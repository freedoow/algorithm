package com.course.b._2;

import java.util.Arrays;

/**
 * @author freed
 * @Description:
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Date 2022-09-25
 */
public class Lc_135 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2};

        System.out.println(Lc_135.candy(nums));
    }

    //两个数组 优化
    public static int candy(int[] ratings) {
        int n = ratings.length;

        int[] left2right = new int[n];
        Arrays.fill(left2right, 1);

        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }

        int resSum = 0;
        int right = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            resSum += Math.max(left2right[i], right);
        }

        return resSum;
    }

    //两个数组 bug
    public static int candy1(int[] ratings) {
        int n = ratings.length;

        int[] left2right = new int[n];
        Arrays.fill(left2right, 1);

        int[] right2left = new int[n];
        Arrays.fill(right2left, 1);

        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        int resSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
            resSum += Math.max(left2right[i], right2left[i]);
        }

        return resSum;
    }


    //暴力解
    public static int candy2(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        boolean hasChange = true;
        while (hasChange) {
            hasChange = false;
            for (int i = 0; i < n; i++) {
                //不是最后一个小孩 且当前小孩分大于右边的  且糖果小于等于右边的
                if (i != n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChange = true;
                }

                //不是第一个小孩 且当前小孩分大于左边的  且糖果小于等于左边的
                if (i != 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChange = true;
                }
            }
        }


        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
