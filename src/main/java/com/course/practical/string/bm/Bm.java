package com.course.practical.string.bm;

/**
 * @author freed
 * @Description: 坏字符规则
 * @Date 2022-09-07
 */
public class Bm {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        int i = 0;// i 表示每次匹配的时候，主串的起始位置，初始化为 0
        while (i <= m - n) {
            //1、第一个坏字符
            int y;
            for (y = n - 1; y >= 0; y--) {
                if (mainString.charAt(i + y) != pattern.charAt(y)) break;
            }
            //2、匹配成功
            if (y < 0) {
                return i;
            }
            //3、匹配不成功
            // 先计算坏字符在模式串中的位置 x
            int x = -1;
            for (int j = 0; j < y; j++) {//线性查找
                char badChar = mainString.charAt(i + y);
                if (badChar == pattern.charAt(j)) {
                    x = j;
                }
            }
            // 4. 往后移动 y - x 位
            // bug 修复：坏字符在模式串的中位置可能会大于 y，即 x 有可能大于 y
            // 比如：主串为 aaabaaabaaabaaaa 模式串为 aba
            // 解决方案就是：如果 y < x 的话，那么去选择往前走 1 步
            i = i + Math.max(1, (y - x));
        }


        return -1;
    }


    public static void main(String[] args) {
        Bm b = new Bm();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
