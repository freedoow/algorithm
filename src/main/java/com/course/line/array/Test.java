package com.course.line.array;

import java.util.Arrays;

/**
 * @author freedoow
 */
public class Test {
    public static void main(String[] args) {
        int [] a = new int[3];
        a[0] =0;
        a[1] =1;
        a[2] =2;
        int[] newA1 = ArrayUtils.insertElement(a, 1, 3);
        System.out.println(Arrays.toString(newA1));
        int[] newA2 = ArrayUtils.removeElement(a, 0);
        System.out.println(Arrays.toString(newA2));

    }
}
