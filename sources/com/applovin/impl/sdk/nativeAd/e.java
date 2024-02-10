package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.r;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.a;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends a implements a.C0021a, AppLovinAdLoadListener {
    private final JSONObject a;
    private final JSONObject c;
    /* access modifiers changed from: private */
    public final AppLovinNativeAdLoadListener d;
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private Uri i = null;
    private Uri j = null;
    private Uri k = null;
    private Uri l = null;
    private com.applovin.impl.a.a m;
    private Uri n = null;
    private Uri o = null;
    private final List<String> p = new ArrayList();
    private String q;
    private final List<i> r = new ArrayList();
    private final List<i> s = new ArrayList();
    private final List<i> t = new ArrayList();
    private final List<i> u = new ArrayList();

    public e(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super("TaskRenderNativeAd", mVar);
        this.a = jSONObject;
        this.c = jSONObject2;
        this.d = appLovinNativeAdLoadListener;
    }

    private void a() {
        AppLovinNativeAdImpl build = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.a), JsonUtils.shallowCopy(this.c), this.b).setTitle(this.e).setAdvertiser(this.f).setBody(this.g).setCallToAction(this.h).setIconUri(this.i).setMainImageUri(this.j).setPrivacyIconUri(this.k).setVastAd(this.m).setPrivacyDestinationUri(this.l).setClickDestinationUri(this.n).setClickDestinationBackupUri(this.o).setClickTrackingUrls(this.p).setJsTracker(this.q).setImpressionRequests(this.r).setViewableMRC50Requests(this.s).setViewableMRC100Requests(this.t).setViewableVideo50Requests(this.u).build();
        build.getAdEventTracker().b();
        if (u.a()) {
            a("Starting cache task for type: " + build.getType() + "...");
        }
        this.b.S().a((com.applovin.impl.sdk.f.a) new a(build, this.b, this), o.a.MAIN);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String string = JsonUtils.getString(jSONObject, "url", (String) null);
            if (StringUtils.isValidString(string)) {
                this.n = Uri.parse(string);
                if (u.a()) {
                    a("Processed click destination URL: " + this.n);
                }
            }
            String string2 = JsonUtils.getString(jSONObject, "fallback", (String) null);
            if (StringUtils.isValidString(string2)) {
                this.o = Uri.parse(string2);
                if (u.a()) {
                    a("Processed click destination backup URL: " + this.o);
                }
            }
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", (JSONArray) null);
            if (jSONArray != null) {
                try {
                    this.p.addAll(JsonUtils.toList(jSONArray));
                    if (u.a()) {
                        a("Processed click tracking URLs: " + this.p);
                    }
                } catch (Throwable th) {
                    if (u.a()) {
                        a("Failed to render click tracking URLs", th);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.d.onNativeAdLoadFailed(-6);
    }

    private void b(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (u.a()) {
                    e.this.a("Preparing native ad view components...");
                }
                try {
                    appLovinNativeAdImpl.setUpNativeAdViewComponents();
                    if (u.a()) {
                        e.this.a("Successfully prepared native ad view components");
                    }
                    appLovinNativeAdImpl.getAdEventTracker().c();
                    e.this.d.onNativeAdLoaded(appLovinNativeAdImpl);
                } catch (Throwable th) {
                    if (u.a()) {
                        e.this.a("Failed to prepare native ad view components", th);
                    }
                    e.this.b();
                }
            }
        });
    }

    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (u.a()) {
            a("Successfully cached and loaded ad");
        }
        b(appLovinNativeAdImpl);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        if (u.a()) {
            a("VAST ad rendered successfully");
        }
        this.m = (com.applovin.impl.a.a) appLovinAd;
        a();
    }

    public void failedToReceiveAd(int i2) {
        if (u.a()) {
            d("VAST ad failed to render");
        }
        a();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [org.json.JSONObject, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v16 */
    public void run() {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        String sb6;
        String str2;
        Uri uri;
        ? r2 = 0;
        String string = JsonUtils.getString(this.a, "privacy_icon_url", (String) null);
        if (URLUtil.isValidUrl(string)) {
            this.k = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.a, CampaignEx.JSON_KEY_PRIVACY_URL, (String) null);
        if (!URLUtil.isValidUrl(string2)) {
            string2 = "https://www.applovin.com/privacy/";
        }
        this.l = Uri.parse(string2);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.a, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            if (u.a()) {
                d("No oRtb response provided: " + this.a);
            }
            b();
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, "version", (String) null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "value", (JSONObject) null);
        if (u.a()) {
            a("Rendering native ad for oRTB version: " + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, jSONObject2);
        a(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", (JSONArray) null);
        if (jSONArray == null || jSONArray.length() == 0) {
            if (u.a()) {
                d("Unable to retrieve assets - failing ad load: " + this.a);
            }
            b();
            return;
        }
        String str3 = "";
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) r2);
            if (jSONObject4.has("title")) {
                this.e = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "title", (JSONObject) r2), "text", r2);
                if (u.a()) {
                    a("Processed title: " + this.e);
                }
            } else if (jSONObject4.has("link")) {
                a(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r2));
            } else {
                if (jSONObject4.has("img")) {
                    int i3 = JsonUtils.getInt(jSONObject4, "id", -1);
                    JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r2);
                    int i4 = JsonUtils.getInt(jSONObject5, "type", -1);
                    String string4 = JsonUtils.getString(jSONObject5, "url", r2);
                    if (i4 == 1 || 3 == i3) {
                        this.i = Uri.parse(string4);
                        if (u.a()) {
                            sb3 = new StringBuilder("Processed icon URL: ");
                            uri = this.i;
                        }
                    } else if (i4 == 3 || 2 == i3) {
                        this.j = Uri.parse(string4);
                        if (u.a()) {
                            sb3 = new StringBuilder("Processed main image URL: ");
                            uri = this.j;
                        }
                    } else {
                        if (u.a()) {
                            c("Unrecognized image: " + jSONObject4);
                        }
                        int i5 = JsonUtils.getInt(jSONObject5, "w", -1);
                        int i6 = JsonUtils.getInt(jSONObject5, CmcdHeadersFactory.STREAMING_FORMAT_HLS, -1);
                        if (i5 > 0 && i6 > 0) {
                            int i7 = (((double) (((float) i5) / ((float) i6))) > 1.0d ? 1 : (((double) (((float) i5) / ((float) i6))) == 1.0d ? 0 : -1));
                            boolean a2 = u.a();
                            if (i7 > 0) {
                                if (a2) {
                                    a("Inferring main image from " + i5 + "x" + i6 + "...");
                                }
                                this.j = Uri.parse(string4);
                            } else {
                                if (a2) {
                                    a("Inferring icon image from " + i5 + "x" + i6 + "...");
                                }
                                this.i = Uri.parse(string4);
                            }
                        } else if (u.a()) {
                            sb6 = "Skipping...";
                        }
                    }
                    sb3.append(uri);
                    str2 = sb3.toString();
                    a(str2);
                } else {
                    if (jSONObject4.has("video")) {
                        str3 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "video", (JSONObject) null), "vasttag", (String) null);
                        if (StringUtils.isValidString(str3)) {
                            if (u.a()) {
                                str2 = "Processed VAST video";
                                a(str2);
                            }
                        } else if (u.a()) {
                            sb5 = new StringBuilder("Ignoring invalid \"vasttag\" for video: ");
                        }
                    } else if (jSONObject4.has("data")) {
                        int i8 = JsonUtils.getInt(jSONObject4, "id", -1);
                        JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                        int i9 = JsonUtils.getInt(jSONObject6, "type", -1);
                        String string5 = JsonUtils.getString(jSONObject6, "value", (String) null);
                        if (i9 == 1 || i8 == 8) {
                            this.f = string5;
                            if (u.a()) {
                                sb4 = new StringBuilder("Processed advertiser: ");
                                str = this.f;
                            }
                        } else if (i9 == 2 || i8 == 4) {
                            this.g = string5;
                            if (u.a()) {
                                sb4 = new StringBuilder("Processed body: ");
                                str = this.g;
                            }
                        } else if (i9 == 12 || i8 == 5) {
                            this.h = string5;
                            if (u.a()) {
                                sb4 = new StringBuilder("Processed cta: ");
                                str = this.h;
                            }
                        } else if (u.a()) {
                            sb5 = new StringBuilder("Skipping unsupported data: ");
                        }
                        sb3.append(str);
                        str2 = sb3.toString();
                        a(str2);
                    } else if (u.a()) {
                        d("Unsupported asset object: " + jSONObject4);
                    }
                    sb5.append(jSONObject4);
                    sb6 = sb5.toString();
                }
                c(sb6);
            }
            i2++;
            r2 = 0;
        }
        String string6 = JsonUtils.getString(jSONObject3, "jstracker", (String) null);
        if (StringUtils.isValidString(string6)) {
            this.q = string6;
            a("Processed jstracker: " + string6);
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", (JSONArray) null);
        if (jSONArray2 != null) {
            int i10 = 0;
            while (i10 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i10, obj);
                if (objectAtIndex instanceof String) {
                    String str4 = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str4)) {
                        this.r.add(new i.a(this.b).a(str4).d(false).c(false).a());
                        if (u.a()) {
                            a("Processed imptracker URL: " + str4);
                        }
                    }
                }
                i10++;
                obj = null;
            }
        }
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", (JSONArray) null);
        if (jSONArray3 != null) {
            for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i11, (JSONObject) null);
                int i12 = JsonUtils.getInt(jSONObject7, "event", -1);
                int i13 = JsonUtils.getInt(jSONObject7, FirebaseAnalytics.Param.METHOD, -1);
                String string7 = JsonUtils.getString(jSONObject7, "url", (String) null);
                if (!TextUtils.isEmpty(string7)) {
                    if (i13 == 1 || i13 == 2) {
                        i b = new i.a(this.b).a(string7).d(false).c(false).g(i13 == 2).a();
                        if (i12 == 1) {
                            this.r.add(b);
                            if (u.a()) {
                                a("Processed impression URL: " + string7);
                            }
                        } else {
                            if (i12 == 2) {
                                this.s.add(b);
                                if (u.a()) {
                                    sb2 = new StringBuilder("Processed viewable MRC50 URL: ");
                                }
                            } else if (i12 == 3) {
                                this.t.add(b);
                                if (u.a()) {
                                    sb2 = new StringBuilder("Processed viewable MRC100 URL: ");
                                }
                            } else {
                                if (i12 == 4) {
                                    this.u.add(b);
                                    if (u.a()) {
                                        sb = new StringBuilder("Processed viewable video 50 URL: ");
                                    }
                                } else {
                                    if (i12 == 555) {
                                        if (u.a()) {
                                            sb = new StringBuilder("Ignoring processing of OMID URL: ");
                                        }
                                    } else if (u.a()) {
                                        d("Unsupported event tracker: " + jSONObject7);
                                    }
                                }
                                sb.append(string7);
                                a(sb.toString());
                            }
                            sb2.append(string7);
                            a(sb2.toString());
                        }
                    } else if (u.a()) {
                        d("Unsupported method for event tracker: " + jSONObject7);
                    }
                }
            }
        }
        if (StringUtils.isValidString(str3)) {
            if (u.a()) {
                a("Processing VAST video...");
            }
            this.b.S().a((com.applovin.impl.sdk.f.a) r.a(str3, JsonUtils.shallowCopy(this.a), JsonUtils.shallowCopy(this.c), b.UNKNOWN, this, this.b));
            return;
        }
        a();
    }
}
