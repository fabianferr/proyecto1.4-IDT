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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/BidPayload.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/BidPayload;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: BidPayload.kt */
public final class BidPayload$$serializer implements GeneratedSerializer<BidPayload> {
    public static final BidPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BidPayload$$serializer bidPayload$$serializer = new BidPayload$$serializer();
        INSTANCE = bidPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.BidPayload", bidPayload$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("version", true);
        pluginGeneratedSerialDescriptor.addElement("adunit", true);
        pluginGeneratedSerialDescriptor.addElement("impression", true);
        pluginGeneratedSerialDescriptor.addElement("ad", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BidPayload$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(AdPayload$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.BidPayload deserialize(kotlinx.serialization.encoding.Decoder r15) {
        /*
            r14 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r14.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r15 = r15.beginStructure(r0)
            boolean r1 = r15.decodeSequentially()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x0044
            kotlinx.serialization.internal.IntSerializer r1 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1
            java.lang.Object r1 = r15.decodeNullableSerializableElement(r0, r5, r1, r6)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r4 = r15.decodeNullableSerializableElement(r0, r4, r5, r6)
            kotlinx.serialization.internal.ArrayListSerializer r5 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
            r5.<init>(r7)
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r3 = r15.decodeNullableSerializableElement(r0, r3, r5, r6)
            com.vungle.ads.internal.model.AdPayload$$serializer r5 = com.vungle.ads.internal.model.AdPayload$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r2 = r15.decodeNullableSerializableElement(r0, r2, r5, r6)
            r5 = 15
            r6 = 15
            goto L_0x009b
        L_0x0044:
            r7 = r6
            r8 = r7
            r9 = r8
            r1 = 0
            r10 = 1
        L_0x0049:
            if (r10 == 0) goto L_0x0095
            int r11 = r15.decodeElementIndex(r0)
            r12 = -1
            if (r11 == r12) goto L_0x0093
            if (r11 == 0) goto L_0x0088
            if (r11 == r4) goto L_0x007d
            if (r11 == r3) goto L_0x006b
            if (r11 != r2) goto L_0x0065
            com.vungle.ads.internal.model.AdPayload$$serializer r11 = com.vungle.ads.internal.model.AdPayload$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r9 = r15.decodeNullableSerializableElement(r0, r2, r11, r9)
            r1 = r1 | 8
            goto L_0x0049
        L_0x0065:
            kotlinx.serialization.UnknownFieldException r15 = new kotlinx.serialization.UnknownFieldException
            r15.<init>((int) r11)
            throw r15
        L_0x006b:
            kotlinx.serialization.internal.ArrayListSerializer r11 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r12 = (kotlinx.serialization.KSerializer) r12
            r11.<init>(r12)
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r8 = r15.decodeNullableSerializableElement(r0, r3, r11, r8)
            r1 = r1 | 4
            goto L_0x0049
        L_0x007d:
            kotlinx.serialization.internal.StringSerializer r11 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r7 = r15.decodeNullableSerializableElement(r0, r4, r11, r7)
            r1 = r1 | 2
            goto L_0x0049
        L_0x0088:
            kotlinx.serialization.internal.IntSerializer r11 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r6 = r15.decodeNullableSerializableElement(r0, r5, r11, r6)
            r1 = r1 | 1
            goto L_0x0049
        L_0x0093:
            r10 = 0
            goto L_0x0049
        L_0x0095:
            r4 = r7
            r3 = r8
            r2 = r9
            r13 = r6
            r6 = r1
            r1 = r13
        L_0x009b:
            r15.endStructure(r0)
            com.vungle.ads.internal.model.BidPayload r15 = new com.vungle.ads.internal.model.BidPayload
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            r9 = r3
            java.util.List r9 = (java.util.List) r9
            r10 = r2
            com.vungle.ads.internal.model.AdPayload r10 = (com.vungle.ads.internal.model.AdPayload) r10
            r11 = 0
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.BidPayload$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.BidPayload");
    }

    public void serialize(Encoder encoder, BidPayload bidPayload) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(bidPayload, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        BidPayload.write$Self(bidPayload, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
