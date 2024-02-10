package com.google.android.tv.ads.controls;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.tv.ads.AdsControlsManager;
import com.google.android.tv.ads.IconClickFallbackImage;
import com.google.android.tv.ads.IconClickFallbackImages;
import java.util.Iterator;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class FallbackImageActivity extends AppCompatActivity {
    public final void onCreate(Bundle bundle) {
        IconClickFallbackImage iconClickFallbackImage;
        IconClickFallbackImages iconClickFallbackImages;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        boolean z = false;
        if (extras != null && extras.getBoolean("render_error_message")) {
            z = true;
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null && (iconClickFallbackImages = (IconClickFallbackImages) extras2.getParcelable("icon_click_fallback_images")) != null) {
            Iterator<IconClickFallbackImage> it = iconClickFallbackImages.getIconClickFallbackImageList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                iconClickFallbackImage = it.next();
                if (!AdsControlsManager.zza(iconClickFallbackImage)) {
                    break;
                }
            }
        }
        iconClickFallbackImage = null;
        if (z || iconClickFallbackImage == null) {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(16908290, (Class<? extends Fragment>) ErrorMessageFragment.class, (Bundle) null).commit();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("wta_uri", iconClickFallbackImage.getStaticResourceUri());
        bundle2.putString("wta_alt_text", iconClickFallbackImage.getAltText());
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(16908290, (Class<? extends Fragment>) WhyThisAdFragment.class, bundle2).commit();
    }
}
