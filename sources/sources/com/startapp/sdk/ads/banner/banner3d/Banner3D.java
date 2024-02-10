package com.startapp.sdk.ads.banner.banner3d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.startapp.a0;
import com.startapp.f9;
import com.startapp.i3;
import com.startapp.j0;
import com.startapp.k7;
import com.startapp.m0;
import com.startapp.o0;
import com.startapp.sdk.ads.banner.BannerBase;
import com.startapp.sdk.ads.banner.BannerInterface;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.a;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: Sta */
public class Banner3D extends BannerBase implements AdEventListener, BannerInterface {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public AdInformationOverrides L;
    public List<j0> M;
    public int N;
    public BannerListener O;
    public Runnable P;
    public BannerOptions q;
    public Banner3DAd r;
    public List<AdDetails> s;
    public Camera t;
    public Matrix u;
    public Paint v;
    public float w;
    public float x;
    public boolean y;
    public boolean z;

    /* compiled from: Sta */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public AdRulesResult adRulesResult;
        public boolean bDefaultLoad;
        public boolean bIsVisible;
        private int currentImage;
        private AdDetails[] details;
        public j0[] faces;
        private int firstRotation;
        private int firstRotationFinished;
        public boolean loaded;
        public boolean loading;
        public BannerOptions options;
        public AdInformationOverrides overrides;
        private float rotation;

        public int describeContents() {
            return 0;
        }

        public int getCurrentImage() {
            return this.currentImage;
        }

        public List<AdDetails> getDetails() {
            return Arrays.asList(this.details);
        }

        public float getRotation() {
            return this.rotation;
        }

        public boolean isFirstRotation() {
            return this.firstRotation == 1;
        }

        public boolean isFirstRotationFinished() {
            return this.firstRotationFinished == 1;
        }

        public void setCurrentImage(int i) {
            this.currentImage = i;
        }

        public void setDetails(List<AdDetails> list) {
            this.details = new AdDetails[list.size()];
            for (int i = 0; i < list.size(); i++) {
                this.details[i] = list.get(i);
            }
        }

        public void setFirstRotation(boolean z) {
            this.firstRotation = z ? 1 : 0;
        }

        public void setFirstRotationFinished(boolean z) {
            this.firstRotationFinished = z ? 1 : 0;
        }

