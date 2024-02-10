package com.startapp.sdk.adsbase;

import com.startapp.p0;
import java.io.Serializable;

/* compiled from: Sta */
public class AutoInterstitialPreferences implements Serializable {
    private static final long serialVersionUID = -9010452850291284559L;
    private int activitiesBetweenAds;
    private int secondsBetweenAds;

    public AutoInterstitialPreferences() {
        setActivitiesBetweenAds(AdsCommonMetaData.k().f());
        setSecondsBetweenAds(AdsCommonMetaData.k().g());
    }

    public int getActivitiesBetweenAds() {
        return this.activitiesBetweenAds;
    }

    public int getSecondsBetweenAds() {
        return this.secondsBetweenAds;
    }

    public AutoInterstitialPreferences setActivitiesBetweenAds(int i) {
        if (i < 1) {
            i = 1;
        }
        this.activitiesBetweenAds = i;
        return this;
    }

    public AutoInterstitialPreferences setSecondsBetweenAds(int i) {
        if (i < 0) {
            i = 0;
        }
        this.secondsBetweenAds = i;
        return this;
    }

    public String toString() {
        StringBuilder a = p0.a("AutoInterstitialPreferences [activitiesBetweenAds=");
        a.append(this.activitiesBetweenAds);
        a.append(", secondsBetweenAds=");
        a.append(this.secondsBetweenAds);
        a.append("]");
        return a.toString();
    }
}
