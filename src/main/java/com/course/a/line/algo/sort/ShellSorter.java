package com.course.a.line.algo.sort;

import java.util.ArrayList;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-18
 */
public class ShellSorter extends Sorter {

    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        //1 计算递增序列
        int n = data.length;
        ArrayList<Integer> list = new ArrayList<>();
        int k = 1;
        int h;
        do {
            h = ((int) Math.pow(3, k) - 1) / 2;
            if (h > n / 3) break;
            list.add(h); // 1 4 13 40 121..
            k++;
        } while (h <= n / 3);

        //2 希尔排序
        for (k = data.length; k >= 0; k--) {
            h = list.get(k); // 最大间隔
            // 将数组变为h 有序 插入排序
            for (int i = h; i < n; i++) {  // 插入的次数
                for (int j = i; j >= h; j = j - h) {
                    if (data[j] < data[j - h]) {
                        Swap(data, j, j - h);
                    } else {
                        break;
                    }
                }

            }
        }
    }
}