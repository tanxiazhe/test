package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Assert;

public class RequestCacheCommand extends HystrixCommand<String> {
  private final int id;

  public RequestCacheCommand(int id) {
    super(HystrixCommandGroupKey.Factory.asKey("RequestCacheCommand"));
    this.id = id;
  }

  @Override
  protected String run() throws Exception {
    System.out.println(Thread.currentThread().getName() + " execute id=" + id);
    return "executed=" + id;
  }

  @Override
  protected String getCacheKey() {
    return String.valueOf(id);
  }

  public static void main(String[] args) {
    HystrixRequestContext context = HystrixRequestContext.initializeContext();
    RequestCacheCommand command2a = new RequestCacheCommand(2);
    RequestCacheCommand command2b = new RequestCacheCommand(2);
    command2a.execute();
    //isResponseFromCache判定是否是在缓存中获取结果
    Assert.assertFalse(command2a.isResponseFromCache);

    command2b.execute();
    //isResponseFromCache判定是否是在缓存中获取结果
    Assert.assertTrue(command2b.isResponseFromCache);

    context.shutdown();

    context = HystrixRequestContext.initializeContext();
    RequestCacheCommand command3b  = new RequestCacheCommand(2);
    command3b.execute();
    Assert.assertFalse(command3b.isResponseFromCache);
    context.shutdown();
  }
}
