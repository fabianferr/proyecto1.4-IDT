package com.squareup.wire;

import com.squareup.wire.OneOf.Key;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0001\"B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÖ\u0003J!\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0002\u0010\u001d2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0002¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0018HÖ\u0001J\b\u0010 \u001a\u00020!H\u0016R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/squareup/wire/OneOf;", "K", "Lcom/squareup/wire/OneOf$Key;", "T", "", "key", "value", "(Lcom/squareup/wire/OneOf$Key;Ljava/lang/Object;)V", "getKey", "()Lcom/squareup/wire/OneOf$Key;", "Lcom/squareup/wire/OneOf$Key;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Lcom/squareup/wire/OneOf$Key;Ljava/lang/Object;)Lcom/squareup/wire/OneOf;", "encodeWithTag", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSizeWithTag", "", "equals", "", "other", "getOrNull", "X", "(Lcom/squareup/wire/OneOf$Key;)Ljava/lang/Object;", "hashCode", "toString", "", "Key", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OneOf.kt */
public final class OneOf<K extends Key<T>, T> {
    private final K key;
    private final T value;

    public static /* synthetic */ OneOf copy$default(OneOf oneOf, K k, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            k = oneOf.key;
        }
        if ((i & 2) != 0) {
            t = oneOf.value;
        }
        return oneOf.copy(k, t);
    }

    public final K component1() {
        return this.key;
    }

    public final T component2() {
        return this.value;
    }

    public final OneOf<K, T> copy(K k, T t) {
        Intrinsics.checkNotNullParameter(k, "key");
        return new OneOf<>(k, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OneOf)) {
            return false;
        }
        OneOf oneOf = (OneOf) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) oneOf.key) && Intrinsics.areEqual((Object) this.value, (Object) oneOf.value);
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        T t = this.value;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public OneOf(K k, T t) {
        Intrinsics.checkNotNullParameter(k, "key");
        this.key = k;
        this.value = t;
    }

    public final K getKey() {
        return this.key;
    }

    public final T getValue() {
        return this.value;
    }

    public final <X> X getOrNull(Key<X> key2) {
        Intrinsics.checkNotNullParameter(key2, "key");
        if (Intrinsics.areEqual((Object) this.key, (Object) key2)) {
            return this.value;
        }
        return null;
    }

    public String toString() {
        String str;
        ProtoAdapter adapter = this.key.getAdapter();
        if (Intrinsics.areEqual((Object) adapter, (Object) ProtoAdapter.STRING) ? true : Intrinsics.areEqual((Object) adapter, (Object) ProtoAdapter.STRING_VALUE)) {
            str = Internal.sanitize(String.valueOf(this.value));
        } else {
            str = String.valueOf(this.value);
        }
        return this.key.getDeclaredName() + '=' + str;
    }

    public final int encodedSizeWithTag() {
        return this.key.getAdapter().encodedSizeWithTag(this.key.getTag(), this.value);
    }

    public final void encodeWithTag(ProtoWriter protoWriter) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        this.key.getAdapter().encodeWithTag(protoWriter, this.key.getTag(), this.value);
    }

    public final void encodeWithTag(ReverseProtoWriter reverseProtoWriter) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        this.key.getAdapter().encodeWithTag(reverseProtoWriter, this.key.getTag(), this.value);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/squareup/wire/OneOf$Key;", "T", "", "tag", "", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "declaredName", "", "redacted", "", "jsonName", "(ILcom/squareup/wire/ProtoAdapter;Ljava/lang/String;ZLjava/lang/String;)V", "getAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "getDeclaredName", "()Ljava/lang/String;", "getJsonName", "getRedacted", "()Z", "getTag", "()I", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OneOf.kt */
    public static abstract class Key<T> {
        private final ProtoAdapter<T> adapter;
        private final String declaredName;
        private final String jsonName;
        private final boolean redacted;
        private final int tag;

        public Key(int i, ProtoAdapter<T> protoAdapter, String str, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
            Intrinsics.checkNotNullParameter(str, "declaredName");
            Intrinsics.checkNotNullParameter(str2, "jsonName");
            this.tag = i;
            this.adapter = protoAdapter;
            this.declaredName = str;
            this.redacted = z;
            this.jsonName = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Key(int i, ProtoAdapter protoAdapter, String str, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, protoAdapter, str, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "" : str2);
        }

        public final int getTag() {
            return this.tag;
        }

        public final ProtoAdapter<T> getAdapter() {
            return this.adapter;
        }

        public final String getDeclaredName() {
            return this.declaredName;
        }

        public final boolean getRedacted() {
            return this.redacted;
        }

        public final String getJsonName() {
            return this.jsonName;
        }
    }
}
