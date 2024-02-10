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

public final class SyncDeviceResponseMessage extends Message<SyncDeviceResponseMessage, Builder> {
    public static final ProtoAdapter<SyncDeviceResponseMessage> ADAPTER = new ProtoAdapter_SyncDeviceResponseMessage();
    public static final Integer DEFAULT_DEVICE_ID = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer device_id;

    public static final class Builder extends Message.Builder<SyncDeviceResponseMessage, Builder> {
        public Integer device_id;

        public Builder device_id(Integer num) {
            this.device_id = num;
            return this;
        }

        public SyncDeviceResponseMessage build() {
            return new SyncDeviceResponseMessage(this.device_id, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SyncDeviceResponseMessage extends ProtoAdapter<SyncDeviceResponseMessage> {
        public ProtoAdapter_SyncDeviceResponseMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SyncDeviceResponseMessage.class);
        }

        public SyncDeviceResponseMessage decode(ProtoReader protoReader) {
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
                    builder.device_id(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SyncDeviceResponseMessage syncDeviceResponseMessage) {
            Integer num = syncDeviceResponseMessage.device_id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            protoWriter.writeBytes(syncDeviceResponseMessage.unknownFields());
        }

        public int encodedSize(SyncDeviceResponseMessage syncDeviceResponseMessage) {
            Integer num = syncDeviceResponseMessage.device_id;
            return syncDeviceResponseMessage.unknownFields().size() + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, num) : 0);
        }

        public SyncDeviceResponseMessage redact(SyncDeviceResponseMessage syncDeviceResponseMessage) {
            Builder newBuilder = syncDeviceResponseMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SyncDeviceResponseMessage(Integer num) {
        this(num, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SyncDeviceResponseMessage)) {
            return false;
        }
        SyncDeviceResponseMessage syncDeviceResponseMessage = (SyncDeviceResponseMessage) obj;
        if (!unknownFields().equals(syncDeviceResponseMessage.unknownFields()) || !Internal.equals(this.device_id, syncDeviceResponseMessage.device_id)) {
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
        Integer num = this.device_id;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.device_id != null) {
            sb.append(", device_id=");
            sb.append(this.device_id);
        }
        return c.a(sb, 0, 2, "SyncDeviceResponseMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public SyncDeviceResponseMessage(Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.device_id = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.device_id = this.device_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
