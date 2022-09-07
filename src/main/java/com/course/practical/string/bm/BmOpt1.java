package com.course.practical.string.bm;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author freed
 * @Description: 坏字符规则
 * @Date 2022-09-07
 */
public class BmOpt1 {
    public int indexOf(String mainString, String pattern) {
        if (mainString == null || pattern == null) return -1;

        int m = mainString.length();
        int n = pattern.length();
        if (m < n) return -1;

        //数据（模式串）预处理，构建坏字符哈希表
        HashMap<Character, Integer> bc = getBadCharIndexMap(pattern);
        // 数据预处理：构建好后缀规则
        int[] suffix = new int[n];
        boolean[] prefix = new boolean[n];
        genGoodSuffixArr(pattern.toCharArray(), suffix, prefix);


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
            char badChar = mainString.charAt(i + y);
            int x = bc.getOrDefault(badChar, -1);

            int badCharMoveSteps = y - x;
            int goodSuffixMoveSteps = 0;
            if (y < n - 1) {
                goodSuffixMoveSteps = calMoveSteps(y, n, suffix, prefix);
            }

            // 4. 往后移动 y - x 位
            // bug 修复：坏字符在模式串的中位置可能会大于 y，即 x 有可能大于 y
            // 比如：主串为 aaabaaabaaabaaaa 模式串为 aba
            // 解决方案就是：如果 y < x 的话，那么去选择往前走 1 步
            i = i + Math.max(badCharMoveSteps, goodSuffixMoveSteps);
        }


        return -1;
    }

    // y 表示坏字符对应的模式串中的字符位置
    private int calMoveSteps(int y, int n, int[] suffix, boolean[] prefix) {
        int k = n - y - 1; // k 表示好后缀的长度
        // 看看模式串中是否存在好后缀(第二种情况)
        if (suffix[k] != -1) return y - suffix[k] + 1;
        // 看看好后缀的后缀子串是否和模式串的前缀子串匹配(第三种情况)
        for (int i = y + 1; i < n; i++) {
            if (prefix[n - i]) {
                return i;
            }
        }
        // 将整个模式串后移 n 位(第一种情况)
        return n;
    }


    private void genGoodSuffixArr(char[] pattern, int[] suffix, boolean[] prefix) {
        Arrays.fill(suffix, -1);
        int n = pattern.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && pattern[j] == pattern[n - 1 - k]) {
                k++;
                suffix[k] = j;
                j--;
            }
            if (j == -1) prefix[k] = true;
        }
    }

    private HashMap<Character, Integer> getBadCharIndexMap(String pattern) {
        char[] patternChar = pattern.toCharArray();
        HashMap<Character, Integer> bc = new HashMap<>();
        for (int i = 0; i < patternChar.length; i++) {
            bc.put(patternChar[i], i);
        }
        return bc;
    }


    public static void main(String[] args) {
        BmOpt1 b = new BmOpt1();
        String mainStr = "    your code";
        String patternStr = "your";

        System.out.println(b.indexOf(mainStr, patternStr));
    }
}
