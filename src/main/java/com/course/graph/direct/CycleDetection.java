package com.course.graph.direct;

import com.course.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description: 环代码检测
 * @Date 2022-08-28
 */
public class CycleDetection {
    private Graph g;
    private boolean[] visited;

    private boolean hasCycle;
    private boolean[] isOnPath;

    public CycleDetection(Graph g) {
        this.g = g;
        if (g == null) return;

        this.visited = new boolean[g.getV()];
        this.isOnPath = new boolean[g.getV()];

        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }


    private boolean dfs(int v) {
        visited[v] = true;
        isOnPath[v] = true;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                if (dfs(w)) return true;
            } else {
                if (isOnPath[w]) return true;
            }
        }
        isOnPath[v] = false;
        return false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {

        Graph g = new AdjacentHash("/Users/whb/code/algo/algorithm/data/graph-directed.txt", true);
        CycleDetection graphDfs = new CycleDetection(g);
        // add 30
        System.out.println(graphDfs.hasCycle);
    }
}