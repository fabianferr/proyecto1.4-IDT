package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;
import java.util.Map;
import org.json.JSONObject;

public abstract class SignalsCollectorBase implements ISignalsCollector {
    public static final String SCAR_INT_SIGNAL = "gmaScarBiddingInterstitialSignal";
    public static final String SCAR_RV_SIGNAL = "gmaScarBiddingRewardedSignal";

    public void getSCARSignals(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        for (String sCARSignal : strArr) {
            dispatchGroup.enter();
            getSCARSignal(context, sCARSignal, true, dispatchGroup, signalsResult);
        }
        for (String sCARSignal2 : strArr2) {
            dispatchGroup.enter();
            getSCARSignal(context, sCARSignal2, false, dispatchGroup, signalsResult);
        }
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void getSCARBiddingSignals(Context context, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        dispatchGroup.enter();
        getSCARSignal(context, true, dispatchGroup, signalsResult);
        dispatchGroup.enter();
        getSCARSignal(context, false, dispatchGroup, signalsResult);
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void onOperationNotSupported(String str, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        signalsResult.setErrorMessage(String.format("Operation Not supported: %s.", new Object[]{str}));
        dispatchGroup.leave();
    }

    private class GMAScarDispatchCompleted implements Runnable {
        private ISignalCollectionListener _signalListener;
        private SignalsResult _signalsResult;

        public GMAScarDispatchCompleted(ISignalCollectionListener iSignalCollectionListener, SignalsResult signalsResult) {
            this._signalListener = iSignalCollectionListener;
            this._signalsResult = signalsResult;
        }

        public void run() {
            Map<String, String> signalsMap = this._signalsResult.getSignalsMap();
            if (signalsMap.size() > 0) {
                this._signalListener.onSignalsCollected(new JSONObject(signalsMap).toString());
            } else if (this._signalsResult.getErrorMessage() == null) {
                this._signalListener.onSignalsCollected("");
            } else {
                this._signalListener.onSignalsCollectionFailed(this._signalsResult.getErrorMessage());
            }
        }
    }
}
