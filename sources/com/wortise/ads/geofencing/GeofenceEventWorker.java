package com.wortise.ads.geofencing;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import com.google.gson.reflect.TypeToken;
import com.wortise.ads.AdResponse;
import com.wortise.ads.e7;
import com.wortise.ads.geofencing.models.GeofenceEvent;
import com.wortise.ads.q4;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\r\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/wortise/ads/geofencing/GeofenceEventWorker;", "Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/AdResponse;", "a", "Lkotlin/Lazy;", "()Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "b", "()Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "event", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceEventWorker.kt */
public final class GeofenceEventWorker extends CoroutineWorker {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private final Lazy a = LazyKt.lazy(new b(this));
    private final Lazy b = LazyKt.lazy(new d(this));

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/geofencing/GeofenceEventWorker$a;", "", "Landroid/content/Context;", "context", "", "adResponse", "Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "event", "Landroidx/work/Operation;", "a", "KEY_AD_RESPONSE", "Ljava/lang/String;", "KEY_EVENT", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GeofenceEventWorker.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Operation a(Context context, String str, GeofenceEvent geofenceEvent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "adResponse");
            try {
                WorkManager b = e7.b(context);
                Data.Builder putString = new Data.Builder().putString("adResponse", str);
                Intrinsics.checkNotNullExpressionValue(putString, "Builder()\n              …_AD_RESPONSE, adResponse)");
                Data build = e7.a(putString, "event", geofenceEvent).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …             .build    ()");
                WorkRequest build2 = ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(GeofenceEventWorker.class).setInputData(build)).build();
                Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequestBuilde…\n                .build()");
                OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) build2;
                if (b != null) {
                    return b.enqueue((WorkRequest) oneTimeWorkRequest);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lcom/wortise/ads/AdResponse;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GeofenceEventWorker.kt */
    static final class b extends Lambda implements Function0<AdResponse> {
        final /* synthetic */ GeofenceEventWorker a;

        @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* compiled from: JsonParser.kt */
        public static final class a extends TypeToken<AdResponse> {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GeofenceEventWorker geofenceEventWorker) {
            super(0);
            this.a = geofenceEventWorker;
        }

        /* renamed from: a */
        public final AdResponse invoke() {
            Data inputData = this.a.getInputData();
            Intrinsics.checkNotNullExpressionValue(inputData, "inputData");
            Object obj = null;
            try {
                String string = inputData.getString("adResponse");
                if (string != null) {
                    q4 q4Var = q4.a;
                    Type type = new a().getType();
                    Intrinsics.checkNotNullExpressionValue(type, "object: TypeToken<T>() {}.type");
                    obj = q4Var.a(string, type);
                }
            } catch (Throwable unused) {
            }
            return (AdResponse) obj;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.geofencing.GeofenceEventWorker", f = "GeofenceEventWorker.kt", i = {}, l = {39}, m = "doWork", n = {}, s = {})
    /* compiled from: GeofenceEventWorker.kt */
    static final class c extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ GeofenceEventWorker b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(GeofenceEventWorker geofenceEventWorker, Continuation<? super c> continuation) {
            super(continuation);
            this.b = geofenceEventWorker;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.doWork(this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GeofenceEventWorker.kt */
    static final class d extends Lambda implements Function0<GeofenceEvent> {
        final /* synthetic */ GeofenceEventWorker a;

        @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* compiled from: JsonParser.kt */
        public static final class a extends TypeToken<GeofenceEvent> {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(GeofenceEventWorker geofenceEventWorker) {
            super(0);
            this.a = geofenceEventWorker;
        }

        /* renamed from: a */
        public final GeofenceEvent invoke() {
            Data inputData = this.a.getInputData();
            Intrinsics.checkNotNullExpressionValue(inputData, "inputData");
            Object obj = null;
            try {
                String string = inputData.getString("event");
                if (string != null) {
                    q4 q4Var = q4.a;
                    Type type = new a().getType();
                    Intrinsics.checkNotNullExpressionValue(type, "object: TypeToken<T>() {}.type");
                    obj = q4Var.a(string, type);
                }
            } catch (Throwable unused) {
            }
            return (GeofenceEvent) obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GeofenceEventWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    private final AdResponse a() {
        return (AdResponse) this.a.getValue();
    }

    private final GeofenceEvent b() {
        return (GeofenceEvent) this.b.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.wortise.ads.geofencing.GeofenceEventWorker.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.geofencing.GeofenceEventWorker$c r0 = (com.wortise.ads.geofencing.GeofenceEventWorker.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.geofencing.GeofenceEventWorker$c r0 = new com.wortise.ads.geofencing.GeofenceEventWorker$c
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0066
        L_0x0029:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "Geofence worker called"
            r2 = 2
            r4 = 0
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r8, (java.lang.Throwable) r4, (int) r2, (java.lang.Object) r4)
            com.wortise.ads.AdResponse r8 = r7.a()
            if (r8 == 0) goto L_0x0071
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            com.wortise.ads.geofencing.models.GeofenceEvent r4 = r7.b()
            java.lang.String r5 = "event"
            r2.putParcelable(r5, r4)
            com.wortise.ads.t5 r4 = new com.wortise.ads.t5
            android.content.Context r5 = r7.getApplicationContext()
            java.lang.String r6 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r4.<init>(r5, r8, r2)
            r0.c = r3
            java.lang.Object r8 = r4.a((kotlin.coroutines.Continuation<? super java.lang.Boolean>) r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r0 = "success()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            return r8
        L_0x0071:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.geofencing.GeofenceEventWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
