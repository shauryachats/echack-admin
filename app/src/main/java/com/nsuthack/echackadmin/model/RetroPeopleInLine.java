package com.nsuthack.echackadmin.model;

import com.google.gson.annotations.SerializedName;

public class RetroPeopleInLine {
    @SerializedName("assemblyid")
    private Integer boothID;

    @SerializedName("count")
    private Integer count;

    public RetroPeopleInLine(Integer boothID, Integer count) {
        this.boothID = boothID;
        this.count = count;
    }

    public Integer getBoothID() {
        return boothID;
    }

    public Integer getCount() {
        return count;
    }

    public void setBoothID(Integer boothID) {
        this.boothID = boothID;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
