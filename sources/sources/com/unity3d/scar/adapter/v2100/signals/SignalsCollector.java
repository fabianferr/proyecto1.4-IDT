package com.unity3d.scar.adapter.v2100.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.signals.ISignalsCollector;
import com.unity3d.scar.adapter.common.signals.SignalCallbackListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.scar.adapter.common.signals.SignalsResult;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public class SignalsCollector extends SignalsCollectorBase implements ISignalsCollector {
    private AdRequestFactory _adRequestFactory;

    public SignalsCollector(AdRequestFactory adRequestFactory) {
        this._adRequestFactory = adRequestFactory;
    }

    public void getSCARSignal(Context context, String str, boolean z, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        QueryInfo.generate(context, z ? AdFormat.INTERSTITIAL : AdFormat.REWARDED, this._adRequestFactory.buildAdRequest(), new QueryInfoCallback(str, new SignalCallbackListener(dispatchGroup, signalsResult)));
    }

    public void getSCARSignal(Context context, boolean z, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        getSCARSignal(context, z ? SignalsCollectorBase.SCAR_INT_SIGNAL : SignalsCollectorBase.SCAR_RV_SIGNAL, z, dispatchGroup, signalsResult);
    }
}
