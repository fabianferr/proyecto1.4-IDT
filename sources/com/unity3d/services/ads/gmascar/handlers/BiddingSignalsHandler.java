package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import org.json.JSONException;
import org.json.JSONObject;

public class BiddingSignalsHandler implements ISignalCollectionListener {
    private final IBiddingSignalsListener listener;

    public BiddingSignalsHandler(IBiddingSignalsListener iBiddingSignalsListener) {
        this.listener = iBiddingSignalsListener;
    }

    public void onSignalsCollected(String str) {
        this.listener.onSignalsReady(getSignals(str));
    }

    public void onSignalsCollectionFailed(String str) {
        this.listener.onSignalsFailure(str);
    }

    private BiddingSignals getSignals(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new BiddingSignals(getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_RV_SIGNAL), getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_INT_SIGNAL));
        } catch (JSONException unused) {
            return null;
        }
    }

    private String getSignalFromJson(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }
}
