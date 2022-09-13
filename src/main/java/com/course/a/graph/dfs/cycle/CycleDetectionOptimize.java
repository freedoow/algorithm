package com.course.a.graph.dfs.cycle;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

/**
 * @author freed
 * @Description: 递归- 环检测代码 - 优化
 * @Date 2022-08-21
 */
public class CycleDetectionOptimize {
    private Graph g;
    private boolean[] visited;
    private boolean hasCycle;

    // 已 存在则无需遍历
    public CycleDetectionOptimize(Graph g) {
        this.g = g;
        if (g == null) return;
        this.hasCycle = false;
        this.visited = new boolean[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                if (dfs(i, i)) hasCycle = true;
                break;
            }
        }
    }

    private boolean dfs(int v, int prev) {
        visited[v] = true;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else {// 否则，w顶点已被访问
                // 如果w不是v的前一个节点的话，那么久存在环
                if (w != prev) return true;
            }
        }
        return false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-cycle.txt");
        CycleDetectionOptimize graphDfs = new CycleDetectionOptimize(g);
        System.out.println(graphDfs.isHasCycle());
    }
}