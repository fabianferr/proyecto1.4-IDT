package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadOptions;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.zzr;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzdy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class RemoteMediaClient implements Cast.MessageReceivedCallback {
    public static final String NAMESPACE = zzaq.zzb;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    /* access modifiers changed from: private */
    public static final Logger zzb = new Logger("RemoteMediaClient");
    final List zza = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public final Handler zzd = new zzdy(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final zzaq zze;
    private final zzbf zzf;
    @NotOnlyInitialized
    private final MediaQueue zzg;
    private zzr zzh;
    private TaskCompletionSource zzi;
    /* access modifiers changed from: private */
    public final List zzj = new CopyOnWriteArrayList();
    private final Map zzk = new ConcurrentHashMap();
    private final Map zzl = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public ParseAdsInfoCallback zzm;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public static abstract class Callback {
        public void onAdBreakStatusUpdated() {
        }

        public void onMediaError(MediaError mediaError) {
        }

        public void onMetadataUpdated() {
        }

        public void onPreloadStatusUpdated() {
        }

        public void onQueueStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
        }

        public void onStatusUpdated() {
        }

        public void zza(int[] iArr) {
        }

        public void zzb(int[] iArr, int i) {
        }

        public void zzc(MediaQueueItem[] mediaQueueItemArr) {
        }

        public void zzd(int[] iArr) {
        }

        public void zze(List list, List list2, int i) {
        }

        public void zzf(int[] iArr) {
        }

        public void zzg() {
        }
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();

        MediaError getMediaError();
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public interface ParseAdsInfoCallback {
        List<AdBreakInfo> parseAdBreaksFromMediaStatus(MediaStatus mediaStatus);

        boolean parseIsPlayingAdFromMediaStatus(MediaStatus mediaStatus);
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public interface ProgressListener {
        void onProgressUpdated(long j, long j2);
    }

    public RemoteMediaClient(zzaq zzaq) {
        zzbf zzbf = new zzbf(this);
        this.zzf = zzbf;
        zzaq zzaq2 = (zzaq) Preconditions.checkNotNull(zzaq);
        this.zze = zzaq2;
        zzaq2.zzQ(new zzbn(this, (zzbm) null));
        zzaq2.zzh(zzbf);
        this.zzg = new MediaQueue(this, 20, 20);
    }

    public static PendingResult zzf(int i, String str) {
        zzbh zzbh = new zzbh();
        zzbh.setResult(new zzbg(zzbh, new Status(i, str)));
        return zzbh;
    }

    static /* bridge */ /* synthetic */ void zzn(RemoteMediaClient remoteMediaClient) {
        for (zzbp zzbp : remoteMediaClient.zzl.values()) {
            if (remoteMediaClient.hasMediaSession() && !zzbp.zzi()) {
                zzbp.zzf();
            } else if (!remoteMediaClient.hasMediaSession() && zzbp.zzi()) {
                zzbp.zzg();
            }
            if (zzbp.zzi() && (remoteMediaClient.isBuffering() || remoteMediaClient.zzu() || remoteMediaClient.isPaused() || remoteMediaClient.isLoadingNextItem())) {
                remoteMediaClient.zzw(zzbp.zzb);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzw(Set set) {
        MediaInfo media;
        HashSet<ProgressListener> hashSet = new HashSet<>(set);
        if (isPlaying() || isPaused() || isBuffering() || zzu()) {
            for (ProgressListener onProgressUpdated : hashSet) {
                onProgressUpdated.onProgressUpdated(getApproximateStreamPosition(), getStreamDuration());
            }
        } else if (isLoadingNextItem()) {
            MediaQueueItem loadingItem = getLoadingItem();
            if (loadingItem != null && (media = loadingItem.getMedia()) != null) {
                for (ProgressListener onProgressUpdated2 : hashSet) {
                    onProgressUpdated2.onProgressUpdated(0, media.getStreamDuration());
                }
            }
        } else {
            for (ProgressListener onProgressUpdated3 : hashSet) {
                onProgressUpdated3.onProgressUpdated(0, 0);
            }
        }
    }

    private final boolean zzx() {
        return this.zzh != null;
    }

    private static final zzbk zzy(zzbk zzbk) {
        try {
            zzbk.zzc();
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Throwable unused) {
            zzbk.setResult(new zzbj(zzbk, new Status(2100)));
        }
        return zzbk;
    }

    @Deprecated
    public void addListener(Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzj.add(listener);
        }
    }

    public boolean addProgressListener(ProgressListener progressListener, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (progressListener == null || this.zzk.containsKey(progressListener)) {
            return false;
        }
        Map map = this.zzl;
        Long valueOf = Long.valueOf(j);
        zzbp zzbp = (zzbp) map.get(valueOf);
        if (zzbp == null) {
            zzbp = new zzbp(this, j);
            this.zzl.put(valueOf, zzbp);
        }
        zzbp.zzd(progressListener);
        this.zzk.put(progressListener, zzbp);
        if (!hasMediaSession()) {
            return true;
        }
        zzbp.zzf();
        return true;
    }

    public long getApproximateAdBreakClipPositionMs() {
        long zzj2;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzj2 = this.zze.zzj();
        }
        return zzj2;
    }

    public long getApproximateLiveSeekableRangeEnd() {
        long zzk2;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzk2 = this.zze.zzk();
        }
        return zzk2;
    }

    public long getApproximateLiveSeekableRangeStart() {
        long zzl2;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzl2 = this.zze.zzl();
        }
        return zzl2;
    }

    public long getApproximateStreamPosition() {
        long zzm2;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzm2 = this.zze.zzm();
        }
        return zzm2;
    }

    public MediaQueueItem getCurrentItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getCurrentItemId());
    }

    public int getIdleReason() {
        int idleReason;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            idleReason = mediaStatus != null ? mediaStatus.getIdleReason() : 0;
        }
        return idleReason;
    }

    public MediaQueueItem getLoadingItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getLoadingItemId());
    }

    public MediaInfo getMediaInfo() {
        MediaInfo zzK;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzK = this.zze.zzK();
        }
        return zzK;
    }

    public MediaQueue getMediaQueue() {
        MediaQueue mediaQueue;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaQueue = this.zzg;
        }
        return mediaQueue;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus zzL;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzL = this.zze.zzL();
        }
        return zzL;
    }

    public String getNamespace() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zze.zze();
    }

    public int getPlayerState() {
        int playerState;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            playerState = mediaStatus != null ? mediaStatus.getPlayerState() : 1;
        }
        return playerState;
    }

    public MediaQueueItem getPreloadedItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getPreloadedItemId());
    }

    public long getStreamDuration() {
        long zzo;
        synchronized (this.zzc) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzo = this.zze.zzo();
        }
        return zzo;
    }

    public boolean hasMediaSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return isBuffering() || zzu() || isPlaying() || isPaused() || isLoadingNextItem();
    }

    public boolean isBuffering() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 4;
    }

    public boolean isLiveStream() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null && mediaInfo.getStreamType() == 2;
    }

    public boolean isLoadingNextItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return (mediaStatus == null || mediaStatus.getLoadingItemId() == 0) ? false : true;
    }

    public boolean isPaused() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return false;
        }
        if (mediaStatus.getPlayerState() == 3) {
            return true;
        }
        if (!isLiveStream() || getIdleReason() != 2) {
            return false;
        }
        return true;
    }

    public boolean isPlaying() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 2;
    }

    public boolean isPlayingAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.isPlayingAd();
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo) {
        return load(mediaInfo, new MediaLoadOptions.Builder().build());
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zze.zzO(str2);
    }

    public PendingResult<MediaChannelResult> pause() {
        return pause((JSONObject) null);
    }

    public PendingResult<MediaChannelResult> play() {
        return play((JSONObject) null);
    }

    public PendingResult<MediaChannelResult> queueAppendItem(MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        return queueInsertItems(new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzah zzah = new zzah(this, mediaQueueItem, i, j, jSONObject);
        zzy(zzah);
        return zzah;
    }

    public PendingResult<MediaChannelResult> queueInsertItems(MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzag zzag = new zzag(this, mediaQueueItemArr, i, jSONObject);
        zzy(zzag);
        return zzag;
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(int i, long j, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzaq zzaq = new zzaq(this, i, j, jSONObject);
        zzy(zzaq);
        return zzaq;
    }

    public PendingResult<MediaChannelResult> queueLoad(MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzaf zzaf = new zzaf(this, mediaQueueItemArr, i, i2, j, jSONObject);
        zzy(zzaf);
        return zzaf;
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(int i, int i2, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzar zzar = new zzar(this, i, i2, jSONObject);
        zzy(zzar);
        return zzar;
    }

    public PendingResult<MediaChannelResult> queueNext(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzan zzan = new zzan(this, jSONObject);
        zzy(zzan);
        return zzan;
    }

    public PendingResult<MediaChannelResult> queuePrev(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzam zzam = new zzam(this, jSONObject);
        zzy(zzam);
        return zzam;
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(int i, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzap zzap = new zzap(this, i, jSONObject);
        zzy(zzap);
        return zzap;
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(int[] iArr, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzaj zzaj = new zzaj(this, iArr, jSONObject);
        zzy(zzaj);
        return zzaj;
    }

    public PendingResult<MediaChannelResult> queueReorderItems(int[] iArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzak zzak = new zzak(this, iArr, i, jSONObject);
        zzy(zzak);
        return zzak;
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(int i, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzao zzao = new zzao(this, i, jSONObject);
        zzy(zzao);
        return zzao;
    }

    public PendingResult<MediaChannelResult> queueShuffle(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzal zzal = new zzal(this, true, jSONObject);
        zzy(zzal);
        return zzal;
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzai zzai = new zzai(this, mediaQueueItemArr, jSONObject);
        zzy(zzai);
        return zzai;
    }

    public void registerCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.add(callback);
        }
    }

    @Deprecated
    public void removeListener(Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzj.remove(listener);
        }
    }

    public void removeProgressListener(ProgressListener progressListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbp zzbp = (zzbp) this.zzk.remove(progressListener);
        if (zzbp != null) {
            zzbp.zze(progressListener);
            if (!zzbp.zzh()) {
                this.zzl.remove(Long.valueOf(zzbp.zzb()));
                zzbp.zzg();
            }
        }
    }

    public PendingResult<MediaChannelResult> requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzac zzac = new zzac(this);
        zzy(zzac);
        return zzac;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j) {
        return seek(j, 0, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(long[] jArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzad zzad = new zzad(this, jArr);
        zzy(zzad);
        return zzad;
    }

    public void setParseAdsInfoCallback(ParseAdsInfoCallback parseAdsInfoCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzm = parseAdsInfoCallback;
    }

    public PendingResult<MediaChannelResult> setPlaybackRate(double d) {
        return setPlaybackRate(d, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(boolean z) {
        return setStreamMute(z, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(double d) throws IllegalArgumentException {
        return setStreamVolume(d, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(TextTrackStyle textTrackStyle) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzae zzae = new zzae(this, textTrackStyle);
        zzy(zzae);
        return zzae;
    }

    public PendingResult<MediaChannelResult> skipAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzab zzab = new zzab(this);
        zzy(zzab);
        return zzab;
    }

    public PendingResult<MediaChannelResult> stop() {
        return stop((JSONObject) null);
    }

    public void togglePlayback() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        int playerState = getPlayerState();
        if (playerState == 4 || playerState == 2) {
            pause();
        } else {
            play();
        }
    }

    public void unregisterCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.remove(callback);
        }
    }

    public final int zza() {
        MediaQueueItem loadingItem;
        if (getMediaInfo() != null && hasMediaSession()) {
            if (isBuffering()) {
                return 6;
            }
            if (isPlaying()) {
                return 3;
            }
            if (isPaused()) {
                return 2;
            }
            if (!isLoadingNextItem() || (loadingItem = getLoadingItem()) == null || loadingItem.getMedia() == null) {
                return 0;
            }
            return 6;
        }
        return 0;
    }

    public final PendingResult zzg(String str, List list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzaw zzaw = new zzaw(this, true, str, (List) null);
        zzy(zzaw);
        return zzaw;
    }

    public final PendingResult zzh(int i, int i2, int i3) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzau zzau = new zzau(this, true, i, i2, i3);
        zzy(zzau);
        return zzau;
    }

    public final PendingResult zzi() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzas zzas = new zzas(this, true);
        zzy(zzas);
        return zzas;
    }

    public final PendingResult zzj(int[] iArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzat zzat = new zzat(this, true, iArr);
        zzy(zzat);
        return zzat;
    }

    public final Task zzk(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return Tasks.forException(new zzao());
        }
        this.zzi = new TaskCompletionSource();
        zzb.d("create SessionState with cached mediaInfo and mediaStatus", new Object[0]);
        MediaInfo mediaInfo = getMediaInfo();
        MediaStatus mediaStatus = getMediaStatus();
        SessionState sessionState = null;
        if (!(mediaInfo == null || mediaStatus == null)) {
            MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
            builder.setMediaInfo(mediaInfo);
            builder.setCurrentTime(getApproximateStreamPosition());
            builder.setQueueData(mediaStatus.getQueueData());
            builder.setPlaybackRate(mediaStatus.getPlaybackRate());
            builder.setActiveTrackIds(mediaStatus.getActiveTrackIds());
            builder.setCustomData(mediaStatus.getCustomData());
            MediaLoadRequestData build = builder.build();
            SessionState.Builder builder2 = new SessionState.Builder();
            builder2.setLoadRequestData(build);
            sessionState = builder2.build();
        }
        if (sessionState != null) {
            this.zzi.setResult(sessionState);
        } else {
            this.zzi.setException(new zzao());
        }
        return this.zzi.getTask();
    }

    public final void zzp() {
        zzr zzr = this.zzh;
        if (zzr != null) {
            zzr.zzi(getNamespace(), this);
            requestStatus();
        }
    }

    public final void zzq(SessionState sessionState) {
        MediaLoadRequestData loadRequestData;
        if (sessionState != null && (loadRequestData = sessionState.getLoadRequestData()) != null) {
            zzb.d("resume SessionState", new Object[0]);
            load(loadRequestData);
        }
    }

    public final void zzr(zzr zzr) {
        zzr zzr2 = this.zzh;
        if (zzr2 != zzr) {
            if (zzr2 != null) {
                this.zze.zzf();
                this.zzg.zzl();
                zzr2.zzg(getNamespace());
                this.zzf.zzc((zzr) null);
                this.zzd.removeCallbacksAndMessages((Object) null);
            }
            this.zzh = zzr;
            if (zzr != null) {
                this.zzf.zzc(zzr);
            }
        }
    }

    public final boolean zzs() {
        Integer indexById;
        if (!hasMediaSession()) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) Preconditions.checkNotNull(getMediaStatus());
        if (!mediaStatus.isMediaCommandSupported(64) && mediaStatus.getQueueRepeatMode() == 0 && ((indexById = mediaStatus.getIndexById(mediaStatus.getCurrentItemId())) == null || indexById.intValue() >= mediaStatus.getQueueItemCount() - 1)) {
            return false;
        }
        return true;
    }

    public final boolean zzt() {
        Integer indexById;
        if (!hasMediaSession()) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) Preconditions.checkNotNull(getMediaStatus());
        if (!mediaStatus.isMediaCommandSupported(128) && mediaStatus.getQueueRepeatMode() == 0 && ((indexById = mediaStatus.getIndexById(mediaStatus.getCurrentItemId())) == null || indexById.intValue() <= 0)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzu() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 5;
    }

    public final boolean zzv() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!isLiveStream()) {
            return true;
        }
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || !mediaStatus.isMediaCommandSupported(2) || mediaStatus.getLiveSeekableRange() == null) {
            return false;
        }
        return true;
    }

    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, MediaLoadOptions mediaLoadOptions) {
        MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
        builder.setMediaInfo(mediaInfo);
        builder.setAutoplay(Boolean.valueOf(mediaLoadOptions.getAutoplay()));
        builder.setCurrentTime(mediaLoadOptions.getPlayPosition());
        builder.setPlaybackRate(mediaLoadOptions.getPlaybackRate());
        builder.setActiveTrackIds(mediaLoadOptions.getActiveTrackIds());
        builder.setCustomData(mediaLoadOptions.getCustomData());
        builder.setCredentials(mediaLoadOptions.getCredentials());
        builder.setCredentialsType(mediaLoadOptions.getCredentialsType());
        return load(builder.build());
    }

    public PendingResult<MediaChannelResult> pause(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzax zzax = new zzax(this, jSONObject);
        zzy(zzax);
        return zzax;
    }

    public PendingResult<MediaChannelResult> play(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzaz zzaz = new zzaz(this, jSONObject);
        zzy(zzaz);
        return zzaz;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j, int i) {
        return seek(j, i, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setPlaybackRate(double d, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzbd zzbd = new zzbd(this, d, jSONObject);
        zzy(zzbd);
        return zzbd;
    }

    public PendingResult<MediaChannelResult> setStreamMute(boolean z, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzbc zzbc = new zzbc(this, z, jSONObject);
        zzy(zzbc);
        return zzbc;
    }

    public PendingResult<MediaChannelResult> setStreamVolume(double d, JSONObject jSONObject) throws IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzbb zzbb = new zzbb(this, d, jSONObject);
        zzy(zzbb);
        return zzbb;
    }

    public PendingResult<MediaChannelResult> stop(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzay zzay = new zzay(this, jSONObject);
        zzy(zzay);
        return zzay;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j, int i, JSONObject jSONObject) {
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j);
        builder.setResumeState(i);
        builder.setCustomData(jSONObject);
        return seek(builder.build());
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(mediaQueueItem, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(int i, JSONObject jSONObject) {
        return queueJumpToItem(i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueLoad(MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IllegalArgumentException {
        return queueLoad(mediaQueueItemArr, i, i2, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> seek(MediaSeekOptions mediaSeekOptions) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzba zzba = new zzba(this, mediaSeekOptions);
        zzy(zzba);
        return zzba;
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        return load(mediaInfo, builder.build());
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        builder.setPlayPosition(j);
        return load(mediaInfo, builder.build());
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        builder.setPlayPosition(j);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    @Deprecated
    public PendingResult<MediaChannelResult> load(MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z);
        builder.setPlayPosition(j);
        builder.setActiveTrackIds(jArr);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    public PendingResult<MediaChannelResult> load(MediaLoadRequestData mediaLoadRequestData) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzx()) {
            return zzf(17, (String) null);
        }
        zzav zzav = new zzav(this, mediaLoadRequestData);
        zzy(zzav);
        return zzav;
    }
}
