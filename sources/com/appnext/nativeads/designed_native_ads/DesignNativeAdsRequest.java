package com.appnext.nativeads.designed_native_ads;

import com.appnext.core.c;

public class DesignNativeAdsRequest extends c {
    private String fC = "";
    private String fD = "";
    private String mSpecificCategories = "";

    public String getCategories() {
        return this.fC;
    }

    public DesignNativeAdsRequest setCategories(String str) {
        this.fC = str;
        return this;
    }

    public String getSpecificCategories() {
        return this.mSpecificCategories;
    }

    public DesignNativeAdsRequest setSpecificCategories(String str) {
        this.mSpecificCategories = str;
        return this;
    }

    public String getPostBack() {
        return this.fD;
    }

    public DesignNativeAdsRequest setPostBack(String str) {
        this.fD = str;
        return this;
    }
}
