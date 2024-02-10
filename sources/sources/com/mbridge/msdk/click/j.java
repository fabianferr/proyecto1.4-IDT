package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.entity.b;
import com.mbridge.msdk.click.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import java.util.concurrent.Semaphore;

/* compiled from: SocketRequestTask */
public final class j extends a {
    private final Semaphore a = new Semaphore(0);
    private Context e;
    private String f;
    private String g;
    private String h;
    private CampaignEx i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private com.mbridge.msdk.click.entity.a n;
    /* access modifiers changed from: private */
    public JumpLoaderResult o;
    private e p;
    /* access modifiers changed from: private */
    public i q;
    private final l.a r = new l.a() {
        public final boolean c(String str) {
            return false;
        }

        public final boolean a(String str) {
            boolean a2 = j.a(j.this, str);
            if (a2) {
                a();
            }
            return a2;
        }

        public final boolean b(String str) {
            boolean a2 = j.a(j.this, str);
            if (a2) {
                a();
            }
            return a2;
        }

        public final void a(String str, boolean z, String str2) {
            j.a(j.this, str);
            j.this.o.setContent(str2);
            a();
        }

        private void a() {
            synchronized (this) {
                j.this.o.setSuccess(true);
                if (j.this.q != null) {
                    j.this.q.a(j.this.o);
                }
                j.this.a.release();
            }
        }

        public final void a(int i, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                j.this.o.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                j.this.o.setContent(str3);
            }
            j.a(j.this, str);
            a();
        }
    };

    public final void b() {
    }

    public j(b bVar) {
        this.e = bVar.a();
        this.f = bVar.b();
        this.g = bVar.c();
        this.h = bVar.d();
        this.i = bVar.e();
        this.j = bVar.f();
        this.k = bVar.g();
        this.l = bVar.i();
        this.m = bVar.h();
    }

    public final void a(e eVar) {
        this.p = eVar;
    }

    public final void a(i iVar) {
        this.q = iVar;
    }

    public final void a() {
        e eVar = this.p;
        if (eVar != null) {
            eVar.a((Object) null);
        }
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        this.o = jumpLoaderResult;
        jumpLoaderResult.setUrl(this.f);
        JumpLoaderResult a2 = a(this.f);
        this.o = a2;
        if (!TextUtils.isEmpty(a2.getExceptionMsg())) {
            this.o.setSuccess(true);
        }
        if (this.c != a.b.RUNNING) {
            i iVar = this.q;
            if (iVar != null) {
                iVar.a(this.o);
            }
        } else if (!this.o.isSuccess()) {
            i iVar2 = this.q;
            if (iVar2 != null) {
                iVar2.a(this.o);
            }
        } else {
            com.mbridge.msdk.click.entity.a aVar = this.n;
            if (aVar != null) {
                this.o.setStatusCode(aVar.f);
            }
            if (ae.a.a(this.o.getUrl()) || 200 != this.n.f || TextUtils.isEmpty(this.o.getContent()) || this.o.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                if (this.n != null) {
                    this.o.setType(1);
                    this.o.setExceptionMsg(this.n.h);
                    this.o.setStatusCode(this.n.f);
                    this.o.setHeader(this.n.a());
                    this.o.setContent(this.n.g);
                }
                String url = this.o.getUrl();
                if (ae.a.a(url)) {
                    this.o.setCode(1);
                    this.o.setUrl(url);
                    this.o.setjumpDone(true);
                } else {
                    this.o.setCode(2);
                    this.o.setUrl(url);
                }
                i iVar3 = this.q;
                if (iVar3 != null) {
                    iVar3.a(this.o);
                    return;
                }
                return;
            }
            this.o.setType(2);
            if (!TextUtils.isEmpty(this.o.getContent())) {
                new l().a(this.g, this.h, this.e, this.o.getUrl(), this.o.getContent(), this.r);
            } else {
                try {
                    new l().a(this.g, this.h, this.e, this.o.getUrl(), this.r);
                } catch (Exception unused) {
                    aa.d("TAG", "webview spider start error");
                }
            }
            this.a.acquireUninterruptibly();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0179 A[EDGE_INSN: B:73:0x0179->B:63:0x0179 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r15 = r14.b((java.lang.String) r15)
            com.mbridge.msdk.click.entity.JumpLoaderResult r0 = new com.mbridge.msdk.click.entity.JumpLoaderResult
            r0.<init>()
            com.mbridge.msdk.click.k r1 = new com.mbridge.msdk.click.k
            r1.<init>()
            com.mbridge.msdk.click.g r2 = new com.mbridge.msdk.click.g
            r2.<init>()
            java.lang.String r3 = ""
            boolean r4 = android.webkit.URLUtil.isNetworkUrl(r15)     // Catch:{ Exception -> 0x002c }
            if (r4 == 0) goto L_0x002a
            java.net.URI r4 = java.net.URI.create(r15)     // Catch:{ Exception -> 0x002c }
            java.lang.String r5 = r4.getScheme()     // Catch:{ Exception -> 0x002c }
            java.lang.String r3 = r4.getHost()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0037
        L_0x0028:
            r4 = move-exception
            goto L_0x002e
        L_0x002a:
            r4 = r3
            goto L_0x0039
        L_0x002c:
            r4 = move-exception
            r5 = r3
        L_0x002e:
            java.lang.String r6 = "SocketRequestTask"
            java.lang.String r4 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r6, r4)
        L_0x0037:
            r4 = r3
            r3 = r5
        L_0x0039:
            r5 = 0
            r7 = r15
            r15 = 0
        L_0x003c:
            r6 = 10
            if (r15 >= r6) goto L_0x0179
            com.mbridge.msdk.foundation.same.e.a$b r6 = r14.c
            com.mbridge.msdk.foundation.same.e.a$b r8 = com.mbridge.msdk.foundation.same.e.a.b.RUNNING
            r9 = 0
            if (r6 == r8) goto L_0x0048
            return r9
        L_0x0048:
            java.lang.String r6 = "tcp"
            boolean r6 = r7.startsWith(r6)
            r8 = 1
            if (r6 == 0) goto L_0x0060
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r14.i
            boolean r10 = r14.j
            boolean r11 = r14.k
            com.mbridge.msdk.click.entity.a r6 = r1.a(r7, r6, r10, r11)
            r14.n = r6
            r6 = 3
            goto L_0x006d
        L_0x0060:
            boolean r6 = r14.j
            boolean r10 = r14.k
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r14.i
            com.mbridge.msdk.click.entity.a r6 = r2.a(r7, r6, r10, r11)
            r14.n = r6
            r6 = 1
        L_0x006d:
            com.mbridge.msdk.click.entity.a r10 = r14.n
            if (r10 != 0) goto L_0x0079
            r0.setUrl(r7)
            r0.setSuccess(r5)
            goto L_0x0179
        L_0x0079:
            java.lang.String r10 = r10.h
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00b3
            r0.setUrl(r7)
            com.mbridge.msdk.click.entity.a r1 = r14.n
            java.lang.String r1 = r1.h
            r0.setExceptionMsg(r1)
            r0.setType(r6)
            com.mbridge.msdk.click.entity.a r1 = r14.n
            java.lang.String r1 = r1.a()
            r0.setHeader(r1)
            r0.setSuccess(r5)
            if (r15 != 0) goto L_0x0179
            com.mbridge.msdk.click.a.a r6 = com.mbridge.msdk.click.a.a.a()
            com.mbridge.msdk.click.entity.a r15 = r14.n
            java.lang.String r8 = r15.h
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r14.i
            java.lang.String r10 = r14.h
            boolean r11 = r14.j
            boolean r12 = r14.k
            int r13 = r14.l
            r6.a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0179
        L_0x00b3:
            com.mbridge.msdk.click.entity.a r6 = r14.n
            int r6 = r6.f
            r10 = 200(0xc8, float:2.8E-43)
            if (r6 != r10) goto L_0x00d4
            r0.setjumpDone(r8)
            r0.setUrl(r7)
            r0.setSuccess(r8)
            com.mbridge.msdk.click.entity.a r15 = r14.n
            java.lang.String r15 = r15.g
            if (r15 != 0) goto L_0x00cb
            goto L_0x00cf
        L_0x00cb:
            com.mbridge.msdk.click.entity.a r15 = r14.n
            java.lang.String r9 = r15.g
        L_0x00cf:
            r0.setContent(r9)
            goto L_0x0179
        L_0x00d4:
            com.mbridge.msdk.click.entity.a r6 = r14.n
            int r6 = r6.f
            r10 = 301(0x12d, float:4.22E-43)
            if (r6 == r10) goto L_0x010c
            com.mbridge.msdk.click.entity.a r6 = r14.n
            int r6 = r6.f
            r10 = 302(0x12e, float:4.23E-43)
            if (r6 == r10) goto L_0x010c
            com.mbridge.msdk.click.entity.a r6 = r14.n
            int r6 = r6.f
            r10 = 307(0x133, float:4.3E-43)
            if (r6 != r10) goto L_0x00ed
            goto L_0x010c
        L_0x00ed:
            r0.setjumpDone(r5)
            r0.setUrl(r7)
            if (r15 != 0) goto L_0x0179
            com.mbridge.msdk.click.a.a r6 = com.mbridge.msdk.click.a.a.a()
            com.mbridge.msdk.click.entity.a r15 = r14.n
            java.lang.String r8 = r15.h
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r14.i
            java.lang.String r10 = r14.h
            boolean r11 = r14.j
            boolean r12 = r14.k
            int r13 = r14.l
            r6.a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0179
        L_0x010c:
            r0.setSuccess(r8)
            r0.setIs302Jump(r8)
            com.mbridge.msdk.click.entity.a r6 = r14.n
            java.lang.String r6 = r6.a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0123
            r0.setjumpDone(r8)
            r0.setUrl(r7)
            goto L_0x0179
        L_0x0123:
            com.mbridge.msdk.click.entity.a r6 = r14.n
            java.lang.String r6 = r6.a
            java.lang.String r7 = "http"
            boolean r7 = r6.startsWith(r7)
            if (r7 != 0) goto L_0x0164
            java.lang.String r7 = "/"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x015d
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 != 0) goto L_0x015d
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x015d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r3 = "://"
            r7.append(r3)
            r7.append(r4)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r3 = r9
            r4 = r3
            goto L_0x0164
        L_0x015d:
            r0.setjumpDone(r8)
            r0.setUrl(r6)
            goto L_0x0179
        L_0x0164:
            boolean r7 = com.mbridge.msdk.foundation.tools.ae.a.a((java.lang.String) r6)
            if (r7 == 0) goto L_0x0171
            r0.setjumpDone(r8)
            r0.setUrl(r6)
            goto L_0x0179
        L_0x0171:
            java.lang.String r7 = r14.b((java.lang.String) r6)
            int r15 = r15 + 1
            goto L_0x003c
        L_0x0179:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.j.a(java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    private String b(String str) {
        if (!this.m) {
            return str;
        }
        String a2 = e.a(this.e, str);
        if (TextUtils.isEmpty(a2)) {
            return str;
        }
        return str + a2;
    }

    static /* synthetic */ boolean a(j jVar, String str) {
        if (ae.a.a(jVar.o.getUrl())) {
            jVar.o.setCode(1);
            jVar.o.setUrl(str);
            jVar.o.setjumpDone(true);
            return true;
        }
        jVar.o.setCode(2);
        jVar.o.setUrl(str);
        return false;
    }
}
