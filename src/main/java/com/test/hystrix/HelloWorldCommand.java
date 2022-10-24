package com.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HelloWorldCommand extends HystrixCommand<String> {

  private final String name;

  public HelloWorldCommand(String name) {
    //最少配置:指定命令组名(CommandGroup)
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }

  @Override
  protected String run() throws Exception {
    // 依赖逻辑封装在run()方法中
    return "Hello " + name + " thread: " + Thread.currentThread().getName();
  }

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException {

    HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");
    //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
    //每个Command对象只能调用一次,不可以重复调用,
    //重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.
    String result = helloWorldCommand.execute();
    System.out.println(" result = "+result);

    helloWorldCommand = new HelloWorldCommand("Asynchronous-hystrix");
    //异步调用,可自由控制获取结果时机,
    Future<String> future = helloWorldCommand.queue();
    //get操作不能超过command定义的超时时间,默认:1秒
    result = future.get(100, TimeUnit.MILLISECONDS);
    System.out.println("result = "+ result);
    System.out.println("mainThread="+ Thread.currentThread().getName());

    //注册观察者事件拦截
    Observable<String> fs = new HelloWorldCommand("world").observe();

    //注册结果回调事件
    fs.subscribe(new Action1<String>() {
      @Override
      public void call(String result) {
        //执行结果处理,result 为HelloWorldCommand返回的结果
        //用户对结果做二次处理.
        System.out.println("result="+ result);
      }
    });
    //注册完整执行生命周期事件
    fs.subscribe(new Observer<String>() {
      @Override
      public void onCompleted() {
        // onNext/onError完成之后最后回调
        System.out.println("execute onCompleted");
      }

      @Override
      public void onError(Throwable throwable) {
        // 当产生异常时回调
        System.out.println("onError " + throwable.getMessage());
        throwable.printStackTrace();
      }

      @Override
      public void onNext(String s) {
        // 获取结果后回调
        System.out.println("onNext: " + s);
      }
    });

  }
}
