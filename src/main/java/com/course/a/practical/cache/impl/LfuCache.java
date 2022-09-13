package com.course.a.practical.cache.impl;

import com.course.a.practical.cache.Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-12
 */
public class LfuCache<K, V> implements Cache<K, V> {
    //每个key 对于value 的映射
    private Map<K, V> cache;
    //每个key使用的次数
    private Map<K, Integer> keyToUsedCount;
    //每个count对应所有的的keys(按照最近使用的顺序组织)
    private Map<Integer, LinkedHashSet<K>> usedCountToKeys;

    private int capacity;

    //记录整个缓存中所有key中使用最小的次数
    private int minUsedCount;

    public LfuCache() {
        cache = new HashMap<>();
        keyToUsedCount = new HashMap<>();
        usedCountToKeys = new HashMap<>();

        this.capacity = capacity;
        minUsedCount = 0;
    }

    @Override
    public V get(K key) {
        V value = cache.get(key);
        if (value == null) return null;

        //需要维护 key 对应的 count
        Integer usedCount = keyToUsedCount.get(key);
        //1、key 的集合中删除掉这个key
        usedCountToKeys.get(usedCount).remove(key);
        keyToUsedCount.put(key, usedCount + 1);


        //2、更新最小使用次数
        // 如果当前的 usedCount 等于最小次数，
        // 并且当前的 usedCount 没有的 key，那么将最小次数加 1
        if (usedCount == minUsedCount && usedCountToKeys.get(usedCount).size() == 0) minUsedCount++;

        //3、key记录到 usedCount+1 集合中
        putUsedCount(key, usedCount + 1);

        return value;
    }

    @Override
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }
        if (cache.size() == capacity) {
            //删除最少使用的key
            K removeKey = usedCountToKeys.get(minUsedCount).iterator().next();
            usedCountToKeys.get(minUsedCount).remove(removeKey);
            cache.remove(removeKey);
            keyToUsedCount.remove(removeKey);
        }

        //新增
        cache.put(key, value);
        keyToUsedCount.put(key, 1);

        //将key记录到minUsedCount中的集合
        minUsedCount = 1;
        putUsedCount(key, minUsedCount);

    }

    private void putUsedCount(K key, int count) {
        if (!usedCountToKeys.containsKey(count)) usedCountToKeys.put(count, new LinkedHashSet<>());
        usedCountToKeys.get(count).add(key);
    }
}