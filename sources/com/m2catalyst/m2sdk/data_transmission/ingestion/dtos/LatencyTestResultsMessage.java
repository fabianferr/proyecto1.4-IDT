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

public final class LatencyTestResultsMessage extends Message<LatencyTestResultsMessage, Builder> {
    public static final ProtoAdapter<LatencyTestResultsMessage> ADAPTER = new ProtoAdapter_LatencyTestResultsMessage();
    public static final Integer DEFAULT_ALGORITHM = 0;
    public static final Float DEFAULT_AVERAGE;
    public static final Float DEFAULT_DEVIATION;
    public static final Double DEFAULT_JITTER = Double.valueOf(0.0d);
    public static final Float DEFAULT_MAXIMUM;
    public static final Float DEFAULT_MINIMUM;
    public static final String DEFAULT_SERVERIP = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer algorithm;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 22)
    public final Float average;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 23)
    public final Float deviation;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 24)
    public final Double jitter;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 1)
    public final List<Double> latencyTimes;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 21)
    public final Float maximum;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 20)
    public final Float minimum;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String serverIP;

    public static final class Builder extends Message.Builder<LatencyTestResultsMessage, Builder> {
        public Integer algorithm;
        public Float average;
        public Float deviation;
        public Double jitter;
        public List<Double> latencyTimes = Internal.newMutableList();
        public Float maximum;
        public Float minimum;
        public String serverIP;

        public Builder algorithm(Integer num) {
            this.algorithm = num;
            return this;
        }

        public Builder average(Float f) {
            this.average = f;
            return this;
        }

        public Builder deviation(Float f) {
            this.deviation = f;
            return this;
        }

        public Builder jitter(Double d) {
            this.jitter = d;
            return this;
        }

        public Builder latencyTimes(List<Double> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.latencyTimes = list;
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

        public Builder serverIP(String str) {
            this.serverIP = str;
            return this;
        }

        public LatencyTestResultsMessage build() {
            return new LatencyTestResultsMessage(this.latencyTimes, this.minimum, this.maximum, this.average, this.deviation, this.jitter, this.serverIP, this.algorithm, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_LatencyTestResultsMessage extends ProtoAdapter<LatencyTestResultsMessage> {
        public ProtoAdapter_LatencyTestResultsMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LatencyTestResultsMessage.class);
        }

        public LatencyTestResultsMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    switch (nextTag) {
                        case 20:
                            builder.minimum(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 21:
                            builder.maximum(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 22:
                            builder.average(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 23:
                            builder.deviation(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 24:
                            builder.jitter(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 25:
                            builder.serverIP(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 26:
                            builder.algorithm(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.latencyTimes.add(ProtoAdapter.DOUBLE.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, LatencyTestResultsMessage latencyTestResultsMessage) {
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(protoWriter, 1, latencyTestResultsMessage.latencyTimes);
            Float f = latencyTestResultsMessage.minimum;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 20, f);
            }
            Float f2 = latencyTestResultsMessage.maximum;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 21, f2);
            }
            Float f3 = latencyTestResultsMessage.average;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 22, f3);
            }
            Float f4 = latencyTestResultsMessage.deviation;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 23, f4);
            }
            Double d = latencyTestResultsMessage.jitter;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 24, d);
            }
            String str = latencyTestResultsMessage.serverIP;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 25, str);
            }
            Integer num = latencyTestResultsMessage.algorithm;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num);
            }
            protoWriter.writeBytes(latencyTestResultsMessage.unknownFields());
        }

        public int encodedSize(LatencyTestResultsMessage latencyTestResultsMessage) {
            int encodedSizeWithTag = ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(1, latencyTestResultsMessage.latencyTimes);
            Float f = latencyTestResultsMessage.minimum;
            int i = 0;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(20, f) : 0);
            Float f2 = latencyTestResultsMessage.maximum;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(21, f2) : 0);
            Float f3 = latencyTestResultsMessage.average;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(22, f3) : 0);
            Float f4 = latencyTestResultsMessage.deviation;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(23, f4) : 0);
            Double d = latencyTestResultsMessage.jitter;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(24, d) : 0);
            String str = latencyTestResultsMessage.serverIP;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(25, str) : 0);
            Integer num = latencyTestResultsMessage.algorithm;
            if (num != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(26, num);
            }
            return latencyTestResultsMessage.unknownFields().size() + encodedSizeWithTag7 + i;
        }

        public LatencyTestResultsMessage redact(LatencyTestResultsMessage latencyTestResultsMessage) {
            Builder newBuilder = latencyTestResultsMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_MINIMUM = valueOf;
        DEFAULT_MAXIMUM = valueOf;
        DEFAULT_AVERAGE = valueOf;
        DEFAULT_DEVIATION = valueOf;
    }

    public LatencyTestResultsMessage(List<Double> list, Float f, Float f2, Float f3, Float f4, Double d, String str, Integer num) {
        this(list, f, f2, f3, f4, d, str, num, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LatencyTestResultsMessage)) {
            return false;
        }
        LatencyTestResultsMessage latencyTestResultsMessage = (LatencyTestResultsMessage) obj;
        if (!unknownFields().equals(latencyTestResultsMessage.unknownFields()) || !this.latencyTimes.equals(latencyTestResultsMessage.latencyTimes) || !Internal.equals(this.minimum, latencyTestResultsMessage.minimum) || !Internal.equals(this.maximum, latencyTestResultsMessage.maximum) || !Internal.equals(this.average, latencyTestResultsMessage.average) || !Internal.equals(this.deviation, latencyTestResultsMessage.deviation) || !Internal.equals(this.jitter, latencyTestResultsMessage.jitter) || !Internal.equals(this.serverIP, latencyTestResultsMessage.serverIP) || !Internal.equals(this.algorithm, latencyTestResultsMessage.algorithm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (this.latencyTimes.hashCode() + (unknownFields().hashCode() * 37)) * 37;
        Float f = this.minimum;
        int i2 = 0;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.maximum;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.average;
        int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.deviation;
        int hashCode5 = (hashCode4 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Double d = this.jitter;
        int hashCode6 = (hashCode5 + (d != null ? d.hashCode() : 0)) * 37;
        String str = this.serverIP;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.algorithm;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.latencyTimes.isEmpty()) {
            sb.append(", latencyTimes=");
            sb.append(this.latencyTimes);
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
        if (this.deviation != null) {
            sb.append(", deviation=");
            sb.append(this.deviation);
        }
        if (this.jitter != null) {
            sb.append(", jitter=");
            sb.append(this.jitter);
        }
        if (this.serverIP != null) {
            sb.append(", serverIP=");
            sb.append(this.serverIP);
        }
        if (this.algorithm != null) {
            sb.append(", algorithm=");
            sb.append(this.algorithm);
        }
        return c.a(sb, 0, 2, "LatencyTestResultsMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public LatencyTestResultsMessage(List<Double> list, Float f, Float f2, Float f3, Float f4, Double d, String str, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.latencyTimes = Internal.immutableCopyOf("latencyTimes", list);
        this.minimum = f;
        this.maximum = f2;
        this.average = f3;
        this.deviation = f4;
        this.jitter = d;
        this.serverIP = str;
        this.algorithm = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.latencyTimes = Internal.copyOf("latencyTimes", this.latencyTimes);
        builder.minimum = this.minimum;
        builder.maximum = this.maximum;
        builder.average = this.average;
        builder.deviation = this.deviation;
        builder.jitter = this.jitter;
        builder.serverIP = this.serverIP;
        builder.algorithm = this.algorithm;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
