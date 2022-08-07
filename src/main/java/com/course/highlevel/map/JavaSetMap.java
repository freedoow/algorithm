package com.course.highlevel.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-07
 */
public class JavaSetMap {
    public static void main(String[] args) {
        // TreeSet：红黑树，有序的
        // HashSet：hash，链表法，数组 + 链表
        Set<Integer> set = new HashSet<>();

        // TreeMap：红黑树，key 有序的
        // HashMap：hash，链表法，数组 + 链表
        Map<Integer, Integer> map = new HashMap<>();
    }
}
