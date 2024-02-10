package com.mbridge.msdk.video.signal.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.h;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONObject;

public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {
    private int a = 0;
    private int b = 1;
    /* access modifiers changed from: protected */
    public Activity j;
    /* access modifiers changed from: protected */
    public String k;
    /* access modifiers changed from: protected */
    public String l;
    /* access modifiers changed from: protected */
    public c m;
    protected String n;
    protected com.mbridge.msdk.videocommon.b.c o;
    protected String p;
    protected int q = 2;
    /* access modifiers changed from: protected */
    public boolean r = false;
    protected boolean s = false;
    protected int t;
    protected int u;
    protected int v;
    /* access modifiers changed from: protected */
    public boolean w = false;
    protected IJSFactory x = new a();

    public AbstractJSContainer(Context context) {
        super(context);
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.x = iJSFactory;
    }

    public void onResume() {
        if (!b.c) {
            if (getJSCommon().b()) {
                getActivityProxy().b();
            }
            getActivityProxy().a(0);
        }
    }

    public void onPause() {
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onStop() {
        if (getJSCommon().b()) {
            getActivityProxy().c();
        }
        getActivityProxy().a(3);
    }

    public void onRestart() {
        if (getJSCommon().b()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(4);
    }

    public void onStart() {
        if (getJSCommon().b()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(2);
    }

    public void onDestroy() {
        if (getJSCommon().b()) {
            getActivityProxy().f();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public com.mbridge.msdk.video.signal.a getActivityProxy() {
        return this.x.getActivityProxy();
    }

    public com.mbridge.msdk.video.signal.c getJSCommon() {
        return this.x.getJSCommon();
    }

    public i getJSVideoModule() {
        return this.x.getJSVideoModule();
    }

    public f getJSNotifyProxy() {
        return this.x.getJSNotifyProxy();
    }

    public e getJSContainerModule() {
        return this.x.getJSContainerModule();
    }

    public h getIJSRewardVideoV1() {
        return this.x.getIJSRewardVideoV1();
    }

    public com.mbridge.msdk.video.signal.b getJSBTModule() {
        return this.x.getJSBTModule();
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        g.a().a(obj, a(this.a));
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj, String str) {
        g.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            aa.d("AbstractJSContainer", "code to string is error");
            return "";
        }
    }

    public void setRewardId(String str) {
        this.p = str;
    }

    public void setUserId(String str) {
        this.n = str;
    }

    public void setUnitId(String str) {
        this.k = str;
    }

    public String getUnitId() {
        return this.k;
    }

    public String getPlacementId() {
        return this.l;
    }

    public void setPlacementId(String str) {
        this.l = str;
    }

    public void setActivity(Activity activity) {
        this.j = activity;
    }

    public void setReward(com.mbridge.msdk.videocommon.b.c cVar) {
        this.o = cVar;
    }

    public void setMute(int i) {
        this.q = i;
    }

    public void setIV(boolean z) {
        this.r = z;
    }

    public void setBidCampaign(boolean z) {
        this.s = z;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.t = i;
        this.u = i2;
        this.v = i3;
    }

    public void setBigOffer(boolean z) {
        this.w = z;
    }

    public void setRewardUnitSetting(c cVar) {
        this.m = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        aa.d("AbstractJSContainer", str);
        Activity activity = this.j;
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public final j b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        a.C0158a a2 = com.mbridge.msdk.videocommon.a.a(this.r ? 287 : 94, campaignEx);
        if (a2 != null && a2.c()) {
            WindVaneWebView a3 = a2.a();
            if (a3.getObject() instanceof j) {
                return (j) a3.getObject();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final int c(CampaignEx campaignEx) {
        j b2 = b(campaignEx);
        if (b2 != null) {
            return b2.l();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r4 = r4.getRewardTemplateMode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.videocommon.d.c r3, com.mbridge.msdk.foundation.entity.CampaignEx r4) {
        /*
            r2 = this;
            int r0 = r2.c(r4)
            r1 = 1
            if (r0 != r1) goto L_0x0008
            return
        L_0x0008:
            if (r4 == 0) goto L_0x0019
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()
            if (r4 == 0) goto L_0x0019
            int r4 = r4.c()
            boolean r4 = r2.b((int) r4)
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            if (r4 != 0) goto L_0x0027
            if (r3 == 0) goto L_0x0027
            com.mbridge.msdk.videocommon.d.c r3 = r2.m
            int r3 = r3.c()
            r2.b((int) r3)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.container.AbstractJSContainer.a(com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private boolean b(int i) {
        boolean z = true;
        if (i == 1) {
            this.j.setRequestedOrientation(12);
        } else if (i != 2) {
            z = false;
        } else {
            try {
                this.j.setRequestedOrientation(11);
            } catch (Throwable th) {
                aa.b("AbstractJSContainer", th.getMessage(), th);
                return false;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        c cVar;
        if (!TextUtils.isEmpty(this.l) || (cVar = this.m) == null || TextUtils.isEmpty(cVar.A())) {
            return this.l;
        }
        return this.m.A();
    }
}
