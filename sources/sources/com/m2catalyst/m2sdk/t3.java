package com.m2catalyst.m2sdk;

import android.telephony.SubscriptionManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionOrchestrator$addSubscriptionChangeListener$2", f = "NetworkCollectionOrchestrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkCollectionOrchestrator.kt */
public final class t3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ v3 a;

    /* compiled from: NetworkCollectionOrchestrator.kt */
    public static final class a extends SubscriptionManager.OnSubscriptionsChangedListener {
        public final /* synthetic */ v3 a;

        @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.network.NetworkCollectionOrchestrator$addSubscriptionChangeListener$2$1$onSubscriptionsChanged$1", f = "NetworkCollectionOrchestrator.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.m2catalyst.m2sdk.t3$a$a  reason: collision with other inner class name */
        /* compiled from: NetworkCollectionOrchestrator.kt */
        public static final class C0127a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ v3 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0127a(v3 v3Var, Continuation<? super C0127a> continuation) {
                super(2, continuation);
                this.b = v3Var;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0127a(this.b, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0127a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    v3 v3Var = this.b;
                    this.a = 1;
                    v3Var.getClass();
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new u3(v3Var, (Continuation<? super u3>) null), this);
                    if (withContext != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        withContext = Unit.INSTANCE;
                    }
                    if (withContext == coroutine_suspended) {
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

        public a(v3 v3Var) {
            this.a = v3Var;
        }

        public final void onSubscriptionsChanged() {
            if (this.a.b()) {
                this.a.c();
                j3.a(new C0127a(this.a, (Continuation<? super C0127a>) null));
            }
            q3 q3Var = (q3) this.a.c.getValue();
            if (q3Var.e()) {
                q3Var.h.clear();
                q3Var.d();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t3(v3 v3Var, Continuation<? super t3> continuation) {
        super(2, continuation);
        this.a = v3Var;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new t3(this.a, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((t3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if ((r4 == 0) != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            kotlin.ResultKt.throwOnFailure(r4)
            com.m2catalyst.m2sdk.v3 r4 = r3.a
            android.telephony.SubscriptionManager$OnSubscriptionsChangedListener r1 = r4.i
            if (r1 != 0) goto L_0x0049
            com.m2catalyst.m2sdk.t3$a r1 = new com.m2catalyst.m2sdk.t3$a
            com.m2catalyst.m2sdk.v3 r2 = r3.a
            r1.<init>(r2)
            r4.i = r1
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r4 >= r1) goto L_0x003e
            com.m2catalyst.m2sdk.v3 r4 = r3.a
            android.content.Context r4 = r4.a()
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            int r4 = r4.checkCallingOrSelfPermission(r0)     // Catch:{ RuntimeException -> 0x002d }
            goto L_0x0037
        L_0x002d:
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            java.lang.String r2 = "context.packageManager"
            int r4 = com.m2catalyst.m2sdk.v.a(r1, r2, r4, r0)
        L_0x0037:
            if (r4 != 0) goto L_0x003b
            r4 = 1
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            if (r4 == 0) goto L_0x0049
        L_0x003e:
            com.m2catalyst.m2sdk.v3 r4 = r3.a
            android.telephony.SubscriptionManager r0 = r4.j
            if (r0 == 0) goto L_0x0049
            android.telephony.SubscriptionManager$OnSubscriptionsChangedListener r4 = r4.i
            r0.addOnSubscriptionsChangedListener(r4)
        L_0x0049:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.t3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
