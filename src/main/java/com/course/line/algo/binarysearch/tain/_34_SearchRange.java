package com.course.line.algo.binarysearch.tain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-03-05
 */
public class _34_SearchRange {

    public static Integer[] searchRange(int[] data, int target) {

        int firstValue = searchFirstValue1(data, target);
        if (firstValue == -1) return new Integer[]{-1, -1};
        int lastValue = searchLastValue1(data, target);
        return new Integer[]{firstValue, lastValue};
    }


    private static int searchLastValue(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target >= data[mid]) {
                if (mid == data.length - 1 || target < data[mid + 1]) return mid;
                else left = mid + 1;
            } else if (target < data[mid]) {
                right = mid - 1;
            }

        }
        if (target == data[left]) return left;
        return -1;
    }


    private static int searchLastValue1(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (target < data[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }

        }
        if (target == data[left]) return left;
        return -1;
    }

    private static int searchFirstValue(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= data[mid]) {
                if (mid == 0 || target > data[mid - 1]) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (target == data[left]) return left;
        return -1;
    }

    private static int searchFirstValue1(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > data[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (target == data[left]) return left;
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 3, 5, 6, 8, 9, 10};
        Integer[] ints = _34_SearchRange.searchRange(data, 3);
        System.out.println(Arrays.asList(ints));
    }
}
