package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class e implements AppLovinCommunicatorSubscriber {
    private final m a;
    private final Object b = new Object();
    private final LinkedHashMap<String, Bundle> c = new LinkedHashMap<String, Bundle>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    };
    private final Set<a> d = Collections.synchronizedSet(new HashSet());

    public interface a {
        void onCreativeIdGenerated(String str, String str2);
    }

    public e(m mVar) {
        this.a = mVar;
        if (StringUtils.isValidString(a())) {
            AppLovinCommunicator.getInstance(mVar.L()).subscribe((AppLovinCommunicatorSubscriber) this, "safedk_ad_info");
        }
    }

    public static String a() {
        return c(MobileAdsBridge.versionMethodName);
    }

    public static String b() {
        return c("getSdkKey");
    }

    private static String c(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("com.applovin.quality.AppLovinQualityService");
        } catch (Throwable unused) {
            return "";
        }
        return (String) cls.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    public Bundle a(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.b) {
            bundle = this.c.get(str);
        }
        return bundle;
    }

    public void a(a aVar) {
        this.d.add(aVar);
    }

    public void b(a aVar) {
        this.d.remove(aVar);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.b) {
                this.c.remove(str);
            }
        }
    }

    public String getCommunicatorId() {
        return com.ironsource.sdk.c.e.a;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle != null) {
                Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
                if (bundle2 == null) {
                    if (u.a()) {
                        this.a.A().d("AppLovinSdk", "Received SafeDK ad info without private data");
                    }
                } else if (MaxAdFormat.formatFromString(bundle2.getString(FirebaseAnalytics.Param.AD_FORMAT)) != null) {
                    final String string = bundle2.getString("id");
                    if (!TextUtils.isEmpty(string)) {
                        synchronized (this.b) {
                            u A = this.a.A();
                            A.b("AppLovinSdk", "Storing current SafeDK ad info for serve id: " + string);
                            this.c.put(string, bundle);
                        }
                        final String string2 = bundle.getString("ad_review_creative_id");
                        if (StringUtils.isValidString(string2) && !this.d.isEmpty()) {
                            Iterator it = new HashSet(this.d).iterator();
                            while (it.hasNext()) {
                                final a aVar = (a) it.next();
                                this.a.S().a((com.applovin.impl.sdk.f.a) new z(this.a, new Runnable() {
                                    public void run() {
                                        aVar.onCreativeIdGenerated(string, string2);
                                    }
                                }), o.a.BACKGROUND);
                            }
                        }
                    } else if (u.a()) {
                        this.a.A().d("AppLovinSdk", "Received SafeDK ad info without serve id");
                    }
                } else if (u.a()) {
                    this.a.A().d("AppLovinSdk", "Received SafeDK ad info without ad format");
                }
            } else if (u.a()) {
                this.a.A().d("AppLovinSdk", "Received SafeDK ad info without public data");
            }
        }
    }
}
