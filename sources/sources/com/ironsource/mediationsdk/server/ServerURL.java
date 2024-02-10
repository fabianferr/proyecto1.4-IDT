package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.ServerProtocol;
import com.ironsource.environment.a;
import com.ironsource.environment.c;
import com.ironsource.environment.d.b;
import com.ironsource.environment.h;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.e;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ServerURL {
    private static final String AMPERSAND = "&";
    private static final String ANDROID = "android";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION = "appVer";
    private static final String AUID = "auid";
    private static String BASE_URL_PREFIX = "https://init.supersonicads.com/sdk/v";
    private static final String BASE_URL_SUFFIX = "?request=";
    private static final String BROWSER_USER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CONNECTION_TYPE = "connType";
    private static final String COPPA = "coppa";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "devMake";
    private static final String DEVICE_MODEL = "devModel";
    private static final String EQUAL = "=";
    private static final String FIRST_SESSION = "fs";
    private static final String GAID = "advId";
    private static final String GOOGLE_FAMILY_SUPPORT = "dff";
    private static final String IMPRESSION = "impression";
    private static final String ISO_COUNTRY_CODE = "icc";
    private static final String IS_DEMAND_ONLY = "isDemandOnly";
    private static final String MEDIATION_TYPE = "mt";
    private static final String MOBILE_CARRIER = "mCar";
    private static final String MOBILE_COUNTRY_CODE = "mcc";
    private static final String MOBILE_NETWORK_CODE = "mnc";
    private static final String OS_VERSION = "osVer";
    private static final String PLACEMENT = "placementId";
    private static final String PLATFORM_KEY = "platform";
    private static final String PLUGIN_FW_VERSION = "plugin_fw_v";
    private static final String PLUGIN_TYPE = "pluginType";
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String REWARDED_VIDEO_MANUAL_MODE = "rvManual";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String SERR = "serr";
    private static final String TEST_SUITE = "ts";
    private static final String TIME_ZONE_ID = "tz";
    private static final String TIME_ZONE_OFFSET = "tzOff";

    private static String createURLParams(List<Pair<String, String>> list) {
        String str = "";
        for (Pair next : list) {
            if (str.length() > 0) {
                str = str + AMPERSAND;
            }
            str = str + ((String) next.first) + EQUAL + URLEncoder.encode((String) next.second, "UTF-8");
        }
        return str;
    }

    private static String getBaseUrl(String str) {
        return BASE_URL_PREFIX + str + BASE_URL_SUFFIX;
    }

    public static String getCPVProvidersURL(Context context, String str, String str2, String str3, String str4, boolean z, List<Pair<String, String>> list, boolean z2) {
        String str5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(PLATFORM_KEY, "android"));
        arrayList.add(new Pair(APPLICATION_KEY, str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new Pair(APPLICATION_USER_ID, str2));
        }
        arrayList.add(new Pair(SDK_VERSION, IronSourceUtils.getSDKVersion()));
        if (z) {
            arrayList.add(new Pair(REWARDED_VIDEO_MANUAL_MODE, "1"));
        }
        if (!IronSourceUtils.isEncryptedResponse()) {
            arrayList.add(new Pair(SERR, "0"));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            arrayList.add(new Pair(PLUGIN_TYPE, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            arrayList.add(new Pair(PLUGIN_VERSION, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            arrayList.add(new Pair(PLUGIN_FW_VERSION, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new Pair(GAID, str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(new Pair(MEDIATION_TYPE, str4));
        }
        String c = c.c(context, context.getPackageName());
        if (!TextUtils.isEmpty(c)) {
            arrayList.add(new Pair(APPLICATION_VERSION, c));
        }
        int i = Build.VERSION.SDK_INT;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        arrayList.add(new Pair(OS_VERSION, sb.toString()));
        arrayList.add(new Pair(DEVICE_MAKE, Build.MANUFACTURER));
        arrayList.add(new Pair(DEVICE_MODEL, Build.MODEL));
        boolean firstSession = IronSourceUtils.getFirstSession(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(firstSession ? 1 : 0);
        arrayList.add(new Pair(FIRST_SESSION, sb2.toString()));
        ConcurrentHashMap<String, List<String>> c2 = com.ironsource.mediationsdk.d.c.a().c();
        if (c2.containsKey("is_child_directed")) {
            arrayList.add(new Pair(COPPA, c2.get("is_child_directed").get(0)));
        }
        if (c2.containsKey("is_test_suite")) {
            String str6 = (String) c2.get("is_test_suite").get(0);
            if (!TextUtils.isEmpty(str6) && str6.equalsIgnoreCase("enable")) {
                arrayList.add(new Pair("ts", "1"));
            }
        }
        if (c2.containsKey("google_family_self_certified_sdks")) {
            String str7 = (String) c2.get("google_family_self_certified_sdks").get(0);
            if (!TextUtils.isEmpty(str7) && str7.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                arrayList.add(new Pair(GOOGLE_FAMILY_SUPPORT, "1"));
            }
        }
        String connectionType = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty(connectionType)) {
            arrayList.add(new Pair(CONNECTION_TYPE, connectionType));
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        String q = h.q();
        if (q.length() != 0) {
            arrayList.add(new Pair(BROWSER_USER_AGENT, q));
        }
        try {
            str5 = h.a(context) + "-" + h.b(context);
        } catch (Exception e) {
            e.printStackTrace();
            str5 = null;
        }
        if (!(str5 == null || str5.length() == 0)) {
            arrayList.add(new Pair(DEVICE_LANG, str5));
        }
        if (context != null) {
            arrayList.add(new Pair(BUNDLE_ID, context.getPackageName()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(a.AnonymousClass1.c(context));
            arrayList.add(new Pair("mcc", sb3.toString()));
            StringBuilder sb4 = new StringBuilder();
            sb4.append(a.AnonymousClass1.d(context));
            arrayList.add(new Pair("mnc", sb4.toString()));
            String j = h.j(context);
            if (!TextUtils.isEmpty(j)) {
                arrayList.add(new Pair(ISO_COUNTRY_CODE, j));
            }
            String i2 = h.i(context);
            if (!TextUtils.isEmpty(i2)) {
                arrayList.add(new Pair(MOBILE_CARRIER, i2));
            }
        }
        String c3 = h.c();
        if (!TextUtils.isEmpty(c3)) {
            arrayList.add(new Pair(TIME_ZONE_ID, c3));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(h.b());
        arrayList.add(new Pair(TIME_ZONE_OFFSET, sb5.toString()));
        String y = h.y(context);
        if (!TextUtils.isEmpty(y)) {
            arrayList.add(new Pair("auid", y));
        }
        if (z2) {
            arrayList.add(new Pair("isDemandOnly", "1"));
        }
        arrayList.addAll(IronSourceUtils.parseJsonToPairList(new b().a()));
        return getBaseUrl(IronSourceUtils.getSDKVersion()) + URLEncoder.encode(IronSourceAES.encode(e.a().b(), createURLParams(arrayList)), "UTF-8");
    }

    public static String getRequestURL(String str, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("impression", Boolean.toString(z)));
        arrayList.add(new Pair(PLACEMENT, Integer.toString(i)));
        String createURLParams = createURLParams(arrayList);
        return str + AMPERSAND + createURLParams;
    }

    private static void setBaseUrlPrefix(String str) {
        BASE_URL_PREFIX = str;
    }
}
