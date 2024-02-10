package com.vungle.ads.internal.model;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/AdPayload.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/AdPayload;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: AdPayload.kt */
public final class AdPayload$$serializer implements GeneratedSerializer<AdPayload> {
    public static final AdPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdPayload$$serializer adPayload$$serializer = new AdPayload$$serializer();
        INSTANCE = adPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload", adPayload$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(CampaignUnit.JSON_KEY_ADS, true);
        pluginGeneratedSerialDescriptor.addElement("mraidFiles", true);
        pluginGeneratedSerialDescriptor.addElement("incentivizedTextSettings", true);
        pluginGeneratedSerialDescriptor.addElement("assetsFullyDownloaded", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE)), new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.AdPayload deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            r7 = 0
            if (r2 == 0) goto L_0x005b
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer r8 = com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            r2.<init>(r8)
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r2, r7)
            kotlinx.serialization.internal.LinkedHashMapSerializer r6 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            r6.<init>(r8, r9)
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r6, r7)
            kotlinx.serialization.internal.LinkedHashMapSerializer r6 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            r6.<init>(r8, r9)
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r4 = r0.decodeSerializableElement(r1, r4, r6, r7)
            boolean r3 = r0.decodeBooleanElement(r1, r3)
            r6 = 15
            r8 = r3
            r10 = r4
            r4 = 15
            goto L_0x00c4
        L_0x005b:
            r8 = r7
            r9 = r8
            r10 = r9
            r2 = 0
            r7 = 0
            r11 = 1
        L_0x0061:
            if (r11 == 0) goto L_0x00bf
            int r12 = r0.decodeElementIndex(r1)
            r13 = -1
            if (r12 == r13) goto L_0x00bd
            if (r12 == 0) goto L_0x00ab
            if (r12 == r5) goto L_0x0095
            if (r12 == r4) goto L_0x007f
            if (r12 != r3) goto L_0x0079
            boolean r2 = r0.decodeBooleanElement(r1, r3)
            r7 = r7 | 8
            goto L_0x0061
        L_0x0079:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r12)
            throw r0
        L_0x007f:
            kotlinx.serialization.internal.LinkedHashMapSerializer r12 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r13 = (kotlinx.serialization.KSerializer) r13
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r14 = (kotlinx.serialization.KSerializer) r14
            r12.<init>(r13, r14)
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r4, r12, r10)
            r7 = r7 | 4
            goto L_0x0061
        L_0x0095:
            kotlinx.serialization.internal.LinkedHashMapSerializer r12 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r13 = (kotlinx.serialization.KSerializer) r13
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r14 = (kotlinx.serialization.KSerializer) r14
            r12.<init>(r13, r14)
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r5, r12, r9)
            r7 = r7 | 2
            goto L_0x0061
        L_0x00ab:
            kotlinx.serialization.internal.ArrayListSerializer r12 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer r13 = com.vungle.ads.internal.model.AdPayload$PlacementAdUnit$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r13 = (kotlinx.serialization.KSerializer) r13
            r12.<init>(r13)
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r6, r12, r8)
            r7 = r7 | 1
            goto L_0x0061
        L_0x00bd:
            r11 = 0
            goto L_0x0061
        L_0x00bf:
            r4 = r7
            r5 = r9
            r15 = r8
            r8 = r2
            r2 = r15
        L_0x00c4:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.AdPayload r0 = new com.vungle.ads.internal.model.AdPayload
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            r6 = r5
            java.util.Map r6 = (java.util.Map) r6
            r7 = r10
            java.util.Map r7 = (java.util.Map) r7
            r9 = 0
            r3 = r0
            r5 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.AdPayload");
    }

    public void serialize(Encoder encoder, AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(adPayload, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AdPayload.write$Self(adPayload, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
