package com.course.highlevel.set;

/**
 * @author freed
 * @Description:
 * @Date 2022-07-30
 */
public class Item<E> {
    E data;
    boolean isDeleted;

    public Item(E data) {
        this.data = data;
        this.isDeleted = false;
    }


    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "data=" + data +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
