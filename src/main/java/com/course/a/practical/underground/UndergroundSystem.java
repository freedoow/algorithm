package com.course.a.practical.underground;


import java.util.HashMap;

/**
 * @author whb
 * @Description:
 * @Date 2022-08-30
 */
public class UndergroundSystem {
    //维护每个乘客的起始站信息
    private HashMap<Integer, Start> startInfo;
    //维护两个站的乘客信息：所有的乘客数，以及所有乘客花的时间
    private HashMap<StartEnd, SumAmount> table;

    public void checkIn(int id, String stationName, int t) {
        startInfo.put(id, new Start(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        //起始点
        Start start = startInfo.get(id);

        //花费时间
        StartEnd key = new StartEnd(start.getStation(), stationName);
        SumAmount sumAmount = table.getOrDefault(key, new SumAmount(0, 0));
        sumAmount.setAmount(sumAmount.getAmount() + 1);
        sumAmount.setSum(sumAmount.getSum() + (t - start.getTime()));

        table.put(key, sumAmount);
    }


    public double getAverageTime(String startStation, String endStation) {
        StartEnd key = new StartEnd(startStation, endStation);
        SumAmount sumAmount = table.get(key);
        int sum = sumAmount.getSum();
        int amount = sumAmount.getAmount();
        return 1.0 * sum / amount;
    }
}
