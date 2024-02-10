package com.vungle.ads.internal.platform;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidPlatform$$ExternalSyntheticLambda0 implements OnSuccessListener {
    public final /* synthetic */ AndroidPlatform f$0;

    public /* synthetic */ AndroidPlatform$$ExternalSyntheticLambda0(AndroidPlatform androidPlatform) {
        this.f$0 = androidPlatform;
    }

    public final void onSuccess(Object obj) {
        AndroidPlatform.m2312updateAppSetID$lambda1(this.f$0, (AppSetIdInfo) obj);
    }
}
