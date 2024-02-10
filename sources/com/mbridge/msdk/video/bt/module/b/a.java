package com.mbridge.msdk.video.bt.module.b;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.r;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DecoratorRewardVideoListener */
public final class a implements InterVideoOutListener {
    private g a;
    private String b;
    private boolean c;

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
    }

    public a(g gVar) {
        this.a = gVar;
    }

    public final void onAdShow(String str, MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onAdShow(mBridgeIds);
            try {
                HashMap hashMap = new HashMap();
                if (TextUtils.isEmpty(str)) {
                    hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
                }
                m.a().a("2000130", str, (Map<String, String>) hashMap);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(this.b)) {
                r.a().g(this.b, "rv", this.c);
            }
        }
    }

    public final void onAdClose(String str, MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onAdClose(mBridgeIds, rewardInfo);
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
        g gVar = this.a;
        if (gVar != null) {
            gVar.onShowFail(mBridgeIds, str2);
            if (!TextUtils.isEmpty(this.b)) {
                r.a().b(this.b, str2, "rv", this.c);
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
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoComplete(mBridgeIds);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onEndcardShow(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoLoadFail(mBridgeIds, str);
            if (mBridgeIds != null) {
                try {
                    if (!TextUtils.isEmpty(mBridgeIds.getUnitId())) {
                        r.a().a(mBridgeIds.getUnitId(), str, "rv", this.c);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoLoadSuccess(mBridgeIds);
            if (mBridgeIds != null) {
                try {
                    if (!TextUtils.isEmpty(mBridgeIds.getUnitId())) {
                        r.a().c(mBridgeIds.getUnitId(), "rv", this.c);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final void onLoadSuccess(String str, MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onLoadSuccess(mBridgeIds);
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
            if (!TextUtils.isEmpty(this.b)) {
                r.a().b(this.b, "rv", this.c);
            }
        }
    }
}
