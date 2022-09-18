package com.course.b._1;

/**
 * @author freed
 * @Description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022-09-18
 */
public class Lc_27 {

    //快慢指针
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //对撞指针

    /**
     * TODO  && nums[right] == val
     * [3,2,2,3]
     * 3
     */
    public static int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //遇到要删除的元素，使用最后一个替换
            //替换元素可能也是要删除 继续判断
            if (nums[left] == val) {
                nums[right] = nums[left];
                right--;
            } else {
                left++;
            }
        }
        return right + 1;
    }
}
