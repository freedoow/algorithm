package com.course.a.practical.string.rk;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-06
 */
public class Rk {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        // 1. 计算主串中 m - n + 1 个子串的哈希值
        int[] hashCodes = new int[m - n + 1];
        for (int i = 0; i < m - n - 1; i++) {
            hashCodes[i] = calHashCode(mainString.substring(i, i + n));
        }

        // 2. 计算模式串的哈希值
        int hashCode = calHashCode(pattern);
        for (int i = 0; i < m - n - 1; i++) {
            if (hashCode == hashCodes[i]) return i;
        }


        return -1;
    }

    private int calHashCode(String str) {
        return str.hashCode();
    }

    public static void main(String[] args) {
        Rk b = new Rk();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
