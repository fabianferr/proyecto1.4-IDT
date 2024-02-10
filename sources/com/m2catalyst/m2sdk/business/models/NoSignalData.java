package com.m2catalyst.m2sdk.business.models;

import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NoNetworkSignalInfoMessage;
import com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0015\u0010O\u001a\u00020P2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\u0003H\u0000¢\u0006\u0002\bSJ\u0006\u0010T\u001a\u00020UR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001c\u0010)\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001c\u0010,\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001e\u0010/\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00105\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001c\u00108\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\u001a\u0010;\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u001a\u0010>\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001eR\u001a\u0010F\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR\u001e\u0010I\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R\u001a\u0010L\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000f\"\u0004\bN\u0010\u0011¨\u0006V"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/NoSignalData;", "", "entity", "Lcom/m2catalyst/m2sdk/database/entities/NoSignalMNSIEntity;", "(Lcom/m2catalyst/m2sdk/database/entities/NoSignalMNSIEntity;)V", "()V", "accuracy", "", "getAccuracy", "()F", "setAccuracy", "(F)V", "id", "", "getId", "()I", "setId", "(I)V", "latitude", "", "getLatitude", "()Ljava/lang/Double;", "setLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "locationProvider", "", "getLocationProvider", "()Ljava/lang/String;", "setLocationProvider", "(Ljava/lang/String;)V", "locationTimeStamp", "", "getLocationTimeStamp", "()Ljava/lang/Long;", "setLocationTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "longitude", "getLongitude", "setLongitude", "permissions", "getPermissions", "setPermissions", "phoneType", "getPhoneType", "setPhoneType", "simMcc", "getSimMcc", "()Ljava/lang/Integer;", "setSimMcc", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "simMnc", "getSimMnc", "setSimMnc", "simOperatorName", "getSimOperatorName", "setSimOperatorName", "simSlot", "getSimSlot", "setSimSlot", "timeStamp", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "timeZone", "getTimeZone", "setTimeZone", "timeZoneId", "getTimeZoneId", "setTimeZoneId", "timeZoneOffset", "getTimeZoneOffset", "setTimeZoneOffset", "transmitted", "getTransmitted", "setTransmitted", "setup", "", "setup$m2sdk_release", "toNoSignalEntity", "toNoSignalEntity$m2sdk_release", "toNoSignalMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/NoNetworkSignalInfoMessage;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NoSignalData.kt */
public final class NoSignalData {
    private float accuracy;
    private int id;
    private Double latitude;
    private String locationProvider;
    private Long locationTimeStamp;
    private Double longitude;
    private String permissions;
    private String phoneType;
    private Integer simMcc;
    private Integer simMnc;
    private String simOperatorName;
    private int simSlot;
    private long timeStamp;
    private String timeZone;
    private String timeZoneId;
    private Long timeZoneOffset;
    private int transmitted;

