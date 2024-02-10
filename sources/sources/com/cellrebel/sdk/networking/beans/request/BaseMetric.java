package com.cellrebel.sdk.networking.beans.request;

import android.text.format.DateFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Calendar;
import java.util.Locale;

public class BaseMetric {
    @SerializedName("absoluteRfChannelNumber")
    @Expose
    public Integer absoluteRfChannelNumber;
    @SerializedName("accessNetworkTechnologyRaw")
    @Expose
    public Integer accessNetworkTechnologyRaw;
    @SerializedName("accessTechnology")
    @Expose
    public String accessTechnology;
    @SerializedName("accessTypeRaw")
    @Expose
    public String accessTypeRaw;
    @SerializedName("additionalPlmns")
    @Expose
    public String additionalPlmns;
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
    @SerializedName("cellId")
    @Expose
    public String cellId;
    @SerializedName("cellType")
    @Expose
    public String cellType;
    @SerializedName("channelQualityIndicator")
    @Expose
    public Integer channelQualityIndicator;
    @SerializedName("clientIp")
    @Expose
    public String clientIp;
    @SerializedName("connectionAbsoluteRfChannelNumber")
    @Expose
    public Integer connectionAbsoluteRfChannelNumber;
    @SerializedName("csiReferenceSignalReceivedPower")
    @Expose
    public Integer csiReferenceSignalReceivedPower;
    @SerializedName("csiReferenceSignalReceivedQuality")
    @Expose
    public Integer csiReferenceSignalReceivedQuality;
    @SerializedName("csiReferenceSignalToNoiseAndInterferenceRatio")
    @Expose
    public Integer csiReferenceSignalToNoiseAndInterferenceRatio;
    @SerializedName("dataSlotNumber")
    @Expose
    public int dataSimSlotNumber;
    @SerializedName("dateTimeOfMeasurement")
    @Expose
    public String dateTimeOfMeasurement;
    @SerializedName("dbm")
    @Expose
    public Integer dbm;
    @SerializedName("debugString")
    @Expose
    public String debugString;
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
    @SerializedName("interference")
    @Expose
    public int interference;
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
    @SerializedName("isNrCellSeen")
    @Expose
    public Boolean isNrCellSeen;
    @SerializedName("isOnScreen")
    @Expose
    public Boolean isOnScreen;
    @SerializedName("isReadPhoneStatePermissionGranted")
    @Expose
    public Boolean isReadPhoneStatePermissionGranted;
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
    @SerializedName("lacId")
    @Expose
    public String lacId;
    @SerializedName("latencyType")
    @Expose
    public int latencyType;
    @SerializedName("latitude")
    @Expose
    public double latitude;
    @SerializedName("linkDownstreamBandwidth")
    @Expose
    public int linkDownstreamBandwidth;
    @SerializedName("linkUpstreamBandwidth")
    @Expose
    public int linkUpstreamBandwidth;
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
    public Integer physicalCellId;
    @SerializedName("privateIp")
    @Expose
    public String privateIp;
    @SerializedName("readableDate")
    @Expose
    public String readableDate;
    @SerializedName("referenceSignalReceivedPower")
    @Expose
    public Integer referenceSignalReceivedPower;
    @SerializedName("referenceSignalReceivedQuality")
    @Expose
    public Integer referenceSignalReceivedQuality;
    @SerializedName("referenceSignalSignalToNoiseRatio")
    @Expose
    public Integer referenceSignalSignalToNoiseRatio;
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
    @SerializedName("serviceStateStatus")
    @Expose
    public Integer serviceStateStatus;
    @SerializedName("signalStrength")
    @Expose
    public int signalStrength;
    @SerializedName("signalStrengthAsu")
    @Expose
    public Integer signalStrengthAsu;
    @SerializedName("simMCC")
    @Expose
    public String simMCC;
    @SerializedName("simMNC")
    @Expose
    public String simMNC;
    @SerializedName("ssReferenceSignalReceivedPower")
    @Expose
    public Integer ssReferenceSignalReceivedPower;
    @SerializedName("ssReferenceSignalReceivedQuality")
    @Expose
    public Integer ssReferenceSignalReceivedQuality;
    @SerializedName("ssReferenceSignalToNoiseAndInterferenceRatio")
    @Expose
    public Integer ssReferenceSignalToNoiseAndInterferenceRatio;
    @SerializedName("stateDuringMeasurement")
    @Expose
    public int stateDuringMeasurement;
    @SerializedName("timingAdvance")
    @Expose
    public Integer timingAdvance;
    @SerializedName("vopsSupport")
    @Expose
    public Integer vopsSupport;

    public BaseMetric absoluteRfChannelNumber(Integer num) {
        this.absoluteRfChannelNumber = num;
        return this;
    }

    public Integer absoluteRfChannelNumber() {
        return this.absoluteRfChannelNumber;
    }

    public BaseMetric accessNetworkTechnologyRaw(Integer num) {
        this.accessNetworkTechnologyRaw = num;
        return this;
    }

    public Integer accessNetworkTechnologyRaw() {
        return this.accessNetworkTechnologyRaw;
    }

    public BaseMetric accessTechnology(String str) {
        this.accessTechnology = str;
        return this;
    }

    public String accessTechnology() {
        return this.accessTechnology;
    }

    public BaseMetric accessTypeRaw(String str) {
        this.accessTypeRaw = str;
        return this;
    }

    public String accessTypeRaw() {
        return this.accessTypeRaw;
    }

    public BaseMetric additionalPlmns(String str) {
        this.additionalPlmns = str;
        return this;
    }

    public String additionalPlmns() {
        return this.additionalPlmns;
    }

    public double altitude() {
        return this.altitude;
    }

    public BaseMetric altitude(double d) {
        this.altitude = d;
        return this;
    }

    public BaseMetric anonymize(Boolean bool) {
        this.anonymize = bool;
        return this;
    }

    public Boolean anonymize() {
        return this.anonymize;
    }

    public BaseMetric appId(String str) {
        this.appId = str;
        return this;
    }

    public String appId() {
        return this.appId;
    }

    public long appLastUpdateTime() {
        return this.appLastUpdateTime;
    }

    public BaseMetric appLastUpdateTime(long j) {
        this.appLastUpdateTime = j;
        return this;
    }

    public long appVersionCode() {
        return this.appVersionCode;
    }

    public BaseMetric appVersionCode(long j) {
        this.appVersionCode = j;
        return this;
    }

    public BaseMetric appVersionName(String str) {
        this.appVersionName = str;
        return this;
    }

    public String appVersionName() {
        return this.appVersionName;
    }

    public BaseMetric buildDevice(String str) {
        this.buildDevice = str;
        return this;
    }

    public String buildDevice() {
        return this.buildDevice;
    }

    public BaseMetric buildHardware(String str) {
        this.buildHardware = str;
        return this;
    }

    public String buildHardware() {
        return this.buildHardware;
    }

    public BaseMetric buildProduct(String str) {
        this.buildProduct = str;
        return this;
    }

    public String buildProduct() {
        return this.buildProduct;
    }

    public int callState() {
        return this.callState;
    }

    public BaseMetric callState(int i) {
        this.callState = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof BaseMetric;
    }

    public BaseMetric carrierName(String str) {
        this.carrierName = str;
        return this;
    }

    public String carrierName() {
        return this.carrierName;
    }

    public BaseMetric cellBands(String str) {
        this.cellBands = str;
        return this;
    }

    public String cellBands() {
        return this.cellBands;
    }

    public BaseMetric cellBandwidths(String str) {
        this.cellBandwidths = str;
        return this;
    }

    public String cellBandwidths() {
        return this.cellBandwidths;
    }

    public BaseMetric cellId(String str) {
        this.cellId = str;
        return this;
    }

    public String cellId() {
        return this.cellId;
    }

    public BaseMetric cellType(String str) {
        this.cellType = str;
        return this;
    }

    public String cellType() {
        return this.cellType;
    }

    public BaseMetric channelQualityIndicator(Integer num) {
        this.channelQualityIndicator = num;
        return this;
    }

    public Integer channelQualityIndicator() {
        return this.channelQualityIndicator;
    }

    public BaseMetric clientIp(String str) {
        this.clientIp = str;
        return this;
    }

    public String clientIp() {
        return this.clientIp;
    }

    public BaseMetric connectionAbsoluteRfChannelNumber(Integer num) {
        this.connectionAbsoluteRfChannelNumber = num;
        return this;
    }

    public Integer connectionAbsoluteRfChannelNumber() {
        return this.connectionAbsoluteRfChannelNumber;
    }

