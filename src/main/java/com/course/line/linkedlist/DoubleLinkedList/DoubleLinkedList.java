package com.course.line.linkedlist.DoubleLinkedList;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-05
 */
public class DoubleLinkedList<E> {
    private class Node {
        E e;
        Node prev;
        Node next;

        public Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(null, e, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node first;
    private Node last;
    private int size;

    public DoubleLinkedList() {
        first = last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

