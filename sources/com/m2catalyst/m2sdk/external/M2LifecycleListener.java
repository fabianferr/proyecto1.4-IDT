package com.m2catalyst.m2sdk.external;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/m2catalyst/m2sdk/external/M2LifecycleListener;", "Lcom/m2catalyst/m2sdk/external/M2Listener;", "onSDKCollectionStarted", "", "onSDKCollectionStopped", "onSDKInitialized", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: M2Listener.kt */
public interface M2LifecycleListener extends M2Listener {
    void onSDKCollectionStarted();

    void onSDKCollectionStopped();

    void onSDKInitialized();
}
