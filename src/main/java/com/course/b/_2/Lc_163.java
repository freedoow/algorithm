package com.course.b._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-21
 */
public class Lc_163 {
    public List<String> findMissRanges(int[] nums, int lower, int upper) {
        ArrayList<String> resList = new ArrayList<>();
        long prev =  lower - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev + 2) {
                resList.add(String.valueOf(prev + 1));
            } else if (nums[i] > prev + 2) {
                resList.add((prev + 1) + ">" + (nums[i] - 1));
            }
            prev = nums[i];
        }
        if (upper == prev + 1) {
            resList.add(String.valueOf(prev + 1));
        } else if (upper > prev + 1) {
            resList.add((prev + 1) + "->" + upper);
        }
        return resList;
    }
}
