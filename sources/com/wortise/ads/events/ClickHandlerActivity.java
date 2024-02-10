package com.wortise.ads.events;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.wortise.ads.AdResponse;
import com.wortise.ads.R;
import com.wortise.ads.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\n"}, d2 = {"Lcom/wortise/ads/events/ClickHandlerActivity;", "Landroidx/fragment/app/FragmentActivity;", "", "a", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "<init>", "()V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ClickHandlerActivity.kt */
public final class ClickHandlerActivity extends FragmentActivity {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/events/ClickHandlerActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "adExtras", "Landroid/content/Intent;", "a", "", "EXTRA_AD_EXTRAS", "Ljava/lang/String;", "EXTRA_AD_RESPONSE", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: ClickHandlerActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, AdResponse adResponse, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intent putExtra = new Intent(context, ClickHandlerActivity.class).putExtra("adResponse", adResponse).putExtra("adExtras", bundle);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, ClickHan…RA_AD_EXTRAS,   adExtras)");
            return putExtra;
        }
    }

    private final void a() {
        AdResponse adResponse = (AdResponse) getIntent().getParcelableExtra("adResponse");
        if (adResponse != null) {
            s2.a.a(this, adResponse, getIntent().getBundleExtra("adExtras"), true);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.wortise_activity_click_handler);
        a();
        finish();
    }
}
