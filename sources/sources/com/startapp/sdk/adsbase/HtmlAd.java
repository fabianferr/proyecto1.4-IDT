package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.startapp.f6;
import com.startapp.i3;
import com.startapp.k9;
import com.startapp.m7;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: Sta */
public abstract class HtmlAd extends Ad {
    public static String c = null;
    private static final long serialVersionUID = -6617750692215126073L;
    private List<AppPresenceDetails> apps;
    private String[] closingUrl = {""};
    private Long delayCloseInterval;
    private Long delayImpressionInSeconds;
    private int height;
    private String htmlUuid = "";
    public boolean[] inAppBrowserEnabled = {true};
    private boolean isMraidAd = false;
    private int orientation = 0;
    private String[] packageNames = {""};
    private int rewardDuration = 0;
    private boolean rewardedHideTimer = false;
    private Boolean[] sendRedirectHops = null;
    public boolean[] smartRedirect = {false};
    private String[] trackingClickUrls = {""};
    public String[] trackingUrls = {""};
    private int width;

    public HtmlAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
        if (c == null) {
            r();
        }
    }

    public void a(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void b(String str) {
        Long l = null;
        for (String str2 : str.split(",")) {
            if (!str2.equals("")) {
                try {
                    long parseLong = Long.parseLong(str2);
                    if (parseLong > 0 && (l == null || parseLong < l.longValue())) {
                        l = Long.valueOf(parseLong);
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (l != null) {
            this.adCacheTtl = Long.valueOf(TimeUnit.SECONDS.toMillis(l.longValue()));
        }
    }

    public void c(String str) {
        if (Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*([\\\"\\'])mraid\\.js\\1[^>]*>\\s*</script>\\n*", 2).matcher(new StringBuffer(str)).find()) {
            this.isMraidAd = true;
        }
        if (MetaData.k.V()) {
            try {
                str = m7.a(f6.a(), str);
            } catch (Throwable th) {
                i3.a(th);
            }
        }
        Map<Activity, Integer> map = k9.a;
        d dVar = d.h;
        dVar.getClass();
        String uuid = UUID.randomUUID().toString();
        dVar.b.put(uuid, str);
        this.htmlUuid = uuid;
        String a = k9.a(str, "@smartRedirect@", "@smartRedirect@");
        if (a != null) {
            String[] split = a.split(",");
            this.smartRedirect = new boolean[split.length];
            for (int i = 0; i < split.length; i++) {
                if (split[i].compareTo(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) == 0) {
                    this.smartRedirect[i] = true;
                } else {
                    this.smartRedirect[i] = false;
                }
            }
        }
        String a2 = k9.a(str, "@trackingClickUrl@", "@trackingClickUrl@");
        if (a2 != null) {
            this.trackingClickUrls = a2.split(",");
        }
        String a3 = k9.a(str, "@closeUrl@", "@closeUrl@");
        if (a3 != null) {
            this.closingUrl = a3.split(",");
        }
        String a4 = k9.a(str, "@tracking@", "@tracking@");
        if (a4 != null) {
            this.trackingUrls = a4.split(",");
        }
        String a5 = k9.a(str, "@packageName@", "@packageName@");
        if (a5 != null) {
            this.packageNames = a5.split(",");
        }
        String a6 = k9.a(str, "@startappBrowserEnabled@", "@startappBrowserEnabled@");
        if (a6 != null) {
            String[] split2 = a6.split(",");
            this.inAppBrowserEnabled = new boolean[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                if (split2[i2].compareTo("false") == 0) {
                    this.inAppBrowserEnabled[i2] = false;
                } else {
                    this.inAppBrowserEnabled[i2] = true;
                }
            }
        }
        String a7 = k9.a(str, "@orientation@", "@orientation@");
        if (a7 != null) {
            Map<Activity, Integer> map2 = k9.a;
            a(SplashConfig.Orientation.getByName(a7));
        }
        String a8 = k9.a(str, "@adInfoEnable@", "@adInfoEnable@");
        if (a8 != null) {
            getAdInfoOverride().a(Boolean.parseBoolean(a8));
        }
        String a9 = k9.a(str, "@adInfoPosition@", "@adInfoPosition@");
        if (a9 != null) {
            getAdInfoOverride().a(AdInformationPositions.Position.getByName(a9));
        }
        String a10 = k9.a(str, "@ttl@", "@ttl@");
        if (a10 != null) {
            b(a10);
        }
        String a11 = k9.a(str, "@belowMinCPM@", "@belowMinCPM@");
        if (a11 != null) {
            if (Arrays.asList(a11.split(",")).contains("false")) {
                this.belowMinCPM = false;
            } else {
                this.belowMinCPM = true;
            }
        }
        String a12 = k9.a(str, "@delayCloseInterval@", "@delayCloseInterval@");
        if (a12 != null && a12.length() > 0) {
            try {
                this.delayCloseInterval = Long.valueOf(Long.parseLong(a12));
            } catch (NumberFormatException unused) {
            }
        }
        String a13 = k9.a(str, "@delayImpressionInSeconds@", "@delayImpressionInSeconds@");
        if (a13 != null && a13.length() > 0) {
            try {
                this.delayImpressionInSeconds = Long.valueOf(Long.parseLong(a13));
            } catch (NumberFormatException unused2) {
            }
        }
        String a14 = k9.a(str, "@rewardDuration@", "@rewardDuration@");
        if (a14 != null) {
            try {
                this.rewardDuration = Integer.parseInt(a14);
            } catch (Throwable th2) {
                i3.a(th2);
            }
        }
        String a15 = k9.a(str, "@rewardedHideTimer@", "@rewardedHideTimer@");
        if (a15 != null) {
            try {
                this.rewardedHideTimer = Boolean.parseBoolean(a15);
            } catch (Throwable th3) {
                i3.a(th3);
            }
        }
        String a16 = k9.a(str, "@sendRedirectHops@", "@sendRedirectHops@");
        if (a16 != null && !a16.equals("")) {
            String[] split3 = a16.split(",");
            this.sendRedirectHops = new Boolean[split3.length];
            for (int i3 = 0; i3 < split3.length; i3++) {
                if (split3[i3].compareTo(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) == 0) {
                    this.sendRedirectHops[i3] = Boolean.TRUE;
                } else if (split3[i3].compareTo("false") == 0) {
                    this.sendRedirectHops[i3] = Boolean.FALSE;
                } else {
                    this.sendRedirectHops[i3] = null;
                }
            }
        }
        ConsentData consentData = new ConsentData();
        this.consentData = consentData;
        consentData.b(k9.a(str, "@infoDparam@", "@infoDparam@"));
        this.consentData.c(k9.a(str, "@infoImpUrl@", "@infoImpUrl@"));
        this.consentData.a(k9.a(str, "@infoClickUrl@", "@infoClickUrl@"));
        try {
            String a17 = k9.a(str, "@ct@", "@ct@");
            if (!TextUtils.isEmpty(a17)) {
                this.consentData.a(Integer.valueOf(Integer.parseInt(a17)));
            }
        } catch (Throwable th4) {
            i3.a(th4);
        }
        try {
            String a18 = k9.a(str, "@tsc@", "@tsc@");
            if (!TextUtils.isEmpty(a18)) {
                this.consentData.a(Long.valueOf(Long.parseLong(a18)));
            }
        } catch (Throwable th5) {
            i3.a(th5);
        }
        try {
            String a19 = k9.a(str, "@apc@", "@apc@");
            if (!TextUtils.isEmpty(a19)) {
                this.consentData.a(Boolean.valueOf(Boolean.parseBoolean(a19)));
            }
        } catch (Throwable th6) {
            i3.a(th6);
        }
        int length = this.smartRedirect.length;
        String[] strArr = this.trackingUrls;
        if (length < strArr.length) {
            boolean[] zArr = new boolean[strArr.length];
            int i4 = 0;
            while (true) {
                boolean[] zArr2 = this.smartRedirect;
                if (i4 >= zArr2.length) {
                    break;
                }
                zArr[i4] = zArr2[i4];
                i4++;
            }
            while (i4 < this.trackingUrls.length) {
                zArr[i4] = false;
                i4++;
            }
            this.smartRedirect = zArr;
        }
    }

    public String[] g() {
        return this.closingUrl;
    }

    public String getAdId() {
        return k9.a(k(), "@adId@", "@adId@");
    }

    public String getBidToken() {
        return k9.a(k(), "@bidToken@", "@bidToken@");
    }

    public String getDParam() {
        String[] strArr = this.trackingClickUrls;
        String[] strArr2 = this.trackingUrls;
        String str = null;
        String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
        }
        return a.a(str2, str);
    }

    public Long h() {
        return this.delayCloseInterval;
    }

    public Long i() {
        return this.delayImpressionInSeconds;
    }

    public int j() {
        return this.height;
    }

    public String k() {
        d dVar = d.h;
        return dVar.b.get(this.htmlUuid);
    }

    public String l() {
        return this.htmlUuid;
    }

    public int m() {
        return this.orientation;
    }

    public String[] n() {
        return this.packageNames;
    }

    public int o() {
        return this.rewardDuration;
    }

    public String[] p() {
        return this.trackingClickUrls;
    }

    public int q() {
        return this.width;
    }

    public final void r() {
        c = k9.a(getContext());
    }

    public boolean s() {
        return this.isMraidAd;
    }

    public boolean t() {
        return this.rewardedHideTimer;
    }

    public Boolean[] u() {
        return this.sendRedirectHops;
    }

    public void a(SplashConfig.Orientation orientation2) {
        this.orientation = 0;
        Map<Activity, Integer> map = k9.a;
        if (orientation2 == null) {
            return;
        }
        if (orientation2.equals(SplashConfig.Orientation.PORTRAIT)) {
            this.orientation = 1;
        } else if (orientation2.equals(SplashConfig.Orientation.LANDSCAPE)) {
            this.orientation = 2;
        }
    }

    public boolean a(int i) {
        boolean[] zArr = this.inAppBrowserEnabled;
        if (zArr == null || i < 0 || i >= zArr.length) {
            return true;
        }
        return zArr[i];
    }

    public void a(List<AppPresenceDetails> list) {
        this.apps = list;
    }

    public Boolean b(int i) {
        Boolean[] boolArr = this.sendRedirectHops;
        if (boolArr == null || i < 0 || i >= boolArr.length) {
            return null;
        }
        return boolArr[i];
    }
}
