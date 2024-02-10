package com.pgl.ssdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class r extends Handler {
    protected WeakReference a;

    public r(Looper looper, q qVar) {
        super(looper);
        if (qVar != null) {
            this.a = new WeakReference(qVar);
        }
    }

    public void handleMessage(Message message) {
        q qVar;
        WeakReference weakReference = this.a;
        if (weakReference != null && (qVar = (q) weakReference.get()) != null && message != null) {
            qVar.a(message);
        }
    }
}
