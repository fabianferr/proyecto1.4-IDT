package com.applovin.impl.sdk;

import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.utils.g;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.TimeUnit;

public class t {
    private final m a;
    private final LocationManager b;
    private double c;
    private double d;
    private long e;

    t(m mVar) {
        this.a = mVar;
        this.b = (LocationManager) mVar.L().getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    private Location a(String str, String str2) {
        u A;
        StringBuilder sb;
        String str3;
        if (!g.a(str2, this.a.L())) {
            return null;
        }
        try {
            return this.b.getLastKnownLocation(str);
        } catch (SecurityException e2) {
            th = e2;
            if (u.a()) {
                A = this.a.A();
                sb = new StringBuilder("Failed to retrieve location from ");
                sb.append(str);
                str3 = ": access denied.";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        } catch (IllegalArgumentException e3) {
            th = e3;
            if (u.a()) {
                A = this.a.A();
                sb = new StringBuilder("Failed to retrieve location from ");
                sb.append(str);
                str3 = ": device does not support this location provider.";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        } catch (NullPointerException e4) {
            th = e4;
            if (u.a()) {
                A = this.a.A();
                sb = new StringBuilder("Failed to retrieve location from ");
                sb.append(str);
                str3 = ": location provider is not available.";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        } catch (Throwable th) {
            th = th;
            if (u.a()) {
                A = this.a.A();
                sb = new StringBuilder("Failed to retrieve location from ");
                sb.append(str);
                str3 = ".";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        }
    }

    private boolean f() {
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.a.a(b.ea)).longValue());
        if (this.e != 0 && System.currentTimeMillis() - this.e < millis) {
            return false;
        }
        Location a2 = a("gps", "android.permission.ACCESS_FINE_LOCATION");
        if (a2 == null) {
            a2 = a("network", "android.permission.ACCESS_COARSE_LOCATION");
        }
        if (a2 == null) {
            return false;
        }
        this.c = a2.getLatitude();
        this.d = a2.getLongitude();
        this.e = System.currentTimeMillis();
        return true;
    }

    public boolean a() {
        return g.a("android.permission.ACCESS_COARSE_LOCATION", this.a.L());
    }

    public boolean b() {
        return g.h() ? this.b.isLocationEnabled() : !g.c() || Settings.Secure.getInt(this.a.L().getContentResolver(), "location_mode", 0) != 0;
    }

    public boolean c() {
        if (this.a.p().isLocationCollectionEnabled() && ((Boolean) this.a.a(b.dZ)).booleanValue() && a()) {
            return f() || this.e != 0;
        }
        return false;
    }

    public double d() {
        return this.c;
    }

    public double e() {
        return this.d;
    }
}
