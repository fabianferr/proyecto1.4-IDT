package com.appnext.nativeads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.appnext.base.Appnext;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.appnext.core.i;

public class NativeAdView extends FrameLayout {
    private a adViewActions;
    /* access modifiers changed from: private */
    public NativeAd eU;
    /* access modifiers changed from: private */
    public NativeAdData eW;
    private PrivacyIcon fm;
    private ViewTreeObserver.OnScrollChangedListener fn;

    interface a {
        void d(int i);
    }

    public NativeAdView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fn = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                NativeAdView nativeAdView = NativeAdView.this;
                nativeAdView.e(nativeAdView.getVisiblePercent(nativeAdView));
            }
        };
        Appnext.init(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.fn = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                NativeAdView nativeAdView = NativeAdView.this;
                nativeAdView.e(nativeAdView.getVisiblePercent(nativeAdView));
            }
        };
        Appnext.init(context);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.fm);
    }

    public void removeView(View view) {
        if (view != this.fm) {
            super.removeView(view);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.fm);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        PrivacyIcon privacyIcon = this.fm;
        if (privacyIcon != view) {
            super.bringChildToFront(privacyIcon);
        }
    }

    public void setVisibility(int i) {
        if (this.eU != null && this.eW != null) {
            super.setVisibility(i);
            e(getVisiblePercent(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        try {
            NativeAd nativeAd = this.eU;
            if (nativeAd != null && this.eW != null) {
                nativeAd.onWindowVisibilityChanged(i);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAdView$onWindowVisibilityChanged", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bringToFront();
        getViewTreeObserver().addOnScrollChangedListener(this.fn);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getViewTreeObserver().removeOnScrollChangedListener(this.fn);
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAdView$onWindowVisibilityChanged", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(NativeAd nativeAd, NativeAdData nativeAdData, a aVar) {
        int i;
        int i2;
        int i3;
        this.eU = nativeAd;
        this.eW = nativeAdData;
        this.adViewActions = aVar;
        if (nativeAd != null && nativeAdData != null) {
            int i4 = 0;
            try {
                setVisibility(0);
                PrivacyIcon privacyIcon = this.fm;
                if (privacyIcon != null) {
                    super.removeView(privacyIcon);
                }
                if (this.eU.getPrivacyPolicyVisibility() == 0) {
                    this.fm = new PrivacyIcon(getContext());
                    int a2 = g.a(getContext(), 25.0f);
                    int privacyPolicyPosition = this.eU.getPrivacyPolicyPosition();
                    if (privacyPolicyPosition == 0) {
                        i = a2;
                        i3 = i;
                        a2 = 0;
                        i2 = 51;
                    } else if (privacyPolicyPosition == 1) {
                        i4 = a2;
                        i3 = i4;
                        a2 = 0;
                        i = 0;
                        i2 = 53;
                    } else if (privacyPolicyPosition == 2) {
                        i = a2;
                        i3 = 0;
                        i2 = 83;
                    } else if (privacyPolicyPosition != 3) {
                        i4 = a2;
                        i = i4;
                        i3 = i;
                        i2 = 3;
                    } else {
                        i4 = a2;
                        i = 0;
                        i3 = 0;
                        i2 = 85;
                    }
                    addView(this.fm, new FrameLayout.LayoutParams(-2, -2, i2));
                    this.fm.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            try {
                                if (NativeAdView.this.eU != null) {
                                    try {
                                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(g.e((AppnextAd) NativeAdView.this.eW)));
                                        intent.setFlags(268435456);
                                        NativeAdView.this.getContext().startActivity(intent);
                                    } catch (Throwable unused) {
                                    }
                                }
                            } catch (Throwable th) {
                                com.appnext.base.a.a("NativeAdView$init", th);
                            }
                        }
                    });
                    if (i.a((AppnextAd) this.eW, (SettingsManager) a.aC())) {
                        i.a(getContext(), (ImageView) this.fm);
                    } else if (this.eU.getPrivacyPolicyColor() == 0) {
                        this.fm.setImageResource(R.drawable.apnxt_na_i_icon_light);
                    } else {
                        this.fm.setImageResource(R.drawable.apnxt_na_i_icon_dark);
                    }
                    this.fm.getLayoutParams().width = g.a(getContext(), 40.0f);
                    this.fm.getLayoutParams().height = g.a(getContext(), 40.0f);
                    this.fm.setPadding(i4, a2, i, i3);
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("NativeAdView$init", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void aD() {
        super.removeView(this.fm);
        this.eU = null;
        this.eW = null;
        this.adViewActions = null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eU != null && this.eW != null && this.adViewActions != null) {
            e(getVisiblePercent(this));
        }
    }

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (getParent() == null || !view.isAttachedToWindow()) {
                return false;
            }
            Rect rect = new Rect();
            ((ViewGroup) getParent()).getHitRect(rect);
            return view.getGlobalVisibleRect(rect);
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAdView$isViewPartiallyVisible", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final int getVisiblePercent(View view) {
        if (!isViewPartiallyVisible(this) || view == null) {
            return 0;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        double width = (double) (rect.width() * rect.height());
        double width2 = (double) (view.getWidth() * view.getHeight());
        Double.isNaN(width);
        Double.isNaN(width2);
        return (int) ((width * 100.0d) / width2);
    }

    /* access modifiers changed from: private */
    public void e(int i) {
        if (getWindowVisibility() != 8 && getWindowVisibility() != 4 && this.eU != null) {
            a aVar = this.adViewActions;
            if (aVar != null) {
                aVar.d(i);
            }
            if (this.eU.getMediaView() != null) {
                this.eU.getMediaView().d(getVisiblePercent(this.eU.getMediaView()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eU != null && this.eW != null && this.adViewActions != null) {
            e(getVisiblePercent(this));
        }
    }
}
