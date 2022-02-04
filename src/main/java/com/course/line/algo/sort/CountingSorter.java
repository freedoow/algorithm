package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-02-04
 */
public class CountingSorter {

    public void sort(int[] data) {
        // 1、找到数组中的最大值,初始化计算器
        int max = data[0];
        int min = data[0];
        for (int i = 0; i < data.length; i++) {
            max = Math.max(max, data[i]);
            min = Math.min(min, data[i]);
        }
        int count[] = new int[max - min + 1];


        //2、计数累加
        for (int i = 0; i < data.length; i++) {
            count[data[i] - min]++;
        }

        //计数累加  设置1不数组越界
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        //计算每个元素在排序数组的位置
        int[] output = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            int j = data[i];
            int k = count[j - min] - 1;
            output[k] = data[i];
            count[j - min]--;
        }


        //复制数组
        for (int i = 0; i < output.length; i++) {
            data[i] = output[i];
        }
    }

    public static void main(String[] args) {
        CountingSorter sorter = new CountingSorter();

        int[] data = {4, 2, -9, 8, 3, 3, 1};
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
