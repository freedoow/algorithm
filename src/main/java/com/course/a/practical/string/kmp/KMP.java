package com.course.a.practical.string.kmp;


import java.util.Arrays;

/**
 * *************
 * @author freed
 * @Description: 坏字符规则
 * @Date 2022-09-07
 */
public class KMP {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        //根据模式串所有的前缀，计算得到next数组
        int[] next = getNext(pattern.toCharArray());

        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j > 0 && mainString.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1] + 1;
            }
            if (mainString.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            }

            if (j == n) return i - n + 1;
        }
        return -1;
    }


    private int[] getNext(char[] pattern) {
        int n = pattern.length;
        // bug 修复： 如果只有一个字符的话，就不计算 next 数组
        if (n == 1) return new int[0];

        int[] next = new int[n - 1];
        Arrays.fill(next, -1);

        for (int i = 1; i < n - 1; i++) {
            // 1. 拿到模式串中 [0...i] 这个好前缀
            String goodPrefix = new String(pattern, 0, i + 1);
            // 2. 计算当前好前缀的【最长匹配前缀子串】结尾字符的下标
            for (int j = i; j > 0; j--) {
                // 2.1 拿到好前缀的 [j, i] 这个后缀字符串
                String suffix = goodPrefix.substring(j);
                // 2.2 将后缀的每个字符和好前缀的前缀的每个字符比较
                // 得到第一个不相等的字符所在的位置 k
                int k;
                for (k = 0; k < suffix.length(); k++) {
                    if (suffix.charAt(k) != goodPrefix.charAt(k)) {
                        break;
                    }
                }
                // 2.3 如果前缀匹配了后缀字符串，那么更新【最长匹配前缀字符串】结尾字符的下标
                if (k == suffix.length()) {
                    // 注意：next[i] 之前可能已经计算过，所以我们需要取最大值
                    next[i] = Math.max(k - 1, next[i]);
                }
            }
        }
        // 最值问题
        return next;
    }

    private int[] getNext1(char[] pattern) {
        int n = pattern.length;
        // bug 修复： 如果只有一个字符的话，就不计算 next 数组
        if (n == 1) return new int[0];

        int[] next = new int[n - 1];

        next[0] = -1;


        for (int j = 1; j < n - 1; j++) {
            if (pattern[next[j - 1] + 1] == pattern[j]) {
                next[j] = next[j - 1] + 1;
            } else {
                int pre = next[j - 1];
                while (pre >= 0 && pattern[pre + 1] != pattern[j]) {
                    pre = next[pre];
                }
                if (pattern[pre + 1] == pattern[j]) {
                    next[j] = pre + 1;
                } else {
                    next[j] = pre;
                }
            }
        }
        // 最值问题
        return next;
    }

    private int[] getNext2(char[] pattern) {
        int n = pattern.length;
        // bug 修复： 如果只有一个字符的话，就不计算 next 数组
        if (n == 1) return new int[0];

        int[] next = new int[n - 1];

        next[0] = -1;


        for (int j = 1; j < n - 1; j++) {
            int pre = next[j - 1];
            while (pre != -1 && pattern[pre + 1] != pattern[j]) {
                pre = next[pre];
            }
            if (pattern[pre + 1] == pattern[j]) {
                pre++;
            }
            next[j] = pre;
        }
        // 最值问题
        return next;
    }


    public static void main(String[] args) {
        KMP b = new KMP();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
