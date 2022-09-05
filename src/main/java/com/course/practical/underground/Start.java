package com.course.practical.underground;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-05
 */
public class Start {
    private String station;
    private int time;

    public Start(String station, int time) {
        this.station = station;
        this.time = time;
    }

    public String getStation() {
        return station;
    }

    public int getTime() {
        return time;
    }
}
