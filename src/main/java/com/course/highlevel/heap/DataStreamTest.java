package com.course.highlevel.heap;

/**
 * @author whb
 * @Description:
 * @Date 2022-07-17
 */
public class DataStreamTest {
    public static void main(String[] args) {
        DataStream1 dataStream = new DataStream1();
        dataStream.add(3);
        System.out.println(dataStream.removeMax()); // 打印 3
        dataStream.add(6);
        dataStream.add(5);
        System.out.println(dataStream.removeMax()); // 打印 6
        dataStream.add(2);
        dataStream.add(1);
        System.out.println(dataStream.removeMax()); // 打印 5
    }
}