    public void copyFrom(BaseMetric baseMetric) {
        this.mobileClientId = baseMetric.mobileClientId;
        this.measurementSequenceId = baseMetric.measurementSequenceId;
        this.stateDuringMeasurement = baseMetric.stateDuringMeasurement;
        this.anonymize = baseMetric.anonymize;
        this.sdkOrigin = baseMetric.sdkOrigin;
        this.sdkVersionNumber = baseMetric.sdkVersionNumber;
        this.dateTimeOfMeasurement = String.valueOf(System.currentTimeMillis() / 1000);
        this.simMNC = baseMetric.simMNC;
        this.simMCC = baseMetric.simMCC;
        this.latitude = baseMetric.latitude;
        this.longitude = baseMetric.longitude;
        this.gpsAccuracy = baseMetric.gpsAccuracy;
        this.deviceBrand = baseMetric.deviceBrand;
        this.deviceModel = baseMetric.deviceModel;
        this.deviceVersion = baseMetric.deviceVersion;
        this.networkOperatorName = baseMetric.networkOperatorName;
        this.physicalCellId = baseMetric.physicalCellId;
        this.cellId = baseMetric.cellId;
        this.lacId = baseMetric.lacId;
        this.dbm = baseMetric.dbm;
        this.locationSpeed = baseMetric.locationSpeed;
        this.locationSpeedAccuracy = baseMetric.locationSpeedAccuracy;
        this.overrideNetworkType = baseMetric.overrideNetworkType;
        this.accessNetworkTechnologyRaw = baseMetric.accessNetworkTechnologyRaw;
        this.isRooted = baseMetric.isRooted;
        this.carrierName = baseMetric.carrierName;
        this.os = baseMetric.os;
        this.osVersion = baseMetric.osVersion;
        this.secondarySimMCC = baseMetric.secondarySimMCC;
        this.secondarySimMNC = baseMetric.secondarySimMNC;
        this.secondaryCarrierName = baseMetric.secondaryCarrierName;
        this.numberOfSimSlots = baseMetric.numberOfSimSlots;
        this.dataSimSlotNumber = baseMetric.dataSimSlotNumber;
        this.isConnectedToVpn = baseMetric.isConnectedToVpn;
        this.linkDownstreamBandwidth = baseMetric.linkDownstreamBandwidth;
        this.linkUpstreamBandwidth = baseMetric.linkUpstreamBandwidth;
        this.appVersionName = baseMetric.appVersionName;
        this.appVersionCode = baseMetric.appVersionCode;
        this.appLastUpdateTime = baseMetric.appLastUpdateTime;
        this.clientIp = baseMetric.clientIp;
        this.accessTechnology = baseMetric.accessTechnology;
        this.accessTypeRaw = baseMetric.accessTypeRaw;
        this.signalStrength = baseMetric.signalStrength;
        this.networkMCC = baseMetric.networkMCC;
        this.networkMNC = baseMetric.networkMNC;
        this.readableDate = baseMetric.readableDate;
        this.absoluteRfChannelNumber = baseMetric.absoluteRfChannelNumber;
        this.connectionAbsoluteRfChannelNumber = baseMetric.connectionAbsoluteRfChannelNumber;
        this.timingAdvance = baseMetric.timingAdvance;
        this.signalStrengthAsu = baseMetric.signalStrengthAsu;
        this.debugString = baseMetric.debugString;
        this.isDcNrRestricted = baseMetric.isDcNrRestricted;
        this.isNrAvailable = baseMetric.isNrAvailable;
        this.isEnDcAvailable = baseMetric.isEnDcAvailable;
        this.nrState = baseMetric.nrState;
        this.nrFrequencyRange = baseMetric.nrFrequencyRange;
        this.isUsingCarrierAggregation = baseMetric.isUsingCarrierAggregation;
        this.vopsSupport = baseMetric.vopsSupport;
        this.cellBandwidths = baseMetric.cellBandwidths;
        this.altitude = baseMetric.altitude;
        this.gpsVerticalAccuracy = baseMetric.gpsVerticalAccuracy;
        this.getRestrictBackgroundStatus = baseMetric.getRestrictBackgroundStatus;
        this.cellType = baseMetric.cellType;
        this.isDefaultNetworkActive = baseMetric.isDefaultNetworkActive;
        this.isActiveNetworkMetered = baseMetric.isActiveNetworkMetered;
        this.isOnScreen = baseMetric.isOnScreen;
        this.isRoaming = baseMetric.isRoaming;
        this.locationAge = baseMetric.locationAge;
        this.serverIp = baseMetric.serverIp;
        this.privateIp = baseMetric.privateIp;
        this.gatewayIp = baseMetric.gatewayIp;
        this.locationPermissionState = baseMetric.locationPermissionState;
        this.serviceStateStatus = baseMetric.serviceStateStatus;
        this.isNrCellSeen = baseMetric.isNrCellSeen;
        this.isReadPhoneStatePermissionGranted = baseMetric.isReadPhoneStatePermissionGranted;
        this.channelQualityIndicator = baseMetric.channelQualityIndicator;
        this.referenceSignalSignalToNoiseRatio = baseMetric.referenceSignalSignalToNoiseRatio;
        this.referenceSignalReceivedPower = baseMetric.referenceSignalReceivedPower;
        this.referenceSignalReceivedQuality = baseMetric.referenceSignalReceivedQuality;
        this.csiReferenceSignalReceivedPower = baseMetric.csiReferenceSignalReceivedPower;
        this.csiReferenceSignalToNoiseAndInterferenceRatio = baseMetric.csiReferenceSignalToNoiseAndInterferenceRatio;
        this.csiReferenceSignalReceivedQuality = baseMetric.csiReferenceSignalReceivedQuality;
        this.ssReferenceSignalReceivedPower = baseMetric.ssReferenceSignalReceivedPower;
        this.ssReferenceSignalReceivedQuality = baseMetric.ssReferenceSignalReceivedQuality;
        this.ssReferenceSignalToNoiseAndInterferenceRatio = baseMetric.ssReferenceSignalToNoiseAndInterferenceRatio;
        this.additionalPlmns = baseMetric.additionalPlmns;
        this.cellBands = baseMetric.cellBands;
        this.duplexModeState = baseMetric.duplexModeState;
        this.dozeModeState = baseMetric.dozeModeState;
        this.callState = baseMetric.callState;
        this.buildDevice = baseMetric.buildDevice;
        this.buildHardware = baseMetric.buildHardware;
        this.buildProduct = baseMetric.buildProduct;
        this.appId = baseMetric.appId;
    }

    public BaseMetric csiReferenceSignalReceivedPower(Integer num) {
        this.csiReferenceSignalReceivedPower = num;
        return this;
    }

    public Integer csiReferenceSignalReceivedPower() {
        return this.csiReferenceSignalReceivedPower;
    }

    public BaseMetric csiReferenceSignalReceivedQuality(Integer num) {
        this.csiReferenceSignalReceivedQuality = num;
        return this;
    }

    public Integer csiReferenceSignalReceivedQuality() {
        return this.csiReferenceSignalReceivedQuality;
    }

    public BaseMetric csiReferenceSignalToNoiseAndInterferenceRatio(Integer num) {
        this.csiReferenceSignalToNoiseAndInterferenceRatio = num;
        return this;
    }

    public Integer csiReferenceSignalToNoiseAndInterferenceRatio() {
        return this.csiReferenceSignalToNoiseAndInterferenceRatio;
    }

    public int dataSimSlotNumber() {
        return this.dataSimSlotNumber;
    }

    public BaseMetric dataSimSlotNumber(int i) {
        this.dataSimSlotNumber = i;
        return this;
    }

    public BaseMetric dateTimeOfMeasurement(String str) {
        this.dateTimeOfMeasurement = str;
        return this;
    }

    public String dateTimeOfMeasurement() {
        return this.dateTimeOfMeasurement;
    }

    public BaseMetric dbm(Integer num) {
        this.dbm = num;
        return this;
    }

    public Integer dbm() {
        return this.dbm;
    }

    public BaseMetric debugString(String str) {
        this.debugString = str;
        return this;
    }

    public String debugString() {
        return this.debugString;
    }

    public BaseMetric deviceBrand(String str) {
        this.deviceBrand = str;
        return this;
    }

    public String deviceBrand() {
        return this.deviceBrand;
    }

    public BaseMetric deviceModel(String str) {
        this.deviceModel = str;
        return this;
    }

    public String deviceModel() {
        return this.deviceModel;
    }

    public BaseMetric deviceVersion(String str) {
        this.deviceVersion = str;
        return this;
    }

    public String deviceVersion() {
        return this.deviceVersion;
    }

    public int dozeModeState() {
        return this.dozeModeState;
    }

    public BaseMetric dozeModeState(int i) {
        this.dozeModeState = i;
        return this;
    }

    public int duplexModeState() {
        return this.duplexModeState;
    }

