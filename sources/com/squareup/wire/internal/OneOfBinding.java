package com.squareup.wire.internal;

import com.facebook.share.internal.ShareConstants;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B1\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010/\u001a\u0004\u0018\u00010%2\u0006\u00100\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u0017\u00102\u001a\u0004\u0018\u00010%2\u0006\u00103\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00104J\u001f\u00105\u001a\u0002062\u0006\u00103\u001a\u00028\u00012\b\u00107\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u00108J\u001d\u00107\u001a\u0002062\u0006\u00103\u001a\u00028\u00012\u0006\u00107\u001a\u00020%H\u0016¢\u0006\u0002\u00108R\u000e\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0013R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0015¨\u00069"}, d2 = {"Lcom/squareup/wire/internal/OneOfBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "Ljava/lang/Class;", "key", "Lcom/squareup/wire/OneOf$Key;", "writeIdentityValues", "", "(Ljava/lang/reflect/Field;Ljava/lang/Class;Lcom/squareup/wire/OneOf$Key;Z)V", "builderField", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "()Z", "isMessage", "keyAdapter", "", "getKeyAdapter", "()Ljava/lang/Void;", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "Lcom/squareup/wire/ProtoAdapter;", "", "getSingleAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "getWriteIdentityValues", "get", "message", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getFromBuilder", "builder", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "set", "", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OneOfBinding.kt */
public final class OneOfBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    private final Field builderField;
    private final OneOf.Key<?> key;
    private final Field messageField;
    private final boolean writeIdentityValues;

    public boolean isMap() {
        return false;
    }

    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    public OneOfBinding(Field field, Class<B> cls, OneOf.Key<?> key2, boolean z) {
        Intrinsics.checkNotNullParameter(field, "messageField");
        Intrinsics.checkNotNullParameter(cls, "builderType");
        Intrinsics.checkNotNullParameter(key2, "key");
        this.messageField = field;
        this.key = key2;
        this.writeIdentityValues = z;
        Field declaredField = cls.getDeclaredField(field.getName());
        Intrinsics.checkNotNullExpressionValue(declaredField, "builderType.getDeclaredField(messageField.name)");
        this.builderField = declaredField;
    }

    public int getTag() {
        return this.key.getTag();
    }

    public WireField.Label getLabel() {
        return WireField.Label.OPTIONAL;
    }

    public boolean getRedacted() {
        return this.key.getRedacted();
    }

    public String getWireFieldJsonName() {
        return this.key.getJsonName();
    }

    public String getName() {
        return this.key.getDeclaredName();
    }

    public String getDeclaredName() {
        return this.key.getDeclaredName();
    }

    public boolean isMessage() {
        Class<Message> cls = Message.class;
        KClass<?> type = getSingleAdapter().getType();
        return cls.isAssignableFrom(type == null ? null : JvmClassMappingKt.getJavaObjectType(type));
    }

    public Void getKeyAdapter() {
        throw new IllegalStateException("not a map".toString());
    }

    public ProtoAdapter<Object> getSingleAdapter() {
        return this.key.getAdapter();
    }

    public void value(B b, Object obj) {
        Intrinsics.checkNotNullParameter(b, "builder");
        Intrinsics.checkNotNullParameter(obj, "value");
        set(b, obj);
    }

    public void set(B b, Object obj) {
        Intrinsics.checkNotNullParameter(b, "builder");
        Field field = this.builderField;
        OneOf.Key<?> key2 = this.key;
        Intrinsics.checkNotNull(obj);
        field.set(b, new OneOf(key2, obj));
    }

    public Object get(M m) {
        Intrinsics.checkNotNullParameter(m, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        OneOf oneOf = (OneOf) this.messageField.get(m);
        if (oneOf == null) {
            return null;
        }
        return oneOf.getOrNull(this.key);
    }

    public Object getFromBuilder(B b) {
        Intrinsics.checkNotNullParameter(b, "builder");
        OneOf oneOf = (OneOf) this.builderField.get(b);
        if (oneOf == null) {
            return null;
        }
        return oneOf.getOrNull(this.key);
    }
}
