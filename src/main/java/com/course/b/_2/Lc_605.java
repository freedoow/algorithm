package com.course.b._2;

/**
 * @author freed
 * @Description:
 *
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date 2022-09-25
 */
public class Lc_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;

        //遍历完 & 花种完了
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 1) { //当前花坛种花 至少i+2的地方才能种花
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) { //i没有种花 且最后一个花坛
                n--;
                i += 2;
            } else {// i没有种花 i+1种了
                i += 3;
            }
        }
        return n <= 0;
    }
}
