package com.course.a.line.algo.binarysearch.tain;

/**
 * @author freedoow
 * @Description: 山脉数组中查找目标值
 * 3 * log(n)
 * @Date 2022-03-06
 */
public class _1095_SearchMinIndexMountain {

    public static int search(int[] data, int target) {
        if (data == null && data.length == 0) return -1;
        int left = 0;
        int right = data.length - 1;

        int topValue = _852_PeakIndexInMountainArray.search(data);


        return Math.min(search(data, left, topValue, target), search(data, topValue, right, target));
    }

    private static int search(int[] data, int left, int right, int target) {
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (target > data[mid]) {
                left = mid + 1;
            } else if (target < data[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 2, 3, 18, 3, 2, 1};
        System.out.println(_1095_SearchMinIndexMountain.search(data, 2));
    }
}
