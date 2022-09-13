package com.course.a.graph.bfs;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-22
 */
public class GraphBfsCycle {
    private Graph g;
    private boolean[] visited;

    private int[] prevs;
    private int source;
    private boolean hasCycle;


    public GraphBfsCycle(Graph g) {
        this.g = g;
        this.source = source;

        this.visited = new boolean[g.getV()];
        this.prevs = new int[g.getV()];
        Arrays.fill(this.prevs, -1);

        for (int i = 0; i < g.getV(); i++) {
            if (bfs(source)) {
                this.hasCycle = true;
                break;
            }
        }
    }

    private boolean bfs(int v) {
        if (g == null) return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        //维护前一个顶点
        prevs[v] = v;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer w : g.getTargetVAllV(curr)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    //维护前一个顶点
                    prevs[w] = curr;
                } else {
                    if (w == prevs[curr]) return true;
                }
            }
        }
        return false;
    }

    public boolean isConnected(int target) {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合法 or 超出范围");
    }


    public boolean isHasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/bfs/graph-bfs.txt");
        GraphBfsCycle graphBfs = new GraphBfsCycle(g);
        System.out.println(graphBfs.isHasCycle());
    }
}
