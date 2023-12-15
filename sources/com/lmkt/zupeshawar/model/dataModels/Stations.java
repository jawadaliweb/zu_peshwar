package com.lmkt.zupeshawar.model.dataModels;

import com.google.gson.annotations.SerializedName;

public class Stations {
    @SerializedName("stop_name")
    public String name;
    @SerializedName("stop_id")
    public String stationID;
    public String stationLat;
    public String stationLong;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
