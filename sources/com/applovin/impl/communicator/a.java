package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

public class a {
    private final Context a;
    private final Set<b> b = new HashSet(32);
    private final Object c = new Object();

    public a(Context context) {
        this.a = context;
    }

    private b a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (b next : this.b) {
            if (str.equals(next.a()) && appLovinCommunicatorSubscriber.equals(next.b())) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.applovin.communicator.AppLovinCommunicatorSubscriber r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Attempting to re-subscribe subscriber ("
            if (r7 == 0) goto L_0x006f
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r8)
            if (r1 != 0) goto L_0x000b
            goto L_0x006f
        L_0x000b:
            java.lang.Object r1 = r6.c
            monitor-enter(r1)
            com.applovin.impl.communicator.b r2 = r6.a((java.lang.String) r8, (com.applovin.communicator.AppLovinCommunicatorSubscriber) r7)     // Catch:{ all -> 0x006c }
            r3 = 1
            if (r2 == 0) goto L_0x0052
            boolean r4 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = "AppLovinCommunicator"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r5.<init>(r0)     // Catch:{ all -> 0x006c }
            r5.append(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r7 = ") to topic ("
            r5.append(r7)     // Catch:{ all -> 0x006c }
            r5.append(r8)     // Catch:{ all -> 0x006c }
            java.lang.String r7 = ")"
            r5.append(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x006c }
            com.applovin.impl.sdk.u.i(r4, r7)     // Catch:{ all -> 0x006c }
        L_0x0039:
            boolean r7 = r2.c()     // Catch:{ all -> 0x006c }
            if (r7 != 0) goto L_0x0050
            r2.a(r3)     // Catch:{ all -> 0x006c }
            android.content.Context r7 = r6.a     // Catch:{ all -> 0x006c }
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)     // Catch:{ all -> 0x006c }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x006c }
            r0.<init>(r8)     // Catch:{ all -> 0x006c }
            r7.registerReceiver(r2, r0)     // Catch:{ all -> 0x006c }
        L_0x0050:
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            return r3
        L_0x0052:
            com.applovin.impl.communicator.b r0 = new com.applovin.impl.communicator.b     // Catch:{ all -> 0x006c }
            r0.<init>(r8, r7)     // Catch:{ all -> 0x006c }
            java.util.Set<com.applovin.impl.communicator.b> r7 = r6.b     // Catch:{ all -> 0x006c }
            r7.add(r0)     // Catch:{ all -> 0x006c }
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            android.content.Context r7 = r6.a
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)
            android.content.IntentFilter r1 = new android.content.IntentFilter
            r1.<init>(r8)
            r7.registerReceiver(r0, r1)
            return r3
        L_0x006c:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r7
        L_0x006f:
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x0095
            java.lang.String r0 = "AppLovinCommunicator"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to subscribe - invalid subscriber ("
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = ") or topic ("
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = ")"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.applovin.impl.sdk.u.i(r0, r7)
        L_0x0095:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.communicator.a.a(com.applovin.communicator.AppLovinCommunicatorSubscriber, java.lang.String):boolean");
    }

    public boolean a(String str) {
        synchronized (this.c) {
            for (b a2 : this.b) {
                if (str.equals(a2.a())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        b a2;
        if (StringUtils.isValidString(str)) {
            synchronized (this.c) {
                a2 = a(str, appLovinCommunicatorSubscriber);
            }
            if (a2 != null) {
                a2.a(false);
                AppLovinBroadcastManager.getInstance(this.a).unregisterReceiver(a2);
            }
        }
    }
}
