package com.course.a.line.stack.Leetcode;

import com.course.a.line.stack.array.ArrayStack;

/**
 * @author freedoow
 * @Description:
 * @Date 2021-12-22
 */
public class lc20_Use {
    //暴力解
    public boolean isValid(String s) {
        StringBuffer sb = new StringBuffer(s);
        int count = sb.length() / 2;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                char c1 = sb.charAt(j);
                char c2 = sb.charAt(j + 1);
                //匹配删除
                if (isMatched(c1, c2)) {
                    sb.delete(j, j + 2);
                    break;
                }
            }
        }
        if (sb.length() == 0) {
            return true;
        } else {
            return false;
        }

    }


    public boolean isMatched(char c1, char c2) {
        if (c1 == '(') {
            return c2 == ')';
        } else if (c1 == '[') {
            return c2 == ']';
        } else if (c1 == '{') {
            return c2 == '}';
        } else {
            return false;
        }
    }


    /**
     * 辅助栈
     *
     * @param s
     * @return
     */
    public static boolean isValidA2(String s) {

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
        lc20_Use A2 = new lc20_Use();
        System.out.println(A2.isValid("([{}])"));
        System.out.println(A2.isValid("{}}"));
        System.out.println(A2.isValid("{[}]"));
        System.out.println(A2.isValid("{}["));
    }
}
