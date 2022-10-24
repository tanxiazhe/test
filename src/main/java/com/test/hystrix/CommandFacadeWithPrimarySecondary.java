package com.test.hystrix;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CommandFacadeWithPrimarySecondary extends HystrixCommand<String> {
  private final static DynamicBooleanProperty usePrimary =
      DynamicPropertyFactory.getInstance().getBooleanProperty("primarySecondary.usePrimary", true);

  private final int id;

  public CommandFacadeWithPrimarySecondary(int id) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("SystemX"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("PrimarySecondaryCommand"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            .withExecutionIsolationStrategy(
                HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
    this.id = id;
  }

  @Override
  protected String run() throws Exception {
    if(usePrimary.get()){
      return new PrimaryCommand(id).execute();
    }else {
      return new SecondaryCommand(id).execute();
    }
  }

  @Override
  protected String getFallback() {
    return "static-fallback-"+id;
  }

  @Override
  protected String getCacheKey() {
    return String.valueOf(id);
  }

  private class PrimaryCommand extends HystrixCommand<String>{
    private  final int id;
    public PrimaryCommand(int id) {
      super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("SystemX"))
                  .andCommandKey(HystrixCommandKey.Factory.asKey("PrimaryCommand"))
                  .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("PrimaryCommand"))
                  .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(600))
      );

      this.id = id;
    }

    @Override
    protected String run() throws Exception {
      return "responseFromPrimary-"+id;
    }
  }

  private class SecondaryCommand extends HystrixCommand<String>{
    private  final int id;
    public SecondaryCommand(int id) {
      super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("SystemX"))
          .andCommandKey(HystrixCommandKey.Factory.asKey("SecondaryCommand"))
          .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("SecondaryCommand"))
          .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(100))
      );

      this.id = id;
    }

    @Override
    protected String run() throws Exception {
      return "responseFromSecondary-"+id;
    }
  }

  public static void main(String[] args) {
    HystrixRequestContext context = HystrixRequestContext.initializeContext();
    ConfigurationManager.getConfigInstance().setProperty("primarySecondary.usePrimary",false);
    System.out.println( new  CommandFacadeWithPrimarySecondary(20).execute());

  }

}
