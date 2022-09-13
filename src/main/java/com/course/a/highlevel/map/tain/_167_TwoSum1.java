package com.course.a.highlevel.map.tain;

/**
 * @author freed 有序数组
 * @Description:
 * @Date 2022-08-09
 */
public class _167_TwoSum1 {
    //双指针
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            }else {
                right--;
            }
        }

        return new int[0];
    }


    //二分查找
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int index = binarySearch(nums, i + 1, nums.length - 1, target - x);
            if (index != -1) return new int[]{i + 1, index + 1};
        }
        return new int[0];
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid - 1;
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }
}
