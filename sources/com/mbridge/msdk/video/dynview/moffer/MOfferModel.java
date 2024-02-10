package com.mbridge.msdk.video.dynview.moffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.cast.MediaTrack;
import com.ironsource.sdk.c.e;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.video.dynview.e.f;
import com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MOfferModel implements NoProGuard {
    private static final String TAG = "MOfferModel";
    private final String AD_NUM = "ad_num";
    private final String API_VERSION = "api_version";
    private final String APP_ID = "app_id";
    private final String CATEGORY = "category";
    private final String COUNTRY_CODE = "country_code";
    private final String CRT_CID = "crt_cid";
    private final String CRT_RID = "crt_rid";
    private final String DEFAULT_PATH_V3 = "/openapi/ad/v3";
    private final int DO_ACTION_IMPRESSION = 0;
    private final int DO_ACTION_ONLY_IMPRESSION = 1;
    private final String DY_VIEW = "dy_view";
    private final String E = e.a;
    private final String EC_ID = "ec_id";
    private final String H5_T = "h5_t";
    private final String H5_TYPE = "h5_type";
    private final String HTTP_REQ = "http_req";
    private final String IMEI = "imei";
    private final String I_FMD5 = "i_fmd5";
    private final String K = CampaignEx.JSON_KEY_AD_K;
    private final String MCC = ThroughputConfigUtil.SHARED_PREFS_KEY_MCC;
    private final String MNC = ThroughputConfigUtil.SHARED_PREFS_KEY_MNC;
    private final String MOF = "mof";
    private final String MOF_CALLBACK_DATE = "mcd";
    private final String MOF_DATA = "mof_data";
    private final String MOF_DOMAIN = "mof_domain";
    private final String MOF_PARENT_ID = "mof_parent_id";
    private final String MOF_T = "mof_t";
    private final String MOF_TEST_UID = "mof_testuid";
    private final String MOF_TYPE = "mof_type";
    private final String MOF_UID = "mof_uid";
    private final String MOF_VER = "mof_ver";
    private final String MORE_OFFER_CLICK = "more offer click";
    private final String MORE_OFFER_DEFAULT_APP_ID = "92762";
    private final String MORE_OFFER_DEFAULT_APP_KEY = "936dcbdd57fe235fd7cf61c2e93da3c4";
    private final String MORE_OFFER_DEFAULT_UNIT_ID = "117361";
    private final String MORE_OFFER_LOAD_FAILED = "more offer load failed";
    private final String MORE_OFFER_LOAD_SUCCESS = "more offer load success";
    private final String MORE_OFFER_SHOW = "more offer show";
    private final String MORE_OFFER_SHOW_FAILED = "more offer show fail";
    private final String OFFER_ID = "offer_id";
    private final String OFF_SET = TypedValues.CycleType.S_WAVE_OFFSET;
    private final String ONE_ID = "oneId";
    private final String ONLY_IMPRESSION = "only_impression";
    private final String PARENT_AD_TYPE = "parent_ad_type";
    private final String PARENT_EXCHANGE = "parent_exchange";
    private final String PARENT_ID = "parent_id";
    private final String PARENT_TEMPLATE_ID = "parent_template_id";
    private final String PARENT_UNIT = "parent_unit";
    private final String PING_MODE = "ping_mode";
    private final String RV_TID = "rv_tid";
    private final String R_ID = "r_id";
    private final String SIGN = MediaTrack.ROLE_SIGN;
    private final String TNUM = "tnum";
    private final String TP_LGP = "tplgp";
    private final String UC_PARENT_UNIT = "uc_parent_unit";
    private final String UNIT_ID = MBridgeConstans.PROPERTIES_UNIT_ID;
    private final String VALUE_AD_NUM = "20";
    private final String VALUE_API_VERSION = "2.3";
    private final String VALUE_CATEGORY = "0";
    private final String VALUE_COUNTRY_CODE = "CN";
    private final String VALUE_DEFAULT_VIDEO_TEMP_ID = "404";
    private final String VALUE_H5_TYPE = "1";
    private final String VALUE_HTTP_REQ = "2";
    private final String VALUE_MOF = "1";
    private final String VALUE_MOF_TYPE = "1";
    private final String VALUE_MOF_VER = "1";
    private final String VALUE_OFF_SET = "0";
    private final String VALUE_ONLY_IMPRESSION = "1";
    private final String VALUE_PING_MODE = "1";
    private final String VALUE_TNUM = "20";
    private final String V_FMD5 = "v_fmd5";
    /* access modifiers changed from: private */
    public int admf;
    /* access modifiers changed from: private */
    public int admftm;
    /* access modifiers changed from: private */
    public int bitmapSuccessCount = 0;
    /* access modifiers changed from: private */
    public List<Integer> cacheImpressionReportList;
    /* access modifiers changed from: private */
    public List<Integer> cacheOnlyImpressionReportList;
    /* access modifiers changed from: private */
    public volatile boolean hasReportMoreOfferLoad = false;
    /* access modifiers changed from: private */
    public volatile boolean hasReportMoreOfferShow = false;
    /* access modifiers changed from: private */
    public boolean isOnlyImpShow = false;
    /* access modifiers changed from: private */
    public boolean isShowMoreOffer;
    /* access modifiers changed from: private */
    public CampaignUnit mCampaignUnit;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mControlShowSize = 0;
    private int mFromType = 0;
    private List<Integer> mImpressionId = new ArrayList();
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayout;
    /* access modifiers changed from: private */
    public CampaignEx mMainOfferCampaignEx;
    /* access modifiers changed from: private */
    public f mMoreOfferLayoutListener;
    /* access modifiers changed from: private */
    public c mMoreOfferShowCallBack = new c() {
        public final void a(List<View> list) {
            TextView textView;
            if (MOfferModel.this.viewMofferLayout != null && (textView = (TextView) MOfferModel.this.viewMofferLayout.findViewById(MOfferModel.this.findID("mbridge_reward_end_card_like_tv"))) != null) {
                textView.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */
    public a mNotifyListener;
    /* access modifiers changed from: private */
    public ObservableScrollView mObservableScrollView;
    /* access modifiers changed from: private */
    public d mParam;
    /* access modifiers changed from: private */
    public String mRid;
    /* access modifiers changed from: private */
    public String mUnitId;
    private OnItemExposeListener onItemExposeListener = new OnItemExposeListener() {
        public final void onItemViewVisible(boolean z, int i) {
            if (MOfferModel.this.viewMofferLayout != null) {
                if (MOfferModel.this.viewMofferLayout.getVisibility() == 0) {
                    if (!MOfferModel.this.hasReportMoreOfferShow) {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, b.d().g(), "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        boolean unused = MOfferModel.this.hasReportMoreOfferShow = true;
                    }
                    try {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, i, 0, "117361");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (MOfferModel.this.cacheImpressionReportList == null) {
                        List unused2 = MOfferModel.this.cacheImpressionReportList = new ArrayList();
                    }
                    if (!MOfferModel.this.cacheImpressionReportList.contains(Integer.valueOf(i))) {
                        MOfferModel.this.cacheImpressionReportList.add(Integer.valueOf(i));
                    }
                }
            }
        }

        public final void onItemViewFirstVisible() {
            if (MOfferModel.this.viewMofferLayout != null && MOfferModel.this.isOnlyImpShow) {
                if (MOfferModel.this.viewMofferLayout.getVisibility() == 0) {
                    try {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, 0, 1, "117361");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (MOfferModel.this.cacheOnlyImpressionReportList == null) {
                        List unused = MOfferModel.this.cacheOnlyImpressionReportList = new ArrayList();
                    }
                    MOfferModel.this.cacheOnlyImpressionReportList.add(0);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public MBridgeRelativeLayout viewMofferLayout;

    static /* synthetic */ int access$2108(MOfferModel mOfferModel) {
        int i = mOfferModel.bitmapSuccessCount;
        mOfferModel.bitmapSuccessCount = i + 1;
        return i;
    }

    public void setFromType(int i) {
        this.mFromType = i;
    }

    public void setMoreOfferListener(f fVar, a aVar) {
        this.mMoreOfferLayoutListener = fVar;
        this.mNotifyListener = aVar;
    }

    public void buildMofferAd(CampaignEx campaignEx) {
        Context g = b.d().g();
        this.mContext = g;
        if (g != null) {
            this.mMainOfferCampaignEx = campaignEx;
            initView();
            initData();
        }
    }

    private void initData() {
        String str;
        CampaignEx campaignEx = this.mMainOfferCampaignEx;
        if (campaignEx != null && this.mContext != null) {
            buildRequestParams(campaignEx);
            if (this.mParam != null) {
                com.mbridge.msdk.video.dynview.f.b bVar = new com.mbridge.msdk.video.dynview.f.b(this.mContext);
                AnonymousClass3 r8 = new com.mbridge.msdk.video.dynview.f.a.a() {
                    public final void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, CampaignUnit campaignUnit) {
                        if (MOfferModel.this.mParam == null || campaignUnit == null) {
                            a.a().b();
                            return;
                        }
                        try {
                            MOfferModel mOfferModel = MOfferModel.this;
                            String unused = mOfferModel.mUnitId = mOfferModel.mParam.c().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                            MOfferModel mOfferModel2 = MOfferModel.this;
                            String unused2 = mOfferModel2.mRid = mOfferModel2.mParam.c().get("r_id");
                            if (campaignUnit.getAds() == null || campaignUnit.getAds().size() < 5) {
                                if (!MOfferModel.this.hasReportMoreOfferLoad) {
                                    com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, b.d().g(), "more offer load failed errorCode: -999 errorMsg: The campaign quantity less than 5.", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                    boolean unused3 = MOfferModel.this.hasReportMoreOfferLoad = true;
                                }
                                a.a().b();
                                return;
                            }
                            CampaignUnit unused4 = MOfferModel.this.mCampaignUnit = campaignUnit;
                            if (MOfferModel.this.admf > 0 && MOfferModel.this.admftm == 1) {
                                MOfferModel.this.doControllableImpOnRequest();
                            }
                            if (!MOfferModel.this.hasReportMoreOfferLoad) {
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, b.d().g(), "more offer load success", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                boolean unused5 = MOfferModel.this.hasReportMoreOfferLoad = true;
                            }
                            MOfferModel.this.createMoreOfferView();
                        } catch (Exception e) {
                            aa.d(MOfferModel.TAG, e.getMessage());
                            a.a().b();
                        }
                    }

                    public final void a(int i, String str) {
                        if (MOfferModel.this.mParam == null) {
                            a.a().b();
                            return;
                        }
                        try {
                            MOfferModel mOfferModel = MOfferModel.this;
                            String unused = mOfferModel.mUnitId = mOfferModel.mParam.c().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                            MOfferModel mOfferModel2 = MOfferModel.this;
                            String unused2 = mOfferModel2.mRid = mOfferModel2.mParam.c().get("r_id");
                            if (!MOfferModel.this.hasReportMoreOfferLoad) {
                                CampaignEx access$200 = MOfferModel.this.mMainOfferCampaignEx;
                                Context g = b.d().g();
                                com.mbridge.msdk.video.dynview.f.a.a(access$200, g, "more offer load failed errorCode:" + i + "errorMsg:" + str, MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                boolean unused3 = MOfferModel.this.hasReportMoreOfferLoad = true;
                            }
                            a.a().b();
                        } catch (Exception e) {
                            aa.d(MOfferModel.TAG, e.getMessage());
                            a.a().b();
                        }
                    }
                };
                String str2 = com.mbridge.msdk.foundation.same.net.g.d.a().t;
                if (!TextUtils.isEmpty(this.mMainOfferCampaignEx.getReq_ext_data())) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.mMainOfferCampaignEx.getReq_ext_data());
                        String optString = jSONObject.optString("mof_domain");
                        if (!TextUtils.isEmpty(optString)) {
                            str2 = optString + "/openapi/ad/v3";
                        }
                        String optString2 = jSONObject.optString("parent_id");
                        if (!TextUtils.isEmpty(optString2)) {
                            com.mbridge.msdk.foundation.same.net.g.b.a(this.mParam, "mof_parent_id", optString2);
                        }
                        String optString3 = jSONObject.optString("oneId");
                        if (!TextUtils.isEmpty(optString3)) {
                            com.mbridge.msdk.foundation.same.net.g.b.a(this.mParam, "oneId", optString3);
                        }
                        String optString4 = jSONObject.optString("mcd");
                        if (!TextUtils.isEmpty(optString4)) {
                            com.mbridge.msdk.foundation.same.net.g.b.a(this.mParam, "mcd", optString4);
                        }
                        r8.setUnitId(this.mMainOfferCampaignEx.getCampaignUnitId());
                    } catch (Exception e) {
                        aa.d(TAG, e.getMessage());
                        str = com.mbridge.msdk.foundation.same.net.g.d.a().t;
                    }
                }
                str = str2;
                bVar.getLoadOrSetting(1, str, this.mParam, new com.mbridge.msdk.foundation.same.net.b(), r8, true);
                doAdmfContorl();
            }
        }
    }

    private void doAdmfContorl() {
        JSONObject jSONObject;
        try {
            CampaignEx campaignEx = this.mMainOfferCampaignEx;
            if (campaignEx == null) {
                return;
            }
            if (!TextUtils.isEmpty(campaignEx.getMoreOfferJsonData())) {
                JSONObject jSONObject2 = new JSONObject(this.mMainOfferCampaignEx.getMoreOfferJsonData());
                int i = this.mFromType;
                if (i == 1) {
                    jSONObject = jSONObject2.getJSONObject("template_url");
                } else if (i != 2) {
                    jSONObject = null;
                } else {
                    jSONObject = jSONObject2.getJSONObject(CampaignEx.ENDCARD_URL);
                }
                if (jSONObject != null) {
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                        this.admftm = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                    }
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                        this.admf = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                    }
                }
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void doControllableImpOnRequest() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit != null) {
            try {
                com.mbridge.msdk.video.dynview.f.a.a(campaignUnit, 0, 1, "117361");
                this.isOnlyImpShow = true;
                if (this.mCampaignUnit.getAds() != null) {
                    int size = this.mCampaignUnit.getAds().size();
                    if (this.admf >= size) {
                        this.admf = size;
                    }
                    if (this.mImpressionId == null) {
                        this.mImpressionId = new ArrayList();
                    }
                    for (int i = 0; i < this.admf; i++) {
                        if (!this.mImpressionId.contains(Integer.valueOf(i))) {
                            com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, i, 0, "117361");
                            this.mImpressionId.add(Integer.valueOf(i));
                        }
                    }
                }
            } catch (Exception e) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    private void doControllableImpOnShow(int i) {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit != null && campaignUnit.getAds() != null) {
            try {
                int size = this.mCampaignUnit.getAds().size();
                if (this.mControlShowSize == 0) {
                    this.mControlShowSize = this.admf + i;
                }
                if (this.mControlShowSize >= size) {
                    this.mControlShowSize = size;
                }
                while (i < this.mControlShowSize) {
                    if (!this.mImpressionId.contains(Integer.valueOf(i))) {
                        com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, i, 0, "117361");
                        this.mImpressionId.add(Integer.valueOf(i));
                    }
                    i++;
                }
            } catch (Exception e) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x023e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void buildRequestParams(com.mbridge.msdk.foundation.entity.CampaignEx r29) {
        /*
            r28 = this;
            r1 = r28
            java.lang.String r0 = "CN"
            if (r29 != 0) goto L_0x0007
            return
        L_0x0007:
            com.mbridge.msdk.foundation.same.net.h.d r2 = new com.mbridge.msdk.foundation.same.net.h.d
            r2.<init>()
            r1.mParam = r2
            java.lang.String r2 = r29.getCampaignUnitId()
            java.lang.String r3 = r29.getId()
            java.lang.String r4 = r29.getRequestIdNotice()
            java.lang.String r5 = r29.getendcard_url()
            java.lang.String r6 = "mof_testuid"
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.al.a(r5, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x0034
            java.lang.String r5 = r29.getendcard_url()
            java.lang.String r6 = "mof_uid"
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.al.a(r5, r6)
        L_0x0034:
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r6 = r6.h()
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0059 }
            if (r7 != 0) goto L_0x005a
            com.mbridge.msdk.c.f r7 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0059 }
            com.mbridge.msdk.c.e r7 = r7.b(r6)     // Catch:{ Exception -> 0x0059 }
            if (r7 == 0) goto L_0x005a
            com.mbridge.msdk.c.f r7 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0059 }
            com.mbridge.msdk.c.e r7 = r7.b(r6)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r7 = r7.aH()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005b
        L_0x0059:
        L_0x005a:
            r7 = r0
        L_0x005b:
            java.lang.String r8 = r29.getendcard_url()
            java.lang.String r9 = "mcc"
            java.lang.String r8 = com.mbridge.msdk.foundation.tools.al.a(r8, r9)
            java.lang.String r10 = r29.getendcard_url()
            java.lang.String r11 = "mnc"
            java.lang.String r10 = com.mbridge.msdk.foundation.tools.al.a(r10, r11)
            java.lang.String r12 = r29.getendcard_url()
            java.lang.String r13 = "rv_tid"
            java.lang.String r12 = com.mbridge.msdk.foundation.tools.al.a(r12, r13)
            java.lang.String r14 = r29.getendcard_url()
            java.lang.String r15 = "ec_id"
            java.lang.String r14 = com.mbridge.msdk.foundation.tools.al.a(r14, r15)
            r16 = r0
            java.lang.String r0 = r29.getendcard_url()
            r17 = r15
            java.lang.String r15 = "tplgp"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r0, r15)
            r18 = r0
            java.lang.String r0 = r29.getendcard_url()
            r19 = r15
            java.lang.String r15 = "v_fmd5"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r0, r15)
            r20 = r0
            java.lang.String r0 = r29.getendcard_url()
            r21 = r15
            java.lang.String r15 = "i_fmd5"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r0, r15)
            r22 = r0
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            com.mbridge.msdk.foundation.controller.b r23 = com.mbridge.msdk.foundation.controller.b.d()
            r24 = r15
            java.lang.String r15 = r23.h()
            r23 = r12
            java.lang.String r12 = "app_id"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r12, r15)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r6)
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r6 = r6.j()
            r15.append(r6)
            java.lang.String r6 = r15.toString()
            java.lang.String r6 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r6)
            java.lang.String r15 = "sign"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r15, r6)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r25 = r15
            java.lang.String r15 = ""
            if (r6 == 0) goto L_0x00f6
            r26 = r12
            r6 = r15
            goto L_0x00f9
        L_0x00f6:
            r6 = r4
            r26 = r12
        L_0x00f9:
            java.lang.String r12 = "r_id"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r12, r6)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            r6 = 1
            java.lang.String[] r12 = new java.lang.String[r6]
            r27 = 0
            r12[r27] = r3
            java.lang.String r12 = java.util.Arrays.toString(r12)
            java.lang.String r6 = "e"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r12)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "mof_type"
            java.lang.String r12 = "1"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r12)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "h5_type"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r12)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "mof"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r12)
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0130
            r0 = r16
            goto L_0x0131
        L_0x0130:
            r0 = r7
        L_0x0131:
            com.mbridge.msdk.foundation.same.net.h.d r6 = r1.mParam
            java.lang.String r7 = "country_code"
            com.mbridge.msdk.foundation.same.net.g.b.a(r6, r7, r0)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "mof_ver"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r12)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "parent_exchange"
            r0.a(r6, r15)
            int r0 = r29.getAdType()
            r6 = 94
            if (r0 == r6) goto L_0x0157
            r6 = 287(0x11f, float:4.02E-43)
            if (r0 == r6) goto L_0x0154
            r0 = r15
            goto L_0x0159
        L_0x0154:
            java.lang.String r0 = "interstitial_video"
            goto L_0x0159
        L_0x0157:
            java.lang.String r0 = "rewarded_video"
        L_0x0159:
            com.mbridge.msdk.foundation.same.net.h.d r6 = r1.mParam
            java.lang.String r7 = "parent_ad_type"
            r6.a(r7, r0)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "oneId"
            java.lang.String r7 = r29.getReq_ext_data()
            r0.a(r6, r7)
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            java.lang.String r6 = "parent_template_id"
            if (r0 != 0) goto L_0x0179
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            r0.a(r6, r14)
            goto L_0x0180
        L_0x0179:
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r7 = "404"
            r0.a(r6, r7)
        L_0x0180:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x018f
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "uc_parent_unit"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r2)
            goto L_0x0196
        L_0x018f:
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r6 = "parent_unit"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r6, r2)
        L_0x0196:
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r11, r10)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r9, r8)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r0 = "crt_cid"
            r2.put(r0, r3)     // Catch:{ Exception -> 0x01da }
            java.lang.String r0 = "crt_rid"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01da }
            r0 = r23
            r2.put(r13, r0)     // Catch:{ Exception -> 0x01da }
            r0 = r17
            r2.put(r0, r14)     // Catch:{ Exception -> 0x01da }
            r0 = r18
            r4 = r19
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01da }
            r0 = r20
            r4 = r21
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01da }
            r0 = r22
            r4 = r24
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01da }
            java.lang.String r0 = "h5_t"
            r4 = 1
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01da }
            java.lang.String r0 = "mof_t"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01da }
            goto L_0x01de
        L_0x01da:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01de:
            java.lang.String r0 = r2.toString()
            com.mbridge.msdk.foundation.same.net.h.d r2 = r1.mParam
            java.lang.String r4 = "mof_data"
            com.mbridge.msdk.foundation.same.net.g.b.a(r2, r4, r0)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "imei"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r15)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "offer_id"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "offset"
            java.lang.String r3 = "0"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "category"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "only_impression"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r12)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "ping_mode"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r12)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "http_req"
            java.lang.String r3 = "2"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "ad_num"
            java.lang.String r3 = "20"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "tnum"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "api_version"
            java.lang.String r3 = "2.3"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r3)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0256
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "92762"
            r3 = r26
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r3, r2)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "92762936dcbdd57fe235fd7cf61c2e93da3c4"
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r2)
            r3 = r25
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r3, r2)
            java.lang.String r5 = "117361"
        L_0x0256:
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "unit_id"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r5)
            com.mbridge.msdk.foundation.same.net.h.d r0 = r1.mParam
            java.lang.String r2 = "dy_view"
            com.mbridge.msdk.foundation.same.net.g.b.a(r0, r2, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.moffer.MOfferModel.buildRequestParams(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    /* access modifiers changed from: private */
    public void createMoreOfferView() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit != null && this.mContext != null && campaignUnit.getAds() != null && this.mCampaignUnit.getAds().size() != 0) {
            setMoreOfferLayoutCallBack();
            createMoreOfferList();
        }
    }

    private void createMoreOfferList() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout != null) {
            this.mObservableScrollView = (ObservableScrollView) mBridgeRelativeLayout.findViewById(findID("mbridge_moreoffer_hls"));
            buildScrollViewGroup();
            addLikeTextView();
            showView();
        }
    }

    private void setMoreOfferLayoutCallBack() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout != null) {
            mBridgeRelativeLayout.setMoreOfferCacheReportCallBack(new b() {
                public final void a() {
                    try {
                        if (MOfferModel.this.cacheImpressionReportList != null) {
                            for (int i = 0; i < MOfferModel.this.cacheImpressionReportList.size(); i++) {
                                if (!MOfferModel.this.hasReportMoreOfferShow) {
                                    com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                    boolean unused = MOfferModel.this.hasReportMoreOfferShow = true;
                                }
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheImpressionReportList.get(i)).intValue(), 0, "117361");
                            }
                        }
                        if (MOfferModel.this.cacheOnlyImpressionReportList != null || !MOfferModel.this.isOnlyImpShow) {
                            for (int i2 = 0; i2 < MOfferModel.this.cacheOnlyImpressionReportList.size(); i2++) {
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheOnlyImpressionReportList.get(i2)).intValue(), 1, "117361");
                            }
                        }
                        MOfferModel.this.release();
                    } catch (Exception e) {
                        aa.d(MOfferModel.TAG, e.getMessage());
                    }
                }
            });
            this.viewMofferLayout.setMoreOfferShowFailedCallBack(new d() {
                public final void a() {
                    if (!(MOfferModel.this.viewMofferLayout == null || MOfferModel.this.viewMofferLayout.getVisibility() == 0)) {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show fail", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                    }
                    MOfferModel.this.release();
                }
            });
        }
    }

    private void buildScrollViewGroup() {
        if (this.mContext != null && this.viewMofferLayout != null && this.mMainOfferCampaignEx != null) {
            this.mLinearLayout = new LinearLayout(this.mContext);
            this.mLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
            this.mLinearLayout.setOrientation(0);
            this.mLinearLayout.setGravity(17);
            for (int i = 0; i < this.mCampaignUnit.ads.size(); i++) {
                View buildItemView = buildItemView(i);
                if (buildItemView != null) {
                    this.mLinearLayout.addView(buildItemView);
                }
            }
            this.mObservableScrollView.addView(this.mLinearLayout);
            this.mObservableScrollView.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    MOfferModel.this.checkViewVisiableState();
                    return false;
                }
            });
        }
    }

    private View buildItemView(final int i) {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        final View inflate = LayoutInflater.from(this.mContext).inflate(t.a(context, "mbridge_reward_end_card_more_offer_item", "layout"), (ViewGroup) null, false);
        int a = t.a(this.mContext, "mbridge_reward_end_card_item_iv", "id");
        if (inflate == null) {
            return null;
        }
        setOfferData(this.mCampaignUnit.getAds(), i, (RoundImageView) inflate.findViewById(a), (TextView) inflate.findViewById(t.a(this.mContext, "mbridge_reward_end_card_item_title_tv", "id")));
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CampaignEx campaignEx;
                try {
                    if (MOfferModel.this.mCampaignUnit != null && MOfferModel.this.mCampaignUnit.ads != null && MOfferModel.this.mCampaignUnit.ads.size() > 0 && (campaignEx = MOfferModel.this.mCampaignUnit.ads.get(i)) != null) {
                        if (MOfferModel.this.mNotifyListener != null) {
                            MOfferModel mOfferModel = MOfferModel.this;
                            mOfferModel.callBackClick(mOfferModel.mNotifyListener);
                        }
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, b.d().g(), "more offer click", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        com.mbridge.msdk.video.dynview.f.a.a(b.d().g(), campaignEx, MOfferModel.this.mUnitId, inflate);
                    }
                } catch (Exception e) {
                    aa.d(MOfferModel.TAG, e.getMessage());
                }
            }
        });
        return inflate;
    }

    private void setOfferData(List<CampaignEx> list, int i, final RoundImageView roundImageView, TextView textView) {
        CampaignEx campaignEx;
        if (roundImageView != null && textView != null && list != null && this.mContext != null && this.mMainOfferCampaignEx != null && list.size() > 0 && (campaignEx = list.get(i)) != null) {
            roundImageView.setImageDrawable((Drawable) null);
            com.mbridge.msdk.foundation.same.c.b.a(this.mContext).a(campaignEx.getIconUrl(), (c) new c() {
                public final void onFailedLoad(String str, String str2) {
                }

                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    try {
                        if (!(roundImageView == null || bitmap == null || bitmap.isRecycled())) {
                            roundImageView.setBorderRadius(13);
                            roundImageView.setImageBitmap(bitmap);
                        }
                        MOfferModel.access$2108(MOfferModel.this);
                        if (!MOfferModel.this.isShowMoreOffer && MOfferModel.this.bitmapSuccessCount >= 5 && MOfferModel.this.mMoreOfferShowCallBack != null) {
                            boolean unused = MOfferModel.this.isShowMoreOffer = true;
                            MOfferModel.this.mMoreOfferShowCallBack.a((List<View>) null);
                        }
                    } catch (Exception e) {
                        aa.d(MOfferModel.TAG, e.getMessage());
                    }
                }
            });
            if (!TextUtils.isEmpty(campaignEx.getAppName())) {
                String a = al.a(this.mMainOfferCampaignEx.getendcard_url(), "mof_textmod");
                if (TextUtils.isEmpty(a) || !a.equals("1")) {
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                } else if (textView != null) {
                    textView.setText(campaignEx.getAppName());
                }
            }
        }
    }

    public void showView() {
        CampaignUnit campaignUnit;
        f fVar = this.mMoreOfferLayoutListener;
        if (fVar != null) {
            MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
            if (mBridgeRelativeLayout == null || (campaignUnit = this.mCampaignUnit) == null) {
                fVar.a(-1, "more Offer create fail");
                return;
            }
            fVar.a((ViewGroup) mBridgeRelativeLayout, campaignUnit);
            if (!this.isOnlyImpShow) {
                com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, 0, 1, "117361");
            }
        }
    }

    private void initView() {
        Context context = this.mContext;
        if (context != null) {
            this.viewMofferLayout = (MBridgeRelativeLayout) LayoutInflater.from(this.mContext).inflate(t.a(context, "mbridge_reward_more_offer_view", "layout"), (ViewGroup) null, false);
        }
    }

    private void addLikeTextView() {
        TextView textView;
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout != null && (textView = (TextView) mBridgeRelativeLayout.findViewById(findID("mbridge_reward_end_card_like_tv"))) != null) {
            textView.setTextColor(Color.parseColor("#FF000000"));
            textView.setTextSize(10.0f);
            if (w.g(b.d().g()).contains("zh")) {
                textView.setEms(1);
                textView.getLayoutParams().width = af.b(b.d().g(), 30.0f);
                textView.setText("猜你喜欢");
            } else {
                textView.setText("Just\nfor\nYou");
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MOfferModel.this.mObservableScrollView != null) {
                        if (MOfferModel.this.mObservableScrollView.getVisibility() == 0) {
                            MOfferModel.this.mObservableScrollView.setVisibility(8);
                        } else {
                            MOfferModel.this.mObservableScrollView.setVisibility(0);
                        }
                    }
                    try {
                        new com.mbridge.msdk.video.dynview.h.b().a((View) MOfferModel.this.mLinearLayout, 300);
                    } catch (Exception e) {
                        aa.d(MOfferModel.TAG, e.getMessage());
                    }
                }
            });
        }
    }

    public void checkViewVisiableState() {
        if (this.mLinearLayout != null) {
            int i = 0;
            while (i < this.mLinearLayout.getChildCount()) {
                try {
                    setCallbackForLogicVisibleView(this.mLinearLayout.getChildAt(i), i);
                    i++;
                } catch (Exception e) {
                    aa.d(TAG, e.getMessage());
                    return;
                }
            }
        }
    }

    private void setCallbackForLogicVisibleView(View view, int i) {
        if (view != null) {
            try {
                Rect rect = new Rect();
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
                boolean z = rect.width() > view.getMeasuredWidth() / 5;
                if (globalVisibleRect && z) {
                    List<Integer> list = this.mImpressionId;
                    if (list != null && this.onItemExposeListener != null && !list.contains(Integer.valueOf(i))) {
                        this.mImpressionId.add(Integer.valueOf(i));
                        this.onItemExposeListener.onItemViewVisible(true, i);
                    }
                } else if (this.admf != 0) {
                    doControllableImpOnShow(i);
                }
            } catch (Exception e) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void callBackClick(a aVar) {
        if (aVar != null) {
            aVar.a(128, "");
        }
    }

    /* access modifiers changed from: private */
    public int findID(String str) {
        return t.a(b.d().g(), str, "id");
    }

    /* access modifiers changed from: private */
    public void release() {
        List<Integer> list = this.cacheImpressionReportList;
        if (list != null) {
            list.clear();
            this.cacheImpressionReportList = null;
        }
        List<Integer> list2 = this.cacheOnlyImpressionReportList;
        if (list2 != null) {
            list2.clear();
            this.cacheOnlyImpressionReportList = null;
        }
    }

    public void mofDestroy() {
        if (this.mMoreOfferLayoutListener != null) {
            this.mMoreOfferLayoutListener = null;
        }
        if (this.onItemExposeListener != null) {
            this.onItemExposeListener = null;
        }
        if (this.mMoreOfferShowCallBack != null) {
            this.mMoreOfferShowCallBack = null;
        }
    }
}
