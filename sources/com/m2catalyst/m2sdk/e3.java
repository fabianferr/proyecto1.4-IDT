package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MNSIBuilderMin30.kt */
public final class e3 extends c3 {
    public final Context t;
    public final int u;
    public final int v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e3(Context context, int i, int i2) {
        super(context, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.t = context;
        this.u = i;
        this.v = i2;
        Object systemService = d().getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        ((TelephonyManager) systemService).createForSubscriptionId(o());
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
        Object obj;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT == 30) {
            Context context = this.t;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                i2 = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
            } catch (RuntimeException unused) {
                i2 = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.READ_PHONE_STATE");
            }
            if (!(i2 == 0)) {
                if (this.h == null || this.i == null || this.r <= 0) {
                    return false;
                }
                return true;
            }
        }
        if (this.h == null || this.i == null || (obj = this.f) == null) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.telephony.TelephonyDisplayInfo");
        int networkType = ((TelephonyDisplayInfo) obj).getNetworkType();
        if (networkType == 18) {
            if ((this.s == networkType || this.r == networkType) && ((i = this.r) == 13 || i == 20)) {
                return true;
            }
            return false;
        } else if (this.r == networkType || this.s == networkType) {
            return true;
        } else {
            return false;
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

    public final void a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "telephonyDisplayInfo");
        this.d++;
        this.f = obj;
        this.l = System.currentTimeMillis();
    }

    public final boolean a(c3 c3Var) {
        if (c3Var != null && this.m == c3Var.m && this.n == c3Var.n && this.o == c3Var.o && this.p == c3Var.p && this.l == c3Var.l && this.q == c3Var.q) {
            return true;
        }
        return false;
    }

    public final c3 a() {
        e3 e3Var = new e3(this.t, this.u, this.v);
        e3Var.d = this.d;
        e3Var.g = this.g;
        e3Var.h = this.h;
        e3Var.i = this.i;
        e3Var.j = this.j;
        e3Var.f = this.f;
        e3Var.m = this.m;
        e3Var.n = this.n;
        e3Var.o = this.o;
        e3Var.p = this.p;
        e3Var.l = this.l;
        e3Var.q = this.q;
        e3Var.r = this.r;
        e3Var.s = this.s;
        e3Var.k = this.k;
        return e3Var;
    }
}
