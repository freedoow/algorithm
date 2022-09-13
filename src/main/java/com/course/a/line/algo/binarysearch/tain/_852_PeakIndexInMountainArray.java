package com.course.a.line.algo.binarysearch.tain;

/**
 * @author freedoow
 * @Description: 山脉数组
 * 1. nums.length >= 3
 * 2.存在0<i < nums.length- 1,使得nums[0] < nums[1]< .. < nums[i- 1] < nums[i] > nums[i+ 1]> .. > nums[nums.length - 1]
 * 以上索引i的值就是山脉数组nums的山顶的索引值，写一个函数，输入就是山脉数组,返回该山脉数组的山顶索引。
 * 示例1 :
 * 输入: [0,2,3,5, 6,3,2, 1]
 * 输出: 4
 * 因为数组的最高点是元素6,而6所在索引是4
 * 示例2 :
 * 输入: [0,2, 1, 0]
 * 输出: 1
 * 因为数组的最高点是元素2,而2所在索引是1
 * 提示:
 * ●3 <= nums.length <= 10000
 * ●0 <= nums[] <= 10^6
 * ●nums 就是输入的山脉数组
 * @Date 2022-03-06
 */
public class _852_PeakIndexInMountainArray {

    public static int search(int[] data) {
        if (data == null && data.length == 0) return -1;
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] > data[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 8, 9, 10, 18, 2, 1, 0};
        System.out.println(_852_PeakIndexInMountainArray.search(data));
    }
}
