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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/DeviceNode.AndroidAmazonExt.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: DeviceNode.kt */
public final class DeviceNode$AndroidAmazonExt$$serializer implements GeneratedSerializer<DeviceNode.AndroidAmazonExt> {
    public static final DeviceNode$AndroidAmazonExt$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DeviceNode$AndroidAmazonExt$$serializer deviceNode$AndroidAmazonExt$$serializer = new DeviceNode$AndroidAmazonExt$$serializer();
        INSTANCE = deviceNode$AndroidAmazonExt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode.AndroidAmazonExt", deviceNode$AndroidAmazonExt$$serializer, 19);
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
        pluginGeneratedSerialDescriptor.addElement("gaid", true);
        pluginGeneratedSerialDescriptor.addElement("amazonAdvertisingId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$AndroidAmazonExt$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0132, code lost:
        r8 = r8 | r9;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x025d, code lost:
        r4 = r19;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x025f, code lost:
        r6 = 18;
        r10 = r10;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fb, code lost:
        r14 = r14;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fb, code lost:
        r14 = r14;
        r10 = r10;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.DeviceNode.AndroidAmazonExt deserialize(kotlinx.serialization.encoding.Decoder r35) {
        /*
            r34 = this;
            r0 = r35
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r34.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r9 = 11
            r10 = 10
            r11 = 9
            r12 = 7
            r13 = 6
            r14 = 5
            r15 = 3
            r4 = 8
            r3 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 0
            if (r2 == 0) goto L_0x00d7
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r7, r2, r8)
            boolean r6 = r0.decodeBooleanElement(r1, r6)
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r7, r8)
            float r7 = r0.decodeFloatElement(r1, r15)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r15, r8)
            int r14 = r0.decodeIntElement(r1, r14)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r13, r15, r8)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r12, r15, r8)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r8)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r15, r8)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r15, r8)
            float r9 = r0.decodeFloatElement(r1, r9)
            r15 = 12
            int r15 = r0.decodeIntElement(r1, r15)
            r8 = 13
            boolean r8 = r0.decodeBooleanElement(r1, r8)
            r20 = r2
            r2 = 14
            int r2 = r0.decodeIntElement(r1, r2)
            r19 = r2
            r2 = 15
            boolean r2 = r0.decodeBooleanElement(r1, r2)
            kotlinx.serialization.internal.StringSerializer r18 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r21 = r2
            r2 = r18
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            r18 = r3
            r17 = r7
            r3 = 16
            r7 = 0
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r2, r7)
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r22 = r2
            r2 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r3, r7)
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3
            r16 = r6
            r6 = 18
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r6, r3, r7)
            r6 = 524287(0x7ffff, float:7.34683E-40)
            r7 = r5
            r29 = r8
            r30 = r9
            r31 = r14
            r32 = r15
            r8 = r17
            r14 = r4
            r15 = r10
            r17 = r11
            r4 = r2
            r10 = r3
            r2 = r20
            r20 = r21
            goto L_0x028d
        L_0x00d7:
            r7 = r8
            r2 = 1
            r6 = 18
            r8 = 0
            r22 = 0
            r2 = r7
            r3 = r2
            r4 = r3
            r5 = r4
            r10 = r5
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r25 = r15
            r7 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 1
        L_0x00fb:
            if (r33 == 0) goto L_0x0274
            int r9 = r0.decodeElementIndex(r1)
            switch(r9) {
                case -1: goto L_0x0265;
                case 0: goto L_0x0244;
                case 1: goto L_0x0235;
                case 2: goto L_0x021f;
                case 3: goto L_0x0210;
                case 4: goto L_0x01fa;
                case 5: goto L_0x01eb;
                case 6: goto L_0x01d7;
                case 7: goto L_0x01c2;
                case 8: goto L_0x01ac;
                case 9: goto L_0x0196;
                case 10: goto L_0x017e;
                case 11: goto L_0x0170;
                case 12: goto L_0x0162;
                case 13: goto L_0x0154;
                case 14: goto L_0x0144;
                case 15: goto L_0x0135;
                case 16: goto L_0x0124;
                case 17: goto L_0x0117;
                case 18: goto L_0x010a;
                default: goto L_0x0104;
            }
        L_0x0104:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x010a:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r6, r9, r10)
            r9 = 262144(0x40000, float:3.67342E-40)
            r8 = r8 | r9
            goto L_0x0261
        L_0x0117:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r6 = 17
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r6, r9, r11)
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0132
        L_0x0124:
            r6 = 17
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r6 = 16
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r6, r9, r4)
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x0132:
            r8 = r8 | r9
            goto L_0x025f
        L_0x0135:
            r6 = 16
            r9 = 15
            boolean r22 = r0.decodeBooleanElement(r1, r9)
            r17 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 | r17
            goto L_0x025f
        L_0x0144:
            r6 = 16
            r7 = 14
            r9 = 15
            int r17 = r0.decodeIntElement(r1, r7)
            r8 = r8 | 16384(0x4000, float:2.2959E-41)
            r7 = r17
            goto L_0x025f
        L_0x0154:
            r6 = 13
            r9 = 15
            r17 = 14
            boolean r29 = r0.decodeBooleanElement(r1, r6)
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
            goto L_0x025f
        L_0x0162:
            r6 = 12
            r9 = 15
            r17 = 14
            int r32 = r0.decodeIntElement(r1, r6)
            r8 = r8 | 4096(0x1000, float:5.74E-42)
            goto L_0x025f
        L_0x0170:
            r6 = 11
            r9 = 15
            r17 = 14
            float r30 = r0.decodeFloatElement(r1, r6)
            r8 = r8 | 2048(0x800, float:2.87E-42)
            goto L_0x025f
        L_0x017e:
            r6 = 11
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r19 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r6 = r19
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            r19 = r4
            r4 = 10
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r4, r6, r12)
            r8 = r8 | 1024(0x400, float:1.435E-42)
            goto L_0x025d
        L_0x0196:
            r19 = r4
            r4 = 10
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r6 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            r4 = 9
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r4, r6, r13)
            r8 = r8 | 512(0x200, float:7.175E-43)
            goto L_0x025d
        L_0x01ac:
            r19 = r4
            r4 = 9
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r6 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            r4 = 8
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r4, r6, r14)
            r8 = r8 | 256(0x100, float:3.59E-43)
            goto L_0x025d
        L_0x01c2:
            r19 = r4
            r4 = 8
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r6 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            r4 = 7
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r4, r6, r3)
            r8 = r8 | 128(0x80, float:1.794E-43)
            goto L_0x025d
        L_0x01d7:
            r19 = r4
            r4 = 7
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r6 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            r4 = 6
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r4, r6, r15)
            r8 = r8 | 64
            goto L_0x025d
        L_0x01eb:
            r19 = r4
            r4 = 6
            r6 = 5
            r9 = 15
            r17 = 14
            int r31 = r0.decodeIntElement(r1, r6)
            r8 = r8 | 32
            goto L_0x025d
        L_0x01fa:
            r19 = r4
            r4 = 6
            r6 = 5
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r28 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = r28
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r6 = 4
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r6, r4, r5)
            r8 = r8 | 16
            goto L_0x025d
        L_0x0210:
            r19 = r4
            r4 = 3
            r6 = 4
            r9 = 15
            r17 = 14
            float r24 = r0.decodeFloatElement(r1, r4)
            r8 = r8 | 8
            goto L_0x025d
        L_0x021f:
            r19 = r4
            r4 = 3
            r6 = 4
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r27 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = r27
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r6 = 2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r4, r2)
            r8 = r8 | 4
            goto L_0x025d
        L_0x0235:
            r19 = r4
            r4 = 1
            r6 = 2
            r9 = 15
            r17 = 14
            boolean r23 = r0.decodeBooleanElement(r1, r4)
            r8 = r8 | 2
            goto L_0x025d
        L_0x0244:
            r19 = r4
            r4 = 1
            r6 = 2
            r9 = 15
            r17 = 14
            kotlinx.serialization.internal.StringSerializer r26 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = r26
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r6 = r25
            r9 = 0
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r9, r4, r6)
            r8 = r8 | 1
            r25 = r4
        L_0x025d:
            r4 = r19
        L_0x025f:
            r6 = 18
        L_0x0261:
            r9 = 11
            goto L_0x00fb
        L_0x0265:
            r19 = r4
            r6 = r25
            r9 = 0
            r17 = 14
            r6 = 18
            r9 = 11
            r33 = 0
            goto L_0x00fb
        L_0x0274:
            r19 = r4
            r6 = r25
            r18 = r5
            r4 = r11
            r17 = r13
            r13 = r15
            r20 = r22
            r16 = r23
            r15 = r12
            r22 = r19
            r12 = r3
            r19 = r7
            r7 = r2
            r2 = r6
            r6 = r8
            r8 = r24
        L_0x028d:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.DeviceNode$AndroidAmazonExt r0 = new com.vungle.ads.internal.model.DeviceNode$AndroidAmazonExt
            r3 = r0
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r7 = (java.lang.String) r7
            r9 = r18
            java.lang.String r9 = (java.lang.String) r9
            r11 = r13
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = (java.lang.String) r12
            r13 = r14
            java.lang.String r13 = (java.lang.String) r13
            r14 = r17
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = (java.lang.String) r15
            r21 = r22
            java.lang.String r21 = (java.lang.String) r21
            r22 = r4
            java.lang.String r22 = (java.lang.String) r22
            r23 = r10
            java.lang.String r23 = (java.lang.String) r23
            r24 = 0
            r4 = r6
            r6 = r16
            r10 = r31
            r16 = r30
            r17 = r32
            r18 = r29
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode$AndroidAmazonExt$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.DeviceNode$AndroidAmazonExt");
    }

    public void serialize(Encoder encoder, DeviceNode.AndroidAmazonExt androidAmazonExt) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(androidAmazonExt, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.AndroidAmazonExt.write$Self(androidAmazonExt, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
