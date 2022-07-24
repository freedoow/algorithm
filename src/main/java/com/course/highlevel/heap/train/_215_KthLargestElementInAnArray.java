package com.course.highlevel.heap.train;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author freedoow
 * @Description: 快排&顶堆
 * @Date 2022-07-24
 */
public class _215_KthLargestElementInAnArray {
    private Random random = new Random(System.currentTimeMillis());


    // 优先队列
    public int findKthLargest(int[] num, int k) {

        int len = num.length;
        if (k < len - k) {
            //小顶堆
            PriorityQueue<Integer> pg = new PriorityQueue<>(k);

            for (int i = 0; i < num.length; i++) {
                pg.add(num[i]);
            }


            for (int i = k; i < num.length; i++) {
                if (num[i] > pg.peek()) {
                    pg.remove();
                    pg.add(num[i]);
                }
            }
            return pg.peek();
        } else {
            int capacity = len - k + 1;
            //大顶堆
            PriorityQueue<Integer> pg = new PriorityQueue<>(capacity, (a, b) -> b - a);

            for (int i = 0; i < capacity; i++) {
                pg.add(num[i]);
            }

            for (int i = k; i < capacity; i++) {
                if (num[i] > pg.peek()) {
                    pg.remove();
                    pg.add(num[i]);
                }
            }

            return pg.peek();
        }

    }

    public int findKthLargest1(int[] num, int k) {
        int len = num.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;

        while (true) {
            int index = partition(num, left, right);

            if (target == index) {
                return num[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = right - 1;
            }
        }
    }

    private int partition(int[] data, int lo, int hi) {
        //以防数据是有序的
        if (hi > lo) {
            int randomIndex = lo + 1 + random.nextInt(hi - lo);
            swap(data, hi, randomIndex);
        }

        int pivot = data[hi];
        int less = lo;
        int great = lo;

        for (; great <= hi - 1; great++) {
            if (data[great] < pivot) {
                swap(data, less, great);
                less++;
            }
        }

        swap(data, less, hi);
        return less;
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
