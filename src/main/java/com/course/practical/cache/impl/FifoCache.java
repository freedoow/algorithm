package com.course.practical.cache.impl;

import com.course.practical.cache.Cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class FifoCache<K, V> implements Cache<K, V> {
    private Map<K, V> cache;
    private Queue<K> queue;
    private int capacity;

    public FifoCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.queue = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        V oldValue = cache.get(key);
        if (oldValue == null) {
            if (queue.size() == capacity) {
                K oldKey = queue.poll();
                cache.remove(oldKey);
            }
            queue.offer(key);
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        FifoCache<Integer, Integer> cache = new FifoCache<>(3);
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
