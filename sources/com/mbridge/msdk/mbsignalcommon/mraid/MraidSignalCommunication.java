package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.appnext.core.Ad;
import com.facebook.internal.ServerProtocol;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONObject;

public class MraidSignalCommunication extends AbsFeedBackForH5 {
    private b d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.d = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.d = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() != null && (windVaneWebView.getMraidObject() instanceof b)) {
                this.d = (b) windVaneWebView.getMraidObject();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof a) {
            a aVar = (a) obj;
            windVaneWebView = aVar.a;
            a.C0149a.a.a((WebView) aVar.a, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            aa.d("MraidSignalCommunication", "MRAID Open " + optString);
            if (this.d != null && !TextUtils.isEmpty(optString)) {
                if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= ((long) com.mbridge.msdk.click.b.a.c) || !com.mbridge.msdk.click.b.a.a(this.d.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.a)) {
                    this.d.open(optString);
                }
            }
        } catch (Throwable th) {
            aa.b("MraidSignalCommunication", "MRAID Open", th);
        }
    }

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0149a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "close");
        }
        try {
            aa.d("MraidSignalCommunication", "MRAID close");
            b bVar = this.d;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th) {
            aa.b("MraidSignalCommunication", "MRAID close", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0149a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "unload");
        }
        try {
            aa.d("MraidSignalCommunication", "MRAID unload");
            b bVar = this.d;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th) {
            aa.b("MraidSignalCommunication", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0149a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            aa.d("MraidSignalCommunication", "MRAID useCustomClose " + optString);
            if (!TextUtils.isEmpty(optString) && this.d != null) {
                this.d.useCustomClose(optString.toLowerCase().equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            }
        } catch (Throwable th) {
            aa.b("MraidSignalCommunication", "MRAID useCustomClose", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0149a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            aa.d("MraidSignalCommunication", "MRAID expand " + optString + " " + optString2);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && this.d != null) {
                this.d.expand(optString, optString2.toLowerCase().equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            }
        } catch (Throwable th) {
            aa.b("MraidSignalCommunication", "MRAID expand", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0149a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, MRAIDPresenter.SET_ORIENTATION_PROPERTIES);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            aa.d("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && this.d != null) {
                optString.toLowerCase().equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                String lowerCase = optString2.toLowerCase();
                int hashCode = lowerCase.hashCode();
                if (hashCode == 729267099) {
                    str2 = Ad.ORIENTATION_PORTRAIT;
                } else if (hashCode == 1430647483) {
                    str2 = Ad.ORIENTATION_LANDSCAPE;
                } else {
                    return;
                }
                lowerCase.equals(str2);
            }
        } catch (Throwable th) {
            aa.b("MraidSignalCommunication", "MRAID setOrientationProperties", th);
        }
    }
}
