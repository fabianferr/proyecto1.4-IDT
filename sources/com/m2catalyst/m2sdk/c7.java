package com.m2catalyst.m2sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import com.m2catalyst.m2sdk.database.entities.WifiEntity;
import com.m2catalyst.m2sdk.external.SDKState;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WifiCollectionManager.kt */
public final class c7 {
    public final Context a;
    public final g2 b;
    public final z3 c;
    public final WifiRepository d;
    public final z5 e;
    public final ConnectivityManager f;
    public boolean g;
    public String h;
    public final e i = new e(this);

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.wifi.WifiCollectionManager", f = "WifiCollectionManager.kt", i = {0, 0}, l = {99}, m = "collectIfNeeded", n = {"this", "newWifiConnected"}, s = {"L$0", "I$0"})
    /* compiled from: WifiCollectionManager.kt */
    public static final class a extends ContinuationImpl {
        public c7 a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ c7 d;
        public int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c7 c7Var, Continuation<? super a> continuation) {
            super(continuation);
            this.d = c7Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a(this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.wifi.WifiCollectionManager", f = "WifiCollectionManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {139, 143, 149}, m = "collectWifiRecordIfPossible", n = {"this", "wifiInfo", "this", "wifiInfo", "wifiEntity", "this", "wifiInfo", "wifi"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    /* compiled from: WifiCollectionManager.kt */
    public static final class b extends ContinuationImpl {
        public c7 a;
        public WifiInfo b;
        public Object c;
        public WifiEntity d;
        public /* synthetic */ Object e;
        public final /* synthetic */ c7 f;
        public int g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c7 c7Var, Continuation<? super b> continuation) {
            super(continuation);
            this.f = c7Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return this.f.b(this);
        }
    }

    /* compiled from: WifiCollectionManager.kt */
    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ ByteBuffer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ByteBuffer byteBuffer) {
            super(0);
            this.a = byteBuffer;
        }

        public final Object invoke() {
            return InetAddress.getByAddress(this.a.array()).getHostAddress();
        }
    }

    /* compiled from: WifiCollectionManager.kt */
    public static final class d extends Lambda implements Function0<List<ScanResult>> {
        public final /* synthetic */ WifiManager a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(WifiManager wifiManager) {
            super(0);
            this.a = wifiManager;
        }

        public final Object invoke() {
            return this.a.getScanResults();
        }
    }

    /* compiled from: WifiCollectionManager.kt */
    public static final class e extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ c7 a;

        @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.wifi.WifiCollectionManager$connectivityNetworkCallback$1$onAvailable$1", f = "WifiCollectionManager.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: WifiCollectionManager.kt */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ c7 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c7 c7Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = c7Var;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    c7 c7Var = this.b;
                    this.a = 1;
                    if (c7Var.a(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        public e(c7 c7Var) {
            this.a = c7Var;
        }

        public final void onAvailable(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            j3.b(new a(this.a, (Continuation<? super a>) null));
        }

        public final void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            c7 c7Var = this.a;
            c7Var.g = m4.c(c7Var.a);
            SDKState.Companion.getInstance().setWifiConnected$m2sdk_release(Boolean.valueOf(this.a.g));
        }

        public final void onUnavailable() {
            c7 c7Var = this.a;
            c7Var.g = m4.c(c7Var.a);
            SDKState.Companion.getInstance().setWifiConnected$m2sdk_release(Boolean.valueOf(this.a.g));
        }
    }

