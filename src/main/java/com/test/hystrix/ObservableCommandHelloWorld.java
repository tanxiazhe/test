package com.test.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.Iterator;

public class ObservableCommandHelloWorld extends HystrixObservableCommand<String> {
  private final String name;

  protected ObservableCommandHelloWorld(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }

  @Override
  protected Observable<String> construct() {
    return Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> subscriber) {
        try {

          if (!subscriber.isUnsubscribed()) {
            subscriber.onNext("Hello");
            int i = 1 / 0;
            subscriber.onNext(name + " !");
            subscriber.onCompleted();
          }
        } catch (Exception e) {
          subscriber.onError(e);
        }
      }
    }).subscribeOn(Schedulers.io());
  }

  @Override
  protected Observable<String> resumeWithFallback() {
    return Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> subscriber) {
        try {
          if (!subscriber.isUnsubscribed()) {
            subscriber.onNext("failed");
            subscriber.onNext("help");
            subscriber.onCompleted();
          }
        } catch (Exception e) {
          subscriber.onError(e);
        }
      }
    }).subscribeOn(Schedulers.io());
  }

  public static void main(String[] args) {
    Observable<String> observable = new ObservableCommandHelloWorld("world").observe();
    Iterator<String> iterable = observable.toBlocking().getIterator();
    while (iterable.hasNext()) {
      System.out.println(iterable.next());
    }

    Observable<String> observable2 = new ObservableCommandHelloWorld("world").toObservable();
    Iterator<String> iterable2 = observable.toBlocking().getIterator();
    while (iterable2.hasNext()) {
      System.out.println(iterable2.next());
    }
  }
}
