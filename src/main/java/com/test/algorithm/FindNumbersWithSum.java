package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindNumbersWithSum {
    public static List<Integer> findNumbersWithSum(int[] array, int sum) {
        List<Integer> list = new ArrayList<>();
        if (array.length < 2) {
            return null;
        }
        int l = 0, h = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[l] + array[h] == sum) {
                list.add(array[l]);
                list.add(array[h]);
                return list;
            } else if (array[l] + array[h] < sum) {
                l++;
            } else {
                h--;
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums.length < 3) {
            return res;
        }
        int left = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int l, h;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            h = nums.length - 1;
            left = 0 - nums[i];

            if (!set.contains(nums[i])) {
                set.add(nums[i]);

                System.out.format("i=%d, nums[i]=%d, left=%d\n", l,nums[i], left);
                HashSet<Integer> set2 = new HashSet<>();
                while (l < h) {
                    System.out.format("         l=%d,  h=%d\n", l, h);
                    if (nums[l] + nums[h] == left) {

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[h]);


                        if (!set2.contains(nums[l])) {
                            set2.add(nums[l]);
                            res.add(list);
                            System.out.println("        "+list);
                        }
                        l++;
                        h--;
                    } else if (nums[l] + nums[h] > left) {
                        h--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //        System.out.println(FindNumbersWithSum.findNumbersWithSum(new int[]{1, 2, 3, 5,
        //        9, 10}, 10));
        //        FindNumbersWithSum.threeSum(new int[]{1, -2, -3,0, 5, 9, 10, -10});
        //        FindNumbersWithSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        //        FindNumbersWithSum.threeSum(new int[]{0,0,0});
        FindNumbersWithSum.threeSum(new int[]{3,0,-2,-1,1,2});
    }
}
