package com.teragence.library;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.teragence.client.i;
import com.teragence.client.service.k;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class w1 extends PhoneStateListener implements q1 {
    private static final String k = "com.teragence.library.w1";
    private final TelephonyManager a;
    private final LocationManager b;
    private final Context c;
    private k d;
    private com.teragence.client.a<k> e;
    private boolean[] f = new boolean[5];
    private boolean g = false;
    private PhoneStateListener h;
    private LocationListener i;
    private LocationListener j;

    class a extends t1 {
        a() {
        }

        public void onLocationChanged(Location location) {
            w1.this.a(location);
        }
    }

    class b extends t1 {
        b() {
        }

        public void onLocationChanged(Location location) {
            w1.this.a(location);
        }
    }

    public w1(Context context) {
        this.a = (TelephonyManager) context.getSystemService("phone");
        this.b = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        this.c = context;
        this.d = new k();
    }

    private String a(String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(Pattern.quote(str2) + "(.*?)" + Pattern.quote(str3)).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(Location location) {
        String str;
        String str2;
        k kVar = this.d;
        if (kVar != null) {
            kVar.a = location.getLatitude();
            this.d.b = location.getLongitude();
            this.d.c = location.getAltitude();
            this.d.d = location.getAccuracy();
            if (Build.VERSION.SDK_INT >= 26) {
                this.d.e = location.getVerticalAccuracyMeters();
            }
        }
        if (!this.g || location.getProvider().equals("gps")) {
            a(u1.Location);
            f();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            str2 = k;
            str = String.format(Locale.ENGLISH, "phone location update: %s %f %f (%f, %f)", new Object[]{location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getVerticalAccuracyMeters())});
        } else {
            str2 = k;
            str = String.format(Locale.ENGLISH, "phone location update: %s %f %f (%f)", new Object[]{location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Float.valueOf(location.getAccuracy())});
        }
        i.a(str2, str);
    }

    private void a(u1 u1Var) {
        this.f[u1Var.a()] = true;
        boolean[] zArr = this.f;
        int length = zArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (zArr[i2]) {
                i2++;
            } else {
                return;
            }
        }
        a();
    }

    private void a(JSONObject jSONObject, Object obj) {
        String str;
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (obj instanceof CellIdentityNr) {
                    CellIdentityNr cellIdentityNr = (CellIdentityNr) obj;
                    String mccString = cellIdentityNr.getMccString();
                    String mncString = cellIdentityNr.getMncString();
                    if (mccString == null) {
                        mccString = "";
                    }
                    if (mncString == null) {
                        mncString = "";
                    }
                    Locale locale = Locale.ENGLISH;
                    jSONObject.put("CELL_INFO_STRING", String.format(locale, "NR:%d:%d:%s:%s:%d", new Object[]{Long.valueOf(cellIdentityNr.getNci()), Integer.valueOf(cellIdentityNr.getPci()), mccString, mncString, Integer.valueOf(cellIdentityNr.getTac())}));
                    jSONObject.put("NR_ARFCN", String.valueOf(cellIdentityNr.getNrarfcn()));
                    return;
                }
            }
            if (obj instanceof CellIdentityLte) {
                CellIdentityLte cellIdentityLte = (CellIdentityLte) obj;
                Locale locale2 = Locale.ENGLISH;
                jSONObject.put("CELL_INFO_STRING", String.format(locale2, "LTE:%d:%d:%d:%d:%d", new Object[]{Integer.valueOf(cellIdentityLte.getCi()), Integer.valueOf(cellIdentityLte.getPci()), Integer.valueOf(cellIdentityLte.getMcc()), Integer.valueOf(cellIdentityLte.getMnc()), Integer.valueOf(cellIdentityLte.getTac())}));
                if (Build.VERSION.SDK_INT >= 24) {
                    str = String.valueOf(cellIdentityLte.getEarfcn());
                    str2 = "LTE_EARFCN";
                } else {
                    return;
                }
            } else if (obj instanceof CellIdentityWcdma) {
                CellIdentityWcdma cellIdentityWcdma = (CellIdentityWcdma) obj;
                Locale locale3 = Locale.ENGLISH;
                jSONObject.put("CELL_INFO_STRING", String.format(locale3, "WCDMA:%d:%d:%d:%d:%d", new Object[]{Integer.valueOf(cellIdentityWcdma.getCid()), Integer.valueOf(cellIdentityWcdma.getLac()), Integer.valueOf(cellIdentityWcdma.getMcc()), Integer.valueOf(cellIdentityWcdma.getMnc()), Integer.valueOf(cellIdentityWcdma.getPsc())}));
                if (Build.VERSION.SDK_INT >= 24) {
                    str = String.valueOf(cellIdentityWcdma.getUarfcn());
                    str2 = "WCDMA_UARFCN";
                } else {
                    return;
                }
            } else if (obj instanceof CellIdentityCdma) {
                CellIdentityCdma cellIdentityCdma = (CellIdentityCdma) obj;
                Locale locale4 = Locale.ENGLISH;
                jSONObject.put("CELL_INFO_STRING", String.format(locale4, "CDMA:%d:%d:%d", new Object[]{Integer.valueOf(cellIdentityCdma.getBasestationId()), Integer.valueOf(cellIdentityCdma.getSystemId()), Integer.valueOf(cellIdentityCdma.getNetworkId())}));
                return;
            } else if (obj instanceof CellIdentityGsm) {
                CellIdentityGsm cellIdentityGsm = (CellIdentityGsm) obj;
                Locale locale5 = Locale.ENGLISH;
                jSONObject.put("CELL_INFO_STRING", String.format(locale5, "GSM:%d:%d:%d:%d:%d", new Object[]{Integer.valueOf(cellIdentityGsm.getCid()), Integer.valueOf(cellIdentityGsm.getLac()), Integer.valueOf(cellIdentityGsm.getMcc()), Integer.valueOf(cellIdentityGsm.getMnc()), Integer.valueOf(cellIdentityGsm.getPsc())}));
                if (Build.VERSION.SDK_INT >= 24) {
                    str = String.valueOf(cellIdentityGsm.getArfcn());
                    str2 = "GSM_ARFCN";
                } else {
                    return;
                }
            } else {
                return;
            }
            jSONObject.put(str2, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean b() {
        return Build.VERSION.SDK_INT < 23 || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private void c() {
        Map<String, Object> map = this.d.p;
        map.remove("GSM_ARFCN");
        map.remove("CDMA_EVDO_RSSI");
        map.remove("CDMA_RSSI");
        map.remove("CDMA_EVDO_SNR");
        map.remove("CDMA_EVDO_ECIO");
        map.remove("WCDMA_UARFCN");
        map.remove("LTE_CQI");
        map.remove("LTE_RSRQ");
        map.remove("LTE_RSSNR");
        map.remove("TIMING_ADVANCE");
        map.remove("LTE_EARFCN");
        map.remove("NR_ARFCN");
        map.remove("NR_SS_SINR");
        map.remove("NR_SS_RSRQ");
        map.remove("NR_SS_RSRP");
        map.remove("NR_CSI_SINR");
        map.remove("NR_CSI_RSRQ");
        map.remove("NR_CSI_RSRP");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0054, code lost:
        if (r13.b.isProviderEnabled("network") != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        if (r13.b.isProviderEnabled("network") != false) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r13 = this;
            java.lang.String r0 = k
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            boolean r3 = r13.g
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "looking for location: fineLocation: %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            com.teragence.client.i.a((java.lang.String) r0, (java.lang.String) r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            java.lang.String r5 = "gps"
            java.lang.String r6 = "network"
            if (r2 < r3) goto L_0x0057
            boolean r2 = r13.g
            if (r2 == 0) goto L_0x0044
            android.content.Context r2 = r13.c
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            int r2 = r2.checkCallingOrSelfPermission(r3)
            if (r2 != 0) goto L_0x0044
            android.location.LocationManager r2 = r13.b
            boolean r2 = r2.isProviderEnabled(r5)
            if (r2 == 0) goto L_0x0044
            android.location.LocationManager r7 = r13.b
            android.location.LocationListener r12 = r13.j
            java.lang.String r8 = "gps"
            r9 = 2000(0x7d0, double:9.88E-321)
            r11 = 0
            r7.requestLocationUpdates(r8, r9, r11, r12)
            r4 = 1
        L_0x0044:
            android.content.Context r2 = r13.c
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            int r2 = r2.checkCallingOrSelfPermission(r3)
            if (r2 != 0) goto L_0x0085
            android.location.LocationManager r2 = r13.b
            boolean r2 = r2.isProviderEnabled(r6)
            if (r2 == 0) goto L_0x0085
            goto L_0x0078
        L_0x0057:
            boolean r2 = r13.g
            if (r2 == 0) goto L_0x0070
            android.location.LocationManager r2 = r13.b
            boolean r2 = r2.isProviderEnabled(r5)
            if (r2 == 0) goto L_0x0070
            android.location.LocationManager r7 = r13.b
            android.location.LocationListener r12 = r13.j
            java.lang.String r8 = "gps"
            r9 = 2000(0x7d0, double:9.88E-321)
            r11 = 0
            r7.requestLocationUpdates(r8, r9, r11, r12)
            r4 = 1
        L_0x0070:
            android.location.LocationManager r2 = r13.b
            boolean r2 = r2.isProviderEnabled(r6)
            if (r2 == 0) goto L_0x0085
        L_0x0078:
            android.location.LocationManager r5 = r13.b
            android.location.LocationListener r10 = r13.i
            java.lang.String r6 = "network"
            r7 = 2000(0x7d0, double:9.88E-321)
            r9 = 0
            r5.requestLocationUpdates(r6, r7, r9, r10)
            goto L_0x0086
        L_0x0085:
            r1 = r4
        L_0x0086:
            if (r1 != 0) goto L_0x0092
            java.lang.String r1 = "looking for location: no location permissions, or no provider :("
            com.teragence.client.i.a((java.lang.String) r0, (java.lang.String) r1)
            com.teragence.library.u1 r0 = com.teragence.library.u1.Location
            r13.a((com.teragence.library.u1) r0)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.w1.d():void");
    }

    private void e() {
        int i2;
        if (Build.VERSION.SDK_INT < 23) {
            i2 = 1281 | 16;
        } else if (this.c.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            i2 = 1297;
        } else {
            i.a(k, "not gathering cell location info, no permission");
            a(u1.Cell);
            a(u1.CellInfo);
            i2 = 257;
        }
        try {
            if (Build.VERSION.SDK_INT >= 30 && this.c.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                i2 |= 1048576;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.a.listen(this.h, i2);
        } catch (Exception e3) {
            i.a(k, String.format(Locale.ENGLISH, "TelehonyManger; unable to listen for %d", new Object[]{Integer.valueOf(i2)}), e3);
            a(u1.Cell);
            a(u1.CellInfo);
        }
    }

    private void f() {
        try {
            this.b.removeUpdates(this.j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.b.removeUpdates(this.i);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void g() {
        this.a.listen(this.h, 0);
    }

    public void a() {
        f();
        g();
        k kVar = this.d;
        float f2 = kVar.e;
        if (f2 > 0.0f) {
            kVar.p.put("VERTICAL_ACCURACY", String.valueOf(f2));
        }
        if (this.e != null) {
            i.a(k, String.format("proceeding with: %s", new Object[]{Arrays.toString(this.f)}));
            this.e.a(this.d);
        }
        this.f = new boolean[5];
        this.e = null;
        this.g = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0046 A[SYNTHETIC, Splitter:B:11:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.teragence.client.a<com.teragence.client.service.k> r4, boolean r5) {
        /*
            r3 = this;
            r3.e = r4
            r3.g = r5
            r4 = 5
            boolean[] r4 = new boolean[r4]
            r3.f = r4
            com.teragence.client.service.k r4 = new com.teragence.client.service.k
            r4.<init>()
            r3.d = r4
            com.teragence.library.x1 r4 = new com.teragence.library.x1
            com.teragence.library.v1 r5 = new com.teragence.library.v1
            r5.<init>(r3)
            r4.<init>(r5)
            r3.h = r4
            com.teragence.library.w1$a r4 = new com.teragence.library.w1$a
            r4.<init>()
            r3.i = r4
            com.teragence.library.w1$b r4 = new com.teragence.library.w1$b
            r4.<init>()
            r3.j = r4
            r4 = 1
            r5 = 0
            android.app.ActivityManager$RunningAppProcessInfo r0 = new android.app.ActivityManager$RunningAppProcessInfo     // Catch:{ Exception -> 0x0042 }
            r0.<init>()     // Catch:{ Exception -> 0x0042 }
            android.app.ActivityManager.getMyMemoryState(r0)     // Catch:{ Exception -> 0x0042 }
            int r1 = r0.importance     // Catch:{ Exception -> 0x0042 }
            r2 = 100
            if (r1 == r2) goto L_0x0043
            int r0 = r0.importance     // Catch:{ Exception -> 0x0042 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0042:
        L_0x0043:
            r0 = 0
        L_0x0044:
            if (r0 == 0) goto L_0x0058
            android.content.Context r0 = r3.c     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = "MySP"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = "manuallyStopped"
            boolean r0 = r0.getBoolean(r1, r5)     // Catch:{ Exception -> 0x0056 }
            r4 = r4 ^ r0
            goto L_0x0058
        L_0x0056:
            r4 = 0
        L_0x0058:
            if (r4 == 0) goto L_0x005e
            r3.d()
            goto L_0x006b
        L_0x005e:
            java.lang.String r4 = k
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r0 = "Background location not allowed"
            java.lang.String r5 = java.lang.String.format(r0, r5)
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r5)
        L_0x006b:
            r3.e()
            com.teragence.client.service.k r4 = r3.d
            android.telephony.TelephonyManager r5 = r3.a
            java.lang.String r5 = r5.getNetworkCountryIso()
            r4.m = r5
            com.teragence.client.service.k r4 = r3.d
            android.telephony.TelephonyManager r5 = r3.a
            java.lang.String r5 = r5.getNetworkOperator()
            r4.n = r5
            com.teragence.client.service.k r4 = r3.d
            android.telephony.TelephonyManager r5 = r3.a
            java.lang.String r5 = r5.getNetworkOperatorName()
            r4.o = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.w1.a(com.teragence.client.a, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02a8, code lost:
        r0.put(r7, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCellInfoChanged(java.util.List<android.telephony.CellInfo> r29) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.lang.String r3 = ""
            com.teragence.client.service.k r0 = r1.d
            if (r0 == 0) goto L_0x0644
            if (r2 == 0) goto L_0x0644
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r0 < r4) goto L_0x0028
            r0 = 0
        L_0x0013:
            int r7 = r29.size()
            if (r0 >= r7) goto L_0x0028
            java.lang.Object r7 = r2.get(r0)
            android.telephony.CellInfo r7 = (android.telephony.CellInfo) r7
            boolean r7 = r7 instanceof android.telephony.CellInfoNr
            if (r7 == 0) goto L_0x0025
            r7 = 1
            goto L_0x0029
        L_0x0025:
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0028:
            r7 = 0
        L_0x0029:
            com.teragence.client.service.k r0 = r1.d     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            com.teragence.library.s1 r8 = new com.teragence.library.s1     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            android.telephony.TelephonyManager r9 = r1.a     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            int r9 = r9.getNetworkType()     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            android.content.Context r10 = r1.c     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            r8.<init>(r9, r10)     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            java.lang.String r8 = r8.toString()     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            r0.f = r8     // Catch:{ SecurityException -> 0x0044, Exception -> 0x003f }
            goto L_0x0048
        L_0x003f:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0048
        L_0x0044:
            com.teragence.client.service.k r0 = r1.d
            r0.f = r3
        L_0x0048:
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
            r0 = 0
        L_0x004e:
            int r9 = r29.size()
            java.lang.String r10 = "CDMA_RSSI"
            java.lang.String r11 = "CDMA_EVDO_SNR"
            java.lang.String r12 = "CDMA_EVDO_ECIO"
            java.lang.String r13 = "NR_SS_SINR"
            java.lang.String r14 = "NR_SS_RSRQ"
            java.lang.String r15 = "NR_SS_RSRP"
            java.lang.String r5 = "NR_CSI_SINR"
            java.lang.String r6 = "NR_CSI_RSRQ"
            java.lang.String r4 = "NR_CSI_RSRP"
            r19 = r3
            java.lang.String r3 = "TIMING_ADVANCE"
            r20 = r8
            java.lang.String r8 = "IS_REGISTERED"
            if (r0 >= r9) goto L_0x03e9
            java.lang.Object r9 = r2.get(r0)
            android.telephony.CellInfo r9 = (android.telephony.CellInfo) r9
            int r2 = android.os.Build.VERSION.SDK_INT
            r21 = 4
            r22 = r0
            r24 = 2
            r25 = r10
            r10 = 29
            if (r2 < r10) goto L_0x014f
            boolean r2 = r9 instanceof android.telephony.CellInfoNr
            if (r2 == 0) goto L_0x014f
            r2 = r9
            android.telephony.CellInfoNr r2 = (android.telephony.CellInfoNr) r2
            android.telephony.CellIdentity r7 = r2.getCellIdentity()
            android.telephony.CellIdentityNr r7 = (android.telephony.CellIdentityNr) r7
            java.lang.String r10 = r7.getMccString()
            java.lang.String r22 = r7.getMncString()
            if (r10 != 0) goto L_0x009b
            r10 = r19
        L_0x009b:
            if (r22 != 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r19 = r22
        L_0x00a0:
            com.teragence.client.service.k r0 = r1.d
            r26 = r11
            java.util.Locale r11 = java.util.Locale.ENGLISH
            r27 = r12
            r12 = 5
            java.lang.Object[] r12 = new java.lang.Object[r12]
            long r22 = r7.getNci()
            java.lang.Long r22 = java.lang.Long.valueOf(r22)
            r17 = 0
            r12[r17] = r22
            int r22 = r7.getPci()
            java.lang.Integer r22 = java.lang.Integer.valueOf(r22)
            r16 = 1
            r12[r16] = r22
            r12[r24] = r10
            r10 = 3
            r12[r10] = r19
            int r10 = r7.getTac()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r12[r21] = r10
            java.lang.String r10 = "NR:%d:%d:%s:%s:%d"
            java.lang.String r10 = java.lang.String.format(r11, r10, r12)
            r0.i = r10
            com.teragence.client.service.k r0 = r1.d
            android.telephony.CellSignalStrength r10 = r2.getCellSignalStrength()
            int r10 = r10.getDbm()
            r0.k = r10
            r28.c()     // Catch:{ Exception -> 0x00e9 }
        L_0x00e9:
            com.teragence.client.service.k r0 = r1.d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p
            android.telephony.CellSignalStrength r2 = r2.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r2 = (android.telephony.CellSignalStrengthNr) r2
            int r10 = r2.getCsiRsrp()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.put(r4, r10)
            int r10 = r2.getCsiRsrq()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.put(r6, r10)
            int r10 = r2.getCsiSinr()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.put(r5, r10)
            int r10 = r2.getSsRsrp()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.put(r15, r10)
            int r10 = r2.getSsRsrq()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.put(r14, r10)
            int r2 = r2.getSsSinr()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.put(r13, r2)
            int r2 = r7.getNrarfcn()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r7 = "NR_ARFCN"
            r0.put(r7, r2)
            boolean r2 = r9.isRegistered()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.put(r8, r2)
            goto L_0x03ef
        L_0x014f:
            r26 = r11
            r27 = r12
            if (r7 == 0) goto L_0x0157
            goto L_0x03dd
        L_0x0157:
            boolean r0 = r9 instanceof android.telephony.CellInfoLte
            if (r0 == 0) goto L_0x0226
            r0 = r9
            android.telephony.CellInfoLte r0 = (android.telephony.CellInfoLte) r0
            android.telephony.CellIdentityLte r2 = r0.getCellIdentity()
            com.teragence.client.service.k r7 = r1.d
            java.util.Locale r10 = java.util.Locale.ENGLISH
            r11 = 5
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r12 = r2.getCi()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r17 = 0
            r11[r17] = r12
            int r12 = r2.getPci()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r16 = 1
            r11[r16] = r12
            int r12 = r2.getMcc()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r24] = r12
            int r12 = r2.getMnc()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r19 = 3
            r11[r19] = r12
            int r12 = r2.getTac()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r21] = r12
            java.lang.String r12 = "LTE:%d:%d:%d:%d:%d"
            java.lang.String r10 = java.lang.String.format(r10, r12, r11)
            r7.i = r10
            com.teragence.client.service.k r7 = r1.d
            android.telephony.CellSignalStrengthLte r10 = r0.getCellSignalStrength()
            int r10 = r10.getDbm()
            r7.k = r10
            r28.c()     // Catch:{ Exception -> 0x01b9 }
            goto L_0x01ba
        L_0x01b9:
        L_0x01ba:
            com.teragence.client.service.k r7 = r1.d
            java.util.Map<java.lang.String, java.lang.Object> r7 = r7.p
            boolean r9 = r9.isRegistered()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.put(r8, r9)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 24
            if (r9 < r10) goto L_0x01eb
            int r2 = r2.getEarfcn()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r9 = "LTE_EARFCN"
            r7.put(r9, r2)
            android.telephony.CellSignalStrengthLte r2 = r0.getCellSignalStrength()
            int r2 = r2.getTimingAdvance()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r7.put(r3, r2)
        L_0x01eb:
            int r2 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r2 < r9) goto L_0x03ef
            android.telephony.CellSignalStrengthLte r2 = r0.getCellSignalStrength()
            int r2 = r2.getRssnr()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r9 = "LTE_RSSNR"
            r7.put(r9, r2)
            android.telephony.CellSignalStrengthLte r2 = r0.getCellSignalStrength()
            int r2 = r2.getRsrq()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r9 = "LTE_RSRQ"
            r7.put(r9, r2)
            android.telephony.CellSignalStrengthLte r0 = r0.getCellSignalStrength()
            int r0 = r0.getCqi()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "LTE_CQI"
            r7.put(r2, r0)
            goto L_0x03ef
        L_0x0226:
            boolean r0 = r9 instanceof android.telephony.CellInfoWcdma
            if (r0 == 0) goto L_0x02ad
            r0 = r9
            android.telephony.CellInfoWcdma r0 = (android.telephony.CellInfoWcdma) r0
            android.telephony.CellIdentityWcdma r2 = r0.getCellIdentity()
            com.teragence.client.service.k r7 = r1.d
            java.util.Locale r10 = java.util.Locale.ENGLISH
            r11 = 5
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r12 = r2.getCid()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r17 = 0
            r11[r17] = r12
            int r12 = r2.getLac()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r16 = 1
            r11[r16] = r12
            int r12 = r2.getMcc()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r24] = r12
            int r12 = r2.getMnc()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r19 = 3
            r11[r19] = r12
            int r12 = r2.getPsc()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r21] = r12
            java.lang.String r12 = "WCDMA:%d:%d:%d:%d:%d"
            java.lang.String r10 = java.lang.String.format(r10, r12, r11)
            r7.i = r10
            com.teragence.client.service.k r7 = r1.d
            android.telephony.CellSignalStrengthWcdma r0 = r0.getCellSignalStrength()
            int r0 = r0.getDbm()
            r7.k = r0
            r28.c()     // Catch:{ Exception -> 0x0288 }
            goto L_0x0289
        L_0x0288:
        L_0x0289:
            com.teragence.client.service.k r0 = r1.d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p
            boolean r7 = r9.isRegistered()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.put(r8, r7)
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 24
            if (r7 < r9) goto L_0x03ef
            int r2 = r2.getUarfcn()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r7 = "WCDMA_UARFCN"
        L_0x02a8:
            r0.put(r7, r2)
            goto L_0x03ef
        L_0x02ad:
            boolean r0 = r9 instanceof android.telephony.CellInfoCdma
            if (r0 == 0) goto L_0x034d
            r0 = r9
            android.telephony.CellInfoCdma r0 = (android.telephony.CellInfoCdma) r0
            android.telephony.CellIdentityCdma r2 = r0.getCellIdentity()
            com.teragence.client.service.k r7 = r1.d
            java.util.Locale r10 = java.util.Locale.ENGLISH
            r11 = 3
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r12 = r2.getBasestationId()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r17 = 0
            r11[r17] = r12
            int r12 = r2.getSystemId()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r16 = 1
            r11[r16] = r12
            int r2 = r2.getNetworkId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11[r24] = r2
            java.lang.String r2 = "CDMA:%d:%d:%d"
            java.lang.String r2 = java.lang.String.format(r10, r2, r11)
            r7.i = r2
            com.teragence.client.service.k r2 = r1.d
            android.telephony.CellSignalStrengthCdma r7 = r0.getCellSignalStrength()
            int r7 = r7.getDbm()
            r2.k = r7
            r28.c()     // Catch:{ Exception -> 0x02f8 }
        L_0x02f8:
            com.teragence.client.service.k r2 = r1.d
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.p
            android.telephony.CellSignalStrengthCdma r7 = r0.getCellSignalStrength()
            int r7 = r7.getEvdoEcio()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r10 = r27
            r2.put(r10, r7)
            android.telephony.CellSignalStrengthCdma r7 = r0.getCellSignalStrength()
            int r7 = r7.getEvdoSnr()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r11 = r26
            r2.put(r11, r7)
            android.telephony.CellSignalStrengthCdma r7 = r0.getCellSignalStrength()
            int r7 = r7.getCdmaDbm()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r12 = r25
            r2.put(r12, r7)
            android.telephony.CellSignalStrengthCdma r0 = r0.getCellSignalStrength()
            int r0 = r0.getEvdoDbm()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r7 = "CDMA_EVDO_RSSI"
            r2.put(r7, r0)
            boolean r0 = r9.isRegistered()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.put(r8, r0)
            goto L_0x03ef
        L_0x034d:
            r12 = r25
            r11 = r26
            r10 = r27
            boolean r0 = r9 instanceof android.telephony.CellInfoGsm
            if (r0 == 0) goto L_0x03dd
            r0 = r9
            android.telephony.CellInfoGsm r0 = (android.telephony.CellInfoGsm) r0
            android.telephony.CellIdentityGsm r2 = r0.getCellIdentity()
            com.teragence.client.service.k r7 = r1.d
            r25 = r12
            java.util.Locale r12 = java.util.Locale.ENGLISH
            r26 = r11
            r11 = 5
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r19 = r2.getCid()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r17 = 0
            r11[r17] = r19
            int r19 = r2.getLac()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r16 = 1
            r11[r16] = r19
            int r19 = r2.getMcc()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r11[r24] = r19
            int r19 = r2.getMnc()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r22 = 3
            r11[r22] = r19
            int r19 = r2.getPsc()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r11[r21] = r19
            r27 = r10
            java.lang.String r10 = "GSM:%d:%d:%d:%d:%d"
            java.lang.String r10 = java.lang.String.format(r12, r10, r11)
            r7.i = r10
            com.teragence.client.service.k r7 = r1.d
            android.telephony.CellSignalStrengthGsm r0 = r0.getCellSignalStrength()
            int r0 = r0.getDbm()
            r7.k = r0
            r28.c()     // Catch:{ Exception -> 0x03bb }
            goto L_0x03bc
        L_0x03bb:
        L_0x03bc:
            com.teragence.client.service.k r0 = r1.d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p
            boolean r7 = r9.isRegistered()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.put(r8, r7)
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 24
            if (r7 < r9) goto L_0x03ef
            int r2 = r2.getArfcn()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r7 = "GSM_ARFCN"
            goto L_0x02a8
        L_0x03dd:
            int r0 = r22 + 1
            r2 = r29
            r3 = r19
            r8 = r20
            r4 = 29
            goto L_0x004e
        L_0x03e9:
            r25 = r10
            r26 = r11
            r27 = r12
        L_0x03ef:
            r2 = 0
        L_0x03f0:
            int r0 = r29.size()
            if (r2 >= r0) goto L_0x0618
            r7 = r29
            java.lang.Object r0 = r7.get(r2)
            android.telephony.CellInfo r0 = (android.telephony.CellInfo) r0
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            int r10 = android.os.Build.VERSION.SDK_INT
            java.lang.String r11 = "CELL_STRENGTH_DBM"
            r12 = 29
            if (r10 < r12) goto L_0x048c
            boolean r10 = r0 instanceof android.telephony.CellInfoNr
            if (r10 == 0) goto L_0x048c
            r10 = r0
            android.telephony.CellInfoNr r10 = (android.telephony.CellInfoNr) r10
            android.telephony.CellIdentity r18 = r10.getCellIdentity()
            r12 = r18
            android.telephony.CellIdentityNr r12 = (android.telephony.CellIdentityNr) r12
            android.telephony.CellSignalStrength r18 = r10.getCellSignalStrength()
            int r18 = r18.getDbm()
            android.telephony.CellSignalStrength r10 = r10.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r10 = (android.telephony.CellSignalStrengthNr) r10
            r1.a((org.json.JSONObject) r9, (java.lang.Object) r12)     // Catch:{ Exception -> 0x0480 }
            java.lang.String r12 = java.lang.String.valueOf(r18)     // Catch:{ Exception -> 0x0480 }
            r9.put(r11, r12)     // Catch:{ Exception -> 0x0480 }
            int r11 = r10.getCsiRsrp()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0480 }
            r9.put(r4, r11)     // Catch:{ Exception -> 0x0480 }
            int r11 = r10.getCsiRsrq()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0480 }
            r9.put(r6, r11)     // Catch:{ Exception -> 0x0480 }
            int r11 = r10.getCsiSinr()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0480 }
            r9.put(r5, r11)     // Catch:{ Exception -> 0x0480 }
            int r11 = r10.getSsRsrp()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0480 }
            r9.put(r15, r11)     // Catch:{ Exception -> 0x0480 }
            int r11 = r10.getSsRsrq()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0480 }
            r9.put(r14, r11)     // Catch:{ Exception -> 0x0480 }
            int r10 = r10.getSsSinr()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0480 }
            r9.put(r13, r10)     // Catch:{ Exception -> 0x0480 }
            boolean r0 = r0.isRegistered()     // Catch:{ Exception -> 0x0480 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0480 }
            r9.put(r8, r0)     // Catch:{ Exception -> 0x0480 }
            goto L_0x0484
        L_0x0480:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0484:
            r18 = r3
            r3 = r20
            r12 = r27
            goto L_0x060e
        L_0x048c:
            boolean r10 = r0 instanceof android.telephony.CellInfoLte
            if (r10 == 0) goto L_0x050d
            r10 = r0
            android.telephony.CellInfoLte r10 = (android.telephony.CellInfoLte) r10
            android.telephony.CellIdentityLte r12 = r10.getCellIdentity()
            android.telephony.CellSignalStrengthLte r18 = r10.getCellSignalStrength()
            int r18 = r18.getDbm()
            r1.a((org.json.JSONObject) r9, (java.lang.Object) r12)     // Catch:{ Exception -> 0x04b5 }
            java.lang.String r12 = java.lang.String.valueOf(r18)     // Catch:{ Exception -> 0x04b5 }
            r9.put(r11, r12)     // Catch:{ Exception -> 0x04b5 }
            boolean r0 = r0.isRegistered()     // Catch:{ Exception -> 0x04b5 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04b5 }
            r9.put(r8, r0)     // Catch:{ Exception -> 0x04b5 }
            goto L_0x04b9
        L_0x04b5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x04b9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r12 = 24
            if (r0 < r12) goto L_0x04d3
            android.telephony.CellSignalStrengthLte r0 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x04cf }
            int r0 = r0.getTimingAdvance()     // Catch:{ Exception -> 0x04cf }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x04cf }
            r9.put(r3, r0)     // Catch:{ Exception -> 0x04cf }
            goto L_0x04d3
        L_0x04cf:
            r0 = move-exception
            r0.printStackTrace()
        L_0x04d3:
            int r0 = android.os.Build.VERSION.SDK_INT
            r11 = 26
            if (r0 < r11) goto L_0x0541
            android.telephony.CellSignalStrengthLte r0 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x053d }
            int r0 = r0.getRssnr()     // Catch:{ Exception -> 0x053d }
            java.lang.String r11 = "LTE_RSSNR"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x053d }
            r9.put(r11, r0)     // Catch:{ Exception -> 0x053d }
            android.telephony.CellSignalStrengthLte r0 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x053d }
            int r0 = r0.getRsrq()     // Catch:{ Exception -> 0x053d }
            java.lang.String r11 = "LTE_RSRQ"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x053d }
            r9.put(r11, r0)     // Catch:{ Exception -> 0x053d }
            android.telephony.CellSignalStrengthLte r0 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x053d }
            int r0 = r0.getCqi()     // Catch:{ Exception -> 0x053d }
            java.lang.String r10 = "LTE_CQI"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x053d }
            r9.put(r10, r0)     // Catch:{ Exception -> 0x053d }
            goto L_0x0537
        L_0x050d:
            r12 = 24
            boolean r10 = r0 instanceof android.telephony.CellInfoWcdma
            if (r10 == 0) goto L_0x0549
            r10 = r0
            android.telephony.CellInfoWcdma r10 = (android.telephony.CellInfoWcdma) r10
            android.telephony.CellIdentityWcdma r12 = r10.getCellIdentity()
            android.telephony.CellSignalStrengthWcdma r10 = r10.getCellSignalStrength()
            int r10 = r10.getDbm()
            r1.a((org.json.JSONObject) r9, (java.lang.Object) r12)     // Catch:{ Exception -> 0x053d }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x053d }
            r9.put(r11, r10)     // Catch:{ Exception -> 0x053d }
            boolean r0 = r0.isRegistered()     // Catch:{ Exception -> 0x053d }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x053d }
            r9.put(r8, r0)     // Catch:{ Exception -> 0x053d }
        L_0x0537:
            r18 = r3
            r12 = r27
            goto L_0x0609
        L_0x053d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0541:
            r18 = r3
            r3 = r20
            r12 = r27
            goto L_0x060b
        L_0x0549:
            boolean r10 = r0 instanceof android.telephony.CellInfoCdma
            if (r10 == 0) goto L_0x05d1
            r10 = r0
            android.telephony.CellInfoCdma r10 = (android.telephony.CellInfoCdma) r10
            android.telephony.CellIdentityCdma r12 = r10.getCellIdentity()
            android.telephony.CellSignalStrengthCdma r18 = r10.getCellSignalStrength()
            int r18 = r18.getDbm()
            r1.a((org.json.JSONObject) r9, (java.lang.Object) r12)     // Catch:{ Exception -> 0x05c6 }
            java.lang.String r12 = java.lang.String.valueOf(r18)     // Catch:{ Exception -> 0x05c6 }
            r9.put(r11, r12)     // Catch:{ Exception -> 0x05c6 }
            android.telephony.CellSignalStrengthCdma r11 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x05c6 }
            int r11 = r11.getEvdoEcio()     // Catch:{ Exception -> 0x05c6 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x05c6 }
            r12 = r27
            r9.put(r12, r11)     // Catch:{ Exception -> 0x05c0 }
            android.telephony.CellSignalStrengthCdma r11 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x05c0 }
            int r11 = r11.getEvdoSnr()     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x05c0 }
            r18 = r3
            r3 = r26
            r9.put(r3, r11)     // Catch:{ Exception -> 0x05bc }
            android.telephony.CellSignalStrengthCdma r11 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x05bc }
            int r11 = r11.getCdmaDbm()     // Catch:{ Exception -> 0x05bc }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x05bc }
            r26 = r3
            r3 = r25
            r9.put(r3, r11)     // Catch:{ Exception -> 0x05ba }
            android.telephony.CellSignalStrengthCdma r10 = r10.getCellSignalStrength()     // Catch:{ Exception -> 0x05ba }
            int r10 = r10.getEvdoDbm()     // Catch:{ Exception -> 0x05ba }
            java.lang.String r11 = "CDMA_EVDO_RSSI"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x05ba }
            r9.put(r11, r10)     // Catch:{ Exception -> 0x05ba }
            boolean r0 = r0.isRegistered()     // Catch:{ Exception -> 0x05ba }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x05ba }
            r9.put(r8, r0)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0607
        L_0x05ba:
            r0 = move-exception
            goto L_0x05cd
        L_0x05bc:
            r0 = move-exception
            r26 = r3
            goto L_0x05c3
        L_0x05c0:
            r0 = move-exception
            r18 = r3
        L_0x05c3:
            r3 = r25
            goto L_0x05cd
        L_0x05c6:
            r0 = move-exception
            r18 = r3
            r3 = r25
            r12 = r27
        L_0x05cd:
            r0.printStackTrace()
            goto L_0x0607
        L_0x05d1:
            r18 = r3
            r3 = r25
            r12 = r27
            boolean r10 = r0 instanceof android.telephony.CellInfoGsm
            if (r10 == 0) goto L_0x0607
            r10 = r0
            android.telephony.CellInfoGsm r10 = (android.telephony.CellInfoGsm) r10
            r25 = r3
            android.telephony.CellIdentityGsm r3 = r10.getCellIdentity()
            android.telephony.CellSignalStrengthGsm r10 = r10.getCellSignalStrength()
            int r10 = r10.getDbm()
            r1.a((org.json.JSONObject) r9, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0602 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0602 }
            r9.put(r11, r3)     // Catch:{ Exception -> 0x0602 }
            boolean r0 = r0.isRegistered()     // Catch:{ Exception -> 0x0602 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0602 }
            r9.put(r8, r0)     // Catch:{ Exception -> 0x0602 }
            goto L_0x0609
        L_0x0602:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0609
        L_0x0607:
            r25 = r3
        L_0x0609:
            r3 = r20
        L_0x060b:
            r3.put(r9)
        L_0x060e:
            int r2 = r2 + 1
            r20 = r3
            r27 = r12
            r3 = r18
            goto L_0x03f0
        L_0x0618:
            r3 = r20
            com.teragence.client.service.k r0 = r1.d     // Catch:{ Exception -> 0x0624 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p     // Catch:{ Exception -> 0x0624 }
            java.lang.String r2 = "CELL_INFO"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0624 }
            goto L_0x0628
        L_0x0624:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0628:
            com.teragence.client.service.k r0 = r1.d
            java.lang.String r0 = r0.i
            if (r0 == 0) goto L_0x063f
            java.lang.String r2 = k
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r0
            java.lang.String r0 = "cell info info update: %s"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            com.teragence.client.i.a((java.lang.String) r2, (java.lang.String) r0)
        L_0x063f:
            com.teragence.library.u1 r0 = com.teragence.library.u1.CellInfo
            r1.a((com.teragence.library.u1) r0)
        L_0x0644:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.w1.onCellInfoChanged(java.util.List):void");
    }

    public void onCellLocationChanged(CellLocation cellLocation) {
        String format;
        k kVar = this.d;
        if (kVar != null) {
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                format = String.format(Locale.ENGLISH, "GSM:%d:%d", new Object[]{Integer.valueOf(gsmCellLocation.getCid()), Integer.valueOf(gsmCellLocation.getLac())});
            } else {
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    format = String.format(Locale.ENGLISH, "CDMA:%d:%d:%d", new Object[]{Integer.valueOf(cdmaCellLocation.getBaseStationId()), Integer.valueOf(cdmaCellLocation.getNetworkId()), Integer.valueOf(cdmaCellLocation.getSystemId())});
                }
                if (this.a != null && b()) {
                    onCellInfoChanged(this.a.getAllCellInfo());
                }
                i.a(k, String.format("cell info update: %s", new Object[]{this.d.h}));
                a(u1.Cell);
            }
            kVar.h = format;
            try {
                onCellInfoChanged(this.a.getAllCellInfo());
            } catch (SecurityException unused) {
            }
            i.a(k, String.format("cell info update: %s", new Object[]{this.d.h}));
            a(u1.Cell);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006e, code lost:
        if (r8.getOverrideNetworkType() == 0) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDisplayInfoChanged(android.telephony.TelephonyDisplayInfo r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            r1 = 31
            r2 = 3
            r3 = 2
            r4 = 1
            java.lang.String r5 = "NETWORK_OVERRIDE_TYPE"
            if (r0 < r1) goto L_0x0038
            com.teragence.client.service.k r0 = r7.d     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            int r1 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r1 != r4) goto L_0x0016
            goto L_0x004f
        L_0x0016:
            int r1 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r1 != r3) goto L_0x001d
            goto L_0x0058
        L_0x001d:
            int r1 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r1 != r2) goto L_0x0024
            goto L_0x0061
        L_0x0024:
            int r1 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            r2 = 5
            if (r1 != r2) goto L_0x0031
            java.lang.String r8 = "NR_ADVANCED"
        L_0x002d:
            r0.put(r5, r8)     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            goto L_0x007f
        L_0x0031:
            int r8 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r8 != 0) goto L_0x0073
            goto L_0x0070
        L_0x0038:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            r1 = 30
            if (r0 != r1) goto L_0x007f
            super.onDisplayInfoChanged(r8)     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            com.teragence.client.service.k r0 = r7.d     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            int r1 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            int r6 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r6 != r4) goto L_0x0052
        L_0x004f:
            java.lang.String r8 = "LTE_CA"
            goto L_0x002d
        L_0x0052:
            int r4 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r4 != r3) goto L_0x005b
        L_0x0058:
            java.lang.String r8 = "LTE_ADVANCED_PRO"
            goto L_0x002d
        L_0x005b:
            int r3 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r3 != r2) goto L_0x0064
        L_0x0061:
            java.lang.String r8 = "NR_NSA"
            goto L_0x002d
        L_0x0064:
            r2 = 4
            if (r1 != r2) goto L_0x006a
            java.lang.String r8 = "NR_NSA_MMWAVE"
            goto L_0x002d
        L_0x006a:
            int r8 = r8.getOverrideNetworkType()     // Catch:{ SecurityException -> 0x007b, Exception -> 0x0076 }
            if (r8 != 0) goto L_0x0073
        L_0x0070:
            java.lang.String r8 = "NONE"
            goto L_0x002d
        L_0x0073:
            java.lang.String r8 = ""
            goto L_0x002d
        L_0x0076:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x007f
        L_0x007b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.w1.onDisplayInfoChanged(android.telephony.TelephonyDisplayInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c9 A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d1 A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0230 A[Catch:{ Exception -> 0x025c }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0275 A[Catch:{ Exception -> 0x0319 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02a5 A[Catch:{ Exception -> 0x0319 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onServiceStateChanged(android.telephony.ServiceState r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = ""
            java.lang.String r3 = "nrState="
            java.lang.String r4 = " = "
            java.lang.String r5 = "SERVICE_STATE_IS_SEARCHING"
            java.lang.String r6 = "SERVICE_STATE_ROAMING"
            java.lang.String r7 = "{"
            java.lang.String r8 = " "
            java.lang.String r9 = "="
            java.lang.String r10 = "}"
            com.teragence.client.service.k r0 = r1.d
            if (r0 == 0) goto L_0x0355
            boolean r11 = r23.getRoaming()
            if (r11 != 0) goto L_0x0028
            int r11 = r23.getState()
            if (r11 != 0) goto L_0x0028
            r11 = 1
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            r0.l = r11
            com.teragence.client.service.k r0 = r1.d
            android.telephony.TelephonyManager r11 = r1.a
            java.lang.String r11 = r11.getNetworkCountryIso()
            r0.m = r11
            com.teragence.client.service.k r0 = r1.d
            java.lang.String r11 = r23.getOperatorNumeric()
            r0.n = r11
            com.teragence.client.service.k r0 = r1.d
            java.lang.String r11 = r23.getOperatorAlphaLong()
            r0.o = r11
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x032e }
            r14.<init>()     // Catch:{ Exception -> 0x032e }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x032e }
            r15 = 28
            if (r0 < r15) goto L_0x00a8
            java.lang.String r0 = "SERVICE_STATE_CDMA_NETWORK_ID"
            int r15 = r23.getCdmaNetworkId()     // Catch:{ Exception -> 0x032e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r15)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = "SERVICE_STATE_CDMA_SYSTEM_ID"
            int r15 = r23.getCdmaSystemId()     // Catch:{ Exception -> 0x032e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r15)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = "SERVICE_STATE_CHANNEL_NUMBER"
            int r15 = r23.getChannelNumber()     // Catch:{ Exception -> 0x032e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r15)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = "SERVICE_STATE_DUPLEX_MODE"
            int r15 = r23.getDuplexMode()     // Catch:{ Exception -> 0x032e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r15)     // Catch:{ Exception -> 0x032e }
            int[] r0 = r23.getCellBandwidths()     // Catch:{ Exception -> 0x032e }
            if (r0 == 0) goto L_0x00a8
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x032e }
            r0.<init>()     // Catch:{ Exception -> 0x032e }
            int[] r15 = r23.getCellBandwidths()     // Catch:{ Exception -> 0x032e }
            int r12 = r15.length     // Catch:{ Exception -> 0x032e }
            r13 = 0
        L_0x0095:
            if (r13 >= r12) goto L_0x00a3
            r16 = r15[r13]     // Catch:{ Exception -> 0x032e }
            java.lang.String r11 = java.lang.String.valueOf(r16)     // Catch:{ Exception -> 0x032e }
            r0.put(r11)     // Catch:{ Exception -> 0x032e }
            int r13 = r13 + 1
            goto L_0x0095
        L_0x00a3:
            java.lang.String r11 = "SERVICE_STATE_CELL_BANDWIDTHS"
            r14.put(r11, r0)     // Catch:{ Exception -> 0x032e }
        L_0x00a8:
            java.lang.String r0 = "SERVICE_STATE_IS_MANUAL_SELECTION"
            boolean r11 = r23.getIsManualSelection()     // Catch:{ Exception -> 0x032e }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r11)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = "SERVICE_STATE_VOICE_STATE"
            int r11 = r23.getState()     // Catch:{ Exception -> 0x032e }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r11)     // Catch:{ Exception -> 0x032e }
            boolean r0 = r23.getRoaming()     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x032e }
            r14.put(r6, r0)     // Catch:{ Exception -> 0x032e }
            java.lang.String r0 = r23.getOperatorAlphaLong()     // Catch:{ Exception -> 0x032e }
            if (r0 == 0) goto L_0x00dc
            java.lang.String r0 = "SERVICE_STATE_OPERATOR_ALPHA_LONG"
            java.lang.String r11 = r23.getOperatorAlphaLong()     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r11)     // Catch:{ Exception -> 0x032e }
        L_0x00dc:
            java.lang.String r0 = r23.getOperatorAlphaShort()     // Catch:{ Exception -> 0x032e }
            if (r0 == 0) goto L_0x00eb
            java.lang.String r0 = "SERVICE_STATE_OPERATOR_ALPHA_SHORT"
            java.lang.String r11 = r23.getOperatorAlphaShort()     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r11)     // Catch:{ Exception -> 0x032e }
        L_0x00eb:
            java.lang.String r0 = r23.getOperatorNumeric()     // Catch:{ Exception -> 0x032e }
            if (r0 == 0) goto L_0x00fa
            java.lang.String r0 = "SERVICE_STATE_OPERATOR_NUMERIC"
            java.lang.String r11 = r23.getOperatorNumeric()     // Catch:{ Exception -> 0x032e }
            r14.put(r0, r11)     // Catch:{ Exception -> 0x032e }
        L_0x00fa:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x031f }
            r11 = 30
            if (r0 < r11) goto L_0x031d
            boolean r0 = r23.isSearching()     // Catch:{ Exception -> 0x031f }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x031f }
            r14.put(r5, r0)     // Catch:{ Exception -> 0x031f }
            java.util.List r0 = r23.getNetworkRegistrationInfoList()     // Catch:{ Exception -> 0x031f }
            if (r0 == 0) goto L_0x031d
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x031f }
            r11.<init>()     // Catch:{ Exception -> 0x031f }
            java.util.Iterator r12 = r0.iterator()     // Catch:{ Exception -> 0x031f }
        L_0x011a:
            boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x031f }
            if (r0 == 0) goto L_0x030c
            java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x031f }
            r13 = r0
            android.telephony.NetworkRegistrationInfo r13 = (android.telephony.NetworkRegistrationInfo) r13     // Catch:{ Exception -> 0x031f }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x031f }
            r15.<init>()     // Catch:{ Exception -> 0x031f }
            r23 = r12
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x031f }
            java.lang.String r0 = "VoiceSpecificRegistrationInfo { "
            java.lang.String r0 = r1.a(r12, r0, r10)     // Catch:{ Exception -> 0x01b5 }
            if (r0 != 0) goto L_0x0140
            java.lang.String r0 = "VoiceSpecificRegistrationInfo :{ "
            java.lang.String r0 = r1.a(r12, r0, r10)     // Catch:{ Exception -> 0x01b5 }
        L_0x0140:
            if (r0 == 0) goto L_0x01ac
            java.lang.String r0 = r0.replace(r4, r9)     // Catch:{ Exception -> 0x01b5 }
            r16 = r14
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a4 }
            r14.<init>()     // Catch:{ Exception -> 0x01a4 }
            java.lang.String[] r0 = r0.split(r8)     // Catch:{ Exception -> 0x01a4 }
            r17 = r11
            int r11 = r0.length     // Catch:{ Exception -> 0x019e }
            r18 = r5
            r5 = 0
        L_0x0157:
            if (r5 >= r11) goto L_0x0194
            r19 = r11
            r11 = r0[r5]     // Catch:{ Exception -> 0x0192 }
            boolean r20 = r11.contains(r9)     // Catch:{ Exception -> 0x0192 }
            if (r20 == 0) goto L_0x0185
            boolean r20 = r11.contains(r7)     // Catch:{ Exception -> 0x0192 }
            if (r20 != 0) goto L_0x0185
            boolean r20 = r11.contains(r10)     // Catch:{ Exception -> 0x0192 }
            if (r20 != 0) goto L_0x0185
            java.lang.String[] r11 = r11.split(r9)     // Catch:{ Exception -> 0x0192 }
            r20 = r0
            int r0 = r11.length     // Catch:{ Exception -> 0x0192 }
            r21 = r6
            r6 = 2
            if (r0 != r6) goto L_0x0189
            r6 = 0
            r0 = r11[r6]     // Catch:{ Exception -> 0x019c }
            r6 = 1
            r11 = r11[r6]     // Catch:{ Exception -> 0x019c }
            r14.put(r0, r11)     // Catch:{ Exception -> 0x019c }
            goto L_0x0189
        L_0x0185:
            r20 = r0
            r21 = r6
        L_0x0189:
            int r5 = r5 + 1
            r11 = r19
            r0 = r20
            r6 = r21
            goto L_0x0157
        L_0x0192:
            r0 = move-exception
            goto L_0x01a1
        L_0x0194:
            r21 = r6
            java.lang.String r0 = "ADDITIONAL_VOICE_SPECIFIC_DATA"
            r15.put(r0, r14)     // Catch:{ Exception -> 0x019c }
            goto L_0x01c1
        L_0x019c:
            r0 = move-exception
            goto L_0x01be
        L_0x019e:
            r0 = move-exception
            r18 = r5
        L_0x01a1:
            r21 = r6
            goto L_0x01be
        L_0x01a4:
            r0 = move-exception
            r18 = r5
            r21 = r6
            r17 = r11
            goto L_0x01be
        L_0x01ac:
            r18 = r5
            r21 = r6
            r17 = r11
            r16 = r14
            goto L_0x01c1
        L_0x01b5:
            r0 = move-exception
            r18 = r5
            r21 = r6
            r17 = r11
            r16 = r14
        L_0x01be:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0319 }
        L_0x01c1:
            java.lang.String r0 = "DataSpecificRegistrationInfo { "
            java.lang.String r0 = r1.a(r12, r0, r10)     // Catch:{ Exception -> 0x0224 }
            if (r0 != 0) goto L_0x01cf
            java.lang.String r0 = "DataSpecificRegistrationInfo :{ "
            java.lang.String r0 = r1.a(r12, r0, r10)     // Catch:{ Exception -> 0x0224 }
        L_0x01cf:
            if (r0 == 0) goto L_0x0221
            java.lang.String r0 = r0.replace(r4, r9)     // Catch:{ Exception -> 0x0224 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0224 }
            r5.<init>()     // Catch:{ Exception -> 0x0224 }
            java.lang.String[] r0 = r0.split(r8)     // Catch:{ Exception -> 0x0224 }
            int r6 = r0.length     // Catch:{ Exception -> 0x0224 }
            r11 = 0
        L_0x01e0:
            if (r11 >= r6) goto L_0x0217
            r14 = r0[r11]     // Catch:{ Exception -> 0x0224 }
            boolean r19 = r14.contains(r9)     // Catch:{ Exception -> 0x0224 }
            if (r19 == 0) goto L_0x020c
            boolean r19 = r14.contains(r7)     // Catch:{ Exception -> 0x0224 }
            if (r19 != 0) goto L_0x020c
            boolean r19 = r14.contains(r10)     // Catch:{ Exception -> 0x0224 }
            if (r19 != 0) goto L_0x020c
            java.lang.String[] r14 = r14.split(r9)     // Catch:{ Exception -> 0x0224 }
            r19 = r0
            int r0 = r14.length     // Catch:{ Exception -> 0x0224 }
            r20 = r4
            r4 = 2
            if (r0 != r4) goto L_0x0210
            r4 = 0
            r0 = r14[r4]     // Catch:{ Exception -> 0x021f }
            r4 = 1
            r14 = r14[r4]     // Catch:{ Exception -> 0x021f }
            r5.put(r0, r14)     // Catch:{ Exception -> 0x021f }
            goto L_0x0210
        L_0x020c:
            r19 = r0
            r20 = r4
        L_0x0210:
            int r11 = r11 + 1
            r0 = r19
            r4 = r20
            goto L_0x01e0
        L_0x0217:
            r20 = r4
            java.lang.String r0 = "ADDITIONAL_DATA_SPECIFIC_DATA"
            r15.put(r0, r5)     // Catch:{ Exception -> 0x021f }
            goto L_0x022a
        L_0x021f:
            r0 = move-exception
            goto L_0x0227
        L_0x0221:
            r20 = r4
            goto L_0x022a
        L_0x0224:
            r0 = move-exception
            r20 = r4
        L_0x0227:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0319 }
        L_0x022a:
            java.lang.String r0 = r1.a(r12, r3, r8)     // Catch:{ Exception -> 0x025c }
            if (r0 != 0) goto L_0x0234
            java.lang.String r0 = r1.a(r12, r3, r10)     // Catch:{ Exception -> 0x025c }
        L_0x0234:
            if (r0 == 0) goto L_0x0260
            boolean r4 = r0.contains(r9)     // Catch:{ Exception -> 0x025c }
            if (r4 != 0) goto L_0x0260
            boolean r4 = r0.contains(r8)     // Catch:{ Exception -> 0x025c }
            if (r4 != 0) goto L_0x0260
            boolean r4 = r0.contains(r7)     // Catch:{ Exception -> 0x025c }
            if (r4 != 0) goto L_0x0260
            boolean r4 = r0.contains(r10)     // Catch:{ Exception -> 0x025c }
            if (r4 != 0) goto L_0x0260
            java.lang.String r0 = r0.replace(r8, r2)     // Catch:{ Exception -> 0x025c }
            java.lang.String r0 = r0.replace(r10, r2)     // Catch:{ Exception -> 0x025c }
            java.lang.String r4 = "NR_STATE"
            r15.put(r4, r0)     // Catch:{ Exception -> 0x025c }
            goto L_0x0260
        L_0x025c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0319 }
        L_0x0260:
            java.lang.String r0 = r13.getRegisteredPlmn()     // Catch:{ Exception -> 0x0319 }
            if (r0 == 0) goto L_0x026f
            java.lang.String r0 = "REGISTERED_PLMN"
            java.lang.String r4 = r13.getRegisteredPlmn()     // Catch:{ Exception -> 0x0319 }
            r15.put(r0, r4)     // Catch:{ Exception -> 0x0319 }
        L_0x026f:
            java.util.List r0 = r13.getAvailableServices()     // Catch:{ Exception -> 0x0319 }
            if (r0 == 0) goto L_0x029f
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0319 }
            r0.<init>()     // Catch:{ Exception -> 0x0319 }
            java.util.List r4 = r13.getAvailableServices()     // Catch:{ Exception -> 0x0319 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0319 }
        L_0x0282:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x0319 }
            if (r5 == 0) goto L_0x029a
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x0319 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0319 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0319 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0319 }
            r0.put(r5)     // Catch:{ Exception -> 0x0319 }
            goto L_0x0282
        L_0x029a:
            java.lang.String r4 = "AVAILABLE_SERVICES"
            r15.put(r4, r0)     // Catch:{ Exception -> 0x0319 }
        L_0x029f:
            android.telephony.CellIdentity r0 = r13.getCellIdentity()     // Catch:{ Exception -> 0x0319 }
            if (r0 == 0) goto L_0x02a8
            r1.a((org.json.JSONObject) r15, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0319 }
        L_0x02a8:
            com.teragence.library.s1 r0 = new com.teragence.library.s1     // Catch:{ Exception -> 0x0319 }
            int r4 = r13.getAccessNetworkTechnology()     // Catch:{ Exception -> 0x0319 }
            android.content.Context r5 = r1.c     // Catch:{ Exception -> 0x0319 }
            r0.<init>(r4, r5)     // Catch:{ Exception -> 0x0319 }
            java.lang.String r4 = "NETWORK_TYPE"
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0319 }
            r15.put(r4, r0)     // Catch:{ Exception -> 0x0319 }
            java.lang.String r0 = "DOMAIN"
            int r4 = r13.getDomain()     // Catch:{ Exception -> 0x0319 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0319 }
            r15.put(r0, r4)     // Catch:{ Exception -> 0x0319 }
            java.lang.String r0 = "TRANSPORT_TYPE"
            int r4 = r13.getTransportType()     // Catch:{ Exception -> 0x0319 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0319 }
            r15.put(r0, r4)     // Catch:{ Exception -> 0x0319 }
            java.lang.String r0 = "IS_REGISTERED"
            boolean r4 = r13.isRegistered()     // Catch:{ Exception -> 0x0319 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0319 }
            r15.put(r0, r4)     // Catch:{ Exception -> 0x0319 }
            boolean r0 = r13.isRoaming()     // Catch:{ Exception -> 0x0319 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0319 }
            r4 = r21
            r15.put(r4, r0)     // Catch:{ Exception -> 0x0319 }
            boolean r0 = r13.isSearching()     // Catch:{ Exception -> 0x0319 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0319 }
            r5 = r18
            r15.put(r5, r0)     // Catch:{ Exception -> 0x0319 }
            r6 = r17
            r6.put(r15)     // Catch:{ Exception -> 0x0319 }
            r12 = r23
            r11 = r6
            r14 = r16
            r6 = r4
            r4 = r20
            goto L_0x011a
        L_0x030c:
            r6 = r11
            r16 = r14
            java.lang.String r0 = "SERVICE_STATE_NETWORK_REGISTRATION_INFO"
            r2 = r16
            r2.put(r0, r6)     // Catch:{ Exception -> 0x0317 }
            goto L_0x0324
        L_0x0317:
            r0 = move-exception
            goto L_0x0321
        L_0x0319:
            r0 = move-exception
            r2 = r16
            goto L_0x0321
        L_0x031d:
            r2 = r14
            goto L_0x0324
        L_0x031f:
            r0 = move-exception
            r2 = r14
        L_0x0321:
            r0.printStackTrace()     // Catch:{ Exception -> 0x032e }
        L_0x0324:
            com.teragence.client.service.k r0 = r1.d     // Catch:{ Exception -> 0x032e }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.p     // Catch:{ Exception -> 0x032e }
            java.lang.String r3 = "SERVICE_STATE"
            r0.put(r3, r2)     // Catch:{ Exception -> 0x032e }
            goto L_0x0332
        L_0x032e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0332:
            java.lang.String r0 = k
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.teragence.client.service.k r3 = r1.d
            java.lang.String r4 = r3.g
            r5 = 0
            r2[r5] = r4
            boolean r3 = r3.l
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r4 = 1
            r2[r4] = r3
            java.lang.String r3 = "service state update: %s, %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            com.teragence.client.i.a((java.lang.String) r0, (java.lang.String) r2)
            com.teragence.library.u1 r0 = com.teragence.library.u1.Service
            r1.a((com.teragence.library.u1) r0)
        L_0x0355:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.w1.onServiceStateChanged(android.telephony.ServiceState):void");
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        String str;
        k kVar;
        if (this.d != null) {
            if (signalStrength.isGsm()) {
                kVar = this.d;
                str = String.format(Locale.ENGLISH, "GSM:%d:%d", new Object[]{Integer.valueOf(signalStrength.getGsmSignalStrength()), Integer.valueOf(signalStrength.getGsmBitErrorRate())});
            } else {
                kVar = this.d;
                str = String.format(Locale.ENGLISH, "CDMA:%d:%d", new Object[]{Integer.valueOf(signalStrength.getCdmaDbm()), Integer.valueOf(signalStrength.getCdmaEcio())});
            }
            kVar.j = str;
            if (this.a != null && b()) {
                try {
                    onCellInfoChanged(this.a.getAllCellInfo());
                } catch (SecurityException unused) {
                }
            }
            i.a(k, String.format("signal strength update: %s", new Object[]{this.d.j}));
            a(u1.Signal);
        }
    }
}
