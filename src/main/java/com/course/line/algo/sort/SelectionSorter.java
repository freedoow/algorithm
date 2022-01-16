package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description: 选择
 * @Date 2022-01-16
 */
public class SelectionSorter extends Sorter{
    public static void sort(int[] data) {
        if (data == null || data.length == 1) return;

        for (int i = 0; i < data.length; i++) { //控制选择排序的次数
            int minIndex = i;  // 下标向前移动
            for (int j = i + 1; j < data.length; j++) { // 选择最小值的索引
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            Swap(data, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        SelectionSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }

}
