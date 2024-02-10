package com.startapp;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.Collections;

/* compiled from: Sta */
public final class dc extends ContentObserver {
    public final Context a;
    public final AudioManager b;
    public final mb c;
    public final zb d;
    public float e;

    public dc(Handler handler, Context context, mb mbVar, zb zbVar) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = mbVar;
        this.d = zbVar;
    }

    public final float a() {
        int streamVolume = this.b.getStreamVolume(3);
        int streamMaxVolume = this.b.getStreamMaxVolume(3);
        this.c.getClass();
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = ((float) streamVolume) / ((float) streamMaxVolume);
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public final void b() {
        zb zbVar = this.d;
        float f = this.e;
        lc lcVar = (lc) zbVar;
        lcVar.a = f;
        if (lcVar.e == null) {
            lcVar.e = db.c;
        }
        for (T t : Collections.unmodifiableCollection(lcVar.e.b)) {
            AdSessionStatePublisher adSessionStatePublisher = t.e;
            fc.a.a(adSessionStatePublisher.c(), "setDeviceVolume", Float.valueOf(f));
        }
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float a2 = a();
        if (a2 != this.e) {
            this.e = a2;
            b();
        }
    }
}
