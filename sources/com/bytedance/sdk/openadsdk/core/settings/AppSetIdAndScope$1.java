package com.bytedance.sdk.openadsdk.core.settings;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

class AppSetIdAndScope$1 implements OnSuccessListener<AppSetIdInfo> {
    AppSetIdAndScope$1() {
    }

    public void onSuccess(AppSetIdInfo appSetIdInfo) {
        String unused = c.a = Integer.toString(appSetIdInfo.getScope());
        String unused2 = c.b = appSetIdInfo.getId();
        int unused3 = c.d = 1;
    }
}
