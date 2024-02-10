package com.ironsource.mediationsdk.bidding;

import java.util.Map;

public interface BiddingDataCallback {
    void onFailure(String str);

    void onSuccess(Map<String, Object> map);
}
