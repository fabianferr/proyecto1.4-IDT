package com.startapp;

import android.view.View;
import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.util.List;

/* compiled from: Sta */
public class t5 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ NativeAdDetails a;

    public t5(NativeAdDetails nativeAdDetails) {
        this.a = nativeAdDetails;
    }

    public void onViewAttachedToWindow(View view) {
        View view2;
        AdDetails adDetails;
        List<VerificationDetails> b;
        NativeAdDetails nativeAdDetails = this.a;
        nativeAdDetails.getClass();
        if (!(!MetaData.k.V() || (view2 = (View) nativeAdDetails.h.get()) == null || (adDetails = nativeAdDetails.a) == null || (b = adDetails.b()) == null)) {
            b6 b6Var = new b6(view2.getContext(), b, false);
            nativeAdDetails.k = b6Var;
            if (b6Var.c()) {
                nativeAdDetails.k.a(view2);
                nativeAdDetails.k.e();
                nativeAdDetails.k.d();
                nativeAdDetails.k.b();
            }
        }
        this.a.a();
    }

    public void onViewDetachedFromWindow(View view) {
        NativeAdDetails nativeAdDetails = this.a;
        sa saVar = nativeAdDetails.g;
        if (saVar != null) {
            saVar.a();
            nativeAdDetails.g = null;
        }
        NativeAdDetails nativeAdDetails2 = this.a;
        b6 b6Var = nativeAdDetails2.k;
        if (b6Var != null) {
            b6Var.a();
            nativeAdDetails2.k = null;
        }
        view.removeOnAttachStateChangeListener(this.a.i);
    }
}
