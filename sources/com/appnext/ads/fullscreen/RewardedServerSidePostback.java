package com.appnext.ads.fullscreen;

import com.appnext.base.a;
import java.io.Serializable;
import java.util.HashMap;

public class RewardedServerSidePostback implements Serializable {
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;

    public RewardedServerSidePostback() {
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = "";
    }

    public RewardedServerSidePostback(String str, String str2, String str3, String str4, String str5) {
        this.J = str;
        this.K = str2;
        this.L = str3;
        this.M = str4;
        this.N = str5;
    }

    public String getRewardsTransactionId() {
        return this.J;
    }

    public void setRewardsTransactionId(String str) {
        this.J = str;
    }

    public String getRewardsUserId() {
        return this.K;
    }

    public void setRewardsUserId(String str) {
        this.K = str;
    }

    public String getRewardsRewardTypeCurrency() {
        return this.L;
    }

    public void setRewardsRewardTypeCurrency(String str) {
        this.L = str;
    }

    public String getRewardsAmountRewarded() {
        return this.M;
    }

    public void setRewardsAmountRewarded(String str) {
        this.M = str;
    }

    public String getRewardsCustomParameter() {
        return this.N;
    }

    public void setRewardsCustomParameter(String str) {
        this.N = str;
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, String> n() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("rewardsTransactionId", this.J);
            hashMap.put("rewardsUserId", this.K);
            hashMap.put("rewardsRewardTypeCurrency", this.L);
            hashMap.put("rewardsAmountRewarded", this.M);
            hashMap.put("rewardsCustomParameter", this.N);
        } catch (Throwable th) {
            a.a("RewardedServerSidePostback$getParams", th);
        }
        return hashMap;
    }
}
