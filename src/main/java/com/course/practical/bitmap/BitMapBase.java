package com.course.practical.bitmap;

import java.util.Arrays;

/**
 * @author freed
 * @Description: 基础位图
 * @Date 2022-09-10
 */
public class BitMapBase {

    private byte b;

    public BitMapBase() {
        b = 0;
    }

    public void set(int num) {
         /*
            set 2
            00000001 << 2
            00000100
         b | 00000000
         b = 00000100

            set 2
            00000001 << 2
            00000100
         b | 00000100
         b = 00000100
         */
        b |= (1 << num);

    }

    public boolean contains(int target) {
        /**
         * contains 4
         * 00000001
         * 00010000
         * & 10101100
         * 00000000
         */
        //10101100

        return ((1 << target) & b) != 0;


    }

    @Override
    public String toString() {
        return "BitMap{" +
                "b=" + Integer.toBinaryString(b).substring(24) +
                '}';
    }
    public static void main(String[] args) {
        int[] data = new int[]{2, 7, 2, 5, 3};
        BitMapBase bitMapBase = new BitMapBase();
        for (int i = 0; i < data.length; i++) {
            bitMapBase.set(data[i]);

        }

        System.out.println(bitMapBase);

        if (bitMapBase.contains(2)){
            System.out.println("存在目标值");
        }
    }
}
