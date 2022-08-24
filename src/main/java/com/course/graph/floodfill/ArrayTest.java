package com.course.graph.floodfill;

import java.util.Arrays;

/**
 * @author frrd
 * @Description:
 * @Date 2022-08-24
 */
public class ArrayTest {

    /**
     * 二维转一维
     * 一维索引公式：
     * i * cols + j
     * i 元素的行索引
     * j 元素的列索引
     * clos 二维数据列数
     * @param arr
     * @return
     */
    public static int[] twoDimConvertOneDim(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[] res = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                res[index] = arr[i][j];
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[][] data = {
                {4, 2, 5, 11},
                {3, 7, 1, 9},
                {32, 22, 13, 8}
        };
        
         System.out.println(Arrays.toString(twoDimConvertOneDim(data)));

        /*int[] arr = {4, 2, 5, 11, 3, 7, 1, 9, 32, 22, 13, 8};
        for (int[] a : oneDimConvertTwoDim(arr, 3, 4)) {
            System.out.println(Arrays.toString(a));
        }*/

//        printAdj(data, 0, 0);
    }
}
