package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcuk implements zzctx {
    private final zzcdw zza;

    zzcuk(zzcdw zzcdw) {
        this.zza = zzcdw;
    }

    public final void zza(JSONObject jSONObject) {
        int i;
        long optLong = jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa");
        }
        this.zza.zzb(i, optLong);
    }
}
