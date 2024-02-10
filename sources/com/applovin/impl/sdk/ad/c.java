package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private final m a;
    private final String b;

    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        
        private final String d;

        private a(String str) {
            this.d = str;
        }

        public String toString() {
            return this.d;
        }
    }

    public c(String str, m mVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (mVar != null) {
            this.b = str;
            this.a = mVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    private String a(b<String> bVar) {
        for (String next : this.a.b(bVar)) {
            if (this.b.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    public String a() {
        return this.b;
    }

    public a b() {
        return a(b.bc) != null ? a.REGULAR : a(b.bd) != null ? a.AD_RESPONSE_JSON : a.UNSPECIFIED;
    }

    public String c() {
        String a2 = a(b.bc);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String a3 = a(b.bd);
        if (!TextUtils.isEmpty(a3)) {
            return a3;
        }
        return null;
    }

    public JSONObject d() {
        if (b() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.b.substring(c().length()), 0), "UTF-8"));
                if (u.a()) {
                    u A = this.a.A();
                    A.b("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e) {
                if (!u.a()) {
                    return null;
                }
                u A2 = this.a.A();
                A2.b("AdToken", "Unable to decode token '" + this.b + "' into JSON", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            if (!u.a()) {
                return null;
            }
            u A3 = this.a.A();
            A3.b("AdToken", "Unable to process ad response from token '" + this.b + "'", e2);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        String str = this.b;
        String str2 = ((c) obj).b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String prefixToIndex = StringUtils.prefixToIndex(32, this.b);
        return "AdToken{id=" + prefixToIndex + ", type=" + b() + AbstractJsonLexerKt.END_OBJ;
    }
}
