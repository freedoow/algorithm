package com.course.b._1;

/**
 * @author freed
 * @Description:
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/running-sum-of-1d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date 2022-09-18
 */
public class Lc_1480 {
    // 暴力解
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += sum;
            }
            prefixSum[i] =sum;
        }
        return prefixSum;
    }

    // 消除重复
    public int[] runningSum1(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] =nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i];
        }
        return prefixSum;
    }
}
