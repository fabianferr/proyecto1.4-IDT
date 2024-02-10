package com.ironsource.mediationsdk.adunit.adapter.internal;

import android.app.Activity;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;

public interface AdapterAdFullScreenInterface<Listener extends AdapterAdListener> {
    boolean isAdAvailable(AdData adData);

    void loadAd(AdData adData, Activity activity, Listener listener);

    void showAd(AdData adData, Listener listener);
}
