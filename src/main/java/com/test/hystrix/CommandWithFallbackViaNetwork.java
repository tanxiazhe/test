package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class CommandWithFallbackViaNetwork extends HystrixCommand<String> {

  private final int id;

  public CommandWithFallbackViaNetwork(int id) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueCommand")));
    this.id = id;
  }

  @Override
  protected String run() throws Exception {
    throw new RuntimeException("force failure for example");
  }

  @Override
  protected String getFallback() {
    return new FallbackViaNetwork(id).execute();
  }
  public static void main(String[] args) {
    CommandWithFallbackViaNetwork commandWithFallbackViaNetwork = new CommandWithFallbackViaNetwork(2);
    String result = commandWithFallbackViaNetwork.execute();
    System.out.println(result);
    System.out.println("MainThread:" + Thread.currentThread().getName());
  }
  private static class FallbackViaNetwork extends HystrixCommand<String> {

    private final int id;

    private FallbackViaNetwork(int id) {
      super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX"))
          .andCommandKey(HystrixCommandKey.Factory.asKey("getvalueFallbackCommand"))
          .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("remoteserviceX Fallback")));
      this.id = id;
    }

    @Override
    protected String run() throws Exception {
      return "Hello " + id + " thread: " + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
      return  null;
    }
  }
}
