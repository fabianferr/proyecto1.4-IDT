package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class VideoInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new zzdu();
    public static final int HDR_TYPE_DV = 3;
    public static final int HDR_TYPE_HDR = 4;
    public static final int HDR_TYPE_HDR10 = 2;
    public static final int HDR_TYPE_SDR = 1;
    public static final int HDR_TYPE_UNKNOWN = 0;
    private static final Logger zza = new Logger("VideoInfo");
    private final int zzb;
    private final int zzc;
    private final int zzd;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public static class Builder {
        private int zza;
        private int zzb;
        private int zzc;

        public VideoInfo build() {
            return new VideoInfo(this.zza, this.zzb, this.zzc);
        }

        public Builder setHdrType(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setWidth(int i) {
            this.zza = i;
            return this;
        }
    }

    VideoInfo(int i, int i2, int i3) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.cast.VideoInfo zza(org.json.JSONObject r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.lang.String r2 = "hdrType"
            java.lang.String r2 = r8.getString(r2)     // Catch:{ JSONException -> 0x007b }
            int r3 = r2.hashCode()     // Catch:{ JSONException -> 0x007b }
            r4 = 3218(0xc92, float:4.51E-42)
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == r4) goto L_0x0044
            r4 = 103158(0x192f6, float:1.44555E-40)
            if (r3 == r4) goto L_0x003a
            r4 = 113729(0x1bc41, float:1.59368E-40)
            if (r3 == r4) goto L_0x0030
            r4 = 99136405(0x5e8b395, float:2.1883143E-35)
            if (r3 == r4) goto L_0x0026
            goto L_0x004e
        L_0x0026:
            java.lang.String r3 = "hdr10"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x004e
            r3 = 1
            goto L_0x004f
        L_0x0030:
            java.lang.String r3 = "sdr"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x004e
            r3 = 3
            goto L_0x004f
        L_0x003a:
            java.lang.String r3 = "hdr"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x004e
            r3 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r3 = "dv"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x004e
            r3 = 0
            goto L_0x004f
        L_0x004e:
            r3 = -1
        L_0x004f:
            if (r3 == 0) goto L_0x0069
            if (r3 == r7) goto L_0x0068
            if (r3 == r6) goto L_0x0066
            if (r3 == r5) goto L_0x0064
            com.google.android.gms.cast.internal.Logger r3 = zza     // Catch:{ JSONException -> 0x007b }
            java.lang.String r4 = "Unknown HDR type: %s"
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ JSONException -> 0x007b }
            r5[r1] = r2     // Catch:{ JSONException -> 0x007b }
            r3.d(r4, r5)     // Catch:{ JSONException -> 0x007b }
            r5 = 0
            goto L_0x0069
        L_0x0064:
            r5 = 1
            goto L_0x0069
        L_0x0066:
            r5 = 4
            goto L_0x0069
        L_0x0068:
            r5 = 2
        L_0x0069:
            com.google.android.gms.cast.VideoInfo r2 = new com.google.android.gms.cast.VideoInfo     // Catch:{ JSONException -> 0x007b }
            java.lang.String r3 = "width"
            int r3 = r8.getInt(r3)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r4 = "height"
            int r8 = r8.getInt(r4)     // Catch:{ JSONException -> 0x007b }
            r2.<init>(r3, r8, r5)     // Catch:{ JSONException -> 0x007b }
            return r2
        L_0x007b:
            r8 = move-exception
            com.google.android.gms.cast.internal.Logger r2 = zza
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "Error while creating a VideoInfo instance from JSON"
            r2.d(r8, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.VideoInfo.zza(org.json.JSONObject):com.google.android.gms.cast.VideoInfo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.zzc == videoInfo.getHeight() && this.zzb == videoInfo.getWidth() && this.zzd == videoInfo.getHdrType();
    }

    public int getHdrType() {
        return this.zzd;
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getWidth() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(this.zzd));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.writeInt(parcel, 4, getHdrType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.zzb);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzc);
            int i = this.zzd;
            jSONObject.put("hdrType", i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : "hdr" : "dv" : "hdr10" : "sdr");
            return jSONObject;
        } catch (JSONException unused) {
            zza.e("Failed to transform VideoInfo into Json", new Object[0]);
            return new JSONObject();
        }
    }
}
