package com.course.a.graph.direct.topology;

import com.course.a.graph.Graph;
import com.course.a.graph.direct.AdjacentHash;

import java.util.Arrays;

/**
 * @author freed
 * @Description: 环代码检测
 * @Date 2022-08-28
 */
public class Dfs {
    private Graph g;
    private boolean[] visited;

    private boolean hasCycle;
    private boolean[] isOnPath;

    private int[] res;
    private int index;

    public Dfs(Graph g) {
        this.g = g;
        if (g == null) return;

        this.visited = new boolean[g.getV()];
        this.isOnPath = new boolean[g.getV()];

        this.res = new int[g.getV()];
        this.index = this.res.length - 1;

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
        res[index--] = v;
        return false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public int[] getRes() {
        return res;
    }

    public static void main(String[] args) {

        Graph g = new AdjacentHash("/Users/whb/code/algo/algorithm/data/graph-directed.txt", true);
        Dfs graphDfs = new Dfs(g);
        // add 30
        System.out.println(graphDfs.hasCycle);
        System.out.println(Arrays.toString(graphDfs.getRes()));
    }
}