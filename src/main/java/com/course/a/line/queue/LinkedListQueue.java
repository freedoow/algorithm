package com.course.a.line.queue;

import com.course.a.line.linkedlist.LinkedList;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-14
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> data;

    public LinkedListQueue() {
        data = new LinkedList();
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
            if(i != getSize() -1){
                sb.append(", ");
            }
        }
        sb.append("] ");
        return sb.toString();
    }
}
