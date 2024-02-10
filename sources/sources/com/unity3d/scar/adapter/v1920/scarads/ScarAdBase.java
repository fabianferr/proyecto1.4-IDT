package com.unity3d.scar.adapter.v1920.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public abstract class ScarAdBase implements IScarAd {
    protected IAdsErrorHandler _adsErrorHandler;
    protected Context _context;
    protected QueryInfo _queryInfo;
    protected ScarAdMetadata _scarAdMetadata;

    /* access modifiers changed from: protected */
    public abstract void loadAdInternal(IScarLoadListener iScarLoadListener, AdRequest adRequest);

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, QueryInfo queryInfo, IAdsErrorHandler iAdsErrorHandler) {
        this._context = context;
        this._scarAdMetadata = scarAdMetadata;
        this._queryInfo = queryInfo;
        this._adsErrorHandler = iAdsErrorHandler;
    }

    public void loadAd(IScarLoadListener iScarLoadListener) {
        if (this._queryInfo != null) {
            loadAdInternal(iScarLoadListener, new AdRequest.Builder().setAdInfo(new AdInfo(this._queryInfo, this._scarAdMetadata.getAdString())).build());
            return;
        }
        this._adsErrorHandler.handleError(GMAAdsError.QueryNotFoundError(this._scarAdMetadata));
    }
}
