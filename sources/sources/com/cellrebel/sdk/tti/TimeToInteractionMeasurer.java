package com.cellrebel.sdk.tti;

import com.cellrebel.sdk.tti.DownloadMeasurer;
import com.cellrebel.sdk.tti.ServerSelection;
import com.cellrebel.sdk.tti.UploadMeasurer;
import com.cellrebel.sdk.tti.UploadStatsListener;
import com.cellrebel.sdk.tti.models.ClientAuth;
import com.cellrebel.sdk.tti.models.Server;
import com.cellrebel.sdk.tti.models.ServerConfig;
import com.cellrebel.sdk.tti.models.TimeToInteractionConfig;
import com.cellrebel.sdk.tti.models.TimeToInteractionResult;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class TimeToInteractionMeasurer {
    /* access modifiers changed from: private */
    public Server a;
    private ServerSelection b;
    /* access modifiers changed from: private */
    public String c;
    /* access modifiers changed from: private */
    public ClientAuth d;
    /* access modifiers changed from: private */
    public final TimeToInteractionConfig e;
    private final ServerListProvider f;
    private final OkHttpClient g;
    /* access modifiers changed from: private */
    public final DownloadMeasurer h;
    /* access modifiers changed from: private */
    public final UploadMeasurer i;
    /* access modifiers changed from: private */
    public final UploadStatsListener j;
    private final ServerSelection.LatencyRepository k;
    /* access modifiers changed from: private */
    public TimeToInteractionResult l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public boolean p;

    class a implements UploadStatsListener.EventCallback {
        final /* synthetic */ CountDownLatch a;

        /* renamed from: com.cellrebel.sdk.tti.TimeToInteractionMeasurer$a$a  reason: collision with other inner class name */
        class C0075a implements UploadMeasurer.CompletionHandler {
            C0075a() {
            }

            public void a() {
                TimeToInteractionMeasurer.this.f();
                if (!TimeToInteractionMeasurer.this.n) {
                    boolean unused = TimeToInteractionMeasurer.this.n = true;
                    a.this.a.countDown();
                }
            }

            public void a(String str) {
                TimeToInteractionMeasurer.this.f();
                if (!TimeToInteractionMeasurer.this.n) {
                    boolean unused = TimeToInteractionMeasurer.this.n = true;
                    TimeToInteractionMeasurer.this.l.addError(TimeToInteractionResult.ErrorType.FILE_UPLOAD_FAILURE);
                    a.this.a.countDown();
                }
            }
        }

        class b implements DownloadMeasurer.CompletionHandler {
            b() {
            }

            public void a(long j, long j2, long j3) {
                TimeToInteractionMeasurer.this.l.downloadTime = j;
                TimeToInteractionMeasurer.this.l.bytesDownloaded = j2;
                TimeToInteractionMeasurer.this.l.downloadTimeToFirstByte = j3;
                if (!TimeToInteractionMeasurer.this.m) {
                    boolean unused = TimeToInteractionMeasurer.this.m = true;
                    a.this.a.countDown();
                }
            }

            public void a(String str) {
                if (!TimeToInteractionMeasurer.this.m) {
                    boolean unused = TimeToInteractionMeasurer.this.m = true;
                    TimeToInteractionMeasurer.this.l.addError(TimeToInteractionResult.ErrorType.FILE_DOWNLOAD_FAILURE);
                    a.this.a.countDown();
                }
            }
        }

        a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        public void a() {
            boolean unused = TimeToInteractionMeasurer.this.p = true;
            TimeToInteractionMeasurer.this.i.a(TimeToInteractionMeasurer.this.a.getUploadUrl(), TimeToInteractionMeasurer.this.e.uploadFileSize, TimeToInteractionMeasurer.this.c, TimeToInteractionMeasurer.this.d.token, new C0075a());
            TimeToInteractionMeasurer.this.h.a(TimeToInteractionMeasurer.this.a.getDownloadUrl(), TimeToInteractionMeasurer.this.e.downloadFileSize, TimeToInteractionMeasurer.this.c, TimeToInteractionMeasurer.this.d.token, new b());
        }

        public void b() {
            if (!TimeToInteractionMeasurer.this.o) {
                boolean unused = TimeToInteractionMeasurer.this.o = true;
                if (!TimeToInteractionMeasurer.this.p) {
                    TimeToInteractionMeasurer.this.l.addError(TimeToInteractionResult.ErrorType.UPLOAD_STATS_FAILURE);
                }
                this.a.countDown();
            }
        }

        public void c() {
            if (!TimeToInteractionMeasurer.this.o) {
                boolean unused = TimeToInteractionMeasurer.this.o = true;
                TimeToInteractionMeasurer.this.j.b();
                TimeToInteractionMeasurer.this.j.c();
                this.a.countDown();
            }
        }
    }

    public TimeToInteractionMeasurer(TimeToInteractionConfig timeToInteractionConfig, ServerSelection.LatencyRepository latencyRepository) {
        this.e = timeToInteractionConfig;
        OkHttpClient okHttpClient = new OkHttpClient();
        this.g = okHttpClient;
        this.h = new DownloadMeasurer(okHttpClient);
        this.i = new UploadMeasurer(okHttpClient);
        this.j = new UploadStatsListener(okHttpClient);
        this.k = latencyRepository;
        this.f = new ServerListProvider(timeToInteractionConfig.serverListUrl, timeToInteractionConfig.appName, timeToInteractionConfig.appVersion, timeToInteractionConfig.deviceModel, timeToInteractionConfig.deviceId);
    }

    private ServerConfig a() {
        return this.f.a();
    }

    private void a(List<Server> list) {
        if (this.b == null) {
            this.b = new ServerSelection(this.g, list, this.k);
        }
        ServerSelection serverSelection = this.b;
        TimeToInteractionConfig timeToInteractionConfig = this.e;
        serverSelection.a(timeToInteractionConfig.serverSelectionTimeout, timeToInteractionConfig.pingsPerServer, timeToInteractionConfig.pingTimeout, this.c, this.d.token);
        this.a = this.b.a();
        this.l.latency = this.b.b();
    }

    private String b() {
        try {
            return InetAddress.getByName(new URL(this.a.getUrl()).getHost()).getHostAddress();
        } catch (Exception unused) {
            return null;
        }
    }

    private int c() {
        try {
            return new URL(this.a.getUrl()).getPort();
        } catch (Exception unused) {
            return -1;
        }
    }

    private TimeToInteractionResult e() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        this.p = false;
        UploadStatsListener uploadStatsListener = this.j;
        String uploadStatsUrl = this.a.getUploadStatsUrl();
        String str = this.c;
        String str2 = this.d.token;
        TimeToInteractionConfig timeToInteractionConfig = this.e;
        uploadStatsListener.a(uploadStatsUrl, str, str2, timeToInteractionConfig.uploadStatsTimeout, timeToInteractionConfig.uploadStatsInterval, new a(countDownLatch));
        try {
            if (!countDownLatch.await((long) this.e.timeout, TimeUnit.SECONDS)) {
                this.i.a();
                this.h.a();
                this.j.a();
                this.l.addError(TimeToInteractionResult.ErrorType.TIME_TO_INTERACTION_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            this.l.addError(TimeToInteractionResult.ErrorType.TIME_TO_INTERACTION_INTERRUPTED);
        }
        if (this.j.c() == 0 && this.n && !this.l.errors.contains(TimeToInteractionResult.ErrorType.FILE_UPLOAD_FAILURE)) {
            this.l.addError(TimeToInteractionResult.ErrorType.UPLOAD_STATS_FAILURE);
        }
        TimeToInteractionResult timeToInteractionResult = this.l;
        timeToInteractionResult.serverId = this.a.id;
        timeToInteractionResult.serverIp = b();
        this.l.serverPort = c();
        this.l.uploadTime = this.j.c();
        this.l.bytesUploaded = this.j.b();
        this.l.uploadTimeToFirstByte = this.j.d();
        this.l.serverVersion = this.j.f();
        this.l.serverBuild = this.j.e();
        return this.l;
    }

    /* access modifiers changed from: private */
    public void f() {
        this.j.g();
    }

    public TimeToInteractionResult d() {
        TimeToInteractionResult timeToInteractionResult;
        TimeToInteractionResult.ErrorType errorType;
        ClientAuth clientAuth;
        String str;
        this.l = new TimeToInteractionResult();
        this.m = false;
        this.n = false;
        this.o = false;
        ServerConfig a2 = a();
        if (a2 == null || (clientAuth = a2.clientAuth) == null || (str = a2.guid) == null) {
            timeToInteractionResult = this.l;
            errorType = TimeToInteractionResult.ErrorType.SERVER_CONFIG_FAILURE;
        } else {
            this.c = str;
            this.d = clientAuth;
            List<Server> list = a2.servers;
            if (list == null || list.isEmpty()) {
                timeToInteractionResult = this.l;
                errorType = TimeToInteractionResult.ErrorType.SERVER_LIST_FAILURE;
            } else {
                a(list);
                if (this.a != null) {
                    return e();
                }
                timeToInteractionResult = this.l;
                errorType = TimeToInteractionResult.ErrorType.SERVER_SELECTION_FAILURE;
            }
        }
        timeToInteractionResult.addError(errorType);
        return this.l;
    }
}
