package com.m2catalyst.m2sdk.configuration;

import android.os.Build;
import com.m2catalyst.m2sdk.external.LoggingLevel;
import com.m2catalyst.m2sdk.external.M2SDKConfiguration;
import com.m2catalyst.m2sdk.f3;
import com.m2catalyst.m2sdk.f6;
import com.m2catalyst.m2sdk.h2;
import com.m2catalyst.m2sdk.n2;
import com.m2catalyst.m2sdk.p2;
import com.m2catalyst.m2sdk.q2;
import com.m2catalyst.m2sdk.x2;
import io.monedata.adapters.m2catalyst.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0002R*\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R*\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R*\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00198\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u00198\u0006@@X\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR.\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\f\u001a\u0004\u0018\u00010#8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R.\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\f\u001a\u0004\u0018\u00010*8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00102\u001a\u0004\u0018\u0001012\b\u0010\f\u001a\u0004\u0018\u0001018\u0006@@X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u00109\u001a\u0004\u0018\u0001082\b\u0010\f\u001a\u0004\u0018\u0001088\u0006@@X\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R.\u0010@\u001a\u0004\u0018\u00010?2\b\u0010\f\u001a\u0004\u0018\u00010?8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER.\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\f\u001a\u0004\u0018\u00010F8\u0006@@X\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR*\u0010N\u001a\u00020M2\u0006\u0010\f\u001a\u00020M8\u0006@@X\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0017\u0010T\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\bT\u0010\u000e\u001a\u0004\bU\u0010\u0010R\u0017\u0010V\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\bV\u0010\u000e\u001a\u0004\bW\u0010\u0010R\u0017\u0010X\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\bX\u0010\u000e\u001a\u0004\bY\u0010\u0010R\u0017\u0010Z\u001a\u00020M8\u0006¢\u0006\f\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010QR\u001a\u0010\\\u001a\u00020M8\u0006XD¢\u0006\f\n\u0004\b\\\u0010O\u001a\u0004\b]\u0010QR\u001a\u0010^\u001a\u00020\u000b8\u0006XD¢\u0006\f\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010¨\u0006b"}, d2 = {"Lcom/m2catalyst/m2sdk/configuration/M2Configuration;", "", "", "isDebug", "Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration;", "configuration", "", "setLocalConfig", "Lcom/m2catalyst/m2sdk/x2;", "setRemoteConfig", "isComplete", "", "<set-?>", "packageName", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "setPackageName$m2sdk_release", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName$m2sdk_release", "apiKey", "getApiKey", "setApiKey$m2sdk_release", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "loggingLevel", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "getLoggingLevel", "()Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "setLoggingLevel$m2sdk_release", "(Lcom/m2catalyst/m2sdk/external/LoggingLevel;)V", "superloggingLevel", "getSuperloggingLevel", "setSuperloggingLevel$m2sdk_release", "Lcom/m2catalyst/m2sdk/q2;", "ingestionConfig", "Lcom/m2catalyst/m2sdk/q2;", "getIngestionConfig", "()Lcom/m2catalyst/m2sdk/q2;", "setIngestionConfig$m2sdk_release", "(Lcom/m2catalyst/m2sdk/q2;)V", "Lcom/m2catalyst/m2sdk/p2;", "generalConfig", "Lcom/m2catalyst/m2sdk/p2;", "getGeneralConfig", "()Lcom/m2catalyst/m2sdk/p2;", "setGeneralConfig$m2sdk_release", "(Lcom/m2catalyst/m2sdk/p2;)V", "Lcom/m2catalyst/m2sdk/n2;", "dataAccess", "Lcom/m2catalyst/m2sdk/n2;", "getDataAccess", "()Lcom/m2catalyst/m2sdk/n2;", "setDataAccess$m2sdk_release", "(Lcom/m2catalyst/m2sdk/n2;)V", "Lcom/m2catalyst/m2sdk/h2;", "locationConfiguration", "Lcom/m2catalyst/m2sdk/h2;", "getLocationConfiguration", "()Lcom/m2catalyst/m2sdk/h2;", "setLocationConfiguration$m2sdk_release", "(Lcom/m2catalyst/m2sdk/h2;)V", "Lcom/m2catalyst/m2sdk/f3;", "mnsiConfiguration", "Lcom/m2catalyst/m2sdk/f3;", "getMnsiConfiguration", "()Lcom/m2catalyst/m2sdk/f3;", "setMnsiConfiguration$m2sdk_release", "(Lcom/m2catalyst/m2sdk/f3;)V", "Lcom/m2catalyst/m2sdk/f6;", "speedTestConfiguration", "Lcom/m2catalyst/m2sdk/f6;", "getSpeedTestConfiguration", "()Lcom/m2catalyst/m2sdk/f6;", "setSpeedTestConfiguration$m2sdk_release", "(Lcom/m2catalyst/m2sdk/f6;)V", "", "crashExceptionHandling", "I", "getCrashExceptionHandling", "()I", "setCrashExceptionHandling$m2sdk_release", "(I)V", "ingestionBaseUrl", "getIngestionBaseUrl", "ndtUrl", "getNdtUrl", "m2RemoteConfigBaseUrl", "getM2RemoteConfigBaseUrl", "androidVersion", "getAndroidVersion", "versionCode", "getVersionCode", "versionName", "getVersionName", "<init>", "()V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: M2Configuration.kt */
public final class M2Configuration {
    private final int androidVersion;
    private String apiKey = "";
    private String appName = "";
    private int crashExceptionHandling;
    private n2 dataAccess;
    private p2 generalConfig;
    private final String ingestionBaseUrl;
    private q2 ingestionConfig;
    private h2 locationConfiguration;
    private LoggingLevel loggingLevel;
    private final String m2RemoteConfigBaseUrl;
    private f3 mnsiConfiguration;
    private final String ndtUrl;
    private String packageName = "";
    private f6 speedTestConfiguration;
    private LoggingLevel superloggingLevel;
    private final int versionCode;
    private final String versionName;

