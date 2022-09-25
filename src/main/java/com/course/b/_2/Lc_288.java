package com.course.b._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-21
 */
public class Lc_288 {

    public  static  List<String> summaryRanges(int[] nums) {
        ArrayList<String> resList = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {

            int low = i;
            i++;
            //找到非连续的点
            while (i < nums.length && nums[i] - nums[i - 1] == 1) i++;

            int high = i - 1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(nums[high]);
            }
            resList.add(sb.toString());
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(Lc_288.summaryRanges(nums));
    }
}
