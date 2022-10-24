package com.test.algorithm;

import java.util.ArrayList;

public class MinStack {
  private ArrayList<Integer> stack = new ArrayList<>();
  public void push(Integer integer){
    stack.add(integer);
  }
  public Integer pop(){
    if(stack.size() >0){
      Integer res = stack.get(stack.size());
      stack.remove(res);
      return res;
    }
    return null;
  }
  public Integer top(){
    if(stack.size() >0){
      Integer res = stack.get(stack.size());
      stack.remove(res);
      return res;
    }
    return null;
  }
  public Integer min(){
    Integer min = stack.get(0);
    for (int i : stack){
      if(min > i){
        min = i;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(1);
    stack.push(6);
    stack.push(3);
    stack.push(1);
    stack.push(8);
    System.out.println(stack.min());
  }
}
