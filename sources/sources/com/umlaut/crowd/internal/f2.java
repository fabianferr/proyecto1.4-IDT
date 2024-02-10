package com.umlaut.crowd.internal;

import android.os.SystemClock;
import android.util.Log;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.threads.ThreadManager;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class f2 {
    private static final String e = "f2";
    private static final boolean f = false;
    private final int a;
    private final String[] b;
    private final String[] c;
    private final HashMap<String, g2> d;

    class a implements Callable<g2> {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* renamed from: a */
        public g2 call() throws UnknownHostException {
            g2 a2;
            if (!InsightCore.getInsightConfig().v0() || (a2 = f2.this.a(this.a, this.b / 2)) == null || !a2.h()) {
                return f2.this.a(this.a);
            }
            return a2;
        }
    }

    private static final class b {
        static final f2 a = new f2((a) null);

        private b() {
        }
    }

    /* synthetic */ f2(a aVar) {
        this();
    }

    public String b(String str, int i) throws UnknownHostException {
        return b(str, i, true);
    }

    private f2() {
        this.d = new HashMap<>();
        this.a = InsightCore.getInsightConfig().u0();
        this.b = InsightCore.getInsightConfig().G0();
        this.c = InsightCore.getInsightConfig().H0();
    }

    public String b(String str, int i, boolean z) throws UnknownHostException {
        return a(str, i, z).c();
    }

    public static f2 a() {
        return b.a;
    }

    public g2 a(String str, int i, boolean z) throws UnknownHostException {
        g2 g2Var;
        if (h2.a(str)) {
            return a(str);
        }
        synchronized (this.d) {
            Iterator<Map.Entry<String, g2>> it = this.d.entrySet().iterator();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            while (it.hasNext()) {
                if (((g2) it.next().getValue()).f() < elapsedRealtime - ((long) this.a)) {
                    it.remove();
                }
            }
        }
        Exception exc = null;
        if (z) {
            synchronized (this.d) {
                g2Var = this.d.get(str);
            }
            if (g2Var != null && g2Var.h()) {
                g2Var.a(tb.Yes);
                g2Var.a(0);
                return g2Var;
            }
        } else {
            g2Var = null;
        }
        try {
            g2Var = (g2) ThreadManager.getInstance().getCachedThreadPool().submit(new a(str, i)).get((long) i, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            exc = e2;
            Log.d(e, "resolveHostname: " + exc);
        }
        if (g2Var != null && g2Var.h()) {
            synchronized (this.d) {
                this.d.put(str, g2Var);
            }
            return g2Var;
        } else if (exc != null) {
            throw new UnknownHostException(exc.getMessage());
        } else {
            throw new UnknownHostException();
        }
    }

    /* access modifiers changed from: private */
    public g2 a(String str) throws UnknownHostException {
        return h2.b(str);
    }

    /* access modifiers changed from: private */
    public g2 a(String str, int i) {
        return h2.a(this.b, this.c, str, i, InsightCore.getRadioController().m());
    }
}
