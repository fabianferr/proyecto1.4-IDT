package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.CollectionOrchestrator$restartCollection$1", f = "CollectionOrchestrator.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CollectionOrchestrator.kt */
public final class t0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ u0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t0(u0 u0Var, Continuation<? super t0> continuation) {
        super(2, continuation);
        this.b = u0Var;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new t0(this.b, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((t0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            v3 v3Var = (v3) this.b.a.getValue();
            this.a = 1;
            v3Var.e();
            Object a2 = v3Var.a((Continuation<? super Boolean>) this);
            if (a2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                a2 = Unit.INSTANCE;
            }
            if (a2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        companion.i("permission_logs", "NetworkCollectionOrchestrator restarted", new String[0]);
        g2 g2Var = (g2) ((e2) this.b.b.getValue()).a.getValue();
        g2Var.getClass();
        companion.d(g2Var.a, "restart()", new String[0]);
        companion.d(g2Var.a, "stop()", new String[0]);
        g2Var.h = false;
        companion.d(g2Var.a, "start()", new String[0]);
        g2Var.h = true;
        g2Var.d();
        companion.i("permission_logs", "LocationCollectionOrchestrator restarted", new String[0]);
        d7 d7Var = (d7) this.b.c.getValue();
        d7Var.a.b();
        if (d7Var.d) {
            d7Var.d = false;
            try {
                ((Context) d7Var.b.getValue()).getApplicationContext().unregisterReceiver((WifiSDKReceiver) d7Var.c.getValue());
            } catch (IllegalArgumentException unused) {
                M2SDKLogger.Companion.e("WifiCollectionOrchestrator", "wifi receiver is not registered to be unregistered", new String[0]);
            }
        }
        d7Var.a();
        companion.i("permission_logs", "WifiCollectionOrchestrator restarted", new String[0]);
        return Unit.INSTANCE;
    }
}
