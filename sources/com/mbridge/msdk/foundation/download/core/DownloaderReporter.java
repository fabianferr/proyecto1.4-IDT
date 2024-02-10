package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class DownloaderReporter {
    private static final String KEY = "key=";
    private static final String TAG = "DownloaderReporter";
    private final Map<String, String> _params;
    private final String _reportKey;

    private DownloaderReporter(Builder builder) {
        this._reportKey = builder._reportKey;
        this._params = builder._params;
    }

    public final void report() {
        String str = KEY + this._reportKey + asUrlParams(this._params);
        if (k.a().c()) {
            k.a().a(str);
            return;
        }
        try {
            new a(b.d().g()).post(0, d.a().a, q.a(str, b.d().g(), ""), (e) null);
        } catch (Exception e) {
            aa.d(TAG, "report exception: " + e.getMessage());
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String next : map.keySet()) {
                    String encodeValue = encodeValue(map.get(next));
                    sb.append("&");
                    sb.append(next);
                    sb.append("=");
                    sb.append(encodeValue);
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private String encodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public final Map<String, String> _params;
        /* access modifiers changed from: private */
        public final String _reportKey;

        public Builder(String str) {
            if (!TextUtils.isEmpty(str)) {
                this._reportKey = str;
                this._params = new HashMap();
                return;
            }
            throw new IllegalArgumentException("reportKey can not be empty");
        }

        public Builder add(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    this._params.put(str, str2);
                } catch (Exception unused) {
                }
            }
            return this;
        }

        public DownloaderReporter build() {
            return new DownloaderReporter(this);
        }
    }
}
