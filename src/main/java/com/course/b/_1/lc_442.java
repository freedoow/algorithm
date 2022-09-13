package com.course.b._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whb
 * @Description:
 * @Date 2022-09-13
 */
public class lc_442 {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) res.add(nums[i + 1]);
        }

        return res;
    }

    public List<Integer> findDuplicatesOpt(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i - 1]) - 1;

            if (nums[index] < 0) res.add(Math.abs(nums[i]));
            else nums[index] = -nums[index];
        }
        return res;
    }

}
