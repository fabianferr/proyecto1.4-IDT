package com.squareup.wire;

import com.facebook.share.internal.ShareConstants;
import com.squareup.wire.Message;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.ReflectionKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 `*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002`aB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB7\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000fB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0012B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0013B9\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014BA\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0017J\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0\u0000J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0\u0000J\u0015\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u000202H&¢\u0006\u0002\u00103J\u0013\u00100\u001a\u00028\u00002\u0006\u00104\u001a\u000205¢\u0006\u0002\u00106J\u0013\u00100\u001a\u00028\u00002\u0006\u00107\u001a\u000208¢\u0006\u0002\u00109J\u0013\u00100\u001a\u00028\u00002\u0006\u0010:\u001a\u00020;¢\u0006\u0002\u0010<J\u0013\u00100\u001a\u00028\u00002\u0006\u00107\u001a\u00020=¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00028\u0000¢\u0006\u0002\u0010AJ\u001d\u0010?\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010@\u001a\u00028\u0000H&¢\u0006\u0002\u0010EJ\u001d\u0010?\u001a\u00020B2\u0006\u0010C\u001a\u00020F2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010GJ\u001b\u0010?\u001a\u00020B2\u0006\u00104\u001a\u00020H2\u0006\u0010@\u001a\u00028\u0000¢\u0006\u0002\u0010IJ\u001b\u0010?\u001a\u00020B2\u0006\u0010J\u001a\u00020K2\u0006\u0010@\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020=2\u0006\u0010@\u001a\u00028\u0000¢\u0006\u0002\u0010NJ'\u0010O\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010P\u001a\u00020Q2\b\u0010@\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010RJ'\u0010O\u001a\u00020B2\u0006\u0010C\u001a\u00020F2\u0006\u0010P\u001a\u00020Q2\b\u0010@\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010SJ\u0015\u0010T\u001a\u00020Q2\u0006\u0010@\u001a\u00028\u0000H&¢\u0006\u0002\u0010UJ\u001f\u0010V\u001a\u00020Q2\u0006\u0010P\u001a\u00020Q2\b\u0010@\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010WJ\u0015\u0010X\u001a\u00028\u00002\u0006\u0010@\u001a\u00028\u0000H&¢\u0006\u0002\u0010YJ\u0015\u0010Z\u001a\u00020\t2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010[J\u0019\u0010\\\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010]\u001a\u00020^H\u0000¢\u0006\u0002\b_R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"\u0018\u00010\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"\u0018\u00010\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(¨\u0006b"}, d2 = {"Lcom/squareup/wire/ProtoAdapter;", "E", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "type", "Ljava/lang/Class;", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;)V", "typeUrl", "", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;)V", "syntax", "Lcom/squareup/wire/Syntax;", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;Lcom/squareup/wire/Syntax;)V", "identity", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;Lcom/squareup/wire/Syntax;Ljava/lang/Object;)V", "Lkotlin/reflect/KClass;", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;Lcom/squareup/wire/Syntax;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;Lcom/squareup/wire/Syntax;Ljava/lang/Object;)V", "sourceFile", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;Ljava/lang/String;Lcom/squareup/wire/Syntax;Ljava/lang/Object;Ljava/lang/String;)V", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/reflect/KClass;Ljava/lang/String;Lcom/squareup/wire/Syntax;Ljava/lang/Object;Ljava/lang/String;)V", "getFieldEncoding$wire_runtime", "()Lcom/squareup/wire/FieldEncoding;", "getIdentity", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isStruct", "", "isStruct$wire_runtime", "()Z", "packedAdapter", "", "getPackedAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "repeatedAdapter", "getRepeatedAdapter$wire_runtime", "getSourceFile", "()Ljava/lang/String;", "getSyntax", "()Lcom/squareup/wire/Syntax;", "getType", "()Lkotlin/reflect/KClass;", "getTypeUrl", "asPacked", "asRepeated", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "bytes", "", "([B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)Ljava/lang/Object;", "Lokio/ByteString;", "(Lokio/ByteString;)Ljava/lang/Object;", "encode", "value", "(Ljava/lang/Object;)[B", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ReverseProtoWriter;Ljava/lang/Object;)V", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;Ljava/lang/Object;)V", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/lang/Object;)V", "encodeByteString", "(Ljava/lang/Object;)Lokio/ByteString;", "encodeWithTag", "tag", "", "(Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "(Lcom/squareup/wire/ReverseProtoWriter;ILjava/lang/Object;)V", "encodedSize", "(Ljava/lang/Object;)I", "encodedSizeWithTag", "(ILjava/lang/Object;)I", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "withLabel", "label", "Lcom/squareup/wire/WireField$Label;", "withLabel$wire_runtime", "Companion", "EnumConstantNotFoundException", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL;
    public static final ProtoAdapter<Boolean> BOOL_VALUE;
    public static final ProtoAdapter<ByteString> BYTES;
    public static final ProtoAdapter<ByteString> BYTES_VALUE;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ProtoAdapter<Double> DOUBLE;
    public static final ProtoAdapter<Double> DOUBLE_VALUE;
    public static final ProtoAdapter<Duration> DURATION;
    public static final ProtoAdapter<Unit> EMPTY = ProtoAdapterKt.commonEmpty();
    public static final ProtoAdapter<Integer> FIXED32 = ProtoAdapterKt.commonFixed32();
    public static final ProtoAdapter<Long> FIXED64 = ProtoAdapterKt.commonFixed64();
    public static final ProtoAdapter<Float> FLOAT;
    public static final ProtoAdapter<Float> FLOAT_VALUE;
    public static final ProtoAdapter<Instant> INSTANT;
    public static final ProtoAdapter<Integer> INT32;
    public static final ProtoAdapter<Integer> INT32_VALUE;
    public static final ProtoAdapter<Long> INT64;
    public static final ProtoAdapter<Long> INT64_VALUE;
    public static final ProtoAdapter<Integer> SFIXED32 = ProtoAdapterKt.commonSfixed32();
    public static final ProtoAdapter<Long> SFIXED64 = ProtoAdapterKt.commonSfixed64();
    public static final ProtoAdapter<Integer> SINT32 = ProtoAdapterKt.commonSint32();
    public static final ProtoAdapter<Long> SINT64 = ProtoAdapterKt.commonSint64();
    public static final ProtoAdapter<String> STRING;
    public static final ProtoAdapter<String> STRING_VALUE;
    public static final ProtoAdapter<List<?>> STRUCT_LIST = ProtoAdapterKt.commonStructList();
    public static final ProtoAdapter<Map<String, ?>> STRUCT_MAP = ProtoAdapterKt.commonStructMap();
    public static final ProtoAdapter STRUCT_NULL = ProtoAdapterKt.commonStructNull();
    public static final ProtoAdapter<Object> STRUCT_VALUE = ProtoAdapterKt.commonStructValue();
    public static final ProtoAdapter<Integer> UINT32;
    public static final ProtoAdapter<Integer> UINT32_VALUE;
    public static final ProtoAdapter<Long> UINT64;
    public static final ProtoAdapter<Long> UINT64_VALUE;
    private final FieldEncoding fieldEncoding;
    private final E identity;
    private final ProtoAdapter<List<E>> packedAdapter;
    private final ProtoAdapter<List<E>> repeatedAdapter;
    private final String sourceFile;
    private final Syntax syntax;
    private final KClass<?> type;
    private final String typeUrl;

    @JvmStatic
    public static final <M extends Message<?, ?>> ProtoAdapter<M> get(M m) {
        return Companion.get(m);
    }

    @JvmStatic
    public static final <M> ProtoAdapter<M> get(Class<M> cls) {
        return Companion.get(cls);
    }

    @JvmStatic
    public static final ProtoAdapter<?> get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return Companion.newEnumAdapter(cls);
    }

    @JvmStatic
    public static final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return Companion.newMapAdapter(protoAdapter, protoAdapter2);
    }

    @JvmStatic
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return Companion.newMessageAdapter(cls);
    }

    @JvmStatic
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str) {
        return Companion.newMessageAdapter(cls, str);
    }

    @JvmStatic
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str, Syntax syntax2) {
        return Companion.newMessageAdapter(cls, str, syntax2);
    }

    public abstract E decode(ProtoReader protoReader) throws IOException;

    public abstract void encode(ProtoWriter protoWriter, E e) throws IOException;

    public abstract int encodedSize(E e);

    public abstract E redact(E e);

    public ProtoAdapter(FieldEncoding fieldEncoding2, KClass<?> kClass, String str, Syntax syntax2, E e, String str2) {
        ProtoAdapter<List<E>> protoAdapter;
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(syntax2, "syntax");
        this.fieldEncoding = fieldEncoding2;
        this.type = kClass;
        this.typeUrl = str;
        this.syntax = syntax2;
        this.identity = e;
        this.sourceFile = str2;
        boolean z = this instanceof PackedProtoAdapter;
        ProtoAdapter<List<E>> protoAdapter2 = null;
        if (z || (this instanceof RepeatedProtoAdapter) || fieldEncoding2 == FieldEncoding.LENGTH_DELIMITED) {
            protoAdapter = null;
        } else {
            if (getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) {
                protoAdapter = new PackedProtoAdapter<>(this);
            } else {
                throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
            }
        }
        this.packedAdapter = protoAdapter;
        if (!(this instanceof RepeatedProtoAdapter) && !z) {
            protoAdapter2 = new RepeatedProtoAdapter<>(this);
        }
        this.repeatedAdapter = protoAdapter2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProtoAdapter(FieldEncoding fieldEncoding2, KClass kClass, String str, Syntax syntax2, Object obj, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fieldEncoding2, (KClass<?>) kClass, str, syntax2, (i & 16) != 0 ? null : obj, (i & 32) != 0 ? null : str2);
    }

    public final FieldEncoding getFieldEncoding$wire_runtime() {
        return this.fieldEncoding;
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public final Syntax getSyntax() {
        return this.syntax;
    }

    public final E getIdentity() {
        return this.identity;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final ProtoAdapter<List<E>> getPackedAdapter$wire_runtime() {
        return this.packedAdapter;
    }

    public final ProtoAdapter<List<E>> getRepeatedAdapter$wire_runtime() {
        return this.repeatedAdapter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls) {
        this(fieldEncoding2, JvmClassMappingKt.getKotlinClass(cls));
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(cls, "type");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls, String str) {
        this(fieldEncoding2, JvmClassMappingKt.getKotlinClass(cls), str, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(cls, "type");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls, String str, Syntax syntax2) {
        this(fieldEncoding2, JvmClassMappingKt.getKotlinClass(cls), str, syntax2);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(syntax2, "syntax");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls, String str, Syntax syntax2, E e) {
        this(fieldEncoding2, JvmClassMappingKt.getKotlinClass(cls), str, syntax2, e, (String) null);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(syntax2, "syntax");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, KClass<?> kClass) {
        this(fieldEncoding2, kClass, (String) null, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, KClass<?> kClass, String str) {
        this(fieldEncoding2, kClass, str, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, KClass<?> kClass, String str, Syntax syntax2) {
        this(fieldEncoding2, kClass, str, syntax2, (Object) null);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(syntax2, "syntax");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, KClass<?> kClass, String str, Syntax syntax2, E e) {
        this(fieldEncoding2, kClass, str, syntax2, e, (String) null);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(syntax2, "syntax");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding2, Class<?> cls, String str, Syntax syntax2, E e, String str2) {
        this(fieldEncoding2, JvmClassMappingKt.getKotlinClass(cls), str, syntax2, e, str2);
        Intrinsics.checkNotNullParameter(fieldEncoding2, "fieldEncoding");
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(syntax2, "syntax");
    }

    public final void encode(OutputStream outputStream, E e) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        encode(buffer, e);
        buffer.emit();
    }

    public final E decode(InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final ProtoAdapter<List<E>> asPacked() {
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
            ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            throw new UnsupportedOperationException("Can't create a packed adapter from a packed or repeated adapter.");
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public final boolean isStruct$wire_runtime() {
        return Intrinsics.areEqual((Object) this, (Object) STRUCT_MAP) || Intrinsics.areEqual((Object) this, (Object) STRUCT_LIST) || Intrinsics.areEqual((Object) this, (Object) STRUCT_VALUE) || Intrinsics.areEqual((Object) this, (Object) STRUCT_NULL);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "value", "", "type", "Ljava/lang/Class;", "(ILjava/lang/Class;)V", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)V", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProtoAdapter.kt */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public EnumConstantNotFoundException(int r3, kotlin.reflect.KClass<?> r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Unknown enum tag "
                r0.<init>(r1)
                r0.append(r3)
                java.lang.String r1 = " for "
                r0.append(r1)
                r1 = 0
                if (r4 != 0) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.lang.Class r4 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r4)
                if (r4 != 0) goto L_0x001a
                goto L_0x001e
            L_0x001a:
                java.lang.String r1 = r4.getName()
            L_0x001e:
                r0.append(r1)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4)
                r2.value = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException.<init>(int, kotlin.reflect.KClass):void");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public EnumConstantNotFoundException(int i, Class<?> cls) {
            this(i, JvmClassMappingKt.getKotlinClass(cls));
            Intrinsics.checkNotNullParameter(cls, "type");
        }
    }

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001IB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u00102\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0010\b\u0001\u00103*\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003042\u0006\u00105\u001a\u0002H3H\u0007¢\u0006\u0002\u00106J\"\u00102\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0004\b\u0001\u001032\f\u00107\u001a\b\u0012\u0004\u0012\u0002H308H\u0007J\u0014\u00102\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u00109\u001a\u00020%H\u0007J&\u0010:\u001a\b\u0012\u0004\u0012\u0002H<0;\"\b\b\u0001\u0010<*\u00020=2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H<08H\u0007JB\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002H@0*0\u0004\"\u0004\b\u0001\u0010?\"\u0004\b\u0002\u0010@2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0\u0004H\u0007JH\u0010C\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0014\b\u0001\u00103*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD04\"\u0014\b\u0002\u0010D*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD0E2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H308H\u0007JP\u0010C\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0014\b\u0001\u00103*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD04\"\u0014\b\u0002\u0010D*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD0E2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H3082\u0006\u0010F\u001a\u00020%H\u0007JX\u0010C\u001a\b\u0012\u0004\u0012\u0002H30\u0004\"\u0014\b\u0001\u00103*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD04\"\u0014\b\u0002\u0010D*\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002HD0E2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H3082\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020HH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010(0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\"\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0002\b\u0003\u0018\u00010*0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$Companion;", "", "()V", "BOOL", "Lcom/squareup/wire/ProtoAdapter;", "", "BOOL_VALUE", "BYTES", "Lokio/ByteString;", "BYTES_VALUE", "DOUBLE", "", "DOUBLE_VALUE", "DURATION", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "EMPTY", "", "FIXED32", "", "FIXED64", "", "FLOAT", "", "FLOAT_VALUE", "INSTANT", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "INT32", "INT32_VALUE", "INT64", "INT64_VALUE", "SFIXED32", "SFIXED64", "SINT32", "SINT64", "STRING", "", "STRING_VALUE", "STRUCT_LIST", "", "STRUCT_MAP", "", "STRUCT_NULL", "", "STRUCT_VALUE", "UINT32", "UINT32_VALUE", "UINT64", "UINT64_VALUE", "get", "M", "Lcom/squareup/wire/Message;", "message", "(Lcom/squareup/wire/Message;)Lcom/squareup/wire/ProtoAdapter;", "type", "Ljava/lang/Class;", "adapterString", "newEnumAdapter", "Lcom/squareup/wire/EnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "newMapAdapter", "K", "V", "keyAdapter", "valueAdapter", "newMessageAdapter", "B", "Lcom/squareup/wire/Message$Builder;", "typeUrl", "syntax", "Lcom/squareup/wire/Syntax;", "UnsupportedTypeProtoAdapter", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProtoAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
            Intrinsics.checkNotNullParameter(cls, "type");
            return ReflectionKt.createRuntimeMessageAdapter$default(cls, (String) null, Syntax.PROTO_2, false, 8, (Object) null);
        }

        @JvmStatic
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(str, "typeUrl");
            return ReflectionKt.createRuntimeMessageAdapter$default(cls, str, Syntax.PROTO_2, false, 8, (Object) null);
        }

        @JvmStatic
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str, Syntax syntax) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(str, "typeUrl");
            Intrinsics.checkNotNullParameter(syntax, "syntax");
            return ReflectionKt.createRuntimeMessageAdapter$default(cls, str, syntax, false, 8, (Object) null);
        }

        @JvmStatic
        public final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(Class<E> cls) {
            Intrinsics.checkNotNullParameter(cls, "type");
            return new RuntimeEnumAdapter<>(cls);
        }

        @JvmStatic
        public final <M extends Message<?, ?>> ProtoAdapter<M> get(M m) {
            Intrinsics.checkNotNullParameter(m, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return get(m.getClass());
        }

        @JvmStatic
        public final <M> ProtoAdapter<M> get(Class<M> cls) {
            Intrinsics.checkNotNullParameter(cls, "type");
            try {
                Object obj = cls.getField("ADAPTER").get((Object) null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<M of com.squareup.wire.ProtoAdapter.Companion.get>");
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e);
            } catch (NoSuchFieldException e2) {
                throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e2);
            }
        }

        @JvmStatic
        public final ProtoAdapter<?> get(String str) {
            Intrinsics.checkNotNullParameter(str, "adapterString");
            try {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '#', 0, false, 6, (Object) null);
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                Object obj = Class.forName(substring).getField(substring2).get((Object) null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("failed to access ", str), e);
            } catch (NoSuchFieldException e2) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("failed to access ", str), e2);
            } catch (ClassNotFoundException e3) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("failed to access ", str), e3);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$Companion$UnsupportedTypeProtoAdapter;", "Lcom/squareup/wire/ProtoAdapter;", "", "()V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ProtoAdapter.kt */
        public static final class UnsupportedTypeProtoAdapter extends ProtoAdapter {
            public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
                return ((Number) encodedSize((Void) obj)).intValue();
            }

            public UnsupportedTypeProtoAdapter() {
                super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Void.class));
            }

            public Void redact(Void voidR) {
                Intrinsics.checkNotNullParameter(voidR, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            public Void encodedSize(Void voidR) {
                Intrinsics.checkNotNullParameter(voidR, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            public Void encode(ProtoWriter protoWriter, Void voidR) {
                Intrinsics.checkNotNullParameter(protoWriter, "writer");
                Intrinsics.checkNotNullParameter(voidR, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            public Void encode(ReverseProtoWriter reverseProtoWriter, Void voidR) {
                Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
                Intrinsics.checkNotNullParameter(voidR, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            public Void decode(ProtoReader protoReader) {
                Intrinsics.checkNotNullParameter(protoReader, "reader");
                throw new IllegalStateException("Operation not supported.");
            }
        }

        @JvmStatic
        public final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            Intrinsics.checkNotNullParameter(protoAdapter, "keyAdapter");
            Intrinsics.checkNotNullParameter(protoAdapter2, "valueAdapter");
            return new MapProtoAdapter<>(protoAdapter, protoAdapter2);
        }
    }

    static {
        ProtoAdapter<Duration> protoAdapter;
        ProtoAdapter<Instant> protoAdapter2;
        ProtoAdapter<Boolean> commonBool = ProtoAdapterKt.commonBool();
        BOOL = commonBool;
        ProtoAdapter<Integer> commonInt32 = ProtoAdapterKt.commonInt32();
        INT32 = commonInt32;
        ProtoAdapter<Integer> commonUint32 = ProtoAdapterKt.commonUint32();
        UINT32 = commonUint32;
        ProtoAdapter<Long> commonInt64 = ProtoAdapterKt.commonInt64();
        INT64 = commonInt64;
        ProtoAdapter<Long> commonUint64 = ProtoAdapterKt.commonUint64();
        UINT64 = commonUint64;
        ProtoAdapter<Float> commonFloat = ProtoAdapterKt.commonFloat();
        FLOAT = commonFloat;
        ProtoAdapter<Double> commonDouble = ProtoAdapterKt.commonDouble();
        DOUBLE = commonDouble;
        ProtoAdapter<ByteString> commonBytes = ProtoAdapterKt.commonBytes();
        BYTES = commonBytes;
        ProtoAdapter<String> commonString = ProtoAdapterKt.commonString();
        STRING = commonString;
        DOUBLE_VALUE = ProtoAdapterKt.commonWrapper(commonDouble, "type.googleapis.com/google.protobuf.DoubleValue");
        FLOAT_VALUE = ProtoAdapterKt.commonWrapper(commonFloat, "type.googleapis.com/google.protobuf.FloatValue");
        INT64_VALUE = ProtoAdapterKt.commonWrapper(commonInt64, "type.googleapis.com/google.protobuf.Int64Value");
        UINT64_VALUE = ProtoAdapterKt.commonWrapper(commonUint64, "type.googleapis.com/google.protobuf.UInt64Value");
        INT32_VALUE = ProtoAdapterKt.commonWrapper(commonInt32, "type.googleapis.com/google.protobuf.Int32Value");
        UINT32_VALUE = ProtoAdapterKt.commonWrapper(commonUint32, "type.googleapis.com/google.protobuf.UInt32Value");
        BOOL_VALUE = ProtoAdapterKt.commonWrapper(commonBool, "type.googleapis.com/google.protobuf.BoolValue");
        STRING_VALUE = ProtoAdapterKt.commonWrapper(commonString, "type.googleapis.com/google.protobuf.StringValue");
        BYTES_VALUE = ProtoAdapterKt.commonWrapper(commonBytes, "type.googleapis.com/google.protobuf.BytesValue");
        try {
            protoAdapter = ProtoAdapterKt.commonDuration();
        } catch (NoClassDefFoundError unused) {
            protoAdapter = new Companion.UnsupportedTypeProtoAdapter();
        }
        DURATION = protoAdapter;
        try {
            protoAdapter2 = ProtoAdapterKt.commonInstant();
        } catch (NoClassDefFoundError unused2) {
            protoAdapter2 = new Companion.UnsupportedTypeProtoAdapter();
        }
        INSTANT = protoAdapter2;
    }

    public int encodedSizeWithTag(int i, E e) {
        if (e == null) {
            return 0;
        }
        int encodedSize = encodedSize(e);
        if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize);
        }
        return ProtoWriter.Companion.tagSize$wire_runtime(i) + encodedSize;
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, E e) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        reverseProtoWriter.writeForward$wire_runtime(new ProtoAdapterKt$delegateEncode$1(this, e));
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, E e) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (e != null) {
            protoWriter.writeTag(i, getFieldEncoding$wire_runtime());
            if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
                protoWriter.writeVarint32(encodedSize(e));
            }
            encode(protoWriter, e);
        }
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, E e) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (e != null) {
            if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
                int byteCount = reverseProtoWriter.getByteCount();
                encode(reverseProtoWriter, e);
                reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
            } else {
                encode(reverseProtoWriter, e);
            }
            reverseProtoWriter.writeTag(i, getFieldEncoding$wire_runtime());
        }
    }

    public final void encode(BufferedSink bufferedSink, E e) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        ReverseProtoWriter reverseProtoWriter = new ReverseProtoWriter();
        encode(reverseProtoWriter, e);
        reverseProtoWriter.writeTo(bufferedSink);
    }

    public final byte[] encode(E e) {
        Buffer buffer = new Buffer();
        encode((BufferedSink) buffer, e);
        return buffer.readByteArray();
    }

    public final ByteString encodeByteString(E e) {
        Buffer buffer = new Buffer();
        encode((BufferedSink) buffer, e);
        return buffer.readByteString();
    }

    public final E decode(byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return decode((BufferedSource) new Buffer().write(bArr));
    }

    public final E decode(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return decode((BufferedSource) new Buffer().write(byteString));
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return decode(new ProtoReader(bufferedSource));
    }

    public String toString(E e) {
        return String.valueOf(e);
    }

    public final ProtoAdapter<?> withLabel$wire_runtime(WireField.Label label) {
        Intrinsics.checkNotNullParameter(label, "label");
        if (label.isRepeated()) {
            return label.isPacked() ? asPacked() : asRepeated();
        }
        return this;
    }
}
