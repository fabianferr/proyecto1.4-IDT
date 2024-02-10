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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/RtbToken.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/RtbToken;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: RtbToken.kt */
public final class RtbToken$$serializer implements GeneratedSerializer<RtbToken> {
    public static final RtbToken$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RtbToken$$serializer rtbToken$$serializer = new RtbToken$$serializer();
        INSTANCE = rtbToken$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbToken", rtbToken$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("device", false);
        pluginGeneratedSerialDescriptor.addElement("user", true);
        pluginGeneratedSerialDescriptor.addElement("ext", true);
        pluginGeneratedSerialDescriptor.addElement("request", true);
        pluginGeneratedSerialDescriptor.addElement("ordinal_view", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RtbToken$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DeviceNode$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(CommonRequestBody$User$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CommonRequestBody$RequestExt$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(RtbRequest$$serializer.INSTANCE), IntSerializer.INSTANCE};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.RtbToken deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x0047
            com.vungle.ads.internal.model.DeviceNode$$serializer r2 = com.vungle.ads.internal.model.DeviceNode$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r7, r2, r8)
            com.vungle.ads.internal.model.CommonRequestBody$User$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$User$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r7, r8)
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer r7 = com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r7, r8)
            com.vungle.ads.internal.model.RtbRequest$$serializer r7 = com.vungle.ads.internal.model.RtbRequest$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r7, r8)
            int r4 = r0.decodeIntElement(r1, r4)
            r7 = 31
            r10 = r4
            r11 = r5
            r5 = 31
            goto L_0x00a1
        L_0x0047:
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r2 = 0
            r8 = 0
            r13 = 1
        L_0x004e:
            if (r13 == 0) goto L_0x009c
            int r14 = r0.decodeElementIndex(r1)
            r15 = -1
            if (r14 == r15) goto L_0x009a
            if (r14 == 0) goto L_0x008f
            if (r14 == r6) goto L_0x0084
            if (r14 == r5) goto L_0x0079
            if (r14 == r3) goto L_0x006e
            if (r14 != r4) goto L_0x0068
            int r2 = r0.decodeIntElement(r1, r4)
            r8 = r8 | 16
            goto L_0x004e
        L_0x0068:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x006e:
            com.vungle.ads.internal.model.RtbRequest$$serializer r14 = com.vungle.ads.internal.model.RtbRequest$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r3, r14, r12)
            r8 = r8 | 8
            goto L_0x004e
        L_0x0079:
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$RequestExt$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r5, r14, r11)
            r8 = r8 | 4
            goto L_0x004e
        L_0x0084:
            com.vungle.ads.internal.model.CommonRequestBody$User$$serializer r14 = com.vungle.ads.internal.model.CommonRequestBody$User$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r6, r14, r10)
            r8 = r8 | 2
            goto L_0x004e
        L_0x008f:
            com.vungle.ads.internal.model.DeviceNode$$serializer r14 = com.vungle.ads.internal.model.DeviceNode$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r7, r14, r9)
            r8 = r8 | 1
            goto L_0x004e
        L_0x009a:
            r13 = 0
            goto L_0x004e
        L_0x009c:
            r5 = r8
            r6 = r10
            r3 = r12
            r10 = r2
            r2 = r9
        L_0x00a1:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.RtbToken r0 = new com.vungle.ads.internal.model.RtbToken
            r1 = r2
            com.vungle.ads.internal.model.DeviceNode r1 = (com.vungle.ads.internal.model.DeviceNode) r1
            r7 = r6
            com.vungle.ads.internal.model.CommonRequestBody$User r7 = (com.vungle.ads.internal.model.CommonRequestBody.User) r7
            r8 = r11
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt r8 = (com.vungle.ads.internal.model.CommonRequestBody.RequestExt) r8
            r9 = r3
            com.vungle.ads.internal.model.RtbRequest r9 = (com.vungle.ads.internal.model.RtbRequest) r9
            r11 = 0
            r4 = r0
            r6 = r1
            r4.<init>((int) r5, (com.vungle.ads.internal.model.DeviceNode) r6, (com.vungle.ads.internal.model.CommonRequestBody.User) r7, (com.vungle.ads.internal.model.CommonRequestBody.RequestExt) r8, (com.vungle.ads.internal.model.RtbRequest) r9, (int) r10, (kotlinx.serialization.internal.SerializationConstructorMarker) r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.RtbToken$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.RtbToken");
    }

    public void serialize(Encoder encoder, RtbToken rtbToken) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(rtbToken, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        RtbToken.write$Self(rtbToken, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
