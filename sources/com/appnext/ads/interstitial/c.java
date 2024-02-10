package com.appnext.ads.interstitial;

import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.facebook.internal.ServerProtocol;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;

public final class c extends SettingsManager {
    private static c aL;
    private String v = ("https://cdn.appnext.com/tools/sdk/confign/interstitial/" + g.W() + "/interstitial_config.txt");
    private HashMap<String, String> w = null;

    /* access modifiers changed from: protected */
    public final String m() {
        return "InterstitialSettings";
    }

    public static synchronized c E() {
        c cVar;
        synchronized (c.class) {
            if (aL == null) {
                aL = new c();
            }
            cVar = aL;
        }
        return cVar;
    }

    private c() {
    }

    /* access modifiers changed from: protected */
    public final String j() {
        return this.v;
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, String> k() {
        return this.w;
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, String> l() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("creative", Interstitial.TYPE_MANAGED);
        hashMap.put("auto_play", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, "false");
        hashMap.put("pview", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("min_internet_connection", "2g");
        hashMap.put("min_internet_connection_video", "3g");
        hashMap.put("urlApp_protection", "false");
        hashMap.put("can_close", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, "15");
        hashMap.put("button_text", "");
        hashMap.put("button_color", "");
        hashMap.put("skip_title", "");
        hashMap.put("remove_poster_on_auto_play", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("show_rating", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("show_desc", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("new_button_text", "Install");
        hashMap.put("existing_button_text", "Open");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("resolve_timeout", "8");
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("gdpr", "false");
        hashMap.put("clickType_A", "0");
        hashMap.put("didPrivacy", "false");
        hashMap.put("S1", "[{\"id\":\"multi\",\"p\":50},{\"id\":\"single\",\"p\":50}]");
        hashMap.put("stp_flag", "false");
        return hashMap;
    }
}
