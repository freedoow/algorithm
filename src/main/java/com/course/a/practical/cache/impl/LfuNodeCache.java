package com.course.a.practical.cache.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-12
 */

class Node {
    int key, val, count;
    Node next, prev;

    Node() {
    }

    Node(int key, int val, int count) {
        this.key = key;
        this.val = val;
        this.count = count;
    }
}

class DoubleLinkedList {
    private Node head;
    private Node tail;

    DoubleLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        return node;
    }

    // 将 node 拼接到表尾
    void add(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    Node popFirst() {
        if (isEmpty()) return null;
        return remove(this.head.next);
    }

    boolean isEmpty() {
        return this.head.next == this.tail;
    }
}

public class LfuNodeCache {
    //每个key 对于value 的映射
    private Map<Integer, Node> keyToNode;
    //每个count对应所有的的keys(按照最近使用的顺序组织)
    private Map<Integer, DoubleLinkedList> usedCountToKeys;

    private int capacity;

    //记录整个缓存中所有key中使用最小的次数
    private int minUsedCount;

    public LfuNodeCache() {
        keyToNode = new HashMap<>();
        usedCountToKeys = new HashMap<>();

        this.capacity = capacity;
        minUsedCount = 0;
    }

    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node == null) return 0;

        //需要维护 key 对应的 count
        int usedCount = node.count;
        //1、key 的集合中删除掉这个key
        usedCountToKeys.get(usedCount).remove(node);
        node.count = usedCount + 1;


        //2、更新最小使用次数
        // 如果当前的 usedCount 等于最小次数，
        // 并且当前的 usedCount 没有的 key，那么将最小次数加 1
        if (usedCount == minUsedCount && usedCountToKeys.get(usedCount).isEmpty()) minUsedCount++;

        //3、key记录到 usedCount+1 集合中
        putUsedCount(node, usedCount + 1);

        return node.val;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.val = value;
            keyToNode.put(key, node);
            get(key);
            return;
        }
        if (keyToNode.size() == capacity) {
            //删除最少使用的key
            Node removeNode = usedCountToKeys.get(minUsedCount).popFirst();
            usedCountToKeys.get(minUsedCount).remove(removeNode);
            keyToNode.remove(removeNode);
        }

        //新增
        Node node = new Node(key, value, 1);

        //将key记录到minUsedCount中的集合
        minUsedCount = 1;
        putUsedCount(node, minUsedCount);

    }

    private void putUsedCount(Node node, int count) {
        if (!usedCountToKeys.containsKey(count)) usedCountToKeys.put(count, new DoubleLinkedList());
        usedCountToKeys.get(count).add(node);
    }
}