package com.course.line.stack;

import com.course.line.stack.array.DynamicArrayStack;
import com.course.line.stack.linkedlist.LinkedListStack;

import java.util.Random;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-12
 */
public class Test {
    private static Random random = new Random();

    private static double testStack(Stack<Integer> stack, int cnt) {
        long startTime = System.nanoTime();

        for (int i = 0; i < cnt; i++) {
            stack.push(random.nextInt());
        }
        for (int i = 0; i < cnt; i++) {
            stack.pop();
        }

        return (System.nanoTime() - startTime) / 1000_000_000.0;
    }

    public static void main(String[] args) {
        int cnt = 100000000;

        Stack<Integer> stack = new DynamicArrayStack<>(10);
        double time1 = testStack(stack, cnt);
        System.out.println("DynamicArrayStack 花费的时间：" + time1);

        stack = new LinkedListStack<>();
        double time2 = testStack(stack, cnt);
        System.out.println("LinkedListStack 花费的时间：" + time2);
    }
}
