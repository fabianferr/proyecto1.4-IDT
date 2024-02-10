package com.applovin.impl.a;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class e {
    private static final List<String> c = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});
    protected List<r> a = new ArrayList();
    private final m b;
    private final JSONObject d;
    private final JSONObject e;
    private final b f;
    private final long g = System.currentTimeMillis();

    public e(JSONObject jSONObject, JSONObject jSONObject2, b bVar, m mVar) {
        this.b = mVar;
        this.d = jSONObject;
        this.e = jSONObject2;
        this.f = bVar;
    }

    public int a() {
        return this.a.size();
    }

    public List<r> b() {
        return this.a;
    }

    public JSONObject c() {
        return this.d;
    }

    public JSONObject d() {
        return this.e;
    }

    public b e() {
        return this.f;
    }

    public long f() {
        return this.g;
    }

    public List<String> g() {
        List<String> explode = CollectionUtils.explode(JsonUtils.getString(this.d, "vast_preferred_video_types", (String) null));
        return !explode.isEmpty() ? explode : c;
    }

    public int h() {
        return Utils.getVideoCompletionPercent(this.d);
    }
}
