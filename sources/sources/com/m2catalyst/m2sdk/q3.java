package com.m2catalyst.m2sdk;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyDisplayInfo;
import android.util.SparseArray;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot;
import com.m2catalyst.m2sdk.business.models.SubInfo;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.c3;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.speed_test.SpeedTestManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NetworkCollectionManager.kt */
public final class q3 {
    public final Context a;
    public final MNSIRepository b;
    public final NoSignalMNSIRepository c;
    public final q d;
    public final g2 e;
    public final z3 f;
    public final SpeedTestManager g;
    public final SparseArray<c3> h;
    public final ConcurrentLinkedQueue<Pair<MNSI, c3>> i = new ConcurrentLinkedQueue<>();
    public final int[] j = {-1, -1, -1};
    public final LinkedHashMap k = new LinkedHashMap();
    public final M2SDKLogger l = M2SDKLogger.Companion.getLogger("MNSI");
    public final LinkedHashMap m = new LinkedHashMap();

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager", f = "NetworkCollectionManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {204, 227}, m = "createAndProcess", n = {"this", "$this$createAndProcess", "lastMNSIPair", "pair", "mnsiId", "shouldAttemptToRunTest", "this", "$this$createAndProcess", "pair", "mnsiId", "shouldAttemptToRunTest"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
    /* compiled from: NetworkCollectionManager.kt */
    public static final class a extends ContinuationImpl {
        public q3 a;
        public c3 b;
        public Pair c;
        public Serializable d;
        public Ref.IntRef e;
        public Ref.IntRef f;
        public boolean g;
        public /* synthetic */ Object h;
        public final /* synthetic */ q3 i;
        public int j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q3 q3Var, Continuation<? super a> continuation) {
            super(continuation);
            this.i = q3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return this.i.a((c3) null, (M2Location) null, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager", f = "NetworkCollectionManager.kt", i = {0, 0, 0}, l = {522}, m = "processMNSIWithInvalidLocation", n = {"this", "location", "pair"}, s = {"L$0", "L$1", "L$3"})
    /* compiled from: NetworkCollectionManager.kt */
    public static final class b extends ContinuationImpl {
        public q3 a;
        public M2Location b;
        public Iterator c;
        public Pair d;
        public /* synthetic */ Object e;
        public final /* synthetic */ q3 f;
        public int g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q3 q3Var, Continuation<? super b> continuation) {
            super(continuation);
            this.f = q3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return this.f.a((M2Location) null, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager", f = "NetworkCollectionManager.kt", i = {}, l = {333, 333}, m = "storeCellLocation", n = {}, s = {})
    /* compiled from: NetworkCollectionManager.kt */
    public static final class c extends ContinuationImpl {
        public c3 a;
        public q3 b;
        public /* synthetic */ Object c;
        public final /* synthetic */ q3 d;
        public int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(q3 q3Var, Continuation<? super c> continuation) {
            super(continuation);
            this.d = q3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a(0, (CellLocation) null, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager", f = "NetworkCollectionManager.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {355, 357, 364, 364}, m = "storeServiceState", n = {"this", "serviceState", "subscriber", "this", "serviceState", "subscriber", "this", "serviceState", "subscriber", "this", "serviceState", "subscriber"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
    /* compiled from: NetworkCollectionManager.kt */
    public static final class d extends ContinuationImpl {
        public q3 a;
        public ServiceState b;
        public c3 c;
        public Object d;
        public int e;
        public /* synthetic */ Object f;
        public final /* synthetic */ q3 g;
        public int h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(q3 q3Var, Continuation<? super d> continuation) {
            super(continuation);
            this.g = q3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(0, (ServiceState) null, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager", f = "NetworkCollectionManager.kt", i = {}, l = {391, 391}, m = "storeSignalStrength", n = {}, s = {})
    /* compiled from: NetworkCollectionManager.kt */
    public static final class e extends ContinuationImpl {
        public c3 a;
        public q3 b;
        public /* synthetic */ Object c;
        public final /* synthetic */ q3 d;
        public int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(q3 q3Var, Continuation<? super e> continuation) {
            super(continuation);
            this.d = q3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a(0, (SignalStrength) null, (Continuation<? super Unit>) this);
        }
    }

    public q3(Context context, MNSIRepository mNSIRepository, NoSignalMNSIRepository noSignalMNSIRepository, q qVar, LocationRepository locationRepository, g2 g2Var, z3 z3Var, SpeedTestManager speedTestManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mNSIRepository, "mnsiRepository");
        Intrinsics.checkNotNullParameter(noSignalMNSIRepository, "noSignalRepository");
        Intrinsics.checkNotNullParameter(qVar, "cellInfoStrategyManager");
        Intrinsics.checkNotNullParameter(locationRepository, "locationRepository");
        Intrinsics.checkNotNullParameter(g2Var, "locationCollection");
        Intrinsics.checkNotNullParameter(z3Var, "networkDataUsage");
        Intrinsics.checkNotNullParameter(speedTestManager, "speedTestManager");
        this.a = context;
        this.b = mNSIRepository;
        this.c = noSignalMNSIRepository;
        this.d = qVar;
        this.e = g2Var;
        this.f = z3Var;
        this.g = speedTestManager;
        SparseArray<c3> sparseArray = new SparseArray<>();
        this.h = sparseArray;
        if (sparseArray.size() == 0) {
            d();
        }
    }

    public final M2SDKLogger b() {
        return this.l;
    }

    public final SparseArray<c3> c() {
        return this.h;
    }

    public final void d() {
        Iterator it = m6.b(this.a).iterator();
        while (it.hasNext()) {
            SubInfo subInfo = (SubInfo) it.next();
            SparseArray<c3> sparseArray = this.h;
            c3 a2 = c3.a.a(this.a, subInfo.getId(), subInfo.getSimSlot());
            sparseArray.put(a2.o(), a2);
        }
    }

    public final boolean e() {
        int i2;
        Context context = this.a;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i2 = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (RuntimeException unused) {
            i2 = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.READ_PHONE_STATE");
        }
        if (i2 == 0) {
            ArrayList b2 = m6.b(this.a);
            if (this.h.size() != b2.size()) {
                return true;
            }
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                if (this.h.get(((SubInfo) it.next()).getId()) == null) {
                    return true;
                }
            }
            return false;
        }
        boolean z = (this.j[0] == SubscriptionManager.getDefaultDataSubscriptionId() && this.j[1] == SubscriptionManager.getDefaultSmsSubscriptionId() && this.j[2] == SubscriptionManager.getDefaultVoiceSubscriptionId()) ? false : true;
        this.j[0] = SubscriptionManager.getDefaultDataSubscriptionId();
        this.j[1] = SubscriptionManager.getDefaultSmsSubscriptionId();
        this.j[2] = SubscriptionManager.getDefaultVoiceSubscriptionId();
        return z;
    }

    public final Pair<c3, MNSI> a() {
        return (Pair) this.k.get(Integer.valueOf(m6.a(this.a).getId()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: kotlin.Pair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: com.m2catalyst.m2sdk.c3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.m2catalyst.m2sdk.c3 r21, com.m2catalyst.m2sdk.business.models.M2Location r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            boolean r3 = r2 instanceof com.m2catalyst.m2sdk.q3.a
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.m2catalyst.m2sdk.q3$a r3 = (com.m2catalyst.m2sdk.q3.a) r3
            int r4 = r3.j
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.j = r4
            goto L_0x001e
        L_0x0019:
            com.m2catalyst.m2sdk.q3$a r3 = new com.m2catalyst.m2sdk.q3$a
            r3.<init>(r0, r2)
        L_0x001e:
            r10 = r3
            java.lang.Object r2 = r10.h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r10.j
            r5 = 2
            r6 = 1
            java.lang.String r7 = " "
            r8 = 0
            java.lang.String r9 = "MNSI_BUILDER"
            r12 = 0
            if (r4 == 0) goto L_0x006f
            if (r4 == r6) goto L_0x004e
            if (r4 != r5) goto L_0x0046
            boolean r1 = r10.g
            java.io.Serializable r3 = r10.d
            kotlin.jvm.internal.Ref$IntRef r3 = (kotlin.jvm.internal.Ref.IntRef) r3
            kotlin.Pair r4 = r10.c
            com.m2catalyst.m2sdk.c3 r5 = r10.b
            com.m2catalyst.m2sdk.q3 r6 = r10.a
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x033f
        L_0x0046:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004e:
            boolean r1 = r10.g
            kotlin.jvm.internal.Ref$IntRef r4 = r10.f
            kotlin.jvm.internal.Ref$IntRef r13 = r10.e
            java.io.Serializable r14 = r10.d
            kotlin.Pair r14 = (kotlin.Pair) r14
            kotlin.Pair r15 = r10.c
            com.m2catalyst.m2sdk.c3 r11 = r10.b
            com.m2catalyst.m2sdk.q3 r5 = r10.a
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r2
            r2 = r1
            r1 = r11
            r11 = r4
            r4 = r18
            r19 = r15
            r15 = r5
            r5 = r19
            goto L_0x0184
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r2)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r0.l
            java.lang.String[] r4 = new java.lang.String[r12]
            java.lang.String r5 = "createAndProcess "
            r2.d(r9, r5, r4)
            int r2 = r21.o()
            java.util.LinkedHashMap r4 = r0.k
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r4.get(r2)
            r15 = r2
            kotlin.Pair r15 = (kotlin.Pair) r15
            if (r15 == 0) goto L_0x0095
            java.lang.Object r2 = r15.getFirst()
            com.m2catalyst.m2sdk.c3 r2 = (com.m2catalyst.m2sdk.c3) r2
            goto L_0x0096
        L_0x0095:
            r2 = r8
        L_0x0096:
            boolean r2 = r1.a((com.m2catalyst.m2sdk.c3) r2)
            if (r2 == 0) goto L_0x00c7
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r1 = r21.o()
            if (r15 == 0) goto L_0x00ab
            java.lang.Object r3 = r15.getFirst()
            r8 = r3
            com.m2catalyst.m2sdk.c3 r8 = (com.m2catalyst.m2sdk.c3) r8
        L_0x00ab:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "createAndProcess REJECTED - duplicate "
            r3.<init>(r4)
            r3.append(r1)
            r3.append(r7)
            r3.append(r8)
            java.lang.String r1 = r3.toString()
            java.lang.String[] r3 = new java.lang.String[r12]
            r2.d(r9, r1, r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00c7:
            com.m2catalyst.m2sdk.q r2 = r0.d
            if (r15 == 0) goto L_0x00d2
            java.lang.Object r4 = r15.getFirst()
            com.m2catalyst.m2sdk.c3 r4 = (com.m2catalyst.m2sdk.c3) r4
            goto L_0x00d3
        L_0x00d2:
            r4 = r8
        L_0x00d3:
            if (r15 == 0) goto L_0x00de
            java.lang.Object r11 = r15.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r11 = (com.m2catalyst.m2sdk.business.models.MNSI) r11
            r13 = r22
            goto L_0x00e1
        L_0x00de:
            r13 = r22
            r11 = r8
        L_0x00e1:
            kotlin.Pair r2 = r2.a(r1, r13, r4, r11)
            if (r2 == 0) goto L_0x040c
            com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r0.l
            java.lang.Object r11 = r2.getSecond()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r11)
            java.lang.String r5 = r13.toString()
            java.lang.String[] r11 = new java.lang.String[r12]
            r4.d(r9, r5, r11)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            r4.handleDeviceUptime()
            java.lang.Object r4 = r2.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 != r6) goto L_0x03a8
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r4 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.Object r5 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r5 = (com.m2catalyst.m2sdk.business.models.MNSI) r5
            java.lang.Integer r5 = r5.getSubscriber()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r13 = "NetworkCollectionManager process Subscriber "
            r11.<init>(r13)
            r11.append(r5)
            java.lang.String r5 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r12]
            r4.d(r9, r5, r11)
            java.lang.Object r5 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r5 = (com.m2catalyst.m2sdk.business.models.MNSI) r5
            android.content.Context r11 = r21.d()
            r5.addPermissionValues(r11)
            com.m2catalyst.m2sdk.speed_test.SpeedTestManager r5 = r0.g
            java.lang.Object r11 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r11 = (com.m2catalyst.m2sdk.business.models.MNSI) r11
            r13 = 2
            boolean r5 = com.m2catalyst.m2sdk.speed_test.SpeedTestManager.shouldAttemptRunAutomaticSpeedTest$default(r5, r11, r12, r13, r8)
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef
            r11.<init>()
            r13 = -1
            r11.element = r13
            java.lang.Object r13 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r13 = (com.m2catalyst.m2sdk.business.models.MNSI) r13
            boolean r13 = r13.isStandardCompleteness()
            if (r13 == 0) goto L_0x0362
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r4 = r0.b
            java.lang.Object r13 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r13 = (com.m2catalyst.m2sdk.business.models.MNSI) r13
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r13 = r13.toEntity$m2sdk_release()
            r10.a = r0
            r10.b = r1
            r10.c = r15
            r10.d = r2
            r10.e = r11
            r10.f = r11
            r10.g = r5
            r10.j = r6
            java.lang.Object r4 = r4.insertMNSIEntry(r13, r10)
            if (r4 != r3) goto L_0x017f
            return r3
        L_0x017f:
            r14 = r2
            r2 = r5
            r13 = r11
            r5 = r15
            r15 = r0
        L_0x0184:
            java.lang.Number r4 = (java.lang.Number) r4
            r16 = r7
            long r6 = r4.longValue()
            int r4 = (int) r6
            r11.element = r4
            int r4 = r13.element
            r6 = -1
            if (r4 == r6) goto L_0x02e4
            com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r15.l
            java.lang.String[] r6 = new java.lang.String[r12]
            r7 = r16
            r4.d(r9, r7, r6)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r15.l
            int r6 = r1.o()
            long r16 = java.lang.System.currentTimeMillis()
            java.lang.String r11 = com.m2catalyst.m2sdk.c3.a((long) r16)
            int r8 = r13.element
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "NEW MNSI Subscriber:"
            r12.<init>(r0)
            r12.append(r6)
            r12.append(r7)
            r12.append(r11)
            java.lang.String r0 = " RECORD DB "
            r12.append(r0)
            r12.append(r8)
            java.lang.String r0 = "------------------------"
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            r6 = 0
            java.lang.String[] r8 = new java.lang.String[r6]
            r4.d(r9, r0, r8)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r15.l
            if (r5 == 0) goto L_0x01e9
            java.lang.Object r4 = r5.getFirst()
            com.m2catalyst.m2sdk.c3 r4 = (com.m2catalyst.m2sdk.c3) r4
            if (r4 == 0) goto L_0x01e9
            int r4 = r4.e()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            goto L_0x01ea
        L_0x01e9:
            r4 = 0
        L_0x01ea:
            if (r5 == 0) goto L_0x01f3
            java.lang.Object r6 = r5.getFirst()
            com.m2catalyst.m2sdk.c3 r6 = (com.m2catalyst.m2sdk.c3) r6
            goto L_0x01f4
        L_0x01f3:
            r6 = 0
        L_0x01f4:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "MNSI_BUILDER_LAST id= "
            r8.<init>(r11)
            r8.append(r4)
            r8.append(r7)
            r8.append(r6)
            java.lang.String r4 = r8.toString()
            r6 = 0
            java.lang.String[] r8 = new java.lang.String[r6]
            r0.d(r9, r4, r8)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r15.l
            int r4 = r1.e()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "MNSI_BUILDER id= "
            r8.<init>(r11)
            r8.append(r4)
            r8.append(r7)
            r8.append(r1)
            java.lang.String r4 = r8.toString()
            java.lang.String[] r8 = new java.lang.String[r6]
            r0.d(r9, r4, r8)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r15.l
            if (r5 == 0) goto L_0x0242
            java.lang.Object r4 = r5.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r4 = (com.m2catalyst.m2sdk.business.models.MNSI) r4
            if (r4 == 0) goto L_0x0242
            int r4 = r4.getId()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            goto L_0x0243
        L_0x0242:
            r4 = 0
        L_0x0243:
            if (r5 == 0) goto L_0x024c
            java.lang.Object r6 = r5.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r6 = (com.m2catalyst.m2sdk.business.models.MNSI) r6
            goto L_0x024d
        L_0x024c:
            r6 = 0
        L_0x024d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "MNSI_LAST id= "
            r8.<init>(r11)
            r8.append(r4)
            r8.append(r7)
            r8.append(r6)
            java.lang.String r4 = r8.toString()
            r6 = 0
            java.lang.String[] r8 = new java.lang.String[r6]
            r0.d(r9, r4, r8)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r15.l
            int r4 = r13.element
            java.lang.Object r6 = r14.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r6 = (com.m2catalyst.m2sdk.business.models.MNSI) r6
            int r6 = r6.getId()
            java.lang.Object r8 = r14.getSecond()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "MNSI db="
            r11.<init>(r12)
            r11.append(r4)
            java.lang.String r4 = " id= "
            r11.append(r4)
            r11.append(r6)
            r11.append(r7)
            r11.append(r8)
            java.lang.String r4 = r11.toString()
            r6 = 0
            java.lang.String[] r8 = new java.lang.String[r6]
            r0.d(r9, r4, r8)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r15.l
            java.lang.String[] r4 = new java.lang.String[r6]
            java.lang.String r8 = "------------------------------------------------ "
            r0.d(r9, r8, r4)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r15.l
            java.lang.String[] r4 = new java.lang.String[r6]
            r0.d(r9, r7, r4)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.Object r4 = r14.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r4 = (com.m2catalyst.m2sdk.business.models.MNSI) r4
            java.lang.Integer r4 = r4.getSubscriber()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "createAndProcess SAVED - Subscriber "
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.String[] r6 = new java.lang.String[r6]
            r0.d(r9, r4, r6)
            com.m2catalyst.m2sdk.external.SDKState$Companion r0 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r0 = r0.getInstance()
            java.lang.Object r4 = r14.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r4 = (com.m2catalyst.m2sdk.business.models.MNSI) r4
            r0.setCompleteMNSI(r4)
            java.lang.Object r0 = r14.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r0 = (com.m2catalyst.m2sdk.business.models.MNSI) r0
            int r4 = r13.element
            r0.setId(r4)
        L_0x02e4:
            if (r5 == 0) goto L_0x0348
            java.lang.Object r0 = r5.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r0 = (com.m2catalyst.m2sdk.business.models.MNSI) r0
            if (r0 == 0) goto L_0x0348
            java.lang.Integer r4 = r0.isDataDefaultSim()
            if (r4 != 0) goto L_0x02f5
            goto L_0x0348
        L_0x02f5:
            int r4 = r4.intValue()
            r5 = 1
            if (r4 != r5) goto L_0x0348
            com.m2catalyst.m2sdk.z3 r4 = r15.f
            com.m2catalyst.m2sdk.y3 r4 = com.m2catalyst.m2sdk.z3.a(r4)
            r0.setNetworkData$m2sdk_release(r4)
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r4 = r15.b
            int r5 = r0.getId()
            java.lang.Long r6 = r0.getDataRx()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            long r6 = r6.longValue()
            java.lang.Long r0 = r0.getDataTx()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            long r8 = r0.longValue()
            r10.a = r15
            r10.b = r1
            r10.c = r14
            r10.d = r13
            r0 = 0
            r10.e = r0
            r10.f = r0
            r10.g = r2
            r0 = 2
            r10.j = r0
            java.lang.Object r0 = r4.updateMobileSignalRxTx(r5, r6, r8, r10)
            if (r0 != r3) goto L_0x033a
            return r3
        L_0x033a:
            r5 = r1
            r1 = r2
            r3 = r13
            r4 = r14
            r6 = r15
        L_0x033f:
            r11 = r3
            r2 = r4
            r15 = r6
            r18 = r5
            r5 = r1
            r1 = r18
            goto L_0x034b
        L_0x0348:
            r5 = r2
            r11 = r13
            r2 = r14
        L_0x034b:
            int r0 = r1.o()
            kotlin.Pair r3 = new kotlin.Pair
            java.lang.Object r4 = r2.getSecond()
            r3.<init>(r1, r4)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.util.LinkedHashMap r1 = r15.k
            r1.put(r0, r3)
            goto L_0x0388
        L_0x0362:
            int r0 = r21.o()
            java.lang.Object r1 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r1 = (com.m2catalyst.m2sdk.business.models.MNSI) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "createAndProcess REJECTED - not standard completeness "
            r3.<init>(r6)
            r3.append(r0)
            r3.append(r7)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            r4.d(r9, r0, r1)
            r15 = r20
        L_0x0388:
            int r0 = r11.element
            r1 = -1
            if (r0 == r1) goto L_0x03a5
            if (r5 == 0) goto L_0x03a5
            com.m2catalyst.m2sdk.speed_test.SpeedTestManager r0 = r15.g
            java.lang.Object r1 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r1 = (com.m2catalyst.m2sdk.business.models.MNSI) r1
            int r3 = r11.element
            r1.setId(r3)
            java.lang.Object r2 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r2 = (com.m2catalyst.m2sdk.business.models.MNSI) r2
            r0.runAutomaticTest(r1, r2)
        L_0x03a5:
            r3 = r20
            goto L_0x0409
        L_0x03a8:
            java.lang.Object r0 = r2.getFirst()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r3 = 2
            if (r0 != r3) goto L_0x03a5
            java.lang.Object r0 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r0 = (com.m2catalyst.m2sdk.business.models.MNSI) r0
            boolean r0 = r0.isStandardCompleteness()
            if (r0 == 0) goto L_0x03a5
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r3 = r21.o()
            java.lang.Object r4 = r2.getSecond()
            com.m2catalyst.m2sdk.business.models.MNSI r4 = (com.m2catalyst.m2sdk.business.models.MNSI) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "createAndProcess QUEUED - for better location "
            r5.<init>(r6)
            r5.append(r3)
            r5.append(r7)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            r4 = 0
            java.lang.String[] r5 = new java.lang.String[r4]
            r0.d(r9, r3, r5)
            boolean r0 = r21.s()
            if (r0 != 0) goto L_0x03a5
            r21.t()
            r3 = r20
            java.util.concurrent.ConcurrentLinkedQueue<kotlin.Pair<com.m2catalyst.m2sdk.business.models.MNSI, com.m2catalyst.m2sdk.c3>> r0 = r3.i
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.Object r2 = r2.getSecond()
            r5.<init>(r2, r1)
            r0.add(r5)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r3.l
            java.lang.String[] r1 = new java.lang.String[r4]
            java.lang.String r2 = "MNSI put in queue"
            r0.d(r9, r2, r1)
        L_0x0409:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x040c:
            r3 = r0
            r0 = r8
            r4 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r3.l
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r4 = "createAndProcess pair is null"
            r2.d(r9, r4, r5)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r1 = r21.o()
            if (r15 == 0) goto L_0x0428
            java.lang.Object r0 = r15.getFirst()
            r8 = r0
            com.m2catalyst.m2sdk.c3 r8 = (com.m2catalyst.m2sdk.c3) r8
            goto L_0x0429
        L_0x0428:
            r8 = r0
        L_0x0429:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "createAndProcess REJECTED - pair is null "
            r0.<init>(r4)
            r0.append(r1)
            r0.append(r7)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            r2.d(r9, r0, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q3.a(com.m2catalyst.m2sdk.c3, com.m2catalyst.m2sdk.business.models.M2Location, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.List r12, int r13, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.m2catalyst.m2sdk.s3
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.m2catalyst.m2sdk.s3 r0 = (com.m2catalyst.m2sdk.s3) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.s3 r0 = new com.m2catalyst.m2sdk.s3
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x003e
            if (r2 == r3) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00f6
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            com.m2catalyst.m2sdk.q3 r12 = r0.b
            com.m2catalyst.m2sdk.c3 r13 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r2 = new java.lang.String[r4]
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r5 = r11.h
            java.lang.Object r5 = r5.get(r13)
            if (r5 != 0) goto L_0x0050
            java.lang.String r5 = " not found"
            goto L_0x0052
        L_0x0050:
            java.lang.String r5 = " found"
        L_0x0052:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Subscriber "
            r6.<init>(r7)
            r6.append(r13)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r2[r6] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "CellInfo: "
            r5.<init>(r7)
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            r2[r3] = r5
            java.lang.String r5 = "MNSI_BUILDER"
            java.lang.String r7 = "NetworkCollectionManager storeCellInfo"
            r14.v(r5, r7, r2)
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r14 = r11.h
            java.lang.Object r14 = r14.get(r13)
            com.m2catalyst.m2sdk.c3 r14 = (com.m2catalyst.m2sdk.c3) r14
            if (r14 == 0) goto L_0x00f6
            r14.a((java.util.List<? extends android.telephony.CellInfo>) r12)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r2 = new com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot
            android.content.Context r7 = r11.a
            r2.<init>(r7, r13)
            r14.a((com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot) r2)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r13 = r11.l
            long r7 = r14.b()
            java.lang.String r2 = a(r7)
            long r7 = r14.b()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "TRIGGER ----- storeCellInfo          new time= "
            r9.<init>(r10)
            r9.append(r2)
            java.lang.String r2 = " timestamp = "
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r9.toString()
            java.lang.String[] r7 = new java.lang.String[r6]
            r13.d(r5, r2, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r13 = r11.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = "                                     cellInfo= "
            r2.<init>(r7)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            java.lang.String[] r2 = new java.lang.String[r6]
            r13.d(r5, r12, r2)
            com.m2catalyst.m2sdk.c3 r13 = r14.a()
            com.m2catalyst.m2sdk.g2 r12 = r11.e
            r0.a = r13
            r0.b = r11
            r0.e = r3
            java.lang.Object r14 = r12.a((kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location>) r0)
            if (r14 != r1) goto L_0x00e5
            return r1
        L_0x00e5:
            r12 = r11
        L_0x00e6:
            com.m2catalyst.m2sdk.business.models.M2Location r14 = (com.m2catalyst.m2sdk.business.models.M2Location) r14
            r2 = 0
            r0.a = r2
            r0.b = r2
            r0.e = r4
            java.lang.Object r12 = r12.a((com.m2catalyst.m2sdk.c3) r13, (com.m2catalyst.m2sdk.business.models.M2Location) r14, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q3.a(java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static String a(long j2) {
        String format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ", Locale.US).format(new Date(j2));
        Intrinsics.checkNotNullExpressionValue(format, "format.format(dateTime)");
        return format;
    }

    public final void a(List list, int i2) {
        Intrinsics.checkNotNullParameter(list, "cellInfo");
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        String[] strArr = new String[2];
        String str = this.h.get(i2) == null ? " not found" : " found";
        strArr[0] = "Subscriber " + i2 + str;
        StringBuilder sb = new StringBuilder("CellInfo: ");
        sb.append(list);
        strArr[1] = sb.toString();
        companion.v("MNSI_BUILDER", "NetworkCollectionManager setCellInfo", strArr);
        c3 c3Var = this.h.get(i2);
        if (c3Var != null) {
            c3Var.a((List<? extends CellInfo>) list);
            c3Var.a(new NetworkInfoSnapshot(this.a, i2));
            M2SDKLogger m2SDKLogger = this.l;
            String a2 = a(c3Var.b());
            long b2 = c3Var.b();
            m2SDKLogger.d("MNSI_BUILDER", "TRIGGER ----- SETTING NO SAVE setCellInfo            new time= " + a2 + " timestamp = " + b2, new String[0]);
            M2SDKLogger m2SDKLogger2 = this.l;
            StringBuilder sb2 = new StringBuilder("                                                     cellInfo= ");
            sb2.append(list);
            m2SDKLogger2.d("MNSI_BUILDER", sb2.toString(), new String[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(int r12, android.telephony.CellLocation r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.m2catalyst.m2sdk.q3.c
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.m2catalyst.m2sdk.q3$c r0 = (com.m2catalyst.m2sdk.q3.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.q3$c r0 = new com.m2catalyst.m2sdk.q3$c
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x003e
            if (r2 == r3) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00f6
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            com.m2catalyst.m2sdk.q3 r12 = r0.b
            com.m2catalyst.m2sdk.c3 r13 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r2 = new java.lang.String[r4]
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r5 = r11.h
            java.lang.Object r5 = r5.get(r12)
            if (r5 != 0) goto L_0x0050
            java.lang.String r5 = " not found"
            goto L_0x0052
        L_0x0050:
            java.lang.String r5 = " found"
        L_0x0052:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Subscriber "
            r6.<init>(r7)
            r6.append(r12)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r2[r6] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "CellLocation: "
            r5.<init>(r7)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2[r3] = r5
            java.lang.String r5 = "MNSI_BUILDER"
            java.lang.String r7 = "NetworkCollectionManager storeCellTower"
            r14.v(r5, r7, r2)
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r14 = r11.h
            java.lang.Object r14 = r14.get(r12)
            com.m2catalyst.m2sdk.c3 r14 = (com.m2catalyst.m2sdk.c3) r14
            if (r14 == 0) goto L_0x00f6
            r14.a((android.telephony.CellLocation) r13)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r2 = new com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot
            android.content.Context r7 = r11.a
            r2.<init>(r7, r12)
            r14.a((com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot) r2)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r11.l
            long r7 = r14.c()
            java.lang.String r2 = a(r7)
            long r7 = r14.c()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "TRIGGER ----- storeCellTower         new time= "
            r9.<init>(r10)
            r9.append(r2)
            java.lang.String r2 = " timestamp = "
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r9.toString()
            java.lang.String[] r7 = new java.lang.String[r6]
            r12.d(r5, r2, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r11.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = "                                     cellLocation= "
            r2.<init>(r7)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            java.lang.String[] r2 = new java.lang.String[r6]
            r12.d(r5, r13, r2)
            com.m2catalyst.m2sdk.c3 r13 = r14.a()
            com.m2catalyst.m2sdk.g2 r12 = r11.e
            r0.a = r13
            r0.b = r11
            r0.e = r3
            java.lang.Object r14 = r12.a((kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location>) r0)
            if (r14 != r1) goto L_0x00e5
            return r1
        L_0x00e5:
            r12 = r11
        L_0x00e6:
            com.m2catalyst.m2sdk.business.models.M2Location r14 = (com.m2catalyst.m2sdk.business.models.M2Location) r14
            r2 = 0
            r0.a = r2
            r0.b = r2
            r0.e = r4
            java.lang.Object r12 = r12.a((com.m2catalyst.m2sdk.c3) r13, (com.m2catalyst.m2sdk.business.models.M2Location) r14, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q3.a(int, android.telephony.CellLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(int r18, android.telephony.ServiceState r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            boolean r4 = r3 instanceof com.m2catalyst.m2sdk.q3.d
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.m2catalyst.m2sdk.q3$d r4 = (com.m2catalyst.m2sdk.q3.d) r4
            int r5 = r4.h
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.h = r5
            goto L_0x0020
        L_0x001b:
            com.m2catalyst.m2sdk.q3$d r4 = new com.m2catalyst.m2sdk.q3$d
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.h
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 0
            r11 = 0
            r12 = 1
            if (r6 == 0) goto L_0x0078
            if (r6 == r12) goto L_0x0061
            if (r6 == r9) goto L_0x0056
            if (r6 == r8) goto L_0x0041
            if (r6 != r7) goto L_0x0039
            goto L_0x0056
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            int r1 = r4.e
            java.lang.Object r2 = r4.d
            com.m2catalyst.m2sdk.q3 r2 = (com.m2catalyst.m2sdk.q3) r2
            com.m2catalyst.m2sdk.c3 r6 = r4.c
            android.telephony.ServiceState r8 = r4.b
            com.m2catalyst.m2sdk.q3 r9 = r4.a
            kotlin.ResultKt.throwOnFailure(r3)
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r8
            goto L_0x0188
        L_0x0056:
            int r1 = r4.e
            android.telephony.ServiceState r2 = r4.b
            com.m2catalyst.m2sdk.q3 r4 = r4.a
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x019f
        L_0x0061:
            int r1 = r4.e
            java.lang.Object r2 = r4.d
            com.m2catalyst.m2sdk.q r2 = (com.m2catalyst.m2sdk.q) r2
            com.m2catalyst.m2sdk.c3 r6 = r4.c
            android.telephony.ServiceState r7 = r4.b
            com.m2catalyst.m2sdk.q3 r8 = r4.a
            kotlin.ResultKt.throwOnFailure(r3)
            r16 = r6
            r6 = r2
            r2 = r7
            r7 = r16
            goto L_0x00fc
        L_0x0078:
            kotlin.ResultKt.throwOnFailure(r3)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r6 = new java.lang.String[r9]
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r13 = r0.h
            java.lang.Object r13 = r13.get(r1)
            if (r13 != 0) goto L_0x008a
            java.lang.String r13 = " not found"
            goto L_0x008c
        L_0x008a:
            java.lang.String r13 = " found"
        L_0x008c:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "Subscriber "
            r14.<init>(r15)
            r14.append(r1)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r6[r11] = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "ServiceState: "
            r13.<init>(r14)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            r6[r12] = r13
            java.lang.String r13 = "MNSI_BUILDER"
            java.lang.String r14 = "NetworkCollectionManager storeServiceState"
            r3.v(r13, r14, r6)
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r3 = r0.h
            java.lang.Object r3 = r3.get(r1)
            com.m2catalyst.m2sdk.c3 r3 = (com.m2catalyst.m2sdk.c3) r3
            if (r3 == 0) goto L_0x01b0
            int r6 = r19.getState()
            if (r6 != r12) goto L_0x0120
            java.util.LinkedHashMap r6 = r0.m
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r18)
            java.lang.Object r6 = r6.get(r14)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 != 0) goto L_0x00d5
            goto L_0x00db
        L_0x00d5:
            int r6 = r6.intValue()
            if (r6 == r8) goto L_0x0120
        L_0x00db:
            com.m2catalyst.m2sdk.q r6 = r0.d
            com.m2catalyst.m2sdk.c3 r3 = r3.a()
            com.m2catalyst.m2sdk.g2 r7 = r0.e
            r4.a = r0
            r4.b = r2
            r4.c = r3
            r4.d = r6
            r4.e = r1
            r4.h = r12
            java.lang.Object r7 = r7.a((kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location>) r4)
            if (r7 != r5) goto L_0x00f6
            return r5
        L_0x00f6:
            r8 = r0
            r16 = r7
            r7 = r3
            r3 = r16
        L_0x00fc:
            com.m2catalyst.m2sdk.business.models.M2Location r3 = (com.m2catalyst.m2sdk.business.models.M2Location) r3
            com.m2catalyst.m2sdk.business.models.NoSignalData r3 = r6.a((com.m2catalyst.m2sdk.c3) r7, (com.m2catalyst.m2sdk.business.models.M2Location) r3)
            if (r3 == 0) goto L_0x011d
            com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository r6 = r8.c
            com.m2catalyst.m2sdk.business.models.NoSignalData[] r7 = new com.m2catalyst.m2sdk.business.models.NoSignalData[r12]
            r7[r11] = r3
            r4.a = r8
            r4.b = r2
            r4.c = r10
            r4.d = r10
            r4.e = r1
            r4.h = r9
            java.lang.Object r3 = r6.addNoSignalRecord(r7, r4)
            if (r3 != r5) goto L_0x011d
            return r5
        L_0x011d:
            r4 = r8
            goto L_0x019f
        L_0x0120:
            r3.a((android.telephony.ServiceState) r2)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r6 = new com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot
            android.content.Context r9 = r0.a
            r6.<init>(r9, r1)
            r3.a((com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot) r6)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r6 = r0.l
            long r14 = r3.l()
            java.lang.String r9 = a(r14)
            long r14 = r3.l()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r7 = "TRIGGER ----- storeServiceState      new time= "
            r12.<init>(r7)
            r12.append(r9)
            java.lang.String r7 = " timestamp = "
            r12.append(r7)
            r12.append(r14)
            java.lang.String r7 = r12.toString()
            java.lang.String[] r9 = new java.lang.String[r11]
            r6.d(r13, r7, r9)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r6 = r0.l
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "                                     serviceState= "
            r7.<init>(r9)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.String[] r9 = new java.lang.String[r11]
            r6.d(r13, r7, r9)
            com.m2catalyst.m2sdk.c3 r6 = r3.a()
            com.m2catalyst.m2sdk.g2 r3 = r0.e
            r4.a = r0
            r4.b = r2
            r4.c = r6
            r4.d = r0
            r4.e = r1
            r4.h = r8
            java.lang.Object r3 = r3.a((kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location>) r4)
            if (r3 != r5) goto L_0x0184
            return r5
        L_0x0184:
            r9 = r0
            r7 = r6
            r6 = r3
            r3 = r9
        L_0x0188:
            com.m2catalyst.m2sdk.business.models.M2Location r6 = (com.m2catalyst.m2sdk.business.models.M2Location) r6
            r4.a = r9
            r4.b = r2
            r4.c = r10
            r4.d = r10
            r4.e = r1
            r8 = 4
            r4.h = r8
            java.lang.Object r3 = r3.a((com.m2catalyst.m2sdk.c3) r7, (com.m2catalyst.m2sdk.business.models.M2Location) r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4)
            if (r3 != r5) goto L_0x019e
            return r5
        L_0x019e:
            r4 = r9
        L_0x019f:
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.util.LinkedHashMap r3 = r4.m
            int r2 = r2.getState()
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            r3.put(r1, r2)
        L_0x01b0:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q3.a(int, android.telephony.ServiceState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(int r12, android.telephony.SignalStrength r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.m2catalyst.m2sdk.q3.e
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.m2catalyst.m2sdk.q3$e r0 = (com.m2catalyst.m2sdk.q3.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.q3$e r0 = new com.m2catalyst.m2sdk.q3$e
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x003e
            if (r2 == r3) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00f9
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            com.m2catalyst.m2sdk.q3 r12 = r0.b
            com.m2catalyst.m2sdk.c3 r13 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e9
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r2 = new java.lang.String[r4]
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r5 = r11.h
            java.lang.Object r5 = r5.get(r12)
            if (r5 != 0) goto L_0x0050
            java.lang.String r5 = " not found"
            goto L_0x0052
        L_0x0050:
            java.lang.String r5 = " found"
        L_0x0052:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Subscriber "
            r6.<init>(r7)
            r6.append(r12)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r2[r6] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "SignalStrength: "
            r5.<init>(r7)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2[r3] = r5
            java.lang.String r5 = "MNSI_BUILDER"
            java.lang.String r7 = "NetworkCollectionManager storeSignalStrength"
            r14.v(r5, r7, r2)
            android.util.SparseArray<com.m2catalyst.m2sdk.c3> r14 = r11.h
            java.lang.Object r14 = r14.get(r12)
            com.m2catalyst.m2sdk.c3 r14 = (com.m2catalyst.m2sdk.c3) r14
            if (r14 == 0) goto L_0x00f9
            com.m2catalyst.m2sdk.r1.a()
            r14.a((android.telephony.SignalStrength) r13)
            com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot r2 = new com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot
            android.content.Context r7 = r11.a
            r2.<init>(r7, r12)
            r14.a((com.m2catalyst.m2sdk.business.models.NetworkInfoSnapshot) r2)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r11.l
            long r7 = r14.m()
            java.lang.String r2 = a(r7)
            long r7 = r14.m()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "TRIGGER ----- storeSignalStrength    new time= "
            r9.<init>(r10)
            r9.append(r2)
            java.lang.String r2 = " timestamp = "
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r9.toString()
            java.lang.String[] r7 = new java.lang.String[r6]
            r12.d(r5, r2, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r11.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = "                                     signalStrength= "
            r2.<init>(r7)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            java.lang.String[] r2 = new java.lang.String[r6]
            r12.d(r5, r13, r2)
            com.m2catalyst.m2sdk.c3 r13 = r14.a()
            com.m2catalyst.m2sdk.g2 r12 = r11.e
            r0.a = r13
            r0.b = r11
            r0.e = r3
            java.lang.Object r14 = r12.a((kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location>) r0)
            if (r14 != r1) goto L_0x00e8
            return r1
        L_0x00e8:
            r12 = r11
        L_0x00e9:
            com.m2catalyst.m2sdk.business.models.M2Location r14 = (com.m2catalyst.m2sdk.business.models.M2Location) r14
            r2 = 0
            r0.a = r2
            r0.b = r2
            r0.e = r4
            java.lang.Object r12 = r12.a((com.m2catalyst.m2sdk.c3) r13, (com.m2catalyst.m2sdk.business.models.M2Location) r14, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x00f9
            return r1
        L_0x00f9:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q3.a(int, android.telephony.SignalStrength, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(int i2, TelephonyDisplayInfo telephonyDisplayInfo) {
        Intrinsics.checkNotNullParameter(telephonyDisplayInfo, "telephonyDisplayInfo");
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        String[] strArr = new String[2];
        String str = this.h.get(i2) == null ? " not found" : " found";
        strArr[0] = "Subscriber " + i2 + str;
        StringBuilder sb = new StringBuilder("TelephonyDisplayInfo: ");
        sb.append(telephonyDisplayInfo);
        strArr[1] = sb.toString();
        companion.v("MNSI_BUILDER", "NetworkCollectionManager storeDisplayInfo", strArr);
        c3 c3Var = this.h.get(i2);
        if (c3Var != null) {
            M2SDKLogger m2SDKLogger = this.l;
            String a2 = a(c3Var.p());
            long p = c3Var.p();
            m2SDKLogger.d("MNSI_BUILDER", "TRIGGER ----- setDisplayInfo         new time= " + a2 + " timestamp = " + p, new String[0]);
            M2SDKLogger m2SDKLogger2 = this.l;
            StringBuilder sb2 = new StringBuilder("                                     telephonyDisplayInfo= ");
            sb2.append(telephonyDisplayInfo);
            m2SDKLogger2.d("MNSI_BUILDER", sb2.toString(), new String[0]);
            c3Var.a((Object) telephonyDisplayInfo);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.m2catalyst.m2sdk.business.models.M2Location r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.q3.b
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.q3$b r0 = (com.m2catalyst.m2sdk.q3.b) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.q3$b r0 = new com.m2catalyst.m2sdk.q3$b
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.g
            r3 = 1
            java.lang.String r4 = "MNSI_BUILDER"
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            kotlin.Pair r14 = r0.d
            java.util.Iterator r2 = r0.c
            com.m2catalyst.m2sdk.business.models.M2Location r6 = r0.b
            com.m2catalyst.m2sdk.q3 r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00ce
        L_0x0035:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r15)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r15 = r13.l
            java.util.concurrent.ConcurrentLinkedQueue<kotlin.Pair<com.m2catalyst.m2sdk.business.models.MNSI, com.m2catalyst.m2sdk.c3>> r2 = r13.i
            int r2 = r2.size()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "processMNSIWithInvalidLocation queuedMNSIForBetterLocation.size="
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            java.lang.String[] r6 = new java.lang.String[r5]
            r15.d(r4, r2, r6)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r15 = r13.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "LOCATION - "
            r2.<init>(r6)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r6 = new java.lang.String[r5]
            r15.d(r4, r2, r6)
            java.util.concurrent.ConcurrentLinkedQueue<kotlin.Pair<com.m2catalyst.m2sdk.business.models.MNSI, com.m2catalyst.m2sdk.c3>> r15 = r13.i
            java.util.Iterator r15 = r15.iterator()
            r7 = r13
            r2 = r15
        L_0x0078:
            boolean r15 = r2.hasNext()
            if (r15 == 0) goto L_0x00ec
            java.lang.Object r15 = r2.next()
            kotlin.Pair r15 = (kotlin.Pair) r15
            java.lang.Object r6 = r15.getFirst()
            com.m2catalyst.m2sdk.business.models.MNSI r6 = (com.m2catalyst.m2sdk.business.models.MNSI) r6
            long r8 = r6.getTimeStamp()
            long r10 = r14.getTimeStamp()
            long r8 = r8 - r10
            long r8 = java.lang.Math.abs(r8)
            r10 = 6
            long r10 = com.m2catalyst.m2sdk.o1.c(r10)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d1
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = r7.l
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "QUEUED MNSI TRY TO SAVE - MNSI "
            r9.<init>(r10)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.String[] r9 = new java.lang.String[r5]
            r8.d(r4, r6, r9)
            java.lang.Object r6 = r15.getSecond()
            com.m2catalyst.m2sdk.c3 r6 = (com.m2catalyst.m2sdk.c3) r6
            r0.a = r7
            r0.b = r14
            r0.c = r2
            r0.d = r15
            r0.g = r3
            java.lang.Object r6 = r7.a((com.m2catalyst.m2sdk.c3) r6, (com.m2catalyst.m2sdk.business.models.M2Location) r14, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x00cc
            return r1
        L_0x00cc:
            r6 = r14
            r14 = r15
        L_0x00ce:
            r15 = r14
            r14 = r6
            goto L_0x00e6
        L_0x00d1:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = r7.l
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "NO SAVE QUEUED MNSI "
            r9.<init>(r10)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.String[] r9 = new java.lang.String[r5]
            r8.d(r4, r6, r9)
        L_0x00e6:
            java.util.concurrent.ConcurrentLinkedQueue<kotlin.Pair<com.m2catalyst.m2sdk.business.models.MNSI, com.m2catalyst.m2sdk.c3>> r6 = r7.i
            r6.remove(r15)
            goto L_0x0078
        L_0x00ec:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.q3.a(com.m2catalyst.m2sdk.business.models.M2Location, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
