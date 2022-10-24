package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class HelloWorldCommand3 extends HystrixCommand<String> {
  private final String name;

  protected HelloWorldCommand3(String name) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloworld group"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            .withExecutionIsolationStrategy(
                HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
    this.name = name;
  }

  @Override
  protected String run() throws Exception {
    return "HystrixThread:" + Thread.currentThread().getName();
  }

  public static void main(String[] args) {
    HelloWorldCommand3 helloWorldCommand3 = new HelloWorldCommand3("semaphore");
    String result = helloWorldCommand3.execute();
    System.out.println(result);
    System.out.println("MainThread:" + Thread.currentThread().getName());
  }
}
