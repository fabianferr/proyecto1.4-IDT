package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.File;
import java.util.Collections;

public class a extends com.applovin.impl.sdk.f.a {
    private final e a = new e();
    private final AppLovinNativeAdImpl c;
    private final C0021a d;

    /* renamed from: com.applovin.impl.sdk.nativeAd.a$a  reason: collision with other inner class name */
    public interface C0021a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, m mVar, C0021a aVar) {
        super("TaskCacheNativeAd", mVar);
        this.c = appLovinNativeAdImpl;
        this.d = aVar;
    }

    private Uri a(Uri uri) {
        String str;
        if (uri == null) {
            return null;
        }
        if (u.a()) {
            a("Attempting to cache resource: " + uri);
        }
        String a2 = this.b.aa() != null ? this.b.aa().a(f(), uri.toString(), this.c.getCachePrefix(), Collections.emptyList(), false, this.a) : this.b.ab().a(f(), uri.toString(), this.c.getCachePrefix(), Collections.emptyList(), false, this.a);
        if (StringUtils.isValidString(a2)) {
            File a3 = this.b.aa() != null ? this.b.aa().a(a2, f()) : this.b.ab().a(a2, f());
            if (a3 != null) {
                Uri fromFile = Uri.fromFile(a3);
                if (fromFile != null) {
                    return fromFile;
                }
                if (u.a()) {
                    str = "Unable to extract Uri from image file";
                }
            } else if (u.a()) {
                str = "Unable to retrieve File from cached image filename = " + a2;
            }
            d(str);
        }
        return null;
    }

    public void run() {
        if (u.a()) {
            a("Begin caching ad #" + this.c.getAdIdNumber() + "...");
        }
        Uri a2 = a(this.c.getIconUri());
        if (a2 != null) {
            this.c.setIconUri(a2);
        }
        Uri a3 = a(this.c.getMainImageUri());
        if (a3 != null) {
            this.c.setMainImageUri(a3);
        }
        Uri a4 = a(this.c.getPrivacyIconUri());
        if (a4 != null) {
            this.c.setPrivacyIconUri(a4);
        }
        if (u.a()) {
            a("Finished caching ad #" + this.c.getAdIdNumber());
        }
        this.d.a(this.c);
    }
}
