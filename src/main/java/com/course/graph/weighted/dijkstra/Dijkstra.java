package com.course.graph.weighted.dijkstra;

import com.course.graph.weighted.WeightEdAdjacentHashList;

import java.util.Arrays;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-28
 */
public class Dijkstra {
    private WeightEdAdjacentHashList g;
    private int source;

    private int[] distance;
    private boolean[] visited;

    public Dijkstra(WeightEdAdjacentHashList g, int source) {
        this.g = g;
        this.source = source;

        distance = new int[g.getV()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        visited = new boolean[g.getV()];
        while (true) {
            //1、找到当前没有访问的最短路径节点
            int currDistance = Integer.MAX_VALUE;
            int curr = -1;

            for (int v = 0; v < g.getV(); v++) {
                if (!visited[v] && distance[v] < currDistance){
                    currDistance = distance[v];
                    curr = v;
                }
            }
            if (curr == -1) break;
            //2、确认这个节点的最短路径就是当前大小
            visited[curr] = true;
            //3、根据最短路径大小，更新其他节点的路径长度
            for (Integer w : g.getTargetVAllV(curr)) {
                //没有被访问过 且当前节点到达顶点举例 比之前直线距离还近 更新
                if (!visited[w] && ((distance[curr] + g.getWeight(curr, w)) < distance[w])) distance[w] = distance[curr] + g.getWeight(curr, w);
            }
        }
    }
    public int minDistanceToV(int v){
        validateVertex(v);
        return distance[v];
    }



    public void validateVertex(int v){
        if (v <0 && v >=g.getV()) throw new RuntimeException("顶点不合格");
    }

    public static void main(String[] args) {
        WeightEdAdjacentHashList g = new WeightEdAdjacentHashList("/Users/whb/code/algo/algorithm/data/weighted/dijkstra.txt");
        Dijkstra dijkstra = new Dijkstra(g, 0);
        System.out.println(dijkstra.minDistanceToV(1));
    }
}
