package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: TTQueuedWork */
public class c {
    private static final Object a = new Object();
    private static volatile Handler b;
    private static final LinkedList<Runnable> c = new LinkedList<>();
    private static Object d = new Object();

    public static void a(Runnable runnable, boolean z) {
        Handler b2 = b();
        synchronized (a) {
            c.add(runnable);
            if (z) {
                b2.sendEmptyMessageDelayed(1, 100);
            } else {
                b2.sendEmptyMessage(1);
            }
        }
    }

    private static Handler b() {
        Handler handler;
        if (b != null) {
            return b;
        }
        synchronized (a) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("queued-work-looper", -2);
                handlerThread.start();
                b = new a(handlerThread.getLooper());
            }
            handler = b;
        }
        return handler;
    }

    /* access modifiers changed from: private */
    public static void c() {
        LinkedList linkedList;
        synchronized (d) {
            synchronized (a) {
                LinkedList<Runnable> linkedList2 = c;
                linkedList = (LinkedList) linkedList2.clone();
                linkedList2.clear();
                b().removeMessages(1);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    /* compiled from: TTQueuedWork */
    private static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                c.c();
            }
        }
    }
}
