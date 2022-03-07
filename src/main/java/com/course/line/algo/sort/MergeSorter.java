package com.course.line.algo.sort;

import java.util.Arrays;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-23
 */
public class MergeSorter {
    public static void sort(int[] data) {
        if (data == null || data.length < 2) return;
        int[] temp = new int[data.length];

        sort(data, 0, data.length - 1, temp);
    }

    private static void sort(int[] data, int left, int right, int[] temp) {
        //终止条件
        if (left == right) return;
        //子问题求解
        int mid = (left + right) / 2;

        sort(data, left, mid, temp);
        sort(data, mid + 1, right, temp);
        //合并
        merge(data, left, mid, right, temp);
    }


    private static void merge(int[] data, int left, int mid, int right, int[] temp) {

        int tempPos = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[tempPos] = data[i];
                i++;
            } else {
                temp[tempPos] = data[j];
                j++;
            }
            tempPos++;

        }
        //左边还有元素
        while (i <= mid) {
            temp[tempPos++] = data[i++];
        }
        //左边还有元素
        while (j <= right) {
            temp[tempPos++] = data[j++];
        }

        int num = right - left + 1;
        for (int k = left; k < num; k++) {
            data[left++] = temp[k];
        }
    }


    private void merge2(int[] data, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = data[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) { // 左边没有元素，右边有元素
                data[k] = tmp[j++];
            } else if (j == right + 1) { // 左边有元素，右边没有元素
                data[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                data[k] = tmp[i++];
            } else {
                // 注意：这里使用 data 和 tmp 都是一样的
                // 原因：在合并的时候是从左往右去修改 data 的，所以 data 的没有修改的后半部分和 tmp 的后半部分是一样的
                data[k] = tmp[j++];
            }
        }
    }

    public void sortBU(int[] data) {
        if (data == null || data.length <= 1) return;
        int len = data.length;
        int[] tmp = new int[len];
        for (int size = 1; size < len; size += size) { // size 表示子数组的长度，1,2,4,8
            for (int left = 0; left < len - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, len - 1);
                merge(data, left, mid, right, tmp);
            }
        }
    }
    public static void main(String[] args) {
        int[] data = new int[]{12, 31, 42, 35, 67, 89};
        MergeSorter.sort(data);

        System.out.println(Arrays.toString(data));
    }


}
