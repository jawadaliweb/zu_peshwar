package com.lmkt.zupeshawar.db;

public class CategoryTB {
    public int id;
    public String name;
    public int parentID;

    public CategoryTB() {
    }

    public CategoryTB(int i, int i2, String str) {
        this.id = i;
        this.parentID = i2;
        this.name = str;
    }
}
