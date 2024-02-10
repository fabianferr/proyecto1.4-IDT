package com.m2catalyst.m2sdk.business.models;

import android.os.Build;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.DeviceInfoMessage;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010V\u001a\u0004\u0018\u00010\u0004J\b\u0010W\u001a\u00020XH\u0007J\b\u0010Y\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001a\u00105\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001a\u00108\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001c\u0010;\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001c\u0010>\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\u001c\u0010A\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\u001c\u0010D\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001a\u0010G\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010/\"\u0004\bI\u00101R\u001a\u0010J\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010/\"\u0004\bL\u00101R\u001a\u0010M\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010/\"\u0004\bO\u00101R\u001a\u0010P\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010/\"\u0004\bR\u00101R\u001a\u0010S\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010/\"\u0004\bU\u00101¨\u0006["}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/DeviceInfo;", "", "()V", "bootloaderId", "", "getBootloaderId", "()Ljava/lang/String;", "setBootloaderId", "(Ljava/lang/String;)V", "cpuCoreLabels", "", "getCpuCoreLabels", "()[Ljava/lang/String;", "setCpuCoreLabels", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "cpuInfo", "getCpuInfo", "cpuMaxSpeed", "", "getCpuMaxSpeed", "()Ljava/lang/Long;", "Ljava/lang/Long;", "deviceArchitecture", "getDeviceArchitecture", "setDeviceArchitecture", "deviceId", "", "getDeviceId", "()Ljava/lang/Integer;", "setDeviceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "deviceName", "getDeviceName", "setDeviceName", "deviceType", "getDeviceType", "setDeviceType", "localeLanguage", "getLocaleLanguage", "setLocaleLanguage", "m2uuid", "getM2uuid", "setM2uuid", "mcc", "getMcc", "()I", "setMcc", "(I)V", "mnc", "getMnc", "setMnc", "networkMcc", "getNetworkMcc", "setNetworkMcc", "networkMnc", "getNetworkMnc", "setNetworkMnc", "networkOperator", "getNetworkOperator", "setNetworkOperator", "oSArchitecture", "getOSArchitecture", "setOSArchitecture", "osBuildId", "getOsBuildId", "setOsBuildId", "osBuildVersion", "getOsBuildVersion", "setOsBuildVersion", "osVersion", "getOsVersion", "setOsVersion", "resourcesMcc", "getResourcesMcc", "setResourcesMcc", "resourcesMnc", "getResourcesMnc", "setResourcesMnc", "simMcc", "getSimMcc", "setSimMcc", "simMnc", "getSimMnc", "setSimMnc", "getDeviceTypeValue", "toMessage", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/DeviceInfoMessage;", "toString", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeviceInfo.kt */
public final class DeviceInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int PAY_PERIOD_MONTH = 1;
    /* access modifiers changed from: private */
    public static int PAY_PERIOD_SIX_MONTH = 3;
    /* access modifiers changed from: private */
    public static int PAY_PERIOD_THREE_MONTH = 2;
    /* access modifiers changed from: private */
    public static int PAY_PERIOD_YEAR = 4;
    public static final int UNSYNCED_DEVICE_ID = -3;
    private String bootloaderId;
    private String[] cpuCoreLabels;
    private final String cpuInfo;
    private final Long cpuMaxSpeed;
    private String deviceArchitecture;
    private Integer deviceId;
    private String deviceName;
    private String deviceType;
    private String localeLanguage;
    private String m2uuid;
    private int mcc = -1;
    private int mnc = -1;
    private int networkMcc = -1;
    private int networkMnc = -1;
    private String networkOperator;
    private String oSArchitecture;
    private String osBuildId;
    private String osBuildVersion;
    private int osVersion = -1;
    private int resourcesMcc = -1;
    private int resourcesMnc = -1;
    private int simMcc = -1;
    private int simMnc = -1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/DeviceInfo$Companion;", "", "()V", "PAY_PERIOD_MONTH", "", "getPAY_PERIOD_MONTH", "()I", "setPAY_PERIOD_MONTH", "(I)V", "PAY_PERIOD_SIX_MONTH", "getPAY_PERIOD_SIX_MONTH", "setPAY_PERIOD_SIX_MONTH", "PAY_PERIOD_THREE_MONTH", "getPAY_PERIOD_THREE_MONTH", "setPAY_PERIOD_THREE_MONTH", "PAY_PERIOD_YEAR", "getPAY_PERIOD_YEAR", "setPAY_PERIOD_YEAR", "UNSYNCED_DEVICE_ID", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DeviceInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getPAY_PERIOD_MONTH() {
            return DeviceInfo.PAY_PERIOD_MONTH;
        }

        public final int getPAY_PERIOD_SIX_MONTH() {
            return DeviceInfo.PAY_PERIOD_SIX_MONTH;
        }

        public final int getPAY_PERIOD_THREE_MONTH() {
            return DeviceInfo.PAY_PERIOD_THREE_MONTH;
        }

        public final int getPAY_PERIOD_YEAR() {
            return DeviceInfo.PAY_PERIOD_YEAR;
        }

        public final void setPAY_PERIOD_MONTH(int i) {
            DeviceInfo.PAY_PERIOD_MONTH = i;
        }

        public final void setPAY_PERIOD_SIX_MONTH(int i) {
            DeviceInfo.PAY_PERIOD_SIX_MONTH = i;
        }

        public final void setPAY_PERIOD_THREE_MONTH(int i) {
            DeviceInfo.PAY_PERIOD_THREE_MONTH = i;
        }

        public final void setPAY_PERIOD_YEAR(int i) {
            DeviceInfo.PAY_PERIOD_YEAR = i;
        }
    }

    public final String getBootloaderId() {
        return this.bootloaderId;
    }

    public final String[] getCpuCoreLabels() {
        return this.cpuCoreLabels;
    }

    public final String getCpuInfo() {
        return this.cpuInfo;
    }

    public final Long getCpuMaxSpeed() {
        return this.cpuMaxSpeed;
    }

    public final String getDeviceArchitecture() {
        return this.deviceArchitecture;
    }

    public final Integer getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getDeviceTypeValue() {
        if (this.deviceType == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            this.deviceType = str + " " + str2;
        }
        return this.deviceType;
    }

    public final String getLocaleLanguage() {
        return this.localeLanguage;
    }

    public final String getM2uuid() {
        return this.m2uuid;
    }

    public final int getMcc() {
        return this.mcc;
    }

    public final int getMnc() {
        return this.mnc;
    }

    public final int getNetworkMcc() {
        return this.networkMcc;
    }

    public final int getNetworkMnc() {
        return this.networkMnc;
    }

    public final String getNetworkOperator() {
        return this.networkOperator;
    }

    public final String getOSArchitecture() {
        return this.oSArchitecture;
    }

    public final String getOsBuildId() {
        return this.osBuildId;
    }

    public final String getOsBuildVersion() {
        return this.osBuildVersion;
    }

    public final int getOsVersion() {
        return this.osVersion;
    }

    public final int getResourcesMcc() {
        return this.resourcesMcc;
    }

    public final int getResourcesMnc() {
        return this.resourcesMnc;
    }

    public final int getSimMcc() {
        return this.simMcc;
    }

    public final int getSimMnc() {
        return this.simMnc;
    }

    public final void setBootloaderId(String str) {
        this.bootloaderId = str;
    }

    public final void setCpuCoreLabels(String[] strArr) {
        this.cpuCoreLabels = strArr;
    }

    public final void setDeviceArchitecture(String str) {
        this.deviceArchitecture = str;
    }

    public final void setDeviceId(Integer num) {
        this.deviceId = num;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final void setDeviceType(String str) {
        this.deviceType = str;
    }

    public final void setLocaleLanguage(String str) {
        this.localeLanguage = str;
    }

    public final void setM2uuid(String str) {
        this.m2uuid = str;
    }

    public final void setMcc(int i) {
        this.mcc = i;
    }

    public final void setMnc(int i) {
        this.mnc = i;
    }

    public final void setNetworkMcc(int i) {
        this.networkMcc = i;
    }

    public final void setNetworkMnc(int i) {
        this.networkMnc = i;
    }

    public final void setNetworkOperator(String str) {
        this.networkOperator = str;
    }

    public final void setOSArchitecture(String str) {
        this.oSArchitecture = str;
    }

    public final void setOsBuildId(String str) {
        this.osBuildId = str;
    }

    public final void setOsBuildVersion(String str) {
        this.osBuildVersion = str;
    }

    public final void setOsVersion(int i) {
        this.osVersion = i;
    }

    public final void setResourcesMcc(int i) {
        this.resourcesMcc = i;
    }

    public final void setResourcesMnc(int i) {
        this.resourcesMnc = i;
    }

    public final void setSimMcc(int i) {
        this.simMcc = i;
    }

    public final void setSimMnc(int i) {
        this.simMnc = i;
    }

    public final DeviceInfoMessage toMessage() {
        DeviceInfoMessage.Builder builder = new DeviceInfoMessage.Builder();
        builder.m2_id(this.m2uuid);
        builder.device_type(this.deviceType);
        builder.android_version(Integer.valueOf(this.osVersion));
        builder.device_name(this.deviceName);
        builder.carrier_name(this.networkOperator);
        builder.mcc(Integer.valueOf(this.mcc));
        builder.mnc(Integer.valueOf(this.mnc));
        builder.language(this.localeLanguage);
        builder.bootloader_id(this.bootloaderId);
        builder.os_build_version(this.osBuildVersion);
        builder.os_build_id(this.osBuildId);
        builder.n_mcc(Integer.valueOf(this.networkMcc));
        builder.n_mnc(Integer.valueOf(this.networkMnc));
        builder.s_mcc(Integer.valueOf(this.simMcc));
        builder.s_mnc(Integer.valueOf(this.simMnc));
        builder.r_mcc(Integer.valueOf(this.resourcesMcc));
        builder.r_mnc(Integer.valueOf(this.resourcesMnc));
        builder.cpu_info(this.cpuInfo).cpu_core_labels(Arrays.toString(this.cpuCoreLabels));
        Long l = this.cpuMaxSpeed;
        if (l != null) {
            builder.cpu_max_speed(Integer.valueOf((int) l.longValue()));
        }
        builder.device_architecture(this.deviceArchitecture);
        builder.os_architecture(this.oSArchitecture);
        DeviceInfoMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public String toString() {
        String str = this.deviceName;
        String str2 = this.m2uuid;
        String str3 = this.deviceType;
        String str4 = this.bootloaderId;
        int i = this.osVersion;
        String str5 = this.osBuildId;
        String str6 = this.osBuildVersion;
        String str7 = this.localeLanguage;
        String str8 = this.networkOperator;
        int i2 = this.mcc;
        int i3 = this.mnc;
        int i4 = this.networkMcc;
        int i5 = this.networkMnc;
        int i6 = this.simMcc;
        int i7 = this.simMnc;
        int i8 = this.resourcesMcc;
        int i9 = this.resourcesMnc;
        String str9 = this.deviceArchitecture;
        return StringsKt.trimIndent("\n            deviceName: " + str + "\n            deviceGuid: " + str2 + "\n            deviceType: " + str3 + "\n            bootloaderId: " + str4 + "\n            osVersion: " + i + "\n            osBuildId: " + str5 + "\n            osBuildVersion: " + str6 + "\n            localeLanguage: " + str7 + "\n            networkOperator: " + str8 + "\n            mcc: " + i2 + "\n            mnc: " + i3 + "\n            networkMcc: " + i4 + "\n            networkMnc: " + i5 + "\n            simMcc: " + i6 + "\n            simMnc: " + i7 + "\n            resourcesMcc: " + i8 + "\n            resourcesMnc: " + i9 + "\n            deviceArchitecture: " + str9 + "\n            osArchitecture: " + this.oSArchitecture + "\n            ");
    }
}
