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

public final class LocationInfoResponseMessage extends Message<LocationInfoResponseMessage, Builder> {
    public static final ProtoAdapter<LocationInfoResponseMessage> ADAPTER = new ProtoAdapter_LocationInfoResponseMessage();
    public static final Integer DEFAULT_LOCATION_LOGS_ACCEPTED = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer location_logs_accepted;

    public static final class Builder extends Message.Builder<LocationInfoResponseMessage, Builder> {
        public Integer location_logs_accepted;

        public Builder location_logs_accepted(Integer num) {
            this.location_logs_accepted = num;
            return this;
        }

        public LocationInfoResponseMessage build() {
            return new LocationInfoResponseMessage(this.location_logs_accepted, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_LocationInfoResponseMessage extends ProtoAdapter<LocationInfoResponseMessage> {
        public ProtoAdapter_LocationInfoResponseMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LocationInfoResponseMessage.class);
        }

        public LocationInfoResponseMessage decode(ProtoReader protoReader) {
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
                    builder.location_logs_accepted(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, LocationInfoResponseMessage locationInfoResponseMessage) {
            Integer num = locationInfoResponseMessage.location_logs_accepted;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            protoWriter.writeBytes(locationInfoResponseMessage.unknownFields());
        }

        public int encodedSize(LocationInfoResponseMessage locationInfoResponseMessage) {
            Integer num = locationInfoResponseMessage.location_logs_accepted;
            return locationInfoResponseMessage.unknownFields().size() + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, num) : 0);
        }

        public LocationInfoResponseMessage redact(LocationInfoResponseMessage locationInfoResponseMessage) {
            Builder newBuilder = locationInfoResponseMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LocationInfoResponseMessage(Integer num) {
        this(num, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfoResponseMessage)) {
            return false;
        }
        LocationInfoResponseMessage locationInfoResponseMessage = (LocationInfoResponseMessage) obj;
        if (!unknownFields().equals(locationInfoResponseMessage.unknownFields()) || !Internal.equals(this.location_logs_accepted, locationInfoResponseMessage.location_logs_accepted)) {
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
        Integer num = this.location_logs_accepted;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.location_logs_accepted != null) {
            sb.append(", location_logs_accepted=");
            sb.append(this.location_logs_accepted);
        }
        return c.a(sb, 0, 2, "LocationInfoResponseMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public LocationInfoResponseMessage(Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.location_logs_accepted = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.location_logs_accepted = this.location_logs_accepted;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
