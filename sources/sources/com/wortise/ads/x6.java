package com.wortise.ads;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/x6;", "Lcom/wortise/ads/i0;", "Landroid/location/Location;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/location/Criteria;", "b", "()Landroid/location/Criteria;", "criteria", "Landroid/location/LocationManager;", "locationManager$delegate", "Lkotlin/Lazy;", "c", "()Landroid/location/LocationManager;", "locationManager", "", "d", "()Ljava/lang/String;", "provider", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: VanillaLocation.kt */
public final class x6 extends i0 {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final Lazy b;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/location/LocationManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: VanillaLocation.kt */
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
    public x6(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt.lazy(new a(context));
    }

    private final Criteria b() {
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(2);
        return criteria;
    }

    private final LocationManager c() {
        return (LocationManager) this.b.getValue();
    }

    private final String d() {
        LocationManager c = c();
        if (c == null) {
            return null;
        }
        return c.getBestProvider(b(), true);
    }

    public Object a(Continuation<? super Location> continuation) {
        LocationManager c;
        String d = d();
        if (d == null || (c = c()) == null) {
            return null;
        }
        return c.getLastKnownLocation(d);
    }
}
