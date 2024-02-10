package com.m2catalyst.m2sdk.external;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.logger.LoggerUtils;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.m2;
import com.m2catalyst.m2sdk.o2;
import com.m2catalyst.m2sdk.o4;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.r5;
import com.m2catalyst.m2sdk.s1;
import com.m2catalyst.m2sdk.s5;
import com.m2catalyst.m2sdk.t0;
import com.m2catalyst.m2sdk.t2;
import com.m2catalyst.m2sdk.u0;
import com.m2catalyst.m2sdk.v0;
import com.m2catalyst.m2sdk.z5;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J.\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fH\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u001b\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001f\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0002H\u0000¢\u0006\u0004\b%\u0010&J\u0017\u0010,\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010+J\u000e\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016J\n\u0010?\u001a\u0004\u0018\u00010>H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0016R\u0014\u0010C\u001a\u00020B8\u0002XT¢\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020F0E8\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010N\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Lcom/m2catalyst/m2sdk/external/M2SDK;", "Lcom/m2catalyst/m2sdk/external/DataAvailability;", "Landroid/content/Context;", "context", "", "resetPermissionStatus", "Landroid/content/ContextWrapper;", "contextWrapper", "", "initKoin", "setExceptionHandler", "T", "Lkotlin/Function1;", "Lcom/m2catalyst/m2sdk/v0;", "block", "getComponent", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Landroid/app/Application;", "application", "Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration;", "configuration", "initialize", "initialize$m2sdk_release", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/external/M2Listener;", "listener", "addListener", "removeListener", "turnOnDataCollection", "turnOffDataCollection", "updateConfiguration$m2sdk_release", "(Landroid/content/Context;Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration;)V", "updateConfiguration", "checkPermissionsAndRestartCollection$m2sdk_release", "(Landroid/content/Context;)V", "checkPermissionsAndRestartCollection", "appContext", "wakeUpSDK$m2sdk_release", "(Landroid/content/Context;)Z", "wakeUpSDK", "", "throwable", "recordException$m2sdk_release", "(Ljava/lang/Throwable;)V", "recordException", "enabled", "setCrowdSourcedSharing", "isMonitoring", "Lcom/m2catalyst/m2sdk/external/DataAvailability$ConfigurationAvailability;", "getConfiguration", "Lcom/m2catalyst/m2sdk/external/DataAvailability$DeviceInfoAvailability;", "getDeviceInfoData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$SDKStateAvailability;", "getSDKState", "Lcom/m2catalyst/m2sdk/external/DataAvailability$LocationDataAvailability;", "getLocationData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$RFNetworkDataAvailability;", "getRFNetworkData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$NoSignalAvailability;", "getNoSignalData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$WifiAvailability;", "getWifiData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$NetworkDiagnosticsAvailability;", "getNetworkDiagnosticsData", "Lcom/m2catalyst/m2sdk/external/DataAvailability$BadSignalAvailability;", "getBadSignalsData", "", "TAG", "Ljava/lang/String;", "", "Lcom/m2catalyst/m2sdk/external/M2LifecycleListener;", "lifecycleListeners", "Ljava/util/List;", "initAttempt", "Z", "getInitAttempt$m2sdk_release", "()Z", "setInitAttempt$m2sdk_release", "(Z)V", "startAttempt", "getStartAttempt$m2sdk_release", "setStartAttempt$m2sdk_release", "<init>", "()V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: M2SDK.kt */
public final class M2SDK implements DataAvailability {
    public static final M2SDK INSTANCE = new M2SDK();
    private static final String TAG = "M2SDK";
    private static boolean initAttempt;
    /* access modifiers changed from: private */
    public static final List<M2LifecycleListener> lifecycleListeners = new ArrayList();
    private static boolean startAttempt;

    private M2SDK() {
    }

    private final void initKoin(ContextWrapper contextWrapper) {
        M2SDK$initKoin$1 m2SDK$initKoin$1 = new M2SDK$initKoin$1(contextWrapper);
        Intrinsics.checkNotNullParameter(m2SDK$initKoin$1, "declaration");
        t2 t2Var = new t2();
        m2SDK$initKoin$1.invoke(t2Var);
        if (GlobalContext.INSTANCE.getOrNull() == null) {
            DefaultContextExtKt.startKoin((Function1<? super KoinApplication, Unit>) new m2(t2Var));
        } else {
            Koin.loadModules$default(GlobalContext.INSTANCE.get(), t2Var.a, false, 2, (Object) null);
        }
    }

