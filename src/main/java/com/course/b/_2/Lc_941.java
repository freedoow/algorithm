package com.course.b._2;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-20
 */
public class Lc_941 {

    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // 1、找到最高点
        while (i < n - 1 && arr[i] < arr[i + 1]) i++;

        // 最高点不能是第一个和最后一个元素
        if (i == 0 || i == n - 1) return false;
        // 2、从最高点往后递减
        while (i < n - 1 && arr[i] > arr[i + 1]) i++;

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 2, 1};
        System.out.println(Lc_941.validMountainArray(arr));
    }
}
