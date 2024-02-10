package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;

public class BannerSignalPlugin extends AbsFeedBackForH5 {
    private final String d = "BannerSignalPlugin";
    private c e;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof c) {
                this.e = (c) context;
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof c)) {
                this.e = (c) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", MobileAdsBridgeBase.initializeMethodName, th);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "onSignalCommunication");
            c cVar = this.e;
            if (cVar != null) {
                cVar.f(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "onSignalCommunication", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "readyStatus");
            c cVar = this.e;
            if (cVar != null) {
                cVar.c(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "readyStatus", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "init");
            c cVar = this.e;
            if (cVar != null) {
                cVar.a(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "init", th);
        }
    }

    public void click(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            c cVar = this.e;
            if (cVar != null) {
                cVar.b(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "toggleCloseBtn");
            c cVar = this.e;
            if (cVar != null) {
                cVar.d(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "triggerCloseBtn");
            c cVar = this.e;
            if (cVar != null) {
                cVar.e(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "triggerCloseBtn", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "sendImpressions");
            c cVar = this.e;
            if (cVar != null) {
                cVar.i(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "sendImpressions", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "reportUrls");
            c cVar = this.e;
            if (cVar != null) {
                cVar.k(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "reportUrls", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "increaseOfferFrequence");
            c cVar = this.e;
            if (cVar != null) {
                cVar.l(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "increaseOfferFrequence", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "resetCountdown");
            c cVar = this.e;
            if (cVar != null) {
                cVar.h(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "resetCountdown", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "handlerH5Exception");
            c cVar = this.e;
            if (cVar != null) {
                cVar.m(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "handlerH5Exception", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "install");
            c cVar = this.e;
            if (cVar != null) {
                cVar.g(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "install", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "getNetstat");
            c cVar = this.e;
            if (cVar != null) {
                cVar.o(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "getNetstat", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "openURL");
            c cVar = this.e;
            if (cVar != null) {
                cVar.n(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "openURL", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            aa.d("BannerSignalPlugin", "getFileInfo");
            c cVar = this.e;
            if (cVar != null) {
                cVar.j(obj, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalPlugin", "getFileInfo", th);
        }
    }
}
