package com.applovin.impl.sdk;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinUserSegment;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class g implements AppLovinUserSegment {
    private String a;

    g() {
    }

    public String getName() {
        return this.a;
    }

    public void setName(String str) {
        if (u.a() && str != null) {
            if (str.length() > 32) {
                u.i("AppLovinUserSegment", "Setting name greater than 32 characters: " + str);
            }
            if (!StringUtils.isAlphaNumeric(str)) {
                u.i("AppLovinUserSegment", "Setting name that is not alphanumeric: " + str);
            }
        }
        this.a = str;
    }

    public String toString() {
        return "AppLovinUserSegment{name=" + getName() + AbstractJsonLexerKt.END_OBJ;
    }
}
