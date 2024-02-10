package com.m2catalyst.m2sdk.business.models;

import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.WifiNetworkInfoMessage;
import com.m2catalyst.m2sdk.database.entities.WifiEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010Q\u001a\u00020RR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00103\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R\u001e\u00106\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001e\u00109\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u001c\u0010<\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+R\u001a\u0010?\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R\u001a\u0010B\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R\u001e\u0010E\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010K\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\u001a\u0010N\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011¨\u0006S"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/Wifi;", "", "entity", "Lcom/m2catalyst/m2sdk/database/entities/WifiEntity;", "(Lcom/m2catalyst/m2sdk/database/entities/WifiEntity;)V", "accuracy", "", "getAccuracy", "()Ljava/lang/Float;", "setAccuracy", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "connectedWifiBandFrequency", "", "getConnectedWifiBandFrequency", "()I", "setConnectedWifiBandFrequency", "(I)V", "connectionSpeed", "getConnectionSpeed", "setConnectionSpeed", "dataRx", "", "getDataRx", "()Ljava/lang/Long;", "setDataRx", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "dataTx", "getDataTx", "setDataTx", "getEntity$m2sdk_release", "()Lcom/m2catalyst/m2sdk/database/entities/WifiEntity;", "id", "getId", "()J", "setId", "(J)V", "ipAddress", "", "getIpAddress", "()Ljava/lang/String;", "setIpAddress", "(Ljava/lang/String;)V", "latitude", "", "getLatitude", "()Ljava/lang/Double;", "setLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "locationProvider", "getLocationProvider", "setLocationProvider", "locationTimeStamp", "getLocationTimeStamp", "setLocationTimeStamp", "longitude", "getLongitude", "setLongitude", "permissions", "getPermissions", "setPermissions", "ssid", "getSsid", "setSsid", "timeStamp", "getTimeStamp", "setTimeStamp", "timeZoneOffset", "getTimeZoneOffset", "()Ljava/lang/Integer;", "setTimeZoneOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "transmitted", "getTransmitted", "setTransmitted", "wifiSignalStrength", "getWifiSignalStrength", "setWifiSignalStrength", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/WifiNetworkInfoMessage;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Wifi.kt */
public final class Wifi {
    private Float accuracy;
    private int connectedWifiBandFrequency;
    private int connectionSpeed;
    private Long dataRx;
    private Long dataTx;
    private final WifiEntity entity;
    private long id = -1;
    private String ipAddress;
    private Double latitude;
    private String locationProvider;
    private Long locationTimeStamp;
    private Double longitude;
    private String permissions;
    private String ssid;
    private long timeStamp = -1;
    private Integer timeZoneOffset;
    private int transmitted;
    private int wifiSignalStrength;

    public Wifi(WifiEntity wifiEntity) {
        Intrinsics.checkNotNullParameter(wifiEntity, "entity");
        this.entity = wifiEntity;
        long j = -1;
        String str = "";
        this.ssid = str;
        this.ipAddress = str;
        int i = -1;
        this.connectionSpeed = -1;
        this.wifiSignalStrength = -1;
        this.connectedWifiBandFrequency = -1;
        this.id = (long) wifiEntity.getId();
        Long time_stamp = wifiEntity.getTime_stamp();
        this.timeStamp = time_stamp != null ? time_stamp.longValue() : j;
        this.timeZoneOffset = wifiEntity.getTimeZoneOffset();
        String ssid2 = wifiEntity.getSsid();
        this.ssid = ssid2 == null ? str : ssid2;
        String ip_address = wifiEntity.getIp_address();
        this.ipAddress = ip_address != null ? ip_address : str;
        Integer connection_speed = wifiEntity.getConnection_speed();
        this.connectionSpeed = connection_speed != null ? connection_speed.intValue() : -1;
        Integer signal_strenth_dbm = wifiEntity.getSignal_strenth_dbm();
        this.wifiSignalStrength = signal_strenth_dbm != null ? signal_strenth_dbm.intValue() : -1;
        Integer connected_wifi_band_frequency = wifiEntity.getConnected_wifi_band_frequency();
        this.connectedWifiBandFrequency = connected_wifi_band_frequency != null ? connected_wifi_band_frequency.intValue() : i;
        Long locationTimeStamp2 = wifiEntity.getLocationTimeStamp();
        Long l = null;
        this.locationTimeStamp = locationTimeStamp2 != null ? Long.valueOf(locationTimeStamp2.longValue()) : null;
        this.latitude = wifiEntity.getLatitude();
        this.longitude = wifiEntity.getLongitude();
        Float accuracy2 = wifiEntity.getAccuracy();
        this.accuracy = accuracy2 != null ? Float.valueOf(accuracy2.floatValue()) : null;
        this.locationProvider = wifiEntity.getLocationProvider();
        Integer dataRx2 = wifiEntity.getDataRx();
        this.dataRx = dataRx2 != null ? Long.valueOf((long) dataRx2.intValue()) : null;
        Integer dataTx2 = wifiEntity.getDataTx();
        this.dataTx = dataTx2 != null ? Long.valueOf((long) dataTx2.intValue()) : l;
        this.transmitted = wifiEntity.getTransmitted();
        this.permissions = wifiEntity.getPermissions();
    }

