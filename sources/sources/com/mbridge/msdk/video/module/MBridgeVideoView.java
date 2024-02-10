package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class MBridgeVideoView extends MBridgeBaseView implements i {
    /* access modifiers changed from: private */
    public static boolean al = false;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;
    /* access modifiers changed from: private */
    public ImageView A;
    /* access modifiers changed from: private */
    public MBridgeSegmentsProgressBar B;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.module.a.a C;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.dynview.e.a D;
    /* access modifiers changed from: private */
    public int E = 0;
    /* access modifiers changed from: private */
    public boolean F;
    /* access modifiers changed from: private */
    public FrameLayout G;
    private MBridgeClickCTAView H;
    private com.mbridge.msdk.video.signal.factory.b I;
    /* access modifiers changed from: private */
    public int J;
    private RelativeLayout K;
    private boolean L = false;
    /* access modifiers changed from: private */
    public boolean M = false;
    /* access modifiers changed from: private */
    public boolean N = false;
    private String O;
    private int P;
    private int Q;
    private int R;
    private MBAlertDialog S;
    private com.mbridge.msdk.widget.dialog.a T;
    /* access modifiers changed from: private */
    public String U = "";
    private double V;
    private double W;
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public AlphaAnimation aB;
    private MBridgeBaitClickView aC;
    /* access modifiers changed from: private */
    public int aD = 0;
    /* access modifiers changed from: private */
    public int aE = 5;
    private int aF = 5;
    /* access modifiers changed from: private */
    public int aG = 5;
    private AcquireRewardPopViewParameters aH;
    /* access modifiers changed from: private */
    public MBAcquireRewardPopView aI;
    private b aJ = new b(this);
    private boolean aK = false;
    private Runnable aL = new Runnable() {
        public final void run() {
            if (MBridgeVideoView.this.G != null) {
                MBridgeVideoView.this.G.setVisibility(8);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable aM = new Runnable() {
        public final void run() {
            if (MBridgeVideoView.this.aE <= 0) {
                MBridgeVideoView.this.showRewardPopView();
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                mBridgeVideoView.removeCallbacks(mBridgeVideoView.aM);
                return;
            }
            MBridgeVideoView.N(MBridgeVideoView.this);
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            mBridgeVideoView2.postDelayed(mBridgeVideoView2.aM, 1000);
        }
    };
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = false;
    /* access modifiers changed from: private */
    public boolean ah = false;
    private boolean ai = false;
    private int aj;
    /* access modifiers changed from: private */
    public boolean ak = false;
    private int am = 2;
    private AdSession an;
    /* access modifiers changed from: private */
    public MediaEvents ao;
    /* access modifiers changed from: private */
    public String ap;
    /* access modifiers changed from: private */
    public int aq;
    private int ar;
    private int as;
    /* access modifiers changed from: private */
    public boolean at = false;
    /* access modifiers changed from: private */
    public boolean au = false;
    /* access modifiers changed from: private */
    public boolean av = false;
    /* access modifiers changed from: private */
    public boolean aw = true;
    /* access modifiers changed from: private */
    public boolean ax = false;
    /* access modifiers changed from: private */
    public boolean ay = false;
    /* access modifiers changed from: private */
    public boolean az = false;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize = 1;
    public int mCurrPlayNum = 1;
    public int mCurrentPlayProgressTime = 0;
    public int mMuteSwitch = 0;
    /* access modifiers changed from: private */
    public PlayerView s;
    /* access modifiers changed from: private */
    public SoundImageView t;
    /* access modifiers changed from: private */
    public TextView u;
    /* access modifiers changed from: private */
    public View v;
    /* access modifiers changed from: private */
    public RelativeLayout w;
    /* access modifiers changed from: private */
    public ImageView x;
    /* access modifiers changed from: private */
    public ProgressBar y;
    /* access modifiers changed from: private */
    public FeedBackButton z;

    public void init(Context context) {
    }

    static /* synthetic */ int N(MBridgeVideoView mBridgeVideoView) {
        int i = mBridgeVideoView.aE;
        mBridgeVideoView.aE = i - 1;
        return i;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        this.C = aVar;
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, List<CampaignEx> list, int i, int i2) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.D = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i;
        this.E = i2;
        this.mCampOrderViewData = list;
        if (this.b != null && this.b.getDynamicTempCode() == 5 && (mBridgeSegmentsProgressBar = this.B) != null && this.mCampOrderViewData != null) {
            if (this.mCampaignSize > 1) {
                mBridgeSegmentsProgressBar.setVisibility(0);
                this.B.init(this.mCampaignSize, 2);
                for (int i3 = 0; i3 < this.mCampOrderViewData.size(); i3++) {
                    int videoPlayProgress = this.mCampOrderViewData.get(i3).getVideoPlayProgress();
                    if (videoPlayProgress > 0) {
                        this.B.setProgress(videoPlayProgress, i3);
                    }
                    if (this.mCampOrderViewData.get(i3).isRewardPopViewShowed) {
                        this.L = true;
                    }
                }
                return;
            }
            mBridgeSegmentsProgressBar.setVisibility(8);
        }
    }

    public boolean isShowingAlertView() {
        return this.M;
    }

    public boolean isRewardPopViewShowing() {
        return this.N;
    }

    public void setUnitId(String str) {
        this.U = str;
        b bVar = this.aJ;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public String getUnitId() {
        return this.U;
    }

    public boolean isMiniCardShowing() {
        return this.ad;
    }

    public boolean isShowingTransparent() {
        return this.ai;
    }

    public void setShowingTransparent(boolean z2) {
        this.ai = z2;
    }

    public MBridgeVideoView(Context context) {
        super(context);
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.b = campaignEx;
            this.i = campaignEx.isDynamicView();
        }
        if (this.i) {
            final c a2 = new com.mbridge.msdk.video.dynview.j.c().a((View) this, campaignEx);
            com.mbridge.msdk.video.dynview.b.a().a(a2, new g() {
                public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        if (!(this == null || aVar.a() == null)) {
                            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                            this.addView(aVar.a());
                        }
                        if (aVar.b() != null) {
                            for (View onClickListener : aVar.b()) {
                                onClickListener.setOnClickListener(new com.mbridge.msdk.widget.a() {
                                    /* access modifiers changed from: protected */
                                    public final void a(View view) {
                                        MBridgeVideoView.a(MBridgeVideoView.this, "video_play_click");
                                    }
                                });
                            }
                        }
                        boolean unused = MBridgeVideoView.this.aA = aVar.c();
                        MBridgeVideoView.this.a();
                        boolean unused2 = MBridgeVideoView.al = false;
                        int unused3 = MBridgeVideoView.this.J = a2.j();
                    }
                }

                public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                    aa.d(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
                }
            });
            return;
        }
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.c.inflate(findLayout, this);
            a();
        }
        al = false;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f = e();
        if (!this.f) {
            aa.d(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        c();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.aB = alphaAnimation;
        alphaAnimation.setDuration(200);
    }

    public void setIsIV(boolean z2) {
        this.ak = z2;
        b bVar = this.aJ;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        int i;
        super.setCampaign(campaignEx);
        b bVar = this.aJ;
        if (bVar != null) {
            bVar.a(campaignEx);
            b bVar2 = this.aJ;
            if (campaignEx == null) {
                i = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.U, false).r();
            } else if (campaignEx.getReady_rate() != -1) {
                i = campaignEx.getReady_rate();
            } else {
                i = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.U, false).r();
            }
            bVar2.a(i, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.U, false).s());
        }
    }

    public void setSoundState(int i) {
        this.am = i;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            if (!this.i) {
                this.s.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (MBridgeVideoView.this.e != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.h, MBridgeVideoView.this.s.buildH5JsonObject(0));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MBridgeVideoView.this.e.a(1, jSONObject);
                        }
                    }
                });
            } else if (com.mbridge.msdk.video.dynview.i.a.a(this.b) == -1 || com.mbridge.msdk.video.dynview.i.a.a(this.b) == 100) {
                this.s.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (MBridgeVideoView.this.e != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.h, MBridgeVideoView.this.s.buildH5JsonObject(0));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MBridgeVideoView.this.e.a(1, jSONObject);
                        }
                        if (MBridgeVideoView.this.ao != null) {
                            MBridgeVideoView.this.ao.adUserInteraction(InteractionType.CLICK);
                        }
                        MBridgeVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.t;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        Integer num = 2;
                        if (MBridgeVideoView.this.s != null && MBridgeVideoView.this.s.isSilent()) {
                            num = 1;
                        }
                        if (num.intValue() == 1) {
                            MBridgeVideoView.this.mMuteSwitch = 2;
                        } else {
                            MBridgeVideoView.this.mMuteSwitch = 1;
                        }
                        if (MBridgeVideoView.this.e != null) {
                            MBridgeVideoView.this.e.a(5, num);
                        }
                    }
                });
            }
            this.v.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "1");
                        m.a().c(MBridgeVideoView.this.b.getCurrentLRid(), "2000152", hashMap);
                        m.a().a("2000148", MBridgeVideoView.this.b, (Map<String, String>) new HashMap());
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (MBridgeVideoView.this.ak) {
                        boolean unused = MBridgeVideoView.this.az = true;
                        if (MBridgeVideoView.this.aw) {
                            MBridgeVideoView.this.b();
                        } else if (MBridgeVideoView.this.e != null) {
                            MBridgeVideoView.this.e.a(123, "");
                        }
                    } else {
                        MBridgeVideoView.this.b();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0118, code lost:
        if (r4 < r0) goto L_0x011a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012d A[Catch:{ Exception -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013a A[Catch:{ Exception -> 0x014e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r9 = this;
            boolean r0 = r9.ak     // Catch:{ Exception -> 0x014e }
            r1 = 8
            java.lang.String r2 = ""
            r3 = 2
            if (r0 == 0) goto L_0x00ec
            int r0 = r9.aq     // Catch:{ Exception -> 0x014e }
            int r4 = com.mbridge.msdk.foundation.same.a.o     // Catch:{ Exception -> 0x014e }
            if (r0 == r4) goto L_0x0015
            int r0 = r9.aq     // Catch:{ Exception -> 0x014e }
            int r4 = com.mbridge.msdk.foundation.same.a.p     // Catch:{ Exception -> 0x014e }
            if (r0 != r4) goto L_0x00ec
        L_0x0015:
            boolean r0 = r9.at     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x002f
            int r0 = r9.aq     // Catch:{ Exception -> 0x014e }
            int r1 = com.mbridge.msdk.foundation.same.a.p     // Catch:{ Exception -> 0x014e }
            if (r0 != r1) goto L_0x002e
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x002e
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            boolean r1 = r9.ax     // Catch:{ Exception -> 0x014e }
            java.lang.String r1 = r9.b((boolean) r1)     // Catch:{ Exception -> 0x014e }
            r0.a(r3, r1)     // Catch:{ Exception -> 0x014e }
        L_0x002e:
            return
        L_0x002f:
            int r0 = r9.aq     // Catch:{ Exception -> 0x014e }
            int r4 = com.mbridge.msdk.foundation.same.a.p     // Catch:{ Exception -> 0x014e }
            if (r0 != r4) goto L_0x0049
            boolean r0 = r9.az     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0049
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0048
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            boolean r1 = r9.ax     // Catch:{ Exception -> 0x014e }
            java.lang.String r1 = r9.b((boolean) r1)     // Catch:{ Exception -> 0x014e }
            r0.a(r3, r1)     // Catch:{ Exception -> 0x014e }
        L_0x0048:
            return
        L_0x0049:
            boolean r0 = r9.aw     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x00eb
            com.mbridge.msdk.playercommon.PlayerView r0 = r9.s     // Catch:{ Exception -> 0x014e }
            int r0 = r0.getCurPosition()     // Catch:{ Exception -> 0x014e }
            int r0 = r0 / 1000
            com.mbridge.msdk.playercommon.PlayerView r4 = r9.s     // Catch:{ Exception -> 0x014e }
            int r4 = r4.getDuration()     // Catch:{ Exception -> 0x014e }
            if (r4 != 0) goto L_0x0064
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r9.b     // Catch:{ Exception -> 0x014e }
            int r4 = r4.getVideoLength()     // Catch:{ Exception -> 0x014e }
            goto L_0x006a
        L_0x0064:
            com.mbridge.msdk.playercommon.PlayerView r4 = r9.s     // Catch:{ Exception -> 0x014e }
            int r4 = r4.getDuration()     // Catch:{ Exception -> 0x014e }
        L_0x006a:
            float r5 = (float) r0     // Catch:{ Exception -> 0x014e }
            float r4 = (float) r4     // Catch:{ Exception -> 0x014e }
            float r5 = r5 / r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 * r4
            int r4 = (int) r5     // Catch:{ Exception -> 0x014e }
            int r5 = r9.aq     // Catch:{ Exception -> 0x014e }
            int r6 = com.mbridge.msdk.foundation.same.a.o     // Catch:{ Exception -> 0x014e }
            if (r5 != r6) goto L_0x00b8
            r9.f()     // Catch:{ Exception -> 0x014e }
            int r5 = r9.ar     // Catch:{ Exception -> 0x014e }
            int r6 = com.mbridge.msdk.foundation.same.a.q     // Catch:{ Exception -> 0x014e }
            if (r5 != r6) goto L_0x0095
            int r5 = r9.as     // Catch:{ Exception -> 0x014e }
            if (r4 < r5) goto L_0x0095
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0094
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            boolean r1 = r9.ax     // Catch:{ Exception -> 0x014e }
            java.lang.String r1 = r9.b((boolean) r1)     // Catch:{ Exception -> 0x014e }
            r0.a(r3, r1)     // Catch:{ Exception -> 0x014e }
        L_0x0094:
            return
        L_0x0095:
            int r5 = r9.ar     // Catch:{ Exception -> 0x014e }
            int r6 = com.mbridge.msdk.foundation.same.a.r     // Catch:{ Exception -> 0x014e }
            if (r5 != r6) goto L_0x00af
            int r5 = r9.as     // Catch:{ Exception -> 0x014e }
            if (r0 < r5) goto L_0x00af
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x00ae
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            boolean r1 = r9.ax     // Catch:{ Exception -> 0x014e }
            java.lang.String r1 = r9.b((boolean) r1)     // Catch:{ Exception -> 0x014e }
            r0.a(r3, r1)     // Catch:{ Exception -> 0x014e }
        L_0x00ae:
            return
        L_0x00af:
            com.mbridge.msdk.video.module.a.a r3 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r3 == 0) goto L_0x00b8
            com.mbridge.msdk.video.module.a.a r3 = r9.e     // Catch:{ Exception -> 0x014e }
            r3.a(r1, r2)     // Catch:{ Exception -> 0x014e }
        L_0x00b8:
            int r3 = r9.aq     // Catch:{ Exception -> 0x014e }
            int r5 = com.mbridge.msdk.foundation.same.a.p     // Catch:{ Exception -> 0x014e }
            if (r3 != r5) goto L_0x00eb
            int r3 = r9.ar     // Catch:{ Exception -> 0x014e }
            int r5 = com.mbridge.msdk.foundation.same.a.q     // Catch:{ Exception -> 0x014e }
            if (r3 != r5) goto L_0x00d5
            int r3 = r9.as     // Catch:{ Exception -> 0x014e }
            if (r4 < r3) goto L_0x00d5
            r9.f()     // Catch:{ Exception -> 0x014e }
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x00d4
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x014e }
        L_0x00d4:
            return
        L_0x00d5:
            int r3 = r9.ar     // Catch:{ Exception -> 0x014e }
            int r4 = com.mbridge.msdk.foundation.same.a.r     // Catch:{ Exception -> 0x014e }
            if (r3 != r4) goto L_0x00eb
            int r3 = r9.as     // Catch:{ Exception -> 0x014e }
            if (r0 < r3) goto L_0x00eb
            r9.f()     // Catch:{ Exception -> 0x014e }
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x00eb
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x014e }
        L_0x00eb:
            return
        L_0x00ec:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r9.b     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0144
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r9.b     // Catch:{ Exception -> 0x014e }
            int r0 = r0.getAdSpaceT()     // Catch:{ Exception -> 0x014e }
            if (r0 == r3) goto L_0x0144
            int r0 = r9.k()     // Catch:{ Exception -> 0x014e }
            com.mbridge.msdk.playercommon.PlayerView r4 = r9.s     // Catch:{ Exception -> 0x014e }
            int r4 = r4.getCurPosition()     // Catch:{ Exception -> 0x014e }
            int r4 = r4 / 1000
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r9.b     // Catch:{ Exception -> 0x014e }
            int r5 = r5.getDynamicTempCode()     // Catch:{ Exception -> 0x014e }
            r6 = 5
            r7 = 0
            r8 = 1
            if (r5 != r6) goto L_0x011c
            int r5 = r9.mCurrPlayNum     // Catch:{ Exception -> 0x014e }
            if (r5 <= r8) goto L_0x011c
            if (r0 != 0) goto L_0x0116
            goto L_0x0123
        L_0x0116:
            if (r0 <= 0) goto L_0x0123
            if (r4 >= r0) goto L_0x0123
        L_0x011a:
            r7 = 1
            goto L_0x0123
        L_0x011c:
            if (r0 <= 0) goto L_0x0120
            if (r4 < r0) goto L_0x011a
        L_0x0120:
            if (r0 != 0) goto L_0x0123
            goto L_0x011a
        L_0x0123:
            if (r7 == 0) goto L_0x013a
            int r0 = r9.R     // Catch:{ Exception -> 0x014e }
            if (r0 != r8) goto L_0x013a
            boolean r0 = r9.ai     // Catch:{ Exception -> 0x014e }
            if (r0 != 0) goto L_0x013a
            r9.f()     // Catch:{ Exception -> 0x014e }
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0158
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x014e }
            goto L_0x0158
        L_0x013a:
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0158
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            r0.a(r3, r2)     // Catch:{ Exception -> 0x014e }
            goto L_0x0158
        L_0x0144:
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            if (r0 == 0) goto L_0x0158
            com.mbridge.msdk.video.module.a.a r0 = r9.e     // Catch:{ Exception -> 0x014e }
            r0.a(r3, r2)     // Catch:{ Exception -> 0x014e }
            goto L_0x0158
        L_0x014e:
            r0 = move-exception
            java.lang.String r1 = "MBridgeBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.b():void");
    }

    public void hideAlertView(int i) {
        if (this.M) {
            this.M = false;
            this.at = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.U, false);
            q.a(this.a, this.b, com.mbridge.msdk.videocommon.d.c.a, this.U, 1, i);
            if (i == 0) {
                g();
                if (!this.ak) {
                    return;
                }
                if (this.aq == com.mbridge.msdk.foundation.same.a.p || this.aq == com.mbridge.msdk.foundation.same.a.o) {
                    this.au = true;
                    if (this.e != null) {
                        this.e.a(124, "");
                    }
                    this.ay = true;
                    gonePlayingCloseView();
                    return;
                }
                return;
            }
            this.av = true;
            if (this.ak && this.aq == com.mbridge.msdk.foundation.same.a.p) {
                g();
            } else if (!this.ak || this.aq != com.mbridge.msdk.foundation.same.a.o) {
                if (this.e != null) {
                    this.e.a(2, "");
                }
            } else if (this.e != null) {
                this.e.a(2, b(this.ax));
            }
        }
    }

    public void alertWebViewShowed() {
        this.M = true;
        setShowingAlertViewCover(true);
    }

    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.S;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        if (this.e != null) {
            this.e.a(125, "");
        }
    }

    public void showAlertView() {
        if (!this.ad) {
            if (this.T == null) {
                this.T = new com.mbridge.msdk.widget.dialog.a() {
                    public final void a() {
                    }

                    public final void b() {
                        boolean unused = MBridgeVideoView.this.M = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.M);
                        if (MBridgeVideoView.this.ak && (MBridgeVideoView.this.aq == com.mbridge.msdk.foundation.same.a.p || MBridgeVideoView.this.aq == com.mbridge.msdk.foundation.same.a.o)) {
                            boolean unused2 = MBridgeVideoView.this.au = true;
                            if (MBridgeVideoView.this.e != null) {
                                MBridgeVideoView.this.e.a(124, "");
                            }
                            boolean unused3 = MBridgeVideoView.this.ay = true;
                            MBridgeVideoView.this.gonePlayingCloseView();
                        }
                        MBridgeVideoView.this.g();
                        q.a(MBridgeVideoView.this.a, MBridgeVideoView.this.b, MBridgeVideoView.this.ap, MBridgeVideoView.this.U, 1, 0);
                    }

                    public final void c() {
                        boolean unused = MBridgeVideoView.this.M = false;
                        boolean unused2 = MBridgeVideoView.this.av = true;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.M);
                        q.a(MBridgeVideoView.this.a, MBridgeVideoView.this.b, MBridgeVideoView.this.ap, MBridgeVideoView.this.U, 1, 1);
                        if (!MBridgeVideoView.this.ak || MBridgeVideoView.this.aq != com.mbridge.msdk.foundation.same.a.o) {
                            if (MBridgeVideoView.this.ak && MBridgeVideoView.this.aq == com.mbridge.msdk.foundation.same.a.p) {
                                MBridgeVideoView.this.g();
                            } else if (MBridgeVideoView.this.e != null) {
                                MBridgeVideoView.this.e.a(2, "");
                            }
                        } else if (MBridgeVideoView.this.e != null) {
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.e;
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            aVar.a(2, mBridgeVideoView2.b(mBridgeVideoView2.ax));
                        }
                    }
                };
            }
            if (this.S == null) {
                MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.T);
                this.S = mBAlertDialog;
                AdSession adSession = this.an;
                if (adSession != null) {
                    adSession.addFriendlyObstruction(mBAlertDialog.getWindow().getDecorView(), FriendlyObstructionPurpose.NOT_VISIBLE, (String) null);
                }
            }
            if (this.ak) {
                this.S.makeIVAlertView(this.aq, this.U);
            } else {
                this.S.makeRVAlertView(this.U);
            }
            PlayerView playerView = this.s;
            if (playerView != null && !playerView.isComplete()) {
                this.S.show();
                this.at = true;
                this.M = true;
                setShowingAlertViewCover(true);
                com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.U, false);
                this.ap = com.mbridge.msdk.videocommon.d.c.a;
                q.a(this.a, this.b, this.ap, this.U, 1);
            }
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.I = bVar;
        if (this.f) {
            if (!TextUtils.isEmpty(this.O) && this.b != null) {
                AdSession adSession = this.an;
                if (adSession != null) {
                    adSession.registerAdView(this.s);
                    SoundImageView soundImageView = this.t;
                    if (soundImageView != null) {
                        this.an.addFriendlyObstruction(soundImageView, FriendlyObstructionPurpose.OTHER, (String) null);
                    }
                    this.an.addFriendlyObstruction(this.u, FriendlyObstructionPurpose.OTHER, (String) null);
                    this.an.addFriendlyObstruction(this.v, FriendlyObstructionPurpose.VIDEO_CONTROLS, (String) null);
                }
                if (this.b != null && ak.b(this.b.getVideoResolution())) {
                    String videoResolution = this.b.getVideoResolution();
                    aa.b(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
                    String[] split = videoResolution.split("x");
                    if (split.length == 2) {
                        if (af.c(split[0]) > 0.0d) {
                            this.V = af.c(split[0]);
                        }
                        if (af.c(split[1]) > 0.0d) {
                            this.W = af.c(split[1]);
                        }
                        aa.b(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.V + "  mVideoH:" + this.W);
                    }
                    if (this.V <= 0.0d) {
                        this.V = 1280.0d;
                    }
                    if (this.W <= 0.0d) {
                        this.W = 720.0d;
                    }
                }
                this.s.initBufferIngParam(this.Q);
                this.s.initVFPData(this.O, this.b.getVideoUrlEncode(), this.aJ);
                soundOperate(this.am, -1, (String) null);
            }
        } else if (this.e != null) {
            this.e.a(12, "MBridgeVideoView initSuccess false");
        }
        al = false;
    }

    public void defaultShow() {
        super.defaultShow();
        this.aa = true;
        showVideoLocation(0, 0, af.i(this.a), af.h(this.a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.P == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        float f;
        aa.b(MBridgeBaseView.TAG, "showVideoLocation marginTop:" + i + " marginLeft:" + i2 + " width:" + i3 + "  height:" + i4 + " radius:" + i5 + " borderTop:" + i6 + " borderLeft:" + i7 + " borderWidth:" + i8 + " borderHeight:" + i9);
        if (this.f) {
            this.w.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.w.getVisibility() != 0) {
                this.w.setVisibility(0);
            }
            if (this.u.getVisibility() == 0) {
                j();
            }
            if (!(i3 > 0 && i4 > 0 && af.i(this.a) >= i3 && af.h(this.a) >= i4) || this.aa) {
                h();
                return;
            }
            o = i6;
            p = i7;
            q = i8 + 4;
            r = i9 + 4;
            float f2 = ((float) i3) / ((float) i4);
            try {
                f = (float) (this.V / this.W);
            } catch (Throwable th) {
                aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                f = 0.0f;
            }
            if (i5 > 0) {
                n = i5;
                if (i5 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius((float) af.b(getContext(), (float) i5));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.s.setBackground(gradientDrawable);
                    if (Build.VERSION.SDK_INT >= 21) {
                        setClipToOutline(true);
                        this.s.setClipToOutline(true);
                    }
                }
            }
            if (Math.abs(f2 - f) <= 0.1f || this.aj == 1) {
                h();
                if (this.ai) {
                    setLayoutCenter(i3, i4);
                    if (al) {
                        this.e.a(114, "");
                    } else {
                        this.e.a(116, "");
                    }
                } else {
                    setLayoutParam(i2, i, i3, i4);
                }
            } else {
                h();
                videoOperate(1);
            }
        }
    }

    public void soundOperate(int i, int i2) {
        soundOperate(i, i2, "2");
    }

    public void soundOperate(int i, int i2, String str) {
        SoundImageView soundImageView;
        if (this.f) {
            this.am = i;
            if (i == 1) {
                SoundImageView soundImageView2 = this.t;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.s.closeSound();
                try {
                    MediaEvents mediaEvents = this.ao;
                    if (mediaEvents != null) {
                        mediaEvents.volumeChange(0.0f);
                    }
                } catch (IllegalArgumentException e) {
                    aa.a("OMSDK", e.getMessage());
                }
            } else if (i == 2) {
                SoundImageView soundImageView3 = this.t;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.s.openSound();
                try {
                    MediaEvents mediaEvents2 = this.ao;
                    if (mediaEvents2 != null) {
                        mediaEvents2.volumeChange(1.0f);
                    }
                } catch (IllegalArgumentException e2) {
                    aa.a("OMSDK", e2.getMessage());
                }
            }
            if (this.b != null && this.b.isDynamicView()) {
                SoundImageView soundImageView4 = this.t;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i2 == 1) {
                SoundImageView soundImageView5 = this.t;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i2 == 2 && (soundImageView = this.t) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str != null && str.equals("2") && this.e != null) {
            this.e.a(7, Integer.valueOf(i));
        }
    }

    public void videoOperate(int i) {
        aa.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i);
        if (!this.f) {
            return;
        }
        if (i == 1) {
            if (getVisibility() == 0 && isfront()) {
                aa.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                if (!this.M && !com.mbridge.msdk.foundation.c.b.c) {
                    g();
                }
            }
        } else if (i == 2) {
            if (getVisibility() == 0 && isfront()) {
                aa.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                f();
            }
        } else if (i == 3 && !this.ac) {
            this.s.release();
            this.ac = true;
            m.a().a("2000146", this.b, (Map<String, String>) new HashMap());
        }
    }

    public void closeVideoOperate(int i, int i2) {
        if (i == 1) {
            this.az = true;
            if (getVisibility() == 0) {
                b();
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "1");
                m.a().c(this.b.getCurrentLRid(), "2000152", hashMap);
                m.a().a("2000148", this.b, (Map<String, String>) new HashMap());
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
        if (i2 == 1) {
            gonePlayingCloseView();
        } else if (i2 != 2) {
        } else {
            if ((!this.ay || getVisibility() != 0) && this.f && this.v.getVisibility() != 0) {
                if (!this.i || this.F) {
                    this.v.setVisibility(0);
                }
                this.ae = true;
            }
        }
    }

    public void progressBarOperate(int i) {
        ProgressBar progressBar;
        if (!this.f) {
            return;
        }
        if (i == 1) {
            ProgressBar progressBar2 = this.y;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        } else if (i == 2 && (progressBar = this.y) != null) {
            progressBar.setVisibility(0);
        }
    }

    public void progressOperate(int i, int i2) {
        if (this.f) {
            aa.b(MBridgeBaseView.TAG, "progressOperate progress:" + i);
            int videoLength = this.b != null ? this.b.getVideoLength() : 0;
            if (i > 0 && i <= videoLength && this.s != null) {
                aa.b(MBridgeBaseView.TAG, "progressOperate progress:" + i);
                this.s.seekTo(i * 1000);
            }
            if (i2 == 1) {
                this.u.setVisibility(8);
            } else if (i2 == 2) {
                this.u.setVisibility(0);
            }
            if (this.u.getVisibility() == 0) {
                j();
            }
        }
    }

    public String getCurrentProgress() {
        try {
            int a2 = this.aJ.a();
            int videoLength = this.b != null ? this.b.getVideoLength() : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(a2, videoLength));
            jSONObject.put("time", a2);
            jSONObject.put("duration", videoLength + "");
            return jSONObject.toString();
        } catch (Throwable th) {
            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return JsonUtils.EMPTY_JSON;
        }
    }

    public void setScaleFitXY(int i) {
        this.aj = i;
    }

    public void setVisible(int i) {
        setVisibility(i);
    }

    public void setCover(boolean z2) {
        if (this.f) {
            this.s.setIsCovered(z2);
        }
    }

    public void setMiniEndCardState(boolean z2) {
        this.ad = z2;
    }

    public void setShowingAlertViewCover(boolean z2) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z2 && (mBAcquireRewardPopView = this.aI) != null && this.N && this.M) {
            mBAcquireRewardPopView.onPause();
        }
        this.s.setIsCovered(z2);
    }

    public boolean isH5Canvas() {
        return getLayoutParams().height < af.h(this.a.getApplicationContext());
    }

    public int getBorderViewHeight() {
        return r;
    }

    public int getBorderViewWidth() {
        return q;
    }

    public int getBorderViewLeft() {
        return p;
    }

    public int getBorderViewTop() {
        return o;
    }

    public int getBorderViewRadius() {
        return n;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.b == null || !this.b.isDynamicView()) && this.f && this.aa) {
            h();
        }
    }

    private String a(int i, int i2) {
        if (i2 != 0) {
            double d = (double) (((float) i) / ((float) i2));
            try {
                return af.a(Double.valueOf(d)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i2 + "";
    }

    public int getCloseAlert() {
        return this.R;
    }

    public void setCloseAlert(int i) {
        this.R = i;
    }

    public int getVideoSkipTime() {
        return this.P;
    }

    public void setVideoSkipTime(int i) {
        this.P = i;
    }

    public void setPlayURL(String str) {
        this.O = str;
    }

    public void setBufferTimeout(int i) {
        this.Q = i;
    }

    private boolean e() {
        try {
            this.s = (PlayerView) findViewById(filterFindViewId(this.aA, "mbridge_vfpv"));
            this.u = (TextView) findViewById(filterFindViewId(this.aA, "mbridge_tv_count"));
            View findViewById = findViewById(filterFindViewId(this.aA, "mbridge_rl_playing_close"));
            this.v = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            this.w = (RelativeLayout) findViewById(filterFindViewId(this.aA, "mbridge_top_control"));
            this.x = (ImageView) findViewById(filterFindViewId(this.aA, "mbridge_videoview_bg"));
            this.y = (ProgressBar) findViewById(filterFindViewId(this.aA, "mbridge_video_progress_bar"));
            this.z = (FeedBackButton) findViewById(filterFindViewId(this.aA, "mbridge_native_endcard_feed_btn"));
            ImageView imageView = (ImageView) findViewById(filterFindViewId(this.aA, "mbridge_iv_link"));
            this.A = imageView;
            af.a(1, imageView, this.b, this.a, false, new com.mbridge.msdk.foundation.c.a() {
                public final void a() {
                    MBridgeVideoView.this.f();
                }

                public final void b() {
                    MBridgeVideoView.this.g();
                }

                public final void a(String str) {
                    MBridgeVideoView.this.g();
                }
            });
            this.t = (SoundImageView) findViewById(filterFindViewId(this.aA, "mbridge_sound_switch"));
            this.B = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.aA, "mbridge_reward_segment_progressbar"));
            this.G = (FrameLayout) findViewById(filterFindViewId(this.aA, "mbridge_reward_cta_layout"));
            this.aC = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aA, "mbridge_animation_click_view"));
            this.K = (RelativeLayout) findViewById(filterFindViewId(this.aA, "mbridge_reward_moreoffer_layout"));
            this.aI = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.aA, "mbridge_reward_popview"));
            return isNotNULL(this.s, this.t, this.u, this.v);
        } catch (Throwable th) {
            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i = indexOfChild + 1;
        boolean z2 = false;
        while (i <= childCount - 1) {
            if (viewGroup.getChildAt(i).getVisibility() == 0 && this.ad) {
                return false;
            }
            i++;
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            PlayerView playerView = this.s;
            if (playerView != null) {
                playerView.onPause();
                if (this.b != null && !this.b.isRewardPopViewShowed) {
                    removeCallbacks(this.aM);
                }
                if (!(this.b == null || this.b.getNativeVideoTracking() == null || this.b.isHasReportAdTrackPause())) {
                    this.b.setHasReportAdTrackPause(true);
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, this.U, this.b.getNativeVideoTracking().m(), false, false);
                }
                MediaEvents mediaEvents = this.ao;
                if (mediaEvents != null) {
                    mediaEvents.pause();
                    aa.a("omsdk", "play:  videoEvents.pause()");
                }
            }
        } catch (Throwable th) {
            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        b bVar;
        try {
            if (!this.ab) {
                try {
                    if (this.ao != null) {
                        float duration = (float) this.s.getDuration();
                        float f = 0.0f;
                        if (duration == 0.0f && this.b != null) {
                            duration = (float) this.b.getVideoLength();
                        }
                        MediaEvents mediaEvents = this.ao;
                        if (getMute() == 2) {
                            f = 1.0f;
                        }
                        mediaEvents.start(duration, f);
                        aa.a("omsdk", "play: videoEvents.start()");
                    }
                } catch (IllegalArgumentException e) {
                    aa.a(MBridgeBaseView.TAG, e.getMessage());
                }
                boolean playVideo = this.s.playVideo();
                if (!(this.b == null || this.b.getPlayable_ads_without_video() == 2 || playVideo || (bVar = this.aJ) == null)) {
                    bVar.onPlayError("play video failed");
                }
                this.ab = true;
                return;
            }
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aI;
            if (mBAcquireRewardPopView != null && this.N) {
                mBAcquireRewardPopView.onResume();
            }
            if (!this.N) {
                this.s.onResume();
                if (this.b != null && !this.b.isRewardPopViewShowed) {
                    post(this.aM);
                }
                try {
                    MediaEvents mediaEvents2 = this.ao;
                    if (mediaEvents2 != null) {
                        mediaEvents2.resume();
                        aa.a("omsdk", "play:  videoEvents.resume()");
                    }
                } catch (IllegalArgumentException e2) {
                    aa.a(MBridgeBaseView.TAG, e2.getMessage());
                }
            }
        } catch (Exception e3) {
            aa.b(MBridgeBaseView.TAG, e3.getMessage(), e3);
        }
    }

    public void gonePlayingCloseView() {
        if (this.f && this.v.getVisibility() != 8) {
            this.v.setVisibility(8);
            this.ae = false;
        }
        if (!this.aK && !this.ah && !this.af) {
            this.aK = true;
            int i = this.P;
            if (i >= 0) {
                if (i == 0) {
                    this.ah = true;
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            boolean unused = MBridgeVideoView.this.ah = true;
                        }
                    }, (long) (this.P * 1000));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0179 A[Catch:{ all -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018a A[Catch:{ all -> 0x01a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() {
        /*
            r16 = this;
            r1 = r16
            android.content.Context r0 = r1.a
            int r0 = com.mbridge.msdk.foundation.tools.af.i((android.content.Context) r0)
            float r0 = (float) r0
            android.content.Context r2 = r1.a
            int r2 = com.mbridge.msdk.foundation.tools.af.h((android.content.Context) r2)
            float r2 = (float) r2
            android.content.Context r3 = r16.getContext()
            r4 = 1114112000(0x42680000, float:58.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)
            android.content.Context r4 = r16.getContext()
            r5 = 1120927744(0x42d00000, float:104.0)
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r4, (float) r5)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r1.b
            r6 = 1
            if (r5 == 0) goto L_0x0066
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r1.b
            int r5 = r5.getAdSpaceT()
            r7 = 2
            if (r5 != r7) goto L_0x0066
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r1.b
            com.mbridge.msdk.foundation.entity.CampaignEx$c r5 = r5.getRewardTemplateMode()
            int r5 = r5.c()
            if (r5 != r6) goto L_0x0046
            int r8 = r3 * 2
            float r8 = (float) r8
            float r0 = r0 - r8
            int r8 = r4 * 2
            float r8 = (float) r8
            float r2 = r2 - r8
        L_0x0046:
            if (r5 != r7) goto L_0x0050
            int r8 = r4 * 2
            float r8 = (float) r8
            float r0 = r0 - r8
            int r8 = r3 * 2
            float r8 = (float) r8
            float r2 = r2 - r8
        L_0x0050:
            if (r5 != 0) goto L_0x0066
            int r5 = r1.d
            if (r5 != r6) goto L_0x005e
            int r3 = r3 * 2
            float r3 = (float) r3
            float r0 = r0 - r3
            int r4 = r4 * 2
            float r3 = (float) r4
            goto L_0x0065
        L_0x005e:
            int r4 = r4 * 2
            float r4 = (float) r4
            float r0 = r0 - r4
            int r3 = r3 * 2
            float r3 = (float) r3
        L_0x0065:
            float r2 = r2 - r3
        L_0x0066:
            double r3 = r1.V
            r7 = 0
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b6
            double r9 = r1.W
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b6
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x01b6
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x007f
            goto L_0x01b6
        L_0x007f:
            double r3 = r3 / r9
            float r5 = r0 / r2
            double r7 = (double) r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r9 = "videoWHDivide:"
            r5.<init>(r9)
            r5.append(r3)
            java.lang.String r9 = "  screenWHDivide:"
            r5.append(r9)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r9 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.aa.b(r9, r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r3)
            double r10 = com.mbridge.msdk.foundation.tools.af.a((java.lang.Double) r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r7)
            double r7 = com.mbridge.msdk.foundation.tools.af.a((java.lang.Double) r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r12 = "videoWHDivideFinal:"
            r5.<init>(r12)
            r5.append(r10)
            java.lang.String r12 = "  screenWHDivideFinal:"
            r5.append(r12)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.mbridge.msdk.foundation.tools.aa.b(r9, r5)
            com.mbridge.msdk.playercommon.PlayerView r5 = r1.s
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5
            r12 = 17
            r13 = -1
            int r14 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r14 <= 0) goto L_0x00eb
            double r7 = (double) r0
            double r10 = r1.W
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r10
            double r10 = r1.V
            double r7 = r7 / r10
            r5.width = r13
            int r7 = (int) r7
            r5.height = r7
            r5.gravity = r12
            goto L_0x0101
        L_0x00eb:
            int r14 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r14 >= 0) goto L_0x00fd
            double r7 = (double) r2
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r3
            int r7 = (int) r7
            r5.width = r7
            r5.height = r13
            r5.gravity = r12
            goto L_0x0101
        L_0x00fd:
            r5.width = r13
            r5.height = r13
        L_0x0101:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.b     // Catch:{ all -> 0x01a5 }
            if (r7 == 0) goto L_0x01ad
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.b     // Catch:{ all -> 0x01a5 }
            boolean r7 = r7.isDynamicView()     // Catch:{ all -> 0x01a5 }
            if (r7 == 0) goto L_0x01ad
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.b     // Catch:{ all -> 0x01a5 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r7 = r7.getRewardTemplateMode()     // Catch:{ all -> 0x01a5 }
            int r7 = r7.b()     // Catch:{ all -> 0x01a5 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r1.b     // Catch:{ all -> 0x01a5 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r8.getRewardTemplateMode()     // Catch:{ all -> 0x01a5 }
            int r8 = r8.c()     // Catch:{ all -> 0x01a5 }
            r10 = 102(0x66, float:1.43E-43)
            r11 = 202(0xca, float:2.83E-43)
            if (r7 == r10) goto L_0x012d
            if (r7 != r11) goto L_0x012a
            goto L_0x012d
        L_0x012a:
            r2 = 202(0xca, float:2.83E-43)
            goto L_0x014f
        L_0x012d:
            if (r8 != r6) goto L_0x0141
            r5.width = r13     // Catch:{ all -> 0x01a5 }
            r5.gravity = r12     // Catch:{ all -> 0x01a5 }
            double r2 = r1.W     // Catch:{ all -> 0x01a5 }
            double r14 = r1.V     // Catch:{ all -> 0x01a5 }
            double r11 = (double) r0
            java.lang.Double.isNaN(r11)
            double r14 = r14 / r11
            double r2 = r2 / r14
            int r2 = (int) r2
            r5.height = r2     // Catch:{ all -> 0x01a5 }
            goto L_0x012a
        L_0x0141:
            r5.height = r13     // Catch:{ all -> 0x01a5 }
            r5.gravity = r12     // Catch:{ all -> 0x01a5 }
            double r10 = (double) r2
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r3
            int r2 = (int) r10
            r5.width = r2     // Catch:{ all -> 0x01a5 }
            goto L_0x012a
        L_0x014f:
            if (r7 != r2) goto L_0x0166
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.b     // Catch:{ all -> 0x01a5 }
            java.lang.String r2 = r2.getImageUrl()     // Catch:{ all -> 0x01a5 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x01a5 }
            if (r2 != 0) goto L_0x0166
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.b     // Catch:{ all -> 0x01a5 }
            java.lang.String r2 = r2.getImageUrl()     // Catch:{ all -> 0x01a5 }
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x01a5 }
        L_0x0166:
            r2 = 302(0x12e, float:4.23E-43)
            if (r7 == r2) goto L_0x016e
            r2 = 802(0x322, float:1.124E-42)
            if (r7 != r2) goto L_0x01ad
        L_0x016e:
            double r2 = r1.V     // Catch:{ all -> 0x01a5 }
            double r6 = r1.W     // Catch:{ all -> 0x01a5 }
            double r2 = r2 / r6
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x018a
            r5.width = r13     // Catch:{ all -> 0x01a5 }
            double r2 = r1.W     // Catch:{ all -> 0x01a5 }
            double r6 = (double) r0
            java.lang.Double.isNaN(r6)
            double r2 = r2 * r6
            double r6 = r1.V     // Catch:{ all -> 0x01a5 }
            double r2 = r2 / r6
            int r0 = (int) r2     // Catch:{ all -> 0x01a5 }
            r5.height = r0     // Catch:{ all -> 0x01a5 }
            goto L_0x01ad
        L_0x018a:
            android.content.Context r0 = r16.getContext()     // Catch:{ all -> 0x01a5 }
            r2 = 1130102784(0x435c0000, float:220.0)
            int r0 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r0, (float) r2)     // Catch:{ all -> 0x01a5 }
            double r2 = r1.V     // Catch:{ all -> 0x01a5 }
            double r6 = (double) r0
            java.lang.Double.isNaN(r6)
            double r2 = r2 * r6
            double r6 = r1.W     // Catch:{ all -> 0x01a5 }
            double r2 = r2 / r6
            int r2 = (int) r2     // Catch:{ all -> 0x01a5 }
            r5.width = r2     // Catch:{ all -> 0x01a5 }
            r5.height = r0     // Catch:{ all -> 0x01a5 }
            goto L_0x01ad
        L_0x01a5:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r9, r0)
        L_0x01ad:
            com.mbridge.msdk.playercommon.PlayerView r0 = r1.s
            r0.setLayoutParams(r5)
            r16.setMatchParent()
            goto L_0x01b9
        L_0x01b6:
            r16.i()
        L_0x01b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.h():void");
    }

    private void i() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (!isLandscape() && this.f) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.s.getLayoutParams();
                int i = af.i(this.a);
                layoutParams.width = -1;
                layoutParams.height = (i * 9) / 16;
                layoutParams.gravity = 17;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static final class b extends DefaultVideoPlayerStatusListener {
        private MBridgeVideoView a;
        private int b;
        private int c;
        private int d;
        private boolean e;
        /* access modifiers changed from: private */
        public MediaEvents f;
        private a g = new a();
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private boolean k;
        private String l;
        private CampaignEx m;
        private int n;
        private int o;
        private boolean p = false;

        public final void a(CampaignEx campaignEx) {
            this.m = campaignEx;
        }

        public final void a(boolean z) {
            this.k = z;
        }

        public final void a(String str) {
            this.l = str;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.d;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0093 A[Catch:{ Exception -> 0x00a3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                r2.n = r3
                r2.o = r4
                com.mbridge.msdk.foundation.tools.ac r3 = com.mbridge.msdk.foundation.tools.ac.a()
                java.lang.String r4 = "h_c_r_w_p_c"
                r1 = 0
                boolean r3 = r3.a((java.lang.String) r4, (boolean) r1)
                if (r3 != 0) goto L_0x0015
                goto L_0x00af
            L_0x0015:
                int r3 = r2.n
                r4 = 100
                if (r3 == r4) goto L_0x00af
                int r4 = r2.o
                if (r4 != 0) goto L_0x00af
                boolean r4 = r2.p
                if (r4 != 0) goto L_0x00af
                if (r3 == 0) goto L_0x00af
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.m
                if (r3 != 0) goto L_0x002b
                goto L_0x00af
            L_0x002b:
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x00a3 }
                r4 = 94
                if (r3 == r4) goto L_0x0063
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.m     // Catch:{ Exception -> 0x00a3 }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x00a3 }
                r4 = 287(0x11f, float:4.02E-43)
                if (r3 != r4) goto L_0x003e
                goto L_0x0063
            L_0x003e:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3 }
                r3.<init>()     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.m     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x00a3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.m     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x00a3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.m     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r4 = r4.getBidToken()     // Catch:{ Exception -> 0x00a3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a3 }
                goto L_0x0087
            L_0x0063:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3 }
                r3.<init>()     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.m     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r4 = r4.getRequestId()     // Catch:{ Exception -> 0x00a3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.m     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x00a3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.m     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x00a3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a3 }
            L_0x0087:
                com.mbridge.msdk.videocommon.download.c r4 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x00a3 }
                java.lang.String r1 = r2.l     // Catch:{ Exception -> 0x00a3 }
                com.mbridge.msdk.videocommon.download.a r3 = r4.a(r1, r3)     // Catch:{ Exception -> 0x00a3 }
                if (r3 == 0) goto L_0x00af
                r3.o()     // Catch:{ Exception -> 0x00a3 }
                r3 = 1
                r2.p = r3     // Catch:{ Exception -> 0x00a3 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x00a3 }
                if (r3 == 0) goto L_0x00af
                java.lang.String r3 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.aa.d(r0, r3)     // Catch:{ Exception -> 0x00a3 }
                goto L_0x00af
            L_0x00a3:
                r3 = move-exception
                boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r4 == 0) goto L_0x00af
                java.lang.String r3 = r3.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r0, r3)
            L_0x00af:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.b.a(int, int):void");
        }

        public b(MBridgeVideoView mBridgeVideoView) {
            this.a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.l = mBridgeVideoView.getUnitId();
                this.m = mBridgeVideoView.getCampaign();
            }
        }

        public final void onPlayStarted(int i2) {
            super.onPlayStarted(i2);
            if (!this.e) {
                MBridgeVideoView mBridgeVideoView = this.a;
                if (mBridgeVideoView != null) {
                    boolean unused = mBridgeVideoView.F = true;
                }
                this.a.e.a(10, this.g);
                this.e = true;
            }
            this.d = i2;
            CampaignEx campaignEx = this.m;
            if (campaignEx != null) {
                int videoCompleteTime = campaignEx.getVideoCompleteTime();
                if (videoCompleteTime <= 0) {
                    videoCompleteTime = i2;
                }
                String str = "mbridge_reward_shape_progress";
                if (this.m.isDynamicView()) {
                    MBridgeVideoView mBridgeVideoView2 = this.a;
                    if (!(mBridgeVideoView2 == null || mBridgeVideoView2.u == null)) {
                        if (this.m.getDynamicTempCode() != 5 || this.a.mCurrPlayNum <= 1 || videoCompleteTime > 0) {
                            if (videoCompleteTime > 0) {
                                if (!this.k || this.m.getDynamicTempCode() == 5) {
                                    d();
                                }
                                str = "mbridge_reward_video_time_count_num_bg";
                            }
                            this.a.u.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, "drawable"));
                        } else {
                            this.a.u.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                            d();
                        }
                    }
                } else if (videoCompleteTime > 0) {
                    this.a.u.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 30.0f));
                    int b2 = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 5.0f);
                    layoutParams.addRule(1, t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(b2, 0, 0, 0);
                    this.a.u.setPadding(b2, 0, b2, 0);
                    this.a.u.setLayoutParams(layoutParams);
                } else {
                    this.a.u.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, "drawable"));
                }
            }
            if (this.a.y != null) {
                this.a.y.setMax(i2);
            }
            CampaignEx campaignEx2 = this.m;
            if (campaignEx2 != null && campaignEx2.getAdSpaceT() == 2) {
                this.a.w.setVisibility(0);
            }
            if (this.a.u.getVisibility() == 0) {
                this.a.j();
            }
            boolean unused2 = MBridgeVideoView.al = false;
            if (this.a.J == 0) {
                this.a.setCTALayoutVisibleOrGone();
            }
            this.a.showMoreOfferInPlayTemplate();
            this.a.showBaitClickView();
            MBridgeVideoView.s(this.a);
        }

        private void d() {
            MBridgeVideoView mBridgeVideoView = this.a;
            if (mBridgeVideoView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.u.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -2;
                    layoutParams.height = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 25.0f);
                    this.a.u.setLayoutParams(layoutParams);
                }
                int b2 = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 5.0f);
                this.a.u.setPadding(b2, 0, b2, 0);
            }
        }

        public final void onPlayCompleted() {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            boolean unused = this.a.ax = true;
            if (this.m != null) {
                this.a.u.setText(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                this.m.setVideoPlayProgress(100);
                if (this.m.getAdSpaceT() == 2) {
                    this.a.v.setVisibility(4);
                    if (this.a.z != null) {
                        this.a.z.setClickable(false);
                    }
                    if (this.a.t != null) {
                        this.a.t.setClickable(false);
                    }
                }
            } else {
                this.a.u.setText("0");
            }
            MediaEvents mediaEvents = this.f;
            if (mediaEvents != null) {
                mediaEvents.complete();
                aa.a("omsdk", "play:  videoEvents.complete()");
            }
            this.a.s.setClickable(false);
            String g2 = this.a.b(true);
            CampaignEx campaignEx = this.m;
            if (campaignEx == null || campaignEx.getDynamicTempCode() != 5 || (mBridgeVideoView = this.a) == null || mBridgeVideoView.D == null || this.a.mCampaignSize <= this.a.mCurrPlayNum) {
                this.a.e.a(121, "");
                this.a.e.a(11, g2);
                int i2 = this.c;
                this.b = i2;
                this.a.mCurrentPlayProgressTime = i2;
                boolean unused2 = MBridgeVideoView.al = true;
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("position", Integer.valueOf(this.a.mCurrPlayNum));
            if (this.a.mMuteSwitch != 0) {
                hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(this.a.mMuteSwitch));
            }
            this.a.D.a(hashMap);
        }

        public final void onPlayError(String str) {
            aa.d("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.e.a(12, str);
            }
        }

        /* JADX WARNING: type inference failed for: r0v77, types: [java.lang.CharSequence] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r12, int r13) {
            /*
                r11 = this;
                super.onPlayProgress(r12, r13)
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                boolean r0 = r0.f
                java.lang.String r1 = "DefaultVideoPlayerStatusListener"
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == 0) goto L_0x01f6
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                r4 = 0
                if (r0 == 0) goto L_0x0039
                int r0 = r0.getVideoCompleteTime()
                if (r0 > 0) goto L_0x001a
                r0 = r13
            L_0x001a:
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.b.a()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r11.m
                java.lang.String r7 = r7.getCampaignUnitId()
                r6.append(r7)
                java.lang.String r7 = "_1"
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r5.a((java.lang.String) r6, (int) r12)
                goto L_0x003a
            L_0x0039:
                r0 = 0
            L_0x003a:
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r11.m
                boolean r5 = r5.isDynamicView()
                java.lang.String r6 = "0"
                java.lang.String r7 = "mbridge_reward_video_view_reward_time_complete"
                java.lang.String r8 = "mbridge_reward_video_view_reward_time_left"
                java.lang.String r9 = "string"
                if (r5 == 0) goto L_0x0129
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r11.m
                int r5 = r5.getDynamicTempCode()
                r10 = 5
                if (r5 != r10) goto L_0x0129
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r11.a     // Catch:{ Exception -> 0x011f }
                int r4 = r4.E     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a     // Catch:{ Exception -> 0x011f }
                if (r5 != 0) goto L_0x0060
                goto L_0x01f6
            L_0x0060:
                android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x011f }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.foundation.controller.b r10 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x011f }
                android.content.Context r10 = r10.g()     // Catch:{ Exception -> 0x011f }
                int r7 = com.mbridge.msdk.foundation.tools.t.a(r10, r7, r9)     // Catch:{ Exception -> 0x011f }
                java.lang.CharSequence r5 = r5.getText(r7)     // Catch:{ Exception -> 0x011f }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.video.module.MBridgeVideoView r7 = r11.a     // Catch:{ Exception -> 0x011f }
                android.content.Context r7 = r7.getContext()     // Catch:{ Exception -> 0x011f }
                android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.foundation.controller.b r10 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x011f }
                android.content.Context r10 = r10.g()     // Catch:{ Exception -> 0x011f }
                int r8 = com.mbridge.msdk.foundation.tools.t.a(r10, r8, r9)     // Catch:{ Exception -> 0x011f }
                java.lang.CharSequence r7 = r7.getText(r8)     // Catch:{ Exception -> 0x011f }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x011f }
                if (r0 < 0) goto L_0x00ac
                int r0 = r0 - r12
                if (r0 > 0) goto L_0x009c
                goto L_0x00d0
            L_0x009c:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
                r4.<init>()     // Catch:{ Exception -> 0x011f }
                r4.append(r0)     // Catch:{ Exception -> 0x011f }
                r4.append(r7)     // Catch:{ Exception -> 0x011f }
                java.lang.String r5 = r4.toString()     // Catch:{ Exception -> 0x011f }
                goto L_0x00d0
            L_0x00ac:
                int r4 = r4 - r12
                if (r4 > 0) goto L_0x00b2
                if (r0 > 0) goto L_0x00d1
                goto L_0x00d2
            L_0x00b2:
                if (r0 > 0) goto L_0x00c0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
                r0.<init>()     // Catch:{ Exception -> 0x011f }
                r0.append(r4)     // Catch:{ Exception -> 0x011f }
                r0.append(r2)     // Catch:{ Exception -> 0x011f }
                goto L_0x00cb
            L_0x00c0:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
                r0.<init>()     // Catch:{ Exception -> 0x011f }
                r0.append(r4)     // Catch:{ Exception -> 0x011f }
                r0.append(r7)     // Catch:{ Exception -> 0x011f }
            L_0x00cb:
                java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x011f }
                r0 = r4
            L_0x00d0:
                r4 = r0
            L_0x00d1:
                r6 = r5
            L_0x00d2:
                com.mbridge.msdk.video.module.MBridgeVideoView$a r0 = r11.g     // Catch:{ Exception -> 0x011f }
                r0.a = r12     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                android.widget.TextView r0 = r0.u     // Catch:{ Exception -> 0x011f }
                r0.setText(r6)     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                android.widget.ProgressBar r0 = r0.y     // Catch:{ Exception -> 0x011f }
                if (r0 == 0) goto L_0x00fc
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                android.widget.ProgressBar r0 = r0.y     // Catch:{ Exception -> 0x011f }
                int r0 = r0.getVisibility()     // Catch:{ Exception -> 0x011f }
                if (r0 != 0) goto L_0x00fc
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                android.widget.ProgressBar r0 = r0.y     // Catch:{ Exception -> 0x011f }
                r0.setProgress(r12)     // Catch:{ Exception -> 0x011f }
            L_0x00fc:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                int r0 = r0.aG     // Catch:{ Exception -> 0x011f }
                if (r4 >= r0) goto L_0x01f6
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r0 = r0.aI     // Catch:{ Exception -> 0x011f }
                if (r0 == 0) goto L_0x01f6
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                boolean r0 = r0.N     // Catch:{ Exception -> 0x011f }
                if (r0 == 0) goto L_0x01f6
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ Exception -> 0x011f }
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r0 = r0.aI     // Catch:{ Exception -> 0x011f }
                r0.onTimeLessThanReduce(r4)     // Catch:{ Exception -> 0x011f }
                goto L_0x01f6
            L_0x011f:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
                goto L_0x01f6
            L_0x0129:
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a
                if (r5 != 0) goto L_0x012f
                goto L_0x01f2
            L_0x012f:
                boolean r10 = r11.k
                if (r10 == 0) goto L_0x0145
                java.lang.Object[] r0 = new java.lang.Object[r3]
                int r5 = r13 - r12
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0[r4] = r5
                java.lang.String r4 = "%s"
                java.lang.String r0 = java.lang.String.format(r4, r0)
                goto L_0x01cc
            L_0x0145:
                if (r0 <= r13) goto L_0x0148
                r0 = r13
            L_0x0148:
                if (r0 > 0) goto L_0x014d
                int r10 = r13 - r12
                goto L_0x014f
            L_0x014d:
                int r10 = r0 - r12
            L_0x014f:
                if (r10 > 0) goto L_0x0171
                if (r0 > 0) goto L_0x0154
                goto L_0x016f
            L_0x0154:
                android.content.Context r0 = r5.getContext()
                android.content.res.Resources r0 = r0.getResources()
                com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()
                android.content.Context r5 = r5.g()
                int r5 = com.mbridge.msdk.foundation.tools.t.a(r5, r7, r9)
                java.lang.CharSequence r0 = r0.getText(r5)
                r6 = r0
                java.lang.String r6 = (java.lang.String) r6
            L_0x016f:
                r0 = r6
                goto L_0x01ab
            L_0x0171:
                if (r0 > 0) goto L_0x017f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r10)
                r0.append(r2)
                goto L_0x01a6
            L_0x017f:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r10)
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r11.a
                android.content.Context r4 = r4.getContext()
                android.content.res.Resources r4 = r4.getResources()
                com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()
                android.content.Context r5 = r5.g()
                int r5 = com.mbridge.msdk.foundation.tools.t.a(r5, r8, r9)
                java.lang.CharSequence r4 = r4.getText(r5)
                java.lang.String r4 = (java.lang.String) r4
                r0.append(r4)
            L_0x01a6:
                java.lang.String r0 = r0.toString()
                r4 = r10
            L_0x01ab:
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a
                int r5 = r5.aG
                if (r4 >= r5) goto L_0x01cc
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r5 = r5.aI
                if (r5 == 0) goto L_0x01cc
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a
                boolean r5 = r5.N
                if (r5 == 0) goto L_0x01cc
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r5 = r5.aI
                r5.onTimeLessThanReduce(r4)
            L_0x01cc:
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r11.a
                android.widget.TextView r4 = r4.u
                r4.setText(r0)
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                android.widget.ProgressBar r0 = r0.y
                if (r0 == 0) goto L_0x01f2
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                android.widget.ProgressBar r0 = r0.y
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x01f2
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                android.widget.ProgressBar r0 = r0.y
                r0.setProgress(r12)
            L_0x01f2:
                com.mbridge.msdk.video.module.MBridgeVideoView$a r0 = r11.g
                r0.a = r12
            L_0x01f6:
                r11.c = r13
                com.mbridge.msdk.video.module.MBridgeVideoView$a r0 = r11.g
                r0.b = r13
                com.mbridge.msdk.video.module.MBridgeVideoView$a r0 = r11.g
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r11.a
                boolean r4 = r4.ay
                r0.c = r4
                r11.b = r12
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                android.widget.ImageView r0 = r0.A
                if (r0 == 0) goto L_0x0227
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                android.widget.ImageView r0 = r0.A
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r2)
                int r2 = r11.b
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.setTag(r2)
            L_0x0227:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                r0.mCurrentPlayProgressTime = r12
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                com.mbridge.msdk.video.module.a.a r0 = r0.e
                r2 = 15
                com.mbridge.msdk.video.module.MBridgeVideoView$a r4 = r11.g
                r0.a(r2, r4)
                com.iab.omid.library.mmadbridge.adsession.media.MediaEvents r0 = r11.f
                r2 = 100
                if (r0 == 0) goto L_0x0284
                int r4 = r12 * 100
                int r4 = r4 / r13
                int r5 = r12 + 1
                int r5 = r5 * 100
                int r5 = r5 / r13
                r6 = 25
                java.lang.String r7 = "omsdk"
                if (r4 > r6) goto L_0x025b
                if (r6 >= r5) goto L_0x025b
                boolean r6 = r11.h
                if (r6 != 0) goto L_0x025b
                r11.h = r3
                r0.firstQuartile()
                java.lang.String r0 = "play:  videoEvents.firstQuartile()"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r7, (java.lang.String) r0)
                goto L_0x0284
            L_0x025b:
                r6 = 50
                if (r4 > r6) goto L_0x0270
                if (r6 >= r5) goto L_0x0270
                boolean r6 = r11.i
                if (r6 != 0) goto L_0x0270
                r11.i = r3
                r0.midpoint()
                java.lang.String r0 = "play:  videoEvents.midpoint()"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r7, (java.lang.String) r0)
                goto L_0x0284
            L_0x0270:
                r6 = 75
                if (r4 > r6) goto L_0x0284
                if (r6 >= r5) goto L_0x0284
                boolean r4 = r11.j
                if (r4 != 0) goto L_0x0284
                r11.j = r3
                r0.thirdQuartile()
                java.lang.String r0 = "play:  videoEvents.thirdQuartile()"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r7, (java.lang.String) r0)
            L_0x0284:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                boolean r0 = r0.ak
                if (r0 == 0) goto L_0x02a3
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                boolean r0 = r0.at
                if (r0 != 0) goto L_0x02a3
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                int r0 = r0.aq
                int r4 = com.mbridge.msdk.foundation.same.a.p
                if (r0 != r4) goto L_0x02a3
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a
                r0.b()
            L_0x02a3:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ all -> 0x02ec }
                if (r0 == 0) goto L_0x02c3
                com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar r0 = r0.B     // Catch:{ all -> 0x02ec }
                if (r0 == 0) goto L_0x02c3
                int r0 = r12 * 100
                int r0 = r0 / r13
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r11.a     // Catch:{ all -> 0x02ec }
                com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar r4 = r4.B     // Catch:{ all -> 0x02ec }
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r11.a     // Catch:{ all -> 0x02ec }
                int r5 = r5.mCurrPlayNum     // Catch:{ all -> 0x02ec }
                int r5 = r5 - r3
                r4.setProgress(r0, r5)     // Catch:{ all -> 0x02ec }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r11.m     // Catch:{ all -> 0x02ec }
                r4.setVideoPlayProgress(r0)     // Catch:{ all -> 0x02ec }
            L_0x02c3:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ all -> 0x02ec }
                if (r0 == 0) goto L_0x02f4
                int r0 = r0.J     // Catch:{ all -> 0x02ec }
                r4 = -1
                if (r0 == r4) goto L_0x02f4
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ all -> 0x02ec }
                int r0 = r0.J     // Catch:{ all -> 0x02ec }
                if (r12 != r0) goto L_0x02f4
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ all -> 0x02ec }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ all -> 0x02ec }
                if (r0 == 0) goto L_0x02f4
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ all -> 0x02ec }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ all -> 0x02ec }
                boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x02ec }
                if (r0 == 0) goto L_0x02f4
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r11.a     // Catch:{ all -> 0x02ec }
                r0.setCTALayoutVisibleOrGone()     // Catch:{ all -> 0x02ec }
                goto L_0x02f4
            L_0x02ec:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
            L_0x02f4:
                int r0 = r11.n
                if (r0 == r2) goto L_0x0396
                boolean r4 = r11.p
                if (r4 != 0) goto L_0x0396
                if (r0 != 0) goto L_0x0300
                goto L_0x0396
            L_0x0300:
                int r4 = r11.o
                if (r4 <= r0) goto L_0x0308
                int r0 = r0 / 2
                r11.o = r0
            L_0x0308:
                int r0 = r11.o
                if (r0 < 0) goto L_0x0396
                int r13 = r13 * r0
                int r13 = r13 / r2
                if (r12 < r13) goto L_0x0396
                com.mbridge.msdk.foundation.entity.CampaignEx r12 = r11.m
                int r12 = r12.getAdType()
                r0 = 94
                if (r12 == r0) goto L_0x034b
                com.mbridge.msdk.foundation.entity.CampaignEx r12 = r11.m
                int r12 = r12.getAdType()
                r0 = 287(0x11f, float:4.02E-43)
                if (r12 != r0) goto L_0x0326
                goto L_0x034b
            L_0x0326:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                java.lang.String r0 = r0.getId()
                r12.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                java.lang.String r0 = r0.getVideoUrlEncode()
                r12.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                java.lang.String r0 = r0.getBidToken()
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                goto L_0x036f
            L_0x034b:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                java.lang.String r0 = r0.getRequestId()
                r12.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                java.lang.String r0 = r0.getId()
                r12.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.m
                java.lang.String r0 = r0.getVideoUrlEncode()
                r12.append(r0)
                java.lang.String r12 = r12.toString()
            L_0x036f:
                com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()
                java.lang.String r2 = r11.l
                com.mbridge.msdk.videocommon.download.a r12 = r0.a(r2, r12)
                if (r12 == 0) goto L_0x0396
                r12.o()
                r11.p = r3
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r0 = "CDRate is : "
                r12.<init>(r0)
                r12.append(r13)
                java.lang.String r13 = " and start download !"
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                com.mbridge.msdk.foundation.tools.aa.d(r1, r12)
            L_0x0396:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.b.onPlayProgress(int, int):void");
        }

        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                MediaEvents mediaEvents = this.f;
                if (mediaEvents != null) {
                    mediaEvents.bufferStart();
                }
                this.a.e.a(13, "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                MediaEvents mediaEvents = this.f;
                if (mediaEvents != null) {
                    mediaEvents.bufferFinish();
                    aa.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.a.e.a(14, "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        public final void c() {
            this.a = null;
            boolean unused = MBridgeVideoView.al = false;
        }
    }

    public static class a {
        public int a;
        public int b;
        public boolean c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.a + ", allDuration=" + this.b + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public void onBackPress() {
        if (!this.ad && !this.M && !this.au) {
            if (this.ae) {
                b();
                return;
            }
            boolean z2 = this.af;
            if (z2 && this.ag) {
                b();
            } else if (!z2 && this.ah) {
                b();
            }
        }
    }

    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.af = true;
            this.ah = false;
        } else if (i == 1) {
            this.ag = true;
        }
    }

    public void showIVRewardAlertView(String str) {
        this.e.a(8, "");
    }

    public void notifyVideoClose() {
        this.e.a(2, "");
    }

    public void setAdSession(AdSession adSession) {
        this.an = adSession;
    }

    public void setVideoEvents(MediaEvents mediaEvents) {
        this.ao = mediaEvents;
        b bVar = this.aJ;
        if (bVar != null) {
            MediaEvents unused = bVar.f = mediaEvents;
        }
    }

    public int getMute() {
        return this.am;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.aq = i;
        this.ar = i2;
        this.as = i3;
    }

    public void setDialogRole(int i) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        this.aw = z2;
        aa.d(MBridgeBaseView.TAG, i + " " + this.aw);
    }

    /* access modifiers changed from: private */
    public String b(boolean z2) {
        if (!this.ak) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.at) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.s);
            }
            if (this.av) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.u);
            }
            if (this.au) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.t);
            }
            jSONObject.put("complete_info", z2 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            aa.d(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        RelativeLayout relativeLayout;
        try {
            StringBuilder sb = new StringBuilder("NOTCH VideoView ");
            boolean z2 = false;
            sb.append(String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            aa.d(MBridgeBaseView.TAG, sb.toString());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i5 = layoutParams.leftMargin;
            int i6 = layoutParams.rightMargin;
            int i7 = layoutParams.topMargin;
            int i8 = layoutParams.bottomMargin;
            if (Math.max(Math.max(i5, i6), Math.max(i7, i8)) > Math.max(Math.max(i, i2), Math.max(i3, i4))) {
                z2 = true;
            }
            if (!z2 && (relativeLayout = this.w) != null) {
                final int i9 = i;
                final int i10 = i3;
                final int i11 = i2;
                final int i12 = i4;
                relativeLayout.postDelayed(new Runnable() {
                    public final void run() {
                        if (MBridgeVideoView.this.w != null) {
                            MBridgeVideoView.this.w.setVisibility(0);
                            if (MBridgeVideoView.this.b != null && MBridgeVideoView.this.b.getAdSpaceT() != 2) {
                                MBridgeVideoView.this.w.setPadding(i9, i10, i11, i12);
                                MBridgeVideoView.this.w.startAnimation(MBridgeVideoView.this.aB);
                            }
                        }
                    }
                }, 200);
            }
            if (this.u.getVisibility() == 0) {
                j();
            }
        } catch (Exception e) {
            aa.d(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.b != null) {
            this.b.setCampaignUnitId(this.U);
            com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
            a2.a(this.U + "_1", this.b);
        }
        if (!com.mbridge.msdk.foundation.c.b.a().b()) {
            FeedBackButton feedBackButton = this.z;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        } else if (this.z != null) {
            com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
            a3.a(this.U + "_1", this.z);
        }
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(str, (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
            public final void onSuccessLoad(final Bitmap bitmap, String str) {
                if (bitmap != null) {
                    try {
                        if (!bitmap.isRecycled() && MBridgeVideoView.this.x != null) {
                            com.mbridge.msdk.foundation.same.f.b.d().execute(new Runnable() {
                                public final void run() {
                                    try {
                                        final Bitmap a2 = l.a(bitmap, 10);
                                        MBridgeVideoView.this.x.post(new Runnable() {
                                            public final void run() {
                                                MBridgeVideoView.this.x.setVisibility(0);
                                                MBridgeVideoView.this.x.setImageBitmap(a2);
                                            }
                                        });
                                    } catch (Exception e) {
                                        aa.d(MBridgeBaseView.TAG, e.getMessage());
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        aa.d(MBridgeBaseView.TAG, th.getMessage());
                    }
                }
            }

            public final void onFailedLoad(String str, String str2) {
                aa.d(MBridgeBaseView.TAG, str);
            }
        });
    }

    public void setCTALayoutVisibleOrGone() {
        FrameLayout frameLayout;
        if (this.b != null && this.b.isDynamicView() && (frameLayout = this.G) != null && this.J >= -1) {
            MBridgeClickCTAView mBridgeClickCTAView = this.H;
            if (mBridgeClickCTAView == null && frameLayout != null) {
                if (mBridgeClickCTAView == null) {
                    MBridgeClickCTAView mBridgeClickCTAView2 = new MBridgeClickCTAView(getContext());
                    this.H = mBridgeClickCTAView2;
                    mBridgeClickCTAView2.setCampaign(this.b);
                    this.H.setUnitId(this.U);
                    com.mbridge.msdk.video.module.a.a aVar = this.C;
                    if (aVar != null) {
                        this.H.setNotifyListener(new com.mbridge.msdk.video.module.a.a.i(aVar));
                    }
                    this.H.preLoadData(this.I);
                }
                this.G.addView(this.H);
            }
            int i = this.J;
            if (i >= 0) {
                this.G.setVisibility(0);
            } else if (i != -1) {
            } else {
                if (this.G.getVisibility() != 0) {
                    this.G.setVisibility(0);
                    postDelayed(this.aL, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    return;
                }
                this.G.setVisibility(8);
                getHandler().removeCallbacks(this.aL);
            }
        }
    }

    public void showMoreOfferInPlayTemplate() {
        if (this.b != null && this.K != null && this.b.isDynamicView() && this.b.getRewardTemplateMode() != null) {
            String e = this.b.getRewardTemplateMode().e();
            if (!TextUtils.isEmpty(e)) {
                try {
                    String a2 = al.a(e, "mof");
                    if (!TextUtils.isEmpty(a2) && Integer.parseInt(a2) == 1) {
                        com.mbridge.msdk.video.dynview.moffer.a.a().a(this.b, this, new com.mbridge.msdk.video.module.a.a.i(this.C), 1);
                    }
                } catch (Exception e2) {
                    aa.d(MBridgeBaseView.TAG, e2.getMessage());
                }
            }
        }
    }

    public void showBaitClickView() {
        int parseInt;
        MBridgeBaitClickView mBridgeBaitClickView;
        if (this.b != null && this.b.isDynamicView() && this.b.getRewardTemplateMode() != null) {
            String e = this.b.getRewardTemplateMode().e();
            if (!TextUtils.isEmpty(e)) {
                try {
                    String a2 = al.a(e, "bait_click");
                    if (!TextUtils.isEmpty(a2) && (parseInt = Integer.parseInt(a2)) != 0 && (mBridgeBaitClickView = this.aC) != null) {
                        mBridgeBaitClickView.setVisibility(0);
                        this.aC.init(parseInt);
                        this.aC.startAnimation();
                        this.aC.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                if (MBridgeVideoView.this.e != null) {
                                    MBridgeVideoView.a(MBridgeVideoView.this, "bait_click_clicked");
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    aa.d(MBridgeBaseView.TAG, e2.getMessage());
                }
            }
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.aI;
        if (mBAcquireRewardPopView != null && (acquireRewardPopViewParameters = this.aH) != null) {
            try {
                mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
                this.aI.setVisibility(0);
                setCover(true);
                f();
                this.N = true;
                if (this.b != null) {
                    this.b.isRewardPopViewShowed = true;
                }
            } catch (Exception e) {
                aa.d(MBridgeBaseView.TAG, e.getMessage());
            }
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aI;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th) {
            aa.d(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aI;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th) {
            aa.d(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aI;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th) {
            aa.d(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public int k() {
        int i = 0;
        try {
            int l = l();
            if (this.b == null) {
                return l;
            }
            i = this.b.getVideoCompleteTime();
            if (this.b.getDynamicTempCode() != 5 && i > l) {
                i = l;
            }
            if (i <= 0) {
                return l;
            }
            return i;
        } catch (Throwable th) {
            aa.d(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    private int l() {
        int i = 0;
        try {
            b bVar = this.aJ;
            if (bVar != null) {
                i = bVar.b();
            }
            if (i == 0) {
                return this.b.getVideoLength();
            }
            return i;
        } catch (Throwable th) {
            aa.d(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aL != null) {
                getHandler().removeCallbacks(this.aL);
            }
            if (this.aD != 0) {
                removeCallbacks(this.aM);
            }
        } catch (Throwable th) {
            aa.d(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.s;
            if (playerView != null && !this.ac) {
                playerView.release();
                m.a().a("2000146", this.b, (Map<String, String>) new HashMap());
            }
            b bVar = this.aJ;
            if (bVar != null) {
                bVar.c();
            }
            if (this.C != null) {
                this.C = null;
            }
        } catch (Exception e) {
            aa.d(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[SYNTHETIC, Splitter:B:24:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeVideoView r9, java.lang.String r10) {
        /*
            com.mbridge.msdk.video.module.a.a r0 = r9.C
            if (r0 == 0) goto L_0x0096
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r9.b
            if (r0 == 0) goto L_0x004f
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r9.b     // Catch:{ Exception -> 0x004b }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x004b }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
            r2.<init>()     // Catch:{ Exception -> 0x004b }
            int r0 = r0.b()     // Catch:{ Exception -> 0x004b }
            r2.append(r0)     // Catch:{ Exception -> 0x004b }
            r2.append(r1)     // Catch:{ Exception -> 0x004b }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x004b }
        L_0x0025:
            r7 = r1
            android.content.Context r0 = r9.a     // Catch:{ Exception -> 0x004b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r9.b     // Catch:{ Exception -> 0x004b }
            java.lang.String r2 = r1.getCampaignUnitId()     // Catch:{ Exception -> 0x004b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r9.b     // Catch:{ Exception -> 0x004b }
            boolean r3 = r1.isBidCampaign()     // Catch:{ Exception -> 0x004b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r9.b     // Catch:{ Exception -> 0x004b }
            java.lang.String r4 = r1.getRequestId()     // Catch:{ Exception -> 0x004b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r9.b     // Catch:{ Exception -> 0x004b }
            java.lang.String r5 = r1.getRequestIdNotice()     // Catch:{ Exception -> 0x004b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r9.b     // Catch:{ Exception -> 0x004b }
            java.lang.String r6 = r1.getId()     // Catch:{ Exception -> 0x004b }
            r1 = r10
            com.mbridge.msdk.foundation.same.report.q.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r10 = move-exception
            r10.printStackTrace()
        L_0x004f:
            r10 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0062 }
            r0.<init>()     // Catch:{ JSONException -> 0x0062 }
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.h     // Catch:{ JSONException -> 0x0060 }
            r1 = 0
            org.json.JSONObject r1 = r9.a(r1)     // Catch:{ JSONException -> 0x0060 }
            r0.put(r10, r1)     // Catch:{ JSONException -> 0x0060 }
            goto L_0x0069
        L_0x0060:
            r10 = move-exception
            goto L_0x0066
        L_0x0062:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L_0x0066:
            r10.printStackTrace()
        L_0x0069:
            com.mbridge.msdk.video.module.a.a r10 = r9.C
            r1 = 105(0x69, float:1.47E-43)
            r10.a(r1, r0)
            com.mbridge.msdk.foundation.controller.b r10 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r10 = r10.g()
            if (r10 == 0) goto L_0x0096
            com.mbridge.msdk.foundation.controller.b r10 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x008c }
            android.content.Context r10 = r10.g()     // Catch:{ Exception -> 0x008c }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x008c }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r9.b     // Catch:{ Exception -> 0x008c }
            com.mbridge.msdk.video.module.b.b.d(r10, r9)     // Catch:{ Exception -> 0x008c }
            goto L_0x0096
        L_0x008c:
            r9 = move-exception
            java.lang.String r10 = "MBridgeBaseView"
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r10, r9)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.a(com.mbridge.msdk.video.module.MBridgeVideoView, java.lang.String):void");
    }

    static /* synthetic */ void s(MBridgeVideoView mBridgeVideoView) {
        String str;
        if (mBridgeVideoView.b != null && mBridgeVideoView.b.isDynamicView() && !mBridgeVideoView.L) {
            if (!TextUtils.isEmpty(mBridgeVideoView.b.getMof_template_url())) {
                str = mBridgeVideoView.b.getMof_template_url();
            } else if (mBridgeVideoView.b.getRewardTemplateMode() != null) {
                str = mBridgeVideoView.b.getRewardTemplateMode().e();
            } else {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String a2 = al.a(str, "guideShow");
                    String a3 = al.a(str, "guideDelay");
                    String a4 = al.a(str, "guideTime");
                    String a5 = al.a(str, "guideRewardTime");
                    if (!TextUtils.isEmpty(a2)) {
                        mBridgeVideoView.aD = Integer.parseInt(a2);
                    }
                    if (!TextUtils.isEmpty(a3)) {
                        int parseInt = Integer.parseInt(a3);
                        mBridgeVideoView.aE = parseInt;
                        if (parseInt > 10 || parseInt < 3) {
                            mBridgeVideoView.aE = 5;
                        }
                    }
                    if (!TextUtils.isEmpty(a4)) {
                        int parseInt2 = Integer.parseInt(a4);
                        mBridgeVideoView.aF = parseInt2;
                        if (parseInt2 > 10 || parseInt2 < 3) {
                            mBridgeVideoView.aF = 5;
                        }
                    }
                    if (!TextUtils.isEmpty(a5)) {
                        int parseInt3 = Integer.parseInt(a5);
                        mBridgeVideoView.aG = parseInt3;
                        if (parseInt3 > 10 || parseInt3 < 5) {
                            mBridgeVideoView.aG = 5;
                        }
                    }
                    int i = mBridgeVideoView.aD;
                    if (i <= 0) {
                        return;
                    }
                    if (i <= 2) {
                        int k = mBridgeVideoView.k();
                        if (k == 0 || k > mBridgeVideoView.aE) {
                            int i2 = k - mBridgeVideoView.aE;
                            if (i2 >= 0 && mBridgeVideoView.aG > i2) {
                                mBridgeVideoView.aG = i2;
                            }
                            int l = mBridgeVideoView.l();
                            if (mBridgeVideoView.aG >= l) {
                                mBridgeVideoView.aG = l - mBridgeVideoView.aE;
                            }
                            if (mBridgeVideoView.aE < l) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(mBridgeVideoView.b.getAppName());
                                String str2 = "US";
                                e g = f.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
                                if (g != null) {
                                    str2 = g.aH();
                                }
                                mBridgeVideoView.aH = new AcquireRewardPopViewParameters.Builder("", mBridgeVideoView.U, mBridgeVideoView.aD, str2).setAutoDismissTime(mBridgeVideoView.aF).setReduceTime(mBridgeVideoView.aG).setBehaviourListener(new AcquireRewardPopViewBehaviourListener() {
                                    public final void onReceivedSuccess(int i) {
                                        boolean unused = MBridgeVideoView.this.N = false;
                                        MBridgeVideoView.this.setCover(false);
                                        int I = MBridgeVideoView.this.k() - i;
                                        MBridgeVideoView.this.b.setVideoCompleteTime(I);
                                        MBridgeVideoView.this.g();
                                        if (MBridgeVideoView.this.e != null) {
                                            MBridgeVideoView.this.e.a(130, Integer.valueOf(I));
                                        }
                                        q.a(MBridgeVideoView.this.b, MBridgeVideoView.this.U, MBridgeVideoView.this.aD, 1, "");
                                    }

                                    public final void onReceivedFail(String str) {
                                        boolean unused = MBridgeVideoView.this.N = false;
                                        MBridgeVideoView.this.setCover(false);
                                        MBridgeVideoView.this.g();
                                        q.a(MBridgeVideoView.this.b, MBridgeVideoView.this.U, MBridgeVideoView.this.aD, 2, str);
                                    }

                                    public final void onOutOfContentClicked(float f, float f2) {
                                        if (MBridgeVideoView.this.C != null) {
                                            MBridgeVideoView.this.C.a(105, "");
                                        }
                                    }
                                }).setRightAnswerList(arrayList).build();
                                mBridgeVideoView.postDelayed(mBridgeVideoView.aM, 1000);
                            }
                        }
                    }
                } catch (Throwable th) {
                    aa.d(MBridgeBaseView.TAG, th.getMessage());
                }
            }
        }
    }
}