        public void setRotation(float f) {
            this.rotation = f;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (!this.bIsVisible) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(this.currentImage);
            parcel.writeFloat(this.rotation);
            parcel.writeInt(this.firstRotation);
            parcel.writeInt(this.firstRotationFinished);
            parcel.writeParcelableArray(this.details, i);
            parcel.writeInt(this.loaded ? 1 : 0);
            parcel.writeInt(this.loading ? 1 : 0);
            parcel.writeInt(this.bDefaultLoad ? 1 : 0);
            j0[] j0VarArr = this.faces;
            if (j0VarArr == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(j0VarArr.length);
                for (j0 writeParcelable : this.faces) {
                    parcel.writeParcelable(writeParcelable, i);
                }
            }
            parcel.writeSerializable(this.overrides);
            parcel.writeSerializable(this.options);
            parcel.writeSerializable(this.adRulesResult);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            if (parcel.readInt() == 1) {
                this.bIsVisible = true;
                this.currentImage = parcel.readInt();
                this.rotation = parcel.readFloat();
                this.firstRotation = parcel.readInt();
                this.firstRotationFinished = parcel.readInt();
                Parcelable[] readParcelableArray = parcel.readParcelableArray(AdDetails.class.getClassLoader());
                if (readParcelableArray != null) {
                    AdDetails[] adDetailsArr = new AdDetails[readParcelableArray.length];
                    this.details = adDetailsArr;
                    System.arraycopy(readParcelableArray, 0, adDetailsArr, 0, readParcelableArray.length);
                }
                int readInt = parcel.readInt();
                this.loaded = false;
                if (readInt == 1) {
                    this.loaded = true;
                }
                int readInt2 = parcel.readInt();
                this.loading = false;
                if (readInt2 == 1) {
                    this.loading = true;
                }
                int readInt3 = parcel.readInt();
                this.bDefaultLoad = false;
                if (readInt3 == 1) {
                    this.bDefaultLoad = true;
                }
                int readInt4 = parcel.readInt();
                if (readInt4 > 0) {
                    this.faces = new j0[readInt4];
                    for (int i = 0; i < readInt4; i++) {
                        this.faces[i] = (j0) parcel.readParcelable(j0.class.getClassLoader());
                    }
                }
                this.overrides = (AdInformationOverrides) parcel.readSerializable();
                this.options = (BannerOptions) parcel.readSerializable();
                this.adRulesResult = (AdRulesResult) parcel.readSerializable();
                return;
            }
            this.bIsVisible = false;
        }
    }

    public Banner3D(Activity activity) {
        this((Context) activity);
    }

    public void a(List<AdDetails> list, boolean z2) {
        Banner3DAd banner3DAd;
        this.s = list;
        String str = null;
        if (list != null) {
            o0 o0Var = new o0();
            StringBuilder sb = new StringBuilder();
            for (AdDetails g : list) {
                sb.append(a.a(g.g(), (String) null));
                sb.append(",");
            }
            if (Banner3DSize.a(getContext(), getParent(), this.q, this, o0Var)) {
                setMinimumWidth(f9.a(getContext(), this.q.o()));
                setMinimumHeight(f9.a(getContext(), this.q.d()));
                if (getLayoutParams() != null && getLayoutParams().width == -1) {
                    setMinimumWidth(f9.a(getContext(), o0Var.a.x));
                }
                if (getLayoutParams() != null && getLayoutParams().height == -1) {
                    setMinimumHeight(f9.a(getContext(), o0Var.a.y));
                }
                if (getLayoutParams() != null) {
                    if (getLayoutParams().width > 0) {
                        setMinimumWidth(getLayoutParams().width);
                    }
                    if (getLayoutParams().height > 0) {
                        setMinimumHeight(getLayoutParams().height);
                    }
                    if (getLayoutParams().width > 0 && getLayoutParams().height > 0 && (banner3DAd = this.r) != null) {
                        banner3DAd.b(true);
                    }
                }
                List<j0> list2 = this.M;
                if (list2 == null || list2.size() == 0) {
                    o();
                    removeAllViews();
                    this.M = new ArrayList();
                    for (AdDetails j0Var : list) {
                        this.M.add(new j0(getContext(), this, j0Var, this.q, new TrackingParams(getAdPreferences().getAdTag())));
                    }
                    this.N = 0;
                } else {
                    for (j0 a : this.M) {
                        a.a(getContext(), this.q, this);
                    }
                }
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s(), p());
                layoutParams.addRule(13);
                int q2 = q();
                layoutParams.rightMargin = q2;
                layoutParams.leftMargin = q2;
                int r2 = r();
                layoutParams.topMargin = r2;
                layoutParams.bottomMargin = r2;
                addView(relativeLayout, layoutParams);
                Context context = getContext();
                AdInformationObject.Size size = AdInformationObject.Size.SMALL;
                AdPreferences.Placement placement = AdPreferences.Placement.INAPP_BANNER;
                AdInformationOverrides adInformationOverrides = this.L;
                Banner3DAd banner3DAd2 = this.r;
                String requestUrl = banner3DAd2 != null ? banner3DAd2.getRequestUrl() : null;
                Banner3DAd banner3DAd3 = this.r;
                if (banner3DAd3 != null) {
                    str = banner3DAd3.getDParam();
                }
                new AdInformationObject(context, size, placement, adInformationOverrides, (ConsentData) null, requestUrl, str).a(relativeLayout);
                if (this.v == null) {
                    Paint paint = new Paint();
                    this.v = paint;
                    paint.setAntiAlias(true);
                    this.v.setFilterBitmap(true);
                }
                if (!this.E) {
                    this.E = true;
                    v();
                }
                if (this.F) {
                    u();
                }
                if (z2) {
                    m0.c(getContext(), this.O, this, sb.toString());
                    return;
                }
                return;
            }
            setErrorMessage("Error in banner screen size");
            setVisibility(8);
            if (z2) {
                m0.b(getContext(), this.O, this, sb.toString());
                return;
            }
            return;
        }
        setErrorMessage("No ads to load");
        if (z2) {
            m0.b(getContext(), this.O, this, (String) null);
        }
    }

    public int d() {
        return this.h;
    }

    public String e() {
        return "StartApp Banner3D";
    }

    public int f() {
        return BannerMetaData.b.a().j();
    }

    public String getBidToken() {
        Banner3DAd banner3DAd = this.r;
        if (banner3DAd != null) {
            return banner3DAd.getBidToken();
        }
        return null;
    }

    public int getHeightInDp() {
        return 50;
    }

    public int getWidthInDp() {
        return 300;
    }

    public void hideBanner() {
        this.F = false;
        setVisibility(8);
    }

    public void i() {
        if (!this.I) {
            this.q = BannerMetaData.b.b();
            this.s = new ArrayList();
            this.L = AdInformationOverrides.a();
            o();
            this.M = new ArrayList();
            this.I = true;
            setBackgroundColor(0);
            if (getId() == -1) {
                setId(this.h);
            }
            if (this.G) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        ViewTreeObserver viewTreeObserver = Banner3D.this.getViewTreeObserver();
                        int i = a0.a;
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                        Banner3D banner3D = Banner3D.this;
                        if (!banner3D.H) {
                            banner3D.k();
                        }
                    }
                });
            }
        }
    }

    public void m() {
        int i = 0;
        this.H = false;
        this.I = true;
        this.E = false;
        this.y = true;
        this.A = true;
        this.B = false;
        this.C = false;
        this.g = false;
        this.c = null;
        o();
        this.M = new ArrayList();
        Context context = getContext();
        Banner3DAd banner3DAd = this.r;
        if (banner3DAd != null) {
            i = banner3DAd.h();
        }
        Banner3DAd banner3DAd2 = new Banner3DAd(context, i);
        this.r = banner3DAd2;
        banner3DAd2.load(l(), this);
    }

    public final void o() {
        List<j0> list = this.M;
        if (list != null && !list.isEmpty()) {
            for (j0 next : this.M) {
                if (next != null) {
                    Bitmap bitmap = next.c;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    Bitmap bitmap2 = next.d;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    next.c = null;
                    next.d = null;
                    k7 k7Var = next.g;
                    if (k7Var != null) {
                        k7Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
                    }
                    Banner3DView banner3DView = next.h;
                    if (banner3DView != null) {
                        banner3DView.removeAllViews();
                        next.h = null;
                    }
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = true;
        BannerOptions bannerOptions = this.q;
        if (bannerOptions == null || !bannerOptions.v()) {
            this.A = false;
            this.B = true;
        }
        v();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = false;
        removeCallbacks(this.P);
        List<j0> list = this.M;
        if (list != null) {
            for (j0 j0Var : list) {
                k7 k7Var = j0Var.g;
                if (k7Var != null) {
                    k7Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        if (!this.g && !this.I) {
            this.g = true;
            v();
        }
        if (!isInEditMode() && this.F) {
            List<j0> list = this.M;
            if (!(list == null || list.size() == 0)) {
                try {
                    int s2 = s();
                    int p = p();
                    int q2 = q();
                    int r2 = r();
                    float g = !this.B ? this.q.g() : ((1.0f - this.q.g()) * ((float) Math.pow((double) (Math.abs(this.w - 45.0f) / 45.0f), (double) this.q.l()))) + this.q.g();
                    Bitmap bitmap3 = this.M.get((this.M.size() + (this.N - 1)) % this.M.size()).d;
                    Bitmap bitmap4 = this.M.get(this.N).d;
                    if (bitmap4 != null && bitmap3 != null) {
                        float f = this.w;
                        if (f < 45.0f) {
                            if (f > 3.0f) {
                                bitmap2 = bitmap3;
                                a(canvas, bitmap4, r2, q2, s2 / 2, p / 2, g, (f - 90.0f) * ((float) this.q.c().getRotationMultiplier()));
                            } else {
                                bitmap2 = bitmap3;
                            }
                            a(canvas, bitmap2, r2, q2, s2 / 2, p / 2, g, this.w * ((float) this.q.c().getRotationMultiplier()));
                            return;
                        }
                        Bitmap bitmap5 = bitmap3;
                        if (f < 87.0f) {
                            bitmap = bitmap4;
                            a(canvas, bitmap5, r2, q2, s2 / 2, p / 2, g, f * ((float) this.q.c().getRotationMultiplier()));
                        } else {
                            bitmap = bitmap4;
                        }
                        a(canvas, bitmap, r2, q2, s2 / 2, p / 2, g, (this.w - 90.0f) * ((float) this.q.c().getRotationMultiplier()));
                        if (!this.A) {
                            this.B = true;
                        }
                    }
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
        }
    }

    public void onFailedToReceiveAd(Ad ad) {
        if (ad != null) {
            setErrorMessage(ad.getErrorMessage());
        }
        m0.b(getContext(), this.O, this, (String) null);
    }

    public void onReceiveAd(Ad ad) {
        this.H = true;
        this.I = false;
        this.L = this.r.getAdInfoOverride();
        List<AdDetails> g = ((JsonAd) ad).g();
        this.s = g;
        a(g, this.K);
        this.K = false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z2 = savedState.bIsVisible;
        this.F = z2;
        if (z2) {
            this.s = savedState.getDetails();
            this.w = savedState.getRotation();
            this.A = savedState.isFirstRotation();
            this.B = savedState.isFirstRotationFinished();
            this.N = savedState.getCurrentImage();
            j0[] j0VarArr = savedState.faces;
            o();
            this.M = new ArrayList();
            if (j0VarArr != null) {
                for (j0 add : j0VarArr) {
                    this.M.add(add);
                }
            }
            this.H = savedState.loaded;
            this.I = savedState.loading;
            this.G = savedState.bDefaultLoad;
            this.L = savedState.overrides;
            this.q = savedState.options;
            if (this.s.size() == 0) {
                this.G = true;
                h();
                return;
            }
            post(new Runnable() {
                public void run() {
                    Banner3D banner3D = Banner3D.this;
                    banner3D.a(banner3D.s, false);
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.bIsVisible = this.F;
        savedState.setDetails(this.s);
        savedState.setRotation(this.w);
        savedState.setFirstRotation(this.A);
        savedState.setFirstRotationFinished(this.B);
        savedState.setCurrentImage(this.N);
        savedState.options = this.q;
        savedState.faces = new j0[this.M.size()];
        savedState.loaded = this.H;
        savedState.loading = this.I;
        savedState.overrides = this.L;
        for (int i = 0; i < this.M.size(); i++) {
            savedState.faces[i] = this.M.get(i);
        }
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        List<j0> list;
        int s2 = s();
        int p = p();
        int q2 = q();
        int r2 = r();
        if (!(motionEvent.getX() >= ((float) q2) && motionEvent.getY() >= ((float) r2) && motionEvent.getX() <= ((float) (q2 + s2)) && motionEvent.getY() <= ((float) (r2 + p))) || (list = this.M) == null || list.size() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D = true;
            this.x = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2 && this.x - motionEvent.getY() >= 10.0f) {
                this.D = false;
                this.x = motionEvent.getY();
            }
        } else if (this.D) {
            if (this.w < 45.0f) {
                t();
            }
            this.D = false;
            this.y = false;
            setClicked(true);
            postDelayed(new Runnable() {
                public void run() {
                    Banner3D.this.y = true;
                }
            }, AdsCommonMetaData.h.z());
            j0 j0Var = this.M.get(this.N);
            Context context = getContext();
            String m = j0Var.a.m();
            boolean a = a.a(context, AdPreferences.Placement.INAPP_BANNER);
            k7 k7Var = j0Var.g;
            String str = null;
            if (k7Var != null) {
                k7Var.a((String) null, (JSONObject) null);
            }
            if (m != null && !AbstractJsonLexerKt.NULL.equals(m) && !TextUtils.isEmpty(m)) {
                a.a(m, j0Var.a.l(), j0Var.a.g(), context, j0Var.f);
            } else if (!j0Var.a.A() || a) {
                a.a(context, j0Var.a.g(), j0Var.a.u(), j0Var.f, j0Var.a.B() && !a, false);
            } else {
                a.a(context, j0Var.a.g(), j0Var.a.u(), j0Var.a.p(), j0Var.f, AdsCommonMetaData.h.z(), AdsCommonMetaData.h.y(), j0Var.a.B(), j0Var.a.C(), false, (Runnable) null);
            }
            if (this.N < this.s.size()) {
                str = a.a(this.s.get(this.N).g(), (String) null);
            }
            m0.a(getContext(), this.O, this, str);
        }
        return true;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            this.J = true;
            BannerOptions bannerOptions = this.q;
            if (bannerOptions == null || !bannerOptions.v()) {
                this.A = false;
                this.B = true;
            }
            v();
            return;
        }
        this.J = false;
        if (!this.z) {
            removeCallbacks(this.P);
        }
    }

    public final int p() {
        return (int) (this.q.e() * ((float) f9.a(getContext(), this.q.d())));
    }

    public final int q() {
        return (getWidth() - s()) / 2;
    }

    public final int r() {
        return (getHeight() - p()) / 2;
    }

    public final int s() {
        return (int) (this.q.p() * ((float) f9.a(getContext(), this.q.o())));
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.O = bannerListener;
    }

    public void showBanner() {
        this.F = true;
        u();
    }

    public final void t() {
        this.N = ((this.N - 1) + this.M.size()) % this.M.size();
    }

    public final void u() {
        setVisibility(0);
        if (this.r != null) {
            u7 u2 = ComponentLocator.a(getContext()).u();
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_BANNER;
            String adId = this.r.getAdId();
            if (adId != null) {
                u2.a.put(new u7.a(placement, -1), adId);
            }
        }
    }

    public final void v() {
        if (this.J && this.g) {
            removeCallbacks(this.P);
            post(this.P);
        }
    }

    public Banner3D(Activity activity, AdPreferences adPreferences) {
        this((Context) activity, adPreferences);
    }

    public Banner3D(Activity activity, BannerListener bannerListener) {
        this((Context) activity, bannerListener);
    }

    public Banner3D(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context) activity, adPreferences, bannerListener);
    }

    public Banner3D(Activity activity, boolean z2) {
        this((Context) activity, z2);
    }

    public Banner3D(Activity activity, boolean z2, AdPreferences adPreferences) {
        this((Context) activity, z2, adPreferences);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet) {
        this((Context) activity, attributeSet);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet, int i) {
        this((Context) activity, attributeSet, i);
    }

    @Deprecated
    public Banner3D(Context context) {
        this(context, true, (AdPreferences) null);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public Banner3D(Context context, BannerListener bannerListener) {
        this(context, true, (AdPreferences) null);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, boolean z2) {
        this(context, z2, (AdPreferences) null);
    }

    @Deprecated
    public Banner3D(Context context, boolean z2, AdPreferences adPreferences) {
        super(context);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = 45.0f;
        this.x = 0.0f;
        this.y = true;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.M = new ArrayList();
        this.N = 0;
        this.P = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0132  */
            /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r12 = this;
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.H
                    if (r1 == 0) goto L_0x0136
                    java.util.List<com.startapp.j0> r0 = r0.M
                    int r0 = r0.size()
                    if (r0 != 0) goto L_0x0010
                    goto L_0x0136
                L_0x0010:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.F
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L_0x008e
                    boolean r0 = r0.isShown()
                    if (r0 == 0) goto L_0x008e
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.g
                    if (r1 == 0) goto L_0x008e
                    java.util.List<com.startapp.j0> r1 = r0.M
                    int r0 = r0.N
                    java.lang.Object r0 = r1.get(r0)
                    com.startapp.j0 r0 = (com.startapp.j0) r0
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r1 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    android.content.Context r5 = r1.getContext()
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.a
                    java.lang.String[] r4 = r4.w()
                    int r4 = r4.length
                    if (r4 <= 0) goto L_0x007d
                    java.util.concurrent.atomic.AtomicBoolean r4 = r0.e
                    boolean r4 = r4.compareAndSet(r2, r3)
                    if (r4 == 0) goto L_0x007d
                    com.startapp.k7 r11 = new com.startapp.k7
                    com.startapp.sdk.adsbase.model.AdPreferences$Placement r6 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.INAPP_BANNER
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.a
                    java.lang.String[] r7 = r4.w()
                    com.startapp.sdk.adsbase.commontracking.TrackingParams r8 = r0.f
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.a
                    java.lang.Long r4 = r4.h()
                    if (r4 == 0) goto L_0x006a
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.model.AdDetails r9 = r0.a
                    java.lang.Long r9 = r9.h()
                    long r9 = r9.longValue()
                    long r9 = r4.toMillis(r9)
                    goto L_0x0076
                L_0x006a:
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.remoteconfig.MetaData r9 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                    long r9 = r9.s()
                    long r9 = r4.toMillis(r9)
                L_0x0076:
                    r4 = r11
                    r4.<init>(r5, r6, r7, r8, r9)
                    r0.g = r11
                    goto L_0x007e
                L_0x007d:
                    r11 = 0
                L_0x007e:
                    if (r11 == 0) goto L_0x0083
                    r1.a((com.startapp.k7) r11)
                L_0x0083:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.C
                    if (r1 != 0) goto L_0x008e
                    r0.C = r3
                    r0.a()
                L_0x008e:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.y
                    if (r1 == 0) goto L_0x00d9
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.q
                    int r1 = r1.m()
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r4 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r5 = r4.B
                    if (r5 != 0) goto L_0x00a7
                    com.startapp.sdk.ads.banner.BannerOptions r4 = r4.q
                    int r4 = r4.k()
                    goto L_0x00a8
                L_0x00a7:
                    r4 = 1
                L_0x00a8:
                    int r1 = r1 * r4
                    float r1 = (float) r1
                    float r4 = r0.w
                    float r4 = r4 + r1
                    r0.w = r4
                    r1 = 1119092736(0x42b40000, float:90.0)
                    int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                    if (r4 < 0) goto L_0x00c7
                    int r4 = r0.N
                    int r4 = r4 + r3
                    java.util.List<com.startapp.j0> r5 = r0.M
                    int r5 = r5.size()
                    int r4 = r4 % r5
                    r0.N = r4
                    float r4 = r0.w
                    float r4 = r4 - r1
                    r0.w = r4
                L_0x00c7:
                    float r4 = r0.w
                    r5 = 0
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 > 0) goto L_0x00d6
                    r0.t()
                    float r4 = r0.w
                    float r4 = r4 + r1
                    r0.w = r4
                L_0x00d6:
                    r0.invalidate()
                L_0x00d9:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.w
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.q
                    int r0 = r0.m()
                    int r0 = 90 - r0
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0114
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.w
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.q
                    int r0 = r0.m()
                    int r0 = r0 + 90
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0114
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.A
                    if (r1 != 0) goto L_0x0114
                    boolean r1 = r0.J
                    if (r1 == 0) goto L_0x010f
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.q
                    int r1 = r1.b()
                    long r4 = (long) r1
                    r0.postDelayed(r12, r4)
                L_0x010f:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.z = r2
                    goto L_0x0124
                L_0x0114:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.q
                    int r1 = r1.n()
                    long r4 = (long) r1
                    r0.postDelayed(r12, r4)
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.z = r3
                L_0x0124:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    int r1 = r0.N
                    int r1 = r1 + r3
                    java.util.List<com.startapp.j0> r0 = r0.M
                    int r0 = r0.size()
                    int r1 = r1 % r0
                    if (r1 != 0) goto L_0x0136
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.A = r2
                L_0x0136:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.banner.banner3d.Banner3D.AnonymousClass1.run():void");
            }
        };
        try {
            this.G = z2;
            setAdPreferences(adPreferences);
            h();
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public final void a(Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4, float f, float f2) {
        if (this.t == null) {
            this.t = new Camera();
        }
        this.t.save();
        this.t.translate(0.0f, 0.0f, (float) i4);
        this.t.rotateX(f2);
        float f3 = (float) (-i4);
        this.t.translate(0.0f, 0.0f, f3);
        if (this.u == null) {
            this.u = new Matrix();
        }
        this.t.getMatrix(this.u);
        this.t.restore();
        this.u.preTranslate((float) (-i3), f3);
        this.u.postScale(f, f);
        this.u.postTranslate((float) (i2 + i3), (float) (i + i4));
        canvas.drawBitmap(bitmap, this.u, this.v);
    }

    public void a(int i) {
        this.h = i;
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = 45.0f;
        this.x = 0.0f;
        this.y = true;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.M = new ArrayList();
        this.N = 0;
        this.P = new Runnable() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r12 = this;
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.H
                    if (r1 == 0) goto L_0x0136
                    java.util.List<com.startapp.j0> r0 = r0.M
                    int r0 = r0.size()
                    if (r0 != 0) goto L_0x0010
                    goto L_0x0136
                L_0x0010:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.F
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L_0x008e
                    boolean r0 = r0.isShown()
                    if (r0 == 0) goto L_0x008e
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.g
                    if (r1 == 0) goto L_0x008e
                    java.util.List<com.startapp.j0> r1 = r0.M
                    int r0 = r0.N
                    java.lang.Object r0 = r1.get(r0)
                    com.startapp.j0 r0 = (com.startapp.j0) r0
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r1 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    android.content.Context r5 = r1.getContext()
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.a
                    java.lang.String[] r4 = r4.w()
                    int r4 = r4.length
                    if (r4 <= 0) goto L_0x007d
                    java.util.concurrent.atomic.AtomicBoolean r4 = r0.e
                    boolean r4 = r4.compareAndSet(r2, r3)
                    if (r4 == 0) goto L_0x007d
                    com.startapp.k7 r11 = new com.startapp.k7
                    com.startapp.sdk.adsbase.model.AdPreferences$Placement r6 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.INAPP_BANNER
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.a
                    java.lang.String[] r7 = r4.w()
                    com.startapp.sdk.adsbase.commontracking.TrackingParams r8 = r0.f
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.a
                    java.lang.Long r4 = r4.h()
                    if (r4 == 0) goto L_0x006a
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.model.AdDetails r9 = r0.a
                    java.lang.Long r9 = r9.h()
                    long r9 = r9.longValue()
                    long r9 = r4.toMillis(r9)
                    goto L_0x0076
                L_0x006a:
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.remoteconfig.MetaData r9 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
                    long r9 = r9.s()
                    long r9 = r4.toMillis(r9)
                L_0x0076:
                    r4 = r11
                    r4.<init>(r5, r6, r7, r8, r9)
                    r0.g = r11
                    goto L_0x007e
                L_0x007d:
                    r11 = 0
                L_0x007e:
                    if (r11 == 0) goto L_0x0083
                    r1.a((com.startapp.k7) r11)
                L_0x0083:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.C
                    if (r1 != 0) goto L_0x008e
                    r0.C = r3
                    r0.a()
                L_0x008e:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.y
                    if (r1 == 0) goto L_0x00d9
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.q
                    int r1 = r1.m()
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r4 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r5 = r4.B
                    if (r5 != 0) goto L_0x00a7
                    com.startapp.sdk.ads.banner.BannerOptions r4 = r4.q
                    int r4 = r4.k()
                    goto L_0x00a8
                L_0x00a7:
                    r4 = 1
                L_0x00a8:
                    int r1 = r1 * r4
                    float r1 = (float) r1
                    float r4 = r0.w
                    float r4 = r4 + r1
                    r0.w = r4
                    r1 = 1119092736(0x42b40000, float:90.0)
                    int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                    if (r4 < 0) goto L_0x00c7
                    int r4 = r0.N
                    int r4 = r4 + r3
                    java.util.List<com.startapp.j0> r5 = r0.M
                    int r5 = r5.size()
                    int r4 = r4 % r5
                    r0.N = r4
                    float r4 = r0.w
                    float r4 = r4 - r1
                    r0.w = r4
                L_0x00c7:
                    float r4 = r0.w
                    r5 = 0
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 > 0) goto L_0x00d6
                    r0.t()
                    float r4 = r0.w
                    float r4 = r4 + r1
                    r0.w = r4
                L_0x00d6:
                    r0.invalidate()
                L_0x00d9:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.w
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.q
                    int r0 = r0.m()
                    int r0 = 90 - r0
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0114
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.w
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.q
                    int r0 = r0.m()
                    int r0 = r0 + 90
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0114
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.A
                    if (r1 != 0) goto L_0x0114
                    boolean r1 = r0.J
                    if (r1 == 0) goto L_0x010f
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.q
                    int r1 = r1.b()
                    long r4 = (long) r1
                    r0.postDelayed(r12, r4)
                L_0x010f:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.z = r2
                    goto L_0x0124
                L_0x0114:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.q
                    int r1 = r1.n()
                    long r4 = (long) r1
                    r0.postDelayed(r12, r4)
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.z = r3
                L_0x0124:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    int r1 = r0.N
                    int r1 = r1 + r3
                    java.util.List<com.startapp.j0> r0 = r0.M
                    int r0 = r0.size()
                    int r1 = r1 % r0
                    if (r1 != 0) goto L_0x0136
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.A = r2
                L_0x0136:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.banner.banner3d.Banner3D.AnonymousClass1.run():void");
            }
        };
        try {
            h();
        } catch (Throwable th) {
            i3.a(th);
        }
    }
}
