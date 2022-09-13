package com.course.a.graph.direct;

import com.course.a.graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author freed
 * @Description: 有权图
 * @Date 2022-08-14
 */
public class WeightEdAdjacentHash implements Graph {
    private int V;
    private int E;
    private HashMap<Integer, Integer>[] data;
    private boolean isDirected;

    private int[] inDegress;
    private int[] outDegress;

    public WeightEdAdjacentHash(String name, boolean isDirected) {
        this.isDirected = isDirected;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line = reader.readLine();
            String[] arr = line.split(" ");

            this.V = Integer.valueOf(arr[0]);
            this.E = Integer.valueOf(arr[1]);
            this.data = new HashMap[V];
            for (int i = 0; i < V; i++) {
                data[i] = new HashMap<>();
            }

            this.inDegress = new int[V];
            this.outDegress = new int[V];
            while ((line = reader.readLine()) != null) {
                arr = line.split(" ");
                int a = Integer.valueOf(arr[0]);
                validateVertex(a);
                int b = Integer.valueOf(arr[1]);
                validateVertex(b);

                if (a == b) throw new RuntimeException("出现了自环边，错误");
                if (data[a].containsKey(b)) throw new RuntimeException("出现了平行边边，错误");
                int weight = Integer.valueOf(arr[2]);
                data[a].put(b, weight);
                if (!isDirected) {
                    data[b].put(a, weight);
                } else { //有向图
                    outDegress[a]++;
                    outDegress[b]++;
                }
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
            HashMap<Integer, Integer> adjMap = data[i];
            for (Map.Entry<Integer, Integer> entry : adjMap.entrySet()) {
                sb.append("(").append(entry.getKey()).append(", ").append(entry.getValue()).append(")");
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
        return data[v].containsKey(w);
    }

    // 获取指定顶点所有相邻的顶点
    @Override
    public Collection<Integer> getTargetVAllV(int v) {
        validateVertex(v);
        return data[v].keySet();
    }

    // 获取指定顶点的度数
    @Override
    public int degree(int v) {
        if (isDirected) throw new RuntimeException("无向图才可以计算");
        return getTargetVAllV(v).size();
    }

    // 获取指定边的权重值
    public int getWeight(int v, int w) {
        if (hasEdge(v, w)) {
            return data[v].get(w);
        }
        return -1;
    }

    public int[] getInDegress() {
        if (!isDirected) throw new RuntimeException("有向图才可以计算");
        return inDegress;
    }

    public int[] getOutDegress() {
        if (!isDirected) throw new RuntimeException("有向图才可以计算");
        return outDegress;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public static void main(String[] args) {
        WeightEdAdjacentHash adjacentMatrix = new WeightEdAdjacentHash("/Users/whb/code/algo/algorithm/data/weighted/graph-weighted.txt", true);
        System.out.println(adjacentMatrix.toString());
    }
}
