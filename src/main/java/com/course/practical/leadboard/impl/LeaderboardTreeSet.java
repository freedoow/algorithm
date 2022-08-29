package com.course.practical.leadboard.impl;

import com.course.practical.leadboard.Leaderboard;
import com.course.practical.leadboard.Player;

import java.util.*;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-30
 */
public class LeaderboardTreeSet implements Leaderboard {

    private HashMap<Integer, Player> map;
    private TreeSet<Player> players;

    public LeaderboardTreeSet() {
        this.map = new HashMap<>();
        players = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getScores() == o2.getScores() ?
                        o1.getId() - o2.getId() :
                        o2.getScores() - o1.getScores();
            }
        });
    }

    @Override
    public void addScore(int playerId, int score) {
        Player player = null;
        if (map.containsKey(playerId)) {
            player = map.get(playerId);
            players.remove(player);
            player.setScores(player.getScores() + score);
        } else {
            player = new Player(playerId, score);
            map.put(playerId, player);
        }
        players.add(player);
    }

    @Override
    public int top(int k) {
        Iterator<Player> it = players.iterator();
        int sum = 0;
        // O(k)
        while (it.hasNext() && k > 0) {
            sum += it.next().getScores();
            k--;
        }
        return sum;
    }

    @Override
    public void reset(int playerId) {
        if (map.containsKey(playerId)) {
            players.remove(map.get(playerId));
            map.remove(playerId);
        }
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new LeaderboardTreeSet();
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
