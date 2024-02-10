package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CampaignUnit implements NoProGuard, Serializable {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TK_TCP_PORT = "tk_tcp_port";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "CampaignUnit";
    private static final long serialVersionUID = 1;
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private StringBuffer cParams = new StringBuffer();
    private String csp;
    private String domain;
    private double ecppv;
    private String encryptPrice = "";
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private String msg = "";
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;

    private Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public void setIa_rst(int i) {
        this.ia_rst = i;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public void setIa_ori(int i) {
        this.ia_ori = i;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public void setRks(HashMap<String, String> hashMap) {
        this.rks = hashMap;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public void setEpMap(HashMap<String, String> hashMap) {
        this.epMap = hashMap;
    }

    public String getCsp() {
        return this.csp;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public int getTokenRule() {
        int i = this.tokenRule;
        if (i == 1) {
            return i;
        }
        return 0;
    }

    public void setTokenRule(int i) {
        this.tokenRule = i;
    }

    public int getVcn() {
        int i = this.vcn;
        if (i > 1) {
            return i;
        }
        return 1;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    public String getSh() {
        return this.sh;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public void setJmDo(int i) {
        this.jmDo = i;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public int getAdType() {
        return this.adType;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public void setEcppv(double d) {
        this.ecppv = d;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public int getTemplate() {
        return this.template;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public String assembCParams() {
        String str;
        String str2;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String a = w.a();
            Context g = b.d().g();
            String e = w.e(g);
            String d = w.d(g);
            if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                str = String.valueOf(w.r(g));
                str2 = w.l(g) + "x" + w.m(g);
            } else {
                str2 = "";
                str = str2;
            }
            this.cParams = this.cParams.append(getAdType()).append("|").append(nullToEmpty("1")).append("|").append(nullToEmpty(Build.VERSION.RELEASE)).append("|").append(nullToEmpty(MBConfiguration.SDK_VERSION)).append("|").append(nullToEmpty(w.i())).append("|").append(nullToEmpty(str2)).append("|").append(nullToEmpty(Integer.valueOf(w.h(b.d().g())))).append("|").append(nullToEmpty(w.g(b.d().g()))).append("|").append(nullToEmpty(str)).append("|").append(nullToEmpty(d)).append(nullToEmpty(e)).append("|").append("|").append("|").append("|").append(nullToEmpty(a)).append("|").append(nullToEmpty("")).append("|").append(nullToEmpty(w.k())).append("|").append(nullToEmpty("")).append("|").append("").append("|").append(nullToEmpty("")).append("|").append(nullToEmpty(com.mbridge.msdk.foundation.same.a.l + "," + com.mbridge.msdk.foundation.same.a.m)).append("|").append(w.u()).append("|");
        } catch (Throwable th) {
            aa.b(TAG, th.getMessage(), th);
        }
        return this.cParams.toString();
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.onlyImpressionUrl);
            if (parse != null) {
                this.requestId = parse.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        Iterator<CampaignEx> it = getAds().iterator();
        while (it.hasNext()) {
            it.next().setLocalRequestId(str);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|(3:15|16|17)|18|19|(1:54)(4:23|24|25|61)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void getSysIDAndBKUPID(org.json.JSONObject r9) {
        /*
            java.lang.String r0 = "H+tU+FeXHM=="
            com.mbridge.msdk.foundation.controller.c.a()
            com.mbridge.msdk.foundation.tools.FastKV$Builder r1 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x0019 }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.b(r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x0019 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0019 }
            com.mbridge.msdk.foundation.tools.FastKV r1 = r1.build()     // Catch:{ Exception -> 0x0019 }
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            java.lang.String r2 = "H+tU+Fz8"
            java.lang.String r3 = "H+tU+bfPhM=="
            java.lang.String r4 = "c"
            java.lang.String r5 = "b"
            if (r1 == 0) goto L_0x0084
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x007e }
            android.content.Context r0 = r0.g()     // Catch:{ Exception -> 0x007e }
            if (r9 == 0) goto L_0x0104
            if (r0 == 0) goto L_0x0104
            java.lang.String r0 = r9.optString(r5)     // Catch:{ Exception -> 0x007e }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x007e }
            if (r6 != 0) goto L_0x0056
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x007e }
            boolean r6 = android.text.TextUtils.equals(r6, r0)     // Catch:{ Exception -> 0x007e }
            if (r6 != 0) goto L_0x0056
            com.mbridge.msdk.foundation.same.a.l = r0     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.a.a.a r0 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x007e }
            r0.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r3)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0056 }
            r1.putString(r0, r3)     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            java.lang.String r9 = r9.optString(r4)     // Catch:{ Exception -> 0x007e }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0104
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x007e }
            boolean r0 = android.text.TextUtils.equals(r0, r9)     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0104
            com.mbridge.msdk.foundation.same.a.m = r9     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.a.a.a r9 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x007e }
            r9.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.u.b(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0104 }
            r1.putString(r9, r0)     // Catch:{ Exception -> 0x0104 }
            goto L_0x0104
        L_0x007e:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0104
        L_0x0084:
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0100 }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x0100 }
            if (r9 == 0) goto L_0x0104
            if (r1 == 0) goto L_0x0104
            java.lang.String r6 = r9.optString(r5)     // Catch:{ Exception -> 0x0100 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0100 }
            r8 = 0
            if (r7 != 0) goto L_0x00c8
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0100 }
            boolean r7 = android.text.TextUtils.equals(r7, r6)     // Catch:{ Exception -> 0x0100 }
            if (r7 != 0) goto L_0x00c8
            com.mbridge.msdk.foundation.same.a.l = r6     // Catch:{ Exception -> 0x0100 }
            com.mbridge.msdk.foundation.a.a.a r6 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0100 }
            r6.a((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x0100 }
            android.content.SharedPreferences r5 = r1.getSharedPreferences(r5, r8)     // Catch:{ Exception -> 0x0100 }
            if (r5 == 0) goto L_0x00c8
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.u.b(r3)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0100 }
            r5.putString(r3, r6)     // Catch:{ Exception -> 0x0100 }
            r5.apply()     // Catch:{ Exception -> 0x0100 }
        L_0x00c8:
            java.lang.String r9 = r9.optString(r4)     // Catch:{ Exception -> 0x0100 }
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0100 }
            if (r3 != 0) goto L_0x0104
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0100 }
            boolean r3 = android.text.TextUtils.equals(r3, r9)     // Catch:{ Exception -> 0x0100 }
            if (r3 != 0) goto L_0x0104
            com.mbridge.msdk.foundation.same.a.m = r9     // Catch:{ Exception -> 0x0100 }
            com.mbridge.msdk.foundation.a.a.a r9 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0100 }
            r9.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x0100 }
            android.content.SharedPreferences r9 = r1.getSharedPreferences(r9, r8)     // Catch:{ Exception -> 0x0100 }
            if (r9 == 0) goto L_0x0104
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r2)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0100 }
            r9.putString(r0, r1)     // Catch:{ Exception -> 0x0100 }
            r9.apply()     // Catch:{ Exception -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignUnit.getSysIDAndBKUPID(org.json.JSONObject):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0181 A[SYNTHETIC, Splitter:B:46:0x0181] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0321 A[Catch:{ Exception -> 0x03bd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.foundation.entity.CampaignUnit parseCampaignUnit(org.json.JSONObject r38, java.lang.String r39) {
        /*
            r0 = r38
            java.lang.String r1 = "ads"
            java.lang.String r2 = "template"
            java.lang.String r3 = "ad_type"
            java.lang.String r4 = "parent_session_id"
            java.lang.String r5 = "a"
            java.lang.String r6 = "encrypt_ecppv"
            java.lang.String r7 = "only_impression_url"
            java.lang.String r8 = "html_url"
            if (r0 == 0) goto L_0x03bf
            com.mbridge.msdk.foundation.entity.CampaignUnit r15 = new com.mbridge.msdk.foundation.entity.CampaignUnit     // Catch:{ Exception -> 0x03bf }
            r15.<init>()     // Catch:{ Exception -> 0x03bf }
            java.lang.String r10 = "rks"
            java.lang.String r10 = r0.optString(r10)     // Catch:{ Exception -> 0x03bc }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x03bc }
            if (r11 != 0) goto L_0x0051
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x004e }
            r11.<init>(r10)     // Catch:{ Exception -> 0x004e }
            java.util.Iterator r10 = r11.keys()     // Catch:{ Exception -> 0x004e }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x004e }
            r12.<init>()     // Catch:{ Exception -> 0x004e }
        L_0x0034:
            if (r10 == 0) goto L_0x004a
            boolean r13 = r10.hasNext()     // Catch:{ Exception -> 0x004e }
            if (r13 == 0) goto L_0x004a
            java.lang.Object r13 = r10.next()     // Catch:{ Exception -> 0x004e }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x004e }
            java.lang.String r14 = r11.optString(r13)     // Catch:{ Exception -> 0x004e }
            r12.put(r13, r14)     // Catch:{ Exception -> 0x004e }
            goto L_0x0034
        L_0x004a:
            r15.setRks(r12)     // Catch:{ Exception -> 0x004e }
            goto L_0x0051
        L_0x004e:
            r9 = r15
            goto L_0x03c0
        L_0x0051:
            boolean r10 = android.text.TextUtils.isEmpty(r39)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r11 = "encrypt_p"
            java.lang.String r12 = ""
            if (r10 != 0) goto L_0x006b
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x004e }
            r10.<init>()     // Catch:{ Exception -> 0x004e }
            r10.put(r11, r12)     // Catch:{ Exception -> 0x004e }
            java.lang.String r13 = "irlfa"
            r10.put(r13, r12)     // Catch:{ Exception -> 0x004e }
            r15.setEpMap(r10)     // Catch:{ Exception -> 0x004e }
        L_0x006b:
            java.lang.String r10 = "req_ext_data"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r13 = "nscpt"
            r14 = 1
            int r13 = r0.optInt(r13, r14)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r9 = "mof_template_url"
            java.lang.String r9 = r0.optString(r9, r12)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r14 = "mof_tplid"
            r18 = r9
            r9 = 0
            int r14 = r0.optInt(r14, r9)     // Catch:{ Exception -> 0x03bc }
            if (r10 == 0) goto L_0x008d
            java.lang.String r12 = r10.toString()     // Catch:{ Exception -> 0x004e }
        L_0x008d:
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ Exception -> 0x03bc }
            r10.<init>()     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "pv_urls"
            org.json.JSONArray r10 = r0.optJSONArray(r10)     // Catch:{ Exception -> 0x03bc }
            if (r10 == 0) goto L_0x00be
            int r19 = r10.length()     // Catch:{ Exception -> 0x004e }
            if (r19 <= 0) goto L_0x00be
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x004e }
            r20 = r12
            int r12 = r10.length()     // Catch:{ Exception -> 0x004e }
            r9.<init>(r12)     // Catch:{ Exception -> 0x004e }
            r21 = r13
            r12 = 0
        L_0x00ae:
            int r13 = r10.length()     // Catch:{ Exception -> 0x004e }
            if (r12 >= r13) goto L_0x00c3
            java.lang.String r13 = r10.getString(r12)     // Catch:{ Exception -> 0x004e }
            r9.add(r13)     // Catch:{ Exception -> 0x004e }
            int r12 = r12 + 1
            goto L_0x00ae
        L_0x00be:
            r20 = r12
            r21 = r13
            r9 = 0
        L_0x00c3:
            java.lang.String r10 = "replace_tmp"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x03bc }
            com.mbridge.msdk.foundation.db.a.a r12 = com.mbridge.msdk.foundation.db.a.a.a()     // Catch:{ Exception -> 0x03bc }
            r13 = 1
            r12.a(r10, r13)     // Catch:{ Exception -> 0x03bc }
            getSysIDAndBKUPID(r38)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = r0.optString(r5)     // Catch:{ Exception -> 0x03bc }
            r15.setSessionId(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = r0.optString(r4)     // Catch:{ Exception -> 0x03bc }
            r15.setParentSessionId(r10)     // Catch:{ Exception -> 0x03bc }
            int r10 = r0.optInt(r3)     // Catch:{ Exception -> 0x03bc }
            r15.setAdType(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "unit_size"
            java.lang.String r10 = r0.optString(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setUnitSize(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = r0.optString(r8)     // Catch:{ Exception -> 0x03bc }
            r15.setHtmlUrl(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = r0.optString(r7)     // Catch:{ Exception -> 0x03bc }
            r15.setOnlyImpressionUrl(r10)     // Catch:{ Exception -> 0x03bc }
            double r12 = r0.optDouble(r6)     // Catch:{ Exception -> 0x03bc }
            r15.setEcppv(r12)     // Catch:{ Exception -> 0x03bc }
            int r10 = r0.optInt(r2)     // Catch:{ Exception -> 0x03bc }
            r15.setTemplate(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "jm_do"
            int r10 = r0.optInt(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setJmDo(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "ia_icon"
            java.lang.String r10 = r0.optString(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setIa_icon(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "ia_rst"
            int r10 = r0.optInt(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setIa_rst(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "ia_url"
            java.lang.String r10 = r0.optString(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setIa_url(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "ia_ori"
            int r10 = r0.optInt(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setIa_ori(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "ia_all_ext1"
            java.lang.String r10 = r0.optString(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setIa_all_ext1(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "ia_all_ext2"
            java.lang.String r10 = r0.optString(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setIa_all_ext2(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "vcn"
            int r10 = r0.optInt(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setVcn(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "token_r"
            int r10 = r0.optInt(r10)     // Catch:{ Exception -> 0x03bc }
            r15.setTokenRule(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = r0.optString(r11)     // Catch:{ Exception -> 0x03bc }
            r15.setEncryptPrice(r10)     // Catch:{ Exception -> 0x03bc }
            org.json.JSONArray r13 = r0.optJSONArray(r1)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "frames"
            org.json.JSONArray r12 = r0.optJSONArray(r10)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r10 = "tk_tcp_port"
            r17 = r14
            java.lang.String r14 = "web env is not support"
            r16 = r14
            java.lang.String r14 = "end_screen_url"
            if (r12 == 0) goto L_0x02f9
            int r22 = r12.length()     // Catch:{ Exception -> 0x03bc }
            if (r22 <= 0) goto L_0x02f9
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x03bc }
            r13.<init>()     // Catch:{ Exception -> 0x03bc }
            r22 = r2
            r2 = 0
        L_0x018f:
            int r11 = r12.length()     // Catch:{ Exception -> 0x03bc }
            if (r2 >= r11) goto L_0x02f2
            org.json.JSONObject r11 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x03bc }
            r24 = r2
            org.json.JSONArray r2 = r11.getJSONArray(r1)     // Catch:{ Exception -> 0x03bc }
            r25 = r1
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x03bc }
            r1.<init>()     // Catch:{ Exception -> 0x03bc }
            r26 = r5
            r27 = r10
            r5 = 0
        L_0x01ab:
            int r10 = r2.length()     // Catch:{ Exception -> 0x03bc }
            if (r5 >= r10) goto L_0x028f
            org.json.JSONObject r10 = r2.optJSONObject(r5)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r28 = r0.optString(r7)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r29 = r0.optString(r8)     // Catch:{ Exception -> 0x03bc }
            java.lang.String r30 = r0.optString(r14)     // Catch:{ Exception -> 0x03bc }
            r31 = 0
            java.lang.String r32 = r0.optString(r6)     // Catch:{ Exception -> 0x03bc }
            r33 = r27
            r34 = r11
            r11 = r28
            r35 = r20
            r20 = r12
            r12 = r29
            r23 = r2
            r2 = r21
            r21 = r6
            r6 = r13
            r13 = r30
            r28 = r7
            r27 = r8
            r36 = r14
            r7 = r16
            r8 = r17
            r14 = r31
            r29 = r15
            r16 = r39
            r17 = r32
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaign(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x03b5 }
            if (r10 == 0) goto L_0x0262
            java.lang.String r11 = r29.getIa_url()     // Catch:{ Exception -> 0x039c }
            r10.setKeyIaUrl(r11)     // Catch:{ Exception -> 0x039c }
            int r11 = r29.getIa_ori()     // Catch:{ Exception -> 0x039c }
            r10.setKeyIaOri(r11)     // Catch:{ Exception -> 0x039c }
            int r11 = r29.getIa_rst()     // Catch:{ Exception -> 0x039c }
            r10.setKeyIaRst(r11)     // Catch:{ Exception -> 0x039c }
            java.lang.String r11 = r29.getIa_icon()     // Catch:{ Exception -> 0x039c }
            r10.setKeyIaIcon(r11)     // Catch:{ Exception -> 0x039c }
            int r11 = r0.optInt(r3)     // Catch:{ Exception -> 0x039c }
            r10.setAdType(r11)     // Catch:{ Exception -> 0x039c }
            java.lang.String r11 = "ia_ext1"
            java.lang.String r11 = r0.optString(r11)     // Catch:{ Exception -> 0x039c }
            r10.setIa_ext1(r11)     // Catch:{ Exception -> 0x039c }
            java.lang.String r11 = "ia_ext2"
            java.lang.String r11 = r0.optString(r11)     // Catch:{ Exception -> 0x039c }
            r10.setIa_ext2(r11)     // Catch:{ Exception -> 0x039c }
            int r11 = r29.getVcn()     // Catch:{ Exception -> 0x039c }
            r10.setVcn(r11)     // Catch:{ Exception -> 0x039c }
            int r11 = r29.getTokenRule()     // Catch:{ Exception -> 0x039c }
            r10.setTokenRule(r11)     // Catch:{ Exception -> 0x039c }
            java.lang.String r11 = r29.getEncryptPrice()     // Catch:{ Exception -> 0x039c }
            r10.setEncryptPrice(r11)     // Catch:{ Exception -> 0x039c }
            r10.setMof_tplid(r8)     // Catch:{ Exception -> 0x039c }
            r15 = r18
            r10.setMof_template_url(r15)     // Catch:{ Exception -> 0x039c }
            r10.setNscpt(r2)     // Catch:{ Exception -> 0x039c }
            r10.setPv_urls(r9)     // Catch:{ Exception -> 0x039c }
            r14 = r35
            r10.setReq_ext_data(r14)     // Catch:{ Exception -> 0x039c }
            r11 = r33
            r12 = 9377(0x24a1, float:1.314E-41)
            int r13 = r0.optInt(r11, r12)     // Catch:{ Exception -> 0x039c }
            r10.setTrackingTcpPort(r13)     // Catch:{ Exception -> 0x039c }
            r1.add(r10)     // Catch:{ Exception -> 0x039c }
            r10 = r29
            goto L_0x026f
        L_0x0262:
            r15 = r18
            r11 = r33
            r14 = r35
            r12 = 9377(0x24a1, float:1.314E-41)
            r10 = r29
            r10.setMsg(r7)     // Catch:{ Exception -> 0x03bd }
        L_0x026f:
            int r5 = r5 + 1
            r13 = r6
            r16 = r7
            r17 = r8
            r18 = r15
            r12 = r20
            r6 = r21
            r8 = r27
            r7 = r28
            r21 = r2
            r15 = r10
            r27 = r11
            r20 = r14
            r2 = r23
            r11 = r34
            r14 = r36
            goto L_0x01ab
        L_0x028f:
            r28 = r7
            r34 = r11
            r36 = r14
            r10 = r15
            r7 = r16
            r15 = r18
            r14 = r20
            r2 = r21
            r11 = r27
            r21 = r6
            r27 = r8
            r20 = r12
            r6 = r13
            r8 = r17
            r12 = 9377(0x24a1, float:1.314E-41)
            com.mbridge.msdk.out.Frame r5 = new com.mbridge.msdk.out.Frame     // Catch:{ Exception -> 0x03bd }
            r5.<init>()     // Catch:{ Exception -> 0x03bd }
            java.lang.String r13 = r0.optString(r4)     // Catch:{ Exception -> 0x03bd }
            r5.setParentSessionId(r13)     // Catch:{ Exception -> 0x03bd }
            r13 = r26
            java.lang.String r12 = r0.optString(r13)     // Catch:{ Exception -> 0x03bd }
            r5.setSessionId(r12)     // Catch:{ Exception -> 0x03bd }
            r5.setCampaigns(r1)     // Catch:{ Exception -> 0x03bd }
            r12 = r22
            r1 = r34
            int r1 = r1.optInt(r12)     // Catch:{ Exception -> 0x03bd }
            r5.setTemplate(r1)     // Catch:{ Exception -> 0x03bd }
            r6.add(r5)     // Catch:{ Exception -> 0x03bd }
            int r1 = r24 + 1
            r16 = r7
            r17 = r8
            r22 = r12
            r5 = r13
            r18 = r15
            r12 = r20
            r8 = r27
            r7 = r28
            r13 = r6
            r15 = r10
            r10 = r11
            r20 = r14
            r6 = r21
            r14 = r36
            r21 = r2
            r2 = r1
            r1 = r25
            goto L_0x018f
        L_0x02f2:
            r6 = r13
            r10 = r15
            r10.setListFrames(r6)     // Catch:{ Exception -> 0x03bd }
            goto L_0x03bd
        L_0x02f9:
            r28 = r7
            r27 = r8
            r11 = r10
            r36 = r14
            r10 = r15
            r7 = r16
            r8 = r17
            r15 = r18
            r14 = r20
            r2 = r21
            r21 = r6
            if (r13 == 0) goto L_0x03bd
            int r1 = r13.length()     // Catch:{ Exception -> 0x03bd }
            if (r1 <= 0) goto L_0x03bd
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x03bd }
            r1.<init>()     // Catch:{ Exception -> 0x03bd }
            r3 = 0
        L_0x031b:
            int r4 = r13.length()     // Catch:{ Exception -> 0x03bd }
            if (r3 >= r4) goto L_0x03b8
            org.json.JSONObject r4 = r13.optJSONObject(r3)     // Catch:{ Exception -> 0x03bd }
            r5 = r28
            java.lang.String r6 = r0.optString(r5)     // Catch:{ Exception -> 0x03bd }
            r12 = r27
            java.lang.String r16 = r0.optString(r12)     // Catch:{ Exception -> 0x03bd }
            r35 = r14
            r14 = r36
            java.lang.String r17 = r0.optString(r14)     // Catch:{ Exception -> 0x03bd }
            r18 = 0
            r36 = r14
            r14 = r21
            java.lang.String r19 = r0.optString(r14)     // Catch:{ Exception -> 0x03bd }
            r29 = r10
            r10 = r4
            r4 = r11
            r11 = r6
            r6 = r12
            r12 = r16
            r20 = r13
            r13 = r17
            r28 = r5
            r21 = r14
            r5 = r35
            r22 = r36
            r14 = r18
            r37 = r15
            r15 = r29
            r16 = r39
            r17 = r19
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaign(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x03b5 }
            if (r10 == 0) goto L_0x039f
            r10.setMof_tplid(r8)     // Catch:{ Exception -> 0x039c }
            r11 = r37
            r10.setMof_template_url(r11)     // Catch:{ Exception -> 0x039c }
            r10.setNscpt(r2)     // Catch:{ Exception -> 0x039c }
            r10.setPv_urls(r9)     // Catch:{ Exception -> 0x039c }
            r10.setReq_ext_data(r5)     // Catch:{ Exception -> 0x039c }
            int r12 = r29.getVcn()     // Catch:{ Exception -> 0x039c }
            r10.setVcn(r12)     // Catch:{ Exception -> 0x039c }
            int r12 = r29.getTokenRule()     // Catch:{ Exception -> 0x039c }
            r10.setTokenRule(r12)     // Catch:{ Exception -> 0x039c }
            java.lang.String r12 = r29.getEncryptPrice()     // Catch:{ Exception -> 0x039c }
            r10.setEncryptPrice(r12)     // Catch:{ Exception -> 0x039c }
            r12 = 9377(0x24a1, float:1.314E-41)
            int r13 = r0.optInt(r4, r12)     // Catch:{ Exception -> 0x039c }
            r10.setTrackingTcpPort(r13)     // Catch:{ Exception -> 0x039c }
            r1.add(r10)     // Catch:{ Exception -> 0x039c }
            r10 = r29
            goto L_0x03a8
        L_0x039c:
            r9 = r29
            goto L_0x03c0
        L_0x039f:
            r11 = r37
            r12 = 9377(0x24a1, float:1.314E-41)
            r10 = r29
            r10.setMsg(r7)     // Catch:{ Exception -> 0x03bd }
        L_0x03a8:
            int r3 = r3 + 1
            r14 = r5
            r27 = r6
            r15 = r11
            r13 = r20
            r36 = r22
            r11 = r4
            goto L_0x031b
        L_0x03b5:
            r10 = r29
            goto L_0x03bd
        L_0x03b8:
            r10.setAds(r1)     // Catch:{ Exception -> 0x03bd }
            goto L_0x03bd
        L_0x03bc:
            r10 = r15
        L_0x03bd:
            r9 = r10
            goto L_0x03c0
        L_0x03bf:
            r9 = 0
        L_0x03c0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignUnit.parseCampaignUnit(org.json.JSONObject, java.lang.String):com.mbridge.msdk.foundation.entity.CampaignUnit");
    }
}
