package com.applovin.impl.sdk.f;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.q;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.model.AdPayload;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c extends a implements h.a {
    protected final e a;
    /* access modifiers changed from: private */
    public AppLovinAdLoadListener c;
    private final q d;
    private final r e;
    private final Collection<Character> f;
    private final com.applovin.impl.sdk.e.e g;
    private boolean h;

    c(String str, e eVar, m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, mVar);
        if (eVar != null) {
            this.a = eVar;
            this.c = appLovinAdLoadListener;
            this.d = mVar.ab();
            this.e = mVar.aa();
            this.f = j();
            this.g = new com.applovin.impl.sdk.e.e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    private Uri a(Uri uri, String str) {
        String str2;
        StringBuilder sb;
        if (uri != null) {
            String uri2 = uri.toString();
            if (StringUtils.isValidString(uri2)) {
                if (u.a()) {
                    a("Caching " + str + " image...");
                }
                return g(uri2);
            } else if (!u.a()) {
                return null;
            } else {
                sb = new StringBuilder("Failed to cache ");
                sb.append(str);
                str2 = " image";
            }
        } else if (!u.a()) {
            return null;
        } else {
            sb = new StringBuilder("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        a(sb.toString());
        return null;
    }

    private Uri a(String str, String str2) {
        StringBuilder sb;
        if (this.e != null) {
            return b(str, str2);
        }
        String replace = str2.replace("/", "_");
        String L = this.a.L();
        if (StringUtils.isValidString(L)) {
            replace = L + replace;
        }
        File a2 = this.d.a(replace, this.b.L());
        if (a2 == null) {
            return null;
        }
        if (a2.exists()) {
            this.g.b(a2.length());
            sb = new StringBuilder(AdPayload.FILE_SCHEME);
        } else {
            if (!this.d.a(a2, str + str2, (List<String>) Arrays.asList(new String[]{str}), this.g)) {
                return null;
            }
            sb = new StringBuilder(AdPayload.FILE_SCHEME);
        }
        sb.append(a2.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    private Uri b(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", "_");
        String L = this.a.L();
        if (StringUtils.isValidString(L)) {
            replace = L + replace;
        }
        File a2 = this.e.a(replace, this.b.L());
        if (a2 == null) {
            return null;
        }
        if (a2.exists()) {
            this.g.b(a2.length());
            sb = new StringBuilder(AdPayload.FILE_SCHEME);
        } else {
            if (!this.e.a(a2, str + str2, (List<String>) Arrays.asList(new String[]{str}), this.g)) {
                return null;
            }
            sb = new StringBuilder(AdPayload.FILE_SCHEME);
        }
        sb.append(a2.getAbsolutePath());
        return Uri.parse(sb.toString());
    }

    private Uri g(String str) {
        return c(str, this.a.I(), true);
    }

    private Collection<Character> j() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.b.a(b.bo)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public Uri a(String str, List<String> list, boolean z) {
        String str2;
        if (this.e != null) {
            return b(str, list, z);
        }
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (u.a()) {
            a("Caching video " + str + "...");
        }
        String a2 = this.d.a(f(), str, this.a.L(), list, z, this.g);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.d.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    if (u.a()) {
                        a("Finish caching video for ad #" + this.a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a2);
                    }
                    return fromFile;
                } else if (!u.a()) {
                    return null;
                } else {
                    str2 = "Unable to create URI from cached video file = " + a3;
                }
            } else if (!u.a()) {
                return null;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
            d(str2);
            return null;
        }
        if (u.a()) {
            d("Failed to cache video");
        }
        h();
        return null;
    }

    /* access modifiers changed from: package-private */
    public String a(String str, List<String> list) {
        InputStream inputStream;
        if (this.e != null) {
            return b(str, list);
        }
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                if (u.a()) {
                    a("Nothing to cache, skipping...");
                }
                return null;
            }
            String fileName = ((Boolean) this.b.a(b.eW)).booleanValue() ? Utils.getFileName(parse) : parse.getLastPathSegment();
            if (StringUtils.isValidString(this.a.L())) {
                fileName = this.a.L() + fileName;
            }
            try {
                File a2 = this.d.a(fileName, f());
                if (a2 != null && a2.exists()) {
                    return this.d.a(a2);
                }
                inputStream = this.d.a(str, list, true, this.g);
                if (inputStream != null) {
                    try {
                        this.d.b(inputStream, a2);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                Utils.close(inputStream, this.b);
                return this.d.a(a2);
            } catch (Throwable th2) {
                if (u.a()) {
                    a("Resource at " + str + " failed to load.", th2);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String a(String str, List<String> list, e eVar) {
        StringBuilder sb;
        if (!StringUtils.isValidString(str)) {
            return str;
        }
        if (!((Boolean) this.b.a(b.bp)).booleanValue()) {
            if (u.a()) {
                a("Resource caching is disabled, skipping cache...");
            }
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        boolean shouldCancelHtmlCachingIfShown = eVar.shouldCancelHtmlCachingIfShown();
        boolean aK = eVar.aK();
        List<String> H = eVar.H();
        for (String next : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb2.length()) {
                if (b()) {
                    return str;
                }
                i = sb2.indexOf(next, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb2.length();
                int i3 = i;
                while (!this.f.contains(Character.valueOf(sb2.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    if (u.a()) {
                        d("Unable to cache resource; ad HTML is invalid.");
                    }
                    return str;
                }
                String substring = sb2.substring(next.length() + i, i3);
                if (StringUtils.isValidString(substring)) {
                    if (!shouldCancelHtmlCachingIfShown || !eVar.hasShown()) {
                        if (aK) {
                            String d2 = eVar.d();
                            if (d2.equals(next + substring)) {
                                if (u.a()) {
                                    sb = new StringBuilder("Postponing caching for \"");
                                    sb.append(substring);
                                    substring = "\" video resource";
                                } else {
                                    i2 = i3;
                                }
                            }
                        }
                        Uri a2 = a(next, substring);
                        if (a2 != null) {
                            sb2.replace(i, i3, a2.toString());
                            eVar.b(a2);
                            this.g.e();
                        } else {
                            if (H.contains(next + substring)) {
                                h();
                                this.h = true;
                            }
                            this.g.f();
                        }
                        i2 = i3;
                    } else {
                        if (u.a()) {
                            a("Cancelling HTML caching due to ad being shown already");
                        }
                        this.g.a();
                        return str;
                    }
                } else if (u.a()) {
                    sb = new StringBuilder("Skip caching of non-resource ");
                } else {
                    i2 = i3;
                }
                sb.append(substring);
                a(sb.toString());
                i2 = i3;
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.b.H().b(this);
    }

    public void a(a aVar) {
        if (aVar.f().equalsIgnoreCase(this.a.N())) {
            if (u.a()) {
                d("Updating flag for timeout...");
            }
            this.h = true;
        }
        this.b.H().b(this);
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdBase appLovinAdBase) {
        d.a(this.g, appLovinAdBase, this.b);
    }

    /* access modifiers changed from: package-private */
    public Uri b(String str, List<String> list, boolean z) {
        String str2;
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        a("Caching video " + str + "...");
        String a2 = this.e.a(f(), str, this.a.L(), list, z, this.g);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.e.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    a("Finish caching video for ad #" + this.a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a2);
                    return fromFile;
                }
                str2 = "Unable to create URI from cached video file = " + a3;
            } else {
                str2 = "Unable to cache video = " + str + "Video file was missing or null";
            }
            d(str2);
            return null;
        }
        d("Failed to cache video");
        h();
        Bundle bundle = new Bundle();
        bundle.putLong("ad_id", this.a.getAdIdNumber());
        bundle.putInt("load_response_code", this.g.j());
        Exception i = this.g.i();
        if (i != null) {
            bundle.putString("load_exception_message", i.getMessage());
        }
        this.b.ag().a(bundle, "video_caching_failed");
        return null;
    }

    /* access modifiers changed from: package-private */
    public String b(String str, List<String> list) {
        if (StringUtils.isValidString(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                a("Nothing to cache, skipping...");
                return null;
            }
            String fileName = ((Boolean) this.b.a(b.eW)).booleanValue() ? Utils.getFileName(parse) : parse.getLastPathSegment();
            if (StringUtils.isValidString(this.a.L())) {
                fileName = this.a.L() + fileName;
            }
            File a2 = this.e.a(fileName, f());
            ByteArrayOutputStream a3 = (a2 == null || !a2.exists()) ? null : this.e.a(a2);
            if (a3 == null) {
                a3 = this.e.a(str, list, true, this.g);
                if (a3 != null) {
                    this.e.a(a3, a2);
                    this.g.a((long) a3.size());
                }
            } else {
                this.g.b((long) a3.size());
            }
            try {
                return a3.toString("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                a("UTF-8 encoding not supported.", e2);
            } catch (Throwable th) {
                a("String resource at " + str + " failed to load.", th);
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public Uri c(String str, List<String> list, boolean z) {
        String str2;
        if (this.e != null) {
            return d(str, list, z);
        }
        try {
            String a2 = this.d.a(f(), str, this.a.L(), list, z, this.g);
            if (!StringUtils.isValidString(a2)) {
                return null;
            }
            File a3 = this.d.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                if (!u.a()) {
                    return null;
                }
                str2 = "Unable to extract Uri from image file";
            } else if (!u.a()) {
                return null;
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a2;
            }
            d(str2);
            return null;
        } catch (Throwable th) {
            if (!u.a()) {
                return null;
            }
            a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (u.a()) {
            a("Caching mute images...");
        }
        Uri a2 = a(this.a.aC(), CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (a2 != null) {
            this.a.c(a2);
        }
        Uri a3 = a(this.a.aD(), CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        if (a3 != null) {
            this.a.d(a3);
        }
        if (u.a()) {
            a("Ad updated with muteImageFilename = " + this.a.aC() + ", unmuteImageFilename = " + this.a.aD());
        }
    }

    /* access modifiers changed from: package-private */
    public Uri d(String str, List<String> list, boolean z) {
        String str2;
        try {
            String a2 = this.e.a(f(), str, this.a.L(), list, z, this.g);
            if (!StringUtils.isValidString(a2)) {
                return null;
            }
            File a3 = this.e.a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                str2 = "Unable to extract Uri from image file";
            } else {
                str2 = "Unable to retrieve File from cached image filename = " + a2;
            }
            d(str2);
            return null;
        } catch (Throwable th) {
            a("Failed to cache image at url = " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Uri e(String str) {
        return a(str, this.a.I(), true);
    }

    /* access modifiers changed from: package-private */
    public String f(final String str) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        com.applovin.impl.sdk.network.c a2 = com.applovin.impl.sdk.network.c.a(this.b).a(str).b("GET").a("").a(0).a();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        this.b.R().a(a2, new b.a(), new b.c<String>() {
            public void a(int i, String str, String str2) {
                c cVar = c.this;
                cVar.d("Failed to load resource from '" + str + "'");
            }

            public void a(String str, int i) {
                atomicReference.set(str);
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.g.a((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.c;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (u.a()) {
            a("Rendered new ad:" + this.a);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (c.this.c != null) {
                    c.this.c.adReceived(c.this.a);
                    AppLovinAdLoadListener unused = c.this.c = null;
                }
            }
        });
    }

    public void run() {
        if (this.a.M()) {
            if (u.a()) {
                a("Subscribing to timeout events...");
            }
            this.b.H().a((h.a) this);
        }
    }
}
