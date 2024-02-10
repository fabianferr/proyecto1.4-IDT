package com.mbridge.msdk.videocommon.listener;

import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public interface InterVideoOutListener {
    void onAdClose(String str, MBridgeIds mBridgeIds, RewardInfo rewardInfo);

    void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo);

    void onAdShow(String str, MBridgeIds mBridgeIds);

    void onEndcardShow(MBridgeIds mBridgeIds);

    void onLoadSuccess(String str, MBridgeIds mBridgeIds);

    void onShowFail(String str, MBridgeIds mBridgeIds, String str2);

    void onVideoAdClicked(boolean z, MBridgeIds mBridgeIds);

    void onVideoComplete(MBridgeIds mBridgeIds);

    void onVideoLoadFail(MBridgeIds mBridgeIds, String str);

    void onVideoLoadSuccess(MBridgeIds mBridgeIds);
}
