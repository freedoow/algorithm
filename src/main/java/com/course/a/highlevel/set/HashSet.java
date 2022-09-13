package com.course.a.highlevel.set;


/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public class HashSet<E> implements Set<E> {
    private E[] data;
    private int size;

    public HashSet() {
        this.data = (E[]) new Object[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E e) { //O(1)
        int index = hash(e, data.length);
        if (data[index] == null) {
            data[index] = e;
            size++;
            // 扩容2倍
            if (size == data.length) {
                resize(2 & data.length);
            }
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                int newIndex = hash(data[i], newCapacity);
                newData[newIndex] = data[i];
            }
        }
        data = newData;
    }

    @Override
    public void remove(E e) {//O(1)
        int index = hash(e, data.length);
        data[index] = null;
        size--;
    }

    @Override
    public boolean contains(E e) {//O(1)
        int index = hash(e, data.length);

        return data[index] != null;
    }

    //O(1)
    public int hash(E e, int length) {
        return Math.abs(e.hashCode()) % length;
    }

}
