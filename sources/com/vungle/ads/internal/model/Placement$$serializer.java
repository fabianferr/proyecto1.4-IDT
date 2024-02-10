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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/Placement.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/Placement;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: ConfigPayload.kt */
public final class Placement$$serializer implements GeneratedSerializer<Placement> {
    public static final Placement$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Placement$$serializer placement$$serializer = new Placement$$serializer();
        INSTANCE = placement$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.Placement", placement$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("reference_id", false);
        pluginGeneratedSerialDescriptor.addElement("is_incentivized", true);
        pluginGeneratedSerialDescriptor.addElement("supported_template_types", true);
        pluginGeneratedSerialDescriptor.addElement("supported_ad_formats", true);
        pluginGeneratedSerialDescriptor.addElement("ad_refresh_duration", true);
        pluginGeneratedSerialDescriptor.addElement("header_bidding", true);
        pluginGeneratedSerialDescriptor.addElement("ad_size", true);
        pluginGeneratedSerialDescriptor.addElement("isIncentivized", true);
        pluginGeneratedSerialDescriptor.addElement("placementAdType", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Placement$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.Placement deserialize(kotlinx.serialization.encoding.Decoder r27) {
        /*
            r26 = this;
            r0 = r27
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r26.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 9
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 3
            r8 = 8
            r9 = 4
            r10 = 2
            r11 = 1
            r12 = 0
            r13 = 0
            if (r2 == 0) goto L_0x0078
            java.lang.String r2 = r0.decodeStringElement(r1, r12)
            java.lang.String r11 = r0.decodeStringElement(r1, r11)
            kotlinx.serialization.internal.BooleanSerializer r12 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r12, r13)
            kotlinx.serialization.internal.ArrayListSerializer r12 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r14 = (kotlinx.serialization.KSerializer) r14
            r12.<init>(r14)
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r7, r12, r13)
            kotlinx.serialization.internal.ArrayListSerializer r12 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r14 = (kotlinx.serialization.KSerializer) r14
            r12.<init>(r14)
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r9, r12, r13)
            int r6 = r0.decodeIntElement(r1, r6)
            boolean r5 = r0.decodeBooleanElement(r1, r5)
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r12, r13)
            boolean r8 = r0.decodeBooleanElement(r1, r8)
            java.lang.String r3 = r0.decodeStringElement(r1, r3)
            r12 = 1023(0x3ff, float:1.434E-42)
            r12 = r2
            r21 = r3
            r18 = r5
            r17 = r6
            r20 = r8
            r13 = r11
            r11 = 1023(0x3ff, float:1.434E-42)
            goto L_0x0125
        L_0x0078:
            r7 = r13
            r10 = r7
            r11 = r10
            r12 = r11
            r16 = r12
            r17 = r16
            r21 = r17
            r2 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r22 = 1
        L_0x0088:
            if (r22 == 0) goto L_0x0114
            int r9 = r0.decodeElementIndex(r1)
            switch(r9) {
                case -1: goto L_0x010c;
                case 0: goto L_0x00ff;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00d3;
                case 4: goto L_0x00be;
                case 5: goto L_0x00b7;
                case 6: goto L_0x00b0;
                case 7: goto L_0x00a5;
                case 8: goto L_0x009e;
                case 9: goto L_0x0097;
                default: goto L_0x0091;
            }
        L_0x0091:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x0097:
            java.lang.String r21 = r0.decodeStringElement(r1, r3)
            r15 = r15 | 512(0x200, float:7.175E-43)
            goto L_0x0109
        L_0x009e:
            boolean r14 = r0.decodeBooleanElement(r1, r8)
            r15 = r15 | 256(0x100, float:3.59E-43)
            goto L_0x0109
        L_0x00a5:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r4, r9, r7)
            r15 = r15 | 128(0x80, float:1.794E-43)
            goto L_0x0109
        L_0x00b0:
            boolean r2 = r0.decodeBooleanElement(r1, r5)
            r15 = r15 | 64
            goto L_0x0109
        L_0x00b7:
            int r13 = r0.decodeIntElement(r1, r6)
            r15 = r15 | 32
            goto L_0x0109
        L_0x00be:
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r24 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = r24
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
            r9.<init>(r3)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r3 = 4
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r3, r9, r10)
            r15 = r15 | 16
            goto L_0x0107
        L_0x00d3:
            r3 = 4
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r23 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = r23
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
            r9.<init>(r3)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r3 = 3
            java.lang.Object r11 = r0.decodeSerializableElement(r1, r3, r9, r11)
            r15 = r15 | 8
            goto L_0x0107
        L_0x00e9:
            r3 = 3
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r3 = 2
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r3, r9, r12)
            r15 = r15 | 4
            goto L_0x0107
        L_0x00f6:
            r3 = 2
            r9 = 1
            java.lang.String r17 = r0.decodeStringElement(r1, r9)
            r15 = r15 | 2
            goto L_0x0107
        L_0x00ff:
            r3 = 0
            r9 = 1
            java.lang.String r16 = r0.decodeStringElement(r1, r3)
            r15 = r15 | 1
        L_0x0107:
            r3 = 9
        L_0x0109:
            r9 = 4
            goto L_0x0088
        L_0x010c:
            r3 = 0
            r3 = 9
            r9 = 4
            r22 = 0
            goto L_0x0088
        L_0x0114:
            r18 = r2
            r4 = r7
            r9 = r10
            r7 = r11
            r10 = r12
            r20 = r14
            r11 = r15
            r12 = r16
            r25 = r17
            r17 = r13
            r13 = r25
        L_0x0125:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.Placement r0 = new com.vungle.ads.internal.model.Placement
            r14 = r10
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            r15 = r7
            java.util.List r15 = (java.util.List) r15
            r16 = r9
            java.util.List r16 = (java.util.List) r16
            r19 = r4
            java.lang.String r19 = (java.lang.String) r19
            r22 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.Placement$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.Placement");
    }

    public void serialize(Encoder encoder, Placement placement) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(placement, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Placement.write$Self(placement, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
