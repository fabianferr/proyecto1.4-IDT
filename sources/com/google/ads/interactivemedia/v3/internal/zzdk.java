package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class zzdk extends zzeo implements AdDisplayContainer {
    private VideoAdPlayer zza;

    public zzdk(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        super(viewGroup);
        this.zza = videoAdPlayer;
    }

    public final VideoAdPlayer getPlayer() {
        return this.zza;
    }

    public final void setPlayer(VideoAdPlayer videoAdPlayer) {
        videoAdPlayer.getClass();
        this.zza = videoAdPlayer;
    }
}
