package com.cellrebel.sdk.workers;

import android.content.Context;
import android.text.TextUtils;
import com.cellrebel.sdk.networking.ApiClient;
import com.cellrebel.sdk.networking.RequestEventListener;
import com.cellrebel.sdk.networking.TLSSocketFactory;
import com.cellrebel.sdk.networking.TokenAuthenticator;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;
import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import com.cellrebel.sdk.networking.beans.response.ProgressResponseBody;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.http.client.cache.HeaderConstants;

public class CollectLoadedLatencyWorker extends CollectGameWorker {
    String r;
    private final Settings s = SettingsManager.b().c();
    private Context t;
    private String u;
    private CountDownLatch v = new CountDownLatch(1);
    private List<GameInfoMetric> w;
    private final RequestEventListener x = new RequestEventListener();
    private final ExecutorService y = Executors.newSingleThreadExecutor();

    class a implements Runnable {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ GameInfoMetric b;
        final /* synthetic */ int c;
        final /* synthetic */ Context d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ CountDownLatch g;

        a(boolean[] zArr, GameInfoMetric gameInfoMetric, int i, Context context, int i2, int i3, CountDownLatch countDownLatch) {
            this.a = zArr;
            this.b = gameInfoMetric;
            this.c = i;
            this.d = context;
            this.e = i2;
            this.f = i3;
            this.g = countDownLatch;
        }