    public M2Configuration() {
        this.loggingLevel = isDebug() ? LoggingLevel.VERBOSE : LoggingLevel.INFO;
        this.crashExceptionHandling = 1;
        this.ingestionBaseUrl = isDebug() ? "https://dev.ingest.m2appmonitor.com/" : "https://ingest.m2catalyst.com/";
        this.ndtUrl = isDebug() ? "https://dev.m2appinsight.com/networkDiagnostics/" : "https://m2appinsight.com/networkDiagnostics/";
        isDebug();
        this.m2RemoteConfigBaseUrl = "";
        this.androidVersion = Build.VERSION.SDK_INT;
        this.versionCode = 1002;
        this.versionName = BuildConfig.ADAPTER_VERSION;
    }

    public final int getAndroidVersion() {
        return this.androidVersion;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getCrashExceptionHandling() {
        return this.crashExceptionHandling;
    }

    public final n2 getDataAccess() {
        return this.dataAccess;
    }

    public final p2 getGeneralConfig() {
        return this.generalConfig;
    }

    public final String getIngestionBaseUrl() {
        return this.ingestionBaseUrl;
    }

    public final q2 getIngestionConfig() {
        return this.ingestionConfig;
    }

    public final h2 getLocationConfiguration() {
        return this.locationConfiguration;
    }

    public final LoggingLevel getLoggingLevel() {
        return this.loggingLevel;
    }

    public final String getM2RemoteConfigBaseUrl() {
        return this.m2RemoteConfigBaseUrl;
    }

    public final f3 getMnsiConfiguration() {
        return this.mnsiConfiguration;
    }

    public final String getNdtUrl() {
        return this.ndtUrl;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final f6 getSpeedTestConfiguration() {
        return this.speedTestConfiguration;
    }

    public final LoggingLevel getSuperloggingLevel() {
        return this.superloggingLevel;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isComplete() {
        if (this.dataAccess == null || this.generalConfig == null || this.ingestionConfig == null || this.locationConfiguration == null || this.mnsiConfiguration == null) {
            return false;
        }
        if (!(this.packageName.length() > 0)) {
            return false;
        }
        if (!(this.appName.length() > 0)) {
            return false;
        }
        if (this.apiKey.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean isDebug() {
        return false;
    }

    public final void setApiKey$m2sdk_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apiKey = str;
    }

    public final void setAppName$m2sdk_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void setCrashExceptionHandling$m2sdk_release(int i) {
        this.crashExceptionHandling = i;
    }

    public final void setDataAccess$m2sdk_release(n2 n2Var) {
        this.dataAccess = n2Var;
    }

    public final void setGeneralConfig$m2sdk_release(p2 p2Var) {
        this.generalConfig = p2Var;
    }

    public final void setIngestionConfig$m2sdk_release(q2 q2Var) {
        this.ingestionConfig = q2Var;
    }

    public final void setLocalConfig(M2SDKConfiguration m2SDKConfiguration) {
        Intrinsics.checkNotNullParameter(m2SDKConfiguration, "configuration");
        this.packageName = m2SDKConfiguration.getPackageName();
        this.appName = m2SDKConfiguration.getAppName();
        this.apiKey = m2SDKConfiguration.getApiKey();
        this.crashExceptionHandling = m2SDKConfiguration.getCrashExceptionHandling$m2sdk_release() ? 1 : 0;
        if (m2SDKConfiguration.getLoggingLevel$m2sdk_release() == null) {
            m2SDKConfiguration.setLoggingLevel$m2sdk_release(isDebug() ? LoggingLevel.VERBOSE : LoggingLevel.INFO);
        }
        LoggingLevel loggingLevel$m2sdk_release = m2SDKConfiguration.getLoggingLevel$m2sdk_release();
        Intrinsics.checkNotNull(loggingLevel$m2sdk_release);
        this.loggingLevel = loggingLevel$m2sdk_release;
    }

    public final void setLocationConfiguration$m2sdk_release(h2 h2Var) {
        this.locationConfiguration = h2Var;
    }

    public final void setLoggingLevel$m2sdk_release(LoggingLevel loggingLevel2) {
        Intrinsics.checkNotNullParameter(loggingLevel2, "<set-?>");
        this.loggingLevel = loggingLevel2;
    }

    public final void setMnsiConfiguration$m2sdk_release(f3 f3Var) {
        this.mnsiConfiguration = f3Var;
    }

    public final void setPackageName$m2sdk_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setRemoteConfig(x2 x2Var) {
        Intrinsics.checkNotNullParameter(x2Var, "configuration");
        this.generalConfig = x2Var.f;
        this.ingestionConfig = x2Var.a;
        this.speedTestConfiguration = x2Var.c;
        this.locationConfiguration = x2Var.d;
        this.mnsiConfiguration = x2Var.e;
        this.dataAccess = x2Var.b;
    }

    public final void setSpeedTestConfiguration$m2sdk_release(f6 f6Var) {
        this.speedTestConfiguration = f6Var;
    }

    public final void setSuperloggingLevel$m2sdk_release(LoggingLevel loggingLevel2) {
        this.superloggingLevel = loggingLevel2;
    }
}
