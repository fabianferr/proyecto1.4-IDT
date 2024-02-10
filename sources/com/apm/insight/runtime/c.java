package com.apm.insight.runtime;

import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class c {
    private final List<ICrashCallback> a = new CopyOnWriteArrayList();
    private final List<ICrashCallback> b = new CopyOnWriteArrayList();
    private final List<ICrashCallback> c = new CopyOnWriteArrayList();
    private final List<ICrashCallback> d = new CopyOnWriteArrayList();
    private final List<IOOMCallback> e = new CopyOnWriteArrayList();

    /* renamed from: com.apm.insight.runtime.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.apm.insight.CrashType[] r0 = com.apm.insight.CrashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.ANR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.JAVA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.LAUNCH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.apm.insight.CrashType r1 = com.apm.insight.CrashType.NATIVE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.c.AnonymousClass1.<clinit>():void");
        }
    }

    public List<IOOMCallback> a() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void a(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = AnonymousClass1.a[crashType.ordinal()];
        if (i == 1) {
            this.a.add(iCrashCallback);
            this.b.add(iCrashCallback);
            this.c.add(iCrashCallback);
        } else if (i != 2) {
            if (i == 3) {
                list = this.b;
            } else if (i == 4) {
                list = this.a;
            } else if (i == 5) {
                list = this.c;
            } else {
                return;
            }
            list.add(iCrashCallback);
        }
        list = this.d;
        list.add(iCrashCallback);
    }

    /* access modifiers changed from: package-private */
    public void a(IOOMCallback iOOMCallback) {
        this.e.add(iOOMCallback);
    }

    public List<ICrashCallback> b() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void b(ICrashCallback iCrashCallback, CrashType crashType) {
        List<ICrashCallback> list;
        int i = AnonymousClass1.a[crashType.ordinal()];
        if (i == 1) {
            this.a.remove(iCrashCallback);
            this.b.remove(iCrashCallback);
            this.c.remove(iCrashCallback);
        } else if (i != 2) {
            if (i == 3) {
                list = this.b;
            } else if (i == 4) {
                list = this.a;
            } else if (i == 5) {
                list = this.c;
            } else {
                return;
            }
            list.remove(iCrashCallback);
        }
        list = this.d;
        list.remove(iCrashCallback);
    }

    /* access modifiers changed from: package-private */
    public void b(IOOMCallback iOOMCallback) {
        this.e.remove(iOOMCallback);
    }

    public List<ICrashCallback> c() {
        return this.b;
    }

    public List<ICrashCallback> d() {
        return this.c;
    }

    public List<ICrashCallback> e() {
        return this.d;
    }
}
