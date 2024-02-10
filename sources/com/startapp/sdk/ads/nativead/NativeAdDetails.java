package com.startapp.sdk.ads.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.startapp.b1;
import com.startapp.b6;
import com.startapp.d2;
import com.startapp.k7;
import com.startapp.p0;
import com.startapp.sa;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.t5;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class NativeAdDetails implements NativeAdInterface {
    public final AdDetails a;
    public Bitmap b;
    public Bitmap c;
    public boolean d = false;
    public boolean e = false;
    public String f;
    public sa g;
    public WeakReference<View> h = new WeakReference<>((Object) null);
    public View.OnAttachStateChangeListener i;
    public NativeAdDisplayListener j;
    public b6 k;
    public final k7.a l = new a();

    /* compiled from: Sta */
    public class a implements k7.a {
        public a() {
        }

        public void onSent(String str) {
            NativeAdDetails nativeAdDetails = NativeAdDetails.this;
            boolean z = true;
            nativeAdDetails.d = true;
            if (nativeAdDetails.j == null) {
                z = false;
            }
            d2.a("onShow", z, str, (String) null);
            NativeAdDisplayListener nativeAdDisplayListener = nativeAdDetails.j;
            if (nativeAdDisplayListener != null) {
                nativeAdDisplayListener.adDisplayed(nativeAdDetails);
            }
        }
    }

    /* compiled from: Sta */
    public class b implements b1.b {
        public int a;
        public final /* synthetic */ Runnable b;

        public b(Runnable runnable) {
            this.b = runnable;
        }

        public void a(Bitmap bitmap, int i) {
            if (i == 0) {
                NativeAdDetails.this.b = bitmap;
            } else {
                NativeAdDetails.this.c = bitmap;
            }
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 == 2) {
                this.b.run();
            }
        }
    }

    /* compiled from: Sta */
    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            NativeAdDetails.a(NativeAdDetails.this, view);
        }
    }

    /* compiled from: Sta */
    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NativeAdDetails.a(NativeAdDetails.this, view);
        }
    }

    /* compiled from: Sta */
    public class e implements sa.a {
        public e() {
        }
    }

    /* compiled from: Sta */
    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.startapp.sdk.ads.nativead.StartAppNativeAd$CampaignAction[] r0 = com.startapp.sdk.ads.nativead.StartAppNativeAd.CampaignAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.startapp.sdk.ads.nativead.StartAppNativeAd$CampaignAction r1 = com.startapp.sdk.ads.nativead.StartAppNativeAd.CampaignAction.OPEN_MARKET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.startapp.sdk.ads.nativead.StartAppNativeAd$CampaignAction r1 = com.startapp.sdk.ads.nativead.StartAppNativeAd.CampaignAction.LAUNCH_APP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.nativead.NativeAdDetails.f.<clinit>():void");
        }
    }

    public NativeAdDetails(AdDetails adDetails) {
        this.a = adDetails;
    }

    public static void a(NativeAdDetails nativeAdDetails, View view) {
        nativeAdDetails.getClass();
        Context context = view.getContext();
        int i2 = f.a[nativeAdDetails.getCampaignAction().ordinal()];
        if (i2 == 1) {
            boolean a2 = com.startapp.sdk.adsbase.a.a(context, AdPreferences.Placement.INAPP_NATIVE);
            if (!nativeAdDetails.a.A() || a2) {
                com.startapp.sdk.adsbase.a.a(context, nativeAdDetails.a.g(), nativeAdDetails.a.u(), new TrackingParams(nativeAdDetails.f), nativeAdDetails.a.B() && !a2, false);
            } else {
                com.startapp.sdk.adsbase.a.a(context, nativeAdDetails.a.g(), nativeAdDetails.a.u(), nativeAdDetails.a.p(), new TrackingParams(nativeAdDetails.f), AdsCommonMetaData.h.z(), AdsCommonMetaData.h.y(), nativeAdDetails.a.B(), nativeAdDetails.a.C(), false, (Runnable) null);
            }
        } else if (i2 == 2) {
            com.startapp.sdk.adsbase.a.a(nativeAdDetails.getPackageName(), nativeAdDetails.a.l(), nativeAdDetails.a.g(), context, new TrackingParams(nativeAdDetails.f));
        }
        NativeAdDisplayListener nativeAdDisplayListener = nativeAdDetails.j;
        if (nativeAdDisplayListener != null) {
            nativeAdDisplayListener.adClicked(nativeAdDetails);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        unregisterView();
    }

    public String getCallToAction() {
        String e2;
        AdDetails adDetails = this.a;
        if (adDetails == null || (e2 = adDetails.e()) == null) {
            return "";
        }
        return e2;
    }

    public StartAppNativeAd.CampaignAction getCampaignAction() {
        StartAppNativeAd.CampaignAction campaignAction = StartAppNativeAd.CampaignAction.OPEN_MARKET;
        AdDetails adDetails = this.a;
        return (adDetails == null || !adDetails.z()) ? campaignAction : StartAppNativeAd.CampaignAction.LAUNCH_APP;
    }

    public String getCategory() {
        String f2;
        AdDetails adDetails = this.a;
        if (adDetails == null || (f2 = adDetails.f()) == null) {
            return "";
        }
        return f2;
    }

    public String getDescription() {
        String i2;
        AdDetails adDetails = this.a;
        if (adDetails == null || (i2 = adDetails.i()) == null) {
            return "";
        }
        return i2;
    }

    public Bitmap getImageBitmap() {
        return this.b;
    }

    public String getImageUrl() {
        AdDetails adDetails = this.a;
        if (adDetails != null) {
            return adDetails.j();
        }
        return null;
    }

    public String getInstalls() {
        String k2;
        AdDetails adDetails = this.a;
        if (adDetails == null || (k2 = adDetails.k()) == null) {
            return "";
        }
        return k2;
    }

    public String getPackageName() {
        String p;
        AdDetails adDetails = this.a;
        if (adDetails == null || (p = adDetails.p()) == null) {
            return "";
        }
        return p;
    }

    public float getRating() {
        AdDetails adDetails = this.a;
        if (adDetails != null) {
            return adDetails.q();
        }
        return 5.0f;
    }

    public Bitmap getSecondaryImageBitmap() {
        return this.c;
    }

    public String getSecondaryImageUrl() {
        AdDetails adDetails = this.a;
        if (adDetails != null) {
            return adDetails.r();
        }
        return null;
    }

    public String getTitle() {
        String t;
        AdDetails adDetails = this.a;
        if (adDetails == null || (t = adDetails.t()) == null) {
            return "";
        }
        return t;
    }

    public boolean isApp() {
        AdDetails adDetails = this.a;
        if (adDetails != null) {
            return adDetails.y();
        }
        return true;
    }

    public boolean isBelowMinCPM() {
        AdDetails adDetails = this.a;
        return adDetails != null && adDetails.n();
    }

    public void loadImages(Context context, Runnable runnable) {
        b bVar = new b(runnable);
        new b1(context, getImageUrl(), bVar, 0).a();
        new b1(context, getSecondaryImageUrl(), bVar, 1).a();
    }

    public void registerViewForInteraction(View view) {
        a(view);
        ((View) this.h.get()).setOnClickListener(new c());
    }

    public String toString() {
        String description = getDescription();
        if (description != null) {
            description = description.substring(0, Math.min(30, description.length()));
        }
        StringBuilder a2 = p0.a("         Title: [");
        a2.append(getTitle());
        a2.append("]\n         Description: [");
        a2.append(description);
        a2.append("]...\n         Rating: [");
        a2.append(getRating());
        a2.append("]\n         Installs: [");
        a2.append(getInstalls());
        a2.append("]\n         Category: [");
        a2.append(getCategory());
        a2.append("]\n         PackageName: [");
        a2.append(getPackageName());
        a2.append("]\n         CampaginAction: [");
        a2.append(getCampaignAction());
        a2.append("]\n");
        return a2.toString();
    }

    public void unregisterView() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        sa saVar = this.g;
        if (saVar != null) {
            saVar.a();
            this.g = null;
        }
        View view = (View) this.h.get();
        this.h.clear();
        if (view != null && (onAttachStateChangeListener = this.i) != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public void registerViewForInteraction(View view, List<View> list) {
        registerViewForInteraction(view, list, (NativeAdDisplayListener) null);
    }

    public void registerViewForInteraction(View view, List<View> list, NativeAdDisplayListener nativeAdDisplayListener) {
        if (list == null || list.isEmpty() || this.h.get() != null) {
            registerViewForInteraction(view);
        } else {
            d dVar = new d();
            for (View onClickListener : list) {
                onClickListener.setOnClickListener(dVar);
            }
            a(view);
        }
        this.j = nativeAdDisplayListener;
    }

    public final void a(View view) {
        this.h = new WeakReference<>(view);
        if (!view.hasWindowFocus()) {
            if (this.i == null) {
                this.i = new t5(this);
            }
            view.addOnAttachStateChangeListener(this.i);
            return;
        }
        a();
    }

    public final void a() {
        long j2;
        if (this.g == null && !this.d) {
            View view = (View) this.h.get();
            if (view == null) {
                NativeAdDisplayListener nativeAdDisplayListener = this.j;
                if (nativeAdDisplayListener != null) {
                    nativeAdDisplayListener.adNotDisplayed(this);
                    return;
                }
                return;
            }
            Context context = view.getContext();
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_NATIVE;
            AdDetails adDetails = this.a;
            String[] w = adDetails != null ? adDetails.w() : null;
            TrackingParams trackingParams = new TrackingParams(this.f, true);
            if (this.a.h() != null) {
                j2 = TimeUnit.SECONDS.toMillis(this.a.h().longValue());
            } else {
                j2 = TimeUnit.SECONDS.toMillis(MetaData.k.s());
            }
            k7 k7Var = new k7(context, placement, w, trackingParams, j2);
            Context context2 = view.getContext();
            AdDetails adDetails2 = this.a;
            k7 k7Var2 = new k7(context2, placement, adDetails2 != null ? adDetails2.w() : null, new TrackingParams(this.f), 0);
            k7Var.a(this.l);
            BannerOptions a2 = BannerMetaData.b.a();
            k7Var2.c();
            sa saVar = new sa(this.h, k7Var, a2);
            this.g = saVar;
            saVar.c = new e();
            if (saVar.b()) {
                saVar.run();
            }
        }
    }
}
