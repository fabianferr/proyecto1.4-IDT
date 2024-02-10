package com.m2catalyst.m2sdk.external;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration;", "", "builder", "Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration$Builder;", "(Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration$Builder;)V", "<set-?>", "", "apiKey", "getApiKey", "()Ljava/lang/String;", "appName", "getAppName", "", "crashExceptionHandling", "getCrashExceptionHandling$m2sdk_release", "()Z", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "loggingLevel", "getLoggingLevel$m2sdk_release", "()Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "setLoggingLevel$m2sdk_release", "(Lcom/m2catalyst/m2sdk/external/LoggingLevel;)V", "packageName", "getPackageName", "Builder", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: M2SDKConfiguration.kt */
public class M2SDKConfiguration {
    private String apiKey;
    private String appName;
    private final Builder builder;
    private boolean crashExceptionHandling;
    private LoggingLevel loggingLevel;
    private String packageName;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0000¢\u0006\u0002\b%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006&"}, d2 = {"Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiKey", "", "getApiKey$m2sdk_release", "()Ljava/lang/String;", "setApiKey$m2sdk_release", "(Ljava/lang/String;)V", "appName", "getAppName$m2sdk_release", "setAppName$m2sdk_release", "crashExceptionHandling", "", "getCrashExceptionHandling$m2sdk_release", "()Z", "setCrashExceptionHandling$m2sdk_release", "(Z)V", "loggingLevel", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "getLoggingLevel$m2sdk_release", "()Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "setLoggingLevel$m2sdk_release", "(Lcom/m2catalyst/m2sdk/external/LoggingLevel;)V", "packageName", "getPackageName$m2sdk_release", "setPackageName$m2sdk_release", "build", "Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration;", "checkValidity", "withApiKey", "withAppName", "withCrashExceptionHandling", "withLoggingLevel", "withPackageName", "withPackageName$m2sdk_release", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: M2SDKConfiguration.kt */
    public static final class Builder {
        private String apiKey;
        private String appName;
        private boolean crashExceptionHandling = true;
        private LoggingLevel loggingLevel;
        private String packageName;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.packageName = context.getApplicationContext().getPackageName();
        }

        private final boolean checkValidity() {
            String str = this.packageName;
            if (str == null || str.length() == 0) {
                return false;
            }
            String str2 = this.appName;
            if (str2 == null || str2.length() == 0) {
                return false;
            }
            String str3 = this.apiKey;
            return !(str3 == null || str3.length() == 0);
        }

        public final M2SDKConfiguration build() {
            if (checkValidity()) {
                return new M2SDKConfiguration(this);
            }
            return null;
        }

        public final String getApiKey$m2sdk_release() {
            return this.apiKey;
        }

        public final String getAppName$m2sdk_release() {
            return this.appName;
        }

        public final boolean getCrashExceptionHandling$m2sdk_release() {
            return this.crashExceptionHandling;
        }

        public final LoggingLevel getLoggingLevel$m2sdk_release() {
            return this.loggingLevel;
        }

        public final String getPackageName$m2sdk_release() {
            return this.packageName;
        }

        public final void setApiKey$m2sdk_release(String str) {
            this.apiKey = str;
        }

        public final void setAppName$m2sdk_release(String str) {
            this.appName = str;
        }

        public final void setCrashExceptionHandling$m2sdk_release(boolean z) {
            this.crashExceptionHandling = z;
        }

        public final void setLoggingLevel$m2sdk_release(LoggingLevel loggingLevel2) {
            this.loggingLevel = loggingLevel2;
        }

        public final void setPackageName$m2sdk_release(String str) {
            this.packageName = str;
        }

        public final Builder withApiKey(String str) {
            Intrinsics.checkNotNullParameter(str, "apiKey");
            this.apiKey = str;
            return this;
        }

        public final Builder withAppName(String str) {
            Intrinsics.checkNotNullParameter(str, "appName");
            this.appName = str;
            return this;
        }

        public final Builder withCrashExceptionHandling(boolean z) {
            this.crashExceptionHandling = z;
            return this;
        }

        public final Builder withLoggingLevel(LoggingLevel loggingLevel2) {
            Intrinsics.checkNotNullParameter(loggingLevel2, "loggingLevel");
            this.loggingLevel = loggingLevel2;
            return this;
        }

        public final Builder withPackageName$m2sdk_release(String str) {
            Intrinsics.checkNotNullParameter(str, "packageName");
            this.packageName = str;
            return this;
        }
    }

    public M2SDKConfiguration(Builder builder2) {
        Intrinsics.checkNotNullParameter(builder2, "builder");
        this.builder = builder2;
        String packageName$m2sdk_release = builder2.getPackageName$m2sdk_release();
        String str = "";
        this.packageName = packageName$m2sdk_release == null ? str : packageName$m2sdk_release;
        String appName$m2sdk_release = builder2.getAppName$m2sdk_release();
        this.appName = appName$m2sdk_release == null ? str : appName$m2sdk_release;
        String apiKey$m2sdk_release = builder2.getApiKey$m2sdk_release();
        this.apiKey = apiKey$m2sdk_release != null ? apiKey$m2sdk_release : str;
        this.crashExceptionHandling = builder2.getCrashExceptionHandling$m2sdk_release();
        this.loggingLevel = builder2.getLoggingLevel$m2sdk_release();
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getCrashExceptionHandling$m2sdk_release() {
        return this.crashExceptionHandling;
    }

    public final LoggingLevel getLoggingLevel$m2sdk_release() {
        return this.loggingLevel;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setLoggingLevel$m2sdk_release(LoggingLevel loggingLevel2) {
        this.loggingLevel = loggingLevel2;
    }
}
