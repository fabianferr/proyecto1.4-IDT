package com.appnext.ads.fullscreen;

import androidx.exifinterface.media.ExifInterface;
import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.facebook.internal.ServerProtocol;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;

public class c extends SettingsManager {
    private static c u;
    private String v = ("https://cdn.appnext.com/tools/sdk/confign/fullscreen/" + g.W() + "/fullscreen_config.txt");
    private HashMap<String, String> w = null;

    /* access modifiers changed from: protected */
    public final String m() {
        return "FullscreenSettings";
    }

    public static synchronized c h() {
        c cVar;
        synchronized (c.class) {
            if (u == null) {
                u = new c();
            }
            cVar = u;
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
        hashMap.put("can_close", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("show_close", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("show_close_time", "2000");
        hashMap.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, "15");
        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, "false");
        hashMap.put("urlApp_protection", "false");
        hashMap.put("pview", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("min_internet_connection_video", "3g");
        hashMap.put("banner_expiration_time", "0");
        hashMap.put("postpone_vta_sec", "0");
        hashMap.put("postpone_impression_sec", "0");
        hashMap.put("resolve_timeout", "8");
        hashMap.put("num_saved_videos", CampaignEx.CLICKMODE_ON);
        hashMap.put("caption_text_time", ExifInterface.GPS_MEASUREMENT_3D);
        hashMap.put("ads_caching_time_minutes", "0");
        hashMap.put("gdpr", "false");
        hashMap.put("clickType_a", "0");
        hashMap.put("clickType_b", "0");
        hashMap.put("didPrivacy", "false");
        hashMap.put("stp_flag", "false");
        return hashMap;
    }
}
