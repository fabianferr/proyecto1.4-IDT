package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.jobs.b;

/* compiled from: Sta */
public class y8 extends b {
    public y8(Context context, b.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    public void run() {
        z8 a = ComponentLocator.a(this.context).l.a();
        b.a aVar = this.callback;
        if (aVar != null) {
            a.e.post(new a9(a, aVar, this));
        } else {
            a.e.post(a.j);
        }
    }
}
