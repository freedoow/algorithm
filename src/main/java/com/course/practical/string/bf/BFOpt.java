package com.course.practical.string.bf;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-05
 */
public class BFOpt {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        char first = pattern.charAt(0);
        for (int i = 0; i < m; i++) {
            // 1. 找到等于模式串中第一个字符的位置
            if (mainString.charAt(i) != first) {
                while (i < m && mainString.charAt(i) != first) {
                    i++;
                }

                if (i < m) {
                    // 2. 比对后面的字符，如果相等的话，一直比对下去
                    int k = i + 1;
                    for (int j = 1; j < n && k < m; j++, k++) {
                        if (mainString.charAt(k) == pattern.charAt(j)) {
                            // 3. 如果 j 是模式串的最后一个字符，说明匹配到了模式串
                            if (j == n - 1) return i;
                            continue;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BFOpt b = new BFOpt();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
