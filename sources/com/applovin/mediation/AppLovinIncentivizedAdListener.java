package com.applovin.mediation;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.ads.mediation.applovin.AppLovinRewardItem;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.Map;

public class AppLovinIncentivizedAdListener implements AppLovinAdRewardListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    private boolean mFullyWatched;
    private AppLovinRewardItem mRewardItem;
    private final MediationRewardedAdCallback mRewardedAdCallback;
    private final String mZoneId;

    public AppLovinIncentivizedAdListener(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationRewardedAdCallback mediationRewardedAdCallback) {
        this.mZoneId = AppLovinUtils.retrieveZoneId(mediationRewardedAdConfiguration.getServerParameters());
        this.mRewardedAdCallback = mediationRewardedAdCallback;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video displayed.");
        this.mRewardedAdCallback.onAdOpened();
        this.mRewardedAdCallback.reportAdImpression();
    }

    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video dismissed.");
        AppLovinMediationAdapter.INCENTIVIZED_ADS.remove(this.mZoneId);
        if (this.mFullyWatched) {
            this.mRewardedAdCallback.onUserEarnedReward(this.mRewardItem);
        }
        this.mRewardedAdCallback.onAdClosed();
    }

    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video clicked.");
        this.mRewardedAdCallback.reportAdClicked();
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Rewarded video playback began.");
        this.mRewardedAdCallback.onVideoStart();
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        ApplovinAdapter.log(3, "Rewarded video playback ended at playback percent: " + d + "%.");
        this.mFullyWatched = z;
        if (z) {
            this.mRewardedAdCallback.onVideoComplete();
        }
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        ApplovinAdapter.log(6, "Rewarded video validation request for ad did exceed quota with response: " + map);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        ApplovinAdapter.log(6, "Rewarded video validation request for ad failed with error code: " + i);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        ApplovinAdapter.log(6, "Rewarded video validation request was rejected with response: " + map);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        String str = map.get("currency");
        int parseDouble = (int) Double.parseDouble(map.get("amount"));
        ApplovinAdapter.log(3, "Rewarded " + parseDouble + " " + str);
        this.mRewardItem = new AppLovinRewardItem(parseDouble, str);
    }
}
