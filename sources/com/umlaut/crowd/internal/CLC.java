package com.umlaut.crowd.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.DateUtils;
import com.umlaut.crowd.utils.PermissionUtils;
import java.util.List;

public class CLC implements q3 {
    private static double s = 0.0d;
    private static double t = 0.0d;
    private static final String u = "CLC";
    private static final boolean v = false;
    private static final int w = 300000;
    private final Context a;
    private LocationManager b;
    /* access modifiers changed from: private */
    public y1 c;
    private long d;
    private q4 e;
    private Location f;
    private long g;
    private d h;
    private long i = 4000;
    /* access modifiers changed from: private */
    public boolean j;
    private long k;
    private FusedLocationProviderClient l;
    private c m;
    private boolean n = false;
    private boolean o = false;
    private e p;
    private Handler q;
    private final Runnable r = new a();

    public enum ProviderMode {
        Passive,
        Network,
        Gps,
        GpsAndNetwork,
        RailNet
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (CLC.this.j) {
                CLC.this.c.a((q3) CLC.this);
            }
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.CLC$ProviderMode[] r0 = com.umlaut.crowd.internal.CLC.ProviderMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.CLC$ProviderMode r1 = com.umlaut.crowd.internal.CLC.ProviderMode.Gps     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.CLC$ProviderMode r1 = com.umlaut.crowd.internal.CLC.ProviderMode.GpsAndNetwork     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.CLC$ProviderMode r1 = com.umlaut.crowd.internal.CLC.ProviderMode.Network     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.CLC$ProviderMode r1 = com.umlaut.crowd.internal.CLC.ProviderMode.Passive     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.CLC$ProviderMode r1 = com.umlaut.crowd.internal.CLC.ProviderMode.RailNet     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CLC.b.<clinit>():void");
        }
    }

    private class c extends LocationCallback {

        class a implements Runnable {
            final /* synthetic */ LocationResult a;

            a(LocationResult locationResult) {
                this.a = locationResult;
            }

            public void run() {
                CLC.this.a(this.a.getLastLocation());
            }
        }

        private c() {
        }

        public void onLocationResult(LocationResult locationResult) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(locationResult));
        }

        /* synthetic */ c(CLC clc, a aVar) {
            this();
        }
    }

    private class d implements LocationListener {

        class a implements Runnable {
            final /* synthetic */ Location a;

            a(Location location) {
                this.a = location;
            }

            public void run() {
                CLC.this.a(this.a);
            }
        }

        private d() {
        }

        public void onLocationChanged(Location location) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(location));
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        /* synthetic */ d(CLC clc, a aVar) {
            this();
        }
    }

    public interface e {
        void a(q4 q4Var);
    }

    public CLC(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[SYNTHETIC, Splitter:B:21:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r11 = this;
            boolean r0 = r11.o
            if (r0 != 0) goto L_0x0007
            r11.e()
        L_0x0007:
            long r0 = android.os.SystemClock.elapsedRealtime()
            r11.k = r0
            r0 = 0
            android.location.LocationManager r1 = r11.b     // Catch:{ Exception -> 0x0015 }
            java.util.List r1 = r1.getAllProviders()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0017
        L_0x0015:
            r1 = r0
        L_0x0017:
            boolean r2 = r11.n
            java.lang.String r3 = "getNewestCachedLocationFromDevice: "
            if (r2 == 0) goto L_0x0040
            com.google.android.gms.location.FusedLocationProviderClient r2 = r11.l     // Catch:{ all -> 0x002e }
            com.google.android.gms.tasks.Task r2 = r2.getLastLocation()     // Catch:{ all -> 0x002e }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x002e }
            r5 = 200(0xc8, double:9.9E-322)
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.await(r2, r5, r4)     // Catch:{ all -> 0x002e }
            android.location.Location r2 = (android.location.Location) r2     // Catch:{ all -> 0x002e }
            goto L_0x0041
        L_0x002e:
            r2 = move-exception
            java.lang.String r4 = u
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.d(r4, r2)
        L_0x0040:
            r2 = r0
        L_0x0041:
            if (r1 == 0) goto L_0x0085
            int r4 = r1.size()
            if (r4 <= 0) goto L_0x0085
            r4 = 0
        L_0x004a:
            int r5 = r1.size()
            if (r4 >= r5) goto L_0x0085
            android.location.LocationManager r5 = r11.b     // Catch:{ SecurityException -> 0x005d }
            java.lang.Object r6 = r1.get(r4)     // Catch:{ SecurityException -> 0x005d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ SecurityException -> 0x005d }
            android.location.Location r5 = r5.getLastKnownLocation(r6)     // Catch:{ SecurityException -> 0x005d }
            goto L_0x0070
        L_0x005d:
            r5 = move-exception
            java.lang.String r6 = u
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r3)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.util.Log.d(r6, r5)
            r5 = r0
        L_0x0070:
            if (r5 == 0) goto L_0x0082
            if (r2 != 0) goto L_0x0075
            goto L_0x0081
        L_0x0075:
            long r6 = r5.getTime()
            long r8 = r2.getTime()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0082
        L_0x0081:
            r2 = r5
        L_0x0082:
            int r4 = r4 + 1
            goto L_0x004a
        L_0x0085:
            if (r2 == 0) goto L_0x0094
            r11.f = r2
            r11.b((android.location.Location) r2)
            android.content.Context r0 = r11.a
            com.umlaut.crowd.internal.q4 r0 = a((android.location.Location) r2, (android.content.Context) r0)
            r11.e = r0
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CLC.c():void");
    }

    private void e() {
        if (this.b == null) {
            this.b = (LocationManager) this.a.getSystemService(FirebaseAnalytics.Param.LOCATION);
        }
        if (this.c == null) {
            this.c = new y1();
        }
        if (this.h == null) {
            this.h = new d(this, (a) null);
        }
        if (this.q == null) {
            this.q = new Handler(this.a.getMainLooper());
        }
        try {
            if (f.a(new String[]{"com.google.android.gms.common.GoogleApiAvailability", "com.google.android.gms.common.ConnectionResult", "com.google.android.gms.tasks.Tasks", "com.google.android.gms.location.FusedLocationProviderClient", "com.google.android.gms.location.LocationServices", "com.google.android.gms.location.LocationCallback", "com.google.android.gms.location.LocationResult", "com.google.android.gms.location.LocationRequest"}) && GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.a) == 0) {
                if (this.l == null) {
                    this.l = LocationServices.getFusedLocationProviderClient(this.a);
                }
                if (this.m == null) {
                    this.m = new c(this, (a) null);
                }
                this.n = true;
            }
        } catch (Exception unused) {
        }
        this.o = true;
    }

    public long d() {
        return this.i;
    }

    public synchronized q4 getLastLocationInfo() {
        q4 q4Var;
        q4 q4Var2 = this.e;
        if ((q4Var2 == null || q4Var2.LocationProvider == s4.Unknown || (SystemClock.elapsedRealtime() - this.k > 300000 && this.e.LocationAge > 300000)) && PermissionUtils.hasAnyLocationPermissionPermission(this.a)) {
            c();
        }
        if (this.e == null) {
            q4 q4Var3 = new q4();
            this.e = q4Var3;
            q4Var3.LocationProvider = s4.Unknown;
            q4Var3.LocationPermissionType = a(this.a);
        }
        q4 q4Var4 = this.e;
        if (q4Var4.LocationProvider != s4.Unknown) {
            q4Var4.LocationAge = SystemClock.elapsedRealtime() - this.g;
        }
        b4 a2 = g3.a(this.a).a(true);
        q4 q4Var5 = this.e;
        q4Var5.IpLocationLongitude = a2.b;
        q4Var5.IpLocationLatitude = a2.a;
        q4Var5.IpLocationAccuracy = a2.c;
        q4Var5.IpLocationAge = a2.a();
        q4Var = this.e;
        s = q4Var.LocationLatitude;
        t = q4Var.LocationLongitude;
        try {
        } catch (CloneNotSupportedException e2) {
            Log.e(u, "getLastLocationInfo", e2);
            return this.e;
        }
        return (q4) q4Var.clone();
    }

    public void startListening(ProviderMode providerMode) {
        List<String> list;
        boolean z;
        boolean z2;
        boolean z3;
        e();
        if (providerMode != null && this.b != null && PermissionUtils.hasAnyLocationPermissionPermission(this.a)) {
            this.j = true;
            try {
                list = this.b.getAllProviders();
            } catch (Exception unused) {
                list = null;
            }
            if (list != null) {
                z3 = false;
                z2 = false;
                z = false;
                for (String next : list) {
                    next.hashCode();
                    next.hashCode();
                    char c2 = 65535;
                    switch (next.hashCode()) {
                        case -792039641:
                            if (next.equals("passive")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 102570:
                            if (next.equals("gps")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1843485230:
                            if (next.equals("network")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            z = true;
                            break;
                        case 1:
                            z3 = true;
                            break;
                        case 2:
                            z2 = true;
                            break;
                    }
                }
            } else {
                z3 = false;
                z2 = false;
                z = false;
            }
            try {
                int i2 = b.a[providerMode.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (z3) {
                            this.b.requestLocationUpdates("gps", 500, 5.0f, this.h, Looper.getMainLooper());
                        }
                        if (z2) {
                            this.b.requestLocationUpdates("network", 0, 0.0f, this.h, Looper.getMainLooper());
                        }
                    } else if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                this.c.a((q3) this);
                            }
                        } else if (z) {
                            this.b.requestLocationUpdates("passive", 0, 0.0f, this.h, Looper.getMainLooper());
                            if (this.n) {
                                try {
                                    this.l.requestLocationUpdates(t7.a(), (LocationCallback) this.m, Looper.getMainLooper());
                                } catch (Throwable th) {
                                    String str = u;
                                    Log.e(str, "startListening: probably incompatible play-services-location library: " + th);
                                    this.n = false;
                                }
                            }
                        }
                    } else if (z2) {
                        this.b.requestLocationUpdates("network", 0, 0.0f, this.h, Looper.getMainLooper());
                    }
                } else if (z3) {
                    this.b.requestLocationUpdates("gps", 500, 5.0f, this.h, Looper.getMainLooper());
                }
            } catch (Exception e2) {
                String str2 = u;
                Log.d(str2, "startListening: " + e2);
            }
        }
    }

    public void stopListening() {
        d dVar;
        LocationManager locationManager = this.b;
        if (!(locationManager == null || (dVar = this.h) == null)) {
            try {
                locationManager.removeUpdates(dVar);
                if (this.n) {
                    try {
                        this.l.removeLocationUpdates((LocationCallback) this.m);
                    } catch (Throwable th) {
                        String str = u;
                        Log.e(str, "stopListening: probably incompatible play-services-location library: " + th);
                    }
                }
            } catch (Exception e2) {
                String str2 = u;
                Log.d(str2, "stopListening: " + e2);
            }
        }
        this.j = false;
    }

    private static r4 a(Context context) {
        boolean z = true;
        boolean z2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        boolean z3 = context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
        if (Build.VERSION.SDK_INT >= 29 && context.checkCallingOrSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
            z = false;
        }
        if (z2) {
            return z ? r4.PreciseBackground : r4.Precise;
        }
        if (z3) {
            return z ? r4.ApproximateBackground : r4.Approximate;
        }
        return r4.None;
    }

    private long b(Location location) {
        long elapsedRealtimeNanos = location.getElapsedRealtimeNanos() / 1000000;
        this.g = elapsedRealtimeNanos;
        return elapsedRealtimeNanos;
    }

    public static double b() {
        return t;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.location.Location r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto L_0x00c6
            java.lang.String r0 = r8.getProvider()     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00c6
            double r0 = r8.getLatitude()     // Catch:{ all -> 0x00c3 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x001d
            double r0 = r8.getLongitude()     // Catch:{ all -> 0x00c3 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x001d
            goto L_0x00c6
        L_0x001d:
            long r0 = r7.b((android.location.Location) r8)     // Catch:{ all -> 0x00c3 }
            android.location.Location r2 = r7.f     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r8.getProvider()     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = "gps"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00c3 }
            if (r2 != 0) goto L_0x0053
            android.location.Location r2 = r7.f     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r2.getProvider()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x0053
            android.location.Location r2 = r7.f     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r2.getProvider()     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = "gps"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x0053
            long r2 = r7.d     // Catch:{ all -> 0x00c3 }
            long r2 = r0 - r2
            r4 = 5000(0x1388, double:2.4703E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0053
            monitor-exit(r7)
            return
        L_0x0053:
            r7.f = r8     // Catch:{ all -> 0x00c3 }
            android.content.Context r2 = r7.a     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.q4 r2 = a((android.location.Location) r8, (android.content.Context) r2)     // Catch:{ all -> 0x00c3 }
            r7.e = r2     // Catch:{ all -> 0x00c3 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c3 }
            long r5 = r7.g     // Catch:{ all -> 0x00c3 }
            long r3 = r3 - r5
            r2.LocationAge = r3     // Catch:{ all -> 0x00c3 }
            android.content.Context r2 = r7.a     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.g3 r2 = com.umlaut.crowd.internal.g3.a((android.content.Context) r2)     // Catch:{ all -> 0x00c3 }
            r3 = 0
            com.umlaut.crowd.internal.b4 r2 = r2.a((boolean) r3)     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.q4 r3 = r7.e     // Catch:{ all -> 0x00c3 }
            double r4 = r2.b     // Catch:{ all -> 0x00c3 }
            r3.IpLocationLongitude = r4     // Catch:{ all -> 0x00c3 }
            double r4 = r2.a     // Catch:{ all -> 0x00c3 }
            r3.IpLocationLatitude = r4     // Catch:{ all -> 0x00c3 }
            int r4 = r2.c     // Catch:{ all -> 0x00c3 }
            r3.IpLocationAccuracy = r4     // Catch:{ all -> 0x00c3 }
            long r4 = r2.a()     // Catch:{ all -> 0x00c3 }
            r3.IpLocationAge = r4     // Catch:{ all -> 0x00c3 }
            r7.d = r0     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.q4 r2 = r7.e     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.s4 r3 = r2.LocationProvider     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.s4 r4 = com.umlaut.crowd.internal.s4.Gps     // Catch:{ all -> 0x00c3 }
            if (r3 != r4) goto L_0x00a2
            int r3 = r2.NumberOfSatellites     // Catch:{ all -> 0x00c3 }
            if (r3 <= 0) goto L_0x00a2
            int r2 = r2.IsMocked     // Catch:{ all -> 0x00c3 }
            if (r2 != 0) goto L_0x00a2
            com.umlaut.crowd.timeserver.TimeServer r2 = com.umlaut.crowd.InsightCore.getTimeServer()     // Catch:{ all -> 0x00c3 }
            long r3 = r8.getTime()     // Catch:{ all -> 0x00c3 }
            r2.a((long) r3, (long) r0)     // Catch:{ all -> 0x00c3 }
        L_0x00a2:
            com.umlaut.crowd.internal.CLC$e r8 = r7.p     // Catch:{ all -> 0x00c3 }
            if (r8 == 0) goto L_0x00c1
            com.umlaut.crowd.internal.q4 r0 = r7.e     // Catch:{ CloneNotSupportedException -> 0x00b2 }
            java.lang.Object r0 = r0.clone()     // Catch:{ CloneNotSupportedException -> 0x00b2 }
            com.umlaut.crowd.internal.q4 r0 = (com.umlaut.crowd.internal.q4) r0     // Catch:{ CloneNotSupportedException -> 0x00b2 }
            r8.a(r0)     // Catch:{ CloneNotSupportedException -> 0x00b2 }
            goto L_0x00c1
        L_0x00b2:
            r8 = move-exception
            java.lang.String r0 = u     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "getLastLocationInfo"
            android.util.Log.e(r0, r1, r8)     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.CLC$e r8 = r7.p     // Catch:{ all -> 0x00c3 }
            com.umlaut.crowd.internal.q4 r0 = r7.e     // Catch:{ all -> 0x00c3 }
            r8.a(r0)     // Catch:{ all -> 0x00c3 }
        L_0x00c1:
            monitor-exit(r7)
            return
        L_0x00c3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00c6:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CLC.a(android.location.Location):void");
    }

    private static q4 a(Location location, Context context) {
        q4 q4Var = new q4();
        q4Var.LocationAccuracyHorizontal = (double) location.getAccuracy();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 || !location.hasVerticalAccuracy()) {
            q4Var.LocationAccuracyVertical = (double) location.getAccuracy();
        } else {
            q4Var.LocationAccuracyVertical = (double) location.getVerticalAccuracyMeters();
        }
        long timeInMillis = TimeServer.getTimeInMillis();
        q4Var.locationTimestampMillis = timeInMillis;
        q4Var.LocationTimestamp = DateUtils.formatTableau(timeInMillis);
        q4Var.LocationAltitude = location.getAltitude();
        q4Var.LocationBearing = (double) location.getBearing();
        q4Var.LocationLatitude = location.getLatitude();
        q4Var.LocationLongitude = location.getLongitude();
        Bundle extras = location.getExtras();
        if (extras != null) {
            q4Var.NumberOfSatellites = extras.getInt("satellites", -1);
        }
        if (i2 >= 31) {
            q4Var.IsMocked = location.isMock() ? 1 : 0;
        } else {
            q4Var.IsMocked = location.isFromMockProvider() ? 1 : 0;
        }
        if (location.getProvider() == null) {
            q4Var.LocationProvider = s4.Unknown;
        } else if (location.getProvider().equals("gps")) {
            q4Var.LocationProvider = s4.Gps;
        } else if (location.getProvider().equals("network")) {
            q4Var.LocationProvider = s4.Network;
        } else if (location.getProvider().equals("fused")) {
            q4Var.LocationProvider = s4.Fused;
        } else {
            q4Var.LocationProvider = s4.Unknown;
        }
        q4Var.LocationPermissionType = a(context);
        q4Var.LocationSpeed = (double) location.getSpeed();
        return q4Var;
    }

    public void a(q4 q4Var) {
        if (q4Var != null) {
            this.e = q4Var;
        }
        e eVar = this.p;
        if (eVar != null) {
            eVar.a(this.e);
        }
        if (this.j) {
            this.q.postDelayed(this.r, this.i);
        }
    }

    public void a(e eVar) {
        this.p = eVar;
    }

    public static double a() {
        return s;
    }

    public void a(long j2) {
        this.i = j2;
    }
}
