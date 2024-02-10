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

public final class VerifyApiKeyResponseMessage extends Message<VerifyApiKeyResponseMessage, Builder> {
    public static final ProtoAdapter<VerifyApiKeyResponseMessage> ADAPTER = new ProtoAdapter_VerifyApiKeyResponseMessage();
    public static final Integer DEFAULT_COMPANY_ID = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer company_id;

    public static final class Builder extends Message.Builder<VerifyApiKeyResponseMessage, Builder> {
        public Integer company_id;

        public Builder company_id(Integer num) {
            this.company_id = num;
            return this;
        }

        public VerifyApiKeyResponseMessage build() {
            return new VerifyApiKeyResponseMessage(this.company_id, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_VerifyApiKeyResponseMessage extends ProtoAdapter<VerifyApiKeyResponseMessage> {
        public ProtoAdapter_VerifyApiKeyResponseMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VerifyApiKeyResponseMessage.class);
        }

        public VerifyApiKeyResponseMessage decode(ProtoReader protoReader) {
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
                    builder.company_id(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, VerifyApiKeyResponseMessage verifyApiKeyResponseMessage) {
            Integer num = verifyApiKeyResponseMessage.company_id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            protoWriter.writeBytes(verifyApiKeyResponseMessage.unknownFields());
        }

        public int encodedSize(VerifyApiKeyResponseMessage verifyApiKeyResponseMessage) {
            Integer num = verifyApiKeyResponseMessage.company_id;
            return verifyApiKeyResponseMessage.unknownFields().size() + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, num) : 0);
        }

        public VerifyApiKeyResponseMessage redact(VerifyApiKeyResponseMessage verifyApiKeyResponseMessage) {
            Builder newBuilder = verifyApiKeyResponseMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VerifyApiKeyResponseMessage(Integer num) {
        this(num, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VerifyApiKeyResponseMessage)) {
            return false;
        }
        VerifyApiKeyResponseMessage verifyApiKeyResponseMessage = (VerifyApiKeyResponseMessage) obj;
        if (!unknownFields().equals(verifyApiKeyResponseMessage.unknownFields()) || !Internal.equals(this.company_id, verifyApiKeyResponseMessage.company_id)) {
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
        Integer num = this.company_id;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.company_id != null) {
            sb.append(", company_id=");
            sb.append(this.company_id);
        }
        return c.a(sb, 0, 2, "VerifyApiKeyResponseMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public VerifyApiKeyResponseMessage(Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.company_id = num;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.company_id = this.company_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
