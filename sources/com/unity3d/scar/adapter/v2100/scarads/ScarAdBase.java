package com.unity3d.scar.adapter.v2100.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public abstract class ScarAdBase<T> implements IScarAd {
    protected T _adObj;
    protected AdRequestFactory _adRequestFactory;
    protected IAdsErrorHandler _adsErrorHandler;
    protected Context _context;
    protected ScarAdListener _scarAdListener;
    protected ScarAdMetadata _scarAdMetadata;

    /* access modifiers changed from: protected */
    public abstract void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener);

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, AdRequestFactory adRequestFactory, IAdsErrorHandler iAdsErrorHandler) {
        this._context = context;
        this._scarAdMetadata = scarAdMetadata;
        this._adRequestFactory = adRequestFactory;
        this._adsErrorHandler = iAdsErrorHandler;
    }

    public void setGmaAd(T t) {
        this._adObj = t;
    }

    public void loadAd(IScarLoadListener iScarLoadListener) {
        AdRequest buildAdRequestWithAdString = this._adRequestFactory.buildAdRequestWithAdString(this._scarAdMetadata.getAdString());
        this._scarAdListener.setLoadListener(iScarLoadListener);
        loadAdInternal(buildAdRequestWithAdString, iScarLoadListener);
    }
}
