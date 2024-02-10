package com.ironsource.mediationsdk.events;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ironsource.b.c;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.model.r;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b implements c {
    private int A = 90000;
    private int B = 1024;
    private int C = 5;
    private String D = "supersonic_sdk.db";
    private String E = IronSourceConstants.EVENTS_PROVIDER;
    private String F = "placement";
    private final String G = "abt";
    private final String H = "mt";
    private a I;
    private int J = 5000;
    private int[] K;
    private Map<String, String> L = new HashMap();
    private r M;
    private final Object N = new Object();
    public boolean a;
    boolean b = false;
    public boolean c = false;
    public int d = -1;
    com.ironsource.b.a e;
    ArrayList<com.ironsource.environment.c.a> f;
    public boolean g = true;
    int h;
    String i;
    Context j;
    int k = 100;
    int l = 1;
    int[] m;
    int[] n;
    int[] o;
    Map<String, String> p = new HashMap();
    public String q = "";
    int r;
    String s;
    String t;
    Set<Integer> u;
    C0112b v;
    public IronSourceSegment w;
    private int x = 1;
    private int y = 100;
    private int z = 5000;

    public enum a {
        NOT_SUPPORTED(-1),
        OFFERWALL(1),
        INTERSTITIAL(2),
        REWARDED_VIDEO(3),
        NATIVE_AD(4),
        BANNER(8);
        
        int g;

        private a(int i) {
            this.g = i;
        }
    }

    /* renamed from: com.ironsource.mediationsdk.events.b$b  reason: collision with other inner class name */
    class C0112b extends HandlerThread {
        Handler a;

        C0112b(String str) {
            super(str);
        }

        /* access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    static int a(int i2, IronSource.AD_UNIT ad_unit) {
        a aVar;
        int i3 = a.NOT_SUPPORTED.g;
        if (ad_unit == IronSource.AD_UNIT.OFFERWALL || i2 == 15 || (i2 >= 300 && i2 < 400)) {
            aVar = a.OFFERWALL;
        } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO || ((i2 >= 1000 && i2 < 2000) || (i2 >= 91000 && i2 < 92000))) {
            aVar = a.REWARDED_VIDEO;
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL || ((i2 >= 2000 && i2 < 3000) || (i2 >= 92000 && i2 < 93000))) {
            aVar = a.INTERSTITIAL;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER || ((i2 >= 3000 && i2 < 4000) || (i2 >= 93000 && i2 < 94000))) {
            aVar = a.BANNER;
        } else if (ad_unit != IronSource.AD_UNIT.NATIVE_AD && ((i2 < 4000 || i2 >= 5000) && (i2 < 94000 || i2 >= 95000))) {
            return i3;
        } else {
            aVar = a.NATIVE_AD;
        }
        return aVar.g;
    }

    static /* synthetic */ void a(b bVar) {
        synchronized (bVar.N) {
            bVar.e.a(bVar.f, bVar.t);
            bVar.f.clear();
        }
    }

    static /* synthetic */ void a(b bVar, com.ironsource.environment.c.a aVar, String str) {
        JSONObject d2 = aVar.d();
        if (d2 != null && d2.has(str)) {
            try {
                String optString = d2.optString(str, (String) null);
                if (optString != null) {
                    aVar.a(str, optString.substring(0, Math.min(optString.length(), 1024)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(String str) {
        a aVar = this.I;
        if (aVar == null || !aVar.c().equals(str)) {
            this.I = d.a(str, this.r);
        }
    }

    public static void a(Map<String, Object> map, int i2, String str) {
        map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put(IronSourceConstants.AUCTION_FALLBACK, str);
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            IronSourceSegment ironSourceSegment = this.w;
            if (ironSourceSegment != null) {
                if (ironSourceSegment.getAge() > 0) {
                    jSONObject.put(IronSourceSegment.AGE, this.w.getAge());
                }
                if (!TextUtils.isEmpty(this.w.getGender())) {
                    jSONObject.put(IronSourceSegment.GENDER, this.w.getGender());
                }
                if (this.w.getLevel() > 0) {
                    jSONObject.put(IronSourceSegment.LEVEL, this.w.getLevel());
                }
                if (this.w.getIsPaying() != null) {
                    jSONObject.put(IronSourceSegment.PAYING, this.w.getIsPaying().get());
                }
                if (this.w.getIapt() > 0.0d) {
                    jSONObject.put(IronSourceSegment.IAPT, this.w.getIapt());
                }
                if (this.w.getUcd() > 0) {
                    jSONObject.put(IronSourceSegment.USER_CREATION_DATE, this.w.getUcd());
                }
            }
            r rVar = this.M;
            if (rVar != null) {
                String str = rVar.b;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("segmentId", str);
                }
                JSONObject jSONObject2 = this.M.c;
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    static boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:48|(2:50|51)|52|53|64) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0126 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.ironsource.mediationsdk.events.b r7) {
        /*
            r0 = 0
            r7.b = r0     // Catch:{ all -> 0x013c }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x013c }
            r1.<init>()     // Catch:{ all -> 0x013c }
            java.lang.Object r2 = r7.N     // Catch:{ all -> 0x003f }
            monitor-enter(r2)     // Catch:{ all -> 0x003f }
            com.ironsource.b.a r3 = r7.e     // Catch:{ all -> 0x003c }
            java.lang.String r4 = r7.t     // Catch:{ all -> 0x003c }
            java.util.ArrayList r3 = r3.a((java.lang.String) r4)     // Catch:{ all -> 0x003c }
            com.ironsource.b.a r4 = r7.e     // Catch:{ all -> 0x003c }
            java.lang.String r5 = r7.t     // Catch:{ all -> 0x003c }
            r4.b(r5)     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            com.ironsource.mediationsdk.events.c$b r2 = new com.ironsource.mediationsdk.events.c$b     // Catch:{ all -> 0x003f }
            com.ironsource.mediationsdk.events.c$a r4 = new com.ironsource.mediationsdk.events.c$a     // Catch:{ all -> 0x003f }
            java.util.ArrayList<com.ironsource.environment.c.a> r5 = r7.f     // Catch:{ all -> 0x003f }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x003f }
            int r3 = r7.J     // Catch:{ all -> 0x003f }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x003f }
            com.ironsource.b.a r3 = r7.e     // Catch:{ all -> 0x003f }
            java.util.List r4 = r2.c()     // Catch:{ all -> 0x003f }
            java.lang.String r5 = r7.t     // Catch:{ all -> 0x003f }
            r3.a(r4, r5)     // Catch:{ all -> 0x003f }
            java.util.List r2 = r2.b()     // Catch:{ all -> 0x003f }
            r1.addAll(r2)     // Catch:{ all -> 0x003f }
            goto L_0x005f
        L_0x003c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r3     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x013c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            java.lang.String r5 = "CombinedEventList exception: "
            r4.<init>(r5)     // Catch:{ all -> 0x013c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x013c }
            r4.append(r2)     // Catch:{ all -> 0x013c }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x013c }
            r3.error(r2)     // Catch:{ all -> 0x013c }
            r1.clear()     // Catch:{ all -> 0x013c }
            java.util.ArrayList<com.ironsource.environment.c.a> r2 = r7.f     // Catch:{ all -> 0x013c }
            r1.addAll(r2)     // Catch:{ all -> 0x013c }
        L_0x005f:
            int r2 = r1.size()     // Catch:{ all -> 0x013c }
            if (r2 <= 0) goto L_0x013b
            java.util.ArrayList<com.ironsource.environment.c.a> r2 = r7.f     // Catch:{ all -> 0x013c }
            r2.clear()     // Catch:{ all -> 0x013c }
            r7.h = r0     // Catch:{ all -> 0x013c }
            com.ironsource.mediationsdk.sdk.c r2 = com.ironsource.mediationsdk.sdk.c.a()     // Catch:{ all -> 0x013c }
            org.json.JSONObject r2 = r2.b()     // Catch:{ all -> 0x013c }
            r7.a((org.json.JSONObject) r2)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r7.q     // Catch:{ all -> 0x00ec }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x0084
            java.lang.String r4 = "abt"
            r2.put(r4, r3)     // Catch:{ all -> 0x00ec }
        L_0x0084:
            com.ironsource.mediationsdk.z r3 = com.ironsource.mediationsdk.z.a()     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r3.k     // Catch:{ all -> 0x00ec }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x0095
            java.lang.String r4 = "mt"
            r2.put(r4, r3)     // Catch:{ all -> 0x00ec }
        L_0x0095:
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.L     // Catch:{ all -> 0x00ec }
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x00cb
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x00ec }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00ec }
        L_0x00a5:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x00cb
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00ec }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00ec }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00ec }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00ec }
            boolean r5 = r2.has(r5)     // Catch:{ all -> 0x00ec }
            if (r5 != 0) goto L_0x00a5
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00ec }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00ec }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x00ec }
            r2.put(r5, r4)     // Catch:{ all -> 0x00ec }
            goto L_0x00a5
        L_0x00cb:
            com.ironsource.environment.b.b r3 = new com.ironsource.environment.b.b     // Catch:{ all -> 0x00ec }
            r3.<init>()     // Catch:{ all -> 0x00ec }
            org.json.JSONObject r3 = r3.a()     // Catch:{ all -> 0x00ec }
            java.util.Iterator r4 = r3.keys()     // Catch:{ all -> 0x00ec }
        L_0x00d8:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00ec }
            if (r5 == 0) goto L_0x0104
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00ec }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00ec }
            java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x00ec }
            r2.put(r5, r6)     // Catch:{ all -> 0x00ec }
            goto L_0x00d8
        L_0x00ec:
            r3 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x013c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            java.lang.String r6 = "Exception while building the event general properties: "
            r5.<init>(r6)     // Catch:{ all -> 0x013c }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x013c }
            r5.append(r3)     // Catch:{ all -> 0x013c }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x013c }
            r4.error(r3)     // Catch:{ all -> 0x013c }
        L_0x0104:
            com.ironsource.mediationsdk.events.a r3 = r7.I     // Catch:{ all -> 0x013c }
            java.lang.String r2 = r3.a(r1, r2)     // Catch:{ all -> 0x013c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x013c }
            if (r3 == 0) goto L_0x0118
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x013c }
            java.lang.String r0 = "Failed to parse events."
            r7.error(r0)     // Catch:{ all -> 0x013c }
            return
        L_0x0118:
            boolean r3 = r7.c     // Catch:{ all -> 0x013c }
            if (r3 == 0) goto L_0x0126
            int r3 = r7.d     // Catch:{ Exception -> 0x0126 }
            byte[] r3 = com.ironsource.mediationsdk.utils.g.a(r2, r3)     // Catch:{ Exception -> 0x0126 }
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r0)     // Catch:{ Exception -> 0x0126 }
        L_0x0126:
            com.ironsource.b.b r0 = new com.ironsource.b.b     // Catch:{ all -> 0x013c }
            com.ironsource.mediationsdk.events.b$3 r3 = new com.ironsource.mediationsdk.events.b$3     // Catch:{ all -> 0x013c }
            r3.<init>()     // Catch:{ all -> 0x013c }
            com.ironsource.mediationsdk.events.a r7 = r7.I     // Catch:{ all -> 0x013c }
            java.lang.String r7 = r7.a()     // Catch:{ all -> 0x013c }
            r0.<init>(r3, r2, r7, r1)     // Catch:{ all -> 0x013c }
            com.ironsource.environment.thread.IronSourceThreadManager r7 = com.ironsource.environment.thread.IronSourceThreadManager.INSTANCE     // Catch:{ all -> 0x013c }
            r7.postMediationBackgroundTask(r0)     // Catch:{ all -> 0x013c }
        L_0x013b:
            return
        L_0x013c:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Send event exception: "
            r1.<init>(r2)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.error(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.events.b.b(com.ironsource.mediationsdk.events.b):void");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f = new ArrayList<>();
        this.h = 0;
        this.I = d.a(this.s, this.r);
        C0112b bVar = new C0112b(this.t + "EventThread");
        this.v = bVar;
        bVar.start();
        C0112b bVar2 = this.v;
        bVar2.a = new Handler(bVar2.getLooper());
        this.i = IronSourceUtils.getSessionId();
        this.u = new HashSet();
        c();
    }

    public final void a(int i2) {
        if (i2 > 0) {
            this.l = i2;
        }
    }

    public final synchronized void a(Context context, IronSourceSegment ironSourceSegment) {
        String defaultEventsFormatterType = IronSourceUtils.getDefaultEventsFormatterType(context, this.t, this.s);
        this.s = defaultEventsFormatterType;
        a(defaultEventsFormatterType);
        this.I.c = IronSourceUtils.getDefaultEventsURL(context, this.t, (String) null);
        this.e = com.ironsource.b.a.a(context, "supersonic_sdk.db", 5);
        this.v.a(new Runnable() {
            public final void run() {
                b.a(b.this);
            }
        });
        this.m = IronSourceUtils.getDefaultOptOutEvents(context, this.t);
        this.n = IronSourceUtils.getDefaultOptInEvents(context, this.t);
        this.o = IronSourceUtils.getDefaultTriggerEvents(context, this.t);
        this.K = IronSourceUtils.getDefaultNonConnectivityEvents(context, this.t);
        this.w = ironSourceSegment;
        this.j = context;
    }

    public final synchronized void a(com.ironsource.environment.c.a aVar) {
        a(aVar, (IronSource.AD_UNIT) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final com.ironsource.environment.c.a r3, final com.ironsource.mediationsdk.IronSource.AD_UNIT r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x0017
            boolean r0 = r2.g     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0008
            goto L_0x0017
        L_0x0008:
            com.ironsource.mediationsdk.events.b$b r0 = r2.v     // Catch:{ all -> 0x0014 }
            com.ironsource.mediationsdk.events.b$2 r1 = new com.ironsource.mediationsdk.events.b$2     // Catch:{ all -> 0x0014 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0014 }
            r0.a(r1)     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)
            return
        L_0x0014:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0017:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.events.b.a(com.ironsource.environment.c.a, com.ironsource.mediationsdk.IronSource$AD_UNIT):void");
    }

    public final synchronized void a(r rVar) {
        this.M = rVar;
    }

    public final void a(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = this.I;
            if (aVar != null) {
                aVar.c = str;
            }
            IronSourceUtils.saveDefaultEventsURL(context, this.t, str);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ArrayList<com.ironsource.environment.c.a> arrayList) {
        if (arrayList != null) {
            synchronized (this.N) {
                this.e.a(arrayList, this.t);
                this.h = this.e.a(this.t).size() + this.f.size();
            }
        }
    }

    public final void a(Map<String, String> map) {
        this.L.putAll(map);
    }

    public final void a(int[] iArr, Context context) {
        this.m = iArr;
        IronSourceUtils.saveDefaultOptOutEvents(context, this.t, iArr);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int[] iArr) {
        if (!a(iArr)) {
            return false;
        }
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return a(r1.K) ? a(r3.a(), r1.K) : r1.u.contains(java.lang.Integer.valueOf(r3.a()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.lang.String r2, com.ironsource.environment.c.a r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "none"
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x000c
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x000c:
            int[] r2 = r1.K     // Catch:{ all -> 0x002f }
            boolean r2 = a((int[]) r2)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x001f
            int r2 = r3.a()     // Catch:{ all -> 0x002f }
            int[] r3 = r1.K     // Catch:{ all -> 0x002f }
            boolean r2 = r1.a((int) r2, (int[]) r3)     // Catch:{ all -> 0x002f }
            goto L_0x002d
        L_0x001f:
            java.util.Set<java.lang.Integer> r2 = r1.u     // Catch:{ all -> 0x002f }
            int r3 = r3.a()     // Catch:{ all -> 0x002f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x002f }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r1)
            return r2
        L_0x002f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.events.b.a(java.lang.String, com.ironsource.environment.c.a):boolean");
    }

    /* access modifiers changed from: package-private */
    public synchronized int b(com.ironsource.environment.c.a aVar) {
        return aVar.a() + 90000;
    }

    public final void b() {
        this.v.a(new Runnable() {
            public final void run() {
                b.b(b.this);
            }
        });
    }

    public final void b(int i2) {
        if (i2 > 0) {
            this.k = i2;
        }
    }

    public final void b(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            this.s = str;
            IronSourceUtils.saveDefaultEventsFormatterType(context, this.t, str);
            a(str);
        }
    }

    public final void b(Map<String, String> map) {
        this.p.putAll(map);
    }

    public final void b(int[] iArr, Context context) {
        this.n = iArr;
        IronSourceUtils.saveDefaultOptInEvents(context, this.t, iArr);
    }

    /* access modifiers changed from: package-private */
    public abstract void c();

    public final void c(int i2) {
        if (i2 > 0) {
            this.J = i2;
        }
    }

    public final void c(int[] iArr, Context context) {
        this.o = iArr;
        IronSourceUtils.saveDefaultTriggerEvents(context, this.t, iArr);
    }

    /* access modifiers changed from: protected */
    public abstract boolean c(com.ironsource.environment.c.a aVar);

    /* access modifiers changed from: protected */
    public abstract String d(int i2);

    public final void d(int[] iArr, Context context) {
        this.K = iArr;
        IronSourceUtils.saveDefaultNonConnectivityEvents(context, this.t, iArr);
    }

    /* access modifiers changed from: protected */
    public abstract boolean d(com.ironsource.environment.c.a aVar);

    /* access modifiers changed from: protected */
    public abstract int e(com.ironsource.environment.c.a aVar);

    /* access modifiers changed from: protected */
    public boolean f(com.ironsource.environment.c.a aVar) {
        return (aVar.a() == 14 || aVar.a() == 114 || aVar.a() == 514 || aVar.a() == 140 || aVar.a() == 40 || aVar.a() == 41 || aVar.a() == 50 || aVar.a() == 51 || aVar.a() == 52) ? false : true;
    }

    /* access modifiers changed from: protected */
    public boolean g(com.ironsource.environment.c.a aVar) {
        return (aVar.a() == 40 || aVar.a() == 41 || aVar.a() == 50 || aVar.a() == 51 || aVar.a() == 52) ? false : true;
    }
}
