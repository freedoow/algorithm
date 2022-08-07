package com.course.highlevel.map;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-01
 */
public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(K key, V value) {
        this(key, value, null);
    }

    public Node() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
