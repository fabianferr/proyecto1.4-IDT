package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.f;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StatisticsOnNotifyListener */
public class k extends f {
    protected boolean a;
    protected CampaignEx b;
    protected List<CampaignEx> c;
    protected boolean d = false;
    protected a e;
    protected c f;
    protected String g;
    protected String h;
    protected com.mbridge.msdk.video.module.a.a i = new f();
    protected int j = 1;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;

    public final void a(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public final void a(List<CampaignEx> list) {
        this.c = list;
    }

    public k(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i2, boolean z) {
        if (!z && campaignEx != null && ak.b(str2) && aVar != null && aVar2 != null) {
            this.b = campaignEx;
            this.h = str;
            this.g = str2;
            this.e = aVar;
            this.f = cVar;
            this.i = aVar2;
            this.a = true;
            this.j = i2;
            this.d = false;
        } else if (z && campaignEx != null && ak.b(str2) && aVar2 != null) {
            this.b = campaignEx;
            this.h = str;
            this.g = str2;
            this.e = aVar;
            this.f = cVar;
            this.i = aVar2;
            this.a = true;
            this.j = i2;
            this.d = true;
        }
    }

    public void a(int i2, Object obj) {
        super.a(i2, obj);
        this.i.a(i2, obj);
    }

    public final void a(int i2) {
        if (this.b == null) {
            return;
        }
        if (i2 == 1 || i2 == 2) {
            b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, i2, this.j);
        }
    }

