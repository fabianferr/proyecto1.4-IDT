package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MNSIBuilder.kt */
public abstract class c3 {
    public final Context a;
    public final int b;
    public final int c;
    public int d;
    public boolean e;
    public Object f;
    public List<? extends CellInfo> g;
    public SignalStrength h;
    public ServiceState i;
    public CellLocation j;
    public NetworkInfoSnapshot k;
    public long l = -1;
    public long m = -1;
    public long n = -1;
    public long o = -1;
    public long p = -1;
    public long q = -1;
    public int r = Integer.MIN_VALUE;
    public int s = Integer.MIN_VALUE;

    /* compiled from: MNSIBuilder.kt */
    public static final class a {
        public static c3 a(Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT < 30) {
                return new d3(context, i, i2);
            }
            return new e3(context, i, i2);
        }
    }

    public c3(Context context, int i2, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = i2;
        this.c = i3;
    }

    public abstract c3 a();

    public abstract void a(CellLocation cellLocation);

    public abstract void a(ServiceState serviceState);

    public abstract void a(SignalStrength signalStrength);

    public abstract void a(NetworkInfoSnapshot networkInfoSnapshot);

    public abstract void a(Object obj);

    public abstract void a(List<? extends CellInfo> list);

    public abstract boolean a(c3 c3Var);

    public final boolean a(String str) {
        Pair<String, String> pair;
        Integer num = null;
        if (Build.VERSION.SDK_INT < 30) {
            List<? extends CellInfo> list = this.g;
            CellInfo a2 = list != null ? m4.a(list) : null;
            if (!(a2 instanceof CellInfoCdma)) {
                pair = m4.a(a2);
            } else if (str == null) {
                return false;
            } else {
                return StringsKt.equals(str, "CDMA", true);
            }
        } else if (!m4.e(this.i)) {
            pair = m4.b(this.i);
        } else if (str == null) {
            return false;
        } else {
            return StringsKt.equals(str, "CDMA", true);
        }
        NetworkInfoSnapshot networkInfoSnapshot = this.k;
        Integer networkMcc = networkInfoSnapshot != null ? networkInfoSnapshot.getNetworkMcc() : null;
        NetworkInfoSnapshot networkInfoSnapshot2 = this.k;
        Integer networkMnc = networkInfoSnapshot2 != null ? networkInfoSnapshot2.getNetworkMnc() : null;
        if (!m4.a(pair)) {
            return false;
        }
        Intrinsics.checkNotNull(pair);
        String first = pair.getFirst();
        Integer valueOf = first != null ? Integer.valueOf(Integer.parseInt(first)) : null;
        String second = pair.getSecond();
        if (second != null) {
            num = Integer.valueOf(Integer.parseInt(second));
        }
        if (networkMnc == null || networkMcc == null || valueOf == null || num == null || !Intrinsics.areEqual((Object) networkMcc, (Object) valueOf) || !Intrinsics.areEqual((Object) networkMnc, (Object) num)) {
            return false;
        }
        return true;
    }

    public final long b() {
        return this.m;
    }

    public final long c() {
        return this.p;
    }

    public Context d() {
        return this.a;
    }

    public final int e() {
        return this.d;
    }

    public final List<CellInfo> f() {
        return this.g;
    }

    public final CellLocation g() {
        return this.j;
    }

    public final NetworkInfoSnapshot h() {
        return this.k;
    }

    public final ServiceState i() {
        return this.i;
    }

    public final SignalStrength j() {
        return this.h;
    }

    public final Object k() {
        return this.f;
    }

    public final long l() {
        return this.o;
    }

    public final long m() {
        return this.n;
    }

    public int n() {
        return this.c;
    }

    public int o() {
        return this.b;
    }

    public final long p() {
        return this.l;
    }

    public abstract boolean q();

    public final boolean r() {
        NetworkInfoSnapshot networkInfoSnapshot = this.k;
        Integer num = null;
        Integer voiceNetworkType = networkInfoSnapshot != null ? networkInfoSnapshot.getVoiceNetworkType() : null;
        NetworkInfoSnapshot networkInfoSnapshot2 = this.k;
        if (networkInfoSnapshot2 != null) {
            num = networkInfoSnapshot2.getDataNetworkType();
        }
        int i2 = this.r;
        if (voiceNetworkType != null && i2 == voiceNetworkType.intValue()) {
            int i3 = this.s;
            if (num != null && i3 == num.intValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean s() {
        return this.e;
    }

    public final void t() {
        this.e = true;
    }

    public final String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        String a2 = a(this.m);
        sb.append(" cellInfo " + a2);
        String a3 = a(this.n);
        sb.append(" signalStrength " + a3);
        String a4 = a(this.o);
        sb.append(" serviceState " + a4);
        String a5 = a(this.p);
        sb.append(" cellLocation " + a5);
        String a6 = a(this.l);
        sb.append(" telephonyDisplayInfo " + a6);
        String a7 = a(this.q);
        sb.append(" networkInfo " + a7);
        sb.append(property);
        long j2 = this.m;
        sb.append(" cellInfo " + j2);
        long j3 = this.n;
        sb.append(" signalStrength " + j3);
        long j4 = this.o;
        sb.append(" serviceState " + j4);
        long j5 = this.p;
        sb.append(" cellLocation " + j5);
        long j6 = this.l;
        sb.append(" telephonyDisplayInfo " + j6);
        long j7 = this.q;
        sb.append(" networkInfo " + j7);
        sb.append(property);
        List<? extends CellInfo> list = this.g;
        sb.append(" newestCellInfo=" + list);
        SignalStrength signalStrength = this.h;
        sb.append(" newestSignalStrength=" + signalStrength);
        ServiceState serviceState = this.i;
        sb.append(" newestServiceState=" + serviceState);
        CellLocation cellLocation = this.j;
        sb.append(" newestcellLocation=" + cellLocation);
        Object obj = this.f;
        sb.append(" newestTelephonyDisplayInfo=" + obj);
        NetworkInfoSnapshot networkInfoSnapshot = this.k;
        sb.append(" newestNetworkInfo=" + networkInfoSnapshot);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public static String a(long j2) {
        String format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ", Locale.US).format(new Date(j2));
        Intrinsics.checkNotNullExpressionValue(format, "format.format(dateTime)");
        return format;
    }
}
