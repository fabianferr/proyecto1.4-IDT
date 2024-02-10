package com.umlaut.crowd.internal;

public class s6 extends Thread {
    private static final int i = 80;
    private l2 a;
    private k2 b;
    t6 c;
    private String d = "";
    private ta[] e;
    private ta[] f;
    private va g;
    private va[] h;

    class a implements k2 {
        a() {
        }

        public void a(l2 l2Var) {
        }

        public void a(r5 r5Var, String str) {
        }

        public void a(t6 t6Var) {
        }

        public void a(z1 z1Var) {
        }

        public boolean a(ta[] taVarArr) {
            return true;
        }

        public boolean b(ta[] taVarArr) {
            return true;
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.w7$a[] r0 = com.umlaut.crowd.internal.w7.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_NO_FREE_SLOTS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_UNKNOWN_REQUEST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_REQUEST_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_INVALID_PARAMETER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_INVALID_SIGNATURE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.umlaut.crowd.internal.w7$a r1 = com.umlaut.crowd.internal.w7.a.FAIL_WRONG_CONNECTION     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.s6.b.<clinit>():void");
        }
    }

    public s6(t6 t6Var, k2 k2Var) {
        l2 l2Var = l2.NOT_STARTED;
        this.a = l2Var;
        this.c = t6Var;
        if (k2Var == null) {
            this.b = new a();
        } else {
            this.b = k2Var;
        }
    }

