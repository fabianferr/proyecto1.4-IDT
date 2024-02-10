package com.ironsource.sdk.k;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.a.h;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.k.d;
import com.ironsource.sdk.k.e;
import com.ironsource.sdk.k.g;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002 #\u0018\u0000 .2\u00020\u0001:\u0001.B!\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\r\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010!J\r\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAd;", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface;", "id", "", "controller", "Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface;", "eventTracker", "Lcom/ironsource/sdk/Events/ISNEventTrackerInterface;", "(Ljava/lang/String;Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface;Lcom/ironsource/sdk/Events/ISNEventTrackerInterface;)V", "<set-?>", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "adData", "getAdData", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "demandSourceName", "getDemandSourceName", "()Ljava/lang/String;", "isBidding", "listener", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;", "getListener", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;", "setListener", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;)V", "startTime", "", "Ljava/lang/Long;", "viewHolder", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder;", "baseEventParams", "Lcom/ironsource/sdk/Events/ISNEventParams;", "createControllerApiListener", "com/ironsource/sdk/nativeAd/ISNNativeAd$createControllerApiListener$1", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAd$createControllerApiListener$1;", "createViewHolderListener", "com/ironsource/sdk/nativeAd/ISNNativeAd$createViewHolderListener$1", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAd$createViewHolderListener$1;", "destroy", "", "load", "activity", "Landroid/app/Activity;", "loadParams", "Lorg/json/JSONObject;", "loadDuration", "register", "Companion", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements d {
    public static final C0122a a = new C0122a((byte) 0);
    public final g b;
    public final com.ironsource.sdk.a.b c;
    public String d;
    public String e;
    public Long f;
    public d.a g;
    public e h;
    private final String i;
    /* access modifiers changed from: private */
    public c j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAd$Companion;", "", "()V", "create", "Lcom/ironsource/sdk/nativeAd/ISNNativeAd;", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.ironsource.sdk.k.a$a  reason: collision with other inner class name */
    public static final class C0122a {
        private C0122a() {
        }

        public /* synthetic */ C0122a(byte b) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/ironsource/sdk/nativeAd/ISNNativeAd$createControllerApiListener$1", "Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;", "onClicked", "", "onLoadFailed", "reason", "", "onLoadSuccess", "adData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "onShown", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements g.a {
        private /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        public final void a() {
            d.a aVar = this.a.g;
            if (aVar != null) {
                aVar.onNativeAdClicked();
            }
        }

        public final void a(c cVar) {
            Intrinsics.checkNotNullParameter(cVar, "adData");
            this.a.j = cVar;
            com.ironsource.sdk.a.b a2 = this.a.c;
            h.a aVar = h.l;
            Intrinsics.checkNotNullExpressionValue(aVar, "loadAdSuccess");
            HashMap<String, Object> hashMap = this.a.b().a;
            Intrinsics.checkNotNullExpressionValue(hashMap, "baseEventParams().data");
            a2.a(aVar, hashMap);
            d.a aVar2 = this.a.g;
            if (aVar2 != null) {
                aVar2.onNativeAdLoadSuccess(cVar);
            }
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_ERROR_REASON);
            com.ironsource.sdk.a.a a2 = this.a.b().a("callfailreason", str);
            com.ironsource.sdk.a.b a3 = this.a.c;
            h.a aVar = h.g;
            Intrinsics.checkNotNullExpressionValue(aVar, "loadAdFailed");
            HashMap<String, Object> hashMap = a2.a;
            Intrinsics.checkNotNullExpressionValue(hashMap, "eventParams.data");
            a3.a(aVar, hashMap);
            d.a aVar2 = this.a.g;
            if (aVar2 != null) {
                aVar2.onNativeAdLoadFailed(str);
            }
        }

        public final void b() {
            d.a aVar = this.a.g;
            if (aVar != null) {
                aVar.onNativeAdShown();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ironsource/sdk/nativeAd/ISNNativeAd$createViewHolderListener$1", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$Listener;", "onViewClicked", "", "viewName", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder$ViewName;", "onVisibilityChanged", "viewVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements e.a {
        private /* synthetic */ a a;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.ironsource.sdk.k.a$c$a  reason: collision with other inner class name */
        public /* synthetic */ class C0123a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[e.b.values().length];
                iArr[e.b.PrivacyIcon.ordinal()] = 1;
                a = iArr;
            }
        }

        c(a aVar) {
            this.a = aVar;
        }

        public final void a(com.ironsource.sdk.g.g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "viewVisibilityParams");
            this.a.b.a(gVar);
        }

        public final void a(e.b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "viewName");
            if (C0123a.a[bVar.ordinal()] == 1) {
                this.a.b.b();
                return;
            }
            JSONObject put = new JSONObject().put("viewName", bVar.a);
            g c = this.a.b;
            Intrinsics.checkNotNullExpressionValue(put, "clickParams");
            c.a(put);
        }
    }

    public a(String str, g gVar, com.ironsource.sdk.a.b bVar) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(gVar, "controller");
        Intrinsics.checkNotNullParameter(bVar, "eventTracker");
        this.i = str;
        this.b = gVar;
        this.c = bVar;
        gVar.a((g.a) new b(this));
    }

    private final long c() {
        Long l = this.f;
        if (l == null) {
            return -1;
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue();
    }

    public final c a() {
        return this.j;
    }

    public final void a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "viewHolder");
        Map linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> hashMap = b().a;
        Intrinsics.checkNotNullExpressionValue(hashMap, "baseEventParams().data");
        linkedHashMap.putAll(hashMap);
        String jSONObject = eVar.a().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "viewHolder.viewsStatus().toString()");
        linkedHashMap.put("generalmessage", jSONObject);
        com.ironsource.sdk.a.b bVar = this.c;
        h.a aVar = h.n;
        Intrinsics.checkNotNullExpressionValue(aVar, "registerAd");
        bVar.a(aVar, linkedHashMap);
        this.h = eVar;
        eVar.a = new c(this);
        this.b.a(eVar);
    }

    public final com.ironsource.sdk.a.a b() {
        com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("isbiddinginstance", this.e).a("demandsourcename", this.d).a("producttype", d.e.NativeAd.toString()).a("custom_c", Long.valueOf(c()));
        Intrinsics.checkNotNullExpressionValue(a2, "ISNEventParams()\n\t\t\t.add…CUSTOM_C, loadDuration())");
        return a2;
    }
}
