package com.course.highlevel.map;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-07
 */
public class HashMap<K, V> implements Map<K, V> {
    private Node<K, V>[] data;
    private int size;
    private double loadFactor;


    public HashMap(int initCapacity, double loadFactor) {
        this.data = new Node[initCapacity];
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public HashMap(int initCapacity) {
        this(initCapacity, 0.75);
    }

    public HashMap(double loadFactor) {
        this(10, loadFactor);
    }

    public HashMap() {
        this(10, 0.75);

    }

    // 计算key索引
    private int hash(K key, int length) {
        return Math.abs(key.hashCode()) % length;
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
        //1、找到插入node节点
        int index = hash(key, data.length);
        Node<K, V> curr = getNode(key);
        //  不存在新增 存在更新
        if (curr == null) {
            data[index] = new Node(key, value, data[index]);
            size++;
            //扩容
            if (size >= data.length * loadFactor) {
                resize(2 * data.length);
            }
        } else {
            curr.value = value;
        }
    }

    private void resize(int newCapacity) {
        Node[] newData = new Node[newCapacity];
        for (int i = 0; i < data.length; i++) {
            Node<K, V> curr = data[i];
            while (curr != null) {
                K key = curr.key;
                int newIndex = hash(key, newCapacity);
                Node<K, V> head = newData[newIndex];
                newData[newIndex] = new Node(key, curr.value);
                if (head != null) {
                    newData[newIndex].next = head;
                }
                curr = curr.next;
            }
        }
        data = newData;
    }

    @Override
    public V remove(K key) {
        int index = hash(key, data.length);
        if (data[index] == null) return null;
        Node<K, V> prev = data[index];
        Node<K, V> curr = data[index];
        while (curr != null) {
            if (key.equals(curr.key)) {
                if (prev == null) {
                    data[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node<K, V> curr = getNode(key);
        if (curr != null) curr.value = newValue;
        else throw new RuntimeException("不存在");
    }

    @Override
    public V get(K key) {
        Node<K, V> curr = getNode(key);
        return curr == null ? null : curr.value;
    }

    private Node<K, V> getNode(K key) {
        int index = hash(key, data.length);
        Node<K, V> curr = data[index];
        while (curr != null) {
            if (key.equals(curr.key)) break;
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> curr = getNode(key);
        return curr != null;
    }

    public void put(V playerId, V i) {
    }
}
