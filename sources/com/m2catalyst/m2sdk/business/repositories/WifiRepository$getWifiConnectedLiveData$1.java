package com.m2catalyst.m2sdk.business.repositories;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WifiRepository.kt */
public /* synthetic */ class WifiRepository$getWifiConnectedLiveData$1 extends FunctionReferenceImpl implements Function0<MutableLiveData<Boolean>> {
    public WifiRepository$getWifiConnectedLiveData$1(Object obj) {
        super(0, obj, WifiRepository.class, "getWifiConnectedLiveData", "getWifiConnectedLiveData()Landroidx/lifecycle/MutableLiveData;", 0);
    }

    public final MutableLiveData<Boolean> invoke() {
        return ((WifiRepository) this.receiver).getWifiConnectedLiveData();
    }
}