    private ua[] a(ta[] taVarArr) {
        ua[] uaVarArr = new ua[taVarArr.length];
        for (int i2 = 0; i2 < taVarArr.length; i2++) {
            uaVarArr[i2] = ua.a(taVarArr[i2].b());
        }
        return uaVarArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0136, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013f, code lost:
        throw r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090 A[Catch:{ all -> 0x0136 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r8 = this;
            java.lang.String r0 = "build RequestTestserverMessage failed"
            r8.d = r0
            com.umlaut.crowd.internal.t6 r0 = r8.c
            com.umlaut.crowd.internal.ta[] r0 = r0.d
            r1 = 0
            if (r0 == 0) goto L_0x0022
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0022
            com.umlaut.crowd.internal.f0 r0 = new com.umlaut.crowd.internal.f0
            r0.<init>()
            com.umlaut.crowd.internal.t6 r2 = r8.c
            java.lang.String r3 = r2.b
            r0.clientgroupid = r3
            com.umlaut.crowd.internal.ta[] r2 = r2.d
            com.umlaut.crowd.internal.ua[] r2 = r8.a((com.umlaut.crowd.internal.ta[]) r2)
            r0.requestedTests = r2
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            com.umlaut.crowd.internal.t6 r2 = r8.c
            com.umlaut.crowd.internal.ta[] r2 = r2.e
            if (r2 == 0) goto L_0x0040
            int r2 = r2.length
            if (r2 <= 0) goto L_0x0040
            com.umlaut.crowd.internal.f0 r2 = new com.umlaut.crowd.internal.f0
            r2.<init>()
            com.umlaut.crowd.internal.t6 r3 = r8.c
            java.lang.String r4 = r3.b
            r2.clientgroupid = r4
            com.umlaut.crowd.internal.ta[] r3 = r3.e
            com.umlaut.crowd.internal.ua[] r3 = r8.a((com.umlaut.crowd.internal.ta[]) r3)
            r2.requestedTests = r3
            goto L_0x0041
        L_0x0040:
            r2 = r1
        L_0x0041:
            java.lang.String r3 = "Connection to Controlserver failed"
            r8.d = r3
            com.umlaut.crowd.internal.t6 r3 = r8.c
            int r4 = r3.g
            r5 = 80
            if (r4 <= 0) goto L_0x004e
            goto L_0x0057
        L_0x004e:
            r3.g = r5
            com.umlaut.crowd.internal.k2 r4 = r8.b
            r4.a((com.umlaut.crowd.internal.t6) r3)
            r4 = 80
        L_0x0057:
            com.umlaut.crowd.internal.k2 r3 = r8.b
            com.umlaut.crowd.internal.z1 r6 = com.umlaut.crowd.internal.z1.CONTROL_CONNECTING
            r3.a((com.umlaut.crowd.internal.z1) r6)
            com.umlaut.crowd.internal.h1 r3 = new com.umlaut.crowd.internal.h1     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            com.umlaut.crowd.internal.t6 r6 = r8.c     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            java.lang.String r7 = r6.a     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            int r6 = r6.i     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            r3.<init>(r7, r4, r6)     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            boolean r4 = r3.g()     // Catch:{ all -> 0x0134 }
            if (r4 != 0) goto L_0x00a2
            com.umlaut.crowd.internal.t6 r4 = r8.c     // Catch:{ all -> 0x0134 }
            boolean r6 = r4.h     // Catch:{ all -> 0x0134 }
            if (r6 == 0) goto L_0x008d
            int r6 = r4.g     // Catch:{ all -> 0x0134 }
            if (r6 == r5) goto L_0x008d
            r4.g = r5     // Catch:{ all -> 0x0134 }
            r3.a((int) r5)     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.k2 r4 = r8.b     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.t6 r5 = r8.c     // Catch:{ all -> 0x0134 }
            r4.a((com.umlaut.crowd.internal.t6) r5)     // Catch:{ all -> 0x0134 }
            boolean r4 = r3.g()     // Catch:{ all -> 0x0134 }
            r5 = 1
            if (r4 != r5) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r5 = 0
        L_0x008e:
            if (r5 != 0) goto L_0x00a2
            com.umlaut.crowd.internal.k2 r0 = r8.b     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.CONNECTION_REFUSED     // Catch:{ all -> 0x0134 }
            java.lang.String r2 = r8.d     // Catch:{ all -> 0x0134 }
            r0.a(r1, r2)     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.n     // Catch:{ all -> 0x0134 }
            r8.a((com.umlaut.crowd.internal.l2) r0)     // Catch:{ all -> 0x0134 }
            r3.close()     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            return
        L_0x00a2:
            com.umlaut.crowd.internal.k2 r4 = r8.b     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.z1 r5 = com.umlaut.crowd.internal.z1.CONTROL_REQUEST     // Catch:{ all -> 0x0134 }
            r4.a((com.umlaut.crowd.internal.z1) r5)     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x00ea
            java.lang.String r4 = "Register Foreground Tests failed"
            r8.d = r4     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.u5 r0 = r3.a((com.umlaut.crowd.internal.s5) r0)     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x00dc
            com.umlaut.crowd.internal.v5 r4 = r0.c()     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.v5 r5 = com.umlaut.crowd.internal.v5.MESSAGETYPE_REQUEST_TESTSERVER     // Catch:{ all -> 0x0134 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0134 }
            if (r4 != 0) goto L_0x00c2
            goto L_0x00dc
        L_0x00c2:
            com.umlaut.crowd.internal.f0 r0 = (com.umlaut.crowd.internal.f0) r0     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.t6 r4 = r8.c     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ta[] r4 = r4.d     // Catch:{ all -> 0x0134 }
            r8.f = r4     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ua[] r0 = r0.requestedTests     // Catch:{ all -> 0x0134 }
            r8.a(r4, r0)     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.k2 r0 = r8.b     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ta[] r4 = r8.f     // Catch:{ all -> 0x0134 }
            boolean r0 = r0.a((com.umlaut.crowd.internal.ta[]) r4)     // Catch:{ all -> 0x0134 }
            if (r0 != 0) goto L_0x00ea
            r8.f = r1     // Catch:{ all -> 0x0134 }
            goto L_0x00ea
        L_0x00dc:
            com.umlaut.crowd.internal.w7 r0 = (com.umlaut.crowd.internal.w7) r0     // Catch:{ all -> 0x0134 }
            r8.a((com.umlaut.crowd.internal.w7) r0)     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.n     // Catch:{ all -> 0x0134 }
            r8.a((com.umlaut.crowd.internal.l2) r0)     // Catch:{ all -> 0x0134 }
            r3.close()     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            return
        L_0x00ea:
            if (r2 == 0) goto L_0x012b
            java.lang.String r0 = "Register Background Tests failed"
            r8.d = r0     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.u5 r0 = r3.a((com.umlaut.crowd.internal.s5) r2)     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x011d
            com.umlaut.crowd.internal.v5 r2 = r0.c()     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.v5 r4 = com.umlaut.crowd.internal.v5.MESSAGETYPE_REQUEST_TESTSERVER     // Catch:{ all -> 0x0134 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0134 }
            if (r2 != 0) goto L_0x0103
            goto L_0x011d
        L_0x0103:
            com.umlaut.crowd.internal.f0 r0 = (com.umlaut.crowd.internal.f0) r0     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.t6 r2 = r8.c     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ta[] r2 = r2.e     // Catch:{ all -> 0x0134 }
            r8.e = r2     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ua[] r0 = r0.requestedTests     // Catch:{ all -> 0x0134 }
            r8.a(r2, r0)     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.k2 r0 = r8.b     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ta[] r2 = r8.e     // Catch:{ all -> 0x0134 }
            boolean r0 = r0.a((com.umlaut.crowd.internal.ta[]) r2)     // Catch:{ all -> 0x0134 }
            if (r0 != 0) goto L_0x012b
            r8.e = r1     // Catch:{ all -> 0x0134 }
            goto L_0x012b
        L_0x011d:
            com.umlaut.crowd.internal.w7 r0 = (com.umlaut.crowd.internal.w7) r0     // Catch:{ all -> 0x0134 }
            r8.a((com.umlaut.crowd.internal.w7) r0)     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.n     // Catch:{ all -> 0x0134 }
            r8.a((com.umlaut.crowd.internal.l2) r0)     // Catch:{ all -> 0x0134 }
            r3.close()     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            return
        L_0x012b:
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.START_BACKGROUND_TESTS     // Catch:{ all -> 0x0134 }
            r8.a((com.umlaut.crowd.internal.l2) r0)     // Catch:{ all -> 0x0134 }
            r3.close()     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
            return
        L_0x0134:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0136 }
        L_0x0136:
            r1 = move-exception
            r3.close()     // Catch:{ all -> 0x013b }
            goto L_0x013f
        L_0x013b:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
        L_0x013f:
            throw r1     // Catch:{ UnknownHostException -> 0x015e, Exception -> 0x0140 }
        L_0x0140:
            r0 = move-exception
            boolean r0 = r0 instanceof java.io.IOException
            if (r0 == 0) goto L_0x014f
            com.umlaut.crowd.internal.k2 r0 = r8.b
            com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.IOEXCEPTION
            java.lang.String r2 = r8.d
            r0.a(r1, r2)
            goto L_0x0158
        L_0x014f:
            com.umlaut.crowd.internal.k2 r0 = r8.b
            com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNKNOWN
            java.lang.String r2 = r8.d
            r0.a(r1, r2)
        L_0x0158:
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.n
            r8.a((com.umlaut.crowd.internal.l2) r0)
            goto L_0x016c
        L_0x015e:
            com.umlaut.crowd.internal.k2 r0 = r8.b
            com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNKNOWN_HOST
            java.lang.String r2 = r8.d
            r0.a(r1, r2)
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.n
            r8.a((com.umlaut.crowd.internal.l2) r0)
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.s6.b():void");
    }

    private void c() {
        synchronized (this) {
            ta[] taVarArr = this.e;
            if (taVarArr != null && taVarArr.length > 0) {
                this.h = new va[taVarArr.length];
                int i2 = 0;
                while (true) {
                    va[] vaVarArr = this.h;
                    if (i2 >= vaVarArr.length) {
                        break;
                    }
                    vaVarArr[i2] = new va(this, this.e[i2], false);
                    this.h[i2].start();
                    i2++;
                }
            }
            a(l2.INIT_TEST);
        }
    }

    private void d() {
        ta[] taVarArr = this.f;
        if (taVarArr != null && taVarArr.length > 0) {
            int i2 = 0;
            while (i2 < this.f.length) {
                synchronized (this) {
                    l2 l2Var = this.a;
                    l2 l2Var2 = l2.INIT_TEST;
                    if (l2Var != l2Var2) {
                        a(l2Var2);
                    }
                    va vaVar = new va(this, this.f[i2], true);
                    this.g = vaVar;
                    vaVar.start();
                }
                try {
                    this.g.join();
                } catch (InterruptedException unused) {
                }
                if (!this.a.equals(l2.ABORTING) && !this.a.equals(l2.ABORTED)) {
                    i2++;
                } else {
                    return;
                }
            }
        }
        a(l2.WAIT_FOR_BACKGROUND_TESTS);
    }

    private void e() {
        ta[] taVarArr = this.e;
        if (taVarArr != null && taVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                va[] vaVarArr = this.h;
                if (i2 >= vaVarArr.length) {
                    break;
                }
                try {
                    vaVarArr[i2].join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                i2++;
            }
        }
        a(l2.END);
    }

    public void run() {
        try {
            a(l2.REQUEST_TESTSERVER);
            while (true) {
                l2 l2Var = this.a;
                l2 l2Var2 = l2.ABORTED;
                if (!l2Var.equals(l2Var2)) {
                    l2 l2Var3 = this.a;
                    l2 l2Var4 = l2.END;
                    if (l2Var3.equals(l2Var4)) {
                        return;
                    }
                    if (this.a.equals(l2.REQUEST_TESTSERVER)) {
                        b();
                    } else if (this.a.equals(l2.START_BACKGROUND_TESTS)) {
                        c();
                    } else if (this.a.equals(l2.INIT_TEST)) {
                        d();
                    } else if (this.a.equals(l2.WAIT_FOR_BACKGROUND_TESTS)) {
                        e();
                    } else if (!this.a.equals(l2.ABORTING) && !this.a.equals(l2Var2)) {
                        l2 l2Var5 = this.a;
                        l2 l2Var6 = l2.n;
                        if (l2Var5.equals(l2Var6)) {
                            return;
                        }
                        if (!this.a.equals(l2Var4)) {
                            this.b.a(r5.UNEXPECTED_ERROR, "Engine state unknown");
                            a(l2Var6);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            k2 k2Var = this.b;
            r5 r5Var = r5.UNEXPECTED_ERROR;
            k2Var.a(r5Var, this.d + " " + e2.getMessage());
            a(l2.n);
        }
    }

    private void a(ta[] taVarArr, ua[] uaVarArr) throws u9 {
        if (taVarArr.length == uaVarArr.length) {
            for (int i2 = 0; i2 < uaVarArr.length; i2++) {
                taVarArr[i2].a(uaVarArr[i2].msg);
            }
            return;
        }
        this.d = "Response from Server invalid";
        this.b.a(r5.INVALID_PARAMETER, "Response from Server invalid");
        a(l2.END);
        throw new u9(this.d);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.umlaut.crowd.internal.l2 r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.umlaut.crowd.internal.l2 r0 = r2.a     // Catch:{ all -> 0x0047 }
            com.umlaut.crowd.internal.l2 r1 = com.umlaut.crowd.internal.l2.n     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0029
            com.umlaut.crowd.internal.l2 r0 = r2.a     // Catch:{ all -> 0x0047 }
            com.umlaut.crowd.internal.l2 r1 = com.umlaut.crowd.internal.l2.ABORTING     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0029
            com.umlaut.crowd.internal.l2 r0 = r2.a     // Catch:{ all -> 0x0047 }
            com.umlaut.crowd.internal.l2 r1 = com.umlaut.crowd.internal.l2.ABORTED     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0029
            com.umlaut.crowd.internal.l2 r0 = r2.a     // Catch:{ all -> 0x0047 }
            com.umlaut.crowd.internal.l2 r1 = com.umlaut.crowd.internal.l2.END     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x003c
        L_0x0029:
            com.umlaut.crowd.internal.l2 r0 = r2.a     // Catch:{ all -> 0x0047 }
            com.umlaut.crowd.internal.l2 r1 = com.umlaut.crowd.internal.l2.ABORTING     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0045
            com.umlaut.crowd.internal.l2 r0 = com.umlaut.crowd.internal.l2.ABORTED     // Catch:{ all -> 0x0047 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x003c
            goto L_0x0045
        L_0x003c:
            r2.a = r3     // Catch:{ all -> 0x0047 }
            com.umlaut.crowd.internal.k2 r0 = r2.b     // Catch:{ all -> 0x0047 }
            r0.a((com.umlaut.crowd.internal.l2) r3)     // Catch:{ all -> 0x0047 }
            monitor-exit(r2)
            return
        L_0x0045:
            monitor-exit(r2)
            return
        L_0x0047:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.s6.a(com.umlaut.crowd.internal.l2):void");
    }

    public void a(w7 w7Var) {
        if (w7Var == null) {
            this.b.a(r5.CLOSED_BY_PEER, this.d);
            return;
        }
        switch (b.a[w7Var.fail.ordinal()]) {
            case 1:
                this.b.a(r5.UNEXPECTED_ERROR, this.d);
                return;
            case 2:
                this.b.a(r5.NO_FREE_SLOTS, this.d);
                return;
            case 3:
                this.b.a(r5.UNKNOWN_REQUEST, this.d);
                return;
            case 4:
                this.b.a(r5.REQUEST_FAILED, this.d);
                return;
            case 5:
                this.b.a(r5.INVALID_PARAMETER, this.d);
                return;
            case 6:
                this.b.a(r5.INVALID_SIGNATURE, this.d);
                return;
            case 7:
                this.b.a(r5.WRONG_CONNECTION, this.d);
                return;
            default:
                this.b.a(r5.UNEXPECTED_ANSWER, this.d);
                return;
        }
    }

    public void a() {
        int i2;
        a(l2.ABORTING);
        synchronized (this) {
            va vaVar = this.g;
            if (vaVar != null) {
                vaVar.a();
            }
            i2 = 0;
            if (this.h != null) {
                int i3 = 0;
                while (true) {
                    va[] vaVarArr = this.h;
                    if (i3 >= vaVarArr.length) {
                        break;
                    }
                    va vaVar2 = vaVarArr[i3];
                    if (vaVar2 != null) {
                        vaVar2.a();
                    }
                    i3++;
                }
            }
        }
        va vaVar3 = this.g;
        if (vaVar3 != null) {
            try {
                vaVar3.join();
            } catch (InterruptedException unused) {
            }
        }
        if (this.h != null) {
            while (true) {
                va[] vaVarArr2 = this.h;
                if (i2 >= vaVarArr2.length) {
                    break;
                }
                va vaVar4 = vaVarArr2[i2];
                if (vaVar4 != null) {
                    try {
                        vaVar4.join();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                i2++;
            }
        }
        a(l2.ABORTED);
    }
}
