package com.course.a.graph.weighted.dijkstra;

import com.course.a.graph.weighted.WeightEdAdjacentHashList;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-28
 */
public class DijkstraOptimize {
    private WeightEdAdjacentHashList g;
    private int source;

    private int[] distance;
    private boolean[] visited;

    public DijkstraOptimize(WeightEdAdjacentHashList g, int source) {
        this.g = g;
        this.source = source;

        distance = new int[g.getV()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        visited = new boolean[g.getV()];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            //1、找到当前没有访问的最短路径节点
            int curr = pq.poll().v;
            if (visited[curr]) continue;

            //2、确认这个节点的最短路径就是当前大小
            visited[curr] = true;

            //3、根据最短路径大小，更新其他节点的路径长度
            for (Integer w : g.getTargetVAllV(curr)) {
                //没有被访问过 且当前节点到达顶点举例 比之前直线距离还近 更新
                if (!visited[w] && ((distance[curr] + g.getWeight(curr, w)) < distance[w])) {
                    distance[w] = distance[curr] + g.getWeight(curr, w);
                    pq.add(new Pair(w, distance[w]));
                }
            }
        }
    }

    public int minDistanceToV(int v) {
        validateVertex(v);
        return distance[v];
    }

    public void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合格");
    }

    public static void main(String[] args) {
        WeightEdAdjacentHashList g = new WeightEdAdjacentHashList("/Users/whb/code/algo/algorithm/data/weighted/dijkstra.txt");
        DijkstraOptimize dijkstra = new DijkstraOptimize(g, 0);
        System.out.println(dijkstra.minDistanceToV(1));
    }
}
