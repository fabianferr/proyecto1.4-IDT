package com.appnext.core;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Process;
import com.appnext.core.f;
import java.io.IOException;
import java.util.HashMap;

public class p {
    private String banner = "";
    private f click;
    /* access modifiers changed from: private */
    public Context context;
    private String ct = "";
    /* access modifiers changed from: private */
    public a dC;
    /* access modifiers changed from: private */
    public f.a dD = new f.a() {
        public final void onMarket(String str) {
            AppnextAd d = p.this.dC.d();
            Ad c = p.this.dC.c();
            if (c != null && d != null && p.this.context != null) {
                if (!g.b(p.this.context, d.getAdPackage())) {
                    try {
                        if (!str.startsWith("market://details?id=" + d.getAdPackage()) && !str.startsWith("http")) {
                            p.this.a(g.e("admin.appnext.com", "applink"), d.getBannerID(), c.getPlacementID(), c.getTID(), str, "SetROpenV1");
                        }
                    } catch (Throwable th) {
                        com.appnext.base.a.a("UserAction$onMarket", th);
                    }
                } else if (str.startsWith("market://")) {
                    try {
                        Intent launchIntentForPackage = p.this.context.getPackageManager().getLaunchIntentForPackage(d.getAdPackage());
                        launchIntentForPackage.addFlags(268435456);
                        p.this.context.startActivity(launchIntentForPackage);
                    } catch (Throwable unused) {
                        p.this.dC.report("error_no_market");
                    }
                } else {
                    try {
                        p.this.openLink(str);
                    } catch (Throwable unused2) {
                        p.this.dC.report("error_no_market");
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x008e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void error(java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "UserAction$error"
                com.appnext.core.p r1 = com.appnext.core.p.this     // Catch:{ all -> 0x003d }
                java.lang.String r2 = "admin.appnext.com"
                java.lang.String r3 = "applink"
                java.lang.String r2 = com.appnext.core.g.e(r2, r3)     // Catch:{ all -> 0x003d }
                com.appnext.core.p r3 = com.appnext.core.p.this     // Catch:{ all -> 0x003d }
                com.appnext.core.p$a r3 = r3.dC     // Catch:{ all -> 0x003d }
                com.appnext.core.AppnextAd r3 = r3.d()     // Catch:{ all -> 0x003d }
                java.lang.String r3 = r3.getBannerID()     // Catch:{ all -> 0x003d }
                com.appnext.core.p r4 = com.appnext.core.p.this     // Catch:{ all -> 0x003d }
                com.appnext.core.p$a r4 = r4.dC     // Catch:{ all -> 0x003d }
                com.appnext.core.Ad r4 = r4.c()     // Catch:{ all -> 0x003d }
                java.lang.String r4 = r4.getPlacementID()     // Catch:{ all -> 0x003d }
                com.appnext.core.p r5 = com.appnext.core.p.this     // Catch:{ all -> 0x003d }
                com.appnext.core.p$a r5 = r5.dC     // Catch:{ all -> 0x003d }
                com.appnext.core.Ad r5 = r5.c()     // Catch:{ all -> 0x003d }
                java.lang.String r5 = r5.getTID()     // Catch:{ all -> 0x003d }
                java.lang.String r7 = "SetDOpenV1"
                r6 = r9
                r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003d }
                goto L_0x0041
            L_0x003d:
                r1 = move-exception
                com.appnext.base.a.a(r0, r1)
            L_0x0041:
                com.appnext.core.p r1 = com.appnext.core.p.this     // Catch:{ all -> 0x0098 }
                com.appnext.core.p$a r1 = r1.dC     // Catch:{ all -> 0x0098 }
                com.appnext.core.SettingsManager r1 = r1.e()     // Catch:{ all -> 0x0098 }
                java.lang.String r2 = "urlApp_protection"
                java.lang.String r1 = r1.t(r2)     // Catch:{ all -> 0x0098 }
                boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch:{ all -> 0x0098 }
                java.lang.String r2 = "error_no_market"
                if (r1 == 0) goto L_0x0085
                com.appnext.core.p r9 = com.appnext.core.p.this     // Catch:{ all -> 0x007b }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
                java.lang.String r3 = "market://details?id="
                r1.<init>(r3)     // Catch:{ all -> 0x007b }
                com.appnext.core.p r3 = com.appnext.core.p.this     // Catch:{ all -> 0x007b }
                com.appnext.core.p$a r3 = r3.dC     // Catch:{ all -> 0x007b }
                com.appnext.core.AppnextAd r3 = r3.d()     // Catch:{ all -> 0x007b }
                java.lang.String r3 = r3.getAdPackage()     // Catch:{ all -> 0x007b }
                r1.append(r3)     // Catch:{ all -> 0x007b }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007b }
                r9.openLink(r1)     // Catch:{ all -> 0x007b }
                goto L_0x009c
            L_0x007b:
                com.appnext.core.p r9 = com.appnext.core.p.this     // Catch:{ all -> 0x0098 }
                com.appnext.core.p$a r9 = r9.dC     // Catch:{ all -> 0x0098 }
                r9.report(r2)     // Catch:{ all -> 0x0098 }
                goto L_0x009c
            L_0x0085:
                if (r9 != 0) goto L_0x0088
                return
            L_0x0088:
                com.appnext.core.p r1 = com.appnext.core.p.this     // Catch:{ all -> 0x008e }
                r1.openLink(r9)     // Catch:{ all -> 0x008e }
                goto L_0x009c
            L_0x008e:
                com.appnext.core.p r9 = com.appnext.core.p.this     // Catch:{ all -> 0x0098 }
                com.appnext.core.p$a r9 = r9.dC     // Catch:{ all -> 0x0098 }
                r9.report(r2)     // Catch:{ all -> 0x0098 }
                return
            L_0x0098:
                r9 = move-exception
                com.appnext.base.a.a(r0, r9)
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.p.AnonymousClass3.error(java.lang.String):void");
        }
    };
    private String guid = "";

    public interface a {
        Ad c();

        AppnextAd d();

        SettingsManager e();

        void report(String str);
    }

    public p(Context context2, a aVar) {
        this.context = context2;
        this.click = f.b(context2);
        this.dC = aVar;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        f fVar = this.click;
        if (fVar != null) {
            n.aa().a(new Runnable(str, str2, str3, str4, str5, str6) {
                final /* synthetic */ String cJ;
                final /* synthetic */ String cK;
                final /* synthetic */ String cL;
                final /* synthetic */ String cM;
                final /* synthetic */ String cr;
                final /* synthetic */ String val$placementID;

                {
                    this.cJ = r2;
                    this.cr = r3;
                    this.val$placementID = r4;
                    this.cK = r5;
                    this.cL = r6;
                    this.cM = r7;
                }

                public final void run() {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("guid", this.cJ);
                        hashMap.put("bannerId", this.cr);
                        hashMap.put("placementId", this.val$placementID);
                        hashMap.put("vid", this.cK);
                        hashMap.put("url", this.cL);
                        Context r1 = f.this.context;
                        g.a(r1, "https://admin.appnext.com/AdminService.asmx/" + this.cM, hashMap);
                    } catch (Throwable th) {
                        com.appnext.base.a.a("AppnextCK$serverNotify", th);
                    }
                }
            });
        }
    }

    public final void a(AppnextAd appnextAd, String str, f.a aVar) {
        f fVar = this.click;
        if (fVar != null) {
            n.aa().a(new Runnable(appnextAd) {
                final /* synthetic */ AppnextAd B;

                public final void run(
/*
Method generation error in method: com.appnext.core.f.6.run():void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appnext.core.f.6.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
        }
    }

    public final void c(AppnextAd appnextAd, f.a aVar) {
        this.click.a(appnextAd.getMarketUrl(), aVar);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.appnext.core.AppnextAd r10, final java.lang.String r11, java.lang.String r12, final com.appnext.core.f.a r13) {
        /*
            r9 = this;
            java.lang.String r0 = "UserAction$doClick"
            boolean r1 = r9.ac()     // Catch:{ all -> 0x0157 }
            if (r1 != 0) goto L_0x001a
            android.os.Handler r10 = new android.os.Handler     // Catch:{ all -> 0x0157 }
            android.os.Looper r12 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0157 }
            r10.<init>(r12)     // Catch:{ all -> 0x0157 }
            com.appnext.core.p$1 r12 = new com.appnext.core.p$1     // Catch:{ all -> 0x0157 }
            r12.<init>(r11, r13)     // Catch:{ all -> 0x0157 }
            r10.post(r12)     // Catch:{ all -> 0x0157 }
            return
        L_0x001a:
            if (r10 != 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r1 = r9.ct     // Catch:{ all -> 0x0152 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0152 }
            if (r1 != 0) goto L_0x0072
            java.lang.String r1 = r9.ct     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = r10.getAdPackage()     // Catch:{ all -> 0x0152 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0072
            android.content.Context r10 = r9.context     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "https://admin.appnext.com/AdminService.asmx/SetRL?guid="
            r11.<init>(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = r9.guid     // Catch:{ all -> 0x005a }
            r11.append(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "&bid="
            r11.append(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = r9.banner     // Catch:{ all -> 0x005a }
            r11.append(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "&pid="
            r11.append(r1)     // Catch:{ all -> 0x005a }
            r11.append(r12)     // Catch:{ all -> 0x005a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x005a }
            r12 = 0
            com.appnext.core.g.a(r10, r11, r12)     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r10 = move-exception
            com.appnext.base.a.a(r0, r10)     // Catch:{ all -> 0x0152 }
        L_0x005e:
            com.appnext.core.f$a r10 = r9.dD     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = r9.ct     // Catch:{ all -> 0x0152 }
            r10.onMarket(r11)     // Catch:{ all -> 0x0152 }
            if (r13 == 0) goto L_0x006c
            java.lang.String r10 = r9.ct     // Catch:{ all -> 0x0152 }
            r13.onMarket(r10)     // Catch:{ all -> 0x0152 }
        L_0x006c:
            java.lang.String r10 = ""
            r9.ct = r10     // Catch:{ all -> 0x0152 }
            goto L_0x0156
        L_0x0072:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r12.<init>()     // Catch:{ all -> 0x0152 }
            r12.append(r11)     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = "&device="
            r12.append(r11)     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = com.appnext.core.g.V()     // Catch:{ all -> 0x0152 }
            r12.append(r11)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r12.toString()     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = r10.getWebview()     // Catch:{ all -> 0x0152 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x0152 }
            r1 = 2
            r2 = 1
            switch(r12) {
                case 48: goto L_0x00b6;
                case 49: goto L_0x00ac;
                case 50: goto L_0x00a2;
                case 51: goto L_0x0098;
                default: goto L_0x0097;
            }     // Catch:{ all -> 0x0152 }
        L_0x0097:
            goto L_0x00c0
        L_0x0098:
            java.lang.String r12 = "3"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0152 }
            if (r11 == 0) goto L_0x00c0
            r11 = 0
            goto L_0x00c1
        L_0x00a2:
            java.lang.String r12 = "2"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0152 }
            if (r11 == 0) goto L_0x00c0
            r11 = 1
            goto L_0x00c1
        L_0x00ac:
            java.lang.String r12 = "1"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0152 }
            if (r11 == 0) goto L_0x00c0
            r11 = 2
            goto L_0x00c1
        L_0x00b6:
            java.lang.String r12 = "0"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0152 }
            if (r11 == 0) goto L_0x00c0
            r11 = 3
            goto L_0x00c1
        L_0x00c0:
            r11 = -1
        L_0x00c1:
            r12 = 268435456(0x10000000, float:2.5243549E-29)
            if (r11 == 0) goto L_0x012c
            if (r11 == r2) goto L_0x011c
            if (r11 == r1) goto L_0x00f7
            com.appnext.core.f r1 = r9.click     // Catch:{ all -> 0x0152 }
            if (r1 != 0) goto L_0x00ce
            return
        L_0x00ce:
            java.lang.String r2 = r10.getAppURL()     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = r10.getMarketUrl()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r10.getBannerID()     // Catch:{ all -> 0x0152 }
            com.appnext.core.p$2 r6 = new com.appnext.core.p$2     // Catch:{ all -> 0x0152 }
            r6.<init>(r13)     // Catch:{ all -> 0x0152 }
            com.appnext.core.p$a r10 = r9.dC     // Catch:{ all -> 0x0152 }
            com.appnext.core.SettingsManager r10 = r10.e()     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = "resolve_timeout"
            java.lang.String r10 = r10.t(r11)     // Catch:{ all -> 0x0152 }
            long r10 = java.lang.Long.parseLong(r10)     // Catch:{ all -> 0x0152 }
            r12 = 1000(0x3e8, double:4.94E-321)
            long r7 = r10 * r12
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0152 }
            goto L_0x015b
        L_0x00f7:
            android.content.Intent r11 = new android.content.Intent     // Catch:{ all -> 0x0152 }
            android.content.Context r1 = r9.context     // Catch:{ all -> 0x0152 }
            java.lang.Class<com.appnext.core.ResultActivity> r2 = com.appnext.core.ResultActivity.class
            r11.<init>(r1, r2)     // Catch:{ all -> 0x0152 }
            java.lang.String r1 = "url"
            r11.putExtra(r1, r4)     // Catch:{ all -> 0x0152 }
            java.lang.String r1 = "title"
            java.lang.String r10 = r10.getAdTitle()     // Catch:{ all -> 0x0152 }
            r11.putExtra(r1, r10)     // Catch:{ all -> 0x0152 }
            r11.addFlags(r12)     // Catch:{ all -> 0x0152 }
            android.content.Context r10 = r9.context     // Catch:{ all -> 0x0152 }
            r10.startActivity(r11)     // Catch:{ all -> 0x0152 }
            if (r13 == 0) goto L_0x015b
            r13.onMarket(r4)     // Catch:{ all -> 0x0152 }
            goto L_0x0156
        L_0x011c:
            com.appnext.core.f$a r10 = r9.dD     // Catch:{ all -> 0x0127 }
            r10.onMarket(r4)     // Catch:{ all -> 0x0127 }
            if (r13 == 0) goto L_0x0156
            r13.onMarket(r4)     // Catch:{ all -> 0x0127 }
            goto L_0x0156
        L_0x0127:
            r10 = move-exception
            com.appnext.base.a.a(r0, r10)     // Catch:{ all -> 0x0152 }
            goto L_0x0156
        L_0x012c:
            android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x014d }
            java.lang.String r11 = "android.intent.action.VIEW"
            r10.<init>(r11)     // Catch:{ all -> 0x014d }
            android.net.Uri r11 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x014d }
            r10.setData(r11)     // Catch:{ all -> 0x014d }
            r10.addFlags(r12)     // Catch:{ all -> 0x014d }
            android.content.Context r11 = r9.context     // Catch:{ all -> 0x0148 }
            r11.startActivity(r10)     // Catch:{ all -> 0x0148 }
            if (r13 == 0) goto L_0x015b
            r13.onMarket(r4)     // Catch:{ all -> 0x0148 }
            goto L_0x015b
        L_0x0148:
            r10 = move-exception
            com.appnext.base.a.a(r0, r10)     // Catch:{ all -> 0x014d }
            goto L_0x0156
        L_0x014d:
            r10 = move-exception
            com.appnext.base.a.a(r0, r10)     // Catch:{ all -> 0x0152 }
            goto L_0x0156
        L_0x0152:
            r10 = move-exception
            com.appnext.base.a.a(r0, r10)     // Catch:{ all -> 0x0157 }
        L_0x0156:
            return
        L_0x0157:
            r10 = move-exception
            com.appnext.base.a.a(r0, r10)
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.p.a(com.appnext.core.AppnextAd, java.lang.String, java.lang.String, com.appnext.core.f$a):void");
    }

    /* access modifiers changed from: private */
    public void openLink(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public final void d(AppnextAd appnextAd) {
        try {
            f fVar = this.click;
            if (fVar != null) {
                fVar.d(appnextAd);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("UserAction$adImpression", th);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean ac() {
        try {
            if (this.context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                g.a(this.context, "http://www.appnext.com/myid.html", (HashMap<String, String>) null);
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            throw new IOException();
        } catch (Throwable th) {
            com.appnext.base.a.a("UserAction$checkConnection", th);
            return false;
        }
    }

    public final void destroy() {
        this.context = null;
        if (this.click != null) {
            this.click = null;
        }
    }
}
