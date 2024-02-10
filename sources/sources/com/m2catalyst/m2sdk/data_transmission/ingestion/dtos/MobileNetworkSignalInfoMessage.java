package com.m2catalyst.m2sdk.data_transmission.ingestion.dtos;

import com.m2catalyst.m2sdk.c;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

public final class MobileNetworkSignalInfoMessage extends Message<MobileNetworkSignalInfoMessage, Builder> {
    public static final ProtoAdapter<MobileNetworkSignalInfoMessage> ADAPTER = new ProtoAdapter_MobileNetworkSignalInfoMessage();
    public static final Double DEFAULT_ACCURACY;
    public static final Integer DEFAULT_ASU = 0;
    public static final Float DEFAULT_BAROMETRIC;
    public static final Integer DEFAULT_BASESTATIONID = 0;
    public static final Double DEFAULT_BASESTATIONLATITUDE;
    public static final Double DEFAULT_BASESTATIONLONGITUDE;
    public static final Integer DEFAULT_BITERRORRATE = 0;
    public static final Integer DEFAULT_CDMAASU = 0;
    public static final Integer DEFAULT_CDMADBM = 0;
    public static final Integer DEFAULT_CDMAECIO = 0;
    public static final Long DEFAULT_CELLTOWERINFOTIMESTAMP = 0L;
    public static final Integer DEFAULT_CID = 0;
    public static final Integer DEFAULT_COMPLETENESS = 0;
    public static final Integer DEFAULT_DATANETWORKTYPE = 0;
    public static final Long DEFAULT_DATARX = 0L;
    public static final Long DEFAULT_DATATX = 0L;
    public static final Integer DEFAULT_DBM = 0;
    public static final Integer DEFAULT_ECIO = 0;
    public static final Integer DEFAULT_EVDOASU = 0;
    public static final Integer DEFAULT_EVDODBM = 0;
    public static final Integer DEFAULT_EVDOECIO = 0;
    public static final Integer DEFAULT_EVDOSNR = 0;
    public static final Boolean DEFAULT_GPSAVAILABLE;
    public static final Integer DEFAULT_GSMARFCN = 0;
    public static final Integer DEFAULT_GSMASU = 0;
    public static final Integer DEFAULT_GSMBITERROR = 0;
    public static final Integer DEFAULT_GSMBSIC = 0;
    public static final Integer DEFAULT_GSMDBM = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Float DEFAULT_INDOOROUTDOORWEIGHT;
    public static final Boolean DEFAULT_IS5GCONNECTED;
    public static final Integer DEFAULT_ISDATADEFAULTSIM = 0;
    public static final Boolean DEFAULT_ISUSINGCARRIERAGGREGATION;
    public static final Integer DEFAULT_LAC = 0;
    public static final Double DEFAULT_LATITUDE;
    public static final String DEFAULT_LOCATIONPROVIDER = "";
    public static final Long DEFAULT_LOCATIONTIMESTAMP = 0L;
    public static final Double DEFAULT_LONGITUDE;
    public static final Integer DEFAULT_LTEASU = 0;
    public static final Integer DEFAULT_LTEBANDWIDTH = 0;
    public static final Integer DEFAULT_LTECI = 0;
    public static final Integer DEFAULT_LTECQI = 0;
    public static final Integer DEFAULT_LTEDBM = 0;
    public static final Integer DEFAULT_LTEEARFCN = 0;
    public static final Integer DEFAULT_LTEPCI = 0;
    public static final Integer DEFAULT_LTERSRP = 0;
    public static final Integer DEFAULT_LTERSRQ = 0;
    public static final Integer DEFAULT_LTERSSI = 0;
    public static final Integer DEFAULT_LTERSSNR = 0;
    public static final Integer DEFAULT_LTESIGNALSTRENGTH = 0;
    public static final Integer DEFAULT_LTETAC = 0;
    public static final Integer DEFAULT_LTETIMINGADVANCE = 0;
    public static final String DEFAULT_NETWORKCOUNTRYISO = "";
    public static final Integer DEFAULT_NETWORKID = 0;
    public static final Integer DEFAULT_NETWORKMCC = 0;
    public static final Integer DEFAULT_NETWORKMNC = 0;
    public static final String DEFAULT_NETWORKOPERATORNAME = "";
    public static final String DEFAULT_NETWORKTYPE = "";
    public static final Integer DEFAULT_NRARFCN = 0;
    public static final Integer DEFAULT_NRASULEVEL = 0;
    public static final Integer DEFAULT_NRCSIRSRP = 0;
    public static final Integer DEFAULT_NRCSIRSRQ = 0;
    public static final Integer DEFAULT_NRCSISINR = 0;
    public static final Integer DEFAULT_NRDBM = 0;
    public static final Integer DEFAULT_NRLEVEL = 0;
    public static final Long DEFAULT_NRNCI = 0L;
    public static final Integer DEFAULT_NRPCI = 0;
    public static final Integer DEFAULT_NRSSRSRP = 0;
    public static final Integer DEFAULT_NRSSRSRQ = 0;
    public static final Integer DEFAULT_NRSSSINR = 0;
    public static final Integer DEFAULT_NRTAC = 0;
    public static final Integer DEFAULT_OVERRIDENETWORKTYPE = 0;
    public static final String DEFAULT_PERMISSIONS = "";
    public static final String DEFAULT_PHONETYPE = "";
    public static final Integer DEFAULT_RAWNETWORKTYPE = 0;
    public static final Integer DEFAULT_REGISTERED = 0;
    public static final Integer DEFAULT_RESOURCESMCC = 0;
    public static final Integer DEFAULT_RESOURCESMNC = 0;
    public static final Boolean DEFAULT_ROAMING;
    public static final Integer DEFAULT_RSRP = 0;
    public static final Integer DEFAULT_RSRQ = 0;
    public static final Long DEFAULT_SECONDARYCELLNRNCI = 0L;
    public static final String DEFAULT_SIMCOUNTRYISO = "";
    public static final Integer DEFAULT_SIMMCC = 0;
    public static final Integer DEFAULT_SIMMNC = 0;
    public static final String DEFAULT_SIMOPERATORNAME = "";
    public static final Integer DEFAULT_SYSTEMID = 0;
    public static final Integer DEFAULT_TDSCDMAASU = 0;
    public static final Integer DEFAULT_TDSCDMADBM = 0;
    public static final String DEFAULT_TECHNOLOGY = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TIMEZONE = "";
    public static final Integer DEFAULT_TIMEZONEOFFSET = 0;
    public static final Integer DEFAULT_VOICENETWORKTYPE = 0;
    public static final Integer DEFAULT_WCDMAASU = 0;
    public static final Integer DEFAULT_WCDMABITERRORRATE = 0;
    public static final Integer DEFAULT_WCDMACID = 0;
    public static final Integer DEFAULT_WCDMADBM = 0;
    public static final Integer DEFAULT_WCDMALAC = 0;
    public static final Integer DEFAULT_WCDMAPSC = 0;
    public static final Integer DEFAULT_WCDMAUARFCN = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 45)
    public final Double accuracy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 35)
    public final Integer asu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 114)
    public final Float barometric;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer baseStationId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 27)
    public final Double baseStationLatitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 28)
    public final Double baseStationLongitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 39)
    public final Integer bitErrorRate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 65)
    public final Integer cdmaAsu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 64)
    public final Integer cdmaDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 66)
    public final Integer cdmaEcio;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 33)
    public final Long cellTowerInfoTimeStamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 31)
    public final Integer cid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 119)
    public final Integer completeness;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 87)
    public final Integer dataNetworkType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 94)
    public final Long dataRx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 95)
    public final Long dataTx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 34)
    public final Integer dbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 36)
    public final Integer ecio;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 68)
    public final Integer evdoAsu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 67)
    public final Integer evdoDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 69)
    public final Integer evdoEcio;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 70)
    public final Integer evdoSnr;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 76)
    public final Boolean gpsAvailable;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 90)
    public final Integer gsmArfcn;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 72)
    public final Integer gsmAsu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 73)
    public final Integer gsmBitError;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 91)
    public final Integer gsmBsic;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 71)
    public final Integer gsmDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 96)
    public final Float indoorOutdoorWeight;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 112)
    public final Boolean is5GConnected;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 122)
    public final Integer isDataDefaultSim;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 110)
    public final Boolean isUsingCarrierAggregation;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer lac;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 43)
    public final Double latitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 42)
    public final String locationProvider;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 41)
    public final Long locationTimeStamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 44)
    public final Double longitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 63)
    public final Integer lteAsu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 117)
    public final List<Integer> lteBand;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 120)
    public final Integer lteBandwidth;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 77)
    public final Integer lteCi;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 61)
    public final Integer lteCqi;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 62)
    public final Integer lteDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 89)
    public final Integer lteEarfcn;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 78)
    public final Integer ltePci;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 58)
    public final Integer lteRsrp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 59)
    public final Integer lteRsrq;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 116)
    public final Integer lteRssi;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 60)
    public final Integer lteRssnr;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 57)
    public final Integer lteSignalStrength;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 79)
    public final Integer lteTac;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 92)
    public final Integer lteTimingAdvance;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 47)
    public final String networkCountryIso;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 29)
    public final Integer networkId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 49)
    public final Integer networkMcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 48)
    public final Integer networkMnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 46)
    public final String networkOperatorName;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final String networkType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 98)
    public final Integer nrArfcn;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 101)
    public final Integer nrAsuLevel;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 115)
    public final List<Integer> nrBand;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 102)
    public final Integer nrCsiRsrp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 103)
    public final Integer nrCsiRsrq;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 104)
    public final Integer nrCsiSinr;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 105)
    public final Integer nrDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 106)
    public final Integer nrLevel;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 97)
    public final Long nrNci;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 99)
    public final Integer nrPci;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 107)
    public final Integer nrSsRsrp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 108)
    public final Integer nrSsRsrq;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 109)
    public final Integer nrSsSinr;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 100)
    public final Integer nrTac;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 113)
    public final Integer overrideNetworkType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 118)
    public final String permissions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 23)
    public final String phoneType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 86)
    public final Integer rawNetworkType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 56)
    public final Integer registered;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 55)
    public final Integer resourcesMcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 54)
    public final Integer resourcesMnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 85)
    public final Boolean roaming;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 37)
    public final Integer rsrp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 38)
    public final Integer rsrq;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 111)
    public final Long secondaryCellNrNci;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 51)
    public final String simCountryIso;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 53)
    public final Integer simMcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 52)
    public final Integer simMnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 50)
    public final String simOperatorName;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 30)
    public final Integer systemId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 75)
    public final Integer tdscdmaAsu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 74)
    public final Integer tdscdmaDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String technology;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 21)
    public final Long timeStamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 22)
    public final String timeZone;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 121)
    public final Integer timeZoneOffset;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 88)
    public final Integer voiceNetworkType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 81)
    public final Integer wcdmaAsu;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 40)
    public final Integer wcdmaBitErrorRate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 82)
    public final Integer wcdmaCid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 80)
    public final Integer wcdmaDbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 83)
    public final Integer wcdmaLac;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 84)
    public final Integer wcdmaPsc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 93)
    public final Integer wcdmaUarfcn;

    public static final class Builder extends Message.Builder<MobileNetworkSignalInfoMessage, Builder> {
        public Double accuracy;
        public Integer asu;
        public Float barometric;
        public Integer baseStationId;
        public Double baseStationLatitude;
        public Double baseStationLongitude;
        public Integer bitErrorRate;
        public Integer cdmaAsu;
        public Integer cdmaDbm;
        public Integer cdmaEcio;
        public Long cellTowerInfoTimeStamp;
        public Integer cid;
        public Integer completeness;
        public Integer dataNetworkType;
        public Long dataRx;
        public Long dataTx;
        public Integer dbm;
        public Integer ecio;
        public Integer evdoAsu;
        public Integer evdoDbm;
        public Integer evdoEcio;
        public Integer evdoSnr;
        public Boolean gpsAvailable;
        public Integer gsmArfcn;
        public Integer gsmAsu;
        public Integer gsmBitError;
        public Integer gsmBsic;
        public Integer gsmDbm;
        public Integer id;
        public Float indoorOutdoorWeight;
        public Boolean is5GConnected;
        public Integer isDataDefaultSim;
        public Boolean isUsingCarrierAggregation;
        public Integer lac;
        public Double latitude;
        public String locationProvider;
        public Long locationTimeStamp;
        public Double longitude;
        public Integer lteAsu;
        public List<Integer> lteBand = Internal.newMutableList();
        public Integer lteBandwidth;
        public Integer lteCi;
        public Integer lteCqi;
        public Integer lteDbm;
        public Integer lteEarfcn;
        public Integer ltePci;
        public Integer lteRsrp;
        public Integer lteRsrq;
        public Integer lteRssi;
        public Integer lteRssnr;
        public Integer lteSignalStrength;
        public Integer lteTac;
        public Integer lteTimingAdvance;
        public String networkCountryIso;
        public Integer networkId;
        public Integer networkMcc;
        public Integer networkMnc;
        public String networkOperatorName;
        public String networkType;
        public Integer nrArfcn;
        public Integer nrAsuLevel;
        public List<Integer> nrBand = Internal.newMutableList();
        public Integer nrCsiRsrp;
        public Integer nrCsiRsrq;
        public Integer nrCsiSinr;
        public Integer nrDbm;
        public Integer nrLevel;
        public Long nrNci;
        public Integer nrPci;
        public Integer nrSsRsrp;
        public Integer nrSsRsrq;
        public Integer nrSsSinr;
        public Integer nrTac;
        public Integer overrideNetworkType;
        public String permissions;
        public String phoneType;
        public Integer rawNetworkType;
        public Integer registered;
        public Integer resourcesMcc;
        public Integer resourcesMnc;
        public Boolean roaming;
        public Integer rsrp;
        public Integer rsrq;
        public Long secondaryCellNrNci;
        public String simCountryIso;
        public Integer simMcc;
        public Integer simMnc;
        public String simOperatorName;
        public Integer systemId;
        public Integer tdscdmaAsu;
        public Integer tdscdmaDbm;
        public String technology;
        public Long timeStamp;
        public String timeZone;
        public Integer timeZoneOffset;
        public Integer voiceNetworkType;
        public Integer wcdmaAsu;
        public Integer wcdmaBitErrorRate;
        public Integer wcdmaCid;
        public Integer wcdmaDbm;
        public Integer wcdmaLac;
        public Integer wcdmaPsc;
        public Integer wcdmaUarfcn;

        public Builder accuracy(Double d) {
            this.accuracy = d;
            return this;
        }

        public Builder asu(Integer num) {
            this.asu = num;
            return this;
        }

        public Builder barometric(Float f) {
            this.barometric = f;
            return this;
        }

        public Builder baseStationId(Integer num) {
            this.baseStationId = num;
            return this;
        }

        public Builder baseStationLatitude(Double d) {
            this.baseStationLatitude = d;
            return this;
        }

        public Builder baseStationLongitude(Double d) {
            this.baseStationLongitude = d;
            return this;
        }

        public Builder bitErrorRate(Integer num) {
            this.bitErrorRate = num;
            return this;
        }

        public Builder cdmaAsu(Integer num) {
            this.cdmaAsu = num;
            return this;
        }

        public Builder cdmaDbm(Integer num) {
            this.cdmaDbm = num;
            return this;
        }

        public Builder cdmaEcio(Integer num) {
            this.cdmaEcio = num;
            return this;
        }

        public Builder cellTowerInfoTimeStamp(Long l) {
            this.cellTowerInfoTimeStamp = l;
            return this;
        }

        public Builder cid(Integer num) {
            this.cid = num;
            return this;
        }

        public Builder completeness(Integer num) {
            this.completeness = num;
            return this;
        }

        public Builder dataNetworkType(Integer num) {
            this.dataNetworkType = num;
            return this;
        }

        public Builder dataRx(Long l) {
            this.dataRx = l;
            return this;
        }

        public Builder dataTx(Long l) {
            this.dataTx = l;
            return this;
        }

        public Builder dbm(Integer num) {
            this.dbm = num;
            return this;
        }

        public Builder ecio(Integer num) {
            this.ecio = num;
            return this;
        }

        public Builder evdoAsu(Integer num) {
            this.evdoAsu = num;
            return this;
        }

        public Builder evdoDbm(Integer num) {
            this.evdoDbm = num;
            return this;
        }

        public Builder evdoEcio(Integer num) {
            this.evdoEcio = num;
            return this;
        }

        public Builder evdoSnr(Integer num) {
            this.evdoSnr = num;
            return this;
        }

        public Builder gpsAvailable(Boolean bool) {
            this.gpsAvailable = bool;
            return this;
        }

        public Builder gsmArfcn(Integer num) {
            this.gsmArfcn = num;
            return this;
        }

        public Builder gsmAsu(Integer num) {
            this.gsmAsu = num;
            return this;
        }

        public Builder gsmBitError(Integer num) {
            this.gsmBitError = num;
            return this;
        }

        public Builder gsmBsic(Integer num) {
            this.gsmBsic = num;
            return this;
        }

        public Builder gsmDbm(Integer num) {
            this.gsmDbm = num;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder indoorOutdoorWeight(Float f) {
            this.indoorOutdoorWeight = f;
            return this;
        }

        public Builder is5GConnected(Boolean bool) {
            this.is5GConnected = bool;
            return this;
        }

        public Builder isDataDefaultSim(Integer num) {
            this.isDataDefaultSim = num;
            return this;
        }

        public Builder isUsingCarrierAggregation(Boolean bool) {
            this.isUsingCarrierAggregation = bool;
            return this;
        }

        public Builder lac(Integer num) {
            this.lac = num;
            return this;
        }

        public Builder latitude(Double d) {
            this.latitude = d;
            return this;
        }

        public Builder locationProvider(String str) {
            this.locationProvider = str;
            return this;
        }

        public Builder locationTimeStamp(Long l) {
            this.locationTimeStamp = l;
            return this;
        }

        public Builder longitude(Double d) {
            this.longitude = d;
            return this;
        }

        public Builder lteAsu(Integer num) {
            this.lteAsu = num;
            return this;
        }

        public Builder lteBand(List<Integer> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.lteBand = list;
            return this;
        }

        public Builder lteBandwidth(Integer num) {
            this.lteBandwidth = num;
            return this;
        }

        public Builder lteCi(Integer num) {
            this.lteCi = num;
            return this;
        }

        public Builder lteCqi(Integer num) {
            this.lteCqi = num;
            return this;
        }

        public Builder lteDbm(Integer num) {
            this.lteDbm = num;
            return this;
        }

        public Builder lteEarfcn(Integer num) {
            this.lteEarfcn = num;
            return this;
        }

        public Builder ltePci(Integer num) {
            this.ltePci = num;
            return this;
        }

        public Builder lteRsrp(Integer num) {
            this.lteRsrp = num;
            return this;
        }

        public Builder lteRsrq(Integer num) {
            this.lteRsrq = num;
            return this;
        }

        public Builder lteRssi(Integer num) {
            this.lteRssi = num;
            return this;
        }

        public Builder lteRssnr(Integer num) {
            this.lteRssnr = num;
            return this;
        }

        public Builder lteSignalStrength(Integer num) {
            this.lteSignalStrength = num;
            return this;
        }

        public Builder lteTac(Integer num) {
            this.lteTac = num;
            return this;
        }

        public Builder lteTimingAdvance(Integer num) {
            this.lteTimingAdvance = num;
            return this;
        }

        public Builder networkCountryIso(String str) {
            this.networkCountryIso = str;
            return this;
        }

        public Builder networkId(Integer num) {
            this.networkId = num;
            return this;
        }

        public Builder networkMcc(Integer num) {
            this.networkMcc = num;
            return this;
        }

        public Builder networkMnc(Integer num) {
            this.networkMnc = num;
            return this;
        }

        public Builder networkOperatorName(String str) {
            this.networkOperatorName = str;
            return this;
        }

        public Builder networkType(String str) {
            this.networkType = str;
            return this;
        }

        public Builder nrArfcn(Integer num) {
            this.nrArfcn = num;
            return this;
        }

        public Builder nrAsuLevel(Integer num) {
            this.nrAsuLevel = num;
            return this;
        }

        public Builder nrBand(List<Integer> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.nrBand = list;
            return this;
        }

        public Builder nrCsiRsrp(Integer num) {
            this.nrCsiRsrp = num;
            return this;
        }

        public Builder nrCsiRsrq(Integer num) {
            this.nrCsiRsrq = num;
            return this;
        }

        public Builder nrCsiSinr(Integer num) {
            this.nrCsiSinr = num;
            return this;
        }

        public Builder nrDbm(Integer num) {
            this.nrDbm = num;
            return this;
        }

        public Builder nrLevel(Integer num) {
            this.nrLevel = num;
            return this;
        }

        public Builder nrNci(Long l) {
            this.nrNci = l;
            return this;
        }

        public Builder nrPci(Integer num) {
            this.nrPci = num;
            return this;
        }

        public Builder nrSsRsrp(Integer num) {
            this.nrSsRsrp = num;
            return this;
        }

        public Builder nrSsRsrq(Integer num) {
            this.nrSsRsrq = num;
            return this;
        }

        public Builder nrSsSinr(Integer num) {
            this.nrSsSinr = num;
            return this;
        }

        public Builder nrTac(Integer num) {
            this.nrTac = num;
            return this;
        }

        public Builder overrideNetworkType(Integer num) {
            this.overrideNetworkType = num;
            return this;
        }

        public Builder permissions(String str) {
            this.permissions = str;
            return this;
        }

        public Builder phoneType(String str) {
            this.phoneType = str;
            return this;
        }

        public Builder rawNetworkType(Integer num) {
            this.rawNetworkType = num;
            return this;
        }

        public Builder registered(Integer num) {
            this.registered = num;
            return this;
        }

        public Builder resourcesMcc(Integer num) {
            this.resourcesMcc = num;
            return this;
        }

        public Builder resourcesMnc(Integer num) {
            this.resourcesMnc = num;
            return this;
        }

        public Builder roaming(Boolean bool) {
            this.roaming = bool;
            return this;
        }

        public Builder rsrp(Integer num) {
            this.rsrp = num;
            return this;
        }

        public Builder rsrq(Integer num) {
            this.rsrq = num;
            return this;
        }

        public Builder secondaryCellNrNci(Long l) {
            this.secondaryCellNrNci = l;
            return this;
        }

        public Builder simCountryIso(String str) {
            this.simCountryIso = str;
            return this;
        }

        public Builder simMcc(Integer num) {
            this.simMcc = num;
            return this;
        }

        public Builder simMnc(Integer num) {
            this.simMnc = num;
            return this;
        }

        public Builder simOperatorName(String str) {
            this.simOperatorName = str;
            return this;
        }

        public Builder systemId(Integer num) {
            this.systemId = num;
            return this;
        }

        public Builder tdscdmaAsu(Integer num) {
            this.tdscdmaAsu = num;
            return this;
        }

        public Builder tdscdmaDbm(Integer num) {
            this.tdscdmaDbm = num;
            return this;
        }

        public Builder technology(String str) {
            this.technology = str;
            return this;
        }

        public Builder timeStamp(Long l) {
            this.timeStamp = l;
            return this;
        }

        public Builder timeZone(String str) {
            this.timeZone = str;
            return this;
        }

        public Builder timeZoneOffset(Integer num) {
            this.timeZoneOffset = num;
            return this;
        }

        public Builder voiceNetworkType(Integer num) {
            this.voiceNetworkType = num;
            return this;
        }

        public Builder wcdmaAsu(Integer num) {
            this.wcdmaAsu = num;
            return this;
        }

        public Builder wcdmaBitErrorRate(Integer num) {
            this.wcdmaBitErrorRate = num;
            return this;
        }

        public Builder wcdmaCid(Integer num) {
            this.wcdmaCid = num;
            return this;
        }

        public Builder wcdmaDbm(Integer num) {
            this.wcdmaDbm = num;
            return this;
        }

        public Builder wcdmaLac(Integer num) {
            this.wcdmaLac = num;
            return this;
        }

        public Builder wcdmaPsc(Integer num) {
            this.wcdmaPsc = num;
            return this;
        }

        public Builder wcdmaUarfcn(Integer num) {
            this.wcdmaUarfcn = num;
            return this;
        }

        public MobileNetworkSignalInfoMessage build() {
            return new MobileNetworkSignalInfoMessage(this.id, this.timeStamp, this.timeZone, this.phoneType, this.networkType, this.technology, this.baseStationId, this.baseStationLatitude, this.baseStationLongitude, this.networkId, this.systemId, this.cid, this.lac, this.cellTowerInfoTimeStamp, this.dbm, this.asu, this.ecio, this.rsrp, this.rsrq, this.bitErrorRate, this.wcdmaBitErrorRate, this.locationTimeStamp, this.locationProvider, this.latitude, this.longitude, this.accuracy, this.networkOperatorName, this.networkCountryIso, this.networkMnc, this.networkMcc, this.simOperatorName, this.simCountryIso, this.simMnc, this.simMcc, this.resourcesMnc, this.resourcesMcc, this.registered, this.lteSignalStrength, this.lteRsrp, this.lteRsrq, this.lteRssnr, this.lteCqi, this.lteDbm, this.lteAsu, this.cdmaDbm, this.cdmaAsu, this.cdmaEcio, this.evdoDbm, this.evdoAsu, this.evdoEcio, this.evdoSnr, this.gsmDbm, this.gsmAsu, this.gsmBitError, this.tdscdmaDbm, this.tdscdmaAsu, this.gpsAvailable, this.lteCi, this.ltePci, this.lteTac, this.wcdmaDbm, this.wcdmaAsu, this.wcdmaCid, this.wcdmaLac, this.wcdmaPsc, this.roaming, this.rawNetworkType, this.dataNetworkType, this.voiceNetworkType, this.lteEarfcn, this.gsmArfcn, this.gsmBsic, this.lteTimingAdvance, this.wcdmaUarfcn, this.dataRx, this.dataTx, this.indoorOutdoorWeight, this.nrNci, this.nrArfcn, this.nrPci, this.nrTac, this.nrAsuLevel, this.nrCsiRsrp, this.nrCsiRsrq, this.nrCsiSinr, this.nrDbm, this.nrLevel, this.nrSsRsrp, this.nrSsRsrq, this.nrSsSinr, this.isUsingCarrierAggregation, this.secondaryCellNrNci, this.is5GConnected, this.overrideNetworkType, this.barometric, this.nrBand, this.lteRssi, this.lteBand, this.permissions, this.completeness, this.lteBandwidth, this.timeZoneOffset, this.isDataDefaultSim, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MobileNetworkSignalInfoMessage extends ProtoAdapter<MobileNetworkSignalInfoMessage> {
        public ProtoAdapter_MobileNetworkSignalInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MobileNetworkSignalInfoMessage.class);
        }

        public MobileNetworkSignalInfoMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 20:
                            builder.id(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 21:
                            builder.timeStamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 22:
                            builder.timeZone(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 23:
                            builder.phoneType(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 24:
                            builder.networkType(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 25:
                            builder.technology(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 26:
                            builder.baseStationId(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 27:
                            builder.baseStationLatitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 28:
                            builder.baseStationLongitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 29:
                            builder.networkId(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 30:
                            builder.systemId(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 31:
                            builder.cid(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 32:
                            builder.lac(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 33:
                            builder.cellTowerInfoTimeStamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 34:
                            builder.dbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 35:
                            builder.asu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 36:
                            builder.ecio(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 37:
                            builder.rsrp(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 38:
                            builder.rsrq(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 39:
                            builder.bitErrorRate(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 40:
                            builder.wcdmaBitErrorRate(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 41:
                            builder.locationTimeStamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 42:
                            builder.locationProvider(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 43:
                            builder.latitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 44:
                            builder.longitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 45:
                            builder.accuracy(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 46:
                            builder.networkOperatorName(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 47:
                            builder.networkCountryIso(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 48:
                            builder.networkMnc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 49:
                            builder.networkMcc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 50:
                            builder.simOperatorName(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 51:
                            builder.simCountryIso(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 52:
                            builder.simMnc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 53:
                            builder.simMcc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 54:
                            builder.resourcesMnc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 55:
                            builder.resourcesMcc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 56:
                            builder.registered(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 57:
                            builder.lteSignalStrength(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 58:
                            builder.lteRsrp(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 59:
                            builder.lteRsrq(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 60:
                            builder.lteRssnr(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 61:
                            builder.lteCqi(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 62:
                            builder.lteDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 63:
                            builder.lteAsu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 64:
                            builder.cdmaDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 65:
                            builder.cdmaAsu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 66:
                            builder.cdmaEcio(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 67:
                            builder.evdoDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 68:
                            builder.evdoAsu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 69:
                            builder.evdoEcio(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 70:
                            builder.evdoSnr(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 71:
                            builder.gsmDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 72:
                            builder.gsmAsu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 73:
                            builder.gsmBitError(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 74:
                            builder.tdscdmaDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 75:
                            builder.tdscdmaAsu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 76:
                            builder.gpsAvailable(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 77:
                            builder.lteCi(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 78:
                            builder.ltePci(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 79:
                            builder.lteTac(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 80:
                            builder.wcdmaDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 81:
                            builder.wcdmaAsu(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 82:
                            builder.wcdmaCid(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 83:
                            builder.wcdmaLac(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 84:
                            builder.wcdmaPsc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 85:
                            builder.roaming(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 86:
                            builder.rawNetworkType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 87:
                            builder.dataNetworkType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 88:
                            builder.voiceNetworkType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 89:
                            builder.lteEarfcn(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 90:
                            builder.gsmArfcn(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 91:
                            builder.gsmBsic(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 92:
                            builder.lteTimingAdvance(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 93:
                            builder.wcdmaUarfcn(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 94:
                            builder.dataRx(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 95:
                            builder.dataTx(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 96:
                            builder.indoorOutdoorWeight(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 97:
                            builder.nrNci(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 98:
                            builder.nrArfcn(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 99:
                            builder.nrPci(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 100:
                            builder.nrTac(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 101:
                            builder.nrAsuLevel(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 102:
                            builder.nrCsiRsrp(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 103:
                            builder.nrCsiRsrq(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 104:
                            builder.nrCsiSinr(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 105:
                            builder.nrDbm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 106:
                            builder.nrLevel(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 107:
                            builder.nrSsRsrp(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 108:
                            builder.nrSsRsrq(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 109:
                            builder.nrSsSinr(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 110:
                            builder.isUsingCarrierAggregation(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 111:
                            builder.secondaryCellNrNci(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 112:
                            builder.is5GConnected(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 113:
                            builder.overrideNetworkType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 114:
                            builder.barometric(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 115:
                            builder.nrBand.add(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 116:
                            builder.lteRssi(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 117:
                            builder.lteBand.add(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 118:
                            builder.permissions(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 119:
                            builder.completeness(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 120:
                            builder.lteBandwidth(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 121:
                            builder.timeZoneOffset(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 122:
                            builder.isDataDefaultSim(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public void encode(ProtoWriter protoWriter, MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage) {
            Integer num = mobileNetworkSignalInfoMessage.id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 20, num);
            }
            Long l = mobileNetworkSignalInfoMessage.timeStamp;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 21, l);
            }
            String str = mobileNetworkSignalInfoMessage.timeZone;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 22, str);
            }
            String str2 = mobileNetworkSignalInfoMessage.phoneType;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 23, str2);
            }
            String str3 = mobileNetworkSignalInfoMessage.networkType;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 24, str3);
            }
            String str4 = mobileNetworkSignalInfoMessage.technology;
            if (str4 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 25, str4);
            }
            Integer num2 = mobileNetworkSignalInfoMessage.baseStationId;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num2);
            }
            Double d = mobileNetworkSignalInfoMessage.baseStationLatitude;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 27, d);
            }
            Double d2 = mobileNetworkSignalInfoMessage.baseStationLongitude;
            if (d2 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 28, d2);
            }
            Integer num3 = mobileNetworkSignalInfoMessage.networkId;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 29, num3);
            }
            Integer num4 = mobileNetworkSignalInfoMessage.systemId;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 30, num4);
            }
            Integer num5 = mobileNetworkSignalInfoMessage.cid;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 31, num5);
            }
            Integer num6 = mobileNetworkSignalInfoMessage.lac;
            if (num6 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num6);
            }
            Long l2 = mobileNetworkSignalInfoMessage.cellTowerInfoTimeStamp;
            if (l2 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 33, l2);
            }
            Integer num7 = mobileNetworkSignalInfoMessage.dbm;
            if (num7 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 34, num7);
            }
            Integer num8 = mobileNetworkSignalInfoMessage.asu;
            if (num8 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 35, num8);
            }
            Integer num9 = mobileNetworkSignalInfoMessage.ecio;
            if (num9 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 36, num9);
            }
            Integer num10 = mobileNetworkSignalInfoMessage.rsrp;
            if (num10 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 37, num10);
            }
            Integer num11 = mobileNetworkSignalInfoMessage.rsrq;
            if (num11 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 38, num11);
            }
            Integer num12 = mobileNetworkSignalInfoMessage.bitErrorRate;
            if (num12 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 39, num12);
            }
            Integer num13 = mobileNetworkSignalInfoMessage.wcdmaBitErrorRate;
            if (num13 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 40, num13);
            }
            Long l3 = mobileNetworkSignalInfoMessage.locationTimeStamp;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 41, l3);
            }
            String str5 = mobileNetworkSignalInfoMessage.locationProvider;
            if (str5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 42, str5);
            }
            Double d3 = mobileNetworkSignalInfoMessage.latitude;
            if (d3 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 43, d3);
            }
            Double d4 = mobileNetworkSignalInfoMessage.longitude;
            if (d4 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 44, d4);
            }
            Double d5 = mobileNetworkSignalInfoMessage.accuracy;
            if (d5 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 45, d5);
            }
            String str6 = mobileNetworkSignalInfoMessage.networkOperatorName;
            if (str6 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 46, str6);
            }
            String str7 = mobileNetworkSignalInfoMessage.networkCountryIso;
            if (str7 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 47, str7);
            }
            Integer num14 = mobileNetworkSignalInfoMessage.networkMnc;
            if (num14 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 48, num14);
            }
            Integer num15 = mobileNetworkSignalInfoMessage.networkMcc;
            if (num15 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 49, num15);
            }
            String str8 = mobileNetworkSignalInfoMessage.simOperatorName;
            if (str8 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 50, str8);
            }
            String str9 = mobileNetworkSignalInfoMessage.simCountryIso;
            if (str9 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 51, str9);
            }
            Integer num16 = mobileNetworkSignalInfoMessage.simMnc;
            if (num16 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 52, num16);
            }
            Integer num17 = mobileNetworkSignalInfoMessage.simMcc;
            if (num17 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 53, num17);
            }
            Integer num18 = mobileNetworkSignalInfoMessage.resourcesMnc;
            if (num18 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 54, num18);
            }
            Integer num19 = mobileNetworkSignalInfoMessage.resourcesMcc;
            if (num19 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 55, num19);
            }
            Integer num20 = mobileNetworkSignalInfoMessage.registered;
            if (num20 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 56, num20);
            }
            Integer num21 = mobileNetworkSignalInfoMessage.lteSignalStrength;
            if (num21 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 57, num21);
            }
            Integer num22 = mobileNetworkSignalInfoMessage.lteRsrp;
            if (num22 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 58, num22);
            }
            Integer num23 = mobileNetworkSignalInfoMessage.lteRsrq;
            if (num23 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 59, num23);
            }
            Integer num24 = mobileNetworkSignalInfoMessage.lteRssnr;
            if (num24 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 60, num24);
            }
            Integer num25 = mobileNetworkSignalInfoMessage.lteCqi;
            if (num25 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 61, num25);
            }
            Integer num26 = mobileNetworkSignalInfoMessage.lteDbm;
            if (num26 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 62, num26);
            }
            Integer num27 = mobileNetworkSignalInfoMessage.lteAsu;
            if (num27 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 63, num27);
            }
            Integer num28 = mobileNetworkSignalInfoMessage.cdmaDbm;
            if (num28 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 64, num28);
            }
            Integer num29 = mobileNetworkSignalInfoMessage.cdmaAsu;
            if (num29 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 65, num29);
            }
            Integer num30 = mobileNetworkSignalInfoMessage.cdmaEcio;
            if (num30 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 66, num30);
            }
            Integer num31 = mobileNetworkSignalInfoMessage.evdoDbm;
            if (num31 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 67, num31);
            }
            Integer num32 = mobileNetworkSignalInfoMessage.evdoAsu;
            if (num32 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 68, num32);
            }
            Integer num33 = mobileNetworkSignalInfoMessage.evdoEcio;
            if (num33 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 69, num33);
            }
            Integer num34 = mobileNetworkSignalInfoMessage.evdoSnr;
            if (num34 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 70, num34);
            }
            Integer num35 = mobileNetworkSignalInfoMessage.gsmDbm;
            if (num35 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 71, num35);
            }
            Integer num36 = mobileNetworkSignalInfoMessage.gsmAsu;
            if (num36 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 72, num36);
            }
            Integer num37 = mobileNetworkSignalInfoMessage.gsmBitError;
            if (num37 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 73, num37);
            }
            Integer num38 = mobileNetworkSignalInfoMessage.tdscdmaDbm;
            if (num38 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 74, num38);
            }
            Integer num39 = mobileNetworkSignalInfoMessage.tdscdmaAsu;
            if (num39 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 75, num39);
            }
            Boolean bool = mobileNetworkSignalInfoMessage.gpsAvailable;
            if (bool != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 76, bool);
            }
            Integer num40 = mobileNetworkSignalInfoMessage.lteCi;
            if (num40 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 77, num40);
            }
            Integer num41 = mobileNetworkSignalInfoMessage.ltePci;
            if (num41 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 78, num41);
            }
            Integer num42 = mobileNetworkSignalInfoMessage.lteTac;
            if (num42 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 79, num42);
            }
            Integer num43 = mobileNetworkSignalInfoMessage.wcdmaDbm;
            if (num43 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 80, num43);
            }
            Integer num44 = mobileNetworkSignalInfoMessage.wcdmaAsu;
            if (num44 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 81, num44);
            }
            Integer num45 = mobileNetworkSignalInfoMessage.wcdmaCid;
            if (num45 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 82, num45);
            }
            Integer num46 = mobileNetworkSignalInfoMessage.wcdmaLac;
            if (num46 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 83, num46);
            }
            Integer num47 = mobileNetworkSignalInfoMessage.wcdmaPsc;
            if (num47 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 84, num47);
            }
            Boolean bool2 = mobileNetworkSignalInfoMessage.roaming;
            if (bool2 != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 85, bool2);
            }
            Integer num48 = mobileNetworkSignalInfoMessage.rawNetworkType;
            if (num48 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 86, num48);
            }
            Integer num49 = mobileNetworkSignalInfoMessage.dataNetworkType;
            if (num49 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 87, num49);
            }
            Integer num50 = mobileNetworkSignalInfoMessage.voiceNetworkType;
            if (num50 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 88, num50);
            }
            Integer num51 = mobileNetworkSignalInfoMessage.lteEarfcn;
            if (num51 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 89, num51);
            }
            Integer num52 = mobileNetworkSignalInfoMessage.gsmArfcn;
            if (num52 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 90, num52);
            }
            Integer num53 = mobileNetworkSignalInfoMessage.gsmBsic;
            if (num53 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 91, num53);
            }
            Integer num54 = mobileNetworkSignalInfoMessage.lteTimingAdvance;
            if (num54 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 92, num54);
            }
            Integer num55 = mobileNetworkSignalInfoMessage.wcdmaUarfcn;
            if (num55 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 93, num55);
            }
            Long l4 = mobileNetworkSignalInfoMessage.dataRx;
            if (l4 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 94, l4);
            }
            Long l5 = mobileNetworkSignalInfoMessage.dataTx;
            if (l5 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 95, l5);
            }
            Float f = mobileNetworkSignalInfoMessage.indoorOutdoorWeight;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 96, f);
            }
            Long l6 = mobileNetworkSignalInfoMessage.nrNci;
            if (l6 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 97, l6);
            }
            Integer num56 = mobileNetworkSignalInfoMessage.nrArfcn;
            if (num56 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 98, num56);
            }
            Integer num57 = mobileNetworkSignalInfoMessage.nrPci;
            if (num57 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 99, num57);
            }
            Integer num58 = mobileNetworkSignalInfoMessage.nrTac;
            if (num58 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 100, num58);
            }
            Integer num59 = mobileNetworkSignalInfoMessage.nrAsuLevel;
            if (num59 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 101, num59);
            }
            Integer num60 = mobileNetworkSignalInfoMessage.nrCsiRsrp;
            if (num60 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 102, num60);
            }
            Integer num61 = mobileNetworkSignalInfoMessage.nrCsiRsrq;
            if (num61 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 103, num61);
            }
            Integer num62 = mobileNetworkSignalInfoMessage.nrCsiSinr;
            if (num62 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 104, num62);
            }
            Integer num63 = mobileNetworkSignalInfoMessage.nrDbm;
            if (num63 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 105, num63);
            }
            Integer num64 = mobileNetworkSignalInfoMessage.nrLevel;
            if (num64 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 106, num64);
            }
            Integer num65 = mobileNetworkSignalInfoMessage.nrSsRsrp;
            if (num65 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 107, num65);
            }
            Integer num66 = mobileNetworkSignalInfoMessage.nrSsRsrq;
            if (num66 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 108, num66);
            }
            Integer num67 = mobileNetworkSignalInfoMessage.nrSsSinr;
            if (num67 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 109, num67);
            }
            Boolean bool3 = mobileNetworkSignalInfoMessage.isUsingCarrierAggregation;
            if (bool3 != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 110, bool3);
            }
            Long l7 = mobileNetworkSignalInfoMessage.secondaryCellNrNci;
            if (l7 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 111, l7);
            }
            Boolean bool4 = mobileNetworkSignalInfoMessage.is5GConnected;
            if (bool4 != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 112, bool4);
            }
            Integer num68 = mobileNetworkSignalInfoMessage.overrideNetworkType;
            if (num68 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 113, num68);
            }
            Float f2 = mobileNetworkSignalInfoMessage.barometric;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 114, f2);
            }
            ProtoAdapter.INT32.asRepeated().encodeWithTag(protoWriter, 115, mobileNetworkSignalInfoMessage.nrBand);
            Integer num69 = mobileNetworkSignalInfoMessage.lteRssi;
            if (num69 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 116, num69);
            }
            ProtoAdapter.INT32.asRepeated().encodeWithTag(protoWriter, 117, mobileNetworkSignalInfoMessage.lteBand);
            String str10 = mobileNetworkSignalInfoMessage.permissions;
            if (str10 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 118, str10);
            }
            Integer num70 = mobileNetworkSignalInfoMessage.completeness;
            if (num70 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 119, num70);
            }
            Integer num71 = mobileNetworkSignalInfoMessage.lteBandwidth;
            if (num71 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 120, num71);
            }
            Integer num72 = mobileNetworkSignalInfoMessage.timeZoneOffset;
            if (num72 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 121, num72);
            }
            Integer num73 = mobileNetworkSignalInfoMessage.isDataDefaultSim;
            if (num73 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 122, num73);
            }
            protoWriter.writeBytes(mobileNetworkSignalInfoMessage.unknownFields());
        }

        public int encodedSize(MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage) {
            Integer num = mobileNetworkSignalInfoMessage.id;
            int i = 0;
            int encodedSizeWithTag = num != null ? ProtoAdapter.INT32.encodedSizeWithTag(20, num) : 0;
            Long l = mobileNetworkSignalInfoMessage.timeStamp;
            int encodedSizeWithTag2 = encodedSizeWithTag + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(21, l) : 0);
            String str = mobileNetworkSignalInfoMessage.timeZone;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(22, str) : 0);
            String str2 = mobileNetworkSignalInfoMessage.phoneType;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(23, str2) : 0);
            String str3 = mobileNetworkSignalInfoMessage.networkType;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (str3 != null ? ProtoAdapter.STRING.encodedSizeWithTag(24, str3) : 0);
            String str4 = mobileNetworkSignalInfoMessage.technology;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (str4 != null ? ProtoAdapter.STRING.encodedSizeWithTag(25, str4) : 0);
            Integer num2 = mobileNetworkSignalInfoMessage.baseStationId;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(26, num2) : 0);
            Double d = mobileNetworkSignalInfoMessage.baseStationLatitude;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(27, d) : 0);
            Double d2 = mobileNetworkSignalInfoMessage.baseStationLongitude;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (d2 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(28, d2) : 0);
            Integer num3 = mobileNetworkSignalInfoMessage.networkId;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(29, num3) : 0);
            Integer num4 = mobileNetworkSignalInfoMessage.systemId;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(30, num4) : 0);
            Integer num5 = mobileNetworkSignalInfoMessage.cid;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(31, num5) : 0);
            Integer num6 = mobileNetworkSignalInfoMessage.lac;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (num6 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num6) : 0);
            Long l2 = mobileNetworkSignalInfoMessage.cellTowerInfoTimeStamp;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (l2 != null ? ProtoAdapter.INT64.encodedSizeWithTag(33, l2) : 0);
            Integer num7 = mobileNetworkSignalInfoMessage.dbm;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (num7 != null ? ProtoAdapter.INT32.encodedSizeWithTag(34, num7) : 0);
            Integer num8 = mobileNetworkSignalInfoMessage.asu;
            int encodedSizeWithTag16 = encodedSizeWithTag15 + (num8 != null ? ProtoAdapter.INT32.encodedSizeWithTag(35, num8) : 0);
            Integer num9 = mobileNetworkSignalInfoMessage.ecio;
            int encodedSizeWithTag17 = encodedSizeWithTag16 + (num9 != null ? ProtoAdapter.INT32.encodedSizeWithTag(36, num9) : 0);
            Integer num10 = mobileNetworkSignalInfoMessage.rsrp;
            int encodedSizeWithTag18 = encodedSizeWithTag17 + (num10 != null ? ProtoAdapter.INT32.encodedSizeWithTag(37, num10) : 0);
            Integer num11 = mobileNetworkSignalInfoMessage.rsrq;
            int encodedSizeWithTag19 = encodedSizeWithTag18 + (num11 != null ? ProtoAdapter.INT32.encodedSizeWithTag(38, num11) : 0);
            Integer num12 = mobileNetworkSignalInfoMessage.bitErrorRate;
            int encodedSizeWithTag20 = encodedSizeWithTag19 + (num12 != null ? ProtoAdapter.INT32.encodedSizeWithTag(39, num12) : 0);
            Integer num13 = mobileNetworkSignalInfoMessage.wcdmaBitErrorRate;
            int encodedSizeWithTag21 = encodedSizeWithTag20 + (num13 != null ? ProtoAdapter.INT32.encodedSizeWithTag(40, num13) : 0);
            Long l3 = mobileNetworkSignalInfoMessage.locationTimeStamp;
            int encodedSizeWithTag22 = encodedSizeWithTag21 + (l3 != null ? ProtoAdapter.INT64.encodedSizeWithTag(41, l3) : 0);
            String str5 = mobileNetworkSignalInfoMessage.locationProvider;
            int encodedSizeWithTag23 = encodedSizeWithTag22 + (str5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(42, str5) : 0);
            Double d3 = mobileNetworkSignalInfoMessage.latitude;
            int encodedSizeWithTag24 = encodedSizeWithTag23 + (d3 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(43, d3) : 0);
            Double d4 = mobileNetworkSignalInfoMessage.longitude;
            int encodedSizeWithTag25 = encodedSizeWithTag24 + (d4 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(44, d4) : 0);
            Double d5 = mobileNetworkSignalInfoMessage.accuracy;
            int encodedSizeWithTag26 = encodedSizeWithTag25 + (d5 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(45, d5) : 0);
            String str6 = mobileNetworkSignalInfoMessage.networkOperatorName;
            int encodedSizeWithTag27 = encodedSizeWithTag26 + (str6 != null ? ProtoAdapter.STRING.encodedSizeWithTag(46, str6) : 0);
            String str7 = mobileNetworkSignalInfoMessage.networkCountryIso;
            int encodedSizeWithTag28 = encodedSizeWithTag27 + (str7 != null ? ProtoAdapter.STRING.encodedSizeWithTag(47, str7) : 0);
            Integer num14 = mobileNetworkSignalInfoMessage.networkMnc;
            int encodedSizeWithTag29 = encodedSizeWithTag28 + (num14 != null ? ProtoAdapter.INT32.encodedSizeWithTag(48, num14) : 0);
            Integer num15 = mobileNetworkSignalInfoMessage.networkMcc;
            int encodedSizeWithTag30 = encodedSizeWithTag29 + (num15 != null ? ProtoAdapter.INT32.encodedSizeWithTag(49, num15) : 0);
            String str8 = mobileNetworkSignalInfoMessage.simOperatorName;
            int encodedSizeWithTag31 = encodedSizeWithTag30 + (str8 != null ? ProtoAdapter.STRING.encodedSizeWithTag(50, str8) : 0);
            String str9 = mobileNetworkSignalInfoMessage.simCountryIso;
            int encodedSizeWithTag32 = encodedSizeWithTag31 + (str9 != null ? ProtoAdapter.STRING.encodedSizeWithTag(51, str9) : 0);
            Integer num16 = mobileNetworkSignalInfoMessage.simMnc;
            int encodedSizeWithTag33 = encodedSizeWithTag32 + (num16 != null ? ProtoAdapter.INT32.encodedSizeWithTag(52, num16) : 0);
            Integer num17 = mobileNetworkSignalInfoMessage.simMcc;
            int encodedSizeWithTag34 = encodedSizeWithTag33 + (num17 != null ? ProtoAdapter.INT32.encodedSizeWithTag(53, num17) : 0);
            Integer num18 = mobileNetworkSignalInfoMessage.resourcesMnc;
            int encodedSizeWithTag35 = encodedSizeWithTag34 + (num18 != null ? ProtoAdapter.INT32.encodedSizeWithTag(54, num18) : 0);
            Integer num19 = mobileNetworkSignalInfoMessage.resourcesMcc;
            int encodedSizeWithTag36 = encodedSizeWithTag35 + (num19 != null ? ProtoAdapter.INT32.encodedSizeWithTag(55, num19) : 0);
            Integer num20 = mobileNetworkSignalInfoMessage.registered;
            int encodedSizeWithTag37 = encodedSizeWithTag36 + (num20 != null ? ProtoAdapter.INT32.encodedSizeWithTag(56, num20) : 0);
            Integer num21 = mobileNetworkSignalInfoMessage.lteSignalStrength;
            int encodedSizeWithTag38 = encodedSizeWithTag37 + (num21 != null ? ProtoAdapter.INT32.encodedSizeWithTag(57, num21) : 0);
            Integer num22 = mobileNetworkSignalInfoMessage.lteRsrp;
            int encodedSizeWithTag39 = encodedSizeWithTag38 + (num22 != null ? ProtoAdapter.INT32.encodedSizeWithTag(58, num22) : 0);
            Integer num23 = mobileNetworkSignalInfoMessage.lteRsrq;
            int encodedSizeWithTag40 = encodedSizeWithTag39 + (num23 != null ? ProtoAdapter.INT32.encodedSizeWithTag(59, num23) : 0);
            Integer num24 = mobileNetworkSignalInfoMessage.lteRssnr;
            int encodedSizeWithTag41 = encodedSizeWithTag40 + (num24 != null ? ProtoAdapter.INT32.encodedSizeWithTag(60, num24) : 0);
            Integer num25 = mobileNetworkSignalInfoMessage.lteCqi;
            int encodedSizeWithTag42 = encodedSizeWithTag41 + (num25 != null ? ProtoAdapter.INT32.encodedSizeWithTag(61, num25) : 0);
            Integer num26 = mobileNetworkSignalInfoMessage.lteDbm;
            int encodedSizeWithTag43 = encodedSizeWithTag42 + (num26 != null ? ProtoAdapter.INT32.encodedSizeWithTag(62, num26) : 0);
            Integer num27 = mobileNetworkSignalInfoMessage.lteAsu;
            int encodedSizeWithTag44 = encodedSizeWithTag43 + (num27 != null ? ProtoAdapter.INT32.encodedSizeWithTag(63, num27) : 0);
            Integer num28 = mobileNetworkSignalInfoMessage.cdmaDbm;
            int encodedSizeWithTag45 = encodedSizeWithTag44 + (num28 != null ? ProtoAdapter.INT32.encodedSizeWithTag(64, num28) : 0);
            Integer num29 = mobileNetworkSignalInfoMessage.cdmaAsu;
            int encodedSizeWithTag46 = encodedSizeWithTag45 + (num29 != null ? ProtoAdapter.INT32.encodedSizeWithTag(65, num29) : 0);
            Integer num30 = mobileNetworkSignalInfoMessage.cdmaEcio;
            int encodedSizeWithTag47 = encodedSizeWithTag46 + (num30 != null ? ProtoAdapter.INT32.encodedSizeWithTag(66, num30) : 0);
            Integer num31 = mobileNetworkSignalInfoMessage.evdoDbm;
            int encodedSizeWithTag48 = encodedSizeWithTag47 + (num31 != null ? ProtoAdapter.INT32.encodedSizeWithTag(67, num31) : 0);
            Integer num32 = mobileNetworkSignalInfoMessage.evdoAsu;
            int encodedSizeWithTag49 = encodedSizeWithTag48 + (num32 != null ? ProtoAdapter.INT32.encodedSizeWithTag(68, num32) : 0);
            Integer num33 = mobileNetworkSignalInfoMessage.evdoEcio;
            int encodedSizeWithTag50 = encodedSizeWithTag49 + (num33 != null ? ProtoAdapter.INT32.encodedSizeWithTag(69, num33) : 0);
            Integer num34 = mobileNetworkSignalInfoMessage.evdoSnr;
            int encodedSizeWithTag51 = encodedSizeWithTag50 + (num34 != null ? ProtoAdapter.INT32.encodedSizeWithTag(70, num34) : 0);
            Integer num35 = mobileNetworkSignalInfoMessage.gsmDbm;
            int encodedSizeWithTag52 = encodedSizeWithTag51 + (num35 != null ? ProtoAdapter.INT32.encodedSizeWithTag(71, num35) : 0);
            Integer num36 = mobileNetworkSignalInfoMessage.gsmAsu;
            int encodedSizeWithTag53 = encodedSizeWithTag52 + (num36 != null ? ProtoAdapter.INT32.encodedSizeWithTag(72, num36) : 0);
            Integer num37 = mobileNetworkSignalInfoMessage.gsmBitError;
            int encodedSizeWithTag54 = encodedSizeWithTag53 + (num37 != null ? ProtoAdapter.INT32.encodedSizeWithTag(73, num37) : 0);
            Integer num38 = mobileNetworkSignalInfoMessage.tdscdmaDbm;
            int encodedSizeWithTag55 = encodedSizeWithTag54 + (num38 != null ? ProtoAdapter.INT32.encodedSizeWithTag(74, num38) : 0);
            Integer num39 = mobileNetworkSignalInfoMessage.tdscdmaAsu;
            int encodedSizeWithTag56 = encodedSizeWithTag55 + (num39 != null ? ProtoAdapter.INT32.encodedSizeWithTag(75, num39) : 0);
            Boolean bool = mobileNetworkSignalInfoMessage.gpsAvailable;
            int encodedSizeWithTag57 = encodedSizeWithTag56 + (bool != null ? ProtoAdapter.BOOL.encodedSizeWithTag(76, bool) : 0);
            Integer num40 = mobileNetworkSignalInfoMessage.lteCi;
            int encodedSizeWithTag58 = encodedSizeWithTag57 + (num40 != null ? ProtoAdapter.INT32.encodedSizeWithTag(77, num40) : 0);
            Integer num41 = mobileNetworkSignalInfoMessage.ltePci;
            int encodedSizeWithTag59 = encodedSizeWithTag58 + (num41 != null ? ProtoAdapter.INT32.encodedSizeWithTag(78, num41) : 0);
            Integer num42 = mobileNetworkSignalInfoMessage.lteTac;
            int encodedSizeWithTag60 = encodedSizeWithTag59 + (num42 != null ? ProtoAdapter.INT32.encodedSizeWithTag(79, num42) : 0);
            Integer num43 = mobileNetworkSignalInfoMessage.wcdmaDbm;
            int encodedSizeWithTag61 = encodedSizeWithTag60 + (num43 != null ? ProtoAdapter.INT32.encodedSizeWithTag(80, num43) : 0);
            Integer num44 = mobileNetworkSignalInfoMessage.wcdmaAsu;
            int encodedSizeWithTag62 = encodedSizeWithTag61 + (num44 != null ? ProtoAdapter.INT32.encodedSizeWithTag(81, num44) : 0);
            Integer num45 = mobileNetworkSignalInfoMessage.wcdmaCid;
            int encodedSizeWithTag63 = encodedSizeWithTag62 + (num45 != null ? ProtoAdapter.INT32.encodedSizeWithTag(82, num45) : 0);
            Integer num46 = mobileNetworkSignalInfoMessage.wcdmaLac;
            int encodedSizeWithTag64 = encodedSizeWithTag63 + (num46 != null ? ProtoAdapter.INT32.encodedSizeWithTag(83, num46) : 0);
            Integer num47 = mobileNetworkSignalInfoMessage.wcdmaPsc;
            int encodedSizeWithTag65 = encodedSizeWithTag64 + (num47 != null ? ProtoAdapter.INT32.encodedSizeWithTag(84, num47) : 0);
            Boolean bool2 = mobileNetworkSignalInfoMessage.roaming;
            int encodedSizeWithTag66 = encodedSizeWithTag65 + (bool2 != null ? ProtoAdapter.BOOL.encodedSizeWithTag(85, bool2) : 0);
            Integer num48 = mobileNetworkSignalInfoMessage.rawNetworkType;
            int encodedSizeWithTag67 = encodedSizeWithTag66 + (num48 != null ? ProtoAdapter.INT32.encodedSizeWithTag(86, num48) : 0);
            Integer num49 = mobileNetworkSignalInfoMessage.dataNetworkType;
            int encodedSizeWithTag68 = encodedSizeWithTag67 + (num49 != null ? ProtoAdapter.INT32.encodedSizeWithTag(87, num49) : 0);
            Integer num50 = mobileNetworkSignalInfoMessage.voiceNetworkType;
            int encodedSizeWithTag69 = encodedSizeWithTag68 + (num50 != null ? ProtoAdapter.INT32.encodedSizeWithTag(88, num50) : 0);
            Integer num51 = mobileNetworkSignalInfoMessage.lteEarfcn;
            int encodedSizeWithTag70 = encodedSizeWithTag69 + (num51 != null ? ProtoAdapter.INT32.encodedSizeWithTag(89, num51) : 0);
            Integer num52 = mobileNetworkSignalInfoMessage.gsmArfcn;
            int encodedSizeWithTag71 = encodedSizeWithTag70 + (num52 != null ? ProtoAdapter.INT32.encodedSizeWithTag(90, num52) : 0);
            Integer num53 = mobileNetworkSignalInfoMessage.gsmBsic;
            int encodedSizeWithTag72 = encodedSizeWithTag71 + (num53 != null ? ProtoAdapter.INT32.encodedSizeWithTag(91, num53) : 0);
            Integer num54 = mobileNetworkSignalInfoMessage.lteTimingAdvance;
            int encodedSizeWithTag73 = encodedSizeWithTag72 + (num54 != null ? ProtoAdapter.INT32.encodedSizeWithTag(92, num54) : 0);
            Integer num55 = mobileNetworkSignalInfoMessage.wcdmaUarfcn;
            int encodedSizeWithTag74 = encodedSizeWithTag73 + (num55 != null ? ProtoAdapter.INT32.encodedSizeWithTag(93, num55) : 0);
            Long l4 = mobileNetworkSignalInfoMessage.dataRx;
            int encodedSizeWithTag75 = encodedSizeWithTag74 + (l4 != null ? ProtoAdapter.INT64.encodedSizeWithTag(94, l4) : 0);
            Long l5 = mobileNetworkSignalInfoMessage.dataTx;
            int encodedSizeWithTag76 = encodedSizeWithTag75 + (l5 != null ? ProtoAdapter.INT64.encodedSizeWithTag(95, l5) : 0);
            Float f = mobileNetworkSignalInfoMessage.indoorOutdoorWeight;
            int encodedSizeWithTag77 = encodedSizeWithTag76 + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(96, f) : 0);
            Long l6 = mobileNetworkSignalInfoMessage.nrNci;
            int encodedSizeWithTag78 = encodedSizeWithTag77 + (l6 != null ? ProtoAdapter.INT64.encodedSizeWithTag(97, l6) : 0);
            Integer num56 = mobileNetworkSignalInfoMessage.nrArfcn;
            int encodedSizeWithTag79 = encodedSizeWithTag78 + (num56 != null ? ProtoAdapter.INT32.encodedSizeWithTag(98, num56) : 0);
            Integer num57 = mobileNetworkSignalInfoMessage.nrPci;
            int encodedSizeWithTag80 = encodedSizeWithTag79 + (num57 != null ? ProtoAdapter.INT32.encodedSizeWithTag(99, num57) : 0);
            Integer num58 = mobileNetworkSignalInfoMessage.nrTac;
            int encodedSizeWithTag81 = encodedSizeWithTag80 + (num58 != null ? ProtoAdapter.INT32.encodedSizeWithTag(100, num58) : 0);
            Integer num59 = mobileNetworkSignalInfoMessage.nrAsuLevel;
            int encodedSizeWithTag82 = encodedSizeWithTag81 + (num59 != null ? ProtoAdapter.INT32.encodedSizeWithTag(101, num59) : 0);
            Integer num60 = mobileNetworkSignalInfoMessage.nrCsiRsrp;
            int encodedSizeWithTag83 = encodedSizeWithTag82 + (num60 != null ? ProtoAdapter.INT32.encodedSizeWithTag(102, num60) : 0);
            Integer num61 = mobileNetworkSignalInfoMessage.nrCsiRsrq;
            int encodedSizeWithTag84 = encodedSizeWithTag83 + (num61 != null ? ProtoAdapter.INT32.encodedSizeWithTag(103, num61) : 0);
            Integer num62 = mobileNetworkSignalInfoMessage.nrCsiSinr;
            int encodedSizeWithTag85 = encodedSizeWithTag84 + (num62 != null ? ProtoAdapter.INT32.encodedSizeWithTag(104, num62) : 0);
            Integer num63 = mobileNetworkSignalInfoMessage.nrDbm;
            int encodedSizeWithTag86 = encodedSizeWithTag85 + (num63 != null ? ProtoAdapter.INT32.encodedSizeWithTag(105, num63) : 0);
            Integer num64 = mobileNetworkSignalInfoMessage.nrLevel;
            int encodedSizeWithTag87 = encodedSizeWithTag86 + (num64 != null ? ProtoAdapter.INT32.encodedSizeWithTag(106, num64) : 0);
            Integer num65 = mobileNetworkSignalInfoMessage.nrSsRsrp;
            int encodedSizeWithTag88 = encodedSizeWithTag87 + (num65 != null ? ProtoAdapter.INT32.encodedSizeWithTag(107, num65) : 0);
            Integer num66 = mobileNetworkSignalInfoMessage.nrSsRsrq;
            int encodedSizeWithTag89 = encodedSizeWithTag88 + (num66 != null ? ProtoAdapter.INT32.encodedSizeWithTag(108, num66) : 0);
            Integer num67 = mobileNetworkSignalInfoMessage.nrSsSinr;
            int encodedSizeWithTag90 = encodedSizeWithTag89 + (num67 != null ? ProtoAdapter.INT32.encodedSizeWithTag(109, num67) : 0);
            Boolean bool3 = mobileNetworkSignalInfoMessage.isUsingCarrierAggregation;
            int encodedSizeWithTag91 = encodedSizeWithTag90 + (bool3 != null ? ProtoAdapter.BOOL.encodedSizeWithTag(110, bool3) : 0);
            Long l7 = mobileNetworkSignalInfoMessage.secondaryCellNrNci;
            int encodedSizeWithTag92 = encodedSizeWithTag91 + (l7 != null ? ProtoAdapter.INT64.encodedSizeWithTag(111, l7) : 0);
            Boolean bool4 = mobileNetworkSignalInfoMessage.is5GConnected;
            int encodedSizeWithTag93 = encodedSizeWithTag92 + (bool4 != null ? ProtoAdapter.BOOL.encodedSizeWithTag(112, bool4) : 0);
            Integer num68 = mobileNetworkSignalInfoMessage.overrideNetworkType;
            int encodedSizeWithTag94 = encodedSizeWithTag93 + (num68 != null ? ProtoAdapter.INT32.encodedSizeWithTag(113, num68) : 0);
            Float f2 = mobileNetworkSignalInfoMessage.barometric;
            int encodedSizeWithTag95 = ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(115, mobileNetworkSignalInfoMessage.nrBand) + encodedSizeWithTag94 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(114, f2) : 0);
            Integer num69 = mobileNetworkSignalInfoMessage.lteRssi;
            int encodedSizeWithTag96 = ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(117, mobileNetworkSignalInfoMessage.lteBand) + encodedSizeWithTag95 + (num69 != null ? ProtoAdapter.INT32.encodedSizeWithTag(116, num69) : 0);
            String str10 = mobileNetworkSignalInfoMessage.permissions;
            int encodedSizeWithTag97 = encodedSizeWithTag96 + (str10 != null ? ProtoAdapter.STRING.encodedSizeWithTag(118, str10) : 0);
            Integer num70 = mobileNetworkSignalInfoMessage.completeness;
            int encodedSizeWithTag98 = encodedSizeWithTag97 + (num70 != null ? ProtoAdapter.INT32.encodedSizeWithTag(119, num70) : 0);
            Integer num71 = mobileNetworkSignalInfoMessage.lteBandwidth;
            int encodedSizeWithTag99 = encodedSizeWithTag98 + (num71 != null ? ProtoAdapter.INT32.encodedSizeWithTag(120, num71) : 0);
            Integer num72 = mobileNetworkSignalInfoMessage.timeZoneOffset;
            int encodedSizeWithTag100 = encodedSizeWithTag99 + (num72 != null ? ProtoAdapter.INT32.encodedSizeWithTag(121, num72) : 0);
            Integer num73 = mobileNetworkSignalInfoMessage.isDataDefaultSim;
            if (num73 != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(122, num73);
            }
            return mobileNetworkSignalInfoMessage.unknownFields().size() + encodedSizeWithTag100 + i;
        }

        public MobileNetworkSignalInfoMessage redact(MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage) {
            Builder newBuilder = mobileNetworkSignalInfoMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_BASESTATIONLATITUDE = valueOf;
        DEFAULT_BASESTATIONLONGITUDE = valueOf;
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
        DEFAULT_ACCURACY = valueOf;
        Boolean bool = Boolean.FALSE;
        DEFAULT_GPSAVAILABLE = bool;
        DEFAULT_ROAMING = bool;
        Float valueOf2 = Float.valueOf(0.0f);
        DEFAULT_INDOOROUTDOORWEIGHT = valueOf2;
        DEFAULT_ISUSINGCARRIERAGGREGATION = bool;
        DEFAULT_IS5GCONNECTED = bool;
        DEFAULT_BAROMETRIC = valueOf2;
    }

    public MobileNetworkSignalInfoMessage(Integer num, Long l, String str, String str2, String str3, String str4, Integer num2, Double d, Double d2, Integer num3, Integer num4, Integer num5, Integer num6, Long l2, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Long l3, String str5, Double d3, Double d4, Double d5, String str6, String str7, Integer num14, Integer num15, String str8, String str9, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Integer num39, Boolean bool, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47, Boolean bool2, Integer num48, Integer num49, Integer num50, Integer num51, Integer num52, Integer num53, Integer num54, Integer num55, Long l4, Long l5, Float f, Long l6, Integer num56, Integer num57, Integer num58, Integer num59, Integer num60, Integer num61, Integer num62, Integer num63, Integer num64, Integer num65, Integer num66, Integer num67, Boolean bool3, Long l7, Boolean bool4, Integer num68, Float f2, List<Integer> list, Integer num69, List<Integer> list2, String str10, Integer num70, Integer num71, Integer num72, Integer num73) {
        this(num, l, str, str2, str3, str4, num2, d, d2, num3, num4, num5, num6, l2, num7, num8, num9, num10, num11, num12, num13, l3, str5, d3, d4, d5, str6, str7, num14, num15, str8, str9, num16, num17, num18, num19, num20, num21, num22, num23, num24, num25, num26, num27, num28, num29, num30, num31, num32, num33, num34, num35, num36, num37, num38, num39, bool, num40, num41, num42, num43, num44, num45, num46, num47, bool2, num48, num49, num50, num51, num52, num53, num54, num55, l4, l5, f, l6, num56, num57, num58, num59, num60, num61, num62, num63, num64, num65, num66, num67, bool3, l7, bool4, num68, f2, list, num69, list2, str10, num70, num71, num72, num73, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MobileNetworkSignalInfoMessage)) {
            return false;
        }
        MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage = (MobileNetworkSignalInfoMessage) obj;
        if (!unknownFields().equals(mobileNetworkSignalInfoMessage.unknownFields()) || !Internal.equals(this.id, mobileNetworkSignalInfoMessage.id) || !Internal.equals(this.timeStamp, mobileNetworkSignalInfoMessage.timeStamp) || !Internal.equals(this.timeZone, mobileNetworkSignalInfoMessage.timeZone) || !Internal.equals(this.phoneType, mobileNetworkSignalInfoMessage.phoneType) || !Internal.equals(this.networkType, mobileNetworkSignalInfoMessage.networkType) || !Internal.equals(this.technology, mobileNetworkSignalInfoMessage.technology) || !Internal.equals(this.baseStationId, mobileNetworkSignalInfoMessage.baseStationId) || !Internal.equals(this.baseStationLatitude, mobileNetworkSignalInfoMessage.baseStationLatitude) || !Internal.equals(this.baseStationLongitude, mobileNetworkSignalInfoMessage.baseStationLongitude) || !Internal.equals(this.networkId, mobileNetworkSignalInfoMessage.networkId) || !Internal.equals(this.systemId, mobileNetworkSignalInfoMessage.systemId) || !Internal.equals(this.cid, mobileNetworkSignalInfoMessage.cid) || !Internal.equals(this.lac, mobileNetworkSignalInfoMessage.lac) || !Internal.equals(this.cellTowerInfoTimeStamp, mobileNetworkSignalInfoMessage.cellTowerInfoTimeStamp) || !Internal.equals(this.dbm, mobileNetworkSignalInfoMessage.dbm) || !Internal.equals(this.asu, mobileNetworkSignalInfoMessage.asu) || !Internal.equals(this.ecio, mobileNetworkSignalInfoMessage.ecio) || !Internal.equals(this.rsrp, mobileNetworkSignalInfoMessage.rsrp) || !Internal.equals(this.rsrq, mobileNetworkSignalInfoMessage.rsrq) || !Internal.equals(this.bitErrorRate, mobileNetworkSignalInfoMessage.bitErrorRate) || !Internal.equals(this.wcdmaBitErrorRate, mobileNetworkSignalInfoMessage.wcdmaBitErrorRate) || !Internal.equals(this.locationTimeStamp, mobileNetworkSignalInfoMessage.locationTimeStamp) || !Internal.equals(this.locationProvider, mobileNetworkSignalInfoMessage.locationProvider) || !Internal.equals(this.latitude, mobileNetworkSignalInfoMessage.latitude) || !Internal.equals(this.longitude, mobileNetworkSignalInfoMessage.longitude) || !Internal.equals(this.accuracy, mobileNetworkSignalInfoMessage.accuracy) || !Internal.equals(this.networkOperatorName, mobileNetworkSignalInfoMessage.networkOperatorName) || !Internal.equals(this.networkCountryIso, mobileNetworkSignalInfoMessage.networkCountryIso) || !Internal.equals(this.networkMnc, mobileNetworkSignalInfoMessage.networkMnc) || !Internal.equals(this.networkMcc, mobileNetworkSignalInfoMessage.networkMcc) || !Internal.equals(this.simOperatorName, mobileNetworkSignalInfoMessage.simOperatorName) || !Internal.equals(this.simCountryIso, mobileNetworkSignalInfoMessage.simCountryIso) || !Internal.equals(this.simMnc, mobileNetworkSignalInfoMessage.simMnc) || !Internal.equals(this.simMcc, mobileNetworkSignalInfoMessage.simMcc) || !Internal.equals(this.resourcesMnc, mobileNetworkSignalInfoMessage.resourcesMnc) || !Internal.equals(this.resourcesMcc, mobileNetworkSignalInfoMessage.resourcesMcc) || !Internal.equals(this.registered, mobileNetworkSignalInfoMessage.registered) || !Internal.equals(this.lteSignalStrength, mobileNetworkSignalInfoMessage.lteSignalStrength) || !Internal.equals(this.lteRsrp, mobileNetworkSignalInfoMessage.lteRsrp) || !Internal.equals(this.lteRsrq, mobileNetworkSignalInfoMessage.lteRsrq) || !Internal.equals(this.lteRssnr, mobileNetworkSignalInfoMessage.lteRssnr) || !Internal.equals(this.lteCqi, mobileNetworkSignalInfoMessage.lteCqi) || !Internal.equals(this.lteDbm, mobileNetworkSignalInfoMessage.lteDbm) || !Internal.equals(this.lteAsu, mobileNetworkSignalInfoMessage.lteAsu) || !Internal.equals(this.cdmaDbm, mobileNetworkSignalInfoMessage.cdmaDbm) || !Internal.equals(this.cdmaAsu, mobileNetworkSignalInfoMessage.cdmaAsu) || !Internal.equals(this.cdmaEcio, mobileNetworkSignalInfoMessage.cdmaEcio) || !Internal.equals(this.evdoDbm, mobileNetworkSignalInfoMessage.evdoDbm) || !Internal.equals(this.evdoAsu, mobileNetworkSignalInfoMessage.evdoAsu) || !Internal.equals(this.evdoEcio, mobileNetworkSignalInfoMessage.evdoEcio) || !Internal.equals(this.evdoSnr, mobileNetworkSignalInfoMessage.evdoSnr) || !Internal.equals(this.gsmDbm, mobileNetworkSignalInfoMessage.gsmDbm) || !Internal.equals(this.gsmAsu, mobileNetworkSignalInfoMessage.gsmAsu) || !Internal.equals(this.gsmBitError, mobileNetworkSignalInfoMessage.gsmBitError) || !Internal.equals(this.tdscdmaDbm, mobileNetworkSignalInfoMessage.tdscdmaDbm) || !Internal.equals(this.tdscdmaAsu, mobileNetworkSignalInfoMessage.tdscdmaAsu) || !Internal.equals(this.gpsAvailable, mobileNetworkSignalInfoMessage.gpsAvailable) || !Internal.equals(this.lteCi, mobileNetworkSignalInfoMessage.lteCi) || !Internal.equals(this.ltePci, mobileNetworkSignalInfoMessage.ltePci) || !Internal.equals(this.lteTac, mobileNetworkSignalInfoMessage.lteTac) || !Internal.equals(this.wcdmaDbm, mobileNetworkSignalInfoMessage.wcdmaDbm) || !Internal.equals(this.wcdmaAsu, mobileNetworkSignalInfoMessage.wcdmaAsu) || !Internal.equals(this.wcdmaCid, mobileNetworkSignalInfoMessage.wcdmaCid) || !Internal.equals(this.wcdmaLac, mobileNetworkSignalInfoMessage.wcdmaLac) || !Internal.equals(this.wcdmaPsc, mobileNetworkSignalInfoMessage.wcdmaPsc) || !Internal.equals(this.roaming, mobileNetworkSignalInfoMessage.roaming) || !Internal.equals(this.rawNetworkType, mobileNetworkSignalInfoMessage.rawNetworkType) || !Internal.equals(this.dataNetworkType, mobileNetworkSignalInfoMessage.dataNetworkType) || !Internal.equals(this.voiceNetworkType, mobileNetworkSignalInfoMessage.voiceNetworkType) || !Internal.equals(this.lteEarfcn, mobileNetworkSignalInfoMessage.lteEarfcn) || !Internal.equals(this.gsmArfcn, mobileNetworkSignalInfoMessage.gsmArfcn) || !Internal.equals(this.gsmBsic, mobileNetworkSignalInfoMessage.gsmBsic) || !Internal.equals(this.lteTimingAdvance, mobileNetworkSignalInfoMessage.lteTimingAdvance) || !Internal.equals(this.wcdmaUarfcn, mobileNetworkSignalInfoMessage.wcdmaUarfcn) || !Internal.equals(this.dataRx, mobileNetworkSignalInfoMessage.dataRx) || !Internal.equals(this.dataTx, mobileNetworkSignalInfoMessage.dataTx) || !Internal.equals(this.indoorOutdoorWeight, mobileNetworkSignalInfoMessage.indoorOutdoorWeight) || !Internal.equals(this.nrNci, mobileNetworkSignalInfoMessage.nrNci) || !Internal.equals(this.nrArfcn, mobileNetworkSignalInfoMessage.nrArfcn) || !Internal.equals(this.nrPci, mobileNetworkSignalInfoMessage.nrPci) || !Internal.equals(this.nrTac, mobileNetworkSignalInfoMessage.nrTac) || !Internal.equals(this.nrAsuLevel, mobileNetworkSignalInfoMessage.nrAsuLevel) || !Internal.equals(this.nrCsiRsrp, mobileNetworkSignalInfoMessage.nrCsiRsrp) || !Internal.equals(this.nrCsiRsrq, mobileNetworkSignalInfoMessage.nrCsiRsrq) || !Internal.equals(this.nrCsiSinr, mobileNetworkSignalInfoMessage.nrCsiSinr) || !Internal.equals(this.nrDbm, mobileNetworkSignalInfoMessage.nrDbm) || !Internal.equals(this.nrLevel, mobileNetworkSignalInfoMessage.nrLevel) || !Internal.equals(this.nrSsRsrp, mobileNetworkSignalInfoMessage.nrSsRsrp) || !Internal.equals(this.nrSsRsrq, mobileNetworkSignalInfoMessage.nrSsRsrq) || !Internal.equals(this.nrSsSinr, mobileNetworkSignalInfoMessage.nrSsSinr) || !Internal.equals(this.isUsingCarrierAggregation, mobileNetworkSignalInfoMessage.isUsingCarrierAggregation) || !Internal.equals(this.secondaryCellNrNci, mobileNetworkSignalInfoMessage.secondaryCellNrNci) || !Internal.equals(this.is5GConnected, mobileNetworkSignalInfoMessage.is5GConnected) || !Internal.equals(this.overrideNetworkType, mobileNetworkSignalInfoMessage.overrideNetworkType) || !Internal.equals(this.barometric, mobileNetworkSignalInfoMessage.barometric) || !this.nrBand.equals(mobileNetworkSignalInfoMessage.nrBand) || !Internal.equals(this.lteRssi, mobileNetworkSignalInfoMessage.lteRssi) || !this.lteBand.equals(mobileNetworkSignalInfoMessage.lteBand) || !Internal.equals(this.permissions, mobileNetworkSignalInfoMessage.permissions) || !Internal.equals(this.completeness, mobileNetworkSignalInfoMessage.completeness) || !Internal.equals(this.lteBandwidth, mobileNetworkSignalInfoMessage.lteBandwidth) || !Internal.equals(this.timeZoneOffset, mobileNetworkSignalInfoMessage.timeZoneOffset) || !Internal.equals(this.isDataDefaultSim, mobileNetworkSignalInfoMessage.isDataDefaultSim)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.timeStamp;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.timeZone;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.phoneType;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.networkType;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.technology;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.baseStationId;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Double d = this.baseStationLatitude;
        int hashCode9 = (hashCode8 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.baseStationLongitude;
        int hashCode10 = (hashCode9 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Integer num3 = this.networkId;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.systemId;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.cid;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.lac;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.cellTowerInfoTimeStamp;
        int hashCode15 = (hashCode14 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num7 = this.dbm;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.asu;
        int hashCode17 = (hashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.ecio;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.rsrp;
        int hashCode19 = (hashCode18 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.rsrq;
        int hashCode20 = (hashCode19 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.bitErrorRate;
        int hashCode21 = (hashCode20 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.wcdmaBitErrorRate;
        int hashCode22 = (hashCode21 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Long l3 = this.locationTimeStamp;
        int hashCode23 = (hashCode22 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str5 = this.locationProvider;
        int hashCode24 = (hashCode23 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Double d3 = this.latitude;
        int hashCode25 = (hashCode24 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.longitude;
        int hashCode26 = (hashCode25 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.accuracy;
        int hashCode27 = (hashCode26 + (d5 != null ? d5.hashCode() : 0)) * 37;
        String str6 = this.networkOperatorName;
        int hashCode28 = (hashCode27 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.networkCountryIso;
        int hashCode29 = (hashCode28 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num14 = this.networkMnc;
        int hashCode30 = (hashCode29 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.networkMcc;
        int hashCode31 = (hashCode30 + (num15 != null ? num15.hashCode() : 0)) * 37;
        String str8 = this.simOperatorName;
        int hashCode32 = (hashCode31 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.simCountryIso;
        int hashCode33 = (hashCode32 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num16 = this.simMnc;
        int hashCode34 = (hashCode33 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.simMcc;
        int hashCode35 = (hashCode34 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.resourcesMnc;
        int hashCode36 = (hashCode35 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.resourcesMcc;
        int hashCode37 = (hashCode36 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.registered;
        int hashCode38 = (hashCode37 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.lteSignalStrength;
        int hashCode39 = (hashCode38 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Integer num22 = this.lteRsrp;
        int hashCode40 = (hashCode39 + (num22 != null ? num22.hashCode() : 0)) * 37;
        Integer num23 = this.lteRsrq;
        int hashCode41 = (hashCode40 + (num23 != null ? num23.hashCode() : 0)) * 37;
        Integer num24 = this.lteRssnr;
        int hashCode42 = (hashCode41 + (num24 != null ? num24.hashCode() : 0)) * 37;
        Integer num25 = this.lteCqi;
        int hashCode43 = (hashCode42 + (num25 != null ? num25.hashCode() : 0)) * 37;
        Integer num26 = this.lteDbm;
        int hashCode44 = (hashCode43 + (num26 != null ? num26.hashCode() : 0)) * 37;
        Integer num27 = this.lteAsu;
        int hashCode45 = (hashCode44 + (num27 != null ? num27.hashCode() : 0)) * 37;
        Integer num28 = this.cdmaDbm;
        int hashCode46 = (hashCode45 + (num28 != null ? num28.hashCode() : 0)) * 37;
        Integer num29 = this.cdmaAsu;
        int hashCode47 = (hashCode46 + (num29 != null ? num29.hashCode() : 0)) * 37;
        Integer num30 = this.cdmaEcio;
        int hashCode48 = (hashCode47 + (num30 != null ? num30.hashCode() : 0)) * 37;
        Integer num31 = this.evdoDbm;
        int hashCode49 = (hashCode48 + (num31 != null ? num31.hashCode() : 0)) * 37;
        Integer num32 = this.evdoAsu;
        int hashCode50 = (hashCode49 + (num32 != null ? num32.hashCode() : 0)) * 37;
        Integer num33 = this.evdoEcio;
        int hashCode51 = (hashCode50 + (num33 != null ? num33.hashCode() : 0)) * 37;
        Integer num34 = this.evdoSnr;
        int hashCode52 = (hashCode51 + (num34 != null ? num34.hashCode() : 0)) * 37;
        Integer num35 = this.gsmDbm;
        int hashCode53 = (hashCode52 + (num35 != null ? num35.hashCode() : 0)) * 37;
        Integer num36 = this.gsmAsu;
        int hashCode54 = (hashCode53 + (num36 != null ? num36.hashCode() : 0)) * 37;
        Integer num37 = this.gsmBitError;
        int hashCode55 = (hashCode54 + (num37 != null ? num37.hashCode() : 0)) * 37;
        Integer num38 = this.tdscdmaDbm;
        int hashCode56 = (hashCode55 + (num38 != null ? num38.hashCode() : 0)) * 37;
        Integer num39 = this.tdscdmaAsu;
        int hashCode57 = (hashCode56 + (num39 != null ? num39.hashCode() : 0)) * 37;
        Boolean bool = this.gpsAvailable;
        int hashCode58 = (hashCode57 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num40 = this.lteCi;
        int hashCode59 = (hashCode58 + (num40 != null ? num40.hashCode() : 0)) * 37;
        Integer num41 = this.ltePci;
        int hashCode60 = (hashCode59 + (num41 != null ? num41.hashCode() : 0)) * 37;
        Integer num42 = this.lteTac;
        int hashCode61 = (hashCode60 + (num42 != null ? num42.hashCode() : 0)) * 37;
        Integer num43 = this.wcdmaDbm;
        int hashCode62 = (hashCode61 + (num43 != null ? num43.hashCode() : 0)) * 37;
        Integer num44 = this.wcdmaAsu;
        int hashCode63 = (hashCode62 + (num44 != null ? num44.hashCode() : 0)) * 37;
        Integer num45 = this.wcdmaCid;
        int hashCode64 = (hashCode63 + (num45 != null ? num45.hashCode() : 0)) * 37;
        Integer num46 = this.wcdmaLac;
        int hashCode65 = (hashCode64 + (num46 != null ? num46.hashCode() : 0)) * 37;
        Integer num47 = this.wcdmaPsc;
        int hashCode66 = (hashCode65 + (num47 != null ? num47.hashCode() : 0)) * 37;
        Boolean bool2 = this.roaming;
        int hashCode67 = (hashCode66 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num48 = this.rawNetworkType;
        int hashCode68 = (hashCode67 + (num48 != null ? num48.hashCode() : 0)) * 37;
        Integer num49 = this.dataNetworkType;
        int hashCode69 = (hashCode68 + (num49 != null ? num49.hashCode() : 0)) * 37;
        Integer num50 = this.voiceNetworkType;
        int hashCode70 = (hashCode69 + (num50 != null ? num50.hashCode() : 0)) * 37;
        Integer num51 = this.lteEarfcn;
        int hashCode71 = (hashCode70 + (num51 != null ? num51.hashCode() : 0)) * 37;
        Integer num52 = this.gsmArfcn;
        int hashCode72 = (hashCode71 + (num52 != null ? num52.hashCode() : 0)) * 37;
        Integer num53 = this.gsmBsic;
        int hashCode73 = (hashCode72 + (num53 != null ? num53.hashCode() : 0)) * 37;
        Integer num54 = this.lteTimingAdvance;
        int hashCode74 = (hashCode73 + (num54 != null ? num54.hashCode() : 0)) * 37;
        Integer num55 = this.wcdmaUarfcn;
        int hashCode75 = (hashCode74 + (num55 != null ? num55.hashCode() : 0)) * 37;
        Long l4 = this.dataRx;
        int hashCode76 = (hashCode75 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.dataTx;
        int hashCode77 = (hashCode76 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Float f = this.indoorOutdoorWeight;
        int hashCode78 = (hashCode77 + (f != null ? f.hashCode() : 0)) * 37;
        Long l6 = this.nrNci;
        int hashCode79 = (hashCode78 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num56 = this.nrArfcn;
        int hashCode80 = (hashCode79 + (num56 != null ? num56.hashCode() : 0)) * 37;
        Integer num57 = this.nrPci;
        int hashCode81 = (hashCode80 + (num57 != null ? num57.hashCode() : 0)) * 37;
        Integer num58 = this.nrTac;
        int hashCode82 = (hashCode81 + (num58 != null ? num58.hashCode() : 0)) * 37;
        Integer num59 = this.nrAsuLevel;
        int hashCode83 = (hashCode82 + (num59 != null ? num59.hashCode() : 0)) * 37;
        Integer num60 = this.nrCsiRsrp;
        int hashCode84 = (hashCode83 + (num60 != null ? num60.hashCode() : 0)) * 37;
        Integer num61 = this.nrCsiRsrq;
        int hashCode85 = (hashCode84 + (num61 != null ? num61.hashCode() : 0)) * 37;
        Integer num62 = this.nrCsiSinr;
        int hashCode86 = (hashCode85 + (num62 != null ? num62.hashCode() : 0)) * 37;
        Integer num63 = this.nrDbm;
        int hashCode87 = (hashCode86 + (num63 != null ? num63.hashCode() : 0)) * 37;
        Integer num64 = this.nrLevel;
        int hashCode88 = (hashCode87 + (num64 != null ? num64.hashCode() : 0)) * 37;
        Integer num65 = this.nrSsRsrp;
        int hashCode89 = (hashCode88 + (num65 != null ? num65.hashCode() : 0)) * 37;
        Integer num66 = this.nrSsRsrq;
        int hashCode90 = (hashCode89 + (num66 != null ? num66.hashCode() : 0)) * 37;
        Integer num67 = this.nrSsSinr;
        int hashCode91 = (hashCode90 + (num67 != null ? num67.hashCode() : 0)) * 37;
        Boolean bool3 = this.isUsingCarrierAggregation;
        int hashCode92 = (hashCode91 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Long l7 = this.secondaryCellNrNci;
        int hashCode93 = (hashCode92 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Boolean bool4 = this.is5GConnected;
        int hashCode94 = (hashCode93 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num68 = this.overrideNetworkType;
        int hashCode95 = (hashCode94 + (num68 != null ? num68.hashCode() : 0)) * 37;
        Float f2 = this.barometric;
        int hashCode96 = (this.nrBand.hashCode() + ((hashCode95 + (f2 != null ? f2.hashCode() : 0)) * 37)) * 37;
        Integer num69 = this.lteRssi;
        int hashCode97 = (this.lteBand.hashCode() + ((hashCode96 + (num69 != null ? num69.hashCode() : 0)) * 37)) * 37;
        String str10 = this.permissions;
        int hashCode98 = (hashCode97 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num70 = this.completeness;
        int hashCode99 = (hashCode98 + (num70 != null ? num70.hashCode() : 0)) * 37;
        Integer num71 = this.lteBandwidth;
        int hashCode100 = (hashCode99 + (num71 != null ? num71.hashCode() : 0)) * 37;
        Integer num72 = this.timeZoneOffset;
        int hashCode101 = (hashCode100 + (num72 != null ? num72.hashCode() : 0)) * 37;
        Integer num73 = this.isDataDefaultSim;
        if (num73 != null) {
            i2 = num73.hashCode();
        }
        int i3 = hashCode101 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.timeStamp != null) {
            sb.append(", timeStamp=");
            sb.append(this.timeStamp);
        }
        if (this.timeZone != null) {
            sb.append(", timeZone=");
            sb.append(this.timeZone);
        }
        if (this.phoneType != null) {
            sb.append(", phoneType=");
            sb.append(this.phoneType);
        }
        if (this.networkType != null) {
            sb.append(", networkType=");
            sb.append(this.networkType);
        }
        if (this.technology != null) {
            sb.append(", technology=");
            sb.append(this.technology);
        }
        if (this.baseStationId != null) {
            sb.append(", baseStationId=");
            sb.append(this.baseStationId);
        }
        if (this.baseStationLatitude != null) {
            sb.append(", baseStationLatitude=");
            sb.append(this.baseStationLatitude);
        }
        if (this.baseStationLongitude != null) {
            sb.append(", baseStationLongitude=");
            sb.append(this.baseStationLongitude);
        }
        if (this.networkId != null) {
            sb.append(", networkId=");
            sb.append(this.networkId);
        }
        if (this.systemId != null) {
            sb.append(", systemId=");
            sb.append(this.systemId);
        }
        if (this.cid != null) {
            sb.append(", cid=");
            sb.append(this.cid);
        }
        if (this.lac != null) {
            sb.append(", lac=");
            sb.append(this.lac);
        }
        if (this.cellTowerInfoTimeStamp != null) {
            sb.append(", cellTowerInfoTimeStamp=");
            sb.append(this.cellTowerInfoTimeStamp);
        }
        if (this.dbm != null) {
            sb.append(", dbm=");
            sb.append(this.dbm);
        }
        if (this.asu != null) {
            sb.append(", asu=");
            sb.append(this.asu);
        }
        if (this.ecio != null) {
            sb.append(", ecio=");
            sb.append(this.ecio);
        }
        if (this.rsrp != null) {
            sb.append(", rsrp=");
            sb.append(this.rsrp);
        }
        if (this.rsrq != null) {
            sb.append(", rsrq=");
            sb.append(this.rsrq);
        }
        if (this.bitErrorRate != null) {
            sb.append(", bitErrorRate=");
            sb.append(this.bitErrorRate);
        }
        if (this.wcdmaBitErrorRate != null) {
            sb.append(", wcdmaBitErrorRate=");
            sb.append(this.wcdmaBitErrorRate);
        }
        if (this.locationTimeStamp != null) {
            sb.append(", locationTimeStamp=");
            sb.append(this.locationTimeStamp);
        }
        if (this.locationProvider != null) {
            sb.append(", locationProvider=");
            sb.append(this.locationProvider);
        }
        if (this.latitude != null) {
            sb.append(", latitude=");
            sb.append(this.latitude);
        }
        if (this.longitude != null) {
            sb.append(", longitude=");
            sb.append(this.longitude);
        }
        if (this.accuracy != null) {
            sb.append(", accuracy=");
            sb.append(this.accuracy);
        }
        if (this.networkOperatorName != null) {
            sb.append(", networkOperatorName=");
            sb.append(this.networkOperatorName);
        }
        if (this.networkCountryIso != null) {
            sb.append(", networkCountryIso=");
            sb.append(this.networkCountryIso);
        }
        if (this.networkMnc != null) {
            sb.append(", networkMnc=");
            sb.append(this.networkMnc);
        }
        if (this.networkMcc != null) {
            sb.append(", networkMcc=");
            sb.append(this.networkMcc);
        }
        if (this.simOperatorName != null) {
            sb.append(", simOperatorName=");
            sb.append(this.simOperatorName);
        }
        if (this.simCountryIso != null) {
            sb.append(", simCountryIso=");
            sb.append(this.simCountryIso);
        }
        if (this.simMnc != null) {
            sb.append(", simMnc=");
            sb.append(this.simMnc);
        }
        if (this.simMcc != null) {
            sb.append(", simMcc=");
            sb.append(this.simMcc);
        }
        if (this.resourcesMnc != null) {
            sb.append(", resourcesMnc=");
            sb.append(this.resourcesMnc);
        }
        if (this.resourcesMcc != null) {
            sb.append(", resourcesMcc=");
            sb.append(this.resourcesMcc);
        }
        if (this.registered != null) {
            sb.append(", registered=");
            sb.append(this.registered);
        }
        if (this.lteSignalStrength != null) {
            sb.append(", lteSignalStrength=");
            sb.append(this.lteSignalStrength);
        }
        if (this.lteRsrp != null) {
            sb.append(", lteRsrp=");
            sb.append(this.lteRsrp);
        }
        if (this.lteRsrq != null) {
            sb.append(", lteRsrq=");
            sb.append(this.lteRsrq);
        }
        if (this.lteRssnr != null) {
            sb.append(", lteRssnr=");
            sb.append(this.lteRssnr);
        }
        if (this.lteCqi != null) {
            sb.append(", lteCqi=");
            sb.append(this.lteCqi);
        }
        if (this.lteDbm != null) {
            sb.append(", lteDbm=");
            sb.append(this.lteDbm);
        }
        if (this.lteAsu != null) {
            sb.append(", lteAsu=");
            sb.append(this.lteAsu);
        }
        if (this.cdmaDbm != null) {
            sb.append(", cdmaDbm=");
            sb.append(this.cdmaDbm);
        }
        if (this.cdmaAsu != null) {
            sb.append(", cdmaAsu=");
            sb.append(this.cdmaAsu);
        }
        if (this.cdmaEcio != null) {
            sb.append(", cdmaEcio=");
            sb.append(this.cdmaEcio);
        }
        if (this.evdoDbm != null) {
            sb.append(", evdoDbm=");
            sb.append(this.evdoDbm);
        }
        if (this.evdoAsu != null) {
            sb.append(", evdoAsu=");
            sb.append(this.evdoAsu);
        }
        if (this.evdoEcio != null) {
            sb.append(", evdoEcio=");
            sb.append(this.evdoEcio);
        }
        if (this.evdoSnr != null) {
            sb.append(", evdoSnr=");
            sb.append(this.evdoSnr);
        }
        if (this.gsmDbm != null) {
            sb.append(", gsmDbm=");
            sb.append(this.gsmDbm);
        }
        if (this.gsmAsu != null) {
            sb.append(", gsmAsu=");
            sb.append(this.gsmAsu);
        }
        if (this.gsmBitError != null) {
            sb.append(", gsmBitError=");
            sb.append(this.gsmBitError);
        }
        if (this.tdscdmaDbm != null) {
            sb.append(", tdscdmaDbm=");
            sb.append(this.tdscdmaDbm);
        }
        if (this.tdscdmaAsu != null) {
            sb.append(", tdscdmaAsu=");
            sb.append(this.tdscdmaAsu);
        }
        if (this.gpsAvailable != null) {
            sb.append(", gpsAvailable=");
            sb.append(this.gpsAvailable);
        }
        if (this.lteCi != null) {
            sb.append(", lteCi=");
            sb.append(this.lteCi);
        }
        if (this.ltePci != null) {
            sb.append(", ltePci=");
            sb.append(this.ltePci);
        }
        if (this.lteTac != null) {
            sb.append(", lteTac=");
            sb.append(this.lteTac);
        }
        if (this.wcdmaDbm != null) {
            sb.append(", wcdmaDbm=");
            sb.append(this.wcdmaDbm);
        }
        if (this.wcdmaAsu != null) {
            sb.append(", wcdmaAsu=");
            sb.append(this.wcdmaAsu);
        }
        if (this.wcdmaCid != null) {
            sb.append(", wcdmaCid=");
            sb.append(this.wcdmaCid);
        }
        if (this.wcdmaLac != null) {
            sb.append(", wcdmaLac=");
            sb.append(this.wcdmaLac);
        }
        if (this.wcdmaPsc != null) {
            sb.append(", wcdmaPsc=");
            sb.append(this.wcdmaPsc);
        }
        if (this.roaming != null) {
            sb.append(", roaming=");
            sb.append(this.roaming);
        }
        if (this.rawNetworkType != null) {
            sb.append(", rawNetworkType=");
            sb.append(this.rawNetworkType);
        }
        if (this.dataNetworkType != null) {
            sb.append(", dataNetworkType=");
            sb.append(this.dataNetworkType);
        }
        if (this.voiceNetworkType != null) {
            sb.append(", voiceNetworkType=");
            sb.append(this.voiceNetworkType);
        }
        if (this.lteEarfcn != null) {
            sb.append(", lteEarfcn=");
            sb.append(this.lteEarfcn);
        }
        if (this.gsmArfcn != null) {
            sb.append(", gsmArfcn=");
            sb.append(this.gsmArfcn);
        }
        if (this.gsmBsic != null) {
            sb.append(", gsmBsic=");
            sb.append(this.gsmBsic);
        }
        if (this.lteTimingAdvance != null) {
            sb.append(", lteTimingAdvance=");
            sb.append(this.lteTimingAdvance);
        }
        if (this.wcdmaUarfcn != null) {
            sb.append(", wcdmaUarfcn=");
            sb.append(this.wcdmaUarfcn);
        }
        if (this.dataRx != null) {
            sb.append(", dataRx=");
            sb.append(this.dataRx);
        }
        if (this.dataTx != null) {
            sb.append(", dataTx=");
            sb.append(this.dataTx);
        }
        if (this.indoorOutdoorWeight != null) {
            sb.append(", indoorOutdoorWeight=");
            sb.append(this.indoorOutdoorWeight);
        }
        if (this.nrNci != null) {
            sb.append(", nrNci=");
            sb.append(this.nrNci);
        }
        if (this.nrArfcn != null) {
            sb.append(", nrArfcn=");
            sb.append(this.nrArfcn);
        }
        if (this.nrPci != null) {
            sb.append(", nrPci=");
            sb.append(this.nrPci);
        }
        if (this.nrTac != null) {
            sb.append(", nrTac=");
            sb.append(this.nrTac);
        }
        if (this.nrAsuLevel != null) {
            sb.append(", nrAsuLevel=");
            sb.append(this.nrAsuLevel);
        }
        if (this.nrCsiRsrp != null) {
            sb.append(", nrCsiRsrp=");
            sb.append(this.nrCsiRsrp);
        }
        if (this.nrCsiRsrq != null) {
            sb.append(", nrCsiRsrq=");
            sb.append(this.nrCsiRsrq);
        }
        if (this.nrCsiSinr != null) {
            sb.append(", nrCsiSinr=");
            sb.append(this.nrCsiSinr);
        }
        if (this.nrDbm != null) {
            sb.append(", nrDbm=");
            sb.append(this.nrDbm);
        }
        if (this.nrLevel != null) {
            sb.append(", nrLevel=");
            sb.append(this.nrLevel);
        }
        if (this.nrSsRsrp != null) {
            sb.append(", nrSsRsrp=");
            sb.append(this.nrSsRsrp);
        }
        if (this.nrSsRsrq != null) {
            sb.append(", nrSsRsrq=");
            sb.append(this.nrSsRsrq);
        }
        if (this.nrSsSinr != null) {
            sb.append(", nrSsSinr=");
            sb.append(this.nrSsSinr);
        }
        if (this.isUsingCarrierAggregation != null) {
            sb.append(", isUsingCarrierAggregation=");
            sb.append(this.isUsingCarrierAggregation);
        }
        if (this.secondaryCellNrNci != null) {
            sb.append(", secondaryCellNrNci=");
            sb.append(this.secondaryCellNrNci);
        }
        if (this.is5GConnected != null) {
            sb.append(", is5GConnected=");
            sb.append(this.is5GConnected);
        }
        if (this.overrideNetworkType != null) {
            sb.append(", overrideNetworkType=");
            sb.append(this.overrideNetworkType);
        }
        if (this.barometric != null) {
            sb.append(", barometric=");
            sb.append(this.barometric);
        }
        if (!this.nrBand.isEmpty()) {
            sb.append(", nrBand=");
            sb.append(this.nrBand);
        }
        if (this.lteRssi != null) {
            sb.append(", lteRssi=");
            sb.append(this.lteRssi);
        }
        if (!this.lteBand.isEmpty()) {
            sb.append(", lteBand=");
            sb.append(this.lteBand);
        }
        if (this.permissions != null) {
            sb.append(", permissions=");
            sb.append(this.permissions);
        }
        if (this.completeness != null) {
            sb.append(", completeness=");
            sb.append(this.completeness);
        }
        if (this.lteBandwidth != null) {
            sb.append(", lteBandwidth=");
            sb.append(this.lteBandwidth);
        }
        if (this.timeZoneOffset != null) {
            sb.append(", timeZoneOffset=");
            sb.append(this.timeZoneOffset);
        }
        if (this.isDataDefaultSim != null) {
            sb.append(", isDataDefaultSim=");
            sb.append(this.isDataDefaultSim);
        }
        return c.a(sb, 0, 2, "MobileNetworkSignalInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileNetworkSignalInfoMessage(Integer num, Long l, String str, String str2, String str3, String str4, Integer num2, Double d, Double d2, Integer num3, Integer num4, Integer num5, Integer num6, Long l2, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Long l3, String str5, Double d3, Double d4, Double d5, String str6, String str7, Integer num14, Integer num15, String str8, String str9, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Integer num39, Boolean bool, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47, Boolean bool2, Integer num48, Integer num49, Integer num50, Integer num51, Integer num52, Integer num53, Integer num54, Integer num55, Long l4, Long l5, Float f, Long l6, Integer num56, Integer num57, Integer num58, Integer num59, Integer num60, Integer num61, Integer num62, Integer num63, Integer num64, Integer num65, Integer num66, Integer num67, Boolean bool3, Long l7, Boolean bool4, Integer num68, Float f2, List<Integer> list, Integer num69, List<Integer> list2, String str10, Integer num70, Integer num71, Integer num72, Integer num73, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = num;
        this.timeStamp = l;
        this.timeZone = str;
        this.phoneType = str2;
        this.networkType = str3;
        this.technology = str4;
        this.baseStationId = num2;
        this.baseStationLatitude = d;
        this.baseStationLongitude = d2;
        this.networkId = num3;
        this.systemId = num4;
        this.cid = num5;
        this.lac = num6;
        this.cellTowerInfoTimeStamp = l2;
        this.dbm = num7;
        this.asu = num8;
        this.ecio = num9;
        this.rsrp = num10;
        this.rsrq = num11;
        this.bitErrorRate = num12;
        this.wcdmaBitErrorRate = num13;
        this.locationTimeStamp = l3;
        this.locationProvider = str5;
        this.latitude = d3;
        this.longitude = d4;
        this.accuracy = d5;
        this.networkOperatorName = str6;
        this.networkCountryIso = str7;
        this.networkMnc = num14;
        this.networkMcc = num15;
        this.simOperatorName = str8;
        this.simCountryIso = str9;
        this.simMnc = num16;
        this.simMcc = num17;
        this.resourcesMnc = num18;
        this.resourcesMcc = num19;
        this.registered = num20;
        this.lteSignalStrength = num21;
        this.lteRsrp = num22;
        this.lteRsrq = num23;
        this.lteRssnr = num24;
        this.lteCqi = num25;
        this.lteDbm = num26;
        this.lteAsu = num27;
        this.cdmaDbm = num28;
        this.cdmaAsu = num29;
        this.cdmaEcio = num30;
        this.evdoDbm = num31;
        this.evdoAsu = num32;
        this.evdoEcio = num33;
        this.evdoSnr = num34;
        this.gsmDbm = num35;
        this.gsmAsu = num36;
        this.gsmBitError = num37;
        this.tdscdmaDbm = num38;
        this.tdscdmaAsu = num39;
        this.gpsAvailable = bool;
        this.lteCi = num40;
        this.ltePci = num41;
        this.lteTac = num42;
        this.wcdmaDbm = num43;
        this.wcdmaAsu = num44;
        this.wcdmaCid = num45;
        this.wcdmaLac = num46;
        this.wcdmaPsc = num47;
        this.roaming = bool2;
        this.rawNetworkType = num48;
        this.dataNetworkType = num49;
        this.voiceNetworkType = num50;
        this.lteEarfcn = num51;
        this.gsmArfcn = num52;
        this.gsmBsic = num53;
        this.lteTimingAdvance = num54;
        this.wcdmaUarfcn = num55;
        this.dataRx = l4;
        this.dataTx = l5;
        this.indoorOutdoorWeight = f;
        this.nrNci = l6;
        this.nrArfcn = num56;
        this.nrPci = num57;
        this.nrTac = num58;
        this.nrAsuLevel = num59;
        this.nrCsiRsrp = num60;
        this.nrCsiRsrq = num61;
        this.nrCsiSinr = num62;
        this.nrDbm = num63;
        this.nrLevel = num64;
        this.nrSsRsrp = num65;
        this.nrSsRsrq = num66;
        this.nrSsSinr = num67;
        this.isUsingCarrierAggregation = bool3;
        this.secondaryCellNrNci = l7;
        this.is5GConnected = bool4;
        this.overrideNetworkType = num68;
        this.barometric = f2;
        this.nrBand = Internal.immutableCopyOf("nrBand", list);
        this.lteRssi = num69;
        this.lteBand = Internal.immutableCopyOf("lteBand", list2);
        this.permissions = str10;
        this.completeness = num70;
        this.lteBandwidth = num71;
        this.timeZoneOffset = num72;
        this.isDataDefaultSim = num73;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.timeStamp = this.timeStamp;
        builder.timeZone = this.timeZone;
        builder.phoneType = this.phoneType;
        builder.networkType = this.networkType;
        builder.technology = this.technology;
        builder.baseStationId = this.baseStationId;
        builder.baseStationLatitude = this.baseStationLatitude;
        builder.baseStationLongitude = this.baseStationLongitude;
        builder.networkId = this.networkId;
        builder.systemId = this.systemId;
        builder.cid = this.cid;
        builder.lac = this.lac;
        builder.cellTowerInfoTimeStamp = this.cellTowerInfoTimeStamp;
        builder.dbm = this.dbm;
        builder.asu = this.asu;
        builder.ecio = this.ecio;
        builder.rsrp = this.rsrp;
        builder.rsrq = this.rsrq;
        builder.bitErrorRate = this.bitErrorRate;
        builder.wcdmaBitErrorRate = this.wcdmaBitErrorRate;
        builder.locationTimeStamp = this.locationTimeStamp;
        builder.locationProvider = this.locationProvider;
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.accuracy = this.accuracy;
        builder.networkOperatorName = this.networkOperatorName;
        builder.networkCountryIso = this.networkCountryIso;
        builder.networkMnc = this.networkMnc;
        builder.networkMcc = this.networkMcc;
        builder.simOperatorName = this.simOperatorName;
        builder.simCountryIso = this.simCountryIso;
        builder.simMnc = this.simMnc;
        builder.simMcc = this.simMcc;
        builder.resourcesMnc = this.resourcesMnc;
        builder.resourcesMcc = this.resourcesMcc;
        builder.registered = this.registered;
        builder.lteSignalStrength = this.lteSignalStrength;
        builder.lteRsrp = this.lteRsrp;
        builder.lteRsrq = this.lteRsrq;
        builder.lteRssnr = this.lteRssnr;
        builder.lteCqi = this.lteCqi;
        builder.lteDbm = this.lteDbm;
        builder.lteAsu = this.lteAsu;
        builder.cdmaDbm = this.cdmaDbm;
        builder.cdmaAsu = this.cdmaAsu;
        builder.cdmaEcio = this.cdmaEcio;
        builder.evdoDbm = this.evdoDbm;
        builder.evdoAsu = this.evdoAsu;
        builder.evdoEcio = this.evdoEcio;
        builder.evdoSnr = this.evdoSnr;
        builder.gsmDbm = this.gsmDbm;
        builder.gsmAsu = this.gsmAsu;
        builder.gsmBitError = this.gsmBitError;
        builder.tdscdmaDbm = this.tdscdmaDbm;
        builder.tdscdmaAsu = this.tdscdmaAsu;
        builder.gpsAvailable = this.gpsAvailable;
        builder.lteCi = this.lteCi;
        builder.ltePci = this.ltePci;
        builder.lteTac = this.lteTac;
        builder.wcdmaDbm = this.wcdmaDbm;
        builder.wcdmaAsu = this.wcdmaAsu;
        builder.wcdmaCid = this.wcdmaCid;
        builder.wcdmaLac = this.wcdmaLac;
        builder.wcdmaPsc = this.wcdmaPsc;
        builder.roaming = this.roaming;
        builder.rawNetworkType = this.rawNetworkType;
        builder.dataNetworkType = this.dataNetworkType;
        builder.voiceNetworkType = this.voiceNetworkType;
        builder.lteEarfcn = this.lteEarfcn;
        builder.gsmArfcn = this.gsmArfcn;
        builder.gsmBsic = this.gsmBsic;
        builder.lteTimingAdvance = this.lteTimingAdvance;
        builder.wcdmaUarfcn = this.wcdmaUarfcn;
        builder.dataRx = this.dataRx;
        builder.dataTx = this.dataTx;
        builder.indoorOutdoorWeight = this.indoorOutdoorWeight;
        builder.nrNci = this.nrNci;
        builder.nrArfcn = this.nrArfcn;
        builder.nrPci = this.nrPci;
        builder.nrTac = this.nrTac;
        builder.nrAsuLevel = this.nrAsuLevel;
        builder.nrCsiRsrp = this.nrCsiRsrp;
        builder.nrCsiRsrq = this.nrCsiRsrq;
        builder.nrCsiSinr = this.nrCsiSinr;
        builder.nrDbm = this.nrDbm;
        builder.nrLevel = this.nrLevel;
        builder.nrSsRsrp = this.nrSsRsrp;
        builder.nrSsRsrq = this.nrSsRsrq;
        builder.nrSsSinr = this.nrSsSinr;
        builder.isUsingCarrierAggregation = this.isUsingCarrierAggregation;
        builder.secondaryCellNrNci = this.secondaryCellNrNci;
        builder.is5GConnected = this.is5GConnected;
        builder.overrideNetworkType = this.overrideNetworkType;
        builder.barometric = this.barometric;
        builder.nrBand = Internal.copyOf("nrBand", this.nrBand);
        builder.lteRssi = this.lteRssi;
        builder.lteBand = Internal.copyOf("lteBand", this.lteBand);
        builder.permissions = this.permissions;
        builder.completeness = this.completeness;
        builder.lteBandwidth = this.lteBandwidth;
        builder.timeZoneOffset = this.timeZoneOffset;
        builder.isDataDefaultSim = this.isDataDefaultSim;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
