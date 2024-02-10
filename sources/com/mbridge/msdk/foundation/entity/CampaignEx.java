package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.system.NoProGuard;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CampaignEx extends DomainCampaignEx implements NoProGuard, Serializable {
    public static final int CAMPAIN_NV_T2_VALUE_3 = 3;
    public static final int CAMPAIN_NV_T2_VALUE_4 = 4;
    public static final String CLICKMODE_ON = "5";
    public static final int CLICK_TIMEOUT_INTERVAL_DEFAULT_VALUE = 2;
    public static final int C_UA_DEFAULT_VALUE = 1;
    private static final int DEFAULT_READY_RATE = 100;
    public static final String ENDCARD_URL = "endcard_url";
    public static final int FLAG_DEFAULT_SPARE_OFFER = -1;
    public static final int FLAG_IS_SPARE_OFFER = 1;
    public static final int FLAG_NOT_SPARE_OFFER = 0;
    public static final int IMP_UA_DEFAULT_VALUE = 1;
    public static final String JSON_AD_IMP_KEY = "sec";
    public static final String JSON_AD_IMP_VALUE = "url";
    public static final String JSON_KEY_AAB = "aab";
    public static final String JSON_KEY_ADVIMP = "adv_imp";
    public static final String JSON_KEY_AD_AKS = "aks";
    public static final String JSON_KEY_AD_AL = "al";
    public static final String JSON_KEY_AD_HTML = "ad_html";
    public static final String JSON_KEY_AD_K = "k";
    public static final String JSON_KEY_AD_MP = "mp";
    public static final String JSON_KEY_AD_Q = "q";
    public static final String JSON_KEY_AD_R = "r";
    public static final String JSON_KEY_AD_SOURCE_ID = "ad_source_id";
    public static final String JSON_KEY_AD_TMP_IDS = "tmp_ids";
    public static final String JSON_KEY_AD_TRACKING_DROPOUT_TRACK = "dropout_track";
    public static final String JSON_KEY_AD_TRACKING_IMPRESSION_T2 = "impression_t2";
    public static final String JSON_KEY_AD_TRACKING_PLYCMPT_TRACK = "plycmpt_track";
    public static final String JSON_KEY_AD_URL_LIST = "ad_url_list";
    public static final String JSON_KEY_AD_ZIP = "ad_tpl_url";
    public static final String JSON_KEY_APP_SIZE = "app_size";
    public static final String JSON_KEY_BANNER_HTML = "banner_html";
    public static final String JSON_KEY_BANNER_URL = "banner_url";
    public static final String JSON_KEY_BTY = "ctype";
    public static final String JSON_KEY_CAMPAIGN_UNITID = "unitId";
    public static final String JSON_KEY_CLICK_INTERVAL = "c_ct";
    public static final String JSON_KEY_CLICK_MODE = "click_mode";
    public static final String JSON_KEY_CLICK_TIMEOUT_INTERVAL = "c_toi";
    public static final String JSON_KEY_CLICK_URL = "click_url";
    public static final String JSON_KEY_CREATIVE_ID = "creative_id";
    public static final String JSON_KEY_CTA_TEXT = "ctatext";
    public static final String JSON_KEY_C_UA = "c_ua";
    public static final String JSON_KEY_DEEP_LINK_URL = "deep_link";
    public static final String JSON_KEY_DESC = "desc";
    public static final String JSON_KEY_ECPPV = "encrypt_ecppv";
    public static final String JSON_KEY_EC_CREATIVE_ID = "ec_crtv_id";
    public static final String JSON_KEY_EC_TEMP_ID = "ec_temp_id";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_ENDCARD_CLICK = "endcard_click_result";
    public static final String JSON_KEY_EXT_DATA = "ext_data";
    public static final String JSON_KEY_FAC = "fac";
    public static final String JSON_KEY_FCA = "fca";
    public static final String JSON_KEY_FCB = "fcb";
    public static final String JSON_KEY_FLB = "flb";
    public static final String JSON_KEY_FLB_SKIP_TIME = "flb_skiptime";
    public static final String JSON_KEY_GIF_URL = "gif_url";
    public static final String JSON_KEY_GUIDELINES = "guidelines";
    public static final String JSON_KEY_HASMBTPLMARK = "hasMBTplMark";
    public static final String JSON_KEY_HB = "hb";
    public static final String JSON_KEY_ICON_URL = "icon_url";
    public static final String JSON_KEY_ID = "id";
    public static final String JSON_KEY_IMAGE_SIZE = "image_size";
    public static final String JSON_KEY_IMAGE_URL = "image_url";
    public static final String JSON_KEY_IMPRESSION_URL = "impression_url";
    public static final String JSON_KEY_IMP_REPORT_TYPE = "imp_report_type";
    public static final String JSON_KEY_IMP_UA = "imp_ua";
    public static final String JSON_KEY_JM_PD = "jm_pd";
    public static final String JSON_KEY_LANDING_TYPE = "landing_type";
    public static final String JSON_KEY_LINK_TYPE = "link_type";
    public static final String JSON_KEY_LOCAL_REQUEST_ID = "local_rid";
    public static final String JSON_KEY_MAITVE = "maitve";
    public static final String JSON_KEY_MAITVESRC = "maitve_src";
    public static final String JSON_KEY_MRAID = "mraid";
    public static final String JSON_KEY_MRAIDFORH5 = "mraid_src";
    public static final String JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T = "adspace_t";
    public static final String JSON_KEY_NEW_INTERSTITIAL_CBD = "cbd";
    public static final String JSON_KEY_NEW_INTERSTITIAL_VST = "vst";
    public static final String JSON_KEY_NOTICE_URL = "notice_url";
    public static final String JSON_KEY_NUMBER_RATING = "number_rating";
    public static final String JSON_KEY_NV_T2 = "nv_t2";
    public static final String JSON_KEY_OFFER_TYPE = "offer_type";
    public static final String JSON_KEY_PACKAGE_NAME = "package_name";
    public static final String JSON_KEY_PLCT = "plct";
    public static final String JSON_KEY_PLCTB = "plctb";
    public static final String JSON_KEY_PRIVACY_URL = "privacy_url";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_READY_RATE = "ready_rate";
    public static final String JSON_KEY_RETARGET_OFFER = "retarget_offer";
    public static final String JSON_KEY_RETARGET_TYPE = "rtins_type";
    public static final String JSON_KEY_REWARD_AMOUNT = "reward_amount";
    public static final String JSON_KEY_REWARD_NAME = "reward_name";
    public static final String JSON_KEY_REWARD_PLUS = "rw_pl";
    public static final String JSON_KEY_REWARD_TEMPLATE = "rv";
    public static final String JSON_KEY_REWARD_VIDEO_MD5 = "md5_file";
    public static final String JSON_KEY_RS_IGNORE_CHECK_RULE = "rs_ignc_r";
    public static final String JSON_KEY_STAR = "rating";
    public static final String JSON_KEY_ST_IEX = "iex";
    public static final String JSON_KEY_ST_TS = "ts";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TIMESTAMP = "timestamp";
    public static final String JSON_KEY_TITLE = "title";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_TP_OFFER = "tp_offer";
    public static final String JSON_KEY_T_IMP = "t_imp";
    public static final String JSON_KEY_USER_ACTIVATION = "user_activation";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String JSON_KEY_VIDEO_CHECK_TYPE = "vck_t";
    public static final String JSON_KEY_VIDEO_COMPLETE_TIME = "view_com_time";
    public static final String JSON_KEY_VIDEO_CREATIVE_ID = "vid_crtv_id";
    public static final String JSON_KEY_VIDEO_CTN_TYPE = "vctn_t";
    public static final String JSON_KEY_VIDEO_LENGTHL = "video_length";
    public static final String JSON_KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String JSON_KEY_VIDEO_SIZE = "video_size";
    public static final String JSON_KEY_VIDEO_URL = "video_url";
    public static final String JSON_KEY_WATCH_MILE = "watch_mile";
    public static final String JSON_KEY_WITHOUT_INSTALL_CHECK = "wtick";
    public static final String JSON_NATIVE_VIDEO_AD_TRACKING = "ad_tracking";
    public static final String JSON_NATIVE_VIDEO_CLICK = "click";
    public static final String JSON_NATIVE_VIDEO_CLOSE = "close";
    public static final String JSON_NATIVE_VIDEO_COMPLETE = "complete";
    public static final String JSON_NATIVE_VIDEO_ENDCARD = "endcard";
    public static final String JSON_NATIVE_VIDEO_ENDCARD_SHOW = "endcard_show";
    public static final String JSON_NATIVE_VIDEO_ERROR = "error";
    public static final String JSON_NATIVE_VIDEO_FIRST_QUARTILE = "first_quartile";
    public static final String JSON_NATIVE_VIDEO_MIDPOINT = "midpoint";
    public static final String JSON_NATIVE_VIDEO_MUTE = "mute";
    public static final String JSON_NATIVE_VIDEO_PAUSE = "pause";
    public static final String JSON_NATIVE_VIDEO_PLAY_PERCENTAGE = "play_percentage";
    public static final String JSON_NATIVE_VIDEO_RESUME = "resume";
    public static final String JSON_NATIVE_VIDEO_START = "start";
    public static final String JSON_NATIVE_VIDEO_THIRD_QUARTILE = "third_quartile";
    public static final String JSON_NATIVE_VIDEO_UNMUTE = "unmute";
    public static final String JSON_NATIVE_VIDEO_VIDEO_CLICK = "video_click";
    public static final String JSON_NATIVE_VIDOE_IMPRESSION = "impression";
    public static final String KEY_ADCHOICE = "adchoice";
    public static final String KEY_AD_TYPE = "ad_type";
    public static final String KEY_IA_CACHE = "ia_cache";
    public static final String KEY_IA_EXT1 = "ia_ext1";
    public static final String KEY_IA_EXT2 = "ia_ext2";
    public static final String KEY_IA_ICON = "ia_icon";
    public static final String KEY_IA_ORI = "ia_ori";
    public static final String KEY_IA_RST = "ia_rst";
    public static final String KEY_IA_URL = "ia_url";
    public static final String KEY_IS_CMPT_ENTRY = "cmpt=1";
    public static final String KEY_IS_DOWNLOAD = "is_download_zip";
    public static final String KEY_OC_TIME = "oc_time";
    public static final String KEY_OC_TYPE = "oc_type";
    public static final String KEY_OMID = "omid";
    public static final String KEY_T_LIST = "t_list";
    public static final int LANDING_TYPE_VALUE_OPEN_BROWSER = 1;
    public static final int LANDING_TYPE_VALUE_OPEN_GP_BY_PACKAGE = 3;
    public static final int LANDING_TYPE_VALUE_OPEN_WEBVIEW = 2;
    public static final int LINK_TYPE_1 = 1;
    public static final int LINK_TYPE_2 = 2;
    public static final int LINK_TYPE_3 = 3;
    public static final int LINK_TYPE_4 = 4;
    public static final int LINK_TYPE_8 = 8;
    public static final int LINK_TYPE_9 = 9;
    public static final int LINK_TYPE_MINI_PROGRAM = 12;
    public static final int NEW_INTERSTITIAL_DEFAULT_AD_SPACE_T = 1;
    public static final int NEW_INTERSTITIAL_DEFAULT_CBD = -2;
    public static final int NEW_INTERSTITIAL_DEFAULT_VST = -2;
    public static final String PLAYABLE_ADS_WITHOUT_VIDEO = "playable_ads_without_video";
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_DEFAULT = 1;
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_ENDCARD = 2;
    public static final String PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH = "show_privacy_btn";
    public static final int RETAR_GETING_IS = 1;
    public static final int RETAR_GETING_NOT = 2;
    public static final int RTINS_TYPE_DONE = 1;
    public static final int RTINS_TYPE_NOT_DONE = 2;
    public static final String TAG = "CampaignEx";
    public static final String URL_KEY_EXP_IDS = "exp_ids";
    public static final String VIDEO_END_TYPE = "video_end_type";
    public static final int VIDEO_END_TYPE_BROWSER = 5;
    public static final int VIDEO_END_TYPE_DEFAULT = 2;
    public static final int VIDEO_END_TYPE_FINISH = 1;
    public static final int VIDEO_END_TYPE_NATIVE = 100;
    public static final int VIDEO_END_TYPE_REULSE = 2;
    public static final int VIDEO_END_TYPE_VAST = 3;
    public static final int VIDEO_END_TYPE_WEBVIEW = 4;
    private static final long serialVersionUID = 1;
    private String CMPTEntryUrl;
    private AabEntity aabEntity;
    private String adHtml = "";
    private int adSpaceT;
    private int adType;
    private String adZip = "";
    private String ad_url_list;
    private a adchoice;
    private String advImp;
    private HashMap<String, String> aks;
    private String al;
    private String bannerHtml = "";
    private String bannerUrl = "";
    private String bidToken = "";
    private int bty;
    private int cUA = 1;
    private long cVersionCode;
    private int cacheLevel;
    private boolean campaignIsFiltered = false;
    private String campaignUnitId;
    private boolean canStart2C1Anim = false;
    private boolean canStartMoreOfferAnim = false;
    private int cbd = -2;
    private int cbt;
    private int clickInterval;
    private int clickTimeOutInterval = 2;
    private String clickURL = "";
    private String click_mode;
    private String deepLinkUrl = "";
    private int dynamicTempCode = 0;
    private long ecCrtvId = 0;
    private long ecTemplateId = 0;
    private String ecppv;
    private String encryptPrice = "";
    private String endScreenUrl;
    private int endcard_click_result;
    private String endcard_url;
    private String errReasonByDefaultAd;
    private int errTypeByDefaultAd = -1;
    private String expIds;
    private String ext_data;
    private int fac = 0;
    private int fca;
    private int fcb;
    private int flb;
    private int flbSkipTime;
    private String gifUrl;
    private String guidelines;
    private boolean hasMBTplMark;
    private boolean hasReportAdTrackPause = false;
    private String htmlUrl;
    private String ia_ext1;
    private String ia_ext2;
    private int iex;
    private String imageSize = "";
    private int impReportType = 0;
    private int impUA = 1;
    private String impressionURL = "";
    private String interactiveCache;
    private int isAddSuccesful;
    private boolean isBidCampaign;
    private boolean isCallBackImpression = false;
    private boolean isCallbacked;
    private int isClick;
    private int isDeleted;
    private int isDownLoadZip;
    private boolean isDynamicView = false;
    private boolean isMraid;
    private boolean isReady = false;
    private boolean isReport;
    private boolean isReportClick;
    public boolean isRewardPopViewShowed = false;
    private int isTimeoutCheckVideoStatus = -1;
    private int jmPd;
    private JumpLoaderResult jumpResult;
    private String k;
    private String keyIaIcon;
    private int keyIaOri;
    private int keyIaRst;
    private String keyIaUrl;
    private String label;
    private String landingType;
    private int linkType;
    private int loadTimeoutState = 0;
    private String localRequestId;
    public boolean mMoreOfferImpShow = false;
    private int maitve;
    private String maitve_src;
    private b mediaViewHolder;
    private String mof_template_url;
    private int mof_tplid;
    private String moreOfferJsonData = "";
    private String mp;
    private String mraid;
    private String n_lrid;
    private String n_rid;
    private j nativeVideoTracking;
    private String nativeVideoTrackingString;
    private String noticeUrl = "";
    private int nscpt = 1;
    private int nvT2 = 6;
    private int oc_time;
    private int oc_type = 0;
    private int offerType;
    private String omid = null;
    private String onlyImpressionURL = "";
    private String pkgSource;
    private String placementId;
    private int playable_ads_without_video = 1;
    private long plct = 0;
    private long plctb = 0;
    private int privacyButtonTemplateVisibility = 0;
    private String privacyUrl = "";
    private List<String> pv_urls;
    private String q;
    private String r;
    private int readyState = 1;
    private int ready_rate = -1;
    private String req_ext_data;
    private String requestId;
    private String requestIdNotice;
    private int retarget_offer;
    private int rewardAmount;
    private int rewardPlayStatus;
    public RewardPlus rewardPlus;
    private c rewardTemplateMode;
    private String reward_name;
    private ArrayList<Integer> rsIgnoreCheckRule;
    private int rtinsType;
    private int showCount;
    private int spareOfferFlag = -1;
    private int t_imp;
    private String t_list;
    private int tab = -1;
    private int template;
    private int tokenRule = 0;
    private int tpOffer = 0;
    private int trackingTcpPort = 9377;
    private long ts;
    private boolean userActivation = false;
    private int vcn = 0;
    private long vidCrtvId = 0;
    private int videoCheckType = 2;
    private int videoCompleteTime = 0;
    private int videoCtnType = 1;
    public String videoMD5Value = "";
    private int videoPlayProgress = 0;
    private String videoResolution;
    private int videoSize;
    private String videoUrlEncode = "";
    private int video_end_type = 2;
    private int vst = -2;
    private int watchMile;
    private int wtick = 0;

    public static final class b implements Serializable {
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public Map<Integer, String> l;
    }

    public int getPrivacyButtonTemplateVisibility() {
        return this.privacyButtonTemplateVisibility;
    }

    public void setPrivacyButtonTemplateVisibility(int i) {
        this.privacyButtonTemplateVisibility = i;
    }

    public int getTpOffer() {
        return this.tpOffer;
    }

    public void setTpOffer(int i) {
        this.tpOffer = i;
    }

    public int getFac() {
        return this.fac;
    }

    public void setFac(int i) {
        this.fac = i;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public void setAdZip(String str) {
        this.adZip = str;
        boolean i = af.i(str);
        int l = af.l(str);
        if (i) {
            setDynamicView(true);
            setDynamicTempCode(l);
        }
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setPv_urls(List<String> list) {
        this.pv_urls = list;
    }

    public List<String> getPv_urls() {
        return this.pv_urls;
    }

    public int getReadyState() {
        return this.readyState;
    }

    public int getShowCount() {
        return this.showCount;
    }

    public void setShowCount(int i) {
        this.showCount = i;
    }

    public String getEcppv() {
        return this.ecppv;
    }

    public void setEcppv(String str) {
        this.ecppv = str;
    }

    public String getNRid() {
        return this.n_rid;
    }

    public void setNRid(String str) {
        this.n_rid = str;
    }

    public String getNLRid() {
        return this.n_lrid;
    }

    public void setNLRid(String str) {
        this.n_lrid = str;
    }

    public int getErrTypeByDefaultAd() {
        return this.errTypeByDefaultAd;
    }

    public void setErrTypeByDefaultAd(int i) {
        this.errTypeByDefaultAd = i;
    }

    public String getErrReasonByDefaultAd() {
        return this.errReasonByDefaultAd;
    }

    public void setErrReasonByDefaultAd(String str) {
        this.errReasonByDefaultAd = str;
    }

    public int getImpReportType() {
        return this.impReportType;
    }

    public void setImpReportType(int i) {
        this.impReportType = i;
        if (i == 1) {
            int i2 = this.adType;
            if (i2 == 296 || i2 == 42) {
                String impressionURL2 = getImpressionURL();
                String onlyImpressionURL2 = getOnlyImpressionURL();
                if (!TextUtils.isEmpty(impressionURL2) && !impressionURL2.contains(JSON_KEY_IMP_REPORT_TYPE)) {
                    setImpressionURL(impressionURL2 + "&imp_report_type=" + i);
                }
                if (!TextUtils.isEmpty(onlyImpressionURL2) && !onlyImpressionURL2.contains(JSON_KEY_IMP_REPORT_TYPE)) {
                    setOnlyImpressionURL(onlyImpressionURL2 + "&imp_report_type=" + i);
                }
            }
        }
    }

    public int getAdSpaceT() {
        return this.adSpaceT;
    }

    public void setAdSpaceT(int i) {
        this.adSpaceT = i;
    }

    public int getCbd() {
        return this.cbd;
    }

    public void setCbd(int i) {
        this.cbd = i;
    }

    public int getVst() {
        return this.vst;
    }

    public void setVst(int i) {
        this.vst = i;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public int getVideoCompleteTime() {
        return this.videoCompleteTime;
    }

    public void setVideoCompleteTime(int i) {
        this.videoCompleteTime = i;
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
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    public boolean isDynamicView() {
        return this.isDynamicView;
    }

    public void setDynamicView(boolean z) {
        this.isDynamicView = z;
    }

    public int getDynamicTempCode() {
        return this.dynamicTempCode;
    }

    public void setDynamicTempCode(int i) {
        this.dynamicTempCode = af.b(i);
    }

    public boolean isCampaignIsFiltered() {
        return this.campaignIsFiltered;
    }

    public void setCampaignIsFiltered(boolean z) {
        this.campaignIsFiltered = z;
    }

    public int getSpareOfferFlag() {
        return this.spareOfferFlag;
    }

    public void setSpareOfferFlag(int i) {
        this.spareOfferFlag = i;
    }

    public long getPlct() {
        return this.plct;
    }

    public void setPlct(long j) {
        this.plct = j;
    }

    public long getPlctb() {
        return this.plctb;
    }

    public void setPlctb(long j) {
        this.plctb = j;
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

    public long getVidCrtvId() {
        return this.vidCrtvId;
    }

    public void setVidCrtvId(long j) {
        this.vidCrtvId = j;
    }

    public long getEcCrtvId() {
        return this.ecCrtvId;
    }

    public void setEcCrtvId(long j) {
        this.ecCrtvId = j;
    }

    public long getEcTemplateId() {
        return this.ecTemplateId;
    }

    public void setEcTemplateId(long j) {
        this.ecTemplateId = j;
    }

    public boolean isHasMBTplMark() {
        return this.hasMBTplMark;
    }

    public void setHasMBTplMark(boolean z) {
        this.hasMBTplMark = z;
    }

    public int getFlb() {
        return this.flb;
    }

    public void setFlb(int i) {
        this.flb = i;
    }

    public int getFlbSkipTime() {
        return this.flbSkipTime;
    }

    public void setFlbSkipTime(int i) {
        this.flbSkipTime = i;
    }

    public a getAdchoice() {
        return this.adchoice;
    }

    public void setAdchoice(a aVar) {
        this.adchoice = aVar;
    }

    public RewardPlus getRewardPlus() {
        return this.rewardPlus;
    }

    public void setRewardPlus(RewardPlus rewardPlus2) {
        this.rewardPlus = rewardPlus2;
    }

    public int getOc_type() {
        return this.oc_type;
    }

    public void setOc_type(int i) {
        this.oc_type = i;
    }

    public int getOc_time() {
        return this.oc_time;
    }

    public void setOc_time(int i) {
        this.oc_time = i;
    }

    public String getT_list() {
        return this.t_list;
    }

    public void setT_list(String str) {
        this.t_list = str;
    }

    public String getInteractiveCache() {
        return this.interactiveCache;
    }

    public void setInteractiveCache(String str) {
        this.interactiveCache = str;
    }

    public int getIsDownLoadZip() {
        return this.isDownLoadZip;
    }

    public void setIsDownLoadZip(int i) {
        this.isDownLoadZip = i;
    }

    public String getMoreOfferJsonData() {
        return this.moreOfferJsonData;
    }

    public int getAdType() {
        return this.adType;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public String getIa_ext1() {
        return this.ia_ext1;
    }

    public void setIa_ext1(String str) {
        this.ia_ext1 = str;
    }

    public String getIa_ext2() {
        return this.ia_ext2;
    }

    public void setIa_ext2(String str) {
        this.ia_ext2 = str;
    }

    public String getKeyIaIcon() {
        return this.keyIaIcon;
    }

    public void setKeyIaIcon(String str) {
        this.keyIaIcon = str;
    }

    public int getKeyIaRst() {
        return this.keyIaRst;
    }

    public void setKeyIaRst(int i) {
        this.keyIaRst = i;
    }

    public String getKeyIaUrl() {
        return this.keyIaUrl;
    }

    public void setKeyIaUrl(String str) {
        this.keyIaUrl = str;
    }

    public int getKeyIaOri() {
        return this.keyIaOri;
    }

    public void setKeyIaOri(int i) {
        this.keyIaOri = i;
    }

    public int getIsAddSuccesful() {
        return this.isAddSuccesful;
    }

    public void setIsAddSuccesful(int i) {
        this.isAddSuccesful = i;
    }

    public int getJmPd() {
        return this.jmPd;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public void setIsClick(int i) {
        this.isClick = i;
    }

    public void setJmPd(int i) {
        this.jmPd = i;
    }

    public int getNvT2() {
        return this.nvT2;
    }

    public void setNvT2(int i) {
        this.nvT2 = i;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public String getExpIds() {
        return this.expIds;
    }

    public void setExpIds(String str) {
        this.expIds = str;
    }

    public int getRtinsType() {
        return this.rtinsType;
    }

    public void setRtinsType(int i) {
        this.rtinsType = i;
    }

    public HashMap<String, String> getAks() {
        return this.aks;
    }

    public void setAks(HashMap<String, String> hashMap) {
        this.aks = hashMap;
    }

    public String getK() {
        return this.k;
    }

    public void setK(String str) {
        this.k = str;
    }

    public String getQ() {
        return this.q;
    }

    public void setQ(String str) {
        this.q = str;
    }

    public String getR() {
        return this.r;
    }

    public void setR(String str) {
        this.r = str;
    }

    public String getAl() {
        return this.al;
    }

    public void setAl(String str) {
        this.al = str;
    }

    public String getMp() {
        return this.mp;
    }

    public void setMp(String str) {
        this.mp = str;
    }

    public boolean isBidCampaign() {
        return this.isBidCampaign;
    }

    public void setIsBidCampaign(boolean z) {
        this.isBidCampaign = z;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public int getEndcard_click_result() {
        return this.endcard_click_result;
    }

    public void setEndcard_click_result(int i) {
        this.endcard_click_result = i;
    }

    public int getImpUA() {
        return this.impUA;
    }

    public void setImpUA(int i) {
        this.impUA = i;
    }

    public int getcUA() {
        return this.cUA;
    }

    public void setcUA(int i) {
        this.cUA = i;
    }

    public String getVideoMD5Value() {
        return this.videoMD5Value;
    }

    public void setVideoMD5Value(String str) {
        this.videoMD5Value = str;
    }

    public int getVideo_end_type() {
        return this.video_end_type;
    }

    public void setVideo_end_type(int i) {
        this.video_end_type = i;
    }

    public String getMraid() {
        return this.mraid;
    }

    public void setMraid(String str) {
        this.mraid = str;
    }

    public boolean isMraid() {
        return this.isMraid;
    }

    public void setIsMraid(boolean z) {
        this.isMraid = z;
    }

    public String getendcard_url() {
        return this.endcard_url;
    }

    public void setendcard_url(String str) {
        c cVar;
        this.endcard_url = str;
        if (TextUtils.isEmpty(this.mof_template_url) && (((cVar = this.rewardTemplateMode) == null || TextUtils.isEmpty(cVar.e)) && !TextUtils.isEmpty(str) && str.contains(KEY_IS_CMPT_ENTRY))) {
            setCMPTEntryUrl(str);
        }
        setCanStartMoreOfferAnim(af.k(str));
        setMoreOfferAdControl(str, ENDCARD_URL);
    }

    public int getPlayable_ads_without_video() {
        return this.playable_ads_without_video;
    }

    public void setPlayable_ads_without_video(int i) {
        this.playable_ads_without_video = i;
    }

    public String getCampaignUnitId() {
        return this.campaignUnitId;
    }

    public void setCampaignUnitId(String str) {
        this.campaignUnitId = str;
    }

    public String getNativeVideoTrackingString() {
        return this.nativeVideoTrackingString;
    }

    public void setNativeVideoTrackingString(String str) {
        this.nativeVideoTrackingString = str;
    }

    public j getNativeVideoTracking() {
        return this.nativeVideoTracking;
    }

    public void setNativeVideoTracking(j jVar) {
        this.nativeVideoTracking = jVar;
    }

    public String getAd_url_list() {
        return this.ad_url_list;
    }

    public void setAd_url_list(String str) {
        this.ad_url_list = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getPkgSource() {
        return this.pkgSource;
    }

    public void setPkgSource(String str) {
        this.pkgSource = str;
    }

    public int getIex() {
        return this.iex;
    }

    public void setIex(int i) {
        this.iex = i;
    }

    public long getTs() {
        return this.ts;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public b getMediaViewHolder() {
        return this.mediaViewHolder;
    }

    public void setMediaViewHolder(b bVar) {
        this.mediaViewHolder = bVar;
    }

    public c getRewardTemplateMode() {
        return this.rewardTemplateMode;
    }

    public void setRewardTemplateMode(c cVar) {
        this.rewardTemplateMode = cVar;
        if (cVar != null && !TextUtils.isEmpty(cVar.e())) {
            if (TextUtils.isEmpty(this.mof_template_url) && cVar.e().contains(KEY_IS_CMPT_ENTRY)) {
                setCMPTEntryUrl(cVar.e());
            }
            boolean i = af.i(cVar.e());
            int l = af.l(cVar.e());
            if (i) {
                setDynamicView(true);
                setDynamicTempCode(l);
            }
            setMoreOfferAdControl(cVar.e(), "template_url");
        }
    }

    private void setMoreOfferAdControl(String str, String str2) {
        JSONObject jSONObject;
        try {
            int c2 = af.c(str, MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
            if (c2 != 0) {
                if (TextUtils.isEmpty(this.moreOfferJsonData)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(this.moreOfferJsonData);
                }
                int c3 = af.c(str, MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF, c2);
                jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM, c3);
                jSONObject.put(str2, jSONObject2);
                this.moreOfferJsonData = jSONObject.toString();
            }
        } catch (Exception e) {
            aa.a(TAG, e.getMessage());
        }
    }

    public int getRetarget_offer() {
        return this.retarget_offer;
    }

    public void setRetarget_offer(int i) {
        this.retarget_offer = i;
    }

    public int getRewardPlayStatus() {
        return this.rewardPlayStatus;
    }

    public void setRewardPlayStatus(int i) {
        this.rewardPlayStatus = i;
    }

    public String getGuidelines() {
        return this.guidelines;
    }

    public void setGuidelines(String str) {
        this.guidelines = str;
    }

    public int getOfferType() {
        return this.offerType;
    }

    public void setOfferType(int i) {
        this.offerType = i;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public String getEndScreenUrl() {
        return this.endScreenUrl;
    }

    public void setEndScreenUrl(String str) {
        this.endScreenUrl = str;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public void setRewardAmount(int i) {
        this.rewardAmount = i;
    }

    public String getRewardName() {
        return this.reward_name;
    }

    public void setRewardName(String str) {
        this.reward_name = str;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public void setAdCall(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.linkType != 2 ? "Learn more" : "Install";
        }
        super.setAdCall(str);
    }

    public int getBty() {
        return this.bty;
    }

    public void setBty(int i) {
        this.bty = i;
    }

    public String getAdvImp() {
        return this.advImp;
    }

    public void setAdvImp(String str) {
        this.advImp = str;
    }

    public Map<Integer, String> getAdvImpList() {
        return generateAdImpression(this.advImp);
    }

    public int getTImp() {
        return this.t_imp;
    }

    public void setTImp(int i) {
        this.t_imp = i;
    }

    public String getVideoUrlEncode() {
        return this.videoUrlEncode;
    }

    public void setVideoUrlEncode(String str) {
        this.videoUrlEncode = str;
    }

    public int getVideoSize() {
        return this.videoSize;
    }

    public void setVideoSize(int i) {
        this.videoSize = i;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public int getWatchMile() {
        return this.watchMile;
    }

    public void setWatchMile(int i) {
        this.watchMile = i;
    }

    public int getCacheLevel() {
        return this.cacheLevel;
    }

    public void setCacheLevel(int i) {
        this.cacheLevel = i;
    }

    public boolean isCallBackImpression() {
        return this.isCallBackImpression;
    }

    public void setCallBackImpression(boolean z) {
        this.isCallBackImpression = z;
    }

    public void setReport(boolean z) {
        this.isReport = z;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public boolean isReportClick() {
        return this.isReportClick;
    }

    public void setReportClick(boolean z) {
        this.isReportClick = z;
    }

    public int getClickInterval() {
        return this.clickInterval;
    }

    public void setClickInterval(int i) {
        this.clickInterval = i;
    }

    public int getClickTimeOutInterval() {
        return this.clickTimeOutInterval;
    }

    public void setClickTimeOutInterval(int i) {
        this.clickTimeOutInterval = i;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionURL)) {
                return null;
            }
            Uri parse = Uri.parse(this.onlyImpressionURL);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(JSON_KEY_AD_K);
                this.requestId = queryParameter;
                setRequestId(queryParameter);
            }
            return this.requestId;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public String getCurrentLRid() {
        if (TextUtils.isEmpty(this.n_lrid)) {
            return this.localRequestId;
        }
        return this.n_lrid;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
    }

    public String getRequestIdNotice() {
        try {
            if (!TextUtils.isEmpty(this.requestIdNotice)) {
                return this.requestIdNotice;
            }
            if (TextUtils.isEmpty(this.noticeUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.noticeUrl);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(JSON_KEY_AD_K);
                this.requestIdNotice = queryParameter;
                setRequestIdNotice(queryParameter);
            }
            return this.requestIdNotice;
        } catch (Exception unused) {
            return "";
        }
    }

    public void setRequestIdNotice(String str) {
        this.requestIdNotice = str;
    }

    public String getClick_mode() {
        return this.click_mode;
    }

    public void setClick_mode(String str) {
        this.click_mode = str;
    }

    public String getLandingType() {
        return this.landingType;
    }

    public void setLandingType(String str) {
        this.landingType = str;
    }

    public int getFca() {
        return this.fca;
    }

    public void setFca(int i) {
        this.fca = i;
    }

    public int getFcb() {
        return this.fcb;
    }

    public void setFcb(int i) {
        this.fcb = i;
    }

    public int getTab() {
        return this.tab;
    }

    public void setTab(int i) {
        this.tab = i;
    }

    public String getClickURL() {
        return this.clickURL;
    }

    public void setClickURL(String str) {
        this.clickURL = str;
    }

    public int getWtick() {
        return this.wtick;
    }

    public void setWtick(int i) {
        this.wtick = i;
    }

    public String getDeepLinkURL() {
        return this.deepLinkUrl;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setUserActivation(boolean z) {
        this.userActivation = z;
    }

    public boolean getUserActivation() {
        return this.userActivation;
    }

    public int getTrackingTcpPort() {
        return this.trackingTcpPort;
    }

    public void setTrackingTcpPort(int i) {
        this.trackingTcpPort = i;
    }

    public String getImpressionURL() {
        try {
            if (ac.a().a("v_a_d_p", false)) {
                String str = this.impressionURL;
                String a2 = af.a(str, "&tun=", w.y() + "");
                this.impressionURL = a2;
                return a2;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
        return this.impressionURL;
    }

    public void setImpressionURL(String str) {
        this.impressionURL = str;
    }

    public String getNoticeUrl() {
        try {
            if (ac.a().a("v_a_d_p", false)) {
                String str = this.noticeUrl;
                String a2 = af.a(str, "&tun=", w.y() + "");
                this.noticeUrl = a2;
                return a2;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
        return this.noticeUrl;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }

    public String getOnlyImpressionURL() {
        try {
            if (ac.a().a("v_a_d_p", false)) {
                String str = this.onlyImpressionURL;
                String a2 = af.a(str, "&tun=", w.y() + "");
                this.onlyImpressionURL = a2;
                return a2;
            }
        } catch (Exception e) {
            aa.d(TAG, e.getMessage());
        }
        return this.onlyImpressionURL;
    }

    public void setOnlyImpressionURL(String str) {
        Uri parse;
        this.onlyImpressionURL = str;
        try {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                String queryParameter = parse.getQueryParameter(URL_KEY_EXP_IDS);
                if (!TextUtils.isEmpty(queryParameter)) {
                    setExpIds(queryParameter);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public JumpLoaderResult getJumpResult() {
        return this.jumpResult;
    }

    public void setJumpResult(JumpLoaderResult jumpLoaderResult) {
        this.jumpResult = jumpLoaderResult;
    }

    public int getTemplate() {
        return this.template;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public String getHost() {
        if (TextUtils.isEmpty(getNoticeUrl())) {
            return "";
        }
        try {
            Uri parse = Uri.parse(getNoticeUrl());
            if (parse == null) {
                return "";
            }
            return parse.getScheme() + "://" + parse.getHost();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static CampaignEx parseSettingCampaign(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        campaignEx.setId(jSONObject.optString("campaignid"));
        campaignEx.setPackageName(jSONObject.optString("packageName"));
        campaignEx.setAppName(jSONObject.optString("title"));
        campaignEx.setAdCall(jSONObject.optString("cta"));
        campaignEx.setAppDesc(jSONObject.optString(JSON_KEY_DESC));
        campaignEx.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
        campaignEx.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
        campaignEx.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
        campaignEx.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
        campaignEx.setAdHtml(jSONObject.optString(JSON_KEY_AD_HTML));
        campaignEx.setAdZip(jSONObject.optString(JSON_KEY_AD_ZIP));
        campaignEx.setBannerUrl(jSONObject.optString(JSON_KEY_BANNER_URL));
        campaignEx.setBannerHtml(jSONObject.optString(JSON_KEY_BANNER_HTML));
        campaignEx.setCreativeId(jSONObject.optLong(JSON_KEY_CREATIVE_ID));
        campaignEx.setVidCrtvId(jSONObject.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
        campaignEx.setEcCrtvId(jSONObject.optLong(JSON_KEY_EC_CREATIVE_ID));
        campaignEx.setEcTemplateId(jSONObject.optLong(JSON_KEY_EC_TEMP_ID));
        campaignEx.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
        return campaignEx;
    }

    private static boolean isBreakCampainOrSetItByEndCard(CampaignEx campaignEx, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.mbridge.msdk.foundation.controller.b.d().k() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        campaignEx.setendcard_url(str);
        return false;
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject) {
        CampaignEx campaignEx;
        ArrayList arrayList;
        JSONObject jSONObject2 = jSONObject;
        CampaignEx campaignEx2 = null;
        if (jSONObject2 != null) {
            try {
                campaignEx = new CampaignEx();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return campaignEx2;
            }
            try {
                campaignEx.setId(jSONObject2.optString("id"));
                campaignEx.setAppName(jSONObject2.optString("title"));
                campaignEx.setAppDesc(jSONObject2.optString(JSON_KEY_DESC));
                campaignEx.setPackageName(jSONObject2.optString(JSON_KEY_PACKAGE_NAME));
                campaignEx.setRtinsType(jSONObject2.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx.setIconUrl(jSONObject2.optString(JSON_KEY_ICON_URL));
                campaignEx.setImageUrl(jSONObject2.optString(JSON_KEY_IMAGE_URL));
                campaignEx.setSize(jSONObject2.optString(JSON_KEY_APP_SIZE));
                campaignEx.setImageSize(jSONObject2.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx.setImpressionURL(jSONObject2.optString(JSON_KEY_IMPRESSION_URL));
                campaignEx.setClickURL(jSONObject2.optString(JSON_KEY_CLICK_URL));
                campaignEx.setRewardPlus(RewardPlus.parseByString(jSONObject2.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx.setWtick(jSONObject2.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx.setDeepLinkUrl(jSONObject2.optString(JSON_KEY_DEEP_LINK_URL));
                campaignEx.setUserActivation(jSONObject2.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx.setNoticeUrl(jSONObject2.optString(JSON_KEY_NOTICE_URL));
                campaignEx.setTemplate(jSONObject2.optInt("template"));
                campaignEx.setType(jSONObject2.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx.setFca(jSONObject2.optInt(JSON_KEY_FCA));
                campaignEx.setFcb(jSONObject2.optInt(JSON_KEY_FCB));
                campaignEx.setEndcard_click_result(jSONObject2.optInt(JSON_KEY_ENDCARD_CLICK));
                if (!TextUtils.isEmpty(jSONObject2.optString(JSON_KEY_STAR))) {
                    campaignEx.setRating(Double.parseDouble(jSONObject2.optString(JSON_KEY_STAR, "0")));
                }
                if (!TextUtils.isEmpty(jSONObject2.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx.setNumberRating(jSONObject2.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx.setClick_mode(jSONObject2.optString(JSON_KEY_CLICK_MODE));
                campaignEx.setLandingType(jSONObject2.optString(JSON_KEY_LANDING_TYPE));
                campaignEx.setLinkType(jSONObject2.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx.setClickInterval(jSONObject2.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx.setAdCall(jSONObject2.optString(JSON_KEY_CTA_TEXT));
                campaignEx.setAd_url_list(jSONObject2.optString(JSON_KEY_AD_URL_LIST));
                campaignEx.setRetarget_offer(jSONObject2.optInt(JSON_KEY_RETARGET_OFFER, 2));
                campaignEx.setVideoUrlEncode(jSONObject2.optString(JSON_KEY_VIDEO_URL));
                campaignEx.setVideoLength(jSONObject2.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx.setVideoSize(jSONObject2.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx.setVideoResolution(jSONObject2.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx.setWatchMile(jSONObject2.optInt(JSON_KEY_WATCH_MILE));
                campaignEx.setTimestamp(System.currentTimeMillis());
                campaignEx.setBty(jSONObject2.optInt(JSON_KEY_BTY));
                campaignEx.setAdvImp(jSONObject2.optString(JSON_KEY_ADVIMP));
                campaignEx.setTImp(jSONObject2.optInt(JSON_KEY_T_IMP));
                campaignEx.setHtmlUrl(jSONObject2.optString(CampaignUnit.JSON_KEY_HTML_URL));
                campaignEx.setEndScreenUrl(jSONObject2.optString(CampaignUnit.JSON_KEY_END_SCREEN_URL));
                campaignEx.setGuidelines(jSONObject2.optString(JSON_KEY_GUIDELINES));
                campaignEx.setOfferType(jSONObject2.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx.setRewardName(jSONObject2.optString(JSON_KEY_REWARD_NAME));
                campaignEx.setRewardAmount(jSONObject2.optInt(JSON_KEY_REWARD_AMOUNT));
                try {
                    if (jSONObject2.has(JSON_NATIVE_VIDEO_AD_TRACKING)) {
                        String optString = jSONObject2.optString(JSON_NATIVE_VIDEO_AD_TRACKING);
                        if (!TextUtils.isEmpty(optString)) {
                            campaignEx.setNativeVideoTrackingString(optString);
                            campaignEx.setNativeVideoTracking(TrackingStr2Object(optString));
                        }
                    }
                } catch (Exception unused) {
                }
                try {
                    campaignEx.setReady_rate(jSONObject2.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject optJSONObject = jSONObject2.optJSONObject(JSON_KEY_EXT_DATA);
                    if (optJSONObject != null) {
                        campaignEx.setExt_data(optJSONObject.toString());
                    }
                    campaignEx.setMof_tplid(jSONObject2.optInt(CampaignUnit.JSON_KEY_MOF_TPLID));
                    campaignEx.setMof_template_url(jSONObject2.optString(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx.setNscpt(jSONObject2.optInt(CampaignUnit.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray optJSONArray = jSONObject2.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                    campaignEx.setPv_urls(arrayList);
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject(CampaignUnit.JSON_KEY_REQ_EXT_DATA);
                    if (optJSONObject2 != null) {
                        campaignEx.setReq_ext_data(optJSONObject2.toString());
                    }
                } catch (Exception unused2) {
                }
                campaignEx.setVideo_end_type(jSONObject2.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx, jSONObject2.optString(ENDCARD_URL))) {
                    return null;
                }
                campaignEx.setPlayable_ads_without_video(jSONObject2.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                campaignEx.setVideoMD5Value("");
                if (jSONObject2.has(JSON_KEY_NV_T2)) {
                    campaignEx.setNvT2(jSONObject2.optInt(JSON_KEY_NV_T2));
                }
                if (jSONObject2.has(JSON_KEY_GIF_URL)) {
                    campaignEx.setGifUrl(jSONObject2.optString(JSON_KEY_GIF_URL));
                }
                campaignEx.setRewardTemplateMode(c.a(jSONObject2.optJSONObject("rv")));
                campaignEx.setClickTimeOutInterval(jSONObject2.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx.setImpUA(jSONObject2.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx.setcUA(jSONObject2.optInt(JSON_KEY_C_UA, 1));
                campaignEx.setJmPd(jSONObject2.optInt(JSON_KEY_JM_PD));
                campaignEx.setKeyIaIcon(jSONObject2.optString("ia_icon"));
                campaignEx.setKeyIaRst(jSONObject2.optInt("ia_rst"));
                campaignEx.setKeyIaUrl(jSONObject2.optString("ia_url"));
                campaignEx.setKeyIaOri(jSONObject2.optInt("ia_ori"));
                campaignEx.setAdType(jSONObject2.optInt("ad_type"));
                campaignEx.setTpOffer(jSONObject2.optInt(JSON_KEY_TP_OFFER));
                campaignEx.setFac(jSONObject2.optInt(JSON_KEY_FAC));
                campaignEx.setIa_ext1(jSONObject2.optString(KEY_IA_EXT1));
                campaignEx.setIa_ext2(jSONObject2.optString(KEY_IA_EXT2));
                campaignEx.setIsDownLoadZip(jSONObject2.optInt(KEY_IS_DOWNLOAD));
                campaignEx.setInteractiveCache(jSONObject2.optString(KEY_IA_CACHE));
                campaignEx.setOc_time(jSONObject2.optInt(KEY_OC_TIME));
                campaignEx.setOc_type(jSONObject2.optInt(KEY_OC_TYPE));
                campaignEx.setT_list(jSONObject2.optString(KEY_T_LIST));
                campaignEx.setAdchoice(a.b(jSONObject2.optString(KEY_ADCHOICE, "")));
                campaignEx.setPlct(jSONObject2.optLong(JSON_KEY_PLCT));
                campaignEx.setPlctb(jSONObject2.optLong(JSON_KEY_PLCTB));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray(KEY_OMID);
                if (optJSONArray2 != null) {
                    campaignEx.setOmid(optJSONArray2.toString());
                } else if (!TextUtils.isEmpty(jSONObject2.optString(KEY_OMID))) {
                    campaignEx.setOmid(jSONObject2.optString(KEY_OMID));
                } else {
                    campaignEx.setOmid((String) null);
                }
                campaignEx.setCreativeId(jSONObject2.optLong(JSON_KEY_CREATIVE_ID));
                campaignEx.setVidCrtvId(jSONObject2.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
                campaignEx.setEcCrtvId(jSONObject2.optLong(JSON_KEY_EC_CREATIVE_ID));
                campaignEx.setEcTemplateId(jSONObject2.optLong(JSON_KEY_EC_TEMP_ID));
                campaignEx.setLocalRequestId(jSONObject2.optString(JSON_KEY_LOCAL_REQUEST_ID, ""));
                String optString2 = jSONObject2.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString2);
                if (TextUtils.isEmpty(parse.getPath()) || (!parse.getPath().endsWith(".zip") && !parse.getPath().endsWith(".ZIP"))) {
                    campaignEx.setBannerUrl(optString2);
                } else {
                    campaignEx.setAdZip(optString2);
                }
                campaignEx.setBannerHtml(jSONObject2.optString("cam_html"));
                campaignEx.setAdHtml(jSONObject2.optString("cam_html"));
                campaignEx.setCampaignUnitId(jSONObject2.optString(JSON_KEY_CAMPAIGN_UNITID));
                String optString3 = jSONObject2.optString(JSON_KEY_MRAID);
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = jSONObject2.optString(JSON_KEY_MRAIDFORH5);
                }
                if (!TextUtils.isEmpty(optString3)) {
                    campaignEx.setIsMraid(true);
                    campaignEx.setMraid(optString3);
                } else if (TextUtils.isEmpty(campaignEx.getAdHtml()) || campaignEx.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx.setIsMraid(false);
                } else {
                    campaignEx.setIsMraid(true);
                }
                try {
                    String optString4 = jSONObject2.optString(CampaignUnit.JSON_KEY_ONLY_IMPRESSION_URL);
                    if (!TextUtils.isEmpty(optString4)) {
                        campaignEx.setOnlyImpressionURL(optString4);
                        Uri parse2 = Uri.parse(optString4);
                        if (parse2 != null) {
                            campaignEx.setRequestId(parse2.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    String optString5 = jSONObject2.optString(JSON_KEY_NOTICE_URL);
                    if (!TextUtils.isEmpty(optString5)) {
                        campaignEx.setNoticeUrl(optString5);
                        Uri parse3 = Uri.parse(optString5);
                        if (parse3 != null) {
                            campaignEx.setRequestIdNotice(parse3.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    try {
                        String optString6 = jSONObject2.optString(JSON_KEY_ECPPV);
                        if (!TextUtils.isEmpty(optString6)) {
                            campaignEx.setEcppv(optString6);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused3) {
                }
                campaignEx.setIsBidCampaign(jSONObject2.optBoolean(JSON_KEY_HB, false));
                campaignEx.setPlacementId(jSONObject2.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx.setMaitve(jSONObject2.optInt(JSON_KEY_MAITVE));
                campaignEx.setMaitve_src(jSONObject2.optString(JSON_KEY_MAITVESRC));
                campaignEx.setFlb(jSONObject2.optInt(JSON_KEY_FLB));
                campaignEx.setFlbSkipTime(jSONObject2.optInt(JSON_KEY_FLB_SKIP_TIME));
                campaignEx.setCbd(jSONObject2.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx.setVst(jSONObject2.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx.setAdSpaceT(jSONObject2.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                campaignEx2 = parseCampaignWithBackData(jSONObject2, campaignEx);
                campaignEx2.setVcn(jSONObject2.optInt("vcn"));
                campaignEx2.setTokenRule(jSONObject2.optInt("token_r"));
                campaignEx2.setEncryptPrice(jSONObject2.optString("encrypt_p"));
                campaignEx2.setVideoCompleteTime(jSONObject2.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                campaignEx2.setVideoCheckType(jSONObject2.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                campaignEx2.setVideoCtnType(jSONObject2.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                JSONArray optJSONArray3 = jSONObject2.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i2)));
                    }
                    if (arrayList2.size() > 0) {
                        campaignEx2.setRsIgnoreCheckRule(arrayList2);
                    }
                }
                if (jSONObject2.has(JSON_KEY_AAB)) {
                    campaignEx2.setAabEntity(AabEntity.parser(jSONObject2.getString(JSON_KEY_AAB)));
                }
                try {
                    campaignEx2.setPrivacyUrl(jSONObject2.optString(JSON_KEY_PRIVACY_URL, ""));
                    campaignEx2.setPrivacyButtonTemplateVisibility(jSONObject2.optInt(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, 0));
                } catch (Exception e3) {
                    aa.d(FirebaseAnalytics.Param.CAMPAIGN, e3.getMessage());
                }
                campaignEx2.setImpReportType(jSONObject2.optInt(JSON_KEY_IMP_REPORT_TYPE, 0));
                campaignEx2.setTrackingTcpPort(jSONObject2.optInt(CampaignUnit.JSON_KEY_TK_TCP_PORT, 9377));
                return campaignEx2;
            } catch (Exception e4) {
                e = e4;
                campaignEx2 = campaignEx;
                e.printStackTrace();
                return campaignEx2;
            }
        }
        return campaignEx2;
    }

    private static JSONObject dealV5Temp(JSONObject jSONObject) {
        JSONArray optJSONArray;
        try {
            if (!jSONObject.has(JSON_KEY_AD_TMP_IDS) || (optJSONArray = jSONObject.optJSONArray(JSON_KEY_AD_TMP_IDS)) == null || optJSONArray.length() <= 0) {
                return jSONObject;
            }
            jSONObject.remove(JSON_KEY_AD_TMP_IDS);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject a2 = com.mbridge.msdk.foundation.db.a.a.a().a(optJSONArray.getString(i));
                if (a2 != null) {
                    Iterator<String> keys = a2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, a2.opt(next));
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z, CampaignUnit campaignUnit) {
        return parseCampaign(jSONObject, str, str2, str3, z, campaignUnit, "", "");
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z, CampaignUnit campaignUnit, String str4, String str5) {
        CampaignEx campaignEx;
        ArrayList arrayList;
        CampaignUnit campaignUnit2 = campaignUnit;
        JSONObject dealV5Temp = dealV5Temp(jSONObject);
        if (dealV5Temp == null) {
            return null;
        }
        try {
            CampaignEx campaignEx2 = new CampaignEx();
            try {
                String optString = dealV5Temp.optString(JSON_KEY_AD_AKS);
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                        keys = keys;
                    }
                    campaignEx2.setAks(hashMap);
                }
                if (!TextUtils.isEmpty(str4)) {
                    campaignEx2.setBidToken(str4);
                    campaignEx2.setIsBidCampaign(true);
                }
                try {
                    campaignEx2.setReady_rate(dealV5Temp.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject optJSONObject = dealV5Temp.optJSONObject(JSON_KEY_EXT_DATA);
                    if (optJSONObject != null) {
                        campaignEx2.setExt_data(optJSONObject.toString());
                    }
                    campaignEx2.setMof_tplid(dealV5Temp.optInt(CampaignUnit.JSON_KEY_MOF_TPLID));
                    campaignEx2.setMof_template_url(dealV5Temp.optString(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx2.setNscpt(dealV5Temp.optInt(CampaignUnit.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray optJSONArray = dealV5Temp.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                    campaignEx2.setPv_urls(arrayList);
                    JSONObject optJSONObject2 = dealV5Temp.optJSONObject(CampaignUnit.JSON_KEY_REQ_EXT_DATA);
                    if (optJSONObject2 != null) {
                        campaignEx2.setReq_ext_data(optJSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                campaignEx2.setId(dealV5Temp.optString("id"));
                campaignEx2.setAppName(dealV5Temp.optString("title"));
                campaignEx2.setCampaignUnitId(dealV5Temp.optString(JSON_KEY_CAMPAIGN_UNITID, ""));
                campaignEx2.setAppDesc(dealV5Temp.optString(JSON_KEY_DESC));
                campaignEx2.setPackageName(dealV5Temp.optString(JSON_KEY_PACKAGE_NAME));
                campaignEx2.setRtinsType(dealV5Temp.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx2.setIconUrl(dealV5Temp.optString(JSON_KEY_ICON_URL));
                campaignEx2.setImageUrl(dealV5Temp.optString(JSON_KEY_IMAGE_URL));
                campaignEx2.setSize(dealV5Temp.optString(JSON_KEY_APP_SIZE));
                campaignEx2.setImageSize(dealV5Temp.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx2.setImpressionURL(replaceValueByKey(campaignUnit2, campaignEx2, dealV5Temp.optString(JSON_KEY_IMPRESSION_URL)));
                campaignEx2.setClickURL(replaceValueByKey(campaignUnit2, campaignEx2, dealV5Temp.optString(JSON_KEY_CLICK_URL)));
                campaignEx2.setRewardPlus(RewardPlus.parseByString(dealV5Temp.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx2.setWtick(dealV5Temp.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx2.setDeepLinkUrl(replaceValueByKey(campaignUnit2, campaignEx2, dealV5Temp.optString(JSON_KEY_DEEP_LINK_URL)));
                campaignEx2.setUserActivation(dealV5Temp.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx2.setNoticeUrl(replaceValueByKey(campaignUnit2, campaignEx2, dealV5Temp.optString(JSON_KEY_NOTICE_URL)));
                campaignEx2.setTemplate(dealV5Temp.optInt("template"));
                campaignEx2.setType(dealV5Temp.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx2.setFca(dealV5Temp.optInt(JSON_KEY_FCA));
                campaignEx2.setFcb(dealV5Temp.optInt(JSON_KEY_FCB));
                campaignEx2.setEndcard_click_result(dealV5Temp.optInt(JSON_KEY_ENDCARD_CLICK));
                if (!TextUtils.isEmpty(dealV5Temp.optString(JSON_KEY_STAR))) {
                    campaignEx2.setRating(Double.parseDouble(dealV5Temp.optString(JSON_KEY_STAR, "0")));
                }
                if (!TextUtils.isEmpty(dealV5Temp.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx2.setNumberRating(dealV5Temp.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx2.setClick_mode(dealV5Temp.optString(JSON_KEY_CLICK_MODE));
                campaignEx2.setLandingType(dealV5Temp.optString(JSON_KEY_LANDING_TYPE));
                campaignEx2.setLinkType(dealV5Temp.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx2.setClickInterval(dealV5Temp.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx2.setAdCall(dealV5Temp.optString(JSON_KEY_CTA_TEXT));
                campaignEx2.setAd_url_list(dealV5Temp.optString(JSON_KEY_AD_URL_LIST));
                campaignEx2.setRetarget_offer(dealV5Temp.optInt(JSON_KEY_RETARGET_OFFER, 2));
                String optString2 = dealV5Temp.optString(JSON_KEY_VIDEO_URL);
                if (!TextUtils.isEmpty(optString2)) {
                    if (z) {
                        campaignEx2.setVideoUrlEncode(optString2);
                    } else {
                        campaignEx2.setVideoUrlEncode(u.b(optString2));
                    }
                }
                campaignEx2.setVideoCompleteTime(dealV5Temp.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                campaignEx2.setVideoLength(dealV5Temp.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx2.setVideoSize(dealV5Temp.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx2.setVideoResolution(dealV5Temp.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx2.setWatchMile(dealV5Temp.optInt(JSON_KEY_WATCH_MILE));
                campaignEx2.setTimestamp(System.currentTimeMillis());
                campaignEx2.setOnlyImpressionURL(replaceValueByKey(campaignUnit2, campaignEx2, str));
                try {
                    if (!TextUtils.isEmpty(str5)) {
                        campaignEx2.setEcppv(str5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                campaignEx2.setBty(dealV5Temp.optInt(JSON_KEY_BTY));
                campaignEx2.setAdvImp(dealV5Temp.optString(JSON_KEY_ADVIMP));
                campaignEx2.setTImp(dealV5Temp.optInt(JSON_KEY_T_IMP));
                campaignEx2.setHtmlUrl(str2);
                campaignEx2.setEndScreenUrl(str3);
                campaignEx2.setGuidelines(dealV5Temp.optString(JSON_KEY_GUIDELINES));
                campaignEx2.setOfferType(dealV5Temp.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx2.setRewardName(dealV5Temp.optString(JSON_KEY_REWARD_NAME));
                campaignEx2.setRewardAmount(dealV5Temp.optInt(JSON_KEY_REWARD_AMOUNT));
                try {
                    String replaceValueByKey = replaceValueByKey(campaignUnit2, campaignEx2, dealV5Temp.optString(JSON_NATIVE_VIDEO_AD_TRACKING));
                    if (!TextUtils.isEmpty(replaceValueByKey)) {
                        campaignEx2.setNativeVideoTrackingString(replaceValueByKey);
                        campaignEx2.setNativeVideoTracking(TrackingStr2Object(replaceValueByKey));
                    }
                } catch (Exception unused2) {
                }
                campaignEx2.setVideo_end_type(dealV5Temp.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx2, dealV5Temp.optString(ENDCARD_URL))) {
                    return null;
                }
                campaignEx2.setPlayable_ads_without_video(dealV5Temp.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                campaignEx2.setVideoMD5Value("");
                if (dealV5Temp.has(JSON_KEY_NV_T2)) {
                    campaignEx2.setNvT2(dealV5Temp.optInt(JSON_KEY_NV_T2));
                }
                if (dealV5Temp.has(JSON_KEY_GIF_URL)) {
                    campaignEx2.setGifUrl(dealV5Temp.optString(JSON_KEY_GIF_URL));
                }
                campaignEx2.setRewardTemplateMode(c.a(dealV5Temp.optJSONObject("rv")));
                campaignEx2.setClickTimeOutInterval(dealV5Temp.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx2.setImpUA(dealV5Temp.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx2.setcUA(dealV5Temp.optInt(JSON_KEY_C_UA, 1));
                campaignEx2.setJmPd(dealV5Temp.optInt(JSON_KEY_JM_PD));
                campaignEx2.setKeyIaIcon(dealV5Temp.optString("ia_icon"));
                campaignEx2.setKeyIaRst(dealV5Temp.optInt("ia_rst"));
                campaignEx2.setKeyIaUrl(dealV5Temp.optString("ia_url"));
                campaignEx2.setKeyIaOri(dealV5Temp.optInt("ia_ori"));
                campaignEx2.setAdType(campaignUnit.getAdType());
                campaignEx2.setTpOffer(dealV5Temp.optInt(JSON_KEY_TP_OFFER));
                campaignEx2.setFac(dealV5Temp.optInt(JSON_KEY_FAC));
                campaignEx2.setIa_ext1(dealV5Temp.optString(KEY_IA_EXT1));
                campaignEx2.setIa_ext2(dealV5Temp.optString(KEY_IA_EXT2));
                campaignEx2.setIsDownLoadZip(dealV5Temp.optInt(KEY_IS_DOWNLOAD));
                campaignEx2.setInteractiveCache(dealV5Temp.optString(KEY_IA_CACHE));
                campaignEx2.setOc_time(dealV5Temp.optInt(KEY_OC_TIME));
                campaignEx2.setOc_type(dealV5Temp.optInt(KEY_OC_TYPE));
                campaignEx2.setT_list(dealV5Temp.optString(KEY_T_LIST));
                campaignEx2.setAdchoice(a.b(dealV5Temp.optString(KEY_ADCHOICE, "")));
                campaignEx2.setPlct(dealV5Temp.optLong(JSON_KEY_PLCT));
                campaignEx2.setPlctb(dealV5Temp.optLong(JSON_KEY_PLCTB));
                campaignEx2.setCreativeId(dealV5Temp.optLong(JSON_KEY_CREATIVE_ID));
                campaignEx2.setVidCrtvId(dealV5Temp.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
                campaignEx2.setEcCrtvId(dealV5Temp.optLong(JSON_KEY_EC_CREATIVE_ID));
                campaignEx2.setEcTemplateId(dealV5Temp.optLong(JSON_KEY_EC_TEMP_ID));
                String optString3 = dealV5Temp.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString3);
                if (TextUtils.isEmpty(parse.getPath()) || (!parse.getPath().endsWith(".zip") && !parse.getPath().endsWith(".ZIP"))) {
                    campaignEx2.setBannerUrl(optString3);
                } else {
                    campaignEx2.setAdZip(optString3);
                }
                campaignEx2.setBannerHtml(dealV5Temp.optString("cam_html"));
                campaignEx2.setAdHtml(dealV5Temp.optString("cam_html"));
                String optString4 = dealV5Temp.optString(JSON_KEY_MRAID);
                if (!TextUtils.isEmpty(optString4)) {
                    campaignEx2.setIsMraid(true);
                    campaignEx2.setMraid(optString4);
                } else if (TextUtils.isEmpty(campaignEx2.getAdHtml()) || campaignEx2.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx2.setIsMraid(false);
                } else {
                    campaignEx2.setIsMraid(true);
                }
                JSONArray optJSONArray2 = dealV5Temp.optJSONArray(KEY_OMID);
                if (optJSONArray2 != null) {
                    campaignEx2.setOmid(optJSONArray2.toString());
                } else if (!TextUtils.isEmpty(dealV5Temp.optString(KEY_OMID))) {
                    campaignEx2.setOmid(dealV5Temp.optString(KEY_OMID));
                } else {
                    campaignEx2.setOmid((String) null);
                }
                campaignEx2.setPlacementId(dealV5Temp.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx2.setMaitve(dealV5Temp.optInt(JSON_KEY_MAITVE));
                campaignEx2.setMaitve_src(dealV5Temp.optString(JSON_KEY_MAITVESRC));
                campaignEx2.setFlb(dealV5Temp.optInt(JSON_KEY_FLB));
                campaignEx2.setCbd(dealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx2.setVst(dealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx2.setAdSpaceT(dealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                campaignEx2.setFlbSkipTime(dealV5Temp.optInt(JSON_KEY_FLB_SKIP_TIME));
                campaignEx = parseCampaign(dealV5Temp, campaignEx2);
                try {
                    campaignEx.setImpressionURL(af.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx.getPackageName(), campaignEx.getImpressionURL()));
                } catch (Exception e2) {
                    try {
                        aa.d(FirebaseAnalytics.Param.CAMPAIGN, e2.getMessage());
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        return campaignEx;
                    }
                }
                campaignEx.setVideoCheckType(dealV5Temp.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                campaignEx.setVideoCtnType(dealV5Temp.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                JSONArray optJSONArray3 = dealV5Temp.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i2)));
                    }
                    if (arrayList2.size() > 0) {
                        campaignEx.setRsIgnoreCheckRule(arrayList2);
                    }
                }
                if (dealV5Temp.has(JSON_KEY_AAB)) {
                    campaignEx.setAabEntity(AabEntity.parser(dealV5Temp.getString(JSON_KEY_AAB)));
                }
                try {
                    campaignEx.setPrivacyUrl(dealV5Temp.optString(JSON_KEY_PRIVACY_URL, ""));
                    campaignEx.setPrivacyButtonTemplateVisibility(dealV5Temp.optInt(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, 0));
                } catch (Exception e4) {
                    aa.d(FirebaseAnalytics.Param.CAMPAIGN, e4.getMessage());
                }
                campaignEx.setImpReportType(dealV5Temp.optInt(JSON_KEY_IMP_REPORT_TYPE, 0));
                return campaignEx;
            } catch (Exception e5) {
                e = e5;
                campaignEx = campaignEx2;
                e.printStackTrace();
                return campaignEx;
            }
        } catch (Exception e6) {
            e = e6;
            campaignEx = null;
            e.printStackTrace();
            return campaignEx;
        }
    }

    public static String object2TrackingStr(j jVar) {
        if (jVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (jVar.p() != null) {
                    jSONObject.put("impression", processNativeVideoTrackingArray2Json(jVar.p()));
                }
                if (jVar.d() != null) {
                    jSONObject.put("start", processNativeVideoTrackingArray2Json(jVar.d()));
                }
                if (jVar.e() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_FIRST_QUARTILE, processNativeVideoTrackingArray2Json(jVar.e()));
                }
                if (jVar.f() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_MIDPOINT, processNativeVideoTrackingArray2Json(jVar.f()));
                }
                if (jVar.g() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_THIRD_QUARTILE, processNativeVideoTrackingArray2Json(jVar.g()));
                }
                if (jVar.h() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_COMPLETE, processNativeVideoTrackingArray2Json(jVar.h()));
                }
                if (jVar.i() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE, reparsePlayCentage(jVar.i()));
                }
                if (jVar.j() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_MUTE, processNativeVideoTrackingArray2Json(jVar.j()));
                }
                if (jVar.k() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_UNMUTE, processNativeVideoTrackingArray2Json(jVar.k()));
                }
                if (jVar.l() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_CLICK, processNativeVideoTrackingArray2Json(jVar.l()));
                }
                if (jVar.m() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_PAUSE, processNativeVideoTrackingArray2Json(jVar.p()));
                }
                if (jVar.n() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_RESUME, processNativeVideoTrackingArray2Json(jVar.n()));
                }
                if (jVar.o() != null) {
                    jSONObject.put("error", processNativeVideoTrackingArray2Json(jVar.o()));
                }
                if (jVar.q() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ENDCARD, processNativeVideoTrackingArray2Json(jVar.q()));
                }
                if (jVar.s() != null) {
                    jSONObject.put("close", processNativeVideoTrackingArray2Json(jVar.s()));
                }
                if (jVar.r() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ENDCARD_SHOW, processNativeVideoTrackingArray2Json(jVar.r()));
                }
                if (jVar.t() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_VIDEO_CLICK, processNativeVideoTrackingArray2Json(jVar.q()));
                }
                if (jVar.c() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_IMPRESSION_T2, processNativeVideoTrackingArray2Json(jVar.c()));
                }
                if (jVar.a() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_DROPOUT_TRACK, processNativeVideoTrackingArray2Json(jVar.a()));
                }
                if (jVar.b() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK, processNativeVideoTrackingArray2Json(jVar.b()));
                }
                JSONObject object2TrackingStr = object2TrackingStr(jSONObject, jVar);
                if (object2TrackingStr == null) {
                    return "";
                }
                return object2TrackingStr.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static j TrackingStr2Object(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                j jVar = new j();
                jVar.o(processNativeVideoTrackingArray(jSONObject.optJSONArray("impression")));
                jVar.d(processNativeVideoTrackingArray(jSONObject.optJSONArray("start")));
                jVar.e(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                jVar.f(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MIDPOINT)));
                jVar.g(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                jVar.h(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_COMPLETE)));
                jVar.a(parsePlayCentage(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)));
                jVar.i(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MUTE)));
                jVar.j(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_UNMUTE)));
                jVar.k(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLICK)));
                jVar.l(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PAUSE)));
                jVar.m(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_RESUME)));
                jVar.n(processNativeVideoTrackingArray(jSONObject.optJSONArray("error")));
                jVar.p(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD)));
                jVar.r(processNativeVideoTrackingArray(jSONObject.optJSONArray("close")));
                jVar.q(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD_SHOW)));
                jVar.s(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_VIDEO_CLICK)));
                jVar.c(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_IMPRESSION_T2)));
                jVar.a(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_DROPOUT_TRACK)));
                jVar.b(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK)));
                return trackingStr2Object(jSONObject, jVar);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    protected static JSONArray processNativeVideoTrackingArray2Json(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : strArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    protected static String[] processNativeVideoTrackingArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    private Map<Integer, String> generateAdImpression(String str) {
        HashMap hashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt(JSON_AD_IMP_KEY);
                    hashMap2.put(Integer.valueOf(optInt), optJSONObject.optString("url"));
                    i++;
                } catch (Exception e) {
                    e = e;
                    hashMap = hashMap2;
                    e.printStackTrace();
                    return hashMap;
                }
            }
            return hashMap2;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return hashMap;
        }
    }

    public List<String> getAdUrlList() {
        ArrayList arrayList;
        Exception e;
        String ad_url_list2 = getAd_url_list();
        try {
            if (TextUtils.isEmpty(ad_url_list2)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(ad_url_list2);
            arrayList = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    arrayList.add(jSONArray.optString(i));
                    i++;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
            e.printStackTrace();
            return arrayList;
        }
    }

    public static JSONArray parseCamplistToJson(List<CampaignEx> list) {
        JSONArray jSONArray = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        for (CampaignEx campaignToJsonObject : list) {
                            try {
                                jSONArray2.put(campaignToJsonObject(campaignToJsonObject));
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        return jSONArray2;
                    } catch (Exception e) {
                        e = e;
                        jSONArray = jSONArray2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx, boolean z, boolean z2) throws JSONException {
        JSONObject campaignToJsonObject = campaignToJsonObject(campaignEx);
        campaignToJsonObject.put("isReady", z);
        campaignToJsonObject.put("expired", z2);
        return campaignToJsonObject;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", campaignEx.getId());
        jSONObject.put(JSON_KEY_FLB, campaignEx.getFlb());
        jSONObject.put(JSON_KEY_FLB_SKIP_TIME, campaignEx.getFlbSkipTime());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_VST, campaignEx.getVst());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_CBD, campaignEx.getCbd());
        if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
            jSONObject.put(JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
        }
        if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
            try {
                jSONObject.put(JSON_KEY_EXT_DATA, new JSONObject(campaignEx.getExt_data()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getReq_ext_data())) {
            try {
                jSONObject.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, new JSONObject(campaignEx.getReq_ext_data()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
            jSONObject.put(CampaignUnit.JSON_KEY_MOF_TPLID, campaignEx.getMof_tplid());
            jSONObject.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            jSONObject.put(CampaignUnit.JSON_KEY_NSCPT, campaignEx.getNscpt());
        }
        jSONObject.put(JSON_KEY_READY_RATE, campaignEx.getReady_rate());
        jSONObject.put("title", campaignEx.getAppName());
        jSONObject.put(JSON_KEY_DESC, campaignEx.getAppDesc());
        jSONObject.put(JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
        jSONObject.put(JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
        jSONObject.put(JSON_KEY_ICON_URL, campaignEx.getIconUrl());
        jSONObject.put(JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
        jSONObject.put(JSON_KEY_APP_SIZE, campaignEx.getSize());
        jSONObject.put(JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
        jSONObject.put(JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
        jSONObject.put(JSON_KEY_CLICK_URL, campaignEx.getClickURL());
        if (campaignEx.getRewardPlus() != null) {
            jSONObject.put(JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject());
        }
        jSONObject.put(JSON_KEY_WITHOUT_INSTALL_CHECK, campaignEx.getWtick());
        jSONObject.put(JSON_KEY_DEEP_LINK_URL, campaignEx.getDeepLinkURL());
        jSONObject.put(JSON_KEY_USER_ACTIVATION, campaignEx.getUserActivation());
        jSONObject.put(JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
        jSONObject.put("template", campaignEx.getTemplate());
        jSONObject.put(JSON_KEY_AD_SOURCE_ID, campaignEx.getType());
        jSONObject.put(JSON_KEY_FCA, campaignEx.getFca());
        jSONObject.put(JSON_KEY_FCB, campaignEx.getFcb());
        jSONObject.put(JSON_KEY_STAR, campaignEx.getRating() + "");
        jSONObject.put(JSON_KEY_NUMBER_RATING, campaignEx.getNumberRating());
        jSONObject.put(JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
        jSONObject.put(JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
        jSONObject.put(JSON_KEY_LINK_TYPE, campaignEx.getLinkType());
        jSONObject.put(JSON_KEY_CLICK_INTERVAL, campaignEx.getClickInterval());
        jSONObject.put(JSON_KEY_CTA_TEXT, campaignEx.getAdCall());
        jSONObject.put(JSON_KEY_ENDCARD_CLICK, campaignEx.getEndcard_click_result());
        jSONObject.put(JSON_KEY_RETARGET_OFFER, campaignEx.getRetarget_offer());
        jSONObject.put(JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
        jSONObject.put(JSON_KEY_VIDEO_LENGTHL, campaignEx.getVideoLength());
        jSONObject.put(JSON_KEY_VIDEO_SIZE, campaignEx.getVideoSize());
        jSONObject.put(JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
        jSONObject.put(JSON_KEY_WATCH_MILE, campaignEx.getWatchMile());
        jSONObject.put(JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
        jSONObject.put(CampaignUnit.JSON_KEY_ONLY_IMPRESSION_URL, campaignEx.getOnlyImpressionURL());
        jSONObject.put(JSON_KEY_ECPPV, campaignEx.getEcppv());
        jSONObject.put(JSON_KEY_BTY, campaignEx.getBty());
        jSONObject.put(JSON_KEY_T_IMP, campaignEx.getTImp());
        jSONObject.put(JSON_KEY_ADVIMP, campaignEx.getAdvImp());
        jSONObject.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
        jSONObject.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
        jSONObject.put(JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
        jSONObject.put(JSON_KEY_OFFER_TYPE, campaignEx.getOfferType());
        jSONObject.put(JSON_KEY_REWARD_AMOUNT, campaignEx.getRewardAmount());
        jSONObject.put(JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
        jSONObject.put(JSON_KEY_GIF_URL, campaignEx.getGifUrl());
        if (ak.b(campaignEx.getNativeVideoTrackingString())) {
            jSONObject.put(JSON_NATIVE_VIDEO_AD_TRACKING, new JSONObject(campaignEx.getNativeVideoTrackingString()));
        }
        jSONObject.put(VIDEO_END_TYPE, campaignEx.getVideo_end_type());
        jSONObject.put(ENDCARD_URL, campaignEx.getendcard_url());
        jSONObject.put(PLAYABLE_ADS_WITHOUT_VIDEO, campaignEx.getPlayable_ads_without_video());
        if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null || !ak.b(campaignEx.getRewardTemplateMode().a()))) {
            jSONObject.put("rv", new JSONObject(campaignEx.getRewardTemplateMode().a()));
        }
        jSONObject.put(JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
        jSONObject.put(JSON_KEY_CLICK_TIMEOUT_INTERVAL, campaignEx.getClickTimeOutInterval());
        jSONObject.put(JSON_KEY_C_UA, campaignEx.getcUA());
        jSONObject.put(JSON_KEY_IMP_UA, campaignEx.getImpUA());
        jSONObject.put(JSON_KEY_JM_PD, campaignEx.getJmPd());
        jSONObject.put("ia_icon", campaignEx.getKeyIaIcon());
        jSONObject.put("ia_rst", campaignEx.getKeyIaRst());
        jSONObject.put("ia_url", campaignEx.getKeyIaUrl());
        jSONObject.put("ia_ori", campaignEx.getKeyIaOri());
        jSONObject.put("ad_type", campaignEx.getAdType());
        jSONObject.put(KEY_IA_EXT1, campaignEx.getIa_ext1());
        jSONObject.put(KEY_IA_EXT2, campaignEx.getIa_ext2());
        jSONObject.put(KEY_IS_DOWNLOAD, campaignEx.getIsDownLoadZip());
        jSONObject.put(KEY_IA_CACHE, campaignEx.getInteractiveCache());
        jSONObject.put(KEY_OC_TYPE, campaignEx.getOc_type());
        jSONObject.put(KEY_OC_TIME, campaignEx.getOc_time());
        jSONObject.put(KEY_T_LIST, campaignEx.getT_list());
        a adchoice2 = campaignEx.getAdchoice();
        if (adchoice2 != null) {
            jSONObject.put(KEY_ADCHOICE, new JSONObject(adchoice2.c()));
        }
        jSONObject.put(JSON_KEY_PLCT, campaignEx.getPlct());
        jSONObject.put(JSON_KEY_PLCTB, campaignEx.getPlctb());
        jSONObject.put(KEY_OMID, campaignEx.getOmid());
        jSONObject.put(JSON_KEY_CREATIVE_ID, campaignEx.getCreativeId());
        jSONObject.put("cam_html", campaignEx.getBannerHtml());
        jSONObject.put("cam_tpl_url", campaignEx.getBannerUrl() != null ? campaignEx.getBannerUrl() : campaignEx.getAdZip());
        jSONObject.put(JSON_KEY_MRAID, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_MRAIDFORH5, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_TIMESTAMP, campaignEx.getTimestamp());
        jSONObject.put(JSON_KEY_HB, campaignEx.isBidCampaign);
        jSONObject.put(MBridgeConstans.PLACEMENT_ID, campaignEx.getPlacementId());
        jSONObject.put(JSON_KEY_MAITVE, campaignEx.getMaitve());
        jSONObject.put(JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
        jSONObject.put("vcn", campaignEx.getVcn());
        jSONObject.put("token_r", campaignEx.getTokenRule());
        jSONObject.put("encrypt_p", campaignEx.getEncryptPrice());
        jSONObject.put(JSON_KEY_VIDEO_COMPLETE_TIME, campaignEx.getVideoCompleteTime());
        jSONObject.put(JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRule());
        jSONObject.put(JSON_KEY_VIDEO_CHECK_TYPE, campaignEx.getVideoCheckType());
        jSONObject.put(JSON_KEY_VIDEO_CTN_TYPE, campaignEx.getVideoCtnType());
        jSONObject.put(JSON_KEY_TP_OFFER, campaignEx.getTpOffer());
        jSONObject.put(JSON_KEY_FAC, campaignEx.getFac());
        jSONObject.put(JSON_KEY_LOCAL_REQUEST_ID, campaignEx.getLocalRequestId());
        jSONObject.put(JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
        jSONObject.put(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, campaignEx.getPrivacyButtonTemplateVisibility());
        try {
            jSONObject.put("misk_spt", af.f());
            jSONObject.put("misk_spt_det", af.g());
        } catch (JSONException unused) {
        }
        if (campaignEx.getAabEntity() != null) {
            jSONObject.put(JSON_KEY_AAB, campaignEx.getAabEntity().toJson());
        }
        jSONObject.put(JSON_KEY_VIDEO_CREATIVE_ID, campaignEx.getVidCrtvId());
        jSONObject.put(JSON_KEY_EC_CREATIVE_ID, campaignEx.getEcCrtvId());
        jSONObject.put(JSON_KEY_EC_TEMP_ID, campaignEx.getEcTemplateId());
        jSONObject.put(JSON_KEY_IMP_REPORT_TYPE, campaignEx.getImpReportType());
        jSONObject.put(CampaignUnit.JSON_KEY_TK_TCP_PORT, campaignEx.getTrackingTcpPort());
        return campaignToJsonObject(jSONObject, campaignEx);
    }

    private static JSONArray reparsePlayCentage(List<Map<Integer, String>> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                try {
                    Map map = list.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rate", map.keySet().iterator().next());
                    jSONObject.put("url", map.values().iterator().next());
                    jSONArray.put(jSONObject);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    private static List<Map<Integer, String>> parsePlayCentage(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap hashMap = new HashMap();
                        int i2 = jSONObject.getInt("rate");
                        hashMap.put(Integer.valueOf(i2), jSONObject.getString("url"));
                        arrayList.add(hashMap);
                    }
                    i++;
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public boolean isCallbacked() {
        return this.isCallbacked;
    }

    public void setCallbacked(boolean z) {
        this.isCallbacked = z;
    }

    public int getReady_rate() {
        return this.ready_rate;
    }

    public void setReady_rate(int i) {
        this.ready_rate = i;
    }

    public String getExt_data() {
        return this.ext_data;
    }

    public void setExt_data(String str) {
        this.ext_data = str;
    }

    public int getNscpt() {
        return this.nscpt;
    }

    public void setNscpt(int i) {
        this.nscpt = i;
    }

    public String getMof_template_url() {
        return this.mof_template_url;
    }

    public void setMof_template_url(String str) {
        this.mof_template_url = str;
        if (!TextUtils.isEmpty(str)) {
            setCMPTEntryUrl(str);
            boolean i = af.i(str);
            int l = af.l(str);
            if (i) {
                setDynamicView(true);
                setDynamicTempCode(l);
            }
            setCanStart2C1Anim(af.k(str));
        }
    }

    private void checkAndReSetDynamicViewState(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.mof_template_url) || !this.isDynamicView) {
                boolean i = af.i(str);
                int l = af.l(str);
                if (i) {
                    setDynamicView(true);
                    setDynamicTempCode(l);
                }
            }
        }
    }

    public String getCMPTEntryUrl() {
        return this.CMPTEntryUrl;
    }

    public void setCMPTEntryUrl(String str) {
        this.CMPTEntryUrl = str;
    }

    public int getMof_tplid() {
        return this.mof_tplid;
    }

    public void setMof_tplid(int i) {
        this.mof_tplid = i;
    }

    public String getReq_ext_data() {
        return this.req_ext_data;
    }

    public void setReq_ext_data(String str) {
        this.req_ext_data = str;
    }

    public void setReadyState(int i) {
        this.readyState = i;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void setReady(boolean z) {
        this.isReady = z;
    }

    public int getLoadTimeoutState() {
        return this.loadTimeoutState;
    }

    public void setLoadTimeoutState(int i) {
        this.loadTimeoutState = i;
    }

    public int getMaitve() {
        return this.maitve;
    }

    public void setMaitve(int i) {
        this.maitve = i;
    }

    public String getMaitve_src() {
        return this.maitve_src;
    }

    public void setMaitve_src(String str) {
        this.maitve_src = str;
    }

    public static final class c implements Serializable {
        private String a;
        private int b;
        private int c;
        private String d;
        /* access modifiers changed from: private */
        public String e;
        private List<a> f;

        public static final class a implements Serializable {
            public String a;
            public List<String> b = new ArrayList();
        }

        private c(String str) {
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final List<a> f() {
            return this.f;
        }

        public static c a(String str) {
            try {
                if (ak.b(str)) {
                    return a(new JSONObject(str));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                if (!ak.b(jSONObject.toString())) {
                    return null;
                }
                c cVar = new c(jSONObject.toString());
                cVar.b = jSONObject.optInt("video_template", 1);
                cVar.e = jSONObject.optString("template_url");
                cVar.c = jSONObject.optInt(AdUnitActivity.EXTRA_ORIENTATION);
                cVar.d = jSONObject.optString("paused_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("image");
                if (optJSONObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        List<String> b2 = af.b(optJSONObject.optJSONArray(next));
                        if (b2 != null && b2.size() > 0) {
                            a aVar = new a();
                            aVar.a = next;
                            aVar.b.addAll(b2);
                            arrayList.add(aVar);
                        }
                    }
                    cVar.f = arrayList;
                }
                return cVar;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public boolean isHasReportAdTrackPause() {
        return this.hasReportAdTrackPause;
    }

    public void setHasReportAdTrackPause(boolean z) {
        this.hasReportAdTrackPause = z;
    }

    public static final class a implements Serializable {
        private String a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private String g = "";
        private String h = "";
        private int i = 0;
        private int j = 0;
        private String k = "";

        public final int a() {
            return this.i;
        }

        public final int b() {
            return this.j;
        }

        public final String c() {
            return this.k;
        }

        public final String d() {
            return this.b;
        }

        public final void a(String str) {
            this.b = str;
        }

        public final String e() {
            return this.c;
        }

        public final String f() {
            return this.d;
        }

        public static a b(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static com.mbridge.msdk.foundation.entity.CampaignEx.a a(org.json.JSONObject r3) {
            /*
                r0 = 0
                if (r3 == 0) goto L_0x0073
                com.mbridge.msdk.foundation.entity.CampaignEx$a r1 = new com.mbridge.msdk.foundation.entity.CampaignEx$a     // Catch:{ Exception -> 0x006b, all -> 0x0062 }
                r1.<init>()     // Catch:{ Exception -> 0x006b, all -> 0x0062 }
                java.lang.String r0 = "adchoice_icon"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.c = r0     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r0 = "adchoice_link"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.b = r0     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r0 = "adchoice_size"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.d = r0     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r2 = "ad_logo_link"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.a = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r2 = "adv_logo"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.h = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r2 = "adv_name"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.g = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r2 = "platform_logo"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.f = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r2 = "platform_name"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.e = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r2 = c(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.j = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r0 = d(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.i = r0     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r1.k = r3     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r0 = r1
                goto L_0x0073
            L_0x005c:
                r3 = move-exception
                r0 = r1
                goto L_0x0063
            L_0x005f:
                r3 = move-exception
                r0 = r1
                goto L_0x006c
            L_0x0062:
                r3 = move-exception
            L_0x0063:
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r1 == 0) goto L_0x0073
                r3.printStackTrace()
                goto L_0x0073
            L_0x006b:
                r3 = move-exception
            L_0x006c:
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r1 == 0) goto L_0x0073
                r3.printStackTrace()
            L_0x0073:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignEx.a.a(org.json.JSONObject):com.mbridge.msdk.foundation.entity.CampaignEx$a");
        }

        private static int c(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 1) {
                    return Integer.parseInt(split[1]);
                }
            } catch (Exception | NumberFormatException unused) {
            }
            return 0;
        }

        private static int d(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 0) {
                    return Integer.parseInt(split[0]);
                }
            } catch (Exception | NumberFormatException unused) {
            }
            return 0;
        }
    }

    public boolean isSpareOffer(long j, long j2) {
        if (isEffectiveOffer(j)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (getPlctb() > 0) {
            if (getTimestamp() + (getPlctb() * 1000) >= currentTimeMillis) {
                return true;
            }
            return false;
        } else if (getTimestamp() + j2 >= currentTimeMillis) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEffectiveOffer(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (getPlct() > 0) {
            if (getTimestamp() + (getPlct() * 1000) >= currentTimeMillis) {
                return true;
            }
            return false;
        } else if (getTimestamp() + j >= currentTimeMillis) {
            return true;
        } else {
            return false;
        }
    }

    public String getOmid() {
        return this.omid;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public boolean isActiveOm() {
        return !TextUtils.isEmpty(this.omid) && !TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL);
    }

    public int getCbt() {
        return this.cbt;
    }

    public void setCbt(int i) {
        this.cbt = i;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public boolean needShowIDialog() {
        return super.needShowIDialog(this);
    }

    public long getcVersionCode() {
        return this.cVersionCode;
    }

    public void setcVersionCode(long j) {
        this.cVersionCode = j;
    }

    public AabEntity getAabEntity() {
        return this.aabEntity;
    }

    public void setAabEntity(AabEntity aabEntity2) {
        this.aabEntity = aabEntity2;
    }

    public ArrayList<Integer> getRsIgnoreCheckRule() {
        return this.rsIgnoreCheckRule;
    }

    public String getRsIgnoreCheckRuleString() {
        if (getRsIgnoreCheckRule() == null || getRsIgnoreCheckRule().size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Integer> it = getRsIgnoreCheckRule().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            if (!TextUtils.isEmpty(sb)) {
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return "";
        }
    }

    public void setRsIgnoreCheckRule(ArrayList<Integer> arrayList) {
        this.rsIgnoreCheckRule = arrayList;
    }

    public void setRsIgnoreCheckRuleByString(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String parseInt : split) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                setRsIgnoreCheckRule(arrayList);
            }
        }
    }

    public int getVideoCheckType() {
        return this.videoCheckType;
    }

    public void setVideoCheckType(int i) {
        if (i > 2 || i < 1) {
            this.videoCheckType = 2;
        } else {
            this.videoCheckType = i;
        }
    }

    public int getVideoCtnType() {
        return this.videoCtnType;
    }

    public void setVideoCtnType(int i) {
        if (i > 2 || i < 1) {
            this.videoCtnType = 1;
        } else {
            this.videoCtnType = i;
        }
    }

    public int getIsTimeoutCheckVideoStatus() {
        return this.isTimeoutCheckVideoStatus;
    }

    public void setIsTimeoutCheckVideoStatus(int i) {
        this.isTimeoutCheckVideoStatus = i;
    }

    public void setCanStart2C1Anim(boolean z) {
        this.canStart2C1Anim = z;
    }

    public boolean getCanStart2C1Anim() {
        return this.canStart2C1Anim;
    }

    public void setCanStartMoreOfferAnim(boolean z) {
        this.canStartMoreOfferAnim = z;
    }

    public boolean getCanStartMoreOfferAnim() {
        return this.canStartMoreOfferAnim;
    }

    public int getVideoPlayProgress() {
        return this.videoPlayProgress;
    }

    public void setVideoPlayProgress(int i) {
        this.videoPlayProgress = i;
    }
}
