package com.course.practical.bitmap;

import java.util.Random;

/**
 * @author freed
 * @Description: 标准位图
 * @Date 2022-09-10
 */
public class BitMapStandard {

    private byte[] bytes;
    private int nBits;

    public BitMapStandard(int nBits) {
        this.nBits = nBits;
        this.bytes = new byte[nBits / 8 + 1];
    }

    public void set(int num) {
        if (num > nBits) return;
        //找到第几个字节
        int byteIndex = num / 8;
        //找到第几位 ?
        int bitIndex = num % 8;
        bytes[byteIndex] |= (1 << bitIndex);

    }

    public boolean contains(int target) {
        if (target > nBits) return false;
        //找到第几个字节
        int byteIndex = target / 8;
        //找到第几位 ?
        int bitIndex = target % 8;

        return ((1 << bitIndex) & bytes[byteIndex]) != 0;


    }


    public static void main(String[] args) {
        int[] data = new int[]{2, 7, 2, 5, 3};
        BitMapStandard bitMapBase = new BitMapStandard(8);
        for (int i = 0; i < data.length; i++) {
            bitMapBase.set(data[i]);

        }

        if (bitMapBase.contains(4)) {
            System.out.println("存在目标值");
        }

        //1亿数据
         data = new int[10_000_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Random().nextInt(100_000_000);
        }

        bitMapBase = new BitMapStandard(100_000_000); //100_000_000 bit =  12MB

        for (int i = 0; i < data.length; i++) {
            bitMapBase.set(data[i]);
        }
        if (bitMapBase.contains(data[888])){
            System.out.println("存在目标值");
        }


         /*

        // 1. 使用哈希表
        Set<Integer> set = new HashSet<>(); // 10_000_000 * 4 / 0.75 = 51 MB (理想情况)
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        if (set.contains(target)) { // 时间复杂度 O(1)，会存在哈希冲突
            System.out.println("1 千万个整数中存在目标值：" + target);
        }

        // 2. 使用 boolean 类型的数组
        boolean[] arr = new boolean[100_000_000]; // 100_000_000 byte = 95 MB
        for (int i = 0; i < data.length; i++) {
            arr[data[i]] = true;
        }
        if (arr[target]) { // 时间复杂度 O(1)
            System.out.println("1 千万个整数中存在目标值：" + target);
        }

        */
    }
}
