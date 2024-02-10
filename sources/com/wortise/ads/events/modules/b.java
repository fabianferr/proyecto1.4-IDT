package com.wortise.ads.events.modules;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdType;
import com.wortise.ads.geofencing.models.GeofenceEvent;
import com.wortise.ads.k4;
import com.wortise.ads.push.PushInterstitialActivity;
import com.wortise.ads.push.models.Notification;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0014R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/wortise/ads/events/modules/b;", "Lcom/wortise/ads/events/modules/a;", "", "canHandle", "onOpenTarget", "Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "event$delegate", "Lkotlin/Lazy;", "getEvent", "()Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "event", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "", "getLogExtras", "()Ljava/lang/Object;", "logExtras", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "adExtras", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Landroid/os/Bundle;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PushHandler.kt */
public final class b extends a {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String EXTRA_EVENT = "event";
    private final Lazy event$delegate;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/events/modules/b$a;", "", "", "EXTRA_EVENT", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: PushHandler.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.events.modules.b$b  reason: collision with other inner class name */
    /* compiled from: PushHandler.kt */
    static final class C0183b extends Lambda implements Function0<GeofenceEvent> {
        final /* synthetic */ Bundle a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0183b(Bundle bundle) {
            super(0);
            this.a = bundle;
        }

        /* renamed from: a */
        public final GeofenceEvent invoke() {
            Bundle bundle = this.a;
            if (bundle == null) {
                return null;
            }
            return (GeofenceEvent) bundle.getParcelable("event");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, AdResponse adResponse, Bundle bundle) {
        super(context, adResponse, bundle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.event$delegate = LazyKt.lazy(new C0183b(bundle));
    }

    private final GeofenceEvent getEvent() {
        return (GeofenceEvent) this.event$delegate.getValue();
    }

    private final Intent getIntent() {
        AdResponse a2;
        Notification m = getAdResponse().m();
        if (m == null || (a2 = m.a()) == null) {
            return null;
        }
        return PushInterstitialActivity.Companion.a(getContext(), a2);
    }

    public boolean canHandle() {
        return getAdResponse().a(AdType.PUSH);
    }

    /* access modifiers changed from: protected */
    public Object getLogExtras() {
        return getEvent();
    }

    /* access modifiers changed from: protected */
    public boolean onOpenTarget() {
        Intent intent = getIntent();
        Boolean valueOf = intent == null ? null : Boolean.valueOf(k4.a(intent, getContext()));
        return valueOf == null ? super.onOpenTarget() : valueOf.booleanValue();
    }
}
