package com.wortise.ads.geofencing;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.wortise.ads.AdError;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.push.PushAd;
import com.wortise.ads.work.SimpleListenableWorker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/wortise/ads/geofencing/GeosmartWorker;", "Lcom/wortise/ads/work/SimpleListenableWorker;", "", "b", "", "onStopped", "Lcom/wortise/ads/push/PushAd;", "Lcom/wortise/ads/push/PushAd;", "pushAd", "com/wortise/ads/geofencing/GeosmartWorker$b", "c", "Lcom/wortise/ads/geofencing/GeosmartWorker$b;", "pushListener", "", "()Ljava/lang/String;", "adUnitId", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeosmartWorker.kt */
public final class GeosmartWorker extends SimpleListenableWorker {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private PushAd b;
    private final b c = new b(this);

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/geofencing/GeosmartWorker$a;", "", "", "EXTRA_AD_UNIT_ID", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GeosmartWorker.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/wortise/ads/geofencing/GeosmartWorker$b", "Lcom/wortise/ads/push/PushAd$Listener;", "Lcom/wortise/ads/push/PushAd;", "ad", "Lcom/wortise/ads/AdError;", "error", "", "onPushFailed", "onPushLoaded", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GeosmartWorker.kt */
    public static final class b implements PushAd.Listener {
        final /* synthetic */ GeosmartWorker a;

        b(GeosmartWorker geosmartWorker) {
            this.a = geosmartWorker;
        }

        public void onPushFailed(PushAd pushAd, AdError adError) {
            Intrinsics.checkNotNullParameter(pushAd, "ad");
            Intrinsics.checkNotNullParameter(adError, "error");
            GeosmartWorker geosmartWorker = this.a;
            ListenableWorker.Result failure = adError == AdError.SERVER_ERROR ? ListenableWorker.Result.failure() : ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(failure, "if (error === AdError.SE…e() else Result.success()");
            geosmartWorker.a(failure);
        }

        public void onPushLoaded(PushAd pushAd) {
            Intrinsics.checkNotNullParameter(pushAd, "ad");
            GeosmartWorker geosmartWorker = this.a;
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            geosmartWorker.a(success);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GeosmartWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    private final String c() {
        String string = getInputData().getString("adUnitId");
        if (string != null) {
            return string;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        try {
            WortiseLog.i$default(Intrinsics.stringPlus("Started geosmart job for ad unit ", c()), (Throwable) null, 2, (Object) null);
            if (this.b != null) {
                return true;
            }
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            PushAd pushAd = new PushAd(applicationContext, c());
            pushAd.setListener(this.c);
            PushAd.loadAd$default(pushAd, (RequestParameters) null, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
            this.b = pushAd;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void onStopped() {
        super.onStopped();
        PushAd pushAd = this.b;
        if (pushAd != null) {
            pushAd.destroy();
        }
        this.b = null;
    }
}
