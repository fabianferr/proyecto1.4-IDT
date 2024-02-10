package com.vungle.ads.internal.presenter;

import android.util.Log;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/vungle/ads/internal/presenter/MRAIDPresenter$processCommand$6$1", "Lcom/vungle/ads/internal/network/Callback;", "Ljava/lang/Void;", "onFailure", "", "call", "Lcom/vungle/ads/internal/network/Call;", "t", "", "onResponse", "response", "Lcom/vungle/ads/internal/network/Response;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDPresenter.kt */
public final class MRAIDPresenter$processCommand$6$1 implements Callback<Void> {
    MRAIDPresenter$processCommand$6$1() {
    }

    public void onResponse(Call<Void> call, Response<Void> response) {
        Log.d("MRAIDPresenter", "send RI success");
    }

    public void onFailure(Call<Void> call, Throwable th) {
        Log.d("MRAIDPresenter", "send RI Failure");
    }
}
