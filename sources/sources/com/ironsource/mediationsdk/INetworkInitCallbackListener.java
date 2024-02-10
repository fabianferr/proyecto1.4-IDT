package com.ironsource.mediationsdk;

public interface INetworkInitCallbackListener {
    void onNetworkInitCallbackFailed(String str);

    void onNetworkInitCallbackSuccess();
}
