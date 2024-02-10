package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.videocommon.d.c;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CampaignDownLoadTask */
public final class a implements Serializable {
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public boolean B;
    private int C;
    private File D;
    /* access modifiers changed from: private */
    public int E = 1;
    private int F;
    private int G;
    private int H;
    private boolean I = false;
    private h J;
    private c K;
    private h L;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private String Q = "";
    private OnDownloadStateListener R = new OnDownloadStateListener() {
        public final void onCancelDownload(DownloadMessage downloadMessage) {
        }

        public final void onDownloadStart(DownloadMessage downloadMessage) {
            try {
                int unused = a.this.f = 1;
                if (a.this.v == null) {
                    p unused2 = a.this.v = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
                }
                a.this.v.a(a.this.j, a.this.m, a.this.q, a.this.f);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
        }

        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                if (a.this.v == null) {
                    p unused = a.this.v = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
                }
                a.this.v.a(a.this.n, a.this.p, 5);
                String str = "";
                if (downloadMessage != null) {
                    try {
                        str = (String) downloadMessage.getExtra("responseHeaders");
                    } catch (Throwable th) {
                        aa.d("CampaignDownLoadTask", th.getMessage());
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.p, false, str);
                a aVar2 = a.this;
                String b = aVar2.f(aVar2.A == 100 ? 3 : 1);
                if (!TextUtils.isEmpty(b)) {
                    a.this.c(b);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
        }

        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            try {
                if (a.this.z != null && a.this.z.getStatus() != DownloadStatus.CANCELLED) {
                    String str = "Video Download Error";
                    if (!(downloadError == null || downloadError.getException() == null)) {
                        str = downloadError.getException().getMessage();
                    }
                    a.this.u();
                    a.this.a(3, str, "");
                    a.this.a(str);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
        }
    };
    private OnProgressStateListener S = new OnProgressStateListener() {
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                long unused = a.this.p = downloadProgress.getCurrent();
                long unused2 = a.this.m = downloadProgress.getTotal();
                int unused3 = a.this.A = downloadProgress.getCurrentDownloadRate();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CampaignDownLoadTask", e.getMessage());
                }
            }
            if (MBridgeConstans.DEBUG) {
                aa.d("CampaignDownLoadTask", "name：" + a.this.j.getAppName() + " Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate: " + a.this.t + " - " + a.this.d + " total & current: " + downloadProgress.getTotal() + " - " + downloadProgress.getCurrent());
            }
        }
    };
    private OnDownloadStateListener T = new OnDownloadStateListener() {
        public final void onCancelDownload(DownloadMessage downloadMessage) {
        }

        public final void onDownloadStart(DownloadMessage downloadMessage) {
            int unused = a.this.f = 1;
            if (a.this.v == null) {
                p unused2 = a.this.v = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
            }
            a.this.v.a(a.this.j, a.this.m, a.this.q, a.this.f);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0091 A[Catch:{ Exception -> 0x0097 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onDownloadComplete(com.mbridge.msdk.foundation.download.DownloadMessage r8) {
            /*
                r7 = this;
                java.lang.String r0 = "CampaignDownLoadTask"
                java.lang.String r1 = "onDownloadComplete callback : "
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                long r3 = r1.p     // Catch:{ Exception -> 0x0097 }
                r2.append(r3)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = "    "
                r2.append(r1)     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                long r3 = r1.m     // Catch:{ Exception -> 0x0097 }
                r2.append(r3)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.tools.aa.d(r0, r1)     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.db.p r1 = r1.v     // Catch:{ Exception -> 0x0097 }
                if (r1 != 0) goto L_0x0044
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0097 }
                android.content.Context r2 = r2.g()     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.db.h r2 = com.mbridge.msdk.foundation.db.h.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.db.p r2 = com.mbridge.msdk.foundation.db.p.a((com.mbridge.msdk.foundation.db.g) r2)     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.db.p unused = r1.v = r2     // Catch:{ Exception -> 0x0097 }
            L_0x0044:
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.db.p r1 = r1.v     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.videocommon.download.a r2 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                java.lang.String r2 = r2.n     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.videocommon.download.a r3 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                long r3 = r3.p     // Catch:{ Exception -> 0x0097 }
                r5 = 5
                r1.a(r2, r3, r5)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = ""
                if (r8 == 0) goto L_0x0079
                java.lang.String r2 = "responseHeaders"
                java.lang.Object r8 = r8.getExtra(r2)     // Catch:{ all -> 0x006d }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x006d }
                com.mbridge.msdk.foundation.tools.aa.d(r0, r8)     // Catch:{ all -> 0x006b }
                r1 = r8
                goto L_0x0079
            L_0x006b:
                r1 = move-exception
                goto L_0x0071
            L_0x006d:
                r8 = move-exception
                r6 = r1
                r1 = r8
                r8 = r6
            L_0x0071:
                java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.foundation.tools.aa.d(r0, r1)     // Catch:{ Exception -> 0x0097 }
                goto L_0x007a
            L_0x0079:
                r8 = r1
            L_0x007a:
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                long r2 = r1.p     // Catch:{ Exception -> 0x0097 }
                r4 = 1
                r1.a((long) r2, (boolean) r4, (java.lang.String) r8)     // Catch:{ Exception -> 0x0097 }
                com.mbridge.msdk.videocommon.download.a r8 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                r1 = 3
                java.lang.String r8 = r8.f((int) r1)     // Catch:{ Exception -> 0x0097 }
                boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0097 }
                if (r1 != 0) goto L_0x009f
                com.mbridge.msdk.videocommon.download.a r1 = com.mbridge.msdk.videocommon.download.a.this     // Catch:{ Exception -> 0x0097 }
                r1.c((java.lang.String) r8)     // Catch:{ Exception -> 0x0097 }
                goto L_0x009f
            L_0x0097:
                r8 = move-exception
                java.lang.String r8 = r8.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r0, r8)
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.a.AnonymousClass3.onDownloadComplete(com.mbridge.msdk.foundation.download.DownloadMessage):void");
        }

        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (a.this.y != null && a.this.y.getStatus() != DownloadStatus.CANCELLED) {
                String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
                a.this.u();
                a.this.a(3, message, "");
                a.this.a(message);
            }
        }
    };
    private OnProgressStateListener U = new OnProgressStateListener() {
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                long unused = a.this.p = downloadProgress.getCurrent();
                long unused2 = a.this.m = downloadProgress.getTotal();
                int unused3 = a.this.A = downloadProgress.getCurrentDownloadRate();
                if (a.this.t != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.t) {
                    aa.d("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate = " + a.this.t + " " + a.this.d);
                    if (!a.this.e) {
                        boolean unused4 = a.this.e = true;
                        if (!a.this.B) {
                            a aVar = a.this;
                            aVar.c(aVar.f(1));
                            a.this.a(downloadProgress.getCurrent(), false, "");
                        }
                        if (a.this.y != null && a.this.E == 2 && !a.this.B) {
                            a.this.y.cancel(downloadMessage);
                        }
                    }
                }
            } catch (Exception e) {
                aa.d("CampaignDownLoadTask", e.getMessage());
            }
        }
    };
    private boolean a = false;
    private boolean b = false;
    private int c = 1;
    /* access modifiers changed from: private */
    public int d;
    /* access modifiers changed from: private */
    public boolean e = false;
    /* access modifiers changed from: private */
    public volatile int f = 0;
    private CopyOnWriteArrayList<d> g = new CopyOnWriteArrayList<>();
    private com.mbridge.msdk.videocommon.listener.a h;
    private com.mbridge.msdk.videocommon.listener.a i;
    /* access modifiers changed from: private */
    public CampaignEx j;
    private String k;
    private Context l;
    /* access modifiers changed from: private */
    public long m;
    /* access modifiers changed from: private */
    public String n;
    private String o;
    /* access modifiers changed from: private */
    public long p = 0;
    /* access modifiers changed from: private */
    public String q;
    private boolean r = false;
    private long s;
    /* access modifiers changed from: private */
    public int t = 100;
    private boolean u = false;
    /* access modifiers changed from: private */
    public p v;
    private boolean w = false;
    private String x;
    /* access modifiers changed from: private */
    public DownloadRequest y;
    /* access modifiers changed from: private */
    public DownloadRequest z;

    public a(Context context, CampaignEx campaignEx, String str, int i2) {
        File file;
        int i3;
        File file2;
        CampaignEx campaignEx2 = campaignEx;
        if (context != null || campaignEx2 != null) {
            e g2 = f.a().g(b.d().h());
            if (g2 != null) {
                this.I = g2.f();
            }
            this.F = com.mbridge.msdk.foundation.same.a.D;
            this.G = com.mbridge.msdk.foundation.same.a.E;
            this.H = com.mbridge.msdk.foundation.same.a.C;
            this.s = System.currentTimeMillis();
            this.l = b.d().g();
            this.j = campaignEx2;
            this.k = str;
            this.c = i2;
            if (campaignEx2 != null) {
                this.n = campaignEx.getVideoUrlEncode();
            }
            this.x = y.d(this.n);
            this.o = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
            this.q = this.o + this.x;
            this.a = ac.a().a("u_n_d_r_r", false);
            aa.b("CampaignDownLoadTask", this.j.getAppName() + " videoLocalPath:" + this.q + " videoUrl: " + this.j.getVideoUrlEncode() + " " + this.t);
            if (campaignEx2 != null) {
                this.Q = campaignEx.getCurrentLRid();
            }
            try {
                if (!TextUtils.isEmpty(this.n)) {
                    if (!TextUtils.isEmpty(this.o)) {
                        file = new File(this.o);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } else {
                        file = null;
                    }
                    if (file != null && file.exists() && ((file2 = this.D) == null || !file2.exists())) {
                        File file3 = new File(file + "/.nomedia");
                        this.D = file3;
                        if (!file3.exists()) {
                            this.D.createNewFile();
                        }
                    }
                    p a2 = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
                    m a3 = a2.a(this.n, "");
                    if (a3 != null) {
                        this.p = a3.b();
                        if (this.f != 2) {
                            this.f = a3.d();
                        }
                        if (this.f == 1) {
                            this.f = 2;
                        }
                        this.m = (long) a3.c();
                        if (a3.a() > 0) {
                            this.s = a3.a();
                        }
                        if (this.f == 5) {
                            if (Objects.exists(new File(this.o + this.x), this.o, this.x)) {
                                this.q = this.o + this.x;
                            } else {
                                t();
                            }
                        } else if (this.f != 0) {
                            this.q = this.o + this.x;
                        }
                    } else {
                        a2.a(this.n, this.s);
                    }
                    String str2 = this.n;
                    if (TextUtils.isEmpty(str2)) {
                        this.i.a("VideoUrl is NULL, Please check it.", "");
                    } else if (this.f == 1) {
                        aa.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
                    } else if (this.f == 5 && Utils.getDownloadRate(this.m, this.p) >= this.t) {
                        aa.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                        com.mbridge.msdk.videocommon.listener.a aVar = this.h;
                        if (aVar != null) {
                            aVar.a(this.n);
                        }
                        com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
                        if (aVar2 != null) {
                            aVar2.a(this.n);
                        }
                        try {
                            File file4 = new File(this.q);
                            if (Objects.exists(file4, this.o, this.x) && file4.isFile()) {
                                file4.setLastModified(System.currentTimeMillis());
                            }
                        } catch (Exception e2) {
                            aa.d("CampaignDownLoadTask", e2.getMessage());
                        }
                    } else if (this.c == 3) {
                        aa.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                        a(0, false, "");
                    } else {
                        try {
                            i3 = b(this.j);
                        } catch (Exception unused) {
                            i3 = 100;
                        }
                        if (i3 == 0) {
                            com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                            if (aVar3 != null) {
                                aVar3.a(this.n);
                            }
                            com.mbridge.msdk.videocommon.listener.a aVar4 = this.i;
                            if (aVar4 != null) {
                                aVar4.a(this.n);
                            }
                        }
                        if (i3 != 100 && this.a) {
                            DownloadMessage downloadMessage = new DownloadMessage(new Object(), str2, this.x, i3, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                            downloadMessage.setUseCronetDownload(e(this.j));
                            this.z = a(downloadMessage, this.R, this.S);
                        }
                        DownloadMessage downloadMessage2 = new DownloadMessage(new Object(), str2, this.x, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                        downloadMessage2.setUseCronetDownload(e(this.j));
                        this.y = a(downloadMessage2, this.T, this.U);
                    }
                }
            } catch (Exception e3) {
                aa.b("CampaignDownLoadTask", e3.getMessage());
            }
        }
    }

    public final void a(boolean z2) {
        this.M = z2;
    }

    public final boolean a() {
        return this.M;
    }

    public final void b(boolean z2) {
        this.N = z2;
    }

    public final boolean b() {
        return this.N;
    }

    public final void c(boolean z2) {
        this.O = z2;
    }

    public final boolean c() {
        return this.O;
    }

    public final void d(boolean z2) {
        this.P = z2;
    }

    public final boolean d() {
        return this.P;
    }

    public final String e() {
        return this.n;
    }

    public final void a(int i2) {
        this.c = i2;
    }

    public final void b(int i2) {
        this.d = i2;
    }

    public final boolean f() {
        return this.w;
    }

    public final void e(boolean z2) {
        this.w = z2;
    }

    public final long g() {
        return this.s;
    }

    public final void f(boolean z2) {
        this.r = z2;
    }

    public final String h() {
        return this.q;
    }

    public final long i() {
        return this.m;
    }

    public final int j() {
        return this.f;
    }

    public final void a(int i2, int i3) {
        this.f = i2;
        if (this.v == null) {
            this.v = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
        }
        this.v.a(this.n, (long) i3, i2);
    }

    public final CampaignEx k() {
        return this.j;
    }

    public final void a(CampaignEx campaignEx) {
        this.j = campaignEx;
        if (campaignEx != null) {
            this.Q = campaignEx.getCurrentLRid();
        }
    }

    public final void c(int i2) {
        aa.a("CampaignDownLoadTask", "set ready rate: " + i2);
        this.t = i2;
    }

    public final long l() {
        return this.p;
    }

    public final void d(int i2) {
        this.C = i2;
    }

    public final void e(int i2) {
        this.E = i2;
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout((long) this.F).withConnectTimeout((long) this.H).withWriteTimeout((long) this.G).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.o).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).with("do_us_fi_re", Boolean.toString(this.I)).with(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, this.Q).with("down_type", "4").build();
    }

    public final void a(long j2, boolean z2, String str) {
        p pVar;
        aa.d("CampaignDownLoadTask", "setStateToDone ： mProgressSize " + this.p + "  progressSize " + j2 + "  " + this.A + "%   FileSize : " + this.m + "  " + this.j.getAppName());
        long j3 = 0;
        if (this.t != 100 || this.c == 3 || j2 == this.m || z2) {
            this.f = 5;
            if (j2 == this.m) {
                a(1, "", str);
            }
            long j4 = this.m;
            if (!(j4 == 0 || (pVar = this.v) == null)) {
                pVar.b(this.n, j4);
            }
            this.b = false;
            a(j2, this.f);
            return;
        }
        File file = new File(this.q);
        if (Objects.exists(file, this.o, this.x)) {
            j3 = file.length();
        }
        aa.d("CampaignDownLoadTask", "progressSize = " + j2 + " fileSize = " + this.m + " " + z2 + " absFileSize = " + j3);
        a("File size is not match witch download size.");
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.h;
        if (aVar != null) {
            aVar.a(str, this.n);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a(str, this.n);
        }
        aa.d("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.f != 4 && this.f != 2 && this.f != 5) {
            this.f = 4;
            CampaignEx campaignEx = this.j;
            if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || this.j.getRsIgnoreCheckRule().size() <= 0 || !this.j.getRsIgnoreCheckRule().contains(0)) {
                a(this.p, this.f);
            } else {
                aa.b("CampaignDownLoadTask", "Is not check video download status");
            }
        }
    }

    public final void m() {
        aa.d("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.n)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.h;
                if (aVar != null) {
                    aVar.a(this.n);
                    return;
                }
                return;
            }
            if (this.n != null) {
                aa.d("CampaignDownLoadTask", new URL(this.n).getPath());
            }
            if (this.c == 3) {
                aa.d("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a(this.n);
                }
            } else if (this.t == 0 && this.E == 2) {
                aa.d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                if (aVar3 != null) {
                    aVar3.a(this.n);
                }
            } else {
                try {
                    if (this.f == 5 && Utils.getDownloadRate(this.m, this.p) >= this.t) {
                        if (Objects.exists(new File(this.o + this.x), this.o, this.x)) {
                            this.q = this.o + this.x;
                            com.mbridge.msdk.videocommon.listener.a aVar4 = this.h;
                            if (aVar4 != null) {
                                aVar4.a(this.n);
                                return;
                            }
                            return;
                        }
                    }
                } catch (Exception e2) {
                    aa.d("CampaignDownLoadTask", "startForLoadRefactor: " + e2.getMessage());
                }
                boolean z2 = this.a && this.E == 2 && this.t != 100;
                aa.d("CampaignDownLoadTask", "start: ready rate is " + this.t + " and video ctn type is " + this.E + " and isUseNewDownloadReadyRate " + z2);
                if (z2) {
                    DownloadRequest downloadRequest = this.z;
                    if (downloadRequest != null) {
                        downloadRequest.start();
                        return;
                    }
                    DownloadRequest downloadRequest2 = this.y;
                    if (downloadRequest2 != null) {
                        downloadRequest2.start();
                        return;
                    }
                    return;
                }
                DownloadRequest downloadRequest3 = this.y;
                if (downloadRequest3 != null) {
                    downloadRequest3.start();
                    return;
                }
                DownloadRequest downloadRequest4 = this.z;
                if (downloadRequest4 != null) {
                    downloadRequest4.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.h;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void n() {
        aa.d("CampaignDownLoadTask", "start()");
        try {
            if (!TextUtils.isEmpty(this.n)) {
                if (this.n != null) {
                    aa.d("CampaignDownLoadTask", new URL(this.n).getPath());
                }
                int i2 = this.t;
                if (i2 == 0 && this.E == 2) {
                    aa.d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                    return;
                }
                boolean z2 = this.a && this.E == 2 && i2 != 100;
                aa.d("CampaignDownLoadTask", "start: ready rate is " + this.t + " and video ctn type is " + this.E + " and isUseNewDownloadReadyRate " + z2);
                if (z2) {
                    DownloadRequest downloadRequest = this.z;
                    if (downloadRequest != null) {
                        downloadRequest.start();
                        return;
                    }
                    DownloadRequest downloadRequest2 = this.y;
                    if (downloadRequest2 != null) {
                        downloadRequest2.start();
                        return;
                    }
                    return;
                }
                DownloadRequest downloadRequest3 = this.y;
                if (downloadRequest3 != null) {
                    downloadRequest3.start();
                    return;
                }
                DownloadRequest downloadRequest4 = this.z;
                if (downloadRequest4 != null) {
                    downloadRequest4.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.h;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    private int b(CampaignEx campaignEx) {
        int i2;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            i2 = campaignEx.getReady_rate();
            aa.a("CampaignDownLoadTask", "ready_rate(campaign): " + i2);
        } else {
            i2 = c(campaignEx);
            aa.a("CampaignDownLoadTask", "ready_rate(reward_unit_setting): " + i2);
        }
        try {
            return Math.max(i2, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.J == null) {
                    this.J = f.a().c(b.d().h(), this.k);
                }
                return this.J.f();
            } else if (campaignEx.getAdType() == 42) {
                if (this.L == null) {
                    this.L = f.a().e(b.d().h(), this.k);
                }
                return d((CampaignEx) null);
            } else {
                if (this.K == null) {
                    this.K = com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), this.k, false);
                }
                return this.K.r();
            }
        } catch (Throwable th) {
            aa.b("CampaignDownLoadTask", th.getMessage(), th);
            return 100;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            h hVar = this.L;
            if (hVar != null) {
                return hVar.f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void o() {
        boolean z2 = true;
        try {
            this.B = true;
            if (this.E == 1) {
                aa.d("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.E);
            } else if (this.c == 3) {
                aa.d("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.c);
            } else {
                aa.d("CampaignDownLoadTask", "resume()");
                if (!this.a || this.E != 2 || this.t == 100) {
                    z2 = false;
                }
                aa.d("CampaignDownLoadTask", "resume: ready rate is " + this.t + " and video ctn type is " + this.E + " and isUseNewDownloadReadyRate " + z2);
                DownloadMessage downloadMessage = new DownloadMessage(new Object(), this.n, this.x, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                downloadMessage.setUseCronetDownload(e(this.j));
                if (z2) {
                    DownloadRequest<?> a2 = a(downloadMessage, this.R, this.S);
                    this.z = a2;
                    a2.start();
                } else {
                    DownloadRequest<?> a3 = a(downloadMessage, this.T, this.U);
                    this.y = a3;
                    a3.start();
                }
                c(f(2));
            }
        } catch (Exception e2) {
            aa.d("CampaignDownLoadTask", e2.getMessage());
        }
    }

    public final void b(String str) {
        u();
        a(2, str, "");
        this.f = 4;
    }

    public final void a(d dVar) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(dVar);
        }
    }

    public final String p() {
        String str = "";
        if (this.c == 3) {
            return str;
        }
        String str2 = this.o + this.x;
        File file = new File(str2);
        try {
            if (!Objects.exists(file, this.o, this.x)) {
                str = "file is not exist ";
            } else if (!file.isFile()) {
                str = "file is not file ";
            } else if (!file.canRead()) {
                str = "file can not read ";
            } else if (file.length() > 0) {
                this.q = str2;
            } else {
                str = "file length is 0 ";
            }
        } catch (Throwable th) {
            aa.d("CampaignDownLoadTask", th.getMessage());
            str = th.getMessage();
        }
        if (this.f == 5 && !TextUtils.isEmpty(str)) {
            t();
        }
        return str;
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.h = aVar;
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.i = aVar;
    }

    private void a(long j2, int i2) {
        this.p = j2;
        int i3 = this.t;
        if (100 * j2 >= ((long) i3) * this.m && !this.u && i2 != 4) {
            if (i3 != 100 || i2 == 5) {
                this.u = true;
                aa.d("CampaignDownLoadTask", "UpdateListener : state: " + i2 + " progress : " + j2);
                String p2 = p();
                if (TextUtils.isEmpty(p2)) {
                    com.mbridge.msdk.videocommon.listener.a aVar = this.h;
                    if (aVar != null) {
                        aVar.a(this.n);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar2 = this.i;
                    if (aVar2 != null) {
                        aVar2.a(this.n);
                    }
                } else {
                    com.mbridge.msdk.videocommon.listener.a aVar3 = this.h;
                    if (aVar3 != null) {
                        aVar3.a("file is not effective " + p2, this.n);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.i;
                    if (aVar4 != null) {
                        aVar4.a("file is not effective " + p2, this.n);
                    }
                }
            } else {
                this.f = 5;
                return;
            }
        }
        if (!this.b && j2 > 0) {
            this.b = true;
            if (this.v == null) {
                this.v = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
            }
            this.v.a(this.n, j2, this.f);
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            Iterator<d> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.a(j2, i2);
                }
            }
        }
    }

    public final void q() {
        if (this.g != null) {
            this.g = null;
        }
    }

    private void t() {
        if (this.v == null) {
            this.v = p.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g()));
        }
        try {
            this.v.b(this.n);
            if (!ac.a().a("r_d_v_b_l", true)) {
                File file = new File(this.q);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            this.f = 0;
            throw th;
        }
        this.f = 0;
    }

    public final void r() {
        try {
            t();
            CampaignEx campaignEx = this.j;
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.a.a a2 = com.mbridge.msdk.videocommon.a.a.a();
                if (a2 != null) {
                    a2.a(this.j);
                }
                this.f = 0;
                return;
            }
            this.f = 0;
        } catch (Exception unused) {
            aa.d("CampaignDownLoadTask", "del file is failed");
        } catch (Throwable th) {
            this.f = 0;
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.reward.b.a");
            Object newInstance = cls.newInstance();
            cls.getMethod("insertExcludeId", new Class[]{String.class, CampaignEx.class}).invoke(newInstance, new Object[]{this.k, this.j});
            Class<?> cls2 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            Object newInstance2 = cls2.newInstance();
            cls2.getMethod("insertExcludeId", new Class[]{String.class, CampaignEx.class}).invoke(newInstance2, new Object[]{this.k, this.j});
        } catch (Exception e2) {
            aa.d("CampaignDownLoadTask", e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        long j2 = 0;
        if (this.s != 0) {
            j2 = System.currentTimeMillis() - this.s;
        }
        n nVar = new n(this.l, this.j, i2, Long.toString(j2), this.m, this.C);
        nVar.r(this.j.getId());
        nVar.e(this.j.getVideoUrlEncode());
        nVar.t(str);
        nVar.n(this.j.getRequestId());
        nVar.o(this.j.getCurrentLRid());
        nVar.p(this.j.getRequestIdNotice());
        nVar.q(this.k);
        nVar.m(str2);
        try {
            int i3 = this.C;
            if (!(i3 == 94 || i3 == 287)) {
                if (i3 != 296) {
                    q.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g())).a(nVar);
                } else if (ac.a().a("r_l_b_m_t_b", false)) {
                    a(nVar, this.j);
                    com.mbridge.msdk.foundation.same.report.m.a().a(nVar, this.j);
                    return;
                }
            }
            if (ac.a().a("r_l_b_m_t_r_i", true)) {
                a(nVar, this.j);
                com.mbridge.msdk.foundation.same.report.m.a().a(nVar, this.j);
                return;
            }
        } catch (Exception unused) {
        }
        q.a((g) com.mbridge.msdk.foundation.db.h.a(b.d().g())).a(nVar);
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (k.a().c()) {
                    k.a().a(str);
                    return;
                }
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
                d a2 = com.mbridge.msdk.foundation.same.report.q.a(str, b.d().g(), this.k);
                CampaignEx campaignEx = this.j;
                if (!(campaignEx == null || campaignEx.getAdType() == 42)) {
                    a2.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
                }
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a2, (com.mbridge.msdk.foundation.same.net.e) null);
            } catch (Exception e2) {
                aa.d("CampaignDownLoadTask", e2.getMessage());
            }
        }
    }

    public final String s() {
        try {
            File file = new File(this.q);
            if (Objects.exists(file, this.o, this.x) && file.isFile()) {
                return this.q;
            }
        } catch (Exception e2) {
            aa.d("CampaignDownLoadTask", e2.getMessage());
        }
        return this.n;
    }

    /* access modifiers changed from: private */
    public String f(int i2) {
        if (this.j == null || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.j.getRequestId()) || TextUtils.isEmpty(this.j.getVideoUrlEncode())) {
            return "";
        }
        return "key=2000077&unit_id=" + this.k + "&rid=" + this.j.getRequestId() + "&rid_n=" + this.j.getRequestIdNotice() + "&package_name=" + b.d().b() + "&app_id=" + b.d().h() + "&video_url=" + URLEncoder.encode(this.j.getVideoUrlEncode()) + "&process_size=" + this.p + "&file_size=" + this.m + "&ready_rate=" + this.t + "&cd_rate=" + this.d + "&cid=" + this.j.getId() + "&type=" + this.f + "&video_download_status=" + i2;
    }

    private static void a(n nVar, CampaignEx campaignEx) {
        try {
            c a2 = com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), campaignEx.getCampaignUnitId());
            if (a2 != null) {
                nVar.l(a2.l());
            }
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b2 != null) {
                nVar.k(b2.c());
            }
        } catch (Exception e2) {
            aa.d("CampaignDownLoadTask", e2.getMessage());
        }
    }

    private int e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th) {
            aa.d("CampaignDownLoadTask", th.getMessage());
            return 0;
        }
    }
}
