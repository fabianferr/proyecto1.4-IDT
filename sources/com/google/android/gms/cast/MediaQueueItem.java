package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class MediaQueueItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueItem> CREATOR = new zzck();
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    String zza;
    /* access modifiers changed from: private */
    public MediaInfo zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public double zze;
    /* access modifiers changed from: private */
    public double zzf;
    /* access modifiers changed from: private */
    public double zzg;
    /* access modifiers changed from: private */
    public long[] zzh;
    /* access modifiers changed from: private */
    public JSONObject zzi;
    private final Writer zzj;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public static class Builder {
        private final MediaQueueItem zza;

        public Builder(MediaInfo mediaInfo) throws IllegalArgumentException {
            this.zza = new MediaQueueItem(mediaInfo, (zzcj) null);
        }

        public MediaQueueItem build() {
            this.zza.zzi();
            return this.zza;
        }

        public Builder clearItemId() {
            this.zza.getWriter().setItemId(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zza.getWriter().setActiveTrackIds(jArr);
            return this;
        }

        public Builder setAutoplay(boolean z) {
            this.zza.getWriter().setAutoplay(z);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zza.getWriter().setCustomData(jSONObject);
            return this;
        }

        public Builder setItemId(int i) {
            this.zza.getWriter().setItemId(i);
            return this;
        }

        public Builder setPlaybackDuration(double d) {
            this.zza.getWriter().setPlaybackDuration(d);
            return this;
        }

        public Builder setPreloadTime(double d) throws IllegalArgumentException {
            this.zza.getWriter().setPreloadTime(d);
            return this;
        }

        public Builder setStartTime(double d) throws IllegalArgumentException {
            this.zza.getWriter().setStartTime(d);
            return this;
        }

        public Builder(MediaQueueItem mediaQueueItem) throws IllegalArgumentException {
            this.zza = new MediaQueueItem(mediaQueueItem, (zzcj) null);
        }

        public Builder(JSONObject jSONObject) throws JSONException {
            this.zza = new MediaQueueItem(jSONObject);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public class Writer {
        public Writer() {
        }

        public void setActiveTrackIds(long[] jArr) {
            MediaQueueItem.this.zzh = jArr;
        }

        public void setAutoplay(boolean z) {
            MediaQueueItem.this.zzd = z;
        }

        public void setCustomData(JSONObject jSONObject) {
            MediaQueueItem.this.zzi = jSONObject;
        }

        public void setItemId(int i) {
            MediaQueueItem.this.zzc = i;
        }

        public void setMedia(MediaInfo mediaInfo) {
            MediaQueueItem.this.zzb = mediaInfo;
        }

        public void setPlaybackDuration(double d) {
            if (!Double.isNaN(d)) {
                MediaQueueItem.this.zzf = d;
                return;
            }
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }

        public void setPreloadTime(double d) {
            if (Double.isNaN(d) || d < 0.0d) {
                throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
            }
            MediaQueueItem.this.zzg = d;
        }

        public void setStartTime(double d) {
            if (Double.isNaN(d) || d >= 0.0d) {
                MediaQueueItem.this.zze = d;
                return;
            }
            throw new IllegalArgumentException("startTime cannot be negative.");
        }
    }

    MediaQueueItem(MediaInfo mediaInfo, int i, boolean z, double d, double d2, double d3, long[] jArr, String str) {
        this.zze = Double.NaN;
        this.zzj = new Writer();
        this.zzb = mediaInfo;
        this.zzc = i;
        this.zzd = z;
        this.zze = d;
        this.zzf = d2;
        this.zzg = d3;
        this.zzh = jArr;
        this.zza = str;
        if (str != null) {
            try {
                this.zzi = new JSONObject(this.zza);
            } catch (JSONException unused) {
                this.zzi = null;
                this.zza = null;
            }
        } else {
            this.zzi = null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        JSONObject jSONObject = this.zzi;
        boolean z = jSONObject == null;
        JSONObject jSONObject2 = mediaQueueItem.zzi;
        if (z != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zze(this.zzb, mediaQueueItem.zzb) && this.zzc == mediaQueueItem.zzc && this.zzd == mediaQueueItem.zzd && ((Double.isNaN(this.zze) && Double.isNaN(mediaQueueItem.zze)) || this.zze == mediaQueueItem.zze) && this.zzf == mediaQueueItem.zzf && this.zzg == mediaQueueItem.zzg && Arrays.equals(this.zzh, mediaQueueItem.zzh);
    }

    public boolean fromJson(JSONObject jSONObject) throws JSONException {
        boolean z;
        long[] jArr;
        boolean z2;
        int i;
        boolean z3 = false;
        if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            this.zzb = new MediaInfo(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_PARAM_MEDIA));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.zzc != (i = jSONObject.getInt("itemId"))) {
            this.zzc = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.zzd != (z2 = jSONObject.getBoolean("autoplay"))) {
            this.zzd = z2;
            z = true;
        }
        double optDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(optDouble) != Double.isNaN(this.zze) || (!Double.isNaN(optDouble) && Math.abs(optDouble - this.zze) > 1.0E-7d)) {
            this.zze = optDouble;
            z = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.zzf) > 1.0E-7d) {
                this.zzf = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d2 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d2 - this.zzg) > 1.0E-7d) {
                this.zzg = d2;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.getLong(i2);
            }
            long[] jArr2 = this.zzh;
            if (jArr2 != null && jArr2.length == length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (this.zzh[i3] != jArr[i3]) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            z3 = true;
        } else {
            jArr = null;
        }
        if (z3) {
            this.zzh = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzi = jSONObject.getJSONObject("customData");
        return true;
    }

    public long[] getActiveTrackIds() {
        return this.zzh;
    }

    public boolean getAutoplay() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzi;
    }

    public int getItemId() {
        return this.zzc;
    }

    public MediaInfo getMedia() {
        return this.zzb;
    }

    public double getPlaybackDuration() {
        return this.zzf;
    }

    public double getPreloadTime() {
        return this.zzg;
    }

    public double getStartTime() {
        return this.zze;
    }

    public Writer getWriter() {
        return this.zzj;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(this.zzc), Boolean.valueOf(this.zzd), Double.valueOf(this.zze), Double.valueOf(this.zzf), Double.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)), String.valueOf(this.zzi));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.zzb;
            if (mediaInfo != null) {
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MEDIA, mediaInfo.zza());
            }
            int i = this.zzc;
            if (i != 0) {
                jSONObject.put("itemId", i);
            }
            jSONObject.put("autoplay", this.zzd);
            if (!Double.isNaN(this.zze)) {
                jSONObject.put("startTime", this.zze);
            }
            double d = this.zzf;
            if (d != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", d);
            }
            jSONObject.put("preloadTime", this.zzg);
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                for (long put : this.zzh) {
                    jSONArray.put(put);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            JSONObject jSONObject2 = this.zzi;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void zzi() throws IllegalArgumentException {
        if (this.zzb == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (!Double.isNaN(this.zze) && this.zze < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzf)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzg) || this.zzg < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        JSONObject jSONObject = this.zzi;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMedia(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getItemId());
        SafeParcelWriter.writeBoolean(parcel, 4, getAutoplay());
        SafeParcelWriter.writeDouble(parcel, 5, getStartTime());
        SafeParcelWriter.writeDouble(parcel, 6, getPlaybackDuration());
        SafeParcelWriter.writeDouble(parcel, 7, getPreloadTime());
        SafeParcelWriter.writeLongArray(parcel, 8, getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel, 9, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* synthetic */ MediaQueueItem(MediaInfo mediaInfo, zzcj zzcj) {
        this(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, (long[]) null, (String) null);
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
    }

    /* synthetic */ MediaQueueItem(MediaQueueItem mediaQueueItem, zzcj zzcj) {
        this(mediaQueueItem.getMedia(), mediaQueueItem.getItemId(), mediaQueueItem.getAutoplay(), mediaQueueItem.getStartTime(), mediaQueueItem.getPlaybackDuration(), mediaQueueItem.getPreloadTime(), mediaQueueItem.getActiveTrackIds(), (String) null);
        if (this.zzb != null) {
            this.zzi = mediaQueueItem.getCustomData();
            return;
        }
        throw new IllegalArgumentException("media cannot be null.");
    }

    public MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this((MediaInfo) null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, (long[]) null, (String) null);
        fromJson(jSONObject);
    }
}
