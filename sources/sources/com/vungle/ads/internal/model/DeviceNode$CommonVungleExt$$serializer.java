package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.DeviceNode;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/DeviceNode.CommonVungleExt.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$CommonVungleExt;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: DeviceNode.kt */
public final class DeviceNode$CommonVungleExt$$serializer implements GeneratedSerializer<DeviceNode.CommonVungleExt> {
    public static final DeviceNode$CommonVungleExt$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DeviceNode$CommonVungleExt$$serializer deviceNode$CommonVungleExt$$serializer = new DeviceNode$CommonVungleExt$$serializer();
        INSTANCE = deviceNode$CommonVungleExt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode.CommonVungleExt", deviceNode$CommonVungleExt$$serializer, 17);
        pluginGeneratedSerialDescriptor.addElement("android_id", true);
        pluginGeneratedSerialDescriptor.addElement("is_google_play_services_available", true);
        pluginGeneratedSerialDescriptor.addElement("app_set_id", true);
        pluginGeneratedSerialDescriptor.addElement("battery_level", true);
        pluginGeneratedSerialDescriptor.addElement("battery_state", true);
        pluginGeneratedSerialDescriptor.addElement("battery_saver_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("connection_type", true);
        pluginGeneratedSerialDescriptor.addElement("connection_type_detail", true);
        pluginGeneratedSerialDescriptor.addElement("locale", true);
        pluginGeneratedSerialDescriptor.addElement("language", true);
        pluginGeneratedSerialDescriptor.addElement("time_zone", true);
        pluginGeneratedSerialDescriptor.addElement("volume_level", true);
        pluginGeneratedSerialDescriptor.addElement("sound_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("is_tv", true);
        pluginGeneratedSerialDescriptor.addElement("sd_card_available", true);
        pluginGeneratedSerialDescriptor.addElement("is_sideload_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("os_name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$CommonVungleExt$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0156, code lost:
        r5 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x01f1, code lost:
        r5 = 16;
        r7 = 11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.DeviceNode.CommonVungleExt deserialize(kotlinx.serialization.encoding.Decoder r33) {
        /*
            r32 = this;
            r0 = r33
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r32.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r7 = 11
            r8 = 10
            r9 = 9
            r10 = 7
            r11 = 6
            r12 = 5
            r13 = 3
            r15 = 8
            r14 = 4
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x00c4
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r6)
            boolean r4 = r0.decodeBooleanElement(r1, r4)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r5, r6)
            float r5 = r0.decodeFloatElement(r1, r13)
            kotlinx.serialization.internal.StringSerializer r13 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r14, r13, r6)
            int r12 = r0.decodeIntElement(r1, r12)
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r14, r6)
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r14, r6)
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r15, r14, r6)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r15, r6)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r15, r6)
            float r7 = r0.decodeFloatElement(r1, r7)
            r15 = 12
            int r15 = r0.decodeIntElement(r1, r15)
            r6 = 13
            boolean r6 = r0.decodeBooleanElement(r1, r6)
            r18 = r2
            r2 = 14
            int r2 = r0.decodeIntElement(r1, r2)
            r17 = r2
            r2 = 15
            boolean r2 = r0.decodeBooleanElement(r1, r2)
            kotlinx.serialization.internal.StringSerializer r16 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r19 = r2
            r2 = r16
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            r33 = r4
            r16 = r5
            r4 = 0
            r5 = 16
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r5, r2, r4)
            r4 = 131071(0x1ffff, float:1.8367E-40)
            r4 = r2
            r28 = r7
            r29 = r12
            r30 = r15
            r2 = r18
            r20 = r19
            r18 = r6
            r15 = r8
            r12 = r10
            r19 = r17
            r8 = 131071(0x1ffff, float:1.8367E-40)
            r10 = r33
            r6 = r3
            r17 = r14
            r14 = r9
            goto L_0x023b
        L_0x00c4:
            r4 = r6
            r2 = 1
            r5 = 16
            r6 = 0
            r20 = 0
            r2 = r4
            r3 = r2
            r10 = r3
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r23 = r15
            r4 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 1
        L_0x00e6:
            if (r31 == 0) goto L_0x0226
            int r9 = r0.decodeElementIndex(r1)
            switch(r9) {
                case -1: goto L_0x0215;
                case 0: goto L_0x01f6;
                case 1: goto L_0x01e5;
                case 2: goto L_0x01d1;
                case 3: goto L_0x01c4;
                case 4: goto L_0x01b0;
                case 5: goto L_0x01a3;
                case 6: goto L_0x0192;
                case 7: goto L_0x0180;
                case 8: goto L_0x016c;
                case 9: goto L_0x015a;
                case 10: goto L_0x0144;
                case 11: goto L_0x0137;
                case 12: goto L_0x012a;
                case 13: goto L_0x011d;
                case 14: goto L_0x010f;
                case 15: goto L_0x0102;
                case 16: goto L_0x00f5;
                default: goto L_0x00ef;
            }
        L_0x00ef:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x00f5:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r5, r9, r15)
            r9 = 65536(0x10000, float:9.18355E-41)
            r6 = r6 | r9
            goto L_0x0211
        L_0x0102:
            r9 = 15
            boolean r20 = r0.decodeBooleanElement(r1, r9)
            r16 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 | r16
            goto L_0x0211
        L_0x010f:
            r4 = 14
            r9 = 15
            int r16 = r0.decodeIntElement(r1, r4)
            r6 = r6 | 16384(0x4000, float:2.2959E-41)
            r4 = r16
            goto L_0x0211
        L_0x011d:
            r5 = 13
            r9 = 15
            r16 = 14
            boolean r27 = r0.decodeBooleanElement(r1, r5)
            r6 = r6 | 8192(0x2000, float:1.14794E-41)
            goto L_0x0156
        L_0x012a:
            r5 = 12
            r9 = 15
            r16 = 14
            int r30 = r0.decodeIntElement(r1, r5)
            r6 = r6 | 4096(0x1000, float:5.74E-42)
            goto L_0x0156
        L_0x0137:
            r5 = 12
            r9 = 15
            r16 = 14
            float r28 = r0.decodeFloatElement(r1, r7)
            r6 = r6 | 2048(0x800, float:2.87E-42)
            goto L_0x0156
        L_0x0144:
            r5 = 12
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r19 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r5 = r19
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r8, r5, r10)
            r6 = r6 | 1024(0x400, float:1.435E-42)
        L_0x0156:
            r5 = 16
            goto L_0x0211
        L_0x015a:
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 9
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r7, r5, r11)
            r6 = r6 | 512(0x200, float:7.175E-43)
            goto L_0x01f1
        L_0x016c:
            r7 = 9
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 8
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r7, r5, r12)
            r6 = r6 | 256(0x100, float:3.59E-43)
            goto L_0x01f1
        L_0x0180:
            r7 = 8
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 7
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r7, r5, r14)
            r6 = r6 | 128(0x80, float:1.794E-43)
            goto L_0x01f1
        L_0x0192:
            r7 = 7
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 6
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r7, r5, r13)
            r6 = r6 | 64
            goto L_0x01f1
        L_0x01a3:
            r5 = 5
            r7 = 6
            r9 = 15
            r16 = 14
            int r29 = r0.decodeIntElement(r1, r5)
            r6 = r6 | 32
            goto L_0x01f1
        L_0x01b0:
            r5 = 5
            r7 = 6
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r26 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r5 = r26
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 4
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r7, r5, r3)
            r6 = r6 | 16
            goto L_0x01f1
        L_0x01c4:
            r5 = 3
            r7 = 4
            r9 = 15
            r16 = 14
            float r22 = r0.decodeFloatElement(r1, r5)
            r6 = r6 | 8
            goto L_0x01f1
        L_0x01d1:
            r5 = 3
            r7 = 4
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r25 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r5 = r25
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r7, r5, r2)
            r6 = r6 | 4
            goto L_0x01f1
        L_0x01e5:
            r5 = 1
            r7 = 2
            r9 = 15
            r16 = 14
            boolean r21 = r0.decodeBooleanElement(r1, r5)
            r6 = r6 | 2
        L_0x01f1:
            r5 = 16
            r7 = 11
            goto L_0x0211
        L_0x01f6:
            r5 = 1
            r7 = 2
            r9 = 15
            r16 = 14
            kotlinx.serialization.internal.StringSerializer r24 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r5 = r24
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = r23
            r8 = 0
            java.lang.Object r23 = r0.decodeNullableSerializableElement(r1, r8, r5, r7)
            r6 = r6 | 1
            r5 = 16
            r7 = 11
            r8 = 10
        L_0x0211:
            r9 = 9
            goto L_0x00e6
        L_0x0215:
            r7 = r23
            r8 = 0
            r9 = 15
            r16 = 14
            r7 = 11
            r8 = 10
            r9 = 9
            r31 = 0
            goto L_0x00e6
        L_0x0226:
            r7 = r23
            r19 = r4
            r8 = r6
            r17 = r12
            r12 = r14
            r4 = r15
            r16 = r22
            r18 = r27
            r6 = r2
            r2 = r7
            r15 = r10
            r14 = r11
            r11 = r13
            r10 = r21
            r13 = r3
        L_0x023b:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.DeviceNode$CommonVungleExt r0 = new com.vungle.ads.internal.model.DeviceNode$CommonVungleExt
            r3 = r0
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            r9 = r13
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = (java.lang.String) r12
            r13 = r17
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = (java.lang.String) r15
            r21 = r4
            java.lang.String r21 = (java.lang.String) r21
            r22 = 0
            r4 = r8
            r6 = r10
            r8 = r16
            r10 = r29
            r16 = r28
            r17 = r30
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode$CommonVungleExt$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.DeviceNode$CommonVungleExt");
    }

    public void serialize(Encoder encoder, DeviceNode.CommonVungleExt commonVungleExt) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(commonVungleExt, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.CommonVungleExt.write$Self(commonVungleExt, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
