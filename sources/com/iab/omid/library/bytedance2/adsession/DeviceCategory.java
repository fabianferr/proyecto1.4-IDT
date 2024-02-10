package com.iab.omid.library.bytedance2.adsession;

public enum DeviceCategory {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER("other");
    
    private final String deviceCategory;

    private DeviceCategory(String str) {
        this.deviceCategory = str;
    }

    public String toString() {
        return this.deviceCategory;
    }
}
