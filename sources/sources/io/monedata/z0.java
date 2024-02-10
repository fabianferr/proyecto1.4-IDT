package io.monedata;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lio/monedata/z0;", "", "Landroid/content/Context;", "context", "b", "Landroid/location/Location;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Class;", "()Ljava/lang/Class;", "clazz", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class z0 {
    public static final z0 a = new z0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.managers.LocationManager", f = "LocationManager.kt", i = {}, l = {37}, m = "get", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ z0 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(z0 z0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = z0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, this);
        }
    }

    private z0() {
    }

    private final Class<?> a() {
        Class<?> cls = Class.forName("com.google.android.gms.location.FusedLocationProviderClient");
        Intrinsics.checkNotNullExpressionValue(cls, "forName(CLASS_NAME)");
        return cls;
    }

    private final Object b(Context context) {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(context)");
        return fusedLocationProviderClient;
    }

    public final Task<Location> a(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            z0 z0Var = a;
            Object invoke = z0Var.a().getMethod("getLastLocation", new Class[0]).invoke(z0Var.b(context), new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.google.android.gms.tasks.Task<android.location.Location>");
            obj = Result.m2344constructorimpl((Task) invoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        return (Task) obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r6, kotlin.coroutines.Continuation<? super android.location.Location> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.monedata.z0.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.monedata.z0$a r0 = (io.monedata.z0.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.z0$a r0 = new io.monedata.z0$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0051 }
            goto L_0x0048
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            io.monedata.z0 r7 = a     // Catch:{ all -> 0x0051 }
            com.google.android.gms.tasks.Task r6 = r7.a(r6)     // Catch:{ all -> 0x0051 }
            if (r6 == 0) goto L_0x004b
            r0.c = r4     // Catch:{ all -> 0x0051 }
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.await(r6, r0)     // Catch:{ all -> 0x0051 }
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            android.location.Location r7 = (android.location.Location) r7     // Catch:{ all -> 0x0051 }
            goto L_0x004c
        L_0x004b:
            r7 = r3
        L_0x004c:
            java.lang.Object r6 = kotlin.Result.m2344constructorimpl(r7)     // Catch:{ all -> 0x0051 }
            goto L_0x005c
        L_0x0051:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m2344constructorimpl(r6)
        L_0x005c:
            boolean r7 = kotlin.Result.m2350isFailureimpl(r6)
            if (r7 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r6
        L_0x0064:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.z0.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
