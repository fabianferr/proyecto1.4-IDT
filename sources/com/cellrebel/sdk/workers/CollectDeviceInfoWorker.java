package com.cellrebel.sdk.workers;

import android.content.Context;
import android.webkit.WebView;
import com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric;
import java.util.concurrent.CountDownLatch;

public class CollectDeviceInfoWorker extends BaseMetricsWorker {
    private CountDownLatch j = new CountDownLatch(1);
    String k;

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.j.countDown();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DeviceInfoMetric deviceInfoMetric, Context context) {
        try {
            deviceInfoMetric.userAgent = new WebView(context).getSettings().getUserAgentString();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x01de */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a3 A[Catch:{ Exception -> 0x01e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a5 A[Catch:{ Exception -> 0x01e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b2 A[Catch:{ Exception -> 0x01e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4 A[Catch:{ Exception -> 0x01e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r11) {
        /*
            r10 = this;
            com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric r9 = new com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.<init>()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r0 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "power"
            java.lang.Object r1 = r11.getSystemService(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r3 = r1
            android.os.PowerManager r3 = (android.os.PowerManager) r3     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r1 = r1.c()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            if (r1 != 0) goto L_0x0030
            r0 = 500(0x1f4, float:7.0E-43)
            r9.stateDuringMeasurement(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            goto L_0x004e
        L_0x0030:
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            if (r0 != 0) goto L_0x003c
            r0 = 501(0x1f5, float:7.02E-43)
            r9.stateDuringMeasurement(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            goto L_0x004e
        L_0x003c:
            boolean r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r2 = r10.c     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r4 = r10.b     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r5 = r10.d     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r6 = r10.e     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r7 = r10.f     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            boolean r8 = r10.g     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r0 = r9
            com.cellrebel.sdk.utils.Utils.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
        L_0x004e:
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r0.<init>()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1 = 0
            android.content.Intent r0 = r11.registerReceiver(r1, r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = r1.s()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.deviceBrand = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = r1.t()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.deviceModel = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = r1.g()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.deviceVersion = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "Android"
            r9.os = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.osVersion = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.database.ConnectionType r1 = r1.a((android.content.Context) r11)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.database.ConnectionType r2 = com.cellrebel.sdk.database.ConnectionType.FOUR_G     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L_0x0098
            com.cellrebel.sdk.database.ConnectionType r2 = com.cellrebel.sdk.database.ConnectionType.FOUR_G_CA     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            if (r1 != r2) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r2 = 0
            goto L_0x0099
        L_0x0098:
            r2 = 1
        L_0x0099:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.is4gCapable = r2     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.database.ConnectionType r2 = com.cellrebel.sdk.database.ConnectionType.FIVE_G     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            if (r1 != r2) goto L_0x00a5
            r1 = 1
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.is5gCapable = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r2 = 22
            if (r1 < r2) goto L_0x00de
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r11.getSystemService(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Class r2 = r1.getClass()     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            java.lang.String r5 = "isVolteAvailable"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            java.lang.Object r1 = r2.invoke(r1, r5)     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x00d3, all -> 0x01e2 }
            goto L_0x00d8
        L_0x00d3:
            r1 = move-exception
            r1.toString()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1 = 0
        L_0x00d8:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.volteSupport = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
        L_0x00de:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r2 = 24
            if (r1 < r2) goto L_0x00f7
            java.util.Calendar r1 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            long r5 = android.os.Build.TIME     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1.setTimeInMillis(r5)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r1 = r1.get(r3)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.deviceYear = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
        L_0x00f7:
            com.cellrebel.sdk.utils.CpuUtilisationReader r1 = new com.cellrebel.sdk.utils.CpuUtilisationReader     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1.<init>()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1.j()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r1 = r1.b()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.cpuUsage = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = com.cellrebel.sdk.utils.Utils.f()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.maximumStorage = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = com.cellrebel.sdk.utils.Utils.g()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.freeStorage = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r1 = com.cellrebel.sdk.utils.Utils.e(r11)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.ram = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r1 = com.cellrebel.sdk.utils.Utils.c(r11)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.freeRam = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "level"
            r2 = -1
            int r1 = r0.getIntExtra(r1, r2)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r5 = "scale"
            int r5 = r0.getIntExtra(r5, r2)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r1 = r1 * 100
            float r1 = (float) r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            float r1 = r1 / r5
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.batteryLevel = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "status"
            int r1 = r0.getIntExtra(r1, r2)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.batteryState = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "plugged"
            int r1 = r0.getIntExtra(r1, r2)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.batteryChargeType = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "health"
            int r1 = r0.getIntExtra(r1, r4)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.batteryHealth = r1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r1 = "temperature"
            int r0 = r0.getIntExtra(r1, r4)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            float r0 = (float) r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.batteryTemperature = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r0 = r0.getDisplayLanguage()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.language = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.util.Locale r0 = r0.locale     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.locale = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            long r0 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.elapsedRealtimeNanos = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.workers.CollectDeviceInfoWorker$$ExternalSyntheticLambda0 r1 = new com.cellrebel.sdk.workers.CollectDeviceInfoWorker$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r1.<init>(r9, r11)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r0.post(r1)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.content.res.Resources r0 = r11.getResources()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r0 = r0.widthPixels     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.screenWidth = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.content.res.Resources r0 = r11.getResources()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            int r0 = r0.heightPixels     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.screenHeight = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.lang.String r0 = r10.k     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r9.measurementSequenceId = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r10.j = r0     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.workers.CollectDeviceInfoWorker$$ExternalSyntheticLambda1 r0 = new com.cellrebel.sdk.workers.CollectDeviceInfoWorker$$ExternalSyntheticLambda1     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r11, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r9, (java.lang.Runnable) r0)     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            java.util.concurrent.CountDownLatch r11 = r10.j     // Catch:{ InterruptedException -> 0x01de }
            r11.await()     // Catch:{ InterruptedException -> 0x01de }
        L_0x01de:
            r9.toString()     // Catch:{ Exception -> 0x01e4, all -> 0x01e2 }
            goto L_0x01e4
        L_0x01e2:
            r11 = move-exception
            throw r11
        L_0x01e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectDeviceInfoWorker.a(android.content.Context):void");
    }
}
