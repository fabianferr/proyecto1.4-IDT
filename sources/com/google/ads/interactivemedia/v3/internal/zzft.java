package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzft {
    private final WebView zza;
    private final Handler zzb;
    private zzfq zzc;
    private boolean zzd = false;

    zzft(Handler handler, WebView webView, Uri uri) {
        this.zzb = handler;
        this.zza = webView;
        webView.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT > 19) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            String format = String.format("%s://%s", new Object[]{uri.getScheme(), uri.getHost()});
            if (uri.getPort() != -1) {
                format = String.format(ScarConstants.TOKEN_WITH_SCAR_FORMAT, new Object[]{format, Integer.valueOf(uri.getPort())});
            }
            WebViewCompat.addWebMessageListener(webView, "androidWebViewCompatSender", zzst.zzm(format), new zzfp(this));
        }
        webView.setWebViewClient(new zzfs(this));
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            instance.setAcceptThirdPartyCookies(webView, true);
        }
    }

    public final WebView zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.post(new zzfn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zzd = true;
        this.zza.destroy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzff zzff) {
        String zzg = zzff.zzg();
        if (this.zzd) {
            String obj = zzff.toString();
            zzhd.zzd("Attempted to send bridge message after cleanup: " + obj + "; " + zzg);
            return;
        }
        String obj2 = zzff.toString();
        zzhd.zzc("Sending Javascript msg: " + obj2 + "; URL: " + zzg);
        try {
            this.zza.evaluateJavascript(zzg, (ValueCallback) null);
        } catch (IllegalStateException unused) {
            this.zza.loadUrl(zzg);
        }
    }

    public final void zze(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = ", Message Type: "
            java.lang.String r1 = "Received Javascript msg: "
            int r2 = r7.hashCode()     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            r3 = 48
            r4 = 1
            if (r2 == r3) goto L_0x001c
            r3 = 52
            if (r2 == r3) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "4"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0026
            r2 = 1
            goto L_0x0027
        L_0x001c:
            java.lang.String r2 = "0"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0026
            r2 = 0
            goto L_0x0027
        L_0x0026:
            r2 = -1
        L_0x0027:
            if (r2 == 0) goto L_0x0032
            if (r2 == r4) goto L_0x002d
            r2 = 0
            goto L_0x0036
        L_0x002d:
            com.google.ads.interactivemedia.v3.internal.zzff r2 = com.google.ads.interactivemedia.v3.internal.zzff.zzd(r6)     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            goto L_0x0036
        L_0x0032:
            com.google.ads.interactivemedia.v3.internal.zzff r2 = com.google.ads.interactivemedia.v3.internal.zzff.zzc(r6)     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
        L_0x0036:
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            r4.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            r4.append(r3)     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            java.lang.String r1 = r4.toString()     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            com.google.ads.interactivemedia.v3.internal.zzhd.zzc(r1)     // Catch:{ IllegalArgumentException -> 0x0068, Exception -> 0x004f }
            com.google.ads.interactivemedia.v3.internal.zzfq r6 = r5.zzc
            r6.zzl(r2)
            return
        L_0x004f:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid internal message. Message could not be be parsed: "
            r2.<init>(r3)
            r2.append(r6)
            r2.append(r0)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            com.google.ads.interactivemedia.v3.internal.zzhd.zzb(r6, r1)
            return
        L_0x0068:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid internal message. Make sure the Google IMA SDK library is up to date. Message: "
            r1.<init>(r2)
            r1.append(r6)
            r1.append(r0)
            r1.append(r7)
            java.lang.String r6 = r1.toString()
            com.google.ads.interactivemedia.v3.internal.zzhd.zzd(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzft.zzf(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final void zzg(zzfq zzfq) {
        this.zzc = zzfq;
    }

    public final void zzh(zzff zzff) {
        this.zzb.post(new zzfo(this, zzff));
    }
}
