package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.wortise.ads.consent.ConsentManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/wortise/ads/k;", "", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest$Builder;", "Landroid/content/Context;", "context", "", "a", "(Lcom/google/android/gms/ads/admanager/AdManagerAdRequest$Builder;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdRequestFactory.kt */
public final class k {
    public static final k a = new k();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.google.factories.AdRequestFactory", f = "AdRequestFactory.kt", i = {0}, l = {19}, m = "create", n = {"$this$build_u24lambda_u2d1$iv"}, s = {"L$0"})
    /* compiled from: AdRequestFactory.kt */
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ k c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar, Continuation<? super a> continuation) {
            super(continuation);
            this.c = kVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Context) null, (Continuation<? super AdManagerAdRequest>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.google.factories.AdRequestFactory", f = "AdRequestFactory.kt", i = {0}, l = {34}, m = "setTargeting", n = {"$this$setTargeting"}, s = {"L$0"})
    /* compiled from: AdRequestFactory.kt */
    static final class b extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ k c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(k kVar, Continuation<? super b> continuation) {
            super(continuation);
            this.c = kVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((AdManagerAdRequest.Builder) null, (Context) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/d2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.google.factories.AdRequestFactory$setTargeting$data$1", f = "AdRequestFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AdRequestFactory.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d2>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super d2> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a == 0) {
                ResultKt.throwOnFailure(obj);
                return new d2(this.b, (Location) null, true, 2, (DefaultConstructorMarker) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private k() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r5, kotlin.coroutines.Continuation<? super com.google.android.gms.ads.admanager.AdManagerAdRequest> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.wortise.ads.k.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.k$a r0 = (com.wortise.ads.k.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.k$a r0 = new com.wortise.ads.k$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r5 = (com.google.android.gms.ads.admanager.AdManagerAdRequest.Builder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r6 = new com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder
            r6.<init>()
            com.wortise.ads.k r2 = a
            r2.a((com.google.android.gms.ads.admanager.AdManagerAdRequest.Builder) r6, (android.content.Context) r5)
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = r2.a(r6, r5, r0)
            if (r5 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r5 = r6
        L_0x004e:
            com.google.android.gms.ads.admanager.AdManagerAdRequest r5 = r5.build()
            java.lang.String r6 = "build"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.k.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void a(AdManagerAdRequest.Builder builder, Context context) {
        Bundle bundle = new Bundle();
        if (!ConsentManager.canRequestPersonalizedAds(context)) {
            bundle.putString("npa", "1");
        }
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7 A[SYNTHETIC, Splitter:B:33:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf A[SYNTHETIC, Splitter:B:40:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.google.android.gms.ads.admanager.AdManagerAdRequest.Builder r6, android.content.Context r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.wortise.ads.k.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.k$b r0 = (com.wortise.ads.k.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.k$b r0 = new com.wortise.ads.k$b
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.a
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r6 = (com.google.android.gms.ads.admanager.AdManagerAdRequest.Builder) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004d
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.k$c r2 = new com.wortise.ads.k$c
            r2.<init>(r7, r4)
            r0.a = r6
            r0.d = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            com.wortise.ads.d2 r8 = (com.wortise.ads.d2) r8
            java.util.List r7 = r8.a()
            if (r7 != 0) goto L_0x0056
            goto L_0x007e
        L_0x0056:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0065:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r7.next()
            com.wortise.ads.q6 r1 = (com.wortise.ads.q6) r1
            java.lang.String r1 = r1.a()
            r0.add(r1)
            goto L_0x0065
        L_0x0079:
            java.lang.String r7 = "apps"
            r6.addCustomTargeting((java.lang.String) r7, (java.util.List<java.lang.String>) r0)
        L_0x007e:
            com.wortise.ads.q0 r7 = r8.b()
            if (r7 != 0) goto L_0x0085
            goto L_0x00dc
        L_0x0085:
            java.lang.Integer r0 = r7.a()
            java.lang.String r1 = "battery_capacity"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.battery.BatteryHealth r0 = r7.b()
            if (r0 != 0) goto L_0x0096
        L_0x0094:
            r0 = r4
            goto L_0x00a1
        L_0x0096:
            com.google.gson.Gson r1 = com.wortise.ads.r4.a()     // Catch:{ all -> 0x009f }
            java.lang.String r0 = r1.toJson((java.lang.Object) r0)     // Catch:{ all -> 0x009f }
            goto L_0x00a1
        L_0x009f:
            goto L_0x0094
        L_0x00a1:
            java.lang.String r1 = "battery_health"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.Integer r0 = r7.c()
            java.lang.String r1 = "battery_level"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.battery.BatteryPlugged r0 = r7.d()
            if (r0 != 0) goto L_0x00b7
        L_0x00b5:
            r0 = r4
            goto L_0x00c2
        L_0x00b7:
            com.google.gson.Gson r1 = com.wortise.ads.r4.a()     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r1.toJson((java.lang.Object) r0)     // Catch:{ all -> 0x00c0 }
            goto L_0x00c2
        L_0x00c0:
            goto L_0x00b5
        L_0x00c2:
            java.lang.String r1 = "battery_plugged"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.battery.BatteryStatus r7 = r7.e()
            if (r7 != 0) goto L_0x00cf
        L_0x00cd:
            r7 = r4
            goto L_0x00d7
        L_0x00cf:
            com.google.gson.Gson r0 = com.wortise.ads.r4.a()     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = r0.toJson((java.lang.Object) r7)     // Catch:{ all -> 0x00cd }
        L_0x00d7:
            java.lang.String r0 = "battery_status"
            com.wortise.ads.h.a(r6, r0, r7)
        L_0x00dc:
            com.wortise.ads.j1 r7 = r8.c()
            if (r7 != 0) goto L_0x00e3
            goto L_0x0125
        L_0x00e3:
            java.lang.String r0 = r7.a()
            java.lang.String r1 = "cell_carrier"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.d()
            java.lang.String r1 = "cell_network_country"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.network.models.CellNetworkType r0 = r7.e()
            if (r0 != 0) goto L_0x00fd
        L_0x00fb:
            r0 = r4
            goto L_0x0105
        L_0x00fd:
            com.google.gson.Gson r1 = com.wortise.ads.r4.a()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = r1.toJson((java.lang.Object) r0)     // Catch:{ all -> 0x00fb }
        L_0x0105:
            java.lang.String r1 = "cell_network_type"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.b()
            java.lang.String r1 = "cell_mcc"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.c()
            java.lang.String r1 = "cell_mnc"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r7 = r7.f()
            java.lang.String r0 = "cell_sim_country"
            com.wortise.ads.h.a(r6, r0, r7)
        L_0x0125:
            com.wortise.ads.api.submodels.UserLocation r7 = r8.d()
            if (r7 != 0) goto L_0x012d
            goto L_0x01eb
        L_0x012d:
            com.wortise.ads.api.submodels.UserLocation$Accuracy r0 = r7.a()
            java.lang.Float r0 = r0.a()
            java.lang.String r1 = "location_accuracy"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.api.submodels.UserLocation$Accuracy r0 = r7.a()
            java.lang.Float r0 = r0.b()
            java.lang.String r1 = "location_accuracy_vertical"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.b()
            java.lang.String r1 = "location_admin_area"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.Double r0 = r7.c()
            java.lang.String r1 = "location_altitude"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.Float r0 = r7.d()
            java.lang.String r1 = "location_bearing"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.e()
            java.lang.String r1 = "location_city"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.f()
            java.lang.String r1 = "location_country"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.g()
            java.lang.String r1 = "location_feature"
            com.wortise.ads.h.a(r6, r1, r0)
            double r0 = r7.h()
            java.lang.Double r0 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r0)
            java.lang.String r1 = "location_latitude"
            com.wortise.ads.h.a(r6, r1, r0)
            double r0 = r7.i()
            java.lang.Double r0 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r0)
            java.lang.String r1 = "location_longitude"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.j()
            java.lang.String r1 = "location_postal_code"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.k()
            java.lang.String r1 = "location_provider"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.api.submodels.UserLocation$Speed r0 = r7.l()
            float r0 = r0.b()
            java.lang.Float r0 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r0)
            java.lang.String r1 = "location_speed"
            com.wortise.ads.h.a(r6, r1, r0)
            com.wortise.ads.api.submodels.UserLocation$Speed r0 = r7.l()
            java.lang.Float r0 = r0.a()
            java.lang.String r1 = "location_speed_accuracy"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.m()
            java.lang.String r1 = "location_sub_admin_area"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.n()
            java.lang.String r1 = "location_sub_locality"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r0 = r7.o()
            java.lang.String r1 = "location_sub_thoroughfare"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.String r7 = r7.p()
            java.lang.String r0 = "location_thoroughfare"
            com.wortise.ads.h.a(r6, r0, r7)
        L_0x01eb:
            com.wortise.ads.z4 r7 = r8.e()
            if (r7 != 0) goto L_0x01f2
            goto L_0x0210
        L_0x01f2:
            com.wortise.ads.network.models.NetworkType r0 = r7.a()
            if (r0 != 0) goto L_0x01fa
        L_0x01f8:
            r0 = r4
            goto L_0x0202
        L_0x01fa:
            com.google.gson.Gson r1 = com.wortise.ads.r4.a()     // Catch:{ all -> 0x01f8 }
            java.lang.String r0 = r1.toJson((java.lang.Object) r0)     // Catch:{ all -> 0x01f8 }
        L_0x0202:
            java.lang.String r1 = "network_type"
            com.wortise.ads.h.a(r6, r1, r0)
            java.lang.Boolean r7 = r7.b()
            java.lang.String r0 = "network_vpn"
            com.wortise.ads.h.a(r6, r0, r7)
        L_0x0210:
            com.wortise.ads.s6 r7 = r8.f()
            if (r7 != 0) goto L_0x0217
            goto L_0x0236
        L_0x0217:
            java.lang.Integer r8 = r7.a()
            java.lang.String r0 = "user_age"
            com.wortise.ads.h.a(r6, r0, r8)
            com.wortise.ads.user.UserGender r7 = r7.b()
            if (r7 != 0) goto L_0x0228
            goto L_0x0230
        L_0x0228:
            com.google.gson.Gson r8 = com.wortise.ads.r4.a()     // Catch:{ all -> 0x0230 }
            java.lang.String r4 = r8.toJson((java.lang.Object) r7)     // Catch:{ all -> 0x0230 }
        L_0x0230:
            java.lang.String r7 = "user_gender"
            com.wortise.ads.h.a(r6, r7, r4)
        L_0x0236:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.k.a(com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
