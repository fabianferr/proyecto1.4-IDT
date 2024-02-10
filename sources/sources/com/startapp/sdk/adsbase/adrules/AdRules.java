package com.startapp.sdk.adsbase.adrules;

import android.app.Activity;
import com.startapp.d9;
import com.startapp.f;
import com.startapp.k9;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Sta */
public class AdRules implements Serializable {
    private static final long serialVersionUID = 9050956736420299872L;
    public transient Set<Class<? extends AdRule>> a = new HashSet();
    private boolean applyOnBannerRefresh = true;
    @d9(innerValue = AdRule.class, key = AdPreferences.Placement.class, type = HashMap.class, value = ArrayList.class)
    private Map<AdPreferences.Placement, List<AdRule>> placements = new HashMap();
    @d9(type = ArrayList.class, value = AdRule.class)
    private List<AdRule> session = new ArrayList();
    @d9(innerValue = AdRule.class, type = HashMap.class, value = ArrayList.class)
    private Map<String, List<AdRule>> tags = new HashMap();

    public boolean a() {
        return this.applyOnBannerRefresh;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdRules adRules = (AdRules) obj;
        if (this.applyOnBannerRefresh != adRules.applyOnBannerRefresh || !k9.a(this.session, adRules.session) || !k9.a(this.placements, adRules.placements) || !k9.a(this.tags, adRules.tags)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.session, this.placements, this.tags, Boolean.valueOf(this.applyOnBannerRefresh)};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public synchronized AdRulesResult a(AdPreferences.Placement placement, String str) {
        AdRulesResult a2;
        this.a.clear();
        a2 = a(this.tags.get(str), f.d.c.get(str), AdRuleLevel.TAG);
        if (a2.b()) {
            AdRuleLevel adRuleLevel = AdRuleLevel.PLACEMENT;
            placement.toString();
            a2 = a(this.placements.get(placement), f.d.b.get(placement), adRuleLevel);
            if (a2.b()) {
                a2 = a(this.session, f.d.a, AdRuleLevel.SESSION);
            }
        }
        return a2;
    }

    public final AdRulesResult a(List list, List list2, AdRuleLevel adRuleLevel) {
        if (list == null) {
            return new AdRulesResult(true, "");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdRule adRule = (AdRule) it.next();
            if (adRule.a || !this.a.contains(adRule.getClass())) {
                if (!adRule.a(list2)) {
                    return new AdRulesResult(false, adRule.getClass().getSimpleName() + "_" + adRuleLevel + "");
                }
                this.a.add(adRule.getClass());
            }
        }
        return new AdRulesResult(true, "");
    }
}
