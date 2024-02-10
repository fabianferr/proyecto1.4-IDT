package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.iab.omid.library.mmadbridge.adsession.media.VastProperties;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.n;
import com.mbridge.msdk.video.signal.a.c;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.videocommon.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MBTempContainer extends AbstractJSContainer {
    /* access modifiers changed from: private */
    public static final String y = "MBTempContainer";
    /* access modifiers changed from: private */
    public CampaignEx A;
    private com.mbridge.msdk.videocommon.download.a B;
    /* access modifiers changed from: private */
    public h C;
    private com.mbridge.msdk.video.bt.module.a.b D;
    private com.mbridge.msdk.video.dynview.e.a E;
    /* access modifiers changed from: private */
    public int F = 1;
    private String G = "";
    private com.mbridge.msdk.video.signal.factory.b H;
    /* access modifiers changed from: private */
    public int I = com.mbridge.msdk.foundation.same.a.s;
    /* access modifiers changed from: private */
    public int J;
    private boolean K = false;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q = "";
    private String R;
    private List<CampaignEx> S = new ArrayList();
    private int T = 0;
    private LayoutInflater U;
    /* access modifiers changed from: private */
    public int V = 0;
    private int W = 0;
    protected boolean a = false;
    /* access modifiers changed from: private */
    public View aa;
    private boolean ab = false;
    /* access modifiers changed from: private */
    public boolean ac = false;
    private boolean ad = false;
    private boolean ae;
    private boolean af = false;
    /* access modifiers changed from: private */
    public boolean ag = false;
    /* access modifiers changed from: private */
    public boolean ah = false;
    /* access modifiers changed from: private */
    public boolean ai = false;
    /* access modifiers changed from: private */
    public boolean aj = false;
    private boolean ak = false;
    private com.mbridge.msdk.mbsignalcommon.mraid.d al;
    private AdSession am = null;
    /* access modifiers changed from: private */
    public MediaEvents an = null;
    /* access modifiers changed from: private */
    public Runnable ao = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.aa != null) {
                MBTempContainer.this.aa.setVisibility(8);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean ap = false;
    protected boolean b = false;
    protected a c = new a.C0155a();
    protected WindVaneWebView d;
    protected MBridgeVideoView e;
    protected MBridgeContainerView f;
    protected Handler g = new Handler();
    protected Runnable h = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.getActivityProxy().h() == 0) {
                MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
            } else {
                int unused = MBTempContainer.this.V = -3;
            }
        }
    };
    protected Runnable i = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.getActivityProxy().h() == 0) {
                MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
            } else {
                int unused = MBTempContainer.this.V = -4;
            }
        }
    };
    private View z;

    public void preload() {
    }

    public void setMediaPlayerUrl(String str) {
    }

    public MBTempContainer(Context context) {
        super(context);
        init(context);
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        this.U = LayoutInflater.from(context);
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i2) {
        if (list != null) {
            this.S = list;
        }
        this.T = i2;
    }

    public void registerErrorListener(a aVar) {
        this.c = aVar;
    }

    public int findID(String str) {
        return t.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return t.a(getContext(), str, "layout");
    }

    public interface a {
        void a(String str);

        void a(boolean z);

        /* renamed from: com.mbridge.msdk.video.bt.module.MBTempContainer$a$a  reason: collision with other inner class name */
        public static class C0155a implements a {
            private boolean a = false;

            public void a(String str) {
                aa.d("ActivityErrorListener", str);
                this.a = true;
            }

            public final void a(boolean z) {
                this.a = z;
            }
        }
    }

    public boolean isLoadSuccess() {
        return this.b;
    }

    private int c() {
        j b2 = b(this.A);
        if (b2 != null) {
            return b2.j();
        }
        return 0;
    }

    private boolean d() {
        j b2 = b(this.A);
        if (b2 != null) {
            return b2.m();
        }
        return false;
    }

    private boolean e() {
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView == null) {
            return false;
        }
        if (mBridgeVideoView.isShowingAlertView() || this.e.isRewardPopViewShowing()) {
            return true;
        }
        return false;
    }

    public void superDefaultLoad(int i2, String str) {
        this.g.removeCallbacks(this.h);
        this.g.removeCallbacks(this.i);
        this.c.a(true);
        WindVaneWebView windVaneWebView = this.d;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    public void onPause() {
        super.onPause();
        this.ad = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.f;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.e;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th) {
            aa.b(y, th.getMessage(), th);
        }
    }

    public void onResume() {
        Runnable runnable;
        super.onResume();
        int i2 = this.V;
        if (i2 == -3) {
            runnable = this.h;
        } else {
            runnable = i2 == -4 ? this.i : null;
        }
        if (runnable != null) {
            runnable.run();
            this.V = 0;
        }
        try {
            if (this.e != null && !e() && !this.e.isMiniCardShowing() && !com.mbridge.msdk.foundation.c.b.c) {
                this.e.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.e;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.f;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.ad && !e() && !com.mbridge.msdk.foundation.c.b.c) {
                getJSVideoModule().videoOperate(1);
            }
            if (this.j != null) {
                af.a(this.j.getWindow().getDecorView());
            }
            if (this.af && this.ag && this.j != null) {
                this.j.finish();
            }
        } catch (Throwable th) {
            aa.b(y, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.e.onActivityStop();
        }
    }

    public void onDestroy() {
        CampaignEx campaignEx;
        if (!this.K) {
            boolean z2 = true;
            this.K = true;
            super.onDestroy();
            try {
                MBridgeVideoView mBridgeVideoView = this.e;
                if (mBridgeVideoView != null) {
                    mBridgeVideoView.releasePlayer();
                }
                WindVaneWebView windVaneWebView = this.d;
                if (windVaneWebView != null) {
                    ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    this.d.clearWebView();
                    m.a().a(this.A);
                    this.d.release();
                }
                if (this.D != null) {
                    this.D = null;
                }
                this.g.removeCallbacks(this.h);
                this.g.removeCallbacks(this.i);
                getJSCommon().e();
                if (this.r) {
                    com.mbridge.msdk.c.f.a().e(this.k);
                }
                if (!this.ab) {
                    this.ab = true;
                    CampaignEx campaignEx2 = this.A;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                        this.ac = true;
                    }
                    if (this.C != null) {
                        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.o || this.t == com.mbridge.msdk.foundation.same.a.p)) {
                            h hVar = this.C;
                            if (this.J != 1) {
                                z2 = false;
                            }
                            hVar.a(z2, this.I);
                        }
                        if (!this.ac) {
                            this.o.a(0);
                        }
                        this.C.a(this.ac, this.o);
                    }
                    this.g.removeCallbacks(this.ao);
                    if (((!this.r && !this.w) || ((campaignEx = this.A) != null && campaignEx.isDynamicView())) && this.ac) {
                        aa.a(y, "sendToServerRewardInfo");
                        com.mbridge.msdk.video.module.b.b.a(this.A, this.o, this.k, this.n, this.R);
                    }
                    if (!this.w) {
                        if (this.r) {
                            com.mbridge.msdk.videocommon.a.b(287, this.A);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(94, this.A);
                        }
                    }
                    MBridgeContainerView mBridgeContainerView = this.f;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.release();
                    }
                }
            } catch (Throwable th) {
                aa.a(y, th.getMessage());
                return;
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.al;
            if (dVar != null) {
                dVar.d();
            }
            AdSession adSession = this.am;
            if (adSession != null) {
                adSession.removeAllFriendlyObstructions();
                this.am.finish();
                this.am = null;
            }
            if (!this.w) {
                if (isLoadSuccess()) {
                    this.g.postDelayed(new Runnable() {
                        public final void run() {
                            if (MBTempContainer.this.j != null) {
                                MBTempContainer.this.j.finish();
                            }
                        }
                    }, 100);
                } else if (this.j != null) {
                    this.j.finish();
                }
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.video.bt.a.c.a().f(this.G);
        }
    }

    private void f() {
        p pVar = new p(getContext());
        CampaignEx campaignEx = this.A;
        if (campaignEx != null) {
            pVar.a(campaignEx.getRequestId(), this.A.getRequestIdNotice(), this.A.getId(), this.k, com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.A.getId()), this.A.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.A.getId());
            this.ae = true;
        }
    }

    public void setShowingTransparent() {
        int a2;
        boolean d2 = d();
        this.af = d2;
        if (!d2 && (a2 = t.a(getContext(), "mbridge_reward_theme", "style")) > 1 && this.j != null) {
            this.j.setTheme(a2);
        }
    }

    private void g() {
        AdSession adSession = this.am;
        if (adSession != null) {
            try {
                adSession.addFriendlyObstruction(this.f, FriendlyObstructionPurpose.OTHER, (String) null);
                View view = this.aa;
                if (view != null) {
                    this.am.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, (String) null);
                }
                WindVaneWebView windVaneWebView = this.d;
                if (windVaneWebView != null) {
                    this.am.addFriendlyObstruction(windVaneWebView, FriendlyObstructionPurpose.OTHER, (String) null);
                }
                AdEvents createAdEvents = AdEvents.createAdEvents(this.am);
                this.an = MediaEvents.createMediaEvents(this.am);
                this.am.start();
                createAdEvents.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
                this.e.setVideoEvents(this.an);
                if (createAdEvents != null) {
                    createAdEvents.impressionOccurred();
                }
            } catch (Exception e2) {
                aa.a("omsdk", e2.getMessage());
            }
        }
    }

    public void receiveSuccess() {
        aa.a(y, "receiveSuccess ,start hybrid");
        this.g.removeCallbacks(this.i);
        this.g.postDelayed(this.ao, 250);
    }

    public void defaultLoad(int i2, String str) {
        int i3;
        int i4;
        superDefaultLoad(i2, str);
        if (isLoadSuccess()) {
            if (this.A.getPlayable_ads_without_video() == 2) {
                this.f.setCampaign(this.A);
                this.f.addOrderViewData(this.S);
                this.f.setUnitID(this.k);
                this.f.setCloseDelayTime(i());
                this.f.setPlayCloseBtnTm(this.m.h());
                this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.A, this.B, this.o, b(), this.k, new d(), this.m.z(), this.w));
                this.f.preLoadData(this.H);
                this.f.showPlayableView();
            } else {
                a(i2, str);
                this.aa.setVisibility(8);
                loadModuleDatas();
                int f2 = this.m.f();
                int c2 = c();
                int i5 = c2 != 0 ? c2 : f2;
                CampaignEx campaignEx = this.A;
                if (campaignEx != null && campaignEx.isDynamicView()) {
                    this.e.setContainerViewOnNotifyListener(new c(this.j, this.A));
                }
                CampaignEx campaignEx2 = this.A;
                if (campaignEx2 == null || campaignEx2.getVst() <= -2) {
                    i3 = this.m.e();
                } else {
                    i3 = this.A.getVst();
                }
                CampaignEx campaignEx3 = this.A;
                if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (i4 = this.F) > 1) {
                    i3 = a(i3, i4);
                    this.A.setVst(i3);
                }
                int i6 = i3;
                this.e.setVideoSkipTime(i6);
                MBridgeVideoView mBridgeVideoView = this.e;
                mBridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.m(mBridgeVideoView, this.f, this.A, this.o, this.B, b(), this.k, i5, i6, new f(), this.m.z(), this.w, this.m.D()));
                this.e.defaultShow();
                MBridgeContainerView mBridgeContainerView = this.f;
                mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.b(this.e, mBridgeContainerView, this.A, this.o, this.B, b(), this.k, new c(this.j, this.A), this.m.z(), this.w));
                this.f.defaultShow();
            }
            g();
            return;
        }
        a(i2, str);
        if (this.j != null) {
            this.j.finish();
        }
    }

    public int getLayoutID() {
        return findLayout(this.af ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public WindVaneWebView findWindVaneWebView() {
        a.C0158a aVar;
        try {
            if (this.w) {
                CampaignEx campaignEx = this.A;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
                    return null;
                }
                a.C0158a a2 = com.mbridge.msdk.videocommon.a.a(this.k + "_" + this.A.getId() + "_" + this.A.getRequestId() + "_" + this.A.getRewardTemplateMode().e());
                if (a2 != null) {
                    return a2.a();
                }
                return null;
            }
            if (this.r) {
                aVar = com.mbridge.msdk.videocommon.a.a(287, this.A);
            } else {
                aVar = com.mbridge.msdk.videocommon.a.a(94, this.A);
            }
            if (aVar == null || !aVar.c()) {
                return null;
            }
            if (this.r) {
                com.mbridge.msdk.videocommon.a.b(287, this.A);
            } else {
                com.mbridge.msdk.videocommon.a.b(94, this.A);
            }
            WindVaneWebView a3 = aVar.a();
            if (this.af) {
                a3.setWebViewTransparent();
            }
            return a3;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public boolean initViews() {
        View findViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.aa = findViewById;
        return findViewById != null;
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.f;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.af && (mBridgeVideoView2 = this.e) != null) {
            mBridgeVideoView2.notifyVideoClose();
        } else if (!this.ah || (mBridgeVideoView = this.e) == null) {
            if (!this.aj || (mBridgeContainerView2 = this.f) == null) {
                if (this.ai && (mBridgeContainerView = this.f) != null) {
                    mBridgeContainerView.onEndcardBackPress();
                }
                if (getJSCommon().b()) {
                    if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                        getActivityProxy().g();
                    }
                } else if (!canBackPress()) {
                    aa.a(y, "onBackPressed can't excute");
                } else if (this.j != null && !this.w && !this.ak) {
                    this.ak = true;
                    this.j.onBackPressed();
                }
            } else {
                mBridgeContainerView2.onPlayableBackPress();
            }
        } else if (mBridgeVideoView.isMiniCardShowing()) {
            MBridgeContainerView mBridgeContainerView3 = this.f;
            if (mBridgeContainerView3 != null) {
                mBridgeContainerView3.onMiniEndcardBackPress();
            }
        } else {
            this.e.onBackPress();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047 A[Catch:{ all -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "code="
            com.mbridge.msdk.foundation.entity.n r1 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x009c }
            r1.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "2000037"
            r1.s(r2)     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r2.<init>(r0)     // Catch:{ all -> 0x009c }
            r2.append(r4)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = ",desc="
            r2.append(r4)     // Catch:{ all -> 0x009c }
            r2.append(r5)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x009c }
            r1.j(r4)     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x003a
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x003a
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.e()     // Catch:{ all -> 0x009c }
            goto L_0x003b
        L_0x003a:
            r4 = r5
        L_0x003b:
            r1.i(r4)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r3.k     // Catch:{ all -> 0x009c }
            r1.q(r4)     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x004b
            java.lang.String r5 = r4.getId()     // Catch:{ all -> 0x009c }
        L_0x004b:
            r1.r(r5)     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x0065
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x009c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x0065
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x009c }
            r1.n(r4)     // Catch:{ all -> 0x009c }
        L_0x0065:
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = r4.getRequestIdNotice()     // Catch:{ all -> 0x009c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x007c
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.getRequestIdNotice()     // Catch:{ all -> 0x009c }
            r1.p(r4)     // Catch:{ all -> 0x009c }
        L_0x007c:
            android.content.Context r4 = r3.getContext()     // Catch:{ all -> 0x009c }
            int r4 = com.mbridge.msdk.foundation.tools.w.r(r4)     // Catch:{ all -> 0x009c }
            r1.d((int) r4)     // Catch:{ all -> 0x009c }
            android.content.Context r5 = r3.getContext()     // Catch:{ all -> 0x009c }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.w.a((android.content.Context) r5, (int) r4)     // Catch:{ all -> 0x009c }
            r1.v(r4)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = com.mbridge.msdk.foundation.entity.n.e((com.mbridge.msdk.foundation.entity.n) r1)     // Catch:{ all -> 0x009c }
            java.lang.String r5 = r3.k     // Catch:{ all -> 0x009c }
            com.mbridge.msdk.video.module.b.b.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x009c }
            goto L_0x00a6
        L_0x009c:
            r4 = move-exception
            java.lang.String r5 = y
            java.lang.String r0 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r5, r0, r4)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.a(int, java.lang.String):void");
    }

    private int h() {
        try {
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b2 == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b2 != null) {
                return (int) b2.h();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    private int i() {
        CampaignEx campaignEx = this.A;
        if (campaignEx == null) {
            return 1;
        }
        boolean b2 = af.b(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int c2 = af.c(this.A.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        if (b2 && c2 >= 0) {
            return c2;
        }
        if (this.A.getCbd() > -2) {
            return this.A.getCbd();
        }
        return this.m.p();
    }

    private int a(int i2, int i3) {
        List<CampaignEx> list;
        if (i2 < 0 || (list = this.S) == null || list.size() == 0 || i3 <= 1) {
            return i2;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i3 - 1; i5++) {
            if (this.S.get(i5) != null) {
                i4 += this.S.get(i5).getVideoLength();
            }
        }
        if (i2 > i4) {
            return i2 - i4;
        }
        return 0;
    }

    private final class f extends com.mbridge.msdk.video.module.a.a.f {
        private f() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
            if (com.mbridge.msdk.video.bt.module.MBTempContainer.d(r6.a).isCampaignIsFiltered() != false) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0175, code lost:
            if (com.mbridge.msdk.video.bt.module.MBTempContainer.d(r6.a).isCampaignIsFiltered() != false) goto L_0x0182;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r7, java.lang.Object r8) {
            /*
                r6 = this;
                super.a(r7, r8)
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r0 = r0.r
                java.lang.String r1 = "NotifyListener"
                if (r0 == 0) goto L_0x003e
                boolean r0 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0036 }
                if (r0 == 0) goto L_0x003e
                r0 = r8
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0036 }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0036 }
                if (r2 != 0) goto L_0x003e
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0036 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x0036 }
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this     // Catch:{ Exception -> 0x0036 }
                java.lang.String r3 = "Alert_window_status"
                int r3 = r2.getInt(r3)     // Catch:{ Exception -> 0x0036 }
                int unused = r0.I = r3     // Catch:{ Exception -> 0x0036 }
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this     // Catch:{ Exception -> 0x0036 }
                java.lang.String r3 = "complete_info"
                int r2 = r2.getInt(r3)     // Catch:{ Exception -> 0x0036 }
                int unused = r0.J = r2     // Catch:{ Exception -> 0x0036 }
                goto L_0x003e
            L_0x0036:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
            L_0x003e:
                r0 = 2
                r2 = 0
                if (r7 == r0) goto L_0x00f2
                r3 = 121(0x79, float:1.7E-43)
                r4 = 1
                if (r7 == r3) goto L_0x00d1
                r3 = 16
                if (r7 == r3) goto L_0x00c6
                r3 = 17
                if (r7 == r3) goto L_0x00b2
                switch(r7) {
                    case 10: goto L_0x0054;
                    case 11: goto L_0x00f2;
                    case 12: goto L_0x00f2;
                    default: goto L_0x0052;
                }
            L_0x0052:
                goto L_0x01ad
            L_0x0054:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ah = r4
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.A
                if (r7 == 0) goto L_0x01ad
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.A
                boolean r7 = r7.isDynamicView()
                if (r7 == 0) goto L_0x008c
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r7 = r7.w
                if (r7 == 0) goto L_0x0082
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.A
                boolean r7 = r7.isCampaignIsFiltered()
                if (r7 == 0) goto L_0x0095
                goto L_0x008c
            L_0x0082:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.C
                r7.a()
                goto L_0x0095
            L_0x008c:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.C
                r7.a()
            L_0x0095:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                android.content.Context r7 = r7.getContext()
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.A
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r0 = r0.k
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                int r1 = r1.F
                com.mbridge.msdk.video.bt.module.b.f.a((android.content.Context) r7, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (java.lang.String) r0, (int) r1)
                goto L_0x01ad
            L_0x00b2:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ac = r4
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.module.MBridgeContainerView r7 = r7.f
                if (r7 == 0) goto L_0x01ad
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.module.MBridgeContainerView r7 = r7.f
                r7.setRewardStatus(r4)
                goto L_0x01ad
            L_0x00c6:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.c r7 = r7.getJSCommon()
                r7.d()
                goto L_0x01ad
            L_0x00d1:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ac = r4
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.C
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r8 = r8.l
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r0 = r0.k
                r7.a((java.lang.String) r8, (java.lang.String) r0)
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ah = r2
                goto L_0x01ad
            L_0x00f2:
                r3 = 12
                if (r7 != r3) goto L_0x018b
                java.lang.String r3 = "Play error but has no message."
                boolean r4 = r8 instanceof java.lang.String     // Catch:{ all -> 0x0102 }
                if (r4 == 0) goto L_0x010a
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0102 }
                r3 = r8
                goto L_0x010a
            L_0x0102:
                r8 = move-exception
                java.lang.String r8 = r8.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r1, r8)
            L_0x010a:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                android.content.Context r8 = r8.getContext()
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.A
                com.mbridge.msdk.video.bt.module.MBTempContainer r4 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r4 = r4.k
                com.mbridge.msdk.video.bt.module.MBTempContainer r5 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                int r5 = r5.F
                com.mbridge.msdk.video.bt.module.b.f.a(r8, r1, r4, r3, r5)
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r8 = r8.ah
                if (r8 != 0) goto L_0x018b
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.videocommon.d.c r8 = r8.m
                int r8 = r8.D()
                if (r8 != 0) goto L_0x014f
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.C
                java.lang.String r8 = "play error"
                r7.a(r8)
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ah = r2
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.m(r7)
                return
            L_0x014f:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.A
                if (r8 == 0) goto L_0x0182
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.A
                boolean r8 = r8.isDynamicView()
                if (r8 == 0) goto L_0x0182
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r8 = r8.w
                if (r8 == 0) goto L_0x0178
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.A
                boolean r8 = r8.isCampaignIsFiltered()
                if (r8 == 0) goto L_0x018b
                goto L_0x0182
            L_0x0178:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r8 = r8.C
                r8.a()
                goto L_0x018b
            L_0x0182:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r8 = r8.C
                r8.a()
            L_0x018b:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.i r8 = r8.getJSVideoModule()
                r1 = 3
                r8.videoOperate(r1)
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r8.ah = r2
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.iab.omid.library.mmadbridge.adsession.media.MediaEvents r8 = r8.an
                if (r8 == 0) goto L_0x01ad
                if (r7 != r0) goto L_0x01ad
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.iab.omid.library.mmadbridge.adsession.media.MediaEvents r7 = r7.an
                r7.skipped()
            L_0x01ad:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.f.a(int, java.lang.Object):void");
        }
    }

    private final class c extends com.mbridge.msdk.video.module.a.a.a {
        public c(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        public final void a(int i, Object obj) {
            String str = "";
            if (i != 108) {
                if (i != 113) {
                    if (i != 117) {
                        if (i != 126 && i != 128) {
                            switch (i) {
                                case 103:
                                case 104:
                                    MBTempContainer.m(MBTempContainer.this);
                                    break;
                                case 105:
                                    com.mbridge.msdk.video.signal.c jSCommon = MBTempContainer.this.getJSCommon();
                                    if (obj != null) {
                                        str = obj.toString();
                                    }
                                    jSCommon.click(1, str);
                                    break;
                                case 106:
                                    break;
                            }
                        } else {
                            MBTempContainer.this.C.a(false, MBTempContainer.this.l, MBTempContainer.this.k);
                        }
                    } else {
                        if (MBTempContainer.this.e != null) {
                            MBTempContainer.this.e.setVisible(4);
                        }
                        boolean unused = MBTempContainer.this.ai = true;
                        MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
                    }
                }
                MBTempContainer.this.C.a(true, MBTempContainer.this.l, MBTempContainer.this.k);
            } else {
                MBTempContainer.this.getJSCommon().a((c.a) new c.b(MBTempContainer.this.getJSCommon(), new e()));
                com.mbridge.msdk.video.signal.c jSCommon2 = MBTempContainer.this.getJSCommon();
                if (obj != null) {
                    str = obj.toString();
                }
                jSCommon2.click(1, str);
            }
            super.a(i, obj);
        }
    }

    private final class d extends com.mbridge.msdk.video.module.a.a.f {
        private d() {
        }

        public final void a(int i, Object obj) {
            String str;
            super.a(i, obj);
            try {
                if (obj instanceof JSONObject) {
                    str = obj.toString();
                } else {
                    str = (String) obj;
                }
                if (MBTempContainer.this.r && !TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("type");
                    int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (optInt == 2) {
                        int unused = MBTempContainer.this.I = com.mbridge.msdk.foundation.same.a.u;
                    } else if (optInt != 3) {
                        int unused2 = MBTempContainer.this.I = com.mbridge.msdk.foundation.same.a.s;
                    } else {
                        int unused3 = MBTempContainer.this.I = com.mbridge.msdk.foundation.same.a.t;
                    }
                    int unused4 = MBTempContainer.this.J = optInt2;
                }
            } catch (Exception unused5) {
                aa.d("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i == 120) {
                MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
            } else if (i == 126) {
                MBTempContainer.this.C.a(false, MBTempContainer.this.l, MBTempContainer.this.k);
            } else if (i != 127) {
                switch (i) {
                    case 100:
                        boolean unused6 = MBTempContainer.this.aj = true;
                        MBTempContainer.this.g.postDelayed(MBTempContainer.this.ao, 250);
                        MBTempContainer.this.C.a();
                        return;
                    case 101:
                    case 102:
                        MBTempContainer.this.getJSCommon().d();
                        return;
                    case 103:
                        boolean unused7 = MBTempContainer.this.ac = true;
                        if (MBTempContainer.this.A.isMraid()) {
                            MBTempContainer.m(MBTempContainer.this);
                            return;
                        } else {
                            MBTempContainer.this.getJSCommon().d();
                            return;
                        }
                    case 104:
                        MBTempContainer.m(MBTempContainer.this);
                        return;
                    case 105:
                        MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        return;
                    default:
                        return;
                }
            } else {
                boolean unused8 = MBTempContainer.this.ac = true;
                MBTempContainer.this.C.a();
                MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
                MBTempContainer.this.getJSContainerModule().showEndcard(100);
            }
        }
    }

    private class e extends c.a {
        private e() {
        }

        public final void a() {
            super.a();
            MBTempContainer.this.receiveSuccess();
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.F(MBTempContainer.this);
            if (MBTempContainer.this.ap) {
                MBTempContainer.this.onPause();
            }
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            boolean unused = MBTempContainer.this.ag = true;
            MBTempContainer.H(MBTempContainer.this);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals("1.0") && MBTempContainer.this.j != null) {
                        if (MBTempContainer.this.w) {
                            MBTempContainer.m(MBTempContainer.this);
                        } else {
                            MBTempContainer.this.j.finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (MBTempContainer.this.ap) {
                MBTempContainer.this.onResume();
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.H(MBTempContainer.this);
            boolean unused = MBTempContainer.this.ag = true;
        }

        public final void a(boolean z) {
            super.a(z);
            MBTempContainer.this.C.a(z, MBTempContainer.this.l, MBTempContainer.this.k);
        }

        public final void a(int i, String str) {
            super.a(i, str);
            MBTempContainer.this.defaultLoad(i, str);
        }

        public final void b() {
            super.b();
            if (MBTempContainer.this.g != null) {
                MBTempContainer.this.g.removeCallbacks(MBTempContainer.this.h);
            }
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.A = campaignEx;
        if (campaignEx != null) {
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.k)) {
                campaignEx.setCampaignUnitId(this.k);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.ap = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
            a2.a(campaignEx.getCampaignUnitId() + "_1", campaignEx);
        }
    }

    public CampaignEx getCampaign() {
        return this.A;
    }

    public void setCampaignExpired(boolean z2) {
        try {
            CampaignEx campaignEx = this.A;
            if (campaignEx == null) {
                return;
            }
            if (z2) {
                campaignEx.setSpareOfferFlag(1);
                if (this.m == null) {
                    return;
                }
                if (this.m.z() == 1) {
                    this.A.setCbt(1);
                } else {
                    this.A.setCbt(0);
                }
            } else {
                campaignEx.setSpareOfferFlag(0);
                this.A.setCbt(0);
            }
        } catch (Exception e2) {
            aa.d(y, e2.getMessage());
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.B = aVar;
    }

    public void setShowRewardListener(h hVar) {
        this.C = hVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.a.b bVar) {
        this.D = bVar;
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, int i2) {
        this.E = aVar;
        this.F = i2;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.H = bVar;
    }

    public void setInstanceId(String str) {
        this.G = str;
    }

    public String getInstanceId() {
        return this.G;
    }

    public void setWebViewFront(int i2) {
        this.W = i2;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        this.L = i2;
        this.M = i3;
        this.N = i4;
        this.O = i5;
        this.P = i6;
        String a2 = o.a(i2, i3, i4, i5, i6);
        this.Q = a2;
        aa.d(y, a2);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.Q)) {
            getJSCommon().b(this.Q);
            if (this.d != null && !TextUtils.isEmpty(this.Q)) {
                g.a().a((WebView) this.d, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i3, i4, i5, i6);
        }
        MBridgeContainerView mBridgeContainerView = this.f;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i2, i3, i4, i5, i6);
        }
    }

    public void setDeveloperExtraData(String str) {
        this.R = str;
    }

    private static final class b extends AppletSchemeCallBack {
        private CampaignEx a;

        public b(CampaignEx campaignEx) {
            this.a = campaignEx;
        }

        /* access modifiers changed from: protected */
        public final void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                aa.a(MBTempContainer.y, "start request wx scheme");
            }
        }

        /* access modifiers changed from: protected */
        public final void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.a(MBTempContainer.y, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d(MBTempContainer.y, e.getMessage());
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onRequestFailed(int i, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                String a2 = MBTempContainer.y;
                aa.a(a2, "request wx scheme failed: errorCode: " + i + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d(MBTempContainer.y, e.getMessage());
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:100|(2:102|(2:104|(1:106)(1:107)))(1:108)|109|(1:111)|112|(3:113|114|(1:116))|122|123|124|125|126) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x038e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "mbridge_video_templete_webview_parent"
            java.lang.String r3 = "id"
            java.lang.String r4 = "_1"
            com.mbridge.msdk.videocommon.d.c r0 = r1.m
            if (r0 != 0) goto L_0x0022
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r5 = r5.h()
            java.lang.String r6 = r1.k
            boolean r7 = r1.r
            com.mbridge.msdk.videocommon.d.c r0 = r0.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r7)
            r1.m = r0
        L_0x0022:
            r5 = 0
            r6 = 0
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ Exception -> 0x0063 }
            if (r0 != 0) goto L_0x0029
            goto L_0x006b
        L_0x0029:
            com.mbridge.msdk.scheme.applet.AppletModelManager r0 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ Exception -> 0x0035 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.A     // Catch:{ Exception -> 0x0035 }
            com.mbridge.msdk.scheme.applet.AppletsModel r0 = r0.get(r7)     // Catch:{ Exception -> 0x0035 }
            r7 = r0
            goto L_0x003e
        L_0x0035:
            r0 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0063 }
            if (r7 == 0) goto L_0x003d
            r0.printStackTrace()     // Catch:{ Exception -> 0x0063 }
        L_0x003d:
            r7 = r5
        L_0x003e:
            if (r7 == 0) goto L_0x006b
            boolean r0 = r7.can(r6)     // Catch:{ Exception -> 0x0055 }
            if (r0 != 0) goto L_0x0047
            goto L_0x006b
        L_0x0047:
            r7.setUserClick(r6)     // Catch:{ Exception -> 0x0055 }
            com.mbridge.msdk.video.bt.module.MBTempContainer$b r0 = new com.mbridge.msdk.video.bt.module.MBTempContainer$b     // Catch:{ Exception -> 0x0055 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r1.A     // Catch:{ Exception -> 0x0055 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0055 }
            r7.requestWxAppletsScheme(r6, r0)     // Catch:{ Exception -> 0x0055 }
            goto L_0x006b
        L_0x0055:
            r0 = move-exception
            if (r7 == 0) goto L_0x005b
            r7.clearRequestState()     // Catch:{ Exception -> 0x0063 }
        L_0x005b:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0063 }
            if (r7 == 0) goto L_0x006b
            r0.printStackTrace()     // Catch:{ Exception -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            r0 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L_0x006b
            r0.printStackTrace()
        L_0x006b:
            r1.ak = r6
            boolean r0 = r1.w     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x00a2
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0096
            boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0096
            com.mbridge.msdk.video.bt.module.b.d r0 = new com.mbridge.msdk.video.bt.module.b.d     // Catch:{ all -> 0x0419 }
            android.content.Context r8 = r17.getContext()     // Catch:{ all -> 0x0419 }
            boolean r9 = r1.r     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.videocommon.d.c r10 = r1.m     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r1.A     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.b.h r12 = r1.C     // Catch:{ all -> 0x0419 }
            java.lang.String r13 = r17.b()     // Catch:{ all -> 0x0419 }
            java.lang.String r14 = r1.k     // Catch:{ all -> 0x0419 }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0419 }
            r1.C = r0     // Catch:{ all -> 0x0419 }
            goto L_0x00be
        L_0x0096:
            com.mbridge.msdk.video.bt.module.b.c r0 = new com.mbridge.msdk.video.bt.module.b.c     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.a.b r7 = r1.D     // Catch:{ all -> 0x0419 }
            java.lang.String r8 = r1.G     // Catch:{ all -> 0x0419 }
            r0.<init>(r7, r8)     // Catch:{ all -> 0x0419 }
            r1.C = r0     // Catch:{ all -> 0x0419 }
            goto L_0x00be
        L_0x00a2:
            com.mbridge.msdk.video.bt.module.b.d r0 = new com.mbridge.msdk.video.bt.module.b.d     // Catch:{ all -> 0x0419 }
            android.content.Context r10 = r17.getContext()     // Catch:{ all -> 0x0419 }
            boolean r11 = r1.r     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.videocommon.d.c r12 = r1.m     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = r1.A     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.b.h r14 = r1.C     // Catch:{ all -> 0x0419 }
            java.lang.String r15 = r17.b()     // Catch:{ all -> 0x0419 }
            java.lang.String r7 = r1.k     // Catch:{ all -> 0x0419 }
            r9 = r0
            r16 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0419 }
            r1.C = r0     // Catch:{ all -> 0x0419 }
        L_0x00be:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x00f3
            boolean r0 = r0.isActiveOm()     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x00f3
            android.content.Context r7 = r17.getContext()     // Catch:{ all -> 0x0419 }
            r8 = 0
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            java.lang.String r9 = r0.getOmid()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            java.lang.String r10 = r0.getRequestId()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            java.lang.String r11 = r0.getId()     // Catch:{ all -> 0x0419 }
            java.lang.String r12 = r1.k     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.videocommon.download.a r0 = r1.B     // Catch:{ all -> 0x0419 }
            java.lang.String r13 = r0.s()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            java.lang.String r14 = r0.getRequestIdNotice()     // Catch:{ all -> 0x0419 }
            com.iab.omid.library.mmadbridge.adsession.AdSession r0 = com.mbridge.msdk.a.b.a(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0419 }
            r1.am = r0     // Catch:{ all -> 0x0419 }
        L_0x00f3:
            com.mbridge.msdk.video.bt.module.b.e r0 = new com.mbridge.msdk.video.bt.module.b.e     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.b.h r7 = r1.C     // Catch:{ all -> 0x0419 }
            r0.<init>(r7)     // Catch:{ all -> 0x0419 }
            r1.registerErrorListener(r0)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.videocommon.d.c r0 = r1.m     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.A     // Catch:{ all -> 0x0419 }
            r1.a((com.mbridge.msdk.videocommon.d.c) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r7)     // Catch:{ all -> 0x0419 }
            r17.setShowingTransparent()     // Catch:{ all -> 0x0419 }
            int r0 = r17.getLayoutID()     // Catch:{ all -> 0x0419 }
            if (r0 > 0) goto L_0x0114
            java.lang.String r0 = "layoutID not found"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0419 }
            goto L_0x042e
        L_0x0114:
            android.view.LayoutInflater r7 = r1.U     // Catch:{ all -> 0x0419 }
            android.view.View r0 = r7.inflate(r0, r5)     // Catch:{ all -> 0x0419 }
            r1.z = r0     // Catch:{ all -> 0x0419 }
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0419 }
            r8 = -1
            r7.<init>(r8, r8)     // Catch:{ all -> 0x0419 }
            r1.addView(r0, r7)     // Catch:{ all -> 0x0419 }
            boolean r0 = r1.a     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x012c
            r17.setMatchParent()     // Catch:{ all -> 0x0419 }
        L_0x012c:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r17.findWindVaneWebView()     // Catch:{ all -> 0x0419 }
            r1.d = r0     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r17.findMBridgeVideoView()     // Catch:{ all -> 0x0419 }
            r1.e = r0     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.A     // Catch:{ all -> 0x0419 }
            r0.setVideoLayout(r7)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.e     // Catch:{ all -> 0x0419 }
            boolean r7 = r1.r     // Catch:{ all -> 0x0419 }
            r0.setIsIV(r7)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.e     // Catch:{ all -> 0x0419 }
            java.lang.String r7 = r1.k     // Catch:{ all -> 0x0419 }
            r0.setUnitId(r7)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.e     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.dynview.e.a r7 = r1.E     // Catch:{ all -> 0x0419 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r9 = r1.S     // Catch:{ all -> 0x0419 }
            int r10 = r1.F     // Catch:{ all -> 0x0419 }
            int r11 = r1.T     // Catch:{ all -> 0x0419 }
            r0.setCamPlayOrderCallback(r7, r9, r10, r11)     // Catch:{ all -> 0x0419 }
            boolean r0 = r1.w     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0169
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.e     // Catch:{ all -> 0x0419 }
            int r7 = r1.M     // Catch:{ all -> 0x0419 }
            int r9 = r1.N     // Catch:{ all -> 0x0419 }
            int r10 = r1.O     // Catch:{ all -> 0x0419 }
            int r11 = r1.P     // Catch:{ all -> 0x0419 }
            r0.setNotchPadding(r7, r9, r10, r11)     // Catch:{ all -> 0x0419 }
        L_0x0169:
            com.mbridge.msdk.video.module.MBridgeContainerView r0 = r17.findMBridgeContainerView()     // Catch:{ all -> 0x0419 }
            r1.f = r0     // Catch:{ all -> 0x0419 }
            boolean r0 = r1.w     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0182
            com.mbridge.msdk.video.module.MBridgeContainerView r9 = r1.f     // Catch:{ all -> 0x0419 }
            int r10 = r1.L     // Catch:{ all -> 0x0419 }
            int r11 = r1.M     // Catch:{ all -> 0x0419 }
            int r12 = r1.N     // Catch:{ all -> 0x0419 }
            int r13 = r1.O     // Catch:{ all -> 0x0419 }
            int r14 = r1.P     // Catch:{ all -> 0x0419 }
            r9.setNotchPadding(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0419 }
        L_0x0182:
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.e     // Catch:{ all -> 0x0419 }
            r7 = 1
            if (r0 == 0) goto L_0x0193
            com.mbridge.msdk.video.module.MBridgeContainerView r0 = r1.f     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0193
            boolean r0 = r17.initViews()     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0193
            r0 = 1
            goto L_0x0194
        L_0x0193:
            r0 = 0
        L_0x0194:
            if (r0 != 0) goto L_0x01a8
            com.mbridge.msdk.video.bt.module.MBTempContainer$a r0 = r1.c     // Catch:{ all -> 0x0419 }
            java.lang.String r2 = "not found View IDS"
            r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0419 }
            android.app.Activity r0 = r1.j     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x042e
            android.app.Activity r0 = r1.j     // Catch:{ all -> 0x0419 }
            r0.finish()     // Catch:{ all -> 0x0419 }
            goto L_0x042e
        L_0x01a8:
            r1.b = r7     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r15 = r1.d     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.factory.b r0 = new com.mbridge.msdk.video.signal.factory.b     // Catch:{ all -> 0x0419 }
            android.app.Activity r10 = r1.j     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.module.MBridgeVideoView r12 = r1.e     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.module.MBridgeContainerView r13 = r1.f     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r14 = r1.A     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.MBTempContainer$e r11 = new com.mbridge.msdk.video.bt.module.MBTempContainer$e     // Catch:{ all -> 0x0419 }
            r11.<init>()     // Catch:{ all -> 0x0419 }
            r9 = r0
            r16 = r11
            r11 = r15
            r8 = r15
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0419 }
            r1.H = r0     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x01db
            int r0 = r0.getDynamicTempCode()     // Catch:{ all -> 0x0419 }
            r9 = 5
            if (r0 != r9) goto L_0x01db
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.S     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x01db
            com.mbridge.msdk.video.signal.factory.b r9 = r1.H     // Catch:{ all -> 0x0419 }
            r9.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ all -> 0x0419 }
        L_0x01db:
            com.mbridge.msdk.video.signal.factory.b r0 = r1.H     // Catch:{ all -> 0x0419 }
            r1.registerJsFactory(r0)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.b.a()     // Catch:{ all -> 0x0419 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0419 }
            r9.<init>()     // Catch:{ all -> 0x0419 }
            java.lang.String r10 = r1.k     // Catch:{ all -> 0x0419 }
            r9.append(r10)     // Catch:{ all -> 0x0419 }
            r9.append(r4)     // Catch:{ all -> 0x0419 }
            java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.MBTempContainer$5 r9 = new com.mbridge.msdk.video.bt.module.MBTempContainer$5     // Catch:{ all -> 0x0419 }
            r9.<init>()     // Catch:{ all -> 0x0419 }
            r0.a((java.lang.String) r4, (com.mbridge.msdk.foundation.c.a) r9)     // Catch:{ all -> 0x0419 }
            java.lang.String r0 = "preload template webview is null or load error"
            if (r8 == 0) goto L_0x0415
            android.view.View r4 = r1.z     // Catch:{ all -> 0x0419 }
            android.content.Context r9 = r17.getContext()     // Catch:{ all -> 0x0419 }
            int r9 = com.mbridge.msdk.foundation.tools.t.a(r9, r2, r3)     // Catch:{ all -> 0x0419 }
            android.view.View r4 = r4.findViewById(r9)     // Catch:{ all -> 0x0419 }
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.factory.b r9 = r1.H     // Catch:{ all -> 0x0419 }
            r8.setApiManagerJSFactory(r9)     // Catch:{ all -> 0x0419 }
            android.view.ViewParent r9 = r8.getParent()     // Catch:{ all -> 0x0419 }
            if (r9 == 0) goto L_0x0221
            r1.defaultLoad(r6, r0)     // Catch:{ all -> 0x0419 }
            goto L_0x042e
        L_0x0221:
            java.lang.Object r0 = r8.getObject()     // Catch:{ all -> 0x0419 }
            boolean r0 = r0 instanceof com.mbridge.msdk.video.signal.a.j     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x03de
            com.mbridge.msdk.video.signal.factory.b r0 = r1.H     // Catch:{ all -> 0x0419 }
            java.lang.Object r9 = r8.getObject()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.a.j r9 = (com.mbridge.msdk.video.signal.a.j) r9     // Catch:{ all -> 0x0419 }
            r0.a((com.mbridge.msdk.video.signal.a.j) r9)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ all -> 0x0419 }
            int r9 = r1.q     // Catch:{ all -> 0x0419 }
            r0.a((int) r9)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ all -> 0x0419 }
            java.lang.String r9 = r1.k     // Catch:{ all -> 0x0419 }
            r0.a((java.lang.String) r9)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.videocommon.d.c r9 = r1.m     // Catch:{ all -> 0x0419 }
            r0.a((com.mbridge.msdk.videocommon.d.c) r9)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.MBTempContainer$e r9 = new com.mbridge.msdk.video.bt.module.MBTempContainer$e     // Catch:{ all -> 0x0419 }
            r9.<init>()     // Catch:{ all -> 0x0419 }
            r0.a((com.mbridge.msdk.video.signal.c.a) r9)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x028a
            boolean r0 = r0.isMraid()     // Catch:{ all -> 0x0419 }
            if (r0 != 0) goto L_0x026d
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.A     // Catch:{ all -> 0x0419 }
            boolean r0 = r0.isActiveOm()     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x028a
        L_0x026d:
            com.mbridge.msdk.mbsignalcommon.mraid.d r0 = new com.mbridge.msdk.mbsignalcommon.mraid.d     // Catch:{ all -> 0x0419 }
            android.content.Context r5 = r17.getContext()     // Catch:{ all -> 0x0419 }
            r0.<init>(r5)     // Catch:{ all -> 0x0419 }
            r1.al = r0     // Catch:{ all -> 0x0419 }
            r0.c()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.mbsignalcommon.mraid.d r0 = r1.al     // Catch:{ all -> 0x0419 }
            r0.a()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.mbsignalcommon.mraid.d r0 = r1.al     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.bt.module.MBTempContainer$6 r5 = new com.mbridge.msdk.video.bt.module.MBTempContainer$6     // Catch:{ all -> 0x0419 }
            r5.<init>()     // Catch:{ all -> 0x0419 }
            r0.a(r5)     // Catch:{ all -> 0x0419 }
        L_0x028a:
            java.lang.Object r0 = r8.getObject()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.a.j r0 = (com.mbridge.msdk.video.signal.a.j) r0     // Catch:{ all -> 0x0419 }
            int r0 = r0.o()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.e r5 = r17.getJSContainerModule()     // Catch:{ all -> 0x0419 }
            r5.readyStatus(r0)     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r1.d     // Catch:{ Exception -> 0x03be }
            if (r0 == 0) goto L_0x03c6
            android.content.res.Resources r0 = r17.getResources()     // Catch:{ Exception -> 0x03be }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x03be }
            int r0 = r0.orientation     // Catch:{ Exception -> 0x03be }
            boolean r5 = r17.d()     // Catch:{ Exception -> 0x03be }
            if (r5 == 0) goto L_0x02d8
            android.content.Context r5 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            int r5 = com.mbridge.msdk.foundation.tools.af.j((android.content.Context) r5)     // Catch:{ Exception -> 0x03be }
            android.content.Context r9 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            int r9 = com.mbridge.msdk.foundation.tools.af.k((android.content.Context) r9)     // Catch:{ Exception -> 0x03be }
            android.content.Context r10 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            boolean r10 = com.mbridge.msdk.foundation.tools.af.a(r10)     // Catch:{ Exception -> 0x03be }
            if (r10 == 0) goto L_0x02e8
            android.content.Context r10 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            int r10 = com.mbridge.msdk.foundation.tools.af.l((android.content.Context) r10)     // Catch:{ Exception -> 0x03be }
            r11 = 2
            if (r0 != r11) goto L_0x02d6
            int r5 = r5 + r10
            goto L_0x02e8
        L_0x02d6:
            int r9 = r9 + r10
            goto L_0x02e8
        L_0x02d8:
            android.content.Context r5 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            int r5 = com.mbridge.msdk.foundation.tools.af.i((android.content.Context) r5)     // Catch:{ Exception -> 0x03be }
            android.content.Context r9 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            int r9 = com.mbridge.msdk.foundation.tools.af.h((android.content.Context) r9)     // Catch:{ Exception -> 0x03be }
        L_0x02e8:
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.A     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r10 = r10.getRewardTemplateMode()     // Catch:{ Exception -> 0x03be }
            int r10 = r10.c()     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r1.A     // Catch:{ Exception -> 0x03be }
            int r11 = r1.c(r11)     // Catch:{ Exception -> 0x03be }
            if (r11 != r7) goto L_0x02fb
            r10 = r0
        L_0x02fb:
            com.mbridge.msdk.video.signal.f r11 = r17.getJSNotifyProxy()     // Catch:{ Exception -> 0x03be }
            r11.a(r0, r10, r5, r9)     // Catch:{ Exception -> 0x03be }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x03be }
            r5.<init>()     // Catch:{ Exception -> 0x03be }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ Exception -> 0x03be }
            android.content.Context r9 = r17.getContext()     // Catch:{ Exception -> 0x03be }
            float r9 = com.mbridge.msdk.foundation.tools.af.e((android.content.Context) r9)     // Catch:{ Exception -> 0x03be }
            double r9 = (double) r9     // Catch:{ Exception -> 0x03be }
            r5.put(r0, r9)     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.videocommon.b.c r0 = r1.o     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            if (r0 == 0) goto L_0x036a
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r0.<init>()     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r9 = "name"
            com.mbridge.msdk.videocommon.b.c r10 = r1.o     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r10 = r10.a()     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r0.put(r9, r10)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r9 = "amount"
            com.mbridge.msdk.videocommon.b.c r10 = r1.o     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            int r10 = r10.b()     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r0.put(r9, r10)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r9 = r1.p     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r0.put(r3, r9)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r9 = "userId"
            java.lang.String r10 = r1.n     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r5.put(r9, r10)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r9 = "reward"
            r5.put(r9, r0)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r0 = "playVideoMute"
            int r9 = r1.q     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r5.put(r0, r9)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            java.lang.String r0 = "extra"
            java.lang.String r9 = r1.R     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            r5.put(r0, r9)     // Catch:{ JSONException -> 0x0360, Exception -> 0x0355 }
            goto L_0x036a
        L_0x0355:
            r0 = move-exception
            java.lang.String r9 = y     // Catch:{ Exception -> 0x03be }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r9, (java.lang.String) r0)     // Catch:{ Exception -> 0x03be }
            goto L_0x036a
        L_0x0360:
            r0 = move-exception
            java.lang.String r9 = y     // Catch:{ Exception -> 0x03be }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r9, (java.lang.String) r0)     // Catch:{ Exception -> 0x03be }
        L_0x036a:
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x03be }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x038e }
            r5.<init>()     // Catch:{ Exception -> 0x038e }
            java.lang.String r9 = "type"
            java.lang.String r10 = "2"
            r5.put(r9, r10)     // Catch:{ Exception -> 0x038e }
            java.lang.String r9 = "update"
            java.lang.String r10 = "1"
            r5.put(r9, r10)     // Catch:{ Exception -> 0x038e }
            com.mbridge.msdk.foundation.same.report.m r9 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x038e }
            java.lang.String r10 = "2000133"
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r1.A     // Catch:{ Exception -> 0x038e }
            r9.a((java.lang.String) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r11, (java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ Exception -> 0x038e }
        L_0x038e:
            com.mbridge.msdk.video.signal.f r5 = r17.getJSNotifyProxy()     // Catch:{ Exception -> 0x03be }
            r5.a((java.lang.Object) r0)     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.mbsignalcommon.windvane.g r0 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r1.d     // Catch:{ Exception -> 0x03be }
            java.lang.String r9 = "oncutoutfetched"
            java.lang.String r10 = r1.Q     // Catch:{ Exception -> 0x03be }
            byte[] r10 = r10.getBytes()     // Catch:{ Exception -> 0x03be }
            java.lang.String r6 = android.util.Base64.encodeToString(r10, r6)     // Catch:{ Exception -> 0x03be }
            r0.a((android.webkit.WebView) r5, (java.lang.String) r9, (java.lang.String) r6)     // Catch:{ Exception -> 0x03be }
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ Exception -> 0x03be }
            r0.b((boolean) r7)     // Catch:{ Exception -> 0x03be }
            r17.loadModuleDatas()     // Catch:{ Exception -> 0x03be }
            android.os.Handler r0 = r1.g     // Catch:{ Exception -> 0x03be }
            java.lang.Runnable r5 = r1.h     // Catch:{ Exception -> 0x03be }
            r9 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r5, r9)     // Catch:{ Exception -> 0x03be }
            goto L_0x03c6
        L_0x03be:
            r0 = move-exception
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0419 }
            if (r5 == 0) goto L_0x03c6
            r0.printStackTrace()     // Catch:{ all -> 0x0419 }
        L_0x03c6:
            java.lang.Object r0 = r8.getObject()     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.a.j r0 = (com.mbridge.msdk.video.signal.a.j) r0     // Catch:{ all -> 0x0419 }
            com.mbridge.msdk.video.signal.c$a r0 = r0.l     // Catch:{ all -> 0x0419 }
            r0.a()     // Catch:{ all -> 0x0419 }
            boolean r0 = r1.w     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x03de
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ all -> 0x0419 }
            int r5 = r1.W     // Catch:{ all -> 0x0419 }
            r0.e(r5)     // Catch:{ all -> 0x0419 }
        L_0x03de:
            com.mbridge.msdk.video.signal.c r0 = r17.getJSCommon()     // Catch:{ all -> 0x0419 }
            int r0 = r0.a()     // Catch:{ all -> 0x0419 }
            if (r0 != r7) goto L_0x0408
            android.view.View r0 = r1.z     // Catch:{ all -> 0x0419 }
            android.content.Context r5 = r17.getContext()     // Catch:{ all -> 0x0419 }
            int r2 = com.mbridge.msdk.foundation.tools.t.a(r5, r2, r3)     // Catch:{ all -> 0x0419 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0419 }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0408
            android.view.View r2 = r1.z     // Catch:{ all -> 0x0419 }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0419 }
            r2.removeView(r0)     // Catch:{ all -> 0x0419 }
            android.view.View r2 = r1.z     // Catch:{ all -> 0x0419 }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0419 }
            r2.addView(r0, r7)     // Catch:{ all -> 0x0419 }
        L_0x0408:
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0419 }
            r2 = -1
            r0.<init>(r2, r2)     // Catch:{ all -> 0x0419 }
            r4.addView(r8, r0)     // Catch:{ all -> 0x0419 }
            r17.g()     // Catch:{ all -> 0x0419 }
            goto L_0x042e
        L_0x0415:
            r1.defaultLoad(r6, r0)     // Catch:{ all -> 0x0419 }
            goto L_0x042e
        L_0x0419:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "onCreate error"
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.a((java.lang.String) r0)
        L_0x042e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.onCreate():void");
    }

    public void loadModuleDatas() {
        int i2;
        int i3;
        int i4;
        j b2 = b(this.A);
        if (b2 != null) {
            i2 = b2.k();
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            this.q = i2;
        }
        int f2 = this.m.f();
        int c2 = c();
        int i5 = c2 != 0 ? c2 : f2;
        this.e.setSoundState(this.q);
        this.e.setCampaign(this.A);
        this.e.setPlayURL(this.B.s());
        CampaignEx campaignEx = this.A;
        if (campaignEx == null || campaignEx.getVst() <= -2) {
            i3 = this.m.e();
        } else {
            i3 = this.A.getVst();
        }
        CampaignEx campaignEx2 = this.A;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i4 = this.F) > 1) {
            i3 = a(i3, i4);
            this.A.setVst(i3);
        }
        this.e.setVideoSkipTime(i3);
        this.e.setCloseAlert(this.m.i());
        this.e.setBufferTimeout(h());
        MBridgeVideoView mBridgeVideoView = this.e;
        com.mbridge.msdk.video.signal.factory.b bVar = this.H;
        CampaignEx campaignEx3 = this.A;
        com.mbridge.msdk.videocommon.b.c cVar = this.o;
        com.mbridge.msdk.videocommon.download.a aVar = this.B;
        String b3 = b();
        String str = this.k;
        f fVar = new f();
        int i6 = i3;
        int z2 = this.m.z();
        int i7 = i3;
        n nVar = r3;
        n nVar2 = new n(bVar, campaignEx3, cVar, aVar, b3, str, i5, i6, fVar, z2, this.w, this.m.D());
        mBridgeVideoView.setNotifyListener(nVar);
        this.e.setShowingTransparent(this.af);
        this.e.setAdSession(this.am);
        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.o || this.t == com.mbridge.msdk.foundation.same.a.p)) {
            this.e.setIVRewardEnable(this.t, this.u, this.v);
            this.e.setDialogRole(getJSCommon() != null ? getJSCommon().h() : 1);
        }
        this.f.setCampaign(this.A);
        this.f.addOrderViewData(this.S);
        this.f.setUnitID(this.k);
        this.f.setCloseDelayTime(i());
        this.f.setPlayCloseBtnTm(this.m.h());
        this.f.setVideoInteractiveType(this.m.g());
        this.f.setEndscreenType(this.m.q());
        this.f.setVideoSkipTime(i7);
        this.f.setShowingTransparent(this.af);
        this.f.setJSFactory(this.H);
        if (this.A.getPlayable_ads_without_video() == 2) {
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.A, this.B, this.o, b(), this.k, new d(), this.m.z(), this.w));
            this.f.preLoadData(this.H);
            this.f.showPlayableView();
        } else {
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.c(this.H, this.A, this.o, this.B, b(), this.k, new c(this.j, this.A), this.m.z(), this.w));
            this.f.preLoadData(this.H);
            this.e.preLoadData(this.H);
        }
        if (this.af) {
            this.f.setMBridgeClickMiniCardViewTransparent();
        }
    }

    static /* synthetic */ void m(MBTempContainer mBTempContainer) {
        try {
            if (mBTempContainer.D != null) {
                if (mBTempContainer.r && (mBTempContainer.t == com.mbridge.msdk.foundation.same.a.o || mBTempContainer.t == com.mbridge.msdk.foundation.same.a.p)) {
                    com.mbridge.msdk.video.bt.module.a.b bVar = mBTempContainer.D;
                    boolean z2 = true;
                    if (mBTempContainer.J != 1) {
                        z2 = false;
                    }
                    bVar.a(z2, mBTempContainer.I);
                }
                mBTempContainer.D.a(mBTempContainer.G, mBTempContainer.ac, mBTempContainer.o);
            } else if (mBTempContainer.j != null) {
                mBTempContainer.j.finish();
            }
        } catch (Exception unused) {
            if (mBTempContainer.j != null) {
                mBTempContainer.j.finish();
            }
        }
    }

    static /* synthetic */ void F(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.j.runOnUiThread(new Runnable() {
                public final void run() {
                    MBTempContainer.this.aa.setBackgroundColor(0);
                    MBTempContainer.this.aa.setVisibility(0);
                    MBTempContainer.this.aa.bringToFront();
                }
            });
        }
    }

    static /* synthetic */ void H(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.j.runOnUiThread(new Runnable() {
                public final void run() {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            });
        }
    }
}
