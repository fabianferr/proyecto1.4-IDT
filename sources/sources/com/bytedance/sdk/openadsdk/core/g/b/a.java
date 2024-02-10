package com.bytedance.sdk.openadsdk.core.g.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.facebook.internal.security.CertificateUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastAbsoluteProgressTracker */
public class a extends c implements Comparable<a> {
    public long a;

    protected a(long j, String str, c.C0065c cVar, Boolean bool) {
        super(str, cVar, bool);
        this.a = j;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] split = str.split(CertificateUtil.DELIMITER);
        if (split.length == 3) {
            try {
                return (int) (((float) ((Integer.parseInt(split[0]) * 60 * 60 * 1000) + (Integer.parseInt(split[1]) * 60 * 1000))) + (Float.parseFloat(split[2]) * 1000.0f));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public boolean a(long j) {
        return this.a <= j && !e();
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        long j = this.a;
        long j2 = aVar.a;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.b.a$a  reason: collision with other inner class name */
    /* compiled from: VastAbsoluteProgressTracker */
    public static class C0064a {
        private final String a;
        private final long b;
        private c.C0065c c = c.C0065c.TRACKING_URL;
        private boolean d = false;

        public C0064a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public a a() {
            return new a(this.b, this.a, this.c, Boolean.valueOf(this.d));
        }
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", c());
        jSONObject.put("trackingMilliseconds", this.a);
        return jSONObject;
    }
}
