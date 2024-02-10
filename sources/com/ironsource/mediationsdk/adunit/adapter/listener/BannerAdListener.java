package com.ironsource.mediationsdk.adunit.adapter.listener;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;

public interface BannerAdListener extends AdapterAdViewListener {
    void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams);
}