    public c7(Context context, g2 g2Var, z3 z3Var, WifiRepository wifiRepository, z5 z5Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(g2Var, "locationCollector");
        Intrinsics.checkNotNullParameter(z3Var, "dataUsageState");
        Intrinsics.checkNotNullParameter(wifiRepository, "wifiRepository");
        Intrinsics.checkNotNullParameter(z5Var, "sdkPreferences");
        this.a = context;
        this.b = g2Var;
        this.c = z3Var;
        this.d = wifiRepository;
        this.e = z5Var;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f = (ConnectivityManager) systemService;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.m2catalyst.m2sdk.c7.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.m2catalyst.m2sdk.c7$a r0 = (com.m2catalyst.m2sdk.c7.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.c7$a r0 = new com.m2catalyst.m2sdk.c7$a
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            int r1 = r0.b
            com.m2catalyst.m2sdk.c7 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005c
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            android.net.ConnectivityManager r6 = r5.f
            android.net.Network r2 = r6.getActiveNetwork()
            android.net.NetworkCapabilities r6 = r6.getNetworkCapabilities(r2)
            if (r6 == 0) goto L_0x004a
            boolean r6 = r6.hasTransport(r4)
            goto L_0x004b
        L_0x004a:
            r6 = 0
        L_0x004b:
            if (r6 == 0) goto L_0x005a
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r0 = r5.b(r0)
            if (r0 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r0 = r5
            r1 = r6
        L_0x005c:
            if (r1 == 0) goto L_0x005f
            r3 = 1
        L_0x005f:
            r0.g = r3
            com.m2catalyst.m2sdk.external.SDKState$Companion r6 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r6 = r6.getInstance()
            boolean r0 = r0.g
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r6.setWifiConnected$m2sdk_release(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.c7.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x02d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            boolean r2 = r1 instanceof com.m2catalyst.m2sdk.c7.b
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.m2catalyst.m2sdk.c7$b r2 = (com.m2catalyst.m2sdk.c7.b) r2
            int r3 = r2.g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.g = r3
            goto L_0x001c
        L_0x0017:
            com.m2catalyst.m2sdk.c7$b r2 = new com.m2catalyst.m2sdk.c7$b
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.e
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.g
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 0
            r9 = 1
            if (r4 == 0) goto L_0x0062
            if (r4 == r9) goto L_0x0053
            if (r4 == r6) goto L_0x0046
            if (r4 != r5) goto L_0x003e
            java.lang.Object r3 = r2.c
            com.m2catalyst.m2sdk.business.models.Wifi r3 = (com.m2catalyst.m2sdk.business.models.Wifi) r3
            android.net.wifi.WifiInfo r4 = r2.b
            com.m2catalyst.m2sdk.c7 r2 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x02d4
        L_0x003e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0046:
            java.lang.Object r4 = r2.c
            com.m2catalyst.m2sdk.database.entities.WifiEntity r4 = (com.m2catalyst.m2sdk.database.entities.WifiEntity) r4
            android.net.wifi.WifiInfo r6 = r2.b
            com.m2catalyst.m2sdk.c7 r10 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x02b2
        L_0x0053:
            com.m2catalyst.m2sdk.database.entities.WifiEntity r4 = r2.d
            java.lang.Object r10 = r2.c
            com.m2catalyst.m2sdk.c7 r10 = (com.m2catalyst.m2sdk.c7) r10
            android.net.wifi.WifiInfo r11 = r2.b
            com.m2catalyst.m2sdk.c7 r12 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0178
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r1)
            android.content.Context r1 = r0.a
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r4 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1
            if (r1 == 0) goto L_0x02f2
            android.net.wifi.WifiInfo r11 = r1.getConnectionInfo()
            if (r11 == 0) goto L_0x02f2
            java.lang.String r10 = r11.getSSID()
            java.lang.String r12 = "wifiInfo.ssid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x008e
            r10 = 1
            goto L_0x008f
        L_0x008e:
            r10 = 0
        L_0x008f:
            if (r10 == 0) goto L_0x02f2
            r10 = 4
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.allocate(r10)
            java.nio.ByteOrder r13 = java.nio.ByteOrder.LITTLE_ENDIAN
            r10.order(r13)
            int r13 = r11.getIpAddress()
            r10.putInt(r13)
            android.content.Context r13 = r0.a
            boolean r13 = com.m2catalyst.m2sdk.o4.c(r13)
            if (r13 == 0) goto L_0x02f2
            com.m2catalyst.m2sdk.database.entities.WifiEntity r13 = new com.m2catalyst.m2sdk.database.entities.WifiEntity
            r13.<init>()
            com.m2catalyst.m2sdk.external.SDKState$Companion r14 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r14 = r14.getInstance()
            android.content.Context r15 = r0.a
            java.lang.String r4 = com.m2catalyst.m2sdk.o4.a(r14, r15, r4)
            r13.setPermissions(r4)
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r14)
            r13.setTime_stamp(r4)
            java.lang.Long r4 = r13.getTime_stamp()
            java.lang.Integer r4 = com.m2catalyst.m2sdk.o1.a((java.lang.Long) r4)
            r13.setTimeZoneOffset(r4)
            com.m2catalyst.m2sdk.c7$c r4 = new com.m2catalyst.m2sdk.c7$c
            r4.<init>(r10)
            int r10 = r11.getIpAddress()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r14 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
            java.lang.Object r10 = r4.invoke()     // Catch:{ Exception -> 0x00ea }
        L_0x00ea:
            java.lang.String r10 = (java.lang.String) r10
            r13.setIp_address(r10)
            int r4 = r11.getLinkSpeed()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r13.setConnection_speed(r4)
            int r4 = r11.getRssi()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r13.setSignal_strenth_dbm(r4)
            com.m2catalyst.m2sdk.c7$d r4 = new com.m2catalyst.m2sdk.c7$d
            r4.<init>(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
            java.util.List r1 = r1.getScanResults()     // Catch:{ Exception -> 0x0112 }
            goto L_0x0114
        L_0x0112:
            r1 = r7
        L_0x0114:
            if (r1 == 0) goto L_0x0162
            java.util.Iterator r1 = r1.iterator()
        L_0x011a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x014f
            java.lang.Object r4 = r1.next()
            r10 = r4
            android.net.wifi.ScanResult r10 = (android.net.wifi.ScanResult) r10
            java.lang.String r14 = r11.getSSID()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r12)
            java.lang.String r15 = r10.SSID
            java.lang.String r5 = "it.SSID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r15, (boolean) r8, (int) r6, (java.lang.Object) r7)
            if (r5 == 0) goto L_0x0149
            java.lang.String r5 = r10.BSSID
            java.lang.String r10 = r11.getBSSID()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)
            if (r5 == 0) goto L_0x0149
            r5 = 1
            goto L_0x014a
        L_0x0149:
            r5 = 0
        L_0x014a:
            if (r5 == 0) goto L_0x014d
            goto L_0x0150
        L_0x014d:
            r5 = 3
            goto L_0x011a
        L_0x014f:
            r4 = r7
        L_0x0150:
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            if (r4 == 0) goto L_0x0162
            java.lang.String r1 = r4.SSID
            r13.setSsid(r1)
            int r1 = r4.frequency
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r13.setConnected_wifi_band_frequency(r1)
        L_0x0162:
            com.m2catalyst.m2sdk.g2 r1 = r0.b
            r2.a = r0
            r2.b = r11
            r2.c = r0
            r2.d = r13
            r2.g = r9
            java.lang.Object r1 = r1.a((kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location>) r2)
            if (r1 != r3) goto L_0x0175
            return r3
        L_0x0175:
            r10 = r0
            r12 = r10
            r4 = r13
        L_0x0178:
            com.m2catalyst.m2sdk.business.models.M2Location r1 = (com.m2catalyst.m2sdk.business.models.M2Location) r1
            r10.getClass()
            if (r1 == 0) goto L_0x01b2
            long r13 = r1.getTime()
            java.lang.Long r5 = java.lang.Long.valueOf(r13)
            r4.setLocationTimeStamp(r5)
            double r13 = r1.getLatitude()
            java.lang.Double r5 = java.lang.Double.valueOf(r13)
            r4.setLatitude(r5)
            double r13 = r1.getLongitude()
            java.lang.Double r5 = java.lang.Double.valueOf(r13)
            r4.setLongitude(r5)
            float r5 = r1.getAccuracy()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.setAccuracy(r5)
            java.lang.String r1 = r1.getProvider()
            r4.setLocationProvider(r1)
        L_0x01b2:
            r12.getClass()
            java.lang.Long r1 = r4.getTime_stamp()
            if (r1 != 0) goto L_0x01bc
            goto L_0x0203
        L_0x01bc:
            java.lang.String r1 = r4.getSsid()
            if (r1 != 0) goto L_0x01c3
            goto L_0x0203
        L_0x01c3:
            java.lang.String r1 = r4.getIp_address()
            if (r1 != 0) goto L_0x01ca
            goto L_0x0203
        L_0x01ca:
            java.lang.Integer r1 = r4.getConnection_speed()
            if (r1 == 0) goto L_0x0203
            java.lang.Integer r1 = r4.getConnection_speed()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.intValue()
            if (r1 >= 0) goto L_0x01de
            goto L_0x0203
        L_0x01de:
            java.lang.Integer r1 = r4.getConnected_wifi_band_frequency()
            if (r1 != 0) goto L_0x01e5
            goto L_0x0203
        L_0x01e5:
            java.lang.Integer r1 = r4.getSignal_strenth_dbm()
            if (r1 != 0) goto L_0x01ec
            goto L_0x0203
        L_0x01ec:
            java.lang.Long r1 = r4.getLocationTimeStamp()
            if (r1 != 0) goto L_0x01f3
            goto L_0x0203
        L_0x01f3:
            java.lang.String r1 = r4.getLocationProvider()
            if (r1 != 0) goto L_0x01fa
            goto L_0x0203
        L_0x01fa:
            java.lang.Float r1 = r4.getAccuracy()
            if (r1 != 0) goto L_0x0201
            goto L_0x0203
        L_0x0201:
            r1 = 1
            goto L_0x0204
        L_0x0203:
            r1 = 0
        L_0x0204:
            if (r1 == 0) goto L_0x02f2
            com.m2catalyst.m2sdk.z3 r1 = r12.c
            r1.getClass()
            com.m2catalyst.m2sdk.y3 r5 = new com.m2catalyst.m2sdk.y3
            r14 = 1
            r15 = 0
            r17 = 0
            r13 = r5
            r13.<init>(r14, r15, r17)
            r1.b()     // Catch:{ Exception -> 0x026c }
            java.util.ArrayList r10 = r1.i     // Catch:{ Exception -> 0x026c }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x026c }
            r13.<init>()     // Catch:{ Exception -> 0x026c }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x026c }
        L_0x0224:
            boolean r14 = r10.hasNext()     // Catch:{ Exception -> 0x026c }
            if (r14 == 0) goto L_0x0241
            java.lang.Object r14 = r10.next()     // Catch:{ Exception -> 0x026c }
            r15 = r14
            com.m2catalyst.m2sdk.y3 r15 = (com.m2catalyst.m2sdk.y3) r15     // Catch:{ Exception -> 0x026c }
            int r15 = r15.a     // Catch:{ Exception -> 0x026c }
            int r9 = r5.a     // Catch:{ Exception -> 0x026c }
            if (r15 != r9) goto L_0x0239
            r9 = 1
            goto L_0x023a
        L_0x0239:
            r9 = 0
        L_0x023a:
            if (r9 == 0) goto L_0x023f
            r13.add(r14)     // Catch:{ Exception -> 0x026c }
        L_0x023f:
            r9 = 1
            goto L_0x0224
        L_0x0241:
            java.util.List r9 = kotlin.collections.CollectionsKt.toMutableList(r13)     // Catch:{ Exception -> 0x026c }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x026c }
        L_0x0249:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x026c }
            if (r10 == 0) goto L_0x0266
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x026c }
            com.m2catalyst.m2sdk.y3 r10 = (com.m2catalyst.m2sdk.y3) r10     // Catch:{ Exception -> 0x026c }
            long r13 = r5.c     // Catch:{ Exception -> 0x026c }
            long r6 = r10.c     // Catch:{ Exception -> 0x026c }
            long r13 = r13 + r6
            r5.c = r13     // Catch:{ Exception -> 0x026c }
            long r6 = r5.b     // Catch:{ Exception -> 0x026c }
            long r13 = r10.b     // Catch:{ Exception -> 0x026c }
            long r6 = r6 + r13
            r5.b = r6     // Catch:{ Exception -> 0x026c }
            r6 = 2
            r7 = 0
            goto L_0x0249
        L_0x0266:
            java.util.ArrayList r1 = r1.i     // Catch:{ Exception -> 0x026c }
            r1.clear()     // Catch:{ Exception -> 0x026c }
            goto L_0x0279
        L_0x026c:
            com.m2catalyst.m2sdk.y3 r5 = new com.m2catalyst.m2sdk.y3
            r19 = 1
            r20 = 0
            r22 = 0
            r18 = r5
            r18.<init>(r19, r20, r22)
        L_0x0279:
            java.lang.String r1 = r12.h
            if (r1 == 0) goto L_0x029c
            java.lang.String r6 = r11.getSSID()
            r7 = 2
            r9 = 0
            boolean r1 = kotlin.text.StringsKt.equals$default(r1, r6, r8, r7, r9)
            if (r1 != 0) goto L_0x029c
            com.m2catalyst.m2sdk.business.repositories.WifiRepository r1 = r12.d
            r2.a = r12
            r2.b = r11
            r2.c = r4
            r2.d = r9
            r2.g = r7
            java.lang.Object r1 = r1.updatePrevRecordDataUsage(r5, r2)
            if (r1 != r3) goto L_0x02b0
            return r3
        L_0x029c:
            long r6 = r5.c
            int r1 = (int) r6
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r4.setDataRx(r1)
            long r5 = r5.b
            int r1 = (int) r5
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r4.setDataTx(r1)
        L_0x02b0:
            r6 = r11
            r10 = r12
        L_0x02b2:
            com.m2catalyst.m2sdk.business.models.Wifi r1 = new com.m2catalyst.m2sdk.business.models.Wifi
            r1.<init>(r4)
            com.m2catalyst.m2sdk.business.repositories.WifiRepository r4 = r10.d
            r5 = 1
            com.m2catalyst.m2sdk.business.models.Wifi[] r5 = new com.m2catalyst.m2sdk.business.models.Wifi[r5]
            r5[r8] = r1
            r2.a = r10
            r2.b = r6
            r2.c = r1
            r7 = 0
            r2.d = r7
            r7 = 3
            r2.g = r7
            java.lang.Object r2 = r4.addWifi(r5, r2)
            if (r2 != r3) goto L_0x02d1
            return r3
        L_0x02d1:
            r3 = r1
            r4 = r6
            r2 = r10
        L_0x02d4:
            com.m2catalyst.m2sdk.external.SDKState$Companion r1 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r1 = r1.getInstance()
            r1.setCompleteWifi$m2sdk_release(r3)
            com.m2catalyst.m2sdk.z5 r1 = r2.e
            com.m2catalyst.m2sdk.a6 r3 = com.m2catalyst.m2sdk.a6.LAST_TIME_WIFI_COLLECTED
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r1.a(r3, r5)
            java.lang.String r1 = r4.getSSID()
            r2.h = r1
        L_0x02f2:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.c7.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a() {
        try {
            this.f.registerDefaultNetworkCallback(this.i);
        } catch (Exception unused) {
        }
    }

    public final void b() {
        try {
            z5 z5Var = this.e;
            Object obj = a6.LAST_TIME_WIFI_COLLECTED.b;
            if (z5Var.a.getAll().containsKey("lastTimeWifiCollectecAuto")) {
                obj = z5Var.a.getAll().get("lastTimeWifiCollectecAuto");
            }
            Long l = (Long) obj;
            long longValue = l != null ? l.longValue() : 0;
            boolean z = false;
            if (m4.c(this.a)) {
                if (System.currentTimeMillis() - longValue <= o1.a(1)) {
                    z = true;
                }
            }
            this.g = z;
            this.f.unregisterNetworkCallback(this.i);
        } catch (Exception unused) {
        }
    }
}
