package com.startapp.sdk.adsbase.adrules;

import com.startapp.d9;
import java.io.Serializable;

/* compiled from: Sta */
public class AdaptMetaData implements Serializable {
    public static transient AdaptMetaData a = new AdaptMetaData();
    @d9(complex = true)
    private AdRules adRules = new AdRules();
    private String adaptMetaDataUpdateVersion = "4.11.0";

    private AdaptMetaData() {
    }

    public AdRules a() {
        return this.adRules;
    }
}
