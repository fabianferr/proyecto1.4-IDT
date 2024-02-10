package com.startapp.sdk.adsbase.adlisteners;

import com.startapp.sdk.adsbase.Ad;

/* compiled from: Sta */
public interface AdEventListener {
    void onFailedToReceiveAd(Ad ad);

    void onReceiveAd(Ad ad);
}
