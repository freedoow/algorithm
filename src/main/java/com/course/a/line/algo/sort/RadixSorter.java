package com.course.a.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description: 基数排序
 * @Date 2022-02-08
 */
public class RadixSorter {


    public static void sort(int[] data) {
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            max = Math.max(max, data[i]);
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(data, exp);
        }
    }

    // 计数排序
    private static void countSort(int[] data, int exp) {
        int[] count = new int[10];
        for (int i = 0; i < data.length; i++) {
            // 个位数  (4512/ 1) % 10
            // 十位数  (4512 / 10) % 10
            // 百位数  (4512 / 100) % 10
            int digit = (data[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            int digit = (data[i] / exp) % 10;
            int k = count[digit] - 1;
            output[k] = data[i];
            count[digit]--;
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = output[i];
        }

    }

    public static void main(String[] args) {
        int[] data = new int[]{4512, 4213, 19233, 2165, 1141};
        RadixSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
