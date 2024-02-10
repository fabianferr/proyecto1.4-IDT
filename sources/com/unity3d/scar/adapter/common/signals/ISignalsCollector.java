package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;

public interface ISignalsCollector {
    void getSCARBiddingSignals(Context context, ISignalCollectionListener iSignalCollectionListener);

    void getSCARSignal(Context context, String str, boolean z, DispatchGroup dispatchGroup, SignalsResult signalsResult);

    void getSCARSignal(Context context, boolean z, DispatchGroup dispatchGroup, SignalsResult signalsResult);

    void getSCARSignals(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener);
}
