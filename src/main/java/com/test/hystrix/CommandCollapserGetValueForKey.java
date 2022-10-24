package com.test.hystrix;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CommandCollapserGetValueForKey
    extends HystrixCollapser<List<String>, String, Integer> {
  private final Integer key;

  public CommandCollapserGetValueForKey(Integer key) {
    this.key = key;
  }

  @Override
  public Integer getRequestArgument() {
    return key;
  }

  @Override
  protected HystrixCommand<List<String>> createCommand(
      Collection<CollapsedRequest<String, Integer>> requests) {
    return new BatchCommand(requests);
  }

  @Override
  protected void mapResponseToRequests(List<String> batchResponse,
      Collection<CollapsedRequest<String, Integer>> requests) {
    int count = 0;
    for (CollapsedRequest<String, Integer> request : requests) {
      request.setResponse(batchResponse.get(count++));
    }
  }

  private class BatchCommand extends HystrixCommand<List<String>> {
    private final Collection<CollapsedRequest<String, Integer>> requests;

    public BatchCommand(Collection<CollapsedRequest<String, Integer>> requests) {
      super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
          .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueForKey")));
      this.requests = requests;
    }

    @Override
    protected List<String> run() throws Exception {
      ArrayList<String> response = new ArrayList<String>();
      for (CollapsedRequest<String, Integer> request : requests) {
        response.add("ValueForKey: " + request.getArgument());
      }
      return response;
    }
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    HystrixRequestContext context = HystrixRequestContext.initializeContext();
    Future<String> f1 = new CommandCollapserGetValueForKey(1).queue();
    Future<String> f2 = new CommandCollapserGetValueForKey(2).queue();
    Future<String> f3 = new CommandCollapserGetValueForKey(3).queue();
    Future<String> f4 = new CommandCollapserGetValueForKey(4).queue();

    System.out.println(f1.get());
    System.out.println(f2.get());
    System.out.println(f3.get());
    System.out.println(f4.get());
    System.out.println(HystrixRequestLog.getCurrentRequest().getExecutedCommands().size());

    HystrixCommand<?> command = HystrixRequestLog.getCurrentRequest().getExecutedCommands()
        .toArray(new HystrixCommand<?>[1])[0];
    System.out.println(command.getCommandKey().name());
    System.out.println(command.getExecutionEvents().toString());

  }
}
