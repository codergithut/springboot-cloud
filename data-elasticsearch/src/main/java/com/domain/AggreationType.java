package com.domain;

public enum AggreationType {

    /**
     *  常见聚合统计
     */
    TERMS("terms", 1), AVERAGE("average", 2), SUM("sum", 3), MAX("max", 4), MIN("min", 5);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private AggreationType(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (AggreationType c : AggreationType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}