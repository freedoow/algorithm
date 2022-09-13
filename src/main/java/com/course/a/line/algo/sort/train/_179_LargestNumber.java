package com.course.a.line.algo.sort.train;

import com.course.a.line.algo.sort.Sorter;

/**
 * @author freedoow
 * @Description: 最大值
 * @Date 2022-02-15
 */
public class _179_LargestNumber extends Sorter {

    public static String sort(int[] data) {
        sort(data, 0, data.length - 1);
        StringBuffer sb = new StringBuffer();
        for (int i : data) {
            sb.append(i);
        }
        return sb.toString();
    }


    private static void sort(int[] data, int lo, int hi) {

        if (lo >= hi) return;
        // 分区
        int pivot = data[hi];

        int less = lo;
        int great = hi;

        int i = lo;

        while (i <= great) {
            String xy = data[i] + "" + pivot;
            String yx = pivot + "" + data[i];
            if (xy.compareTo(yx) > 0) {
                Swap(data, i, less);
                less++;
                i++;
            } else if (xy.compareTo(yx) < 0) {
                Swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }

        sort(data, lo, less - 1);
        sort(data, great + 1, hi);
    }


    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42};
        String sort = _179_LargestNumber.sort(data);

        System.out.println(sort);
    }
}
