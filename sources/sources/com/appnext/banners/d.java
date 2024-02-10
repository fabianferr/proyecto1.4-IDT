package com.appnext.banners;

import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;

public final class d extends SettingsManager {
    private static d bD;

    /* access modifiers changed from: protected */
    public final HashMap<String, String> k() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final String m() {
        return "BannerSettings";
    }

    public static synchronized d K() {
        d dVar;
        synchronized (d.class) {
            if (bD == null) {
                bD = new d();
            }
            dVar = bD;
        }
        return dVar;
    }

    private d() {
    }

    /* access modifiers changed from: protected */
    public final String j() {
        return "https://cdn.appnext.com/tools/sdk/confign/banner/" + g.W() + "/banner_config.txt";
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, String> l() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("urlApp_protection", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("resolve_timeout", "8");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("pview", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("new_button_text", "Install");
        hashMap.put("existing_button_text", "Open");
        hashMap.put("gdpr", "false");
        hashMap.put("BANNER_cpiActiveFlow", "d");
        hashMap.put("BANNER_cpcActiveFlow", "b");
        hashMap.put("LARGE_BANNER_cpiActiveFlow", "d");
        hashMap.put("LARGE_BANNER_cpcActiveFlow", "b");
        hashMap.put("MEDIUM_RECTANGLE_cpiActiveFlow", "d");
        hashMap.put("MEDIUM_RECTANGLE_cpcActiveFlow", "b");
        hashMap.put("didPrivacy", "false");
        hashMap.put("impOne", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("_arFlag", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("banner_ar", "10");
        hashMap.put("large_banner_ar", "10");
        hashMap.put("medium_rectangle_ar", "10");
        hashMap.put("stp_flag", "false");
        return hashMap;
    }
}
