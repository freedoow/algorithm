package com.course.a.practical.string.rk;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-06
 */
public class RkOptHash {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        // 1. 计算主串中 m - n + 1 个子串的哈希值
        int[] hashCodes = new int[m - n + 1];
        hashCodes[0] = calFirstSubStrHashCode(mainString.substring(0, n));

        for (int i = 1; i < m - n - 1; i++) {
            hashCodes[i] = calHashCode(mainString, i, hashCodes, n);
        }

        // 2. 计算模式串的哈希值
        int hashCode = calFirstSubStrHashCode(pattern);
        for (int i = 0; i < m - n - 1; i++) {
            // abc = 0 + 1 + 2 = 3
            // cba = 2 + 1 + 0 = 3
            if (hashCode == hashCodes[i]) {
                // 解决哈希冲突问题：将子串和模式串重新对比一遍
                int k = i;
                for (int j = 0; j < n; j++) {
                    if (mainString.charAt(k) != pattern.charAt(j)) break;
                    k++;
                    if (j == n-1) return i;
                }
            }
        }

        return -1;
    }

    // abc => 0 + 1 + 2 = 3
    private int calFirstSubStrHashCode(String substring) {
        int n = substring.length();

        int hashCode = 0;
        for (int i = 0; i < n; i++) {
            hashCode += (substring.charAt(n - i - 1) - 'a');
        }

        return hashCode;
    }

    //h[i] =h[i-1] -s[i-1]+s[i+n-1]
    private int calHashCode(String mainString, int i, int[] hashCodes, int n) {
        return hashCodes[i - 1] - (mainString.charAt(i - 1) - 'a') + (mainString.charAt(i + n - 1) - 'a');
    }

    public static void main(String[] args) {
        RkOptHash b = new RkOptHash();
        String mainStr = "    oury code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
