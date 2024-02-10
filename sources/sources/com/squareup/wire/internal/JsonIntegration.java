package com.squareup.wire.internal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\b'()*+,-.B\u0005¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJE\u0010\u000e\u001a\u00028\u0001\"\b\b\u0002\u0010\u000f*\u00020\u0003\"\b\b\u0003\u0010\u0010*\u00020\u00032\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u0014H\u0002¢\u0006\u0002\u0010\u0015JA\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\"\b\b\u0002\u0010\u000f*\u00020\u0003\"\b\b\u0003\u0010\u0010*\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u00192\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002J\u0015\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u0001H&¢\u0006\u0002\u0010 J)\u0010!\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010#\u001a\u00028\u0001H&¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002J\u0015\u0010&\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010 ¨\u0006/"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration;", "F", "A", "", "()V", "formatterAdapter", "jsonStringAdapter", "Lcom/squareup/wire/internal/JsonFormatter;", "(Lcom/squareup/wire/internal/JsonFormatter;)Ljava/lang/Object;", "frameworkAdapter", "framework", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "jsonAdapter", "M", "B", "syntax", "Lcom/squareup/wire/Syntax;", "field", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "(Ljava/lang/Object;Lcom/squareup/wire/Syntax;Lcom/squareup/wire/internal/FieldOrOneOfBinding;)Ljava/lang/Object;", "jsonAdapters", "", "adapter", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "(Lcom/squareup/wire/internal/RuntimeMessageAdapter;Ljava/lang/Object;)Ljava/util/List;", "jsonFormatter", "protoAdapter", "Lcom/squareup/wire/ProtoAdapter;", "listAdapter", "elementAdapter", "(Ljava/lang/Object;)Ljava/lang/Object;", "mapAdapter", "keyFormatter", "valueAdapter", "(Ljava/lang/Object;Lcom/squareup/wire/internal/JsonFormatter;Ljava/lang/Object;)Ljava/lang/Object;", "mapKeyJsonFormatter", "structAdapter", "ByteStringJsonFormatter", "IntAsStringJsonFormatter", "LongAsStringJsonFormatter", "StringJsonFormatter", "UnsignedIntAsNumberJsonFormatter", "UnsignedIntAsStringJsonFormatter", "UnsignedLongAsNumberJsonFormatter", "UnsignedLongAsStringJsonFormatter", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonIntegration.kt */
public abstract class JsonIntegration<F, A> {
    public abstract A formatterAdapter(JsonFormatter<?> jsonFormatter);

    public abstract A frameworkAdapter(F f, Type type);

    public abstract A listAdapter(A a);

    public abstract A mapAdapter(F f, JsonFormatter<?> jsonFormatter, A a);

    public abstract A structAdapter(F f);

