package com.course.a.graph.impl;

import com.course.a.graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-14
 */
public class AdjacentMatrix implements Graph {
    private int V;
    private int E;
    private int[][] data;

    public AdjacentMatrix(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line = reader.readLine();
            String[] arr = line.split(" ");

            this.V = Integer.valueOf(arr[0]);
            this.E = Integer.valueOf(arr[1]);
            this.data = new int[V][V];

            while ((line = reader.readLine()) != null) {
                arr = line.split(" ");
                int a = Integer.valueOf(arr[0]);
                int b = Integer.valueOf(arr[1]);
                data[a][b] = 1;
                data[b][a] = 1;

            }


        } catch (Exception e) {

        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("顶点数 = %d，边数 = %d \n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(data[i][j] + " ");
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
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return data[v][w] == 1;
    }

    // 获取指定顶点所有相邻的顶点
    @Override
    public List<Integer> getTargetVAllV(int v) {
        validateVertex(v);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (data[v][i] == 1) list.add(i);
        }
        return list;
    }

    // 获取指定顶点的度数
    @Override
    public int degree(int v){
        return getTargetVAllV(v).size();
    }


    public static void main(String[] args) {

        AdjacentMatrix adjacentMatrix = new AdjacentMatrix("/Users/whb/code/algo/algorithm/data/graph.txt");
        System.out.println(adjacentMatrix);
    }
}