    public BaseMetric duplexModeState(int i) {
        this.duplexModeState = i;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseMetric)) {
            return false;
        }
        BaseMetric baseMetric = (BaseMetric) obj;
        if (!baseMetric.canEqual(this) || id() != baseMetric.id()) {
            return false;
        }
        String mobileClientId2 = mobileClientId();
        String mobileClientId3 = baseMetric.mobileClientId();
        if (mobileClientId2 != null ? !mobileClientId2.equals(mobileClientId3) : mobileClientId3 != null) {
            return false;
        }
        String measurementSequenceId2 = measurementSequenceId();
        String measurementSequenceId3 = baseMetric.measurementSequenceId();
        if (measurementSequenceId2 != null ? !measurementSequenceId2.equals(measurementSequenceId3) : measurementSequenceId3 != null) {
            return false;
        }
        String clientIp2 = clientIp();
        String clientIp3 = baseMetric.clientIp();
        if (clientIp2 != null ? !clientIp2.equals(clientIp3) : clientIp3 != null) {
            return false;
        }
        String dateTimeOfMeasurement2 = dateTimeOfMeasurement();
        String dateTimeOfMeasurement3 = baseMetric.dateTimeOfMeasurement();
        if (dateTimeOfMeasurement2 != null ? !dateTimeOfMeasurement2.equals(dateTimeOfMeasurement3) : dateTimeOfMeasurement3 != null) {
            return false;
        }
        if (stateDuringMeasurement() != baseMetric.stateDuringMeasurement()) {
            return false;
        }
        String accessTechnology2 = accessTechnology();
        String accessTechnology3 = baseMetric.accessTechnology();
        if (accessTechnology2 != null ? !accessTechnology2.equals(accessTechnology3) : accessTechnology3 != null) {
            return false;
        }
        String accessTypeRaw2 = accessTypeRaw();
        String accessTypeRaw3 = baseMetric.accessTypeRaw();
        if (accessTypeRaw2 != null ? !accessTypeRaw2.equals(accessTypeRaw3) : accessTypeRaw3 != null) {
            return false;
        }
        if (signalStrength() != baseMetric.signalStrength() || interference() != baseMetric.interference()) {
            return false;
        }
        String simMCC2 = simMCC();
        String simMCC3 = baseMetric.simMCC();
        if (simMCC2 != null ? !simMCC2.equals(simMCC3) : simMCC3 != null) {
            return false;
        }
        String simMNC2 = simMNC();
        String simMNC3 = baseMetric.simMNC();
        if (simMNC2 != null ? !simMNC2.equals(simMNC3) : simMNC3 != null) {
            return false;
        }
        String secondarySimMCC2 = secondarySimMCC();
        String secondarySimMCC3 = baseMetric.secondarySimMCC();
        if (secondarySimMCC2 != null ? !secondarySimMCC2.equals(secondarySimMCC3) : secondarySimMCC3 != null) {
            return false;
        }
        String secondarySimMNC2 = secondarySimMNC();
        String secondarySimMNC3 = baseMetric.secondarySimMNC();
        if (secondarySimMNC2 != null ? !secondarySimMNC2.equals(secondarySimMNC3) : secondarySimMNC3 != null) {
            return false;
        }
        if (numberOfSimSlots() != baseMetric.numberOfSimSlots() || dataSimSlotNumber() != baseMetric.dataSimSlotNumber()) {
            return false;
        }
        String networkMCC2 = networkMCC();
        String networkMCC3 = baseMetric.networkMCC();
        if (networkMCC2 != null ? !networkMCC2.equals(networkMCC3) : networkMCC3 != null) {
            return false;
        }
        String networkMNC2 = networkMNC();
        String networkMNC3 = baseMetric.networkMNC();
        if (networkMNC2 != null ? !networkMNC2.equals(networkMNC3) : networkMNC3 != null) {
            return false;
        }
        if (Double.compare(latitude(), baseMetric.latitude()) != 0 || Double.compare(longitude(), baseMetric.longitude()) != 0 || Double.compare(gpsAccuracy(), baseMetric.gpsAccuracy()) != 0) {
            return false;
        }
        String cellId2 = cellId();
        String cellId3 = baseMetric.cellId();
        if (cellId2 != null ? !cellId2.equals(cellId3) : cellId3 != null) {
            return false;
        }
        String lacId2 = lacId();
        String lacId3 = baseMetric.lacId();
        if (lacId2 != null ? !lacId2.equals(lacId3) : lacId3 != null) {
            return false;
        }
        String deviceBrand2 = deviceBrand();
        String deviceBrand3 = baseMetric.deviceBrand();
        if (deviceBrand2 != null ? !deviceBrand2.equals(deviceBrand3) : deviceBrand3 != null) {
            return false;
        }
        String deviceModel2 = deviceModel();
        String deviceModel3 = baseMetric.deviceModel();
        if (deviceModel2 != null ? !deviceModel2.equals(deviceModel3) : deviceModel3 != null) {
            return false;
        }
        String deviceVersion2 = deviceVersion();
        String deviceVersion3 = baseMetric.deviceVersion();
        if (deviceVersion2 != null ? !deviceVersion2.equals(deviceVersion3) : deviceVersion3 != null) {
            return false;
        }
        String sdkVersionNumber2 = sdkVersionNumber();
        String sdkVersionNumber3 = baseMetric.sdkVersionNumber();
        if (sdkVersionNumber2 != null ? !sdkVersionNumber2.equals(sdkVersionNumber3) : sdkVersionNumber3 != null) {
            return false;
        }
        String carrierName2 = carrierName();
        String carrierName3 = baseMetric.carrierName();
        if (carrierName2 != null ? !carrierName2.equals(carrierName3) : carrierName3 != null) {
            return false;
        }
        String secondaryCarrierName2 = secondaryCarrierName();
        String secondaryCarrierName3 = baseMetric.secondaryCarrierName();
        if (secondaryCarrierName2 != null ? !secondaryCarrierName2.equals(secondaryCarrierName3) : secondaryCarrierName3 != null) {
            return false;
        }
        String networkOperatorName2 = networkOperatorName();
        String networkOperatorName3 = baseMetric.networkOperatorName();
        if (networkOperatorName2 != null ? !networkOperatorName2.equals(networkOperatorName3) : networkOperatorName3 != null) {
            return false;
        }
        String os2 = os();
        String os3 = baseMetric.os();
        if (os2 != null ? !os2.equals(os3) : os3 != null) {
            return false;
        }
        String osVersion2 = osVersion();
        String osVersion3 = baseMetric.osVersion();
        if (osVersion2 != null ? !osVersion2.equals(osVersion3) : osVersion3 != null) {
            return false;
        }
        String readableDate2 = readableDate();
        String readableDate3 = baseMetric.readableDate();
        if (readableDate2 != null ? !readableDate2.equals(readableDate3) : readableDate3 != null) {
            return false;
        }
        Integer physicalCellId2 = physicalCellId();
        Integer physicalCellId3 = baseMetric.physicalCellId();
        if (physicalCellId2 != null ? !physicalCellId2.equals(physicalCellId3) : physicalCellId3 != null) {
            return false;
        }
        Integer absoluteRfChannelNumber2 = absoluteRfChannelNumber();
        Integer absoluteRfChannelNumber3 = baseMetric.absoluteRfChannelNumber();
        if (absoluteRfChannelNumber2 != null ? !absoluteRfChannelNumber2.equals(absoluteRfChannelNumber3) : absoluteRfChannelNumber3 != null) {
            return false;
        }
        Integer connectionAbsoluteRfChannelNumber2 = connectionAbsoluteRfChannelNumber();
        Integer connectionAbsoluteRfChannelNumber3 = baseMetric.connectionAbsoluteRfChannelNumber();
        if (connectionAbsoluteRfChannelNumber2 != null ? !connectionAbsoluteRfChannelNumber2.equals(connectionAbsoluteRfChannelNumber3) : connectionAbsoluteRfChannelNumber3 != null) {
            return false;
        }
        String cellBands2 = cellBands();
        String cellBands3 = baseMetric.cellBands();
        if (cellBands2 != null ? !cellBands2.equals(cellBands3) : cellBands3 != null) {
            return false;
        }
        Integer channelQualityIndicator2 = channelQualityIndicator();
        Integer channelQualityIndicator3 = baseMetric.channelQualityIndicator();
        if (channelQualityIndicator2 != null ? !channelQualityIndicator2.equals(channelQualityIndicator3) : channelQualityIndicator3 != null) {
            return false;
        }
        Integer referenceSignalSignalToNoiseRatio2 = referenceSignalSignalToNoiseRatio();
        Integer referenceSignalSignalToNoiseRatio3 = baseMetric.referenceSignalSignalToNoiseRatio();
        if (referenceSignalSignalToNoiseRatio2 != null ? !referenceSignalSignalToNoiseRatio2.equals(referenceSignalSignalToNoiseRatio3) : referenceSignalSignalToNoiseRatio3 != null) {
            return false;
        }
        Integer referenceSignalReceivedPower2 = referenceSignalReceivedPower();
        Integer referenceSignalReceivedPower3 = baseMetric.referenceSignalReceivedPower();
        if (referenceSignalReceivedPower2 != null ? !referenceSignalReceivedPower2.equals(referenceSignalReceivedPower3) : referenceSignalReceivedPower3 != null) {
            return false;
        }
        Integer referenceSignalReceivedQuality2 = referenceSignalReceivedQuality();
        Integer referenceSignalReceivedQuality3 = baseMetric.referenceSignalReceivedQuality();
        if (referenceSignalReceivedQuality2 != null ? !referenceSignalReceivedQuality2.equals(referenceSignalReceivedQuality3) : referenceSignalReceivedQuality3 != null) {
            return false;
        }
        Integer csiReferenceSignalReceivedPower2 = csiReferenceSignalReceivedPower();
        Integer csiReferenceSignalReceivedPower3 = baseMetric.csiReferenceSignalReceivedPower();
        if (csiReferenceSignalReceivedPower2 != null ? !csiReferenceSignalReceivedPower2.equals(csiReferenceSignalReceivedPower3) : csiReferenceSignalReceivedPower3 != null) {
            return false;
        }
        Integer csiReferenceSignalToNoiseAndInterferenceRatio2 = csiReferenceSignalToNoiseAndInterferenceRatio();
        Integer csiReferenceSignalToNoiseAndInterferenceRatio3 = baseMetric.csiReferenceSignalToNoiseAndInterferenceRatio();
        if (csiReferenceSignalToNoiseAndInterferenceRatio2 != null ? !csiReferenceSignalToNoiseAndInterferenceRatio2.equals(csiReferenceSignalToNoiseAndInterferenceRatio3) : csiReferenceSignalToNoiseAndInterferenceRatio3 != null) {
            return false;
        }
        Integer csiReferenceSignalReceivedQuality2 = csiReferenceSignalReceivedQuality();
        Integer csiReferenceSignalReceivedQuality3 = baseMetric.csiReferenceSignalReceivedQuality();
        if (csiReferenceSignalReceivedQuality2 != null ? !csiReferenceSignalReceivedQuality2.equals(csiReferenceSignalReceivedQuality3) : csiReferenceSignalReceivedQuality3 != null) {
            return false;
        }
        Integer ssReferenceSignalReceivedPower2 = ssReferenceSignalReceivedPower();
        Integer ssReferenceSignalReceivedPower3 = baseMetric.ssReferenceSignalReceivedPower();
        if (ssReferenceSignalReceivedPower2 != null ? !ssReferenceSignalReceivedPower2.equals(ssReferenceSignalReceivedPower3) : ssReferenceSignalReceivedPower3 != null) {
            return false;
        }
        Integer ssReferenceSignalReceivedQuality2 = ssReferenceSignalReceivedQuality();
        Integer ssReferenceSignalReceivedQuality3 = baseMetric.ssReferenceSignalReceivedQuality();
        if (ssReferenceSignalReceivedQuality2 != null ? !ssReferenceSignalReceivedQuality2.equals(ssReferenceSignalReceivedQuality3) : ssReferenceSignalReceivedQuality3 != null) {
            return false;
        }
        Integer ssReferenceSignalToNoiseAndInterferenceRatio2 = ssReferenceSignalToNoiseAndInterferenceRatio();
        Integer ssReferenceSignalToNoiseAndInterferenceRatio3 = baseMetric.ssReferenceSignalToNoiseAndInterferenceRatio();
        if (ssReferenceSignalToNoiseAndInterferenceRatio2 != null ? !ssReferenceSignalToNoiseAndInterferenceRatio2.equals(ssReferenceSignalToNoiseAndInterferenceRatio3) : ssReferenceSignalToNoiseAndInterferenceRatio3 != null) {
            return false;
        }
        Integer timingAdvance2 = timingAdvance();
        Integer timingAdvance3 = baseMetric.timingAdvance();
        if (timingAdvance2 != null ? !timingAdvance2.equals(timingAdvance3) : timingAdvance3 != null) {
            return false;
        }
        Integer signalStrengthAsu2 = signalStrengthAsu();
        Integer signalStrengthAsu3 = baseMetric.signalStrengthAsu();
        if (signalStrengthAsu2 != null ? !signalStrengthAsu2.equals(signalStrengthAsu3) : signalStrengthAsu3 != null) {
            return false;
        }
        Integer dbm2 = dbm();
        Integer dbm3 = baseMetric.dbm();
        if (dbm2 != null ? !dbm2.equals(dbm3) : dbm3 != null) {
            return false;
        }
        String debugString2 = debugString();
        String debugString3 = baseMetric.debugString();
        if (debugString2 != null ? !debugString2.equals(debugString3) : debugString3 != null) {
            return false;
        }
        Boolean isDcNrRestricted2 = isDcNrRestricted();
        Boolean isDcNrRestricted3 = baseMetric.isDcNrRestricted();
        if (isDcNrRestricted2 != null ? !isDcNrRestricted2.equals(isDcNrRestricted3) : isDcNrRestricted3 != null) {
            return false;
        }
        Boolean isNrAvailable2 = isNrAvailable();
        Boolean isNrAvailable3 = baseMetric.isNrAvailable();
        if (isNrAvailable2 != null ? !isNrAvailable2.equals(isNrAvailable3) : isNrAvailable3 != null) {
            return false;
        }
        Boolean isEnDcAvailable2 = isEnDcAvailable();
        Boolean isEnDcAvailable3 = baseMetric.isEnDcAvailable();
        if (isEnDcAvailable2 != null ? !isEnDcAvailable2.equals(isEnDcAvailable3) : isEnDcAvailable3 != null) {
            return false;
        }
        String nrState2 = nrState();
        String nrState3 = baseMetric.nrState();
        if (nrState2 != null ? !nrState2.equals(nrState3) : nrState3 != null) {
            return false;
        }
        Integer nrFrequencyRange2 = nrFrequencyRange();
        Integer nrFrequencyRange3 = baseMetric.nrFrequencyRange();
        if (nrFrequencyRange2 != null ? !nrFrequencyRange2.equals(nrFrequencyRange3) : nrFrequencyRange3 != null) {
            return false;
        }
        Boolean isUsingCarrierAggregation2 = isUsingCarrierAggregation();
        Boolean isUsingCarrierAggregation3 = baseMetric.isUsingCarrierAggregation();
        if (isUsingCarrierAggregation2 != null ? !isUsingCarrierAggregation2.equals(isUsingCarrierAggregation3) : isUsingCarrierAggregation3 != null) {
            return false;
        }
        Integer vopsSupport2 = vopsSupport();
        Integer vopsSupport3 = baseMetric.vopsSupport();
        if (vopsSupport2 != null ? !vopsSupport2.equals(vopsSupport3) : vopsSupport3 != null) {
            return false;
        }
        String cellBandwidths2 = cellBandwidths();
        String cellBandwidths3 = baseMetric.cellBandwidths();
        if (cellBandwidths2 != null ? !cellBandwidths2.equals(cellBandwidths3) : cellBandwidths3 != null) {
            return false;
        }
        String additionalPlmns2 = additionalPlmns();
        String additionalPlmns3 = baseMetric.additionalPlmns();
        if (additionalPlmns2 != null ? !additionalPlmns2.equals(additionalPlmns3) : additionalPlmns3 != null) {
            return false;
        }
        if (Double.compare(altitude(), baseMetric.altitude()) != 0) {
            return false;
        }
        Float locationSpeed2 = locationSpeed();
        Float locationSpeed3 = baseMetric.locationSpeed();
        if (locationSpeed2 != null ? !locationSpeed2.equals(locationSpeed3) : locationSpeed3 != null) {
            return false;
        }
        Float locationSpeedAccuracy2 = locationSpeedAccuracy();
        Float locationSpeedAccuracy3 = baseMetric.locationSpeedAccuracy();
        if (locationSpeedAccuracy2 != null ? !locationSpeedAccuracy2.equals(locationSpeedAccuracy3) : locationSpeedAccuracy3 != null) {
            return false;
        }
        Float gpsVerticalAccuracy2 = gpsVerticalAccuracy();
        Float gpsVerticalAccuracy3 = baseMetric.gpsVerticalAccuracy();
        if (gpsVerticalAccuracy2 != null ? !gpsVerticalAccuracy2.equals(gpsVerticalAccuracy3) : gpsVerticalAccuracy3 != null) {
            return false;
        }
        if (getRestrictBackgroundStatus() != baseMetric.getRestrictBackgroundStatus()) {
            return false;
        }
        String cellType2 = cellType();
        String cellType3 = baseMetric.cellType();
        if (cellType2 != null ? !cellType2.equals(cellType3) : cellType3 != null) {
            return false;
        }
        Boolean isDefaultNetworkActive2 = isDefaultNetworkActive();
        Boolean isDefaultNetworkActive3 = baseMetric.isDefaultNetworkActive();
        if (isDefaultNetworkActive2 != null ? !isDefaultNetworkActive2.equals(isDefaultNetworkActive3) : isDefaultNetworkActive3 != null) {
            return false;
        }
        Boolean isActiveNetworkMetered2 = isActiveNetworkMetered();
        Boolean isActiveNetworkMetered3 = baseMetric.isActiveNetworkMetered();
        if (isActiveNetworkMetered2 != null ? !isActiveNetworkMetered2.equals(isActiveNetworkMetered3) : isActiveNetworkMetered3 != null) {
            return false;
        }
        Boolean isOnScreen2 = isOnScreen();
        Boolean isOnScreen3 = baseMetric.isOnScreen();
        if (isOnScreen2 != null ? !isOnScreen2.equals(isOnScreen3) : isOnScreen3 != null) {
            return false;
        }
        Boolean isRoaming2 = isRoaming();
        Boolean isRoaming3 = baseMetric.isRoaming();
        if (isRoaming2 != null ? !isRoaming2.equals(isRoaming3) : isRoaming3 != null) {
            return false;
        }
        if (locationAge() != baseMetric.locationAge()) {
            return false;
        }
        Integer overrideNetworkType2 = overrideNetworkType();
        Integer overrideNetworkType3 = baseMetric.overrideNetworkType();
        if (overrideNetworkType2 != null ? !overrideNetworkType2.equals(overrideNetworkType3) : overrideNetworkType3 != null) {
            return false;
        }
        Integer accessNetworkTechnologyRaw2 = accessNetworkTechnologyRaw();
        Integer accessNetworkTechnologyRaw3 = baseMetric.accessNetworkTechnologyRaw();
        if (accessNetworkTechnologyRaw2 != null ? !accessNetworkTechnologyRaw2.equals(accessNetworkTechnologyRaw3) : accessNetworkTechnologyRaw3 != null) {
            return false;
        }
        Boolean anonymize2 = anonymize();
        Boolean anonymize3 = baseMetric.anonymize();
        if (anonymize2 != null ? !anonymize2.equals(anonymize3) : anonymize3 != null) {
            return false;
        }
        String sdkOrigin2 = sdkOrigin();
        String sdkOrigin3 = baseMetric.sdkOrigin();
        if (sdkOrigin2 != null ? !sdkOrigin2.equals(sdkOrigin3) : sdkOrigin3 != null) {
            return false;
        }
        Boolean isRooted2 = isRooted();
        Boolean isRooted3 = baseMetric.isRooted();
        if (isRooted2 != null ? !isRooted2.equals(isRooted3) : isRooted3 != null) {
            return false;
        }
        Boolean isConnectedToVpn2 = isConnectedToVpn();
        Boolean isConnectedToVpn3 = baseMetric.isConnectedToVpn();
        if (isConnectedToVpn2 != null ? !isConnectedToVpn2.equals(isConnectedToVpn3) : isConnectedToVpn3 != null) {
            return false;
        }
        if (linkDownstreamBandwidth() != baseMetric.linkDownstreamBandwidth() || linkUpstreamBandwidth() != baseMetric.linkUpstreamBandwidth() || latencyType() != baseMetric.latencyType()) {
            return false;
        }
        String serverIp2 = serverIp();
        String serverIp3 = baseMetric.serverIp();
        if (serverIp2 != null ? !serverIp2.equals(serverIp3) : serverIp3 != null) {
            return false;
        }
        String privateIp2 = privateIp();
        String privateIp3 = baseMetric.privateIp();
        if (privateIp2 != null ? !privateIp2.equals(privateIp3) : privateIp3 != null) {
            return false;
        }
        String gatewayIp2 = gatewayIp();
        String gatewayIp3 = baseMetric.gatewayIp();
        if (gatewayIp2 != null ? !gatewayIp2.equals(gatewayIp3) : gatewayIp3 != null) {
            return false;
        }
        Integer locationPermissionState2 = locationPermissionState();
        Integer locationPermissionState3 = baseMetric.locationPermissionState();
        if (locationPermissionState2 != null ? !locationPermissionState2.equals(locationPermissionState3) : locationPermissionState3 != null) {
            return false;
        }
        Integer serviceStateStatus2 = serviceStateStatus();
        Integer serviceStateStatus3 = baseMetric.serviceStateStatus();
        if (serviceStateStatus2 != null ? !serviceStateStatus2.equals(serviceStateStatus3) : serviceStateStatus3 != null) {
            return false;
        }
        Boolean isNrCellSeen2 = isNrCellSeen();
        Boolean isNrCellSeen3 = baseMetric.isNrCellSeen();
        if (isNrCellSeen2 != null ? !isNrCellSeen2.equals(isNrCellSeen3) : isNrCellSeen3 != null) {
            return false;
        }
        Boolean isReadPhoneStatePermissionGranted2 = isReadPhoneStatePermissionGranted();
        Boolean isReadPhoneStatePermissionGranted3 = baseMetric.isReadPhoneStatePermissionGranted();
        if (isReadPhoneStatePermissionGranted2 != null ? !isReadPhoneStatePermissionGranted2.equals(isReadPhoneStatePermissionGranted3) : isReadPhoneStatePermissionGranted3 != null) {
            return false;
        }
        String appVersionName2 = appVersionName();
        String appVersionName3 = baseMetric.appVersionName();
        if (appVersionName2 != null ? !appVersionName2.equals(appVersionName3) : appVersionName3 != null) {
            return false;
        }
        if (appVersionCode() != baseMetric.appVersionCode() || appLastUpdateTime() != baseMetric.appLastUpdateTime() || duplexModeState() != baseMetric.duplexModeState() || dozeModeState() != baseMetric.dozeModeState() || callState() != baseMetric.callState()) {
            return false;
        }
        String buildDevice2 = buildDevice();
        String buildDevice3 = baseMetric.buildDevice();
        if (buildDevice2 != null ? !buildDevice2.equals(buildDevice3) : buildDevice3 != null) {
            return false;
        }
        String buildHardware2 = buildHardware();
        String buildHardware3 = baseMetric.buildHardware();
        if (buildHardware2 != null ? !buildHardware2.equals(buildHardware3) : buildHardware3 != null) {
            return false;
        }
        String buildProduct2 = buildProduct();
        String buildProduct3 = baseMetric.buildProduct();
        if (buildProduct2 != null ? !buildProduct2.equals(buildProduct3) : buildProduct3 != null) {
            return false;
        }
        String appId2 = appId();
        String appId3 = baseMetric.appId();
        if (appId2 != null ? appId2.equals(appId3) : appId3 == null) {
            return isSending() == baseMetric.isSending();
        }
        return false;
    }

    public BaseMetric gatewayIp(String str) {
        this.gatewayIp = str;
        return this;
    }

    public String gatewayIp() {
        return this.gatewayIp;
    }

    public int getRestrictBackgroundStatus() {
        return this.getRestrictBackgroundStatus;
    }

    public BaseMetric getRestrictBackgroundStatus(int i) {
        this.getRestrictBackgroundStatus = i;
        return this;
    }

    public double gpsAccuracy() {
        return this.gpsAccuracy;
    }

    public BaseMetric gpsAccuracy(double d) {
        this.gpsAccuracy = d;
        return this;
    }

    public BaseMetric gpsVerticalAccuracy(Float f) {
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
        String clientIp2 = clientIp();
        int hashCode3 = (hashCode2 * 59) + (clientIp2 == null ? 43 : clientIp2.hashCode());
        String dateTimeOfMeasurement2 = dateTimeOfMeasurement();
        int hashCode4 = (((hashCode3 * 59) + (dateTimeOfMeasurement2 == null ? 43 : dateTimeOfMeasurement2.hashCode())) * 59) + stateDuringMeasurement();
        String accessTechnology2 = accessTechnology();
        int hashCode5 = (hashCode4 * 59) + (accessTechnology2 == null ? 43 : accessTechnology2.hashCode());
        String accessTypeRaw2 = accessTypeRaw();
        int hashCode6 = (((((hashCode5 * 59) + (accessTypeRaw2 == null ? 43 : accessTypeRaw2.hashCode())) * 59) + signalStrength()) * 59) + interference();
        String simMCC2 = simMCC();
        int hashCode7 = (hashCode6 * 59) + (simMCC2 == null ? 43 : simMCC2.hashCode());
        String simMNC2 = simMNC();
        int hashCode8 = (hashCode7 * 59) + (simMNC2 == null ? 43 : simMNC2.hashCode());
        String secondarySimMCC2 = secondarySimMCC();
        int hashCode9 = (hashCode8 * 59) + (secondarySimMCC2 == null ? 43 : secondarySimMCC2.hashCode());
        String secondarySimMNC2 = secondarySimMNC();
        int hashCode10 = (((((hashCode9 * 59) + (secondarySimMNC2 == null ? 43 : secondarySimMNC2.hashCode())) * 59) + numberOfSimSlots()) * 59) + dataSimSlotNumber();
        String networkMCC2 = networkMCC();
        int hashCode11 = (hashCode10 * 59) + (networkMCC2 == null ? 43 : networkMCC2.hashCode());
        String networkMNC2 = networkMNC();
        int i2 = hashCode11 * 59;
        int hashCode12 = networkMNC2 == null ? 43 : networkMNC2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(latitude());
        long doubleToLongBits2 = Double.doubleToLongBits(longitude());
        long doubleToLongBits3 = Double.doubleToLongBits(gpsAccuracy());
        int i3 = ((((((i2 + hashCode12) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        String cellId2 = cellId();
        int hashCode13 = (i3 * 59) + (cellId2 == null ? 43 : cellId2.hashCode());
        String lacId2 = lacId();
        int hashCode14 = (hashCode13 * 59) + (lacId2 == null ? 43 : lacId2.hashCode());
        String deviceBrand2 = deviceBrand();
        int hashCode15 = (hashCode14 * 59) + (deviceBrand2 == null ? 43 : deviceBrand2.hashCode());
        String deviceModel2 = deviceModel();
        int hashCode16 = (hashCode15 * 59) + (deviceModel2 == null ? 43 : deviceModel2.hashCode());
        String deviceVersion2 = deviceVersion();
        int hashCode17 = (hashCode16 * 59) + (deviceVersion2 == null ? 43 : deviceVersion2.hashCode());
        String sdkVersionNumber2 = sdkVersionNumber();
        int hashCode18 = (hashCode17 * 59) + (sdkVersionNumber2 == null ? 43 : sdkVersionNumber2.hashCode());
        String carrierName2 = carrierName();
        int hashCode19 = (hashCode18 * 59) + (carrierName2 == null ? 43 : carrierName2.hashCode());
        String secondaryCarrierName2 = secondaryCarrierName();
        int hashCode20 = (hashCode19 * 59) + (secondaryCarrierName2 == null ? 43 : secondaryCarrierName2.hashCode());
        String networkOperatorName2 = networkOperatorName();
        int hashCode21 = (hashCode20 * 59) + (networkOperatorName2 == null ? 43 : networkOperatorName2.hashCode());
        String os2 = os();
        int hashCode22 = (hashCode21 * 59) + (os2 == null ? 43 : os2.hashCode());
        String osVersion2 = osVersion();
        int hashCode23 = (hashCode22 * 59) + (osVersion2 == null ? 43 : osVersion2.hashCode());
        String readableDate2 = readableDate();
        int hashCode24 = (hashCode23 * 59) + (readableDate2 == null ? 43 : readableDate2.hashCode());
        Integer physicalCellId2 = physicalCellId();
        int hashCode25 = (hashCode24 * 59) + (physicalCellId2 == null ? 43 : physicalCellId2.hashCode());
        Integer absoluteRfChannelNumber2 = absoluteRfChannelNumber();
        int hashCode26 = (hashCode25 * 59) + (absoluteRfChannelNumber2 == null ? 43 : absoluteRfChannelNumber2.hashCode());
        Integer connectionAbsoluteRfChannelNumber2 = connectionAbsoluteRfChannelNumber();
        int hashCode27 = (hashCode26 * 59) + (connectionAbsoluteRfChannelNumber2 == null ? 43 : connectionAbsoluteRfChannelNumber2.hashCode());
        String cellBands2 = cellBands();
        int hashCode28 = (hashCode27 * 59) + (cellBands2 == null ? 43 : cellBands2.hashCode());
        Integer channelQualityIndicator2 = channelQualityIndicator();
        int hashCode29 = (hashCode28 * 59) + (channelQualityIndicator2 == null ? 43 : channelQualityIndicator2.hashCode());
        Integer referenceSignalSignalToNoiseRatio2 = referenceSignalSignalToNoiseRatio();
        int hashCode30 = (hashCode29 * 59) + (referenceSignalSignalToNoiseRatio2 == null ? 43 : referenceSignalSignalToNoiseRatio2.hashCode());
        Integer referenceSignalReceivedPower2 = referenceSignalReceivedPower();
        int hashCode31 = (hashCode30 * 59) + (referenceSignalReceivedPower2 == null ? 43 : referenceSignalReceivedPower2.hashCode());
        Integer referenceSignalReceivedQuality2 = referenceSignalReceivedQuality();
        int hashCode32 = (hashCode31 * 59) + (referenceSignalReceivedQuality2 == null ? 43 : referenceSignalReceivedQuality2.hashCode());
        Integer csiReferenceSignalReceivedPower2 = csiReferenceSignalReceivedPower();
        int hashCode33 = (hashCode32 * 59) + (csiReferenceSignalReceivedPower2 == null ? 43 : csiReferenceSignalReceivedPower2.hashCode());
        Integer csiReferenceSignalToNoiseAndInterferenceRatio2 = csiReferenceSignalToNoiseAndInterferenceRatio();
        int hashCode34 = (hashCode33 * 59) + (csiReferenceSignalToNoiseAndInterferenceRatio2 == null ? 43 : csiReferenceSignalToNoiseAndInterferenceRatio2.hashCode());
        Integer csiReferenceSignalReceivedQuality2 = csiReferenceSignalReceivedQuality();
        int hashCode35 = (hashCode34 * 59) + (csiReferenceSignalReceivedQuality2 == null ? 43 : csiReferenceSignalReceivedQuality2.hashCode());
        Integer ssReferenceSignalReceivedPower2 = ssReferenceSignalReceivedPower();
        int hashCode36 = (hashCode35 * 59) + (ssReferenceSignalReceivedPower2 == null ? 43 : ssReferenceSignalReceivedPower2.hashCode());
        Integer ssReferenceSignalReceivedQuality2 = ssReferenceSignalReceivedQuality();
        int hashCode37 = (hashCode36 * 59) + (ssReferenceSignalReceivedQuality2 == null ? 43 : ssReferenceSignalReceivedQuality2.hashCode());
        Integer ssReferenceSignalToNoiseAndInterferenceRatio2 = ssReferenceSignalToNoiseAndInterferenceRatio();
        int hashCode38 = (hashCode37 * 59) + (ssReferenceSignalToNoiseAndInterferenceRatio2 == null ? 43 : ssReferenceSignalToNoiseAndInterferenceRatio2.hashCode());
        Integer timingAdvance2 = timingAdvance();
        int hashCode39 = (hashCode38 * 59) + (timingAdvance2 == null ? 43 : timingAdvance2.hashCode());
        Integer signalStrengthAsu2 = signalStrengthAsu();
        int hashCode40 = (hashCode39 * 59) + (signalStrengthAsu2 == null ? 43 : signalStrengthAsu2.hashCode());
        Integer dbm2 = dbm();
        int hashCode41 = (hashCode40 * 59) + (dbm2 == null ? 43 : dbm2.hashCode());
        String debugString2 = debugString();
        int hashCode42 = (hashCode41 * 59) + (debugString2 == null ? 43 : debugString2.hashCode());
        Boolean isDcNrRestricted2 = isDcNrRestricted();
        int hashCode43 = (hashCode42 * 59) + (isDcNrRestricted2 == null ? 43 : isDcNrRestricted2.hashCode());
        Boolean isNrAvailable2 = isNrAvailable();
        int hashCode44 = (hashCode43 * 59) + (isNrAvailable2 == null ? 43 : isNrAvailable2.hashCode());
        Boolean isEnDcAvailable2 = isEnDcAvailable();
        int hashCode45 = (hashCode44 * 59) + (isEnDcAvailable2 == null ? 43 : isEnDcAvailable2.hashCode());
        String nrState2 = nrState();
        int hashCode46 = (hashCode45 * 59) + (nrState2 == null ? 43 : nrState2.hashCode());
        Integer nrFrequencyRange2 = nrFrequencyRange();
        int hashCode47 = (hashCode46 * 59) + (nrFrequencyRange2 == null ? 43 : nrFrequencyRange2.hashCode());
        Boolean isUsingCarrierAggregation2 = isUsingCarrierAggregation();
        int hashCode48 = (hashCode47 * 59) + (isUsingCarrierAggregation2 == null ? 43 : isUsingCarrierAggregation2.hashCode());
        Integer vopsSupport2 = vopsSupport();
        int hashCode49 = (hashCode48 * 59) + (vopsSupport2 == null ? 43 : vopsSupport2.hashCode());
        String cellBandwidths2 = cellBandwidths();
        int hashCode50 = (hashCode49 * 59) + (cellBandwidths2 == null ? 43 : cellBandwidths2.hashCode());
        String additionalPlmns2 = additionalPlmns();
        int i4 = hashCode50 * 59;
        int hashCode51 = additionalPlmns2 == null ? 43 : additionalPlmns2.hashCode();
        long doubleToLongBits4 = Double.doubleToLongBits(altitude());
        int i5 = ((i4 + hashCode51) * 59) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        Float locationSpeed2 = locationSpeed();
        int hashCode52 = (i5 * 59) + (locationSpeed2 == null ? 43 : locationSpeed2.hashCode());
        Float locationSpeedAccuracy2 = locationSpeedAccuracy();
        int hashCode53 = (hashCode52 * 59) + (locationSpeedAccuracy2 == null ? 43 : locationSpeedAccuracy2.hashCode());
        Float gpsVerticalAccuracy2 = gpsVerticalAccuracy();
        int hashCode54 = (((hashCode53 * 59) + (gpsVerticalAccuracy2 == null ? 43 : gpsVerticalAccuracy2.hashCode())) * 59) + getRestrictBackgroundStatus();
        String cellType2 = cellType();
        int hashCode55 = (hashCode54 * 59) + (cellType2 == null ? 43 : cellType2.hashCode());
        Boolean isDefaultNetworkActive2 = isDefaultNetworkActive();
        int hashCode56 = (hashCode55 * 59) + (isDefaultNetworkActive2 == null ? 43 : isDefaultNetworkActive2.hashCode());
        Boolean isActiveNetworkMetered2 = isActiveNetworkMetered();
        int hashCode57 = (hashCode56 * 59) + (isActiveNetworkMetered2 == null ? 43 : isActiveNetworkMetered2.hashCode());
        Boolean isOnScreen2 = isOnScreen();
        int hashCode58 = (hashCode57 * 59) + (isOnScreen2 == null ? 43 : isOnScreen2.hashCode());
        Boolean isRoaming2 = isRoaming();
        int hashCode59 = (((hashCode58 * 59) + (isRoaming2 == null ? 43 : isRoaming2.hashCode())) * 59) + locationAge();
        Integer overrideNetworkType2 = overrideNetworkType();
        int hashCode60 = (hashCode59 * 59) + (overrideNetworkType2 == null ? 43 : overrideNetworkType2.hashCode());
        Integer accessNetworkTechnologyRaw2 = accessNetworkTechnologyRaw();
        int hashCode61 = (hashCode60 * 59) + (accessNetworkTechnologyRaw2 == null ? 43 : accessNetworkTechnologyRaw2.hashCode());
        Boolean anonymize2 = anonymize();
        int hashCode62 = (hashCode61 * 59) + (anonymize2 == null ? 43 : anonymize2.hashCode());
        String sdkOrigin2 = sdkOrigin();
        int hashCode63 = (hashCode62 * 59) + (sdkOrigin2 == null ? 43 : sdkOrigin2.hashCode());
        Boolean isRooted2 = isRooted();
        int hashCode64 = (hashCode63 * 59) + (isRooted2 == null ? 43 : isRooted2.hashCode());
        Boolean isConnectedToVpn2 = isConnectedToVpn();
        int hashCode65 = (((((((hashCode64 * 59) + (isConnectedToVpn2 == null ? 43 : isConnectedToVpn2.hashCode())) * 59) + linkDownstreamBandwidth()) * 59) + linkUpstreamBandwidth()) * 59) + latencyType();
        String serverIp2 = serverIp();
        int hashCode66 = (hashCode65 * 59) + (serverIp2 == null ? 43 : serverIp2.hashCode());
        String privateIp2 = privateIp();
        int hashCode67 = (hashCode66 * 59) + (privateIp2 == null ? 43 : privateIp2.hashCode());
        String gatewayIp2 = gatewayIp();
        int hashCode68 = (hashCode67 * 59) + (gatewayIp2 == null ? 43 : gatewayIp2.hashCode());
        Integer locationPermissionState2 = locationPermissionState();
        int hashCode69 = (hashCode68 * 59) + (locationPermissionState2 == null ? 43 : locationPermissionState2.hashCode());
        Integer serviceStateStatus2 = serviceStateStatus();
        int hashCode70 = (hashCode69 * 59) + (serviceStateStatus2 == null ? 43 : serviceStateStatus2.hashCode());
        Boolean isNrCellSeen2 = isNrCellSeen();
        int hashCode71 = (hashCode70 * 59) + (isNrCellSeen2 == null ? 43 : isNrCellSeen2.hashCode());
        Boolean isReadPhoneStatePermissionGranted2 = isReadPhoneStatePermissionGranted();
        int hashCode72 = (hashCode71 * 59) + (isReadPhoneStatePermissionGranted2 == null ? 43 : isReadPhoneStatePermissionGranted2.hashCode());
        String appVersionName2 = appVersionName();
        int i6 = hashCode72 * 59;
        int hashCode73 = appVersionName2 == null ? 43 : appVersionName2.hashCode();
        long appVersionCode2 = appVersionCode();
        long appLastUpdateTime2 = appLastUpdateTime();
        int duplexModeState2 = ((((((((((i6 + hashCode73) * 59) + ((int) (appVersionCode2 ^ (appVersionCode2 >>> 32)))) * 59) + ((int) (appLastUpdateTime2 ^ (appLastUpdateTime2 >>> 32)))) * 59) + duplexModeState()) * 59) + dozeModeState()) * 59) + callState();
        String buildDevice2 = buildDevice();
        int hashCode74 = (duplexModeState2 * 59) + (buildDevice2 == null ? 43 : buildDevice2.hashCode());
        String buildHardware2 = buildHardware();
        int hashCode75 = (hashCode74 * 59) + (buildHardware2 == null ? 43 : buildHardware2.hashCode());
        String buildProduct2 = buildProduct();
        int hashCode76 = (hashCode75 * 59) + (buildProduct2 == null ? 43 : buildProduct2.hashCode());
        String appId2 = appId();
        int i7 = hashCode76 * 59;
        if (appId2 != null) {
            i = appId2.hashCode();
        }
        return ((i7 + i) * 59) + (isSending() ? 79 : 97);
    }

    public long id() {
        return this.id;
    }

    public BaseMetric id(long j) {
        this.id = j;
        return this;
    }

    public int interference() {
        return this.interference;
    }

    public BaseMetric interference(int i) {
        this.interference = i;
        return this;
    }

    public BaseMetric isActiveNetworkMetered(Boolean bool) {
        this.isActiveNetworkMetered = bool;
        return this;
    }

    public Boolean isActiveNetworkMetered() {
        return this.isActiveNetworkMetered;
    }

    public BaseMetric isConnectedToVpn(Boolean bool) {
        this.isConnectedToVpn = bool;
        return this;
    }

    public Boolean isConnectedToVpn() {
        return this.isConnectedToVpn;
    }

    public BaseMetric isDcNrRestricted(Boolean bool) {
        this.isDcNrRestricted = bool;
        return this;
    }

    public Boolean isDcNrRestricted() {
        return this.isDcNrRestricted;
    }

    public BaseMetric isDefaultNetworkActive(Boolean bool) {
        this.isDefaultNetworkActive = bool;
        return this;
    }

    public Boolean isDefaultNetworkActive() {
        return this.isDefaultNetworkActive;
    }

    public BaseMetric isEnDcAvailable(Boolean bool) {
        this.isEnDcAvailable = bool;
        return this;
    }

    public Boolean isEnDcAvailable() {
        return this.isEnDcAvailable;
    }

    public BaseMetric isNrAvailable(Boolean bool) {
        this.isNrAvailable = bool;
        return this;
    }

    public Boolean isNrAvailable() {
        return this.isNrAvailable;
    }

    public BaseMetric isNrCellSeen(Boolean bool) {
        this.isNrCellSeen = bool;
        return this;
    }

    public Boolean isNrCellSeen() {
        return this.isNrCellSeen;
    }

    public BaseMetric isOnScreen(Boolean bool) {
        this.isOnScreen = bool;
        return this;
    }

    public Boolean isOnScreen() {
        return this.isOnScreen;
    }

    public BaseMetric isReadPhoneStatePermissionGranted(Boolean bool) {
        this.isReadPhoneStatePermissionGranted = bool;
        return this;
    }

    public Boolean isReadPhoneStatePermissionGranted() {
        return this.isReadPhoneStatePermissionGranted;
    }

    public BaseMetric isRoaming(Boolean bool) {
        this.isRoaming = bool;
        return this;
    }

    public Boolean isRoaming() {
        return this.isRoaming;
    }

    public BaseMetric isRooted(Boolean bool) {
        this.isRooted = bool;
        return this;
    }

    public Boolean isRooted() {
        return this.isRooted;
    }

    public BaseMetric isSending(boolean z) {
        this.isSending = z;
        return this;
    }

    public boolean isSending() {
        return this.isSending;
    }

    public BaseMetric isUsingCarrierAggregation(Boolean bool) {
        this.isUsingCarrierAggregation = bool;
        return this;
    }

    public Boolean isUsingCarrierAggregation() {
        return this.isUsingCarrierAggregation;
    }

    public BaseMetric lacId(String str) {
        this.lacId = str;
        return this;
    }

    public String lacId() {
        return this.lacId;
    }

    public int latencyType() {
        return this.latencyType;
    }

    public BaseMetric latencyType(int i) {
        this.latencyType = i;
        return this;
    }

    public double latitude() {
        return this.latitude;
    }

    public BaseMetric latitude(double d) {
        this.latitude = d;
        return this;
    }

    public int linkDownstreamBandwidth() {
        return this.linkDownstreamBandwidth;
    }

    public BaseMetric linkDownstreamBandwidth(int i) {
        this.linkDownstreamBandwidth = i;
        return this;
    }

    public int linkUpstreamBandwidth() {
        return this.linkUpstreamBandwidth;
    }

    public BaseMetric linkUpstreamBandwidth(int i) {
        this.linkUpstreamBandwidth = i;
        return this;
    }

    public int locationAge() {
        return this.locationAge;
    }

    public BaseMetric locationAge(int i) {
        this.locationAge = i;
        return this;
    }

    public BaseMetric locationPermissionState(Integer num) {
        this.locationPermissionState = num;
        return this;
    }

    public Integer locationPermissionState() {
        return this.locationPermissionState;
    }

    public BaseMetric locationSpeed(Float f) {
        this.locationSpeed = f;
        return this;
    }

    public Float locationSpeed() {
        return this.locationSpeed;
    }

    public BaseMetric locationSpeedAccuracy(Float f) {
        this.locationSpeedAccuracy = f;
        return this;
    }

    public Float locationSpeedAccuracy() {
        return this.locationSpeedAccuracy;
    }

    public double longitude() {
        return this.longitude;
    }

    public BaseMetric longitude(double d) {
        this.longitude = d;
        return this;
    }

    public BaseMetric measurementSequenceId(String str) {
        this.measurementSequenceId = str;
        return this;
    }

    public String measurementSequenceId() {
        return this.measurementSequenceId;
    }

    public BaseMetric mobileClientId(String str) {
        this.mobileClientId = str;
        return this;
    }

    public String mobileClientId() {
        return this.mobileClientId;
    }

    public BaseMetric networkMCC(String str) {
        this.networkMCC = str;
        return this;
    }

    public String networkMCC() {
        return this.networkMCC;
    }

    public BaseMetric networkMNC(String str) {
        this.networkMNC = str;
        return this;
    }

    public String networkMNC() {
        return this.networkMNC;
    }

    public BaseMetric networkOperatorName(String str) {
        this.networkOperatorName = str;
        return this;
    }

    public String networkOperatorName() {
        return this.networkOperatorName;
    }

    public BaseMetric nrFrequencyRange(Integer num) {
        this.nrFrequencyRange = num;
        return this;
    }

    public Integer nrFrequencyRange() {
        return this.nrFrequencyRange;
    }

    public BaseMetric nrState(String str) {
        this.nrState = str;
        return this;
    }

    public String nrState() {
        return this.nrState;
    }

    public int numberOfSimSlots() {
        return this.numberOfSimSlots;
    }

    public BaseMetric numberOfSimSlots(int i) {
        this.numberOfSimSlots = i;
        return this;
    }

    public BaseMetric os(String str) {
        this.os = str;
        return this;
    }

    public String os() {
        return this.os;
    }

    public BaseMetric osVersion(String str) {
        this.osVersion = str;
        return this;
    }

    public String osVersion() {
        return this.osVersion;
    }

    public BaseMetric overrideNetworkType(Integer num) {
        this.overrideNetworkType = num;
        return this;
    }

    public Integer overrideNetworkType() {
        return this.overrideNetworkType;
    }

    public BaseMetric physicalCellId(Integer num) {
        this.physicalCellId = num;
        return this;
    }

    public Integer physicalCellId() {
        return this.physicalCellId;
    }

    public BaseMetric privateIp(String str) {
        this.privateIp = str;
        return this;
    }

    public String privateIp() {
        return this.privateIp;
    }

    public String readableDate() {
        return this.readableDate;
    }

    public void readableDate(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        this.readableDate = DateFormat.format("dd-MM-yyyy HH:mm:ss", instance).toString();
    }

    public BaseMetric referenceSignalReceivedPower(Integer num) {
        this.referenceSignalReceivedPower = num;
        return this;
    }

    public Integer referenceSignalReceivedPower() {
        return this.referenceSignalReceivedPower;
    }

    public BaseMetric referenceSignalReceivedQuality(Integer num) {
        this.referenceSignalReceivedQuality = num;
        return this;
    }

    public Integer referenceSignalReceivedQuality() {
        return this.referenceSignalReceivedQuality;
    }

    public BaseMetric referenceSignalSignalToNoiseRatio(Integer num) {
        this.referenceSignalSignalToNoiseRatio = num;
        return this;
    }

    public Integer referenceSignalSignalToNoiseRatio() {
        return this.referenceSignalSignalToNoiseRatio;
    }

    public void save() {
    }

    public BaseMetric sdkOrigin(String str) {
        this.sdkOrigin = str;
        return this;
    }

    public String sdkOrigin() {
        return this.sdkOrigin;
    }

    public BaseMetric sdkVersionNumber(String str) {
        this.sdkVersionNumber = str;
        return this;
    }

    public String sdkVersionNumber() {
        return this.sdkVersionNumber;
    }

    public BaseMetric secondaryCarrierName(String str) {
        this.secondaryCarrierName = str;
        return this;
    }

    public String secondaryCarrierName() {
        return this.secondaryCarrierName;
    }

    public BaseMetric secondarySimMCC(String str) {
        this.secondarySimMCC = str;
        return this;
    }

    public String secondarySimMCC() {
        return this.secondarySimMCC;
    }

    public BaseMetric secondarySimMNC(String str) {
        this.secondarySimMNC = str;
        return this;
    }

    public String secondarySimMNC() {
        return this.secondarySimMNC;
    }

    public BaseMetric serverIp(String str) {
        this.serverIp = str;
        return this;
    }

    public String serverIp() {
        return this.serverIp;
    }

    public BaseMetric serviceStateStatus(Integer num) {
        this.serviceStateStatus = num;
        return this;
    }

    public Integer serviceStateStatus() {
        return this.serviceStateStatus;
    }

    public int signalStrength() {
        return this.signalStrength;
    }

    public BaseMetric signalStrength(int i) {
        this.signalStrength = i;
        return this;
    }

    public BaseMetric signalStrengthAsu(Integer num) {
        this.signalStrengthAsu = num;
        return this;
    }

    public Integer signalStrengthAsu() {
        return this.signalStrengthAsu;
    }

    public BaseMetric simMCC(String str) {
        this.simMCC = str;
        return this;
    }

    public String simMCC() {
        return this.simMCC;
    }

    public BaseMetric simMNC(String str) {
        this.simMNC = str;
        return this;
    }

    public String simMNC() {
        return this.simMNC;
    }

    public BaseMetric ssReferenceSignalReceivedPower(Integer num) {
        this.ssReferenceSignalReceivedPower = num;
        return this;
    }

    public Integer ssReferenceSignalReceivedPower() {
        return this.ssReferenceSignalReceivedPower;
    }

    public BaseMetric ssReferenceSignalReceivedQuality(Integer num) {
        this.ssReferenceSignalReceivedQuality = num;
        return this;
    }

    public Integer ssReferenceSignalReceivedQuality() {
        return this.ssReferenceSignalReceivedQuality;
    }

    public BaseMetric ssReferenceSignalToNoiseAndInterferenceRatio(Integer num) {
        this.ssReferenceSignalToNoiseAndInterferenceRatio = num;
        return this;
    }

    public Integer ssReferenceSignalToNoiseAndInterferenceRatio() {
        return this.ssReferenceSignalToNoiseAndInterferenceRatio;
    }

    public int stateDuringMeasurement() {
        return this.stateDuringMeasurement;
    }

    public BaseMetric stateDuringMeasurement(int i) {
        this.stateDuringMeasurement = i;
        return this;
    }

    public BaseMetric timingAdvance(Integer num) {
        this.timingAdvance = num;
        return this;
    }

    public Integer timingAdvance() {
        return this.timingAdvance;
    }

    public String toString() {
        return "BaseMetric(id=" + id() + ", mobileClientId=" + mobileClientId() + ", measurementSequenceId=" + measurementSequenceId() + ", clientIp=" + clientIp() + ", dateTimeOfMeasurement=" + dateTimeOfMeasurement() + ", stateDuringMeasurement=" + stateDuringMeasurement() + ", accessTechnology=" + accessTechnology() + ", accessTypeRaw=" + accessTypeRaw() + ", signalStrength=" + signalStrength() + ", interference=" + interference() + ", simMCC=" + simMCC() + ", simMNC=" + simMNC() + ", secondarySimMCC=" + secondarySimMCC() + ", secondarySimMNC=" + secondarySimMNC() + ", numberOfSimSlots=" + numberOfSimSlots() + ", dataSimSlotNumber=" + dataSimSlotNumber() + ", networkMCC=" + networkMCC() + ", networkMNC=" + networkMNC() + ", latitude=" + latitude() + ", longitude=" + longitude() + ", gpsAccuracy=" + gpsAccuracy() + ", cellId=" + cellId() + ", lacId=" + lacId() + ", deviceBrand=" + deviceBrand() + ", deviceModel=" + deviceModel() + ", deviceVersion=" + deviceVersion() + ", sdkVersionNumber=" + sdkVersionNumber() + ", carrierName=" + carrierName() + ", secondaryCarrierName=" + secondaryCarrierName() + ", networkOperatorName=" + networkOperatorName() + ", os=" + os() + ", osVersion=" + osVersion() + ", readableDate=" + readableDate() + ", physicalCellId=" + physicalCellId() + ", absoluteRfChannelNumber=" + absoluteRfChannelNumber() + ", connectionAbsoluteRfChannelNumber=" + connectionAbsoluteRfChannelNumber() + ", cellBands=" + cellBands() + ", channelQualityIndicator=" + channelQualityIndicator() + ", referenceSignalSignalToNoiseRatio=" + referenceSignalSignalToNoiseRatio() + ", referenceSignalReceivedPower=" + referenceSignalReceivedPower() + ", referenceSignalReceivedQuality=" + referenceSignalReceivedQuality() + ", csiReferenceSignalReceivedPower=" + csiReferenceSignalReceivedPower() + ", csiReferenceSignalToNoiseAndInterferenceRatio=" + csiReferenceSignalToNoiseAndInterferenceRatio() + ", csiReferenceSignalReceivedQuality=" + csiReferenceSignalReceivedQuality() + ", ssReferenceSignalReceivedPower=" + ssReferenceSignalReceivedPower() + ", ssReferenceSignalReceivedQuality=" + ssReferenceSignalReceivedQuality() + ", ssReferenceSignalToNoiseAndInterferenceRatio=" + ssReferenceSignalToNoiseAndInterferenceRatio() + ", timingAdvance=" + timingAdvance() + ", signalStrengthAsu=" + signalStrengthAsu() + ", dbm=" + dbm() + ", debugString=" + debugString() + ", isDcNrRestricted=" + isDcNrRestricted() + ", isNrAvailable=" + isNrAvailable() + ", isEnDcAvailable=" + isEnDcAvailable() + ", nrState=" + nrState() + ", nrFrequencyRange=" + nrFrequencyRange() + ", isUsingCarrierAggregation=" + isUsingCarrierAggregation() + ", vopsSupport=" + vopsSupport() + ", cellBandwidths=" + cellBandwidths() + ", additionalPlmns=" + additionalPlmns() + ", altitude=" + altitude() + ", locationSpeed=" + locationSpeed() + ", locationSpeedAccuracy=" + locationSpeedAccuracy() + ", gpsVerticalAccuracy=" + gpsVerticalAccuracy() + ", getRestrictBackgroundStatus=" + getRestrictBackgroundStatus() + ", cellType=" + cellType() + ", isDefaultNetworkActive=" + isDefaultNetworkActive() + ", isActiveNetworkMetered=" + isActiveNetworkMetered() + ", isOnScreen=" + isOnScreen() + ", isRoaming=" + isRoaming() + ", locationAge=" + locationAge() + ", overrideNetworkType=" + overrideNetworkType() + ", accessNetworkTechnologyRaw=" + accessNetworkTechnologyRaw() + ", anonymize=" + anonymize() + ", sdkOrigin=" + sdkOrigin() + ", isRooted=" + isRooted() + ", isConnectedToVpn=" + isConnectedToVpn() + ", linkDownstreamBandwidth=" + linkDownstreamBandwidth() + ", linkUpstreamBandwidth=" + linkUpstreamBandwidth() + ", latencyType=" + latencyType() + ", serverIp=" + serverIp() + ", privateIp=" + privateIp() + ", gatewayIp=" + gatewayIp() + ", locationPermissionState=" + locationPermissionState() + ", serviceStateStatus=" + serviceStateStatus() + ", isNrCellSeen=" + isNrCellSeen() + ", isReadPhoneStatePermissionGranted=" + isReadPhoneStatePermissionGranted() + ", appVersionName=" + appVersionName() + ", appVersionCode=" + appVersionCode() + ", appLastUpdateTime=" + appLastUpdateTime() + ", duplexModeState=" + duplexModeState() + ", dozeModeState=" + dozeModeState() + ", callState=" + callState() + ", buildDevice=" + buildDevice() + ", buildHardware=" + buildHardware() + ", buildProduct=" + buildProduct() + ", appId=" + appId() + ", isSending=" + isSending() + ")";
    }

    public BaseMetric vopsSupport(Integer num) {
        this.vopsSupport = num;
        return this;
    }

    public Integer vopsSupport() {
        return this.vopsSupport;
    }
}
