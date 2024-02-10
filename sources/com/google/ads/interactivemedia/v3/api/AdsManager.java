package com.google.ads.interactivemedia.v3.api;

import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public interface AdsManager extends BaseManager {
    void clicked();

    void discardAdBreak();

    List<Float> getAdCuePoints();

    void pause();

    @Deprecated
    void requestNextAdBreak();

    void resume();

    void skip();

    void start();
}
