package com.mbridge.msdk.reward.player;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";
    private boolean A;
    /* access modifiers changed from: private */
    public int B = 1;
    /* access modifiers changed from: private */
    public int C = 0;
    /* access modifiers changed from: private */
    public int D = 0;
    /* access modifiers changed from: private */
    public int E = 0;
    /* access modifiers changed from: private */
    public int F = 0;
    /* access modifiers changed from: private */
    public int G = 0;
    /* access modifiers changed from: private */
    public int H = 0;
    private String I;
    private com.mbridge.msdk.video.dynview.e.a J = new com.mbridge.msdk.video.dynview.e.a() {
        public final void a(Map<String, Object> map) {
            if (map != null) {
                if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                    int unused = MBRewardVideoActivity.this.e = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
                }
                if (map.containsKey("position")) {
                    int intValue = ((Integer) map.get("position")).intValue();
                    if (MBRewardVideoActivity.this.t != null && MBRewardVideoActivity.this.t.size() > 0 && intValue >= 1) {
                        MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                        CampaignEx unused2 = mBRewardVideoActivity.r = (CampaignEx) mBRewardVideoActivity.t.get(intValue);
                        MBRewardVideoActivity.b(MBRewardVideoActivity.this);
                        int i = intValue - 1;
                        if (MBRewardVideoActivity.this.t.get(i) != null) {
                            MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                            int unused3 = mBRewardVideoActivity2.C = mBRewardVideoActivity2.C - ((CampaignEx) MBRewardVideoActivity.this.t.get(i)).getVideoLength();
                        }
                        MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                        MBRewardVideoActivity.this.r.setVideoCompleteTime(mBRewardVideoActivity3.a(mBRewardVideoActivity3.r.getVideoCompleteTime(), MBRewardVideoActivity.this.B));
                        MBRewardVideoActivity mBRewardVideoActivity4 = MBRewardVideoActivity.this;
                        mBRewardVideoActivity4.a(mBRewardVideoActivity4.r);
                    }
                }
            }
        }
    };
    private d K = new d() {
        public final void a(CampaignEx campaignEx) {
            if (campaignEx != null) {
                if (MBRewardVideoActivity.this.v != null) {
                    new com.mbridge.msdk.video.dynview.h.b().b((View) MBRewardVideoActivity.this.v, 500);
                }
                CampaignEx unused = MBRewardVideoActivity.this.r = campaignEx;
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.a(mBRewardVideoActivity.r);
                return;
            }
            MBRewardVideoActivity.this.a("campaign is null");
        }

        public final void a() {
            if (MBRewardVideoActivity.this.v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b((View) MBRewardVideoActivity.this.v, 500);
            }
            boolean unused = MBRewardVideoActivity.this.k = true;
            MBRewardVideoActivity.this.b();
            if (MBRewardVideoActivity.this.u != null) {
                MBRewardVideoActivity.this.u.setNotchPadding(MBRewardVideoActivity.this.H, MBRewardVideoActivity.this.D, MBRewardVideoActivity.this.F, MBRewardVideoActivity.this.E, MBRewardVideoActivity.this.G);
            }
        }
    };
    private String a;
    private String b;
    private String c;
    private c d;
    /* access modifiers changed from: private */
    public int e = 2;
    private boolean f = false;
    private boolean g = false;
    private int h;
    private int i;
    private int j;
    /* access modifiers changed from: private */
    public boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public h m;
    private com.mbridge.msdk.videocommon.d.c n;
    private boolean o = false;
    private boolean p = false;
    private com.mbridge.msdk.videocommon.download.a q;
    /* access modifiers changed from: private */
    public CampaignEx r;
    private List<com.mbridge.msdk.videocommon.download.a> s;
    /* access modifiers changed from: private */
    public List<CampaignEx> t;
    /* access modifiers changed from: private */
    public MBTempContainer u;
    /* access modifiers changed from: private */
    public MBridgeBTContainer v;
    private WindVaneWebView w;
    private com.mbridge.msdk.video.bt.module.a.a x;
    private String y;
    private String z;

    static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity) {
        int i2 = mBRewardVideoActivity.B;
        mBRewardVideoActivity.B = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:105|106|107|108|109|110|(3:112|113|114)(2:115|(2:117|118)(2:119|(1:129)(1:(3:124|(1:126)|127)(1:128))))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x0303 */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0311 A[SYNTHETIC, Splitter:B:112:0x0311] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0315 A[Catch:{ Exception -> 0x0154, all -> 0x03ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.lang.String r2 = "_"
            java.lang.String r3 = ""
            java.lang.String r4 = "anim"
            java.lang.String r5 = "2000129"
            java.lang.String r6 = "进入 show，大模板 "
            super.onCreate(r22)
            r7 = 1
            com.mbridge.msdk.MBridgeConstans.isRewardActivityShowing = r7
            com.mbridge.msdk.foundation.controller.b r8 = com.mbridge.msdk.foundation.controller.b.d()
            r8.a((android.content.Context) r1)
            java.lang.String r8 = "mbridge_more_offer_activity"
            int r8 = r1.findLayout(r8)     // Catch:{ all -> 0x03ba }
            if (r8 >= 0) goto L_0x002a
            java.lang.String r0 = "no mbridge_more_offer_activity layout"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x03ba }
            return
        L_0x002a:
            r1.setContentView(r8)     // Catch:{ all -> 0x03ba }
            android.content.Intent r8 = r21.getIntent()     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_UNITID     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = r8.getStringExtra(r9)     // Catch:{ all -> 0x03ba }
            r1.a = r9     // Catch:{ all -> 0x03ba }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x03ba }
            java.lang.String r10 = "data empty error"
            if (r9 == 0) goto L_0x0045
            r1.a((java.lang.String) r10)     // Catch:{ all -> 0x03ba }
            return
        L_0x0045:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.reward.b.a$d> r9 = com.mbridge.msdk.reward.b.a.h     // Catch:{ all -> 0x03ba }
            java.lang.String r11 = r1.a     // Catch:{ all -> 0x03ba }
            java.lang.Object r9 = r9.get(r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.video.bt.module.b.h r9 = (com.mbridge.msdk.video.bt.module.b.h) r9     // Catch:{ all -> 0x03ba }
            r1.m = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = r8.getStringExtra(r9)     // Catch:{ all -> 0x03ba }
            r1.b = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_REWARD     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = r8.getStringExtra(r9)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.b.c r9 = com.mbridge.msdk.videocommon.b.c.b(r9)     // Catch:{ all -> 0x03ba }
            r1.d = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_USERID     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = r8.getStringExtra(r9)     // Catch:{ all -> 0x03ba }
            r1.c = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_MUTE     // Catch:{ all -> 0x03ba }
            r11 = 2
            int r9 = r8.getIntExtra(r9, r11)     // Catch:{ all -> 0x03ba }
            r1.e = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_ISIV     // Catch:{ all -> 0x03ba }
            r11 = 0
            boolean r9 = r8.getBooleanExtra(r9, r11)     // Catch:{ all -> 0x03ba }
            r1.f = r9     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r9 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x03ba }
            boolean r12 = r1.f     // Catch:{ all -> 0x03ba }
            r14 = 94
            if (r12 == 0) goto L_0x008c
            r12 = 287(0x11f, float:4.02E-43)
            goto L_0x008e
        L_0x008c:
            r12 = 94
        L_0x008e:
            r9.a((int) r12)     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_ISBID     // Catch:{ all -> 0x03ba }
            boolean r9 = r8.getBooleanExtra(r9, r11)     // Catch:{ all -> 0x03ba }
            r1.g = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_EXTRADATA     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = r8.getStringExtra(r9)     // Catch:{ all -> 0x03ba }
            r1.z = r9     // Catch:{ all -> 0x03ba }
            boolean r9 = r1.f     // Catch:{ all -> 0x03ba }
            if (r9 == 0) goto L_0x00bd
            java.lang.String r9 = INTENT_IVREWARD_MODETYPE     // Catch:{ all -> 0x03ba }
            int r9 = r8.getIntExtra(r9, r11)     // Catch:{ all -> 0x03ba }
            r1.h = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_IVREWARD_VALUETYPE     // Catch:{ all -> 0x03ba }
            int r9 = r8.getIntExtra(r9, r11)     // Catch:{ all -> 0x03ba }
            r1.i = r9     // Catch:{ all -> 0x03ba }
            java.lang.String r9 = INTENT_IVREWARD_VALUE     // Catch:{ all -> 0x03ba }
            int r9 = r8.getIntExtra(r9, r11)     // Catch:{ all -> 0x03ba }
            r1.j = r9     // Catch:{ all -> 0x03ba }
        L_0x00bd:
            com.mbridge.msdk.video.signal.factory.b r9 = new com.mbridge.msdk.video.signal.factory.b     // Catch:{ all -> 0x03ba }
            r9.<init>(r1)     // Catch:{ all -> 0x03ba }
            r1.jsFactory = r9     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.video.signal.factory.IJSFactory r9 = r1.jsFactory     // Catch:{ all -> 0x03ba }
            r1.registerJsFactory(r9)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.video.bt.module.b.h r9 = r1.m     // Catch:{ all -> 0x03ba }
            if (r9 != 0) goto L_0x00d3
            java.lang.String r0 = "showRewardListener is null"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x03ba }
            return
        L_0x00d3:
            com.mbridge.msdk.reward.adapter.RewardUnitCacheManager r9 = com.mbridge.msdk.reward.adapter.RewardUnitCacheManager.getInstance()     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r1.b     // Catch:{ all -> 0x03ba }
            java.lang.String r15 = r1.a     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.d.c r9 = r9.get(r12, r15)     // Catch:{ all -> 0x03ba }
            r1.n = r9     // Catch:{ all -> 0x03ba }
            if (r9 != 0) goto L_0x010f
            com.mbridge.msdk.videocommon.d.b r9 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r12 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r12.h()     // Catch:{ all -> 0x03ba }
            java.lang.String r15 = r1.a     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.d.c r9 = r9.a(r12, r15)     // Catch:{ all -> 0x03ba }
            r1.n = r9     // Catch:{ all -> 0x03ba }
            if (r9 != 0) goto L_0x010f
            com.mbridge.msdk.videocommon.d.b r9 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r12 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r12.h()     // Catch:{ all -> 0x03ba }
            java.lang.String r15 = r1.a     // Catch:{ all -> 0x03ba }
            boolean r13 = r1.f     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.d.c r9 = r9.a((java.lang.String) r12, (java.lang.String) r15, (boolean) r13)     // Catch:{ all -> 0x03ba }
            r1.n = r9     // Catch:{ all -> 0x03ba }
        L_0x010f:
            com.mbridge.msdk.videocommon.d.c r9 = r1.n     // Catch:{ all -> 0x03ba }
            if (r9 == 0) goto L_0x0127
            com.mbridge.msdk.videocommon.b.c r12 = r1.d     // Catch:{ all -> 0x03ba }
            int r9 = r9.m()     // Catch:{ all -> 0x03ba }
            r12.a((int) r9)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.b.c r9 = r1.d     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.d.c r12 = r1.n     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = r12.n()     // Catch:{ all -> 0x03ba }
            r9.a((java.lang.String) r12)     // Catch:{ all -> 0x03ba }
        L_0x0127:
            com.mbridge.msdk.videocommon.b.c r9 = r1.d     // Catch:{ all -> 0x03ba }
            if (r9 == 0) goto L_0x0136
            int r9 = r9.b()     // Catch:{ all -> 0x03ba }
            if (r9 > 0) goto L_0x0136
            com.mbridge.msdk.videocommon.b.c r9 = r1.d     // Catch:{ all -> 0x03ba }
            r9.a((int) r7)     // Catch:{ all -> 0x03ba }
        L_0x0136:
            java.lang.String r9 = "mbridge_reward_activity_open"
            int r9 = com.mbridge.msdk.foundation.tools.t.a(r1, r9, r4)     // Catch:{ all -> 0x03ba }
            java.lang.String r12 = "mbridge_reward_activity_stay"
            int r4 = com.mbridge.msdk.foundation.tools.t.a(r1, r12, r4)     // Catch:{ all -> 0x03ba }
            if (r9 <= r7) goto L_0x0149
            if (r4 <= r7) goto L_0x0149
            r1.overridePendingTransition(r9, r4)     // Catch:{ all -> 0x03ba }
        L_0x0149:
            if (r0 == 0) goto L_0x0158
            java.lang.String r4 = SAVE_STATE_KEY_REPORT     // Catch:{ Exception -> 0x0154 }
            boolean r0 = r0.getBoolean(r4)     // Catch:{ Exception -> 0x0154 }
            r1.p = r0     // Catch:{ Exception -> 0x0154 }
            goto L_0x0158
        L_0x0154:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x03ba }
        L_0x0158:
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x03ba }
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.b((java.lang.String) r4)     // Catch:{ all -> 0x03ba }
            r1.s = r0     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = INTENT_ISBIG_OFFER     // Catch:{ all -> 0x03ba }
            boolean r0 = r8.getBooleanExtra(r0, r11)     // Catch:{ all -> 0x03ba }
            r1.k = r0     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = "DynamicViewCampaignResourceDownloader"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r4.<init>(r6)     // Catch:{ all -> 0x03ba }
            boolean r6 = r1.k     // Catch:{ all -> 0x03ba }
            r4.append(r6)     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x03ba }
            boolean r0 = r1.k     // Catch:{ all -> 0x03ba }
            if (r0 != 0) goto L_0x0200
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x0197
            int r0 = r0.size()     // Catch:{ all -> 0x03ba }
            if (r0 <= 0) goto L_0x0197
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x03ba }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.a r0 = (com.mbridge.msdk.videocommon.download.a) r0     // Catch:{ all -> 0x03ba }
            r1.q = r0     // Catch:{ all -> 0x03ba }
        L_0x0197:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x01dc
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.k()     // Catch:{ all -> 0x03ba }
            r1.r = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            r0.e((boolean) r7)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            r0.f((boolean) r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x01dc
            java.lang.String r0 = r0.getCurrentLRid()     // Catch:{ all -> 0x03ba }
            r1.I = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.getLocalRequestId()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.reward.b.a.c = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.getEcppv()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.reward.b.a.d = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x03ba }
            android.content.Context r0 = r0.g()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ all -> 0x03ba }
            int r2 = r2.getMaitve()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.r     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = r3.getMaitve_src()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.click.b.a((android.content.Context) r0, (int) r2, (java.lang.String) r3)     // Catch:{ all -> 0x03ba }
        L_0x01dc:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x01e8
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x01e8
            com.mbridge.msdk.videocommon.b.c r0 = r1.d     // Catch:{ all -> 0x03ba }
            if (r0 != 0) goto L_0x01eb
        L_0x01e8:
            r1.a((java.lang.String) r10)     // Catch:{ all -> 0x03ba }
        L_0x01eb:
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ba }
            java.lang.String r2 = r1.I     // Catch:{ all -> 0x03ba }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x03ba }
            r3.<init>()     // Catch:{ all -> 0x03ba }
            r0.a((java.lang.String) r5, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x03ba }
            r21.b()     // Catch:{ all -> 0x03ba }
            r21.a()     // Catch:{ all -> 0x03ba }
            return
        L_0x0200:
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x03ba }
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.a((java.lang.String) r4)     // Catch:{ all -> 0x03ba }
            r1.t = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ba }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r1.t     // Catch:{ all -> 0x03ba }
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)     // Catch:{ all -> 0x03ba }
            r1.y = r3     // Catch:{ all -> 0x03ba }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x0258
            int r0 = r0.size()     // Catch:{ all -> 0x03ba }
            if (r0 <= 0) goto L_0x0258
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x03ba }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = r0.getCMPTEntryUrl()     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r0.getRequestId()     // Catch:{ all -> 0x03ba }
            r1.y = r4     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r0.getCurrentLRid()     // Catch:{ all -> 0x03ba }
            r1.I = r4     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r0.getLocalRequestId()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.reward.b.a.c = r4     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r0.getEcppv()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.reward.b.a.d = r4     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x03ba }
            android.content.Context r4 = r4.g()     // Catch:{ all -> 0x03ba }
            int r6 = r0.getMaitve()     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.getMaitve_src()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.click.b.a((android.content.Context) r4, (int) r6, (java.lang.String) r0)     // Catch:{ all -> 0x03ba }
        L_0x0258:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ba }
            r0.<init>()     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x03ba }
            r0.append(r4)     // Catch:{ all -> 0x03ba }
            r0.append(r2)     // Catch:{ all -> 0x03ba }
            java.lang.String r4 = r1.y     // Catch:{ all -> 0x03ba }
            r0.append(r4)     // Catch:{ all -> 0x03ba }
            r0.append(r2)     // Catch:{ all -> 0x03ba }
            r0.append(r3)     // Catch:{ all -> 0x03ba }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.a$a r0 = com.mbridge.msdk.videocommon.a.a(r0)     // Catch:{ all -> 0x03ba }
            r2 = 0
            if (r0 == 0) goto L_0x0280
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r0.a()     // Catch:{ all -> 0x03ba }
            goto L_0x0281
        L_0x0280:
            r0 = r2
        L_0x0281:
            r1.w = r0     // Catch:{ all -> 0x03ba }
            if (r0 != 0) goto L_0x03a5
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            if (r0 != 0) goto L_0x029d
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x029d
            int r0 = r0.size()     // Catch:{ all -> 0x03ba }
            if (r0 <= 0) goto L_0x029d
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x03ba }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.a r0 = (com.mbridge.msdk.videocommon.download.a) r0     // Catch:{ all -> 0x03ba }
            r1.q = r0     // Catch:{ all -> 0x03ba }
        L_0x029d:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            if (r0 != 0) goto L_0x02be
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x03ba }
            boolean r3 = r1.f     // Catch:{ all -> 0x03ba }
            if (r3 == 0) goto L_0x02ac
            r13 = 287(0x11f, float:4.02E-43)
            goto L_0x02ae
        L_0x02ac:
            r13 = 94
        L_0x02ae:
            java.lang.String r3 = r1.a     // Catch:{ all -> 0x03ba }
            boolean r4 = r1.g     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.n r0 = r0.c(r3)     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x02bc
            com.mbridge.msdk.videocommon.download.a r2 = r0.b((int) r13, (boolean) r4)     // Catch:{ all -> 0x03ba }
        L_0x02bc:
            r1.q = r2     // Catch:{ all -> 0x03ba }
        L_0x02be:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x02d2
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.k()     // Catch:{ all -> 0x03ba }
            r1.r = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            r0.e((boolean) r7)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            r0.f((boolean) r11)     // Catch:{ all -> 0x03ba }
        L_0x02d2:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x03a1
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r1.r     // Catch:{ all -> 0x03ba }
            if (r12 == 0) goto L_0x03a1
            com.mbridge.msdk.videocommon.b.c r0 = r1.d     // Catch:{ all -> 0x03ba }
            if (r0 != 0) goto L_0x02e0
            goto L_0x03a1
        L_0x02e0:
            r1.k = r11     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0303 }
            android.content.Context r13 = r0.g()     // Catch:{ Exception -> 0x0303 }
            java.lang.String r14 = "showMoreOffer showBTOld"
            java.lang.String r15 = r1.a     // Catch:{ Exception -> 0x0303 }
            boolean r0 = r1.g     // Catch:{ Exception -> 0x0303 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ Exception -> 0x0303 }
            java.lang.String r17 = r2.getRequestId()     // Catch:{ Exception -> 0x0303 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ Exception -> 0x0303 }
            java.lang.String r18 = r2.getRequestIdNotice()     // Catch:{ Exception -> 0x0303 }
            r19 = 0
            r16 = r0
            com.mbridge.msdk.reward.c.a.a(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x0303 }
        L_0x0303:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ all -> 0x03ba }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r1.t     // Catch:{ all -> 0x03ba }
            java.util.List r0 = r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x03ba }
            java.lang.String r2 = "no available campaign"
            if (r0 != 0) goto L_0x0315
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x03ba }
            return
        L_0x0315:
            int r3 = r0.size()     // Catch:{ all -> 0x03ba }
            if (r3 != 0) goto L_0x031f
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x03ba }
            return
        L_0x031f:
            java.lang.Object r2 = r0.get(r11)     // Catch:{ all -> 0x03ba }
            if (r2 == 0) goto L_0x038f
            java.lang.Object r2 = r0.get(r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ all -> 0x03ba }
            boolean r2 = r2.isDynamicView()     // Catch:{ all -> 0x03ba }
            if (r2 == 0) goto L_0x038f
            if (r3 != r7) goto L_0x037d
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x03ba }
            r1.r = r0     // Catch:{ all -> 0x03ba }
            if (r0 == 0) goto L_0x0369
            java.lang.String r0 = r0.getCurrentLRid()     // Catch:{ all -> 0x03ba }
            r1.I = r0     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            r0.setCampaignIsFiltered(r7)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r1.r     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x03ba }
            android.content.Context r9 = r0.g()     // Catch:{ all -> 0x03ba }
            java.lang.String r10 = "no available campaign but to one offer show"
            java.lang.String r11 = r1.a     // Catch:{ all -> 0x03ba }
            boolean r12 = r1.g     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            java.lang.String r13 = r0.getRequestId()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            java.lang.String r14 = r0.getRequestIdNotice()     // Catch:{ all -> 0x03ba }
            r15 = 0
            com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x03ba }
        L_0x0369:
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ all -> 0x03ba }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x03ba }
            r3.<init>()     // Catch:{ all -> 0x03ba }
            r0.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x03ba }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x03ba }
            goto L_0x03b6
        L_0x037d:
            com.mbridge.msdk.foundation.same.report.m r2 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ba }
            java.lang.String r3 = r1.I     // Catch:{ all -> 0x03ba }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x03ba }
            r4.<init>()     // Catch:{ all -> 0x03ba }
            r2.a((java.lang.String) r5, (java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ all -> 0x03ba }
            r1.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ all -> 0x03ba }
            goto L_0x03b6
        L_0x038f:
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ba }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ all -> 0x03ba }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x03ba }
            r3.<init>()     // Catch:{ all -> 0x03ba }
            r0.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x03ba }
            r21.b()     // Catch:{ all -> 0x03ba }
            goto L_0x03b6
        L_0x03a1:
            r1.a((java.lang.String) r10)     // Catch:{ all -> 0x03ba }
            return
        L_0x03a5:
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ba }
            java.lang.String r2 = r1.I     // Catch:{ all -> 0x03ba }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x03ba }
            r3.<init>()     // Catch:{ all -> 0x03ba }
            r0.a((java.lang.String) r5, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x03ba }
            r21.c()     // Catch:{ all -> 0x03ba }
        L_0x03b6:
            r21.a()     // Catch:{ all -> 0x03ba }
            return
        L_0x03ba:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "onCreate error"
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.a((java.lang.String) r0)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            java.lang.String r2 = r1.I
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0.a((java.lang.String) r5, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.player.MBRewardVideoActivity.onCreate(android.os.Bundle):void");
    }

    private void a() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable a2 = com.mbridge.msdk.foundation.controller.b.d().a(this.a, this.f ? 287 : 94);
            if (a2 != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
                af.a(imageView, a2, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(List<CampaignEx> list) {
        int i2;
        if (list == null) {
            a("no available campaign");
        } else if (list.size() == 0) {
            a("no available campaign");
        } else {
            if (list.get(0) != null) {
                i2 = list.get(0).getDynamicTempCode();
                this.I = list.get(0).getCurrentLRid();
            } else {
                i2 = 0;
            }
            if (i2 != 5) {
                c();
                return;
            }
            for (CampaignEx next : list) {
                if (next != null) {
                    this.C += next.getVideoLength();
                }
            }
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null) {
                int a2 = a(campaignEx.getVideoCompleteTime(), this.B);
                this.r = campaignEx;
                campaignEx.setCampaignIsFiltered(true);
                this.B = 1;
                this.r.setVideoCompleteTime(a2);
                a(this.r);
                return;
            }
            a("campaign is less");
        }
    }

    /* access modifiers changed from: private */
    public void a(CampaignEx campaignEx) {
        CampaignEx k2;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.s;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a next : this.s) {
                    if (next != null && (k2 = next.k()) != null && TextUtils.equals(k2.getId(), campaignEx.getId()) && TextUtils.equals(k2.getRequestId(), campaignEx.getRequestId())) {
                        this.q = next;
                    }
                }
            }
            this.k = true;
            b();
            MBTempContainer mBTempContainer = this.u;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.H, this.D, this.F, this.E, this.G);
            }
        } catch (Exception e2) {
            aa.d("MBRewardVideoActivity", e2.getMessage());
            a("more offer to one offer exception");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        aa.d("MBRewardVideoActivity", str);
        h hVar = this.m;
        if (hVar != null) {
            hVar.a(str);
            m.a().a("2000129", this.I, (Map<String, String>) new HashMap());
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void b() {
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        List<CampaignEx> list2;
        try {
            m.a().a(this.r);
        } catch (Exception unused) {
        }
        int findID = findID("mbridge_temp_container");
        if (findID < 0) {
            a("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(findID);
        this.u = mBTempContainer;
        if (mBTempContainer == null) {
            a("env error");
        }
        List<CampaignEx> list3 = this.t;
        if (list3 == null || list3.size() <= 0 || !this.t.get(0).isDynamicView()) {
            this.u.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.h.b().c((View) this.u, 500);
        }
        com.mbridge.msdk.reward.b.a.b = this.r.getCurrentLRid();
        changeHalfScreenPadding(-1);
        this.u.setActivity(this);
        this.u.setBidCampaign(this.g);
        this.u.setBigOffer(this.k);
        this.u.setUnitId(this.a);
        this.u.setCampaign(this.r);
        if (this.r.getDynamicTempCode() == 5 && (list2 = this.t) != null && list2.size() > 1) {
            View findViewById = findViewById(findID("mbridge_reward_root_container"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.u.removeAllViews();
            this.u.setCampOrderViewData(this.t, this.C);
            this.u.setCamPlayOrderCallback(this.J, this.B);
        }
        this.u.setCampaignDownLoadTask(this.q);
        this.u.setIV(this.f);
        CampaignEx campaignEx = this.r;
        if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
            this.u.setIVRewardEnable(this.h, this.i, this.j);
        } else {
            this.u.setIVRewardEnable(0, 0, 0);
        }
        this.u.setMute(this.e);
        CampaignEx campaignEx2 = this.r;
        if (!((campaignEx2 == null || (rewardPlus = campaignEx2.getRewardPlus()) == null) && ((list = this.t) == null || list.size() <= 0 || this.t.get(0) == null || (rewardPlus = this.t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            c cVar = new c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.d = cVar;
        }
        this.u.setReward(this.d);
        this.u.setRewardUnitSetting(this.n);
        this.u.setPlacementId(this.b);
        this.u.setUserId(this.c);
        this.u.setShowRewardListener(this.m);
        this.u.setDeveloperExtraData(this.z);
        this.u.init(this);
        this.u.onCreate();
        try {
            com.mbridge.msdk.reward.c.a.a(this.r, com.mbridge.msdk.foundation.controller.b.d().g(), "showBTOld", this.a, this.g, "", "", 0);
        } catch (Exception unused2) {
        }
    }

    private void c() {
        RewardPlus rewardPlus;
        int findID = findID("mbridge_bt_container");
        if (findID < 0) {
            a("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(findID);
        this.v = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            a("env error");
        }
        this.v.setVisibility(0);
        com.mbridge.msdk.video.bt.module.a.a d2 = d();
        this.x = d2;
        this.v.setBTContainerCallback(d2);
        this.v.setShowRewardVideoListener(this.m);
        this.v.setChoiceOneCallback(this.K);
        this.v.setCampaigns(this.t);
        this.v.setCampaignDownLoadTasks(this.s);
        this.v.setRewardUnitSetting(this.n);
        this.v.setUnitId(this.a);
        this.v.setPlacementId(this.b);
        this.v.setUserId(this.c);
        this.v.setActivity(this);
        CampaignEx campaignEx = this.r;
        if (!((campaignEx == null || (rewardPlus = campaignEx.getRewardPlus()) == null) && (this.t.get(0) == null || (rewardPlus = this.t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            c cVar = new c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.d = cVar;
        }
        this.v.setReward(this.d);
        this.v.setIVRewardEnable(this.h, this.i, this.j);
        this.v.setIV(this.f);
        this.v.setMute(this.e);
        this.v.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.v.setDeveloperExtraData(this.z);
        this.v.init(this);
        this.v.onCreate();
        List<com.mbridge.msdk.videocommon.download.a> list = this.s;
        if (list != null && list.size() > 0) {
            try {
                com.mbridge.msdk.reward.c.a.a(this.s.get(0).k(), com.mbridge.msdk.foundation.controller.b.d().g(), "showMoreOffer", this.a, this.g, "", "", 0);
            } catch (Exception unused) {
            }
        }
    }

    private com.mbridge.msdk.video.bt.module.a.a d() {
        if (this.x == null) {
            this.x = new com.mbridge.msdk.video.bt.module.a.a() {
                public final void a() {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a();
                    }
                }

                public final void a(boolean z, c cVar) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(z, cVar);
                    }
                }

                public final void a(boolean z, int i) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(z, i);
                    }
                }

                public final void a(String str) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(str);
                    }
                }

                public final void a(boolean z, String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(z, str, str2);
                    }
                }

                public final void a(String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(str, str2);
                    }
                }

                public final void b(String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.b(str, str2);
                    }
                }

                public final void a(int i, String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(i, str, str2);
                    }
                }
            };
        }
        return this.x;
    }

    /* access modifiers changed from: private */
    public int a(int i2, int i3) {
        List<CampaignEx> list = this.t;
        if (list == null || list.size() == 0) {
            return i2;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.t.size(); i6++) {
            if (this.t.get(0) != null) {
                if (i6 == 0) {
                    i5 = this.t.get(0).getVideoCompleteTime();
                }
                i4 += this.t.get(i6).getVideoLength();
            }
        }
        if (i3 == 1) {
            if (i2 == 0) {
                if (i4 >= 45) {
                    return 45;
                }
            } else if (i4 > i2) {
                if (i2 > 45) {
                    return 45;
                }
                return i2;
            }
            return i4;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i3 - 1; i8++) {
            if (this.t.get(i8) != null) {
                i7 += this.t.get(i8).getVideoLength();
            }
        }
        if (i5 > i7) {
            return i5 - i7;
        }
        return 0;
    }

    public void onResume() {
        super.onResume();
        if (!com.mbridge.msdk.foundation.c.b.c) {
            com.mbridge.msdk.foundation.controller.b.d().a((Context) this);
            try {
                com.mbridge.msdk.foundation.same.f.b.a().execute(new b(this.a, this.s));
            } catch (Throwable th) {
                aa.d("MBRewardVideoActivity", th.getMessage());
            }
            MBTempContainer mBTempContainer = this.u;
            if (mBTempContainer != null) {
                mBTempContainer.onResume();
            }
            MBridgeBTContainer mBridgeBTContainer = this.v;
            if (mBridgeBTContainer != null) {
                mBridgeBTContainer.onResume();
            }
        }
    }

    public void onPause() {
        super.onPause();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.u != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.u.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(this.I)) {
            hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.a);
        }
        m.a().a("2000151", this.I, (Map<String, String>) new HashMap());
        com.mbridge.msdk.video.module.b.b.a(this.a);
        e();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.v = null;
        }
        this.J = null;
        this.K = null;
        com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
        a2.c(this.a + "_1");
        com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
        a3.c(this.a + "_2");
        com.mbridge.msdk.foundation.same.f.b.a().execute(new a(this.s, this.a, this.y));
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (!com.mbridge.msdk.foundation.c.b.c) {
            new com.mbridge.msdk.foundation.c.a() {
                public final void a() {
                    MBRewardVideoActivity.this.onPause();
                }

                public final void b() {
                    MBRewardVideoActivity.this.onResume();
                }

                public final void a(String str) {
                    MBRewardVideoActivity.this.onResume();
                }
            };
            MBTempContainer mBTempContainer = this.u;
            if (mBTempContainer != null) {
                mBTempContainer.onStart();
                this.r.setCampaignUnitId(this.a);
                com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
                a2.a(this.a + "_1", this.r);
            }
            MBridgeBTContainer mBridgeBTContainer = this.v;
            if (mBridgeBTContainer != null) {
                mBridgeBTContainer.onStart();
                List<CampaignEx> list = this.t;
                if (list != null && list.size() > 0) {
                    CampaignEx campaignEx = this.t.get(0);
                    campaignEx.setCampaignUnitId(this.a);
                    com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
                    a3.a(this.a + "_1", campaignEx);
                }
            }
            if (!this.A) {
                com.mbridge.msdk.foundation.c.b a4 = com.mbridge.msdk.foundation.c.b.a();
                a4.b(this.a + "_1", 1);
                com.mbridge.msdk.foundation.c.b a5 = com.mbridge.msdk.foundation.c.b.a();
                a5.c(this.a + "_2");
                this.A = true;
            }
        }
    }

    private static final class a implements Runnable {
        private final List<com.mbridge.msdk.videocommon.download.a> a;
        private final String b;
        private final String c;

        public a(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.a = list;
            this.b = str;
            this.c = str2;
        }

        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.a;
                if (list != null && list.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.a) {
                        if (!(next == null || next.k() == null)) {
                            CampaignEx k = next.k();
                            try {
                                AppletModelManager.getInstance().remove(k);
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    aa.b("MBRewardVideoActivity", "AppletModelManager remove error", e);
                                }
                            }
                            String str = k.getRequestId() + k.getId() + k.getVideoUrlEncode();
                            n c2 = com.mbridge.msdk.videocommon.download.c.getInstance().c(this.b);
                            if (c2 != null) {
                                try {
                                    c2.b(str);
                                } catch (Exception unused) {
                                }
                            }
                            if (k != null) {
                                if (k.getRewardTemplateMode() != null) {
                                    if (!TextUtils.isEmpty(k.getRewardTemplateMode().e())) {
                                        com.mbridge.msdk.videocommon.a.b(this.b + "_" + k.getId() + "_" + this.c + "_" + k.getRewardTemplateMode().e());
                                        com.mbridge.msdk.videocommon.a.b(k.getAdType(), k);
                                    }
                                    if (!TextUtils.isEmpty(k.getCMPTEntryUrl())) {
                                        com.mbridge.msdk.videocommon.a.b(this.b + "_" + this.c + "_" + k.getCMPTEntryUrl());
                                    }
                                    com.mbridge.msdk.videocommon.a.a.a().a(k);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                aa.a("MBRewardVideoActivity", e2.getMessage());
            }
        }
    }

    public void finish() {
        super.finish();
        com.mbridge.msdk.foundation.controller.b.d().a(0);
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.v = null;
        }
        com.mbridge.msdk.foundation.c.b.a().c(this.a);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.p);
        super.onSaveInstanceState(bundle);
    }

    public void setTopControllerPadding(int i2, int i3, int i4, int i5, int i6) {
        this.D = i3;
        this.F = i4;
        this.E = i5;
        this.G = i6;
        this.H = i2;
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        com.mbridge.msdk.video.dynview.a.a.e = i2;
        com.mbridge.msdk.video.dynview.a.a.a = i3;
        com.mbridge.msdk.video.dynview.a.a.b = i4;
        com.mbridge.msdk.video.dynview.a.a.c = i5;
        com.mbridge.msdk.video.dynview.a.a.d = i6;
    }

    public int findID(String str) {
        return t.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return t.a(getApplicationContext(), str, "layout");
    }

    public void changeHalfScreenPadding(int i2) {
        try {
            CampaignEx campaignEx = this.r;
            if (campaignEx != null && campaignEx.getAdSpaceT() == 2) {
                getWindow().getDecorView().setBackground(new ColorDrawable(0));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
                int b2 = af.b((Context) this, 58.0f);
                int b3 = af.b((Context) this, 104.0f);
                if (this.r.getRewardTemplateMode().c() == 0) {
                    if (i2 == 2) {
                        layoutParams.setMargins(b3, b2, b3, b2);
                    } else {
                        layoutParams.setMargins(b2, b3, b2, b3);
                    }
                } else if (this.r.getRewardTemplateMode().c() == 2) {
                    layoutParams.setMargins(b3, b2, b3, b2);
                } else {
                    layoutParams.setMargins(b2, b3, b2, b3);
                }
                this.u.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            aa.d("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void e() {
        try {
            List<CampaignEx> list = this.t;
            if (list != null && list.size() > 0) {
                for (CampaignEx b2 : this.t) {
                    b(b2);
                }
            }
            CampaignEx campaignEx = this.r;
            if (campaignEx != null) {
                b(campaignEx);
            }
        } catch (Throwable th) {
            aa.d("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).c(campaignEx.getImageUrl());
            }
            if (!TextUtils.isEmpty(campaignEx.getIconUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).c(campaignEx.getIconUrl());
            }
        }
    }

    public void setTheme(int i2) {
        super.setTheme(t.a(this, "mbridge_transparent_theme", "style"));
    }

    private static final class b implements Runnable {
        private final List<com.mbridge.msdk.videocommon.download.a> a;
        private final String b;

        public b(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.a = list;
            this.b = str;
        }

        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.a;
                if (list != null && list.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.a) {
                        if (!(next == null || next.k() == null)) {
                            com.mbridge.msdk.videocommon.a.a.a().a(next.k(), this.b);
                        }
                    }
                }
            } catch (Throwable th) {
                aa.d("MBRewardVideoActivity", th.getMessage());
            }
        }
    }
}
