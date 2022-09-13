package com.course.a.practical.string.trie.train;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class Lc208 {

    private class Node {
        //每个节点包含：
        //1、一个字符
        //2、若干子节点
        //a-z 26个
        //a -> 0, b -> 1, ... z -> 26
        // a - a = 0
        // b - a = 1
        private Node[] children;
        //标识，这个节点是否是一个单词最后一个字符
        private boolean isWord;

        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }

    private Node root;

    public Lc208() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (Character c : prefix.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Lc208 trie = new Lc208();
        trie.insert("big");
        trie.insert("pat");
        trie.insert("bigger");
        trie.insert("dog");
        trie.insert("door");

        System.out.println(trie.search("door"));
    }
}
