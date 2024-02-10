package com.wortise.ads.consent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.wortise.ads.consent.ConsentDialog;
import com.wortise.ads.k4;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\r"}, d2 = {"Lcom/wortise/ads/consent/ConsentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/wortise/ads/consent/ConsentDialog$Listener;", "()V", "onConsentRequestFinished", "", "granted", "", "(Ljava/lang/Boolean;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConsentActivity.kt */
public final class ConsentActivity extends AppCompatActivity implements ConsentDialog.Listener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_WITH_OPT_OUT = "withOptOut";

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wortise/ads/consent/ConsentActivity$Companion;", "", "()V", "EXTRA_WITH_OPT_OUT", "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "withOptOut", "", "request", "activity", "Landroid/app/Activity;", "requestCode", "", "requestOnce", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ConsentActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent getIntent(Context context, boolean z) {
            Intent putExtra = new Intent(context, ConsentActivity.class).putExtra(ConsentActivity.EXTRA_WITH_OPT_OUT, z);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, ConsentA…WITH_OPT_OUT, withOptOut)");
            return putExtra;
        }

        public static /* synthetic */ boolean request$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.request(context, z);
        }

        public static /* synthetic */ boolean requestOnce$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.requestOnce(context, z);
        }

        @JvmStatic
        public final boolean request(Activity activity, int i) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return request$default(this, activity, i, false, 4, (Object) null);
        }

        @JvmStatic
        public final boolean request(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return request$default(this, context, false, 2, (Object) null);
        }

        @JvmStatic
        public final boolean request(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            return k4.a(ConsentActivity.Companion.getIntent(context, z), context);
        }

        @JvmStatic
        public final boolean requestOnce(Activity activity, int i) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return requestOnce$default(this, activity, i, false, 4, (Object) null);
        }

        @JvmStatic
        public final boolean requestOnce(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return requestOnce$default(this, context, false, 2, (Object) null);
        }

        @JvmStatic
        public final boolean requestOnce(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (ConsentManager.isReplied(context)) {
                return false;
            }
            return request(context, z);
        }

        public static /* synthetic */ boolean request$default(Companion companion, Activity activity, int i, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return companion.request(activity, i, z);
        }

        public static /* synthetic */ boolean requestOnce$default(Companion companion, Activity activity, int i, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return companion.requestOnce(activity, i, z);
        }

        @JvmStatic
        public final boolean request(Activity activity, int i, boolean z) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return k4.a(ConsentActivity.Companion.getIntent(activity, z), activity, i);
        }

        @JvmStatic
        public final boolean requestOnce(Activity activity, int i, boolean z) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (ConsentManager.isReplied(activity)) {
                return false;
            }
            return request(activity, i, z);
        }
    }

    @JvmStatic
    public static final boolean request(Activity activity, int i) {
        return Companion.request(activity, i);
    }

    @JvmStatic
    public static final boolean request(Activity activity, int i, boolean z) {
        return Companion.request(activity, i, z);
    }

    @JvmStatic
    public static final boolean request(Context context) {
        return Companion.request(context);
    }

    @JvmStatic
    public static final boolean request(Context context, boolean z) {
        return Companion.request(context, z);
    }

    @JvmStatic
    public static final boolean requestOnce(Activity activity, int i) {
        return Companion.requestOnce(activity, i);
    }

    @JvmStatic
    public static final boolean requestOnce(Activity activity, int i, boolean z) {
        return Companion.requestOnce(activity, i, z);
    }

    @JvmStatic
    public static final boolean requestOnce(Context context) {
        return Companion.requestOnce(context);
    }

    @JvmStatic
    public static final boolean requestOnce(Context context, boolean z) {
        return Companion.requestOnce(context, z);
    }

    public void onConsentRequestFinished(Boolean bool) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ConsentManager.request(this, getIntent().getBooleanExtra(EXTRA_WITH_OPT_OUT, false), this);
    }
}
