package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 $*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0002#$B\u001d\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\bJ\r\u0010\u001b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000b\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0004R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\f8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012¨\u0006%"}, d2 = {"Lcom/squareup/wire/Message;", "M", "B", "Lcom/squareup/wire/Message$Builder;", "Ljava/io/Serializable;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)V", "()Lcom/squareup/wire/ProtoAdapter;", "cachedSerializedSize", "", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "hashCode", "()Lokio/ByteString;", "encode", "", "", "stream", "Ljava/io/OutputStream;", "sink", "Lokio/BufferedSink;", "encodeByteString", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "toString", "", "withoutUnknownFields", "()Lcom/squareup/wire/Message;", "writeReplace", "", "Builder", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Message.kt */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    private transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient ByteString unknownFields;

    public abstract B newBuilder();

    protected Message(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        Intrinsics.checkNotNullParameter(byteString, "unknownFields");
        this.adapter = protoAdapter;
        this.unknownFields = byteString;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        return byteString == null ? ByteString.EMPTY : byteString;
    }

    public final int getCachedSerializedSize$wire_runtime() {
        return this.cachedSerializedSize;
    }

    public final void setCachedSerializedSize$wire_runtime(int i) {
        this.cachedSerializedSize = i;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        Message message = this;
        return this.adapter.toString(this);
    }

    /* access modifiers changed from: protected */
    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final void encode(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        Message message = this;
        this.adapter.encode(bufferedSink, this);
    }

    public final byte[] encode() {
        Message message = this;
        return this.adapter.encode(this);
    }

    public final ByteString encodeByteString() {
        Message message = this;
        return this.adapter.encodeByteString(this);
    }

    public final void encode(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        Message message = this;
        this.adapter.encode(outputStream, this);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0014\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u00020\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0005J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\u001f\u001a\u00020\rJ\r\u0010 \u001a\u00028\u0002H&¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\rJ\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000J\b\u0010$\u001a\u00020%H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/squareup/wire/Message$Builder;", "M", "Lcom/squareup/wire/Message;", "B", "", "()V", "unknownFieldsBuffer", "Lokio/Buffer;", "getUnknownFieldsBuffer$wire_runtime", "()Lokio/Buffer;", "setUnknownFieldsBuffer$wire_runtime", "(Lokio/Buffer;)V", "unknownFieldsByteString", "Lokio/ByteString;", "getUnknownFieldsByteString$wire_runtime", "()Lokio/ByteString;", "setUnknownFieldsByteString$wire_runtime", "(Lokio/ByteString;)V", "unknownFieldsWriter", "Lcom/squareup/wire/ProtoWriter;", "getUnknownFieldsWriter$wire_runtime", "()Lcom/squareup/wire/ProtoWriter;", "setUnknownFieldsWriter$wire_runtime", "(Lcom/squareup/wire/ProtoWriter;)V", "addUnknownField", "tag", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "value", "addUnknownFields", "unknownFields", "build", "()Lcom/squareup/wire/Message;", "buildUnknownFields", "clearUnknownFields", "prepareForNewUnknownFields", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        private transient Buffer unknownFieldsBuffer;
        private transient ByteString unknownFieldsByteString = ByteString.EMPTY;
        private transient ProtoWriter unknownFieldsWriter;

        public abstract M build();

        protected Builder() {
        }

        public final ByteString getUnknownFieldsByteString$wire_runtime() {
            return this.unknownFieldsByteString;
        }

        public final void setUnknownFieldsByteString$wire_runtime(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "<set-?>");
            this.unknownFieldsByteString = byteString;
        }

        public final Buffer getUnknownFieldsBuffer$wire_runtime() {
            return this.unknownFieldsBuffer;
        }

        public final void setUnknownFieldsBuffer$wire_runtime(Buffer buffer) {
            this.unknownFieldsBuffer = buffer;
        }

        public final ProtoWriter getUnknownFieldsWriter$wire_runtime() {
            return this.unknownFieldsWriter;
        }

        public final void setUnknownFieldsWriter$wire_runtime(ProtoWriter protoWriter) {
            this.unknownFieldsWriter = protoWriter;
        }

        public final Builder<M, B> addUnknownFields(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "unknownFields");
            Builder builder = this;
            if (byteString.size() > 0) {
                prepareForNewUnknownFields();
                ProtoWriter unknownFieldsWriter$wire_runtime = getUnknownFieldsWriter$wire_runtime();
                Intrinsics.checkNotNull(unknownFieldsWriter$wire_runtime);
                unknownFieldsWriter$wire_runtime.writeBytes(byteString);
            }
            return this;
        }

        public final Builder<M, B> addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
            Builder builder = this;
            prepareForNewUnknownFields();
            ProtoAdapter<?> rawProtoAdapter = fieldEncoding.rawProtoAdapter();
            ProtoWriter unknownFieldsWriter$wire_runtime = getUnknownFieldsWriter$wire_runtime();
            Intrinsics.checkNotNull(unknownFieldsWriter$wire_runtime);
            rawProtoAdapter.encodeWithTag(unknownFieldsWriter$wire_runtime, i, obj);
            return this;
        }

        public final Builder<M, B> clearUnknownFields() {
            Builder builder = this;
            setUnknownFieldsByteString$wire_runtime(ByteString.EMPTY);
            if (getUnknownFieldsBuffer$wire_runtime() != null) {
                Buffer unknownFieldsBuffer$wire_runtime = getUnknownFieldsBuffer$wire_runtime();
                Intrinsics.checkNotNull(unknownFieldsBuffer$wire_runtime);
                unknownFieldsBuffer$wire_runtime.clear();
                setUnknownFieldsBuffer$wire_runtime((Buffer) null);
            }
            setUnknownFieldsWriter$wire_runtime((ProtoWriter) null);
            return this;
        }

        public final ByteString buildUnknownFields() {
            Buffer buffer = this.unknownFieldsBuffer;
            if (buffer != null) {
                Intrinsics.checkNotNull(buffer);
                this.unknownFieldsByteString = buffer.readByteString();
                this.unknownFieldsBuffer = null;
                this.unknownFieldsWriter = null;
            }
            return this.unknownFieldsByteString;
        }

        private final void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer == null) {
                this.unknownFieldsBuffer = new Buffer();
                Buffer buffer = this.unknownFieldsBuffer;
                Intrinsics.checkNotNull(buffer);
                ProtoWriter protoWriter = new ProtoWriter(buffer);
                this.unknownFieldsWriter = protoWriter;
                Intrinsics.checkNotNull(protoWriter);
                protoWriter.writeBytes(this.unknownFieldsByteString);
                this.unknownFieldsByteString = ByteString.EMPTY;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/squareup/wire/Message$Companion;", "", "()V", "serialVersionUID", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
