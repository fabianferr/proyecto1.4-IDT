package com.vungle.ads.internal.ui;

import android.os.Handler;
import android.webkit.WebView;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import kotlinx.serialization.json.JsonObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VungleWebClient$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ WebViewAPI.MraidDelegate f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ JsonObject f$2;
    public final /* synthetic */ Handler f$3;
    public final /* synthetic */ VungleWebClient f$4;
    public final /* synthetic */ WebView f$5;

    public /* synthetic */ VungleWebClient$$ExternalSyntheticLambda1(WebViewAPI.MraidDelegate mraidDelegate, String str, JsonObject jsonObject, Handler handler, VungleWebClient vungleWebClient, WebView webView) {
        this.f$0 = mraidDelegate;
        this.f$1 = str;
        this.f$2 = jsonObject;
        this.f$3 = handler;
        this.f$4 = vungleWebClient;
        this.f$5 = webView;
    }

    public final void run() {
        VungleWebClient.m270shouldOverrideUrlLoading$lambda4$lambda3$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
