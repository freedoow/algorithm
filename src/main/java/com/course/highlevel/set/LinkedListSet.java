package com.course.highlevel.set;

import com.course.line.linkedlist.LinkedList;

/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> data;

    public LinkedListSet() {
        this.data = new LinkedList<>();
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
        if (!data.contains(e)) data.addFirst(e);
    }

    @Override
    public void remove(E e) {
        data.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    @Override
    public String toString() {
        return "LinkedListSet{" +
                "data=" + data.toString() +
                '}';
    }

    public static void main(String[] args) {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.toString());
    }
}
