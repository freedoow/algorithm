package com.course.a.highlevel.map;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-01
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private Node<K, V> dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node<K, V>();
        this.size = 0;
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
    public void add(K key, V value) {
        Node curr = dummyHead.next;
        while (curr != null) {
            if (key.equals(curr.key)) break;
            curr = curr.next;
        }
        if (curr == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            //key存在 更新value
            curr.value = value;
        }
    }

    @Override
    public V remove(K key) {

        //1、 找到需要删除的节点的前一个节点
        Node<K, V> prev = this.dummyHead;
        Node<K, V> curr = dummyHead.next;
        while (curr != null) {
            if (key.equals(curr.key)) break;
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
            curr.next = null;
            size--;
            return curr.value;
        }


        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node<K, V> curr = getNode(key);
        if (curr != null) curr.value = newValue;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> curr = dummyHead;
        while (curr != null) {
            if (key.equals(curr.key)) break;
            else curr = curr.next;
        }
        return curr;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> node = getNode(key);
        return node != null;
    }
}
