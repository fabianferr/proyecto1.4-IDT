package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: GeckoConfig */
public class b {
    private static ThreadPoolExecutor s;
    public final Context a;
    public final Executor b;
    final Executor c;
    final com.bykv.vk.openvk.preload.geckox.j.a d;
    public final IStatisticMonitor e;
    public final INetWork f;
    public final List<String> g;
    public final List<String> h;
    final com.bykv.vk.openvk.preload.geckox.a.a.a i;
    public final Long j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final File p;
    public final boolean q;
    public JSONObject r;

    /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    private b(a aVar) {
        Context context = aVar.d;
        this.a = context;
        if (context != null) {
            List<String> list = aVar.b;
            this.g = list;
            this.h = aVar.c;
            this.d = aVar.g;
            this.i = aVar.j;
            Long l2 = aVar.k;
            this.j = l2;
            if (TextUtils.isEmpty(aVar.l)) {
                this.k = com.bykv.vk.openvk.preload.geckox.utils.a.a(context);
            } else {
                this.k = aVar.l;
            }
            String str = aVar.m;
            this.l = str;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o == null) {
                this.p = new File(context.getFilesDir(), "gecko_offline_res_x");
            } else {
                this.p = aVar.o;
            }
            String str2 = aVar.n;
            this.m = str2;
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("host == null");
            } else if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("access key empty");
            } else if (l2 == null) {
                throw new IllegalArgumentException("appId == null");
            } else if (!TextUtils.isEmpty(str)) {
                if (aVar.e == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("csj_gecko_update");
                            thread.setPriority(3);
                            return thread;
                        }
                    });
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.b = threadPoolExecutor;
                } else {
                    this.b = aVar.e;
                }
                if (aVar.f == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("csj_gecko_check_update");
                            thread.setPriority(3);
                            return thread;
                        }
                    });
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                    this.c = threadPoolExecutor2;
                } else {
                    this.c = aVar.f;
                }
                this.f = aVar.a;
                this.e = aVar.h;
                this.q = aVar.i;
            } else {
                throw new IllegalArgumentException("deviceId key empty");
            }
        } else {
            throw new IllegalArgumentException("context == null");
        }
    }

    public static ThreadPoolExecutor a() {
        if (s == null) {
            synchronized (b.class) {
                if (s == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    s = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return s;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        s = threadPoolExecutor;
    }

    /* compiled from: GeckoConfig */
    public static class a {
        INetWork a;
        List<String> b;
        List<String> c;
        Context d;
        Executor e;
        Executor f;
        com.bykv.vk.openvk.preload.geckox.j.a g;
        IStatisticMonitor h;
        boolean i = true;
        com.bykv.vk.openvk.preload.geckox.a.a.a j;
        Long k;
        String l;
        String m;
        String n;
        File o;
        String p;
        String q;

        public a(Context context) {
            this.d = context.getApplicationContext();
        }
    }
}
