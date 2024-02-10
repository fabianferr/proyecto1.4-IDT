package com.m2catalyst.m2sdk.logger;

import android.location.Location;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.external.M2SDKConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/LoggerUtils;", "", "()V", "locationToString", "", "location", "Landroid/location/Location;", "m2ConfigurationToString", "configuration", "Lcom/m2catalyst/m2sdk/configuration/M2Configuration;", "m2ConfigurationToString$m2sdk_release", "m2LocationToString", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "m2SDKConfigurationToString", "Lcom/m2catalyst/m2sdk/external/M2SDKConfiguration;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoggerUtils.kt */
public final class LoggerUtils {
    public static final LoggerUtils INSTANCE = new LoggerUtils();

    private LoggerUtils() {
    }

    public final String locationToString(Location location) {
        if (location == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder();
        long time = location.getTime();
        sb.append("Time: " + time + " (milliseconds since epoch),");
        String provider = location.getProvider();
        sb.append("Provider: " + provider + ",");
        double latitude = location.getLatitude();
        sb.append("Latitude: " + latitude + ",");
        double longitude = location.getLongitude();
        sb.append("Longitude: " + longitude + ",");
        double altitude = location.getAltitude();
        sb.append("Altitude: " + altitude + ",");
        float accuracy = location.getAccuracy();
        sb.append("Accuracy: " + accuracy + " meters,");
        float speed = location.getSpeed();
        sb.append("Speed: " + speed + " m/s,");
        float bearing = location.getBearing();
        sb.append("Bearing: " + bearing + " degrees");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final String m2ConfigurationToString$m2sdk_release(M2Configuration m2Configuration) {
        if (m2Configuration == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder();
        String packageName = m2Configuration.getPackageName();
        sb.append("Package Name: " + packageName + ",");
        String appName = m2Configuration.getAppName();
        sb.append("App Name: " + appName + ",");
        String apiKey = m2Configuration.getApiKey();
        sb.append("API Key: " + apiKey + ",");
        String ingestionBaseUrl = m2Configuration.getIngestionBaseUrl();
        sb.append("Ingestion Base URL: " + ingestionBaseUrl + ",");
        String ndtUrl = m2Configuration.getNdtUrl();
        sb.append("NDT URL: " + ndtUrl + ",");
        String m2RemoteConfigBaseUrl = m2Configuration.getM2RemoteConfigBaseUrl();
        sb.append("M2 Remote Config Base URL: " + m2RemoteConfigBaseUrl + ",");
        int androidVersion = m2Configuration.getAndroidVersion();
        sb.append("Android Version: " + androidVersion + ",");
        int versionCode = m2Configuration.getVersionCode();
        sb.append("Version Code: " + versionCode + ",");
        String versionName = m2Configuration.getVersionName();
        sb.append("Version Name: " + versionName);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final String m2LocationToString(M2Location m2Location) {
        if (m2Location == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder(locationToString(m2Location));
        Float indoorOutdoorWeight = m2Location.getIndoorOutdoorWeight();
        sb.append(",Weight: " + indoorOutdoorWeight + ",");
        Float barometricPressure = m2Location.getBarometricPressure();
        sb.append("Barometric: " + barometricPressure + ",");
        String permissions = m2Location.getPermissions();
        sb.append("Permissions: " + permissions);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final String m2SDKConfigurationToString(M2SDKConfiguration m2SDKConfiguration) {
        if (m2SDKConfiguration == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder();
        String packageName = m2SDKConfiguration.getPackageName();
        sb.append("Package Name: " + packageName + ",");
        String appName = m2SDKConfiguration.getAppName();
        sb.append("App Name: " + appName + ",");
        String apiKey = m2SDKConfiguration.getApiKey();
        sb.append("API Key: " + apiKey);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }
}
