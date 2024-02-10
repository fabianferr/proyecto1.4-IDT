package com.bytedance.sdk.openadsdk.i;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* compiled from: VolumeChangeObserver */
public class h {
    private final AudioManager a;
    private int b = -1;
    private boolean c = false;

    public h(Context context) {
        this.a = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public boolean b() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return true;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.a != null) {
            int i = 0;
            if (z) {
                int f = DeviceUtils.f();
                if (f != 0) {
                    this.b = f;
                }
                l.b("VolumeChangeObserver", "mute set volume to 0");
                a(3, 0, 0);
                this.c = true;
                return;
            }
            int i2 = this.b;
            if (i2 == 0) {
                i2 = DeviceUtils.h() / 15;
            } else {
                if (i2 == -1) {
                    if (z2) {
                        i2 = DeviceUtils.h() / 15;
                    } else {
                        return;
                    }
                }
                l.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.b);
                this.b = -1;
                a(3, i2, i);
                this.c = true;
            }
            i = 1;
            l.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.b);
            this.b = -1;
            a(3, i2, i);
            this.c = true;
        }
    }

    private void a(int i, int i2, int i3) {
        try {
            this.a.setStreamVolume(i, i2, i3);
        } catch (Throwable unused) {
        }
    }
}
