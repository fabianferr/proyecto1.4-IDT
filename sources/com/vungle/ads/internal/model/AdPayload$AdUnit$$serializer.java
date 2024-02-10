package com.vungle.ads.internal.model;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.model.AdPayload;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/AdPayload.AdUnit.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: AdPayload.kt */
public final class AdPayload$AdUnit$$serializer implements GeneratedSerializer<AdPayload.AdUnit> {
    public static final AdPayload$AdUnit$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdPayload$AdUnit$$serializer adPayload$AdUnit$$serializer = new AdPayload$AdUnit$$serializer();
        INSTANCE = adPayload$AdUnit$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.AdUnit", adPayload$AdUnit$$serializer, 26);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("adType", true);
        pluginGeneratedSerialDescriptor.addElement("adSource", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.CAMPAIGN, true);
        pluginGeneratedSerialDescriptor.addElement("expiry", true);
        pluginGeneratedSerialDescriptor.addElement("app_id", true);
        pluginGeneratedSerialDescriptor.addElement("callToActionUrl", true);
        pluginGeneratedSerialDescriptor.addElement("deeplinkUrl", true);
        pluginGeneratedSerialDescriptor.addElement("click_coordinates_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("tpat", true);
        pluginGeneratedSerialDescriptor.addElement("templateURL", true);
        pluginGeneratedSerialDescriptor.addElement("templateId", true);
        pluginGeneratedSerialDescriptor.addElement("template_type", true);
        pluginGeneratedSerialDescriptor.addElement("templateSettings", true);
        pluginGeneratedSerialDescriptor.addElement("bid_token", true);
        pluginGeneratedSerialDescriptor.addElement("ad_market_id", true);
        pluginGeneratedSerialDescriptor.addElement("info", true);
        pluginGeneratedSerialDescriptor.addElement("sleep", true);
        pluginGeneratedSerialDescriptor.addElement("viewability", true);
        pluginGeneratedSerialDescriptor.addElement("adExt", true);
        pluginGeneratedSerialDescriptor.addElement("notification", true);
        pluginGeneratedSerialDescriptor.addElement("load_ad", true);
        pluginGeneratedSerialDescriptor.addElement(CampaignEx.JSON_KEY_TIMESTAMP, true);
        pluginGeneratedSerialDescriptor.addElement("showCloseIncentivized", true);
        pluginGeneratedSerialDescriptor.addElement("showClose", true);
        pluginGeneratedSerialDescriptor.addElement(NativeProtocol.BRIDGE_ARG_ERROR_CODE, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$AdUnit$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload.TpatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload$TemplateSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload$Viewability$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0200, code lost:
        r8 = r8 | r9;
        r14 = r14;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x026a, code lost:
        r8 = r8 | r9;
        r6 = r66;
        r14 = r14;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x026d, code lost:
        r10 = r50;
        r9 = r51;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0533, code lost:
        r9 = r6;
        r2 = r21;
        r3 = r22;
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0567, code lost:
        r6 = r66;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0188, code lost:
        r14 = r14;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0188, code lost:
        r14 = r14;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0188, code lost:
        r14 = r14;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.vungle.ads.internal.model.AdPayload.AdUnit deserialize(kotlinx.serialization.encoding.Decoder r66) {
        /*
            r65 = this;
            r0 = r66
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r65.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r11 = 11
            r12 = 10
            r13 = 9
            r14 = 7
            r15 = 6
            r3 = 5
            r4 = 3
            r6 = 8
            r5 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == 0) goto L_0x015c
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r9, r10)
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r15, r9, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r14, r15, r10)
            kotlinx.serialization.internal.BooleanSerializer r15 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r15, r10)
            com.vungle.ads.internal.model.AdPayload$TpatSerializer r15 = com.vungle.ads.internal.model.AdPayload.TpatSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r13, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r12, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r24 = r2
            r2 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer r15 = com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r23 = r2
            r2 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r22 = r2
            r2 = 14
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r21 = r2
            r2 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r20 = r2
            r2 = 16
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r19 = r2
            r2 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            com.vungle.ads.internal.model.AdPayload$Viewability$$serializer r15 = com.vungle.ads.internal.model.AdPayload$Viewability$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r18 = r2
            r2 = 18
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r17 = r2
            r2 = 19
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.ArrayListSerializer r15 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r16 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r10 = r16
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            r15.<init>(r10)
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r66 = r9
            r9 = 0
            r10 = 20
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r10, r15, r9)
            kotlinx.serialization.internal.ArrayListSerializer r15 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r16 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r9 = r16
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            r15.<init>(r9)
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r9 = 21
            r16 = r8
            r8 = 0
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r15, r8)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r25 = r2
            r2 = 22
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r26 = r2
            r2 = 23
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r27 = r2
            r2 = 24
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r28 = r2
            r2 = 25
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r8)
            r8 = 67108863(0x3ffffff, float:1.5046327E-36)
            r34 = r11
            r33 = r12
            r30 = r14
            r8 = r16
            r35 = r23
            r12 = r28
            r37 = 67108863(0x3ffffff, float:1.5046327E-36)
            r11 = r2
            r14 = r9
            r2 = r24
            r9 = r66
            goto L_0x05b3
        L_0x015c:
            r8 = r10
            r2 = 1
            r2 = r8
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r36 = r15
            r37 = r36
            r38 = r37
            r39 = r38
            r40 = r39
            r41 = r40
            r42 = r41
            r43 = r42
            r44 = r43
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r8 = 0
            r49 = 1
        L_0x0188:
            if (r49 == 0) goto L_0x056b
            r50 = r10
            int r10 = r0.decodeElementIndex(r1)
            switch(r10) {
                case -1: goto L_0x053b;
                case 0: goto L_0x0502;
                case 1: goto L_0x04c6;
                case 2: goto L_0x048c;
                case 3: goto L_0x0454;
                case 4: goto L_0x041e;
                case 5: goto L_0x03ea;
                case 6: goto L_0x03b8;
                case 7: goto L_0x0387;
                case 8: goto L_0x0357;
                case 9: goto L_0x0329;
                case 10: goto L_0x02fd;
                case 11: goto L_0x02d3;
                case 12: goto L_0x02b4;
                case 13: goto L_0x0293;
                case 14: goto L_0x0273;
                case 15: goto L_0x0255;
                case 16: goto L_0x0240;
                case 17: goto L_0x022b;
                case 18: goto L_0x0216;
                case 19: goto L_0x0203;
                case 20: goto L_0x01eb;
                case 21: goto L_0x01d5;
                case 22: goto L_0x01c6;
                case 23: goto L_0x01b7;
                case 24: goto L_0x01a8;
                case 25: goto L_0x0199;
                default: goto L_0x0193;
            }
        L_0x0193:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r10)
            throw r0
        L_0x0199:
            kotlinx.serialization.internal.IntSerializer r10 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            r51 = r9
            r9 = 25
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r9, r10, r11)
            r9 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0200
        L_0x01a8:
            r51 = r9
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r10 = 24
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r10, r9, r12)
            r9 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x0200
        L_0x01b7:
            r51 = r9
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r10 = 23
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r10, r9, r13)
            r9 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0200
        L_0x01c6:
            r51 = r9
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r10 = 22
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r10, r9, r6)
            r9 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0200
        L_0x01d5:
            r51 = r9
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            r9.<init>(r10)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r10 = 21
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r10, r9, r14)
            r9 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x0200
        L_0x01eb:
            r51 = r9
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            r9.<init>(r10)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r10 = 20
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r10, r9, r15)
            r9 = 1048576(0x100000, float:1.469368E-39)
        L_0x0200:
            r8 = r8 | r9
            goto L_0x026d
        L_0x0203:
            r51 = r9
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r66 = r6
            r6 = 19
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r6, r9, r3)
            r9 = 524288(0x80000, float:7.34684E-40)
            goto L_0x026a
        L_0x0216:
            r66 = r6
            r51 = r9
            r6 = 19
            r10 = 20
            com.vungle.ads.internal.model.AdPayload$Viewability$$serializer r9 = com.vungle.ads.internal.model.AdPayload$Viewability$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r6 = 18
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r6, r9, r5)
            r9 = 262144(0x40000, float:3.67342E-40)
            goto L_0x026a
        L_0x022b:
            r66 = r6
            r51 = r9
            r6 = 18
            r10 = 20
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r6 = 17
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r6, r9, r4)
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x026a
        L_0x0240:
            r66 = r6
            r51 = r9
            r6 = 17
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r6 = 16
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r6, r9, r7)
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x026a
        L_0x0255:
            r66 = r6
            r51 = r9
            r6 = 16
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r6 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r6, r9, r2)
            r9 = 32768(0x8000, float:4.5918E-41)
        L_0x026a:
            r8 = r8 | r9
            r6 = r66
        L_0x026d:
            r10 = r50
            r9 = r51
            goto L_0x0188
        L_0x0273:
            r66 = r6
            r51 = r9
            r6 = 15
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r21 = r2
            r6 = r51
            r2 = 14
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r2, r9, r6)
            r8 = r8 | 16384(0x4000, float:2.2959E-41)
            r6 = r66
            r2 = r21
            r10 = r50
            goto L_0x0188
        L_0x0293:
            r21 = r2
            r66 = r6
            r6 = r9
            r2 = 14
            r10 = 20
            com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer r9 = com.vungle.ads.internal.model.AdPayload$TemplateSettings$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r22 = r3
            r2 = r50
            r3 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
            r10 = r2
            r9 = r6
            r2 = r21
            r3 = r22
            goto L_0x0567
        L_0x02b4:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r50
            r3 = 13
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r23 = r2
            r3 = r48
            r2 = 12
            java.lang.Object r48 = r0.decodeNullableSerializableElement(r1, r2, r9, r3)
            r8 = r8 | 4096(0x1000, float:5.74E-42)
            goto L_0x0533
        L_0x02d3:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r48
            r23 = r50
            r2 = 12
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r35 = r3
            r2 = r47
            r3 = 11
            java.lang.Object r47 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 2048(0x800, float:2.87E-42)
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r48 = r35
            goto L_0x0567
        L_0x02fd:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r47
            r35 = r48
            r23 = r50
            r3 = 11
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r34 = r2
            r3 = r46
            r2 = 10
            java.lang.Object r46 = r0.decodeNullableSerializableElement(r1, r2, r9, r3)
            r8 = r8 | 1024(0x400, float:1.435E-42)
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r47 = r34
            goto L_0x0567
        L_0x0329:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r2 = 10
            r10 = 20
            com.vungle.ads.internal.model.AdPayload$TpatSerializer r9 = com.vungle.ads.internal.model.AdPayload.TpatSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r33 = r3
            r2 = r45
            r3 = 9
            java.lang.Object r45 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 512(0x200, float:7.175E-43)
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r46 = r33
            goto L_0x0567
        L_0x0357:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r3 = 9
            r10 = 20
            kotlinx.serialization.internal.BooleanSerializer r9 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r32 = r2
            r3 = r44
            r2 = 8
            java.lang.Object r44 = r0.decodeNullableSerializableElement(r1, r2, r9, r3)
            r8 = r8 | 256(0x100, float:3.59E-43)
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r45 = r32
            goto L_0x0567
        L_0x0387:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r2 = 8
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r31 = r3
            r2 = r43
            r3 = 7
            java.lang.Object r43 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 128(0x80, float:1.794E-43)
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r44 = r31
            goto L_0x0567
        L_0x03b8:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r3 = 7
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r30 = r2
            r3 = r42
            r2 = 6
            java.lang.Object r42 = r0.decodeNullableSerializableElement(r1, r2, r9, r3)
            r8 = r8 | 64
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r43 = r30
            goto L_0x0567
        L_0x03ea:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r2 = 6
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r29 = r3
            r2 = r41
            r3 = 5
            java.lang.Object r41 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 32
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r42 = r29
            goto L_0x0567
        L_0x041e:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r3 = 5
            r10 = 20
            kotlinx.serialization.internal.IntSerializer r9 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r28 = r2
            r3 = r40
            r2 = 4
            java.lang.Object r40 = r0.decodeNullableSerializableElement(r1, r2, r9, r3)
            r8 = r8 | 16
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r41 = r28
            goto L_0x0567
        L_0x0454:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r2 = 4
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r27 = r3
            r2 = r39
            r3 = 3
            java.lang.Object r39 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 8
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r40 = r27
            goto L_0x0567
        L_0x048c:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r3 = 3
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r26 = r2
            r3 = r38
            r2 = 2
            java.lang.Object r38 = r0.decodeNullableSerializableElement(r1, r2, r9, r3)
            r8 = r8 | 4
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r39 = r26
            goto L_0x0567
        L_0x04c6:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r2 = 2
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r25 = r3
            r2 = r37
            r3 = 1
            java.lang.Object r37 = r0.decodeNullableSerializableElement(r1, r3, r9, r2)
            r8 = r8 | 2
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            r38 = r25
            goto L_0x0567
        L_0x0502:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r2 = r37
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r3 = 1
            r10 = 20
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            r3 = r36
            r10 = 0
            java.lang.Object r36 = r0.decodeNullableSerializableElement(r1, r10, r9, r3)
            r8 = r8 | 1
        L_0x0533:
            r9 = r6
            r2 = r21
            r3 = r22
            r10 = r23
            goto L_0x0567
        L_0x053b:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r3 = r36
            r2 = r37
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r50
            r10 = 0
            r2 = r21
            r3 = r22
            r10 = r23
            r49 = 0
        L_0x0567:
            r6 = r66
            goto L_0x0188
        L_0x056b:
            r21 = r2
            r22 = r3
            r66 = r6
            r6 = r9
            r23 = r10
            r3 = r36
            r2 = r37
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r18 = r4
            r17 = r5
            r19 = r7
            r37 = r8
            r10 = r15
            r20 = r21
            r7 = r25
            r4 = r26
            r5 = r27
            r9 = r29
            r26 = r66
            r8 = r2
            r2 = r3
            r21 = r6
            r27 = r13
            r25 = r22
            r22 = r23
            r3 = r28
            r6 = r31
            r13 = r32
        L_0x05b3:
            r0.endStructure(r1)
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = new com.vungle.ads.internal.model.AdPayload$AdUnit
            r36 = r0
            r38 = r2
            java.lang.String r38 = (java.lang.String) r38
            r39 = r8
            java.lang.String r39 = (java.lang.String) r39
            r40 = r7
            java.lang.String r40 = (java.lang.String) r40
            r41 = r4
            java.lang.String r41 = (java.lang.String) r41
            r42 = r5
            java.lang.Integer r42 = (java.lang.Integer) r42
            r43 = r3
            java.lang.String r43 = (java.lang.String) r43
            r44 = r9
            java.lang.String r44 = (java.lang.String) r44
            r45 = r30
            java.lang.String r45 = (java.lang.String) r45
            r46 = r6
            java.lang.Boolean r46 = (java.lang.Boolean) r46
            r47 = r13
            java.util.Map r47 = (java.util.Map) r47
            r48 = r33
            java.lang.String r48 = (java.lang.String) r48
            r49 = r34
            java.lang.String r49 = (java.lang.String) r49
            r50 = r35
            java.lang.String r50 = (java.lang.String) r50
            r51 = r22
            com.vungle.ads.internal.model.AdPayload$TemplateSettings r51 = (com.vungle.ads.internal.model.AdPayload.TemplateSettings) r51
            r52 = r21
            java.lang.String r52 = (java.lang.String) r52
            r53 = r20
            java.lang.String r53 = (java.lang.String) r53
            r54 = r19
            java.lang.String r54 = (java.lang.String) r54
            r55 = r18
            java.lang.Integer r55 = (java.lang.Integer) r55
            r56 = r17
            com.vungle.ads.internal.model.AdPayload$Viewability r56 = (com.vungle.ads.internal.model.AdPayload.Viewability) r56
            r57 = r25
            java.lang.String r57 = (java.lang.String) r57
            r58 = r10
            java.util.List r58 = (java.util.List) r58
            r59 = r14
            java.util.List r59 = (java.util.List) r59
            r60 = r26
            java.lang.Integer r60 = (java.lang.Integer) r60
            r61 = r27
            java.lang.Integer r61 = (java.lang.Integer) r61
            r62 = r12
            java.lang.Integer r62 = (java.lang.Integer) r62
            r63 = r11
            java.lang.Integer r63 = (java.lang.Integer) r63
            r64 = 0
            r36.<init>((int) r37, (java.lang.String) r38, (java.lang.String) r39, (java.lang.String) r40, (java.lang.String) r41, (java.lang.Integer) r42, (java.lang.String) r43, (java.lang.String) r44, (java.lang.String) r45, (java.lang.Boolean) r46, (java.util.Map) r47, (java.lang.String) r48, (java.lang.String) r49, (java.lang.String) r50, (com.vungle.ads.internal.model.AdPayload.TemplateSettings) r51, (java.lang.String) r52, (java.lang.String) r53, (java.lang.String) r54, (java.lang.Integer) r55, (com.vungle.ads.internal.model.AdPayload.Viewability) r56, (java.lang.String) r57, (java.util.List) r58, (java.util.List) r59, (java.lang.Integer) r60, (java.lang.Integer) r61, (java.lang.Integer) r62, (java.lang.Integer) r63, (kotlinx.serialization.internal.SerializationConstructorMarker) r64)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$AdUnit$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.AdPayload$AdUnit");
    }

    public void serialize(Encoder encoder, AdPayload.AdUnit adUnit) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(adUnit, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AdPayload.AdUnit.write$Self(adUnit, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
