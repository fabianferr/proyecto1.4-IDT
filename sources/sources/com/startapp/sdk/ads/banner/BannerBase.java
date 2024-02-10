package com.startapp.sdk.ads.banner;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.startapp.a0;
import com.startapp.e;
import com.startapp.f;
import com.startapp.f9;
import com.startapp.k7;
import com.startapp.l0;
import com.startapp.sa;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import java.util.Random;

/* compiled from: Sta */
public abstract class BannerBase extends RelativeLayout {
    public boolean a;
    public AdPreferences b;
    public AdRulesResult c;
    public int d;
    public boolean e;
    public Point f;
    public boolean g;
    public int h;
    public int i;
    public sa j;
    public boolean k;
    public boolean l;
    public String m;
    public final Runnable n;
    public final Handler o;
    public final Object p;

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            AdRulesResult adRulesResult;
            if (BannerBase.this.isShown() || ((adRulesResult = BannerBase.this.c) != null && !adRulesResult.b())) {
                BannerBase.this.j();
            }
        }
    }

    /* compiled from: Sta */
    public class b implements Handler.Callback {
        public b() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1 || i == 2) {
                BannerBase bannerBase = BannerBase.this;
                bannerBase.n();
                bannerBase.j();
            }
            return true;
        }
    }

    public BannerBase(Context context) {
        super(context);
        this.a = false;
        this.d = 0;
        this.e = true;
        this.g = false;
        int nextInt = new Random().nextInt(100000) + 159868227;
        this.h = nextInt;
        this.i = nextInt + 1;
        this.k = false;
        this.l = false;
        this.n = new a();
        this.o = new Handler(Looper.getMainLooper(), new b());
        this.p = new Object();
        try {
            ComponentLocator.a(context).t().a(512);
        } catch (Throwable unused) {
        }
    }

    public abstract void a(int i2);

    public void a(k7 k7Var) {
        if (this.j == null) {
            sa saVar = new sa(g(), k7Var, BannerMetaData.b.a());
            this.j = saVar;
            if (saVar.b()) {
                saVar.run();
            }
        }
    }

    public void b() {
        if (!isInEditMode()) {
            removeCallbacks(this.n);
            synchronized (this.p) {
                this.o.removeMessages(2);
            }
        }
    }

    public int c() {
        return f();
    }

    public abstract int d();

    public abstract String e();

    public abstract int f();

    public View g() {
        return this;
    }

    public AdPreferences getAdPreferences() {
        AdPreferences adPreferences = this.b;
        if (adPreferences != null) {
            return adPreferences;
        }
        AdPreferences adPreferences2 = new AdPreferences();
        this.b = adPreferences2;
        return adPreferences2;
    }

    public abstract String getBidToken();

    public String getErrorMessage() {
        return this.m;
    }

    public abstract int getHeightInDp();

    public abstract int getWidthInDp();

    public void h() {
        if (!isInEditMode()) {
            i();
            return;
        }
        setMinimumWidth(f9.a(getContext(), getWidthInDp()));
        setMinimumHeight(f9.a(getContext(), getHeightInDp()));
        setBackgroundColor(Color.rgb(169, 169, 169));
        TextView textView = new TextView(getContext());
        textView.setText(e());
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(textView, layoutParams);
    }

    public abstract void hideBanner();

    public abstract void i();

    public boolean isClicked() {
        return this.k;
    }

    public boolean isFirstLoad() {
        return this.e;
    }

    public void j() {
        sa saVar = this.j;
        if (saVar != null) {
            saVar.a();
            this.j = null;
        }
        if (this.c == null || AdaptMetaData.a.a().a()) {
            AdRulesResult a2 = AdaptMetaData.a.a().a(AdPreferences.Placement.INAPP_BANNER, getAdPreferences().getAdTag());
            this.c = a2;
            if (a2.b()) {
                m();
            } else {
                hideBanner();
            }
        } else if (this.c.b()) {
            m();
        }
    }

    public void k() {
        synchronized (this.p) {
            if (!this.o.hasMessages(1)) {
                this.o.sendEmptyMessage(1);
            }
        }
    }

    public AdPreferences l() {
        AdPreferences adPreferences = getAdPreferences();
        boolean z = false;
        if (adPreferences.getPlacementId() == null) {
            String str = null;
            StringBuilder sb = null;
            String str2 = null;
            for (ViewParent viewParent = this; viewParent instanceof View; viewParent = ((View) viewParent).getParent()) {
                if (str2 == null) {
                    str2 = com.startapp.sdk.adsbase.a.a(((View) viewParent).getContext());
                }
                try {
                    String resourceEntryName = ((View) viewParent).getResources().getResourceEntryName(((View) viewParent).getId());
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        sb.insert(0, "/");
                    }
                    sb.insert(0, resourceEntryName);
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (sb != null) {
                str = sb.toString();
            }
            Pair pair = new Pair(str2, str);
            adPreferences.setPlacementId(com.startapp.sdk.adsbase.a.a(getContext().getPackageName(), getClass().getName(), (String) pair.first, (String) pair.second));
        }
        boolean z2 = this.a;
        int i2 = a0.a;
        if (1 != getLayerType() && z2) {
            z = isHardwareAccelerated();
        }
        adPreferences.setHardwareAccelerated(z);
        return adPreferences;
    }

    public void loadAd(int i2, int i3) {
        if (getParent() == null) {
            try {
                ComponentLocator.a(getContext()).t().a(1024);
            } catch (Throwable unused) {
            }
            this.f = new Point(i2, i3);
            k();
        }
    }

    public abstract void m();

    public void n() {
        if (this.a && !isInEditMode() && CacheMetaData.d()) {
            removeCallbacks(this.n);
            postDelayed(this.n, (long) c());
            long C = (long) (MetaData.k.C() * 1000);
            synchronized (this.p) {
                this.o.removeMessages(2);
                this.o.sendEmptyMessageDelayed(2, C);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            ComponentLocator.a(getContext()).t().a(4096);
        } catch (Throwable unused) {
        }
        this.a = true;
        n();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a = false;
        b();
        sa saVar = this.j;
        if (saVar != null) {
            saVar.a();
            this.j = null;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        a(bundle.getInt("bannerId"));
        this.c = (AdRulesResult) bundle.getSerializable("adRulesResult");
        this.b = (AdPreferences) bundle.getSerializable("adPreferences");
        this.d = bundle.getInt(TypedValues.CycleType.S_WAVE_OFFSET);
        this.e = bundle.getBoolean("firstLoad");
        this.l = bundle.getBoolean("shouldReloadBanner");
        super.onRestoreInstanceState(bundle.getParcelable("upperState"));
    }

    public Parcelable onSaveInstanceState() {
        if (isClicked()) {
            setClicked(false);
            this.l = true;
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt("bannerId", d());
        bundle.putParcelable("upperState", onSaveInstanceState);
        bundle.putSerializable("adRulesResult", this.c);
        bundle.putSerializable("adPreferences", this.b);
        bundle.putInt(TypedValues.CycleType.S_WAVE_OFFSET, this.d);
        bundle.putBoolean("firstLoad", this.e);
        bundle.putBoolean("shouldReloadBanner", this.l);
        return bundle;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.l) {
                this.l = false;
                j();
            }
            this.a = true;
            n();
            return;
        }
        this.a = false;
        b();
    }

    public void setAdPreferences(AdPreferences adPreferences) {
        this.b = adPreferences != null ? new AdPreferences(adPreferences) : null;
    }

    public void setAdTag(String str) {
        getAdPreferences().setAdTag(str);
    }

    public void setClicked(boolean z) {
        this.k = z;
    }

    public void setErrorMessage(String str) {
        this.m = str;
    }

    public void setFirstLoad(boolean z) {
        this.e = z;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setAdTag(new l0(context, attributeSet).b);
    }

    public void a() {
        if (isFirstLoad() || AdaptMetaData.a.a().a()) {
            setFirstLoad(false);
            f.d.a(new e(AdPreferences.Placement.INAPP_BANNER, getAdPreferences().getAdTag()));
        }
    }

    public void loadAd() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        loadAd(f9.b(getContext(), displayMetrics.widthPixels), f9.b(getContext(), displayMetrics.heightPixels));
    }

    public BannerBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = false;
        this.d = 0;
        this.e = true;
        this.g = false;
        int nextInt = new Random().nextInt(100000) + 159868227;
        this.h = nextInt;
        this.i = nextInt + 1;
        this.k = false;
        this.l = false;
        this.n = new a();
        this.o = new Handler(Looper.getMainLooper(), new b());
        this.p = new Object();
        a(context, attributeSet);
    }
}
