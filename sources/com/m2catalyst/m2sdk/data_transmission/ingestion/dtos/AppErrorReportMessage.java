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

public final class AppErrorReportMessage extends Message<AppErrorReportMessage, Builder> {
    public static final ProtoAdapter<AppErrorReportMessage> ADAPTER = new ProtoAdapter_AppErrorReportMessage();
    public static final Long DEFAULT_DATE = 0L;
    public static final String DEFAULT_STACK_TRACE = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long date;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String stack_trace;

    public static final class Builder extends Message.Builder<AppErrorReportMessage, Builder> {
        public Long date;
        public String stack_trace;

        public Builder date(Long l) {
            this.date = l;
            return this;
        }

        public Builder stack_trace(String str) {
            this.stack_trace = str;
            return this;
        }

        public AppErrorReportMessage build() {
            return new AppErrorReportMessage(this.date, this.stack_trace, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_AppErrorReportMessage extends ProtoAdapter<AppErrorReportMessage> {
        public ProtoAdapter_AppErrorReportMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AppErrorReportMessage.class);
        }

        public AppErrorReportMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.date(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.stack_trace(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, AppErrorReportMessage appErrorReportMessage) {
            Long l = appErrorReportMessage.date;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, l);
            }
            String str = appErrorReportMessage.stack_trace;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str);
            }
            protoWriter.writeBytes(appErrorReportMessage.unknownFields());
        }

        public int encodedSize(AppErrorReportMessage appErrorReportMessage) {
            Long l = appErrorReportMessage.date;
            int i = 0;
            int encodedSizeWithTag = l != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, l) : 0;
            String str = appErrorReportMessage.stack_trace;
            if (str != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, str);
            }
            return appErrorReportMessage.unknownFields().size() + encodedSizeWithTag + i;
        }

        public AppErrorReportMessage redact(AppErrorReportMessage appErrorReportMessage) {
            Builder newBuilder = appErrorReportMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AppErrorReportMessage(Long l, String str) {
        this(l, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppErrorReportMessage)) {
            return false;
        }
        AppErrorReportMessage appErrorReportMessage = (AppErrorReportMessage) obj;
        if (!unknownFields().equals(appErrorReportMessage.unknownFields()) || !Internal.equals(this.date, appErrorReportMessage.date) || !Internal.equals(this.stack_trace, appErrorReportMessage.stack_trace)) {
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
        Long l = this.date;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.stack_trace;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.date != null) {
            sb.append(", date=");
            sb.append(this.date);
        }
        if (this.stack_trace != null) {
            sb.append(", stack_trace=");
            sb.append(this.stack_trace);
        }
        return c.a(sb, 0, 2, "AppErrorReportMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public AppErrorReportMessage(Long l, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.date = l;
        this.stack_trace = str;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.date = this.date;
        builder.stack_trace = this.stack_trace;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
