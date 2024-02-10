package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.geofencing.models.GeofencePoint;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/wortise/ads/c3;", "Lcom/wortise/ads/k0;", "", "a", "Lcom/wortise/ads/AdResponse;", "adResponse", "", "b", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofencePushModule.kt */
public final class c3 extends k0 {
    private e0 b;
    private Job c;

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.push.modules.GeofencePushModule$execute$1$1", f = "GeofencePushModule.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GeofencePushModule.kt */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ e0 b;
        final /* synthetic */ AdResponse c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e0 e0Var, AdResponse adResponse, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = e0Var;
            this.c = adResponse;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e0 e0Var = this.b;
                AdResponse adResponse = this.c;
                this.a = 1;
                if (e0Var.a(adResponse, (Continuation<? super Unit>) this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c3(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void a() {
        super.a();
        e0 e0Var = this.b;
        if (e0Var != null) {
            e0Var.a();
        }
        this.b = null;
        Job job = this.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public boolean b(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        List<GeofencePoint> h = adResponse.h();
        return !(h == null || h.isEmpty());
    }

    public void a(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        if (this.b == null) {
            e0 b2 = z2.a.b(this);
            this.b = b2;
            this.c = BuildersKt__Builders_commonKt.launch$default(b(), (CoroutineContext) null, (CoroutineStart) null, new a(b2, adResponse, (Continuation<? super a>) null), 3, (Object) null);
        }
    }
}
