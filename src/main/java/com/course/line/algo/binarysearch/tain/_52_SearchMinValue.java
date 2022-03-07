package com.course.line.algo.binarysearch.tain;

/**
 * @author freedoow
 * @Description: 旋转数组最小值（可重复）
 * @Date 2022-03-06
 */
public class _52_SearchMinValue {

    public static int search(int[] data) {
        if (data == null || data.length == 0) return -1;
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] > data[right]) {
                left = mid + 1;
            } else if (data[mid] < data[right]) { // 防止最右为最小值
                right = mid;
            } else {// 重复 -1
                right--;
            }
        }
        return data[left];
    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 8, 9, 10, 18, 2, 3, 4};
        System.out.println(_52_SearchMinValue.search(data));
    }
}
