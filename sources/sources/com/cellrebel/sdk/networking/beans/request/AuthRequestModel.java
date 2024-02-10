package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.utils.Utils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequestModel {
    @SerializedName("appId")
    @Expose
    public String appId;
    @SerializedName("appKey")
    @Expose
    private final String appKey = Utils.a();
    @SerializedName("sdkClientKey")
    @Expose
    public String clientKey;
    @SerializedName("deviceBrand")
    @Expose
    public String deviceBrand;
    @SerializedName("deviceModel")
    @Expose
    public String deviceModel;
    @SerializedName("deviceVersion")
    @Expose
    public String deviceVersion;
    @SerializedName("mobileClientId")
    @Expose
    public String mobileClientId;
    @SerializedName("networkMcc")
    @Expose
    public String networkMcc;
    @SerializedName("os")
    @Expose
    public String os;
    @SerializedName("sdkOrigin")
    @Expose
    public String sdkOrigin = Utils.b();
    @SerializedName("tac")
    @Expose
    public String tac;
    @SerializedName("token")
    @Expose
    public String token = "";

    public AuthRequestModel appId(String str) {
        this.appId = str;
        return this;
    }

    public String appId() {
        return this.appId;
    }

    public String appKey() {
        return this.appKey;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof AuthRequestModel;
    }

    public AuthRequestModel clientKey(String str) {
        this.clientKey = str;
        return this;
    }

    public String clientKey() {
        return this.clientKey;
    }

    public AuthRequestModel deviceBrand(String str) {
        this.deviceBrand = str;
        return this;
    }

    public String deviceBrand() {
        return this.deviceBrand;
    }

    public AuthRequestModel deviceModel(String str) {
        this.deviceModel = str;
        return this;
    }

    public String deviceModel() {
        return this.deviceModel;
    }

    public AuthRequestModel deviceVersion(String str) {
        this.deviceVersion = str;
        return this;
    }

    public String deviceVersion() {
        return this.deviceVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthRequestModel)) {
            return false;
        }
        AuthRequestModel authRequestModel = (AuthRequestModel) obj;
        if (!authRequestModel.canEqual(this)) {
            return false;
        }
        String mobileClientId2 = mobileClientId();
        String mobileClientId3 = authRequestModel.mobileClientId();
        if (mobileClientId2 != null ? !mobileClientId2.equals(mobileClientId3) : mobileClientId3 != null) {
            return false;
        }
        String clientKey2 = clientKey();
        String clientKey3 = authRequestModel.clientKey();
        if (clientKey2 != null ? !clientKey2.equals(clientKey3) : clientKey3 != null) {
            return false;
        }
        String os2 = os();
        String os3 = authRequestModel.os();
        if (os2 != null ? !os2.equals(os3) : os3 != null) {
            return false;
        }
        String deviceBrand2 = deviceBrand();
        String deviceBrand3 = authRequestModel.deviceBrand();
        if (deviceBrand2 != null ? !deviceBrand2.equals(deviceBrand3) : deviceBrand3 != null) {
            return false;
        }
        String deviceModel2 = deviceModel();
        String deviceModel3 = authRequestModel.deviceModel();
        if (deviceModel2 != null ? !deviceModel2.equals(deviceModel3) : deviceModel3 != null) {
            return false;
        }
        String deviceVersion2 = deviceVersion();
        String deviceVersion3 = authRequestModel.deviceVersion();
        if (deviceVersion2 != null ? !deviceVersion2.equals(deviceVersion3) : deviceVersion3 != null) {
            return false;
        }
        String str = token();
        String str2 = authRequestModel.token();
        if (str != null ? !str.equals(str2) : str2 != null) {
            return false;
        }
        String sdkOrigin2 = sdkOrigin();
        String sdkOrigin3 = authRequestModel.sdkOrigin();
        if (sdkOrigin2 != null ? !sdkOrigin2.equals(sdkOrigin3) : sdkOrigin3 != null) {
            return false;
        }
        String appKey2 = appKey();
        String appKey3 = authRequestModel.appKey();
        if (appKey2 != null ? !appKey2.equals(appKey3) : appKey3 != null) {
            return false;
        }
        String networkMcc2 = networkMcc();
        String networkMcc3 = authRequestModel.networkMcc();
        if (networkMcc2 != null ? !networkMcc2.equals(networkMcc3) : networkMcc3 != null) {
            return false;
        }
        String appId2 = appId();
        String appId3 = authRequestModel.appId();
        if (appId2 != null ? !appId2.equals(appId3) : appId3 != null) {
            return false;
        }
        String tac2 = tac();
        String tac3 = authRequestModel.tac();
        return tac2 != null ? tac2.equals(tac3) : tac3 == null;
    }

    public int hashCode() {
        String mobileClientId2 = mobileClientId();
        int i = 43;
        int hashCode = mobileClientId2 == null ? 43 : mobileClientId2.hashCode();
        String clientKey2 = clientKey();
        int hashCode2 = ((hashCode + 59) * 59) + (clientKey2 == null ? 43 : clientKey2.hashCode());
        String os2 = os();
        int hashCode3 = (hashCode2 * 59) + (os2 == null ? 43 : os2.hashCode());
        String deviceBrand2 = deviceBrand();
        int hashCode4 = (hashCode3 * 59) + (deviceBrand2 == null ? 43 : deviceBrand2.hashCode());
        String deviceModel2 = deviceModel();
        int hashCode5 = (hashCode4 * 59) + (deviceModel2 == null ? 43 : deviceModel2.hashCode());
        String deviceVersion2 = deviceVersion();
        int hashCode6 = (hashCode5 * 59) + (deviceVersion2 == null ? 43 : deviceVersion2.hashCode());
        String str = token();
        int hashCode7 = (hashCode6 * 59) + (str == null ? 43 : str.hashCode());
        String sdkOrigin2 = sdkOrigin();
        int hashCode8 = (hashCode7 * 59) + (sdkOrigin2 == null ? 43 : sdkOrigin2.hashCode());
        String appKey2 = appKey();
        int hashCode9 = (hashCode8 * 59) + (appKey2 == null ? 43 : appKey2.hashCode());
        String networkMcc2 = networkMcc();
        int hashCode10 = (hashCode9 * 59) + (networkMcc2 == null ? 43 : networkMcc2.hashCode());
        String appId2 = appId();
        int hashCode11 = (hashCode10 * 59) + (appId2 == null ? 43 : appId2.hashCode());
        String tac2 = tac();
        int i2 = hashCode11 * 59;
        if (tac2 != null) {
            i = tac2.hashCode();
        }
        return i2 + i;
    }

    public AuthRequestModel mobileClientId(String str) {
        this.mobileClientId = str;
        return this;
    }

    public String mobileClientId() {
        return this.mobileClientId;
    }

    public AuthRequestModel networkMcc(String str) {
        this.networkMcc = str;
        return this;
    }

    public String networkMcc() {
        return this.networkMcc;
    }

    public AuthRequestModel os(String str) {
        this.os = str;
        return this;
    }

    public String os() {
        return this.os;
    }

    public AuthRequestModel sdkOrigin(String str) {
        this.sdkOrigin = str;
        return this;
    }

    public String sdkOrigin() {
        return this.sdkOrigin;
    }

    public AuthRequestModel tac(String str) {
        this.tac = str;
        return this;
    }

    public String tac() {
        return this.tac;
    }

    public String toString() {
        return "AuthRequestModel(mobileClientId=" + mobileClientId() + ", clientKey=" + clientKey() + ", os=" + os() + ", deviceBrand=" + deviceBrand() + ", deviceModel=" + deviceModel() + ", deviceVersion=" + deviceVersion() + ", token=" + token() + ", sdkOrigin=" + sdkOrigin() + ", appKey=" + appKey() + ", networkMcc=" + networkMcc() + ", appId=" + appId() + ", tac=" + tac() + ")";
    }

    public AuthRequestModel token(String str) {
        this.token = str;
        return this;
    }

    public String token() {
        return this.token;
    }
}
