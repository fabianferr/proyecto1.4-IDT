package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class VastAdsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VastAdsRequest> CREATOR = new zzdt();
    private final String zza;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public static class Builder {
        private String zza;
        private String zzb;

        public VastAdsRequest build() {
            return new VastAdsRequest(this.zza, this.zzb);
        }

        public Builder setAdTagUrl(String str) {
            this.zza = str;
            return this;
        }

        public Builder setAdsResponse(String str) {
            this.zzb = str;
            return this;
        }
    }

    VastAdsRequest(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static VastAdsRequest fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new VastAdsRequest(CastUtils.optStringOrNull(jSONObject, "adTagUrl"), CastUtils.optStringOrNull(jSONObject, "adsResponse"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastAdsRequest)) {
            return false;
        }
        VastAdsRequest vastAdsRequest = (VastAdsRequest) obj;
        return CastUtils.zze(this.zza, vastAdsRequest.zza) && CastUtils.zze(this.zzb, vastAdsRequest.zzb);
    }

    public String getAdTagUrl() {
        return this.zza;
    }

    public String getAdsResponse() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAdTagUrl(), false);
        SafeParcelWriter.writeString(parcel, 3, getAdsResponse(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.zza;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.zzb;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
