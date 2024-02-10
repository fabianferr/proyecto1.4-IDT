package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.vungle.ads.internal.model.AdPayload;
import com.wortise.ads.banner.BannerAd;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import stikerwap.appdys.t_chat;

public class profile extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private static final int SELECT_PHOTO = 2;
    private static final int SELECT_VIDEO = 4;
    BannerAd adView_nat_w;
    int altura;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_propia;
    String c1;
    boolean c1_esclaro;
    String c2;
    boolean c2_esclaro;
    cargar_fotoscoments c_f;
    cargar_fotos_gal c_f_g;
    cargar_likes c_l;
    cargar_videos_gal c_v_g;
    long captureTime;
    String codigo;
    View convertView;
    ProgressDialog d_video;
    AlertDialog.Builder dialog_likes;
    String dist;
    int edat = -1;
    enviar_coment env;
    Bundle extras;
    ImageView f1;
    ImageView f1_v;
    ImageView f2;
    ImageView f2_v;
    ImageView f3;
    ImageView f3_v;
    ImageView f4;
    ImageView f4_v;
    ArrayList<Foto> fotos_glob_a = new ArrayList<>();
    boolean fotos_glob_a_completo;
    int fotos_perfil;
    config globales;
    String idcoment_ult;
    long idusu;
    String idusu_profile;
    int ind_global;
    int ind_v_global;
    /* access modifiers changed from: private */
    public likes_adapter itemAdapter;
    ImageView iv;
    ImageView iv_favorito;
    boolean liked = false;
    /* access modifiers changed from: private */
    public ArrayList<likes_item> listData = new ArrayList<>();
    LinearLayout ll_coments;
    LinearLayout ll_likes1;
    LinearLayout ll_likes2;
    LinearLayout ll_likes3;
    LinearLayout ll_likes4;
    LinearLayout ll_v_likes1;
    LinearLayout ll_v_likes2;
    LinearLayout ll_v_likes3;
    LinearLayout ll_v_likes4;
    boolean mAd_visto = false;
    ListView mDrawerList;
    boolean mostrar_game;
    int n_cargados = 0;
    int nlikes_pro = 0;
    int nvideos = 0;
    obtener_img_g o_i_g;
    File path;
    ProgressBar pb1;
    ProgressBar pb1_v;
    ProgressBar pb2;
    ProgressBar pb2_v;
    ProgressBar pb3;
    ProgressBar pb3_v;
    ProgressBar pb4;
    ProgressBar pb4_v;
    ProgressBar pb_enviando;
    SharedPreferences settings;
    TextView tv_descr;
    TextView tv_likes1;
    TextView tv_likes2;
    TextView tv_likes3;
    TextView tv_likes4;
    TextView tv_v_likes1;
    TextView tv_v_likes2;
    TextView tv_v_likes3;
    TextView tv_v_likes4;
    String vfoto;
    ArrayList<Video> videos_glob_a = new ArrayList<>();
    boolean videos_glob_a_completo;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:245:0x0e02  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0ee1  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0f01  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0fcf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            android.content.Context r2 = r17.getApplicationContext()
            stikerwap.appdys.config r2 = (stikerwap.appdys.config) r2
            r0.globales = r2
            java.lang.String r2 = r2.c1
            if (r2 != 0) goto L_0x0015
            stikerwap.appdys.config r2 = r0.globales
            r2.recuperar_vars()
        L_0x0015:
            r0.establec_ralc(r0)
            android.content.Intent r2 = r17.getIntent()
            android.os.Bundle r2 = r2.getExtras()
            r0.extras = r2
            java.lang.String r3 = "desde_main"
            r4 = 0
            boolean r2 = r2.getBoolean(r3, r4)
            if (r2 == 0) goto L_0x0038
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c1c
            r0.c1 = r2
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c2c
            r0.c2 = r2
            goto L_0x0054
        L_0x0038:
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            stikerwap.appdys.config r3 = r0.globales
            int r3 = r3.ind_secc_sel_2
            r2 = r2[r3]
            java.lang.String r2 = r2.c1
            r0.c1 = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            stikerwap.appdys.config r3 = r0.globales
            int r3 = r3.ind_secc_sel_2
            r2 = r2[r3]
            java.lang.String r2 = r2.c2
            r0.c2 = r2
        L_0x0054:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "#"
            r2.<init>(r3)
            java.lang.String r5 = r0.c1
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            r0.c1_esclaro = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r5 = r0.c2
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            r0.c2_esclaro = r2
            java.lang.String r2 = r0.c1
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_icos
            java.lang.String r2 = stikerwap.appdys.config.aplicar_color_dialog(r2, r5)
            r0.cbtn = r2
            boolean r2 = r0.c1_esclaro
            if (r2 != 0) goto L_0x0094
            r2 = 2131952478(0x7f13035e, float:1.95414E38)
            r0.setTheme(r2)
        L_0x0094:
            java.lang.String r2 = "es_root"
            r5 = 1
            if (r1 != 0) goto L_0x00b1
            android.os.Bundle r6 = r0.extras
            if (r6 == 0) goto L_0x00ad
            boolean r6 = r6.containsKey(r2)
            if (r6 == 0) goto L_0x00ad
            android.os.Bundle r6 = r0.extras
            boolean r2 = r6.getBoolean(r2, r4)
            if (r2 == 0) goto L_0x00ad
            r2 = 1
            goto L_0x00ae
        L_0x00ad:
            r2 = 0
        L_0x00ae:
            r0.es_root = r2
            goto L_0x00c2
        L_0x00b1:
            boolean r6 = r1.containsKey(r2)
            if (r6 == 0) goto L_0x00bf
            boolean r2 = r1.getBoolean(r2, r4)
            if (r2 == 0) goto L_0x00bf
            r2 = 1
            goto L_0x00c0
        L_0x00bf:
            r2 = 0
        L_0x00c0:
            r0.es_root = r2
        L_0x00c2:
            super.onCreate(r18)
            r1 = 2131558689(0x7f0d0121, float:1.87427E38)
            r0.setContentView(r1)
            r17.incluir_menu_pre()
            stikerwap.appdys.config r1 = r0.globales
            r1.onCreate_global(r0, r4)
            java.lang.String r1 = "search"
            java.lang.Object r1 = r0.getSystemService(r1)
            android.app.SearchManager r1 = (android.app.SearchManager) r1
            stikerwap.appdys.profile$1 r2 = new stikerwap.appdys.profile$1
            r2.<init>()
            r1.setOnCancelListener(r2)
            stikerwap.appdys.profile$2 r2 = new stikerwap.appdys.profile$2
            r2.<init>()
            r1.setOnDismissListener(r2)
            stikerwap.appdys.config r1 = r0.globales
            android.os.Bundle r2 = r0.extras
            if (r2 == 0) goto L_0x00fb
            java.lang.String r6 = "ad_entrar"
            boolean r2 = r2.containsKey(r6)
            if (r2 == 0) goto L_0x00fb
            r2 = 1
            goto L_0x00fc
        L_0x00fb:
            r2 = 0
        L_0x00fc:
            android.os.Bundle r6 = r0.extras
            if (r6 == 0) goto L_0x010a
            java.lang.String r7 = "fb_entrar"
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x010a
            r6 = 1
            goto L_0x010b
        L_0x010a:
            r6 = 0
        L_0x010b:
            r1.toca_int(r0, r2, r6)
            java.lang.String r1 = "sh"
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r4)
            r0.settings = r1
            java.lang.String r2 = "idusu"
            r6 = 0
            long r1 = r1.getLong(r2, r6)
            r0.idusu = r1
            android.content.SharedPreferences r1 = r0.settings
            java.lang.String r2 = "cod"
            java.lang.String r6 = ""
            java.lang.String r1 = r1.getString(r2, r6)
            r0.codigo = r1
            android.os.Bundle r1 = r0.extras
            java.lang.String r2 = "id"
            java.lang.String r1 = r1.getString(r2)
            r0.idusu_profile = r1
            java.io.File r1 = r17.getFilesDir()
            r0.path = r1
            r17.banner()
            java.lang.String r1 = r0.c1
            boolean r1 = r1.equals(r6)
            r2 = 2
            if (r1 != 0) goto L_0x0183
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r7 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            int[] r8 = new int[r2]
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.String r10 = r0.c1
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            r8[r4] = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.String r10 = r0.c2
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            r8[r5] = r9
            r1.<init>(r7, r8)
            r7 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r7 = r0.findViewById(r7)
            r7.setBackgroundDrawable(r1)
        L_0x0183:
            android.view.WindowManager r1 = r17.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            android.graphics.Point r7 = new android.graphics.Point
            r7.<init>()
            r1.getSize(r7)
            int r1 = r7.y
            r0.altura = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 2131362992(0x7f0a04b0, float:1.834578E38)
            r8 = 2131363004(0x7f0a04bc, float:1.8345805E38)
            r9 = 2131363001(0x7f0a04b9, float:1.8345798E38)
            r10 = 20
            if (r1 <= r10) goto L_0x02ed
            android.view.View r1 = r0.findViewById(r9)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            android.view.View r1 = r0.findViewById(r8)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363013(0x7f0a04c5, float:1.8345823E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363014(0x7f0a04c6, float:1.8345825E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363011(0x7f0a04c3, float:1.8345819E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363012(0x7f0a04c4, float:1.834582E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            android.view.View r1 = r0.findViewById(r7)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362993(0x7f0a04b1, float:1.8345782E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362977(0x7f0a04a1, float:1.834575E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362978(0x7f0a04a2, float:1.8345752E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362979(0x7f0a04a3, float:1.8345754E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362980(0x7f0a04a4, float:1.8345756E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362981(0x7f0a04a5, float:1.8345758E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362982(0x7f0a04a6, float:1.834576E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362983(0x7f0a04a7, float:1.8345762E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131362984(0x7f0a04a8, float:1.8345764E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363029(0x7f0a04d5, float:1.8345855E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363030(0x7f0a04d6, float:1.8345857E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363031(0x7f0a04d7, float:1.834586E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363032(0x7f0a04d8, float:1.8345861E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363033(0x7f0a04d9, float:1.8345863E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363034(0x7f0a04da, float:1.8345865E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363035(0x7f0a04db, float:1.8345867E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
            r1 = 2131363036(0x7f0a04dc, float:1.834587E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r11 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r11)
        L_0x02ed:
            r0.mostrar_game = r4
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            long r12 = r0.idusu
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x0349
            r1 = 0
        L_0x0309:
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r11 = r11.length
            if (r1 >= r11) goto L_0x0349
            boolean r11 = r0.mostrar_game
            if (r11 != 0) goto L_0x0349
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            r11 = r11[r1]
            int r12 = r11.tipo
            if (r12 != r5) goto L_0x0343
            java.lang.String r12 = r11.url
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "games."
            r13.<init>(r14)
            java.lang.String r14 = stikerwap.appdys.config.DOM_EDROID
            r13.append(r14)
            r13.append(r6)
            java.lang.String r13 = r13.toString()
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x0343
            boolean r12 = r11.con_login
            if (r12 == 0) goto L_0x0343
            boolean r11 = r11.con_punt
            if (r11 == 0) goto L_0x0343
            r11 = 1
            goto L_0x0344
        L_0x0343:
            r11 = 0
        L_0x0344:
            r0.mostrar_game = r11
            int r1 = r1 + 1
            goto L_0x0309
        L_0x0349:
            r1 = 2131363473(0x7f0a0691, float:1.8346756E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.os.Bundle r11 = r0.extras
            java.lang.String r12 = "nombre"
            java.lang.String r11 = r11.getString(r12)
            r1.setText(r11)
            r1 = 2131362993(0x7f0a04b1, float:1.8345782E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb_enviando = r1
            boolean r1 = r0.c1_esclaro
            if (r1 != 0) goto L_0x0374
            android.view.View r1 = r0.findViewById(r7)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb_enviando = r1
        L_0x0374:
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "fnac_d"
            java.lang.String r1 = r1.getString(r7)
            int r1 = java.lang.Integer.parseInt(r1)
            android.os.Bundle r7 = r0.extras
            java.lang.String r11 = "fnac_m"
            java.lang.String r7 = r7.getString(r11)
            int r7 = java.lang.Integer.parseInt(r7)
            android.os.Bundle r11 = r0.extras
            java.lang.String r12 = "fnac_a"
            java.lang.String r11 = r11.getString(r12)
            int r11 = java.lang.Integer.parseInt(r11)
            android.os.Bundle r12 = r0.extras
            java.lang.String r13 = "p_fnac"
            int r12 = r12.getInt(r13)
            if (r12 <= 0) goto L_0x03e4
            if (r1 <= 0) goto L_0x03e4
            if (r7 <= 0) goto L_0x03e4
            if (r11 <= 0) goto L_0x03e4
            java.util.Calendar r12 = java.util.Calendar.getInstance()
            int r7 = r7 - r5
            r12.set(r11, r7, r1)
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            int r7 = r1.get(r5)
            int r11 = r12.get(r5)
            int r7 = r7 - r11
            r0.edat = r7
            int r7 = r12.get(r2)
            int r11 = r1.get(r2)
            if (r7 > r11) goto L_0x03df
            int r7 = r12.get(r2)
            int r11 = r1.get(r2)
            if (r7 != r11) goto L_0x03e4
            r7 = 5
            int r7 = r12.get(r7)
            r11 = 5
            int r1 = r1.get(r11)
            if (r7 <= r1) goto L_0x03e4
        L_0x03df:
            int r1 = r0.edat
            int r1 = r1 - r5
            r0.edat = r1
        L_0x03e4:
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "p_dist"
            int r1 = r1.getInt(r7)
            if (r1 <= 0) goto L_0x040c
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "dist"
            boolean r1 = r1.containsKey(r7)
            if (r1 == 0) goto L_0x040c
            android.os.Bundle r1 = r0.extras
            java.lang.String r1 = r1.getString(r7)
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x040c
            android.os.Bundle r1 = r0.extras
            java.lang.String r1 = r1.getString(r7)
            r0.dist = r1
        L_0x040c:
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            long r11 = r0.idusu
            r7.append(r11)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0443
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "conectado"
            boolean r1 = r1.containsKey(r7)
            if (r1 == 0) goto L_0x0443
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "conectado"
            boolean r1 = r1.getBoolean(r7)
            if (r1 == 0) goto L_0x0443
            r1 = 2131362443(0x7f0a028b, float:1.8344667E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
        L_0x0443:
            r17.mostrar_subtit()
            r1 = 2131362153(0x7f0a0169, float:1.8344079E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_descr = r1
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "p_descr"
            int r1 = r1.getInt(r7)
            if (r1 <= 0) goto L_0x0497
            android.content.SharedPreferences r1 = r0.settings
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "descr_"
            r7.<init>(r11)
            java.lang.String r11 = r0.idusu_profile
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            java.lang.String r1 = r1.getString(r7, r6)
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0497
            android.widget.TextView r1 = r0.tv_descr
            android.content.SharedPreferences r7 = r0.settings
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "descr_"
            r11.<init>(r12)
            java.lang.String r12 = r0.idusu_profile
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r7 = r7.getString(r11, r6)
            r1.setText(r7)
            android.widget.TextView r1 = r0.tv_descr
            r1.setVisibility(r4)
        L_0x0497:
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "vfoto"
            java.lang.String r1 = r1.getString(r7)
            r0.vfoto = r1
            android.os.Bundle r1 = r0.extras
            java.lang.String r7 = "fotos_perfil"
            int r1 = r1.getInt(r7)
            r0.fotos_perfil = r1
            r1 = 2131362513(0x7f0a02d1, float:1.8344809E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.iv = r1
            int r1 = r0.fotos_perfil
            r7 = 1056964608(0x3f000000, float:0.5)
            r11 = 8
            if (r1 == 0) goto L_0x05de
            java.lang.String r1 = r0.vfoto
            java.lang.String r12 = "0"
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x04ca
            goto L_0x05de
        L_0x04ca:
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            long r13 = r0.idusu
            r12.append(r13)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x0509
            android.widget.ImageView r1 = r0.iv     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            android.content.ContentResolver r8 = r17.getContentResolver()     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            stikerwap.appdys.config r9 = r0.globales     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            java.io.File r9 = r9.getTempFile(r0, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            android.net.Uri r9 = android.net.Uri.fromFile(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            android.graphics.Bitmap r8 = android.provider.MediaStore.Images.Media.getBitmap(r8, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            r1.setImageBitmap(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            android.widget.ImageView r1 = r0.iv     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            stikerwap.appdys.profile$3 r8 = new stikerwap.appdys.profile$3     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            r1.setOnClickListener(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x0506 }
            goto L_0x05e6
        L_0x0506:
            goto L_0x05e6
        L_0x0509:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r12 = "fperfil_"
            r1.<init>(r12)
            java.lang.String r12 = r0.idusu_profile
            r1.append(r12)
            java.lang.String r12 = "_g.jpg"
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            java.io.File r12 = new java.io.File     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            java.io.File r13 = r0.path     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r12.<init>(r13, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.graphics.BitmapFactory$Options r13 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r13.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r13.inJustDecodeBounds = r5     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            java.lang.String r14 = r12.getPath()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.graphics.BitmapFactory.decodeFile(r14, r13)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            int r14 = r13.outWidth     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.content.res.Resources r14 = r17.getResources()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.util.DisplayMetrics r14 = r14.getDisplayMetrics()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            float r14 = r14.density     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r15 = 1142292480(0x44160000, float:600.0)
            float r14 = r14 * r15
            float r14 = r14 + r7
            int r14 = (int) r14     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.content.res.Resources r15 = r17.getResources()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.util.DisplayMetrics r15 = r15.getDisplayMetrics()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            float r15 = r15.density     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r16 = 1142292480(0x44160000, float:600.0)
            float r15 = r15 * r16
            float r15 = r15 + r7
            int r15 = (int) r15     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            int r2 = r13.outWidth     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            int r13 = r13.outHeight     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            if (r2 > r14) goto L_0x0560
            if (r13 > r15) goto L_0x0560
            r16 = 1
            goto L_0x0562
        L_0x0560:
            r16 = 0
        L_0x0562:
            if (r16 != 0) goto L_0x057f
            int r13 = stikerwap.appdys.config.calculateNewWidth(r2, r13, r14, r15)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            float r2 = (float) r2     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            float r13 = (float) r13     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            float r2 = r2 / r13
            int r2 = java.lang.Math.round(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.graphics.BitmapFactory$Options r13 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r13.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r13.inSampleSize = r2     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            java.lang.String r2 = r12.getPath()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2, r13)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            goto L_0x058b
        L_0x057f:
            android.content.ContentResolver r2 = r17.getContentResolver()     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.net.Uri r12 = android.net.Uri.fromFile(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.graphics.Bitmap r2 = android.provider.MediaStore.Images.Media.getBitmap(r2, r12)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
        L_0x058b:
            android.widget.ImageView r12 = r0.iv     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r12.setImageBitmap(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            android.widget.ImageView r2 = r0.iv     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            stikerwap.appdys.profile$4 r12 = new stikerwap.appdys.profile$4     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r12.<init>(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            r2.setOnClickListener(r12)     // Catch:{ Exception | OutOfMemoryError -> 0x059b }
            goto L_0x059c
        L_0x059b:
        L_0x059c:
            android.content.SharedPreferences r1 = r0.settings
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r12 = "fperfil_"
            r2.<init>(r12)
            java.lang.String r12 = r0.idusu_profile
            r2.append(r12)
            java.lang.String r12 = "_g"
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String r1 = r1.getString(r2, r6)
            java.lang.String r2 = r0.vfoto
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x05e6
            boolean r1 = r0.c1_esclaro
            if (r1 == 0) goto L_0x05cb
            android.view.View r1 = r0.findViewById(r8)
            r1.setVisibility(r4)
            goto L_0x05d2
        L_0x05cb:
            android.view.View r1 = r0.findViewById(r9)
            r1.setVisibility(r4)
        L_0x05d2:
            stikerwap.appdys.profile$obtener_foto r1 = new stikerwap.appdys.profile$obtener_foto
            r2 = 0
            r1.<init>()
            java.lang.String[] r2 = new java.lang.String[r4]
            r1.execute(r2)
            goto L_0x05e6
        L_0x05de:
            android.widget.ImageView r1 = r0.iv
            r1.setVisibility(r11)
            r17.mostrar_viewsaux()
        L_0x05e6:
            int r1 = r0.fotos_perfil
            if (r1 <= 0) goto L_0x063f
            stikerwap.appdys.config r1 = r0.globales
            java.io.File r1 = r1.getTempFile(r0, r5)
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r2.inJustDecodeBounds = r5     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            java.lang.String r8 = r1.getPath()     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            android.graphics.BitmapFactory.decodeFile(r8, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            int r8 = r2.outWidth     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            int r8 = r2.outWidth     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            int r2 = r2.outHeight     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r9 = 75
            r12 = 100
            if (r8 > r9) goto L_0x060e
            if (r2 > r12) goto L_0x060e
            r13 = 1
            goto L_0x060f
        L_0x060e:
            r13 = 0
        L_0x060f:
            if (r13 != 0) goto L_0x062e
            int r2 = stikerwap.appdys.config.calculateNewWidth(r8, r2, r9, r12)     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            float r8 = (float) r8     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            float r2 = (float) r2     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            float r8 = r8 / r2
            int r2 = java.lang.Math.round(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r8.inSampleSize = r2     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r0.bm_propia = r1     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            goto L_0x0649
        L_0x062e:
            android.content.ContentResolver r2 = r17.getContentResolver()     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            android.graphics.Bitmap r1 = android.provider.MediaStore.Images.Media.getBitmap(r2, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            r0.bm_propia = r1     // Catch:{ Exception | OutOfMemoryError -> 0x063d }
            goto L_0x0649
        L_0x063d:
            goto L_0x0649
        L_0x063f:
            r1 = 2131362515(0x7f0a02d3, float:1.8344813E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r11)
        L_0x0649:
            r1 = 2131362579(0x7f0a0313, float:1.8344943E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_coments = r1
            android.os.Bundle r1 = r0.extras
            java.lang.String r2 = "coments"
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            r2 = -1
            if (r1 == 0) goto L_0x0791
            android.os.Bundle r1 = r0.extras
            java.lang.String r8 = "coments_chat"
            boolean r1 = r1.getBoolean(r8)
            if (r1 == 0) goto L_0x0791
            boolean r1 = r0.c1_esclaro
            if (r1 != 0) goto L_0x0675
            r1 = -1
            goto L_0x0677
        L_0x0675:
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0677:
            r8 = 2131363401(0x7f0a0649, float:1.834661E38)
            android.view.View r8 = r0.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r8.setTextColor(r1)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r8 = stikerwap.appdys.config.esClaro(r8)
            if (r8 == 0) goto L_0x06a2
            r8 = 2131362451(0x7f0a0293, float:1.8344683E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setVisibility(r4)
            goto L_0x06ac
        L_0x06a2:
            r8 = 2131362450(0x7f0a0292, float:1.834468E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setVisibility(r4)
        L_0x06ac:
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131230928(0x7f0800d0, float:1.8077923E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r9)
            java.lang.String r9 = r0.cbtn
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x06d6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.String r12 = r0.cbtn
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.MULTIPLY
            r8.setColorFilter(r9, r12)
        L_0x06d6:
            r9 = 2131362452(0x7f0a0294, float:1.8344685E38)
            android.view.View r9 = r0.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r9.setImageDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r8 = stikerwap.appdys.config.esClaro(r8)
            if (r8 == 0) goto L_0x0701
            r8 = 2131362476(0x7f0a02ac, float:1.8344734E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setVisibility(r4)
            goto L_0x070b
        L_0x0701:
            r8 = 2131362475(0x7f0a02ab, float:1.8344732E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setVisibility(r4)
        L_0x070b:
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131231437(0x7f0802cd, float:1.8078955E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r9)
            java.lang.String r9 = r0.cbtn
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x0735
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.String r12 = r0.cbtn
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.MULTIPLY
            r8.setColorFilter(r9, r12)
        L_0x0735:
            r9 = 2131362474(0x7f0a02aa, float:1.834473E38)
            android.view.View r9 = r0.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r9.setImageDrawable(r8)
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 <= r10) goto L_0x075b
            r1 = 2131362216(0x7f0a01a8, float:1.8344206E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            boolean r8 = r0.c1_esclaro
            r8 = r8 ^ r5
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.String r9 = r0.cbtn
            stikerwap.appdys.config.edittext_color(r1, r8, r9)
            goto L_0x0767
        L_0x075b:
            r8 = 2131362216(0x7f0a01a8, float:1.8344206E38)
            android.view.View r8 = r0.findViewById(r8)
            android.widget.EditText r8 = (android.widget.EditText) r8
            r8.setTextColor(r1)
        L_0x0767:
            r1 = 2131362452(0x7f0a0294, float:1.8344685E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            r1 = 2131362474(0x7f0a02aa, float:1.834473E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            r1 = 2131362515(0x7f0a02d3, float:1.8344813E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.graphics.Bitmap r8 = r0.bm_propia
            android.graphics.Bitmap r8 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r8, r5)
            r1.setImageBitmap(r8)
            r0.mostrar_coments(r5)
            goto L_0x07aa
        L_0x0791:
            r1 = 2131363401(0x7f0a0649, float:1.834661E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r11)
            r1 = 2131363120(0x7f0a0530, float:1.834604E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r11)
            android.widget.LinearLayout r1 = r0.ll_coments
            r1.setVisibility(r11)
        L_0x07aa:
            r0.ind_global = r4
            r0.fotos_glob_a_completo = r4
            r1 = 2131362453(0x7f0a0295, float:1.8344687E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f1 = r1
            r1 = 2131362455(0x7f0a0297, float:1.8344691E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f2 = r1
            r1 = 2131362457(0x7f0a0299, float:1.8344695E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f3 = r1
            r1 = 2131362459(0x7f0a029b, float:1.83447E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f4 = r1
            r1 = 2131362612(0x7f0a0334, float:1.834501E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_likes1 = r1
            r1 = 2131362614(0x7f0a0336, float:1.8345014E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_likes2 = r1
            r1 = 2131362616(0x7f0a0338, float:1.8345018E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_likes3 = r1
            r1 = 2131362618(0x7f0a033a, float:1.8345022E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_likes4 = r1
            r1 = 2131363432(0x7f0a0668, float:1.8346673E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_likes1 = r1
            r1 = 2131363434(0x7f0a066a, float:1.8346677E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_likes2 = r1
            r1 = 2131363436(0x7f0a066c, float:1.834668E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_likes3 = r1
            r1 = 2131363438(0x7f0a066e, float:1.8346685E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_likes4 = r1
            boolean r1 = r0.c1_esclaro
            r5 = 2131363323(0x7f0a05fb, float:1.8346452E38)
            r8 = 2131231190(0x7f0801d6, float:1.8078454E38)
            if (r1 == 0) goto L_0x08a9
            r1 = 2131362978(0x7f0a04a2, float:1.8345752E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb1 = r1
            r1 = 2131362980(0x7f0a04a4, float:1.8345756E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb2 = r1
            r1 = 2131362982(0x7f0a04a6, float:1.834576E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb3 = r1
            r1 = 2131362984(0x7f0a04a8, float:1.8345764E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb4 = r1
            r1 = 2131363115(0x7f0a052b, float:1.834603E38)
            android.view.View r1 = r0.findViewById(r1)
            java.lang.String r9 = "#FFEEEEEE"
            int r9 = android.graphics.Color.parseColor(r9)
            r1.setBackgroundColor(r9)
            r1 = 2131363428(0x7f0a0664, float:1.8346665E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r9 = stikerwap.appdys.config.NEGRO
            r1.setTextColor(r9)
            r1 = 2131363477(0x7f0a0695, float:1.8346764E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r9 = stikerwap.appdys.config.NEGRO
            r1.setTextColor(r9)
            android.view.View r1 = r0.findViewById(r5)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r1.setBackgroundResource(r8)
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r9 = stikerwap.appdys.config.BLANCO_2
            r1.setColor(r9)
            goto L_0x090d
        L_0x08a9:
            r1 = 2131362977(0x7f0a04a1, float:1.834575E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb1 = r1
            r1 = 2131362979(0x7f0a04a3, float:1.8345754E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb2 = r1
            r1 = 2131362981(0x7f0a04a5, float:1.8345758E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb3 = r1
            r1 = 2131362983(0x7f0a04a7, float:1.8345762E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb4 = r1
            r1 = 2131363115(0x7f0a052b, float:1.834603E38)
            android.view.View r1 = r0.findViewById(r1)
            int r9 = stikerwap.appdys.config.GRIS_OSCURO
            r1.setBackgroundColor(r9)
            r1 = 2131363428(0x7f0a0664, float:1.8346665E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setTextColor(r2)
            r1 = 2131363477(0x7f0a0695, float:1.8346764E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setTextColor(r2)
            android.view.View r1 = r0.findViewById(r5)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r1.setBackgroundResource(r8)
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r9 = stikerwap.appdys.config.NEGRO
            r1.setColor(r9)
        L_0x090d:
            android.os.Bundle r1 = r0.extras
            java.lang.String r9 = "galeria"
            boolean r1 = r1.getBoolean(r9)
            if (r1 == 0) goto L_0x0a61
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r5 = r0.cbtn
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x0940
            r1 = 2131362479(0x7f0a02af, float:1.834474E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            r1 = 2131362485(0x7f0a02b5, float:1.8344752E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            goto L_0x0954
        L_0x0940:
            r1 = 2131362478(0x7f0a02ae, float:1.8344738E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            r1 = 2131362484(0x7f0a02b4, float:1.834475E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
        L_0x0954:
            android.content.res.Resources r1 = r17.getResources()
            r5 = 2131231687(0x7f0803c7, float:1.8079462E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r5)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x097e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r9 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r5, r9)
        L_0x097e:
            r5 = 2131362477(0x7f0a02ad, float:1.8344736E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageDrawable(r1)
            r1 = 2131362477(0x7f0a02ad, float:1.8344736E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            android.content.res.Resources r1 = r17.getResources()
            r5 = 2131230818(0x7f080062, float:1.80777E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r5)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x09be
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r9 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r5, r9)
        L_0x09be:
            r5 = 2131362483(0x7f0a02b3, float:1.8344748E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageDrawable(r1)
            r1 = 2131362483(0x7f0a02b3, float:1.8344748E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            r17.mostrar_fotos()
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r9 = r0.idusu
            r5.append(r9)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0a68
            r1 = 2131361990(0x7f0a00c6, float:1.8343748E38)
            android.view.View r5 = r0.findViewById(r1)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.res.Resources r9 = r17.getResources()
            r10 = 2131886125(0x7f12002d, float:1.940682E38)
            java.lang.String r9 = r9.getString(r10)
            java.lang.String r9 = r9.toUpperCase()
            r5.setText(r9)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0a2e
            android.view.View r5 = r0.findViewById(r1)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.String r10 = r0.cbtn
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            int r9 = android.graphics.Color.parseColor(r9)
            r5.setBackgroundColor(r9)
        L_0x0a2e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            boolean r5 = stikerwap.appdys.config.esClaro(r5)
            if (r5 == 0) goto L_0x0a45
            int r5 = stikerwap.appdys.config.NEGRO
            goto L_0x0a46
        L_0x0a45:
            r5 = -1
        L_0x0a46:
            android.view.View r9 = r0.findViewById(r1)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r9.setTextColor(r5)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            r1 = 2131362563(0x7f0a0303, float:1.834491E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            goto L_0x0a68
        L_0x0a61:
            android.view.View r1 = r0.findViewById(r5)
            r1.setVisibility(r11)
        L_0x0a68:
            r0.ind_v_global = r4
            r0.videos_glob_a_completo = r4
            r1 = 2131362454(0x7f0a0296, float:1.834469E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f1_v = r1
            r1 = 2131362456(0x7f0a0298, float:1.8344693E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f2_v = r1
            r1 = 2131362458(0x7f0a029a, float:1.8344697E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f3_v = r1
            r1 = 2131362460(0x7f0a029c, float:1.8344701E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.f4_v = r1
            r1 = 2131362613(0x7f0a0335, float:1.8345012E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_v_likes1 = r1
            r1 = 2131362615(0x7f0a0337, float:1.8345016E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_v_likes2 = r1
            r1 = 2131362617(0x7f0a0339, float:1.834502E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_v_likes3 = r1
            r1 = 2131362619(0x7f0a033b, float:1.8345024E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.ll_v_likes4 = r1
            r1 = 2131363433(0x7f0a0669, float:1.8346675E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_v_likes1 = r1
            r1 = 2131363435(0x7f0a066b, float:1.8346679E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_v_likes2 = r1
            r1 = 2131363437(0x7f0a066d, float:1.8346683E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_v_likes3 = r1
            r1 = 2131363439(0x7f0a066f, float:1.8346687E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_v_likes4 = r1
            boolean r1 = r0.c1_esclaro
            r5 = 2131363325(0x7f0a05fd, float:1.8346456E38)
            if (r1 == 0) goto L_0x0b56
            r1 = 2131363030(0x7f0a04d6, float:1.8345857E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb1_v = r1
            r1 = 2131363032(0x7f0a04d8, float:1.8345861E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb2_v = r1
            r1 = 2131363034(0x7f0a04da, float:1.8345865E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb3_v = r1
            r1 = 2131363036(0x7f0a04dc, float:1.834587E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb4_v = r1
            r1 = 2131363116(0x7f0a052c, float:1.8346032E38)
            android.view.View r1 = r0.findViewById(r1)
            java.lang.String r9 = "#FFEEEEEE"
            int r9 = android.graphics.Color.parseColor(r9)
            r1.setBackgroundColor(r9)
            r1 = 2131363481(0x7f0a0699, float:1.8346772E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r9 = stikerwap.appdys.config.NEGRO
            r1.setTextColor(r9)
            android.view.View r1 = r0.findViewById(r5)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r1.setBackgroundResource(r8)
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r8 = stikerwap.appdys.config.BLANCO_2
            r1.setColor(r8)
            goto L_0x0bae
        L_0x0b56:
            r1 = 2131363029(0x7f0a04d5, float:1.8345855E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb1_v = r1
            r1 = 2131363031(0x7f0a04d7, float:1.834586E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb2_v = r1
            r1 = 2131363033(0x7f0a04d9, float:1.8345863E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb3_v = r1
            r1 = 2131363035(0x7f0a04db, float:1.8345867E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb4_v = r1
            r1 = 2131363116(0x7f0a052c, float:1.8346032E38)
            android.view.View r1 = r0.findViewById(r1)
            int r9 = stikerwap.appdys.config.GRIS_OSCURO
            r1.setBackgroundColor(r9)
            r1 = 2131363481(0x7f0a0699, float:1.8346772E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setTextColor(r2)
            android.view.View r1 = r0.findViewById(r5)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r1.setBackgroundResource(r8)
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r8 = stikerwap.appdys.config.NEGRO
            r1.setColor(r8)
        L_0x0bae:
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.galeriav
            if (r1 == 0) goto L_0x0cfc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r5 = r0.cbtn
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x0bdd
            r1 = 2131362482(0x7f0a02b2, float:1.8344746E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            r1 = 2131362488(0x7f0a02b8, float:1.8344758E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            goto L_0x0bf1
        L_0x0bdd:
            r1 = 2131362481(0x7f0a02b1, float:1.8344744E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            r1 = 2131362487(0x7f0a02b7, float:1.8344756E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
        L_0x0bf1:
            android.content.res.Resources r1 = r17.getResources()
            r5 = 2131231687(0x7f0803c7, float:1.8079462E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r5)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0c1b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r8 = r0.cbtn
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r8 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r5, r8)
        L_0x0c1b:
            r5 = 2131362480(0x7f0a02b0, float:1.8344742E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageDrawable(r1)
            r1 = 2131362480(0x7f0a02b0, float:1.8344742E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            android.content.res.Resources r1 = r17.getResources()
            r5 = 2131230818(0x7f080062, float:1.80777E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r5)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0c5b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r8 = r0.cbtn
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r8 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r5, r8)
        L_0x0c5b:
            r5 = 2131362486(0x7f0a02b6, float:1.8344754E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageDrawable(r1)
            r1 = 2131362486(0x7f0a02b6, float:1.8344754E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            r17.mostrar_videos()
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r8 = r0.idusu
            r5.append(r8)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0d03
            r1 = 2131361999(0x7f0a00cf, float:1.8343766E38)
            android.view.View r5 = r0.findViewById(r1)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131886125(0x7f12002d, float:1.940682E38)
            java.lang.String r8 = r8.getString(r9)
            java.lang.String r8 = r8.toUpperCase()
            r5.setText(r8)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0ccb
            android.view.View r5 = r0.findViewById(r1)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r5.setBackgroundColor(r8)
        L_0x0ccb:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r8 = r0.cbtn
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            boolean r5 = stikerwap.appdys.config.esClaro(r5)
            if (r5 == 0) goto L_0x0ce1
            int r2 = stikerwap.appdys.config.NEGRO
        L_0x0ce1:
            android.view.View r5 = r0.findViewById(r1)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setTextColor(r2)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            r1 = 2131362564(0x7f0a0304, float:1.8344912E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            goto L_0x0d03
        L_0x0cfc:
            android.view.View r1 = r0.findViewById(r5)
            r1.setVisibility(r11)
        L_0x0d03:
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r8 = r0.idusu
            r2.append(r8)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0d27
            r1 = 2131362422(0x7f0a0276, float:1.8344624E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r11)
            goto L_0x0d31
        L_0x0d27:
            r1 = 2131362422(0x7f0a0276, float:1.8344624E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
        L_0x0d31:
            android.os.Bundle r1 = r0.extras
            java.lang.String r2 = "privados_chat"
            boolean r1 = r1.getBoolean(r2)
            r2 = 2131362495(0x7f0a02bf, float:1.8344772E38)
            if (r1 == 0) goto L_0x0dd5
            android.os.Bundle r1 = r0.extras
            java.lang.String r5 = "privados"
            java.lang.String r1 = r1.getString(r5)
            java.lang.String r5 = "1"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0dd5
            java.lang.String r1 = r0.idusu_profile
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r8 = r0.idusu
            r5.append(r8)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0dd5
            android.os.Bundle r1 = r0.extras
            java.lang.String r5 = "desdepriv"
            boolean r1 = r1.containsKey(r5)
            if (r1 != 0) goto L_0x0dd5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r5 = r0.cbtn
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x0d90
            r1 = 2131362425(0x7f0a0279, float:1.834463E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
            goto L_0x0d9a
        L_0x0d90:
            r1 = 2131362424(0x7f0a0278, float:1.8344628E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r4)
        L_0x0d9a:
            android.content.res.Resources r1 = r17.getResources()
            r5 = 2131231217(0x7f0801f1, float:1.8078509E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r5)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0dc4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r8 = r0.cbtn
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r8 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r5, r8)
        L_0x0dc4:
            android.view.View r5 = r0.findViewById(r2)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageDrawable(r1)
            android.view.View r1 = r0.findViewById(r2)
            r1.setOnClickListener(r0)
            goto L_0x0ddc
        L_0x0dd5:
            android.view.View r1 = r0.findViewById(r2)
            r1.setVisibility(r11)
        L_0x0ddc:
            r1 = 2131363441(0x7f0a0671, float:1.834669E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r5 = 2131363442(0x7f0a0672, float:1.8346693E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r8 = 2131362461(0x7f0a029d, float:1.8344703E38)
            android.view.View r8 = r0.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r0.iv_favorito = r8
            boolean r8 = r0.mostrar_game
            r9 = 1116471296(0x428c0000, float:70.0)
            r10 = 2131362316(0x7f0a020c, float:1.834441E38)
            if (r8 == 0) goto L_0x0ee1
            android.view.View r8 = r0.findViewById(r2)
            int r8 = r8.getVisibility()
            if (r8 != r11) goto L_0x0e67
            android.view.View r8 = r0.findViewById(r10)
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r8 = (android.widget.RelativeLayout.LayoutParams) r8
            android.content.res.Resources r12 = r17.getResources()
            android.util.DisplayMetrics r12 = r12.getDisplayMetrics()
            float r12 = r12.density
            r13 = 1092616192(0x41200000, float:10.0)
            float r12 = r12 * r13
            float r12 = r12 + r7
            int r12 = (int) r12
            r8.rightMargin = r12
            android.view.View r12 = r0.findViewById(r10)
            r12.setLayoutParams(r8)
            android.widget.ImageView r8 = r0.iv_favorito
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r8 = (android.widget.RelativeLayout.LayoutParams) r8
            android.content.res.Resources r12 = r17.getResources()
            android.util.DisplayMetrics r12 = r12.getDisplayMetrics()
            float r12 = r12.density
            float r12 = r12 * r9
            float r12 = r12 + r7
            int r12 = (int) r12
            r8.rightMargin = r12
            android.widget.ImageView r12 = r0.iv_favorito
            r12.setLayoutParams(r8)
            android.view.ViewGroup$LayoutParams r8 = r1.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r8 = (android.widget.RelativeLayout.LayoutParams) r8
            android.content.res.Resources r12 = r17.getResources()
            android.util.DisplayMetrics r12 = r12.getDisplayMetrics()
            float r12 = r12.density
            r13 = 1124204544(0x43020000, float:130.0)
            float r12 = r12 * r13
            float r12 = r12 + r7
            int r12 = (int) r12
            r8.rightMargin = r12
            r1.setLayoutParams(r8)
        L_0x0e67:
            android.content.res.Resources r8 = r17.getResources()
            r12 = 2131230923(0x7f0800cb, float:1.8077912E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r12)
            java.lang.String r12 = r0.cbtn
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x0e91
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r3)
            java.lang.String r13 = r0.cbtn
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            int r12 = android.graphics.Color.parseColor(r12)
            android.graphics.PorterDuff$Mode r13 = android.graphics.PorterDuff.Mode.MULTIPLY
            r8.setColorFilter(r12, r13)
        L_0x0e91:
            r12 = 2131362507(0x7f0a02cb, float:1.8344797E38)
            android.view.View r12 = r0.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r12.setImageDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r12 = r0.cbtn
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            boolean r8 = stikerwap.appdys.config.esClaro(r8)
            if (r8 == 0) goto L_0x0ebc
            r8 = 2131362508(0x7f0a02cc, float:1.8344799E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setVisibility(r4)
            goto L_0x0ec6
        L_0x0ebc:
            r8 = 2131362506(0x7f0a02ca, float:1.8344795E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setVisibility(r4)
        L_0x0ec6:
            android.view.View r8 = r0.findViewById(r10)
            r8.setOnClickListener(r0)
            android.os.Bundle r8 = r0.extras
            if (r8 == 0) goto L_0x0ee8
            java.lang.String r12 = "abrir_game"
            boolean r8 = r8.containsKey(r12)
            if (r8 == 0) goto L_0x0ee8
            android.view.View r8 = r0.findViewById(r10)
            r8.performClick()
            goto L_0x0ee8
        L_0x0ee1:
            android.view.View r8 = r0.findViewById(r10)
            r8.setVisibility(r11)
        L_0x0ee8:
            java.lang.String r8 = r0.idusu_profile
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            long r12 = r0.idusu
            r10.append(r12)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0fcf
            boolean r5 = r0.mostrar_game
            if (r5 != 0) goto L_0x0f80
            android.view.View r2 = r0.findViewById(r2)
            int r2 = r2.getVisibility()
            if (r2 != r11) goto L_0x0f48
            android.widget.ImageView r2 = r0.iv_favorito
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            android.content.res.Resources r5 = r17.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            r8 = 1092616192(0x41200000, float:10.0)
            float r5 = r5 * r8
            float r5 = r5 + r7
            int r5 = (int) r5
            r2.rightMargin = r5
            android.widget.ImageView r5 = r0.iv_favorito
            r5.setLayoutParams(r2)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            android.content.res.Resources r5 = r17.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            float r5 = r5 * r9
            float r5 = r5 + r7
            int r5 = (int) r5
            r2.rightMargin = r5
            r1.setLayoutParams(r2)
            goto L_0x0f80
        L_0x0f48:
            android.widget.ImageView r2 = r0.iv_favorito
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            android.content.res.Resources r5 = r17.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            float r5 = r5 * r9
            float r5 = r5 + r7
            int r5 = (int) r5
            r2.rightMargin = r5
            android.widget.ImageView r5 = r0.iv_favorito
            r5.setLayoutParams(r2)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            android.content.res.Resources r5 = r17.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            r8 = 1124204544(0x43020000, float:130.0)
            float r5 = r5 * r8
            float r5 = r5 + r7
            int r5 = (int) r5
            r2.rightMargin = r5
            r1.setLayoutParams(r2)
        L_0x0f80:
            android.content.res.Resources r2 = r17.getResources()
            r5 = 2131231428(0x7f0802c4, float:1.8078937E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r5)
            java.lang.String r5 = r0.cbtn
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0faa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r6 = r0.cbtn
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.MULTIPLY
            r2.setColorFilter(r5, r6)
        L_0x0faa:
            r1.setBackgroundDrawable(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r3 = r0.cbtn
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            if (r2 == 0) goto L_0x0fc6
            int r2 = stikerwap.appdys.config.NEGRO
            r1.setTextColor(r2)
        L_0x0fc6:
            r1.setOnClickListener(r0)
            android.widget.ImageView r1 = r0.iv_favorito
            r1.setOnClickListener(r0)
            goto L_0x101d
        L_0x0fcf:
            android.content.res.Resources r1 = r17.getResources()
            r2 = 2131231431(0x7f0802c7, float:1.8078943E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            java.lang.String r2 = r0.cbtn
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0ff9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r6 = r0.cbtn
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            int r2 = android.graphics.Color.parseColor(r2)
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r2, r6)
        L_0x0ff9:
            r5.setBackgroundDrawable(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r0.cbtn
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x1015
            int r1 = stikerwap.appdys.config.NEGRO
            r5.setTextColor(r1)
        L_0x1015:
            r5.setOnClickListener(r0)
            android.widget.ImageView r1 = r0.iv_favorito
            r1.setVisibility(r11)
        L_0x101d:
            android.view.Window r1 = r17.getWindow()
            r2 = 2
            r1.setSoftInputMode(r2)
            stikerwap.appdys.profile$cargarprofile r1 = new stikerwap.appdys.profile$cargarprofile
            r2 = 0
            r1.<init>()
            java.lang.String[] r2 = new java.lang.String[r4]
            r1.execute(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.onCreate(android.os.Bundle):void");
    }

    private void banner() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            if (!this.idusu_profile.equals(this.idusu + "")) {
                z7 = (this.globales.admob_pro_cod.equals("") || this.globales.admob_pro_w == 0 || this.globales.admob_pro_h == 0) ? false : true;
                z5 = !this.globales.appnext_pro_cod.equals("") && this.globales.appnext_ads != null && this.globales.appnext_ads.size() > 0;
                z4 = !this.globales.fb_pro_cod.equals("");
                z3 = !this.globales.st_pro_cod.equals("");
                z2 = !this.globales.is_pro_cod.equals("");
                z = !this.globales.uni_pro_cod.equals("");
                z6 = !this.globales.wortise_pro_cod.equals("");
            } else {
                z7 = false;
                z6 = false;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            }
            ArrayList arrayList = new ArrayList();
            if (z7) {
                arrayList.add(1);
            }
            if (z5 && !z6) {
                arrayList.add(2);
            }
            if (z4) {
                arrayList.add(3);
            }
            if (z3) {
                arrayList.add(4);
            }
            if (z2) {
                arrayList.add(5);
            }
            if (z && UnityAds.isInitialized()) {
                arrayList.add(6);
            }
            if (z6) {
                arrayList.add(7);
            }
            int intValue = !arrayList.isEmpty() ? ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue() : 0;
            if (intValue == 1) {
                AdView adView = new AdView(this);
                adView.setAdSize(AdSize.LARGE_BANNER);
                adView.setAdUnitId(this.globales.admob_pro_cod);
                findViewById(R.id.tv_appreco).setVisibility(8);
                ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
                ((LinearLayout) findViewById(R.id.ll_nat_ad)).removeAllViews();
                ((LinearLayout) findViewById(R.id.ll_nat_ad)).addView(adView);
                adView.loadAd(new AdRequest.Builder().build());
            } else if (intValue == 2) {
                if (config.esClaro("#" + this.c1)) {
                    ((TextView) findViewById(R.id.tv_appreco)).setTextColor(config.NEGRO);
                }
                this.globales.appnext_mostrar_2(this, 1, 2, -1, (String) null);
            } else if (intValue == 3) {
                final NativeBannerAd nativeBannerAd = new NativeBannerAd((Context) this, this.globales.fb_pro_cod);
                findViewById(R.id.tv_appreco).setVisibility(8);
                nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withAdListener(new NativeAdListener() {
                    public void onAdClicked(Ad ad) {
                    }

                    public void onError(Ad ad, AdError adError) {
                    }

                    public void onLoggingImpression(Ad ad) {
                    }

                    public void onMediaDownloaded(Ad ad) {
                    }

                    public void onAdLoaded(Ad ad) {
                        NativeAdViewAttributes backgroundColor = new NativeAdViewAttributes().setTypeface(Typeface.MONOSPACE).setBackgroundColor(config.BLANCO_2);
                        if (profile.this.c1 != null && !profile.this.c1.equals("")) {
                            int canviarColor = config.canviarColor(Color.parseColor("#" + profile.this.c1), 0.2f, 0);
                            backgroundColor.setBackgroundColor(canviarColor);
                            if (config.esClaro_int(canviarColor)) {
                                backgroundColor.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
                                backgroundColor.setDescriptionTextColor(ViewCompat.MEASURED_STATE_MASK);
                            } else {
                                backgroundColor.setTitleTextColor(-1);
                                backgroundColor.setDescriptionTextColor(-1);
                            }
                        }
                        if (profile.this.cbtn != null && !profile.this.cbtn.equals("")) {
                            backgroundColor.setButtonColor(Color.parseColor("#" + profile.this.cbtn));
                            if (config.esClaro("#" + profile.this.cbtn)) {
                                backgroundColor.setButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                            } else {
                                backgroundColor.setButtonTextColor(-1);
                            }
                        }
                        View render = NativeBannerAdView.render(profile.this, nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100, backgroundColor);
                        LinearLayout linearLayout = (LinearLayout) profile.this.findViewById(R.id.ll_nat);
                        try {
                            if (profile.this.c2_esclaro) {
                                linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                            } else {
                                linearLayout.setBackgroundColor(-1);
                            }
                            int dp_to_px = config.dp_to_px(profile.this.getApplicationContext(), 1);
                            linearLayout.setPadding(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        linearLayout.setVisibility(0);
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat_ad)).removeAllViews();
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat_ad)).addView(render);
                    }
                }).build());
            } else if (intValue == 4) {
                Banner banner = new Banner((Context) this, (BannerListener) new BannerListener() {
                    public void onClick(View view) {
                    }

                    public void onFailedToReceiveAd(View view) {
                    }

                    public void onImpression(View view) {
                    }

                    public void onReceiveAd(View view) {
                        LinearLayout linearLayout = (LinearLayout) profile.this.findViewById(R.id.ll_nat);
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                            LinearLayout linearLayout2 = (LinearLayout) profile.this.findViewById(R.id.ll_nat_ad);
                            if (linearLayout2 != null) {
                                linearLayout2.removeAllViews();
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(20);
                                linearLayout2.addView(view, layoutParams);
                            }
                        }
                    }
                });
                banner.setAdTag("BANNER PROFILE");
                findViewById(R.id.tv_appreco).setVisibility(8);
                banner.loadAd(320, 50);
            } else if (intValue == 5) {
                if (this.globales.isBanner_global != null) {
                    IronSource.destroyBanner(this.globales.isBanner_global);
                }
                this.globales.isBanner_global = IronSource.createBanner(this, ISBannerSize.BANNER);
                findViewById(R.id.tv_appreco).setVisibility(8);
                ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
                ((LinearLayout) findViewById(R.id.ll_nat_ad)).removeAllViews();
                ((LinearLayout) findViewById(R.id.ll_nat_ad)).addView(this.globales.isBanner_global);
                IronSource.loadBanner(this.globales.isBanner_global);
            } else if (intValue == 6) {
                findViewById(R.id.tv_appreco).setVisibility(8);
                AnonymousClass7 r1 = new BannerView.IListener() {
                    public void onBannerClick(BannerView bannerView) {
                    }

                    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
                    }

                    public void onBannerLeftApplication(BannerView bannerView) {
                    }

                    public void onBannerShown(BannerView bannerView) {
                    }

                    public void onBannerLoaded(BannerView bannerView) {
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat)).setVisibility(0);
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat_ad)).removeAllViews();
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat_ad)).addView(bannerView);
                    }
                };
                BannerView bannerView = new BannerView(this, this.globales.uni_pro_cod, new UnityBannerSize(320, 50));
                bannerView.setListener(r1);
                bannerView.load();
            } else if (intValue == 7) {
                BannerAd bannerAd = new BannerAd(this);
                this.adView_nat_w = bannerAd;
                bannerAd.setAutoRefresh(false);
                this.adView_nat_w.setAdSize(com.wortise.ads.AdSize.HEIGHT_90);
                this.adView_nat_w.setAdUnitId(this.globales.wortise_pro_cod);
                findViewById(R.id.tv_appreco).setVisibility(8);
                ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
                this.adView_nat_w.setListener(new BannerAd.Listener() {
                    public void onBannerClicked(BannerAd bannerAd) {
                    }

                    public void onBannerFailed(BannerAd bannerAd, com.wortise.ads.AdError adError) {
                        Log.e("ara", "wortise banner failed:" + adError.toString());
                        if (!profile.this.globales.appnext_pro_cod.equals("") && profile.this.globales.appnext_ads != null && profile.this.globales.appnext_ads.size() > 0) {
                            if (config.esClaro("#" + profile.this.c1)) {
                                ((TextView) profile.this.findViewById(R.id.tv_appreco)).setTextColor(config.NEGRO);
                            }
                            profile.this.globales.appnext_mostrar_2(profile.this, 1, 2, -1, (String) null);
                        }
                    }

                    public void onBannerLoaded(BannerAd bannerAd) {
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat_ad)).removeAllViews();
                        ((LinearLayout) profile.this.findViewById(R.id.ll_nat_ad)).addView(profile.this.adView_nat_w);
                    }
                });
                this.adView_nat_w.loadAd();
            } else {
                this.anun = this.globales.mostrar_banner(this, false);
            }
        }
    }

    private class Foto {
        public boolean eliminada;
        public String fcrea;
        public String id;
        public String liked;
        public String nlikes;

        private Foto() {
            this.eliminada = false;
        }
    }

    private class Video {
        public boolean eliminado;
        public String fcrea;
        public String formato;
        public String id;
        public String liked;
        public String nlikes;

        private Video() {
            this.eliminado = false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean pretratar_video(String str) {
        Bitmap bitmap;
        File file = new File(str);
        boolean z = false;
        if (file.length() == 0) {
            return false;
        }
        if (file.length() > 111149056) {
            final AlertDialog create = new AlertDialog.Builder(this).setCancelable(false).setPositiveButton(getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.vidlargo).create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
            return false;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 3);
        try {
            createVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(this.globales.getTempFile(this, 99)));
        } catch (Exception unused2) {
        }
        try {
            File tempFile = this.globales.getTempFile(this, 99);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(tempFile.getPath(), options);
            int i = options.outWidth;
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 <= 800 && i3 <= 800) {
                z = true;
            }
            if (!z) {
                int round = Math.round(((float) i2) / ((float) config.calculateNewWidth(i2, i3, 800, 800)));
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = round;
                bitmap = BitmapFactory.decodeFile(tempFile.getPath(), options2);
            } else {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(tempFile));
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 75, new FileOutputStream(this.globales.getTempFile(this, 99)));
        } catch (Exception unused3) {
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:96|97|98|(1:102)|103|104|105|106|107|255) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x0291 */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:69:0x01ba] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:88:0x0214] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r28, int r29, android.content.Intent r30) {
        /*
            r27 = this;
            r1 = r27
            r0 = r28
            r2 = r29
            r3 = r30
            stikerwap.appdys.config r4 = r1.globales
            if (r4 == 0) goto L_0x0013
            boolean r4 = r4.onActivityResult_glob(r0, r2, r3, r1)
            if (r4 == 0) goto L_0x0013
            return
        L_0x0013:
            r4 = -1
            if (r2 != r4) goto L_0x06ed
            r2 = 108(0x6c, float:1.51E-43)
            r5 = 100
            java.lang.String r6 = ""
            r7 = 0
            if (r0 != r2) goto L_0x0066
            java.lang.String r0 = "dt_foto98_temp.mp4"
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r0 = r2.getExtTempFile_libre(r1, r0)
            java.lang.String r0 = r0.getAbsolutePath()
            if (r0 == 0) goto L_0x06ed
            boolean r2 = r0.equals(r6)
            if (r2 != 0) goto L_0x06ed
            boolean r2 = r1.pretratar_video(r0)
            if (r2 != 0) goto L_0x003a
            return
        L_0x003a:
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r2 = r2.getTempFile(r1, r5)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x0049
            int r5 = r5 + 1
            goto L_0x003a
        L_0x0049:
            stikerwap.appdys.config r2 = r1.globales
            r3 = 99
            java.io.File r2 = r2.getTempFile(r1, r3)
            stikerwap.appdys.config r3 = r1.globales
            java.io.File r3 = r3.getTempFile(r1, r5)
            r2.renameTo(r3)
            stikerwap.appdys.profile$enviar_video r2 = new stikerwap.appdys.profile$enviar_video
            r2.<init>(r5, r0)
            java.lang.String[] r0 = new java.lang.String[r7]
            r2.execute(r0)
            goto L_0x06ed
        L_0x0066:
            r2 = 4
            r8 = 1
            if (r0 != r2) goto L_0x00db
            android.net.Uri r0 = r30.getData()
            android.content.Context r2 = r27.getApplicationContext()
            java.lang.String r2 = stikerwap.appdys.config.generatePath(r0, r2)
            java.lang.String r3 = "."
            int r3 = r2.lastIndexOf(r3)
            int r3 = r3 + r8
            java.lang.String r2 = r2.substring(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "dt_foto98_temp."
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            boolean r0 = stikerwap.appdys.config.savefile(r1, r0, r2)
            if (r0 != 0) goto L_0x0096
            return
        L_0x0096:
            stikerwap.appdys.config r0 = r1.globales
            java.io.File r0 = r0.getExtTempFile_libre(r1, r2)
            java.lang.String r0 = r0.getAbsolutePath()
            if (r0 == 0) goto L_0x06ed
            boolean r2 = r0.equals(r6)
            if (r2 != 0) goto L_0x06ed
            boolean r2 = r1.pretratar_video(r0)
            if (r2 != 0) goto L_0x00af
            return
        L_0x00af:
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r2 = r2.getTempFile(r1, r5)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00be
            int r5 = r5 + 1
            goto L_0x00af
        L_0x00be:
            stikerwap.appdys.config r2 = r1.globales
            r3 = 99
            java.io.File r2 = r2.getTempFile(r1, r3)
            stikerwap.appdys.config r3 = r1.globales
            java.io.File r3 = r3.getTempFile(r1, r5)
            r2.renameTo(r3)
            stikerwap.appdys.profile$enviar_video r2 = new stikerwap.appdys.profile$enviar_video
            r2.<init>(r5, r0)
            java.lang.String[] r0 = new java.lang.String[r7]
            r2.execute(r0)
            goto L_0x06ed
        L_0x00db:
            r2 = 106(0x6a, float:1.49E-43)
            java.lang.String r9 = "orientation"
            r10 = 600(0x258, float:8.41E-43)
            java.lang.String r13 = "fperfilgal_temp"
            if (r0 != r2) goto L_0x0230
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x014a }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x014a }
            java.io.File r2 = r2.getExtTempFile_libre(r1, r13)     // Catch:{ Exception -> 0x014a }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x014a }
            r0.<init>(r2)     // Catch:{ Exception -> 0x014a }
            long r2 = r0.length()     // Catch:{ Exception -> 0x014a }
            android.content.Context r0 = r27.getApplicationContext()     // Catch:{ Exception -> 0x014a }
            android.content.ContentResolver r14 = r0.getContentResolver()     // Catch:{ Exception -> 0x014a }
            android.net.Uri r15 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x014a }
            java.lang.String r0 = "_size"
            java.lang.String[] r16 = new java.lang.String[]{r9, r0}     // Catch:{ Exception -> 0x014a }
            java.lang.String r17 = "date_added>=?"
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ Exception -> 0x014a }
            long r11 = r1.captureTime     // Catch:{ Exception -> 0x014a }
            r18 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 / r18
            r18 = 1
            long r11 = r11 - r18
            java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x014a }
            r0[r7] = r6     // Catch:{ Exception -> 0x014a }
            java.lang.String r19 = "date_added desc"
            r18 = r0
            android.database.Cursor r0 = r14.query(r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x014a }
            if (r0 == 0) goto L_0x0147
            long r11 = r1.captureTime     // Catch:{ Exception -> 0x014a }
            r14 = 0
            int r6 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0147
            int r6 = r0.getCount()     // Catch:{ Exception -> 0x014a }
            if (r6 == 0) goto L_0x0147
        L_0x0134:
            boolean r6 = r0.moveToNext()     // Catch:{ Exception -> 0x014a }
            if (r6 == 0) goto L_0x0147
            long r11 = r0.getLong(r8)     // Catch:{ Exception -> 0x014a }
            int r6 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0134
            int r0 = r0.getInt(r7)     // Catch:{ Exception -> 0x014a }
            goto L_0x0148
        L_0x0147:
            r0 = -1
        L_0x0148:
            r2 = r0
            goto L_0x014f
        L_0x014a:
            r0 = move-exception
            r0.printStackTrace()
            r2 = -1
        L_0x014f:
            if (r2 != r4) goto L_0x016b
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0167 }
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ IOException -> 0x0167 }
            java.io.File r3 = r3.getExtTempFile_libre(r1, r13)     // Catch:{ IOException -> 0x0167 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0167 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0167 }
            java.lang.String r3 = "Orientation"
            int r2 = r0.getAttributeInt(r3, r4)     // Catch:{ IOException -> 0x0167 }
            goto L_0x016b
        L_0x0167:
            r0 = move-exception
            r0.printStackTrace()
        L_0x016b:
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x01c7 }
            java.io.File r0 = r0.getExtTempFile_libre(r1, r13)     // Catch:{ Exception -> 0x01c7 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x01c7 }
            r3.<init>()     // Catch:{ Exception -> 0x01c7 }
            r3.inJustDecodeBounds = r8     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r6 = r0.getPath()     // Catch:{ Exception -> 0x01c7 }
            android.graphics.BitmapFactory.decodeFile(r6, r3)     // Catch:{ Exception -> 0x01c7 }
            int r6 = r3.outWidth     // Catch:{ Exception -> 0x01c7 }
            int r6 = r3.outWidth     // Catch:{ Exception -> 0x01c7 }
            int r3 = r3.outHeight     // Catch:{ Exception -> 0x01c7 }
            if (r6 > r10) goto L_0x018a
            if (r3 > r10) goto L_0x018a
            goto L_0x018b
        L_0x018a:
            r8 = 0
        L_0x018b:
            if (r8 != 0) goto L_0x01a8
            int r3 = stikerwap.appdys.config.calculateNewWidth(r6, r3, r10, r10)     // Catch:{ Exception -> 0x01c7 }
            float r6 = (float) r6     // Catch:{ Exception -> 0x01c7 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x01c7 }
            float r6 = r6 / r3
            int r3 = java.lang.Math.round(r6)     // Catch:{ Exception -> 0x01c7 }
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x01c7 }
            r6.<init>()     // Catch:{ Exception -> 0x01c7 }
            r6.inSampleSize = r3     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x01c7 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r6)     // Catch:{ Exception -> 0x01c7 }
            goto L_0x01b4
        L_0x01a8:
            android.content.ContentResolver r3 = r27.getContentResolver()     // Catch:{ Exception -> 0x01c7 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception -> 0x01c7 }
            android.graphics.Bitmap r0 = android.provider.MediaStore.Images.Media.getBitmap(r3, r0)     // Catch:{ Exception -> 0x01c7 }
        L_0x01b4:
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception -> 0x01c7 }
            java.io.File r3 = r3.getExtTempFile_libre(r1, r13)     // Catch:{ Exception -> 0x01c7 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ OutOfMemoryError -> 0x01c5, OutOfMemoryError -> 0x01c5 }
            r6.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x01c5, OutOfMemoryError -> 0x01c5 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ OutOfMemoryError -> 0x01c5, OutOfMemoryError -> 0x01c5 }
            r0.compress(r3, r5, r6)     // Catch:{ OutOfMemoryError -> 0x01c5, OutOfMemoryError -> 0x01c5 }
            goto L_0x01cb
        L_0x01c5:
            goto L_0x01cb
        L_0x01c7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01cb:
            if (r2 == r4) goto L_0x0223
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r3 = 3
            if (r2 != r3) goto L_0x01d8
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x01e6
        L_0x01d8:
            r3 = 8
            if (r2 != r3) goto L_0x01df
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x01e6
        L_0x01df:
            r3 = 6
            if (r2 != r3) goto L_0x01e5
            r2 = 90
            goto L_0x01e6
        L_0x01e5:
            r2 = 0
        L_0x01e6:
            if (r2 <= 0) goto L_0x0223
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception -> 0x021f }
            java.io.File r3 = r3.getExtTempFile_libre(r1, r13)     // Catch:{ Exception -> 0x021f }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x021f }
            android.graphics.Bitmap r20 = android.graphics.BitmapFactory.decodeFile(r3)     // Catch:{ Exception -> 0x021f }
            float r2 = (float) r2     // Catch:{ Exception -> 0x021f }
            r0.postRotate(r2)     // Catch:{ Exception -> 0x021f }
            r21 = 0
            r22 = 0
            int r23 = r20.getWidth()     // Catch:{ Exception -> 0x021f }
            int r24 = r20.getHeight()     // Catch:{ Exception -> 0x021f }
            r26 = 1
            r25 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x021f }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x021f }
            java.io.File r2 = r2.getExtTempFile_libre(r1, r13)     // Catch:{ Exception -> 0x021f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ OutOfMemoryError -> 0x0223, OutOfMemoryError -> 0x0223 }
            r3.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x0223, OutOfMemoryError -> 0x0223 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ OutOfMemoryError -> 0x0223, OutOfMemoryError -> 0x0223 }
            r0.compress(r2, r5, r3)     // Catch:{ OutOfMemoryError -> 0x0223, OutOfMemoryError -> 0x0223 }
            goto L_0x0223
        L_0x021f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0223:
            stikerwap.appdys.profile$enviar_foto r0 = new stikerwap.appdys.profile$enviar_foto
            r2 = 0
            r0.<init>()
            java.lang.String[] r2 = new java.lang.String[r7]
            r0.execute(r2)
            goto L_0x06ed
        L_0x0230:
            r2 = 2
            if (r0 != r2) goto L_0x02a1
            android.net.Uri r0 = r30.getData()
            java.lang.String[] r2 = new java.lang.String[]{r9}     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            android.content.ContentResolver r14 = r27.getContentResolver()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r17 = 0
            r18 = 0
            r19 = 0
            r15 = r0
            r16 = r2
            android.database.Cursor r3 = r14.query(r15, r16, r17, r18, r19)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            if (r3 == 0) goto L_0x025e
            boolean r6 = r3.moveToFirst()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            if (r6 == 0) goto L_0x025e
            r2 = r2[r7]     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            int r4 = r3.getInt(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
        L_0x025e:
            android.graphics.Matrix r2 = new android.graphics.Matrix     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            float r3 = (float) r4     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r2.postRotate(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            android.graphics.Bitmap r20 = r3.decodeSampledBitmapFromResource(r0, r10, r10)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r21 = 0
            r22 = 0
            int r23 = r20.getWidth()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            int r24 = r20.getHeight()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r26 = 1
            r25 = r2
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            java.io.File r2 = r2.getExtTempFile_libre(r1, r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception | OutOfMemoryError -> 0x0291 }
            r3.<init>(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0291 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception | OutOfMemoryError -> 0x0291 }
            r0.compress(r2, r5, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0291 }
        L_0x0291:
            r0.recycle()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            stikerwap.appdys.profile$enviar_foto r0 = new stikerwap.appdys.profile$enviar_foto     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r5 = 0
            r0.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            java.lang.String[] r2 = new java.lang.String[r7]     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            r0.execute(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x06ed }
            goto L_0x06ed
        L_0x02a1:
            r5 = 0
            if (r3 == 0) goto L_0x02e2
            java.lang.String r0 = "accion_usu_fav_id"
            boolean r9 = r3.hasExtra(r0)
            if (r9 == 0) goto L_0x02e2
            r2 = 0
        L_0x02ad:
            java.util.ArrayList<stikerwap.appdys.likes_item> r4 = r1.listData
            int r4 = r4.size()
            if (r2 >= r4) goto L_0x06ed
            java.util.ArrayList<stikerwap.appdys.likes_item> r4 = r1.listData
            java.lang.Object r4 = r4.get(r2)
            stikerwap.appdys.likes_item r4 = (stikerwap.appdys.likes_item) r4
            java.lang.String r4 = r4.id
            java.lang.String r5 = r3.getStringExtra(r0)
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02df
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r1.listData
            java.lang.Object r0 = r0.get(r2)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            java.lang.String r2 = "accion_usu_fav_accion"
            boolean r2 = r3.getBooleanExtra(r2, r7)
            r0.fav = r2
            stikerwap.appdys.likes_adapter r0 = r1.itemAdapter
            r0.notifyDataSetChanged()
            return
        L_0x02df:
            int r2 = r2 + 1
            goto L_0x02ad
        L_0x02e2:
            java.lang.String r0 = "idf"
            if (r3 == 0) goto L_0x0371
            java.lang.String r9 = "nlikes"
            boolean r10 = r3.hasExtra(r9)
            if (r10 == 0) goto L_0x0371
            r4 = 0
        L_0x02ef:
            java.util.ArrayList<stikerwap.appdys.profile$Foto> r6 = r1.fotos_glob_a
            int r6 = r6.size()
            if (r4 >= r6) goto L_0x033a
            java.util.ArrayList<stikerwap.appdys.profile$Foto> r6 = r1.fotos_glob_a
            java.lang.Object r6 = r6.get(r4)
            stikerwap.appdys.profile$Foto r6 = (stikerwap.appdys.profile.Foto) r6
            java.lang.String r6 = r6.id
            android.os.Bundle r10 = r30.getExtras()
            java.lang.String r10 = r10.getString(r0)
            boolean r6 = r6.equals(r10)
            if (r6 == 0) goto L_0x0337
            java.util.ArrayList<stikerwap.appdys.profile$Foto> r0 = r1.fotos_glob_a
            java.lang.Object r0 = r0.get(r4)
            stikerwap.appdys.profile$Foto r0 = (stikerwap.appdys.profile.Foto) r0
            android.os.Bundle r6 = r30.getExtras()
            java.lang.String r6 = r6.getString(r9)
            r0.nlikes = r6
            java.util.ArrayList<stikerwap.appdys.profile$Foto> r0 = r1.fotos_glob_a
            java.lang.Object r0 = r0.get(r4)
            stikerwap.appdys.profile$Foto r0 = (stikerwap.appdys.profile.Foto) r0
            android.os.Bundle r6 = r30.getExtras()
            java.lang.String r10 = "liked"
            java.lang.String r6 = r6.getString(r10)
            r0.liked = r6
            r0 = 1
            goto L_0x033b
        L_0x0337:
            int r4 = r4 + 1
            goto L_0x02ef
        L_0x033a:
            r0 = 0
        L_0x033b:
            if (r0 == 0) goto L_0x06ed
            int r0 = r1.ind_global
            int r4 = r4 - r0
            if (r4 != 0) goto L_0x0347
            android.widget.LinearLayout r12 = r1.ll_likes1
            android.widget.TextView r0 = r1.tv_likes1
            goto L_0x035f
        L_0x0347:
            if (r4 != r8) goto L_0x034e
            android.widget.LinearLayout r12 = r1.ll_likes2
            android.widget.TextView r0 = r1.tv_likes2
            goto L_0x035f
        L_0x034e:
            if (r4 != r2) goto L_0x0355
            android.widget.LinearLayout r12 = r1.ll_likes3
            android.widget.TextView r0 = r1.tv_likes3
            goto L_0x035f
        L_0x0355:
            r2 = 3
            if (r4 != r2) goto L_0x035d
            android.widget.LinearLayout r12 = r1.ll_likes4
            android.widget.TextView r0 = r1.tv_likes4
            goto L_0x035f
        L_0x035d:
            r0 = r5
            r12 = r0
        L_0x035f:
            if (r12 == 0) goto L_0x06ed
            android.os.Bundle r2 = r30.getExtras()
            java.lang.String r2 = r2.getString(r9)
            r0.setText(r2)
            r12.setVisibility(r7)
            goto L_0x06ed
        L_0x0371:
            if (r3 == 0) goto L_0x0382
            java.lang.String r9 = "elim_fotoperfil"
            boolean r9 = r3.hasExtra(r9)
            if (r9 == 0) goto L_0x0382
            java.lang.String r0 = r1.idusu_profile
            r1.ban_usu_2(r0)
            goto L_0x06ed
        L_0x0382:
            java.lang.String r9 = "_liked_"
            java.lang.String r10 = "_nlikes_"
            java.lang.String r11 = "_fcrea_"
            java.lang.String r12 = "_"
            if (r3 == 0) goto L_0x04d4
            java.lang.String r13 = "elim_foto"
            boolean r13 = r3.hasExtra(r13)
            if (r13 == 0) goto L_0x04d4
            java.lang.String r2 = "elim_foto"
            java.lang.String r2 = r3.getStringExtra(r2)
            java.lang.String r5 = "indf"
            int r3 = r3.getIntExtra(r5, r4)
            boolean r5 = r2.equals(r6)
            if (r5 != 0) goto L_0x06ed
            if (r3 == r4) goto L_0x06ed
            java.io.File r4 = new java.io.File
            java.io.File r5 = r1.path
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r13 = "fperfilgal_"
            r7.<init>(r13)
            r7.append(r2)
            java.lang.String r13 = ".jpg"
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            r4.<init>(r5, r7)
            boolean r5 = r4.exists()
            if (r5 == 0) goto L_0x03cb
            r4.delete()
        L_0x03cb:
            java.io.File r4 = new java.io.File
            java.io.File r5 = r1.path
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r13 = "fperfilgal_"
            r7.<init>(r13)
            r7.append(r2)
            java.lang.String r2 = "_g.jpg"
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r4.<init>(r5, r2)
            boolean r2 = r4.exists()
            if (r2 == 0) goto L_0x03ee
            r4.delete()
        L_0x03ee:
            java.util.ArrayList<stikerwap.appdys.profile$Foto> r2 = r1.fotos_glob_a
            java.lang.Object r2 = r2.get(r3)
            stikerwap.appdys.profile$Foto r2 = (stikerwap.appdys.profile.Foto) r2
            r2.eliminada = r8
            r1.mostrar_foto(r3, r8)
            android.content.SharedPreferences r2 = r1.settings
            android.content.SharedPreferences$Editor r2 = r2.edit()
        L_0x0401:
            r4 = 3
            if (r3 > r4) goto L_0x04cf
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r3)
            r4.append(r12)
            java.lang.String r5 = r1.idusu_profile
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.content.SharedPreferences r5 = r1.settings
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            int r8 = r3 + 1
            r7.append(r8)
            r7.append(r12)
            java.lang.String r13 = r1.idusu_profile
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            java.lang.String r5 = r5.getString(r7, r6)
            r2.putString(r4, r5)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "f"
            r4.<init>(r5)
            r4.append(r3)
            r4.append(r11)
            java.lang.String r7 = r1.idusu_profile
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            android.content.SharedPreferences r7 = r1.settings
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r8)
            r13.append(r11)
            java.lang.String r14 = r1.idusu_profile
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r7 = r7.getString(r13, r6)
            r2.putString(r4, r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r5)
            r4.append(r3)
            r4.append(r10)
            java.lang.String r7 = r1.idusu_profile
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            android.content.SharedPreferences r7 = r1.settings
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            r13.append(r8)
            r13.append(r10)
            java.lang.String r14 = r1.idusu_profile
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r7 = r7.getString(r13, r6)
            r2.putString(r4, r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r5)
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = r1.idusu_profile
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.content.SharedPreferences r4 = r1.settings
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r5)
            r7.append(r8)
            r7.append(r9)
            java.lang.String r5 = r1.idusu_profile
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.String r4 = r4.getString(r5, r6)
            r2.putString(r3, r4)
            r3 = r8
            goto L_0x0401
        L_0x04cf:
            r2.commit()
            goto L_0x06ed
        L_0x04d4:
            java.lang.String r0 = "idv"
            if (r3 == 0) goto L_0x0563
            java.lang.String r13 = "nlikesv"
            boolean r14 = r3.hasExtra(r13)
            if (r14 == 0) goto L_0x0563
            r4 = 0
        L_0x04e1:
            java.util.ArrayList<stikerwap.appdys.profile$Video> r6 = r1.videos_glob_a
            int r6 = r6.size()
            if (r4 >= r6) goto L_0x052c
            java.util.ArrayList<stikerwap.appdys.profile$Video> r6 = r1.videos_glob_a
            java.lang.Object r6 = r6.get(r4)
            stikerwap.appdys.profile$Video r6 = (stikerwap.appdys.profile.Video) r6
            java.lang.String r6 = r6.id
            android.os.Bundle r9 = r30.getExtras()
            java.lang.String r9 = r9.getString(r0)
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0529
            java.util.ArrayList<stikerwap.appdys.profile$Video> r0 = r1.videos_glob_a
            java.lang.Object r0 = r0.get(r4)
            stikerwap.appdys.profile$Video r0 = (stikerwap.appdys.profile.Video) r0
            android.os.Bundle r6 = r30.getExtras()
            java.lang.String r6 = r6.getString(r13)
            r0.nlikes = r6
            java.util.ArrayList<stikerwap.appdys.profile$Video> r0 = r1.videos_glob_a
            java.lang.Object r0 = r0.get(r4)
            stikerwap.appdys.profile$Video r0 = (stikerwap.appdys.profile.Video) r0
            android.os.Bundle r6 = r30.getExtras()
            java.lang.String r9 = "liked"
            java.lang.String r6 = r6.getString(r9)
            r0.liked = r6
            r0 = 1
            goto L_0x052d
        L_0x0529:
            int r4 = r4 + 1
            goto L_0x04e1
        L_0x052c:
            r0 = 0
        L_0x052d:
            if (r0 == 0) goto L_0x06ed
            int r0 = r1.ind_v_global
            int r4 = r4 - r0
            if (r4 != 0) goto L_0x0539
            android.widget.LinearLayout r12 = r1.ll_v_likes1
            android.widget.TextView r0 = r1.tv_v_likes1
            goto L_0x0551
        L_0x0539:
            if (r4 != r8) goto L_0x0540
            android.widget.LinearLayout r12 = r1.ll_v_likes2
            android.widget.TextView r0 = r1.tv_v_likes2
            goto L_0x0551
        L_0x0540:
            if (r4 != r2) goto L_0x0547
            android.widget.LinearLayout r12 = r1.ll_v_likes3
            android.widget.TextView r0 = r1.tv_v_likes3
            goto L_0x0551
        L_0x0547:
            r2 = 3
            if (r4 != r2) goto L_0x054f
            android.widget.LinearLayout r12 = r1.ll_v_likes4
            android.widget.TextView r0 = r1.tv_v_likes4
            goto L_0x0551
        L_0x054f:
            r0 = r5
            r12 = r0
        L_0x0551:
            if (r12 == 0) goto L_0x06ed
            android.os.Bundle r2 = r30.getExtras()
            java.lang.String r2 = r2.getString(r13)
            r0.setText(r2)
            r12.setVisibility(r7)
            goto L_0x06ed
        L_0x0563:
            if (r3 == 0) goto L_0x06c3
            java.lang.String r2 = "elim_video"
            boolean r2 = r3.hasExtra(r2)
            if (r2 == 0) goto L_0x06c3
            java.lang.String r2 = "elim_video"
            java.lang.String r2 = r3.getStringExtra(r2)
            java.lang.String r5 = "indv"
            int r3 = r3.getIntExtra(r5, r4)
            boolean r5 = r2.equals(r6)
            if (r5 != 0) goto L_0x06ed
            if (r3 == r4) goto L_0x06ed
            java.io.File r4 = new java.io.File
            java.io.File r5 = r1.path
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r13 = "fperfilgalv_"
            r7.<init>(r13)
            r7.append(r2)
            java.lang.String r2 = ".jpg"
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r4.<init>(r5, r2)
            boolean r2 = r4.exists()
            if (r2 == 0) goto L_0x05a4
            r4.delete()
        L_0x05a4:
            java.util.ArrayList<stikerwap.appdys.profile$Video> r2 = r1.videos_glob_a
            java.lang.Object r2 = r2.get(r3)
            stikerwap.appdys.profile$Video r2 = (stikerwap.appdys.profile.Video) r2
            r2.eliminado = r8
            int r2 = r1.nvideos
            int r2 = r2 - r8
            r1.nvideos = r2
            r1.mostrar_video(r3, r8)
            android.content.SharedPreferences r2 = r1.settings
            android.content.SharedPreferences$Editor r2 = r2.edit()
            r4 = 3
        L_0x05bd:
            if (r3 > r4) goto L_0x06bf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            r5.append(r3)
            r5.append(r12)
            java.lang.String r7 = r1.idusu_profile
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            android.content.SharedPreferences r7 = r1.settings
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            int r13 = r3 + 1
            r8.append(r13)
            r8.append(r12)
            java.lang.String r14 = r1.idusu_profile
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            java.lang.String r7 = r7.getString(r8, r6)
            r2.putString(r5, r7)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "v"
            r5.<init>(r7)
            r5.append(r3)
            java.lang.String r8 = "_formato_"
            r5.append(r8)
            java.lang.String r8 = r1.idusu_profile
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.content.SharedPreferences r8 = r1.settings
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r7)
            r14.append(r13)
            java.lang.String r15 = "_formato_"
            r14.append(r15)
            java.lang.String r15 = r1.idusu_profile
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r8 = r8.getString(r14, r6)
            r2.putString(r5, r8)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            r5.append(r3)
            r5.append(r11)
            java.lang.String r8 = r1.idusu_profile
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.content.SharedPreferences r8 = r1.settings
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r7)
            r14.append(r13)
            r14.append(r11)
            java.lang.String r15 = r1.idusu_profile
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r8 = r8.getString(r14, r6)
            r2.putString(r5, r8)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            r5.append(r3)
            r5.append(r10)
            java.lang.String r8 = r1.idusu_profile
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.content.SharedPreferences r8 = r1.settings
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r7)
            r14.append(r13)
            r14.append(r10)
            java.lang.String r15 = r1.idusu_profile
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r8 = r8.getString(r14, r6)
            r2.putString(r5, r8)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            r5.append(r3)
            r5.append(r9)
            java.lang.String r3 = r1.idusu_profile
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.content.SharedPreferences r5 = r1.settings
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r13)
            r8.append(r9)
            java.lang.String r7 = r1.idusu_profile
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r5 = r5.getString(r7, r6)
            r2.putString(r3, r5)
            r3 = r13
            goto L_0x05bd
        L_0x06bf:
            r2.commit()
            goto L_0x06ed
        L_0x06c3:
            if (r3 == 0) goto L_0x06ed
            java.lang.String r0 = "finalizar"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x06ed
            android.os.Bundle r0 = r30.getExtras()
            java.lang.String r2 = "finalizar"
            boolean r0 = r0.getBoolean(r2)
            if (r0 == 0) goto L_0x06ed
            android.os.Bundle r0 = r30.getExtras()
            java.lang.String r2 = "finalizar_app"
            boolean r0 = r0.getBoolean(r2)
            if (r0 != 0) goto L_0x06e7
            r1.es_root = r7
        L_0x06e7:
            r1.setResult(r4, r3)
            r27.finish()
        L_0x06ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: package-private */
    public void incluir_menu_pre() {
        int incluir_menu = this.globales.incluir_menu(this);
        if (this.globales.tipomenu == 1) {
            ListView listView = (ListView) findViewById(R.id.left_drawer);
            this.mDrawerList = listView;
            this.globales.config_drawer(listView);
        } else if (this.globales.tipomenu == 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.globales.secciones_a.length; i2++) {
                if (!this.globales.secciones_a[i2].oculta) {
                    findViewById(i2).setOnClickListener(this);
                    i++;
                    if (i == incluir_menu) {
                        break;
                    }
                }
            }
            if (findViewById(R.id.idaux9999) != null && findViewById(R.id.idaux9999).getVisibility() == 0) {
                findViewById(R.id.idaux9999).setOnClickListener(this);
            }
        }
        for (int i3 = 0; i3 < this.globales.icos_a.length; i3++) {
            if (this.globales.icos_a[i3] > 0) {
                findViewById(this.globales.icos_a[i3]).setOnClickListener(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cambiar_favorito(boolean z) {
        if (!this.idusu_profile.equals(this.idusu + "")) {
            SharedPreferences.Editor edit = this.settings.edit();
            if (z) {
                edit.putBoolean("usufav_" + this.idusu_profile, true);
                if (!this.liked) {
                    this.nlikes_pro++;
                }
                this.liked = true;
                if (this.c1_esclaro) {
                    this.iv_favorito.setImageDrawable(getResources().getDrawable(R.drawable.favorito_activ_n));
                } else {
                    this.iv_favorito.setImageDrawable(getResources().getDrawable(R.drawable.favorito_activ_b));
                }
                if (this.listData.size() > 0) {
                    if (!this.listData.get(0).id.equals(this.idusu + "")) {
                        likes_item likes_item = new likes_item();
                        likes_item.id = this.idusu + "";
                        likes_item.nombre = getResources().getString(R.string.tu);
                        likes_item.t_img = this.globales.getTempFile(this, 1).exists();
                        this.listData.add(0, likes_item);
                        this.itemAdapter.notifyDataSetChanged();
                    }
                }
            } else {
                edit.remove("usufav_" + this.idusu_profile);
                if (this.liked) {
                    this.nlikes_pro--;
                }
                if (this.nlikes_pro < 0) {
                    this.nlikes_pro = 0;
                }
                this.liked = false;
                if (this.c1_esclaro) {
                    this.iv_favorito.setImageDrawable(getResources().getDrawable(R.drawable.favorito_noactiv_n));
                } else {
                    this.iv_favorito.setImageDrawable(getResources().getDrawable(R.drawable.favorito_noactiv_b));
                }
                if (this.listData.size() > 0) {
                    if (this.listData.get(0).id.equals(this.idusu + "")) {
                        this.listData.remove(0);
                        this.itemAdapter.notifyDataSetChanged();
                    }
                }
            }
            edit.commit();
            ((TextView) findViewById(R.id.tv_likes_n)).setText(this.nlikes_pro + "");
            Intent intent = new Intent();
            intent.putExtra("accion_usu_fav_id", this.idusu_profile);
            intent.putExtra("accion_usu_fav_accion", z);
            setResult(-1, intent);
        }
    }

    public void onClick(View view) {
        String str;
        View findViewById;
        View view2 = view;
        if (view.getId() == R.id.fl_trophy) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if (config.isNetworkAvailable(this)) {
                View inflate = getLayoutInflater().inflate(R.layout.webview_progressbar, (ViewGroup) null);
                WebView webView = (WebView) inflate.findViewById(R.id.webview_wp);
                webView.getSettings().setUserAgentString("Android Vinebre Software");
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setPluginState(WebSettings.PluginState.ON);
                webView.getSettings().setUseWideViewPort(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.pb_wp);
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color(progressBar, this.cbtn);
                }
                builder.setNegativeButton(R.string.cerrar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                final AlertDialog create = builder.create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-2);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                webView.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        String str2;
                        if (str.startsWith("http://jugar/") || str.startsWith("https://jugar/")) {
                            try {
                                str2 = Uri.parse(str).getQueryParameter("id");
                            } catch (Exception unused) {
                                str2 = "";
                            }
                            if (!str2.equals("")) {
                                int i = 0;
                                boolean z = false;
                                while (i < profile.this.globales.secciones_a.length && !z) {
                                    Seccion seccion = profile.this.globales.secciones_a[i];
                                    if (seccion.tipo == 1) {
                                        String str3 = seccion.url;
                                        if (str3.contains("games." + config.DOM_EDROID + "") && seccion.idgame.equals(str2)) {
                                            z = true;
                                            i++;
                                        }
                                    }
                                    z = false;
                                    i++;
                                }
                                if (z) {
                                    View view = new View(profile.this);
                                    view.setTag(R.id.TAG_IDSECC, Integer.valueOf(i - 1));
                                    view.setTag(R.id.tag_jugar, true);
                                    create.dismiss();
                                    try {
                                        profile.this.abrir_secc(view);
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        }
                        return true;
                    }

                    public void onPageFinished(WebView webView, String str) {
                        if (str.startsWith(config.PROTOC_GEN + "games-scores." + config.DOM_EDROID + "")) {
                            progressBar.setVisibility(8);
                        }
                    }
                });
                create.setView(inflate);
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-2);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create.show();
                webView.loadUrl(config.PROTOC_GEN + "games-scores." + config.DOM_EDROID + "/srv/game_comparison.php?c1=" + this.c1 + "&c2=" + this.c2 + "&fp=" + this.fotos_perfil + "&idusu=" + this.idusu + "&c=" + this.codigo + "&idusu_2=" + this.idusu_profile);
                return;
            }
            builder.setMessage(getResources().getString(R.string.wv_sinconex));
            builder.setNegativeButton(R.string.cerrar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            final AlertDialog create2 = builder.create();
            if (!this.cbtn.equals("")) {
                create2.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create2.getButton(-2);
                        button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                    }
                });
            }
            create2.show();
        } else if (view.getId() == R.id.iv_ban) {
            ban_usu(this.idusu_profile);
        } else if (view.getId() == R.id.tv_likes_n || view.getId() == R.id.tv_likes_self) {
            if (this.nlikes_pro != 0) {
                this.dialog_likes = new AlertDialog.Builder(this);
                this.convertView = getLayoutInflater().inflate(R.layout.likes_list, (ViewGroup) null);
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color((ProgressBar) this.convertView.findViewById(R.id.likes_pb), this.cbtn);
                }
                this.dialog_likes.setView(this.convertView);
                this.dialog_likes.setCancelable(true);
                ListView listView = (ListView) this.convertView.findViewById(R.id.lv);
                listView.setCacheColorHint(0);
                likes_adapter likes_adapter = new likes_adapter(this, R.layout.likes_item, this.listData, this.idusu);
                this.itemAdapter = likes_adapter;
                listView.setAdapter(likes_adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        likes_item likes_item = (likes_item) profile.this.listData.get(i);
                        if (!likes_item.es_mas) {
                            String str = likes_item.id;
                            if (!str.equals(profile.this.idusu + "")) {
                                String str2 = likes_item.id;
                                if (!str2.equals(profile.this.idusu_profile + "")) {
                                    Intent intent = new Intent(profile.this, profile.class);
                                    intent.putExtra("id", likes_item.id);
                                    intent.putExtra("privados", likes_item.privados);
                                    intent.putExtra("nombre", likes_item.nombre);
                                    intent.putExtra("coments", likes_item.coments);
                                    intent.putExtra("fnac_d", likes_item.fnac_d);
                                    intent.putExtra("fnac_m", likes_item.fnac_m);
                                    intent.putExtra("fnac_a", likes_item.fnac_a);
                                    intent.putExtra("sexo", likes_item.sexo);
                                    intent.putExtra("vfoto", likes_item.vfoto_bd);
                                    if (profile.this.extras.containsKey("desdepriv")) {
                                        intent.putExtra("desdepriv", "1");
                                    }
                                    intent.putExtra("p_fnac", profile.this.extras.getInt("p_fnac"));
                                    intent.putExtra("p_sexo", profile.this.extras.getInt("p_sexo"));
                                    intent.putExtra("p_descr", profile.this.extras.getInt("p_descr"));
                                    intent.putExtra("p_dist", profile.this.extras.getInt("p_dist"));
                                    intent.putExtra("coments_chat", profile.this.extras.getBoolean("coments_chat"));
                                    intent.putExtra("galeria", profile.this.extras.getBoolean("galeria"));
                                    intent.putExtra("privados_chat", profile.this.extras.getBoolean("privados_chat"));
                                    intent.putExtra("fotos_perfil", profile.this.fotos_perfil);
                                    intent.putExtra("fotos_chat", profile.this.extras.getInt("fotos_chat"));
                                    profile.this.startActivityForResult(intent, 0);
                                }
                            }
                        } else if (profile.this.c_l == null || profile.this.c_l.getStatus() != AsyncTask.Status.RUNNING) {
                            profile.this.c_l = new cargar_likes();
                            profile.this.c_l.execute(new String[0]);
                        }
                    }
                });
                this.dialog_likes.show();
                if (this.listData.size() == 0) {
                    cargar_likes cargar_likes2 = this.c_l;
                    if (cargar_likes2 == null || cargar_likes2.getStatus() != AsyncTask.Status.RUNNING) {
                        cargar_likes cargar_likes3 = new cargar_likes();
                        this.c_l = cargar_likes3;
                        cargar_likes3.execute(new String[0]);
                    }
                }
            }
        } else if (view.getId() == R.id.iv_favorito) {
            if (this.settings.contains("usufav_" + this.idusu_profile)) {
                cambiar_favorito(false);
                SharedPreferences.Editor edit = this.settings.edit();
                edit.putBoolean("usufav_noactivar_" + this.idusu_profile, true);
                edit.commit();
                new aplic_favorito(false).execute(new String[0]);
                return;
            }
            cambiar_favorito(true);
            new aplic_favorito(true).execute(new String[0]);
            if (!this.settings.contains("usufav_msgmostrado")) {
                SharedPreferences.Editor edit2 = this.settings.edit();
                edit2.putBoolean("usufav_msgmostrado", true);
                edit2.commit();
                final AlertDialog create3 = new AlertDialog.Builder(this).setCancelable(false).setPositiveButton(R.string.aceptar, (DialogInterface.OnClickListener) null).setMessage(R.string.favorito_activar).create();
                if (!this.cbtn.equals("")) {
                    create3.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create3.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create3.show();
                try {
                    ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            }
        } else if (view.getId() == R.id.iv_privado) {
            Intent intent = new Intent(this, t_chat.class);
            intent.putExtra("empezar_privado", true);
            intent.putExtra("externo", true);
            intent.putExtra("id_remit", this.idusu_profile);
            intent.putExtra("nombre_remit", this.extras.getString("nombre"));
            intent.putExtra("idchat", 0);
            intent.putExtra("idtema", 0);
            intent.putExtra("fotos_perfil", this.extras.getInt("fotos_perfil"));
            intent.putExtra("fotos_chat", this.extras.getInt("fotos_chat"));
            intent.putExtra("fnac", this.extras.getInt("p_fnac"));
            intent.putExtra("sexo", this.extras.getInt("p_sexo"));
            intent.putExtra("descr", this.extras.getInt("p_descr"));
            intent.putExtra("dist", this.extras.getInt("p_dist"));
            intent.putExtra("privados", this.extras.getBoolean("privados_chat"));
            intent.putExtra("coments", this.extras.getBoolean("coments_chat"));
            intent.putExtra("galeria", this.extras.getBoolean("galeria"));
            intent.putExtra("c1", this.globales.secciones_a[this.globales.ind_secc_sel_2].c1);
            intent.putExtra("c2", this.globales.secciones_a[this.globales.ind_secc_sel_2].c2);
            startActivityForResult(intent, 0);
        } else {
            String str2 = "fotos_chat";
            if (view.getId() == R.id.iv_enviarcoment) {
                f_enviar(false);
            } else if (view.getId() == R.id.iv_elimcoment) {
                final View view3 = (View) view.getParent().getParent();
                final String str3 = (String) view3.getTag(R.id.idaux2);
                if (str3 != null) {
                    final AlertDialog create4 = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            view3.setVisibility(8);
                            int indexOfChild = ((LinearLayout) view3.getParent()).indexOfChild(view3);
                            SharedPreferences.Editor edit = profile.this.settings.edit();
                            while (indexOfChild < 4) {
                                SharedPreferences sharedPreferences = profile.this.settings;
                                StringBuilder sb = new StringBuilder("idcom");
                                int i2 = indexOfChild + 1;
                                sb.append(i2);
                                sb.append("_");
                                sb.append(profile.this.idusu_profile);
                                edit.putString("idcom" + indexOfChild + "_" + profile.this.idusu_profile, sharedPreferences.getString(sb.toString(), ""));
                                edit.putString("com" + indexOfChild + "_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_" + profile.this.idusu_profile, ""));
                                edit.putString("com" + indexOfChild + "_fcrea_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fcrea_" + profile.this.idusu_profile, ""));
                                edit.putString("com" + indexOfChild + "_idusucrea_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_idusucrea_" + profile.this.idusu_profile, ""));
                                edit.putString("com" + indexOfChild + "_nombre_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_nombre_" + profile.this.idusu_profile, ""));
                                edit.putString("com" + indexOfChild + "_vfoto_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_vfoto_" + profile.this.idusu_profile, "0"));
                                edit.putString("com" + indexOfChild + "_privados_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_privados_" + profile.this.idusu_profile, "0"));
                                edit.putString("com" + indexOfChild + "_fnacd_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fnacd_" + profile.this.idusu_profile, "0"));
                                edit.putString("com" + indexOfChild + "_fnacm_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fnacm_" + profile.this.idusu_profile, "0"));
                                edit.putString("com" + indexOfChild + "_fnaca_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fnaca_" + profile.this.idusu_profile, "0"));
                                edit.putString("com" + indexOfChild + "_sexo_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_sexo_" + profile.this.idusu_profile, "0"));
                                edit.putString("com" + indexOfChild + "_coments_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_coments_" + profile.this.idusu_profile, "0"));
                                indexOfChild = i2;
                            }
                            edit.commit();
                            new elim_coment(str3).execute(new String[0]);
                        }
                    }).setMessage(R.string.confirmar_elimcoment).create();
                    if (!this.cbtn.equals("")) {
                        create4.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create4.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                                Button button2 = create4.getButton(-2);
                                button2.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                            }
                        });
                    }
                    create4.show();
                    ((TextView) create4.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                }
            } else if (view.getId() == R.id.iv_spamcoment) {
                View view4 = (View) view.getParent().getParent();
                if (view4 != null && (findViewById = view4.findViewById(R.id.iv_usucoment)) != null) {
                    ban_usu((String) findViewById.getTag(R.id.idaux1));
                }
            } else if (view.getId() == R.id.iv_mascoments) {
                new cargar_coments().execute(new String[0]);
            } else if (view.getId() == R.id.iv_masfotos) {
                this.ind_global += 4;
                new cargar_fotos().execute(new String[0]);
            } else if (view.getId() == R.id.iv_menosfotos) {
                this.ind_global -= 4;
                new cargar_fotos().execute(new String[0]);
            } else if (view.getId() == R.id.iv_masvideos) {
                this.ind_v_global += 4;
                new cargar_videos().execute(new String[0]);
            } else if (view.getId() == R.id.iv_menosvideos) {
                this.ind_v_global -= 4;
                new cargar_videos().execute(new String[0]);
            } else if (view.getId() == R.id.iv_f1_v || view.getId() == R.id.iv_f2_v || view.getId() == R.id.iv_f3_v || view.getId() == R.id.iv_f4_v) {
                View view5 = view;
                String str4 = str2;
                String str5 = (String) view5.getTag(R.id.idaux1);
                int parseInt = Integer.parseInt((String) view5.getTag(R.id.idaux3));
                if (str5 != null && !this.videos_glob_a.get(parseInt).eliminado) {
                    Video video = this.videos_glob_a.get(parseInt);
                    Intent intent2 = new Intent(this, t_video_pro.class);
                    if (video.formato.equals("1")) {
                        str = "mp4";
                    } else if (video.formato.equals("2")) {
                        str = "3gp";
                    } else if (video.formato.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        str = "webm";
                    } else {
                        return;
                    }
                    intent2.putExtra("url", "https://video." + config.DOM_EDROID + "/files_pro/v" + video.id + "_" + this.idusu_profile + "." + str);
                    intent2.putExtra("ind", this.globales.ind_secc_sel_2);
                    intent2.putExtra("nlikes", this.videos_glob_a.get(parseInt).nlikes);
                    intent2.putExtra("liked", this.videos_glob_a.get(parseInt).liked);
                    intent2.putExtra("idv", video.id);
                    intent2.putExtra("indv", parseInt);
                    intent2.putExtra("idusu_profile", this.idusu_profile);
                    intent2.putExtra("coments", this.extras.getString("coments"));
                    intent2.putExtra("p_fnac", this.extras.getInt("p_fnac"));
                    intent2.putExtra("p_sexo", this.extras.getInt("p_sexo"));
                    intent2.putExtra("p_descr", this.extras.getInt("p_descr"));
                    intent2.putExtra("p_dist", this.extras.getInt("p_dist"));
                    intent2.putExtra("coments_chat", this.extras.getBoolean("coments_chat"));
                    intent2.putExtra("galeria", this.extras.getBoolean("galeria"));
                    intent2.putExtra("privados_chat", this.extras.getBoolean("privados_chat"));
                    intent2.putExtra("fotos_perfil", this.fotos_perfil);
                    String str6 = str4;
                    intent2.putExtra(str6, this.extras.getInt(str6));
                    startActivityForResult(intent2, 0);
                }
            } else if (view.getId() == R.id.iv_f1 || view.getId() == R.id.iv_f2 || view.getId() == R.id.iv_f3 || view.getId() == R.id.iv_f4) {
                View view6 = view;
                String str7 = str2;
                String str8 = (String) view6.getTag(R.id.idaux1);
                int parseInt2 = Integer.parseInt((String) view6.getTag(R.id.idaux3));
                if (str8 != null && !this.fotos_glob_a.get(parseInt2).eliminada) {
                    File tempFile_libre = this.globales.getTempFile_libre(this, "fperfilgal_" + str8 + "_g.jpg");
                    if (tempFile_libre.exists()) {
                        Intent intent3 = new Intent(this, fotogal.class);
                        intent3.putExtra("url", AdPayload.FILE_SCHEME + tempFile_libre.getAbsolutePath());
                        intent3.putExtra("nlikes", this.fotos_glob_a.get(parseInt2).nlikes);
                        intent3.putExtra("liked", this.fotos_glob_a.get(parseInt2).liked);
                        intent3.putExtra("fcrea", this.fotos_glob_a.get(parseInt2).fcrea);
                        intent3.putExtra("idf", str8);
                        intent3.putExtra("indf", parseInt2);
                        intent3.putExtra("idusu_profile", this.idusu_profile);
                        intent3.putExtra("p_fnac", this.extras.getInt("p_fnac"));
                        intent3.putExtra("p_sexo", this.extras.getInt("p_sexo"));
                        intent3.putExtra("p_descr", this.extras.getInt("p_descr"));
                        intent3.putExtra("p_dist", this.extras.getInt("p_dist"));
                        intent3.putExtra("coments_chat", this.extras.getBoolean("coments_chat"));
                        intent3.putExtra("galeria", this.extras.getBoolean("galeria"));
                        intent3.putExtra("privados_chat", this.extras.getBoolean("privados_chat"));
                        intent3.putExtra("fotos_perfil", this.fotos_perfil);
                        intent3.putExtra(str7, this.extras.getInt(str7));
                        startActivityForResult(intent3, 0);
                        return;
                    }
                    obtener_img_g obtener_img_g2 = this.o_i_g;
                    if (obtener_img_g2 == null || obtener_img_g2.getStatus() != AsyncTask.Status.RUNNING) {
                        obtener_img_g obtener_img_g3 = new obtener_img_g(str8, parseInt2);
                        this.o_i_g = obtener_img_g3;
                        obtener_img_g3.execute(new String[0]);
                    }
                }
            } else if (view.getId() == R.id.btnfotos) {
                final AlertDialog create5 = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.tomardecamara), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!profile.this.globales.tener_que_pedir_p_camara(profile.this, 107)) {
                            profile.this.captureTime = System.currentTimeMillis();
                            config config = profile.this.globales;
                            profile profile = profile.this;
                            config.iniciar_tomardecamara(profile, profile.globales.getExtTempFile_libre(profile.this, "fperfilgal_temp"));
                        }
                    }
                }).setNegativeButton(getString(R.string.tomardesd), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent("android.intent.action.PICK");
                        intent.setType("image/*");
                        profile.this.startActivityForResult(intent, 2);
                    }
                }).setMessage(R.string.tomarfoto).create();
                if (!this.cbtn.equals("")) {
                    create5.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create5.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                            Button button2 = create5.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create5.show();
                ((TextView) create5.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (view.getId() != R.id.btnvideos) {
                View view7 = view;
                String str9 = str2;
                if (view7.getTag(R.id.idaux1) != null && view7.getTag(R.id.idaux1).equals("ESCOMENT")) {
                    Intent intent4 = new Intent(this, profile.class);
                    intent4.putExtra("id", (String) view7.getTag(R.id.idaux2));
                    intent4.putExtra("privados", (String) view7.getTag(R.id.idaux5));
                    intent4.putExtra("nombre", (String) view7.getTag(R.id.idaux3));
                    intent4.putExtra("coments", (String) view7.getTag(R.id.idaux10));
                    intent4.putExtra("fnac_d", (String) view7.getTag(R.id.idaux6));
                    intent4.putExtra("fnac_m", (String) view7.getTag(R.id.idaux7));
                    intent4.putExtra("fnac_a", (String) view7.getTag(R.id.idaux8));
                    intent4.putExtra("sexo", (String) view7.getTag(R.id.idaux9));
                    intent4.putExtra("vfoto", (String) view7.getTag(R.id.idaux4));
                    if (this.extras.containsKey("desdepriv")) {
                        intent4.putExtra("desdepriv", "1");
                    }
                    intent4.putExtra("p_fnac", this.extras.getInt("p_fnac"));
                    intent4.putExtra("p_sexo", this.extras.getInt("p_sexo"));
                    intent4.putExtra("p_descr", this.extras.getInt("p_descr"));
                    intent4.putExtra("p_dist", this.extras.getInt("p_dist"));
                    intent4.putExtra("coments_chat", this.extras.getBoolean("coments_chat"));
                    intent4.putExtra("galeria", this.extras.getBoolean("galeria"));
                    intent4.putExtra("privados_chat", this.extras.getBoolean("privados_chat"));
                    intent4.putExtra("fotos_perfil", this.fotos_perfil);
                    String str10 = str9;
                    intent4.putExtra(str10, this.extras.getInt(str10));
                    startActivityForResult(intent4, 0);
                } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
                    View view8 = view7;
                    abrir_secc(view);
                } else {
                    if (this.globales.appnext_rew_cod != null && !this.globales.appnext_rew_cod.equals("")) {
                        this.mAd_appnext = new RewardedVideo((Context) this, this.globales.appnext_rew_cod);
                    }
                    if (this.globales.admob_rew_cod != null) {
                        this.globales.admob_rew_cod.equals("");
                    }
                    if (this.globales.fb_rew_cod != null && !this.globales.fb_rew_cod.equals("")) {
                        this.mAd_fb = new RewardedVideoAd(this, this.globales.fb_rew_cod);
                    }
                    if (this.globales.st_rew_cod != null && !this.globales.st_rew_cod.equals("")) {
                        this.mAd_st = new StartAppAd(this);
                    }
                    this.dialog_cargando = new ProgressDialog(this);
                    this.v_abrir_secc = view7;
                    View view9 = view7;
                    if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                        abrir_secc(view);
                    }
                }
            } else if (this.nvideos >= this.globales.max_videos_pro) {
                final AlertDialog create6 = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.demasiados_videos).create();
                if (!this.cbtn.equals("")) {
                    create6.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create6.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                            Button button2 = create6.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create6.show();
                ((TextView) create6.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                final AlertDialog create7 = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.tomardecamara), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!profile.this.globales.tener_que_pedir_p_camara(profile.this, 109)) {
                            config config = profile.this.globales;
                            profile profile = profile.this;
                            config.iniciar_tomardecamara_v(profile, profile.globales.getExtTempFile_libre(profile.this, "dt_foto98_temp.mp4"));
                        }
                    }
                }).setNegativeButton(getString(R.string.selvideo), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent("android.intent.action.PICK");
                        intent.setType("video/*");
                        profile.this.startActivityForResult(intent, 4);
                    }
                }).setMessage(R.string.enviarvideo).create();
                if (!this.cbtn.equals("")) {
                    create7.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create7.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                            Button button2 = create7.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create7.show();
                ((TextView) create7.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ban_usu(final String str) {
        if (str != null) {
            final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    profile.this.ban_usu_2(str);
                }
            }).setMessage(R.string.confirmar_elimusu).create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        Button button2 = create.getButton(-2);
                        if (button2 != null) {
                            button2.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ban_usu_2(String str) {
        config.mostrar_toast(Toast.makeText(this, getResources().getString(R.string.enviando), 0));
        config.elim_privado(this, str);
        new t_chat.eliminar_usu(str, this.idusu, this.codigo, this).execute(new String[0]);
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putBoolean("ban_" + str, true);
        edit.commit();
        Intent intent = new Intent();
        intent.putExtra("idusu_ban", str);
        setResult(-1, intent);
        if (str.equals(this.idusu_profile)) {
            finish();
            return;
        }
        for (int i = 0; i < this.ll_coments.getChildCount(); i++) {
            LinearLayout linearLayout = (LinearLayout) this.ll_coments.getChildAt(i);
            String str2 = (String) linearLayout.findViewById(R.id.iv_usucoment).getTag(R.id.idaux1);
            if (str2 != null && str2.equals(str)) {
                linearLayout.setVisibility(8);
                SharedPreferences.Editor edit2 = this.settings.edit();
                int i2 = i;
                while (i2 < 4) {
                    SharedPreferences sharedPreferences = this.settings;
                    StringBuilder sb = new StringBuilder("idcom");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append("_");
                    sb.append(this.idusu_profile);
                    edit2.putString("idcom" + i2 + "_" + this.idusu_profile, sharedPreferences.getString(sb.toString(), ""));
                    edit2.putString("com" + i2 + "_" + this.idusu_profile, this.settings.getString("com" + i3 + "_" + this.idusu_profile, ""));
                    edit2.putString("com" + i2 + "_fcrea_" + this.idusu_profile, this.settings.getString("com" + i3 + "_fcrea_" + this.idusu_profile, ""));
                    edit2.putString("com" + i2 + "_idusucrea_" + this.idusu_profile, this.settings.getString("com" + i3 + "_idusucrea_" + this.idusu_profile, ""));
                    edit2.putString("com" + i2 + "_nombre_" + this.idusu_profile, this.settings.getString("com" + i3 + "_nombre_" + this.idusu_profile, ""));
                    edit2.putString("com" + i2 + "_vfoto_" + this.idusu_profile, this.settings.getString("com" + i3 + "_vfoto_" + this.idusu_profile, "0"));
                    edit2.putString("com" + i2 + "_privados_" + this.idusu_profile, this.settings.getString("com" + i3 + "_privados_" + this.idusu_profile, "0"));
                    edit2.putString("com" + i2 + "_fnacd_" + this.idusu_profile, this.settings.getString("com" + i3 + "_fnacd_" + this.idusu_profile, "0"));
                    edit2.putString("com" + i2 + "_fnacm_" + this.idusu_profile, this.settings.getString("com" + i3 + "_fnacm_" + this.idusu_profile, "0"));
                    edit2.putString("com" + i2 + "_fnaca_" + this.idusu_profile, this.settings.getString("com" + i3 + "_fnaca_" + this.idusu_profile, "0"));
                    edit2.putString("com" + i2 + "_sexo_" + this.idusu_profile, this.settings.getString("com" + i3 + "_sexo_" + this.idusu_profile, "0"));
                    edit2.putString("com" + i2 + "_coments_" + this.idusu_profile, this.settings.getString("com" + i3 + "_coments_" + this.idusu_profile, "0"));
                    i2 = i3;
                }
                edit2.commit();
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 107 && i != 109) {
            return;
        }
        if (iArr == null || iArr.length <= 0 || !strArr[0].equals("android.permission.CAMERA") || iArr[0] != 0) {
            config.mostrar_error(this, "", getResources().getString(R.string.permisos), this.cbtn);
        } else if (i == 107) {
            this.captureTime = System.currentTimeMillis();
            config config = this.globales;
            config.iniciar_tomardecamara(this, config.getExtTempFile_libre(this, "fperfilgal_temp"));
        } else {
            config config2 = this.globales;
            config2.iniciar_tomardecamara_v(this, config2.getExtTempFile_libre(this, "dt_foto98_temp.mp4"));
        }
    }

    public void abrir_secc(View view) {
        ResultGetIntent intent = this.globales.getIntent(view, this);
        if (intent != null) {
            try {
                String str = this.idusu_profile;
                if (str.equals(this.idusu + "") && intent.i != null && intent.i.getComponent().getClassName().endsWith(".preperfil")) {
                    return;
                }
            } catch (Exception unused) {
            }
            if (view.getTag(R.id.tag_jugar) != null) {
                Bundle bundle = this.extras;
                if (bundle == null || !bundle.containsKey("desde_game_2")) {
                    intent.finalizar = false;
                } else {
                    intent.finalizar = true;
                }
                if (intent.i != null) {
                    intent.i.putExtra("game_idusu_ref", this.idusu_profile);
                }
            }
            if (intent.finalizar) {
                this.finalizar = true;
                Intent intent2 = new Intent();
                intent2.putExtra("finalizar", true);
                intent2.putExtra("finalizar_app", intent.finalizar_app);
                setResult(-1, intent2);
            }
            if (intent.esmas) {
                startActivityForResult(intent.i, 0);
            } else if (intent.i != null) {
                if (intent.finalizar && this.globales.tipomenu != 2) {
                    intent.i.putExtra("es_root", true);
                }
                if (this.finalizar) {
                    this.es_root = false;
                }
                startActivityForResult(intent.i, 0);
            }
            if (this.finalizar && !this.buscador_on) {
                finish();
            }
        }
    }

    public void mostrar_subtit() {
        String str;
        String str2;
        if (this.edat != -1) {
            str = this.edat + getResources().getString(R.string.anyos_abrev);
        } else {
            str = "";
        }
        if (this.dist != null) {
            String country = Locale.getDefault().getCountry();
            long parseLong = Long.parseLong(this.dist);
            if (country.equals("US") || country.equals("GB") || country.equals("MM")) {
                if (parseLong > 1600) {
                    parseLong = (long) Math.round((float) (parseLong / 1600));
                    str2 = "mi.";
                } else {
                    double d = (double) parseLong;
                    Double.isNaN(d);
                    parseLong = Math.round(d * 1.09d);
                    str2 = "yd.";
                }
            } else if (parseLong > 999) {
                parseLong = (long) Math.round((float) (parseLong / 1000));
                str2 = "km.";
            } else {
                str2 = "m.";
            }
            if (!str.isEmpty()) {
                str = str + ", ";
            }
            str = str + parseLong + str2;
        }
        if (!str.isEmpty()) {
            ((TextView) findViewById(R.id.tv_subtit)).setText(str);
            ((TextView) findViewById(R.id.tv_subtit)).setVisibility(0);
            return;
        }
        ((TextView) findViewById(R.id.tv_subtit)).setVisibility(8);
    }

    public void mostrar_viewsaux() {
        if (((TextView) findViewById(R.id.tv_subtit)).getVisibility() == 8) {
            findViewById(R.id.v_aux1).setVisibility(0);
        } else {
            findViewById(R.id.v_aux1).setVisibility(8);
        }
        if (((TextView) findViewById(R.id.descr)).getVisibility() == 8) {
            findViewById(R.id.v_aux2).setVisibility(0);
        } else {
            findViewById(R.id.v_aux2).setVisibility(8);
        }
    }

    private void f_enviar(boolean z) {
        String trim = ((TextView) findViewById(R.id.et_coment_self)).getText().toString().replace("@", "").trim();
        if (!trim.equals("")) {
            if (z && this.altura < 600) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
            }
            ((TextView) findViewById(R.id.et_coment_self)).setTextColor(-7829368);
            this.pb_enviando.setVisibility(0);
            enviar_coment enviar_coment2 = this.env;
            if (enviar_coment2 == null || enviar_coment2.getStatus() != AsyncTask.Status.RUNNING) {
                SharedPreferences sharedPreferences = this.settings;
                if (!sharedPreferences.contains("usufav_" + this.idusu_profile)) {
                    SharedPreferences sharedPreferences2 = this.settings;
                    if (!sharedPreferences2.contains("usufav_noactivar_" + this.idusu_profile)) {
                        cambiar_favorito(true);
                    }
                }
                enviar_coment enviar_coment3 = new enviar_coment(trim);
                this.env = enviar_coment3;
                enviar_coment3.execute(new String[0]);
            }
        }
    }

    private class obtener_img_g extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idimg_acargar;
        int ind;

        public obtener_img_g(String str, int i) {
            this.idimg_acargar = str;
            this.ind = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            int i;
            int i2;
            int i3 = this.ind % 4;
            if (i3 == 0) {
                i2 = R.id.pb_1;
                i = R.id.pb_1_inv;
            } else if (i3 == 1) {
                i2 = R.id.pb_2;
                i = R.id.pb_2_inv;
            } else if (i3 == 2) {
                i2 = R.id.pb_3;
                i = R.id.pb_3_inv;
            } else if (i3 == 3) {
                i2 = R.id.pb_4;
                i = R.id.pb_4_inv;
            } else {
                return;
            }
            if (profile.this.c1_esclaro) {
                profile.this.findViewById(i).setVisibility(0);
            } else {
                profile.this.findViewById(i2).setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.lang.String r0 = "fperfilgal_"
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/ususgal/"
                r2.append(r3)     // Catch:{  }
                stikerwap.appdys.profile r3 = stikerwap.appdys.profile.this     // Catch:{  }
                java.lang.String r3 = r3.idusu_profile     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idimg_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = ".jpg"
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{  }
                r2 = 60000(0xea60, float:8.4078E-41)
                r1.setReadTimeout(r2)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ MalformedURLException -> 0x0087 }
                r4.bmImg = r3     // Catch:{ MalformedURLException -> 0x0087 }
                r2.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{  }
                stikerwap.appdys.config r1 = r1.globales     // Catch:{  }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r4.idimg_acargar     // Catch:{  }
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = "_g.jpg"
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = r3.toString()     // Catch:{  }
                java.io.File r0 = r1.getTempFile_libre(r2, r0)     // Catch:{  }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{  }
                r1.<init>(r0)     // Catch:{  }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{  }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r3 = 100
                r0.compress(r2, r3, r1)     // Catch:{  }
                java.lang.String r5 = "1"
            L_0x0087:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.obtener_img_g.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            try {
                profile.this.findViewById(R.id.pb_1).setVisibility(8);
                profile.this.findViewById(R.id.pb_1_inv).setVisibility(8);
                profile.this.findViewById(R.id.pb_2).setVisibility(8);
                profile.this.findViewById(R.id.pb_2_inv).setVisibility(8);
                profile.this.findViewById(R.id.pb_3).setVisibility(8);
                profile.this.findViewById(R.id.pb_3_inv).setVisibility(8);
                profile.this.findViewById(R.id.pb_4).setVisibility(8);
                profile.this.findViewById(R.id.pb_4_inv).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str.equals("1")) {
                Intent intent = new Intent(profile.this, fotogal.class);
                StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
                config config = profile.this.globales;
                profile profile = profile.this;
                sb.append(config.getTempFile_libre(profile, "fperfilgal_" + this.idimg_acargar + "_g.jpg").getAbsolutePath());
                intent.putExtra("url", sb.toString());
                intent.putExtra("nlikes", profile.this.fotos_glob_a.get(this.ind).nlikes);
                intent.putExtra("liked", profile.this.fotos_glob_a.get(this.ind).liked);
                intent.putExtra("fcrea", profile.this.fotos_glob_a.get(this.ind).fcrea);
                intent.putExtra("idf", this.idimg_acargar);
                intent.putExtra("indf", this.ind);
                intent.putExtra("idusu_profile", profile.this.idusu_profile);
                intent.putExtra("p_fnac", profile.this.extras.getInt("p_fnac"));
                intent.putExtra("p_sexo", profile.this.extras.getInt("p_sexo"));
                intent.putExtra("p_descr", profile.this.extras.getInt("p_descr"));
                intent.putExtra("p_dist", profile.this.extras.getInt("p_dist"));
                intent.putExtra("coments_chat", profile.this.extras.getBoolean("coments_chat"));
                intent.putExtra("galeria", profile.this.extras.getBoolean("galeria"));
                intent.putExtra("privados_chat", profile.this.extras.getBoolean("privados_chat"));
                intent.putExtra("fotos_perfil", profile.this.fotos_perfil);
                intent.putExtra("fotos_chat", profile.this.extras.getInt("fotos_chat"));
                profile.this.startActivityForResult(intent, 0);
            }
        }
    }

    private class obtener_foto extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idusu_acargar;

        private obtener_foto() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.idusu_acargar = profile.this.idusu_profile;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "fperfil_"
                java.lang.String r0 = r4.idusu_acargar
                java.lang.String r1 = "0"
                if (r0 != 0) goto L_0x0009
                return r1
            L_0x0009:
                java.net.URL r0 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/usus/"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idusu_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_1.jpg?v="
                r2.append(r3)     // Catch:{  }
                stikerwap.appdys.profile r3 = stikerwap.appdys.profile.this     // Catch:{  }
                java.lang.String r3 = r3.vfoto     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r0.<init>(r2)     // Catch:{  }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r2 = 1
                r0.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r0.setReadTimeout(r2)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r2 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ MalformedURLException -> 0x0086 }
                r4.bmImg = r3     // Catch:{ MalformedURLException -> 0x0086 }
                r2.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                java.io.File r0 = new java.io.File     // Catch:{  }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r5)     // Catch:{  }
                java.lang.String r5 = r4.idusu_acargar     // Catch:{  }
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = "_g.jpg"
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = r3.toString()     // Catch:{  }
                r0.<init>(r2, r5)     // Catch:{  }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{  }
                r5.<init>(r0)     // Catch:{  }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{  }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r3 = 100
                r0.compress(r2, r3, r5)     // Catch:{  }
                java.lang.String r5 = "1"
                return r5
            L_0x0086:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.obtener_foto.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.equals("1")) {
                SharedPreferences.Editor edit = profile.this.settings.edit();
                edit.putString("fperfil_" + this.idusu_acargar + "_g", profile.this.vfoto);
                edit.commit();
            }
            profile.this.findViewById(R.id.pb_foto).setVisibility(8);
            profile.this.findViewById(R.id.pb_foto_inv).setVisibility(8);
            if (str.equals("1")) {
                profile.this.iv.setImageBitmap(this.bmImg);
                profile.this.iv.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(profile.this, fotoperfil.class);
                        File file = profile.this.path;
                        File file2 = new File(file, "fperfil_" + profile.this.idusu_profile + "_g.jpg");
                        StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
                        sb.append(file2.getAbsolutePath());
                        intent.putExtra("url", sb.toString());
                        intent.putExtra("idusu_profile", profile.this.idusu_profile);
                        profile.this.startActivityForResult(intent, 0);
                    }
                });
            }
        }
    }

    private class enviar_coment extends AsyncTask<String, Void, String> {
        String coment;

        public enviar_coment(String str) {
            this.coment = str;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/enviar_coment.php?idusu=" + profile.this.idusu + "&c=" + profile.this.codigo + "&idusu_pro=" + profile.this.idusu_profile);
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("m", new StringBody(URLEncoder.encode(this.coment, "UTF-8")));
                httpPost.setEntity(multipartEntity);
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return sb.toString();
                    }
                    sb.append(readLine);
                }
            } catch (Exception unused) {
                return "ANDROID:KO";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2 = str;
            AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
            try {
                profile.this.pb_enviando.setVisibility(8);
                if (!profile.this.c1_esclaro) {
                    ((TextView) profile.this.findViewById(R.id.et_coment_self)).setTextColor(-1);
                } else {
                    ((TextView) profile.this.findViewById(R.id.et_coment_self)).setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
            } catch (Exception unused) {
            }
            if (str2.indexOf("ANDROID:OK ID:") != -1) {
                int indexOf = str2.indexOf("ANDROID:OK ID:") + 14;
                String substring = str2.substring(indexOf, str2.indexOf("-", indexOf));
                ((EditText) profile.this.findViewById(R.id.et_coment_self)).setText("");
                String convertir_fecha_inv = config.convertir_fecha_inv(new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
                profile.this.mostrar_coment(false, true, substring, profile.this.idusu + "", profile.this.getResources().getString(R.string.tu), convertir_fecha_inv, this.coment, "0", "", "", "", "", "", "");
                SharedPreferences.Editor edit = profile.this.settings.edit();
                for (int i = 3; i > 0; i += -1) {
                    SharedPreferences sharedPreferences = profile.this.settings;
                    StringBuilder sb = new StringBuilder("idcom");
                    int i2 = i - 1;
                    sb.append(i2);
                    sb.append("_");
                    sb.append(profile.this.idusu_profile);
                    edit.putString("idcom" + i + "_" + profile.this.idusu_profile, sharedPreferences.getString(sb.toString(), ""));
                    edit.putString("com" + i + "_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_" + profile.this.idusu_profile, ""));
                    edit.putString("com" + i + "_fcrea_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fcrea_" + profile.this.idusu_profile, ""));
                    edit.putString("com" + i + "_idusucrea_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_idusucrea_" + profile.this.idusu_profile, ""));
                    edit.putString("com" + i + "_nombre_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_nombre_" + profile.this.idusu_profile, ""));
                    edit.putString("com" + i + "_vfoto_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_vfoto_" + profile.this.idusu_profile, "0"));
                    edit.putString("com" + i + "_privados_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_privados_" + profile.this.idusu_profile, "0"));
                    edit.putString("com" + i + "_fnacd_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fnacd_" + profile.this.idusu_profile, "0"));
                    edit.putString("com" + i + "_fnacm_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fnacm_" + profile.this.idusu_profile, "0"));
                    edit.putString("com" + i + "_fnaca_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_fnaca_" + profile.this.idusu_profile, "0"));
                    edit.putString("com" + i + "_sexo_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_sexo_" + profile.this.idusu_profile, "0"));
                    edit.putString("com" + i + "_coments_" + profile.this.idusu_profile, profile.this.settings.getString("com" + i2 + "_coments_" + profile.this.idusu_profile, "0"));
                }
                edit.putString("idcom0_" + profile.this.idusu_profile, substring);
                edit.putString("com0_" + profile.this.idusu_profile, this.coment);
                edit.putString("com0_fcrea_" + profile.this.idusu_profile, convertir_fecha_inv);
                edit.putString("com0_idusucrea_" + profile.this.idusu_profile, profile.this.idusu + "");
                StringBuilder sb2 = new StringBuilder("com0_nombre_");
                sb2.append(profile.this.idusu_profile);
                edit.putString(sb2.toString(), profile.this.getResources().getString(R.string.tu));
                edit.putString("com0_vfoto_" + profile.this.idusu_profile, "0");
                edit.commit();
                try {
                    profile.this.findViewById(R.id.sc_pro).post(new Runnable() {
                        public void run() {
                            try {
                                ((ScrollView) profile.this.findViewById(R.id.sc_pro)).smoothScrollTo(0, profile.this.findViewById(R.id.tv_coments).getTop());
                            } catch (Exception unused) {
                            }
                        }
                    });
                } catch (Exception unused2) {
                }
            } else if (str2.indexOf("ANDROID:KO MOTIVO:NOADMITE") != -1) {
                final AlertDialog create = builder.setCancelable(false).setPositiveButton(profile.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.noadmitecoments).create();
                if (!profile.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create.show();
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                final AlertDialog create2 = builder.setCancelable(false).setPositiveButton(profile.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
                if (!profile.this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                try {
                    create2.show();
                } catch (Exception unused3) {
                }
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    private class cargarprofile extends AsyncTask<String, Void, String> {
        String condist;

        private cargarprofile() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.condist = "0";
            if (profile.this.extras.getInt("p_dist") > 0 && !profile.this.extras.containsKey("dist")) {
                this.condist = "1";
            }
            if (profile.this.c1_esclaro) {
                profile.this.findViewById(R.id.pb_masfotos_inv).setVisibility(0);
                profile.this.findViewById(R.id.pb_masvideos_inv).setVisibility(0);
                profile.this.findViewById(R.id.pb_mascoments_inv).setVisibility(0);
                return;
            }
            profile.this.findViewById(R.id.pb_masfotos).setVisibility(0);
            profile.this.findViewById(R.id.pb_masvideos).setVisibility(0);
            profile.this.findViewById(R.id.pb_mascoments).setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0169  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x016f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                java.lang.String r7 = "vdescr_"
                stikerwap.appdys.profile r0 = stikerwap.appdys.profile.this
                android.content.SharedPreferences r0 = r0.settings
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "idcom0_"
                r1.<init>(r2)
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this
                java.lang.String r2 = r2.idusu_profile
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = ""
                java.lang.String r0 = r0.getString(r1, r2)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = ","
                r1.append(r0)
                stikerwap.appdys.profile r3 = stikerwap.appdys.profile.this
                android.content.SharedPreferences r3 = r3.settings
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "idcom1_"
                r4.<init>(r5)
                stikerwap.appdys.profile r5 = stikerwap.appdys.profile.this
                java.lang.String r5 = r5.idusu_profile
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                java.lang.String r3 = r3.getString(r4, r2)
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                r3.append(r0)
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "idcom2_"
                r4.<init>(r5)
                stikerwap.appdys.profile r5 = stikerwap.appdys.profile.this
                java.lang.String r5 = r5.idusu_profile
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                java.lang.String r1 = r1.getString(r4, r2)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                r3.append(r0)
                stikerwap.appdys.profile r0 = stikerwap.appdys.profile.this
                android.content.SharedPreferences r0 = r0.settings
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r4 = "idcom3_"
                r1.<init>(r4)
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this
                java.lang.String r4 = r4.idusu_profile
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                java.lang.String r0 = r0.getString(r1, r2)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r1 = 0
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.<init>()     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = "/srv/obtener_profile.php?idusu="
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                long r4 = r4.idusu     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = "&c="
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = r4.codigo     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = "&idusu_pro="
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = r4.idusu_profile     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r4 = "&vdescr="
                r3.append(r4)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                android.content.SharedPreferences r4 = r4.settings     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r5.<init>(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                stikerwap.appdys.profile r7 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r7 = r7.idusu_profile     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r5.append(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r7 = r5.toString()     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r5 = "0"
                java.lang.String r7 = r4.getString(r7, r5)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r7 = "&idcoments="
                r3.append(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r0)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r7 = "&condist="
                r3.append(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r7 = r6.condist     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r3.append(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r0.<init>(r7)     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.net.URLConnection r7 = r0.openConnection()     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x016d, all -> 0x0166 }
                r0 = 1
                r7.setDoInput(r0)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r7.setReadTimeout(r0)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.lang.String r0 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r7.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.io.InputStream r0 = r7.getInputStream()     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r3.<init>(r0)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r0.<init>()     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
            L_0x013c:
                java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                if (r3 == 0) goto L_0x0157
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r4.<init>()     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r4.append(r3)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                r0.append(r3)     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                goto L_0x013c
            L_0x0157:
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0164, all -> 0x0161 }
                if (r7 == 0) goto L_0x0160
                r7.disconnect()
            L_0x0160:
                return r0
            L_0x0161:
                r0 = move-exception
                r1 = r7
                goto L_0x0167
            L_0x0164:
                r1 = r7
                goto L_0x016d
            L_0x0166:
                r0 = move-exception
            L_0x0167:
                if (r1 == 0) goto L_0x016c
                r1.disconnect()
            L_0x016c:
                throw r0
            L_0x016d:
                if (r1 == 0) goto L_0x0172
                r1.disconnect()
            L_0x0172:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargarprofile.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            String str3;
            String str4;
            int i;
            String str5;
            String str6;
            String str7;
            String str8;
            int i2;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            String str25;
            String str26;
            boolean z;
            String str27 = str;
            try {
                profile.this.findViewById(R.id.pb_masfotos_inv).setVisibility(4);
                profile.this.findViewById(R.id.pb_masfotos).setVisibility(4);
                profile.this.findViewById(R.id.pb_masvideos_inv).setVisibility(4);
                profile.this.findViewById(R.id.pb_masvideos).setVisibility(4);
                profile.this.findViewById(R.id.pb_mascoments_inv).setVisibility(8);
                profile.this.findViewById(R.id.pb_mascoments).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str27.contains("ANDROID:OK DATOSUSU:")) {
                SharedPreferences.Editor edit = profile.this.settings.edit();
                int indexOf = str27.indexOf("DATOSUSU:") + 9;
                String str28 = ";";
                int indexOf2 = str27.indexOf(str28, indexOf);
                if (this.condist.equals("1")) {
                    String substring = str27.substring(indexOf, indexOf2);
                    if (substring.equals("-1")) {
                        profile.this.dist = null;
                    } else {
                        profile.this.dist = substring;
                    }
                    profile.this.mostrar_subtit();
                }
                int i3 = 1;
                int i4 = indexOf2 + 1;
                int indexOf3 = str27.indexOf(str28, i4);
                String str29 = ",";
                String str30 = "";
                if (profile.this.extras.getInt("p_descr") > 0) {
                    String substring2 = str27.substring(i4, indexOf3);
                    if (!substring2.equals(str30)) {
                        int indexOf4 = substring2.indexOf(str29);
                        String substring3 = substring2.substring(0, indexOf4);
                        String replace = substring2.substring(indexOf4 + 1).replace("@X@", str29);
                        edit.putString("vdescr_" + profile.this.idusu_profile, substring3);
                        edit.putString("descr_" + profile.this.idusu_profile, replace);
                        edit.commit();
                        profile.this.tv_descr.setText(replace);
                        profile.this.tv_descr.setVisibility(0);
                    }
                }
                String str31 = "0";
                if (profile.this.fotos_perfil == 0 || profile.this.vfoto.equals(str31)) {
                    profile.this.mostrar_viewsaux();
                }
                int i5 = indexOf3 + 1;
                int indexOf5 = str27.indexOf(str28, i5);
                boolean z2 = profile.this.extras.getBoolean("galeria");
                String str32 = ExifInterface.LATITUDE_SOUTH;
                String str33 = "_";
                if (z2) {
                    String[] split = str27.substring(i5, indexOf5).split(str29);
                    int i6 = 0;
                    for (int i7 = 4; i6 < i7; i7 = 4) {
                        edit.remove("idf" + i6 + str33 + profile.this.idusu_profile);
                        edit.remove(f.a + i6 + "_fcrea_" + profile.this.idusu_profile);
                        edit.remove(f.a + i6 + "_nlikes_" + profile.this.idusu_profile);
                        edit.remove(f.a + i6 + "_liked_" + profile.this.idusu_profile);
                        i6++;
                    }
                    int i8 = 0;
                    while (!split[i8].equals(str32) && !split[i8].equals("N")) {
                        String[] split2 = split[i8].split("-");
                        String str34 = str31;
                        edit.putString("idf" + i8 + str33 + profile.this.idusu_profile, split2[0]);
                        edit.putString(f.a + i8 + "_fcrea_" + profile.this.idusu_profile, split2[1]);
                        edit.putString(f.a + i8 + "_nlikes_" + profile.this.idusu_profile, split2[2]);
                        edit.putString(f.a + i8 + "_liked_" + profile.this.idusu_profile, split2[3]);
                        Foto foto = new Foto();
                        foto.id = split2[0];
                        foto.fcrea = split2[1];
                        foto.nlikes = split2[2];
                        foto.liked = split2[3];
                        profile.this.fotos_glob_a.add(foto);
                        i8++;
                        str31 = str34;
                        str30 = str30;
                    }
                    str3 = str31;
                    str2 = str30;
                    edit.commit();
                    profile.this.mostrar_fotos();
                    profile.this.f1.setOnClickListener(profile.this);
                    profile.this.f2.setOnClickListener(profile.this);
                    profile.this.f3.setOnClickListener(profile.this);
                    profile.this.f4.setOnClickListener(profile.this);
                    profile.this.c_f_g = new cargar_fotos_gal();
                    profile.this.c_f_g.execute(new String[0]);
                    if (split[i8].equals(str32)) {
                        profile.this.findViewById(R.id.fl_masfotos).setVisibility(0);
                        i3 = 1;
                    } else {
                        i3 = 1;
                        profile.this.fotos_glob_a_completo = true;
                    }
                } else {
                    str3 = str31;
                    str2 = str30;
                }
                int i9 = indexOf5 + i3;
                int indexOf6 = str27.indexOf(str28, i9);
                if (!profile.this.extras.getString("coments").equals("1") || !profile.this.extras.getBoolean("coments_chat")) {
                    i = indexOf6;
                    str5 = str28;
                    str7 = str33;
                    str4 = str29;
                    str8 = str32;
                    str6 = str2;
                } else {
                    String[] split3 = str27.substring(i9, indexOf6).split(str29);
                    int i10 = 0;
                    while (true) {
                        str9 = "_fnacm_";
                        str10 = "_fnacd_";
                        str11 = "_privados_";
                        str12 = "_vfoto_";
                        str13 = "_idusucrea_";
                        str5 = str28;
                        i = indexOf6;
                        str14 = "_copia";
                        str4 = str29;
                        str15 = str32;
                        if (i10 >= 4) {
                            break;
                        }
                        StringBuilder sb = new StringBuilder("idcom");
                        sb.append(i10);
                        sb.append(str33);
                        String[] strArr = split3;
                        sb.append(profile.this.idusu_profile);
                        sb.append(str14);
                        String str35 = str9;
                        String str36 = str2;
                        edit.putString(sb.toString(), profile.this.settings.getString("idcom" + i10 + str33 + profile.this.idusu_profile, str36));
                        SharedPreferences sharedPreferences = profile.this.settings;
                        StringBuilder sb2 = new StringBuilder("com");
                        sb2.append(i10);
                        sb2.append(str33);
                        String str37 = str33;
                        sb2.append(profile.this.idusu_profile);
                        edit.putString("com" + i10 + str33 + profile.this.idusu_profile + str14, sharedPreferences.getString(sb2.toString(), str36));
                        edit.putString("com" + i10 + "_fcrea_" + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + "_fcrea_" + profile.this.idusu_profile, str36));
                        edit.putString("com" + i10 + str13 + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + str13 + profile.this.idusu_profile, str36));
                        edit.putString("com" + i10 + "_nombre_" + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + "_nombre_" + profile.this.idusu_profile, str36));
                        String str38 = str3;
                        edit.putString("com" + i10 + str12 + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + str12 + profile.this.idusu_profile, str38));
                        SharedPreferences sharedPreferences2 = profile.this.settings;
                        StringBuilder sb3 = new StringBuilder("com");
                        sb3.append(i10);
                        sb3.append(str11);
                        String str39 = str36;
                        sb3.append(profile.this.idusu_profile);
                        edit.putString("com" + i10 + str11 + profile.this.idusu_profile + str14, sharedPreferences2.getString(sb3.toString(), str38));
                        edit.putString("com" + i10 + str10 + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + str10 + profile.this.idusu_profile, str38));
                        StringBuilder sb4 = new StringBuilder("com");
                        sb4.append(i10);
                        String str40 = str35;
                        sb4.append(str40);
                        sb4.append(profile.this.idusu_profile);
                        sb4.append(str14);
                        edit.putString(sb4.toString(), profile.this.settings.getString("com" + i10 + str40 + profile.this.idusu_profile, str38));
                        edit.putString("com" + i10 + "_fnaca_" + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + "_fnaca_" + profile.this.idusu_profile, str38));
                        edit.putString("com" + i10 + "_sexo_" + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + "_sexo_" + profile.this.idusu_profile, str38));
                        edit.putString("com" + i10 + "_coments_" + profile.this.idusu_profile + str14, profile.this.settings.getString("com" + i10 + "_coments_" + profile.this.idusu_profile, str38));
                        StringBuilder sb5 = new StringBuilder("idcom");
                        sb5.append(i10);
                        String str41 = str37;
                        sb5.append(str41);
                        sb5.append(profile.this.idusu_profile);
                        edit.remove(sb5.toString());
                        edit.remove("com" + i10 + str41 + profile.this.idusu_profile);
                        edit.remove("com" + i10 + "_fcrea_" + profile.this.idusu_profile);
                        edit.remove("com" + i10 + str13 + profile.this.idusu_profile);
                        edit.remove("com" + i10 + "_nombre_" + profile.this.idusu_profile);
                        edit.remove("com" + i10 + str12 + profile.this.idusu_profile);
                        edit.remove("com" + i10 + str11 + profile.this.idusu_profile);
                        edit.remove("com" + i10 + str10 + profile.this.idusu_profile);
                        edit.remove("com" + i10 + str35 + profile.this.idusu_profile);
                        edit.remove("com" + i10 + "_fnaca_" + profile.this.idusu_profile);
                        edit.remove("com" + i10 + "_sexo_" + profile.this.idusu_profile);
                        edit.remove("com" + i10 + "_coments_" + profile.this.idusu_profile);
                        i10++;
                        String str42 = str;
                        str33 = str41;
                        str2 = str39;
                        str28 = str5;
                        indexOf6 = i;
                        str29 = str4;
                        split3 = strArr;
                        str3 = str38;
                        str32 = str15;
                    }
                    String[] strArr2 = split3;
                    String str43 = "idcom";
                    String str44 = str33;
                    String str45 = str3;
                    String str46 = str2;
                    edit.commit();
                    int i11 = 0;
                    while (true) {
                        String str47 = str45;
                        String str48 = str15;
                        if (strArr2[i11].equals(str48)) {
                            str7 = str44;
                            str15 = str48;
                            break;
                        }
                        str15 = str48;
                        if (strArr2[i11].equals("N")) {
                            str7 = str44;
                            break;
                        }
                        String[] split4 = strArr2[i11].split("-");
                        String str49 = str14;
                        if (split4.length > 1) {
                            edit.putString(str43 + i11 + str44 + profile.this.idusu_profile, split4[0]);
                            edit.putString("com" + i11 + str44 + profile.this.idusu_profile, split4[1].replace("@X@", "-").replace("@Y@", str4));
                            edit.putString("com" + i11 + "_fcrea_" + profile.this.idusu_profile, split4[2]);
                            edit.putString("com" + i11 + str13 + profile.this.idusu_profile, split4[3]);
                            edit.putString("com" + i11 + "_nombre_" + profile.this.idusu_profile, split4[4]);
                            edit.putString("com" + i11 + str12 + profile.this.idusu_profile, split4[5]);
                            edit.putString("com" + i11 + str11 + profile.this.idusu_profile, split4[6]);
                            edit.putString("com" + i11 + str10 + profile.this.idusu_profile, split4[7]);
                            edit.putString("com" + i11 + str9 + profile.this.idusu_profile, split4[8]);
                            edit.putString("com" + i11 + "_fnaca_" + profile.this.idusu_profile, split4[9]);
                            edit.putString("com" + i11 + "_sexo_" + profile.this.idusu_profile, split4[10]);
                            edit.putString("com" + i11 + "_coments_" + profile.this.idusu_profile, split4[11]);
                            str21 = str43;
                            str17 = str9;
                            str25 = str44;
                            str16 = str10;
                            str24 = str49;
                            str18 = str11;
                            str23 = str46;
                            str20 = str13;
                            String str50 = str47;
                            str19 = str12;
                            str22 = str50;
                        } else {
                            String str51 = str43;
                            String str52 = str44;
                            String str53 = str4;
                            int i12 = 0;
                            while (true) {
                                if (i12 >= 5) {
                                    str4 = str53;
                                    str21 = str51;
                                    str17 = str9;
                                    str25 = str52;
                                    str16 = str10;
                                    str24 = str49;
                                    str18 = str11;
                                    str23 = str46;
                                    str26 = str12;
                                    z = false;
                                    break;
                                }
                                SharedPreferences sharedPreferences3 = profile.this.settings;
                                str4 = str53;
                                str21 = str51;
                                StringBuilder sb6 = new StringBuilder(str21);
                                sb6.append(i12);
                                str17 = str9;
                                str25 = str52;
                                sb6.append(str25);
                                str16 = str10;
                                sb6.append(profile.this.idusu_profile);
                                str24 = str49;
                                sb6.append(str24);
                                str18 = str11;
                                str23 = str46;
                                str26 = str12;
                                if (sharedPreferences3.getString(sb6.toString(), str23).equals(split4[0])) {
                                    z = true;
                                    break;
                                }
                                i12++;
                                str12 = str26;
                                str46 = str23;
                                str11 = str18;
                                str49 = str24;
                                str10 = str16;
                                str52 = str25;
                                str9 = str17;
                                str51 = str21;
                                str53 = str4;
                            }
                            if (z) {
                                edit.putString(str21 + i11 + str25 + profile.this.idusu_profile, profile.this.settings.getString(str21 + i12 + str25 + profile.this.idusu_profile + str24, str23));
                                StringBuilder sb7 = new StringBuilder("com");
                                sb7.append(i11);
                                sb7.append(str25);
                                sb7.append(profile.this.idusu_profile);
                                edit.putString(sb7.toString(), profile.this.settings.getString("com" + i12 + str25 + profile.this.idusu_profile + str24, str23));
                                StringBuilder sb8 = new StringBuilder("com");
                                sb8.append(i11);
                                sb8.append("_fcrea_");
                                sb8.append(profile.this.idusu_profile);
                                edit.putString(sb8.toString(), profile.this.settings.getString("com" + i12 + "_fcrea_" + profile.this.idusu_profile + str24, str23));
                                StringBuilder sb9 = new StringBuilder("com");
                                sb9.append(i11);
                                sb9.append(str13);
                                sb9.append(profile.this.idusu_profile);
                                edit.putString(sb9.toString(), profile.this.settings.getString("com" + i12 + str13 + profile.this.idusu_profile + str24, str23));
                                StringBuilder sb10 = new StringBuilder("com");
                                sb10.append(i11);
                                sb10.append("_nombre_");
                                sb10.append(profile.this.idusu_profile);
                                edit.putString(sb10.toString(), profile.this.settings.getString("com" + i12 + "_nombre_" + profile.this.idusu_profile + str24, str23));
                                StringBuilder sb11 = new StringBuilder("com");
                                sb11.append(i11);
                                String str54 = str26;
                                sb11.append(str54);
                                sb11.append(profile.this.idusu_profile);
                                String sb12 = sb11.toString();
                                SharedPreferences sharedPreferences4 = profile.this.settings;
                                StringBuilder sb13 = new StringBuilder("com");
                                sb13.append(i12);
                                sb13.append(str54);
                                str20 = str13;
                                sb13.append(profile.this.idusu_profile);
                                sb13.append(str24);
                                String sb14 = sb13.toString();
                                str22 = str47;
                                edit.putString(sb12, sharedPreferences4.getString(sb14, str22));
                                StringBuilder sb15 = new StringBuilder("com");
                                sb15.append(i11);
                                String str55 = str18;
                                sb15.append(str55);
                                sb15.append(profile.this.idusu_profile);
                                str19 = str54;
                                edit.putString(sb15.toString(), profile.this.settings.getString("com" + i12 + str55 + profile.this.idusu_profile + str24, str22));
                                StringBuilder sb16 = new StringBuilder("com");
                                sb16.append(i11);
                                String str56 = str16;
                                sb16.append(str56);
                                sb16.append(profile.this.idusu_profile);
                                edit.putString(sb16.toString(), profile.this.settings.getString("com" + i12 + str56 + profile.this.idusu_profile + str24, str22));
                                StringBuilder sb17 = new StringBuilder("com");
                                sb17.append(i11);
                                String str57 = str17;
                                sb17.append(str57);
                                sb17.append(profile.this.idusu_profile);
                                edit.putString(sb17.toString(), profile.this.settings.getString("com" + i12 + str57 + profile.this.idusu_profile + str24, str22));
                                StringBuilder sb18 = new StringBuilder("com");
                                sb18.append(i11);
                                sb18.append("_fnaca_");
                                sb18.append(profile.this.idusu_profile);
                                edit.putString(sb18.toString(), profile.this.settings.getString("com" + i12 + "_fnaca_" + profile.this.idusu_profile + str24, str22));
                                StringBuilder sb19 = new StringBuilder("com");
                                sb19.append(i11);
                                sb19.append("_sexo_");
                                sb19.append(profile.this.idusu_profile);
                                edit.putString(sb19.toString(), profile.this.settings.getString("com" + i12 + "_sexo_" + profile.this.idusu_profile + str24, str22));
                                StringBuilder sb20 = new StringBuilder("com");
                                sb20.append(i11);
                                sb20.append("_coments_");
                                sb20.append(profile.this.idusu_profile);
                                edit.putString(sb20.toString(), profile.this.settings.getString("com" + i12 + "_coments_" + profile.this.idusu_profile + str24, str22));
                            } else {
                                str22 = str47;
                                str19 = str26;
                                str20 = str13;
                            }
                        }
                        i11++;
                        str44 = str25;
                        str14 = str24;
                        str43 = str21;
                        str13 = str20;
                        str9 = str17;
                        str10 = str16;
                        str46 = str23;
                        str45 = str22;
                        str12 = str19;
                        str11 = str18;
                    }
                    str6 = str46;
                    edit.commit();
                    profile.this.mostrar_coments(false);
                    new cargar_fotoscoments().execute(new String[0]);
                    str8 = str15;
                    if (strArr2[i11].equals(str8)) {
                        profile.this.findViewById(R.id.fl_mascoments).setVisibility(0);
                    }
                }
                int i13 = i + 1;
                String str58 = str;
                String str59 = str5;
                int indexOf7 = str58.indexOf(str59, i13);
                profile.this.cambiar_favorito(str58.substring(i13, indexOf7).equals("1"));
                int i14 = indexOf7 + 1;
                int indexOf8 = str58.indexOf(str59, i14);
                if (!profile.this.idusu_profile.equals(profile.this.idusu + str6) && str58.substring(i14, indexOf8).equals("1")) {
                    profile.this.findViewById(R.id.iv_conectado).setVisibility(0);
                }
                int i15 = indexOf8 + 1;
                int indexOf9 = str58.indexOf(str59, i15);
                try {
                    profile.this.nlikes_pro = Integer.parseInt(str58.substring(i15, indexOf9));
                    if (!profile.this.idusu_profile.equals(profile.this.idusu + str6)) {
                        ((TextView) profile.this.findViewById(R.id.tv_likes_n)).setText(profile.this.nlikes_pro + str6);
                        profile.this.findViewById(R.id.tv_likes_n).setVisibility(0);
                    } else {
                        ((TextView) profile.this.findViewById(R.id.tv_likes_self)).setText(profile.this.nlikes_pro + str6);
                        profile.this.findViewById(R.id.tv_likes_self).setVisibility(0);
                    }
                } catch (Exception unused2) {
                }
                int i16 = indexOf9 + 1;
                int indexOf10 = str58.indexOf(str59, i16);
                if (profile.this.globales.galeriav) {
                    String[] split5 = str58.substring(i16, indexOf10).split(str4);
                    for (int i17 = 0; i17 < 4; i17++) {
                        edit.remove("idv" + i17 + str7 + profile.this.idusu_profile);
                        edit.remove("v" + i17 + "_formato_" + profile.this.idusu_profile);
                        edit.remove("v" + i17 + "_fcrea_" + profile.this.idusu_profile);
                        edit.remove("v" + i17 + "_nlikes_" + profile.this.idusu_profile);
                        edit.remove("v" + i17 + "_liked_" + profile.this.idusu_profile);
                    }
                    int i18 = 0;
                    while (!split5[i18].equals(str8) && !split5[i18].equals("N")) {
                        String[] split6 = split5[i18].split("-");
                        edit.putString("idv" + i18 + str7 + profile.this.idusu_profile, split6[0]);
                        edit.putString("v" + i18 + "_formato_" + profile.this.idusu_profile, split6[1]);
                        edit.putString("v" + i18 + "_fcrea_" + profile.this.idusu_profile, split6[2]);
                        edit.putString("v" + i18 + "_nlikes_" + profile.this.idusu_profile, split6[3]);
                        edit.putString("v" + i18 + "_liked_" + profile.this.idusu_profile, split6[4]);
                        Video video = new Video();
                        video.id = split6[0];
                        video.formato = split6[1];
                        video.fcrea = split6[2];
                        video.nlikes = split6[3];
                        video.liked = split6[4];
                        profile.this.videos_glob_a.add(video);
                        i18++;
                    }
                    edit.commit();
                    profile.this.mostrar_videos();
                    profile.this.f1_v.setOnClickListener(profile.this);
                    profile.this.f2_v.setOnClickListener(profile.this);
                    profile.this.f3_v.setOnClickListener(profile.this);
                    profile.this.f4_v.setOnClickListener(profile.this);
                    profile.this.c_v_g = new cargar_videos_gal();
                    profile.this.c_v_g.execute(new String[0]);
                    if (split5[i18].equals(str8)) {
                        profile.this.findViewById(R.id.fl_masvideos).setVisibility(0);
                        i2 = 1;
                    } else {
                        i2 = 1;
                        profile.this.videos_glob_a_completo = true;
                    }
                    profile.this.nvideos = Integer.parseInt(split5[i18 + i2]);
                }
            }
        }
    }

    private class cargar_likes extends AsyncTask<String, Void, String> {
        private cargar_likes() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            profile.this.convertView.findViewById(R.id.likes_pb).setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
                r0.<init>()     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "/srv/likes.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&idusu_pro="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.idusu_profile     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&n="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                int r1 = r1.n_cargados     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009e }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x009e }
                r1.<init>(r0)     // Catch:{ Exception -> 0x009e }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x009e }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x009e }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            L_0x0070:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                if (r2 == 0) goto L_0x008b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r3.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r3.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                goto L_0x0070
            L_0x008b:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                if (r0 == 0) goto L_0x0094
                r0.disconnect()
            L_0x0094:
                return r6
            L_0x0095:
                r6 = move-exception
                goto L_0x00a6
            L_0x0097:
                r6 = r0
                goto L_0x009e
            L_0x0099:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00a6
            L_0x009e:
                java.lang.String r0 = ""
                if (r6 == 0) goto L_0x00a5
                r6.disconnect()
            L_0x00a5:
                return r0
            L_0x00a6:
                if (r0 == 0) goto L_0x00ab
                r0.disconnect()
            L_0x00ab:
                goto L_0x00ad
            L_0x00ac:
                throw r6
            L_0x00ad:
                goto L_0x00ac
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_likes.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            try {
                profile.this.convertView.findViewById(R.id.likes_pb).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                int indexOf = str.indexOf("DATOS:") + 6;
                String[] split = str.substring(indexOf, str.indexOf(";", indexOf)).split(",");
                if (profile.this.listData.size() == 0) {
                    if (profile.this.liked) {
                        likes_item likes_item = new likes_item();
                        likes_item.id = profile.this.idusu + "";
                        likes_item.nombre = profile.this.getResources().getString(R.string.tu);
                        likes_item.t_img = profile.this.globales.getTempFile(profile.this, 1).exists();
                        profile.this.listData.add(likes_item);
                    }
                } else if (((likes_item) profile.this.listData.get(profile.this.listData.size() - 1)).es_mas) {
                    profile.this.listData.remove(profile.this.listData.size() - 1);
                }
                int i = 0;
                while (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                    String[] split2 = split[i].split("-");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= profile.this.listData.size()) {
                            z = false;
                            break;
                        } else if (((likes_item) profile.this.listData.get(i2)).id.equals(split2[0])) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        likes_item likes_item2 = new likes_item();
                        likes_item2.id = split2[0];
                        likes_item2.nombre = split2[1].replace("@X@", ",").replace("@Y@", "-");
                        likes_item2.vfoto_bd = split2[2];
                        if (!likes_item2.vfoto_bd.equals("0")) {
                            likes_item2.t_img = true;
                        }
                        likes_item2.privados = split2[3];
                        likes_item2.fnac_d = split2[4];
                        likes_item2.fnac_m = split2[5];
                        likes_item2.fnac_a = split2[6];
                        likes_item2.sexo = split2[7];
                        likes_item2.coments = split2[8];
                        likes_item2.fav = split2[9].equals("1");
                        profile.this.listData.add(likes_item2);
                        profile.this.n_cargados++;
                    }
                    i++;
                }
                if (split[i].equals(ExifInterface.LATITUDE_SOUTH)) {
                    likes_item likes_item3 = new likes_item();
                    likes_item3.es_mas = true;
                    profile.this.listData.add(likes_item3);
                }
                profile.this.itemAdapter.notifyDataSetChanged();
            }
        }
    }

    private class cargar_coments extends AsyncTask<String, Void, String> {
        private cargar_coments() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            profile.this.findViewById(R.id.fl_mascoments).setVisibility(8);
            if (profile.this.c1_esclaro) {
                profile.this.findViewById(R.id.pb_mascoments_inv).setVisibility(0);
            } else {
                profile.this.findViewById(R.id.pb_mascoments).setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
                r0.<init>()     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "/srv/coments_profile.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&idusu_pro="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.idusu_profile     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&idc="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.idcoment_ult     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009e }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x009e }
                r1.<init>(r0)     // Catch:{ Exception -> 0x009e }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x009e }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x009e }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            L_0x0070:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                if (r2 == 0) goto L_0x008b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r3.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r3.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                goto L_0x0070
            L_0x008b:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                if (r0 == 0) goto L_0x0094
                r0.disconnect()
            L_0x0094:
                return r6
            L_0x0095:
                r6 = move-exception
                goto L_0x00a6
            L_0x0097:
                r6 = r0
                goto L_0x009e
            L_0x0099:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00a6
            L_0x009e:
                java.lang.String r0 = ""
                if (r6 == 0) goto L_0x00a5
                r6.disconnect()
            L_0x00a5:
                return r0
            L_0x00a6:
                if (r0 == 0) goto L_0x00ab
                r0.disconnect()
            L_0x00ab:
                goto L_0x00ad
            L_0x00ac:
                throw r6
            L_0x00ad:
                goto L_0x00ac
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_coments.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2 = str;
            try {
                profile.this.findViewById(R.id.pb_mascoments).setVisibility(8);
                profile.this.findViewById(R.id.pb_mascoments_inv).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str2.contains("ANDROID:OK DATOS:")) {
                int indexOf = str2.indexOf("DATOS:") + 6;
                String[] split = str2.substring(indexOf, str2.indexOf(";", indexOf)).split(",");
                int i = 0;
                while (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                    String[] split2 = split[i].split("-");
                    profile.this.mostrar_coment(false, false, split2[0], split2[3], split2[4], split2[2], split2[1].replace("@X@", "-").replace("@Y@", ","), split2[5], split2[6], split2[7], split2[8], split2[9], split2[10], split2[11]);
                    i++;
                }
                if (profile.this.c_f == null || profile.this.c_f.getStatus() != AsyncTask.Status.RUNNING) {
                    profile.this.c_f = new cargar_fotoscoments();
                    profile.this.c_f.execute(new String[0]);
                }
                if (split[i].equals(ExifInterface.LATITUDE_SOUTH)) {
                    profile.this.findViewById(R.id.fl_mascoments).setVisibility(0);
                }
            }
        }
    }

    private class cargar_fotos extends AsyncTask<String, Void, String> {
        boolean ejecutar;

        private cargar_fotos() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            profile.this.findViewById(R.id.fl_masfotos).setVisibility(4);
            profile.this.findViewById(R.id.fl_menosfotos).setVisibility(4);
            this.ejecutar = true;
            if (profile.this.fotos_glob_a.size() > profile.this.ind_global) {
                profile.this.mostrar_fotos_dearray();
                this.ejecutar = false;
            } else if (profile.this.c1_esclaro) {
                profile.this.findViewById(R.id.pb_masfotos_inv).setVisibility(0);
            } else {
                profile.this.findViewById(R.id.pb_masfotos).setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                boolean r6 = r5.ejecutar
                java.lang.String r0 = ""
                if (r6 != 0) goto L_0x0007
                return r0
            L_0x0007:
                r6 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "/srv/fotos_profile.php?idusu="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                long r2 = r2.idusu     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "&c="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = r2.codigo     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "&idusu_pro="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = r2.idusu_profile     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "&idf="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                int r2 = r2.ind_global     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r3 = 1
                if (r2 <= 0) goto L_0x0054
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.util.ArrayList<stikerwap.appdys.profile$Foto> r2 = r2.fotos_glob_a     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                int r4 = r4.ind_global     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                int r4 = r4 - r3
                java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile$Foto r2 = (stikerwap.appdys.profile.Foto) r2     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = r2.id     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                goto L_0x0059
            L_0x0054:
                r2 = 0
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
            L_0x0059:
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r2.<init>(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.net.URLConnection r1 = r2.openConnection()     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.setDoInput(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r1.setReadTimeout(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r1.setRequestProperty(r6, r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.io.InputStream r6 = r1.getInputStream()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r6.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            L_0x0090:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                if (r3 == 0) goto L_0x00ab
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r4.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r4.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r6.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                goto L_0x0090
            L_0x00ab:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                if (r1 == 0) goto L_0x00b4
                r1.disconnect()
            L_0x00b4:
                return r6
            L_0x00b5:
                r0 = move-exception
                r6 = r1
                goto L_0x00bb
            L_0x00b8:
                r6 = r1
                goto L_0x00c1
            L_0x00ba:
                r0 = move-exception
            L_0x00bb:
                if (r6 == 0) goto L_0x00c0
                r6.disconnect()
            L_0x00c0:
                throw r0
            L_0x00c1:
                if (r6 == 0) goto L_0x00c6
                r6.disconnect()
            L_0x00c6:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_fotos.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (profile.this.findViewById(R.id.pb_masfotos_inv) != null) {
                profile.this.findViewById(R.id.pb_masfotos_inv).setVisibility(4);
                profile.this.findViewById(R.id.pb_masfotos).setVisibility(4);
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                int indexOf = str.indexOf("DATOS:") + 6;
                String[] split = str.substring(indexOf, str.indexOf(";", indexOf)).split(",");
                int i = 0;
                while (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                    String[] split2 = split[i].split("-");
                    Foto foto = new Foto();
                    foto.id = split2[0];
                    foto.fcrea = split2[1];
                    foto.nlikes = split2[2];
                    foto.liked = split2[3];
                    profile.this.fotos_glob_a.add(foto);
                    i++;
                }
                if (split[i].equals("N")) {
                    profile.this.fotos_glob_a_completo = true;
                }
                profile.this.mostrar_fotos_dearray();
            }
        }
    }

    private class cargar_videos extends AsyncTask<String, Void, String> {
        boolean ejecutar;

        private cargar_videos() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            profile.this.findViewById(R.id.fl_masvideos).setVisibility(4);
            profile.this.findViewById(R.id.fl_menosvideos).setVisibility(4);
            this.ejecutar = true;
            if (profile.this.videos_glob_a.size() > profile.this.ind_v_global) {
                profile.this.mostrar_videos_dearray();
                this.ejecutar = false;
            } else if (profile.this.c1_esclaro) {
                profile.this.findViewById(R.id.pb_masvideos_inv).setVisibility(0);
            } else {
                profile.this.findViewById(R.id.pb_masvideos).setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                boolean r6 = r5.ejecutar
                java.lang.String r0 = ""
                if (r6 != 0) goto L_0x0007
                return r0
            L_0x0007:
                r6 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "/srv/videos_profile.php?idusu="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                long r2 = r2.idusu     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "&c="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = r2.codigo     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "&idusu_pro="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = r2.idusu_profile     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = "&idv="
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                int r2 = r2.ind_v_global     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r3 = 1
                if (r2 <= 0) goto L_0x0054
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.util.ArrayList<stikerwap.appdys.profile$Video> r2 = r2.videos_glob_a     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile r4 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                int r4 = r4.ind_v_global     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                int r4 = r4 - r3
                java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                stikerwap.appdys.profile$Video r2 = (stikerwap.appdys.profile.Video) r2     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r2 = r2.id     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                goto L_0x0059
            L_0x0054:
                r2 = 0
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
            L_0x0059:
                r1.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r2.<init>(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.net.URLConnection r1 = r2.openConnection()     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00c1, all -> 0x00ba }
                r1.setDoInput(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r1.setReadTimeout(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r1.setRequestProperty(r6, r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.io.InputStream r6 = r1.getInputStream()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r6.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            L_0x0090:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                if (r3 == 0) goto L_0x00ab
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r4.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r4.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                r6.append(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                goto L_0x0090
            L_0x00ab:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                if (r1 == 0) goto L_0x00b4
                r1.disconnect()
            L_0x00b4:
                return r6
            L_0x00b5:
                r0 = move-exception
                r6 = r1
                goto L_0x00bb
            L_0x00b8:
                r6 = r1
                goto L_0x00c1
            L_0x00ba:
                r0 = move-exception
            L_0x00bb:
                if (r6 == 0) goto L_0x00c0
                r6.disconnect()
            L_0x00c0:
                throw r0
            L_0x00c1:
                if (r6 == 0) goto L_0x00c6
                r6.disconnect()
            L_0x00c6:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_videos.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (profile.this.findViewById(R.id.pb_masvideos_inv) != null) {
                profile.this.findViewById(R.id.pb_masvideos_inv).setVisibility(4);
                profile.this.findViewById(R.id.pb_masvideos).setVisibility(4);
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                int indexOf = str.indexOf("DATOS:") + 6;
                String[] split = str.substring(indexOf, str.indexOf(";", indexOf)).split(",");
                int i = 0;
                while (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                    String[] split2 = split[i].split("-");
                    Video video = new Video();
                    video.id = split2[0];
                    video.formato = split2[1];
                    video.fcrea = split2[2];
                    video.nlikes = split2[3];
                    video.liked = split2[4];
                    profile.this.videos_glob_a.add(video);
                    i++;
                }
                if (split[i].equals("N")) {
                    profile.this.videos_glob_a_completo = true;
                }
                profile.this.mostrar_videos_dearray();
            }
        }
    }

    private class cargar_fotoscoments extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idusu_acargar;
        String vfoto_bd;

        private cargar_fotoscoments() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            for (int i = 0; i < profile.this.ll_coments.getChildCount(); i++) {
                LinearLayout linearLayout = (LinearLayout) profile.this.ll_coments.getChildAt(i);
                String str = (String) linearLayout.findViewById(R.id.iv_usucoment).getTag(R.id.idaux1);
                String str2 = (String) linearLayout.findViewById(R.id.iv_usucoment).getTag(R.id.idaux2);
                this.vfoto_bd = str2;
                if (str2 != null && !str2.equals("0")) {
                    String str3 = this.vfoto_bd;
                    SharedPreferences sharedPreferences = profile.this.settings;
                    if (!str3.equals(sharedPreferences.getString("fperfil_" + str, "0"))) {
                        this.idusu_acargar = str;
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.lang.String r0 = "fperfil_"
                java.lang.String r1 = r4.idusu_acargar
                if (r1 != 0) goto L_0x000b
                java.lang.String r5 = "-1"
                return r5
            L_0x000b:
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/usus/"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idusu_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_1_p.jpg?v="
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.vfoto_bd     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r1.setReadTimeout(r2)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ MalformedURLException -> 0x0085 }
                r4.bmImg = r3     // Catch:{ MalformedURLException -> 0x0085 }
                r2.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                java.io.File r1 = new java.io.File     // Catch:{  }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r4.idusu_acargar     // Catch:{  }
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = ".jpg"
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = r3.toString()     // Catch:{  }
                r1.<init>(r2, r0)     // Catch:{  }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                android.graphics.Bitmap r1 = r4.bmImg     // Catch:{  }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r3 = 70
                r1.compress(r2, r3, r0)     // Catch:{  }
                java.lang.String r5 = "1"
            L_0x0085:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_fotoscoments.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (profile.this.ll_coments != null && this.idusu_acargar != null && !str.equals("-1")) {
                if (str == "1") {
                    SharedPreferences.Editor edit = profile.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, this.vfoto_bd);
                    edit.commit();
                }
                int childCount = profile.this.ll_coments.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    String str2 = (String) profile.this.ll_coments.getChildAt(i).findViewById(R.id.iv_usucoment).getTag(R.id.idaux1);
                    if (str2 != null && str2.equals(this.idusu_acargar)) {
                        profile.this.ll_coments.getChildAt(i).findViewById(R.id.iv_usucoment).setTag(R.id.idaux2, this.vfoto_bd);
                        if (str == "1") {
                            ((ImageView) profile.this.ll_coments.getChildAt(i).findViewById(R.id.iv_usucoment)).setImageBitmap(config.getCircularBitmapWithWhiteBorder(this.bmImg, 1));
                        }
                    }
                }
                new cargar_fotoscoments().execute(new String[0]);
            }
        }
    }

    private class cargar_fotos_gal extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idf;
        ImageView iv;
        ProgressBar pb_aux;

        private cargar_fotos_gal() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (profile.this.f1.getVisibility() == 0 && profile.this.f1.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f1;
                this.pb_aux = profile.this.pb1;
            } else if (profile.this.f2.getVisibility() == 0 && profile.this.f2.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f2;
                this.pb_aux = profile.this.pb2;
            } else if (profile.this.f3.getVisibility() == 0 && profile.this.f3.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f3;
                this.pb_aux = profile.this.pb3;
            } else if (profile.this.f4.getVisibility() == 0 && profile.this.f4.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f4;
                this.pb_aux = profile.this.pb4;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.lang.String r0 = "fperfilgal_"
                android.widget.ImageView r1 = r4.iv
                if (r1 != 0) goto L_0x000b
                java.lang.String r5 = "-1"
                return r5
            L_0x000b:
                r2 = 2131362376(0x7f0a0248, float:1.834453E38)
                java.lang.Object r1 = r1.getTag(r2)
                java.lang.String r1 = (java.lang.String) r1
                r4.idf = r1
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/ususgal/"
                r2.append(r3)     // Catch:{  }
                stikerwap.appdys.profile r3 = stikerwap.appdys.profile.this     // Catch:{  }
                java.lang.String r3 = r3.idusu_profile     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idf     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_p.jpg"
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r1.setReadTimeout(r2)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ MalformedURLException -> 0x0097 }
                r4.bmImg = r3     // Catch:{ MalformedURLException -> 0x0097 }
                r2.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                java.io.File r1 = new java.io.File     // Catch:{  }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r4.idf     // Catch:{  }
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = ".jpg"
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = r3.toString()     // Catch:{  }
                r1.<init>(r2, r0)     // Catch:{  }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                android.graphics.Bitmap r1 = r4.bmImg     // Catch:{  }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r3 = 70
                r1.compress(r2, r3, r0)     // Catch:{  }
                java.lang.String r5 = "1"
            L_0x0097:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_fotos_gal.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (this.iv != null && !str.equals("-1") && ((String) this.iv.getTag(R.id.idaux1)).equals(this.idf)) {
                ProgressBar progressBar = this.pb_aux;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.iv.setTag(R.id.idaux2, ExifInterface.LATITUDE_SOUTH);
                if (str == "1") {
                    this.iv.setImageBitmap(this.bmImg);
                }
                new cargar_fotos_gal().execute(new String[0]);
            }
        }
    }

    private class cargar_videos_gal extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idv;
        ImageView iv;
        ProgressBar pb_aux;

        private cargar_videos_gal() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (profile.this.f1_v.getVisibility() == 0 && profile.this.f1_v.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f1_v;
                this.pb_aux = profile.this.pb1_v;
            } else if (profile.this.f2_v.getVisibility() == 0 && profile.this.f2_v.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f2_v;
                this.pb_aux = profile.this.pb2_v;
            } else if (profile.this.f3_v.getVisibility() == 0 && profile.this.f3_v.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f3_v;
                this.pb_aux = profile.this.pb3_v;
            } else if (profile.this.f4_v.getVisibility() == 0 && profile.this.f4_v.getTag(R.id.idaux2).equals("N")) {
                this.iv = profile.this.f4_v;
                this.pb_aux = profile.this.pb4_v;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.lang.String r0 = "fperfilgalv_"
                android.widget.ImageView r1 = r4.iv
                if (r1 != 0) goto L_0x000b
                java.lang.String r5 = "-1"
                return r5
            L_0x000b:
                r2 = 2131362376(0x7f0a0248, float:1.834453E38)
                java.lang.Object r1 = r1.getTag(r2)
                java.lang.String r1 = (java.lang.String) r1
                r4.idv = r1
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/videos_pro/v"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idv     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_"
                r2.append(r3)     // Catch:{  }
                stikerwap.appdys.profile r3 = stikerwap.appdys.profile.this     // Catch:{  }
                java.lang.String r3 = r3.idusu_profile     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_th.jpg"
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r1.setReadTimeout(r2)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ MalformedURLException -> 0x0097 }
                r4.bmImg = r3     // Catch:{ MalformedURLException -> 0x0097 }
                r2.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                java.io.File r1 = new java.io.File     // Catch:{  }
                stikerwap.appdys.profile r2 = stikerwap.appdys.profile.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r4.idv     // Catch:{  }
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = ".jpg"
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = r3.toString()     // Catch:{  }
                r1.<init>(r2, r0)     // Catch:{  }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                android.graphics.Bitmap r1 = r4.bmImg     // Catch:{  }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r3 = 70
                r1.compress(r2, r3, r0)     // Catch:{  }
                java.lang.String r5 = "1"
            L_0x0097:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.cargar_videos_gal.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (this.iv != null && !str.equals("-1") && ((String) this.iv.getTag(R.id.idaux1)).equals(this.idv)) {
                ProgressBar progressBar = this.pb_aux;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.iv.setTag(R.id.idaux2, ExifInterface.LATITUDE_SOUTH);
                if (str == "1") {
                    Bitmap putOverlay = config.putOverlay(this.bmImg, BitmapFactory.decodeResource(profile.this.getResources(), R.drawable.play_pppp));
                    this.bmImg = putOverlay;
                    this.iv.setImageBitmap(putOverlay);
                }
                new cargar_videos_gal().execute(new String[0]);
            }
        }
    }

    private class enviar_video extends AsyncTask<String, Void, String> {
        int id_temp;
        String videoPath;

        public enviar_video(int i, String str) {
            this.videoPath = str;
            this.id_temp = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            profile.this.d_video = new ProgressDialog(profile.this);
            profile.this.d_video.setMessage(profile.this.getString(R.string.subiendo));
            profile.this.d_video.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !profile.this.cbtn.equals("")) {
                profile.this.d_video.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) profile.this.d_video.findViewById(16908301), profile.this.cbtn);
                    }
                });
            }
            profile.this.d_video.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            String str = "";
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.PROTOC_GEN + "video-upload." + config.DOM_EDROID + "/upload.php?pro=1");
            FileBody fileBody = new FileBody(new File(this.videoPath));
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("videoFile", fileBody);
            try {
                multipartEntity.addPart("idusu", new StringBody(profile.this.idusu + str));
                multipartEntity.addPart("idapp", new StringBody("3008836"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                if (entity != null) {
                    str = EntityUtils.toString(entity);
                }
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            int indexOf = str.indexOf("ANDROID:OK:-");
            boolean z = false;
            if (indexOf != -1) {
                int i = indexOf + 12;
                int indexOf2 = str.indexOf("-", i + 1);
                String substring = str.substring(i, indexOf2);
                int i2 = indexOf2 + 1;
                String substring2 = str.substring(i2, str.indexOf("-", i2));
                if (substring2.equals("1")) {
                    str2 = "mp4";
                } else if (substring2.equals("2")) {
                    str2 = "3gp";
                } else {
                    str2 = substring2.equals(ExifInterface.GPS_MEASUREMENT_3D) ? "webm" : "";
                }
                if (!str2.isEmpty()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.videoPath);
                        config config = profile.this.globales;
                        profile profile = profile.this;
                        String absolutePath = config.getTempFile_libre(profile, "vp" + substring + "." + str2).getAbsolutePath();
                        FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.videoPath = absolutePath;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    new enviar_thumb(this.id_temp, substring, substring2).execute(new String[0]);
                    z = true;
                }
            }
            if (!z) {
                try {
                    profile.this.d_video.dismiss();
                } catch (Exception unused) {
                }
            }
        }
    }

    private class enviar_thumb extends AsyncTask<String, Void, String> {
        String formato;
        int id_temp;
        String idvideo;

        public enviar_thumb(int i, String str, String str2) {
            this.id_temp = i;
            this.idvideo = str;
            this.formato = str2;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            Bitmap bitmap;
            String str = "";
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/guardar_videogal.php");
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(profile.this.getContentResolver(), Uri.fromFile(profile.this.globales.getTempFile(profile.this, this.id_temp)));
            } catch (IOException e) {
                e.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
                return "KO";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            multipartEntity.addPart("thumb", new ByteArrayBody(byteArrayOutputStream.toByteArray(), "temporal.jpg"));
            try {
                multipartEntity.addPart("idusu", new StringBody(profile.this.idusu + str));
                multipartEntity.addPart("c", new StringBody(profile.this.codigo));
                multipartEntity.addPart("idvideo", new StringBody(this.idvideo));
                multipartEntity.addPart("formato", new StringBody(this.formato));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                str = EntityUtils.toString(entity);
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            int i;
            int indexOf;
            try {
                profile.this.d_video.cancel();
            } catch (Exception unused) {
            }
            int indexOf2 = str.indexOf("ANDROID:OK ID:");
            if (indexOf2 == -1 || (indexOf = str.indexOf("-", i)) == -1) {
                z = false;
            } else {
                Video video = new Video();
                video.id = str.substring((i = indexOf2 + 14), indexOf);
                video.formato = this.formato;
                video.fcrea = DateFormat.format("ddMMyyHHmm", new Date()).toString();
                video.nlikes = "0";
                video.liked = "0";
                profile.this.videos_glob_a.add(0, video);
                z = true;
                profile.this.nvideos++;
                profile.this.ind_v_global = 0;
                try {
                    config config = profile.this.globales;
                    config.copy(profile.this.globales.getTempFile(profile.this, this.id_temp), new File(profile.this.path, "fperfilgalv_" + video.id + ".jpg"));
                } catch (Exception unused2) {
                }
                profile.this.mostrar_videos_dearray();
                SharedPreferences.Editor edit = profile.this.settings.edit();
                for (int i2 = 3; i2 > 0; i2 += -1) {
                    SharedPreferences sharedPreferences = profile.this.settings;
                    StringBuilder sb = new StringBuilder("idv");
                    int i3 = i2 - 1;
                    sb.append(i3);
                    sb.append("_");
                    sb.append(profile.this.idusu_profile);
                    edit.putString("idv" + i2 + "_" + profile.this.idusu_profile, sharedPreferences.getString(sb.toString(), ""));
                    edit.putString("v" + i2 + "_formato_" + profile.this.idusu_profile, profile.this.settings.getString("v" + i3 + "_formato_" + profile.this.idusu_profile, ""));
                    edit.putString("v" + i2 + "_fcrea_" + profile.this.idusu_profile, profile.this.settings.getString("v" + i3 + "_fcrea_" + profile.this.idusu_profile, ""));
                    edit.putString("v" + i2 + "_nlikes_" + profile.this.idusu_profile, profile.this.settings.getString("v" + i3 + "_nlikes_" + profile.this.idusu_profile, ""));
                    edit.putString("v" + i2 + "_liked_" + profile.this.idusu_profile, profile.this.settings.getString("v" + i3 + "_liked_" + profile.this.idusu_profile, ""));
                }
                edit.putString("idv0_" + profile.this.idusu_profile, video.id);
                edit.putString("v0_formato_" + profile.this.idusu_profile, video.formato);
                edit.putString("v0_fcrea_" + profile.this.idusu_profile, video.fcrea);
                edit.putString("v0_nlikes_" + profile.this.idusu_profile, video.nlikes);
                edit.putString("v0_liked_" + profile.this.idusu_profile, video.liked);
                edit.commit();
            }
            if (!z) {
                final AlertDialog create = new AlertDialog.Builder(profile.this).setCancelable(false).setPositiveButton(profile.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
                if (!profile.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused3) {
                }
            }
        }
    }

    private class enviar_foto extends AsyncTask<String, Void, String> {
        ProgressDialog d_aux;

        private enviar_foto() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(profile.this);
            this.d_aux = progressDialog;
            progressDialog.setMessage(profile.this.getString(R.string.subiendo));
            this.d_aux.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !profile.this.cbtn.equals("")) {
                this.d_aux.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) enviar_foto.this.d_aux.findViewById(16908301), profile.this.cbtn);
                    }
                });
            }
            this.d_aux.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            Bitmap bitmap;
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/guardar_fotogal.php?idusu=" + profile.this.idusu + "&c=" + profile.this.settings.getString("cod", ""));
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                File extTempFile_libre = profile.this.globales.getExtTempFile_libre(profile.this, "fperfilgal_temp");
                BitmapFactory.Options options = new BitmapFactory.Options();
                boolean z = true;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(extTempFile_libre.getPath(), options);
                int i = options.outWidth;
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                if (i2 > 600 || i3 > 600) {
                    z = false;
                }
                if (!z) {
                    config config = profile.this.globales;
                    int round = Math.round(((float) i2) / ((float) config.calculateNewWidth(i2, i3, 600, 600)));
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = round;
                    bitmap = BitmapFactory.decodeFile(extTempFile_libre.getPath(), options2);
                } else {
                    bitmap = MediaStore.Images.Media.getBitmap(profile.this.getContentResolver(), Uri.fromFile(extTempFile_libre));
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                multipartEntity.addPart("foto1", new ByteArrayBody(byteArrayOutputStream.toByteArray(), "temporal.jpg"));
                httpPost.setEntity(multipartEntity);
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
                    return sb.toString();
                }
                return "";
            } catch (Exception | OutOfMemoryError unused) {
                return "";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            int i;
            int indexOf;
            ProgressDialog progressDialog = this.d_aux;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.d_aux.cancel();
            }
            int indexOf2 = str.indexOf("ANDROID:OK ID:");
            if (indexOf2 == -1 || (indexOf = str.indexOf("-", i)) == -1) {
                z = false;
            } else {
                Foto foto = new Foto();
                foto.id = str.substring((i = indexOf2 + 14), indexOf);
                foto.fcrea = DateFormat.format("ddMMyyHHmm", new Date()).toString();
                foto.nlikes = "0";
                foto.liked = "0";
                profile.this.fotos_glob_a.add(0, foto);
                profile.this.ind_global = 0;
                try {
                    config config = profile.this.globales;
                    config.copy(profile.this.globales.getExtTempFile_libre(profile.this, "fperfilgal_temp"), new File(profile.this.path, "fperfilgal_" + foto.id + ".jpg"));
                    config config2 = profile.this.globales;
                    config.copy(profile.this.globales.getExtTempFile_libre(profile.this, "fperfilgal_temp"), new File(profile.this.path, "fperfilgal_" + foto.id + "_g.jpg"));
                } catch (Exception unused) {
                }
                profile.this.mostrar_fotos_dearray();
                SharedPreferences.Editor edit = profile.this.settings.edit();
                for (int i2 = 3; i2 > 0; i2 += -1) {
                    SharedPreferences sharedPreferences = profile.this.settings;
                    StringBuilder sb = new StringBuilder("idf");
                    int i3 = i2 - 1;
                    sb.append(i3);
                    sb.append("_");
                    sb.append(profile.this.idusu_profile);
                    edit.putString("idf" + i2 + "_" + profile.this.idusu_profile, sharedPreferences.getString(sb.toString(), ""));
                    edit.putString(f.a + i2 + "_fcrea_" + profile.this.idusu_profile, profile.this.settings.getString(f.a + i3 + "_fcrea_" + profile.this.idusu_profile, ""));
                    edit.putString(f.a + i2 + "_nlikes_" + profile.this.idusu_profile, profile.this.settings.getString(f.a + i3 + "_nlikes_" + profile.this.idusu_profile, ""));
                    edit.putString(f.a + i2 + "_liked_" + profile.this.idusu_profile, profile.this.settings.getString(f.a + i3 + "_liked_" + profile.this.idusu_profile, ""));
                }
                edit.putString("idf0_" + profile.this.idusu_profile, foto.id);
                edit.putString("f0_fcrea_" + profile.this.idusu_profile, foto.fcrea);
                edit.putString("f0_nlikes_" + profile.this.idusu_profile, foto.nlikes);
                edit.putString("f0_liked_" + profile.this.idusu_profile, foto.liked);
                edit.commit();
                z = true;
            }
            if (!z) {
                final AlertDialog create = new AlertDialog.Builder(profile.this).setCancelable(false).setPositiveButton(profile.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
                if (!profile.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + profile.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private class elim_coment extends AsyncTask<String, Void, Byte> {
        String idcoment;

        elim_coment(String str) {
            this.idcoment = str;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0091  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0084 }
                r0.<init>()     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "/srv/eliminar_coment.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x0084 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&idc="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r5.idcoment     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0084 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0084 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0084 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x0084 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0084 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.lang.String r1 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r3.<init>(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r2.<init>(r3)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            L_0x005d:
                java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                if (r1 == 0) goto L_0x0071
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r3.<init>()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r3.append(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.lang.String r1 = "\n"
                r3.append(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                goto L_0x005d
            L_0x0071:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                if (r0 == 0) goto L_0x007a
                r0.disconnect()
            L_0x007a:
                return r6
            L_0x007b:
                r6 = move-exception
                goto L_0x008f
            L_0x007d:
                r6 = r0
                goto L_0x0084
            L_0x007f:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x008f
            L_0x0084:
                r0 = 2
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x007f }
                if (r6 == 0) goto L_0x008e
                r6.disconnect()
            L_0x008e:
                return r0
            L_0x008f:
                if (r0 == 0) goto L_0x0094
                r0.disconnect()
            L_0x0094:
                goto L_0x0096
            L_0x0095:
                throw r6
            L_0x0096:
                goto L_0x0095
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.elim_coment.doInBackground(java.lang.String[]):java.lang.Byte");
        }
    }

    private class aplic_favorito extends AsyncTask<String, Void, Byte> {
        String modo;

        aplic_favorito(Boolean bool) {
            this.modo = bool.booleanValue() ? "1" : "0";
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
                r0.<init>()     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "/srv/favorito_usu.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x0090 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "&idusu_pro="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                stikerwap.appdys.profile r1 = stikerwap.appdys.profile.this     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = r1.idusu_profile     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "&modo="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = r5.modo     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0090 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0090 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0090 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x0090 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0090 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.lang.String r1 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            L_0x0069:
                java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                if (r1 == 0) goto L_0x007d
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r3.<init>()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r3.append(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.lang.String r1 = "\n"
                r3.append(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                goto L_0x0069
            L_0x007d:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                if (r0 == 0) goto L_0x0086
                r0.disconnect()
            L_0x0086:
                return r6
            L_0x0087:
                r6 = move-exception
                goto L_0x009b
            L_0x0089:
                r6 = r0
                goto L_0x0090
            L_0x008b:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x009b
            L_0x0090:
                r0 = 2
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x008b }
                if (r6 == 0) goto L_0x009a
                r6.disconnect()
            L_0x009a:
                return r0
            L_0x009b:
                if (r0 == 0) goto L_0x00a0
                r0.disconnect()
            L_0x00a0:
                goto L_0x00a2
            L_0x00a1:
                throw r6
            L_0x00a2:
                goto L_0x00a1
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.aplic_favorito.doInBackground(java.lang.String[]):java.lang.Byte");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00b8, code lost:
        if (r5.equals(r6.toString()) != false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mostrar_coment(java.lang.Boolean r20, java.lang.Boolean r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            r19 = this;
            r0 = r19
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r27
            java.lang.String r5 = "fperfil_"
            java.lang.String r6 = "layout_inflater"
            java.lang.Object r6 = r0.getSystemService(r6)
            android.view.LayoutInflater r6 = (android.view.LayoutInflater) r6
            r7 = 2131558478(0x7f0d004e, float:1.8742273E38)
            r8 = 0
            android.view.View r6 = r6.inflate(r7, r8)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r7 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r6.setTag(r7, r1)
            r8 = 2131362514(0x7f0a02d2, float:1.834481E38)
            android.view.View r8 = r6.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r9 = 2131363454(0x7f0a067e, float:1.8346717E38)
            android.view.View r9 = r6.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131363416(0x7f0a0658, float:1.834664E38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131363400(0x7f0a0648, float:1.8346608E38)
            android.view.View r11 = r6.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131362446(0x7f0a028e, float:1.8344673E38)
            android.view.View r12 = r6.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r13 = 2131362500(0x7f0a02c4, float:1.8344782E38)
            android.view.View r13 = r6.findViewById(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            boolean r14 = r0.c1_esclaro
            if (r14 == 0) goto L_0x006e
            int r14 = stikerwap.appdys.config.NEGRO
            r9.setTextColor(r14)
            int r14 = stikerwap.appdys.config.GRIS_OSCURO
            r10.setTextColor(r14)
            int r14 = stikerwap.appdys.config.NEGRO
            r11.setTextColor(r14)
            goto L_0x007a
        L_0x006e:
            r14 = -1
            r9.setTextColor(r14)
            int r15 = stikerwap.appdys.config.GRIS_CLARO
            r10.setTextColor(r15)
            r11.setTextColor(r14)
        L_0x007a:
            boolean r14 = r20.booleanValue()
            r15 = 0
            java.lang.String r7 = ""
            if (r14 != 0) goto L_0x00d7
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r16 = r5
            r17 = r6
            long r5 = r0.idusu
            r14.append(r5)
            r14.append(r7)
            java.lang.String r5 = r14.toString()
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00bb
            java.lang.String r5 = r0.idusu_profile
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r14 = r10
            r18 = r11
            long r10 = r0.idusu
            r6.append(r10)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00de
            goto L_0x00be
        L_0x00bb:
            r14 = r10
            r18 = r11
        L_0x00be:
            boolean r5 = r0.c1_esclaro
            if (r5 == 0) goto L_0x00d0
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131231068(0x7f08015c, float:1.8078207E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            r12.setImageDrawable(r5)
        L_0x00d0:
            r12.setOnClickListener(r0)
            r12.setVisibility(r15)
            goto L_0x00f6
        L_0x00d7:
            r16 = r5
            r17 = r6
            r14 = r10
            r18 = r11
        L_0x00de:
            boolean r5 = r0.c1_esclaro
            if (r5 == 0) goto L_0x00f0
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131231710(0x7f0803de, float:1.8079509E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            r13.setImageDrawable(r5)
        L_0x00f0:
            r13.setOnClickListener(r0)
            r13.setVisibility(r15)
        L_0x00f6:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r10 = r0.idusu
            r5.append(r10)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L_0x011c
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131886857(0x7f120309, float:1.9408305E38)
            java.lang.String r5 = r5.getString(r6)
            r9.setText(r5)
            goto L_0x011f
        L_0x011c:
            r9.setText(r3)
        L_0x011f:
            java.lang.String r5 = stikerwap.appdys.config.convertir_fecha(r25)
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat
            java.lang.String r9 = "ddMMyyHHmm"
            r6.<init>(r9)
            r9 = 1
            java.text.DateFormat r10 = android.text.format.DateFormat.getDateFormat(r19)     // Catch:{ Exception -> 0x019e }
            java.text.DateFormat r11 = android.text.format.DateFormat.getTimeFormat(r19)     // Catch:{ Exception -> 0x019e }
            java.util.Date r5 = r6.parse(r5)     // Catch:{ Exception -> 0x019e }
            java.util.Calendar r6 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x019e }
            java.util.Calendar r12 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x019e }
            r12.setTime(r5)     // Catch:{ Exception -> 0x019e }
            int r13 = r12.get(r9)     // Catch:{ Exception -> 0x019e }
            int r15 = r6.get(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r9 = " "
            if (r13 != r15) goto L_0x017f
            r13 = 6
            int r12 = r12.get(r13)     // Catch:{ Exception -> 0x019e }
            int r6 = r6.get(r13)     // Catch:{ Exception -> 0x019e }
            if (r12 != r6) goto L_0x017f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019e }
            r6.<init>()     // Catch:{ Exception -> 0x019e }
            android.content.res.Resources r10 = r19.getResources()     // Catch:{ Exception -> 0x019e }
            r12 = 2131886471(0x7f120187, float:1.9407522E38)
            java.lang.String r10 = r10.getString(r12)     // Catch:{ Exception -> 0x019e }
            r6.append(r10)     // Catch:{ Exception -> 0x019e }
            r6.append(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r11.format(r5)     // Catch:{ Exception -> 0x019e }
            r6.append(r5)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x019e }
            r6 = r14
            r6.setText(r5)     // Catch:{ Exception -> 0x019e }
            goto L_0x019f
        L_0x017f:
            r6 = r14
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019e }
            r12.<init>()     // Catch:{ Exception -> 0x019e }
            java.lang.String r10 = r10.format(r5)     // Catch:{ Exception -> 0x019e }
            r12.append(r10)     // Catch:{ Exception -> 0x019e }
            r12.append(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r11.format(r5)     // Catch:{ Exception -> 0x019e }
            r12.append(r5)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x019e }
            r6.setText(r5)     // Catch:{ Exception -> 0x019e }
            goto L_0x019f
        L_0x019e:
        L_0x019f:
            r5 = r26
            r11 = r18
            r11.setText(r5)
            r5 = 2131362376(0x7f0a0248, float:1.834453E38)
            r8.setTag(r5, r2)
            int r6 = r0.fotos_perfil
            if (r6 <= 0) goto L_0x026b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            long r9 = r0.idusu
            r6.append(r9)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x01db
            java.lang.String r6 = "0"
            r9 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r8.setTag(r9, r6)
            android.graphics.Bitmap r6 = r0.bm_propia
            r10 = 1
            android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r10)
            r8.setImageBitmap(r6)
            goto L_0x0270
        L_0x01db:
            r9 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r8.setTag(r9, r4)
            java.io.File r6 = new java.io.File     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            java.io.File r9 = r0.path     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r11 = r16
            r10.<init>(r11)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r10.append(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            java.lang.String r11 = ".jpg"
            r10.append(r11)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r6.<init>(r9, r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.graphics.BitmapFactory$Options r9 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r9.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r10 = 1
            r9.inJustDecodeBounds = r10     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            java.lang.String r10 = r6.getPath()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.graphics.BitmapFactory.decodeFile(r10, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            int r10 = r9.outWidth     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.content.res.Resources r10 = r19.getResources()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            float r10 = r10.density     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r11 = 1111490560(0x42400000, float:48.0)
            float r10 = r10 * r11
            r12 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r12
            int r10 = (int) r10     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.content.res.Resources r13 = r19.getResources()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.util.DisplayMetrics r13 = r13.getDisplayMetrics()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            float r13 = r13.density     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            float r13 = r13 * r11
            float r13 = r13 + r12
            int r11 = (int) r13     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            int r12 = r9.outWidth     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            int r9 = r9.outHeight     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            if (r12 > r10) goto L_0x0236
            if (r9 > r11) goto L_0x0236
            r13 = 1
            goto L_0x0237
        L_0x0236:
            r13 = 0
        L_0x0237:
            if (r13 != 0) goto L_0x0254
            int r9 = stikerwap.appdys.config.calculateNewWidth(r12, r9, r10, r11)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            float r10 = (float) r12     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            float r9 = (float) r9     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            float r10 = r10 / r9
            int r9 = java.lang.Math.round(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r10.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r10.inSampleSize = r9     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r10)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            goto L_0x0260
        L_0x0254:
            android.content.ContentResolver r9 = r19.getContentResolver()     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            android.graphics.Bitmap r6 = android.provider.MediaStore.Images.Media.getBitmap(r9, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
        L_0x0260:
            r9 = 1
            android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            r8.setImageBitmap(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0269 }
            goto L_0x0270
        L_0x0269:
            goto L_0x0270
        L_0x026b:
            r6 = 8
            r8.setVisibility(r6)
        L_0x0270:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            long r8 = r0.idusu
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r6 = r2.equals(r6)
            if (r6 != 0) goto L_0x02d4
            java.lang.String r6 = "ESCOMENT"
            r7 = r17
            r7.setTag(r5, r6)
            r5 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r7.setTag(r5, r2)
            r2 = 2131362379(0x7f0a024b, float:1.8344537E38)
            r7.setTag(r2, r3)
            r2 = 2131362380(0x7f0a024c, float:1.8344539E38)
            r7.setTag(r2, r4)
            r2 = 2131362381(0x7f0a024d, float:1.834454E38)
            r3 = r28
            r7.setTag(r2, r3)
            r2 = 2131362382(0x7f0a024e, float:1.8344543E38)
            r3 = r29
            r7.setTag(r2, r3)
            r2 = 2131362383(0x7f0a024f, float:1.8344545E38)
            r3 = r30
            r7.setTag(r2, r3)
            r2 = 2131362384(0x7f0a0250, float:1.8344547E38)
            r3 = r31
            r7.setTag(r2, r3)
            r2 = 2131362385(0x7f0a0251, float:1.834455E38)
            r3 = r32
            r7.setTag(r2, r3)
            r2 = 2131362377(0x7f0a0249, float:1.8344533E38)
            r3 = r33
            r7.setTag(r2, r3)
            r7.setOnClickListener(r0)
            goto L_0x02d6
        L_0x02d4:
            r7 = r17
        L_0x02d6:
            boolean r2 = r21.booleanValue()
            if (r2 == 0) goto L_0x02e3
            android.widget.LinearLayout r2 = r0.ll_coments
            r3 = 0
            r2.addView(r7, r3)
            goto L_0x02e8
        L_0x02e3:
            android.widget.LinearLayout r2 = r0.ll_coments
            r2.addView(r7)
        L_0x02e8:
            r0.idcoment_ult = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.profile.mostrar_coment(java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void mostrar_coments(boolean z) {
        int i;
        this.ll_coments.removeAllViews();
        boolean z2 = false;
        int i2 = 0;
        while (i2 < 4) {
            SharedPreferences sharedPreferences = this.settings;
            if (!sharedPreferences.getString("idcom" + i2 + "_" + this.idusu_profile, "").equals("")) {
                SharedPreferences sharedPreferences2 = this.settings;
                String string = sharedPreferences2.getString("com" + i2 + "_idusucrea_" + this.idusu_profile, "");
                if (!string.equals("")) {
                    SharedPreferences sharedPreferences3 = this.settings;
                    if (sharedPreferences3.getBoolean("ban_" + string, z2)) {
                        i = i2;
                        i2 = i + 1;
                        z2 = false;
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                Boolean valueOf2 = Boolean.valueOf(z2);
                SharedPreferences sharedPreferences4 = this.settings;
                String string2 = sharedPreferences4.getString("idcom" + i2 + "_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences5 = this.settings;
                String string3 = sharedPreferences5.getString("com" + i2 + "_idusucrea_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences6 = this.settings;
                String string4 = sharedPreferences6.getString("com" + i2 + "_nombre_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences7 = this.settings;
                String string5 = sharedPreferences7.getString("com" + i2 + "_fcrea_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences8 = this.settings;
                String string6 = sharedPreferences8.getString("com" + i2 + "_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences9 = this.settings;
                String string7 = sharedPreferences9.getString("com" + i2 + "_vfoto_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences10 = this.settings;
                String string8 = sharedPreferences10.getString("com" + i2 + "_privados_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences11 = this.settings;
                String string9 = sharedPreferences11.getString("com" + i2 + "_fnacd_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences12 = this.settings;
                String string10 = sharedPreferences12.getString("com" + i2 + "_fnacm_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences13 = this.settings;
                String string11 = sharedPreferences13.getString("com" + i2 + "_fnaca_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences14 = this.settings;
                String string12 = sharedPreferences14.getString("com" + i2 + "_sexo_" + this.idusu_profile, "");
                SharedPreferences sharedPreferences15 = this.settings;
                i = i2;
                mostrar_coment(valueOf, valueOf2, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, sharedPreferences15.getString("com" + i2 + "_coments_" + this.idusu_profile, ""));
                i2 = i + 1;
                z2 = false;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_fotos_dearray() {
        this.f1.setVisibility(8);
        this.f2.setVisibility(8);
        this.f3.setVisibility(8);
        this.f4.setVisibility(8);
        this.pb1.setVisibility(8);
        this.pb2.setVisibility(8);
        this.pb3.setVisibility(8);
        this.pb4.setVisibility(8);
        this.ll_likes1.setVisibility(8);
        this.ll_likes2.setVisibility(8);
        this.ll_likes3.setVisibility(8);
        this.ll_likes4.setVisibility(8);
        int i = 0;
        while (i < 4 && this.ind_global + i <= this.fotos_glob_a.size() - 1) {
            mostrar_foto(this.ind_global + i, true);
            i++;
        }
        if (this.fotos_glob_a.isEmpty()) {
            String str = this.idusu_profile;
            if (!str.equals(this.idusu + "")) {
                findViewById(R.id.tl_fotos).setVisibility(8);
                cargar_fotos_gal cargar_fotos_gal2 = new cargar_fotos_gal();
                this.c_f_g = cargar_fotos_gal2;
                cargar_fotos_gal2.execute(new String[0]);
            }
        }
        if (this.ind_global + i <= this.fotos_glob_a.size() - 1 || !this.fotos_glob_a_completo) {
            findViewById(R.id.fl_masfotos).setVisibility(0);
        } else {
            findViewById(R.id.fl_masfotos).setVisibility(4);
        }
        if (this.ind_global > 0) {
            findViewById(R.id.fl_menosfotos).setVisibility(0);
        } else {
            findViewById(R.id.fl_menosfotos).setVisibility(4);
        }
        findViewById(R.id.tl_fotos).setVisibility(0);
        cargar_fotos_gal cargar_fotos_gal22 = new cargar_fotos_gal();
        this.c_f_g = cargar_fotos_gal22;
        cargar_fotos_gal22.execute(new String[0]);
    }

    /* access modifiers changed from: package-private */
    public void mostrar_fotos() {
        this.f1.setVisibility(8);
        this.f2.setVisibility(8);
        this.f3.setVisibility(8);
        this.f4.setVisibility(8);
        this.pb1.setVisibility(8);
        this.pb2.setVisibility(8);
        this.pb3.setVisibility(8);
        this.pb4.setVisibility(8);
        this.ll_likes1.setVisibility(8);
        this.ll_likes2.setVisibility(8);
        this.ll_likes3.setVisibility(8);
        this.ll_likes4.setVisibility(8);
        int i = 0;
        boolean z = false;
        while (i < 4) {
            SharedPreferences sharedPreferences = this.settings;
            if (sharedPreferences.getString("idf" + i + "_" + this.idusu_profile, "").equals("")) {
                break;
            }
            mostrar_foto(i, false);
            i++;
            z = true;
        }
        if (!z) {
            String str = this.idusu_profile;
            if (!str.equals(this.idusu + "")) {
                findViewById(R.id.tl_fotos).setVisibility(8);
                return;
            }
        }
        findViewById(R.id.tl_fotos).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void mostrar_foto(int i, boolean z) {
        ProgressBar progressBar;
        TextView textView;
        LinearLayout linearLayout;
        ImageView imageView;
        Boolean bool;
        String str;
        String str2;
        Bitmap bitmap;
        int i2 = i;
        int i3 = i2 % 4;
        boolean z2 = true;
        if (i3 == 0) {
            imageView = this.f1;
            linearLayout = this.ll_likes1;
            textView = this.tv_likes1;
            progressBar = this.pb1;
        } else if (i3 == 1) {
            imageView = this.f2;
            linearLayout = this.ll_likes2;
            textView = this.tv_likes2;
            progressBar = this.pb2;
        } else if (i3 == 2) {
            imageView = this.f3;
            linearLayout = this.ll_likes3;
            textView = this.tv_likes3;
            progressBar = this.pb3;
        } else if (i3 == 3) {
            imageView = this.f4;
            linearLayout = this.ll_likes4;
            textView = this.tv_likes4;
            progressBar = this.pb4;
        } else {
            return;
        }
        if (z) {
            str2 = this.fotos_glob_a.get(i2).id;
            str = this.fotos_glob_a.get(i2).nlikes;
            bool = Boolean.valueOf(this.fotos_glob_a.get(i2).eliminada);
        } else {
            SharedPreferences sharedPreferences = this.settings;
            String string = sharedPreferences.getString("idf" + i2 + "_" + this.idusu_profile, "");
            SharedPreferences sharedPreferences2 = this.settings;
            String string2 = sharedPreferences2.getString(f.a + i2 + "_nlikes_" + this.idusu_profile, "");
            bool = false;
            str2 = string;
            str = string2;
        }
        progressBar.setVisibility(8);
        imageView.setTag(R.id.idaux1, str2);
        imageView.setTag(R.id.idaux2, "N");
        imageView.setTag(R.id.idaux3, i2 + "");
        if (bool.booleanValue()) {
            imageView.setImageDrawable((Drawable) null);
            imageView.setTag(R.id.idaux2, ExifInterface.LATITUDE_SOUTH);
            linearLayout.setVisibility(8);
        } else {
            if (str.equals("0")) {
                linearLayout.setVisibility(8);
            } else {
                textView.setText(str);
                linearLayout.setVisibility(0);
            }
            try {
                File file = this.path;
                File file2 = new File(file, "fperfilgal_" + str2 + ".jpg");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file2.getPath(), options);
                int i4 = options.outWidth;
                int i5 = (int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f);
                int i6 = (int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f);
                int i7 = options.outWidth;
                int i8 = options.outHeight;
                if (i7 > i5 || i8 > i6) {
                    z2 = false;
                }
                if (!z2) {
                    int round = Math.round(((float) i7) / ((float) config.calculateNewWidth(i7, i8, i5, i6)));
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = round;
                    bitmap = BitmapFactory.decodeFile(file2.getPath(), options2);
                } else {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file2));
                }
                imageView.setImageBitmap(bitmap);
                imageView.setTag(R.id.idaux2, ExifInterface.LATITUDE_SOUTH);
            } catch (Exception unused) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sinfoto_chat));
                progressBar.setVisibility(0);
            } catch (OutOfMemoryError unused2) {
            }
        }
        imageView.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void mostrar_videos_dearray() {
        this.f1_v.setVisibility(8);
        this.f2_v.setVisibility(8);
        this.f3_v.setVisibility(8);
        this.f4_v.setVisibility(8);
        this.pb1_v.setVisibility(8);
        this.pb2_v.setVisibility(8);
        this.pb3_v.setVisibility(8);
        this.pb4_v.setVisibility(8);
        this.ll_v_likes1.setVisibility(8);
        this.ll_v_likes2.setVisibility(8);
        this.ll_v_likes3.setVisibility(8);
        this.ll_v_likes4.setVisibility(8);
        int i = 0;
        while (i < 4 && this.ind_v_global + i <= this.videos_glob_a.size() - 1) {
            mostrar_video(this.ind_v_global + i, true);
            i++;
        }
        if (this.videos_glob_a.isEmpty()) {
            String str = this.idusu_profile;
            if (!str.equals(this.idusu + "")) {
                findViewById(R.id.tl_videos).setVisibility(8);
                cargar_videos_gal cargar_videos_gal2 = new cargar_videos_gal();
                this.c_v_g = cargar_videos_gal2;
                cargar_videos_gal2.execute(new String[0]);
            }
        }
        if (this.ind_v_global + i <= this.videos_glob_a.size() - 1 || !this.videos_glob_a_completo) {
            findViewById(R.id.fl_masvideos).setVisibility(0);
        } else {
            findViewById(R.id.fl_masvideos).setVisibility(4);
        }
        if (this.ind_v_global > 0) {
            findViewById(R.id.fl_menosvideos).setVisibility(0);
        } else {
            findViewById(R.id.fl_menosvideos).setVisibility(4);
        }
        findViewById(R.id.tl_videos).setVisibility(0);
        cargar_videos_gal cargar_videos_gal22 = new cargar_videos_gal();
        this.c_v_g = cargar_videos_gal22;
        cargar_videos_gal22.execute(new String[0]);
    }

    /* access modifiers changed from: package-private */
    public void mostrar_videos() {
        this.f1_v.setVisibility(8);
        this.f2_v.setVisibility(8);
        this.f3_v.setVisibility(8);
        this.f4_v.setVisibility(8);
        this.pb1_v.setVisibility(8);
        this.pb2_v.setVisibility(8);
        this.pb3_v.setVisibility(8);
        this.pb4_v.setVisibility(8);
        this.ll_v_likes1.setVisibility(8);
        this.ll_v_likes2.setVisibility(8);
        this.ll_v_likes3.setVisibility(8);
        this.ll_v_likes4.setVisibility(8);
        int i = 0;
        boolean z = false;
        while (i < 4) {
            SharedPreferences sharedPreferences = this.settings;
            if (sharedPreferences.getString("idv" + i + "_" + this.idusu_profile, "").equals("")) {
                break;
            }
            mostrar_video(i, false);
            i++;
            z = true;
        }
        if (!z) {
            String str = this.idusu_profile;
            if (!str.equals(this.idusu + "")) {
                findViewById(R.id.tl_videos).setVisibility(8);
                return;
            }
        }
        findViewById(R.id.tl_videos).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void mostrar_video(int i, boolean z) {
        ProgressBar progressBar;
        TextView textView;
        LinearLayout linearLayout;
        ImageView imageView;
        Boolean bool;
        String str;
        String str2;
        Bitmap bitmap;
        int i2 = i;
        int i3 = i2 % 4;
        boolean z2 = true;
        if (i3 == 0) {
            imageView = this.f1_v;
            linearLayout = this.ll_v_likes1;
            textView = this.tv_v_likes1;
            progressBar = this.pb1_v;
        } else if (i3 == 1) {
            imageView = this.f2_v;
            linearLayout = this.ll_v_likes2;
            textView = this.tv_v_likes2;
            progressBar = this.pb2_v;
        } else if (i3 == 2) {
            imageView = this.f3_v;
            linearLayout = this.ll_v_likes3;
            textView = this.tv_v_likes3;
            progressBar = this.pb3_v;
        } else if (i3 == 3) {
            imageView = this.f4_v;
            linearLayout = this.ll_v_likes4;
            textView = this.tv_v_likes4;
            progressBar = this.pb4_v;
        } else {
            return;
        }
        if (z) {
            str2 = this.videos_glob_a.get(i2).id;
            str = this.videos_glob_a.get(i2).nlikes;
            bool = Boolean.valueOf(this.videos_glob_a.get(i2).eliminado);
        } else {
            SharedPreferences sharedPreferences = this.settings;
            String string = sharedPreferences.getString("idv" + i2 + "_" + this.idusu_profile, "");
            SharedPreferences sharedPreferences2 = this.settings;
            String string2 = sharedPreferences2.getString("v" + i2 + "_nlikes_" + this.idusu_profile, "");
            bool = false;
            str2 = string;
            str = string2;
        }
        progressBar.setVisibility(8);
        imageView.setTag(R.id.idaux1, str2);
        imageView.setTag(R.id.idaux2, "N");
        imageView.setTag(R.id.idaux3, i2 + "");
        if (bool.booleanValue()) {
            imageView.setImageDrawable((Drawable) null);
            imageView.setTag(R.id.idaux2, ExifInterface.LATITUDE_SOUTH);
            linearLayout.setVisibility(8);
        } else {
            if (str.equals("0")) {
                linearLayout.setVisibility(8);
            } else {
                textView.setText(str);
                linearLayout.setVisibility(0);
            }
            try {
                File file = this.path;
                File file2 = new File(file, "fperfilgalv_" + str2 + ".jpg");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file2.getPath(), options);
                int i4 = options.outWidth;
                int i5 = (int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f);
                int i6 = (int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f);
                int i7 = options.outWidth;
                int i8 = options.outHeight;
                if (i7 > i5 || i8 > i6) {
                    z2 = false;
                }
                if (!z2) {
                    int round = Math.round(((float) i7) / ((float) config.calculateNewWidth(i7, i8, i5, i6)));
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = round;
                    bitmap = BitmapFactory.decodeFile(file2.getPath(), options2);
                } else {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file2));
                }
                imageView.setImageBitmap(config.putOverlay(bitmap, BitmapFactory.decodeResource(getResources(), R.drawable.play_pppp)));
                imageView.setTag(R.id.idaux2, ExifInterface.LATITUDE_SOUTH);
            } catch (Exception unused) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sinfoto_chat));
                progressBar.setVisibility(0);
            } catch (OutOfMemoryError unused2) {
            }
        }
        imageView.setVisibility(0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        ((LinearLayout) findViewById(R.id.ll_ad)).removeAllViews();
        Anuncios anuncios = this.anun;
        if (!(anuncios == null || anuncios.adView == null)) {
            try {
                this.anun.adView.destroy();
            } catch (Exception unused) {
            }
        }
        Anuncios anuncios2 = this.anun;
        if (!(anuncios2 == null || anuncios2.adView_fb == null)) {
            try {
                this.anun.adView_fb.destroy();
            } catch (Exception unused2) {
            }
        }
        Anuncios anuncios3 = this.anun;
        if (!(anuncios3 == null || anuncios3.wortiseBanner == null)) {
            try {
                this.anun.wortiseBanner.destroy();
            } catch (Exception unused3) {
            }
        }
        banner();
    }

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("es_root", this.es_root);
    }

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void onPause() {
        Anuncios anuncios;
        Anuncios anuncios2;
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.pause();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.pause();
        }
        BannerAd bannerAd = this.adView_nat_w;
        if (bannerAd != null) {
            bannerAd.pause();
        }
        super.onPause();
        config.onPause_global(this);
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        SharedPreferences sharedPreferences = this.settings;
        cambiar_favorito(sharedPreferences.contains("usufav_" + this.idusu_profile));
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.resume();
        }
        BannerAd bannerAd = this.adView_nat_w;
        if (bannerAd != null) {
            bannerAd.resume();
        }
    }

    public void onDestroy() {
        Anuncios anuncios;
        Anuncios anuncios2;
        Anuncios anuncios3;
        if (!(this.globales.admob_pos == 0 || (anuncios3 = this.anun) == null || anuncios3.adView == null)) {
            this.anun.adView.destroy();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView_fb == null)) {
            this.anun.adView_fb.destroy();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.destroy();
        }
        BannerAd bannerAd = this.adView_nat_w;
        if (bannerAd != null) {
            bannerAd.destroy();
        }
        if ((this.es_root && isFinishing()) || config.finalizar_app) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            super.onBackPressed();
            return;
        }
        this.atras_pulsado = true;
        config.confirmar_exit(this);
    }

    public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
        this.dialog_cargando.cancel();
        this.mAd_appnext.showAd();
    }

    public void onAdClosed() {
        if (this.mAd_visto) {
            abrir_secc(this.v_abrir_secc);
        }
    }

    public void adError(String str) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }

    public void videoEnded() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    private void establec_ralc(final Context context) {
        this.ralc = new RewardedAdLoadCallback() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                if (!profile.this.globales.admob_rew_failed(context, profile.this.mAd_appnext)) {
                    profile.this.dialog_cargando.cancel();
                    profile profile = profile.this;
                    profile.abrir_secc(profile.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                profile.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        profile.this.abrir_secc(profile.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (profile.this.mAd_visto) {
                            profile.this.abrir_secc(profile.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        profile.this.mAd_visto = true;
                        config.rew_visto(context);
                    }
                });
            }
        };
    }

    public void onError(Ad ad, AdError adError) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }

    public void onAdLoaded(Ad ad) {
        this.dialog_cargando.cancel();
        this.mAd_fb.show();
    }

    public void onRewardedVideoCompleted() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    public void onRewardedVideoClosed() {
        if (this.mAd_visto) {
            abrir_secc(this.v_abrir_secc);
        }
    }

    public void onVideoCompleted() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        this.mAd_st.showAd("REWARDED VIDEO", new AdDisplayListener() {
            public void adClicked(com.startapp.sdk.adsbase.Ad ad) {
            }

            public void adDisplayed(com.startapp.sdk.adsbase.Ad ad) {
            }

            public void adNotDisplayed(com.startapp.sdk.adsbase.Ad ad) {
            }

            public void adHidden(com.startapp.sdk.adsbase.Ad ad) {
                if (profile.this.mAd_visto) {
                    profile profile = profile.this;
                    profile.abrir_secc(profile.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
