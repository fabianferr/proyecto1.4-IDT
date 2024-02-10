package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import java.util.Map;
import org.json.JSONObject;

public interface BannerAdapterInterface extends AdUnitAdapterInterface {
    void collectBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback);

    void destroyBanner(JSONObject jSONObject);

    Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2);

    void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener);

    void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener);

    void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener);

    void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener);

    void loadBannerForDemandOnlyForBidding(JSONObject jSONObject, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener bannerSmashListener);
}
