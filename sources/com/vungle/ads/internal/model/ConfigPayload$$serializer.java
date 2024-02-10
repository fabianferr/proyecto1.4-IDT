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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/ConfigPayload.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/ConfigPayload;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: ConfigPayload.kt */
public final class ConfigPayload$$serializer implements GeneratedSerializer<ConfigPayload> {
    public static final ConfigPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ConfigPayload$$serializer configPayload$$serializer = new ConfigPayload$$serializer();
        INSTANCE = configPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload", configPayload$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("endpoints", true);
        pluginGeneratedSerialDescriptor.addElement("placements", true);
        pluginGeneratedSerialDescriptor.addElement("config", true);
        pluginGeneratedSerialDescriptor.addElement("gdpr", true);
        pluginGeneratedSerialDescriptor.addElement("logging", true);
        pluginGeneratedSerialDescriptor.addElement("crash_report", true);
        pluginGeneratedSerialDescriptor.addElement("viewability", true);
        pluginGeneratedSerialDescriptor.addElement("ad_load_optimization", true);
        pluginGeneratedSerialDescriptor.addElement("ri", true);
        pluginGeneratedSerialDescriptor.addElement(Cookie.COPPA_DISABLE_AD_ID, true);
        pluginGeneratedSerialDescriptor.addElement(Cookie.CONFIG_EXTENSION, true);
        pluginGeneratedSerialDescriptor.addElement("template", true);
        pluginGeneratedSerialDescriptor.addElement("log_metrics", true);
        pluginGeneratedSerialDescriptor.addElement("session", true);
        pluginGeneratedSerialDescriptor.addElement("reuse_assets", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigPayload$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ConfigPayload$Endpoints$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(Placement$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(ConfigPayload$ConfigSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$GDPRSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$LoggingSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$CrashReportSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$ViewabilitySettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$LoadOptimizationSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$ReportIncentivizedSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$Template$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$LogMetricsSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigPayload$Session$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CleverCache$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x020e, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0253, code lost:
        r2 = r24;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.ConfigPayload deserialize(kotlinx.serialization.encoding.Decoder r45) {
        /*
            r44 = this;
            r0 = r45
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r44.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r7 = 10
            r8 = 9
            r9 = 7
            r10 = 6
            r11 = 5
            r12 = 3
            r13 = 8
            r14 = 4
            r15 = 2
            r3 = 1
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x00c4
            com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer r2 = com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r2, r5)
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.Placement$$serializer r18 = com.vungle.ads.internal.model.Placement$$serializer.INSTANCE
            r6 = r18
            kotlinx.serialization.KSerializer r6 = (kotlinx.serialization.KSerializer) r6
            r4.<init>(r6)
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r4, r5)
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r15, r4, r5)
            com.vungle.ads.internal.model.ConfigPayload$GDPRSettings$$serializer r6 = com.vungle.ads.internal.model.ConfigPayload$GDPRSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r12, r6, r5)
            com.vungle.ads.internal.model.ConfigPayload$LoggingSettings$$serializer r12 = com.vungle.ads.internal.model.ConfigPayload$LoggingSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r14, r12, r5)
            com.vungle.ads.internal.model.ConfigPayload$CrashReportSettings$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$CrashReportSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r14, r5)
            com.vungle.ads.internal.model.ConfigPayload$ViewabilitySettings$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$ViewabilitySettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r14, r5)
            com.vungle.ads.internal.model.ConfigPayload$LoadOptimizationSettings$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$LoadOptimizationSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r14, r5)
            com.vungle.ads.internal.model.ConfigPayload$ReportIncentivizedSettings$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$ReportIncentivizedSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r13, r14, r5)
            kotlinx.serialization.internal.BooleanSerializer r14 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r14, r5)
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r14, r5)
            com.vungle.ads.internal.model.ConfigPayload$Template$$serializer r14 = com.vungle.ads.internal.model.ConfigPayload$Template$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            r15 = 11
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r15, r14, r5)
            com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer r15 = com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r18 = r2
            r2 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r5)
            com.vungle.ads.internal.model.ConfigPayload$Session$$serializer r15 = com.vungle.ads.internal.model.ConfigPayload$Session$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r17 = r2
            r2 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r5)
            com.vungle.ads.internal.model.CleverCache$$serializer r15 = com.vungle.ads.internal.model.CleverCache$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r16 = r4
            r4 = 14
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r15, r5)
            r5 = 32767(0x7fff, float:4.5916E-41)
            r24 = r3
            r26 = 32767(0x7fff, float:4.5916E-41)
            r3 = r2
            r2 = r18
            r43 = r16
            r16 = r4
            r4 = r43
            goto L_0x0292
        L_0x00c4:
            r2 = 0
            r4 = 14
            r2 = r5
            r3 = r2
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r20 = r15
            r21 = r20
            r22 = r21
            r5 = 0
            r23 = 1
        L_0x00dc:
            if (r23 == 0) goto L_0x0272
            int r4 = r0.decodeElementIndex(r1)
            switch(r4) {
                case -1: goto L_0x0259;
                case 0: goto L_0x0237;
                case 1: goto L_0x0211;
                case 2: goto L_0x01fa;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01d0;
                case 5: goto L_0x01bb;
                case 6: goto L_0x01a6;
                case 7: goto L_0x018f;
                case 8: goto L_0x0177;
                case 9: goto L_0x015f;
                case 10: goto L_0x0147;
                case 11: goto L_0x012f;
                case 12: goto L_0x0111;
                case 13: goto L_0x00fb;
                case 14: goto L_0x00eb;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r4)
            throw r0
        L_0x00eb:
            com.vungle.ads.internal.model.CleverCache$$serializer r4 = com.vungle.ads.internal.model.CleverCache$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r24 = r2
            r2 = 14
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r2, r4, r6)
            r5 = r5 | 16384(0x4000, float:2.2959E-41)
            goto L_0x0253
        L_0x00fb:
            r24 = r2
            r2 = 14
            com.vungle.ads.internal.model.ConfigPayload$Session$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$Session$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r16 = r6
            r2 = r21
            r6 = 13
            java.lang.Object r21 = r0.decodeNullableSerializableElement(r1, r6, r4, r2)
            r5 = r5 | 8192(0x2000, float:1.14794E-41)
            goto L_0x020e
        L_0x0111:
            r24 = r2
            r16 = r6
            r2 = r21
            r6 = 13
            com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r17 = r2
            r6 = r20
            r2 = 12
            java.lang.Object r20 = r0.decodeNullableSerializableElement(r1, r2, r4, r6)
            r5 = r5 | 4096(0x1000, float:5.74E-42)
            r6 = r16
            r21 = r17
            goto L_0x0253
        L_0x012f:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 12
            com.vungle.ads.internal.model.ConfigPayload$Template$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$Template$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 11
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r2, r4, r7)
            r5 = r5 | 2048(0x800, float:2.87E-42)
            goto L_0x020e
        L_0x0147:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 11
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 10
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r2, r4, r8)
            r5 = r5 | 1024(0x400, float:1.435E-42)
            goto L_0x020e
        L_0x015f:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 10
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 9
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r2, r4, r13)
            r5 = r5 | 512(0x200, float:7.175E-43)
            goto L_0x020e
        L_0x0177:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 9
            com.vungle.ads.internal.model.ConfigPayload$ReportIncentivizedSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$ReportIncentivizedSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 8
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r2, r4, r9)
            r5 = r5 | 256(0x100, float:3.59E-43)
            goto L_0x020e
        L_0x018f:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 8
            com.vungle.ads.internal.model.ConfigPayload$LoadOptimizationSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$LoadOptimizationSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 7
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r2, r4, r10)
            r5 = r5 | 128(0x80, float:1.794E-43)
            goto L_0x020e
        L_0x01a6:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 7
            com.vungle.ads.internal.model.ConfigPayload$ViewabilitySettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$ViewabilitySettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 6
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r2, r4, r11)
            r5 = r5 | 64
            goto L_0x020e
        L_0x01bb:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 6
            com.vungle.ads.internal.model.ConfigPayload$CrashReportSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$CrashReportSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 5
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r2, r4, r14)
            r5 = r5 | 32
            goto L_0x020e
        L_0x01d0:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 5
            com.vungle.ads.internal.model.ConfigPayload$LoggingSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$LoggingSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 4
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r2, r4, r12)
            r5 = r5 | 16
            goto L_0x020e
        L_0x01e5:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 4
            com.vungle.ads.internal.model.ConfigPayload$GDPRSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$GDPRSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 3
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r2, r4, r15)
            r5 = r5 | 8
            goto L_0x020e
        L_0x01fa:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 3
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$ConfigSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r2 = 2
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r5 = r5 | 4
        L_0x020e:
            r6 = r16
            goto L_0x0253
        L_0x0211:
            r24 = r2
            r16 = r6
            r6 = r20
            r17 = r21
            r2 = 2
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            com.vungle.ads.internal.model.Placement$$serializer r19 = com.vungle.ads.internal.model.Placement$$serializer.INSTANCE
            r2 = r19
            kotlinx.serialization.KSerializer r2 = (kotlinx.serialization.KSerializer) r2
            r4.<init>(r2)
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r19 = r3
            r2 = r24
            r3 = 1
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r5 = r5 | 2
            r6 = r16
            r3 = r19
            goto L_0x0255
        L_0x0237:
            r19 = r3
            r16 = r6
            r6 = r20
            r17 = r21
            r3 = 1
            com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer r4 = com.vungle.ads.internal.model.ConfigPayload$Endpoints$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            r24 = r2
            r3 = r22
            r2 = 0
            java.lang.Object r22 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r5 = r5 | 1
            r6 = r16
            r3 = r19
        L_0x0253:
            r2 = r24
        L_0x0255:
            r4 = 14
            goto L_0x00dc
        L_0x0259:
            r24 = r2
            r19 = r3
            r16 = r6
            r6 = r20
            r17 = r21
            r3 = r22
            r2 = 0
            r6 = r16
            r3 = r19
            r2 = r24
            r4 = 14
            r23 = 0
            goto L_0x00dc
        L_0x0272:
            r24 = r2
            r19 = r3
            r16 = r6
            r6 = r20
            r17 = r21
            r3 = r22
            r2 = r3
            r26 = r5
            r3 = r17
            r4 = r19
            r17 = r6
            r6 = r15
            r43 = r14
            r14 = r7
            r7 = r8
            r8 = r13
            r13 = r9
            r9 = r10
            r10 = r11
            r11 = r43
        L_0x0292:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.ConfigPayload r0 = new com.vungle.ads.internal.model.ConfigPayload
            r25 = r0
            r27 = r2
            com.vungle.ads.internal.model.ConfigPayload$Endpoints r27 = (com.vungle.ads.internal.model.ConfigPayload.Endpoints) r27
            r28 = r24
            java.util.List r28 = (java.util.List) r28
            r29 = r4
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings r29 = (com.vungle.ads.internal.model.ConfigPayload.ConfigSettings) r29
            r30 = r6
            com.vungle.ads.internal.model.ConfigPayload$GDPRSettings r30 = (com.vungle.ads.internal.model.ConfigPayload.GDPRSettings) r30
            r31 = r12
            com.vungle.ads.internal.model.ConfigPayload$LoggingSettings r31 = (com.vungle.ads.internal.model.ConfigPayload.LoggingSettings) r31
            r32 = r11
            com.vungle.ads.internal.model.ConfigPayload$CrashReportSettings r32 = (com.vungle.ads.internal.model.ConfigPayload.CrashReportSettings) r32
            r33 = r10
            com.vungle.ads.internal.model.ConfigPayload$ViewabilitySettings r33 = (com.vungle.ads.internal.model.ConfigPayload.ViewabilitySettings) r33
            r34 = r9
            com.vungle.ads.internal.model.ConfigPayload$LoadOptimizationSettings r34 = (com.vungle.ads.internal.model.ConfigPayload.LoadOptimizationSettings) r34
            r35 = r13
            com.vungle.ads.internal.model.ConfigPayload$ReportIncentivizedSettings r35 = (com.vungle.ads.internal.model.ConfigPayload.ReportIncentivizedSettings) r35
            r36 = r8
            java.lang.Boolean r36 = (java.lang.Boolean) r36
            r37 = r7
            java.lang.String r37 = (java.lang.String) r37
            r38 = r14
            com.vungle.ads.internal.model.ConfigPayload$Template r38 = (com.vungle.ads.internal.model.ConfigPayload.Template) r38
            r39 = r17
            com.vungle.ads.internal.model.ConfigPayload$LogMetricsSettings r39 = (com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings) r39
            r40 = r3
            com.vungle.ads.internal.model.ConfigPayload$Session r40 = (com.vungle.ads.internal.model.ConfigPayload.Session) r40
            r41 = r16
            com.vungle.ads.internal.model.CleverCache r41 = (com.vungle.ads.internal.model.CleverCache) r41
            r42 = 0
            r25.<init>((int) r26, (com.vungle.ads.internal.model.ConfigPayload.Endpoints) r27, (java.util.List) r28, (com.vungle.ads.internal.model.ConfigPayload.ConfigSettings) r29, (com.vungle.ads.internal.model.ConfigPayload.GDPRSettings) r30, (com.vungle.ads.internal.model.ConfigPayload.LoggingSettings) r31, (com.vungle.ads.internal.model.ConfigPayload.CrashReportSettings) r32, (com.vungle.ads.internal.model.ConfigPayload.ViewabilitySettings) r33, (com.vungle.ads.internal.model.ConfigPayload.LoadOptimizationSettings) r34, (com.vungle.ads.internal.model.ConfigPayload.ReportIncentivizedSettings) r35, (java.lang.Boolean) r36, (java.lang.String) r37, (com.vungle.ads.internal.model.ConfigPayload.Template) r38, (com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings) r39, (com.vungle.ads.internal.model.ConfigPayload.Session) r40, (com.vungle.ads.internal.model.CleverCache) r41, (kotlinx.serialization.internal.SerializationConstructorMarker) r42)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.ConfigPayload$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.ConfigPayload");
    }

    public void serialize(Encoder encoder, ConfigPayload configPayload) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(configPayload, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ConfigPayload.write$Self(configPayload, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
