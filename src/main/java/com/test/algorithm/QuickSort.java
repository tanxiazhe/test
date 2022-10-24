package com.test.algorithm;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {
	public static void main(String[] args) {
//		int nums[]= new int[]{49,14,38,74,96,65,8,49,55,27,96,74,96};
//		int nums[] = new int[]{3, 2, 1, 5, 6, 99, 99, 789, 4};
//		int nums[] = new int[]{3, 2, 1, 5, 6, 4};
//		System.out.println(findKthLargest(nums, 2));
//		System.out.println(thirdMax(nums));
		int p[][] = new int[][]{{5, 5}, {6, 7}, {3, 6}};
//		System.out.println(numberOfWeakCharacters(p));

	}

	public static int numberOfWeakCharacters(int[][] properties) {
		Arrays.sort(properties, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : y[0] - x[0]));
		int max = properties[0][1];
		int c = 0;
		for (int i = 1; i < properties.length; i++) {
			System.out.println("max=" + max);
			System.out.println("properties[i][1]=" + properties[i][1]);
			if (properties[i][1] > max) {
				c++;
			}
			max = Math.max(max, properties[i][1]);
		}

		return c;
	}


	public void printQueue(int[][] properties) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
			System.out.println(x[0] + ", " + y[0]);
			System.out.println(x[1] + ", " + y[1]);
			return (Integer.compare(x[0], y[0]) == 1)
					&&
					(Integer.compare(x[1], y[1]) == 1)
					? 1 : 0;
		});

		for (int[] i : properties) {
			if (!queue.contains(i)) {
				queue.add(i);
			}
		}
		Iterator<int[]> iterator = queue.iterator();
		while (iterator.hasNext()) {
			int[] current = iterator.next();
			System.out.println(Arrays.toString(current));
		}

	}

	public int numberOfWeakCharacters2(int[][] properties) {
		Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		int max = Integer.MIN_VALUE;
		int res = 0;
		for (int i = properties.length - 1; i >= 0; i--) {
			if (properties[i][1] < max)
				res++;
			max = Math.max(properties[i][1], max);
		}

		return res;
	}


	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
		for (int i = 0; i < nums.length; i++) {
			q.add(nums[i]);
		}
		Integer[] a = q.toArray(new Integer[0]);
		System.out.println(Arrays.toString(a));
		if (q.size() < 3) {
			Integer[] a2 = (Integer[]) q.toArray();
			System.out.println(Arrays.toString(a2));
			return a[0];
		}
		return q.peek();
	}

	public static int findKthLargest(int[] nums, int k) {
		if (k < 0) return 0;
		int i = nums.length - 1;
		int j = i - 1;
		quickSort(nums, 0, nums.length - 1);
		if (k > nums.length) return nums[nums.length - 1];
		int s = 0;
		while (i > 0) {
			if (nums[i] > nums[j]) {
				s++;
				System.out.println(s);
				System.out.println(i);

			}
			i--;
			j = i - 1;
			if (s == k) {
				break;
			}

		}
		return nums[i + 1];
	}

	public static void quickSort(int[] nums, int low, int high) {

		System.out.println(Arrays.toString(nums));
		int mid = 0;
		if (low < high) {
			mid = quickSort1(nums, low, high);
			System.out.println(mid);
			quickSort(nums, low, mid - 1);
			quickSort(nums, mid + 1, high);
		}
	}

	public static int quickSort1(int[] nums, int low, int high) {
		int pivotkey = nums[low];
		while (low < high) {
			System.out.println("nums[" + low + "]=" + nums[low] + ",nums[" + high + "]=" + nums[high] + ", nums[" + pivotkey + "]" + pivotkey);
			while (low < high && nums[high] >= pivotkey) {
				high--;
				System.out.print("high =" + high + ", ");
			}
			nums[low] = nums[high];
			System.out.println(Arrays.toString(nums));
			System.out.println(pivotkey);
			while (low < high && nums[low] <= pivotkey) {
				low++;
				System.out.print("low =" + low + ", ");
			}
			nums[high] = nums[low];
			System.out.println(Arrays.toString(nums));
		}
		nums[low] = pivotkey;
		return low;
	}
}