    private final boolean resetPermissionStatus(Context context) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        boolean z;
        boolean z2;
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        companion.i("permission_logs", "Reset Permission Initiated", new String[0]);
        z5 a = r2.a.a().a();
        a6 a6Var = a6.PERMISSION_COARSE_LOCATION_GRANTED;
        Object obj5 = Boolean.FALSE;
        String c = a6Var.c();
        if (!a.a().getAll().containsKey(c)) {
            obj = obj5;
        } else {
            obj = a.a().getAll().get(c);
        }
        Boolean bool = (Boolean) obj;
        a6 a6Var2 = a6.PERMISSION_FINE_LOCATION_GRANTED;
        String c2 = a6Var2.c();
        if (!a.a().getAll().containsKey(c2)) {
            obj2 = obj5;
        } else {
            obj2 = a.a().getAll().get(c2);
        }
        Boolean bool2 = (Boolean) obj2;
        a6 a6Var3 = a6.PERMISSION_BACKGROUND_LOCATION_GRANTED;
        String c3 = a6Var3.c();
        if (!a.a().getAll().containsKey(c3)) {
            obj3 = obj5;
        } else {
            obj3 = a.a().getAll().get(c3);
        }
        Boolean bool3 = (Boolean) obj3;
        a6 a6Var4 = a6.PERMISSION_READ_PHONE_STATE_GRANTED;
        String c4 = a6Var4.c();
        if (!a.a().getAll().containsKey(c4)) {
            obj4 = obj5;
        } else {
            obj4 = a.a().getAll().get(c4);
        }
        Boolean bool4 = (Boolean) obj4;
        a6 a6Var5 = a6.PERMISSION_PACKAGE_USAGE_STATS_GRANTED;
        String c5 = a6Var5.c();
        if (a.a().getAll().containsKey(c5)) {
            obj5 = a.a().getAll().get(c5);
        }
        Boolean bool5 = (Boolean) obj5;
        boolean b = o4.b(context);
        if (!Intrinsics.areEqual((Object) Boolean.valueOf(b), (Object) bool)) {
            a.a(a6Var, Boolean.valueOf(b));
            companion.v("permission_logs", "Reset Permission COARSE_LOCATION_GRANTED: " + b, new String[0]);
            z = true;
        } else {
            z = false;
        }
        SDKState.Companion companion2 = SDKState.Companion;
        companion2.getInstance().setCoarseLocationPermissionGranted$m2sdk_release(b);
        boolean c6 = o4.c(context);
        if (!Intrinsics.areEqual((Object) Boolean.valueOf(c6), (Object) bool2)) {
            a.a(a6Var2, Boolean.valueOf(c6));
            companion.v("permission_logs", "Reset Permission FINE_LOCATION_GRANTED: " + c6, new String[0]);
            z = true;
        }
        companion2.getInstance().setFineLocationPermissionGranted$m2sdk_release(c6);
        boolean a2 = o4.a(context);
        if (!Intrinsics.areEqual((Object) Boolean.valueOf(a2), (Object) bool3)) {
            a.a(a6Var3, Boolean.valueOf(a2));
            companion.v("permission_logs", "Reset Permission BACKGROUND_LOCATION_GRANTED: " + a2, new String[0]);
            z = true;
        }
        companion2.getInstance().setBackgroundLocationPermissionGranted$m2sdk_release(a2);
        boolean e = o4.e(context);
        if (!Intrinsics.areEqual((Object) Boolean.valueOf(e), (Object) bool4)) {
            a.a(a6Var4, Boolean.valueOf(e));
            companion.v("permission_logs", "Reset Permission READ_PHONE_STATE_GRANTED: " + e, new String[0]);
            z = true;
        }
        companion2.getInstance().setReadPhoneStatePermissionGranted$m2sdk_release(e);
        boolean d = o4.d(context);
        if (!Intrinsics.areEqual((Object) Boolean.valueOf(d), (Object) bool5)) {
            a.a(a6Var5, Boolean.valueOf(d));
            companion.v("permission_logs", "Reset Permission PACKAGE_USAGE_STATS_GRANTED: " + d, new String[0]);
            z2 = true;
        } else {
            z2 = z;
        }
        companion2.getInstance().setPackageUsageStatsPermissionGranted$m2sdk_release(d);
        return z2;
    }

    /* access modifiers changed from: private */
    public final void setExceptionHandler() {
        if (r2.j == null) {
            r2.j = new r2();
        }
        r2 r2Var = r2.j;
        Intrinsics.checkNotNull(r2Var);
        M2Configuration m2Configuration = r2Var.g;
        Integer valueOf = m2Configuration != null ? Integer.valueOf(m2Configuration.getCrashExceptionHandling()) : null;
        Set<String> set = s1.a;
        if ((valueOf == null || valueOf.intValue() == 0) ? false : true) {
            new Handler(Looper.getMainLooper()).post(new M2SDK$$ExternalSyntheticLambda0());
        }
    }

    /* access modifiers changed from: private */
    public static final void setExceptionHandler$lambda$11() {
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th) {
                M2SDKLogger.Companion.getLogger().e("M2Catalyst Global Exception Handler", ExceptionsKt.stackTraceToString(th), new String[0]);
                INSTANCE.recordException$m2sdk_release(th);
            }
        }
    }

    public final void addListener(M2Listener m2Listener) {
        Intrinsics.checkNotNullParameter(m2Listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (m2Listener instanceof M2LifecycleListener) {
            lifecycleListeners.add(m2Listener);
        }
    }

    public final void checkPermissionsAndRestartCollection$m2sdk_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (resetPermissionStatus(context) && isMonitoring()) {
            M2SDKLogger.Companion.i("permission_logs", "Begin Restart Collection", new String[0]);
            if (u0.e == null) {
                u0.e = new u0();
            }
            u0 u0Var = u0.e;
            Intrinsics.checkNotNull(u0Var);
            u0Var.getClass();
            if (INSTANCE.isMonitoring()) {
                j3.b(new t0(u0Var, (Continuation<? super t0>) null));
            }
        }
    }

    public DataAvailability.BadSignalAvailability getBadSignalsData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getBadSignalsData();
        } catch (Exception unused) {
            return null;
        }
    }

    public DataAvailability.ConfigurationAvailability getConfiguration() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getConfiguration();
        } catch (Exception unused) {
            return null;
        }
    }

    public DataAvailability.DeviceInfoAvailability getDeviceInfoData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getDeviceInfoData();
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean getInitAttempt$m2sdk_release() {
        return initAttempt;
    }

    public DataAvailability.LocationDataAvailability getLocationData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getLocationData();
        } catch (Exception unused) {
            return null;
        }
    }

    public DataAvailability.NetworkDiagnosticsAvailability getNetworkDiagnosticsData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getNetworkDiagnosticsData();
        } catch (Exception unused) {
            return null;
        }
    }

    public DataAvailability.NoSignalAvailability getNoSignalData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getNoSignalData();
        } catch (Exception unused) {
            return null;
        }
    }

    public DataAvailability.RFNetworkDataAvailability getRFNetworkData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getRFNetworkData();
        } catch (Exception unused) {
            return null;
        }
    }

    public DataAvailability.SDKStateAvailability getSDKState() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getSDKState();
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean getStartAttempt$m2sdk_release() {
        return startAttempt;
    }

    public DataAvailability.WifiAvailability getWifiData() {
        if (!initAttempt) {
            return null;
        }
        if (s5.i == null) {
            s5.i = new s5();
        }
        s5 s5Var = s5.i;
        Intrinsics.checkNotNull(s5Var);
        if (!s5Var.a.d()) {
            return null;
        }
        try {
            return ((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null)).getWifiData();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void initialize(Application application, M2SDKConfiguration m2SDKConfiguration) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(m2SDKConfiguration, "configuration");
        Thread.setDefaultUncaughtExceptionHandler(new o2());
        initKoin(application);
        M2SDKLogger.Companion.i(TAG, "initialize()", LoggerUtils.INSTANCE.m2SDKConfigurationToString(m2SDKConfiguration));
        j3.b(new M2SDK$initialize$1(application, m2SDKConfiguration, (Continuation<? super M2SDK$initialize$1>) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd A[LOOP:0: B:28:0x00b7->B:30:0x00bd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initialize$m2sdk_release(android.content.Context r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.external.M2SDK$initialize$2
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.external.M2SDK$initialize$2 r0 = (com.m2catalyst.m2sdk.external.M2SDK$initialize$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.external.M2SDK$initialize$2 r0 = new com.m2catalyst.m2sdk.external.M2SDK$initialize$2
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "context.applicationContext"
            java.lang.String r4 = "M2SDK"
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003a
            if (r2 != r5) goto L_0x0032
            java.lang.Object r14 = r0.L$0
            android.content.Context r14 = (android.content.Context) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0080
        L_0x0032:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r15)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r15 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r7 = "Initialize Components"
            r15.i(r4, r7, r2)
            com.m2catalyst.m2sdk.s5 r2 = com.m2catalyst.m2sdk.s5.i
            if (r2 != 0) goto L_0x0051
            com.m2catalyst.m2sdk.s5 r2 = new com.m2catalyst.m2sdk.s5
            r2.<init>()
            com.m2catalyst.m2sdk.s5.i = r2
        L_0x0051:
            com.m2catalyst.m2sdk.s5 r2 = com.m2catalyst.m2sdk.s5.i
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.m2catalyst.m2sdk.r2 r7 = r2.a
            boolean r7 = r7.e()
            if (r7 == 0) goto L_0x0068
            java.lang.String[] r14 = new java.lang.String[r6]
            java.lang.String r0 = "SDK Already initialized, skip initialization."
            r15.i(r4, r0, r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0068:
            com.m2catalyst.m2sdk.external.M2SDKConfiguration r15 = r2.a()
            if (r15 == 0) goto L_0x010d
            android.content.Context r15 = r14.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r3)
            r0.L$0 = r14
            r0.label = r5
            java.lang.Object r15 = r2.a(r15, r6, r0)
            if (r15 != r1) goto L_0x0080
            return r1
        L_0x0080:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r15 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r0 = new java.lang.String[r5]
            com.google.gson.GsonBuilder r1 = new com.google.gson.GsonBuilder
            r1.<init>()
            com.google.gson.GsonBuilder r1 = r1.setPrettyPrinting()
            com.google.gson.Gson r1 = r1.create()
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.j
            if (r2 != 0) goto L_0x009c
            com.m2catalyst.m2sdk.r2 r2 = new com.m2catalyst.m2sdk.r2
            r2.<init>()
            com.m2catalyst.m2sdk.r2.j = r2
        L_0x009c:
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r1 = r1.toJson((java.lang.Object) r2)
            java.lang.String r2 = "GsonBuilder().setPrettyP…figuration.getInstance())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0[r6] = r1
            java.lang.String r1 = "initializer.getSavedConfig()"
            r15.i(r4, r1, r0)
            java.util.List<com.m2catalyst.m2sdk.external.M2LifecycleListener> r15 = lifecycleListeners
            java.util.Iterator r15 = r15.iterator()
        L_0x00b7:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x00c7
            java.lang.Object r0 = r15.next()
            com.m2catalyst.m2sdk.external.M2LifecycleListener r0 = (com.m2catalyst.m2sdk.external.M2LifecycleListener) r0
            r0.onSDKInitialized()
            goto L_0x00b7
        L_0x00c7:
            com.m2catalyst.m2sdk.external.M2SDK r15 = INSTANCE
            android.content.Context r14 = r14.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)
            r15.resetPermissionStatus(r14)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r7 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r8 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.SDK_INITIALIZE
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            r10 = 0
            r11 = 4
            r12 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r7, r8, r9, r10, r11, r12)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String[] r15 = new java.lang.String[r5]
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            com.m2catalyst.m2sdk.r2 r1 = com.m2catalyst.m2sdk.r2.j
            if (r1 != 0) goto L_0x00f5
            com.m2catalyst.m2sdk.r2 r1 = new com.m2catalyst.m2sdk.r2
            r1.<init>()
            com.m2catalyst.m2sdk.r2.j = r1
        L_0x00f5:
            com.m2catalyst.m2sdk.r2 r1 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r0 = r0.toJson((java.lang.Object) r1)
            java.lang.String r1 = "Gson().toJson(M2Internal…figuration.getInstance())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r15[r6] = r0
            java.lang.String r0 = "initialized with config"
            r14.i(r4, r0, r15)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x010d:
            java.lang.RuntimeException r14 = new java.lang.RuntimeException
            java.lang.String r15 = "M2 must be initialized before starting it "
            r14.<init>(r15)
            goto L_0x0116
        L_0x0115:
            throw r14
        L_0x0116:
            goto L_0x0115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.external.M2SDK.initialize$m2sdk_release(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isAccessible(KFunction<?> kFunction, l2 l2Var) {
        return DataAvailability.DefaultImpls.isAccessible(this, kFunction, l2Var);
    }

    public final boolean isMonitoring() {
        if (r2.j == null) {
            r2.j = new r2();
        }
        r2 r2Var = r2.j;
        Intrinsics.checkNotNull(r2Var);
        return r2Var.a(r5.f);
    }

    public final void recordException$m2sdk_release(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        try {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new M2SDK$recordException$1(th, (Continuation<? super M2SDK$recordException$1>) null), 3, (Object) null);
            M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "M2Catalyst Global Exception Handler", th.getMessage(), (Exception) null, false, 4, (Object) null);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public final void removeListener(M2Listener m2Listener) {
        Intrinsics.checkNotNullParameter(m2Listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (m2Listener instanceof M2LifecycleListener) {
            lifecycleListeners.remove(m2Listener);
        }
    }

    public final void setCrowdSourcedSharing(boolean z) {
        if (r2.j == null) {
            r2.j = new r2();
        }
        r2 r2Var = r2.j;
        Intrinsics.checkNotNull(r2Var);
        r2Var.a().a(a6.CROWDSOURCE_SHARING_ENABLED, Boolean.valueOf(z));
    }

    public final void setInitAttempt$m2sdk_release(boolean z) {
        initAttempt = z;
    }

    public final void setStartAttempt$m2sdk_release(boolean z) {
        startAttempt = z;
    }

    public final void turnOffDataCollection(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initKoin(new ContextWrapper(context.getApplicationContext()));
        j3.b(new M2SDK$turnOffDataCollection$1((Continuation<? super M2SDK$turnOffDataCollection$1>) null));
    }

    public final void turnOnDataCollection(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initKoin(new ContextWrapper(context.getApplicationContext()));
        M2SDKLogger.Companion.i(TAG, "start()", new String[0]);
        j3.b(new M2SDK$turnOnDataCollection$1(context, (Continuation<? super M2SDK$turnOnDataCollection$1>) null));
    }

    public final void updateConfiguration$m2sdk_release(Context context, M2SDKConfiguration m2SDKConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(m2SDKConfiguration, "configuration");
        MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.SDK_UPDATE_CONFIGURATION, 1, false, 4, (Object) null);
        M2SDK m2sdk = INSTANCE;
        m2sdk.turnOffDataCollection(context);
        if (r2.j == null) {
            r2.j = new r2();
        }
        r2 r2Var = r2.j;
        Intrinsics.checkNotNull(r2Var);
        r2Var.getClass();
        Intrinsics.checkNotNullParameter(m2SDKConfiguration, "configuration");
        r2Var.a((Object) m2SDKConfiguration);
        r2Var.a(true);
        if (r2.j == null) {
            r2.j = new r2();
        }
        r2 r2Var2 = r2.j;
        Intrinsics.checkNotNull(r2Var2);
        r2Var2.a(m2SDKConfiguration);
        m2sdk.turnOnDataCollection(context);
    }

    public final boolean wakeUpSDK$m2sdk_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        initKoin(new ContextWrapper(context.getApplicationContext()));
        if (isMonitoring()) {
            return true;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            Application application = (Application) applicationContext;
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            M2SDKConfiguration a = r2Var.a(context);
            if (a != null) {
                M2SDK m2sdk = INSTANCE;
                m2sdk.initialize(application, a);
                if (r2.j == null) {
                    r2.j = new r2();
                }
                r2 r2Var2 = r2.j;
                Intrinsics.checkNotNull(r2Var2);
                z5 a2 = r2Var2.a();
                a6 a6Var = a6.API_KEY;
                Object obj = Boolean.FALSE;
                if (a2.a.getAll().containsKey("sdkPersistentDataCollectionOn")) {
                    obj = a2.a.getAll().get("sdkPersistentDataCollectionOn");
                }
                Boolean bool = (Boolean) obj;
                if (bool != null ? bool.booleanValue() : false) {
                    m2sdk.turnOnDataCollection(application);
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private final <T> T getComponent(Function1<? super v0, ? extends T> function1) {
        if (!s5.h.a().b()) {
            return null;
        }
        try {
            return function1.invoke((v0) KoinJavaComponent.get$default(v0.class, (Qualifier) null, (Function0) null, 6, (Object) null));
        } catch (Exception unused) {
            return null;
        }
    }
}
