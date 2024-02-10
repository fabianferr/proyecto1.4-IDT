package com.vungle.ads.internal.model;

import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 S2\u00020\u0001:\u0002RSB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Ba\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010#J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\u0006\u0010A\u001a\u00020\bJ\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\u0006\u0010E\u001a\u00020\bJ\u0006\u0010F\u001a\u00020\bJ\u0006\u0010G\u001a\u00020\bJ\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020-J\t\u0010K\u001a\u00020\u0005HÖ\u0001J!\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QHÇ\u0001R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u001bR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001eR\u000e\u0010\u0010\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u001bR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010)R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010)R(\u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u00103\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006T"}, d2 = {"Lcom/vungle/ads/internal/model/Placement;", "", "seen1", "", "identifier", "", "referenceId", "incentivized", "", "supportedTemplateTypes", "", "supportedAdFormats", "adRefreshDuration", "headerBidding", "adSize", "isIncentivized", "placementAdType", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;IZLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;IZLjava/lang/String;)V", "getAdRefreshDuration$annotations", "()V", "getAdRefreshDuration", "()I", "getAdSize$annotations", "getAdSize", "()Ljava/lang/String;", "getHeaderBidding$annotations", "getHeaderBidding", "()Z", "getIdentifier$annotations", "getIdentifier", "getIncentivized$annotations", "getIncentivized", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReferenceId$annotations", "getReferenceId", "getSupportedAdFormats$annotations", "getSupportedAdFormats", "()Ljava/util/List;", "getSupportedTemplateTypes$annotations", "getSupportedTemplateTypes", "wakeupTime", "", "getWakeupTime$annotations", "getWakeupTime", "()Ljava/lang/Long;", "setWakeupTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;IZLjava/lang/String;)Lcom/vungle/ads/internal/model/Placement;", "equals", "other", "hashCode", "isBanner", "isBannerNonMREC", "isDefault", "isInterstitial", "isMREC", "isNative", "isRewardedVideo", "snooze", "", "sleepTime", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: ConfigPayload.kt */
public final class Placement {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int adRefreshDuration;
    private final String adSize;
    private final boolean headerBidding;
    private final String identifier;
    private final Boolean incentivized;
    private final boolean isIncentivized;
    private final String placementAdType;
    private final String referenceId;
    private final List<String> supportedAdFormats;
    private final List<String> supportedTemplateTypes;
    private Long wakeupTime;

    public static /* synthetic */ Placement copy$default(Placement placement, String str, String str2, Boolean bool, List list, List list2, int i, boolean z, String str3, int i2, Object obj) {
        Placement placement2 = placement;
        int i3 = i2;
        return placement.copy((i3 & 1) != 0 ? placement2.identifier : str, (i3 & 2) != 0 ? placement2.referenceId : str2, (i3 & 4) != 0 ? placement2.incentivized : bool, (i3 & 8) != 0 ? placement2.supportedTemplateTypes : list, (i3 & 16) != 0 ? placement2.supportedAdFormats : list2, (i3 & 32) != 0 ? placement2.adRefreshDuration : i, (i3 & 64) != 0 ? placement2.headerBidding : z, (i3 & 128) != 0 ? placement2.adSize : str3);
    }

    @SerialName("ad_refresh_duration")
    public static /* synthetic */ void getAdRefreshDuration$annotations() {
    }

    @SerialName("ad_size")
    public static /* synthetic */ void getAdSize$annotations() {
    }

    @SerialName("header_bidding")
    public static /* synthetic */ void getHeaderBidding$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @SerialName("is_incentivized")
    public static /* synthetic */ void getIncentivized$annotations() {
    }

    @SerialName("reference_id")
    public static /* synthetic */ void getReferenceId$annotations() {
    }

    @SerialName("supported_ad_formats")
    public static /* synthetic */ void getSupportedAdFormats$annotations() {
    }

    @SerialName("supported_template_types")
    public static /* synthetic */ void getSupportedTemplateTypes$annotations() {
    }

    @Transient
    public static /* synthetic */ void getWakeupTime$annotations() {
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.referenceId;
    }

    public final Boolean component3() {
        return this.incentivized;
    }

    public final List<String> component4() {
        return this.supportedTemplateTypes;
    }

    public final List<String> component5() {
        return this.supportedAdFormats;
    }

    public final int component6() {
        return this.adRefreshDuration;
    }

    public final boolean component7() {
        return this.headerBidding;
    }

    public final String component8() {
        return this.adSize;
    }

