package com.squareup.wire;

import com.squareup.wire.WireField;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0000\u001a\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0000\u001a\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0005H\u0000\u001a\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0000\u001a\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H\u0000\u001a\u0012\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0005H\u0000\u001a\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001aC\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b0\u0005\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0005H\b\u001a\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005H\u0000\u001a\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010'0\u0005H\u0000\u001a\u001a\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0002\b\u0003\u0018\u00010\u001b0\u0005H\u0000\u001a\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0005H\u0000\u001a\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0005H\u0000\u001a\u001c\u0010-\u001a\u00020%\"\u0004\b\u0000\u0010.2\u0006\u0010/\u001a\u0002H.H\b¢\u0006\u0002\u00100\u001a\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a0\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H40\u0005\"\b\b\u0000\u00104*\u00020,2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H40\u00052\u0006\u00106\u001a\u00020%H\u0000\u001a%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\b\u001a%\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\b\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020;H\b¢\u0006\u0002\u0010<\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010=\u001a\u00020>H\b¢\u0006\u0002\u0010?\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020\bH\b¢\u0006\u0002\u0010@\u001a&\u0010A\u001a\u00020;\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\b¢\u0006\u0002\u0010B\u001a.\u0010A\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u0002H.H\b¢\u0006\u0002\u0010E\u001a&\u0010F\u001a\u00020\b\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\b¢\u0006\u0002\u0010G\u001a8\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\b¢\u0006\u0002\u0010L\u001a8\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020M2\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\b¢\u0006\u0002\u0010N\u001a0\u0010O\u001a\u00020\u0001\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\b¢\u0006\u0002\u0010P\u001a%\u0010Q\u001a\u0006\u0012\u0002\b\u00030\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010R\u001a\u00020SH\b\u001a.\u0010T\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020M2\u0006\u0010/\u001a\u0002H.H\b¢\u0006\u0002\u0010U\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"FIXED_32_SIZE", "", "FIXED_64_SIZE", "FIXED_BOOL_SIZE", "commonBool", "Lcom/squareup/wire/ProtoAdapter;", "", "commonBytes", "Lokio/ByteString;", "commonDouble", "", "commonDuration", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "commonEmpty", "", "commonFixed32", "commonFixed64", "", "commonFloat", "", "commonInstant", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "commonInt32", "commonInt64", "commonNewMapAdapter", "", "K", "V", "keyAdapter", "valueAdapter", "commonSfixed32", "commonSfixed64", "commonSint32", "commonSint64", "commonString", "", "commonStructList", "", "commonStructMap", "commonStructNull", "", "commonStructValue", "", "commonToString", "E", "value", "(Ljava/lang/Object;)Ljava/lang/String;", "commonUint32", "commonUint64", "commonWrapper", "T", "delegate", "typeUrl", "commonCreatePacked", "commonCreateRepeated", "commonDecode", "bytes", "", "(Lcom/squareup/wire/ProtoAdapter;[B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSource;)Ljava/lang/Object;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)Ljava/lang/Object;", "commonEncode", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)[B", "sink", "Lokio/BufferedSink;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSink;Ljava/lang/Object;)V", "commonEncodeByteString", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)Lokio/ByteString;", "commonEncodeWithTag", "writer", "Lcom/squareup/wire/ProtoWriter;", "tag", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ReverseProtoWriter;ILjava/lang/Object;)V", "commonEncodedSizeWithTag", "(Lcom/squareup/wire/ProtoAdapter;ILjava/lang/Object;)I", "commonWithLabel", "label", "Lcom/squareup/wire/WireField$Label;", "delegateEncode", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ReverseProtoWriter;Ljava/lang/Object;)V", "wire-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;

    public static final <E> int commonEncodedSizeWithTag(ProtoAdapter<E> protoAdapter, int i, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        if (e == null) {
            return 0;
        }
        int encodedSize = protoAdapter.encodedSize(e);
        if (protoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize);
        }
        return encodedSize + ProtoWriter.Companion.tagSize$wire_runtime(i);
    }

    public static final <E> void delegateEncode(ProtoAdapter<E> protoAdapter, ReverseProtoWriter reverseProtoWriter, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        reverseProtoWriter.writeForward$wire_runtime(new ProtoAdapterKt$delegateEncode$1(protoAdapter, e));
    }

    public static final <E> void commonEncodeWithTag(ProtoAdapter<E> protoAdapter, ProtoWriter protoWriter, int i, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (e != null) {
            protoWriter.writeTag(i, protoAdapter.getFieldEncoding$wire_runtime());
            if (protoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
                protoWriter.writeVarint32(protoAdapter.encodedSize(e));
            }
            protoAdapter.encode(protoWriter, e);
        }
    }

    public static final <E> void commonEncodeWithTag(ProtoAdapter<E> protoAdapter, ReverseProtoWriter reverseProtoWriter, int i, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (e != null) {
            if (protoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
                int byteCount = reverseProtoWriter.getByteCount();
                protoAdapter.encode(reverseProtoWriter, e);
                reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
            } else {
                protoAdapter.encode(reverseProtoWriter, e);
            }
            reverseProtoWriter.writeTag(i, protoAdapter.getFieldEncoding$wire_runtime());
        }
    }

    public static final <E> void commonEncode(ProtoAdapter<E> protoAdapter, BufferedSink bufferedSink, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        ReverseProtoWriter reverseProtoWriter = new ReverseProtoWriter();
        protoAdapter.encode(reverseProtoWriter, e);
        reverseProtoWriter.writeTo(bufferedSink);
    }

    public static final <E> byte[] commonEncode(ProtoAdapter<E> protoAdapter, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Buffer buffer = new Buffer();
        protoAdapter.encode((BufferedSink) buffer, e);
        return buffer.readByteArray();
    }

    public static final <E> ByteString commonEncodeByteString(ProtoAdapter<E> protoAdapter, E e) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Buffer buffer = new Buffer();
        protoAdapter.encode((BufferedSink) buffer, e);
        return buffer.readByteString();
    }

    public static final <E> E commonDecode(ProtoAdapter<E> protoAdapter, byte[] bArr) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return protoAdapter.decode((BufferedSource) new Buffer().write(bArr));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> protoAdapter, ByteString byteString) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return protoAdapter.decode((BufferedSource) new Buffer().write(byteString));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> protoAdapter, BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return protoAdapter.decode(new ProtoReader(bufferedSource));
    }

    public static final <E> String commonToString(E e) {
        return String.valueOf(e);
    }

    public static final <E> ProtoAdapter<?> commonWithLabel(ProtoAdapter<E> protoAdapter, WireField.Label label) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        Intrinsics.checkNotNullParameter(label, "label");
        if (label.isRepeated()) {
            return label.isPacked() ? protoAdapter.asPacked() : protoAdapter.asRepeated();
        }
        return protoAdapter;
    }

    public static final <E> ProtoAdapter<List<E>> commonCreatePacked(ProtoAdapter<E> protoAdapter) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        if (protoAdapter.getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) {
            return new PackedProtoAdapter<>(protoAdapter);
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(ProtoAdapter<E> protoAdapter) {
        Intrinsics.checkNotNullParameter(protoAdapter, "<this>");
        return new RepeatedProtoAdapter<>(protoAdapter);
    }

    public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        Intrinsics.checkNotNullParameter(protoAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(protoAdapter2, "valueAdapter");
        return new MapProtoAdapter<>(protoAdapter, protoAdapter2);
    }

    public static final ProtoAdapter<Boolean> commonBool() {
        return new ProtoAdapterKt$commonBool$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Boolean.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Integer> commonInt32() {
        return new ProtoAdapterKt$commonInt32$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Integer> commonUint32() {
        return new ProtoAdapterKt$commonUint32$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Integer> commonSint32() {
        return new ProtoAdapterKt$commonSint32$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Integer> commonFixed32() {
        return new ProtoAdapterKt$commonFixed32$1(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Integer.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Integer> commonSfixed32() {
        return commonFixed32();
    }

    public static final ProtoAdapter<Long> commonInt64() {
        return new ProtoAdapterKt$commonInt64$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Long> commonUint64() {
        return new ProtoAdapterKt$commonUint64$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Long> commonSint64() {
        return new ProtoAdapterKt$commonSint64$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Long> commonFixed64() {
        return new ProtoAdapterKt$commonFixed64$1(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Long.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Long> commonSfixed64() {
        return commonFixed64();
    }

    public static final ProtoAdapter<Float> commonFloat() {
        return new ProtoAdapterKt$commonFloat$1(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Float.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<Double> commonDouble() {
        return new ProtoAdapterKt$commonDouble$1(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Double.TYPE), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<String> commonString() {
        return new ProtoAdapterKt$commonString$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(String.class), Syntax.PROTO_2);
    }

    public static final ProtoAdapter<ByteString> commonBytes() {
        return new ProtoAdapterKt$commonBytes$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ByteString.class), Syntax.PROTO_2, ByteString.EMPTY);
    }

    public static final ProtoAdapter<Duration> commonDuration() {
        return new ProtoAdapterKt$commonDuration$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Duration.class), Syntax.PROTO_3);
    }

    public static final ProtoAdapter<Instant> commonInstant() {
        return new ProtoAdapterKt$commonInstant$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Instant.class), Syntax.PROTO_3);
    }

    public static final ProtoAdapter<Unit> commonEmpty() {
        return new ProtoAdapterKt$commonEmpty$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Unit.class), Syntax.PROTO_3);
    }

    public static final ProtoAdapter<Map<String, ?>> commonStructMap() {
        return new ProtoAdapterKt$commonStructMap$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.class), Syntax.PROTO_3);
    }

    public static final ProtoAdapter<List<?>> commonStructList() {
        return new ProtoAdapterKt$commonStructList$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.class), Syntax.PROTO_3);
    }

    public static final ProtoAdapter commonStructNull() {
        return new ProtoAdapterKt$commonStructNull$1(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Void.class), Syntax.PROTO_3);
    }

    public static final ProtoAdapter<Object> commonStructValue() {
        return new ProtoAdapterKt$commonStructValue$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Object.class), Syntax.PROTO_3);
    }

    public static final <T> ProtoAdapter<T> commonWrapper(ProtoAdapter<T> protoAdapter, String str) {
        Intrinsics.checkNotNullParameter(protoAdapter, "delegate");
        Intrinsics.checkNotNullParameter(str, "typeUrl");
        return new ProtoAdapterKt$commonWrapper$1(str, protoAdapter, FieldEncoding.LENGTH_DELIMITED, protoAdapter.getType(), Syntax.PROTO_3, protoAdapter.getIdentity());
    }
}
