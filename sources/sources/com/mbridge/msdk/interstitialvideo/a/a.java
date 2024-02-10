package com.mbridge.msdk.interstitialvideo.a;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.r;
import com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DecoratorInterstitialListener */
public final class a implements InterVideoOutListener {
    private InterstitialVideoListener a;
    private String b;
    private boolean c;

    public a(InterstitialVideoListener interstitialVideoListener) {
        this.a = interstitialVideoListener;
    }

    public a(InterstitialVideoListener interstitialVideoListener, String str, boolean z) {
        this.a = interstitialVideoListener;
        this.b = str;
        this.c = z;
    }

    public final void onAdShow(String str, MBridgeIds mBridgeIds) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onAdShow(mBridgeIds);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().g(this.b, "iv", this.c);
            }
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

    public final void onAdClose(String str, MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onAdClose(mBridgeIds, rewardInfo);
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
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onShowFail(mBridgeIds, str2);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().b(this.b, str2, "iv", this.c);
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
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onVideoComplete(mBridgeIds);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onAdCloseWithIVReward(mBridgeIds, rewardInfo);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onEndcardShow(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onVideoLoadFail(mBridgeIds, str);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().a(this.b, str, "iv", this.c);
            }
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onVideoLoadSuccess(mBridgeIds);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().c(this.b, "iv", this.c);
            }
        }
    }

    public final void onLoadSuccess(String str, MBridgeIds mBridgeIds) {
        InterstitialVideoListener interstitialVideoListener = this.a;
        if (interstitialVideoListener != null) {
            interstitialVideoListener.onLoadSuccess(mBridgeIds);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().b(this.b, "iv", this.c);
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    str = mBridgeIds.getLocalRequestId();
                }
                HashMap hashMap = new HashMap();
                if (TextUtils.isEmpty(str)) {
                    hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
                }
                m.a().a("2000127", str, (Map<String, String>) hashMap);
            } catch (Exception unused) {
            }
        }
    }
}
