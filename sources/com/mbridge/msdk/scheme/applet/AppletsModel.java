package com.mbridge.msdk.scheme.applet;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.scheme.report.AppletsReport;
import com.mbridge.msdk.scheme.request.AppletSchemeRequest;
import com.mbridge.msdk.scheme.response.AppletSchemeResponse;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class AppletsModel implements Serializable {
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_0 = "0";
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_1 = "1";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK = "event_callback";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK = "install_callback";
    public static final int REQUEST_TYPE_CLICK = 1;
    public static final int REQUEST_TYPE_SHOW = 0;
    private static String TAG = "AppletsModel";
    private static final String URL_ENCODE_UTF_8 = "UTF-8";
    private static final String WX_MINIPROGRAM = "wx_miniprogram";
    private static final int WX_SCHEME_REQUEST_ERROR_CODE_44993 = 44993;
    private volatile IAppletSchemeCallBack appletSchemeCallBack;
    private final CampaignEx campaignEx;
    private String deepLink = "";
    private volatile boolean isRequestSuccess = false;
    private boolean isRequestTimesMaxPerDay = false;
    private volatile boolean isRequesting = false;
    private boolean isSupportWxScheme = false;
    private boolean isUserClick = false;
    private int lastRequestType = -1;
    private Map<String, String> params;
    private String reBuildClickUrl;
    private final String requestId;
    private final String unitID;

    public AppletsModel(CampaignEx campaignEx2, String str, String str2) {
        this.campaignEx = campaignEx2;
        this.unitID = str;
        this.requestId = str2;
    }

    public void requestWxAppletsScheme(int i, IAppletSchemeCallBack iAppletSchemeCallBack) {
        if (this.campaignEx != null && !TextUtils.isEmpty(this.unitID)) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, "start request wx scheme");
            }
            this.isRequesting = true;
            if (iAppletSchemeCallBack != null) {
                this.appletSchemeCallBack = iAppletSchemeCallBack;
            }
            handlerSchemeRequestStart();
            AppletSchemeRequest appletSchemeRequest = new AppletSchemeRequest(b.d().g());
            if (this.params == null) {
                this.params = getAppletsParamsAndBuildRequest(this.campaignEx);
            }
            if (this.params != null) {
                if (isRequestTimesMaxPerDay()) {
                    handlerSchemeRequestFailed(WX_SCHEME_REQUEST_ERROR_CODE_44993, "get wxscheme failed : request times is max");
                    return;
                }
                this.lastRequestType = i;
                appletSchemeRequest.get(1, d.a().g, this.params, new com.mbridge.msdk.foundation.same.net.b(5000, 5000, 5000, 6000, 0), new DefaultAppletSchemeResponse(this));
            }
        }
    }

    public void setAppletSchemeCallBack(IAppletSchemeCallBack iAppletSchemeCallBack) {
        this.appletSchemeCallBack = iAppletSchemeCallBack;
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public void setRequestingFinish() {
        this.isRequesting = false;
    }

    public boolean isRequestSuccess() {
        return this.isRequestSuccess;
    }

    public String getReBuildClickUrl() {
        return this.reBuildClickUrl;
    }

    private void handlerSchemeRequestStart() {
        if (this.appletSchemeCallBack != null) {
            try {
                this.appletSchemeCallBack.onAppletSchemeRequestStart();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "handler wx scheme start exception ", e);
                }
            }
            AppletsReport.reportAppletsLoadState(b.d().g(), "start load wx scheme", this.unitID, this.requestId);
        }
    }

    /* access modifiers changed from: private */
    public void handlerSchemeRequestNetworkError(a aVar) {
        String str;
        int i;
        if (this.appletSchemeCallBack != null) {
            if (aVar != null) {
                i = aVar.a;
                str = aVar.getMessage();
                if (i == 10) {
                    str = "request timeout";
                }
            } else {
                i = -1;
                str = "unKnown";
            }
            if (MBridgeConstans.DEBUG) {
                aa.a(TAG, String.format("handlerSchemeRequestNetworkError network error by code %s and %s", new Object[]{String.valueOf(i), str}));
            }
            try {
                IAppletSchemeCallBack iAppletSchemeCallBack = this.appletSchemeCallBack;
                iAppletSchemeCallBack.onNetworkError(i, "network error: " + str, this.reBuildClickUrl);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "handler wx scheme network error exception ", e);
                }
            }
            AppletsReport.reportAppletsLoadState(b.d().g(), String.format("network error by code %s and %s", new Object[]{String.valueOf(i), str}), this.unitID, this.requestId);
        }
    }

    /* access modifiers changed from: private */
    public void handlerSchemeRequestResult(l<JSONObject> lVar) throws SchemeRequestException {
        JSONObject jSONObject = (JSONObject) lVar.a;
        if (MBridgeConstans.DEBUG) {
            aa.a("AppletsModel", "result: " + jSONObject.toString());
        }
        if (jSONObject.has("wx_scheme")) {
            String optString = jSONObject.optString("wx_scheme", "");
            if (!TextUtils.isEmpty(optString)) {
                this.isRequestSuccess = true;
                handlerSchemeRequestSuccess(optString);
                return;
            }
            throw new SchemeRequestException("wx_scheme value is null");
        }
        int optInt = jSONObject.optInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1);
        String optString2 = jSONObject.optString("error_msg", "");
        if (optInt == WX_SCHEME_REQUEST_ERROR_CODE_44993) {
            this.isRequestTimesMaxPerDay = true;
        }
        handlerSchemeRequestFailed(optInt, optString2);
    }

    /* access modifiers changed from: private */
    public void handlerSchemeRequestFailed(int i, String str) {
        if (this.appletSchemeCallBack != null) {
            if (MBridgeConstans.DEBUG) {
                aa.a(TAG, String.format("handlerSchemeRequestFailed network error by code %s and %s", new Object[]{String.valueOf(i), str}));
            }
            try {
                this.appletSchemeCallBack.onAppletSchemeRequestFailed(i, str, this.reBuildClickUrl);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "handler wx scheme failed exception  ", e);
                }
            }
            AppletsReport.reportAppletsLoadState(b.d().g(), String.format("network error by code %s and %s", new Object[]{String.valueOf(i), str}), this.unitID, this.requestId);
        }
    }

    private void handlerSchemeRequestSuccess(String str) {
        if (this.appletSchemeCallBack != null) {
            if (MBridgeConstans.DEBUG) {
                String str2 = TAG;
                aa.a(str2, "handlerSchemeRequestSuccess: " + str);
            }
            try {
                this.deepLink = str;
                this.appletSchemeCallBack.onAppletSchemeRequestSuccess(str);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "handler wx scheme success exception ", e);
                }
            }
            AppletsReport.reportAppletsLoadState(b.d().g(), "request wx scheme success", this.unitID, this.requestId);
        }
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    /* access modifiers changed from: private */
    public void handlerRequestNetworkError() {
        if (this.appletSchemeCallBack != null) {
            if (MBridgeConstans.DEBUG) {
                aa.a(TAG, "handlerRequestNetworkError response or result is null");
            }
            try {
                this.appletSchemeCallBack.onNetworkError(1, "response or result is null", this.reBuildClickUrl);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "handler request network error exception ", e);
                }
            }
            AppletsReport.reportAppletsLoadState(b.d().g(), "response or result is null", this.unitID, this.requestId);
        }
    }

    private Map<String, String> getAppletsParamsAndBuildRequest(CampaignEx campaignEx2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = MBridgeConstans.DYNAMIC_VIEW_WX_IS_REDIRECT;
        String str8 = "query";
        HashMap hashMap = new HashMap();
        if (campaignEx2 == null) {
            return hashMap;
        }
        try {
            Uri parse = Uri.parse(campaignEx2.getClickURL());
            if (parse != null) {
                if (parse.getQueryParameterNames() != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = parse.getQueryParameterNames().iterator();
                    int i = 0;
                    while (true) {
                        str = "";
                        if (!it.hasNext()) {
                            break;
                        }
                        try {
                            Iterator<String> it2 = it;
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(next, "wx_miniprogram")) {
                                str6 = str7;
                                str5 = str8;
                            } else {
                                try {
                                    str = parse.getQueryParameter(next);
                                } catch (Exception unused) {
                                }
                                String str9 = str;
                                if (TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK) || TextUtils.equals(next, DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK)) {
                                    try {
                                        str9 = URLEncoder.encode(str9, "UTF-8");
                                    } catch (Exception e) {
                                        Exception exc = e;
                                        if (MBridgeConstans.DEBUG) {
                                            String str10 = TAG;
                                            str6 = str7;
                                            StringBuilder sb2 = new StringBuilder();
                                            str5 = str8;
                                            sb2.append("encode url for ");
                                            sb2.append(str9);
                                            sb2.append(" failed");
                                            aa.b(str10, sb2.toString(), exc);
                                        }
                                    }
                                }
                                str6 = str7;
                                str5 = str8;
                                sb.append(next);
                                sb.append("=");
                                sb.append(str9);
                                if (i < parse.getQueryParameterNames().size()) {
                                    sb.append("&");
                                }
                                i++;
                            }
                            it = it2;
                            str7 = str6;
                            str8 = str5;
                        } catch (Exception e2) {
                            e = e2;
                            if (MBridgeConstans.DEBUG) {
                                aa.b(TAG, "create wechat app request param failed ", e);
                            }
                            return hashMap;
                        }
                    }
                    String str11 = str7;
                    String str12 = str8;
                    try {
                        String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                        if (queryParameter == null) {
                            queryParameter = str;
                        }
                        str2 = queryParameter;
                    } catch (Exception e3) {
                        Exception exc2 = e3;
                        if (MBridgeConstans.DEBUG) {
                            aa.b(TAG, "create wechat app request param failed ", exc2);
                        }
                        str2 = str;
                    }
                    hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, str2);
                    try {
                        String queryParameter2 = parse.getQueryParameter("path");
                        if (queryParameter2 == null) {
                            queryParameter2 = str;
                        }
                        str3 = queryParameter2;
                    } catch (Exception e4) {
                        Exception exc3 = e4;
                        if (MBridgeConstans.DEBUG) {
                            aa.b(TAG, "create wechat app request param failed ", exc3);
                        }
                        str3 = str;
                    }
                    hashMap.put("path", str3);
                    try {
                        String queryParameter3 = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID);
                        if (queryParameter3 == null) {
                            queryParameter3 = str;
                        }
                        str4 = queryParameter3;
                    } catch (Exception e5) {
                        Exception exc4 = e5;
                        if (MBridgeConstans.DEBUG) {
                            aa.b(TAG, "create wechat app request param failed ", exc4);
                        }
                        str4 = str;
                    }
                    hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID, str4);
                    try {
                        String encode = URLEncoder.encode(sb.toString(), "UTF-8");
                        if (encode != null) {
                            str = encode;
                        }
                    } catch (UnsupportedEncodingException e6) {
                        if (MBridgeConstans.DEBUG) {
                            aa.b(TAG, "create wechat app request param failed ", e6);
                        }
                    }
                    String str13 = str;
                    String str14 = str12;
                    hashMap.put(str14, str13);
                    String str15 = str11;
                    hashMap.put(str15, "0");
                    if (MBridgeConstans.DEBUG) {
                        String str16 = TAG;
                        aa.a(str16, "query: " + str13);
                    }
                    this.reBuildClickUrl = reCreateClickUrl(MBridgeConstans.DYNAMIC_VIEW_WX_APP + "=" + str2 + "&" + "path" + "=" + str3 + "&" + str14 + "=" + str13 + "&" + MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID + "=" + str4 + "&" + str15 + "=" + "1");
                    return hashMap;
                }
            }
            return hashMap;
        } catch (Exception e7) {
            e = e7;
        }
    }

    private String reCreateClickUrl(String str) {
        return d.a().g + "?" + str;
    }

    public boolean canRequestWxScheme(int i) {
        if (!isSupportWxScheme()) {
            return false;
        }
        if (i != 0) {
            return i == 1;
        }
        return isCanRequestByTemplateUrl("2");
    }

    private boolean isCanRequestByLinkType() {
        CampaignEx campaignEx2 = this.campaignEx;
        if (campaignEx2 == null) {
            return false;
        }
        int linkType = campaignEx2.getLinkType();
        if (linkType == 8 || linkType == 9) {
            return true;
        }
        return false;
    }

    private boolean isCanRequestByClickUrl(String str) {
        try {
            CampaignEx campaignEx2 = this.campaignEx;
            if (campaignEx2 == null) {
                return false;
            }
            String clickURL = campaignEx2.getClickURL();
            if (TextUtils.isEmpty(clickURL)) {
                return false;
            }
            return TextUtils.equals(al.a(clickURL, "wx_miniprogram"), str);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            aa.b(TAG, "query wx_miniprogram from click url exception ", e);
            return false;
        }
    }

    private boolean isCanRequestByTemplateUrl(String str) {
        CampaignEx.c rewardTemplateMode;
        try {
            CampaignEx campaignEx2 = this.campaignEx;
            if (campaignEx2 == null || (rewardTemplateMode = campaignEx2.getRewardTemplateMode()) == null) {
                return false;
            }
            if (TextUtils.isEmpty(rewardTemplateMode.e())) {
                return false;
            }
            return TextUtils.equals(al.a(rewardTemplateMode.e(), MBridgeConstans.DYNAMIC_VIEW_REQ_WX_URL), str);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            aa.b(TAG, "query reqwxurl from template url exception ", e);
            return false;
        }
    }

    public boolean isRequestTimesMaxPerDay() {
        return this.isRequestTimesMaxPerDay;
    }

    public boolean can(int i) {
        if (isRequesting() || !canRequestWxScheme(i)) {
            return false;
        }
        if (this.lastRequestType == -1) {
            return true;
        }
        if (isRequestSuccess()) {
            return false;
        }
        int i2 = this.lastRequestType;
        if ((i2 == 0 && i == 1) || (i2 == 1 && i == 1 && this.isUserClick)) {
            return true;
        }
        return false;
    }

    public void setUserClick(boolean z) {
        this.isUserClick = z;
    }

    public boolean isSupportWxScheme() {
        if (!this.isSupportWxScheme) {
            this.isSupportWxScheme = isCanRequestByClickUrl("1") && isCanRequestByLinkType();
        }
        return this.isSupportWxScheme;
    }

    public void clearRequestState() {
        this.isRequestSuccess = false;
        this.isRequesting = false;
        this.appletSchemeCallBack = null;
    }

    /* access modifiers changed from: private */
    public void changeRequestingState(boolean z) {
        this.isRequesting = z;
    }

    private static final class DefaultAppletSchemeResponse extends AppletSchemeResponse {
        private AppletsModel appletsModel;

        public DefaultAppletSchemeResponse(AppletsModel appletsModel2) {
            this.appletsModel = appletsModel2;
        }

        public final void onSuccess(l<JSONObject> lVar) {
            super.onSuccess(lVar);
            AppletsModel appletsModel2 = this.appletsModel;
            if (appletsModel2 != null) {
                appletsModel2.changeRequestingState(false);
                if (lVar == null || lVar.a == null) {
                    this.appletsModel.handlerRequestNetworkError();
                    return;
                }
                try {
                    this.appletsModel.handlerSchemeRequestResult(lVar);
                } catch (SchemeRequestException e) {
                    this.appletsModel.handlerSchemeRequestFailed(-2, e.getMessage());
                }
            }
        }

        public final void onError(a aVar) {
            super.onError(aVar);
            AppletsModel appletsModel2 = this.appletsModel;
            if (appletsModel2 != null) {
                appletsModel2.changeRequestingState(false);
                this.appletsModel.handlerSchemeRequestNetworkError(aVar);
            }
        }
    }

    private static final class SchemeRequestException extends Exception {
        public SchemeRequestException(String str) {
            super(str);
        }
    }
}
