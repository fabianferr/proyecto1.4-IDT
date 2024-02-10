package com.startapp.sdk.adsbase.commontracking;

import com.startapp.k9;
import com.startapp.p0;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.t7;
import java.io.Serializable;

/* compiled from: Sta */
public class TrackingParams implements Serializable {
    private static final long serialVersionUID = 2988581940261615851L;
    private String adTag;
    private String clientSessionId;
    private boolean isPubImp;
    private String nonImpressionReason;
    private int offset;
    private String profileId;

    public TrackingParams() {
        this((String) null);
    }

    public String a() {
        return this.adTag;
    }

    public int b() {
        return this.offset;
    }

    public String c() {
        if (this.offset <= 0) {
            return "";
        }
        StringBuilder a = p0.a("&offset=");
        a.append(this.offset);
        return a.toString();
    }

    public String d() {
        return this.profileId;
    }

    public String e() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = this.adTag;
        String str5 = "";
        if (str4 == null || str4.equals(str5)) {
            str = str5;
        } else {
            int i = 200;
            if (this.adTag.length() < 200) {
                i = this.adTag.length();
            }
            StringBuilder a = p0.a("&adTag=");
            a.append(k9.a(this.adTag.substring(0, i)));
            str = a.toString();
        }
        sb.append(str);
        if (this.clientSessionId != null) {
            StringBuilder a2 = p0.a("&clientSessionId=");
            a2.append(k9.a(this.clientSessionId));
            str2 = a2.toString();
        } else {
            str2 = str5;
        }
        sb.append(str2);
        if (this.profileId != null) {
            StringBuilder a3 = p0.a("&profileId=");
            a3.append(k9.a(this.profileId));
            str3 = a3.toString();
        } else {
            str3 = str5;
        }
        sb.append(str3);
        sb.append(c());
        String str6 = this.nonImpressionReason;
        if (str6 != null && !str6.equals(str5)) {
            StringBuilder a4 = p0.a("&isShown=false&reason=");
            a4.append(k9.a(this.nonImpressionReason));
            str5 = a4.toString();
        }
        sb.append(str5);
        return sb.toString();
    }

    public boolean f() {
        return this.isPubImp;
    }

    public TrackingParams(String str, boolean z) {
        this(str);
        this.isPubImp = z;
    }

    public TrackingParams a(int i) {
        this.offset = i;
        return this;
    }

    public TrackingParams a(String str) {
        this.nonImpressionReason = str;
        return this;
    }

    public TrackingParams(String str) {
        this.adTag = str;
        t7 t7Var = t7.d;
        this.clientSessionId = t7.d.a();
        this.profileId = MetaData.w().F();
        this.offset = 0;
    }
}
