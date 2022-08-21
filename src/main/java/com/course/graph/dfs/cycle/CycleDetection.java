package com.course.graph.dfs.cycle;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description: 递归- 环检测代码
 * @Date 2022-08-21
 */
public class CycleDetection {
    private Graph g;
    private boolean[] visited;
    private boolean hasCycle;

    public CycleDetection(Graph g) {
        this.g = g;
        if (g == null) return;
        this.hasCycle = false;
        this.visited = new boolean[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                dfs(i, i);
            }
        }
    }

    private void dfs(int v, int prev) {
        visited[v] = true;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                dfs(w, v);
            } else {// 否则，w顶点已被访问
                if (w != prev) { // 如果w不是v的前一个节点的话，那么久存在环
                    hasCycle = true;
                }
            }
        }
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-cycle.txt");
        CycleDetection graphDfs = new CycleDetection(g);
        System.out.println(graphDfs.isHasCycle());
    }
}