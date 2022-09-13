package com.course.a.practical.cache;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public interface Cache<K, V> {
    V get(K key);

    void put(K key, V value);
}
