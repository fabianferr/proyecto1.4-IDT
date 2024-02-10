package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {
    private final a a;
    private final String b;
    private final String c;
    private final List<MaxNetworkResponseInfo> d;
    private final long e;

    public MaxAdWaterfallInfoImpl(a aVar, long j, List<MaxNetworkResponseInfo> list) {
        this(aVar, aVar.m(), aVar.n(), j, list);
    }

    public MaxAdWaterfallInfoImpl(a aVar, String str, String str2, long j, List<MaxNetworkResponseInfo> list) {
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = j;
    }

    public long getLatencyMillis() {
        return this.e;
    }

    public MaxAd getLoadedAd() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.d;
    }

    public String getTestName() {
        return this.c;
    }

    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.b + ", testName=" + this.c + ", networkResponses=" + this.d + ", latencyMillis=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
