package com.bytedance.sdk.openadsdk.apiImpl;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.settings.k;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: AdLoadUtils */
public class a {
    public static boolean a(PAGLoadListener pAGLoadListener) {
        if (k.a()) {
            return false;
        }
        if (pAGLoadListener == null) {
            return true;
        }
        pAGLoadListener.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
        return true;
    }

    public static void a(final h hVar, final PAGLoadListener pAGLoadListener, final AdSlot adSlot) {
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                if (!l.e()) {
                    com.bytedance.sdk.component.utils.l.e("AdLoadBaseManager", "please exec TTAdSdk.init before load ad");
                    PAGLoadListener pAGLoadListener = pAGLoadListener;
                    if (pAGLoadListener != null) {
                        pAGLoadListener.onError(10000, "Please exec TTAdSdk.init before load ad");
                        return;
                    }
                    return;
                }
                aa.d(hVar);
                c.a(adSlot);
            }
        };
        if (l.e()) {
            r0.run();
        } else {
            l.b().post(r0);
        }
    }

    public static void a(AdSlot.Builder builder, PAGRequest pAGRequest) {
        Map<String, Object> extraInfo;
        if (l.e() && pAGRequest != null && builder != null && (extraInfo = pAGRequest.getExtraInfo()) != null) {
            if (extraInfo.containsKey("ad_id") && extraInfo.get("ad_id") != null) {
                builder.setAdId(extraInfo.get("ad_id").toString());
            }
            if (extraInfo.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID) != null) {
                builder.setCreativeId(extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID).toString());
            }
            if (extraInfo.containsKey("ext") && extraInfo.get("ext") != null) {
                builder.setExt(extraInfo.get("ext").toString());
            }
            if (extraInfo.containsKey("media_extra") && extraInfo.get("media_extra") != null) {
                builder.setMediaExtra(extraInfo.get("media_extra").toString());
            }
        }
    }

    public static boolean a(String str, PAGRequest pAGRequest, PAGLoadListener pAGLoadListener) {
        if (TextUtils.isEmpty(str) && pAGLoadListener != null) {
            pAGLoadListener.onError(1, PAGErrorCode.PAGAdErrorCodeSlotIdNULLMsg);
            return true;
        } else if (pAGRequest != null || pAGLoadListener == null) {
            return false;
        } else {
            pAGLoadListener.onError(2, PAGErrorCode.PAGAdErrorCodeRequestNULLMsg);
            return true;
        }
    }
}
