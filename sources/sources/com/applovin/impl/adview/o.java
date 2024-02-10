package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class o implements AppLovinInterstitialAdDialog {
    protected final m a;
    private final WeakReference<Context> b;
    /* access modifiers changed from: private */
    public volatile AppLovinAdLoadListener c;
    /* access modifiers changed from: private */
    public volatile AppLovinAdDisplayListener d;
    /* access modifiers changed from: private */
    public volatile AppLovinAdVideoPlaybackListener e;
    /* access modifiers changed from: private */
    public volatile AppLovinAdClickListener f;
    /* access modifiers changed from: private */
    public volatile e g;
    private volatile e.b h;
    /* access modifiers changed from: private */
    public ViewGroup i;
    /* access modifiers changed from: private */
    public AppLovinFullscreenAdViewObserver j;
    /* access modifiers changed from: private */
    public a k;

    public o(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.a = appLovinSdk.coreSdk;
            this.b = new WeakReference<>(context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (o.this.c != null) {
                    o.this.c.failedToReceiveAd(i2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        Intent intent = new Intent(context, AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.a.z());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    private void a(e eVar, final Context context) {
        if (this.a.af().b() == null) {
            this.a.T().a(f.o);
        }
        this.g = eVar;
        this.h = this.g.p();
        final long max = Math.max(0, ((Long) this.a.a(b.cm)).longValue());
        if (u.a()) {
            u A = this.a.A();
            A.b("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        }
        a(eVar, context, new Runnable() {
            public void run() {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (o.this.i == null || o.this.j == null) {
                            if (u.a()) {
                                o.this.a.A().b("InterstitialAdDialogWrapper", "Presenting ad in a fullscreen activity");
                            }
                            o.this.a(context);
                            return;
                        }
                        if (u.a()) {
                            u A = o.this.a.A();
                            A.b("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + o.this.i + ")");
                        }
                        o.this.i.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        a.a(o.this.g, o.this.f, o.this.d, o.this.e, o.this.a, (Activity) o.this.f(), new a.C0008a() {
                            public void a(a aVar) {
                                a unused = o.this.k = aVar;
                                o.this.j.setPresenter(aVar);
                                aVar.a(o.this.i);
                            }

                            public void a(String str, Throwable th) {
                                o.a(o.this.g, o.this.d, str, th, (AppLovinFullscreenActivity) null);
                            }
                        });
                    }
                }, max);
            }
        });
    }

    private void a(e eVar, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(eVar.N()) || !eVar.ah() || h.a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(eVar.ai()).setMessage(eVar.aj()).setPositiveButton(eVar.ak(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    public static void a(e eVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        if (u.a()) {
            u.c("InterstitialAdDialogWrapper", str, th);
        }
        if (appLovinAdDisplayListener instanceof g) {
            j.a(appLovinAdDisplayListener, str);
        } else {
            j.b(appLovinAdDisplayListener, (AppLovinAd) eVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    private void a(AppLovinAd appLovinAd) {
        if (this.d != null) {
            this.d.adHidden(appLovinAd);
        }
    }

    /* access modifiers changed from: private */
    public void b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (o.this.c != null) {
                    o.this.c.adReceived(appLovinAd);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public Context f() {
        return (Context) this.b.get();
    }

    public e a() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.a.u().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    public AppLovinAdVideoPlaybackListener b() {
        return this.e;
    }

    public AppLovinAdDisplayListener c() {
        return this.d;
    }

    public AppLovinAdClickListener d() {
        return this.f;
    }

    public void e() {
        this.i = null;
        this.j = null;
        this.f = null;
        this.c = null;
        this.e = null;
        this.d = null;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.d = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.c = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.e = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                o.this.b(appLovinAd);
                o.this.showAndRender(appLovinAd);
            }

            public void failedToReceiveAd(int i) {
                o.this.a(i);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        Context f2 = f();
        if (f2 == null) {
            if (u.a()) {
                u.i("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            }
            a(appLovinAd);
            return;
        }
        AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAd, this.a);
        if (maybeRetrieveNonDummyAd == null) {
            if (u.a()) {
                u.i("InterstitialAdDialogWrapper", "Failed to show ad: " + appLovinAd);
            }
            a(appLovinAd);
        } else if (((AppLovinAdImpl) maybeRetrieveNonDummyAd).hasShown() && ((Boolean) this.a.a(b.ca)).booleanValue()) {
            throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
        } else if (maybeRetrieveNonDummyAd instanceof e) {
            a((e) maybeRetrieveNonDummyAd, f2);
        } else {
            if (u.a()) {
                u A = this.a.A();
                A.e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + maybeRetrieveNonDummyAd + "'");
            }
            a(maybeRetrieveNonDummyAd);
        }
    }

    public void showAndRender(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle) {
        if (viewGroup == null || lifecycle == null) {
            if (u.a()) {
                u.i("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null containerView or lifecycle");
            }
            a(appLovinAd);
            return;
        }
        this.i = viewGroup;
        AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver = new AppLovinFullscreenAdViewObserver(lifecycle, this, this.a);
        this.j = appLovinFullscreenAdViewObserver;
        lifecycle.addObserver(appLovinFullscreenAdViewObserver);
        showAndRender(appLovinAd);
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
