package com.teragence.client.service;

import android.content.Context;
import android.content.Intent;

public class b implements g {
    private final g a;
    private final Context b;

    public b(g gVar, Context context) {
        this.a = gVar;
        this.b = context;
    }

    public void a(boolean z) {
        Context context;
        Intent intent;
        this.a.a(z);
        if (z) {
            context = this.b;
            intent = new Intent(ServiceStateConstants.STARTED);
        } else {
            context = this.b;
            intent = new Intent(ServiceStateConstants.STOPPED);
        }
        context.sendBroadcast(intent);
    }

    public boolean a() {
        return this.a.a();
    }
}
