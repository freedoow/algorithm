package com.course.a.graph.dfs;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description: 递归
 * @Date 2022-08-17
 */
public class GraphDfsR {
    private Graph g;

    public GraphDfsR(Graph g) {
        this.g = g;
    }

    public ArrayList<Integer> dfs(int v) {

        ArrayList<Integer> res = new ArrayList<>();
        if (g == null) return new ArrayList<>(0);
        boolean[] visited = new boolean[g.getV()];
        dfs(v, res, visited);
        return res;
    }

    private void dfs(int v, List<Integer> list, boolean[] visited) {
        if (g == null) return;
        list.add(v);
        visited[v] = true;
        for (Integer w : g.getTargetVAllV(v)) {
            if (!visited[w]) {
                dfs(w, list, visited);
            }
        }
    }


    public static void main(String[] args) {

        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs.txt");
        GraphDfsR graphDfs = new GraphDfsR(g);
        System.out.println(graphDfs.dfs(0));
    }
}