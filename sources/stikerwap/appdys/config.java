package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.Html;
import android.text.format.DateFormat;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.net.MailTo;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import androidx.multidex.MultiDex;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.appnext.nativeads.NativeAd;
import com.appnext.nativeads.NativeAdView;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.common.Scopes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.newinterstitial.out.MBNewInterstitialHandler;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.vungle.ads.AdConfig;
import com.vungle.ads.BaseAd;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.presenter.NativeAdPresenter;
import com.wortise.ads.AdError;
import com.wortise.ads.banner.BannerAd;
import com.wortise.ads.interstitial.InterstitialAd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import stikerwap.appdys.t_chat;

public class config extends Application implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final int ADD_WHATS = 110;
    public static final int BLANCO = Color.parseColor("#FFFFFF");
    public static final int BLANCO_2 = Color.parseColor("#FAFAFA");
    public static final String CAD_REP_ORIG = " !#$%&()+,-./023456789:;<=>?ABCDEFGHIJKLMNOPQRSTUVWXYZ[^_abcdefghijklmnopqrstuvwxz{}~";
    public static final int CAMARA_CODE = 107;
    static final String COD_APP = "cfolv1";
    public static String DOM_CDN = "";
    public static String DOM_EDROID = "e-droid.net";
    public static final String DOM_SRV;
    public static final boolean FB_LOGIN = false;
    public static final int FILECHOOSER_RESULTCODE = 10;
    public static final int GRIS_CLARO = Color.parseColor("#9E9E9E");
    public static final int GRIS_OSCURO = Color.parseColor("#757575");
    static final int IDAPP = 3008836;
    public static final int LOCATION_CODE = 103;
    public static final int MAX_VID_DURATION = 40;
    public static final int MAX_VID_LENGTH = 111149056;
    public static final int MICROFONO_CAMARA_CODE = 105;
    public static final int NEGRO = Color.parseColor("#212121");
    public static final int NEGRO_2 = Color.parseColor("#727272");
    public static final String PROTOC_GEN;
    public static final int RETURN_SINADS = 111;
    static final int RSS_CONTENT_ENCODED = 6;
    static final int RSS_DATE = 3;
    static final int RSS_DESCRIPTION = 4;
    static final int RSS_IGNORETAG = 0;
    static final int RSS_LINK = 2;
    static final int RSS_OTHER = 5;
    static final int RSS_TITLE = 1;
    public static final int TAKE_PHOTO_CODE = 106;
    public static final int TAKE_VIDEO_CODE = 108;
    public static final int VERSION_SSL_KO = 22;
    public static final int VIDEO_CODE = 109;
    static final int VSOURCE = 172;
    static final int WIDTH_PORTRAIT = 500;
    static String admob_app_id;
    static String admob_appopen_cod;
    static String admob_int_cod;
    static String appnext_cod;
    static String appnext_cod_int_e;
    static String appnext_cod_int_ia;
    static int appnext_ent_modo = 0;
    static Interstitial appnext_glob_int = null;
    static Boolean autoplay;
    static boolean europeo = false;
    static InterstitialAd fb_glob_int = null;
    static String fb_int_cod;
    static boolean finalizar_app = false;
    static Map<Integer, Boolean> hsv_situado = new HashMap();
    static int hsv_x = 0;
    static int idfrase_global = 1;
    static com.google.android.gms.ads.interstitial.InterstitialAd interstitial_glob = null;
    static String is_int_cod;
    static com.vungle.ads.InterstitialAd liftoff_glob_int = null;
    static String liftoff_int_cod;
    static String mb_c_bg;
    static String mb_c_items;
    static int mb_item_sel = -1;
    static mb_item[] mb_items;
    static MBNewInterstitialHandler mint_glob_int = null;
    static String mint_int_cod_place;
    static String mint_int_cod_unit;
    static Boolean mute;
    static int our = 0;
    static PAGInterstitialAd pangle_glob_int = null;
    static String pangle_int_cod;
    static boolean prioridad_admob = false;
    static boolean privacy_incluir_adsconsent = false;
    static ArrayList<Integer> secciones_alist;
    static StartAppAd st_glob_int = null;
    static String st_int_cod;
    static Typeface tf_monospace;
    static Typeface tf_sans_serif;
    static Typeface tf_serif;
    static int toca_int = 0;
    static int toca_int_chat = 0;
    static String uni_int_cod;
    static com.wortise.ads.interstitial.InterstitialAd wortise_glob_int = null;
    static String wortise_int_cod;
    String acad_descr;
    String acad_ico;
    String acad_img;
    String acad_package;
    String acad_rating;
    String acad_ref;
    String acad_tit;
    boolean act_fondomenu;
    int admob_chat_interv;
    String admob_cod;
    int admob_int_interv;
    int admob_intentrar_interv;
    int admob_intgame_interv;
    String admob_menu_cod;
    int admob_menu_h;
    int admob_menu_w;
    int admob_pos;
    String admob_pro_cod;
    int admob_pro_h;
    int admob_pro_w;
    String admob_qr_cod;
    String admob_radio_cod;
    String admob_rew_cod;
    AdSize admob_tipo;
    ArrayList<NativeAd> appnext_ads;
    String appnext_inchat_cod;
    String appnext_menu_cod;
    String appnext_pro_cod;
    String appnext_qr_cod;
    String appnext_radio_cod;
    String appnext_rew_cod;
    String appnext_vi_cod;
    int appnext_vi_ini;
    int appnext_vi_interv;
    String appnext_video_cod;
    int appnext_video_ini;
    int appnext_video_interv;
    String appnextb_cod;
    boolean autoapagado;
    boolean aviso_cookies;
    boolean banner_mostrando = false;
    boolean banners_enchats;
    boolean bienvenida_nomas_def;
    boolean bienvenida_nomas_mostrar;
    String bienvenida_tit;
    String bienvenida_txt;
    int bubbles;
    boolean busc_antiguedad;
    boolean busc_cat;
    boolean busc_precio;
    boolean busc_texto;
    String c1;
    String c1_ofic;
    String c1_prods;
    String c1_prods_l;
    String c1_splash;
    String c1c;
    String c2;
    String c2_ofic;
    String c2_prods;
    String c2_prods_l;
    String c2_splash;
    String c2c;
    String c_antiguedad_prods_l;
    String c_bubbles;
    String c_ico_sep_ofic;
    String c_ico_sep_prods;
    String c_icos;
    String c_icos_2_prods;
    String c_icos_ofic;
    String c_icos_prods;
    String c_icos_top;
    String c_ind;
    String c_ir_ofic;
    String c_linea;
    Context c_periron;
    int c_perofic;
    int c_perprod;
    String c_precio_prods_l;
    String c_prods_det;
    String c_secc_activ;
    String c_secc_noactiv;
    String c_sep_ofic;
    String c_sep_prods;
    String c_sep_secc;
    String c_tit_ofic;
    String c_tit_prods;
    String c_tit_prods_l;
    boolean c_txt_chats;
    String c_txt_ofic;
    String c_txt_prods;
    String cad_rep;
    String card_admob_nuestro;
    String card_appnext_nuestro;
    String card_fb_nuestro;
    boolean card_nuestro;
    String card_st_nuestro;
    String catsnotif_tit;
    int catsnotif_v_bd;
    boolean chatsecc_acceso_a_perfil;
    boolean chatsecc_coments;
    boolean chatsecc_en_radio;
    boolean chatsecc_en_video;
    int chatsecc_fotos_perfil;
    boolean chatsecc_galeria;
    int chatsecc_p_descr;
    int chatsecc_p_dist;
    int chatsecc_p_fnac;
    int chatsecc_p_sexo;
    boolean chatsecc_privados;
    String codigo_acceso;
    boolean customtabs;
    int cvm;
    String divisa;
    boolean emojis;
    boolean es_admin;
    String fb_b_cod;
    boolean fb_bloqdatos;
    String fb_menu_cod;
    int fb_modo;
    String fb_pro_cod;
    String fb_qr_cod;
    String fb_radio_cod;
    String fb_rew_cod;
    boolean fnac_completa;
    boolean fondo_margen = false;
    int fondo_tipo = 2;
    int fondo_v = 0;
    String forzar_cargar_appnext;
    String forzar_cargar_startapp;
    boolean fotos_privados;
    boolean galeriav;
    int glob_acceso = 0;
    int glob_descr = 1;
    int glob_fnac = 1;
    int glob_fotos_perfil = 1;
    int glob_sexo = 1;
    boolean hay_catsnotif;
    boolean hay_icosmenu;
    int ico_busc_idsec;
    boolean ico_busc_imgperso;
    int ico_busc_imgperso_v;
    int ico_busc_ord;
    String ico_busc_url;
    int ico_exit_idsec;
    boolean ico_exit_imgperso;
    int ico_exit_imgperso_v;
    int ico_exit_ord;
    String ico_exit_url;
    int ico_notif_idsec;
    boolean ico_notif_imgperso;
    int ico_notif_imgperso_v;
    int ico_notif_ord;
    String ico_notif_url;
    int ico_ofics_idsec;
    boolean ico_ofics_imgperso;
    int ico_ofics_imgperso_v;
    int ico_ofics_ord;
    String ico_ofics_url;
    int ico_perfil_idsec;
    boolean ico_perfil_imgperso;
    int ico_perfil_imgperso_v;
    int ico_perfil_modo;
    int ico_perfil_ord;
    String ico_perfil_url;
    int ico_search_idsec;
    boolean ico_search_imgperso;
    int ico_search_imgperso_v;
    int ico_search_ord;
    String ico_search_url;
    int ico_share_idsec;
    boolean ico_share_imgperso;
    int ico_share_imgperso_v;
    int ico_share_ord;
    String ico_share_url;
    int ico_sinads_idsec;
    boolean ico_sinads_imgperso;
    int ico_sinads_imgperso_v;
    int ico_sinads_ord;
    String ico_sinads_url;
    int[] icos_a;
    boolean icos_pendientes;
    int inchat_1vez;
    int inchat_veces;
    int ind_secc_buscador = -1;
    int ind_secc_ofics = -1;
    int ind_secc_sel = -1;
    int ind_secc_sel_2 = -1;
    String instal_int_url = "";
    IronSourceBannerLayout isBanner_global;
    String is_appid = "";
    String is_b_cod = "";
    String is_card_cod;
    String is_menu_cod;
    String is_pro_cod;
    String is_qr_cod;
    String is_radio_cod;
    String is_rew_cod;
    String liftoff_appid = "";
    boolean links_enchats;
    int login_tipo;
    ListView mDrawerList;
    MenuAdapter ma;
    boolean margen_fondomenu;
    int max_videos_pro;
    int[] menu_a_secciones;
    boolean menu_anim;
    boolean menu_c;
    String menu_c1;
    String menu_c2;
    int menu_estilo;
    boolean menu_icos_izq;
    boolean menu_mostrar_icos;
    boolean menu_mostrar_txt;
    int menu_ncols;
    int menu_padding;
    boolean menu_txt_b;
    String menu_txt_bg;
    boolean menu_txt_c;
    String menu_txt_col;
    int menu_txt_radius;
    String menusl_c;
    String mint_appid = "";
    String mint_appkey = "";
    String monedata_appid = "";
    int notifdef_idabrir;
    String notifdef_tit;
    String notifdef_txt;
    String notifdef_url;
    int nsecc_mostradas;
    int nsecc_visibles;
    Oficina[] oficinas_a;
    ArrayList<MenuOpcion> opcions;
    boolean ord_antiguedad;
    String ord_def;
    boolean ord_precio;
    boolean ord_texto;
    String pa_int_url = "";
    String pangle_appid = "";
    String pb_c;
    int pb_pos = 0;
    int pb_s = 0;
    int pb_tipo = 2;
    boolean pedir_confirm_exit;
    boolean pedir_location_aliniciar = false;
    int petic_ask_email;
    int petic_ask_nombre;
    int petic_ask_tel;
    int playerjs_def_v = 0;
    int playerjs_v = 0;
    String pollfish_cod;
    Boolean pollfish_completada = false;
    String pp_divisa;
    String pp_email;
    String precio_divisa;
    String precio_email = "";
    int precio_modo;
    String precio_msg;
    String precio_msg_sinads;
    String precio_secc;
    String precio_sinads;
    int precio_time;
    int precio_time_sinads;
    boolean privacy_enmenu;
    boolean privacy_mostrar;
    boolean privacy_mostrar_2;
    boolean prods_adaptar_ancho;
    String prods_comprar;
    boolean prods_linksexternos;
    String prods_masinfo;
    boolean prods_masinfo_mostrar;
    String prods_tit;
    int radio_apagado;
    boolean radio_artist_b;
    String radio_artist_col;
    int radio_artist_size;
    int radio_pos;
    boolean radio_song_b;
    String radio_song_col;
    int radio_song_size;
    boolean radio_txt_c;
    int rate_int;
    String rate_ko;
    String rate_ok;
    int rate_primeravez;
    int rate_tipo;
    String rate_tit;
    String rate_txt;
    int rew_modo;
    String rew_msg;
    String rew_poll_msg;
    int rss_interv;
    String rss_tit;
    boolean screenshot_inhab;
    boolean search_descr;
    boolean search_show_descr;
    boolean search_show_ico;
    boolean search_show_tit;
    boolean search_tit;
    Seccion[] secciones_a;
    boolean sep_secc;
    String share_subject;
    String share_text;
    int slider_h;
    int slider_v;
    boolean spam_mostrar;
    boolean splash_margen = true;
    int splash_tipo = 1;
    int splash_w;
    String st_b_cod;
    String st_inchat_cod;
    String st_menu_cod;
    String st_pro_cod;
    String st_qr_cod;
    String st_radio_cod;
    String st_rew_cod;
    ArrayList<NativeAdDetails> startapp_ads;
    boolean t_fondomenu;
    int t_ind;
    int t_mas;
    int tipo_fondomenu;
    int tipomenu;
    boolean tts_mostrar;
    String uni_appid = "";
    String uni_b_cod = "";
    String uni_pro_cod;
    String uni_rew_cod;
    View v_cab;
    int v_fondomenu;
    int v_ico_emotic = 0;
    int v_ico_enviar = 0;
    int v_ico_foto = 0;
    int v_ico_perfil = 0;
    int v_ico_privados = 0;
    int v_ico_video = 0;
    View v_periron;
    boolean video_cast;
    int video_cast_v;
    boolean video_fs;
    boolean video_ls;
    boolean video_pip_auto;
    boolean video_pip_icon;
    String wortise_appid = "";
    String wortise_b_cod = "";
    String wortise_card_cod;
    String wortise_menu_cod;
    String wortise_pro_cod = "";
    String wortise_qr_cod;
    String wortise_radio_cod;
    String wortise_rew_cod;
    boolean wv_cache;
    boolean wv_cache_limpiada;
    boolean wv_sinconex;
    String wv_sinconex_txt;

    public static boolean fb_login() {
        return false;
    }

    public static boolean isConnectionFast(int i, int i2) {
        if (i == 1) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        switch (i2) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public String obtenerFuente(int i) {
        return i == 2 ? "CaviarDreams.ttf" : i == 3 ? "Pacifico.ttf" : i == 4 ? "Sansation-Regular.ttf" : i == 5 ? "Walkway_Bold.ttf" : "";
    }

    static {
        String str = Build.VERSION.SDK_INT < 22 ? "http://" : "https://";
        PROTOC_GEN = str;
        DOM_SRV = str + f_domsrv();
    }

    static class mb_item {
        Boolean externo;
        int id;
        int idsecc;
        int img_v;
        MenuItem menuitem;
        String txt;
        String url;

        mb_item() {
        }
    }

    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler());
        DOM_EDROID = f_dom_edroid(this);
    }

    private static String f_dom_edroid(Context context) {
        try {
            if (Locale.getDefault().getCountry() != "PK") {
                return context.getResources().getConfiguration().locale.getCountry() == "PK" ? "e-droid3.net" : "e-droid.net";
            }
            return "e-droid3.net";
        } catch (Exception unused) {
            return "e-droid.net";
        }
    }

    private static String f_domsrv() {
        return "srv" + (new Random().nextInt(9) + 11) + "." + DOM_EDROID;
    }

    public static Set<String> extractPackageNames(List<ResolveInfo> list) {
        HashSet hashSet = new HashSet();
        for (ResolveInfo resolveInfo : list) {
            hashSet.add(resolveInfo.activityInfo.packageName);
        }
        return hashSet;
    }

    static boolean launchNativeApi30(Context context, Uri uri) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri).addCategory("android.intent.category.BROWSABLE").addFlags(268436480));
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private static boolean launchNativeBeforeApi30(Context context, Uri uri) {
        PackageManager packageManager = context.getPackageManager();
        Set<String> extractPackageNames = extractPackageNames(packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", (String) null)), 0));
        Intent addCategory = new Intent("android.intent.action.VIEW", uri).addCategory("android.intent.category.BROWSABLE");
        Set<String> extractPackageNames2 = extractPackageNames(packageManager.queryIntentActivities(addCategory, 0));
        extractPackageNames2.removeAll(extractPackageNames);
        if (extractPackageNames2.isEmpty()) {
            return false;
        }
        addCategory.addFlags(268435456);
        context.startActivity(addCategory);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean abrir_ext(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "#"
            android.net.Uri r1 = android.net.Uri.parse(r7)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 < r3) goto L_0x0011
            boolean r2 = launchNativeApi30(r6, r1)
            goto L_0x0015
        L_0x0011:
            boolean r2 = launchNativeBeforeApi30(r6, r1)
        L_0x0015:
            r3 = 1
            if (r2 == 0) goto L_0x0019
            return r3
        L_0x0019:
            boolean r2 = r5.customtabs
            if (r2 == 0) goto L_0x005b
            boolean r2 = abrir_con_nav(r7)
            if (r2 == 0) goto L_0x005b
            androidx.browser.customtabs.CustomTabsIntent$Builder r2 = new androidx.browser.customtabs.CustomTabsIntent$Builder     // Catch:{ Exception -> 0x0057 }
            r2.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b }
            r4.<init>(r0)     // Catch:{ Exception -> 0x004b }
            java.lang.String r0 = r5.c1     // Catch:{ Exception -> 0x004b }
            r4.append(r0)     // Catch:{ Exception -> 0x004b }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x004b }
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x004b }
            androidx.browser.customtabs.CustomTabColorSchemeParams$Builder r4 = new androidx.browser.customtabs.CustomTabColorSchemeParams$Builder     // Catch:{ Exception -> 0x004b }
            r4.<init>()     // Catch:{ Exception -> 0x004b }
            androidx.browser.customtabs.CustomTabColorSchemeParams$Builder r0 = r4.setToolbarColor(r0)     // Catch:{ Exception -> 0x004b }
            androidx.browser.customtabs.CustomTabColorSchemeParams r0 = r0.build()     // Catch:{ Exception -> 0x004b }
            androidx.browser.customtabs.CustomTabsIntent$Builder r2 = r2.setDefaultColorSchemeParams(r0)     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            androidx.browser.customtabs.CustomTabsIntent r0 = r2.build()     // Catch:{ Exception -> 0x0057 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x0057 }
            r0.launchUrl(r6, r7)     // Catch:{ Exception -> 0x0057 }
            return r3
        L_0x0057:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005b:
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.VIEW"
            r7.<init>(r0, r1)
            r6.startActivity(r7)     // Catch:{ Exception -> 0x0066 }
            return r3
        L_0x0066:
            r6 = move-exception
            r6.printStackTrace()
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.abrir_ext(android.content.Context, java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public Anuncios mostrar_banner(Context context, boolean z) {
        return mostrar_banner_2(context, z, z);
    }

    /* access modifiers changed from: package-private */
    public Anuncios mostrar_banner_2(final Context context, boolean z, boolean z2) {
        com.wortise.ads.AdSize adSize;
        ArrayList<NativeAd> arrayList;
        if (getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            return null;
        }
        final Anuncios anuncios = new Anuncios();
        anuncios.adView = null;
        anuncios.adView_fb = null;
        anuncios.startAppBanner = null;
        this.banner_mostrando = false;
        if (this.admob_pos != 0 && !z) {
            ArrayList arrayList2 = new ArrayList();
            if (!this.admob_cod.equals("") && !z2) {
                arrayList2.add(1);
            }
            if (!this.appnextb_cod.equals("") && (arrayList = this.appnext_ads) != null && arrayList.size() > 0 && ((this.admob_cod.equals("") || !prioridad_admob) && this.wortise_b_cod.equals(""))) {
                arrayList2.add(2);
            }
            if (!this.fb_b_cod.equals("")) {
                arrayList2.add(3);
            }
            if (!this.st_b_cod.equals("")) {
                arrayList2.add(4);
            }
            if (!this.uni_b_cod.equals("") && UnityAds.isInitialized()) {
                arrayList2.add(7);
            }
            if (!this.is_b_cod.equals("")) {
                arrayList2.add(8);
            }
            if (!this.wortise_b_cod.equals("")) {
                arrayList2.add(9);
            }
            int intValue = !arrayList2.isEmpty() ? ((Integer) arrayList2.get(new Random().nextInt(((arrayList2.size() - 1) - 0) + 1) + 0)).intValue() : 0;
            if (intValue == 1) {
                anuncios.adView = new AdView(context);
                AdSize adSize2 = this.admob_tipo;
                if (adSize2 == AdSize.LARGE_BANNER && getResources().getConfiguration().orientation == 2) {
                    adSize2 = AdSize.SMART_BANNER;
                }
                anuncios.adView.setAdSize(adSize2);
                anuncios.adView.setAdUnitId(this.admob_cod);
                if (this.admob_pos == 1) {
                    anuncios.adView.setTag(Integer.valueOf(R.id.TAG_ESBANNER));
                    ((LinearLayout) this.v_cab).addView(anuncios.adView);
                } else {
                    Activity activity = (Activity) context;
                    ((LinearLayout) activity.findViewById(R.id.ll_ad)).addView(anuncios.adView);
                    ((LinearLayout) activity.findViewById(R.id.ll_ad)).setVisibility(0);
                }
                this.banner_mostrando = true;
                anuncios.adView.setAdListener(new AdListener() {
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        if (!config.this.appnextb_cod.equals("") && config.this.appnext_ads != null && config.this.appnext_ads.size() > 0) {
                            try {
                                if (config.this.admob_pos == 1) {
                                    View findViewWithTag = config.this.v_cab.findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
                                    if (findViewWithTag != null) {
                                        ((LinearLayout) config.this.v_cab).removeView(findViewWithTag);
                                    }
                                } else {
                                    ((LinearLayout) config.this.v_cab.getRootView().findViewById(R.id.ll_ad)).removeAllViews();
                                }
                                config config = config.this;
                                config.appnext_mostrar(config.v_cab.getContext());
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
                try {
                    anuncios.adView.loadAd(new AdRequest.Builder().build());
                } catch (Exception unused) {
                }
            } else if (intValue == 2) {
                appnext_mostrar(context);
            } else if (intValue == 3) {
                if (this.admob_tipo == AdSize.LARGE_BANNER && getResources().getConfiguration().orientation == 1) {
                    anuncios.adView_fb = new com.facebook.ads.AdView(context, this.fb_b_cod, com.facebook.ads.AdSize.BANNER_HEIGHT_90);
                } else {
                    anuncios.adView_fb = new com.facebook.ads.AdView(context, this.fb_b_cod, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                }
                if (this.admob_pos == 1) {
                    anuncios.adView_fb.setTag(Integer.valueOf(R.id.TAG_ESBANNER));
                    ((LinearLayout) this.v_cab).addView(anuncios.adView_fb);
                } else {
                    Activity activity2 = (Activity) context;
                    ((LinearLayout) activity2.findViewById(R.id.ll_ad)).setBackgroundColor(-7829368);
                    ((LinearLayout) activity2.findViewById(R.id.ll_ad)).setPadding(0, dp_to_px(this, 3), 0, 0);
                    ((LinearLayout) activity2.findViewById(R.id.ll_ad)).addView(anuncios.adView_fb);
                    ((LinearLayout) activity2.findViewById(R.id.ll_ad)).setVisibility(0);
                }
                this.banner_mostrando = true;
                anuncios.adView_fb.loadAd();
            } else if (intValue == 4) {
                anuncios.startAppBanner = new Banner(context, (BannerListener) new BannerListener() {
                    public void onClick(View view) {
                    }

                    public void onFailedToReceiveAd(View view) {
                    }

                    public void onImpression(View view) {
                    }

                    public void onReceiveAd(View view) {
                        if (config.this.v_cab != null) {
                            if (config.this.admob_pos != 1) {
                                LinearLayout linearLayout = (LinearLayout) config.this.v_cab.getRootView().findViewById(R.id.ll_ad);
                                if (linearLayout.getChildCount() == 0) {
                                    linearLayout.addView(view);
                                    linearLayout.setVisibility(0);
                                }
                            } else if (((LinearLayout) config.this.v_cab).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER)) == null) {
                                ((LinearLayout) config.this.v_cab).addView(view);
                            }
                            config.this.banner_mostrando = true;
                        }
                    }
                });
                anuncios.startAppBanner.setAdTag(AdPreferences.TYPE_BANNER);
                if (this.admob_pos == 1) {
                    anuncios.startAppBanner.setTag(Integer.valueOf(R.id.TAG_ESBANNER));
                }
                if (this.admob_tipo == AdSize.LARGE_BANNER && getResources().getConfiguration().orientation == 1) {
                    anuncios.startAppBanner.loadAd(320, 100);
                } else {
                    anuncios.startAppBanner.loadAd(320, 50);
                }
            } else if (intValue == 7) {
                if (UnityAds.isInitialized()) {
                    AnonymousClass3 r12 = new BannerView.IListener() {
                        public void onBannerClick(BannerView bannerView) {
                        }

                        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
                        }

                        public void onBannerLeftApplication(BannerView bannerView) {
                        }

                        public void onBannerShown(BannerView bannerView) {
                        }

                        public void onBannerLoaded(BannerView bannerView) {
                            LinearLayout linearLayout;
                            int i = config.this.admob_pos;
                            Integer valueOf = Integer.valueOf(R.id.TAG_ESBANNER);
                            if (i == 1) {
                                View findViewWithTag = config.this.v_cab.findViewWithTag(valueOf);
                                if (findViewWithTag != null) {
                                    ((LinearLayout) config.this.v_cab).removeView(findViewWithTag);
                                }
                            } else {
                                ((LinearLayout) config.this.v_cab.getRootView().findViewById(R.id.ll_ad)).removeAllViews();
                            }
                            anuncios.unityBanner = bannerView;
                            if (config.this.admob_pos == 1) {
                                anuncios.unityBanner.setTag(valueOf);
                                anuncios.unityBanner.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                                ((LinearLayout) config.this.v_cab).addView(anuncios.unityBanner);
                            } else {
                                try {
                                    linearLayout = (LinearLayout) config.this.v_cab.getRootView().findViewById(R.id.ll_ad);
                                } catch (Exception unused) {
                                    linearLayout = null;
                                }
                                if (linearLayout != null) {
                                    linearLayout.addView(anuncios.unityBanner);
                                    linearLayout.findViewById(R.id.ll_ad).setVisibility(0);
                                }
                            }
                            config.this.banner_mostrando = true;
                        }
                    };
                    UnityBannerSize unityBannerSize = new UnityBannerSize(320, 50);
                    if (this.admob_tipo == AdSize.LARGE_BANNER && getResources().getConfiguration().orientation == 1) {
                        unityBannerSize = new UnityBannerSize(320, 100);
                    }
                    anuncios.unityBanner = new BannerView((Activity) context, this.uni_b_cod, unityBannerSize);
                    anuncios.unityBanner.setListener(r12);
                    anuncios.unityBanner.load();
                }
            } else if (intValue == 8) {
                ISBannerSize iSBannerSize = ISBannerSize.BANNER;
                if (this.admob_tipo == AdSize.LARGE_BANNER && getResources().getConfiguration().orientation == 1) {
                    iSBannerSize = ISBannerSize.LARGE;
                }
                IronSourceBannerLayout ironSourceBannerLayout = this.isBanner_global;
                if (ironSourceBannerLayout != null) {
                    IronSource.destroyBanner(ironSourceBannerLayout);
                }
                IronSourceBannerLayout createBanner = IronSource.createBanner((Activity) context, iSBannerSize);
                this.isBanner_global = createBanner;
                createBanner.setBannerListener(new com.ironsource.mediationsdk.sdk.BannerListener() {
                    public void onBannerAdClicked() {
                    }

                    public void onBannerAdLeftApplication() {
                    }

                    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
                    }

                    public void onBannerAdScreenDismissed() {
                    }

                    public void onBannerAdScreenPresented() {
                    }

                    public void onBannerAdLoaded() {
                        LinearLayout linearLayout;
                        int i = config.this.admob_pos;
                        Integer valueOf = Integer.valueOf(R.id.TAG_ESBANNER);
                        if (i == 1) {
                            View findViewWithTag = config.this.v_cab.findViewWithTag(valueOf);
                            if (findViewWithTag != null) {
                                ((LinearLayout) config.this.v_cab).removeView(findViewWithTag);
                            }
                        } else {
                            ((LinearLayout) config.this.v_cab.getRootView().findViewById(R.id.ll_ad)).removeAllViews();
                        }
                        if (config.this.admob_pos == 1) {
                            config.this.isBanner_global.setTag(valueOf);
                            ((LinearLayout) config.this.v_cab).addView(config.this.isBanner_global);
                        } else {
                            try {
                                linearLayout = (LinearLayout) config.this.v_cab.getRootView().findViewById(R.id.ll_ad);
                            } catch (Exception unused) {
                                linearLayout = null;
                            }
                            if (linearLayout != null) {
                                linearLayout.addView(config.this.isBanner_global);
                                linearLayout.findViewById(R.id.ll_ad).setVisibility(0);
                            }
                        }
                        config.this.banner_mostrando = true;
                    }
                });
                IronSource.loadBanner(this.isBanner_global);
            } else if (intValue == 9) {
                anuncios.wortiseBanner = new BannerAd(context);
                anuncios.wortiseBanner.setAutoRefresh(false);
                if (this.admob_tipo == AdSize.LARGE_BANNER && getResources().getConfiguration().orientation == 1) {
                    adSize = com.wortise.ads.AdSize.HEIGHT_90;
                } else {
                    adSize = com.wortise.ads.AdSize.HEIGHT_50;
                }
                anuncios.wortiseBanner.setAdSize(adSize);
                anuncios.wortiseBanner.setAdUnitId(this.wortise_b_cod);
                anuncios.wortiseBanner.setListener(new BannerAd.Listener() {
                    public void onBannerClicked(BannerAd bannerAd) {
                    }

                    public void onBannerFailed(BannerAd bannerAd, AdError adError) {
                        Log.e("ara", "wortise banner failed:" + adError.toString());
                        if (!config.this.appnextb_cod.equals("") && config.this.appnext_ads != null && config.this.appnext_ads.size() > 0) {
                            config.this.appnext_mostrar(context);
                        }
                    }

                    public void onBannerLoaded(BannerAd bannerAd) {
                        if (config.this.admob_pos == 1) {
                            anuncios.wortiseBanner.setTag(Integer.valueOf(R.id.TAG_ESBANNER));
                            ((LinearLayout) config.this.v_cab).addView(anuncios.wortiseBanner);
                        } else {
                            ((LinearLayout) ((Activity) context).findViewById(R.id.ll_ad)).addView(anuncios.wortiseBanner);
                            ((LinearLayout) ((Activity) context).findViewById(R.id.ll_ad)).setVisibility(0);
                        }
                        config.this.banner_mostrando = true;
                    }
                });
                anuncios.wortiseBanner.loadAd();
            }
        }
        return anuncios;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    /* access modifiers changed from: protected */
    public void appnext_mostrar(Context context) {
        appnext_mostrar_2(context, 1, 1, -1, (String) null);
    }

    /* access modifiers changed from: protected */
    public void appnext_mostrar_2(Context context, int i, int i2, int i3, String str) {
        appnext_mostrar_3(context, i, i2, i3, str, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0256  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void appnext_mostrar_3(android.content.Context r17, int r18, int r19, int r20, java.lang.String r21, boolean r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r21
            java.util.ArrayList<com.appnext.nativeads.NativeAd> r5 = r0.appnext_ads
            if (r5 == 0) goto L_0x03a2
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x03a2
            r5 = r1
            android.app.Activity r5 = (android.app.Activity) r5
            android.view.WindowManager r6 = r5.getWindowManager()
            android.view.Display r6 = r6.getDefaultDisplay()
            android.graphics.Point r7 = new android.graphics.Point
            r7.<init>()
            r6.getSize(r7)
            int r6 = r7.x
            r7 = -1
            r8 = 1
            r9 = 0
            r10 = r20
            if (r10 != r7) goto L_0x0043
            java.util.Random r10 = new java.util.Random
            r10.<init>()
            java.util.ArrayList<com.appnext.nativeads.NativeAd> r11 = r0.appnext_ads
            int r11 = r11.size()
            int r11 = r11 - r8
            int r11 = r11 - r9
            int r11 = r11 + r8
            int r10 = r10.nextInt(r11)
            int r10 = r10 + r9
        L_0x0043:
            java.lang.String r11 = "layout_inflater"
            java.lang.Object r11 = r0.getSystemService(r11)
            android.view.LayoutInflater r11 = (android.view.LayoutInflater) r11
            r12 = 0
            r13 = 3
            if (r2 != r8) goto L_0x0065
            if (r3 != r13) goto L_0x005b
            r14 = 2131558431(0x7f0d001f, float:1.8742178E38)
            android.view.View r11 = r11.inflate(r14, r12)
            com.appnext.nativeads.NativeAdView r11 = (com.appnext.nativeads.NativeAdView) r11
            goto L_0x006e
        L_0x005b:
            r14 = 2131558429(0x7f0d001d, float:1.8742174E38)
            android.view.View r11 = r11.inflate(r14, r12)
            com.appnext.nativeads.NativeAdView r11 = (com.appnext.nativeads.NativeAdView) r11
            goto L_0x006e
        L_0x0065:
            r14 = 2131558430(0x7f0d001e, float:1.8742176E38)
            android.view.View r11 = r11.inflate(r14, r12)
            com.appnext.nativeads.NativeAdView r11 = (com.appnext.nativeads.NativeAdView) r11
        L_0x006e:
            int r12 = android.os.Build.VERSION.SDK_INT
            r14 = 20
            if (r12 <= r14) goto L_0x00bc
            r12 = 2131361908(0x7f0a0074, float:1.8343582E38)
            if (r2 != r8) goto L_0x0087
            if (r3 == r13) goto L_0x00bc
            android.view.View r4 = r11.findViewById(r12)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            java.lang.String r12 = "757575"
            progress_color(r4, r12)
            goto L_0x00bc
        L_0x0087:
            if (r4 == 0) goto L_0x00bc
            java.lang.String r14 = ""
            boolean r14 = r4.equals(r14)
            if (r14 != 0) goto L_0x00bc
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "#"
            r14.<init>(r15)
            r14.append(r4)
            java.lang.String r4 = r14.toString()
            boolean r4 = esClaro(r4)
            if (r4 == 0) goto L_0x00b1
            android.view.View r4 = r11.findViewById(r12)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            java.lang.String r12 = "FBFBFB"
            progress_color(r4, r12)
            goto L_0x00bc
        L_0x00b1:
            android.view.View r4 = r11.findViewById(r12)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            java.lang.String r12 = "727272"
            progress_color(r4, r12)
        L_0x00bc:
            java.util.ArrayList<com.appnext.nativeads.NativeAd> r4 = r0.appnext_ads
            java.lang.Object r4 = r4.get(r10)
            com.appnext.nativeads.NativeAd r4 = (com.appnext.nativeads.NativeAd) r4
            android.graphics.Typeface r10 = android.graphics.Typeface.defaultFromStyle(r9)
            r12 = 2131361912(0x7f0a0078, float:1.834359E38)
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r14 = r4.getAdTitle()
            r12.setText(r14)
            r14 = 2
            r15 = 2131361902(0x7f0a006e, float:1.834357E38)
            if (r2 != r8) goto L_0x0213
            r12.setTypeface(r10, r8)
            android.view.View r12 = r11.findViewById(r15)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r12.setTypeface(r10)
            android.view.View r10 = r11.findViewById(r15)
            android.widget.TextView r10 = (android.widget.TextView) r10
            java.lang.String r12 = r4.getAdDescription()
            r10.setText(r12)
            android.content.res.Resources r10 = r16.getResources()
            r12 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r10 = r10.getBoolean(r12)
            r12 = 4
            if (r10 == 0) goto L_0x010c
            android.view.View r10 = r11.findViewById(r15)
            r10.setTextDirection(r12)
        L_0x010c:
            java.lang.String r10 = r4.getStoreRating()
            if (r10 == 0) goto L_0x021a
            int r7 = r10.length()
            if (r7 != r13) goto L_0x021a
            java.lang.String r7 = r10.substring(r9, r8)     // Catch:{ Exception -> 0x012b }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x012b }
            java.lang.String r10 = r10.substring(r14, r13)     // Catch:{ Exception -> 0x0129 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x0129 }
            goto L_0x012e
        L_0x0129:
            goto L_0x012d
        L_0x012b:
            r7 = 0
        L_0x012d:
            r10 = 0
        L_0x012e:
            if (r10 >= r13) goto L_0x0132
        L_0x0130:
            r10 = 0
            goto L_0x0139
        L_0x0132:
            r15 = 7
            if (r10 <= r15) goto L_0x0138
            int r7 = r7 + 1
            goto L_0x0130
        L_0x0138:
            r10 = 5
        L_0x0139:
            if (r7 <= 0) goto L_0x021a
            r15 = 6
            if (r7 >= r15) goto L_0x021a
            r15 = 2131363080(0x7f0a0508, float:1.8345959E38)
            android.view.View r15 = r11.findViewById(r15)
            r15.setVisibility(r9)
            r15 = 2131363093(0x7f0a0515, float:1.8345985E38)
            if (r7 <= r8) goto L_0x01df
            r8 = 2131363083(0x7f0a050b, float:1.8345965E38)
            android.view.View r8 = r11.findViewById(r8)
            r8.setVisibility(r9)
            if (r7 <= r14) goto L_0x01b5
            r8 = 2131363086(0x7f0a050e, float:1.834597E38)
            android.view.View r8 = r11.findViewById(r8)
            r8.setVisibility(r9)
            if (r7 <= r13) goto L_0x0195
            r8 = 2131363089(0x7f0a0511, float:1.8345977E38)
            android.view.View r8 = r11.findViewById(r8)
            r8.setVisibility(r9)
            if (r7 <= r12) goto L_0x017d
            r7 = 2131363092(0x7f0a0514, float:1.8345983E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            goto L_0x021a
        L_0x017d:
            r7 = 5
            if (r10 != r7) goto L_0x018c
            r7 = 2131363094(0x7f0a0516, float:1.8345987E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            goto L_0x021a
        L_0x018c:
            android.view.View r7 = r11.findViewById(r15)
            r7.setVisibility(r9)
            goto L_0x021a
        L_0x0195:
            r7 = 5
            if (r10 != r7) goto L_0x01a3
            r7 = 2131363091(0x7f0a0513, float:1.8345981E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            goto L_0x01ad
        L_0x01a3:
            r7 = 2131363090(0x7f0a0512, float:1.834598E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
        L_0x01ad:
            android.view.View r7 = r11.findViewById(r15)
            r7.setVisibility(r9)
            goto L_0x021a
        L_0x01b5:
            r7 = 5
            if (r10 != r7) goto L_0x01c3
            r7 = 2131363088(0x7f0a0510, float:1.8345975E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            goto L_0x01cd
        L_0x01c3:
            r7 = 2131363087(0x7f0a050f, float:1.8345973E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
        L_0x01cd:
            r7 = 2131363090(0x7f0a0512, float:1.834598E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            android.view.View r7 = r11.findViewById(r15)
            r7.setVisibility(r9)
            goto L_0x021a
        L_0x01df:
            r7 = 5
            if (r10 != r7) goto L_0x01ed
            r7 = 2131363085(0x7f0a050d, float:1.8345969E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            goto L_0x01f7
        L_0x01ed:
            r7 = 2131363084(0x7f0a050c, float:1.8345967E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
        L_0x01f7:
            r7 = 2131363087(0x7f0a050f, float:1.8345973E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            r7 = 2131363090(0x7f0a0512, float:1.834598E38)
            android.view.View r7 = r11.findViewById(r7)
            r7.setVisibility(r9)
            android.view.View r7 = r11.findViewById(r15)
            r7.setVisibility(r9)
            goto L_0x021a
        L_0x0213:
            android.graphics.Typeface r7 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0219 }
            r12.setTypeface(r7)     // Catch:{ Exception -> 0x0219 }
            goto L_0x021a
        L_0x0219:
        L_0x021a:
            if (r22 != 0) goto L_0x0235
            r7 = 2131361904(0x7f0a0070, float:1.8343574E38)
            android.view.View r8 = r11.findViewById(r7)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setVisibility(r9)
            android.view.View r7 = r11.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            java.lang.String r8 = r4.getIconURL()
            r4.downloadAndDisplayImage(r1, r7, r8)
        L_0x0235:
            r1 = 1
            if (r2 != r1) goto L_0x024b
            if (r3 != r13) goto L_0x024b
            if (r22 != 0) goto L_0x024b
            r7 = 2131361905(0x7f0a0071, float:1.8343576E38)
            android.view.View r7 = r11.findViewById(r7)
            com.appnext.nativeads.MediaView r7 = (com.appnext.nativeads.MediaView) r7
            r7.setMute(r1)     // Catch:{ Exception -> 0x0248 }
        L_0x0248:
            r4.setMediaView(r7)
        L_0x024b:
            stikerwap.appdys.config$6 r1 = new stikerwap.appdys.config$6
            r1.<init>()
            r4.setAdListener(r1)
            r1 = 1
            if (r2 != r1) goto L_0x03a2
            r2 = 2131361934(0x7f0a008e, float:1.8343634E38)
            android.view.View r2 = r11.findViewById(r2)
            r7 = 8
            r2.setVisibility(r7)
            r2 = 1056964608(0x3f000000, float:0.5)
            r7 = 2131361917(0x7f0a007d, float:1.83436E38)
            r8 = 2131362302(0x7f0a01fe, float:1.834438E38)
            if (r3 != r1) goto L_0x02fb
            int r3 = r0.admob_pos
            if (r3 != r1) goto L_0x0282
            r1 = 2131361807(0x7f0a000f, float:1.8343377E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.setTag(r1)
            android.view.View r1 = r0.v_cab
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.addView(r11)
            goto L_0x0297
        L_0x0282:
            r1 = 2131362555(0x7f0a02fb, float:1.8344894E38)
            android.view.View r3 = r5.findViewById(r1)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.addView(r11)
            android.view.View r1 = r5.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.setVisibility(r9)
        L_0x0297:
            r1 = 1
            r0.banner_mostrando = r1
            android.content.res.Resources r3 = r16.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.orientation
            if (r3 != r14) goto L_0x02b5
            r3 = 2131361902(0x7f0a006e, float:1.834357E38)
            android.view.View r3 = r11.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setMaxLines(r1)
            r1 = 45
            goto L_0x02ce
        L_0x02b5:
            r3 = 2131361902(0x7f0a006e, float:1.834357E38)
            com.google.android.gms.ads.AdSize r5 = r0.admob_tipo
            com.google.android.gms.ads.AdSize r9 = com.google.android.gms.ads.AdSize.LARGE_BANNER
            if (r5 != r9) goto L_0x02cc
            android.view.View r3 = r11.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r5 = 1098907648(0x41800000, float:16.0)
            r3.setTextSize(r1, r5)
            r1 = 100
            goto L_0x02ce
        L_0x02cc:
            r1 = 60
        L_0x02ce:
            android.view.ViewGroup$LayoutParams r3 = r11.getLayoutParams()
            r3.width = r6
            android.view.ViewGroup$LayoutParams r3 = r11.getLayoutParams()
            float r1 = (float) r1
            android.content.res.Resources r5 = r16.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            float r1 = r1 * r5
            float r1 = r1 + r2
            int r1 = (int) r1
            r3.height = r1
            android.view.View r1 = r11.findViewById(r8)
            r4.registerClickableViews((android.view.View) r1)
            android.view.View r1 = r11.findViewById(r7)
            com.appnext.nativeads.NativeAdView r1 = (com.appnext.nativeads.NativeAdView) r1
            r4.setNativeAdView(r1)
            goto L_0x03a2
        L_0x02fb:
            r1 = 2131362624(0x7f0a0340, float:1.8345034E38)
            if (r3 != r14) goto L_0x0354
            android.view.View r1 = r5.findViewById(r1)
            r1.setVisibility(r9)
            r1 = 2131363374(0x7f0a062e, float:1.8346555E38)
            android.view.View r1 = r5.findViewById(r1)
            r1.setVisibility(r9)
            r1 = 2131362625(0x7f0a0341, float:1.8345036E38)
            android.view.View r3 = r5.findViewById(r1)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.removeAllViews()
            android.view.View r1 = r5.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.addView(r11)
            android.view.ViewGroup$LayoutParams r1 = r11.getLayoutParams()
            r1.width = r6
            android.view.ViewGroup$LayoutParams r1 = r11.getLayoutParams()
            r3 = 80
            float r3 = (float) r3
            android.content.res.Resources r5 = r16.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            float r3 = r3 * r5
            float r3 = r3 + r2
            int r2 = (int) r3
            r1.height = r2
            android.view.View r1 = r11.findViewById(r8)
            r4.registerClickableViews((android.view.View) r1)
            android.view.View r1 = r11.findViewById(r7)
            com.appnext.nativeads.NativeAdView r1 = (com.appnext.nativeads.NativeAdView) r1
            r4.setNativeAdView(r1)
            goto L_0x03a2
        L_0x0354:
            if (r3 != r13) goto L_0x03a2
            r2 = 2131362645(0x7f0a0355, float:1.8345076E38)
            android.view.View r2 = r5.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x0371
            int r1 = r2.getChildCount()
            r3 = 1
            int r1 = r1 - r3
            android.view.View r1 = r2.getChildAt(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.addView(r11)
            goto L_0x038b
        L_0x0371:
            android.view.View r2 = r5.findViewById(r1)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r2.addView(r11)
            android.view.View r1 = r5.findViewById(r1)
            r1.setVisibility(r9)
            r1 = 2131362565(0x7f0a0305, float:1.8344914E38)
            android.view.View r1 = r5.findViewById(r1)
            r1.setVisibility(r9)
        L_0x038b:
            android.view.ViewGroup$LayoutParams r1 = r11.getLayoutParams()
            r2 = -1
            r1.width = r2
            android.view.View r1 = r11.findViewById(r8)
            r4.registerClickableViews((android.view.View) r1)
            android.view.View r1 = r11.findViewById(r7)
            com.appnext.nativeads.NativeAdView r1 = (com.appnext.nativeads.NativeAdView) r1
            r4.setNativeAdView(r1)
        L_0x03a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.appnext_mostrar_3(android.content.Context, int, int, int, java.lang.String, boolean):void");
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        ListView listView;
        if (this.tipomenu == 1 && this.ma != null && str.equals("ico_cargado")) {
            this.ma.notifyDataSetChanged();
        } else if (this.tipomenu == 1 && (listView = this.mDrawerList) != null && listView.getHeaderViewsCount() > 0 && str.equals("slider_v_act")) {
            RelativeLayout relativeLayout = (RelativeLayout) this.mDrawerList.findViewById(R.id.ll_drawer);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_drawer);
            try {
                FileInputStream openFileInput = openFileInput("slider_header");
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileInput.getFD());
                openFileInput.close();
                imageView.setImageBitmap(decodeFileDescriptor);
            } catch (Exception | OutOfMemoryError unused) {
            }
            if (this.slider_h > 0) {
                relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, this.slider_h));
            }
            relativeLayout.findViewById(R.id.pb_drawer).setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
            imageView.setVisibility(0);
            imageView.startAnimation(loadAnimation);
        }
    }

    static void fade_in(ImageView imageView) {
        imageView.setAlpha(0.0f);
        imageView.setVisibility(0);
        imageView.animate().alpha(1.0f).setDuration(200);
    }

    /* access modifiers changed from: package-private */
    public void recuperar_vars() {
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        String[] split = sharedPreferences.getString("idseccs", "").split(",");
        String string = sharedPreferences.getString("idofics", "");
        String[] strArr = new String[0];
        if (!string.equals("")) {
            strArr = string.split(",");
        }
        crear_globales(split, strArr, (Bundle) null, (Intent) null);
        this.ind_secc_sel = sharedPreferences.getInt("ind_secc_sel", 0);
        this.ind_secc_sel_2 = sharedPreferences.getInt("ind_secc_sel_2", 0);
        try {
            establecerFuente(Integer.parseInt(sharedPreferences.getString("ft", "0")));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static Activity getActivityFromView(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int incluir_menu(Context context) {
        return incluir_menu_2(context, true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x06de, code lost:
        r1 = (android.widget.HorizontalScrollView) r9.findViewById(stikerwap.appdys.R.id.hsv_menu);
     */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0ce7  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0d03  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int incluir_menu_2(android.content.Context r29, java.lang.Boolean r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            java.lang.String r2 = r0.c1
            if (r2 != 0) goto L_0x000b
            r28.recuperar_vars()
        L_0x000b:
            boolean r2 = r0.autoapagado
            if (r2 != 0) goto L_0x001f
            r2 = r1
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ Exception -> 0x001e }
            android.view.Window r2 = r2.getWindow()     // Catch:{ Exception -> 0x001e }
            r3 = 128(0x80, float:1.794E-43)
            r4 = 128(0x80, float:1.794E-43)
            r2.setFlags(r3, r4)     // Catch:{ Exception -> 0x001e }
            goto L_0x001f
        L_0x001e:
        L_0x001f:
            boolean r2 = r0.screenshot_inhab
            if (r2 == 0) goto L_0x0033
            r2 = r1
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ Exception -> 0x0032 }
            android.view.Window r2 = r2.getWindow()     // Catch:{ Exception -> 0x0032 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r4 = 8192(0x2000, float:1.14794E-41)
            r2.setFlags(r3, r4)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0033
        L_0x0032:
        L_0x0033:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 20
            if (r2 <= r3) goto L_0x0041
            r2 = r1
            android.app.Activity r2 = (android.app.Activity) r2
            java.lang.String r3 = r0.c1
            aplicar_color_top(r2, r3)
        L_0x0041:
            android.content.res.Resources r2 = r28.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            r3 = 1106771968(0x41f80000, float:31.0)
            float r3 = r3 * r2
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            r5 = 1105199104(0x41e00000, float:28.0)
            float r5 = r5 * r2
            float r5 = r5 + r4
            int r5 = (int) r5
            r6 = 1111490560(0x42400000, float:48.0)
            float r6 = r6 * r2
            float r6 = r6 + r4
            int r6 = (int) r6
            r7 = 1124335616(0x43040000, float:132.0)
            float r7 = r7 * r2
            float r7 = r7 + r4
            int r7 = (int) r7
            r8 = r1
            android.app.Activity r8 = (android.app.Activity) r8
            r9 = 2131362182(0x7f0a0186, float:1.8344137E38)
            android.view.View r9 = r8.findViewById(r9)
            androidx.drawerlayout.widget.DrawerLayout r9 = (androidx.drawerlayout.widget.DrawerLayout) r9
            int r10 = r0.tipomenu
            r11 = 1
            if (r10 != r11) goto L_0x007c
            boolean r10 = r30.booleanValue()
            if (r10 != 0) goto L_0x0081
        L_0x007c:
            if (r9 == 0) goto L_0x0081
            r9.setDrawerLockMode(r11)
        L_0x0081:
            r9 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r9 = r8.findViewById(r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            android.view.WindowManager r10 = r8.getWindowManager()
            android.view.Display r10 = r10.getDefaultDisplay()
            android.graphics.Point r12 = new android.graphics.Point
            r12.<init>()
            r10.getSize(r12)
            int r10 = r12.x
            android.view.LayoutInflater r12 = android.view.LayoutInflater.from(r29)
            android.graphics.drawable.GradientDrawable r13 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r14 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r15 = 2
            int[] r4 = new int[r15]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r11 = "#"
            r15.<init>(r11)
            r17 = r3
            java.lang.String r3 = r0.c1
            r15.append(r3)
            java.lang.String r3 = r15.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r15 = 0
            r4[r15] = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            java.lang.String r15 = r0.c2
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r15 = 1
            r4[r15] = r3
            r13.<init>(r14, r4)
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r4 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r14 = 2
            int[] r15 = new int[r14]
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r11)
            r18 = r7
            java.lang.String r7 = r0.c1
            r14.append(r7)
            java.lang.String r7 = r14.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r14 = 0
            r15[r14] = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            java.lang.String r14 = r0.c2
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r14 = 1
            r15[r14] = r7
            r3.<init>(r4, r15)
            int r4 = r0.tipomenu
            if (r4 != r14) goto L_0x0113
            int r10 = r10 - r5
        L_0x0113:
            r5 = 0
            if (r4 != 0) goto L_0x0151
            boolean r4 = r30.booleanValue()
            if (r4 == 0) goto L_0x0151
            android.content.res.Resources r4 = r28.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            float r4 = r4.density
            r7 = 1140457472(0x43fa0000, float:500.0)
            float r4 = r4 * r7
            r7 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r7
            int r4 = (int) r4
            if (r10 >= r4) goto L_0x0151
            r4 = 2131558460(0x7f0d003c, float:1.8742236E38)
            android.view.View r4 = r12.inflate(r4, r5)
            r0.v_cab = r4
            r7 = 2131362040(0x7f0a00f8, float:1.834385E38)
            android.view.View r4 = r4.findViewById(r7)
            r4.setBackgroundDrawable(r13)
            android.view.View r4 = r0.v_cab
            r7 = 2131362038(0x7f0a00f6, float:1.8343845E38)
            android.view.View r4 = r4.findViewById(r7)
            r4.setBackgroundDrawable(r3)
            r3 = 1
            goto L_0x015e
        L_0x0151:
            r3 = 2131558459(0x7f0d003b, float:1.8742234E38)
            android.view.View r3 = r12.inflate(r3, r5)
            r0.v_cab = r3
            r3.setBackgroundDrawable(r13)
            r3 = 0
        L_0x015e:
            android.view.View r4 = r0.v_cab
            r7 = 0
            r9.addView(r4, r7)
            android.view.View r4 = r0.v_cab
            r7 = 2131362352(0x7f0a0230, float:1.8344482E38)
            android.view.View r4 = r4.findViewById(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            java.lang.String r13 = r0.c_linea
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r4.setBackgroundColor(r7)
            boolean r4 = r30.booleanValue()
            r13 = 3
            if (r4 == 0) goto L_0x0661
            r4 = 4
            int[] r14 = new int[r4]
            r0.icos_a = r14
            int r14 = r0.ico_ofics_ord
            r19 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r20 = 2131362363(0x7f0a023b, float:1.8344504E38)
            r21 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r22 = 2131362362(0x7f0a023a, float:1.8344502E38)
            r23 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r24 = 2131362361(0x7f0a0239, float:1.83445E38)
            r25 = 2131362356(0x7f0a0234, float:1.834449E38)
            if (r14 <= 0) goto L_0x0241
            stikerwap.appdys.Oficina[] r15 = r0.oficinas_a
            int r15 = r15.length
            if (r15 > 0) goto L_0x01b0
            int r15 = r0.ico_ofics_idsec
            if (r15 <= 0) goto L_0x0241
        L_0x01b0:
            r15 = 1
            if (r14 != r15) goto L_0x01ba
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x01d8
        L_0x01ba:
            r15 = 2
            if (r14 != r15) goto L_0x01c4
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x01d8
        L_0x01c4:
            if (r14 != r13) goto L_0x01cd
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x01d8
        L_0x01cd:
            if (r14 != r4) goto L_0x01d6
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
            goto L_0x01d8
        L_0x01d6:
            r14 = 0
            r15 = 0
        L_0x01d8:
            android.view.View r26 = r8.findViewById(r14)
            r5 = r26
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r4 = r0.ico_ofics_imgperso
            if (r4 == 0) goto L_0x01ea
            java.lang.String r4 = "ico_ofics"
            r0.file_to_iv(r4, r5)
            goto L_0x020f
        L_0x01ea:
            android.content.res.Resources r4 = r8.getResources()
            r13 = 2131231074(0x7f080162, float:1.8078219E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r7 = r0.c_icos_top
            r13.append(r7)
            java.lang.String r7 = r13.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            android.graphics.PorterDuff$Mode r13 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r7, r13)
            r5.setImageDrawable(r4)
        L_0x020f:
            int r4 = r0.ico_ofics_ord
            int r4 = r4 + 10000
            r5.setId(r4)
            int r4 = r0.ico_ofics_ord
            int r4 = r4 + 10000
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r7, r4)
            int[] r4 = r0.icos_a
            int r5 = r0.ico_ofics_ord
            int r5 = r5 + 10000
            r7 = 0
            r4[r7] = r5
            android.view.View r4 = r8.findViewById(r15)
            r0.f_focus_tv(r4)
            android.view.View r4 = r8.findViewById(r15)
            r4.setVisibility(r7)
            if (r3 != 0) goto L_0x023e
            int r10 = r10 - r6
        L_0x023e:
            r4 = 1
            r5 = 1
            goto L_0x0245
        L_0x0241:
            r4 = 0
            r5 = 0
            r14 = 0
            r15 = 0
        L_0x0245:
            int r7 = r0.ico_share_ord
            if (r7 <= 0) goto L_0x02dd
            r13 = 1
            if (r7 != r13) goto L_0x0253
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x0270
        L_0x0253:
            r5 = 2
            if (r7 != r5) goto L_0x025d
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x0270
        L_0x025d:
            r5 = 3
            if (r7 != r5) goto L_0x0267
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x0270
        L_0x0267:
            r5 = 4
            if (r7 != r5) goto L_0x0270
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x0270:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r7 = r0.ico_share_imgperso
            if (r7 == 0) goto L_0x0282
            java.lang.String r7 = "ico_share"
            r0.file_to_iv(r7, r5)
            r27 = r14
            goto L_0x02a9
        L_0x0282:
            android.content.res.Resources r7 = r8.getResources()
            r13 = 2131231058(0x7f080152, float:1.8078186E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r27 = r14
            java.lang.String r14 = r0.c_icos_top
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r13, r14)
            r5.setImageDrawable(r7)
        L_0x02a9:
            int r7 = r0.ico_share_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_share_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_share_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            int r4 = r4 + 1
            android.view.View r5 = r8.findViewById(r15)
            r0.f_focus_tv(r5)
            android.view.View r5 = r8.findViewById(r15)
            r7 = 0
            r5.setVisibility(r7)
            if (r3 != 0) goto L_0x02da
            int r10 = r10 - r6
        L_0x02da:
            r14 = r27
            r5 = 1
        L_0x02dd:
            int r7 = r0.ico_search_ord
            if (r7 <= 0) goto L_0x0375
            r13 = 1
            if (r7 != r13) goto L_0x02eb
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x0308
        L_0x02eb:
            r5 = 2
            if (r7 != r5) goto L_0x02f5
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x0308
        L_0x02f5:
            r5 = 3
            if (r7 != r5) goto L_0x02ff
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x0308
        L_0x02ff:
            r5 = 4
            if (r7 != r5) goto L_0x0308
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x0308:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r7 = r0.ico_search_imgperso
            if (r7 == 0) goto L_0x031a
            java.lang.String r7 = "ico_search"
            r0.file_to_iv(r7, r5)
            r27 = r14
            goto L_0x0341
        L_0x031a:
            android.content.res.Resources r7 = r8.getResources()
            r13 = 2131230951(0x7f0800e7, float:1.807797E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r27 = r14
            java.lang.String r14 = r0.c_icos_top
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r13, r14)
            r5.setImageDrawable(r7)
        L_0x0341:
            int r7 = r0.ico_search_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_search_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_search_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            int r4 = r4 + 1
            android.view.View r5 = r8.findViewById(r15)
            r0.f_focus_tv(r5)
            android.view.View r5 = r8.findViewById(r15)
            r7 = 0
            r5.setVisibility(r7)
            if (r3 != 0) goto L_0x0372
            int r10 = r10 - r6
        L_0x0372:
            r14 = r27
            r5 = 1
        L_0x0375:
            int r7 = r0.ico_busc_ord
            if (r7 <= 0) goto L_0x0431
            int r7 = r0.ico_busc_idsec
            if (r7 <= 0) goto L_0x0381
            r27 = r5
        L_0x037f:
            r5 = 1
            goto L_0x0397
        L_0x0381:
            r7 = 0
        L_0x0382:
            stikerwap.appdys.Seccion[] r13 = r0.secciones_a
            r27 = r5
            int r5 = r13.length
            if (r7 >= r5) goto L_0x0396
            r5 = r13[r7]
            int r5 = r5.tipo
            r13 = 5
            if (r5 != r13) goto L_0x0391
            goto L_0x037f
        L_0x0391:
            int r7 = r7 + 1
            r5 = r27
            goto L_0x0382
        L_0x0396:
            r5 = 0
        L_0x0397:
            if (r5 == 0) goto L_0x0433
            int r5 = r0.ico_busc_ord
            r7 = 1
            if (r5 != r7) goto L_0x03a5
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x03c2
        L_0x03a5:
            r7 = 2
            if (r5 != r7) goto L_0x03af
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x03c2
        L_0x03af:
            r7 = 3
            if (r5 != r7) goto L_0x03b9
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x03c2
        L_0x03b9:
            r7 = 4
            if (r5 != r7) goto L_0x03c2
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x03c2:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r7 = r0.ico_busc_imgperso
            if (r7 == 0) goto L_0x03d4
            java.lang.String r7 = "ico_busc"
            r0.file_to_iv(r7, r5)
            r27 = r14
            goto L_0x03fb
        L_0x03d4:
            android.content.res.Resources r7 = r8.getResources()
            r13 = 2131230951(0x7f0800e7, float:1.807797E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r27 = r14
            java.lang.String r14 = r0.c_icos_top
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r13, r14)
            r5.setImageDrawable(r7)
        L_0x03fb:
            int r7 = r0.ico_busc_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_busc_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_busc_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            int r4 = r4 + 1
            android.view.View r5 = r8.findViewById(r15)
            r0.f_focus_tv(r5)
            android.view.View r5 = r8.findViewById(r15)
            r7 = 0
            r5.setVisibility(r7)
            if (r3 != 0) goto L_0x042c
            int r10 = r10 - r6
        L_0x042c:
            r14 = r27
            r27 = 1
            goto L_0x0433
        L_0x0431:
            r27 = r5
        L_0x0433:
            int r5 = r0.ico_exit_ord
            if (r5 <= 0) goto L_0x04cc
            r7 = 1
            if (r5 != r7) goto L_0x0441
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x045e
        L_0x0441:
            r7 = 2
            if (r5 != r7) goto L_0x044b
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x045e
        L_0x044b:
            r7 = 3
            if (r5 != r7) goto L_0x0455
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x045e
        L_0x0455:
            r7 = 4
            if (r5 != r7) goto L_0x045e
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x045e:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r7 = r0.ico_exit_imgperso
            if (r7 == 0) goto L_0x0470
            java.lang.String r7 = "ico_exit"
            r0.file_to_iv(r7, r5)
            r27 = r14
            goto L_0x0497
        L_0x0470:
            android.content.res.Resources r7 = r8.getResources()
            r13 = 2131231678(0x7f0803be, float:1.8079444E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r27 = r14
            java.lang.String r14 = r0.c_icos_top
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r13, r14)
            r5.setImageDrawable(r7)
        L_0x0497:
            int r7 = r0.ico_exit_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_exit_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_exit_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            int r4 = r4 + 1
            android.view.View r5 = r8.findViewById(r15)
            r0.f_focus_tv(r5)
            android.view.View r5 = r8.findViewById(r15)
            r7 = 0
            r5.setVisibility(r7)
            if (r3 != 0) goto L_0x04c8
            int r10 = r10 - r6
        L_0x04c8:
            r14 = r27
            r27 = 1
        L_0x04cc:
            int r5 = r0.ico_notif_ord
            if (r5 <= 0) goto L_0x0568
            r7 = 1
            if (r5 != r7) goto L_0x04da
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x04f7
        L_0x04da:
            r7 = 2
            if (r5 != r7) goto L_0x04e4
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x04f7
        L_0x04e4:
            r7 = 3
            if (r5 != r7) goto L_0x04ee
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x04f7
        L_0x04ee:
            r7 = 4
            if (r5 != r7) goto L_0x04f7
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x04f7:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r7 = r0.ico_notif_imgperso
            if (r7 == 0) goto L_0x0509
            java.lang.String r7 = "ico_notif"
            r0.file_to_iv(r7, r5)
            r27 = r14
            goto L_0x0530
        L_0x0509:
            android.content.res.Resources r7 = r8.getResources()
            r13 = 2131231600(0x7f080370, float:1.8079286E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r27 = r14
            java.lang.String r14 = r0.c_icos_top
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r13, r14)
            r5.setImageDrawable(r7)
        L_0x0530:
            int r7 = r0.ico_notif_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_notif_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_notif_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            int r4 = r4 + 1
            android.view.View r5 = r8.findViewById(r15)
            r0.f_focus_tv(r5)
            android.view.View r5 = r8.findViewById(r15)
            r7 = 0
            r5.setVisibility(r7)
            mostrar_notif_noleidas(r29)
            if (r3 != 0) goto L_0x0564
            int r10 = r10 - r6
        L_0x0564:
            r14 = r27
            r27 = 1
        L_0x0568:
            int r5 = r0.ico_perfil_ord
            if (r5 <= 0) goto L_0x05cf
            r7 = 1
            if (r5 != r7) goto L_0x0576
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x0593
        L_0x0576:
            r7 = 2
            if (r5 != r7) goto L_0x0580
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x0593
        L_0x0580:
            r7 = 3
            if (r5 != r7) goto L_0x058a
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x0593
        L_0x058a:
            r7 = 4
            if (r5 != r7) goto L_0x0593
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x0593:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0.mostrar_ico_perfil(r1, r5)
            int r7 = r0.ico_perfil_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_perfil_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_perfil_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            int r4 = r4 + 1
            android.view.View r5 = r8.findViewById(r15)
            r0.f_focus_tv(r5)
            android.view.View r5 = r8.findViewById(r15)
            r7 = 0
            r5.setVisibility(r7)
            if (r3 != 0) goto L_0x05cd
            int r10 = r10 - r6
        L_0x05cd:
            r27 = 1
        L_0x05cf:
            int r5 = r0.ico_sinads_ord
            if (r5 <= 0) goto L_0x0663
            r7 = 1
            if (r5 != r7) goto L_0x05dd
            r14 = 2131362356(0x7f0a0234, float:1.834449E38)
            r15 = 2131362361(0x7f0a0239, float:1.83445E38)
            goto L_0x05fa
        L_0x05dd:
            r7 = 2
            if (r5 != r7) goto L_0x05e7
            r14 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r15 = 2131362362(0x7f0a023a, float:1.8344502E38)
            goto L_0x05fa
        L_0x05e7:
            r7 = 3
            if (r5 != r7) goto L_0x05f1
            r14 = 2131362358(0x7f0a0236, float:1.8344494E38)
            r15 = 2131362363(0x7f0a023b, float:1.8344504E38)
            goto L_0x05fa
        L_0x05f1:
            r7 = 4
            if (r5 != r7) goto L_0x05fa
            r14 = 2131362359(0x7f0a0237, float:1.8344496E38)
            r15 = 2131362364(0x7f0a023c, float:1.8344506E38)
        L_0x05fa:
            android.view.View r5 = r8.findViewById(r14)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            boolean r7 = r0.ico_sinads_imgperso
            if (r7 == 0) goto L_0x060a
            java.lang.String r7 = "ico_sinads"
            r0.file_to_iv(r7, r5)
            goto L_0x062f
        L_0x060a:
            android.content.res.Resources r7 = r8.getResources()
            r13 = 2131231688(0x7f0803c8, float:1.8079464E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r14 = r0.c_icos_top
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r13, r14)
            r5.setImageDrawable(r7)
        L_0x062f:
            int r7 = r0.ico_sinads_ord
            int r7 = r7 + 10000
            r5.setId(r7)
            int r7 = r0.ico_sinads_ord
            int r7 = r7 + 10000
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r13, r7)
            int[] r5 = r0.icos_a
            int r7 = r0.ico_sinads_ord
            int r7 = r7 + 10000
            r5[r4] = r7
            android.view.View r4 = r8.findViewById(r15)
            r0.f_focus_tv(r4)
            android.view.View r4 = r8.findViewById(r15)
            r5 = 0
            r4.setVisibility(r5)
            if (r3 != 0) goto L_0x065e
            int r10 = r10 - r6
        L_0x065e:
            r27 = 1
            goto L_0x0663
        L_0x0661:
            r27 = 0
        L_0x0663:
            r4 = 2131362370(0x7f0a0242, float:1.8344519E38)
            android.view.View r4 = r8.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            java.lang.String r5 = "icohome"
            int[] r5 = r0.file_to_iv(r5, r4)
            r7 = 0
            r13 = r5[r7]
            if (r13 != 0) goto L_0x067f
            r7 = 1
            r13 = r5[r7]
            if (r13 == 0) goto L_0x067d
            goto L_0x067f
        L_0x067d:
            r7 = 0
            goto L_0x0680
        L_0x067f:
            r7 = 1
        L_0x0680:
            boolean r13 = r30.booleanValue()
            r14 = 8
            if (r13 != 0) goto L_0x0698
            if (r7 != 0) goto L_0x0696
            android.view.View r1 = r0.v_cab
            r2 = 2131362352(0x7f0a0230, float:1.8344482E38)
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r14)
        L_0x0696:
            r13 = 0
            return r13
        L_0x0698:
            r13 = 0
            if (r3 != 0) goto L_0x06ba
            r15 = r5[r13]
            float r13 = (float) r15
            float r13 = r13 * r2
            r15 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 + r15
            int r13 = (int) r13
            r16 = 1
            r5 = r5[r16]
            float r5 = (float) r5
            float r5 = r5 * r2
            float r5 = r5 + r15
            int r2 = (int) r5
            if (r2 <= r6) goto L_0x06b2
            int r13 = r13 * r6
            int r13 = r13 / r2
        L_0x06b2:
            r2 = r18
            int r2 = java.lang.Math.min(r13, r2)
            int r10 = r10 - r2
            goto L_0x06d2
        L_0x06ba:
            if (r27 != 0) goto L_0x06d2
            r2 = 0
            r6 = r5[r2]
            if (r6 != 0) goto L_0x06d2
            r2 = 1
            r5 = r5[r2]
            if (r5 != 0) goto L_0x06d2
            android.view.View r2 = r0.v_cab
            r5 = 2131362040(0x7f0a00f8, float:1.834385E38)
            android.view.View r2 = r2.findViewById(r5)
            r2.setVisibility(r14)
        L_0x06d2:
            r2 = 0
            r0.nsecc_mostradas = r2
            int r2 = r0.tipomenu
            if (r2 != 0) goto L_0x0a39
            int r1 = r0.t_mas
            r2 = 3
            if (r1 != r2) goto L_0x070f
            r1 = 2131362353(0x7f0a0231, float:1.8344484E38)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.HorizontalScrollView r1 = (android.widget.HorizontalScrollView) r1
            if (r1 == 0) goto L_0x070f
            java.util.Map<java.lang.Integer, java.lang.Boolean> r2 = hsv_situado
            int r4 = r8.hashCode()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6 = 0
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r6)
            r2.put(r4, r9)
            stikerwap.appdys.config$7 r2 = new stikerwap.appdys.config$7     // Catch:{ Exception -> 0x070f }
            r2.<init>(r1)     // Catch:{ Exception -> 0x070f }
            r1.post(r2)     // Catch:{ Exception -> 0x070f }
            android.view.ViewTreeObserver r2 = r1.getViewTreeObserver()     // Catch:{ Exception -> 0x070f }
            stikerwap.appdys.config$8 r4 = new stikerwap.appdys.config$8     // Catch:{ Exception -> 0x070f }
            r4.<init>(r1)     // Catch:{ Exception -> 0x070f }
            r2.addOnScrollChangedListener(r4)     // Catch:{ Exception -> 0x070f }
        L_0x070f:
            r1 = 2131361804(0x7f0a000c, float:1.834337E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r2 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r2 = -1
        L_0x071e:
            int r6 = r4.intValue()
            stikerwap.appdys.Seccion[] r8 = r0.secciones_a
            int r9 = r8.length
            if (r6 >= r9) goto L_0x0740
            int r6 = r4.intValue()
            r6 = r8[r6]
            boolean r6 = r6.oculta
            if (r6 != 0) goto L_0x0735
            int r2 = r4.intValue()
        L_0x0735:
            int r4 = r4.intValue()
            r6 = 1
            int r4 = r4 + r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x071e
        L_0x0740:
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r4 = 0
        L_0x0746:
            int r8 = r6.intValue()
            r9 = 2131363168(0x7f0a0560, float:1.8346137E38)
            if (r8 > r2) goto L_0x093e
            stikerwap.appdys.Seccion[] r8 = r0.secciones_a
            int r13 = r6.intValue()
            r8 = r8[r13]
            boolean r8 = r8.oculta
            if (r8 != 0) goto L_0x0932
            r8 = 2131558698(0x7f0d012a, float:1.874272E38)
            r13 = 0
            android.view.View r8 = r12.inflate(r8, r13)
            int r13 = r6.intValue()
            if (r13 <= 0) goto L_0x078e
            boolean r13 = r0.sep_secc
            if (r13 == 0) goto L_0x078e
            android.view.View r13 = r8.findViewById(r9)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            java.lang.String r5 = r0.c_sep_secc
            r15.append(r5)
            java.lang.String r5 = r15.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            r13.setBackgroundColor(r5)
            android.view.View r5 = r8.findViewById(r9)
            r13 = 0
            r5.setVisibility(r13)
        L_0x078e:
            r5 = 2131363461(0x7f0a0685, float:1.8346731E38)
            android.view.View r5 = r8.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r13 = r6.intValue()
            int r15 = r0.ind_secc_sel
            if (r13 != r15) goto L_0x082f
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r15 = r0.c_secc_activ
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            r5.setTextColor(r13)
            int r13 = r0.t_ind
            if (r13 <= 0) goto L_0x0804
            r15 = 3
            if (r13 >= r15) goto L_0x0804
            r15 = 1
            if (r13 != r15) goto L_0x07ca
            android.content.res.Resources r13 = r28.getResources()
            r15 = 2131231681(0x7f0803c1, float:1.807945E38)
            android.graphics.drawable.Drawable r13 = r13.getDrawable(r15)
            goto L_0x07d5
        L_0x07ca:
            android.content.res.Resources r13 = r28.getResources()
            r15 = 2131231680(0x7f0803c0, float:1.8079448E38)
            android.graphics.drawable.Drawable r13 = r13.getDrawable(r15)
        L_0x07d5:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            java.lang.String r9 = r0.c_ind
            r15.append(r9)
            java.lang.String r9 = r15.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r13.setColorFilter(r9, r15)
            r9 = 2131362498(0x7f0a02c2, float:1.8344778E38)
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r9.setImageDrawable(r13)
            r9 = 2131362498(0x7f0a02c2, float:1.8344778E38)
            android.view.View r9 = r8.findViewById(r9)
            r13 = 0
            r9.setVisibility(r13)
            goto L_0x0844
        L_0x0804:
            r9 = 3
            if (r13 != r9) goto L_0x0844
            r9 = 2131362499(0x7f0a02c3, float:1.834478E38)
            android.view.View r9 = r8.findViewById(r9)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r15 = r0.c_ind
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            int r13 = android.graphics.Color.parseColor(r13)
            r9.setBackgroundColor(r13)
            r9 = 2131362499(0x7f0a02c3, float:1.834478E38)
            android.view.View r9 = r8.findViewById(r9)
            r13 = 0
            r9.setVisibility(r13)
            goto L_0x0844
        L_0x082f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r13 = r0.c_secc_noactiv
            r9.append(r13)
            java.lang.String r9 = r9.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            r5.setTextColor(r9)
        L_0x0844:
            stikerwap.appdys.Seccion[] r9 = r0.secciones_a
            int r13 = r6.intValue()
            r9 = r9[r13]
            java.lang.String r9 = r9.titulo
            r5.setText(r9)
            r1.addView(r8)
            int r9 = r0.t_mas
            r13 = 3
            if (r9 == r13) goto L_0x0890
            r9 = 0
            r8.measure(r9, r9)
            int r9 = r6.intValue()
            if (r9 != r2) goto L_0x0865
            r17 = 0
        L_0x0865:
            int r9 = r0.nsecc_mostradas
            if (r9 != 0) goto L_0x0890
        L_0x0869:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r4
            int r9 = r9 + r17
            if (r9 <= r10) goto L_0x0890
            java.lang.CharSequence r9 = r5.getText()
            java.lang.CharSequence r13 = r5.getText()
            int r13 = r13.length()
            r15 = 1
            int r13 = r13 - r15
            r15 = 0
            java.lang.CharSequence r9 = r9.subSequence(r15, r13)
            java.lang.String r9 = r9.toString()
            r5.setText(r9)
            r8.measure(r15, r15)
            goto L_0x0869
        L_0x0890:
            int r9 = r0.t_mas
            r13 = 3
            if (r9 == r13) goto L_0x0919
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r4
            int r9 = r9 + r17
            if (r9 <= r10) goto L_0x0919
            r5.setVisibility(r14)
            r4 = 2131362498(0x7f0a02c2, float:1.8344778E38)
            android.view.View r4 = r8.findViewById(r4)
            r4.setVisibility(r14)
            r4 = 2131362499(0x7f0a02c3, float:1.834478E38)
            android.view.View r4 = r8.findViewById(r4)
            r4.setVisibility(r14)
            r4 = 2131362489(0x7f0a02b9, float:1.834476E38)
            android.view.View r4 = r8.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r5 = 2131362386(0x7f0a0252, float:1.8344551E38)
            r4.setId(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r4.setTag(r6, r5)
            int r5 = r0.t_mas
            r6 = 1
            if (r5 != r6) goto L_0x08df
            android.content.res.Resources r5 = r28.getResources()
            r6 = 2131231439(0x7f0802cf, float:1.807896E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            goto L_0x08f9
        L_0x08df:
            r6 = 2
            if (r5 != r6) goto L_0x08ee
            android.content.res.Resources r5 = r28.getResources()
            r6 = 2131231440(0x7f0802d0, float:1.8078961E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            goto L_0x08f9
        L_0x08ee:
            android.content.res.Resources r5 = r28.getResources()
            r6 = 2131231436(0x7f0802cc, float:1.8078953E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
        L_0x08f9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r11)
            java.lang.String r8 = r0.c_icos_top
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            int r6 = android.graphics.Color.parseColor(r6)
            android.graphics.PorterDuff$Mode r8 = android.graphics.PorterDuff.Mode.MULTIPLY
            r5.setColorFilter(r6, r8)
            r4.setImageDrawable(r5)
            r5 = 0
            r4.setVisibility(r5)
            r4 = 1
            goto L_0x093f
        L_0x0919:
            int r9 = r6.intValue()
            r5.setId(r9)
            r9 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r5.setTag(r9, r6)
            int r5 = r0.nsecc_mostradas
            r9 = 1
            int r5 = r5 + r9
            r0.nsecc_mostradas = r5
            int r5 = r8.getMeasuredWidth()
            int r4 = r4 + r5
            goto L_0x0933
        L_0x0932:
            r9 = 1
        L_0x0933:
            int r5 = r6.intValue()
            int r5 = r5 + r9
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            goto L_0x0746
        L_0x093e:
            r4 = 0
        L_0x093f:
            r5 = -1
            if (r2 != r5) goto L_0x097c
            if (r27 != 0) goto L_0x097c
            if (r7 != 0) goto L_0x097c
            if (r3 == 0) goto L_0x0962
            android.view.View r1 = r0.v_cab
            r2 = 2131362040(0x7f0a00f8, float:1.834385E38)
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r14)
            android.view.View r1 = r0.v_cab
            r2 = 2131362038(0x7f0a00f6, float:1.8343845E38)
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r14)
            goto L_0x0cc3
        L_0x0962:
            android.view.View r1 = r0.v_cab
            r2 = 2131362036(0x7f0a00f4, float:1.8343841E38)
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r14)
            android.view.View r1 = r0.v_cab
            r2 = 2131362352(0x7f0a0230, float:1.8344482E38)
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r14)
            goto L_0x0cc3
        L_0x097c:
            boolean r2 = r0.privacy_enmenu
            if (r2 == 0) goto L_0x0cc3
            if (r4 != 0) goto L_0x0cc3
            r2 = 2131558698(0x7f0d012a, float:1.874272E38)
            r3 = 0
            android.view.View r2 = r12.inflate(r2, r3)
            boolean r3 = r0.sep_secc
            if (r3 == 0) goto L_0x09b2
            r3 = 2131363168(0x7f0a0560, float:1.8346137E38)
            android.view.View r4 = r2.findViewById(r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r6 = r0.c_sep_secc
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            r4.setBackgroundColor(r5)
            android.view.View r3 = r2.findViewById(r3)
            r4 = 0
            r3.setVisibility(r4)
        L_0x09b2:
            r3 = 2131363461(0x7f0a0685, float:1.8346731E38)
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.addView(r2)
            r3.setVisibility(r14)
            r1 = 2131362498(0x7f0a02c2, float:1.8344778E38)
            android.view.View r1 = r2.findViewById(r1)
            r1.setVisibility(r14)
            r1 = 2131362499(0x7f0a02c3, float:1.834478E38)
            android.view.View r1 = r2.findViewById(r1)
            r1.setVisibility(r14)
            r1 = 2131362489(0x7f0a02b9, float:1.834476E38)
            android.view.View r1 = r2.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r2 = 2131362386(0x7f0a0252, float:1.8344551E38)
            r1.setId(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r1.setTag(r3, r2)
            int r2 = r0.t_mas
            r3 = 1
            if (r2 != r3) goto L_0x09ff
            android.content.res.Resources r2 = r28.getResources()
            r3 = 2131231439(0x7f0802cf, float:1.807896E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            goto L_0x0a19
        L_0x09ff:
            r3 = 2
            if (r2 != r3) goto L_0x0a0e
            android.content.res.Resources r2 = r28.getResources()
            r3 = 2131231440(0x7f0802d0, float:1.8078961E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            goto L_0x0a19
        L_0x0a0e:
            android.content.res.Resources r2 = r28.getResources()
            r3 = 2131231436(0x7f0802cc, float:1.8078953E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
        L_0x0a19:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            java.lang.String r4 = r0.c_icos_top
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.MULTIPLY
            r2.setColorFilter(r3, r4)
            r1.setImageDrawable(r2)
            r2 = 0
            r1.setVisibility(r2)
            goto L_0x0cc3
        L_0x0a39:
            r3 = 2131362444(0x7f0a028c, float:1.8344669E38)
            r5 = 1
            if (r2 != r5) goto L_0x0c49
            android.view.View r2 = r8.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.content.res.Resources r5 = r8.getResources()
            r6 = 2131231232(0x7f080200, float:1.807854E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r11)
            java.lang.String r7 = r0.c_icos_top
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            int r6 = android.graphics.Color.parseColor(r6)
            android.graphics.PorterDuff$Mode r7 = android.graphics.PorterDuff.Mode.MULTIPLY
            r5.setColorFilter(r6, r7)
            r2.setImageDrawable(r5)
            r5 = 0
            r2.setVisibility(r5)
            stikerwap.appdys.config$9 r6 = new stikerwap.appdys.config$9
            r6.<init>()
            r2.setOnClickListener(r6)
            stikerwap.appdys.config$10 r2 = new stikerwap.appdys.config$10
            r2.<init>()
            r4.setOnClickListener(r2)
            r2 = 2131362528(0x7f0a02e0, float:1.834484E38)
            android.view.View r2 = r8.findViewById(r2)
            android.widget.ListView r2 = (android.widget.ListView) r2
            r0.mDrawerList = r2
            r2.setCacheColorHint(r5)
            android.widget.ListView r2 = r0.mDrawerList
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            java.lang.String r5 = r0.menusl_c
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r2.setBackgroundColor(r4)
            int r2 = r0.slider_v
            if (r2 <= 0) goto L_0x0b4c
            android.widget.ListView r2 = r0.mDrawerList
            int r2 = r2.getHeaderViewsCount()
            if (r2 != 0) goto L_0x0ac4
            android.view.LayoutInflater r2 = r8.getLayoutInflater()
            r4 = 2131558502(0x7f0d0066, float:1.8742322E38)
            r5 = 0
            android.view.View r2 = r2.inflate(r4, r5)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            android.widget.ListView r4 = r0.mDrawerList
            r6 = 0
            r4.addHeaderView(r2, r5, r6)
            goto L_0x0ad0
        L_0x0ac4:
            r6 = 0
            android.widget.ListView r2 = r0.mDrawerList
            r4 = 2131362591(0x7f0a031f, float:1.8344967E38)
            android.view.View r2 = r2.findViewById(r4)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
        L_0x0ad0:
            java.lang.String r4 = "sh"
            android.content.SharedPreferences r4 = r0.getSharedPreferences(r4, r6)
            java.lang.String r5 = "slider_v_act"
            int r5 = r4.getInt(r5, r6)
            int r6 = r0.slider_v
            if (r5 != r6) goto L_0x0b1d
            android.view.View r3 = r2.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            java.lang.String r4 = "slider_header"
            java.io.FileInputStream r4 = r0.openFileInput(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0afe }
            java.io.FileDescriptor r5 = r4.getFD()     // Catch:{ Exception | OutOfMemoryError -> 0x0afe }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFileDescriptor(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0afe }
            r4.close()     // Catch:{ Exception | OutOfMemoryError -> 0x0afe }
            r3.setImageBitmap(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0afe }
            goto L_0x0aff
        L_0x0afe:
        L_0x0aff:
            int r4 = r0.slider_h
            if (r4 <= 0) goto L_0x0b0e
            android.widget.AbsListView$LayoutParams r4 = new android.widget.AbsListView$LayoutParams
            int r5 = r0.slider_h
            r6 = -1
            r4.<init>(r6, r5)
            r2.setLayoutParams(r4)
        L_0x0b0e:
            r4 = 2131363000(0x7f0a04b8, float:1.8345796E38)
            android.view.View r2 = r2.findViewById(r4)
            r2.setVisibility(r14)
            r5 = 0
            r3.setVisibility(r5)
            goto L_0x0b4c
        L_0x0b1d:
            r5 = 0
            java.lang.String r6 = "slider_v_act"
            int r4 = r4.getInt(r6, r5)
            int r5 = r0.slider_v
            if (r4 >= r5) goto L_0x0b4c
            r4 = 2131363000(0x7f0a04b8, float:1.8345796E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            int r5 = r0.slider_h
            if (r5 <= 0) goto L_0x0b41
            android.widget.AbsListView$LayoutParams r5 = new android.widget.AbsListView$LayoutParams
            int r6 = r0.slider_h
            r7 = -1
            r5.<init>(r7, r6)
            r2.setLayoutParams(r5)
        L_0x0b41:
            android.view.View r2 = r2.findViewById(r3)
            r2.setVisibility(r14)
            r2 = 0
            r4.setVisibility(r2)
        L_0x0b4c:
            boolean r2 = r0.sep_secc
            if (r2 == 0) goto L_0x0bb9
            r2 = 3
            int[] r2 = new int[r2]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            java.lang.String r4 = r0.c_sep_secc
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r4 = 0
            r2[r4] = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            java.lang.String r4 = r0.c_sep_secc
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r4 = 1
            r2[r4] = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            java.lang.String r4 = r0.menusl_c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r4 = 2
            r2[r4] = r3
            android.content.res.Resources r3 = r28.getResources()
            r4 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r3 = r3.getBoolean(r4)
            if (r3 == 0) goto L_0x0ba7
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r4 = android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT
            r3.<init>(r4, r2)
            goto L_0x0bae
        L_0x0ba7:
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r4 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r3.<init>(r4, r2)
        L_0x0bae:
            android.widget.ListView r2 = r0.mDrawerList
            r2.setDivider(r3)
            android.widget.ListView r2 = r0.mDrawerList
            r3 = 1
            r2.setDividerHeight(r3)
        L_0x0bb9:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r0.opcions = r2
            r2 = 0
        L_0x0bc1:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            int r2 = r3.intValue()
            stikerwap.appdys.Seccion[] r4 = r0.secciones_a
            int r5 = r4.length
            if (r2 >= r5) goto L_0x0c1b
            int r2 = r3.intValue()
            r2 = r4[r2]
            boolean r2 = r2.oculta
            if (r2 != 0) goto L_0x0c13
            stikerwap.appdys.config$MenuOpcion r2 = new stikerwap.appdys.config$MenuOpcion
            r2.<init>()
            stikerwap.appdys.Seccion[] r4 = r0.secciones_a
            int r5 = r3.intValue()
            r4 = r4[r5]
            java.lang.String r4 = r4.titulo
            r2.texto = r4
            stikerwap.appdys.Seccion[] r4 = r0.secciones_a
            int r5 = r3.intValue()
            r4 = r4[r5]
            boolean r4 = r4.ico_cargando
            if (r4 != 0) goto L_0x0c07
            stikerwap.appdys.Seccion[] r4 = r0.secciones_a
            int r5 = r3.intValue()
            r4 = r4[r5]
            android.graphics.Bitmap r4 = r4.ico
            r2.img = r4
            r4 = 0
            r2.img_cargando = r4
            r4 = 0
            r5 = 1
            goto L_0x0c0d
        L_0x0c07:
            r4 = 0
            r2.img = r4
            r5 = 1
            r2.img_cargando = r5
        L_0x0c0d:
            java.util.ArrayList<stikerwap.appdys.config$MenuOpcion> r6 = r0.opcions
            r6.add(r2)
            goto L_0x0c15
        L_0x0c13:
            r4 = 0
            r5 = 1
        L_0x0c15:
            int r2 = r3.intValue()
            int r2 = r2 + r5
            goto L_0x0bc1
        L_0x0c1b:
            boolean r2 = r0.privacy_enmenu
            if (r2 == 0) goto L_0x0c39
            stikerwap.appdys.config$MenuOpcion r2 = new stikerwap.appdys.config$MenuOpcion
            r2.<init>()
            android.content.res.Resources r3 = r28.getResources()
            r4 = 2131886649(0x7f120239, float:1.9407883E38)
            java.lang.String r3 = r3.getString(r4)
            r2.texto = r3
            r3 = 1
            r2.esprivacy = r3
            java.util.ArrayList<stikerwap.appdys.config$MenuOpcion> r3 = r0.opcions
            r3.add(r2)
        L_0x0c39:
            stikerwap.appdys.config$MenuAdapter r2 = new stikerwap.appdys.config$MenuAdapter
            java.util.ArrayList<stikerwap.appdys.config$MenuOpcion> r3 = r0.opcions
            r2.<init>(r3, r1)
            r0.ma = r2
            android.widget.ListView r1 = r0.mDrawerList
            r1.setAdapter(r2)
            goto L_0x0cc3
        L_0x0c49:
            r5 = 2
            if (r2 != r5) goto L_0x0cc3
            java.lang.Class r2 = r8.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r5 = "t_menugrid"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0cc3
            android.view.View r2 = r8.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.content.res.Resources r3 = r28.getResources()
            r5 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r3 = r3.getBoolean(r5)
            if (r3 == 0) goto L_0x0c7c
            android.content.res.Resources r3 = r8.getResources()
            r5 = 2131231225(0x7f0801f9, float:1.8078525E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r5)
            goto L_0x0c87
        L_0x0c7c:
            android.content.res.Resources r3 = r8.getResources()
            r5 = 2131231224(0x7f0801f8, float:1.8078523E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r5)
        L_0x0c87:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r6 = r0.c_icos_top
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.MULTIPLY
            r3.setColorFilter(r5, r6)
            r2.setImageDrawable(r3)
            r3 = 9998(0x270e, float:1.401E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r2.setTag(r5, r3)
            r3 = 9998(0x270e, float:1.401E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.setTag(r5, r3)
            r3 = 0
            r2.setVisibility(r3)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r2.setOnClickListener(r1)
            r4.setOnClickListener(r1)
            goto L_0x0cc4
        L_0x0cc3:
            r3 = 0
        L_0x0cc4:
            int r1 = r0.tipomenu
            r2 = 1
            if (r1 != r2) goto L_0x0d0d
            boolean r1 = r0.icos_pendientes
            if (r1 == 0) goto L_0x0d0d
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            r4 = 2147483647(0x7fffffff, float:NaN)
            java.util.List r1 = r1.getRunningServices(r4)
            java.util.Iterator r1 = r1.iterator()
            r15 = 0
        L_0x0ce1:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0d01
            java.lang.Object r3 = r1.next()
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3
            java.lang.Class<stikerwap.appdys.s_cargar_icos> r4 = stikerwap.appdys.s_cargar_icos.class
            java.lang.String r4 = r4.getName()
            android.content.ComponentName r3 = r3.service
            java.lang.String r3 = r3.getClassName()
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0ce1
            r15 = 1
            goto L_0x0ce1
        L_0x0d01:
            if (r15 != 0) goto L_0x0d0d
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.s_cargar_icos> r2 = stikerwap.appdys.s_cargar_icos.class
            r1.<init>(r0, r2)
            r0.startService(r1)
        L_0x0d0d:
            int r1 = r0.nsecc_mostradas
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.incluir_menu_2(android.content.Context, java.lang.Boolean):int");
    }

    /* access modifiers changed from: package-private */
    public boolean f_focus_tv(View view) {
        if (Build.VERSION.SDK_INT <= 22) {
            return false;
        }
        view.setForeground(getDrawable(R.drawable.btn_tv));
        view.setFocusable(true);
        view.setFocusableInTouchMode(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ExcHandler: FileNotFoundException | IOException | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:10:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mostrar_ico_perfil(android.content.Context r6, android.widget.ImageView r7) {
        /*
            r5 = this;
            java.lang.String r0 = "sh"
            r1 = 0
            android.content.SharedPreferences r0 = r5.getSharedPreferences(r0, r1)
            int r2 = r5.ico_perfil_modo
            r3 = 2
            if (r2 == r3) goto L_0x0090
            java.lang.String r2 = "nick"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.getString(r2, r3)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0090
            r0 = 1
            java.io.File r2 = r5.getTempFile(r5, r0)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0027
            goto L_0x0090
        L_0x0027:
            int r6 = r5.ico_perfil_modo
            if (r6 == 0) goto L_0x002d
            if (r6 != r0) goto L_0x00c3
        L_0x002d:
            java.io.File r6 = r5.getTempFile(r5, r0)
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r2.<init>()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r2.inJustDecodeBounds = r0     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            java.lang.String r3 = r6.getPath()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            android.graphics.BitmapFactory.decodeFile(r3, r2)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            int r3 = r2.outWidth     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            int r3 = r2.outWidth     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            int r2 = r2.outHeight     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 > r4) goto L_0x004c
            if (r2 > r4) goto L_0x004c
            r1 = 1
        L_0x004c:
            if (r1 != 0) goto L_0x006b
            int r1 = calculateNewWidth(r3, r2, r4, r4)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            float r2 = (float) r3     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            float r1 = (float) r1     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            float r2 = r2 / r1
            int r1 = java.lang.Math.round(r2)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r2.<init>()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r2.inSampleSize = r1     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            java.lang.String r6 = r6.getPath()     // Catch:{ OutOfMemoryError -> 0x0069, FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r2)     // Catch:{ OutOfMemoryError -> 0x0069, FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            goto L_0x0077
        L_0x0069:
            r6 = 0
            goto L_0x0077
        L_0x006b:
            android.content.ContentResolver r1 = r5.getContentResolver()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            android.graphics.Bitmap r6 = android.provider.MediaStore.Images.Media.getBitmap(r1, r6)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
        L_0x0077:
            int r1 = r5.ico_perfil_modo     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            if (r1 != 0) goto L_0x0080
            android.graphics.Bitmap r6 = getCircularBitmapWithWhiteBorder(r6, r0)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            goto L_0x0084
        L_0x0080:
            android.graphics.Bitmap r6 = crop(r6, r0)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
        L_0x0084:
            r0 = 4
            int r0 = dp_to_px(r5, r0)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r7.setPadding(r0, r0, r0, r0)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            r7.setImageBitmap(r6)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x00c3 }
            goto L_0x00c3
        L_0x0090:
            boolean r0 = r5.ico_perfil_imgperso
            if (r0 == 0) goto L_0x009a
            java.lang.String r6 = "ico_perfil"
            r5.file_to_iv(r6, r7)
            goto L_0x00c3
        L_0x009a:
            android.app.Activity r6 = (android.app.Activity) r6
            android.content.res.Resources r6 = r6.getResources()
            r0 = 2131231421(0x7f0802bd, float:1.8078923E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "#"
            r0.<init>(r1)
            java.lang.String r1 = r5.c_icos_top
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.MULTIPLY
            r6.setColorFilter(r0, r1)
            r7.setImageDrawable(r6)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.mostrar_ico_perfil(android.content.Context, android.widget.ImageView):void");
    }

    public void config_drawer(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                if (view.getTag(R.id.TAG_ESPRIVACY) != null) {
                    new cargarprivacidad_glob(view.getContext(), config.this.c_icos, config.aplicar_color_dialog(config.this.c1, config.this.c_icos)).execute(new String[0]);
                    return;
                }
                if (config.this.slider_v > 0) {
                    i--;
                }
                view.setId(config.this.menu_a_secciones[i]);
                view.setTag(R.id.TAG_IDSECC, Integer.valueOf(config.this.menu_a_secciones[i]));
                ((Activity_ext) view.getContext()).onClick(view);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ResultGetIntent crear_rgi(Integer num, Context context) {
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        Intent intent6;
        Intent intent7;
        Intent intent8;
        Intent intent9;
        Intent intent10;
        Intent intent11;
        Intent intent12;
        Intent intent13;
        Intent intent14;
        Intent intent15;
        Intent intent16;
        ResultGetIntent resultGetIntent = new ResultGetIntent();
        resultGetIntent.finalizar = true;
        resultGetIntent.finalizar_app = false;
        resultGetIntent.esmas = false;
        if (num.intValue() == -1) {
            int i = 0;
            while (true) {
                Seccion[] seccionArr = this.secciones_a;
                if (i >= seccionArr.length) {
                    break;
                } else if (!seccionArr[i].oculta) {
                    num = Integer.valueOf(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        if (num.intValue() < 9997) {
            Seccion seccion = this.secciones_a[num.intValue()];
            if (!seccion.oculta) {
                this.ind_secc_sel = num.intValue();
            }
            this.ind_secc_sel_2 = num.intValue();
            SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("ind_secc_sel", this.ind_secc_sel);
            edit.putInt("ind_secc_sel_2", this.ind_secc_sel_2);
            edit.commit();
            boolean z = sharedPreferences.getBoolean("chat" + seccion.id + "_validado", true);
            if (seccion.tipo == 1) {
                if (z) {
                    intent16 = new Intent(context, t_url.class);
                } else {
                    Intent intent17 = new Intent(context, t_chat_contra.class);
                    intent17.putExtra("clase", seccion.tipo);
                    intent17.putExtra("ind", num);
                    intent16 = intent17;
                }
                intent16.putExtra("url", seccion.url);
                resultGetIntent.i = intent16;
                return resultGetIntent;
            } else if (seccion.tipo == 2) {
                if (z) {
                    intent15 = new Intent(context, t_html.class);
                } else {
                    intent15 = new Intent(context, t_chat_contra.class);
                    intent15.putExtra("clase", seccion.tipo);
                    intent15.putExtra("ind", num);
                }
                intent15.putExtra("idsecc", num);
                resultGetIntent.i = intent15;
                return resultGetIntent;
            } else if (seccion.tipo == 3) {
                if (z) {
                    intent14 = new Intent(context, t_and.class);
                } else {
                    intent14 = new Intent(context, t_chat_contra.class);
                    intent14.putExtra("clase", seccion.tipo);
                    intent14.putExtra("ind", num);
                }
                intent14.putExtra("idsecc", num);
                resultGetIntent.i = intent14;
                return resultGetIntent;
            } else if (seccion.tipo == 4) {
                if (z) {
                    return intent_ofics(context);
                }
                Intent intent18 = new Intent(context, t_chat_contra.class);
                intent18.putExtra("clase", seccion.tipo);
                intent18.putExtra("ind", num);
                resultGetIntent.i = intent18;
                return resultGetIntent;
            } else if (seccion.tipo == 5) {
                if (z) {
                    return intent_prods(context);
                }
                Intent intent19 = new Intent(context, t_chat_contra.class);
                intent19.putExtra("clase", seccion.tipo);
                intent19.putExtra("ind", num);
                resultGetIntent.i = intent19;
                return resultGetIntent;
            } else if (seccion.tipo == 6) {
                if (!z) {
                    intent13 = new Intent(context, t_chat_contra.class);
                    intent13.putExtra("clase", seccion.tipo);
                } else if (seccion.tipo_player == 0) {
                    intent13 = new Intent(context, t_video.class);
                } else if (seccion.tipo_player == 1) {
                    intent13 = new Intent(context, t_video_exoplayer.class);
                } else {
                    intent13 = new Intent(context, t_video_playerjs.class);
                }
                intent13.putExtra("url", seccion.url);
                intent13.putExtra("ua", seccion.ua);
                intent13.putExtra("ind", num);
                resultGetIntent.i = intent13;
                return resultGetIntent;
            } else if (seccion.tipo == 7) {
                if (z) {
                    intent12 = new Intent(context, t_radio.class);
                } else {
                    intent12 = new Intent(context, t_chat_contra.class);
                    intent12.putExtra("clase", seccion.tipo);
                }
                intent12.putExtra("ind", num);
                resultGetIntent.i = intent12;
                return resultGetIntent;
            } else if (seccion.tipo == 8) {
                if (z) {
                    intent11 = new Intent(context, t_rss.class);
                } else {
                    intent11 = new Intent(context, t_chat_contra.class);
                    intent11.putExtra("clase", seccion.tipo);
                }
                intent11.putExtra("ind", num);
                resultGetIntent.i = intent11;
                return resultGetIntent;
            } else if (seccion.tipo == 9) {
                Intent intent20 = new Intent(context, t_chat_contra.class);
                intent20.putExtra("ind", num);
                resultGetIntent.i = intent20;
                return resultGetIntent;
            } else if (seccion.tipo == 10) {
                if (seccion.idsubcat > 0) {
                    if (z) {
                        intent9 = new Intent(context, t_buscchats_lista.class);
                    } else {
                        intent9 = new Intent(context, t_chat_contra.class);
                        intent9.putExtra("clase", seccion.tipo);
                    }
                    intent9.putExtra("ind", num);
                    intent9.putExtra("idcat", seccion.idcat);
                    intent9.putExtra("idsubcat", seccion.idsubcat);
                } else {
                    if (z) {
                        intent10 = new Intent(context, t_buscchats.class);
                    } else {
                        intent10 = new Intent(context, t_chat_contra.class);
                        intent10.putExtra("clase", seccion.tipo);
                    }
                    intent9.putExtra("ind", num);
                    intent9.putExtra("idcat", seccion.idcat);
                }
                resultGetIntent.i = intent9;
                return resultGetIntent;
            } else if (seccion.tipo == 11) {
                if (z) {
                    intent8 = new Intent(context, t_buscusus.class);
                } else {
                    intent8 = new Intent(context, t_chat_contra.class);
                    intent8.putExtra("clase", seccion.tipo);
                }
                intent8.putExtra("ind", num);
                resultGetIntent.i = intent8;
                return resultGetIntent;
            } else if (seccion.tipo == 12) {
                if (z) {
                    intent7 = new Intent(context, t_submenu.class);
                } else {
                    intent7 = new Intent(context, t_chat_contra.class);
                    intent7.putExtra("clase", seccion.tipo);
                }
                intent7.putExtra("ind", num);
                resultGetIntent.i = intent7;
                return resultGetIntent;
            } else if (seccion.tipo == 22) {
                if (z) {
                    intent6 = new Intent(context, t_submenu_ultimas.class);
                } else {
                    intent6 = new Intent(context, t_chat_contra.class);
                    intent6.putExtra("clase", seccion.tipo);
                }
                intent6.putExtra("ind", num);
                resultGetIntent.i = intent6;
                return resultGetIntent;
            } else if (seccion.tipo == 13) {
                if (z) {
                    intent5 = new Intent(context, t_gal.class);
                } else {
                    intent5 = new Intent(context, t_chat_contra.class);
                    intent5.putExtra("clase", seccion.tipo);
                }
                intent5.putExtra("ind", num);
                resultGetIntent.i = intent5;
                return resultGetIntent;
            } else if (seccion.tipo == 14) {
                if (z) {
                    intent4 = new Intent(context, t_card.class);
                } else {
                    intent4 = new Intent(context, t_chat_contra.class);
                    intent4.putExtra("clase", seccion.tipo);
                }
                intent4.putExtra("ind", num);
                resultGetIntent.i = intent4;
                return resultGetIntent;
            } else if (seccion.tipo == 16) {
                if (z) {
                    intent3 = new Intent(context, t_buscvideos.class);
                } else {
                    intent3 = new Intent(context, t_chat_contra.class);
                    intent3.putExtra("clase", seccion.tipo);
                }
                intent3.putExtra("ind", num);
                resultGetIntent.i = intent3;
                return resultGetIntent;
            } else if (seccion.tipo == 19) {
                if (z) {
                    intent2 = new Intent(context, t_vistafb.class);
                } else {
                    intent2 = new Intent(context, t_chat_contra.class);
                    intent2.putExtra("clase", seccion.tipo);
                }
                intent2.putExtra("ind", num);
                resultGetIntent.i = intent2;
                return resultGetIntent;
            } else {
                if (seccion.tipo == 20) {
                    if (z) {
                        intent = new Intent(context, t_qr.class);
                    } else {
                        intent = new Intent(context, t_chat_contra.class);
                        intent.putExtra("clase", seccion.tipo);
                    }
                    intent.putExtra("ind", num);
                    resultGetIntent.i = intent;
                }
                return resultGetIntent;
            }
        } else {
            this.ind_secc_sel_2 = 0;
            SharedPreferences.Editor edit2 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
            edit2.putInt("ind_secc_sel", this.ind_secc_sel);
            edit2.putInt("ind_secc_sel_2", this.ind_secc_sel_2);
            edit2.commit();
            resultGetIntent.i = new Intent(context, t_chat_contra.class);
            return resultGetIntent;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Integer} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public stikerwap.appdys.ResultGetIntent getIntent(android.view.View r17, android.content.Context r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            stikerwap.appdys.ResultGetIntent r3 = new stikerwap.appdys.ResultGetIntent
            r3.<init>()
            r4 = 1
            r3.finalizar = r4
            r5 = 0
            r3.finalizar_app = r5
            r3.esmas = r5
            r6 = 2131361805(0x7f0a000d, float:1.8343373E38)
            java.lang.Object r7 = r1.getTag(r6)
            r8 = -1
            java.lang.String r9 = ""
            if (r7 == 0) goto L_0x002a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.Object r1 = r1.getTag(r6)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0035
        L_0x002a:
            r6 = 2131361812(0x7f0a0014, float:1.8343387E38)
            java.lang.Object r1 = r1.getTag(r6)
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            r1 = r9
        L_0x0035:
            int r6 = r7.intValue()
            if (r6 < 0) goto L_0x0049
            int r6 = r7.intValue()
            stikerwap.appdys.Seccion[] r10 = r0.secciones_a
            int r10 = r10.length
            if (r6 >= r10) goto L_0x0049
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r7, r2)
            return r1
        L_0x0049:
            int r6 = r7.intValue()
            r10 = 9998(0x270e, float:1.401E-41)
            if (r6 != r10) goto L_0x0054
            r3.finalizar = r4
            return r3
        L_0x0054:
            int r6 = r7.intValue()
            r10 = 2131362386(0x7f0a0252, float:1.8344551E38)
            if (r6 != r10) goto L_0x006b
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.t_menu> r6 = stikerwap.appdys.t_menu.class
            r1.<init>(r2, r6)
            r3.finalizar = r5
            r3.esmas = r4
            r3.i = r1
            return r3
        L_0x006b:
            boolean r6 = r1.equals(r9)
            r10 = 0
            r11 = 10000(0x2710, float:1.4013E-41)
            if (r6 == 0) goto L_0x0084
            int r6 = r7.intValue()
            if (r6 <= r11) goto L_0x0122
            int r6 = r7.intValue()
            int[] r12 = r0.icos_a
            int r12 = r12.length
            int r12 = r12 + r11
            if (r6 > r12) goto L_0x0122
        L_0x0084:
            java.lang.String r6 = "share"
            boolean r12 = r1.equals(r6)
            java.lang.String r13 = "ind_secc_sel_2"
            java.lang.String r14 = "ind_secc_sel"
            java.lang.String r15 = "sh"
            if (r12 != 0) goto L_0x0393
            int r12 = r7.intValue()
            int r8 = r0.ico_share_ord
            int r8 = r8 + r11
            if (r12 != r8) goto L_0x009f
            goto L_0x0393
        L_0x009f:
            java.lang.String r6 = "search"
            boolean r8 = r1.equals(r6)
            if (r8 != 0) goto L_0x033e
            int r8 = r7.intValue()
            int r12 = r0.ico_search_ord
            int r12 = r12 + r11
            if (r8 != r12) goto L_0x00b2
            goto L_0x033e
        L_0x00b2:
            java.lang.String r6 = "offices"
            boolean r8 = r1.equals(r6)
            if (r8 != 0) goto L_0x02e1
            int r8 = r7.intValue()
            int r12 = r0.ico_ofics_ord
            int r12 = r12 + r11
            if (r8 != r12) goto L_0x00c5
            goto L_0x02e1
        L_0x00c5:
            java.lang.String r6 = "products"
            boolean r8 = r1.equals(r6)
            if (r8 != 0) goto L_0x0284
            int r8 = r7.intValue()
            int r12 = r0.ico_busc_ord
            int r12 = r12 + r11
            if (r8 != r12) goto L_0x00d8
            goto L_0x0284
        L_0x00d8:
            java.lang.String r6 = "exit"
            boolean r8 = r1.equals(r6)
            if (r8 != 0) goto L_0x023c
            int r8 = r7.intValue()
            int r12 = r0.ico_exit_ord
            int r12 = r12 + r11
            if (r8 != r12) goto L_0x00eb
            goto L_0x023c
        L_0x00eb:
            java.lang.String r6 = "notifications"
            boolean r8 = r1.equals(r6)
            if (r8 != 0) goto L_0x01ed
            int r8 = r7.intValue()
            int r12 = r0.ico_notif_ord
            int r12 = r12 + r11
            if (r8 != r12) goto L_0x00fe
            goto L_0x01ed
        L_0x00fe:
            java.lang.String r3 = "profile"
            boolean r6 = r1.equals(r3)
            if (r6 != 0) goto L_0x0180
            int r6 = r7.intValue()
            int r8 = r0.ico_perfil_ord
            int r8 = r8 + r11
            if (r6 != r8) goto L_0x0110
            goto L_0x0180
        L_0x0110:
            java.lang.String r3 = "noads"
            boolean r6 = r1.equals(r3)
            if (r6 != 0) goto L_0x0123
            int r6 = r7.intValue()
            int r7 = r0.ico_sinads_ord
            int r7 = r7 + r11
            if (r6 != r7) goto L_0x0122
            goto L_0x0123
        L_0x0122:
            return r10
        L_0x0123:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0164
            int r1 = r0.ico_sinads_idsec
            if (r1 <= 0) goto L_0x0164
            if (r1 != r4) goto L_0x0136
            java.lang.String r1 = r0.ico_sinads_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x0136:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_sinads_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x0164:
            r1 = r2
            stikerwap.appdys.Activity_ext_class r1 = (stikerwap.appdys.Activity_ext_class) r1     // Catch:{ Exception -> 0x016a }
            java.lang.String r9 = r1.cbtn     // Catch:{ Exception -> 0x016a }
            goto L_0x016f
        L_0x016a:
            r1 = r2
            stikerwap.appdys.FragmentActivity_ext_class r1 = (stikerwap.appdys.FragmentActivity_ext_class) r1     // Catch:{ Exception -> 0x016f }
            java.lang.String r9 = r1.cbtn     // Catch:{ Exception -> 0x016f }
        L_0x016f:
            r0.iniciar_pago_sinads(r2, r9)
            stikerwap.appdys.ResultGetIntent r1 = new stikerwap.appdys.ResultGetIntent
            r1.<init>()
            r1.i = r10
            r1.finalizar = r5
            r1.finalizar_app = r5
            r1.esmas = r5
            return r1
        L_0x0180:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01c1
            int r1 = r0.ico_perfil_idsec
            if (r1 <= 0) goto L_0x01c1
            if (r1 != r4) goto L_0x0193
            java.lang.String r1 = r0.ico_perfil_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x0193:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_perfil_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x01c1:
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.preperfil> r2 = stikerwap.appdys.preperfil.class
            r1.<init>(r0, r2)
            java.lang.String r2 = "desde_main"
            r1.putExtra(r2, r4)
            java.lang.String r2 = "desde_main_oblig"
            r1.putExtra(r2, r5)
            java.lang.String r2 = "nocompletar"
            r1.putExtra(r2, r4)
            int r2 = r0.tipomenu
            r3 = 2
            if (r2 == r3) goto L_0x01e1
            java.lang.String r2 = "es_root"
            r1.putExtra(r2, r4)
        L_0x01e1:
            stikerwap.appdys.ResultGetIntent r2 = new stikerwap.appdys.ResultGetIntent
            r2.<init>()
            r2.finalizar = r5
            r2.esmas = r4
            r2.i = r1
            return r2
        L_0x01ed:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x022e
            int r1 = r0.ico_notif_idsec
            if (r1 <= 0) goto L_0x022e
            if (r1 != r4) goto L_0x0200
            java.lang.String r1 = r0.ico_notif_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x0200:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_notif_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x022e:
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.notifs> r6 = stikerwap.appdys.notifs.class
            r1.<init>(r2, r6)
            r3.finalizar = r5
            r3.esmas = r4
            r3.i = r1
            return r3
        L_0x023c:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x027d
            int r1 = r0.ico_exit_idsec
            if (r1 <= 0) goto L_0x027d
            if (r1 != r4) goto L_0x024f
            java.lang.String r1 = r0.ico_exit_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x024f:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_exit_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x027d:
            r3.finalizar = r4
            r3.finalizar_app = r4
            finalizar_app = r4
            return r3
        L_0x0284:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x02c5
            int r1 = r0.ico_busc_idsec
            if (r1 <= 0) goto L_0x02c5
            if (r1 != r4) goto L_0x0297
            java.lang.String r1 = r0.ico_busc_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x0297:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_busc_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x02c5:
            int r1 = r0.ind_secc_buscador
            r3 = -1
            if (r1 == r3) goto L_0x02dc
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            int r3 = r0.ind_secc_buscador
            r0.ind_secc_sel = r3
            r1.putInt(r14, r3)
            r1.commit()
        L_0x02dc:
            stikerwap.appdys.ResultGetIntent r1 = r0.intent_prods(r2)
            return r1
        L_0x02e1:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0322
            int r1 = r0.ico_ofics_idsec
            if (r1 <= 0) goto L_0x0322
            if (r1 != r4) goto L_0x02f4
            java.lang.String r1 = r0.ico_ofics_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x02f4:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_ofics_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x0322:
            int r1 = r0.ind_secc_ofics
            r3 = -1
            if (r1 == r3) goto L_0x0339
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            int r3 = r0.ind_secc_ofics
            r0.ind_secc_sel = r3
            r1.putInt(r14, r3)
            r1.commit()
        L_0x0339:
            stikerwap.appdys.ResultGetIntent r1 = r0.intent_ofics(r2)
            return r1
        L_0x033e:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x037f
            int r1 = r0.ico_search_idsec
            if (r1 <= 0) goto L_0x037f
            if (r1 != r4) goto L_0x0351
            java.lang.String r1 = r0.ico_search_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x0351:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_search_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x037f:
            r1 = r2
            android.app.Activity r1 = (android.app.Activity) r1
            r1.onSearchRequested()
            stikerwap.appdys.ResultGetIntent r1 = new stikerwap.appdys.ResultGetIntent
            r1.<init>()
            r1.i = r10
            r1.finalizar = r4
            r1.finalizar_app = r5
            r1.esmas = r5
            return r1
        L_0x0393:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x03d4
            int r1 = r0.ico_share_idsec
            if (r1 <= 0) goto L_0x03d4
            if (r1 != r4) goto L_0x03a6
            java.lang.String r1 = r0.ico_share_url
            stikerwap.appdys.ResultGetIntent r1 = r0.getIntent_porURL(r1, r2)
            return r1
        L_0x03a6:
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r15, r5)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r4 = r0.ico_share_idsec
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            r0.ind_secc_sel_2 = r3
            r0.ind_secc_sel = r3
            r1.putInt(r13, r3)
            int r3 = r0.ind_secc_sel
            r1.putInt(r14, r3)
            r1.commit()
            int r1 = r0.ind_secc_sel
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            stikerwap.appdys.ResultGetIntent r1 = r0.crear_rgi(r1, r2)
            return r1
        L_0x03d4:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.SEND"
            r1.<init>(r2)
            java.lang.String r2 = "text/plain"
            r1.setType(r2)
            java.lang.String r2 = "android.intent.extra.SUBJECT"
            java.lang.String r4 = r0.share_subject
            r1.putExtra(r2, r4)
            java.lang.String r2 = "android.intent.extra.TEXT"
            java.lang.String r4 = r0.share_text
            r1.putExtra(r2, r4)
            r2 = 2131886280(0x7f1200c8, float:1.9407134E38)
            java.lang.String r2 = r0.getString(r2)
            android.content.Intent r1 = android.content.Intent.createChooser(r1, r2)
            r3.i = r1
            r3.finalizar = r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.getIntent(android.view.View, android.content.Context):stikerwap.appdys.ResultGetIntent");
    }

    /* access modifiers changed from: package-private */
    public ResultGetIntent intent_prods(Context context) {
        ResultGetIntent resultGetIntent = new ResultGetIntent();
        int i = 1;
        resultGetIntent.finalizar = true;
        resultGetIntent.finalizar_app = false;
        Intent intent = new Intent(context, t_buscador_form.class);
        if (!this.busc_texto && !this.busc_cat && !this.busc_precio && !this.busc_antiguedad && !this.ord_texto && !this.ord_precio && !this.ord_antiguedad) {
            intent = new Intent(context, t_buscador.class);
            if (this.ord_def.indexOf("TITULO") == -1) {
                i = this.ord_def.indexOf("PRECIO") != -1 ? 2 : 3;
            }
            intent.putExtra("orden", i);
            intent.putExtra("orden_tipo", this.ord_def.contains("ASC"));
        }
        resultGetIntent.i = intent;
        return resultGetIntent;
    }

    /* access modifiers changed from: package-private */
    public ResultGetIntent intent_ofics(Context context) {
        ResultGetIntent resultGetIntent = new ResultGetIntent();
        boolean z = true;
        resultGetIntent.finalizar = true;
        resultGetIntent.finalizar_app = false;
        Intent intent = new Intent(context, t_oficinas.class);
        Oficina[] oficinaArr = this.oficinas_a;
        if (oficinaArr.length == 1) {
            if (oficinaArr[0].horario.equals("") && this.oficinas_a[0].dir1.equals("") && this.oficinas_a[0].dir2.equals("") && this.oficinas_a[0].cp.equals("") && this.oficinas_a[0].pob.equals("") && this.oficinas_a[0].prov.equals("") && this.oficinas_a[0].nfotos <= 0 && this.oficinas_a[0].x == 0) {
                z = false;
            }
            if (this.oficinas_a[0].t_email && this.oficinas_a[0].tel1.equals("") && this.oficinas_a[0].tel2.equals("") && this.oficinas_a[0].web.equals("") && !this.oficinas_a[0].chat && !z) {
                intent = new Intent(context, contactar.class);
                intent.putExtra("idofic", this.oficinas_a[0].id);
            } else if (!this.oficinas_a[0].t_email && !this.oficinas_a[0].tel1.equals("") && this.oficinas_a[0].tel2.equals("") && this.oficinas_a[0].web.equals("") && !this.oficinas_a[0].chat && !z) {
                intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.oficinas_a[0].tel1));
                resultGetIntent.finalizar = false;
            } else if (!this.oficinas_a[0].t_email && this.oficinas_a[0].tel1.equals("") && !this.oficinas_a[0].tel2.equals("") && this.oficinas_a[0].web.equals("") && !this.oficinas_a[0].chat && !z) {
                intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.oficinas_a[0].tel2));
                resultGetIntent.finalizar = false;
            } else if (this.oficinas_a[0].t_email || !this.oficinas_a[0].tel1.equals("") || !this.oficinas_a[0].tel2.equals("") || this.oficinas_a[0].web.equals("") || this.oficinas_a[0].chat || z) {
                if (!this.oficinas_a[0].t_email && this.oficinas_a[0].tel1.equals("") && this.oficinas_a[0].tel2.equals("") && this.oficinas_a[0].web.equals("") && this.oficinas_a[0].chat && !z) {
                    intent = new Intent(context, chat.class);
                }
            } else if (this.oficinas_a[0].web_popup) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.oficinas_a[0].web));
                if (this.customtabs && abrir_con_nav(this.oficinas_a[0].web)) {
                    Bundle bundle = new Bundle();
                    bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                    try {
                        bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, Color.parseColor("#" + this.c1));
                    } catch (Exception unused) {
                    }
                    intent.putExtras(bundle);
                }
                resultGetIntent.finalizar = false;
            } else {
                intent = new Intent(context, t_url.class);
                intent.putExtra("url", this.oficinas_a[0].web);
            }
        }
        resultGetIntent.i = intent;
        return resultGetIntent;
    }

    /* access modifiers changed from: package-private */
    public int[] file_to_iv(String str, ImageView imageView) {
        int[] iArr = {0, 0};
        try {
            FileInputStream openFileInput = openFileInput(str);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileInput.getFD());
            openFileInput.close();
            imageView.setImageBitmap(decodeFileDescriptor);
            iArr[0] = decodeFileDescriptor.getWidth();
            iArr[1] = decodeFileDescriptor.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError unused) {
        }
        return iArr;
    }

    public static void copy_to_fos(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                outputStream.close();
                return;
            }
        }
    }

    public static void copy(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[SYNTHETIC, Splitter:B:34:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061 A[Catch:{ IOException -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006c A[SYNTHETIC, Splitter:B:43:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0074 A[Catch:{ IOException -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean savefile(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r1 = 0
            java.io.File r2 = r3.getExternalFilesDir(r1)
            r0.<init>(r2, r5)
            java.lang.String r5 = r0.getAbsolutePath()
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r2.<init>(r5, r0)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r3.read(r5)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
        L_0x0028:
            r4.write(r5)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            int r1 = r3.read(r5)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r2 = -1
            if (r1 != r2) goto L_0x0028
            if (r3 == 0) goto L_0x003a
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003a
        L_0x0038:
            r3 = move-exception
            goto L_0x003e
        L_0x003a:
            r4.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0041
        L_0x003e:
            r3.printStackTrace()
        L_0x0041:
            r0 = 1
            goto L_0x0068
        L_0x0043:
            r5 = move-exception
            goto L_0x0049
        L_0x0045:
            r5 = move-exception
            goto L_0x004d
        L_0x0047:
            r5 = move-exception
            r4 = r1
        L_0x0049:
            r1 = r3
            goto L_0x006a
        L_0x004b:
            r5 = move-exception
            r4 = r1
        L_0x004d:
            r1 = r3
            goto L_0x0054
        L_0x004f:
            r5 = move-exception
            r4 = r1
            goto L_0x006a
        L_0x0052:
            r5 = move-exception
            r4 = r1
        L_0x0054:
            r5.printStackTrace()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x005f
        L_0x005d:
            r3 = move-exception
            goto L_0x0065
        L_0x005f:
            if (r4 == 0) goto L_0x0068
            r4.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0068
        L_0x0065:
            r3.printStackTrace()
        L_0x0068:
            return r0
        L_0x0069:
            r5 = move-exception
        L_0x006a:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r3 = move-exception
            goto L_0x0078
        L_0x0072:
            if (r4 == 0) goto L_0x007b
            r4.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x007b
        L_0x0078:
            r3.printStackTrace()
        L_0x007b:
            goto L_0x007d
        L_0x007c:
            throw r5
        L_0x007d:
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.savefile(android.content.Context, android.net.Uri, java.lang.String):boolean");
    }

    static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i4 <= i && i3 <= i2) {
            return 1;
        }
        return Math.round(((float) i4) / ((float) calculateNewWidth(i4, i3, i, i2)));
    }

    static int calculateNewWidth(int i, int i2, int i3, int i4) {
        if (i > i3) {
            i2 = Math.round((float) ((i2 * i3) / i));
            i = i3;
        }
        return i2 > i4 ? Math.round((float) ((i * i4) / i2)) : i;
    }

    public Bitmap decodeSampledBitmapFromResource(Uri uri, int i, int i2) throws IOException, OutOfMemoryError {
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
        openInputStream.close();
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        InputStream openInputStream2 = getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, (Rect) null, options);
        openInputStream2.close();
        return decodeStream;
    }

    /* access modifiers changed from: package-private */
    public File getExtTempFile(Context context, int i) {
        File externalFilesDir = context.getExternalFilesDir((String) null);
        return new File(externalFilesDir, "dt_foto" + i + "_temp.jpg");
    }

    /* access modifiers changed from: package-private */
    public File getTempFile(Context context, int i) {
        File filesDir = context.getFilesDir();
        return new File(filesDir, "dt_foto" + i + "_temp.jpg");
    }

    /* access modifiers changed from: package-private */
    public File getTempFile_notemp(Context context, int i, boolean z) {
        String str = z ? "_g" : "";
        File filesDir = context.getFilesDir();
        return new File(filesDir, "dt_foto" + i + str + ".jpg");
    }

    /* access modifiers changed from: package-private */
    public File getExtTempFile_libre(Context context, String str) {
        return new File(context.getExternalFilesDir((String) null), str);
    }

    /* access modifiers changed from: package-private */
    public File getTempFile_libre(Context context, String str) {
        return new File(context.getFilesDir(), str);
    }

    static boolean esMuyClaro(String str) {
        if (str.equals("") || str.equals("#")) {
            return true;
        }
        double red = (double) (Color.red(Color.parseColor(str)) * Color.red(Color.parseColor(str)));
        Double.isNaN(red);
        double green = (double) (Color.green(Color.parseColor(str)) * Color.green(Color.parseColor(str)));
        Double.isNaN(green);
        double d = (red * 0.241d) + (green * 0.691d);
        double blue = (double) (Color.blue(Color.parseColor(str)) * Color.blue(Color.parseColor(str)));
        Double.isNaN(blue);
        if (((int) Math.sqrt(d + (blue * 0.068d))) > 200) {
            return true;
        }
        return false;
    }

    static boolean esMuyOscuro(String str) {
        if (str.equals("") || str.equals("#")) {
            return true;
        }
        double red = (double) (Color.red(Color.parseColor(str)) * Color.red(Color.parseColor(str)));
        Double.isNaN(red);
        double green = (double) (Color.green(Color.parseColor(str)) * Color.green(Color.parseColor(str)));
        Double.isNaN(green);
        double d = (red * 0.241d) + (green * 0.691d);
        double blue = (double) (Color.blue(Color.parseColor(str)) * Color.blue(Color.parseColor(str)));
        Double.isNaN(blue);
        if (((int) Math.sqrt(d + (blue * 0.068d))) < 60) {
            return true;
        }
        return false;
    }

    static boolean esClaro(String str) {
        if (str.equals("") || str.equals("#")) {
            return true;
        }
        double red = (double) (Color.red(Color.parseColor(str)) * Color.red(Color.parseColor(str)));
        Double.isNaN(red);
        double green = (double) (Color.green(Color.parseColor(str)) * Color.green(Color.parseColor(str)));
        Double.isNaN(green);
        double d = (red * 0.241d) + (green * 0.691d);
        double blue = (double) (Color.blue(Color.parseColor(str)) * Color.blue(Color.parseColor(str)));
        Double.isNaN(blue);
        if (((int) Math.sqrt(d + (blue * 0.068d))) > 130) {
            return true;
        }
        return false;
    }

    static boolean esClaro_int(int i) {
        double red = (double) (Color.red(i) * Color.red(i));
        Double.isNaN(red);
        double green = (double) (Color.green(i) * Color.green(i));
        Double.isNaN(green);
        double d = (red * 0.241d) + (green * 0.691d);
        double blue = (double) (Color.blue(i) * Color.blue(i));
        Double.isNaN(blue);
        return ((int) Math.sqrt(d + (blue * 0.068d))) > 130;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        if (esClaro_int(r2) != false) goto L_0x000a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r4 == 2) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int canviarColor(int r2, float r3, int r4) {
        /*
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x000c
            boolean r4 = esClaro_int(r2)
            if (r4 == 0) goto L_0x000f
        L_0x000a:
            float r0 = r0 - r3
            goto L_0x0015
        L_0x000c:
            r1 = 1
            if (r4 != r1) goto L_0x0011
        L_0x000f:
            float r0 = r0 + r3
            goto L_0x0015
        L_0x0011:
            r1 = 2
            if (r4 != r1) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            int r3 = android.graphics.Color.alpha(r2)
            int r4 = android.graphics.Color.red(r2)
            float r4 = (float) r4
            float r4 = r4 * r0
            int r4 = java.lang.Math.round(r4)
            int r1 = android.graphics.Color.green(r2)
            float r1 = (float) r1
            float r1 = r1 * r0
            int r1 = java.lang.Math.round(r1)
            int r2 = android.graphics.Color.blue(r2)
            float r2 = (float) r2
            float r2 = r2 * r0
            int r2 = java.lang.Math.round(r2)
            r0 = 255(0xff, float:3.57E-43)
            int r4 = java.lang.Math.min(r4, r0)
            int r1 = java.lang.Math.min(r1, r0)
            int r2 = java.lang.Math.min(r2, r0)
            int r2 = android.graphics.Color.argb(r3, r4, r1, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.canviarColor(int, float, int):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x11ea, code lost:
        if (r3.equals("") != false) goto L_0x11ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:491:0x1240, code lost:
        if (r3.equals("") != false) goto L_0x11ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:530:0x12f8, code lost:
        if (r3.equals("") != false) goto L_0x11ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:739:0x1dc8, code lost:
        if (r1.url.contains("pixworld.io-desdeac") == false) goto L_0x1e1b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:882:0x269b, code lost:
        if (r1 != -1) goto L_0x26a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:535:0x130c  */
    /* JADX WARNING: Removed duplicated region for block: B:876:0x2661  */
    /* JADX WARNING: Removed duplicated region for block: B:892:0x26ce  */
    /* JADX WARNING: Removed duplicated region for block: B:895:0x26ea A[LOOP:16: B:894:0x26e8->B:895:0x26ea, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x26f7  */
    /* JADX WARNING: Removed duplicated region for block: B:899:0x26fb  */
    /* JADX WARNING: Removed duplicated region for block: B:903:0x2707  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int crear_globales(java.lang.String[] r29, java.lang.String[] r30, android.os.Bundle r31, android.content.Intent r32) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = 0
            r0.wv_cache_limpiada = r4
            java.lang.String r5 = "sh"
            android.content.SharedPreferences r5 = r0.getSharedPreferences(r5, r4)
            r5.registerOnSharedPreferenceChangeListener(r0)
            java.lang.String r6 = "ico_busc_ord"
            int r6 = r5.getInt(r6, r4)
            r0.ico_busc_ord = r6
            java.lang.String r6 = "ico_share_ord"
            int r6 = r5.getInt(r6, r4)
            r0.ico_share_ord = r6
            java.lang.String r6 = "ico_ofics_ord"
            int r6 = r5.getInt(r6, r4)
            r0.ico_ofics_ord = r6
            java.lang.String r6 = "ico_exit_ord"
            int r6 = r5.getInt(r6, r4)
            r0.ico_exit_ord = r6
            java.lang.String r6 = "ico_notif_ord"
            int r6 = r5.getInt(r6, r4)
            r0.ico_notif_ord = r6
            java.lang.String r6 = "ic_po"
            int r6 = r5.getInt(r6, r4)
            r0.ico_perfil_ord = r6
            java.lang.String r6 = "ic_so"
            int r6 = r5.getInt(r6, r4)
            r0.ico_search_ord = r6
            java.lang.String r6 = "ic_sa"
            int r6 = r5.getInt(r6, r4)
            r0.ico_sinads_ord = r6
            java.lang.String r6 = "io1"
            int r6 = r5.getInt(r6, r4)
            r7 = 1
            if (r6 != r7) goto L_0x0060
            r6 = 1
            goto L_0x0061
        L_0x0060:
            r6 = 0
        L_0x0061:
            r0.ico_ofics_imgperso = r6
            java.lang.String r6 = "io2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_ofics_imgperso_v = r6
            java.lang.String r6 = "io3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_ofics_idsec = r6
            java.lang.String r6 = "io4"
            java.lang.String r8 = ""
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_ofics_url = r6
            java.lang.String r6 = "ib1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x0087
            r6 = 1
            goto L_0x0088
        L_0x0087:
            r6 = 0
        L_0x0088:
            r0.ico_busc_imgperso = r6
            java.lang.String r6 = "ib2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_busc_imgperso_v = r6
            java.lang.String r6 = "ib3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_busc_idsec = r6
            java.lang.String r6 = "ib4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_busc_url = r6
            java.lang.String r6 = "ie1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x00ac
            r6 = 1
            goto L_0x00ad
        L_0x00ac:
            r6 = 0
        L_0x00ad:
            r0.ico_exit_imgperso = r6
            java.lang.String r6 = "ie2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_exit_imgperso_v = r6
            java.lang.String r6 = "ie3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_exit_idsec = r6
            java.lang.String r6 = "ie4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_exit_url = r6
            java.lang.String r6 = "in1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x00d1
            r6 = 1
            goto L_0x00d2
        L_0x00d1:
            r6 = 0
        L_0x00d2:
            r0.ico_notif_imgperso = r6
            java.lang.String r6 = "in2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_notif_imgperso_v = r6
            java.lang.String r6 = "in3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_notif_idsec = r6
            java.lang.String r6 = "in4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_notif_url = r6
            java.lang.String r6 = "is1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x00f6
            r6 = 1
            goto L_0x00f7
        L_0x00f6:
            r6 = 0
        L_0x00f7:
            r0.ico_share_imgperso = r6
            java.lang.String r6 = "is2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_share_imgperso_v = r6
            java.lang.String r6 = "is3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_share_idsec = r6
            java.lang.String r6 = "is4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_share_url = r6
            java.lang.String r6 = "ir1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x011b
            r6 = 1
            goto L_0x011c
        L_0x011b:
            r6 = 0
        L_0x011c:
            r0.ico_search_imgperso = r6
            java.lang.String r6 = "ir2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_search_imgperso_v = r6
            java.lang.String r6 = "ir3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_search_idsec = r6
            java.lang.String r6 = "ir4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_search_url = r6
            java.lang.String r6 = "ip1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x0140
            r6 = 1
            goto L_0x0141
        L_0x0140:
            r6 = 0
        L_0x0141:
            r0.ico_perfil_imgperso = r6
            java.lang.String r6 = "ip2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_perfil_imgperso_v = r6
            java.lang.String r6 = "ip3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_perfil_idsec = r6
            java.lang.String r6 = "ip4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_perfil_url = r6
            java.lang.String r6 = "ip5"
            int r6 = r5.getInt(r6, r4)
            r0.ico_perfil_modo = r6
            java.lang.String r6 = "id1"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x016d
            r6 = 1
            goto L_0x016e
        L_0x016d:
            r6 = 0
        L_0x016e:
            r0.ico_sinads_imgperso = r6
            java.lang.String r6 = "id2"
            int r6 = r5.getInt(r6, r4)
            r0.ico_sinads_imgperso_v = r6
            java.lang.String r6 = "id3"
            int r6 = r5.getInt(r6, r4)
            r0.ico_sinads_idsec = r6
            java.lang.String r6 = "id4"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.ico_sinads_url = r6
            java.lang.String r6 = "pla"
            int r6 = r5.getInt(r6, r4)
            if (r6 != r7) goto L_0x0192
            r6 = 1
            goto L_0x0193
        L_0x0192:
            r6 = 0
        L_0x0193:
            r0.pedir_location_aliniciar = r6
            java.lang.String r6 = "share_subject"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.share_subject = r6
            java.lang.String r6 = "share_text"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.share_text = r6
            java.lang.String r6 = "our"
            int r6 = r5.getInt(r6, r4)
            our = r6
            java.lang.String r6 = "admob_cod"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.admob_cod = r6
            java.lang.String r6 = "admob_pos"
            int r6 = r5.getInt(r6, r4)
            r0.admob_pos = r6
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.SMART_BANNER
            r0.admob_tipo = r6
            prioridad_admob = r4
            appnext_ent_modo = r7
            java.lang.String r6 = "i2"
            java.lang.String r6 = r5.getString(r6, r8)
            boolean r9 = r6.equals(r8)
            r10 = 2
            java.lang.String r11 = "1"
            if (r9 != 0) goto L_0x01ea
            java.lang.String r9 = r6.substring(r4, r7)
            boolean r9 = r9.equals(r11)
            prioridad_admob = r9
            java.lang.String r6 = r6.substring(r7, r10)
            int r6 = java.lang.Integer.parseInt(r6)
            appnext_ent_modo = r6
        L_0x01ea:
            java.lang.String r6 = "fbb"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.fb_b_cod = r6
            java.lang.String r6 = "fbi"
            java.lang.String r6 = r5.getString(r6, r8)
            fb_int_cod = r6
            java.lang.String r6 = "fbm"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.fb_menu_cod = r6
            java.lang.String r6 = "fbp"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.fb_pro_cod = r6
            java.lang.String r6 = "fbr"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.fb_rew_cod = r6
            java.lang.String r6 = "pfc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.pollfish_cod = r6
            java.lang.String r6 = "stb"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_b_cod = r6
            java.lang.String r6 = "sti"
            java.lang.String r6 = r5.getString(r6, r8)
            st_int_cod = r6
            java.lang.String r6 = "stm"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_menu_cod = r6
            java.lang.String r6 = "stp"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_pro_cod = r6
            java.lang.String r6 = "str"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_rew_cod = r6
            java.lang.String r6 = "iiu"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.instal_int_url = r6
            java.lang.String r6 = "piu"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.pa_int_url = r6
            java.lang.String r6 = "uai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.uni_appid = r6
            java.lang.String r6 = "ubc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.uni_b_cod = r6
            java.lang.String r6 = "uic"
            java.lang.String r6 = r5.getString(r6, r8)
            uni_int_cod = r6
            java.lang.String r6 = "urc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.uni_rew_cod = r6
            java.lang.String r6 = "iai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_appid = r6
            r0.is_b_cod = r8
            r0.is_pro_cod = r8
            r0.is_menu_cod = r8
            r0.is_radio_cod = r8
            r0.is_qr_cod = r8
            is_int_cod = r8
            r0.is_rew_cod = r8
            r0.is_card_cod = r8
            boolean r6 = r6.equals(r8)
            java.lang.String r9 = "0"
            if (r6 != 0) goto L_0x031b
            java.lang.String r6 = "ibc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_b_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02ab
            r0.is_b_cod = r8
        L_0x02ab:
            java.lang.String r6 = "ipc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_pro_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02bb
            r0.is_pro_cod = r8
        L_0x02bb:
            java.lang.String r6 = "imc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_menu_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02cb
            r0.is_menu_cod = r8
        L_0x02cb:
            java.lang.String r6 = "irc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_radio_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02db
            r0.is_radio_cod = r8
        L_0x02db:
            java.lang.String r6 = "iqc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_qr_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02eb
            r0.is_qr_cod = r8
        L_0x02eb:
            java.lang.String r6 = "iic"
            java.lang.String r6 = r5.getString(r6, r8)
            is_int_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02fb
            is_int_cod = r8
        L_0x02fb:
            java.lang.String r6 = "iwc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_rew_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x030b
            r0.is_rew_cod = r8
        L_0x030b:
            java.lang.String r6 = "icc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.is_card_cod = r6
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x031b
            r0.is_card_cod = r8
        L_0x031b:
            java.lang.String r6 = "a_ra"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.admob_radio_cod = r6
            java.lang.String r6 = "n_ra"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_radio_cod = r6
            java.lang.String r6 = "f_ra"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.fb_radio_cod = r6
            java.lang.String r6 = "st_ra"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_radio_cod = r6
            java.lang.String r6 = "a_qr"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.admob_qr_cod = r6
            java.lang.String r6 = "n_qr"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_qr_cod = r6
            java.lang.String r6 = "f_qr"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.fb_qr_cod = r6
            java.lang.String r6 = "st_qr"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_qr_cod = r6
            java.lang.String r6 = "n_i_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_inchat_cod = r6
            java.lang.String r6 = "st_i_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.st_inchat_cod = r6
            java.lang.String r6 = "ic_1"
            int r6 = r5.getInt(r6, r4)
            r0.inchat_1vez = r6
            java.lang.String r6 = "ic_v"
            int r6 = r5.getInt(r6, r4)
            r0.inchat_veces = r6
            java.lang.String r6 = "a_p_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.admob_pro_cod = r6
            java.lang.String r6 = "n_p_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_pro_cod = r6
            java.lang.String r6 = "upc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.uni_pro_cod = r6
            java.lang.String r6 = "a_m_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.admob_menu_cod = r6
            java.lang.String r6 = "n_m_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_menu_cod = r6
            java.lang.String r6 = "a_r_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.admob_rew_cod = r6
            java.lang.String r6 = "n_r_c"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_rew_cod = r6
            java.lang.String r6 = "r_mo"
            int r6 = r5.getInt(r6, r4)
            r0.rew_modo = r6
            java.lang.String r6 = "r_ms"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.rew_msg = r6
            java.lang.String r6 = "r_pms"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.rew_poll_msg = r6
            r0.admob_pro_w = r4
            r0.admob_pro_h = r4
            java.lang.String r6 = "a_p_s"
            java.lang.String r12 = "0x0"
            java.lang.String r6 = r5.getString(r6, r12)
            java.lang.String r12 = "x"
            java.lang.String[] r6 = r6.split(r12)
            int r12 = r6.length
            if (r12 != r10) goto L_0x03f5
            r12 = r6[r4]
            int r12 = java.lang.Integer.parseInt(r12)
            r0.admob_pro_w = r12
            r6 = r6[r7]
            int r6 = java.lang.Integer.parseInt(r6)
            r0.admob_pro_h = r6
        L_0x03f5:
            r0.admob_menu_w = r4
            r0.admob_menu_h = r4
            java.lang.String r6 = "a_m_s"
            java.lang.String r12 = "0x0"
            java.lang.String r6 = r5.getString(r6, r12)
            java.lang.String r12 = "x"
            java.lang.String[] r6 = r6.split(r12)
            int r12 = r6.length
            if (r12 != r10) goto L_0x041b
            r12 = r6[r4]
            int r12 = java.lang.Integer.parseInt(r12)
            r0.admob_menu_w = r12
            r6 = r6[r7]
            int r6 = java.lang.Integer.parseInt(r6)
            r0.admob_menu_h = r6
        L_0x041b:
            boolean r6 = r0.card_nuestro
            if (r6 == 0) goto L_0x043f
            java.lang.String r6 = "ca_a"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.card_admob_nuestro = r6
            java.lang.String r6 = "ca_n"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.card_appnext_nuestro = r6
            java.lang.String r6 = "ca_f"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.card_fb_nuestro = r6
            java.lang.String r6 = "ca_s"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.card_st_nuestro = r6
        L_0x043f:
            java.lang.String r6 = "fca"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.forzar_cargar_appnext = r6
            java.lang.String r6 = "fcs"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.forzar_cargar_startapp = r6
            java.lang.String r6 = "admob_sma"
            int r6 = r5.getInt(r6, r7)
            if (r6 != 0) goto L_0x045c
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.BANNER
            r0.admob_tipo = r6
            goto L_0x0468
        L_0x045c:
            java.lang.String r6 = "admob_sma"
            int r6 = r5.getInt(r6, r7)
            if (r6 != r10) goto L_0x0468
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.LARGE_BANNER
            r0.admob_tipo = r6
        L_0x0468:
            java.lang.String r6 = "admob_int_cod"
            java.lang.String r6 = r5.getString(r6, r8)
            admob_int_cod = r6
            java.lang.String r6 = "aac"
            java.lang.String r6 = r5.getString(r6, r8)
            admob_appopen_cod = r6
            java.lang.String r6 = "wai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_appid = r6
            java.lang.String r6 = "wic"
            java.lang.String r6 = r5.getString(r6, r8)
            wortise_int_cod = r6
            java.lang.String r6 = "wbc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_b_cod = r6
            java.lang.String r6 = "wpc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_pro_cod = r6
            java.lang.String r6 = "wmc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_menu_cod = r6
            java.lang.String r6 = "wrc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_radio_cod = r6
            java.lang.String r6 = "wqc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_qr_cod = r6
            java.lang.String r6 = "wwc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_rew_cod = r6
            java.lang.String r6 = "wcc"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.wortise_card_cod = r6
            java.lang.String r6 = "mai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.monedata_appid = r6
            java.lang.String r6 = "pai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.pangle_appid = r6
            java.lang.String r6 = "pic"
            java.lang.String r6 = r5.getString(r6, r8)
            pangle_int_cod = r6
            java.lang.String r6 = "lai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.liftoff_appid = r6
            java.lang.String r6 = "lic"
            java.lang.String r6 = r5.getString(r6, r8)
            liftoff_int_cod = r6
            java.lang.String r6 = "miai"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.mint_appid = r6
            java.lang.String r6 = "miak"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.mint_appkey = r6
            java.lang.String r6 = "miicp"
            java.lang.String r6 = r5.getString(r6, r8)
            mint_int_cod_place = r6
            java.lang.String r6 = "miicu"
            java.lang.String r6 = r5.getString(r6, r8)
            mint_int_cod_unit = r6
            java.lang.String r6 = "tcn"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.catsnotif_tit = r6
            java.lang.String r6 = "b_c"
            int r6 = r5.getInt(r6, r7)
            if (r6 != r7) goto L_0x0524
            r6 = 1
            goto L_0x0525
        L_0x0524:
            r6 = 0
        L_0x0525:
            r0.banners_enchats = r6
            java.lang.String r6 = "l_c"
            int r6 = r5.getInt(r6, r7)
            if (r6 != r7) goto L_0x0531
            r6 = 1
            goto L_0x0532
        L_0x0531:
            r6 = 0
        L_0x0532:
            r0.links_enchats = r6
            java.lang.String r6 = "fp"
            int r6 = r5.getInt(r6, r7)
            if (r6 != r7) goto L_0x053e
            r6 = 1
            goto L_0x053f
        L_0x053e:
            r6 = 0
        L_0x053f:
            r0.fotos_privados = r6
            java.lang.String r6 = "cvm"
            int r6 = r5.getInt(r6, r4)
            r0.cvm = r6
            java.lang.String r6 = "emo"
            int r6 = r5.getInt(r6, r7)
            if (r6 != r7) goto L_0x0553
            r6 = 1
            goto L_0x0554
        L_0x0553:
            r6 = 0
        L_0x0554:
            r0.emojis = r6
            r0.bubbles = r7
            r0.c_txt_chats = r7
            r0.galeriav = r4
            r0.aviso_cookies = r4
            r0.privacy_enmenu = r4
            r0.fnac_completa = r4
            r0.es_admin = r4
            r0.splash_margen = r7
            r0.splash_tipo = r7
            r0.autoapagado = r4
            r0.screenshot_inhab = r4
            r0.tts_mostrar = r4
            r0.spam_mostrar = r4
            r0.customtabs = r4
            r0.video_pip_icon = r4
            r0.video_pip_auto = r4
            java.lang.String r6 = "i"
            java.lang.String r6 = r5.getString(r6, r8)
            boolean r12 = r6.equals(r8)
            r15 = 5
            r13 = 4
            r14 = 3
            if (r12 != 0) goto L_0x074f
            java.lang.String r12 = r6.substring(r4, r7)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.bubbles = r12
            java.lang.String r12 = r6.substring(r7, r10)
            boolean r12 = r12.equals(r11)
            r0.c_txt_chats = r12
            java.lang.String r12 = r6.substring(r10, r14)
            boolean r12 = r12.equals(r11)
            r0.galeriav = r12
            java.lang.String r12 = r6.substring(r14, r13)
            boolean r12 = r12.equals(r11)
            r0.search_tit = r12
            java.lang.String r12 = r6.substring(r13, r15)
            boolean r12 = r12.equals(r11)
            r0.search_descr = r12
            r12 = 6
            java.lang.String r13 = r6.substring(r15, r12)
            boolean r13 = r13.equals(r11)
            r0.search_show_tit = r13
            r13 = 7
            java.lang.String r15 = r6.substring(r12, r13)
            boolean r12 = r15.equals(r11)
            r0.search_show_descr = r12
            r12 = 8
            java.lang.String r15 = r6.substring(r13, r12)
            boolean r13 = r15.equals(r11)
            r0.search_show_ico = r13
            r13 = 9
            java.lang.String r15 = r6.substring(r12, r13)
            boolean r12 = r15.equals(r11)
            r0.aviso_cookies = r12
            r12 = 10
            java.lang.String r15 = r6.substring(r13, r12)
            boolean r13 = r15.equals(r11)
            r0.privacy_enmenu = r13
            int r13 = r6.length()
            if (r13 <= r12) goto L_0x0604
            r13 = 11
            java.lang.String r15 = r6.substring(r12, r13)
            boolean r12 = r15.equals(r11)
            r0.es_admin = r12
            goto L_0x0606
        L_0x0604:
            r13 = 11
        L_0x0606:
            int r12 = r6.length()
            if (r12 <= r13) goto L_0x0619
            r12 = 12
            java.lang.String r15 = r6.substring(r13, r12)
            boolean r13 = r15.equals(r11)
            r0.fnac_completa = r13
            goto L_0x061b
        L_0x0619:
            r12 = 12
        L_0x061b:
            int r13 = r6.length()
            if (r13 <= r12) goto L_0x062d
            r13 = 13
            java.lang.String r13 = r6.substring(r12, r13)
            boolean r12 = r13.equals(r11)
            r0.splash_margen = r12
        L_0x062d:
            int r12 = r6.length()
            r13 = 13
            if (r12 <= r13) goto L_0x0643
            r12 = 13
            r13 = 14
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.splash_tipo = r12
        L_0x0643:
            int r12 = r6.length()
            r13 = 14
            if (r12 <= r13) goto L_0x0667
            r12 = 14
            r13 = 15
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.fondo_margen = r12
            r12 = 15
            r13 = 16
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.fondo_tipo = r12
        L_0x0667:
            int r12 = r6.length()
            r13 = 16
            if (r12 <= r13) goto L_0x06b5
            r12 = 16
            r13 = 17
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.glob_acceso = r12
            r12 = 17
            r13 = 18
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.glob_fotos_perfil = r12
            r12 = 18
            r13 = 19
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.glob_fnac = r12
            r12 = 19
            r13 = 20
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.glob_sexo = r12
            r12 = 20
            r13 = 21
            java.lang.String r12 = r6.substring(r12, r13)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.glob_descr = r12
        L_0x06b5:
            int r12 = r6.length()
            r13 = 21
            if (r12 <= r13) goto L_0x06cb
            r12 = 21
            r13 = 22
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.autoapagado = r12
        L_0x06cb:
            int r12 = r6.length()
            r13 = 24
            if (r12 <= r13) goto L_0x06e1
            r12 = 24
            r13 = 25
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.tts_mostrar = r12
        L_0x06e1:
            int r12 = r6.length()
            r13 = 25
            if (r12 <= r13) goto L_0x06f7
            r12 = 25
            r13 = 26
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.spam_mostrar = r12
        L_0x06f7:
            int r12 = r6.length()
            r13 = 26
            if (r12 <= r13) goto L_0x070d
            r12 = 26
            r13 = 27
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.customtabs = r12
        L_0x070d:
            int r12 = r6.length()
            r13 = 27
            if (r12 <= r13) goto L_0x0723
            r12 = 27
            r13 = 28
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.screenshot_inhab = r12
        L_0x0723:
            int r12 = r6.length()
            r13 = 28
            if (r12 <= r13) goto L_0x0739
            r12 = 28
            r13 = 29
            java.lang.String r12 = r6.substring(r12, r13)
            boolean r12 = r12.equals(r11)
            r0.video_pip_icon = r12
        L_0x0739:
            int r12 = r6.length()
            r13 = 29
            if (r12 <= r13) goto L_0x074f
            r12 = 29
            r13 = 30
            java.lang.String r6 = r6.substring(r12, r13)
            boolean r6 = r6.equals(r11)
            r0.video_pip_auto = r6
        L_0x074f:
            java.lang.String r6 = "cb"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.c_bubbles = r6
            java.lang.String r6 = "fv"
            int r6 = r5.getInt(r6, r4)
            r0.fondo_v = r6
            java.lang.String r6 = "pv"
            int r6 = r5.getInt(r6, r4)
            r0.playerjs_v = r6
            java.lang.String r6 = "pdv"
            int r6 = r5.getInt(r6, r4)
            r0.playerjs_def_v = r6
            r6 = 1
            r12 = 0
        L_0x0771:
            r13 = 6
            if (r6 >= r13) goto L_0x0791
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r15 = "mb_"
            r13.<init>(r15)
            r13.append(r6)
            java.lang.String r13 = r13.toString()
            java.lang.String r13 = r5.getString(r13, r8)
            boolean r13 = r13.equals(r8)
            if (r13 != 0) goto L_0x078e
            int r12 = r12 + 1
        L_0x078e:
            int r6 = r6 + 1
            goto L_0x0771
        L_0x0791:
            stikerwap.appdys.config$mb_item[] r6 = new stikerwap.appdys.config.mb_item[r12]
            mb_items = r6
            r6 = 1
            r12 = 0
        L_0x0797:
            java.lang.String r13 = "@"
            r15 = 6
            if (r6 >= r15) goto L_0x082e
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r14 = "mb_"
            r15.<init>(r14)
            r15.append(r6)
            java.lang.String r14 = r15.toString()
            java.lang.String r14 = r5.getString(r14, r8)
            boolean r15 = r14.equals(r8)
            if (r15 != 0) goto L_0x0827
            stikerwap.appdys.config$mb_item[] r15 = mb_items
            stikerwap.appdys.config$mb_item r17 = new stikerwap.appdys.config$mb_item
            r17.<init>()
            r15[r12] = r17
            java.lang.String[] r14 = r14.split(r13)
            stikerwap.appdys.config$mb_item[] r15 = mb_items
            r15 = r15[r12]
            r17 = r14[r4]
            int r4 = java.lang.Integer.parseInt(r17)
            r15.id = r4
            stikerwap.appdys.config$mb_item[] r4 = mb_items
            r4 = r4[r12]
            r15 = r14[r7]
            java.lang.String r7 = "-ARR-"
            java.lang.String r7 = r15.replace(r7, r13)
            r4.txt = r7
            r4 = r14[r10]
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x07f1
            stikerwap.appdys.config$mb_item[] r4 = mb_items
            r4 = r4[r12]
            r7 = 3
            r15 = r14[r7]
            int r7 = java.lang.Integer.parseInt(r15)
            r4.img_v = r7
            goto L_0x07f8
        L_0x07f1:
            stikerwap.appdys.config$mb_item[] r4 = mb_items
            r4 = r4[r12]
            r7 = 0
            r4.img_v = r7
        L_0x07f8:
            stikerwap.appdys.config$mb_item[] r4 = mb_items
            r4 = r4[r12]
            r7 = 4
            r15 = r14[r7]
            int r7 = java.lang.Integer.parseInt(r15)
            r4.idsecc = r7
            stikerwap.appdys.config$mb_item[] r4 = mb_items
            r4 = r4[r12]
            r7 = 5
            r15 = r14[r7]
            java.lang.String r7 = "-ARR-"
            java.lang.String r7 = r15.replace(r7, r13)
            r4.url = r7
            stikerwap.appdys.config$mb_item[] r4 = mb_items
            r4 = r4[r12]
            r7 = 6
            r13 = r14[r7]
            boolean r7 = r13.equals(r11)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r4.externo = r7
            int r12 = r12 + 1
        L_0x0827:
            int r6 = r6 + 1
            r4 = 0
            r7 = 1
            r14 = 3
            goto L_0x0797
        L_0x082e:
            java.lang.String r4 = "mb_cbg"
            java.lang.String r4 = r5.getString(r4, r8)
            mb_c_bg = r4
            java.lang.String r4 = "mb_cit"
            java.lang.String r4 = r5.getString(r4, r8)
            mb_c_items = r4
            java.lang.String r4 = "vipe"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.v_ico_perfil = r4
            java.lang.String r4 = "vipr"
            int r4 = r5.getInt(r4, r6)
            r0.v_ico_privados = r4
            java.lang.String r4 = "vifo"
            int r4 = r5.getInt(r4, r6)
            r0.v_ico_foto = r4
            java.lang.String r4 = "vivi"
            int r4 = r5.getInt(r4, r6)
            r0.v_ico_video = r4
            java.lang.String r4 = "viem"
            int r4 = r5.getInt(r4, r6)
            r0.v_ico_emotic = r4
            java.lang.String r4 = "vien"
            int r4 = r5.getInt(r4, r6)
            r0.v_ico_enviar = r4
            java.lang.String r4 = "mv"
            r7 = 8
            int r4 = r5.getInt(r4, r7)
            r0.max_videos_pro = r4
            java.lang.String r4 = "r_p"
            int r4 = r5.getInt(r4, r6)
            r0.radio_pos = r4
            java.lang.String r4 = "r_t_c"
            int r4 = r5.getInt(r4, r6)
            r7 = 1
            if (r4 != r7) goto L_0x0892
            r4 = 1
            goto L_0x0893
        L_0x0892:
            r4 = 0
        L_0x0893:
            r0.radio_txt_c = r4
            java.lang.String r4 = "r_a_s"
            int r4 = r5.getInt(r4, r6)
            r0.radio_artist_size = r4
            java.lang.String r4 = "r_s_s"
            int r4 = r5.getInt(r4, r6)
            r0.radio_song_size = r4
            java.lang.String r4 = "r_a_c"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.radio_artist_col = r4
            java.lang.String r4 = "r_s_c"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.radio_song_col = r4
            java.lang.String r4 = "r_a_b"
            int r4 = r5.getInt(r4, r6)
            r7 = 1
            if (r4 != r7) goto L_0x08c0
            r4 = 1
            goto L_0x08c1
        L_0x08c0:
            r4 = 0
        L_0x08c1:
            r0.radio_artist_b = r4
            java.lang.String r4 = "r_s_b"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x08cd
            r4 = 1
            goto L_0x08ce
        L_0x08cd:
            r4 = 0
        L_0x08ce:
            r0.radio_song_b = r4
            java.lang.String r4 = "r_a"
            int r4 = r5.getInt(r4, r6)
            r0.radio_apagado = r4
            java.lang.String r4 = "cs_v"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x08e2
            r4 = 1
            goto L_0x08e3
        L_0x08e2:
            r4 = 0
        L_0x08e3:
            r0.chatsecc_en_video = r4
            java.lang.String r4 = "cs_r"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x08ef
            r4 = 1
            goto L_0x08f0
        L_0x08ef:
            r4 = 0
        L_0x08f0:
            r0.chatsecc_en_radio = r4
            java.lang.String r4 = "cs_p"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x08fc
            r4 = 1
            goto L_0x08fd
        L_0x08fc:
            r4 = 0
        L_0x08fd:
            r0.chatsecc_privados = r4
            java.lang.String r4 = "cs_c"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x0909
            r4 = 1
            goto L_0x090a
        L_0x0909:
            r4 = 0
        L_0x090a:
            r0.chatsecc_coments = r4
            java.lang.String r4 = "cs_g"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x0916
            r4 = 1
            goto L_0x0917
        L_0x0916:
            r4 = 0
        L_0x0917:
            r0.chatsecc_galeria = r4
            java.lang.String r4 = "cs_ap"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x0923
            r4 = 1
            goto L_0x0924
        L_0x0923:
            r4 = 0
        L_0x0924:
            r0.chatsecc_acceso_a_perfil = r4
            java.lang.String r4 = "cs_fp"
            int r4 = r5.getInt(r4, r6)
            r0.chatsecc_fotos_perfil = r4
            java.lang.String r4 = "cs_pf"
            int r4 = r5.getInt(r4, r6)
            r0.chatsecc_p_fnac = r4
            java.lang.String r4 = "cs_ps"
            int r4 = r5.getInt(r4, r6)
            r0.chatsecc_p_sexo = r4
            java.lang.String r4 = "cs_pde"
            int r4 = r5.getInt(r4, r6)
            r0.chatsecc_p_descr = r4
            java.lang.String r4 = "cs_pdi"
            int r4 = r5.getInt(r4, r6)
            r0.chatsecc_p_dist = r4
            java.lang.String r4 = "appnext_cod"
            java.lang.String r4 = r5.getString(r4, r8)
            appnext_cod = r4
            java.lang.String r4 = "appnext_cod_int_e"
            java.lang.String r4 = r5.getString(r4, r8)
            appnext_cod_int_e = r4
            java.lang.String r4 = "appnext_cod_int_ia"
            java.lang.String r4 = r5.getString(r4, r8)
            appnext_cod_int_ia = r4
            java.lang.String r4 = "ap"
            r6 = 1
            int r4 = r5.getInt(r4, r6)
            if (r4 != r6) goto L_0x0971
            r4 = 1
            goto L_0x0972
        L_0x0971:
            r4 = 0
        L_0x0972:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            autoplay = r4
            java.lang.String r4 = "mu"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r6) goto L_0x0982
            r4 = 1
            goto L_0x0983
        L_0x0982:
            r4 = 0
        L_0x0983:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            mute = r4
            java.lang.String r4 = appnext_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x099e
            java.lang.String r4 = appnext_cod_int_e
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x099e
            java.lang.String r4 = appnext_cod_int_e
            appnext_cod = r4
            goto L_0x09b4
        L_0x099e:
            java.lang.String r4 = appnext_cod
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x09b4
            java.lang.String r4 = appnext_cod_int_e
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x09b4
            java.lang.String r4 = appnext_cod
            appnext_cod_int_e = r4
            appnext_cod_int_ia = r4
        L_0x09b4:
            java.lang.String r4 = "appnextb_cod"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.appnextb_cod = r4
            r0.appnext_video_cod = r8
            r4 = 1
            r0.appnext_video_ini = r4
            r6 = 4
            r0.appnext_video_interv = r6
            java.lang.String r6 = "apn_v"
            java.lang.String r6 = r5.getString(r6, r8)
            java.lang.String[] r6 = r6.split(r13)
            int r7 = r6.length
            if (r7 <= r10) goto L_0x09e6
            r7 = 0
            r12 = r6[r7]
            r0.appnext_video_cod = r12
            r7 = r6[r4]
            int r7 = java.lang.Integer.parseInt(r7)
            r0.appnext_video_ini = r7
            r6 = r6[r10]
            int r6 = java.lang.Integer.parseInt(r6)
            r0.appnext_video_interv = r6
        L_0x09e6:
            java.lang.String r6 = "apn_vi"
            java.lang.String r6 = r5.getString(r6, r8)
            r0.appnext_vi_cod = r6
            r0.appnext_vi_ini = r4
            r6 = 4
            r0.appnext_vi_interv = r6
            java.lang.String r6 = "vi"
            java.lang.String r6 = r5.getString(r6, r8)
            java.lang.String[] r6 = r6.split(r13)
            int r7 = r6.length
            if (r7 <= r4) goto L_0x0a12
            r7 = 0
            r12 = r6[r7]
            int r7 = java.lang.Integer.parseInt(r12)
            r0.appnext_vi_ini = r7
            r6 = r6[r4]
            int r4 = java.lang.Integer.parseInt(r6)
            r0.appnext_vi_interv = r4
        L_0x0a12:
            admob_app_id = r8
            android.content.pm.PackageManager r4 = r28.getPackageManager()     // Catch:{ Exception -> 0x0a2d }
            java.lang.String r6 = r28.getPackageName()     // Catch:{ Exception -> 0x0a2d }
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r6, r7)     // Catch:{ Exception -> 0x0a2d }
            android.os.Bundle r4 = r4.metaData     // Catch:{ Exception -> 0x0a2d }
            java.lang.String r6 = "com.google.android.gms.ads.APPLICATION_ID"
            java.lang.String r4 = r4.getString(r6, r8)     // Catch:{ Exception -> 0x0a2d }
            admob_app_id = r4     // Catch:{ Exception -> 0x0a2d }
            goto L_0x0a2e
        L_0x0a2d:
        L_0x0a2e:
            java.lang.String r4 = admob_app_id
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0a46
            r0.admob_cod = r8
            admob_int_cod = r8
            admob_appopen_cod = r8
            r0.admob_pro_cod = r8
            r0.admob_radio_cod = r8
            r0.admob_qr_cod = r8
            r0.admob_menu_cod = r8
            r0.admob_rew_cod = r8
        L_0x0a46:
            java.lang.String r4 = pangle_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = liftoff_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = mint_int_cod_place
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = wortise_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = admob_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = appnext_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = fb_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = st_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = uni_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = r0.pa_int_url
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            java.lang.String r4 = is_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0aa0
            r4 = 0
            goto L_0x0aa7
        L_0x0aa0:
            java.lang.String r4 = "admob_int_v"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
        L_0x0aa7:
            r0.admob_int_interv = r4
            java.lang.String r4 = pangle_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = liftoff_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = mint_int_cod_place
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = wortise_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = admob_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = appnext_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = fb_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = st_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = uni_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = r0.pa_int_url
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            java.lang.String r4 = is_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b03
            r4 = 0
            goto L_0x0b0a
        L_0x0b03:
            java.lang.String r4 = "aigi"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
        L_0x0b0a:
            r0.admob_intgame_interv = r4
            java.lang.String r4 = wortise_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = admob_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = admob_appopen_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = appnext_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = fb_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = st_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = uni_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            java.lang.String r4 = is_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0b4e
            r4 = 0
            goto L_0x0b55
        L_0x0b4e:
            java.lang.String r4 = "admob_inte_v"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
        L_0x0b55:
            r0.admob_intentrar_interv = r4
            java.lang.String r4 = pangle_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = liftoff_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = mint_int_cod_place
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = wortise_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = admob_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = appnext_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = fb_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = st_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = uni_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = r0.pa_int_url
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            java.lang.String r4 = is_int_cod
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0bb2
            r4 = 0
            r6 = 0
            goto L_0x0bbb
        L_0x0bb2:
            java.lang.String r4 = "admob_ch_v"
            r6 = 0
            int r18 = r5.getInt(r4, r6)
            r4 = r18
        L_0x0bbb:
            r0.admob_chat_interv = r4
            r0.acad_tit = r8
            java.lang.String r4 = "acad"
            java.lang.String r4 = r5.getString(r4, r8)
            java.lang.String[] r4 = r4.split(r13)
            int r7 = r4.length
            r12 = 6
            if (r7 <= r12) goto L_0x0bee
            r7 = r4[r6]
            r0.acad_tit = r7
            r6 = 1
            r7 = r4[r6]
            r0.acad_descr = r7
            r6 = r4[r10]
            r0.acad_img = r6
            r6 = 3
            r7 = r4[r6]
            r0.acad_ico = r7
            r6 = 4
            r7 = r4[r6]
            r0.acad_package = r7
            r6 = 5
            r7 = r4[r6]
            r0.acad_ref = r7
            r6 = 6
            r4 = r4[r6]
            r0.acad_rating = r4
        L_0x0bee:
            java.lang.String r4 = "tipomenu"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.tipomenu = r4
            java.lang.String r4 = "petic_ask_nombre"
            int r4 = r5.getInt(r4, r6)
            r0.petic_ask_nombre = r4
            java.lang.String r4 = "petic_ask_email"
            int r4 = r5.getInt(r4, r6)
            r0.petic_ask_email = r4
            java.lang.String r4 = "petic_ask_tel"
            int r4 = r5.getInt(r4, r6)
            r0.petic_ask_tel = r4
            java.lang.String r4 = "sep_secc"
            int r4 = r5.getInt(r4, r6)
            if (r4 != 0) goto L_0x0c1b
            r0.sep_secc = r6
            goto L_0x0c1e
        L_0x0c1b:
            r4 = 1
            r0.sep_secc = r4
        L_0x0c1e:
            java.lang.String r4 = "t_ind"
            int r4 = r5.getInt(r4, r6)
            r0.t_ind = r4
            java.lang.String r4 = "t_mas"
            int r4 = r5.getInt(r4, r6)
            r0.t_mas = r4
            java.lang.String r4 = "c1"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c1 = r4
            java.lang.String r4 = "c2"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c2 = r4
            java.lang.String r4 = "c1c"
            java.lang.String r6 = r0.c1
            java.lang.String r4 = r5.getString(r4, r6)
            r0.c1c = r4
            java.lang.String r4 = "c2c"
            java.lang.String r6 = r0.c2
            java.lang.String r4 = r5.getString(r4, r6)
            r0.c2c = r4
            java.lang.String r4 = "c_icos"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_icos = r4
            java.lang.String r4 = "c_icos_t"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_icos_top = r4
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0c6e
            java.lang.String r4 = r0.c_icos
            r0.c_icos_top = r4
        L_0x0c6e:
            java.lang.String r4 = "c_sep_secc"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_sep_secc = r4
            java.lang.String r4 = "c_secc_noactiv"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_secc_noactiv = r4
            java.lang.String r4 = "c_secc_activ"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_secc_activ = r4
            java.lang.String r4 = "c_linea"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_linea = r4
            java.lang.String r4 = "c_ind"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_ind = r4
            java.lang.String r4 = "c1_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c1_ofic = r4
            java.lang.String r4 = "c2_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c2_ofic = r4
            java.lang.String r4 = "c_perofic"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.c_perofic = r4
            java.lang.String r4 = "c_tit_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_tit_ofic = r4
            java.lang.String r4 = "c_sep_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_sep_ofic = r4
            java.lang.String r4 = "c_ico_sep_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_ico_sep_ofic = r4
            java.lang.String r4 = "c_txt_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_txt_ofic = r4
            java.lang.String r4 = "c_icos_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_icos_ofic = r4
            java.lang.String r4 = "c_ir_ofic"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_ir_ofic = r4
            java.lang.String r4 = "c1_sp"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c1_splash = r4
            java.lang.String r4 = "c2_sp"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c2_splash = r4
            java.lang.String r4 = "c1_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c1_prods = r4
            java.lang.String r4 = "c2_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c2_prods = r4
            java.lang.String r4 = "c_txt_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_txt_prods = r4
            java.lang.String r4 = "c_icos_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_icos_prods = r4
            java.lang.String r4 = "c_icos_2_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_icos_2_prods = r4
            java.lang.String r4 = "c_tit_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_tit_prods = r4
            java.lang.String r4 = "c_sep_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_sep_prods = r4
            java.lang.String r4 = "c_ico_sep_prods"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_ico_sep_prods = r4
            java.lang.String r4 = "c1_prods_l"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c1_prods_l = r4
            java.lang.String r4 = "c2_prods_l"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c2_prods_l = r4
            java.lang.String r4 = "c_perprod"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.c_perprod = r4
            java.lang.String r4 = "c_tit_prods_l"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_tit_prods_l = r4
            java.lang.String r4 = "c_precio_prods_l"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_precio_prods_l = r4
            java.lang.String r4 = "c_antiguedad_prods_l"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_antiguedad_prods_l = r4
            java.lang.String r4 = "c_prods_det"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.c_prods_det = r4
            java.lang.String r4 = "splash_w"
            r6 = 2000(0x7d0, float:2.803E-42)
            int r4 = r5.getInt(r4, r6)
            r0.splash_w = r4
            java.lang.String r4 = "s_v"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.slider_v = r4
            java.lang.String r4 = "s_h"
            int r4 = r5.getInt(r4, r6)
            r0.slider_h = r4
            java.lang.String r4 = "bv_txt"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.bienvenida_txt = r4
            java.lang.String r4 = "bv_tit"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.bienvenida_tit = r4
            java.lang.String r4 = "bv_nomas_mostrar"
            int r4 = r5.getInt(r4, r6)
            if (r4 != 0) goto L_0x0da0
            r0.bienvenida_nomas_mostrar = r6
            r4 = 1
            goto L_0x0da3
        L_0x0da0:
            r4 = 1
            r0.bienvenida_nomas_mostrar = r4
        L_0x0da3:
            java.lang.String r7 = "bv_nomas_def"
            int r7 = r5.getInt(r7, r6)
            if (r7 != 0) goto L_0x0dae
            r0.bienvenida_nomas_def = r6
            goto L_0x0db0
        L_0x0dae:
            r0.bienvenida_nomas_def = r4
        L_0x0db0:
            r0.pb_tipo = r4
            r0.pb_pos = r6
            r0.pb_s = r10
            java.lang.String r4 = "FF666666"
            r0.pb_c = r4
            java.lang.String r4 = "sp_i"
            java.lang.String r4 = r5.getString(r4, r8)
            int r7 = r4.length()
            r12 = 10
            if (r7 <= r12) goto L_0x0df3
            r7 = 8
            java.lang.String r14 = r4.substring(r6, r7)
            r0.pb_c = r14
            r6 = 9
            java.lang.String r14 = r4.substring(r7, r6)
            int r7 = java.lang.Integer.parseInt(r14)
            r0.pb_tipo = r7
            java.lang.String r7 = r4.substring(r6, r12)
            int r6 = java.lang.Integer.parseInt(r7)
            r0.pb_pos = r6
            r6 = 11
            java.lang.String r4 = r4.substring(r12, r6)
            int r4 = java.lang.Integer.parseInt(r4)
            r0.pb_s = r4
        L_0x0df3:
            r4 = 0
            r0.fb_modo = r4
            r0.fb_bloqdatos = r4
            r0.login_tipo = r4
            java.lang.String r4 = "fb_m"
            java.lang.String r4 = r5.getString(r4, r9)     // Catch:{ Exception -> 0x0e01 }
            goto L_0x0e03
        L_0x0e01:
            r4 = r9
        L_0x0e03:
            r6 = 0
            r7 = 1
            java.lang.String r12 = r4.substring(r6, r7)
            int r12 = java.lang.Integer.parseInt(r12)
            r0.fb_modo = r12
            if (r12 == r7) goto L_0x0e13
            if (r12 != r10) goto L_0x0e31
        L_0x0e13:
            int r12 = r4.length()
            if (r12 >= r10) goto L_0x0e1c
            r0.fb_modo = r6
            goto L_0x0e31
        L_0x0e1c:
            java.lang.String r12 = r4.substring(r7, r10)
            boolean r7 = r12.equals(r11)
            r0.fb_bloqdatos = r7
            r7 = 3
            java.lang.String r4 = r4.substring(r10, r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r0.login_tipo = r4
        L_0x0e31:
            java.lang.String r4 = "vcn"
            int r4 = r5.getInt(r4, r6)
            r0.catsnotif_v_bd = r4
            java.lang.String r4 = "hcn"
            int r4 = r5.getInt(r4, r6)
            r6 = 1
            if (r4 != r6) goto L_0x0e45
            r4 = 1
            goto L_0x0e46
        L_0x0e45:
            r4 = 0
        L_0x0e46:
            r0.hay_catsnotif = r4
            java.lang.String r4 = "nd_t"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.notifdef_tit = r4
            java.lang.String r4 = "nd_s"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.notifdef_txt = r4
            java.lang.String r4 = "nd_i"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.notifdef_idabrir = r4
            java.lang.String r4 = "nd_u"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.notifdef_url = r4
            java.lang.String r4 = "conf_ex"
            int r4 = r5.getInt(r4, r6)
            r6 = 1
            if (r4 != r6) goto L_0x0e74
            r4 = 1
            goto L_0x0e75
        L_0x0e74:
            r4 = 0
        L_0x0e75:
            r0.pedir_confirm_exit = r4
            java.lang.String r4 = "pp"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r6) goto L_0x0e81
            r4 = 1
            goto L_0x0e82
        L_0x0e81:
            r4 = 0
        L_0x0e82:
            r0.privacy_mostrar = r4
            java.lang.String r4 = "pp2"
            r7 = 0
            int r4 = r5.getInt(r4, r7)
            if (r4 != r6) goto L_0x0e8f
            r4 = 1
            goto L_0x0e90
        L_0x0e8f:
            r4 = 0
        L_0x0e90:
            r0.privacy_mostrar_2 = r4
            java.lang.String r4 = "ps"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.precio_secc = r4
            java.lang.String r4 = "pd"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.precio_divisa = r4
            java.lang.String r4 = "pt"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.precio_time = r4
            java.lang.String r4 = "pm"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.precio_msg = r4
            java.lang.String r4 = "pz"
            int r4 = r5.getInt(r4, r6)
            r0.precio_modo = r4
            java.lang.String r4 = "pe"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.precio_email = r4
            java.lang.String r4 = "ps2"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.precio_sinads = r4
            java.lang.String r4 = "pt2"
            int r4 = r5.getInt(r4, r6)
            r0.precio_time_sinads = r4
            java.lang.String r4 = "pm2"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.precio_msg_sinads = r4
            java.lang.String r4 = "rt_tit"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.rate_tit = r4
            java.lang.String r4 = "rt_txt"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.rate_txt = r4
            java.lang.String r4 = "rt_ok"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.rate_ok = r4
            java.lang.String r4 = "rt_ko"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.rate_ko = r4
            java.lang.String r4 = "rt_1v"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.rate_primeravez = r4
            java.lang.String r4 = "rt_int"
            int r4 = r5.getInt(r4, r6)
            r0.rate_int = r4
            java.lang.String r4 = "rt_t"
            int r4 = r5.getInt(r4, r6)
            r0.rate_tipo = r4
            java.lang.String r4 = "wv_sc"
            r6 = 1
            int r4 = r5.getInt(r4, r6)
            if (r4 != r6) goto L_0x0f20
            r4 = 1
            goto L_0x0f21
        L_0x0f20:
            r4 = 0
        L_0x0f21:
            r0.wv_sinconex = r4
            java.lang.String r4 = "wv_sc_txt"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.wv_sinconex_txt = r4
            java.lang.String r4 = "wv_c"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r6) goto L_0x0f37
            r4 = 1
            goto L_0x0f38
        L_0x0f37:
            r4 = 0
        L_0x0f38:
            r0.wv_cache = r4
            java.lang.String r4 = "rss_i"
            r6 = 0
            int r4 = r5.getInt(r4, r6)
            r0.rss_interv = r4
            java.lang.String r4 = "rss_t"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.rss_tit = r4
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0f53
            r0.rss_interv = r6
        L_0x0f53:
            stikerwap.appdys.alarma_rss r4 = new stikerwap.appdys.alarma_rss
            r4.<init>()
            android.content.Context r7 = r28.getApplicationContext()
            int r12 = r0.rss_interv
            r4.SetAlarm(r7, r12)
            java.lang.String r4 = "vfs"
            int r4 = r5.getInt(r4, r6)
            r7 = 1
            if (r4 != r7) goto L_0x0f6d
            r4 = 1
            goto L_0x0f6e
        L_0x0f6d:
            r4 = 0
        L_0x0f6e:
            r0.video_fs = r4
            java.lang.String r4 = "vls"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x0f7b
            r4 = 1
            goto L_0x0f7c
        L_0x0f7b:
            r4 = 0
        L_0x0f7c:
            r0.video_ls = r4
            java.lang.String r4 = "vc"
            int r4 = r5.getInt(r4, r6)
            if (r4 != r7) goto L_0x0f89
            r4 = 1
            goto L_0x0f8a
        L_0x0f89:
            r4 = 0
        L_0x0f8a:
            r0.video_cast = r4
            java.lang.String r4 = "vcv"
            int r4 = r5.getInt(r4, r6)
            r0.video_cast_v = r4
            java.lang.String r4 = "cr"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.cad_rep = r4
            java.lang.String r4 = "divisa"
            java.lang.String r4 = r5.getString(r4, r8)
            java.lang.String r6 = "puntoycoma"
            java.lang.String r7 = ";"
            java.lang.String r4 = r4.replace(r6, r7)
            r0.divisa = r4
            java.lang.String r4 = "busc_campos"
            java.lang.String r4 = r5.getString(r4, r8)
            java.lang.String r6 = ","
            java.lang.String[] r4 = r4.split(r6)
            int r7 = r4.length
            r12 = 4
            if (r7 != r12) goto L_0x100e
            r7 = 0
            r12 = r4[r7]
            boolean r7 = r12.equals(r11)
            r0.busc_texto = r7
            r7 = 1
            r12 = r4[r7]
            boolean r7 = r12.equals(r11)
            r0.busc_cat = r7
            r7 = r4[r10]
            boolean r7 = r7.equals(r11)
            r0.busc_precio = r7
            r7 = 3
            r4 = r4[r7]
            boolean r4 = r4.equals(r11)
            r0.busc_antiguedad = r4
            boolean r4 = r0.busc_cat
            if (r4 == 0) goto L_0x100e
            stikerwap.appdys.bd r4 = new stikerwap.appdys.bd     // Catch:{ Exception -> 0x100a }
            android.content.Context r7 = r28.getApplicationContext()     // Catch:{ Exception -> 0x100a }
            r4.<init>(r7)     // Catch:{ Exception -> 0x100a }
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x100a }
            if (r4 == 0) goto L_0x100e
            java.lang.String r7 = "SELECT _id FROM cats LIMIT 1"
            r12 = 0
            android.database.Cursor r7 = r4.rawQuery(r7, r12)     // Catch:{ Exception -> 0x100a }
            boolean r12 = r7.moveToFirst()     // Catch:{ Exception -> 0x100a }
            if (r12 != 0) goto L_0x1003
            r12 = 0
            r0.busc_cat = r12     // Catch:{ Exception -> 0x100a }
        L_0x1003:
            r7.close()     // Catch:{ Exception -> 0x100a }
            r4.close()     // Catch:{ Exception -> 0x100a }
            goto L_0x100e
        L_0x100a:
            r4 = 0
            r0.busc_cat = r4
            goto L_0x100f
        L_0x100e:
            r4 = 0
        L_0x100f:
            java.lang.String r7 = "busc_orden"
            java.lang.String r7 = r5.getString(r7, r8)
            java.lang.String[] r7 = r7.split(r6)
            int r12 = r7.length
            r14 = 3
            if (r12 != r14) goto L_0x1036
            r12 = r7[r4]
            boolean r4 = r12.equals(r11)
            r0.ord_texto = r4
            r4 = 1
            r12 = r7[r4]
            boolean r4 = r12.equals(r11)
            r0.ord_precio = r4
            r4 = r7[r10]
            boolean r4 = r4.equals(r11)
            r0.ord_antiguedad = r4
        L_0x1036:
            java.lang.String r4 = "busc_def"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.ord_def = r4
            java.lang.String r4 = "prods_tit"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.prods_tit = r4
            java.lang.String r4 = "prods_masinfo"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.prods_masinfo = r4
            java.lang.String r4 = "prods_comprar"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.prods_comprar = r4
            java.lang.String r4 = "prods_masinfo_mostrar"
            r7 = 1
            int r4 = r5.getInt(r4, r7)
            if (r4 != r7) goto L_0x1061
            r4 = 1
            goto L_0x1062
        L_0x1061:
            r4 = 0
        L_0x1062:
            r0.prods_masinfo_mostrar = r4
            java.lang.String r4 = "prods_linksexternos"
            int r4 = r5.getInt(r4, r7)
            if (r4 != r7) goto L_0x106e
            r4 = 1
            goto L_0x106f
        L_0x106e:
            r4 = 0
        L_0x106f:
            r0.prods_linksexternos = r4
            java.lang.String r4 = "prods_adaptar_ancho"
            int r4 = r5.getInt(r4, r7)
            if (r4 != r7) goto L_0x107b
            r4 = 1
            goto L_0x107c
        L_0x107b:
            r4 = 0
        L_0x107c:
            r0.prods_adaptar_ancho = r4
            java.lang.String r4 = "pp_email"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.pp_email = r4
            java.lang.String r4 = "pp_div"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.pp_divisa = r4
            java.lang.String r4 = "m_ncols"
            int r4 = r5.getInt(r4, r7)
            r0.menu_ncols = r4
            java.lang.String r4 = "m_padding"
            int r4 = r5.getInt(r4, r10)
            r0.menu_padding = r4
            java.lang.String r4 = "m_txt_radius"
            r12 = 5
            int r4 = r5.getInt(r4, r12)
            r0.menu_txt_radius = r4
            java.lang.String r4 = "m_mostrar_icos"
            int r4 = r5.getInt(r4, r7)
            if (r4 != 0) goto L_0x10b3
            r4 = 0
            r0.menu_mostrar_icos = r4
            goto L_0x10b6
        L_0x10b3:
            r4 = 0
            r0.menu_mostrar_icos = r7
        L_0x10b6:
            java.lang.String r12 = "m_mostrar_txt"
            int r12 = r5.getInt(r12, r7)
            if (r12 != 0) goto L_0x10c1
            r0.menu_mostrar_txt = r4
            goto L_0x10c3
        L_0x10c1:
            r0.menu_mostrar_txt = r7
        L_0x10c3:
            java.lang.String r12 = "m_icos_izq"
            int r12 = r5.getInt(r12, r7)
            if (r12 != 0) goto L_0x10ce
            r0.menu_icos_izq = r4
            goto L_0x10d0
        L_0x10ce:
            r0.menu_icos_izq = r7
        L_0x10d0:
            java.lang.String r12 = "m_anim"
            int r12 = r5.getInt(r12, r7)
            if (r12 != 0) goto L_0x10db
            r0.menu_anim = r4
            goto L_0x10dd
        L_0x10db:
            r0.menu_anim = r7
        L_0x10dd:
            java.lang.String r12 = "m_c"
            int r12 = r5.getInt(r12, r7)
            if (r12 != 0) goto L_0x10e8
            r0.menu_c = r4
            goto L_0x10ea
        L_0x10e8:
            r0.menu_c = r7
        L_0x10ea:
            java.lang.String r12 = "m_txt_c"
            int r12 = r5.getInt(r12, r7)
            if (r12 != 0) goto L_0x10f5
            r0.menu_txt_c = r4
            goto L_0x10f7
        L_0x10f5:
            r0.menu_txt_c = r7
        L_0x10f7:
            java.lang.String r12 = "m_txt_b"
            int r12 = r5.getInt(r12, r4)
            if (r12 != r7) goto L_0x1101
            r7 = 1
            goto L_0x1102
        L_0x1101:
            r7 = 0
        L_0x1102:
            r0.menu_txt_b = r7
            java.lang.String r7 = "m_e"
            int r7 = r5.getInt(r7, r4)
            r0.menu_estilo = r7
            java.lang.String r4 = "m_txt_bg"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.menu_txt_bg = r4
            java.lang.String r4 = "m_txt_col"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.menu_txt_col = r4
            java.lang.String r4 = "m_c1"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.menu_c1 = r4
            java.lang.String r4 = "m_c2"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.menu_c2 = r4
            java.lang.String r4 = "msl_c"
            java.lang.String r4 = r5.getString(r4, r8)
            r0.menusl_c = r4
            java.lang.String r4 = "fm"
            r7 = 0
            int r4 = r5.getInt(r4, r7)
            r12 = 1
            if (r4 != r12) goto L_0x1140
            r4 = 1
            goto L_0x1141
        L_0x1140:
            r4 = 0
        L_0x1141:
            r0.t_fondomenu = r4
            java.lang.String r4 = "act_fm"
            boolean r4 = r5.getBoolean(r4, r7)
            r0.act_fondomenu = r4
            java.lang.String r4 = "vf"
            int r4 = r5.getInt(r4, r7)
            r0.v_fondomenu = r4
            r0.margen_fondomenu = r7
            r0.tipo_fondomenu = r7
            java.lang.String r4 = "tm"
            java.lang.String r4 = r5.getString(r4, r8)
            boolean r12 = r4.equals(r8)
            if (r12 != 0) goto L_0x117a
            r12 = 1
            java.lang.String r14 = r4.substring(r7, r12)
            boolean r7 = r14.equals(r11)
            r0.margen_fondomenu = r7
            java.lang.String r4 = r4.substring(r12, r10)
            int r4 = java.lang.Integer.parseInt(r4)
            r0.tipo_fondomenu = r4
        L_0x117a:
            int r4 = r1.length
            stikerwap.appdys.Seccion[] r4 = new stikerwap.appdys.Seccion[r4]
            r0.secciones_a = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            secciones_alist = r4
            int r4 = r1.length
            int[] r4 = new int[r4]
            r0.menu_a_secciones = r4
            java.lang.String r4 = "s"
            if (r3 == 0) goto L_0x11a2
            java.lang.String r12 = "abrir_idsecc"
            java.lang.String r12 = r3.getString(r12)
            if (r12 == 0) goto L_0x11a2
            java.lang.String r12 = "abrir_idsecc"
            java.lang.String r3 = r3.getString(r12)
        L_0x119d:
            r7 = 9996(0x270c, float:1.4007E-41)
        L_0x119f:
            r10 = 0
            goto L_0x12ff
        L_0x11a2:
            if (r3 == 0) goto L_0x11bf
            java.lang.String r12 = "notif_id"
            java.lang.String r12 = r3.getString(r12)
            if (r12 == 0) goto L_0x11bf
            java.lang.String r12 = "notif_tipo"
            java.lang.String r12 = r3.getString(r12)
            boolean r12 = r12.equals(r11)
            if (r12 == 0) goto L_0x11bf
            java.lang.String r12 = "notif_idelem"
            java.lang.String r3 = r3.getString(r12)
            goto L_0x119d
        L_0x11bf:
            if (r3 == 0) goto L_0x11ef
            java.lang.String r12 = "notif_idtema"
            java.lang.String r12 = r3.getString(r12)
            if (r12 == 0) goto L_0x11ef
            r12 = 0
        L_0x11ca:
            int r14 = r1.length
            if (r12 >= r14) goto L_0x11e5
            java.lang.String r14 = "notif_idsecc"
            java.lang.String r14 = r3.getString(r14)
            r15 = r1[r12]
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x11e2
            java.lang.String r12 = "notif_idsecc"
            java.lang.String r3 = r3.getString(r12)
            goto L_0x11e6
        L_0x11e2:
            int r12 = r12 + 1
            goto L_0x11ca
        L_0x11e5:
            r3 = r8
        L_0x11e6:
            boolean r12 = r3.equals(r8)
            if (r12 == 0) goto L_0x119d
        L_0x11ec:
            r7 = 9997(0x270d, float:1.4009E-41)
            goto L_0x119f
        L_0x11ef:
            if (r3 == 0) goto L_0x1243
            java.lang.String r12 = "id_remit"
            java.lang.String r12 = r3.getString(r12)
            if (r12 == 0) goto L_0x1243
            r3 = 0
        L_0x11fa:
            int r12 = r1.length
            if (r3 >= r12) goto L_0x123b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r4)
            r14 = r1[r3]
            r12.append(r14)
            java.lang.String r14 = "_tipo"
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            r14 = 0
            int r12 = r5.getInt(r12, r14)
            r14 = 9
            if (r12 != r14) goto L_0x1238
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "chat"
            r12.<init>(r14)
            r14 = r1[r3]
            r12.append(r14)
            java.lang.String r14 = "_validado"
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            r14 = 1
            boolean r12 = r5.getBoolean(r12, r14)
            if (r12 == 0) goto L_0x1238
            r3 = r1[r3]
            goto L_0x123c
        L_0x1238:
            int r3 = r3 + 1
            goto L_0x11fa
        L_0x123b:
            r3 = r8
        L_0x123c:
            boolean r12 = r3.equals(r8)
            if (r12 == 0) goto L_0x119d
            goto L_0x11ec
        L_0x1243:
            if (r3 == 0) goto L_0x12fc
            java.lang.String r12 = "abrir_perfil"
            java.lang.String r12 = r3.getString(r12)
            if (r12 == 0) goto L_0x12fc
            java.lang.String r12 = "abrir_game"
            java.lang.String r3 = r3.getString(r12)
            if (r3 == 0) goto L_0x1257
            r3 = 1
            goto L_0x1258
        L_0x1257:
            r3 = 0
        L_0x1258:
            r12 = r8
        L_0x1259:
            r14 = 1
            if (r3 > r14) goto L_0x12f3
            r14 = 0
        L_0x125d:
            int r15 = r1.length
            if (r14 >= r15) goto L_0x12e7
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r4)
            r7 = r1[r14]
            r15.append(r7)
            java.lang.String r7 = "_tipo"
            r15.append(r7)
            java.lang.String r7 = r15.toString()
            r15 = 0
            int r7 = r5.getInt(r7, r15)
            if (r3 != 0) goto L_0x12a6
            r15 = 9
            if (r7 != r15) goto L_0x129a
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r10 = "chat"
            r15.<init>(r10)
            r10 = r1[r14]
            r15.append(r10)
            java.lang.String r10 = "_validado"
            r15.append(r10)
            java.lang.String r10 = r15.toString()
            r15 = 1
            boolean r10 = r5.getBoolean(r10, r15)
            if (r10 != 0) goto L_0x12df
        L_0x129a:
            r10 = 10
            if (r7 == r10) goto L_0x12df
            r10 = 11
            if (r7 == r10) goto L_0x12df
            r10 = 16
            if (r7 == r10) goto L_0x12df
        L_0x12a6:
            r10 = 1
            if (r3 != r10) goto L_0x12e2
            if (r7 != r10) goto L_0x12e2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r15 = r1[r14]
            r7.append(r15)
            java.lang.String r15 = "_cl"
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r15 = 0
            int r7 = r5.getInt(r7, r15)
            if (r7 != r10) goto L_0x12e2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r10 = r1[r14]
            r7.append(r10)
            java.lang.String r10 = "_cp"
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            int r7 = r5.getInt(r7, r15)
            r10 = 1
            if (r7 != r10) goto L_0x12e2
        L_0x12df:
            r12 = r1[r14]
            goto L_0x12e7
        L_0x12e2:
            int r14 = r14 + 1
            r10 = 2
            goto L_0x125d
        L_0x12e7:
            boolean r7 = r12.equals(r8)
            if (r7 != 0) goto L_0x12ee
            goto L_0x12f3
        L_0x12ee:
            int r3 = r3 + 1
            r10 = 2
            goto L_0x1259
        L_0x12f3:
            r3 = r12
            boolean r7 = r3.equals(r8)
            if (r7 == 0) goto L_0x119d
            goto L_0x11ec
        L_0x12fc:
            r3 = r8
            goto L_0x119d
        L_0x12ff:
            r0.nsecc_visibles = r10
            r0.icos_pendientes = r10
            r0.hay_icosmenu = r10
            r12 = 0
            r14 = 0
        L_0x1307:
            int r15 = r1.length
            java.lang.String r10 = "_ord"
            if (r12 >= r15) goto L_0x2630
            r15 = r1[r12]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r15)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r1 = 0
            int r2 = r5.getInt(r2, r1)
            r1 = 1
            int r2 = r2 - r1
            boolean r1 = r3.equals(r8)
            if (r1 == 0) goto L_0x134f
            r1 = 9997(0x270d, float:1.4009E-41)
            if (r7 == r1) goto L_0x134f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            r1.append(r15)
            r19 = r12
            java.lang.String r12 = "_ocu"
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r12 = 0
            int r1 = r5.getInt(r1, r12)
            r12 = 1
            if (r1 == r12) goto L_0x1358
            int r1 = java.lang.Math.min(r7, r2)
            r7 = r1
            goto L_0x1358
        L_0x134f:
            r19 = r12
            boolean r1 = r3.equals(r15)
            if (r1 == 0) goto L_0x1358
            r7 = r2
        L_0x1358:
            stikerwap.appdys.Seccion r1 = new stikerwap.appdys.Seccion
            r1.<init>()
            int r12 = java.lang.Integer.parseInt(r15)
            r1.id = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r4)
            r12.append(r15)
            r31 = r3
            java.lang.String r3 = "_tipo"
            r12.append(r3)
            java.lang.String r3 = r12.toString()
            r12 = 0
            int r3 = r5.getInt(r3, r12)
            r1.tipo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_tit"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.titulo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_de"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.descr = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_k"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            java.lang.String r3 = r3.trim()
            boolean r12 = r3.equals(r8)
            if (r12 != 0) goto L_0x13fa
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r1.kw = r12
            java.lang.String[] r3 = r3.split(r6)
            int r12 = r3.length
            r20 = r7
            r7 = 0
        L_0x13d9:
            if (r7 >= r12) goto L_0x13fc
            r21 = r3[r7]
            r22 = r3
            java.lang.String r3 = r21.trim()
            boolean r21 = r3.equals(r8)
            if (r21 != 0) goto L_0x13f1
            r21 = r12
            java.util.ArrayList<java.lang.String> r12 = r1.kw
            r12.add(r3)
            goto L_0x13f3
        L_0x13f1:
            r21 = r12
        L_0x13f3:
            int r7 = r7 + 1
            r12 = r21
            r3 = r22
            goto L_0x13d9
        L_0x13fa:
            r20 = r7
        L_0x13fc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_i"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r7 = "110"
            java.lang.String r3 = r5.getString(r3, r7)
            r21 = r14
            r7 = 0
            r12 = 1
            java.lang.String r14 = r3.substring(r7, r12)
            boolean r7 = r14.equals(r11)
            r1.search_incluir = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r7.append(r15)
            java.lang.String r12 = "_idgo"
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r5.getString(r7, r8)
            r1.idgo = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r7.append(r15)
            java.lang.String r12 = "_ocu"
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            r12 = 0
            int r7 = r5.getInt(r7, r12)
            r14 = 1
            if (r7 != r14) goto L_0x1454
            r1.oculta = r14
            goto L_0x145f
        L_0x1454:
            r1.oculta = r12
            int r7 = r0.nsecc_visibles
            r1.ind_menu = r7
            int r7 = r0.nsecc_visibles
            int r7 = r7 + r14
            r0.nsecc_visibles = r7
        L_0x145f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r7.append(r15)
            java.lang.String r12 = "_ptit"
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r5.getString(r7, r8)
            r1.popup_tit = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r7.append(r15)
            java.lang.String r12 = "_ptxt"
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r5.getString(r7, r8)
            r1.popup_txt = r7
            int r7 = r3.length()
            r12 = 1
            if (r7 <= r12) goto L_0x149a
            r7 = 2
            java.lang.String r14 = r3.substring(r12, r7)
            goto L_0x149b
        L_0x149a:
            r14 = r11
        L_0x149b:
            r1.popup_nomas_mostrar = r12
            r7 = 0
            r1.popup_nomas_def = r7
            boolean r17 = r14.equals(r9)
            if (r17 == 0) goto L_0x14a9
            r1.popup_nomas_mostrar = r7
            goto L_0x14b4
        L_0x14a9:
            java.lang.String r7 = "2"
            boolean r7 = r14.equals(r7)
            if (r7 == 0) goto L_0x14b3
            r1.popup_nomas_def = r12
        L_0x14b3:
            r7 = 0
        L_0x14b4:
            r1.depago = r7
            int r7 = r3.length()
            r12 = 2
            if (r7 <= r12) goto L_0x14c8
            r7 = 3
            java.lang.String r3 = r3.substring(r12, r7)
            boolean r3 = r3.equals(r11)
            r1.depago = r3
        L_0x14c8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_tp"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r1.tipo_player = r3
            int r3 = r1.tipo
            r7 = 6
            if (r3 != r7) goto L_0x15e8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_pl"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.playlist = r3
            java.lang.String r3 = r1.playlist
            java.lang.String r7 = "@CCORCH@"
            java.lang.String r12 = "]"
            java.lang.String r3 = r3.replace(r7, r12)
            r1.playlist = r3
            java.lang.String r3 = r1.playlist
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x15a3
            java.lang.String r3 = r1.playlist
            java.lang.String r7 = "@y@"
            boolean r3 = r3.startsWith(r7)
            if (r3 == 0) goto L_0x15a3
            java.lang.String r3 = r0.cad_rep
            if (r3 == 0) goto L_0x15a3
            int r3 = r3.length()
            r7 = 85
            if (r3 != r7) goto L_0x15a3
            java.lang.String r3 = r1.playlist
            r7 = 3
            java.lang.String r3 = r3.substring(r7)
            r1.playlist = r3
            r7 = r8
            r3 = 0
        L_0x1531:
            java.lang.String r12 = r1.playlist
            int r12 = r12.length()
            if (r3 >= r12) goto L_0x156e
            java.lang.String r12 = r1.playlist
            int r14 = r3 + 1
            java.lang.String r3 = r12.substring(r3, r14)
            java.lang.String r12 = r0.cad_rep
            int r12 = r12.indexOf(r3)
            r22 = r3
            r3 = -1
            if (r12 == r3) goto L_0x1557
            int r3 = r12 + 1
            r23 = r9
            java.lang.String r9 = " !#$%&()+,-./023456789:;<=>?ABCDEFGHIJKLMNOPQRSTUVWXYZ[^_abcdefghijklmnopqrstuvwxz{}~"
            java.lang.String r3 = r9.substring(r12, r3)
            goto L_0x155b
        L_0x1557:
            r23 = r9
            r3 = r22
        L_0x155b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r3)
            java.lang.String r7 = r9.toString()
            r3 = r14
            r9 = r23
            goto L_0x1531
        L_0x156e:
            r23 = r9
            r1.playlist = r7
            java.lang.String r3 = r1.playlist
            java.lang.String r7 = "@yy1111@"
            java.lang.String r9 = "https://"
            java.lang.String r3 = r3.replace(r7, r9)
            r1.playlist = r3
            java.lang.String r3 = r1.playlist
            java.lang.String r7 = "@yy111@"
            java.lang.String r9 = "https://www."
            java.lang.String r3 = r3.replace(r7, r9)
            r1.playlist = r3
            java.lang.String r3 = r1.playlist
            java.lang.String r7 = "@yy11@"
            java.lang.String r9 = "http://"
            java.lang.String r3 = r3.replace(r7, r9)
            r1.playlist = r3
            java.lang.String r3 = r1.playlist
            java.lang.String r7 = "@yy1@"
            java.lang.String r9 = "http://www."
            java.lang.String r3 = r3.replace(r7, r9)
            r1.playlist = r3
            goto L_0x15a5
        L_0x15a3:
            r23 = r9
        L_0x15a5:
            r3 = 0
            r1.headers = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_h"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r7 = r3.equals(r8)
            if (r7 != 0) goto L_0x15ea
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r1.headers = r7
            java.lang.String r7 = "@@Y@@"
            java.lang.String[] r3 = r3.split(r7)
            r7 = 0
        L_0x15d1:
            int r9 = r3.length
            if (r7 >= r9) goto L_0x15ea
            r9 = r3[r7]
            java.lang.String r12 = "@@X@@"
            java.lang.String[] r9 = r9.split(r12)
            int r12 = r9.length
            r14 = 2
            if (r12 != r14) goto L_0x15e5
            java.util.List<java.lang.String[]> r12 = r1.headers
            r12.add(r9)
        L_0x15e5:
            int r7 = r7 + 1
            goto L_0x15d1
        L_0x15e8:
            r23 = r9
        L_0x15ea:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_r"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x1605
            r3 = 1
            goto L_0x1606
        L_0x1605:
            r3 = 0
        L_0x1606:
            r1.rewarded = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_d"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r9) goto L_0x1621
            r3 = 1
            goto L_0x1622
        L_0x1621:
            r3 = 0
        L_0x1622:
            r1.descargar = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_r_m"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.radio_mostrar = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_ext"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.linksexternos = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_adapt"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x166d
            r1.adaptar_ancho = r9
            goto L_0x166f
        L_0x166d:
            r1.adaptar_ancho = r7
        L_0x166f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_stream"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r9) goto L_0x1689
            r1.stream = r9
            goto L_0x168b
        L_0x1689:
            r1.stream = r7
        L_0x168b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_idfondo"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.idfondo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_vf"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.vfondo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fondo_modif"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x16d4
            r1.fondo_modif = r9
            goto L_0x16d6
        L_0x16d4:
            r1.fondo_modif = r7
        L_0x16d6:
            r1.fondo_margen = r7
            r1.fondo_tipo = r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_tm"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r9 = r3.equals(r8)
            if (r9 != 0) goto L_0x170b
            r9 = 1
            java.lang.String r12 = r3.substring(r7, r9)
            boolean r7 = r12.equals(r11)
            r1.fondo_margen = r7
            r7 = 2
            java.lang.String r3 = r3.substring(r9, r7)
            int r3 = java.lang.Integer.parseInt(r3)
            r1.fondo_tipo = r3
        L_0x170b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_url"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.url = r3
            int r3 = r1.tipo
            r7 = 6
            if (r3 != r7) goto L_0x17b4
            java.lang.String r3 = r1.url
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x17b4
            java.lang.String r3 = r1.url
            java.lang.String r7 = "@y@"
            boolean r3 = r3.startsWith(r7)
            if (r3 == 0) goto L_0x17b4
            java.lang.String r3 = r0.cad_rep
            if (r3 == 0) goto L_0x17b4
            int r3 = r3.length()
            r7 = 85
            if (r3 != r7) goto L_0x17b4
            java.lang.String r3 = r1.url
            r7 = 3
            java.lang.String r3 = r3.substring(r7)
            r1.url = r3
            r7 = r8
            r3 = 0
        L_0x1750:
            java.lang.String r9 = r1.url
            int r9 = r9.length()
            if (r3 >= r9) goto L_0x1782
            java.lang.String r9 = r1.url
            int r12 = r3 + 1
            java.lang.String r3 = r9.substring(r3, r12)
            java.lang.String r9 = r0.cad_rep
            int r9 = r9.indexOf(r3)
            r14 = -1
            if (r9 == r14) goto L_0x1771
            int r3 = r9 + 1
            java.lang.String r14 = " !#$%&()+,-./023456789:;<=>?ABCDEFGHIJKLMNOPQRSTUVWXYZ[^_abcdefghijklmnopqrstuvwxz{}~"
            java.lang.String r3 = r14.substring(r9, r3)
        L_0x1771:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r3)
            java.lang.String r7 = r9.toString()
            r3 = r12
            goto L_0x1750
        L_0x1782:
            r1.url = r7
            java.lang.String r3 = r1.url
            java.lang.String r7 = "@yy1111@"
            java.lang.String r9 = "https://"
            java.lang.String r3 = r3.replace(r7, r9)
            r1.url = r3
            java.lang.String r3 = r1.url
            java.lang.String r7 = "@yy111@"
            java.lang.String r9 = "https://www."
            java.lang.String r3 = r3.replace(r7, r9)
            r1.url = r3
            java.lang.String r3 = r1.url
            java.lang.String r7 = "@yy11@"
            java.lang.String r9 = "http://"
            java.lang.String r3 = r3.replace(r7, r9)
            r1.url = r3
            java.lang.String r3 = r1.url
            java.lang.String r7 = "@yy1@"
            java.lang.String r9 = "http://www."
            java.lang.String r3 = r3.replace(r7, r9)
            r1.url = r3
        L_0x17b4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_ua"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.ua = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_html"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.html = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_pur"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x17fd
            r1.puroHTML = r7
            goto L_0x1800
        L_0x17fd:
            r3 = 0
            r1.puroHTML = r3
        L_0x1800:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_loa"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x181b
            r1.loader = r7
            r3 = 0
            goto L_0x181e
        L_0x181b:
            r3 = 0
            r1.loader = r3
        L_0x181e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r4)
            r9.append(r15)
            java.lang.String r12 = "_zoo"
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            int r9 = r5.getInt(r9, r3)
            if (r9 != r7) goto L_0x1838
            r1.zoom = r7
            goto L_0x183a
        L_0x1838:
            r1.zoom = r3
        L_0x183a:
            r1.pulltorefresh = r3
            int r3 = r1.tipo
            if (r3 != r7) goto L_0x1867
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_i1"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r9 = r3.equals(r8)
            if (r9 != 0) goto L_0x1893
            r9 = 0
            java.lang.String r3 = r3.substring(r9, r7)
            boolean r3 = r3.equals(r11)
            r1.pulltorefresh = r3
            goto L_0x1893
        L_0x1867:
            int r3 = r1.tipo
            r7 = 2
            if (r3 != r7) goto L_0x1893
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_i2"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r7 = r3.equals(r8)
            if (r7 != 0) goto L_0x1893
            r7 = 0
            r9 = 1
            java.lang.String r3 = r3.substring(r7, r9)
            boolean r3 = r3.equals(r11)
            r1.pulltorefresh = r3
        L_0x1893:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_c1"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.c1 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_c2"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.c2 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_c_peritem"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r1.c_peritem = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_c_tit"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.c_tit = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_c_fecha"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.c_fecha = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_mostrar_img"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1922
            r1.mostrar_img = r7
            goto L_0x1925
        L_0x1922:
            r3 = 0
            r1.mostrar_img = r3
        L_0x1925:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_mostrar_fecha"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1940
            r1.mostrar_fecha = r7
            r3 = 0
            goto L_0x1943
        L_0x1940:
            r3 = 0
            r1.mostrar_fecha = r3
        L_0x1943:
            int r7 = r1.tipo
            r9 = 7
            if (r7 != r9) goto L_0x195f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r7.append(r15)
            java.lang.String r9 = "_vin"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            int r7 = r5.getInt(r7, r3)
            r1.v_img_notif = r7
        L_0x195f:
            int r3 = r1.tipo
            r7 = 6
            if (r3 == r7) goto L_0x1a35
            int r3 = r1.tipo
            r7 = 7
            if (r3 != r7) goto L_0x196b
            goto L_0x1a35
        L_0x196b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_f_perfil"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r1.fotos_perfil = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fnac"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.p_fnac = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_sexo"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.p_sexo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_descr"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.p_descr = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_dist"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.p_dist = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_com"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x19f9
            r3 = 1
            goto L_0x19fa
        L_0x19f9:
            r3 = 0
        L_0x19fa:
            r1.coments = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_gal"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1a15
            r3 = 1
            goto L_0x1a16
        L_0x1a15:
            r3 = 0
        L_0x1a16:
            r1.galeria = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_priv"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1a31
            r3 = 1
            goto L_0x1a32
        L_0x1a31:
            r3 = 0
        L_0x1a32:
            r1.privados = r3
            goto L_0x1a55
        L_0x1a35:
            int r3 = r0.chatsecc_fotos_perfil
            r1.fotos_perfil = r3
            int r3 = r0.chatsecc_p_fnac
            r1.p_fnac = r3
            int r3 = r0.chatsecc_p_sexo
            r1.p_sexo = r3
            int r3 = r0.chatsecc_p_descr
            r1.p_descr = r3
            int r3 = r0.chatsecc_p_dist
            r1.p_dist = r3
            boolean r3 = r0.chatsecc_coments
            r1.coments = r3
            boolean r3 = r0.chatsecc_galeria
            r1.galeria = r3
            boolean r3 = r0.chatsecc_privados
            r1.privados = r3
        L_0x1a55:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_fdist"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1a6f
            r3 = 1
            goto L_0x1a70
        L_0x1a6f:
            r3 = 0
        L_0x1a70:
            r1.fdist = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fsexo"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1a8b
            r3 = 1
            goto L_0x1a8c
        L_0x1a8b:
            r3 = 0
        L_0x1a8c:
            r1.fsexo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fn"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1aa7
            r3 = 1
            goto L_0x1aa8
        L_0x1aa7:
            r3 = 0
        L_0x1aa8:
            r1.fnick = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fedad1"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1ac3
            r3 = 1
            goto L_0x1ac4
        L_0x1ac3:
            r3 = 0
        L_0x1ac4:
            r1.fedad1 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fedad2"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1adf
            r3 = 1
            goto L_0x1ae0
        L_0x1adf:
            r3 = 0
        L_0x1ae0:
            r1.fedad2 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_fdist_d"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r1.fdist_def = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fsexo_d"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.fsexo_def = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fedad1_d"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.fedad1_def = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_fedad2_d"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.fedad2_def = r3
            int r3 = r1.tipo
            r7 = 16
            if (r3 != r7) goto L_0x1d05
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_fdist"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            if (r3 != r7) goto L_0x1b5f
            r3 = 1
            goto L_0x1b60
        L_0x1b5f:
            r3 = 0
        L_0x1b60:
            r1.ftipo_dist = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_i16"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r7 = "1111110111101"
            java.lang.String r3 = r5.getString(r3, r7)
            r7 = 0
            r9 = 1
            java.lang.String r12 = r3.substring(r7, r9)
            boolean r7 = r12.equals(r11)
            r1.ftipo_maspuntuados = r7
            r7 = 2
            java.lang.String r12 = r3.substring(r9, r7)
            boolean r9 = r12.equals(r11)
            r1.ftipo_masvistos = r9
            r9 = 3
            java.lang.String r12 = r3.substring(r7, r9)
            boolean r7 = r12.equals(r11)
            r1.ftipo_destacados = r7
            r7 = 4
            java.lang.String r12 = r3.substring(r9, r7)
            boolean r9 = r12.equals(r11)
            r1.ftipo_favoritos = r9
            r9 = 5
            java.lang.String r12 = r3.substring(r7, r9)
            boolean r7 = r12.equals(r11)
            r1.ftipo_ultimos = r7
            r12 = 6
            java.lang.String r7 = r3.substring(r9, r12)
            int r7 = java.lang.Integer.parseInt(r7)
            r1.ftipo_def = r7
            r9 = 7
            java.lang.String r7 = r3.substring(r12, r9)
            boolean r7 = r7.equals(r11)
            r1.req_aprob = r7
            r14 = 8
            java.lang.String r7 = r3.substring(r9, r14)
            int r7 = java.lang.Integer.parseInt(r7)
            r1.pos_coments = r7
            r7 = 9
            java.lang.String r9 = r3.substring(r14, r7)
            boolean r9 = r9.equals(r11)
            r1.mostrar_descr = r9
            r9 = 10
            java.lang.String r12 = r3.substring(r7, r9)
            boolean r12 = r12.equals(r11)
            r1.mostrar_nombre = r12
            r12 = 11
            java.lang.String r7 = r3.substring(r9, r12)
            boolean r7 = r7.equals(r11)
            r1.mostrar_fecha = r7
            r7 = 12
            java.lang.String r16 = r3.substring(r12, r7)
            int r9 = java.lang.Integer.parseInt(r16)
            r1.formato = r9
            r9 = 13
            java.lang.String r3 = r3.substring(r7, r9)
            boolean r3 = r3.equals(r11)
            r1.mostrar_videosdeusu = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_di"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_dist = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_mp"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_maspuntuados = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_mv"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_masvistos = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_de"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_destacados = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_fa"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_favoritos = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_ul"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_ultimos = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_t_pr"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_propios = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_cats"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            java.lang.String[] r3 = r3.split(r13)
            int r9 = r3.length
            stikerwap.appdys.Cat_buscvideo[] r9 = new stikerwap.appdys.Cat_buscvideo[r9]
            r1.cats_buscvideo_a = r9
            r9 = 0
        L_0x1ccf:
            int r7 = r3.length
            if (r9 >= r7) goto L_0x1d05
            stikerwap.appdys.Cat_buscvideo r7 = new stikerwap.appdys.Cat_buscvideo
            r7.<init>()
            r12 = r3[r9]
            java.lang.String r14 = ";"
            java.lang.String[] r12 = r12.split(r14)
            r14 = 0
            r22 = r12[r14]
            int r14 = java.lang.Integer.parseInt(r22)
            r7.id = r14
            r22 = r3
            r14 = 1
            r3 = r12[r14]
            boolean r3 = r3.equals(r11)
            r7.soloadmin = r3
            r3 = 2
            r12 = r12[r3]
            r7.descr = r12
            stikerwap.appdys.Cat_buscvideo[] r3 = r1.cats_buscvideo_a
            r3[r9] = r7
            int r9 = r9 + 1
            r3 = r22
            r12 = 11
            r14 = 8
            goto L_0x1ccf
        L_0x1d05:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_f_chat"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r1.fotos_chat = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_accext"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x1d37
            r3 = 1
            goto L_0x1d38
        L_0x1d37:
            r3 = 0
        L_0x1d38:
            r1.acceso_a_externo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_cat"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.idcat = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_sub"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.idsubcat = r3
            int r3 = r1.tipo
            r9 = 14
            if (r3 != r9) goto L_0x1d85
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_v"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.v = r3
        L_0x1d85:
            int r3 = r1.tipo
            r7 = 1
            if (r3 != r7) goto L_0x1e1b
            java.lang.String r3 = r1.url
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "games."
            r7.<init>(r9)
            java.lang.String r9 = DOM_EDROID
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            boolean r3 = r3.contains(r7)
            if (r3 != 0) goto L_0x1dca
            java.lang.String r3 = r1.url
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "quiz."
            r7.<init>(r9)
            java.lang.String r9 = DOM_EDROID
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            boolean r3 = r3.contains(r7)
            if (r3 != 0) goto L_0x1dca
            java.lang.String r3 = r1.url
            java.lang.String r7 = "pixworld.io-desdeac"
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto L_0x1e1b
        L_0x1dca:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_idg"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.idgame = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_cl"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x1dfc
            r3 = 1
            goto L_0x1dfd
        L_0x1dfc:
            r3 = 0
        L_0x1dfd:
            r1.con_login = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_cp"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r9) goto L_0x1e18
            r3 = 1
            goto L_0x1e19
        L_0x1e18:
            r3 = 0
        L_0x1e19:
            r1.con_punt = r3
        L_0x1e1b:
            int r3 = r1.tipo
            r7 = 19
            if (r3 != r7) goto L_0x1e3f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_iw"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r7 = 1
            if (r3 != r7) goto L_0x1e3c
            r3 = 1
            goto L_0x1e3d
        L_0x1e3c:
            r3 = 0
        L_0x1e3d:
            r1.ico_widget = r3
        L_0x1e3f:
            int r3 = r1.tipo
            r7 = 13
            if (r3 != r7) goto L_0x1e7f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_st"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x1e60
            r3 = 1
            goto L_0x1e61
        L_0x1e60:
            r3 = 0
        L_0x1e61:
            r1.stickers = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_sta"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r9) goto L_0x1e7c
            r3 = 1
            goto L_0x1e7d
        L_0x1e7c:
            r3 = 0
        L_0x1e7d:
            r1.stickers_anim = r3
        L_0x1e7f:
            int r3 = r1.tipo
            r7 = 20
            if (r3 != r7) goto L_0x1ef2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_ad"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x1ea0
            r3 = 1
            goto L_0x1ea1
        L_0x1ea0:
            r3 = 0
        L_0x1ea1:
            r1.abrir_directo = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_mc"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r9) goto L_0x1ebc
            r3 = 1
            goto L_0x1ebd
        L_0x1ebc:
            r3 = 0
        L_0x1ebd:
            r1.mostrar_compartir = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r12 = "_tv"
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != r9) goto L_0x1ed8
            r3 = 1
            goto L_0x1ed9
        L_0x1ed8:
            r3 = 0
        L_0x1ed9:
            r1.t_visor = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_cv"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.c_visor = r3
        L_0x1ef2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_ncols"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            r1.ncols = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_padding"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 2
            int r3 = r5.getInt(r3, r7)
            r1.padding = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_txt_radius"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 5
            int r3 = r5.getInt(r3, r7)
            r1.txt_radius = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_mostrar_icos"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 1
            int r3 = r5.getInt(r3, r7)
            if (r3 != 0) goto L_0x1f56
            r3 = 0
            r1.mostrar_icos = r3
            goto L_0x1f58
        L_0x1f56:
            r1.mostrar_icos = r7
        L_0x1f58:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_mostrar_txt"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != 0) goto L_0x1f73
            r3 = 0
            r1.mostrar_txt = r3
            goto L_0x1f75
        L_0x1f73:
            r1.mostrar_txt = r7
        L_0x1f75:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_icos_izq"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != 0) goto L_0x1f90
            r3 = 0
            r1.icos_izq = r3
            goto L_0x1f92
        L_0x1f90:
            r1.icos_izq = r7
        L_0x1f92:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_anim"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != 0) goto L_0x1fad
            r3 = 0
            r1.anim = r3
            goto L_0x1faf
        L_0x1fad:
            r1.anim = r7
        L_0x1faf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_c"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != 0) goto L_0x1fca
            r3 = 0
            r1.c = r3
            goto L_0x1fcc
        L_0x1fca:
            r1.c = r7
        L_0x1fcc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_txt_c"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            if (r3 != 0) goto L_0x1fe7
            r3 = 0
            r1.txt_c = r3
            goto L_0x1fea
        L_0x1fe7:
            r3 = 0
            r1.txt_c = r7
        L_0x1fea:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r4)
            r9.append(r15)
            java.lang.String r12 = "_txt_b"
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            int r9 = r5.getInt(r9, r3)
            if (r9 != r7) goto L_0x2003
            r7 = 1
            goto L_0x2004
        L_0x2003:
            r7 = 0
        L_0x2004:
            r1.txt_b = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            r7.append(r15)
            java.lang.String r9 = "_e"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            int r7 = r5.getInt(r7, r3)
            r1.estilo = r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_txt_bg"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_bg = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_txt_col"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.txt_col = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_seccs"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r1.seccs = r3
            int r3 = r1.tipo
            r7 = 22
            if (r3 != r7) goto L_0x209a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_incl"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r7 = r3.equals(r8)
            if (r7 != 0) goto L_0x209a
            r7 = 0
            r9 = 1
            java.lang.String r12 = r3.substring(r7, r9)
            boolean r7 = r12.equals(r11)
            r1.incl_submenu = r7
            r7 = 2
            java.lang.String r3 = r3.substring(r9, r7)
            boolean r3 = r3.equals(r11)
            r1.incl_card = r3
        L_0x209a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_ico_id"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r7 = 0
            int r3 = r5.getInt(r3, r7)
            r1.ico_id = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_v_ico"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.v_ico = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_w_ico"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.w_ico = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_h_ico"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r1.h_ico = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r9 = "_ico"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r5.getInt(r3, r7)
            r9 = 1
            if (r3 != r9) goto L_0x211c
            r1.ico_cargando = r9
            r1.ico_mostrado = r7
            boolean r3 = r1.oculta
            if (r3 != 0) goto L_0x2152
            r0.icos_pendientes = r9
            r0.hay_icosmenu = r9
            goto L_0x2152
        L_0x211c:
            r1.ico_cargando = r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            r3.<init>()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            java.lang.String r7 = "img_s"
            r3.append(r7)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            r3.append(r15)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            java.lang.String r7 = "_ico"
            r3.append(r7)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            java.io.FileInputStream r3 = r0.openFileInput(r3)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            java.io.FileDescriptor r7 = r3.getFD()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFileDescriptor(r7)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            r1.ico = r7     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            r3.close()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x2146 }
            goto L_0x2147
        L_0x2146:
        L_0x2147:
            android.graphics.Bitmap r3 = r1.ico
            if (r3 == 0) goto L_0x2152
            boolean r3 = r1.oculta
            if (r3 != 0) goto L_0x2152
            r3 = 1
            r0.hay_icosmenu = r3
        L_0x2152:
            int r3 = r1.tipo
            r9 = 5
            if (r3 != r9) goto L_0x215a
            r0.ind_secc_buscador = r2
            goto L_0x2161
        L_0x215a:
            int r3 = r1.tipo
            r7 = 4
            if (r3 != r7) goto L_0x2161
            r0.ind_secc_ofics = r2
        L_0x2161:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_idtemas"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r7 = r3.equals(r8)
            if (r7 != 0) goto L_0x219d
            java.lang.String[] r3 = r3.split(r6)
            int r7 = r3.length
            stikerwap.appdys.Tema[] r7 = new stikerwap.appdys.Tema[r7]
            r1.temas_a = r7
            r7 = 0
        L_0x2186:
            int r12 = r3.length
            if (r7 >= r12) goto L_0x219d
            r12 = r3[r7]
            stikerwap.appdys.Tema r14 = new stikerwap.appdys.Tema
            r14.<init>()
            int r12 = java.lang.Integer.parseInt(r12)
            r14.id = r12
            stikerwap.appdys.Tema[] r12 = r1.temas_a
            r12[r7] = r14
            int r7 = r7 + 1
            goto L_0x2186
        L_0x219d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r15)
            java.lang.String r7 = "_iditems"
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r7 = r3.equals(r8)
            if (r7 != 0) goto L_0x25f9
            java.lang.String[] r3 = r3.split(r6)
            int r7 = r3.length
            stikerwap.appdys.AndItem[] r7 = new stikerwap.appdys.AndItem[r7]
            r1.and_items_a = r7
            r7 = 0
        L_0x21c2:
            int r12 = r3.length
            if (r7 >= r12) goto L_0x25f9
            r12 = r3[r7]
            stikerwap.appdys.AndItem r14 = new stikerwap.appdys.AndItem
            r14.<init>()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r9 = "it"
            r15.<init>(r9)
            r15.append(r12)
            r15.append(r10)
            java.lang.String r15 = r15.toString()
            r22 = r3
            r3 = 0
            int r15 = r5.getInt(r15, r3)
            int r3 = java.lang.Integer.parseInt(r12)
            r14.id = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            r24 = r11
            java.lang.String r11 = "_tit1"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.tit1 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_c"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit1_c = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.tit2 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_c"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit2_c = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.txt = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_c"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_c = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_h"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_h = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fcab_id"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.fcab_id = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fcab_modif"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 1
            int r3 = r5.getInt(r3, r11)
            r14.fcab_modif = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fcab_c"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.fcab_c = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fcab_url"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.fcab_url = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fotos_pos"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.fotos_pos = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fotos_c"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.fotos_c = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fotos_h"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.fotos_h = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fcab_z"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r11 = 1
            if (r3 != r11) goto L_0x2353
            r3 = 1
            goto L_0x2354
        L_0x2353:
            r3 = 0
        L_0x2354:
            r14.fcab_zoom = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_fotos_z"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 1
            int r3 = r5.getInt(r3, r11)
            if (r3 != r11) goto L_0x2370
            r3 = 1
            goto L_0x2371
        L_0x2370:
            r3 = 0
        L_0x2371:
            r14.fotos_zoom = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_b"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit1_b = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_i"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit1_i = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_f"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit1_f = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_col"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.tit1_col = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_u"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit1_u = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit1_s"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit1_s = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_b"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit2_b = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_i"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit2_i = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_f"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit2_f = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_col"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.tit2_col = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_u"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit2_u = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_tit2_s"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.tit2_s = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_b"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_b = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_i"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_i = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_f"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_f = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_col"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            r14.txt_col = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_u"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_u = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r11 = "_txt_s"
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r11 = 0
            int r3 = r5.getInt(r3, r11)
            r14.txt_s = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r12)
            java.lang.String r9 = "_idfotos"
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r5.getString(r3, r8)
            boolean r9 = r3.equals(r8)
            if (r9 != 0) goto L_0x25d2
            java.lang.String[] r3 = r3.split(r6)
            int r9 = r3.length
            r11 = 2
            int[] r12 = new int[r11]
            r17 = 1
            r12[r17] = r11
            r11 = 0
            r12[r11] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r12)
            int[][] r9 = (int[][]) r9
            r14.fotos_a = r9
            int r9 = r3.length
            java.lang.String[] r9 = new java.lang.String[r9]
            r14.fotos_str_a = r9
            r9 = 0
        L_0x255a:
            int r11 = r3.length
            if (r9 >= r11) goto L_0x25cd
            r11 = r3[r9]
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r25 = r3
            java.lang.String r3 = "it_f"
            r12.<init>(r3)
            r12.append(r11)
            r12.append(r10)
            java.lang.String r3 = r12.toString()
            r12 = 0
            int r3 = r5.getInt(r3, r12)
            int[][] r12 = r14.fotos_a
            r17 = 1
            int r3 = r3 + -1
            r12 = r12[r3]
            int r26 = java.lang.Integer.parseInt(r11)
            r18 = 0
            r12[r18] = r26
            int[][] r12 = r14.fotos_a
            r12 = r12[r3]
            r26 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r27 = r6
            java.lang.String r6 = "it_f"
            r13.<init>(r6)
            r13.append(r11)
            java.lang.String r6 = "_modif"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            r13 = 1
            int r6 = r5.getInt(r6, r13)
            r12[r13] = r6
            java.lang.String[] r6 = r14.fotos_str_a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "it_f"
            r12.<init>(r13)
            r12.append(r11)
            java.lang.String r11 = "_url"
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            java.lang.String r11 = r5.getString(r11, r8)
            r6[r3] = r11
            int r9 = r9 + 1
            r3 = r25
            r13 = r26
            r6 = r27
            goto L_0x255a
        L_0x25cd:
            r27 = r6
            r26 = r13
            goto L_0x25e6
        L_0x25d2:
            r27 = r6
            r26 = r13
            r3 = 2
            int[] r6 = new int[r3]
            r6 = {0, 0} // fill-array
            java.lang.Class r3 = java.lang.Integer.TYPE
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r6)
            int[][] r3 = (int[][]) r3
            r14.fotos_a = r3
        L_0x25e6:
            stikerwap.appdys.AndItem[] r3 = r1.and_items_a
            r6 = 1
            int r15 = r15 - r6
            r3[r15] = r14
            int r7 = r7 + 1
            r3 = r22
            r11 = r24
            r13 = r26
            r6 = r27
            r9 = 5
            goto L_0x21c2
        L_0x25f9:
            r27 = r6
            r24 = r11
            r26 = r13
            stikerwap.appdys.Seccion[] r3 = r0.secciones_a
            r3[r2] = r1
            java.util.ArrayList<java.lang.Integer> r3 = secciones_alist
            int r6 = r1.id
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3.add(r6)
            boolean r1 = r1.oculta
            if (r1 != 0) goto L_0x2619
            int[] r1 = r0.menu_a_secciones
            r1[r21] = r2
            int r14 = r21 + 1
            goto L_0x261b
        L_0x2619:
            r14 = r21
        L_0x261b:
            int r12 = r19 + 1
            r1 = r29
            r2 = r30
            r3 = r31
            r7 = r20
            r9 = r23
            r11 = r24
            r13 = r26
            r6 = r27
            r10 = 0
            goto L_0x1307
        L_0x2630:
            r27 = r6
            r21 = r14
            if (r32 == 0) goto L_0x26a1
            java.lang.String r1 = r32.getDataString()
            if (r1 == 0) goto L_0x26a1
            java.lang.String r1 = r32.getDataString()
            java.lang.String r2 = "www.appcreator24.com/open3008836-cfolv1/"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x26a1
            java.lang.String r1 = r32.getDataString()
            java.lang.String r2 = "http://"
            java.lang.String r1 = r1.replace(r2, r8)
            java.lang.String r2 = "https://"
            java.lang.String r1 = r1.replace(r2, r8)
            int r2 = r1.length()
            r3 = 40
            if (r2 <= r3) goto L_0x26a1
            java.lang.String r2 = "/"
            java.lang.String[] r1 = r1.split(r2)
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            r1 = r1[r2]
            r3 = r29
            r2 = 0
        L_0x266f:
            int r6 = r3.length
            if (r2 >= r6) goto L_0x26a1
            stikerwap.appdys.Seccion[] r6 = r0.secciones_a
            r6 = r6[r2]
            java.lang.String r6 = r6.idgo
            boolean r6 = r6.equalsIgnoreCase(r1)
            if (r6 == 0) goto L_0x269e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            stikerwap.appdys.Seccion[] r3 = r0.secciones_a
            r2 = r3[r2]
            int r2 = r2.id
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r2 = 0
            int r1 = r5.getInt(r1, r2)
            r2 = 1
            int r1 = r1 - r2
            r2 = -1
            if (r1 == r2) goto L_0x26a1
            goto L_0x26a2
        L_0x269e:
            int r2 = r2 + 1
            goto L_0x266f
        L_0x26a1:
            r1 = r7
        L_0x26a2:
            if (r32 == 0) goto L_0x26df
            java.lang.String r2 = r32.getDataString()
            if (r2 == 0) goto L_0x26df
            java.lang.String r2 = r32.getDataString()
            java.lang.String r3 = "join-app.net/a3008836-cfolv1/"
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x26df
            java.lang.String r2 = r32.getDataString()
            java.lang.String r3 = "http://"
            java.lang.String r2 = r2.replace(r3, r8)
            java.lang.String r3 = "https://"
            java.lang.String r2 = r2.replace(r3, r8)
            int r3 = r2.length()
            r4 = 29
            if (r3 <= r4) goto L_0x26df
            java.lang.String r3 = "/"
            java.lang.String[] r2 = r2.split(r3)
            int r3 = r2.length
            r4 = 1
            int r3 = r3 - r4
            r2 = r2[r3]
            java.lang.String r2 = r2.toUpperCase()
            r0.codigo_acceso = r2
        L_0x26df:
            int[] r2 = r0.menu_a_secciones
            r14 = r21
            int[] r3 = new int[r14]
            r0.menu_a_secciones = r3
            r3 = 0
        L_0x26e8:
            if (r3 >= r14) goto L_0x26f3
            int[] r4 = r0.menu_a_secciones
            r6 = r2[r3]
            r4[r3] = r6
            int r3 = r3 + 1
            goto L_0x26e8
        L_0x26f3:
            r2 = 9996(0x270c, float:1.4007E-41)
            if (r1 != r2) goto L_0x26fb
            r1 = r30
            r7 = 0
            goto L_0x26fe
        L_0x26fb:
            r7 = r1
            r1 = r30
        L_0x26fe:
            int r2 = r1.length
            stikerwap.appdys.Oficina[] r2 = new stikerwap.appdys.Oficina[r2]
            r0.oficinas_a = r2
            r2 = 0
        L_0x2704:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x2989
            r3 = r1[r2]
            stikerwap.appdys.Oficina r4 = new stikerwap.appdys.Oficina
            r4.<init>()
            int r6 = java.lang.Integer.parseInt(r3)
            r4.id = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r9 = "o"
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_tit"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.titulo = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_dir1"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.dir1 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_dir2"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.dir2 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_cp"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.cp = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_pob"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.pob = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_prov"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.prov = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_tel1"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.tel1 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_tel2"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.tel2 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_horario"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.horario = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_nfotos"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r11 = 0
            int r6 = r5.getInt(r6, r11)
            r4.nfotos = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r12 = "_x"
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            int r6 = r5.getInt(r6, r11)
            r4.x = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r12 = "_y"
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            int r6 = r5.getInt(r6, r11)
            r4.y = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r12 = "_z"
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            int r6 = r5.getInt(r6, r11)
            r4.z = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_email"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.email = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_t_email"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r11 = 0
            int r6 = r5.getInt(r6, r11)
            if (r6 != 0) goto L_0x2874
            r4.t_email = r11
            goto L_0x2877
        L_0x2874:
            r6 = 1
            r4.t_email = r6
        L_0x2877:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_web"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            r4.web = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_wp"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r11 = 1
            int r6 = r5.getInt(r6, r11)
            if (r6 != 0) goto L_0x28aa
            r6 = 0
            r4.web_popup = r6
            goto L_0x28ad
        L_0x28aa:
            r6 = 0
            r4.web_popup = r11
        L_0x28ad:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r9)
            r11.append(r3)
            java.lang.String r12 = "_chat"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            int r11 = r5.getInt(r11, r6)
            if (r11 != 0) goto L_0x28c8
            r4.chat = r6
            r6 = 1
            goto L_0x28cb
        L_0x28c8:
            r6 = 1
            r4.chat = r6
        L_0x28cb:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r9)
            r11.append(r3)
            java.lang.String r12 = "_zoo"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            int r11 = r5.getInt(r11, r6)
            if (r11 != r6) goto L_0x28e4
            r6 = 1
            goto L_0x28e5
        L_0x28e4:
            r6 = 0
        L_0x28e5:
            r4.fotos_z = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            java.lang.String r11 = "_idfotos"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getString(r6, r8)
            boolean r11 = r6.equals(r8)
            if (r11 != 0) goto L_0x2964
            r11 = r27
            java.lang.String[] r6 = r6.split(r11)
            r12 = 0
        L_0x2909:
            int r13 = r6.length
            if (r12 >= r13) goto L_0x2966
            r13 = r6[r12]
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "o_f"
            r14.<init>(r15)
            r14.append(r13)
            r14.append(r10)
            java.lang.String r14 = r14.toString()
            r15 = 0
            int r14 = r5.getInt(r14, r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "o_f"
            r15.<init>(r1)
            r15.append(r13)
            java.lang.String r1 = "_modif"
            r15.append(r1)
            java.lang.String r1 = r15.toString()
            r15 = 1
            boolean r1 = r5.getBoolean(r1, r15)
            int r13 = java.lang.Integer.parseInt(r13)
            if (r14 != r15) goto L_0x2948
            r4.f1_id = r13
            r4.f1_modif = r1
        L_0x2946:
            r15 = 4
            goto L_0x295f
        L_0x2948:
            r15 = 2
            if (r14 != r15) goto L_0x2950
            r4.f2_id = r13
            r4.f2_modif = r1
            goto L_0x2946
        L_0x2950:
            r15 = 3
            if (r14 != r15) goto L_0x2958
            r4.f3_id = r13
            r4.f3_modif = r1
            goto L_0x2946
        L_0x2958:
            r15 = 4
            if (r14 != r15) goto L_0x295f
            r4.f4_id = r13
            r4.f4_modif = r1
        L_0x295f:
            int r12 = r12 + 1
            r1 = r30
            goto L_0x2909
        L_0x2964:
            r11 = r27
        L_0x2966:
            r15 = 4
            stikerwap.appdys.Oficina[] r1 = r0.oficinas_a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r3)
            r6.append(r10)
            java.lang.String r3 = r6.toString()
            r6 = 0
            int r3 = r5.getInt(r3, r6)
            r9 = 1
            int r3 = r3 - r9
            r1[r3] = r4
            int r2 = r2 + 1
            r1 = r30
            r27 = r11
            goto L_0x2704
        L_0x2989:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.crear_globales(java.lang.String[], java.lang.String[], android.os.Bundle, android.content.Intent):int");
    }

    /* access modifiers changed from: package-private */
    public void cargar_int(Context context) {
        int i;
        int i2 = toca_int;
        if (i2 == 1 || (i = toca_int_chat) == 1) {
            com.google.android.gms.ads.interstitial.InterstitialAd.load(this, admob_int_cod, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                public void onAdLoaded(com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                    config.interstitial_glob = interstitialAd;
                    config.interstitial_glob.setFullScreenContentCallback(new FullScreenContentCallback() {
                        public void onAdDismissedFullScreenContent() {
                        }

                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        }

                        public void onAdShowedFullScreenContent() {
                            config.interstitial_glob = null;
                        }
                    });
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    config.interstitial_glob = null;
                    if (config.appnext_cod.equals("")) {
                        config.toca_int = 0;
                        config.toca_int_chat = 0;
                    }
                }
            });
        } else if (i2 != 2 && i != 2) {
            if (i2 == 3 || i == 3) {
                fb_glob_int = new InterstitialAd(context, fb_int_cod);
                AnonymousClass13 r5 = new InterstitialAdListener() {
                    public void onAdClicked(Ad ad) {
                    }

                    public void onAdLoaded(Ad ad) {
                    }

                    public void onInterstitialDismissed(Ad ad) {
                    }

                    public void onInterstitialDisplayed(Ad ad) {
                    }

                    public void onLoggingImpression(Ad ad) {
                    }

                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                        config.toca_int = 0;
                        config.toca_int_chat = 0;
                    }
                };
                InterstitialAd interstitialAd = fb_glob_int;
                interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(r5).build());
            } else if (i2 == 4 || i == 4) {
                StartAppAd startAppAd = new StartAppAd(getApplicationContext());
                st_glob_int = startAppAd;
                startAppAd.loadAd((AdEventListener) new AdEventListener() {
                    public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
                    }

                    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
                        config.toca_int = 0;
                        config.toca_int_chat = 0;
                    }
                });
            } else if (i2 != 9 && i != 9) {
                if (i2 == 10 || i == 10) {
                    IronSource.loadInterstitial();
                } else if (i2 == 12 || i == 12) {
                    com.wortise.ads.interstitial.InterstitialAd interstitialAd2 = wortise_glob_int;
                    if (interstitialAd2 != null) {
                        interstitialAd2.destroy();
                    }
                    wortise_glob_int = null;
                    com.wortise.ads.interstitial.InterstitialAd interstitialAd3 = new com.wortise.ads.interstitial.InterstitialAd(context, wortise_int_cod);
                    wortise_glob_int = interstitialAd3;
                    interstitialAd3.setListener(new InterstitialAd.Listener() {
                        public void onInterstitialClicked(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                        }

                        public void onInterstitialDismissed(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                        }

                        public void onInterstitialShown(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                        }

                        public void onInterstitialFailed(com.wortise.ads.interstitial.InterstitialAd interstitialAd, AdError adError) {
                            Log.e("ara", "wortise interstitial failed:" + adError.toString());
                            if (config.wortise_glob_int != null) {
                                config.wortise_glob_int.destroy();
                            }
                            config.wortise_glob_int = null;
                            if (config.appnext_cod.equals("")) {
                                config.toca_int = 0;
                                config.toca_int_chat = 0;
                            }
                        }

                        public void onInterstitialLoaded(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                            config.wortise_glob_int = interstitialAd;
                        }
                    });
                    wortise_glob_int.loadAd();
                } else if (i2 == 13 || i == 13) {
                    if (pangle_glob_int != null) {
                        pangle_glob_int = null;
                    }
                    PAGInterstitialAd.loadAd(pangle_int_cod, new PAGInterstitialRequest(), (PAGInterstitialAdLoadListener) new PAGInterstitialAdLoadListener() {
                        public void onError(int i, String str) {
                            Log.e("ara", "error al cargar Pangle:" + str);
                            config.pangle_glob_int = null;
                            config.toca_int = 0;
                            config.toca_int_chat = 0;
                        }

                        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                            config.pangle_glob_int = pAGInterstitialAd;
                        }
                    });
                } else if (i2 == 14 || i == 14) {
                    if (liftoff_glob_int != null) {
                        liftoff_glob_int = null;
                    }
                    com.vungle.ads.InterstitialAd interstitialAd4 = new com.vungle.ads.InterstitialAd(this, liftoff_int_cod, new AdConfig());
                    liftoff_glob_int = interstitialAd4;
                    interstitialAd4.setAdListener(new com.vungle.ads.InterstitialAdListener() {
                        public void onAdClicked(BaseAd baseAd) {
                        }

                        public void onAdEnd(BaseAd baseAd) {
                        }

                        public void onAdFailedToPlay(BaseAd baseAd, VungleError vungleError) {
                        }

                        public void onAdImpression(BaseAd baseAd) {
                        }

                        public void onAdLeftApplication(BaseAd baseAd) {
                        }

                        public void onAdLoaded(BaseAd baseAd) {
                        }

                        public void onAdStart(BaseAd baseAd) {
                        }

                        public void onAdFailedToLoad(BaseAd baseAd, VungleError vungleError) {
                            Log.e("ara", "error al cargar Liftoff:" + vungleError);
                            config.liftoff_glob_int = null;
                            config.toca_int = 0;
                            config.toca_int_chat = 0;
                        }
                    });
                    liftoff_glob_int.load((String) null);
                } else if (i2 == 15 || i == 15) {
                    if (mint_glob_int != null) {
                        mint_glob_int = null;
                    }
                    MBNewInterstitialHandler mBNewInterstitialHandler = new MBNewInterstitialHandler(this, mint_int_cod_place, mint_int_cod_unit);
                    mint_glob_int = mBNewInterstitialHandler;
                    mBNewInterstitialHandler.setInterstitialVideoListener(new NewInterstitialListener() {
                        public void onLoadCampaignSuccess(MBridgeIds mBridgeIds) {
                            Log.i("ara", "onLoadCampaignSuccess: " + Thread.currentThread() + " " + mBridgeIds.toString());
                        }

                        public void onResourceLoadSuccess(MBridgeIds mBridgeIds) {
                            Log.i("ara", "onResourceLoadSuccess: " + Thread.currentThread() + " " + mBridgeIds.toString());
                        }

                        public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
                            Log.e("ara", "onResourceLoadFail errorMsg: " + str + " " + mBridgeIds.toString());
                            config.mint_glob_int = null;
                            config.toca_int = 0;
                            config.toca_int_chat = 0;
                        }

                        public void onShowFail(MBridgeIds mBridgeIds, String str) {
                            Log.e("ara", "onShowFail: " + str + " " + mBridgeIds.toString());
                        }

                        public void onAdShow(MBridgeIds mBridgeIds) {
                            Log.i("ara", "onAdShow: " + mBridgeIds.toString());
                        }

                        public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                            Log.i("ara", "onAdClose: isCompleteViewï¼" + rewardInfo.isCompleteView() + " " + mBridgeIds.toString());
                        }

                        public void onAdClicked(MBridgeIds mBridgeIds) {
                            Log.i("ara", "onAdClicked: " + mBridgeIds.toString());
                        }

                        public void onVideoComplete(MBridgeIds mBridgeIds) {
                            Log.i("ara", "onVideoComplete: " + mBridgeIds.toString());
                        }

                        public void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                            Log.i("ara", "onAdCloseWithNIReward: " + mBridgeIds.toString() + "  " + rewardInfo.toString());
                            Log.i("ara", rewardInfo.isCompleteView() ? "Video playback/playable is complete." : "Video playback/playable is not complete.");
                            int rewardAlertStatus = rewardInfo.getRewardAlertStatus();
                            if (rewardAlertStatus == MBridgeConstans.IVREWARDALERT_STATUS_NOTSHOWN) {
                                Log.e("ara", "The dialog is not shown.");
                            }
                            if (rewardAlertStatus == MBridgeConstans.IVREWARDALERT_STATUS_CLICKCONTINUE) {
                                Log.e("ara", "The dialog's continue button clicked.");
                            }
                            if (rewardAlertStatus == MBridgeConstans.IVREWARDALERT_STATUS_CLICKCANCEL) {
                                Log.e("ara", "The dialog's cancel button clicked.");
                            }
                        }

                        public void onEndcardShow(MBridgeIds mBridgeIds) {
                            Log.i("ara", "onEndcardShow: " + mBridgeIds.toString());
                        }
                    });
                    mint_glob_int.load();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_int(final Context context, Boolean bool) {
        MBNewInterstitialHandler mBNewInterstitialHandler;
        com.vungle.ads.InterstitialAd interstitialAd;
        PAGInterstitialAd pAGInterstitialAd;
        StartAppAd startAppAd;
        com.facebook.ads.InterstitialAd interstitialAd2;
        com.wortise.ads.interstitial.InterstitialAd interstitialAd3;
        com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd4;
        int i = toca_int;
        if (i == 1 && (interstitialAd4 = interstitial_glob) != null) {
            interstitialAd4.show((Activity) context);
            toca_int = 0;
            toca_int_chat = 0;
        } else if (i != 12 || (interstitialAd3 = wortise_glob_int) == null || !interstitialAd3.isAvailable()) {
            int i2 = toca_int;
            if (i2 == 2 || ((i2 == 1 && !appnext_cod.equals("")) || (toca_int == 12 && !appnext_cod.equals("")))) {
                if (appnext_glob_int == null) {
                    appnext_glob_int = new Interstitial(getApplicationContext(), appnext_cod_int_ia);
                    if (mute.booleanValue()) {
                        appnext_glob_int.setMute(true);
                    }
                    if (!autoplay.booleanValue()) {
                        appnext_glob_int.setAutoPlay(false);
                    }
                    appnext_glob_int.setBackButtonCanClose(true);
                    appnext_glob_int.setSkipText(getResources().getString(R.string.ad_saltar));
                    appnext_glob_int.setOnAdLoadedCallback(new OnAdLoaded() {
                        public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
                            try {
                                config.appnext_glob_int.showAd();
                            } catch (Exception unused) {
                            }
                        }
                    });
                    appnext_glob_int.setOnAdErrorCallback(new OnAdError() {
                        public void adError(String str) {
                            Log.e("ara", "AppNext Interstitial error:" + str);
                            config.appnext_glob_int = null;
                        }
                    });
                    appnext_glob_int.setOnAdClosedCallback(new OnAdClosed() {
                        public void onAdClosed() {
                            config.appnext_glob_int = null;
                        }
                    });
                    appnext_glob_int.loadAd();
                }
                toca_int = 0;
                toca_int_chat = 0;
            } else if (toca_int == 3 && (interstitialAd2 = fb_glob_int) != null && interstitialAd2.isAdLoaded()) {
                fb_glob_int.show();
                toca_int = 0;
                toca_int_chat = 0;
            } else if (toca_int != 4 || (startAppAd = st_glob_int) == null || !startAppAd.isReady()) {
                int i3 = toca_int;
                if (i3 == 6) {
                    Intent intent = new Intent(context, t_url.class);
                    intent.putExtra("url", this.instal_int_url);
                    try {
                        intent.addFlags(65536);
                    } catch (Exception unused) {
                    }
                    ((Activity) context).startActivityForResult(intent, 0);
                    toca_int = 0;
                    toca_int_chat = 0;
                } else if (i3 == 7) {
                    abrir_ext(context, this.pa_int_url);
                    toca_int = 0;
                    toca_int_chat = 0;
                } else if (i3 != 9 || !UnityAds.isInitialized()) {
                    int i4 = toca_int;
                    if (i4 == 10) {
                        if (!IronSource.isInterstitialReady()) {
                            try {
                                IronSource.loadInterstitial();
                            } catch (Exception unused2) {
                            }
                        } else {
                            IronSource.showInterstitial();
                            toca_int = 0;
                            toca_int_chat = 0;
                        }
                    } else if (i4 == 13 && (pAGInterstitialAd = pangle_glob_int) != null) {
                        pAGInterstitialAd.show((Activity) context);
                        toca_int = 0;
                        toca_int_chat = 0;
                    } else if (i4 == 14 && (interstitialAd = liftoff_glob_int) != null && interstitialAd.canPlayAd().booleanValue()) {
                        liftoff_glob_int.play(context);
                        toca_int = 0;
                        toca_int_chat = 0;
                    } else if (toca_int == 15 && (mBNewInterstitialHandler = mint_glob_int) != null && mBNewInterstitialHandler.isReady()) {
                        mint_glob_int.show();
                        toca_int = 0;
                        toca_int_chat = 0;
                    }
                } else {
                    UnityAds.load(uni_int_cod, new IUnityAdsLoadListener() {
                        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                        }

                        public void onUnityAdsAdLoaded(String str) {
                            UnityAds.show((Activity) context, config.uni_int_cod, new UnityAdsShowOptions(), (IUnityAdsShowListener) null);
                        }
                    });
                    toca_int = 0;
                    toca_int_chat = 0;
                }
            } else {
                st_glob_int.showAd(our == 1 ? "Intersticial normal" : "INTERSTITIAL");
                toca_int = 0;
                toca_int_chat = 0;
            }
        } else {
            wortise_glob_int.showAd();
            toca_int = 0;
            toca_int_chat = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_int_chat(final Context context) {
        MBNewInterstitialHandler mBNewInterstitialHandler;
        com.vungle.ads.InterstitialAd interstitialAd;
        PAGInterstitialAd pAGInterstitialAd;
        StartAppAd startAppAd;
        com.facebook.ads.InterstitialAd interstitialAd2;
        com.wortise.ads.interstitial.InterstitialAd interstitialAd3;
        com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd4;
        int i = toca_int_chat;
        if (i == 1 && (interstitialAd4 = interstitial_glob) != null) {
            interstitialAd4.show((Activity) context);
            toca_int = 0;
            toca_int_chat = 0;
        } else if (i != 12 || (interstitialAd3 = wortise_glob_int) == null || !interstitialAd3.isAvailable()) {
            int i2 = toca_int_chat;
            if (i2 == 2 || ((i2 == 1 && !appnext_cod.equals("")) || (toca_int_chat == 12 && !appnext_cod.equals("")))) {
                if (appnext_glob_int == null) {
                    appnext_glob_int = new Interstitial(getApplicationContext(), appnext_cod_int_ia);
                    if (mute.booleanValue()) {
                        appnext_glob_int.setMute(true);
                    }
                    if (!autoplay.booleanValue()) {
                        appnext_glob_int.setAutoPlay(false);
                    }
                    appnext_glob_int.setBackButtonCanClose(true);
                    appnext_glob_int.setSkipText(getResources().getString(R.string.ad_saltar));
                    appnext_glob_int.setOnAdLoadedCallback(new OnAdLoaded() {
                        public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
                            try {
                                config.appnext_glob_int.showAd();
                            } catch (Exception unused) {
                            }
                        }
                    });
                    appnext_glob_int.setOnAdErrorCallback(new OnAdError() {
                        public void adError(String str) {
                            Log.e("ara", "AppNext Interstitial error:" + str);
                            config.appnext_glob_int = null;
                        }
                    });
                    appnext_glob_int.setOnAdClosedCallback(new OnAdClosed() {
                        public void onAdClosed() {
                            config.appnext_glob_int = null;
                        }
                    });
                    appnext_glob_int.loadAd();
                }
                toca_int = 0;
                toca_int_chat = 0;
            } else if (toca_int_chat == 3 && (interstitialAd2 = fb_glob_int) != null && interstitialAd2.isAdLoaded()) {
                fb_glob_int.show();
                toca_int = 0;
                toca_int_chat = 0;
            } else if (toca_int_chat != 4 || (startAppAd = st_glob_int) == null || !startAppAd.isReady()) {
                int i3 = toca_int_chat;
                if (i3 == 6) {
                    Intent intent = new Intent(context, t_url.class);
                    intent.putExtra("url", this.instal_int_url);
                    try {
                        intent.addFlags(65536);
                    } catch (Exception unused) {
                    }
                    ((Activity) context).startActivityForResult(intent, 0);
                    toca_int = 0;
                    toca_int_chat = 0;
                } else if (i3 == 7) {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(this.pa_int_url));
                    intent2.addFlags(268435456);
                    ((Activity) context).startActivity(intent2);
                    toca_int = 0;
                    toca_int_chat = 0;
                } else if (i3 == 9 && UnityAds.isInitialized()) {
                    UnityAds.load(uni_int_cod, new IUnityAdsLoadListener() {
                        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                        }

                        public void onUnityAdsAdLoaded(String str) {
                            UnityAds.show((Activity) context, config.uni_int_cod, new UnityAdsShowOptions(), (IUnityAdsShowListener) null);
                        }
                    });
                    toca_int = 0;
                    toca_int_chat = 0;
                } else if (toca_int_chat != 10 || !IronSource.isInterstitialReady()) {
                    int i4 = toca_int_chat;
                    if (i4 == 13 && (pAGInterstitialAd = pangle_glob_int) != null) {
                        pAGInterstitialAd.show((Activity) context);
                        toca_int = 0;
                        toca_int_chat = 0;
                    } else if (i4 == 14 && (interstitialAd = liftoff_glob_int) != null && interstitialAd.canPlayAd().booleanValue()) {
                        liftoff_glob_int.play(context);
                        toca_int = 0;
                        toca_int_chat = 0;
                    } else if (toca_int_chat == 15 && (mBNewInterstitialHandler = mint_glob_int) != null && mBNewInterstitialHandler.isReady()) {
                        mint_glob_int.show();
                        toca_int = 0;
                        toca_int_chat = 0;
                    }
                } else {
                    IronSource.showInterstitial();
                    toca_int = 0;
                    toca_int_chat = 0;
                }
            } else {
                st_glob_int.showAd(our == 1 ? "Intersticial chat" : "INTERSTITIAL");
                toca_int = 0;
                toca_int_chat = 0;
            }
        } else {
            wortise_glob_int.showAd();
            toca_int = 0;
            toca_int_chat = 0;
        }
    }

    public void toca_int(Context context, boolean z, boolean z2) {
        toca_int_2(context, z, z2, true);
    }

    public void toca_int_2(Context context, boolean z, boolean z2, boolean z3) {
        toca_int_3(context, z, z2, true, false);
    }

    public void toca_int_3(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        int i2;
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            mostrar_int(context, Boolean.valueOf(z3));
            if (toca_int <= 0) {
                if (z || z2) {
                    int i3 = toca_int_chat;
                    if (i3 != 2) {
                        if (z) {
                            toca_int = 1;
                        } else if (z2) {
                            toca_int = 3;
                        } else {
                            return;
                        }
                        if (i3 == 0) {
                            cargar_int(context);
                        }
                        SharedPreferences.Editor edit = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                        edit.putInt("n_imp", 0);
                        edit.putInt("n_imp_chat", 0);
                        edit.commit();
                        return;
                    }
                    return;
                }
                if ((!z4 && this.admob_int_interv > 0) || (z4 && this.admob_intgame_interv > 0)) {
                    SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                    int i4 = sharedPreferences.getInt("n_imp", 0) + 1;
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    edit2.putInt("n_imp", i4);
                    edit2.commit();
                    if ((!z4 && (i2 = this.admob_int_interv) > 0 && i4 % i2 == 0) || (z4 && (i = this.admob_intgame_interv) > 0 && i4 % i == 0)) {
                        edit2.putInt("n_imp_chat", 0);
                        edit2.commit();
                        ArrayList arrayList = new ArrayList();
                        if (!admob_int_cod.equals("")) {
                            arrayList.add(1);
                        }
                        if (!appnext_cod.equals("") && ((admob_int_cod.equals("") || !prioridad_admob) && wortise_int_cod.equals(""))) {
                            arrayList.add(2);
                        }
                        if (!fb_int_cod.equals("")) {
                            arrayList.add(3);
                        }
                        if (!st_int_cod.equals("")) {
                            arrayList.add(4);
                        }
                        if (!this.instal_int_url.equals("")) {
                            arrayList.add(6);
                        }
                        if (!this.pa_int_url.equals("")) {
                            arrayList.add(7);
                        }
                        if (!uni_int_cod.equals("")) {
                            arrayList.add(9);
                        }
                        if (!is_int_cod.equals("")) {
                            arrayList.add(10);
                        }
                        if (!wortise_int_cod.equals("")) {
                            arrayList.add(12);
                        }
                        if (!pangle_int_cod.equals("")) {
                            arrayList.add(13);
                        }
                        if (!liftoff_int_cod.equals("")) {
                            arrayList.add(14);
                        }
                        if (!mint_int_cod_place.equals("")) {
                            arrayList.add(15);
                        }
                        if (!arrayList.isEmpty()) {
                            if (arrayList.size() > 1) {
                                int i5 = toca_int_chat;
                                if (i5 > 0) {
                                    toca_int = i5;
                                } else {
                                    toca_int = ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue();
                                }
                            } else {
                                toca_int = ((Integer) arrayList.get(0)).intValue();
                            }
                            if (toca_int_chat == 0) {
                                cargar_int(context);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                toca_int = 0;
            }
        }
    }

    public void toca_int_chat(Context context) {
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            mostrar_int_chat(context);
            if (toca_int_chat <= 0) {
                if (this.admob_chat_interv > 0) {
                    SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                    int i = sharedPreferences.getInt("n_imp_chat", 0) + 1;
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putInt("n_imp_chat", i);
                    edit.commit();
                    if (i % this.admob_chat_interv == 0) {
                        edit.putInt("n_imp", 0);
                        edit.commit();
                        ArrayList arrayList = new ArrayList();
                        if (!admob_int_cod.equals("")) {
                            arrayList.add(1);
                        }
                        if (!appnext_cod.equals("") && ((admob_int_cod.equals("") || !prioridad_admob) && wortise_int_cod.equals(""))) {
                            arrayList.add(2);
                        }
                        if (!fb_int_cod.equals("")) {
                            arrayList.add(3);
                        }
                        if (!st_int_cod.equals("")) {
                            arrayList.add(4);
                        }
                        if (!this.instal_int_url.equals("")) {
                            arrayList.add(6);
                        }
                        if (!this.pa_int_url.equals("")) {
                            arrayList.add(7);
                        }
                        if (!uni_int_cod.equals("")) {
                            arrayList.add(9);
                        }
                        if (!is_int_cod.equals("")) {
                            arrayList.add(10);
                        }
                        if (!wortise_int_cod.equals("")) {
                            arrayList.add(12);
                        }
                        if (!pangle_int_cod.equals("")) {
                            arrayList.add(13);
                        }
                        if (!liftoff_int_cod.equals("")) {
                            arrayList.add(14);
                        }
                        if (!mint_int_cod_place.equals("")) {
                            arrayList.add(15);
                        }
                        if (!arrayList.isEmpty()) {
                            if (arrayList.size() > 1) {
                                int i2 = toca_int;
                                if (i2 > 0) {
                                    toca_int_chat = i2;
                                } else {
                                    toca_int_chat = ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue();
                                }
                            } else {
                                toca_int_chat = ((Integer) arrayList.get(0)).intValue();
                            }
                            if (toca_int == 0) {
                                cargar_int(context);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                toca_int_chat = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void mostrar_inchat_post(LinearLayout linearLayout, int i, int i2) {
        ArrayList<NativeAdDetails> arrayList;
        ArrayList<NativeAd> arrayList2;
        ArrayList arrayList3 = new ArrayList();
        String str = this.appnext_inchat_cod;
        if (str != null && !str.equals("") && (arrayList2 = this.appnext_ads) != null && arrayList2.size() > 0) {
            arrayList3.add(1);
        }
        String str2 = this.st_inchat_cod;
        if (str2 != null && !str2.equals("") && (arrayList = this.startapp_ads) != null && arrayList.size() > 0) {
            arrayList3.add(2);
        }
        int intValue = !arrayList3.isEmpty() ? ((Integer) arrayList3.get(new Random().nextInt(((arrayList3.size() - 1) - 0) + 1) + 0)).intValue() : 0;
        if (intValue == 1) {
            ((RelativeLayout) linearLayout.findViewById(R.id.na_ad)).getLayoutParams().width = i2;
            NativeAd nativeAd = this.appnext_ads.get(new Random().nextInt(((this.appnext_ads.size() - 1) - 0) + 1) + 0);
            ((TextView) linearLayout.findViewById(R.id.na_install)).setTextColor(i);
            ((TextView) linearLayout.findViewById(R.id.na_install)).setText(getResources().getString(R.string.download) + " app");
            nativeAd.downloadAndDisplayImage(getApplicationContext(), (ImageView) linearLayout.findViewById(R.id.na_media), nativeAd.getWideImageURL());
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(linearLayout.findViewById(R.id.na_view));
            arrayList4.add(linearLayout.findViewById(R.id.na_install));
            nativeAd.registerClickableViews((List<View>) arrayList4);
            nativeAd.setNativeAdView((NativeAdView) linearLayout.findViewById(R.id.na_view));
            linearLayout.findViewById(R.id.na_view).setVisibility(0);
        } else if (intValue == 2) {
            ((RelativeLayout) linearLayout.findViewById(R.id.sa_ad)).getLayoutParams().width = i2;
            NativeAdDetails nativeAdDetails = this.startapp_ads.get(new Random().nextInt(((this.startapp_ads.size() - 1) - 0) + 1) + 0);
            ((TextView) linearLayout.findViewById(R.id.sa_install)).setTextColor(i);
            ((TextView) linearLayout.findViewById(R.id.sa_install)).setText(getResources().getString(R.string.download) + " app");
            ((ImageView) linearLayout.findViewById(R.id.sa_iv)).setImageBitmap(nativeAdDetails.getImageBitmap());
            nativeAdDetails.registerViewForInteraction(linearLayout);
            linearLayout.findViewById(R.id.sa_ad).setVisibility(0);
        }
    }

    public void mostrar_inchat(int i, final String str) {
        SharedPreferences.Editor edit = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
        edit.putString("f2_idfrase", "0");
        edit.putString("f2_id", "1");
        edit.putString("f2_nombre", getResources().getString(R.string.bot));
        edit.putString("f2_privados", "0");
        if (i == 0) {
            edit.putString("f2_frase", getResources().getString(R.string.bot_frase));
            edit.putString("f2_b64", "");
        } else if (i == 1) {
            edit.putString("f2_frase", "");
            edit.putString("f2_b64", "es_ad");
        }
        edit.putString("f2_fcrea", new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
        edit.putString("f2_tipo", "0");
        edit.putString("f2_b64_th", "");
        edit.putString("f2_idvideo", "");
        edit.putString("f2_formato", "");
        edit.putString("f2_idtema", str);
        edit.putString("f2_vfoto", "0");
        edit.putString("f2_fnac_d", "1");
        edit.putString("f2_fnac_m", "1");
        edit.putString("f2_fnac_a", "1977");
        edit.putString("f2_sexo", "0");
        edit.putString("f2_coments", "0");
        edit.putBoolean("f2_ultimas", false);
        edit.putString("f2_ts", System.currentTimeMillis() + "");
        edit.commit();
        if (i == 0) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    config.this.mostrar_inchat(1, str);
                }
            }, 1000);
        }
    }

    public void toca_inchat(Context context, SharedPreferences sharedPreferences, final String str) {
        String str2;
        String str3;
        ArrayList<NativeAdDetails> arrayList;
        ArrayList<NativeAd> arrayList2;
        boolean z = false;
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            if (this.inchat_1vez > 0 && this.inchat_veces > 0 && (((str2 = this.appnext_inchat_cod) != null && !str2.equals("") && (arrayList2 = this.appnext_ads) != null && arrayList2.size() > 0) || ((str3 = this.st_inchat_cod) != null && !str3.equals("") && (arrayList = this.startapp_ads) != null && arrayList.size() > 0))) {
                int i = sharedPreferences.getInt("n_inchat", 0) + 1;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("n_inchat", i);
                edit.commit();
                int i2 = this.inchat_1vez;
                if (i == i2 || (i > i2 && (i - i2) % this.inchat_veces == 0)) {
                    z = true;
                }
            }
            if (z) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        config.this.mostrar_inchat(0, str);
                    }
                }, 2000);
            }
        }
    }

    public int toca_intentrar() {
        if (getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            return 0;
        }
        toca_int = 0;
        toca_int_chat = 0;
        if (!this.acad_tit.equals("")) {
            return 5;
        }
        if (this.admob_intentrar_interv <= 0) {
            return 0;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        int i = sharedPreferences.getInt("n_impentrada", 0) + 1;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("n_impentrada", i);
        edit.commit();
        if (i % this.admob_intentrar_interv != 0 && i != 1) {
            return 0;
        }
        edit.putInt("n_imp", 0);
        edit.putInt("n_imp_chat", 0);
        edit.commit();
        ArrayList arrayList = new ArrayList();
        if (!admob_int_cod.equals("") || !admob_appopen_cod.equals("")) {
            arrayList.add(1);
        }
        if (!appnext_cod.equals("") && ((admob_int_cod.equals("") && admob_appopen_cod.equals("")) || !prioridad_admob)) {
            arrayList.add(2);
        }
        if (!fb_int_cod.equals("")) {
            arrayList.add(3);
        }
        if (!st_int_cod.equals("")) {
            arrayList.add(4);
        }
        if (!uni_int_cod.equals("")) {
            arrayList.add(9);
        }
        if (!is_int_cod.equals("")) {
            arrayList.add(10);
        }
        if (!wortise_int_cod.equals("")) {
            arrayList.add(12);
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        if (arrayList.size() > 1) {
            return ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue();
        }
        return ((Integer) arrayList.get(0)).intValue();
    }

    public boolean esSuprem() {
        return esSuprem1() || esSuprem2() || esSuprem3();
    }

    private boolean esSuprem1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private boolean esSuprem2() {
        String[] strArr = {"/system/app/Superuser.apk", "/system/bin/su", "/system/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/data/local/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/sbin/su"};
        int i = 0;
        while (i < 10) {
            try {
                if (new File(strArr[i]).exists()) {
                    return true;
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean esSuprem3() {
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", DownloadCommon.DOWNLOAD_REPORT_SUCCESS});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() == null) {
                if (exec != null) {
                    exec.destroy();
                }
                return false;
            } else if (exec == null) {
                return true;
            } else {
                exec.destroy();
                return true;
            }
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void iniciar_tomardecamara(android.content.Context r5, java.io.File r6) {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.media.action.IMAGE_CAPTURE"
            r0.<init>(r1)
            java.lang.String r1 = "stikerwap.appdys.fileprovider"
            android.net.Uri r6 = androidx.core.content.FileProvider.getUriForFile(r5, r1, r6)     // Catch:{ Exception -> 0x004b }
            java.lang.String r1 = "output"
            r0.putExtra(r1, r6)
            r1 = 1
            r0.addFlags(r1)
            r1 = 2
            r0.addFlags(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 >= r2) goto L_0x0044
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            r2 = 65536(0x10000, float:9.18355E-41)
            java.util.List r1 = r1.queryIntentActivities(r0, r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x002f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.pm.ActivityInfo r2 = r2.activityInfo
            java.lang.String r2 = r2.packageName
            r3 = 3
            r4.grantUriPermission(r2, r6, r3)
            goto L_0x002f
        L_0x0044:
            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{  }
            r6 = 106(0x6a, float:1.49E-43)
            r5.startActivityForResult(r0, r6)     // Catch:{  }
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.iniciar_tomardecamara(android.content.Context, java.io.File):void");
    }

    /* access modifiers changed from: package-private */
    public void iniciar_tomardecamara_v(Context context, File file) {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (file != null) {
            intent.putExtra("output", FileProvider.getUriForFile(context, "stikerwap.appdys.fileprovider", file));
        }
        intent.putExtra("android.intent.extra.videoQuality", 0);
        intent.putExtra("android.intent.extra.durationLimit", 40);
        intent.putExtra("android.intent.extra.sizeLimit", MAX_VID_LENGTH);
        intent.putExtra("android.intent.extra.videoQuality", 0);
        intent.putExtra("android.intent.extra.durationLimit", 40);
        intent.putExtra("android.intent.extra.sizeLimit", MAX_VID_LENGTH);
        try {
            ((Activity) context).startActivityForResult(intent, 108);
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public boolean tener_que_pedir_p_camara(Context context, int i) {
        PackageInfo packageInfo;
        String[] strArr;
        Boolean bool = false;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (!(packageInfo == null || (strArr = packageInfo.requestedPermissions) == null)) {
            bool = Boolean.valueOf(Arrays.asList(strArr).contains("android.permission.CAMERA"));
        }
        if (!bool.booleanValue() || ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            return false;
        }
        ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.CAMERA"}, i);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v121, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r51v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v42, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v50, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v51, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v55, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v134, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v46, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v56, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v47, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v58, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v136, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v57, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v61, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v67, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v142, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v62, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v65, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v143, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v71, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v66, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v67, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v146, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v74, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v68, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v147, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v75, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v58, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v148, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v149, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v49, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v77, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v150, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r61v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v5, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x06d5, code lost:
        if ((java.lang.System.currentTimeMillis() - r10.longValue()) < java.lang.Long.valueOf((long) (((r0.getInt("notif_int", 0) * 60) * 60) * 1000)).longValue()) goto L_0x069c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x04f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x04f3  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x086b  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x08b9  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x08cf  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x099a  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x09cc  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0bea  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0bec  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0bf3  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0c01  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0c22  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0c27  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0cf7  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0d3c  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0d4a  */
    /* JADX WARNING: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:313:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void notificar(android.content.Context r70, java.lang.String r71) {
        /*
            r8 = r70
            java.lang.String r0 = "sh"
            r1 = 0
            android.content.SharedPreferences r0 = r8.getSharedPreferences(r0, r1)
            android.content.SharedPreferences$Editor r2 = r0.edit()
            java.lang.String r3 = "\\\""
            java.lang.String r4 = "\""
            r5 = r71
            java.lang.String r3 = r5.replace(r3, r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x0023
            r4 = 201326592(0xc000000, float:9.8607613E-32)
            r9 = 201326592(0xc000000, float:9.8607613E-32)
            goto L_0x0027
        L_0x0023:
            r4 = 134217728(0x8000000, float:3.85186E-34)
            r9 = 134217728(0x8000000, float:3.85186E-34)
        L_0x0027:
            java.lang.String r4 = "@"
            int r5 = r3.indexOf(r4)
            r6 = 1
            int r5 = r5 + r6
            int r7 = r3.indexOf(r4, r5)
            java.lang.String r5 = r3.substring(r5, r7)
            java.lang.String r7 = "PRIVADO"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0041
            goto L_0x0d5f
        L_0x0041:
            java.lang.String r7 = "RESP:"
            boolean r10 = r5.startsWith(r7)
            java.lang.String r11 = "COMENT:"
            r13 = 4
            r14 = 6
            r15 = 5
            java.lang.String r6 = "1"
            java.lang.String r1 = "0"
            java.lang.String r12 = ""
            if (r10 == 0) goto L_0x00aa
            java.lang.String[] r3 = r3.split(r4)
            r4 = r3[r13]
            r10 = r3[r15]
            r18 = r3[r14]
            r17 = 7
            r3 = r3[r17]
            r13 = r1
            r22 = r3
            r32 = r4
            r24 = r9
            r50 = r10
            r4 = r12
            r9 = r4
            r10 = r9
            r14 = r10
            r15 = r14
            r21 = r15
            r23 = r21
            r25 = r23
            r26 = r25
            r27 = r26
            r28 = r27
            r29 = r28
            r30 = r29
            r31 = r30
            r33 = r31
            r35 = r33
            r36 = r35
            r37 = r36
            r39 = r37
            r40 = r39
            r48 = r40
            r49 = r48
            r51 = r49
            r52 = r51
            r53 = r52
            r54 = r53
            r55 = r54
            r56 = r55
            r57 = r56
            r58 = r57
            r59 = r58
            r61 = r59
            r60 = r18
            goto L_0x03a6
        L_0x00aa:
            boolean r10 = r5.startsWith(r11)
            java.lang.String r14 = "-"
            if (r10 == 0) goto L_0x0114
            java.lang.String[] r3 = r3.split(r4)
            r4 = r3[r13]
            r10 = r3[r15]
            r18 = 6
            r13 = r3[r18]
            java.lang.String[] r13 = r13.split(r14)
            r14 = 0
            r20 = r13[r14]
            r21 = 1
            r13 = r13[r21]
            r14 = 7
            r3 = r3[r14]
            r21 = r3
            r32 = r4
            r24 = r9
            r50 = r10
            r4 = r12
            r9 = r4
            r10 = r9
            r14 = r10
            r15 = r14
            r22 = r15
            r23 = r22
            r25 = r23
            r26 = r25
            r27 = r26
            r28 = r27
            r29 = r28
            r30 = r29
            r31 = r30
            r33 = r31
            r35 = r33
            r36 = r35
            r37 = r36
            r39 = r37
            r40 = r39
            r48 = r40
            r49 = r48
            r51 = r49
            r52 = r51
            r53 = r52
            r54 = r53
            r55 = r54
            r57 = r55
            r58 = r57
            r59 = r58
            r61 = r59
            r56 = r13
            r60 = r20
            r13 = r1
            goto L_0x03a6
        L_0x0114:
            r21 = 1
            int r10 = r3.indexOf(r14)
            int r10 = r10 + 1
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            int r15 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r15)
            int r15 = r15 + 1
            r22 = r10
            int r10 = r3.indexOf(r14, r15)
            java.lang.String r15 = r3.substring(r15, r10)
            int r10 = r10 + 1
            r23 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r24 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r25 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r26 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r27 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r28 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r29 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r30 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r31 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r32 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r33 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r34 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r35 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            r36 = r10
            int r10 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r10)
            int r10 = r10 + 1
            r37 = r13
            int r13 = r3.indexOf(r14, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            int r14 = r3.indexOf(r14, r13)
            java.lang.String r13 = r3.substring(r13, r14)
            int r14 = r3.indexOf(r4)
            int r14 = r14 + 1
            int r14 = r3.indexOf(r4, r14)
            int r14 = r14 + 1
            r38 = r10
            int r10 = r3.indexOf(r4, r14)
            java.lang.String r14 = r3.substring(r14, r10)
            r39 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r40 = r15
            java.lang.String r15 = "ban_"
            r13.<init>(r15)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0227
            return
        L_0x0227:
            int r10 = r10 + 1
            int r13 = r3.indexOf(r4, r10)
            java.lang.String r10 = r3.substring(r10, r13)
            int r13 = r13 + 1
            int r15 = r3.indexOf(r4, r13)
            java.lang.String r13 = r3.substring(r13, r15)
            r41 = r10
            java.lang.String r10 = "\\'"
            r42 = r14
            java.lang.String r14 = "'"
            java.lang.String r10 = r13.replace(r10, r14)
            int r15 = r15 + 1
            int r13 = r3.indexOf(r4, r15)
            java.lang.String r14 = r3.substring(r15, r13)
            int r13 = r13 + 1
            int r15 = r3.indexOf(r4, r13)
            java.lang.String r13 = r3.substring(r13, r15)
            int r15 = r15 + 1
            r43 = r10
            int r10 = r3.indexOf(r4, r15)
            java.lang.String r15 = r3.substring(r15, r10)
            int r10 = r10 + 1
            r44 = r13
            int r13 = r3.indexOf(r4, r10)     // Catch:{ Exception -> 0x035f }
            java.lang.String r10 = r3.substring(r10, r13)     // Catch:{ Exception -> 0x035f }
            int r13 = r13 + 1
            r45 = r10
            int r10 = r3.indexOf(r4, r13)     // Catch:{ Exception -> 0x0357 }
            java.lang.String r13 = r3.substring(r13, r10)     // Catch:{ Exception -> 0x0357 }
            boolean r46 = r13.equals(r6)     // Catch:{ Exception -> 0x0353 }
            if (r46 == 0) goto L_0x02b9
            int r10 = r10 + 1
            r46 = r14
            int r14 = r3.indexOf(r4, r10)     // Catch:{ Exception -> 0x0355 }
            java.lang.String r10 = r3.substring(r10, r14)     // Catch:{ Exception -> 0x0355 }
            int r14 = r14 + 1
            r47 = r10
            int r10 = r3.indexOf(r4, r14)     // Catch:{ Exception -> 0x02b2 }
            java.lang.String r14 = r3.substring(r14, r10)     // Catch:{ Exception -> 0x02b2 }
            int r10 = r10 + 1
            int r4 = r3.indexOf(r4, r10)     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.substring(r10, r4)     // Catch:{ Exception -> 0x02af }
            r4 = r12
            r21 = r14
            r10 = r47
            r14 = r4
            goto L_0x0315
        L_0x02af:
            r3 = r12
            goto L_0x02b5
        L_0x02b2:
            r3 = r12
            r14 = r3
        L_0x02b5:
            r10 = r47
            goto L_0x0368
        L_0x02b9:
            r46 = r14
            java.lang.String r14 = "2"
            boolean r14 = r13.equals(r14)     // Catch:{ Exception -> 0x0355 }
            if (r14 == 0) goto L_0x02e5
            r14 = 1
            int r10 = r10 + r14
            int r14 = r3.indexOf(r4, r10)     // Catch:{ Exception -> 0x0355 }
            java.lang.String r10 = r3.substring(r10, r14)     // Catch:{ Exception -> 0x0355 }
            r21 = 1
            int r14 = r14 + 1
            int r4 = r3.indexOf(r4, r14)     // Catch:{ Exception -> 0x02df }
            java.lang.String r3 = r3.substring(r14, r4)     // Catch:{ Exception -> 0x02df }
            r21 = r10
            r4 = r12
            r10 = r4
            r14 = r10
            goto L_0x0315
        L_0x02df:
            r14 = r10
            r3 = r12
            r10 = r3
            goto L_0x0368
        L_0x02e5:
            java.lang.String r14 = "3"
            boolean r14 = r13.equals(r14)     // Catch:{ Exception -> 0x0355 }
            if (r14 == 0) goto L_0x030f
            r14 = 1
            int r10 = r10 + r14
            int r14 = r3.indexOf(r4, r10)     // Catch:{ Exception -> 0x0355 }
            java.lang.String r10 = r3.substring(r10, r14)     // Catch:{ Exception -> 0x0355 }
            r21 = 1
            int r14 = r14 + 1
            int r4 = r3.indexOf(r4, r14)     // Catch:{ Exception -> 0x030a }
            java.lang.String r3 = r3.substring(r14, r4)     // Catch:{ Exception -> 0x030a }
            r4 = r3
            r14 = r10
            r3 = r12
            r10 = r3
            r21 = r10
            goto L_0x0315
        L_0x030a:
            r3 = r10
            r10 = r12
            goto L_0x035d
        L_0x030f:
            r3 = r12
            r4 = r3
            r10 = r4
            r14 = r10
            r21 = r14
        L_0x0315:
            r50 = r12
            r56 = r50
            r60 = r56
            r58 = r14
            r59 = r15
            r61 = r21
            r55 = r25
            r57 = r27
            r51 = r28
            r53 = r29
            r28 = r30
            r54 = r31
            r27 = r32
            r52 = r33
            r48 = r34
            r49 = r38
            r33 = r41
            r15 = r42
            r32 = r44
            r14 = r46
            r29 = r3
            r30 = r10
            r21 = r60
            r10 = r22
            r31 = r23
            r25 = r24
            r23 = r4
            r24 = r9
            r22 = r21
            r4 = r43
            goto L_0x03a4
        L_0x0353:
            r46 = r14
        L_0x0355:
            goto L_0x035b
        L_0x0357:
            r46 = r14
            r13 = r1
        L_0x035b:
            r3 = r12
            r10 = r3
        L_0x035d:
            r14 = r10
            goto L_0x0368
        L_0x035f:
            r46 = r14
            r13 = r1
            r3 = r12
            r10 = r3
            r14 = r10
            r45 = r14
        L_0x0368:
            r58 = r3
            r21 = r12
            r50 = r21
            r56 = r50
            r60 = r56
            r61 = r14
            r59 = r15
            r55 = r25
            r57 = r27
            r51 = r28
            r53 = r29
            r28 = r30
            r54 = r31
            r27 = r32
            r52 = r33
            r48 = r34
            r49 = r38
            r33 = r41
            r15 = r42
            r4 = r43
            r32 = r44
            r14 = r46
            r30 = r10
            r29 = r60
            r10 = r22
            r31 = r23
            r25 = r24
            r24 = r9
            r22 = r29
            r23 = r22
        L_0x03a4:
            r9 = r45
        L_0x03a6:
            java.lang.String r3 = "COMSELF:"
            boolean r3 = r5.startsWith(r3)
            java.lang.String r8 = "notification"
            r38 = r8
            java.lang.String r8 = "COMSELFV:"
            r41 = r6
            java.lang.String r6 = "privados"
            r42 = r6
            java.lang.String r6 = "avisos"
            r44 = r6
            java.lang.String r6 = " "
            if (r3 != 0) goto L_0x099a
            boolean r3 = r5.startsWith(r8)
            if (r3 != 0) goto L_0x099a
            java.lang.String r3 = "COMFAV:"
            boolean r3 = r5.startsWith(r3)
            if (r3 != 0) goto L_0x099a
            java.lang.String r3 = "FGALFAV:"
            boolean r3 = r5.startsWith(r3)
            if (r3 != 0) goto L_0x099a
            java.lang.String r3 = "FGALVFAV:"
            boolean r3 = r5.startsWith(r3)
            if (r3 != 0) goto L_0x099a
            java.lang.String r3 = "FPERFAV:"
            boolean r3 = r5.startsWith(r3)
            if (r3 != 0) goto L_0x099a
            java.lang.String r3 = "DESCRFAV:"
            boolean r3 = r5.startsWith(r3)
            if (r3 != 0) goto L_0x099a
            boolean r3 = r5.startsWith(r7)
            if (r3 != 0) goto L_0x099a
            boolean r3 = r5.startsWith(r11)
            if (r3 != 0) goto L_0x099a
            java.lang.String r3 = "BEAT:"
            boolean r3 = r5.startsWith(r3)
            if (r3 == 0) goto L_0x042d
            r12 = r70
            r10 = r5
            r14 = r6
            r68 = r24
            r63 = r27
            r67 = r29
            r9 = r31
            r66 = r32
            r5 = r33
            r2 = r38
            r4 = r42
            r6 = r44
            r65 = r49
            r1 = r52
            r16 = r53
            r62 = r54
            r27 = r55
            r64 = r59
            r24 = r61
            r13 = 0
            r29 = r28
            r28 = r48
            goto L_0x09c5
        L_0x042d:
            boolean r3 = r4.equals(r12)
            if (r3 == 0) goto L_0x0440
            boolean r3 = r9.equals(r12)
            if (r3 == 0) goto L_0x0440
            boolean r3 = r13.equals(r1)
            if (r3 == 0) goto L_0x0440
            return
        L_0x0440:
            boolean r3 = r15.equals(r1)
            r7 = 0
            if (r3 != 0) goto L_0x046e
            boolean r3 = r15.equals(r12)
            if (r3 != 0) goto L_0x046e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r11 = "idusu"
            r45 = r5
            r46 = r6
            long r5 = r0.getLong(r11, r7)
            r3.append(r5)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x0472
            return
        L_0x046e:
            r45 = r5
            r46 = r6
        L_0x0472:
            boolean r3 = r15.equals(r1)
            if (r3 != 0) goto L_0x0537
            boolean r3 = r15.equals(r12)
            if (r3 != 0) goto L_0x0537
            boolean r3 = r4.equals(r12)
            if (r3 == 0) goto L_0x0486
            r3 = r9
            goto L_0x0487
        L_0x0486:
            r3 = r4
        L_0x0487:
            boolean r5 = r3.equals(r12)
            if (r5 == 0) goto L_0x048f
            r3 = r30
        L_0x048f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "_idremit_ult"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r0.getString(r5, r12)
            boolean r5 = r5.equals(r15)
            if (r5 == 0) goto L_0x04ed
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "_mensaje_ult"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r0.getString(r5, r12)
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x04ed
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r14)
            java.lang.String r7 = "_f_ult"
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            r47 = r12
            long r11 = java.lang.System.currentTimeMillis()
            long r7 = r0.getLong(r7, r11)
            long r5 = r5 - r7
            r7 = 30000(0x7530, double:1.4822E-319)
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x04ef
            r5 = 1
            goto L_0x04f0
        L_0x04ed:
            r47 = r12
        L_0x04ef:
            r5 = 0
        L_0x04f0:
            if (r5 == 0) goto L_0x04f3
            return
        L_0x04f3:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "_f_ult"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            long r6 = java.lang.System.currentTimeMillis()
            r2.putLong(r5, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "_idremit_ult"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.putString(r5, r15)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "_mensaje_ult"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.putString(r5, r3)
            r2.commit()
            goto L_0x0539
        L_0x0537:
            r47 = r12
        L_0x0539:
            r3 = r41
            boolean r5 = r10.equals(r3)
            if (r5 == 0) goto L_0x054f
            r6 = 2131886669(0x7f12024d, float:1.9407923E38)
            r12 = r70
            r5 = r33
            anyadir_privado(r12, r15, r5)
            r11 = r32
            r7 = 1
            goto L_0x0586
        L_0x054f:
            r6 = 2131886669(0x7f12024d, float:1.9407923E38)
            r12 = r70
            r5 = r33
            java.lang.String r7 = "idprivado"
            java.lang.String r7 = r0.getString(r7, r1)
            boolean r7 = r7.equals(r1)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "chat"
            r8.<init>(r11)
            r11 = r32
            r8.append(r11)
            java.lang.String r6 = "_validado"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r8 = 1
            boolean r6 = r0.getBoolean(r6, r8)
            if (r6 == 0) goto L_0x0999
            java.lang.String r6 = "pwd_validado"
            boolean r6 = r0.getBoolean(r6, r8)
            if (r6 != 0) goto L_0x0586
            goto L_0x0999
        L_0x0586:
            if (r7 != 0) goto L_0x0589
            return
        L_0x0589:
            boolean r6 = r10.equals(r1)
            java.lang.String r7 = "activa"
            if (r6 != 0) goto L_0x05af
            boolean r6 = r10.equals(r3)
            if (r6 == 0) goto L_0x05ab
            r6 = 0
            boolean r8 = r0.getBoolean(r7, r6)
            if (r8 == 0) goto L_0x05ab
            java.lang.String r6 = "idprivado"
            java.lang.String r6 = r0.getString(r6, r1)
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x05ab
            goto L_0x05af
        L_0x05ab:
            r8 = r47
            goto L_0x0646
        L_0x05af:
            java.lang.String r6 = "f2_idfrase"
            r8 = r45
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_id"
            r2.putString(r6, r15)
            java.lang.String r6 = "f2_nombre"
            r2.putString(r6, r5)
            java.lang.String r6 = "f2_privados"
            r8 = r31
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_frase"
            r2.putString(r6, r4)
            java.lang.String r6 = "f2_fcrea"
            java.lang.String r8 = convertir_fecha(r40)
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_b64"
            r2.putString(r6, r9)
            java.lang.String r6 = "f2_tipo"
            r2.putString(r6, r13)
            java.lang.String r6 = "f2_b64_th"
            r8 = r30
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_idvideo"
            r9 = r61
            r2.putString(r6, r9)
            java.lang.String r6 = "f2_formato"
            r8 = r29
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_idtema"
            r2.putString(r6, r14)
            java.lang.String r6 = "f2_vfoto"
            r8 = r59
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_fnac_d"
            r8 = r53
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_fnac_m"
            r8 = r28
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_fnac_a"
            r8 = r54
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_sexo"
            r8 = r27
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_coments"
            r8 = r52
            r2.putString(r6, r8)
            java.lang.String r6 = "f2_ultimas"
            r8 = 0
            r2.putBoolean(r6, r8)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            long r8 = java.lang.System.currentTimeMillis()
            r6.append(r8)
            r8 = r47
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.String r9 = "f2_ts"
            r2.putString(r9, r6)
            r2.commit()
        L_0x0646:
            boolean r6 = r10.equals(r1)
            if (r6 == 0) goto L_0x084d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            r9 = 0
            boolean r6 = r0.getBoolean(r6, r9)
            if (r6 != 0) goto L_0x084d
            r27 = r15
            r6 = r44
            int r15 = r0.getInt(r6, r9)
            r9 = 2
            if (r15 >= r9) goto L_0x084f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "s"
            r7.<init>(r9)
            r7.append(r11)
            java.lang.String r9 = "_tipo"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r9 = 0
            int r7 = r0.getInt(r7, r9)
            if (r7 == 0) goto L_0x068d
            r10 = 6
            if (r7 == r10) goto L_0x068d
            r15 = 7
            if (r7 != r15) goto L_0x068b
            goto L_0x068d
        L_0x068b:
            r7 = 1
            goto L_0x068e
        L_0x068d:
            r7 = 0
        L_0x068e:
            if (r7 == 0) goto L_0x06d8
            java.lang.String r10 = "notif_int"
            int r10 = r0.getInt(r10, r9)
            r15 = 9999(0x270f, float:1.4012E-41)
            if (r10 != r15) goto L_0x069e
            r17 = r14
        L_0x069c:
            r7 = 0
            goto L_0x06da
        L_0x069e:
            java.lang.String r10 = "f_ult_notif"
            r17 = r14
            r14 = 0
            long r18 = r0.getLong(r10, r14)
            java.lang.Long r10 = java.lang.Long.valueOf(r18)
            long r18 = r10.longValue()
            int r16 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x06da
            java.lang.String r14 = "notif_int"
            int r14 = r0.getInt(r14, r9)
            int r14 = r14 * 60
            int r14 = r14 * 60
            int r14 = r14 * 1000
            long r14 = (long) r14
            java.lang.Long r9 = java.lang.Long.valueOf(r14)
            long r14 = java.lang.System.currentTimeMillis()
            long r18 = r10.longValue()
            long r14 = r14 - r18
            long r9 = r9.longValue()
            int r18 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r18 >= 0) goto L_0x06da
            goto L_0x069c
        L_0x06d8:
            r17 = r14
        L_0x06da:
            if (r7 == 0) goto L_0x0d5f
            java.lang.String r7 = "f_ult_notif"
            long r9 = java.lang.System.currentTimeMillis()
            r2.putLong(r7, r9)
            r2.commit()
            r2 = r38
            java.lang.Object r2 = r12.getSystemService(r2)
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2
            boolean r7 = r4.equals(r8)
            if (r7 != 0) goto L_0x071c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r14 = r46
            r1.append(r14)
            android.content.res.Resources r5 = r70.getResources()
            r7 = 2131886323(0x7f1200f3, float:1.9407222E38)
            java.lang.String r5 = r5.getString(r7)
            r1.append(r5)
            java.lang.String r5 = ":"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
        L_0x071a:
            r5 = 1
            goto L_0x077c
        L_0x071c:
            r14 = r46
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x074d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r14)
            android.content.res.Resources r4 = r70.getResources()
            r5 = 2131886355(0x7f120113, float:1.9407287E38)
            java.lang.String r4 = r4.getString(r5)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.content.res.Resources r4 = r70.getResources()
            r5 = 2131886669(0x7f12024d, float:1.9407923E38)
            java.lang.String r4 = r4.getString(r5)
            goto L_0x071a
        L_0x074d:
            boolean r1 = r13.equals(r3)
            if (r1 == 0) goto L_0x084c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r14)
            android.content.res.Resources r4 = r70.getResources()
            r5 = 2131886356(0x7f120114, float:1.9407289E38)
            java.lang.String r4 = r4.getString(r5)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.content.res.Resources r4 = r70.getResources()
            r5 = 2131886670(0x7f12024e, float:1.9407925E38)
            java.lang.String r4 = r4.getString(r5)
            goto L_0x071a
        L_0x077c:
            int r0 = r0.getInt(r6, r5)
            if (r0 != 0) goto L_0x0784
            r0 = 1
            goto L_0x0785
        L_0x0784:
            r0 = 0
        L_0x0785:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            if (r5 < r6) goto L_0x0799
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            android.app.NotificationChannel r6 = crear_channel(r12, r0)
            java.lang.String r6 = r6.getId()
            r5.<init>((android.content.Context) r12, (java.lang.String) r6)
            goto L_0x079e
        L_0x0799:
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            r5.<init>(r12)
        L_0x079e:
            r6 = 2131231598(0x7f08036e, float:1.8079282E38)
            androidx.core.app.NotificationCompat$Builder r6 = r5.setSmallIcon((int) r6)
            androidx.core.app.NotificationCompat$Builder r1 = r6.setContentTitle(r1)
            androidx.core.app.NotificationCompat$Builder r1 = r1.setContentText(r4)
            r4 = 1
            r1.setAutoCancel(r4)
            android.graphics.Bitmap r1 = ico_en_notif(r70)
            if (r1 == 0) goto L_0x07ba
            r5.setLargeIcon(r1)
        L_0x07ba:
            if (r0 != r4) goto L_0x07c0
            r0 = 5
            r5.setDefaults(r0)
        L_0x07c0:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.preinicio> r1 = stikerwap.appdys.preinicio.class
            r0.<init>(r12, r1)
            java.lang.String r1 = "notif_idtema"
            r4 = r17
            r0.putExtra(r1, r4)
            java.lang.String r1 = "notif_idsecc"
            r0.putExtra(r1, r11)
            java.lang.String r1 = "fotos_perfil"
            int r4 = java.lang.Integer.parseInt(r25)
            r0.putExtra(r1, r4)
            java.lang.String r1 = "fnac"
            int r4 = java.lang.Integer.parseInt(r35)
            r0.putExtra(r1, r4)
            java.lang.String r1 = "sexo"
            int r4 = java.lang.Integer.parseInt(r36)
            r0.putExtra(r1, r4)
            java.lang.String r1 = "descr"
            int r4 = java.lang.Integer.parseInt(r37)
            r0.putExtra(r1, r4)
            java.lang.String r1 = "dist"
            int r4 = java.lang.Integer.parseInt(r39)
            r0.putExtra(r1, r4)
            r1 = r55
            boolean r1 = r1.equals(r3)
            r4 = r42
            r0.putExtra(r4, r1)
            java.lang.String r1 = "coments"
            r13 = r48
            boolean r4 = r13.equals(r3)
            r0.putExtra(r1, r4)
            java.lang.String r1 = "galeria"
            r4 = r49
            boolean r3 = r4.equals(r3)
            r0.putExtra(r1, r3)
            java.lang.String r1 = "fotos_chat"
            int r3 = java.lang.Integer.parseInt(r26)
            r0.putExtra(r1, r3)
            java.lang.String r1 = "c1"
            r3 = r57
            r0.putExtra(r1, r3)
            java.lang.String r1 = "c2"
            r3 = r51
            r0.putExtra(r1, r3)
            r8 = r24
            r6 = 1
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r12, r6, r0, r8)
            r5.setContentIntent(r0)
            android.app.Notification r0 = r5.build()
            r2.notify(r6, r0)
            goto L_0x0d5f
        L_0x084c:
            return
        L_0x084d:
            r27 = r15
        L_0x084f:
            r8 = r24
            r2 = r38
            r4 = r42
            r14 = r46
            r6 = 1
            boolean r9 = r10.equals(r3)
            if (r9 == 0) goto L_0x08b9
            int r9 = r0.getInt(r4, r6)
            if (r9 != r6) goto L_0x08b9
            r6 = 0
            boolean r9 = r0.getBoolean(r7, r6)
            if (r9 == 0) goto L_0x08b9
            java.lang.String r6 = "idprivado"
            java.lang.String r6 = r0.getString(r6, r1)
            r9 = r27
            boolean r6 = r6.equals(r9)
            if (r6 != 0) goto L_0x08bb
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "f_ult_"
            r3.<init>(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r6 = 0
            long r3 = r0.getLong(r3, r6)
            long r1 = r1 - r3
            r3 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0d5f
            java.lang.String r0 = "accion"
            r1 = 0
            android.content.SharedPreferences r0 = r12.getSharedPreferences(r0, r1)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "accion"
            r2 = 1
            r0.putInt(r1, r2)
            java.lang.String r1 = "id_remit"
            r0.putString(r1, r9)
            java.lang.String r1 = "nombre_remit"
            r0.putString(r1, r5)
            r0.commit()
            goto L_0x0d5f
        L_0x08b9:
            r9 = r27
        L_0x08bb:
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x0d5f
            r3 = 1
            int r4 = r0.getInt(r4, r3)
            if (r4 != r3) goto L_0x0d5f
            r3 = 0
            boolean r3 = r0.getBoolean(r7, r3)
            if (r3 != 0) goto L_0x0d5f
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "f_ult_"
            r6.<init>(r7)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            long r6 = r0.getLong(r6, r10)
            long r3 = r3 - r6
            r6 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0d5f
            java.lang.Object r0 = r12.getSystemService(r2)
            r10 = r0
            android.app.NotificationManager r10 = (android.app.NotificationManager) r10
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r14)
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886681(0x7f120259, float:1.9407948E38)
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r0 < r3) goto L_0x0928
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            r3 = 1
            android.app.NotificationChannel r4 = crear_channel(r12, r3)
            java.lang.String r3 = r4.getId()
            r0.<init>((android.content.Context) r12, (java.lang.String) r3)
            goto L_0x092d
        L_0x0928:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            r0.<init>(r12)
        L_0x092d:
            r11 = r0
            r0 = 2131231598(0x7f08036e, float:1.8079282E38)
            androidx.core.app.NotificationCompat$Builder r0 = r11.setSmallIcon((int) r0)
            android.content.res.Resources r3 = r70.getResources()
            r4 = 2131886699(0x7f12026b, float:1.9407984E38)
            java.lang.String r3 = r3.getString(r4)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setContentTitle(r3)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setContentText(r2)
            r3 = 1
            r0.setAutoCancel(r3)
            android.graphics.Bitmap r0 = ico_en_notif(r70)
            if (r0 == 0) goto L_0x0955
            r11.setLargeIcon(r0)
        L_0x0955:
            r0 = 5
            r11.setDefaults(r0)
            android.content.Intent r13 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.preinicio> r0 = stikerwap.appdys.preinicio.class
            r13.<init>(r12, r0)
            java.lang.String r0 = "id_remit"
            r13.putExtra(r0, r9)
            java.lang.String r0 = "nombre_remit"
            r13.putExtra(r0, r5)
            r0 = 2
            boolean r0 = existe_notif(r12, r0, r9, r1)
            if (r0 != 0) goto L_0x0987
            android.content.res.Resources r0 = r70.getResources()
            r1 = 2131886699(0x7f12026b, float:1.9407984E38)
            java.lang.String r1 = r0.getString(r1)
            r4 = 3
            r5 = 2
            java.lang.String r7 = "0"
            r0 = r70
            r3 = r13
            r6 = r9
            crear_notif(r0, r1, r2, r3, r4, r5, r6, r7)
        L_0x0987:
            r0 = 3
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r12, r0, r13, r8)
            r11.setContentIntent(r0)
            r0 = 3
            android.app.Notification r1 = r11.build()
            r10.notify(r0, r1)
            goto L_0x0d5f
        L_0x0999:
            return
        L_0x099a:
            r12 = r70
            r10 = r5
            r14 = r6
            r68 = r24
            r63 = r27
            r13 = r28
            r67 = r29
            r9 = r31
            r66 = r32
            r5 = r33
            r2 = r38
            r4 = r42
            r6 = r44
            r28 = r48
            r65 = r49
            r1 = r52
            r62 = r54
            r27 = r55
            r64 = r59
            r24 = r61
            r29 = r13
            r16 = r53
            r13 = 0
        L_0x09c5:
            int r3 = r0.getInt(r6, r13)
            r13 = 2
            if (r3 >= r13) goto L_0x0d5f
            java.lang.String r3 = ":"
            java.lang.String[] r3 = r10.split(r3)
            r32 = r1
            r31 = 1
            r1 = r3[r31]
            r3 = r3[r13]
            java.lang.Object r2 = r12.getSystemService(r2)
            r13 = r2
            android.app.NotificationManager r13 = (android.app.NotificationManager) r13
            java.lang.String r2 = "COMFAV:"
            boolean r2 = r10.startsWith(r2)
            if (r2 == 0) goto L_0x0a16
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r31 = r3
            r3 = 2131886460(0x7f12017c, float:1.94075E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            r2.append(r14)
            r2.append(r5)
            java.lang.String r1 = r2.toString()
            r2 = r31
            r3 = 1
            r14 = 4
        L_0x0a12:
            r17 = 5
            goto L_0x0be4
        L_0x0a16:
            r31 = r3
            java.lang.String r2 = "FGALFAV:"
            boolean r2 = r10.startsWith(r2)
            if (r2 == 0) goto L_0x0a4b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886456(0x7f120178, float:1.9407491E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886669(0x7f12024d, float:1.9407923E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 1
            r14 = 5
            goto L_0x0a12
        L_0x0a4b:
            java.lang.String r2 = "FGALVFAV:"
            boolean r2 = r10.startsWith(r2)
            if (r2 == 0) goto L_0x0a81
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886457(0x7f120179, float:1.9407493E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886670(0x7f12024e, float:1.9407925E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 10
            r3 = 1
            r14 = 10
            goto L_0x0a12
        L_0x0a81:
            java.lang.String r2 = "FPERFAV:"
            boolean r2 = r10.startsWith(r2)
            if (r2 == 0) goto L_0x0ab5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886464(0x7f120180, float:1.9407508E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886669(0x7f12024d, float:1.9407923E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 1
            r14 = 6
            goto L_0x0a12
        L_0x0ab5:
            java.lang.String r2 = "DESCRFAV:"
            boolean r2 = r10.startsWith(r2)
            if (r2 == 0) goto L_0x0ae0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886463(0x7f12017f, float:1.9407506E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = r31
            r3 = 1
            r14 = 7
            goto L_0x0a12
        L_0x0ae0:
            boolean r2 = r10.startsWith(r8)
            if (r2 == 0) goto L_0x0b0e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886459(0x7f12017b, float:1.9407497E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 9
            r2 = r31
            r3 = 1
            r14 = 9
        L_0x0b0a:
            r17 = 4
            goto L_0x0be4
        L_0x0b0e:
            boolean r2 = r10.startsWith(r7)
            if (r2 == 0) goto L_0x0b4a
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886612(0x7f120214, float:1.9407808E38)
            java.lang.String r2 = r2.getString(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r14 = 2131886461(0x7f12017d, float:1.9407501E38)
            java.lang.String r1 = r1.getString(r14)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 11
            r3 = 1
            r14 = 11
        L_0x0b41:
            r17 = 6
            r69 = r2
            r2 = r1
            r1 = r69
            goto L_0x0be4
        L_0x0b4a:
            boolean r2 = r10.startsWith(r11)
            if (r2 == 0) goto L_0x0b7e
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886614(0x7f120216, float:1.9407812E38)
            java.lang.String r2 = r2.getString(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r14 = 2131886462(0x7f12017e, float:1.9407504E38)
            java.lang.String r1 = r1.getString(r14)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 12
            r3 = 1
            r14 = 12
            goto L_0x0b41
        L_0x0b7e:
            java.lang.String r2 = "BEAT:"
            boolean r2 = r10.startsWith(r2)
            if (r2 == 0) goto L_0x0bbe
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886466(0x7f120182, float:1.9407512E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            r2.append(r14)
            r1 = r23
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.res.Resources r2 = r70.getResources()
            r3 = 2131886673(0x7f120251, float:1.9407931E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 13
            r3 = 1
            r14 = 13
            r17 = 7
            goto L_0x0be4
        L_0x0bbe:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r14)
            android.content.res.Resources r1 = r70.getResources()
            r3 = 2131886458(0x7f12017a, float:1.9407495E38)
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 8
            r2 = r31
            r3 = 1
            r14 = 8
            goto L_0x0b0a
        L_0x0be4:
            int r0 = r0.getInt(r6, r3)
            if (r0 != 0) goto L_0x0bec
            r0 = 1
            goto L_0x0bed
        L_0x0bec:
            r0 = 0
        L_0x0bed:
            int r3 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            if (r3 < r6) goto L_0x0c01
            androidx.core.app.NotificationCompat$Builder r3 = new androidx.core.app.NotificationCompat$Builder
            android.app.NotificationChannel r6 = crear_channel(r12, r0)
            java.lang.String r6 = r6.getId()
            r3.<init>((android.content.Context) r12, (java.lang.String) r6)
            goto L_0x0c06
        L_0x0c01:
            androidx.core.app.NotificationCompat$Builder r3 = new androidx.core.app.NotificationCompat$Builder
            r3.<init>(r12)
        L_0x0c06:
            r6 = r3
            r3 = 2131231598(0x7f08036e, float:1.8079282E38)
            androidx.core.app.NotificationCompat$Builder r3 = r6.setSmallIcon((int) r3)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setContentTitle(r1)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setContentText(r2)
            r18 = r13
            r13 = 1
            r3.setAutoCancel(r13)
            android.graphics.Bitmap r3 = ico_en_notif(r70)
            if (r3 == 0) goto L_0x0c25
            r6.setLargeIcon(r3)
        L_0x0c25:
            if (r0 != r13) goto L_0x0c2b
            r0 = 5
            r6.setDefaults(r0)
        L_0x0c2b:
            android.content.Intent r13 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.preinicio> r0 = stikerwap.appdys.preinicio.class
            r13.<init>(r12, r0)
            boolean r0 = r10.startsWith(r7)
            if (r0 != 0) goto L_0x0cf7
            boolean r0 = r10.startsWith(r11)
            if (r0 == 0) goto L_0x0c40
            goto L_0x0cf7
        L_0x0c40:
            java.lang.String r0 = "abrir_perfil"
            r13.putExtra(r0, r15)
            r13.putExtra(r4, r9)
            java.lang.String r0 = "nombre"
            r13.putExtra(r0, r5)
            java.lang.String r0 = "coments"
            r3 = r32
            r13.putExtra(r0, r3)
            java.lang.String r0 = "fnac_d"
            r3 = r16
            r13.putExtra(r0, r3)
            java.lang.String r0 = "fnac_m"
            r3 = r29
            r13.putExtra(r0, r3)
            java.lang.String r0 = "fnac_a"
            r3 = r62
            r13.putExtra(r0, r3)
            java.lang.String r0 = "sexo"
            r3 = r63
            r13.putExtra(r0, r3)
            java.lang.String r0 = "vfoto"
            r3 = r64
            r13.putExtra(r0, r3)
            java.lang.String r0 = "p_fnac"
            int r3 = java.lang.Integer.parseInt(r35)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "p_sexo"
            int r3 = java.lang.Integer.parseInt(r36)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "p_descr"
            int r3 = java.lang.Integer.parseInt(r37)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "p_dist"
            int r3 = java.lang.Integer.parseInt(r39)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "coments_chat"
            r3 = r28
            r4 = r41
            boolean r3 = r3.equals(r4)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "galeria"
            r3 = r65
            boolean r3 = r3.equals(r4)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "privados_chat"
            r3 = r27
            boolean r3 = r3.equals(r4)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "fotos_perfil"
            int r3 = java.lang.Integer.parseInt(r25)
            r13.putExtra(r0, r3)
            java.lang.String r0 = "fotos_chat"
            int r3 = java.lang.Integer.parseInt(r26)
            r13.putExtra(r0, r3)
            boolean r0 = r10.startsWith(r8)
            if (r0 == 0) goto L_0x0ce7
            java.lang.String r0 = "abrir_perfilv"
            r3 = r24
            r13.putExtra(r0, r3)
            java.lang.String r0 = "abrir_perfilv_formato"
            r3 = r67
            r13.putExtra(r0, r3)
            goto L_0x0d36
        L_0x0ce7:
            java.lang.String r0 = "BEAT:"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x0d36
            java.lang.String r0 = "abrir_game"
            r3 = r58
            r13.putExtra(r0, r3)
            goto L_0x0d36
        L_0x0cf7:
            java.lang.String r0 = "abrir_idsecc"
            r4 = r66
            r13.putExtra(r0, r4)
            boolean r0 = r10.startsWith(r7)
            if (r0 == 0) goto L_0x0d1a
            java.lang.String r0 = "abrir_idcat"
            r10 = r50
            r13.putExtra(r0, r10)
            java.lang.String r0 = "abrir_idtema"
            r3 = r60
            r13.putExtra(r0, r3)
            java.lang.String r0 = "idresp_ir"
            r3 = r22
            r13.putExtra(r0, r3)
            goto L_0x0d36
        L_0x0d1a:
            r10 = r50
            r3 = r60
            java.lang.String r0 = "abrir_idcat"
            r13.putExtra(r0, r10)
            java.lang.String r0 = "abrir_idtema"
            r13.putExtra(r0, r3)
            java.lang.String r0 = "abrir_idresp"
            r3 = r56
            r13.putExtra(r0, r3)
            java.lang.String r0 = "idcoment_ir"
            r3 = r21
            r13.putExtra(r0, r3)
        L_0x0d36:
            boolean r0 = existe_notif(r12, r14, r15, r15)
            if (r0 != 0) goto L_0x0d4a
            r0 = r70
            r8 = r17
            r3 = r13
            r4 = r8
            r5 = r14
            r9 = r6
            r6 = r15
            r7 = r15
            crear_notif(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0d4d
        L_0x0d4a:
            r9 = r6
            r8 = r17
        L_0x0d4d:
            r4 = r68
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r12, r8, r13, r4)
            r9.setContentIntent(r0)
            android.app.Notification r0 = r9.build()
            r2 = r18
            r2.notify(r8, r0)
        L_0x0d5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.notificar(android.content.Context, java.lang.String):void");
    }

    public class MenuOpcion {
        public boolean esprivacy = false;
        public Bitmap img;
        public boolean img_cargando;
        public String texto;

        public MenuOpcion() {
        }
    }

    private static class MenuHolder {
        public ImageView img;
        public View marcador;
        public ProgressBar pb;
        public TextView texto;

        private MenuHolder() {
        }
    }

    public class MenuAdapter extends ArrayAdapter<MenuOpcion> {
        private Context context;
        private List<MenuOpcion> opcionList;

        public MenuAdapter(List<MenuOpcion> list, Context context2) {
            super(context2, R.layout.drawer_list_item, list);
            this.opcionList = list;
            this.context = context2;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            MenuHolder menuHolder = new MenuHolder();
            if (view == null) {
                view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.drawer_list_item, (ViewGroup) null);
                menuHolder.marcador = view.findViewById(R.id.marcador);
                menuHolder.texto = (TextView) view.findViewById(R.id.texto);
                menuHolder.img = (ImageView) view.findViewById(R.id.img);
                menuHolder.pb = (ProgressBar) view.findViewById(R.id.pb_img);
                if (config.this.t_ind == 0) {
                    menuHolder.marcador.getLayoutParams().width = 1;
                    menuHolder.marcador.setBackgroundColor(0);
                } else if (config.this.ind_secc_sel == 900) {
                    menuHolder.marcador.setBackgroundColor(0);
                }
                if (!config.this.hay_icosmenu) {
                    menuHolder.img.setVisibility(8);
                }
                view.setTag(R.id.TAG_IDHOLDER, menuHolder);
            } else {
                menuHolder = (MenuHolder) view.getTag(R.id.TAG_IDHOLDER);
            }
            MenuOpcion menuOpcion = this.opcionList.get(i);
            if (menuOpcion.esprivacy) {
                view.setTag(R.id.TAG_ESPRIVACY, "1");
            } else {
                view.setTag(R.id.TAG_ESPRIVACY, (Object) null);
            }
            if (i >= config.this.menu_a_secciones.length || config.this.ind_secc_sel != config.this.menu_a_secciones[i]) {
                menuHolder.marcador.setBackgroundColor(0);
                TextView textView = menuHolder.texto;
                textView.setTextColor(Color.parseColor("#" + config.this.c_secc_noactiv));
            } else {
                if (config.this.t_ind > 0) {
                    View view2 = menuHolder.marcador;
                    view2.setBackgroundColor(Color.parseColor("#" + config.this.c_ind));
                }
                TextView textView2 = menuHolder.texto;
                textView2.setTextColor(Color.parseColor("#" + config.this.c_secc_activ));
            }
            menuHolder.texto.setText(menuOpcion.texto);
            if (config.this.hay_icosmenu) {
                if (menuOpcion.img_cargando) {
                    menuHolder.pb.setVisibility(0);
                    menuHolder.img.setImageDrawable(config.this.getResources().getDrawable(R.drawable.pixel500por1));
                } else {
                    menuHolder.pb.setVisibility(8);
                    if (menuOpcion.img != null) {
                        menuHolder.img.setImageBitmap(menuOpcion.img);
                    } else {
                        menuHolder.img.setImageDrawable(config.this.getResources().getDrawable(R.drawable.pixel500por1));
                    }
                }
            }
            return view;
        }
    }

    static void mostrar_error(Context context, String str, String str2, final String str3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true).setPositiveButton(context.getString(R.string.cerrar), (DialogInterface.OnClickListener) null).setMessage(str2);
        if (!str.equals("")) {
            builder.setTitle(str);
        }
        final AlertDialog create = builder.create();
        if (!str3.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + str3));
                }
            });
        }
        try {
            create.show();
        } catch (Exception unused) {
        }
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused2) {
        }
    }

    public static class cargarprivacidad_glob extends AsyncTask<String, Void, Byte> {
        Context c;
        String c_icos;
        String cbtn;
        ProgressDialog dialog_cargando;
        String result_http;

        public cargarprivacidad_glob(Context context, String str, String str2) {
            this.c = context;
            this.c_icos = str;
            this.cbtn = str2;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:19|18|22|23|(0)|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0095, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
            r1 = r6;
            r6 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x009f, code lost:
            r6.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a5, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0099 */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = stikerwap.appdys.config.PROTOC_GEN
                r6.append(r0)
                java.lang.String r0 = "privacy."
                r6.append(r0)
                java.lang.String r0 = stikerwap.appdys.config.DOM_EDROID
                r6.append(r0)
                java.lang.String r0 = "/privacy.php?desde_app=1&ida=3008836&idl="
                r6.append(r0)
                java.util.Locale r0 = java.util.Locale.getDefault()
                java.lang.String r0 = r0.getLanguage()
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                r0 = -1
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00a9 }
                r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x00a9 }
                r6 = 0
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0099 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0099 }
                r6 = 1
                r1.setDoInput(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r1.setReadTimeout(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r1.setRequestProperty(r6, r2)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.io.InputStream r6 = r1.getInputStream()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r6.<init>()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            L_0x005b:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                if (r3 == 0) goto L_0x0076
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r4.<init>()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r4.append(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r6.append(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                goto L_0x005b
            L_0x0076:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r5.result_http = r6     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r2 = "@EURO@"
                java.lang.String r3 = "€"
                java.lang.String r6 = r6.replace(r2, r3)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r5.result_http = r6     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                if (r1 == 0) goto L_0x008b
                r1.disconnect()
            L_0x008b:
                r6 = 0
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            L_0x0091:
                r6 = move-exception
                goto L_0x00a3
            L_0x0093:
                r6 = r1
                goto L_0x0099
            L_0x0095:
                r0 = move-exception
                r1 = r6
                r6 = r0
                goto L_0x00a3
            L_0x0099:
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x0095 }
                if (r6 == 0) goto L_0x00a2
                r6.disconnect()
            L_0x00a2:
                return r0
            L_0x00a3:
                if (r1 == 0) goto L_0x00a8
                r1.disconnect()
            L_0x00a8:
                throw r6
            L_0x00a9:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.cargarprivacidad_glob.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(this.c);
            this.dialog_cargando = progressDialog;
            progressDialog.setMessage(this.c.getString(R.string.cargando));
            this.dialog_cargando.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !this.c_icos.equals("")) {
                this.dialog_cargando.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) cargarprivacidad_glob.this.dialog_cargando.findViewById(16908301), cargarprivacidad_glob.this.c_icos);
                    }
                });
            }
            this.dialog_cargando.show();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                this.dialog_cargando.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() != 0) {
                Context context = this.c;
                config.mostrar_error(context, context.getString(R.string.error_http_tit), this.c.getString(R.string.error_http), this.cbtn);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
            builder.setMessage(Html.fromHtml(this.result_http));
            builder.setCancelable(true);
            builder.setPositiveButton(this.c.getString(R.string.cerrar), (DialogInterface.OnClickListener) null);
            if (config.privacy_incluir_adsconsent) {
                builder.setNeutralButton(R.string.ads_privacy, new DialogInterface.OnClickListener() {
                    static /* synthetic */ void lambda$onClick$0(FormError formError) {
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            UserMessagingPlatform.showPrivacyOptionsForm((Activity) cargarprivacidad_glob.this.c, new config$cargarprivacidad_glob$2$$ExternalSyntheticLambda0());
                        } catch (Exception unused) {
                        }
                    }
                });
            }
            final AlertDialog create = builder.create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + cargarprivacidad_glob.this.cbtn));
                        if (config.privacy_incluir_adsconsent) {
                            Button button2 = create.getButton(-3);
                            button2.setTextColor(Color.parseColor("#" + cargarprivacidad_glob.this.cbtn));
                        }
                    }
                });
            }
            try {
                create.show();
            } catch (Exception unused2) {
            }
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused3) {
            }
        }
    }

    public static void anyadir_privado(Context context, String str, String str2) {
        int i = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        boolean z = false;
        int i2 = 0;
        while (!z && i2 < 100) {
            z = sharedPreferences.getString("privado" + i2 + "_id", "").equals(str);
            i2++;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!z) {
            while (!z && i < 100) {
                if (!sharedPreferences.contains("privado" + i + "_id")) {
                    edit.putString("privado" + i + "_id", str);
                    edit.putString("privado" + i + "_nombre", str2);
                    edit.putLong("privado" + i + "_fultconex", System.currentTimeMillis());
                    z = true;
                }
                i++;
            }
        } else {
            int i3 = i2 - 1;
            edit.putString("privado" + i3 + "_id", str);
            edit.putString("privado" + i3 + "_nombre", str2);
            edit.putLong("privado" + i3 + "_fultconex", System.currentTimeMillis());
        }
        edit.commit();
    }

    public static void elim_privado(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        int i = 0;
        while (!z && i < 100) {
            if (sharedPreferences.getString("privado" + i + "_id", "").equals(str)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("privado" + i + "_id");
                edit.commit();
                z = true;
            }
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public void f_ban(Context context, ImageView imageView, final String str) {
        final AlertDialog alertDialog;
        final SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        final long j = sharedPreferences.getLong("idusu", 0);
        final String string = sharedPreferences.getString("cod", "");
        final String str2 = (String) imageView.getTag(R.id.idaux1);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (sharedPreferences.getBoolean("ban_" + str2, false)) {
            alertDialog = builder.setPositiveButton(R.string.aceptar, (DialogInterface.OnClickListener) null).setMessage(R.string.usu_yareportado).create();
        } else {
            final Context context2 = context;
            alertDialog = builder.setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    config.mostrar_toast(Toast.makeText(context2, config.this.getResources().getString(R.string.enviando), 0));
                    config.elim_privado(context2, str2);
                    new t_chat.eliminar_usu(str2, j, string, context2).execute(new String[0]);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("ban_" + str2, true);
                    edit.commit();
                    t_chat.ocultar_frases(context2, str2);
                }
            }).setMessage(getResources().getString(R.string.confirmar_elimcontent)).create();
        }
        if (!str.equals("")) {
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = alertDialog.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + str));
                    Button button2 = alertDialog.getButton(-2);
                    if (button2 != null) {
                        button2.setTextColor(Color.parseColor("#" + str));
                    }
                }
            });
        }
        alertDialog.show();
        try {
            ((TextView) alertDialog.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void tratar_fondo(ImageView imageView, Boolean bool, int i) {
        RelativeLayout.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        if (imageView.getParent() instanceof LinearLayout) {
            if (i == 0) {
                layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
            }
            if (bool.booleanValue()) {
                int dp_to_px = dp_to_px(this, 10);
                layoutParams3.setMargins(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
            }
            imageView.setLayoutParams(layoutParams3);
        } else if (imageView.getParent() instanceof FrameLayout) {
            if (i == 0) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            } else {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            if (bool.booleanValue()) {
                int dp_to_px2 = dp_to_px(this, 10);
                layoutParams2.setMargins(dp_to_px2, dp_to_px2, dp_to_px2, dp_to_px2);
            }
            layoutParams2.gravity = 17;
            imageView.setLayoutParams(layoutParams2);
        } else if (imageView.getParent() instanceof RelativeLayout) {
            if (i == 0) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            if (bool.booleanValue()) {
                int dp_to_px3 = dp_to_px(this, 10);
                layoutParams.setMargins(dp_to_px3, dp_to_px3, dp_to_px3, dp_to_px3);
            }
            layoutParams.addRule(13, -1);
            imageView.setLayoutParams(layoutParams);
        } else {
            return;
        }
        if (i == 2) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (i == 3) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public static String convertir_fecha(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyHHmm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
        try {
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("ddMMyyHHmm");
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(parse);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String convertir_fecha_inv(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyHHmm");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("ddMMyyHHmm");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
            return simpleDateFormat2.format(parse);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static void progress_color(ProgressBar progressBar, String str) {
        if (Build.VERSION.SDK_INT >= 21 && str != null && !str.equals("") && !str.equals("#")) {
            int[][] iArr = {new int[]{16842910}, new int[]{-16842910}, new int[]{-16842912}, new int[]{16842919}};
            progressBar.setIndeterminateTintList(new ColorStateList(iArr, new int[]{Color.parseColor("#" + str), Color.parseColor("#" + str), Color.parseColor("#" + str), Color.parseColor("#" + str)}));
        }
    }

    public static void edittext_color(EditText editText, Boolean bool, String str) {
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT >= 21 && str != null && !str.equals("") && !str.equals("#")) {
            if (bool.booleanValue()) {
                str2 = "FFFFFF";
                str3 = "FAFAFA";
            } else {
                str2 = "000000";
                str3 = "212121";
            }
            editText.setTextColor(Color.parseColor("#".concat(str2)));
            int[][] iArr = {new int[]{16842908}, new int[]{-16842908}};
            editText.setBackgroundTintList(new ColorStateList(iArr, new int[]{Color.parseColor("#" + str), Color.parseColor("#".concat(str3))}));
        }
    }

    public static void textinputlayout_color(TextInputLayout textInputLayout, Boolean bool, String str) {
        if (Build.VERSION.SDK_INT >= 21 && str != null && !str.equals("") && !str.equals("#")) {
            String str2 = bool.booleanValue() ? "FFFFFF" : "000000";
            textInputLayout.setHintTextColor(ColorStateList.valueOf(Color.parseColor("#".concat(str2))));
            textInputLayout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#".concat(str2))));
            textInputLayout.setBoxStrokeColor(Color.parseColor("#".concat(str2)));
            EditText editText = textInputLayout.getEditText();
            editText.setTextColor(Color.parseColor("#".concat(str2)));
            editText.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    public static void checkbox_color(CheckBox checkBox, String str) {
        if (Build.VERSION.SDK_INT >= 21 && str != null && !str.equals("") && !str.equals("#")) {
            int[][] iArr = {new int[]{16842908}, new int[]{-16842908}};
            checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{Color.parseColor("#" + str), Color.parseColor("#" + str)}));
        }
    }

    public static void aplicar_color_top(Activity activity, String str) {
        if (Build.VERSION.SDK_INT > 20) {
            float[] fArr = new float[3];
            Color.colorToHSV(Color.parseColor("#" + str), fArr);
            fArr[2] = fArr[2] * 0.8f;
            int HSVToColor = Color.HSVToColor(fArr);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(HSVToColor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c5 A[Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<stikerwap.appdys.rss_item> tratar_rss(java.io.InputStream r16) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r2 = 1
            r0.setNamespaceAware(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            org.xmlpull.v1.XmlPullParser r3 = r0.newPullParser()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r4 = 0
            r0 = r16
            r3.setInput(r0, r4)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            int r0 = r3.getEventType()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r6 = "EEE, dd MMM yyyy HH:mm:ss Z"
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r5.<init>(r6, r7)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r6 = 3
            java.text.DateFormat r7 = java.text.SimpleDateFormat.getDateTimeInstance(r6, r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.text.DateFormat r8 = java.text.SimpleDateFormat.getDateInstance(r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.util.Calendar r9 = java.util.Calendar.getInstance()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r11 = -1
            r12 = r4
            r13 = -1
            r14 = 0
        L_0x0035:
            if (r0 == r2) goto L_0x0237
            if (r0 != 0) goto L_0x003b
            goto L_0x021b
        L_0x003b:
            java.lang.String r10 = "item"
            r15 = 2
            r2 = 4
            if (r0 != r15) goto L_0x00af
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x0054
            stikerwap.appdys.rss_item r12 = new stikerwap.appdys.rss_item     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r12.<init>()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r13 = 0
            r14 = 0
            goto L_0x021b
        L_0x0054:
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r10 = "title"
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x0064
            r13 = 1
            goto L_0x021b
        L_0x0064:
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r10 = "link"
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x0073
            r13 = 2
            goto L_0x021b
        L_0x0073:
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r10 = "pubDate"
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x0082
            r13 = 3
            goto L_0x021b
        L_0x0082:
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r10 = "description"
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x0091
            r13 = 4
            goto L_0x021b
        L_0x0091:
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r2 = "encoded"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x00ac
            java.lang.String r0 = r3.getPrefix()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r2 = "content"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x00ac
            r13 = 6
            goto L_0x021b
        L_0x00ac:
            r13 = 5
            goto L_0x021b
        L_0x00af:
            if (r0 != r6) goto L_0x00fc
            java.lang.String r0 = r3.getName()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x00f9
            java.lang.String r0 = r12.postDate     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == 0) goto L_0x00f4
            java.lang.String r0 = r12.postDate     // Catch:{ ParseException -> 0x00ee }
            java.lang.String r2 = "\\p{Cntrl}"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replaceAll(r2, r10)     // Catch:{ ParseException -> 0x00ee }
            java.util.Date r0 = r5.parse(r0)     // Catch:{ ParseException -> 0x00ee }
            r9.setTime(r0)     // Catch:{ ParseException -> 0x00ee }
            r2 = 11
            int r2 = r9.get(r2)     // Catch:{ ParseException -> 0x00ee }
            if (r2 != 0) goto L_0x00e7
            r2 = 12
            int r2 = r9.get(r2)     // Catch:{ ParseException -> 0x00ee }
            if (r2 != 0) goto L_0x00e7
            java.lang.String r0 = r8.format(r0)     // Catch:{ ParseException -> 0x00ee }
            r12.postDate = r0     // Catch:{ ParseException -> 0x00ee }
            goto L_0x00f4
        L_0x00e7:
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x00ee }
            r12.postDate = r0     // Catch:{ ParseException -> 0x00ee }
            goto L_0x00f4
        L_0x00ee:
            r0 = move-exception
            r12.postDate = r4     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r0.printStackTrace()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
        L_0x00f4:
            r1.add(r12)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            goto L_0x021b
        L_0x00f9:
            r13 = 0
            goto L_0x021b
        L_0x00fc:
            if (r0 != r2) goto L_0x021b
            java.lang.String r0 = r3.getText()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r0 = r0.trim()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r12 == 0) goto L_0x021b
            switch(r13) {
                case 1: goto L_0x01fe;
                case 2: goto L_0x01e8;
                case 3: goto L_0x01d2;
                case 4: goto L_0x0113;
                case 5: goto L_0x010d;
                case 6: goto L_0x011b;
                default: goto L_0x010b;
            }     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
        L_0x010b:
            goto L_0x021b
        L_0x010d:
            java.lang.String r2 = r12.postThumbUrl     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x0113
            goto L_0x021b
        L_0x0113:
            java.lang.String r2 = r12.postThumbUrl     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x011b
            if (r14 == 0) goto L_0x011b
            goto L_0x021b
        L_0x011b:
            int r2 = r0.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x021b
            java.lang.String r2 = ".jpg"
            int r2 = r0.indexOf(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r10 = ".png"
            int r10 = r0.indexOf(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r15 = 999999(0xf423f, float:1.401297E-39)
            if (r2 != r11) goto L_0x0135
            r2 = 999999(0xf423f, float:1.401297E-39)
        L_0x0135:
            if (r10 != r11) goto L_0x013a
            r10 = 999999(0xf423f, float:1.401297E-39)
        L_0x013a:
            int r2 = java.lang.Math.min(r2, r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == r15) goto L_0x021b
            int r10 = r2 + 1
            java.lang.String r10 = r0.substring(r2, r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r4 = r2
        L_0x0147:
            r6 = 1
            if (r4 <= r6) goto L_0x016c
            java.lang.String r6 = "'"
            boolean r6 = r10.equals(r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r6 != 0) goto L_0x016b
            java.lang.String r6 = "\""
            boolean r6 = r10.equals(r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r6 != 0) goto L_0x016b
            java.lang.String r6 = "="
            boolean r6 = r10.equals(r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r6 != 0) goto L_0x016b
            int r4 = r4 + -1
            int r6 = r4 + 1
            java.lang.String r10 = r0.substring(r4, r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            goto L_0x0147
        L_0x016b:
            r6 = 1
        L_0x016c:
            if (r4 <= r6) goto L_0x021b
            int r4 = r4 + 1
            int r2 = r2 + 4
            java.lang.String r4 = r0.substring(r4, r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r10 = "http"
            boolean r10 = r4.startsWith(r10)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r10 == 0) goto L_0x021b
            java.lang.String r10 = "&gt;"
            int r10 = r0.indexOf(r10, r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r6 = ">"
            int r6 = r0.indexOf(r6, r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r10 != r11) goto L_0x018f
            r10 = 999999(0xf423f, float:1.401297E-39)
        L_0x018f:
            if (r6 != r11) goto L_0x0194
            r6 = 999999(0xf423f, float:1.401297E-39)
        L_0x0194:
            int r6 = java.lang.Math.min(r10, r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r6 == r15) goto L_0x01c2
            java.lang.String r0 = r0.substring(r2, r6)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r2 = "width=\"1\""
            int r2 = r0.indexOf(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == r11) goto L_0x01af
            java.lang.String r2 = "height=\"1\""
            int r2 = r0.indexOf(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 != r11) goto L_0x01c0
        L_0x01af:
            java.lang.String r2 = "width='1'"
            int r2 = r0.indexOf(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == r11) goto L_0x01c2
            java.lang.String r2 = "height='1'"
            int r0 = r0.indexOf(r2)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r0 == r11) goto L_0x01c2
        L_0x01c0:
            r6 = 0
            goto L_0x01c3
        L_0x01c2:
            r6 = 1
        L_0x01c3:
            if (r6 == 0) goto L_0x021b
            java.lang.String r0 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r4, r0)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r12.postThumbUrl = r0     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r0 = 6
            if (r13 != r0) goto L_0x021b
            r14 = 1
            goto L_0x021b
        L_0x01d2:
            int r2 = r0.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x021b
            java.lang.String r2 = r12.postDate     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x01e5
            java.lang.String r2 = r12.postDate     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            int r2 = r2.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 <= 0) goto L_0x01e5
            goto L_0x021b
        L_0x01e5:
            r12.postDate = r0     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            goto L_0x021b
        L_0x01e8:
            int r2 = r0.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x021b
            java.lang.String r2 = r12.postLink     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x01fb
            java.lang.String r2 = r12.postLink     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            int r2 = r2.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 <= 0) goto L_0x01fb
            goto L_0x021b
        L_0x01fb:
            r12.postLink = r0     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            goto L_0x021b
        L_0x01fe:
            int r2 = r0.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x021b
            java.lang.String r2 = r12.postTitle     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 == 0) goto L_0x0211
            java.lang.String r2 = r12.postTitle     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            int r2 = r2.length()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            if (r2 <= 0) goto L_0x0211
            goto L_0x021b
        L_0x0211:
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            java.lang.String r0 = r0.toString()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r12.postTitle = r0     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
        L_0x021b:
            int r0 = r3.next()     // Catch:{ MalformedURLException -> 0x0233, IOException -> 0x022e, XmlPullParserException -> 0x0229, ParseException -> 0x0224 }
            r2 = 1
            r4 = 0
            r6 = 3
            goto L_0x0035
        L_0x0224:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0237
        L_0x0229:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0237
        L_0x022e:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0237
        L_0x0233:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0237:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.tratar_rss(java.io.InputStream):java.util.ArrayList");
    }

    public static Intent completar_externo(Intent intent, Bundle bundle) {
        intent.putExtra("externo", true);
        intent.putExtra("idchat", bundle.getInt("idchat"));
        intent.putExtra("idtema", bundle.getInt("idtema"));
        intent.putExtra("fotos_perfil", bundle.getInt("fotos_perfil"));
        intent.putExtra("fnac", bundle.getInt("fnac"));
        intent.putExtra("sexo", bundle.getInt("sexo"));
        intent.putExtra("descr", bundle.getInt("descr"));
        intent.putExtra("dist", bundle.getInt("dist"));
        intent.putExtra("privados", bundle.getBoolean("privados"));
        intent.putExtra("coments", bundle.getBoolean("coments"));
        intent.putExtra("galeria", bundle.getBoolean("galeria"));
        intent.putExtra("fotos_chat", bundle.getInt("fotos_chat"));
        intent.putExtra("c1", bundle.getString("c1"));
        intent.putExtra("c2", bundle.getString("c2"));
        return intent;
    }

    public static class modif_usuchat extends AsyncTask<String, Void, Byte> {
        String campo;
        String codigo;
        int idchat;
        long idusu;
        int modo;

        modif_usuchat(long j, String str, int i, String str2, int i2) {
            this.idusu = j;
            this.codigo = str;
            this.idchat = i;
            this.campo = str2;
            this.modo = i2;
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 100000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/modif_usuchats.php?idusu=" + this.idusu + "&c=" + this.codigo + "&idchat=" + this.idchat + "&campo=" + this.campo + "&modo=" + this.modo);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                if (sb.indexOf("ANDROID:OK") != -1) {
                    return (byte) 1;
                }
                return (byte) 0;
            } catch (Exception unused) {
                return (byte) 0;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            b.byteValue();
        }
    }

    public static class enviar_sinresp extends AsyncTask<String, Void, Boolean> {
        String ua;
        String url;

        enviar_sinresp(String str, String str2) {
            this.url = str;
            this.ua = str2;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(this.url);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                String str = this.ua;
                if (str != null) {
                    httpPost.setHeader("User-Agent", str);
                }
                defaultHttpClient.execute(httpPost);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public static Bitmap crop(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        if (i == 1) {
            i = 5;
        } else if (i == 2) {
            i = 10;
        } else if (i == 3) {
            i = 20;
        }
        float f = (float) i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap getCircularBitmapWithWhiteBorder(Bitmap bitmap, int i) {
        int i2;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                int i3 = 0;
                if (bitmap.getWidth() > bitmap.getHeight()) {
                    i3 = (bitmap.getWidth() / 2) - (min / 2);
                    i2 = 0;
                } else {
                    i2 = (bitmap.getHeight() / 2) - (min / 2);
                }
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, i3, i2, min, min);
                int width = createBitmap.getWidth() + i;
                int height = createBitmap.getHeight() + i;
                Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setShader(bitmapShader);
                Canvas canvas = new Canvas(createBitmap2);
                float f = (width > height ? (float) height : (float) width) / 2.0f;
                canvas.drawCircle((float) (width / 2), (float) (height / 2), f, paint);
                paint.setShader((Shader) null);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(-12303292);
                paint.setStrokeWidth((float) i);
                canvas.drawCircle((float) (width / 2), (float) (height / 2), f - ((float) (i / 2)), paint);
                return createBitmap2;
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    static void confirmar_exit(Context context) {
        mostrar_toast(Toast.makeText(context, R.string.confirm_exit, 0));
    }

    /* access modifiers changed from: package-private */
    public void onCreate_global(Context context, boolean z) {
        FragmentActivity_ext_class fragmentActivity_ext_class;
        Activity_ext_class activity_ext_class;
        int i;
        Seccion[] seccionArr;
        int i2;
        Context context2 = context;
        Seccion seccion = null;
        if (z) {
            activity_ext_class = null;
            fragmentActivity_ext_class = (FragmentActivity_ext_class) context2;
        } else {
            fragmentActivity_ext_class = null;
            activity_ext_class = (Activity_ext_class) context2;
        }
        int i3 = this.ind_secc_sel_2;
        int i4 = 0;
        if (i3 > -1 && (seccionArr = this.secciones_a) != null && i3 < seccionArr.length) {
            int i5 = 0;
            while (true) {
                Seccion[] seccionArr2 = this.secciones_a;
                if (i5 >= seccionArr2.length) {
                    break;
                } else if (seccionArr2[i5].tipo == 22) {
                    seccion = this.secciones_a[i5];
                    break;
                } else {
                    i5++;
                }
            }
            if (!(seccion == null || (i2 = this.secciones_a[this.ind_secc_sel_2].tipo) == 22 || ((i2 == 12 && !seccion.incl_submenu) || (i2 == 14 && !seccion.incl_card)))) {
                String str = this.secciones_a[this.ind_secc_sel_2].id + "";
                SharedPreferences sharedPreferences = context2.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                String[] split = sharedPreferences.getString("seccs_ultimas", "").split(",");
                String str2 = str;
                int i6 = 0;
                while (i6 < split.length && i6 < 7) {
                    if (!split[i6].equals(str)) {
                        str2 = str2 + "," + split[i6];
                    }
                    i6++;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("seccs_ultimas", str2);
                edit.apply();
            }
        }
        if (mb_items.length > 0) {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) ((Activity) context2).findViewById(R.id.navigation_b);
            if (!mb_c_bg.equals("") && !mb_c_items.equals("")) {
                bottomNavigationView.setBackgroundColor(Color.parseColor("#" + mb_c_bg));
                int parseColor = Color.parseColor("#" + mb_c_items);
                StringBuilder sb = new StringBuilder("#");
                sb.append(mb_c_bg);
                ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842913}, new int[]{16842910}}, new int[]{canviarColor(parseColor, 0.4f, esClaro(sb.toString()) ? 2 : 1), parseColor});
                bottomNavigationView.setItemTextColor(colorStateList);
                bottomNavigationView.setItemIconTintList(colorStateList);
            }
            bottomNavigationView.getMenu().clear();
            int i7 = 0;
            while (i7 < mb_items.length) {
                bottomNavigationView.getMenu().add(i4, mb_items[i7].id, i4, mb_items[i7].txt);
                if (mb_items[i7].img_v > 0) {
                    bottomNavigationView.getMenu().getItem(i7).setIcon(Drawable.createFromPath(context2.getFileStreamPath("ico_mb_it" + mb_items[i7].id).getAbsolutePath()));
                }
                mb_items[i7].menuitem = bottomNavigationView.getMenu().getItem(i7);
                MenuItem item = bottomNavigationView.getMenu().getItem(i7);
                final Context context3 = context;
                final boolean z2 = z;
                final FragmentActivity_ext_class fragmentActivity_ext_class2 = fragmentActivity_ext_class;
                AnonymousClass32 r11 = r0;
                final Activity_ext_class activity_ext_class2 = activity_ext_class;
                AnonymousClass32 r0 = new MenuItem.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int i = 0;
                        while (true) {
                            if (i >= config.mb_items.length) {
                                i = -1;
                                break;
                            } else if (config.mb_items[i].menuitem.getItemId() == menuItem.getItemId()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i == -1) {
                            return false;
                        }
                        mb_item mb_item = config.mb_items[i];
                        config.mb_item_sel = mb_item.menuitem.getItemId();
                        if (mb_item.idsecc > 0) {
                            View view = new View(context3);
                            int indexOf = config.secciones_alist.indexOf(Integer.valueOf(mb_item.idsecc));
                            view.setId(indexOf);
                            view.setTag(R.id.TAG_IDSECC, Integer.valueOf(indexOf));
                            if (z2) {
                                if (config.this.appnext_rew_cod != null && !config.this.appnext_rew_cod.equals("")) {
                                    fragmentActivity_ext_class2.mAd_appnext = new RewardedVideo((Context) (Activity) context3, config.this.appnext_rew_cod);
                                }
                                if (config.this.admob_rew_cod != null) {
                                    config.this.admob_rew_cod.equals("");
                                }
                                if (config.this.fb_rew_cod != null && !config.this.fb_rew_cod.equals("")) {
                                    fragmentActivity_ext_class2.mAd_fb = new RewardedVideoAd((Activity) context3, config.this.fb_rew_cod);
                                }
                                if (config.this.st_rew_cod != null && !config.this.st_rew_cod.equals("")) {
                                    fragmentActivity_ext_class2.mAd_st = new StartAppAd((Activity) context3);
                                }
                                fragmentActivity_ext_class2.dialog_cargando = new ProgressDialog((Activity) context3);
                                fragmentActivity_ext_class2.v_abrir_secc = view;
                                if (!config.this.rewarded(context3, view, fragmentActivity_ext_class2.cbtn, fragmentActivity_ext_class2.dialog_cargando, fragmentActivity_ext_class2.ralc, fragmentActivity_ext_class2.mAd_appnext, fragmentActivity_ext_class2.mAd_fb, fragmentActivity_ext_class2.mAd_st, (View) null)) {
                                    ((Activity_ext) context3).abrir_secc(view);
                                }
                            } else {
                                if (config.this.appnext_rew_cod != null && !config.this.appnext_rew_cod.equals("")) {
                                    activity_ext_class2.mAd_appnext = new RewardedVideo((Context) (Activity) context3, config.this.appnext_rew_cod);
                                }
                                if (config.this.admob_rew_cod != null) {
                                    config.this.admob_rew_cod.equals("");
                                }
                                if (config.this.fb_rew_cod != null && !config.this.fb_rew_cod.equals("")) {
                                    activity_ext_class2.mAd_fb = new RewardedVideoAd((Activity) context3, config.this.fb_rew_cod);
                                }
                                if (config.this.st_rew_cod != null && !config.this.st_rew_cod.equals("")) {
                                    activity_ext_class2.mAd_st = new StartAppAd((Activity) context3);
                                }
                                activity_ext_class2.dialog_cargando = new ProgressDialog((Activity) context3);
                                activity_ext_class2.v_abrir_secc = view;
                                if (!config.this.rewarded(context3, view, activity_ext_class2.cbtn, activity_ext_class2.dialog_cargando, activity_ext_class2.ralc, activity_ext_class2.mAd_appnext, activity_ext_class2.mAd_fb, activity_ext_class2.mAd_st, (View) null)) {
                                    ((Activity_ext) context3).abrir_secc(view);
                                }
                            }
                        } else if (!mb_item.url.equals("")) {
                            if (!mb_item.externo.booleanValue()) {
                                String str = mb_item.url;
                                ResultGetIntent intent_porURL = config.this.getIntent_porURL(str, context3);
                                if (!(intent_porURL.i == null || intent_porURL.i.getAction() == null || !intent_porURL.i.getAction().equals("android.intent.action.VIEW"))) {
                                    Intent intent = new Intent(context3, t_url.class);
                                    intent.putExtra("url", str);
                                    intent_porURL.i = intent;
                                }
                                if (intent_porURL.finalizar) {
                                    if (z2) {
                                        fragmentActivity_ext_class2.finalizar = true;
                                    } else {
                                        activity_ext_class2.finalizar = true;
                                    }
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("finalizar", true);
                                    intent2.putExtra("finalizar_app", intent_porURL.finalizar_app);
                                    ((Activity) context3).setResult(-1, intent2);
                                }
                                if (z2) {
                                    if (intent_porURL.esmas) {
                                        ((Activity) context3).startActivityForResult(intent_porURL.i, 0);
                                    } else if (intent_porURL.i != null) {
                                        if (intent_porURL.finalizar) {
                                            fragmentActivity_ext_class2.es_root = false;
                                            if (config.this.tipomenu != 2) {
                                                intent_porURL.i.putExtra("es_root", true);
                                            }
                                            try {
                                                ((Activity) context3).startActivity(intent_porURL.i);
                                            } catch (Exception unused) {
                                            }
                                        } else {
                                            ((Activity) context3).startActivityForResult(intent_porURL.i, 0);
                                        }
                                    }
                                    if (fragmentActivity_ext_class2.finalizar && !fragmentActivity_ext_class2.buscador_on) {
                                        ((Activity) context3).finish();
                                    }
                                } else {
                                    if (intent_porURL.esmas) {
                                        ((Activity) context3).startActivityForResult(intent_porURL.i, 0);
                                    } else if (intent_porURL.i != null) {
                                        if (intent_porURL.finalizar) {
                                            activity_ext_class2.es_root = false;
                                            if (config.this.tipomenu != 2) {
                                                intent_porURL.i.putExtra("es_root", true);
                                            }
                                            try {
                                                ((Activity) context3).startActivity(intent_porURL.i);
                                            } catch (Exception unused2) {
                                            }
                                        } else {
                                            ((Activity) context3).startActivityForResult(intent_porURL.i, 0);
                                        }
                                    }
                                    if (activity_ext_class2.finalizar && !activity_ext_class2.buscador_on) {
                                        ((Activity) context3).finish();
                                    }
                                }
                            } else {
                                ResultGetIntent intent_porURL2 = config.this.getIntent_porURL(mb_item.url, context3);
                                if (intent_porURL2.finalizar) {
                                    if (z2) {
                                        fragmentActivity_ext_class2.finalizar = true;
                                    } else {
                                        activity_ext_class2.finalizar = true;
                                    }
                                    Intent intent3 = new Intent();
                                    intent3.putExtra("finalizar", true);
                                    intent3.putExtra("finalizar_app", intent_porURL2.finalizar_app);
                                    ((Activity) context3).setResult(-1, intent3);
                                }
                                if (z2) {
                                    if (intent_porURL2.esmas) {
                                        ((Activity) context3).startActivityForResult(intent_porURL2.i, 0);
                                    } else if (intent_porURL2.i != null) {
                                        if (intent_porURL2.finalizar) {
                                            fragmentActivity_ext_class2.es_root = false;
                                            if (config.this.tipomenu != 2) {
                                                intent_porURL2.i.putExtra("es_root", true);
                                            }
                                            try {
                                                ((Activity) context3).startActivity(intent_porURL2.i);
                                            } catch (Exception unused3) {
                                            }
                                        } else {
                                            ((Activity) context3).startActivityForResult(intent_porURL2.i, 0);
                                        }
                                    }
                                    if (fragmentActivity_ext_class2.finalizar && !fragmentActivity_ext_class2.buscador_on) {
                                        ((Activity) context3).finish();
                                    }
                                } else {
                                    if (intent_porURL2.esmas) {
                                        ((Activity) context3).startActivityForResult(intent_porURL2.i, 0);
                                    } else if (intent_porURL2.i != null) {
                                        if (intent_porURL2.finalizar) {
                                            activity_ext_class2.es_root = false;
                                            if (config.this.tipomenu != 2) {
                                                intent_porURL2.i.putExtra("es_root", true);
                                            }
                                            try {
                                                ((Activity) context3).startActivity(intent_porURL2.i);
                                            } catch (Exception unused4) {
                                            }
                                        } else {
                                            ((Activity) context3).startActivityForResult(intent_porURL2.i, 0);
                                        }
                                    }
                                    if (activity_ext_class2.finalizar && !activity_ext_class2.buscador_on) {
                                        ((Activity) context3).finish();
                                    }
                                }
                            }
                        }
                        return true;
                    }
                };
                item.setOnMenuItemClickListener(r11);
                i7++;
                i4 = 0;
            }
            if (mb_item_sel != -1) {
                bottomNavigationView.getMenu().findItem(mb_item_sel).setChecked(true);
                mb_item_sel = -1;
                i = 0;
            } else {
                i = 0;
                bottomNavigationView.getMenu().setGroupCheckable(0, true, false);
                for (int i8 = 0; i8 < bottomNavigationView.getMenu().size(); i8++) {
                    bottomNavigationView.getMenu().getItem(i8).setChecked(false);
                }
                bottomNavigationView.getMenu().setGroupCheckable(0, true, true);
            }
            bottomNavigationView.setVisibility(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        r1 = (android.widget.HorizontalScrollView) r0.findViewById(stikerwap.appdys.R.id.hsv_menu);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void onResume_global(android.content.Context r5) {
        /*
            boolean r0 = finalizar_app
            if (r0 == 0) goto L_0x000a
            r0 = r5
            android.app.Activity r0 = (android.app.Activity) r0
            r0.finish()
        L_0x000a:
            r0 = r5
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131361908(0x7f0a0074, float:1.8343582E38)
            android.view.View r2 = r0.findViewById(r1)
            if (r2 == 0) goto L_0x001f
            android.view.View r1 = r0.findViewById(r1)
            r2 = 8
            r1.setVisibility(r2)
        L_0x001f:
            mostrar_notif_noleidas(r5)
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x0029 }
            stikerwap.appdys.config r5 = (stikerwap.appdys.config) r5     // Catch:{ Exception -> 0x0029 }
            goto L_0x002a
        L_0x0029:
            r5 = 0
        L_0x002a:
            if (r5 == 0) goto L_0x0060
            java.lang.String r1 = r5.c1
            if (r1 == 0) goto L_0x0060
            int r1 = r5.tipomenu
            if (r1 != 0) goto L_0x0060
            int r1 = r5.t_mas
            r2 = 3
            if (r1 != r2) goto L_0x0060
            r1 = 2131362353(0x7f0a0231, float:1.8344484E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.HorizontalScrollView r1 = (android.widget.HorizontalScrollView) r1
            if (r1 == 0) goto L_0x0060
            java.util.Map<java.lang.Integer, java.lang.Boolean> r2 = hsv_situado
            int r3 = r0.hashCode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r2.put(r3, r4)
            stikerwap.appdys.config$33 r2 = new stikerwap.appdys.config$33     // Catch:{ Exception -> 0x005f }
            r2.<init>(r1)     // Catch:{ Exception -> 0x005f }
            r1.post(r2)     // Catch:{ Exception -> 0x005f }
            goto L_0x0060
        L_0x005f:
        L_0x0060:
            if (r5 == 0) goto L_0x006f
            java.lang.String r5 = r5.is_appid
            java.lang.String r1 = ""
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x006f
            com.ironsource.mediationsdk.IronSource.onResume(r0)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.onResume_global(android.content.Context):void");
    }

    static void onPause_global(Context context) {
        config config;
        try {
            config = (config) context.getApplicationContext();
        } catch (Exception unused) {
            config = null;
        }
        if (config != null && !config.is_appid.equals("")) {
            IronSource.onPause((Activity) context);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult_glob(int i, int i2, Intent intent, Context context) {
        String str;
        String str2;
        if (i == 111) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            long j = sharedPreferences.getLong("idusu", 0);
            String string = sharedPreferences.getString("cod_g", "");
            try {
                str2 = ((Activity_ext_class) context).cbtn;
            } catch (Exception unused) {
                try {
                    str2 = ((FragmentActivity_ext_class) context).cbtn;
                } catch (Exception unused2) {
                    str = "";
                }
            }
            str = str2;
            new comprobar_pago_sinads(context, j, string, str, this.c_icos, true).execute(new String[0]);
        }
        return false;
    }

    static void finalizar_app(Context context) {
        try {
            config config = (config) context.getApplicationContext();
            if (config.radio_apagado == 2) {
                config.stop_radio();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void abrir_go(Context context, int i) {
        if (i != -1) {
            ((Activity) context).startActivityForResult(crear_rgi(Integer.valueOf(i), this).i, 0);
        }
    }

    static String aplicar_color_dialog(String str, String str2) {
        if (str == null || str2 == null || str.equals("") || str2.equals("") || Build.VERSION.SDK_INT <= 20) {
            return "";
        }
        if (esMuyClaro("#" + str2)) {
            if (esMuyClaro("#" + str)) {
                return "FF000000";
            }
        }
        if (esMuyOscuro("#" + str2)) {
            if (esMuyOscuro("#" + str)) {
                return "FFFFFFFF";
            }
        }
        return str2;
    }

    public static boolean hay_conn_rapida(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && isConnectionFast(activeNetworkInfo.getType(), activeNetworkInfo.getSubtype());
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: protected */
    public void setDefaultFont(Context context, String str, int i) {
        Typeface typeface;
        if (i == 0) {
            typeface = Typeface.defaultFromStyle(0);
        } else if (i == 1) {
            try {
                typeface = Typeface.createFromFile(new File(getFilesDir(), "font"));
            } catch (Exception unused) {
                typeface = Typeface.defaultFromStyle(0);
            }
        } else {
            String obtenerFuente = obtenerFuente(i);
            if (obtenerFuente.equals("")) {
                typeface = Typeface.defaultFromStyle(0);
            } else {
                AssetManager assets = context.getAssets();
                typeface = Typeface.createFromAsset(assets, "fonts/" + obtenerFuente);
            }
        }
        replaceFont(str, typeface);
    }

    /* access modifiers changed from: protected */
    public void replaceFont(String str, Typeface typeface) {
        try {
            Field declaredField = Typeface.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set((Object) null, typeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void establecerFuente(int i) {
        if (tf_monospace == null) {
            tf_monospace = Typeface.create(Typeface.MONOSPACE, 0);
            tf_serif = Typeface.create(Typeface.SERIF, 0);
            tf_sans_serif = Typeface.create(Typeface.SANS_SERIF, 0);
        }
        setDefaultFont(this, "DEFAULT", i);
        setDefaultFont(this, "MONOSPACE", i);
        setDefaultFont(this, "SERIF", i);
        setDefaultFont(this, "SANS_SERIF", i);
    }

    static void mostrar_toast(Toast toast) {
        try {
            ((TextView) ((ViewGroup) toast.getView()).getChildAt(0)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
        toast.show();
    }

    /* access modifiers changed from: package-private */
    public ResultGetIntent getIntent_porURL(String str, Context context) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String lowerCase = str.toLowerCase();
        String[] strArr = {"offices", "share", "search", "products", "exit", "notifications", Scopes.PROFILE, "noads"};
        int i = 0;
        while (i < 8) {
            String str9 = strArr[i];
            if (!lowerCase.startsWith("action_" + str9)) {
                if (!lowerCase.startsWith("http://action_" + str9)) {
                    i++;
                }
            }
            View view = new View(context);
            view.setTag(R.id.TAG_ACCION, str9);
            return getIntent(view, context);
        }
        ResultGetIntent resultGetIntent = new ResultGetIntent();
        resultGetIntent.finalizar = false;
        resultGetIntent.finalizar_app = false;
        resultGetIntent.esmas = false;
        if (lowerCase.startsWith("tel:") || lowerCase.startsWith("http://tel:")) {
            if (lowerCase.startsWith("tel:")) {
                str2 = str.substring(4);
            } else {
                str2 = str.substring(11);
            }
            if (str2.endsWith("/")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            resultGetIntent.i = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str2));
            return resultGetIntent;
        } else if (lowerCase.startsWith(MailTo.MAILTO_SCHEME) || lowerCase.startsWith("http://mailto:")) {
            if (lowerCase.startsWith(MailTo.MAILTO_SCHEME)) {
                str3 = str.substring(7).trim();
            } else {
                str3 = str.substring(14).trim();
            }
            if (!str3.equals("")) {
                int indexOf = str3.indexOf("?");
                if (indexOf > 0) {
                    int indexOf2 = str3.indexOf("?subject=");
                    if (indexOf2 != -1) {
                        str5 = str3.substring(indexOf2 + 9).trim();
                        int indexOf3 = str5.indexOf("&body=");
                        if (indexOf3 != -1) {
                            str4 = str5.substring(indexOf3 + 6).trim();
                            str5 = str5.substring(0, indexOf3).trim();
                        } else {
                            str4 = "";
                        }
                    } else {
                        str5 = "";
                        str4 = str5;
                    }
                    str3 = str3.substring(0, indexOf).trim();
                } else {
                    str5 = "";
                    str4 = str5;
                }
                if (str3.endsWith("/")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str3, (String) null));
                if (!str5.equals("")) {
                    try {
                        str5 = URLDecoder.decode(str5, "UTF-8");
                    } catch (Exception unused) {
                    }
                    intent.putExtra("android.intent.extra.SUBJECT", str5);
                }
                if (!str4.equals("")) {
                    try {
                        str4 = URLDecoder.decode(str4, "UTF-8");
                    } catch (Exception unused2) {
                    }
                    intent.putExtra("android.intent.extra.TEXT", str4);
                }
                resultGetIntent.i = Intent.createChooser(intent, getResources().getString(R.string.enviar_email));
                return resultGetIntent;
            }
            resultGetIntent.i = new Intent("android.intent.action.SENDTO", Uri.parse(str));
            return resultGetIntent;
        } else if (lowerCase.startsWith("smsto:") || lowerCase.startsWith("http://smsto:")) {
            if (lowerCase.startsWith("smsto:")) {
                str6 = str.substring(6).trim();
            } else {
                str6 = str.substring(13).trim();
            }
            if (!str6.equals("")) {
                int indexOf4 = str6.indexOf("?");
                if (indexOf4 > 0) {
                    int indexOf5 = str6.indexOf("?body=");
                    if (indexOf5 != -1) {
                        str7 = str6.substring(indexOf5 + 6).trim();
                    } else {
                        str7 = "";
                    }
                    str6 = str6.substring(0, indexOf4).trim();
                } else {
                    str7 = "";
                }
                if (str6.endsWith("/")) {
                    str6 = str6.substring(0, str6.length() - 1);
                }
                Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str6));
                if (!str7.equals("")) {
                    try {
                        str7 = URLDecoder.decode(str7, "UTF-8");
                    } catch (Exception unused3) {
                    }
                    intent2.putExtra("sms_body", str7);
                }
                resultGetIntent.i = intent2;
                return resultGetIntent;
            }
            resultGetIntent.i = new Intent("android.intent.action.SENDTO", Uri.parse(str));
            return resultGetIntent;
        } else if (lowerCase.startsWith("vnd.youtube:")) {
            int indexOf6 = str.indexOf("?");
            if (indexOf6 > 0) {
                str8 = str.substring(12, indexOf6);
            } else {
                str8 = str.substring(12);
            }
            String str10 = "https://www.youtube.com/watch?v=" + str8;
            resultGetIntent.i = new Intent("android.intent.action.VIEW", Uri.parse(str10));
            if (this.customtabs && abrir_con_nav(str10)) {
                Bundle bundle = new Bundle();
                bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                try {
                    bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, Color.parseColor("#" + this.c1));
                } catch (Exception unused4) {
                }
                resultGetIntent.i.putExtras(bundle);
            }
            return resultGetIntent;
        } else if (lowerCase.endsWith(".mp3")) {
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setDataAndType(Uri.parse(str), "audio/*");
            resultGetIntent.i = intent3;
            return resultGetIntent;
        } else if (lowerCase.endsWith(".mp4") || lowerCase.endsWith(".3gp")) {
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.setDataAndType(Uri.parse(str), "video/*");
            resultGetIntent.i = intent4;
            return resultGetIntent;
        } else {
            resultGetIntent.i = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (this.customtabs && abrir_con_nav(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                try {
                    bundle2.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, Color.parseColor("#" + this.c1));
                } catch (Exception unused5) {
                }
                resultGetIntent.i.putExtras(bundle2);
            }
            return resultGetIntent;
        }
    }

    static boolean abrir_con_nav(String str) {
        return !str.startsWith("rtsp://") && !str.startsWith("rtmp://") && !str.startsWith("market://") && !str.startsWith("whatsapp://") && !str.startsWith("upi://") && !str.startsWith("http://www.appcreator24.com/open") && !str.startsWith("https://www.appcreator24.com/open") && !str.endsWith(".apk") && !str.endsWith(".m3u") && !str.endsWith(".m3u8") && !str.endsWith(".mp3") && !str.endsWith(".mp4") && !str.endsWith(".3gp");
    }

    static int crear_notif(Context context, String str, String str2, Intent intent, int i, int i2, String str3, String str4) {
        if (str3.equals((Object) null) || str3.equals("")) {
            str3 = "0";
        }
        if (str4.equals((Object) null) || str4.equals("")) {
            str4 = "0";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i3 = sharedPreferences.getInt("id_ultnotif", 0) + 1;
        intent.putExtra("idnotif_marcar", i3);
        edit.putInt("id_ultnotif", i3);
        edit.putBoolean("hatenidonotif", true);
        edit.putLong("notif_" + i3 + "_fcrea", System.currentTimeMillis());
        edit.putString("notif_" + i3 + "_title", str);
        edit.putString("notif_" + i3 + "_text", str2);
        edit.putString("notif_" + i3 + "_intent", intent.toUri(0));
        edit.putInt("notif_" + i3 + "_numnotif", i);
        edit.putBoolean("notif_" + i3 + "_leida", false);
        edit.putInt("notif_" + i3 + "_tipo", i2);
        edit.putString("notif_" + i3 + "_idusu1", str3);
        edit.putString("notif_" + i3 + "_idusu2", str4);
        if (i3 > 100) {
            StringBuilder sb = new StringBuilder("notif_");
            int i4 = i3 - 100;
            sb.append(i4);
            sb.append("_fcrea");
            edit.remove(sb.toString());
            edit.remove("notif_" + i4 + "_title");
            edit.remove("notif_" + i4 + "_text");
            edit.remove("notif_" + i4 + "_intent");
            edit.remove("notif_" + i4 + "_numnotif");
            edit.remove("notif_" + i4 + "_leida");
            edit.remove("notif_" + i4 + "_tipo");
            edit.remove("notif_" + i4 + "_idusu1");
            edit.remove("notif_" + i4 + "_idusu2");
        }
        edit.commit();
        act_notif_noleidas(context);
        return i3;
    }

    static void act_notif_noleidas(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i = 0;
        int i2 = 0;
        for (int i3 = sharedPreferences.getInt("id_ultnotif", 0); i3 > 0; i3--) {
            if (!sharedPreferences.getBoolean("notif_" + i3 + "_leida", false)) {
                i++;
            }
            i2++;
            if (i2 > 99) {
                break;
            }
        }
        edit.putInt("notif_noleidas", i);
        edit.commit();
    }

    static void mostrar_notif_noleidas(Context context) {
        int i;
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        int i2 = sharedPreferences.getInt("ico_notif_ord", 0);
        int i3 = i2 == 1 ? R.id.ico_tv_1 : i2 == 2 ? R.id.ico_tv_2 : i2 == 3 ? R.id.ico_tv_3 : i2 == 4 ? R.id.ico_tv_4 : 0;
        if (i3 > 0) {
            try {
                TextView textView = (TextView) ((Activity) context).findViewById(i3);
                int i4 = sharedPreferences.getInt("notif_noleidas", 0);
                if (i4 > 99) {
                    i4 = 99;
                }
                if (i4 <= 0 || sharedPreferences.getInt("ico_notif_idsec", 0) != 0) {
                    textView.setVisibility(8);
                    return;
                }
                int dp_to_px = dp_to_px(context, 3);
                if (i4 < 10) {
                    i = dp_to_px(context, 8);
                } else {
                    i = dp_to_px(context, 4);
                }
                textView.setPadding(i, dp_to_px, i, dp_to_px);
                textView.setText("" + i4);
                textView.setVisibility(0);
            } catch (Exception unused) {
            }
        }
    }

    static boolean existe_notif(Context context, int i, String str, String str2) {
        if (str.equals((Object) null) || str.equals("")) {
            str = "0";
        }
        if (str2.equals((Object) null) || str2.equals("")) {
            str2 = "0";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        int i2 = 0;
        for (int i3 = sharedPreferences.getInt("id_ultnotif", 0); i3 > 0; i3--) {
            if (!sharedPreferences.getBoolean("notif_" + i3 + "_leida", false)) {
                if (sharedPreferences.getInt("notif_" + i3 + "_tipo", 0) == i) {
                    if (sharedPreferences.getString("notif_" + i3 + "_idusu1", "").equals(str)) {
                        if (sharedPreferences.getString("notif_" + i3 + "_idusu2", "").equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            i2++;
            if (i2 > 99) {
                return false;
            }
        }
        return false;
    }

    static void elim_notifs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i = 0;
        for (int i2 = sharedPreferences.getInt("id_ultnotif", 0); i2 > 0; i2--) {
            edit.remove("notif_" + i2 + "_fcrea");
            edit.remove("notif_" + i2 + "_title");
            edit.remove("notif_" + i2 + "_text");
            edit.remove("notif_" + i2 + "_intent");
            edit.remove("notif_" + i2 + "_numnotif");
            edit.remove("notif_" + i2 + "_leida");
            edit.remove("notif_" + i2 + "_tipo");
            edit.remove("notif_" + i2 + "_idusu1");
            edit.remove("notif_" + i2 + "_idusu2");
            i++;
            if (i > 99) {
                break;
            }
        }
        edit.putInt("id_ultnotif", 0);
        edit.putInt("notif_noleidas", 0);
        edit.commit();
        act_notif_noleidas(context);
    }

    static int dp_to_px(Context context, int i) {
        double d = (double) (((float) i) * context.getResources().getDisplayMetrics().density);
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    static float px_to_dp(Context context, float f) {
        return f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    static String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    public static String random_str(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("0123456789qwertyuiopasdfghjklzxcvbnm".charAt(random.nextInt(36)));
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void iniciar_pago_sinads(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        long j = sharedPreferences.getLong("idusu", 0);
        String string = sharedPreferences.getString("cod_g", "");
        Long valueOf = Long.valueOf(sharedPreferences.getLong("sinads_fhasta", 0));
        if (!sharedPreferences.getBoolean("sinads", false) || System.currentTimeMillis() >= valueOf.longValue()) {
            new comprobar_pago_sinads(context, j, string, str, this.c_icos, false).execute(new String[0]);
        } else {
            msg_sinads_pagado(valueOf, context, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void msg_sinads_pagado(Long l, Context context, final String str) {
        String string = getString(R.string.sinads_activado);
        if (l.longValue() < Long.parseLong("2524604400000")) {
            string = string + "(" + getString(R.string.hasta) + " " + DateFormat.getDateFormat(context).format(new Date(l.longValue())) + ")";
        }
        final AlertDialog create = new AlertDialog.Builder(context).setPositiveButton(R.string.aceptar, (DialogInterface.OnClickListener) null).setMessage(string).create();
        if (!str.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + str));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_pago_sinads(Context context, final String str) {
        String str2;
        String str3;
        final SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        final long j = sharedPreferences.getLong("idusu", 0);
        String str4 = this.precio_msg_sinads;
        if (str4 == null || str4.equals("")) {
            String str5 = getResources().getString(R.string.wallet_msg_1_sinads).replace("@X@", this.precio_sinads + " " + this.precio_divisa) + "\n\n" + getResources().getString(R.string.wallet_msg_2);
            int i = this.precio_time_sinads;
            if (i == 18000) {
                str2 = str5.replace("@Y@", getResources().getString(R.string.siempre));
            } else {
                if (i < 2161) {
                    str3 = (this.precio_time_sinads / 24) + " " + getResources().getString(R.string.dias);
                } else if (i == 8784) {
                    str3 = "1 " + getResources().getString(R.string.anyo);
                } else if (i == 17568) {
                    str3 = "2 " + getResources().getString(R.string.anyos);
                } else {
                    str3 = "";
                }
                if (str3 != "") {
                    str2 = str5.replace("@Y@", str3);
                } else {
                    return;
                }
            }
        } else {
            str2 = this.precio_msg_sinads;
        }
        final Context context2 = context;
        final AlertDialog create = new AlertDialog.Builder(context).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|7|8|11|12|13|14|16) */
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x003c, code lost:
                r8 = "";
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0024 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.content.DialogInterface r7, int r8) {
                /*
                    r6 = this;
                    java.lang.String r7 = "utf-8"
                    java.lang.String r8 = "https://pay."
                    android.content.SharedPreferences r0 = r4
                    android.content.SharedPreferences$Editor r0 = r0.edit()
                    java.lang.String r1 = "sinads_intentado"
                    r2 = 1
                    r0.putBoolean(r1, r2)
                    java.lang.String r1 = "sinads_comprobacionespago"
                    r2 = 0
                    r0.putInt(r1, r2)
                    r0.apply()
                    stikerwap.appdys.config r0 = stikerwap.appdys.config.this
                    java.lang.String r0 = r0.precio_email
                    java.lang.String r0 = java.net.URLEncoder.encode(r0, r7)     // Catch:{ Exception -> 0x0024 }
                L_0x0024:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c }
                    r1.<init>(r8)     // Catch:{ Exception -> 0x003c }
                    java.lang.String r8 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ Exception -> 0x003c }
                    r1.append(r8)     // Catch:{ Exception -> 0x003c }
                    java.lang.String r8 = "/srv/pay_item_sinads.php"
                    r1.append(r8)     // Catch:{ Exception -> 0x003c }
                    java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x003c }
                    java.lang.String r8 = java.net.URLEncoder.encode(r8, r7)     // Catch:{ Exception -> 0x003c }
                    goto L_0x003e
                L_0x003c:
                    java.lang.String r8 = ""
                L_0x003e:
                    stikerwap.appdys.config r1 = stikerwap.appdys.config.this     // Catch:{ Exception -> 0x004c }
                    r3 = 2131886655(0x7f12023f, float:1.9407895E38)
                    java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x004c }
                    java.lang.String r1 = java.net.URLEncoder.encode(r1, r7)     // Catch:{ Exception -> 0x004c }
                    goto L_0x004e
                L_0x004c:
                    java.lang.String r1 = "NoAds"
                L_0x004e:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r4 = "https://www.paypal.com/cgi-bin/webscr/?rm=2&cmd=_xclick&business="
                    r3.<init>(r4)
                    r3.append(r0)
                    java.lang.String r0 = "&amount="
                    r3.append(r0)
                    stikerwap.appdys.config r0 = stikerwap.appdys.config.this
                    java.lang.String r0 = r0.precio_sinads
                    r3.append(r0)
                    java.lang.String r0 = "&no_shipping=0&no_note=1&currency_code="
                    r3.append(r0)
                    stikerwap.appdys.config r0 = stikerwap.appdys.config.this
                    java.lang.String r0 = r0.precio_divisa
                    r3.append(r0)
                    java.lang.String r0 = "&bn=PP-BuyNowBF"
                    r3.append(r0)
                    java.lang.String r0 = r3.toString()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r0)
                    java.lang.String r0 = "&custom="
                    r3.append(r0)
                    long r4 = r5
                    r3.append(r4)
                    java.lang.String r0 = ","
                    r3.append(r0)
                    r0 = 10
                    java.lang.String r0 = stikerwap.appdys.config.random_str(r0)
                    r3.append(r0)
                    java.lang.String r0 = r3.toString()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r0)
                    java.lang.String r0 = "&item_name="
                    r3.append(r0)
                    r3.append(r1)
                    java.lang.String r0 = r3.toString()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r0)
                    java.lang.String r0 = "&notify_url="
                    r1.append(r0)
                    r1.append(r8)
                    java.lang.String r8 = r1.toString()
                    java.lang.String r0 = "https://closethis"
                    java.lang.String r0 = java.net.URLEncoder.encode(r0, r7)     // Catch:{ Exception -> 0x00cb }
                L_0x00cb:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    r7.append(r8)
                    java.lang.String r8 = "&return="
                    r7.append(r8)
                    r7.append(r0)
                    java.lang.String r8 = "&cancel_return="
                    r7.append(r8)
                    r7.append(r0)
                    java.lang.String r7 = r7.toString()
                    android.content.Intent r8 = new android.content.Intent
                    android.content.Context r0 = r7
                    android.app.Activity r0 = (android.app.Activity) r0
                    java.lang.Class<stikerwap.appdys.t_url> r1 = stikerwap.appdys.t_url.class
                    r8.<init>(r0, r1)
                    java.lang.String r0 = "url"
                    r8.putExtra(r0, r7)
                    java.lang.String r7 = "loader"
                    r8.putExtra(r7, r2)
                    java.lang.String r7 = "linksexternos"
                    r8.putExtra(r7, r2)
                    java.lang.String r7 = "adaptar_ancho"
                    r8.putExtra(r7, r2)
                    android.content.Context r7 = r7
                    android.app.Activity r7 = (android.app.Activity) r7
                    r0 = 111(0x6f, float:1.56E-43)
                    r7.startActivityForResult(r8, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.AnonymousClass35.onClick(android.content.DialogInterface, int):void");
            }
        }).setMessage(str2).create();
        if (!str.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + str));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + str));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_pago_secc(Context context, int i, final String str, String str2) {
        String str3;
        String str4;
        String str5;
        final SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        final long j = sharedPreferences.getLong("idusu", 0);
        String str6 = this.precio_msg;
        if (str6 == null || str6.equals("")) {
            String str7 = getResources().getString(R.string.wallet_msg_1).replace("@X@", this.precio_secc + " " + this.precio_divisa) + "\n\n" + getResources().getString(R.string.wallet_msg_2);
            int i2 = this.precio_time;
            if (i2 == 0) {
                str4 = str7.replace("@Y@", getResources().getString(R.string.acceder_unavez));
            } else if (i2 == 18000) {
                str4 = str7.replace("@Y@", getResources().getString(R.string.siempre));
            } else {
                if (i2 == 1) {
                    str5 = "1 " + getResources().getString(R.string.hora);
                } else if (i2 < 25) {
                    str5 = this.precio_time + " " + getResources().getString(R.string.horas);
                } else if (i2 < 2161) {
                    str5 = (this.precio_time / 24) + " " + getResources().getString(R.string.dias);
                } else if (i2 == 8784) {
                    str5 = "1 " + getResources().getString(R.string.anyo);
                } else if (i2 == 17568) {
                    str5 = "2 " + getResources().getString(R.string.anyos);
                } else {
                    str5 = "";
                }
                if (str5 != "") {
                    str4 = str7.replace("@Y@", str5);
                } else {
                    return;
                }
            }
            if (this.precio_modo == 1) {
                str3 = (str4 + "\n\n" + getResources().getString(R.string.wallet_msg_3)) + "\n\n" + getResources().getString(R.string.wallet_msg_4);
            } else {
                str3 = str4;
            }
        } else {
            str3 = this.precio_msg;
        }
        final int i3 = i;
        final Context context2 = context;
        final AlertDialog create = new AlertDialog.Builder(context).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            /* JADX WARNING: Can't wrap try/catch for region: R(10:17|18|19|20|21|24|25|26|27|29) */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x010b, code lost:
                r11 = "";
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00f3 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.content.DialogInterface r10, int r11) {
                /*
                    r9 = this;
                    stikerwap.appdys.config r10 = stikerwap.appdys.config.this
                    int r10 = r10.precio_modo
                    java.lang.String r11 = "_comprobacionespago"
                    java.lang.String r0 = "_intentado"
                    java.lang.String r1 = "utf-8"
                    java.lang.String r2 = "secc"
                    r3 = 0
                    java.lang.String r4 = "https://pay."
                    r5 = 1
                    if (r10 != r5) goto L_0x00ba
                    stikerwap.appdys.config r10 = stikerwap.appdys.config.this
                    android.content.Context r10 = r10.getApplicationContext()
                    android.content.pm.PackageManager r10 = r10.getPackageManager()
                    java.lang.String r6 = "app.phantom"
                    r10.getPackageInfo(r6, r3)     // Catch:{ NameNotFoundException -> 0x0024 }
                    r10 = 1
                    goto L_0x0026
                L_0x0024:
                    r10 = 0
                L_0x0026:
                    java.lang.String r6 = "android.intent.action.VIEW"
                    if (r10 == 0) goto L_0x00a8
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    r10.<init>(r4)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    java.lang.String r4 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    r10.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    java.lang.String r4 = "/srv/solana_transaction.php?idusu="
                    r10.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    long r7 = r3     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    r10.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    java.lang.String r4 = "&idsec="
                    r10.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    int r4 = r5     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    r10.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    java.lang.String r10 = r10.toString()     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    java.lang.String r10 = java.net.URLEncoder.encode(r10, r1)     // Catch:{ UnsupportedEncodingException -> 0x0051 }
                    goto L_0x0056
                L_0x0051:
                    r10 = move-exception
                    r10.printStackTrace()
                    r10 = 0
                L_0x0056:
                    if (r10 == 0) goto L_0x01de
                    android.content.SharedPreferences r1 = r6
                    android.content.SharedPreferences$Editor r1 = r1.edit()
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>(r2)
                    int r7 = r5
                    r4.append(r7)
                    r4.append(r0)
                    java.lang.String r0 = r4.toString()
                    r1.putBoolean(r0, r5)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>(r2)
                    int r2 = r5
                    r0.append(r2)
                    r0.append(r11)
                    java.lang.String r11 = r0.toString()
                    r1.putInt(r11, r3)
                    r1.apply()
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder
                    java.lang.String r0 = "solana:"
                    r11.<init>(r0)
                    r11.append(r10)
                    java.lang.String r10 = r11.toString()
                    android.net.Uri r10 = android.net.Uri.parse(r10)
                    android.content.Intent r11 = new android.content.Intent
                    r11.<init>(r6, r10)
                    android.content.Context r10 = r7
                    r10.startActivity(r11)
                    goto L_0x01de
                L_0x00a8:
                    java.lang.String r10 = "https://play.google.com/store/apps/details?id=app.phantom"
                    android.net.Uri r10 = android.net.Uri.parse(r10)
                    android.content.Intent r11 = new android.content.Intent
                    r11.<init>(r6, r10)
                    android.content.Context r10 = r7
                    r10.startActivity(r11)
                    goto L_0x01de
                L_0x00ba:
                    android.content.SharedPreferences r10 = r6
                    android.content.SharedPreferences$Editor r10 = r10.edit()
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>(r2)
                    int r7 = r5
                    r6.append(r7)
                    r6.append(r0)
                    java.lang.String r0 = r6.toString()
                    r10.putBoolean(r0, r5)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>(r2)
                    int r2 = r5
                    r0.append(r2)
                    r0.append(r11)
                    java.lang.String r11 = r0.toString()
                    r10.putInt(r11, r3)
                    r10.apply()
                    stikerwap.appdys.config r10 = stikerwap.appdys.config.this
                    java.lang.String r10 = r10.precio_email
                    java.lang.String r10 = java.net.URLEncoder.encode(r10, r1)     // Catch:{ Exception -> 0x00f3 }
                L_0x00f3:
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
                    r11.<init>(r4)     // Catch:{ Exception -> 0x010b }
                    java.lang.String r0 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ Exception -> 0x010b }
                    r11.append(r0)     // Catch:{ Exception -> 0x010b }
                    java.lang.String r0 = "/srv/pay_item.php"
                    r11.append(r0)     // Catch:{ Exception -> 0x010b }
                    java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x010b }
                    java.lang.String r11 = java.net.URLEncoder.encode(r11, r1)     // Catch:{ Exception -> 0x010b }
                    goto L_0x010d
                L_0x010b:
                    java.lang.String r11 = ""
                L_0x010d:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r2 = "https://www.paypal.com/cgi-bin/webscr/?rm=2&cmd=_xclick&business="
                    r0.<init>(r2)
                    r0.append(r10)
                    java.lang.String r10 = "&amount="
                    r0.append(r10)
                    stikerwap.appdys.config r10 = stikerwap.appdys.config.this
                    java.lang.String r10 = r10.precio_secc
                    r0.append(r10)
                    java.lang.String r10 = "&no_shipping=0&no_note=1&currency_code="
                    r0.append(r10)
                    stikerwap.appdys.config r10 = stikerwap.appdys.config.this
                    java.lang.String r10 = r10.precio_divisa
                    r0.append(r10)
                    java.lang.String r10 = "&bn=PP-BuyNowBF"
                    r0.append(r10)
                    java.lang.String r10 = r0.toString()
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r0.append(r10)
                    java.lang.String r10 = "&custom="
                    r0.append(r10)
                    long r4 = r3
                    r0.append(r4)
                    java.lang.String r10 = ","
                    r0.append(r10)
                    int r2 = r5
                    r0.append(r2)
                    r0.append(r10)
                    r10 = 10
                    java.lang.String r10 = stikerwap.appdys.config.random_str(r10)
                    r0.append(r10)
                    java.lang.String r10 = r0.toString()
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r0.append(r10)
                    java.lang.String r10 = "&item_name="
                    r0.append(r10)
                    stikerwap.appdys.config r10 = stikerwap.appdys.config.this
                    r2 = 2131886226(0x7f120092, float:1.9407025E38)
                    java.lang.String r10 = r10.getString(r2)
                    r0.append(r10)
                    java.lang.String r10 = r0.toString()
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r0.append(r10)
                    java.lang.String r10 = "&notify_url="
                    r0.append(r10)
                    r0.append(r11)
                    java.lang.String r10 = r0.toString()
                    java.lang.String r11 = "https://closethis"
                    java.lang.String r11 = java.net.URLEncoder.encode(r11, r1)     // Catch:{ Exception -> 0x019b }
                L_0x019b:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r0.append(r10)
                    java.lang.String r10 = "&return="
                    r0.append(r10)
                    r0.append(r11)
                    java.lang.String r10 = "&cancel_return="
                    r0.append(r10)
                    r0.append(r11)
                    java.lang.String r10 = r0.toString()
                    android.content.Intent r11 = new android.content.Intent
                    android.content.Context r0 = r7
                    android.app.Activity r0 = (android.app.Activity) r0
                    java.lang.Class<stikerwap.appdys.t_url> r1 = stikerwap.appdys.t_url.class
                    r11.<init>(r0, r1)
                    java.lang.String r0 = "url"
                    r11.putExtra(r0, r10)
                    java.lang.String r10 = "loader"
                    r11.putExtra(r10, r3)
                    java.lang.String r10 = "linksexternos"
                    r11.putExtra(r10, r3)
                    java.lang.String r10 = "adaptar_ancho"
                    r11.putExtra(r10, r3)
                    android.content.Context r10 = r7
                    android.app.Activity r10 = (android.app.Activity) r10
                    r10.startActivityForResult(r11, r3)
                L_0x01de:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.AnonymousClass37.onClick(android.content.DialogInterface, int):void");
            }
        }).setMessage(str3).create();
        if (!str.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + str));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + str));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    private class comprobar_pago_secc extends AsyncTask<String, Void, String> {
        Context c;
        String c_icos;
        String cbtn;
        String codigo;
        ProgressDialog dialog_cargando;
        int idsecc;
        long idusu;
        View v_abrir_secc;

        comprobar_pago_secc(Context context, long j, String str, int i, String str2, String str3, View view) {
            this.c = context;
            this.idusu = j;
            this.codigo = str;
            this.idsecc = i;
            this.cbtn = str2;
            this.c_icos = str3;
            this.v_abrir_secc = view;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SharedPreferences sharedPreferences = config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            if (sharedPreferences.getInt("secc" + this.idsecc + "_comprobacionespago", 0) > 10) {
                cancel(false);
                config.this.mostrar_pago_secc(this.c, this.idsecc, this.cbtn, this.c_icos);
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(this.c);
            this.dialog_cargando = progressDialog;
            progressDialog.setMessage(config.this.getResources().getString(R.string.comprobando_pago));
            this.dialog_cargando.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !this.c_icos.equals("")) {
                this.dialog_cargando.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) comprobar_pago_secc.this.dialog_cargando.findViewById(16908301), comprobar_pago_secc.this.c_icos);
                    }
                });
            }
            this.dialog_cargando.show();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r6 = ""
                java.lang.String r0 = "https://pay."
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x009d }
                r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.String r0 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ MalformedURLException -> 0x009d }
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.String r0 = "/srv/check_payment.php?idusu="
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x009d }
                long r3 = r5.idusu     // Catch:{ MalformedURLException -> 0x009d }
                r2.append(r3)     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.String r0 = "&c="
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.String r0 = r5.codigo     // Catch:{ MalformedURLException -> 0x009d }
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.String r0 = "&idsec="
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x009d }
                int r0 = r5.idsecc     // Catch:{ MalformedURLException -> 0x009d }
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x009d }
                java.lang.String r0 = r2.toString()     // Catch:{ MalformedURLException -> 0x009d }
                r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x009d }
                r0 = 0
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0098, all -> 0x0091 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0098, all -> 0x0091 }
                r0 = 1
                r1.setDoInput(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r0 = 15000(0x3a98, float:2.102E-41)
                r1.setReadTimeout(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.lang.String r0 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r1.setRequestProperty(r0, r2)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r1.connect()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r3.<init>(r0)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r2.<init>(r3)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r0.<init>()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
            L_0x0067:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                if (r3 == 0) goto L_0x0082
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r4.<init>()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r4.append(r3)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                r0.append(r3)     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                goto L_0x0067
            L_0x0082:
                java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x008f, all -> 0x008c }
                if (r1 == 0) goto L_0x008b
                r1.disconnect()
            L_0x008b:
                return r6
            L_0x008c:
                r6 = move-exception
                r0 = r1
                goto L_0x0092
            L_0x008f:
                r0 = r1
                goto L_0x0098
            L_0x0091:
                r6 = move-exception
            L_0x0092:
                if (r0 == 0) goto L_0x0097
                r0.disconnect()
            L_0x0097:
                throw r6
            L_0x0098:
                if (r0 == 0) goto L_0x009d
                r0.disconnect()
            L_0x009d:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.comprobar_pago_secc.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            Long l;
            try {
                this.dialog_cargando.dismiss();
            } catch (Exception unused) {
            }
            if (str.contains("ANDROID:NO")) {
                SharedPreferences sharedPreferences = config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("secc" + this.idsecc + "_comprobacionespago", sharedPreferences.getInt("secc" + this.idsecc + "_comprobacionespago", 0) + 1);
                edit.apply();
                config.this.mostrar_pago_secc(this.c, this.idsecc, this.cbtn, this.c_icos);
            } else if (str.contains("ANDROID:YES DURACION:")) {
                int indexOf = str.indexOf("ANDROID:YES DURACION:") + 21;
                int parseInt = Integer.parseInt(str.substring(indexOf, str.indexOf("-", indexOf)));
                SharedPreferences.Editor edit2 = config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit2.putInt("secc" + this.idsecc + "_comprobacionespago", 0);
                edit2.putBoolean("secc" + this.idsecc + "_pagada", true);
                if (parseInt == 18000) {
                    l = 2524604400000L;
                } else {
                    l = Long.valueOf(System.currentTimeMillis() + ((long) (parseInt * 60 * 60 * 1000)));
                }
                edit2.putLong("secc" + this.idsecc + "_fhasta", l.longValue());
                edit2.apply();
                ((Activity_ext) this.c).abrir_secc(this.v_abrir_secc);
            } else {
                config.mostrar_error(this.c, config.this.getResources().getString(R.string.error_http_tit), config.this.getResources().getString(R.string.error_http), this.cbtn);
            }
        }
    }

    private class comprobar_pago_sinads extends AsyncTask<String, Void, String> {
        Context c;
        String c_icos;
        String cbtn;
        String codigo;
        boolean desde_return;
        ProgressDialog dialog_cargando;
        long idusu;

        comprobar_pago_sinads(Context context, long j, String str, String str2, String str3, boolean z) {
            this.c = context;
            this.idusu = j;
            this.codigo = str;
            this.cbtn = str2;
            this.c_icos = str3;
            this.desde_return = z;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getInt("sinads_comprobacionespago", 0) > 10) {
                cancel(false);
                config.this.mostrar_pago_sinads(this.c, this.cbtn);
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(this.c);
            this.dialog_cargando = progressDialog;
            progressDialog.setMessage(config.this.getResources().getString(R.string.comprobando_pago));
            this.dialog_cargando.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !this.c_icos.equals("")) {
                this.dialog_cargando.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) comprobar_pago_sinads.this.dialog_cargando.findViewById(16908301), comprobar_pago_sinads.this.c_icos);
                    }
                });
            }
            this.dialog_cargando.show();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r6 = ""
                java.lang.String r0 = "https://pay."
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0093 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0093 }
                r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x0093 }
                java.lang.String r0 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ MalformedURLException -> 0x0093 }
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x0093 }
                java.lang.String r0 = "/srv/check_payment_sinads.php?idusu="
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x0093 }
                long r3 = r5.idusu     // Catch:{ MalformedURLException -> 0x0093 }
                r2.append(r3)     // Catch:{ MalformedURLException -> 0x0093 }
                java.lang.String r0 = "&c="
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x0093 }
                java.lang.String r0 = r5.codigo     // Catch:{ MalformedURLException -> 0x0093 }
                r2.append(r0)     // Catch:{ MalformedURLException -> 0x0093 }
                java.lang.String r0 = r2.toString()     // Catch:{ MalformedURLException -> 0x0093 }
                r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x0093 }
                r0 = 0
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x008e, all -> 0x0087 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x008e, all -> 0x0087 }
                r0 = 1
                r1.setDoInput(r0)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r0 = 15000(0x3a98, float:2.102E-41)
                r1.setReadTimeout(r0)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.lang.String r0 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r1.setRequestProperty(r0, r2)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r1.connect()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r3.<init>(r0)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r0.<init>()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
            L_0x005d:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                if (r3 == 0) goto L_0x0078
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r4.<init>()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r4.append(r3)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                r0.append(r3)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                goto L_0x005d
            L_0x0078:
                java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
                if (r1 == 0) goto L_0x0081
                r1.disconnect()
            L_0x0081:
                return r6
            L_0x0082:
                r6 = move-exception
                r0 = r1
                goto L_0x0088
            L_0x0085:
                r0 = r1
                goto L_0x008e
            L_0x0087:
                r6 = move-exception
            L_0x0088:
                if (r0 == 0) goto L_0x008d
                r0.disconnect()
            L_0x008d:
                throw r6
            L_0x008e:
                if (r0 == 0) goto L_0x0093
                r0.disconnect()
            L_0x0093:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.comprobar_pago_sinads.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            try {
                this.dialog_cargando.dismiss();
            } catch (Exception unused) {
            }
            if (str.contains("ANDROID:NO")) {
                SharedPreferences sharedPreferences = config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("sinads_comprobacionespago", sharedPreferences.getInt("sinads_comprobacionespago", 0) + 1);
                edit.apply();
                if (!this.desde_return) {
                    config.this.mostrar_pago_sinads(this.c, this.cbtn);
                }
            } else if (str.contains("ANDROID:YES FHASTA:")) {
                int indexOf = str.indexOf("ANDROID:YES FHASTA:") + 19;
                Long valueOf = Long.valueOf(Double.valueOf(Double.parseDouble(str.substring(indexOf, str.indexOf("-", indexOf)))).longValue());
                SharedPreferences.Editor edit2 = config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit2.putInt("sinads_comprobacionespago", 0);
                edit2.putBoolean("sinads", true);
                edit2.putLong("sinads_fhasta", valueOf.longValue());
                edit2.apply();
                config.this.msg_sinads_pagado(valueOf, this.c, this.cbtn);
            } else {
                config.mostrar_error(this.c, config.this.getResources().getString(R.string.error_http_tit), config.this.getResources().getString(R.string.error_http), this.cbtn);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a7, code lost:
        if ((java.lang.System.currentTimeMillis() - r0.longValue()) > (((((r2 == 2 ? 1 : r2 == 3 ? 3 : r2 == 4 ? 7 : r2 == 5 ? 15 : 30) * 24) * 60) * 60) * 1000)) goto L_0x026b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean rewarded(android.content.Context r21, android.view.View r22, java.lang.String r23, android.app.ProgressDialog r24, com.google.android.gms.ads.rewarded.RewardedAdLoadCallback r25, com.appnext.ads.fullscreen.RewardedVideo r26, com.facebook.ads.RewardedVideoAd r27, com.startapp.sdk.adsbase.StartAppAd r28, android.view.View r29) {
        /*
            r20 = this;
            r11 = r20
            r5 = r21
            r12 = r23
            java.lang.String r0 = "sh"
            r10 = 0
            android.content.SharedPreferences r1 = r11.getSharedPreferences(r0, r10)
            java.lang.String r2 = "sinads"
            boolean r1 = r1.getBoolean(r2, r10)
            if (r1 == 0) goto L_0x0018
            return r10
        L_0x0018:
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r0, r10)
            r1 = 2131361812(0x7f0a0014, float:1.8343387E38)
            r13 = r22
            java.lang.Object r1 = r13.getTag(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r2 = r1.intValue()
            int r3 = r11.ico_share_ord
            int r3 = r3 + 10000
            r4 = -1
            r14 = 1
            if (r2 != r3) goto L_0x004d
            int r1 = r11.ico_share_idsec
            if (r1 <= r14) goto L_0x0047
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x0047:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x004d:
            int r2 = r1.intValue()
            int r3 = r11.ico_search_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x0071
            int r1 = r11.ico_search_idsec
            if (r1 <= r14) goto L_0x006b
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x006b:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x0071:
            int r2 = r1.intValue()
            int r3 = r11.ico_exit_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x0095
            int r1 = r11.ico_exit_idsec
            if (r1 <= r14) goto L_0x008f
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x008f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x0095:
            int r2 = r1.intValue()
            int r3 = r11.ico_notif_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x00b9
            int r1 = r11.ico_notif_idsec
            if (r1 <= r14) goto L_0x00b3
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x00b3:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x00b9:
            int r2 = r1.intValue()
            int r3 = r11.ico_ofics_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x00e7
            int r1 = r11.ico_ofics_idsec
            if (r1 <= r14) goto L_0x00d7
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x00d7:
            if (r1 != 0) goto L_0x00e1
            int r1 = r11.ind_secc_ofics
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x00e1:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x00e7:
            int r2 = r1.intValue()
            int r3 = r11.ico_busc_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x0112
            int r1 = r11.ico_busc_idsec
            if (r1 <= r14) goto L_0x0104
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x0104:
            if (r1 != 0) goto L_0x010d
            int r1 = r11.ind_secc_buscador
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x010d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x0112:
            int r2 = r1.intValue()
            int r3 = r11.ico_perfil_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x0134
            int r1 = r11.ico_perfil_idsec
            if (r1 <= r14) goto L_0x012f
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x012f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0155
        L_0x0134:
            int r2 = r1.intValue()
            int r3 = r11.ico_sinads_ord
            int r3 = r3 + 10000
            if (r2 != r3) goto L_0x0155
            int r1 = r11.ico_sinads_idsec
            if (r1 <= r14) goto L_0x0151
            java.util.ArrayList<java.lang.Integer> r2 = secciones_alist
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r2.indexOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0155
        L_0x0151:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
        L_0x0155:
            java.lang.String r2 = r11.precio_secc
            r3 = 0
            java.lang.String r15 = ""
            if (r2 == 0) goto L_0x0205
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0205
            int r2 = r1.intValue()
            if (r2 < 0) goto L_0x0205
            int r2 = r1.intValue()
            stikerwap.appdys.Seccion[] r6 = r11.secciones_a
            int r7 = r6.length
            if (r2 >= r7) goto L_0x0205
            int r2 = r1.intValue()
            r2 = r6[r2]
            boolean r2 = r2.depago
            if (r2 == 0) goto L_0x0205
            stikerwap.appdys.Seccion[] r2 = r11.secciones_a
            int r1 = r1.intValue()
            r1 = r2[r1]
            int r6 = r1.id
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "secc"
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r7 = "_pagada"
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            boolean r1 = r0.getBoolean(r1, r10)
            if (r1 == 0) goto L_0x01c5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r7 = "_fhasta"
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            long r7 = r0.getLong(r1, r3)
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            long r7 = java.lang.System.currentTimeMillis()
            long r16 = r1.longValue()
            int r1 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x01c5
            return r10
        L_0x01c5:
            java.lang.String r1 = "idusu"
            long r3 = r0.getLong(r1, r3)
            java.lang.String r1 = "cod"
            java.lang.String r7 = r0.getString(r1, r15)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r2 = "_intentado"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.getBoolean(r1, r10)
            if (r0 == 0) goto L_0x01ff
            stikerwap.appdys.config$comprobar_pago_secc r13 = new stikerwap.appdys.config$comprobar_pago_secc
            java.lang.String r8 = r11.c_icos
            r0 = r13
            r1 = r20
            r2 = r21
            r5 = r7
            r7 = r23
            r9 = r29
            r0.<init>(r2, r3, r5, r6, r7, r8, r9)
            java.lang.String[] r0 = new java.lang.String[r10]
            r13.execute(r0)
            goto L_0x0204
        L_0x01ff:
            java.lang.String r0 = r11.c_icos
            r11.mostrar_pago_secc(r5, r6, r12, r0)
        L_0x0204:
            return r14
        L_0x0205:
            java.lang.String r2 = r11.appnext_rew_cod
            r6 = 4
            r7 = 3
            r8 = 2
            if (r2 == 0) goto L_0x0212
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x0212:
            java.lang.String r2 = r11.admob_rew_cod
            if (r2 == 0) goto L_0x021c
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x021c:
            java.lang.String r2 = r11.fb_rew_cod
            if (r2 == 0) goto L_0x0226
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x0226:
            java.lang.String r2 = r11.st_rew_cod
            if (r2 == 0) goto L_0x0230
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x0230:
            java.lang.String r2 = r11.pollfish_cod
            if (r2 == 0) goto L_0x023a
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x023a:
            java.lang.String r2 = r11.uni_rew_cod
            if (r2 == 0) goto L_0x0244
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x0244:
            java.lang.String r2 = r11.is_rew_cod
            if (r2 == 0) goto L_0x024e
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
        L_0x024e:
            java.lang.String r2 = r11.wortise_rew_cod
            if (r2 == 0) goto L_0x0271
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x0259
            goto L_0x0271
        L_0x0259:
            java.lang.String r2 = "fult_rew"
            long r16 = r0.getLong(r2, r3)
            java.lang.Long r0 = java.lang.Long.valueOf(r16)
            long r16 = r0.longValue()
            int r2 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x026d
        L_0x026b:
            r0 = 1
            goto L_0x02aa
        L_0x026d:
            int r2 = r11.rew_modo
            if (r2 != 0) goto L_0x0273
        L_0x0271:
            r0 = 0
            goto L_0x02aa
        L_0x0273:
            if (r2 != r14) goto L_0x0276
            goto L_0x026b
        L_0x0276:
            if (r2 != r8) goto L_0x027b
            r2 = 1
            goto L_0x028d
        L_0x027b:
            if (r2 != r7) goto L_0x0280
            r2 = 3
            goto L_0x028d
        L_0x0280:
            if (r2 != r6) goto L_0x0285
            r2 = 7
            goto L_0x028d
        L_0x0285:
            r3 = 5
            if (r2 != r3) goto L_0x028b
            r2 = 15
            goto L_0x028d
        L_0x028b:
            r2 = 30
        L_0x028d:
            long r16 = java.lang.System.currentTimeMillis()
            long r18 = r0.longValue()
            long r16 = r16 - r18
            r18 = 24
            long r2 = r2 * r18
            r18 = 60
            long r2 = r2 * r18
            long r2 = r2 * r18
            r18 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r18
            int r0 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0271
            goto L_0x026b
        L_0x02aa:
            if (r0 != 0) goto L_0x02ad
            return r10
        L_0x02ad:
            int r0 = r1.intValue()
            if (r0 < 0) goto L_0x044a
            int r0 = r1.intValue()
            stikerwap.appdys.Seccion[] r2 = r11.secciones_a
            int r3 = r2.length
            if (r0 >= r3) goto L_0x044a
            int r0 = r1.intValue()
            r0 = r2[r0]
            boolean r0 = r0.rewarded
            if (r0 == 0) goto L_0x044a
            java.lang.String r0 = r11.appnext_rew_cod
            if (r0 == 0) goto L_0x02d2
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x02d2
            r0 = 1
            goto L_0x02d3
        L_0x02d2:
            r0 = 0
        L_0x02d3:
            java.lang.String r1 = r11.admob_rew_cod
            if (r1 == 0) goto L_0x02df
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x02df
            r1 = 1
            goto L_0x02e0
        L_0x02df:
            r1 = 0
        L_0x02e0:
            java.lang.String r2 = r11.fb_rew_cod
            if (r2 == 0) goto L_0x02ec
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x02ec
            r2 = 1
            goto L_0x02ed
        L_0x02ec:
            r2 = 0
        L_0x02ed:
            java.lang.String r3 = r11.st_rew_cod
            if (r3 == 0) goto L_0x02f9
            boolean r3 = r3.equals(r15)
            if (r3 != 0) goto L_0x02f9
            r3 = 1
            goto L_0x02fa
        L_0x02f9:
            r3 = 0
        L_0x02fa:
            java.lang.String r4 = r11.pollfish_cod
            if (r4 == 0) goto L_0x0306
            boolean r4 = r4.equals(r15)
            if (r4 != 0) goto L_0x0306
            r4 = 1
            goto L_0x0307
        L_0x0306:
            r4 = 0
        L_0x0307:
            java.lang.String r9 = r11.uni_rew_cod
            if (r9 == 0) goto L_0x0313
            boolean r9 = r9.equals(r15)
            if (r9 != 0) goto L_0x0313
            r9 = 1
            goto L_0x0314
        L_0x0313:
            r9 = 0
        L_0x0314:
            java.lang.String r10 = r11.is_rew_cod
            if (r10 == 0) goto L_0x0320
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0320
            r10 = 1
            goto L_0x0321
        L_0x0320:
            r10 = 0
        L_0x0321:
            java.lang.String r6 = r11.wortise_rew_cod
            if (r6 == 0) goto L_0x032d
            boolean r6 = r6.equals(r15)
            if (r6 != 0) goto L_0x032d
            r6 = 1
            goto L_0x032e
        L_0x032d:
            r6 = 0
        L_0x032e:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r1 == 0) goto L_0x033c
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r7.add(r8)
        L_0x033c:
            if (r0 == 0) goto L_0x034c
            if (r1 == 0) goto L_0x0344
            boolean r0 = prioridad_admob
            if (r0 != 0) goto L_0x034c
        L_0x0344:
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.add(r0)
        L_0x034c:
            if (r2 == 0) goto L_0x0356
            r0 = 3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.add(r0)
        L_0x0356:
            if (r3 == 0) goto L_0x0360
            r0 = 4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.add(r0)
        L_0x0360:
            r0 = 6
            if (r4 == 0) goto L_0x036a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r7.add(r1)
        L_0x036a:
            if (r9 == 0) goto L_0x037a
            boolean r1 = com.unity3d.ads.UnityAds.isInitialized()
            if (r1 == 0) goto L_0x037a
            r1 = 7
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.add(r1)
        L_0x037a:
            if (r10 == 0) goto L_0x038b
            boolean r1 = com.ironsource.mediationsdk.IronSource.isRewardedVideoAvailable()
            if (r1 == 0) goto L_0x038b
            r1 = 8
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.add(r1)
        L_0x038b:
            if (r6 == 0) goto L_0x0396
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r7.add(r1)
        L_0x0396:
            boolean r1 = r7.isEmpty()
            if (r1 != 0) goto L_0x03b5
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            int r2 = r7.size()
            int r2 = r2 - r14
            r3 = 0
            int r2 = r2 - r3
            int r2 = r2 + r14
            int r1 = r1.nextInt(r2)
            int r1 = r1 + r3
            java.lang.Object r1 = r7.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            goto L_0x03ba
        L_0x03b5:
            r3 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
        L_0x03ba:
            r3 = r1
            int r1 = r3.intValue()
            if (r1 != r0) goto L_0x03d7
            android.content.res.Resources r0 = r20.getResources()
            r1 = 2131886658(0x7f120242, float:1.9407901E38)
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = r11.rew_poll_msg
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x03ec
            java.lang.String r0 = r11.rew_poll_msg
            goto L_0x03ec
        L_0x03d7:
            android.content.res.Resources r0 = r20.getResources()
            r1 = 2131886657(0x7f120241, float:1.94079E38)
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = r11.rew_msg
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x03ec
            java.lang.String r0 = r11.rew_msg
        L_0x03ec:
            r10 = r0
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r5)
            r1 = 2131886163(0x7f120053, float:1.9406897E38)
            r2 = 0
            android.app.AlertDialog$Builder r9 = r0.setNegativeButton(r1, r2)
            stikerwap.appdys.config$39 r8 = new stikerwap.appdys.config$39
            r0 = r8
            r1 = r20
            r2 = r24
            r4 = r26
            r5 = r21
            r6 = r25
            r7 = r27
            r14 = r8
            r8 = r28
            r13 = r9
            r9 = r29
            r11 = r10
            r10 = r22
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 2131886114(0x7f120022, float:1.9406798E38)
            android.app.AlertDialog$Builder r0 = r13.setPositiveButton(r0, r14)
            android.app.AlertDialog$Builder r0 = r0.setMessage(r11)
            android.app.AlertDialog r0 = r0.create()
            boolean r1 = r12.equals(r15)
            if (r1 != 0) goto L_0x0435
            stikerwap.appdys.config$40 r1 = new stikerwap.appdys.config$40
            r2 = r20
            r1.<init>(r0, r12)
            r0.setOnShowListener(r1)
            goto L_0x0437
        L_0x0435:
            r2 = r20
        L_0x0437:
            r0.show()
            r1 = 16908299(0x102000b, float:2.387726E-38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x0448 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0448 }
            android.graphics.Typeface r1 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0448 }
            r0.setTypeface(r1)     // Catch:{ Exception -> 0x0448 }
        L_0x0448:
            r0 = 1
            return r0
        L_0x044a:
            r2 = r11
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.rewarded(android.content.Context, android.view.View, java.lang.String, android.app.ProgressDialog, com.google.android.gms.ads.rewarded.RewardedAdLoadCallback, com.appnext.ads.fullscreen.RewardedVideo, com.facebook.ads.RewardedVideoAd, com.startapp.sdk.adsbase.StartAppAd, android.view.View):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean admob_rew_failed(Context context, RewardedVideo rewardedVideo) {
        if (rewardedVideo == null) {
            return false;
        }
        try {
            rewardedVideo.setOnAdLoadedCallback((OnAdLoaded) context);
            rewardedVideo.setOnAdClosedCallback((OnAdClosed) context);
            rewardedVideo.setOnAdErrorCallback((OnAdError) context);
            rewardedVideo.setOnVideoEndedCallback((OnVideoEnded) context);
            rewardedVideo.loadAd();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fdescargar(java.lang.String r9, java.lang.String r10, java.lang.String r11, android.content.Context r12) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            boolean r1 = r9.equals(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r9.toLowerCase(r1)
            android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request     // Catch:{ Exception -> 0x00b4 }
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x00b4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b4 }
            r2.allowScanningByMediaScanner()
            r3 = 1
            r2.setNotificationVisibility(r3)
            java.lang.String r4 = ".apk"
            java.lang.String r5 = ".mp4"
            java.lang.String r6 = ".mp3"
            if (r10 == 0) goto L_0x002f
            boolean r7 = r10.equals(r0)
            if (r7 == 0) goto L_0x004a
        L_0x002f:
            boolean r7 = r1.endsWith(r6)
            if (r7 == 0) goto L_0x0038
            java.lang.String r10 = "audio/mpeg"
            goto L_0x004a
        L_0x0038:
            boolean r7 = r1.endsWith(r5)
            if (r7 == 0) goto L_0x0042
            java.lang.String r10 = "video/mp4"
            goto L_0x004a
        L_0x0042:
            boolean r7 = r1.endsWith(r4)
            if (r7 == 0) goto L_0x004a
            java.lang.String r10 = "application/vnd.android.package-archive"
        L_0x004a:
            if (r10 == 0) goto L_0x0057
            boolean r7 = r10.equals(r0)
            if (r7 != 0) goto L_0x0057
            r2.setMimeType(r10)     // Catch:{ Exception -> 0x0056 }
            goto L_0x0057
        L_0x0056:
        L_0x0057:
            boolean r10 = r11.equals(r0)
            if (r10 == 0) goto L_0x007c
            boolean r10 = r1.endsWith(r6)
            if (r10 != 0) goto L_0x006f
            boolean r10 = r1.endsWith(r5)
            if (r10 != 0) goto L_0x006f
            boolean r10 = r1.endsWith(r4)
            if (r10 == 0) goto L_0x007c
        L_0x006f:
            java.lang.String r10 = "/"
            int r10 = r9.lastIndexOf(r10)     // Catch:{ Exception -> 0x007b }
            int r10 = r10 + r3
            java.lang.String r11 = r9.substring(r10)     // Catch:{ Exception -> 0x007b }
            goto L_0x007c
        L_0x007b:
        L_0x007c:
            boolean r9 = r11.equals(r0)
            if (r9 != 0) goto L_0x0093
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0093 }
            r10 = 29
            if (r9 < r10) goto L_0x008e
            java.lang.String r9 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ Exception -> 0x0093 }
            r2.setDestinationInExternalPublicDir(r9, r11)     // Catch:{ Exception -> 0x0093 }
            goto L_0x0093
        L_0x008e:
            java.lang.String r9 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ Exception -> 0x0093 }
            r2.setDestinationInExternalFilesDir(r12, r9, r11)     // Catch:{ Exception -> 0x0093 }
        L_0x0093:
            java.lang.String r9 = "download"
            java.lang.Object r9 = r8.getSystemService(r9)     // Catch:{  }
            android.app.DownloadManager r9 = (android.app.DownloadManager) r9     // Catch:{  }
            r9.enqueue(r2)     // Catch:{  }
            android.content.Context r9 = r8.getApplicationContext()     // Catch:{  }
            android.content.res.Resources r10 = r8.getResources()     // Catch:{  }
            r11 = 2131886326(0x7f1200f6, float:1.9407228E38)
            java.lang.String r10 = r10.getString(r11)     // Catch:{  }
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r10, r3)     // Catch:{  }
            r9.show()     // Catch:{  }
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.config.fdescargar(java.lang.String, java.lang.String, java.lang.String, android.content.Context):void");
    }

    static void rew_visto(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
        edit.putLong("fult_rew", System.currentTimeMillis());
        edit.putInt("n_imp", 0);
        edit.putInt("n_imp_chat", 0);
        edit.commit();
        toca_int = 0;
        toca_int_chat = 0;
    }

    public static Bitmap putOverlay(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, (float) ((bitmap.getWidth() - bitmap2.getWidth()) / 2), (float) ((bitmap.getHeight() - bitmap2.getHeight()) / 2), (Paint) null);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    public void oncreate_popup(Context context, int i, final String str, Bundle bundle) {
        if (i != -1 && bundle == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            Seccion seccion = this.secciones_a[i];
            if (!seccion.popup_txt.equals("")) {
                if (!sharedPreferences.getBoolean("popup_nomas_" + seccion.id, false)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    if (!seccion.popup_tit.equals("")) {
                        builder.setTitle(seccion.popup_tit);
                    }
                    if (seccion.popup_nomas_mostrar) {
                        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.bienvenida, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R.id.message);
                        textView.setMovementMethod(new ScrollingMovementMethod());
                        textView.setText(Html.fromHtml(seccion.popup_txt));
                        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.skip);
                        if (!str.equals("")) {
                            checkbox_color(checkBox, str);
                        }
                        checkBox.setChecked(seccion.popup_nomas_def);
                        checkBox.setTag(Integer.valueOf(i));
                        builder.setView(inflate);
                    } else {
                        builder.setMessage(Html.fromHtml(seccion.popup_txt));
                    }
                    builder.setCancelable(false);
                    if (seccion.popup_nomas_mostrar) {
                        builder.setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                CheckBox checkBox = (CheckBox) ((AlertDialog) dialogInterface).findViewById(R.id.skip);
                                if (checkBox.isChecked()) {
                                    SharedPreferences.Editor edit = config.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                                    edit.putBoolean("popup_nomas_" + config.this.secciones_a[((Integer) checkBox.getTag()).intValue()].id, true);
                                    edit.commit();
                                }
                            }
                        });
                    } else {
                        builder.setPositiveButton(getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
                    }
                    final AlertDialog create = builder.create();
                    if (!str.equals("")) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + str));
                            }
                        });
                    }
                    try {
                        create.show();
                        if (!seccion.popup_nomas_mostrar) {
                            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void stop_radio() {
        Intent intent = new Intent(this, s_mediaplayer_exo.class);
        intent.putExtra("accion", "stop");
        startService(intent);
    }

    static void fguardar_foto_desdefile(String str, Context context) {
        String str2;
        if (str != null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "image/*";
            try {
                str2 = URLUtil.guessFileName(str, (String) null, mimeTypeFromExtension);
            } catch (Exception unused) {
                str2 = "";
            }
            if (!str2.equals("")) {
                if (str2.indexOf(".") != -1) {
                    String substring = str2.substring(str2.lastIndexOf("."));
                    Random random = new Random();
                    str2 = "img" + (random.nextInt(9000) + 1000) + substring;
                }
                String str3 = str2;
                try {
                    if (Build.VERSION.SDK_INT >= 29) {
                        ContentResolver contentResolver = context.getContentResolver();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_display_name", str3);
                        contentValues.put("mime_type", mimeTypeFromExtension);
                        copy_to_fos(new File(str.replace(AdPayload.FILE_SCHEME, "")), context.getContentResolver().openOutputStream(contentResolver.insert(MediaStore.Images.Media.getContentUri("external_primary"), contentValues)));
                        mostrar_toast(Toast.makeText(context, context.getResources().getString(R.string.guardando), 1));
                        return;
                    }
                    File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), str3);
                    copy(new File(str.replace(AdPayload.FILE_SCHEME, "")), file);
                    ((DownloadManager) context.getSystemService(NativeAdPresenter.DOWNLOAD)).addCompletedDownload(str3, str3, true, mimeTypeFromExtension, file.getAbsolutePath(), file.length(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static NotificationChannel crear_channel(Context context, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("channel_" + i, "channel " + i, 3);
        if (i == 0) {
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        }
        notificationManager.createNotificationChannel(notificationChannel);
        return notificationChannel;
    }

    public static Bitmap ico_en_notif(Context context) {
        String string = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getString(CmcdHeadersFactory.OBJECT_TYPE_INIT_SEGMENT, "");
        if (string.equals("") || string.length() <= 23 || !string.substring(23, 24).equals("1")) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
    }

    public static Bitmap getBitmapFromURL(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generatePath(Uri uri, Context context) {
        String generateFromKitkat = generateFromKitkat(uri, context);
        if (generateFromKitkat != null) {
            return generateFromKitkat;
        }
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            if (query.moveToFirst()) {
                generateFromKitkat = query.getString(query.getColumnIndexOrThrow("_data"));
            }
            query.close();
        }
        return generateFromKitkat == null ? uri.getPath() : generateFromKitkat;
    }

    private static String generateFromKitkat(Uri uri, Context context) {
        String str = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String str2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER)[1];
            String[] strArr = {"_data"};
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{str2}, (String) null);
            int columnIndex = query.getColumnIndex(strArr[0]);
            if (query.moveToFirst()) {
                str = query.getString(columnIndex);
            }
            query.close();
        }
        return str;
    }

    public static boolean p_notifications(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            String[] strArr = packageInfo != null ? packageInfo.requestedPermissions : null;
            if (strArr != null && strArr.length > 0) {
                List asList = Arrays.asList(strArr);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(asList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).contains("POST_NOTIFICATIONS")) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean p_location(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            String[] strArr = packageInfo != null ? packageInfo.requestedPermissions : null;
            if (strArr == null || strArr.length <= 0) {
                return false;
            }
            List asList = Arrays.asList(strArr);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(asList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains("ACCESS_FINE_LOCATION")) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
