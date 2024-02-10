package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/l3;", "", "Landroid/content/Context;", "context", "", "a", "Lcom/google/android/gms/common/GoogleApiAvailability;", "()Lcom/google/android/gms/common/GoogleApiAvailability;", "apiAvailability", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleApi.kt */
public final class l3 {
    public static final l3 a = new l3();

    private l3() {
    }

    private final GoogleApiAvailability a() {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a().isGooglePlayServicesAvailable(context) == 0;
    }
}
