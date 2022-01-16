package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description: 插入
 * @Date 2022-01-16
 */
public class InsertionSorter extends Sorter {


    public static void sort(int[] data) {

        if (data == null || data.length == 1) return;

        for (int i = 1; i < data.length; i++) {  // 插入的次数
            int temp = data[i];
            int j;
            for (j = i; j > 0; j--) {
                if (temp < data[j - 1]) {
                    data[j] = data[j - 1];
                } else {
                    break;
                }
            }
            data[i] = temp;
        }

    }

    public static void sort1(int[] data) {

        if (data == null || data.length == 1) return;

        for (int i = 1; i < data.length; i++) {  // 插入的次数
            for (int j = i; j > 0; j--) {

                if (data[j] < data[j - 1]) {
                    Swap(data, j, j - 1);
                } else {
                    break;
                }

            }
        }

    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        InsertionSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
