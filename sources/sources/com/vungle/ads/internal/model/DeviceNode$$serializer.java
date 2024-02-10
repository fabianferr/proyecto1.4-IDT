package com.vungle.ads.internal.model;

import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
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
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/DeviceNode.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: DeviceNode.kt */
public final class DeviceNode$$serializer implements GeneratedSerializer<DeviceNode> {
    public static final DeviceNode$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DeviceNode$$serializer deviceNode$$serializer = new DeviceNode$$serializer();
        INSTANCE = deviceNode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode", deviceNode$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("make", false);
        pluginGeneratedSerialDescriptor.addElement("model", false);
        pluginGeneratedSerialDescriptor.addElement("osv", false);
        pluginGeneratedSerialDescriptor.addElement("carrier", true);
        pluginGeneratedSerialDescriptor.addElement("os", false);
        pluginGeneratedSerialDescriptor.addElement("w", false);
        pluginGeneratedSerialDescriptor.addElement(CmcdHeadersFactory.STREAMING_FORMAT_HLS, false);
        pluginGeneratedSerialDescriptor.addElement("ua", true);
        pluginGeneratedSerialDescriptor.addElement("ifa", true);
        pluginGeneratedSerialDescriptor.addElement("lmt", true);
        pluginGeneratedSerialDescriptor.addElement("ext", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DeviceNode$DeviceExt$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0108, code lost:
        r3 = 10;
        r4 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.DeviceNode deserialize(kotlinx.serialization.encoding.Decoder r25) {
        /*
            r24 = this;
            r0 = r25
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r24.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 10
            r4 = 9
            r5 = 7
            r6 = 6
            r7 = 5
            r8 = 3
            r9 = 8
            r10 = 4
            r11 = 2
            r12 = 1
            r13 = 0
            r14 = 0
            if (r2 == 0) goto L_0x0073
            java.lang.String r2 = r0.decodeStringElement(r1, r13)
            java.lang.String r12 = r0.decodeStringElement(r1, r12)
            java.lang.String r11 = r0.decodeStringElement(r1, r11)
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r13, r14)
            java.lang.String r10 = r0.decodeStringElement(r1, r10)
            int r7 = r0.decodeIntElement(r1, r7)
            int r6 = r0.decodeIntElement(r1, r6)
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r13, r14)
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r13, r14)
            kotlinx.serialization.internal.IntSerializer r13 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r13, r14)
            com.vungle.ads.internal.model.DeviceNode$DeviceExt$$serializer r13 = com.vungle.ads.internal.model.DeviceNode$DeviceExt$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r13, r14)
            r13 = 2047(0x7ff, float:2.868E-42)
            r16 = r6
            r15 = r7
            r14 = r10
            r17 = r12
            r10 = r2
            r12 = r11
            r11 = r9
            r9 = 2047(0x7ff, float:2.868E-42)
            goto L_0x0124
        L_0x0073:
            r8 = r14
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r2 = 0
            r14 = 0
            r15 = 0
            r23 = 1
        L_0x0085:
            if (r23 == 0) goto L_0x0116
            int r7 = r0.decodeElementIndex(r1)
            switch(r7) {
                case -1: goto L_0x010e;
                case 0: goto L_0x00ff;
                case 1: goto L_0x00f5;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00db;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00c8;
                case 6: goto L_0x00c0;
                case 7: goto L_0x00b5;
                case 8: goto L_0x00aa;
                case 9: goto L_0x009f;
                case 10: goto L_0x0094;
                default: goto L_0x008e;
            }
        L_0x008e:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r7)
            throw r0
        L_0x0094:
            com.vungle.ads.internal.model.DeviceNode$DeviceExt$$serializer r7 = com.vungle.ads.internal.model.DeviceNode$DeviceExt$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r3, r7, r10)
            r15 = r15 | 1024(0x400, float:1.435E-42)
            goto L_0x00c6
        L_0x009f:
            kotlinx.serialization.internal.IntSerializer r7 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r4, r7, r8)
            r15 = r15 | 512(0x200, float:7.175E-43)
            goto L_0x00c6
        L_0x00aa:
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r9, r7, r11)
            r15 = r15 | 256(0x100, float:3.59E-43)
            goto L_0x00c6
        L_0x00b5:
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r5, r7, r12)
            r15 = r15 | 128(0x80, float:1.794E-43)
            goto L_0x00c6
        L_0x00c0:
            int r2 = r0.decodeIntElement(r1, r6)
            r15 = r15 | 64
        L_0x00c6:
            r7 = 5
            goto L_0x0085
        L_0x00c8:
            r7 = 5
            int r14 = r0.decodeIntElement(r1, r7)
            r15 = r15 | 32
            goto L_0x0085
        L_0x00d0:
            r3 = 4
            r7 = 5
            java.lang.String r19 = r0.decodeStringElement(r1, r3)
            r15 = r15 | 16
            r3 = 10
            goto L_0x0085
        L_0x00db:
            r3 = 4
            r7 = 5
            kotlinx.serialization.internal.StringSerializer r22 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r3 = r22
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r4 = 3
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r4, r3, r13)
            r15 = r15 | 8
            goto L_0x0108
        L_0x00eb:
            r3 = 2
            r4 = 3
            r7 = 5
            java.lang.String r18 = r0.decodeStringElement(r1, r3)
            r15 = r15 | 4
            goto L_0x0108
        L_0x00f5:
            r3 = 1
            r4 = 3
            r7 = 5
            java.lang.String r17 = r0.decodeStringElement(r1, r3)
            r15 = r15 | 2
            goto L_0x0108
        L_0x00ff:
            r3 = 0
            r4 = 3
            r7 = 5
            java.lang.String r16 = r0.decodeStringElement(r1, r3)
            r15 = r15 | 1
        L_0x0108:
            r3 = 10
            r4 = 9
            goto L_0x0085
        L_0x010e:
            r3 = 0
            r7 = 5
            r3 = 10
            r23 = 0
            goto L_0x0085
        L_0x0116:
            r4 = r8
            r3 = r10
            r5 = r12
            r8 = r13
            r9 = r15
            r10 = r16
            r12 = r18
            r16 = r2
            r15 = r14
            r14 = r19
        L_0x0124:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.DeviceNode r0 = new com.vungle.ads.internal.model.DeviceNode
            r13 = r8
            java.lang.String r13 = (java.lang.String) r13
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            r18 = r11
            java.lang.String r18 = (java.lang.String) r18
            r19 = r4
            java.lang.Integer r19 = (java.lang.Integer) r19
            r20 = r3
            com.vungle.ads.internal.model.DeviceNode$DeviceExt r20 = (com.vungle.ads.internal.model.DeviceNode.DeviceExt) r20
            r21 = 0
            r8 = r0
            r11 = r17
            r17 = r1
            r8.<init>((int) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (int) r15, (int) r16, (java.lang.String) r17, (java.lang.String) r18, (java.lang.Integer) r19, (com.vungle.ads.internal.model.DeviceNode.DeviceExt) r20, (kotlinx.serialization.internal.SerializationConstructorMarker) r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.DeviceNode");
    }

    public void serialize(Encoder encoder, DeviceNode deviceNode) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(deviceNode, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.write$Self(deviceNode, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
