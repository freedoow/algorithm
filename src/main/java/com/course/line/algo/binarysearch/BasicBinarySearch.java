package com.course.line.algo.binarysearch;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-03-01
 */
public class BasicBinarySearch {

    public static Boolean contains(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return true;
            } else if (data[mid] < target) {
                left = mid + 1;
                continue;
            } else { // data[mid] > target
                right = mid - 1;
                continue;

            }
        }
        return false;
    }

    public static Boolean contains2(int[] data, int target) {
        return contains(data, target, 0, data.length);
    }

    public static Boolean contains(int[] data, int target, int left, int right) {
        if (left >= right) return false;
        int mid = left + (right - left) / 2;
        if (data[mid] == target) {
            return true;
        } else if (data[mid] < target) {
            return contains(data, target, mid + 1, right);
        } else {
            return contains(data, target, left, mid - 1);
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(BasicBinarySearch.contains2(data, 10));
    }
}
