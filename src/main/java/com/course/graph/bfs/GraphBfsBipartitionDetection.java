package com.course.graph.bfs;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-22
 */
public class GraphBfsBipartitionDetection {
    private Graph g;
    private boolean[] visited;
    // -1表示没有染色
    // 0 红色 1蓝色
    private int[] colors;
    private boolean isBipartition;

    public GraphBfsBipartitionDetection(Graph g) {
        this.g = g;

        this.visited = new boolean[g.getV()];
        this.colors = new int[g.getV()];
        Arrays.fill(colors, -1);

        this.isBipartition = true;

        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) {
                if (!bfs(v)){
                    this.isBipartition =false;
                    break;
                }
            }
        }
    }

    private boolean bfs(int v) {
        if (g == null) return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        colors[v] = 0;


        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer w : g.getTargetVAllV(curr)) {
                //没有遍历过染色
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    // 给顶点w 染色 和 curr颜色不一样
                    colors[w] = 1 - colors[curr];
                } else if (colors[w] == colors[curr]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/bfs/graph-bfs.txt");
        GraphBfsBipartitionDetection graphBfs = new GraphBfsBipartitionDetection(g);
    }
}
