package com.course.a.graph.weighted.dijkstra;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-28
 */
public class Pair implements Comparable<Pair> {
    int v;
    int distance;

    public Pair(int v, int distance) {
        this.v = v;
        this.distance = distance;
    }

    @Override
    public int compareTo(Pair o) {
        return distance - o.distance;
    }
}
