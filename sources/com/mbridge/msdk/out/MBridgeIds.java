package com.mbridge.msdk.out;

import android.text.TextUtils;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

public class MBridgeIds implements NoProGuard, Serializable {
    private String bidToken = "";
    private boolean isCache = false;
    private String localRequestId;
    private String placementId;
    private String unitId;

    public MBridgeIds() {
    }

    public MBridgeIds(String str, String str2) {
        this.placementId = str;
        this.unitId = str2;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setCache(boolean z) {
        this.isCache = z;
    }

    public String getBidToken() {
        if (TextUtils.isEmpty(this.bidToken)) {
            this.bidToken = "";
        }
        return this.bidToken;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
    }

    public String toString() {
        return "MBridgeIds{placementId='" + this.placementId + "', unitId='" + this.unitId + "', bidToken='" + this.bidToken + "', localRequestId='" + this.localRequestId + "'}";
    }
}
