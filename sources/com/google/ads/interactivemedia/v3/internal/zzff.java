package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.impl.data.JavaScriptMsgData;
import com.google.ads.interactivemedia.v3.impl.data.zzbh;
import com.google.ads.interactivemedia.v3.impl.data.zzbt;
import java.net.MalformedURLException;
import java.util.Arrays;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzff {
    private static final zzwm zza;
    private final zzfd zzb;
    private final Object zzc;
    private final String zzd;
    private final zzfe zze;

    static {
        zzwn zzwn = new zzwn();
        zzwn.zzb(UiElement.class, zzbt.GSON_TYPE_ADAPTER);
        zzwn.zzb(CompanionAdSlot.class, new zzfc());
        zzwn.zzc(new zzra());
        zza = zzwn.zza();
    }

    public zzff(zzfd zzfd, zzfe zzfe, String str, Object obj) {
        this.zzb = zzfd;
        this.zze = zzfe;
        this.zzd = str;
        this.zzc = obj;
    }

    public static zzff zzc(String str) throws MalformedURLException {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        if (path != null) {
            String substring = path.substring(1);
            if (parse.getQueryParameter(CmcdConfiguration.KEY_SESSION_ID) != null) {
                return new zzff(zzfd.zza(substring), zzfe.zza(parse.getQueryParameter("type")), parse.getQueryParameter(CmcdConfiguration.KEY_SESSION_ID), zza.zze(parse.getQueryParameter("data"), JavaScriptMsgData.class));
            }
            throw new MalformedURLException("Session id must be provided in message.");
        }
        throw new MalformedURLException("URL must have message.");
    }

    public static zzff zzd(String str) {
        zzwm zzwm = zza;
        zzbh zzbh = (zzbh) zzwm.zze(str, zzbh.class);
        if (zzbh.sid != null) {
            return new zzff(zzfd.zza(zzbh.name), zzfe.zza(zzbh.type), zzbh.sid, zzwm.zze(zzbh.data, JavaScriptMsgData.class));
        }
        throw new NullPointerException("Session id must be provided in message.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzff)) {
            return false;
        }
        zzff zzff = (zzff) obj;
        return this.zzb == zzff.zzb && zzri.zza(this.zzc, zzff.zzc) && zzri.zza(this.zzd, zzff.zzd) && this.zze == zzff.zze;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        return String.format("JavaScriptMessage [command=%s, type=%s, sid=%s, data=%s]", new Object[]{this.zzb, this.zze, this.zzd, this.zzc});
    }

    public final zzfd zza() {
        return this.zzb;
    }

    public final zzfe zzb() {
        return this.zze;
    }

    public final Object zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzd;
    }

    public final String zzg() {
        zzsq zzsq = new zzsq();
        zzsq.zza("type", this.zze);
        zzsq.zza(CmcdConfiguration.KEY_SESSION_ID, this.zzd);
        Object obj = this.zzc;
        if (obj != null) {
            zzsq.zza("data", obj);
        }
        return String.format("%s('%s', %s);", new Object[]{"javascript:adsense.mobileads.afmanotify.receiveMessage", this.zzb, zza.zzf(zzsq.zzc())});
    }
}