    public final Placement copy(String str, String str2, Boolean bool, List<String> list, List<String> list2, int i, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "referenceId");
        Intrinsics.checkNotNullParameter(list, "supportedTemplateTypes");
        Intrinsics.checkNotNullParameter(list2, "supportedAdFormats");
        return new Placement(str, str2, bool, list, list2, i, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placement)) {
            return false;
        }
        Placement placement = (Placement) obj;
        return Intrinsics.areEqual((Object) this.identifier, (Object) placement.identifier) && Intrinsics.areEqual((Object) this.referenceId, (Object) placement.referenceId) && Intrinsics.areEqual((Object) this.incentivized, (Object) placement.incentivized) && Intrinsics.areEqual((Object) this.supportedTemplateTypes, (Object) placement.supportedTemplateTypes) && Intrinsics.areEqual((Object) this.supportedAdFormats, (Object) placement.supportedAdFormats) && this.adRefreshDuration == placement.adRefreshDuration && this.headerBidding == placement.headerBidding && Intrinsics.areEqual((Object) this.adSize, (Object) placement.adSize);
    }

    public int hashCode() {
        int hashCode = ((this.identifier.hashCode() * 31) + this.referenceId.hashCode()) * 31;
        Boolean bool = this.incentivized;
        int i = 0;
        int hashCode2 = (((((((hashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.supportedTemplateTypes.hashCode()) * 31) + this.supportedAdFormats.hashCode()) * 31) + this.adRefreshDuration) * 31;
        boolean z = this.headerBidding;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str = this.adSize;
        if (str != null) {
            i = str.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Placement(identifier=" + this.identifier + ", referenceId=" + this.referenceId + ", incentivized=" + this.incentivized + ", supportedTemplateTypes=" + this.supportedTemplateTypes + ", supportedAdFormats=" + this.supportedAdFormats + ", adRefreshDuration=" + this.adRefreshDuration + ", headerBidding=" + this.headerBidding + ", adSize=" + this.adSize + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/Placement$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/Placement;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConfigPayload.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Placement> serializer() {
            return Placement$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Placement(int i, @SerialName("id") String str, @SerialName("reference_id") String str2, @SerialName("is_incentivized") Boolean bool, @SerialName("supported_template_types") List list, @SerialName("supported_ad_formats") List list2, @SerialName("ad_refresh_duration") int i2, @SerialName("header_bidding") boolean z, @SerialName("ad_size") String str3, boolean z2, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        String str5;
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, Placement$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.referenceId = str2;
        boolean z3 = false;
        if ((i & 4) == 0) {
            this.incentivized = false;
        } else {
            this.incentivized = bool;
        }
        if ((i & 8) == 0) {
            this.supportedTemplateTypes = CollectionsKt.emptyList();
        } else {
            this.supportedTemplateTypes = list;
        }
        if ((i & 16) == 0) {
            this.supportedAdFormats = CollectionsKt.emptyList();
        } else {
            this.supportedAdFormats = list2;
        }
        if ((i & 32) == 0) {
            this.adRefreshDuration = Integer.MIN_VALUE;
        } else {
            this.adRefreshDuration = i2;
        }
        if ((i & 64) == 0) {
            this.headerBidding = false;
        } else {
            this.headerBidding = z;
        }
        if ((i & 128) == 0) {
            this.adSize = null;
        } else {
            this.adSize = str3;
        }
        if ((i & 256) == 0) {
            Boolean bool2 = this.incentivized;
            this.isIncentivized = bool2 != null ? bool2.booleanValue() : z3;
        } else {
            this.isIncentivized = z2;
        }
        this.wakeupTime = null;
        if ((i & 512) == 0) {
            List<String> list3 = this.supportedTemplateTypes;
            if (list3.contains("banner")) {
                str5 = "TYPE_BANNER";
            } else if (list3.contains("mrec")) {
                str5 = "TYPE_MREC";
            } else {
                str5 = list3.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) ? "TYPE_NATIVE" : "TYPE_DEFAULT";
            }
            this.placementAdType = str5;
            return;
        }
        this.placementAdType = str4;
    }

    public Placement(String str, String str2, Boolean bool, List<String> list, List<String> list2, int i, boolean z, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "referenceId");
        Intrinsics.checkNotNullParameter(list, "supportedTemplateTypes");
        Intrinsics.checkNotNullParameter(list2, "supportedAdFormats");
        this.identifier = str;
        this.referenceId = str2;
        this.incentivized = bool;
        this.supportedTemplateTypes = list;
        this.supportedAdFormats = list2;
        this.adRefreshDuration = i;
        this.headerBidding = z;
        this.adSize = str3;
        this.isIncentivized = bool != null ? bool.booleanValue() : false;
        if (list.contains("banner")) {
            str4 = "TYPE_BANNER";
        } else if (list.contains("mrec")) {
            str4 = "TYPE_MREC";
        } else {
            str4 = list.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) ? "TYPE_NATIVE" : "TYPE_DEFAULT";
        }
        this.placementAdType = str4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4) == false) goto L_0x0100;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void write$Self(com.vungle.ads.internal.model.Placement r6, kotlinx.serialization.encoding.CompositeEncoder r7, kotlinx.serialization.descriptors.SerialDescriptor r8) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = r6.identifier
            r1 = 0
            r7.encodeStringElement(r8, r1, r0)
            java.lang.String r0 = r6.referenceId
            r2 = 1
            r7.encodeStringElement(r8, r2, r0)
            r0 = 2
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x0024
        L_0x0022:
            r3 = 1
            goto L_0x0032
        L_0x0024:
            java.lang.Boolean r3 = r6.incentivized
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0031
            goto L_0x0022
        L_0x0031:
            r3 = 0
        L_0x0032:
            if (r3 == 0) goto L_0x003d
            kotlinx.serialization.internal.BooleanSerializer r3 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3
            java.lang.Boolean r4 = r6.incentivized
            r7.encodeNullableSerializableElement(r8, r0, r3, r4)
        L_0x003d:
            r0 = 3
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x0046
        L_0x0044:
            r3 = 1
            goto L_0x0054
        L_0x0046:
            java.util.List<java.lang.String> r3 = r6.supportedTemplateTypes
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0053
            goto L_0x0044
        L_0x0053:
            r3 = 0
        L_0x0054:
            if (r3 == 0) goto L_0x0066
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r4 = (kotlinx.serialization.KSerializer) r4
            r3.<init>(r4)
            kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3
            java.util.List<java.lang.String> r4 = r6.supportedTemplateTypes
            r7.encodeSerializableElement(r8, r0, r3, r4)
        L_0x0066:
            r0 = 4
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x006f
        L_0x006d:
            r3 = 1
            goto L_0x007d
        L_0x006f:
            java.util.List<java.lang.String> r3 = r6.supportedAdFormats
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x007c
            goto L_0x006d
        L_0x007c:
            r3 = 0
        L_0x007d:
            if (r3 == 0) goto L_0x008f
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r4 = (kotlinx.serialization.KSerializer) r4
            r3.<init>(r4)
            kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3
            java.util.List<java.lang.String> r4 = r6.supportedAdFormats
            r7.encodeSerializableElement(r8, r0, r3, r4)
        L_0x008f:
            r0 = 5
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x0098
        L_0x0096:
            r3 = 1
            goto L_0x00a0
        L_0x0098:
            int r3 = r6.adRefreshDuration
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x009f
            goto L_0x0096
        L_0x009f:
            r3 = 0
        L_0x00a0:
            if (r3 == 0) goto L_0x00a7
            int r3 = r6.adRefreshDuration
            r7.encodeIntElement(r8, r0, r3)
        L_0x00a7:
            r0 = 6
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x00b0
        L_0x00ae:
            r3 = 1
            goto L_0x00b6
        L_0x00b0:
            boolean r3 = r6.headerBidding
            if (r3 == 0) goto L_0x00b5
            goto L_0x00ae
        L_0x00b5:
            r3 = 0
        L_0x00b6:
            if (r3 == 0) goto L_0x00bd
            boolean r3 = r6.headerBidding
            r7.encodeBooleanElement(r8, r0, r3)
        L_0x00bd:
            r0 = 7
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x00c6
        L_0x00c4:
            r3 = 1
            goto L_0x00cc
        L_0x00c6:
            java.lang.String r3 = r6.adSize
            if (r3 == 0) goto L_0x00cb
            goto L_0x00c4
        L_0x00cb:
            r3 = 0
        L_0x00cc:
            if (r3 == 0) goto L_0x00d7
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.SerializationStrategy r3 = (kotlinx.serialization.SerializationStrategy) r3
            java.lang.String r4 = r6.adSize
            r7.encodeNullableSerializableElement(r8, r0, r3, r4)
        L_0x00d7:
            r0 = 8
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x00e1
        L_0x00df:
            r3 = 1
            goto L_0x00f1
        L_0x00e1:
            boolean r3 = r6.isIncentivized
            java.lang.Boolean r4 = r6.incentivized
            if (r4 == 0) goto L_0x00ec
            boolean r4 = r4.booleanValue()
            goto L_0x00ed
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            if (r3 == r4) goto L_0x00f0
            goto L_0x00df
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            if (r3 == 0) goto L_0x00f8
            boolean r3 = r6.isIncentivized
            r7.encodeBooleanElement(r8, r0, r3)
        L_0x00f8:
            r0 = 9
            boolean r3 = r7.shouldEncodeElementDefault(r8, r0)
            if (r3 == 0) goto L_0x0102
        L_0x0100:
            r1 = 1
            goto L_0x0130
        L_0x0102:
            java.lang.String r3 = r6.placementAdType
            java.util.List<java.lang.String> r4 = r6.supportedTemplateTypes
            java.lang.String r5 = "banner"
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L_0x0111
            java.lang.String r4 = "TYPE_BANNER"
            goto L_0x0129
        L_0x0111:
            java.lang.String r5 = "mrec"
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L_0x011c
            java.lang.String r4 = "TYPE_MREC"
            goto L_0x0129
        L_0x011c:
            java.lang.String r5 = "native"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0127
            java.lang.String r4 = "TYPE_NATIVE"
            goto L_0x0129
        L_0x0127:
            java.lang.String r4 = "TYPE_DEFAULT"
        L_0x0129:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0130
            goto L_0x0100
        L_0x0130:
            if (r1 == 0) goto L_0x0137
            java.lang.String r6 = r6.placementAdType
            r7.encodeStringElement(r8, r0, r6)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.Placement.write$Self(com.vungle.ads.internal.model.Placement, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Placement(java.lang.String r13, java.lang.String r14, java.lang.Boolean r15, java.util.List r16, java.util.List r17, int r18, boolean r19, java.lang.String r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x000d
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r6 = r1
            goto L_0x000e
        L_0x000d:
            r6 = r15
        L_0x000e:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0018
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r7 = r1
            goto L_0x001a
        L_0x0018:
            r7 = r16
        L_0x001a:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0024
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r8 = r1
            goto L_0x0026
        L_0x0024:
            r8 = r17
        L_0x0026:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0031
        L_0x002f:
            r9 = r18
        L_0x0031:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0037
            r10 = 0
            goto L_0x0039
        L_0x0037:
            r10 = r19
        L_0x0039:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0040
            r0 = 0
            r11 = r0
            goto L_0x0042
        L_0x0040:
            r11 = r20
        L_0x0042:
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.Placement.<init>(java.lang.String, java.lang.String, java.lang.Boolean, java.util.List, java.util.List, int, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getIncentivized() {
        return this.incentivized;
    }

    public final List<String> getSupportedTemplateTypes() {
        return this.supportedTemplateTypes;
    }

    public final List<String> getSupportedAdFormats() {
        return this.supportedAdFormats;
    }

    public final int getAdRefreshDuration() {
        return this.adRefreshDuration;
    }

    public final boolean getHeaderBidding() {
        return this.headerBidding;
    }

    public final String getAdSize() {
        return this.adSize;
    }

    public final boolean isIncentivized() {
        return this.isIncentivized;
    }

    public final Long getWakeupTime() {
        return this.wakeupTime;
    }

    public final void setWakeupTime(Long l) {
        this.wakeupTime = l;
    }

    public final boolean isNative() {
        return Intrinsics.areEqual((Object) this.placementAdType, (Object) "TYPE_NATIVE");
    }

    public final boolean isBanner() {
        return Intrinsics.areEqual((Object) this.placementAdType, (Object) "TYPE_BANNER") || isMREC();
    }

    public final boolean isBannerNonMREC() {
        return Intrinsics.areEqual((Object) this.placementAdType, (Object) "TYPE_BANNER");
    }

    public final boolean isMREC() {
        return Intrinsics.areEqual((Object) this.placementAdType, (Object) "TYPE_MREC");
    }

    public final boolean isDefault() {
        return Intrinsics.areEqual((Object) this.placementAdType, (Object) "TYPE_DEFAULT");
    }

    public final boolean isInterstitial() {
        return isDefault() && !this.isIncentivized;
    }

    public final boolean isRewardedVideo() {
        return isDefault() && this.isIncentivized;
    }

    public final void snooze(long j) {
        this.wakeupTime = Long.valueOf(System.currentTimeMillis() + (j * ((long) 1000)));
    }
}
