package com.course.a.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description: 冒泡
 * @Date 2022-01-16
 */
public class BubbleSorter extends Sorter {

    public static void sort(int[] data) {
        if (data == null || data.length == 1) return;

        for (int round = 1; round <= data.length; round++) { // 控制冒泡轮次
            int compareTimes = data.length - round;
            boolean hasSwap = false;
            for (int i = 0; i < compareTimes; i++) {  // 控制冒泡
                if (data[i] > data[i + 1]) {
                    Swap(data, i, i + 1);
                    i++;
                    hasSwap = true;
                }
            }
            if (!hasSwap) break;
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{31, 12, 42, 35, 67, 89};

        BubbleSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }
}
