package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HelloWorldCommand2 extends HystrixCommand<String> {

  private final String name;

  public HelloWorldCommand2(String name) {
    super(
        /*CommandGroup是每个命令最少配置的必选参数，在不指定ThreadPoolKey的情况下，字面值用于对不同依赖的线程池/信号区分.*/
        Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloworldGroup"))
            /* HystrixCommandKey工厂定义依赖名称 */
            //每个CommandKey代表一个依赖抽象,相同的依赖要使用相同的CommandKey名称。依赖隔离的根本就是对相同CommandKey的依赖做隔离.
            .andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorld"))
            /* 配置依赖超时时间,500毫秒*/.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            .withExecutionIsolationThreadTimeoutInMilliseconds(1500))
            /* 使用HystrixThreadPoolKey工厂定义线程池名称*/
            //当对同一业务依赖做隔离时使用CommandGroup做区分,但是对同一依赖的不同远程调用如(一个是redis 一个是http),
            //可以使用HystrixThreadPoolKey做隔离区分.虽然在业务上都是相同的组，但是需要在资源上做隔离时，可以使用HystrixThreadPoolKey区分.
            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HelloWorldPool")));

    this.name = name;
  }

  @Override
  protected String getFallback() {
    return "execute failed";
  }

  @Override
  protected String run() throws Exception {
    TimeUnit.MILLISECONDS.sleep(1000);
    return "Hello " + name + " thread: " + Thread.currentThread().getName();
  }

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException {

    HelloWorldCommand2 helloWorldCommand = new HelloWorldCommand2("test-fallback");
    //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
    //每个Command对象只能调用一次,不可以重复调用,
    //重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.
    String result = helloWorldCommand.execute();
    System.out.println(" result = " + result);
    System.out.println("MainThread:"+ Thread.currentThread().getName());
  }
}
