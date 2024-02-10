package com.ironsource.sdk.k;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ironsource/sdk/nativeAd/PrivacyIconView;", "", "()V", "Companion", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {
    public static final a a = new a((byte) 0);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/ironsource/sdk/nativeAd/PrivacyIconView$Companion;", "", "()V", "create", "Landroid/view/View;", "context", "Landroid/content/Context;", "privacyIconUrl", "", "imageLoader", "Lcom/ironsource/sdk/utils/loaders/ImageLoaderInterface;", "getDefaultPrivacyIconView", "activityContext", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static final GradientDrawable a() {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(Color.parseColor("#000000"));
            return gradientDrawable;
        }

        static View a(Context context) {
            TextView textView = new TextView(context);
            textView.setText(CmcdHeadersFactory.OBJECT_TYPE_INIT_SEGMENT);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(15.0f);
            textView.setBackground(a());
            textView.setAlpha(0.2f);
            textView.setPadding(21, 0, 21, 0);
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            return textView;
        }
    }
}
