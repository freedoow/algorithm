package com.course.highlevel.heap;


import com.course.line.array.ArrayList;

/**
 * @author whb
 * @Description: 大顶堆
 * @Date 2022-07-17
 */
public class MaxHeap<E extends Comparable> {
    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 返回一个索引所表示的元素的父节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not have parent");
        }
        return (index - 1) / 2;
    }

    // 返回最后一个非叶子节点的索引值
    private int lastNonLeafIndex() {
        // 最后一个叶子节点的索引
        int lastLeafIndex = data.getSize() - 1;
        // 返回最后一个叶子节点的父节点的索引值就是最后一个非叶子节点的索引
        return parent(lastLeafIndex);
    }

    //新增
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //数组索引 index 元素上浮
    private void siftUp(int index) {
        E e = data.get(index);

        while (index > 0) {
            E parentNode = data.get(parent(index));

            if (e.compareTo(parentNode) <= 0) break;

            //交换
            data.set(index, parentNode);

            //更新插入的元素节点为父亲节点的索引
            index = parent(index);
        }
        data.set(index, e);
    }

}
