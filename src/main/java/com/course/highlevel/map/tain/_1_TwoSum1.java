package com.course.highlevel.map.tain;

import java.util.HashMap;

/**
 * @author freed
 * @Description: 一个数组，输入一个目标值，在其数组 找两数之和 等于目标值的索引
 * @Date 2022-08-09
 */
public class _1_TwoSum1 {
    //hash查找 优化
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                Integer index = map.get(target - x);
                return new int[]{index, i};
            }
            map.put(x, i);
        }

        return new int[0];
    }


    //hash查找
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                Integer index = map.get(target - x);
                // i和index  不是同一个元素 同一元素不能被使用两次
                if (i != index) return new int[]{index, i};
            }
        }

        return new int[0];
    }


    //线性查找
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - x) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
