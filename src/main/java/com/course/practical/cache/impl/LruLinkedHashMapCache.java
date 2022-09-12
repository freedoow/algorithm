package com.course.practical.cache.impl;

import com.course.practical.cache.Cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-12
 */
public class LruLinkedHashMapCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LruLinkedHashMapCache(int capacity, int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (size() > capacity) return true;
        else return false;
    }


    public static void main(String[] args) {
        LruLinkedHashMapCache<Integer, Integer> cache = new LruLinkedHashMapCache<>(3, 3, 0.75F);
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
