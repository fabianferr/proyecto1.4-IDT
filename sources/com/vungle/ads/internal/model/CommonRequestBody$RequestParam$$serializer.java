package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.CommonRequestBody;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/CommonRequestBody.RequestParam.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/CommonRequestBody$RequestParam;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: CommonRequestBody.kt */
public final class CommonRequestBody$RequestParam$$serializer implements GeneratedSerializer<CommonRequestBody.RequestParam> {
    public static final CommonRequestBody$RequestParam$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CommonRequestBody$RequestParam$$serializer commonRequestBody$RequestParam$$serializer = new CommonRequestBody$RequestParam$$serializer();
        INSTANCE = commonRequestBody$RequestParam$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.RequestParam", commonRequestBody$RequestParam$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("placements", true);
        pluginGeneratedSerialDescriptor.addElement("header_bidding", true);
        pluginGeneratedSerialDescriptor.addElement("ad_size", true);
        pluginGeneratedSerialDescriptor.addElement("adStartTime", true);
        pluginGeneratedSerialDescriptor.addElement("app_id", true);
        pluginGeneratedSerialDescriptor.addElement("placement_reference_id", true);
        pluginGeneratedSerialDescriptor.addElement("user", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$RequestParam$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.CommonRequestBody.RequestParam deserialize(kotlinx.serialization.encoding.Decoder r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r20.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 6
            r4 = 5
            r5 = 3
            r6 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == 0) goto L_0x0062
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r11 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            r2.<init>(r11)
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r10)
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r9, r10)
            kotlinx.serialization.internal.LongSerializer r9 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r9, r10)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 127(0x7f, float:1.78E-43)
            goto L_0x00e6
        L_0x0062:
            r9 = r10
            r11 = r9
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r2 = 0
            r16 = 1
        L_0x006b:
            if (r16 == 0) goto L_0x00db
            int r8 = r0.decodeElementIndex(r1)
            switch(r8) {
                case -1: goto L_0x00d5;
                case 0: goto L_0x00bd;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00a6;
                case 3: goto L_0x009b;
                case 4: goto L_0x0090;
                case 5: goto L_0x0085;
                case 6: goto L_0x007a;
                default: goto L_0x0074;
            }
        L_0x0074:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r8)
            throw r0
        L_0x007a:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r3, r8, r9)
            r2 = r2 | 64
            goto L_0x00d3
        L_0x0085:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r4, r8, r15)
            r2 = r2 | 32
            goto L_0x00d3
        L_0x0090:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r6, r8, r14)
            r2 = r2 | 16
            goto L_0x00d3
        L_0x009b:
            kotlinx.serialization.internal.LongSerializer r8 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r5, r8, r13)
            r2 = r2 | 8
            goto L_0x00d3
        L_0x00a6:
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r7, r8, r12)
            r2 = r2 | 4
            goto L_0x00d3
        L_0x00b1:
            kotlinx.serialization.internal.BooleanSerializer r8 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            r3 = 1
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r3, r8, r11)
            r2 = r2 | 2
            goto L_0x00d2
        L_0x00bd:
            r3 = 1
            kotlinx.serialization.internal.ArrayListSerializer r8 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r17 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = r17
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
            r8.<init>(r3)
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            r3 = 0
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r3, r8, r10)
            r2 = r2 | 1
        L_0x00d2:
            r3 = 6
        L_0x00d3:
            r8 = 1
            goto L_0x006b
        L_0x00d5:
            r3 = 0
            r3 = 6
            r8 = 1
            r16 = 0
            goto L_0x006b
        L_0x00db:
            r3 = r9
            r8 = r11
            r7 = r12
            r5 = r13
            r6 = r14
            r4 = r15
            r19 = r10
            r10 = r2
            r2 = r19
        L_0x00e6:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.CommonRequestBody$RequestParam r0 = new com.vungle.ads.internal.model.CommonRequestBody$RequestParam
            r11 = r2
            java.util.List r11 = (java.util.List) r11
            r12 = r8
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            r13 = r7
            java.lang.String r13 = (java.lang.String) r13
            r14 = r5
            java.lang.Long r14 = (java.lang.Long) r14
            r15 = r6
            java.lang.String r15 = (java.lang.String) r15
            r16 = r4
            java.lang.String r16 = (java.lang.String) r16
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            r18 = 0
            r9 = r0
            r9.<init>((int) r10, (java.util.List) r11, (java.lang.Boolean) r12, (java.lang.String) r13, (java.lang.Long) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (kotlinx.serialization.internal.SerializationConstructorMarker) r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.CommonRequestBody$RequestParam$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.CommonRequestBody$RequestParam");
    }

    public void serialize(Encoder encoder, CommonRequestBody.RequestParam requestParam) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(requestParam, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.RequestParam.write$Self(requestParam, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
