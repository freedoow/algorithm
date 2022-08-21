package com.course.graph.dfs;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author freed
 * @Description: 单源路径
 * @Date 2022-08-21
 */
public class SingleSourcePath {
    private Graph g;
    private int source;

    private boolean[] visited;
    private int[] prevs;


    public SingleSourcePath(Graph g, int source) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        this.source = source;
        this.prevs = new int[g.getV()];
        //每个顶点前一个顶点初始化为-1
        for (int i = 0; i < g.getV(); i++) {
            prevs[i] = -1;
        }
        //源顶点遍历
        //源顶点的前一个设置为源顶点本身
        dfs(source, source);
    }

    //递归遍历顶点v，并维护顶点v 的前一个顶点的信息
    private void dfs(int v, int prev) {
        visited[v] = true;
        prevs[v] = prev;

        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                //v 是w 前一个订点
                dfs(w, v);
            }
        }
    }


    public boolean isConnected(int target) {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合法 or 超出范围");
    }

    public List<Integer> path(int target) {
        validateVertex(target);
        //源顶点到不了目标顶点，直接返回
        if (!isConnected(target)) return new ArrayList<>(0);
        ArrayList<Integer> res = new ArrayList<>();
        //根据 prevs 信息找到路径
        while (target != source) {
            res.add(target);
            target = prevs[target];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {

        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-single.txt");
        SingleSourcePath graphDfs = new SingleSourcePath(g,0);
        System.out.println(graphDfs.path(6));
    }
}