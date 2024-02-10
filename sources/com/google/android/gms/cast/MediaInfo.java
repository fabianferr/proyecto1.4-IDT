package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzfe;
import com.google.android.gms.internal.cast.zzfh;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzby();
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    public static final long UNKNOWN_START_ABSOLUTE_TIME = -1;
    public static final long zza = CastUtils.secToMillisec(-1);
    String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public MediaMetadata zzf;
    /* access modifiers changed from: private */
    public long zzg;
    /* access modifiers changed from: private */
    public List zzh;
    /* access modifiers changed from: private */
    public TextTrackStyle zzi;
    /* access modifiers changed from: private */
    public List zzj;
    /* access modifiers changed from: private */
    public List zzk;
    /* access modifiers changed from: private */
    public String zzl;
    /* access modifiers changed from: private */
    public VastAdsRequest zzm;
    /* access modifiers changed from: private */
    public long zzn;
    private String zzo;
    /* access modifiers changed from: private */
    public String zzp;
    /* access modifiers changed from: private */
    public String zzq;
    /* access modifiers changed from: private */
    public String zzr;
    /* access modifiers changed from: private */
    public JSONObject zzs;
    private final Writer zzt;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public static class Builder {
        private String zza;
        private int zzb = -1;
        private String zzc;
        private MediaMetadata zzd;
        private long zze = -1;
        private List zzf;
        private TextTrackStyle zzg;
        private String zzh;
        private List zzi;
        private List zzj;
        private String zzk;
        private VastAdsRequest zzl;
        private String zzm;
        private String zzn;
        private String zzo;
        private String zzp;

        public Builder() {
        }

        public Builder(String str) {
            this.zza = str;
        }

        public Builder(String str, String str2) {
            this.zza = str;
            this.zzk = str2;
        }

        public MediaInfo build() {
            return new MediaInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, -1, this.zzm, this.zzn, this.zzo, this.zzp);
        }

        public Builder setAdBreakClips(List<AdBreakClipInfo> list) {
            this.zzj = list;
            return this;
        }

        public Builder setAdBreaks(List<AdBreakInfo> list) {
            this.zzi = list;
            return this;
        }

        public Builder setAtvEntity(String str) {
            this.zzm = str;
            return this;
        }

        public Builder setContentType(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zzn = str;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzh = jSONObject == null ? null : jSONObject.toString();
            return this;
        }

        public Builder setEntity(String str) {
            this.zzk = str;
            return this;
        }

        public Builder setHlsSegmentFormat(String str) {
            this.zzo = str;
            return this;
        }

        public Builder setHlsVideoSegmentFormat(String str) {
            this.zzp = str;
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zzf = list;
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzd = mediaMetadata;
            return this;
        }

        public Builder setStreamDuration(long j) {
            if (j >= 0 || j == -1) {
                this.zze = j;
                return this;
            }
            throw new IllegalArgumentException("Invalid stream duration");
        }

        public Builder setStreamType(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            this.zzb = i;
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzg = textTrackStyle;
            return this;
        }

        public Builder setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            this.zzl = vastAdsRequest;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public class Writer {
        public Writer() {
        }

        public void setAdBreakClips(List<AdBreakClipInfo> list) {
            MediaInfo.this.zzk = list;
        }

        public void setAdBreaks(List<AdBreakInfo> list) {
            MediaInfo.this.zzj = list;
        }

        public void setContentId(String str) {
            MediaInfo.this.zzc = str;
        }

        public void setContentType(String str) {
            MediaInfo.this.zze = str;
        }

        public void setContentUrl(String str) {
            MediaInfo.this.zzp = str;
        }

        public void setCustomData(JSONObject jSONObject) {
            MediaInfo.this.zzs = jSONObject;
        }

        public void setEntity(String str) {
            MediaInfo.this.zzl = str;
        }

        public void setHlsSegmentFormat(String str) {
            MediaInfo.this.zzq = str;
        }

        public void setHlsVideoSegmentFormat(String str) {
            MediaInfo.this.zzr = str;
        }

        public void setMediaTracks(List<MediaTrack> list) {
            MediaInfo.this.zzh = list;
        }

        public void setMetadata(MediaMetadata mediaMetadata) {
            MediaInfo.this.zzf = mediaMetadata;
        }

        public void setStreamType(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            MediaInfo.this.zzd = i;
        }

        public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
            MediaInfo.this.zzi = textTrackStyle;
        }

        public void setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            MediaInfo.this.zzm = vastAdsRequest;
        }

        public void setStartAbsoluteTime(long j) {
            if (j >= 0 || j == -1) {
                MediaInfo.this.zzn = j;
                return;
            }
            throw new IllegalArgumentException("Invalid start absolute time");
        }

        public void setStreamDuration(long j) {
            if (j >= 0 || j == -1) {
                MediaInfo.this.zzg = j;
                return;
            }
            throw new IllegalArgumentException("Invalid stream duration");
        }
    }

    MediaInfo(String str, int i, String str2, MediaMetadata mediaMetadata, long j, List list, TextTrackStyle textTrackStyle, String str3, List list2, List list3, String str4, VastAdsRequest vastAdsRequest, long j2, String str5, String str6, String str7, String str8) {
        String str9 = str3;
        String str10 = str4;
        String str11 = str6;
        this.zzt = new Writer();
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
        this.zzf = mediaMetadata;
        this.zzg = j;
        this.zzh = list;
        this.zzi = textTrackStyle;
        this.zzb = str9;
        if (str9 != null) {
            try {
                this.zzs = new JSONObject(this.zzb);
            } catch (JSONException unused) {
                this.zzs = null;
                this.zzb = null;
            }
        } else {
            this.zzs = null;
        }
        this.zzj = list2;
        this.zzk = list3;
        this.zzl = str10;
        this.zzm = vastAdsRequest;
        this.zzn = j2;
        this.zzo = str5;
        this.zzp = str11;
        this.zzq = str7;
        this.zzr = str8;
        if (this.zzc == null && str11 == null && str10 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.zzs;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.zzs;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zze(this.zzc, mediaInfo.zzc) && this.zzd == mediaInfo.zzd && CastUtils.zze(this.zze, mediaInfo.zze) && CastUtils.zze(this.zzf, mediaInfo.zzf) && this.zzg == mediaInfo.zzg && CastUtils.zze(this.zzh, mediaInfo.zzh) && CastUtils.zze(this.zzi, mediaInfo.zzi) && CastUtils.zze(this.zzj, mediaInfo.zzj) && CastUtils.zze(this.zzk, mediaInfo.zzk) && CastUtils.zze(this.zzl, mediaInfo.zzl) && CastUtils.zze(this.zzm, mediaInfo.zzm) && this.zzn == mediaInfo.zzn && CastUtils.zze(this.zzo, mediaInfo.zzo) && CastUtils.zze(this.zzp, mediaInfo.zzp) && CastUtils.zze(this.zzq, mediaInfo.zzq) && CastUtils.zze(this.zzr, mediaInfo.zzr);
    }

    public List<AdBreakClipInfo> getAdBreakClips() {
        List list = this.zzk;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List<AdBreakInfo> getAdBreaks() {
        List list = this.zzj;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getContentId() {
        String str = this.zzc;
        return str == null ? "" : str;
    }

    public String getContentType() {
        return this.zze;
    }

    public String getContentUrl() {
        return this.zzp;
    }

    public JSONObject getCustomData() {
        return this.zzs;
    }

    public String getEntity() {
        return this.zzl;
    }

    public String getHlsSegmentFormat() {
        return this.zzq;
    }

    public String getHlsVideoSegmentFormat() {
        return this.zzr;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzh;
    }

    public MediaMetadata getMetadata() {
        return this.zzf;
    }

    public long getStartAbsoluteTime() {
        return this.zzn;
    }

    public long getStreamDuration() {
        return this.zzg;
    }

    public int getStreamType() {
        return this.zzd;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzi;
    }

    public VastAdsRequest getVmapAdsRequest() {
        return this.zzm;
    }

    public Writer getWriter() {
        return this.zzt;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzf, Long.valueOf(this.zzg), String.valueOf(this.zzs), this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, Long.valueOf(this.zzn), this.zzo, this.zzq, this.zzr);
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzi = textTrackStyle;
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzc);
            jSONObject.putOpt("contentUrl", this.zzp);
            int i = this.zzd;
            jSONObject.put("streamType", i != 1 ? i != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.zze;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            MediaMetadata mediaMetadata = this.zzf;
            if (mediaMetadata != null) {
                jSONObject.put("metadata", mediaMetadata.zza());
            }
            long j = this.zzg;
            if (j <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", CastUtils.millisecToSec(j));
            }
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack zza2 : this.zzh) {
                    jSONArray.put(zza2.zza());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.zzi;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
            }
            JSONObject jSONObject2 = this.zzs;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.zzl;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.zzj != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AdBreakInfo zza3 : this.zzj) {
                    jSONArray2.put(zza3.zza());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.zzk != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AdBreakClipInfo zza4 : this.zzk) {
                    jSONArray3.put(zza4.zza());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.zzm;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.zza());
            }
            long j2 = this.zzn;
            if (j2 != -1) {
                jSONObject.put("startAbsoluteTime", CastUtils.millisecToSec(j2));
            }
            jSONObject.putOpt("atvEntity", this.zzo);
            String str3 = this.zzq;
            if (str3 != null) {
                jSONObject.put("hlsSegmentFormat", str3);
            }
            String str4 = this.zzr;
            if (str4 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str4);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00aa A[LOOP:0: B:3:0x0022->B:23:0x00aa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0187 A[LOOP:2: B:29:0x00d1->B:55:0x0187, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzr(org.json.JSONObject r40) throws org.json.JSONException {
        /*
            r39 = this;
            r1 = r39
            r2 = r40
            java.lang.String r3 = "whenSkippable"
            java.lang.String r0 = "breaks"
            boolean r4 = r2.has(r0)
            java.lang.String r5 = "duration"
            java.lang.String r6 = "id"
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x00bb
            org.json.JSONArray r4 = r2.getJSONArray(r0)
            java.util.ArrayList r10 = new java.util.ArrayList
            int r0 = r4.length()
            r10.<init>(r0)
            r11 = 0
        L_0x0022:
            int r0 = r4.length()
            if (r11 >= r0) goto L_0x00b4
            org.json.JSONObject r0 = r4.getJSONObject(r11)
            android.os.Parcelable$Creator<com.google.android.gms.cast.AdBreakInfo> r12 = com.google.android.gms.cast.AdBreakInfo.CREATOR
            if (r0 != 0) goto L_0x0033
        L_0x0030:
            r0 = 0
            goto L_0x00a8
        L_0x0033:
            boolean r12 = r0.has(r6)
            if (r12 == 0) goto L_0x0030
            java.lang.String r12 = "position"
            boolean r13 = r0.has(r12)
            if (r13 != 0) goto L_0x0042
            goto L_0x0030
        L_0x0042:
            java.lang.String r17 = r0.getString(r6)     // Catch:{ JSONException -> 0x0091 }
            long r12 = r0.getLong(r12)     // Catch:{ JSONException -> 0x0091 }
            long r15 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r12)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r12 = "isWatched"
            boolean r20 = r0.optBoolean(r12)     // Catch:{ JSONException -> 0x0091 }
            long r12 = r0.optLong(r5)     // Catch:{ JSONException -> 0x0091 }
            long r18 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r12)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r12 = "breakClipIds"
            org.json.JSONArray r12 = r0.optJSONArray(r12)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ JSONException -> 0x0091 }
            if (r12 == 0) goto L_0x007c
            int r13 = r12.length()     // Catch:{ JSONException -> 0x0091 }
            java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ JSONException -> 0x0091 }
            r14 = 0
        L_0x006d:
            int r9 = r12.length()     // Catch:{ JSONException -> 0x0091 }
            if (r14 >= r9) goto L_0x007c
            java.lang.String r9 = r12.getString(r14)     // Catch:{ JSONException -> 0x0091 }
            r13[r14] = r9     // Catch:{ JSONException -> 0x0091 }
            int r14 = r14 + 1
            goto L_0x006d
        L_0x007c:
            r21 = r13
            java.lang.String r9 = "isEmbedded"
            boolean r22 = r0.optBoolean(r9)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = "expanded"
            boolean r23 = r0.optBoolean(r9)     // Catch:{ JSONException -> 0x0091 }
            com.google.android.gms.cast.AdBreakInfo r0 = new com.google.android.gms.cast.AdBreakInfo     // Catch:{ JSONException -> 0x0091 }
            r14 = r0
            r14.<init>(r15, r17, r18, r20, r21, r22, r23)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x00a8
        L_0x0091:
            r0 = move-exception
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.Object[] r12 = new java.lang.Object[r7]
            java.lang.String r0 = r0.getMessage()
            r12[r8] = r0
            java.lang.String r0 = "Error while creating an AdBreakInfo from JSON: %s"
            java.lang.String r0 = java.lang.String.format(r9, r0, r12)
            java.lang.String r9 = "AdBreakInfo"
            android.util.Log.d(r9, r0)
            goto L_0x0030
        L_0x00a8:
            if (r0 == 0) goto L_0x00b1
            r10.add(r0)
            int r11 = r11 + 1
            goto L_0x0022
        L_0x00b1:
            r10.clear()
        L_0x00b4:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r10)
            r1.zzj = r0
        L_0x00bb:
            java.lang.String r0 = "breakClips"
            boolean r4 = r2.has(r0)
            if (r4 == 0) goto L_0x0198
            org.json.JSONArray r2 = r2.getJSONArray(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r0 = r2.length()
            r4.<init>(r0)
            r9 = 0
        L_0x00d1:
            int r0 = r2.length()
            if (r9 >= r0) goto L_0x0191
            org.json.JSONObject r0 = r2.getJSONObject(r9)
            long r10 = com.google.android.gms.cast.AdBreakClipInfo.AD_BREAK_CLIP_NOT_SKIPPABLE
            if (r0 != 0) goto L_0x00e2
        L_0x00df:
            r0 = 0
            goto L_0x0185
        L_0x00e2:
            boolean r10 = r0.has(r6)
            if (r10 != 0) goto L_0x00e9
            goto L_0x00df
        L_0x00e9:
            java.lang.String r25 = r0.getString(r6)     // Catch:{ JSONException -> 0x016d }
            long r10 = r0.optLong(r5)     // Catch:{ JSONException -> 0x016d }
            long r27 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r10)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r10 = "clickThroughUrl"
            java.lang.String r31 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r10 = "contentUrl"
            java.lang.String r29 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r10 = "mimeType"
            java.lang.String r10 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x016d }
            if (r10 != 0) goto L_0x010f
            java.lang.String r10 = "contentType"
            java.lang.String r10 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x016d }
        L_0x010f:
            r30 = r10
            java.lang.String r10 = "title"
            java.lang.String r26 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r10 = "customData"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r11 = "contentId"
            java.lang.String r33 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r11)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r11 = "posterUrl"
            java.lang.String r34 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r11)     // Catch:{ JSONException -> 0x016d }
            boolean r11 = r0.has(r3)     // Catch:{ JSONException -> 0x016d }
            if (r11 == 0) goto L_0x013f
            java.lang.Object r11 = r0.get(r3)     // Catch:{ JSONException -> 0x016d }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ JSONException -> 0x016d }
            int r11 = r11.intValue()     // Catch:{ JSONException -> 0x016d }
            long r11 = (long) r11     // Catch:{ JSONException -> 0x016d }
            long r11 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r11)     // Catch:{ JSONException -> 0x016d }
            goto L_0x0141
        L_0x013f:
            r11 = -1
        L_0x0141:
            r35 = r11
            java.lang.String r11 = "hlsSegmentFormat"
            java.lang.String r37 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r11)     // Catch:{ JSONException -> 0x016d }
            java.lang.String r11 = "vastAdsRequest"
            org.json.JSONObject r0 = r0.optJSONObject(r11)     // Catch:{ JSONException -> 0x016d }
            com.google.android.gms.cast.VastAdsRequest r38 = com.google.android.gms.cast.VastAdsRequest.fromJson(r0)     // Catch:{ JSONException -> 0x016d }
            com.google.android.gms.cast.AdBreakClipInfo r0 = new com.google.android.gms.cast.AdBreakClipInfo     // Catch:{ JSONException -> 0x016d }
            if (r10 == 0) goto L_0x0165
            int r11 = r10.length()     // Catch:{ JSONException -> 0x016d }
            if (r11 != 0) goto L_0x015e
            goto L_0x0165
        L_0x015e:
            java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x016d }
            r32 = r10
            goto L_0x0167
        L_0x0165:
            r32 = 0
        L_0x0167:
            r24 = r0
            r24.<init>(r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r37, r38)     // Catch:{ JSONException -> 0x016d }
            goto L_0x0185
        L_0x016d:
            r0 = move-exception
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.Object[] r11 = new java.lang.Object[r7]
            java.lang.String r0 = r0.getMessage()
            r11[r8] = r0
            java.lang.String r0 = "Error while creating an AdBreakClipInfo from JSON: %s"
            java.lang.String r0 = java.lang.String.format(r10, r0, r11)
            java.lang.String r10 = "AdBreakClipInfo"
            android.util.Log.d(r10, r0)
            goto L_0x00df
        L_0x0185:
            if (r0 == 0) goto L_0x018e
            r4.add(r0)
            int r9 = r9 + 1
            goto L_0x00d1
        L_0x018e:
            r4.clear()
        L_0x0191:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r4)
            r1.zzk = r0
        L_0x0198:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.zzr(org.json.JSONObject):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        JSONObject jSONObject = this.zzs;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zzb = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getContentId(), false);
        SafeParcelWriter.writeInt(parcel, 3, getStreamType());
        SafeParcelWriter.writeString(parcel, 4, getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getMetadata(), i, false);
        SafeParcelWriter.writeLong(parcel, 6, getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel, 7, getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getTextTrackStyle(), i, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 10, getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel, 11, getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel, 12, getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVmapAdsRequest(), i, false);
        SafeParcelWriter.writeLong(parcel, 14, getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 17, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel, 18, getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("contentId"), -1, (String) null, (MediaMetadata) null, -1, (List) null, (TextTrackStyle) null, (String) null, (List) null, (List) null, (String) null, (VastAdsRequest) null, -1, (String) null, (String) null, (String) null, (String) null);
        MediaInfo mediaInfo;
        int i;
        int i2;
        zzfh zzfh;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("streamType", "NONE");
        if ("NONE".equals(optString)) {
            mediaInfo = this;
            mediaInfo.zzd = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(optString)) {
                mediaInfo.zzd = 1;
            } else if ("LIVE".equals(optString)) {
                mediaInfo.zzd = 2;
            } else {
                mediaInfo.zzd = -1;
            }
        }
        mediaInfo.zze = CastUtils.optStringOrNull(jSONObject2, "contentType");
        if (jSONObject2.has("metadata")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("metadata");
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject3.getInt("metadataType"));
            mediaInfo.zzf = mediaMetadata;
            mediaMetadata.zzc(jSONObject3);
        }
        mediaInfo.zzg = -1;
        if (mediaInfo.zzd != 2 && jSONObject2.has("duration") && !jSONObject2.isNull("duration")) {
            double optDouble = jSONObject2.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble) && optDouble >= 0.0d) {
                mediaInfo.zzg = CastUtils.secToMillisec(optDouble);
            }
        }
        if (jSONObject2.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("tracks");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                String str = MediaTrack.ROLE_ALTERNATE;
                long j = jSONObject4.getLong("trackId");
                String optString2 = jSONObject4.optString("type");
                if (AdPreferences.TYPE_TEXT.equals(optString2)) {
                    i = 1;
                } else if ("AUDIO".equals(optString2)) {
                    i = 2;
                } else {
                    i = ShareConstants.VIDEO_URL.equals(optString2) ? 3 : 0;
                }
                String optStringOrNull = CastUtils.optStringOrNull(jSONObject4, "trackContentId");
                String optStringOrNull2 = CastUtils.optStringOrNull(jSONObject4, "trackContentType");
                String optStringOrNull3 = CastUtils.optStringOrNull(jSONObject4, "name");
                String optStringOrNull4 = CastUtils.optStringOrNull(jSONObject4, "language");
                if (jSONObject4.has("subtype")) {
                    String string = jSONObject4.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i2 = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i2 = 2;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i2 = 3;
                    } else {
                        i2 = "CHAPTERS".equals(string) ? 4 : "METADATA".equals(string) ? 5 : -1;
                    }
                } else {
                    i2 = 0;
                }
                if (jSONObject4.has("roles")) {
                    zzfe zzfe = new zzfe();
                    JSONArray jSONArray2 = jSONObject4.getJSONArray("roles");
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        zzfe.zzb(jSONArray2.optString(i4));
                    }
                    zzfh = zzfe.zzc();
                } else {
                    zzfh = null;
                }
                arrayList.add(new MediaTrack(j, i, optStringOrNull, optStringOrNull2, optStringOrNull3, optStringOrNull4, i2, zzfh, jSONObject4.optJSONObject("customData")));
            }
            mediaInfo.zzh = new ArrayList(arrayList);
        } else {
            mediaInfo.zzh = null;
        }
        if (jSONObject2.has("textTrackStyle")) {
            JSONObject jSONObject5 = jSONObject2.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.fromJson(jSONObject5);
            mediaInfo.zzi = textTrackStyle;
        } else {
            mediaInfo.zzi = null;
        }
        zzr(jSONObject);
        mediaInfo.zzs = jSONObject2.optJSONObject("customData");
        mediaInfo.zzl = CastUtils.optStringOrNull(jSONObject2, "entity");
        mediaInfo.zzo = CastUtils.optStringOrNull(jSONObject2, "atvEntity");
        mediaInfo.zzm = VastAdsRequest.fromJson(jSONObject2.optJSONObject("vmapAdsRequest"));
        if (jSONObject2.has("startAbsoluteTime") && !jSONObject2.isNull("startAbsoluteTime")) {
            double optDouble2 = jSONObject2.optDouble("startAbsoluteTime");
            if (!Double.isNaN(optDouble2) && !Double.isInfinite(optDouble2) && optDouble2 >= 0.0d) {
                mediaInfo.zzn = CastUtils.secToMillisec(optDouble2);
            }
        }
        if (jSONObject2.has("contentUrl")) {
            mediaInfo.zzp = jSONObject2.optString("contentUrl");
        }
        mediaInfo.zzq = CastUtils.optStringOrNull(jSONObject2, "hlsSegmentFormat");
        mediaInfo.zzr = CastUtils.optStringOrNull(jSONObject2, "hlsVideoSegmentFormat");
    }
}
