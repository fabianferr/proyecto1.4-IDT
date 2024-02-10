package com.appnext.nativeads.designed_native_ads.views.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appnext.base.a;
import com.appnext.core.j;
import com.appnext.nativeads.R;
import com.appnext.nativeads.designed_native_ads.AppnextDesignedNativeAdData;
import com.appnext.nativeads.designed_native_ads.DesignNativeAd;
import com.appnext.nativeads.designed_native_ads.views.DesignedNativeAdViewContainer;
import com.appnext.nativeads.designed_native_ads.views.b;
import java.util.List;

public final class b extends a {
    private static int gk = 5;

    public b(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public final void f(List<DesignNativeAd> list) {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            int min = Math.min(gk, list.size());
            for (int i5 = 1; i5 <= min; i5++) {
                if (i5 == 1) {
                    i4 = R.id.image1;
                    i3 = R.id.title1;
                    i2 = R.id.native_ad_view1;
                } else if (i5 == 2) {
                    i4 = R.id.image2;
                    i3 = R.id.title2;
                    i2 = R.id.native_ad_view2;
                } else if (i5 == 3) {
                    i4 = R.id.image3;
                    i3 = R.id.title3;
                    i2 = R.id.native_ad_view3;
                } else if (i5 == 4) {
                    i4 = R.id.image4;
                    i3 = R.id.title4;
                    i2 = R.id.native_ad_view4;
                } else if (i5 != 5) {
                } else {
                    i4 = R.id.image5;
                    i3 = R.id.title5;
                    i2 = R.id.native_ad_view5;
                }
                DesignNativeAd designNativeAd = list.get(i5 - 1);
                j.Y().a(getContext(), (ImageView) findViewById(i4), designNativeAd.getIconUrl(), 16, (j.a) null);
                ((TextView) findViewById(i3)).setText(designNativeAd.getAdTitle());
                DesignedNativeAdViewContainer designedNativeAdViewContainer = (DesignedNativeAdViewContainer) findViewById(i2);
                designedNativeAdViewContainer.register(new b.a(designNativeAd) {
                    final /* synthetic */ DesignNativeAd gi;

                    {
                        this.gi = r2;
                    }

                    public final void f(int i) {
                        try {
                            a.this.ga.b(this.gi, i);
                            a.this.ga.a(this.gi, i);
                        } catch (Throwable th) {
                            com.appnext.base.a.a("DesignedNativeAdView$register", th);
                        }
                    }
                });
                designedNativeAdViewContainer.setOnClickListener(new View.OnClickListener(designNativeAd) {
                    final /* synthetic */ DesignNativeAd gi;

                    {
                        this.gi = r2;
                    }

                    public final void onClick(View view) {
                        try {
                            if (a.this.gf != null) {
                                a.this.gf.onAdClicked(new AppnextDesignedNativeAdData(this.gi.getAdPackage(), this.gi.getAdTitle(), System.currentTimeMillis()));
                            }
                            a.this.ga.a(this.gi);
                        } catch (Throwable th) {
                            com.appnext.base.a.a("DesignedNativeAdView$register", th);
                        }
                    }
                });
            }
            for (int i6 = min + 1; i6 <= gk; i6++) {
                if (i6 == 1) {
                    i = R.id.fl1container;
                } else if (i6 == 2) {
                    i = R.id.fl2container;
                } else if (i6 == 3) {
                    i = R.id.fl3container;
                } else if (i6 == 4) {
                    i = R.id.fl4container;
                } else if (i6 != 5) {
                } else {
                    i = R.id.fl5container;
                }
                findViewById(i).setVisibility(8);
            }
            ((LinearLayout) findViewById(R.id.apps_container)).setWeightSum((float) min);
        } catch (Throwable th) {
            a.a("SuggestedAppsView$onAdsLoaded", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        int i = z ? 0 : 4;
        try {
            findViewById(R.id.title1).setVisibility(i);
            findViewById(R.id.title2).setVisibility(i);
            findViewById(R.id.title3).setVisibility(i);
            findViewById(R.id.title4).setVisibility(i);
            findViewById(R.id.title5).setVisibility(i);
        } catch (Throwable th) {
            a.a("SuggestedAppsView$presentTitles", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void setIconTitleTextColor(int i) {
        try {
            ((TextView) findViewById(R.id.title1)).setTextColor(i);
            ((TextView) findViewById(R.id.title2)).setTextColor(i);
            ((TextView) findViewById(R.id.title3)).setTextColor(i);
            ((TextView) findViewById(R.id.title4)).setTextColor(i);
            ((TextView) findViewById(R.id.title5)).setTextColor(i);
        } catch (Throwable th) {
            a.a("SuggestedAppsView$setIconTitleTextColor", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void setTitleTextColorForAdUnit(int i) {
        try {
            ((TextView) findViewById(R.id.suggested_apps_title)).setTextColor(i);
        } catch (Throwable th) {
            a.a("SuggestedAppsView$setTitleTextColorForAdUnit", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void setTitleText(String str) {
        ((TextView) findViewById(R.id.suggested_apps_title)).setText(str);
    }

    /* access modifiers changed from: protected */
    public final int getContentResource() {
        return R.layout.suggested_apps_view_layout;
    }
}
