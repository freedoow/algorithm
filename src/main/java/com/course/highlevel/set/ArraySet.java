package com.course.highlevel.set;

import com.course.line.array.ArrayList;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-07-30
 */
public class ArraySet<E> implements Set<E> {

    private ArrayList<E> data;

    public ArraySet() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E e) {
        if (!data.contains(e)) data.addLast(e);
    }

    @Override
    public void remove(E e) {
        if (!data.isEmpty()) data.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    @Override
    public String toString() {
        return "ArraySet{" +
                "data=" + data.toString() +
                '}';
    }

    public static void main(String[] args) {
        ArraySet<Integer> set = new ArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.toString());
    }
}
