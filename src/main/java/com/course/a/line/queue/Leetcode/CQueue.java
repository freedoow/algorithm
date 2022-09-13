package com.course.a.line.queue.Leetcode;

import java.util.Stack;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-03
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
        stack1.push(value);
    }

    public int deletedHead() {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        if (stack2.isEmpty()) {
//            return -1;
//        }
//        return stack2.pop();


        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
