package com.course.line.algo.sort;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-24
 */
public class BucketSorter {

    public static void sort(int[] data) {
        if (data == null || data.length <= 2) return;
        int max = data[0];
        // 创建几个空的桶
        for (int i : data) {
            max = Math.max(max, i);
        }
        int bucketNum = max / 10 + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketNum];

        //将所有元素添加进桶
        for (int i = 0; i < data.length; i++) {
            // 算出在那个桶里 TODO
            int index = data[i] / 10;
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(data[i]);
        }

        //对桶排序
        for (ArrayList<Integer> bucket : buckets) {
            if (bucket != null) {
                IntegerQuickSorter.sort(bucket);
            }
        }

        int j = 0;
        //桶中拿出数据
        for (ArrayList<Integer> bucket : buckets) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    data[j] = bucket.get(i);
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 1, 23, 22, 33, 56, 12, 5, 3, 5, 6, 8, 2, 3, 4};
        new BucketSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }


    public void sort1(int[] data) {
        if (data == null || data.length <= 2) return;

        // 创建几个空的桶
        int maxValue = data[0];
        for (int value : data) {
            maxValue = Math.max(maxValue, value);
        }
        int size = maxValue / 10 + 1;
        ArrayList<Integer>[] buckets = new ArrayList[size];

        //将所有元素添加进桶
        for (int i = 0; i < data.length; i++) {
            //算出元素应该在那个桶 ?
            int num = data[i] / 10;
            if (buckets[num] == null) {
                buckets[num] = new ArrayList<>();
            }
            buckets[num].add(data[i]);
        }

        //对桶排序
        for (ArrayList list : buckets) {
            if (list != null && list.size() != 0) {
                IntegerQuickSorter.sort(list);
            }
        }

        //桶中拿出数据
        int index = 0;
        for (ArrayList<Integer> list : buckets) {
            if (list != null && list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    data[index] = list.get(i);
                    index++;
                }
            }
        }

    }
}
