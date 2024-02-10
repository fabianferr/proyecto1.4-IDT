package com.cellrebel.sdk.workers;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.utils.TelephonyHelper;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BaseMetricsWorker {
    public static boolean h;
    static boolean i;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Context a;
        final /* synthetic */ BaseMetric b;
        final /* synthetic */ List c;
        final /* synthetic */ Runnable d;

        a(Context context, BaseMetric baseMetric, List list, Runnable runnable) {
            this.a = context;
            this.b = baseMetric;
            this.c = list;
            this.d = runnable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            BaseMetricsWorker.a(this.a, this.b, (List<CellInfo>) this.c);
            if (this.d == null) {
                return null;
            }
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler(Looper.getMainLooper()).post(this.d);
            return null;
        }
    }

    class b extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Context a;
        final /* synthetic */ BaseMetric b;
        final /* synthetic */ Runnable c;

        b(Context context, BaseMetric baseMetric, Runnable runnable) {
            this.a = context;
            this.b = baseMetric;
            this.c = runnable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            BaseMetricsWorker.a(this.a, this.b);
            if (this.c == null) {
                return null;
            }
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler(Looper.getMainLooper()).post(this.c);
            return null;
        }
    }

    public static CellInfo a(Context context, TelephonyManager telephonyManager) {
        if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return null;
        }
        TrackingHelper a2 = TrackingHelper.a();
        List<CellInfo> a3 = TelephonyHelper.b().a(context);
        if (a3 == null || a3.isEmpty()) {
            return null;
        }
        return a(a3, a2.m(context), a2.l(context), a2.x(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.telephony.CellInfo a(java.util.List<android.telephony.CellInfo> r10, java.lang.String r11, java.lang.String r12, com.cellrebel.sdk.database.ConnectionType r13) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x035d
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x035d
        L_0x000b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r10)
            java.util.Iterator r10 = r10.iterator()
        L_0x0014:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r10.next()
            android.telephony.CellInfo r2 = (android.telephony.CellInfo) r2
            boolean r3 = r2.isRegistered()
            if (r3 != 0) goto L_0x0027
            goto L_0x0035
        L_0x0027:
            java.lang.String r3 = e(r2)
            if (r12 == 0) goto L_0x0014
            if (r3 == 0) goto L_0x0014
            boolean r3 = r12.equals(r3)
            if (r3 != 0) goto L_0x0014
        L_0x0035:
            r1.remove(r2)
            goto L_0x0014
        L_0x0039:
            boolean r10 = r1.isEmpty()
            if (r10 == 0) goto L_0x0040
            return r0
        L_0x0040:
            int r10 = r1.size()
            r12 = 0
            r2 = 1
            if (r10 != r2) goto L_0x004f
        L_0x0048:
            java.lang.Object r10 = r1.get(r12)
        L_0x004c:
            android.telephony.CellInfo r10 = (android.telephony.CellInfo) r10
            return r10
        L_0x004f:
            com.cellrebel.sdk.utils.TelephonyHelper r10 = com.cellrebel.sdk.utils.TelephonyHelper.b()
            android.telephony.ServiceState r10 = r10.c
            if (r10 == 0) goto L_0x0122
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 30
            if (r3 < r4) goto L_0x0122
            java.util.List r10 = r10.getNetworkRegistrationInfoList()
            java.util.Iterator r10 = r10.iterator()
        L_0x0065:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x0122
            java.lang.Object r3 = r10.next()
            android.telephony.NetworkRegistrationInfo r3 = (android.telephony.NetworkRegistrationInfo) r3
            java.util.List r4 = r3.getAvailableServices()
            r5 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0065
            android.telephony.CellIdentity r3 = r3.getCellIdentity()
            java.util.Iterator r4 = r1.iterator()
        L_0x0088:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0065
            java.lang.Object r5 = r4.next()
            android.telephony.CellInfo r5 = (android.telephony.CellInfo) r5
            boolean r6 = r5 instanceof android.telephony.CellInfoNr
            if (r6 == 0) goto L_0x00b5
            boolean r6 = r3 instanceof android.telephony.CellIdentityNr
            if (r6 == 0) goto L_0x00b5
            i = r2
            r6 = r5
            android.telephony.CellInfoNr r6 = (android.telephony.CellInfoNr) r6
            android.telephony.CellIdentity r6 = r6.getCellIdentity()
            android.telephony.CellIdentityNr r6 = (android.telephony.CellIdentityNr) r6
            r7 = r3
            android.telephony.CellIdentityNr r7 = (android.telephony.CellIdentityNr) r7
            int r6 = r6.getPci()
            int r7 = r7.getPci()
            if (r6 != r7) goto L_0x00b5
            return r5
        L_0x00b5:
            boolean r6 = r5 instanceof android.telephony.CellInfoLte
            if (r6 == 0) goto L_0x00dd
            boolean r6 = r3 instanceof android.telephony.CellIdentityLte
            if (r6 == 0) goto L_0x00dd
            r6 = r5
            android.telephony.CellInfoLte r6 = (android.telephony.CellInfoLte) r6
            android.telephony.CellIdentityLte r6 = r6.getCellIdentity()
            r7 = r3
            android.telephony.CellIdentityLte r7 = (android.telephony.CellIdentityLte) r7
            int r8 = r6.getCi()
            int r9 = r7.getCi()
            if (r8 != r9) goto L_0x00d2
            return r5
        L_0x00d2:
            int r6 = r6.getPci()
            int r7 = r7.getPci()
            if (r6 != r7) goto L_0x00dd
            return r5
        L_0x00dd:
            boolean r6 = r5 instanceof android.telephony.CellInfoWcdma
            if (r6 == 0) goto L_0x00fa
            boolean r6 = r3 instanceof android.telephony.CellIdentityWcdma
            if (r6 == 0) goto L_0x00fa
            r6 = r5
            android.telephony.CellInfoWcdma r6 = (android.telephony.CellInfoWcdma) r6
            android.telephony.CellIdentityWcdma r6 = r6.getCellIdentity()
            r7 = r3
            android.telephony.CellIdentityWcdma r7 = (android.telephony.CellIdentityWcdma) r7
            int r6 = r6.getCid()
            int r7 = r7.getCid()
            if (r6 != r7) goto L_0x00fa
            return r5
        L_0x00fa:
            boolean r6 = r5 instanceof android.telephony.CellInfoCdma
            if (r6 == 0) goto L_0x0117
            boolean r6 = r3 instanceof android.telephony.CellIdentityCdma
            if (r6 == 0) goto L_0x0117
            r6 = r5
            android.telephony.CellInfoCdma r6 = (android.telephony.CellInfoCdma) r6
            android.telephony.CellIdentityCdma r6 = r6.getCellIdentity()
            r7 = r3
            android.telephony.CellIdentityCdma r7 = (android.telephony.CellIdentityCdma) r7
            int r6 = r6.getBasestationId()
            int r7 = r7.getBasestationId()
            if (r6 != r7) goto L_0x0117
            return r5
        L_0x0117:
            android.telephony.CellIdentity r6 = r5.getCellIdentity()
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x0088
            return r5
        L_0x0122:
            com.cellrebel.sdk.utils.TelephonyHelper r10 = com.cellrebel.sdk.utils.TelephonyHelper.b()
            com.cellrebel.sdk.utils.WrappedRegInfo r10 = r10.e
            if (r10 == 0) goto L_0x014b
            java.lang.String r3 = r10.i
            if (r3 == 0) goto L_0x014b
            java.util.Iterator r3 = r1.iterator()
        L_0x0132:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x014b
            java.lang.Object r4 = r3.next()
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4
            java.lang.String r5 = r10.i
            java.lang.String r6 = r4.toString()
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x0132
            return r4
        L_0x014b:
            int r10 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r10 < r3) goto L_0x02df
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Iterator r3 = r1.iterator()
        L_0x015a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x018d
            java.lang.Object r4 = r3.next()
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4
            java.lang.String r5 = f(r4)
            if (r5 != 0) goto L_0x016d
            goto L_0x015a
        L_0x016d:
            boolean r6 = r10.containsKey(r5)
            if (r6 == 0) goto L_0x0181
            java.lang.Object r6 = r10.get(r5)
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L_0x0186
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            goto L_0x0186
        L_0x0181:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0186:
            r6.add(r4)
            r10.put(r5, r6)
            goto L_0x015a
        L_0x018d:
            if (r11 == 0) goto L_0x01a6
            java.util.Set r3 = r10.keySet()
            int r3 = r3.size()
            if (r3 <= r2) goto L_0x01a6
            boolean r3 = r10.containsKey(r11)
            if (r3 == 0) goto L_0x01a6
            java.lang.Object r10 = r10.get(r11)
            r1 = r10
            java.util.List r1 = (java.util.List) r1
        L_0x01a6:
            if (r1 == 0) goto L_0x01b0
            int r10 = r1.size()
            if (r10 != r2) goto L_0x01b0
            goto L_0x0048
        L_0x01b0:
            if (r1 == 0) goto L_0x02de
            int r10 = r1.size()
            if (r10 <= r2) goto L_0x02de
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x01d0:
            boolean r6 = r1.hasNext()
            r7 = 29
            if (r6 == 0) goto L_0x020c
            java.lang.Object r6 = r1.next()
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r7) goto L_0x01ee
            boolean r7 = r6 instanceof android.telephony.CellInfoNr
            if (r7 == 0) goto L_0x01ee
            i = r2
            android.telephony.CellInfoNr r6 = (android.telephony.CellInfoNr) r6
            r10.add(r6)
            goto L_0x01d0
        L_0x01ee:
            boolean r7 = r6 instanceof android.telephony.CellInfoLte
            if (r7 == 0) goto L_0x01f8
            android.telephony.CellInfoLte r6 = (android.telephony.CellInfoLte) r6
            r3.add(r6)
            goto L_0x01d0
        L_0x01f8:
            boolean r7 = r6 instanceof android.telephony.CellInfoWcdma
            if (r7 == 0) goto L_0x0202
            android.telephony.CellInfoWcdma r6 = (android.telephony.CellInfoWcdma) r6
            r4.add(r6)
            goto L_0x01d0
        L_0x0202:
            boolean r7 = r6 instanceof android.telephony.CellInfoGsm
            if (r7 == 0) goto L_0x01d0
            android.telephony.CellInfoGsm r6 = (android.telephony.CellInfoGsm) r6
            r5.add(r6)
            goto L_0x01d0
        L_0x020c:
            if (r13 == 0) goto L_0x028a
            com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.FIVE_G
            if (r13 != r1) goto L_0x022f
            boolean r1 = r10.isEmpty()
            if (r1 != 0) goto L_0x022f
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r7) goto L_0x022f
            int r1 = r10.size()
            if (r1 != r2) goto L_0x0228
        L_0x0222:
            java.lang.Object r10 = r10.get(r12)
            goto L_0x004c
        L_0x0228:
            android.telephony.CellInfo r1 = b((java.util.List<android.telephony.CellInfo>) r10)
            if (r1 == 0) goto L_0x022f
            return r1
        L_0x022f:
            com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.FOUR_G
            if (r13 == r1) goto L_0x0237
            com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.FOUR_G_CA
            if (r13 != r1) goto L_0x0250
        L_0x0237:
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x0250
            int r1 = r3.size()
            if (r1 != r2) goto L_0x0249
        L_0x0243:
            java.lang.Object r10 = r3.get(r12)
            goto L_0x004c
        L_0x0249:
            android.telephony.CellInfoLte r1 = a((java.util.List<android.telephony.CellInfoLte>) r3, (java.lang.String) r11)
            if (r1 == 0) goto L_0x0250
            return r1
        L_0x0250:
            com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.THREE_G
            if (r13 != r1) goto L_0x026d
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x026d
            int r1 = r4.size()
            if (r1 != r2) goto L_0x0266
        L_0x0260:
            java.lang.Object r10 = r4.get(r12)
            goto L_0x004c
        L_0x0266:
            android.telephony.CellInfoWcdma r1 = c((java.util.List<android.telephony.CellInfoWcdma>) r4)
            if (r1 == 0) goto L_0x026d
            return r1
        L_0x026d:
            com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.TWO_G
            if (r13 != r1) goto L_0x028a
            boolean r13 = r5.isEmpty()
            if (r13 != 0) goto L_0x028a
            int r13 = r5.size()
            if (r13 != r2) goto L_0x0283
        L_0x027d:
            java.lang.Object r10 = r5.get(r12)
            goto L_0x004c
        L_0x0283:
            android.telephony.CellInfoGsm r13 = a((java.util.List<android.telephony.CellInfoGsm>) r5)
            if (r13 == 0) goto L_0x028a
            return r13
        L_0x028a:
            boolean r13 = r10.isEmpty()
            if (r13 != 0) goto L_0x02a2
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r7) goto L_0x02a2
            int r13 = r10.size()
            if (r13 != r2) goto L_0x029b
            goto L_0x0222
        L_0x029b:
            android.telephony.CellInfo r10 = b((java.util.List<android.telephony.CellInfo>) r10)
            if (r10 == 0) goto L_0x02a2
            return r10
        L_0x02a2:
            boolean r10 = r3.isEmpty()
            if (r10 != 0) goto L_0x02b6
            int r10 = r3.size()
            if (r10 != r2) goto L_0x02af
            goto L_0x0243
        L_0x02af:
            android.telephony.CellInfoLte r10 = a((java.util.List<android.telephony.CellInfoLte>) r3, (java.lang.String) r11)
            if (r10 == 0) goto L_0x02b6
            return r10
        L_0x02b6:
            boolean r10 = r4.isEmpty()
            if (r10 != 0) goto L_0x02ca
            int r10 = r4.size()
            if (r10 != r2) goto L_0x02c3
            goto L_0x0260
        L_0x02c3:
            android.telephony.CellInfoWcdma r10 = c((java.util.List<android.telephony.CellInfoWcdma>) r4)
            if (r10 == 0) goto L_0x02ca
            return r10
        L_0x02ca:
            boolean r10 = r5.isEmpty()
            if (r10 != 0) goto L_0x02de
            int r10 = r5.size()
            if (r10 != r2) goto L_0x02d7
            goto L_0x027d
        L_0x02d7:
            android.telephony.CellInfoGsm r10 = a((java.util.List<android.telephony.CellInfoGsm>) r5)
            if (r10 == 0) goto L_0x02de
            return r10
        L_0x02de:
            return r0
        L_0x02df:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r3 = r1.iterator()
        L_0x02f2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x031c
            java.lang.Object r4 = r3.next()
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4
            boolean r5 = r4 instanceof android.telephony.CellInfoLte
            if (r5 == 0) goto L_0x0308
            android.telephony.CellInfoLte r4 = (android.telephony.CellInfoLte) r4
            r10.add(r4)
            goto L_0x02f2
        L_0x0308:
            boolean r5 = r4 instanceof android.telephony.CellInfoWcdma
            if (r5 == 0) goto L_0x0312
            android.telephony.CellInfoWcdma r4 = (android.telephony.CellInfoWcdma) r4
            r13.add(r4)
            goto L_0x02f2
        L_0x0312:
            boolean r5 = r4 instanceof android.telephony.CellInfoGsm
            if (r5 == 0) goto L_0x02f2
            android.telephony.CellInfoGsm r4 = (android.telephony.CellInfoGsm) r4
            r0.add(r4)
            goto L_0x02f2
        L_0x031c:
            boolean r3 = r10.isEmpty()
            if (r3 != 0) goto L_0x032f
            int r13 = r10.size()
            if (r13 != r2) goto L_0x032a
            goto L_0x0222
        L_0x032a:
            android.telephony.CellInfoLte r10 = a((java.util.List<android.telephony.CellInfoLte>) r10, (java.lang.String) r11)
            return r10
        L_0x032f:
            boolean r10 = r13.isEmpty()
            if (r10 != 0) goto L_0x0346
            int r10 = r13.size()
            if (r10 != r2) goto L_0x0341
            java.lang.Object r10 = r13.get(r12)
            goto L_0x004c
        L_0x0341:
            android.telephony.CellInfoWcdma r10 = c((java.util.List<android.telephony.CellInfoWcdma>) r13)
            return r10
        L_0x0346:
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L_0x0048
            int r10 = r0.size()
            if (r10 != r2) goto L_0x0358
            java.lang.Object r10 = r0.get(r12)
            goto L_0x004c
        L_0x0358:
            android.telephony.CellInfoGsm r10 = a((java.util.List<android.telephony.CellInfoGsm>) r0)
            return r10
        L_0x035d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.BaseMetricsWorker.a(java.util.List, java.lang.String, java.lang.String, com.cellrebel.sdk.database.ConnectionType):android.telephony.CellInfo");
    }

    private static CellInfoGsm a(List<CellInfoGsm> list) {
        return list.get(0);
    }

    private static CellInfoLte a(List<CellInfoLte> list, String str) {
        CellInfoLte cellInfoLte = null;
        for (CellInfoLte next : list) {
            CellSignalStrengthLte cellSignalStrength = next.getCellSignalStrength();
            CellIdentityLte cellIdentity = next.getCellIdentity();
            if (cellSignalStrength.getTimingAdvance() > 0 && cellSignalStrength.getTimingAdvance() != Integer.MAX_VALUE) {
                return next;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26 && cellSignalStrength.getRsrq() != Integer.MAX_VALUE && cellSignalStrength.getRsrq() != 0) {
                return next;
            }
            if (i2 >= 26 && cellSignalStrength.getRsrp() != Integer.MAX_VALUE && cellSignalStrength.getRsrp() != 0) {
                return next;
            }
            if (str != null && String.valueOf(cellIdentity.getMnc()).equals(str)) {
                cellInfoLte = next;
            }
        }
        return cellInfoLte == null ? list.get(0) : cellInfoLte;
    }

    private static String a(CellInfo cellInfo) {
        Set set;
        CellIdentityLte cellIdentityLte;
        if (Build.VERSION.SDK_INT >= 30) {
            if (cellInfo instanceof CellInfoLte) {
                cellIdentityLte = ((CellInfoLte) cellInfo).getCellIdentity();
            } else {
                if (cellInfo instanceof CellInfoWcdma) {
                    set = ((CellInfoWcdma) cellInfo).getCellIdentity().getAdditionalPlmns();
                } else if (cellInfo instanceof CellInfoGsm) {
                    set = ((CellInfoGsm) cellInfo).getCellIdentity().getAdditionalPlmns();
                } else {
                    if (cellInfo instanceof CellInfoNr) {
                        CellIdentity cellIdentity = ((CellInfoNr) cellInfo).getCellIdentity();
                        if (cellIdentity instanceof CellIdentityNr) {
                            set = ((CellIdentityNr) cellIdentity).getAdditionalPlmns();
                        } else if (cellIdentity instanceof CellIdentityLte) {
                            cellIdentityLte = (CellIdentityLte) cellIdentity;
                        }
                    }
                    set = null;
                }
                if (set != null && !set.isEmpty()) {
                    return set.toString();
                }
            }
            set = cellIdentityLte.getAdditionalPlmns();
            return set.toString();
        }
        return null;
    }

    public static void a(Context context, BaseMetric baseMetric) {
        a(context, baseMetric, (List<CellInfo>) new ArrayList());
    }

    public static void a(Context context, BaseMetric baseMetric, Runnable runnable) {
        new b(context, baseMetric, runnable).execute(new Void[0]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        a(r2, "https://icanhazip.com/");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.clientIp = "0.0.0.0";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0950, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x0953, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x0955, code lost:
        r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:204:0x064f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0238 */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0653 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0670 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0679 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x06b7 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0772 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0798 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x07e5 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x082e A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x087d A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x08ad A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x08c3 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x08f9 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x0902 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x091f A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0953 A[ExcHandler: OutOfMemoryError (e java.lang.OutOfMemoryError), Splitter:B:20:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0227 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x026b A[SYNTHETIC, Splitter:B:57:0x026b] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02e9 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0307 A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x031c A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x034a A[Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r19, com.cellrebel.sdk.networking.beans.request.BaseMetric r20, java.util.List<android.telephony.CellInfo> r21) {
        /*
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r4 = "0.0.0.0"
            java.lang.String r5 = ""
            java.lang.String r6 = "https://icanhazip.com/"
            boolean r7 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception | OutOfMemoryError -> 0x0058 }
            if (r7 == 0) goto L_0x0055
            com.cellrebel.sdk.networking.ApiService r7 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            java.lang.String r8 = "https://checkip.amazonaws.com/"
            retrofit2.Call r7 = r7.a(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            retrofit2.Response r7 = r7.execute()     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            if (r7 == 0) goto L_0x004d
            java.lang.Object r8 = r7.body()     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            if (r8 == 0) goto L_0x004d
            boolean r8 = r7.isSuccessful()     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            if (r8 == 0) goto L_0x004d
            java.lang.Object r7 = r7.body()     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            okhttp3.ResponseBody r7 = (okhttp3.ResponseBody) r7     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            java.lang.String r7 = r7.string()     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            java.lang.String r8 = "[\\n\\t ]"
            java.lang.String r7 = r7.replaceAll(r8, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            boolean r8 = com.cellrebel.sdk.ping.IPTools.c(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            if (r8 != 0) goto L_0x004a
            boolean r8 = com.cellrebel.sdk.ping.IPTools.d(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            if (r8 == 0) goto L_0x004d
        L_0x004a:
            r2.clientIp = r7     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            goto L_0x005a
        L_0x004d:
            a((com.cellrebel.sdk.networking.beans.request.BaseMetric) r2, (java.lang.String) r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0051 }
            goto L_0x005a
        L_0x0051:
            a((com.cellrebel.sdk.networking.beans.request.BaseMetric) r2, (java.lang.String) r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0058 }
            goto L_0x005a
        L_0x0055:
            r2.clientIp = r4     // Catch:{ Exception | OutOfMemoryError -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            r2.clientIp = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x005a:
            r4 = 0
            i = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.SettingsManager r6 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.networking.beans.response.Settings r6 = r6.c()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.PreferencesManager r7 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.a((android.content.Context) r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.mobileClientId = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r7 = r6.anonymize()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.anonymize = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r9
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dateTimeOfMeasurement = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.readableDate(r7)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.database.ConnectionType r7 = r7.a((android.content.Context) r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.accessTechnology = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.c((android.content.Context) r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.accessTypeRaw = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.v(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r8 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r8 = r8.u(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.simMNC = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.simMCC = r8     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r7 = r7.z(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r7 == 0) goto L_0x00dd
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.r(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.secondarySimMCC = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.s(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.secondarySimMNC = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.p(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.secondaryCarrierName = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x00dd:
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r7 = r7.o(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.numberOfSimSlots = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r7 = r7.g(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dataSimSlotNumber = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.m(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r8 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r8 = r8.l(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.networkMNC = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.networkMCC = r8     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.location.Location r7 = r7.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r8 = 28
            r11 = 26
            if (r7 == 0) goto L_0x0162
            java.lang.String r12 = "Location=ON"
            r2.debugString = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            double r12 = r7.getLatitude()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.latitude = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            double r12 = r7.getLongitude()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.longitude = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            float r12 = r7.getAccuracy()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            double r12 = (double) r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.gpsAccuracy = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            double r12 = r7.getAltitude()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.altitude = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            float r12 = r7.getSpeed()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.locationSpeed = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r12 < r8) goto L_0x0148
            float r13 = r7.getVerticalAccuracyMeters()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Float r13 = java.lang.Float.valueOf(r13)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.gpsVerticalAccuracy = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0148:
            if (r12 < r11) goto L_0x0154
            float r12 = r7.getSpeedAccuracyMetersPerSecond()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.locationSpeedAccuracy = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0154:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            long r14 = r7.getTime()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            long r12 = r12 - r14
            long r12 = r12 / r9
            int r7 = (int) r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.locationAge = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x016e
        L_0x0162:
            double r9 = r2.latitude     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r12 = 0
            int r7 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x016e
            java.lang.String r7 = "Location=OFF"
            r2.debugString = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x016e:
            java.lang.String r7 = r2.debugString     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r9 = 2
            r10 = 1
            if (r7 == 0) goto L_0x01ad
            boolean r7 = r7.isEmpty()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r7 == 0) goto L_0x017b
            goto L_0x01ad
        L_0x017b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r7.<init>()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r12 = r2.debugString     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r7.append(r12)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r12 = " isOnline: %s foregroundStarts: %s"
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r14 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r13[r4] = r14     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.PreferencesManager r14 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r14 = r14.l()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r13[r10] = r14     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r12 = java.lang.String.format(r12, r13)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r7.append(r12)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x01cd
        L_0x01ad:
            java.lang.String r7 = "isOnline: %s foregroundStarts: %s"
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r13 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r12[r4] = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.PreferencesManager r13 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r13 = r13.l()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r12[r10] = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = java.lang.String.format(r7, r12)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x01cd:
            r2.debugString = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.e(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.cellId = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.j(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.lacId = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.PreferencesManager r7 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.s()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.deviceBrand = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.PreferencesManager r7 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.t()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.deviceModel = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.PreferencesManager r7 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.g()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.deviceVersion = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.d(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.carrierName = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = r7.n(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.networkOperatorName = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = com.cellrebel.sdk.utils.Utils.d(r19)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.sdkVersionNumber = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = "Android"
            r2.os = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.osVersion = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r6 = r6.sdkOrigin     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 == 0) goto L_0x0229
            r2.sdkOrigin = r6     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0229:
            com.cellrebel.sdk.utils.RootUtil r6 = new com.cellrebel.sdk.utils.RootUtil     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r6.<init>(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r6 = r6.k()     // Catch:{ Exception -> 0x0238, OutOfMemoryError -> 0x0953 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0238, OutOfMemoryError -> 0x0953 }
            r2.isRooted = r6     // Catch:{ Exception -> 0x0238, OutOfMemoryError -> 0x0953 }
        L_0x0238:
            com.cellrebel.sdk.utils.TrackingHelper r6 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.net.NetworkCapabilities r6 = r6.k(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r12 = 4
            r13 = 21
            if (r7 < r13) goto L_0x025f
            if (r6 == 0) goto L_0x025f
            boolean r7 = r6.hasTransport(r12)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isConnectedToVpn = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r7 = r6.getLinkDownstreamBandwidthKbps()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.linkDownstreamBandwidth = r7     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r6 = r6.getLinkUpstreamBandwidthKbps()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.linkUpstreamBandwidth = r6     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x025f:
            com.cellrebel.sdk.utils.TrackingHelper r6 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.TelephonyManager r6 = r6.h(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r7 = "android.permission.ACCESS_COARSE_LOCATION"
            if (r6 == 0) goto L_0x02d5
            int r14 = androidx.core.app.ActivityCompat.checkSelfPermission(r1, r7)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r14 != 0) goto L_0x02d5
            com.cellrebel.sdk.utils.TelephonyHelper r14 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.util.List r14 = r14.a((android.content.Context) r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r14 == 0) goto L_0x02db
            java.util.Iterator r14 = r14.iterator()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r15 = 0
        L_0x0280:
            boolean r16 = r14.hasNext()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r16 == 0) goto L_0x0295
            java.lang.Object r16 = r14.next()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellInfo r16 = (android.telephony.CellInfo) r16     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r16 = r16.isRegistered()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r16 == 0) goto L_0x0280
            int r15 = r15 + 1
            goto L_0x0280
        L_0x0295:
            java.lang.String r14 = r2.debugString     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r14 == 0) goto L_0x02c4
            boolean r14 = r14.isEmpty()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r14 == 0) goto L_0x02a0
            goto L_0x02c4
        L_0x02a0:
            java.lang.String r14 = r2.debugString     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r14 == 0) goto L_0x02db
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r14.<init>()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = r2.debugString     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r14.append(r13)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = " isRegistered: %d"
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r9[r4] = r15     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r9 = java.lang.String.format(r13, r9)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r14.append(r9)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r9 = r14.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x02d2
        L_0x02c4:
            java.lang.String r9 = "isRegistered: %d"
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r13[r4] = r14     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r9 = java.lang.String.format(r9, r13)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x02d2:
            r2.debugString = r9     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x02db
        L_0x02d5:
            r6.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            androidx.core.app.ActivityCompat.checkSelfPermission(r1, r7)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x02db:
            android.content.pm.PackageManager r9 = r19.getPackageManager()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = r19.getPackageName()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r13, r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r9 == 0) goto L_0x02ff
            java.lang.String r13 = r9.versionName     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.appVersionName = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r13 < r8) goto L_0x02f6
            long r13 = r9.getLongVersionCode()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x02f9
        L_0x02f6:
            int r13 = r9.versionCode     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            long r13 = (long) r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x02f9:
            r2.appVersionCode = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            long r13 = r9.lastUpdateTime     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.appLastUpdateTime = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x02ff:
            if (r3 == 0) goto L_0x031c
            boolean r9 = r21.isEmpty()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r9 != 0) goto L_0x031c
            com.cellrebel.sdk.utils.TrackingHelper r6 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r9 = r6.m(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = r6.l(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.database.ConnectionType r6 = r6.x(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellInfo r3 = a((java.util.List<android.telephony.CellInfo>) r3, (java.lang.String) r9, (java.lang.String) r13, (com.cellrebel.sdk.database.ConnectionType) r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x032e
        L_0x031c:
            android.telephony.CellInfo r3 = a((android.content.Context) r1, (android.telephony.TelephonyManager) r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r3 != 0) goto L_0x032e
            com.cellrebel.sdk.utils.TrackingHelper r3 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.TelephonyManager r3 = r3.i(r1)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellInfo r3 = a((android.content.Context) r1, (android.telephony.TelephonyManager) r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x032e:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r9 = 24
            if (r6 >= r9) goto L_0x0348
            if (r3 == 0) goto L_0x0348
            java.lang.String r13 = c((android.telephony.CellInfo) r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.cellId = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = d(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.lacId = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r13 = g(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.networkMNC = r13     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0348:
            if (r3 == 0) goto L_0x0670
            com.cellrebel.sdk.utils.TelephonyHelper r13 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellSignalStrength r13 = r13.a((android.telephony.CellInfo) r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r3.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r14 = b((android.telephony.CellInfo) r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.cellBands = r14     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r14 = a((android.telephony.CellInfo) r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.additionalPlmns = r14     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r14 = r3 instanceof android.telephony.CellInfoGsm     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r15 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == 0) goto L_0x03d2
            java.lang.String r14 = "GSM"
            r17 = r3
            android.telephony.CellInfoGsm r17 = (android.telephony.CellInfoGsm) r17     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellIdentityGsm r17 = r17.getCellIdentity()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r18 = r3
            android.telephony.CellInfoGsm r18 = (android.telephony.CellInfoGsm) r18     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellSignalStrengthGsm r18 = r18.getCellSignalStrength()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 < r9) goto L_0x0386
            int r17 = r17.getArfcn()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.absoluteRfChannelNumber = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0386:
            if (r6 < r11) goto L_0x0392
            int r4 = r18.getTimingAdvance()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.timingAdvance = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0392:
            int r4 = r18.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = r18.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r13 instanceof android.telephony.CellSignalStrengthGsm     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x03d3
            r4 = r13
            android.telephony.CellSignalStrengthGsm r4 = (android.telephony.CellSignalStrengthGsm) r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = r2.signalStrengthAsu     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x03bf
            int r10 = r4.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x03bf:
            java.lang.Integer r10 = r2.dbm     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x03d3
            int r4 = r4.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x03d3
        L_0x03d2:
            r14 = r5
        L_0x03d3:
            boolean r4 = r3 instanceof android.telephony.CellInfoWcdma     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0432
            java.lang.String r14 = "WCDMA"
            r4 = r3
            android.telephony.CellInfoWcdma r4 = (android.telephony.CellInfoWcdma) r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellIdentityWcdma r4 = r4.getCellIdentity()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r10 = r3
            android.telephony.CellInfoWcdma r10 = (android.telephony.CellInfoWcdma) r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellSignalStrengthWcdma r10 = r10.getCellSignalStrength()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 < r9) goto L_0x03f3
            int r4 = r4.getUarfcn()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.absoluteRfChannelNumber = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x03f3:
            int r4 = r10.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = r10.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r13 instanceof android.telephony.CellSignalStrengthWcdma     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0432
            r4 = r13
            android.telephony.CellSignalStrengthWcdma r4 = (android.telephony.CellSignalStrengthWcdma) r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = r2.signalStrengthAsu     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x0420
            int r10 = r4.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0420:
            java.lang.Integer r10 = r2.dbm     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x0432
            int r4 = r4.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0432:
            boolean r4 = r3 instanceof android.telephony.CellInfoLte     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0534
            java.lang.String r14 = "LTE"
            r4 = r3
            android.telephony.CellInfoLte r4 = (android.telephony.CellInfoLte) r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellIdentityLte r10 = r4.getCellIdentity()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellSignalStrengthLte r4 = r4.getCellSignalStrength()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r18 = r10.getPci()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r18)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.physicalCellId = r12     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 < r9) goto L_0x0459
            int r10 = r10.getEarfcn()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.absoluteRfChannelNumber = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0459:
            if (r6 < r11) goto L_0x0465
            int r10 = r4.getCqi()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.channelQualityIndicator = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0465:
            if (r6 < r11) goto L_0x0471
            int r10 = r4.getRssnr()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.referenceSignalSignalToNoiseRatio = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0471:
            if (r6 < r11) goto L_0x047d
            int r10 = r4.getRsrp()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.referenceSignalReceivedPower = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x047d:
            if (r6 < r11) goto L_0x0489
            int r10 = r4.getRsrq()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.referenceSignalReceivedQuality = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0489:
            int r10 = r4.getTimingAdvance()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.timingAdvance = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r4.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = r4.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r13 instanceof android.telephony.CellSignalStrengthLte     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0534
            r4 = r13
            android.telephony.CellSignalStrengthLte r4 = (android.telephony.CellSignalStrengthLte) r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 < r11) goto L_0x04c2
            java.lang.Integer r10 = r2.channelQualityIndicator     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x04c2
            int r10 = r4.getCqi()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.channelQualityIndicator = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x04c2:
            if (r6 < r11) goto L_0x04d6
            java.lang.Integer r10 = r2.referenceSignalSignalToNoiseRatio     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x04d6
            int r10 = r4.getRssnr()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.referenceSignalSignalToNoiseRatio = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x04d6:
            if (r6 < r11) goto L_0x04ea
            java.lang.Integer r10 = r2.referenceSignalReceivedPower     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x04ea
            int r10 = r4.getRsrp()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.referenceSignalReceivedPower = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x04ea:
            if (r6 < r11) goto L_0x04fe
            java.lang.Integer r10 = r2.referenceSignalReceivedQuality     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x04fe
            int r10 = r4.getRsrq()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.referenceSignalReceivedQuality = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x04fe:
            java.lang.Integer r10 = r2.timingAdvance     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x0510
            int r10 = r4.getTimingAdvance()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.timingAdvance = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0510:
            java.lang.Integer r10 = r2.signalStrengthAsu     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x0522
            int r10 = r4.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r10     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0522:
            java.lang.Integer r10 = r2.dbm     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r10 = r10.intValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r10 != r15) goto L_0x0534
            int r4 = r4.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0534:
            r4 = 29
            if (r6 < r4) goto L_0x064f
            boolean r4 = r3 instanceof android.telephony.CellInfoNr     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 == 0) goto L_0x064f
            java.lang.String r14 = "NR"
            r4 = r3
            android.telephony.CellInfoNr r4 = (android.telephony.CellInfoNr) r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            android.telephony.CellIdentity r6 = r4.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            boolean r10 = r6 instanceof android.telephony.CellIdentityNr     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r10 == 0) goto L_0x055f
            android.telephony.CellIdentityNr r6 = (android.telephony.CellIdentityNr) r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r10 = r6.getPci()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.physicalCellId = r10     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r6.getNrarfcn()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.absoluteRfChannelNumber = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x055f:
            android.telephony.CellSignalStrength r4 = r4.getCellSignalStrength()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            boolean r6 = r4 instanceof android.telephony.CellSignalStrengthNr     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r6 == 0) goto L_0x064f
            android.telephony.CellSignalStrengthNr r4 = (android.telephony.CellSignalStrengthNr) r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getCsiRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.csiReferenceSignalReceivedPower = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getCsiSinr()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.csiReferenceSignalToNoiseAndInterferenceRatio = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getCsiRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.csiReferenceSignalReceivedQuality = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getSsRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.ssReferenceSignalReceivedPower = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getSsRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.ssReferenceSignalReceivedQuality = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getSsSinr()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.ssReferenceSignalToNoiseAndInterferenceRatio = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r6 = r4.getAsuLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.signalStrengthAsu = r6     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.getDbm()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.dbm = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            boolean r4 = r13 instanceof android.telephony.CellSignalStrengthNr     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 == 0) goto L_0x064f
            android.telephony.CellSignalStrengthNr r13 = (android.telephony.CellSignalStrengthNr) r13     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = r2.csiReferenceSignalReceivedPower     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x05d1
            int r4 = r13.getCsiRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.csiReferenceSignalReceivedPower = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x05d1:
            java.lang.Integer r4 = r2.csiReferenceSignalReceivedPower     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x05e3
            int r4 = r13.getCsiSinr()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.csiReferenceSignalToNoiseAndInterferenceRatio = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x05e3:
            java.lang.Integer r4 = r2.csiReferenceSignalReceivedQuality     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x05f5
            int r4 = r13.getCsiRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.csiReferenceSignalReceivedQuality = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x05f5:
            java.lang.Integer r4 = r2.ssReferenceSignalReceivedPower     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x0607
            int r4 = r13.getSsRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.ssReferenceSignalReceivedPower = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x0607:
            java.lang.Integer r4 = r2.ssReferenceSignalReceivedQuality     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x0619
            int r4 = r13.getSsRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.ssReferenceSignalReceivedQuality = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x0619:
            java.lang.Integer r4 = r2.ssReferenceSignalToNoiseAndInterferenceRatio     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x062b
            int r4 = r13.getSsSinr()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.ssReferenceSignalToNoiseAndInterferenceRatio = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x062b:
            java.lang.Integer r4 = r2.signalStrengthAsu     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x063d
            int r4 = r13.getAsuLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.signalStrengthAsu = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x063d:
            java.lang.Integer r4 = r2.dbm     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            int r4 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            if (r4 != r15) goto L_0x064f
            int r4 = r13.getDbm()     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
            r2.dbm = r4     // Catch:{ Exception | OutOfMemoryError -> 0x064f }
        L_0x064f:
            boolean r4 = r3 instanceof android.telephony.CellInfoCdma     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0671
            java.lang.String r14 = "CDMA"
            android.telephony.CellInfoCdma r3 = (android.telephony.CellInfoCdma) r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.CellSignalStrengthCdma r3 = r3.getCellSignalStrength()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = r3.getAsuLevel()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrengthAsu = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r3 = r3.getDbm()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dbm = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x0671
        L_0x0670:
            r14 = r5
        L_0x0671:
            com.cellrebel.sdk.utils.TelephonyHelper r3 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.WrappedRegInfo r3 = r3.e     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r3 == 0) goto L_0x06af
            com.cellrebel.sdk.utils.TelephonyHelper r3 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.WrappedRegInfo r3 = r3.e     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r3.a     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isDcNrRestricted = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r3.c     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isEnDcAvailable = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r3.b     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isNrAvailable = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r4 = r3.f     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.nrState = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r3.d     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isUsingCarrierAggregation = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = r3.g     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.vopsSupport = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r3 = r3.h     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.accessNetworkTechnologyRaw = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x06af:
            com.cellrebel.sdk.utils.TelephonyHelper r3 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.ServiceState r3 = r3.c     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r3 == 0) goto L_0x0853
            int r4 = r3.getState()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.serviceStateStatus = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 < r8) goto L_0x06d5
            int r4 = r3.getChannelNumber()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.connectionAbsoluteRfChannelNumber = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = r3.getDuplexMode()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.duplexModeState = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x06d5:
            java.lang.String r3 = r3.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r4 = "NrFrequencyRange=-1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r6 = 3
            if (r4 != 0) goto L_0x0757
            java.lang.String r4 = "NrFrequencyRange = -1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x06ec
            goto L_0x0757
        L_0x06ec:
            java.lang.String r4 = "NrFrequencyRange=0"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0753
            java.lang.String r4 = "NrFrequencyRange = 0"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x06fd
            goto L_0x0753
        L_0x06fd:
            java.lang.String r4 = "NrFrequencyRange=1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x074d
            java.lang.String r4 = "NrFrequencyRange = 1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x070e
            goto L_0x074d
        L_0x070e:
            java.lang.String r4 = "NrFrequencyRange=2"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x074b
            java.lang.String r4 = "NrFrequencyRange = 2"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x071f
            goto L_0x074b
        L_0x071f:
            java.lang.String r4 = "NrFrequencyRange=3"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0746
            java.lang.String r4 = "NrFrequencyRange = 3"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0730
            goto L_0x0746
        L_0x0730:
            java.lang.String r4 = "NrFrequencyRange=4"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0740
            java.lang.String r4 = "NrFrequencyRange = 4"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x075e
        L_0x0740:
            r4 = 4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x075c
        L_0x0746:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x075c
        L_0x074b:
            r4 = 2
            goto L_0x074e
        L_0x074d:
            r4 = 1
        L_0x074e:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x0755
        L_0x0753:
            r4 = 0
            goto L_0x074e
        L_0x0755:
            r4 = r8
            goto L_0x075c
        L_0x0757:
            r4 = -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x075c:
            r2.nrFrequencyRange = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x075e:
            java.lang.Boolean r4 = r2.isUsingCarrierAggregation     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0784
            java.lang.String r4 = "IsUsingCarrierAggregation"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0784
            java.lang.String r4 = "IsUsingCarrierAggregation = true"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x077d
            java.lang.String r4 = "IsUsingCarrierAggregation=true"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x077b
            goto L_0x077d
        L_0x077b:
            r4 = 0
            goto L_0x077e
        L_0x077d:
            r4 = 1
        L_0x077e:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isUsingCarrierAggregation = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0784:
            java.lang.Integer r4 = r2.vopsSupport     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x07d1
            java.lang.String r4 = "vopsSupport"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x07d1
            java.lang.String r4 = "VopsSupport = 1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x07c9
            java.lang.String r4 = "VopsSupport=1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x07a1
            goto L_0x07c9
        L_0x07a1:
            java.lang.String r4 = "VopsSupport = 2"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x07c7
            java.lang.String r4 = "VopsSupport=2"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x07b2
            goto L_0x07c7
        L_0x07b2:
            java.lang.String r4 = "VopsSupport = 3"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x07c2
            java.lang.String r4 = "VopsSupport=3"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x07d1
        L_0x07c2:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x07cf
        L_0x07c7:
            r4 = 2
            goto L_0x07ca
        L_0x07c9:
            r4 = 1
        L_0x07ca:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r4 = r8
        L_0x07cf:
            r2.vopsSupport = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x07d1:
            java.lang.Integer r4 = r2.vopsSupport     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x081e
            java.lang.String r4 = "msVoiceAvail"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x081e
            java.lang.String r4 = "msVoiceAvail = 1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0816
            java.lang.String r4 = "msVoiceAvail=1"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x07ee
            goto L_0x0816
        L_0x07ee:
            java.lang.String r4 = "msVoiceAvail = 2"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0814
            java.lang.String r4 = "msVoiceAvail=2"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x07ff
            goto L_0x0814
        L_0x07ff:
            java.lang.String r4 = "msVoiceAvail = 3"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x080f
            java.lang.String r4 = "msVoiceAvail=3"
            boolean r4 = r3.contains(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x081e
        L_0x080f:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x081c
        L_0x0814:
            r4 = 2
            goto L_0x0817
        L_0x0816:
            r4 = 1
        L_0x0817:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r4 = r6
        L_0x081c:
            r2.vopsSupport = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x081e:
            java.lang.String r4 = "CellBandwidths=\\[(.*?)\\]"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r6 = r4.find()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 == 0) goto L_0x0838
            r6 = 1
            r4.group(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r4 = r4.group(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.cellBandwidths = r4     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0838:
            java.lang.String r4 = "AdditionalPlmns=\\{(.*?)\\}"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.util.regex.Matcher r3 = r4.matcher(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r4 = r3.find()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 == 0) goto L_0x0853
            java.lang.String r4 = r2.additionalPlmns     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 != 0) goto L_0x0853
            r4 = 1
            java.lang.String r3 = r3.group(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.additionalPlmns = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0853:
            boolean r3 = com.cellrebel.sdk.utils.Utils.g(r19)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isRoaming = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TelephonyHelper r3 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.telephony.TelephonyDisplayInfo r3 = r3.d     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r6 = 30
            if (r4 < r6) goto L_0x089f
            if (r3 == 0) goto L_0x089f
            int r6 = r3.getOverrideNetworkType()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.overrideNetworkType = r6     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r6 = r2.isRoaming     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r6 = r6.booleanValue()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 != 0) goto L_0x089f
            java.lang.String r6 = r3.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r8 = "isRoaming = true"
            boolean r6 = r6.contains(r8)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r6 != 0) goto L_0x0898
            java.lang.String r3 = r3.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r6 = "isRoaming=true"
            boolean r3 = r3.contains(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r3 == 0) goto L_0x0896
            goto L_0x0898
        L_0x0896:
            r3 = 0
            goto L_0x0899
        L_0x0898:
            r3 = 1
        L_0x0899:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isRoaming = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x089f:
            r2.cellType = r14     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = "connectivity"
            java.lang.Object r3 = r1.getSystemService(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r6 = 21
            if (r4 < r6) goto L_0x08b7
            boolean r6 = r3.isDefaultNetworkActive()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isDefaultNetworkActive = r6     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x08b7:
            boolean r6 = r3.isActiveNetworkMetered()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isActiveNetworkMetered = r6     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r4 < r9) goto L_0x08c9
            int r3 = r3.getRestrictBackgroundStatus()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.getRestrictBackgroundStatus = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x08c9:
            java.util.ArrayList r3 = com.cellrebel.sdk.ping.IPTools.a()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = r3.toString()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r4 = "/"
            java.lang.String r3 = r3.replace(r4, r5)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.privateIp = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = com.cellrebel.sdk.ping.IPTools.a((android.content.Context) r19)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.gatewayIp = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r3 = h     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isOnScreen = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            com.cellrebel.sdk.utils.TelephonyHelper r3 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r3 = r3.c()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.signalStrength = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r1, r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r3 != 0) goto L_0x0902
            r3 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r5 = r3
            r3 = 1
        L_0x0900:
            r4 = 0
            goto L_0x0915
        L_0x0902:
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r1, r7)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r3 != 0) goto L_0x090f
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r5 = r4
            goto L_0x0900
        L_0x090f:
            r3 = 1
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
        L_0x0915:
            r2.locationPermissionState = r5     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            int r5 = androidx.core.app.ActivityCompat.checkSelfPermission(r1, r5)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            if (r5 != 0) goto L_0x0920
            r4 = 1
        L_0x0920:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isReadPhoneStatePermissionGranted = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            boolean r3 = i     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.isNrCellSeen = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r3 = com.cellrebel.sdk.utils.Utils.b((android.content.Context) r19)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.dozeModeState = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            int r3 = com.cellrebel.sdk.utils.Utils.a((android.content.Context) r19)     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.callState = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = android.os.Build.DEVICE     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.buildDevice = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = android.os.Build.HARDWARE     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.buildHardware = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r3 = android.os.Build.PRODUCT     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.buildProduct = r3     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            java.lang.String r1 = r19.getPackageName()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r2.appId = r1     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            r20.save()     // Catch:{ OutOfMemoryError -> 0x0953, Exception -> 0x0950 }
            goto L_0x0958
        L_0x0950:
            r0 = move-exception
        L_0x0951:
            r1 = r0
            goto L_0x0955
        L_0x0953:
            r0 = move-exception
            goto L_0x0951
        L_0x0955:
            r1.toString()
        L_0x0958:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.BaseMetricsWorker.a(android.content.Context, com.cellrebel.sdk.networking.beans.request.BaseMetric, java.util.List):void");
    }

    public static void a(Context context, BaseMetric baseMetric, List<CellInfo> list, Runnable runnable) {
        new a(context, baseMetric, list, runnable).execute(new Void[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (com.cellrebel.sdk.ping.IPTools.d(r3) == false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.cellrebel.sdk.networking.beans.request.BaseMetric r2, java.lang.String r3) {
        /*
            com.cellrebel.sdk.networking.ApiService r0 = com.cellrebel.sdk.networking.ApiClient.a()
            retrofit2.Call r3 = r0.a(r3)
            retrofit2.Response r3 = r3.execute()
            if (r3 == 0) goto L_0x0039
            java.lang.Object r0 = r3.body()
            if (r0 == 0) goto L_0x0039
            boolean r0 = r3.isSuccessful()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r3 = r3.body()
            okhttp3.ResponseBody r3 = (okhttp3.ResponseBody) r3
            java.lang.String r3 = r3.string()
            java.lang.String r0 = "[\\n\\t ]"
            java.lang.String r1 = ""
            java.lang.String r3 = r3.replaceAll(r0, r1)
            boolean r0 = com.cellrebel.sdk.ping.IPTools.c(r3)
            if (r0 != 0) goto L_0x003b
            boolean r0 = com.cellrebel.sdk.ping.IPTools.d(r3)
            if (r0 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            java.lang.String r3 = "0.0.0.0"
        L_0x003b:
            r2.clientIp = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.BaseMetricsWorker.a(com.cellrebel.sdk.networking.beans.request.BaseMetric, java.lang.String):void");
    }

    private static CellInfo b(List<CellInfo> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            for (CellInfo next : list) {
                if (next instanceof CellInfoNr) {
                    i = true;
                    CellInfoNr cellInfoNr = (CellInfoNr) next;
                    CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellInfoNr.getCellSignalStrength();
                    if (cellSignalStrengthNr.getCsiRsrq() != Integer.MAX_VALUE || cellSignalStrengthNr.getSsRsrq() != Integer.MAX_VALUE) {
                        return cellInfoNr;
                    }
                }
            }
        }
        return list.get(0);
    }

    private static String b(CellInfo cellInfo) {
        if (Build.VERSION.SDK_INT < 30 || !(cellInfo instanceof CellInfoLte)) {
            return null;
        }
        CellIdentityLte cellIdentity = ((CellInfoLte) cellInfo).getCellIdentity();
        if (cellIdentity.getBands().length > 0) {
            return Arrays.toString(cellIdentity.getBands());
        }
        return null;
    }

    private static CellInfoWcdma c(List<CellInfoWcdma> list) {
        return list.get(0);
    }

    private static String c(CellInfo cellInfo) {
        if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
            CellIdentity cellIdentity = ((CellInfoNr) cellInfo).getCellIdentity();
            if (cellIdentity instanceof CellIdentityNr) {
                return String.valueOf(((CellIdentityNr) cellIdentity).getNci());
            }
        }
        return cellInfo instanceof CellInfoLte ? String.valueOf(((CellInfoLte) cellInfo).getCellIdentity().getCi()) : cellInfo instanceof CellInfoWcdma ? String.valueOf(((CellInfoWcdma) cellInfo).getCellIdentity().getCid()) : cellInfo instanceof CellInfoGsm ? String.valueOf(((CellInfoGsm) cellInfo).getCellIdentity().getCid()) : "";
    }

    private static String d(CellInfo cellInfo) {
        int lac;
        if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
            CellIdentity cellIdentity = ((CellInfoNr) cellInfo).getCellIdentity();
            if (cellIdentity instanceof CellIdentityNr) {
                lac = ((CellIdentityNr) cellIdentity).getTac();
                return String.valueOf(lac);
            }
        }
        if (cellInfo instanceof CellInfoLte) {
            lac = ((CellInfoLte) cellInfo).getCellIdentity().getTac();
        } else if (cellInfo instanceof CellInfoWcdma) {
            lac = ((CellInfoWcdma) cellInfo).getCellIdentity().getLac();
        } else if (!(cellInfo instanceof CellInfoGsm)) {
            return "";
        } else {
            lac = ((CellInfoGsm) cellInfo).getCellIdentity().getLac();
        }
        return String.valueOf(lac);
    }

    private static String e(CellInfo cellInfo) {
        if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
            CellIdentity cellIdentity = ((CellInfoNr) cellInfo).getCellIdentity();
            if (cellIdentity instanceof CellIdentityNr) {
                return ((CellIdentityNr) cellIdentity).getMccString();
            }
        }
        if (cellInfo instanceof CellInfoLte) {
            return String.valueOf(((CellInfoLte) cellInfo).getCellIdentity().getMcc());
        }
        if (cellInfo instanceof CellInfoWcdma) {
            return String.valueOf(((CellInfoWcdma) cellInfo).getCellIdentity().getMcc());
        }
        if (cellInfo instanceof CellInfoGsm) {
            return String.valueOf(((CellInfoGsm) cellInfo).getCellIdentity().getMcc());
        }
        return null;
    }

    private static String f(CellInfo cellInfo) {
        if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
            CellIdentity cellIdentity = ((CellInfoNr) cellInfo).getCellIdentity();
            if (cellIdentity instanceof CellIdentityNr) {
                return ((CellIdentityNr) cellIdentity).getMncString();
            }
        }
        if (cellInfo instanceof CellInfoLte) {
            return String.valueOf(((CellInfoLte) cellInfo).getCellIdentity().getMnc());
        }
        if (cellInfo instanceof CellInfoWcdma) {
            return String.valueOf(((CellInfoWcdma) cellInfo).getCellIdentity().getMnc());
        }
        if (cellInfo instanceof CellInfoGsm) {
            return String.valueOf(((CellInfoGsm) cellInfo).getCellIdentity().getMnc());
        }
        return null;
    }

    private static String g(CellInfo cellInfo) {
        if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
            CellIdentity cellIdentity = ((CellInfoNr) cellInfo).getCellIdentity();
            if (cellIdentity instanceof CellIdentityNr) {
                return String.valueOf(((CellIdentityNr) cellIdentity).getMncString());
            }
        }
        return cellInfo instanceof CellInfoLte ? String.valueOf(((CellInfoLte) cellInfo).getCellIdentity().getMnc()) : cellInfo instanceof CellInfoWcdma ? String.valueOf(((CellInfoWcdma) cellInfo).getCellIdentity().getMnc()) : cellInfo instanceof CellInfoGsm ? String.valueOf(((CellInfoGsm) cellInfo).getCellIdentity().getMnc()) : "";
    }

    public void a(Context context) {
    }
}
