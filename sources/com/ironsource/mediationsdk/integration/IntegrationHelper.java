package com.ironsource.mediationsdk.integration;

import android.content.Context;
import android.util.Log;
import com.ironsource.mediationsdk.IntegrationData;

public class IntegrationHelper {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[Catch:{ Exception -> 0x010d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "IntegrationHelper"
            java.lang.String r1 = ", please update your adapter to version 4.1.*"
            r2 = 0
            java.lang.String r3 = com.ironsource.environment.StringUtils.toLowerCase(r9)     // Catch:{ Exception -> 0x010d }
            int r4 = r3.hashCode()     // Catch:{ Exception -> 0x010d }
            r5 = -1875652737(0xffffffff9033cf7f, float:-3.5461375E-29)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L_0x0033
            r5 = 92668925(0x58603fd, float:1.2602765E-35)
            if (r4 == r5) goto L_0x0029
            r5 = 497130182(0x1da19ac6, float:4.2776377E-21)
            if (r4 == r5) goto L_0x001f
            goto L_0x003e
        L_0x001f:
            java.lang.String r4 = "facebook"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x010d }
            if (r3 == 0) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x0029:
            java.lang.String r4 = "admob"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x010d }
            if (r3 == 0) goto L_0x003e
            r3 = 2
            goto L_0x003f
        L_0x0033:
            java.lang.String r4 = "supersonicads"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x010d }
            if (r3 == 0) goto L_0x003e
            r3 = 0
            goto L_0x003f
        L_0x003e:
            r3 = -1
        L_0x003f:
            if (r3 == 0) goto L_0x0062
            if (r3 == r7) goto L_0x005f
            if (r3 == r6) goto L_0x005c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "--------------- "
            r3.<init>(r4)     // Catch:{ Exception -> 0x010d }
            r3.append(r9)     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = " --------------"
            r3.append(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x010d }
        L_0x0058:
            android.util.Log.i(r0, r3)     // Catch:{ Exception -> 0x010d }
            goto L_0x0065
        L_0x005c:
            java.lang.String r3 = "--------------- Google (AdMob and Ad Manager) --------------"
            goto L_0x0058
        L_0x005f:
            java.lang.String r3 = "--------------- Meta --------------"
            goto L_0x0058
        L_0x0062:
            java.lang.String r3 = "--------------- IronSource --------------"
            goto L_0x0058
        L_0x0065:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "com.ironsource.adapters."
            r3.<init>(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = com.ironsource.environment.StringUtils.toLowerCase(r9)     // Catch:{ Exception -> 0x010d }
            r3.append(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "."
            r3.append(r4)     // Catch:{ Exception -> 0x010d }
            r3.append(r9)     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "Adapter"
            r3.append(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x010d }
            com.ironsource.mediationsdk.IntegrationData r8 = b(r8, r3)     // Catch:{ Exception -> 0x010d }
            if (r8 != 0) goto L_0x008b
            return r2
        L_0x008b:
            java.lang.String r4 = "SupersonicAds"
            boolean r4 = r9.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x010d }
            if (r4 != 0) goto L_0x00dd
            java.lang.String r4 = r8.version     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = "4.1"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Exception -> 0x010d }
            if (r4 != 0) goto L_0x00d4
            java.lang.String r4 = r8.version     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = "4.3"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Exception -> 0x010d }
            if (r4 == 0) goto L_0x00a8
            goto L_0x00d4
        L_0x00a8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            r4.<init>()     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = r8.name     // Catch:{ Exception -> 0x010d }
            r4.append(r5)     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = " adapter "
            r4.append(r5)     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = r8.version     // Catch:{ Exception -> 0x010d }
            r4.append(r8)     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = " is incompatible with SDK version "
            r4.append(r8)     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSDKVersion()     // Catch:{ Exception -> 0x010d }
            r4.append(r8)     // Catch:{ Exception -> 0x010d }
            r4.append(r1)     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x010d }
            android.util.Log.e(r0, r8)     // Catch:{ Exception -> 0x010d }
            r8 = 0
            goto L_0x00da
        L_0x00d4:
            java.lang.String r8 = "Adapter - VERIFIED"
            android.util.Log.i(r0, r8)     // Catch:{ Exception -> 0x010d }
            r8 = 1
        L_0x00da:
            if (r8 != 0) goto L_0x00dd
            return r2
        L_0x00dd:
            java.lang.Class r8 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = "getAdapterSDKVersion"
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0104 }
            java.lang.reflect.Method r8 = r8.getMethod(r1, r3)     // Catch:{ Exception -> 0x0104 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0104 }
            r3 = 0
            java.lang.Object r8 = r8.invoke(r3, r1)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            java.lang.String r3 = "SDK Version - "
            r1.<init>(r3)     // Catch:{ Exception -> 0x0104 }
            r1.append(r8)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0104 }
            android.util.Log.i(r0, r8)     // Catch:{ Exception -> 0x0104 }
            goto L_0x010c
        L_0x0104:
            java.lang.String r8 = "validateSDKVersion"
            java.lang.String r1 = "Unable to get SDK version"
            android.util.Log.w(r8, r1)     // Catch:{ Exception -> 0x010d }
        L_0x010c:
            return r7
        L_0x010d:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "isAdapterValid "
            r1.<init>(r3)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            android.util.Log.e(r0, r9, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.a(android.content.Context, java.lang.String):boolean");
    }

    private static IntegrationData b(Context context, String str) {
        String str2;
        try {
            IntegrationData integrationData = (IntegrationData) Class.forName(str).getMethod("getIntegrationData", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            Log.i("IntegrationHelper", "Adapter " + integrationData.version + " - VERIFIED");
            return integrationData;
        } catch (ClassNotFoundException unused) {
            str2 = "Adapter - MISSING";
            Log.e("IntegrationHelper", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "Adapter version - NOT VERIFIED";
            Log.e("IntegrationHelper", str2);
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        if (r6.equals(com.facebook.AccessToken.DEFAULT_GRAPH_DOMAIN) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e0, code lost:
        if (r6.equals(com.facebook.AccessToken.DEFAULT_GRAPH_DOMAIN) == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0114, code lost:
        android.util.Log.e("IntegrationHelper", r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void validateIntegration(android.content.Context r23) {
        /*
            r0 = r23
            java.lang.String r1 = "Verifying Integration:"
            java.lang.String r2 = "IntegrationHelper"
            android.util.Log.i(r2, r1)
            java.lang.String r1 = "*** Permissions ***"
            android.util.Log.i(r2, r1)
            android.content.pm.PackageManager r1 = r23.getPackageManager()
            java.lang.String r3 = "android.permission.INTERNET"
            java.lang.String r4 = r23.getPackageName()
            int r3 = r1.checkPermission(r3, r4)
            if (r3 != 0) goto L_0x0024
            java.lang.String r3 = "android.permission.INTERNET - VERIFIED"
            android.util.Log.i(r2, r3)
            goto L_0x0029
        L_0x0024:
            java.lang.String r3 = "android.permission.INTERNET - MISSING"
            android.util.Log.e(r2, r3)
        L_0x0029:
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            java.lang.String r4 = r23.getPackageName()
            int r1 = r1.checkPermission(r3, r4)
            if (r1 != 0) goto L_0x003b
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE - VERIFIED"
            android.util.Log.i(r2, r1)
            goto L_0x0040
        L_0x003b:
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE - MISSING"
            android.util.Log.e(r2, r1)
        L_0x0040:
            java.lang.String r3 = "AdColony"
            java.lang.String r4 = "AppLovin"
            java.lang.String r5 = "APS"
            java.lang.String r6 = "BidMachine"
            java.lang.String r7 = "Chartboost"
            java.lang.String r8 = "Fyber"
            java.lang.String r9 = "AdMob"
            java.lang.String r10 = "HyprMX"
            java.lang.String r11 = "InMobi"
            java.lang.String r12 = "SupersonicAds"
            java.lang.String r13 = "Maio"
            java.lang.String r14 = "Facebook"
            java.lang.String r15 = "Mintegral"
            java.lang.String r16 = "MyTarget"
            java.lang.String r17 = "Pangle"
            java.lang.String r18 = "Smaato"
            java.lang.String r19 = "SuperAwesome"
            java.lang.String r20 = "Tapjoy"
            java.lang.String r21 = "UnityAds"
            java.lang.String r22 = "Vungle"
            java.lang.String[] r1 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}
            r3 = 0
            r4 = 0
        L_0x006e:
            r5 = 20
            if (r4 >= r5) goto L_0x011b
            r5 = r1[r4]
            boolean r6 = a(r0, r5)
            java.lang.String r7 = ">>>> "
            r8 = 2
            java.lang.String r9 = "facebook"
            java.lang.String r10 = "admob"
            java.lang.String r11 = "supersonicads"
            r12 = -1
            r13 = 1
            if (r6 == 0) goto L_0x00cc
            java.lang.String r6 = com.ironsource.environment.StringUtils.toLowerCase(r5)
            r6.hashCode()
            int r14 = r6.hashCode()
            switch(r14) {
                case -1875652737: goto L_0x00a6;
                case 92668925: goto L_0x009d;
                case 497130182: goto L_0x0096;
                default: goto L_0x0094;
            }
        L_0x0094:
            r8 = -1
            goto L_0x00ae
        L_0x0096:
            boolean r6 = r6.equals(r9)
            if (r6 != 0) goto L_0x00ae
            goto L_0x0094
        L_0x009d:
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x00a4
            goto L_0x0094
        L_0x00a4:
            r8 = 1
            goto L_0x00ae
        L_0x00a6:
            boolean r6 = r6.equals(r11)
            if (r6 != 0) goto L_0x00ad
            goto L_0x0094
        L_0x00ad:
            r8 = 0
        L_0x00ae:
            switch(r8) {
                case 0: goto L_0x00c9;
                case 1: goto L_0x00c6;
                case 2: goto L_0x00c3;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = " - VERIFIED"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L_0x010b
        L_0x00c3:
            java.lang.String r5 = ">>>> Meta - VERIFIED"
            goto L_0x010b
        L_0x00c6:
            java.lang.String r5 = ">>>> Google (AdMob and Ad Manager) - VERIFIED"
            goto L_0x010b
        L_0x00c9:
            java.lang.String r5 = ">>>> IronSource - VERIFIED"
            goto L_0x010b
        L_0x00cc:
            java.lang.String r6 = com.ironsource.environment.StringUtils.toLowerCase(r5)
            r6.hashCode()
            int r14 = r6.hashCode()
            switch(r14) {
                case -1875652737: goto L_0x00ec;
                case 92668925: goto L_0x00e3;
                case 497130182: goto L_0x00dc;
                default: goto L_0x00da;
            }
        L_0x00da:
            r8 = -1
            goto L_0x00f4
        L_0x00dc:
            boolean r6 = r6.equals(r9)
            if (r6 != 0) goto L_0x00f4
            goto L_0x00da
        L_0x00e3:
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x00ea
            goto L_0x00da
        L_0x00ea:
            r8 = 1
            goto L_0x00f4
        L_0x00ec:
            boolean r6 = r6.equals(r11)
            if (r6 != 0) goto L_0x00f3
            goto L_0x00da
        L_0x00f3:
            r8 = 0
        L_0x00f4:
            switch(r8) {
                case 0: goto L_0x0112;
                case 1: goto L_0x010f;
                case 2: goto L_0x0109;
                default: goto L_0x00f7;
            }
        L_0x00f7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = " - NOT VERIFIED"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L_0x0114
        L_0x0109:
            java.lang.String r5 = ">>>> Meta - NOT VERIFIED"
        L_0x010b:
            android.util.Log.i(r2, r5)
            goto L_0x0117
        L_0x010f:
            java.lang.String r5 = ">>>> Google (AdMob and Ad Manager) - NOT VERIFIED"
            goto L_0x010b
        L_0x0112:
            java.lang.String r5 = ">>>> IronSource - NOT VERIFIED"
        L_0x0114:
            android.util.Log.e(r2, r5)
        L_0x0117:
            int r4 = r4 + 1
            goto L_0x006e
        L_0x011b:
            com.ironsource.mediationsdk.integration.IntegrationHelper$1 r1 = new com.ironsource.mediationsdk.integration.IntegrationHelper$1
            r1.<init>(r0)
            r1.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.integration.IntegrationHelper.validateIntegration(android.content.Context):void");
    }
}
