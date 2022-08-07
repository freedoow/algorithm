package com.course.highlevel.set;


import java.util.Arrays;

/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public class HashSetLinkedList<E> implements Set<E> {

    private Node[] data;
    private int size;


    // 装载因子
    private double loadFactor = 0.25;


    public HashSetLinkedList() {
        this.data = new Node[10];
        this.size = 0;
    }


    public HashSetLinkedList(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
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
    public void add(E e) { // Min O(1) Max O(n)
        int index = hash(e, data.length);
        if (data[index] == null) {
            data[index] = new Node(e);
        } else {
            Node prev = null;
            Node curr = data[index];
            while (curr != null) {
                if (e.equals(curr.e)) {
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = new Node(e);
        }
        size++;
        if (size >= data.length * loadFactor) {
            resize(2 * data.length);
        }
    }

    private void resize(int newCapacity) {
        Node[] newData =  new Node[newCapacity];
        for (int i = 0; i < data.length; i++) {
            Node<E> curr = data[i];
            while (curr != null) {
                E e = curr.e;

                int newIndex = hash(e, data.length);
                Node head = newData[newIndex];
                newData[newIndex] = new Node(e);
                if (head != null) {
                    newData[newIndex].next = head;
                }
                curr = curr.next;
            }
        }
        data = newData;
    }

    @Override
    public void remove(E e) {//O(1)
        int index = hash(e, data.length);
        if (data[index] == null) {
            return;
        }
        Node prev = null;
        Node curr = data[index];
        while (curr != null) {
            if (e.equals(curr.e)) {
                if (prev == null) {
                    data[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;
                size--;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    @Override
    public boolean contains(E e) {
        int index = hash(e, data.length);
        if (data[index] == null) return false;
        Node curr = data[index];
        while (curr != null) {
            if (e.equals(curr.e)) return true;
            curr = curr.next;
        }
        return false;
    }

    //O(1)
    public int hash(E e, int length) {
        return Math.abs(e.hashCode()) % length;
    }

    @Override
    public String toString() {
        return "HashSetLinkedList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args) {
        HashSetLinkedList<Object> set = new HashSetLinkedList<>();
        set.add(3);
        set.add(60);
        set.add(44);
        set.add(46);
        set.add(50);
        set.add(60);
        System.out.println(set.toString());
    }

}
