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

public final class DeviceBatteryLogMessage extends Message<DeviceBatteryLogMessage, Builder> {
    public static final ProtoAdapter<DeviceBatteryLogMessage> ADAPTER = new ProtoAdapter_DeviceBatteryLogMessage();
    public static final Float DEFAULT_BATTERY_PERCENTAGE = Float.valueOf(0.0f);
    public static final Double DEFAULT_CHARGE_RATE;
    public static final Integer DEFAULT_CHARGING_OR_DRAINING = 0;
    public static final Double DEFAULT_DELTA_TIME;
    public static final Double DEFAULT_DRAIN_RATE;
    public static final Integer DEFAULT_TEMPERATURE = 0;
    public static final Long DEFAULT_TIME_STAMP = 0L;
    public static final Integer DEFAULT_VOLTAGE = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float battery_percentage;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double charge_rate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer charging_or_draining;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    public final Double delta_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double drain_rate;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer temperature;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long time_stamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer voltage;

    public static final class Builder extends Message.Builder<DeviceBatteryLogMessage, Builder> {
        public Float battery_percentage;
        public Double charge_rate;
        public Integer charging_or_draining;
        public Double delta_time;
        public Double drain_rate;
        public Integer temperature;
        public Long time_stamp;
        public Integer voltage;

        public Builder battery_percentage(Float f) {
            this.battery_percentage = f;
            return this;
        }

        public Builder charge_rate(Double d) {
            this.charge_rate = d;
            return this;
        }

        public Builder charging_or_draining(Integer num) {
            this.charging_or_draining = num;
            return this;
        }

        public Builder delta_time(Double d) {
            this.delta_time = d;
            return this;
        }

        public Builder drain_rate(Double d) {
            this.drain_rate = d;
            return this;
        }

        public Builder temperature(Integer num) {
            this.temperature = num;
            return this;
        }

        public Builder time_stamp(Long l) {
            this.time_stamp = l;
            return this;
        }

        public Builder voltage(Integer num) {
            this.voltage = num;
            return this;
        }

