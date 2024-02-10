package com.startapp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Sta */
public class v implements ServiceConnection {
    public final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue<>(1);
    public boolean b = false;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.a.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
