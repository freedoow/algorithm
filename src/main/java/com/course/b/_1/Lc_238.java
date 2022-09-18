package com.course.b._1;

/**
 * @author freed
 * @Description:
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date 2022-09-18
 */
public class Lc_238 {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        // leftProDucts[i] 表示索引i 左侧所有元素的乘积
        int[] leftProDucts = new int[size];
        leftProDucts[0] = 1;
        for (int i = 0; i < size; i++) {
            leftProDucts[i] = leftProDucts[i - 1] * nums[i - 1];
        }

        // rightProDucts[i] 表示索引i 右侧所有元素的乘积
        int[] rightProDucts = new int[size];
        rightProDucts[size - 1] = 1;
        for (int i = 0; i < size; i++) {
            rightProDucts[i] = rightProDucts[i + 1] * nums[i + 1];
        }

        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = leftProDucts[i] * rightProDucts[i];
        }
        return res;
    }

    public int[] productExceptSelfOpt(int[] nums) {
        int size = nums.length;

        int[] res = new int[size];

        //左边乘积 放在res
        res[0] = 1;
        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = size - 1; i >= 0; i++) {
            res[i] = res[i] * rightProduct;
            //更新右边
            rightProduct = rightProduct * nums[i];
        }
        return res;
    }
}
