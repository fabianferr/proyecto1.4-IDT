package com.wortise.ads;

import android.app.NotificationChannel;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/wortise/ads/g5;", "", "Landroid/content/Context;", "context", "", "channelId", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: NotificationUtils.kt */
public final class g5 {
    public static final g5 a = new g5();

    private g5() {
    }

    public final boolean a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "channelId");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        boolean z = false;
        if (!from.areNotificationsEnabled()) {
            return false;
        }
        NotificationChannel notificationChannel = from.getNotificationChannel(str);
        if (notificationChannel != null && notificationChannel.getImportance() == 0) {
            z = true;
        }
        return !z;
    }
}
