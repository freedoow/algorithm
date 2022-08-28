package com.course.graph.dfs.conect;

import com.course.graph.Graph;
import com.course.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author freed
 * @Description: 联通分量
 * @Date 2022-08-18
 */
public class ConnectedComponentCountOptimize {
    private Graph g;
    private List<Integer> res;
    private int[] visited;
    private int count = 0;


    public ConnectedComponentCountOptimize(Graph g) {
        this.g = g;
        if (g == null) return;
        this.res = new ArrayList<>();
        this.visited = new int[g.getV()];

        Arrays.fill(visited, -1);

        for (int i = 0; i < g.getV(); i++) {
            if (visited[i] == -1) {
                count++;
                dfs(i, count);
            }
        }
    }

    //联通分量个数
    public int getCount() {
        return count;
    }

    private void dfs(int v, int key) {
        res.add(v);
        visited[v] = key;
        for (Integer w : g.getTargetVAllV(v)) {
            if (visited[w] == -1) {
                dfs(w, key);
            }
        }
    }


    public List<Integer> getRes() {
        return res;
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

        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs-cc.txt");
        ConnectedComponentCountOptimize graphDfs = new ConnectedComponentCountOptimize(g);
        System.out.println(graphDfs.getRes());
        System.out.println(graphDfs.getCount());
        System.out.println(Arrays.toString(graphDfs.components()));
        System.out.println(graphDfs.isConnected(0,4));
        System.out.println(graphDfs.isConnected(0,6));

    }
}