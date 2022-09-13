package com.course.a.graph.dfs.bipartion;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.Arrays;

/**
 * @author freed
 * @Description: 递归优化-二分图检测
 * @Date 2022-08-21
 */
public class BipartitionDetection {
    private Graph g;
    private boolean[] visited;
    /**
     * -1 没有染颜色
     * 0 红色
     * 1 蓝色
     */
    private int[] colors;
    private boolean isBipartition;


    public BipartitionDetection(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        if (g == null) return;

        this.isBipartition = true;
        this.colors = new int[g.getV()];
        Arrays.fill(colors, -1);

        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
        }
    }

    private void dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                /**
                 * 1 ->0
                 * 0 ->1
                 */
                dfs(w, 1 - color);
            } else if (colors[w] == colors[v]) {//相邻顶点的颜色一样 则不是二分图
                isBipartition = false;
            }
        }
    }

    public boolean isBipartition() {
        return isBipartition;
    }


    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-bi.txt");
        BipartitionDetection graphDfs = new BipartitionDetection(g);
        System.out.println(graphDfs.isBipartition());
    }
}