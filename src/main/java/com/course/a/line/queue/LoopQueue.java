package com.course.a.line.queue;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-14
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int head;

    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        head = tail = 0;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
//        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == head) {
            // 扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;

    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    /**
     * 获得当前队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(10 % 5);
    }

    @Override
    public E dequeue() {
        E res = data[head];
        data[head] = null;
        size--;
        head = (head + 1) % data.length;
        if (size == getCapacity() /4){
            resize(getCapacity() /2);
        }
        return res;
    }

    @Override
    public E getFront() {
        return data[head];
    }
}
