package com.course.line.stack.Leetcode;


import com.course.line.stack.array.ArrayStack;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-12
 */
public class A2 {
    public static boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<Character>(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character peek = stack.peek();
                if (peek == '(' && c == ')') {
                    stack.pop();
                } else if (peek == '{' && c == '}') {
                    stack.pop();
                } else if (peek == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(A2.isValid("([{}])"));
        System.out.println(A2.isValid("{}}"));
        System.out.println(A2.isValid("{[}]"));
        System.out.println(A2.isValid("{}["));
    }
}