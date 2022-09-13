package com.course.a.highlevel.heap;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-14
 */
public class DataStream2 {
    private MaxHeap<Integer> maxHeap;

    public DataStream2() {
        maxHeap = new MaxHeap<>();
    }

    public void add(int val) {
        maxHeap.add(val);
    }

    public int removeMax() {
        return maxHeap.removeMax();
    }
}

