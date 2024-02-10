package com.m2catalyst.m2sdk.business.models;

import android.content.Context;
import android.location.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationLogMessage;
import com.m2catalyst.m2sdk.database.entities.LocationEntity;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.o4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BJ\u0013\u0010C\u001a\u00020\u00152\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\b\u0010F\u001a\u00020\u001bH\u0016J\b\u0010G\u001a\u00020\u000fH\u0016J\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u001bH\u0016J\r\u0010J\u001a\u00020KH\u0000¢\u0006\u0002\bLJ\b\u0010M\u001a\u0004\u0018\u00010NR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001a\u0010#\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0006R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001c\u00103\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010(\"\u0004\b5\u0010\u0006R\u001a\u00106\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013R\u001a\u00109\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010\u0013R\u001a\u0010<\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001f¨\u0006O"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/M2Location;", "Landroid/location/Location;", "l", "(Landroid/location/Location;)V", "provider", "", "(Ljava/lang/String;)V", "barometricPressure", "", "getBarometricPressure", "()Ljava/lang/Float;", "setBarometricPressure", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "dataConnectionType", "", "getDataConnectionType", "()I", "setDataConnectionType", "(I)V", "hasSSID", "", "getHasSSID", "()Z", "setHasSSID", "(Z)V", "id", "", "getId", "()J", "setId", "(J)V", "indoorOutdoorWeight", "getIndoorOutdoorWeight", "setIndoorOutdoorWeight", "mobileData", "getMobileData", "setMobileData", "permissions", "getPermissions", "()Ljava/lang/String;", "setPermissions", "rssi", "", "getRssi", "()D", "setRssi", "(D)V", "timeStamp", "getTimeStamp", "setTimeStamp", "timeZoneId", "getTimeZoneId", "setTimeZoneId", "timeZoneOffset", "getTimeZoneOffset", "setTimeZoneOffset", "transmitted", "getTransmitted", "setTransmitted", "wifiData", "getWifiData", "setWifiData", "addPermissionValues", "", "context", "Landroid/content/Context;", "equals", "obj", "", "getTime", "hashCode", "setTime", "time", "toEntity", "Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;", "toEntity$m2sdk_release", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/LocationLogMessage;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: M2Location.kt */
public final class M2Location extends Location {
    private Float barometricPressure;
    private int dataConnectionType;
    private boolean hasSSID;
    private long id;
    private Float indoorOutdoorWeight;
    private long mobileData;
    private String permissions;
    private double rssi;
    private long timeStamp;
    private String timeZoneId;
    private int timeZoneOffset;
    private int transmitted;
    private long wifiData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2Location(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_PROVIDER);
        this.id = -1;
        this.dataConnectionType = -1;
        this.timeStamp = super.getTime();
    }

    public final void addPermissionValues(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.permissions = o4.a(SDKState.Companion.getInstance(), context, FirebaseAnalytics.Param.LOCATION);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (Intrinsics.areEqual((Object) M2Location.class, (Object) obj.getClass())) {
                M2Location m2Location = (M2Location) obj;
                if (m2Location.id != this.id) {
                    return false;
                }
                String provider = m2Location.getProvider();
                Intrinsics.checkNotNull(provider);
                String provider2 = getProvider();
                Intrinsics.checkNotNull(provider2);
                if (provider.compareTo(provider2) != 0 || m2Location.timeStamp != this.timeStamp || m2Location.getElapsedRealtimeNanos() != getElapsedRealtimeNanos()) {
                    return false;
                }
                if (!(m2Location.getLatitude() == getLatitude())) {
                    return false;
                }
                if (!(m2Location.getLongitude() == getLongitude())) {
                    return false;
                }
                if (!(m2Location.getAltitude() == getAltitude())) {
                    return false;
                }
                if (!(m2Location.getSpeed() == getSpeed())) {
                    return false;
                }
                if (!(m2Location.getBearing() == getBearing())) {
                    return false;
                }
                if ((m2Location.getAccuracy() == getAccuracy()) && m2Location.indoorOutdoorWeight == this.indoorOutdoorWeight) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final Float getBarometricPressure() {
        return this.barometricPressure;
    }

    public final int getDataConnectionType() {
        return this.dataConnectionType;
    }

    public final boolean getHasSSID() {
        return this.hasSSID;
    }

    public final long getId() {
        return this.id;
    }

    public final Float getIndoorOutdoorWeight() {
        return this.indoorOutdoorWeight;
    }

    public final long getMobileData() {
        return this.mobileData;
    }

    public final String getPermissions() {
        return this.permissions;
    }

    public final double getRssi() {
        return this.rssi;
    }

    public long getTime() {
        return this.timeStamp;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTimeZoneId() {
        return this.timeZoneId;
    }

    public final int getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public final long getWifiData() {
        return this.wifiData;
    }

    public int hashCode() {
        int i = (this.transmitted + 31) * 31;
        String str = this.timeZoneId;
        int i2 = 0;
        int hashCode = (((i + ((str == null || str == null) ? 0 : str.hashCode())) * 31) + this.timeZoneOffset) * 31;
        String provider = getProvider();
        int hashCode2 = (((((((((Double.valueOf(getLongitude()).hashCode() + ((Double.valueOf(getLatitude()).hashCode() + ((Long.valueOf(this.timeStamp).hashCode() + ((hashCode + (provider != null ? provider.hashCode() : 0)) * 31)) * 31)) * 31)) * 31) + (hasAltitude() ? Double.valueOf(getAltitude()).hashCode() : 0)) * 31) + (hasSpeed() ? Float.valueOf(getSpeed()).hashCode() : 0)) * 31) + (hasBearing() ? Float.valueOf(getBearing()).hashCode() : 0)) * 31) + (hasAccuracy() ? Float.valueOf(getAccuracy()).hashCode() : 0)) * 31;
        Float f = this.indoorOutdoorWeight;
        if (f != null) {
            Intrinsics.checkNotNull(f);
            i2 = Float.valueOf(f.floatValue()).hashCode();
        }
        return hashCode2 + i2;
    }

    public final void setBarometricPressure(Float f) {
        this.barometricPressure = f;
    }

    public final void setDataConnectionType(int i) {
        this.dataConnectionType = i;
    }

    public final void setHasSSID(boolean z) {
        this.hasSSID = z;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setIndoorOutdoorWeight(Float f) {
        this.indoorOutdoorWeight = f;
    }

    public final void setMobileData(long j) {
        this.mobileData = j;
    }

    public final void setPermissions(String str) {
        this.permissions = str;
    }

    public final void setRssi(double d) {
        this.rssi = d;
    }

    public void setTime(long j) {
        this.timeStamp = j;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public final void setTimeZoneId(String str) {
        this.timeZoneId = str;
    }

    public final void setTimeZoneOffset(int i) {
        this.timeZoneOffset = i;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public final void setWifiData(long j) {
        this.wifiData = j;
    }

    public final LocationEntity toEntity$m2sdk_release() {
        LocationEntity locationEntity = new LocationEntity();
        boolean z = true;
        Double d = null;
        locationEntity.setSpeed(!((getSpeed() > 0.0f ? 1 : (getSpeed() == 0.0f ? 0 : -1)) == 0) ? Float.valueOf(getSpeed()) : null);
        locationEntity.setAccuracy(Float.valueOf(getAccuracy()));
        locationEntity.setAltitude(!((getAltitude() > 0.0d ? 1 : (getAltitude() == 0.0d ? 0 : -1)) == 0) ? Double.valueOf(getAltitude()) : null);
        if (getBearing() != 0.0f) {
            z = false;
        }
        locationEntity.setBearing(!z ? Float.valueOf(getBearing()) : null);
        long j = this.id;
        if (j != -1) {
            locationEntity.setId((int) j);
        }
        Float f = this.indoorOutdoorWeight;
        if (f != null) {
            d = Double.valueOf((double) f.floatValue());
        }
        locationEntity.setIndoorOutdoorWeight(d);
        locationEntity.setLatitude(Double.valueOf(getLatitude()));
        locationEntity.setLongitude(Double.valueOf(getLongitude()));
        locationEntity.setProvider(getProvider());
        locationEntity.setTimeStamp(Long.valueOf(this.timeStamp));
        locationEntity.setTimeZoneId(this.timeZoneId);
        locationEntity.setTimeZoneOffset(Integer.valueOf(this.timeZoneOffset));
        locationEntity.setTransmitted(this.transmitted);
        locationEntity.setBarometric(this.barometricPressure);
        locationEntity.setPermissions(this.permissions);
        return locationEntity;
    }

    public final LocationLogMessage toMessage() {
        LocationLogMessage.Builder builder = new LocationLogMessage.Builder();
        builder.time_stamp(Long.valueOf(this.timeStamp));
        builder.time_zone_id(this.timeZoneId);
        builder.time_zone_offset(Integer.valueOf(this.timeZoneOffset));
        builder.provider(getProvider());
        builder.latitude(Double.valueOf(getLatitude()));
        builder.longitude(Double.valueOf(getLongitude()));
        builder.altitude(Double.valueOf(getAltitude()));
        builder.bearing(Float.valueOf(getBearing()));
        builder.speed(Float.valueOf(getSpeed()));
        builder.accuracy(Float.valueOf(getAccuracy()));
        Float f = this.indoorOutdoorWeight;
        if (f != null) {
            builder.indoorOutdoorWeight(Float.valueOf(f.floatValue()));
        }
        Float f2 = this.barometricPressure;
        if (f2 != null) {
            builder.barometric(Float.valueOf(f2.floatValue()));
        }
        builder.permissions(this.permissions);
        return builder.build();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public M2Location(android.location.Location r4) {
        /*
            r3 = this;
            java.lang.String r0 = "l"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.getProvider()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3.<init>((java.lang.String) r0)
            r3.set(r4)
            r0 = 0
            r3.indoorOutdoorWeight = r0
            long r1 = r4.getTime()
            r3.timeStamp = r1
            java.lang.String r4 = com.m2catalyst.m2sdk.o1.b()
            r3.timeZoneId = r4
            long r1 = r3.timeStamp
            java.lang.Long r4 = java.lang.Long.valueOf(r1)
            java.lang.Integer r4 = com.m2catalyst.m2sdk.o1.a((java.lang.Long) r4)
            r1 = 0
            if (r4 == 0) goto L_0x0033
            int r4 = r4.intValue()
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            r3.timeZoneOffset = r4
            r3.hasSSID = r1
            r1 = 0
            r3.rssi = r1
            r1 = 0
            r3.wifiData = r1
            r3.mobileData = r1
            r3.barometricPressure = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.models.M2Location.<init>(android.location.Location):void");
    }
}
