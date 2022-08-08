package com.course.highlevel.map.tain;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author freed
 * @Description:  数组交集 不允许有重复元素
 * @Date 2022-08-08
 */
public class _349_IntersectionOfTwoArrays {

    //双指针
    public int[] intersection3(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> resultSet = new HashSet<>();
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[i]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[resultSet.size()];
        int k = 0;
        for (Integer num : resultSet) {
            ans[k++] = num;
        }
        return ans;
    }

    //哈希查找法
    public int[] intersection2(int[] nums1, int[] nums2) {

        Arrays.sort(nums2);

        HashSet<Integer> resultSet = new HashSet<>();
        for (int num1 : nums1) {
            resultSet.add(num1);
        }
        for (int num2 : nums2) {
            if (resultSet.contains(nums2)) resultSet.add(num2);
        }

        int[] ans = new int[resultSet.size()];
        int i = 0;
        for (Integer num : resultSet) {
            ans[i++] = num;
        }
        return ans;
    }

    //二分查找
    public int[] intersection1(int[] nums1, int[] nums2) {

        Arrays.sort(nums2);

        HashSet<Integer> resultSet = new HashSet<>();
        for (int num1 : nums1) {
            if (binarySearch(nums2, num1)) resultSet.add(num1);
        }

        int[] ans = new int[resultSet.size()];
        int i = 0;
        for (Integer num : resultSet) {
            ans[i++] = num;
        }
        return ans;
    }

    //二分查找
    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    //线性查找
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) resultSet.add(num1);
            }
        }
        int[] ans = new int[resultSet.size()];
        int i = 0;
        for (Integer num : resultSet) {
            ans[i++] = num;
        }
        return ans;
    }
}
