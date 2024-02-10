package com.wortise.ads.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.TaskStackBuilder;
import com.wortise.ads.AdResponse;
import com.wortise.ads.interstitial.InterstitialActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/push/PushInterstitialActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/content/Intent;", "a", "()Landroid/content/Intent;", "adIntent", "Lcom/wortise/ads/AdResponse;", "b", "()Lcom/wortise/ads/AdResponse;", "adResponse", "c", "launchIntent", "<init>", "()V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PushInterstitialActivity.kt */
public final class PushInterstitialActivity extends Activity {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/wortise/ads/push/PushInterstitialActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "response", "Landroid/content/Intent;", "a", "", "EXTRA_AD_RESPONSE", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: PushInterstitialActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adResponse, "response");
            Intent putExtra = new Intent(context, PushInterstitialActivity.class).putExtra("adResponse", adResponse);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, PushInte…RA_AD_RESPONSE, response)");
            return putExtra;
        }
    }

    private final Intent a() {
        AdResponse b = b();
        if (b == null) {
            return null;
        }
        return InterstitialActivity.Companion.a(this, b, 0);
    }

    private final AdResponse b() {
        return (AdResponse) getIntent().getParcelableExtra("adResponse");
    }

    private final Intent c() {
        return getPackageManager().getLaunchIntentForPackage(getPackageName());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TaskStackBuilder create = TaskStackBuilder.create(this);
        Intent c = c();
        if (c != null) {
            create.addNextIntent(c);
        }
        Intent a2 = a();
        if (a2 != null) {
            create.addNextIntentWithParentStack(a2);
        }
        Intrinsics.checkNotNullExpressionValue(create, "create(this).apply {\n\n  …rentStack(it) }\n        }");
        create.startActivities();
    }
}
