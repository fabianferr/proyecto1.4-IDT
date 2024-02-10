package com.cellrebel.sdk.networking.beans.request;

import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.ServiceState;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.utils.TelephonyHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Set;

public class CellInfoMetric {
    @SerializedName("accessNetworkTechnologyRaw")
    @Expose
    public Integer accessNetworkTechnologyRaw;
    @SerializedName("additionalPlmns")
    @Expose
    public String additionalPlmns;
    @SerializedName("age")
    @Expose
    public long age;
    @SerializedName("altitude")
    @Expose
    public double altitude;
    @SerializedName("anonymize")
    @Expose
    public Boolean anonymize;
    @SerializedName("appId")
    @Expose
    public String appId;
    @SerializedName("appLastUpdateTime")
    @Expose
    public long appLastUpdateTime;
    @SerializedName("appVersionCode")
    @Expose
    public long appVersionCode;
    @SerializedName("appVersionName")
    @Expose
    public String appVersionName;
    @SerializedName("absoluteRfChannelNumber")
    @Expose
    public Integer arfc;
    @SerializedName("asuLevel")
    @Expose
    public Integer asuLevel;
    @SerializedName("bandwidth")
    @Expose
    public Integer bandwidth;
    @SerializedName("buildDevice")
    @Expose
    public String buildDevice;
    @SerializedName("buildHardware")
    @Expose
    public String buildHardware;
    @SerializedName("buildProduct")
    @Expose
    public String buildProduct;
    @SerializedName("callState")
    @Expose
    public int callState;
    @SerializedName("carrierName")
    @Expose
    public String carrierName;
    @SerializedName("cellBands")
    @Expose
    public String cellBands;
    @SerializedName("cellBandwidths")
    @Expose
    public String cellBandwidths;
    @SerializedName("cellConnectionStatus")
    @Expose
    public int cellConnectionStatus;
    @SerializedName("cellId")
    @Expose
    public String cellId;
    @SerializedName("cellType")
    @Expose
    public String cellType;
    @SerializedName("connectionAbsoluteRfChannelNumber")
    @Expose
    public Integer connectionArfc;
    @SerializedName("channelQualityIndicator")
    @Expose
    public Integer cqi;
    @SerializedName("csiReferenceSignalReceivedPower")
    @Expose
    public Integer csiRsrp;
    @SerializedName("csiReferenceSignalReceivedQuality")
    @Expose
    public Integer csiRsrq;
    @SerializedName("csiReferenceSignalToNoiseAndInterferenceRatio")
    @Expose
    public Integer csiSinr;
    @SerializedName("dataSlotNumber")
    @Expose
    public int dataSimSlotNumber;
    @SerializedName("dateTimeOfMeasurement")
    @Expose
    public String dateTimeOfMeasurement;
    @SerializedName("dbm")
    @Expose
    public Integer dbm;
    @SerializedName("deviceBrand")
    @Expose
    public String deviceBrand;
    @SerializedName("deviceModel")
    @Expose
    public String deviceModel;
    @SerializedName("deviceVersion")
    @Expose
    public String deviceVersion;
    @SerializedName("dozeModeState")
    @Expose
    public int dozeModeState;
    @SerializedName("duplexModeState")
    @Expose
    public int duplexModeState;
    @SerializedName("gatewayIp")
    @Expose
    public String gatewayIp;
    @SerializedName("restrictBackgroundStatus")
    @Expose
    public int getRestrictBackgroundStatus;
    @SerializedName("gpsAccuracy")
    @Expose
    public double gpsAccuracy;
    @SerializedName("gpsVerticalAccuracy")
    @Expose
    public Float gpsVerticalAccuracy;
    public long id;
    @SerializedName("isActiveNetworkMetered")
    @Expose
    public Boolean isActiveNetworkMetered;
    @SerializedName("isConnectedToVpn")
    @Expose
    public Boolean isConnectedToVpn;
    @SerializedName("isDcNrRestricted")
    @Expose
    public Boolean isDcNrRestricted;
    @SerializedName("isDefaultNetworkActive")
    @Expose
    public Boolean isDefaultNetworkActive;
    @SerializedName("isEnDcAvailable")
    @Expose
    public Boolean isEnDcAvailable;
    @SerializedName("isNrAvailable")
    @Expose
    public Boolean isNrAvailable;
    @SerializedName("isOnScreen")
    @Expose
    public Boolean isOnScreen;
    @SerializedName("isReadPhoneStatePermissionGranted")
    @Expose
    public Boolean isReadPhoneStatePermissionGranted;
    @SerializedName("registered")
    @Expose
    public boolean isRegistered;
    @SerializedName("isRoaming")
    @Expose
    public Boolean isRoaming;
    @SerializedName("isRooted")
    @Expose
    public Boolean isRooted;
    public boolean isSending;
    @SerializedName("isUsingCarrierAggregation")
    @Expose
    public Boolean isUsingCarrierAggregation;
    @SerializedName("lac")
    @Expose
    public String lac;
    @SerializedName("latencyType")
    @Expose
    public int latencyType;
    @SerializedName("latitude")
    @Expose
    public double latitude;
    @SerializedName("level")
    @Expose
    public Integer level;
    @SerializedName("locationAge")
    @Expose
    public int locationAge;
    @SerializedName("locationPermissionState")
    @Expose
    public Integer locationPermissionState;
    @SerializedName("locationSpeed")
    @Expose
    public Float locationSpeed;
    @SerializedName("locationSpeedAccuracy")
    @Expose
    public Float locationSpeedAccuracy;
    @SerializedName("longitude")
    @Expose
    public double longitude;
    @SerializedName("measurementSequenceId")
    @Expose
    public String measurementSequenceId;
    @SerializedName("mobileClientId")
    @Expose
    public String mobileClientId;
    @SerializedName("networkMCC")
    @Expose
    public String networkMCC;
    @SerializedName("networkMNC")
    @Expose
    public String networkMNC;
    @SerializedName("networkOperatorName")
    @Expose
    public String networkOperatorName;
    @SerializedName("nrFrequencyRange")
    @Expose
    public Integer nrFrequencyRange;
    @SerializedName("nrState")
    @Expose
    public String nrState;
    @SerializedName("simSlots")
    @Expose
    public int numberOfSimSlots;
    @SerializedName("os")
    @Expose
    public String os;
    @SerializedName("osVersion")
    @Expose
    public String osVersion;
    @SerializedName("overrideNetworkType")
    @Expose
    public Integer overrideNetworkType;
    @SerializedName("physicalCellId")
    @Expose
    public Integer pci;
    @SerializedName("privateIp")
    @Expose
    public String privateIp;
    @SerializedName("referenceSignalReceivedPower")
    @Expose
    public Integer rsrp;
    @SerializedName("referenceSignalReceivedQuality")
    @Expose
    public Integer rsrq;
    @SerializedName("referenceSignalStrengthIndicator")
    @Expose
    public Integer rssi;
    @SerializedName("referenceSignalSignalToNoiseRatio")
    @Expose
    public Integer rssnr;
    @SerializedName("sdkOrigin")
    @Expose
    public String sdkOrigin;
    @SerializedName("sdkVersionNumber")
    @Expose
    public String sdkVersionNumber;
    @SerializedName("carrierName2")
    @Expose
    public String secondaryCarrierName;
    @SerializedName("simMCC2")
    @Expose
    public String secondarySimMCC;
    @SerializedName("simMNC2")
    @Expose
    public String secondarySimMNC;
    @SerializedName("serverIp")
    @Expose
    public String serverIp;
    @SerializedName("simMCC")
    @Expose
    public String simMCC;
    @SerializedName("simMNC")
    @Expose
    public String simMNC;
    @SerializedName("ssReferenceSignalReceivedPower")
    @Expose
    public Integer ssRsrp;
    @SerializedName("ssReferenceSignalReceivedQuality")
    @Expose
    public Integer ssRsrq;
    @SerializedName("ssReferenceSignalToNoiseAndInterferenceRatio")
    @Expose
    public Integer ssSinr;
    @SerializedName("stateDuringMeasurement")
    @Expose
    public int stateDuringMeasurement;
    @SerializedName("timingAdvance")
    @Expose
    public Integer timingAdvance;
    @SerializedName("vopsSupport")
    @Expose
    public Integer vopsSupport;
    @SerializedName("wcdmaEcNo")
    @Expose
    public Integer wcdmaEcNo;

    public CellInfoMetric accessNetworkTechnologyRaw(Integer num) {
        this.accessNetworkTechnologyRaw = num;
        return this;
    }

    public Integer accessNetworkTechnologyRaw() {
        return this.accessNetworkTechnologyRaw;
    }

    public CellInfoMetric additionalPlmns(String str) {
        this.additionalPlmns = str;
        return this;
    }

    public String additionalPlmns() {
        return this.additionalPlmns;
    }

    public long age() {
        return this.age;
    }

    public CellInfoMetric age(long j) {
        this.age = j;
        return this;
    }

    public double altitude() {
        return this.altitude;
    }

    public CellInfoMetric altitude(double d) {
        this.altitude = d;
        return this;
    }

    public CellInfoMetric anonymize(Boolean bool) {
        this.anonymize = bool;
        return this;
    }

    public Boolean anonymize() {
        return this.anonymize;
    }

    public CellInfoMetric appId(String str) {
        this.appId = str;
        return this;
    }

    public String appId() {
        return this.appId;
    }

    public long appLastUpdateTime() {
        return this.appLastUpdateTime;
    }

    public CellInfoMetric appLastUpdateTime(long j) {
        this.appLastUpdateTime = j;
        return this;
    }

    public long appVersionCode() {
        return this.appVersionCode;
    }

    public CellInfoMetric appVersionCode(long j) {
        this.appVersionCode = j;
        return this;
    }

    public CellInfoMetric appVersionName(String str) {
        this.appVersionName = str;
        return this;
    }

    public String appVersionName() {
        return this.appVersionName;
    }

    public CellInfoMetric arfc(Integer num) {
        this.arfc = num;
        return this;
    }

    public Integer arfc() {
        return this.arfc;
    }

    public CellInfoMetric asuLevel(Integer num) {
        this.asuLevel = num;
        return this;
    }

    public Integer asuLevel() {
        return this.asuLevel;
    }

    public CellInfoMetric bandwidth(Integer num) {
        this.bandwidth = num;
        return this;
    }

