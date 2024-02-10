package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
public class x extends Handler {
    protected WeakReference<a> a;

    /* compiled from: WeakHandler */
    public interface a {
        void a(Message message);
    }

    public x(a aVar) {
        if (aVar != null) {
            this.a = new WeakReference<>(aVar);
        }
    }

    public x(Looper looper, a aVar) {
        super(looper);
        if (aVar != null) {
            this.a = new WeakReference<>(aVar);
        }
    }

    public void handleMessage(Message message) {
        a aVar;
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && (aVar = (a) weakReference.get()) != null && message != null) {
            aVar.a(message);
        }
    }
}
