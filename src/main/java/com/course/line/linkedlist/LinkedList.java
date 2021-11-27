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
     * @param index 索引
     * @return E
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
     * @return E
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 查询最后一个值
     *
     * @return E
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改指定索引的值
     *
     * @param index 索引
     * @param e     修改的值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("get fail, index fail");
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = head.next;
        }
        curr.e = e;
    }

    /**
     * 添加头节点
     *
     * @param e 新增节点需要存储的数据
     */
    public void addFirst(E e) {
//        Node addNode = new Node(e) ;
//        addNode.next = head;
//        head = addNode

        head = new Node(e, head);
        size++;
    }

    /**
     * 添加尾节点
     *
     * @param e
     */
    public void addLast(E e) {
        add(size - 1, e);
    }

    /**
     * 添加中间节点
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("get fail, index fail");
        if (index == 0) addFirst(e);

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = head.next;
        }
//        Node addNode = new Node(e);
//        addNode.next = prev.next;
//        prev.next = addNode;
        prev.next = new Node(e, prev.next);

        size++;
    }

}
