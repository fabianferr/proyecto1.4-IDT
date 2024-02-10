package com.m2catalyst.m2sdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionsUtils.kt */
public final class a {
    public static Object a(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            return function0.invoke();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean a(Integer num, Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "values");
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        int length = numArr.length;
        for (int i = 0; i < length; i++) {
            if (numArr[i].intValue() == intValue) {
                return true;
            }
        }
        return false;
    }

    public static final void a(Context context, Class<?> cls, String str, long j, long j2, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        companion.v("ActionUtils", "launchAlarm: " + cls + ", " + str + ", " + j + ", " + j2 + ", " + i + ", " + i2 + ", " + z, new String[0]);
        Intent intent = new Intent(context, cls);
        intent.setAction(str);
        intent.putExtra("REPEATING_ALARM_INTERVAL", j2);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 33554432);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 570425344);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            if (z && service != null) {
                alarmManager.cancel(service);
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 31) {
                alarmManager.setAndAllowWhileIdle(i, j, broadcast);
            } else if (i3 >= 23) {
                alarmManager.setExactAndAllowWhileIdle(i, j, broadcast);
            } else if (i3 >= 21) {
                alarmManager.setExact(i, j, broadcast);
            } else {
                alarmManager.set(i, j, broadcast);
            }
        }
    }

    public static final PendingIntent a(Context context, int i) {
        Intrinsics.checkNotNullParameter(LocationSDKReceiver.class, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(LocationSDKReceiver.LOCATION_COLLECTION_UPDATE, "broadcastAction");
        Intent intent = new Intent(context, LocationSDKReceiver.class);
        intent.setAction(LocationSDKReceiver.LOCATION_COLLECTION_UPDATE);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i);
        Intrinsics.checkNotNullExpressionValue(broadcast, "with(Intent(context, thi…xt, 0, this, flags)\n    }");
        return broadcast;
    }
}
