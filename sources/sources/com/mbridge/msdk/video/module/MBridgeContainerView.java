package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.video.dynview.moffer.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.a.a.l;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MBridgeContainerView extends MBridgeBaseView implements e, g {
    private int A = 1;
    private int B = 1;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = true;
    private boolean G = false;
    private boolean H = false;
    private int I;
    private boolean J = false;
    private boolean K = false;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private b R;
    private boolean S = false;
    private boolean T = false;
    private List<CampaignEx> U = new ArrayList();
    private MBridgePlayableView n;
    private MBridgeClickCTAView o;
    private MBridgeClickMiniCardView p;
    private MBridgeNativeEndCardView q;
    private MBridgeH5EndCardView r;
    private MBridgeVastEndCardView s;
    private MBridgeLandingPageView t;
    private MBridgeVideoEndCoverView u;
    private MBridgeAlertWebview v;
    private MBridgeOrderCampView w;
    /* access modifiers changed from: private */
    public String x;
    private int y;
    private int z = 1;

    public void setJSFactory(b bVar) {
        this.R = bVar;
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list != null) {
            this.U = list;
        }
    }

    public int getVideoSkipTime() {
        return this.I;
    }

    public void setVideoSkipTime(int i) {
        this.I = i;
    }

    public MBridgeContainerView(Context context) {
        super(context);
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        setVisibility(0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u};
        for (int i = 0; i < 8; i++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i];
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.R = bVar;
        if (this.b != null) {
            if (this.b.getPlayable_ads_without_video() == 2) {
                if (this.n == null) {
                    this.n = new MBridgePlayableView(this.a);
                }
                this.n.setCloseDelayShowTime(this.A);
                this.n.setPlayCloseBtnTm(this.B);
                this.n.setCampaign(this.b);
                this.n.setNotifyListener(new i(this.e) {
                    public final void a(int i, Object obj) {
                        super.a(i, obj);
                        if (i == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            n nVar = new n();
                            nVar.n(MBridgeContainerView.this.b.getRequestId());
                            nVar.p(MBridgeContainerView.this.b.getRequestIdNotice());
                            nVar.r(MBridgeContainerView.this.b.getId());
                            nVar.b(MBridgeContainerView.this.b.isMraid() ? n.a : n.b);
                            com.mbridge.msdk.foundation.same.report.n.a(nVar, MBridgeContainerView.this.a, MBridgeContainerView.this.x);
                        }
                    }
                });
                this.n.preLoadData(bVar);
            } else {
                b(this.y);
                if (this.b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.b.getVideo_end_type()));
                    } catch (Throwable th) {
                        aa.d(MBridgeBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                            public final void run() {
                                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                                mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.b.getVideo_end_type()));
                            }
                        });
                    }
                    if (!af.j(this.b.getendcard_url())) {
                        try {
                            String a = al.a(this.b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a) && Integer.parseInt(a) == 1) {
                                a.a().a(this.b, 2);
                            }
                        } catch (Exception e) {
                            aa.d(MBridgeBaseView.TAG, e.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.b.getVideo_end_type()));
                        }
                    }, (long) getVideoSkipTime());
                }
            }
            g();
        }
    }

    public void showPlayableView() {
        if (this.b != null && !this.H) {
            removeAllViews();
            setMatchParent();
            if (this.n == null) {
                preLoadData(this.R);
            }
            addView(this.n);
            MBridgePlayableView mBridgePlayableView = this.n;
            if (mBridgePlayableView != null) {
                mBridgePlayableView.setUnitId(this.x);
                if (this.b != null && this.b.isMraid() && this.b.getPlayable_ads_without_video() == 2) {
                    this.n.setCloseVisible(0);
                }
                this.n.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
            }
            this.T = true;
            bringToFront();
        }
    }

    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.v;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1) && !this.T) {
            removeAllViews();
            bringToFront();
            this.S = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.v == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.v;
        if (!(mBridgeAlertWebview2 == null || mBridgeAlertWebview2.getParent() == null)) {
            removeView(this.v);
        }
        addView(this.v);
        setBackgroundColor(0);
        this.v.webviewshow();
        return true;
    }

    public void showVideoClickView(int i) {
        if (this.b == null) {
            return;
        }
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    MBridgeClickCTAView mBridgeClickCTAView = this.o;
                    if (!(mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null)) {
                        removeView(this.o);
                    }
                    MBridgeAlertWebview mBridgeAlertWebview = this.v;
                    if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
                        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getParent() == null) {
                            try {
                                if (this.b != null && this.b.getPlayable_ads_without_video() == 1) {
                                    setMatchParent();
                                    f();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (miniCardLoaded()) {
                            MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
                            if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.getParent() == null)) {
                                removeView(this.r);
                            }
                            this.e.a(112, "");
                            if (this.b != null && !this.b.isHasReportAdTrackPause()) {
                                this.b.setHasReportAdTrackPause(true);
                                com.mbridge.msdk.video.module.b.b.f(this.a, this.b);
                            }
                            if (this.E) {
                                this.e.a(115, "");
                            } else {
                                this.T = true;
                                bringToFront();
                                webviewshow();
                                onConfigurationChanged(getResources().getConfiguration());
                            }
                            this.D = true;
                            return;
                        }
                        h();
                    }
                }
            } else if (!this.C) {
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.r;
                if (!(mBridgeH5EndCardView2 == null || mBridgeH5EndCardView2.getParent() == null)) {
                    removeView(this.r);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.p;
                if (!(mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null)) {
                    removeView(this.p);
                }
                MBridgeClickCTAView mBridgeClickCTAView2 = this.o;
                if (mBridgeClickCTAView2 == null || mBridgeClickCTAView2.getParent() == null) {
                    try {
                        if (this.b != null && this.b.getPlayable_ads_without_video() == 1) {
                            this.T = true;
                            if (this.o == null) {
                                b(-1);
                            }
                            if (this.o != null) {
                                if (this.b == null || !this.b.isDynamicView()) {
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                    layoutParams.addRule(12, -1);
                                    addView(this.o, 0, layoutParams);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                }
            }
        } else if (!isLast() && !endCardShowing()) {
            h();
        }
    }

    public void showEndcard(int i) {
        if (this.b != null) {
            if (i == 1) {
                this.e.a(104, "");
            } else if (i == 100) {
                if (this.b.getPlayable_ads_without_video() == 2) {
                    this.H = true;
                }
                a((View) this.n);
                setMatchParent();
                e();
            } else if (i == 3) {
                removeAllViews();
                setMatchParent();
                if (this.s == null) {
                    a(this.R, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.s, layoutParams);
                this.s.notifyShowListener();
                this.T = true;
                bringToFront();
            } else if (i == 4) {
                this.e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.t == null) {
                    a(this.R, 4);
                }
                this.t.setUnitId(this.x);
                this.t.preLoadData(this.R);
                addView(this.t);
                this.T = true;
                bringToFront();
            } else if (i != 5) {
                removeAllViews();
                setMatchParent();
                this.T = true;
                bringToFront();
                a();
                this.e.a(117, "");
            } else {
                this.e.a(106, "");
            }
        }
        this.C = true;
    }

    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.u;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.R;
            this.R = bVar;
            if (mBridgeVideoEndCoverView == null) {
                MBridgeVideoEndCoverView mBridgeVideoEndCoverView2 = new MBridgeVideoEndCoverView(this.a);
                this.u = mBridgeVideoEndCoverView2;
                mBridgeVideoEndCoverView2.setCampaign(this.b);
                this.u.setNotifyListener(new i(this.e));
                this.u.preLoadData(bVar);
            }
        }
        addView(this.u);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.a);
        this.w = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.U);
        if (this.e != null && (this.e instanceof k)) {
            ((k) this.e).a(this.U);
        }
        this.w.setNotifyListener(new i(this.e));
        this.w.setRewarded(this.K);
        this.w.setNotchPadding(this.L, this.M, this.N, this.O);
        this.w.setCampOrderViewBuildCallback(new com.mbridge.msdk.video.dynview.e.b() {
            public final void a() {
                if (MBridgeContainerView.this.e != null) {
                    MBridgeContainerView.this.e.a(117, "");
                }
            }

            public final void b() {
                if (MBridgeContainerView.this.b.getAdSpaceT() == 2) {
                    MBridgeContainerView.this.showVideoEndCover();
                    return;
                }
                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                mBridgeContainerView.showEndcard(mBridgeContainerView.b.getVideo_end_type());
            }
        });
        this.w.createView(this);
    }

    public boolean endCardShowing() {
        return this.C;
    }

    public boolean miniCardShowing() {
        return this.D;
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        return mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.isLoadSuccess();
    }

    public void toggleCloseBtn(int i) {
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i);
        }
    }

    public void notifyCloseBtn(int i) {
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i);
        }
    }

    public void triggerCloseBtn(String str) {
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
        if (this.b != null) {
            this.e.a(122, "");
            this.e.a(104, "");
        }
    }

    public void readyStatus(int i) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i);
        }
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.J) {
                return;
            }
        }
        a();
    }

    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i, i2, i3, i4);
            this.p.setRadius(i5);
            this.p.setCloseVisible(8);
            this.p.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            f();
            if (!this.G) {
                this.G = true;
                this.e.a(109, "");
                this.e.a(117, "");
            }
        }
    }

    public void resizeMiniCard(int i, int i2, int i3) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i, i2);
            this.p.setRadius(i3);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            f();
        }
    }

    public void configurationChanged(int i, int i2, int i3) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getVisibility() == 0) {
            this.p.resizeMiniCard(i, i2);
        }
    }

    public void webviewshow() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type", ExifInterface.GPS_MEASUREMENT_3D);
            hashMap.put("update", "1");
            m.a().a("2000133", this.b, (Map<String, String>) hashMap);
        } catch (Exception unused) {
        }
        a(this.n, this.p, this.r, this.v);
    }

    public void install(CampaignEx campaignEx) {
        this.e.a(105, campaignEx);
    }

    public void orientation(Configuration configuration) {
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.n, this.p, this.r, this.v};
        for (int i = 0; i < 4; i++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    public void setNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        super.setNotifyListener(aVar);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u};
        for (int i = 0; i < 8; i++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i];
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.p, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public void addView(View view) {
        if (view != null) {
            a(view);
            super.addView(view);
            return;
        }
        aa.d(MBridgeBaseView.TAG, "view is null");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
            return;
        }
        aa.d(MBridgeBaseView.TAG, "view is null");
    }

    public boolean canBackPress() {
        if (this.q != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.t;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        return mBridgeH5EndCardView != null && mBridgeH5EndCardView.isPlayable();
    }

    public void setShowingTransparent(boolean z2) {
        this.E = z2;
    }

    public boolean getShowingTransparent() {
        return this.E;
    }

    public String getUnitID() {
        return this.x;
    }

    public void setUnitID(String str) {
        this.x = str;
    }

    public void setVideoInteractiveType(int i) {
        if (this.b == null || !this.b.isDynamicView()) {
            this.y = i;
            return;
        }
        int a = com.mbridge.msdk.video.dynview.i.a.a(this.b);
        if (a == 100) {
            this.y = i;
        } else {
            this.y = a;
        }
    }

    public void setEndscreenType(int i) {
        this.z = i;
    }

    public int getVideoInteractiveType() {
        return this.y;
    }

    public void setCloseDelayTime(int i) {
        this.A = i;
    }

    public void setPlayCloseBtnTm(int i) {
        this.B = i;
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private void a() {
        if (this.b != null) {
            boolean isDynamicView = this.b.isDynamicView();
            boolean j = af.j(this.b.getendcard_url());
            if (isDynamicView && !j) {
                e();
                return;
            }
        }
        if (this.z != 2 || this.J) {
            e();
        } else {
            b();
        }
    }

    private void b() {
        if (this.r == null) {
            a(this.R, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.r;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.r.setError(true);
            }
        } else {
            this.J = true;
            addView(this.r);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.r.excuteTask();
            this.r.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
            n nVar = new n();
            nVar.n(this.b.getRequestId());
            nVar.p(this.b.getRequestIdNotice());
            nVar.r(this.b.getId());
            nVar.b(this.b.isMraid() ? n.a : n.b);
            com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a, this.x);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.r;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.x);
        }
    }

    private void e() {
        this.z = 1;
        if (this.q == null) {
            a(this.R, 2);
        }
        addView(this.q);
        onConfigurationChanged(getResources().getConfiguration());
        this.q.notifyShowListener();
        this.T = true;
        bringToFront();
    }

    private void f() {
        if (this.p == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.E && this.F) {
            this.F = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.p, layoutParams);
    }

    private void g() {
        if (this.v == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.a);
            this.v = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.x);
            this.v.setCampaign(this.b);
        }
        this.v.preLoadData(this.R);
    }

    /* access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        this.R = bVar;
        if (this.b != null) {
            if (num == null) {
                num = Integer.valueOf(this.b.getVideo_end_type());
            }
            if (!isLast()) {
                h();
            }
            int intValue = num.intValue();
            if (intValue == 1) {
                return;
            }
            if (intValue == 3) {
                if (this.s == null) {
                    this.s = new MBridgeVastEndCardView(this.a);
                }
                this.s.setCampaign(this.b);
                this.s.setNotifyListener(new l(this.e));
                this.s.preLoadData(bVar);
            } else if (intValue == 4) {
                if (this.t == null) {
                    this.t = new MBridgeLandingPageView(this.a);
                }
                this.t.setCampaign(this.b);
                this.t.setNotifyListener(new i(this.e));
            } else if (intValue == 5) {
            } else {
                if (this.z == 2) {
                    boolean isDynamicView = this.b.isDynamicView();
                    boolean j = af.j(this.b.getendcard_url());
                    if ((this.b == null || !isDynamicView || j) && this.b.getAdSpaceT() != 2) {
                        if (this.r == null) {
                            this.r = new MBridgeH5EndCardView(this.a);
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", ExifInterface.GPS_MEASUREMENT_3D);
                                m.a().a("2000154", this.b, (Map<String, String>) hashMap);
                            } catch (Throwable th) {
                                aa.d(MBridgeBaseView.TAG, th.getMessage());
                            }
                        }
                        if (this.b.getDynamicTempCode() == 5 && this.e != null && (this.e instanceof k)) {
                            ((k) this.e).a(this.b);
                        }
                        this.r.setCampaign(this.b);
                        this.r.setCloseDelayShowTime(this.A);
                        this.r.setNotifyListener(new i(this.e));
                        this.r.setUnitId(this.x);
                        this.r.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
                        this.r.preLoadData(bVar);
                        if (!this.E) {
                            addView(this.r);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int c = (this.b == null || this.b.getRewardTemplateMode() == null) ? 0 : this.b.getRewardTemplateMode().c();
                if (this.q == null) {
                    if (this.b.isDynamicView()) {
                        i();
                    } else {
                        MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(this.a, (AttributeSet) null, false, -1, this.b.getAdSpaceT() == 2, c, this.b.getMof_tplid());
                        this.q = mBridgeNativeEndCardView;
                        mBridgeNativeEndCardView.setCampaign(this.b);
                    }
                }
                this.q.setLayout();
                if (this.b.isDynamicView()) {
                    a a = a.a();
                    if (a.a(this.b.getRequestId() + "_" + this.b.getId())) {
                        try {
                            a a2 = a.a();
                            MBridgeNativeEndCardView mBridgeNativeEndCardView2 = this.q;
                            a2.a(mBridgeNativeEndCardView2, this.b.getRequestId() + "_" + this.b.getId(), new i(this.e));
                        } catch (Exception e) {
                            aa.d(MBridgeBaseView.TAG, e.getMessage());
                        }
                    } else {
                        try {
                            String a3 = al.a(this.b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a3) && Integer.parseInt(a3) == 1) {
                                a.a().a(this.b, this.q, new i(this.e), 2);
                            }
                        } catch (Exception e2) {
                            aa.d(MBridgeBaseView.TAG, e2.getMessage());
                        }
                    }
                }
                this.q.setUnitId(this.x);
                this.q.setCloseBtnDelay(this.A);
                this.q.setNotifyListener(new i(this.e));
                this.q.preLoadData(bVar);
                this.q.setNotchPadding(this.L, this.M, this.N, this.O);
            }
        }
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || viewGroup.indexOfChild(this) != 0) {
            return false;
        }
        return true;
    }

    private void h() {
        this.D = false;
        this.T = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i);
                if (!(childAt instanceof MBridgeContainerView)) {
                    viewGroup.bringChildToFront(childAt);
                } else {
                    i++;
                }
            }
        }
    }

    private void b(int i) {
        if (i == -3) {
            return;
        }
        if (i != -2) {
            if (this.o == null) {
                this.o = new MBridgeClickCTAView(this.a);
            }
            this.o.setCampaign(this.b);
            this.o.setUnitId(this.x);
            this.o.setNotifyListener(new i(this.e));
            this.o.preLoadData(this.R);
        } else if (this.b != null && this.b.getVideo_end_type() == 2) {
            if (this.p == null) {
                this.p = new MBridgeClickMiniCardView(this.a);
            }
            this.p.setCampaign(this.b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
            mBridgeClickMiniCardView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(mBridgeClickMiniCardView, this.e));
            this.p.preLoadData(this.R);
            setMatchParent();
            f();
            h();
        }
    }

    private void a(MBridgeH5EndCardView... mBridgeH5EndCardViewArr) {
        for (MBridgeH5EndCardView mBridgeH5EndCardView : mBridgeH5EndCardViewArr) {
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    public CampaignEx getReSetCampaign() {
        if (!this.b.isDynamicView() || !TextUtils.isEmpty(this.b.getendcard_url())) {
            return null;
        }
        int size = this.U.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                if (this.U.get(i2) != null && this.U.get(i2).getId() == this.b.getId()) {
                    i = i2 - 1;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i < 0 || i >= size || this.U.get(i) == null) {
            return null;
        }
        return this.U.get(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.b
            java.lang.String r0 = r0.getendcard_url()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 404(0x194, float:5.66E-43)
            if (r1 != 0) goto L_0x0029
            java.lang.String r1 = "ecid"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r0, r1)     // Catch:{ all -> 0x001f }
            int r2 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x001f }
            r7 = r2
            goto L_0x002b
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = "MBridgeBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
        L_0x0029:
            r7 = 404(0x194, float:5.66E-43)
        L_0x002b:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r0 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView
            android.content.Context r4 = r11.a
            r5 = 0
            r6 = 1
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.b
            int r1 = r1.getAdSpaceT()
            r2 = 2
            if (r1 != r2) goto L_0x003d
            r1 = 1
            r8 = 1
            goto L_0x003f
        L_0x003d:
            r1 = 0
            r8 = 0
        L_0x003f:
            int r9 = r11.l
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.b
            int r10 = r1.getMof_tplid()
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r11.q = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.b
            int r0 = r0.getDynamicTempCode()
            r1 = 5
            if (r0 != r1) goto L_0x0071
            com.mbridge.msdk.video.module.a.a r0 = r11.e
            if (r0 == 0) goto L_0x0069
            com.mbridge.msdk.video.module.a.a r0 = r11.e
            boolean r0 = r0 instanceof com.mbridge.msdk.video.module.a.a.k
            if (r0 == 0) goto L_0x0069
            com.mbridge.msdk.video.module.a.a r0 = r11.e
            com.mbridge.msdk.video.module.a.a.k r0 = (com.mbridge.msdk.video.module.a.a.k) r0
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.b
            r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r1)
        L_0x0069:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r0 = r11.q
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.b
            r0.setCampaign(r1)
            goto L_0x0078
        L_0x0071:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r0 = r11.q
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.b
            r0.setCampaign(r1)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeContainerView.i():void");
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.p.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.D) {
            this.e.a(107, "");
        }
    }

    public void onEndcardBackPress() {
        if (this.q != null || this.s != null) {
            this.e.a(104, "");
            try {
                a.a().b();
            } catch (Exception e) {
                aa.d(MBridgeBaseView.TAG, e.getMessage());
            }
        } else if (this.t != null) {
            this.e.a(103, "");
        } else {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.onBackPress();
            }
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.r = null;
        }
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.t;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.q.release();
        }
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        return mBridgeH5EndCardView == null ? this.n : mBridgeH5EndCardView;
    }

    public void hideAlertWebview() {
        if (!isLast()) {
            if (this.S && !this.T) {
                h();
                this.S = false;
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.v;
            if (mBridgeAlertWebview != null && mBridgeAlertWebview.getParent() != null) {
                removeView(this.v);
                MBridgeClickCTAView mBridgeClickCTAView = this.o;
                if (mBridgeClickCTAView != null && mBridgeClickCTAView.getParent() != null) {
                    setWrapContent();
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
                    }
                }
            }
        }
    }

    public void ivRewardAdsWithoutVideo(String str) {
        this.e.a(103, str);
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        aa.d(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i)}));
        this.P = i;
        this.L = i2;
        this.M = i3;
        this.N = i4;
        this.O = i5;
        this.Q = o.a(i, i2, i3, i4, i5);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i2, i3, i4, i5);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.q == null)) {
            this.r.setNotchValue(this.Q, i2, i3, i4, i5);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.r.q, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.n;
        if (!(mBridgePlayableView == null || mBridgePlayableView.q == null)) {
            this.n.setNotchValue(this.Q, i2, i3, i4, i5);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.n.q, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.w;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i2, i3, i4, i5);
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setRewardStatus(boolean z2) {
        this.K = z2;
    }
}
