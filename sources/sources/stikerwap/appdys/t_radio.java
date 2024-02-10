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
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerSize;
import com.appnext.banners.BannerView;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.ads.Ad;
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
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.ads.banner.Mrec;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.wortise.ads.AdError;
import com.wortise.ads.banner.BannerAd;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class t_radio extends Activity_ext_class implements Activity_ext, View.OnKeyListener, View.OnClickListener, MediaController.MediaPlayerControl, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private int TV_MARGIN;
    private int TV_PADDING;
    private int WIDTH_IMGS;
    HashMap<String, String> acargar_m;
    BannerAd adView_nat_w;
    AdView admob_rad;
    private int altura;
    Anuncios anun;
    BannerView appnext_rad;
    boolean atras_pulsado = false;
    Bitmap bm_propia;
    String c1;
    boolean c1_esclaro;
    String c2;
    boolean c2_esclaro;
    boolean c_fondotxt_esclaro;
    /* access modifiers changed from: private */
    public String codigo;
    boolean coments;
    boolean con_chat;
    private int descr;
    /* access modifiers changed from: private */
    public String dia_act;
    private int dist;
    int dp10;
    int dp3;
    enviar env;
    boolean esStream = false;
    Bundle extras;
    com.facebook.ads.AdView fb_rad;
    private int fnac;
    private int fotos_chat;
    HashMap<String, Bitmap> fotos_m;
    /* access modifiers changed from: private */
    public int fotos_perfil;
    boolean galeria;
    config globales;
    boolean hay_banner;
    boolean hayfrasedeotrousu = false;
    int height_global;
    /* access modifiers changed from: private */
    public int idfrase_masantigua_glob;
    private int idsecc;
    /* access modifiers changed from: private */
    public int idtema;
    /* access modifiers changed from: private */
    public long idusu;
    /* access modifiers changed from: private */
    public String idusu_act;
    private long idusu_global;
    int ind;
    HashMap<String, String> intentados_m;
    LinearLayout llchat;
    boolean logineado_ok;
    boolean mAd_visto = false;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public MediaController mMediaController;
    int marge_mateix;
    /* access modifiers changed from: private */
    public int nfrases;
    obtener_foto o_f;
    File path;
    ProgressBar pb_enviando;
    boolean privados;
    int radio_mostrar;
    float scale;
    private int sexo;
    SharedPreferences sh;
    SharedPreferences sh_mc;
    SharedPreferences sh_mp;
    List<String> spool = new ArrayList();
    TextView tv_artist;
    TextView tv_song;
    int width_ad;
    int width_frase;
    int width_global;

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:178:0x05de, code lost:
        if (r0.sh.getInt("fnac_a", 0) != 0) goto L_0x05e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x05ed, code lost:
        if (r0.sh.getInt("sexo", r14) == 0) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x05fd, code lost:
        if (r0.sh.getString("descr", "").equals("") != false) goto L_0x05bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x049f A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "fondo_"
            android.content.Context r3 = r19.getApplicationContext()
            stikerwap.appdys.config r3 = (stikerwap.appdys.config) r3
            r0.globales = r3
            java.lang.String r3 = r3.c1
            if (r3 != 0) goto L_0x0017
            stikerwap.appdys.config r3 = r0.globales
            r3.recuperar_vars()
        L_0x0017:
            r0.establec_ralc(r0)
            android.content.Intent r3 = r19.getIntent()
            android.os.Bundle r3 = r3.getExtras()
            r0.extras = r3
            java.lang.String r4 = "es_root"
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L_0x0040
            if (r3 == 0) goto L_0x003c
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x003c
            android.os.Bundle r3 = r0.extras
            boolean r3 = r3.getBoolean(r4, r6)
            if (r3 == 0) goto L_0x003c
            r3 = 1
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            r0.es_root = r3
            goto L_0x0051
        L_0x0040:
            boolean r3 = r1.containsKey(r4)
            if (r3 == 0) goto L_0x004e
            boolean r3 = r1.getBoolean(r4, r6)
            if (r3 == 0) goto L_0x004e
            r3 = 1
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            r0.es_root = r3
        L_0x0051:
            android.content.Intent r3 = r19.getIntent()
            android.os.Bundle r3 = r3.getExtras()
            r0.extras = r3
            java.lang.String r4 = "ind"
            int r3 = r3.getInt(r4)
            r0.ind = r3
            java.lang.String r3 = "sh"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r6)
            r0.sh = r3
            stikerwap.appdys.config r3 = r0.globales
            int r3 = r3.fondo_v
            if (r3 <= 0) goto L_0x0077
            android.content.SharedPreferences r3 = r0.sh
            r3.registerOnSharedPreferenceChangeListener(r0)
        L_0x0077:
            stikerwap.appdys.config r3 = r0.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            int r4 = r0.ind
            r3 = r3[r4]
            java.lang.String r3 = r3.c1
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos
            java.lang.String r3 = stikerwap.appdys.config.aplicar_color_dialog(r3, r4)
            r0.cbtn = r3
            super.onCreate(r20)
            r3 = 2131558741(0x7f0d0155, float:1.8742806E38)
            r0.setContentView(r3)
            r19.incluir_menu_pre()
            stikerwap.appdys.config r3 = r0.globales
            r3.onCreate_global(r0, r6)
            java.lang.String r3 = "search"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.SearchManager r3 = (android.app.SearchManager) r3
            stikerwap.appdys.t_radio$1 r4 = new stikerwap.appdys.t_radio$1
            r4.<init>()
            r3.setOnCancelListener(r4)
            stikerwap.appdys.t_radio$2 r4 = new stikerwap.appdys.t_radio$2
            r4.<init>()
            r3.setOnDismissListener(r4)
            stikerwap.appdys.config r3 = r0.globales
            int r3 = r3.tipomenu
            if (r3 != r5) goto L_0x00cb
            r3 = 2131362182(0x7f0a0186, float:1.8344137E38)
            android.view.View r3 = r0.findViewById(r3)
            androidx.drawerlayout.widget.DrawerLayout r3 = (androidx.drawerlayout.widget.DrawerLayout) r3
            stikerwap.appdys.t_radio$3 r4 = new stikerwap.appdys.t_radio$3
            r4.<init>()
            r3.addDrawerListener(r4)
        L_0x00cb:
            stikerwap.appdys.config r3 = r0.globales
            android.os.Bundle r4 = r0.extras
            if (r4 == 0) goto L_0x00db
            java.lang.String r7 = "ad_entrar"
            boolean r4 = r4.containsKey(r7)
            if (r4 == 0) goto L_0x00db
            r4 = 1
            goto L_0x00dc
        L_0x00db:
            r4 = 0
        L_0x00dc:
            android.os.Bundle r7 = r0.extras
            if (r7 == 0) goto L_0x00ea
            java.lang.String r8 = "fb_entrar"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x00ea
            r7 = 1
            goto L_0x00eb
        L_0x00ea:
            r7 = 0
        L_0x00eb:
            r3.toca_int(r0, r4, r7)
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.admob_radio_cod
            java.lang.String r4 = ""
            if (r3 != r4) goto L_0x0117
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.appnext_radio_cod
            if (r3 != r4) goto L_0x0117
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.fb_radio_cod
            if (r3 != r4) goto L_0x0117
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.st_radio_cod
            if (r3 != r4) goto L_0x0117
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.is_radio_cod
            if (r3 != r4) goto L_0x0117
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.wortise_radio_cod
            if (r3 == r4) goto L_0x0115
            goto L_0x0117
        L_0x0115:
            r3 = 0
            goto L_0x0118
        L_0x0117:
            r3 = 1
        L_0x0118:
            r0.hay_banner = r3
            if (r3 == 0) goto L_0x0120
            r19.posar_banner()
            goto L_0x0128
        L_0x0120:
            stikerwap.appdys.config r3 = r0.globales
            stikerwap.appdys.Anuncios r3 = r3.mostrar_banner(r0, r6)
            r0.anun = r3
        L_0x0128:
            stikerwap.appdys.config r3 = r0.globales
            int r7 = r3.ind_secc_sel_2
            java.lang.String r8 = r0.cbtn
            r3.oncreate_popup(r0, r7, r8, r1)
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r3 = r0.ind
            r1 = r1[r3]
            java.lang.String r1 = r1.c1
            boolean r1 = r1.equals(r4)
            java.lang.String r3 = "#"
            r7 = 2
            if (r1 != 0) goto L_0x018f
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r8 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            int[] r9 = new int[r7]
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r3)
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r0.ind
            r11 = r11[r12]
            java.lang.String r11 = r11.c1
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            int r10 = android.graphics.Color.parseColor(r10)
            r9[r6] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r3)
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r0.ind
            r11 = r11[r12]
            java.lang.String r11 = r11.c2
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            int r10 = android.graphics.Color.parseColor(r10)
            r9[r5] = r10
            r1.<init>(r8, r9)
            r8 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r8 = r0.findViewById(r8)
            r8.setBackgroundDrawable(r1)
        L_0x018f:
            boolean r1 = r0.hay_banner
            r8 = 0
            r9 = 3
            if (r1 != 0) goto L_0x0285
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r10 = r0.ind
            r1 = r1[r10]
            int r1 = r1.idfondo
            r10 = 2131362464(0x7f0a02a0, float:1.834471E38)
            if (r1 <= 0) goto L_0x024d
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r11 = r0.ind
            r1 = r1[r11]
            boolean r1 = r1.fondo_modif
            if (r1 != 0) goto L_0x01f9
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            android.view.View r11 = r0.findViewById(r10)     // Catch:{ Exception -> 0x01f6 }
            android.widget.ImageView r11 = (android.widget.ImageView) r11     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r12 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.Seccion[] r12 = r12.secciones_a     // Catch:{ Exception -> 0x01f6 }
            int r13 = r0.ind     // Catch:{ Exception -> 0x01f6 }
            r12 = r12[r13]     // Catch:{ Exception -> 0x01f6 }
            boolean r12 = r12.fondo_margen     // Catch:{ Exception -> 0x01f6 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r13 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.Seccion[] r13 = r13.secciones_a     // Catch:{ Exception -> 0x01f6 }
            int r14 = r0.ind     // Catch:{ Exception -> 0x01f6 }
            r13 = r13[r14]     // Catch:{ Exception -> 0x01f6 }
            int r13 = r13.fondo_tipo     // Catch:{ Exception -> 0x01f6 }
            r1.tratar_fondo(r11, r12, r13)     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f6 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r2 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a     // Catch:{ Exception -> 0x01f6 }
            int r12 = r0.ind     // Catch:{ Exception -> 0x01f6 }
            r2 = r2[r12]     // Catch:{ Exception -> 0x01f6 }
            int r2 = r2.idfondo     // Catch:{ Exception -> 0x01f6 }
            r11.append(r2)     // Catch:{ Exception -> 0x01f6 }
            java.lang.String r2 = r11.toString()     // Catch:{ Exception -> 0x01f6 }
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x01f6 }
            android.widget.ImageView r10 = (android.widget.ImageView) r10     // Catch:{ Exception -> 0x01f6 }
            r1.file_to_iv(r2, r10)     // Catch:{ Exception -> 0x01f6 }
            goto L_0x0285
        L_0x01f6:
            goto L_0x0285
        L_0x01f9:
            stikerwap.appdys.t_radio$cargarfoto r1 = new stikerwap.appdys.t_radio$cargarfoto
            r1.<init>()
            java.lang.String[] r2 = new java.lang.String[r9]
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r0.ind
            r11 = r11[r12]
            int r11 = r11.idfondo
            r10.append(r11)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            r2[r6] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            int r11 = r0.ind
            r10.append(r11)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            r2[r5] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r0.ind
            r11 = r11[r12]
            int r11 = r11.vfondo
            r10.append(r11)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            r2[r7] = r10
            r1.execute(r2)
            goto L_0x0285
        L_0x024d:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.fondo_v
            if (r1 <= 0) goto L_0x0285
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r2 = "fondo_v_act"
            int r1 = r1.getInt(r2, r6)
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fondo_v
            if (r1 != r2) goto L_0x0285
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            android.view.View r2 = r0.findViewById(r10)     // Catch:{ Exception -> 0x01f6 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r11 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            boolean r11 = r11.fondo_margen     // Catch:{ Exception -> 0x01f6 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r12 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            int r12 = r12.fondo_tipo     // Catch:{ Exception -> 0x01f6 }
            r1.tratar_fondo(r2, r11, r12)     // Catch:{ Exception -> 0x01f6 }
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x01f6 }
            java.lang.String r2 = "fondo"
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x01f6 }
            android.widget.ImageView r10 = (android.widget.ImageView) r10     // Catch:{ Exception -> 0x01f6 }
            r1.file_to_iv(r2, r10)     // Catch:{ Exception -> 0x01f6 }
        L_0x0285:
            java.lang.String r1 = "sh_mp"
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r6)
            r0.sh_mp = r1
            java.lang.String r1 = "sh_mc"
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r6)
            r0.sh_mc = r1
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r2 = r0.ind
            r1 = r1[r2]
            boolean r1 = r1.stream
            r0.esStream = r1
            r0.radio_mostrar = r6
            boolean r1 = r0.hay_banner
            if (r1 != 0) goto L_0x02b5
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r2 = r0.ind
            r1 = r1[r2]
            int r1 = r1.radio_mostrar
            r0.radio_mostrar = r1
        L_0x02b5:
            int r1 = r0.radio_mostrar
            r2 = 14
            r10 = 12
            r11 = 4
            r12 = 10
            r13 = 1056964608(0x3f000000, float:0.5)
            r14 = 20
            if (r1 <= 0) goto L_0x04c9
            r1 = 2131363376(0x7f0a0630, float:1.834656E38)
            android.view.View r15 = r0.findViewById(r1)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r0.tv_artist = r15
            r15 = 2131363467(0x7f0a068b, float:1.8346744E38)
            android.view.View r16 = r0.findViewById(r15)
            r8 = r16
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0.tv_song = r8
            android.content.SharedPreferences r8 = r0.sh_mc
            r8.registerOnSharedPreferenceChangeListener(r0)
            android.content.SharedPreferences r8 = r0.sh_mc
            android.content.SharedPreferences$Editor r8 = r8.edit()
            java.lang.String r15 = "t_radio_artist"
            r8.remove(r15)
            java.lang.String r15 = "t_radio_song"
            r8.remove(r15)
            r8.commit()
            stikerwap.appdys.config r8 = r0.globales
            boolean r8 = r8.radio_artist_b
            if (r8 == 0) goto L_0x0305
            android.widget.TextView r8 = r0.tv_artist
            android.graphics.Typeface r15 = r8.getTypeface()
            r8.setTypeface(r15, r5)
        L_0x0305:
            stikerwap.appdys.config r8 = r0.globales
            boolean r8 = r8.radio_song_b
            if (r8 == 0) goto L_0x0314
            android.widget.TextView r8 = r0.tv_song
            android.graphics.Typeface r15 = r8.getTypeface()
            r8.setTypeface(r15, r5)
        L_0x0314:
            stikerwap.appdys.config r8 = r0.globales
            int r8 = r8.radio_artist_size
            if (r8 == 0) goto L_0x0324
            android.widget.TextView r8 = r0.tv_artist
            stikerwap.appdys.config r15 = r0.globales
            int r15 = r15.radio_artist_size
            float r15 = (float) r15
            r8.setTextSize(r7, r15)
        L_0x0324:
            stikerwap.appdys.config r8 = r0.globales
            int r8 = r8.radio_song_size
            if (r8 == 0) goto L_0x0334
            android.widget.TextView r8 = r0.tv_song
            stikerwap.appdys.config r15 = r0.globales
            int r15 = r15.radio_song_size
            float r15 = (float) r15
            r8.setTextSize(r7, r15)
        L_0x0334:
            r8 = 2131362609(0x7f0a0331, float:1.8345003E38)
            android.view.View r15 = r0.findViewById(r8)
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams
            r6 = -2
            r1 = -2
            r8.<init>(r6, r1)
            android.content.res.Resources r1 = r19.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            r6 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 * r6
            float r1 = r1 + r13
            int r1 = (int) r1
            r8.setMargins(r1, r1, r1, r1)
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            if (r1 != r5) goto L_0x0368
            r8.addRule(r12)
            r8.addRule(r2)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x0368:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            r6 = 21
            if (r1 != r7) goto L_0x037a
            r8.addRule(r12)
            r8.addRule(r6)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x037a:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            if (r1 != r9) goto L_0x038c
            r1 = 15
            r8.addRule(r1)
            r8.addRule(r6)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x038c:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            if (r1 != r11) goto L_0x039c
            r8.addRule(r10)
            r8.addRule(r6)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x039c:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            r6 = 5
            if (r1 != r6) goto L_0x03ad
            r8.addRule(r10)
            r8.addRule(r2)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x03ad:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            r6 = 6
            if (r1 != r6) goto L_0x03be
            r8.addRule(r10)
            r8.addRule(r14)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x03be:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            r6 = 7
            if (r1 != r6) goto L_0x03d1
            r1 = 15
            r8.addRule(r1)
            r8.addRule(r14)
            r15.setLayoutParams(r8)
            goto L_0x03e2
        L_0x03d1:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.radio_pos
            r6 = 8
            if (r1 != r6) goto L_0x03e2
            r8.addRule(r12)
            r8.addRule(r14)
            r15.setLayoutParams(r8)
        L_0x03e2:
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.radio_txt_c
            if (r1 == 0) goto L_0x03eb
            r15.setGravity(r5)
        L_0x03eb:
            stikerwap.appdys.config r1 = r0.globales
            java.lang.String r1 = r1.radio_artist_col
            boolean r6 = r1.equals(r4)
            if (r6 == 0) goto L_0x042a
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r6 = r0.ind
            r1 = r1[r6]
            java.lang.String r1 = r1.c1
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0427
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.c1
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x0424
            int r1 = stikerwap.appdys.config.NEGRO
            goto L_0x043a
        L_0x0424:
            int r1 = stikerwap.appdys.config.BLANCO
            goto L_0x043a
        L_0x0427:
            r1 = 0
            r6 = 0
            goto L_0x043c
        L_0x042a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            int r1 = android.graphics.Color.parseColor(r1)
        L_0x043a:
            r6 = r1
            r1 = 1
        L_0x043c:
            if (r1 == 0) goto L_0x0443
            android.widget.TextView r1 = r0.tv_artist
            r1.setTextColor(r6)
        L_0x0443:
            stikerwap.appdys.config r1 = r0.globales
            java.lang.String r1 = r1.radio_song_col
            boolean r6 = r1.equals(r4)
            if (r6 == 0) goto L_0x0482
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r6 = r0.ind
            r1 = r1[r6]
            java.lang.String r1 = r1.c1
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x047f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.c1
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x047c
            int r1 = stikerwap.appdys.config.NEGRO_2
            goto L_0x0492
        L_0x047c:
            int r1 = stikerwap.appdys.config.BLANCO_2
            goto L_0x0492
        L_0x047f:
            r1 = 0
            r6 = 0
            goto L_0x0494
        L_0x0482:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            int r1 = android.graphics.Color.parseColor(r1)
        L_0x0492:
            r6 = r1
            r1 = 1
        L_0x0494:
            if (r1 == 0) goto L_0x049b
            android.widget.TextView r1 = r0.tv_song
            r1.setTextColor(r6)
        L_0x049b:
            int r1 = r0.radio_mostrar
            if (r1 == r5) goto L_0x04a4
            if (r1 != r7) goto L_0x04a2
            goto L_0x04a4
        L_0x04a2:
            r6 = 0
            goto L_0x04af
        L_0x04a4:
            r1 = 2131363376(0x7f0a0630, float:1.834656E38)
            android.view.View r1 = r0.findViewById(r1)
            r6 = 0
            r1.setVisibility(r6)
        L_0x04af:
            int r1 = r0.radio_mostrar
            if (r1 == r5) goto L_0x04b5
            if (r1 != r9) goto L_0x04bf
        L_0x04b5:
            r1 = 2131363467(0x7f0a068b, float:1.8346744E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r6)
        L_0x04bf:
            r1 = 2131362609(0x7f0a0331, float:1.8345003E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r6)
        L_0x04c9:
            boolean r1 = r0.esStream
            if (r1 == 0) goto L_0x04d5
            android.widget.MediaController r1 = new android.widget.MediaController
            r1.<init>(r0, r6)
            r0.mMediaController = r1
            goto L_0x04dc
        L_0x04d5:
            android.widget.MediaController r1 = new android.widget.MediaController
            r1.<init>(r0)
            r0.mMediaController = r1
        L_0x04dc:
            android.widget.MediaController r1 = r0.mMediaController
            r1.setMediaPlayer(r0)
            android.widget.MediaController r1 = r0.mMediaController
            r6 = 2131363121(0x7f0a0531, float:1.8346042E38)
            android.view.View r8 = r0.findViewById(r6)
            r1.setAnchorView(r8)
            android.view.View r1 = r0.findViewById(r6)
            stikerwap.appdys.t_radio$4 r6 = new stikerwap.appdys.t_radio$4
            r6.<init>()
            r1.setOnClickListener(r6)
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.s_mediaplayer_exo> r6 = stikerwap.appdys.s_mediaplayer_exo.class
            r1.<init>(r0, r6)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.url
            java.lang.String r8 = "url"
            r1.putExtra(r8, r6)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.ua
            java.lang.String r8 = "ua"
            r1.putExtra(r8, r6)
            java.lang.String r6 = "accion"
            java.lang.String r8 = "iniciar"
            r1.putExtra(r6, r8)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            int r6 = r6.id
            java.lang.String r8 = "idsecc"
            r1.putExtra(r8, r6)
            java.lang.String r6 = "radio_mostrar"
            int r8 = r0.radio_mostrar
            r1.putExtra(r6, r8)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.titulo
            java.lang.String r8 = "secc_tit"
            r1.putExtra(r8, r6)
            java.lang.String r6 = "esStream"
            boolean r8 = r0.esStream
            r1.putExtra(r6, r8)
            r0.startService(r1)
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.chatsecc_en_radio
            r0.con_chat = r1
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r6 = r0.ind
            r1 = r1[r6]
            java.lang.String r1 = r1.c1
            r0.c1 = r1
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r6 = r0.ind
            r1 = r1[r6]
            java.lang.String r1 = r1.c2
            r0.c2 = r1
            boolean r1 = r0.con_chat
            if (r1 == 0) goto L_0x0964
            r0.logineado_ok = r5
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.chatsecc_p_fnac
            stikerwap.appdys.config r6 = r0.globales
            int r6 = r6.chatsecc_p_sexo
            stikerwap.appdys.config r8 = r0.globales
            int r8 = r8.chatsecc_p_descr
            stikerwap.appdys.config r15 = r0.globales
            int r15 = r15.chatsecc_fotos_perfil
            r0.fotos_perfil = r15
            android.content.SharedPreferences r15 = r0.sh
            java.lang.String r14 = "nick"
            java.lang.String r14 = r15.getString(r14, r4)
            boolean r14 = r14.equals(r4)
            if (r14 != 0) goto L_0x0603
            stikerwap.appdys.config r14 = r0.globales
            int r14 = r14.fb_modo
            if (r14 != r9) goto L_0x05ac
            android.content.SharedPreferences r14 = r0.sh
            java.lang.String r15 = "email_confirmado"
            r13 = 0
            boolean r14 = r14.getBoolean(r15, r13)
            if (r14 != 0) goto L_0x05ac
            goto L_0x0603
        L_0x05ac:
            int r13 = r0.fotos_perfil
            if (r13 != r7) goto L_0x05bf
            stikerwap.appdys.config r13 = r0.globales
            java.io.File r13 = r13.getTempFile(r0, r5)
            boolean r13 = r13.exists()
            if (r13 == 0) goto L_0x05bd
            goto L_0x05bf
        L_0x05bd:
            r1 = 0
            goto L_0x0600
        L_0x05bf:
            if (r1 != r7) goto L_0x05e1
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r13 = "fnac_d"
            r14 = 0
            int r1 = r1.getInt(r13, r14)
            if (r1 == 0) goto L_0x05bd
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r13 = "fnac_m"
            int r1 = r1.getInt(r13, r14)
            if (r1 == 0) goto L_0x05bd
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r13 = "fnac_a"
            int r1 = r1.getInt(r13, r14)
            if (r1 == 0) goto L_0x05bd
            goto L_0x05e2
        L_0x05e1:
            r14 = 0
        L_0x05e2:
            if (r6 != r7) goto L_0x05ef
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r6 = "sexo"
            int r1 = r1.getInt(r6, r14)
            if (r1 == 0) goto L_0x05bd
        L_0x05ef:
            if (r8 != r7) goto L_0x0606
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r6 = "descr"
            java.lang.String r1 = r1.getString(r6, r4)
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0606
            goto L_0x05bd
        L_0x0600:
            r0.logineado_ok = r1
            goto L_0x0606
        L_0x0603:
            r1 = 0
            r0.logineado_ok = r1
        L_0x0606:
            android.view.WindowManager r1 = r19.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>()
            r1.getSize(r6)
            int r1 = r6.y
            r0.altura = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.c1
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            r0.c1_esclaro = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r8 = r0.ind
            r6 = r6[r8]
            java.lang.String r6 = r6.c2
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            r0.c2_esclaro = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.bubbles
            if (r1 <= 0) goto L_0x067b
            r0.c_fondotxt_esclaro = r5
            stikerwap.appdys.config r1 = r0.globales
            java.lang.String r1 = r1.c_bubbles
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x067f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            stikerwap.appdys.config r6 = r0.globales
            java.lang.String r6 = r6.c_bubbles
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            r0.c_fondotxt_esclaro = r1
            goto L_0x067f
        L_0x067b:
            boolean r1 = r0.c1_esclaro
            r0.c_fondotxt_esclaro = r1
        L_0x067f:
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x0691 }
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a     // Catch:{ Exception -> 0x0691 }
            int r6 = r0.ind     // Catch:{ Exception -> 0x0691 }
            r1 = r1[r6]     // Catch:{ Exception -> 0x0691 }
            stikerwap.appdys.Tema[] r1 = r1.temas_a     // Catch:{ Exception -> 0x0691 }
            r6 = 0
            r1 = r1[r6]     // Catch:{ Exception -> 0x0691 }
            int r1 = r1.id     // Catch:{ Exception -> 0x0691 }
            r0.idtema = r1     // Catch:{ Exception -> 0x0691 }
            goto L_0x0694
        L_0x0691:
            r1 = 0
            r0.idtema = r1
        L_0x0694:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.chatsecc_fotos_perfil
            r0.fotos_perfil = r1
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.chatsecc_privados
            r0.privados = r1
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.chatsecc_coments
            r0.coments = r1
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.chatsecc_galeria
            r0.galeria = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.chatsecc_p_fnac
            r0.fnac = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.chatsecc_p_sexo
            r0.sexo = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.chatsecc_p_dist
            r0.dist = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.chatsecc_p_descr
            r0.descr = r1
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.WindowManager r6 = r19.getWindowManager()
            android.view.Display r6 = r6.getDefaultDisplay()
            r6.getMetrics(r1)
            int r6 = r1.widthPixels
            r0.width_global = r6
            int r1 = r1.heightPixels
            r0.height_global = r1
            int r1 = r0.width_global
            android.content.res.Resources r6 = r19.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 != r7) goto L_0x06ec
            int r1 = r0.height_global
        L_0x06ec:
            int r6 = r1 / 2
            double r13 = (double) r6
            r17 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r17
            int r6 = (int) r13
            r0.width_frase = r6
            double r13 = (double) r1
            r17 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r17
            int r1 = (int) r13
            r0.width_ad = r1
            int r1 = r0.fotos_perfil
            if (r1 <= 0) goto L_0x071e
            r1 = 50
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r1)
            int r6 = r0.width_frase
            int r6 = r6 - r1
            r0.width_frase = r6
            int r6 = r0.width_ad
            int r6 = r6 - r1
            r0.width_ad = r6
        L_0x071e:
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r11)
            r0.marge_mateix = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.bubbles
            if (r1 != r5) goto L_0x0731
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r2)
            r0.marge_mateix = r1
            goto L_0x0758
        L_0x0731:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.bubbles
            if (r1 != r7) goto L_0x073f
            r1 = 5
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r1)
            r0.marge_mateix = r1
            goto L_0x0758
        L_0x073f:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.bubbles
            if (r1 != r9) goto L_0x074c
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r10)
            r0.marge_mateix = r1
            goto L_0x0758
        L_0x074c:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.bubbles
            if (r1 != r11) goto L_0x0758
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r11)
            r0.marge_mateix = r1
        L_0x0758:
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r9)
            r0.dp3 = r1
            int r1 = stikerwap.appdys.config.dp_to_px(r0, r12)
            r0.dp10 = r1
            stikerwap.appdys.config r1 = r0.globales
            boolean r1 = r1.emojis
            r2 = 2131361986(0x7f0a00c2, float:1.834374E38)
            if (r1 != 0) goto L_0x0776
            android.view.View r1 = r0.findViewById(r2)
            r6 = 8
            r1.setVisibility(r6)
        L_0x0776:
            android.content.res.Resources r1 = r19.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            r6 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r6
            r6 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r6
            int r1 = (int) r1
            r0.WIDTH_IMGS = r1
            android.content.res.Resources r1 = r19.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            r7 = 1077936128(0x40400000, float:3.0)
            float r1 = r1 * r7
            float r1 = r1 + r6
            int r1 = (int) r1
            r0.TV_PADDING = r1
            android.content.res.Resources r1 = r19.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            float r1 = r1 * r7
            float r1 = r1 + r6
            int r1 = (int) r1
            r0.TV_MARGIN = r1
            java.io.File r1 = r19.getFilesDir()
            r0.path = r1
            r1 = 0
            r0.nfrases = r1
            r0.dia_act = r4
            r0.idusu_act = r4
            r0.hayfrasedeotrousu = r1
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r6 = "idusu"
            r7 = 0
            long r6 = r1.getLong(r6, r7)
            r0.idusu = r6
            android.content.SharedPreferences r1 = r0.sh
            java.lang.String r6 = "cod"
            java.lang.String r1 = r1.getString(r6, r4)
            r0.codigo = r1
            r1 = 2131362646(0x7f0a0356, float:1.8345078E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.llchat = r1
            r1 = 2131362993(0x7f0a04b1, float:1.8345782E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb_enviando = r1
            java.lang.String r1 = r0.c1
            boolean r1 = r1.equals(r4)
            r6 = 2131362028(0x7f0a00ec, float:1.8343825E38)
            if (r1 != 0) goto L_0x087c
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 20
            if (r1 <= r7) goto L_0x080b
            android.view.View r1 = r0.findViewById(r6)
            android.widget.EditText r1 = (android.widget.EditText) r1
            boolean r7 = r0.c1_esclaro
            r7 = r7 ^ r5
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = r0.cbtn
            stikerwap.appdys.config.edittext_color(r1, r7, r8)
            goto L_0x0816
        L_0x080b:
            android.view.View r1 = r0.findViewById(r6)
            android.widget.EditText r1 = (android.widget.EditText) r1
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setTextColor(r7)
        L_0x0816:
            boolean r1 = r0.c2_esclaro
            if (r1 != 0) goto L_0x0839
            android.view.View r1 = r0.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.content.res.Resources r7 = r19.getResources()
            r8 = 2131231073(0x7f080161, float:1.8078217E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r8)
            r1.setImageDrawable(r7)
            r1 = 2131362992(0x7f0a04b0, float:1.834578E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r0.pb_enviando = r1
        L_0x0839:
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 20
            if (r1 <= r7) goto L_0x0846
            android.widget.ProgressBar r1 = r0.pb_enviando
            java.lang.String r7 = r0.cbtn
            stikerwap.appdys.config.progress_color(r1, r7)
        L_0x0846:
            android.content.res.Resources r1 = r19.getResources()
            r7 = 2131230929(0x7f0800d1, float:1.8077925E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r7)
            java.lang.String r7 = r0.cbtn
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x0870
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = r0.cbtn
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r3, r4)
        L_0x0870:
            r3 = 2131361987(0x7f0a00c3, float:1.8343742E38)
            android.view.View r3 = r0.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setImageDrawable(r1)
        L_0x087c:
            android.view.View r1 = r0.findViewById(r2)
            r1.setOnClickListener(r0)
            r1 = 2131361987(0x7f0a00c3, float:1.8343742E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setOnClickListener(r0)
            android.view.View r1 = r0.findViewById(r6)
            r1.setOnKeyListener(r0)
            r1 = 2131363117(0x7f0a052d, float:1.8346034E38)
            android.view.View r1 = r0.findViewById(r1)
            stikerwap.appdys.t_radio$5 r2 = new stikerwap.appdys.t_radio$5
            r2.<init>()
            r1.setOnClickListener(r2)
            r1 = 2131361981(0x7f0a00bd, float:1.834373E38)
            android.view.View r1 = r0.findViewById(r1)
            stikerwap.appdys.t_radio$6 r2 = new stikerwap.appdys.t_radio$6
            r2.<init>()
            r1.setOnClickListener(r2)
            r1 = 2131361981(0x7f0a00bd, float:1.834373E38)
            android.view.View r1 = r0.findViewById(r1)
            r2 = 0
            r1.setVisibility(r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.fotos_m = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.acargar_m = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.intentados_m = r1
            r1 = 0
            r0.bm_propia = r1
            boolean r1 = r0.c_fondotxt_esclaro     // Catch:{ OutOfMemoryError -> 0x08f5 }
            if (r1 == 0) goto L_0x08e7
            android.content.res.Resources r1 = r19.getResources()     // Catch:{ OutOfMemoryError -> 0x08f5 }
            r2 = 2131231691(0x7f0803cb, float:1.807947E38)
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)     // Catch:{ OutOfMemoryError -> 0x08f5 }
            r0.bm_propia = r1     // Catch:{ OutOfMemoryError -> 0x08f5 }
            goto L_0x08f6
        L_0x08e7:
            android.content.res.Resources r1 = r19.getResources()     // Catch:{ OutOfMemoryError -> 0x08f5 }
            r2 = 2131231689(0x7f0803c9, float:1.8079466E38)
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)     // Catch:{ OutOfMemoryError -> 0x08f5 }
            r0.bm_propia = r1     // Catch:{ OutOfMemoryError -> 0x08f5 }
            goto L_0x08f6
        L_0x08f5:
        L_0x08f6:
            int r1 = r0.fotos_perfil
            if (r1 <= 0) goto L_0x094d
            stikerwap.appdys.config r1 = r0.globales
            java.io.File r1 = r1.getTempFile(r0, r5)
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x094c }
            r2.<init>()     // Catch:{ Exception -> 0x094c }
            r2.inJustDecodeBounds = r5     // Catch:{ Exception -> 0x094c }
            java.lang.String r3 = r1.getPath()     // Catch:{ Exception -> 0x094c }
            android.graphics.BitmapFactory.decodeFile(r3, r2)     // Catch:{ Exception -> 0x094c }
            int r3 = r2.outWidth     // Catch:{ Exception -> 0x094c }
            int r3 = r2.outWidth     // Catch:{ Exception -> 0x094c }
            int r2 = r2.outHeight     // Catch:{ Exception -> 0x094c }
            r4 = 75
            r6 = 100
            if (r3 > r4) goto L_0x091d
            if (r2 > r6) goto L_0x091d
            goto L_0x091e
        L_0x091d:
            r5 = 0
        L_0x091e:
            if (r5 != 0) goto L_0x093d
            int r2 = stikerwap.appdys.config.calculateNewWidth(r3, r2, r4, r6)     // Catch:{ Exception -> 0x094c }
            float r3 = (float) r3     // Catch:{ Exception -> 0x094c }
            float r2 = (float) r2     // Catch:{ Exception -> 0x094c }
            float r3 = r3 / r2
            int r2 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x094c }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x094c }
            r3.<init>()     // Catch:{ Exception -> 0x094c }
            r3.inSampleSize = r2     // Catch:{ Exception -> 0x094c }
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x094c }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1, r3)     // Catch:{ Exception -> 0x094c }
            r0.bm_propia = r1     // Catch:{ Exception -> 0x094c }
            goto L_0x094d
        L_0x093d:
            android.content.ContentResolver r2 = r19.getContentResolver()     // Catch:{ Exception -> 0x094c }
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ Exception -> 0x094c }
            android.graphics.Bitmap r1 = android.provider.MediaStore.Images.Media.getBitmap(r2, r1)     // Catch:{ Exception -> 0x094c }
            r0.bm_propia = r1     // Catch:{ Exception -> 0x094c }
            goto L_0x094d
        L_0x094c:
        L_0x094d:
            r1 = 0
            r0.idfrase_masantigua_glob = r1
            boolean r2 = r0.logineado_ok
            if (r2 == 0) goto L_0x0964
            stikerwap.appdys.t_radio$cargar_ultimas r2 = new stikerwap.appdys.t_radio$cargar_ultimas
            java.lang.String r3 = "0"
            int r4 = r0.idfrase_masantigua_glob
            java.lang.String r5 = "0"
            r2.<init>(r5, r3, r4)
            java.lang.String[] r1 = new java.lang.String[r1]
            r2.execute(r1)
        L_0x0964:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_radio.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public void ocultar_banner() {
        if (((LinearLayout) findViewById(R.id.ll_ad)).getChildCount() > 0) {
            findViewById(R.id.ll_ad).setVisibility(8);
        }
        View findViewWithTag = findViewById(R.id.ll_princ).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void cerrar_chat() {
        Anuncios anuncios;
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
        } catch (Exception unused) {
        }
        findViewById(R.id.sv_chat).setVisibility(8);
        MediaController mediaController = this.mMediaController;
        if (mediaController != null) {
            mediaController.show(0);
        }
        if (this.hay_banner) {
            findViewById(R.id.ll_ad_rad).setVisibility(0);
        } else if (!this.globales.banners_enchats && (anuncios = this.anun) != null && anuncios.adView != null) {
            if (((LinearLayout) findViewById(R.id.ll_ad)).getChildCount() > 0) {
                findViewById(R.id.ll_ad).setVisibility(0);
            }
            View findViewWithTag = findViewById(R.id.ll_princ).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(0);
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        f_enviar(true);
        return true;
    }

    private void f_enviar(boolean z) {
        String trim = ((TextView) findViewById(R.id.c_mensaje)).getText().toString().replace("@", "").trim();
        if (!trim.equals("")) {
            if (z && this.altura < 600) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
            }
            ((EditText) findViewById(R.id.c_mensaje)).setText("");
            SharedPreferences.Editor edit = this.sh.edit();
            edit.putString("f2_id", this.idusu + "");
            edit.putString("f2_frase", trim);
            edit.putString("f2_fcrea", new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
            edit.putString("f2_b64", "");
            edit.putString("f2_idfrase", "0");
            edit.putString("f2_idtema", this.idtema + "");
            edit.putString("f2_vfoto", "0");
            edit.putBoolean("f2_ultimas", false);
            edit.putString("f2_ts", System.currentTimeMillis() + "");
            edit.commit();
            this.globales.toca_int_chat(this);
            config config = this.globales;
            SharedPreferences sharedPreferences = this.sh;
            config.toca_inchat(this, sharedPreferences, this.idtema + "");
            this.spool.add(trim);
            enviar enviar2 = this.env;
            if (enviar2 == null || enviar2.getStatus() != AsyncTask.Status.RUNNING) {
                enviar enviar3 = new enviar();
                this.env = enviar3;
                enviar3.execute(new String[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_fecha() {
        boolean z;
        Date date;
        if (!this.dia_act.equals("")) {
            try {
                date = new SimpleDateFormat("ddMMyy").parse(this.dia_act);
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                date = null;
                z = false;
            }
            if (z) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i = this.TV_MARGIN;
                layoutParams.setMargins(0, i * 8, 0, i * 2);
                layoutParams.gravity = 1;
                textView.setLayoutParams(layoutParams);
                textView.setGravity(1);
                textView.setBackgroundResource(R.drawable.fondo_rounded_fecha);
                textView.setTextSize(1, 13.0f);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextColor(-12303292);
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(date);
                if (instance2.get(1) == instance.get(1) && instance2.get(6) == instance.get(6)) {
                    textView.setText(getResources().getString(R.string.hoy));
                } else {
                    textView.setText(DateFormat.getDateFormat(this).format(date));
                }
                this.llchat.addView(textView, 0);
            }
        }
    }

    private class enviar extends AsyncTask<String, Void, String> {
        private enviar() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            Iterator<String> it = t_radio.this.spool.iterator();
            while (it.hasNext()) {
                try {
                    it.remove();
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                    HttpPost httpPost = new HttpPost(config.PROTOC_GEN + "gcm." + config.DOM_EDROID + "/enviar_mensaje.php");
                    MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                    multipartEntity.addPart("v", new StringBody("4"));
                    multipartEntity.addPart("idapp", new StringBody("3008836"));
                    multipartEntity.addPart("idusu", new StringBody(t_radio.this.idusu + ""));
                    multipartEntity.addPart("c", new StringBody(t_radio.this.codigo));
                    multipartEntity.addPart("idtema", new StringBody(t_radio.this.idtema + ""));
                    multipartEntity.addPart("idusudest", new StringBody("0"));
                    multipartEntity.addPart("externo", new StringBody("0"));
                    multipartEntity.addPart("m", new StringBody(URLEncoder.encode(it.next(), "UTF-8")));
                    httpPost.setEntity(multipartEntity);
                    httpPost.setHeader("User-Agent", "Android Vinebre Software");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        }
                    }
                } catch (Exception unused) {
                    return "KO";
                }
            }
            return "OK";
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.equals("OK") && t_radio.this.spool.size() > 0) {
                t_radio t_radio = t_radio.this;
                t_radio.env = new enviar();
                t_radio.this.env.execute(new String[0]);
            }
        }
    }

    private class obtener_foto extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idusu_acargar;
        String vfoto_acargar;

        private obtener_foto() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_radio.this.acargar_m.equals("")) {
                cancel(false);
                return;
            }
            try {
                this.idusu_acargar = (String) t_radio.this.acargar_m.keySet().toArray()[0];
            } catch (Exception unused) {
                cancel(false);
            }
            if (this.idusu_acargar != null) {
                this.vfoto_acargar = t_radio.this.acargar_m.get(this.idusu_acargar);
                t_radio.this.intentados_m.put(this.idusu_acargar, t_radio.this.acargar_m.get(this.idusu_acargar));
                t_radio.this.acargar_m.remove(this.idusu_acargar);
            }
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
                if (r0 == 0) goto L_0x0088
                java.lang.String r0 = r4.vfoto_acargar
                if (r0 != 0) goto L_0x000d
                goto L_0x0088
            L_0x000d:
                java.net.URL r0 = new java.net.URL     // Catch:{  }
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
                java.lang.String r3 = r4.vfoto_acargar     // Catch:{  }
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
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
                r4.bmImg = r3     // Catch:{  }
                r2.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                java.io.File r0 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_radio r2 = stikerwap.appdys.t_radio.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r5)     // Catch:{  }
                java.lang.String r5 = r4.idusu_acargar     // Catch:{  }
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = ".jpg"
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = r3.toString()     // Catch:{  }
                r0.<init>(r2, r5)     // Catch:{  }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x0088 }
                r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x0088 }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x0088 }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x0088 }
                r3 = 70
                r0.compress(r2, r3, r5)     // Catch:{ MalformedURLException -> 0x0088 }
                java.lang.String r5 = "1"
                return r5
            L_0x0088:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_radio.obtener_foto.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (t_radio.this.fotos_m != null) {
                if (str == "1") {
                    t_radio.this.fotos_m.put(this.idusu_acargar, this.bmImg);
                    SharedPreferences.Editor edit = t_radio.this.sh.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, t_radio.this.intentados_m.get(this.idusu_acargar));
                    edit.commit();
                }
                int childCount = t_radio.this.llchat.getChildCount();
                int i = 0;
                while (i < childCount) {
                    try {
                        String str2 = (String) t_radio.this.llchat.getChildAt(i).getTag();
                        if (str2 != null && str2.equals(this.idusu_acargar)) {
                            t_radio.this.llchat.getChildAt(i).findViewById(R.id.pb_foto).setVisibility(8);
                            t_radio.this.llchat.getChildAt(i).findViewById(R.id.pb_foto_inv).setVisibility(8);
                            if (str == "1") {
                                ((ImageView) t_radio.this.llchat.getChildAt(i).findViewById(R.id.iv_avatar_f)).setImageBitmap(config.getCircularBitmapWithWhiteBorder(this.bmImg, 0));
                            }
                        }
                        i++;
                    } catch (Exception unused) {
                    }
                }
                if (!t_radio.this.acargar_m.equals("")) {
                    t_radio t_radio = t_radio.this;
                    t_radio.o_f = new obtener_foto();
                    t_radio.this.o_f.execute(new String[0]);
                }
            }
        }
    }

    private class cargar_ultimas extends AsyncTask<String, Void, String> {
        private String idconversante;
        private int idfrase_masantigua;
        private String idprivado_finalizar;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        public cargar_ultimas(String str, String str2, int i) {
            this.idprivado_finalizar = str;
            this.idconversante = str2;
            this.idfrase_masantigua = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
                r0.<init>()     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "/srv/ultimas_frases.php?ver=1&idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_radio r1 = stikerwap.appdys.t_radio.this     // Catch:{ Exception -> 0x00b1 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_radio r1 = stikerwap.appdys.t_radio.this     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idtema="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_radio r1 = stikerwap.appdys.t_radio.this     // Catch:{ Exception -> 0x00b1 }
                int r1 = r1.idtema     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idf="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                int r1 = r5.idfrase_masantigua     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idprivado_finalizar=0&idconversante="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = r5.idconversante     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&externo=0"
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b1 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b1 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00b1 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x00b1 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b1 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            L_0x0083:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r2 == 0) goto L_0x009e
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                goto L_0x0083
            L_0x009e:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r0 == 0) goto L_0x00a7
                r0.disconnect()
            L_0x00a7:
                return r6
            L_0x00a8:
                r6 = move-exception
                goto L_0x00b9
            L_0x00aa:
                r6 = r0
                goto L_0x00b1
            L_0x00ac:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00b9
            L_0x00b1:
                java.lang.String r0 = "ANDROID:KO"
                if (r6 == 0) goto L_0x00b8
                r6.disconnect()
            L_0x00b8:
                return r0
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                goto L_0x00c0
            L_0x00bf:
                throw r6
            L_0x00c0:
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_radio.cargar_ultimas.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            boolean z;
            int i;
            String str3;
            String str4 = str;
            if (this.idfrase_masantigua != -1) {
                if (str4.indexOf("ANDROID:OK") != -1 || str4.indexOf("ANDROID:KO") != -1 || str4.indexOf("ANDROID:PERFILKO") != -1) {
                    if (str4.indexOf("ANDROID:PERFILKO") != -1) {
                        final AlertDialog create = new AlertDialog.Builder(t_radio.this).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).setMessage(R.string.perfil_desactivado).create();
                        if (!t_radio.this.cbtn.equals("")) {
                            create.setOnShowListener(new DialogInterface.OnShowListener() {
                                public void onShow(DialogInterface dialogInterface) {
                                    Button button = create.getButton(-1);
                                    button.setTextColor(Color.parseColor("#" + t_radio.this.cbtn));
                                    Button button2 = create.getButton(-2);
                                    button2.setTextColor(Color.parseColor("#" + t_radio.this.cbtn));
                                }
                            });
                        }
                        create.show();
                        try {
                            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                        } catch (Exception unused) {
                        }
                    } else if (str4.indexOf("ANDROID:OK") != -1) {
                        int indexOf = str4.indexOf("@XYY53@");
                        String str5 = "";
                        String str6 = str5;
                        boolean z2 = false;
                        for (int i2 = -1; indexOf != i2; i2 = -1) {
                            int indexOf2 = str4.indexOf("@", indexOf + 1) + 1;
                            int indexOf3 = str4.indexOf("@", indexOf2);
                            String substring = str4.substring(indexOf2, indexOf3);
                            t_radio.this.idfrase_masantigua_glob = Integer.parseInt(substring);
                            int i3 = indexOf3 + 1;
                            int indexOf4 = str4.indexOf("@", i3);
                            String substring2 = str4.substring(i3, indexOf4);
                            int i4 = indexOf4 + 1;
                            int indexOf5 = str4.indexOf("@", i4);
                            String substring3 = str4.substring(i4, indexOf5);
                            int i5 = indexOf5 + 1;
                            int indexOf6 = str4.indexOf("@", i5);
                            String substring4 = str4.substring(i5, indexOf6);
                            int i6 = indexOf6 + 1;
                            int indexOf7 = str4.indexOf("@", i6);
                            String substring5 = str4.substring(i6, indexOf7);
                            int i7 = indexOf7 + 1;
                            String str7 = substring5;
                            int indexOf8 = str4.indexOf("@", i7);
                            String substring6 = str4.substring(i7, indexOf8);
                            int i8 = indexOf8 + 1;
                            String str8 = substring6;
                            int indexOf9 = str4.indexOf("@", i8);
                            String substring7 = str4.substring(i8, indexOf9);
                            int i9 = indexOf9 + 1;
                            String str9 = substring7;
                            int indexOf10 = str4.indexOf("@", i9);
                            String substring8 = str4.substring(i9, indexOf10);
                            int i10 = indexOf10 + 1;
                            String str10 = substring8;
                            int indexOf11 = str4.indexOf("@", i10);
                            String substring9 = str4.substring(i10, indexOf11);
                            int i11 = indexOf11 + 1;
                            String str11 = substring9;
                            int indexOf12 = str4.indexOf("@", i11);
                            String substring10 = str4.substring(i11, indexOf12);
                            int i12 = indexOf12 + 1;
                            String str12 = substring10;
                            int indexOf13 = str4.indexOf("@", i12);
                            String substring11 = str4.substring(i12, indexOf13);
                            int i13 = indexOf13 + 1;
                            String str13 = substring11;
                            int indexOf14 = str4.indexOf("@", i13);
                            String substring12 = str4.substring(i13, indexOf14);
                            int i14 = indexOf14 + 1;
                            int indexOf15 = str4.indexOf("@", i14);
                            String substring13 = str4.substring(i14, indexOf15);
                            if (str5.equals("") || substring4.equals("") || !str5.equals(substring4) || str6.equals("") || substring2.equals("") || !str6.equals(substring2)) {
                                int indexOf16 = str4.indexOf("@XYY53@", indexOf15);
                                if (indexOf16 != -1) {
                                    int indexOf17 = str4.indexOf("@", str4.indexOf("@", indexOf16 + 1) + 1) + 1;
                                    str2 = str4.substring(indexOf17, str4.indexOf("@", indexOf17));
                                } else {
                                    str2 = "";
                                }
                                if (z2 || str4.indexOf("ZXRT4@1@") != -1) {
                                    z = z2;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    z = z2;
                                    sb.append(t_radio.this.idusu);
                                    sb.append("");
                                    if (substring2.equals(sb.toString())) {
                                        int i15 = indexOf15;
                                        while (true) {
                                            int indexOf18 = str4.indexOf("@XYY53@", i15);
                                            if (indexOf18 != -1) {
                                                int indexOf19 = str4.indexOf("@", str4.indexOf("@", indexOf18 + 1) + 1) + 1;
                                                i = str4.indexOf("@", indexOf19);
                                                str3 = str4.substring(indexOf19, i);
                                            } else {
                                                i = i15;
                                                str3 = "";
                                            }
                                            if (str3.equals("")) {
                                                z2 = true;
                                                break;
                                            } else if (!str3.equals(substring2)) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i15 = i;
                                            }
                                        }
                                        SharedPreferences.Editor edit = t_radio.this.sh.edit();
                                        edit.putString("f2_idfrase", substring);
                                        edit.putString("f2_id", substring2);
                                        edit.putString("f2_idusu_prev", str2);
                                        edit.putBoolean("f2_mateixusu_hastafinal", z2);
                                        edit.putString("f2_nombre", substring3);
                                        edit.putString("f2_privados", str8);
                                        edit.putString("f2_frase", substring4);
                                        edit.putString("f2_fcrea", config.convertir_fecha(str9));
                                        edit.putString("f2_b64", "");
                                        edit.putString("f2_tipo", substring13);
                                        edit.putString("f2_b64_th", "");
                                        edit.putString("f2_idvideo", "");
                                        edit.putString("f2_formato", "");
                                        edit.putString("f2_idtema", t_radio.this.idtema + "");
                                        edit.putString("f2_vfoto", str7);
                                        edit.putString("f2_fnac_d", str10);
                                        edit.putString("f2_fnac_m", str11);
                                        edit.putString("f2_fnac_a", str12);
                                        edit.putString("f2_sexo", str13);
                                        edit.putString("f2_coments", substring12);
                                        edit.putBoolean("f2_ultimas", true);
                                        edit.putString("f2_ts", System.currentTimeMillis() + "");
                                        edit.commit();
                                        str6 = substring2;
                                        str5 = substring4;
                                    }
                                }
                                z2 = z;
                                SharedPreferences.Editor edit2 = t_radio.this.sh.edit();
                                edit2.putString("f2_idfrase", substring);
                                edit2.putString("f2_id", substring2);
                                edit2.putString("f2_idusu_prev", str2);
                                edit2.putBoolean("f2_mateixusu_hastafinal", z2);
                                edit2.putString("f2_nombre", substring3);
                                edit2.putString("f2_privados", str8);
                                edit2.putString("f2_frase", substring4);
                                edit2.putString("f2_fcrea", config.convertir_fecha(str9));
                                edit2.putString("f2_b64", "");
                                edit2.putString("f2_tipo", substring13);
                                edit2.putString("f2_b64_th", "");
                                edit2.putString("f2_idvideo", "");
                                edit2.putString("f2_formato", "");
                                edit2.putString("f2_idtema", t_radio.this.idtema + "");
                                edit2.putString("f2_vfoto", str7);
                                edit2.putString("f2_fnac_d", str10);
                                edit2.putString("f2_fnac_m", str11);
                                edit2.putString("f2_fnac_a", str12);
                                edit2.putString("f2_sexo", str13);
                                edit2.putString("f2_coments", substring12);
                                edit2.putBoolean("f2_ultimas", true);
                                edit2.putString("f2_ts", System.currentTimeMillis() + "");
                                edit2.commit();
                                str6 = substring2;
                                str5 = substring4;
                            }
                            indexOf = str4.indexOf("@XYY53@", indexOf15);
                        }
                        if (str4.indexOf("ZXRT4@1@") == -1) {
                            t_radio.this.mostrar_fecha();
                        }
                    }
                }
            }
        }
    }

    public void posar_banner() {
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            ArrayList arrayList = new ArrayList();
            if (!this.globales.admob_radio_cod.equals("")) {
                arrayList.add(1);
            }
            if (!this.globales.appnext_radio_cod.equals("") && this.globales.wortise_radio_cod.equals("")) {
                arrayList.add(2);
            }
            if (!this.globales.fb_radio_cod.equals("") && getResources().getConfiguration().orientation == 1) {
                arrayList.add(3);
            }
            if (!this.globales.st_radio_cod.equals("")) {
                arrayList.add(4);
            }
            if (!this.globales.is_radio_cod.equals("")) {
                arrayList.add(5);
            }
            if (!this.globales.wortise_radio_cod.equals("")) {
                arrayList.add(6);
            }
            if (!arrayList.isEmpty()) {
                int intValue = ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue();
                final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_ad_rad);
                linearLayout.removeAllViews();
                if (intValue == 1) {
                    this.admob_rad = new AdView(this);
                    if (getResources().getConfiguration().orientation == 2) {
                        this.admob_rad.setAdSize(AdSize.LARGE_BANNER);
                    } else {
                        this.admob_rad.setAdSize(AdSize.MEDIUM_RECTANGLE);
                    }
                    this.admob_rad.setAdUnitId(this.globales.admob_radio_cod);
                    linearLayout.addView(this.admob_rad);
                    if (!((DrawerLayout) findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                        linearLayout.setVisibility(0);
                    }
                    this.admob_rad.loadAd(new AdRequest.Builder().build());
                } else if (intValue == 2) {
                    BannerView bannerView = new BannerView(this);
                    this.appnext_rad = bannerView;
                    bannerView.setPlacementId(this.globales.appnext_radio_cod);
                    if (getResources().getConfiguration().orientation == 2) {
                        this.appnext_rad.setBannerSize(BannerSize.LARGE_BANNER);
                    } else {
                        this.appnext_rad.setBannerSize(BannerSize.MEDIUM_RECTANGLE);
                    }
                    linearLayout.addView(this.appnext_rad);
                    if (!((DrawerLayout) findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                        linearLayout.setVisibility(0);
                    }
                    BannerAdRequest bannerAdRequest = new BannerAdRequest();
                    bannerAdRequest.setMute(false).setCreativeType("static");
                    this.appnext_rad.loadAd(bannerAdRequest);
                } else if (intValue == 3) {
                    com.facebook.ads.AdView adView = new com.facebook.ads.AdView((Context) this, this.globales.fb_radio_cod, com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                    this.fb_rad = adView;
                    linearLayout.addView(adView);
                    if (!((DrawerLayout) findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                        linearLayout.setVisibility(0);
                    }
                    this.fb_rad.loadAd();
                } else if (intValue == 4) {
                    Mrec mrec = new Mrec((Activity) this);
                    mrec.setAdTag("AUDIO SECTION");
                    linearLayout.addView(mrec);
                    if (!((DrawerLayout) findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                        linearLayout.setVisibility(0);
                    }
                } else if (intValue == 5) {
                    if (this.globales.isBanner_global != null) {
                        IronSource.destroyBanner(this.globales.isBanner_global);
                    }
                    this.globales.isBanner_global = IronSource.createBanner(this, ISBannerSize.RECTANGLE);
                    linearLayout.addView(this.globales.isBanner_global);
                    if (!((DrawerLayout) findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                        linearLayout.setVisibility(0);
                    }
                    IronSource.loadBanner(this.globales.isBanner_global);
                } else if (intValue == 6) {
                    BannerAd bannerAd = new BannerAd(this);
                    this.adView_nat_w = bannerAd;
                    bannerAd.setAutoRefresh(false);
                    this.adView_nat_w.setAdSize(com.wortise.ads.AdSize.HEIGHT_250);
                    this.adView_nat_w.setAdUnitId(this.globales.wortise_radio_cod);
                    if (!this.globales.appnext_radio_cod.equals("")) {
                        this.adView_nat_w.setListener(new BannerAd.Listener() {
                            public void onBannerClicked(BannerAd bannerAd) {
                            }

                            public void onBannerLoaded(BannerAd bannerAd) {
                            }

                            public void onBannerFailed(BannerAd bannerAd, AdError adError) {
                                Log.e("ara", "wortise banner failed:" + adError.toString());
                                t_radio.this.appnext_rad = new BannerView(t_radio.this);
                                t_radio.this.appnext_rad.setPlacementId(t_radio.this.globales.appnext_radio_cod);
                                if (t_radio.this.getResources().getConfiguration().orientation == 2) {
                                    t_radio.this.appnext_rad.setBannerSize(BannerSize.LARGE_BANNER);
                                } else {
                                    t_radio.this.appnext_rad.setBannerSize(BannerSize.MEDIUM_RECTANGLE);
                                }
                                linearLayout.removeAllViews();
                                linearLayout.addView(t_radio.this.appnext_rad);
                                if (!((DrawerLayout) t_radio.this.findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                                    linearLayout.setVisibility(0);
                                }
                                BannerAdRequest bannerAdRequest = new BannerAdRequest();
                                bannerAdRequest.setMute(false).setCreativeType("static");
                                t_radio.this.appnext_rad.loadAd(bannerAdRequest);
                            }
                        });
                    }
                    linearLayout.addView(this.adView_nat_w);
                    if (!((DrawerLayout) findViewById(R.id.drawer_layout)).isDrawerOpen(8388611)) {
                        linearLayout.setVisibility(0);
                    }
                    this.adView_nat_w.loadAd();
                }
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnemotic) {
            new EmojisMenu((EditText) findViewById(R.id.c_mensaje), this).show();
        } else if (view.getId() == R.id.btnenv) {
            f_enviar(false);
        } else if ((view.getId() == R.id.ll_frase_txt || view.getId() == R.id.fl_frase) && ((View) view.getParent()).getTag(R.id.idaux1) != null && !((View) view.getParent()).getTag(R.id.idaux1).equals("0") && !((View) view.getParent()).getTag(R.id.idaux1).equals("1")) {
            View view2 = (View) view.getParent();
            Intent intent = new Intent(this, profile.class);
            intent.putExtra("id", (String) view2.getTag(R.id.idaux1));
            intent.putExtra("privados", (String) view2.getTag(R.id.idaux2));
            intent.putExtra("nombre", (String) view2.getTag(R.id.idaux3));
            intent.putExtra("coments", (String) view2.getTag(R.id.idaux4));
            intent.putExtra("fnac_d", (String) view2.getTag(R.id.idaux5));
            intent.putExtra("fnac_m", (String) view2.getTag(R.id.idaux6));
            intent.putExtra("fnac_a", (String) view2.getTag(R.id.idaux7));
            intent.putExtra("sexo", (String) view2.getTag(R.id.idaux8));
            intent.putExtra("vfoto", (String) view2.getTag(R.id.idaux9));
            intent.putExtra("p_fnac", this.fnac);
            intent.putExtra("p_sexo", this.sexo);
            intent.putExtra("p_descr", this.descr);
            intent.putExtra("p_dist", this.dist);
            intent.putExtra("coments_chat", this.coments);
            intent.putExtra("galeria", this.galeria);
            intent.putExtra("privados_chat", this.privados);
            intent.putExtra("fotos_perfil", this.fotos_perfil);
            intent.putExtra("fotos_chat", this.fotos_chat);
            startActivityForResult(intent, 0);
        } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
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
            this.v_abrir_secc = view;
            if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                abrir_secc(view);
            }
        }
    }

    public void abrir_secc(View view) {
        ResultGetIntent intent = this.globales.getIntent(view, this);
        if (intent != null) {
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
                if (intent.finalizar) {
                    this.es_root = false;
                    if (this.globales.tipomenu != 2) {
                        intent.i.putExtra("es_root", true);
                    }
                    try {
                        startActivity(intent.i);
                    } catch (Exception unused) {
                    }
                } else {
                    startActivityForResult(intent.i, 0);
                }
            }
            if (this.finalizar && !this.buscador_on) {
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config != null && config.onActivityResult_glob(i, i2, intent, this)) || i2 != -1) {
            return;
        }
        if (intent == null || !intent.hasExtra("finalizar")) {
            if (intent != null && intent.hasExtra("idusu_ban")) {
                t_chat.ocultar_frases(this, intent.getStringExtra("idusu_ban"));
            }
        } else if (intent.getExtras().getBoolean("finalizar")) {
            if (!intent.getExtras().getBoolean("finalizar_app")) {
                this.es_root = false;
            }
            setResult(-1, intent);
            finish();
        }
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
        try {
            this.mMediaController.show(0);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0113=Splitter:B:45:0x0113, B:32:0x00e5=Splitter:B:32:0x00e5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSharedPreferenceChanged(final android.content.SharedPreferences r8, java.lang.String r9) {
        /*
            r7 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "f2_idfrase"
            boolean r0 = r8.contains(r0)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = "f2_ts"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0129
            android.content.SharedPreferences r9 = r7.sh
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "ban_"
            r0.<init>(r2)
            java.lang.String r2 = "f2_id"
            java.lang.String r2 = r8.getString(r2, r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            boolean r9 = r9.contains(r0)
            if (r9 != 0) goto L_0x0129
            java.lang.String r9 = "f2_idtema"
            java.lang.String r0 = "0"
            java.lang.String r9 = r8.getString(r9, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r7.idtema
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0129
            boolean r9 = r7.con_chat
            if (r9 == 0) goto L_0x0129
            boolean r9 = r7.logineado_ok
            if (r9 == 0) goto L_0x0129
            stikerwap.appdys.t_radio$8 r9 = new stikerwap.appdys.t_radio$8
            r9.<init>(r8)
            r7.runOnUiThread(r9)
            goto L_0x0129
        L_0x0062:
            java.lang.String r0 = "fondo_v_act"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00b3
            stikerwap.appdys.config r8 = r7.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            int r9 = r7.ind
            r8 = r8[r9]
            int r8 = r8.idfondo
            if (r8 != 0) goto L_0x0129
            stikerwap.appdys.config r8 = r7.globales     // Catch:{ Exception -> 0x0129 }
            r9 = 2131362464(0x7f0a02a0, float:1.834471E38)
            android.view.View r0 = r7.findViewById(r9)     // Catch:{ Exception -> 0x0129 }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x0129 }
            stikerwap.appdys.config r1 = r7.globales     // Catch:{ Exception -> 0x0129 }
            boolean r1 = r1.fondo_margen     // Catch:{ Exception -> 0x0129 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0129 }
            stikerwap.appdys.config r2 = r7.globales     // Catch:{ Exception -> 0x0129 }
            int r2 = r2.fondo_tipo     // Catch:{ Exception -> 0x0129 }
            r8.tratar_fondo(r0, r1, r2)     // Catch:{ Exception -> 0x0129 }
            android.view.View r8 = r7.findViewById(r9)     // Catch:{ Exception -> 0x0129 }
            android.widget.ImageView r8 = (android.widget.ImageView) r8     // Catch:{ Exception -> 0x0129 }
            r0 = 8
            r8.setVisibility(r0)     // Catch:{ Exception -> 0x0129 }
            stikerwap.appdys.config r8 = r7.globales     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "fondo"
            android.view.View r1 = r7.findViewById(r9)     // Catch:{ Exception -> 0x0129 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0129 }
            r8.file_to_iv(r0, r1)     // Catch:{ Exception -> 0x0129 }
            android.view.View r8 = r7.findViewById(r9)     // Catch:{ Exception -> 0x0129 }
            android.widget.ImageView r8 = (android.widget.ImageView) r8     // Catch:{ Exception -> 0x0129 }
            stikerwap.appdys.config.fade_in(r8)     // Catch:{ Exception -> 0x0129 }
            goto L_0x0129
        L_0x00b3:
            java.lang.String r0 = "t_radio_artist"
            boolean r2 = r9.equals(r0)
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = "ISO-8859-1"
            java.lang.String r5 = "Â"
            java.lang.String r6 = "Ã"
            if (r2 == 0) goto L_0x00eb
            java.lang.String r8 = r8.getString(r0, r1)
            boolean r9 = r8.contains(r6)
            if (r9 != 0) goto L_0x00d6
            boolean r9 = r8.contains(r5)
            if (r9 == 0) goto L_0x00e5
        L_0x00d6:
            java.lang.String r9 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x00e1 }
            byte[] r0 = r8.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x00e1 }
            r9.<init>(r0, r3)     // Catch:{ UnsupportedEncodingException -> 0x00e1 }
            r8 = r9
            goto L_0x00e5
        L_0x00e1:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00e5:
            android.widget.TextView r9 = r7.tv_artist     // Catch:{ Exception -> 0x0129 }
            r9.setText(r8)     // Catch:{ Exception -> 0x0129 }
            goto L_0x0129
        L_0x00eb:
            java.lang.String r0 = "t_radio_song"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0119
            java.lang.String r8 = r8.getString(r0, r1)
            boolean r9 = r8.contains(r6)
            if (r9 != 0) goto L_0x0104
            boolean r9 = r8.contains(r5)
            if (r9 == 0) goto L_0x0113
        L_0x0104:
            java.lang.String r9 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x010f }
            byte[] r0 = r8.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x010f }
            r9.<init>(r0, r3)     // Catch:{ UnsupportedEncodingException -> 0x010f }
            r8 = r9
            goto L_0x0113
        L_0x010f:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0113:
            android.widget.TextView r9 = r7.tv_song     // Catch:{ Exception -> 0x0129 }
            r9.setText(r8)     // Catch:{ Exception -> 0x0129 }
            goto L_0x0129
        L_0x0119:
            android.widget.MediaController r8 = r7.mMediaController
            if (r8 == 0) goto L_0x0129
            boolean r8 = r8.isShowing()
            if (r8 == 0) goto L_0x0129
            android.widget.MediaController r8 = r7.mMediaController
            r9 = 0
            r8.show(r9)
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_radio.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public void onPause() {
        Anuncios anuncios;
        Anuncios anuncios2;
        if ((this.finalizar || isFinishing()) && this.globales.radio_apagado == 1) {
            try {
                this.globales.stop_radio();
            } catch (Exception unused) {
            }
        }
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
        this.sh_mc.unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void onResume() {
        SharedPreferences sharedPreferences;
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
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
        if (!(this.radio_mostrar <= 0 || this.tv_artist == null || this.tv_song == null || (sharedPreferences = this.sh_mc) == null)) {
            String string = sharedPreferences.getString("t_radio_artist", "");
            if (string.contains("Ã") || string.contains("Â")) {
                try {
                    string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            this.tv_artist.setText(string);
            String string2 = this.sh_mc.getString("t_radio_song", "");
            if (string2.contains("Ã") || string2.contains("Â")) {
                try {
                    string2 = new String(string2.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            this.tv_song.setText(string2);
        }
        this.sh_mc.registerOnSharedPreferenceChangeListener(this);
        if (this.con_chat && this.logineado_ok) {
            this.sh.registerOnSharedPreferenceChangeListener(this);
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
        AdView adView = this.admob_rad;
        if (adView != null) {
            adView.destroy();
        }
        BannerView bannerView = this.appnext_rad;
        if (bannerView != null) {
            bannerView.destroy();
        }
        com.facebook.ads.AdView adView2 = this.fb_rad;
        if (adView2 != null) {
            adView2.destroy();
        }
        if (this.globales.isBanner_global != null) {
            IronSource.destroyBanner(this.globales.isBanner_global);
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

    public void onConfigurationChanged(Configuration configuration) {
        Anuncios anuncios;
        super.onConfigurationChanged(configuration);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        ((LinearLayout) findViewById(R.id.ll_ad)).removeAllViews();
        Anuncios anuncios2 = this.anun;
        if (!(anuncios2 == null || anuncios2.adView == null)) {
            try {
                this.anun.adView.destroy();
            } catch (Exception unused) {
            }
        }
        Anuncios anuncios3 = this.anun;
        if (!(anuncios3 == null || anuncios3.adView_fb == null)) {
            try {
                this.anun.adView_fb.destroy();
            } catch (Exception unused2) {
            }
        }
        Anuncios anuncios4 = this.anun;
        if (!(anuncios4 == null || anuncios4.wortiseBanner == null)) {
            try {
                this.anun.wortiseBanner.destroy();
            } catch (Exception unused3) {
            }
        }
        if (this.hay_banner) {
            posar_banner();
        } else {
            this.anun = this.globales.mostrar_banner(this, false);
        }
        if (findViewById(R.id.sv_chat).getVisibility() != 0) {
            return;
        }
        if (this.hay_banner) {
            findViewById(R.id.ll_ad_rad).setVisibility(8);
        } else if (!this.globales.banners_enchats && (anuncios = this.anun) != null && anuncios.adView != null) {
            ocultar_banner();
        }
    }

    private class cargarfoto extends AsyncTask<String, Void, Byte> {
        String idfoto;
        String ind_f;
        String vfoto;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        private cargarfoto() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x007e, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x007a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                r1 = r6[r0]
                r5.idfoto = r1
                r1 = 1
                r2 = r6[r1]
                r5.ind_f = r2
                r2 = 2
                r6 = r6[r2]
                r5.vfoto = r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN
                r6.append(r2)
                java.lang.String r2 = "/srv/imgs/radio/"
                r6.append(r2)
                java.lang.String r2 = r5.idfoto
                r6.append(r2)
                java.lang.String r2 = "_fondo.png?v="
                r6.append(r2)
                java.lang.String r2 = r5.vfoto
                r6.append(r2)
                java.lang.String r6 = r6.toString()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "fondo_"
                r2.<init>(r3)
                java.lang.String r3 = r5.idfoto
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r3 = -1
                java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0089 }
                r4.<init>(r6)     // Catch:{ MalformedURLException -> 0x0089 }
                java.net.URLConnection r6 = r4.openConnection()     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                r6.setDoInput(r1)     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                r1 = 5000(0x1388, float:7.006E-42)
                r6.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                r1 = 7000(0x1b58, float:9.809E-42)
                r6.setReadTimeout(r1)     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                r6.connect()     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                java.io.InputStream r6 = r6.getInputStream()     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                stikerwap.appdys.t_radio r1 = stikerwap.appdys.t_radio.this     // Catch:{ Exception -> 0x007a }
                java.io.FileOutputStream r1 = r1.openFileOutput(r2, r0)     // Catch:{ Exception -> 0x007a }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x007a }
                r4 = 100
                r6.compress(r2, r4, r1)     // Catch:{ Exception -> 0x007a }
                r1.close()     // Catch:{ Exception -> 0x007a }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r0)
                return r6
            L_0x007a:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)     // Catch:{ IOException -> 0x0084, OutOfMemoryError -> 0x007f }
                return r6
            L_0x007f:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            L_0x0084:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            L_0x0089:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_radio.cargarfoto.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (b.byteValue() == 0) {
                try {
                    t_radio.this.globales.tratar_fondo((ImageView) t_radio.this.findViewById(R.id.iv_fondo), Boolean.valueOf(t_radio.this.globales.secciones_a[t_radio.this.ind].fondo_margen), t_radio.this.globales.secciones_a[t_radio.this.ind].fondo_tipo);
                    ((ImageView) t_radio.this.findViewById(R.id.iv_fondo)).setVisibility(8);
                    config config = t_radio.this.globales;
                    config.file_to_iv("fondo_" + this.idfoto, (ImageView) t_radio.this.findViewById(R.id.iv_fondo));
                    config.fade_in((ImageView) t_radio.this.findViewById(R.id.iv_fondo));
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = t_radio.this.sh.edit();
                edit.putInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + this.idfoto + "_fondo_modif", 0);
                edit.commit();
                t_radio.this.globales.secciones_a[Integer.parseInt(this.ind_f)].fondo_modif = false;
            }
        }
    }

    public void onBackPressed() {
        if (findViewById(R.id.sv_chat).getVisibility() == 0) {
            cerrar_chat();
        } else if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            super.onBackPressed();
        } else {
            this.atras_pulsado = true;
            config.confirmar_exit(this);
        }
    }

    public int getBufferPercentage() {
        try {
            if (getDuration() > 0) {
                return (getCurrentPosition() * 100) / getDuration();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public int getCurrentPosition() {
        return this.sh_mp.getInt("position", 0);
    }

    public int getDuration() {
        return this.sh_mp.getInt("duration", -1);
    }

    public boolean isPlaying() {
        return this.sh_mp.getBoolean("isPlaying", false);
    }

    public void pause() {
        Intent intent = new Intent(this, s_mediaplayer_exo.class);
        intent.putExtra("url", this.globales.secciones_a[this.ind].url);
        intent.putExtra("ua", this.globales.secciones_a[this.ind].ua);
        intent.putExtra("accion", CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        intent.putExtra("idsecc", this.globales.secciones_a[this.ind].id);
        intent.putExtra("radio_mostrar", this.radio_mostrar);
        intent.putExtra("secc_tit", this.globales.secciones_a[this.ind].titulo);
        intent.putExtra("esStream", this.esStream);
        startService(intent);
    }

    public void seekTo(int i) {
        Intent intent = new Intent(this, s_mediaplayer_exo.class);
        intent.putExtra("url", this.globales.secciones_a[this.ind].url);
        intent.putExtra("ua", this.globales.secciones_a[this.ind].ua);
        intent.putExtra("accion", "seekto");
        intent.putExtra("valor", i);
        intent.putExtra("idsecc", this.globales.secciones_a[this.ind].id);
        intent.putExtra("secc_tit", this.globales.secciones_a[this.ind].titulo);
        intent.putExtra("esStream", this.esStream);
        intent.putExtra("radio_mostrar", this.radio_mostrar);
        startService(intent);
    }

    public void start() {
        Intent intent = new Intent(this, s_mediaplayer_exo.class);
        intent.putExtra("url", this.globales.secciones_a[this.ind].url);
        intent.putExtra("ua", this.globales.secciones_a[this.ind].ua);
        intent.putExtra("accion", "play");
        intent.putExtra("idsecc", this.globales.secciones_a[this.ind].id);
        intent.putExtra("radio_mostrar", this.radio_mostrar);
        intent.putExtra("secc_tit", this.globales.secciones_a[this.ind].titulo);
        intent.putExtra("esStream", this.esStream);
        startService(intent);
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
                if (!t_radio.this.globales.admob_rew_failed(context, t_radio.this.mAd_appnext)) {
                    t_radio.this.dialog_cargando.cancel();
                    t_radio t_radio = t_radio.this;
                    t_radio.abrir_secc(t_radio.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_radio.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        t_radio.this.abrir_secc(t_radio.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_radio.this.mAd_visto) {
                            t_radio.this.abrir_secc(t_radio.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_radio.this.mAd_visto = true;
                        config.rew_visto(context);
                    }
                });
            }
        };
    }

    public void onError(Ad ad, com.facebook.ads.AdError adError) {
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
                if (t_radio.this.mAd_visto) {
                    t_radio t_radio = t_radio.this;
                    t_radio.abrir_secc(t_radio.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
