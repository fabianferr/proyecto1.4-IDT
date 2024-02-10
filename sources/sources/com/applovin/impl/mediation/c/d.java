package com.applovin.impl.mediation.c;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
    private final String a;
    private final String c;
    private final f d;
    private final Map<String, String> e;
    private final Map<String, String> f;
    private final MaxError g;

    public d(String str, Map<String, String> map, MaxError maxError, f fVar, m mVar) {
        super("TaskFireMediationPostbacks", mVar);
        this.a = str;
        this.c = str + "_urls";
        this.e = Utils.toUrlSafeMap(map, mVar);
        this.g = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.d = fVar;
        Map<String, String> map2 = CollectionUtils.map(7);
        map2.put("AppLovin-Event-Type", str);
        map2.put("AppLovin-Ad-Network-Name", fVar.N());
        if (fVar instanceof com.applovin.impl.mediation.a.a) {
            com.applovin.impl.mediation.a.a aVar = (com.applovin.impl.mediation.a.a) fVar;
            map2.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            map2.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
            map2.put("AppLovin-Third-Party-Ad-Placement-ID", aVar.l());
        }
        if (maxError != null) {
            map2.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            map2.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f = map2;
    }

    private String a(String str, MaxError maxError) {
        int i;
        String str2;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            i = maxAdapterError.getMediatedNetworkErrorCode();
            str2 = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage(), d())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(str2, d()));
    }

    private Map<String, String> a() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.b.a(com.applovin.impl.sdk.d.a.i)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private void a(String str, Map<String, Object> map) {
        d().U().a(h.o().c(str).b("POST").b(this.f).a(false).c(map).b(((Boolean) this.b.a(com.applovin.impl.sdk.d.a.T)).booleanValue()).a());
    }

    private String b(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(next, StringUtils.emptyIfNull(map.get(next)));
        }
        return str;
    }

    public void run() {
        List<String> g2 = this.d.g(this.c);
        Map<String, String> a2 = a();
        for (String b : g2) {
            Uri parse = Uri.parse(a(b(b, this.e), this.g));
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            Map map = CollectionUtils.map(a2.size());
            for (String next : parse.getQueryParameterNames()) {
                String queryParameter = parse.getQueryParameter(next);
                if (a2.containsKey(queryParameter)) {
                    map.put(next, this.d.h(a2.get(queryParameter)));
                } else {
                    clearQuery.appendQueryParameter(next, queryParameter);
                }
            }
            a(clearQuery.build().toString(), (Map<String, Object>) map);
        }
    }
}
