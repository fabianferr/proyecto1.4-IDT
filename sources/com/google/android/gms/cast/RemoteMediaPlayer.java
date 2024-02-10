package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final String NAMESPACE = zzaq.zzb;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzaq zzb;
    /* access modifiers changed from: private */
    public final zzdm zzc;
    private OnPreloadStatusUpdatedListener zzd;
    private OnQueueStatusUpdatedListener zze;
    private OnMetadataUpdatedListener zzf;
    private OnStatusUpdatedListener zzg;

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public RemoteMediaPlayer() {
        zzaq zzaq = new zzaq((String) null);
        this.zzb = zzaq;
        zzaq.zzQ(new zzcy(this));
        zzdm zzdm = new zzdm(this);
        this.zzc = zzdm;
        zzaq.zzh(zzdm);
    }

    static /* bridge */ /* synthetic */ int zza(RemoteMediaPlayer remoteMediaPlayer, int i) {
        MediaStatus mediaStatus = remoteMediaPlayer.getMediaStatus();
        if (mediaStatus == null) {
            return -1;
        }
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            MediaQueueItem queueItem = mediaStatus.getQueueItem(i2);
            if (queueItem != null && queueItem.getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    static /* bridge */ /* synthetic */ void zze(RemoteMediaPlayer remoteMediaPlayer) {
        OnMetadataUpdatedListener onMetadataUpdatedListener = remoteMediaPlayer.zzf;
        if (onMetadataUpdatedListener != null) {
            onMetadataUpdatedListener.onMetadataUpdated();
        }
    }

    static /* bridge */ /* synthetic */ void zzf(RemoteMediaPlayer remoteMediaPlayer) {
        OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener = remoteMediaPlayer.zzd;
        if (onPreloadStatusUpdatedListener != null) {
            onPreloadStatusUpdatedListener.onPreloadStatusUpdated();
        }
    }

    static /* bridge */ /* synthetic */ void zzg(RemoteMediaPlayer remoteMediaPlayer) {
        OnQueueStatusUpdatedListener onQueueStatusUpdatedListener = remoteMediaPlayer.zze;
        if (onQueueStatusUpdatedListener != null) {
            onQueueStatusUpdatedListener.onQueueStatusUpdated();
        }
    }

    static /* bridge */ /* synthetic */ void zzh(RemoteMediaPlayer remoteMediaPlayer) {
        OnStatusUpdatedListener onStatusUpdatedListener = remoteMediaPlayer.zzg;
        if (onStatusUpdatedListener != null) {
            onStatusUpdatedListener.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long zzm;
        synchronized (this.zza) {
            zzm = this.zzb.zzm();
        }
        return zzm;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo zzK;
        synchronized (this.zza) {
            zzK = this.zzb.zzK();
        }
        return zzK;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus zzL;
        synchronized (this.zza) {
            zzL = this.zzb.zzL();
        }
        return zzL;
    }

    public String getNamespace() {
        return this.zzb.zze();
    }

    public long getStreamDuration() {
        long zzo;
        synchronized (this.zza) {
            zzo = this.zzb.zzo();
        }
        return zzo;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, -1, (long[]) null, (JSONObject) null);
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzb.zzO(str2);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        return queueInsertItems(googleApiClient, new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcs(this, googleApiClient, mediaQueueItem, i, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.execute(new zzcr(this, googleApiClient, mediaQueueItemArr, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient googleApiClient, int i, long j, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdb(this, googleApiClient, i, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalArgumentException {
        GoogleApiClient googleApiClient2 = googleApiClient;
        return googleApiClient.execute(new zzcq(this, googleApiClient, mediaQueueItemArr, i, i2, j, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient googleApiClient, int i, int i2, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdc(this, googleApiClient, i, i2, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueNext(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcx(this, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queuePrev(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcw(this, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return googleApiClient.execute(new zzda(this, googleApiClient, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient googleApiClient, int[] iArr, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.execute(new zzcu(this, googleApiClient, iArr, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient googleApiClient, int[] iArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.execute(new zzcv(this, googleApiClient, iArr, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcz(this, googleApiClient, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        return googleApiClient.execute(new zzct(this, googleApiClient, mediaQueueItemArr, jSONObject));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzdk(this, googleApiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, 0, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(GoogleApiClient googleApiClient, long[] jArr) {
        return googleApiClient.execute(new zzco(this, googleApiClient, jArr));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzf = onMetadataUpdatedListener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener) {
        this.zzd = onPreloadStatusUpdatedListener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onQueueStatusUpdatedListener) {
        this.zze = onQueueStatusUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzg = onStatusUpdatedListener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d) throws IllegalArgumentException {
        return setStreamVolume(googleApiClient, d, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(GoogleApiClient googleApiClient, TextTrackStyle textTrackStyle) {
        return googleApiClient.execute(new zzcp(this, googleApiClient, textTrackStyle));
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, -1, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzde(this, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdg(this, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(googleApiClient, mediaQueueItem, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return queueJumpToItem(googleApiClient, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IllegalArgumentException {
        return queueLoad(googleApiClient, mediaQueueItemArr, i, i2, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdj(this, googleApiClient, z, jSONObject));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d, JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.execute(new zzdi(this, googleApiClient, d, jSONObject));
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdf(this, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdh(this, googleApiClient, j, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, (long[]) null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        GoogleApiClient googleApiClient2 = googleApiClient;
        return googleApiClient.execute(new zzdd(this, googleApiClient, mediaInfo, z, j, jArr, jSONObject));
    }
}
