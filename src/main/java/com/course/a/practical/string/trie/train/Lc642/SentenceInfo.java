package com.course.a.practical.string.trie.train.Lc642;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-10
 */
public class SentenceInfo {
    private String content;
    private int time;

    SentenceInfo(String content, int time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public int getTime() {
        return time;
    }
}
