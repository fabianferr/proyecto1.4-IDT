package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.e.a.a.g;
import com.mbridge.msdk.e.m;
import com.mbridge.msdk.e.o;
import com.mbridge.msdk.e.v;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: MBRevenueBatchReportManager */
public final class l {
    /* access modifiers changed from: private */
    public static final String a = "l";
    private static volatile l b = null;
    private static String c = "roas";
    private m d;
    /* access modifiers changed from: private */
    public Handler e;
    private int f = 1;
    private long g = 0;
    private String h = d.a().H;
    /* access modifiers changed from: private */
    public BatchReportDao i;
    /* access modifiers changed from: private */
    public AtomicInteger j;
    /* access modifiers changed from: private */
    public Stack<Long> k;
    private Executor l = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public volatile int m = 0;
    /* access modifiers changed from: private */
    public boolean n = false;

    private l() {
        a h2;
        o oVar;
        e b2 = f.a().b(b.d().h());
        if (!(b2 == null || (h2 = b2.h()) == null)) {
            this.f = h2.f();
            this.g = ((long) h2.g()) * 1000;
            this.h = d.a().H;
            this.m = h2.h();
            boolean z = h2.a() == 1;
            this.n = z;
            if (z && this.m != 1) {
                int a2 = ac.a().a("bcp", "type", ac.a().a("t_r_t", 0));
                if (!(a2 == 0 || a2 == 1)) {
                    a2 = 0;
                }
                w.a a3 = new w.a().a((com.mbridge.msdk.e.d) new i()).a((v) new u());
                if (a2 == 1) {
                    oVar = new o(new t((byte) 2), d.a().i, d.a().m);
                } else {
                    oVar = new o(new g(), d.a().H, 0);
                }
                this.d = m.a(c, b.d().g(), a3.a(a2, oVar).e(ac.a().a("t_m_e_t", 604800000)).a(ac.a().a("t_m_e_s", 50)).d(ac.a().a("t_m_r_c", 50)).b(ac.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ac.a().a("t_m_r_t_s", 2)).a());
                JSONObject c2 = h.c();
                try {
                    c2.put("device_type", com.mbridge.msdk.foundation.tools.w.s(b.d().g()) ? "pad" : "phone");
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                        c2.put(com.mbridge.msdk.foundation.same.net.h.d.d, com.mbridge.msdk.foundation.tools.w.s());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.d.a(c2);
                this.d.a();
            }
        }
        String str = a;
        aa.a(str, "初始化批量上报： " + this.h + " " + this.f + " " + this.g + " " + this.m);
        this.j = new AtomicInteger(0);
        this.k = new Stack<>();
        this.i = BatchReportDao.getInstance(b.d().g());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                int i = message.what;
                int i2 = 0;
                if (i == 1) {
                    Bundle data = message.getData();
                    if (l.this.e != null && l.this.i != null && data != null) {
                        l.this.e.removeMessages(2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<BatchReportMessage> batchReportMessages = l.this.i.getBatchReportMessages(currentTimeMillis, 2);
                        l.a(l.this, (ArrayList) batchReportMessages, currentTimeMillis);
                        l.this.j.set(0);
                        String c = l.a;
                        StringBuilder sb = new StringBuilder("超时上报触发了，需要上报的数据： ");
                        if (batchReportMessages != null) {
                            i2 = batchReportMessages.size();
                        }
                        sb.append(i2);
                        aa.a(c, sb.toString());
                    }
                } else if (i == 2) {
                    Bundle data2 = message.getData();
                    if (l.this.e != null && l.this.i != null && data2 != null) {
                        l.this.e.removeMessages(1);
                        long j = data2.getLong("last_report_time");
                        ArrayList<BatchReportMessage> batchReportMessages2 = l.this.i.getBatchReportMessages(j, 2);
                        l.a(l.this, (ArrayList) batchReportMessages2, j);
                        String c2 = l.a;
                        StringBuilder sb2 = new StringBuilder("队列上报触发了，需要上报的数据： ");
                        if (batchReportMessages2 != null) {
                            i2 = batchReportMessages2.size();
                        }
                        sb2.append(i2);
                        aa.a(c2, sb2.toString());
                    }
                } else if (i == 3) {
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        l.b(l.this, data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                    }
                } else if (i == 4) {
                    Bundle data4 = message.getData();
                    if (l.this.e != null && l.this.i != null && data4 != null && l.this.n) {
                        l.this.e.removeMessages(4);
                        ArrayList<BatchReportMessage> batchReportMessages3 = l.this.i.getBatchReportMessages(System.currentTimeMillis(), 2);
                        if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                            for (int i3 = 0; i3 < batchReportMessages3.size(); i3++) {
                                BatchReportMessage batchReportMessage = batchReportMessages3.get(i3);
                                l.a(l.this, batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                            }
                        }
                        String c3 = l.a;
                        StringBuilder sb3 = new StringBuilder("切换上报lib，需要上报的数据： ");
                        if (batchReportMessages3 != null) {
                            i2 = batchReportMessages3.size();
                        }
                        sb3.append(i2);
                        aa.a(c3, sb3.toString());
                    }
                }
            }
        };
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (b == null) {
                b = new l();
            }
            lVar = b;
        }
        return lVar;
    }

    public final void b() {
        Handler handler = this.e;
        if (handler != null && !handler.hasMessages(1) && this.m != 1 && !this.n) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.e.sendMessageDelayed(obtain, 5000);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("state", i2 + "");
        if (i2 == 2) {
            hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        }
        m.a().b("m_ad_rev_s_s", "roas", "", "", hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.m     // Catch:{ all -> 0x001d }
            r1 = 1
            if (r0 != r1) goto L_0x0008
            monitor-exit(r2)
            return
        L_0x0008:
            com.mbridge.msdk.foundation.same.report.l$3 r0 = new com.mbridge.msdk.foundation.same.report.l$3     // Catch:{ all -> 0x001d }
            r0.<init>(r3)     // Catch:{ all -> 0x001d }
            com.mbridge.msdk.foundation.controller.c.a()     // Catch:{ all -> 0x001d }
            java.util.concurrent.Executor r3 = r2.l     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x0018
            r3.execute(r0)     // Catch:{ all -> 0x001d }
            goto L_0x001b
        L_0x0018:
            r0.run()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.l.a(java.lang.String):void");
    }

    private JSONObject b(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    jSONObject.put(split2[0], split2[1]);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    static /* synthetic */ void a(l lVar, ArrayList arrayList, long j2) {
        if (arrayList != null && arrayList.size() > 0) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("report_message", arrayList);
            bundle.putLong("last_report_time", j2);
            obtain.setData(bundle);
            obtain.what = 3;
            lVar.e.sendMessage(obtain);
        }
    }

    static /* synthetic */ void b(l lVar, final ArrayList arrayList, final long j2) {
        if (arrayList == null || arrayList.size() <= 0) {
            aa.a(a, "需要上报的数据条数： 0");
            return;
        }
        String str = a;
        aa.a(str, "需要上报的数据条数： " + arrayList.size());
        Context g2 = b.d().g();
        if (g2 != null) {
            com.mbridge.msdk.foundation.same.net.h.d a2 = q.a(g2);
            a2.a("app_id", b.d().h());
            a2.a("m_sdk", "msdk");
            a2.a("lqswt", String.valueOf(1));
            a2.a("device_type", com.mbridge.msdk.foundation.tools.w.s(g2) ? "pad" : "phone");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                a2.a(com.mbridge.msdk.foundation.same.net.h.d.d, com.mbridge.msdk.foundation.tools.w.s());
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                try {
                    BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i2);
                    if (batchReportMessage != null) {
                        sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                        if (i2 >= 0 && i2 < size - 1) {
                            sb.append("\n");
                        }
                    }
                    i2++;
                } catch (Throwable th) {
                    aa.d(a, th.getMessage());
                }
            }
            try {
                String encode = URLEncoder.encode(sb.toString(), "utf-8");
                a2.a("data", encode);
                String str2 = a;
                aa.a(str2, "需要批量上报的数据： " + encode);
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
                lVar.a(0, "");
                aVar.post(0, lVar.h, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.a(l.a, "批量上报成功");
                        l.this.a(1, "");
                        try {
                            if (l.this.i != null) {
                                l.this.i.deleteBatchReportMessagesByTimestamp(j2);
                            }
                        } catch (Exception e) {
                            aa.d(l.a, e.getMessage());
                        }
                        synchronized (l.this.k) {
                            l.this.k.clear();
                        }
                    }

                    public final void onFailed(String str) {
                        Stack e;
                        String c2 = l.a;
                        aa.a(c2, "批量上报失败： " + str);
                        l.this.a(2, str);
                        synchronized (l.this.k) {
                            l.this.k.add(Long.valueOf(j2));
                            if (l.this.i != null) {
                                l.this.i.updateMessagesReportState(arrayList);
                            }
                            if (l.this.k.size() >= 5) {
                                aa.a(l.a, "批量上报失败，上报失败的数据超过阈值");
                                try {
                                    l.this.k.pop();
                                    long longValue = ((Long) l.this.k.pop()).longValue();
                                    l.this.k.clear();
                                    if (l.this.i != null) {
                                        l.this.i.deleteBatchReportMessagesByTimestamp(longValue);
                                    }
                                    e = l.this.k;
                                } catch (Exception e2) {
                                    try {
                                        aa.d(l.a, e2.getMessage());
                                        e = l.this.k;
                                    } catch (Throwable th) {
                                        l.this.k.clear();
                                        throw th;
                                    }
                                }
                                e.clear();
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                aa.d(a, e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(l lVar, String str, long j2) {
        if (lVar.d != null) {
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("roas");
            eVar.a(true);
            if (j2 != 0) {
                eVar.a(j2);
            }
            eVar.b(1);
            try {
                eVar.a(lVar.b(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            lVar.d.a(eVar);
        }
    }

    static /* synthetic */ void a(l lVar, String str) {
        lVar.i.addReportMessage(str, 2);
        Handler handler = lVar.e;
        if (handler != null && !handler.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            lVar.e.sendMessageDelayed(obtain, lVar.g);
        }
        if (lVar.j.incrementAndGet() >= lVar.f && lVar.e != null) {
            Message obtain2 = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putLong("last_report_time", System.currentTimeMillis());
            obtain2.setData(bundle);
            obtain2.what = 2;
            lVar.e.sendMessage(obtain2);
            lVar.j.set(0);
        }
    }
}
