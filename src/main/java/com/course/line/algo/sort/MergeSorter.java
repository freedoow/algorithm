package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-23
 */
public class MergeSorter {
    public static void sort(int[] data) {
        if (data == null || data.length < 2) return;
        int[] temp = new int[data.length];

        sort(data, 0, data.length - 1, temp);
    }

    private static void sort(int[] data, int left, int right, int[] temp) {
        //终止条件
        if (left == right) return;
        //子问题求解
        int mid = (left + right) / 2;

        sort(data, left, mid, temp);
        sort(data, mid + 1, right, temp);
        //合并
        merge(data, left, mid, right, temp);
    }


    private static void merge(int[] data, int left, int mid, int right, int[] temp) {

        int tempPos = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[tempPos] = data[i];
                i++;
            } else {
                temp[tempPos] = data[j];
                j++;
            }
            tempPos++;

        }
        //左边还有元素
        while (i <= mid) {
            temp[tempPos++] = data[i++];
        }
        //左边还有元素
        while (j <= right) {
            temp[tempPos++] = data[j++];
        }

        int num = right - left + 1;
        for (int k = left; k < num; k++) {
            data[left++] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        MergeSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
