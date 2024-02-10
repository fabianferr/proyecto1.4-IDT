package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.dynview.e.b;
import com.mbridge.msdk.video.dynview.e.c;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.h.a;
import com.mbridge.msdk.video.module.MBridgeBaseView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MBridgeOrderCampView extends MBridgeBaseView {
    /* access modifiers changed from: private */
    public MBridgeOrderCampView n;
    /* access modifiers changed from: private */
    public List<CampaignEx> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private String t;
    private FeedBackButton u;
    private ImageView v;
    /* access modifiers changed from: private */
    public boolean w = false;
    private c x = new c() {
        public final void a(CampaignEx campaignEx, int i) {
            if (campaignEx != null) {
                try {
                    MBridgeOrderCampView.this.setCampaign(campaignEx);
                    MBridgeOrderCampView.a(MBridgeOrderCampView.this, campaignEx, 0, i);
                } catch (Exception e) {
                    aa.d(MBridgeBaseView.TAG, e.getMessage());
                }
            }
        }

        public final void a() {
            MBridgeOrderCampView.a(MBridgeOrderCampView.this);
        }
    };
    /* access modifiers changed from: private */
    public b y;
    private boolean z = false;

    public MBridgeOrderCampView(Context context) {
        super(context);
    }

    public MBridgeOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        this.n = this;
    }

    public void createView(final ViewGroup viewGroup) {
        if (this.o == null) {
            b bVar = this.y;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("order_view_callback", this.x);
        com.mbridge.msdk.video.dynview.c b = new com.mbridge.msdk.video.dynview.j.c().b(com.mbridge.msdk.foundation.controller.b.d().g(), this.o);
        com.mbridge.msdk.video.dynview.b.a();
        new a(b, new g() {
            public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                if (aVar != null) {
                    try {
                        MBridgeOrderCampView.this.n.addView(aVar.a());
                        boolean unused = MBridgeOrderCampView.this.w = aVar.c();
                        viewGroup.removeAllViews();
                        viewGroup.addView(MBridgeOrderCampView.this.n);
                        f.a(com.mbridge.msdk.foundation.controller.b.d().g(), (List<CampaignEx>) MBridgeOrderCampView.this.o, ((CampaignEx) MBridgeOrderCampView.this.o.get(0)).getCampaignUnitId());
                        MBridgeOrderCampView.this.setViewStatus();
                        if (MBridgeOrderCampView.this.y != null) {
                            MBridgeOrderCampView.this.y.a();
                        }
                    } catch (Exception e) {
                        aa.d(MBridgeBaseView.TAG, e.getMessage());
                    }
                }
            }

            public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                try {
                    f.a(com.mbridge.msdk.foundation.controller.b.d().g(), (List<CampaignEx>) MBridgeOrderCampView.this.o, ((CampaignEx) MBridgeOrderCampView.this.o.get(0)).getCampaignUnitId(), aVar.b());
                    if (MBridgeOrderCampView.this.y != null) {
                        MBridgeOrderCampView.this.y.b();
                    }
                } catch (Exception e) {
                    aa.d(MBridgeBaseView.TAG, e.getMessage());
                }
            }
        }, hashMap);
    }

    public void setCampaignExes(List<CampaignEx> list) {
        this.o = list;
    }

    public void setCampOrderViewBuildCallback(b bVar) {
        this.y = bVar;
    }

    public void setRewarded(boolean z2) {
        this.z = z2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r5.o
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            r0 = 0
        L_0x0009:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.o
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0034
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001f }
            r2.<init>()     // Catch:{ JSONException -> 0x001f }
            java.lang.String r1 = "camp_position"
            r2.put(r1, r0)     // Catch:{ JSONException -> 0x001d }
            goto L_0x0026
        L_0x001d:
            r1 = move-exception
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0023:
            r1.printStackTrace()
        L_0x0026:
            com.mbridge.msdk.video.module.a.a r1 = r5.e
            if (r1 == 0) goto L_0x0031
            com.mbridge.msdk.video.module.a.a r1 = r5.e
            r3 = 110(0x6e, float:1.54E-43)
            r1.a(r3, r2)
        L_0x0031:
            int r0 = r0 + 1
            goto L_0x0009
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.onAttachedToWindow():void");
    }

    public void setViewStatus() {
        MBridgeOrderCampView mBridgeOrderCampView = this.n;
        if (mBridgeOrderCampView != null && this.z) {
            RelativeLayout relativeLayout = (RelativeLayout) mBridgeOrderCampView.findViewById(filterFindViewId(this.w, "mbridge_native_order_camp_controller"));
            this.u = (FeedBackButton) this.n.findViewById(filterFindViewId(this.w, "mbridge_native_order_camp_feed_btn"));
            this.v = (ImageView) this.n.findViewById(filterFindViewId(this.w, "mbridge_iv_link"));
            if (relativeLayout != null) {
                relativeLayout.setPadding(this.p, this.r, this.q, this.s);
            }
            if (this.u != null) {
                try {
                    List<CampaignEx> list = this.o;
                    if (list != null) {
                        if (list.get(0) != null) {
                            this.t = this.o.get(0).getCampaignUnitId();
                            this.b = this.o.get(0);
                            com.mbridge.msdk.foundation.c.b a = com.mbridge.msdk.foundation.c.b.a();
                            a.a(this.t + "_2", this.b);
                            if (this.u != null) {
                                if (com.mbridge.msdk.foundation.c.b.a().b()) {
                                    com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
                                    a2.a(this.t + "_2", (com.mbridge.msdk.foundation.c.a) new com.mbridge.msdk.foundation.c.a() {
                                        public final void a() {
                                        }

                                        public final void a(String str) {
                                        }

                                        public final void b() {
                                        }
                                    });
                                    com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
                                    a3.a(this.t + "_2", this.u);
                                } else {
                                    this.u.setVisibility(8);
                                }
                            }
                        }
                    }
                    FeedBackButton feedBackButton = this.u;
                    if (feedBackButton != null) {
                        feedBackButton.setVisibility(8);
                    }
                } catch (Exception e) {
                    aa.d(MBridgeBaseView.TAG, e.getMessage());
                }
            }
            ImageView imageView = this.v;
            if (imageView != null && imageView != null) {
                try {
                    e b = com.mbridge.msdk.c.f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                    if (b != null) {
                        final String al = b.al();
                        if (TextUtils.isEmpty(al)) {
                            this.v.setVisibility(8);
                        }
                        this.v.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                com.mbridge.msdk.click.b.b(MBridgeOrderCampView.this.a, al);
                            }
                        });
                        return;
                    }
                    this.v.setVisibility(8);
                } catch (Exception e2) {
                    aa.d(MBridgeBaseView.TAG, e2.getMessage());
                }
            }
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.p = i;
        this.q = i2;
        this.r = i3;
        this.s = i4;
        setViewStatus();
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        this.n.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500);
        this.n.startAnimation(translateAnimation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView r8, com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10, int r11) {
        /*
            java.lang.String r0 = "order_view_click"
            if (r9 == 0) goto L_0x0063
            boolean r1 = r9.isDynamicView()
            if (r1 == 0) goto L_0x0063
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r9.getRewardTemplateMode()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r3.<init>()     // Catch:{ Exception -> 0x0059 }
            int r1 = r1.b()     // Catch:{ Exception -> 0x0059 }
            r3.append(r1)     // Catch:{ Exception -> 0x0059 }
            r3.append(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0059 }
        L_0x0025:
            r7 = r2
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0059 }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x0059 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0059 }
            r2.append(r7)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = r9.getCampaignUnitId()     // Catch:{ Exception -> 0x0059 }
            boolean r4 = r9.isBidCampaign()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = r9.getRequestId()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r6 = r9.getRequestIdNotice()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r9 = r9.getId()     // Catch:{ Exception -> 0x0059 }
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            com.mbridge.msdk.foundation.same.report.q.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0063
        L_0x0059:
            r9 = move-exception
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r0, r9)
        L_0x0063:
            r9 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007a }
            r0.<init>()     // Catch:{ JSONException -> 0x007a }
            java.lang.String r9 = com.mbridge.msdk.foundation.same.a.h     // Catch:{ JSONException -> 0x0078 }
            org.json.JSONObject r10 = r8.a(r10)     // Catch:{ JSONException -> 0x0078 }
            r0.put(r9, r10)     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r9 = "camp_position"
            r0.put(r9, r11)     // Catch:{ JSONException -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r9 = move-exception
            goto L_0x007d
        L_0x007a:
            r10 = move-exception
            r0 = r9
            r9 = r10
        L_0x007d:
            r9.printStackTrace()
        L_0x0080:
            com.mbridge.msdk.video.module.a.a r9 = r8.e
            if (r9 == 0) goto L_0x008b
            com.mbridge.msdk.video.module.a.a r8 = r8.e
            r9 = 105(0x69, float:1.47E-43)
            r8.a(r9, r0)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.a(com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView, com.mbridge.msdk.foundation.entity.CampaignEx, int, int):void");
    }

    static /* synthetic */ void a(MBridgeOrderCampView mBridgeOrderCampView) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "2");
            m.a().c(mBridgeOrderCampView.b.getCurrentLRid(), "2000152", hashMap);
            m.a().a("2000134", mBridgeOrderCampView.b, (Map<String, String>) new HashMap());
        } catch (Throwable th) {
            aa.a(MBridgeBaseView.TAG, th.getMessage());
        }
        try {
            com.mbridge.msdk.video.dynview.moffer.a.a().b();
        } catch (Exception e) {
            aa.d(MBridgeBaseView.TAG, e.getMessage());
        }
        if (mBridgeOrderCampView.e != null) {
            mBridgeOrderCampView.e.a(104, "");
        }
    }
}
