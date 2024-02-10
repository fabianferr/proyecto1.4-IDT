package com.mbridge.msdk.newinterstitial.a;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.r;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DecoratorInterstitialListener */
public final class a implements InterVideoOutListener {
    private NewInterstitialListener a;
    private String b;
    private boolean c;

    public a(NewInterstitialListener newInterstitialListener) {
        this.a = newInterstitialListener;
    }

    public a(NewInterstitialListener newInterstitialListener, String str, boolean z) {
        this.a = newInterstitialListener;
        this.b = str;
        this.c = z;
    }

    public final void onAdShow(String str, MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdShow(mBridgeIds);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().g(this.b, "niv", this.c);
                try {
                    HashMap hashMap = new HashMap();
                    if (TextUtils.isEmpty(str)) {
                        hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
                    }
                    m.a().a("2000130", str, (Map<String, String>) hashMap);
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void onAdClose(String str, MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdClose(mBridgeIds, rewardInfo);
            try {
                HashMap hashMap = new HashMap();
                if (TextUtils.isEmpty(str)) {
                    hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
                }
                m.a().a("2000152", str, (Map<String, String>) hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public final void onShowFail(String str, MBridgeIds mBridgeIds, String str2) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onShowFail(mBridgeIds, str2);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().b(this.b, str2, "niv", this.c);
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("code", "");
                hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str2);
                hashMap.put("failingURL", "");
                if (TextUtils.isEmpty(str)) {
                    hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
                }
                m.a().a("2000131", str, (Map<String, String>) hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public final void onVideoAdClicked(boolean z, MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onVideoComplete(mBridgeIds);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdCloseWithNIReward(mBridgeIds, rewardInfo);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onEndcardShow(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onResourceLoadFail(mBridgeIds, str);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().a(this.b, str, "niv", this.c);
            }
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onResourceLoadSuccess(mBridgeIds);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().c(this.b, "niv", this.c);
            }
        }
    }

    public final void onLoadSuccess(String str, MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onLoadCampaignSuccess(mBridgeIds);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().b(this.b, "niv", this.c);
                try {
                    String localRequestId = TextUtils.isEmpty(str) ? mBridgeIds.getLocalRequestId() : str;
                    HashMap hashMap = new HashMap();
                    if (TextUtils.isEmpty(str)) {
                        hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
                    }
                    m.a().a("2000127", localRequestId, (Map<String, String>) hashMap);
                } catch (Exception unused) {
                }
            }
        }
    }
}
