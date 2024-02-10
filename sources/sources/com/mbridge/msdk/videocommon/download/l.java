package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardVideoRefactorManager */
public final class l {
    private AtomicBoolean a;
    private AtomicBoolean b;

    /* compiled from: RewardVideoRefactorManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static final l a = new l();
    }

    private l() {
    }

    public static l a() {
        return a.a;
    }

    public final boolean a(int i) {
        if (MBridgeConstans.DEBUG) {
            aa.b("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i != 94 && i != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.a = new AtomicBoolean(ac.a().a("r_v_r_f_l", false));
        } catch (Exception e) {
            this.a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e.getMessage());
            }
        }
        return this.a.get();
    }

    public final boolean b(int i) {
        if (MBridgeConstans.DEBUG) {
            aa.b("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i != 94 && i != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.b = new AtomicBoolean(ac.a().a("r_v_r_f_c_r", false));
        } catch (Exception e) {
            this.b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e.getMessage());
            }
        }
        return this.b.get();
    }

    public final int a(String str, int i) {
        try {
            return ac.a().a(str, i);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoRefactorManager", "getRewardVideoCampaignRequestTimeout error: " + e.getMessage());
            }
            return i;
        }
    }
}
