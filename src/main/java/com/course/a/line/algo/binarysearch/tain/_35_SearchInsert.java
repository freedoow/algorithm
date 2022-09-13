package com.course.a.line.algo.binarysearch.tain;

/**
 * @author freedoow
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 输入 [1,3,4,5] , 5
 * 输出 2
 * 输入 [1,3,4,5], 2
 * 输出 1
 * @Date 2022-03-05
 */
public class _35_SearchInsert {

    public static int search(int[] data, int target) {
        if (data == null) return -1;
        if (data.length == 0) return -1;
        if (target > data[data.length - 1]) return data.length;

        int left = 0;
        int right = data.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > data[mid]) {
                left = mid + 1;
            } else {
                right = mid;

            }
        }

        return left;
    }


    public static int search1(int[] data, int target) {
        if (data == null) return -1;
        if (data.length == 0) return -1;
        if (target > data[data.length - 1]) return data.length;

        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= data[mid]) {
                if (mid == 0 || target > data[mid - 1]) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }

        return -1;
    }
}
