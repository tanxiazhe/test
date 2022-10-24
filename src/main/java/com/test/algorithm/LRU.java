package com.test.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
  public LRU(){
    this(0);
  }
  public  final int  cacheSize;

  public Map getMap() {
    return map;
  }

  public void setMap(Map map) {
    this.map = map;
  }

  public Map map;

  public  LRU(int capacity){
    this.cacheSize = capacity;
    map = new LinkedHashMap(capacity, 0.75f, true){
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return map.size() > cacheSize;
      }
    };
  }

  public static void main(String[] args) {
    LRU lru = new LRU(5);
    Map<Integer,Integer> map = lru.getMap();
    map.put(1,1);
    map.put(2,1);
    map.put(3,1);
    map.put(4,1);
    map.put(5,1);
    map.put(6,1);

    for (Map.Entry<Integer,Integer> en : map.entrySet()){
      System.out.println(en.getKey()+" : "+en.getValue());
    }



  }
}
