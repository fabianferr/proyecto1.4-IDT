package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.mediation.a.h;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {
    private String a;
    private Map<String, Object> b;
    private Bundle c;
    private Bundle d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private String h;
    private boolean i;
    private String j;
    private String k;
    private long l;
    private MaxAdFormat m;

    private MaxAdapterParametersImpl() {
    }

    static MaxAdapterParametersImpl a(a aVar) {
        MaxAdapterParametersImpl a2 = a((f) aVar);
        a2.j = aVar.l();
        a2.k = aVar.i();
        a2.l = aVar.j();
        return a2;
    }

    static MaxAdapterParametersImpl a(f fVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.a = fVar.getAdUnitId();
        maxAdapterParametersImpl.e = fVar.Q();
        maxAdapterParametersImpl.f = fVar.R();
        maxAdapterParametersImpl.g = fVar.S();
        maxAdapterParametersImpl.h = fVar.T();
        maxAdapterParametersImpl.b = fVar.V();
        maxAdapterParametersImpl.c = fVar.W();
        maxAdapterParametersImpl.d = fVar.X();
        maxAdapterParametersImpl.i = fVar.P();
        return maxAdapterParametersImpl;
    }

    static MaxAdapterParametersImpl a(h hVar, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl a2 = a((f) hVar);
        a2.m = maxAdFormat;
        return a2;
    }

    public MaxAdFormat getAdFormat() {
        return this.m;
    }

    public String getAdUnitId() {
        return this.a;
    }

    public long getBidExpirationMillis() {
        return this.l;
    }

    public String getBidResponse() {
        return this.k;
    }

    public String getConsentString() {
        return this.h;
    }

    public Bundle getCustomParameters() {
        return this.d;
    }

    public Map<String, Object> getLocalExtraParameters() {
        return this.b;
    }

    public Bundle getServerParameters() {
        return this.c;
    }

    public String getThirdPartyAdPlacementId() {
        return this.j;
    }

    public Boolean hasUserConsent() {
        return this.e;
    }

    public Boolean isAgeRestrictedUser() {
        return this.f;
    }

    public Boolean isDoNotSell() {
        return this.g;
    }

    public boolean isTesting() {
        return this.i;
    }
}
