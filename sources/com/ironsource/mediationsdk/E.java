package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.c.e;
import com.ironsource.environment.j;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.h;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.z;
import com.ironsource.sdk.a.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class E implements j {
    private static E t;
    private c A = new c() {
        /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01f1 A[Catch:{ Exception -> 0x0345 }, LOOP:0: B:70:0x01eb->B:72:0x01f1, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0240 A[Catch:{ Exception -> 0x0345 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r11 = this;
                com.ironsource.mediationsdk.z r0 = com.ironsource.mediationsdk.z.a()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.V r1 = com.ironsource.mediationsdk.V.a()     // Catch:{ Exception -> 0x0345 }
                java.lang.Thread r2 = new java.lang.Thread     // Catch:{ Exception -> 0x0016 }
                com.ironsource.mediationsdk.V$1 r3 = new com.ironsource.mediationsdk.V$1     // Catch:{ Exception -> 0x0016 }
                r3.<init>()     // Catch:{ Exception -> 0x0016 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0016 }
                r2.start()     // Catch:{ Exception -> 0x0016 }
                goto L_0x001a
            L_0x0016:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ Exception -> 0x0345 }
            L_0x001a:
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.lang.String r1 = r1.l     // Catch:{ Exception -> 0x0345 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0345 }
                if (r1 != 0) goto L_0x0032
                com.ironsource.mediationsdk.sdk.c r1 = com.ironsource.mediationsdk.sdk.c.a()     // Catch:{ Exception -> 0x0345 }
                java.lang.String r2 = "userId"
                com.ironsource.mediationsdk.E r3 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.lang.String r3 = r3.l     // Catch:{ Exception -> 0x0345 }
                r1.a(r2, r3)     // Catch:{ Exception -> 0x0345 }
            L_0x0032:
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.lang.String r1 = r1.m     // Catch:{ Exception -> 0x0345 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0345 }
                if (r1 != 0) goto L_0x0049
                com.ironsource.mediationsdk.sdk.c r1 = com.ironsource.mediationsdk.sdk.c.a()     // Catch:{ Exception -> 0x0345 }
                java.lang.String r2 = "appKey"
                com.ironsource.mediationsdk.E r3 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.lang.String r3 = r3.m     // Catch:{ Exception -> 0x0345 }
                r1.a(r2, r3)     // Catch:{ Exception -> 0x0345 }
            L_0x0049:
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.b.a r1 = r1.r     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r2 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.lang.String r2 = r2.l     // Catch:{ Exception -> 0x0345 }
                r1.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x0345 }
                r2.<init>()     // Catch:{ Exception -> 0x0345 }
                long r2 = r2.getTime()     // Catch:{ Exception -> 0x0345 }
                r1.q = r2     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ Exception -> 0x0345 }
                android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r3 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.lang.String r3 = r3.l     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.z$a r4 = r11.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r2 = r0.a((android.content.Context) r2, (java.lang.String) r3, (com.ironsource.mediationsdk.z.a) r4)     // Catch:{ Exception -> 0x0345 }
                r1.n = r2     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r1 = r1.n     // Catch:{ Exception -> 0x0345 }
                r2 = 1
                if (r1 == 0) goto L_0x0298
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                android.os.Handler r1 = r1.i     // Catch:{ Exception -> 0x0345 }
                r1.removeCallbacks(r11)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r1 = r1.n     // Catch:{ Exception -> 0x0345 }
                boolean r1 = r1.b()     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x026d
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E$a r2 = com.ironsource.mediationsdk.E.a.INITIATED     // Catch:{ Exception -> 0x0345 }
                r1.a((com.ironsource.mediationsdk.E.a) r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r2 = r1.n     // Catch:{ Exception -> 0x0345 }
                r1.a((com.ironsource.mediationsdk.utils.k) r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                boolean r2 = r0.k()     // Catch:{ Exception -> 0x0345 }
                r1.b(r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r1 = r1.n     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.f r1 = r1.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.sdk.a.g r1 = r1.f()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.b r1 = r1.f()     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x00da
                com.ironsource.environment.g r2 = com.ironsource.environment.g.a     // Catch:{ Exception -> 0x0345 }
                boolean r2 = r1.a()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.g.a((boolean) r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.g r2 = com.ironsource.environment.g.a     // Catch:{ Exception -> 0x0345 }
                boolean r2 = r1.b()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.g.c(r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.g r2 = com.ironsource.environment.g.a     // Catch:{ Exception -> 0x0345 }
                int r2 = r1.c()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.g.a((int) r2)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.thread.IronSourceThreadManager r2 = com.ironsource.environment.thread.IronSourceThreadManager.INSTANCE     // Catch:{ Exception -> 0x0345 }
                boolean r1 = r1.d()     // Catch:{ Exception -> 0x0345 }
                r2.setUseSharedExecutorService(r1)     // Catch:{ Exception -> 0x0345 }
            L_0x00da:
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ Exception -> 0x0345 }
                android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r3 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r3 = r3.n     // Catch:{ Exception -> 0x0345 }
                r1.a(r2, r3)     // Catch:{ Exception -> 0x0345 }
                java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x0345 }
                r1.<init>()     // Catch:{ Exception -> 0x0345 }
                long r1 = r1.getTime()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r3 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                long r3 = r3.q     // Catch:{ Exception -> 0x0345 }
                long r1 = r1 - r3
                boolean r3 = r0.k()     // Catch:{ Exception -> 0x0345 }
                org.json.JSONObject r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3)     // Catch:{ Exception -> 0x0345 }
                java.lang.String r4 = "duration"
                r3.put(r4, r1)     // Catch:{ Exception -> 0x010e }
                java.lang.String r1 = "sessionDepth"
                int r0 = r0.q     // Catch:{ Exception -> 0x010e }
                r3.put(r1, r0)     // Catch:{ Exception -> 0x010e }
                goto L_0x0112
            L_0x010e:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ Exception -> 0x0345 }
            L_0x0112:
                com.ironsource.environment.c.a r0 = new com.ironsource.environment.c.a     // Catch:{ Exception -> 0x0345 }
                r1 = 514(0x202, float:7.2E-43)
                r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.events.i r1 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ Exception -> 0x0345 }
                r1.a((com.ironsource.environment.c.a) r0)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.T r1 = new com.ironsource.mediationsdk.T     // Catch:{ Exception -> 0x0345 }
                r1.<init>()     // Catch:{ Exception -> 0x0345 }
                r0.a = r1     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.T r0 = r0.a     // Catch:{ Exception -> 0x0345 }
                r0.a()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r0 = r0.n     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.f r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.sdk.a.g r0 = r0.f()     // Catch:{ Exception -> 0x0345 }
                boolean r0 = r0.d()     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x0155
                com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ Exception -> 0x0345 }
                android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x0155
                com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ Exception -> 0x0345 }
                android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.integration.IntegrationHelper.validateIntegration(r0)     // Catch:{ Exception -> 0x0345 }
            L_0x0155:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r0 = r0.n     // Catch:{ Exception -> 0x0345 }
                org.json.JSONObject r1 = r0.d     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x01e2
                com.ironsource.mediationsdk.model.f r1 = r0.c     // Catch:{ Exception -> 0x0345 }
                if (r1 != 0) goto L_0x0163
                goto L_0x01e2
            L_0x0163:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0345 }
                r1.<init>()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.f r2 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.q r2 = r2.a()     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x0183
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x0183
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                java.util.ArrayList<java.lang.String> r2 = r2.a     // Catch:{ Exception -> 0x0345 }
                boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0345 }
                if (r2 != 0) goto L_0x0183
                com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ Exception -> 0x0345 }
                r1.add(r2)     // Catch:{ Exception -> 0x0345 }
            L_0x0183:
                com.ironsource.mediationsdk.model.f r2 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.h r2 = r2.b()     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x019e
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x019e
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                java.util.ArrayList<java.lang.String> r2 = r2.b     // Catch:{ Exception -> 0x0345 }
                boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0345 }
                if (r2 != 0) goto L_0x019e
                com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ Exception -> 0x0345 }
                r1.add(r2)     // Catch:{ Exception -> 0x0345 }
            L_0x019e:
                com.ironsource.mediationsdk.model.f r2 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.k r2 = r2.c()     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x01ab
                com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ Exception -> 0x0345 }
                r1.add(r2)     // Catch:{ Exception -> 0x0345 }
            L_0x01ab:
                com.ironsource.mediationsdk.model.f r2 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.d r2 = r2.d()     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x01c6
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x01c6
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                java.util.ArrayList<java.lang.String> r2 = r2.c     // Catch:{ Exception -> 0x0345 }
                boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0345 }
                if (r2 != 0) goto L_0x01c6
                com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ Exception -> 0x0345 }
                r1.add(r2)     // Catch:{ Exception -> 0x0345 }
            L_0x01c6:
                com.ironsource.mediationsdk.model.f r2 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.i r2 = r2.e()     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x01e3
                com.ironsource.mediationsdk.model.o r2 = r0.a     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x01e3
                com.ironsource.mediationsdk.model.o r0 = r0.a     // Catch:{ Exception -> 0x0345 }
                java.util.ArrayList<java.lang.String> r0 = r0.d     // Catch:{ Exception -> 0x0345 }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0345 }
                if (r0 != 0) goto L_0x01e3
                com.ironsource.mediationsdk.IronSource$AD_UNIT r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ Exception -> 0x0345 }
                r1.add(r0)     // Catch:{ Exception -> 0x0345 }
                goto L_0x01e3
            L_0x01e2:
                r1 = 0
            L_0x01e3:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.util.List<com.ironsource.mediationsdk.utils.h> r0 = r0.k     // Catch:{ Exception -> 0x0345 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0345 }
            L_0x01eb:
                boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0345 }
                if (r2 == 0) goto L_0x0205
                java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.h r2 = (com.ironsource.mediationsdk.utils.h) r2     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r3 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                boolean r3 = r3.g     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r4 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r4 = r4.n     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.f r4 = r4.c     // Catch:{ Exception -> 0x0345 }
                r2.a(r1, r3, r4)     // Catch:{ Exception -> 0x0345 }
                goto L_0x01eb
            L_0x0205:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.sdk.SegmentListener r0 = r0.o     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x022c
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r0 = r0.n     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.f r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.sdk.a.g r0 = r0.f()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.r r0 = r0.b()     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x022c
                java.lang.String r1 = r0.a     // Catch:{ Exception -> 0x0345 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0345 }
                if (r1 != 0) goto L_0x022c
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.sdk.SegmentListener r1 = r1.o     // Catch:{ Exception -> 0x0345 }
                java.lang.String r0 = r0.a     // Catch:{ Exception -> 0x0345 }
                r1.onSegmentReceived(r0)     // Catch:{ Exception -> 0x0345 }
            L_0x022c:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.k r0 = r0.n     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.model.f r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.sdk.a.g r0 = r0.f()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.sdk.f.a r0 = r0.e()     // Catch:{ Exception -> 0x0345 }
                boolean r1 = r0.b()     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x0349
                java.lang.String r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSessionId()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.e r2 = com.ironsource.environment.e.a()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ Exception -> 0x0345 }
                android.content.Context r3 = r1.getApplicationContext()     // Catch:{ Exception -> 0x0345 }
                java.util.HashSet r4 = r0.a()     // Catch:{ Exception -> 0x0345 }
                java.lang.String r5 = r0.c()     // Catch:{ Exception -> 0x0345 }
                java.lang.String r6 = r0.d()     // Catch:{ Exception -> 0x0345 }
                boolean r7 = r0.e()     // Catch:{ Exception -> 0x0345 }
                int r9 = r0.f()     // Catch:{ Exception -> 0x0345 }
                boolean r10 = r0.g()     // Catch:{ Exception -> 0x0345 }
                r2.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0345 }
                goto L_0x0349
            L_0x026d:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                boolean r0 = r0.h     // Catch:{ Exception -> 0x0345 }
                if (r0 != 0) goto L_0x0344
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ Exception -> 0x0345 }
                r0.a((com.ironsource.mediationsdk.E.a) r1)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                r0.h = r2     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.util.List<com.ironsource.mediationsdk.utils.h> r0 = r0.k     // Catch:{ Exception -> 0x0345 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0345 }
            L_0x0286:
                boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x0349
                java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.h r1 = (com.ironsource.mediationsdk.utils.h) r1     // Catch:{ Exception -> 0x0345 }
                java.lang.String r2 = "serverResponseIsNotValid"
                r1.a(r2)     // Catch:{ Exception -> 0x0345 }
                goto L_0x0286
            L_0x0298:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                r1 = 3
                if (r0 != r1) goto L_0x02bb
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                r0.p = r2     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.util.List<com.ironsource.mediationsdk.utils.h> r0 = r0.k     // Catch:{ Exception -> 0x0345 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0345 }
            L_0x02ab:
                boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x02bb
                java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.h r1 = (com.ironsource.mediationsdk.utils.h) r1     // Catch:{ Exception -> 0x0345 }
                r1.c()     // Catch:{ Exception -> 0x0345 }
                goto L_0x02ab
            L_0x02bb:
                boolean r0 = r11.a     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x02ed
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r1 = r1.d     // Catch:{ Exception -> 0x0345 }
                if (r0 >= r1) goto L_0x02ed
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                r0.g = r2     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                android.os.Handler r0 = r0.i     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r1 = r1.b     // Catch:{ Exception -> 0x0345 }
                int r1 = r1 * 1000
                long r3 = (long) r1     // Catch:{ Exception -> 0x0345 }
                r0.postDelayed(r11, r3)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r1 = r1.e     // Catch:{ Exception -> 0x0345 }
                if (r0 >= r1) goto L_0x02ed
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r1 = r0.b     // Catch:{ Exception -> 0x0345 }
                int r1 = r1 * 2
                r0.b = r1     // Catch:{ Exception -> 0x0345 }
            L_0x02ed:
                boolean r0 = r11.a     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x02fb
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r0 = r0.c     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r1 = r1.f     // Catch:{ Exception -> 0x0345 }
                if (r0 != r1) goto L_0x033d
            L_0x02fb:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                boolean r0 = r0.h     // Catch:{ Exception -> 0x0345 }
                if (r0 != 0) goto L_0x033d
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                r0.h = r2     // Catch:{ Exception -> 0x0345 }
                java.lang.String r0 = r11.b     // Catch:{ Exception -> 0x0345 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0345 }
                if (r0 == 0) goto L_0x0311
                java.lang.String r0 = "noServerResponse"
                r11.b = r0     // Catch:{ Exception -> 0x0345 }
            L_0x0311:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                java.util.List<com.ironsource.mediationsdk.utils.h> r0 = r0.k     // Catch:{ Exception -> 0x0345 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0345 }
            L_0x0319:
                boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0345 }
                if (r1 == 0) goto L_0x032b
                java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.utils.h r1 = (com.ironsource.mediationsdk.utils.h) r1     // Catch:{ Exception -> 0x0345 }
                java.lang.String r3 = r11.b     // Catch:{ Exception -> 0x0345 }
                r1.a(r3)     // Catch:{ Exception -> 0x0345 }
                goto L_0x0319
            L_0x032b:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ Exception -> 0x0345 }
                r0.a((com.ironsource.mediationsdk.E.a) r1)     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ Exception -> 0x0345 }
                com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ Exception -> 0x0345 }
                java.lang.String r3 = "Mediation availability false reason: No server response"
                r0.log(r1, r3, r2)     // Catch:{ Exception -> 0x0345 }
            L_0x033d:
                com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.this     // Catch:{ Exception -> 0x0345 }
                int r1 = r0.c     // Catch:{ Exception -> 0x0345 }
                int r1 = r1 + r2
                r0.c = r1     // Catch:{ Exception -> 0x0345 }
            L_0x0344:
                return
            L_0x0345:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0349:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.E.AnonymousClass1.run():void");
        }
    };
    T a;
    int b = 1;
    int c = 0;
    int d = 62;
    int e = 12;
    int f = 5;
    boolean g = false;
    boolean h = false;
    Handler i = IronSourceThreadManager.INSTANCE.getInitHandler();
    CountDownTimer j;
    List<h> k = new ArrayList();
    String l = "";
    String m;
    k n;
    SegmentListener o;
    boolean p = false;
    long q;
    com.ironsource.mediationsdk.b.a r = new com.ironsource.mediationsdk.b.a();
    private int s = b.e;
    private final String u = "appKey";
    private final String v = getClass().getSimpleName();
    private boolean w = false;
    private AtomicBoolean x = new AtomicBoolean(true);
    private NetworkStateReceiver y;
    private a z = a.NOT_INIT;

    /* renamed from: com.ironsource.mediationsdk.E$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.ironsource.mediationsdk.E$a[] r0 = com.ironsource.mediationsdk.E.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.INIT_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.NOT_INIT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.INITIATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.E.AnonymousClass3.<clinit>():void");
        }
    }

    public enum a {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    public static class b {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
        public static int d = 3;
        public static int e = 4;
    }

    abstract class c implements Runnable {
        boolean a = true;
        String b;
        protected z.a c = new z.a() {
            public final void a(String str) {
                c.this.a = false;
                c.this.b = str;
            }
        };

        c() {
        }
    }

    private E() {
    }

    public static synchronized E a() {
        E e2;
        synchronized (E.class) {
            if (t == null) {
                t = new E();
            }
            e2 = t;
        }
        return e2;
    }

    public final void a(Context context, k kVar) {
        this.r.a(kVar.a().b());
        e.a("apky", (Object) kVar.a().a());
        g f2 = kVar.c.f();
        e.a("audt", (Object) f2.i().a());
        e.a("tkgp", (Object) f2.c().c);
        e.a("fs", (Object) Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
    }

    public final synchronized void a(Context context, String str, String str2) {
        try {
            AtomicBoolean atomicBoolean = this.x;
            if (atomicBoolean == null || !atomicBoolean.compareAndSet(true, false)) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                logger.log(ironSourceTag, this.v + ": Multiple calls to init are not allowed", 2);
                return;
            }
            a(a.INIT_IN_PROGRESS);
            this.l = str2;
            this.m = str;
            if (IronSourceUtils.isNetworkConnected(context)) {
                this.i.post(this.A);
            } else {
                this.w = true;
                if (this.y == null) {
                    this.y = new NetworkStateReceiver(context, this);
                }
                context.registerReceiver(this.y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                    public final void run() {
                        E.this.j = new CountDownTimer(60000, 15000) {
                            public final void onFinish() {
                                if (!E.this.h) {
                                    E.this.h = true;
                                    for (h a2 : E.this.k) {
                                        a2.a(IronSourceConstants.FALSE_AVAILABILITY_REASON_NO_INTERNET);
                                    }
                                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
                                }
                            }

                            public final void onTick(long j) {
                                if (j <= 45000) {
                                    E.this.p = true;
                                    for (h c : E.this.k) {
                                        c.c();
                                    }
                                }
                            }
                        }.start();
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("old status: " + this.z + ", new status: " + aVar + ")");
        this.z = aVar;
    }

    public final void a(h hVar) {
        if (hVar != null) {
            this.k.add(hVar);
        }
    }

    public final synchronized void a(k kVar) {
        int i2;
        int i3 = kVar != null ? kVar.e : k.a.a;
        a aVar = this.z;
        if (i3 == k.a.b) {
            i2 = b.c;
        } else {
            int i4 = AnonymousClass3.a[aVar.ordinal()];
            i2 = i4 != 1 ? i4 != 2 ? i4 != 3 ? b.a : b.b : b.e : b.d;
        }
        this.s = i2;
        e.a("itp", (Object) Integer.valueOf(i2));
    }

    public final void a(boolean z2) {
        if (this.w && z2) {
            CountDownTimer countDownTimer = this.j;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.w = false;
            this.g = true;
            this.i.post(this.A);
        }
    }

    public final synchronized a b() {
        return this.z;
    }

    public final void b(boolean z2) {
        Map<String, String> a2;
        if (z2 && TextUtils.isEmpty(z.a().k) && (a2 = this.n.c.f().g().a()) != null && !a2.isEmpty()) {
            for (String next : a2.keySet()) {
                if (IronSourceUtils.doesClassExist(next)) {
                    String str = a2.get(next);
                    if (!TextUtils.isEmpty(str)) {
                        next = str;
                    }
                    z.a().d(next);
                    return;
                }
            }
        }
    }

    public final synchronized boolean c() {
        return this.p;
    }
}
