package com.cellrebel.sdk.workers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.ApiClient;
import com.cellrebel.sdk.networking.UrlProvider;
import com.cellrebel.sdk.networking.beans.request.AuthRequestModel;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.ForegroundObserver;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.Storage;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackingManager {
    private static Settings a = null;
    private static boolean b = true;
    private static boolean c = false;
    static MetaHelp d = null;
    static ForegroundObserver e = null;
    private static Context f = null;
    private static boolean g = false;

    public interface OnCompleteListener {
        void onCompleted(boolean z);
    }

    class a extends TimerTask {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void run() {
            TrackingManager.startTracking(this.a, (OnCompleteListener) null);
        }
    }

    class b implements Runnable {
        final /* synthetic */ OnCompleteListener a;

        b(OnCompleteListener onCompleteListener) {
            this.a = onCompleteListener;
        }

        public void run() {
            TrackingManager.b(this.a, true);
        }
    }

    class c implements Runnable {
        final /* synthetic */ OnCompleteListener a;

        c(OnCompleteListener onCompleteListener) {
            this.a = onCompleteListener;
        }

        public void run() {
            TrackingManager.b(this.a, false);
        }
    }

    class d implements Runnable {
        final /* synthetic */ Context a;

        d(Context context) {
            this.a = context;
        }

        public void run() {
            new DataUsageMetricsWorker().a(this.a);
        }
    }

    class e implements Runnable {
        final /* synthetic */ Context a;

        e(Context context) {
            this.a = context;
        }

        public void run() {
            try {
                if (TrackingManager.e == null) {
                    TrackingManager.e = new ForegroundObserver(this.a);
                }
                ProcessLifecycleOwner.get().getLifecycle().addObserver(TrackingManager.e);
            } catch (Exception e) {
                Log.d("CellRebelSDK", "TrackingManager ForegroundObserver init failed, exception=" + e);
            }
        }
    }

    class f implements Callback<Void> {
        final /* synthetic */ Context a;
        final /* synthetic */ OnCompleteListener b;

        f(Context context, OnCompleteListener onCompleteListener) {
            this.a = context;
            this.b = onCompleteListener;
        }

        public void onFailure(Call<Void> call, Throwable th) {
            OnCompleteListener onCompleteListener = this.b;
            if (onCompleteListener != null) {
                onCompleteListener.onCompleted(false);
            }
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            boolean z;
            OnCompleteListener onCompleteListener;
            if (response.isSuccessful()) {
                z = true;
                try {
                    PreferencesManager.m().a();
                    TrackingManager.stopTracking(this.a);
                    SettingsManager.b().a();
                    Storage.J().a();
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
                    if (defaultSharedPreferences.contains("mobileClientId")) {
                        defaultSharedPreferences.edit().remove("mobileClientId").apply();
                    }
                    if (DatabaseClient.a() != null) {
                        DatabaseClient.b();
                    }
                    OnCompleteListener onCompleteListener2 = this.b;
                    if (onCompleteListener2 != null) {
                        onCompleteListener2.onCompleted(true);
                    }
                } catch (Exception | OutOfMemoryError unused) {
                    onCompleteListener = this.b;
                    if (onCompleteListener == null) {
                    }
                }
            } else {
                onCompleteListener = this.b;
                if (onCompleteListener != null) {
                    z = false;
                    onCompleteListener.onCompleted(z);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String a(Context context, String str) {
        try {
            if (DatabaseClient.a(context) == null) {
                Log.d("CellRebelSDK", "Initialization failed, DB init failed");
                return null;
            }
            PreferencesManager m = PreferencesManager.m();
            if (m != null) {
                if (m.v() != null) {
                    PreferencesManager.m().a(UUID.randomUUID().toString(), str, context);
                    Log.d("CellRebelSDK", String.format("Initialized, mobileClientId: %s", new Object[]{PreferencesManager.m().a(context)}));
                    return null;
                }
            }
            Log.d("CellRebelSDK", "Initialization failed, preferences not available");
            return null;
        } catch (Exception | OutOfMemoryError e2) {
            Log.d("CellRebelSDK", String.format("Initialization failed, exception: %s", new Object[]{e2.toString()}));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String a(AuthRequestModel authRequestModel, OnCompleteListener onCompleteListener, Context context) {
        try {
            ResponseBody body = ApiClient.a().b(authRequestModel, UrlProvider.b(SettingsManager.b().c())).execute().body();
            String string = body != null ? body.string() : null;
            if (string != null) {
                Log.d("CellRebelSDK", "Authorization successful");
                PreferencesManager.m().a(string);
            }
            if (onCompleteListener != null) {
                new Handler(context.getMainLooper()).post(new b(onCompleteListener));
            }
            if (!g) {
                a(context);
            }
        } catch (Exception | OutOfMemoryError e2) {
            Log.d("CellRebelSDK", String.format("Authorization failed, exception: %s", new Object[]{e2.toString()}));
            if (onCompleteListener != null) {
                new Handler(context.getMainLooper()).post(new c(onCompleteListener));
            }
            if (!g) {
                a(context);
            }
        }
        return null;
    }

    private static void a(Context context) {
        ThreadPoolProvider.a().a(new TrackingManager$$ExternalSyntheticLambda6(context));
    }

    private static void a(Context context, OnCompleteListener onCompleteListener) {
        try {
            if (DatabaseClient.a() == null) {
                Log.d("CellRebelSDK", "Authorization failed, DB not available");
                return;
            }
            PreferencesManager m = PreferencesManager.m();
            if (m.w() != null) {
                ThreadPoolProvider.a().a(new TrackingManager$$ExternalSyntheticLambda3());
                if (onCompleteListener != null) {
                    b(onCompleteListener, true);
                }
                Log.d("CellRebelSDK", "Authorization successful, already authorized");
                if (!g) {
                    a(context);
                    return;
                }
                return;
            }
            ThreadPoolProvider.a().a(new TrackingManager$$ExternalSyntheticLambda4());
            AuthRequestModel authRequestModel = new AuthRequestModel();
            authRequestModel.mobileClientId = m.a(context);
            authRequestModel.clientKey = m.f();
            authRequestModel.os = "Android";
            authRequestModel.deviceBrand = Build.MANUFACTURER;
            authRequestModel.deviceModel = Build.MODEL;
            authRequestModel.deviceVersion = Build.BRAND;
            authRequestModel.networkMcc = TrackingHelper.a().l(context);
            authRequestModel.appId = getContext().getApplicationContext().getPackageName();
            authRequestModel.tac = TrackingHelper.a().w(getContext());
            ThreadPoolProvider.a().a(new TrackingManager$$ExternalSyntheticLambda5(authRequestModel, onCompleteListener, context));
        } catch (Exception | OutOfMemoryError e2) {
            Log.d("CellRebelSDK", String.format("Authorization failed, exception: %s", new Object[]{e2.toString()}));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, ScheduledExecutorService scheduledExecutorService, Integer[] numArr) {
        if (DatabaseClient.a() != null) {
            Log.d("CellRebelSDK", "DB ready");
            new Timer().schedule(new a(context), 1000);
            scheduledExecutorService.shutdownNow();
        }
        Integer valueOf = Integer.valueOf(numArr[0].intValue() + 1);
        numArr[0] = valueOf;
        if (valueOf.intValue() > 25) {
            Log.d("CellRebelSDK", "Waiting for DB");
            scheduledExecutorService.shutdownNow();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fb A[Catch:{ Exception | OutOfMemoryError -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013c A[Catch:{ Exception | OutOfMemoryError -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.cellrebel.sdk.networking.beans.response.Settings r22, android.content.Context r23) {
        /*
            r0 = r23
            com.cellrebel.sdk.database.SDKRoomDatabase r1 = com.cellrebel.sdk.database.DatabaseClient.a()
            java.lang.String r2 = "CellRebelSDK"
            if (r1 != 0) goto L_0x0010
            java.lang.String r0 = "Measurements disabled, DB unavailable"
            android.util.Log.d(r2, r0)
            return
        L_0x0010:
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            r3 = 0
            r1.b((boolean) r3)
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            if (r1 == 0) goto L_0x015f
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            com.cellrebel.sdk.database.Preferences r1 = r1.v()
            if (r1 != 0) goto L_0x002a
            goto L_0x015f
        L_0x002a:
            com.cellrebel.sdk.utils.FileLoggingTree r1 = com.cellrebel.sdk.workers.MetaHelp.l
            if (r1 != 0) goto L_0x0035
            com.cellrebel.sdk.utils.FileLoggingTree r1 = new com.cellrebel.sdk.utils.FileLoggingTree
            r1.<init>(r0)
            com.cellrebel.sdk.workers.MetaHelp.l = r1
        L_0x0035:
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            long r5 = r4.t()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            long r7 = r4.u()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            long r9 = r4.b()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            com.cellrebel.sdk.utils.TrackingHelper r11 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            com.cellrebel.sdk.database.ConnectionType r11 = r11.a((android.content.Context) r0)     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            com.cellrebel.sdk.database.ConnectionType r12 = com.cellrebel.sdk.database.ConnectionType.WIFI     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            if (r11 != r12) goto L_0x0053
            r11 = 1
            goto L_0x0054
        L_0x0053:
            r11 = 0
        L_0x0054:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            java.lang.Integer r14 = r22.foregroundPeriodicity()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            int r14 = r14.intValue()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            long r14 = (long) r14     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            java.lang.Integer r16 = r22.wifiForegroundTimer()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            int r1 = r16.intValue()     // Catch:{ OutOfMemoryError -> 0x0146, Exception -> 0x0144 }
            r17 = r4
            long r3 = (long) r1
            r18 = 1000(0x3e8, double:4.94E-321)
            r20 = r2
            r1 = 60
            if (r11 == 0) goto L_0x0081
            long r7 = r12 - r7
            long r3 = r3 * r1
            long r3 = r3 * r18
            int r21 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r21 >= 0) goto L_0x0081
        L_0x007e:
            r3 = r17
            goto L_0x00d7
        L_0x0081:
            if (r11 != 0) goto L_0x008e
            long r3 = r12 - r5
            long r14 = r14 * r1
            long r14 = r14 * r18
            int r5 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r5 >= 0) goto L_0x008e
            goto L_0x007e
        L_0x008e:
            long r3 = r12 - r9
            r5 = 300000(0x493e0, double:1.482197E-318)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
            goto L_0x007e
        L_0x0098:
            com.cellrebel.sdk.workers.MetaHelp r3 = d     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            if (r3 != 0) goto L_0x00a3
            com.cellrebel.sdk.workers.MetaHelp r3 = new com.cellrebel.sdk.workers.MetaHelp     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r3.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            d = r3     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
        L_0x00a3:
            com.cellrebel.sdk.workers.MetaHelp r3 = d     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            boolean r3 = r3.c     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            if (r3 != 0) goto L_0x007e
            com.cellrebel.sdk.utils.ThreadPoolProvider r3 = com.cellrebel.sdk.utils.ThreadPoolProvider.a()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            com.cellrebel.sdk.workers.TrackingManager$$ExternalSyntheticLambda0 r4 = new com.cellrebel.sdk.workers.TrackingManager$$ExternalSyntheticLambda0     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r4.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r3.a(r4)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            com.cellrebel.sdk.workers.MetaHelp r3 = d     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r4 = 0
            r3.b = r4     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            com.cellrebel.sdk.utils.ThreadPoolProvider r3 = com.cellrebel.sdk.utils.ThreadPoolProvider.a()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            com.cellrebel.sdk.workers.TrackingManager$$ExternalSyntheticLambda1 r4 = new com.cellrebel.sdk.workers.TrackingManager$$ExternalSyntheticLambda1     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r4.<init>()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r3.b(r4)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            boolean r3 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            if (r3 == 0) goto L_0x007e
            r3 = r17
            if (r11 == 0) goto L_0x00d4
            r3.t(r12)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            goto L_0x00d7
        L_0x00d4:
            r3.s(r12)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
        L_0x00d7:
            java.lang.Integer r4 = r22.dataUsageForegroundPeriodicity()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            int r4 = r4.intValue()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            long r4 = (long) r4     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            java.lang.Integer r6 = r22.wifiDataUsageForegroundPeriodicity()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            int r6 = r6.intValue()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            long r6 = (long) r6     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            long r8 = r3.m()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            long r14 = r3.n()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            java.lang.Boolean r10 = r22.dataUsage()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            boolean r10 = r10.booleanValue()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            if (r10 == 0) goto L_0x0132
            if (r11 == 0) goto L_0x0108
            long r14 = r12 - r14
            long r6 = r6 * r1
            long r6 = r6 * r18
            int r10 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0108
            goto L_0x0132
        L_0x0108:
            if (r11 != 0) goto L_0x0115
            long r6 = r12 - r8
            long r4 = r4 * r1
            long r4 = r4 * r18
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0115
            goto L_0x0132
        L_0x0115:
            java.util.concurrent.ScheduledExecutorService r4 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            com.cellrebel.sdk.workers.TrackingManager$d r5 = new com.cellrebel.sdk.workers.TrackingManager$d     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r5.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            r4.schedule(r5, r1, r0)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            boolean r0 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            if (r0 == 0) goto L_0x0132
            if (r11 == 0) goto L_0x012f
            r3.m(r12)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            goto L_0x0132
        L_0x012f:
            r3.l(r12)     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
        L_0x0132:
            com.cellrebel.sdk.utils.PreferencesManager r0 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            boolean r0 = r0.n()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            if (r0 == 0) goto L_0x015e
            d()     // Catch:{ OutOfMemoryError -> 0x0142, Exception -> 0x0140 }
            goto L_0x015e
        L_0x0140:
            r0 = move-exception
            goto L_0x0149
        L_0x0142:
            r0 = move-exception
            goto L_0x0149
        L_0x0144:
            r0 = move-exception
            goto L_0x0147
        L_0x0146:
            r0 = move-exception
        L_0x0147:
            r20 = r2
        L_0x0149:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r0 = r0.toString()
            r2 = 0
            r1[r2] = r0
            java.lang.String r0 = "Measurements not started, exception: %s"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r1 = r20
            android.util.Log.d(r1, r0)
        L_0x015e:
            return
        L_0x015f:
            r1 = r2
            java.lang.String r0 = "Measurements disabled, preferences unavailable"
            android.util.Log.d(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.TrackingManager.a(com.cellrebel.sdk.networking.beans.response.Settings, android.content.Context):void");
    }

    public static Context applicationContext() {
        return f;
    }

    public static void applicationContext(Context context) {
        f = context;
    }

    public static void authorizeWithoutTracking(Context context, OnCompleteListener onCompleteListener) {
        g = true;
        startTracking(context, onCompleteListener);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013f, code lost:
        if (com.cellrebel.sdk.utils.Utils.a(r2.wifiGameForegroundPeriodicity().intValue(), com.cellrebel.sdk.utils.Storage.J().s()) != false) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0210, code lost:
        if (com.cellrebel.sdk.utils.Utils.a(r2.foregroundGamePeriodicity().intValue(), com.cellrebel.sdk.utils.Storage.J().r()) != false) goto L_0x0212;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.String b(android.content.Context r15) {
        /*
            java.lang.String r0 = "https://metricreceiver.cellrebel.com/"
            java.lang.String r1 = "Settings update failed"
            java.lang.String r2 = "Settings refresh"
            java.lang.String r3 = "CellRebelSDK"
            android.util.Log.d(r3, r2)
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0225
            com.cellrebel.sdk.utils.TrackingHelper r7 = com.cellrebel.sdk.utils.TrackingHelper.a()
            com.cellrebel.sdk.database.ConnectionType r7 = r7.a((android.content.Context) r15)
            com.cellrebel.sdk.database.ConnectionType r8 = com.cellrebel.sdk.database.ConnectionType.WIFI
            if (r7 != r8) goto L_0x0026
            r7 = 1
            goto L_0x0027
        L_0x0026:
            r7 = 0
        L_0x0027:
            if (r7 != 0) goto L_0x004d
            long r8 = java.lang.System.currentTimeMillis()
            com.cellrebel.sdk.utils.Storage r10 = com.cellrebel.sdk.utils.Storage.J()
            long r10 = r10.t()
            long r8 = r8 - r10
            java.lang.Integer r10 = r2.foregroundPeriodicity()
            int r10 = r10.intValue()
            int r10 = r10 * 60
            int r10 = r10 * 1000
            long r10 = (long) r10
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x004d
            java.lang.String r15 = "Measurements skipped, foreground Cellular periodicity"
        L_0x0049:
            android.util.Log.d(r3, r15)
            return r4
        L_0x004d:
            if (r7 == 0) goto L_0x0070
            long r8 = java.lang.System.currentTimeMillis()
            com.cellrebel.sdk.utils.Storage r10 = com.cellrebel.sdk.utils.Storage.J()
            long r10 = r10.u()
            long r8 = r8 - r10
            java.lang.Integer r10 = r2.wifiForegroundTimer()
            int r10 = r10.intValue()
            int r10 = r10 * 60
            int r10 = r10 * 1000
            long r10 = (long) r10
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x0070
            java.lang.String r15 = "Measurements skipped, foreground WiFi periodicity"
            goto L_0x0049
        L_0x0070:
            if (r7 == 0) goto L_0x0143
            java.lang.Boolean r7 = r2.isPageLoadMeasurement()
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0094
            java.lang.Integer r7 = r2.wifiPageLoadForegroundPeriodicity()
            int r7 = r7.intValue()
            com.cellrebel.sdk.utils.Storage r8 = com.cellrebel.sdk.utils.Storage.J()
            long r8 = r8.y()
            boolean r7 = com.cellrebel.sdk.utils.Utils.a((int) r7, (long) r8)
            if (r7 == 0) goto L_0x0094
            r7 = 1
            goto L_0x0095
        L_0x0094:
            r7 = 0
        L_0x0095:
            java.lang.Boolean r8 = r2.fileMeasurement()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00b7
            java.lang.Integer r8 = r2.wifiFileTransferForegroundPeriodicity()
            int r8 = r8.intValue()
            com.cellrebel.sdk.utils.Storage r9 = com.cellrebel.sdk.utils.Storage.J()
            long r9 = r9.q()
            boolean r8 = com.cellrebel.sdk.utils.Utils.a((int) r8, (long) r9)
            if (r8 == 0) goto L_0x00b7
            r8 = 1
            goto L_0x00b8
        L_0x00b7:
            r8 = 0
        L_0x00b8:
            java.lang.Boolean r9 = r2.cdnFileMeasurements()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00da
            java.lang.Integer r9 = r2.wifiCdnFileDownloadForegroundPeriodicity()
            int r9 = r9.intValue()
            com.cellrebel.sdk.utils.Storage r10 = com.cellrebel.sdk.utils.Storage.J()
            long r10 = r10.j()
            boolean r9 = com.cellrebel.sdk.utils.Utils.a((int) r9, (long) r10)
            if (r9 == 0) goto L_0x00da
            r9 = 1
            goto L_0x00db
        L_0x00da:
            r9 = 0
        L_0x00db:
            java.lang.Boolean r10 = r2.videoActiveMeasurement()
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00fd
            java.lang.Integer r10 = r2.wifiVideoForegroundPeriodicity()
            int r10 = r10.intValue()
            com.cellrebel.sdk.utils.Storage r11 = com.cellrebel.sdk.utils.Storage.J()
            long r11 = r11.H()
            boolean r10 = com.cellrebel.sdk.utils.Utils.a((int) r10, (long) r11)
            if (r10 == 0) goto L_0x00fd
            r10 = 1
            goto L_0x00fe
        L_0x00fd:
            r10 = 0
        L_0x00fe:
            java.lang.Boolean r11 = r2.coverageMeasurement()
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0120
            java.lang.Integer r11 = r2.wifiCoverageForegroundPeriodicity()
            int r11 = r11.intValue()
            com.cellrebel.sdk.utils.Storage r12 = com.cellrebel.sdk.utils.Storage.J()
            long r12 = r12.l()
            boolean r11 = com.cellrebel.sdk.utils.Utils.a((int) r11, (long) r12)
            if (r11 == 0) goto L_0x0120
            r11 = 1
            goto L_0x0121
        L_0x0120:
            r11 = 0
        L_0x0121:
            java.lang.Boolean r12 = r2.foregroundGameMeasurement()
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0214
            java.lang.Integer r12 = r2.wifiGameForegroundPeriodicity()
            int r12 = r12.intValue()
            com.cellrebel.sdk.utils.Storage r13 = com.cellrebel.sdk.utils.Storage.J()
            long r13 = r13.s()
            boolean r12 = com.cellrebel.sdk.utils.Utils.a((int) r12, (long) r13)
            if (r12 == 0) goto L_0x0214
            goto L_0x0212
        L_0x0143:
            java.lang.Boolean r7 = r2.isPageLoadMeasurement()
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0165
            java.lang.Integer r7 = r2.pageLoadForegroundPeriodicityMeasurement()
            int r7 = r7.intValue()
            com.cellrebel.sdk.utils.Storage r8 = com.cellrebel.sdk.utils.Storage.J()
            long r8 = r8.x()
            boolean r7 = com.cellrebel.sdk.utils.Utils.a((int) r7, (long) r8)
            if (r7 == 0) goto L_0x0165
            r7 = 1
            goto L_0x0166
        L_0x0165:
            r7 = 0
        L_0x0166:
            java.lang.Boolean r8 = r2.fileMeasurement()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0188
            java.lang.Integer r8 = r2.fileTransferForegroundPeriodicityTimer()
            int r8 = r8.intValue()
            com.cellrebel.sdk.utils.Storage r9 = com.cellrebel.sdk.utils.Storage.J()
            long r9 = r9.p()
            boolean r8 = com.cellrebel.sdk.utils.Utils.a((int) r8, (long) r9)
            if (r8 == 0) goto L_0x0188
            r8 = 1
            goto L_0x0189
        L_0x0188:
            r8 = 0
        L_0x0189:
            java.lang.Boolean r9 = r2.cdnFileMeasurements()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x01ab
            java.lang.Integer r9 = r2.cdnFileDownloadForegroundPeriodicity()
            int r9 = r9.intValue()
            com.cellrebel.sdk.utils.Storage r10 = com.cellrebel.sdk.utils.Storage.J()
            long r10 = r10.i()
            boolean r9 = com.cellrebel.sdk.utils.Utils.a((int) r9, (long) r10)
            if (r9 == 0) goto L_0x01ab
            r9 = 1
            goto L_0x01ac
        L_0x01ab:
            r9 = 0
        L_0x01ac:
            java.lang.Boolean r10 = r2.videoActiveMeasurement()
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x01ce
            java.lang.Integer r10 = r2.videoForegroundPeriodicityMeasurement()
            int r10 = r10.intValue()
            com.cellrebel.sdk.utils.Storage r11 = com.cellrebel.sdk.utils.Storage.J()
            long r11 = r11.G()
            boolean r10 = com.cellrebel.sdk.utils.Utils.a((int) r10, (long) r11)
            if (r10 == 0) goto L_0x01ce
            r10 = 1
            goto L_0x01cf
        L_0x01ce:
            r10 = 0
        L_0x01cf:
            java.lang.Boolean r11 = r2.coverageMeasurement()
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x01f1
            java.lang.Integer r11 = r2.coverageForegroundPeriodicity()
            int r11 = r11.intValue()
            com.cellrebel.sdk.utils.Storage r12 = com.cellrebel.sdk.utils.Storage.J()
            long r12 = r12.k()
            boolean r11 = com.cellrebel.sdk.utils.Utils.a((int) r11, (long) r12)
            if (r11 == 0) goto L_0x01f1
            r11 = 1
            goto L_0x01f2
        L_0x01f1:
            r11 = 0
        L_0x01f2:
            java.lang.Boolean r12 = r2.foregroundGameMeasurement()
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0214
            java.lang.Integer r12 = r2.foregroundGamePeriodicity()
            int r12 = r12.intValue()
            com.cellrebel.sdk.utils.Storage r13 = com.cellrebel.sdk.utils.Storage.J()
            long r13 = r13.r()
            boolean r12 = com.cellrebel.sdk.utils.Utils.a((int) r12, (long) r13)
            if (r12 == 0) goto L_0x0214
        L_0x0212:
            r12 = 1
            goto L_0x0215
        L_0x0214:
            r12 = 0
        L_0x0215:
            if (r7 != 0) goto L_0x0225
            if (r8 != 0) goto L_0x0225
            if (r9 != 0) goto L_0x0225
            if (r10 != 0) goto L_0x0225
            if (r11 != 0) goto L_0x0225
            if (r12 != 0) goto L_0x0225
            java.lang.String r15 = "Measurements skipped, all individual foreground limits"
            goto L_0x0049
        L_0x0225:
            com.cellrebel.sdk.utils.Storage r7 = com.cellrebel.sdk.utils.Storage.J()
            long r7 = r7.N()
            com.cellrebel.sdk.networking.beans.response.Settings r9 = a
            if (r9 != 0) goto L_0x02df
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0247
            long r9 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r9
            long r7 = java.lang.Math.abs(r7)
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x02df
        L_0x0247:
            com.cellrebel.sdk.networking.ApiService r7 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x02cd }
            java.lang.String r8 = com.cellrebel.sdk.networking.UrlProvider.b(r2)     // Catch:{ IOException -> 0x02cd }
            retrofit2.Call r7 = r7.d(r8)     // Catch:{ IOException -> 0x02cd }
            retrofit2.Response r7 = r7.execute()     // Catch:{ IOException -> 0x02cd }
            boolean r8 = r7.isSuccessful()     // Catch:{ IOException -> 0x02cd }
            if (r8 == 0) goto L_0x027c
            java.lang.Object r8 = r7.body()     // Catch:{ IOException -> 0x02cd }
            if (r8 == 0) goto L_0x027c
            com.cellrebel.sdk.utils.SettingsManager r0 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x02cd }
            java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x02cd }
            com.cellrebel.sdk.networking.beans.response.Settings r1 = (com.cellrebel.sdk.networking.beans.response.Settings) r1     // Catch:{ IOException -> 0x02cd }
            r0.a(r1)     // Catch:{ IOException -> 0x02cd }
            com.cellrebel.sdk.utils.Storage r0 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ IOException -> 0x02cd }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x02cd }
            r0.L(r1)     // Catch:{ IOException -> 0x02cd }
            goto L_0x02c9
        L_0x027c:
            java.lang.String r2 = com.cellrebel.sdk.networking.UrlProvider.b(r2)     // Catch:{ IOException -> 0x02cd }
            boolean r2 = r2.equals(r0)     // Catch:{ IOException -> 0x02cd }
            if (r2 != 0) goto L_0x02ba
            com.cellrebel.sdk.networking.ApiService r1 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x02cd }
            retrofit2.Call r0 = r1.d(r0)     // Catch:{ IOException -> 0x02cd }
            retrofit2.Response r0 = r0.execute()     // Catch:{ IOException -> 0x02cd }
            boolean r1 = r0.isSuccessful()     // Catch:{ IOException -> 0x02cd }
            if (r1 == 0) goto L_0x02b6
            java.lang.Object r1 = r0.body()     // Catch:{ IOException -> 0x02cd }
            if (r1 == 0) goto L_0x02b6
            com.cellrebel.sdk.utils.SettingsManager r1 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x02cd }
            java.lang.Object r2 = r0.body()     // Catch:{ IOException -> 0x02cd }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = (com.cellrebel.sdk.networking.beans.response.Settings) r2     // Catch:{ IOException -> 0x02cd }
            r1.a(r2)     // Catch:{ IOException -> 0x02cd }
            com.cellrebel.sdk.utils.Storage r1 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ IOException -> 0x02cd }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x02cd }
            r1.L(r7)     // Catch:{ IOException -> 0x02cd }
        L_0x02b6:
            java.lang.String r1 = "Settings updated"
            r7 = r0
            goto L_0x02c6
        L_0x02ba:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02cd }
            r0.<init>(r1)     // Catch:{ IOException -> 0x02cd }
            r0.append(r7)     // Catch:{ IOException -> 0x02cd }
            java.lang.String r1 = r0.toString()     // Catch:{ IOException -> 0x02cd }
        L_0x02c6:
            android.util.Log.d(r3, r1)     // Catch:{ IOException -> 0x02cd }
        L_0x02c9:
            r7.toString()     // Catch:{ IOException -> 0x02cd }
            goto L_0x02df
        L_0x02cd:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r0 = r0.toString()
            r1[r6] = r0
            java.lang.String r0 = "Settings refresh failed, exception: %s"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            android.util.Log.d(r3, r0)
        L_0x02df:
            com.cellrebel.sdk.utils.SettingsManager r0 = com.cellrebel.sdk.utils.SettingsManager.b()
            com.cellrebel.sdk.networking.beans.response.Settings r0 = r0.c()
            a = r0
            if (r0 == 0) goto L_0x0303
            com.cellrebel.sdk.utils.PreferencesManager r0 = com.cellrebel.sdk.utils.PreferencesManager.m()
            com.cellrebel.sdk.networking.beans.response.Settings r1 = a
            java.lang.Integer r1 = r1.fileTransferTimeoutTimer()
            int r1 = r1.intValue()
            long r1 = (long) r1
            r0.c(r1)
            com.cellrebel.sdk.networking.beans.response.Settings r0 = a
            a((com.cellrebel.sdk.networking.beans.response.Settings) r0, (android.content.Context) r15)
            goto L_0x0308
        L_0x0303:
            java.lang.String r15 = "Settings not available"
            android.util.Log.d(r3, r15)
        L_0x0308:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.TrackingManager.b(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String b(Context context, OnCompleteListener onCompleteListener) {
        try {
            if (DatabaseClient.a() == null) {
                Log.d("CellRebelSDK", "DB not ready");
                ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                newSingleThreadScheduledExecutor.scheduleAtFixedRate(new TrackingManager$$ExternalSyntheticLambda8(context, newSingleThreadScheduledExecutor, new Integer[]{0}), 200, 200, TimeUnit.MILLISECONDS);
                return null;
            }
            c(context, onCompleteListener);
            return null;
        } catch (Exception | OutOfMemoryError e2) {
            Log.d("CellRebelSDK", String.format("Start tracking failed, exception: %s", new Object[]{e2.toString()}));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void b(OnCompleteListener onCompleteListener, boolean z) {
        if (onCompleteListener != null) {
            onCompleteListener.onCompleted(z);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String c(Context context) {
        Looper.prepare();
        try {
            TrackingHelper.a().A(context);
        } catch (Exception | OutOfMemoryError unused) {
        }
        Looper.loop();
        return null;
    }

    private static void c(Context context, OnCompleteListener onCompleteListener) {
        String str;
        if (DatabaseClient.a() == null) {
            str = "Start tracking failed, DB not available";
        } else {
            PreferencesManager.m().b(false);
            if (PreferencesManager.m() == null || PreferencesManager.m().v() == null) {
                str = "Start tracking failed, preferences not available";
            } else {
                b = true;
                c = false;
                try {
                    PreferencesManager.m().b(false);
                    if (PreferencesManager.m() == null) {
                        return;
                    }
                    if (PreferencesManager.m().v() != null) {
                        b = true;
                        c = false;
                        a(context, onCompleteListener);
                        return;
                    }
                    return;
                } catch (Exception | OutOfMemoryError e2) {
                    Log.d("CellRebelSDK", String.format("Start tracking failed, exception: %s", new Object[]{e2.toString()}));
                    return;
                }
            }
        }
        Log.d("CellRebelSDK", str);
    }

    public static void clearUserData(Context context, OnCompleteListener onCompleteListener) {
        ApiClient.a().b(UrlProvider.b(SettingsManager.b().c())).enqueue(new f(context, onCompleteListener));
    }

    private static void d() {
        Settings settings = a;
        if (settings != null) {
            if (settings.pageLoadBackgroundMeasurement().booleanValue() || a.fileTransferBackgroundMeasurement().booleanValue() || a.cdnBackgroundMeasurement().booleanValue() || a.videoBackgroundMeasurement().booleanValue() || a.backgroundCoverageMeasurement().booleanValue() || a.backgroundGameMeasurement().booleanValue()) {
                int i = Integer.MAX_VALUE;
                int intValue = a.pageLoadBackgroundMeasurement().booleanValue() ? a.pageLoadPeriodicityMeasurement().intValue() : Integer.MAX_VALUE;
                int intValue2 = a.fileTransferBackgroundMeasurement().booleanValue() ? a.fileTransferPeriodicityTimer().intValue() : Integer.MAX_VALUE;
                int intValue3 = a.cdnBackgroundMeasurement().booleanValue() ? a.cdnFileDownloadPeriodicity().intValue() : Integer.MAX_VALUE;
                int intValue4 = a.videoBackgroundMeasurement().booleanValue() ? a.videoBackgroundPeriodicityMeasurement().intValue() : Integer.MAX_VALUE;
                int intValue5 = a.backgroundCoverageMeasurement().booleanValue() ? a.coveragePeriodicity().intValue() : Integer.MAX_VALUE;
                if (a.backgroundGameMeasurement().booleanValue()) {
                    i = a.backgroundGamePeriodicity().intValue();
                }
                int min = Math.min(Math.min(Math.min(Math.min(Math.min(intValue, intValue2), intValue3), intValue4), intValue5), i);
                if (min == 0) {
                    min = 1440;
                }
                Data build = new Data.Builder().putLong(CampaignEx.JSON_KEY_TIMESTAMP, new Date().getTime()).build();
                TimeUnit timeUnit = TimeUnit.MINUTES;
                WorkManager.getInstance(f).enqueueUniquePeriodicWork("CR_PERIODIC_WORKER", ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(MetaWorker.class, (long) min, timeUnit, 5, timeUnit).addTag("CR_MEASUREMENT_WORKER")).setInputData(build)).setConstraints(Constraints.NONE)).build());
            }
        }
    }

    public static Context getContext() {
        return f;
    }

    public static String getVersion() {
        return Utils.d(f);
    }

    public static void init(Context context) {
        init(context, (String) null);
    }

    public static void init(Context context, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = String.valueOf(context != null);
        objArr[1] = String.valueOf(str != null && !str.isEmpty());
        Log.d("CellRebelSDK", String.format("Initialization context: %s, clientKey: %s", objArr));
        try {
            new Handler(context.getMainLooper()).post(new e(context));
            f = context.getApplicationContext();
            ThreadPoolProvider.a().a(new TrackingManager$$ExternalSyntheticLambda2(context, str));
        } catch (Exception | OutOfMemoryError e2) {
            Log.d("CellRebelSDK", String.format("Initialization failed, exception: %s", new Object[]{e2.toString()}));
        }
    }

    public static void setBackgroundMeasurementsEnabled(boolean z) {
        PreferencesManager.m().a(z);
        if (z) {
            Log.d("CellRebelSDK", "Background measurements enabled");
            d();
            return;
        }
        Log.d("CellRebelSDK", "Background measurements disabled");
        WorkManager.getInstance(f).cancelUniqueWork("CR_PERIODIC_WORKER");
    }

    public static void startTracking(Context context) {
        startTracking(context, (OnCompleteListener) null);
    }

    public static void startTracking(Context context, OnCompleteListener onCompleteListener) {
        Log.d("CellRebelSDK", "Start tracking");
        ThreadPoolProvider.a().a(new TrackingManager$$ExternalSyntheticLambda7(context, onCompleteListener));
    }

    public static void startTrackingInBackground(Context context) {
        if (DatabaseClient.a() != null) {
            PreferencesManager.m().b(false);
            if (PreferencesManager.m() != null && PreferencesManager.m().v() != null) {
                b = false;
                c = true;
                a(context, (OnCompleteListener) null);
            }
        }
    }

    public static void stopTracking(Context context) {
        Log.d("CellRebelSDK", "Measurements stopped");
        PreferencesManager.m().b(true);
        WorkManager.getInstance(context).cancelUniqueWork("CR_PERIODIC_WORKER");
        WorkManager.getInstance(context).cancelUniqueWork("CR_FOREGROUND_WORKER");
        MetaHelp metaHelp = d;
        if (metaHelp != null) {
            metaHelp.b = true;
            CollectPageLoadMetricsWorker collectPageLoadMetricsWorker = metaHelp.e;
            if (collectPageLoadMetricsWorker != null) {
                collectPageLoadMetricsWorker.a(true);
            }
            CollectVideoMetricsWorker collectVideoMetricsWorker = d.i;
            if (collectVideoMetricsWorker != null) {
                collectVideoMetricsWorker.a(true);
            }
            CollectFileTransferMetricsWorker collectFileTransferMetricsWorker = d.h;
            if (collectFileTransferMetricsWorker != null) {
                collectFileTransferMetricsWorker.a(true);
            }
            CollectGameWorker collectGameWorker = d.f;
            if (collectGameWorker != null) {
                collectGameWorker.a(true);
            }
            CollectLoadedLatencyWorker collectLoadedLatencyWorker = d.g;
            if (collectLoadedLatencyWorker != null) {
                collectLoadedLatencyWorker.a(true);
            }
        }
    }
}
