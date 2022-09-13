package com.course.a.line.stack.array;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-12
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack<Object> stack = new ArrayStack<>(5);

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

        DynamicArrayStack<Object> dynamicArrayStack = new DynamicArrayStack<>(5);

        dynamicArrayStack.push(1);
        System.out.println(dynamicArrayStack.toString());

        dynamicArrayStack.push(2);
        System.out.println(dynamicArrayStack.toString());

        dynamicArrayStack.push(3);
        System.out.println(dynamicArrayStack.toString());

        dynamicArrayStack.push(4);
        System.out.println(dynamicArrayStack.toString());

        dynamicArrayStack.pop();
        System.out.println(dynamicArrayStack.toString());

        dynamicArrayStack.pop();
        System.out.println(dynamicArrayStack.toString());
    }
}
