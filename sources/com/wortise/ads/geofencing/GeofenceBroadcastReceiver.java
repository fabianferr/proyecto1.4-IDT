package com.wortise.ads.geofencing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.GeofencingEvent;
import com.google.gson.reflect.TypeToken;
import com.wortise.ads.AdResponse;
import com.wortise.ads.geofencing.models.GeofenceEvent;
import com.wortise.ads.geofencing.models.GeofencePoint;
import com.wortise.ads.k4;
import com.wortise.ads.u4;
import com.wortise.ads.y2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/wortise/ads/geofencing/GeofenceBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "a", "", "onReceive", "<init>", "()V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceBroadcastReceiver.kt */
public final class GeofenceBroadcastReceiver extends BroadcastReceiver {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/geofencing/GeofenceBroadcastReceiver$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "a", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/geofencing/models/GeofencePoint;", "point", "", "EXTRA_AD_RESPONSE", "Ljava/lang/String;", "EXTRA_POINT", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GeofenceBroadcastReceiver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, GeofenceBroadcastReceiver.class);
        }

        public final Intent a(Context context, AdResponse adResponse, GeofencePoint geofencePoint) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intrinsics.checkNotNullParameter(geofencePoint, "point");
            return k4.a(k4.a(a(context), "adResponse", (Object) adResponse), "point", (Object) geofencePoint);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: JsonParser.kt */
    public static final class b extends TypeToken<GeofencePoint> {
    }

    private final GeofenceEvent a(Context context, Intent intent) {
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
        if (fromIntent == null) {
            return null;
        }
        Location triggeringLocation = fromIntent.getTriggeringLocation();
        if (triggeringLocation != null) {
            u4.a.a(context, triggeringLocation);
        }
        if (!fromIntent.hasError()) {
            return y2.a.a(context, fromIntent);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Geofence job error: ", Integer.valueOf(fromIntent.getErrorCode())).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[Catch:{ all -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 2
            java.lang.String r1 = "Geofence broadcast receiver called"
            r2 = 0
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r1, (java.lang.Throwable) r2, (int) r0, (java.lang.Object) r2)
            com.wortise.ads.geofencing.models.GeofenceEvent r0 = r6.a(r7, r8)     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "adResponse"
            java.lang.String r1 = r8.getStringExtra(r1)     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x001e
            return
        L_0x001e:
            java.lang.String r3 = "point"
            java.lang.String r8 = r8.getStringExtra(r3)     // Catch:{ all -> 0x003c }
            if (r8 != 0) goto L_0x0027
            goto L_0x003c
        L_0x0027:
            com.wortise.ads.q4 r3 = com.wortise.ads.q4.a     // Catch:{ all -> 0x003c }
            com.wortise.ads.geofencing.GeofenceBroadcastReceiver$b r4 = new com.wortise.ads.geofencing.GeofenceBroadcastReceiver$b     // Catch:{ all -> 0x003c }
            r4.<init>()     // Catch:{ all -> 0x003c }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "object: TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x003c }
            java.lang.Object r8 = r3.a((java.lang.String) r8, (java.lang.reflect.Type) r4)     // Catch:{ all -> 0x003c }
            goto L_0x003d
        L_0x003c:
            r8 = r2
        L_0x003d:
            com.wortise.ads.geofencing.models.GeofencePoint r8 = (com.wortise.ads.geofencing.models.GeofencePoint) r8     // Catch:{ all -> 0x005d }
            if (r8 != 0) goto L_0x0043
            r3 = r2
            goto L_0x0047
        L_0x0043:
            com.wortise.ads.geofencing.models.GeofenceTransition r3 = r8.f()     // Catch:{ all -> 0x005d }
        L_0x0047:
            if (r3 == 0) goto L_0x0057
            com.wortise.ads.geofencing.models.GeofenceTransition r8 = r8.f()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0050
            goto L_0x0054
        L_0x0050:
            com.wortise.ads.geofencing.models.GeofenceTransition r2 = r0.a()     // Catch:{ all -> 0x005d }
        L_0x0054:
            if (r8 == r2) goto L_0x0057
            return
        L_0x0057:
            com.wortise.ads.geofencing.GeofenceEventWorker$a r8 = com.wortise.ads.geofencing.GeofenceEventWorker.Companion     // Catch:{ all -> 0x005d }
            r8.a(r7, r1, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0063
        L_0x005d:
            r7 = move-exception
            java.lang.String r8 = "Geofence event error"
            com.wortise.ads.WortiseLog.e((java.lang.String) r8, (java.lang.Throwable) r7)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.geofencing.GeofenceBroadcastReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
