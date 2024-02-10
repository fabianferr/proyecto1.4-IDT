package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class MediaStatus extends AbstractSafeParcelable {
    public static final long COMMAND_DISLIKE = 32768;
    public static final long COMMAND_EDIT_TRACKS = 4096;
    public static final long COMMAND_FOLLOW = 65536;
    public static final long COMMAND_LIKE = 16384;
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_PLAYBACK_RATE = 8192;
    public static final long COMMAND_QUEUE_NEXT = 64;
    public static final long COMMAND_QUEUE_PREVIOUS = 128;
    public static final long COMMAND_QUEUE_REPEAT = 3072;
    public static final long COMMAND_QUEUE_REPEAT_ALL = 1024;
    public static final long COMMAND_QUEUE_REPEAT_ONE = 2048;
    public static final long COMMAND_QUEUE_SHUFFLE = 256;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_AD = 512;
    @Deprecated
    public static final long COMMAND_SKIP_BACKWARD = 32;
    @Deprecated
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_STREAM_TRANSFER = 262144;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final long COMMAND_UNFOLLOW = 131072;
    public static final Parcelable.Creator<MediaStatus> CREATOR = new zzcm();
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_LOADING = 5;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private static final Logger zzx = new Logger("MediaStatus");
    MediaInfo zza;
    long zzb;
    int zzc;
    double zzd;
    int zze;
    int zzf;
    long zzg;
    long zzh;
    double zzi;
    boolean zzj;
    long[] zzk;
    int zzl;
    int zzm;
    String zzn;
    JSONObject zzo;
    int zzp;
    final List zzq;
    boolean zzr;
    AdBreakStatus zzs;
    VideoInfo zzt;
    MediaLiveSeekableRange zzu;
    MediaQueueData zzv;
    boolean zzw;
    private final SparseArray zzy;
    private final Writer zzz;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public static class Builder {
        private MediaInfo zza;
        private long zzb;
        private int zzc = 0;
        private double zzd;
        private int zze = 0;
        private int zzf = 0;
        private long zzg;
        private long zzh;
        private double zzi;
        private boolean zzj;
        private long[] zzk;
        private int zzl = 0;
        private int zzm = 0;
        private JSONObject zzn;
        private int zzo = 0;
        private final List zzp = new ArrayList();
        private boolean zzq;
        private AdBreakStatus zzr;
        private VideoInfo zzs;
        private MediaLiveSeekableRange zzt;
        private MediaQueueData zzu;

        public MediaStatus build() {
            MediaStatus mediaStatus = r1;
            MediaStatus mediaStatus2 = new MediaStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, (String) null, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu);
            MediaStatus mediaStatus3 = mediaStatus;
            mediaStatus3.zzo = this.zzn;
            return mediaStatus3;
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zzk = jArr;
            return this;
        }

        public Builder setAdBreakStatus(AdBreakStatus adBreakStatus) {
            this.zzr = adBreakStatus;
            return this;
        }

        public Builder setCurrentItemId(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzn = jSONObject;
            return this;
        }

        public Builder setIdleReason(int i) {
            this.zzf = i;
            return this;
        }

        public Builder setIsMute(boolean z) {
            this.zzj = z;
            return this;
        }

        public Builder setIsPlayingAd(boolean z) {
            this.zzq = z;
            return this;
        }

        public Builder setLiveSeekableRange(MediaLiveSeekableRange mediaLiveSeekableRange) {
            this.zzt = mediaLiveSeekableRange;
            return this;
        }

        public Builder setLoadingItemId(int i) {
            this.zzl = i;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo) {
            this.zza = mediaInfo;
            return this;
        }

        public Builder setMediaSessionId(long j) {
            this.zzb = j;
            return this;
        }

        public Builder setPlaybackRate(double d) {
            this.zzd = d;
            return this;
        }

        public Builder setPlayerState(int i) {
            this.zze = i;
            return this;
        }

        public Builder setPreloadedItemId(int i) {
            this.zzm = i;
            return this;
        }

        public Builder setQueueData(MediaQueueData mediaQueueData) {
            this.zzu = mediaQueueData;
            return this;
        }

        public Builder setQueueItems(List<MediaQueueItem> list) {
            this.zzp.clear();
            this.zzp.addAll(list);
            return this;
        }

        public Builder setQueueRepeatMode(int i) {
            this.zzo = i;
            return this;
        }

        public Builder setStreamPosition(long j) {
            this.zzg = j;
            return this;
        }

        public Builder setStreamVolume(double d) {
            this.zzi = d;
            return this;
        }

        public Builder setSupportedMediaCommands(long j) {
            this.zzh = j;
            return this;
        }

        public Builder setVideoInfo(VideoInfo videoInfo) {
            this.zzs = videoInfo;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public class Writer {
        public Writer() {
        }

        public void setActiveTrackIds(long[] jArr) {
            MediaStatus.this.zzk = jArr;
        }

        public void setAdBreakStatus(AdBreakStatus adBreakStatus) {
            MediaStatus.this.zzs = adBreakStatus;
        }

        public void setCurrentItemId(int i) {
            MediaStatus.this.zzc = i;
        }

        public void setCustomData(JSONObject jSONObject) {
            MediaStatus mediaStatus = MediaStatus.this;
            mediaStatus.zzo = jSONObject;
            mediaStatus.zzn = null;
        }

        public void setIdleReason(int i) {
            MediaStatus.this.zzf = i;
        }

        public void setIsPlayingAd(boolean z) {
            MediaStatus.this.zzr = z;
        }

        public void setLiveSeekableRange(MediaLiveSeekableRange mediaLiveSeekableRange) {
            MediaStatus.this.zzu = mediaLiveSeekableRange;
        }

        public void setLoadingItemId(int i) {
            MediaStatus.this.zzl = i;
        }

        public void setMediaInfo(MediaInfo mediaInfo) {
            MediaStatus.this.zza = mediaInfo;
        }

        public void setMute(boolean z) {
            MediaStatus.this.zzj = z;
        }

        public void setPlaybackRate(double d) {
            MediaStatus.this.zzd = d;
        }

        public void setPlayerState(int i) {
            MediaStatus.this.zze = i;
        }

        public void setPreloadedItemId(int i) {
            MediaStatus.this.zzm = i;
        }

        public void setQueueData(MediaQueueData mediaQueueData) {
            MediaStatus.this.zzv = mediaQueueData;
        }

        public void setQueueItems(List<MediaQueueItem> list) {
            MediaStatus.this.zze(list);
        }

        public void setQueueRepeatMode(int i) {
            MediaStatus.this.zzp = i;
        }

        public void setShuffle(boolean z) {
            MediaStatus.this.zzw = z;
        }

        public void setStreamPosition(long j) {
            MediaStatus.this.zzg = j;
        }

        public void setStreamVolume(double d) {
            MediaStatus.this.zzi = d;
        }

        public void setSupportedMediaCommands(long j) {
            MediaStatus.this.zzh = j;
        }

        public void setVideoInfo(VideoInfo videoInfo) {
            MediaStatus.this.zzt = videoInfo;
        }
    }

    public MediaStatus(MediaInfo mediaInfo, long j, int i, double d, int i2, int i3, long j2, long j3, double d2, boolean z, long[] jArr, int i4, int i5, String str, int i6, List list, boolean z2, AdBreakStatus adBreakStatus, VideoInfo videoInfo, MediaLiveSeekableRange mediaLiveSeekableRange, MediaQueueData mediaQueueData) {
        String str2 = str;
        List list2 = list;
        MediaQueueData mediaQueueData2 = mediaQueueData;
        this.zzq = new ArrayList();
        this.zzy = new SparseArray();
        this.zzz = new Writer();
        this.zza = mediaInfo;
        this.zzb = j;
        this.zzc = i;
        this.zzd = d;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = j2;
        this.zzh = j3;
        this.zzi = d2;
        this.zzj = z;
        this.zzk = jArr;
        this.zzl = i4;
        this.zzm = i5;
        this.zzn = str2;
        if (str2 != null) {
            try {
                this.zzo = new JSONObject(this.zzn);
            } catch (JSONException unused) {
                this.zzo = null;
                this.zzn = null;
            }
        } else {
            this.zzo = null;
        }
        this.zzp = i6;
        if (list2 != null && !list.isEmpty()) {
            zze(list2);
        }
        this.zzr = z2;
        this.zzs = adBreakStatus;
        this.zzt = videoInfo;
        this.zzu = mediaLiveSeekableRange;
        this.zzv = mediaQueueData2;
        boolean z3 = false;
        if (mediaQueueData2 != null && mediaQueueData.zzk()) {
            z3 = true;
        }
        this.zzw = z3;
    }

    /* access modifiers changed from: private */
    public final void zze(List list) {
        this.zzq.clear();
        this.zzy.clear();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                MediaQueueItem mediaQueueItem = (MediaQueueItem) list.get(i);
                this.zzq.add(mediaQueueItem);
                this.zzy.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }
    }

    private static final boolean zzf(int i, int i2, int i3, int i4) {
        if (i != 1) {
            return false;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return i4 != 2;
            }
            if (i2 != 3) {
                return true;
            }
        }
        return i3 == 0;
    }

    public boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        return (this.zzo == null) == (mediaStatus.zzo == null) && this.zzb == mediaStatus.zzb && this.zzc == mediaStatus.zzc && this.zzd == mediaStatus.zzd && this.zze == mediaStatus.zze && this.zzf == mediaStatus.zzf && this.zzg == mediaStatus.zzg && this.zzi == mediaStatus.zzi && this.zzj == mediaStatus.zzj && this.zzl == mediaStatus.zzl && this.zzm == mediaStatus.zzm && this.zzp == mediaStatus.zzp && Arrays.equals(this.zzk, mediaStatus.zzk) && CastUtils.zze(Long.valueOf(this.zzh), Long.valueOf(mediaStatus.zzh)) && CastUtils.zze(this.zzq, mediaStatus.zzq) && CastUtils.zze(this.zza, mediaStatus.zza) && ((jSONObject = this.zzo) == null || (jSONObject2 = mediaStatus.zzo) == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzr == mediaStatus.isPlayingAd() && CastUtils.zze(this.zzs, mediaStatus.zzs) && CastUtils.zze(this.zzt, mediaStatus.zzt) && CastUtils.zze(this.zzu, mediaStatus.zzu) && Objects.equal(this.zzv, mediaStatus.zzv) && this.zzw == mediaStatus.zzw;
    }

    public long[] getActiveTrackIds() {
        return this.zzk;
    }

    public AdBreakStatus getAdBreakStatus() {
        return this.zzs;
    }

    public AdBreakInfo getCurrentAdBreak() {
        MediaInfo mediaInfo;
        List<AdBreakInfo> adBreaks;
        AdBreakStatus adBreakStatus = this.zzs;
        if (adBreakStatus == null) {
            return null;
        }
        String breakId = adBreakStatus.getBreakId();
        if (!TextUtils.isEmpty(breakId) && (mediaInfo = this.zza) != null && (adBreaks = mediaInfo.getAdBreaks()) != null && !adBreaks.isEmpty()) {
            for (AdBreakInfo next : adBreaks) {
                if (breakId.equals(next.getId())) {
                    return next;
                }
            }
        }
        return null;
    }

    public AdBreakClipInfo getCurrentAdBreakClip() {
        MediaInfo mediaInfo;
        List<AdBreakClipInfo> adBreakClips;
        AdBreakStatus adBreakStatus = this.zzs;
        if (adBreakStatus == null) {
            return null;
        }
        String breakClipId = adBreakStatus.getBreakClipId();
        if (!TextUtils.isEmpty(breakClipId) && (mediaInfo = this.zza) != null && (adBreakClips = mediaInfo.getAdBreakClips()) != null && !adBreakClips.isEmpty()) {
            for (AdBreakClipInfo next : adBreakClips) {
                if (breakClipId.equals(next.getId())) {
                    return next;
                }
            }
        }
        return null;
    }

    public int getCurrentItemId() {
        return this.zzc;
    }

    public JSONObject getCustomData() {
        return this.zzo;
    }

    public int getIdleReason() {
        return this.zzf;
    }

    public Integer getIndexById(int i) {
        return (Integer) this.zzy.get(i);
    }

    public MediaQueueItem getItemById(int i) {
        Integer num = (Integer) this.zzy.get(i);
        if (num == null) {
            return null;
        }
        return (MediaQueueItem) this.zzq.get(num.intValue());
    }

    public MediaQueueItem getItemByIndex(int i) {
        if (i < 0 || i >= this.zzq.size()) {
            return null;
        }
        return (MediaQueueItem) this.zzq.get(i);
    }

    public MediaLiveSeekableRange getLiveSeekableRange() {
        return this.zzu;
    }

    public int getLoadingItemId() {
        return this.zzl;
    }

    public MediaInfo getMediaInfo() {
        return this.zza;
    }

    public double getPlaybackRate() {
        return this.zzd;
    }

    public int getPlayerState() {
        return this.zze;
    }

    public int getPreloadedItemId() {
        return this.zzm;
    }

    public MediaQueueData getQueueData() {
        return this.zzv;
    }

    public MediaQueueItem getQueueItem(int i) {
        return getItemByIndex(i);
    }

    public MediaQueueItem getQueueItemById(int i) {
        return getItemById(i);
    }

    public int getQueueItemCount() {
        return this.zzq.size();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzq;
    }

    public int getQueueRepeatMode() {
        return this.zzp;
    }

    public long getStreamPosition() {
        return this.zzg;
    }

    public double getStreamVolume() {
        return this.zzi;
    }

    public long getSupportedMediaCommands() {
        return this.zzh;
    }

    public VideoInfo getVideoInfo() {
        return this.zzt;
    }

    public Writer getWriter() {
        return this.zzz;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Double.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(Arrays.hashCode(this.zzk)), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), String.valueOf(this.zzo), Integer.valueOf(this.zzp), this.zzq, Boolean.valueOf(this.zzr), this.zzs, this.zzt, this.zzu, this.zzv);
    }

    public boolean isMediaCommandSupported(long j) {
        return (j & this.zzh) != 0;
    }

    public boolean isMute() {
        return this.zzj;
    }

    public boolean isPlayingAd() {
        return this.zzr;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mediaSessionId", this.zzb);
            int i = this.zze;
            String str = "IDLE";
            if (i != 1) {
                if (i == 2) {
                    str = "PLAYING";
                } else if (i == 3) {
                    str = "PAUSED";
                } else if (i == 4) {
                    str = "BUFFERING";
                } else if (i == 5) {
                    str = "LOADING";
                }
            }
            jSONObject.put("playerState", str);
            JSONArray jSONArray = null;
            if (this.zze == 1) {
                int i2 = this.zzf;
                jSONObject.putOpt("idleReason", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : MediaError.ERROR_TYPE_ERROR : "INTERRUPTED" : "CANCELLED" : "FINISHED");
            }
            jSONObject.put("playbackRate", this.zzd);
            jSONObject.put("currentTime", CastUtils.millisecToSec(this.zzg));
            jSONObject.put("supportedMediaCommands", this.zzh);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("level", this.zzi);
            jSONObject2.put("muted", this.zzj);
            jSONObject.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject2);
            if (this.zzk != null) {
                jSONArray = new JSONArray();
                for (long put : this.zzk) {
                    jSONArray.put(put);
                }
            }
            jSONObject.putOpt("activeTrackIds", jSONArray);
            jSONObject.putOpt("customData", this.zzo);
            jSONObject.putOpt("shuffle", Boolean.valueOf(this.zzw));
            MediaInfo mediaInfo = this.zza;
            if (mediaInfo != null) {
                jSONObject.putOpt(ShareConstants.WEB_DIALOG_PARAM_MEDIA, mediaInfo.zza());
            }
            int i3 = this.zzc;
            if (i3 != 0) {
                jSONObject.put("currentItemId", i3);
            }
            int i4 = this.zzm;
            if (i4 != 0) {
                jSONObject.put("preloadedItemId", i4);
            }
            int i5 = this.zzl;
            if (i5 != 0) {
                jSONObject.put("loadingItemId", i5);
            }
            AdBreakStatus adBreakStatus = this.zzs;
            if (adBreakStatus != null) {
                jSONObject.putOpt("breakStatus", adBreakStatus.zzb());
            }
            VideoInfo videoInfo = this.zzt;
            if (videoInfo != null) {
                jSONObject.putOpt("videoInfo", videoInfo.zzb());
            }
            MediaQueueData mediaQueueData = this.zzv;
            if (mediaQueueData != null) {
                jSONObject.putOpt("queueData", mediaQueueData.zza());
            }
            MediaLiveSeekableRange mediaLiveSeekableRange = this.zzu;
            if (mediaLiveSeekableRange != null) {
                jSONObject.putOpt("liveSeekableRange", mediaLiveSeekableRange.zzb());
            }
            jSONObject.putOpt("repeatMode", MediaCommon.zza(Integer.valueOf(this.zzp)));
            List list = this.zzq;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (MediaQueueItem json : this.zzq) {
                    jSONArray2.put(json.toJson());
                }
                jSONObject.put(FirebaseAnalytics.Param.ITEMS, jSONArray2);
            }
            return jSONObject;
        } catch (JSONException e) {
            zzx.e(e, "Error transforming MediaStatus into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02d8, code lost:
        if (r15 == false) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x018c, code lost:
        if (r13.zzk != null) goto L_0x018e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0392  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(org.json.JSONObject r14, int r15) throws org.json.JSONException {
        /*
            r13 = this;
            java.lang.String r0 = "extendedStatus"
            org.json.JSONObject r1 = r14.optJSONObject(r0)
            r2 = 0
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ JSONException -> 0x004c }
            r3.<init>()     // Catch:{ JSONException -> 0x004c }
            java.util.Iterator r4 = r14.keys()     // Catch:{ JSONException -> 0x004c }
        L_0x0012:
            boolean r5 = r4.hasNext()     // Catch:{ JSONException -> 0x004c }
            if (r5 == 0) goto L_0x0022
            java.lang.Object r5 = r4.next()     // Catch:{ JSONException -> 0x004c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x004c }
            r3.add(r5)     // Catch:{ JSONException -> 0x004c }
            goto L_0x0012
        L_0x0022:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004c }
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x004c }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ JSONException -> 0x004c }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ JSONException -> 0x004c }
            r4.<init>(r14, r3)     // Catch:{ JSONException -> 0x004c }
            java.util.Iterator r3 = r1.keys()     // Catch:{ JSONException -> 0x004c }
        L_0x0033:
            boolean r5 = r3.hasNext()     // Catch:{ JSONException -> 0x004c }
            if (r5 == 0) goto L_0x0047
            java.lang.Object r5 = r3.next()     // Catch:{ JSONException -> 0x004c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x004c }
            java.lang.Object r6 = r1.get(r5)     // Catch:{ JSONException -> 0x004c }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x004c }
            goto L_0x0033
        L_0x0047:
            r4.remove(r0)     // Catch:{ JSONException -> 0x004c }
            r14 = r4
            goto L_0x004d
        L_0x004c:
        L_0x004d:
            java.lang.String r0 = "mediaSessionId"
            long r0 = r14.getLong(r0)
            long r3 = r13.zzb
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x005e
            r13.zzb = r0
            r0 = 1
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            java.lang.String r1 = "playerState"
            boolean r3 = r14.has(r1)
            r4 = 2
            if (r3 == 0) goto L_0x00e7
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r3 = "IDLE"
            boolean r3 = r1.equals(r3)
            r6 = 3
            r7 = 4
            if (r3 == 0) goto L_0x0078
            r1 = 1
            goto L_0x00a1
        L_0x0078:
            java.lang.String r3 = "PLAYING"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0082
            r1 = 2
            goto L_0x00a1
        L_0x0082:
            java.lang.String r3 = "PAUSED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x008c
            r1 = 3
            goto L_0x00a1
        L_0x008c:
            java.lang.String r3 = "BUFFERING"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0096
            r1 = 4
            goto L_0x00a1
        L_0x0096:
            java.lang.String r3 = "LOADING"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00a0
            r1 = 5
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            int r3 = r13.zze
            if (r1 == r3) goto L_0x00a9
            r13.zze = r1
            r0 = r0 | 2
        L_0x00a9:
            if (r1 != r5) goto L_0x00e7
            java.lang.String r1 = "idleReason"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x00e7
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r3 = "CANCELLED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x00c1
            r6 = 2
            goto L_0x00df
        L_0x00c1:
            java.lang.String r3 = "INTERRUPTED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x00ca
            goto L_0x00df
        L_0x00ca:
            java.lang.String r3 = "FINISHED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x00d4
            r6 = 1
            goto L_0x00df
        L_0x00d4:
            java.lang.String r3 = "ERROR"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00de
            r6 = 4
            goto L_0x00df
        L_0x00de:
            r6 = 0
        L_0x00df:
            int r1 = r13.zzf
            if (r6 == r1) goto L_0x00e7
            r13.zzf = r6
            r0 = r0 | 2
        L_0x00e7:
            java.lang.String r1 = "playbackRate"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x00fd
            double r6 = r14.getDouble(r1)
            double r8 = r13.zzd
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00fd
            r13.zzd = r6
            r0 = r0 | 2
        L_0x00fd:
            java.lang.String r1 = "currentTime"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x0119
            double r6 = r14.getDouble(r1)
            long r6 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((double) r6)
            long r8 = r13.zzg
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0117
            r13.zzg = r6
            r0 = r0 | 2
        L_0x0117:
            r0 = r0 | 128(0x80, float:1.794E-43)
        L_0x0119:
            java.lang.String r1 = "supportedMediaCommands"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x012f
            long r6 = r14.getLong(r1)
            long r8 = r13.zzh
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012f
            r13.zzh = r6
            r0 = r0 | 2
        L_0x012f:
            java.lang.String r1 = "volume"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x015b
            if (r15 != 0) goto L_0x015b
            org.json.JSONObject r15 = r14.getJSONObject(r1)
            java.lang.String r1 = "level"
            double r6 = r15.getDouble(r1)
            double r8 = r13.zzi
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x014d
            r13.zzi = r6
            r0 = r0 | 2
        L_0x014d:
            java.lang.String r1 = "muted"
            boolean r15 = r15.getBoolean(r1)
            boolean r1 = r13.zzj
            if (r15 == r1) goto L_0x015b
            r13.zzj = r15
            r0 = r0 | 2
        L_0x015b:
            java.lang.String r15 = "activeTrackIds"
            boolean r1 = r14.has(r15)
            r3 = 0
            if (r1 == 0) goto L_0x0169
            org.json.JSONArray r15 = r14.getJSONArray(r15)
            goto L_0x016a
        L_0x0169:
            r15 = r3
        L_0x016a:
            long[] r15 = com.google.android.gms.cast.internal.CastUtils.zzg(r15)
            if (r15 == 0) goto L_0x018a
            long[] r1 = r13.zzk
            if (r1 != 0) goto L_0x0175
            goto L_0x018e
        L_0x0175:
            int r6 = r15.length
            int r1 = r1.length
            if (r1 != r6) goto L_0x018e
            r1 = 0
        L_0x017a:
            int r6 = r15.length
            if (r1 >= r6) goto L_0x0192
            long[] r6 = r13.zzk
            r7 = r6[r1]
            r9 = r15[r1]
            int r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x018e
            int r1 = r1 + 1
            goto L_0x017a
        L_0x018a:
            long[] r1 = r13.zzk
            if (r1 == 0) goto L_0x0192
        L_0x018e:
            r13.zzk = r15
            r0 = r0 | 2
        L_0x0192:
            java.lang.String r15 = "customData"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x01a4
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            r13.zzo = r15
            r13.zzn = r3
            r0 = r0 | 2
        L_0x01a4:
            java.lang.String r15 = "media"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x01cd
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            com.google.android.gms.cast.MediaInfo r1 = new com.google.android.gms.cast.MediaInfo
            r1.<init>(r15)
            com.google.android.gms.cast.MediaInfo r6 = r13.zza
            if (r6 == 0) goto L_0x01bf
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x01c3
        L_0x01bf:
            r13.zza = r1
            r0 = r0 | 2
        L_0x01c3:
            java.lang.String r1 = "metadata"
            boolean r15 = r15.has(r1)
            if (r15 == 0) goto L_0x01cd
            r0 = r0 | 4
        L_0x01cd:
            java.lang.String r15 = "currentItemId"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x01e1
            int r15 = r14.getInt(r15)
            int r1 = r13.zzc
            if (r1 == r15) goto L_0x01e1
            r13.zzc = r15
            r0 = r0 | 2
        L_0x01e1:
            java.lang.String r15 = "preloadedItemId"
            int r15 = r14.optInt(r15, r2)
            int r1 = r13.zzm
            if (r1 == r15) goto L_0x01ef
            r13.zzm = r15
            r0 = r0 | 16
        L_0x01ef:
            java.lang.String r15 = "loadingItemId"
            int r15 = r14.optInt(r15, r2)
            int r1 = r13.zzl
            if (r1 == r15) goto L_0x01fd
            r13.zzl = r15
            r0 = r0 | 2
        L_0x01fd:
            com.google.android.gms.cast.MediaInfo r15 = r13.zza
            if (r15 != 0) goto L_0x0203
            r15 = -1
            goto L_0x0207
        L_0x0203:
            int r15 = r15.getStreamType()
        L_0x0207:
            int r1 = r13.zze
            int r6 = r13.zzf
            int r7 = r13.zzl
            boolean r15 = zzf(r1, r6, r7, r15)
            if (r15 != 0) goto L_0x02db
            java.lang.String r15 = "repeatMode"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x0240
            java.lang.String r15 = r14.getString(r15)
            java.lang.Integer r15 = com.google.android.gms.cast.internal.media.MediaCommon.mediaRepeatModeFromString(r15)
            if (r15 != 0) goto L_0x0228
            int r15 = r13.zzp
            goto L_0x022c
        L_0x0228:
            int r15 = r15.intValue()
        L_0x022c:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            int r1 = r13.zzp
            int r6 = r15.intValue()
            if (r1 == r6) goto L_0x0240
            int r15 = r15.intValue()
            r13.zzp = r15
            r15 = 1
            goto L_0x0241
        L_0x0240:
            r15 = 0
        L_0x0241:
            java.lang.String r1 = "items"
            boolean r6 = r14.has(r1)
            if (r6 == 0) goto L_0x02d8
            org.json.JSONArray r1 = r14.getJSONArray(r1)
            int r6 = r1.length()
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            r8 = 0
        L_0x0257:
            if (r8 >= r6) goto L_0x026d
            org.json.JSONObject r9 = r1.getJSONObject(r8)
            java.lang.String r10 = "itemId"
            int r9 = r9.getInt(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7.put(r8, r9)
            int r8 = r8 + 1
            goto L_0x0257
        L_0x026d:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r9 = 0
        L_0x0273:
            if (r9 >= r6) goto L_0x02c8
            java.lang.Object r10 = r7.get(r9)
            java.lang.Integer r10 = (java.lang.Integer) r10
            org.json.JSONObject r11 = r1.getJSONObject(r9)
            int r12 = r10.intValue()
            com.google.android.gms.cast.MediaQueueItem r12 = r13.getItemById(r12)
            if (r12 == 0) goto L_0x02a0
            boolean r11 = r12.fromJson(r11)
            r15 = r15 | r11
            r8.add(r12)
            int r10 = r10.intValue()
            java.lang.Integer r10 = r13.getIndexById(r10)
            int r10 = r10.intValue()
            if (r9 == r10) goto L_0x02c5
            goto L_0x02c4
        L_0x02a0:
            int r15 = r10.intValue()
            int r10 = r13.zzc
            if (r15 != r10) goto L_0x02bc
            com.google.android.gms.cast.MediaInfo r15 = r13.zza
            if (r15 == 0) goto L_0x02bc
            com.google.android.gms.cast.MediaQueueItem$Builder r10 = new com.google.android.gms.cast.MediaQueueItem$Builder
            r10.<init>((com.google.android.gms.cast.MediaInfo) r15)
            com.google.android.gms.cast.MediaQueueItem r15 = r10.build()
            r15.fromJson(r11)
            r8.add(r15)
            goto L_0x02c4
        L_0x02bc:
            com.google.android.gms.cast.MediaQueueItem r15 = new com.google.android.gms.cast.MediaQueueItem
            r15.<init>(r11)
            r8.add(r15)
        L_0x02c4:
            r15 = 1
        L_0x02c5:
            int r9 = r9 + 1
            goto L_0x0273
        L_0x02c8:
            java.util.List r1 = r13.zzq
            int r1 = r1.size()
            if (r1 == r6) goto L_0x02d2
            r1 = 0
            goto L_0x02d3
        L_0x02d2:
            r1 = 1
        L_0x02d3:
            r1 = r1 ^ r5
            r15 = r15 | r1
            r13.zze(r8)
        L_0x02d8:
            if (r15 == 0) goto L_0x02f7
            goto L_0x02f5
        L_0x02db:
            r13.zzc = r2
            r13.zzl = r2
            r13.zzm = r2
            java.util.List r15 = r13.zzq
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x02f7
            r13.zzp = r2
            java.util.List r15 = r13.zzq
            r15.clear()
            android.util.SparseArray r15 = r13.zzy
            r15.clear()
        L_0x02f5:
            r0 = r0 | 8
        L_0x02f7:
            java.lang.String r15 = "breakStatus"
            org.json.JSONObject r15 = r14.optJSONObject(r15)
            com.google.android.gms.cast.AdBreakStatus r15 = com.google.android.gms.cast.AdBreakStatus.zza(r15)
            com.google.android.gms.cast.AdBreakStatus r1 = r13.zzs
            if (r1 != 0) goto L_0x0307
            if (r15 != 0) goto L_0x030f
        L_0x0307:
            if (r1 == 0) goto L_0x0324
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0324
        L_0x030f:
            if (r15 == 0) goto L_0x031e
            java.lang.String r1 = r15.getBreakId()
            if (r1 != 0) goto L_0x031d
            java.lang.String r1 = r15.getBreakClipId()
            if (r1 == 0) goto L_0x031e
        L_0x031d:
            r2 = 1
        L_0x031e:
            r13.zzr = r2
            r13.zzs = r15
            r0 = r0 | 32
        L_0x0324:
            java.lang.String r15 = "videoInfo"
            org.json.JSONObject r15 = r14.optJSONObject(r15)
            com.google.android.gms.cast.VideoInfo r15 = com.google.android.gms.cast.VideoInfo.zza(r15)
            com.google.android.gms.cast.VideoInfo r1 = r13.zzt
            if (r1 != 0) goto L_0x0334
            if (r15 != 0) goto L_0x033c
        L_0x0334:
            if (r1 == 0) goto L_0x0340
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0340
        L_0x033c:
            r13.zzt = r15
            r0 = r0 | 64
        L_0x0340:
            java.lang.String r15 = "breakInfo"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x0355
            com.google.android.gms.cast.MediaInfo r1 = r13.zza
            if (r1 == 0) goto L_0x0355
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            r1.zzr(r15)
            r0 = r0 | 2
        L_0x0355:
            java.lang.String r15 = "queueData"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x037b
            com.google.android.gms.cast.MediaQueueData$Builder r1 = new com.google.android.gms.cast.MediaQueueData$Builder
            r1.<init>()
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            r1.zza(r15)
            com.google.android.gms.cast.MediaQueueData r15 = r1.build()
            r13.zzv = r15
            boolean r15 = r15.zzk()
            boolean r1 = r13.zzw
            if (r1 == r15) goto L_0x037b
            r13.zzw = r15
            r0 = r0 | 8
        L_0x037b:
            java.lang.String r15 = "liveSeekableRange"
            boolean r15 = r14.has(r15)
            if (r15 == 0) goto L_0x0392
            java.lang.String r15 = "liveSeekableRange"
            org.json.JSONObject r14 = r14.optJSONObject(r15)
            com.google.android.gms.cast.MediaLiveSeekableRange r14 = com.google.android.gms.cast.MediaLiveSeekableRange.zza(r14)
            r13.zzu = r14
            r14 = r0 | 2
            goto L_0x039b
        L_0x0392:
            com.google.android.gms.cast.MediaLiveSeekableRange r14 = r13.zzu
            if (r14 == 0) goto L_0x0398
            r0 = r0 | 2
        L_0x0398:
            r13.zzu = r3
            r14 = r0
        L_0x039b:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza(org.json.JSONObject, int):int");
    }

    public final long zzb() {
        return this.zzb;
    }

    public final boolean zzd() {
        MediaInfo mediaInfo = this.zza;
        return zzf(this.zze, this.zzf, this.zzl, mediaInfo == null ? -1 : mediaInfo.getStreamType());
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        JSONObject jSONObject = this.zzo;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zzn = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMediaInfo(), i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, getCurrentItemId());
        SafeParcelWriter.writeDouble(parcel, 5, getPlaybackRate());
        SafeParcelWriter.writeInt(parcel, 6, getPlayerState());
        SafeParcelWriter.writeInt(parcel, 7, getIdleReason());
        SafeParcelWriter.writeLong(parcel, 8, getStreamPosition());
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeDouble(parcel, 10, getStreamVolume());
        SafeParcelWriter.writeBoolean(parcel, 11, isMute());
        SafeParcelWriter.writeLongArray(parcel, 12, getActiveTrackIds(), false);
        SafeParcelWriter.writeInt(parcel, 13, getLoadingItemId());
        SafeParcelWriter.writeInt(parcel, 14, getPreloadedItemId());
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeTypedList(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, isPlayingAd());
        SafeParcelWriter.writeParcelable(parcel, 19, getAdBreakStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 20, getVideoInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 21, getLiveSeekableRange(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getQueueData(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public MediaStatus(JSONObject jSONObject) throws JSONException {
        this((MediaInfo) null, 0, 0, 0.0d, 0, 0, 0, 0, 0.0d, false, (long[]) null, 0, 0, (String) null, 0, (List) null, false, (AdBreakStatus) null, (VideoInfo) null, (MediaLiveSeekableRange) null, (MediaQueueData) null);
        zza(jSONObject, 0);
    }
}
