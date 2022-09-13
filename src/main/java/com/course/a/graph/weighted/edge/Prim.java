package com.course.a.graph.weighted.edge;

import com.course.a.graph.dfs.conect.ConnectedComponentCountOptimize;
import com.course.a.graph.weighted.WeightEdAdjacentHashList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-28
 */
public class Prim {
    private WeightEdAdjacentHashList g;
    private List<WeightedEdge> result;

    public Prim(WeightEdAdjacentHashList g) {
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
                        if (!visited[w]) {
                            // v - w 横切边
                            int vwWeight = g.getWeight(v, w);
                            // 找到最小横切边
                            if (vwWeight < minEdge.getWeight()) minEdge = new WeightedEdge(v, w, vwWeight);
                        }
                    }
                }
            }
            result.add(minEdge);

            //扩展切分
            int v = minEdge.getV();
            int w = minEdge.getW();
            int newV = visited[v] ? w : v;
            visited[newV] = true;
        }
    }

    public List<WeightedEdge> getResult() {
        return result;
    }
}
