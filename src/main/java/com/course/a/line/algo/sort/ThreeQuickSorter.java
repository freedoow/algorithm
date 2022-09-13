package com.course.a.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-24
 */
public class ThreeQuickSorter extends Sorter {
    private static class PartitionSegment {
        private int less;
        private int great;

        public PartitionSegment(int less, int great) {
            this.less = less;
            this.great = great;
        }
    }

    public static void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        sort(data, 0, data.length -1);
    }

    public static void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        PartitionSegment partitionSegment = partition(data, lo, hi);
        sort(data, lo, partitionSegment.less - 1);
        sort(data, partitionSegment.great + 1, hi);

    }

    private static PartitionSegment partition(int[] data, int lo, int hi) {
        int pivot = data[hi];
        int less = lo;
        int great = hi;
        int i = lo;
        while (i < great) {
            if (data[i] < pivot) {
                Swap(data, i, less);
                less++;
                i++;
            } else if (data[i] > great) {
                Swap(data, i, great);
                great--;
            } else if (data[i] > great) {
                i++;
            }
        }


        return new PartitionSegment(less, great);

    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        ThreeQuickSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
