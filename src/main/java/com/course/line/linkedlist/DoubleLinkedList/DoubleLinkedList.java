package com.course.line.linkedlist.DoubleLinkedList;

import java.util.NoSuchElementException;

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

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    /**
     * 得到某个索引对应的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index >= 0 | index >= size) throw new IllegalArgumentException("index fail");
        if (index == 0) return first.e;
        if (index == size - 1) return last.e;

        return getNode(index).e;
    }

    /**
     * 得到某个索引下的node
     *
     * @param index
     * @return
     */
    private Node getNode(int index) {
        if (index >= 0 | index >= size) return null;

        Node curr;
        if (index < size / 2) {
            curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = last;
            for (int i = 0; i < size - index - 1; i++) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    /**
     * 修改索引对应的值
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        Node node = getNode(index);
        if (node != null) {
            node.e = e;
        }
        throw new IllegalArgumentException("index fail");
    }

    /**
     * 插入头节点
     *
     * @param e
     */
    public void addFirst(E e) {

        Node newNode = new Node(e);
        if (first == null) {
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     * 插入尾节点
     *
     * @param e
     */
    public void addLast(E e) {
        Node newNode = new Node(e);
        if (last == null) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    /**
     * 任务索引插入值
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index >= 0 | index > size) throw new IllegalArgumentException("index fail");
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node oldNode = getNode(index);
            Node prev = oldNode.prev;

            Node newNode = new Node(prev, e, oldNode);
            oldNode.prev = newNode;
            prev.next = newNode;
        }

        size++;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        E e = first.e;


        Node next = first.next;
        if (next == null) {
            first = null;
            last = null;
        } else {
            first.next = null;
            next.prev = null;
            first = next;
        }

        size--;
        return e;
    }


    /**
     * 删除尾节点
     *
     * @return
     */
    public E removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        E e = first.e;

        Node prev = last.prev;
        if (prev == null) {
            last = null;
            first = null;
        } else {
            last.prev = null;
            prev.next = null;
            last = prev;
        }
        size--;
        return e;
    }

    /**
     * 删除任意节点
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index >= 0 | index >= size) throw new IllegalArgumentException("index fail");
        if (index == 0) {
            return removeFirst();
        } else if (index == size) {
            return removeLast();
        } else {
            Node oldNode = getNode(index);
            Node prev = oldNode.prev;
            Node next = oldNode.next;

            prev.next = next;
            next.prev = prev;

            oldNode.prev = null;
            oldNode.next = null;
            size--;
            return oldNode.e;
        }
    }
}

