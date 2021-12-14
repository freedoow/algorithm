package com.course.line.queue;

import com.course.line.array.ArrayList;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-14
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> data;

    public ArrayQueue() {
        data = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("Queue：队首 [");
        for (int i = 0; i < getSize(); i++) {
            sb.append(data.get(i));
            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
