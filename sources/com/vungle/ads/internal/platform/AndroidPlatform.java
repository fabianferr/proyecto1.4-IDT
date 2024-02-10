package com.vungle.ads.internal.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.core.util.Consumer;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.Task;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdvertisingInfo;
import com.vungle.ads.internal.privacy.PrivacyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0017J\n\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0#H\u0016J\b\u0010$\u001a\u00020!H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\n8VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/vungle/ads/internal/platform/AndroidPlatform;", "Lcom/vungle/ads/internal/platform/Platform;", "context", "Landroid/content/Context;", "uaExecutor", "Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "(Landroid/content/Context;Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;)V", "advertisingInfo", "Lcom/vungle/ads/internal/model/AdvertisingInfo;", "appSetId", "", "isAtLeastMinimumSDK", "", "()Z", "isBatterySaverEnabled", "isSdCardPresent", "isSideLoaded", "isSoundEnabled", "powerManager", "Landroid/os/PowerManager;", "userAgent", "getUserAgent", "()Ljava/lang/String;", "setUserAgent", "(Ljava/lang/String;)V", "volumeLevel", "", "getVolumeLevel", "()F", "getAdvertisingInfo", "getAndroidId", "getAppSetId", "getUserAgentLazy", "", "consumer", "Landroidx/core/util/Consumer;", "updateAppSetID", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidPlatform.kt */
public final class AndroidPlatform implements Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AndroidPlatform";
    private AdvertisingInfo advertisingInfo;
    private String appSetId;
    private final Context context;
    private final boolean isSideLoaded;
    private final PowerManager powerManager;
    private final VungleThreadPoolExecutor uaExecutor;
    private String userAgent;

    public AndroidPlatform(Context context2, VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(vungleThreadPoolExecutor, "uaExecutor");
        this.context = context2;
        this.uaExecutor = vungleThreadPoolExecutor;
        updateAppSetID();
        Object systemService = context2.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        this.powerManager = (PowerManager) systemService;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/platform/AndroidPlatform$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AndroidPlatform.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean isAtLeastMinimumSDK() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public boolean isBatterySaverEnabled() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.powerManager.isPowerSaveMode();
        }
        return false;
    }

    public boolean isSideLoaded() {
        return this.isSideLoaded;
    }

    public float getVolumeLevel() {
        try {
            Object systemService = this.context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public boolean isSoundEnabled() {
        try {
            Object systemService = this.context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) systemService).getStreamVolume(3) > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean isSdCardPresent() {
        try {
            return Intrinsics.areEqual((Object) Environment.getExternalStorageState(), (Object) "mounted");
        } catch (Exception e) {
            Log.e(TAG, "Acquiring external storage state failed", e);
            return false;
        }
    }

    public void getUserAgentLazy(Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.uaExecutor.execute(new AndroidPlatform$$ExternalSyntheticLambda1(this, consumer));
    }

    /* access modifiers changed from: private */
    /* renamed from: getUserAgentLazy$lambda-0  reason: not valid java name */
    public static final void m2311getUserAgentLazy$lambda0(AndroidPlatform androidPlatform, Consumer consumer) {
        Intrinsics.checkNotNullParameter(androidPlatform, "this$0");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        new WebViewUtil(androidPlatform.context).getUserAgent(consumer);
    }

    public AdvertisingInfo getAdvertisingInfo() {
        AdvertisingInfo advertisingInfo2 = this.advertisingInfo;
        boolean z = false;
        if (advertisingInfo2 != null) {
            CharSequence advertisingId = advertisingInfo2.getAdvertisingId();
            if (!(advertisingId == null || advertisingId.length() == 0)) {
                return advertisingInfo2;
            }
        }
        AdvertisingInfo advertisingInfo3 = new AdvertisingInfo();
        try {
            if (Intrinsics.areEqual((Object) "Amazon", (Object) Build.MANUFACTURER)) {
                try {
                    ContentResolver contentResolver = this.context.getContentResolver();
                    if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 1) {
                        z = true;
                    }
                    advertisingInfo3.setLimitAdTracking(z);
                    advertisingInfo3.setAdvertisingId(Settings.Secure.getString(contentResolver, "advertising_id"));
                } catch (Settings.SettingNotFoundException e) {
                    Log.w(TAG, "Error getting Amazon advertising info", e);
                }
                this.advertisingInfo = advertisingInfo3;
                return advertisingInfo3;
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
                Intrinsics.checkNotNullExpressionValue(advertisingIdInfo, "getAdvertisingIdInfo(context)");
                advertisingInfo3.setAdvertisingId(advertisingIdInfo.getId());
                advertisingInfo3.setLimitAdTracking(advertisingIdInfo.isLimitAdTrackingEnabled());
            } catch (NoClassDefFoundError e2) {
                Log.e(TAG, "Play services Not available: " + e2.getLocalizedMessage());
                advertisingInfo3.setAdvertisingId(Settings.Secure.getString(this.context.getContentResolver(), "advertising_id"));
            } catch (GooglePlayServicesNotAvailableException e3) {
                Log.e(TAG, "Play services Not available: " + e3.getLocalizedMessage());
            }
            this.advertisingInfo = advertisingInfo3;
            return advertisingInfo3;
        } catch (Exception unused) {
            Log.e(TAG, "Cannot load Advertising ID");
        }
    }

    public String getAppSetId() {
        return this.appSetId;
    }

    public String getAndroidId() {
        return PrivacyManager.INSTANCE.getPublishAndroidId() ? Settings.Secure.getString(this.context.getContentResolver(), "android_id") : "";
    }

    private final void updateAppSetID() {
        try {
            AppSetIdClient client = AppSet.getClient(this.context);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(context)");
            Task<AppSetIdInfo> appSetIdInfo = client.getAppSetIdInfo();
            Intrinsics.checkNotNullExpressionValue(appSetIdInfo, "client.appSetIdInfo");
            appSetIdInfo.addOnSuccessListener(new AndroidPlatform$$ExternalSyntheticLambda0(this));
        } catch (NoClassDefFoundError e) {
            Log.e(TAG, "Required libs to get AppSetID Not available: " + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAppSetID$lambda-1  reason: not valid java name */
    public static final void m2312updateAppSetID$lambda1(AndroidPlatform androidPlatform, AppSetIdInfo appSetIdInfo) {
        Intrinsics.checkNotNullParameter(androidPlatform, "this$0");
        if (appSetIdInfo != null) {
            androidPlatform.appSetId = appSetIdInfo.getId();
        }
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public String getUserAgent() {
        String str = this.userAgent;
        return str == null ? System.getProperty("http.agent") : str;
    }
}
