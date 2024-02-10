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

public final class DeviceBatteryLogsResponseMessage extends Message<DeviceBatteryLogsResponseMessage, Builder> {
    public static final ProtoAdapter<DeviceBatteryLogsResponseMessage> ADAPTER = new ProtoAdapter_DeviceBatteryLogsResponseMessage();
    public static final Integer DEFAULT_DEVICE_BATTERY_LOGS_ACCEPTED = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer device_battery_logs_accepted;

    public static final class Builder extends Message.Builder<DeviceBatteryLogsResponseMessage, Builder> {
        public Integer device_battery_logs_accepted;

        public Builder device_battery_logs_accepted(Integer num) {
            this.device_battery_logs_accepted = num;
            return this;
        }

        public DeviceBatteryLogsResponseMessage build() {
            return new DeviceBatteryLogsResponseMessage(this.device_battery_logs_accepted, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_DeviceBatteryLogsResponseMessage extends ProtoAdapter<DeviceBatteryLogsResponseMessage> {
        public ProtoAdapter_DeviceBatteryLogsResponseMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DeviceBatteryLogsResponseMessage.class);
        }

        public DeviceBatteryLogsResponseMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.device_battery_logs_accepted(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage) {
            Integer num = deviceBatteryLogsResponseMessage.device_battery_logs_accepted;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            protoWriter.writeBytes(deviceBatteryLogsResponseMessage.unknownFields());
        }

        public int encodedSize(DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage) {
            Integer num = deviceBatteryLogsResponseMessage.device_battery_logs_accepted;
            return deviceBatteryLogsResponseMessage.unknownFields().size() + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, num) : 0);
        }

        public DeviceBatteryLogsResponseMessage redact(DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage) {
            Builder newBuilder = deviceBatteryLogsResponseMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DeviceBatteryLogsResponseMessage(Integer num) {
        this(num, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceBatteryLogsResponseMessage)) {
            return false;
        }
        DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage = (DeviceBatteryLogsResponseMessage) obj;
        if (!unknownFields().equals(deviceBatteryLogsResponseMessage.unknownFields()) || !Internal.equals(this.device_battery_logs_accepted, deviceBatteryLogsResponseMessage.device_battery_logs_accepted)) {
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
        Integer num = this.device_battery_logs_accepted;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.device_battery_logs_accepted != null) {
            sb.append(", device_battery_logs_accepted=");
            sb.append(this.device_battery_logs_accepted);
        }
        return c.a(sb, 0, 2, "DeviceBatteryLogsResponseMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public DeviceBatteryLogsResponseMessage(Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.device_battery_logs_accepted = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.device_battery_logs_accepted = this.device_battery_logs_accepted;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
