package com.cellrebel.sdk.workers;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.CellInfo;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.CellInfoMetric;
import com.cellrebel.sdk.networking.beans.request.CoverageMetric;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectCoverageMetricsWorker extends BaseMetricsWorker {
    public String j;
    Set<CellInfo> k = new HashSet();

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void a(Context context, List<CellInfo> list) {
        if (list != null && list.size() != 0) {
            CoverageMetric coverageMetric = new CoverageMetric();
            BaseMetricsWorker.a(context, (BaseMetric) coverageMetric);
            ArrayList arrayList = new ArrayList();
            for (CellInfo next : list) {
                if (!this.k.contains(next)) {
                    CellInfoMetric cellInfoMetric = new CellInfoMetric();
                    cellInfoMetric.fill((BaseMetric) coverageMetric);
                    cellInfoMetric.fill(next);
                    Location b = TrackingHelper.a().b();
                    if (b != null) {
                        cellInfoMetric.latitude(b.getLatitude());
                        cellInfoMetric.longitude(b.getLongitude());
                        cellInfoMetric.gpsAccuracy((double) b.getAccuracy());
                        cellInfoMetric.altitude(b.getAltitude());
                        cellInfoMetric.locationSpeed(Float.valueOf(b.getSpeed()));
                        if (Build.VERSION.SDK_INT >= 26) {
                            cellInfoMetric.locationSpeedAccuracy(Float.valueOf(b.getSpeedAccuracyMetersPerSecond()));
                        }
                        cellInfoMetric.locationAge((int) ((System.currentTimeMillis() - b.getTime()) / 1000));
                    }
                    cellInfoMetric.dateTimeOfMeasurement(String.valueOf(System.currentTimeMillis() / 1000));
                    cellInfoMetric.measurementSequenceId = this.j;
                    cellInfoMetric.stateDuringMeasurement = Utils.a(BaseMetricsWorker.h, this.c, (PowerManager) context.getSystemService("power"), this.b, this.d, this.e, this.f, this.g);
                    arrayList.add(cellInfoMetric);
                    this.k.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                coverageMetric.cellInfoMetricsJSON = new Gson().toJson((Object) arrayList);
                try {
                    DatabaseClient.a().e().a(coverageMetric);
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[Catch:{ Exception | OutOfMemoryError -> 0x01b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            super.a((android.content.Context) r27)
            java.util.Set<android.telephony.CellInfo> r2 = r0.k
            r2.clear()
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r2 != 0) goto L_0x0017
            return
        L_0x0017:
            boolean r3 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r3 == 0) goto L_0x002a
            java.lang.Integer r4 = r2.foregroundCoverageSamplingInterval     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r4 == 0) goto L_0x002a
            java.lang.Integer r5 = r2.foregroundCoverageTimeout     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r5 == 0) goto L_0x002a
            int r3 = r4.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.Integer r2 = r2.foregroundCoverageTimeout     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            goto L_0x003a
        L_0x002a:
            if (r3 != 0) goto L_0x003f
            java.lang.Integer r3 = r2.backgroundCoverageSamplingInterval     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r3 == 0) goto L_0x003f
            java.lang.Integer r4 = r2.backgroundCoverageTimeout     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r4 == 0) goto L_0x003f
            int r3 = r3.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.Integer r2 = r2.backgroundCoverageTimeout     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
        L_0x003a:
            int r2 = r2.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            goto L_0x0043
        L_0x003f:
            r3 = 100
            r2 = 60
        L_0x0043:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r6 = 0
            r7 = 0
        L_0x004a:
            if (r6 != 0) goto L_0x01b6
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            long r11 = r9 - r4
            int r13 = r2 * 1000
            long r13 = (long) r13     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x005a
            r6 = 1
        L_0x005a:
            long r11 = (long) r3     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.Thread.sleep(r11)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            long r9 = r9 - r7
            r11 = 5000(0x1388, double:2.4703E-320)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0075
            com.cellrebel.sdk.utils.TelephonyHelper r7 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.workers.CollectCoverageMetricsWorker$$ExternalSyntheticLambda0 r8 = new com.cellrebel.sdk.workers.CollectCoverageMetricsWorker$$ExternalSyntheticLambda0     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r8.<init>(r0, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r7.a((android.content.Context) r1, (com.cellrebel.sdk.utils.TelephonyHelper.CellInfoCallback) r8)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
        L_0x0075:
            com.cellrebel.sdk.utils.TrackingHelper r9 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            android.telephony.TelephonyManager r9 = r9.h(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r9 != 0) goto L_0x0080
            return
        L_0x0080:
            java.lang.String r9 = "android.permission.ACCESS_COARSE_LOCATION"
            int r9 = androidx.core.app.ActivityCompat.checkSelfPermission(r1, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r9 == 0) goto L_0x0089
            return
        L_0x0089:
            com.cellrebel.sdk.utils.TelephonyHelper r9 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.util.List r9 = r9.a((android.content.Context) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r9 == 0) goto L_0x0099
            int r10 = r9.size()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r10 != 0) goto L_0x00ac
        L_0x0099:
            com.cellrebel.sdk.utils.TrackingHelper r9 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            android.telephony.TelephonyManager r9 = r9.i(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r9 != 0) goto L_0x00a4
            return
        L_0x00a4:
            com.cellrebel.sdk.utils.TelephonyHelper r9 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.util.List r9 = r9.a((android.content.Context) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
        L_0x00ac:
            if (r9 == 0) goto L_0x01b5
            int r10 = r9.size()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r10 != 0) goto L_0x00b6
            goto L_0x01b5
        L_0x00b6:
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r10 = new com.cellrebel.sdk.networking.beans.request.CoverageMetric     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r10.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r1, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r10)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r11.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
        L_0x00c7:
            boolean r12 = r9.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r12 == 0) goto L_0x0181
            java.lang.Object r12 = r9.next()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            android.telephony.CellInfo r12 = (android.telephony.CellInfo) r12     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.networking.beans.request.CellInfoMetric r13 = new com.cellrebel.sdk.networking.beans.request.CellInfoMetric     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.fill((com.cellrebel.sdk.networking.beans.request.BaseMetric) r10)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.fill((android.telephony.CellInfo) r12)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.utils.TrackingHelper r12 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            android.location.Location r12 = r12.b()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r12 == 0) goto L_0x0133
            double r14 = r12.getLatitude()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.latitude(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            double r14 = r12.getLongitude()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.longitude(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            float r14 = r12.getAccuracy()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            double r14 = (double) r14     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.gpsAccuracy(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            double r14 = r12.getAltitude()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.altitude(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            float r14 = r12.getSpeed()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.Float r14 = java.lang.Float.valueOf(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.locationSpeed(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r15 = 26
            if (r14 < r15) goto L_0x0121
            float r14 = r12.getSpeedAccuracyMetersPerSecond()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.Float r14 = java.lang.Float.valueOf(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.locationSpeedAccuracy(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
        L_0x0121:
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            long r18 = r12.getTime()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            long r14 = r14 - r18
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 / r16
            int r12 = (int) r14     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.locationAge(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
        L_0x0133:
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 / r16
            java.lang.String r12 = java.lang.String.valueOf(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.dateTimeOfMeasurement(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.String r12 = r0.j     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.measurementSequenceId = r12     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.String r12 = "power"
            java.lang.Object r12 = r1.getSystemService(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r16 = r12
            android.os.PowerManager r16 = (android.os.PowerManager) r16     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            boolean r14 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            boolean r15 = r0.c     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            boolean r12 = r0.b     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            boolean r1 = r0.d     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r22 = r2
            boolean r2 = r0.e     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r23 = r3
            boolean r3 = r0.f     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r24 = r4
            boolean r4 = r0.g     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r17 = r12
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            int r1 = com.cellrebel.sdk.utils.Utils.a(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r13.stateDuringMeasurement = r1     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r11.add(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r1 = r27
            r2 = r22
            r3 = r23
            r4 = r24
            goto L_0x00c7
        L_0x0181:
            r22 = r2
            r23 = r3
            r24 = r4
            boolean r1 = r11.isEmpty()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r1 == 0) goto L_0x018e
            return
        L_0x018e:
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            java.lang.String r1 = r1.toJson((java.lang.Object) r11)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r10.cellInfoMetricsJSON = r1     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.database.SDKRoomDatabase r1 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            if (r1 != 0) goto L_0x01a0
            return
        L_0x01a0:
            com.cellrebel.sdk.database.SDKRoomDatabase r1 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            com.cellrebel.sdk.database.dao.CoverageMetricDAO r1 = r1.e()     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r1.a((com.cellrebel.sdk.networking.beans.request.CoverageMetric) r10)     // Catch:{ Exception | OutOfMemoryError -> 0x01b6 }
            r1 = r27
            r2 = r22
            r3 = r23
            r4 = r24
            goto L_0x004a
        L_0x01b5:
            return
        L_0x01b6:
            java.util.Set<android.telephony.CellInfo> r1 = r0.k
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectCoverageMetricsWorker.a(android.content.Context):void");
    }
}
