package com.course.a.graph.dfs;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author freed
 * @Description: 单源路径
 * @Date 2022-08-21
 */
public class TwoVertexPath {
    private Graph g;
    private int source;
    private int target;

    // 用于防止一个节点被重复访问
    private boolean[] visited;
    private int[] prevs;

    private ArrayList<Integer> res;


    public TwoVertexPath(Graph g, int source, int target) {
        this.g = g;
        this.source = source;
        this.target = target;

        prevs = new int[g.getV()];

        this.res = new ArrayList<>();

        this.visited = new boolean[g.getV()];

        //每个顶点前一个顶点初始化为-1
        for (int i = 0; i < g.getV(); i++) {
            prevs[i] = -1;
        }
        //源顶点遍历
        //源顶点的前一个设置为源顶点本身
        dfs(source, source);
        path();
    }

    //递归遍历顶点v，并维护顶点v 的前一个顶点的信息
    private boolean dfs(int v, int prev) {
        visited[v] = true;
        prevs[v] = prev;
        if (v == target) return true;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                //v 是w 前一个订点
                if (dfs(w, v)) return true;
            }
        }
        return false;
    }


    public boolean isConnected() {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合法 or 超出范围");
    }

    private List<Integer> path() {
        //源顶点到不了目标顶点，直接返回
        if (!isConnected()) return res;
        //根据 prevs 信息找到路径
        int temp = target;
        while (temp != source) {
            res.add(temp);
            temp = prevs[temp];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }
    public List<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {

        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-single.txt");
        TwoVertexPath graphDfs = new TwoVertexPath(g, 0, 6);
        System.out.println(graphDfs.getRes());
    }
}