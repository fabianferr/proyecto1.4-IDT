package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MNSIBuilderMin17.kt */
public final class d3 extends c3 {
    public final Context t;
    public final int u;
    public final int v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d3(Context context, int i, int i2) {
        super(context, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.t = context;
        this.u = i;
        this.v = i2;
        Object systemService = d().getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        ((TelephonyManager) systemService).createForSubscriptionId(o());
    }

    public final void a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "telephonyDisplayInfo");
    }

    public final void a(List<? extends CellInfo> list) {
        Intrinsics.checkNotNullParameter(list, "cellInfo");
        this.d++;
        this.g = list;
        this.m = System.currentTimeMillis();
    }

    public final Context d() {
        return this.t;
    }

    public final int n() {
        return this.v;
    }

    public final int o() {
        return this.u;
    }

    public final boolean q() {
        if (Build.VERSION.SDK_INT == 29) {
            if (this.g == null || this.i == null || this.h == null || this.r <= 0) {
                return false;
            }
            return true;
        } else if (this.g == null || this.i == null || this.r <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public final void a(CellLocation cellLocation) {
        Intrinsics.checkNotNullParameter(cellLocation, "cellLocation");
        this.d++;
        this.j = cellLocation;
        this.p = System.currentTimeMillis();
    }

    public final void a(NetworkInfoSnapshot networkInfoSnapshot) {
        Intrinsics.checkNotNullParameter(networkInfoSnapshot, "networkInfo");
        this.d++;
        this.k = networkInfoSnapshot;
        this.q = System.currentTimeMillis();
    }

    public final void a(ServiceState serviceState) {
        Intrinsics.checkNotNullParameter(serviceState, "serviceState");
        this.d++;
        this.i = serviceState;
        this.o = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(serviceState, "serviceState");
        this.r = m4.d(serviceState);
        this.s = m4.a(serviceState);
    }

    public final void a(SignalStrength signalStrength) {
        Intrinsics.checkNotNullParameter(signalStrength, "signalStrength");
        this.d++;
        this.h = signalStrength;
        this.n = System.currentTimeMillis();
    }

    public final boolean a(c3 c3Var) {
        if (c3Var != null && this.m == c3Var.m && this.n == c3Var.n && this.o == c3Var.o && this.p == c3Var.p && this.q == c3Var.q) {
            return true;
        }
        return false;
    }

    public final c3 a() {
        d3 d3Var = new d3(this.t, this.u, this.v);
        d3Var.d = this.d;
        d3Var.g = this.g;
        d3Var.h = this.h;
        d3Var.i = this.i;
        d3Var.j = this.j;
        d3Var.f = this.f;
        d3Var.m = this.m;
        d3Var.n = this.n;
        d3Var.o = this.o;
        d3Var.p = this.p;
        d3Var.l = this.l;
        d3Var.q = this.q;
        d3Var.r = this.r;
        d3Var.s = this.s;
        d3Var.k = this.k;
        return d3Var;
    }
}
