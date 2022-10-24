package com.concurrent.connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class ConnectionDriver {
  public static Connection createConnection() {
    return (Connection) Proxy.newProxyInstance(ConnectionPool.class.getClassLoader(),new Class<?>[]{Connection.class}, new ConnectionHandler());
  }

  static class ConnectionHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if("commit".equals(method.getName())){
        TimeUnit.MILLISECONDS.sleep(100);
      }
      return null;
    }
  }
}
