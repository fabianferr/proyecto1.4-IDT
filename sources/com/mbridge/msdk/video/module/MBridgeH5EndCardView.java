package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.appnext.core.Ad;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.video.signal.g;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBridgeH5EndCardView extends MBridgeBaseView implements h, com.mbridge.msdk.mbsignalcommon.mraid.b, g {
    private int A = 1;
    private int B = 1;
    /* access modifiers changed from: private */
    public boolean C = false;
    /* access modifiers changed from: private */
    public boolean D = false;
    /* access modifiers changed from: private */
    public int E = 1;
    /* access modifiers changed from: private */
    public long F = 0;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public boolean H = false;
    private boolean I = false;
    private boolean J = false;
    /* access modifiers changed from: private */
    public boolean K = false;
    /* access modifiers changed from: private */
    public boolean L = false;
    /* access modifiers changed from: private */
    public boolean M = false;
    private boolean N = false;
    /* access modifiers changed from: private */
    public String O = "";
    private boolean P = false;
    private boolean Q = false;
    protected View n;
    protected RelativeLayout o;
    protected ImageView p;
    protected WindVaneWebView q;
    protected Handler r = new Handler();
    protected String s;
    protected boolean t = false;
    protected boolean u = false;
    protected String v;
    Handler w = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 100) {
                if (MBridgeH5EndCardView.this.G) {
                    MBridgeH5EndCardView.this.e.a(122, "");
                }
                MBridgeH5EndCardView.this.e.a(103, "");
            }
        }
    };
    boolean x = false;
    private boolean y = false;
    private boolean z = false;

    public void expand(String str, boolean z2) {
    }

    public void install(CampaignEx campaignEx) {
    }

    public void readyStatus(int i) {
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_h5");
        if (findLayout >= 0) {
            View inflate = this.c.inflate(findLayout, (ViewGroup) null);
            this.n = inflate;
            try {
                this.p = (ImageView) inflate.findViewById(findID("mbridge_windwv_close"));
                this.o = (RelativeLayout) inflate.findViewById(findID("mbridge_windwv_content_rl"));
                this.q = new WindVaneWebView(getContext());
                this.q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.o.addView(this.q);
                this.f = isNotNULL(this.p, this.q);
            } catch (Exception unused) {
                this.f = false;
            }
            addView(this.n, b());
            c();
            e();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            this.p.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.q != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.q, "onSystemDestory", "");
                new Thread(new a(this)).start();
            } else {
                this.e.a(103, "");
                this.e.a(119, "webview is null when closing webview");
            }
        } catch (Exception e2) {
            this.e.a(103, "");
            com.mbridge.msdk.video.module.a.a aVar = this.e;
            aVar.a(119, "close webview exception" + e2.getMessage());
            aa.a(MBridgeBaseView.TAG, e2.getMessage());
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "2");
            m.a().c(this.b.getCurrentLRid(), "2000152", hashMap);
            m.a().a("2000134", this.b, (Map<String, String>) new HashMap());
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    private class a implements Runnable {
        private MBridgeH5EndCardView b;

        public a(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                aa.d("CloseRunnable", e.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.w != null) {
                this.b.w.sendEmptyMessage(100);
            }
        }
    }

    public void setError(boolean z2) {
        this.u = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0128 A[Catch:{ all -> 0x0130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012c A[Catch:{ all -> 0x0130 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r11) {
        /*
            r10 = this;
            java.lang.String r0 = "="
            java.lang.String r2 = r10.a()
            boolean r1 = r10.f
            r3 = 3
            r7 = 0
            if (r1 == 0) goto L_0x0175
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r10.b
            if (r1 == 0) goto L_0x0175
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0175
            long r4 = java.lang.System.currentTimeMillis()
            r10.F = r4
            java.lang.String r1 = "start"
            r10.reportRenderResult(r1, r7)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0024
        L_0x0023:
        L_0x0024:
            com.mbridge.msdk.foundation.webview.BrowserView$MBDownloadListener r1 = new com.mbridge.msdk.foundation.webview.BrowserView$MBDownloadListener
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r10.b
            r1.<init>(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r10.b
            java.lang.String r4 = r4.getAppName()
            r1.setTitle(r4)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r10.q
            r4.setDownloadListener(r1)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r10.q
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r10.b
            java.lang.String r4 = r4.getId()
            r1.setCampaignId(r4)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r10.q
            r1.setTempTypeForMetrics(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r10.b
            if (r1 == 0) goto L_0x0058
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r10.q
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r10.b
            java.lang.String r3 = r3.getCurrentLRid()
            r1.setLocalRequestId(r3)
        L_0x0058:
            r1 = 8
            r10.setCloseVisible(r1)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r10.q
            r1.setApiManagerJSFactory(r11)
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r10.b
            boolean r11 = r11.isMraid()
            if (r11 == 0) goto L_0x006f
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r11 = r10.q
            r11.setMraidObject(r10)
        L_0x006f:
            java.lang.String r11 = "wfr=1"
            boolean r1 = r2.contains(r11)
            r3 = 1
            if (r1 != 0) goto L_0x0085
            java.lang.String r1 = "wfl=1"
            boolean r1 = r2.contains(r1)
            if (r1 == 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r1 = 0
            goto L_0x0086
        L_0x0085:
            r1 = 1
        L_0x0086:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r10.q
            com.mbridge.msdk.video.module.MBridgeH5EndCardView$3 r5 = new com.mbridge.msdk.video.module.MBridgeH5EndCardView$3
            r5.<init>(r1)
            r4.setWebViewListener(r5)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r10.b
            java.lang.String r1 = r1.getMraid()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r4 = "MBridgeBaseView"
            if (r1 == 0) goto L_0x0138
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0130 }
            r10.F = r5     // Catch:{ all -> 0x0130 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r10.b     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x0130 }
            com.mbridge.msdk.videocommon.d.b r5 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0130 }
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0130 }
            java.lang.String r6 = r6.h()     // Catch:{ all -> 0x0130 }
            java.lang.String r8 = r10.v     // Catch:{ all -> 0x0130 }
            com.mbridge.msdk.videocommon.d.c r5 = r5.a(r6, r8)     // Catch:{ all -> 0x0130 }
            boolean r6 = r10.z     // Catch:{ all -> 0x0130 }
            if (r6 == 0) goto L_0x0138
            boolean r6 = com.mbridge.msdk.foundation.tools.ak.b(r1)     // Catch:{ all -> 0x0130 }
            if (r6 == 0) goto L_0x0138
            boolean r6 = r1.contains(r11)     // Catch:{ all -> 0x0130 }
            if (r6 != 0) goto L_0x00d4
            if (r5 == 0) goto L_0x0138
            int r6 = r5.o()     // Catch:{ all -> 0x0130 }
            if (r6 <= 0) goto L_0x0138
        L_0x00d4:
            boolean r11 = r1.contains(r11)     // Catch:{ all -> 0x0130 }
            r6 = 20
            if (r11 == 0) goto L_0x0117
            java.lang.String r11 = "&"
            java.lang.String[] r11 = r1.split(r11)     // Catch:{ all -> 0x0130 }
            if (r11 == 0) goto L_0x0124
            int r1 = r11.length     // Catch:{ all -> 0x0130 }
            if (r1 <= 0) goto L_0x0124
            int r1 = r11.length     // Catch:{ all -> 0x0130 }
            r5 = 0
        L_0x00e9:
            if (r5 >= r1) goto L_0x0124
            r8 = r11[r5]     // Catch:{ all -> 0x0130 }
            boolean r9 = com.mbridge.msdk.foundation.tools.ak.b(r8)     // Catch:{ all -> 0x0130 }
            if (r9 == 0) goto L_0x0114
            java.lang.String r9 = "to"
            boolean r9 = r8.contains(r9)     // Catch:{ all -> 0x0130 }
            if (r9 == 0) goto L_0x0114
            java.lang.String[] r9 = r8.split(r0)     // Catch:{ all -> 0x0130 }
            if (r9 == 0) goto L_0x0114
            java.lang.String[] r9 = r8.split(r0)     // Catch:{ all -> 0x0130 }
            int r9 = r9.length     // Catch:{ all -> 0x0130 }
            if (r9 <= 0) goto L_0x0114
            java.lang.String[] r11 = r8.split(r0)     // Catch:{ all -> 0x0130 }
            r11 = r11[r3]     // Catch:{ all -> 0x0130 }
            int r11 = com.mbridge.msdk.foundation.tools.af.a((java.lang.Object) r11)     // Catch:{ all -> 0x0130 }
            goto L_0x0126
        L_0x0114:
            int r5 = r5 + 1
            goto L_0x00e9
        L_0x0117:
            if (r5 == 0) goto L_0x0124
            int r11 = r5.o()     // Catch:{ all -> 0x0130 }
            if (r11 <= 0) goto L_0x0124
            int r11 = r5.o()     // Catch:{ all -> 0x0130 }
            goto L_0x0126
        L_0x0124:
            r11 = 20
        L_0x0126:
            if (r11 < 0) goto L_0x012c
            r10.excuteEndCardShowTask(r11)     // Catch:{ all -> 0x0130 }
            goto L_0x0138
        L_0x012c:
            r10.excuteEndCardShowTask(r6)     // Catch:{ all -> 0x0130 }
            goto L_0x0138
        L_0x0130:
            r11 = move-exception
            java.lang.String r0 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r4, r0, r11)
        L_0x0138:
            com.mbridge.msdk.videocommon.download.h r11 = com.mbridge.msdk.videocommon.download.h.a()
            java.lang.String r11 = r11.b(r2)
            r10.setHtmlSource(r11)
            java.lang.String r11 = r10.s
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x0162
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "load url:"
            r11.<init>(r0)
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r11)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r11 = r10.q
            r11.loadUrl(r2)
            goto L_0x018a
        L_0x0162:
            java.lang.String r11 = "load html..."
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r11)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r10.q
            java.lang.String r3 = r10.s
            java.lang.String r4 = "text/html"
            java.lang.String r5 = "UTF-8"
            r6 = 0
            r1.loadDataWithBaseURL(r2, r3, r4, r5, r6)
            goto L_0x018a
        L_0x0175:
            java.lang.String r11 = "PL URL IS NULL"
            r10.reportRenderResult(r11, r3)
            com.mbridge.msdk.video.module.a.a r11 = r10.e
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r1 = ""
            r11.a(r0, r1)
            com.mbridge.msdk.video.module.a.a r11 = r10.e
            r0 = 129(0x81, float:1.81E-43)
            r11.a(r0, r1)
        L_0x018a:
            r10.x = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    public void reportRenderResult(String str, int i) {
        if (this.b != null && !this.u) {
            n nVar = new n();
            nVar.n(this.b.getRequestId());
            nVar.p(this.b.getRequestIdNotice());
            nVar.r(this.b.getId());
            nVar.e(i);
            nVar.u(String.valueOf(System.currentTimeMillis() - this.F));
            nVar.t(str);
            String str2 = "2";
            if (this.b.getAdType() == 287) {
                nVar.h(ExifInterface.GPS_MEASUREMENT_3D);
            } else if (this.b.getAdType() == 94) {
                nVar.h("1");
            } else if (this.b.getAdType() == 42) {
                nVar.h(str2);
            }
            if (this.b.isMraid()) {
                nVar.b(n.a);
            } else {
                nVar.f(this.b.getendcard_url());
                if (ak.b(this.b.getendcard_url()) && this.b.getendcard_url().contains(".zip")) {
                    str2 = "1";
                }
                nVar.g(str2);
                nVar.b(n.b);
            }
            com.mbridge.msdk.foundation.same.report.n.b(nVar, this.v, this.b);
        }
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.b.getendcard_url();
            if (ak.b(str) && str.contains("wfl=1")) {
                String[] split = str.split("&");
                int i = 15;
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (ak.b(str2) && str2.contains("timeout") && str2.split("=") != null && str2.split("=").length > 0) {
                            i = af.a((Object) str2.split("=")[1]);
                        }
                    }
                }
                executeEndCardShow(i);
            }
        } catch (Throwable th) {
            aa.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.I = true;
        } else if (i == 1) {
            this.J = true;
        }
    }

    public void toggleCloseBtn(int i) {
        int visibility = this.p.getVisibility();
        if (i == 1) {
            this.H = true;
            visibility = 0;
        } else if (i == 2) {
            this.H = false;
            if (this.x) {
                if (!this.Q && !this.I) {
                    this.Q = true;
                    int i2 = this.B;
                    if (i2 == 0) {
                        this.L = true;
                    } else {
                        this.L = false;
                        if (i2 > -1) {
                            this.r.postDelayed(new e(this), (long) (this.B * 1000));
                        }
                    }
                }
            } else if (!this.P && !this.I) {
                this.P = true;
                int i3 = this.A;
                if (i3 == 0) {
                    this.K = true;
                } else {
                    this.K = false;
                    if (i3 > -1) {
                        this.r.postDelayed(new d(this), (long) (this.A * 1000));
                    }
                }
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    private class d implements Runnable {
        private MBridgeH5EndCardView b;

        public d(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null) {
                boolean unused = mBridgeH5EndCardView.K = true;
            }
        }
    }

    private class e implements Runnable {
        private MBridgeH5EndCardView b;

        public e(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null) {
                boolean unused = mBridgeH5EndCardView.L = true;
            }
        }
    }

    public void handlerPlayableException(String str) {
        if (!this.u) {
            this.u = true;
            this.t = false;
            if (this.b != null) {
                n nVar = new n();
                nVar.n(this.b.getRequestId());
                nVar.p(this.b.getRequestIdNotice());
                nVar.r(this.b.getId());
                nVar.t(str);
                com.mbridge.msdk.foundation.same.report.n.d(nVar, this.a.getApplicationContext(), this.v);
            }
        }
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.q;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        aa.a(MBridgeBaseView.TAG, "webviewshow");
                        try {
                            int[] iArr = new int[2];
                            MBridgeH5EndCardView.this.q.getLocationOnScreen(iArr);
                            aa.d(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context g = com.mbridge.msdk.foundation.controller.b.d().g();
                            if (g != null) {
                                jSONObject.put("startX", af.a(g, (float) iArr[0]));
                                jSONObject.put("startY", af.a(g, (float) iArr[1]));
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.k, (double) af.e(g));
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            str = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                        MBridgeH5EndCardView.this.e.a(109, "");
                        MBridgeH5EndCardView.d(MBridgeH5EndCardView.this);
                        MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "oncutoutfetched", Base64.encodeToString(MBridgeH5EndCardView.this.O.getBytes(), 0));
                        MBridgeH5EndCardView.f(MBridgeH5EndCardView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, Ad.ORIENTATION_LANDSCAPE);
            } else {
                jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, Ad.ORIENTATION_PORTRAIT);
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.q, AdUnitActivity.EXTRA_ORIENTATION, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.p;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public boolean isLoadSuccess() {
        return this.t;
    }

    public void setUnitId(String str) {
        this.v = str;
    }

    public void setCloseDelayShowTime(int i) {
        this.A = i;
    }

    public void setPlayCloseBtnTm(int i) {
        this.B = i;
    }

    public void setHtmlSource(String str) {
        this.s = str;
    }

    public void setCloseVisible(int i) {
        if (this.f) {
            this.p.setVisibility(i);
        }
    }

    public void setCloseVisibleForMraid(int i) {
        if (this.f) {
            this.M = true;
            if (i == 4) {
                this.p.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.p.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.p.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.f) {
            setMatchParent();
        }
    }

    /* access modifiers changed from: protected */
    public String a() {
        String str;
        if (this.b != null) {
            this.G = true;
            if (this.b.isMraid()) {
                this.z = false;
                String mraid = this.b.getMraid();
                if (TextUtils.isEmpty(mraid)) {
                    return this.b.getEndScreenUrl();
                }
                File file = new File(mraid);
                try {
                    if (!file.exists() || !file.isFile() || !file.canRead()) {
                        str = this.b.getEndScreenUrl();
                    } else {
                        str = "file:////" + mraid;
                    }
                    return str;
                } catch (Throwable th) {
                    if (!MBridgeConstans.DEBUG) {
                        return mraid;
                    }
                    th.printStackTrace();
                    return mraid;
                }
            } else {
                String str2 = this.b.getendcard_url();
                if (!ak.a(str2)) {
                    this.z = true;
                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(str2);
                    if (TextUtils.isEmpty(b2)) {
                        try {
                            String path = Uri.parse(str2).getPath();
                            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                                String endScreenUrl = this.b.getEndScreenUrl();
                                if (TextUtils.isEmpty(endScreenUrl)) {
                                    return null;
                                }
                                this.z = false;
                                excuteTask();
                                return endScreenUrl;
                            }
                        } catch (Throwable th2) {
                            aa.d(MBridgeBaseView.TAG, th2.getMessage());
                        }
                        return str2 + "&native_adtype=" + this.b.getAdType();
                    }
                    return b2 + "&native_adtype=" + this.b.getAdType();
                }
                this.z = false;
                return this.b.getEndScreenUrl();
            }
        } else {
            this.G = false;
            return null;
        }
    }

    private class f implements Runnable {
        private MBridgeH5EndCardView b;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.M) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                boolean unused = this.b.H = true;
            }
        }
    }

    public void excuteTask() {
        if (!this.z && this.A > -1) {
            this.r.postDelayed(new f(this), (long) (this.A * 1000));
        }
    }

    private class b implements Runnable {
        private MBridgeH5EndCardView b;

        public b(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null && !mBridgeH5EndCardView.D) {
                boolean unused = this.b.D = true;
                this.b.t = false;
                MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
                this.b.e.a(127, "");
                aa.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
            }
        }
    }

    public void executeEndCardShow(int i) {
        this.r.postDelayed(new b(this), (long) (i * 1000));
    }

    public void excuteEndCardShowTask(int i) {
        this.r.postDelayed(new c(this, i), (long) (i * 1000));
    }

    private static class c implements Runnable {
        private MBridgeH5EndCardView a;
        private int b;

        public c(MBridgeH5EndCardView mBridgeH5EndCardView, int i) {
            this.a = mBridgeH5EndCardView;
            this.b = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0084 A[Catch:{ Exception -> 0x00aa, all -> 0x00f2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x008a A[Catch:{ Exception -> 0x00aa, all -> 0x00f2 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                java.lang.String r0 = "MBridgeBaseView"
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a
                if (r1 == 0) goto L_0x00fa
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b
                if (r1 == 0) goto L_0x00fa
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00f2 }
                boolean r1 = r1.C     // Catch:{ all -> 0x00f2 }
                if (r1 == 0) goto L_0x0018
                java.lang.String r1 = "insertEndCardReadyState hasInsertLoadEndCardReport true return"
                com.mbridge.msdk.foundation.tools.aa.b(r0, r1)     // Catch:{ all -> 0x00f2 }
                return
            L_0x0018:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00f2 }
                r2 = 1
                boolean unused = r1.C = r2     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x00f2 }
                boolean r1 = com.mbridge.msdk.foundation.tools.ak.b(r1)     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = "1"
                java.lang.String r3 = "2"
                if (r1 == 0) goto L_0x0042
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x00f2 }
                java.lang.String r4 = ".zip"
                boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x00f2 }
                if (r1 == 0) goto L_0x0042
                r12 = r2
                goto L_0x0043
            L_0x0042:
                r12 = r3
            L_0x0043:
                r6 = 12
                java.lang.String r11 = "ready timeout"
                com.mbridge.msdk.foundation.entity.n r1 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x00f2 }
                java.lang.String r5 = "2000043"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
                r4.<init>()     // Catch:{ all -> 0x00f2 }
                int r7 = r13.b     // Catch:{ all -> 0x00f2 }
                int r7 = r7 * 1000
                r4.append(r7)     // Catch:{ all -> 0x00f2 }
                java.lang.String r7 = ""
                r4.append(r7)     // Catch:{ all -> 0x00f2 }
                java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r8 = r4.getendcard_url()     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r9 = r4.getId()     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ all -> 0x00f2 }
                java.lang.String r10 = r4.v     // Catch:{ all -> 0x00f2 }
                r4 = r1
                r4.<init>((java.lang.String) r5, (int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ Exception -> 0x00aa }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00aa }
                int r4 = r4.getAdType()     // Catch:{ Exception -> 0x00aa }
                r5 = 287(0x11f, float:4.02E-43)
                if (r4 != r5) goto L_0x008a
                java.lang.String r2 = "3"
                r1.h((java.lang.String) r2)     // Catch:{ Exception -> 0x00aa }
                goto L_0x00ae
            L_0x008a:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ Exception -> 0x00aa }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00aa }
                int r4 = r4.getAdType()     // Catch:{ Exception -> 0x00aa }
                r5 = 94
                if (r4 != r5) goto L_0x009a
                r1.h((java.lang.String) r2)     // Catch:{ Exception -> 0x00aa }
                goto L_0x00ae
            L_0x009a:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ Exception -> 0x00aa }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ Exception -> 0x00aa }
                int r2 = r2.getAdType()     // Catch:{ Exception -> 0x00aa }
                r4 = 42
                if (r2 != r4) goto L_0x00ae
                r1.h((java.lang.String) r3)     // Catch:{ Exception -> 0x00aa }
                goto L_0x00ae
            L_0x00aa:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ all -> 0x00f2 }
            L_0x00ae:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = r2.getRequestId()     // Catch:{ all -> 0x00f2 }
                r1.n(r2)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = r2.getCurrentLRid()     // Catch:{ all -> 0x00f2 }
                r1.o(r2)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = r2.getRequestIdNotice()     // Catch:{ all -> 0x00f2 }
                r1.p(r2)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00f2 }
                int r2 = r2.getAdSpaceT()     // Catch:{ all -> 0x00f2 }
                r1.c((int) r2)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView.b((com.mbridge.msdk.foundation.entity.n) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r2)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = r2.v     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r3 = r13.a     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.b     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.foundation.same.report.n.a((com.mbridge.msdk.foundation.entity.n) r1, (java.lang.String) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r3)     // Catch:{ all -> 0x00f2 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00f2 }
                r1.isLoadSuccess()     // Catch:{ all -> 0x00f2 }
                goto L_0x00fa
            L_0x00f2:
                r1 = move-exception
                java.lang.String r2 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.aa.b(r0, r2, r1)
            L_0x00fa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.c.run():void");
        }
    }

    public boolean isPlayable() {
        return this.z;
    }

    public void onBackPress() {
        boolean z2;
        if (this.H || ((z2 && this.J) || ((!(z2 = this.I) && this.K && !this.x) || (!z2 && this.L && this.x)))) {
            onCloseViewClick();
        }
    }

    public void setLoadPlayable(boolean z2) {
        this.x = z2;
    }

    public void release() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.r = null;
        }
        Handler handler2 = this.w;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.w = null;
        }
        this.o.removeAllViews();
        m.a().a(this.b);
        this.q.release();
        this.q = null;
    }

    public void volumeChange(double d2) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) this.q, d2);
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.b != null && this.b.isMraid()) {
            if (z2) {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.q, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } else {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.q, "false");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && !this.N) {
            this.N = true;
            setFocusableInTouchMode(true);
            requestFocus();
            requestFocusFromTouch();
        }
    }

    public void open(String str) {
        try {
            String clickURL = this.b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.b.setClickURL(str);
                CampaignEx mraidCampaign = getMraidCampaign();
                if (mraidCampaign != null) {
                    new p(getContext()).b(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.v, str, this.b.isBidCampaign());
                }
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), this.v);
            aVar.a((h) this);
            aVar.a(this.b);
            this.b.setClickURL(clickURL);
            this.e.a(126, "");
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void unload() {
        close();
    }

    public CampaignEx getMraidCampaign() {
        return this.b;
    }

    public void useCustomClose(boolean z2) {
        try {
            setCloseVisibleForMraid(z2 ? 4 : 0);
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void setNotchValue(String str, int i, int i2, int i3, int i4) {
        this.O = str;
        if (this.b != null && this.b.getAdSpaceT() != 2) {
            aa.d(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            int b2 = af.b(getContext(), 20.0f);
            layoutParams.setMargins(i + b2, i3 + b2, i2 + b2, i4 + b2);
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void onStartRedirection(Campaign campaign, String str) {
        ae.a(campaign, this);
    }

    public void onFinishRedirection(Campaign campaign, String str) {
        ae.b(campaign, this);
    }

    public void onRedirectionFailed(Campaign campaign, String str) {
        ae.b(campaign, this);
    }

    /* access modifiers changed from: private */
    public static void b(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c a2 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), campaignEx.getCampaignUnitId());
            if (a2 != null) {
                nVar.l(a2.l());
            }
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b2 != null) {
                nVar.k(b2.c());
            }
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031 A[Catch:{ NullPointerException -> 0x00ae, all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[Catch:{ NullPointerException -> 0x00ae, all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c A[Catch:{ NullPointerException -> 0x00ae, all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092 A[Catch:{ NullPointerException -> 0x00ae, all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb A[Catch:{ NullPointerException -> 0x00ae, all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeH5EndCardView r17, long r18, boolean r20) {
        /*
            r1 = r17
            boolean r0 = r1.C     // Catch:{ all -> 0x012a }
            if (r0 == 0) goto L_0x0008
            goto L_0x0134
        L_0x0008:
            r2 = 1
            r1.C = r2     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x012a }
            boolean r0 = com.mbridge.msdk.foundation.tools.ak.b(r0)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = "1"
            java.lang.String r4 = "2"
            if (r0 == 0) goto L_0x002b
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x012a }
            java.lang.String r5 = ".zip"
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x012a }
            if (r0 == 0) goto L_0x002b
            r14 = r3
            goto L_0x002c
        L_0x002b:
            r14 = r4
        L_0x002c:
            java.lang.String r0 = "ready yes"
            r5 = 2
            if (r20 == 0) goto L_0x003a
            java.lang.String r0 = "ready timeout"
            r6 = 12
            r15 = r0
            r7 = 12
            r13 = 2
            goto L_0x004e
        L_0x003a:
            int r6 = r1.E     // Catch:{ all -> 0x012a }
            if (r6 != r5) goto L_0x0048
            java.lang.String r0 = "ready no"
            r5 = 3
            r6 = 11
            r15 = r0
            r7 = 11
            r13 = 3
            goto L_0x004e
        L_0x0048:
            r5 = 10
            r15 = r0
            r7 = 10
            r13 = 1
        L_0x004e:
            com.mbridge.msdk.foundation.entity.n r12 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "2000043"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r0.<init>()     // Catch:{ all -> 0x012a }
            r10 = r18
            r0.append(r10)     // Catch:{ all -> 0x012a }
            java.lang.String r5 = ""
            r0.append(r5)     // Catch:{ all -> 0x012a }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r9 = r0.getendcard_url()     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x012a }
            java.lang.String r5 = r1.v     // Catch:{ all -> 0x012a }
            r16 = r5
            r5 = r12
            r10 = r0
            r11 = r16
            r2 = r12
            r12 = r15
            r20 = r15
            r15 = r13
            r13 = r14
            r5.<init>((java.lang.String) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ NullPointerException -> 0x00ae }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x00ae }
            r5 = 287(0x11f, float:4.02E-43)
            if (r0 != r5) goto L_0x0092
            java.lang.String r0 = "3"
            r2.h((java.lang.String) r0)     // Catch:{ NullPointerException -> 0x00ae }
            goto L_0x00b2
        L_0x0092:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ NullPointerException -> 0x00ae }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x00ae }
            r5 = 94
            if (r0 != r5) goto L_0x00a0
            r2.h((java.lang.String) r3)     // Catch:{ NullPointerException -> 0x00ae }
            goto L_0x00b2
        L_0x00a0:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ NullPointerException -> 0x00ae }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x00ae }
            r3 = 42
            if (r0 != r3) goto L_0x00b2
            r2.h((java.lang.String) r4)     // Catch:{ NullPointerException -> 0x00ae }
            goto L_0x00b2
        L_0x00ae:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x012a }
        L_0x00b2:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getRequestId()     // Catch:{ all -> 0x012a }
            r2.n(r0)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getCurrentLRid()     // Catch:{ all -> 0x012a }
            r2.o(r0)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getRequestIdNotice()     // Catch:{ all -> 0x012a }
            r2.p(r0)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            int r0 = r0.getAdSpaceT()     // Catch:{ all -> 0x012a }
            r2.c((int) r0)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            b((com.mbridge.msdk.foundation.entity.n) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r1.v     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.b     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.same.report.n.a((com.mbridge.msdk.foundation.entity.n) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r3)     // Catch:{ all -> 0x012a }
            boolean r0 = r17.isLoadSuccess()     // Catch:{ all -> 0x012a }
            if (r0 != 0) goto L_0x0134
            r3 = 1
            if (r15 != r3) goto L_0x0134
            r2.e((int) r15)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = java.lang.String.valueOf(r18)     // Catch:{ all -> 0x012a }
            r2.u(r0)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x012a }
            r2.r(r0)     // Catch:{ all -> 0x012a }
            r3 = r20
            r2.t(r3)     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            boolean r0 = r0.isMraid()     // Catch:{ all -> 0x012a }
            if (r0 == 0) goto L_0x0111
            int r0 = com.mbridge.msdk.foundation.entity.n.a     // Catch:{ all -> 0x012a }
            r2.b((int) r0)     // Catch:{ all -> 0x012a }
            goto L_0x0122
        L_0x0111:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x012a }
            r2.f((java.lang.String) r0)     // Catch:{ all -> 0x012a }
            r2.g((java.lang.String) r14)     // Catch:{ all -> 0x012a }
            int r0 = com.mbridge.msdk.foundation.entity.n.b     // Catch:{ all -> 0x012a }
            r2.b((int) r0)     // Catch:{ all -> 0x012a }
        L_0x0122:
            java.lang.String r0 = r1.v     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b     // Catch:{ all -> 0x012a }
            com.mbridge.msdk.foundation.same.report.n.b((com.mbridge.msdk.foundation.entity.n) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ all -> 0x012a }
            goto L_0x0134
        L_0x012a:
            r0 = move-exception
            java.lang.String r1 = "MBridgeBaseView"
            java.lang.String r2 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r1, r2, r0)
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.a(com.mbridge.msdk.video.module.MBridgeH5EndCardView, long, boolean):void");
    }

    static /* synthetic */ void d(MBridgeH5EndCardView mBridgeH5EndCardView) {
        MBridgeH5EndCardView mBridgeH5EndCardView2 = mBridgeH5EndCardView;
        if (mBridgeH5EndCardView2.b != null && mBridgeH5EndCardView2.b.isMraid()) {
            int i = mBridgeH5EndCardView.getResources().getConfiguration().orientation;
            String str = AdError.UNDEFINED_DOMAIN;
            if (i != 0) {
                if (i == 1) {
                    str = Ad.ORIENTATION_PORTRAIT;
                } else if (i == 2) {
                    str = Ad.ORIENTATION_LANDSCAPE;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, str);
                jSONObject.put("locked", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", IronSourceConstants.INTERSTITIAL_AD_UNIT);
            hashMap.put("state", "default");
            hashMap.put("viewable", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            hashMap.put("currentAppOrientation", jSONObject);
            if (mBridgeH5EndCardView.getContext() instanceof Activity) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) mBridgeH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView2.q, (float) w.l(mBridgeH5EndCardView.getContext()), (float) w.m(mBridgeH5EndCardView.getContext()));
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBridgeH5EndCardView2.q, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
            }
            com.mbridge.msdk.mbsignalcommon.mraid.a a2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = mBridgeH5EndCardView2.q;
            a2.a(windVaneWebView, (float) windVaneWebView.getLeft(), (float) mBridgeH5EndCardView2.q.getTop(), (float) mBridgeH5EndCardView2.q.getWidth(), (float) mBridgeH5EndCardView2.q.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a a3 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = mBridgeH5EndCardView2.q;
            a3.b(windVaneWebView2, (float) windVaneWebView2.getLeft(), (float) mBridgeH5EndCardView2.q.getTop(), (float) mBridgeH5EndCardView2.q.getWidth(), (float) mBridgeH5EndCardView2.q.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBridgeH5EndCardView2.q, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBridgeH5EndCardView2.q, com.mbridge.msdk.mbsignalcommon.mraid.d.a);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView2.q);
        }
    }

    static /* synthetic */ void f(MBridgeH5EndCardView mBridgeH5EndCardView) {
        if (mBridgeH5EndCardView.b != null) {
            mBridgeH5EndCardView.b.setCampaignUnitId(mBridgeH5EndCardView.v);
            com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
            a2.c(mBridgeH5EndCardView.v + "_1");
            com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
            a3.a(mBridgeH5EndCardView.v + "_2", mBridgeH5EndCardView.b);
        }
        if (mBridgeH5EndCardView.b != null && mBridgeH5EndCardView.b.isMraid()) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
            imageView.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_notice", "drawable"));
            ImageView imageView2 = mBridgeH5EndCardView.p;
            RelativeLayout.LayoutParams layoutParams = imageView2 != null ? (RelativeLayout.LayoutParams) imageView2.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f), af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            if (layoutParams != null) {
                layoutParams2.leftMargin = layoutParams.rightMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            } else {
                layoutParams2.leftMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f);
                layoutParams2.topMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f);
            }
            mBridgeH5EndCardView.addView(imageView, layoutParams2);
            af.a(4, imageView, mBridgeH5EndCardView.b, com.mbridge.msdk.foundation.controller.b.d().g(), false, new com.mbridge.msdk.foundation.c.a() {
                public final void a() {
                    String str;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        str = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void b() {
                    String str;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        str = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void a(String str) {
                    String str2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        str2 = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
        }
    }
}
