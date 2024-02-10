package com.appnext.nativeads.designed_native_ads;

import android.content.Context;
import com.appnext.nativeads.NativeAdObject;

public class DesignNativeAdObject extends NativeAdObject {
    public static final String AUID = "950";

    public String getAUID() {
        return AUID;
    }

    public DesignNativeAdObject(Context context, String str) {
        super(context, str);
    }
}
