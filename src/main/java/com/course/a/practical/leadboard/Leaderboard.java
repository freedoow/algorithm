package com.course.a.practical.leadboard;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-30
 */
public interface Leaderboard {
    /**
     * 记录每个参赛者的分数
     * 逻辑：
     * 1. 假如参赛者已经在排行榜中，就给他的当前得分增加 score 分值并更新排行
     * 2. 假如参赛者不在排行榜中，就把他添加到排行榜，并将分数设置为 score
     *
     * @param playerId 参赛者 Id，唯一标识一个参赛者
     * @param score    本次参赛者得分
     */
    public void addScore(int playerId, int score);

    /**
     * 返回前 k 名参赛者的得分总和
     *
     * @param k
     * @return
     */
    public int top(int k);

    /**
     * 将指定参赛者的成绩清零
     *
     * @param playerId
     */
    public void reset(int playerId);

}
