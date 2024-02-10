package com.unity3d.scar.adapter.v1920.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.signals.ISignalsCollector;
import com.unity3d.scar.adapter.common.signals.SignalCallbackListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.scar.adapter.common.signals.SignalsResult;
import com.unity3d.scar.adapter.common.signals.SignalsStorage;

public class SignalsCollector extends SignalsCollectorBase implements ISignalsCollector {
    private SignalsStorage<QueryInfo> _signalsStorage;

    public SignalsCollector(SignalsStorage<QueryInfo> signalsStorage) {
        this._signalsStorage = signalsStorage;
    }

    public void getSCARSignal(Context context, String str, boolean z, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        QueryInfo.generate(context, z ? AdFormat.INTERSTITIAL : AdFormat.REWARDED, new AdRequest.Builder().build(), new QueryInfoCallback(str, new SignalCallbackListener(dispatchGroup, this._signalsStorage, signalsResult)));
    }

    public void getSCARSignal(Context context, boolean z, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        onOperationNotSupported("GMA v1920 - SCAR signal retrieval required a placementId", dispatchGroup, signalsResult);
    }
}
