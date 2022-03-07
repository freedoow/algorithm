package com.course.line.algo.sort.train;

import com.course.line.algo.sort.Sorter;

/**
 * @author freedoow
 * @Description: 颜色计数
 * @Date 2022-02-23
 */
public class _75_SortColors extends Sorter {

    //计数排序
    public static void Sort(int[] nums) {
        //计数
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        //排序
        int k = 0;
        for (int i = 0; i <= 2; i++) {
            int num = count[i];
            for (int j = 0; j <= num; j++) {
                nums[k++] = i;
            }
        }
    }
    // 三路快排
    public static void ThreeSort(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;

        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                Swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 2) {
                Swap(nums, i, two);
                two--;
            }else {
                i++;
            }
        }
    }

}
