package com.course.highlevel.set;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-30
 */
public class Node<E> {
     E e;
     Node next;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e) {
        this(e, null);
    }

    public Node() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                ", next=" + next +
                '}';
    }
}
