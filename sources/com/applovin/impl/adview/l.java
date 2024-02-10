package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.i;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.sdk.AppLovinSdkUtils;

class l extends Dialog implements k {
    private final Activity a;
    private final m b;
    /* access modifiers changed from: private */
    public final u c;
    /* access modifiers changed from: private */
    public final d d;
    private final a e;
    /* access modifiers changed from: private */
    public RelativeLayout f;
    /* access modifiers changed from: private */
    public i g;

    l(a aVar, d dVar, Activity activity, m mVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (dVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.b = mVar;
            this.c = mVar.A();
            this.a = activity;
            this.d = dVar;
            this.e = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    private int a(int i) {
        return AppLovinSdkUtils.dpToPx(this.a, i);
    }

    private void a(i.a aVar) {
        if (this.g == null) {
            i a2 = i.a(aVar, this.a);
            this.g = a2;
            a2.setVisibility(8);
            this.g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.d();
                }
            });
            this.g.setClickable(false);
            int a3 = a(((Integer) this.b.a(b.bV)).intValue());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
            layoutParams.addRule(10);
            int i = 9;
            layoutParams.addRule(((Boolean) this.b.a(b.bY)).booleanValue() ? 9 : 11);
            this.g.a(a3);
            int a4 = a(((Integer) this.b.a(b.bX)).intValue());
            int a5 = a(((Integer) this.b.a(b.bW)).intValue());
            layoutParams.setMargins(a5, a4, a5, 0);
            this.f.addView(this.g, layoutParams);
            this.g.bringToFront();
            int a6 = a(((Integer) this.b.a(b.bZ)).intValue());
            View view = new View(this.a);
            view.setBackgroundColor(0);
            int i2 = a3 + a6;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams2.addRule(10);
            if (!((Boolean) this.b.a(b.bY)).booleanValue()) {
                i = 11;
            }
            layoutParams2.addRule(i);
            layoutParams2.setMargins(a5 - a(5), a4 - a(5), a5 - a(5), 0);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (l.this.g.isClickable()) {
                        l.this.g.performClick();
                    }
                }
            });
            this.f.addView(view, layoutParams2);
            view.bringToFront();
        } else if (u.a()) {
            this.c.d("ExpandedAdDialog", "Attempting to create duplicate close button");
        }
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f.setBackgroundColor(-1157627904);
        this.f.addView(this.d);
        if (!this.e.m()) {
            a(this.e.n());
            e();
        }
        setContentView(this.f);
    }

    /* access modifiers changed from: private */
    public void d() {
        this.d.a("javascript:al_onCloseTapped();", (Runnable) new Runnable() {
            public void run() {
                l.this.dismiss();
            }
        });
    }

    private void e() {
        this.a.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (l.this.g == null) {
                        l.this.d();
                    }
                    l.this.g.setVisibility(0);
                    l.this.g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(300);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            l.this.g.setClickable(true);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    l.this.g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    if (u.a()) {
                        l.this.c.b("ExpandedAdDialog", "Unable to fade in close button", th);
                    }
                    l.this.d();
                }
            }
        });
    }

    public a a() {
        return this.e;
    }

    public d b() {
        return this.d;
    }

    public void dismiss() {
        d statsManagerHelper = this.d.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.e();
        }
        this.a.runOnUiThread(new Runnable() {
            public void run() {
                l.this.f.removeView(l.this.d);
                l.super.dismiss();
            }
        });
    }

    public void onBackPressed() {
        this.d.a("javascript:al_onBackPressed();", (Runnable) new Runnable() {
            public void run() {
                l.this.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.a.getWindow().getAttributes().flags, this.a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else if (u.a()) {
                this.c.e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            if (u.a()) {
                this.c.b("ExpandedAdDialog", "Setting window flags failed.", th);
            }
        }
    }
}
