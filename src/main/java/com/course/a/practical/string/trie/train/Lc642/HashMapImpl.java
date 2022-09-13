package com.course.a.practical.string.trie.train.Lc642;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class HashMapImpl {

    //记录每个句子被搜索的次数
    private Map<String, Integer> map;
    //记录用户当前的输入
    private String currSentence;

    public HashMapImpl(String[] sentences, int[] times) {
        map = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        ArrayList<String> resList = new ArrayList<>();

        if (c == '#') {// 已输入完成 更新数据
            map.put(currSentence, map.getOrDefault(currSentence, 0) + 1);
            currSentence = "";
        } else {
            ArrayList<SentenceInfo> list = new ArrayList<>();
            //1、将当前输入字符拼接到当前句子
            currSentence += c;
            //2、找到所有以当前输入字符串开头的句子
            for (String sentence : map.keySet()) {
                if (sentence.startsWith(currSentence)) {
                    list.add(new SentenceInfo(sentence, map.get(sentence)));
                }
            }
            //3排序
            Collections.sort(list, new Comparator<SentenceInfo>() {
                @Override
                public int compare(SentenceInfo o1, SentenceInfo o2) {
                    return o1.getTime() == o2.getTime() ?
                            o1.getContent().compareTo(o2.getContent()) :
                            o2.getTime() - o1.getTime();
                }
            });
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                resList.add(list.get(i).toString());
            }
        }

        return resList;
    }
}
