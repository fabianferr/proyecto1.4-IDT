package com.appnext.nativeads.designed_native_ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.f;
import com.appnext.core.n;
import com.appnext.core.p;
import com.appnext.nativeads.NativeAdObject;
import java.util.ArrayList;
import java.util.List;

public final class d {
    /* access modifiers changed from: private */
    public Context aM;
    /* access modifiers changed from: private */
    public List<a> fF;
    /* access modifiers changed from: private */
    public String fG;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public d(Context context, List<DesignNativeAd> list, String str) {
        this.aM = context;
        this.fG = str;
        e(list);
    }

    private void e(List<DesignNativeAd> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.fF = new ArrayList();
                    for (DesignNativeAd aVar : list) {
                        this.fF.add(new a(aVar));
                    }
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("DesignedNativeAdsActionsController$init", th);
            }
        }
    }

    public final void a(final DesignNativeAd designNativeAd, final int i) {
        int indexOf;
        try {
            if (this.fF == null || (indexOf = this.fF.indexOf(new a(designNativeAd))) < 0) {
                return;
            }
            if (indexOf <= this.fF.size() - 1) {
                final a aVar = this.fF.get(indexOf);
                if ((!Boolean.parseBoolean(c.aG().t("report_vta_instead_of_impresssion")) || indexOf == 0) && !aVar.aL() && i >= Integer.parseInt(c.aG().t("min_imp_precentage"))) {
                    int parseInt = Integer.parseInt(c.aG().t("postpone_impression_sec"));
                    if (!Boolean.parseBoolean(c.aG().t("repeat_viewable_criteria")) || parseInt <= 0) {
                        int indexOf2 = this.fF.indexOf(new a(designNativeAd));
                        if (indexOf2 <= 0 || !this.fF.get(indexOf2).aL()) {
                            aVar.aI();
                            c(aVar.aJ());
                            return;
                        }
                        return;
                    }
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.postDelayed(new Runnable() {
                            public final void run() {
                                try {
                                    int indexOf = d.this.fF.indexOf(new a(designNativeAd));
                                    if ((indexOf <= 0 || !((a) d.this.fF.get(indexOf)).aL()) && i >= Integer.parseInt(c.aG().t("min_imp_precentage"))) {
                                        d.this.c(aVar.aJ());
                                        aVar.aI();
                                    }
                                } catch (Throwable th) {
                                    com.appnext.base.a.a("DesignedNativeAdsActionsController$impressionIfNecessary", th);
                                }
                            }
                        }, (long) (parseInt * 1000));
                    }
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdsActionsController$impressionIfNecessary", th);
        }
    }

    public final void b(final DesignNativeAd designNativeAd, final int i) {
        try {
            if (this.fF != null) {
                int indexOf = this.fF.indexOf(new a(designNativeAd));
                if (Boolean.parseBoolean(c.aG().t("report_vta_instead_of_impresssion"))) {
                    if ((Boolean.parseBoolean(c.aG().t("report_vta_instead_of_impresssion")) && indexOf == 0) || indexOf < 0) {
                        return;
                    }
                    if (indexOf <= this.fF.size() - 1) {
                        final a aVar = this.fF.get(indexOf);
                        if (!aVar.aK() && i >= Integer.parseInt(c.aG().t("min_vta_precentage"))) {
                            int parseInt = Integer.parseInt(c.aG().t("postpone_vta_sec"));
                            if (!Boolean.parseBoolean(c.aG().t("repeat_vta_viewable_criteria")) || parseInt <= 0) {
                                int indexOf2 = this.fF.indexOf(new a(designNativeAd));
                                if (indexOf2 <= 0 || !this.fF.get(indexOf2).aL()) {
                                    aVar.aH();
                                    b(aVar.aJ());
                                    return;
                                }
                                return;
                            }
                            Handler handler = this.mHandler;
                            if (handler != null) {
                                handler.postDelayed(new Runnable() {
                                    public final void run() {
                                        try {
                                            int indexOf = d.this.fF.indexOf(new a(designNativeAd));
                                            if ((indexOf <= 0 || !((a) d.this.fF.get(indexOf)).aL()) && i >= Integer.parseInt(c.aG().t("min_vta_precentage"))) {
                                                aVar.aH();
                                                d.this.b(aVar.aJ());
                                            }
                                        } catch (Throwable th) {
                                            com.appnext.base.a.a("DesignedNativeAdsActionsController$impressionIfNecessary", th);
                                        }
                                    }
                                }, (long) (parseInt * 1000));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdsActionsController$impressionIfNecessary", th);
        }
    }

    public final void a(DesignNativeAd designNativeAd) {
        try {
            new p(this.aM, new b(designNativeAd)).a(designNativeAd, designNativeAd.getAppURL(), this.fG, (f.a) null);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdsActionsController$doClick", th);
        }
    }

    /* access modifiers changed from: private */
    public void b(final DesignNativeAd designNativeAd) {
        try {
            p pVar = new p(this.aM, new b(designNativeAd));
            designNativeAd.getAdTitle();
            designNativeAd.getBannerID();
            pVar.a(designNativeAd, designNativeAd.getImpressionUrl(), (f.a) null);
            n.aa().a(new Runnable() {
                public final void run() {
                    com.appnext.core.adswatched.a.l(d.this.aM).j(designNativeAd.getBannerID(), DesignNativeAdObject.AUID);
                }
            });
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdsActionsController$vta", th);
        }
    }

    /* access modifiers changed from: private */
    public void c(final DesignNativeAd designNativeAd) {
        try {
            new p(this.aM, new b(designNativeAd)).d(designNativeAd);
            designNativeAd.getAdTitle();
            n.aa().a(new Runnable() {
                public final void run() {
                    com.appnext.core.adswatched.a.l(d.this.aM).j(designNativeAd.getBannerID(), DesignNativeAdObject.AUID);
                }
            });
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdsActionsController$impression", th);
        }
    }

    private class a {
        private String aY;
        private DesignNativeAd fM;
        private boolean fN = false;
        private boolean fO = false;

        public a(DesignNativeAd designNativeAd) {
            this.aY = designNativeAd.getBannerID();
            this.fM = designNativeAd;
        }

        public final void aH() {
            this.fN = true;
        }

        public final void aI() {
            this.fO = true;
        }

        public final DesignNativeAd aJ() {
            return this.fM;
        }

        public final boolean aK() {
            return this.fN;
        }

        public final boolean aL() {
            return this.fO;
        }

        public final boolean equals(Object obj) {
            if (obj != null) {
                try {
                    if ((obj instanceof a) && ((a) obj).aY.equals(this.aY)) {
                        return true;
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("DesignedNativeAdsActionsController$Reports", th);
                }
            }
            return super.equals(obj);
        }
    }

    private class b implements p.a {
        private DesignNativeAd fM;
        private NativeAdObject fP;

        public final void report(String str) {
        }

        public b(DesignNativeAd designNativeAd) {
            this.fP = new NativeAdObject(d.this.aM, d.this.fG);
            this.fM = designNativeAd;
        }

        public final Ad c() {
            return this.fP;
        }

        public final SettingsManager e() {
            return c.aG();
        }

        public final /* bridge */ /* synthetic */ AppnextAd d() {
            return this.fM;
        }
    }
}
