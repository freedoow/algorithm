package com.course.a.line.algo.sort.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author freedoow
 * @Description: 合并区间(时间范围)[[1,5],[3,4],[4.20],[16,20]]
 * @Date 2022-02-15
 */
public class _56_MergeSegment {


    public int[][] sort(int[][] intervals) {
        //1、按照区间左边的值进行升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //2、初始化outputs, 用于存储合并之后区间结果的动态数组
        ArrayList<int[]> outputs = new ArrayList<>();
        //3、遍历处理每一个区间
        for (int i = 0; i < intervals.length; i++) {
            if (outputs.isEmpty()) {
                outputs.add(intervals[0]);
            } else { //判断是否重叠，有的话合并
                int[] outputsLastIntervals = outputs.get(outputs.size() - 1);
                int outputsLastIntervalRight = outputsLastIntervals[0];
                int currIntervalLeft = intervals[i][0];

                if (outputsLastIntervalRight < currIntervalLeft) { //没有重叠
                    outputs.add(intervals[i]);
                } else {
                    int max = Math.max(outputsLastIntervalRight, intervals[i][0]);
                    outputsLastIntervals[1] = max;
                }
            }
        }
        return null;
    }
}
