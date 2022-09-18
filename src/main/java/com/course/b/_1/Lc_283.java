package com.course.b._1;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-15
 */
public class Lc_283 {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                //交换 fast 和 slow 指向的元素
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }


    public void moveZeroes1(int[] nums) {
        if (nums.length == 0) return;

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                // 去除判断 性能更高 赋值语句比判断语句执行快
//                if (slow != fast) { //减少交换次数
                // 直接使用赋值代替交换
                    nums[slow] = nums[fast];
                    slow++;
//                }
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
