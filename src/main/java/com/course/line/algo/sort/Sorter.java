package com.course.line.algo.sort;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-16
 */

public class Sorter {

    /**
     * 交换两个索引的值
     *
     * @param data
     * @param i
     * @param j
     */
    public static void Swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
