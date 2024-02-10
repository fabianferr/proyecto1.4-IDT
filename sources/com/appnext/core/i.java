package com.appnext.core;

import android.content.Context;
import android.widget.ImageView;
import com.appnext.core.j;

public final class i {
    public static void a(Context context, final ImageView imageView) {
        j.Y().a(context, imageView, "https://cdn.appnext.com/tools/sdk/adchoices/adchoices_big.png", new j.a() {
            public final void X() {
                imageView.setImageResource(R.drawable.apnxt_adchoices);
            }
        });
    }

    public static boolean a(AppnextAd appnextAd, SettingsManager settingsManager) {
        return appnextAd.isGdpr() && Boolean.parseBoolean(settingsManager.t("gdpr"));
    }
}
