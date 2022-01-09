package com.course.line.stack.Leetcode;


import java.util.Stack;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-22
 */
public class lc155_MinStack {


    private class MinStack1 {
        private Stack<Integer> stack;

        public MinStack1() {
            this.stack = new java.util.Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            int minValue = stack.peek();
            for (Integer i : stack) {
                minValue = Math.min(minValue, i);
            }
            return minValue;
        }
    }

    private class MinStack2 {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MinStack2() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            Integer pop = dataStack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


    private class MinStack3 {
        private Stack<Node> stack;

        public MinStack3() {
            this.stack = new Stack<>();
        }

        public void push(int x) {
            Node node = new Node();
            node.val = x;
            int min = x;
            if (!stack.isEmpty() && stack.peek().min <= min) {
                node.min = stack.peek().min;
            }
            node.min = min;
            stack.push(node);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().min;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }


    private class MinStack4 {
        private Node dummyHead;

        private Stack<Node> stack;

        public MinStack4() {
            this.dummyHead = new Node();
        }

        public void push(int x) {
            int min = x;
            Node head = dummyHead;
            if (head != null && head.min <= x) {
                min = head.min;
            }
            Node node = new Node(x, min);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        public void pop() {
            Node head = dummyHead.next;
            if (head != null) {
                dummyHead.next = head.next;
                head.next = null;
            }

        }

        public int top() {
            return dummyHead.next.val;
        }

        public int getMin() {
            return  dummyHead.next.min;
        }
    }

    private class Node {
        int val;
        int min;
        Node next;

        public Node() {
        }

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}