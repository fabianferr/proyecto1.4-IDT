package com.teragence.client.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.teragence.client.SdkControls;
import com.teragence.client.i;

public class PresenceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (!context.getSharedPreferences("MySP", 0).getBoolean("manuallyStopped", false)) {
                SdkControls.startBackgroundWork(context);
            } else {
                i.a("PresenceReceiver", "SDK manually stopped - do not schedule tests.");
            }
        } catch (Exception e) {
            i.b("PresenceReceiver", e.getMessage());
        }
    }
}
