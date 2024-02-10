package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzgt implements zzgv {
    final String zza;

    public zzgt(String str) {
        this.zza = str;
    }

    public final boolean zza(zzgu zzgu, boolean z) {
        String host;
        if (z || !zzgu.zzc || !this.zza.contains("GOOGLE_INSTREAM_VIDEO_NONCE")) {
            return false;
        }
        String str = this.zza;
        List<String> list = zzgu.zze;
        if (str == null || list == null || (host = Uri.parse(str).getHost()) == null) {
            return true;
        }
        if (host.startsWith("www.")) {
            host = host.substring(4);
        }
        for (String str2 : list) {
            if (host == str2) {
                return false;
            }
            if (host != null && host.equals(str2)) {
                return false;
            }
        }
        return true;
    }
}
