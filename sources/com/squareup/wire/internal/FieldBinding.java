package com.squareup.wire.internal;

import com.facebook.share.internal.ShareConstants;
import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 A*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001AB;\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0018\u00105\u001a\u0004\u0018\u00010\u00142\u0006\u00106\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00107J*\u00108\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J0\u00109\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00170\u00162\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0017\u0010:\u001a\u0004\u0018\u00010\u00142\u0006\u0010;\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010<J$\u0010=\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u001f\u0010>\u001a\u00020\u00172\u0006\u0010;\u001a\u00028\u00012\b\u0010?\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010@J\u001d\u0010?\u001a\u00020\u00172\u0006\u0010;\u001a\u00028\u00012\u0006\u0010?\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010@R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0014\u0010*\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0018\u0010,\u001a\u0006\u0012\u0002\b\u00030 8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\"R\u0014\u0010.\u001a\u00020/X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001aR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006B"}, d2 = {"Lcom/squareup/wire/internal/FieldBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "wireField", "Lcom/squareup/wire/WireField;", "messageType", "Ljava/lang/Class;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "writeIdentityValues", "", "(Lcom/squareup/wire/WireField;Ljava/lang/Class;Ljava/lang/reflect/Field;Ljava/lang/Class;Z)V", "adapterString", "", "builderGetter", "Lkotlin/Function1;", "", "builderSetter", "Lkotlin/Function2;", "", "declaredName", "getDeclaredName", "()Ljava/lang/String;", "instanceGetter", "isMap", "()Z", "isMessage", "keyAdapter", "Lcom/squareup/wire/ProtoAdapter;", "getKeyAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "keyAdapterString", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "getWriteIdentityValues", "get", "message", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getBuilderGetter", "getBuilderSetter", "getFromBuilder", "builder", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "getInstanceGetter", "set", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldBinding.kt */
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Regex IS_GETTER_FIELD_NAME_REGEX = new Regex("^is[^a-z].*$");
    private final String adapterString;
    private final Function1<B, Object> builderGetter;
    private final Function2<B, Object, Unit> builderSetter;
    private final String declaredName;
    private final Function1<M, Object> instanceGetter;
    private final String keyAdapterString;
    private final WireField.Label label;
    /* access modifiers changed from: private */
    public final Field messageField;
    private final String name;
    private final boolean redacted;
    private final int tag;
    private final String wireFieldJsonName;
    private final boolean writeIdentityValues;

    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    public FieldBinding(WireField wireField, Class<M> cls, Field field, Class<B> cls2, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(wireField, "wireField");
        Intrinsics.checkNotNullParameter(cls, "messageType");
        Intrinsics.checkNotNullParameter(field, "messageField");
        Intrinsics.checkNotNullParameter(cls2, "builderType");
        this.messageField = field;
        this.writeIdentityValues = z;
        this.label = wireField.label();
        String name2 = field.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "messageField.name");
        this.name = name2;
        this.wireFieldJsonName = wireField.jsonName();
        if (wireField.declaredName().length() == 0) {
            str = field.getName();
            Intrinsics.checkNotNullExpressionValue(str, "messageField.name");
        } else {
            str = wireField.declaredName();
        }
        this.declaredName = str;
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.builderSetter = getBuilderSetter(cls2, wireField);
        this.builderGetter = getBuilderGetter(cls2, wireField);
        this.instanceGetter = getInstanceGetter(cls);
    }

    public WireField.Label getLabel() {
        return this.label;
    }

    public String getName() {
        return this.name;
    }

    public String getWireFieldJsonName() {
        return this.wireFieldJsonName;
    }

    public String getDeclaredName() {
        return this.declaredName;
    }

    public int getTag() {
        return this.tag;
    }

    public boolean getRedacted() {
        return this.redacted;
    }

    public ProtoAdapter<?> getKeyAdapter() {
        return ProtoAdapter.Companion.get(this.keyAdapterString);
    }

    public ProtoAdapter<?> getSingleAdapter() {
        return ProtoAdapter.Companion.get(this.adapterString);
    }

    public boolean isMap() {
        return this.keyAdapterString.length() > 0;
    }

    public boolean isMessage() {
        Class<Message> cls = Message.class;
        KClass<?> type = getSingleAdapter().getType();
        return cls.isAssignableFrom(type == null ? null : JvmClassMappingKt.getJavaObjectType(type));
    }

    private final Function2<B, Object, Unit> getBuilderSetter(Class<?> cls, WireField wireField) {
        if (cls.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return new FieldBinding$getBuilderSetter$1(wireField);
        }
        if (wireField.label().isOneOf()) {
            Class<?> type = this.messageField.getType();
            try {
                return new FieldBinding$getBuilderSetter$2(cls.getMethod(getName(), new Class[]{type}));
            } catch (NoSuchMethodException unused) {
                throw new AssertionError("No builder method " + cls.getName() + '.' + getName() + '(' + type.getName() + ')');
            }
        } else {
            try {
                return new FieldBinding$getBuilderSetter$3(cls.getField(getName()));
            } catch (NoSuchFieldException unused2) {
                throw new AssertionError("No builder field " + cls.getName() + '.' + getName());
            }
        }
    }

    private final Function1<B, Object> getBuilderGetter(Class<?> cls, WireField wireField) {
        if (cls.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return new FieldBinding$getBuilderGetter$1(wireField);
        }
        try {
            return new FieldBinding$getBuilderGetter$2(cls.getField(getName()));
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + cls.getName() + '.' + getName());
        }
    }

    private final Function1<M, Object> getInstanceGetter(Class<M> cls) {
        if (!Modifier.isPrivate(this.messageField.getModifiers())) {
            return new FieldBinding$getInstanceGetter$2(this);
        }
        String name2 = this.messageField.getName();
        Regex regex = IS_GETTER_FIELD_NAME_REGEX;
        Intrinsics.checkNotNullExpressionValue(name2, "fieldName");
        CharSequence charSequence = name2;
        if (!regex.matches(charSequence)) {
            if (charSequence.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String upperCase = String.valueOf(name2.charAt(0)).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                sb.append(upperCase);
                String substring = name2.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                name2 = sb.toString();
            }
            name2 = Intrinsics.stringPlus("get", name2);
        }
        return new FieldBinding$getInstanceGetter$1(cls.getMethod(name2, new Class[0]));
    }

    public void value(B b, Object obj) {
        Intrinsics.checkNotNullParameter(b, "builder");
        Intrinsics.checkNotNullParameter(obj, "value");
        Class<?> cls = null;
        if (getLabel().isRepeated()) {
            Object fromBuilder = getFromBuilder(b);
            if (TypeIntrinsics.isMutableList(fromBuilder)) {
                if (fromBuilder != null) {
                    TypeIntrinsics.asMutableList(fromBuilder).add(obj);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
            } else if (fromBuilder instanceof List) {
                List mutableList = CollectionsKt.toMutableList((Collection) fromBuilder);
                mutableList.add(obj);
                set(b, (Object) mutableList);
            } else {
                if (fromBuilder != null) {
                    cls = fromBuilder.getClass();
                }
                throw new ClassCastException("Expected a list type, got " + cls + '.');
            }
        } else {
            if (this.keyAdapterString.length() > 0) {
                Object fromBuilder2 = getFromBuilder(b);
                if (TypeIntrinsics.isMutableMap(fromBuilder2)) {
                    ((Map) fromBuilder2).putAll((Map) obj);
                } else if (fromBuilder2 instanceof Map) {
                    Map mutableMap = MapsKt.toMutableMap((Map) fromBuilder2);
                    mutableMap.putAll((Map) obj);
                    set(b, (Object) mutableMap);
                } else {
                    if (fromBuilder2 != null) {
                        cls = fromBuilder2.getClass();
                    }
                    throw new ClassCastException("Expected a map type, got " + cls + '.');
                }
            } else {
                set(b, obj);
            }
        }
    }

    public void set(B b, Object obj) {
        Intrinsics.checkNotNullParameter(b, "builder");
        this.builderSetter.invoke(b, obj);
    }

    public Object get(M m) {
        Intrinsics.checkNotNullParameter(m, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.instanceGetter.invoke(m);
    }

    public Object getFromBuilder(B b) {
        Intrinsics.checkNotNullParameter(b, "builder");
        return this.builderGetter.invoke(b);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/squareup/wire/internal/FieldBinding$Companion;", "", "()V", "IS_GETTER_FIELD_NAME_REGEX", "Lkotlin/text/Regex;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldBinding.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
