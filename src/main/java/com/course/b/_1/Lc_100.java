package com.course.b._1;

/**
 * @author freed
 * @Description:
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Date 2022-09-18
 */
public class Lc_100 {

    //暴力解
    public int maxArea(int[] height) {
        int m = height.length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                ans = Math.max(area, ans);
            }
        }
        return ans;
    }

    //碰撞指针
    public int maxArea1(int[] height) {
        int res = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
