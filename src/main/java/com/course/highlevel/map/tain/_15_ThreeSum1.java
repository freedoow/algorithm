package com.course.highlevel.map.tain;

import java.util.*;

/**
 * @author freed
 * @Description: 三数之和
 * @Date 2022-08-10
 */
public class _15_ThreeSum1 {

    public List<List<Integer>> treeNum1(int[] nums) {
        if (nums == null || nums.length <= 3) return new ArrayList<>(0);

        Arrays.sort(nums); //  Collections.sort(integers);
        List<List<Integer>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> integers = Arrays.asList(nums[i], nums[left], nums[right]);
                    String key = integers.toString();
                    if (!map.containsKey(key)) {
                        list.add(integers);
                        map.put(key, key);
                    }
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    //暴力解法
    public List<List<Integer>> treeNum(int[] nums) {
        if (nums == null || nums.length <= 3) return new ArrayList<>(0);

        Arrays.sort(nums); //  Collections.sort(integers);
        List<List<Integer>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
                        String key = integers.toString();
                        if (!map.containsKey(key)) {
                            list.add(integers);
                            map.put(key, key);
                        }
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new _15_ThreeSum1().treeNum1(nums));
    }
}
