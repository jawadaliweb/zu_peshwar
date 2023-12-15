package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BicycleStandModel {
    @SerializedName("id")
    @Expose
    public int id = 1032;
    @SerializedName("lat")
    @Expose
    public double lat = 27.2038d;
    @SerializedName("lon")
    @Expose
    public double lon = 77.5011d;
    @SerializedName("name")
    @Expose
    public String name = "Office";
    @SerializedName("rentCount")
    @Expose
    public int rentCount = 0;
    @SerializedName("restoreCount")
    @Expose
    public int restoreCount = 1;
}
