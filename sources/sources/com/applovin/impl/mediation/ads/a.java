package com.applovin.impl.mediation.ads;

import android.app.Activity;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.k;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class a {
    private static m a;
    protected final MaxAdFormat adFormat;
    protected MaxAdListener adListener;
    protected MaxAdReviewListener adReviewListener;
    protected final String adUnitId;
    protected final Map<String, Object> extraParameters = Collections.synchronizedMap(CollectionUtils.map());
    protected final Map<String, Object> localExtraParameters = Collections.synchronizedMap(CollectionUtils.map());
    protected final u logger;
    protected MaxAdRequestListener requestListener;
    protected MaxAdRevenueListener revenueListener;
    protected final m sdk;
    protected final String tag;

    /* renamed from: com.applovin.impl.mediation.ads.a$a  reason: collision with other inner class name */
    public interface C0011a extends MaxAdListener, MaxAdRequestListener, MaxAdRevenueListener {
    }

    protected a(String str, MaxAdFormat maxAdFormat, String str2, m mVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = mVar;
        this.tag = str2;
        this.logger = mVar.A();
    }

    public static void logApiCall(String str, String str2) {
        if (a == null) {
            for (AppLovinSdk appLovinSdk : AppLovinSdk.a()) {
                m mVar = appLovinSdk.coreSdk;
                if (!mVar.e()) {
                    if (u.a()) {
                        mVar.A().b(str, str2);
                    }
                    a = mVar;
                }
            }
        } else if (u.a()) {
            a.A().b(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        if (u.a()) {
            k kVar = new k();
            kVar.a().a("MAX Ad").a(aVar).a();
            this.logger.b(this.tag, kVar.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        this.localExtraParameters.clear();
        this.adListener = null;
        this.revenueListener = null;
        this.requestListener = null;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void logApiCall(String str) {
        if (u.a()) {
            this.logger.b(this.tag, str);
        }
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Setting Ad Review creative id listener: " + maxAdReviewListener);
        }
        this.adReviewListener = maxAdReviewListener;
    }

    public void setExtraParameter(String str, String str2) {
        if (str != null) {
            if (this.adFormat.isAdViewAd() && "ad_refresh_seconds".equals(str) && StringUtils.isValidString(str2)) {
                int parseInt = Integer.parseInt(str2);
                if (((long) parseInt) > TimeUnit.MINUTES.toSeconds(2) && u.a()) {
                    String str3 = this.tag;
                    u.i(str3, "Attempting to set extra parameter \"ad_refresh_seconds\" to over 2 minutes (" + parseInt + "s) - this will be ignored");
                }
            }
            this.extraParameters.put(str, str2);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public void setListener(MaxAdListener maxAdListener) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Setting listener: " + maxAdListener);
        }
        this.adListener = maxAdListener;
    }

    public void setLocalExtraParameter(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (!(obj instanceof Activity)) {
            if ("amazon_ad_response".equals(str) || "amazon_ad_error".equals(str)) {
                setExtraParameter("is_amazon_integration", Boolean.toString(true));
            }
            this.localExtraParameters.put(str, obj);
        } else if (u.a()) {
            this.logger.e(this.tag, "Ignoring setting local extra parameter to Activity instance - please pass a WeakReference of it instead!");
        }
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Setting request listener: " + maxAdRequestListener);
        }
        this.requestListener = maxAdRequestListener;
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Setting revenue listener: " + maxAdRevenueListener);
        }
        this.revenueListener = maxAdRevenueListener;
    }
}
