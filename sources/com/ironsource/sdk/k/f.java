package com.ironsource.sdk.k;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.c.a;
import com.ironsource.sdk.controller.g;
import com.ironsource.sdk.controller.h;
import com.ironsource.sdk.controller.n;
import com.ironsource.sdk.controller.r;
import com.ironsource.sdk.k.g;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u00014B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ironsource/sdk/nativeAd/NativeAdControllerApi;", "Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface;", "id", "", "controllerManager", "Lcom/ironsource/sdk/controller/ControllerManager;", "imageLoader", "Lcom/ironsource/sdk/utils/loaders/ImageLoaderInterface;", "adViewManagement", "Lcom/ironsource/sdk/WPAD/AdViewManagement;", "(Ljava/lang/String;Lcom/ironsource/sdk/controller/ControllerManager;Lcom/ironsource/sdk/utils/loaders/ImageLoaderInterface;Lcom/ironsource/sdk/WPAD/AdViewManagement;)V", "listener", "Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;", "getListener", "()Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;", "setListener", "(Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;)V", "logTag", "kotlin.jvm.PlatformType", "click", "", "clickParams", "Lorg/json/JSONObject;", "createMessageListener", "Lcom/ironsource/sdk/controller/IronSourceController$ControllerMessageListener;", "destroy", "load", "activity", "Landroid/app/Activity;", "loadParams", "mediaViewClickCommand", "onClickResponse", "response", "Lcom/ironsource/sdk/controller/ControllerMessage$CallbackToNative;", "onLoadResponse", "onMediaClick", "msg", "Lcom/ironsource/sdk/controller/MessageToNative;", "onReportResponse", "adData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "onVisibilityChangeResponse", "privacyClick", "register", "viewHolder", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder;", "sendLoadReport", "report", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData$Report;", "visibilityChanged", "viewVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "Commands", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements g {
    private final String a;
    private final g b;
    private final d c;
    private final a d;
    private final String e;
    private g.a f;

    private f(String str, com.ironsource.sdk.controller.g gVar, d dVar, a aVar) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(gVar, "controllerManager");
        Intrinsics.checkNotNullParameter(dVar, "imageLoader");
        Intrinsics.checkNotNullParameter(aVar, "adViewManagement");
        this.a = str;
        this.b = gVar;
        this.c = dVar;
        this.d = aVar;
        this.e = getClass().getSimpleName();
        gVar.b.put(str, new f$$ExternalSyntheticLambda2(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(java.lang.String r1, com.ironsource.sdk.controller.g r2, com.ironsource.sdk.utils.a.d r3, com.ironsource.sdk.c.a r4, int r5) {
        /*
            r0 = this;
            com.ironsource.sdk.utils.a.c r3 = new com.ironsource.sdk.utils.a.c
            r4 = 0
            r5 = 1
            r3.<init>(r4, r5)
            com.ironsource.sdk.utils.a.d r3 = (com.ironsource.sdk.utils.a.d) r3
            com.ironsource.sdk.c.e r4 = com.ironsource.sdk.c.e.a()
            java.lang.String r5 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.ironsource.sdk.c.a r4 = (com.ironsource.sdk.c.a) r4
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.k.f.<init>(java.lang.String, com.ironsource.sdk.controller.g, com.ironsource.sdk.utils.a.d, com.ironsource.sdk.c.a, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.ironsource.sdk.k.f r19, android.app.Activity r20, com.ironsource.sdk.controller.h.a r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "$activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            org.json.JSONObject r3 = r2.a
            if (r3 != 0) goto L_0x0026
            com.ironsource.sdk.k.g$a r0 = r0.f
            if (r0 == 0) goto L_0x0025
            java.lang.String r1 = "failed to load native ad: missing params"
        L_0x0020:
            r0.a((java.lang.String) r1)
            goto L_0x020c
        L_0x0025:
            return
        L_0x0026:
            org.json.JSONObject r3 = r2.a
            java.lang.String r4 = "success"
            r5 = 0
            boolean r3 = r3.optBoolean(r4, r5)
            if (r3 != 0) goto L_0x0045
            org.json.JSONObject r1 = r2.a
            java.lang.String r2 = "failed to load native ad: unexpected error"
            java.lang.String r3 = "reason"
            java.lang.String r1 = r1.optString(r3, r2)
            com.ironsource.sdk.k.g$a r0 = r0.f
            if (r0 == 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            goto L_0x0020
        L_0x0044:
            return
        L_0x0045:
            com.ironsource.sdk.k.c$a r3 = new com.ironsource.sdk.k.c$a
            com.ironsource.sdk.utils.a.d r4 = r0.c
            com.ironsource.sdk.c.a r5 = r0.d
            r3.<init>(r4, r5)
            android.content.Context r1 = (android.content.Context) r1
            org.json.JSONObject r2 = r2.a
            java.lang.String r4 = "activityContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "title"
            org.json.JSONObject r5 = r2.optJSONObject(r4)
            java.lang.String r6 = "text"
            if (r5 == 0) goto L_0x006e
            java.lang.String r5 = com.ironsource.environment.l.a.a((org.json.JSONObject) r5, (java.lang.String) r6)
            r9 = r5
            goto L_0x006f
        L_0x006e:
            r9 = 0
        L_0x006f:
            java.lang.String r5 = "advertiser"
            org.json.JSONObject r8 = r2.optJSONObject(r5)
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = com.ironsource.environment.l.a.a((org.json.JSONObject) r8, (java.lang.String) r6)
            r10 = r8
            goto L_0x007e
        L_0x007d:
            r10 = 0
        L_0x007e:
            java.lang.String r15 = "body"
            org.json.JSONObject r8 = r2.optJSONObject(r15)
            if (r8 == 0) goto L_0x008c
            java.lang.String r8 = com.ironsource.environment.l.a.a((org.json.JSONObject) r8, (java.lang.String) r6)
            r11 = r8
            goto L_0x008d
        L_0x008c:
            r11 = 0
        L_0x008d:
            java.lang.String r14 = "cta"
            org.json.JSONObject r8 = r2.optJSONObject(r14)
            if (r8 == 0) goto L_0x009b
            java.lang.String r6 = com.ironsource.environment.l.a.a((org.json.JSONObject) r8, (java.lang.String) r6)
            r12 = r6
            goto L_0x009c
        L_0x009b:
            r12 = 0
        L_0x009c:
            java.lang.String r6 = "icon"
            org.json.JSONObject r8 = r2.optJSONObject(r6)
            java.lang.String r13 = "url"
            if (r8 == 0) goto L_0x00ac
            java.lang.String r8 = com.ironsource.environment.l.a.a((org.json.JSONObject) r8, (java.lang.String) r13)
            goto L_0x00ad
        L_0x00ac:
            r8 = 0
        L_0x00ad:
            java.lang.String r7 = "media"
            r21 = r14
            org.json.JSONObject r14 = r2.optJSONObject(r7)
            r16 = r15
            if (r14 == 0) goto L_0x00c0
            java.lang.String r15 = "adViewId"
            java.lang.String r14 = com.ironsource.environment.l.a.a((org.json.JSONObject) r14, (java.lang.String) r15)
            goto L_0x00c1
        L_0x00c0:
            r14 = 0
        L_0x00c1:
            java.lang.String r15 = "privacyIcon"
            org.json.JSONObject r2 = r2.optJSONObject(r15)
            if (r2 == 0) goto L_0x00ce
            java.lang.String r2 = com.ironsource.environment.l.a.a((org.json.JSONObject) r2, (java.lang.String) r13)
            goto L_0x00cf
        L_0x00ce:
            r2 = 0
        L_0x00cf:
            if (r14 != 0) goto L_0x00d5
            r17 = r7
            r14 = 0
            goto L_0x0119
        L_0x00d5:
            com.ironsource.sdk.c.a r13 = r3.b
            com.ironsource.sdk.c.f r13 = r13.a(r14)
            if (r13 == 0) goto L_0x00e2
            android.webkit.WebView r13 = r13.a()
            goto L_0x00e3
        L_0x00e2:
            r13 = 0
        L_0x00e3:
            if (r13 != 0) goto L_0x010c
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            java.lang.Exception r13 = new java.lang.Exception
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r17 = r7
            java.lang.String r7 = "missing adview for id: '"
            r15.<init>(r7)
            r15.append(r14)
            r7 = 39
            r15.append(r7)
            java.lang.String r7 = r15.toString()
            r13.<init>(r7)
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r7 = kotlin.Result.m2344constructorimpl(r7)
            goto L_0x0114
        L_0x010c:
            r17 = r7
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.Result.m2344constructorimpl(r13)
        L_0x0114:
            kotlin.Result r7 = kotlin.Result.m2343boximpl(r7)
            r14 = r7
        L_0x0119:
            if (r8 != 0) goto L_0x011d
            r13 = 0
            goto L_0x0128
        L_0x011d:
            com.ironsource.sdk.utils.a.d r7 = r3.a
            java.lang.Object r7 = r7.a(r8)
            kotlin.Result r7 = kotlin.Result.m2343boximpl(r7)
            r13 = r7
        L_0x0128:
            com.ironsource.sdk.k.h$a r7 = com.ironsource.sdk.k.h.a
            com.ironsource.sdk.utils.a.d r3 = r3.a
            java.lang.String r7 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r7)
            java.lang.String r7 = "imageLoader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r7)
            if (r2 == 0) goto L_0x0153
            java.lang.Object r2 = r3.a(r2)
            boolean r3 = kotlin.Result.m2350isFailureimpl(r2)
            if (r3 == 0) goto L_0x0143
            r2 = 0
        L_0x0143:
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            if (r2 == 0) goto L_0x0153
            android.widget.ImageView r3 = new android.widget.ImageView
            r3.<init>(r1)
            r3.setImageDrawable(r2)
            android.view.View r3 = (android.view.View) r3
            r15 = r3
            goto L_0x0158
        L_0x0153:
            android.view.View r1 = com.ironsource.sdk.k.h.a.a(r1)
            r15 = r1
        L_0x0158:
            com.ironsource.sdk.k.c$b$a r1 = new com.ironsource.sdk.k.c$b$a
            r8 = r1
            r2 = r21
            r3 = r16
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            com.ironsource.sdk.k.c$b r7 = new com.ironsource.sdk.k.c$b
            r7.<init>(r1)
            com.ironsource.sdk.k.c$b$a r1 = r7.a
            com.ironsource.sdk.k.c r15 = new com.ironsource.sdk.k.c
            java.lang.String r9 = r1.a
            java.lang.String r10 = r1.b
            java.lang.String r11 = r1.c
            java.lang.String r12 = r1.d
            kotlin.Result<android.graphics.drawable.Drawable> r8 = r1.e
            if (r8 == 0) goto L_0x0186
            java.lang.Object r8 = r8.m2353unboximpl()
            boolean r13 = kotlin.Result.m2350isFailureimpl(r8)
            if (r13 == 0) goto L_0x0182
            r8 = 0
        L_0x0182:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            r13 = r8
            goto L_0x0187
        L_0x0186:
            r13 = 0
        L_0x0187:
            kotlin.Result<android.webkit.WebView> r8 = r1.f
            if (r8 == 0) goto L_0x019a
            java.lang.Object r8 = r8.m2353unboximpl()
            boolean r14 = kotlin.Result.m2350isFailureimpl(r8)
            if (r14 == 0) goto L_0x0196
            r8 = 0
        L_0x0196:
            android.webkit.WebView r8 = (android.webkit.WebView) r8
            r14 = r8
            goto L_0x019b
        L_0x019a:
            r14 = 0
        L_0x019b:
            android.view.View r1 = r1.g
            r8 = r15
            r18 = r15
            r15 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r8 = "nativeAd.loadReport."
            r1.<init>(r8)
            java.lang.String r8 = r0.a
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.ironsource.sdk.controller.h$b r8 = new com.ironsource.sdk.controller.h$b
            java.lang.String r9 = r0.a
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            com.ironsource.sdk.k.c$b$a r11 = r7.a
            java.lang.String r11 = r11.a
            if (r11 == 0) goto L_0x01c6
            com.ironsource.sdk.k.c.b.a(r10, r4)
        L_0x01c6:
            com.ironsource.sdk.k.c$b$a r4 = r7.a
            java.lang.String r4 = r4.b
            if (r4 == 0) goto L_0x01cf
            com.ironsource.sdk.k.c.b.a(r10, r5)
        L_0x01cf:
            com.ironsource.sdk.k.c$b$a r4 = r7.a
            java.lang.String r4 = r4.c
            if (r4 == 0) goto L_0x01d8
            com.ironsource.sdk.k.c.b.a(r10, r3)
        L_0x01d8:
            com.ironsource.sdk.k.c$b$a r3 = r7.a
            java.lang.String r3 = r3.d
            if (r3 == 0) goto L_0x01e1
            com.ironsource.sdk.k.c.b.a(r10, r2)
        L_0x01e1:
            com.ironsource.sdk.k.c$b$a r2 = r7.a
            kotlin.Result<android.graphics.drawable.Drawable> r2 = r2.e
            if (r2 == 0) goto L_0x01ee
            java.lang.Object r2 = r2.m2353unboximpl()
            com.ironsource.sdk.k.c.b.a(r10, r6, r2)
        L_0x01ee:
            com.ironsource.sdk.k.c$b$a r2 = r7.a
            kotlin.Result<android.webkit.WebView> r2 = r2.f
            if (r2 == 0) goto L_0x01fd
            java.lang.Object r2 = r2.m2353unboximpl()
            r3 = r17
            com.ironsource.sdk.k.c.b.a(r10, r3, r2)
        L_0x01fd:
            r8.<init>(r9, r1, r10)
            com.ironsource.sdk.controller.g r1 = r0.b
            com.ironsource.sdk.k.f$$ExternalSyntheticLambda4 r2 = new com.ironsource.sdk.k.f$$ExternalSyntheticLambda4
            r3 = r18
            r2.<init>(r0, r3)
            r1.a((com.ironsource.sdk.controller.h.b) r8, (com.ironsource.sdk.controller.n.a) r2)
        L_0x020c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.k.f.a(com.ironsource.sdk.k.f, android.app.Activity, com.ironsource.sdk.controller.h$a):void");
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, h.a aVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "it");
        if (aVar.a == null) {
            str = fVar.e;
            str2 = "failed to handle show on native ad: missing params";
        } else if (!aVar.a.optBoolean("success", false)) {
            String optString = aVar.a.optString(IronSourceConstants.EVENTS_ERROR_REASON, "unexpected error");
            str = fVar.e;
            str2 = "failed to handle show on native ad: " + optString;
        } else {
            g.a aVar2 = fVar.f;
            if (aVar2 != null) {
                aVar2.b();
                return;
            }
            return;
        }
        Logger.i(str, str2);
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, r rVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(rVar, NotificationCompat.CATEGORY_MESSAGE);
        if (Intrinsics.areEqual((Object) rVar.a, (Object) "nativeAd.click")) {
            if (rVar.b == null) {
                str = fVar.e;
                str2 = "failed to handle click on native ad: missing params";
            } else if (!rVar.b.optBoolean("success", false)) {
                String optString = rVar.b.optString(IronSourceConstants.EVENTS_ERROR_REASON, "unexpected error");
                str = fVar.e;
                str2 = "failed to handle click on native ad: " + optString;
            } else {
                g.a aVar = fVar.f;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            Logger.i(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, c cVar, h.a aVar) {
        String optString;
        g.a aVar2;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(cVar, "$adData");
        Intrinsics.checkNotNullParameter(aVar, "it");
        if (aVar.a == null) {
            aVar2 = fVar.f;
            if (aVar2 != null) {
                optString = "failed to load native ad: missing report params";
            } else {
                return;
            }
        } else if (!aVar.a.optBoolean("success", false)) {
            optString = aVar.a.optString(IronSourceConstants.EVENTS_ERROR_REASON, "failed to load native ad: unexpected error");
            aVar2 = fVar.f;
            if (aVar2 != null) {
                Intrinsics.checkNotNullExpressionValue(optString, IronSourceConstants.EVENTS_ERROR_REASON);
            } else {
                return;
            }
        } else {
            g.a aVar3 = fVar.f;
            if (aVar3 != null) {
                aVar3.a(cVar);
                return;
            }
            return;
        }
        aVar2.a(optString);
    }

    /* access modifiers changed from: private */
    public static final void b(f fVar, h.a aVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "it");
        if (aVar.a == null) {
            str = fVar.e;
            str2 = "failed to handle click on native ad: missing params";
        } else if (!aVar.a.optBoolean("success", false)) {
            String optString = aVar.a.optString(IronSourceConstants.EVENTS_ERROR_REASON, "unexpected error");
            str = fVar.e;
            str2 = "failed to handle click on native ad: " + optString;
        } else {
            g.a aVar2 = fVar.f;
            if (aVar2 != null) {
                aVar2.a();
                return;
            }
            return;
        }
        Logger.i(str, str2);
    }

    public final void a() {
        this.b.a(new h.b(this.a, "nativeAd.destroy", new JSONObject()), (n.a) null);
    }

    public final void a(Activity activity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(jSONObject, "loadParams");
        this.b.a(activity);
        this.b.a(new h.b(this.a, "nativeAd.load", jSONObject), (n.a) new f$$ExternalSyntheticLambda1(this, activity));
    }

    public final void a(com.ironsource.sdk.g.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "viewVisibilityParams");
        String str = this.a;
        JSONObject put = new JSONObject().put("isVisible", gVar.a).put("isWindowVisible", gVar.b).put("isShown", gVar.c);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n\t\t\t.put(ISN…ts.IS_SHOWN_KEY, isShown)");
        this.b.a(new h.b(str, "nativeAd.visibilityChanged", put), (n.a) new f$$ExternalSyntheticLambda3(this));
    }

    public final void a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "viewHolder");
        JSONObject put = new JSONObject().put("assetViews", eVar.a());
        JSONObject put2 = new JSONObject().put("command", "nativeAd.click").put("sdkCallback", "onReceivedMessage");
        Intrinsics.checkNotNullExpressionValue(put2, "JSONObject()\n\t\t\t.put(Con…hods.ON_RECEIVED_MESSAGE)");
        JSONObject put3 = put.put("adViewClickCommand", put2);
        String str = this.a;
        Intrinsics.checkNotNullExpressionValue(put3, NativeProtocol.WEB_DIALOG_PARAMS);
        this.b.a(new h.b(str, "nativeAd.register", put3), (n.a) null);
    }

    public final void a(g.a aVar) {
        this.f = aVar;
    }

    public final void a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "clickParams");
        this.b.a(new h.b(this.a, "nativeAd.click", jSONObject), (n.a) new f$$ExternalSyntheticLambda0(this));
    }

    public final void b() {
        this.b.a(new h.b(this.a, "nativeAd.privacyClick", new JSONObject()), (n.a) null);
    }
}
