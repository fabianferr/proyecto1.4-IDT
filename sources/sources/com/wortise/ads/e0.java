package com.wortise.ads;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.location.Location;
import com.wortise.ads.device.ScreenOrientation;
import com.wortise.ads.geofencing.GeofenceBroadcastReceiver;
import com.wortise.ads.geofencing.models.GeofencePoint;
import com.wortise.ads.google.models.GoogleParams;
import com.wortise.ads.push.models.Notification;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0003J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\rJ\u001b\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0007J#\u0010\u000b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H¤@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000eJ\u0010\u0010\u000b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH$R\u0014\u0010\t\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/wortise/ads/e0;", "Landroid/content/ContextWrapper;", "Lcom/wortise/ads/AdResponse;", "adResponse", "", "Lcom/wortise/ads/geofencing/models/GeofencePoint;", "b", "(Lcom/wortise/ads/AdResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "intent", "Landroid/app/PendingIntent;", "a", "point", "", "(Landroid/app/PendingIntent;Lcom/wortise/ads/geofencing/models/GeofencePoint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()Landroid/content/Intent;", "", "c", "()Z", "isAvailable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseGeofence.kt */
public abstract class e0 extends ContextWrapper {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/e0$a;", "", "", "MAX_GEO_VALUES", "I", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: BaseGeofence.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.geofencing.impl.BaseGeofence", f = "BaseGeofence.kt", i = {0, 0, 1, 1}, l = {34, 46}, m = "execute", n = {"this", "adResponse", "this", "adResponse"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* compiled from: BaseGeofence.kt */
    static final class b extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ e0 e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e0 e0Var, Continuation<? super b> continuation) {
            super(continuation);
            this.e = e0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.a((AdResponse) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.geofencing.impl.BaseGeofence", f = "BaseGeofence.kt", i = {0}, l = {62}, m = "getLocations", n = {"list"}, s = {"L$0"})
    /* compiled from: BaseGeofence.kt */
    static final class c extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ e0 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e0 e0Var, Continuation<? super c> continuation) {
            super(continuation);
            this.c = e0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.b((AdResponse) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1}, xi = 176)
    /* compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        final /* synthetic */ Location a;

