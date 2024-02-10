package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010)J\u0017\u0010*\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00028\u0001H&¢\u0006\u0002\u0010)J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0003J\u0010\u00100\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.H\u0002J\u001f\u00101\u001a\u0002022\u0006\u0010+\u001a\u00028\u00012\b\u0010/\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u00103J\u001d\u0010/\u001a\u0002022\u0006\u0010+\u001a\u00028\u00012\u0006\u0010/\u001a\u00020\u0003H&¢\u0006\u0002\u00103R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0012\u0010\u001b\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0012\u0010%\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0011¨\u00064"}, d2 = {"Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "M", "B", "", "()V", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "getAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "isMessage", "keyAdapter", "getKeyAdapter", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "writeIdentityValues", "getWriteIdentityValues", "get", "message", "(Ljava/lang/Object;)Ljava/lang/Object;", "getFromBuilder", "builder", "omitFromJson", "syntax", "Lcom/squareup/wire/Syntax;", "value", "omitIdentity", "set", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldOrOneOfBinding.kt */
public abstract class FieldOrOneOfBinding<M, B> {
    private final Lazy adapter$delegate = LazyKt.lazy(new FieldOrOneOfBinding$adapter$2(this));

    public abstract Object get(M m);

    public abstract String getDeclaredName();

    public abstract Object getFromBuilder(B b);

    public abstract ProtoAdapter<?> getKeyAdapter();

    public abstract WireField.Label getLabel();

    public abstract String getName();

    public abstract boolean getRedacted();

    public abstract ProtoAdapter<?> getSingleAdapter();

    public abstract int getTag();

    public abstract String getWireFieldJsonName();

    public abstract boolean getWriteIdentityValues();

    public abstract boolean isMap();

    public abstract boolean isMessage();

    public abstract void set(B b, Object obj);

    public abstract void value(B b, Object obj);

    public final ProtoAdapter<Object> getAdapter() {
        return (ProtoAdapter) this.adapter$delegate.getValue();
    }

    public final boolean omitFromJson(Syntax syntax, Object obj) {
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        if (obj == null) {
            return true;
        }
        return omitIdentity(syntax) && Intrinsics.areEqual(obj, getAdapter().getIdentity());
    }

    private final boolean omitIdentity(Syntax syntax) {
        if (getWriteIdentityValues()) {
            return false;
        }
        if (getLabel() == WireField.Label.OMIT_IDENTITY) {
            return true;
        }
        if (getLabel().isRepeated() && syntax == Syntax.PROTO_3) {
            return true;
        }
        if (!isMap() || syntax != Syntax.PROTO_3) {
            return false;
        }
        return true;
    }
}
