package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.CommonRequestBody;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 12\u00020\u0001:\u000201BK\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JA\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J!\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lcom/vungle/ads/internal/model/RtbToken;", "", "seen1", "", "device", "Lcom/vungle/ads/internal/model/DeviceNode;", "user", "Lcom/vungle/ads/internal/model/CommonRequestBody$User;", "ext", "Lcom/vungle/ads/internal/model/CommonRequestBody$RequestExt;", "request", "Lcom/vungle/ads/internal/model/RtbRequest;", "ordinalView", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/model/DeviceNode;Lcom/vungle/ads/internal/model/CommonRequestBody$User;Lcom/vungle/ads/internal/model/CommonRequestBody$RequestExt;Lcom/vungle/ads/internal/model/RtbRequest;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/model/DeviceNode;Lcom/vungle/ads/internal/model/CommonRequestBody$User;Lcom/vungle/ads/internal/model/CommonRequestBody$RequestExt;Lcom/vungle/ads/internal/model/RtbRequest;I)V", "getDevice", "()Lcom/vungle/ads/internal/model/DeviceNode;", "getExt", "()Lcom/vungle/ads/internal/model/CommonRequestBody$RequestExt;", "getOrdinalView$annotations", "()V", "getOrdinalView", "()I", "getRequest", "()Lcom/vungle/ads/internal/model/RtbRequest;", "getUser", "()Lcom/vungle/ads/internal/model/CommonRequestBody$User;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: RtbToken.kt */
public final class RtbToken {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeviceNode device;
    private final CommonRequestBody.RequestExt ext;
    private final int ordinalView;
    private final RtbRequest request;
    private final CommonRequestBody.User user;

    public static /* synthetic */ RtbToken copy$default(RtbToken rtbToken, DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deviceNode = rtbToken.device;
        }
        if ((i2 & 2) != 0) {
            user2 = rtbToken.user;
        }
        CommonRequestBody.User user3 = user2;
        if ((i2 & 4) != 0) {
            requestExt = rtbToken.ext;
        }
        CommonRequestBody.RequestExt requestExt2 = requestExt;
        if ((i2 & 8) != 0) {
            rtbRequest = rtbToken.request;
        }
        RtbRequest rtbRequest2 = rtbRequest;
        if ((i2 & 16) != 0) {
            i = rtbToken.ordinalView;
        }
        return rtbToken.copy(deviceNode, user3, requestExt2, rtbRequest2, i);
    }

    @SerialName("ordinal_view")
    public static /* synthetic */ void getOrdinalView$annotations() {
    }

    public final DeviceNode component1() {
        return this.device;
    }

    public final CommonRequestBody.User component2() {
        return this.user;
    }

    public final CommonRequestBody.RequestExt component3() {
        return this.ext;
    }

    public final RtbRequest component4() {
        return this.request;
    }

    public final int component5() {
        return this.ordinalView;
    }

    public final RtbToken copy(DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i) {
        Intrinsics.checkNotNullParameter(deviceNode, "device");
        return new RtbToken(deviceNode, user2, requestExt, rtbRequest, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RtbToken)) {
            return false;
        }
        RtbToken rtbToken = (RtbToken) obj;
        return Intrinsics.areEqual((Object) this.device, (Object) rtbToken.device) && Intrinsics.areEqual((Object) this.user, (Object) rtbToken.user) && Intrinsics.areEqual((Object) this.ext, (Object) rtbToken.ext) && Intrinsics.areEqual((Object) this.request, (Object) rtbToken.request) && this.ordinalView == rtbToken.ordinalView;
    }

    public int hashCode() {
        int hashCode = this.device.hashCode() * 31;
        CommonRequestBody.User user2 = this.user;
        int i = 0;
        int hashCode2 = (hashCode + (user2 == null ? 0 : user2.hashCode())) * 31;
        CommonRequestBody.RequestExt requestExt = this.ext;
        int hashCode3 = (hashCode2 + (requestExt == null ? 0 : requestExt.hashCode())) * 31;
        RtbRequest rtbRequest = this.request;
        if (rtbRequest != null) {
            i = rtbRequest.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.ordinalView;
    }

    public String toString() {
        return "RtbToken(device=" + this.device + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ", ordinalView=" + this.ordinalView + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/RtbToken$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/RtbToken;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RtbToken.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RtbToken> serializer() {
            return RtbToken$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RtbToken(int i, DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, @SerialName("ordinal_view") int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (17 != (i & 17)) {
            PluginExceptionsKt.throwMissingFieldException(i, 17, RtbToken$$serializer.INSTANCE.getDescriptor());
        }
        this.device = deviceNode;
        if ((i & 2) == 0) {
            this.user = null;
        } else {
            this.user = user2;
        }
        if ((i & 4) == 0) {
            this.ext = null;
        } else {
            this.ext = requestExt;
        }
        if ((i & 8) == 0) {
            this.request = null;
        } else {
            this.request = rtbRequest;
        }
        this.ordinalView = i2;
    }

    public RtbToken(DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i) {
        Intrinsics.checkNotNullParameter(deviceNode, "device");
        this.device = deviceNode;
        this.user = user2;
        this.ext = requestExt;
        this.request = rtbRequest;
        this.ordinalView = i;
    }

    @JvmStatic
    public static final void write$Self(RtbToken rtbToken, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(rtbToken, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, DeviceNode$$serializer.INSTANCE, rtbToken.device);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || rtbToken.user != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, CommonRequestBody$User$$serializer.INSTANCE, rtbToken.user);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || rtbToken.ext != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, CommonRequestBody$RequestExt$$serializer.INSTANCE, rtbToken.ext);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || rtbToken.request != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, RtbRequest$$serializer.INSTANCE, rtbToken.request);
        }
        compositeEncoder.encodeIntElement(serialDescriptor, 4, rtbToken.ordinalView);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RtbToken(DeviceNode deviceNode, CommonRequestBody.User user2, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceNode, (i2 & 2) != 0 ? null : user2, (i2 & 4) != 0 ? null : requestExt, (i2 & 8) != 0 ? null : rtbRequest, i);
    }

    public final DeviceNode getDevice() {
        return this.device;
    }

    public final CommonRequestBody.User getUser() {
        return this.user;
    }

    public final CommonRequestBody.RequestExt getExt() {
        return this.ext;
    }

    public final RtbRequest getRequest() {
        return this.request;
    }

    public final int getOrdinalView() {
        return this.ordinalView;
    }
}
