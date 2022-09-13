package com.course.a.highlevel.heap.train;


import java.util.PriorityQueue;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-07-30
 */
public class _295_FindMedianFromDataStream {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public _295_FindMedianFromDataStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    //O(logn)
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }
    //O(1)
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }
}
