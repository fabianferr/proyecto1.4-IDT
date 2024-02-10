package com.mbridge.msdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.OnCompletionListener;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public interface MBridgeSDK {

    public enum PLUGIN_LOAD_STATUS {
        INITIAL,
        INCOMPLETED,
        COMPLETED
    }

    boolean getConsentStatus(Context context);

    Map<String, String> getMBConfigurationMap(String str, String str2);

    Map<String, String> getMBConfigurationMap(String str, String str2, String str3);

    Map<String, String> getMBConfigurationMap(String str, String str2, String str3, boolean z);

    Map<String, String> getMBConfigurationMap(String str, String str2, boolean z);

    PLUGIN_LOAD_STATUS getStatus();

    void init(Map<String, String> map, Application application);

    void init(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener);

    void init(Map<String, String> map, Context context);

    void init(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener);

    void initAsync(Map<String, String> map, Application application);

    void initAsync(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener);

    void initAsync(Map<String, String> map, Context context);

    void initAsync(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener);

    void preload(Map<String, Object> map);

    void preloadFrame(Map<String, Object> map);

    void release();

    void setAllowAcquireIds(boolean z);

    void setAllowTransferIdsIfLimit(boolean z);

    void setConsentStatus(Context context);

    void setConsentStatus(Context context, int i);

    void setConsentStatus(Context context, OnCompletionListener onCompletionListener);

    void setCoppaStatus(Context context, boolean z);

    void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo);

    void setDoNotTrackStatus(Context context, boolean z);

    void setDoNotTrackStatus(boolean z);

    void setThirdPartyFeatures(Map<String, Object> map);

    void setUserPrivateInfoType(Context context, String str, int i);

    void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper);

    void updateDialogWeakActivity(WeakReference<Activity> weakReference);

    AuthorityInfoBean userPrivateInfo(Context context);
}
