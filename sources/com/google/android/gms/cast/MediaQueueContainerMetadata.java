package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.media.zza;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class MediaQueueContainerMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueContainerMetadata> CREATOR = new zzcg();
    public static final int MEDIA_QUEUE_CONTAINER_TYPE_AUDIO_BOOK = 1;
    public static final int MEDIA_QUEUE_CONTAINER_TYPE_GENERIC = 0;
    /* access modifiers changed from: private */
    public int zza;
    /* access modifiers changed from: private */
    public String zzb;
    private List zzc;
    private List zzd;
    /* access modifiers changed from: private */
    public double zze;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public @interface MediaQueueContainerType {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public static class Builder {
        private final MediaQueueContainerMetadata zza = new MediaQueueContainerMetadata((zzcf) null);

        public MediaQueueContainerMetadata build() {
            return new MediaQueueContainerMetadata(this.zza, (zzcf) null);
        }

        public Builder setContainerDuration(double d) {
            this.zza.zze = d;
            return this;
        }

        public Builder setContainerImages(List<WebImage> list) {
            MediaQueueContainerMetadata.zzd(this.zza, list);
            return this;
        }

        public Builder setContainerType(int i) {
            this.zza.zza = i;
            return this;
        }

        public Builder setSections(List<MediaMetadata> list) {
            this.zza.zzg(list);
            return this;
        }

        public Builder setTitle(String str) {
            this.zza.zzb = str;
            return this;
        }

        public final Builder zza(JSONObject jSONObject) {
            MediaQueueContainerMetadata.zzb(this.zza, jSONObject);
            return this;
        }
    }

    private MediaQueueContainerMetadata() {
        zzh();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zzb(com.google.android.gms.cast.MediaQueueContainerMetadata r5, org.json.JSONObject r6) {
        /*
            r5.zzh()
            java.lang.String r0 = "containerType"
            java.lang.String r1 = ""
            java.lang.String r0 = r6.optString(r0, r1)
            int r1 = r0.hashCode()
            r2 = 6924225(0x69a7c1, float:9.702906E-39)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x0026
            r2 = 828666841(0x316473d9, float:3.3244218E-9)
            if (r1 == r2) goto L_0x001c
            goto L_0x0030
        L_0x001c:
            java.lang.String r1 = "GENERIC_CONTAINER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0030
            r0 = 0
            goto L_0x0031
        L_0x0026:
            java.lang.String r1 = "AUDIOBOOK_CONTAINER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            if (r0 == 0) goto L_0x0039
            if (r0 == r4) goto L_0x0036
            goto L_0x003b
        L_0x0036:
            r5.zza = r4
            goto L_0x003b
        L_0x0039:
            r5.zza = r3
        L_0x003b:
            java.lang.String r0 = "title"
            java.lang.String r0 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r6, r0)
            r5.zzb = r0
            java.lang.String r0 = "sections"
            org.json.JSONArray r0 = r6.optJSONArray(r0)
            if (r0 == 0) goto L_0x006c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzc = r1
        L_0x0052:
            int r2 = r0.length()
            if (r3 >= r2) goto L_0x006c
            org.json.JSONObject r2 = r0.optJSONObject(r3)
            if (r2 == 0) goto L_0x0069
            com.google.android.gms.cast.MediaMetadata r4 = new com.google.android.gms.cast.MediaMetadata
            r4.<init>()
            r4.zzc(r2)
            r1.add(r4)
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x0052
        L_0x006c:
            java.lang.String r0 = "containerImages"
            org.json.JSONArray r0 = r6.optJSONArray(r0)
            if (r0 == 0) goto L_0x007e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzd = r1
            com.google.android.gms.cast.internal.media.zza.zzd(r1, r0)
        L_0x007e:
            double r0 = r5.zze
            java.lang.String r2 = "containerDuration"
            double r0 = r6.optDouble(r2, r0)
            r5.zze = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaQueueContainerMetadata.zzb(com.google.android.gms.cast.MediaQueueContainerMetadata, org.json.JSONObject):void");
    }

    static /* bridge */ /* synthetic */ void zzd(MediaQueueContainerMetadata mediaQueueContainerMetadata, List list) {
        mediaQueueContainerMetadata.zzd = list == null ? null : new ArrayList(list);
    }

    private final void zzh() {
        this.zza = 0;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueContainerMetadata)) {
            return false;
        }
        MediaQueueContainerMetadata mediaQueueContainerMetadata = (MediaQueueContainerMetadata) obj;
        return this.zza == mediaQueueContainerMetadata.zza && TextUtils.equals(this.zzb, mediaQueueContainerMetadata.zzb) && Objects.equal(this.zzc, mediaQueueContainerMetadata.zzc) && Objects.equal(this.zzd, mediaQueueContainerMetadata.zzd) && this.zze == mediaQueueContainerMetadata.zze;
    }

    public double getContainerDuration() {
        return this.zze;
    }

    public List<WebImage> getContainerImages() {
        List list = this.zzd;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public int getContainerType() {
        return this.zza;
    }

    public List<MediaMetadata> getSections() {
        List list = this.zzc;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getTitle() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd, Double.valueOf(this.zze));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getContainerType());
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getSections(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getContainerImages(), false);
        SafeParcelWriter.writeDouble(parcel, 6, getContainerDuration());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = this.zza;
            if (i == 0) {
                jSONObject.put("containerType", "GENERIC_CONTAINER");
            } else if (i == 1) {
                jSONObject.put("containerType", "AUDIOBOOK_CONTAINER");
            }
            if (!TextUtils.isEmpty(this.zzb)) {
                jSONObject.put("title", this.zzb);
            }
            List list = this.zzc;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (MediaMetadata zza2 : this.zzc) {
                    jSONArray.put(zza2.zza());
                }
                jSONObject.put("sections", jSONArray);
            }
            List list2 = this.zzd;
            if (list2 != null && !list2.isEmpty()) {
                jSONObject.put("containerImages", zza.zzc(this.zzd));
            }
            jSONObject.put("containerDuration", this.zze);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(List list) {
        this.zzc = list == null ? null : new ArrayList(list);
    }

    MediaQueueContainerMetadata(int i, String str, List list, List list2, double d) {
        this.zza = i;
        this.zzb = str;
        this.zzc = list;
        this.zzd = list2;
        this.zze = d;
    }

    /* synthetic */ MediaQueueContainerMetadata(zzcf zzcf) {
        zzh();
    }

    /* synthetic */ MediaQueueContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata, zzcf zzcf) {
        this.zza = mediaQueueContainerMetadata.zza;
        this.zzb = mediaQueueContainerMetadata.zzb;
        this.zzc = mediaQueueContainerMetadata.zzc;
        this.zzd = mediaQueueContainerMetadata.zzd;
        this.zze = mediaQueueContainerMetadata.zze;
    }
}