        public d(Location location) {
            this.a = location;
        }

        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Float.valueOf(((GeofencePoint) t).a(this.a)), Float.valueOf(((GeofencePoint) t2).a(this.a)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Intent b() {
        return GeofenceBroadcastReceiver.Companion.a(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object a(PendingIntent pendingIntent, GeofencePoint geofencePoint, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract void a(PendingIntent pendingIntent);

    public boolean c() {
        return t4.a.c(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.wortise.ads.AdResponse r7, kotlin.coroutines.Continuation<? super java.util.List<com.wortise.ads.geofencing.models.GeofencePoint>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wortise.ads.e0.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.e0$c r0 = (com.wortise.ads.e0.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.e0$c r0 = new com.wortise.ads.e0$c
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 20
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r7 = r0.a
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.util.List r7 = r7.h()
            r2 = 0
            if (r7 != 0) goto L_0x0048
            r7 = r2
            goto L_0x004c
        L_0x0048:
            java.util.List r7 = kotlin.collections.CollectionsKt.toList(r7)
        L_0x004c:
            if (r7 != 0) goto L_0x004f
            return r2
        L_0x004f:
            r8.element = r7
            java.util.List r7 = (java.util.List) r7
            int r7 = r7.size()
            if (r7 > r4) goto L_0x005c
            T r7 = r8.element
            return r7
        L_0x005c:
            T r7 = r8.element
            java.util.List r7 = (java.util.List) r7
            int r7 = r7.size()
            if (r7 > r4) goto L_0x0069
            T r7 = r8.element
            return r7
        L_0x0069:
            com.wortise.ads.t4 r7 = com.wortise.ads.t4.a
            r0.a = r8
            r0.d = r3
            java.lang.Object r7 = r7.a((android.content.Context) r6, (kotlin.coroutines.Continuation<? super android.location.Location>) r0)
            if (r7 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0079:
            android.location.Location r8 = (android.location.Location) r8
            if (r8 != 0) goto L_0x007e
            goto L_0x008d
        L_0x007e:
            T r0 = r7.element
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            com.wortise.ads.e0$d r1 = new com.wortise.ads.e0$d
            r1.<init>(r8)
            java.util.List r8 = kotlin.collections.CollectionsKt.sortedWith(r0, r1)
            r7.element = r8
        L_0x008d:
            T r7 = r7.element
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.take(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.e0.b(com.wortise.ads.AdResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a() {
        PendingIntent a2 = a(b());
        if (a2 != null) {
            a(a2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.wortise.ads.AdResponse r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.wortise.ads.e0.b
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.wortise.ads.e0$b r0 = (com.wortise.ads.e0.b) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.e0$b r0 = new com.wortise.ads.e0$b
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x004c
            if (r2 == r3) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            java.lang.Object r8 = r0.c
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r2 = r0.b
            com.wortise.ads.AdResponse r2 = (com.wortise.ads.AdResponse) r2
            java.lang.Object r3 = r0.a
            com.wortise.ads.e0 r3 = (com.wortise.ads.e0) r3
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a3
        L_0x0038:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0040:
            java.lang.Object r8 = r0.b
            com.wortise.ads.AdResponse r8 = (com.wortise.ads.AdResponse) r8
            java.lang.Object r2 = r0.a
            com.wortise.ads.e0 r2 = (com.wortise.ads.e0) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005d
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.a = r7
            r0.b = r8
            r0.f = r3
            java.lang.Object r9 = r7.b(r8, r0)
            if (r9 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r2 = r7
        L_0x005d:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x0069
            boolean r5 = r9.isEmpty()
            if (r5 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r3 = 0
        L_0x0069:
            r5 = 0
            if (r3 == 0) goto L_0x0074
            java.lang.String r8 = "Cannot setup geofences: empty geolocation values"
            com.wortise.ads.WortiseLog.i$default((java.lang.String) r8, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0074:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "Adding "
            r3.<init>(r6)
            int r6 = r9.size()
            r3.append(r6)
            java.lang.String r6 = " geofences using "
            r3.append(r6)
            java.lang.Class r6 = r2.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r3, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            r2.a()
            java.util.Iterator r9 = r9.iterator()
            r3 = r2
            r2 = r8
            r8 = r9
        L_0x00a3:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00c5
            java.lang.Object r9 = r8.next()
            com.wortise.ads.geofencing.models.GeofencePoint r9 = (com.wortise.ads.geofencing.models.GeofencePoint) r9
            android.app.PendingIntent r5 = r3.a((com.wortise.ads.AdResponse) r2, (com.wortise.ads.geofencing.models.GeofencePoint) r9)
            if (r5 != 0) goto L_0x00b6
            goto L_0x00a3
        L_0x00b6:
            r0.a = r3
            r0.b = r2
            r0.c = r8
            r0.f = r4
            java.lang.Object r9 = r3.a((android.app.PendingIntent) r5, (com.wortise.ads.geofencing.models.GeofencePoint) r9, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r9 != r1) goto L_0x00a3
            return r1
        L_0x00c5:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.e0.a(com.wortise.ads.AdResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PendingIntent a(Intent intent) {
        try {
            return PendingIntent.getBroadcast(this, 0, intent, 167772160);
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return null;
        }
    }

    private final PendingIntent a(AdResponse adResponse, GeofencePoint geofencePoint) {
        try {
            adResponse = a(adResponse);
        } catch (Throwable unused) {
        }
        return a(GeofenceBroadcastReceiver.Companion.a(this, adResponse, geofencePoint));
    }

    private final AdResponse a(AdResponse adResponse) {
        AdResponse a2 = AdResponse.a(adResponse, (List) null, (String) null, (Long) null, (List) null, (String) null, (String) null, (AdFormat) null, (List) null, (GoogleParams) null, 0, (List) null, (String) null, (Notification) null, (ScreenOrientation) null, (AdType) null, (String) null, 0, 131071, (Object) null);
        List<GeofencePoint> h = a2.h();
        if (h != null) {
            h.clear();
        }
        return a2;
    }
}
