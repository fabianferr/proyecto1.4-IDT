package com.umlaut.crowd.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umlaut.crowd.InsightCore;

public class InsightReceiver extends BroadcastReceiver {
    private static final String a = "InsightReceiver";
    private static final boolean b = false;

    public void onReceive(Context context, Intent intent) {
        if (InsightCore.isInitialized() && !getAbortBroadcast()) {
            InsightCore.startServices();
        }
    }
}
