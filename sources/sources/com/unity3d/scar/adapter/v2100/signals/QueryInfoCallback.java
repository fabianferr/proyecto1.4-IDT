package com.unity3d.scar.adapter.v2100.signals;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.signals.ISignalCallbackListener;

public class QueryInfoCallback extends QueryInfoGenerationCallback {
    private String _placementId;
    private ISignalCallbackListener _signalCallbackListener;

    public QueryInfoCallback(String str, ISignalCallbackListener iSignalCallbackListener) {
        this._placementId = str;
        this._signalCallbackListener = iSignalCallbackListener;
    }

    public void onSuccess(QueryInfo queryInfo) {
        this._signalCallbackListener.onSuccess(this._placementId, queryInfo.getQuery(), queryInfo);
    }

    public void onFailure(String str) {
        this._signalCallbackListener.onFailure(str);
    }
}