    public NoSignalData() {
        this.timeZoneId = "";
        this.simSlot = -1;
        this.timeStamp = System.currentTimeMillis();
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    public final int getId() {
        return this.id;
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

    public final String getPhoneType() {
        return this.phoneType;
    }

    public final Integer getSimMcc() {
        return this.simMcc;
    }

    public final Integer getSimMnc() {
        return this.simMnc;
    }

    public final String getSimOperatorName() {
        return this.simOperatorName;
    }

    public final int getSimSlot() {
        return this.simSlot;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getTimeZoneId() {
        return this.timeZoneId;
    }

    public final Long getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public final void setAccuracy(float f) {
        this.accuracy = f;
    }

    public final void setId(int i) {
        this.id = i;
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

    public final void setPhoneType(String str) {
        this.phoneType = str;
    }

    public final void setSimMcc(Integer num) {
        this.simMcc = num;
    }

    public final void setSimMnc(Integer num) {
        this.simMnc = num;
    }

    public final void setSimOperatorName(String str) {
        this.simOperatorName = str;
    }

    public final void setSimSlot(int i) {
        this.simSlot = i;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public final void setTimeZone(String str) {
        this.timeZone = str;
    }

    public final void setTimeZoneId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeZoneId = str;
    }

    public final void setTimeZoneOffset(Long l) {
        this.timeZoneOffset = l;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public final void setup$m2sdk_release(NoSignalMNSIEntity noSignalMNSIEntity) {
        Intrinsics.checkNotNullParameter(noSignalMNSIEntity, "entity");
        this.id = noSignalMNSIEntity.getId();
        this.transmitted = noSignalMNSIEntity.getTransmitted();
        Long timeStamp2 = noSignalMNSIEntity.getTimeStamp();
        this.timeStamp = timeStamp2 != null ? timeStamp2.longValue() : System.currentTimeMillis();
        this.timeZone = noSignalMNSIEntity.getTimeZone();
        this.phoneType = noSignalMNSIEntity.getPhoneType();
        this.locationTimeStamp = noSignalMNSIEntity.getLocationTimeStamp();
        this.latitude = noSignalMNSIEntity.getLatitude();
        this.longitude = noSignalMNSIEntity.getLongitude();
        Float accuracy2 = noSignalMNSIEntity.getAccuracy();
        this.accuracy = accuracy2 != null ? accuracy2.floatValue() : 0.0f;
        this.locationProvider = noSignalMNSIEntity.getLocationProvider();
        this.simOperatorName = noSignalMNSIEntity.getSimOperatorName();
        this.simMnc = noSignalMNSIEntity.getSimMnc();
        this.simMcc = noSignalMNSIEntity.getSimMcc();
        Integer simSlot2 = noSignalMNSIEntity.getSimSlot();
        this.simSlot = simSlot2 != null ? simSlot2.intValue() : -1;
        this.permissions = noSignalMNSIEntity.getPermissions();
    }

    public final NoSignalMNSIEntity toNoSignalEntity$m2sdk_release() {
        NoSignalMNSIEntity noSignalMNSIEntity = new NoSignalMNSIEntity();
        noSignalMNSIEntity.setId(this.id);
        noSignalMNSIEntity.setTransmitted(this.transmitted);
        noSignalMNSIEntity.setTimeStamp(Long.valueOf(this.timeStamp));
        noSignalMNSIEntity.setTimeZone(this.timeZone);
        noSignalMNSIEntity.setTimeZoneOffset(this.timeZoneOffset);
        noSignalMNSIEntity.setPhoneType(this.phoneType);
        noSignalMNSIEntity.setLocationTimeStamp(this.locationTimeStamp);
        noSignalMNSIEntity.setLocationProvider(this.locationProvider);
        noSignalMNSIEntity.setLatitude(this.latitude);
        noSignalMNSIEntity.setLongitude(this.longitude);
        noSignalMNSIEntity.setAccuracy(Float.valueOf(this.accuracy));
        noSignalMNSIEntity.setSimOperatorName(this.simOperatorName);
        noSignalMNSIEntity.setSimMnc(this.simMnc);
        noSignalMNSIEntity.setSimMcc(this.simMcc);
        noSignalMNSIEntity.setSimSlot(Integer.valueOf(this.simSlot));
        noSignalMNSIEntity.setTimeZoneId(this.timeZoneId);
        noSignalMNSIEntity.setPermissions(this.permissions);
        return noSignalMNSIEntity;
    }

    public final NoNetworkSignalInfoMessage toNoSignalMessage() {
        NoNetworkSignalInfoMessage.Builder builder = new NoNetworkSignalInfoMessage.Builder();
        builder.timeStamp(Long.valueOf(this.timeStamp));
        builder.timeZone(this.timeZone);
        builder.timeZoneOffset(this.timeZoneOffset);
        builder.phoneType(this.phoneType);
        builder.locationTimeStamp(this.locationTimeStamp);
        builder.locationProvider(this.locationProvider);
        builder.latitude(this.latitude);
        builder.longitude(this.longitude);
        builder.accuracy(Double.valueOf((double) this.accuracy));
        builder.simOperatorName(this.simOperatorName);
        builder.simMnc(this.simMnc);
        builder.simMcc(this.simMcc);
        builder.permissions(this.permissions);
        NoNetworkSignalInfoMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NoSignalData(NoSignalMNSIEntity noSignalMNSIEntity) {
        this();
        Intrinsics.checkNotNullParameter(noSignalMNSIEntity, "entity");
        this.timeZoneOffset = noSignalMNSIEntity.getTimeZoneOffset();
        String timeZoneId2 = noSignalMNSIEntity.getTimeZoneId();
        this.timeZoneId = timeZoneId2 == null ? "" : timeZoneId2;
        this.permissions = noSignalMNSIEntity.getPermissions();
        setup$m2sdk_release(noSignalMNSIEntity);
    }
}
