package com.course.a.graph.impl;

import com.course.a.graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-14
 */
public class AdjacentList implements Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] data;

    public AdjacentList(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line = reader.readLine();
            String[] arr = line.split(" ");

            this.V = Integer.valueOf(arr[0]);
            this.E = Integer.valueOf(arr[1]);
            this.data = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                data[i] = new LinkedList<>();
            }

            while ((line = reader.readLine()) != null) {
                arr = line.split(" ");
                int a = Integer.valueOf(arr[0]);
                validateVertex(a);
                int b = Integer.valueOf(arr[1]);
                validateVertex(b);

                if (a == b) throw new RuntimeException("出现了自环边，错误");
                if (data[a].contains(b)) throw new RuntimeException("出现了平行边边，错误");

                data[a].add(b);
                data[b].add(a);
            }


        } catch (Exception e) {

        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("顶点数 = %d，边数 = %d \n", V, E));
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");

            for (Integer j : data[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IllegalArgumentException(String.format("顶点 %d 不合格", v));
    }

    @Override
    public int getV() {
        return V;
    }

    @Override
    public int getE() {
        return E;
    }

    // 判断两个指定的顶点之间是否有边
    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return data[v].contains(w);
    }

    // 获取指定顶点所有相邻的顶点
    @Override
    public List<Integer> getTargetVAllV(int v) {
        validateVertex(v);
        return data[v];
    }

    // 获取指定顶点的度数
    @Override
    public int degree(int v) {
        return getTargetVAllV(v).size();
    }


    public static void main(String[] args) {

        AdjacentList adjacentMatrix = new AdjacentList("/Users/whb/code/algo/algorithm/data/graph.txt");
        System.out.println(adjacentMatrix);
    }
}
