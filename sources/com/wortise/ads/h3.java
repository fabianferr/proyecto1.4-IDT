package com.wortise.ads;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import com.wortise.ads.geofencing.GeosmartWorker;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0004\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0004\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u001a\u0010\u000e\u001a\u00020\r8\u0014X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/h3;", "Lcom/wortise/ads/j0;", "Lcom/wortise/ads/e3;", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "config", "", "Landroidx/work/Data;", "b", "", "interval", "Lcom/wortise/ads/f3;", "Landroidx/work/Constraints;", "constraints", "Landroidx/work/Constraints;", "e", "()Landroidx/work/Constraints;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeosmartWorkerJob.kt */
public final class h3 extends j0<e3> {
    private final Constraints g;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.geofencing.jobs.GeosmartWorkerJob", f = "GeosmartWorkerJob.kt", i = {0}, l = {27}, m = "onStop", n = {"this"}, s = {"L$0"})
    /* compiled from: GeosmartWorkerJob.kt */
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ h3 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h3 h3Var, Continuation<? super a> continuation) {
            super(continuation);
            this.c = h3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super Unit>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h3(Context context) {
        super(Reflection.getOrCreateKotlinClass(GeosmartWorker.class), context, "com.wortise.ads.geofencing.Geosmart", 2, TimeUnit.HOURS);
        Intrinsics.checkNotNullParameter(context, "context");
        Constraints build = z1.a(new Constraints.Builder()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ed()\n            .build()");
        this.g = build;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Data a(e3 e3Var) {
        String str;
        Data.Builder builder = new Data.Builder();
        if (e3Var == null) {
            str = null;
        } else {
            str = e3Var.c();
        }
        Data build = builder.putString("adUnitId", str).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .putSt…tId)\n        .build    ()");
        return build;
    }

    /* access modifiers changed from: protected */
    public Constraints e() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wortise.ads.h3.a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.wortise.ads.h3$a r0 = (com.wortise.ads.h3.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.h3$a r0 = new com.wortise.ads.h3$a
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.a
            com.wortise.ads.h3 r0 = (com.wortise.ads.h3) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = super.a((kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            com.wortise.ads.z2 r5 = com.wortise.ads.z2.a
            android.content.Context r0 = r0.a()
            r5.a(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.h3.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public boolean a(e3 e3Var) {
        String str;
        boolean z = false;
        if (!super.a(e3Var)) {
            return false;
        }
        if (e3Var == null) {
            str = null;
        } else {
            str = e3Var.c();
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        return !z;
    }

    /* access modifiers changed from: protected */
    public f3 a(e3 e3Var, long j) {
        String str;
        if (e3Var == null) {
            str = null;
        } else {
            str = e3Var.c();
        }
        if (str != null) {
            return new f3(str, j);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
