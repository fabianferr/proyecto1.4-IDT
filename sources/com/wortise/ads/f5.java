package com.wortise.ads;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a&\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Landroid/app/NotificationManager;", "", "id", "name", "", "importance", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: NotificationManager.kt */
public final class f5 {
    public static /* synthetic */ void a(NotificationManager notificationManager, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        a(notificationManager, str, str2, i);
    }

    public static final void a(NotificationManager notificationManager, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(notificationManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
        }
    }
}
