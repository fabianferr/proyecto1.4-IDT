package com.cellrebel.sdk.youtube.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkReceiver extends BroadcastReceiver {
    private NetworkListener a;

    public interface NetworkListener {
        void a();

        void b();
    }

    public NetworkReceiver(NetworkListener networkListener) {
        this.a = networkListener;
    }

    public void onReceive(Context context, Intent intent) {
        if (Utils.a(context)) {
            this.a.a();
        } else {
            this.a.b();
        }
    }
}
