package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzo.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class CompanionData {
    private String companionId;

    private static CompanionData create(String str, String str2, String str3, zzav zzav) {
        return new zzo(str, str2, str3, zzav);
    }

    public abstract String clickThroughUrl();

    public String companionId() {
        return this.companionId;
    }

    public abstract String size();

    public abstract String src();

    public final String toString() {
        String companionId2 = companionId();
        String size = size();
        String src = src();
        String clickThroughUrl = clickThroughUrl();
        String valueOf = String.valueOf(type());
        return "CompanionData [companionId=" + companionId2 + ", size=" + size + ", src=" + src + ", clickThroughUrl=" + clickThroughUrl + ", type=" + valueOf + "]";
    }

    public abstract zzav type();

    public static CompanionData create(String str, String str2, String str3, String str4, zzav zzav) {
        CompanionData create = create(str2, str3, str4, zzav);
        create.companionId = str;
        return create;
    }
}
