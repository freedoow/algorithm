package com.course.a.highlevel.map.tain._170_;

import java.util.HashMap;

/**
 * @author freed
 * @Description: 设计数据结构-两数之和-哈希
 * @Date 2022-08-10
 */
public class TwoSum2 {
    private HashMap<Integer, Integer> nums;


    public TwoSum2() {
        nums = new HashMap<>();
    }

    //添加一个元素
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
    }

    //两数之和是否等于value 二分查找
    public boolean find(int value) {
        for (Integer num : nums.keySet()) {
            int target = value - num;
            // 4+4 = 8
            if (target == num && nums.get(target) - 1 > 1) return true;
            if (target != num && nums.containsKey(target)) return true;
        }
        return false;
    }
}
