package com.course.line.linkedlist;

/**
 * @author freedoow
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
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 头节点(dummy-虚拟假的)
    private Node dummyHead;
    // 长度
    private int size;

    public LinkedList() {
        dummyHead = new Node();
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
        Node curr = dummyHead.next;
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
        if (index < 0 || index > size) throw new IllegalArgumentException("get fail, index fail");
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
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

//        head = new Node(e, head);

        add(0, e);
    }

    /**
     * 添加尾节点
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 添加中间节点
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException("add failed, index must >= 0 and <= size");
//        if (index == 0) addFirst(e);

        Node prev = dummyHead;
//        for (int i = 0; i < index - 1; i++) {
//            prev = prev.next;
//        }
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node addNode = new Node(e);
//        addNode.next = prev.next;
//        prev.next = addNode;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public E removeHead() {
//        if (isEmpty()) return null;
//
//        Node delNode = dummyNode;
//        dummyNode = dummyNode.next;
//        delNode.next = null;
//        size--;
//
//        return delNode.e;
        return remove(0);
    }

    /**
     * 删除指定索引位置的节点
     *
     * @param index 索引
     * @return
     */
    public E remove(int index) {
        // size 节点是空的
        if (index < 0 || index > size) throw new IllegalArgumentException("get fail, index fail");
//        if (index == 0) return removeHead();
        // 找到前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 标记删除的节点
        Node delNode = prev.next;
        // 前一个节点next指向删除节点的next
        prev.next = delNode.next;
        delNode.next = null;

        size--;

        return delNode.e;
    }

    /**
     * 判断链表是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node curr = dummyHead.next;
        while (curr.next != null) {
            if (curr.e.equals(e)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null) {
            sb.append(curr + "->");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
