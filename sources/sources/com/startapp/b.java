package com.startapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.startapp.t1;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Sta */
public class b extends t1.a {
    public final Map<Network, Integer> c = new HashMap();

    /* compiled from: Sta */
    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            int a2 = t1.a(networkCapabilities);
            synchronized (b.this.c) {
                b.this.c.put(network, Integer.valueOf(a2));
            }
        }

        public void onLost(Network network) {
            synchronized (b.this.c) {
                b.this.c.remove(network);
            }
        }
    }

    public b(Context context, ConnectivityManager connectivityManager) {
        super(context, connectivityManager);
    }

    public int a() {
        int i;
        synchronized (this.c) {
            i = 0;
            for (Integer next : this.c.values()) {
                if (next != null) {
                    i |= next.intValue();
                }
            }
        }
        return i;
    }

    public void b() {
        if (a0.a(this.a, "android.permission.ACCESS_NETWORK_STATE")) {
            this.b.registerDefaultNetworkCallback(new a());
        }
    }
}
