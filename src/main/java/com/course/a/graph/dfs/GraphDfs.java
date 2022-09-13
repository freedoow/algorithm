package com.course.a.graph.dfs;

import com.course.a.graph.Graph;
import com.course.a.graph.impl.AdjacentHashList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-17
 */
public class GraphDfs {
    private Graph g;

    public GraphDfs(Graph g) {
        this.g = g;
    }



    //优化hash 高效判重
    public ArrayList<Integer> dfs1(int v) {
        ArrayList<Integer> res = new ArrayList<>();
        if (g == null) return res;

        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        HashMap<Integer, Integer> map = new HashMap<>();
        //优化是否访问
        boolean[] visited = new boolean[g.getV()];
        visited[v] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);
            map.put(curr, curr);
            for (int w : g.getTargetVAllV(curr)) {//升序
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
        return res;
    }

    //遍历
    public ArrayList<Integer> dfs(int v) {
        ArrayList<Integer> res = new ArrayList<>();
        if (g == null) return res;

        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);
            map.put(curr, curr);
            for (int w : g.getTargetVAllV(curr)) {//升序
                if (!map.containsKey(w)) {
                    stack.push(w);
                    map.put(w, w);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Graph g = new AdjacentHashList("/Users/whb/code/algo/algorithm/data/graph-dfs.txt");
        GraphDfs graphDfs = new GraphDfs(g);
        System.out.println(graphDfs.dfs1(0));
    }
}