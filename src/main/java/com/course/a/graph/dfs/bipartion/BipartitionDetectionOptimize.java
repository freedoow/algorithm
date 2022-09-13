package com.course.a.graph.dfs.bipartion;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.Arrays;

/**
 * @author freed
 * @Description: 递归优化-二分图检测-优化
 * @Date 2022-08-21
 */
public class BipartitionDetectionOptimize {
    private Graph g;
    private boolean[] visited;
    /**
     * -1 没有染颜色
     * 0 红色
     * 1 蓝色
     */
    private int[] colors;
    private boolean isBipartition;


    public BipartitionDetectionOptimize(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        if (g == null) return;

        this.isBipartition = true;
        this.colors = new int[g.getV()];
        Arrays.fill(colors, -1);

        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    isBipartition = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                /**
                 * 1 ->0
                 * 0 ->1
                 */
                if (dfs(w, 1 - color)) return true;
            } else if (colors[w] == colors[v]) {//相邻顶点的颜色一样 则不是二分图
                return false;
            }
        }
        return true;
    }

    public boolean isBipartition() {
        return isBipartition;
    }

    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-bi.txt");
        BipartitionDetectionOptimize graphDfs = new BipartitionDetectionOptimize(g);
        System.out.println(graphDfs.isBipartition());
    }
}