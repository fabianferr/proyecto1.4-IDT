package com.mbridge.msdk.scheme.applet;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;

public abstract class AppletSchemeCallBack implements IAppletSchemeCallBack {
    private static final String TAG = "AppletSchemeCallBack";

    /* access modifiers changed from: protected */
    public abstract void onRequestFailed(int i, String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void onRequestStart();

    /* access modifiers changed from: protected */
    public abstract void onRequestSuccess(String str);

    public void onAppletSchemeRequestStart() {
        try {
            onRequestStart();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    public void onAppletSchemeRequestSuccess(String str) {
        try {
            onRequestSuccess(str);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    public void onAppletSchemeRequestFailed(int i, String str, String str2) {
        try {
            onRequestFailed(i, str, str2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    public void onNetworkError(int i, String str, String str2) {
        try {
            onRequestFailed(i, str, str2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, e.getMessage());
            }
        }
    }
}
