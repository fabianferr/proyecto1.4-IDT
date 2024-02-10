package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.aa;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MBBatchReportManager */
public final class k {
    /* access modifiers changed from: private */
    public static final String a = "k";
    private static volatile k b;
    /* access modifiers changed from: private */
    public Handler c;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public int e = 30;
    /* access modifiers changed from: private */
    public long f = 5000;
    private String g = d.a().a;
    /* access modifiers changed from: private */
    public BatchReportDao h;
    /* access modifiers changed from: private */
    public AtomicInteger i;
    /* access modifiers changed from: private */
    public Stack<Long> j;
    private Executor k = Executors.newSingleThreadExecutor();

    private k() {
        e b2 = f.a().b(b.d().h());
        if (b2 != null) {
            this.e = b2.an();
            this.f = (long) (b2.ao() * 1000);
            this.d = b2.ap() != 1 ? false : true;
        }
        if (this.d) {
            this.i = new AtomicInteger(0);
            this.j = new Stack<>();
            this.h = BatchReportDao.getInstance(b.d().g());
            HandlerThread handlerThread = new HandlerThread("mb_batch_report_thread");
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper()) {
                public final void handleMessage(Message message) {
                    Bundle data;
                    int i = message.what;
                    if (i == 1) {
                        Bundle data2 = message.getData();
                        if (k.this.c != null && k.this.h != null && data2 != null) {
                            k.this.c.removeMessages(2);
                            long currentTimeMillis = System.currentTimeMillis();
                            k.a(k.this, k.this.h.getBatchReportMessages(currentTimeMillis, 1), currentTimeMillis);
                            k.this.i.set(0);
                        }
                    } else if (i == 2) {
                        Bundle data3 = message.getData();
                        if (k.this.c != null && k.this.h != null && data3 != null) {
                            k.this.c.removeMessages(1);
                            long j = data3.getLong("last_report_time");
                            k.a(k.this, k.this.h.getBatchReportMessages(j, 1), j);
                        }
                    } else if (i == 3 && (data = message.getData()) != null) {
                        k.b(k.this, data.getParcelableArrayList("report_message"), data.getLong("last_report_time"));
                    }
                }
            };
        }
    }

    public static k a() {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k();
                }
            }
        }
        return b;
    }

    public final void b() {
        Handler handler;
        if (this.d && (handler = this.c) != null && !handler.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.c.sendMessageDelayed(obtain, 5000);
        }
    }

    public final synchronized boolean c() {
        return this.d;
    }

    public final synchronized void a(final String str) {
        AnonymousClass3 r0 = new Runnable() {
            public final void run() {
                if (k.this.h != null && k.this.d) {
                    String d = k.a;
                    aa.a(d, "接收到上报数据： " + str);
                    k.this.h.addReportMessage(str, 1);
                    if (k.this.c != null && k.this.f > 0 && !k.this.c.hasMessages(1)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        k.this.c.sendMessageDelayed(obtain, k.this.f);
                    }
                    if (k.this.i.incrementAndGet() >= k.this.e && k.this.c != null) {
                        Message obtain2 = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putLong("last_report_time", System.currentTimeMillis());
                        obtain2.setData(bundle);
                        obtain2.what = 2;
                        k.this.c.sendMessage(obtain2);
                        k.this.i.set(0);
                    }
                }
            }
        };
        c.a();
        Executor executor = this.k;
        if (executor != null) {
            executor.execute(r0);
        } else {
            r0.run();
        }
    }

    static /* synthetic */ void a(k kVar, ArrayList arrayList, long j2) {
        if (arrayList != null && arrayList.size() > 0) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("report_message", arrayList);
            bundle.putLong("last_report_time", j2);
            obtain.setData(bundle);
            obtain.what = 3;
            kVar.c.sendMessage(obtain);
        }
    }

    static /* synthetic */ void b(k kVar, final ArrayList arrayList, final long j2) {
        Context g2;
        if (arrayList != null && arrayList.size() > 0 && (g2 = b.d().g()) != null) {
            com.mbridge.msdk.foundation.same.net.h.d a2 = q.a(g2);
            a2.a("app_id", b.d().h());
            a2.a("m_sdk", "msdk");
            a2.a("lqswt", String.valueOf(1));
            StringBuilder sb = new StringBuilder();
            e g3 = f.a().g(b.d().h());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i2);
                if (batchReportMessage != null) {
                    String reportMessage = batchReportMessage.getReportMessage();
                    if (!TextUtils.isEmpty(reportMessage) && !reportMessage.contains("&ts=")) {
                        reportMessage = reportMessage + "&ts=" + batchReportMessage.getTimestamp();
                    }
                    if (q.a(g3, reportMessage)) {
                        sb.append(reportMessage);
                        if (i2 >= 0 && i2 < arrayList.size() - 1) {
                            sb.append("\n");
                        }
                    }
                }
            }
            try {
                a2.a("data", URLEncoder.encode(sb.toString(), "utf-8"));
                new a(b.d().g()).post(0, kVar.g, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        try {
                            if (k.this.h != null) {
                                k.this.h.deleteBatchReportMessagesByTimestamp(j2);
                            }
                        } catch (Exception e) {
                            aa.d(k.a, e.getMessage());
                        }
                        synchronized (k.this.j) {
                            k.this.j.clear();
                        }
                    }

                    public final void onFailed(String str) {
                        Stack d;
                        synchronized (k.this.j) {
                            k.this.j.add(Long.valueOf(j2));
                            if (k.this.h != null) {
                                k.this.h.updateMessagesReportState(arrayList);
                            }
                            if (k.this.j.size() >= 5) {
                                try {
                                    k.this.j.pop();
                                    long longValue = ((Long) k.this.j.pop()).longValue();
                                    k.this.j.clear();
                                    if (k.this.h != null) {
                                        k.this.h.deleteBatchReportMessagesByTimestamp(longValue);
                                    }
                                    d = k.this.j;
                                } catch (Exception e) {
                                    try {
                                        aa.d(k.a, e.getMessage());
                                        d = k.this.j;
                                    } catch (Throwable th) {
                                        k.this.j.clear();
                                        throw th;
                                    }
                                }
                                d.clear();
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                aa.d(a, e2.getMessage());
            }
        }
    }
}
