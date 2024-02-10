package com.startapp.sdk.adsbase;

import com.startapp.p0;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

/* compiled from: Sta */
public class AdsConstants {
    public static final String a;
    public static final String b;
    public static final String c = "trackdownload";
    public static final String d;
    public static final String e = "https://imp.startappservice.com/tracking/adImpression";
    public static final Boolean f;
    public static final Boolean g;
    public static final String[] h = {"back_", "back_dark", "browser_icon_dark", "forward_", "forward_dark", "x_dark"};
    public static final String[] i = {"empty_star", "filled_star", "half_star"};

    /* compiled from: Sta */
    public enum AdApiType {
        HTML,
        JSON
    }

    static {
        String str = "get";
        StringBuilder a2 = p0.a(str);
        a2.append("ads");
        a = a2.toString();
        StringBuilder a3 = p0.a(str);
        a3.append("htmlad");
        b = a3.toString();
        StringBuilder a4 = p0.a(str);
        a4.append("adsmetadata");
        d = a4.toString();
        Boolean bool = Boolean.FALSE;
        f = bool;
        g = bool;
    }

    public static String a(AdApiType adApiType, AdPreferences.Placement placement) {
        String str;
        String str2;
        String str3;
        String str4;
        int ordinal = adApiType.ordinal();
        if (ordinal == 0) {
            str4 = b;
            str3 = MetaData.k.a(placement);
        } else if (ordinal != 1) {
            str2 = null;
            str = null;
            return str2 + str;
        } else {
            str4 = a;
            str3 = MetaData.k.a(placement);
        }
        String str5 = str3;
        str = str4;
        str2 = str5;
        return str2 + str;
    }
}
