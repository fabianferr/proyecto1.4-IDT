package com.startapp.sdk.ads.splash;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.startapp.k2;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.w4;
import java.io.Serializable;

/* compiled from: Sta */
public class b extends k2 {
    public SplashConfig w = null;
    public SplashScreen x;
    public boolean y = false;
    public boolean z = false;

    public boolean a(int i, KeyEvent keyEvent) {
        if (this.y) {
            if (i == 25) {
                if (!this.z) {
                    this.z = true;
                    SplashScreen splashScreen = this.x;
                    splashScreen.g = true;
                    splashScreen.b.g = true;
                    Toast.makeText(this.b, "Test Mode", 0).show();
                    return true;
                }
            } else if (i == 24 && this.z) {
                this.b.finish();
                return true;
            }
        }
        return i == 4;
    }

    public void d() {
    }

    public void e() {
        SplashScreen splashScreen = this.x;
        if (splashScreen != null) {
            splashScreen.getClass();
        }
    }

    public void f() {
        AdPreferences adPreferences;
        if (this.w != null) {
            Serializable serializableExtra = this.a.getSerializableExtra("AdPreference");
            if (serializableExtra != null) {
                adPreferences = (AdPreferences) serializableExtra;
            } else {
                adPreferences = new AdPreferences();
            }
            this.y = this.a.getBooleanExtra("testMode", false);
            SplashScreen splashScreen = new SplashScreen(this.b, this.w, adPreferences);
            this.x = splashScreen;
            SplashEventHandler splashEventHandler = splashScreen.b;
            w4.a(splashEventHandler.a).a(splashEventHandler.k, new IntentFilter("com.startapp.android.adInfoWasClickedBroadcastListener"));
            if (!splashScreen.c()) {
                splashScreen.f.post(splashScreen.j);
            } else {
                splashScreen.f.postDelayed(splashScreen.j, 100);
            }
        }
    }

    public void g() {
        SplashEventHandler.SplashState splashState;
        SplashScreen splashScreen = this.x;
        if (splashScreen != null) {
            splashScreen.f.removeCallbacks(splashScreen.j);
            SplashEventHandler splashEventHandler = splashScreen.b;
            SplashEventHandler.SplashState splashState2 = splashEventHandler.i;
            if (splashState2 != SplashEventHandler.SplashState.DISPLAYED && splashState2 != (splashState = SplashEventHandler.SplashState.DO_NOT_DISPLAY)) {
                splashEventHandler.i = splashState;
                if (splashEventHandler.d) {
                    splashEventHandler.b();
                }
            }
        }
    }

    public void h() {
    }

    public void a(Bundle bundle) {
        this.w = (SplashConfig) this.a.getSerializableExtra("SplashConfig");
    }
}
