package com.bytedance.sdk.component.g;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PoolTaskStatistics */
public class d {
    public static final String[] a = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] b = {"tt_pangle", "bd_tracker"};
    private static AtomicInteger c = new AtomicInteger(0);
    private static int d = 0;
    private static int e = 0;

    public static void a() {
        try {
            b();
        } catch (Throwable unused) {
        }
    }

    private static void b() {
        String str;
        c i = f.i();
        if (i != null) {
            int i2 = 1;
            int addAndGet = c.addAndGet(1);
            if (f.c >= 0 && addAndGet % f.c == 0 && Looper.getMainLooper() != Looper.myLooper()) {
                Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                HashMap hashMap = new HashMap();
                if (allStackTraces != null) {
                    boolean a2 = l.a();
                    int size = allStackTraces.size();
                    if (size > e) {
                        e = size;
                    }
                    Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
                    int i3 = 0;
                    int i4 = 0;
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        i4 += i2;
                        Thread thread = (Thread) next.getKey();
                        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                        StringBuilder sb = new StringBuilder("\n");
                        if (a2) {
                            sb.append("Thread Name is : " + thread.getName());
                            sb.append("\n");
                        }
                        int length = stackTraceElementArr.length;
                        String str2 = null;
                        int i5 = 0;
                        while (i5 < length) {
                            String stackTraceElement = stackTraceElementArr[i5].toString();
                            Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                            if (a2) {
                                sb.append(stackTraceElement + "\n");
                            }
                            if (TextUtils.isEmpty(str2)) {
                                if (!a(stackTraceElement, a)) {
                                    str = stackTraceElement;
                                    if (!a(thread.getName(), b)) {
                                    }
                                } else {
                                    str = stackTraceElement;
                                }
                                i3++;
                                str2 = str;
                            }
                            i5++;
                            it = it2;
                        }
                        Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
                        if (a2) {
                            if (!TextUtils.isEmpty(str2)) {
                                String str3 = str2 + "&" + thread.getName();
                                a aVar = (a) hashMap.get(str3);
                                if (aVar != null) {
                                    aVar.a(aVar.a() + 1);
                                } else {
                                    aVar = new a(str3, 1, sb.toString(), thread.getName());
                                }
                                hashMap.put(str3, aVar);
                            }
                            if (!TextUtils.isEmpty(sb.toString())) {
                                Log.e("PoolTaskStatistics", "Thread index = " + i4 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                                Log.w("PoolTaskStatistics", sb.toString());
                            }
                        }
                        it = it3;
                        i2 = 1;
                    }
                    if (i3 > d) {
                        d = i3;
                    }
                    if (a2) {
                        Log.e("PoolTaskStatistics", "SDK current threads=" + i3 + ", SDK Max threads=" + d + ", Application threads = " + size + ", Application max threads = " + e);
                        for (Map.Entry value : hashMap.entrySet()) {
                            Log.i("PoolTaskStatistics", ((a) value.getValue()).toString());
                        }
                    }
                    i.a(new com.bytedance.sdk.component.g.b.a(i3, d, size, e));
                }
            }
        }
    }

    private static boolean a(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String contains : strArr) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* compiled from: PoolTaskStatistics */
    public static class a {
        public int a;
        public String b;
        public String c;
        public String d;

        public a(String str, int i, String str2, String str3) {
            this.c = str;
            this.a = i;
            this.d = str2;
            this.b = str3;
        }

        public void a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }

        public String toString() {
            return "ThreadModel{times=" + this.a + ", name='" + this.b + "', lastStackStack='" + this.c + "'}";
        }
    }
}
