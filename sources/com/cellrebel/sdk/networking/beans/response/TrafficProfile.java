package com.cellrebel.sdk.networking.beans.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TrafficProfile {
    @SerializedName("downlinkProfile")
    @Expose
    public List<List<Integer>> downlinkProfile;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("uplinkProfile")
    @Expose
    public List<List<Integer>> uplinkProfile;
    @SerializedName("weight")
    @Expose
    public Integer weight;

    public TrafficProfile(String str, List<List<Integer>> list, List<List<Integer>> list2, Integer num) {
        this.name = str;
        this.downlinkProfile = list;
        this.uplinkProfile = list2;
        this.weight = num;
    }
}
