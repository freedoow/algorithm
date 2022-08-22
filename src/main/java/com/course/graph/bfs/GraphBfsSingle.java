package com.course.graph.bfs;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-22
 */
public class GraphBfsSingle {
    private Graph g;
    private boolean[] visited;

    private int[] prevs;
    private int source;


    public GraphBfsSingle(Graph g, int source) {
        this.g = g;
        this.source = source;

        this.visited = new boolean[g.getV()];
        this.prevs = new int[g.getV()];
        Arrays.fill(this.prevs, -1);
        bfs(source);
    }

    private void bfs(int v) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        visited[v] = true;

        prevs[v] = v;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer w : g.getTargetVAllV(curr)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    //维护前一个顶点
                    prevs[w] = curr;
                }
            }
        }
    }

    public boolean isConnected(int target) {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合法 or 超出范围");
    }

    public List<Integer> path(int target) {
        validateVertex(target);
        //源顶点到不了目标顶点，直接返回
        if (!isConnected(target)) return new ArrayList<>(0);
        ArrayList<Integer> res = new ArrayList<>();
        //根据 prevs 信息找到路径
        while (target != source) {
            res.add(target);
            target = prevs[target];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/bfs/graph-bfs.txt");
        GraphBfsSingle graphBfs = new GraphBfsSingle(g,0);
        System.out.println(graphBfs.path(6));
    }
}
