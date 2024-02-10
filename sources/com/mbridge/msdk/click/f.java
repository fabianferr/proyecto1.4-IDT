package com.mbridge.msdk.click;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;

/* compiled from: DefaultAppletSchemeCallBack */
public final class f extends AppletSchemeCallBack {
    private final NativeListener.NativeTrackingListener a;
    private final CampaignEx b;
    private final AppletsModel c;
    private final a d;

    /* access modifiers changed from: protected */
    public final void onRequestStart() {
    }

    public f(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        this.a = nativeTrackingListener;
        this.b = campaignEx;
        this.c = appletsModel;
        this.d = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onRequestSuccess(String str) {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && this.c != null) {
            try {
                NativeListener.NativeTrackingListener nativeTrackingListener = this.a;
                if (nativeTrackingListener != null) {
                    try {
                        nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("DefaultAppletSchemeCallBack", e.getMessage());
                        }
                    }
                }
                this.c.setUserClick(false);
                this.c.setRequestingFinish();
                this.b.setDeepLinkUrl(str);
                a aVar = this.d;
                if (aVar != null) {
                    try {
                        aVar.a(this.b);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("DefaultAppletSchemeCallBack", e2.getMessage());
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("DefaultAppletSchemeCallBack", e3.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onRequestFailed(int i, String str, String str2) {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && this.c != null) {
            try {
                NativeListener.NativeTrackingListener nativeTrackingListener = this.a;
                if (nativeTrackingListener != null) {
                    try {
                        nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("DefaultAppletSchemeCallBack", e.getMessage());
                        }
                    }
                }
                this.c.setUserClick(false);
                this.c.setRequestingFinish();
                this.b.setClickURL(str2);
                a aVar = this.d;
                if (aVar != null) {
                    try {
                        aVar.a(this.b);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("DefaultAppletSchemeCallBack", e2.getMessage());
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("DefaultAppletSchemeCallBack", e3.getMessage());
                }
            }
        }
    }
}
