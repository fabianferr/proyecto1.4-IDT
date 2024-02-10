package com.m2catalyst.m2sdk.database.entities;

import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationLogMessage;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001e\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00109\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u001e\u0010<\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010B\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001c¨\u0006I"}, d2 = {"Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;", "", "()V", "accuracy", "", "getAccuracy", "()Ljava/lang/Float;", "setAccuracy", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "altitude", "", "getAltitude", "()Ljava/lang/Double;", "setAltitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "barometric", "getBarometric", "setBarometric", "bearing", "getBearing", "setBearing", "id", "", "getId", "()I", "setId", "(I)V", "indoorOutdoorWeight", "getIndoorOutdoorWeight", "setIndoorOutdoorWeight", "latitude", "getLatitude", "setLatitude", "longitude", "getLongitude", "setLongitude", "permissions", "", "getPermissions", "()Ljava/lang/String;", "setPermissions", "(Ljava/lang/String;)V", "provider", "getProvider", "setProvider", "speed", "getSpeed", "setSpeed", "timeStamp", "", "getTimeStamp", "()Ljava/lang/Long;", "setTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "timeZoneId", "getTimeZoneId", "setTimeZoneId", "timeZoneOffset", "getTimeZoneOffset", "()Ljava/lang/Integer;", "setTimeZoneOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "transmitted", "getTransmitted", "setTransmitted", "toBusiness", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/LocationLogMessage;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationEntity.kt */
public final class LocationEntity {
    private Float accuracy;
    private Double altitude;
    private Float barometric;
    private Float bearing;
    private int id;
    private Double indoorOutdoorWeight;
    private Double latitude;
    private Double longitude;
    private String permissions;
    private String provider;
    private Float speed;
    private Long timeStamp;
    private String timeZoneId = TimeZone.getDefault().getID();
    private Integer timeZoneOffset;
    private int transmitted;

    public final Float getAccuracy() {
        return this.accuracy;
    }

    public final Double getAltitude() {
        return this.altitude;
    }

    public final Float getBarometric() {
        return this.barometric;
    }

    public final Float getBearing() {
        return this.bearing;
    }

    public final int getId() {
        return this.id;
    }

    public final Double getIndoorOutdoorWeight() {
        return this.indoorOutdoorWeight;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final String getPermissions() {
        return this.permissions;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final Long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTimeZoneId() {
        return this.timeZoneId;
    }

    public final Integer getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public final void setAccuracy(Float f) {
        this.accuracy = f;
    }

    public final void setAltitude(Double d) {
        this.altitude = d;
    }

    public final void setBarometric(Float f) {
        this.barometric = f;
    }

    public final void setBearing(Float f) {
        this.bearing = f;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndoorOutdoorWeight(Double d) {
        this.indoorOutdoorWeight = d;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final void setPermissions(String str) {
        this.permissions = str;
    }

    public final void setProvider(String str) {
        this.provider = str;
    }

    public final void setSpeed(Float f) {
        this.speed = f;
    }

    public final void setTimeStamp(Long l) {
        this.timeStamp = l;
    }

    public final void setTimeZoneId(String str) {
        this.timeZoneId = str;
    }

    public final void setTimeZoneOffset(Integer num) {
        this.timeZoneOffset = num;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public final M2Location toBusiness() {
        String str = this.provider;
        if (str == null) {
            str = "generated";
        }
        M2Location m2Location = new M2Location(str);
        Float f = this.speed;
        if (f != null) {
            m2Location.setSpeed(f.floatValue());
        }
        Float f2 = this.accuracy;
        if (f2 != null) {
            m2Location.setAccuracy(f2.floatValue());
        }
        Double d = this.altitude;
        if (d != null) {
            m2Location.setAltitude(d.doubleValue());
        }
        Float f3 = this.bearing;
        if (f3 != null) {
            m2Location.setBearing(f3.floatValue());
        }
        Double d2 = this.indoorOutdoorWeight;
        if (d2 != null) {
            m2Location.setIndoorOutdoorWeight(Float.valueOf((float) d2.doubleValue()));
        }
        Double d3 = this.latitude;
        if (d3 != null) {
            m2Location.setLatitude(d3.doubleValue());
        }
        Double d4 = this.longitude;
        if (d4 != null) {
            m2Location.setLongitude(d4.doubleValue());
        }
        Long l = this.timeStamp;
        if (l != null) {
            m2Location.setTimeStamp(l.longValue());
        }
        String str2 = this.timeZoneId;
        if (str2 != null) {
            m2Location.setTimeZoneId(str2);
        }
        Integer num = this.timeZoneOffset;
        if (num != null) {
            m2Location.setTimeZoneOffset(num.intValue());
        }
        m2Location.setTransmitted(this.transmitted);
        Float f4 = this.barometric;
        if (f4 != null) {
            m2Location.setBarometricPressure(Float.valueOf(f4.floatValue()));
        }
        if (this.permissions != null) {
            m2Location.getPermissions();
        }
        int i = this.id;
        if (i != -1) {
            m2Location.setId((long) i);
        }
        return m2Location;
    }

    public final LocationLogMessage toMessage() {
        LocationLogMessage.Builder builder = new LocationLogMessage.Builder();
        builder.time_stamp(this.timeStamp);
        builder.time_zone_id(this.timeZoneId);
        builder.time_zone_offset(this.timeZoneOffset);
        builder.provider(this.provider);
        builder.latitude(this.latitude);
        builder.longitude(this.longitude);
        builder.altitude(this.altitude);
        builder.permissions(this.permissions);
        Float f = this.bearing;
        if (f != null) {
            builder.bearing(Float.valueOf(f.floatValue()));
        }
        Float f2 = this.speed;
        if (f2 != null) {
            builder.speed(Float.valueOf(f2.floatValue()));
        }
        Float f3 = this.accuracy;
        if (f3 != null) {
            builder.accuracy(Float.valueOf(f3.floatValue()));
        }
        Double d = this.indoorOutdoorWeight;
        if (d != null) {
            builder.indoorOutdoorWeight(Float.valueOf((float) d.doubleValue()));
        }
        builder.barometric(this.barometric);
        LocationLogMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