        public void run() {
            this.a[0] = true;
            this.b.fileTransferId = Integer.valueOf(this.c);
            CollectLoadedLatencyWorker.this.a(this.d, this.b, this.e, this.f);
            this.a[0] = false;
            this.g.countDown();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Response a(Interceptor.Chain chain) {
        Request request = chain.request();
        if (!TextUtils.isEmpty(PreferencesManager.m().w())) {
            request = request.newBuilder().addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE).build();
        }
        Response proceed = chain.proceed(request);
        return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), (ProgressResponseBody.ProgressListener) null)).build();
    }

    private void a(FileTransferMetric fileTransferMetric) {
        Objects.toString(fileTransferMetric);
        fileTransferMetric.measurementSequenceId = this.r;
        fileTransferMetric.downloadAccessTechEnd = TrackingHelper.a().a(this.t).toString();
        fileTransferMetric.downloadAccessTechStart = this.u;
        this.v = new CountDownLatch(1);
        BaseMetricsWorker.a(this.t, (BaseMetric) fileTransferMetric, (Runnable) new CollectLoadedLatencyWorker$$ExternalSyntheticLambda1(this));
        try {
            this.v.await();
        } catch (InterruptedException unused) {
        }
        Objects.toString(fileTransferMetric);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        try {
            this.v.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        try {
            this.v.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    private OkHttpClient d() {
        OkHttpClient.Builder cache = new OkHttpClient.Builder().cache((Cache) null);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder retryOnConnectionFailure = cache.readTimeout(1, timeUnit).writeTimeout(1, timeUnit).connectTimeout(1, timeUnit).retryOnConnectionFailure(false);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        retryOnConnectionFailure.addInterceptor(httpLoggingInterceptor);
        retryOnConnectionFailure.eventListener(this.x);
        retryOnConnectionFailure.authenticator(new TokenAuthenticator());
        retryOnConnectionFailure.addInterceptor(new CollectLoadedLatencyWorker$$ExternalSyntheticLambda0());
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            retryOnConnectionFailure.sslSocketFactory(new TLSSocketFactory(instance.getSocketFactory()), ApiClient.b());
        } catch (Exception | OutOfMemoryError unused) {
        }
        ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
        arrayList.add(ConnectionSpec.CLEARTEXT);
        retryOnConnectionFailure.connectionSpecs(arrayList);
        return retryOnConnectionFailure.build();
    }

    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=?, for r6v1, types: [boolean] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r13v1, types: [boolean, int] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0131 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0278 A[Catch:{ Exception -> 0x027d }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028e A[Catch:{ Exception -> 0x02a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0183 A[Catch:{ Exception -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x025b A[Catch:{ IOException -> 0x025f, all -> 0x027f }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x026b A[Catch:{ IOException -> 0x025f, all -> 0x027f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r31) {
        /*
            r30 = this;
            r10 = r30
            r11 = r31
            boolean r12 = com.cellrebel.sdk.utils.Utils.e()
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r11)
            java.lang.String r0 = r0.toString()
            r10.u = r0
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            java.lang.String.valueOf(r0)
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r9 = new com.cellrebel.sdk.networking.beans.request.GameInfoMetric
            r9.<init>()
            java.lang.String r0 = r10.r
            r9.measurementSequenceId = r0
            java.lang.String r0 = "power"
            java.lang.Object r0 = r11.getSystemService(r0)
            r16 = r0
            android.os.PowerManager r16 = (android.os.PowerManager) r16
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0042
            r0 = 500(0x1f4, float:7.0E-43)
        L_0x003f:
            r9.stateDuringMeasurement = r0
            goto L_0x0063
        L_0x0042:
            if (r12 != 0) goto L_0x0047
            r0 = 501(0x1f5, float:7.02E-43)
            goto L_0x003f
        L_0x0047:
            boolean r14 = com.cellrebel.sdk.workers.BaseMetricsWorker.h
            boolean r15 = r10.c
            boolean r0 = r10.b
            boolean r1 = r10.d
            boolean r2 = r10.e
            boolean r3 = r10.f
            boolean r4 = r10.g
            r13 = r9
            r17 = r0
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            com.cellrebel.sdk.utils.Utils.a(r13, r14, r15, r16, r17, r18, r19, r20, r21)
        L_0x0063:
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
            r13 = 1
            r0.<init>(r13)
            r10.v = r0
            com.cellrebel.sdk.workers.CollectLoadedLatencyWorker$$ExternalSyntheticLambda2 r0 = new com.cellrebel.sdk.workers.CollectLoadedLatencyWorker$$ExternalSyntheticLambda2
            r0.<init>(r10)
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r11, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r9, (java.lang.Runnable) r0)
            java.util.concurrent.CountDownLatch r0 = r10.v     // Catch:{ InterruptedException -> 0x0079 }
            r0.await()     // Catch:{ InterruptedException -> 0x0079 }
            goto L_0x007a
        L_0x0079:
        L_0x007a:
            long r0 = java.lang.System.currentTimeMillis()
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r10.s
            java.lang.Integer r2 = r2.loadedLatencyMeasurementsPerServer
            if (r2 != 0) goto L_0x0086
            r14 = 1
            goto L_0x008b
        L_0x0086:
            int r2 = r2.intValue()
            r14 = r2
        L_0x008b:
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r10.s
            java.lang.Integer r2 = r2.loadedLatencyTimeoutTimer
            if (r2 != 0) goto L_0x0096
            r2 = 1000(0x3e8, float:1.401E-42)
            r15 = 1000(0x3e8, float:1.401E-42)
            goto L_0x009b
        L_0x0096:
            int r2 = r2.intValue()
            r15 = r2
        L_0x009b:
            okhttp3.OkHttpClient r8 = r30.d()
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            java.util.List<com.cellrebel.sdk.networking.beans.request.GameInfoMetric> r2 = r10.w
            java.util.Iterator r16 = r2.iterator()
            r6 = 0
            r2 = 0
        L_0x00ac:
            boolean r3 = r16.hasNext()
            if (r3 == 0) goto L_0x02ba
            java.lang.Object r3 = r16.next()
            r5 = r3
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r5 = (com.cellrebel.sdk.networking.beans.request.GameInfoMetric) r5
            boolean[] r4 = new boolean[r13]
            r4[r6] = r6
            java.lang.String r3 = r5.serverUrl
            if (r3 == 0) goto L_0x02a8
            java.lang.String r3 = r5.loadedLatencyTestFileTransferUrl
            if (r3 == 0) goto L_0x02a8
            int r17 = r2 + 1
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r18 = 30000(0x7530, double:1.4822E-319)
            int r20 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r20 <= 0) goto L_0x00d9
            long r0 = java.lang.System.currentTimeMillis()
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r11, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r9)
        L_0x00d9:
            r18 = r0
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r0 = r5.convertToGameInfo(r9)
            r0.isUnderAdditionalLoad = r13
            r1 = 0
            r0.fileTransferId = r1
            if (r12 != 0) goto L_0x00f2
            r10.c(r0)
        L_0x00e9:
            r11 = r7
            r28 = r8
            r29 = r9
        L_0x00ee:
            r4 = 0
            r8 = 1
            goto L_0x02a2
        L_0x00f2:
            com.cellrebel.sdk.networking.beans.response.Settings r1 = r10.s
            java.lang.Boolean r1 = r1.loadedLatencyServersCacheEnabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x010c
            java.util.Map<java.lang.String, com.cellrebel.sdk.networking.beans.request.GameInfoMetric> r1 = r10.l
            java.lang.String r2 = r5.serverUrl
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x010c
            r10.a((com.cellrebel.sdk.networking.beans.request.GameInfoMetric) r0)
            goto L_0x00e9
        L_0x010c:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x029a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x029a }
            r1.<init>()     // Catch:{ Exception -> 0x029a }
            java.io.File r2 = r31.getCacheDir()     // Catch:{ Exception -> 0x029a }
            r1.append(r2)     // Catch:{ Exception -> 0x029a }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x029a }
            r1.append(r2)     // Catch:{ Exception -> 0x029a }
            java.lang.String r2 = "temp"
            r1.append(r2)     // Catch:{ Exception -> 0x029a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x029a }
            r3.<init>(r1)     // Catch:{ Exception -> 0x029a }
            r3.createNewFile()     // Catch:{ IOException -> 0x0131, Exception -> 0x012f }
            goto L_0x0131
        L_0x012f:
            goto L_0x00e9
        L_0x0131:
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x029a }
            r1.<init>()     // Catch:{ Exception -> 0x029a }
            java.lang.String r2 = r5.loadedLatencyTestFileTransferUrl     // Catch:{ Exception -> 0x029a }
            okhttp3.Request$Builder r1 = r1.url((java.lang.String) r2)     // Catch:{ Exception -> 0x029a }
            okhttp3.Request r1 = r1.build()     // Catch:{ Exception -> 0x029a }
            okhttp3.Call r20 = r8.newCall(r1)     // Catch:{ Exception -> 0x029a }
            long r21 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{ Exception -> 0x029a }
            long r23 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x029a }
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x029a }
            r2.<init>(r13)     // Catch:{ Exception -> 0x029a }
            com.cellrebel.sdk.workers.CollectLoadedLatencyWorker$a r1 = new com.cellrebel.sdk.workers.CollectLoadedLatencyWorker$a     // Catch:{ Exception -> 0x029a }
            r25 = r1
            r1 = r25
            r26 = r2
            r2 = r30
            r13 = r3
            r3 = r4
            r27 = r4
            r4 = r0
            r0 = r5
            r5 = r17
            r11 = 0
            r6 = r31
            r11 = r7
            r7 = r14
            r28 = r8
            r8 = r15
            r29 = r9
            r9 = r26
            r1.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x029f }
            java.util.concurrent.ExecutorService r1 = r10.y     // Catch:{ Exception -> 0x029f }
            r2 = r25
            r1.execute(r2)     // Catch:{ Exception -> 0x029f }
            okhttp3.Response r1 = r20.execute()     // Catch:{ Exception -> 0x029f }
            boolean r2 = r1.isSuccessful()     // Catch:{ Exception -> 0x029f }
            if (r2 == 0) goto L_0x0294
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x029f }
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x029f }
            if (r2 == 0) goto L_0x018f
            goto L_0x00ee
        L_0x018f:
            okhttp3.ResponseBody r2 = r1.body()     // Catch:{ Exception -> 0x029f }
            com.cellrebel.sdk.networking.beans.response.ProgressResponseBody r2 = (com.cellrebel.sdk.networking.beans.response.ProgressResponseBody) r2     // Catch:{ Exception -> 0x029f }
            java.io.InputStream r3 = r2.byteStream()     // Catch:{ Exception -> 0x029f }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0281 }
            r4.<init>(r13)     // Catch:{ all -> 0x0281 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x025f }
        L_0x01a2:
            int r6 = r3.read(r5)     // Catch:{ IOException -> 0x025f }
            r7 = -1
            if (r6 != r7) goto L_0x0241
            r4.flush()     // Catch:{ IOException -> 0x025f }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x024e }
            long r5 = r5 - r23
            r7 = 2000(0x7d0, double:9.88E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x021e
            com.cellrebel.sdk.networking.beans.request.FileTransferMetric r7 = new com.cellrebel.sdk.networking.beans.request.FileTransferMetric     // Catch:{ all -> 0x024e }
            r7.<init>()     // Catch:{ all -> 0x024e }
            java.lang.String r0 = r0.loadedLatencyTestFileTransferUrl     // Catch:{ all -> 0x024e }
            r7.serverIdFileLoad = r0     // Catch:{ all -> 0x024e }
            java.lang.String r0 = com.cellrebel.sdk.ping.IPTools.a((java.lang.String) r0)     // Catch:{ all -> 0x024e }
            r7.serverIp = r0     // Catch:{ all -> 0x024e }
            long r8 = r2.firstByteTime     // Catch:{ all -> 0x024e }
            long r8 = r8 - r23
            r2 = 1
            r7.isFileDownLoaded = r2     // Catch:{ all -> 0x024e }
            r7.isFromLatencyTest = r2     // Catch:{ all -> 0x024e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x024e }
            r7.fileTransferId = r0     // Catch:{ all -> 0x024e }
            r7.downLoadFileTime = r5     // Catch:{ all -> 0x024e }
            r7.downloadFirstByteTime = r8     // Catch:{ all -> 0x024e }
            com.cellrebel.sdk.networking.RequestEventListener r0 = r10.x     // Catch:{ all -> 0x024e }
            int r5 = r0.a     // Catch:{ all -> 0x024e }
            long r5 = (long) r5     // Catch:{ all -> 0x024e }
            r7.dnsLookupTime = r5     // Catch:{ all -> 0x024e }
            int r5 = r0.b     // Catch:{ all -> 0x024e }
            long r5 = (long) r5     // Catch:{ all -> 0x024e }
            r7.tcpConnectTime = r5     // Catch:{ all -> 0x024e }
            int r0 = r0.c     // Catch:{ all -> 0x024e }
            long r5 = (long) r0     // Catch:{ all -> 0x024e }
            r7.tlsSetupTime = r5     // Catch:{ all -> 0x024e }
            long r5 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{ all -> 0x024e }
            long r5 = r5 - r21
            r7.bytesReceived = r5     // Catch:{ all -> 0x024e }
            long r5 = r13.length()     // Catch:{ all -> 0x024e }
            r8 = 1024(0x400, double:5.06E-321)
            long r5 = r5 / r8
            r7.fileSize = r5     // Catch:{ all -> 0x024e }
            com.cellrebel.sdk.networking.RequestEventListener r0 = r10.x     // Catch:{ all -> 0x024e }
            int r0 = r0.d     // Catch:{ all -> 0x024e }
            r7.latency = r0     // Catch:{ all -> 0x024e }
            r0 = 3
            r7.latencyType = r0     // Catch:{ all -> 0x024e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x024e }
            r11.add(r0)     // Catch:{ all -> 0x024e }
            r10.a((com.cellrebel.sdk.networking.beans.request.FileTransferMetric) r7)     // Catch:{ all -> 0x024e }
            r5 = 0
            boolean r0 = r27[r5]     // Catch:{ all -> 0x024e }
            if (r0 == 0) goto L_0x021f
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x024e }
            r5 = 2
            r7 = r26
            r7.await(r5, r0)     // Catch:{ all -> 0x024e }
            goto L_0x021f
        L_0x021e:
            r2 = 1
        L_0x021f:
            r1.close()     // Catch:{ all -> 0x024e }
            java.util.List r0 = java.util.Collections.singletonList(r4)     // Catch:{ all -> 0x0281 }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0281 }
            if (r0 == 0) goto L_0x0230
            r4.close()     // Catch:{ all -> 0x0281 }
        L_0x0230:
            java.util.List r0 = java.util.Collections.singletonList(r3)     // Catch:{ Exception -> 0x023e }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x023e }
            if (r0 == 0) goto L_0x0294
            r3.close()     // Catch:{ Exception -> 0x023e }
            goto L_0x0294
        L_0x023e:
            goto L_0x00ee
        L_0x0241:
            r7 = r26
            r8 = 1
            r9 = 0
            r4.write(r5, r9, r6)     // Catch:{ IOException -> 0x0260, all -> 0x024c }
            r26 = r7
            goto L_0x01a2
        L_0x024c:
            r0 = move-exception
            goto L_0x0250
        L_0x024e:
            r0 = move-exception
            r8 = 1
        L_0x0250:
            java.util.List r1 = java.util.Collections.singletonList(r4)     // Catch:{ all -> 0x027f }
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x027f }
            if (r1 == 0) goto L_0x025e
            r4.close()     // Catch:{ all -> 0x027f }
        L_0x025e:
            throw r0     // Catch:{ all -> 0x027f }
        L_0x025f:
            r8 = 1
        L_0x0260:
            java.util.List r0 = java.util.Collections.singletonList(r4)     // Catch:{ all -> 0x027f }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x027f }
            if (r0 == 0) goto L_0x026e
            r4.close()     // Catch:{ all -> 0x027f }
        L_0x026e:
            java.util.List r0 = java.util.Collections.singletonList(r3)     // Catch:{ Exception -> 0x027d }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x027d }
            if (r0 == 0) goto L_0x027b
            r3.close()     // Catch:{ Exception -> 0x027d }
        L_0x027b:
            r4 = 0
            goto L_0x02a2
        L_0x027d:
            goto L_0x027b
        L_0x027f:
            r0 = move-exception
            goto L_0x0283
        L_0x0281:
            r0 = move-exception
            r8 = 1
        L_0x0283:
            java.util.List r1 = java.util.Collections.singletonList(r3)     // Catch:{ Exception -> 0x0292 }
            r4 = 0
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x02a1 }
            if (r1 == 0) goto L_0x0291
            r3.close()     // Catch:{ Exception -> 0x02a1 }
        L_0x0291:
            throw r0     // Catch:{ Exception -> 0x02a1 }
        L_0x0292:
            r4 = 0
            goto L_0x02a1
        L_0x0294:
            r4 = 0
            r8 = 1
            r13.delete()     // Catch:{ Exception -> 0x02a1 }
            goto L_0x02a2
        L_0x029a:
            r11 = r7
            r28 = r8
            r29 = r9
        L_0x029f:
            r4 = 0
            r8 = 1
        L_0x02a1:
        L_0x02a2:
            r7 = r11
            r2 = r17
            r0 = r18
            goto L_0x02b0
        L_0x02a8:
            r11 = r7
            r28 = r8
            r29 = r9
            r4 = 0
            r8 = 1
            r7 = r11
        L_0x02b0:
            r8 = r28
            r9 = r29
            r6 = 0
            r13 = 1
            r11 = r31
            goto L_0x00ac
        L_0x02ba:
            java.util.Map<java.lang.String, com.cellrebel.sdk.networking.beans.request.GameInfoMetric> r0 = r10.l
            r0.clear()
            r30.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectLoadedLatencyWorker.a(android.content.Context):void");
    }

    public void a(Context context, List<GameInfoMetric> list) {
        this.w = list;
        this.t = context;
        a(context);
    }
}
