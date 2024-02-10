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

public final class LocationLogMessage extends Message<LocationLogMessage, Builder> {
    public static final ProtoAdapter<LocationLogMessage> ADAPTER = new ProtoAdapter_LocationLogMessage();
    public static final Float DEFAULT_ACCURACY;
    public static final Double DEFAULT_ALTITUDE;
    public static final Float DEFAULT_BAROMETRIC;
    public static final Float DEFAULT_BEARING;
    public static final Float DEFAULT_INDOOROUTDOORWEIGHT;
    public static final Double DEFAULT_LATITUDE;
    public static final Double DEFAULT_LONGITUDE;
    public static final String DEFAULT_PERMISSIONS = "";
    public static final String DEFAULT_PROVIDER = "";
    public static final Float DEFAULT_SPEED;
    public static final Long DEFAULT_TIME_STAMP = 0L;
    public static final String DEFAULT_TIME_ZONE_ID = "";
    public static final Integer DEFAULT_TIME_ZONE_OFFSET = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    public final Float accuracy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 8)
    public final Double altitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 12)
    public final Float barometric;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
    public final Float bearing;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    public final Float indoorOutdoorWeight;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 5)
    public final Double latitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 6)
    public final Double longitude;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String permissions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String provider;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 10)
    public final Float speed;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long time_stamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String time_zone_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer time_zone_offset;

    public static final class Builder extends Message.Builder<LocationLogMessage, Builder> {
        public Float accuracy;
        public Double altitude;
        public Float barometric;
        public Float bearing;
        public Float indoorOutdoorWeight;
        public Double latitude;
        public Double longitude;
        public String permissions;
        public String provider;
        public Float speed;
        public Long time_stamp;
        public String time_zone_id;
        public Integer time_zone_offset;

        public Builder accuracy(Float f) {
            this.accuracy = f;
            return this;
        }

        public Builder altitude(Double d) {
            this.altitude = d;
            return this;
        }

        public Builder barometric(Float f) {
            this.barometric = f;
            return this;
        }

        public Builder bearing(Float f) {
            this.bearing = f;
            return this;
        }

        public Builder indoorOutdoorWeight(Float f) {
            this.indoorOutdoorWeight = f;
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

        public Builder permissions(String str) {
            this.permissions = str;
            return this;
        }

        public Builder provider(String str) {
            this.provider = str;
            return this;
        }

        public Builder speed(Float f) {
            this.speed = f;
            return this;
        }

        public Builder time_stamp(Long l) {
            this.time_stamp = l;
            return this;
        }

        public Builder time_zone_id(String str) {
            this.time_zone_id = str;
            return this;
        }

        public Builder time_zone_offset(Integer num) {
            this.time_zone_offset = num;
            return this;
        }

        public LocationLogMessage build() {
            return new LocationLogMessage(this.time_stamp, this.time_zone_id, this.time_zone_offset, this.provider, this.latitude, this.longitude, this.accuracy, this.altitude, this.bearing, this.speed, this.indoorOutdoorWeight, this.barometric, this.permissions, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_LocationLogMessage extends ProtoAdapter<LocationLogMessage> {
        public ProtoAdapter_LocationLogMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LocationLogMessage.class);
        }

        public LocationLogMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.time_stamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 2:
                            builder.time_zone_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.time_zone_offset(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 4:
                            builder.provider(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.latitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 6:
                            builder.longitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 7:
                            builder.accuracy(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 8:
                            builder.altitude(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 9:
                            builder.bearing(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 10:
                            builder.speed(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 11:
                            builder.indoorOutdoorWeight(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 12:
                            builder.barometric(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 13:
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

        public void encode(ProtoWriter protoWriter, LocationLogMessage locationLogMessage) {
            Long l = locationLogMessage.time_stamp;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, l);
            }
            String str = locationLogMessage.time_zone_id;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str);
            }
            Integer num = locationLogMessage.time_zone_offset;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num);
            }
            String str2 = locationLogMessage.provider;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, str2);
            }
            Double d = locationLogMessage.latitude;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 5, d);
            }
            Double d2 = locationLogMessage.longitude;
            if (d2 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 6, d2);
            }
            Float f = locationLogMessage.accuracy;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 7, f);
            }
            Double d3 = locationLogMessage.altitude;
            if (d3 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 8, d3);
            }
            Float f2 = locationLogMessage.bearing;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 9, f2);
            }
            Float f3 = locationLogMessage.speed;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 10, f3);
            }
            Float f4 = locationLogMessage.indoorOutdoorWeight;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 11, f4);
            }
            Float f5 = locationLogMessage.barometric;
            if (f5 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 12, f5);
            }
            String str3 = locationLogMessage.permissions;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, str3);
            }
            protoWriter.writeBytes(locationLogMessage.unknownFields());
        }

        public int encodedSize(LocationLogMessage locationLogMessage) {
            Long l = locationLogMessage.time_stamp;
            int i = 0;
            int encodedSizeWithTag = l != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, l) : 0;
            String str = locationLogMessage.time_zone_id;
            int encodedSizeWithTag2 = encodedSizeWithTag + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, str) : 0);
            Integer num = locationLogMessage.time_zone_offset;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num) : 0);
            String str2 = locationLogMessage.provider;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, str2) : 0);
            Double d = locationLogMessage.latitude;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(5, d) : 0);
            Double d2 = locationLogMessage.longitude;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (d2 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(6, d2) : 0);
            Float f = locationLogMessage.accuracy;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(7, f) : 0);
            Double d3 = locationLogMessage.altitude;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (d3 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(8, d3) : 0);
            Float f2 = locationLogMessage.bearing;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(9, f2) : 0);
            Float f3 = locationLogMessage.speed;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(10, f3) : 0);
            Float f4 = locationLogMessage.indoorOutdoorWeight;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(11, f4) : 0);
            Float f5 = locationLogMessage.barometric;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(12, f5) : 0);
            String str3 = locationLogMessage.permissions;
            if (str3 != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(13, str3);
            }
            return locationLogMessage.unknownFields().size() + encodedSizeWithTag12 + i;
        }

        public LocationLogMessage redact(LocationLogMessage locationLogMessage) {
            Builder newBuilder = locationLogMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
        Float valueOf2 = Float.valueOf(0.0f);
        DEFAULT_ACCURACY = valueOf2;
        DEFAULT_ALTITUDE = valueOf;
        DEFAULT_BEARING = valueOf2;
        DEFAULT_SPEED = valueOf2;
        DEFAULT_INDOOROUTDOORWEIGHT = valueOf2;
        DEFAULT_BAROMETRIC = valueOf2;
    }

    public LocationLogMessage(Long l, String str, Integer num, String str2, Double d, Double d2, Float f, Double d3, Float f2, Float f3, Float f4, Float f5, String str3) {
        this(l, str, num, str2, d, d2, f, d3, f2, f3, f4, f5, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationLogMessage)) {
            return false;
        }
        LocationLogMessage locationLogMessage = (LocationLogMessage) obj;
        if (!unknownFields().equals(locationLogMessage.unknownFields()) || !Internal.equals(this.time_stamp, locationLogMessage.time_stamp) || !Internal.equals(this.time_zone_id, locationLogMessage.time_zone_id) || !Internal.equals(this.time_zone_offset, locationLogMessage.time_zone_offset) || !Internal.equals(this.provider, locationLogMessage.provider) || !Internal.equals(this.latitude, locationLogMessage.latitude) || !Internal.equals(this.longitude, locationLogMessage.longitude) || !Internal.equals(this.accuracy, locationLogMessage.accuracy) || !Internal.equals(this.altitude, locationLogMessage.altitude) || !Internal.equals(this.bearing, locationLogMessage.bearing) || !Internal.equals(this.speed, locationLogMessage.speed) || !Internal.equals(this.indoorOutdoorWeight, locationLogMessage.indoorOutdoorWeight) || !Internal.equals(this.barometric, locationLogMessage.barometric) || !Internal.equals(this.permissions, locationLogMessage.permissions)) {
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
        Long l = this.time_stamp;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.time_zone_id;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.time_zone_offset;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.provider;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Double d = this.latitude;
        int hashCode6 = (hashCode5 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.longitude;
        int hashCode7 = (hashCode6 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Float f = this.accuracy;
        int hashCode8 = (hashCode7 + (f != null ? f.hashCode() : 0)) * 37;
        Double d3 = this.altitude;
        int hashCode9 = (hashCode8 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Float f2 = this.bearing;
        int hashCode10 = (hashCode9 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.speed;
        int hashCode11 = (hashCode10 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.indoorOutdoorWeight;
        int hashCode12 = (hashCode11 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Float f5 = this.barometric;
        int hashCode13 = (hashCode12 + (f5 != null ? f5.hashCode() : 0)) * 37;
        String str3 = this.permissions;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.time_stamp != null) {
            sb.append(", time_stamp=");
            sb.append(this.time_stamp);
        }
        if (this.time_zone_id != null) {
            sb.append(", time_zone_id=");
            sb.append(this.time_zone_id);
        }
        if (this.time_zone_offset != null) {
            sb.append(", time_zone_offset=");
            sb.append(this.time_zone_offset);
        }
        if (this.provider != null) {
            sb.append(", provider=");
            sb.append(this.provider);
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
        if (this.altitude != null) {
            sb.append(", altitude=");
            sb.append(this.altitude);
        }
        if (this.bearing != null) {
            sb.append(", bearing=");
            sb.append(this.bearing);
        }
        if (this.speed != null) {
            sb.append(", speed=");
            sb.append(this.speed);
        }
        if (this.indoorOutdoorWeight != null) {
            sb.append(", indoorOutdoorWeight=");
            sb.append(this.indoorOutdoorWeight);
        }
        if (this.barometric != null) {
            sb.append(", barometric=");
            sb.append(this.barometric);
        }
        if (this.permissions != null) {
            sb.append(", permissions=");
            sb.append(this.permissions);
        }
        return c.a(sb, 0, 2, "LocationLogMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public LocationLogMessage(Long l, String str, Integer num, String str2, Double d, Double d2, Float f, Double d3, Float f2, Float f3, Float f4, Float f5, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.time_stamp = l;
        this.time_zone_id = str;
        this.time_zone_offset = num;
        this.provider = str2;
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = f;
        this.altitude = d3;
        this.bearing = f2;
        this.speed = f3;
        this.indoorOutdoorWeight = f4;
        this.barometric = f5;
        this.permissions = str3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.time_stamp = this.time_stamp;
        builder.time_zone_id = this.time_zone_id;
        builder.time_zone_offset = this.time_zone_offset;
        builder.provider = this.provider;
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.accuracy = this.accuracy;
        builder.altitude = this.altitude;
        builder.bearing = this.bearing;
        builder.speed = this.speed;
        builder.indoorOutdoorWeight = this.indoorOutdoorWeight;
        builder.barometric = this.barometric;
        builder.permissions = this.permissions;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
