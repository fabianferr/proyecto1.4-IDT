package com.applovin.adview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.activity.b.e;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenActivity extends Activity implements k {
    public static o parentInterstitialWrapper;
    private m a;
    /* access modifiers changed from: private */
    public com.applovin.impl.adview.activity.b.a b;
    private final AtomicBoolean c = new AtomicBoolean(true);
    private com.applovin.impl.adview.activity.a d;
    private a e;
    private boolean f;

    private static class a implements OnBackInvokedCallback {
        private final Runnable a;

        protected a(Runnable runnable) {
            this.a = runnable;
        }

        public void onBackInvoked() {
            this.a.run();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        com.applovin.impl.adview.activity.b.a aVar = this.b;
        if (aVar != null) {
            aVar.l();
        }
        if (Utils.isAppLovinTestEnvironment(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    private void b() {
        WindowInsetsController insetsController;
        if (!this.f || !g.j() || (insetsController = getWindow().getInsetsController()) == null) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
            return;
        }
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsets.Type.systemBars());
    }

    public void dismiss() {
        if (g.k() && this.e != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.e);
            this.e = null;
        }
        com.applovin.impl.adview.activity.b.a aVar = this.b;
        if (aVar != null) {
            aVar.h();
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        a();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.applovin.impl.adview.activity.b.a aVar = this.b;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            if (bundle.getBoolean("com.applovin.dismiss_on_restore", false)) {
                if (u.a()) {
                    u.h("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
                }
                dismiss();
                return;
            } else if (u.a()) {
                u.f("AppLovinFullscreenActivity", "Activity was destroyed while in background.");
            }
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        View findViewById = findViewById(16908290);
        findViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        String stringExtra = getIntent().getStringExtra("com.applovin.interstitial.sdk_key");
        if (TextUtils.isEmpty(stringExtra)) {
            o oVar = parentInterstitialWrapper;
            if (!(oVar == null || oVar.a() == null)) {
                o.a(parentInterstitialWrapper.a(), parentInterstitialWrapper.c(), "Empty SDK key", (Throwable) null, this);
            }
            finish();
        }
        m mVar = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(this), this).coreSdk;
        this.a = mVar;
        this.f = ((Boolean) mVar.a(b.cG)).booleanValue();
        if (((Boolean) this.a.a(b.cH)).booleanValue()) {
            findViewById.setFitsSystemWindows(true);
        }
        b();
        if (g.k() && ((Boolean) this.a.a(b.eY)).booleanValue()) {
            this.e = new a(new Runnable() {
                public void run() {
                    AppLovinFullscreenActivity.this.a();
                }
            });
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.e);
        }
        o oVar2 = parentInterstitialWrapper;
        if (oVar2 != null) {
            com.applovin.impl.adview.activity.b.a.a(oVar2.a(), parentInterstitialWrapper.d(), parentInterstitialWrapper.c(), parentInterstitialWrapper.b(), this.a, this, new a.C0008a() {
                public void a(com.applovin.impl.adview.activity.b.a aVar) {
                    com.applovin.impl.adview.activity.b.a unused = AppLovinFullscreenActivity.this.b = aVar;
                    aVar.d();
                }

                public void a(String str, Throwable th) {
                    o.a(AppLovinFullscreenActivity.parentInterstitialWrapper.a(), AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th, AppLovinFullscreenActivity.this);
                }
            });
            return;
        }
        Intent intent = new Intent(this, FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.a);
        this.d = aVar;
        bindService(intent, aVar, 1);
        if (g.h()) {
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        parentInterstitialWrapper = null;
        com.applovin.impl.adview.activity.a aVar = this.d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        com.applovin.impl.adview.activity.b.a aVar2 = this.b;
        if (aVar2 != null) {
            if (!aVar2.i()) {
                this.b.h();
            }
            this.b.k();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.applovin.impl.adview.activity.b.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.applovin.impl.adview.activity.b.a aVar = this.b;
        if (aVar != null) {
            aVar.g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        com.applovin.impl.adview.activity.b.a aVar;
        try {
            super.onResume();
            if (!this.c.get() && (aVar = this.b) != null) {
                aVar.f();
            }
        } catch (IllegalArgumentException e2) {
            if (u.a()) {
                this.a.A().b("AppLovinFullscreenActivity", "Error was encountered in onResume().", e2);
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m mVar = this.a;
        if (mVar != null) {
            bundle.putBoolean("com.applovin.dismiss_on_restore", ((Boolean) mVar.a(b.eQ)).booleanValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        com.applovin.impl.adview.activity.b.a aVar = this.b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.b != null) {
            if (!this.c.getAndSet(false) || (this.b instanceof e)) {
                this.b.c(z);
            }
            if (z) {
                b();
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void setPresenter(com.applovin.impl.adview.activity.b.a aVar) {
        this.b = aVar;
    }
}
