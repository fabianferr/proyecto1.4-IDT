package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.data_transmission.TransmissionSDKReceiver;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_transmission.TransmissionManager$transmit$1", f = "TransmissionManager.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmissionManager.kt */
public final class y6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ x6 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Context d;

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_transmission.TransmissionManager$transmit$1$1", f = "TransmissionManager.kt", i = {0, 1}, l = {156, 157}, m = "invokeSuspend", n = {"lastSubmission", "lastSubmission"}, s = {"L$0", "L$0"})
    /* compiled from: TransmissionManager.kt */
    public static final class a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public Ref.ObjectRef a;
        public Ref.ObjectRef b;
        public int c;
        public final /* synthetic */ x6 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(x6 x6Var, Continuation<? super a> continuation) {
            super(1, continuation);
            this.d = x6Var;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new a(this.d, continuation);
        }

        public final Object invoke(Object obj) {
            return ((a) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.c
                r3 = 2
                r4 = 1
                java.lang.String r5 = "TransmissionManager"
                r6 = 0
                if (r2 == 0) goto L_0x002f
                if (r2 == r4) goto L_0x0023
                if (r2 != r3) goto L_0x001b
                kotlin.jvm.internal.Ref$ObjectRef r1 = r0.a
                kotlin.ResultKt.throwOnFailure(r17)
                r3 = r17
                goto L_0x006f
            L_0x001b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0023:
                kotlin.jvm.internal.Ref$ObjectRef r2 = r0.b
                kotlin.jvm.internal.Ref$ObjectRef r4 = r0.a
                kotlin.ResultKt.throwOnFailure(r17)
                r7 = r2
                r2 = r4
                r4 = r17
                goto L_0x0058
            L_0x002f:
                kotlin.ResultKt.throwOnFailure(r17)
                com.m2catalyst.m2sdk.x6 r2 = r0.d
                com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.c
                java.lang.String[] r7 = new java.lang.String[r6]
                java.lang.String r8 = "ingestionManager.executeAfterVerification"
                r2.i(r5, r8, r7)
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                com.m2catalyst.m2sdk.x6 r7 = r0.d
                com.m2catalyst.m2sdk.business.repositories.MNSIRepository r7 = com.m2catalyst.m2sdk.x6.d(r7)
                r0.a = r2
                r0.b = r2
                r0.c = r4
                java.lang.Object r4 = r7.buildAndSubmit(r0)
                if (r4 != r1) goto L_0x0057
                return r1
            L_0x0057:
                r7 = r2
            L_0x0058:
                r7.element = r4
                com.m2catalyst.m2sdk.x6 r4 = r0.d
                com.m2catalyst.m2sdk.business.repositories.LocationRepository r4 = com.m2catalyst.m2sdk.x6.c(r4)
                r0.a = r2
                r7 = 0
                r0.b = r7
                r0.c = r3
                java.lang.Object r3 = r4.buildAndSubmit(r0)
                if (r3 != r1) goto L_0x006e
                return r1
            L_0x006e:
                r1 = r2
            L_0x006f:
                java.lang.Long r3 = (java.lang.Long) r3
                if (r3 == 0) goto L_0x007d
                long r2 = r3.longValue()
                java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2)
                r1.element = r2
            L_0x007d:
                T r1 = r1.element
                java.lang.Long r1 = (java.lang.Long) r1
                if (r1 == 0) goto L_0x00d0
                com.m2catalyst.m2sdk.x6 r2 = r0.d
                long r3 = r1.longValue()
                com.m2catalyst.m2sdk.r2 r1 = r2.a
                com.m2catalyst.m2sdk.z5 r1 = r1.a()
                com.m2catalyst.m2sdk.a6 r7 = com.m2catalyst.m2sdk.a6.LAST_TIME_DATA_TRANSMITTED
                java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
                r1.a(r7, r8)
                com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r2.c
                java.lang.String r2 = com.m2catalyst.m2sdk.o1.a((long) r3)
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "Data transmission at "
                r7.<init>(r8)
                r7.append(r2)
                java.lang.String r2 = r7.toString()
                java.lang.String[] r6 = new java.lang.String[r6]
                r1.i(r5, r2, r6)
                com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r9 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
                java.lang.String r1 = com.m2catalyst.m2sdk.o1.a((long) r3)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r8)
                r2.append(r1)
                java.lang.String r10 = r2.toString()
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 14
                r15 = 0
                com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r9, r10, r11, r12, r13, r14, r15)
            L_0x00d0:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.y6.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y6(x6 x6Var, boolean z, Context context, Continuation<? super y6> continuation) {
        super(2, continuation);
        this.b = x6Var;
        this.c = z;
        this.d = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new y6(this.b, this.c, this.d, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((y6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.b.c.d("TransmissionManager", "transmit -- block mutex", new String[0]);
            if (!this.c) {
                z5 a2 = this.b.a.a();
                a6 a6Var = a6.CROWDSOURCE_SHARING_ENABLED;
                Object boxBoolean = Boxing.boxBoolean(true);
                String c2 = a6Var.c();
                if (a2.a().getAll().containsKey(c2)) {
                    boxBoolean = a2.a().getAll().get(c2);
                }
                Intrinsics.checkNotNull(boxBoolean);
                if (!((Boolean) boxBoolean).booleanValue()) {
                    this.b.c.i("TransmissionManager", "Data transmission not enabled in SDK", new String[0]);
                    M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, "Data transmission not enabled in SDK", (String) null, (Map) null, false, 14, (Object) null);
                }
            }
            x1 b2 = x6.b(this.b);
            a aVar = new a(this.b, (Continuation<? super a>) null);
            this.a = 1;
            if (b2.a(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                M2SDKLogger e = this.b.c;
                String stackTraceToString = ExceptionsKt.stackTraceToString(th);
                e.e("TransmissionManager", "Error transmitting data" + stackTraceToString, new String[0]);
                M2SDKLogger.Companion companion = M2SDKLogger.Companion;
                String stackTraceToString2 = ExceptionsKt.stackTraceToString(th);
                M2SDKLogger.Companion.log$default(companion, "Error transmitting data" + stackTraceToString2, (String) null, (Map) null, false, 14, (Object) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z5 a3 = this.b.a.a();
        a6 a6Var2 = a6.NEXT_TIME_DATA_TRANSMISSION;
        long j = 0;
        Object boxLong = Boxing.boxLong(0);
        String c3 = a6Var2.c();
        if (a3.a().getAll().containsKey(c3)) {
            boxLong = a3.a().getAll().get(c3);
        }
        Long l = (Long) boxLong;
        if (l != null) {
            j = l.longValue();
        }
        x6 x6Var = this.b;
        long a4 = x6Var.a(x6Var.a.a(false), this.d);
        if (j < System.currentTimeMillis()) {
            j = o1.b(1) + System.currentTimeMillis() + a4;
            this.b.a.a().a(a6Var2, Boxing.boxLong(j));
        }
        x6 x6Var2 = this.b;
        Context context = this.d;
        x6Var2.getClass();
        x6.a(context, TransmissionSDKReceiver.TRANSMISSION_INGESTION_ALARM_ACTION, j, a4);
        return Unit.INSTANCE;
    }
}
