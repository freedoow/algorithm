package com.course.graph.direct.topology;

import com.course.graph.direct.AdjacentHash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-29
 */
public class Bfs {

    private AdjacentHash g;

    private int[] res;

    private boolean hasCycle = false;

    public Bfs(AdjacentHash g) {
        if (!g.isDirected()) throw new RuntimeException("有向图支持拓扑排序");
        this.g = g;

        //构建入度
        int[] inDegrees = new int[g.getV()];
        for (int v = 0; v < g.getV(); v++) {
            inDegrees[v] = g.inDegree(v);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < g.getV(); v++) {
            if (inDegrees[v] == 0) queue.add(v);
        }

        this.res = new int[g.getV()];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            res[index++] = v;

            for (Integer w : g.getTargetVAllV(v)) {
                inDegrees[w]--;
                if (inDegrees[w] == 0) queue.add(w);
            }
        }

        if (index != g.getV()) hasCycle = true;
    }

    public int[] getRes() {
        return res;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        AdjacentHash g = new AdjacentHash("/Users/whb/code/algo/algorithm/data/graph-directed.txt", true);
        Bfs graphBfs = new Bfs(g);
        System.out.println(graphBfs.isHasCycle());
        System.out.println(Arrays.toString(graphBfs.getRes()));
    }
}
