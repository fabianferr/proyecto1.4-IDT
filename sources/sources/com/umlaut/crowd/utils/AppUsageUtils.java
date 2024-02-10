package com.umlaut.crowd.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import com.umlaut.crowd.internal.i;

public class AppUsageUtils {

    class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppUsageUtils.startAppUsagePermissionIntent(this.a);
        }
    }

    class b implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean a;
        final /* synthetic */ Activity b;

        b(boolean z, Activity activity) {
            this.a = z;
            this.b = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.a) {
                this.b.finish();
            }
        }
    }

    public static boolean canHandleAppUsagePermissionIntent(Context context) {
        if (Build.VERSION.SDK_INT < 21 || new Intent("android.settings.USAGE_ACCESS_SETTINGS").resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        return true;
    }

    public static i getAppCategory(int i) {
        i iVar = i.Unknown;
        switch (i) {
            case -1:
                return i.Undefined;
            case 0:
                return i.Game;
            case 1:
                return i.Audio;
            case 2:
                return i.Video;
            case 3:
                return i.Image;
            case 4:
                return i.Social;
            case 5:
                return i.News;
            case 6:
                return i.Maps;
            case 7:
                return i.Productivity;
            default:
                return iVar;
        }
    }

    public static boolean isAppUsageStatsPermissionGranted(Context context) {
        if (Build.VERSION.SDK_INT < 21 || ((AppOpsManager) context.getApplicationContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getApplicationContext().getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static boolean showAppUsagePermissionDialog(Activity activity, int i, int i2, int i3, int i4, boolean z) {
        if (!canHandleAppUsagePermissionIntent(activity)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(i);
        builder.setCancelable(false);
        builder.setMessage(i2);
        builder.setPositiveButton(i3, new a(activity));
        builder.setNegativeButton(i4, new b(z, activity));
        builder.create().show();
        return true;
    }

    public static boolean startAppUsagePermissionIntent(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
                intent.setFlags(411074560);
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        return false;
    }
}
