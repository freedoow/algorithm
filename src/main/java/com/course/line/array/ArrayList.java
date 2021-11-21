package com.course.line.array;

/**
 * @author freedoow
 */
public class ArrayList {
    private int[] data;
    private int capacity;
    private int size;

    public ArrayList(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public ArrayList() {
        this(15);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * 指定位置插入元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed, Array is full");
        }
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("add failed,  require index > 0 && index < size");
        }
        // 最后一个到index 移动一位
        for (int i = index - 1; i >= index; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 头插入 
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 尾插入
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

}
