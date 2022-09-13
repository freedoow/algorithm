package com.course.a.line.linkedlist;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-05
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addLast(123);
        System.out.println(linkedList.toString());

        linkedList.addFirst(456);
        System.out.println(linkedList.toString());

        linkedList.addLast(789);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(2).toString());
        System.out.println(linkedList.contains(123));
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.toString());

    }
}
