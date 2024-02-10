package com.cellrebel.sdk.trafficprofile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TrafficProfile {
    @SerializedName("id")
    @Expose
    public int a;
    @Expose(serialize = false)
    public String b;
    @SerializedName("flows")
    @Expose
    public List<TrafficProfileConfig> c;
    @Expose(serialize = false)
    public List<TrafficProfileConfig> d;
    @Expose(serialize = false)
    public int e;

    public TrafficProfile(int i, String str, List<TrafficProfileConfig> list, List<TrafficProfileConfig> list2, int i2) {
        this.a = i;
        this.b = str;
        this.c = list;
        this.d = list2;
        this.e = i2;
    }
}
