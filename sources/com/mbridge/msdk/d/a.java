package com.mbridge.msdk.d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.reward.adapter.c;
import java.util.LinkedList;
import java.util.List;

/* compiled from: LoopTimer */
public final class a {
    /* access modifiers changed from: private */
    public long a;
    /* access modifiers changed from: private */
    public boolean b;
    private LinkedList<i> c;
    private LinkedList<i> d;
    private int e;
    private int f;
    private f g;
    private com.mbridge.msdk.videocommon.d.a h;
    private o i;
    private h j;
    /* access modifiers changed from: private */
    public Handler k;

    /* renamed from: com.mbridge.msdk.d.a$a  reason: collision with other inner class name */
    /* compiled from: LoopTimer */
    static class C0130a {
        static a a = new a();
    }

    private a() {
        this.b = false;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.k = new Handler() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r5) {
                /*
                    r4 = this;
                    com.mbridge.msdk.d.a r0 = com.mbridge.msdk.d.a.this
                    monitor-enter(r0)
                    int r5 = r5.what     // Catch:{ all -> 0x0034 }
                    r1 = 1
                    if (r5 == r1) goto L_0x0012
                    r1 = 2
                    if (r5 == r1) goto L_0x000c
                    goto L_0x0032
                L_0x000c:
                    com.mbridge.msdk.d.a r5 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0034 }
                    com.mbridge.msdk.d.a.c(r5)     // Catch:{ all -> 0x0034 }
                    goto L_0x0032
                L_0x0012:
                    com.mbridge.msdk.d.a r5 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0034 }
                    boolean r5 = r5.b     // Catch:{ all -> 0x0034 }
                    if (r5 == 0) goto L_0x001c
                    monitor-exit(r0)     // Catch:{ all -> 0x0034 }
                    return
                L_0x001c:
                    com.mbridge.msdk.d.a r5 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0034 }
                    long r2 = r5.a     // Catch:{ all -> 0x0034 }
                    com.mbridge.msdk.d.a.a((com.mbridge.msdk.d.a) r5, (long) r2)     // Catch:{ all -> 0x0034 }
                    android.os.Message r5 = r4.obtainMessage(r1)     // Catch:{ all -> 0x0034 }
                    com.mbridge.msdk.d.a r1 = com.mbridge.msdk.d.a.this     // Catch:{ all -> 0x0034 }
                    long r1 = r1.a     // Catch:{ all -> 0x0034 }
                    r4.sendMessageDelayed(r5, r1)     // Catch:{ all -> 0x0034 }
                L_0x0032:
                    monitor-exit(r0)     // Catch:{ all -> 0x0034 }
                    return
                L_0x0034:
                    r5 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0034 }
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.d.a.AnonymousClass1.handleMessage(android.os.Message):void");
            }
        };
    }

    private boolean a(i iVar) {
        boolean z = false;
        if (iVar == null || TextUtils.isEmpty(iVar.a())) {
            return false;
        }
        String a2 = iVar.a();
        try {
            if (this.g != null) {
                com.mbridge.msdk.videocommon.d.a aVar = this.h;
                int a3 = this.g.a(a2, aVar != null ? aVar.f() : 0);
                if (a3 != -1) {
                    if (a3 != 1) {
                    }
                } else if (!TextUtils.isEmpty(a2)) {
                    LinkedList<i> linkedList = this.c;
                    if (linkedList == null || !linkedList.contains(a2)) {
                        LinkedList<i> linkedList2 = this.d;
                        if (linkedList2 != null && linkedList2.contains(a2)) {
                            this.d.remove(a2);
                        }
                    } else {
                        this.c.remove(a2);
                    }
                    o oVar = this.i;
                    if (oVar != null) {
                        oVar.a(a2);
                    }
                }
                try {
                    Handler handler = this.k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                }
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            z = true;
            aa.b("LoopTimer", th.getMessage(), th);
            return z;
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context g2 = b.d().g();
            if (g2 != null) {
                final c cVar = new c(g2, str, str2);
                cVar.b(z);
                cVar.a((com.mbridge.msdk.reward.adapter.a) new com.mbridge.msdk.reward.adapter.a() {
                    public final void a(List<CampaignEx> list) {
                    }

                    public final void a(List<CampaignEx> list, String str) {
                        a.this.k.sendMessage(a.this.k.obtainMessage(2));
                        cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                    }

                    public final void a(String str) {
                        a.this.k.sendMessage(a.this.k.obtainMessage(2));
                        cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                    }
                });
                cVar.a(1, 8000, false);
            }
        } catch (Exception e2) {
            aa.b("LoopTimer", e2.getMessage(), e2);
        }
    }

    public final void a(String str, String str2) {
        if (!this.c.contains(str2)) {
            this.c.add(new i(str, str2, 94));
            o oVar = this.i;
            if (oVar != null) {
                oVar.a(str, str2, 94);
            }
        }
    }

    public final void b(String str, String str2) {
        if (!this.d.contains(str2)) {
            this.d.add(new i(str, str2, 287));
            o oVar = this.i;
            if (oVar != null) {
                oVar.a(str, str2, 287);
            }
        }
    }

    public final void a(long j2) {
        if (this.j == null) {
            this.j = h.a(b.d().g());
        }
        if (this.i == null) {
            this.i = o.a((g) this.j);
        }
        List<i> a2 = this.i.a(287);
        if (a2 != null) {
            this.d.addAll(a2);
            for (i next : a2) {
                b(next.b(), next.a());
            }
        }
        List<i> a3 = this.i.a(94);
        if (a3 != null) {
            this.c.addAll(a3);
            for (i next2 : a3) {
                a(next2.b(), next2.a());
            }
        }
        if (this.g == null) {
            this.g = f.a((g) this.j);
        }
        if (this.h == null) {
            this.h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.a = j2;
        this.b = false;
        Handler handler = this.k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.a);
    }

    static /* synthetic */ void a(a aVar, long j2) {
        LinkedList<i> linkedList = aVar.c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.e == 0 || aVar.c.size() <= aVar.e) {
            LinkedList<i> linkedList2 = aVar.d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f == 0 || aVar.d.size() == aVar.f) {
                aVar.f = 0;
                aVar.e = 0;
                Handler handler = aVar.k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    static /* synthetic */ void c(a aVar) {
        try {
            LinkedList<i> linkedList = aVar.c;
            if (linkedList == null || linkedList.size() <= 0 || aVar.e >= aVar.c.size()) {
                LinkedList<i> linkedList2 = aVar.d;
                if (linkedList2 != null && linkedList2.size() > 0 && aVar.f < aVar.d.size()) {
                    i iVar = aVar.d.get(aVar.f);
                    aVar.f++;
                    if (aVar.a(iVar)) {
                        aVar.a(iVar.b(), iVar.a(), true);
                        return;
                    }
                    return;
                }
                return;
            }
            i iVar2 = aVar.c.get(aVar.e);
            aVar.e++;
            if (aVar.a(iVar2)) {
                aVar.a(iVar2.b(), iVar2.a(), false);
            }
        } catch (Throwable th) {
            aa.b("LoopTimer", th.getMessage(), th);
        }
    }
}
