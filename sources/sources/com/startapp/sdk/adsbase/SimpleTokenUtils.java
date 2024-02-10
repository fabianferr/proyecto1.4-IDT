package com.startapp.sdk.adsbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.startapp.a0;
import com.startapp.h0;
import com.startapp.i3;
import com.startapp.k9;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.common.utils.Pair;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.w7;
import com.startapp.x7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Sta */
public class SimpleTokenUtils {
    public static List<PackageInfo> a = null;
    public static List<PackageInfo> b = null;
    public static long c = 0;
    public static volatile Pair<TokenType, String> d = null;
    public static volatile Pair<TokenType, String> e = null;
    public static boolean f = true;
    public static boolean g = false;
    public static TokenType h = TokenType.UNDEFINED;

    /* compiled from: Sta */
    public enum TokenType {
        T1(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY),
        T2("token2"),
        UNDEFINED("");
        
        private final String text;

        /* access modifiers changed from: public */
        TokenType(String str) {
            this.text = str;
        }

        public static TokenType a(String str) {
            TokenType tokenType = T1;
            if (tokenType.text.equals(str)) {
                return tokenType;
            }
            TokenType tokenType2 = T2;
            if (tokenType2.text.equals(str)) {
                return tokenType2;
            }
            return UNDEFINED;
        }

        public String toString() {
            return this.text;
        }
    }

    /* compiled from: Sta */
    public class a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            SimpleTokenUtils.d = null;
            SimpleTokenUtils.e = null;
            SimpleTokenUtils.f(context);
        }
    }

    /* compiled from: Sta */
    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        public void run() {
            SimpleTokenUtils.e(this.a);
        }
    }

    public static Pair<String, String> a() {
        if (d != null) {
            return new Pair<>(((TokenType) d.first).toString(), d.second);
        }
        return new Pair<>(TokenType.T1.toString(), "");
    }

    public static Pair<String, String> b() {
        if (e != null) {
            return new Pair<>(((TokenType) e.first).toString(), e.second);
        }
        return new Pair<>(TokenType.T2.toString(), "");
    }

    public static long c() {
        return c;
    }

    public static void d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Set<String> v = MetaData.k.v();
        Set<String> E = MetaData.k.E();
        a = new CopyOnWriteArrayList();
        b = new CopyOnWriteArrayList();
        try {
            List<PackageInfo> a2 = a0.a(packageManager);
            c = System.currentTimeMillis();
            PackageInfo packageInfo = null;
            for (PackageInfo next : a2) {
                if (!a0.a(next)) {
                    long j = next.firstInstallTime;
                    if (j < c && j >= 1291593600000L) {
                        c = j;
                    }
                    a.add(next);
                    try {
                        String b2 = k9.b(context);
                        if (v != null && v.contains(b2)) {
                            b.add(next);
                        }
                    } catch (Throwable th) {
                        i3.a(th);
                    }
                } else if (E.contains(next.packageName)) {
                    a.add(next);
                } else if (next.packageName.equals(Constants.a)) {
                    packageInfo = next;
                }
            }
            a = a(a);
            b = a(b);
            if (packageInfo != null) {
                a.add(0, packageInfo);
            }
        } catch (Throwable th2) {
            if (!k9.a(th2, (Class<? extends Throwable>) RemoteException.class)) {
                i3.a(th2);
            }
        }
    }

    public static void e(Context context) {
        boolean a2 = MetaData.k.K().a(context);
        synchronized (SimpleTokenUtils.class) {
            if ((d == null || e == null) && a2) {
                try {
                    d(context);
                    d = new Pair<>(TokenType.T1, w7.a(b(a)));
                    e = new Pair<>(TokenType.T2, w7.a(b(b)));
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
        }
        return;
    }

    public static void f(Context context) {
        Context a2 = h0.a(context);
        if (a2 != null) {
            context = a2;
        }
        try {
            if ((d == null || e == null) && MetaData.k.K().a(context)) {
                ComponentLocator.a(context).l().execute(new c(context));
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public static void c(Context context) {
        Context a2 = h0.a(context);
        if (a2 != null) {
            context = a2;
        }
        f(context);
        f = true;
        g = false;
        h = TokenType.UNDEFINED;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        context.registerReceiver(new a(), intentFilter);
        MetaData.k.a((com.startapp.sdk.adsbase.remoteconfig.c) new b(context));
    }

    /* compiled from: Sta */
    public class b implements com.startapp.sdk.adsbase.remoteconfig.c {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        public void a(MetaDataRequest.RequestReason requestReason, boolean z) {
            if (z) {
                SimpleTokenUtils.d = null;
                SimpleTokenUtils.e = null;
                SimpleTokenUtils.f(this.a);
            }
            MetaData.k.a((com.startapp.sdk.adsbase.remoteconfig.c) this);
        }

        public void a(MetaDataRequest.RequestReason requestReason) {
            MetaData.k.a((com.startapp.sdk.adsbase.remoteconfig.c) this);
        }
    }

    public static Pair<TokenType, String> a(Context context) {
        if (d == null) {
            e(context);
        }
        e.a a2 = ComponentLocator.a(context).e().edit();
        String str = (String) d.second;
        a2.a("shared_prefs_simple_token", str);
        a2.a.putString("shared_prefs_simple_token", str);
        a2.apply();
        f = false;
        h = TokenType.UNDEFINED;
        return new Pair<>(TokenType.T1, d.second);
    }

    public static Pair<TokenType, String> b(Context context) {
        if (e == null) {
            e(context);
        }
        e.a a2 = ComponentLocator.a(context).e().edit();
        String str = (String) e.second;
        a2.a("shared_prefs_simple_token2", str);
        a2.a.putString("shared_prefs_simple_token2", str);
        a2.apply();
        f = false;
        h = TokenType.UNDEFINED;
        return new Pair<>(TokenType.T2, e.second);
    }

    public static List<PackageInfo> a(List<PackageInfo> list) {
        if (list.size() <= 100) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new x7());
        return arrayList.subList(0, 100);
    }

    public static List<String> b(List<PackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : list) {
            arrayList.add(packageInfo.packageName);
        }
        return arrayList;
    }
}
