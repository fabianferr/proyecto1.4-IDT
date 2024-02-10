package com.appnext.core;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.appnext.base.a;
import com.appnext.core.f;

public abstract class AppnextActivity extends Activity {
    protected String banner = "";
    protected String ct = "";
    private RelativeLayout cu;
    protected RelativeLayout cv;
    protected String guid = "";
    /* access modifiers changed from: protected */
    public Handler handler;
    /* access modifiers changed from: protected */
    public String placementID;
    /* access modifiers changed from: protected */
    public p userAction;

    /* access modifiers changed from: protected */
    public abstract SettingsManager getConfig();

    /* access modifiers changed from: protected */
    public abstract void onError(String str);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            n.aa().a(new Runnable() {
                public final void run() {
                    if (!g.f(AppnextActivity.this)) {
                        AppnextActivity.this.finish();
                        AppnextActivity.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                try {
                                    AppnextActivity.this.onError(AppnextError.CONNECTION_ERROR);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
            });
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(128);
            super.onCreate(bundle);
            this.handler = new Handler();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void a(AppnextAd appnextAd, f.a aVar) {
        p pVar = this.userAction;
        if (pVar != null && appnextAd != null) {
            pVar.a(appnextAd, appnextAd.getImpressionURL(), aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void b(AppnextAd appnextAd, f.a aVar) {
        p pVar = this.userAction;
        if (pVar != null && appnextAd != null) {
            pVar.a(appnextAd, appnextAd.getAppURL(), this.placementID, aVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ViewGroup viewGroup, Drawable drawable) {
        try {
            if (this.cu != null) {
                S();
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.cu = relativeLayout;
            relativeLayout.setBackgroundColor(Color.parseColor("#77ffffff"));
            viewGroup.addView(this.cu);
            this.cu.getLayoutParams().height = -1;
            this.cu.getLayoutParams().width = -1;
            ProgressBar progressBar = new ProgressBar(this, (AttributeSet) null, 16842871);
            progressBar.setIndeterminateDrawable(drawable);
            progressBar.setIndeterminate(true);
            this.cu.addView(progressBar);
            RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            progressBar.setAnimation(rotateAnimation);
            ((RelativeLayout.LayoutParams) progressBar.getLayoutParams()).addRule(13, -1);
            this.cu.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                }
            });
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppnextActivity.this.S();
                }
            }, 16000);
        } catch (Throwable th) {
            a.a("AppnextActivity$showClickMask", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void S() {
        RelativeLayout relativeLayout = this.cu;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.cu.removeAllViewsInLayout();
            if (this.cu.getParent() != null) {
                ((RelativeLayout) this.cu.getParent()).removeView(this.cu);
            }
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks((Runnable) null);
        }
        this.cu = null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        com.appnext.base.a.a("AppnextActivity$onDestroy", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r2 = this;
            super.onDestroy()
            r0 = 0
            android.os.Handler r1 = r2.handler     // Catch:{ all -> 0x000b }
            r1.removeCallbacks(r0)     // Catch:{ all -> 0x000b }
            r2.handler = r0     // Catch:{ all -> 0x000b }
        L_0x000b:
            com.appnext.core.p r1 = r2.userAction     // Catch:{ all -> 0x0013 }
            r1.destroy()     // Catch:{ all -> 0x0013 }
            r2.userAction = r0     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r0 = move-exception
            java.lang.String r1 = "AppnextActivity$onDestroy"
            com.appnext.base.a.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.AppnextActivity.onDestroy():void");
    }
}
