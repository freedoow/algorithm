package com.course.a.practical.string.bf;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-05
 */
public class BF {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        for (int i = 0; i < m; i++) {
            // 1. 比对后面的字符，如果相等的话，一直比对下去
            int k = i;
            for (int j = 0; j < n; j++) {
                if (pattern.charAt(j) == mainString.charAt(k)) {
                    k++;

                    // 2. 如果 j 是模式串的最后一个字符，说明匹配到了模式串
                    if (j == n - 1) return i;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BF b = new BF();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
