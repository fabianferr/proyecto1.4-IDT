package io.monedata;

import android.content.Context;
import android.content.ContextWrapper;
import android.location.LocationManager;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.monedata.extensions.ContextKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\n\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/monedata/q0;", "Landroid/content/ContextWrapper;", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()Z", "hasBackgroundLocation", "b", "hasCoarseLocation", "c", "hasGpsLocation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class q0 extends ContextWrapper {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.managers.FeatureManager", f = "FeatureManager.kt", i = {}, l = {39}, m = "canRequestLocation", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ q0 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q0 q0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = q0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.monedata.q0.a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            io.monedata.q0$a r0 = (io.monedata.q0.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.q0$a r0 = new io.monedata.q0$a
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            io.monedata.z0 r5 = io.monedata.z0.a
            r0.c = r3
            java.lang.Object r5 = r5.a(r4, r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            if (r5 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.q0.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT < 29 || ContextKt.hasPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final boolean b() {
        return ContextKt.hasPermission(this, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public final boolean c() {
        if (!ContextKt.hasPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
            return false;
        }
        Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (!(systemService instanceof LocationManager)) {
            systemService = null;
        }
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager != null && locationManager.isProviderEnabled("gps");
    }
}
