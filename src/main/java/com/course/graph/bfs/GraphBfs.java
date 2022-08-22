package com.course.graph.bfs;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-22
 */
public class GraphBfs {
    private Graph g;
    private boolean[] visited;
    private List<Integer> res;

    public GraphBfs(Graph g) {
        this.g = g;

        this.visited = new boolean[g.getV()];
        this.res = new ArrayList<>();

        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) bfs(v);
        }
    }

    private void bfs(int v) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);

            for (Integer w : g.getTargetVAllV(curr)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public List<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/bfs/graph-bfs.txt");
        GraphBfs graphBfs = new GraphBfs(g);
        System.out.println(graphBfs.getRes());
    }
}
