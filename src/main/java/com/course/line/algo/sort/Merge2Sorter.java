package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-23
 */
public class Merge2Sorter {
    public static void sort(int[] data) {
        if (data == null || data.length < 2) return;
        int[] temp = new int[data.length];

        sort(data, 0, data.length - 1, temp);
        //重新赋值
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    private static void sort(int[] data, int left, int right, int[] temp) {
        //终止条件
        if (left == right) return;
        //分解子问题
        int mid = (left + right) / 2;
        sort(data, left, mid, temp);
        sort(data, mid + 1, right, temp);
        //合并
        merge(data, left, mid, right, temp);
    }


    private static void merge(int[] data, int left, int mid, int right, int[] temp) {
        int i = left;
        int temPos = 0;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[temPos] = data[i];
                i++;
            } else {
                temp[temPos] = data[j];
                j++;
            }
            temPos++;
        }
        //左边还有元素
        while (i <= mid) {
            temp[temPos++] = data[i++];
        }
        //左边还有元素
        while (j <= right) {
            temp[temPos++] = data[j++];
        }

        //内部赋值
        int num = right - left + 1;
        for (int k = left; k < num; k++) {
            data[left++] = temp[k];
        }

    }


    public static void main(String[] args) {
        int[] data = new int[]{32, 31, 42, 29, 67, 89};
        Merge2Sorter.sort(data);

        System.out.println(Arrays.toString(data));
    }


}
