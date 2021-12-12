package com.course.line.stack.Leetcode;

/**
 * @author freedoow
 * @Description: 暴力直接解答
 * @Date 2021-12-12
 */
public class A1 {
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
}
