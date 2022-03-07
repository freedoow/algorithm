package com.course.line.algo.sort.train;


/**
 * @author freedoow
 * @Description:
 * @Date 2022-02-27
 */
public class _lc_164 {
    public static int Sort(int[] data) {

        // Arrays.sort(data);
//        基数排序
//        RadixSorter.sort(data);
//        int max = 0;
//        for (int i = 0; i < data.length - 1; i++) {
//            max = Math.max(max, data[i + 1] - data[i]);
//        }
//        return max;
        return maximumGam(data);

    }


    private static int maximumGam(int[] data) {

        //找到最大值和最小值
        int max = data[0];
        int min = data[0];
        for (int i = 0; i < data.length; i++) {
            max = Math.max(max, data[i]);
            min = Math.min(min, data[i]);
        }
        if (max == min) return 0;

        //TODO 重点
        int gap = (int) Math.ceil((double) (max - min) / (data.length - 1));

        // 初始化桶数组
        int bucketNum = data.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        //将元素添加到桶里
        for (int num : data) {
            //TODO 重点
            int bucketId = (num - min) / gap;
            buckets[bucketId].hasData = true;
            buckets[bucketId].min = Math.min(buckets[bucketId].min, num);
            buckets[bucketId].max = Math.max(buckets[bucketId].max, num);
        }

        //算桶之间的间距
        int maxGap = 0;
        int prevMax = min;
        for (Bucket bucket : buckets) {
            if (!bucket.hasData) continue;
            maxGap = Math.max(maxGap, bucket.min - prevMax);
            prevMax = bucket.max;
        }
        return maxGap;
    }


    private static class Bucket {
        public boolean hasData = false;
        public int min = Integer.MAX_VALUE;
        public int max = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] data = new int[]{20, 2, 10, 24, 43};
        System.out.println(_lc_164.Sort(data));
    }

}
