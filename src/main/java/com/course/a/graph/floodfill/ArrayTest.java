package com.course.a.graph.floodfill;

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
     *
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

    /**
     * 一维转二维
     * <p>
     * 行  int i = index / cols;
     * 列  int j = index % cols;
     *
     * @param arr
     * @param rows
     * @param cols
     * @return
     */
    public static int[][] oneDimConvertTwoDim(int[] arr, int rows, int cols) {
        int[][] res = new int[rows][cols];
        for (int index = 0; index < arr.length; index++) {
            int i = index / cols;
            int j = index % cols;

            res[i][j] = arr[index];
        }
        return res;

    }

    //四连通
    public static void printAdj(int[][] arr, int i, int j) {
        System.out.println("上：" + arr[i - 1][j]); // {-1,0}
        System.out.println("下：" + arr[i + 1][j]); // {1,0}
        System.out.println("左：" + arr[i][j - 1]); // {0,-1}
        System.out.println("有：" + arr[i][j + 1]); // {0,1}
    }

    //四联通优化
    public static void printAdjOptimize(int[][] arr, int i, int j) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int row = i + direction[0];
            int col = j + direction[1];
            System.out.println("优化四连通：" + arr[row][col]);
        }
    }

    public static void print8AdjOptimize(int[][] arr, int i, int j) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        for (int[] direction : directions) {
            int row = i + direction[0];
            int col = j + direction[1];
            //索引合法效验
            if (row < rows && col < cols && row >= 0 && col >= 0) System.out.println("8连通：" + arr[row][col]);
        }
    }


    public static void main(String[] args) {
        int[][] data = {
                {4, 2, 5, 11},
                {3, 7, 1, 9},
                {32, 22, 13, 8}
        };

        System.out.println("二维数组转一维：" + Arrays.toString(twoDimConvertOneDim(data)));


        int[] arr = {4, 2, 5, 11, 3, 7, 1, 9, 32, 22, 13, 8};
        for (int[] a : oneDimConvertTwoDim(arr, 3, 4)) {
            System.out.println("一维数组转二维：" + Arrays.toString(a));
        }

        printAdj(data, 1, 2);
        printAdjOptimize(data, 1, 2);
        print8AdjOptimize(data, 0, 0);
    }
}
