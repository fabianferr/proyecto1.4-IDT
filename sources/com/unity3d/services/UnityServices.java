package com.unity3d.services;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.EnvironmentCheck;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.properties.Session;
import com.unity3d.services.core.request.metrics.InitMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J.\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007R*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\u0012\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/unity3d/services/UnityServices;", "", "()V", "debugMode", "", "getDebugMode$annotations", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "isInitialized", "isInitialized$annotations", "isSupported", "isSupported$annotations", "version", "", "getVersion$annotations", "getVersion", "()Ljava/lang/String;", "createExpectedParametersString", "fieldName", "current", "received", "initialize", "", "context", "Landroid/content/Context;", "gameId", "testMode", "initializationListener", "Lcom/unity3d/ads/IUnityAdsInitializationListener;", "UnityServicesError", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UnityServices.kt */
public final class UnityServices {
    public static final UnityServices INSTANCE = new UnityServices();
    private static final boolean isSupported = true;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/unity3d/services/UnityServices$UnityServicesError;", "", "(Ljava/lang/String;I)V", "INVALID_ARGUMENT", "INIT_SANITY_CHECK_FAIL", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UnityServices.kt */
    public enum UnityServicesError {
        INVALID_ARGUMENT,
        INIT_SANITY_CHECK_FAIL
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UnityServices.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.unity3d.services.core.properties.SdkProperties$InitializationState[] r0 = com.unity3d.services.core.properties.SdkProperties.InitializationState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.unity3d.services.core.properties.SdkProperties$InitializationState r1 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.unity3d.services.core.properties.SdkProperties$InitializationState r1 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZED_FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.unity3d.services.core.properties.SdkProperties$InitializationState r1 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.UnityServices.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static /* synthetic */ void getDebugMode$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getVersion$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isSupported$annotations() {
    }

    private UnityServices() {
    }

    @JvmStatic
    public static final void initialize(Context context, String str, boolean z, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        Integer intOrNull;
        String str2;
        DeviceLog.entered();
        if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
            intOrNull.intValue();
            boolean z2 = false;
            if (SdkProperties.getCurrentInitializationState() != SdkProperties.InitializationState.NOT_INITIALIZED) {
                String gameId = ClientProperties.getGameId();
                boolean isTestMode = SdkProperties.isTestMode();
                StringBuilder sb = new StringBuilder();
                if (gameId != null && !Intrinsics.areEqual((Object) gameId, (Object) str)) {
                    sb.append(INSTANCE.createExpectedParametersString("Game ID", gameId, str));
                    Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                    sb.append(10);
                    Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                }
                if (isTestMode != z) {
                    sb.append(INSTANCE.createExpectedParametersString("Test Mode", Boolean.valueOf(isTestMode), Boolean.valueOf(z)));
                    Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                    sb.append(10);
                    Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                if (sb2.length() > 0) {
                    InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitDiffParams());
                    str2 = "different parameters: \n" + sb2;
                } else {
                    InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitSameParams());
                    str2 = "the same Game ID: " + str + " and Test Mode: " + z + " values.";
                }
                DeviceLog.warning("Unity Ads SDK initialize has already been called with " + str2 + " Responding with first initialization result.");
            }
            SdkProperties.addInitializationListener(iUnityAdsInitializationListener);
            SdkProperties.InitializationState currentInitializationState = SdkProperties.getCurrentInitializationState();
            int i = currentInitializationState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[currentInitializationState.ordinal()];
            if (i == 1) {
                SdkProperties.notifyInitializationComplete();
            } else if (i == 2) {
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to previous failed reason");
            } else if (i != 3) {
                SdkProperties.setInitializeState(SdkProperties.InitializationState.INITIALIZING);
                ClientProperties.setGameId(str);
                SdkProperties.setTestMode(z);
                if (!isSupported) {
                    DeviceLog.error("Error while initializing Unity Services: device is not supported");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to device is not supported");
                    return;
                }
                SdkProperties.setInitializationTime(Device.getElapsedRealtime());
                SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis());
                if (str.length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    DeviceLog.error("Error while initializing Unity Services: empty game ID, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to empty game ID");
                } else if (context == null) {
                    DeviceLog.error("Error while initializing Unity Services: null context, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to null context");
                } else {
                    if (context instanceof Application) {
                        ClientProperties.setApplication((Application) context);
                    } else if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        if (activity.getApplication() != null) {
                            ClientProperties.setApplication(activity.getApplication());
                        } else {
                            DeviceLog.error("Error while initializing Unity Services: cannot retrieve application from context, halting Unity Ads init");
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application from context");
                            return;
                        }
                    } else {
                        DeviceLog.error("Error while initializing Unity Services: invalid context, halting Unity Ads init");
                        SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to invalid context");
                        return;
                    }
                    DeviceLog.info("Initializing Unity Services " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + str + " in " + (z ? "test mode" : "production mode") + ", session " + Session.Default.getId());
                    SdkProperties.setDebugMode(SdkProperties.getDebugMode());
                    if (context.getApplicationContext() != null) {
                        ClientProperties.setApplicationContext(context.getApplicationContext());
                        if (!EnvironmentCheck.isEnvironmentOk()) {
                            DeviceLog.error("Error during Unity Services environment check, halting Unity Services init");
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to environment check failed");
                            return;
                        }
                        DeviceLog.info("Unity Services environment check OK");
                        UnityAdsSDK.INSTANCE.initialize();
                        return;
                    }
                    DeviceLog.error("Error while initializing Unity Services: cannot retrieve application context, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application context");
                }
            }
        } else if (iUnityAdsInitializationListener != null) {
            iUnityAdsInitializationListener.onInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "gameId \"" + str + "\" should be a number.");
        }
    }

    public static final boolean isSupported() {
        return isSupported;
    }

    public static final boolean isInitialized() {
        return SdkProperties.isInitialized();
    }

    public static final String getVersion() {
        String versionName = SdkProperties.getVersionName();
        Intrinsics.checkNotNullExpressionValue(versionName, "getVersionName()");
        return versionName;
    }

    public static final boolean getDebugMode() {
        return SdkProperties.getDebugMode();
    }

    public static final void setDebugMode(boolean z) {
        SdkProperties.setDebugMode(z);
    }

    private final String createExpectedParametersString(String str, Object obj, Object obj2) {
        return "- " + str + " Current: " + obj + " | Received: " + obj2;
    }
}
