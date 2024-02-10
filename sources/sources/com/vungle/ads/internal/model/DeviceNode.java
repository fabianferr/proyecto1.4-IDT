package com.vungle.ads.internal.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u0000 H2\u00020\u0001:\u0006EFGHIJB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bq\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0014J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001J!\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DHÇ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001c¨\u0006K"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode;", "", "seen1", "", "make", "", "model", "osv", "carrier", "os", "w", "h", "ua", "ifa", "lmt", "ext", "Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;)V", "getCarrier", "()Ljava/lang/String;", "getExt", "()Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;", "setExt", "(Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;)V", "getH", "()I", "getIfa", "setIfa", "(Ljava/lang/String;)V", "getLmt", "()Ljava/lang/Integer;", "setLmt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMake", "getModel", "getOs", "getOsv", "getUa", "setUa", "getW", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;)Lcom/vungle/ads/internal/model/DeviceNode;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "AndroidAmazonExt", "CommonVungleExt", "Companion", "DeviceExt", "VungleExt", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: DeviceNode.kt */
public final class DeviceNode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String carrier;
    private DeviceExt ext;
    private final int h;
    private String ifa;
    private Integer lmt;
    private final String make;
    private final String model;
    private final String os;
    private final String osv;
    private String ua;
    private final int w;

    public static /* synthetic */ DeviceNode copy$default(DeviceNode deviceNode, String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, Integer num, DeviceExt deviceExt, int i3, Object obj) {
        DeviceNode deviceNode2 = deviceNode;
        int i4 = i3;
        return deviceNode.copy((i4 & 1) != 0 ? deviceNode2.make : str, (i4 & 2) != 0 ? deviceNode2.model : str2, (i4 & 4) != 0 ? deviceNode2.osv : str3, (i4 & 8) != 0 ? deviceNode2.carrier : str4, (i4 & 16) != 0 ? deviceNode2.os : str5, (i4 & 32) != 0 ? deviceNode2.w : i, (i4 & 64) != 0 ? deviceNode2.h : i2, (i4 & 128) != 0 ? deviceNode2.ua : str6, (i4 & 256) != 0 ? deviceNode2.ifa : str7, (i4 & 512) != 0 ? deviceNode2.lmt : num, (i4 & 1024) != 0 ? deviceNode2.ext : deviceExt);
    }

    public final String component1() {
        return this.make;
    }

    public final Integer component10() {
        return this.lmt;
    }

    public final DeviceExt component11() {
        return this.ext;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.osv;
    }

    public final String component4() {
        return this.carrier;
    }

    public final String component5() {
        return this.os;
    }

    public final int component6() {
        return this.w;
    }

    public final int component7() {
        return this.h;
    }

    public final String component8() {
        return this.ua;
    }

    public final String component9() {
        return this.ifa;
    }

    public final DeviceNode copy(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, Integer num, DeviceExt deviceExt) {
        Intrinsics.checkNotNullParameter(str, "make");
        Intrinsics.checkNotNullParameter(str2, "model");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "osv");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "os");
        return new DeviceNode(str, str2, str8, str4, str9, i, i2, str6, str7, num, deviceExt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceNode)) {
            return false;
        }
        DeviceNode deviceNode = (DeviceNode) obj;
        return Intrinsics.areEqual((Object) this.make, (Object) deviceNode.make) && Intrinsics.areEqual((Object) this.model, (Object) deviceNode.model) && Intrinsics.areEqual((Object) this.osv, (Object) deviceNode.osv) && Intrinsics.areEqual((Object) this.carrier, (Object) deviceNode.carrier) && Intrinsics.areEqual((Object) this.os, (Object) deviceNode.os) && this.w == deviceNode.w && this.h == deviceNode.h && Intrinsics.areEqual((Object) this.ua, (Object) deviceNode.ua) && Intrinsics.areEqual((Object) this.ifa, (Object) deviceNode.ifa) && Intrinsics.areEqual((Object) this.lmt, (Object) deviceNode.lmt) && Intrinsics.areEqual((Object) this.ext, (Object) deviceNode.ext);
    }

    public int hashCode() {
        int hashCode = ((((this.make.hashCode() * 31) + this.model.hashCode()) * 31) + this.osv.hashCode()) * 31;
        String str = this.carrier;
        int i = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.os.hashCode()) * 31) + this.w) * 31) + this.h) * 31;
        String str2 = this.ua;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ifa;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lmt;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        DeviceExt deviceExt = this.ext;
        if (deviceExt != null) {
            i = deviceExt.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "DeviceNode(make=" + this.make + ", model=" + this.model + ", osv=" + this.osv + ", carrier=" + this.carrier + ", os=" + this.os + ", w=" + this.w + ", h=" + this.h + ", ua=" + this.ua + ", ifa=" + this.ifa + ", lmt=" + this.lmt + ", ext=" + this.ext + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DeviceNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeviceNode> serializer() {
            return DeviceNode$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DeviceNode(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, DeviceExt deviceExt, SerializationConstructorMarker serializationConstructorMarker) {
        if (119 != (i & 119)) {
            PluginExceptionsKt.throwMissingFieldException(i, 119, DeviceNode$$serializer.INSTANCE.getDescriptor());
        }
        this.make = str;
        this.model = str2;
        this.osv = str3;
        if ((i & 8) == 0) {
            this.carrier = null;
        } else {
            this.carrier = str4;
        }
        this.os = str5;
        this.w = i2;
        this.h = i3;
        if ((i & 128) == 0) {
            this.ua = null;
        } else {
            this.ua = str6;
        }
        if ((i & 256) == 0) {
            this.ifa = null;
        } else {
            this.ifa = str7;
        }
        if ((i & 512) == 0) {
            this.lmt = null;
        } else {
            this.lmt = num;
        }
        if ((i & 1024) == 0) {
            this.ext = null;
        } else {
            this.ext = deviceExt;
        }
    }

    public DeviceNode(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, Integer num, DeviceExt deviceExt) {
        Intrinsics.checkNotNullParameter(str, "make");
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "osv");
        Intrinsics.checkNotNullParameter(str5, "os");
        this.make = str;
        this.model = str2;
        this.osv = str3;
        this.carrier = str4;
        this.os = str5;
        this.w = i;
        this.h = i2;
        this.ua = str6;
        this.ifa = str7;
        this.lmt = num;
        this.ext = deviceExt;
    }

    @JvmStatic
    public static final void write$Self(DeviceNode deviceNode, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(deviceNode, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, deviceNode.make);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, deviceNode.model);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, deviceNode.osv);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || deviceNode.carrier != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, deviceNode.carrier);
        }
        compositeEncoder.encodeStringElement(serialDescriptor, 4, deviceNode.os);
        compositeEncoder.encodeIntElement(serialDescriptor, 5, deviceNode.w);
        compositeEncoder.encodeIntElement(serialDescriptor, 6, deviceNode.h);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || deviceNode.ua != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, deviceNode.ua);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || deviceNode.ifa != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, deviceNode.ifa);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || deviceNode.lmt != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, deviceNode.lmt);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || deviceNode.ext != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, DeviceNode$DeviceExt$$serializer.INSTANCE, deviceNode.ext);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceNode(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, com.vungle.ads.internal.model.DeviceNode.DeviceExt r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r19
        L_0x000b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0011
            r11 = r2
            goto L_0x0013
        L_0x0011:
            r11 = r23
        L_0x0013:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0019
            r12 = r2
            goto L_0x001b
        L_0x0019:
            r12 = r24
        L_0x001b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0021
            r13 = r2
            goto L_0x0023
        L_0x0021:
            r13 = r25
        L_0x0023:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0029
            r14 = r2
            goto L_0x002b
        L_0x0029:
            r14 = r26
        L_0x002b:
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r9 = r21
            r10 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.DeviceNode.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.Integer, com.vungle.ads.internal.model.DeviceNode$DeviceExt, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getMake() {
        return this.make;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOsv() {
        return this.osv;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getOs() {
        return this.os;
    }

    public final int getW() {
        return this.w;
    }

    public final int getH() {
        return this.h;
    }

    public final String getUa() {
        return this.ua;
    }

    public final void setUa(String str) {
        this.ua = str;
    }

    public final String getIfa() {
        return this.ifa;
    }

    public final void setIfa(String str) {
        this.ifa = str;
    }

    public final Integer getLmt() {
        return this.lmt;
    }

    public final void setLmt(Integer num) {
        this.lmt = num;
    }

    public final DeviceExt getExt() {
        return this.ext;
    }

    public final void setExt(DeviceExt deviceExt) {
        this.ext = deviceExt;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;", "", "seen1", "", "vungle", "Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/model/DeviceNode$VungleExt;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;)V", "getVungle", "()Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: DeviceNode.kt */
    public static final class DeviceExt {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final VungleExt vungle;

        public static /* synthetic */ DeviceExt copy$default(DeviceExt deviceExt, VungleExt vungleExt, int i, Object obj) {
            if ((i & 1) != 0) {
                vungleExt = deviceExt.vungle;
            }
            return deviceExt.copy(vungleExt);
        }

        public final VungleExt component1() {
            return this.vungle;
        }

        public final DeviceExt copy(VungleExt vungleExt) {
            Intrinsics.checkNotNullParameter(vungleExt, "vungle");
            return new DeviceExt(vungleExt);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeviceExt) && Intrinsics.areEqual((Object) this.vungle, (Object) ((DeviceExt) obj).vungle);
        }

        public int hashCode() {
            return this.vungle.hashCode();
        }

        public String toString() {
            return "DeviceExt(vungle=" + this.vungle + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$DeviceExt;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DeviceNode.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DeviceExt> serializer() {
                return DeviceNode$DeviceExt$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ DeviceExt(int i, VungleExt vungleExt, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, DeviceNode$DeviceExt$$serializer.INSTANCE.getDescriptor());
            }
            this.vungle = vungleExt;
        }

        public DeviceExt(VungleExt vungleExt) {
            Intrinsics.checkNotNullParameter(vungleExt, "vungle");
            this.vungle = vungleExt;
        }

        @JvmStatic
        public static final void write$Self(DeviceExt deviceExt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(deviceExt, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, DeviceNode$VungleExt$$serializer.INSTANCE, deviceExt.vungle);
        }

        public final VungleExt getVungle() {
            return this.vungle;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÇ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "", "seen1", "", "android", "Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;", "amazon", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;)V", "getAmazon", "()Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;", "getAndroid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: DeviceNode.kt */
    public static final class VungleExt {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final AndroidAmazonExt amazon;

        /* renamed from: android  reason: collision with root package name */
        private final AndroidAmazonExt f34android;

        public VungleExt() {
            this((AndroidAmazonExt) null, (AndroidAmazonExt) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ VungleExt copy$default(VungleExt vungleExt, AndroidAmazonExt androidAmazonExt, AndroidAmazonExt androidAmazonExt2, int i, Object obj) {
            if ((i & 1) != 0) {
                androidAmazonExt = vungleExt.f34android;
            }
            if ((i & 2) != 0) {
                androidAmazonExt2 = vungleExt.amazon;
            }
            return vungleExt.copy(androidAmazonExt, androidAmazonExt2);
        }

        public final AndroidAmazonExt component1() {
            return this.f34android;
        }

        public final AndroidAmazonExt component2() {
            return this.amazon;
        }

        public final VungleExt copy(AndroidAmazonExt androidAmazonExt, AndroidAmazonExt androidAmazonExt2) {
            return new VungleExt(androidAmazonExt, androidAmazonExt2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VungleExt)) {
                return false;
            }
            VungleExt vungleExt = (VungleExt) obj;
            return Intrinsics.areEqual((Object) this.f34android, (Object) vungleExt.f34android) && Intrinsics.areEqual((Object) this.amazon, (Object) vungleExt.amazon);
        }

        public int hashCode() {
            AndroidAmazonExt androidAmazonExt = this.f34android;
            int i = 0;
            int hashCode = (androidAmazonExt == null ? 0 : androidAmazonExt.hashCode()) * 31;
            AndroidAmazonExt androidAmazonExt2 = this.amazon;
            if (androidAmazonExt2 != null) {
                i = androidAmazonExt2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "VungleExt(android=" + this.f34android + ", amazon=" + this.amazon + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$VungleExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DeviceNode.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<VungleExt> serializer() {
                return DeviceNode$VungleExt$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ VungleExt(int i, AndroidAmazonExt androidAmazonExt, AndroidAmazonExt androidAmazonExt2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, DeviceNode$VungleExt$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.f34android = null;
            } else {
                this.f34android = androidAmazonExt;
            }
            if ((i & 2) == 0) {
                this.amazon = null;
            } else {
                this.amazon = androidAmazonExt2;
            }
        }

        public VungleExt(AndroidAmazonExt androidAmazonExt, AndroidAmazonExt androidAmazonExt2) {
            this.f34android = androidAmazonExt;
            this.amazon = androidAmazonExt2;
        }

        @JvmStatic
        public static final void write$Self(VungleExt vungleExt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(vungleExt, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || vungleExt.f34android != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, DeviceNode$AndroidAmazonExt$$serializer.INSTANCE, vungleExt.f34android);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || vungleExt.amazon != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, DeviceNode$AndroidAmazonExt$$serializer.INSTANCE, vungleExt.amazon);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VungleExt(AndroidAmazonExt androidAmazonExt, AndroidAmazonExt androidAmazonExt2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : androidAmazonExt, (i & 2) != 0 ? null : androidAmazonExt2);
        }

        public final AndroidAmazonExt getAndroid() {
            return this.f34android;
        }

        public final AndroidAmazonExt getAmazon() {
            return this.amazon;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 Z2\u00020\u0001:\u0002YZBÑ\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0012\u001a\u00020\n\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0007\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aB\u0005¢\u0006\u0002\u0010\u001bJ!\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XHÇ\u0001R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R&\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R&\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u0010\u001b\u001a\u0004\b\u0006\u00108\"\u0004\b9\u0010:R$\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u001b\u001a\u0004\b\u0016\u00108\"\u0004\b<\u0010:R$\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u001b\u001a\u0004\b\u0014\u00108\"\u0004\b>\u0010:R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R&\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010 R$\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010\u001b\u001a\u0004\bG\u0010+\"\u0004\bH\u0010-R$\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010\u001b\u001a\u0004\bJ\u0010+\"\u0004\bK\u0010-R&\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bL\u0010\u001b\u001a\u0004\bM\u0010\u001e\"\u0004\bN\u0010 R$\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u0010\u001b\u001a\u0004\bP\u0010&\"\u0004\bQ\u0010(¨\u0006[å\b\u0004å\b\u0006å\b\bå\b\tå\b\u000bå\b\få\b\rå\b\u000eå\b\u000få\b\u0010å\b\u0011å\b\u0012å\b\u0013å\b\u0014å\b\u0015å\b\u0016å\b\u0017"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$CommonVungleExt;", "", "seen1", "", "androidId", "", "isGooglePlayServicesAvailable", "", "appSetId", "batteryLevel", "", "batteryState", "batterySaverEnabled", "connectionType", "connectionTypeDetail", "locale", "language", "timeZone", "volumeLevel", "soundEnabled", "isTv", "sdCardAvailable", "isSideloadEnabled", "osName", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZIZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "getAndroidId$annotations", "getAndroidId", "()Ljava/lang/String;", "setAndroidId", "(Ljava/lang/String;)V", "getAppSetId$annotations", "getAppSetId", "setAppSetId", "getBatteryLevel$annotations", "getBatteryLevel", "()F", "setBatteryLevel", "(F)V", "getBatterySaverEnabled$annotations", "getBatterySaverEnabled", "()I", "setBatterySaverEnabled", "(I)V", "getBatteryState$annotations", "getBatteryState", "setBatteryState", "getConnectionType$annotations", "getConnectionType", "setConnectionType", "getConnectionTypeDetail$annotations", "getConnectionTypeDetail", "setConnectionTypeDetail", "isGooglePlayServicesAvailable$annotations", "()Z", "setGooglePlayServicesAvailable", "(Z)V", "isSideloadEnabled$annotations", "setSideloadEnabled", "isTv$annotations", "setTv", "getLanguage", "setLanguage", "getLocale", "setLocale", "getOsName$annotations", "getOsName", "setOsName", "getSdCardAvailable$annotations", "getSdCardAvailable", "setSdCardAvailable", "getSoundEnabled$annotations", "getSoundEnabled", "setSoundEnabled", "getTimeZone$annotations", "getTimeZone", "setTimeZone", "getVolumeLevel$annotations", "getVolumeLevel", "setVolumeLevel", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: DeviceNode.kt */
    public static class CommonVungleExt {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String androidId;
        private String appSetId;
        private float batteryLevel;
        private int batterySaverEnabled;
        private String batteryState;
        private String connectionType;
        private String connectionTypeDetail;
        private boolean isGooglePlayServicesAvailable;
        private boolean isSideloadEnabled;
        private boolean isTv;
        private String language;
        private String locale;
        private String osName;
        private int sdCardAvailable;
        private int soundEnabled;
        private String timeZone;
        private float volumeLevel;

        @SerialName("android_id")
        public static /* synthetic */ void getAndroidId$annotations() {
        }

        @SerialName("app_set_id")
        public static /* synthetic */ void getAppSetId$annotations() {
        }

        @SerialName("battery_level")
        public static /* synthetic */ void getBatteryLevel$annotations() {
        }

        @SerialName("battery_saver_enabled")
        public static /* synthetic */ void getBatterySaverEnabled$annotations() {
        }

        @SerialName("battery_state")
        public static /* synthetic */ void getBatteryState$annotations() {
        }

        @SerialName("connection_type")
        public static /* synthetic */ void getConnectionType$annotations() {
        }

        @SerialName("connection_type_detail")
        public static /* synthetic */ void getConnectionTypeDetail$annotations() {
        }

        @SerialName("os_name")
        public static /* synthetic */ void getOsName$annotations() {
        }

        @SerialName("sd_card_available")
        public static /* synthetic */ void getSdCardAvailable$annotations() {
        }

        @SerialName("sound_enabled")
        public static /* synthetic */ void getSoundEnabled$annotations() {
        }

        @SerialName("time_zone")
        public static /* synthetic */ void getTimeZone$annotations() {
        }

        @SerialName("volume_level")
        public static /* synthetic */ void getVolumeLevel$annotations() {
        }

        @SerialName("is_google_play_services_available")
        public static /* synthetic */ void isGooglePlayServicesAvailable$annotations() {
        }

        @SerialName("is_sideload_enabled")
        public static /* synthetic */ void isSideloadEnabled$annotations() {
        }

        @SerialName("is_tv")
        public static /* synthetic */ void isTv$annotations() {
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$CommonVungleExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$CommonVungleExt;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DeviceNode.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CommonVungleExt> serializer() {
                return DeviceNode$CommonVungleExt$$serializer.INSTANCE;
            }
        }

        public CommonVungleExt() {
            this.soundEnabled = 1;
            this.sdCardAvailable = 1;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CommonVungleExt(int i, @SerialName("android_id") String str, @SerialName("is_google_play_services_available") boolean z, @SerialName("app_set_id") String str2, @SerialName("battery_level") float f, @SerialName("battery_state") String str3, @SerialName("battery_saver_enabled") int i2, @SerialName("connection_type") String str4, @SerialName("connection_type_detail") String str5, String str6, String str7, @SerialName("time_zone") String str8, @SerialName("volume_level") float f2, @SerialName("sound_enabled") int i3, @SerialName("is_tv") boolean z2, @SerialName("sd_card_available") int i4, @SerialName("is_sideload_enabled") boolean z3, @SerialName("os_name") String str9, SerializationConstructorMarker serializationConstructorMarker) {
            int i5 = i;
            if ((i5 & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, DeviceNode$CommonVungleExt$$serializer.INSTANCE.getDescriptor());
            }
            if ((i5 & 1) == 0) {
                this.androidId = null;
            } else {
                this.androidId = str;
            }
            if ((i5 & 2) == 0) {
                this.isGooglePlayServicesAvailable = false;
            } else {
                this.isGooglePlayServicesAvailable = z;
            }
            if ((i5 & 4) == 0) {
                this.appSetId = null;
            } else {
                this.appSetId = str2;
            }
            if ((i5 & 8) == 0) {
                this.batteryLevel = 0.0f;
            } else {
                this.batteryLevel = f;
            }
            if ((i5 & 16) == 0) {
                this.batteryState = null;
            } else {
                this.batteryState = str3;
            }
            if ((i5 & 32) == 0) {
                this.batterySaverEnabled = 0;
            } else {
                this.batterySaverEnabled = i2;
            }
            if ((i5 & 64) == 0) {
                this.connectionType = null;
            } else {
                this.connectionType = str4;
            }
            if ((i5 & 128) == 0) {
                this.connectionTypeDetail = null;
            } else {
                this.connectionTypeDetail = str5;
            }
            if ((i5 & 256) == 0) {
                this.locale = null;
            } else {
                this.locale = str6;
            }
            if ((i5 & 512) == 0) {
                this.language = null;
            } else {
                this.language = str7;
            }
            if ((i5 & 1024) == 0) {
                this.timeZone = null;
            } else {
                this.timeZone = str8;
            }
            if ((i5 & 2048) == 0) {
                this.volumeLevel = 0.0f;
            } else {
                this.volumeLevel = f2;
            }
            if ((i5 & 4096) == 0) {
                this.soundEnabled = 1;
            } else {
                this.soundEnabled = i3;
            }
            if ((i5 & 8192) == 0) {
                this.isTv = false;
            } else {
                this.isTv = z2;
            }
            if ((i5 & 16384) == 0) {
                this.sdCardAvailable = 1;
            } else {
                this.sdCardAvailable = i4;
            }
            if ((32768 & i5) == 0) {
                this.isSideloadEnabled = false;
            } else {
                this.isSideloadEnabled = z3;
            }
            if ((i5 & 65536) == 0) {
                this.osName = null;
            } else {
                this.osName = str9;
            }
        }

        @JvmStatic
        public static final void write$Self(CommonVungleExt commonVungleExt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(commonVungleExt, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            boolean z3 = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || commonVungleExt.androidId != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, commonVungleExt.androidId);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || commonVungleExt.isGooglePlayServicesAvailable) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 1, commonVungleExt.isGooglePlayServicesAvailable);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || commonVungleExt.appSetId != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, commonVungleExt.appSetId);
            }
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && Intrinsics.areEqual((Object) Float.valueOf(commonVungleExt.batteryLevel), (Object) Float.valueOf(0.0f))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeFloatElement(serialDescriptor, 3, commonVungleExt.batteryLevel);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || commonVungleExt.batteryState != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, commonVungleExt.batteryState);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || commonVungleExt.batterySaverEnabled != 0) {
                compositeEncoder.encodeIntElement(serialDescriptor, 5, commonVungleExt.batterySaverEnabled);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || commonVungleExt.connectionType != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, commonVungleExt.connectionType);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || commonVungleExt.connectionTypeDetail != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, commonVungleExt.connectionTypeDetail);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || commonVungleExt.locale != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, commonVungleExt.locale);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || commonVungleExt.language != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, commonVungleExt.language);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || commonVungleExt.timeZone != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, commonVungleExt.timeZone);
            }
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) && Intrinsics.areEqual((Object) Float.valueOf(commonVungleExt.volumeLevel), (Object) Float.valueOf(0.0f))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                compositeEncoder.encodeFloatElement(serialDescriptor, 11, commonVungleExt.volumeLevel);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || commonVungleExt.soundEnabled != 1) {
                compositeEncoder.encodeIntElement(serialDescriptor, 12, commonVungleExt.soundEnabled);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) || commonVungleExt.isTv) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 13, commonVungleExt.isTv);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 14) || commonVungleExt.sdCardAvailable != 1) {
                compositeEncoder.encodeIntElement(serialDescriptor, 14, commonVungleExt.sdCardAvailable);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 15) || commonVungleExt.isSideloadEnabled) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 15, commonVungleExt.isSideloadEnabled);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 16) || commonVungleExt.osName != null) {
                z3 = true;
            }
            if (z3) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, commonVungleExt.osName);
            }
        }

        public final String getAndroidId() {
            return this.androidId;
        }

        public final void setAndroidId(String str) {
            this.androidId = str;
        }

        public final boolean isGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        public final void setGooglePlayServicesAvailable(boolean z) {
            this.isGooglePlayServicesAvailable = z;
        }

        public final String getAppSetId() {
            return this.appSetId;
        }

        public final void setAppSetId(String str) {
            this.appSetId = str;
        }

        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        public final void setBatteryLevel(float f) {
            this.batteryLevel = f;
        }

        public final String getBatteryState() {
            return this.batteryState;
        }

        public final void setBatteryState(String str) {
            this.batteryState = str;
        }

        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        public final void setBatterySaverEnabled(int i) {
            this.batterySaverEnabled = i;
        }

        public final String getConnectionType() {
            return this.connectionType;
        }

        public final void setConnectionType(String str) {
            this.connectionType = str;
        }

        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        public final void setConnectionTypeDetail(String str) {
            this.connectionTypeDetail = str;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final void setLocale(String str) {
            this.locale = str;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final void setTimeZone(String str) {
            this.timeZone = str;
        }

        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        public final void setVolumeLevel(float f) {
            this.volumeLevel = f;
        }

        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        public final void setSoundEnabled(int i) {
            this.soundEnabled = i;
        }

        public final boolean isTv() {
            return this.isTv;
        }

        public final void setTv(boolean z) {
            this.isTv = z;
        }

        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        public final void setSdCardAvailable(int i) {
            this.sdCardAvailable = i;
        }

        public final boolean isSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        public final void setSideloadEnabled(boolean z) {
            this.isSideloadEnabled = z;
        }

        public final String getOsName() {
            return this.osName;
        }

        public final void setOsName(String str) {
            this.osName = str;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 42\u00020\u0001:\u000234Bå\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0012\u001a\u00020\n\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0007\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cB\u001d\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J!\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÇ\u0001R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!¨\u00065"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;", "Lcom/vungle/ads/internal/model/DeviceNode$CommonVungleExt;", "seen1", "", "androidId", "", "isGooglePlayServicesAvailable", "", "appSetId", "batteryLevel", "", "batteryState", "batterySaverEnabled", "connectionType", "connectionTypeDetail", "locale", "language", "timeZone", "volumeLevel", "soundEnabled", "isTv", "sdCardAvailable", "isSideloadEnabled", "osName", "gaid", "amazonAdvertisingId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getAmazonAdvertisingId", "()Ljava/lang/String;", "setAmazonAdvertisingId", "(Ljava/lang/String;)V", "getGaid", "setGaid", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: DeviceNode.kt */
    public static final class AndroidAmazonExt extends CommonVungleExt {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String amazonAdvertisingId;
        private String gaid;

        public AndroidAmazonExt() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AndroidAmazonExt copy$default(AndroidAmazonExt androidAmazonExt, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = androidAmazonExt.gaid;
            }
            if ((i & 2) != 0) {
                str2 = androidAmazonExt.amazonAdvertisingId;
            }
            return androidAmazonExt.copy(str, str2);
        }

        public final String component1() {
            return this.gaid;
        }

        public final String component2() {
            return this.amazonAdvertisingId;
        }

        public final AndroidAmazonExt copy(String str, String str2) {
            return new AndroidAmazonExt(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AndroidAmazonExt)) {
                return false;
            }
            AndroidAmazonExt androidAmazonExt = (AndroidAmazonExt) obj;
            return Intrinsics.areEqual((Object) this.gaid, (Object) androidAmazonExt.gaid) && Intrinsics.areEqual((Object) this.amazonAdvertisingId, (Object) androidAmazonExt.amazonAdvertisingId);
        }

        public int hashCode() {
            String str = this.gaid;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.amazonAdvertisingId;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "AndroidAmazonExt(gaid=" + this.gaid + ", amazonAdvertisingId=" + this.amazonAdvertisingId + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$AndroidAmazonExt;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: DeviceNode.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AndroidAmazonExt> serializer() {
                return DeviceNode$AndroidAmazonExt$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ AndroidAmazonExt(int i, @SerialName("android_id") String str, @SerialName("is_google_play_services_available") boolean z, @SerialName("app_set_id") String str2, @SerialName("battery_level") float f, @SerialName("battery_state") String str3, @SerialName("battery_saver_enabled") int i2, @SerialName("connection_type") String str4, @SerialName("connection_type_detail") String str5, String str6, String str7, @SerialName("time_zone") String str8, @SerialName("volume_level") float f2, @SerialName("sound_enabled") int i3, @SerialName("is_tv") boolean z2, @SerialName("sd_card_available") int i4, @SerialName("is_sideload_enabled") boolean z3, @SerialName("os_name") String str9, String str10, String str11, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, str, z, str2, f, str3, i2, str4, str5, str6, str7, str8, f2, i3, z2, i4, z3, str9, serializationConstructorMarker);
            AndroidAmazonExt androidAmazonExt;
            int i5 = i;
            if ((i5 & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i5, 0, DeviceNode$AndroidAmazonExt$$serializer.INSTANCE.getDescriptor());
            }
            String str12 = null;
            if ((i & 131072) == 0) {
                androidAmazonExt = this;
                androidAmazonExt.gaid = null;
            } else {
                androidAmazonExt = this;
                androidAmazonExt.gaid = str10;
            }
            androidAmazonExt.amazonAdvertisingId = (i & 262144) != 0 ? str11 : str12;
        }

        @JvmStatic
        public static final void write$Self(AndroidAmazonExt androidAmazonExt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(androidAmazonExt, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            CommonVungleExt.write$Self(androidAmazonExt, compositeEncoder, serialDescriptor);
            boolean z = false;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 17) || androidAmazonExt.gaid != null) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, androidAmazonExt.gaid);
            }
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 18) || androidAmazonExt.amazonAdvertisingId != null) {
                z = true;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, androidAmazonExt.amazonAdvertisingId);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AndroidAmazonExt(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        public final String getGaid() {
            return this.gaid;
        }

        public final void setAmazonAdvertisingId(String str) {
            this.amazonAdvertisingId = str;
        }

        public final void setGaid(String str) {
            this.gaid = str;
        }

        public AndroidAmazonExt(String str, String str2) {
            this.gaid = str;
            this.amazonAdvertisingId = str2;
        }
    }
}
