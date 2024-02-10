package com.cellrebel.sdk.workers;

import android.content.Context;
import android.telephony.CellInfo;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CollectCdnDownloadMetricsWorker extends BaseMetricsWorker {
    private CountDownLatch j = new CountDownLatch(2);
    String k;
    String l;
    String m;
    private ConnectionType n;
    private int o;
    private long p;
    private long q;
    private List<CellInfo> r;
    private final ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService t = Executors.newSingleThreadScheduledExecutor();

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.j.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x003f */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0092 A[Catch:{ Exception | OutOfMemoryError -> 0x013f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(int r12, com.cellrebel.sdk.networking.RequestEventListener r13, com.cellrebel.sdk.networking.beans.request.FileTransferMetric r14, android.content.Context r15) {
        /*
            r11 = this;
            okhttp3.OkHttpClient$Builder r0 = new okhttp3.OkHttpClient$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r0.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r1 = 0
            okhttp3.OkHttpClient$Builder r0 = r0.cache(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            long r2 = (long) r12     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.OkHttpClient$Builder r0 = r0.readTimeout(r2, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.OkHttpClient$Builder r0 = r0.writeTimeout(r2, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.OkHttpClient$Builder r0 = r0.connectTimeout(r2, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r2 = 0
            okhttp3.OkHttpClient$Builder r0 = r0.retryOnConnectionFailure(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda5 r3 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda5     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r3.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r0.addInterceptor(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.lang.String r3 = "TLSv1.2"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
            r3.init(r1, r1, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
            com.cellrebel.sdk.networking.TLSSocketFactory r1 = new com.cellrebel.sdk.networking.TLSSocketFactory     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
            javax.net.ssl.SSLSocketFactory r3 = r3.getSocketFactory()     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
            r1.<init>(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
            com.cellrebel.sdk.networking.FullX509TrustManager r3 = com.cellrebel.sdk.networking.ApiClient.b()     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
            r0.sslSocketFactory(r1, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x003f }
        L_0x003f:
            okhttp3.ConnectionSpec$Builder r1 = new okhttp3.ConnectionSpec$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.ConnectionSpec r3 = okhttp3.ConnectionSpec.MODERN_TLS     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r1.<init>((okhttp3.ConnectionSpec) r3)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r3 = 1
            okhttp3.TlsVersion[] r4 = new okhttp3.TlsVersion[r3]     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.TlsVersion r5 = okhttp3.TlsVersion.TLS_1_2     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4[r2] = r5     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.ConnectionSpec$Builder r1 = r1.tlsVersions((okhttp3.TlsVersion[]) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.ConnectionSpec r1 = r1.build()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4.add(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.COMPATIBLE_TLS     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4.add(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4.add(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r0.connectionSpecs(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r0.eventListener(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.OkHttpClient r13 = r0.build()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.lang.String r5 = r11.m     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.Request$Builder r4 = r4.url((java.lang.String) r5)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.Request r4 = r4.build()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.Call r13 = r13.newCall(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            okhttp3.Response r13 = r13.execute()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            boolean r4 = r13.isSuccessful()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            if (r4 == 0) goto L_0x013f
            okhttp3.ResponseBody r13 = r13.body()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            com.cellrebel.sdk.networking.beans.response.ProgressResponseBody r13 = (com.cellrebel.sdk.networking.beans.response.ProgressResponseBody) r13     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.io.File r4 = new java.io.File     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.lang.String r5 = r11.l     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            r4.<init>(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.io.InputStream r5 = r13.byteStream()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0130 }
            r6.<init>(r4)     // Catch:{ all -> 0x0130 }
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x0115 }
        L_0x00ac:
            int r8 = r5.read(r7)     // Catch:{ IOException -> 0x0115 }
            r9 = -1
            if (r8 != r9) goto L_0x0102
            r6.flush()     // Catch:{ IOException -> 0x0115 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0106 }
            long r7 = r7 - r0
            int r12 = r12 * 1000
            long r9 = (long) r12     // Catch:{ all -> 0x0106 }
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 > 0) goto L_0x00e7
            long r12 = r13.firstByteTime     // Catch:{ all -> 0x0106 }
            long r12 = r12 - r0
            long r0 = r4.length()     // Catch:{ all -> 0x0106 }
            r9 = 0
            int r4 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d4
            r9 = 1024(0x400, double:5.06E-321)
            long r0 = r0 / r9
            r14.fileSize = r0     // Catch:{ all -> 0x0106 }
        L_0x00d4:
            r14.isFileDownLoaded(r3)     // Catch:{ all -> 0x0106 }
            r14.downLoadFileTime(r7)     // Catch:{ all -> 0x0106 }
            r14.downloadFirstByteTime(r12)     // Catch:{ all -> 0x0106 }
            com.cellrebel.sdk.utils.TelephonyHelper r12 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ all -> 0x0106 }
            java.util.List r12 = r12.a((android.content.Context) r15)     // Catch:{ all -> 0x0106 }
            r11.r = r12     // Catch:{ all -> 0x0106 }
        L_0x00e7:
            java.util.List r12 = java.util.Collections.singletonList(r6)     // Catch:{ all -> 0x0130 }
            java.lang.Object r12 = r12.get(r2)     // Catch:{ all -> 0x0130 }
            if (r12 == 0) goto L_0x00f4
            r6.close()     // Catch:{ all -> 0x0130 }
        L_0x00f4:
            java.util.List r12 = java.util.Collections.singletonList(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.lang.Object r12 = r12.get(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            if (r12 == 0) goto L_0x013f
            r5.close()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            goto L_0x013f
        L_0x0102:
            r6.write(r7, r2, r8)     // Catch:{ IOException -> 0x0115 }
            goto L_0x00ac
        L_0x0106:
            r12 = move-exception
            java.util.List r13 = java.util.Collections.singletonList(r6)     // Catch:{ all -> 0x0130 }
            java.lang.Object r13 = r13.get(r2)     // Catch:{ all -> 0x0130 }
            if (r13 == 0) goto L_0x0114
            r6.close()     // Catch:{ all -> 0x0130 }
        L_0x0114:
            throw r12     // Catch:{ all -> 0x0130 }
        L_0x0115:
            java.util.List r12 = java.util.Collections.singletonList(r6)     // Catch:{ all -> 0x0130 }
            java.lang.Object r12 = r12.get(r2)     // Catch:{ all -> 0x0130 }
            if (r12 == 0) goto L_0x0122
            r6.close()     // Catch:{ all -> 0x0130 }
        L_0x0122:
            java.util.List r12 = java.util.Collections.singletonList(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.lang.Object r12 = r12.get(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            if (r12 == 0) goto L_0x012f
            r5.close()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
        L_0x012f:
            return
        L_0x0130:
            r12 = move-exception
            java.util.List r13 = java.util.Collections.singletonList(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            java.lang.Object r13 = r13.get(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
            if (r13 == 0) goto L_0x013e
            r5.close()     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
        L_0x013e:
            throw r12     // Catch:{ Exception | OutOfMemoryError -> 0x013f }
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker.a(int, com.cellrebel.sdk.networking.RequestEventListener, com.cellrebel.sdk.networking.beans.request.FileTransferMetric, android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        try {
            this.j.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Context context) {
        try {
            ConnectionType a = TrackingHelper.a().a(context);
            if (a != this.n) {
                this.o++;
            }
            this.n = a;
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        try {
            this.j.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:8|9|10|11|12|13|14|15|(1:17)|18|(1:20)|21|22|23|24|25|(1:30)(1:29)|(3:31|32|36)) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x00db */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x014a */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0156 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0161 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:31:0x0169] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r14) {
        /*
            r13 = this;
            super.a((android.content.Context) r14)
            java.lang.String r0 = r13.m     // Catch:{  }
            java.lang.String r0 = com.cellrebel.sdk.utils.Utils.b((java.lang.String) r0)     // Catch:{  }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
            r1.<init>()     // Catch:{  }
            java.io.File r2 = r14.getCacheDir()     // Catch:{  }
            r1.append(r2)     // Catch:{  }
            java.lang.String r2 = java.io.File.separator     // Catch:{  }
            r1.append(r2)     // Catch:{  }
            r1.append(r0)     // Catch:{  }
            java.lang.String r0 = r1.toString()     // Catch:{  }
            r13.l = r0     // Catch:{  }
            java.lang.String r0 = "power"
            java.lang.Object r0 = r14.getSystemService(r0)     // Catch:{  }
            r4 = r0
            android.os.PowerManager r4 = (android.os.PowerManager) r4     // Catch:{  }
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r14)     // Catch:{  }
            r13.n = r0     // Catch:{  }
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda0 r6 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda0     // Catch:{  }
            r6.<init>(r13, r14)     // Catch:{  }
            java.util.concurrent.ScheduledExecutorService r5 = r13.s     // Catch:{  }
            r7 = 0
            r9 = 500(0x1f4, double:2.47E-321)
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{  }
            java.util.concurrent.ScheduledFuture r0 = r5.scheduleAtFixedRate(r6, r7, r9, r11)     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.FileTransferMetric r11 = new com.cellrebel.sdk.networking.beans.request.FileTransferMetric     // Catch:{  }
            r11.<init>()     // Catch:{  }
            java.lang.String r1 = r13.k     // Catch:{  }
            r11.measurementSequenceId = r1     // Catch:{  }
            java.lang.String r1 = r13.m     // Catch:{  }
            r11.serverIdFileLoad(r1)     // Catch:{  }
            java.lang.String r1 = r13.m     // Catch:{  }
            java.lang.String r1 = com.cellrebel.sdk.ping.IPTools.a((java.lang.String) r1)     // Catch:{  }
            r11.serverIp = r1     // Catch:{  }
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            boolean r1 = r1.c()     // Catch:{  }
            r12 = 1
            if (r1 != 0) goto L_0x0084
            r0 = 500(0x1f4, float:7.0E-43)
            r11.stateDuringMeasurement(r0)     // Catch:{  }
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{  }
            r0.<init>(r12)     // Catch:{  }
            r13.j = r0     // Catch:{  }
            r13.a = r12     // Catch:{  }
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda1 r0 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda1     // Catch:{  }
            r0.<init>(r13)     // Catch:{  }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r14, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r11, (java.lang.Runnable) r0)     // Catch:{  }
            java.util.concurrent.CountDownLatch r14 = r13.j     // Catch:{ InterruptedException -> 0x0083 }
            r14.await()     // Catch:{ InterruptedException -> 0x0083 }
        L_0x0083:
            return
        L_0x0084:
            boolean r2 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{  }
            boolean r3 = r13.c     // Catch:{  }
            boolean r5 = r13.b     // Catch:{  }
            boolean r6 = r13.d     // Catch:{  }
            boolean r7 = r13.e     // Catch:{  }
            boolean r8 = r13.f     // Catch:{  }
            boolean r9 = r13.g     // Catch:{  }
            r1 = r11
            com.cellrebel.sdk.utils.Utils.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{  }
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.database.ConnectionType r1 = r1.a((android.content.Context) r14)     // Catch:{  }
            r13.n = r1     // Catch:{  }
            java.lang.String r1 = r1.toString()     // Catch:{  }
            r11.downloadAccessTechStart(r1)     // Catch:{  }
            long r1 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{  }
            r13.q = r1     // Catch:{  }
            long r1 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{  }
            r13.p = r1     // Catch:{  }
            com.cellrebel.sdk.networking.RequestEventListener r1 = new com.cellrebel.sdk.networking.RequestEventListener     // Catch:{  }
            r1.<init>()     // Catch:{  }
            com.cellrebel.sdk.utils.PreferencesManager r2 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{  }
            long r2 = r2.k()     // Catch:{  }
            int r3 = (int) r2     // Catch:{  }
            java.util.concurrent.ScheduledExecutorService r2 = r13.t     // Catch:{  }
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda2 r4 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda2     // Catch:{  }
            r5 = r4
            r6 = r13
            r7 = r3
            r8 = r1
            r9 = r11
            r10 = r14
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{  }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{  }
            r6 = 0
            java.util.concurrent.ScheduledFuture r2 = r2.schedule(r4, r6, r5)     // Catch:{  }
            long r3 = (long) r3
            r2.get(r3, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x00db }
            goto L_0x00de
        L_0x00db:
            r2.cancel(r12)     // Catch:{  }
        L_0x00de:
            int r2 = r1.a     // Catch:{  }
            long r2 = (long) r2     // Catch:{  }
            r11.dnsLookupTime = r2     // Catch:{  }
            int r2 = r1.b     // Catch:{  }
            long r2 = (long) r2     // Catch:{  }
            r11.tcpConnectTime = r2     // Catch:{  }
            int r2 = r1.c     // Catch:{  }
            long r2 = (long) r2     // Catch:{  }
            r11.tlsSetupTime = r2     // Catch:{  }
            boolean r2 = r11.isFileDownLoaded     // Catch:{  }
            if (r2 == 0) goto L_0x010a
            int r2 = r13.o     // Catch:{  }
            r11.downloadAccessTechNumChanges(r2)     // Catch:{  }
            long r2 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{  }
            long r4 = r13.q     // Catch:{  }
            long r2 = r2 - r4
            r11.bytesReceived(r2)     // Catch:{  }
            long r2 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{  }
            long r4 = r13.p     // Catch:{  }
            long r2 = r2 - r4
            r11.bytesSent(r2)     // Catch:{  }
        L_0x010a:
            com.cellrebel.sdk.utils.TrackingHelper r2 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.database.ConnectionType r2 = r2.a((android.content.Context) r14)     // Catch:{  }
            r13.n = r2     // Catch:{  }
            java.lang.String r2 = r2.toString()     // Catch:{  }
            r11.downloadAccessTechEnd(r2)     // Catch:{  }
            com.cellrebel.sdk.utils.TrackingHelper r2 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            java.lang.String r3 = r13.m     // Catch:{  }
            com.cellrebel.sdk.utils.LatencyItem r2 = r2.b((java.lang.String) r3)     // Catch:{  }
            int r3 = r2.a()     // Catch:{  }
            if (r3 != 0) goto L_0x0130
            int r1 = r1.d     // Catch:{  }
            r2.a(r1)     // Catch:{  }
        L_0x0130:
            int r1 = r2.a()     // Catch:{  }
            r11.latency = r1     // Catch:{  }
            int r1 = r2.b()     // Catch:{  }
            r11.latencyType = r1     // Catch:{  }
            long r1 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{  }
            r13.p = r1     // Catch:{  }
            r0.cancel(r12)     // Catch:{  }
            java.util.concurrent.CountDownLatch r0 = r13.j     // Catch:{ Exception | OutOfMemoryError -> 0x014a }
            r0.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x014a }
        L_0x014a:
            r13.a = r12     // Catch:{  }
            java.util.List<android.telephony.CellInfo> r0 = r13.r     // Catch:{  }
            if (r0 == 0) goto L_0x0161
            boolean r0 = r0.isEmpty()     // Catch:{  }
            if (r0 != 0) goto L_0x0161
            java.util.List<android.telephony.CellInfo> r0 = r13.r     // Catch:{  }
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda3 r1 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda3     // Catch:{  }
            r1.<init>(r13)     // Catch:{  }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r14, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r11, (java.util.List<android.telephony.CellInfo>) r0, (java.lang.Runnable) r1)     // Catch:{  }
            goto L_0x0169
        L_0x0161:
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda4 r0 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda4     // Catch:{  }
            r0.<init>(r13)     // Catch:{  }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r14, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r11, (java.lang.Runnable) r0)     // Catch:{  }
        L_0x0169:
            java.util.concurrent.CountDownLatch r14 = r13.j     // Catch:{ Exception | OutOfMemoryError -> 0x016e, Exception | OutOfMemoryError -> 0x016e }
            r14.await()     // Catch:{ Exception | OutOfMemoryError -> 0x016e, Exception | OutOfMemoryError -> 0x016e }
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker.a(android.content.Context):void");
    }
}
