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

public final class WifiNetworkInfoMessage extends Message<WifiNetworkInfoMessage, Builder> {
    public static final ProtoAdapter<WifiNetworkInfoMessage> ADAPTER = new ProtoAdapter_WifiNetworkInfoMessage();
    public static final Double DEFAULT_ACCURACY;
    public static final Integer DEFAULT_CONNECTED_WIFI_BAND_FREQUENCY = 0;
    public static final Integer DEFAULT_CONNECTION_SPEED = 0;
    public static final Long DEFAULT_DATARX = 0L;
    public static final Long DEFAULT_DATATX = 0L;
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_IP_ADDRESS = "";
    public static final Double DEFAULT_LATITUDE;
    public static final String DEFAULT_LOCATIONPROVIDER = "";
    public static final Long DEFAULT_LOCATIONTIMESTAMP = 0L;
    public static final Double DEFAULT_LONGITUDE;
    public static final String DEFAULT_PERMISSIONS = "";
    public static final String DEFAULT_SSID = "";
    public static final Integer DEFAULT_TIMEZONEOFFSET = 0;
    public static final Long DEFAULT_TIME_STAMP = 0L;
    public static final Integer DEFAULT_WIFI_SIGNAL_STRENGTH = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 12)
    public final Double accuracy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer connected_wifi_band_frequency;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer connection_speed;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 13)
    public final Long dataRx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 14)
    public final Long dataTx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String ip_address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 10)
    public final Double latitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String locationProvider;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 8)
    public final Long locationTimeStamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 11)
    public final Double longitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String permissions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String ssid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 15)
    public final Integer timeZoneOffset;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long time_stamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer wifi_signal_strength;

    public static final class Builder extends Message.Builder<WifiNetworkInfoMessage, Builder> {
        public Double accuracy;
        public Integer connected_wifi_band_frequency;
        public Integer connection_speed;
        public Long dataRx;
        public Long dataTx;
        public Integer id;
        public String ip_address;
        public Double latitude;
        public String locationProvider;
        public Long locationTimeStamp;
        public Double longitude;
        public String permissions;
        public String ssid;
        public Integer timeZoneOffset;
        public Long time_stamp;
        public Integer wifi_signal_strength;

        public Builder accuracy(Double d) {
            this.accuracy = d;
            return this;
        }

        public Builder connected_wifi_band_frequency(Integer num) {
            this.connected_wifi_band_frequency = num;
            return this;
        }

        public Builder connection_speed(Integer num) {
            this.connection_speed = num;
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

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder ip_address(String str) {
            this.ip_address = str;
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

        public Builder permissions(String str) {
            this.permissions = str;
            return this;
        }

        public Builder ssid(String str) {
            this.ssid = str;
            return this;
        }

        public Builder timeZoneOffset(Integer num) {
            this.timeZoneOffset = num;
            return this;
        }

        public Builder time_stamp(Long l) {
            this.time_stamp = l;
            return this;
        }

        public Builder wifi_signal_strength(Integer num) {
            this.wifi_signal_strength = num;
            return this;
        }

        public WifiNetworkInfoMessage build() {
            return new WifiNetworkInfoMessage(this.id, this.time_stamp, this.ssid, this.ip_address, this.connection_speed, this.wifi_signal_strength, this.connected_wifi_band_frequency, this.locationTimeStamp, this.locationProvider, this.latitude, this.longitude, this.accuracy, this.dataRx, this.dataTx, this.timeZoneOffset, this.permissions, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_WifiNetworkInfoMessage extends ProtoAdapter<WifiNetworkInfoMessage> {
        public ProtoAdapter_WifiNetworkInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) WifiNetworkInfoMessage.class);
        }

        public WifiNetworkInfoMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.id(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 2:
                            builder.time_stamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 3:
                            builder.ssid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.ip_address(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.connection_speed(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 6:
                            builder.wifi_signal_strength(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 7:
                            builder.connected_wifi_band_frequency(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 8:
                            builder.locationTimeStamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 9:
                            builder.locationProvider(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.latitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 11:
                            builder.longitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 12:
                            builder.accuracy(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 13:
                            builder.dataRx(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 14:
                            builder.dataTx(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 15:
                            builder.timeZoneOffset(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 16:
                            builder.permissions(ProtoAdapter.STRING.decode(protoReader));
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

        public void encode(ProtoWriter protoWriter, WifiNetworkInfoMessage wifiNetworkInfoMessage) {
            Integer num = wifiNetworkInfoMessage.id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            Long l = wifiNetworkInfoMessage.time_stamp;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, l);
            }
            String str = wifiNetworkInfoMessage.ssid;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, str);
            }
            String str2 = wifiNetworkInfoMessage.ip_address;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, str2);
            }
            Integer num2 = wifiNetworkInfoMessage.connection_speed;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, num2);
            }
            Integer num3 = wifiNetworkInfoMessage.wifi_signal_strength;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, num3);
            }
            Integer num4 = wifiNetworkInfoMessage.connected_wifi_band_frequency;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, num4);
            }
            Long l2 = wifiNetworkInfoMessage.locationTimeStamp;
            if (l2 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 8, l2);
            }
            String str3 = wifiNetworkInfoMessage.locationProvider;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, str3);
            }
            Double d = wifiNetworkInfoMessage.latitude;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 10, d);
            }
            Double d2 = wifiNetworkInfoMessage.longitude;
            if (d2 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 11, d2);
            }
            Double d3 = wifiNetworkInfoMessage.accuracy;
            if (d3 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 12, d3);
            }
            Long l3 = wifiNetworkInfoMessage.dataRx;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 13, l3);
            }
            Long l4 = wifiNetworkInfoMessage.dataTx;
            if (l4 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 14, l4);
            }
            Integer num5 = wifiNetworkInfoMessage.timeZoneOffset;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, num5);
            }
            String str4 = wifiNetworkInfoMessage.permissions;
            if (str4 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, str4);
            }
            protoWriter.writeBytes(wifiNetworkInfoMessage.unknownFields());
        }

        public int encodedSize(WifiNetworkInfoMessage wifiNetworkInfoMessage) {
            Integer num = wifiNetworkInfoMessage.id;
            int i = 0;
            int encodedSizeWithTag = num != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, num) : 0;
            Long l = wifiNetworkInfoMessage.time_stamp;
            int encodedSizeWithTag2 = encodedSizeWithTag + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(2, l) : 0);
            String str = wifiNetworkInfoMessage.ssid;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, str) : 0);
            String str2 = wifiNetworkInfoMessage.ip_address;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, str2) : 0);
            Integer num2 = wifiNetworkInfoMessage.connection_speed;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, num2) : 0);
            Integer num3 = wifiNetworkInfoMessage.wifi_signal_strength;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(6, num3) : 0);
            Integer num4 = wifiNetworkInfoMessage.connected_wifi_band_frequency;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, num4) : 0);
            Long l2 = wifiNetworkInfoMessage.locationTimeStamp;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (l2 != null ? ProtoAdapter.INT64.encodedSizeWithTag(8, l2) : 0);
            String str3 = wifiNetworkInfoMessage.locationProvider;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (str3 != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, str3) : 0);
            Double d = wifiNetworkInfoMessage.latitude;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(10, d) : 0);
            Double d2 = wifiNetworkInfoMessage.longitude;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (d2 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(11, d2) : 0);
            Double d3 = wifiNetworkInfoMessage.accuracy;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (d3 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(12, d3) : 0);
            Long l3 = wifiNetworkInfoMessage.dataRx;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (l3 != null ? ProtoAdapter.INT64.encodedSizeWithTag(13, l3) : 0);
            Long l4 = wifiNetworkInfoMessage.dataTx;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (l4 != null ? ProtoAdapter.INT64.encodedSizeWithTag(14, l4) : 0);
            Integer num5 = wifiNetworkInfoMessage.timeZoneOffset;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(15, num5) : 0);
            String str4 = wifiNetworkInfoMessage.permissions;
            if (str4 != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(16, str4);
            }
            return wifiNetworkInfoMessage.unknownFields().size() + encodedSizeWithTag15 + i;
        }

        public WifiNetworkInfoMessage redact(WifiNetworkInfoMessage wifiNetworkInfoMessage) {
            Builder newBuilder = wifiNetworkInfoMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
        DEFAULT_ACCURACY = valueOf;
    }

    public WifiNetworkInfoMessage(Integer num, Long l, String str, String str2, Integer num2, Integer num3, Integer num4, Long l2, String str3, Double d, Double d2, Double d3, Long l3, Long l4, Integer num5, String str4) {
        this(num, l, str, str2, num2, num3, num4, l2, str3, d, d2, d3, l3, l4, num5, str4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WifiNetworkInfoMessage)) {
            return false;
        }
        WifiNetworkInfoMessage wifiNetworkInfoMessage = (WifiNetworkInfoMessage) obj;
        if (!unknownFields().equals(wifiNetworkInfoMessage.unknownFields()) || !Internal.equals(this.id, wifiNetworkInfoMessage.id) || !Internal.equals(this.time_stamp, wifiNetworkInfoMessage.time_stamp) || !Internal.equals(this.ssid, wifiNetworkInfoMessage.ssid) || !Internal.equals(this.ip_address, wifiNetworkInfoMessage.ip_address) || !Internal.equals(this.connection_speed, wifiNetworkInfoMessage.connection_speed) || !Internal.equals(this.wifi_signal_strength, wifiNetworkInfoMessage.wifi_signal_strength) || !Internal.equals(this.connected_wifi_band_frequency, wifiNetworkInfoMessage.connected_wifi_band_frequency) || !Internal.equals(this.locationTimeStamp, wifiNetworkInfoMessage.locationTimeStamp) || !Internal.equals(this.locationProvider, wifiNetworkInfoMessage.locationProvider) || !Internal.equals(this.latitude, wifiNetworkInfoMessage.latitude) || !Internal.equals(this.longitude, wifiNetworkInfoMessage.longitude) || !Internal.equals(this.accuracy, wifiNetworkInfoMessage.accuracy) || !Internal.equals(this.dataRx, wifiNetworkInfoMessage.dataRx) || !Internal.equals(this.dataTx, wifiNetworkInfoMessage.dataTx) || !Internal.equals(this.timeZoneOffset, wifiNetworkInfoMessage.timeZoneOffset) || !Internal.equals(this.permissions, wifiNetworkInfoMessage.permissions)) {
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
        Long l = this.time_stamp;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.ssid;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.ip_address;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.connection_speed;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.wifi_signal_strength;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.connected_wifi_band_frequency;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.locationTimeStamp;
        int hashCode9 = (hashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.locationProvider;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Double d = this.latitude;
        int hashCode11 = (hashCode10 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.longitude;
        int hashCode12 = (hashCode11 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode13 = (hashCode12 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l3 = this.dataRx;
        int hashCode14 = (hashCode13 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.dataTx;
        int hashCode15 = (hashCode14 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num5 = this.timeZoneOffset;
        int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.permissions;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.time_stamp != null) {
            sb.append(", time_stamp=");
            sb.append(this.time_stamp);
        }
        if (this.ssid != null) {
            sb.append(", ssid=");
            sb.append(this.ssid);
        }
        if (this.ip_address != null) {
            sb.append(", ip_address=");
            sb.append(this.ip_address);
        }
        if (this.connection_speed != null) {
            sb.append(", connection_speed=");
            sb.append(this.connection_speed);
        }
        if (this.wifi_signal_strength != null) {
            sb.append(", wifi_signal_strength=");
            sb.append(this.wifi_signal_strength);
        }
        if (this.connected_wifi_band_frequency != null) {
            sb.append(", connected_wifi_band_frequency=");
            sb.append(this.connected_wifi_band_frequency);
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
        if (this.dataRx != null) {
            sb.append(", dataRx=");
            sb.append(this.dataRx);
        }
        if (this.dataTx != null) {
            sb.append(", dataTx=");
            sb.append(this.dataTx);
        }
        if (this.timeZoneOffset != null) {
            sb.append(", timeZoneOffset=");
            sb.append(this.timeZoneOffset);
        }
        if (this.permissions != null) {
            sb.append(", permissions=");
            sb.append(this.permissions);
        }
        return c.a(sb, 0, 2, "WifiNetworkInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiNetworkInfoMessage(Integer num, Long l, String str, String str2, Integer num2, Integer num3, Integer num4, Long l2, String str3, Double d, Double d2, Double d3, Long l3, Long l4, Integer num5, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = num;
        this.time_stamp = l;
        this.ssid = str;
        this.ip_address = str2;
        this.connection_speed = num2;
        this.wifi_signal_strength = num3;
        this.connected_wifi_band_frequency = num4;
        this.locationTimeStamp = l2;
        this.locationProvider = str3;
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = d3;
        this.dataRx = l3;
        this.dataTx = l4;
        this.timeZoneOffset = num5;
        this.permissions = str4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.time_stamp = this.time_stamp;
        builder.ssid = this.ssid;
        builder.ip_address = this.ip_address;
        builder.connection_speed = this.connection_speed;
        builder.wifi_signal_strength = this.wifi_signal_strength;
        builder.connected_wifi_band_frequency = this.connected_wifi_band_frequency;
        builder.locationTimeStamp = this.locationTimeStamp;
        builder.locationProvider = this.locationProvider;
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.accuracy = this.accuracy;
        builder.dataRx = this.dataRx;
        builder.dataTx = this.dataTx;
        builder.timeZoneOffset = this.timeZoneOffset;
        builder.permissions = this.permissions;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
