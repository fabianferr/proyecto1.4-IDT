package com.squareup.wire;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0017J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u001f\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/squareup/wire/AnyMessage;", "Lcom/squareup/wire/Message;", "", "typeUrl", "", "value", "Lokio/ByteString;", "(Ljava/lang/String;Lokio/ByteString;)V", "getTypeUrl", "()Ljava/lang/String;", "getValue", "()Lokio/ByteString;", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "unpack", "T", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "(Lcom/squareup/wire/ProtoAdapter;)Ljava/lang/Object;", "unpackOrNull", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnyMessage.kt */
public final class AnyMessage extends Message {
    public static final ProtoAdapter<AnyMessage> ADAPTER = new AnyMessage$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnyMessage.class), Syntax.PROTO_3);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String typeUrl;
    private final ByteString value;

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnyMessage(String str, ByteString byteString, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ByteString.EMPTY : byteString);
    }

    public final ByteString getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnyMessage(String str, ByteString byteString) {
        super(ADAPTER, ByteString.EMPTY);
        Intrinsics.checkNotNullParameter(str, "typeUrl");
        Intrinsics.checkNotNullParameter(byteString, "value");
        this.typeUrl = str;
        this.value = byteString;
    }

    public final <T> T unpack(ProtoAdapter<T> protoAdapter) {
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        if (Intrinsics.areEqual((Object) this.typeUrl, (Object) protoAdapter.getTypeUrl())) {
            return protoAdapter.decode(this.value);
        }
        throw new IllegalStateException(("type mismatch: " + getTypeUrl() + " != " + protoAdapter.getTypeUrl()).toString());
    }

    public final <T> T unpackOrNull(ProtoAdapter<T> protoAdapter) {
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        if (Intrinsics.areEqual((Object) this.typeUrl, (Object) protoAdapter.getTypeUrl())) {
            return protoAdapter.decode(this.value);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnyMessage)) {
            return false;
        }
        AnyMessage anyMessage = (AnyMessage) obj;
        if (!Intrinsics.areEqual((Object) this.typeUrl, (Object) anyMessage.typeUrl) || !Intrinsics.areEqual((Object) this.value, (Object) anyMessage.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((i * 37) + this.typeUrl.hashCode()) * 37) + this.value.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        return "Any{type_url=" + this.typeUrl + ", value=" + this.value + AbstractJsonLexerKt.END_OBJ;
    }

    public static /* synthetic */ AnyMessage copy$default(AnyMessage anyMessage, String str, ByteString byteString, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anyMessage.typeUrl;
        }
        if ((i & 2) != 0) {
            byteString = anyMessage.value;
        }
        return anyMessage.copy(str, byteString);
    }

    public final AnyMessage copy(String str, ByteString byteString) {
        Intrinsics.checkNotNullParameter(str, "typeUrl");
        Intrinsics.checkNotNullParameter(byteString, "value");
        return new AnyMessage(str, byteString);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/squareup/wire/AnyMessage$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/AnyMessage;", "pack", "message", "Lcom/squareup/wire/Message;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnyMessage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnyMessage pack(Message<?, ?> message) {
            Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            String typeUrl = message.adapter().getTypeUrl();
            if (typeUrl != null) {
                return new AnyMessage(typeUrl, message.encodeByteString());
            }
            throw new IllegalStateException(("recompile " + Reflection.getOrCreateKotlinClass(message.getClass()) + " to use it with AnyMessage").toString());
        }
    }
}
