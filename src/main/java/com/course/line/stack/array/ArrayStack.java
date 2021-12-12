package com.course.line.stack.array;

import com.course.line.stack.Stack;

import java.util.NoSuchElementException;

/**
 * @author freedoow
 * @Description: 静态数组数据实现栈
 * @Date 2021-12-12
 */
public class ArrayStack<E> implements Stack<E> {

    private E[] data;
    private int size;


    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        if (size == data.length) throw new RuntimeException("push fail, Stack is full");
        data[size] = e;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("pop fail, Stack is empty");
        E e = data[size - 1];
        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("pop fail, Stack is empty");
        return data[size - 1];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("stack: [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
