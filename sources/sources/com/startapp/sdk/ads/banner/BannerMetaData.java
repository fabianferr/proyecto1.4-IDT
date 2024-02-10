package com.startapp.sdk.ads.banner;

import android.app.Activity;
import android.content.Context;
import com.startapp.d9;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class BannerMetaData implements Serializable {
    public static Object a = new Object();
    public static volatile BannerMetaData b = new BannerMetaData();
    private static final long serialVersionUID = -6987543640616659467L;
    @d9(complex = true)
    private BannerOptions BannerOptions = new BannerOptions();
    private String bannerMetadataUpdateVersion = "4.11.0";

    public BannerOptions a() {
        return this.BannerOptions;
    }

    public BannerOptions b() {
        return new BannerOptions(this.BannerOptions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BannerMetaData bannerMetaData = (BannerMetaData) obj;
        if (!k9.a(this.BannerOptions, bannerMetaData.BannerOptions) || !k9.a(this.bannerMetadataUpdateVersion, bannerMetaData.bannerMetadataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.BannerOptions, this.bannerMetadataUpdateVersion};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context, BannerMetaData bannerMetaData) {
        synchronized (a) {
            bannerMetaData.bannerMetadataUpdateVersion = "4.11.0";
            b = bannerMetaData;
            f2.a(context, "StartappBannerMetadata", (Serializable) bannerMetaData);
        }
    }

    public static void a(Context context) {
        BannerMetaData bannerMetaData = (BannerMetaData) f2.a(context, "StartappBannerMetadata", BannerMetaData.class);
        BannerMetaData bannerMetaData2 = new BannerMetaData();
        if (bannerMetaData != null) {
            boolean b2 = k9.b(bannerMetaData, bannerMetaData2);
            if (!(!"4.11.0".equals(bannerMetaData.bannerMetadataUpdateVersion)) && b2) {
                i3 i3Var = new i3(j3.e);
                i3Var.d = "metadata_null";
                i3Var.a();
            }
            b = bannerMetaData;
            return;
        }
        b = bannerMetaData2;
    }
}
