package com.course.practical.cache.impl;

import com.course.practical.cache.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-12
 */
public class LocalCache<K, V> implements Cache<K, V> {
    private Map<K, V> cache;

    public LocalCache() {
        cache = new HashMap<>();
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }
}