    public final Float getAccuracy() {
        return this.accuracy;
    }

    public final int getConnectedWifiBandFrequency() {
        return this.connectedWifiBandFrequency;
    }

    public final int getConnectionSpeed() {
        return this.connectionSpeed;
    }

    public final Long getDataRx() {
        return this.dataRx;
    }

    public final Long getDataTx() {
        return this.dataTx;
    }

    public final WifiEntity getEntity$m2sdk_release() {
        return this.entity;
    }

    public final long getId() {
        return this.id;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final String getLocationProvider() {
        return this.locationProvider;
    }

    public final Long getLocationTimeStamp() {
        return this.locationTimeStamp;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final String getPermissions() {
        return this.permissions;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final Integer getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public final int getWifiSignalStrength() {
        return this.wifiSignalStrength;
    }

    public final void setAccuracy(Float f) {
        this.accuracy = f;
    }

    public final void setConnectedWifiBandFrequency(int i) {
        this.connectedWifiBandFrequency = i;
    }

    public final void setConnectionSpeed(int i) {
        this.connectionSpeed = i;
    }

    public final void setDataRx(Long l) {
        this.dataRx = l;
    }

    public final void setDataTx(Long l) {
        this.dataTx = l;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setIpAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ipAddress = str;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final void setLocationProvider(String str) {
        this.locationProvider = str;
    }

    public final void setLocationTimeStamp(Long l) {
        this.locationTimeStamp = l;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final void setPermissions(String str) {
        this.permissions = str;
    }

    public final void setSsid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ssid = str;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public final void setTimeZoneOffset(Integer num) {
        this.timeZoneOffset = num;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public final void setWifiSignalStrength(int i) {
        this.wifiSignalStrength = i;
    }

    public final WifiNetworkInfoMessage toMessage() {
        WifiNetworkInfoMessage.Builder builder = new WifiNetworkInfoMessage.Builder();
        builder.time_stamp(Long.valueOf(this.timeStamp)).ssid(this.ssid).ip_address(this.ipAddress).connection_speed(Integer.valueOf(this.connectionSpeed)).wifi_signal_strength(Integer.valueOf(this.wifiSignalStrength)).connected_wifi_band_frequency(Integer.valueOf(this.connectedWifiBandFrequency));
        builder.locationTimeStamp(this.locationTimeStamp);
        builder.locationProvider(this.locationProvider);
        builder.latitude(this.latitude);
        builder.longitude(this.longitude);
        builder.timeZoneOffset(this.timeZoneOffset);
        Float f = this.accuracy;
        if (f != null) {
            builder.accuracy(Double.valueOf(f != null ? (double) f.floatValue() : 0.0d));
        }
        builder.dataRx(this.dataRx);
        builder.dataTx(this.dataTx);
        builder.permissions(this.permissions);
        WifiNetworkInfoMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
