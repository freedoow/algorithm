package com.course.a.line.algo.sort;

import java.util.ArrayList;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-24
 */
public class IntegerQuickSorter extends Sorter {

    public static void sort(ArrayList<Integer> data) {
        if (data == null || data.size() < 2) return;
        Integer[] dataArr = data.toArray(new Integer[data.size()]);


        sort(dataArr, 0, dataArr.length - 1);
    }

    private static void sort(Integer[] data, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(data, lo, hi);
        sort(data, lo, j - 1);
        sort(data, j + 1, hi);
    }


    private static int partition(Integer[] data, int lo, int hi) {
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

}
