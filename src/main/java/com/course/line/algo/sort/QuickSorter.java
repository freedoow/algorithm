package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-24
 */
public class QuickSorter extends Sorter {

    public static void sort(int[] data) {
        if (data == null || data.length < 2) return;
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(data, lo, hi);
        sort(data, lo, j - 1);
        sort(data, j + 1, hi);
    }


    private static int partition(int[] data, int lo, int hi) {
        int pivot = data[hi];
        int less = lo;
        int great = lo;

        for (; great <= hi - 1; great++) {
            if (data[great] < pivot) {
                Swap(data, less, great);
                less++;
            }
        }

        Swap(data, less, hi);
        return less;
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        QuickSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
