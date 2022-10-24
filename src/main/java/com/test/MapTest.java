package com.test;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> codes = new HashMap<String, String>();

		codes.put(null, null);
		codes.put(null,null);
		codes.put("C1", "Acathan");

		for(String key:codes.keySet()){
			System.out.println(key);
			System.out.println(codes.get(key));
		}
		System.out.println(codes.get("2"));


	}

	public int[] sortByBits(int[] arr) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for(int i: arr){
			int temp = i;
			int num =0;
			while(i !=0){
				if(i/2 ==1) num++;
				i=i/2;
			}
			List<Integer> orDefault = map.getOrDefault(num, new ArrayList<>());
			orDefault.add(temp);
			map.put(num,orDefault);
		}
		int[] ans = new int[arr.length];
		int i=0;
		Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			List<Integer> a = iterator.next().getValue();
			for(int kk: a){
				ans[i++] = kk;
			}
		}
		return ans;

		return ans;

	}
}
