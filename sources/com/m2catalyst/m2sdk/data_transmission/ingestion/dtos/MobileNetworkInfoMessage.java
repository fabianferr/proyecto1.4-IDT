package com.m2catalyst.m2sdk.data_transmission.ingestion.dtos;

import com.m2catalyst.m2sdk.c;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

public final class MobileNetworkInfoMessage extends Message<MobileNetworkInfoMessage, Builder> {
    public static final ProtoAdapter<MobileNetworkInfoMessage> ADAPTER = new ProtoAdapter_MobileNetworkInfoMessage();
    public static final Integer DEFAULT_BASE_STATION_ID = 0;
    public static final Integer DEFAULT_BASE_STATION_LATITUDE = 0;
    public static final Integer DEFAULT_BASE_STATION_LONGITUDE = 0;
    public static final Float DEFAULT_CDMA_ASU_LEVEL;
    public static final Float DEFAULT_CDMA_DBM;
    public static final Float DEFAULT_CDMA_ECIO;
    public static final Integer DEFAULT_CID = 0;
    public static final Float DEFAULT_EVDO_ASU_LEVEL;
    public static final Float DEFAULT_EVDO_DBM;
    public static final Float DEFAULT_EVDO_ECIO;
    public static final Float DEFAULT_GSM_ASU_LEVEL;
    public static final Float DEFAULT_GSM_DBM;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_LAC = 0;
    public static final Double DEFAULT_LATITUDE;
    public static final Double DEFAULT_LONGITUDE;
    public static final Float DEFAULT_LTE_ASU_LEVEL;
    public static final Float DEFAULT_LTE_DBM;
    public static final Float DEFAULT_LTE_RSRP;
    public static final Float DEFAULT_LTE_RSRQ;
    public static final Integer DEFAULT_NETWORK_ID = 0;
    public static final String DEFAULT_NETWORK_TYPE = "";
    public static final String DEFAULT_PHONE_TYPE = "";
    public static final Integer DEFAULT_SYSTEM_ID = 0;
    public static final Float DEFAULT_TD_SCDMA_ASU_LEVEL;
    public static final Float DEFAULT_TD_SCDMA_DBM;
    public static final Long DEFAULT_TIME_STAMP = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer base_station_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 27)
    public final Integer base_station_latitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 28)
    public final Integer base_station_longitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 34)
    public final Float cdma_asu_level;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 33)
    public final Float cdma_dbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 35)
    public final Float cdma_ecio;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 31)
    public final Integer cid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 40)
    public final Float evdo_asu_level;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 39)
    public final Float evdo_dbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 41)
    public final Float evdo_ecio;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 46)
    public final Float gsm_asu_level;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 45)
    public final Float gsm_dbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer lac;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 21)
    public final Double latitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 22)
    public final Double longitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 56)
    public final Float lte_asu_level;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 53)
    public final Float lte_dbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 54)
    public final Float lte_rsrp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 55)
    public final Float lte_rsrq;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 29)
    public final Integer network_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String network_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final String phone_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 30)
    public final Integer system_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 50)
    public final Float td_scdma_asu_level;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 49)
    public final Float td_scdma_dbm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 23)
    public final Long time_stamp;

    public static final class Builder extends Message.Builder<MobileNetworkInfoMessage, Builder> {
        public Integer base_station_id;
        public Integer base_station_latitude;
        public Integer base_station_longitude;
        public Float cdma_asu_level;
        public Float cdma_dbm;
        public Float cdma_ecio;
        public Integer cid;
        public Float evdo_asu_level;
        public Float evdo_dbm;
        public Float evdo_ecio;
        public Float gsm_asu_level;
        public Float gsm_dbm;
        public Integer id;
        public Integer lac;
        public Double latitude;
        public Double longitude;
        public Float lte_asu_level;
        public Float lte_dbm;
        public Float lte_rsrp;
        public Float lte_rsrq;
        public Integer network_id;
        public String network_type;
        public String phone_type;
        public Integer system_id;
        public Float td_scdma_asu_level;
        public Float td_scdma_dbm;
        public Long time_stamp;

        public Builder base_station_id(Integer num) {
            this.base_station_id = num;
            return this;
        }

        public Builder base_station_latitude(Integer num) {
            this.base_station_latitude = num;
            return this;
        }

        public Builder base_station_longitude(Integer num) {
            this.base_station_longitude = num;
            return this;
        }

        public Builder cdma_asu_level(Float f) {
            this.cdma_asu_level = f;
            return this;
        }

        public Builder cdma_dbm(Float f) {
            this.cdma_dbm = f;
            return this;
        }

        public Builder cdma_ecio(Float f) {
            this.cdma_ecio = f;
            return this;
        }

        public Builder cid(Integer num) {
            this.cid = num;
            return this;
        }

        public Builder evdo_asu_level(Float f) {
            this.evdo_asu_level = f;
            return this;
        }

        public Builder evdo_dbm(Float f) {
            this.evdo_dbm = f;
            return this;
        }

        public Builder evdo_ecio(Float f) {
            this.evdo_ecio = f;
            return this;
        }

        public Builder gsm_asu_level(Float f) {
            this.gsm_asu_level = f;
            return this;
        }

        public Builder gsm_dbm(Float f) {
            this.gsm_dbm = f;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
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

        public Builder longitude(Double d) {
            this.longitude = d;
            return this;
        }

        public Builder lte_asu_level(Float f) {
            this.lte_asu_level = f;
            return this;
        }

        public Builder lte_dbm(Float f) {
            this.lte_dbm = f;
            return this;
        }

        public Builder lte_rsrp(Float f) {
            this.lte_rsrp = f;
            return this;
        }

        public Builder lte_rsrq(Float f) {
            this.lte_rsrq = f;
            return this;
        }

        public Builder network_id(Integer num) {
            this.network_id = num;
            return this;
        }

        public Builder network_type(String str) {
            this.network_type = str;
            return this;
        }

        public Builder phone_type(String str) {
            this.phone_type = str;
            return this;
        }

        public Builder system_id(Integer num) {
            this.system_id = num;
            return this;
        }

        public Builder td_scdma_asu_level(Float f) {
            this.td_scdma_asu_level = f;
            return this;
        }

        public Builder td_scdma_dbm(Float f) {
            this.td_scdma_dbm = f;
            return this;
        }

        public Builder time_stamp(Long l) {
            this.time_stamp = l;
            return this;
        }

        public MobileNetworkInfoMessage build() {
            return new MobileNetworkInfoMessage(this.id, this.latitude, this.longitude, this.time_stamp, this.phone_type, this.network_type, this.base_station_id, this.base_station_latitude, this.base_station_longitude, this.network_id, this.system_id, this.cid, this.lac, this.cdma_dbm, this.cdma_asu_level, this.cdma_ecio, this.evdo_dbm, this.evdo_asu_level, this.evdo_ecio, this.gsm_dbm, this.gsm_asu_level, this.td_scdma_dbm, this.td_scdma_asu_level, this.lte_dbm, this.lte_rsrp, this.lte_rsrq, this.lte_asu_level, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MobileNetworkInfoMessage extends ProtoAdapter<MobileNetworkInfoMessage> {
        public ProtoAdapter_MobileNetworkInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MobileNetworkInfoMessage.class);
        }

        public MobileNetworkInfoMessage decode(ProtoReader protoReader) {
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
                            builder.latitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 22:
                            builder.longitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 23:
                            builder.time_stamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 24:
                            builder.phone_type(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 25:
                            builder.network_type(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 26:
                            builder.base_station_id(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 27:
                            builder.base_station_latitude(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 28:
                            builder.base_station_longitude(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 29:
                            builder.network_id(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 30:
                            builder.system_id(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 31:
                            builder.cid(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 32:
                            builder.lac(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 33:
                            builder.cdma_dbm(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 34:
                            builder.cdma_asu_level(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 35:
                            builder.cdma_ecio(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 39:
                            builder.evdo_dbm(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 40:
                            builder.evdo_asu_level(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 41:
                            builder.evdo_ecio(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 45:
                            builder.gsm_dbm(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 46:
                            builder.gsm_asu_level(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 49:
                            builder.td_scdma_dbm(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 50:
                            builder.td_scdma_asu_level(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 53:
                            builder.lte_dbm(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 54:
                            builder.lte_rsrp(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 55:
                            builder.lte_rsrq(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 56:
                            builder.lte_asu_level(ProtoAdapter.FLOAT.decode(protoReader));
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

        public void encode(ProtoWriter protoWriter, MobileNetworkInfoMessage mobileNetworkInfoMessage) {
            Integer num = mobileNetworkInfoMessage.id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 20, num);
            }
            Double d = mobileNetworkInfoMessage.latitude;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 21, d);
            }
            Double d2 = mobileNetworkInfoMessage.longitude;
            if (d2 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 22, d2);
            }
            Long l = mobileNetworkInfoMessage.time_stamp;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 23, l);
            }
            String str = mobileNetworkInfoMessage.phone_type;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 24, str);
            }
            String str2 = mobileNetworkInfoMessage.network_type;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 25, str2);
            }
            Integer num2 = mobileNetworkInfoMessage.base_station_id;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num2);
            }
            Integer num3 = mobileNetworkInfoMessage.base_station_latitude;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 27, num3);
            }
            Integer num4 = mobileNetworkInfoMessage.base_station_longitude;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 28, num4);
            }
            Integer num5 = mobileNetworkInfoMessage.network_id;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 29, num5);
            }
            Integer num6 = mobileNetworkInfoMessage.system_id;
            if (num6 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 30, num6);
            }
            Integer num7 = mobileNetworkInfoMessage.cid;
            if (num7 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 31, num7);
            }
            Integer num8 = mobileNetworkInfoMessage.lac;
            if (num8 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num8);
            }
            Float f = mobileNetworkInfoMessage.cdma_dbm;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 33, f);
            }
            Float f2 = mobileNetworkInfoMessage.cdma_asu_level;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 34, f2);
            }
            Float f3 = mobileNetworkInfoMessage.cdma_ecio;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 35, f3);
            }
            Float f4 = mobileNetworkInfoMessage.evdo_dbm;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 39, f4);
            }
            Float f5 = mobileNetworkInfoMessage.evdo_asu_level;
            if (f5 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 40, f5);
            }
            Float f6 = mobileNetworkInfoMessage.evdo_ecio;
            if (f6 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 41, f6);
            }
            Float f7 = mobileNetworkInfoMessage.gsm_dbm;
            if (f7 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 45, f7);
            }
            Float f8 = mobileNetworkInfoMessage.gsm_asu_level;
            if (f8 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 46, f8);
            }
            Float f9 = mobileNetworkInfoMessage.td_scdma_dbm;
            if (f9 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 49, f9);
            }
            Float f10 = mobileNetworkInfoMessage.td_scdma_asu_level;
            if (f10 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 50, f10);
            }
            Float f11 = mobileNetworkInfoMessage.lte_dbm;
            if (f11 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 53, f11);
            }
            Float f12 = mobileNetworkInfoMessage.lte_rsrp;
            if (f12 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 54, f12);
            }
            Float f13 = mobileNetworkInfoMessage.lte_rsrq;
            if (f13 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 55, f13);
            }
            Float f14 = mobileNetworkInfoMessage.lte_asu_level;
            if (f14 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 56, f14);
            }
            protoWriter.writeBytes(mobileNetworkInfoMessage.unknownFields());
        }

        public int encodedSize(MobileNetworkInfoMessage mobileNetworkInfoMessage) {
            Integer num = mobileNetworkInfoMessage.id;
            int i = 0;
            int encodedSizeWithTag = num != null ? ProtoAdapter.INT32.encodedSizeWithTag(20, num) : 0;
            Double d = mobileNetworkInfoMessage.latitude;
            int encodedSizeWithTag2 = encodedSizeWithTag + (d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(21, d) : 0);
            Double d2 = mobileNetworkInfoMessage.longitude;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (d2 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(22, d2) : 0);
            Long l = mobileNetworkInfoMessage.time_stamp;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(23, l) : 0);
            String str = mobileNetworkInfoMessage.phone_type;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(24, str) : 0);
            String str2 = mobileNetworkInfoMessage.network_type;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(25, str2) : 0);
            Integer num2 = mobileNetworkInfoMessage.base_station_id;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(26, num2) : 0);
            Integer num3 = mobileNetworkInfoMessage.base_station_latitude;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(27, num3) : 0);
            Integer num4 = mobileNetworkInfoMessage.base_station_longitude;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(28, num4) : 0);
            Integer num5 = mobileNetworkInfoMessage.network_id;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(29, num5) : 0);
            Integer num6 = mobileNetworkInfoMessage.system_id;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (num6 != null ? ProtoAdapter.INT32.encodedSizeWithTag(30, num6) : 0);
            Integer num7 = mobileNetworkInfoMessage.cid;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (num7 != null ? ProtoAdapter.INT32.encodedSizeWithTag(31, num7) : 0);
            Integer num8 = mobileNetworkInfoMessage.lac;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (num8 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num8) : 0);
            Float f = mobileNetworkInfoMessage.cdma_dbm;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(33, f) : 0);
            Float f2 = mobileNetworkInfoMessage.cdma_asu_level;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(34, f2) : 0);
            Float f3 = mobileNetworkInfoMessage.cdma_ecio;
            int encodedSizeWithTag16 = encodedSizeWithTag15 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(35, f3) : 0);
            Float f4 = mobileNetworkInfoMessage.evdo_dbm;
            int encodedSizeWithTag17 = encodedSizeWithTag16 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(39, f4) : 0);
            Float f5 = mobileNetworkInfoMessage.evdo_asu_level;
            int encodedSizeWithTag18 = encodedSizeWithTag17 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(40, f5) : 0);
            Float f6 = mobileNetworkInfoMessage.evdo_ecio;
            int encodedSizeWithTag19 = encodedSizeWithTag18 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(41, f6) : 0);
            Float f7 = mobileNetworkInfoMessage.gsm_dbm;
            int encodedSizeWithTag20 = encodedSizeWithTag19 + (f7 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(45, f7) : 0);
            Float f8 = mobileNetworkInfoMessage.gsm_asu_level;
            int encodedSizeWithTag21 = encodedSizeWithTag20 + (f8 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(46, f8) : 0);
            Float f9 = mobileNetworkInfoMessage.td_scdma_dbm;
            int encodedSizeWithTag22 = encodedSizeWithTag21 + (f9 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(49, f9) : 0);
            Float f10 = mobileNetworkInfoMessage.td_scdma_asu_level;
            int encodedSizeWithTag23 = encodedSizeWithTag22 + (f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(50, f10) : 0);
            Float f11 = mobileNetworkInfoMessage.lte_dbm;
            int encodedSizeWithTag24 = encodedSizeWithTag23 + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(53, f11) : 0);
            Float f12 = mobileNetworkInfoMessage.lte_rsrp;
            int encodedSizeWithTag25 = encodedSizeWithTag24 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(54, f12) : 0);
            Float f13 = mobileNetworkInfoMessage.lte_rsrq;
            int encodedSizeWithTag26 = encodedSizeWithTag25 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(55, f13) : 0);
            Float f14 = mobileNetworkInfoMessage.lte_asu_level;
            if (f14 != null) {
                i = ProtoAdapter.FLOAT.encodedSizeWithTag(56, f14);
            }
            return mobileNetworkInfoMessage.unknownFields().size() + encodedSizeWithTag26 + i;
        }

        public MobileNetworkInfoMessage redact(MobileNetworkInfoMessage mobileNetworkInfoMessage) {
            Builder newBuilder = mobileNetworkInfoMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
        Float valueOf2 = Float.valueOf(0.0f);
        DEFAULT_CDMA_DBM = valueOf2;
        DEFAULT_CDMA_ASU_LEVEL = valueOf2;
        DEFAULT_CDMA_ECIO = valueOf2;
        DEFAULT_EVDO_DBM = valueOf2;
        DEFAULT_EVDO_ASU_LEVEL = valueOf2;
        DEFAULT_EVDO_ECIO = valueOf2;
        DEFAULT_GSM_DBM = valueOf2;
        DEFAULT_GSM_ASU_LEVEL = valueOf2;
        DEFAULT_TD_SCDMA_DBM = valueOf2;
        DEFAULT_TD_SCDMA_ASU_LEVEL = valueOf2;
        DEFAULT_LTE_DBM = valueOf2;
        DEFAULT_LTE_RSRP = valueOf2;
        DEFAULT_LTE_RSRQ = valueOf2;
        DEFAULT_LTE_ASU_LEVEL = valueOf2;
    }

    public MobileNetworkInfoMessage(Integer num, Double d, Double d2, Long l, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, Float f10, Float f11, Float f12, Float f13, Float f14) {
        this(num, d, d2, l, str, str2, num2, num3, num4, num5, num6, num7, num8, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MobileNetworkInfoMessage)) {
            return false;
        }
        MobileNetworkInfoMessage mobileNetworkInfoMessage = (MobileNetworkInfoMessage) obj;
        if (!unknownFields().equals(mobileNetworkInfoMessage.unknownFields()) || !Internal.equals(this.id, mobileNetworkInfoMessage.id) || !Internal.equals(this.latitude, mobileNetworkInfoMessage.latitude) || !Internal.equals(this.longitude, mobileNetworkInfoMessage.longitude) || !Internal.equals(this.time_stamp, mobileNetworkInfoMessage.time_stamp) || !Internal.equals(this.phone_type, mobileNetworkInfoMessage.phone_type) || !Internal.equals(this.network_type, mobileNetworkInfoMessage.network_type) || !Internal.equals(this.base_station_id, mobileNetworkInfoMessage.base_station_id) || !Internal.equals(this.base_station_latitude, mobileNetworkInfoMessage.base_station_latitude) || !Internal.equals(this.base_station_longitude, mobileNetworkInfoMessage.base_station_longitude) || !Internal.equals(this.network_id, mobileNetworkInfoMessage.network_id) || !Internal.equals(this.system_id, mobileNetworkInfoMessage.system_id) || !Internal.equals(this.cid, mobileNetworkInfoMessage.cid) || !Internal.equals(this.lac, mobileNetworkInfoMessage.lac) || !Internal.equals(this.cdma_dbm, mobileNetworkInfoMessage.cdma_dbm) || !Internal.equals(this.cdma_asu_level, mobileNetworkInfoMessage.cdma_asu_level) || !Internal.equals(this.cdma_ecio, mobileNetworkInfoMessage.cdma_ecio) || !Internal.equals(this.evdo_dbm, mobileNetworkInfoMessage.evdo_dbm) || !Internal.equals(this.evdo_asu_level, mobileNetworkInfoMessage.evdo_asu_level) || !Internal.equals(this.evdo_ecio, mobileNetworkInfoMessage.evdo_ecio) || !Internal.equals(this.gsm_dbm, mobileNetworkInfoMessage.gsm_dbm) || !Internal.equals(this.gsm_asu_level, mobileNetworkInfoMessage.gsm_asu_level) || !Internal.equals(this.td_scdma_dbm, mobileNetworkInfoMessage.td_scdma_dbm) || !Internal.equals(this.td_scdma_asu_level, mobileNetworkInfoMessage.td_scdma_asu_level) || !Internal.equals(this.lte_dbm, mobileNetworkInfoMessage.lte_dbm) || !Internal.equals(this.lte_rsrp, mobileNetworkInfoMessage.lte_rsrp) || !Internal.equals(this.lte_rsrq, mobileNetworkInfoMessage.lte_rsrq) || !Internal.equals(this.lte_asu_level, mobileNetworkInfoMessage.lte_asu_level)) {
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
        Double d = this.latitude;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.longitude;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Long l = this.time_stamp;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.phone_type;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.network_type;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.base_station_id;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.base_station_latitude;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.base_station_longitude;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.network_id;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.system_id;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.cid;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.lac;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Float f = this.cdma_dbm;
        int hashCode15 = (hashCode14 + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.cdma_asu_level;
        int hashCode16 = (hashCode15 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.cdma_ecio;
        int hashCode17 = (hashCode16 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.evdo_dbm;
        int hashCode18 = (hashCode17 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Float f5 = this.evdo_asu_level;
        int hashCode19 = (hashCode18 + (f5 != null ? f5.hashCode() : 0)) * 37;
        Float f6 = this.evdo_ecio;
        int hashCode20 = (hashCode19 + (f6 != null ? f6.hashCode() : 0)) * 37;
        Float f7 = this.gsm_dbm;
        int hashCode21 = (hashCode20 + (f7 != null ? f7.hashCode() : 0)) * 37;
        Float f8 = this.gsm_asu_level;
        int hashCode22 = (hashCode21 + (f8 != null ? f8.hashCode() : 0)) * 37;
        Float f9 = this.td_scdma_dbm;
        int hashCode23 = (hashCode22 + (f9 != null ? f9.hashCode() : 0)) * 37;
        Float f10 = this.td_scdma_asu_level;
        int hashCode24 = (hashCode23 + (f10 != null ? f10.hashCode() : 0)) * 37;
        Float f11 = this.lte_dbm;
        int hashCode25 = (hashCode24 + (f11 != null ? f11.hashCode() : 0)) * 37;
        Float f12 = this.lte_rsrp;
        int hashCode26 = (hashCode25 + (f12 != null ? f12.hashCode() : 0)) * 37;
        Float f13 = this.lte_rsrq;
        int hashCode27 = (hashCode26 + (f13 != null ? f13.hashCode() : 0)) * 37;
        Float f14 = this.lte_asu_level;
        if (f14 != null) {
            i2 = f14.hashCode();
        }
        int i3 = hashCode27 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.latitude != null) {
            sb.append(", latitude=");
            sb.append(this.latitude);
        }
        if (this.longitude != null) {
            sb.append(", longitude=");
            sb.append(this.longitude);
        }
        if (this.time_stamp != null) {
            sb.append(", time_stamp=");
            sb.append(this.time_stamp);
        }
        if (this.phone_type != null) {
            sb.append(", phone_type=");
            sb.append(this.phone_type);
        }
        if (this.network_type != null) {
            sb.append(", network_type=");
            sb.append(this.network_type);
        }
        if (this.base_station_id != null) {
            sb.append(", base_station_id=");
            sb.append(this.base_station_id);
        }
        if (this.base_station_latitude != null) {
            sb.append(", base_station_latitude=");
            sb.append(this.base_station_latitude);
        }
        if (this.base_station_longitude != null) {
            sb.append(", base_station_longitude=");
            sb.append(this.base_station_longitude);
        }
        if (this.network_id != null) {
            sb.append(", network_id=");
            sb.append(this.network_id);
        }
        if (this.system_id != null) {
            sb.append(", system_id=");
            sb.append(this.system_id);
        }
        if (this.cid != null) {
            sb.append(", cid=");
            sb.append(this.cid);
        }
        if (this.lac != null) {
            sb.append(", lac=");
            sb.append(this.lac);
        }
        if (this.cdma_dbm != null) {
            sb.append(", cdma_dbm=");
            sb.append(this.cdma_dbm);
        }
        if (this.cdma_asu_level != null) {
            sb.append(", cdma_asu_level=");
            sb.append(this.cdma_asu_level);
        }
        if (this.cdma_ecio != null) {
            sb.append(", cdma_ecio=");
            sb.append(this.cdma_ecio);
        }
        if (this.evdo_dbm != null) {
            sb.append(", evdo_dbm=");
            sb.append(this.evdo_dbm);
        }
        if (this.evdo_asu_level != null) {
            sb.append(", evdo_asu_level=");
            sb.append(this.evdo_asu_level);
        }
        if (this.evdo_ecio != null) {
            sb.append(", evdo_ecio=");
            sb.append(this.evdo_ecio);
        }
        if (this.gsm_dbm != null) {
            sb.append(", gsm_dbm=");
            sb.append(this.gsm_dbm);
        }
        if (this.gsm_asu_level != null) {
            sb.append(", gsm_asu_level=");
            sb.append(this.gsm_asu_level);
        }
        if (this.td_scdma_dbm != null) {
            sb.append(", td_scdma_dbm=");
            sb.append(this.td_scdma_dbm);
        }
        if (this.td_scdma_asu_level != null) {
            sb.append(", td_scdma_asu_level=");
            sb.append(this.td_scdma_asu_level);
        }
        if (this.lte_dbm != null) {
            sb.append(", lte_dbm=");
            sb.append(this.lte_dbm);
        }
        if (this.lte_rsrp != null) {
            sb.append(", lte_rsrp=");
            sb.append(this.lte_rsrp);
        }
        if (this.lte_rsrq != null) {
            sb.append(", lte_rsrq=");
            sb.append(this.lte_rsrq);
        }
        if (this.lte_asu_level != null) {
            sb.append(", lte_asu_level=");
            sb.append(this.lte_asu_level);
        }
        return c.a(sb, 0, 2, "MobileNetworkInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileNetworkInfoMessage(Integer num, Double d, Double d2, Long l, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, Float f10, Float f11, Float f12, Float f13, Float f14, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = num;
        this.latitude = d;
        this.longitude = d2;
        this.time_stamp = l;
        this.phone_type = str;
        this.network_type = str2;
        this.base_station_id = num2;
        this.base_station_latitude = num3;
        this.base_station_longitude = num4;
        this.network_id = num5;
        this.system_id = num6;
        this.cid = num7;
        this.lac = num8;
        this.cdma_dbm = f;
        this.cdma_asu_level = f2;
        this.cdma_ecio = f3;
        this.evdo_dbm = f4;
        this.evdo_asu_level = f5;
        this.evdo_ecio = f6;
        this.gsm_dbm = f7;
        this.gsm_asu_level = f8;
        this.td_scdma_dbm = f9;
        this.td_scdma_asu_level = f10;
        this.lte_dbm = f11;
        this.lte_rsrp = f12;
        this.lte_rsrq = f13;
        this.lte_asu_level = f14;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.time_stamp = this.time_stamp;
        builder.phone_type = this.phone_type;
        builder.network_type = this.network_type;
        builder.base_station_id = this.base_station_id;
        builder.base_station_latitude = this.base_station_latitude;
        builder.base_station_longitude = this.base_station_longitude;
        builder.network_id = this.network_id;
        builder.system_id = this.system_id;
        builder.cid = this.cid;
        builder.lac = this.lac;
        builder.cdma_dbm = this.cdma_dbm;
        builder.cdma_asu_level = this.cdma_asu_level;
        builder.cdma_ecio = this.cdma_ecio;
        builder.evdo_dbm = this.evdo_dbm;
        builder.evdo_asu_level = this.evdo_asu_level;
        builder.evdo_ecio = this.evdo_ecio;
        builder.gsm_dbm = this.gsm_dbm;
        builder.gsm_asu_level = this.gsm_asu_level;
        builder.td_scdma_dbm = this.td_scdma_dbm;
        builder.td_scdma_asu_level = this.td_scdma_asu_level;
        builder.lte_dbm = this.lte_dbm;
        builder.lte_rsrp = this.lte_rsrp;
        builder.lte_rsrq = this.lte_rsrq;
        builder.lte_asu_level = this.lte_asu_level;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
