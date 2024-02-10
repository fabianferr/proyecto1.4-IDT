package com.vungle.ads.internal.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J!\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÇ\u0001R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/vungle/ads/internal/model/CleverCache;", "", "seen1", "", "enabled", "", "diskSize", "", "diskPercentage", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;)V", "getDiskPercentage$annotations", "()V", "getDiskPercentage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiskSize$annotations", "getDiskSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnabled$annotations", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/vungle/ads/internal/model/CleverCache;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: ConfigPayload.kt */
public final class CleverCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Integer diskPercentage;
    private final Long diskSize;
    private final Boolean enabled;

    public CleverCache() {
        this((Boolean) null, (Long) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CleverCache copy$default(CleverCache cleverCache, Boolean bool, Long l, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = cleverCache.enabled;
        }
        if ((i & 2) != 0) {
            l = cleverCache.diskSize;
        }
        if ((i & 4) != 0) {
            num = cleverCache.diskPercentage;
        }
        return cleverCache.copy(bool, l, num);
    }

    @SerialName("disk_percentage")
    public static /* synthetic */ void getDiskPercentage$annotations() {
    }

    @SerialName("disk_size")
    public static /* synthetic */ void getDiskSize$annotations() {
    }

    @SerialName("enabled")
    public static /* synthetic */ void getEnabled$annotations() {
    }

    public final Boolean component1() {
        return this.enabled;
    }

    public final Long component2() {
        return this.diskSize;
    }

    public final Integer component3() {
        return this.diskPercentage;
    }

    public final CleverCache copy(Boolean bool, Long l, Integer num) {
        return new CleverCache(bool, l, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CleverCache)) {
            return false;
        }
        CleverCache cleverCache = (CleverCache) obj;
        return Intrinsics.areEqual((Object) this.enabled, (Object) cleverCache.enabled) && Intrinsics.areEqual((Object) this.diskSize, (Object) cleverCache.diskSize) && Intrinsics.areEqual((Object) this.diskPercentage, (Object) cleverCache.diskPercentage);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.diskSize;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.diskPercentage;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CleverCache(enabled=" + this.enabled + ", diskSize=" + this.diskSize + ", diskPercentage=" + this.diskPercentage + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/CleverCache$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/CleverCache;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConfigPayload.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CleverCache> serializer() {
            return CleverCache$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CleverCache(int i, @SerialName("enabled") Boolean bool, @SerialName("disk_size") Long l, @SerialName("disk_percentage") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, CleverCache$$serializer.INSTANCE.getDescriptor());
        }
        this.enabled = (i & 1) == 0 ? false : bool;
        if ((i & 2) == 0) {
            this.diskSize = 1000L;
        } else {
            this.diskSize = l;
        }
        if ((i & 4) == 0) {
            this.diskPercentage = 3;
        } else {
            this.diskPercentage = num;
        }
    }

    public CleverCache(Boolean bool, Long l, Integer num) {
        this.enabled = bool;
        this.diskSize = l;
        this.diskPercentage = num;
    }

    @JvmStatic
    public static final void write$Self(CleverCache cleverCache, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        Integer num;
        Long l;
        Intrinsics.checkNotNullParameter(cleverCache, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z3 = false;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && Intrinsics.areEqual((Object) cleverCache.enabled, (Object) false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, cleverCache.enabled);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) && (l = cleverCache.diskSize) != null && l.longValue() == 1000) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, cleverCache.diskSize);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || (num = cleverCache.diskPercentage) == null || num.intValue() != 3) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, cleverCache.diskPercentage);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CleverCache(Boolean bool, Long l, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? 1000L : l, (i & 4) != 0 ? 3 : num);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Long getDiskSize() {
        return this.diskSize;
    }

    public final Integer getDiskPercentage() {
        return this.diskPercentage;
    }
}
