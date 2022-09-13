package com.course.a.practical.string.trie.train.Lc642;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class TrieImpl {

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        // times == 0 说明，这个节点不是字符串的结尾节点
        // times > 0 说明是结尾字符节点
        int times = 0;
    }

    private TrieNode root;

    //记录用户当前的输入
    private String currSentence = "";

    public TrieImpl(String[] sentences, int[] times) {
        root = new TrieNode();
        //构建前缀树
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    public void insert(String s, int times) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.times += times;
    }

    public List<String> input(char c) {
        ArrayList<String> resList = new ArrayList<>();

        if (c == '#') {// 已输入完成 更新数据
            insert(currSentence, 1);
            currSentence = "";
        } else {
            List<SentenceInfo> list = lookup(currSentence);
            //1、将当前输入字符拼接到当前句子
            currSentence += c;
            //2、找到所有以当前输入字符串开头的句子

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

    public List<SentenceInfo> lookup(String s) {
        List<SentenceInfo> list = new ArrayList<>();

        //1、找到前缀
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return list;
            }
            curr = curr.children.get(c);
        }
        dfs(curr, s, list);
        return list;
    }

    private void dfs(TrieNode curr, String s, List<SentenceInfo> list) {
        if (curr.times > 0) {
            list.add(new SentenceInfo(s, curr.times));
        }
        for (Character c : curr.children.keySet()) {
            dfs(curr.children.get(c), s + c, list);
        }
    }
}
