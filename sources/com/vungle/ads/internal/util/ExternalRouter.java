package com.vungle.ads.internal.util;

import android.content.Context;
import android.util.Log;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.ActivityManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J@\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/vungle/ads/internal/util/ExternalRouter;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getIntentFromUrl", "Landroid/content/Intent;", "url", "contextIsNotActivity", "", "launch", "deeplinkUrl", "context", "Landroid/content/Context;", "leftApplicationCallback", "Lcom/vungle/ads/internal/util/ActivityManager$LeftApplicationCallback;", "adOpenCallback", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExternalRouter.kt */
public final class ExternalRouter {
    public static final ExternalRouter INSTANCE = new ExternalRouter();
    private static final String TAG = "ExternalRouter";

    private ExternalRouter() {
    }

    @JvmStatic
    public static final boolean launch(String str, String str2, Context context, boolean z, ActivityManager.LeftApplicationCallback leftApplicationCallback, PresenterAdOpenCallback presenterAdOpenCallback) {
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = str3;
        boolean z3 = true;
        if (charSequence == null || charSequence.length() == 0) {
            CharSequence charSequence2 = str4;
            if (charSequence2 == null || charSequence2.length() == 0) {
                return false;
            }
        }
        try {
            ExternalRouter externalRouter = INSTANCE;
            ActivityManager.Companion.startWhenForeground(context, externalRouter.getIntentFromUrl(str3, z2), externalRouter.getIntentFromUrl(str4, z2), leftApplicationCallback, presenterAdOpenCallback);
            return true;
        } catch (Exception e) {
            if (!(charSequence == null || charSequence.length() == 0)) {
                z3 = false;
            }
            if (!z3) {
                AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
                AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 312, "Fail to open " + str3, "", (String) null, (String) null, 24, (Object) null);
            } else {
                AnalyticsClient analyticsClient2 = AnalyticsClient.INSTANCE;
                AnalyticsClient.logError$vungle_ads_release$default(analyticsClient2, 314, "Fail to open " + str4, "", (String) null, (String) null, 24, (Object) null);
            }
            String str5 = TAG;
            Log.e(str5, "Error while opening url" + e.getLocalizedMessage());
            Log.d(str5, "Cannot open url " + str4);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0013 A[Catch:{ URISyntaxException -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014 A[Catch:{ URISyntaxException -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.content.Intent getIntentFromUrl(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ URISyntaxException -> 0x0023 }
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r1 = r1.length()     // Catch:{ URISyntaxException -> 0x0023 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r1 = 0
            goto L_0x0011
        L_0x0010:
            r1 = 1
        L_0x0011:
            if (r1 == 0) goto L_0x0014
            goto L_0x0019
        L_0x0014:
            android.content.Intent r4 = android.content.Intent.parseUri(r4, r2)     // Catch:{ URISyntaxException -> 0x0023 }
            r0 = r4
        L_0x0019:
            if (r0 == 0) goto L_0x003c
            if (r5 == 0) goto L_0x003c
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r0.setFlags(r4)     // Catch:{ URISyntaxException -> 0x0023 }
            goto L_0x003c
        L_0x0023:
            r4 = move-exception
            java.lang.String r5 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "url format is not correct "
            r1.<init>(r2)
            java.lang.String r4 = r4.getLocalizedMessage()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            android.util.Log.e(r5, r4)
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.ExternalRouter.getIntentFromUrl(java.lang.String, boolean):android.content.Intent");
    }
}
