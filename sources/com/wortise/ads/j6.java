package com.wortise.ads;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/j6;", "", "", "id", "I", "b", "()I", "<init>", "(Ljava/lang/String;II)V", "STORE_INFORMATION", "SELECT_BASIC_ADS", "CREATE_PERSONALISED_ADS", "SELECT_PERSONALISED_ADS", "CREATE_PERSONALISED_CONTENT", "SELECT_PERSONALISED_CONTENT", "MEASURE_AD_PERFORMANCE", "MEASURE_CONTENT_PERFORMANCE", "MARKET_RESEARCH", "DEVELOP_AND_IMPROVE_PRODUCTS", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: TcfPurpose.kt */
public enum j6 {
    STORE_INFORMATION(1),
    SELECT_BASIC_ADS(2),
    CREATE_PERSONALISED_ADS(3),
    SELECT_PERSONALISED_ADS(4),
    CREATE_PERSONALISED_CONTENT(5),
    SELECT_PERSONALISED_CONTENT(6),
    MEASURE_AD_PERFORMANCE(7),
    MEASURE_CONTENT_PERFORMANCE(8),
    MARKET_RESEARCH(9),
    DEVELOP_AND_IMPROVE_PRODUCTS(10);
    
    private final int a;

    private j6(int i) {
        this.a = i;
    }

    public final int b() {
        return this.a;
    }
}
