package com.appnext.nativeads.designed_native_ads;

import androidx.exifinterface.media.ExifInterface;
import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.facebook.internal.ServerProtocol;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;

public final class c extends SettingsManager {
    private static c fE;
    private String v = ("https://cdn.appnext.com/tools/sdk/confign/suggested_apps/" + g.W() + "/suggested_apps_config.json");

    /* access modifiers changed from: protected */
    public final HashMap<String, String> k() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final String m() {
        return "DesignNativeAdsSettings";
    }

    public static synchronized c aG() {
        c cVar;
        synchronized (c.class) {
            if (fE == null) {
                fE = new c();
            }
            cVar = fE;
        }
        return cVar;
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
        hashMap.put("min_internet_connection_video", "3G");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("gdpr", "false");
        hashMap.put("cpiActiveFlow", "d");
        hashMap.put("cpcActiveFlow", "b");
        hashMap.put("didPrivacy", "false");
        hashMap.put("min_imp_precentage", "50");
        hashMap.put("repeat_viewable_criteria", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("min_vta_precentage", "50");
        hashMap.put("repeat_vta_viewable_criteria", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("stp_flag", "false");
        hashMap.put("report_vta_instead_of_impresssion", "false");
        hashMap.put("title", "Suggested Apps For You");
        hashMap.put("title_text_color", "#D0D0D0");
        hashMap.put("amount_of_icons", CampaignEx.CLICKMODE_ON);
        hashMap.put("present_titles", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("app_title_text_color", "#000000");
        hashMap.put("local_direction", "false");
        hashMap.put("background_color", "#FFFFFF");
        hashMap.put("transparency", StatisticData.ERROR_CODE_NOT_FOUND);
        return hashMap;
    }
}
