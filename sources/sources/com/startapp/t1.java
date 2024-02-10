package com.startapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.RemoteException;
import com.startapp.sdk.adsbase.remoteconfig.ConnectivityHelperMetadata;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Sta */
public class t1 {
    public static final int[] f;
    public final Context a;
    public final i2<ConnectivityHelperMetadata> b;
    public final List<i2<Void>> c = new LinkedList();
    public final AtomicBoolean d = new AtomicBoolean(false);
    public a e;

    /* compiled from: Sta */
    public static abstract class a {
        public final Context a;
        public final ConnectivityManager b;

        public a(Context context, ConnectivityManager connectivityManager) {
            this.a = context;
            this.b = connectivityManager;
        }

        public abstract int a();

        public void b() {
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);
        }
        if (i >= 26) {
            arrayList.add(5);
        }
        if (i >= 27) {
            arrayList.add(6);
        }
        if (i >= 31) {
            arrayList.add(8);
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        f = iArr;
    }

    public t1(Context context, i2<ConnectivityHelperMetadata> i2Var) {
        this.a = context;
        this.b = i2Var;
    }

    public boolean a() {
        if (a0.a(this.a, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        return false;
                    }
                    return true;
                }
            } catch (Throwable th) {
                if (!k9.a(th, (Class<? extends Throwable>) RemoteException.class)) {
                    i3.a(th);
                }
            }
        }
        return true;
    }

    public static int a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return 0;
        }
        int i = 0;
        for (int i2 : f) {
            try {
                if (networkCapabilities.hasTransport(i2)) {
                    i |= 1 << i2;
                }
            } catch (Throwable unused) {
            }
        }
        return i;
    }
}
