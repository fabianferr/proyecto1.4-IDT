package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.WireField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001?B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u001d\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020)2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00100\u001a\u00020\u0010H\u0016J\u000b\u00101\u001a\u00028\u0001¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00020\u00152\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106JU\u00107\u001a\u00020$\"\u0004\b\u0002\u001082\b\u00109\u001a\u0004\u0018\u00018\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H80\u00142\b\u0010;\u001a\u0004\u0018\u0001H82 \u0010<\u001a\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020$0=¢\u0006\u0002\u0010>R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR)\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u00020\u0015*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006@"}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "", "B", "Lcom/squareup/wire/ProtoAdapter;", "binding", "Lcom/squareup/wire/internal/MessageBinding;", "(Lcom/squareup/wire/internal/MessageBinding;)V", "fieldBindingsArray", "", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "getFieldBindingsArray", "()[Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "[Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "fields", "", "", "getFields", "()Ljava/util/Map;", "jsonAlternateNames", "", "", "getJsonAlternateNames", "()Ljava/util/List;", "jsonNames", "getJsonNames", "messageType", "Lkotlin/reflect/KClass;", "jsonName", "getJsonName", "(Lcom/squareup/wire/internal/FieldOrOneOfBinding;)Ljava/lang/String;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ReverseProtoWriter;Ljava/lang/Object;)V", "encodedSize", "(Ljava/lang/Object;)I", "equals", "", "other", "hashCode", "newBuilder", "()Ljava/lang/Object;", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "writeAllFields", "A", "message", "jsonAdapters", "redactedFieldsAdapter", "encodeValue", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RuntimeMessageAdapter.kt */
public final class RuntimeMessageAdapter<M, B> extends ProtoAdapter<M> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String REDACTED = "██";
    private final MessageBinding<M, B> binding;
    private final FieldOrOneOfBinding<M, B>[] fieldBindingsArray;
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;
    private final List<String> jsonAlternateNames;
    private final List<String> jsonNames;
    private final KClass<? super M> messageType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RuntimeMessageAdapter(MessageBinding<M, B> messageBinding) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) messageBinding.getMessageType(), messageBinding.getTypeUrl(), messageBinding.getSyntax());
        String str;
        Intrinsics.checkNotNullParameter(messageBinding, "binding");
        this.binding = messageBinding;
        this.messageType = messageBinding.getMessageType();
        Map<Integer, FieldOrOneOfBinding<M, B>> fields2 = messageBinding.getFields();
        this.fields = fields2;
        int i = 0;
        Object[] array = fields2.values().toArray(new FieldOrOneOfBinding[0]);
        if (array != null) {
            FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) array;
            this.fieldBindingsArray = fieldOrOneOfBindingArr;
            Collection arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
            int length = fieldOrOneOfBindingArr.length;
            int i2 = 0;
            while (i2 < length) {
                FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = fieldOrOneOfBindingArr[i2];
                i2++;
                arrayList.add(getJsonName(fieldOrOneOfBinding));
            }
            this.jsonNames = (List) arrayList;
            FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr2 = this.fieldBindingsArray;
            Collection arrayList2 = new ArrayList(fieldOrOneOfBindingArr2.length);
            int length2 = fieldOrOneOfBindingArr2.length;
            while (i < length2) {
                FieldOrOneOfBinding<M, B> fieldOrOneOfBinding2 = fieldOrOneOfBindingArr2[i];
                i++;
                if (!Intrinsics.areEqual((Object) getJsonName(fieldOrOneOfBinding2), (Object) fieldOrOneOfBinding2.getDeclaredName())) {
                    str = fieldOrOneOfBinding2.getDeclaredName();
                } else {
                    str = !Intrinsics.areEqual((Object) getJsonName(fieldOrOneOfBinding2), (Object) fieldOrOneOfBinding2.getName()) ? fieldOrOneOfBinding2.getName() : null;
                }
                arrayList2.add(str);
            }
            this.jsonAlternateNames = (List) arrayList2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final Map<Integer, FieldOrOneOfBinding<M, B>> getFields() {
        return this.fields;
    }

    public final FieldOrOneOfBinding<M, B>[] getFieldBindingsArray() {
        return this.fieldBindingsArray;
    }

    public final List<String> getJsonNames() {
        return this.jsonNames;
    }

    public final List<String> getJsonAlternateNames() {
        return this.jsonAlternateNames;
    }

    public final String getJsonName(FieldOrOneOfBinding<?, ?> fieldOrOneOfBinding) {
        Intrinsics.checkNotNullParameter(fieldOrOneOfBinding, "<this>");
        return fieldOrOneOfBinding.getWireFieldJsonName().length() == 0 ? fieldOrOneOfBinding.getDeclaredName() : fieldOrOneOfBinding.getWireFieldJsonName();
    }

    public final B newBuilder() {
        return this.binding.newBuilder();
    }

    public int encodedSize(M m) {
        Intrinsics.checkNotNullParameter(m, "value");
        int cachedSerializedSize = this.binding.getCachedSerializedSize(m);
        if (cachedSerializedSize != 0) {
            return cachedSerializedSize;
        }
        int i = 0;
        for (FieldOrOneOfBinding next : this.fields.values()) {
            Object obj = next.get(m);
            if (obj != null) {
                i += next.getAdapter().encodedSizeWithTag(next.getTag(), obj);
            }
        }
        int size = i + this.binding.unknownFields(m).size();
        this.binding.setCachedSerializedSize(m, size);
        return size;
    }

    public void encode(ProtoWriter protoWriter, M m) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(m, "value");
        for (FieldOrOneOfBinding next : this.fields.values()) {
            Object obj = next.get(m);
            if (obj != null) {
                next.getAdapter().encodeWithTag(protoWriter, next.getTag(), obj);
            }
        }
        protoWriter.writeBytes(this.binding.unknownFields(m));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, M m) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(m, "value");
        reverseProtoWriter.writeBytes(this.binding.unknownFields(m));
        int length = this.fieldBindingsArray.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[length];
                Object obj = fieldOrOneOfBinding.get(m);
                if (obj != null) {
                    fieldOrOneOfBinding.getAdapter().encodeWithTag(reverseProtoWriter, fieldOrOneOfBinding.getTag(), obj);
                }
                if (i >= 0) {
                    length = i;
                } else {
                    return;
                }
            }
        }
    }

    public M redact(M m) {
        Intrinsics.checkNotNullParameter(m, "value");
        B newBuilder = this.binding.newBuilder();
        for (FieldOrOneOfBinding next : this.fields.values()) {
            if (!next.getRedacted() || next.getLabel() != WireField.Label.REQUIRED) {
                boolean isMessage = next.isMessage();
                if (next.getRedacted() || (isMessage && !next.getLabel().isRepeated())) {
                    Object fromBuilder = next.getFromBuilder(newBuilder);
                    if (fromBuilder != null) {
                        next.set(newBuilder, next.getAdapter().redact(fromBuilder));
                    }
                } else if (isMessage && next.getLabel().isRepeated()) {
                    Object fromBuilder2 = next.getFromBuilder(newBuilder);
                    if (fromBuilder2 != null) {
                        next.set(newBuilder, Internal.m244redactElements((List) fromBuilder2, next.getSingleAdapter()));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                    }
                }
            } else {
                throw new UnsupportedOperationException("Field '" + next.getName() + "' in " + getType() + " is required and cannot be redacted.");
            }
        }
        this.binding.clearUnknownFields(newBuilder);
        return this.binding.build(newBuilder);
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && Intrinsics.areEqual((Object) ((RuntimeMessageAdapter) obj).messageType, (Object) this.messageType);
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public String toString(M m) {
        Intrinsics.checkNotNullParameter(m, "value");
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (FieldOrOneOfBinding fieldOrOneOfBinding : getFields().values()) {
            Object obj = fieldOrOneOfBinding.get(m);
            if (obj != null) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(fieldOrOneOfBinding.getName());
                sb.append('=');
                if (fieldOrOneOfBinding.getRedacted()) {
                    obj = REDACTED;
                }
                sb.append(obj);
                z = false;
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public M decode(ProtoReader protoReader) {
        ProtoAdapter protoAdapter;
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        Object newBuilder = newBuilder();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return this.binding.build(newBuilder);
            }
            FieldOrOneOfBinding fieldOrOneOfBinding = this.fields.get(Integer.valueOf(nextTag));
            if (fieldOrOneOfBinding != null) {
                try {
                    if (fieldOrOneOfBinding.isMap()) {
                        protoAdapter = fieldOrOneOfBinding.getAdapter();
                    } else {
                        protoAdapter = fieldOrOneOfBinding.getSingleAdapter();
                    }
                    Object decode = protoAdapter.decode(protoReader);
                    Intrinsics.checkNotNull(decode);
                    fieldOrOneOfBinding.value(newBuilder, decode);
                } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                    this.binding.addUnknownField(newBuilder, nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                }
            } else {
                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                Intrinsics.checkNotNull(peekFieldEncoding);
                this.binding.addUnknownField(newBuilder, nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
            }
        }
    }

    public final <A> void writeAllFields(M m, List<? extends A> list, A a, Function3<? super String, Object, ? super A, Unit> function3) {
        Intrinsics.checkNotNullParameter(list, "jsonAdapters");
        Intrinsics.checkNotNullParameter(function3, "encodeValue");
        int length = this.fieldBindingsArray.length;
        List list2 = null;
        boolean z = false;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = this.fieldBindingsArray[i];
            Intrinsics.checkNotNull(m);
            Object obj = fieldOrOneOfBinding.get(m);
            if (!fieldOrOneOfBinding.omitFromJson(getSyntax(), obj)) {
                if (!fieldOrOneOfBinding.getRedacted() || a == null || obj == null) {
                    function3.invoke(this.jsonNames.get(i), obj, list.get(i));
                } else {
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    list2.add(this.jsonNames.get(i));
                }
            }
            i = i2;
        }
        if (list2 != null && (!list2.isEmpty())) {
            z = true;
        }
        if (z) {
            Intrinsics.checkNotNull(a);
            function3.invoke("__redacted_fields", list2, a);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageAdapter$Companion;", "", "()V", "REDACTED", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RuntimeMessageAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
