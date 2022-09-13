package com.course.a.graph.floodfill;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

/**
 * @author freed
 * @Description: 递归优化-最大联通分量顶点数
 * @Date 2022-08-25
 */
public class ConnectedComponentMaxCount {
    private Graph g;
    private boolean[] visited;
    private int maxVertexNum;


    public ConnectedComponentMaxCount(Graph g) {
        this.g = g;
        if (g == null) return;
        this.maxVertexNum = 0;
        this.visited = new boolean[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                maxVertexNum = Math.max(dfs(i), maxVertexNum);
            }
        }
    }


    private int dfs(int v) {
        visited[v] = true;
        int res = 1;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                res += dfs(w);
            }
        }
        return res;
    }

    public int getMaxVertexNum() {
        return maxVertexNum;
    }

    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-ccmc.txt");
        ConnectedComponentMaxCount graphDfs = new ConnectedComponentMaxCount(g);
        System.out.println(graphDfs.maxVertexNum);
    }
}