package com.course.b._2;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-21
 */
public class Lc_665 {
    public boolean checkPossibility(int[] nums) {

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) return false;

                if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }
}
