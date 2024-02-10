package com.ironsource.sdk.k;

import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.sdk.g.g;
import com.ironsource.sdk.k.b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002=>B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003Je\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\t\u00108\u001a\u000209HÖ\u0001J\r\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010¨\u0006?"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder;", "", "containerView", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;", "titleView", "Landroid/view/View;", "advertiserView", "iconView", "bodyView", "mediaView", "ctaView", "privacyIconView", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "getAdvertiserView", "()Landroid/view/View;", "setAdvertiserView", "(Landroid/view/View;)V", "getBodyView", "setBodyView", "getContainerView", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;", "setContainerView", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;)V", "getCtaView", "setCtaView", "getIconView", "setIconView", "listener", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$Listener;", "getListener$sdk5_release", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$Listener;", "setListener$sdk5_release", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$Listener;)V", "getMediaView", "setMediaView", "getPrivacyIconView", "setPrivacyIconView", "getTitleView", "setTitleView", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "listenToClicks", "", "listenToContainerShown", "toString", "", "viewsStatus", "Lorg/json/JSONObject;", "viewsStatus$sdk5_release", "Listener", "ViewName", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {
    public a a;
    private b b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$Listener;", "", "onViewClicked", "", "viewName", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$ViewName;", "onVisibilityChanged", "viewVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(g gVar);

        void a(b bVar);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$ViewName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Title", "Advertiser", "Body", "Cta", "Icon", "Container", "PrivacyIcon", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        Title("title"),
        Advertiser("advertiser"),
        Body("body"),
        Cta("cta"),
        Icon(RewardPlus.ICON),
        Container("container"),
        PrivacyIcon("privacyIcon");
        
        final String a;

        private b(String str) {
            this.a = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$listenToContainerShown$1", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer$Listener;", "onVisibilityChanged", "", "viewVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements b.a {
        private /* synthetic */ e a;

        c(e eVar) {
            this.a = eVar;
        }

        public final void a(g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "viewVisibilityParams");
            a aVar = this.a.a;
            if (aVar != null) {
                aVar.a(gVar);
            }
        }
    }

    public e(b bVar, View view, View view2, View view3, View view4, View view5, View view6, View view7) {
        Intrinsics.checkNotNullParameter(bVar, "containerView");
        Intrinsics.checkNotNullParameter(view7, "privacyIconView");
        this.b = bVar;
        this.c = view;
        this.d = view2;
        this.e = view3;
        this.f = view4;
        this.g = view5;
        this.h = view6;
        this.i = view7;
        a(this, view, b.Title);
        a(this, this.d, b.Advertiser);
        a(this, this.f, b.Body);
        a(this, this.h, b.Cta);
        a(this, this.e, b.Icon);
        a(this, (View) this.b, b.Container);
        a(this, this.i, b.PrivacyIcon);
        this.b.a = new c(this);
    }

    private static final void a(e eVar, View view, b bVar) {
        if (view != null) {
            view.setOnClickListener(new e$$ExternalSyntheticLambda0(eVar, bVar));
        }
    }

    /* access modifiers changed from: private */
    public static final void a(e eVar, b bVar, View view) {
        Intrinsics.checkNotNullParameter(eVar, "this$0");
        Intrinsics.checkNotNullParameter(bVar, "$viewName");
        a aVar = eVar.a;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public final JSONObject a() {
        boolean z = true;
        JSONObject put = new JSONObject().put("title", this.c != null).put("advertiser", this.d != null).put("body", this.f != null).put("cta", this.h != null).put(ShareConstants.WEB_DIALOG_PARAM_MEDIA, this.g != null);
        if (this.e == null) {
            z = false;
        }
        JSONObject put2 = put.put(RewardPlus.ICON, z);
        Intrinsics.checkNotNullExpressionValue(put2, "JSONObject()\n\t\t\t.put(\"ti…\"icon\", iconView != null)");
        return put2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual((Object) this.b, (Object) eVar.b) && Intrinsics.areEqual((Object) this.c, (Object) eVar.c) && Intrinsics.areEqual((Object) this.d, (Object) eVar.d) && Intrinsics.areEqual((Object) this.e, (Object) eVar.e) && Intrinsics.areEqual((Object) this.f, (Object) eVar.f) && Intrinsics.areEqual((Object) this.g, (Object) eVar.g) && Intrinsics.areEqual((Object) this.h, (Object) eVar.h) && Intrinsics.areEqual((Object) this.i, (Object) eVar.i);
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode() * 31;
        View view = this.c;
        int i2 = 0;
        int hashCode2 = (hashCode + (view == null ? 0 : view.hashCode())) * 31;
        View view2 = this.d;
        int hashCode3 = (hashCode2 + (view2 == null ? 0 : view2.hashCode())) * 31;
        View view3 = this.e;
        int hashCode4 = (hashCode3 + (view3 == null ? 0 : view3.hashCode())) * 31;
        View view4 = this.f;
        int hashCode5 = (hashCode4 + (view4 == null ? 0 : view4.hashCode())) * 31;
        View view5 = this.g;
        int hashCode6 = (hashCode5 + (view5 == null ? 0 : view5.hashCode())) * 31;
        View view6 = this.h;
        if (view6 != null) {
            i2 = view6.hashCode();
        }
        return ((hashCode6 + i2) * 31) + this.i.hashCode();
    }

    public final String toString() {
        return "ISNNativeAdViewHolder(containerView=" + this.b + ", titleView=" + this.c + ", advertiserView=" + this.d + ", iconView=" + this.e + ", bodyView=" + this.f + ", mediaView=" + this.g + ", ctaView=" + this.h + ", privacyIconView=" + this.i + ')';
    }
}
