package com.course.a.highlevel.heap;

import java.util.Arrays;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-18
 */
public class MaxHeapSort {
    public static void sort(Integer[] data) {
        MaxHeap maxHeap = new MaxHeap(data);

        Integer[] temp = new Integer[data.length];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            temp[i] = (Integer) maxHeap.removeMax();
            i++;
        }
        // 3. 拷贝
        for (int j = 0; j < data.length; j++) {
            data[j] = temp[j];
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{15, 17, 19, 13, 22, 16, 28, 30, 42, 66};
        MaxHeapSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
