package com.course.line.array;

import java.util.Arrays;

/**
 * @author freedoow
 */
public class Test {
    public static void main(String[] args) {
//        int [] a = new int[3];
//        a[0] =0;
//        a[1] =1;
//        a[2] =2;
//        int[] newA1 = ArrayUtils.insertElement(a, 1, 3);
//        System.out.println(Arrays.toString(newA1));
//        int[] newA2 = ArrayUtils.removeElement(a, 0);
//        System.out.println(Arrays.toString(newA2));


//        ArrayList arrayList = new ArrayList(10);
//        System.out.println(arrayList.isEmpty());

//        System.out.println(arrayList.isEmpty());
//        arrayList.addFirst(22);
//        arrayList.addLast(23);
//        System.out.println(arrayList);
//        System.out.println(arrayList.contains(22));
//        System.out.println(arrayList.get(2));
//        System.out.println(arrayList.find(2));
//        System.out.println(arrayList);
//
//        arrayList.removeElement(22);
//        System.out.println(arrayList);

        ArrayList<String> stringArrayList = new ArrayList<String>(3);
        stringArrayList.addFirst("aaa");
        stringArrayList.addFirst("bbb");
        stringArrayList.addFirst("ccc");
        System.out.println(stringArrayList);
        stringArrayList.addFirst("ddd");

        System.out.println(stringArrayList);
        stringArrayList.remove(3);
        System.out.println(stringArrayList);
        stringArrayList.remove(3);
        System.out.println(stringArrayList);

        stringArrayList.remove(3);
        System.out.println(stringArrayList);

    }
}
