package com.concurrent.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock {

  private static class  Sync extends AbstractQueuedSynchronizer{
    public  boolean isHeldExclusively(){
      return getState() == 1;
    }

    public boolean tryAccquire(int accquires){
      if(compareAndSetState(0,1)){
        setExclusiveOwnerThread(Thread.currentThread());
        return true;
      }
      return false;
    }

    public  boolean tryRelease(int releases){
      if(getState() ==0)
        throw  new IllegalMonitorStateException();
      setExclusiveOwnerThread(Thread.currentThread());
      setState(0);
      return true;
    }
    Condition newCondition(){
      return new ConditionObject();
    }

  }

  private final Sync sync = new Sync();

  @Override
  public void lock() {
    sync.acquire(1);
  }

  @Override
  public void lockInterruptibly() throws InterruptedException {
   sync.acquireInterruptibly(1);
  }

  @Override
  public boolean tryLock() {
    return  sync.tryAccquire(1);
  }

  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return sync.tryAcquireNanos(1, unit.toNanos(time));
  }

  @Override
  public void unlock() {
    sync.tryRelease(1);
  }

  @Override
  public Condition newCondition() {
    return sync.newCondition();
  }

  public boolean isLocked(){
    return sync.isHeldExclusively();
  }

  public boolean hasQueuedThreads(){
    return sync.hasQueuedThreads();
  }
}
