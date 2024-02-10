package com.pgl.ssdk;

import android.os.HandlerThread;
import java.lang.ref.WeakReference;

public class v extends r implements w {
    private final HandlerThread b;

    v(HandlerThread handlerThread, q qVar) {
        super(handlerThread.getLooper(), qVar);
        this.b = handlerThread;
    }

    public void a(q qVar) {
        this.a = new WeakReference(qVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
