package com.ironsource.sdk.k;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.utils.a.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002'(BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J[\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "", "title", "", "advertiser", "body", "cta", "icon", "Landroid/graphics/drawable/Drawable;", "mediaView", "Landroid/webkit/WebView;", "privacyIcon", "Landroid/view/View;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/webkit/WebView;Landroid/view/View;)V", "getAdvertiser", "()Ljava/lang/String;", "getBody", "getCta", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getMediaView", "()Landroid/webkit/WebView;", "getPrivacyIcon", "()Landroid/view/View;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Factory", "Report", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Drawable e;
    public final WebView f;
    public final View g;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\b\u0012J(\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\b\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Factory;", "", "imageLoader", "Lcom/ironsource/sdk/utils/loaders/ImageLoaderInterface;", "adViewManagement", "Lcom/ironsource/sdk/WPAD/AdViewManagement;", "(Lcom/ironsource/sdk/utils/loaders/ImageLoaderInterface;Lcom/ironsource/sdk/WPAD/AdViewManagement;)V", "createNativeAdLoadReport", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report;", "activityContext", "Landroid/content/Context;", "json", "Lorg/json/JSONObject;", "prepareAdView", "Lkotlin/Result;", "Landroid/webkit/WebView;", "adViewId", "", "prepareAdView-CmtIpJM", "prepareIcon", "Landroid/graphics/drawable/Drawable;", "iconUrl", "prepareIcon-CmtIpJM", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        final d a;
        final com.ironsource.sdk.c.a b;

        public a(d dVar, com.ironsource.sdk.c.a aVar) {
            Intrinsics.checkNotNullParameter(dVar, "imageLoader");
            Intrinsics.checkNotNullParameter(aVar, "adViewManagement");
            this.a = dVar;
            this.b = aVar;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report;", "", "data", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report$Data;", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report$Data;)V", "getData", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report$Data;", "json", "Lorg/json/JSONObject;", "Data", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        final a a;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BX\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001eJ\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b J\t\u0010!\u001a\u00020\rHÆ\u0003Jj\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001ø\u0001\u0000J\u0006\u0010#\u001a\u00020$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report$Data;", "", "title", "", "advertiser", "body", "cta", "icon", "Lkotlin/Result;", "Landroid/graphics/drawable/Drawable;", "media", "Landroid/webkit/WebView;", "privacyIcon", "Landroid/view/View;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/Result;Lkotlin/Result;Landroid/view/View;)V", "getAdvertiser", "()Ljava/lang/String;", "getBody", "getCta", "getIcon-xLWZpok", "()Lkotlin/Result;", "getMedia-xLWZpok", "getPrivacyIcon", "()Landroid/view/View;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component5-xLWZpok", "component6", "component6-xLWZpok", "component7", "copy", "createNativeAdData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "equals", "", "other", "hashCode", "", "toString", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a {
            final String a;
            final String b;
            final String c;
            final String d;
            final Result<Drawable> e;
            final Result<WebView> f;
            final View g;

            public a(String str, String str2, String str3, String str4, Result<? extends Drawable> result, Result<? extends WebView> result2, View view) {
                Intrinsics.checkNotNullParameter(view, "privacyIcon");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = result;
                this.f = result2;
                this.g = view;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics.areEqual((Object) this.a, (Object) aVar.a) && Intrinsics.areEqual((Object) this.b, (Object) aVar.b) && Intrinsics.areEqual((Object) this.c, (Object) aVar.c) && Intrinsics.areEqual((Object) this.d, (Object) aVar.d) && Intrinsics.areEqual((Object) this.e, (Object) aVar.e) && Intrinsics.areEqual((Object) this.f, (Object) aVar.f) && Intrinsics.areEqual((Object) this.g, (Object) aVar.g);
            }

            public final int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Result<Drawable> result = this.e;
                int r0 = (hashCode4 + (result == null ? 0 : Result.m2349hashCodeimpl(result.m2353unboximpl()))) * 31;
                Result<WebView> result2 = this.f;
                if (result2 != null) {
                    i = Result.m2349hashCodeimpl(result2.m2353unboximpl());
                }
                return ((r0 + i) * 31) + this.g.hashCode();
            }

            public final String toString() {
                return "Data(title=" + this.a + ", advertiser=" + this.b + ", body=" + this.c + ", cta=" + this.d + ", icon=" + this.e + ", media=" + this.f + ", privacyIcon=" + this.g + ')';
            }
        }

        public b(a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "data");
            this.a = aVar;
        }

        static final void a(JSONObject jSONObject, String str) {
            jSONObject.put(str, new JSONObject().put("success", true));
        }

        static final <T> void a(JSONObject jSONObject, String str, Object obj) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", Result.m2351isSuccessimpl(obj));
            Throwable r5 = Result.m2347exceptionOrNullimpl(obj);
            if (r5 != null) {
                String message = r5.getMessage();
                if (message == null) {
                    message = "unknown reason";
                }
                jSONObject2.put(IronSourceConstants.EVENTS_ERROR_REASON, message);
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put(str, jSONObject2);
        }
    }

    public c(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view) {
        Intrinsics.checkNotNullParameter(view, "privacyIcon");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = drawable;
        this.f = webView;
        this.g = view;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) cVar.a) && Intrinsics.areEqual((Object) this.b, (Object) cVar.b) && Intrinsics.areEqual((Object) this.c, (Object) cVar.c) && Intrinsics.areEqual((Object) this.d, (Object) cVar.d) && Intrinsics.areEqual((Object) this.e, (Object) cVar.e) && Intrinsics.areEqual((Object) this.f, (Object) cVar.f) && Intrinsics.areEqual((Object) this.g, (Object) cVar.g);
    }

    public final int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Drawable drawable = this.e;
        int hashCode5 = (hashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        WebView webView = this.f;
        if (webView != null) {
            i = webView.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "ISNNativeAdData(title=" + this.a + ", advertiser=" + this.b + ", body=" + this.c + ", cta=" + this.d + ", icon=" + this.e + ", mediaView=" + this.f + ", privacyIcon=" + this.g + ')';
    }
}
