package com.startapp;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.HashSet;

/* compiled from: Sta */
public class g1 extends BroadcastReceiver {
    public final /* synthetic */ h1 a;

    public g1(h1 h1Var) {
        this.a = h1Var;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            e1 e1Var = this.a.c;
            if (e1Var.b == null) {
                e1Var.b = new HashSet();
            }
            e1Var.b.add(bluetoothDevice);
        } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
            this.a.c();
            h1 h1Var = this.a;
            h1Var.b.a(h1Var.b());
        }
    }
}
