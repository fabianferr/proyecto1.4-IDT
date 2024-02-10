package com.startapp.sdk.adsbase.crashreport;

import android.os.Looper;
import java.io.Serializable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: Sta */
public class ThreadsState implements Serializable {
    private static final long serialVersionUID = -4777916407910409315L;
    public final transient String a;
    public final transient boolean b;
    public final transient boolean c;
    public final transient Set<String> d;
    private final long delay;
    private final String handlerDescription;
    private Map<String, ShrunkStackTraceElement[]> threadsStackTraces;

    /* compiled from: Sta */
    public static class MainThreadComparator implements Comparator<String>, Serializable {
        public final transient String a;

        private MainThreadComparator() {
            this.a = Looper.getMainLooper().getThread().getName();
        }

        public int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            if (str.startsWith(this.a)) {
                return -1;
            }
            if (str2.startsWith(this.a)) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: Sta */
    public static class ShrunkStackTraceElement implements Serializable {
        private static final long serialVersionUID = -7615438011343681512L;
        private final long skipBeforeAmount;
        private final StackTraceElement stackTraceElement;

        public ShrunkStackTraceElement(long j, StackTraceElement stackTraceElement2) {
            this.skipBeforeAmount = j;
            this.stackTraceElement = stackTraceElement2;
        }

        public long a() {
            return this.skipBeforeAmount;
        }

        public StackTraceElement b() {
            return this.stackTraceElement;
        }
    }

    /* compiled from: Sta */
    public static class b {
        public String a;
        public String b;
        public Set<String> c;
        public long d;
        public boolean e;
        public boolean f;
    }

    public ThreadsState(b bVar) {
        this.a = bVar.a;
        this.b = bVar.e;
        this.c = bVar.f;
        this.delay = bVar.d;
        this.handlerDescription = bVar.b;
        this.d = bVar.c;
        a();
    }

    public final void a() {
        Thread thread = Looper.getMainLooper().getThread();
        String a2 = a(thread);
        TreeMap treeMap = new TreeMap(new MainThreadComparator());
        boolean z = false;
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            Thread thread2 = (Thread) next.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
            if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                ShrunkStackTraceElement[] b2 = b(stackTraceElementArr);
                if (b2 != null && b2.length > 0) {
                    Thread.State state = thread2.getState();
                    if (thread2 == thread) {
                        if (!a(stackTraceElementArr)) {
                            treeMap.put(a2, b2);
                            z = true;
                        } else {
                            return;
                        }
                    } else if (!this.c || state == Thread.State.BLOCKED || state == Thread.State.WAITING) {
                        treeMap.put(a(thread2), b2);
                    }
                } else if (thread2 == thread) {
                    return;
                }
            } else if (thread2 == thread) {
                return;
            }
        }
        if (!z) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            ShrunkStackTraceElement[] b3 = b(stackTrace);
            if (b3 != null && b3.length > 0 && !a(stackTrace)) {
                treeMap.put(a2, b3);
            } else {
                return;
            }
        }
        this.threadsStackTraces = treeMap;
    }

    public long b() {
        return this.delay;
    }

    public String c() {
        return this.handlerDescription;
    }

    public Map<String, ShrunkStackTraceElement[]> d() {
        return this.threadsStackTraces;
    }

    public final ShrunkStackTraceElement[] b(StackTraceElement[] stackTraceElementArr) {
        ShrunkStackTraceElement[] shrunkStackTraceElementArr;
        String className;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        StackTraceElement stackTraceElement = null;
        long j = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < stackTraceElementArr2.length) {
            StackTraceElement stackTraceElement2 = stackTraceElementArr2[i];
            if (stackTraceElement2 != null && (className = stackTraceElement2.getClassName()) != null) {
                boolean z3 = i < 3;
                String str = this.a;
                boolean z4 = str == null || className.startsWith(str);
                if (z4) {
                    z = true;
                }
                if (!this.b || z4 || z3 || z2) {
                    if (stackTraceElement != null) {
                        arrayList.add(new ShrunkStackTraceElement(j, stackTraceElement));
                        stackTraceElement = null;
                        j = 0;
                    }
                    arrayList.add(new ShrunkStackTraceElement(0, stackTraceElement2));
                } else {
                    if (stackTraceElement != null) {
                        j++;
                    }
                    stackTraceElement = stackTraceElement2;
                }
                z2 = z4;
            }
            i++;
        }
        if (stackTraceElement != null) {
            shrunkStackTraceElementArr = null;
            arrayList.add(new ShrunkStackTraceElement(j + 1, (StackTraceElement) null));
        } else {
            shrunkStackTraceElementArr = null;
        }
        return z ? (ShrunkStackTraceElement[]) arrayList.toArray(new ShrunkStackTraceElement[0]) : shrunkStackTraceElementArr;
    }

    public final boolean a(StackTraceElement[] stackTraceElementArr) {
        if (this.d == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (!(className == null || methodName == null)) {
                if (this.d.contains(className + '.' + methodName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }
}
