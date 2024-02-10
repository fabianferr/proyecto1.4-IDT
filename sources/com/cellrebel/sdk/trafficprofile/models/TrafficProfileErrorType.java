package com.cellrebel.sdk.trafficprofile.models;

public enum TrafficProfileErrorType {
    SERVER_SELECTION_FAILURE(0),
    TIME_SYNC_FAILURE(1),
    DOWNLINK_FAILURE(2),
    UPLINK_FAILURE(3),
    UDP_CONNECTION_FAILURE(4),
    TRAFFIC_PROFILE_TIMEOUT(5),
    TRAFFIC_PROFILE_INTERRUPTED(6);
    
    private final int a;

    private TrafficProfileErrorType(int i2) {
        this.a = i2;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
