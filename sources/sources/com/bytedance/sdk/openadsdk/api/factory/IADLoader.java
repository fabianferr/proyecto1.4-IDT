package com.bytedance.sdk.openadsdk.api.factory;

import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.common.b;

public interface IADLoader<R extends PAGRequest, L extends b> {
    void loadAd(String str, R r, L l);
}
