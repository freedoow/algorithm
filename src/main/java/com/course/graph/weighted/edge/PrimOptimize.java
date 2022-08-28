package com.course.graph.weighted.edge;

import com.course.graph.dfs.conect.ConnectedComponentCountOptimize;
import com.course.graph.weighted.WeightEdAdjacentHashList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-28
 */
public class PrimOptimize {
    private WeightEdAdjacentHashList g;
    private List<WeightedEdge> result;

    public PrimOptimize(WeightEdAdjacentHashList g) {
        this.g = g;
        this.result = new ArrayList<>();

        //g是连通图
        ConnectedComponentCountOptimize cdp = new ConnectedComponentCountOptimize(g);
        if (cdp.getCount() > 1) return;

        //prim
        boolean[] visited = new boolean[g.getV()];
        //选择顶点0位切分一部分
        visited[0] = true;

        for (int i = 0; i < g.getV() - 1; i++) {
            WeightedEdge minEdge = new WeightedEdge(-1, -1, Integer.MAX_VALUE);
            for (int v = 0; v < g.getV(); v++) {
                if (visited[v]) {
                    for (Integer w : g.getTargetVAllV(v)) {
                        // v - w 横切边
                        int vwWeight = g.getWeight(v, w);
                        //找到最小边
                        if (!visited[w] && vwWeight < minEdge.getWeight()) minEdge = new WeightedEdge(v, w, vwWeight);
                    }
                }
            }
            result.add(minEdge);

            //扩展切分
            int v = minEdge.getV();
            int w = minEdge.getW();
//            int newV = visited[v] ? w : v;
//            visited[newV] = true;
            visited[v] = true;
            visited[w] = true;

        }
    }

    public List<WeightedEdge> getResult() {
        return result;
    }


    public static void main(String[] args) {
        WeightEdAdjacentHashList g = new WeightEdAdjacentHashList("/Users/whb/code/algo/algorithm/data/weighted/edge/prim.txt");
        PrimOptimize primOptimize = new PrimOptimize(g);


        List<WeightedEdge> result = primOptimize.getResult();
        for (WeightedEdge weightedEdge : result) {
            System.out.println(weightedEdge);
        }
    }
}
