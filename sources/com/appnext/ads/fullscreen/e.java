package com.appnext.ads.fullscreen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appnext.R;
import com.appnext.base.a;
import com.appnext.core.AppnextAd;
import com.appnext.core.i;
import com.appnext.core.j;
import java.util.ArrayList;

public final class e extends Fragment {
    /* access modifiers changed from: private */
    public i D;
    /* access modifiers changed from: private */
    public TextView E;
    /* access modifiers changed from: private */
    public int F = 0;
    /* access modifiers changed from: private */
    public ArrayList<AppnextAd> G;
    /* access modifiers changed from: private */
    public Handler handler;
    Runnable tick = new Runnable() {
        public final void run() {
            try {
                e.this.handler.removeCallbacks(this);
                e eVar = e.this;
                int r1 = eVar.F - 1;
                eVar.F = r1;
                if (r1 == 0) {
                    e.this.D.videoSelected((AppnextAd) e.this.G.get(0));
                    e.this.report("pre_roll_noclick");
                    return;
                }
                if (e.this.E != null) {
                    e.this.E.setText(e.this.F + " sec");
                }
                e.this.handler.postDelayed(e.this.tick, 1000);
            } catch (Throwable th) {
                a.a("PreRollFragment$onDestroyView", th);
            }
        }
    };

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("time")) {
            this.F = getArguments().getInt("time");
        }
        if (bundle != null) {
            this.F = bundle.getInt("time");
        }
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.D = (i) activity;
        this.handler = new Handler();
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.D = (i) context;
        this.handler = new Handler();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(this.D.getTemplate("S1"), viewGroup, false);
            View findViewById = relativeLayout.findViewById(R.id.item1);
            View findViewById2 = relativeLayout.findViewById(R.id.item2);
            ((TextView) relativeLayout.findViewById(R.id.title)).setText(this.D.getConfigManager().t("pre_title_string1"));
            ((TextView) relativeLayout.findViewById(R.id.secondTile)).setText(this.D.getConfigManager().t("pre_title_string2"));
            this.E = (TextView) relativeLayout.findViewById(R.id.timer);
            ArrayList<AppnextAd> preRollAds = this.D.getPreRollAds();
            this.G = preRollAds;
            if (preRollAds.size() < 2) {
                this.D.videoSelected(this.G.get(0));
                return null;
            }
            a((ViewGroup) findViewById, this.G.get(0), 0);
            a((ViewGroup) findViewById2, this.G.get(1), 1);
            relativeLayout.findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    e.this.D.privacyClicked();
                }
            });
            if (i.a(this.G.get(0), this.D.getConfigManager())) {
                i.a((Context) this.D, (ImageView) relativeLayout.findViewById(R.id.privacy));
            }
            TextView textView = this.E;
            textView.setText(this.F + " sec");
            report("pre_roll_loaded");
            return relativeLayout;
        } catch (Throwable th) {
            a.a("PreRollFragment$onCreateView", th);
            this.D.closeClicked();
            return null;
        }
    }

    private void a(ViewGroup viewGroup, final AppnextAd appnextAd, final int i) {
        try {
            TextView textView = (TextView) viewGroup.findViewById(R.id.title);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.icon);
            ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.background_image);
            RatingBar ratingBar = (RatingBar) viewGroup.findViewById(R.id.ratingBar);
            if (viewGroup.findViewById(R.id.playGameTextView) != null) {
                ((TextView) viewGroup.findViewById(R.id.playGameTextView)).setText(this.D.getConfigManager().t("pre_cta_string"));
            }
            textView.setText(appnextAd.getAdTitle());
            ratingBar.setRating(Float.parseFloat(appnextAd.getStoreRating()));
            viewGroup.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    e.this.D.videoSelected(appnextAd);
                    int i = i;
                    if (i == 0) {
                        e.this.report("pre_roll_left_click");
                    } else if (i == 1) {
                        e.this.report("pre_roll_right_click");
                    }
                }
            });
            if (imageView2 != null) {
                j.Y().a(getActivity(), imageView2, appnextAd.getWideImageURL(), (j.a) null);
                j.Y().a(getActivity(), imageView, appnextAd.getImageURL(), (j.a) null);
            }
        } catch (Throwable th) {
            a.a("PreRollFragment$initItem", th);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("time", this.F);
        super.onSaveInstanceState(bundle);
    }

    public final void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.tick);
    }

    public final void onResume() {
        super.onResume();
        try {
            this.handler.postDelayed(this.tick, 1000);
        } catch (Throwable th) {
            a.a("PreRollFragment$onResume", th);
        }
    }

    /* access modifiers changed from: private */
    public void report(String str) {
        try {
            this.D.report(str, "S1");
        } catch (Throwable th) {
            a.a("PreRollFragment$report", th);
        }
    }
}
