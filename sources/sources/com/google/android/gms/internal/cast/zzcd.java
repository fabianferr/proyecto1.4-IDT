package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzcd extends UIController {
    private final TextView zza;
    private final List zzb;

    public zzcd(TextView textView, List list) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = textView;
        arrayList.addAll(list);
    }

    public final void onMediaStatusUpdated() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (mediaInfo = ((MediaStatus) Preconditions.checkNotNull(remoteMediaClient.getMediaStatus())).getMediaInfo()) != null && (metadata = mediaInfo.getMetadata()) != null) {
            for (String str : this.zzb) {
                if (metadata.containsKey(str)) {
                    this.zza.setText(metadata.getString(str));
                    return;
                }
            }
            this.zza.setText("");
        }
    }
}
