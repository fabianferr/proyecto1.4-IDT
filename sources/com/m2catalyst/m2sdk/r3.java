package com.m2catalyst.m2sdk;

import android.util.SparseArray;
import com.m2catalyst.m2sdk.business.models.M2Location;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionManager$onNewLocationCollected$2", f = "NetworkCollectionManager.kt", i = {1, 1}, l = {499, 509}, m = "invokeSuspend", n = {"$this$forEach$iv", "index$iv"}, s = {"L$0", "I$0"})
/* compiled from: NetworkCollectionManager.kt */
public final class r3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public SparseArray a;
    public q3 b;
    public M2Location c;
    public int d;
    public int e;
    public int f;
    public final /* synthetic */ M2Location g;
    public final /* synthetic */ q3 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r3(M2Location m2Location, q3 q3Var, Continuation<? super r3> continuation) {
        super(2, continuation);
        this.g = m2Location;
        this.h = q3Var;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r3(this.g, this.h, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((r3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 == r5) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            int r2 = r0.e
            int r6 = r0.d
            com.m2catalyst.m2sdk.business.models.M2Location r7 = r0.c
            com.m2catalyst.m2sdk.q3 r8 = r0.b
            android.util.SparseArray r9 = r0.a
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r3 = 1
            r5 = 2
            goto L_0x00c5
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x004a
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r17)
            com.m2catalyst.m2sdk.external.SDKState$Companion r2 = com.m2catalyst.m2sdk.external.SDKState.Companion
            com.m2catalyst.m2sdk.external.SDKState r2 = r2.getInstance()
            com.m2catalyst.m2sdk.business.models.M2Location r6 = r0.g
            r2.setM2Location$m2sdk_release(r6)
            com.m2catalyst.m2sdk.q3 r2 = r0.h
            com.m2catalyst.m2sdk.business.models.M2Location r6 = r0.g
            r0.f = r5
            java.lang.Object r2 = r2.a((com.m2catalyst.m2sdk.business.models.M2Location) r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r2 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.m2catalyst.m2sdk.q3 r2 = r0.h
            android.util.SparseArray r2 = r2.c()
            com.m2catalyst.m2sdk.q3 r6 = r0.h
            com.m2catalyst.m2sdk.business.models.M2Location r7 = r0.g
            int r8 = r2.size()
            r10 = r0
            r9 = r2
            r2 = r8
            r8 = r6
            r6 = 0
        L_0x005d:
            if (r6 >= r2) goto L_0x00c9
            r9.keyAt(r6)
            java.lang.Object r11 = r9.valueAt(r6)
            com.m2catalyst.m2sdk.c3 r11 = (com.m2catalyst.m2sdk.c3) r11
            com.m2catalyst.m2sdk.logger.M2SDKLogger r12 = r8.b()
            long r13 = r7.getTime()
            java.lang.String r13 = com.m2catalyst.m2sdk.q3.a(r13)
            long r14 = r7.getTime()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r3 = "TRIGGER ----- onNewLocationCollected new time= "
            r5.<init>(r3)
            r5.append(r13)
            java.lang.String r3 = " timestamp = "
            r5.append(r3)
            r5.append(r14)
            java.lang.String r3 = r5.toString()
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r13 = "MNSI_BUILDER"
            r12.d(r13, r3, r5)
            com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r8.b()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r12 = "                                     location= "
            r5.<init>(r12)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String[] r12 = new java.lang.String[r4]
            r3.d(r13, r5, r12)
            com.m2catalyst.m2sdk.c3 r3 = r11.a()
            r10.a = r9
            r10.b = r8
            r10.c = r7
            r10.d = r6
            r10.e = r2
            r5 = 2
            r10.f = r5
            java.lang.Object r3 = r8.a((com.m2catalyst.m2sdk.c3) r3, (com.m2catalyst.m2sdk.business.models.M2Location) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r10)
            if (r3 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            r3 = 1
        L_0x00c5:
            int r6 = r6 + r3
            r3 = 2
            r5 = 1
            goto L_0x005d
        L_0x00c9:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.r3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
