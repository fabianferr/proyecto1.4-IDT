package com.bytedance.sdk.component.g.a;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.x;
import java.lang.ref.WeakReference;

/* compiled from: HandlerWapper */
public class b extends x implements c {
    private final HandlerThread b;

    b(HandlerThread handlerThread, x.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.b = handlerThread;
    }

    public void a() {
        removeCallbacksAndMessages((Object) null);
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }

    public void a(x.a aVar) {
        this.a = new WeakReference(aVar);
    }

    public void b() {
        HandlerThread handlerThread = this.b;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
