package com.startapp.sdk.ads.video;

import android.app.Activity;
import android.content.Context;
import com.startapp.k9;
import com.startapp.r6;
import com.startapp.sdk.ads.video.VideoUtil;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.common.utils.Pair;
import java.util.Map;

/* compiled from: Sta */
public class a extends GetAdRequest {
    public GetAdRequest.VideoRequestType U0;
    public GetAdRequest.VideoRequestMode V0 = GetAdRequest.VideoRequestMode.INTERSTITIAL;

    public void a(Context context, AdPreferences adPreferences, AdPreferences.Placement placement, Pair<String, String> pair) {
        super.a(context, adPreferences, placement, pair);
        Ad.AdType adType = this.T0;
        if (adType != null) {
            if (adType == Ad.AdType.NON_VIDEO) {
                this.U0 = GetAdRequest.VideoRequestType.DISABLED;
            } else if (adType == Ad.AdType.VIDEO_NO_VAST) {
                this.U0 = GetAdRequest.VideoRequestType.FORCED_NONVAST;
            } else if (b()) {
                this.U0 = GetAdRequest.VideoRequestType.FORCED;
            }
        } else if (VideoUtil.a(context) == VideoUtil.VideoEligibility.ELIGIBLE) {
            Map<Activity, Integer> map = k9.a;
            this.U0 = GetAdRequest.VideoRequestType.ENABLED;
        } else {
            this.U0 = GetAdRequest.VideoRequestType.DISABLED;
        }
        Ad.AdType adType2 = this.T0;
        if (adType2 == Ad.AdType.REWARDED_VIDEO) {
            this.V0 = GetAdRequest.VideoRequestMode.REWARDED;
        }
        if (adType2 == Ad.AdType.VIDEO) {
            this.V0 = GetAdRequest.VideoRequestMode.INTERSTITIAL;
        }
    }

    public void a(r6 r6Var) throws SDKException {
        super.a(r6Var);
        r6Var.a("video", (Object) this.U0, false, true);
        r6Var.a("videoMode", (Object) this.V0, false, true);
    }
}
