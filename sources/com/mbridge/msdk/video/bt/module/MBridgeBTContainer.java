package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.video.bt.a.c;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.a.c;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeBTContainer extends AbstractJSContainer implements com.mbridge.msdk.video.signal.b {
    /* access modifiers changed from: private */
    public static final String a = "MBridgeBTContainer";
    /* access modifiers changed from: private */
    public boolean A = true;
    private String B;
    private boolean C = false;
    /* access modifiers changed from: private */
    public List<CampaignEx> D;
    private List<com.mbridge.msdk.videocommon.download.a> E;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.bt.module.a.a F;
    /* access modifiers changed from: private */
    public h G;
    /* access modifiers changed from: private */
    public h H;
    private com.mbridge.msdk.video.bt.module.a.b I;
    private String J;
    private String K;
    private String L;
    private String M;
    /* access modifiers changed from: private */
    public boolean N;
    /* access modifiers changed from: private */
    public int O;
    private d P;
    private int b = 0;
    private int c = 1;
    /* access modifiers changed from: private */
    public FrameLayout d;
    private MBridgeBTLayout e;
    /* access modifiers changed from: private */
    public WindVaneWebView f;
    private LayoutInflater g;
    private Context h;
    /* access modifiers changed from: private */
    public TextView i;
    /* access modifiers changed from: private */
    public ImageView y;
    private boolean z = false;

    public void click(int i2, String str) {
    }

    public void handlerH5Exception(int i2, String str) {
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        init(context);
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        this.h = context;
        this.g = LayoutInflater.from(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:30|31|32|38|39|40|41|42) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0180 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x031d */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r11 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "_"
            java.lang.String r2 = "_1"
            java.lang.String r3 = "_2"
            java.lang.String r4 = "get BT wraper.getTag = "
            java.lang.String r5 = "mbridge_bt_container"
            int r5 = r11.findLayout(r5)     // Catch:{ all -> 0x038a }
            if (r5 >= 0) goto L_0x0018
            java.lang.String r0 = "mbridge_bt_container layout null"
            r11.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            return
        L_0x0018:
            android.view.LayoutInflater r6 = r11.g     // Catch:{ all -> 0x038a }
            android.view.View r5 = r6.inflate(r5, r11)     // Catch:{ all -> 0x038a }
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5     // Catch:{ all -> 0x038a }
            r11.d = r5     // Catch:{ all -> 0x038a }
            if (r5 != 0) goto L_0x002a
            java.lang.String r0 = "ViewIds null"
            r11.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            return
        L_0x002a:
            r11.K = r0     // Catch:{ all -> 0x038a }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r11.D     // Catch:{ all -> 0x038a }
            r6 = 0
            if (r5 == 0) goto L_0x0050
            int r5 = r5.size()     // Catch:{ all -> 0x038a }
            if (r5 <= 0) goto L_0x0050
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r11.D     // Catch:{ all -> 0x038a }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r5.getCMPTEntryUrl()     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r5.getRequestId()     // Catch:{ all -> 0x038a }
            r11.K = r8     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r5.getCurrentLRid()     // Catch:{ all -> 0x038a }
            r11.L = r5     // Catch:{ all -> 0x038a }
            goto L_0x0051
        L_0x0050:
            r7 = r0
        L_0x0051:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r5.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r11.k     // Catch:{ all -> 0x038a }
            r5.append(r8)     // Catch:{ all -> 0x038a }
            r5.append(r1)     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r11.K     // Catch:{ all -> 0x038a }
            r5.append(r8)     // Catch:{ all -> 0x038a }
            r5.append(r1)     // Catch:{ all -> 0x038a }
            r5.append(r7)     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.videocommon.a$a r5 = com.mbridge.msdk.videocommon.a.a(r5)     // Catch:{ all -> 0x038a }
            r8 = 0
            if (r5 == 0) goto L_0x0095
            java.lang.String r9 = r5.b()     // Catch:{ all -> 0x038a }
            r11.B = r9     // Catch:{ all -> 0x038a }
            java.lang.String r9 = a     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r10.<init>(r4)     // Catch:{ all -> 0x038a }
            java.lang.String r4 = r11.B     // Catch:{ all -> 0x038a }
            r10.append(r4)     // Catch:{ all -> 0x038a }
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r9, (java.lang.String) r4)     // Catch:{ all -> 0x038a }
            r5.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r5.a()     // Catch:{ all -> 0x038a }
            goto L_0x0096
        L_0x0095:
            r4 = r8
        L_0x0096:
            r11.f = r4     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r4.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r11.k     // Catch:{ all -> 0x038a }
            r4.append(r5)     // Catch:{ all -> 0x038a }
            r4.append(r1)     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r11.K     // Catch:{ all -> 0x038a }
            r4.append(r5)     // Catch:{ all -> 0x038a }
            r4.append(r1)     // Catch:{ all -> 0x038a }
            r4.append(r7)     // Catch:{ all -> 0x038a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.videocommon.a.b(r4)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r11.f     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x0342
            com.mbridge.msdk.video.signal.factory.b r4 = new com.mbridge.msdk.video.signal.factory.b     // Catch:{ all -> 0x038a }
            android.app.Activity r5 = r11.j     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r7 = r11.f     // Catch:{ all -> 0x038a }
            r4.<init>(r5, r11, r7)     // Catch:{ all -> 0x038a }
            r11.registerJsFactory(r4)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r11.f     // Catch:{ all -> 0x038a }
            r5.setApiManagerJSFactory(r4)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r11.f     // Catch:{ all -> 0x038a }
            android.view.ViewParent r5 = r5.getParent()     // Catch:{ all -> 0x038a }
            if (r5 == 0) goto L_0x00da
            java.lang.String r0 = "preload template webview is null or load error"
            r11.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            return
        L_0x00da:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r11.f     // Catch:{ all -> 0x038a }
            java.lang.Object r5 = r5.getObject()     // Catch:{ all -> 0x038a }
            boolean r5 = r5 instanceof com.mbridge.msdk.video.signal.a.j     // Catch:{ all -> 0x038a }
            if (r5 == 0) goto L_0x01a6
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r11.f     // Catch:{ all -> 0x038a }
            java.lang.Object r5 = r5.getObject()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.signal.a.j r5 = (com.mbridge.msdk.video.signal.a.j) r5     // Catch:{ all -> 0x038a }
            r4.a((com.mbridge.msdk.video.signal.a.j) r5)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r11.f     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x019b
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x038a }
            r4.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x038a }
            android.content.Context r7 = r11.getContext()     // Catch:{ all -> 0x038a }
            float r7 = com.mbridge.msdk.foundation.tools.af.e((android.content.Context) r7)     // Catch:{ all -> 0x038a }
            double r9 = (double) r7     // Catch:{ all -> 0x038a }
            r4.put(r5, r9)     // Catch:{ all -> 0x038a }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r5.<init>()     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r7 = "name"
            com.mbridge.msdk.videocommon.b.c r9 = r11.o     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r9 = r9.a()     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r5.put(r7, r9)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r7 = "amount"
            com.mbridge.msdk.videocommon.b.c r9 = r11.o     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            int r9 = r9.b()     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r5.put(r7, r9)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r7 = "id"
            java.lang.String r9 = r11.p     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r5.put(r7, r9)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r7 = "userId"
            java.lang.String r9 = r11.n     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r4.put(r7, r9)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r7 = "reward"
            r4.put(r7, r5)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r5 = "playVideoMute"
            int r7 = r11.q     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r4.put(r5, r7)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            java.lang.String r5 = "extra"
            java.lang.String r7 = r11.M     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            r4.put(r5, r7)     // Catch:{ JSONException -> 0x014f, Exception -> 0x0144 }
            goto L_0x0159
        L_0x0144:
            r5 = move-exception
            java.lang.String r7 = a     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r7, (java.lang.String) r5)     // Catch:{ all -> 0x038a }
            goto L_0x0159
        L_0x014f:
            r5 = move-exception
            java.lang.String r7 = a     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r7, (java.lang.String) r5)     // Catch:{ all -> 0x038a }
        L_0x0159:
            com.mbridge.msdk.video.bt.module.b.c r5 = new com.mbridge.msdk.video.bt.module.b.c     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.module.a.b r7 = r11.c()     // Catch:{ all -> 0x038a }
            r5.<init>(r7, r0)     // Catch:{ all -> 0x038a }
            r11.H = r5     // Catch:{ all -> 0x038a }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x038a }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0180 }
            r4.<init>()     // Catch:{ Exception -> 0x0180 }
            java.lang.String r5 = "type"
            java.lang.String r7 = "1"
            r4.put(r5, r7)     // Catch:{ Exception -> 0x0180 }
            com.mbridge.msdk.foundation.same.report.m r5 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0180 }
            java.lang.String r7 = "2000133"
            java.lang.String r9 = r11.L     // Catch:{ Exception -> 0x0180 }
            r5.b(r7, r9, r4)     // Catch:{ Exception -> 0x0180 }
        L_0x0180:
            com.mbridge.msdk.video.signal.f r4 = r11.getJSNotifyProxy()     // Catch:{ all -> 0x038a }
            r4.a((java.lang.Object) r0)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.signal.c r0 = r11.getJSCommon()     // Catch:{ all -> 0x038a }
            r4 = 1
            r0.b((boolean) r4)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.signal.c r0 = r11.getJSCommon()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$b r4 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$b     // Catch:{ all -> 0x038a }
            r4.<init>()     // Catch:{ all -> 0x038a }
            r0.a((com.mbridge.msdk.video.signal.c.a) r4)     // Catch:{ all -> 0x038a }
        L_0x019b:
            com.mbridge.msdk.video.signal.c r0 = r11.getJSCommon()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.signal.a.c r0 = (com.mbridge.msdk.video.signal.a.c) r0     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.signal.c$a r0 = r0.l     // Catch:{ all -> 0x038a }
            r0.a()     // Catch:{ all -> 0x038a }
        L_0x01a6:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r11.f     // Catch:{ all -> 0x038a }
            r0.setBackgroundColor(r6)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x038a }
            java.lang.String r4 = r11.k     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r11.K     // Catch:{ all -> 0x038a }
            java.util.LinkedHashMap r0 = r0.b((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x033c
            java.lang.String r4 = r11.B     // Catch:{ all -> 0x038a }
            boolean r4 = r0.containsKey(r4)     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x033c
            java.lang.String r4 = r11.B     // Catch:{ all -> 0x038a }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x038a }
            android.view.View r4 = (android.view.View) r4     // Catch:{ all -> 0x038a }
            boolean r5 = r4 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ all -> 0x038a }
            if (r5 == 0) goto L_0x02c2
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r4 = (com.mbridge.msdk.video.bt.module.MBridgeBTLayout) r4     // Catch:{ all -> 0x038a }
            r11.e = r4     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.c.b r4 = com.mbridge.msdk.foundation.c.b.a()     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r5.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r11.k     // Catch:{ all -> 0x038a }
            r5.append(r7)     // Catch:{ all -> 0x038a }
            r5.append(r2)     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$1 r7 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$1     // Catch:{ all -> 0x038a }
            r7.<init>()     // Catch:{ all -> 0x038a }
            r4.a((java.lang.String) r5, (com.mbridge.msdk.foundation.c.a) r7)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r4 = r11.e     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r11.f     // Catch:{ all -> 0x038a }
            android.widget.FrameLayout$LayoutParams r7 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x038a }
            r9 = -1
            r7.<init>(r9, r9)     // Catch:{ all -> 0x038a }
            r4.addView(r5, r6, r7)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.c.b r4 = com.mbridge.msdk.foundation.c.b.a()     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r5.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r11.k     // Catch:{ all -> 0x038a }
            r5.append(r7)     // Catch:{ all -> 0x038a }
            r5.append(r3)     // Catch:{ all -> 0x038a }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x038a }
            r4.c(r3)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.c.b r3 = com.mbridge.msdk.foundation.c.b.a()     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r4.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r11.k     // Catch:{ all -> 0x038a }
            r4.append(r5)     // Catch:{ all -> 0x038a }
            r4.append(r2)     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.widget.FeedBackButton r2 = r3.b(r2)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.c.b r3 = com.mbridge.msdk.foundation.c.b.a()     // Catch:{ all -> 0x038a }
            boolean r3 = r3.b()     // Catch:{ all -> 0x038a }
            if (r3 == 0) goto L_0x0280
            if (r2 == 0) goto L_0x0280
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()     // Catch:{ Exception -> 0x0240 }
            android.widget.RelativeLayout$LayoutParams r3 = (android.widget.RelativeLayout.LayoutParams) r3     // Catch:{ Exception -> 0x0240 }
            r8 = r3
            goto L_0x0244
        L_0x0240:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x038a }
        L_0x0244:
            if (r8 != 0) goto L_0x024f
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x038a }
            int r3 = com.mbridge.msdk.foundation.c.b.a     // Catch:{ all -> 0x038a }
            int r4 = com.mbridge.msdk.foundation.c.b.b     // Catch:{ all -> 0x038a }
            r8.<init>(r3, r4)     // Catch:{ all -> 0x038a }
        L_0x024f:
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x038a }
            android.content.Context r3 = r3.g()     // Catch:{ all -> 0x038a }
            r4 = 1092616192(0x41200000, float:10.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)     // Catch:{ all -> 0x038a }
            r8.topMargin = r3     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x038a }
            android.content.Context r3 = r3.g()     // Catch:{ all -> 0x038a }
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)     // Catch:{ all -> 0x038a }
            r8.leftMargin = r3     // Catch:{ all -> 0x038a }
            r2.setLayoutParams(r8)     // Catch:{ all -> 0x038a }
            android.view.ViewParent r3 = r2.getParent()     // Catch:{ all -> 0x038a }
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3     // Catch:{ all -> 0x038a }
            if (r3 == 0) goto L_0x027b
            r3.removeView(r2)     // Catch:{ all -> 0x038a }
        L_0x027b:
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r3 = r11.e     // Catch:{ all -> 0x038a }
            r3.addView(r2)     // Catch:{ all -> 0x038a }
        L_0x0280:
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r2 = r11.e     // Catch:{ all -> 0x038a }
            java.lang.String r3 = r11.B     // Catch:{ all -> 0x038a }
            r2.setTag(r3)     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r11.B     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r3 = r11.e     // Catch:{ all -> 0x038a }
            r0.put(r2, r3)     // Catch:{ all -> 0x038a }
            java.util.Collection r2 = r0.values()     // Catch:{ all -> 0x038a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x038a }
        L_0x0296:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x038a }
            if (r3 == 0) goto L_0x02b8
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x038a }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x038a }
            boolean r4 = r3 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x0296
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r3 = (com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout) r3     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r3.getInstanceId()     // Catch:{ all -> 0x038a }
            r11.J = r2     // Catch:{ all -> 0x038a }
            android.widget.FrameLayout r2 = r11.d     // Catch:{ all -> 0x038a }
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x038a }
            r4.<init>(r9, r9)     // Catch:{ all -> 0x038a }
            r2.addView(r3, r4)     // Catch:{ all -> 0x038a }
        L_0x02b8:
            java.lang.String r2 = r11.J     // Catch:{ all -> 0x038a }
            r0.remove(r2)     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r11.J     // Catch:{ all -> 0x038a }
            r0.put(r2, r11)     // Catch:{ all -> 0x038a }
        L_0x02c2:
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r11.k     // Catch:{ all -> 0x038a }
            int r3 = r11.q     // Catch:{ all -> 0x038a }
            r0.a((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r11.B     // Catch:{ all -> 0x038a }
            java.lang.String r3 = r11.K     // Catch:{ all -> 0x038a }
            r0.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r11.J     // Catch:{ all -> 0x038a }
            java.lang.String r3 = r11.K     // Catch:{ all -> 0x038a }
            r0.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r2.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r3 = r11.k     // Catch:{ all -> 0x038a }
            r2.append(r3)     // Catch:{ all -> 0x038a }
            r2.append(r1)     // Catch:{ all -> 0x038a }
            java.lang.String r1 = r11.K     // Catch:{ all -> 0x038a }
            r2.append(r1)     // Catch:{ all -> 0x038a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x038a }
            android.app.Activity r2 = r11.j     // Catch:{ all -> 0x038a }
            r0.a((java.lang.String) r1, (android.app.Activity) r2)     // Catch:{ all -> 0x038a }
            android.content.Context r0 = r11.getContext()     // Catch:{ all -> 0x031d }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x031d }
            java.util.concurrent.ThreadPoolExecutor r1 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ all -> 0x031d }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$a r2 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$a     // Catch:{ all -> 0x031d }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r11.D     // Catch:{ all -> 0x031d }
            java.lang.String r4 = r11.k     // Catch:{ all -> 0x031d }
            java.lang.String r5 = r11.l     // Catch:{ all -> 0x031d }
            r2.<init>(r3, r0, r4, r5)     // Catch:{ all -> 0x031d }
            r1.execute(r2)     // Catch:{ all -> 0x031d }
            goto L_0x0324
        L_0x031d:
            java.lang.String r0 = a     // Catch:{ all -> 0x038a }
            java.lang.String r1 = "remove campaign failed"
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x038a }
        L_0x0324:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r11.D     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x039c
            int r0 = r0.size()     // Catch:{ all -> 0x038a }
            if (r0 <= 0) goto L_0x039c
            com.mbridge.msdk.videocommon.d.c r0 = r11.m     // Catch:{ all -> 0x038a }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r11.D     // Catch:{ all -> 0x038a }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ all -> 0x038a }
            r11.a((com.mbridge.msdk.videocommon.d.c) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ all -> 0x038a }
            goto L_0x039c
        L_0x033c:
            java.lang.String r0 = "big template webviewLayout is null"
            r11.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            return
        L_0x0342:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r11.D     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x0384
            int r0 = r0.size()     // Catch:{ all -> 0x038a }
            if (r0 <= 0) goto L_0x0384
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r11.D     // Catch:{ all -> 0x038a }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x0384
            boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x0384
            android.content.Context r0 = r11.h     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.dynview.e.d r1 = r11.P     // Catch:{ all -> 0x038a }
            if (r1 != 0) goto L_0x0368
            java.lang.String r0 = "ChoiceOneCallback is null"
            r11.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            goto L_0x0383
        L_0x0368:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x038a }
            r1.<init>()     // Catch:{ all -> 0x038a }
            java.lang.String r2 = "choice_one_callback"
            com.mbridge.msdk.video.dynview.e.d r3 = r11.P     // Catch:{ all -> 0x038a }
            r1.put(r2, r3)     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.dynview.b.a()     // Catch:{ all -> 0x038a }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r11.D     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$2 r3 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$2     // Catch:{ all -> 0x038a }
            r3.<init>()     // Catch:{ all -> 0x038a }
            com.mbridge.msdk.video.dynview.h.a r4 = new com.mbridge.msdk.video.dynview.h.a     // Catch:{ all -> 0x038a }
            r4.<init>(r0, r2, r3, r1)     // Catch:{ all -> 0x038a }
        L_0x0383:
            return
        L_0x0384:
            java.lang.String r0 = "big template webview is null"
            r11.a((java.lang.String) r0)     // Catch:{ all -> 0x038a }
            goto L_0x039c
        L_0x038a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "onCreate exception "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.a((java.lang.String) r0)
        L_0x039c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.onCreate():void");
    }

    private static final class a implements Runnable {
        private List<CampaignEx> a;
        private Context b;
        private String c;
        private String d;

        public a(List<CampaignEx> list, Context context, String str, String str2) {
            this.a = list;
            this.b = context;
            this.c = str;
            this.d = str2;
        }

        public final void run() {
            List<CampaignEx> list = this.a;
            if (list != null && list.size() > 0) {
                try {
                    f.a((g) com.mbridge.msdk.foundation.db.h.a(this.b)).a(this.c, this.a);
                    com.mbridge.msdk.videocommon.a.a.a().c(this.d, this.a.get(0).getAdType());
                } catch (Exception unused) {
                    aa.a(MBridgeBTContainer.a, "remove campaign failed");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        h hVar = this.G;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    /* access modifiers changed from: protected */
    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    for (String a2 : pv_urls) {
                        CampaignEx campaignEx2 = campaignEx;
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx2, this.k, a2, false, true);
                    }
                }
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.K);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).onConfigurationChanged(configuration);
                    } else if (next instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) next).onConfigurationChanged(configuration);
                    } else if (next instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) next).onConfigurationChanged(configuration);
                    }
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    private com.mbridge.msdk.video.bt.module.a.b c() {
        if (this.I == null) {
            this.I = new com.mbridge.msdk.video.bt.module.a.b() {
                public final void a(String str) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.l);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTContainer.this.k);
                            jSONObject.put("data", jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            aa.a(a2, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", cVar.a());
                                jSONObject3.put("amount", cVar.b());
                                jSONObject2.put(com.wortise.ads.events.modules.c.EXTRA_REWARD, jSONObject3);
                            }
                            jSONObject2.put("isComplete", z);
                            jSONObject2.put("convert", z ? 1 : 2);
                            jSONObject.put("data", jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            aa.a(a2, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(boolean z, int i) {
                    boolean unused = MBridgeBTContainer.this.N = z;
                    int unused2 = MBridgeBTContainer.this.O = i;
                }

                public final void a(String str, String str2) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.l);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTContainer.this.k);
                            jSONObject2.put("error", str2);
                            jSONObject.put("data", jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            aa.a(a2, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put("data", jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            aa.a(a2, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void b(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put("data", jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            aa.a(a2, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void c(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put("data", jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            aa.a(a2, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, int i, String str2, String str3) {
                    if (MBridgeBTContainer.this.G != null) {
                        MBridgeBTContainer.this.G.a(i, str2, str3);
                    }
                }
            };
        }
        return this.I;
    }

    public void onResume() {
        CampaignEx campaignEx;
        super.onResume();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a a2 = com.mbridge.msdk.video.dynview.b.a.a();
            if (a2.a != null) {
                a2.a.a();
            }
        }
        if (!com.mbridge.msdk.foundation.c.b.c) {
            try {
                LinkedHashMap<String, View> b2 = c.a().b(this.k, this.K);
                if (b2 != null && b2.size() > 0) {
                    for (View next : b2.values()) {
                        if (next instanceof MBridgeBTVideoView) {
                            ((MBridgeBTVideoView) next).onResume();
                        }
                    }
                }
            } catch (Throwable th) {
                aa.a(a, th.getMessage());
            }
        }
    }

    public void onStop() {
        CampaignEx campaignEx;
        super.onStop();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a.a().b();
        }
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.K);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).onStop();
                    }
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.K);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).onBackPressed();
                    } else if (next instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) next).onBackPressed();
                    } else if (next instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) next).onBackPressed();
                    }
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    public void onPause() {
        CampaignEx campaignEx;
        super.onPause();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a a2 = com.mbridge.msdk.video.dynview.b.a.a();
            if (a2.a != null) {
                a2.a.b();
            }
        }
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.K);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).onPause();
                    }
                }
            }
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onAdClose() {
        if (this.j != null) {
            this.j.finish();
        }
    }

    public void onDestroy() {
        if (!this.C) {
            this.C = true;
            super.onDestroy();
            c a2 = c.a();
            a2.d(this.k + "_" + this.K);
            try {
                WindVaneWebView windVaneWebView = this.f;
                if (windVaneWebView != null) {
                    ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    this.f.clearWebView();
                    this.f.release();
                }
                if (this.I != null) {
                    this.I = null;
                }
                if (this.F != null) {
                    this.F = null;
                }
                if (this.h != null) {
                    this.h = null;
                }
                List<CampaignEx> list = this.D;
                if (list != null && list.size() > 0) {
                    for (CampaignEx next : this.D) {
                        if (!(next == null || next.getRewardTemplateMode() == null)) {
                            com.mbridge.msdk.videocommon.a.b(this.k + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    }
                    com.mbridge.msdk.video.dynview.b.a.a().b();
                }
                c.a().f(this.B);
                c.a().g(this.k);
                c.a().b(this.k, this.K).remove(this.B);
                c.a().b(this.k, this.K).remove(this.J);
                c.a().b(this.k, this.K).clear();
            } catch (Throwable th) {
                aa.a(a, th.getMessage());
            }
        }
    }

    public void reactDeveloper(Object obj, String str) {
        if (this.F == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, getUnitId());
            String optString2 = jSONObject.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            CampaignEx campaignEx = this.D.get(0);
            boolean z2 = true;
            if (optInt == 1 && optJSONObject != null) {
                boolean optBoolean = optJSONObject.optBoolean("expired");
                if (campaignEx != null) {
                    if (optBoolean) {
                        campaignEx.setSpareOfferFlag(1);
                    } else {
                        campaignEx.setSpareOfferFlag(0);
                    }
                }
            }
            setCBT(campaignEx);
            JSONObject jSONObject2 = null;
            switch (optInt) {
                case 1:
                    this.F.a();
                    this.F.a(2, optString2, optString);
                    break;
                case 2:
                    if (optJSONObject != null) {
                        jSONObject2 = optJSONObject.optJSONObject("error");
                    }
                    String str2 = "";
                    if (jSONObject2 != null) {
                        str2 = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    this.F.a(str2);
                    this.F.a(4, optString2, optString);
                    break;
                case 3:
                    this.F.a(optString2, optString);
                    this.F.a(5, optString2, optString);
                    break;
                case 4:
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "2");
                        hashMap.put("update", "1");
                        m.a().b("2000147", this.L, hashMap);
                    } catch (Throwable th) {
                        aa.d(a, th.getMessage());
                    }
                    this.F.b(optString2, optString);
                    this.F.a(6, optString2, optString);
                    break;
                case 5:
                    this.F.a(jSONObject.optBoolean("isAutoClick"), optString2, optString);
                    break;
                case 6:
                    if (optJSONObject != null) {
                        if (optJSONObject.optInt("convert") != 1) {
                            z2 = false;
                        }
                        jSONObject2 = optJSONObject.optJSONObject(com.wortise.ads.events.modules.c.EXTRA_REWARD);
                        String optString3 = optJSONObject.optString("extra");
                        if (!TextUtils.isEmpty(optString3)) {
                            this.M = optString3;
                        }
                    } else {
                        z2 = false;
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject(FirebaseAnalytics.Param.CAMPAIGN));
                    com.mbridge.msdk.videocommon.b.c a2 = com.mbridge.msdk.videocommon.b.c.a(jSONObject2);
                    if (a2 == null) {
                        a2 = this.o;
                    }
                    this.F.a(7, optString2, optString);
                    try {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("type", "2");
                        m.a().c(parseCampaignWithBackData.getCurrentLRid(), "2000152", hashMap2);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.o || this.t == com.mbridge.msdk.foundation.same.a.p)) {
                        this.F.a(this.N, this.O);
                    }
                    if (!z2) {
                        a2.a(0);
                    }
                    this.F.a(z2, a2);
                    aa.a(a, "sendToServerRewardInfo");
                    if (!this.r && z2) {
                        if (parseCampaignWithBackData != null) {
                            com.mbridge.msdk.video.module.b.b.a(parseCampaignWithBackData, a2, optString, this.n, this.M);
                        } else {
                            com.mbridge.msdk.video.module.b.b.a(campaignEx, a2, optString, this.n, this.M);
                        }
                    }
                    try {
                        m.a().a("2000134", parseCampaignWithBackData, (Map<String, String>) new HashMap());
                        break;
                    } catch (Throwable th2) {
                        aa.a(a, th2.getMessage());
                        break;
                    }
            }
            a(obj);
        } catch (JSONException e3) {
            a(obj, e3.getMessage());
            aa.a(a, e3.getMessage());
        }
    }

    public void reportUrls(Object obj, String str) {
        String str2 = str;
        String str3 = a;
        aa.a(str3, "reportUrls:" + str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    String a2 = af.a(optString, "&tun=", w.y() + "");
                    int optInt2 = jSONObject.optInt("report");
                    CampaignEx campaignEx = null;
                    if (optInt2 == 0) {
                        Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
                        List<CampaignEx> list = this.D;
                        if (list != null) {
                            campaignEx = list.get(0);
                        }
                        com.mbridge.msdk.click.a.a(g2, campaignEx, "", a2, false, optInt != 0);
                    } else {
                        Context g3 = com.mbridge.msdk.foundation.controller.b.d().g();
                        List<CampaignEx> list2 = this.D;
                        if (list2 != null) {
                            campaignEx = list2.get(0);
                        }
                        com.mbridge.msdk.click.a.a(g3, campaignEx, "", a2, false, optInt != 0, optInt2);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString("".getBytes(), 2));
            } catch (Throwable th) {
                aa.b(a, "reportUrls", th);
            }
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
                int optInt = jSONObject.optInt("left", -999);
                int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY, -999);
                int optInt3 = jSONObject.optInt("right", -999);
                int optInt4 = jSONObject.optInt("bottom", -999);
                if (!(optInt == -999 || g2 == null)) {
                    layoutParams.leftMargin = af.b(g2, (float) optInt);
                }
                if (!(optInt2 == -999 || g2 == null)) {
                    layoutParams.topMargin = af.b(g2, (float) optInt2);
                }
                if (!(optInt3 == -999 || g2 == null)) {
                    layoutParams.rightMargin = af.b(g2, (float) optInt3);
                }
                if (!(optInt4 == -999 || g2 == null)) {
                    layoutParams.bottomMargin = af.b(g2, (float) optInt4);
                }
                int optInt5 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                int optInt6 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                if (optInt5 > 0) {
                    layoutParams.width = optInt5;
                }
                if (optInt6 > 0) {
                    layoutParams.height = optInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.j);
            mBTempContainer.setMute(this.q);
            mBTempContainer.setBidCampaign(this.z);
            mBTempContainer.setIV(this.r);
            mBTempContainer.setBigOffer(this.A);
            mBTempContainer.setIVRewardEnable(this.t, this.u, this.v);
            mBTempContainer.setShowRewardListener(this.H);
            mBTempContainer.setCampaignDownLoadTask(d(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(c());
            mBTempContainer.setWebViewFront(getJSCommon().a());
            mBTempContainer.init(this.h);
            mBTempContainer.onCreate();
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    private com.mbridge.msdk.videocommon.download.a d(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.E;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a next : list) {
            if (next.k().getId().equals(campaignEx.getId())) {
                aa.a(a, "tempContainer task initSuccess");
                return next;
            }
        }
        return null;
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.b);
                jSONObject2.put("id", this.B);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                c.a().a((WebView) this.f, "broadcast", this.B);
            }
        }
    }

    public int findID(String str) {
        return t.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return t.a(getContext(), str, "layout");
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.a.a aVar) {
        this.F = aVar;
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.D = list;
    }

    public List<CampaignEx> getCampaigns() {
        return this.D;
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.E = list;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.x = bVar;
    }

    public void setShowRewardVideoListener(h hVar) {
        this.G = hVar;
    }

    public void setChoiceOneCallback(d dVar) {
        this.P = dVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        if (campaignEx.getSpareOfferFlag() != 1) {
            campaignEx.setCbt(0);
        } else if (this.m == null) {
        } else {
            if (this.m.z() == 1) {
                campaignEx.setCbt(1);
            } else {
                campaignEx.setCbt(0);
            }
        }
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        String a2;
        TextView textView;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        try {
            a2 = o.a(i2, i3, i4, i5, i6);
            aa.d(a, a2);
            WindVaneWebView windVaneWebView = this.f;
            if (windVaneWebView != null) {
                if ((windVaneWebView.getObject() instanceof j) && !TextUtils.isEmpty(a2)) {
                    ((j) this.f.getObject()).b(a2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f, "oncutoutfetched", Base64.encodeToString(a2.getBytes(), 0));
                }
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                if (this.D.get(0).isDynamicView() && (textView = this.i) != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                    if (layoutParams != null) {
                        if (i7 > 0) {
                            layoutParams.leftMargin = i7;
                        }
                        if (i8 > 0) {
                            layoutParams.rightMargin = i8;
                        }
                        if (i9 > 0) {
                            layoutParams.topMargin = i9;
                        }
                        if (i10 > 0) {
                            layoutParams.bottomMargin = i10;
                        }
                        this.i.setLayoutParams(layoutParams);
                        if (this.y != null) {
                            try {
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.y.getLayoutParams());
                                layoutParams2.leftMargin = layoutParams.rightMargin;
                                layoutParams2.topMargin = layoutParams.topMargin;
                                this.y.setLayoutParams(layoutParams2);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception e3) {
            aa.d(a, e3.getMessage());
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
            return;
        }
        c.a().a(i2, i3, i4, i5, i6);
        LinkedHashMap<String, View> b2 = c.a().b(this.k, this.K);
        if (b2 != null && b2.size() > 0) {
            for (View next : b2.values()) {
                if (next instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) next).setNotchPadding(i7, i8, i9, i10);
                }
                if (next instanceof MBTempContainer) {
                    ((MBTempContainer) next).setNotchPadding(i2, i3, i4, i5, i6);
                }
                if ((next instanceof WindVaneWebView) && !TextUtils.isEmpty(a2)) {
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((Object) next, "oncutoutfetched", Base64.encodeToString(a2.getBytes(), 0));
                }
            }
        }
    }

    public void setDeveloperExtraData(String str) {
        this.M = str;
    }

    private class b extends c.a {
        private b() {
        }

        public final void a() {
            super.a();
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            ae.a(campaign, MBridgeBTContainer.this.d);
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            ae.b(campaign, MBridgeBTContainer.this.d);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals("1.0") && MBridgeBTContainer.this.j != null) {
                        if (MBridgeBTContainer.this.A) {
                            MBridgeBTContainer.this.onAdClose();
                        } else {
                            MBridgeBTContainer.this.j.finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            ae.b(campaign, MBridgeBTContainer.this.d);
        }

        public final void a(boolean z) {
            super.a(z);
            MBridgeBTContainer.this.H.a(z, MBridgeBTContainer.this.l, MBridgeBTContainer.this.k);
        }

        public final void a(int i, String str) {
            super.a(i, str);
        }

        public final void b() {
            super.b();
        }
    }

    public void addNativeCloseButtonWhenWebViewCrash() {
        try {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
            int b2 = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 48.0f);
            int b3 = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
            layoutParams.setMargins(b3, b3, b3, b3);
            layoutParams.gravity = 5;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_close", "drawable"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeBTContainer.this.onAdClose();
                }
            });
            addView(imageView);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    static /* synthetic */ void a(MBridgeBTContainer mBridgeBTContainer, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap hashMap = new HashMap();
                List<com.mbridge.msdk.foundation.entity.c> b2 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).b(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                    int d2 = b2.get(0).d();
                    String b3 = b2.get(0).b();
                    if (d2 == 1) {
                        hashMap.put("encrypt_p=", "encrypt_p=" + b3);
                        hashMap.put("irlfa=", "irlfa=1");
                        for (Map.Entry entry : hashMap.entrySet()) {
                            campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
