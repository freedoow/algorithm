package com.course.highlevel.heap.train;


import java.util.PriorityQueue;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-07-24
 */
public class _703_KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public _703_KthLargest(int[] num, int k) {
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;
        for (int i = 0; i < num.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(num[i]);
            } else if (minHeap.size() == k && num[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(num[i]);
            }

        }

    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (minHeap.size() == k && val > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(val);
        }
        return minHeap.peek();
    }


}
