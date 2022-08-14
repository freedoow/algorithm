package com.course.highlevel.skiplist;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-14
 */
public class Node<E extends Comparable> {
    private static final int MAX_VALUE = 16;
    //跳表节点，每个节点记录了当前节点数据和所在层数数据
    E data;
    // 表示当前节点在所在层的下一个节点的指针，从上层切换到下层 数据下标-1
     /*
            nextNodes[0] 表示当前节点在第一层的下一个节点
            nextNodes[1] 表示当前节点在第二层的下一个节点
            nextNodes[2] 表示当前节点在第三层的下一个节点
            nextNodes[3] 表示当前节点在第四层的下一个节点
            ...
            nextNodes[15] 表示当前节点在第十六层的下一个节点
        */
    Node[] nextNodes;
    //记录这个节点最大索引高度
    int maxIndexLevel =0;

    public Node(E data) {
        this.data = data;
        nextNodes = new Node[MAX_VALUE];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ data: ");
        builder.append(data);
        builder.append("; levels: ");
        builder.append(maxIndexLevel);
        builder.append(" }");
        return builder.toString();
    }

}
