package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.zzbr;
import java.util.SortedSet;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzeu implements zzgg {
    private final SortedSet zza;
    private final zzfm zzb;
    private final String zzc;
    private long zzd = 0;
    private VideoProgressUpdate zze = new VideoProgressUpdate(0, 0);
    private final zzqu zzf;

    zzeu(zzfm zzfm, SortedSet sortedSet, String str) {
        zzqu zzqu = new zzqu();
        this.zza = sortedSet;
        this.zzf = zzqu;
        this.zzb = zzfm;
        this.zzc = str;
    }

    public final void zza(VideoProgressUpdate videoProgressUpdate) {
        SortedSet sortedSet;
        if (videoProgressUpdate != null && videoProgressUpdate.getDuration() >= 0.0f && !videoProgressUpdate.equals(this.zze)) {
            float currentTime = this.zze.getCurrentTime();
            float currentTime2 = videoProgressUpdate.getCurrentTime();
            if (currentTime < currentTime2) {
                sortedSet = this.zza.subSet(Float.valueOf(currentTime), Float.valueOf(currentTime2));
            } else {
                sortedSet = this.zza.subSet(Float.valueOf(currentTime2), Float.valueOf(currentTime));
            }
            if (!sortedSet.isEmpty() || this.zza.contains(Float.valueOf(videoProgressUpdate.getCurrentTime())) || System.currentTimeMillis() - this.zzd >= 1000) {
                this.zzd = System.currentTimeMillis();
                this.zze = videoProgressUpdate;
                this.zzb.zzp(new zzff(zzfd.contentTimeUpdate, zzfe.contentTimeUpdate, this.zzc, zzbr.create(videoProgressUpdate)));
            }
        }
    }
}
