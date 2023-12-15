package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Distance {
    @SerializedName("distance")
    @Expose
    public String distance;
    @SerializedName("time")
    @Expose
    public String time;
}
