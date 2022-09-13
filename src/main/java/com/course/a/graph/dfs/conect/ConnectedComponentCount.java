package com.course.a.graph.dfs.conect;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description: 联通分量
 * @Date 2022-08-18
 */
public class ConnectedComponentCount {
    private Graph g;
    private List<Integer> res;
    private boolean[] visited;
    private int count = 0;


    public ConnectedComponentCount(Graph g) {
        this.g = g;
        if (g == null) return;
        this.res = new ArrayList<>();
        this.visited = new boolean[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
    }

    public int getCount() {
        return count;
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

        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-cc.txt");
        ConnectedComponentCount graphDfs = new ConnectedComponentCount(g);
        System.out.println(graphDfs.getRes());
        System.out.println(graphDfs.getCount());
    }
}