package com.course.b._1;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-14
 */
public class lc_1370 {
    public String sortString(String s) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            //上升
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    sb.append(Character.valueOf((char) (i + 'a')) );
                    counts[i]--;
                }
            }
            //下降
            for (int i = 25; i >= 0; i--) {
                if (counts[i] > 0) {
                    sb.append(Character.valueOf((char) (i + 'a')));
                    counts[i]--;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        lc_1370 lc_1370 = new lc_1370();
        System.out.println(lc_1370.sortString("aaaabbbbcccc"));
    }
}
