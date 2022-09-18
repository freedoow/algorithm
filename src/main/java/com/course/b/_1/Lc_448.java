package com.course.b._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-13
 */
public class Lc_448 {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) res.add(nums[i + 1]);
        }

        return res;
    }
}
