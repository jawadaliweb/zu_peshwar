package com.lmkt.zupeshawar.model;

public class LeaderBoardModel {
    private String cnic;
    private String endDate;
    private String id;
    private String mobileNumber;
    private String name;
    private String period;
    private String startDate;
    private int usage;
    private String userID;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String str) {
        this.period = str;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getCnic() {
        return this.cnic;
    }

    public void setCnic(String str) {
        this.cnic = str;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public int getUsage() {
        return this.usage;
    }

    public void setUsage(int i) {
        this.usage = i;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }
}
