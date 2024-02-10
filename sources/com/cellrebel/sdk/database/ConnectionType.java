package com.cellrebel.sdk.database;

import com.facebook.internal.AnalyticsEvents;

public enum ConnectionType {
    TWO_G("2G"),
    THREE_G("3G"),
    FOUR_G("4G"),
    FOUR_G_CA("4G_CA"),
    FIVE_G("5G"),
    WIFI("WiFi"),
    CELLULAR("Cellular"),
    NR_NSA("NR_NSA"),
    NR_NSA_MMWAVE("NR_NSA_MMWAVE"),
    NR_SA("NR_SA"),
    NR_SA_MMWAVE("NR_SA_MMWAVE"),
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    
    final String a;

    private ConnectionType(String str) {
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
