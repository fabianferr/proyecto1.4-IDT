package com.wortise.ads;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.wortise.ads.geofencing.models.GeofencePoint;
import com.wortise.ads.geofencing.models.GeofenceTransition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/b3;", "Lcom/wortise/ads/e0;", "Lcom/wortise/ads/geofencing/models/GeofencePoint;", "point", "Lcom/google/android/gms/location/Geofence;", "kotlin.jvm.PlatformType", "a", "Landroid/app/PendingIntent;", "intent", "", "(Landroid/app/PendingIntent;Lcom/wortise/ads/geofencing/models/GeofencePoint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/location/GeofencingClient;", "geofencingClient$delegate", "Lkotlin/Lazy;", "d", "()Lcom/google/android/gms/location/GeofencingClient;", "geofencingClient", "", "c", "()Z", "isAvailable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofencePlayServices.kt */
public final class b3 extends e0 {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private final Lazy a = LazyKt.lazy(new b(this));

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/b3$a;", "", "", "DEFAULT_TRANSITION", "I", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GeofencePlayServices.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lcom/google/android/gms/location/GeofencingClient;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GeofencePlayServices.kt */
    static final class b extends Lambda implements Function0<GeofencingClient> {
        final /* synthetic */ b3 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(b3 b3Var) {
            super(0);
            this.a = b3Var;
        }

        /* renamed from: a */
        public final GeofencingClient invoke() {
            try {
                return LocationServices.getGeofencingClient((Context) this.a);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b3(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final GeofencingClient d() {
        return (GeofencingClient) this.a.getValue();
    }

    /* access modifiers changed from: protected */
    public Object a(PendingIntent pendingIntent, GeofencePoint geofencePoint, Continuation<? super Unit> continuation) {
        GeofencingRequest build = new GeofencingRequest.Builder().addGeofence(a(geofencePoint)).setInitialTrigger(1).build();
        GeofencingClient d = d();
        Task<Void> addGeofences = d == null ? null : d.addGeofences(build, pendingIntent);
        if (addGeofences == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return addGeofences;
        }
        return Unit.INSTANCE;
    }

    public boolean c() {
        return super.c() && l3.a.a(this);
    }

    /* access modifiers changed from: protected */
    public void a(PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "intent");
        GeofencingClient d = d();
        if (d != null) {
            d.removeGeofences(pendingIntent);
        }
    }

    private final Geofence a(GeofencePoint geofencePoint) {
        Geofence.Builder circularRegion = new Geofence.Builder().setCircularRegion(geofencePoint.c(), geofencePoint.d(), geofencePoint.e());
        Long a2 = geofencePoint.a();
        Geofence.Builder requestId = circularRegion.setExpirationDuration(a2 == null ? y1.a.a() : a2.longValue()).setRequestId(geofencePoint.b());
        GeofenceTransition f = geofencePoint.f();
        return requestId.setTransitionTypes(f == null ? 3 : f.getValue()).build();
    }
}
