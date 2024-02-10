package com.wortise.ads;

import android.app.PendingIntent;
import android.content.Context;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wortise.ads.geofencing.models.GeofencePoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/a3;", "Lcom/wortise/ads/e0;", "Landroid/app/PendingIntent;", "intent", "Lcom/wortise/ads/geofencing/models/GeofencePoint;", "point", "", "a", "(Landroid/app/PendingIntent;Lcom/wortise/ads/geofencing/models/GeofencePoint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/location/LocationManager;", "locationManager$delegate", "Lkotlin/Lazy;", "d", "()Landroid/location/LocationManager;", "locationManager", "", "c", "()Z", "isAvailable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceLocation.kt */
public final class a3 extends e0 {
    private final Lazy a;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/location/LocationManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GeofenceLocation.kt */
    static final class a extends Lambda implements Function0<LocationManager> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.a = context;
        }

        /* renamed from: a */
        public final LocationManager invoke() {
            Object systemService = this.a.getSystemService(FirebaseAnalytics.Param.LOCATION);
            if (!(systemService instanceof LocationManager)) {
                systemService = null;
            }
            return (LocationManager) systemService;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a3(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt.lazy(new a(context));
    }

    private final LocationManager d() {
        return (LocationManager) this.a.getValue();
    }

    /* access modifiers changed from: protected */
    public Object a(PendingIntent pendingIntent, GeofencePoint geofencePoint, Continuation<? super Unit> continuation) {
        Unit unit;
        LocationManager d = d();
        if (d == null) {
            unit = null;
        } else {
            double c = geofencePoint.c();
            double d2 = geofencePoint.d();
            float e = geofencePoint.e();
            Long a2 = geofencePoint.a();
            d.addProximityAlert(c, d2, e, a2 == null ? y1.a.a() : a2.longValue(), pendingIntent);
            unit = Unit.INSTANCE;
        }
        if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return unit;
        }
        return Unit.INSTANCE;
    }

    public boolean c() {
        return super.c() && d() != null;
    }

    /* access modifiers changed from: protected */
    public void a(PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "intent");
        LocationManager d = d();
        if (d != null) {
            d.removeProximityAlert(pendingIntent);
        }
    }
}
