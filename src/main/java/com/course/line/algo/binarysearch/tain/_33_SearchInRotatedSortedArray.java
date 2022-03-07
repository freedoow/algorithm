package com.course.line.algo.binarysearch.tain;

/**
 * @author freedoow
 * @Description: 旋转数组
 * 给你一个升序排列的整数数组nums,和一个整数目标值target.
 * 假设按照升序排列的数组在预先未知的某个点上进行了旋转。例如:
 * 数组[0,1,2,4,5,6,7]可能变成了[4,5,6,7,0,1,2]
 * 请你在数组中搜索target:
 * 1.如果数组中存在这个目标值，则返回target在数组中的索引值
 * 2.否则返回-1
 * 示例1:
 * ● 输入: nums = [4,5,6,7,0,1,2]， target= 0
 * ● 输出:4
 * <p>
 * 找到任意有序进行 二分查找找寻
 * @Date 2022-03-06
 */
public class _33_SearchInRotatedSortedArray {

    public static int search(int[] data, int target) {
        if (data == null || data.length == 0) return -1;

        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == data[mid]) return mid;

            if (data[left] > data[mid]) { // 左边有序
                if (target >= data[left] && target < data[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > data[mid] && target <= data[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }


        return -1;
    }
}
