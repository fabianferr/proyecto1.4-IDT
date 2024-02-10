package com.umlaut.crowd.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.umlaut.crowd.CCS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.net.WebApiClient;
import com.umlaut.crowd.net.WebApiResponse;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class g3 {
    private static final boolean f = false;
    private static final String g = "g3";
    private static final String h = "p3insgeoip";
    private static final String i = "P3INS_PFK_GEOIP_CACHE";
    private static final String j = "P3INS_PFK_GEOIP_TIMESTAMP";
    private static final String k = "isplocinfo";
    private static final String l = "anonymize";
    private static final int m = 3600000;
    private long a;
    private long b;
    /* access modifiers changed from: private */
    public final AtomicBoolean c;
    private SharedPreferences d;
    private b4 e;

    private class b implements Runnable {
        private final DRI a;
        private final DWI b;

        b(DRI dri, DWI dwi) {
            this.a = dri;
            this.b = dwi;
        }

        public void run() {
            g3.this.a(this.a, this.b);
            g3.this.c.set(false);
        }
    }

    private static final class c {
        static final g3 a = new g3();

        private c() {
        }
    }

    public e4 b(DRI dri, DWI dwi, boolean z) {
        String str;
        IISR iisr;
        DRI dri2 = dri;
        DWI dwi2 = dwi;
        e4 e4Var = new e4();
        long min = Math.min(CCS.a, ((long) Math.pow((double) this.a, 2.0d)) * 1000);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < this.b + min) {
            return e4Var;
        }
        if (z) {
            try {
                str = InsightCore.getInsightConfig().D0() + k;
            } catch (IOException unused) {
            }
        } else {
            str = InsightCore.getInsightConfig().D0() + "isplocinfo?anonymize=false";
        }
        WebApiResponse sendJsonRequest = WebApiClient.sendJsonRequest(WebApiClient.RequestMethod.GET, str);
        if (sendJsonRequest.responseCode == 200 && sendJsonRequest.content.length() > 0 && (iisr = (IISR) JsonUtils.fromJson(sendJsonRequest.content, IISR.class, true)) != null) {
            long timeInMillis = TimeServer.getTimeInMillis();
            e4Var.AutonomousSystemNumber = aa.a(iisr.AutonomousSystemNumber);
            e4Var.AutonomousSystemOrganization = aa.a(iisr.AutonomousSystemOrganization);
            e4Var.IpAddress = aa.a(iisr.IpAddress);
            e4Var.IspName = aa.a(iisr.IspName);
            e4Var.IspOrganizationalName = aa.a(iisr.IspOrganizationalName);
            e4Var.SuccessfulIspLookup = true;
            long j2 = timeInMillis;
            e4Var.ipLocationData = new b4(iisr.Latitude, iisr.Longitude, iisr.Accuracy, j2);
            synchronized (this) {
                this.e = e4Var.ipLocationData;
            }
            long j3 = j2;
            if (j3 < b() || j3 > b() + InsightCore.getInsightConfig().A0()) {
                a();
                a(j3);
            }
            if (dwi2 != null) {
                a(a(dwi2, dri2), e4Var);
            } else if (dri2.ConnectionType == ConnectionTypes.Mobile) {
                a(a(dri), e4Var);
            } else {
                a(b(dri), e4Var);
            }
            this.b = 0;
            this.a = 0;
        }
        if (!e4Var.SuccessfulIspLookup) {
            this.b = elapsedRealtime;
            this.a++;
        }
        e4Var.ipLocationData = null;
        return e4Var;
    }

    private g3() {
        this.e = null;
        this.c = new AtomicBoolean(false);
    }

    public static g3 a(Context context) {
        g3 g3Var = c.a;
        if (g3Var.d == null) {
            g3Var.d = context.getApplicationContext().getSharedPreferences(h, 0);
        }
        return g3Var;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umlaut.crowd.internal.b4 a(boolean r3) {
        /*
            r2 = this;
            com.umlaut.crowd.internal.b4 r0 = r2.e
            if (r0 != 0) goto L_0x0017
            com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.DRI r0 = r0.getRadioInfoForDefaultDataSim()
            com.umlaut.crowd.internal.ee r1 = com.umlaut.crowd.InsightCore.getWifiController()
            com.umlaut.crowd.internal.DWI r1 = r1.getWifiInfo()
            r2.a(r0, r1, r3)
        L_0x0017:
            com.umlaut.crowd.internal.b4 r3 = new com.umlaut.crowd.internal.b4
            r3.<init>()
            com.umlaut.crowd.internal.b4 r0 = r2.e
            if (r0 == 0) goto L_0x0031
            monitor-enter(r2)
            com.umlaut.crowd.internal.b4 r0 = r2.e     // Catch:{ Exception -> 0x002d }
            java.lang.Object r0 = r0.clone()     // Catch:{ Exception -> 0x002d }
            com.umlaut.crowd.internal.b4 r0 = (com.umlaut.crowd.internal.b4) r0     // Catch:{ Exception -> 0x002d }
            r3 = r0
            goto L_0x002d
        L_0x002b:
            r3 = move-exception
            goto L_0x002f
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x002b }
            goto L_0x0031
        L_0x002f:
            monitor-exit(r2)     // Catch:{ all -> 0x002b }
            throw r3
        L_0x0031:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.g3.a(boolean):com.umlaut.crowd.internal.b4");
    }

    public e4 a(DRI dri, DWI dwi, boolean z) {
        e4 e4Var;
        ConnectionTypes connectionTypes = dri.ConnectionType;
        ConnectionTypes connectionTypes2 = ConnectionTypes.WiFi;
        if (connectionTypes == connectionTypes2) {
            e4Var = dwi != null ? a(a(dwi, dri)) : null;
        } else if (connectionTypes == ConnectionTypes.Mobile) {
            e4Var = a(a(dri));
        } else {
            e4Var = a(b(dri));
        }
        synchronized (this) {
            if (e4Var != null) {
                this.e = e4Var.ipLocationData;
            }
        }
        long timeInMillis = TimeServer.getTimeInMillis();
        if ((e4Var == null || timeInMillis > this.e.d + InsightCore.getInsightConfig().C0() || timeInMillis < this.e.d) && z && this.c.compareAndSet(false, true)) {
            if (dri.ConnectionType != connectionTypes2) {
                dwi = null;
            }
            ThreadManager.getInstance().getCachedThreadPool().execute(new b(dri, dwi));
        }
        if (e4Var == null) {
            e4Var = new e4();
        }
        e4Var.ipLocationData = null;
        return e4Var;
    }

    public e4 a(DRI dri, DWI dwi) {
        return b(dri, dwi, true);
    }

    public static boolean a(ConnectionTypes connectionTypes) {
        ConnectionTypes connectionTypes2 = ConnectionTypes.Mobile;
        return !(connectionTypes == connectionTypes2 || connectionTypes == ConnectionTypes.Unknown) || (InsightCore.getInsightConfig().B0() && connectionTypes == connectionTypes2);
    }

    private e4 a(String str) {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("P3INS_PFK_GEOIP_CACHE_" + str, "");
            if (!string.isEmpty()) {
                return (e4) JsonUtils.fromJson(string, e4.class, true);
            }
        }
        return null;
    }

    private void a(String str, e4 e4Var) {
        if (this.d != null) {
            String json = JsonUtils.toJson((Object) e4Var, (Class<?>) e4.class);
            SharedPreferences.Editor edit = this.d.edit();
            edit.putString("P3INS_PFK_GEOIP_CACHE_" + str, json).apply();
        }
    }

    private void a() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    private void a(long j2) {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(j, j2).apply();
        }
    }

    private String a(DWI dwi, DRI dri) {
        String str;
        String str2 = dwi.DefaultGatewayMacAddress;
        if (str2 == null || str2.isEmpty()) {
            String str3 = dwi.WifiBSSID_Full;
            str = (str3 == null || str3.isEmpty()) ? "UNKNOWN_WIFI_DEFAULT_CACHE" : dwi.WifiBSSID_Full;
        } else {
            str = dwi.DefaultGatewayMacAddress;
        }
        if (dri.IsVpn != 1) {
            return str;
        }
        return str + "_VPN";
    }

    private String a(DRI dri) {
        String str = "MOBILE_" + dri.MCC + "_" + dri.MNC + "_" + l7.a(dri.NetworkType, dri.NrState, dri.DisplayNetworkType).name();
        if (dri.IsVpn != 1) {
            return str;
        }
        return str + "_VPN";
    }

    private long b() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(j, 0);
        }
        return 0;
    }

    private String b(DRI dri) {
        String name = dri.ConnectionType.name();
        if (dri.IsVpn != 1) {
            return name;
        }
        return name + "_VPN";
    }
}
