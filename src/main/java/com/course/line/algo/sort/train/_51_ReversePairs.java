package com.course.line.algo.sort.train;

/**
 * @author freedoow
 * @Description: 逆序对
 * @Date 2022-02-27
 */
public class _51_ReversePairs {
    public int reversePairs(int[] data) {
        int[] temp = new int[data.length];

        return reversePairs(data, 0, data.length - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int leftNum = reversePairs(nums, left, mid, temp);
        int rightNum = reversePairs(nums, mid + 1, right, temp);
        int mergeNum = merge(nums, left, mid, right, temp);
        return leftNum + rightNum + mergeNum;
    }

    private int merge(int[] data, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = data[i];
        }

        int count = 0;
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) { // 左边没有元素，右边有元素
                data[k] = tmp[j++];
            } else if (j == right + 1) { // 左边有元素，右边没有元素
                data[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                data[k] = tmp[i++];
            } else { // tmp[i] <= tmp[j]
                // 注意：这里使用 data 和 tmp 都是一样的
                // 原因：在合并的时候是从左往右去修改 data 的，所以 data 的没有修改的后半部分和 tmp 的后半部分是一样的
                data[k] = tmp[j++];

                //计算逆序对
                count += mid - i + 1;
            }
        }

        return count;
    }
}
