package com.test.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {
	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();


		int nums[] = new int[]{-1, 0, 1, 2, -1, -4};
//		List<Integer> a = (List<Integer>) IntStream.of(nums).collect(ArrayList::new);
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
//		System.out.println(Arrays.toString(res.toArray(new Integer[res.size()])));
//		int nums[] = new int[]{};
//		threeSum2(nums);
	}

	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		Set<Integer> set1 = new HashSet<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		Set<Integer> set2 = new HashSet<>();
		List<List<Integer>> res= new ArrayList<>();
		for(int num: nums1){
			map1.put(num,0);
		}
		for(int num: nums2){
			map2.put(num,0);
		}

		for(int num: nums2){
			if(!map1.keySet().contains(num)){
				set1.add(num);
			}
		}

		res.add(set1.stream().collect(Collectors.toList()));

		for(int num: nums1){
			if(!map2.keySet().contains(num)){
				set2.add(num);
			}
		}

		res.add(set2.stream().collect(Collectors.toList()));

		return res;

	}
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		int l,h;
		int sum ;
		for(int i=0; i< nums.length-2; i++){
			l = i+1;
			h = nums.length-1;
			System.out.println("l="+l+", h="+h);
			while(l<h){
				sum = nums[l]+nums[h]+nums[i];
				System.out.println(", sum="+sum);
				if(sum == 0){
					List<Integer> triple = new ArrayList();
					triple.add(nums[i]);
					triple.add(nums[l]);
					triple.add(nums[h]);

					if(!res.contains(triple)){
						res.add(triple);
					}
					l++;
					h--;
				}
				else if(sum > 0){

					h--;
					System.out.println(", h="+h);
				}else{
					l++;
					System.out.println(", l="+l);
				}

			}

		}
		System.out.println("-----");
		for(List<Integer> r: res)
			System.out.println(r);
		return res;

	}
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList();

		list.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
//				System.out.println(list);
				list.remove((Integer) nums[i]);
				list.remove((Integer) nums[j]);
				System.out.println("nums["+i+"]="+ nums[i]+", nums["+j+"]="+nums[j]+", after : "+list);
				if (list.contains((nums[i] + nums[j]) * -1)) {
					List<Integer> triple = new ArrayList();
					triple.add(nums[i]);
					triple.add(nums[j]);
					triple.add((nums[i] + nums[j]) * -1);
					Collections.sort(triple);
					if (!res.contains(triple)) {
					System.out.println("triple: "+triple);

						res.add(triple);
					}

				}
				list.add((Integer) nums[i]);
				list.add((Integer) nums[j]);
			}

		}
		System.out.println("-----");
		for(List<Integer> r: res)
		System.out.println(r);
		return res;

	}

}
