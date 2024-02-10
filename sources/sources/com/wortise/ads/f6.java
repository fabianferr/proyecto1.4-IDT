package com.wortise.ads;

import android.content.Context;
import androidx.room.Room;
import com.wortise.ads.database.SdkDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/wortise/ads/f6;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/database/SdkDatabase;", "a", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: SdkDatabaseFactory.kt */
public final class f6 {
    public static final f6 a = new f6();
    private static SdkDatabase b;

    private f6() {
    }

    private final SdkDatabase a(Context context) {
        SdkDatabase build = Room.databaseBuilder(context, SdkDatabase.class, "com.wortise.ads").fallbackToDestructiveMigrationFrom(3).fallbackToDestructiveMigrationOnDowngrade().build();
        Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(context,…ngrade()\n        .build()");
        return build;
    }

    public final SdkDatabase b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SdkDatabase sdkDatabase = b;
        if (sdkDatabase != null) {
            return sdkDatabase;
        }
        SdkDatabase a2 = a(context);
        b = a2;
        return a2;
    }
}
