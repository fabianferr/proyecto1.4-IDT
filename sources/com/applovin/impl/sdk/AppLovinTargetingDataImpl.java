package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdContentRating;
import com.applovin.sdk.AppLovinGender;
import com.applovin.sdk.AppLovinTargetingData;
import java.util.List;
import java.util.Map;

public class AppLovinTargetingDataImpl implements AppLovinTargetingData {
    private final Map<String, String> a = CollectionUtils.map();
    private final Object b = new Object();
    private Integer c = null;
    private AppLovinGender d = null;
    private AppLovinAdContentRating e = null;
    private String f = null;
    private String g = null;
    private List<String> h = null;
    private List<String> i = null;

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.b) {
                if (StringUtils.isValidString(str2)) {
                    this.a.put(str, str2);
                } else {
                    this.a.remove(str);
                }
            }
        }
    }

    public void clearAll() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    public Map<String, String> getAllData() {
        Map<String, String> map;
        synchronized (this.b) {
            map = CollectionUtils.map(this.a);
        }
        return map;
    }

    public String getEmail() {
        return this.f;
    }

    public AppLovinGender getGender() {
        return this.d;
    }

    public List<String> getInterests() {
        return this.i;
    }

    public List<String> getKeywords() {
        return this.h;
    }

    public AppLovinAdContentRating getMaximumAdContentRating() {
        return this.e;
    }

    public String getPhoneNumber() {
        return this.g;
    }

    public Integer getYearOfBirth() {
        return this.c;
    }

    public void setEmail(String str) {
        a("email", str != null ? StringUtils.toFullSHA1Hash(str.toLowerCase().trim()) : str);
        this.f = str;
    }

    public void setGender(AppLovinGender appLovinGender) {
        String str;
        if (appLovinGender != null) {
            if (appLovinGender == AppLovinGender.FEMALE) {
                str = "F";
            } else if (appLovinGender == AppLovinGender.MALE) {
                str = "M";
            } else if (appLovinGender == AppLovinGender.OTHER) {
                str = "O";
            }
            a("gender", str);
            this.d = appLovinGender;
        }
        str = null;
        a("gender", str);
        this.d = appLovinGender;
    }

    public void setInterests(List<String> list) {
        a("interests", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.i = list;
    }

    public void setKeywords(List<String> list) {
        a("keywords", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.h = list;
    }

    public void setMaximumAdContentRating(AppLovinAdContentRating appLovinAdContentRating) {
        a("maximum_ad_content_rating", (appLovinAdContentRating == null || appLovinAdContentRating == AppLovinAdContentRating.NONE) ? null : Integer.toString(appLovinAdContentRating.ordinal()));
        this.e = appLovinAdContentRating;
    }

    public void setPhoneNumber(String str) {
        a("phone_number", str != null ? StringUtils.toFullSHA1Hash(str.replaceAll("[^0-9]", "")) : str);
        this.g = str;
    }

    public void setYearOfBirth(Integer num) {
        a("year_of_birth", num == null ? null : Integer.toString(num.intValue()));
        this.c = num;
    }
}
