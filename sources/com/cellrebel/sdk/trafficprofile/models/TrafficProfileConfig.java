package com.cellrebel.sdk.trafficprofile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TrafficProfileConfig {
    @SerializedName("id")
    @Expose
    public int a;
    @SerializedName("segments")
    @Expose
    public List<TrafficProfileSegment> b;

    public TrafficProfileConfig(int i, List<TrafficProfileSegment> list) {
        this.a = i;
        this.b = list;
    }
}
