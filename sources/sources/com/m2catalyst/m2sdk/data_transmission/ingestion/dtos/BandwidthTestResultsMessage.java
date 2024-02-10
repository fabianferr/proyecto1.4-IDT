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

public final class BandwidthTestResultsMessage extends Message<BandwidthTestResultsMessage, Builder> {
    public static final ProtoAdapter<BandwidthTestResultsMessage> ADAPTER = new ProtoAdapter_BandwidthTestResultsMessage();
    public static final Integer DEFAULT_ALGORITHM = 0;
    public static final Float DEFAULT_AVERAGE;
    public static final Long DEFAULT_DATASIZE = 0L;
    public static final Float DEFAULT_MAXIMUM;
    public static final Float DEFAULT_MINIMUM;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    public final Integer algorithm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 24)
    public final Float average;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 25)
    public final Long dataSize;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 23)
    public final Float maximum;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 22)
    public final Float minimum;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer type;

    public static final class Builder extends Message.Builder<BandwidthTestResultsMessage, Builder> {
        public Integer algorithm;
        public Float average;
        public Long dataSize;
        public Float maximum;
        public Float minimum;
        public Integer type;

        public Builder algorithm(Integer num) {
            this.algorithm = num;
            return this;
        }

        public Builder average(Float f) {
            this.average = f;
            return this;
        }

        public Builder dataSize(Long l) {
            this.dataSize = l;
            return this;
        }

        public Builder maximum(Float f) {
            this.maximum = f;
            return this;
        }

        public Builder minimum(Float f) {
            this.minimum = f;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public BandwidthTestResultsMessage build() {
            return new BandwidthTestResultsMessage(this.type, this.algorithm, this.minimum, this.maximum, this.average, this.dataSize, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_BandwidthTestResultsMessage extends ProtoAdapter<BandwidthTestResultsMessage> {
        public ProtoAdapter_BandwidthTestResultsMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) BandwidthTestResultsMessage.class);
        }

        public BandwidthTestResultsMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 20:
                            builder.type(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 21:
                            builder.algorithm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 22:
                            builder.minimum(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 23:
                            builder.maximum(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 24:
                            builder.average(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 25:
                            builder.dataSize(ProtoAdapter.INT64.decode(protoReader));
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

        public void encode(ProtoWriter protoWriter, BandwidthTestResultsMessage bandwidthTestResultsMessage) {
            Integer num = bandwidthTestResultsMessage.type;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 20, num);
            }
            Integer num2 = bandwidthTestResultsMessage.algorithm;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 21, num2);
            }
            Float f = bandwidthTestResultsMessage.minimum;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 22, f);
            }
            Float f2 = bandwidthTestResultsMessage.maximum;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 23, f2);
            }
            Float f3 = bandwidthTestResultsMessage.average;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 24, f3);
            }
            Long l = bandwidthTestResultsMessage.dataSize;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 25, l);
            }
            protoWriter.writeBytes(bandwidthTestResultsMessage.unknownFields());
        }

        public int encodedSize(BandwidthTestResultsMessage bandwidthTestResultsMessage) {
            Integer num = bandwidthTestResultsMessage.type;
            int i = 0;
            int encodedSizeWithTag = num != null ? ProtoAdapter.INT32.encodedSizeWithTag(20, num) : 0;
            Integer num2 = bandwidthTestResultsMessage.algorithm;
            int encodedSizeWithTag2 = encodedSizeWithTag + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(21, num2) : 0);
            Float f = bandwidthTestResultsMessage.minimum;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(22, f) : 0);
            Float f2 = bandwidthTestResultsMessage.maximum;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(23, f2) : 0);
            Float f3 = bandwidthTestResultsMessage.average;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(24, f3) : 0);
            Long l = bandwidthTestResultsMessage.dataSize;
            if (l != null) {
                i = ProtoAdapter.INT64.encodedSizeWithTag(25, l);
            }
            return bandwidthTestResultsMessage.unknownFields().size() + encodedSizeWithTag5 + i;
        }

        public BandwidthTestResultsMessage redact(BandwidthTestResultsMessage bandwidthTestResultsMessage) {
            Builder newBuilder = bandwidthTestResultsMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_MINIMUM = valueOf;
        DEFAULT_MAXIMUM = valueOf;
        DEFAULT_AVERAGE = valueOf;
    }

    public BandwidthTestResultsMessage(Integer num, Integer num2, Float f, Float f2, Float f3, Long l) {
        this(num, num2, f, f2, f3, l, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BandwidthTestResultsMessage)) {
            return false;
        }
        BandwidthTestResultsMessage bandwidthTestResultsMessage = (BandwidthTestResultsMessage) obj;
        if (!unknownFields().equals(bandwidthTestResultsMessage.unknownFields()) || !Internal.equals(this.type, bandwidthTestResultsMessage.type) || !Internal.equals(this.algorithm, bandwidthTestResultsMessage.algorithm) || !Internal.equals(this.minimum, bandwidthTestResultsMessage.minimum) || !Internal.equals(this.maximum, bandwidthTestResultsMessage.maximum) || !Internal.equals(this.average, bandwidthTestResultsMessage.average) || !Internal.equals(this.dataSize, bandwidthTestResultsMessage.dataSize)) {
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
        Integer num = this.type;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.algorithm;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Float f = this.minimum;
        int hashCode4 = (hashCode3 + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.maximum;
        int hashCode5 = (hashCode4 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.average;
        int hashCode6 = (hashCode5 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Long l = this.dataSize;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.algorithm != null) {
            sb.append(", algorithm=");
            sb.append(this.algorithm);
        }
        if (this.minimum != null) {
            sb.append(", minimum=");
            sb.append(this.minimum);
        }
        if (this.maximum != null) {
            sb.append(", maximum=");
            sb.append(this.maximum);
        }
        if (this.average != null) {
            sb.append(", average=");
            sb.append(this.average);
        }
        if (this.dataSize != null) {
            sb.append(", dataSize=");
            sb.append(this.dataSize);
        }
        return c.a(sb, 0, 2, "BandwidthTestResultsMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public BandwidthTestResultsMessage(Integer num, Integer num2, Float f, Float f2, Float f3, Long l, ByteString byteString) {
        super(ADAPTER, byteString);
        this.type = num;
        this.algorithm = num2;
        this.minimum = f;
        this.maximum = f2;
        this.average = f3;
        this.dataSize = l;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.algorithm = this.algorithm;
        builder.minimum = this.minimum;
        builder.maximum = this.maximum;
        builder.average = this.average;
        builder.dataSize = this.dataSize;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
