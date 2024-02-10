package com.wortise.ads;

import android.content.Context;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.wortise.ads.AdSettings;
import com.wortise.ads.consent.ConsentManager;
import com.wortise.ads.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/wortise/ads/a0;", "", "Landroid/content/Context;", "context", "", "granted", "a", "enable", "b", "", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AppLovin.kt */
public final class a0 {
    public static final a0 a = new a0();

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/wortise/ads/a0$a;", "Lcom/wortise/ads/AdSettings$a;", "", "enabled", "", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AppLovin.kt */
    private static final class a implements AdSettings.a {
        private final Context a;

        public a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
        }

        public void a(AdContentRating adContentRating) {
            AdSettings.a.C0176a.a(this, adContentRating);
        }

        public void a(boolean z) {
            boolean unused = a0.a.b(this.a, z);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/consent/models/ConsentData;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AppLovin.kt */
    static final class b extends Lambda implements Function1<ConsentData, Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(1);
            this.a = context;
        }

        public final void a(ConsentData consentData) {
            Intrinsics.checkNotNullParameter(consentData, "it");
            a0 a0Var = a0.a;
            Context context = this.a;
            boolean unused = a0Var.a(context, consentData.canRequestPersonalizedAds(context));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((ConsentData) obj);
            return Unit.INSTANCE;
        }
    }

    private a0() {
    }

    static /* synthetic */ boolean b(a0 a0Var, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = AdSettings.isChildDirected(context);
        }
        return a0Var.b(context, z);
    }

    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a(this, context, false, 2, (Object) null);
        b(this, context, false, 2, (Object) null);
        ConsentManager.addListener(new b(context));
        AdSettings.INSTANCE.addListener$sdk_productionRelease(new a(context));
    }

    /* access modifiers changed from: private */
    public final boolean b(Context context, boolean z) {
        try {
            AppLovinPrivacySettings.setIsAgeRestrictedUser(z, context);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ boolean a(a0 a0Var, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = ConsentManager.canRequestPersonalizedAds(context);
        }
        return a0Var.a(context, z);
    }

    /* access modifiers changed from: private */
    public final boolean a(Context context, boolean z) {
        try {
            AppLovinPrivacySettings.setHasUserConsent(z, context);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
