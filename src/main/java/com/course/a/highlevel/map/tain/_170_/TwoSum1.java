package com.course.a.highlevel.map.tain._170_;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author freed
 * @Description: 设计数据结构-两数之和-二分
 * @Date 2022-08-10
 */
public class TwoSum1 {
    private ArrayList<Integer> nums;


    public TwoSum1() {
        nums = new ArrayList<>();
    }

    //添加一个元素
    public void add(int number) {
        nums.add(number);
        Collections.sort(nums);

    }

    //两数之和是否等于value
    public boolean find(int value) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == value) {
                return true;
            } else if (sum > value) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
