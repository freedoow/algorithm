package com.course.graph.direct;

import com.course.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description: 递归优化-遍历所有顶点
 * @Date 2022-08-17
 */
public class GraphDfsR2 {
    private Graph g;
    private List<Integer> res;
    private boolean[] visited;


    public GraphDfsR2(Graph g) {
        this.g = g;
        if (g == null) return;
        this.res = new ArrayList<>();
        this.visited = new boolean[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }


    private void dfs(int v) {
        res.add(v);
        visited[v] = true;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }


    public List<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {

        Graph g = new AdjacentHash("/Users/whb/code/algo/algorithm/data/graph-dfs.txt", true);
        GraphDfsR2 graphDfs = new GraphDfsR2(g);
        System.out.println(graphDfs.getRes());
    }
}