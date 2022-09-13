package com.course.a.highlevel.map;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-01
 */
public interface Map<K, V> {
    int size();

    boolean isEmpty();

    void add(K key, V value);

    V remove(K key);

    void set(K key, V newValue);

    V get(K key);

    boolean containsKey(K key);


}
