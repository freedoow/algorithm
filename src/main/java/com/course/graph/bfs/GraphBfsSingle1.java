package com.course.graph.bfs;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-22
 */
public class GraphBfsSingle1 {
    private Graph g;
    private boolean[] visited;

    private int[] prevs;
    private int source;
    private int target;


    public GraphBfsSingle1(Graph g, int source, int target) {
        this.g = g;
        this.source = source;
        this.target = target;

        this.visited = new boolean[g.getV()];
        this.prevs = new int[g.getV()];
        Arrays.fill(this.prevs, -1);

        bfs(source, target);

    }

    private void bfs(int v, int target) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        visited[v] = true;

        prevs[v] = v;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            //找到即返回
            if (curr == target) return;
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

    public boolean isConnected() {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合法 or 超出范围");
    }

    public List<Integer> path() {
        validateVertex(target);
        //源顶点到不了目标顶点，直接返回
        if (!isConnected()) return new ArrayList<>(0);
        ArrayList<Integer> res = new ArrayList<>();
        //根据 prevs 信息找到路径
        int temp = target;
        while (temp != source) {
            res.add(temp);
            temp = prevs[temp];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/bfs/graph-bfs.txt");
        GraphBfsSingle1 graphBfs = new GraphBfsSingle1(g, 0, 6);
        System.out.println(graphBfs.path());
    }
}
