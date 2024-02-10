package com.appnext.core.ra.a;

import android.content.Context;
import android.os.Bundle;
import com.appnext.core.ra.a;
import java.text.SimpleDateFormat;

public abstract class b {
    private static SimpleDateFormat ee = new SimpleDateFormat("dd/MM/yyyy");
    private Context aM;
    private Bundle ef;

    /* access modifiers changed from: protected */
    public abstract void an();

    /* access modifiers changed from: protected */
    public abstract boolean ao();

    public b(Context context, Bundle bundle) {
        this.aM = context;
        this.ef = bundle;
    }

    public final void ap() {
        if (!ao() || (ao() && a.o(this.aM).ah())) {
            an();
        }
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.aM;
    }

    /* access modifiers changed from: protected */
    public final Bundle aq() {
        return this.ef;
    }

    protected static SimpleDateFormat ar() {
        return ee;
    }
}
