package com.course.a.practical.cache.impl;

import com.course.a.practical.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-12
 */
public class LruCache<K, V> implements Cache<K, V> {

    private class Node {
        K key;
        V value;
        Node next;
        Node prev;
    }

    private Map<K, Node> cache;
    private Queue<K> queue;
    private int capacity;

    private Node head;
    private Node tail;


    public LruCache(int capacity) {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) return null;
        //查询的V移动到表头
        moveNodeToHead(node);
        return node.value;
    }

    private void moveNodeToHead(Node node) {
        //1、删除节点node
        removeNode(node);
        //2、删除节点node 添加到表头
        addNodeToHead(node);
    }

    private void addNodeToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    /**
     * *******
     *
     * @param node
     */
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = null;
        node.next = null;
    }

    @Override
    public void put(K key, V value) {
        Node node = cache.get(key);

        if (node == null) {
            //、判断缓存容量的大小
            if (cache.size() == capacity) {
                Node delNode = removeTailNode();
                cache.remove(delNode.key);
            }
            //2、创建新节点
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            //3、维护链表和缓存
            cache.put(key, newNode);
            addNodeToHead(newNode);
        } else {
            node.value = value;
            //有的话，放入头
            moveNodeToHead(node);
        }
    }

    private Node removeTailNode() {
        Node delNode = tail.prev;
        removeNode(delNode);
        return delNode;
    }

    public static void main(String[] args) {
        LruCache<Integer, Integer> cache = new LruCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
        cache.put(4, 5);
        System.out.println(cache.get(4));
        cache.put(5, 6);
        System.out.println(cache.get(2));
    }
}