    public Integer bandwidth() {
        return this.bandwidth;
    }

    public CellInfoMetric buildDevice(String str) {
        this.buildDevice = str;
        return this;
    }

    public String buildDevice() {
        return this.buildDevice;
    }

    public CellInfoMetric buildHardware(String str) {
        this.buildHardware = str;
        return this;
    }

    public String buildHardware() {
        return this.buildHardware;
    }

    public CellInfoMetric buildProduct(String str) {
        this.buildProduct = str;
        return this;
    }

    public String buildProduct() {
        return this.buildProduct;
    }

    public int callState() {
        return this.callState;
    }

    public CellInfoMetric callState(int i) {
        this.callState = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof CellInfoMetric;
    }

    public CellInfoMetric carrierName(String str) {
        this.carrierName = str;
        return this;
    }

    public String carrierName() {
        return this.carrierName;
    }

    public CellInfoMetric cellBands(String str) {
        this.cellBands = str;
        return this;
    }

    public String cellBands() {
        return this.cellBands;
    }

    public CellInfoMetric cellBandwidths(String str) {
        this.cellBandwidths = str;
        return this;
    }

    public String cellBandwidths() {
        return this.cellBandwidths;
    }

    public int cellConnectionStatus() {
        return this.cellConnectionStatus;
    }

    public CellInfoMetric cellConnectionStatus(int i) {
        this.cellConnectionStatus = i;
        return this;
    }

    public CellInfoMetric cellId(String str) {
        this.cellId = str;
        return this;
    }

    public String cellId() {
        return this.cellId;
    }

    public CellInfoMetric cellType(String str) {
        this.cellType = str;
        return this;
    }

    public String cellType() {
        return this.cellType;
    }

    public CellInfoMetric connectionArfc(Integer num) {
        this.connectionArfc = num;
        return this;
    }

    public Integer connectionArfc() {
        return this.connectionArfc;
    }

    public CellInfoMetric cqi(Integer num) {
        this.cqi = num;
        return this;
    }

    public Integer cqi() {
        return this.cqi;
    }

    public CellInfoMetric csiRsrp(Integer num) {
        this.csiRsrp = num;
        return this;
    }

    public Integer csiRsrp() {
        return this.csiRsrp;
    }

    public CellInfoMetric csiRsrq(Integer num) {
        this.csiRsrq = num;
        return this;
    }

    public Integer csiRsrq() {
        return this.csiRsrq;
    }

    public CellInfoMetric csiSinr(Integer num) {
        this.csiSinr = num;
        return this;
    }

    public Integer csiSinr() {
        return this.csiSinr;
    }

    public int dataSimSlotNumber() {
        return this.dataSimSlotNumber;
    }

    public CellInfoMetric dataSimSlotNumber(int i) {
        this.dataSimSlotNumber = i;
        return this;
    }

    public CellInfoMetric dateTimeOfMeasurement(String str) {
        this.dateTimeOfMeasurement = str;
        return this;
    }

    public String dateTimeOfMeasurement() {
        return this.dateTimeOfMeasurement;
    }

    public CellInfoMetric dbm(Integer num) {
        this.dbm = num;
        return this;
    }

    public Integer dbm() {
        return this.dbm;
    }

    public CellInfoMetric deviceBrand(String str) {
        this.deviceBrand = str;
        return this;
    }

    public String deviceBrand() {
        return this.deviceBrand;
    }

    public CellInfoMetric deviceModel(String str) {
        this.deviceModel = str;
        return this;
    }

    public String deviceModel() {
        return this.deviceModel;
    }

    public CellInfoMetric deviceVersion(String str) {
        this.deviceVersion = str;
        return this;
    }

    public String deviceVersion() {
        return this.deviceVersion;
    }

    public int dozeModeState() {
        return this.dozeModeState;
    }

    public CellInfoMetric dozeModeState(int i) {
        this.dozeModeState = i;
        return this;
    }

    public int duplexModeState() {
        return this.duplexModeState;
    }

