package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-02-16
 */
public class ThreeWayQuickSorter extends Sorter {

    private static class PartitionSegment {
        public int less;
        public int great;

        public PartitionSegment(int less, int great) {
            this.less = less;
            this.great = great;
        }
    }


    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }


    private static void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
//        PartitionSegment partitionSegment = partition(data, lo, hi);
//
//        int less = partitionSegment.less;
//        int great = partitionSegment.great;

        // 分区
        int pivot = data[hi];

        int less = lo;
        int great = hi;

        int i = lo;

        while (i <= great) {
            if (data[i] < pivot) {
                Swap(data, i, less);
                less++;
                i++;
            } else if (data[i] > pivot) {
                Swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }

        sort(data, lo, less - 1);
        sort(data, great + 1, hi);
    }

    private static PartitionSegment partition(int[] data, int lo, int hi) {
        int pivot = data[hi];

        int less = lo;
        int great = hi;

        int i = lo;

        while (i <= great) {
            if (data[i] < pivot) {
                Swap(data, i, less);
                less++;
                i++;
            } else if (data[i] > pivot) {
                Swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }


        return new PartitionSegment(less, great);
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        ThreeWayQuickSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
