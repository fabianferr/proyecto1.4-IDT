package com.startapp;

import android.os.AsyncTask;

/* compiled from: Sta */
public abstract class sb extends AsyncTask<Object, Void, String> {
    public a a;
    public final b b;

    /* compiled from: Sta */
    public interface a {
    }

    /* compiled from: Sta */
    public interface b {
    }

    public sb(b bVar) {
        this.b = bVar;
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.a;
        if (aVar != null) {
            yb ybVar = (yb) aVar;
            ybVar.c = null;
            sb poll = ybVar.b.poll();
            ybVar.c = poll;
            if (poll != null) {
                poll.executeOnExecutor(ybVar.a, new Object[0]);
            }
        }
    }
}
