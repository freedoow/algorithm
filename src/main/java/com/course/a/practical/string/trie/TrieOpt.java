package com.course.a.practical.string.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class TrieOpt {

    private class Node {
        //每个节点包含：
        //1、一个字符
        //2、若干子节点
        private Map<Character, Node> children;
        //标识，这个节点是否是一个单词最后一个字符
        private boolean isWord;

        public Node() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    private Node root;

    public TrieOpt() {
        this.root = new Node();
    }

    //添加单词
    public void add(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            //1、先从子节点中查找是否包含当前字符c
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }



    //判断是否包含指定的单词
    public boolean contains(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            //1、先从子节点中查找是否包含当前字符c
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.isWord;
    }

    public static void main(String[] args) {
        TrieOpt trie = new TrieOpt();
        trie.add("big");
        trie.add("pat");
        trie.add("bigger");
        trie.add("dog");
        trie.add("door");

        System.out.println(trie.contains("door"));
    }
}
