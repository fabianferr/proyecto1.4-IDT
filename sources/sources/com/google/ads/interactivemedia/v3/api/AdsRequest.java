package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public interface AdsRequest extends BaseRequest {
    String getAdTagUrl();

    String getAdsResponse();

    ContentProgressProvider getContentProgressProvider();

    String getExtraParameter(String str);

    Map<String, String> getExtraParameters();

    void setAdTagUrl(String str);

    void setAdWillAutoPlay(boolean z);

    void setAdWillPlayMuted(boolean z);

    void setAdsResponse(String str);

    void setContentDuration(float f);

    void setContentKeywords(List<String> list);

    void setContentProgressProvider(ContentProgressProvider contentProgressProvider);

    void setContentTitle(String str);

    void setContinuousPlayback(boolean z);

    void setExtraParameter(String str, String str2);

    void setLiveStreamPrefetchSeconds(float f);

    void setVastLoadTimeout(float f);
}