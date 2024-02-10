package com.startapp;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import org.json.JSONObject;

/* compiled from: Sta */
public class h1 {
    public Context a;
    public g6 b;
    public e1 c = new e1();
    public BluetoothAdapter d = a();
    public BroadcastReceiver e;

    public h1(Context context, g6 g6Var) {
        this.a = context;
        this.b = g6Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r6) {
        /*
            r5 = this;
            android.bluetooth.BluetoothAdapter r0 = r5.d
            if (r0 == 0) goto L_0x008a
            boolean r0 = r0.isEnabled()
            if (r0 != 0) goto L_0x000c
            goto L_0x008a
        L_0x000c:
            com.startapp.e1 r0 = r5.c
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x003e }
            r2 = 31
            if (r1 >= r2) goto L_0x001e
            android.content.Context r3 = r5.a     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "android.permission.BLUETOOTH"
            boolean r3 = com.startapp.a0.a((android.content.Context) r3, (java.lang.String) r4)     // Catch:{ all -> 0x003e }
            if (r3 != 0) goto L_0x002a
        L_0x001e:
            if (r1 < r2) goto L_0x002c
            android.content.Context r1 = r5.a     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "android.permission.BLUETOOTH_CONNECT"
            boolean r1 = com.startapp.a0.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x002c
        L_0x002a:
            r1 = 1
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 == 0) goto L_0x0042
            android.bluetooth.BluetoothAdapter r1 = r5.d     // Catch:{ all -> 0x003e }
            boolean r1 = r1.isEnabled()     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x0042
            android.bluetooth.BluetoothAdapter r1 = r5.d     // Catch:{ all -> 0x003e }
            java.util.Set r1 = r1.getBondedDevices()     // Catch:{ all -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r1 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r1)
        L_0x0042:
            java.util.Set r1 = java.util.Collections.emptySet()
        L_0x0046:
            r0.a = r1
            if (r6 == 0) goto L_0x0080
            android.content.Context r6 = r5.a
            java.lang.String r0 = "android.permission.BLUETOOTH_ADMIN"
            boolean r6 = com.startapp.a0.a((android.content.Context) r6, (java.lang.String) r0)
            if (r6 == 0) goto L_0x0080
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r0 = "android.bluetooth.device.action.FOUND"
            r6.<init>(r0)
            com.startapp.g1 r0 = new com.startapp.g1
            r0.<init>(r5)
            r5.e = r0
            android.content.Context r1 = r5.a     // Catch:{ Exception -> 0x006d }
            r1.registerReceiver(r0, r6)     // Catch:{ Exception -> 0x006d }
            android.bluetooth.BluetoothAdapter r6 = r5.d     // Catch:{ Exception -> 0x006d }
            r6.startDiscovery()     // Catch:{ Exception -> 0x006d }
            goto L_0x0089
        L_0x006d:
            r6 = move-exception
            android.bluetooth.BluetoothAdapter r0 = r5.d
            r0.cancelDiscovery()
            com.startapp.g6 r0 = r5.b
            org.json.JSONObject r1 = r5.b()
            r0.a(r1)
            com.startapp.i3.a((java.lang.Throwable) r6)
            goto L_0x0089
        L_0x0080:
            com.startapp.g6 r6 = r5.b
            org.json.JSONObject r0 = r5.b()
            r6.a(r0)
        L_0x0089:
            return
        L_0x008a:
            com.startapp.g6 r6 = r5.b
            r0 = 0
            r6.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.h1.a(boolean):void");
    }

    public JSONObject b() {
        try {
            return this.c.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        BluetoothAdapter bluetoothAdapter;
        if (a0.a(this.a, "android.permission.BLUETOOTH_ADMIN") && this.e != null && (bluetoothAdapter = this.d) != null) {
            bluetoothAdapter.cancelDiscovery();
            try {
                this.a.unregisterReceiver(this.e);
            } catch (Throwable th) {
                i3.a(th);
            }
            this.e = null;
        }
    }

    public final BluetoothAdapter a() {
        if (a0.a(this.a, "android.permission.BLUETOOTH")) {
            return BluetoothAdapter.getDefaultAdapter();
        }
        return null;
    }
}
