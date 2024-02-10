package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.NonCancellable;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionOrchestrator$startRepeatingJob$1", f = "NetworkCollectionOrchestrator.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkCollectionOrchestrator.kt */
public final class w3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ v3 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Context d;

    /* compiled from: NetworkCollectionOrchestrator.kt */
    public static final class a extends TelephonyManager.CellInfoCallback {
        public final void onCellInfo(List<? extends CellInfo> list) {
            Intrinsics.checkNotNullParameter(list, "list");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w3(v3 v3Var, long j, Context context, Continuation<? super w3> continuation) {
        super(2, continuation);
        this.b = v3Var;
        this.c = j;
        this.d = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new w3(this.b, this.c, this.d, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((w3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.a;
        if (i2 == 0 || i2 == 1) {
            ResultKt.throwOnFailure(obj);
            while (NonCancellable.INSTANCE.isActive()) {
                SparseArray<TelephonyManager> sparseArray = this.b.e;
                Context context = this.d;
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    sparseArray.keyAt(i3);
                    TelephonyManager valueAt = sparseArray.valueAt(i3);
                    if (Build.VERSION.SDK_INT >= 29) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        try {
                            i = context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
                        } catch (RuntimeException unused) {
                            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.ACCESS_FINE_LOCATION");
                        }
                        if (i == 0) {
                            valueAt.requestCellInfoUpdate(Executors.newCachedThreadPool(), new a());
                        }
                    }
                }
                long j = this.c;
                this.a = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
