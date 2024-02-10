package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzw;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzcn extends UIController {
    private final TextView zza;

    public zzcn(TextView textView) {
        this.zza = textView;
    }

    public final void onMediaStatusUpdated() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        String zze;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && (mediaInfo = remoteMediaClient.getMediaInfo()) != null && (metadata = mediaInfo.getMetadata()) != null && (zze = zzw.zze(metadata)) != null) {
            this.zza.setText(zze);
        }
    }
}
