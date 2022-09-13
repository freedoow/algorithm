package com.course.a.line.algo.twopoint;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-06
 */
public class MoveZeroes {

    // 朴素解
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] tmp = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    //双指针（快慢指针）
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] tmp = new int[nums.length];
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            //减少交换次数
            if (slow != fast && nums[fast] != 0) {
                // 交换 fast 和 slow 指向的元素
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;

                slow++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] tmp = new int[nums.length];
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            //减少交换次数
            if (slow != fast && nums[fast] != 0) {
                // 交换 fast 和 slow 指向的元素
                nums[slow] = nums[fast];
                slow++;
            }
        }
        // 剩余给零
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
