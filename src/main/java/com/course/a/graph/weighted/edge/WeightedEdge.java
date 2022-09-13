package com.course.a.graph.weighted.edge;

/**
 * @author freed
 * @Description: 最小生成数
 * @Date 2022-08-28
 */
public class WeightedEdge implements Comparable<WeightedEdge> {
    private int v;
    private int w;
    private int weight;

    public WeightedEdge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return this.weight - o.getWeight();
    }

    @Override
    public String toString() {
        return "WeightedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

}
