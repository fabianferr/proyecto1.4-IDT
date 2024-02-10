package com.applovin.impl.sdk.f;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.k;
import com.applovin.impl.sdk.utils.p;
import com.applovin.sdk.AppLovinSdk;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class n extends a {
    /* access modifiers changed from: private */
    public final m a;

    public n(m mVar) {
        super("TaskInitializeSdk", mVar);
        this.a = mVar;
    }

    private void a() {
        if (!this.a.D().a()) {
            Activity ao = this.a.ao();
            if (ao != null) {
                this.a.D().a(ao);
            } else {
                this.a.S().a((a) new z(this.a, true, new Runnable() {
                    public void run() {
                        n.this.a.D().a(n.this.a.af().a());
                    }
                }), o.a.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    private void b() {
        String str;
        if (!this.a.e()) {
            boolean d = this.a.K().d();
            if (d) {
                str = this.a.V().k().b + " (use this for test devices)";
            } else {
                str = "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            }
            Map<String, Object> d2 = this.a.V().d();
            Map<String, Object> c = this.a.V().c();
            k kVar = new k();
            kVar.a().a("=====AppLovin SDK=====");
            kVar.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.a.a(b.dC)).a("Ad Review Version", e.a()).a("OM SDK Version", this.a.al().c());
            kVar.a("===Device Info===").a("OS", Utils.getAndroidOSInfo()).a(IronSourceConstants.TYPE_GAID, str).a(ExifInterface.TAG_MODEL, d2.get("model")).a("Locale", d2.get("locale")).a("Emulator", d2.get("sim")).a("Tablet", d2.get("is_tablet"));
            kVar.a("===App Info===").a("Application ID", c.get(CampaignEx.JSON_KEY_PACKAGE_NAME)).a("Target SDK", c.get("target_sdk")).a("ExoPlayer Version", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
            kVar.a("===SDK Settings===").a("SDK Key", this.a.z()).a("Mediation Provider", this.a.t()).a("TG", p.a(this.a)).a("Test Mode On", Boolean.valueOf(this.a.J().a())).a("Verbose Logging On", Boolean.valueOf(d));
            kVar.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(j.a(f()));
            kVar.a();
            u.f("AppLovinSdk", kVar.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0165, code lost:
        if (r12.a.d() != false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01c1, code lost:
        if (r12.a.d() != false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01c4, code lost:
        r2 = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01c5, code lost:
        r8.append(r2);
        r8.append(" in ");
        r8.append(java.lang.System.currentTimeMillis() - r6);
        r8.append("ms");
        a(r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            boolean r8 = com.applovin.impl.sdk.u.a()
            if (r8 == 0) goto L_0x002e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Initializing AppLovin SDK v"
            r8.<init>(r9)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r9)
            java.lang.String r9 = "..."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.a(r8)
        L_0x002e:
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.e.g r8 = r8.T()     // Catch:{ all -> 0x0168 }
            r8.d()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.e.g r8 = r8.T()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.e.f r9 = com.applovin.impl.sdk.e.f.e     // Catch:{ all -> 0x0168 }
            r8.c(r9)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.e.g r8 = r8.T()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.e.f r9 = com.applovin.impl.sdk.e.f.f     // Catch:{ all -> 0x0168 }
            r8.c(r9)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.q r8 = r8.ab()     // Catch:{ all -> 0x0168 }
            android.content.Context r9 = r12.f()     // Catch:{ all -> 0x0168 }
            r8.a((android.content.Context) r9)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.q r8 = r8.ab()     // Catch:{ all -> 0x0168 }
            android.content.Context r9 = r12.f()     // Catch:{ all -> 0x0168 }
            r8.b((android.content.Context) r9)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.f.o r8 = r8.S()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.f.b r9 = new com.applovin.impl.sdk.f.b     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r10 = r12.a     // Catch:{ all -> 0x0168 }
            r9.<init>(r10)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.f.o$a r10 = com.applovin.impl.sdk.f.o.a.MAIN     // Catch:{ all -> 0x0168 }
            r8.a((com.applovin.impl.sdk.f.a) r9, (com.applovin.impl.sdk.f.o.a) r10)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.o r8 = r8.V()     // Catch:{ all -> 0x0168 }
            r8.e()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.utils.n r8 = r8.ah()     // Catch:{ all -> 0x0168 }
            r8.a()     // Catch:{ all -> 0x0168 }
            android.content.Context r8 = r12.f()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r9 = r12.a     // Catch:{ all -> 0x0168 }
            boolean r8 = com.applovin.impl.sdk.utils.Utils.isPubInDebugMode(r8, r9)     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x009c
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            r8.h()     // Catch:{ all -> 0x0168 }
        L_0x009c:
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.a.c r8 = r8.an()     // Catch:{ all -> 0x0168 }
            r8.a()     // Catch:{ all -> 0x0168 }
            r12.b()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.d.b.dW     // Catch:{ all -> 0x0168 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0168 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0168 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x00c0
            com.applovin.impl.sdk.f.n$1 r8 = new com.applovin.impl.sdk.f.n$1     // Catch:{ all -> 0x0168 }
            r8.<init>()     // Catch:{ all -> 0x0168 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r8)     // Catch:{ all -> 0x0168 }
        L_0x00c0:
            r12.a()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            r9 = 1
            r8.a((boolean) r9)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.network.f r8 = r8.U()     // Catch:{ all -> 0x0168 }
            r8.c()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.sdk.AppLovinEventService r8 = r8.w()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.EventServiceImpl r8 = (com.applovin.impl.sdk.EventServiceImpl) r8     // Catch:{ all -> 0x0168 }
            r8.maybeTrackAppOpenEvent()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.mediation.debugger.a r8 = r8.G()     // Catch:{ all -> 0x0168 }
            boolean r8 = r8.b()     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x00f1
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            boolean r8 = r8.e()     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x0117
        L_0x00f1:
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.d.a.h     // Catch:{ all -> 0x0168 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0168 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0168 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x0120
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            android.content.Context r8 = r8.L()     // Catch:{ all -> 0x0168 }
            com.applovin.impl.sdk.m r9 = r12.a     // Catch:{ all -> 0x0168 }
            boolean r8 = com.applovin.impl.sdk.utils.Utils.isPubInDebugMode(r8, r9)     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x0120
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            boolean r8 = r8.f()     // Catch:{ all -> 0x0168 }
            if (r8 == 0) goto L_0x0120
        L_0x0117:
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x0168 }
            com.applovin.impl.mediation.debugger.a r8 = r8.G()     // Catch:{ all -> 0x0168 }
            r8.a()     // Catch:{ all -> 0x0168 }
        L_0x0120:
            com.applovin.impl.sdk.m r8 = r12.a
            com.applovin.impl.sdk.b.f r8 = r8.al()
            r8.a()
            com.applovin.impl.sdk.m r8 = r12.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.d.b.aB
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x014c
            com.applovin.impl.sdk.m r8 = r12.a
            com.applovin.impl.sdk.d.b<java.lang.Long> r9 = com.applovin.impl.sdk.d.b.aC
            java.lang.Object r8 = r8.a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.m r10 = r12.a
            r10.a((long) r8)
        L_0x014c:
            boolean r8 = com.applovin.impl.sdk.u.a()
            if (r8 == 0) goto L_0x01dd
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.m r4 = r12.a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x01c4
            goto L_0x01c5
        L_0x0168:
            r8 = move-exception
            boolean r9 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x01de }
            if (r9 == 0) goto L_0x0176
            java.lang.String r9 = "AppLovinSdk"
            java.lang.String r10 = "Failed to initialize SDK!"
            com.applovin.impl.sdk.u.c(r9, r10, r8)     // Catch:{ all -> 0x01de }
        L_0x0176:
            com.applovin.impl.sdk.m r8 = r12.a     // Catch:{ all -> 0x01de }
            r9 = 0
            r8.a((boolean) r9)     // Catch:{ all -> 0x01de }
            com.applovin.impl.sdk.m r8 = r12.a
            com.applovin.impl.sdk.b.f r8 = r8.al()
            r8.a()
            com.applovin.impl.sdk.m r8 = r12.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.d.b.aB
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x01a8
            com.applovin.impl.sdk.m r8 = r12.a
            com.applovin.impl.sdk.d.b<java.lang.Long> r9 = com.applovin.impl.sdk.d.b.aC
            java.lang.Object r8 = r8.a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.m r10 = r12.a
            r10.a((long) r8)
        L_0x01a8:
            boolean r8 = com.applovin.impl.sdk.u.a()
            if (r8 == 0) goto L_0x01dd
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.m r4 = r12.a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x01c4
            goto L_0x01c5
        L_0x01c4:
            r2 = r3
        L_0x01c5:
            r8.append(r2)
            r8.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r12.a(r0)
        L_0x01dd:
            return
        L_0x01de:
            r8 = move-exception
            com.applovin.impl.sdk.m r9 = r12.a
            com.applovin.impl.sdk.b.f r9 = r9.al()
            r9.a()
            com.applovin.impl.sdk.m r9 = r12.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.d.b.aB
            java.lang.Object r9 = r9.a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x020b
            com.applovin.impl.sdk.m r9 = r12.a
            com.applovin.impl.sdk.d.b<java.lang.Long> r10 = com.applovin.impl.sdk.d.b.aC
            java.lang.Object r9 = r9.a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            com.applovin.impl.sdk.m r11 = r12.a
            r11.a((long) r9)
        L_0x020b:
            boolean r9 = com.applovin.impl.sdk.u.a()
            if (r9 == 0) goto L_0x0240
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r9.append(r5)
            r9.append(r4)
            com.applovin.impl.sdk.m r4 = r12.a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x0227
            goto L_0x0228
        L_0x0227:
            r2 = r3
        L_0x0228:
            r9.append(r2)
            r9.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r12.a(r0)
        L_0x0240:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.f.n.run():void");
    }
}
