package com.course.a.line.stack.linkedlist;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-12
 */
public class Test {
    public static void main(String[] args) {
        LinkedListStack<Object> stack = new LinkedListStack();

        stack.push(1);
        System.out.println(stack.toString());

        stack.push(2);
        System.out.println(stack.toString());

        stack.push(3);
        System.out.println(stack.toString());

        stack.push(4);
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());

        System.out.println("---------------");

    }
}
