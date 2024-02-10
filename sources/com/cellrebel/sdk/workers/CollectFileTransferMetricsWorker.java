package com.cellrebel.sdk.workers;

import android.content.Context;
import android.telephony.CellInfo;
import android.text.TextUtils;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.networking.ApiClient;
import com.cellrebel.sdk.networking.ApiService;
import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;
import com.cellrebel.sdk.networking.beans.response.ProgressRequestBody;
import com.cellrebel.sdk.networking.beans.response.ProgressResponseBody;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.cache.HeaderConstants;

public class CollectFileTransferMetricsWorker extends BaseMetricsWorker {
    private CountDownLatch j = new CountDownLatch(2);
    String k;
    String l;
    String m;
    String n;
    String o;
    int p;
    private ConnectionType q;
    private int r;
    private long s;
    private long t;
    private List<CellInfo> u;
    private final ScheduledExecutorService v = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService w = Executors.newSingleThreadScheduledExecutor();

    /* access modifiers changed from: private */
    public static /* synthetic */ Response a(Interceptor.Chain chain) {
        Request request = chain.request();
        String w2 = PreferencesManager.m().w();
        if (!TextUtils.isEmpty(w2)) {
            request = request.newBuilder().addHeader("Authorization", w2).addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE).build();
        }
        Response proceed = chain.proceed(request);
        return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), (ProgressResponseBody.ProgressListener) null)).build();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|(17:9|10|11|12|13|14|(2:15|(1:59)(3:33|34|35))|17|18|19|(3:21|(1:23)|24)|25|26|(1:28)|29|30|(1:32))|55|(2:57|62)(1:64)) */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0052 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0172 A[Catch:{ Exception | OutOfMemoryError -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x00b8 A[Catch:{ Exception | OutOfMemoryError -> 0x0175 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(int r19, com.cellrebel.sdk.networking.RequestEventListener r20, com.cellrebel.sdk.networking.beans.request.FileTransferMetric r21, android.content.Context r22) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r21
            okhttp3.OkHttpClient$Builder r3 = new okhttp3.OkHttpClient$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r3.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r4 = 0
            okhttp3.OkHttpClient$Builder r3 = r3.cache(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            long r5 = (long) r0     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.OkHttpClient$Builder r3 = r3.readTimeout(r5, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.OkHttpClient$Builder r3 = r3.writeTimeout(r5, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.OkHttpClient$Builder r3 = r3.connectTimeout(r5, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r5 = 0
            okhttp3.OkHttpClient$Builder r3 = r3.retryOnConnectionFailure(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            com.cellrebel.sdk.networking.TokenAuthenticator r6 = new com.cellrebel.sdk.networking.TokenAuthenticator     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r6.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r3.authenticator(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r6 = r20
            r3.eventListener(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda6 r6 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda6     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r6.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r3.addInterceptor(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.String r6 = "TLSv1.2"
            javax.net.ssl.SSLContext r6 = javax.net.ssl.SSLContext.getInstance(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
            r6.init(r4, r4, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
            com.cellrebel.sdk.networking.TLSSocketFactory r4 = new com.cellrebel.sdk.networking.TLSSocketFactory     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
            javax.net.ssl.SSLSocketFactory r6 = r6.getSocketFactory()     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
            r4.<init>(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
            com.cellrebel.sdk.networking.FullX509TrustManager r6 = com.cellrebel.sdk.networking.ApiClient.b()     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
            r3.sslSocketFactory(r4, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0052 }
        L_0x0052:
            okhttp3.ConnectionSpec$Builder r4 = new okhttp3.ConnectionSpec$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.ConnectionSpec r6 = okhttp3.ConnectionSpec.MODERN_TLS     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r4.<init>((okhttp3.ConnectionSpec) r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r6 = 1
            okhttp3.TlsVersion[] r7 = new okhttp3.TlsVersion[r6]     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.TlsVersion r8 = okhttp3.TlsVersion.TLS_1_2     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r7[r5] = r8     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.ConnectionSpec$Builder r4 = r4.tlsVersions((okhttp3.TlsVersion[]) r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.ConnectionSpec r4 = r4.build()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r7.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r7.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.ConnectionSpec r4 = okhttp3.ConnectionSpec.COMPATIBLE_TLS     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r7.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.ConnectionSpec r4 = okhttp3.ConnectionSpec.CLEARTEXT     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r7.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r3.connectionSpecs(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.OkHttpClient r3 = r3.build()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.String r7 = r1.n     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r4.append(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.String r7 = "/downloadFile/"
            r4.append(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.String r7 = r1.m     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r4.append(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.Request$Builder r9 = new okhttp3.Request$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r9.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.Request$Builder r4 = r9.url((java.lang.String) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.Request r4 = r4.build()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.Call r3 = r3.newCall(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            okhttp3.Response r3 = r3.execute()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            boolean r4 = r3.isSuccessful()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            if (r4 == 0) goto L_0x016a
            okhttp3.ResponseBody r4 = r3.body()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            com.cellrebel.sdk.networking.beans.response.ProgressResponseBody r4 = (com.cellrebel.sdk.networking.beans.response.ProgressResponseBody) r4     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.String r10 = r1.l     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            r9.<init>(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.io.InputStream r10 = r4.byteStream()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ all -> 0x015b }
            r11.<init>(r9)     // Catch:{ all -> 0x015b }
            r12 = 4096(0x1000, float:5.74E-42)
            byte[] r12 = new byte[r12]     // Catch:{ IOException -> 0x0140 }
        L_0x00d2:
            int r13 = r10.read(r12)     // Catch:{ IOException -> 0x0140 }
            r14 = -1
            if (r13 != r14) goto L_0x012b
            r11.flush()     // Catch:{ IOException -> 0x0140 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0131 }
            long r12 = r12 - r7
            int r0 = r0 * 1000
            long r14 = (long) r0     // Catch:{ all -> 0x0131 }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0110
            long r14 = r4.firstByteTime     // Catch:{ all -> 0x0131 }
            long r14 = r14 - r7
            long r7 = r9.length()     // Catch:{ all -> 0x0131 }
            r16 = 0
            int r0 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fb
            r16 = 1024(0x400, double:5.06E-321)
            long r7 = r7 / r16
            r2.fileSize = r7     // Catch:{ all -> 0x0131 }
        L_0x00fb:
            r2.isFileDownLoaded(r6)     // Catch:{ all -> 0x0131 }
            r2.downLoadFileTime(r12)     // Catch:{ all -> 0x0131 }
            r2.downloadFirstByteTime(r14)     // Catch:{ all -> 0x0131 }
            com.cellrebel.sdk.utils.TelephonyHelper r0 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ all -> 0x0131 }
            r14 = r22
            java.util.List r0 = r0.a((android.content.Context) r14)     // Catch:{ all -> 0x0131 }
            r1.u = r0     // Catch:{ all -> 0x0131 }
        L_0x0110:
            java.util.List r0 = java.util.Collections.singletonList(r11)     // Catch:{ all -> 0x015b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x015b }
            if (r0 == 0) goto L_0x011d
            r11.close()     // Catch:{ all -> 0x015b }
        L_0x011d:
            java.util.List r0 = java.util.Collections.singletonList(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            if (r0 == 0) goto L_0x016a
            r10.close()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            goto L_0x016a
        L_0x012b:
            r14 = r22
            r11.write(r12, r5, r13)     // Catch:{ IOException -> 0x0140 }
            goto L_0x00d2
        L_0x0131:
            r0 = move-exception
            java.util.List r2 = java.util.Collections.singletonList(r11)     // Catch:{ all -> 0x015b }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x015b }
            if (r2 == 0) goto L_0x013f
            r11.close()     // Catch:{ all -> 0x015b }
        L_0x013f:
            throw r0     // Catch:{ all -> 0x015b }
        L_0x0140:
            java.util.List r0 = java.util.Collections.singletonList(r11)     // Catch:{ all -> 0x015b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x015b }
            if (r0 == 0) goto L_0x014d
            r11.close()     // Catch:{ all -> 0x015b }
        L_0x014d:
            java.util.List r0 = java.util.Collections.singletonList(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            if (r0 == 0) goto L_0x015a
            r10.close()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
        L_0x015a:
            return
        L_0x015b:
            r0 = move-exception
            java.util.List r2 = java.util.Collections.singletonList(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            if (r2 == 0) goto L_0x0169
            r10.close()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
        L_0x0169:
            throw r0     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
        L_0x016a:
            okhttp3.ResponseBody r0 = r3.body()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            com.cellrebel.sdk.networking.beans.response.ProgressResponseBody r0 = (com.cellrebel.sdk.networking.beans.response.ProgressResponseBody) r0     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
            if (r0 == 0) goto L_0x0175
            r0.close()     // Catch:{ Exception | OutOfMemoryError -> 0x0175 }
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker.a(int, com.cellrebel.sdk.networking.RequestEventListener, com.cellrebel.sdk.networking.beans.request.FileTransferMetric, android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i, FileTransferMetric fileTransferMetric) {
        try {
            File file = new File(this.l);
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(RequestBody.create(MediaType.parse("multipart/*"), file));
            MultipartBody.Part createFormData = MultipartBody.Part.createFormData(ShareInternalUtility.STAGING_PARAM, file.getName(), progressRequestBody);
            long currentTimeMillis = System.currentTimeMillis();
            ApiService a = ApiClient.a();
            if (a.a(this.n + "/uploadFile", createFormData).execute().isSuccessful()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 <= ((long) (i * 1000))) {
                    fileTransferMetric.isFileUpLoaded(true);
                    fileTransferMetric.upLoadFileTime(currentTimeMillis2);
                    fileTransferMetric.uploadFirstByteTime(progressRequestBody.firstByteTime - currentTimeMillis);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
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
            if (a != this.q) {
                this.r++;
            }
            this.q = a;
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

    /* JADX WARNING: Can't wrap try/catch for region: R(31:80|79|78|81|84|85|(0)|88|89|90|91|92|93|94|95|96|97|(0)(0)|101|(0)|104|(0)(0)|108|(0)|119|120|121|122|123|(0)(0)|(3:129|130|146)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:110|111|112|113|114|115|(1:117)|118) */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x02fc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x032d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x027b */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0284 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0295 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02b7 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02ba A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02d5 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0337 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0342 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:129:0x034a] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021e A[Catch:{ Exception | OutOfMemoryError -> 0x0350 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0282 A[Catch:{  }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r23) {
        /*
            r22 = this;
            r6 = r22
            r7 = r23
            super.a((android.content.Context) r23)
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r0.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.io.File r1 = r23.getCacheDir()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r0.append(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r0.append(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.lang.String r1 = r6.m     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r0.append(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r6.l = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.lang.String r0 = "power"
            java.lang.Object r0 = r7.getSystemService(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.lang.String r1 = r6.o     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            if (r1 == 0) goto L_0x01f2
            boolean r1 = r1.isEmpty()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            if (r1 != 0) goto L_0x01f2
            java.lang.String r1 = r6.o     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.lang.String r2 = ","
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r3.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            int r8 = r1.length     // Catch:{ Exception | OutOfMemoryError -> 0x0352 }
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r12 = 0
            r13 = 0
            r17 = 0
        L_0x0056:
            r15 = 3
            if (r12 >= r8) goto L_0x00fc
            r14 = r1[r12]     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception | OutOfMemoryError -> 0x006d }
            r4.<init>(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x006d }
            java.lang.String r4 = r4.getHost()     // Catch:{ Exception | OutOfMemoryError -> 0x006d }
            java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x006d }
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            long r20 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            long r5 = r20 - r18
            if (r4 == 0) goto L_0x007e
            int r4 = (int) r5     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r3.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
        L_0x007e:
            java.lang.String r4 = "/downloadFile/1kb_testfile"
            if (r17 == 0) goto L_0x009f
            com.cellrebel.sdk.utils.LatencyItem r5 = new com.cellrebel.sdk.utils.LatencyItem     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            com.cellrebel.sdk.utils.TrackingHelper r6 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r9.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r9.append(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r9.append(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            int r6 = r6.a((java.lang.String) r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r5.<init>(r6, r15)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            goto L_0x00a7
        L_0x009f:
            com.cellrebel.sdk.utils.TrackingHelper r5 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            com.cellrebel.sdk.utils.LatencyItem r5 = r5.b((java.lang.String) r14)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
        L_0x00a7:
            int r6 = r5.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            if (r6 != 0) goto L_0x00cd
            if (r17 != 0) goto L_0x00cd
            com.cellrebel.sdk.utils.LatencyItem r5 = new com.cellrebel.sdk.utils.LatencyItem     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            com.cellrebel.sdk.utils.TrackingHelper r6 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r9.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r9.append(r14)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r9.append(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.lang.String r4 = r9.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            int r4 = r6.a((java.lang.String) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r5.<init>(r4, r15)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r17 = 1
        L_0x00cd:
            int r4 = r5.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r2.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            int r4 = r5.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            if (r4 <= 0) goto L_0x00f0
            int r4 = r5.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            r6 = r8
            long r8 = (long) r4     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f1
            int r4 = r5.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00f8 }
            long r4 = (long) r4
            r10 = r4
            r13 = r14
            goto L_0x00f1
        L_0x00f0:
            r6 = r8
        L_0x00f1:
            int r12 = r12 + 1
            r8 = r6
            r6 = r22
            goto L_0x0056
        L_0x00f8:
            r15 = r22
            goto L_0x0353
        L_0x00fc:
            com.cellrebel.sdk.database.SDKRoomDatabase r4 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            com.cellrebel.sdk.database.dao.FileTransferDAO r4 = r4.h()     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            java.util.List r5 = r4.getAll()     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            boolean r5 = r5.isEmpty()     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            if (r5 == 0) goto L_0x0116
            com.cellrebel.sdk.database.FileTransferServer r5 = new com.cellrebel.sdk.database.FileTransferServer     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            r5.<init>()     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            r4.a(r5)     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
        L_0x0116:
            java.util.List r5 = r4.getAll()     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            r6 = 0
            java.lang.Object r5 = r5.get(r6)     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            com.cellrebel.sdk.database.FileTransferServer r5 = (com.cellrebel.sdk.database.FileTransferServer) r5     // Catch:{ OutOfMemoryError -> 0x01ec, Exception -> 0x01e7 }
            r14 = r22
            if (r13 == 0) goto L_0x012d
            r14.n = r13     // Catch:{ OutOfMemoryError -> 0x01e5, Exception -> 0x01e3 }
            r5.b = r13     // Catch:{ OutOfMemoryError -> 0x01e5, Exception -> 0x01e3 }
            r4.a(r5)     // Catch:{ OutOfMemoryError -> 0x01e5, Exception -> 0x01e3 }
            goto L_0x0133
        L_0x012d:
            java.lang.String r4 = r5.b     // Catch:{ OutOfMemoryError -> 0x01e5, Exception -> 0x01e3 }
            if (r4 == 0) goto L_0x0133
            r14.n = r4     // Catch:{ OutOfMemoryError -> 0x01e5, Exception -> 0x01e3 }
        L_0x0133:
            r4 = 0
            r5 = 0
        L_0x0135:
            int r8 = r2.size()     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            if (r4 >= r8) goto L_0x01df
            r8 = r1[r4]     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            java.lang.String r9 = r14.n     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r9 = r8.equals(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            if (r9 == 0) goto L_0x015a
            java.lang.Object r8 = r3.get(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            int r5 = r8.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r18 = r1
            r20 = r3
            r19 = r5
            r5 = r14
            r21 = 3
            goto L_0x01d2
        L_0x015a:
            com.cellrebel.sdk.networking.beans.request.FileTransferMetric r13 = new com.cellrebel.sdk.networking.beans.request.FileTransferMetric     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r13.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            java.lang.String r9 = r14.k     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r13.measurementSequenceId = r9     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r13.serverIdFileLoad(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            java.lang.String r8 = com.cellrebel.sdk.ping.IPTools.a((java.lang.String) r8)     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r13.serverIp = r8     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r13.latencyType = r15     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            java.lang.Object r8 = r3.get(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            int r8 = r8.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            long r8 = (long) r8     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r13.dnsLookupTime = r8     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            com.cellrebel.sdk.utils.TrackingHelper r8 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r8 = r8.c()     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            if (r8 != 0) goto L_0x0195
            r8 = 500(0x1f4, float:7.0E-43)
            r13.stateDuringMeasurement(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r18 = r1
            r20 = r3
            r19 = r5
            r3 = r13
            r5 = r14
            r21 = 3
            goto L_0x01bd
        L_0x0195:
            boolean r9 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r10 = r14.c     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r12 = r14.b     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r11 = r14.d     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r8 = r14.e     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            boolean r6 = r14.f     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r18 = r1
            boolean r1 = r14.g     // Catch:{ Exception | OutOfMemoryError -> 0x01df }
            r16 = r8
            r8 = r13
            r19 = r11
            r11 = r0
            r20 = r3
            r3 = r13
            r13 = r19
            r19 = r5
            r5 = r14
            r14 = r16
            r21 = 3
            r15 = r6
            r16 = r1
            com.cellrebel.sdk.utils.Utils.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
        L_0x01bd:
            java.lang.Object r1 = r2.get(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
            int r1 = r1.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
            r3.latency(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda0 r1 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda0     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r7, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r3, (java.lang.Runnable) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01ef }
        L_0x01d2:
            int r4 = r4 + 1
            r14 = r5
            r1 = r18
            r5 = r19
            r3 = r20
            r6 = 0
            r15 = 3
            goto L_0x0135
        L_0x01df:
            r19 = r5
            r5 = r14
            goto L_0x01ef
        L_0x01e3:
            r5 = r14
            goto L_0x01e9
        L_0x01e5:
            r5 = r14
            goto L_0x01e9
        L_0x01e7:
            r5 = r22
        L_0x01e9:
            r19 = 0
            goto L_0x01ef
        L_0x01ec:
            r5 = r22
            goto L_0x01e9
        L_0x01ef:
            r6 = r19
            goto L_0x01f6
        L_0x01f2:
            r5 = r6
            r6 = 0
            r17 = 0
        L_0x01f6:
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.database.ConnectionType r1 = r1.a((android.content.Context) r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r5.q = r1     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda1 r9 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda1     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r9.<init>(r5, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            java.util.concurrent.ScheduledExecutorService r8 = r5.v     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r10 = 0
            r12 = 500(0x1f4, double:2.47E-321)
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            java.util.concurrent.ScheduledFuture r4 = r8.scheduleAtFixedRate(r9, r10, r12, r14)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.networking.beans.request.FileTransferMetric r3 = new com.cellrebel.sdk.networking.beans.request.FileTransferMetric     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r3.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            java.lang.String r1 = r5.k     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r3.measurementSequenceId = r1     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            boolean r9 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            if (r9 == 0) goto L_0x0231
            boolean r10 = r5.c     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            boolean r12 = r5.b     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            boolean r13 = r5.d     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            boolean r14 = r5.e     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            boolean r15 = r5.f     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            boolean r1 = r5.g     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r8 = r3
            r11 = r0
            r16 = r1
            com.cellrebel.sdk.utils.Utils.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
        L_0x0231:
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r5.q = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r3.downloadAccessTechStart(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            java.lang.String r0 = r5.n     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r3.serverIdFileLoad(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            long r0 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r5.t = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.networking.RequestEventListener r8 = new com.cellrebel.sdk.networking.RequestEventListener     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.utils.PreferencesManager r0 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            long r0 = r0.k()     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            int r9 = (int) r0     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            java.util.concurrent.ScheduledExecutorService r10 = r5.w     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda2 r11 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda2     // Catch:{ Exception | OutOfMemoryError -> 0x0350 }
            r0 = r11
            r1 = r22
            r2 = r9
            r12 = r3
            r3 = r8
            r13 = r4
            r14 = 1
            r4 = r12
            r15 = r5
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{  }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{  }
            r1 = 0
            java.util.concurrent.ScheduledFuture r3 = r10.schedule(r11, r1, r0)     // Catch:{  }
            long r4 = (long) r9
            r3.get(r4, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x027b }
            goto L_0x027e
        L_0x027b:
            r3.cancel(r14)     // Catch:{  }
        L_0x027e:
            int r0 = r8.a     // Catch:{  }
            if (r0 <= r6) goto L_0x0284
            long r10 = (long) r0     // Catch:{  }
            goto L_0x0285
        L_0x0284:
            long r10 = (long) r6     // Catch:{  }
        L_0x0285:
            r12.dnsLookupTime = r10     // Catch:{  }
            int r0 = r8.b     // Catch:{  }
            long r10 = (long) r0     // Catch:{  }
            r12.tcpConnectTime = r10     // Catch:{  }
            int r0 = r8.c     // Catch:{  }
            long r10 = (long) r0     // Catch:{  }
            r12.tlsSetupTime = r10     // Catch:{  }
            boolean r0 = r12.isFileDownLoaded     // Catch:{  }
            if (r0 == 0) goto L_0x02a4
            int r0 = r15.r     // Catch:{  }
            r12.downloadAccessTechNumChanges(r0)     // Catch:{  }
            long r10 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{  }
            long r1 = r15.t     // Catch:{  }
            long r10 = r10 - r1
            r12.bytesReceived(r10)     // Catch:{  }
        L_0x02a4:
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r7)     // Catch:{  }
            r15.q = r0     // Catch:{  }
            java.lang.String r0 = r0.toString()     // Catch:{  }
            r12.downloadAccessTechEnd(r0)     // Catch:{  }
            if (r17 == 0) goto L_0x02ba
            int r0 = r8.d     // Catch:{  }
            goto L_0x02c8
        L_0x02ba:
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            java.lang.String r1 = r15.n     // Catch:{  }
            com.cellrebel.sdk.utils.LatencyItem r0 = r0.b((java.lang.String) r1)     // Catch:{  }
            int r0 = r0.a()     // Catch:{  }
        L_0x02c8:
            r12.latency(r0)     // Catch:{  }
            long r0 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{  }
            r15.s = r0     // Catch:{  }
            boolean r0 = r12.isFileDownLoaded     // Catch:{  }
            if (r0 == 0) goto L_0x0325
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r7)     // Catch:{  }
            r15.q = r0     // Catch:{  }
            r1 = 0
            r15.r = r1     // Catch:{  }
            java.lang.String r0 = r0.toString()     // Catch:{  }
            r12.uploadAccessTechStart(r0)     // Catch:{  }
            java.util.concurrent.ScheduledExecutorService r0 = r15.w     // Catch:{  }
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda3 r1 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda3     // Catch:{  }
            r1.<init>(r15, r9, r12)     // Catch:{  }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{  }
            r8 = 0
            java.util.concurrent.ScheduledFuture r0 = r0.schedule(r1, r8, r2)     // Catch:{  }
            r0.get(r4, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x02fc }
            goto L_0x02ff
        L_0x02fc:
            r0.cancel(r14)     // Catch:{  }
        L_0x02ff:
            boolean r0 = r12.isFileUpLoaded     // Catch:{  }
            if (r0 == 0) goto L_0x0312
            int r0 = r15.r     // Catch:{  }
            r12.downloadAccessTechNumChanges(r0)     // Catch:{  }
            long r0 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{  }
            long r2 = r15.s     // Catch:{  }
            long r0 = r0 - r2
            r12.bytesSent(r0)     // Catch:{  }
        L_0x0312:
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r7)     // Catch:{  }
            r15.q = r0     // Catch:{  }
            java.lang.String r0 = r0.toString()     // Catch:{  }
            r12.uploadAccessTechEnd(r0)     // Catch:{  }
            r15.a = r14     // Catch:{  }
        L_0x0325:
            r13.cancel(r14)     // Catch:{  }
            java.util.concurrent.CountDownLatch r0 = r15.j     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r0.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
        L_0x032d:
            java.util.List<android.telephony.CellInfo> r0 = r15.u     // Catch:{  }
            if (r0 == 0) goto L_0x0342
            boolean r0 = r0.isEmpty()     // Catch:{  }
            if (r0 != 0) goto L_0x0342
            java.util.List<android.telephony.CellInfo> r0 = r15.u     // Catch:{  }
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda4 r1 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda4     // Catch:{  }
            r1.<init>(r15)     // Catch:{  }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r7, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r12, (java.util.List<android.telephony.CellInfo>) r0, (java.lang.Runnable) r1)     // Catch:{  }
            goto L_0x034a
        L_0x0342:
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda5 r0 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker$$ExternalSyntheticLambda5     // Catch:{  }
            r0.<init>(r15)     // Catch:{  }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r7, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r12, (java.lang.Runnable) r0)     // Catch:{  }
        L_0x034a:
            java.util.concurrent.CountDownLatch r0 = r15.j     // Catch:{ Exception | OutOfMemoryError -> 0x0353, Exception | OutOfMemoryError -> 0x0353 }
            r0.await()     // Catch:{ Exception | OutOfMemoryError -> 0x0353, Exception | OutOfMemoryError -> 0x0353 }
            goto L_0x0353
        L_0x0350:
            r15 = r5
            goto L_0x0353
        L_0x0352:
            r15 = r6
        L_0x0353:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker.a(android.content.Context):void");
    }

    public void a(boolean z) {
    }
}
