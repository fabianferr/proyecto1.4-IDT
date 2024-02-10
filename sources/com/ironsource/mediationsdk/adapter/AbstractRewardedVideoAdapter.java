package com.ironsource.mediationsdk.adapter;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J6\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0016\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006 "}, d2 = {"Lcom/ironsource/mediationsdk/adapter/AbstractRewardedVideoAdapter;", "AdNetworkAdapter", "Lcom/ironsource/mediationsdk/adapter/AbstractAdUnitAdapter;", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoAdapterInterface;", "adapter", "(Ljava/lang/Object;)V", "collectRewardedVideoBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "getRewardedVideoBiddingData", "", "", "", "initAndLoadRewardedVideo", "appKey", "userId", "listener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "initRewardedVideoForDemandOnly", "initRewardedVideoWithCallback", "isRewardedVideoAvailable", "", "loadRewardedVideo", "loadRewardedVideoForBidding", "serverData", "loadRewardedVideoForDemandOnly", "loadRewardedVideoForDemandOnlyForBidding", "showRewardedVideo", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractRewardedVideoAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements RewardedVideoAdapterInterface {
    public AbstractRewardedVideoAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> rewardedVideoBiddingData = getRewardedVideoBiddingData(jSONObject, jSONObject2);
        if (rewardedVideoBiddingData != null) {
            biddingDataCallback.onSuccess(rewardedVideoBiddingData);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        return null;
    }

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        return false;
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(rewardedVideoSmashListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }
}
