package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbbanner.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBBannerView extends RelativeLayout implements BaseExtraInterfaceForHandler {
    private String bidToken;
    /* access modifiers changed from: private */
    public a controller;
    private boolean hadAttached;
    private boolean isVisible;
    private BannerAdListener mBannerAdListener;
    private MBridgeIds mBridgeIds;
    private String unitId;

    public MBBannerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hadAttached = false;
        this.isVisible = false;
        b.d().a(context);
    }

    public void init(BannerSize bannerSize, String str, String str2) {
        this.unitId = str2;
        this.mBridgeIds = new MBridgeIds(str, str2);
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        a aVar = new a(this, bannerSize, str, str2);
        this.controller = aVar;
        aVar.c(this.isVisible);
        this.controller.b(this.hadAttached);
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.controller;
        return aVar != null ? aVar.b() : "";
    }

    public void updateBannerSize(BannerSize bannerSize) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerSize);
        }
    }

    public void setRefreshTime(int i) {
        a aVar = this.controller;
        if (aVar != null && i >= 0) {
            aVar.a(i);
        }
    }

    public void setAllowShowCloseBtn(boolean z) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void load() {
        String md5 = SameMD5.getMD5(af.c());
        try {
            this.mBridgeIds.setLocalRequestId(md5);
            com.mbridge.msdk.mbbanner.common.d.a.a("2000123", this.unitId, md5, "banner_load", 296);
        } catch (Exception unused) {
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
            this.controller.a("", md5);
            return;
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.mBridgeIds, "banner controler init error，please check it");
        }
    }

    public void loadFromBid(String str) {
        this.bidToken = str;
        String reportLoadEvent = reportLoadEvent(str);
        if (this.controller == null) {
            BannerAdListener bannerAdListener = this.mBannerAdListener;
            if (bannerAdListener != null) {
                bannerAdListener.onLoadFailed(this.mBridgeIds, "banner controler init error，please check it");
            }
        } else if (!TextUtils.isEmpty(str)) {
            this.controller.b(this.hadAttached);
            this.controller.a(0);
            this.controller.a(str, reportLoadEvent);
        } else {
            BannerAdListener bannerAdListener2 = this.mBannerAdListener;
            if (bannerAdListener2 != null) {
                bannerAdListener2.onLoadFailed(this.mBridgeIds, "banner token is null or empty，please check it");
            }
        }
    }

    private String reportLoadEvent(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split != null && split.length >= 3) {
                    str = split[2];
                }
            } else {
                str = SameMD5.getMD5(af.c());
            }
            String str2 = str;
            this.mBridgeIds.setLocalRequestId(str2);
            com.mbridge.msdk.mbbanner.common.d.a.a("2000123", this.unitId, str2, "hb_banner_load", 296);
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerAdListener);
        }
    }

    public void release() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener = null;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((BannerAdListener) null);
            this.controller.c();
        }
        b.d().a(this.unitId);
        removeAllViews();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAttachedState(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAttachedState(false);
        try {
            m.a().a("2000151", this.mBridgeIds, (Map<String, String>) new HashMap());
        } catch (Exception unused) {
        }
    }

    private void updateAttachedState(boolean z) {
        this.hadAttached = z;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisible = i == 0;
        if (this.controller == null) {
            return;
        }
        if (i == 0) {
            delayedNotify();
        } else if (!com.mbridge.msdk.foundation.c.b.c) {
            this.controller.c(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.isVisible = i == 0;
        if (this.controller == null) {
            return;
        }
        if (i == 0) {
            delayedNotify();
        } else if (!com.mbridge.msdk.foundation.c.b.c) {
            this.controller.c(false);
        }
    }

    private void delayedNotify() {
        postDelayed(new Runnable() {
            public void run() {
                if (MBBannerView.this.controller != null && !com.mbridge.msdk.foundation.c.b.c) {
                    MBBannerView.this.controller.c(true);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    public void onPause() {
        if (this.controller != null && TextUtils.isEmpty(this.bidToken)) {
            this.controller.e();
        }
    }

    public void onResume() {
        if (this.controller != null && TextUtils.isEmpty(this.bidToken) && !com.mbridge.msdk.foundation.c.b.c) {
            this.controller.f();
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        b.d().a(this.unitId, jSONObject);
    }
}
