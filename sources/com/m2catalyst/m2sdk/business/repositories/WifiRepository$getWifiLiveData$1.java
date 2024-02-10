package com.m2catalyst.m2sdk.business.repositories;

import androidx.lifecycle.MutableLiveData;
import com.m2catalyst.m2sdk.business.models.Wifi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WifiRepository.kt */
public /* synthetic */ class WifiRepository$getWifiLiveData$1 extends FunctionReferenceImpl implements Function0<MutableLiveData<Wifi>> {
    public WifiRepository$getWifiLiveData$1(Object obj) {
        super(0, obj, WifiRepository.class, "getWifiLiveData", "getWifiLiveData()Landroidx/lifecycle/MutableLiveData;", 0);
    }

    public final MutableLiveData<Wifi> invoke() {
        return ((WifiRepository) this.receiver).getWifiLiveData();
    }
}
