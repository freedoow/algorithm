package com.course.a.graph.weighted.edge;

import com.course.a.graph.dfs.conect.ConnectedComponentCountOptimize;
import com.course.a.graph.weighted.WeightEdAdjacentHashList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author freed
 * @Description: 小顶堆实现Prim算法
 * @Date 2022-08-28
 */
public class PrimMinStack {
    private WeightEdAdjacentHashList g;
    private List<WeightedEdge> result;

    public PrimMinStack(WeightEdAdjacentHashList g) {
        this.g = g;
        this.result = new ArrayList<>();

        //g是连通图
        ConnectedComponentCountOptimize cdp = new ConnectedComponentCountOptimize(g);
        if (cdp.getCount() > 1) return;

        //prim
        boolean[] visited = new boolean[g.getV()];
        //选择顶点0位切分一部分
        visited[0] = true;

        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();
        for (Integer w : g.getTargetVAllV(0)) {
            pq.add(new WeightedEdge(0, w, g.getWeight(0, w)));
        }
        while (!pq.isEmpty()) {
            //1、最小横切边
            WeightedEdge minEdge = pq.poll();
            //不是横切边
            if (visited[minEdge.getV()] && visited[minEdge.getW()]) continue;
            //2、加入最小生成树
            result.add(minEdge);

            //3、扩展切分
            int newV = visited[minEdge.getV()] ? minEdge.getW() : minEdge.getV();
            visited[newV] = true;
            //放入队列
            for (Integer w : g.getTargetVAllV(newV)) {
                if (!visited[w]) pq.add(new WeightedEdge(newV, w, g.getWeight(newV, w)));
            }
        }
    }

    public List<WeightedEdge> getResult() {
        return result;
    }


    public static void main(String[] args) {
        WeightEdAdjacentHashList g = new WeightEdAdjacentHashList("/Users/whb/code/algo/algorithm/data/weighted/edge/prim.txt");
        PrimMinStack primOptimize = new PrimMinStack(g);


        List<WeightedEdge> result = primOptimize.getResult();
        for (WeightedEdge weightedEdge : result) {
            System.out.println(weightedEdge);
        }
    }
}
