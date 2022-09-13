package com.course.a.practical.leadboard.impl;

import com.course.a.practical.leadboard.Leaderboard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-30
 */
public class LeaderboardHashMap implements Leaderboard {

    private HashMap<Integer, Integer> map;

    public LeaderboardHashMap() {
        this.map = new HashMap<>();
    }

    @Override
    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) map.put(playerId, map.get(playerId) + score);
        else map.put(playerId, score);
    }

    @Override
    public int top(int k) {
        // 1. 按照分数降序排序
        Integer[] scores = map.values().toArray(new Integer[map.values().size()]);
        // O(nlogn) - 性能瓶颈
        Arrays.sort(scores, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 2. 拿到前 k 名的分数，累加
        // O(k)
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += scores[i];
        }

        return sum;
    }

    @Override
    public void reset(int playerId) {
        if (map.containsKey(playerId)) map.remove(playerId);
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new LeaderboardHashMap();
        leaderboard.addScore(1, 20);
        leaderboard.addScore(2, 30);
        leaderboard.addScore(3, 16);
        leaderboard.addScore(4, 44);

        System.out.println(leaderboard.top(2));

        leaderboard.addScore(2, 34);
        leaderboard.addScore(3, 23);

        System.out.println(leaderboard.top(1));

        leaderboard.reset(2);
        leaderboard.reset(4);

        System.out.println(leaderboard.top(1));
    }
}
