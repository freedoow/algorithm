package com.course.graph.bfs;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-22
 */
public class GraphBfsConnectedComponentCount {
    private Graph g;
    private int[] visited;

    private int count;

    public GraphBfsConnectedComponentCount(Graph g) {
        this.g = g;

        this.visited = new int[g.getV()];
        Arrays.fill(visited, -1);

        for (int v = 0; v < g.getV(); v++) {
            if (visited[v] == -1) {
                count++;
                bfs(v, count);
            }
        }
    }

    private void bfs(int v, int count) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = count;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Integer w : g.getTargetVAllV(curr)) {
                if (visited[w] == -1) {
                    queue.add(w);
                    visited[w] = count;
                }
            }
        }
    }

    public int getCount() {
        return count;
    }


    //所有顶点
    public List<Integer>[] components() {
        List<Integer>[] lists = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < g.getV(); i++) {
            int w = visited[i];
            lists[w - 1].add(i);
        }

        return lists;
    }

    //是否联通
    public boolean isConnected(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return visited[v] == visited[w];
    }

    private void validateVertex(int v){
        if (v<0 && v>=g.getV()){
            throw new RuntimeException("不合法");
        }
    }
    public static void main(String[] args) {
        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/bfs/graph-bfs.txt");
        GraphBfsConnectedComponentCount graphBfs = new GraphBfsConnectedComponentCount(g);
        System.out.println(graphBfs.getCount());
    }
}
