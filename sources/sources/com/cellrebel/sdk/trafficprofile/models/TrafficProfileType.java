package com.cellrebel.sdk.trafficprofile.models;

public enum TrafficProfileType {
    DOWNLINK(0),
    UPLINK(1);
    
    private final int a;

    private TrafficProfileType(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
