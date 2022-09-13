package com.course.a.practical.underground;

/**
 * @author freed
 * @Description:
 * @Date 2022-09-05
 */
public class SumAmount {
    private int sum;
    private int amount;

    public SumAmount(int sum, int amount) {
        this.sum = sum;
        this.amount = amount;
    }

    public int getSum() {
        return sum;
    }

    public int getAmount() {
        return amount;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
