package com.course.a.graph.weighted.dijkstra;

import com.course.a.graph.weighted.WeightEdAdjacentHashList;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-28
 */
public class DijkstraMinPath {
    private WeightEdAdjacentHashList g;
    private int source;

    private int[] distance;
    private boolean[] visited;

    private int[] prevs;

    public DijkstraMinPath(WeightEdAdjacentHashList g, int source) {
        this.g = g;
        this.source = source;

        distance = new int[g.getV()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        visited = new boolean[g.getV()];

        prevs = new int[g.getV()];
        Arrays.fill(prevs, -1);

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
                    prevs[w] = curr;
                }
            }
        }
    }

    public int minDistanceToV(int v) {
        validateVertex(v);
        return distance[v];
    }

    public List<Integer> path(int target) {
        validateVertex(target);
        //源顶点到不了目标顶点，直接返回
        if (!isConnected(target)) return new ArrayList<>(0);
        ArrayList<Integer> res = new ArrayList<>();
        //根据 prevs 信息找到路径
        while (target != source) {
            res.add(target);
            target = prevs[target];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }

    private boolean isConnected(int target) {
        validateVertex(target);
        return visited[target];
    }

    public void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) throw new RuntimeException("顶点不合格");
    }

    public static void main(String[] args) {
        WeightEdAdjacentHashList g = new WeightEdAdjacentHashList("/Users/whb/code/algo/algorithm/data/weighted/dijkstra.txt");
        DijkstraMinPath dijkstra = new DijkstraMinPath(g, 0);
        System.out.println(dijkstra.minDistanceToV(1));
        System.out.println(dijkstra.path(1));
    }
}
