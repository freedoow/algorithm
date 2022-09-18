package com.course.b._1;

/**
 * @author freed
 * @Description: 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022-09-18
 */
public class Lc_80 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length < 2) return 0;

        int slow = 2; // 已处理区域的最后一个位置下一个位置
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length < 2) return 0;

        int slow = 1; //已处理区域的最后一个位置
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Lc_80.removeDuplicates1(nums));
    }
}
