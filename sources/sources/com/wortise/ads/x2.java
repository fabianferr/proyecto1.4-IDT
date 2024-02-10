package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/x2;", "Lcom/wortise/ads/i0;", "Landroid/location/Location;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "kotlin.jvm.PlatformType", "locationClient$delegate", "Lkotlin/Lazy;", "b", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationClient", "", "()Z", "isAvailable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: FusedLocation.kt */
public final class x2 extends i0 {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final Lazy b;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/lang/Exception;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FusedLocation.kt */
    static final class a implements OnFailureListener {
        final /* synthetic */ CancellableContinuation<Location> a;

        a(CancellableContinuation<? super Location> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            CancellableContinuation<Location> cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl((Object) null));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroid/location/Location;", "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FusedLocation.kt */
    static final class b<TResult> implements OnSuccessListener {
        final /* synthetic */ CancellableContinuation<Location> a;

        b(CancellableContinuation<? super Location> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        /* renamed from: a */
        public final void onSuccess(Location location) {
            CancellableContinuation<Location> cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(location));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Lcom/google/android/gms/location/FusedLocationProviderClient;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FusedLocation.kt */
    static final class c extends Lambda implements Function0<FusedLocationProviderClient> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.a = context;
        }

        /* renamed from: a */
        public final FusedLocationProviderClient invoke() {
            return LocationServices.getFusedLocationProviderClient(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x2(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt.lazy(new c(context));
    }

    /* access modifiers changed from: private */
    public final FusedLocationProviderClient b() {
        return (FusedLocationProviderClient) this.b.getValue();
    }

    public boolean a() {
        return super.a() && l3.a.a(this);
    }

    public Object a(Continuation<? super Location> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        b().getLastLocation().addOnFailureListener(new a(cancellableContinuationImpl)).addOnSuccessListener(new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
