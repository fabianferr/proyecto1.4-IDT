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

public final class LocationInfoMessage extends Message<LocationInfoMessage, Builder> {
    public static final ProtoAdapter<LocationInfoMessage> ADAPTER = new ProtoAdapter_LocationInfoMessage();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationLogMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<LocationLogMessage> location_logs;

    public static final class Builder extends Message.Builder<LocationInfoMessage, Builder> {
        public List<LocationLogMessage> location_logs = Internal.newMutableList();

        public Builder location_logs(List<LocationLogMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.location_logs = list;
            return this;
        }

        public LocationInfoMessage build() {
            return new LocationInfoMessage(this.location_logs, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_LocationInfoMessage extends ProtoAdapter<LocationInfoMessage> {
        public ProtoAdapter_LocationInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LocationInfoMessage.class);
        }

        public LocationInfoMessage decode(ProtoReader protoReader) {
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
                    builder.location_logs.add(LocationLogMessage.ADAPTER.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, LocationInfoMessage locationInfoMessage) {
            LocationLogMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, locationInfoMessage.location_logs);
            protoWriter.writeBytes(locationInfoMessage.unknownFields());
        }

        public int encodedSize(LocationInfoMessage locationInfoMessage) {
            return locationInfoMessage.unknownFields().size() + LocationLogMessage.ADAPTER.asRepeated().encodedSizeWithTag(1, locationInfoMessage.location_logs);
        }

        public LocationInfoMessage redact(LocationInfoMessage locationInfoMessage) {
            Builder newBuilder = locationInfoMessage.newBuilder();
            Internal.redactElements(newBuilder.location_logs, LocationLogMessage.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LocationInfoMessage(List<LocationLogMessage> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfoMessage)) {
            return false;
        }
        LocationInfoMessage locationInfoMessage = (LocationInfoMessage) obj;
        if (!unknownFields().equals(locationInfoMessage.unknownFields()) || !this.location_logs.equals(locationInfoMessage.location_logs)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (unknownFields().hashCode() * 37) + this.location_logs.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.location_logs.isEmpty()) {
            sb.append(", location_logs=");
            sb.append(this.location_logs);
        }
        return c.a(sb, 0, 2, "LocationInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public LocationInfoMessage(List<LocationLogMessage> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.location_logs = Internal.immutableCopyOf("location_logs", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.location_logs = Internal.copyOf("location_logs", this.location_logs);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
