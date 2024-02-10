package com.iab.omid.library.ironsrc.adsession;

public enum DeviceCategory {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER("other");
    
    private final String deviceCategory;

    private DeviceCategory(String str) {
        this.deviceCategory = str;
    }

    public final String toString() {
        return this.deviceCategory;
    }
}
