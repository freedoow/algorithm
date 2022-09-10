package com.course.practical.string.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class Trie {

    private class Node {
        //每个节点包含：
        //1、一个字符
        private Character c;
        //2、若干子节点
        private List<Node> children;
        //标识，这个节点是否是一个单词最后一个字符
        private boolean isWord;

        public Node(Character c) {
            this.c = c;
            children = new ArrayList<>();
            isWord = false;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node('/');
    }

    //添加单词
    public void add(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            //1、先从子节点中查找是否包含当前字符c
            int index = containsChar(curr.children, c);
            if (index == -1) {
                curr.children.add(new Node(c));
                index = curr.children.size() - 1;
            }
            curr = curr.children.get(index);
        }
        curr.isWord = true;
    }

    private int containsChar(List<Node> children, Character c) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).c == c) {
                return i;
            }
        }
        return -1;
    }


    //判断是否包含指定的单词
    public boolean contains(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            //1、先从子节点中查找是否包含当前字符c
            int index = containsChar(curr.children, c);
            if (index == -1) {
                return false;
            }
            curr = curr.children.get(index);
        }

        return curr.isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("big");
        trie.add("pat");
        trie.add("bigger");
        trie.add("dog");
        trie.add("door");

        System.out.println(trie.contains("biggere"));
    }
}
