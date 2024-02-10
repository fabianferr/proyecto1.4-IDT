package com.appnext.nativeads;

import androidx.exifinterface.media.ExifInterface;
import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.facebook.internal.ServerProtocol;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;

public final class a extends SettingsManager {
    private static a fl;
    private String v = ("https://cdn.appnext.com/tools/sdk/confign/nativeads_new/" + g.W() + "/native_ads_config.json");

    /* access modifiers changed from: protected */
    public final HashMap<String, String> k() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final String m() {
        return "NativeAdSettings";
    }

    public static synchronized a aC() {
        a aVar;
        synchronized (a.class) {
            if (fl == null) {
                fl = new a();
            }
            aVar = fl;
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final String j() {
        return this.v;
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, String> l() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("resolve_timeout", "8");
        hashMap.put("urlApp_protection", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("pview", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("default_caching_policy", ExifInterface.GPS_MEASUREMENT_3D);
        hashMap.put("default_video_quality", "2");
        hashMap.put("num_saved_videos", CampaignEx.CLICKMODE_ON);
        hashMap.put("default_video_length", "2");
        hashMap.put("min_internet_connection_video", "3G");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("new_button_text", "Install");
        hashMap.put("existing_button_text", "Open");
        hashMap.put("gdpr", "false");
        hashMap.put("cpiActiveFlow", "d");
        hashMap.put("cpcActiveFlow", "b");
        hashMap.put("didPrivacy", "false");
        hashMap.put("min_imp_precentage", "50");
        hashMap.put("repeat_viewable_criteria", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("min_vta_precentage", "50");
        hashMap.put("repeat_vta_viewable_criteria", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("stp_flag", "false");
        return hashMap;
    }
}
