package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbu;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfdp {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzfdp(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzh = zzbu.zzh(jsonReader);
        this.zzd = zzh;
        this.zza = zzh.optString(CampaignEx.JSON_KEY_AD_HTML, (String) null);
        this.zzb = zzh.optString("ad_base_url", (String) null);
        this.zzc = zzh.optJSONObject("ad_json");
    }
}
