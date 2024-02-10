package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.tools.aa;

public abstract class MBBaseActivity extends Activity {
    /* access modifiers changed from: private */
    public OrientationEventListener a;
    /* access modifiers changed from: private */
    public Display b;
    /* access modifiers changed from: private */
    public int c = -1;

    public abstract void setTopControllerPadding(int i, int i2, int i3, int i4, int i5);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            b();
            a();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            aa.d("MBBaseActivity", e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!b.c) {
            getNotchParams();
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.a;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.a = null;
        }
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            public final void run() {
                int i;
                int i2;
                int i3;
                DisplayCutout displayCutout;
                int i4;
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i5 = -1;
                        int i6 = 0;
                        if (rootWindowInsets == null || Build.VERSION.SDK_INT < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                            i3 = 0;
                            i2 = 0;
                            i = 0;
                        } else {
                            int safeInsetLeft = displayCutout.getSafeInsetLeft();
                            int safeInsetRight = displayCutout.getSafeInsetRight();
                            int safeInsetTop = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            aa.d("MBBaseActivity", "NOTCH Left:" + safeInsetLeft + " Right:" + safeInsetRight + " Top:" + safeInsetTop + " Bottom:" + safeInsetBottom);
                            if (MBBaseActivity.this.b != null) {
                                i4 = MBBaseActivity.this.b.getRotation();
                            } else {
                                i4 = MBBaseActivity.this.a();
                            }
                            if (MBBaseActivity.this.c == -1) {
                                int unused = MBBaseActivity.this.c = i4 == 0 ? 3 : i4 == 1 ? 1 : i4 == 2 ? 4 : i4 == 3 ? 2 : -1;
                                aa.d("MBBaseActivity", MBBaseActivity.this.c + "");
                            }
                            if (i4 != 0) {
                                if (i4 == 1) {
                                    i5 = 90;
                                } else if (i4 == 2) {
                                    i5 = 180;
                                } else if (i4 == 3) {
                                    i5 = 270;
                                }
                                i6 = safeInsetLeft;
                                i3 = safeInsetRight;
                                i2 = safeInsetTop;
                            } else {
                                i6 = safeInsetLeft;
                                i3 = safeInsetRight;
                                i2 = safeInsetTop;
                                i5 = 0;
                            }
                            i = safeInsetBottom;
                        }
                        MBBaseActivity.this.setTopControllerPadding(i5, i6, i3, i2, i);
                        if (MBBaseActivity.this.a == null) {
                            MBBaseActivity.e(MBBaseActivity.this);
                        }
                    }
                } catch (Exception e) {
                    aa.d("MBBaseActivity", e.getMessage());
                }
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public int a() {
        if (this.b == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.b = getDisplay();
            } else {
                this.b = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.b;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    private void b() {
        try {
            getWindow().addFlags(67108864);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            aa.d("MBBaseActivity", th.getMessage());
        }
    }

    static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        AnonymousClass2 r0 = new OrientationEventListener(mBBaseActivity, 1) {
            public final void onOrientationChanged(int i) {
                int rotation = MBBaseActivity.this.b != null ? MBBaseActivity.this.b.getRotation() : 0;
                if (rotation == 1 && MBBaseActivity.this.c != 1) {
                    int unused = MBBaseActivity.this.c = 1;
                    MBBaseActivity.this.getNotchParams();
                    aa.d("MBBaseActivity", "Orientation Left");
                } else if (rotation == 3 && MBBaseActivity.this.c != 2) {
                    int unused2 = MBBaseActivity.this.c = 2;
                    MBBaseActivity.this.getNotchParams();
                    aa.d("MBBaseActivity", "Orientation Right");
                } else if (rotation == 0 && MBBaseActivity.this.c != 3) {
                    int unused3 = MBBaseActivity.this.c = 3;
                    MBBaseActivity.this.getNotchParams();
                    aa.d("MBBaseActivity", "Orientation Top");
                } else if (rotation == 2 && MBBaseActivity.this.c != 4) {
                    int unused4 = MBBaseActivity.this.c = 4;
                    MBBaseActivity.this.getNotchParams();
                    aa.d("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.a = r0;
        if (r0.canDetectOrientation()) {
            mBBaseActivity.a.enable();
            return;
        }
        mBBaseActivity.a.disable();
        mBBaseActivity.a = null;
    }
}
