package com.course.highlevel.skiplist;

import java.util.Random;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-14
 */
public class SkipList<E extends Comparable> {
    // 表示跳表的高度，包括原始链表这一层
    private static final int MAX_LEVEL = 16;

    //当前跳表最大高度（包括原始链表层）
    private int levelCount;
    //虚拟头节点
    private Node<E> dummyHead;

    private Random random = new Random();

    public SkipList() {
        this.levelCount = 1;
        this.dummyHead = new Node(-1);
    }

    public boolean contains(E e) {
        return get(e) != null;
    }

    public Node get(E e) {
        Node curr = this.dummyHead;
        //从最高层往下一层一层寻找
        for (int i = levelCount - 1; i >= 0; i--) {
            while (curr.nextNodes[i] != null && curr.nextNodes[i].data.compareTo(e) < 0) {
                curr = curr.nextNodes[i];
            }
        }
        // curr.next == null or  =e or >e
        if (curr.nextNodes[0] != null && curr.nextNodes[0].data.compareTo(e) == 0) {
            return curr.nextNodes[0];
        }
        return null;
    }

    /**
     * 随机 level 次，如果是奇数层数 +1，防止伪随机
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public void add(E e) {
        //维护索引
        int level = dummyHead.nextNodes[0] == null ? 1 : randomLevel();
        //两层前一个节点初始化为虚拟头节点
        Node[] prevNodes = new Node[level];
        for (int i = 0; i < level; i++) {
            prevNodes[i] = dummyHead;
        }


        // 找到
        Node prev = this.dummyHead;
        //从最高层往下一层一层寻找
        for (int i = levelCount - 1; i >= 0; i--) {
            while (prev.nextNodes[i] != null && prev.nextNodes[i].data.compareTo(e) < 0) {
                prev = prev.nextNodes[i];
            }
            //维护每一层的前一个节点
            if (i < level) prevNodes[i] = prev;

        }

        //插入
        Node newNode = new Node(e);
        for (int i = 0; i < level; i++) {
            newNode.nextNodes[i] = prevNodes[i];
            prevNodes[i].nextNodes[i] = newNode;
        }
        //更新链表高度
        if (levelCount < level) levelCount = level;
    }

    public void remove(E e) {
        //找到删除节点前一个节点 删除节点索引节点的前一个索引节点
        Node<E>[] prevNodes = new Node[levelCount];
        Node prev = this.dummyHead;
        //从最高层往下一层一层寻找
        for (int i = levelCount - 1; i >= 0; i--) {
            while (prev.nextNodes[i] != null && prev.nextNodes[i].data.compareTo(e) < 0) {
                prev = prev.nextNodes[i];
            }
            prevNodes[i] = prev;
        }
        //对每一层进行删除
        if (prev.nextNodes[0] != null && prev.nextNodes[0].data.compareTo(e) == 0) {
            for (int i = levelCount - 1; i >= 0; i--) {
                Node delNode = prevNodes[i].nextNodes[i];
                if (delNode != null && delNode.data.compareTo(e) == 0) {
                    prevNodes[i].nextNodes[i] = delNode.nextNodes[i];
                    delNode.nextNodes[i] = null;
                }
            }
        }
    }
}