    public final <M, B> List<A> jsonAdapters(RuntimeMessageAdapter<M, B> runtimeMessageAdapter, F f) {
        Intrinsics.checkNotNullParameter(runtimeMessageAdapter, "adapter");
        int i = 0;
        Object[] array = runtimeMessageAdapter.getFields().values().toArray(new FieldOrOneOfBinding[0]);
        if (array != null) {
            FieldOrOneOfBinding[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) array;
            Collection arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
            int length = fieldOrOneOfBindingArr.length;
            while (i < length) {
                FieldOrOneOfBinding fieldOrOneOfBinding = fieldOrOneOfBindingArr[i];
                i++;
                arrayList.add(jsonAdapter(f, runtimeMessageAdapter.getSyntax(), fieldOrOneOfBinding));
            }
            return (List) arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final <M, B> A jsonAdapter(F f, Syntax syntax, FieldOrOneOfBinding<M, B> fieldOrOneOfBinding) {
        A a;
        if (fieldOrOneOfBinding.getSingleAdapter().isStruct$wire_runtime()) {
            return structAdapter(f);
        }
        JsonFormatter<?> jsonFormatter = jsonFormatter(syntax, fieldOrOneOfBinding.getSingleAdapter());
        if (jsonFormatter != null) {
            a = formatterAdapter(jsonFormatter);
        } else {
            KClass<?> type = fieldOrOneOfBinding.getSingleAdapter().getType();
            Class<?> javaObjectType = type == null ? null : JvmClassMappingKt.getJavaObjectType(type);
            if (javaObjectType != null) {
                a = frameworkAdapter(f, javaObjectType);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Type");
            }
        }
        if (fieldOrOneOfBinding.getLabel().isRepeated()) {
            return listAdapter(a);
        }
        if (fieldOrOneOfBinding.isMap()) {
            return mapAdapter(f, mapKeyJsonFormatter(fieldOrOneOfBinding.getKeyAdapter()), a);
        }
        return a;
    }

    private final JsonFormatter<?> jsonFormatter(Syntax syntax, ProtoAdapter<?> protoAdapter) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = true;
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.BYTES)) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.BYTES_VALUE);
        }
        if (z) {
            return ByteStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.DURATION)) {
            return DurationJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.INSTANT)) {
            return InstantJsonFormatter.INSTANCE;
        }
        if (protoAdapter instanceof EnumAdapter) {
            return new EnumJsonFormatter<>((EnumAdapter) protoAdapter);
        }
        if (syntax == Syntax.PROTO_2) {
            if (!Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT64)) {
                z8 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT64_VALUE);
            }
            if (z8) {
                return UnsignedLongAsNumberJsonFormatter.INSTANCE;
            }
            return null;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT32)) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.FIXED32);
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT32_VALUE);
        }
        if (z3) {
            return UnsignedIntAsNumberJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.INT64)) {
            z4 = true;
        } else {
            z4 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.SFIXED64);
        }
        if (z4) {
            z5 = true;
        } else {
            z5 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.SINT64);
        }
        if (z5) {
            z6 = true;
        } else {
            z6 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.INT64_VALUE);
        }
        if (z6) {
            return LongAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.FIXED64)) {
            z7 = true;
        } else {
            z7 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT64);
        }
        if (!z7) {
            z8 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT64_VALUE);
        }
        if (z8) {
            return UnsignedLongAsStringJsonFormatter.INSTANCE;
        }
        return null;
    }

    private final JsonFormatter<?> mapKeyJsonFormatter(ProtoAdapter<?> protoAdapter) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.STRING)) {
            return StringJsonFormatter.INSTANCE;
        }
        boolean z6 = true;
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.INT32)) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.SINT32);
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.SFIXED32);
        }
        if (z2) {
            return IntAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.FIXED32)) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT32);
        }
        if (z3) {
            return UnsignedIntAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.INT64)) {
            z4 = true;
        } else {
            z4 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.SFIXED64);
        }
        if (z4) {
            z5 = true;
        } else {
            z5 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.SINT64);
        }
        if (z5) {
            return LongAsStringJsonFormatter.INSTANCE;
        }
        if (!Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.FIXED64)) {
            z6 = Intrinsics.areEqual((Object) protoAdapter, (Object) ProtoAdapter.UINT64);
        }
        if (z6) {
            return UnsignedLongAsStringJsonFormatter.INSTANCE;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected map key type: ", protoAdapter.getType()).toString());
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedLongAsNumberJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "maxLong", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "power64", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class UnsignedLongAsNumberJsonFormatter implements JsonFormatter<Long> {
        public static final UnsignedLongAsNumberJsonFormatter INSTANCE = new UnsignedLongAsNumberJsonFormatter();
        private static final BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);
        private static final BigInteger power64 = new BigInteger("18446744073709551616");

        private UnsignedLongAsNumberJsonFormatter() {
        }

        public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
            return toStringOrNumber(((Number) obj).longValue());
        }

        public Long fromString(String str) {
            BigInteger bigInteger;
            long j;
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                bigInteger = new BigInteger(str);
            } catch (Exception unused) {
                bigInteger = new BigDecimal(str).toBigInteger();
            }
            if (bigInteger.compareTo(maxLong) > 0) {
                j = bigInteger.subtract(power64).longValue();
            } else {
                j = bigInteger.longValue();
            }
            return Long.valueOf(j);
        }

        public Object toStringOrNumber(long j) {
            Object obj;
            if (j < 0) {
                obj = power64.add(BigInteger.valueOf(j));
            } else {
                obj = Long.valueOf(j);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "when {\n        value < 0…    else -> value\n      }");
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedLongAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class UnsignedLongAsStringJsonFormatter implements JsonFormatter<Long> {
        public static final UnsignedLongAsStringJsonFormatter INSTANCE = new UnsignedLongAsStringJsonFormatter();

        private UnsignedLongAsStringJsonFormatter() {
        }

        public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
            return toStringOrNumber(((Number) obj).longValue());
        }

        public String toStringOrNumber(long j) {
            return UnsignedLongAsNumberJsonFormatter.INSTANCE.toStringOrNumber(j).toString();
        }

        public Long fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return UnsignedLongAsNumberJsonFormatter.INSTANCE.fromString(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$LongAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class LongAsStringJsonFormatter implements JsonFormatter<Long> {
        public static final LongAsStringJsonFormatter INSTANCE = new LongAsStringJsonFormatter();

        private LongAsStringJsonFormatter() {
        }

        public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
            return toStringOrNumber(((Number) obj).longValue());
        }

        public String toStringOrNumber(long j) {
            return String.valueOf(j);
        }

        public Long fromString(String str) {
            long j;
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                j = Long.parseLong(str);
            } catch (Exception unused) {
                j = new BigDecimal(str).longValueExact();
            }
            return Long.valueOf(j);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedIntAsNumberJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "maxInt", "", "power32", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class UnsignedIntAsNumberJsonFormatter implements JsonFormatter<Integer> {
        public static final UnsignedIntAsNumberJsonFormatter INSTANCE = new UnsignedIntAsNumberJsonFormatter();
        private static final long maxInt = 2147483647L;
        private static final long power32 = 4294967296L;

        private UnsignedIntAsNumberJsonFormatter() {
        }

        public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
            return toStringOrNumber(((Number) obj).intValue());
        }

        public Integer fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            long parseDouble = (long) Double.parseDouble(str);
            if (parseDouble >= maxInt) {
                parseDouble -= power32;
            }
            return Integer.valueOf((int) parseDouble);
        }

        public Object toStringOrNumber(int i) {
            if (i < 0) {
                return Long.valueOf(((long) i) + power32);
            }
            return Integer.valueOf(i);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$UnsignedIntAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "power32", "", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class UnsignedIntAsStringJsonFormatter implements JsonFormatter<Integer> {
        public static final UnsignedIntAsStringJsonFormatter INSTANCE = new UnsignedIntAsStringJsonFormatter();
        private static final long power32 = 4294967296L;

        private UnsignedIntAsStringJsonFormatter() {
        }

        public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
            return toStringOrNumber(((Number) obj).intValue());
        }

        public Integer fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return Integer.valueOf((int) Long.parseLong(str));
        }

        public Object toStringOrNumber(int i) {
            if (i < 0) {
                return String.valueOf(((long) i) + power32);
            }
            return String.valueOf(i);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$IntAsStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class IntAsStringJsonFormatter implements JsonFormatter<Integer> {
        public static final IntAsStringJsonFormatter INSTANCE = new IntAsStringJsonFormatter();

        private IntAsStringJsonFormatter() {
        }

        public /* bridge */ /* synthetic */ Object toStringOrNumber(Object obj) {
            return toStringOrNumber(((Number) obj).intValue());
        }

        public Integer fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return Integer.valueOf(Integer.parseInt(str));
        }

        public String toStringOrNumber(int i) {
            return String.valueOf(i);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$ByteStringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Lokio/ByteString;", "()V", "fromString", "value", "", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class ByteStringJsonFormatter implements JsonFormatter<ByteString> {
        public static final ByteStringJsonFormatter INSTANCE = new ByteStringJsonFormatter();

        private ByteStringJsonFormatter() {
        }

        public String toStringOrNumber(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "value");
            return byteString.base64();
        }

        public ByteString fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return ByteString.Companion.decodeBase64(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/squareup/wire/internal/JsonIntegration$StringJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "", "()V", "fromString", "value", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JsonIntegration.kt */
    private static final class StringJsonFormatter implements JsonFormatter<String> {
        public static final StringJsonFormatter INSTANCE = new StringJsonFormatter();

        public String fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return str;
        }

        public String toStringOrNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return str;
        }

        private StringJsonFormatter() {
        }
    }
}
