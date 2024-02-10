package com.appnext.ads.fullscreen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appnext.R;
import com.appnext.core.AppnextAd;
import com.appnext.core.a.a;
import com.appnext.core.i;
import com.appnext.core.j;
import java.util.ArrayList;

public final class d extends Fragment {
    /* access modifiers changed from: private */
    public ArrayList<AppnextAd> ads;
    /* access modifiers changed from: private */
    public boolean clicked = false;
    private ImageView x;
    private TextView y;
    /* access modifiers changed from: private */
    public h z;

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.z = (h) activity;
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.z = (h) context;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(this.z.getTemplate("S3"), viewGroup, false);
            this.ads = this.z.getPostRollAds();
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.privacy);
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.close);
            View findViewById = relativeLayout.findViewById(R.id.click);
            this.x = (ImageView) relativeLayout.findViewById(R.id.media);
            this.y = (TextView) relativeLayout.findViewById(R.id.install);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.z.privacyClicked();
                }
            });
            if (i.a(this.ads.get(0), this.z.getConfigManager())) {
                i.a((Context) this.z, imageView);
            }
            imageView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.z.closeClicked();
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.z.installClicked((AppnextAd) d.this.ads.get(0));
                }
            });
            String ctaText = this.z.getCtaText();
            int parseInt = Integer.parseInt(a.n(getContext()).a(this.z.getLanguage(), "settings", "len"));
            if (!TextUtils.isEmpty(ctaText) && ctaText.length() > parseInt) {
                ctaText = ctaText.substring(0, parseInt);
            }
            this.y.setText(ctaText);
            this.y.setTextSize(2, (float) Integer.parseInt(a.n(getContext()).a(this.z.getLanguage(), "settings", "font_size_sp")));
            j.Y().a(getActivity(), this.x, this.ads.get(0).getWideImageURL(), (j.a) null);
            a(relativeLayout, this.ads.get(0), true);
            View findViewById2 = relativeLayout.findViewById(R.id.extra);
            if (findViewById2 != null) {
                if (this.ads.size() > 1) {
                    a((RelativeLayout) findViewById2.findViewById(R.id.item1), this.ads.get(1), false);
                } else {
                    findViewById2.findViewById(R.id.item1).setVisibility(4);
                }
                if (this.ads.size() > 2) {
                    a((RelativeLayout) findViewById2.findViewById(R.id.item2), this.ads.get(2), false);
                } else {
                    findViewById2.findViewById(R.id.item2).setVisibility(4);
                }
                if (findViewById2.findViewById(R.id.item3) != null) {
                    if (this.ads.size() > 3) {
                        a((RelativeLayout) findViewById2.findViewById(R.id.item3), this.ads.get(3), false);
                    } else {
                        findViewById2.findViewById(R.id.item3).setVisibility(4);
                    }
                }
            }
            report("post_roll_loaded");
            return relativeLayout;
        } catch (Throwable th) {
            com.appnext.base.a.a("PostRollFragment$onCreateView", th);
            this.z.closeClicked();
            return null;
        }
    }

    private void a(RelativeLayout relativeLayout, final AppnextAd appnextAd, final boolean z2) {
        j.Y().a(getActivity(), (ImageView) relativeLayout.findViewById(R.id.icon), appnextAd.getImageURL(), (j.a) null);
        ((TextView) relativeLayout.findViewById(R.id.title)).setText(appnextAd.getAdTitle());
        ((RatingBar) relativeLayout.findViewById(R.id.rating)).setRating(Float.parseFloat(appnextAd.getStoreRating()));
        relativeLayout.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
                if (z2) {
                    d.this.report("post_roll_click_main");
                } else {
                    d.this.report("post_roll_click_suggested");
                    StringBuilder sb = new StringBuilder();
                    sb.append(fullscreenAd.getAppURL());
                    sb.append("&tem_id=");
                    sb.append(d.this.z.isRewarded() ? "8" : "7");
                    sb.append("05");
                    fullscreenAd.setAppURL(sb.toString());
                }
                d.this.z.installClicked(fullscreenAd);
                d.this.clicked = true;
            }
        });
    }

    public final void onDestroyView() {
        report("post_roll_click_none");
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public void report(String str) {
        this.z.report(str, "S3");
    }
}
