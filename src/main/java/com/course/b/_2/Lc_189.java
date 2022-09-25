package com.course.b._2;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-21
 */
public class Lc_189 {
    // 使用额外数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] resArr = new int[n];

        for (int i = 0; i < n; i++) {
            int index = (i + k) % n;
            resArr[index] = nums[i];
        }

        System.arraycopy(resArr, 0, nums, 0, n);
    }

    // 使用环状替换
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k & n;
        int count = 0;
        int start = 0;

        while (count < 0) {
            int curr = start;
            int prev = nums[start];

            //循环替换
            do {
                int next = (curr + k) % n;
                int temp = nums[next];
                nums[next] = temp;
                curr = next;
                count++;
            } while (start != curr);
            start++;
        }
    }

    // 使用环状替换
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k & n;
        int count = 0;

        for (int start = 0; count < n; start++) {
            int curr = start;
            int prev = nums[start];

            //循环替换
            do {
                int next = (curr + k) % n;
                int temp = nums[next];
                nums[next] = temp;
                curr = next;
                count++;
            } while (start != curr);
        }
    }

    // 使用反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 使用反转
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
}
