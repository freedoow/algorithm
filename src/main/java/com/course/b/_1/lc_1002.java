package com.course.b._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-14
 */
public class lc_1002 {
    public List<String> commonChars(String[] A) {
        //每个字符在所有字符串出现的最小次数
        int[] minfreq = new int[26];

        //第一个单词 每个字符出现的次数
        for (char c : A[0].toCharArray()) {
            minfreq[c - 'a']++;
        }

        //计算每个字符串出现的最小次数

        for (int i = 0; i < A.length; i++) {
            int[] freq = new int[26];
            for (char c : A[i].toCharArray()) {
                freq[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                minfreq[j] = Math.min(minfreq[j], freq[j]);
            }

        }
        //输出字符出现的最小次数大于0
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                res.add(String.valueOf(i + 'a'));
            }
        }
        return res;
    }
}
