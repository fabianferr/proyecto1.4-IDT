package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class l implements k.a, AppLovinWebViewActivity.EventListener {
    /* access modifiers changed from: private */
    public static final AtomicBoolean a = new AtomicBoolean();
    /* access modifiers changed from: private */
    public static WeakReference<AppLovinWebViewActivity> b;
    /* access modifiers changed from: private */
    public final m c;
    /* access modifiers changed from: private */
    public final u d;
    /* access modifiers changed from: private */
    public AppLovinUserService.OnConsentDialogDismissListener e;
    /* access modifiers changed from: private */
    public k f;
    /* access modifiers changed from: private */
    public WeakReference<Activity> g = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public a h;
    private AtomicBoolean i = new AtomicBoolean();

    l(m mVar) {
        this.c = mVar;
        this.d = mVar.A();
        if (mVar.N() != null) {
            this.g = new WeakReference<>(mVar.N());
        }
        m.a(m.M()).a(new a() {
            public void onActivityStarted(Activity activity) {
                WeakReference unused = l.this.g = new WeakReference(activity);
            }
        });
        this.f = new k(this, mVar);
    }

    private void a(boolean z, long j) {
        g();
        if (z) {
            a(j);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(m mVar) {
        if (d()) {
            if (u.a()) {
                u.i("AppLovinSdk", "Consent dialog already showing");
            }
            return false;
        } else if (!h.a(mVar.L())) {
            if (u.a()) {
                u.i("AppLovinSdk", "No internet available, skip showing of consent dialog");
            }
            return false;
        } else if (!((Boolean) mVar.a(b.au)).booleanValue()) {
            if (u.a()) {
                this.d.e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            }
            return false;
        } else if (StringUtils.isValidString((String) mVar.a(b.av))) {
            return true;
        } else {
            if (u.a()) {
                this.d.e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            }
            return false;
        }
    }

    private void g() {
        this.c.af().b(this.h);
        if (d()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) b.get();
            b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.e = null;
                }
            }
        }
    }

    public void a() {
        final Activity activity = (Activity) this.g.get();
        if (activity != null) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    l.this.a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.c.a(b.ax)).longValue());
        }
    }

    public void a(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (u.a()) {
                    l.this.d.b("ConsentDialogManager", "Scheduling repeating consent alert");
                }
                l.this.f.a(j, l.this.c, l.this);
            }
        });
    }

    public void a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                l lVar = l.this;
                if (!lVar.a(lVar.c) || l.a.getAndSet(true)) {
                    AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener != null) {
                        onConsentDialogDismissListener.onDismiss();
                        return;
                    }
                    return;
                }
                WeakReference unused = l.this.g = new WeakReference(activity);
                AppLovinUserService.OnConsentDialogDismissListener unused2 = l.this.e = onConsentDialogDismissListener;
                a unused3 = l.this.h = new a() {
                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            if (!l.this.d() || l.b.get() != activity) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                                WeakReference unused = l.b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) l.this.c.a(b.av), l.this);
                            }
                            l.a.set(false);
                        }
                    }
                };
                l.this.c.af().a(l.this.h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, l.this.c.z());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) l.this.c.a(b.aw));
                activity.startActivity(intent);
            }
        });
    }

    public void b() {
    }

    public void c() {
        if (!this.i.getAndSet(true)) {
            final String str = (String) this.c.a(b.av);
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    WebView tryToCreateWebView = Utils.tryToCreateWebView(l.this.c.L(), "preloading consent dialog");
                    if (tryToCreateWebView != null) {
                        tryToCreateWebView.loadUrl(str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        WeakReference<AppLovinWebViewActivity> weakReference = b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onReceivedEvent(String str) {
        boolean booleanValue;
        m mVar;
        b bVar;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.c.L());
            g();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.c.L());
            booleanValue = ((Boolean) this.c.a(b.ay)).booleanValue();
            mVar = this.c;
            bVar = b.aD;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.c.a(b.az)).booleanValue();
            mVar = this.c;
            bVar = b.aE;
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.c.a(b.aA)).booleanValue();
            mVar = this.c;
            bVar = b.aF;
        } else {
            return;
        }
        a(booleanValue, ((Long) mVar.a(bVar)).longValue());
    }
}
