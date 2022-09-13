package com.course.a.line.algo.binarysearch;

/**
 * @author freedow
 * @Description:
 * @Date 2022-03-02
 */
public class BinarySearch {

    /**
     * 第一个等于目标元素的下标(重复)
     *
     * @param data
     * @param target
     * @return
     */
    public static int firstEQValue(int[] data, int target) {

        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                if (mid == 0 || data[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (data[mid] < target) {
                left = mid + 1;
            } else { // data[mid] > target
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 第一个大于等于目标元素的下标
     *
     * @param data
     * @param target
     * @return
     */
    public static int firstGQValue(int[] data, int target) {

        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= data[mid]) {
                if (mid == 0 || data[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else { // data[mid] < target
                left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 最后小于等于目标元素的下标
     *
     * @param data
     * @param target
     * @return
     */
    public static int lastLQValue(int[] data, int target) {

        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] <= target) {
                if (mid == 0 || data[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else { //  data[mid] > target
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 4, 4, 5, 5, 6, 7};
        System.out.println(BinarySearch.firstGQValue(data, 5));
    }
}