    public CellInfoMetric duplexModeState(int i) {
        this.duplexModeState = i;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CellInfoMetric)) {
            return false;
        }
        CellInfoMetric cellInfoMetric = (CellInfoMetric) obj;
        if (!cellInfoMetric.canEqual(this) || id() != cellInfoMetric.id()) {
            return false;
        }
        String mobileClientId2 = mobileClientId();
        String mobileClientId3 = cellInfoMetric.mobileClientId();
        if (mobileClientId2 != null ? !mobileClientId2.equals(mobileClientId3) : mobileClientId3 != null) {
            return false;
        }
        String measurementSequenceId2 = measurementSequenceId();
        String measurementSequenceId3 = cellInfoMetric.measurementSequenceId();
        if (measurementSequenceId2 != null ? !measurementSequenceId2.equals(measurementSequenceId3) : measurementSequenceId3 != null) {
            return false;
        }
        String sdkOrigin2 = sdkOrigin();
        String sdkOrigin3 = cellInfoMetric.sdkOrigin();
        if (sdkOrigin2 != null ? !sdkOrigin2.equals(sdkOrigin3) : sdkOrigin3 != null) {
            return false;
        }
        if (isRegistered() != cellInfoMetric.isRegistered()) {
            return false;
        }
        String dateTimeOfMeasurement2 = dateTimeOfMeasurement();
        String dateTimeOfMeasurement3 = cellInfoMetric.dateTimeOfMeasurement();
        if (dateTimeOfMeasurement2 != null ? !dateTimeOfMeasurement2.equals(dateTimeOfMeasurement3) : dateTimeOfMeasurement3 != null) {
            return false;
        }
        String simMCC2 = simMCC();
        String simMCC3 = cellInfoMetric.simMCC();
        if (simMCC2 != null ? !simMCC2.equals(simMCC3) : simMCC3 != null) {
            return false;
        }
        String simMNC2 = simMNC();
        String simMNC3 = cellInfoMetric.simMNC();
        if (simMNC2 != null ? !simMNC2.equals(simMNC3) : simMNC3 != null) {
            return false;
        }
        String secondarySimMCC2 = secondarySimMCC();
        String secondarySimMCC3 = cellInfoMetric.secondarySimMCC();
        if (secondarySimMCC2 != null ? !secondarySimMCC2.equals(secondarySimMCC3) : secondarySimMCC3 != null) {
            return false;
        }
        String secondarySimMNC2 = secondarySimMNC();
        String secondarySimMNC3 = cellInfoMetric.secondarySimMNC();
        if (secondarySimMNC2 != null ? !secondarySimMNC2.equals(secondarySimMNC3) : secondarySimMNC3 != null) {
            return false;
        }
        if (numberOfSimSlots() != cellInfoMetric.numberOfSimSlots() || dataSimSlotNumber() != cellInfoMetric.dataSimSlotNumber()) {
            return false;
        }
        String networkMCC2 = networkMCC();
        String networkMCC3 = cellInfoMetric.networkMCC();
        if (networkMCC2 != null ? !networkMCC2.equals(networkMCC3) : networkMCC3 != null) {
            return false;
        }
        String networkMNC2 = networkMNC();
        String networkMNC3 = cellInfoMetric.networkMNC();
        if (networkMNC2 != null ? !networkMNC2.equals(networkMNC3) : networkMNC3 != null) {
            return false;
        }
        if (Double.compare(latitude(), cellInfoMetric.latitude()) != 0 || Double.compare(longitude(), cellInfoMetric.longitude()) != 0 || Double.compare(gpsAccuracy(), cellInfoMetric.gpsAccuracy()) != 0) {
            return false;
        }
        String deviceBrand2 = deviceBrand();
        String deviceBrand3 = cellInfoMetric.deviceBrand();
        if (deviceBrand2 != null ? !deviceBrand2.equals(deviceBrand3) : deviceBrand3 != null) {
            return false;
        }
        String deviceModel2 = deviceModel();
        String deviceModel3 = cellInfoMetric.deviceModel();
        if (deviceModel2 != null ? !deviceModel2.equals(deviceModel3) : deviceModel3 != null) {
            return false;
        }
        String deviceVersion2 = deviceVersion();
        String deviceVersion3 = cellInfoMetric.deviceVersion();
        if (deviceVersion2 != null ? !deviceVersion2.equals(deviceVersion3) : deviceVersion3 != null) {
            return false;
        }
        String carrierName2 = carrierName();
        String carrierName3 = cellInfoMetric.carrierName();
        if (carrierName2 != null ? !carrierName2.equals(carrierName3) : carrierName3 != null) {
            return false;
        }
        String secondaryCarrierName2 = secondaryCarrierName();
        String secondaryCarrierName3 = cellInfoMetric.secondaryCarrierName();
        if (secondaryCarrierName2 != null ? !secondaryCarrierName2.equals(secondaryCarrierName3) : secondaryCarrierName3 != null) {
            return false;
        }
        String os2 = os();
        String os3 = cellInfoMetric.os();
        if (os2 != null ? !os2.equals(os3) : os3 != null) {
            return false;
        }
        String osVersion2 = osVersion();
        String osVersion3 = cellInfoMetric.osVersion();
        if (osVersion2 != null ? !osVersion2.equals(osVersion3) : osVersion3 != null) {
            return false;
        }
        if (cellConnectionStatus() != cellInfoMetric.cellConnectionStatus()) {
            return false;
        }
        String cellType2 = cellType();
        String cellType3 = cellInfoMetric.cellType();
        if (cellType2 != null ? !cellType2.equals(cellType3) : cellType3 != null) {
            return false;
        }
        if (age() != cellInfoMetric.age()) {
            return false;
        }
        Integer bandwidth2 = bandwidth();
        Integer bandwidth3 = cellInfoMetric.bandwidth();
        if (bandwidth2 != null ? !bandwidth2.equals(bandwidth3) : bandwidth3 != null) {
            return false;
        }
        String cellId2 = cellId();
        String cellId3 = cellInfoMetric.cellId();
        if (cellId2 != null ? !cellId2.equals(cellId3) : cellId3 != null) {
            return false;
        }
        Integer arfc2 = arfc();
        Integer arfc3 = cellInfoMetric.arfc();
        if (arfc2 != null ? !arfc2.equals(arfc3) : arfc3 != null) {
            return false;
        }
        Integer connectionArfc2 = connectionArfc();
        Integer connectionArfc3 = cellInfoMetric.connectionArfc();
        if (connectionArfc2 != null ? !connectionArfc2.equals(connectionArfc3) : connectionArfc3 != null) {
            return false;
        }
        String cellBands2 = cellBands();
        String cellBands3 = cellInfoMetric.cellBands();
        if (cellBands2 != null ? !cellBands2.equals(cellBands3) : cellBands3 != null) {
            return false;
        }
        Integer pci2 = pci();
        Integer pci3 = cellInfoMetric.pci();
        if (pci2 != null ? !pci2.equals(pci3) : pci3 != null) {
            return false;
        }
        String lac2 = lac();
        String lac3 = cellInfoMetric.lac();
        if (lac2 != null ? !lac2.equals(lac3) : lac3 != null) {
            return false;
        }
        Integer asuLevel2 = asuLevel();
        Integer asuLevel3 = cellInfoMetric.asuLevel();
        if (asuLevel2 != null ? !asuLevel2.equals(asuLevel3) : asuLevel3 != null) {
            return false;
        }
        Integer dbm2 = dbm();
        Integer dbm3 = cellInfoMetric.dbm();
        if (dbm2 != null ? !dbm2.equals(dbm3) : dbm3 != null) {
            return false;
        }
        Integer cqi2 = cqi();
        Integer cqi3 = cellInfoMetric.cqi();
        if (cqi2 != null ? !cqi2.equals(cqi3) : cqi3 != null) {
            return false;
        }
        Integer level2 = level();
        Integer level3 = cellInfoMetric.level();
        if (level2 != null ? !level2.equals(level3) : level3 != null) {
            return false;
        }
        Integer rsrp2 = rsrp();
        Integer rsrp3 = cellInfoMetric.rsrp();
        if (rsrp2 != null ? !rsrp2.equals(rsrp3) : rsrp3 != null) {
            return false;
        }
        Integer rsrq2 = rsrq();
        Integer rsrq3 = cellInfoMetric.rsrq();
        if (rsrq2 != null ? !rsrq2.equals(rsrq3) : rsrq3 != null) {
            return false;
        }
        Integer rssi2 = rssi();
        Integer rssi3 = cellInfoMetric.rssi();
        if (rssi2 != null ? !rssi2.equals(rssi3) : rssi3 != null) {
            return false;
        }
        Integer rssnr2 = rssnr();
        Integer rssnr3 = cellInfoMetric.rssnr();
        if (rssnr2 != null ? !rssnr2.equals(rssnr3) : rssnr3 != null) {
            return false;
        }
        Integer csiRsrp2 = csiRsrp();
        Integer csiRsrp3 = cellInfoMetric.csiRsrp();
        if (csiRsrp2 != null ? !csiRsrp2.equals(csiRsrp3) : csiRsrp3 != null) {
            return false;
        }
        Integer csiSinr2 = csiSinr();
        Integer csiSinr3 = cellInfoMetric.csiSinr();
        if (csiSinr2 != null ? !csiSinr2.equals(csiSinr3) : csiSinr3 != null) {
            return false;
        }
        Integer csiRsrq2 = csiRsrq();
        Integer csiRsrq3 = cellInfoMetric.csiRsrq();
        if (csiRsrq2 != null ? !csiRsrq2.equals(csiRsrq3) : csiRsrq3 != null) {
            return false;
        }
        Integer ssRsrp2 = ssRsrp();
        Integer ssRsrp3 = cellInfoMetric.ssRsrp();
        if (ssRsrp2 != null ? !ssRsrp2.equals(ssRsrp3) : ssRsrp3 != null) {
            return false;
        }
        Integer ssRsrq2 = ssRsrq();
        Integer ssRsrq3 = cellInfoMetric.ssRsrq();
        if (ssRsrq2 != null ? !ssRsrq2.equals(ssRsrq3) : ssRsrq3 != null) {
            return false;
        }
        Integer ssSinr2 = ssSinr();
        Integer ssSinr3 = cellInfoMetric.ssSinr();
        if (ssSinr2 != null ? !ssSinr2.equals(ssSinr3) : ssSinr3 != null) {
            return false;
        }
        Integer timingAdvance2 = timingAdvance();
        Integer timingAdvance3 = cellInfoMetric.timingAdvance();
        if (timingAdvance2 != null ? !timingAdvance2.equals(timingAdvance3) : timingAdvance3 != null) {
            return false;
        }
        Boolean isDcNrRestricted2 = isDcNrRestricted();
        Boolean isDcNrRestricted3 = cellInfoMetric.isDcNrRestricted();
        if (isDcNrRestricted2 != null ? !isDcNrRestricted2.equals(isDcNrRestricted3) : isDcNrRestricted3 != null) {
            return false;
        }
        Boolean isNrAvailable2 = isNrAvailable();
        Boolean isNrAvailable3 = cellInfoMetric.isNrAvailable();
        if (isNrAvailable2 != null ? !isNrAvailable2.equals(isNrAvailable3) : isNrAvailable3 != null) {
            return false;
        }
        Boolean isEnDcAvailable2 = isEnDcAvailable();
        Boolean isEnDcAvailable3 = cellInfoMetric.isEnDcAvailable();
        if (isEnDcAvailable2 != null ? !isEnDcAvailable2.equals(isEnDcAvailable3) : isEnDcAvailable3 != null) {
            return false;
        }
        String nrState2 = nrState();
        String nrState3 = cellInfoMetric.nrState();
        if (nrState2 != null ? !nrState2.equals(nrState3) : nrState3 != null) {
            return false;
        }
        Integer nrFrequencyRange2 = nrFrequencyRange();
        Integer nrFrequencyRange3 = cellInfoMetric.nrFrequencyRange();
        if (nrFrequencyRange2 != null ? !nrFrequencyRange2.equals(nrFrequencyRange3) : nrFrequencyRange3 != null) {
            return false;
        }
        Boolean isUsingCarrierAggregation2 = isUsingCarrierAggregation();
        Boolean isUsingCarrierAggregation3 = cellInfoMetric.isUsingCarrierAggregation();
        if (isUsingCarrierAggregation2 != null ? !isUsingCarrierAggregation2.equals(isUsingCarrierAggregation3) : isUsingCarrierAggregation3 != null) {
            return false;
        }
        Integer vopsSupport2 = vopsSupport();
        Integer vopsSupport3 = cellInfoMetric.vopsSupport();
        if (vopsSupport2 != null ? !vopsSupport2.equals(vopsSupport3) : vopsSupport3 != null) {
            return false;
        }
        String cellBandwidths2 = cellBandwidths();
        String cellBandwidths3 = cellInfoMetric.cellBandwidths();
        if (cellBandwidths2 != null ? !cellBandwidths2.equals(cellBandwidths3) : cellBandwidths3 != null) {
            return false;
        }
        String additionalPlmns2 = additionalPlmns();
        String additionalPlmns3 = cellInfoMetric.additionalPlmns();
        if (additionalPlmns2 != null ? !additionalPlmns2.equals(additionalPlmns3) : additionalPlmns3 != null) {
            return false;
        }
        if (Double.compare(altitude(), cellInfoMetric.altitude()) != 0) {
            return false;
        }
        Float locationSpeed2 = locationSpeed();
        Float locationSpeed3 = cellInfoMetric.locationSpeed();
        if (locationSpeed2 != null ? !locationSpeed2.equals(locationSpeed3) : locationSpeed3 != null) {
            return false;
        }
        Float locationSpeedAccuracy2 = locationSpeedAccuracy();
        Float locationSpeedAccuracy3 = cellInfoMetric.locationSpeedAccuracy();
        if (locationSpeedAccuracy2 != null ? !locationSpeedAccuracy2.equals(locationSpeedAccuracy3) : locationSpeedAccuracy3 != null) {
            return false;
        }
        if (locationAge() != cellInfoMetric.locationAge()) {
            return false;
        }
        String sdkVersionNumber2 = sdkVersionNumber();
        String sdkVersionNumber3 = cellInfoMetric.sdkVersionNumber();
        if (sdkVersionNumber2 != null ? !sdkVersionNumber2.equals(sdkVersionNumber3) : sdkVersionNumber3 != null) {
            return false;
        }
        Integer wcdmaEcNo2 = wcdmaEcNo();
        Integer wcdmaEcNo3 = cellInfoMetric.wcdmaEcNo();
        if (wcdmaEcNo2 != null ? !wcdmaEcNo2.equals(wcdmaEcNo3) : wcdmaEcNo3 != null) {
            return false;
        }
        String networkOperatorName2 = networkOperatorName();
        String networkOperatorName3 = cellInfoMetric.networkOperatorName();
        if (networkOperatorName2 != null ? !networkOperatorName2.equals(networkOperatorName3) : networkOperatorName3 != null) {
            return false;
        }
        if (stateDuringMeasurement() != cellInfoMetric.stateDuringMeasurement()) {
            return false;
        }
        Integer overrideNetworkType2 = overrideNetworkType();
        Integer overrideNetworkType3 = cellInfoMetric.overrideNetworkType();
        if (overrideNetworkType2 != null ? !overrideNetworkType2.equals(overrideNetworkType3) : overrideNetworkType3 != null) {
            return false;
        }
        Integer accessNetworkTechnologyRaw2 = accessNetworkTechnologyRaw();
        Integer accessNetworkTechnologyRaw3 = cellInfoMetric.accessNetworkTechnologyRaw();
        if (accessNetworkTechnologyRaw2 != null ? !accessNetworkTechnologyRaw2.equals(accessNetworkTechnologyRaw3) : accessNetworkTechnologyRaw3 != null) {
            return false;
        }
        Boolean anonymize2 = anonymize();
        Boolean anonymize3 = cellInfoMetric.anonymize();
        if (anonymize2 != null ? !anonymize2.equals(anonymize3) : anonymize3 != null) {
            return false;
        }
        Boolean isRooted2 = isRooted();
        Boolean isRooted3 = cellInfoMetric.isRooted();
        if (isRooted2 != null ? !isRooted2.equals(isRooted3) : isRooted3 != null) {
            return false;
        }
        Boolean isConnectedToVpn2 = isConnectedToVpn();
        Boolean isConnectedToVpn3 = cellInfoMetric.isConnectedToVpn();
        if (isConnectedToVpn2 != null ? !isConnectedToVpn2.equals(isConnectedToVpn3) : isConnectedToVpn3 != null) {
            return false;
        }
        Float gpsVerticalAccuracy2 = gpsVerticalAccuracy();
        Float gpsVerticalAccuracy3 = cellInfoMetric.gpsVerticalAccuracy();
        if (gpsVerticalAccuracy2 != null ? !gpsVerticalAccuracy2.equals(gpsVerticalAccuracy3) : gpsVerticalAccuracy3 != null) {
            return false;
        }
        if (getRestrictBackgroundStatus() != cellInfoMetric.getRestrictBackgroundStatus()) {
            return false;
        }
        Boolean isDefaultNetworkActive2 = isDefaultNetworkActive();
        Boolean isDefaultNetworkActive3 = cellInfoMetric.isDefaultNetworkActive();
        if (isDefaultNetworkActive2 != null ? !isDefaultNetworkActive2.equals(isDefaultNetworkActive3) : isDefaultNetworkActive3 != null) {
            return false;
        }
        Boolean isActiveNetworkMetered2 = isActiveNetworkMetered();
        Boolean isActiveNetworkMetered3 = cellInfoMetric.isActiveNetworkMetered();
        if (isActiveNetworkMetered2 != null ? !isActiveNetworkMetered2.equals(isActiveNetworkMetered3) : isActiveNetworkMetered3 != null) {
            return false;
        }
        Boolean isOnScreen2 = isOnScreen();
        Boolean isOnScreen3 = cellInfoMetric.isOnScreen();
        if (isOnScreen2 != null ? !isOnScreen2.equals(isOnScreen3) : isOnScreen3 != null) {
            return false;
        }
        Boolean isRoaming2 = isRoaming();
        Boolean isRoaming3 = cellInfoMetric.isRoaming();
        if (isRoaming2 != null ? !isRoaming2.equals(isRoaming3) : isRoaming3 != null) {
            return false;
        }
        if (latencyType() != cellInfoMetric.latencyType()) {
            return false;
        }
        String serverIp2 = serverIp();
        String serverIp3 = cellInfoMetric.serverIp();
        if (serverIp2 != null ? !serverIp2.equals(serverIp3) : serverIp3 != null) {
            return false;
        }
        String privateIp2 = privateIp();
        String privateIp3 = cellInfoMetric.privateIp();
        if (privateIp2 != null ? !privateIp2.equals(privateIp3) : privateIp3 != null) {
            return false;
        }
        String gatewayIp2 = gatewayIp();
        String gatewayIp3 = cellInfoMetric.gatewayIp();
        if (gatewayIp2 != null ? !gatewayIp2.equals(gatewayIp3) : gatewayIp3 != null) {
            return false;
        }
        Integer locationPermissionState2 = locationPermissionState();
        Integer locationPermissionState3 = cellInfoMetric.locationPermissionState();
        if (locationPermissionState2 != null ? !locationPermissionState2.equals(locationPermissionState3) : locationPermissionState3 != null) {
            return false;
        }
        Boolean isReadPhoneStatePermissionGranted2 = isReadPhoneStatePermissionGranted();
        Boolean isReadPhoneStatePermissionGranted3 = cellInfoMetric.isReadPhoneStatePermissionGranted();
        if (isReadPhoneStatePermissionGranted2 != null ? !isReadPhoneStatePermissionGranted2.equals(isReadPhoneStatePermissionGranted3) : isReadPhoneStatePermissionGranted3 != null) {
            return false;
        }
        if (isSending() != cellInfoMetric.isSending()) {
            return false;
        }
        String appVersionName2 = appVersionName();
        String appVersionName3 = cellInfoMetric.appVersionName();
        if (appVersionName2 != null ? !appVersionName2.equals(appVersionName3) : appVersionName3 != null) {
            return false;
        }
        if (appVersionCode() != cellInfoMetric.appVersionCode() || appLastUpdateTime() != cellInfoMetric.appLastUpdateTime() || duplexModeState() != cellInfoMetric.duplexModeState() || dozeModeState() != cellInfoMetric.dozeModeState() || callState() != cellInfoMetric.callState()) {
            return false;
        }
        String buildDevice2 = buildDevice();
        String buildDevice3 = cellInfoMetric.buildDevice();
        if (buildDevice2 != null ? !buildDevice2.equals(buildDevice3) : buildDevice3 != null) {
            return false;
        }
        String buildHardware2 = buildHardware();
        String buildHardware3 = cellInfoMetric.buildHardware();
        if (buildHardware2 != null ? !buildHardware2.equals(buildHardware3) : buildHardware3 != null) {
            return false;
        }
        String buildProduct2 = buildProduct();
        String buildProduct3 = cellInfoMetric.buildProduct();
        if (buildProduct2 != null ? !buildProduct2.equals(buildProduct3) : buildProduct3 != null) {
            return false;
        }
        String appId2 = appId();
        String appId3 = cellInfoMetric.appId();
        return appId2 != null ? appId2.equals(appId3) : appId3 == null;
    }

    public void fill(CellInfo cellInfo) {
        Set additionalPlmns2;
        String str;
        String str2;
        Set additionalPlmns3;
        String str3;
        int i = Build.VERSION.SDK_INT;
        this.isRegistered = cellInfo.isRegistered();
        this.age = (SystemClock.elapsedRealtime() - (cellInfo.getTimeStamp() / 1000000)) / 1000;
        if (cellInfo instanceof CellInfoGsm) {
            this.cellType = "GSM";
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            if (i >= 28) {
                this.cellConnectionStatus = cellInfoGsm.getCellConnectionStatus();
            }
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            CellSignalStrengthGsm cellSignalStrength = cellInfoGsm.getCellSignalStrength();
            if (i >= 24) {
                this.arfc = Integer.valueOf(cellIdentity.getArfcn());
            }
            if (i >= 26) {
                this.timingAdvance = Integer.valueOf(cellSignalStrength.getTimingAdvance());
            }
            this.asuLevel = Integer.valueOf(cellSignalStrength.getAsuLevel());
            this.dbm = Integer.valueOf(cellSignalStrength.getDbm());
            this.level = Integer.valueOf(cellSignalStrength.getLevel());
            this.cellId = String.valueOf(cellIdentity.getCid());
            if (i >= 28) {
                this.networkMCC = cellIdentity.getMccString();
                str3 = cellIdentity.getMncString();
            } else {
                this.networkMCC = String.valueOf(cellIdentity.getMcc());
                str3 = String.valueOf(cellIdentity.getMnc());
            }
            this.networkMNC = str3;
            this.lac = String.valueOf(cellIdentity.getLac());
            if (i >= 30) {
                Set additionalPlmns4 = cellIdentity.getAdditionalPlmns();
                if (additionalPlmns4 != null && !additionalPlmns4.isEmpty()) {
                    this.additionalPlmns = additionalPlmns4.toString();
                }
                this.rssi = Integer.valueOf(cellSignalStrength.getRssi());
            }
        }
        if (cellInfo instanceof CellInfoWcdma) {
            this.cellType = "WCDMA";
            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
            if (i >= 28) {
                this.cellConnectionStatus = cellInfoWcdma.getCellConnectionStatus();
            }
            CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
            CellSignalStrengthWcdma cellSignalStrength2 = cellInfoWcdma.getCellSignalStrength();
            if (i >= 30) {
                this.wcdmaEcNo = Integer.valueOf(cellSignalStrength2.getEcNo());
            }
            if (i >= 24) {
                this.arfc = Integer.valueOf(cellIdentity2.getUarfcn());
            }
            this.asuLevel = Integer.valueOf(cellSignalStrength2.getAsuLevel());
            this.dbm = Integer.valueOf(cellSignalStrength2.getDbm());
            this.level = Integer.valueOf(cellSignalStrength2.getLevel());
            this.cellId = String.valueOf(cellIdentity2.getCid());
            if (i >= 28) {
                this.networkMCC = cellIdentity2.getMccString();
                str2 = cellIdentity2.getMncString();
            } else {
                this.networkMCC = String.valueOf(cellIdentity2.getMcc());
                str2 = String.valueOf(cellIdentity2.getMnc());
            }
            this.networkMNC = str2;
            this.lac = String.valueOf(cellIdentity2.getLac());
            if (i >= 30 && (additionalPlmns3 = cellIdentity2.getAdditionalPlmns()) != null && !additionalPlmns3.isEmpty()) {
                this.additionalPlmns = additionalPlmns3.toString();
            }
        }
        if (cellInfo instanceof CellInfoLte) {
            this.cellType = "LTE";
            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
            if (i >= 28) {
                this.cellConnectionStatus = cellInfoLte.getCellConnectionStatus();
            }
            CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
            CellSignalStrengthLte cellSignalStrength3 = cellInfoLte.getCellSignalStrength();
            this.pci = Integer.valueOf(cellIdentity3.getPci());
            if (i >= 24) {
                this.arfc = Integer.valueOf(cellIdentity3.getEarfcn());
            }
            if (i >= 30) {
                Set additionalPlmns5 = cellIdentity3.getAdditionalPlmns();
                if (additionalPlmns5 != null && !additionalPlmns5.isEmpty()) {
                    this.additionalPlmns = additionalPlmns5.toString();
                }
                this.rssi = Integer.valueOf(cellSignalStrength3.getRssi());
            }
            if (i >= 30 && cellIdentity3.getBands().length > 0) {
                this.cellBands = Arrays.toString(cellIdentity3.getBands());
            }
            if (i >= 26) {
                this.cqi = Integer.valueOf(cellSignalStrength3.getCqi());
            }
            if (i >= 26) {
                this.rssnr = Integer.valueOf(cellSignalStrength3.getRssnr());
            }
            if (i >= 26) {
                this.rsrp = Integer.valueOf(cellSignalStrength3.getRsrp());
            }
            if (i >= 26) {
                this.rsrq = Integer.valueOf(cellSignalStrength3.getRsrq());
            }
            this.timingAdvance = Integer.valueOf(cellSignalStrength3.getTimingAdvance());
            this.asuLevel = Integer.valueOf(cellSignalStrength3.getAsuLevel());
            this.dbm = Integer.valueOf(cellSignalStrength3.getDbm());
            this.level = Integer.valueOf(cellSignalStrength3.getLevel());
            this.cellId = String.valueOf(cellIdentity3.getCi());
            if (i >= 28) {
                this.bandwidth = Integer.valueOf(cellIdentity3.getBandwidth());
            }
            if (i >= 28) {
                this.networkMCC = cellIdentity3.getMccString();
                str = cellIdentity3.getMncString();
            } else {
                this.networkMCC = String.valueOf(cellIdentity3.getMcc());
                str = String.valueOf(cellIdentity3.getMnc());
            }
            this.networkMNC = str;
            this.lac = String.valueOf(cellIdentity3.getTac());
        }
        if (i >= 29) {
            try {
                if (cellInfo instanceof CellInfoNr) {
                    this.cellType = "5G";
                    CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
                    this.cellConnectionStatus = cellInfoNr.getCellConnectionStatus();
                    CellIdentity cellIdentity4 = cellInfoNr.getCellIdentity();
                    CellSignalStrength cellSignalStrength4 = cellInfoNr.getCellSignalStrength();
                    if (cellIdentity4 instanceof CellIdentityNr) {
                        CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity4;
                        this.pci = Integer.valueOf(cellIdentityNr.getPci());
                        this.arfc = Integer.valueOf(cellIdentityNr.getNrarfcn());
                        this.cellId = String.valueOf(cellIdentityNr.getNci());
                        this.networkMCC = cellIdentityNr.getMccString();
                        this.networkMNC = cellIdentityNr.getMncString();
                        this.lac = String.valueOf(cellIdentityNr.getTac());
                        if (i >= 30 && (additionalPlmns2 = cellIdentityNr.getAdditionalPlmns()) != null && !additionalPlmns2.isEmpty()) {
                            this.additionalPlmns = additionalPlmns2.toString();
                        }
                    }
                    if (cellSignalStrength4 instanceof CellSignalStrengthNr) {
                        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellSignalStrength4;
                        this.csiSinr = Integer.valueOf(cellSignalStrengthNr.getCsiSinr());
                        this.csiRsrp = Integer.valueOf(cellSignalStrengthNr.getCsiRsrp());
                        this.csiRsrq = Integer.valueOf(cellSignalStrengthNr.getCsiRsrq());
                        this.ssSinr = Integer.valueOf(cellSignalStrengthNr.getSsSinr());
                        this.ssRsrp = Integer.valueOf(cellSignalStrengthNr.getSsRsrp());
                        this.ssRsrq = Integer.valueOf(cellSignalStrengthNr.getSsRsrq());
                        this.asuLevel = Integer.valueOf(cellSignalStrengthNr.getAsuLevel());
                        this.dbm = Integer.valueOf(cellSignalStrengthNr.getDbm());
                        this.level = Integer.valueOf(cellSignalStrengthNr.getLevel());
                    }
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
        if (cellInfo instanceof CellInfoCdma) {
            this.cellType = "CDMA";
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            if (Build.VERSION.SDK_INT >= 28) {
                this.cellConnectionStatus = cellInfoCdma.getCellConnectionStatus();
            }
            CellIdentityCdma cellIdentity5 = cellInfoCdma.getCellIdentity();
            CellSignalStrengthCdma cellSignalStrength5 = cellInfoCdma.getCellSignalStrength();
            this.asuLevel = Integer.valueOf(cellSignalStrength5.getAsuLevel());
            this.dbm = Integer.valueOf(cellSignalStrength5.getDbm());
            this.level = Integer.valueOf(cellSignalStrength5.getLevel());
            this.cellId = String.valueOf(cellIdentity5.getBasestationId());
        }
        ServiceState serviceState = TelephonyHelper.b().c;
        if (serviceState != null && Build.VERSION.SDK_INT >= 28) {
            this.connectionArfc = Integer.valueOf(serviceState.getChannelNumber());
        }
    }

    public void fill(BaseMetric baseMetric) {
        String str;
        this.dateTimeOfMeasurement = String.valueOf(System.currentTimeMillis() / 1000);
        String str2 = baseMetric.mobileClientId;
        if (str2 != null && this.mobileClientId == null) {
            this.mobileClientId = str2;
        }
        Boolean bool = baseMetric.anonymize;
        if (bool != null) {
            this.anonymize = bool;
        }
        String str3 = baseMetric.sdkOrigin;
        if (str3 != null) {
            this.sdkOrigin = str3;
        }
        String str4 = baseMetric.simMNC;
        if (str4 != null) {
            this.simMNC = str4;
        }
        String str5 = baseMetric.simMCC;
        if (str5 != null) {
            this.simMCC = str5;
        }
        double d = baseMetric.latitude;
        if (d != 0.0d) {
            this.latitude = d;
        }
        double d2 = baseMetric.longitude;
        if (d2 != 0.0d) {
            this.longitude = d2;
        }
        double d3 = baseMetric.gpsAccuracy;
        if (d3 > 0.0d) {
            this.gpsAccuracy = d3;
        }
        String str6 = baseMetric.deviceBrand;
        if (str6 != null) {
            this.deviceBrand = str6;
        }
        String str7 = baseMetric.deviceModel;
        if (str7 != null) {
            this.deviceModel = str7;
        }
        String str8 = baseMetric.deviceVersion;
        if (str8 != null) {
            this.deviceVersion = str8;
        }
        String str9 = baseMetric.carrierName;
        if (str9 != null && this.carrierName == null) {
            this.carrierName = str9;
        }
        String str10 = baseMetric.os;
        if (str10 != null) {
            this.os = str10;
        }
        String str11 = baseMetric.osVersion;
        if (str11 != null) {
            this.osVersion = str11;
        }
        String str12 = baseMetric.secondarySimMCC;
        if (str12 != null && this.secondarySimMCC == null) {
            this.secondarySimMCC = str12;
        }
        String str13 = baseMetric.secondarySimMNC;
        if (str13 != null && this.secondarySimMNC == null) {
            this.secondarySimMNC = str13;
        }
        String str14 = baseMetric.secondaryCarrierName;
        if (str14 != null && this.secondaryCarrierName == null) {
            this.secondaryCarrierName = str14;
        }
        int i = baseMetric.numberOfSimSlots;
        if (i > 0) {
            this.numberOfSimSlots = i;
        }
        int i2 = baseMetric.dataSimSlotNumber;
        if (i2 > 0) {
            this.dataSimSlotNumber = i2;
        }
        String str15 = baseMetric.sdkVersionNumber;
        if (str15 != null) {
            this.sdkVersionNumber = str15;
        }
        if (this.isRegistered) {
            Boolean bool2 = baseMetric.isDcNrRestricted;
            if (bool2 != null && this.isDcNrRestricted == null) {
                this.isDcNrRestricted = bool2;
            }
            Boolean bool3 = baseMetric.isNrAvailable;
            if (bool3 != null && this.isNrAvailable == null) {
                this.isNrAvailable = bool3;
            }
            Boolean bool4 = baseMetric.isEnDcAvailable;
            if (bool4 != null && this.isEnDcAvailable == null) {
                this.isEnDcAvailable = bool4;
            }
            String str16 = baseMetric.nrState;
            if (str16 != null && this.nrState == null) {
                this.nrState = str16;
            }
            Integer num = baseMetric.nrFrequencyRange;
            if (num != null && this.nrFrequencyRange == null) {
                this.nrFrequencyRange = num;
            }
            Boolean bool5 = baseMetric.isUsingCarrierAggregation;
            if (bool5 != null && this.isUsingCarrierAggregation == null) {
                this.isUsingCarrierAggregation = bool5;
            }
            Integer num2 = baseMetric.vopsSupport;
            if (num2 != null && this.vopsSupport == null) {
                this.vopsSupport = num2;
            }
            String str17 = baseMetric.cellBandwidths;
            if (str17 != null && this.cellBandwidths == null) {
                this.cellBandwidths = str17;
            }
            if (baseMetric.additionalPlmns != null && ((str = this.additionalPlmns) == null || str.isEmpty())) {
                this.additionalPlmns = baseMetric.additionalPlmns;
            }
        }
        this.altitude = baseMetric.altitude;
        Float f = baseMetric.locationSpeed;
        if (f != null) {
            this.locationSpeed = f;
        }
        Float f2 = baseMetric.locationSpeedAccuracy;
        if (f2 != null) {
            this.locationSpeedAccuracy = f2;
        }
        int i3 = baseMetric.locationAge;
        if (i3 > 0) {
            this.locationAge = i3;
        }
        String str18 = baseMetric.networkOperatorName;
        if (str18 != null && this.networkOperatorName == null) {
            this.networkOperatorName = str18;
        }
        int i4 = baseMetric.stateDuringMeasurement;
        if (i4 > this.stateDuringMeasurement) {
            this.stateDuringMeasurement = i4;
        }
        Integer num3 = baseMetric.overrideNetworkType;
        if (num3 != null && this.overrideNetworkType == null) {
            this.overrideNetworkType = num3;
        }
        Integer num4 = baseMetric.accessNetworkTechnologyRaw;
        if (num4 != null && this.accessNetworkTechnologyRaw == null) {
            this.accessNetworkTechnologyRaw = num4;
        }
        Boolean bool6 = baseMetric.isConnectedToVpn;
        if (bool6 != null) {
            this.isConnectedToVpn = bool6;
        }
        Float f3 = baseMetric.gpsVerticalAccuracy;
        if (f3 != null) {
            this.gpsVerticalAccuracy = f3;
        }
        int i5 = baseMetric.getRestrictBackgroundStatus;
        if (i5 > this.getRestrictBackgroundStatus) {
            this.getRestrictBackgroundStatus = i5;
        }
        String str19 = baseMetric.cellType;
        if (str19 != null && this.cellType == null) {
            this.cellType = str19;
        }
        Boolean bool7 = baseMetric.isDefaultNetworkActive;
        if (bool7 != null && this.isDefaultNetworkActive == null) {
            this.isDefaultNetworkActive = bool7;
        }
        Boolean bool8 = baseMetric.isActiveNetworkMetered;
        if (bool8 != null && this.isActiveNetworkMetered == null) {
            this.isActiveNetworkMetered = bool8;
        }
        Boolean bool9 = baseMetric.isOnScreen;
        if (bool9 != null) {
            this.isOnScreen = bool9;
        }
        Boolean bool10 = baseMetric.isRoaming;
        if (bool10 != null && this.isRoaming == null) {
            this.isRoaming = bool10;
        }
        int i6 = baseMetric.latencyType;
        if (i6 > this.latencyType) {
            this.latencyType = i6;
        }
        String str20 = baseMetric.serverIp;
        if (str20 != null) {
            this.serverIp = str20;
        }
        String str21 = baseMetric.privateIp;
        if (str21 != null) {
            this.privateIp = str21;
        }
        String str22 = baseMetric.gatewayIp;
        if (str22 != null) {
            this.gatewayIp = str22;
        }
        this.locationPermissionState = baseMetric.locationPermissionState;
        this.isReadPhoneStatePermissionGranted = baseMetric.isReadPhoneStatePermissionGranted;
        this.appVersionName = baseMetric.appVersionName;
        this.appVersionCode = baseMetric.appVersionCode;
        this.appLastUpdateTime = baseMetric.appLastUpdateTime;
        this.duplexModeState = baseMetric.duplexModeState;
        this.dozeModeState = baseMetric.dozeModeState;
        this.callState = baseMetric.callState;
        this.buildDevice = baseMetric.buildDevice;
        this.buildHardware = baseMetric.buildHardware;
        this.buildProduct = baseMetric.buildProduct;
        this.appId = baseMetric.appId;
        this.isRooted = baseMetric.isRooted;
    }

    public CellInfoMetric gatewayIp(String str) {
        this.gatewayIp = str;
        return this;
    }

    public String gatewayIp() {
        return this.gatewayIp;
    }

    public int getRestrictBackgroundStatus() {
        return this.getRestrictBackgroundStatus;
    }

    public CellInfoMetric getRestrictBackgroundStatus(int i) {
        this.getRestrictBackgroundStatus = i;
        return this;
    }

    public double gpsAccuracy() {
        return this.gpsAccuracy;
    }

    public CellInfoMetric gpsAccuracy(double d) {
        this.gpsAccuracy = d;
        return this;
    }

    public CellInfoMetric gpsVerticalAccuracy(Float f) {
        this.gpsVerticalAccuracy = f;
        return this;
    }

    public Float gpsVerticalAccuracy() {
        return this.gpsVerticalAccuracy;
    }

    public int hashCode() {
        long id2 = id();
        String mobileClientId2 = mobileClientId();
        int i = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (mobileClientId2 == null ? 43 : mobileClientId2.hashCode());
        String measurementSequenceId2 = measurementSequenceId();
        int hashCode2 = (hashCode * 59) + (measurementSequenceId2 == null ? 43 : measurementSequenceId2.hashCode());
        String sdkOrigin2 = sdkOrigin();
        int i2 = 79;
        int hashCode3 = (((hashCode2 * 59) + (sdkOrigin2 == null ? 43 : sdkOrigin2.hashCode())) * 59) + (isRegistered() ? 79 : 97);
        String dateTimeOfMeasurement2 = dateTimeOfMeasurement();
        int hashCode4 = (hashCode3 * 59) + (dateTimeOfMeasurement2 == null ? 43 : dateTimeOfMeasurement2.hashCode());
        String simMCC2 = simMCC();
        int hashCode5 = (hashCode4 * 59) + (simMCC2 == null ? 43 : simMCC2.hashCode());
        String simMNC2 = simMNC();
        int hashCode6 = (hashCode5 * 59) + (simMNC2 == null ? 43 : simMNC2.hashCode());
        String secondarySimMCC2 = secondarySimMCC();
        int hashCode7 = (hashCode6 * 59) + (secondarySimMCC2 == null ? 43 : secondarySimMCC2.hashCode());
        String secondarySimMNC2 = secondarySimMNC();
        int hashCode8 = (((((hashCode7 * 59) + (secondarySimMNC2 == null ? 43 : secondarySimMNC2.hashCode())) * 59) + numberOfSimSlots()) * 59) + dataSimSlotNumber();
        String networkMCC2 = networkMCC();
        int hashCode9 = (hashCode8 * 59) + (networkMCC2 == null ? 43 : networkMCC2.hashCode());
        String networkMNC2 = networkMNC();
        int i3 = hashCode9 * 59;
        int hashCode10 = networkMNC2 == null ? 43 : networkMNC2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(latitude());
        long doubleToLongBits2 = Double.doubleToLongBits(longitude());
        long doubleToLongBits3 = Double.doubleToLongBits(gpsAccuracy());
        int i4 = ((((((i3 + hashCode10) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        String deviceBrand2 = deviceBrand();
        int hashCode11 = (i4 * 59) + (deviceBrand2 == null ? 43 : deviceBrand2.hashCode());
        String deviceModel2 = deviceModel();
        int hashCode12 = (hashCode11 * 59) + (deviceModel2 == null ? 43 : deviceModel2.hashCode());
        String deviceVersion2 = deviceVersion();
        int hashCode13 = (hashCode12 * 59) + (deviceVersion2 == null ? 43 : deviceVersion2.hashCode());
        String carrierName2 = carrierName();
        int hashCode14 = (hashCode13 * 59) + (carrierName2 == null ? 43 : carrierName2.hashCode());
        String secondaryCarrierName2 = secondaryCarrierName();
        int hashCode15 = (hashCode14 * 59) + (secondaryCarrierName2 == null ? 43 : secondaryCarrierName2.hashCode());
        String os2 = os();
        int hashCode16 = (hashCode15 * 59) + (os2 == null ? 43 : os2.hashCode());
        String osVersion2 = osVersion();
        int hashCode17 = (((hashCode16 * 59) + (osVersion2 == null ? 43 : osVersion2.hashCode())) * 59) + cellConnectionStatus();
        String cellType2 = cellType();
        int i5 = hashCode17 * 59;
        int hashCode18 = cellType2 == null ? 43 : cellType2.hashCode();
        long age2 = age();
        int i6 = ((i5 + hashCode18) * 59) + ((int) (age2 ^ (age2 >>> 32)));
        Integer bandwidth2 = bandwidth();
        int hashCode19 = (i6 * 59) + (bandwidth2 == null ? 43 : bandwidth2.hashCode());
        String cellId2 = cellId();
        int hashCode20 = (hashCode19 * 59) + (cellId2 == null ? 43 : cellId2.hashCode());
        Integer arfc2 = arfc();
        int hashCode21 = (hashCode20 * 59) + (arfc2 == null ? 43 : arfc2.hashCode());
        Integer connectionArfc2 = connectionArfc();
        int hashCode22 = (hashCode21 * 59) + (connectionArfc2 == null ? 43 : connectionArfc2.hashCode());
        String cellBands2 = cellBands();
        int hashCode23 = (hashCode22 * 59) + (cellBands2 == null ? 43 : cellBands2.hashCode());
        Integer pci2 = pci();
        int hashCode24 = (hashCode23 * 59) + (pci2 == null ? 43 : pci2.hashCode());
        String lac2 = lac();
        int hashCode25 = (hashCode24 * 59) + (lac2 == null ? 43 : lac2.hashCode());
        Integer asuLevel2 = asuLevel();
        int hashCode26 = (hashCode25 * 59) + (asuLevel2 == null ? 43 : asuLevel2.hashCode());
        Integer dbm2 = dbm();
        int hashCode27 = (hashCode26 * 59) + (dbm2 == null ? 43 : dbm2.hashCode());
        Integer cqi2 = cqi();
        int hashCode28 = (hashCode27 * 59) + (cqi2 == null ? 43 : cqi2.hashCode());
        Integer level2 = level();
        int hashCode29 = (hashCode28 * 59) + (level2 == null ? 43 : level2.hashCode());
        Integer rsrp2 = rsrp();
        int hashCode30 = (hashCode29 * 59) + (rsrp2 == null ? 43 : rsrp2.hashCode());
        Integer rsrq2 = rsrq();
        int hashCode31 = (hashCode30 * 59) + (rsrq2 == null ? 43 : rsrq2.hashCode());
        Integer rssi2 = rssi();
        int hashCode32 = (hashCode31 * 59) + (rssi2 == null ? 43 : rssi2.hashCode());
        Integer rssnr2 = rssnr();
        int hashCode33 = (hashCode32 * 59) + (rssnr2 == null ? 43 : rssnr2.hashCode());
        Integer csiRsrp2 = csiRsrp();
        int hashCode34 = (hashCode33 * 59) + (csiRsrp2 == null ? 43 : csiRsrp2.hashCode());
        Integer csiSinr2 = csiSinr();
        int hashCode35 = (hashCode34 * 59) + (csiSinr2 == null ? 43 : csiSinr2.hashCode());
        Integer csiRsrq2 = csiRsrq();
        int hashCode36 = (hashCode35 * 59) + (csiRsrq2 == null ? 43 : csiRsrq2.hashCode());
        Integer ssRsrp2 = ssRsrp();
        int hashCode37 = (hashCode36 * 59) + (ssRsrp2 == null ? 43 : ssRsrp2.hashCode());
        Integer ssRsrq2 = ssRsrq();
        int hashCode38 = (hashCode37 * 59) + (ssRsrq2 == null ? 43 : ssRsrq2.hashCode());
        Integer ssSinr2 = ssSinr();
        int hashCode39 = (hashCode38 * 59) + (ssSinr2 == null ? 43 : ssSinr2.hashCode());
        Integer timingAdvance2 = timingAdvance();
        int hashCode40 = (hashCode39 * 59) + (timingAdvance2 == null ? 43 : timingAdvance2.hashCode());
        Boolean isDcNrRestricted2 = isDcNrRestricted();
        int hashCode41 = (hashCode40 * 59) + (isDcNrRestricted2 == null ? 43 : isDcNrRestricted2.hashCode());
        Boolean isNrAvailable2 = isNrAvailable();
        int hashCode42 = (hashCode41 * 59) + (isNrAvailable2 == null ? 43 : isNrAvailable2.hashCode());
        Boolean isEnDcAvailable2 = isEnDcAvailable();
        int hashCode43 = (hashCode42 * 59) + (isEnDcAvailable2 == null ? 43 : isEnDcAvailable2.hashCode());
        String nrState2 = nrState();
        int hashCode44 = (hashCode43 * 59) + (nrState2 == null ? 43 : nrState2.hashCode());
        Integer nrFrequencyRange2 = nrFrequencyRange();
        int hashCode45 = (hashCode44 * 59) + (nrFrequencyRange2 == null ? 43 : nrFrequencyRange2.hashCode());
        Boolean isUsingCarrierAggregation2 = isUsingCarrierAggregation();
        int hashCode46 = (hashCode45 * 59) + (isUsingCarrierAggregation2 == null ? 43 : isUsingCarrierAggregation2.hashCode());
        Integer vopsSupport2 = vopsSupport();
        int hashCode47 = (hashCode46 * 59) + (vopsSupport2 == null ? 43 : vopsSupport2.hashCode());
        String cellBandwidths2 = cellBandwidths();
        int hashCode48 = (hashCode47 * 59) + (cellBandwidths2 == null ? 43 : cellBandwidths2.hashCode());
        String additionalPlmns2 = additionalPlmns();
        int i7 = hashCode48 * 59;
        int hashCode49 = additionalPlmns2 == null ? 43 : additionalPlmns2.hashCode();
        long doubleToLongBits4 = Double.doubleToLongBits(altitude());
        int i8 = ((i7 + hashCode49) * 59) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        Float locationSpeed2 = locationSpeed();
        int hashCode50 = (i8 * 59) + (locationSpeed2 == null ? 43 : locationSpeed2.hashCode());
        Float locationSpeedAccuracy2 = locationSpeedAccuracy();
        int hashCode51 = (((hashCode50 * 59) + (locationSpeedAccuracy2 == null ? 43 : locationSpeedAccuracy2.hashCode())) * 59) + locationAge();
        String sdkVersionNumber2 = sdkVersionNumber();
        int hashCode52 = (hashCode51 * 59) + (sdkVersionNumber2 == null ? 43 : sdkVersionNumber2.hashCode());
        Integer wcdmaEcNo2 = wcdmaEcNo();
        int hashCode53 = (hashCode52 * 59) + (wcdmaEcNo2 == null ? 43 : wcdmaEcNo2.hashCode());
        String networkOperatorName2 = networkOperatorName();
        int hashCode54 = (((hashCode53 * 59) + (networkOperatorName2 == null ? 43 : networkOperatorName2.hashCode())) * 59) + stateDuringMeasurement();
        Integer overrideNetworkType2 = overrideNetworkType();
        int hashCode55 = (hashCode54 * 59) + (overrideNetworkType2 == null ? 43 : overrideNetworkType2.hashCode());
        Integer accessNetworkTechnologyRaw2 = accessNetworkTechnologyRaw();
        int hashCode56 = (hashCode55 * 59) + (accessNetworkTechnologyRaw2 == null ? 43 : accessNetworkTechnologyRaw2.hashCode());
        Boolean anonymize2 = anonymize();
        int hashCode57 = (hashCode56 * 59) + (anonymize2 == null ? 43 : anonymize2.hashCode());
        Boolean isRooted2 = isRooted();
        int hashCode58 = (hashCode57 * 59) + (isRooted2 == null ? 43 : isRooted2.hashCode());
        Boolean isConnectedToVpn2 = isConnectedToVpn();
        int hashCode59 = (hashCode58 * 59) + (isConnectedToVpn2 == null ? 43 : isConnectedToVpn2.hashCode());
        Float gpsVerticalAccuracy2 = gpsVerticalAccuracy();
        int hashCode60 = (((hashCode59 * 59) + (gpsVerticalAccuracy2 == null ? 43 : gpsVerticalAccuracy2.hashCode())) * 59) + getRestrictBackgroundStatus();
        Boolean isDefaultNetworkActive2 = isDefaultNetworkActive();
        int hashCode61 = (hashCode60 * 59) + (isDefaultNetworkActive2 == null ? 43 : isDefaultNetworkActive2.hashCode());
        Boolean isActiveNetworkMetered2 = isActiveNetworkMetered();
        int hashCode62 = (hashCode61 * 59) + (isActiveNetworkMetered2 == null ? 43 : isActiveNetworkMetered2.hashCode());
        Boolean isOnScreen2 = isOnScreen();
        int hashCode63 = (hashCode62 * 59) + (isOnScreen2 == null ? 43 : isOnScreen2.hashCode());
        Boolean isRoaming2 = isRoaming();
        int hashCode64 = (((hashCode63 * 59) + (isRoaming2 == null ? 43 : isRoaming2.hashCode())) * 59) + latencyType();
        String serverIp2 = serverIp();
        int hashCode65 = (hashCode64 * 59) + (serverIp2 == null ? 43 : serverIp2.hashCode());
        String privateIp2 = privateIp();
        int hashCode66 = (hashCode65 * 59) + (privateIp2 == null ? 43 : privateIp2.hashCode());
        String gatewayIp2 = gatewayIp();
        int hashCode67 = (hashCode66 * 59) + (gatewayIp2 == null ? 43 : gatewayIp2.hashCode());
        Integer locationPermissionState2 = locationPermissionState();
        int hashCode68 = (hashCode67 * 59) + (locationPermissionState2 == null ? 43 : locationPermissionState2.hashCode());
        Boolean isReadPhoneStatePermissionGranted2 = isReadPhoneStatePermissionGranted();
        int hashCode69 = ((hashCode68 * 59) + (isReadPhoneStatePermissionGranted2 == null ? 43 : isReadPhoneStatePermissionGranted2.hashCode())) * 59;
        if (!isSending()) {
            i2 = 97;
        }
        String appVersionName2 = appVersionName();
        int i9 = (hashCode69 + i2) * 59;
        int hashCode70 = appVersionName2 == null ? 43 : appVersionName2.hashCode();
        long appVersionCode2 = appVersionCode();
        long appLastUpdateTime2 = appLastUpdateTime();
        int duplexModeState2 = ((((((((((i9 + hashCode70) * 59) + ((int) (appVersionCode2 ^ (appVersionCode2 >>> 32)))) * 59) + ((int) (appLastUpdateTime2 ^ (appLastUpdateTime2 >>> 32)))) * 59) + duplexModeState()) * 59) + dozeModeState()) * 59) + callState();
        String buildDevice2 = buildDevice();
        int hashCode71 = (duplexModeState2 * 59) + (buildDevice2 == null ? 43 : buildDevice2.hashCode());
        String buildHardware2 = buildHardware();
        int hashCode72 = (hashCode71 * 59) + (buildHardware2 == null ? 43 : buildHardware2.hashCode());
        String buildProduct2 = buildProduct();
        int hashCode73 = (hashCode72 * 59) + (buildProduct2 == null ? 43 : buildProduct2.hashCode());
        String appId2 = appId();
        int i10 = hashCode73 * 59;
        if (appId2 != null) {
            i = appId2.hashCode();
        }
        return i10 + i;
    }

    public long id() {
        return this.id;
    }

    public CellInfoMetric id(long j) {
        this.id = j;
        return this;
    }

    public CellInfoMetric isActiveNetworkMetered(Boolean bool) {
        this.isActiveNetworkMetered = bool;
        return this;
    }

    public Boolean isActiveNetworkMetered() {
        return this.isActiveNetworkMetered;
    }

    public CellInfoMetric isConnectedToVpn(Boolean bool) {
        this.isConnectedToVpn = bool;
        return this;
    }

    public Boolean isConnectedToVpn() {
        return this.isConnectedToVpn;
    }

    public CellInfoMetric isDcNrRestricted(Boolean bool) {
        this.isDcNrRestricted = bool;
        return this;
    }

    public Boolean isDcNrRestricted() {
        return this.isDcNrRestricted;
    }

    public CellInfoMetric isDefaultNetworkActive(Boolean bool) {
        this.isDefaultNetworkActive = bool;
        return this;
    }

    public Boolean isDefaultNetworkActive() {
        return this.isDefaultNetworkActive;
    }

    public CellInfoMetric isEnDcAvailable(Boolean bool) {
        this.isEnDcAvailable = bool;
        return this;
    }

    public Boolean isEnDcAvailable() {
        return this.isEnDcAvailable;
    }

    public CellInfoMetric isNrAvailable(Boolean bool) {
        this.isNrAvailable = bool;
        return this;
    }

    public Boolean isNrAvailable() {
        return this.isNrAvailable;
    }

    public CellInfoMetric isOnScreen(Boolean bool) {
        this.isOnScreen = bool;
        return this;
    }

    public Boolean isOnScreen() {
        return this.isOnScreen;
    }

    public CellInfoMetric isReadPhoneStatePermissionGranted(Boolean bool) {
        this.isReadPhoneStatePermissionGranted = bool;
        return this;
    }

    public Boolean isReadPhoneStatePermissionGranted() {
        return this.isReadPhoneStatePermissionGranted;
    }

    public CellInfoMetric isRegistered(boolean z) {
        this.isRegistered = z;
        return this;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public CellInfoMetric isRoaming(Boolean bool) {
        this.isRoaming = bool;
        return this;
    }

    public Boolean isRoaming() {
        return this.isRoaming;
    }

    public CellInfoMetric isRooted(Boolean bool) {
        this.isRooted = bool;
        return this;
    }

    public Boolean isRooted() {
        return this.isRooted;
    }

    public CellInfoMetric isSending(boolean z) {
        this.isSending = z;
        return this;
    }

    public boolean isSending() {
        return this.isSending;
    }

    public CellInfoMetric isUsingCarrierAggregation(Boolean bool) {
        this.isUsingCarrierAggregation = bool;
        return this;
    }

    public Boolean isUsingCarrierAggregation() {
        return this.isUsingCarrierAggregation;
    }

    public CellInfoMetric lac(String str) {
        this.lac = str;
        return this;
    }

    public String lac() {
        return this.lac;
    }

    public int latencyType() {
        return this.latencyType;
    }

    public CellInfoMetric latencyType(int i) {
        this.latencyType = i;
        return this;
    }

    public double latitude() {
        return this.latitude;
    }

    public CellInfoMetric latitude(double d) {
        this.latitude = d;
        return this;
    }

    public CellInfoMetric level(Integer num) {
        this.level = num;
        return this;
    }

    public Integer level() {
        return this.level;
    }

    public int locationAge() {
        return this.locationAge;
    }

    public CellInfoMetric locationAge(int i) {
        this.locationAge = i;
        return this;
    }

    public CellInfoMetric locationPermissionState(Integer num) {
        this.locationPermissionState = num;
        return this;
    }

    public Integer locationPermissionState() {
        return this.locationPermissionState;
    }

    public CellInfoMetric locationSpeed(Float f) {
        this.locationSpeed = f;
        return this;
    }

    public Float locationSpeed() {
        return this.locationSpeed;
    }

    public CellInfoMetric locationSpeedAccuracy(Float f) {
        this.locationSpeedAccuracy = f;
        return this;
    }

    public Float locationSpeedAccuracy() {
        return this.locationSpeedAccuracy;
    }

    public double longitude() {
        return this.longitude;
    }

    public CellInfoMetric longitude(double d) {
        this.longitude = d;
        return this;
    }

    public CellInfoMetric measurementSequenceId(String str) {
        this.measurementSequenceId = str;
        return this;
    }

    public String measurementSequenceId() {
        return this.measurementSequenceId;
    }

    public CellInfoMetric mobileClientId(String str) {
        this.mobileClientId = str;
        return this;
    }

    public String mobileClientId() {
        return this.mobileClientId;
    }

    public CellInfoMetric networkMCC(String str) {
        this.networkMCC = str;
        return this;
    }

    public String networkMCC() {
        return this.networkMCC;
    }

    public CellInfoMetric networkMNC(String str) {
        this.networkMNC = str;
        return this;
    }

    public String networkMNC() {
        return this.networkMNC;
    }

    public CellInfoMetric networkOperatorName(String str) {
        this.networkOperatorName = str;
        return this;
    }

    public String networkOperatorName() {
        return this.networkOperatorName;
    }

    public CellInfoMetric nrFrequencyRange(Integer num) {
        this.nrFrequencyRange = num;
        return this;
    }

    public Integer nrFrequencyRange() {
        return this.nrFrequencyRange;
    }

    public CellInfoMetric nrState(String str) {
        this.nrState = str;
        return this;
    }

    public String nrState() {
        return this.nrState;
    }

    public int numberOfSimSlots() {
        return this.numberOfSimSlots;
    }

    public CellInfoMetric numberOfSimSlots(int i) {
        this.numberOfSimSlots = i;
        return this;
    }

    public CellInfoMetric os(String str) {
        this.os = str;
        return this;
    }

    public String os() {
        return this.os;
    }

    public CellInfoMetric osVersion(String str) {
        this.osVersion = str;
        return this;
    }

    public String osVersion() {
        return this.osVersion;
    }

    public CellInfoMetric overrideNetworkType(Integer num) {
        this.overrideNetworkType = num;
        return this;
    }

    public Integer overrideNetworkType() {
        return this.overrideNetworkType;
    }

    public CellInfoMetric pci(Integer num) {
        this.pci = num;
        return this;
    }

    public Integer pci() {
        return this.pci;
    }

    public CellInfoMetric privateIp(String str) {
        this.privateIp = str;
        return this;
    }

    public String privateIp() {
        return this.privateIp;
    }

    public CellInfoMetric rsrp(Integer num) {
        this.rsrp = num;
        return this;
    }

    public Integer rsrp() {
        return this.rsrp;
    }

    public CellInfoMetric rsrq(Integer num) {
        this.rsrq = num;
        return this;
    }

    public Integer rsrq() {
        return this.rsrq;
    }

    public CellInfoMetric rssi(Integer num) {
        this.rssi = num;
        return this;
    }

    public Integer rssi() {
        return this.rssi;
    }

    public CellInfoMetric rssnr(Integer num) {
        this.rssnr = num;
        return this;
    }

    public Integer rssnr() {
        return this.rssnr;
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().a().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public CellInfoMetric sdkOrigin(String str) {
        this.sdkOrigin = str;
        return this;
    }

    public String sdkOrigin() {
        return this.sdkOrigin;
    }

    public CellInfoMetric sdkVersionNumber(String str) {
        this.sdkVersionNumber = str;
        return this;
    }

    public String sdkVersionNumber() {
        return this.sdkVersionNumber;
    }

    public CellInfoMetric secondaryCarrierName(String str) {
        this.secondaryCarrierName = str;
        return this;
    }

    public String secondaryCarrierName() {
        return this.secondaryCarrierName;
    }

    public CellInfoMetric secondarySimMCC(String str) {
        this.secondarySimMCC = str;
        return this;
    }

    public String secondarySimMCC() {
        return this.secondarySimMCC;
    }

    public CellInfoMetric secondarySimMNC(String str) {
        this.secondarySimMNC = str;
        return this;
    }

    public String secondarySimMNC() {
        return this.secondarySimMNC;
    }

    public CellInfoMetric serverIp(String str) {
        this.serverIp = str;
        return this;
    }

    public String serverIp() {
        return this.serverIp;
    }

    public CellInfoMetric simMCC(String str) {
        this.simMCC = str;
        return this;
    }

    public String simMCC() {
        return this.simMCC;
    }

    public CellInfoMetric simMNC(String str) {
        this.simMNC = str;
        return this;
    }

    public String simMNC() {
        return this.simMNC;
    }

    public CellInfoMetric ssRsrp(Integer num) {
        this.ssRsrp = num;
        return this;
    }

    public Integer ssRsrp() {
        return this.ssRsrp;
    }

    public CellInfoMetric ssRsrq(Integer num) {
        this.ssRsrq = num;
        return this;
    }

    public Integer ssRsrq() {
        return this.ssRsrq;
    }

    public CellInfoMetric ssSinr(Integer num) {
        this.ssSinr = num;
        return this;
    }

    public Integer ssSinr() {
        return this.ssSinr;
    }

    public int stateDuringMeasurement() {
        return this.stateDuringMeasurement;
    }

    public CellInfoMetric stateDuringMeasurement(int i) {
        this.stateDuringMeasurement = i;
        return this;
    }

    public CellInfoMetric timingAdvance(Integer num) {
        this.timingAdvance = num;
        return this;
    }

    public Integer timingAdvance() {
        return this.timingAdvance;
    }

    public String toString() {
        return "CellInfoMetric(id=" + id() + ", mobileClientId=" + mobileClientId() + ", measurementSequenceId=" + measurementSequenceId() + ", sdkOrigin=" + sdkOrigin() + ", isRegistered=" + isRegistered() + ", dateTimeOfMeasurement=" + dateTimeOfMeasurement() + ", simMCC=" + simMCC() + ", simMNC=" + simMNC() + ", secondarySimMCC=" + secondarySimMCC() + ", secondarySimMNC=" + secondarySimMNC() + ", numberOfSimSlots=" + numberOfSimSlots() + ", dataSimSlotNumber=" + dataSimSlotNumber() + ", networkMCC=" + networkMCC() + ", networkMNC=" + networkMNC() + ", latitude=" + latitude() + ", longitude=" + longitude() + ", gpsAccuracy=" + gpsAccuracy() + ", deviceBrand=" + deviceBrand() + ", deviceModel=" + deviceModel() + ", deviceVersion=" + deviceVersion() + ", carrierName=" + carrierName() + ", secondaryCarrierName=" + secondaryCarrierName() + ", os=" + os() + ", osVersion=" + osVersion() + ", cellConnectionStatus=" + cellConnectionStatus() + ", cellType=" + cellType() + ", age=" + age() + ", bandwidth=" + bandwidth() + ", cellId=" + cellId() + ", arfc=" + arfc() + ", connectionArfc=" + connectionArfc() + ", cellBands=" + cellBands() + ", pci=" + pci() + ", lac=" + lac() + ", asuLevel=" + asuLevel() + ", dbm=" + dbm() + ", cqi=" + cqi() + ", level=" + level() + ", rsrp=" + rsrp() + ", rsrq=" + rsrq() + ", rssi=" + rssi() + ", rssnr=" + rssnr() + ", csiRsrp=" + csiRsrp() + ", csiSinr=" + csiSinr() + ", csiRsrq=" + csiRsrq() + ", ssRsrp=" + ssRsrp() + ", ssRsrq=" + ssRsrq() + ", ssSinr=" + ssSinr() + ", timingAdvance=" + timingAdvance() + ", isDcNrRestricted=" + isDcNrRestricted() + ", isNrAvailable=" + isNrAvailable() + ", isEnDcAvailable=" + isEnDcAvailable() + ", nrState=" + nrState() + ", nrFrequencyRange=" + nrFrequencyRange() + ", isUsingCarrierAggregation=" + isUsingCarrierAggregation() + ", vopsSupport=" + vopsSupport() + ", cellBandwidths=" + cellBandwidths() + ", additionalPlmns=" + additionalPlmns() + ", altitude=" + altitude() + ", locationSpeed=" + locationSpeed() + ", locationSpeedAccuracy=" + locationSpeedAccuracy() + ", locationAge=" + locationAge() + ", sdkVersionNumber=" + sdkVersionNumber() + ", wcdmaEcNo=" + wcdmaEcNo() + ", networkOperatorName=" + networkOperatorName() + ", stateDuringMeasurement=" + stateDuringMeasurement() + ", overrideNetworkType=" + overrideNetworkType() + ", accessNetworkTechnologyRaw=" + accessNetworkTechnologyRaw() + ", anonymize=" + anonymize() + ", isRooted=" + isRooted() + ", isConnectedToVpn=" + isConnectedToVpn() + ", gpsVerticalAccuracy=" + gpsVerticalAccuracy() + ", getRestrictBackgroundStatus=" + getRestrictBackgroundStatus() + ", isDefaultNetworkActive=" + isDefaultNetworkActive() + ", isActiveNetworkMetered=" + isActiveNetworkMetered() + ", isOnScreen=" + isOnScreen() + ", isRoaming=" + isRoaming() + ", latencyType=" + latencyType() + ", serverIp=" + serverIp() + ", privateIp=" + privateIp() + ", gatewayIp=" + gatewayIp() + ", locationPermissionState=" + locationPermissionState() + ", isReadPhoneStatePermissionGranted=" + isReadPhoneStatePermissionGranted() + ", isSending=" + isSending() + ", appVersionName=" + appVersionName() + ", appVersionCode=" + appVersionCode() + ", appLastUpdateTime=" + appLastUpdateTime() + ", duplexModeState=" + duplexModeState() + ", dozeModeState=" + dozeModeState() + ", callState=" + callState() + ", buildDevice=" + buildDevice() + ", buildHardware=" + buildHardware() + ", buildProduct=" + buildProduct() + ", appId=" + appId() + ")";
    }

    public CellInfoMetric vopsSupport(Integer num) {
        this.vopsSupport = num;
        return this;
    }

    public Integer vopsSupport() {
        return this.vopsSupport;
    }

    public CellInfoMetric wcdmaEcNo(Integer num) {
        this.wcdmaEcNo = num;
        return this;
    }

    public Integer wcdmaEcNo() {
        return this.wcdmaEcNo;
    }
}