    public final void a() {
        if (this.a && this.b != null) {
            n nVar = new n("2000061", this.b.getId(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.g, w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
            nVar.b(this.b.isMraid() ? n.a : n.b);
            com.mbridge.msdk.foundation.same.report.n.b(nVar, com.mbridge.msdk.foundation.controller.b.d().g(), this.g);
        }
    }

    public final void a(int i2, String str) {
        if (this.b != null) {
            com.mbridge.msdk.foundation.same.report.n.c(new n("2000062", this.b.getId(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.g, w.r(com.mbridge.msdk.foundation.controller.b.d().g()), i2, str), com.mbridge.msdk.foundation.controller.b.d().g(), this.g);
        }
    }

    public final void b(int i2) {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i2);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i2);
                    }
                    noticeUrl = sb.toString();
                } else if (i2 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void b() {
        AnonymousClass1 r0 = new Runnable() {
            public final void run() {
                try {
                    if (k.this.a && k.this.b != null && ak.b(k.this.g) && com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        j a2 = j.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        f fVar = new f();
                        fVar.a(System.currentTimeMillis());
                        fVar.b(k.this.g);
                        fVar.a(k.this.b.getId());
                        a2.a(fVar);
                    }
                } catch (Throwable th) {
                    aa.b("NotifyListener", th.getMessage(), th);
                }
            }
        };
        com.mbridge.msdk.foundation.controller.c.a();
        com.mbridge.msdk.foundation.same.f.b.a().execute(r0);
    }

    public final void c() {
        try {
            AnonymousClass2 r0 = new Runnable() {
                public final void run() {
                    try {
                        if (k.this.a && k.this.b != null && ak.b(k.this.g)) {
                            com.mbridge.msdk.videocommon.a.a.a().a(k.this.b, k.this.g);
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        com.mbridge.msdk.videocommon.a.a.a().c(k.this.h, k.this.b.getAdType());
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        aa.a("NotifyListener", th.getMessage());
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.c.a();
            com.mbridge.msdk.foundation.same.f.b.a().execute(r0);
        } catch (Throwable th) {
            aa.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.f(true);
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        String str;
        try {
            CampaignEx campaignEx = this.b;
            if (campaignEx != null && campaignEx.isDynamicView() && this.d && !this.b.isCampaignIsFiltered()) {
                this.l = true;
            } else if (this.a && !TextUtils.isEmpty(this.b.getOnlyImpressionURL()) && d.a != null && !d.a.containsKey(this.b.getOnlyImpressionURL()) && !this.l) {
                d.a.put(this.b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                String onlyImpressionURL = this.b.getOnlyImpressionURL();
                if (this.b.getSpareOfferFlag() == 1) {
                    str = onlyImpressionURL + "&to=1&cbt=" + this.b.getCbt() + "&tmorl=" + this.j;
                } else {
                    str = onlyImpressionURL + "&to=0&cbt=" + this.b.getCbt() + "&tmorl=" + this.j;
                }
                String str2 = str;
                if (!this.d || this.b.isCampaignIsFiltered()) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, this.g, str2, false, true, com.mbridge.msdk.click.a.a.h);
                    c();
                }
                this.l = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        String str;
        try {
            if (this.a && !this.k && !TextUtils.isEmpty(this.b.getImpressionURL())) {
                this.k = true;
                if (this.b.isBidCampaign() && this.b != null) {
                    HashMap hashMap = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.c> b2 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).b(this.b.getCampaignUnitId(), this.b.getRequestId());
                    if (!(b2 == null || b2.size() <= 0 || b2.get(0) == null)) {
                        if (b2.get(0).d() == 1) {
                            hashMap.put("encrypt_p=", "encrypt_p=" + b2.get(0).b());
                            hashMap.put("irlfa=", "irlfa=1");
                            for (Map.Entry entry : hashMap.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String str3 = (String) entry.getValue();
                                CampaignEx campaignEx = this.b;
                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str2, str3));
                                CampaignEx campaignEx2 = this.b;
                                campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str2, str3));
                            }
                        }
                        aa.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(this.b.getRequestId()));
                    }
                }
                String impressionURL = this.b.getImpressionURL();
                if (this.b.getSpareOfferFlag() == 1) {
                    str = impressionURL + "&to=1&cbt=" + this.b.getCbt() + "&tmorl=" + this.j;
                } else {
                    str = impressionURL + "&to=0&cbt=" + this.b.getCbt() + "&tmorl=" + this.j;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, this.g, str, false, true, com.mbridge.msdk.click.a.a.g);
                b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b);
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            com.mbridge.msdk.foundation.db.k.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g())).b(k.this.b.getId());
                        } catch (Throwable th) {
                            aa.b("NotifyListener", th.getMessage(), th);
                        }
                    }
                }).start();
                if (this.a && d.d != null && !TextUtils.isEmpty(this.b.getId())) {
                    d.a(this.g, this.b, com.wortise.ads.events.modules.c.EXTRA_REWARD);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            aa.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        CampaignEx campaignEx;
        List<String> pv_urls;
        try {
            if (this.a && !this.m && (campaignEx = this.b) != null) {
                this.m = true;
                if ((!campaignEx.isDynamicView() || !this.d || this.b.isCampaignIsFiltered()) && (pv_urls = this.b.getPv_urls()) != null && pv_urls.size() > 0) {
                    for (String a2 : pv_urls) {
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, this.g, a2, false, true);
                    }
                }
            }
        } catch (Throwable th) {
            aa.d("NotifyListener", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && this.b.getNativeVideoTracking() != null && this.b.getNativeVideoTracking().o() != null) {
            Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
            CampaignEx campaignEx2 = this.b;
            com.mbridge.msdk.click.a.a(g2, campaignEx2, campaignEx2.getCampaignUnitId(), this.b.getNativeVideoTracking().o(), false, false);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        n nVar;
        try {
            if (this.a) {
                q a2 = q.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                if (!TextUtils.isEmpty(this.b.getNoticeUrl())) {
                    int r = w.r(com.mbridge.msdk.foundation.controller.b.d().g());
                    nVar = new n("2000021", r, this.b.getNoticeUrl(), str, w.a(com.mbridge.msdk.foundation.controller.b.d().g(), r));
                } else if (!TextUtils.isEmpty(this.b.getClickURL())) {
                    int r2 = w.r(com.mbridge.msdk.foundation.controller.b.d().g());
                    nVar = new n("2000021", r2, this.b.getClickURL(), str, w.a(com.mbridge.msdk.foundation.controller.b.d().g(), r2));
                } else {
                    nVar = null;
                }
                if (nVar != null) {
                    nVar.r(this.b.getId());
                    nVar.e(this.b.getVideoUrlEncode());
                    nVar.t(str);
                    nVar.n(this.b.getRequestId());
                    nVar.p(this.b.getRequestIdNotice());
                    nVar.q(this.g);
                    a2.a(nVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        List<CampaignEx> list;
        if (this.b != null && (list = this.c) != null && list.size() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("camp_position")) {
                    this.b = this.c.get(jSONObject.getInt("camp_position"));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
