package com.course.line.linkedlist;

/**
 * @author whb
 */
public class LinkedList<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 头节点
    private Node head;
    // 长度
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查询指定索引的节点的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("get fail, index fail");
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.e;
    }

    /**
     * 查询第一个值
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 查询最后一个值
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }
}
