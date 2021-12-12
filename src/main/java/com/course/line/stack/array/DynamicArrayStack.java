package com.course.line.stack.array;

import com.course.line.array.ArrayList;
import com.course.line.stack.Stack;

/**
 * @author whb
 * @Description: 动态数组实现
 * @Date 2021-12-12
 */
public class DynamicArrayStack<E> implements Stack<E> {
    private ArrayList<E> data;

    public DynamicArrayStack(int capacity) {
        this.data = new ArrayList<>(capacity);
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
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {

        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("stack: [");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if (i != data.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
