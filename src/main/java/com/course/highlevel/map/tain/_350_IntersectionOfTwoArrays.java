package com.course.highlevel.map.tain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author freed
 * @Description: 数组交集 允许有重复元素
 * @Date 2022-08-08
 */
public class _350_IntersectionOfTwoArrays {


    //双指针
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[i]) {
                i++;
            } else {
                j++;
            }
        }


        return Arrays.copyOfRange(nums1, 0, k);
    }

    //计数法
    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums1) {
            int count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, count + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num2 : nums2) {
            if (hashMap.containsKey(num2)) {
                if (hashMap.get(num2) > 0) {
                    list.add(num2);
                    hashMap.put(num2, hashMap.get(num2) - 1);
                }
            }
        }


        int[] ans = new int[list.size()];
        int k = 0;
        for (Integer num : list) {
            ans[k++] = num;
        }
        return ans;
    }
}
