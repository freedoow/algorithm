package com.course.highlevel.set;


import java.util.Arrays;

/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public class HashSetOpenAddressing<E> implements Set<E> {

    private Item[] items;
    private int size;

    // 装载因子
    private double loadFactor = 0.75;
    // 用于记录有多少标记删除的元素
    private int deleteCount;


    public HashSetOpenAddressing() {
        this.items = (Item[]) new Item[10];
        this.size = 0;
        this.deleteCount = 0;
    }

    public HashSetOpenAddressing(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
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
    public void add(E e) { //O(1)
        int index = hash(e, items.length);

        // addIndex 表示元素 e 需要插入的索引位置
        int addIndex = index;
        // isFirst 用于辅助找到元素 e 插入的位置
        boolean isFirst = true;

        while (items[index] != null && !e.equals(items[index].data)) {
            // 找到第一个等于 null 或者删除的元素，并记录赋值给 addIndex
            if ((items[index] == null || items[index].isDeleted) && isFirst) {
                addIndex = index;
                isFirst = false;
            }

            index++;
            index = index % items.length;
        }
        // 说明已经存在 e，则直接返回
        if (items[index] != null && !items[index].isDeleted) return;

        // 这个时候的 addIndex 对应的元素要么是 null ，要么是已经删除的元素
        // 如果 addIndex 对应的元素是标记为删除的元素，那么直接被覆盖了，标记为删除的元素个数减少 1
        if (items[addIndex] != null && items[addIndex].isDeleted) deleteCount--;
        items[addIndex] = new Item(e);
        size++;

        if (size >= items.length * loadFactor) {
            resize(2 * items.length);
        }
    }

    private void resize(int newCapacity) {
        Item[] newData = (Item[]) new Object[newCapacity];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                int newIndex = hash((E) items[i].data, newCapacity);
                newData[newIndex] = items[i];
            }
        }
        items = newData;
    }

    @Override
    public void remove(E e) {//O(1)
        int index = hash(e, items.length);

        //找到e 、元素为null的索引
        while (items[index] == null && !e.equals(items[index].data)) {
            index++;
            index = index % items.length;
        }
        if (items[index] != null) {
            items[index].isDeleted = true;
            size--;
            deleteCount++;
        }

        // 如果标记为删除的元素太多的话，我们进行 resize，清除标记为删除的元素
        // TODO：这里可能会产生时间复杂度震荡
        if (deleteCount + size >= items.length * loadFactor) {
            resize(items.length);
        }
    }

    @Override
    public boolean contains(E e) {//O(1)
        int index = hash(e, items.length);

        return items[index] != null && !items[index].isDeleted;
    }

    //O(1)
    public int hash(E e, int length) {
        return Math.abs(e.hashCode()) % length;
    }

    @Override
    public String toString() {
        return "HashSetOpenAddressing{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    public static void main(String[] args) {
        HashSetOpenAddressing<Object> set = new HashSetOpenAddressing<>();
        set.add(3);
        set.add(60);
        set.add(44);
        System.out.println(set.toString());
    }

}
