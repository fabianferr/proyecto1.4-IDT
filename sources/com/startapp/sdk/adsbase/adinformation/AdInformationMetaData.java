package com.startapp.sdk.adsbase.adinformation;

import android.app.Activity;
import android.content.Context;
import com.startapp.d9;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import com.startapp.sdk.adsbase.adinformation.AdInformationConfig;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: Sta */
public class AdInformationMetaData implements Serializable {
    public static volatile AdInformationMetaData a = new AdInformationMetaData();
    public static final Object b = new Object();
    private static final long serialVersionUID = -6352184674890532240L;
    @d9(complex = true)
    private AdInformationConfig AdInformation = AdInformationConfig.a();
    private String adInformationMetadataUpdateVersion = "4.11.0";

    public static AdInformationMetaData c() {
        return a;
    }

    public AdInformationConfig a() {
        return this.AdInformation;
    }

    public String b() {
        return this.AdInformation.d();
    }

    public String d() {
        AdInformationConfig adInformationConfig = this.AdInformation;
        EnumMap<AdInformationConfig.ImageResourceType, ImageResourceConfig> enumMap = adInformationConfig.a;
        AdInformationConfig.ImageResourceType imageResourceType = AdInformationConfig.ImageResourceType.INFO_L;
        return (!enumMap.containsKey(imageResourceType) || adInformationConfig.a.get(imageResourceType).b().equals("")) ? "https://info.startappservice.com/InApp/resources/info_l.png" : adInformationConfig.a.get(imageResourceType).b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdInformationMetaData adInformationMetaData = (AdInformationMetaData) obj;
        if (!k9.a(this.AdInformation, adInformationMetaData.AdInformation) || !k9.a(this.adInformationMetadataUpdateVersion, adInformationMetaData.adInformationMetadataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.AdInformation, this.adInformationMetadataUpdateVersion};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context) {
        AdInformationMetaData adInformationMetaData = (AdInformationMetaData) f2.a(context, "StartappAdInfoMetadata", AdInformationMetaData.class);
        AdInformationMetaData adInformationMetaData2 = new AdInformationMetaData();
        if (adInformationMetaData != null) {
            boolean b2 = k9.b(adInformationMetaData, adInformationMetaData2);
            if (!(!"4.11.0".equals(adInformationMetaData.adInformationMetadataUpdateVersion)) && b2) {
                i3 i3Var = new i3(j3.e);
                i3Var.d = "metadata_null";
                i3Var.a();
            }
            AdInformationConfig adInformationConfig = adInformationMetaData.AdInformation;
            adInformationConfig.getClass();
            adInformationConfig.a = new EnumMap<>(AdInformationConfig.ImageResourceType.class);
            a = adInformationMetaData;
        } else {
            a = adInformationMetaData2;
        }
        a.AdInformation.a(context);
    }

    public static void a(Context context, AdInformationMetaData adInformationMetaData) {
        synchronized (b) {
            adInformationMetaData.adInformationMetadataUpdateVersion = "4.11.0";
            a = adInformationMetaData;
            AdInformationConfig.a(a.AdInformation);
            a.AdInformation.a(context);
            f2.a(context, "StartappAdInfoMetadata", (Serializable) adInformationMetaData);
        }
    }
}
