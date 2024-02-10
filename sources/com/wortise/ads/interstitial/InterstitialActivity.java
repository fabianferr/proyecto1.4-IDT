package com.wortise.ads.interstitial;

import android.content.Context;
import android.content.Intent;
import com.wortise.ads.AdResponse;
import com.wortise.ads.u2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/wortise/ads/interstitial/InterstitialActivity;", "Lcom/wortise/ads/u2;", "<init>", "()V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: InterstitialActivity.kt */
public final class InterstitialActivity extends u2 {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/wortise/ads/interstitial/InterstitialActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "response", "", "identifier", "Landroid/content/Intent;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: InterstitialActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, AdResponse adResponse, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adResponse, "response");
            return u2.Companion.a(context, Reflection.getOrCreateKotlinClass(InterstitialActivity.class), adResponse, j);
        }
    }
}
