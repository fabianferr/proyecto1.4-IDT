package com.mbridge.msdk.video.signal.communication;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.i;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseVideoCommunication extends AbsFeedBackForH5 implements IVideoCommunication {
    protected IJSFactory d;
    private FastKV e = null;

    private String a(int i) {
        switch (i) {
            case 1:
                return "sdk_info";
            case 2:
                return MBridgeConstans.PROPERTIES_UNIT_ID;
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return "device";
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    public void reportData(Object obj, String str) {
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.d = (IJSFactory) obj;
        }
    }

    public void init(Object obj, String str) {
        Object obj2 = obj;
        String str2 = str;
        aa.b("JS-Video-Brigde", "init");
        try {
            IJSFactory iJSFactory = this.d;
            int i = 1;
            if (iJSFactory != null) {
                String c = iJSFactory.getJSCommon().c();
                if (!TextUtils.isEmpty(c)) {
                    c = Base64.encodeToString(c.getBytes(), 2);
                }
                g.a().a(obj2, c);
                this.d.getJSCommon().b(true);
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("showTransparent");
                    int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                    int optInt3 = jSONObject.optInt("closeType");
                    int optInt4 = jSONObject.optInt("orientationType");
                    int optInt5 = jSONObject.optInt("webfront");
                    int optInt6 = jSONObject.optInt("showAlertRole");
                    this.d.getJSCommon().a(optInt == 1);
                    this.d.getJSCommon().b(optInt2);
                    this.d.getJSCommon().c(optInt3);
                    this.d.getJSCommon().d(optInt4);
                    this.d.getJSCommon().e(optInt5);
                    c jSCommon = this.d.getJSCommon();
                    if (optInt6 != 0) {
                        i = optInt6;
                    }
                    jSCommon.h(i);
                }
            } else if (obj2 != null) {
                a aVar = (a) obj2;
                if (aVar.a.getObject() instanceof j) {
                    j jVar = (j) aVar.a.getObject();
                    String c2 = jVar.c();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        int optInt7 = jSONObject2.optInt("showTransparent");
                        int optInt8 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                        int optInt9 = jSONObject2.optInt("closeType");
                        int optInt10 = jSONObject2.optInt("orientationType");
                        int optInt11 = jSONObject2.optInt("webfront");
                        int optInt12 = jSONObject2.optInt("showAlertRole");
                        jVar.a(optInt7 == 1);
                        jVar.b(optInt8);
                        jVar.c(optInt9);
                        jVar.d(optInt10);
                        jVar.e(optInt11);
                        if (optInt12 != 0) {
                            i = optInt12;
                        }
                        jVar.h(i);
                        aa.b("JS-Video-Brigde", "init jsCommon.setIsShowingTransparent = " + optInt7);
                    }
                    g.a().a(obj2, Base64.encodeToString(c2.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "init error", th);
        }
    }

    public void click(Object obj, String str) {
        int i;
        String str2;
        j jVar;
        aa.b("JS-Video-Brigde", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.optInt("type");
                str2 = jSONObject.optString("pt");
                IJSFactory iJSFactory = this.d;
                if (iJSFactory != null) {
                    iJSFactory.getJSCommon().click(i, str2);
                } else if (obj != null) {
                    a aVar = (a) obj;
                    if ((aVar.a.getObject() instanceof j) && (jVar = (j) aVar.a.getObject()) != null) {
                        jVar.click(i, str2);
                    }
                }
            }
        } catch (JSONException e2) {
            str2 = "";
            e2.printStackTrace();
            i = 1;
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "click error", th);
        }
    }

    public void statistics(Object obj, String str) {
        aa.b("JS-Video-Brigde", "statistics,params:" + str);
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.d.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString("data"));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "statistics error", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        aa.b("JS-Video-Brigde", "triggerCloseBtn");
        try {
            if (this.d != null && !TextUtils.isEmpty(str) && new JSONObject(str).optString("state").equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                this.d.getJSVideoModule().closeVideoOperate(1, -1);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "triggerCloseBtn error", th);
        }
    }

    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("margin_top", 0);
                int optInt2 = jSONObject.optInt("margin_left", 0);
                int optInt3 = jSONObject.optInt("view_width", 0);
                int optInt4 = jSONObject.optInt("view_height", 0);
                int optInt5 = jSONObject.optInt("radius", 0);
                int optInt6 = jSONObject.optInt("border_top", 0);
                int optInt7 = jSONObject.optInt("border_left", 0);
                int optInt8 = jSONObject.optInt("border_width", 0);
                int optInt9 = jSONObject.optInt("border_height", 0);
                aa.b("JS-Video-Brigde", "showVideoLocation,margin_top:" + optInt + ",marginLeft:" + optInt2 + ",viewWidth:" + optInt3 + ",viewHeight:" + optInt4 + ",radius:" + optInt5 + ",borderTop: " + optInt6 + ",borderLeft: " + optInt7 + ",borderWidth: " + optInt8 + ",borderHeight: " + optInt9);
                this.d.getJSVideoModule().showVideoLocation(optInt, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optInt9);
                this.d.getJSCommon().f();
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showVideoLocation error", th);
        }
    }

    public void soundOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                int optInt2 = jSONObject.optInt("view_visible");
                String optString = jSONObject.optString("pt", "");
                aa.b("JS-Video-Brigde", "soundOperate,mute:" + optInt + ",viewVisible:" + optInt2 + ",pt:" + optString);
                if (TextUtils.isEmpty(optString)) {
                    this.d.getJSVideoModule().soundOperate(optInt, optInt2);
                } else {
                    this.d.getJSVideoModule().soundOperate(optInt, optInt2, optString);
                }
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "soundOperate error", th);
        }
    }

    public void videoOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("pause_or_resume");
                aa.b("JS-Video-Brigde", "videoOperate,pauseOrResume:" + optInt);
                this.d.getJSVideoModule().videoOperate(optInt);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "videoOperate error", th);
        }
    }

    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("close");
                int optInt2 = jSONObject.optInt("view_visible");
                aa.b("JS-Video-Brigde", "closeVideoOperte,close:" + optInt + ",viewVisible:" + optInt2);
                this.d.getJSVideoModule().closeVideoOperate(optInt, optInt2);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "closeOperte error", th);
        }
    }

    public void progressOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("progress");
                int optInt2 = jSONObject.optInt("view_visible");
                aa.b("JS-Video-Brigde", "progressOperate,progress:" + optInt + ",viewVisible:" + optInt2);
                this.d.getJSVideoModule().progressOperate(optInt, optInt2);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    public void getCurrentProgress(Object obj, String str) {
        try {
            IJSFactory iJSFactory = this.d;
            if (iJSFactory != null) {
                String currentProgress = iJSFactory.getJSVideoModule().getCurrentProgress();
                aa.b("JS-Video-Brigde", "getCurrentProgress:" + currentProgress);
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                g.a().a(obj, currentProgress);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "getCurrentProgress error", th);
        }
    }

    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("type");
                aa.b("JS-Video-Brigde", "showVideoClickView,type:" + optInt);
                this.d.getJSContainerModule().showVideoClickView(optInt);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("fitxy");
                aa.b("JS-Video-Brigde", "setScaleFitXY,type:" + optInt);
                this.d.getJSVideoModule().setScaleFitXY(optInt);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("state");
                aa.b("JS-Video-Brigde", "notifyCloseBtn,result:" + optInt);
                this.d.getJSVideoModule().notifyCloseBtn(optInt);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "notifyCloseBtn", th);
        }
    }

    public void openURL(Object obj, String str) {
        aa.d("JS-Video-Brigde", "openURL:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt("type");
                if (optInt == 1) {
                    b.a(this.a, optString);
                } else if (optInt == 2) {
                    b.b(this.a, optString);
                }
            } catch (JSONException e2) {
                aa.d("JS-Video-Brigde", e2.getMessage());
            } catch (Throwable th) {
                aa.d("JS-Video-Brigde", th.getMessage());
            }
        }
    }

    public void showAlertView(Object obj, String str) {
        aa.b("JS-Video-Brigde", "showAlertView");
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSVideoModule().showIVRewardAlertView(str);
                g.a().a(obj, "showAlertView", "");
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "showAlertView", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("state");
                aa.b("JS-Video-Brigde", "toggleCloseBtn,result:" + optInt);
                int i = 2;
                if (optInt != 1) {
                    i = optInt == 2 ? 1 : 0;
                }
                this.d.getJSVideoModule().closeVideoOperate(0, i);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "toggleCloseBtn", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                aa.b("JS-Video-Brigde", "handlerH5Exception,params:" + str);
                this.d.getJSCommon().handlerH5Exception(jSONObject.optInt("code", -999), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "h5 error"));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "handlerH5Exception", th);
        }
    }

    public void isSystemResume(Object obj, String str) {
        try {
            if (this.d != null) {
                aa.b("JS-Video-Brigde", "isSystemResume,params:" + str);
                g.a().a(obj, b(this.d.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "isSystemResume", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a.getObject() instanceof j) {
                    ((j) aVar.a.getObject()).i(optInt);
                }
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a((WebView) windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                aa.b("JS-Video-Brigde", "readyStatus", th);
            }
        }
    }

    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str) && this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("type");
                aa.b("JS-Video-Brigde", "playVideoFinishOperate,type: " + optInt);
                this.d.getJSCommon().f(optInt);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "playVideoFinishOperate error", th);
        }
    }

    private String b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            aa.d("JS-Video-Brigde", "code to string is error");
            return "";
        }
    }

    public void reactDeveloper(Object obj, String str) {
        aa.a("JS-Video-Brigde", "reactDeveloper");
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                g.a().b(obj, b(1));
            } else {
                this.d.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "reactDeveloper error " + th);
        }
    }

    public void reportUrls(Object obj, String str) {
        aa.a("JS-Video-Brigde", "reportUrls");
        try {
            if (!TextUtils.isEmpty(str)) {
                IJSFactory iJSFactory = this.d;
                if (iJSFactory == null || iJSFactory.getJSBTModule() == null) {
                    com.mbridge.msdk.video.bt.a.c.a().b(obj, str);
                } else if (this.d.getJSBTModule() instanceof i) {
                    this.d.getJSBTModule().reportUrls(obj, str);
                } else {
                    com.mbridge.msdk.video.bt.a.c.a().b(obj, str);
                }
            } else {
                g.a().b(obj, b(1));
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "reportUrls error " + th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "getFileInfo error", th);
        }
    }

    public void getSDKInfo(Object obj, String str) {
        aa.b("JS-Video-Brigde", "getSDKInfo");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("type");
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                if (this.d != null) {
                    while (i < jSONArray.length()) {
                        int i2 = jSONArray.getInt(i);
                        jSONObject.put(a(i2), this.d.getJSCommon().g(i2));
                        i++;
                    }
                } else if (obj != null) {
                    while (i < jSONArray.length()) {
                        int i3 = jSONArray.getInt(i);
                        a aVar = (a) obj;
                        if (aVar.a.getObject() instanceof j) {
                            jSONObject.put(a(i3), ((j) aVar.a.getObject()).g(i3));
                        }
                        i++;
                    }
                }
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().b(obj, "params is null");
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "getSDKInfo error", th);
            g.a().b(obj, "exception");
        }
    }

    public void loadads(Object obj, String str) {
        int i;
        int i2;
        String str2;
        String str3;
        aa.b("JS-Video-Brigde", "loadads");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(MBridgeConstans.PLACEMENT_ID);
                String optString2 = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                int optInt = jSONObject.optInt("type", 1);
                if (optInt > 2) {
                    optInt = 1;
                }
                i = jSONObject.optInt("adtype", 1);
                str2 = optString2;
                i2 = optInt;
                str3 = optString;
            } else {
                str3 = "";
                str2 = str3;
                i2 = 1;
                i = 1;
            }
            if (TextUtils.isEmpty(str2)) {
                g.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(windVaneWebView, str3, str2, i2, i);
                    }
                }
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "loadads error", th);
            g.a().a(obj, b(1));
        }
    }

    private void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e2) {
            aa.a("JS-Video-Brigde", e2.getMessage());
        }
    }

    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createWebview error " + th);
        }
    }

    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createView error " + th);
        }
    }

    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createPlayerView error " + th);
        }
    }

    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createSubPlayTemplateView error " + th);
        }
    }

    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "destroyComponent error " + th);
        }
    }

    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().f(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getComponentOptions error " + th);
        }
    }

    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewRect error " + th);
        }
    }

    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "removeFromSuperView error " + th);
        }
    }

    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "bringViewToFront error " + th);
        }
    }

    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "hideView error " + th);
        }
    }

    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "showView error " + th);
        }
    }

    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewBgColor error " + th);
        }
    }

    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewAlpha error " + th);
        }
    }

    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setViewScale error " + th);
        }
    }

    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewLoad error " + th);
        }
    }

    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewReload error " + th);
        }
    }

    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewGoBack error " + th);
        }
    }

    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "webviewGoForward error " + th);
        }
    }

    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerPlay error " + th);
        }
    }

    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerPause error " + th);
        }
    }

    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerResume error " + th);
        }
    }

    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerStop error " + th);
        }
    }

    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerUpdateFrame error " + th);
        }
    }

    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerMute error " + th);
        }
    }

    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerUnmute error " + th);
        }
    }

    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().E(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerGetMuteState error " + th);
        }
    }

    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerSetSource error " + th);
        }
    }

    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "playerSetRenderType error " + th);
        }
    }

    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.d != null) {
                com.mbridge.msdk.video.bt.a.c.a().H(obj, new JSONObject(str));
                return;
            }
            a aVar = (a) obj;
            if (aVar.a instanceof WindVaneWebView) {
                WindVaneWebView windVaneWebView = aVar.a;
                if (windVaneWebView.getWebViewListener() != null) {
                    ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj, str);
                    aa.a("JS-Video-Brigde", "preloadSubPlayTemplateView: RVWebViewListener");
                    return;
                }
                aa.a("JS-Video-Brigde", "preloadSubPlayTemplateView: failed");
            }
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "preloadSubPlayTemplateView error " + th);
        }
    }

    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().I(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "closeAd error " + th);
        }
    }

    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().J(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "broadcast error " + th);
        }
    }

    public void closeWeb(Object obj, String str) {
        aa.d("JS-Video-Brigde", "type" + str);
        try {
            if (!TextUtils.isEmpty(str) && this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("status");
                this.d.getJSContainerModule().hideAlertWebview();
                this.d.getJSVideoModule().hideAlertView(optInt);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "closeWeb", th);
        }
    }

    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        aa.d("JS-Video-Brigde", "ivRewardAdsWithoutVideo ： params" + str);
        try {
            if (!TextUtils.isEmpty(str) && this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSContainerModule().ivRewardAdsWithoutVideo(str);
            }
        } catch (Throwable th) {
            aa.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo", th);
        }
    }

    public void setSubPlayTemplateInfo(Object obj, String str) {
        aa.d("JS-Video-Brigde", "setSubPlayTemplateInfo : " + str);
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().K(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "increaseOfferFrequence error " + th);
        }
    }

    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.b.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "handleNativeObject error " + th);
        }
    }

    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().c(windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                aa.d("JS-Video-Brigde", "loadingResourceStatus error " + th);
            }
        }
    }

    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "createNativeEC error " + th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00df A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb A[ADDED_TO_REGION, Catch:{ all -> 0x0115 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCacheItem(java.lang.Object r12, java.lang.String r13) {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.controller.c.a()
            com.mbridge.msdk.foundation.tools.FastKV r0 = r11.e
            java.lang.String r1 = "MBridgeH5CacheSP"
            if (r0 != 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.b(r2)     // Catch:{ Exception -> 0x001b }
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch:{ Exception -> 0x001b }
            r11.e = r0     // Catch:{ Exception -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r0 = 0
            r11.e = r0
        L_0x001e:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r11.e
            java.lang.String r2 = "Save Success"
            java.lang.String r3 = "value"
            java.lang.String r4 = "key"
            java.lang.String r5 = "Save Error, reason is : "
            r6 = 1
            java.lang.String r7 = "setCacheItem error "
            java.lang.String r8 = "JS-Video-Brigde"
            r9 = 0
            java.lang.String r10 = ""
            if (r0 == 0) goto L_0x007e
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x005a
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x005d }
            r0.<init>(r13)     // Catch:{ all -> 0x005d }
            java.lang.String r13 = r0.getString(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r0.getString(r3)     // Catch:{ all -> 0x005d }
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0057
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0057
            com.mbridge.msdk.foundation.tools.FastKV r1 = r11.e     // Catch:{ Exception -> 0x0057 }
            r1.putString(r13, r0)     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            r13 = 1
            goto L_0x00d6
        L_0x005a:
            r2 = r10
            goto L_0x00d5
        L_0x005d:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r7)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r2 = r0.toString()
            goto L_0x00d5
        L_0x007e:
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x00b5 }
            android.content.Context r0 = r0.g()     // Catch:{ all -> 0x00b5 }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r9)     // Catch:{ all -> 0x00b5 }
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x005a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00b5 }
            r1.<init>(r13)     // Catch:{ all -> 0x00b5 }
            java.lang.String r13 = r1.getString(r4)     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = r1.getString(r3)     // Catch:{ all -> 0x00b5 }
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00b5 }
            if (r3 != 0) goto L_0x0057
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00b5 }
            if (r3 != 0) goto L_0x0057
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x00b5 }
            android.content.SharedPreferences$Editor r13 = r0.putString(r13, r1)     // Catch:{ all -> 0x00b5 }
            r13.apply()     // Catch:{ all -> 0x00b5 }
            goto L_0x0057
        L_0x00b5:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r7)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r2 = r0.toString()
        L_0x00d5:
            r13 = 0
        L_0x00d6:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0115 }
            r0.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "code"
            if (r13 == 0) goto L_0x00e0
            r6 = 0
        L_0x00e0:
            r0.put(r1, r6)     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "message"
            r0.put(r1, r2)     // Catch:{ all -> 0x0115 }
            r1 = 2
            if (r12 == 0) goto L_0x0101
            if (r13 == 0) goto L_0x0101
            com.mbridge.msdk.mbsignalcommon.windvane.g r13 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0115 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x0115 }
            r13.a(r12, r0)     // Catch:{ all -> 0x0115 }
            goto L_0x0118
        L_0x0101:
            com.mbridge.msdk.mbsignalcommon.windvane.g r13 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0115 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x0115 }
            r13.b(r12, r0)     // Catch:{ all -> 0x0115 }
            goto L_0x0118
        L_0x0115:
            com.mbridge.msdk.foundation.tools.aa.d(r8, r7)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.setCacheItem(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6 A[Catch:{ all -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2 A[ADDED_TO_REGION, Catch:{ all -> 0x00fc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeCacheItem(java.lang.Object r11, java.lang.String r12) {
        /*
            r10 = this;
            com.mbridge.msdk.foundation.controller.c.a()
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.e
            java.lang.String r1 = "MBridgeH5CacheSP"
            if (r0 != 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.b(r2)     // Catch:{ Exception -> 0x001b }
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x001b }
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch:{ Exception -> 0x001b }
            r10.e = r0     // Catch:{ Exception -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r0 = 0
            r10.e = r0
        L_0x001e:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.e
            java.lang.String r2 = "Delete Success"
            java.lang.String r3 = "key"
            java.lang.String r4 = "Delete Error, reason is : "
            r5 = 1
            java.lang.String r6 = "removeCacheItem error "
            java.lang.String r7 = "JS-Video-Brigde"
            r8 = 0
            java.lang.String r9 = ""
            if (r0 == 0) goto L_0x006f
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x004c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x004e }
            r0.<init>(r12)     // Catch:{ all -> 0x004e }
            java.lang.String r12 = r0.getString(r3)     // Catch:{ all -> 0x004e }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x004a
            com.mbridge.msdk.foundation.tools.FastKV r0 = r10.e     // Catch:{ Exception -> 0x004a }
            r0.remove(r12)     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            r12 = 1
            goto L_0x00bd
        L_0x004c:
            r2 = r9
            goto L_0x00bc
        L_0x004e:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r2 = r0.toString()
            goto L_0x00bc
        L_0x006f:
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x009c }
            android.content.Context r0 = r0.g()     // Catch:{ all -> 0x009c }
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r8)     // Catch:{ all -> 0x009c }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x004c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x009c }
            r1.<init>(r12)     // Catch:{ all -> 0x009c }
            java.lang.String r12 = r1.getString(r3)     // Catch:{ all -> 0x009c }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x004a
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x009c }
            android.content.SharedPreferences$Editor r12 = r0.remove(r12)     // Catch:{ all -> 0x009c }
            r12.apply()     // Catch:{ all -> 0x009c }
            goto L_0x004a
        L_0x009c:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r2 = r0.toString()
        L_0x00bc:
            r12 = 0
        L_0x00bd:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00fc }
            r0.<init>()     // Catch:{ all -> 0x00fc }
            java.lang.String r1 = "code"
            if (r12 == 0) goto L_0x00c7
            r5 = 0
        L_0x00c7:
            r0.put(r1, r5)     // Catch:{ all -> 0x00fc }
            java.lang.String r1 = "message"
            r0.put(r1, r2)     // Catch:{ all -> 0x00fc }
            r1 = 2
            if (r11 == 0) goto L_0x00e8
            if (r12 == 0) goto L_0x00e8
            com.mbridge.msdk.mbsignalcommon.windvane.g r12 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00fc }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x00fc }
            r12.a(r11, r0)     // Catch:{ all -> 0x00fc }
            goto L_0x00ff
        L_0x00e8:
            com.mbridge.msdk.mbsignalcommon.windvane.g r12 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00fc }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x00fc }
            r12.b(r11, r0)     // Catch:{ all -> 0x00fc }
            goto L_0x00ff
        L_0x00fc:
            com.mbridge.msdk.foundation.tools.aa.d(r7, r6)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.removeCacheItem(java.lang.Object, java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.util.Map<java.lang.String, java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r10v3, types: [java.lang.Object] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f0 A[SYNTHETIC, Splitter:B:40:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f4 A[Catch:{ all -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fc A[Catch:{ all -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getAllCache(java.lang.Object r9, java.lang.String r10) {
        /*
            r8 = this;
            com.mbridge.msdk.foundation.controller.c.a()
            com.mbridge.msdk.foundation.tools.FastKV r10 = r8.e
            java.lang.String r0 = "MBridgeH5CacheSP"
            r1 = 0
            if (r10 != 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.FastKV$Builder r10 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x001c }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.b(r2)     // Catch:{ Exception -> 0x001c }
            r10.<init>(r2, r0)     // Catch:{ Exception -> 0x001c }
            com.mbridge.msdk.foundation.tools.FastKV r10 = r10.build()     // Catch:{ Exception -> 0x001c }
            r8.e = r10     // Catch:{ Exception -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r8.e = r1
        L_0x001e:
            com.mbridge.msdk.foundation.tools.FastKV r10 = r8.e
            java.lang.String r2 = "getAllCache Success"
            r3 = 0
            java.lang.String r4 = "getAllCache Error, reason is : "
            java.lang.String r5 = "getAllCache error "
            java.lang.String r6 = "JS-Video-Brigde"
            if (r10 == 0) goto L_0x0080
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x005f }
            r10.<init>()     // Catch:{ all -> 0x005f }
            com.mbridge.msdk.foundation.tools.FastKV r0 = r8.e     // Catch:{ Exception -> 0x003a }
            java.util.Map r1 = r0.getAll()     // Catch:{ Exception -> 0x003a }
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            r1 = r10
            goto L_0x0060
        L_0x003a:
        L_0x003b:
            if (r1 == 0) goto L_0x00dd
            java.util.Set r0 = r1.entrySet()     // Catch:{ all -> 0x0037 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0045:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x00dd
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0037 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0037 }
            java.lang.Object r7 = r1.getKey()     // Catch:{ all -> 0x0037 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0037 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0037 }
            r10.put(r7, r1)     // Catch:{ all -> 0x0037 }
            goto L_0x0045
        L_0x005f:
            r0 = move-exception
        L_0x0060:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r5)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r6, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            r10.append(r0)
            java.lang.String r2 = r10.toString()
            goto L_0x00dc
        L_0x0080:
            com.mbridge.msdk.foundation.controller.b r10 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x00bc }
            android.content.Context r10 = r10.g()     // Catch:{ all -> 0x00bc }
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r0, r3)     // Catch:{ all -> 0x00bc }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00bc }
            r0.<init>()     // Catch:{ all -> 0x00bc }
            java.util.Map r10 = r10.getAll()     // Catch:{ all -> 0x00b9 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x00b9 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00b9 }
        L_0x009d:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x00b7
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x00b9 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00b9 }
            java.lang.Object r7 = r1.getKey()     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00b9 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00b9 }
            r0.put(r7, r1)     // Catch:{ all -> 0x00b9 }
            goto L_0x009d
        L_0x00b7:
            r10 = r0
            goto L_0x00dd
        L_0x00b9:
            r10 = move-exception
            r1 = r0
            goto L_0x00bd
        L_0x00bc:
            r10 = move-exception
        L_0x00bd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r2 = r0.toString()
        L_0x00dc:
            r10 = r1
        L_0x00dd:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0111 }
            r0.<init>()     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = "code"
            r0.put(r1, r3)     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = "message"
            r0.put(r1, r2)     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = "data"
            if (r10 == 0) goto L_0x00f4
            r0.put(r1, r10)     // Catch:{ all -> 0x0111 }
            goto L_0x00fa
        L_0x00f4:
            java.lang.String r10 = "{}"
            r0.put(r1, r10)     // Catch:{ all -> 0x0111 }
        L_0x00fa:
            if (r9 == 0) goto L_0x0121
            com.mbridge.msdk.mbsignalcommon.windvane.g r10 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x0111 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0111 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0111 }
            r1 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x0111 }
            r10.a(r9, r0)     // Catch:{ all -> 0x0111 }
            goto L_0x0121
        L_0x0111:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r5)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r6, r9)
        L_0x0121:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.getAllCache(java.lang.Object, java.lang.String):void");
    }

    public void clearAllCache(Object obj, String str) {
        com.mbridge.msdk.foundation.controller.c.a();
        if (this.e == null) {
            try {
                this.e = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.e = null;
            }
        }
        FastKV fastKV = this.e;
        if (fastKV != null) {
            try {
                fastKV.clear();
            } catch (Exception unused2) {
            }
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Success");
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Throwable th) {
                    aa.d("JS-Video-Brigde", "getAllCache error " + th);
                }
            }
        } else {
            try {
                com.mbridge.msdk.foundation.controller.b.d().g().getSharedPreferences("MBridgeH5CacheSP", 0).edit().clear().apply();
                if (obj != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 0);
                    jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Success");
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                }
            } catch (Throwable th2) {
                aa.d("JS-Video-Brigde", "getAllCache error " + th2);
            }
        }
    }

    public void getCutout(Object obj, String str) {
        try {
            String i = this.d.getJSCommon().i();
            aa.d("JS-Video-Brigde", i);
            if (obj == null || TextUtils.isEmpty(i)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "No notch data, plz try again later.");
                g.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().a(obj, Base64.encodeToString(i.getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getCutout error : " + th.getMessage());
        }
    }

    public void cai(Object obj, String str) {
        aa.a("JS-Video-Brigde", "cai:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(optString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "packageName is empty");
                }
                int i = af.c(com.mbridge.msdk.foundation.controller.b.d().g(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i);
                    jSONObject.put("data", jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, e2.getMessage());
                    aa.a("JS-Video-Brigde", e2.getMessage());
                }
            } catch (JSONException e3) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + e3.getLocalizedMessage());
                aa.b("JS-Video-Brigde", "cai", e3);
            } catch (Throwable th) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + th.getLocalizedMessage());
                aa.b("JS-Video-Brigde", "cai", th);
            }
        }
    }

    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String optString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                String c = f.a().c(optString);
                if (TextUtils.isEmpty(c)) {
                    jSONObject = new JSONObject(f.a().b().aM());
                } else {
                    jSONObject = new JSONObject(c);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Success");
                    jSONObject2.put("data", jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Get App Setting error, plz try again later.");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Get App Setting error, because must give a appId.");
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getAppSetting error : " + th.getMessage());
        }
    }

    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject l = com.mbridge.msdk.videocommon.d.b.a().b().l();
            JSONObject jSONObject = new JSONObject();
            if (obj == null || l == null) {
                jSONObject.put("code", 1);
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Get Reward Setting error, plz try again later.");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Success");
                jSONObject.put("data", l);
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getRewardSetting error : " + th.getMessage());
        }
    }

    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid", "");
            String optString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject F = com.mbridge.msdk.videocommon.d.b.a().a(optString, optString2).F();
                    if (obj == null || F == null) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Get Reward Unit Setting error, plz try again later.");
                    } else {
                        jSONObject2.put("code", 0);
                        jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Success");
                        jSONObject2.put("data", F);
                    }
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                }
            }
            jSONObject2.put("code", 1);
            jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Get reward unit Setting error, because must give appId and unitId.");
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Get Unit Setting error, RV/IV can not support this method.");
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getUnitSetting error : " + th.getMessage());
        }
    }

    public void getEncryptPrice(Object obj, String str) {
        String str2;
        String str3 = "not replaced";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int i = 1;
            if (TextUtils.isEmpty(str)) {
                str2 = "params is null";
            } else {
                JSONObject jSONObject3 = new JSONObject(str);
                String optString = jSONObject3.optString("unitid", "");
                String optString2 = jSONObject3.optString("requestId", "");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    str2 = "params parsing exception";
                } else {
                    com.mbridge.msdk.foundation.entity.c c = d.c(optString, optString2);
                    if (c != null && c.d() == 1) {
                        str3 = "success";
                        jSONObject2.put("encrypt_p", c.b());
                        jSONObject2.put(CampaignUnit.KEY_IRLFA, 1);
                        i = 0;
                    }
                    str2 = str3;
                }
            }
            jSONObject.put("code", i);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
            jSONObject.put("data", jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.d("JS-Video-Brigde", "getEncryptPrice error : " + th.getMessage());
        }
    }
}
