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

public final class NoNetworkSignalInfoMessage extends Message<NoNetworkSignalInfoMessage, Builder> {
    public static final ProtoAdapter<NoNetworkSignalInfoMessage> ADAPTER = new ProtoAdapter_NoNetworkSignalInfoMessage();
    public static final Double DEFAULT_ACCURACY;
    public static final Double DEFAULT_LATITUDE;
    public static final String DEFAULT_LOCATIONPROVIDER = "";
    public static final Long DEFAULT_LOCATIONTIMESTAMP = 0L;
    public static final Double DEFAULT_LONGITUDE;
    public static final String DEFAULT_PERMISSIONS = "";
    public static final String DEFAULT_PHONETYPE = "";
    public static final Integer DEFAULT_SIMMCC = 0;
    public static final Integer DEFAULT_SIMMNC = 0;
    public static final String DEFAULT_SIMOPERATORNAME = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TIMEZONE = "";
    public static final Long DEFAULT_TIMEZONEOFFSET = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 29)
    public final Double accuracy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 27)
    public final Double latitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 26)
    public final String locationProvider;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 25)
    public final Long locationTimeStamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 28)
    public final Double longitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 33)
    public final String permissions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final String phoneType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer simMcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 31)
    public final Integer simMnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 30)
    public final String simOperatorName;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 21)
    public final Long timeStamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 22)
    public final String timeZone;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 23)
    public final Long timeZoneOffset;

    public static final class Builder extends Message.Builder<NoNetworkSignalInfoMessage, Builder> {
        public Double accuracy;
        public Double latitude;
        public String locationProvider;
        public Long locationTimeStamp;
        public Double longitude;
        public String permissions;
        public String phoneType;
        public Integer simMcc;
        public Integer simMnc;
        public String simOperatorName;
        public Long timeStamp;
        public String timeZone;
        public Long timeZoneOffset;

        public Builder accuracy(Double d) {
            this.accuracy = d;
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

        public Builder phoneType(String str) {
            this.phoneType = str;
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

        public Builder timeStamp(Long l) {
            this.timeStamp = l;
            return this;
        }

        public Builder timeZone(String str) {
            this.timeZone = str;
            return this;
        }

        public Builder timeZoneOffset(Long l) {
            this.timeZoneOffset = l;
            return this;
        }

        public NoNetworkSignalInfoMessage build() {
            return new NoNetworkSignalInfoMessage(this.timeStamp, this.timeZone, this.timeZoneOffset, this.phoneType, this.locationTimeStamp, this.locationProvider, this.latitude, this.longitude, this.accuracy, this.simOperatorName, this.simMnc, this.simMcc, this.permissions, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_NoNetworkSignalInfoMessage extends ProtoAdapter<NoNetworkSignalInfoMessage> {
        public ProtoAdapter_NoNetworkSignalInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) NoNetworkSignalInfoMessage.class);
        }

        public NoNetworkSignalInfoMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 21:
                            builder.timeStamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 22:
                            builder.timeZone(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 23:
                            builder.timeZoneOffset(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 24:
                            builder.phoneType(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 25:
                            builder.locationTimeStamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 26:
                            builder.locationProvider(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 27:
                            builder.latitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 28:
                            builder.longitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 29:
                            builder.accuracy(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 30:
                            builder.simOperatorName(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 31:
                            builder.simMnc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 32:
                            builder.simMcc(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 33:
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

        public void encode(ProtoWriter protoWriter, NoNetworkSignalInfoMessage noNetworkSignalInfoMessage) {
            Long l = noNetworkSignalInfoMessage.timeStamp;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 21, l);
            }
            String str = noNetworkSignalInfoMessage.timeZone;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 22, str);
            }
            Long l2 = noNetworkSignalInfoMessage.timeZoneOffset;
            if (l2 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 23, l2);
            }
            String str2 = noNetworkSignalInfoMessage.phoneType;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 24, str2);
            }
            Long l3 = noNetworkSignalInfoMessage.locationTimeStamp;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 25, l3);
            }
            String str3 = noNetworkSignalInfoMessage.locationProvider;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 26, str3);
            }
            Double d = noNetworkSignalInfoMessage.latitude;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 27, d);
            }
            Double d2 = noNetworkSignalInfoMessage.longitude;
            if (d2 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 28, d2);
            }
            Double d3 = noNetworkSignalInfoMessage.accuracy;
            if (d3 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 29, d3);
            }
            String str4 = noNetworkSignalInfoMessage.simOperatorName;
            if (str4 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 30, str4);
            }
            Integer num = noNetworkSignalInfoMessage.simMnc;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 31, num);
            }
            Integer num2 = noNetworkSignalInfoMessage.simMcc;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num2);
            }
            String str5 = noNetworkSignalInfoMessage.permissions;
            if (str5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 33, str5);
            }
            protoWriter.writeBytes(noNetworkSignalInfoMessage.unknownFields());
        }

        public int encodedSize(NoNetworkSignalInfoMessage noNetworkSignalInfoMessage) {
            Long l = noNetworkSignalInfoMessage.timeStamp;
            int i = 0;
            int encodedSizeWithTag = l != null ? ProtoAdapter.INT64.encodedSizeWithTag(21, l) : 0;
            String str = noNetworkSignalInfoMessage.timeZone;
            int encodedSizeWithTag2 = encodedSizeWithTag + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(22, str) : 0);
            Long l2 = noNetworkSignalInfoMessage.timeZoneOffset;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (l2 != null ? ProtoAdapter.INT64.encodedSizeWithTag(23, l2) : 0);
            String str2 = noNetworkSignalInfoMessage.phoneType;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(24, str2) : 0);
            Long l3 = noNetworkSignalInfoMessage.locationTimeStamp;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (l3 != null ? ProtoAdapter.INT64.encodedSizeWithTag(25, l3) : 0);
            String str3 = noNetworkSignalInfoMessage.locationProvider;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (str3 != null ? ProtoAdapter.STRING.encodedSizeWithTag(26, str3) : 0);
            Double d = noNetworkSignalInfoMessage.latitude;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(27, d) : 0);
            Double d2 = noNetworkSignalInfoMessage.longitude;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (d2 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(28, d2) : 0);
            Double d3 = noNetworkSignalInfoMessage.accuracy;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (d3 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(29, d3) : 0);
            String str4 = noNetworkSignalInfoMessage.simOperatorName;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (str4 != null ? ProtoAdapter.STRING.encodedSizeWithTag(30, str4) : 0);
            Integer num = noNetworkSignalInfoMessage.simMnc;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(31, num) : 0);
            Integer num2 = noNetworkSignalInfoMessage.simMcc;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num2) : 0);
            String str5 = noNetworkSignalInfoMessage.permissions;
            if (str5 != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(33, str5);
            }
            return noNetworkSignalInfoMessage.unknownFields().size() + encodedSizeWithTag12 + i;
        }

        public NoNetworkSignalInfoMessage redact(NoNetworkSignalInfoMessage noNetworkSignalInfoMessage) {
            Builder newBuilder = noNetworkSignalInfoMessage.newBuilder();
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

    public NoNetworkSignalInfoMessage(Long l, String str, Long l2, String str2, Long l3, String str3, Double d, Double d2, Double d3, String str4, Integer num, Integer num2, String str5) {
        this(l, str, l2, str2, l3, str3, d, d2, d3, str4, num, num2, str5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NoNetworkSignalInfoMessage)) {
            return false;
        }
        NoNetworkSignalInfoMessage noNetworkSignalInfoMessage = (NoNetworkSignalInfoMessage) obj;
        if (!unknownFields().equals(noNetworkSignalInfoMessage.unknownFields()) || !Internal.equals(this.timeStamp, noNetworkSignalInfoMessage.timeStamp) || !Internal.equals(this.timeZone, noNetworkSignalInfoMessage.timeZone) || !Internal.equals(this.timeZoneOffset, noNetworkSignalInfoMessage.timeZoneOffset) || !Internal.equals(this.phoneType, noNetworkSignalInfoMessage.phoneType) || !Internal.equals(this.locationTimeStamp, noNetworkSignalInfoMessage.locationTimeStamp) || !Internal.equals(this.locationProvider, noNetworkSignalInfoMessage.locationProvider) || !Internal.equals(this.latitude, noNetworkSignalInfoMessage.latitude) || !Internal.equals(this.longitude, noNetworkSignalInfoMessage.longitude) || !Internal.equals(this.accuracy, noNetworkSignalInfoMessage.accuracy) || !Internal.equals(this.simOperatorName, noNetworkSignalInfoMessage.simOperatorName) || !Internal.equals(this.simMnc, noNetworkSignalInfoMessage.simMnc) || !Internal.equals(this.simMcc, noNetworkSignalInfoMessage.simMcc) || !Internal.equals(this.permissions, noNetworkSignalInfoMessage.permissions)) {
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
        Long l = this.timeStamp;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.timeZone;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.timeZoneOffset;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.phoneType;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l3 = this.locationTimeStamp;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str3 = this.locationProvider;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Double d = this.latitude;
        int hashCode8 = (hashCode7 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.longitude;
        int hashCode9 = (hashCode8 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode10 = (hashCode9 + (d3 != null ? d3.hashCode() : 0)) * 37;
        String str4 = this.simOperatorName;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num = this.simMnc;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.simMcc;
        int hashCode13 = (hashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str5 = this.permissions;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.timeStamp != null) {
            sb.append(", timeStamp=");
            sb.append(this.timeStamp);
        }
        if (this.timeZone != null) {
            sb.append(", timeZone=");
            sb.append(this.timeZone);
        }
        if (this.timeZoneOffset != null) {
            sb.append(", timeZoneOffset=");
            sb.append(this.timeZoneOffset);
        }
        if (this.phoneType != null) {
            sb.append(", phoneType=");
            sb.append(this.phoneType);
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
        if (this.simOperatorName != null) {
            sb.append(", simOperatorName=");
            sb.append(this.simOperatorName);
        }
        if (this.simMnc != null) {
            sb.append(", simMnc=");
            sb.append(this.simMnc);
        }
        if (this.simMcc != null) {
            sb.append(", simMcc=");
            sb.append(this.simMcc);
        }
        if (this.permissions != null) {
            sb.append(", permissions=");
            sb.append(this.permissions);
        }
        return c.a(sb, 0, 2, "NoNetworkSignalInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public NoNetworkSignalInfoMessage(Long l, String str, Long l2, String str2, Long l3, String str3, Double d, Double d2, Double d3, String str4, Integer num, Integer num2, String str5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.timeStamp = l;
        this.timeZone = str;
        this.timeZoneOffset = l2;
        this.phoneType = str2;
        this.locationTimeStamp = l3;
        this.locationProvider = str3;
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = d3;
        this.simOperatorName = str4;
        this.simMnc = num;
        this.simMcc = num2;
        this.permissions = str5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.timeStamp = this.timeStamp;
        builder.timeZone = this.timeZone;
        builder.timeZoneOffset = this.timeZoneOffset;
        builder.phoneType = this.phoneType;
        builder.locationTimeStamp = this.locationTimeStamp;
        builder.locationProvider = this.locationProvider;
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.accuracy = this.accuracy;
        builder.simOperatorName = this.simOperatorName;
        builder.simMnc = this.simMnc;
        builder.simMcc = this.simMcc;
        builder.permissions = this.permissions;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
