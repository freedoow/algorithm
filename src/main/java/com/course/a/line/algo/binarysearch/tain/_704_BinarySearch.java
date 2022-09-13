package com.course.a.line.algo.binarysearch.tain;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-03-05
 */
public class _704_BinarySearch {

    public static int search1(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == data[mid]) {
                return mid;
            } else if (target > data[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (data[left] == target) return left;
        return -1;
    }


    public static int search2(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > data[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (data[left] == target) return left;
        return -1;
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(_704_BinarySearch.search2(data, 3));
    }
}
