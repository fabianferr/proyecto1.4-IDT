package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.foundation.tools.ae;
import java.util.concurrent.Semaphore;

/* compiled from: WebViewSpiderLoader */
public final class m extends d implements a.C0139a {
    /* access modifiers changed from: private */
    public e a;
    /* access modifiers changed from: private */
    public JumpLoaderResult b;
    /* access modifiers changed from: private */
    public boolean c = true;
    /* access modifiers changed from: private */
    public boolean d;
    private Context e;
    private b f;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.click.entity.a g;
    private Handler h = new Handler(Looper.getMainLooper());

    public m(Context context) {
        this.e = context;
        this.f = new b(context, 2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.mbridge.msdk.click.m$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.mbridge.msdk.click.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.mbridge.msdk.click.m$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.mbridge.msdk.click.m$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r13, com.mbridge.msdk.click.e r14, boolean r15, java.lang.String r16, java.lang.String r17, com.mbridge.msdk.foundation.entity.CampaignEx r18, boolean r19, boolean r20, int r21) {
        /*
            r12 = this;
            r10 = r12
            r3 = r13
            r0 = r15
            r1 = r14
            r10.a = r1
            r10.d = r0
            com.mbridge.msdk.click.entity.b r1 = new com.mbridge.msdk.click.entity.b
            r1.<init>()
            android.content.Context r2 = r10.e
            r1.a((android.content.Context) r2)
            r1.a((java.lang.String) r13)
            r1.c((boolean) r15)
            r4 = r16
            r1.b((java.lang.String) r4)
            r5 = r17
            r1.c((java.lang.String) r5)
            r6 = r18
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r6)
            r7 = r19
            r1.a((boolean) r7)
            r8 = r20
            r1.b((boolean) r8)
            r9 = r21
            r1.a((int) r9)
            java.lang.String r0 = "tcp"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0052
            com.mbridge.msdk.click.j r0 = new com.mbridge.msdk.click.j
            r0.<init>(r1)
            com.mbridge.msdk.click.e r1 = r10.a
            r0.a((com.mbridge.msdk.click.e) r1)
            com.mbridge.msdk.click.m$1 r1 = new com.mbridge.msdk.click.m$1
            r1.<init>()
            r0.a((com.mbridge.msdk.click.i) r1)
            goto L_0x0068
        L_0x0052:
            com.mbridge.msdk.click.m$a r11 = new com.mbridge.msdk.click.m$a
            android.content.Context r2 = r10.e
            r0 = r11
            r1 = r12
            r3 = r13
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0068:
            com.mbridge.msdk.foundation.same.e.b r1 = r10.f
            r1.a(r0, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.m.a(java.lang.String, com.mbridge.msdk.click.e, boolean, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, boolean, boolean, int):void");
    }

    public final void a() {
        this.c = false;
    }

    /* compiled from: WebViewSpiderLoader */
    private class a extends com.mbridge.msdk.foundation.same.e.a {
        private final Semaphore e = new Semaphore(0);
        private final Context f;
        private String g;
        private String h;
        private String i;
        private CampaignEx j;
        private boolean k;
        private boolean l;
        private int m;
        private l.a n = new l.a() {
            public final boolean c(String str) {
                return false;
            }

            public final boolean a(String str) {
                boolean a2 = a.this.a(str);
                if (a2) {
                    a();
                }
                return a2;
            }

            public final boolean b(String str) {
                boolean a2 = a.this.a(str);
                if (a2) {
                    a();
                }
                return a2;
            }

            public final void a(String str, boolean z, String str2) {
                boolean unused = a.this.a(str);
                m.this.b.setContent(str2);
                a();
            }

            private void a() {
                synchronized (m.this) {
                    m.this.b.setSuccess(true);
                    a.this.e.release();
                }
            }

            public final void a(int i, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    m.this.b.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    m.this.b.setContent(str3);
                }
                boolean unused = a.this.a(str);
                a();
            }
        };

        public final void b() {
        }

        public a(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z, boolean z2, int i2) {
            this.f = context;
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.j = campaignEx;
            this.k = z;
            this.l = z2;
            this.m = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01e9 A[EDGE_INSN: B:81:0x01e9->B:79:0x01e9 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r16, boolean r17, boolean r18, com.mbridge.msdk.foundation.entity.CampaignEx r19, int r20) {
            /*
                r15 = this;
                r1 = r15
                r0 = r16
                java.lang.String r2 = ""
                com.mbridge.msdk.click.m r3 = com.mbridge.msdk.click.m.this
                boolean r3 = r3.d
                if (r3 == 0) goto L_0x0028
                android.content.Context r3 = r1.f
                java.lang.String r3 = com.mbridge.msdk.c.e.a(r3, r0)
                boolean r4 = android.text.TextUtils.isEmpty(r3)
                if (r4 != 0) goto L_0x0028
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                r4.append(r3)
                java.lang.String r0 = r4.toString()
            L_0x0028:
                r3 = r0
                com.mbridge.msdk.click.entity.JumpLoaderResult r4 = new com.mbridge.msdk.click.entity.JumpLoaderResult
                r4.<init>()
                com.mbridge.msdk.click.g r5 = new com.mbridge.msdk.click.g
                r5.<init>()
                boolean r0 = r15.b(r3)     // Catch:{ Exception -> 0x004a }
                if (r0 != 0) goto L_0x0048
                java.net.URI r0 = java.net.URI.create(r3)     // Catch:{ Exception -> 0x004a }
                java.lang.String r6 = r0.getScheme()     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r0.getHost()     // Catch:{ Exception -> 0x0046 }
                goto L_0x004f
            L_0x0046:
                r0 = move-exception
                goto L_0x004c
            L_0x0048:
                r0 = r2
                goto L_0x0051
            L_0x004a:
                r0 = move-exception
                r6 = r2
            L_0x004c:
                r0.printStackTrace()
            L_0x004f:
                r0 = r2
                r2 = r6
            L_0x0051:
                r6 = 0
                r8 = r3
                r7 = 0
                r3 = r2
                r2 = r0
            L_0x0056:
                r0 = 10
                if (r7 >= r0) goto L_0x01e9
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                boolean r0 = r0.c
                r9 = 0
                if (r0 != 0) goto L_0x0064
                return r9
            L_0x0064:
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                r12 = r17
                r13 = r18
                r10 = r19
                com.mbridge.msdk.click.entity.a r11 = r5.a(r8, r12, r13, r10)
                com.mbridge.msdk.click.entity.a unused = r0.g = r11
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                if (r0 != 0) goto L_0x0083
                r4.setUrl(r8)
                r4.setSuccess(r6)
                goto L_0x01e9
            L_0x0083:
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r0 = r0.h
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                r11 = 1
                if (r0 != 0) goto L_0x00d0
                r4.setUrl(r8)
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r0 = r0.h
                r4.setExceptionMsg(r0)
                r4.setType(r11)
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r0 = r0.a()
                r4.setHeader(r0)
                r4.setSuccess(r6)
                if (r7 != 0) goto L_0x01e9
                com.mbridge.msdk.click.a.a r7 = com.mbridge.msdk.click.a.a.a()
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r9 = r0.h
                java.lang.String r11 = r1.i
                r10 = r19
                r12 = r17
                r13 = r18
                r14 = r20
                r7.a(r8, r9, r10, r11, r12, r13, r14)
                goto L_0x01e9
            L_0x00d0:
                r4.setSuccess(r11)
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                int r0 = r0.f
                r14 = 301(0x12d, float:4.22E-43)
                if (r0 == r14) goto L_0x00ea
                r14 = 302(0x12e, float:4.23E-43)
                if (r0 == r14) goto L_0x00ea
                r14 = 307(0x133, float:4.3E-43)
                if (r0 != r14) goto L_0x00e8
                goto L_0x00ea
            L_0x00e8:
                r0 = 0
                goto L_0x00eb
            L_0x00ea:
                r0 = 1
            L_0x00eb:
                if (r0 == 0) goto L_0x0197
                r4.setIs302Jump(r11)
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r0 = r0.a
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0106
                r4.setjumpDone(r11)
                r4.setUrl(r8)
                goto L_0x01e9
            L_0x0106:
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r8 = r0.a
                boolean r0 = r15.b(r8)
                if (r0 == 0) goto L_0x014a
                java.lang.String r0 = "/"
                boolean r0 = r8.startsWith(r0)
                if (r0 == 0) goto L_0x0142
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                if (r0 != 0) goto L_0x0142
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r0 != 0) goto L_0x0142
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r3)
                java.lang.String r3 = "://"
                r0.append(r3)
                r0.append(r2)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                r2 = r9
                r3 = r2
                goto L_0x0162
            L_0x0142:
                r4.setjumpDone(r11)
                r4.setUrl(r8)
                goto L_0x01e9
            L_0x014a:
                boolean r0 = r15.b(r8)
                if (r0 != 0) goto L_0x0162
                java.net.URI r0 = java.net.URI.create(r8)     // Catch:{ Exception -> 0x015e }
                java.lang.String r3 = r0.getScheme()     // Catch:{ Exception -> 0x015e }
                java.lang.String r0 = r0.getHost()     // Catch:{ Exception -> 0x015e }
                r2 = r0
                goto L_0x0162
            L_0x015e:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0162:
                boolean r0 = com.mbridge.msdk.foundation.tools.ae.a.a((java.lang.String) r8)
                if (r0 == 0) goto L_0x0170
                r4.setjumpDone(r11)
                r4.setUrl(r8)
                goto L_0x01e9
            L_0x0170:
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                boolean r0 = r0.d
                if (r0 == 0) goto L_0x0193
                android.content.Context r0 = r1.f
                java.lang.String r0 = com.mbridge.msdk.c.e.a(r0, r8)
                boolean r9 = android.text.TextUtils.isEmpty(r0)
                if (r9 != 0) goto L_0x0193
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r8)
                r9.append(r0)
                java.lang.String r8 = r9.toString()
            L_0x0193:
                int r7 = r7 + 1
                goto L_0x0056
            L_0x0197:
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                int r0 = r0.f
                r2 = 200(0xc8, float:2.8E-43)
                if (r0 != r2) goto L_0x01a5
                r0 = 1
                goto L_0x01a6
            L_0x01a5:
                r0 = 0
            L_0x01a6:
                if (r0 == 0) goto L_0x01ba
                r4.setjumpDone(r11)
                r4.setUrl(r8)
                com.mbridge.msdk.click.m r0 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r0 = r0.g
                java.lang.String r0 = r0.g
                r4.setContent(r0)
                goto L_0x01e9
            L_0x01ba:
                r4.setjumpDone(r6)
                r4.setUrl(r8)
                if (r7 != 0) goto L_0x01e9
                com.mbridge.msdk.click.a.a r7 = com.mbridge.msdk.click.a.a.a()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r2 = "error code:"
                r0.<init>(r2)
                com.mbridge.msdk.click.m r2 = com.mbridge.msdk.click.m.this
                com.mbridge.msdk.click.entity.a r2 = r2.g
                int r2 = r2.f
                r0.append(r2)
                java.lang.String r9 = r0.toString()
                java.lang.String r11 = r1.i
                r10 = r19
                r12 = r17
                r13 = r18
                r14 = r20
                r7.a(r8, r9, r10, r11, r12, r13, r14)
            L_0x01e9:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.m.a.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx, int):com.mbridge.msdk.click.entity.JumpLoaderResult");
        }

        /* access modifiers changed from: private */
        public boolean a(String str) {
            CampaignEx campaignEx = this.j;
            if (campaignEx != null) {
                campaignEx.getLinkType();
            }
            if (ae.a.a(str)) {
                m.this.b.setCode(1);
                m.this.b.setUrl(str);
                m.this.b.setjumpDone(true);
                return true;
            }
            m.this.b.setCode(2);
            m.this.b.setUrl(str);
            return false;
        }

        private boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        public final void a() {
            if (m.this.a != null) {
                m.this.a.a((Object) null);
            }
            JumpLoaderResult unused = m.this.b = new JumpLoaderResult();
            m.this.b.setUrl(this.g);
            JumpLoaderResult unused2 = m.this.b = a(this.g, this.k, this.l, this.j, this.m);
            if (!TextUtils.isEmpty(m.this.b.getExceptionMsg())) {
                m.this.b.setSuccess(true);
            }
            if (m.this.c && m.this.b.isSuccess()) {
                if (m.this.g != null) {
                    m.this.b.setStatusCode(m.this.g.f);
                }
                if (ae.a.a(m.this.b.getUrl()) || 200 != m.this.g.f || TextUtils.isEmpty(m.this.b.getContent()) || m.this.b.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    if (m.this.g != null) {
                        m.this.b.setType(1);
                        m.this.b.setExceptionMsg(m.this.g.h);
                        m.this.b.setStatusCode(m.this.g.f);
                        m.this.b.setHeader(m.this.g.a());
                        m.this.b.setContent(m.this.g.g);
                    }
                    a(m.this.b.getUrl());
                    return;
                }
                m.this.b.setType(2);
                if (!TextUtils.isEmpty(m.this.b.getContent())) {
                    new l().a(this.h, this.i, this.f, m.this.b.getUrl(), m.this.b.getContent(), this.n);
                } else {
                    try {
                        new l().a(this.h, this.i, this.f, m.this.b.getUrl(), this.n);
                    } catch (Exception unused3) {
                    }
                }
                this.e.acquireUninterruptibly();
            }
        }
    }

    public final void a(a.b bVar) {
        if (bVar == a.b.FINISH && this.c) {
            this.h.post(new Runnable() {
                public final void run() {
                    if (m.this.a == null) {
                        return;
                    }
                    if (m.this.b.isSuccess()) {
                        m.this.a.b(m.this.b);
                    } else {
                        m.this.a.a(m.this.b, m.this.b.getMsg());
                    }
                }
            });
        }
    }
}
