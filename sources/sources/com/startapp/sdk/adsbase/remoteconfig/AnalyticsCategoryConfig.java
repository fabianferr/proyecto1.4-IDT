package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.d9;
import com.startapp.h9;
import com.startapp.k9;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Sta */
public class AnalyticsCategoryConfig implements Serializable {
    private static final long serialVersionUID = 5410570404581113345L;
    private Double enabled;
    @d9(parser = FiltersParser.class, type = ArrayList.class, value = AnalyticsCategoryFilterConfig.class)
    private List<AnalyticsCategoryFilterConfig> filters;
    private String firstDelay;
    private Integer flags;
    private Integer priority;
    private Boolean sendViaDb;
    private String ttl;

    /* compiled from: Sta */
    public static class FiltersParser extends h9<AnalyticsCategoryFilterConfig> {
        public FiltersParser() {
            super(AnalyticsCategoryFilterConfig.class);
        }
    }

    public Double a() {
        return this.enabled;
    }

    public List<AnalyticsCategoryFilterConfig> b() {
        return this.filters;
    }

    public String c() {
        return this.firstDelay;
    }

    public Integer d() {
        return this.flags;
    }

    public Integer e() {
        return this.priority;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnalyticsCategoryConfig analyticsCategoryConfig = (AnalyticsCategoryConfig) obj;
        if (!k9.a(this.enabled, analyticsCategoryConfig.enabled) || !k9.a(this.flags, analyticsCategoryConfig.flags) || !k9.a(this.priority, analyticsCategoryConfig.priority) || !k9.a(this.sendViaDb, analyticsCategoryConfig.sendViaDb) || !k9.a(this.ttl, analyticsCategoryConfig.ttl) || !k9.a(this.firstDelay, analyticsCategoryConfig.firstDelay) || !k9.a(this.filters, analyticsCategoryConfig.filters)) {
            return false;
        }
        return true;
    }

    public Boolean f() {
        return this.sendViaDb;
    }

    public String g() {
        return this.ttl;
    }

    public int hashCode() {
        Object[] objArr = {this.enabled, this.flags, this.priority, this.sendViaDb, this.ttl, this.firstDelay, this.filters};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
