package com.appnext.banners;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.appnext.base.a;
import com.appnext.core.callbacks.OnECPMLoaded;

public abstract class BaseBannerView extends ViewGroup {
    protected BaseBannerAdapter bannerAdapter;
    private BannerListener bannerListener;
    private String language;
    ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
        public final void onScrollChanged() {
            BaseBannerView.this.impression();
            BaseBannerView.this.onScrollChanged();
        }
    };

    /* access modifiers changed from: protected */
    public abstract BaseBannerAdapter getBannerAdapter();

    public BaseBannerView(Context context) {
        super(context);
        if (context != null) {
            parseAttributeSet((AttributeSet) null);
            return;
        }
        throw new IllegalArgumentException("The context cannot be null.");
    }

    public BaseBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributeSet(attributeSet);
    }

    public BaseBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        parseAttributeSet(attributeSet);
    }

    public BaseBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        parseAttributeSet(attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092 A[Catch:{ all -> 0x00c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseAttributeSet(android.util.AttributeSet r7) {
        /*
            r6 = this;
            boolean r0 = r6.isInEditMode()     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.appnext.banners.BaseBannerAdapter r0 = r6.getBannerAdapter()     // Catch:{ all -> 0x00c9 }
            r0.init(r6)     // Catch:{ all -> 0x00c9 }
            com.appnext.banners.d r0 = com.appnext.banners.d.K()     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = "tid"
            java.lang.String r2 = "301"
            r0.h(r1, r2)     // Catch:{ all -> 0x00c9 }
            android.view.ViewTreeObserver r0 = r6.getViewTreeObserver()     // Catch:{ all -> 0x00c9 }
            android.view.ViewTreeObserver$OnScrollChangedListener r1 = r6.onScrollChangedListener     // Catch:{ all -> 0x00c9 }
            r0.addOnScrollChangedListener(r1)     // Catch:{ all -> 0x00c9 }
            if (r7 != 0) goto L_0x0025
            return
        L_0x0025:
            android.content.res.Resources r0 = r6.getResources()     // Catch:{ all -> 0x00c9 }
            int[] r1 = com.appnext.banners.R.styleable.BannersAttrs     // Catch:{ all -> 0x00c9 }
            android.content.res.TypedArray r0 = r0.obtainAttributes(r7, r1)     // Catch:{ all -> 0x00c9 }
            int r1 = com.appnext.banners.R.styleable.BannersAttrs_bannerSize     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x0097
            int r2 = r1.hashCode()     // Catch:{ all -> 0x00c9 }
            r3 = -1966536496(0xffffffff8ac908d0, float:-1.9358911E-32)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x0061
            r3 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
            if (r2 == r3) goto L_0x0057
            r3 = 1951953708(0x7458732c, float:6.859571E31)
            if (r2 == r3) goto L_0x004d
            goto L_0x006b
        L_0x004d:
            java.lang.String r2 = "BANNER"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x00c9 }
            if (r2 == 0) goto L_0x006b
            r2 = 0
            goto L_0x006c
        L_0x0057:
            java.lang.String r2 = "MEDIUM_RECTANGLE"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x00c9 }
            if (r2 == 0) goto L_0x006b
            r2 = 2
            goto L_0x006c
        L_0x0061:
            java.lang.String r2 = "LARGE_BANNER"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x00c9 }
            if (r2 == 0) goto L_0x006b
            r2 = 1
            goto L_0x006c
        L_0x006b:
            r2 = -1
        L_0x006c:
            if (r2 == 0) goto L_0x0092
            if (r2 == r5) goto L_0x008c
            if (r2 != r4) goto L_0x0078
            com.appnext.banners.BannerSize r1 = com.appnext.banners.BannerSize.MEDIUM_RECTANGLE     // Catch:{ all -> 0x00c9 }
            r6.setBannerSize(r1)     // Catch:{ all -> 0x00c9 }
            goto L_0x0097
        L_0x0078:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = "Wrong banner size "
            r0.<init>(r2)     // Catch:{ all -> 0x00c9 }
            r0.append(r1)     // Catch:{ all -> 0x00c9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c9 }
            r7.<init>(r0)     // Catch:{ all -> 0x00c9 }
            throw r7     // Catch:{ all -> 0x00c9 }
        L_0x008c:
            com.appnext.banners.BannerSize r1 = com.appnext.banners.BannerSize.LARGE_BANNER     // Catch:{ all -> 0x00c9 }
            r6.setBannerSize(r1)     // Catch:{ all -> 0x00c9 }
            goto L_0x0097
        L_0x0092:
            com.appnext.banners.BannerSize r1 = com.appnext.banners.BannerSize.BANNER     // Catch:{ all -> 0x00c9 }
            r6.setBannerSize(r1)     // Catch:{ all -> 0x00c9 }
        L_0x0097:
            int r1 = com.appnext.banners.R.styleable.BannersAttrs_placementId     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00a2
            r6.setPlacementId(r1)     // Catch:{ all -> 0x00c9 }
        L_0x00a2:
            r0.recycle()     // Catch:{ all -> 0x00c9 }
            com.appnext.banners.d r0 = com.appnext.banners.d.K()     // Catch:{ all -> 0x00c9 }
            android.content.Context r1 = r6.getContext()     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = r6.getPlacementId()     // Catch:{ all -> 0x00c9 }
            r3 = 0
            r0.a(r1, r2, r3)     // Catch:{ all -> 0x00c9 }
            com.appnext.banners.BaseBannerAdapter r0 = r6.getBannerAdapter()     // Catch:{ all -> 0x00c9 }
            com.appnext.banners.BaseBannerView$2 r1 = new com.appnext.banners.BaseBannerView$2     // Catch:{ all -> 0x00c9 }
            r1.<init>()     // Catch:{ all -> 0x00c9 }
            r0.setBannerListener(r1)     // Catch:{ all -> 0x00c9 }
            com.appnext.banners.BaseBannerAdapter r0 = r6.getBannerAdapter()     // Catch:{ all -> 0x00c9 }
            r0.parseAttributeSet(r7)     // Catch:{ all -> 0x00c9 }
            return
        L_0x00c9:
            r7 = move-exception
            java.lang.String r0 = "BaseBannerView$parseAttributeSet"
            com.appnext.base.a.a(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.BaseBannerView.parseAttributeSet(android.util.AttributeSet):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = ((i3 - i) - measuredWidth) / 2;
                int i6 = ((i4 - i2) - measuredHeight) / 2;
                childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
            }
        } catch (Throwable th) {
            a.a("BaseBannerView$onLayout", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        try {
            View childAt = getChildAt(0);
            if (childAt != null) {
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i, i2);
                    i4 = childAt.getMeasuredWidth();
                    i3 = childAt.getMeasuredHeight();
                    setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
                }
            }
            if (getBannerAdapter().getBannerSize() != null) {
                Context context = getContext();
                int L = (int) (((float) getBannerAdapter().getBannerSize().L()) * context.getResources().getDisplayMetrics().scaledDensity);
                i3 = (int) (((float) getBannerAdapter().getBannerSize().M()) * context.getResources().getDisplayMetrics().scaledDensity);
                i4 = L;
            } else {
                i3 = 0;
            }
            setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
        } catch (Throwable th) {
            a.a("BaseBannerView$onMeasure", th);
        }
    }

    public void setPlacementId(String str) {
        try {
            getBannerAdapter().setPlacementId(str);
        } catch (Throwable th) {
            a.a("BaseBannerView$setPlacementId", th);
        }
    }

    public void setBannerSize(BannerSize bannerSize) {
        try {
            getBannerAdapter().setBannerSize(bannerSize);
        } catch (Throwable th) {
            a.a("BaseBannerView$setBannerSize", th);
        }
    }

    public void setBannerListener(BannerListener bannerListener2) {
        try {
            getBannerAdapter().setBannerListener(bannerListener2);
        } catch (Throwable th) {
            a.a("BaseBannerView$setBannerListener", th);
        }
    }

    public void loadAd(BannerAdRequest bannerAdRequest) {
        getBannerAdapter().loadAd(bannerAdRequest);
    }

    /* access modifiers changed from: protected */
    public void getECPM(BannerAdRequest bannerAdRequest, OnECPMLoaded onECPMLoaded) {
        try {
            getBannerAdapter().getECPM(bannerAdRequest, onECPMLoaded);
        } catch (Throwable th) {
            a.a("BaseBannerView$getECPM", th);
        }
    }

    /* access modifiers changed from: private */
    public void impression() {
        try {
            getBannerAdapter().impression();
        } catch (Throwable th) {
            a.a("BaseBannerView$impression", th);
        }
    }

    /* access modifiers changed from: private */
    public void onScrollChanged() {
        try {
            getBannerAdapter().onScrollChanged(getVisiblePercent(this));
        } catch (Throwable th) {
            a.a("BaseBannerView$onScrollChanged", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        try {
            getBannerAdapter().onWindowVisibilityChanged(i);
        } catch (Throwable th) {
            a.a("BaseBannerView$onWindowVisibilityChanged", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            impression();
        } catch (Throwable th) {
            a.a("BaseBannerView$onDraw", th);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        impression();
    }

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (getParent() == null) {
                return false;
            }
            Rect rect = new Rect();
            ((ViewGroup) getParent()).getHitRect(rect);
            return view.getLocalVisibleRect(rect);
        } catch (Throwable th) {
            a.a("BaseBannerView$isViewPartiallyVisible", th);
            return false;
        }
    }

    public int getVisiblePercent(View view) {
        try {
            if (isViewPartiallyVisible(this) && getWindowVisibility() != 8) {
                if (getWindowVisibility() != 4) {
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    double width = (double) (rect.width() * rect.height());
                    double width2 = (double) (view.getWidth() * view.getHeight());
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    return (int) ((width * 100.0d) / width2);
                }
            }
            return 0;
        } catch (Throwable th) {
            a.a("BaseBannerView$getVisiblePercent", th);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public String getPlacementId() {
        return getBannerAdapter().getPlacementId();
    }

    /* access modifiers changed from: package-private */
    public BannerListener getBannerListener() {
        return this.bannerListener;
    }

    public void destroy() {
        getBannerAdapter().destroy();
        this.bannerAdapter = null;
        try {
            getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        } catch (Throwable th) {
            a.a("BaseBannerView$destroy", th);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    private void play() {
        try {
            getBannerAdapter().play();
        } catch (Throwable th) {
            a.a("BaseBannerView$destroy", th);
        }
    }

    private void pause() {
        try {
            getBannerAdapter().pause();
        } catch (Throwable th) {
            a.a("BaseBannerView$pause", th);
        }
    }

    public boolean isClickEnabled() {
        try {
            return getBannerAdapter().isClickEnabled();
        } catch (Throwable th) {
            a.a("BaseBannerView$isClickEnabled", th);
            return false;
        }
    }

    public void setClickEnabled(boolean z) {
        try {
            getBannerAdapter().setClickEnabled(z);
        } catch (Throwable th) {
            a.a("BaseBannerView$setClickEnabled", th);
        }
    }

    public void setParams(String str, String str2) {
        try {
            d.K().i(str, str2);
        } catch (Throwable th) {
            a.a("BaseBannerView$setParams", th);
        }
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        try {
            this.language = str;
            this.bannerAdapter.setLanguage(str);
        } catch (Throwable th) {
            a.a("BaseBannerView$setLanguage", th);
        }
    }
}
