package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryOrderIdCommand extends HystrixCommand<Integer> {
  private final static Logger logger = LoggerFactory.getLogger(QueryOrderIdCommand.class);

  private OrderServiceProvider orderServiceProvider;

  protected QueryOrderIdCommand(OrderServiceProvider orderServiceProvider) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("orderService"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("qureyByOrderId"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
            .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
            .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
            .withExecutionTimeoutEnabled(true))
        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10))

    );
    this.orderServiceProvider = orderServiceProvider;
  }

  @Override
  protected Integer run() throws Exception {
    return orderServiceProvider.queryByOrderId();
  }

  protected Integer getFallback() {
    return -1;
  }

  static class OrderServiceProvider {
    public Integer queryByOrderId() {
      return 1;
    }
  }

  public static void main(String[] args) {
    OrderServiceProvider orderServiceProvider = new OrderServiceProvider();
    QueryOrderIdCommand queryOrderIdCommand = new QueryOrderIdCommand(orderServiceProvider);
    Integer i = queryOrderIdCommand.execute();
    logger.info("result: {}", i);
  }
}
