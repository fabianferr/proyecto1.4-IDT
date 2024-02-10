package com.vungle.ads.internal.model;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPInputStream;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.Transient;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 22\u00020\u0001:\u000212BG\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB/\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J8\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\"\u001a\u0004\u0018\u00010\nJ\b\u0010#\u001a\u0004\u0018\u00010\u0006J\b\u0010$\u001a\u0004\u0018\u00010\u0006J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'H\u0002J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J!\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200HÇ\u0001R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00148\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u00063"}, d2 = {"Lcom/vungle/ads/internal/model/BidPayload;", "", "seen1", "", "version", "adunit", "", "impression", "", "ad", "Lcom/vungle/ads/internal/model/AdPayload;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/vungle/ads/internal/model/AdPayload;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getAdunit", "()Ljava/lang/String;", "getImpression", "()Ljava/util/List;", "json", "Lkotlinx/serialization/json/Json;", "getJson$annotations", "()V", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/vungle/ads/internal/model/BidPayload;", "equals", "", "other", "getAdPayload", "getEventId", "getPlacementId", "gzipDecode", "compressed", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: BidPayload.kt */
public final class BidPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AdPayload ad;
    private final String adunit;
    private final List<String> impression;
    private final Json json;
    private final Integer version;

    public BidPayload() {
        this((Integer) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BidPayload copy$default(BidPayload bidPayload, Integer num, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = bidPayload.version;
        }
        if ((i & 2) != 0) {
            str = bidPayload.adunit;
        }
        if ((i & 4) != 0) {
            list = bidPayload.impression;
        }
        return bidPayload.copy(num, str, list);
    }

    @Transient
    private static /* synthetic */ void getJson$annotations() {
    }

    public final Integer component1() {
        return this.version;
    }

    public final String component2() {
        return this.adunit;
    }

    public final List<String> component3() {
        return this.impression;
    }

    public final BidPayload copy(Integer num, String str, List<String> list) {
        return new BidPayload(num, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BidPayload)) {
            return false;
        }
        BidPayload bidPayload = (BidPayload) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) bidPayload.version) && Intrinsics.areEqual((Object) this.adunit, (Object) bidPayload.adunit) && Intrinsics.areEqual((Object) this.impression, (Object) bidPayload.impression);
    }

    public int hashCode() {
        Integer num = this.version;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.adunit;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.impression;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BidPayload(version=" + this.version + ", adunit=" + this.adunit + ", impression=" + this.impression + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/BidPayload$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/BidPayload;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BidPayload.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BidPayload> serializer() {
            return BidPayload$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BidPayload(int i, Integer num, String str, List list, AdPayload adPayload, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, BidPayload$$serializer.INSTANCE.getDescriptor());
        }
        AdPayload adPayload2 = null;
        if ((i & 1) == 0) {
            this.version = null;
        } else {
            this.version = num;
        }
        if ((i & 2) == 0) {
            this.adunit = null;
        } else {
            this.adunit = str;
        }
        if ((i & 4) == 0) {
            this.impression = null;
        } else {
            this.impression = list;
        }
        Json Json$default = JsonKt.Json$default((Json) null, AnonymousClass1.INSTANCE, 1, (Object) null);
        this.json = Json$default;
        if ((i & 8) == 0) {
            String str2 = this.adunit;
            if (str2 != null) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                byte[] decode = Base64.decode(str2, 0);
                objectRef.element = decode != null ? gzipDecode(decode) : null;
                if (((String) objectRef.element) != null) {
                    StringFormat stringFormat = Json$default;
                    KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(AdPayload.class));
                    Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    adPayload2 = (AdPayload) stringFormat.decodeFromString(serializer, (String) objectRef.element);
                }
            }
            this.ad = adPayload2;
            return;
        }
        this.ad = adPayload;
    }

    public BidPayload(Integer num, String str, List<String> list) {
        this.version = num;
        this.adunit = str;
        this.impression = list;
        AdPayload adPayload = null;
        Json Json$default = JsonKt.Json$default((Json) null, BidPayload$json$1.INSTANCE, 1, (Object) null);
        this.json = Json$default;
        if (str != null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            byte[] decode = Base64.decode(str, 0);
            objectRef.element = decode != null ? gzipDecode(decode) : null;
            if (((String) objectRef.element) != null) {
                StringFormat stringFormat = Json$default;
                KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(AdPayload.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                adPayload = (AdPayload) stringFormat.decodeFromString(serializer, (String) objectRef.element);
            }
        }
        this.ad = adPayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5) == false) goto L_0x006b;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void write$Self(com.vungle.ads.internal.model.BidPayload r8, kotlinx.serialization.encoding.CompositeEncoder r9, kotlinx.serialization.descriptors.SerialDescriptor r10) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            boolean r1 = r9.shouldEncodeElementDefault(r10, r0)
            r2 = 1
            if (r1 == 0) goto L_0x0019
        L_0x0017:
            r1 = 1
            goto L_0x001f
        L_0x0019:
            java.lang.Integer r1 = r8.version
            if (r1 == 0) goto L_0x001e
            goto L_0x0017
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r1 == 0) goto L_0x002a
            kotlinx.serialization.internal.IntSerializer r1 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.SerializationStrategy r1 = (kotlinx.serialization.SerializationStrategy) r1
            java.lang.Integer r3 = r8.version
            r9.encodeNullableSerializableElement(r10, r0, r1, r3)
        L_0x002a:
            boolean r1 = r9.shouldEncodeElementDefault(r10, r2)
            if (r1 == 0) goto L_0x0032
        L_0x0030:
            r1 = 1
            goto L_0x0038
        L_0x0032:
            java.lang.String r1 = r8.adunit
            if (r1 == 0) goto L_0x0037
            goto L_0x0030
        L_0x0037:
            r1 = 0
        L_0x0038:
            if (r1 == 0) goto L_0x0043
            kotlinx.serialization.internal.StringSerializer r1 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.SerializationStrategy r1 = (kotlinx.serialization.SerializationStrategy) r1
            java.lang.String r3 = r8.adunit
            r9.encodeNullableSerializableElement(r10, r2, r1, r3)
        L_0x0043:
            r1 = 2
            boolean r3 = r9.shouldEncodeElementDefault(r10, r1)
            if (r3 == 0) goto L_0x004c
        L_0x004a:
            r3 = 1
            goto L_0x0052
        L_0x004c:
            java.util.List<java.lang.String> r3 = r8.impression
            if (r3 == 0) goto L_0x0051
            goto L_0x004a
        L_0x0051:
            r3 = 0
        L_0x0052:
            if (r3 == 0) goto L_0x0064
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r4 = (kotlinx.serialization.KSerializer) r4
            r3.<init>(r4)
            kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3
            java.util.List<java.lang.String> r4 = r8.impression
            r9.encodeNullableSerializableElement(r10, r1, r3, r4)
        L_0x0064:
            r1 = 3
            boolean r3 = r9.shouldEncodeElementDefault(r10, r1)
            if (r3 == 0) goto L_0x006d
        L_0x006b:
            r0 = 1
            goto L_0x00b8
        L_0x006d:
            com.vungle.ads.internal.model.AdPayload r3 = r8.ad
            java.lang.String r4 = r8.adunit
            r5 = 0
            if (r4 == 0) goto L_0x00b1
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            byte[] r4 = android.util.Base64.decode(r4, r0)
            if (r4 == 0) goto L_0x0084
            java.lang.String r4 = r8.gzipDecode(r4)
            goto L_0x0085
        L_0x0084:
            r4 = r5
        L_0x0085:
            r6.element = r4
            T r4 = r6.element
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00b1
            kotlinx.serialization.json.Json r4 = r8.json
            kotlinx.serialization.StringFormat r4 = (kotlinx.serialization.StringFormat) r4
            T r5 = r6.element
            java.lang.String r5 = (java.lang.String) r5
            kotlinx.serialization.modules.SerializersModule r6 = r4.getSerializersModule()
            java.lang.Class<com.vungle.ads.internal.model.AdPayload> r7 = com.vungle.ads.internal.model.AdPayload.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r7)
            kotlinx.serialization.KSerializer r6 = kotlinx.serialization.SerializersKt.serializer((kotlinx.serialization.modules.SerializersModule) r6, (kotlin.reflect.KType) r7)
            java.lang.String r7 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r4 = r4.decodeFromString(r6, r5)
            com.vungle.ads.internal.model.AdPayload r4 = (com.vungle.ads.internal.model.AdPayload) r4
            r5 = r4
        L_0x00b1:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x00b8
            goto L_0x006b
        L_0x00b8:
            if (r0 == 0) goto L_0x00c3
            com.vungle.ads.internal.model.AdPayload$$serializer r0 = com.vungle.ads.internal.model.AdPayload$$serializer.INSTANCE
            kotlinx.serialization.SerializationStrategy r0 = (kotlinx.serialization.SerializationStrategy) r0
            com.vungle.ads.internal.model.AdPayload r8 = r8.ad
            r9.encodeNullableSerializableElement(r10, r1, r0, r8)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.BidPayload.write$Self(com.vungle.ads.internal.model.BidPayload, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BidPayload(Integer num, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getAdunit() {
        return this.adunit;
    }

    public final List<String> getImpression() {
        return this.impression;
    }

    public final String getPlacementId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.placementId();
        }
        return null;
    }

    public final String getEventId() {
        AdPayload adPayload = this.ad;
        if (adPayload != null) {
            return adPayload.eventId();
        }
        return null;
    }

    public final AdPayload getAdPayload() {
        return this.ad;
    }

    private final String gzipDecode(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        StringBuilder sb = new StringBuilder();
        byte[] bArr2 = new byte[32];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                sb.append(new String(bArr2, 0, read, Charsets.UTF_8));
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
                return sb2;
            }
        }
    }
}
