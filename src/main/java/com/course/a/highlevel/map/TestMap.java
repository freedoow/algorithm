package com.course.a.highlevel.map;

import com.course.a.util.TestFileReader;

import java.util.ArrayList;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-07
 */
public class TestMap {
    static ArrayList<String> words = TestFileReader.readFile("/Users/freed/code/algo/algorithm/data/test-data.txt");

    private static double testMap(Map<String, Integer> map) {
        long startTime = System.nanoTime();
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.set(word, count + 1);
            } else {
                map.add(word, 1);
            }
        }
        return (System.nanoTime() - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        Map<String, Integer> llMap = new LinkedListMap<>();
        double time1 = testMap(llMap);
        System.out.println("链表实现的 Map 花的时间：" + time1);

        Map<String, Integer> bstMap = new BTSTreeMap<>();
        double time2 = testMap(bstMap);
        System.out.println("BST 实现的 Map 花的时间：" + time2);

        Map<String, Integer> hashMap = new HashMap<>();
        double time3 = testMap(hashMap);
        System.out.println("Hash 实现的 Map 花的时间：" + time3);
    }


}
