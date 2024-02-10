package com.vungle.ads.internal.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/CleverCache.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/CleverCache;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: ConfigPayload.kt */
public final class CleverCache$$serializer implements GeneratedSerializer<CleverCache> {
    public static final CleverCache$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CleverCache$$serializer cleverCache$$serializer = new CleverCache$$serializer();
        INSTANCE = cleverCache$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CleverCache", cleverCache$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("enabled", true);
        pluginGeneratedSerialDescriptor.addElement("disk_size", true);
        pluginGeneratedSerialDescriptor.addElement("disk_percentage", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CleverCache$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.CleverCache deserialize(kotlinx.serialization.encoding.Decoder r13) {
        /*
            r12 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r12.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r13 = r13.beginStructure(r0)
            boolean r1 = r13.decodeSequentially()
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x0032
            kotlinx.serialization.internal.BooleanSerializer r1 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1
            java.lang.Object r1 = r13.decodeNullableSerializableElement(r0, r4, r1, r5)
            kotlinx.serialization.internal.LongSerializer r4 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r3 = r13.decodeNullableSerializableElement(r0, r3, r4, r5)
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r2 = r13.decodeNullableSerializableElement(r0, r2, r4, r5)
            r4 = 7
            r5 = 7
            goto L_0x0073
        L_0x0032:
            r6 = r5
            r7 = r6
            r1 = 0
            r8 = 1
        L_0x0036:
            if (r8 == 0) goto L_0x006e
            int r9 = r13.decodeElementIndex(r0)
            r10 = -1
            if (r9 == r10) goto L_0x006c
            if (r9 == 0) goto L_0x0061
            if (r9 == r3) goto L_0x0056
            if (r9 != r2) goto L_0x0050
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r7 = r13.decodeNullableSerializableElement(r0, r2, r9, r7)
            r1 = r1 | 4
            goto L_0x0036
        L_0x0050:
            kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
            r13.<init>((int) r9)
            throw r13
        L_0x0056:
            kotlinx.serialization.internal.LongSerializer r9 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r6 = r13.decodeNullableSerializableElement(r0, r3, r9, r6)
            r1 = r1 | 2
            goto L_0x0036
        L_0x0061:
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r5 = r13.decodeNullableSerializableElement(r0, r4, r9, r5)
            r1 = r1 | 1
            goto L_0x0036
        L_0x006c:
            r8 = 0
            goto L_0x0036
        L_0x006e:
            r3 = r6
            r2 = r7
            r11 = r5
            r5 = r1
            r1 = r11
        L_0x0073:
            r13.endStructure(r0)
            com.vungle.ads.internal.model.CleverCache r13 = new com.vungle.ads.internal.model.CleverCache
            r6 = r1
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            r7 = r3
            java.lang.Long r7 = (java.lang.Long) r7
            r8 = r2
            java.lang.Integer r8 = (java.lang.Integer) r8
            r9 = 0
            r4 = r13
            r4.<init>((int) r5, (java.lang.Boolean) r6, (java.lang.Long) r7, (java.lang.Integer) r8, (kotlinx.serialization.internal.SerializationConstructorMarker) r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.CleverCache$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.CleverCache");
    }

    public void serialize(Encoder encoder, CleverCache cleverCache) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(cleverCache, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CleverCache.write$Self(cleverCache, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