        public DeviceBatteryLogMessage build() {
            return new DeviceBatteryLogMessage(this.charge_rate, this.drain_rate, this.delta_time, this.time_stamp, this.charging_or_draining, this.battery_percentage, this.temperature, this.voltage, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_DeviceBatteryLogMessage extends ProtoAdapter<DeviceBatteryLogMessage> {
        public ProtoAdapter_DeviceBatteryLogMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DeviceBatteryLogMessage.class);
        }

        public DeviceBatteryLogMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.charge_rate(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 2:
                            builder.drain_rate(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 3:
                            builder.delta_time(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 4:
                            builder.time_stamp(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 5:
                            builder.charging_or_draining(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 6:
                            builder.battery_percentage(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 7:
                            builder.temperature(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 8:
                            builder.voltage(ProtoAdapter.INT32.decode(protoReader));
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

        public void encode(ProtoWriter protoWriter, DeviceBatteryLogMessage deviceBatteryLogMessage) {
            Double d = deviceBatteryLogMessage.charge_rate;
            if (d != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 1, d);
            }
            Double d2 = deviceBatteryLogMessage.drain_rate;
            if (d2 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 2, d2);
            }
            Double d3 = deviceBatteryLogMessage.delta_time;
            if (d3 != null) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 3, d3);
            }
            Long l = deviceBatteryLogMessage.time_stamp;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, l);
            }
            Integer num = deviceBatteryLogMessage.charging_or_draining;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, num);
            }
            Float f = deviceBatteryLogMessage.battery_percentage;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, f);
            }
            Integer num2 = deviceBatteryLogMessage.temperature;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, num2);
            }
            Integer num3 = deviceBatteryLogMessage.voltage;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 8, num3);
            }
            protoWriter.writeBytes(deviceBatteryLogMessage.unknownFields());
        }

        public int encodedSize(DeviceBatteryLogMessage deviceBatteryLogMessage) {
            Double d = deviceBatteryLogMessage.charge_rate;
            int i = 0;
            int encodedSizeWithTag = d != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(1, d) : 0;
            Double d2 = deviceBatteryLogMessage.drain_rate;
            int encodedSizeWithTag2 = encodedSizeWithTag + (d2 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(2, d2) : 0);
            Double d3 = deviceBatteryLogMessage.delta_time;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (d3 != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(3, d3) : 0);
            Long l = deviceBatteryLogMessage.time_stamp;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(4, l) : 0);
            Integer num = deviceBatteryLogMessage.charging_or_draining;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, num) : 0);
            Float f = deviceBatteryLogMessage.battery_percentage;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f) : 0);
            Integer num2 = deviceBatteryLogMessage.temperature;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, num2) : 0);
            Integer num3 = deviceBatteryLogMessage.voltage;
            if (num3 != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(8, num3);
            }
            return deviceBatteryLogMessage.unknownFields().size() + encodedSizeWithTag7 + i;
        }

        public DeviceBatteryLogMessage redact(DeviceBatteryLogMessage deviceBatteryLogMessage) {
            Builder newBuilder = deviceBatteryLogMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_CHARGE_RATE = valueOf;
        DEFAULT_DRAIN_RATE = valueOf;
        DEFAULT_DELTA_TIME = valueOf;
    }

    public DeviceBatteryLogMessage(Double d, Double d2, Double d3, Long l, Integer num, Float f, Integer num2, Integer num3) {
        this(d, d2, d3, l, num, f, num2, num3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceBatteryLogMessage)) {
            return false;
        }
        DeviceBatteryLogMessage deviceBatteryLogMessage = (DeviceBatteryLogMessage) obj;
        if (!unknownFields().equals(deviceBatteryLogMessage.unknownFields()) || !Internal.equals(this.charge_rate, deviceBatteryLogMessage.charge_rate) || !Internal.equals(this.drain_rate, deviceBatteryLogMessage.drain_rate) || !Internal.equals(this.delta_time, deviceBatteryLogMessage.delta_time) || !Internal.equals(this.time_stamp, deviceBatteryLogMessage.time_stamp) || !Internal.equals(this.charging_or_draining, deviceBatteryLogMessage.charging_or_draining) || !Internal.equals(this.battery_percentage, deviceBatteryLogMessage.battery_percentage) || !Internal.equals(this.temperature, deviceBatteryLogMessage.temperature) || !Internal.equals(this.voltage, deviceBatteryLogMessage.voltage)) {
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
        Double d = this.charge_rate;
        int i2 = 0;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.drain_rate;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.delta_time;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l = this.time_stamp;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.charging_or_draining;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Float f = this.battery_percentage;
        int hashCode7 = (hashCode6 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num2 = this.temperature;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.voltage;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.charge_rate != null) {
            sb.append(", charge_rate=");
            sb.append(this.charge_rate);
        }
        if (this.drain_rate != null) {
            sb.append(", drain_rate=");
            sb.append(this.drain_rate);
        }
        if (this.delta_time != null) {
            sb.append(", delta_time=");
            sb.append(this.delta_time);
        }
        if (this.time_stamp != null) {
            sb.append(", time_stamp=");
            sb.append(this.time_stamp);
        }
        if (this.charging_or_draining != null) {
            sb.append(", charging_or_draining=");
            sb.append(this.charging_or_draining);
        }
        if (this.battery_percentage != null) {
            sb.append(", battery_percentage=");
            sb.append(this.battery_percentage);
        }
        if (this.temperature != null) {
            sb.append(", temperature=");
            sb.append(this.temperature);
        }
        if (this.voltage != null) {
            sb.append(", voltage=");
            sb.append(this.voltage);
        }
        return c.a(sb, 0, 2, "DeviceBatteryLogMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public DeviceBatteryLogMessage(Double d, Double d2, Double d3, Long l, Integer num, Float f, Integer num2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.charge_rate = d;
        this.drain_rate = d2;
        this.delta_time = d3;
        this.time_stamp = l;
        this.charging_or_draining = num;
        this.battery_percentage = f;
        this.temperature = num2;
        this.voltage = num3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.charge_rate = this.charge_rate;
        builder.drain_rate = this.drain_rate;
        builder.delta_time = this.delta_time;
        builder.time_stamp = this.time_stamp;
        builder.charging_or_draining = this.charging_or_draining;
        builder.battery_percentage = this.battery_percentage;
        builder.temperature = this.temperature;
        builder.voltage = this.voltage;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
