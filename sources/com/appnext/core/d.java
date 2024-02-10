package com.appnext.core;

import android.accounts.AccountManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class d {
    private Context aM;
    protected final int ce = 0;
    protected final int cf = 1;
    protected final int cg = 2;
    protected final int ch = 3;
    /* access modifiers changed from: private */
    public final HashMap<b, a> ci = new HashMap<>();

    public interface a {
        <T> void a(T t);

        void error(String str);
    }

    /* access modifiers changed from: protected */
    public abstract int a(Context context, h hVar);

    /* access modifiers changed from: protected */
    public abstract String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList);

    /* access modifiers changed from: protected */
    public abstract void a(Context context, Ad ad, a aVar) throws Exception;

    /* access modifiers changed from: protected */
    public abstract void a(Ad ad, String str, String str2);

    /* access modifiers changed from: protected */
    public abstract <T> void a(String str, Ad ad, T t);

    /* access modifiers changed from: protected */
    public abstract SettingsManager c(Ad ad);

    public final void a(Context context, Ad ad, String str, a aVar) {
        a(context, ad, str, aVar, true);
    }

    public final void a(Context context, Ad ad, String str, a aVar, boolean z) {
        try {
            this.aM = context.getApplicationContext();
            if (g.g(context)) {
                b(context, ad, str, aVar, z);
            } else if (aVar != null) {
                aVar.error(AppnextError.CONNECTION_ERROR);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("AdsManager$getAdList", th);
            if (aVar != null) {
                aVar.error(AppnextError.NO_ADS);
            }
        }
    }

    /* access modifiers changed from: private */
    public String b(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        String str2;
        StringBuilder sb = new StringBuilder("https://globalcdnapi.appnext.com/offerWallApi.aspx?ext=t&pimp=1&igroup=sdk&m=1&osid=100&s2s=1&type=json&id=");
        sb.append(str);
        sb.append("&cnt=200&tid=");
        sb.append(ad != null ? ad.getTID() : "301");
        sb.append("&vid=");
        sb.append(ad != null ? ad.getVID() : "2.7.0.473");
        sb.append("&cat=");
        String str3 = "";
        sb.append(ad != null ? ad.getCategories() : str3);
        sb.append("&lockcat=");
        sb.append(ad != null ? ad.getSpecificCategories() : str3);
        sb.append("&did=");
        sb.append(g.b(context, false));
        sb.append("&devn=");
        sb.append(g.V());
        sb.append("&dosv=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&dct=");
        sb.append(g.q(g.c(context)));
        sb.append("&lang=");
        sb.append(Locale.getDefault().getLanguage());
        sb.append("&dcc=");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            str2 = simOperator.substring(0, 3) + "_" + simOperator.substring(3);
        } else {
            str2 = str3;
        }
        sb.append(str2);
        sb.append("&dds=0&packageId=");
        sb.append(context.getPackageName());
        sb.append("&g=");
        sb.append(a(context));
        sb.append("&opt=");
        sb.append(AdsIDHelper.isOptOut(context) ? 1 : 0);
        sb.append("&rnd=");
        sb.append(new Random().nextInt());
        if (!TextUtils.isEmpty(ad.getPackageName())) {
            str3 = "&sp=" + ad.getPackageName();
        }
        sb.append(str3);
        return sb.toString();
    }

    private void b(Context context, Ad ad, String str, a aVar, boolean z) {
        try {
            final Ad ad2 = ad;
            final Context context2 = context;
            final a aVar2 = aVar;
            final String str2 = str;
            final boolean z2 = z;
            n.aa().a(new Runnable() {
                /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                    	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
                    	at java.util.ArrayList.get(ArrayList.java:435)
                    	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                    */
                public final void run() {
                    /*
                        r10 = this;
                        com.appnext.core.Ad r0 = r3     // Catch:{ all -> 0x000b }
                        android.content.Context r1 = r4     // Catch:{ all -> 0x000b }
                        java.lang.String r1 = com.appnext.core.g.e((android.content.Context) r1)     // Catch:{ all -> 0x000b }
                        r0.setSessionId(r1)     // Catch:{ all -> 0x000b }
                    L_0x000b:
                        com.appnext.core.d r0 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        java.util.HashMap r0 = r0.ci     // Catch:{ all -> 0x0197 }
                        monitor-enter(r0)     // Catch:{ all -> 0x0197 }
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0194 }
                        com.appnext.core.Ad r2 = r3     // Catch:{ all -> 0x0194 }
                        com.appnext.core.a r1 = r1.j(r2)     // Catch:{ all -> 0x0194 }
                        r2 = 1
                        if (r1 == 0) goto L_0x003e
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0194 }
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0194 }
                        com.appnext.core.a r1 = r1.j(r3)     // Catch:{ all -> 0x0194 }
                        int r1 = r1.P()     // Catch:{ all -> 0x0194 }
                        if (r1 != r2) goto L_0x003e
                        com.appnext.core.d$a r1 = r5     // Catch:{ all -> 0x0194 }
                        if (r1 == 0) goto L_0x003c
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0194 }
                        com.appnext.core.Ad r2 = r3     // Catch:{ all -> 0x0194 }
                        com.appnext.core.a r1 = r1.j(r2)     // Catch:{ all -> 0x0194 }
                        com.appnext.core.d$a r2 = r5     // Catch:{ all -> 0x0194 }
                        r1.a(r2)     // Catch:{ all -> 0x0194 }
                    L_0x003c:
                        monitor-exit(r0)     // Catch:{ all -> 0x0194 }
                        return
                    L_0x003e:
                        com.appnext.core.a r1 = new com.appnext.core.a     // Catch:{ all -> 0x0194 }
                        r1.<init>()     // Catch:{ all -> 0x0194 }
                        com.appnext.core.d$a r3 = r5     // Catch:{ all -> 0x0194 }
                        r1.a(r3)     // Catch:{ all -> 0x0194 }
                        java.lang.String r3 = r6     // Catch:{ all -> 0x0194 }
                        r1.setPlacementID(r3)     // Catch:{ all -> 0x0194 }
                        r1.b(r2)     // Catch:{ all -> 0x0194 }
                        com.appnext.core.d r2 = com.appnext.core.d.this     // Catch:{ all -> 0x0194 }
                        java.util.HashMap r2 = r2.ci     // Catch:{ all -> 0x0194 }
                        com.appnext.core.b r3 = new com.appnext.core.b     // Catch:{ all -> 0x0194 }
                        com.appnext.core.Ad r4 = r3     // Catch:{ all -> 0x0194 }
                        r3.<init>(r4)     // Catch:{ all -> 0x0194 }
                        r2.remove(r3)     // Catch:{ all -> 0x0194 }
                        com.appnext.core.d r2 = com.appnext.core.d.this     // Catch:{ all -> 0x0194 }
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0194 }
                        r2.a((com.appnext.core.Ad) r3, (com.appnext.core.a) r1)     // Catch:{ all -> 0x0194 }
                        monitor-exit(r0)     // Catch:{ all -> 0x0194 }
                        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0184 }
                        r0.<init>()     // Catch:{ all -> 0x0184 }
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
                        r1.<init>()     // Catch:{ all -> 0x0184 }
                        com.appnext.core.d r2 = com.appnext.core.d.this     // Catch:{ all -> 0x0184 }
                        android.content.Context r3 = r4     // Catch:{ all -> 0x0184 }
                        com.appnext.core.Ad r4 = r3     // Catch:{ all -> 0x0184 }
                        java.lang.String r5 = r6     // Catch:{ all -> 0x0184 }
                        java.lang.String r2 = r2.b(r3, r4, r5, r0)     // Catch:{ all -> 0x0184 }
                        r1.append(r2)     // Catch:{ all -> 0x0184 }
                        com.appnext.core.d r2 = com.appnext.core.d.this     // Catch:{ all -> 0x0184 }
                        android.content.Context r3 = r4     // Catch:{ all -> 0x0184 }
                        com.appnext.core.Ad r4 = r3     // Catch:{ all -> 0x0184 }
                        java.lang.String r5 = r6     // Catch:{ all -> 0x0184 }
                        java.lang.String r0 = r2.a((android.content.Context) r3, (com.appnext.core.Ad) r4, (java.lang.String) r5, (java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>>) r0)     // Catch:{ all -> 0x0184 }
                        r1.append(r0)     // Catch:{ all -> 0x0184 }
                        java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0184 }
                        com.appnext.core.e.R()     // Catch:{ all -> 0x0184 }
                        android.content.Context r2 = r4     // Catch:{ all -> 0x0184 }
                        java.lang.String r3 = r6     // Catch:{ all -> 0x0184 }
                        com.appnext.core.Ad r0 = r3     // Catch:{ all -> 0x0184 }
                        java.lang.String r4 = r0.getAUID()     // Catch:{ all -> 0x0184 }
                        com.appnext.core.d r0 = com.appnext.core.d.this     // Catch:{ all -> 0x0184 }
                        com.appnext.core.Ad r1 = r3     // Catch:{ all -> 0x0184 }
                        java.lang.String r5 = "ads_caching_time_minutes"
                        long r5 = r0.a((com.appnext.core.Ad) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0184 }
                        com.appnext.core.Ad r0 = r3     // Catch:{ all -> 0x0184 }
                        java.lang.String r8 = r0.getSpecificCategories()     // Catch:{ all -> 0x0184 }
                        com.appnext.core.Ad r0 = r3     // Catch:{ all -> 0x0184 }
                        java.lang.String r9 = r0.getCategories()     // Catch:{ all -> 0x0184 }
                        java.lang.String r0 = com.appnext.core.e.a(r2, r3, r4, r5, r7, r8, r9)     // Catch:{ all -> 0x0184 }
                        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0197 }
                        if (r1 != 0) goto L_0x017a
                        java.lang.String r1 = "{\"apps\":[]}"
                        boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0197 }
                        if (r1 != 0) goto L_0x017a
                        java.lang.String r1 = "{}"
                        boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0197 }
                        if (r1 != 0) goto L_0x017a
                        boolean r1 = com.appnext.core.d.m(r0)     // Catch:{ all -> 0x0197 }
                        if (r1 == 0) goto L_0x00d9
                        goto L_0x017a
                    L_0x00d9:
                        com.appnext.core.Ad r1 = r3     // Catch:{ all -> 0x0166 }
                        java.lang.String r1 = r1.getPostback()     // Catch:{ all -> 0x0166 }
                        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0166 }
                        if (r1 != 0) goto L_0x00ff
                        java.lang.String r1 = "&q="
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0166 }
                        java.lang.String r3 = "&q="
                        r2.<init>(r3)     // Catch:{ all -> 0x0166 }
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0166 }
                        java.lang.String r3 = r3.getPostback()     // Catch:{ all -> 0x0166 }
                        r2.append(r3)     // Catch:{ all -> 0x0166 }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0166 }
                        java.lang.String r0 = r0.replaceAll(r1, r2)     // Catch:{ all -> 0x0166 }
                    L_0x00ff:
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0166 }
                        android.content.Context r2 = r4     // Catch:{ all -> 0x0166 }
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0166 }
                        r4 = 200(0xc8, float:2.8E-43)
                        java.util.ArrayList r1 = r1.a((android.content.Context) r2, (com.appnext.core.Ad) r3, (java.lang.String) r0, (int) r4)     // Catch:{ all -> 0x0166 }
                        android.content.Context r2 = r4     // Catch:{ all -> 0x0166 }
                        java.lang.String r3 = r6     // Catch:{ all -> 0x0166 }
                        com.appnext.core.Ad r4 = r3     // Catch:{ all -> 0x0166 }
                        java.lang.String r4 = r4.getAUID()     // Catch:{ all -> 0x0166 }
                        java.util.ArrayList r1 = com.appnext.core.d.a((android.content.Context) r2, (java.util.ArrayList<com.appnext.core.AppnextAd>) r1, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0166 }
                        if (r1 == 0) goto L_0x015c
                        boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0197 }
                        if (r2 == 0) goto L_0x0122
                        goto L_0x015c
                    L_0x0122:
                        com.appnext.core.d r0 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        com.appnext.core.Ad r2 = r3     // Catch:{ all -> 0x0197 }
                        com.appnext.core.a r0 = r0.j(r2)     // Catch:{ all -> 0x0197 }
                        r0.c(r1)     // Catch:{ all -> 0x0197 }
                        boolean r0 = r7     // Catch:{ all -> 0x0197 }
                        if (r0 == 0) goto L_0x013e
                        com.appnext.core.d r0 = com.appnext.core.d.this     // Catch:{ all -> 0x013e }
                        android.content.Context r1 = r4     // Catch:{ all -> 0x013e }
                        com.appnext.core.Ad r2 = r3     // Catch:{ all -> 0x013e }
                        com.appnext.core.a r3 = r0.j(r2)     // Catch:{ all -> 0x013e }
                        r0.a((android.content.Context) r1, (com.appnext.core.Ad) r2, (com.appnext.core.a) r3)     // Catch:{ all -> 0x013e }
                    L_0x013e:
                        com.appnext.core.d r0 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        com.appnext.core.Ad r1 = r3     // Catch:{ all -> 0x0197 }
                        com.appnext.core.a r0 = r0.j(r1)     // Catch:{ all -> 0x0197 }
                        r1 = 2
                        r0.b(r1)     // Catch:{ all -> 0x0197 }
                        android.os.Handler r0 = new android.os.Handler     // Catch:{ all -> 0x0197 }
                        android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0197 }
                        r0.<init>(r1)     // Catch:{ all -> 0x0197 }
                        com.appnext.core.d$1$1 r1 = new com.appnext.core.d$1$1     // Catch:{ all -> 0x0197 }
                        r1.<init>()     // Catch:{ all -> 0x0197 }
                        r0.post(r1)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x015c:
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = "No Ads"
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0197 }
                        r1.a((java.lang.String) r2, (java.lang.String) r0, (com.appnext.core.Ad) r3)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x0166:
                        r0 = move-exception
                        java.lang.String r1 = "AdsManager$updateAdList"
                        com.appnext.base.a.a(r1, r0)     // Catch:{ all -> 0x0197 }
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = "Internal error"
                        java.lang.String r0 = com.appnext.core.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0197 }
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0197 }
                        r1.a((java.lang.String) r2, (java.lang.String) r0, (com.appnext.core.Ad) r3)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x017a:
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = "No Ads"
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0197 }
                        r1.a((java.lang.String) r2, (java.lang.String) r0, (com.appnext.core.Ad) r3)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x0184:
                        r0 = move-exception
                        com.appnext.core.d r1 = com.appnext.core.d.this     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = "No Ads"
                        java.lang.String r0 = com.appnext.core.g.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0197 }
                        com.appnext.core.Ad r3 = r3     // Catch:{ all -> 0x0197 }
                        r4 = 0
                        r1.a((java.lang.String) r2, (java.lang.String) r0, (com.appnext.core.Ad) r3, (int) r4)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x0194:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                        throw r1     // Catch:{ all -> 0x0197 }
                    L_0x0197:
                        r0 = move-exception
                        java.lang.String r1 = "AdsManager$updateAdList"
                        com.appnext.base.a.a(r1, r0)
                        com.appnext.core.d r1 = com.appnext.core.d.this
                        java.lang.String r0 = r0.getMessage()
                        com.appnext.core.Ad r2 = r3
                        r1.a((java.lang.String) r0, (com.appnext.core.Ad) r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.d.AnonymousClass1.run():void");
                }
            });
        } catch (Throwable unused) {
            a(AppnextError.INTERNAL_ERROR, ad);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Ad ad) {
        try {
            return h(ad) && i(ad);
        } catch (Throwable th) {
            com.appnext.base.a.a("AdsManager$isLoadedAndUpdated", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean h(Ad ad) {
        try {
            if (this.ci == null || j(ad) == null || j(ad).P() != 2 || j(ad).getAds() == null) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final boolean i(Ad ad) {
        try {
            if (this.ci == null || j(ad) == null || j(ad).getAds().size() != 0 || j(ad).O().longValue() + 60000 <= System.currentTimeMillis()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public long a(Ad ad, String str) {
        try {
            return Long.valueOf(c(ad).t(str)).longValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static ArrayList<AppnextAd> a(Context context, ArrayList<AppnextAd> arrayList, String str, String str2) {
        if (arrayList == null) {
            try {
                return new ArrayList<>();
            } catch (Throwable unused) {
                return new ArrayList<>();
            }
        } else {
            List<String> w = com.appnext.core.adswatched.a.l(context).w(str2);
            if (w != null) {
                if (!w.isEmpty()) {
                    arrayList.size();
                    ArrayList<AppnextAd> arrayList2 = new ArrayList<>();
                    ListIterator<AppnextAd> listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        AppnextAd next = listIterator.next();
                        if (next != null && !w.contains(next.getBannerID())) {
                            arrayList2.add(next);
                            listIterator.remove();
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        com.appnext.core.adswatched.a.l(context).k(str, str2);
                    }
                    arrayList2.addAll(arrayList);
                    arrayList.toString();
                    return arrayList2;
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        if (r2.getRevenueType().equals("cpc") != false) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.appnext.core.AppnextAd> a(android.content.Context r6, com.appnext.core.Ad r7, java.lang.String r8, int r9) throws org.json.JSONException {
        /*
            r5 = this;
            com.appnext.core.a r9 = r5.j(r7)
            r9.k(r8)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r8)
            java.lang.String r8 = "apps"
            org.json.JSONArray r8 = r0.getJSONArray(r8)
            r0 = 0
        L_0x0018:
            int r1 = r8.length()
            if (r0 >= r1) goto L_0x00a5
            org.json.JSONObject r1 = r8.getJSONObject(r0)
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a1 }
            com.appnext.core.h r1 = parseAd(r1)     // Catch:{ all -> 0x00a1 }
            com.appnext.core.AppnextAd r1 = (com.appnext.core.AppnextAd) r1     // Catch:{ all -> 0x00a1 }
            int r2 = r9.size()     // Catch:{ all -> 0x00a1 }
            r1.setAdID(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r7.getPlacementID()     // Catch:{ all -> 0x00a1 }
            r1.setPlacementID(r2)     // Catch:{ all -> 0x00a1 }
            int r2 = r5.a((android.content.Context) r6, (com.appnext.core.h) r1)     // Catch:{ all -> 0x00a1 }
            if (r2 != 0) goto L_0x0091
            com.appnext.core.AppnextAd r2 = a((java.util.ArrayList<com.appnext.core.AppnextAd>) r9, (com.appnext.core.AppnextAd) r1)     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x008d
            r9.remove(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r3 = r2.getRevenueType()     // Catch:{ all -> 0x00a1 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a1 }
            if (r3 != 0) goto L_0x0076
            java.lang.String r3 = r2.getRevenueType()     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r1.getRevenueType()     // Catch:{ all -> 0x00a1 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00a1 }
            if (r3 == 0) goto L_0x0076
            java.lang.String r3 = r2.getRevenueRate()     // Catch:{ all -> 0x00a1 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r1.getRevenueRate()     // Catch:{ all -> 0x00a1 }
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ all -> 0x00a1 }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x008d
            goto L_0x008c
        L_0x0076:
            java.lang.String r3 = r2.getRevenueType()     // Catch:{ all -> 0x00a1 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a1 }
            if (r3 != 0) goto L_0x008d
            java.lang.String r3 = r2.getRevenueType()     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = "cpc"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00a1 }
            if (r3 == 0) goto L_0x008d
        L_0x008c:
            r1 = r2
        L_0x008d:
            r9.add(r1)     // Catch:{ all -> 0x00a1 }
            goto L_0x0098
        L_0x0091:
            r1.getBannerID()     // Catch:{ all -> 0x00a1 }
            r1 = 1
            if (r2 == r1) goto L_0x0098
            r1 = 2
        L_0x0098:
            int r1 = r9.size()     // Catch:{ all -> 0x00a1 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x00a1
            goto L_0x00a5
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0018
        L_0x00a5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.d.a(android.content.Context, com.appnext.core.Ad, java.lang.String, int):java.util.ArrayList");
    }

    private static AppnextAd a(ArrayList<AppnextAd> arrayList, AppnextAd appnextAd) {
        try {
            Iterator<AppnextAd> it = arrayList.iterator();
            while (it.hasNext()) {
                AppnextAd next = it.next();
                if (next.getAdPackage().equals(appnextAd.getAdPackage())) {
                    return next;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    protected static boolean m(String str) {
        try {
            return new JSONObject(str).has("rnd");
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public String a(ArrayList<AppnextAd> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<AppnextAd> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(it.next().getAdJSON()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apps", jSONArray);
            return jSONObject.toString().replace(" ", "\\u2028").replace(" ", "\\u2029");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, Ad ad) {
        a(str, "", ad);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, Ad ad) {
        a(str, str2, ad, 2);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, Ad ad, int i) {
        final Ad ad2 = ad;
        final int i2 = i;
        final String str3 = str;
        final String str4 = str2;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    a j = d.this.j(ad2);
                    if (j != null) {
                        if (j.getAds() == null) {
                            j.c(new ArrayList());
                        } else {
                            j.c(j.getAds());
                        }
                        j.b(i2);
                        j.l(str3);
                        d dVar = d.this;
                        Ad ad = ad2;
                        dVar.a(ad, str3 + " " + str4, j.getPlacementID());
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("AdKey$notifyError", th);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final a j(Ad ad) {
        return this.ci.get(new b(ad));
    }

    /* access modifiers changed from: protected */
    public final HashMap<b, a> Q() {
        return this.ci;
    }

    /* access modifiers changed from: protected */
    public final void a(Ad ad, a aVar) {
        this.ci.put(new b(ad), aVar);
    }

    public static String c(AppnextAd appnextAd) {
        return appnextAd.getAdJSON();
    }

    public final String k(Ad ad) {
        return j(ad).w();
    }

    public static h parseAd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppnextAd appnextAd = (AppnextAd) k.a((Class<?>) AppnextAd.class, jSONObject);
            if (appnextAd != null) {
                appnextAd.setAdJSON(jSONObject.toString());
                if (jSONObject.has(CmcdConfiguration.KEY_SESSION_ID)) {
                    appnextAd.setSession(jSONObject.getString(CmcdConfiguration.KEY_SESSION_ID));
                }
                if (TextUtils.isEmpty(appnextAd.getStoreRating())) {
                    appnextAd.setStoreRating("0");
                }
            }
            return appnextAd;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(final Context context, final String str, final Ad ad) {
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    com.appnext.core.adswatched.a.l(context).j(str, ad.getAUID());
                } catch (Throwable unused) {
                }
            }
        });
    }

    protected static int a(Context context) {
        try {
            if (g.c(context, "android.permission.READ_CONTACTS") && g.c(context, "android.permission.GET_ACCOUNTS")) {
                return AccountManager.get(context).getAccountsByType("com.google").length > 0 ? 0 : 1;
            }
        } catch (Throwable unused) {
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.aM;
    }
}
