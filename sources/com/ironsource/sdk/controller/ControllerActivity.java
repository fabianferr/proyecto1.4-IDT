package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.appnext.core.Ad;
import com.google.android.gms.cast.MediaTrack;
import com.ironsource.environment.h;
import com.ironsource.sdk.c.e;
import com.ironsource.sdk.controller.A;
import com.ironsource.sdk.g.b;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.i.a;
import com.ironsource.sdk.j.f;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;

public class ControllerActivity extends Activity implements z, f {
    private static final String a = "ControllerActivity";
    private static String b = "removeWebViewContainerView | mContainer is null";
    private static String c = "removeWebViewContainerView | view is null";
    public int currentRequestedRotation = -1;
    private String d;
    private A e;
    private RelativeLayout f;
    private FrameLayout g;
    /* access modifiers changed from: private */
    public boolean h = false;
    private String i;
    /* access modifiers changed from: private */
    public Handler j = new Handler();
    /* access modifiers changed from: private */
    public final Runnable k = new Runnable() {
        public final void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.h));
        }
    };
    private RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(-1, -1);
    private b m;
    private boolean n;
    private boolean o;

    private void a() {
        String str = a;
        Logger.i(str, "clearWebviewController");
        A a2 = this.e;
        if (a2 == null) {
            Logger.i(str, "clearWebviewController, null");
            return;
        }
        a2.j = A.g.Gone;
        this.e.l = null;
        this.e.v = null;
        this.e.a(this.i, "onDestroy");
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if (Ad.ORIENTATION_LANDSCAPE.equalsIgnoreCase(str)) {
            b();
        } else if (Ad.ORIENTATION_PORTRAIT.equalsIgnoreCase(str)) {
            c();
        } else if ("device".equalsIgnoreCase(str)) {
            if (h.q(this)) {
                setRequestedOrientation(1);
            }
        } else if (getRequestedOrientation() == -1) {
            setRequestedOrientation(4);
        }
    }

    private void b() {
        int k2 = h.k(this);
        String str = a;
        Logger.i(str, "setInitiateLandscapeOrientation");
        if (k2 == 0) {
            Logger.i(str, "ROTATION_0");
            setRequestedOrientation(0);
        } else if (k2 == 2) {
            Logger.i(str, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (k2 == 3) {
            Logger.i(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (k2 == 1) {
            Logger.i(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        } else {
            Logger.i(str, "No Rotation");
        }
    }

    private void c() {
        int k2 = h.k(this);
        String str = a;
        Logger.i(str, "setInitiatePortraitOrientation");
        if (k2 == 0) {
            Logger.i(str, "ROTATION_0");
            setRequestedOrientation(1);
        } else if (k2 == 2) {
            Logger.i(str, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (k2 == 1) {
            Logger.i(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (k2 == 3) {
            Logger.i(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        } else {
            Logger.i(str, "No Rotation");
        }
    }

    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        Logger.i(a, "onBackPressed");
        new a();
        if (!a.a(this)) {
            super.onBackPressed();
        }
    }

    public void onCloseRequested() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Logger.i(a, "onCreate");
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            A a2 = (A) com.ironsource.sdk.d.b.a((Context) this).a.a;
            this.e = a2;
            a2.i.setId(1);
            this.e.v = this;
            this.e.l = this;
            Intent intent = getIntent();
            this.i = intent.getStringExtra("productType");
            this.h = intent.getBooleanExtra("immersive", false);
            this.d = intent.getStringExtra("adViewId");
            this.n = false;
            this.o = intent.getBooleanExtra("ctrWVPauseResume", false);
            if (this.h) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    public final void onSystemUiVisibilityChange(int i) {
                        if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                            ControllerActivity.this.j.removeCallbacks(ControllerActivity.this.k);
                            ControllerActivity.this.j.postDelayed(ControllerActivity.this.k, 500);
                        }
                    }
                });
                runOnUiThread(this.k);
            }
            if (!TextUtils.isEmpty(this.i) && d.e.OfferWall.toString().equalsIgnoreCase(this.i)) {
                if (bundle != null) {
                    b bVar = (b) bundle.getParcelable("state");
                    if (bVar != null) {
                        this.m = bVar;
                        this.e.a(bVar);
                    }
                    finish();
                } else {
                    this.m = this.e.m;
                }
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f = relativeLayout;
            setContentView(relativeLayout, this.l);
            String str = this.d;
            this.g = !(!TextUtils.isEmpty(str) && !str.equals(Integer.toString(1))) ? this.e.i : com.ironsource.sdk.utils.d.a(getApplicationContext(), e.a().a(str).a());
            if (this.f.findViewById(1) == null && this.g.getParent() != null) {
                finish();
            }
            Intent intent2 = getIntent();
            String stringExtra = intent2.getStringExtra("orientation_set_flag");
            intent2.getIntExtra("rotation_set_flag", 0);
            a(stringExtra);
            this.f.addView(this.g, this.l);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        Logger.i(a, "onDestroy");
        try {
            if (this.f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.g.getParent();
                View findViewById = this.d == null ? viewGroup2.findViewById(1) : e.a().a(this.d).a();
                if (findViewById != null) {
                    if (isFinishing() && (viewGroup = (ViewGroup) findViewById.getParent()) != null) {
                        viewGroup.removeView(findViewById);
                    }
                    viewGroup2.removeView(this.g);
                    if (!this.n) {
                        Logger.i(a, "onDestroy | destroyedFromBackground");
                        a();
                        return;
                    }
                    return;
                }
                throw new Exception(c);
            }
            throw new Exception(b);
        } catch (Exception e2) {
            com.ironsource.sdk.a.f.a(com.ironsource.sdk.a.h.s, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", e2.getMessage()).a);
            String str = a;
            Logger.i(str, "removeWebViewContainerView fail " + e2.getMessage());
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.e.h != null) {
                this.e.g.onHideCustomView();
                return true;
            }
        }
        if (this.h && (i2 == 25 || i2 == 24)) {
            this.j.removeCallbacks(this.k);
            this.j.postDelayed(this.k, 500);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onOrientationChanged(String str, int i2) {
        a(str);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        String str = a;
        Logger.i(str, "onPause, isFinishing=" + isFinishing());
        com.ironsource.environment.thread.a.a.b(new Runnable((AudioManager) getSystemService("audio")) {
            private /* synthetic */ AudioManager a;

            {
                this.a = r1;
            }

            public final void run() {
                try {
                    this.a.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        A a2 = this.e;
        if (a2 != null) {
            a2.b((Context) this);
            if (!this.o) {
                this.e.i();
            }
            this.e.a(false, MediaTrack.ROLE_MAIN);
            this.e.a(this.i, "onPause");
        }
        if (isFinishing()) {
            this.n = true;
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Logger.i(a, "onResume");
        A a2 = this.e;
        if (a2 != null) {
            a2.a((Context) this);
            if (!this.o) {
                this.e.j();
            }
            this.e.a(true, MediaTrack.ROLE_MAIN);
            this.e.a(this.i, "onResume");
        }
        com.ironsource.environment.thread.a.a.b(new Runnable((AudioManager) getSystemService("audio")) {
            private /* synthetic */ AudioManager a;

            {
                this.a = r1;
            }

            public final void run() {
                try {
                    this.a.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty(this.i) && d.e.OfferWall.toString().equalsIgnoreCase(this.i)) {
            this.m.d = true;
            bundle.putParcelable("state", this.m);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Logger.i(a, "onStart");
        A a2 = this.e;
        if (a2 != null) {
            a2.a(this.i, "onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Logger.i(a, "onStop");
        A a2 = this.e;
        if (a2 != null) {
            a2.a(this.i, "onStop");
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(a, "onUserLeaveHint");
        A a2 = this.e;
        if (a2 != null) {
            a2.a(this.i, "onUserLeaveHint");
        }
    }

    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.h && z) {
            runOnUiThread(this.k);
        }
    }

    public void setRequestedOrientation(int i2) {
        if (this.currentRequestedRotation != i2) {
            String str = a;
            Logger.i(str, "Rotation: Req = " + i2 + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i2;
            super.setRequestedOrientation(i2);
        }
    }

    public void toggleKeepScreen(boolean z) {
        runOnUiThread(z ? new Runnable() {
            public final void run() {
                ControllerActivity.this.getWindow().addFlags(128);
            }
        } : new Runnable() {
            public final void run() {
                ControllerActivity.this.getWindow().clearFlags(128);
            }
        });
    }
}
