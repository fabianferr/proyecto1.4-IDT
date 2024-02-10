package com.cellrebel.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.networking.beans.response.ProgressResponseBody;
import com.cellrebel.sdk.ping.AndroidPing;
import com.cellrebel.sdk.ping.Ping;
import com.cellrebel.sdk.ping.PingResult;
import com.cellrebel.sdk.workers.BaseMetricsWorker;
import com.cellrebel.sdk.workers.TrackingManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnSuccessListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.client.cache.HeaderConstants;

public class TrackingHelper {
    private static volatile TrackingHelper n;
    public long a;
    public ConnectionType b = ConnectionType.UNKNOWN;
    /* access modifiers changed from: private */
    public FusedLocationProviderClient c;
    private SettingsClient d;
    private Location e;
    private LocationCallback f;
    private FusedLocationProviderClient g;
    private LocationCallback h;
    private TelephonyManager i;
    private TelephonyManager j;
    private TelephonyManager k;
    private Boolean l = Boolean.FALSE;
    private NetworkCapabilities m;

    class a extends LocationCallback {
        final /* synthetic */ LocationCallback a;

        a(LocationCallback locationCallback) {
            this.a = locationCallback;
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            try {
                if (TrackingHelper.this.c != null) {
                    TrackingHelper.this.c.removeLocationUpdates((LocationCallback) this);
                }
                Objects.toString(locationResult);
                TrackingHelper.this.a(locationResult.getLastLocation());
                LocationCallback locationCallback = this.a;
                if (locationCallback != null) {
                    locationCallback.onLocationResult(locationResult);
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    class b extends LocationCallback {
        final /* synthetic */ LocationCallback a;

        b(LocationCallback locationCallback) {
            this.a = locationCallback;
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            try {
                Objects.toString(locationResult);
                if (TrackingHelper.this.c != null) {
                    TrackingHelper.this.c.removeLocationUpdates((LocationCallback) this);
                }
                TrackingHelper.this.a(locationResult.getLastLocation());
                LocationCallback locationCallback = this.a;
                if (locationCallback != null) {
                    locationCallback.onLocationResult(locationResult);
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    class c implements OnSuccessListener<Location> {
        c() {
        }

        /* renamed from: a */
        public void onSuccess(Location location) {
            if (location != null) {
                try {
                    TrackingHelper.this.a(location);
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
        }
    }

    class d extends LocationCallback {
        d() {
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            if (locationResult != null) {
                try {
                    if (locationResult.getLastLocation() != null) {
                        Objects.toString(locationResult.getLastLocation());
                        TrackingHelper.this.a(locationResult.getLastLocation());
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
        }
    }

    private TrackingHelper() {
        if (n != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    private ConnectionType a(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return ConnectionType.TWO_G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return ConnectionType.THREE_G;
            case 13:
            case 18:
                return ConnectionType.FOUR_G;
            case 19:
                return ConnectionType.FOUR_G_CA;
            case 20:
                return ConnectionType.FIVE_G;
            default:
                return ConnectionType.CELLULAR;
        }
    }

    private ConnectionType a(ServiceState serviceState) {
        Object obj;
        CharSequence charSequence = "GSM";
        CharSequence charSequence2 = "HSPAP";
        try {
            String serviceState2 = serviceState.toString();
            CharSequence charSequence3 = "LTE";
            CharSequence charSequence4 = "eHRPD";
            if (serviceState2.contains("RilDataRadioTechnology")) {
                if (!serviceState2.contains("RilDataRadioTechnology = 1 (")) {
                    if (!serviceState2.contains("RilDataRadioTechnology=1(")) {
                        if (!serviceState2.contains("RilDataRadioTechnology = 2 (")) {
                            if (!serviceState2.contains("RilDataRadioTechnology=2(")) {
                                if (!serviceState2.contains("RilDataRadioTechnology = 3 (")) {
                                    if (!serviceState2.contains("RilDataRadioTechnology=3(")) {
                                        if (!serviceState2.contains("RilDataRadioTechnology = 4 (")) {
                                            if (!serviceState2.contains("RilDataRadioTechnology=4(")) {
                                                if (!serviceState2.contains("RilDataRadioTechnology = 5 (")) {
                                                    if (!serviceState2.contains("RilDataRadioTechnology=5(")) {
                                                        if (!serviceState2.contains("RilDataRadioTechnology = 6 (")) {
                                                            if (!serviceState2.contains("RilDataRadioTechnology=6(")) {
                                                                if (!serviceState2.contains("RilDataRadioTechnology = 7 (")) {
                                                                    if (!serviceState2.contains("RilDataRadioTechnology=7(")) {
                                                                        if (!serviceState2.contains("RilDataRadioTechnology = 8 (")) {
                                                                            if (!serviceState2.contains("RilDataRadioTechnology=8(")) {
                                                                                if (!serviceState2.contains("RilDataRadioTechnology = 9 (")) {
                                                                                    if (!serviceState2.contains("RilDataRadioTechnology=9(")) {
                                                                                        if (!serviceState2.contains("RilDataRadioTechnology = 10")) {
                                                                                            if (!serviceState2.contains("RilDataRadioTechnology=10")) {
                                                                                                if (!serviceState2.contains("RilDataRadioTechnology = 11")) {
                                                                                                    if (!serviceState2.contains("RilDataRadioTechnology=11")) {
                                                                                                        if (!serviceState2.contains("RilDataRadioTechnology = 12")) {
                                                                                                            if (!serviceState2.contains("RilDataRadioTechnology=12")) {
                                                                                                                if (!serviceState2.contains("RilDataRadioTechnology = 13")) {
                                                                                                                    if (!serviceState2.contains("RilDataRadioTechnology=13")) {
                                                                                                                        if (!serviceState2.contains("RilDataRadioTechnology = 14")) {
                                                                                                                            if (!serviceState2.contains("RilDataRadioTechnology=14")) {
                                                                                                                                if (!serviceState2.contains("RilDataRadioTechnology = 15")) {
                                                                                                                                    if (!serviceState2.contains("RilDataRadioTechnology=15")) {
                                                                                                                                        if ((serviceState2.contains("RilDataRadioTechnology = 16") || serviceState2.contains("RilDataRadioTechnology=16")) && Build.VERSION.SDK_INT >= 25) {
                                                                                                                                            return a(16);
                                                                                                                                        }
                                                                                                                                        if ((serviceState2.contains("RilDataRadioTechnology = 17") || serviceState2.contains("RilDataRadioTechnology=17")) && Build.VERSION.SDK_INT >= 25) {
                                                                                                                                            return a(17);
                                                                                                                                        }
                                                                                                                                        if ((serviceState2.contains("RilDataRadioTechnology = 18") || serviceState2.contains("RilDataRadioTechnology=18")) && Build.VERSION.SDK_INT >= 25) {
                                                                                                                                            return a(18);
                                                                                                                                        }
                                                                                                                                        if (!serviceState2.contains("RilDataRadioTechnology = 19")) {
                                                                                                                                            if (!serviceState2.contains("RilDataRadioTechnology=19")) {
                                                                                                                                                if ((serviceState2.contains("RilDataRadioTechnology = 20") || serviceState2.contains("RilDataRadioTechnology=20")) && Build.VERSION.SDK_INT >= 29) {
                                                                                                                                                    return a(20);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        return a(19);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                return a(15);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        return a(13);
                                                                                                                    }
                                                                                                                }
                                                                                                                return a(14);
                                                                                                            }
                                                                                                        }
                                                                                                        return a(12);
                                                                                                    }
                                                                                                }
                                                                                                return a(10);
                                                                                            }
                                                                                        }
                                                                                        return a(9);
                                                                                    }
                                                                                }
                                                                                return a(8);
                                                                            }
                                                                        }
                                                                        return a(6);
                                                                    }
                                                                }
                                                                return a(5);
                                                            }
                                                        }
                                                        return a(7);
                                                    }
                                                }
                                                return a(4);
                                            }
                                        }
                                        return a(4);
                                    }
                                }
                                return a(3);
                            }
                        }
                        return a(2);
                    }
                }
                return a(1);
            }
            ArrayList arrayList = new ArrayList();
            if (serviceState2.contains("GPRS")) {
                arrayList.add("GPRS");
            }
            if (serviceState2.contains("EDGE")) {
                arrayList.add("EDGE");
            }
            if (serviceState2.contains("UMTS")) {
                arrayList.add("UMTS");
            }
            if (serviceState2.contains("CDMA-IS95A")) {
                arrayList.add("CDMA-IS95A");
            }
            if (serviceState2.contains("CDMA-IS95B")) {
                arrayList.add("CDMA-IS95B");
            }
            if (serviceState2.contains("1xRTT")) {
                arrayList.add("1xRTT");
            }
            if (serviceState2.contains("EvDo-rev.0")) {
                arrayList.add("EvDo-rev.0");
            }
            if (serviceState2.contains("EvDo-rev.A")) {
                arrayList.add("EvDo-rev.A");
            }
            if (serviceState2.contains("HSDPA")) {
                arrayList.add("HSDPA");
            }
            if (serviceState2.contains("HSUPA")) {
                arrayList.add("HSUPA");
            }
            if (serviceState2.contains("HSPA")) {
                arrayList.add("HSPA");
            }
            if (serviceState2.contains("EvDo-rev.B")) {
                arrayList.add("EvDo-rev.B");
            }
            CharSequence charSequence5 = charSequence4;
            if (serviceState2.contains(charSequence5)) {
                arrayList.add(charSequence5);
            }
            CharSequence charSequence6 = charSequence5;
            CharSequence charSequence7 = charSequence3;
            if (serviceState2.contains(charSequence7)) {
                arrayList.add(charSequence7);
            }
            CharSequence charSequence8 = charSequence7;
            CharSequence charSequence9 = charSequence2;
            if (serviceState2.contains(charSequence9)) {
                arrayList.add(charSequence9);
            }
            CharSequence charSequence10 = charSequence9;
            CharSequence charSequence11 = charSequence;
            if (serviceState2.contains(charSequence11)) {
                arrayList.add(charSequence11);
            }
            if (arrayList.isEmpty()) {
                return ConnectionType.CELLULAR;
            }
            CharSequence charSequence12 = charSequence11;
            Object obj2 = "EvDo-rev.B";
            if (arrayList.size() > 1) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                obj = "HSPA";
                if (serviceState2.indexOf(str) > serviceState2.indexOf(str2)) {
                    arrayList.remove(str2);
                } else {
                    arrayList.remove(str);
                }
            } else {
                obj = "HSPA";
            }
            String str3 = (String) arrayList.get(0);
            if (str3.equals("GPRS")) {
                return a(1);
            }
            if (str3.equals("EDGE")) {
                return a(2);
            }
            if (str3.equals("UMTS")) {
                return a(3);
            }
            if (str3.equals("CDMA-IS95A")) {
                return a(4);
            }
            if (str3.equals("CDMA-IS95B")) {
                return a(4);
            }
            if (str3.equals("1xRTT")) {
                return a(7);
            }
            if (str3.equals("EvDo-rev.0")) {
                return a(5);
            }
            if (str3.equals("EvDo-rev.A")) {
                return a(6);
            }
            if (str3.equals("HSDPA")) {
                return a(8);
            }
            if (str3.equals("HSUPA")) {
                return a(9);
            }
            if (str3.equals(obj)) {
                return a(10);
            }
            if (str3.equals(obj2)) {
                return a(12);
            }
            if (str3.equals(charSequence6)) {
                return a(14);
            }
            if (str3.equals(charSequence8)) {
                return a(13);
            }
            if (str3.equals(charSequence10)) {
                return a(15);
            }
            if (str3.equals(charSequence12)) {
                return a(16);
            }
            return ConnectionType.CELLULAR;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static TrackingHelper a() {
        if (n == null) {
            synchronized (TrackingHelper.class) {
                if (n == null) {
                    n = new TrackingHelper();
                }
            }
        }
        return n;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Response a(Interceptor.Chain chain) {
        Request request = chain.request();
        String w = PreferencesManager.m().w();
        if (!TextUtils.isEmpty(w)) {
            request = request.newBuilder().addHeader("Authorization", w).addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE).build();
        }
        Response proceed = chain.proceed(request);
        return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), (ProgressResponseBody.ProgressListener) null)).build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(LocationCallback locationCallback, LocationRequest locationRequest, LocationSettingsResponse locationSettingsResponse) {
        a aVar = new a(locationCallback);
        this.f = aVar;
        FusedLocationProviderClient fusedLocationProviderClient = this.c;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, (LocationCallback) aVar, Looper.myLooper());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(LocationCallback locationCallback, Exception exc) {
        if (locationCallback != null) {
            locationCallback.onLocationResult((LocationResult) null);
        }
    }

    private ConnectionType b(Context context) {
        List<CellInfo> a2;
        try {
            if (!(h(context) == null || ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0 || (a2 = TelephonyHelper.b().a(context)) == null)) {
                if (!a2.isEmpty()) {
                    CellInfo a3 = BaseMetricsWorker.a(a2, m(context), l(context), (ConnectionType) null);
                    if (Build.VERSION.SDK_INT >= 29 && (a3 instanceof CellInfoNr)) {
                        return ConnectionType.FIVE_G;
                    }
                    if (a3 instanceof CellInfoLte) {
                        return ConnectionType.FOUR_G;
                    }
                    if (a3 instanceof CellInfoWcdma) {
                        return ConnectionType.THREE_G;
                    }
                    if (a3 instanceof CellInfoGsm) {
                        return ConnectionType.TWO_G;
                    }
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(LocationCallback locationCallback, LocationRequest locationRequest, LocationSettingsResponse locationSettingsResponse) {
        b bVar = new b(locationCallback);
        this.f = bVar;
        FusedLocationProviderClient fusedLocationProviderClient = this.c;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, (LocationCallback) bVar, Looper.myLooper());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(LocationCallback locationCallback, Exception exc) {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(60000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setMaxWaitTime(60000);
        locationRequest.setExpirationDuration(TimeUnit.SECONDS.toMillis(60));
        locationRequest.setPriority(102);
        this.d.checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(locationRequest).build()).addOnSuccessListener(new TrackingHelper$$ExternalSyntheticLambda4(this, locationCallback, locationRequest)).addOnFailureListener(new TrackingHelper$$ExternalSyntheticLambda5(locationCallback));
    }

    private LatencyItem c(String str) {
        try {
            InetAddress byName = InetAddress.getByName(new URL(str).getHost());
            PingResult a2 = Ping.a(byName).a(2000).a();
            a2.a();
            if (a2.a() > 0.0f) {
                return new LatencyItem((int) a2.a(), 1);
            }
            AndroidPing androidPing = new AndroidPing(byName);
            androidPing.a(2000);
            androidPing.run();
            return new LatencyItem((int) androidPing.f, 2);
        } catch (MalformedURLException | UnknownHostException e2) {
            e2.toString();
            return new LatencyItem(0, 0);
        } catch (Throwable unused) {
            return new LatencyItem(0, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        if (androidx.core.app.ActivityCompat.checkSelfPermission(r7, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r6.l = r1     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            com.google.android.gms.location.LocationRequest r1 = new com.google.android.gms.location.LocationRequest     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r2 = 6000(0x1770, double:2.9644E-320)
            r1.setInterval(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r4 = 3000(0xbb8, double:1.482E-320)
            r1.setFastestInterval(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r1.setMaxWaitTime(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r3 = 120(0x78, double:5.93E-322)
            long r2 = r2.toMillis(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r1.setExpirationDuration(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r2 = 100
            r1.setPriority(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            com.google.android.gms.location.LocationCallback r2 = r6.h     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            if (r2 != 0) goto L_0x0073
            com.google.android.gms.location.FusedLocationProviderClient r2 = com.google.android.gms.location.LocationServices.getFusedLocationProviderClient((android.content.Context) r7)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r6.g = r2     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r7, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            if (r2 == 0) goto L_0x0040
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r7, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            if (r2 != 0) goto L_0x004e
        L_0x0040:
            com.google.android.gms.location.FusedLocationProviderClient r2 = r6.g     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            com.google.android.gms.tasks.Task r2 = r2.getLastLocation()     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            com.cellrebel.sdk.utils.TrackingHelper$c r4 = new com.cellrebel.sdk.utils.TrackingHelper$c     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r2.addOnSuccessListener(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
        L_0x004e:
            com.cellrebel.sdk.utils.TrackingHelper$d r2 = new com.cellrebel.sdk.utils.TrackingHelper$d     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r6.h = r2     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r7, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            if (r0 == 0) goto L_0x0066
            int r7 = androidx.core.app.ActivityCompat.checkSelfPermission(r7, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            if (r7 != 0) goto L_0x0062
            goto L_0x0066
        L_0x0062:
            r7 = 0
            r6.h = r7     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            goto L_0x0073
        L_0x0066:
            com.google.android.gms.location.FusedLocationProviderClient r7 = r6.g     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            if (r7 == 0) goto L_0x0073
            com.google.android.gms.location.LocationCallback r0 = r6.h     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            android.os.Looper r2 = android.os.Looper.myLooper()     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
            r7.requestLocationUpdates((com.google.android.gms.location.LocationRequest) r1, (com.google.android.gms.location.LocationCallback) r0, (android.os.Looper) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0073 }
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.TrackingHelper.A(android.content.Context):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|(1:9)|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x009d A[Catch:{ Exception | OutOfMemoryError -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            com.cellrebel.sdk.networking.RequestEventListener r1 = new com.cellrebel.sdk.networking.RequestEventListener     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.OkHttpClient$Builder r2 = new okhttp3.OkHttpClient$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r3 = 0
            okhttp3.OkHttpClient$Builder r2 = r2.cache(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r5 = 60
            okhttp3.OkHttpClient$Builder r2 = r2.readTimeout(r5, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.OkHttpClient$Builder r2 = r2.writeTimeout(r5, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.OkHttpClient$Builder r2 = r2.connectTimeout(r5, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.OkHttpClient$Builder r2 = r2.retryOnConnectionFailure(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            com.cellrebel.sdk.networking.TokenAuthenticator r4 = new com.cellrebel.sdk.networking.TokenAuthenticator     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r2.authenticator(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r2.eventListener(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            com.cellrebel.sdk.utils.TrackingHelper$$ExternalSyntheticLambda1 r4 = new com.cellrebel.sdk.utils.TrackingHelper$$ExternalSyntheticLambda1     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r2.addInterceptor(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            java.lang.String r4 = "TLSv1.2"
            javax.net.ssl.SSLContext r4 = javax.net.ssl.SSLContext.getInstance(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
            r4.init(r3, r3, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
            com.cellrebel.sdk.networking.TLSSocketFactory r3 = new com.cellrebel.sdk.networking.TLSSocketFactory     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
            javax.net.ssl.SSLSocketFactory r4 = r4.getSocketFactory()     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
            r3.<init>(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
            com.cellrebel.sdk.networking.FullX509TrustManager r4 = com.cellrebel.sdk.networking.ApiClient.b()     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
            r2.sslSocketFactory(r3, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0050 }
        L_0x0050:
            okhttp3.ConnectionSpec$Builder r3 = new okhttp3.ConnectionSpec$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.ConnectionSpec r4 = okhttp3.ConnectionSpec.MODERN_TLS     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r3.<init>((okhttp3.ConnectionSpec) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4 = 1
            okhttp3.TlsVersion[] r4 = new okhttp3.TlsVersion[r4]     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.TlsVersion r5 = okhttp3.TlsVersion.TLS_1_2     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4[r0] = r5     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.ConnectionSpec$Builder r3 = r3.tlsVersions((okhttp3.TlsVersion[]) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.ConnectionSpec r3 = r3.build()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4.add(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.ConnectionSpec r3 = okhttp3.ConnectionSpec.COMPATIBLE_TLS     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4.add(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.ConnectionSpec r3 = okhttp3.ConnectionSpec.CLEARTEXT     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r4.add(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r2.connectionSpecs(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.OkHttpClient r2 = r2.build()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r3.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.Request$Builder r8 = r3.url((java.lang.String) r8)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.Request r8 = r8.build()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.Call r8 = r2.newCall(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.Response r8 = r8.execute()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r8.isSuccessful()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            okhttp3.ResponseBody r2 = r8.body()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            if (r2 == 0) goto L_0x00a4
            okhttp3.ResponseBody r8 = r8.body()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            r8.close()     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
        L_0x00a4:
            int r8 = r1.d     // Catch:{ Exception | OutOfMemoryError -> 0x00a7 }
            return r8
        L_0x00a7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.TrackingHelper.a(java.lang.String):int");
    }

    public ConnectionType a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    this.m = networkCapabilities;
                    if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                        return ConnectionType.WIFI;
                    }
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                    return ConnectionType.WIFI;
                }
            }
            return x(context);
        } catch (Exception | OutOfMemoryError unused) {
            return x(context);
        }
    }

    public void a(Context context, LocationCallback locationCallback) {
        try {
            if (this.d == null) {
                y(context);
            }
            if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1 || ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1) {
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.setInterval(60000);
                locationRequest.setFastestInterval(5000);
                locationRequest.setMaxWaitTime(60000);
                locationRequest.setExpirationDuration(TimeUnit.SECONDS.toMillis(60));
                locationRequest.setPriority(100);
                this.d.checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(locationRequest).build()).addOnSuccessListener(new TrackingHelper$$ExternalSyntheticLambda2(this, locationCallback, locationRequest)).addOnFailureListener(new TrackingHelper$$ExternalSyntheticLambda3(this, locationCallback));
            } else if (locationCallback != null) {
                locationCallback.onLocationResult((LocationResult) null);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(Location location) {
        if (location != null) {
            try {
                if (this.e == null) {
                    this.e = location;
                } else if (location.getTime() > this.e.getTime()) {
                    this.e = location;
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    public Location b() {
        return this.e;
    }

    public LatencyItem b(String str) {
        try {
            LatencyItem c2 = c(str);
            if (c2.a() == 0 || c2.a() > 1000) {
                return c2;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < 5; i2++) {
                LatencyItem c3 = c(str);
                if (c3.a() > 0) {
                    arrayList.add(Integer.valueOf(c3.a()));
                }
            }
            arrayList.toString();
            Integer num = 0;
            if (arrayList.isEmpty()) {
                return num.intValue() > 0 ? new LatencyItem(num.intValue(), 0) : new LatencyItem(c2.a(), 0);
            }
            for (Integer intValue : arrayList) {
                num = Integer.valueOf(num.intValue() + intValue.intValue());
            }
            double doubleValue = num.doubleValue();
            double size = (double) arrayList.size();
            Double.isNaN(size);
            return new LatencyItem((int) (doubleValue / size), 0);
        } catch (Exception | OutOfMemoryError unused) {
            return new LatencyItem(0, 0);
        }
    }

    public String c(Context context) {
        TelephonyManager h2 = h(context);
        if (h2 == null) {
            return "UNKNOWN";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && connectivityManager.getNetworkInfo(1).isConnectedOrConnecting()) {
                return "WIFI";
            }
            if (Build.VERSION.SDK_INT >= 30 && ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
                return "UNKNOWN";
            }
            switch (h2.getNetworkType()) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "IDEN";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "EHRPD";
                case 15:
                    return "HSPAP";
                case 16:
                    return "GSM";
                case 17:
                    return "TD_SCDMA";
                case 18:
                    return "IWLAN";
                case 19:
                    return "LTE_CA";
                case 20:
                    return "NR";
            }
            return "UNKNOWN";
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public boolean c() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) TrackingManager.getContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (activeNetworkInfo.isConnected()) {
                return true;
            }
            WifiManager wifiManager = (WifiManager) TrackingManager.getContext().getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return false;
            }
            return wifiManager.isWifiEnabled();
        } catch (Exception | OutOfMemoryError unused) {
            return true;
        }
    }

    public String d(Context context) {
        try {
            TelephonyManager h2 = h(context);
            return h2 == null ? "" : h2.getSimOperatorName();
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public void d() {
        this.i = null;
        this.j = null;
        this.k = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:21|(9:23|(1:25)|26|(1:28)|(1:30)|31|(1:33)|34|(1:36))|37|(7:39|(1:41)|42|(1:44)|45|(1:47)|48)(1:49)|50|(11:52|(1:54)|55|(1:57)|58|(1:60)|(1:62)|63|(1:65)|(1:67)|68)|69|70|(11:74|75|76|77|(1:79)|80|(1:82)|85|86|(2:88|121)(1:122)|89)|83|85|86|(0)(0)|89|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0260 */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0277 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0264 A[Catch:{ Exception | OutOfMemoryError -> 0x02fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e(android.content.Context r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = 0
            android.telephony.TelephonyManager r2 = r22.h(r23)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r2 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            int r3 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r3 == 0) goto L_0x001b
            return r1
        L_0x001b:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r4 = "dd MMM yyyy HH:mm:ss"
            r3.<init>(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.content.Context r4 = r23.getApplicationContext()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r5 = "wifi"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r5 = 1000(0x3e8, double:4.94E-321)
            r7 = 1000000(0xf4240, double:4.940656E-318)
            if (r4 == 0) goto L_0x007a
            android.net.wifi.WifiInfo r9 = r4.getConnectionInfo()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r9.getSSID()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.util.List r4 = r4.getScanResults()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x0044:
            boolean r9 = r4.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r9 == 0) goto L_0x007a
            java.lang.Object r9 = r4.next()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r12 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r10 = r10 - r12
            long r12 = r9.timestamp     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r12 = r12 / r7
            long r10 = r10 + r12
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r12 = r12 - r10
            long r12 = r12 / r5
            java.util.Date r9 = new java.util.Date     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r9.<init>(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r3.format(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String.valueOf(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.util.Date r9 = new java.util.Date     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r9.<init>(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r3.format(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String.valueOf(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            goto L_0x0044
        L_0x007a:
            r2.getNetworkOperator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r2.getSimOperator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            com.cellrebel.sdk.utils.TelephonyHelper r4 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.util.List r4 = r4.a((android.content.Context) r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r4 == 0) goto L_0x027b
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x008e:
            boolean r10 = r4.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r10 == 0) goto L_0x027b
            java.lang.Object r10 = r4.next()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellInfo r10 = (android.telephony.CellInfo) r10     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            boolean r11 = r10 instanceof android.telephony.CellInfoGsm     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r12 = 26
            r13 = 24
            r14 = 28
            if (r11 == 0) goto L_0x010a
            r11 = r10
            android.telephony.CellInfoGsm r11 = (android.telephony.CellInfoGsm) r11     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityGsm r15 = r11.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r11.isRegistered()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 < r14) goto L_0x00b5
            r11.getCellConnectionStatus()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x00b5:
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r18 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r16 = r16 - r18
            long r18 = r11.getTimeStamp()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r18 = r18 / r7
            long r7 = r16 + r18
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r16 = r16 - r7
            long r16 = r16 / r5
            java.util.Date r11 = new java.util.Date     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r11.<init>(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r3.format(r11)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String.valueOf(r16)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 < r13) goto L_0x00df
            r15.getArfcn()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x00df:
            if (r1 < r13) goto L_0x00e4
            r15.getBsic()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x00e4:
            r15.getCid()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r15.getLac()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r15.getMcc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r15.getMnc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 < r14) goto L_0x00f5
            r15.getMobileNetworkOperator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x00f5:
            r7 = r10
            android.telephony.CellInfoGsm r7 = (android.telephony.CellInfoGsm) r7     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellSignalStrengthGsm r7 = r7.getCellSignalStrength()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getAsuLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getDbm()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 < r12) goto L_0x010a
            r7.getTimingAdvance()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x010a:
            boolean r1 = r10 instanceof android.telephony.CellInfoWcdma     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 == 0) goto L_0x0172
            r1 = r10
            android.telephony.CellInfoWcdma r1 = (android.telephony.CellInfoWcdma) r1     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityWcdma r7 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r1.isRegistered()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r14) goto L_0x011f
            r1.getCellConnectionStatus()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x011f:
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r18 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r16 = r16 - r18
            long r18 = r1.getTimeStamp()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r18 = r18 / r20
            r11 = r10
            long r9 = r16 + r18
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r16 = r16 - r9
            long r16 = r16 / r5
            java.util.Date r15 = new java.util.Date     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r15.<init>(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r3.format(r15)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String.valueOf(r16)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getCid()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getLac()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getMcc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getMnc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r14) goto L_0x0159
            r7.getMobileNetworkOperator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x0159:
            r7.getPsc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r13) goto L_0x0161
            r7.getUarfcn()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x0161:
            r10 = r11
            android.telephony.CellInfoWcdma r10 = (android.telephony.CellInfoWcdma) r10     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellSignalStrengthWcdma r7 = r10.getCellSignalStrength()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getAsuLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getDbm()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            goto L_0x0173
        L_0x0172:
            r11 = r10
        L_0x0173:
            boolean r7 = r11 instanceof android.telephony.CellInfoLte     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r7 == 0) goto L_0x01f1
            r10 = r11
            android.telephony.CellInfoLte r10 = (android.telephony.CellInfoLte) r10     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityLte r7 = r10.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r10.isRegistered()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r14) goto L_0x0188
            r10.getCellConnectionStatus()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x0188:
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r18 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r16 = r16 - r18
            long r9 = r10.getTimeStamp()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r9 / r18
            long r9 = r16 + r9
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r16 = r16 - r9
            long r16 = r16 / r5
            java.util.Date r15 = new java.util.Date     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r15.<init>(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r3.format(r15)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String.valueOf(r16)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r14) goto L_0x01b5
            r7.getBandwidth()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x01b5:
            r7.getCi()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getTac()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getMcc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getMnc()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r14) goto L_0x01c6
            r7.getMobileNetworkOperator()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x01c6:
            if (r8 < r13) goto L_0x01cb
            r7.getEarfcn()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x01cb:
            r7.getPci()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r10 = r11
            android.telephony.CellInfoLte r10 = (android.telephony.CellInfoLte) r10     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellSignalStrengthLte r7 = r10.getCellSignalStrength()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getAsuLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getDbm()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r8 < r12) goto L_0x01e3
            r7.getCqi()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x01e3:
            if (r8 < r12) goto L_0x01ee
            r7.getRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r7.getRssnr()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x01ee:
            r7.getTimingAdvance()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x01f1:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            r1 = 29
            if (r7 < r1) goto L_0x025d
            boolean r7 = r11 instanceof android.telephony.CellInfoNr     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            if (r7 == 0) goto L_0x025d
            r10 = r11
            android.telephony.CellInfoNr r10 = (android.telephony.CellInfoNr) r10     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            android.telephony.CellIdentity r7 = r10.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            android.telephony.CellSignalStrength r8 = r10.getCellSignalStrength()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            r10.isRegistered()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            r10.getCellConnectionStatus()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            long r14 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            long r12 = r12 - r14
            long r9 = r10.getTimeStamp()     // Catch:{ Exception | OutOfMemoryError -> 0x025d }
            r14 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r9 / r14
            long r12 = r12 + r9
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            long r9 = r9 - r12
            long r9 = r9 / r5
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r1.<init>(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r3.format(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            java.lang.String.valueOf(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            boolean r1 = r7 instanceof android.telephony.CellIdentityNr     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            if (r1 == 0) goto L_0x023b
            android.telephony.CellIdentityNr r7 = (android.telephony.CellIdentityNr) r7     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r7.getNrarfcn()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r7.getPci()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
        L_0x023b:
            boolean r1 = r8 instanceof android.telephony.CellSignalStrengthNr     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            if (r1 == 0) goto L_0x0260
            android.telephony.CellSignalStrengthNr r8 = (android.telephony.CellSignalStrengthNr) r8     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getAsuLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getDbm()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getLevel()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getCsiRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getCsiRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getCsiSinr()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getSsRsrp()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getSsRsrq()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            r8.getSsSinr()     // Catch:{ Exception | OutOfMemoryError -> 0x0260 }
            goto L_0x0260
        L_0x025d:
            r14 = 1000000(0xf4240, double:4.940656E-318)
        L_0x0260:
            boolean r1 = r11 instanceof android.telephony.CellInfoCdma     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 == 0) goto L_0x0277
            r10 = r11
            android.telephony.CellInfoCdma r10 = (android.telephony.CellInfoCdma) r10     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityCdma r1 = r10.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r10.isRegistered()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r1.getBasestationId()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r1.getNetworkId()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r1.getSystemId()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x0277:
            r7 = r14
            r1 = 0
            goto L_0x008e
        L_0x027b:
            android.telephony.CellInfo r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r0, (android.telephony.TelephonyManager) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 != 0) goto L_0x028d
            com.cellrebel.sdk.utils.TrackingHelper r1 = a()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.TelephonyManager r1 = r1.i(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellInfo r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r0, (android.telephony.TelephonyManager) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
        L_0x028d:
            if (r1 == 0) goto L_0x02fd
            r1.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            boolean r0 = r1 instanceof android.telephony.CellInfoGsm     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r0 == 0) goto L_0x02a5
            android.telephony.CellInfoGsm r1 = (android.telephony.CellInfoGsm) r1     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityGsm r0 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r0 = r0.getCid()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            return r0
        L_0x02a5:
            boolean r0 = r1 instanceof android.telephony.CellInfoWcdma     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r0 == 0) goto L_0x02b8
            android.telephony.CellInfoWcdma r1 = (android.telephony.CellInfoWcdma) r1     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityWcdma r0 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r0 = r0.getCid()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            return r0
        L_0x02b8:
            boolean r0 = r1 instanceof android.telephony.CellInfoLte     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r0 == 0) goto L_0x02cb
            android.telephony.CellInfoLte r1 = (android.telephony.CellInfoLte) r1     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityLte r0 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r0 = r0.getCi()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            return r0
        L_0x02cb:
            boolean r0 = r1 instanceof android.telephony.CellInfoCdma     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r0 == 0) goto L_0x02de
            android.telephony.CellInfoCdma r1 = (android.telephony.CellInfoCdma) r1     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentityCdma r0 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            int r0 = r0.getBasestationId()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            return r0
        L_0x02de:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            r2 = 29
            if (r0 < r2) goto L_0x02fd
            boolean r0 = r1 instanceof android.telephony.CellInfoNr     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r0 == 0) goto L_0x02fd
            android.telephony.CellInfoNr r1 = (android.telephony.CellInfoNr) r1     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            android.telephony.CellIdentity r0 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            boolean r1 = r0 instanceof android.telephony.CellIdentityNr     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            if (r1 == 0) goto L_0x02fd
            android.telephony.CellIdentityNr r0 = (android.telephony.CellIdentityNr) r0     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            long r0 = r0.getNci()     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02fd }
            return r0
        L_0x02fd:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.TrackingHelper.e(android.content.Context):java.lang.String");
    }

    public void e() {
        LocationCallback locationCallback;
        try {
            this.l = Boolean.FALSE;
            FusedLocationProviderClient fusedLocationProviderClient = this.g;
            if (fusedLocationProviderClient != null && (locationCallback = this.h) != null) {
                fusedLocationProviderClient.removeLocationUpdates(locationCallback);
                this.h = null;
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public int f(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            Class<SubscriptionManager> cls = SubscriptionManager.class;
            try {
                return ((Integer) cls.getMethod("getPhoneId", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(SubscriptionManager.getDefaultDataSubscriptionId())})).intValue();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
        return 0;
    }

    public int g(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            Class<SubscriptionManager> cls = SubscriptionManager.class;
            try {
                return ((Integer) cls.getMethod("getSlotIndex", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(SubscriptionManager.getDefaultDataSubscriptionId())})).intValue() + 1;
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
        return 1;
    }

    public TelephonyManager h(Context context) {
        try {
            TelephonyManager telephonyManager = this.j;
            if (telephonyManager != null) {
                return telephonyManager;
            }
            TelephonyManager i2 = i(context);
            if (i2 != null && Build.VERSION.SDK_INT >= 24) {
                TelephonyManager createForSubscriptionId = i2.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId());
                this.j = createForSubscriptionId;
                if (createForSubscriptionId != null) {
                    return createForSubscriptionId;
                }
            }
            this.j = i2;
            return i2;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public TelephonyManager i(Context context) {
        try {
            TelephonyManager telephonyManager = this.i;
            if (telephonyManager != null) {
                return telephonyManager;
            }
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
            this.i = telephonyManager2;
            return telephonyManager2;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:26|27|(2:31|(2:33|34))|35|36|(2:38|39)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0089 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d A[Catch:{ Exception | OutOfMemoryError -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String j(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 0
            android.telephony.TelephonyManager r1 = r3.h(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r2 == 0) goto L_0x0019
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r2 == 0) goto L_0x0019
            return r0
        L_0x0019:
            android.telephony.CellInfo r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r4, (android.telephony.TelephonyManager) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r1 != 0) goto L_0x002b
            com.cellrebel.sdk.utils.TrackingHelper r1 = a()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.telephony.TelephonyManager r1 = r1.i(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.telephony.CellInfo r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r4, (android.telephony.TelephonyManager) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
        L_0x002b:
            if (r1 == 0) goto L_0x009c
            r1.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            boolean r4 = r1 instanceof android.telephony.CellInfoGsm     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r4 == 0) goto L_0x0043
            android.telephony.CellInfoGsm r1 = (android.telephony.CellInfoGsm) r1     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.telephony.CellIdentityGsm r4 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            int r4 = r4.getLac()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            return r4
        L_0x0043:
            boolean r4 = r1 instanceof android.telephony.CellInfoWcdma     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r4 == 0) goto L_0x0056
            android.telephony.CellInfoWcdma r1 = (android.telephony.CellInfoWcdma) r1     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.telephony.CellIdentityWcdma r4 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            int r4 = r4.getLac()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            return r4
        L_0x0056:
            boolean r4 = r1 instanceof android.telephony.CellInfoLte     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r4 == 0) goto L_0x0069
            android.telephony.CellInfoLte r1 = (android.telephony.CellInfoLte) r1     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.telephony.CellIdentityLte r4 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            int r4 = r4.getTac()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            return r4
        L_0x0069:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            r2 = 29
            if (r4 < r2) goto L_0x0089
            boolean r4 = r1 instanceof android.telephony.CellInfoNr     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            if (r4 == 0) goto L_0x0089
            r4 = r1
            android.telephony.CellInfoNr r4 = (android.telephony.CellInfoNr) r4     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            android.telephony.CellIdentity r4 = r4.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            boolean r2 = r4 instanceof android.telephony.CellIdentityNr     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            if (r2 == 0) goto L_0x0089
            android.telephony.CellIdentityNr r4 = (android.telephony.CellIdentityNr) r4     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            int r4 = r4.getTac()     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0089 }
            return r4
        L_0x0089:
            boolean r4 = r1 instanceof android.telephony.CellInfoCdma     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r4 == 0) goto L_0x009c
            android.telephony.CellInfoCdma r1 = (android.telephony.CellInfoCdma) r1     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.telephony.CellIdentityCdma r4 = r1.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            int r4 = r4.getNetworkId()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            return r4
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.TrackingHelper.j(android.content.Context):java.lang.String");
    }

    public NetworkCapabilities k(Context context) {
        NetworkCapabilities networkCapabilities = this.m;
        if (networkCapabilities != null) {
            return networkCapabilities;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            this.m = networkCapabilities2;
            return networkCapabilities2;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public String l(Context context) {
        String networkOperator;
        try {
            TelephonyManager h2 = h(context);
            if (!(h2 == null || (networkOperator = h2.getNetworkOperator()) == null || networkOperator.length() <= 0)) {
                return networkOperator.substring(0, 3);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        return "";
    }

    public String m(Context context) {
        String networkOperator;
        try {
            TelephonyManager h2 = h(context);
            if (!(h2 == null || (networkOperator = h2.getNetworkOperator()) == null || networkOperator.length() <= 0)) {
                String substring = networkOperator.substring(3);
                return substring.startsWith("0") ? substring.replaceFirst("0", "") : substring;
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        return "";
    }

    public String n(Context context) {
        try {
            TelephonyManager h2 = h(context);
            if (h2 == null) {
                return "";
            }
            h2.getNetworkOperatorName();
            return h2.getNetworkOperatorName();
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public int o(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
            }
            return 1;
        } catch (Exception | OutOfMemoryError unused) {
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String p(android.content.Context r9) {
        /*
            r8 = this;
            android.telephony.TelephonyManager r0 = r8.t(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x004a }
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x004a }
            r3 = 24
            if (r2 < r3) goto L_0x003b
            java.lang.Class<android.telephony.TelephonyManager> r2 = android.telephony.TelephonyManager.class
            java.lang.String r3 = "getSimOperatorNameForPhone"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            r7 = 0
            r5[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            int r4 = r8.q(r9)     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            r3[r7] = r4     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x0037, IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033, Exception | OutOfMemoryError -> 0x004a }
            r1 = r0
            goto L_0x003b
        L_0x0033:
            r0 = move-exception
            goto L_0x0038
        L_0x0035:
            r0 = move-exception
            goto L_0x0038
        L_0x0037:
            r0 = move-exception
        L_0x0038:
            r0.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x004a }
        L_0x003b:
            int r0 = r1.length()     // Catch:{ Exception | OutOfMemoryError -> 0x004a }
            if (r0 != 0) goto L_0x0049
            android.telephony.TelephonyManager r9 = r8.t(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x004a }
            java.lang.String r1 = r9.getSimOperatorName()     // Catch:{ Exception | OutOfMemoryError -> 0x004a }
        L_0x0049:
            return r1
        L_0x004a:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.TrackingHelper.p(android.content.Context):java.lang.String");
    }

    public int q(Context context) {
        return f(context) == 0 ? 1 : 0;
    }

    public String r(Context context) {
        try {
            TelephonyManager t = t(context);
            if (t == null) {
                return "";
            }
            String simOperator = t.getSimOperator();
            if (simOperator.length() > 0) {
                return simOperator.substring(0, 3);
            }
            return "";
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[Catch:{ Exception | OutOfMemoryError -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x0002] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String s(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            android.telephony.TelephonyManager r1 = r8.t(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
            if (r1 != 0) goto L_0x0009
            return r0
        L_0x0009:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
            r3 = 24
            if (r2 < r3) goto L_0x003a
            java.lang.Class<android.telephony.TelephonyManager> r2 = android.telephony.TelephonyManager.class
            java.lang.String r3 = "getSimOperatorNumericForPhone"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            r7 = 0
            r5[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            int r4 = r8.q(r9)     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            r3[r7] = r4     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NoSuchMethodException -> 0x0036, IllegalAccessException -> 0x0034, InvocationTargetException -> 0x0032, Exception | OutOfMemoryError -> 0x0057 }
            goto L_0x003b
        L_0x0032:
            r1 = move-exception
            goto L_0x0037
        L_0x0034:
            r1 = move-exception
            goto L_0x0037
        L_0x0036:
            r1 = move-exception
        L_0x0037:
            r1.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0057
            int r2 = r1.length()     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
            if (r2 != 0) goto L_0x004b
            android.telephony.TelephonyManager r9 = r8.t(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
            java.lang.String r1 = r9.getSimOperator()     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
        L_0x004b:
            int r9 = r1.length()     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
            if (r9 <= 0) goto L_0x0057
            r9 = 3
            java.lang.String r9 = r1.substring(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0057 }
            return r9
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.TrackingHelper.s(android.content.Context):java.lang.String");
    }

    public TelephonyManager t(Context context) {
        try {
            TelephonyManager telephonyManager = this.k;
            if (telephonyManager != null) {
                return telephonyManager;
            }
            TelephonyManager i2 = i(context);
            if (i2 == null || Build.VERSION.SDK_INT < 24) {
                return null;
            }
            TelephonyManager h2 = h(context);
            String simOperator = h2.getSimOperator();
            String simOperatorName = h2.getSimOperatorName();
            if (i2.getSimOperatorName().isEmpty() || (i2.getSimOperator().equals(simOperator) && i2.getSimOperatorName().equals(simOperatorName))) {
                int i3 = -1;
                while (i3 < 100) {
                    TelephonyManager createForSubscriptionId = i2.createForSubscriptionId(i3);
                    if (createForSubscriptionId.getSimOperatorName().isEmpty() || createForSubscriptionId.getSimOperator().equals(simOperator)) {
                        i3++;
                    } else {
                        createForSubscriptionId.getSimOperator();
                        this.k = createForSubscriptionId;
                        return createForSubscriptionId;
                    }
                }
                this.k = i2;
                return i2;
            }
            i2.getSimOperator();
            this.k = i2;
            return i2;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public String u(Context context) {
        String simOperator;
        try {
            TelephonyManager h2 = h(context);
            if (!(h2 == null || (simOperator = h2.getSimOperator()) == null || simOperator.length() <= 0)) {
                return simOperator.substring(0, 3);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        return "";
    }

    public String v(Context context) {
        String simOperator;
        try {
            TelephonyManager h2 = h(context);
            if (!(h2 == null || (simOperator = h2.getSimOperator()) == null || simOperator.length() <= 0)) {
                return simOperator.substring(3);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        return "";
    }

    public String w(Context context) {
        TelephonyManager i2 = i(context);
        if (i2 == null || Build.VERSION.SDK_INT < 29) {
            return null;
        }
        return i2.getTypeAllocationCode();
    }

    public ConnectionType x(Context context) {
        try {
            if (TelephonyHelper.b().e != null && Utils.a(TelephonyHelper.b().e.toString())) {
                return (TelephonyHelper.b().e.h != 20 || (!TelephonyHelper.b().c.toString().contains("mNrFrequencyRange=4") && !TelephonyHelper.b().c.toString().contains("mNrFrequencyRange = 4"))) ? TelephonyHelper.b().e.h == 20 ? ConnectionType.NR_SA : (Build.VERSION.SDK_INT < 30 || TelephonyHelper.b().d == null || TelephonyHelper.b().d.getOverrideNetworkType() != 4) ? ConnectionType.NR_NSA : ConnectionType.NR_NSA_MMWAVE : ConnectionType.NR_SA_MMWAVE;
            }
            TelephonyManager h2 = h(context);
            if (h2 == null) {
                return ConnectionType.UNKNOWN;
            }
            if (Build.VERSION.SDK_INT < 30 || ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                int networkType = h2.getNetworkType();
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return ConnectionType.TWO_G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return ConnectionType.THREE_G;
                    case 13:
                    case 18:
                        return ConnectionType.FOUR_G;
                    case 19:
                        return ConnectionType.FOUR_G_CA;
                    case 20:
                        return ConnectionType.FIVE_G;
                    default:
                        ConnectionType a2 = a(networkType);
                        ConnectionType connectionType = ConnectionType.CELLULAR;
                        if (a2 == connectionType && TelephonyHelper.b().e != null) {
                            a2 = a(TelephonyHelper.b().e.h);
                        }
                        if (a2 == null || a2 == connectionType) {
                            a2 = b(context);
                        }
                        return a2 == null ? connectionType : a2;
                }
            } else {
                ConnectionType a3 = TelephonyHelper.b().e != null ? a(TelephonyHelper.b().e.h) : null;
                if (TelephonyHelper.b().c != null) {
                    a3 = a(TelephonyHelper.b().c);
                }
                if (a3 == null || a3 == ConnectionType.CELLULAR) {
                    a3 = b(context);
                }
                return a3 == null ? ConnectionType.CELLULAR : a3;
            }
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public void y(Context context) {
        FusedLocationProviderClient fusedLocationProviderClient;
        try {
            if (this.c == null) {
                this.c = LocationServices.getFusedLocationProviderClient(context);
                this.d = LocationServices.getSettingsClient(context);
                if ((ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1 || ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1) && (fusedLocationProviderClient = this.c) != null) {
                    fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new TrackingHelper$$ExternalSyntheticLambda0(this));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public boolean z(Context context) {
        TelephonyManager h2;
        int phoneCount;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 24 || (h2 = h(context)) == null || (phoneCount = h2.getPhoneCount()) < 2) {
                return false;
            }
            if (i2 < 26) {
                return true;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < phoneCount; i4++) {
                if (h2.getSimState(i4) != 1) {
                    i3++;
                }
            }
            return i3 > 1;
        } catch (Exception | OutOfMemoryError unused) {
        }
        return false;
    }
}
