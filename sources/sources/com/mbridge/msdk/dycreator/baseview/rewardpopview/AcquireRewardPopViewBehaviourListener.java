package com.mbridge.msdk.dycreator.baseview.rewardpopview;

public interface AcquireRewardPopViewBehaviourListener {
    void onOutOfContentClicked(float f, float f2);

    void onReceivedFail(String str);

    void onReceivedSuccess(int i);
}
