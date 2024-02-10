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
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.MimeTypeMap;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.ads.Ad;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class t_url extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    boolean adaptar_ancho = true;
    AlertDialog.Builder adb;
    Anuncios anun;
    boolean atras_pulsado = false;
    GeolocationPermissions.Callback callback_glob;
    boolean cerrar_abrir_secc = false;
    String codigo;
    String contra;
    boolean descargar;
    boolean es_foro = false;
    boolean es_game = false;
    boolean es_pago = false;
    boolean es_publi = false;
    boolean es_px = false;
    boolean es_quiz = false;
    EditText et_contra;
    EditText et_usu;
    Bundle extras;
    String gameid;
    String[] gdocs_ext = {"doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "pages", "ai", "psd", "tiff", "dxf", "svg", "eps", "ps", "ttf", "otf", "xps", "zip", "rar"};
    config globales;
    HttpAuthHandler handler_glob;
    boolean history_cleared = false;
    long idusu;
    int ind_abrir_secc = -1;
    int linksexternos = 0;
    boolean loader = true;
    boolean mAd_visto = false;
    private WebChromeClient mClient;
    /* access modifiers changed from: private */
    public LinearLayout mContentView;
    /* access modifiers changed from: private */
    public View mCustomView;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mFilePathCallback;
    /* access modifiers changed from: private */
    public FrameLayout mTargetView;
    /* access modifiers changed from: private */
    public ValueCallback<Uri> mUploadMessage;
    WebView myWebView;
    String origin_glob;
    PermissionRequest pr_glob;
    boolean primer_load = true;
    boolean ptr = false;
    SwipeRefreshLayout swipe;
    String usu;
    boolean zoom = false;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public t_url() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02bc, code lost:
        if (r3.getInt("fnac_a", 0) != 0) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02ca, code lost:
        if (r3.getInt("sexo", r12) == 0) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d8, code lost:
        if (r3.getString("descr", "").equals("") != false) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        if (r1.extras.getBoolean("nocompletar", false) != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d0, code lost:
        if (r1.globales.secciones_a[r1.globales.ind_secc_sel_2].url.equals(r1.extras.getString("url")) != false) goto L_0x00d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0369 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x045e  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x05ed  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0604  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0630  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0659  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x06c7  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x06e8  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0783  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0825  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0857  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0860  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x08b1  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x08d3  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0943  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0993  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x09a0  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x09a7  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x09cc  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x09d7  */
    /* JADX WARNING: Removed duplicated region for block: B:371:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0216  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            android.content.Context r0 = r21.getApplicationContext()
            stikerwap.appdys.config r0 = (stikerwap.appdys.config) r0
            r1.globales = r0
            java.lang.String r0 = r0.c1
            if (r0 != 0) goto L_0x0015
            stikerwap.appdys.config r0 = r1.globales
            r0.recuperar_vars()
        L_0x0015:
            r1.establec_ralc(r1)
            android.content.Intent r0 = r21.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            r1.extras = r0
            if (r0 != 0) goto L_0x002b
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r1.extras = r0
        L_0x002b:
            java.lang.String r0 = "es_root"
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0049
            android.os.Bundle r5 = r1.extras
            if (r5 == 0) goto L_0x0045
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L_0x0045
            android.os.Bundle r5 = r1.extras
            boolean r5 = r5.getBoolean(r0, r4)
            if (r5 == 0) goto L_0x0045
            r5 = 1
            goto L_0x0046
        L_0x0045:
            r5 = 0
        L_0x0046:
            r1.es_root = r5
            goto L_0x005a
        L_0x0049:
            boolean r5 = r2.containsKey(r0)
            if (r5 == 0) goto L_0x0057
            boolean r5 = r2.getBoolean(r0, r4)
            if (r5 == 0) goto L_0x0057
            r5 = 1
            goto L_0x0058
        L_0x0057:
            r5 = 0
        L_0x0058:
            r1.es_root = r5
        L_0x005a:
            stikerwap.appdys.config r5 = r1.globales
            int r5 = r5.ind_secc_sel_2
            java.lang.String r6 = "file://"
            r7 = -1
            java.lang.String r8 = "url"
            if (r5 == r7) goto L_0x00d5
            stikerwap.appdys.config r5 = r1.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            r5 = r5[r9]
            java.lang.String r5 = r5.c1
            stikerwap.appdys.config r9 = r1.globales
            java.lang.String r9 = r9.c_icos
            java.lang.String r5 = stikerwap.appdys.config.aplicar_color_dialog(r5, r9)
            r1.cbtn = r5
            android.os.Bundle r5 = r1.extras
            boolean r5 = r5.containsKey(r8)
            if (r5 != 0) goto L_0x00a0
            android.os.Bundle r5 = r1.extras
            stikerwap.appdys.config r9 = r1.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            stikerwap.appdys.config r10 = r1.globales
            int r10 = r10.ind_secc_sel_2
            r9 = r9[r10]
            java.lang.String r9 = r9.url
            r5.putString(r8, r9)
            android.os.Bundle r5 = r1.extras
            java.lang.String r9 = "nocompletar"
            boolean r5 = r5.getBoolean(r9, r4)
            if (r5 == 0) goto L_0x00d3
            goto L_0x00e3
        L_0x00a0:
            android.os.Bundle r5 = r1.extras
            java.lang.String r5 = r5.getString(r8)
            boolean r5 = r5.startsWith(r6)
            if (r5 != 0) goto L_0x00e3
            stikerwap.appdys.config r5 = r1.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            r5 = r5[r9]
            int r5 = r5.tipo
            if (r5 != r3) goto L_0x00e3
            stikerwap.appdys.config r5 = r1.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            r5 = r5[r9]
            java.lang.String r5 = r5.url
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            boolean r5 = r5.equals(r9)
            if (r5 != 0) goto L_0x00d3
            goto L_0x00e3
        L_0x00d3:
            r5 = 1
            goto L_0x00e4
        L_0x00d5:
            stikerwap.appdys.config r5 = r1.globales
            java.lang.String r5 = r5.c1
            stikerwap.appdys.config r9 = r1.globales
            java.lang.String r9 = r9.c_icos
            java.lang.String r5 = stikerwap.appdys.config.aplicar_color_dialog(r5, r9)
            r1.cbtn = r5
        L_0x00e3:
            r5 = 0
        L_0x00e4:
            super.onCreate(r22)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 22
            java.lang.String r11 = ""
            if (r9 >= r10) goto L_0x011d
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r11)
            java.lang.String r12 = stikerwap.appdys.config.DOM_EDROID
            r10.append(r12)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x011d
            android.os.Bundle r9 = r1.extras
            java.lang.String r10 = r9.getString(r8)
            java.lang.String r12 = "https://"
            java.lang.String r13 = "http://"
            java.lang.String r10 = r10.replace(r12, r13)
            r9.putString(r8, r10)
        L_0x011d:
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "forum."
            r10.<init>(r12)
            java.lang.String r12 = stikerwap.appdys.config.DOM_EDROID
            r10.append(r12)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            boolean r9 = r9.contains(r10)
            java.lang.String r10 = "pixworld.io-desdeac"
            if (r9 == 0) goto L_0x0142
            r1.es_foro = r3
            goto L_0x01b6
        L_0x0142:
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "quiz."
            r12.<init>(r13)
            java.lang.String r13 = stikerwap.appdys.config.DOM_EDROID
            r12.append(r13)
            r12.append(r11)
            java.lang.String r12 = r12.toString()
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x0164
            r1.es_quiz = r3
            goto L_0x01b6
        L_0x0164:
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "games."
            r12.<init>(r13)
            java.lang.String r13 = stikerwap.appdys.config.DOM_EDROID
            r12.append(r13)
            r12.append(r11)
            java.lang.String r12 = r12.toString()
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x0186
            r1.es_game = r3
            goto L_0x01b6
        L_0x0186:
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x0195
            r1.es_px = r3
            goto L_0x01b6
        L_0x0195:
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            java.lang.String r12 = "instal.com"
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x01a6
            r1.es_publi = r3
            goto L_0x01b6
        L_0x01a6:
            android.os.Bundle r9 = r1.extras
            java.lang.String r9 = r9.getString(r8)
            java.lang.String r12 = "paypal.com"
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x01b6
            r1.es_pago = r3
        L_0x01b6:
            boolean r9 = r1.es_foro
            java.lang.String r12 = "nick"
            r13 = 0
            java.lang.String r15 = "sh"
            if (r9 != 0) goto L_0x0216
            boolean r9 = r1.es_game
            if (r9 == 0) goto L_0x01d9
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            if (r9 == r7) goto L_0x01d9
            stikerwap.appdys.config r9 = r1.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            stikerwap.appdys.config r3 = r1.globales
            int r3 = r3.ind_secc_sel_2
            r3 = r9[r3]
            boolean r3 = r3.con_login
            if (r3 != 0) goto L_0x0216
        L_0x01d9:
            boolean r3 = r1.es_px
            if (r3 == 0) goto L_0x01f1
            stikerwap.appdys.config r3 = r1.globales
            int r3 = r3.ind_secc_sel_2
            if (r3 == r7) goto L_0x01f1
            stikerwap.appdys.config r3 = r1.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            r3 = r3[r9]
            boolean r3 = r3.con_login
            if (r3 != 0) goto L_0x0216
        L_0x01f1:
            boolean r3 = r1.es_quiz
            if (r3 == 0) goto L_0x020a
            stikerwap.appdys.config r3 = r1.globales
            int r3 = r3.ind_secc_sel_2
            if (r3 == r7) goto L_0x020a
            stikerwap.appdys.config r3 = r1.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            r3 = r3[r9]
            boolean r3 = r3.con_login
            if (r3 == 0) goto L_0x020a
            goto L_0x0216
        L_0x020a:
            r18 = r5
            r17 = r6
            r16 = r8
            r19 = r10
            r20 = r12
            goto L_0x036a
        L_0x0216:
            android.content.SharedPreferences r3 = r1.getSharedPreferences(r15, r4)
            java.lang.String r9 = "idusu"
            r16 = r8
            long r7 = r3.getLong(r9, r13)
            r1.idusu = r7
            java.lang.String r7 = "cod"
            java.lang.String r7 = r3.getString(r7, r11)
            r1.codigo = r7
            boolean r7 = r1.es_px
            if (r7 == 0) goto L_0x0235
            r7 = 0
            r8 = 0
            r9 = 0
            r13 = 0
            goto L_0x0265
        L_0x0235:
            stikerwap.appdys.config r7 = r1.globales
            stikerwap.appdys.Seccion[] r7 = r7.secciones_a
            stikerwap.appdys.config r8 = r1.globales
            int r8 = r8.ind_secc_sel_2
            r7 = r7[r8]
            int r7 = r7.p_fnac
            stikerwap.appdys.config r8 = r1.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            stikerwap.appdys.config r9 = r1.globales
            int r9 = r9.ind_secc_sel_2
            r8 = r8[r9]
            int r8 = r8.p_sexo
            stikerwap.appdys.config r9 = r1.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            stikerwap.appdys.config r13 = r1.globales
            int r13 = r13.ind_secc_sel_2
            r9 = r9[r13]
            int r9 = r9.p_descr
            stikerwap.appdys.config r13 = r1.globales
            stikerwap.appdys.Seccion[] r13 = r13.secciones_a
            stikerwap.appdys.config r14 = r1.globales
            int r14 = r14.ind_secc_sel_2
            r13 = r13[r14]
            int r13 = r13.fotos_perfil
        L_0x0265:
            java.lang.String r14 = r3.getString(r12, r11)
            boolean r14 = r14.equals(r11)
            java.lang.String r4 = "desde_px"
            r17 = r6
            java.lang.String r6 = "desde_quiz"
            java.lang.String r2 = "desde_game"
            r18 = r5
            java.lang.String r5 = "desde_foro"
            r19 = r10
            java.lang.String r10 = "idsecc"
            if (r14 != 0) goto L_0x031f
            stikerwap.appdys.config r14 = r1.globales
            int r14 = r14.fb_modo
            r20 = r12
            r12 = 3
            if (r14 != r12) goto L_0x0293
            java.lang.String r12 = "email_confirmado"
            r14 = 0
            boolean r12 = r3.getBoolean(r12, r14)
            if (r12 != 0) goto L_0x0293
            goto L_0x0321
        L_0x0293:
            r12 = 2
            if (r13 != r12) goto L_0x02a3
            stikerwap.appdys.config r13 = r1.globales
            r14 = 1
            java.io.File r13 = r13.getTempFile(r1, r14)
            boolean r13 = r13.exists()
            if (r13 == 0) goto L_0x02da
        L_0x02a3:
            if (r7 != r12) goto L_0x02bf
            java.lang.String r7 = "fnac_d"
            r12 = 0
            int r7 = r3.getInt(r7, r12)
            if (r7 == 0) goto L_0x02da
            java.lang.String r7 = "fnac_m"
            int r7 = r3.getInt(r7, r12)
            if (r7 == 0) goto L_0x02da
            java.lang.String r7 = "fnac_a"
            int r7 = r3.getInt(r7, r12)
            if (r7 == 0) goto L_0x02da
            goto L_0x02c0
        L_0x02bf:
            r12 = 0
        L_0x02c0:
            r7 = 2
            if (r8 != r7) goto L_0x02cc
            java.lang.String r8 = "sexo"
            int r8 = r3.getInt(r8, r12)
            if (r8 == 0) goto L_0x02da
        L_0x02cc:
            if (r9 != r7) goto L_0x0365
            java.lang.String r7 = "descr"
            java.lang.String r3 = r3.getString(r7, r11)
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x0365
        L_0x02da:
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.preperfil> r7 = stikerwap.appdys.preperfil.class
            r3.<init>(r1, r7)
            stikerwap.appdys.config r7 = r1.globales
            stikerwap.appdys.Seccion[] r7 = r7.secciones_a
            stikerwap.appdys.config r8 = r1.globales
            int r8 = r8.ind_secc_sel_2
            r7 = r7[r8]
            int r7 = r7.id
            r3.putExtra(r10, r7)
            boolean r7 = r1.es_foro
            if (r7 == 0) goto L_0x02f9
            r7 = 1
            r3.putExtra(r5, r7)
            goto L_0x030d
        L_0x02f9:
            r7 = 1
            boolean r5 = r1.es_game
            if (r5 == 0) goto L_0x0302
            r3.putExtra(r2, r7)
            goto L_0x030d
        L_0x0302:
            boolean r2 = r1.es_px
            if (r2 == 0) goto L_0x030a
            r3.putExtra(r4, r7)
            goto L_0x030d
        L_0x030a:
            r3.putExtra(r6, r7)
        L_0x030d:
            boolean r2 = r1.es_root
            if (r2 == 0) goto L_0x0316
            boolean r2 = r1.es_root
            r3.putExtra(r0, r2)
        L_0x0316:
            r2 = 0
            r1.es_root = r2
            r1.finalizar = r7
            r1.startActivityForResult(r3, r2)
            goto L_0x0365
        L_0x031f:
            r20 = r12
        L_0x0321:
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.chat_perfil> r7 = stikerwap.appdys.chat_perfil.class
            r3.<init>(r1, r7)
            stikerwap.appdys.config r7 = r1.globales
            stikerwap.appdys.Seccion[] r7 = r7.secciones_a
            stikerwap.appdys.config r8 = r1.globales
            int r8 = r8.ind_secc_sel_2
            r7 = r7[r8]
            int r7 = r7.id
            r3.putExtra(r10, r7)
            boolean r7 = r1.es_foro
            if (r7 == 0) goto L_0x0340
            r7 = 1
            r3.putExtra(r5, r7)
            goto L_0x0354
        L_0x0340:
            r7 = 1
            boolean r5 = r1.es_game
            if (r5 == 0) goto L_0x0349
            r3.putExtra(r2, r7)
            goto L_0x0354
        L_0x0349:
            boolean r2 = r1.es_px
            if (r2 == 0) goto L_0x0351
            r3.putExtra(r4, r7)
            goto L_0x0354
        L_0x0351:
            r3.putExtra(r6, r7)
        L_0x0354:
            boolean r2 = r1.es_root
            if (r2 == 0) goto L_0x035d
            boolean r2 = r1.es_root
            r3.putExtra(r0, r2)
        L_0x035d:
            r2 = 0
            r1.es_root = r2
            r1.finalizar = r7
            r1.startActivityForResult(r3, r2)
        L_0x0365:
            boolean r0 = r1.finalizar
            if (r0 == 0) goto L_0x036a
            return
        L_0x036a:
            boolean r0 = r1.es_foro
            if (r0 == 0) goto L_0x045e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.os.Bundle r2 = r1.extras
            r3 = r16
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            java.lang.String r2 = "&idusu="
            r0.append(r2)
            long r4 = r1.idusu
            r0.append(r4)
            java.lang.String r2 = "&c="
            r0.append(r2)
            java.lang.String r2 = r1.codigo
            r0.append(r2)
            java.lang.String r2 = "&idpais="
            r0.append(r2)
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.getCountry()
            r0.append(r2)
            java.lang.String r2 = "&idl="
            r0.append(r2)
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.getLanguage()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.os.Bundle r2 = r1.extras
            java.lang.String r4 = "abrir_idtema"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x0457
            java.lang.String r2 = "/cats.php"
            java.lang.String r5 = "/tema.php"
            java.lang.String r0 = r0.replace(r2, r5)
            java.lang.String r2 = "/temas.php"
            java.lang.String r0 = r0.replace(r2, r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&idc="
            r2.append(r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r5 = "abrir_idcat"
            java.lang.String r0 = r0.getString(r5)
            r2.append(r0)
            java.lang.String r0 = "&idt="
            r2.append(r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r0 = r0.getString(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.os.Bundle r2 = r1.extras
            java.lang.String r4 = "abrir_idresp"
            boolean r2 = r2.containsKey(r4)
            java.lang.String r5 = "&idr_ir="
            if (r2 == 0) goto L_0x042d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r5)
            android.os.Bundle r0 = r1.extras
            java.lang.String r0 = r0.getString(r4)
            r2.append(r0)
            java.lang.String r0 = "#coment"
            r2.append(r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "idcoment_ir"
            java.lang.String r0 = r0.getString(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0457
        L_0x042d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r5)
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "idresp_ir"
            java.lang.String r0 = r0.getString(r4)
            r2.append(r0)
            java.lang.String r0 = "#resp"
            r2.append(r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "idresp_ir"
            java.lang.String r0 = r0.getString(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x0457:
            android.os.Bundle r2 = r1.extras
            r2.putString(r3, r0)
            goto L_0x059d
        L_0x045e:
            r3 = r16
            boolean r0 = r1.es_game
            if (r0 == 0) goto L_0x04e9
            java.lang.String r0 = r1.codigo
            if (r0 != 0) goto L_0x046e
            r4 = 0
            r1.idusu = r4
            r1.codigo = r11
        L_0x046e:
            java.lang.String r0 = r1.codigo
            boolean r2 = r0.equals(r11)
            if (r2 != 0) goto L_0x049e
            android.os.Bundle r2 = r1.extras
            if (r2 == 0) goto L_0x049e
            java.lang.String r4 = "game_idusu_ref"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x049e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "-"
            r2.append(r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "game_idusu_ref"
            java.lang.String r0 = r0.getString(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x049e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.os.Bundle r4 = r1.extras
            java.lang.String r4 = r4.getString(r3)
            r2.append(r4)
            java.lang.String r4 = "&userid="
            r2.append(r4)
            long r4 = r1.idusu
            r2.append(r4)
            java.lang.String r4 = "&param1="
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&ads=1"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.os.Bundle r2 = r1.extras
            r2.putString(r3, r0)
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x04e6 }
            java.lang.String r2 = "gameid"
            java.lang.String r0 = r0.getQueryParameter(r2)     // Catch:{ Exception -> 0x04e6 }
            r1.gameid = r0     // Catch:{ Exception -> 0x04e6 }
            goto L_0x059d
        L_0x04e6:
            goto L_0x059d
        L_0x04e9:
            boolean r0 = r1.es_px
            if (r0 == 0) goto L_0x059d
            java.lang.String r0 = r1.codigo
            if (r0 != 0) goto L_0x04f8
            r4 = 0
            r1.idusu = r4
            r1.codigo = r11
            goto L_0x050e
        L_0x04f8:
            r2 = 0
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r15, r2)     // Catch:{ UnsupportedEncodingException -> 0x050a }
            r2 = r20
            java.lang.String r0 = r0.getString(r2, r11)     // Catch:{ UnsupportedEncodingException -> 0x050a }
            java.lang.String r2 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r2)     // Catch:{ UnsupportedEncodingException -> 0x050a }
            goto L_0x050f
        L_0x050a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x050e:
            r0 = r11
        L_0x050f:
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r4 = -1
            if (r2 == r4) goto L_0x0527
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            stikerwap.appdys.config r4 = r1.globales
            int r4 = r4.ind_secc_sel_2
            r2 = r2[r4]
            boolean r2 = r2.con_login
            if (r2 == 0) goto L_0x0527
            java.lang.String r2 = "1"
            goto L_0x0529
        L_0x0527:
            java.lang.String r2 = "0"
        L_0x0529:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.os.Bundle r5 = r1.extras
            java.lang.String r5 = r5.getString(r3)
            java.lang.String r6 = "pixworld.io"
            r7 = r19
            java.lang.String r5 = r5.replace(r7, r6)
            r4.append(r5)
            java.lang.String r5 = "?ac_ida=3008836&ac_idsec="
            r4.append(r5)
            stikerwap.appdys.config r5 = r1.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            stikerwap.appdys.config r6 = r1.globales
            int r6 = r6.ind_secc_sel_2
            r5 = r5[r6]
            int r5 = r5.id
            r4.append(r5)
            java.lang.String r5 = "&ac_idm="
            r4.append(r5)
            stikerwap.appdys.config r5 = r1.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            stikerwap.appdys.config r6 = r1.globales
            int r6 = r6.ind_secc_sel_2
            r5 = r5[r6]
            java.lang.String r5 = r5.idgame
            r4.append(r5)
            java.lang.String r5 = "&ac_cl="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = "&ac_idu="
            r4.append(r2)
            long r5 = r1.idusu
            r4.append(r5)
            java.lang.String r2 = "&ac_cod="
            r4.append(r2)
            java.lang.String r2 = r1.codigo
            r4.append(r2)
            java.lang.String r2 = "&ac_ni="
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.os.Bundle r2 = r1.extras
            r2.putString(r3, r0)
            android.view.Window r0 = r21.getWindow()
            r2 = 32
            r0.setSoftInputMode(r2)
        L_0x059d:
            r0 = 2131558745(0x7f0d0159, float:1.8742814E38)
            r1.setContentView(r0)
            r21.incluir_menu_pre()
            stikerwap.appdys.config r0 = r1.globales
            r2 = 0
            r0.onCreate_global(r1, r2)
            java.lang.String r0 = "search"
            java.lang.Object r0 = r1.getSystemService(r0)
            android.app.SearchManager r0 = (android.app.SearchManager) r0
            stikerwap.appdys.t_url$1 r2 = new stikerwap.appdys.t_url$1
            r2.<init>()
            r0.setOnCancelListener(r2)
            stikerwap.appdys.t_url$2 r2 = new stikerwap.appdys.t_url$2
            r2.<init>()
            r0.setOnDismissListener(r2)
            boolean r0 = r1.es_publi
            if (r0 != 0) goto L_0x0602
            boolean r0 = r1.es_pago
            if (r0 != 0) goto L_0x0602
            stikerwap.appdys.config r0 = r1.globales
            android.os.Bundle r2 = r1.extras
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r4 = "youtube.com"
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x05ef
            android.os.Bundle r2 = r1.extras
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r4 = "youtu.be"
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L_0x05ed
            goto L_0x05ef
        L_0x05ed:
            r2 = 0
            goto L_0x05f0
        L_0x05ef:
            r2 = 1
        L_0x05f0:
            boolean r4 = r1.es_game
            if (r4 != 0) goto L_0x05fb
            boolean r4 = r1.es_px
            if (r4 == 0) goto L_0x05f9
            goto L_0x05fb
        L_0x05f9:
            r4 = 0
            goto L_0x05fc
        L_0x05fb:
            r4 = 1
        L_0x05fc:
            stikerwap.appdys.Anuncios r0 = r0.mostrar_banner_2(r1, r2, r4)
            r1.anun = r0
        L_0x0602:
            if (r18 == 0) goto L_0x0610
            stikerwap.appdys.config r0 = r1.globales
            int r2 = r0.ind_secc_sel_2
            java.lang.String r4 = r1.cbtn
            r5 = r22
            r0.oncreate_popup(r1, r2, r4, r5)
            goto L_0x0612
        L_0x0610:
            r5 = r22
        L_0x0612:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "linksexternos"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0659
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "adaptar_ancho"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0659
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "loader"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0659
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "loader"
            boolean r0 = r0.getBoolean(r2)
            r1.loader = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "linksexternos"
            boolean r0 = r0.getBoolean(r2)
            if (r0 == 0) goto L_0x0649
            r2 = 1
            r1.linksexternos = r2
            r2 = 0
            goto L_0x064c
        L_0x0649:
            r2 = 0
            r1.linksexternos = r2
        L_0x064c:
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "adaptar_ancho"
            boolean r0 = r0.getBoolean(r4)
            r1.adaptar_ancho = r0
            r1.descargar = r2
            goto L_0x06a3
        L_0x0659:
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.ind_secc_sel_2
            r2 = -1
            if (r0 == r2) goto L_0x0699
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            boolean r0 = r0.loader
            r1.loader = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            int r0 = r0.linksexternos
            r1.linksexternos = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            boolean r0 = r0.adaptar_ancho
            r1.adaptar_ancho = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            boolean r0 = r0.descargar
            r1.descargar = r0
            goto L_0x06a3
        L_0x0699:
            r2 = 1
            r1.loader = r2
            r2 = 0
            r1.linksexternos = r2
            r1.adaptar_ancho = r2
            r1.descargar = r2
        L_0x06a3:
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.ind_secc_sel_2
            r2 = -1
            if (r0 == r2) goto L_0x06c7
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            boolean r0 = r0.zoom
            r1.zoom = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            boolean r0 = r0.pulltorefresh
            r1.ptr = r0
            goto L_0x06cd
        L_0x06c7:
            r2 = 1
            r1.zoom = r2
            r2 = 0
            r1.ptr = r2
        L_0x06cd:
            r0 = 2131363559(0x7f0a06e7, float:1.834693E38)
            android.view.View r0 = r1.findViewById(r0)
            android.webkit.WebView r0 = (android.webkit.WebView) r0
            r1.myWebView = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r0 = r0.getString(r3)
            r2 = r17
            boolean r0 = r0.startsWith(r2)
            java.lang.String r2 = "#"
            if (r0 == 0) goto L_0x0783
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r4 = 1
            r0.setAllowFileAccess(r4)
            r6 = 0
            r1.loader = r6
            r1.zoom = r4
            r1.ptr = r6
            r1.adaptar_ancho = r4
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "bg1"
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0716
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "bg1"
            java.lang.String r0 = r0.getString(r4)
            android.os.Bundle r4 = r1.extras
            java.lang.String r6 = "bg2"
            java.lang.String r4 = r4.getString(r6)
            goto L_0x0738
        L_0x0716:
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.ind_secc_sel_2
            r4 = -1
            if (r0 == r4) goto L_0x0736
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r4 = r1.globales
            int r4 = r4.ind_secc_sel_2
            r0 = r0[r4]
            java.lang.String r0 = r0.c1
            stikerwap.appdys.config r4 = r1.globales
            stikerwap.appdys.Seccion[] r4 = r4.secciones_a
            stikerwap.appdys.config r6 = r1.globales
            int r6 = r6.ind_secc_sel_2
            r4 = r4[r6]
            java.lang.String r4 = r4.c2
            goto L_0x0738
        L_0x0736:
            r0 = r11
            r4 = r0
        L_0x0738:
            boolean r6 = r0.equals(r11)
            if (r6 != 0) goto L_0x0780
            android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r7 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r8 = 2
            int[] r9 = new int[r8]
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r2)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            r8 = 0
            r9[r8] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            r4 = 1
            r9[r4] = r0
            r6.<init>(r7, r9)
            r0 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setBackgroundDrawable(r6)
            android.webkit.WebView r0 = r1.myWebView
            r4 = 0
            r0.setBackgroundColor(r4)
            goto L_0x07fd
        L_0x0780:
            r4 = 0
            goto L_0x07fd
        L_0x0783:
            r4 = 0
            boolean r0 = r1.es_quiz
            if (r0 == 0) goto L_0x0793
            r1.loader = r4
            r1.zoom = r4
            r1.ptr = r4
            r1.adaptar_ancho = r4
            r1.descargar = r4
            goto L_0x07fd
        L_0x0793:
            boolean r0 = r1.es_foro
            if (r0 == 0) goto L_0x07a2
            r1.loader = r4
            r1.zoom = r4
            r1.ptr = r4
            r1.adaptar_ancho = r4
            r1.descargar = r4
            goto L_0x07fd
        L_0x07a2:
            boolean r0 = r1.es_game
            if (r0 != 0) goto L_0x07f1
            boolean r0 = r1.es_px
            if (r0 == 0) goto L_0x07ab
            goto L_0x07f1
        L_0x07ab:
            boolean r0 = r1.es_publi
            if (r0 == 0) goto L_0x07fd
            android.os.Bundle r0 = r1.extras
            java.lang.String r0 = r0.getString(r3)
            java.lang.String r4 = "&cl=1"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x07d8
            r4 = 2131362433(0x7f0a0281, float:1.8344646E38)
            android.view.View r4 = r1.findViewById(r4)
            stikerwap.appdys.t_url$3 r6 = new stikerwap.appdys.t_url$3
            r6.<init>()
            r4.setOnClickListener(r6)
            r4 = 2131362433(0x7f0a0281, float:1.8344646E38)
            android.view.View r4 = r1.findViewById(r4)
            r6 = 0
            r4.setVisibility(r6)
            goto L_0x07d9
        L_0x07d8:
            r6 = 0
        L_0x07d9:
            java.lang.String r4 = "&lo=1"
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x07e5
            r4 = 1
            r1.loader = r4
            goto L_0x07e8
        L_0x07e5:
            r4 = 1
            r1.loader = r6
        L_0x07e8:
            r1.zoom = r6
            r1.ptr = r6
            r1.adaptar_ancho = r6
            r1.descargar = r6
            goto L_0x07fd
        L_0x07f1:
            r4 = 1
            r6 = 0
            r1.loader = r4
            r1.zoom = r6
            r1.ptr = r6
            r1.adaptar_ancho = r6
            r1.descargar = r6
        L_0x07fd:
            boolean r0 = r1.es_quiz
            if (r0 != 0) goto L_0x0816
            boolean r0 = r1.es_foro
            if (r0 != 0) goto L_0x0816
            boolean r0 = r1.es_game
            if (r0 != 0) goto L_0x0816
            boolean r0 = r1.es_px
            if (r0 != 0) goto L_0x0816
            boolean r0 = r1.es_publi
            if (r0 != 0) goto L_0x0816
            android.webkit.WebView r0 = r1.myWebView
            r1.registerForContextMenu(r0)
        L_0x0816:
            r0 = 2131363212(0x7f0a058c, float:1.8346226E38)
            android.view.View r0 = r1.findViewById(r0)
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r0
            r1.swipe = r0
            boolean r4 = r1.ptr
            if (r4 == 0) goto L_0x0857
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 20
            if (r0 <= r4) goto L_0x084b
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r1.swipe
            r4 = 1
            int[] r6 = new int[r4]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            stikerwap.appdys.config r2 = r1.globales
            java.lang.String r2 = r2.c_icos
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            int r2 = android.graphics.Color.parseColor(r2)
            r4 = 0
            r6[r4] = r2
            r0.setColorSchemeColors(r6)
            goto L_0x084c
        L_0x084b:
            r4 = 0
        L_0x084c:
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r1.swipe
            stikerwap.appdys.t_url$4 r2 = new stikerwap.appdys.t_url$4
            r2.<init>()
            r0.setOnRefreshListener(r2)
            goto L_0x085b
        L_0x0857:
            r4 = 0
            r0.setEnabled(r4)
        L_0x085b:
            int r0 = r1.linksexternos
            r2 = 2
            if (r0 != r2) goto L_0x086a
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 1
            r0.setSupportMultipleWindows(r2)
        L_0x086a:
            android.webkit.WebView r0 = r1.myWebView
            stikerwap.appdys.t_url$5 r2 = new stikerwap.appdys.t_url$5
            r2.<init>()
            r1.mClient = r2
            r0.setWebChromeClient(r2)
            r21.wv_set()
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            boolean r2 = r1.zoom
            r0.setBuiltInZoomControls(r2)
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            boolean r2 = r1.zoom
            r0.setSupportZoom(r2)
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 1
            r0.setDomStorageEnabled(r2)
            android.webkit.WebView r0 = r1.myWebView
            stikerwap.appdys.t_url$6 r2 = new stikerwap.appdys.t_url$6
            r2.<init>()
            r0.setOnTouchListener(r2)
            android.webkit.WebView r0 = r1.myWebView
            stikerwap.appdys.t_url$7 r2 = new stikerwap.appdys.t_url$7
            r2.<init>()
            r0.setDownloadListener(r2)
            boolean r0 = r1.adaptar_ancho
            if (r0 == 0) goto L_0x08c4
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 1
            r0.setUseWideViewPort(r2)
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r0.setLoadWithOverviewMode(r2)
        L_0x08c4:
            r0 = 2131363028(0x7f0a04d4, float:1.8345853E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 20
            if (r2 <= r4) goto L_0x08da
            stikerwap.appdys.config r2 = r1.globales
            java.lang.String r2 = r2.c_icos
            stikerwap.appdys.config.progress_color(r0, r2)
        L_0x08da:
            android.webkit.WebView r2 = r1.myWebView
            stikerwap.appdys.t_url$8 r4 = new stikerwap.appdys.t_url$8
            r4.<init>(r0)
            r2.setWebViewClient(r4)
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 1
            r0.setJavaScriptEnabled(r2)
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            android.webkit.WebSettings$PluginState r2 = android.webkit.WebSettings.PluginState.ON
            r0.setPluginState(r2)
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 0
            r0.setMediaPlaybackRequiresUserGesture(r2)
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.wv_cache
            if (r0 == 0) goto L_0x091d
            boolean r0 = r1.es_quiz
            if (r0 != 0) goto L_0x091d
            boolean r0 = r1.es_foro
            if (r0 != 0) goto L_0x091d
            boolean r0 = r1.es_game
            if (r0 != 0) goto L_0x091d
            boolean r0 = r1.es_px
            if (r0 != 0) goto L_0x091d
            boolean r0 = r1.es_publi
            if (r0 == 0) goto L_0x0933
        L_0x091d:
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.wv_cache_limpiada
            if (r0 != 0) goto L_0x0933
            boolean r0 = stikerwap.appdys.config.isNetworkAvailable(r21)
            if (r0 == 0) goto L_0x0933
            android.webkit.WebView r0 = r1.myWebView
            r2 = 1
            r0.clearCache(r2)
            stikerwap.appdys.config r0 = r1.globales
            r0.wv_cache_limpiada = r2
        L_0x0933:
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = -1
            r0.setCacheMode(r2)
            boolean r0 = stikerwap.appdys.config.isNetworkAvailable(r21)
            if (r0 != 0) goto L_0x0972
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.wv_sinconex
            if (r0 == 0) goto L_0x0968
            boolean r0 = r1.es_quiz
            if (r0 != 0) goto L_0x0968
            boolean r0 = r1.es_foro
            if (r0 != 0) goto L_0x0968
            boolean r0 = r1.es_game
            if (r0 != 0) goto L_0x0968
            boolean r0 = r1.es_px
            if (r0 != 0) goto L_0x0968
            boolean r0 = r1.es_publi
            if (r0 != 0) goto L_0x0968
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 1
            r0.setCacheMode(r2)
            goto L_0x0972
        L_0x0968:
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            r2 = 2
            r0.setCacheMode(r2)
        L_0x0972:
            boolean r0 = r1.es_publi
            if (r0 != 0) goto L_0x09d5
            boolean r0 = r1.es_pago
            if (r0 != 0) goto L_0x09d5
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.ind_secc_sel_2
            r2 = -1
            if (r0 == r2) goto L_0x09a0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            java.lang.String r0 = r0.ua
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x09a0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.ind_secc_sel_2
            r0 = r0[r2]
            java.lang.String r0 = r0.ua
            goto L_0x09a1
        L_0x09a0:
            r0 = r11
        L_0x09a1:
            boolean r2 = r0.equals(r11)
            if (r2 == 0) goto L_0x09cc
            android.webkit.WebView r0 = r1.myWebView
            android.webkit.WebSettings r0 = r0.getSettings()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.webkit.WebView r4 = r1.myWebView
            android.webkit.WebSettings r4 = r4.getSettings()
            java.lang.String r4 = r4.getUserAgentString()
            r2.append(r4)
            java.lang.String r4 = " Vinebre"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.setUserAgentString(r2)
            goto L_0x09d5
        L_0x09cc:
            android.webkit.WebView r2 = r1.myWebView
            android.webkit.WebSettings r2 = r2.getSettings()
            r2.setUserAgentString(r0)
        L_0x09d5:
            if (r5 != 0) goto L_0x0a8e
            android.os.Bundle r0 = r1.extras
            java.lang.String r0 = r0.getString(r3)
            int r2 = r1.linksexternos
            r3 = 1
            if (r2 == r3) goto L_0x0a08
            java.lang.String r2 = r0.toLowerCase()
            java.lang.String r3 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r2)
            if (r3 == 0) goto L_0x0a08
            boolean r4 = r3.equals(r11)
            if (r4 != 0) goto L_0x0a08
            java.lang.String[] r4 = r1.gdocs_ext
            java.util.List r4 = java.util.Arrays.asList(r4)
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L_0x0a08
            java.lang.String r3 = "docs.google.com"
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x0a08
            r2 = 1
            goto L_0x0a09
        L_0x0a08:
            r2 = 0
        L_0x0a09:
            if (r2 == 0) goto L_0x0a26
            java.lang.String r2 = "utf-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r2)     // Catch:{ Exception -> 0x0a12 }
        L_0x0a12:
            android.webkit.WebView r2 = r1.myWebView
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "https://docs.google.com/viewer?embedded=true&url="
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.loadUrl(r0)
            goto L_0x0a8e
        L_0x0a26:
            boolean r2 = r1.es_publi
            if (r2 == 0) goto L_0x0a4a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0a49 }
            r2.<init>()     // Catch:{ Exception -> 0x0a49 }
            r2.append(r0)     // Catch:{ Exception -> 0x0a49 }
            java.lang.String r3 = "&android_id="
            r2.append(r3)     // Catch:{ Exception -> 0x0a49 }
            android.content.ContentResolver r3 = r21.getContentResolver()     // Catch:{ Exception -> 0x0a49 }
            java.lang.String r4 = "android_id"
            java.lang.String r3 = android.provider.Settings.Secure.getString(r3, r4)     // Catch:{ Exception -> 0x0a49 }
            r2.append(r3)     // Catch:{ Exception -> 0x0a49 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0a49 }
            goto L_0x0a4a
        L_0x0a49:
        L_0x0a4a:
            android.webkit.WebView r2 = r1.myWebView
            r2.loadUrl(r0)
            boolean r0 = r1.es_px
            if (r0 == 0) goto L_0x0a78
            r2 = 0
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r15, r2)
            java.lang.String r2 = "pp_aceptada"
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L_0x0a78
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.aviso_cookies
            if (r0 != 0) goto L_0x0a6c
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.privacy_mostrar_2
            if (r0 == 0) goto L_0x0a78
        L_0x0a6c:
            stikerwap.appdys.t_url$cargarprivacidad r0 = new stikerwap.appdys.t_url$cargarprivacidad
            r2 = 1
            r0.<init>(r2)
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            r0.execute(r2)
        L_0x0a78:
            r0 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.mContentView = r0
            r0 = 2131363279(0x7f0a05cf, float:1.8346362E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r1.mTargetView = r0
        L_0x0a8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_url.onCreate(android.os.Bundle):void");
    }

    private class cargarprivacidad extends AsyncTask<String, Void, Byte> {
        ProgressDialog dialog_cargando_2;
        boolean pedir_confirm;
        String result_http;

        public cargarprivacidad(boolean z) {
            this.pedir_confirm = z;
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_url.cargarprivacidad.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(t_url.this);
            this.dialog_cargando_2 = progressDialog;
            progressDialog.setMessage(t_url.this.getString(R.string.cargando));
            this.dialog_cargando_2.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !t_url.this.cbtn.equals("")) {
                this.dialog_cargando_2.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) cargarprivacidad.this.dialog_cargando_2.findViewById(16908301), t_url.this.cbtn);
                    }
                });
            }
            this.dialog_cargando_2.show();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                this.dialog_cargando_2.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() != 0) {
                t_url t_url = t_url.this;
                config.mostrar_error(t_url, t_url.getString(R.string.error_http_tit), t_url.this.getString(R.string.error_http), t_url.this.cbtn);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(t_url.this);
            builder.setMessage(Html.fromHtml(this.result_http));
            if (this.pedir_confirm) {
                builder.setCancelable(false);
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_url.this.finish();
                    }
                });
                builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor edit = t_url.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                        edit.putBoolean("pp_aceptada", true);
                        edit.commit();
                    }
                });
            } else {
                builder.setCancelable(true);
                builder.setPositiveButton(t_url.this.getString(R.string.cerrar), (DialogInterface.OnClickListener) null);
            }
            final AlertDialog create = builder.create();
            if (!t_url.this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + t_url.this.cbtn));
                        if (cargarprivacidad.this.pedir_confirm) {
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + t_url.this.cbtn));
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

    /* access modifiers changed from: package-private */
    public void abrir_go(int i, boolean z) {
        ResultGetIntent crear_rgi = this.globales.crear_rgi(Integer.valueOf(i), this);
        if (z) {
            this.finalizar = true;
            Intent intent = new Intent();
            intent.putExtra("finalizar", true);
            intent.putExtra("finalizar_app", false);
            setResult(-1, intent);
            if (crear_rgi.i != null) {
                if (this.globales.tipomenu != 2) {
                    crear_rgi.i.putExtra("es_root", true);
                }
                this.es_root = false;
                startActivity(crear_rgi.i);
            }
            finish();
            return;
        }
        startActivityForResult(crear_rgi.i, 0);
    }

    /* access modifiers changed from: package-private */
    public Intent i_perfilajeno(String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent(this, profile.class);
        intent.putExtra("id", parse.getQueryParameter("id"));
        intent.putExtra("privados", parse.getQueryParameter("privados"));
        intent.putExtra("nombre", parse.getQueryParameter("nombre"));
        intent.putExtra("coments", parse.getQueryParameter("coments"));
        intent.putExtra("fnac_d", parse.getQueryParameter("fnac_d"));
        intent.putExtra("fnac_m", parse.getQueryParameter("fnac_m"));
        intent.putExtra("fnac_a", parse.getQueryParameter("fnac_a"));
        intent.putExtra("sexo", parse.getQueryParameter("sexo"));
        intent.putExtra("vfoto", parse.getQueryParameter("vfoto"));
        if (this.extras.containsKey("desdepriv")) {
            intent.putExtra("desdepriv", "1");
        }
        intent.putExtra("p_fnac", this.globales.secciones_a[this.globales.ind_secc_sel_2].p_fnac);
        intent.putExtra("p_sexo", this.globales.secciones_a[this.globales.ind_secc_sel_2].p_sexo);
        intent.putExtra("p_descr", this.globales.secciones_a[this.globales.ind_secc_sel_2].p_descr);
        intent.putExtra("p_dist", this.globales.secciones_a[this.globales.ind_secc_sel_2].p_dist);
        intent.putExtra("coments_chat", this.globales.secciones_a[this.globales.ind_secc_sel_2].coments);
        intent.putExtra("galeria", this.globales.secciones_a[this.globales.ind_secc_sel_2].galeria);
        intent.putExtra("privados_chat", this.globales.secciones_a[this.globales.ind_secc_sel_2].privados);
        intent.putExtra("fotos_perfil", this.globales.secciones_a[this.globales.ind_secc_sel_2].fotos_perfil);
        intent.putExtra("fotos_chat", 1);
        return intent;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getMenuInflater().inflate(R.menu.m3, contextMenu);
        WebView.HitTestResult hitTestResult = this.myWebView.getHitTestResult();
        if (!this.descargar || !(hitTestResult.getType() == 5 || hitTestResult.getType() == 8)) {
            contextMenu.removeItem(R.id.guardar);
        } else {
            MenuItem findItem = contextMenu.findItem(R.id.guardar);
            String str = findItem.getTitle() + "";
            findItem.setTitle(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
        }
        if (!this.descargar || !(hitTestResult.getType() == 5 || hitTestResult.getType() == 8)) {
            contextMenu.removeItem(R.id.compartir);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        boolean z;
        Uri uriForFile;
        int itemId = menuItem.getItemId();
        String str = "";
        if (itemId == R.id.compartir) {
            if (this.extras.getString("url").startsWith(AdPayload.FILE_SCHEME)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeFile = BitmapFactory.decodeFile(this.extras.getString("url").replace(AdPayload.FILE_SCHEME, str), options);
                try {
                    File file = new File(getCacheDir(), "images");
                    file.mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(file + "/temporal.png");
                    decodeFile.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    z = true;
                } catch (IOException e) {
                    e.printStackTrace();
                    z = false;
                }
                if (z && (uriForFile = FileProvider.getUriForFile(this, "stikerwap.appdys.fileprovider", new File(new File(getCacheDir(), "images"), "temporal.png"))) != null) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.addFlags(1);
                    intent.setType(getContentResolver().getType(uriForFile));
                    intent.putExtra("android.intent.extra.STREAM", uriForFile);
                    startActivity(Intent.createChooser(intent, getResources().getString(R.string.compartir)));
                }
            } else {
                String str2 = this.myWebView.getHitTestResult().getExtra().toString();
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("text/plain");
                intent2.putExtra("android.intent.extra.TEXT", str2);
                startActivity(Intent.createChooser(intent2, getResources().getString(R.string.compartir)));
            }
            return true;
        } else if (itemId != R.id.guardar) {
            return super.onContextItemSelected(menuItem);
        } else {
            if (this.extras.getString("url").startsWith(AdPayload.FILE_SCHEME)) {
                config.fguardar_foto_desdefile(this.extras.getString("url"), this);
            } else {
                WebView.HitTestResult hitTestResult = this.myWebView.getHitTestResult();
                String str3 = hitTestResult.getExtra().toString();
                if (str3 != null) {
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(hitTestResult.getExtra().toString());
                    String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "image/*";
                    try {
                        str = URLUtil.guessFileName(str3, (String) null, mimeTypeFromExtension);
                    } catch (Exception unused) {
                    }
                    this.globales.fdescargar(str3, mimeTypeFromExtension, str, this);
                }
            }
            return true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCustomView != null) {
                this.atras_pulsado = false;
                this.mClient.onHideCustomView();
                return true;
            } else if (this.myWebView.canGoBack() && !this.history_cleared) {
                if (this.es_foro) {
                    try {
                        this.atras_pulsado = false;
                        String url = this.myWebView.getUrl();
                        WebBackForwardList copyBackForwardList = this.myWebView.copyBackForwardList();
                        String url2 = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1).getUrl();
                        if (!url2.contains("tema_nuevo.php")) {
                            if (!url2.contains("resp_nueva.php")) {
                                if (!url2.contains("coment_nuevo.php")) {
                                    this.myWebView.goBack();
                                }
                            }
                        }
                        int i2 = 1;
                        while (true) {
                            if (!url2.contains("tema_nuevo.php") && !url2.contains("resp_nueva.php")) {
                                if (!url2.contains("coment_nuevo.php")) {
                                    if (!url.contains("tema_nuevo.php") && !url.contains("resp_nueva.php") && !url.contains("coment_nuevo.php")) {
                                        int i3 = i2 + 1;
                                        if (copyBackForwardList.getCurrentIndex() - i3 >= 0) {
                                            i2 = i3;
                                        }
                                    }
                                    url2 = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - i2).getUrl();
                                    if (!url2.contains("tema_nuevo.php") && !url2.contains("resp_nueva.php") && !url2.contains("coment_nuevo.php")) {
                                        break;
                                    }
                                }
                            }
                            i2++;
                            url2 = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - i2).getUrl();
                        }
                        this.myWebView.goBackOrForward(-i2);
                    } catch (Exception unused) {
                        this.atras_pulsado = false;
                        this.myWebView.goBack();
                    }
                } else {
                    this.atras_pulsado = false;
                    this.myWebView.goBack();
                }
                return true;
            } else if (this.es_root && !this.atras_pulsado && this.globales.pedir_confirm_exit) {
                this.atras_pulsado = true;
                config.confirmar_exit(this);
                return true;
            } else if (this.es_root && this.myWebView.getUrl() != null && (this.myWebView.getUrl().toLowerCase().contains("youtube.com") || this.myWebView.getUrl().toLowerCase().contains("youtu.be"))) {
                startActivity(new Intent(this, finalizar.class));
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
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

    public void onClick(View view) {
        if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
            abrir_secc(view);
            return;
        }
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
        this.ind_abrir_secc = -1;
        this.cerrar_abrir_secc = false;
        if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
            abrir_secc(view);
        }
    }

    public void abrir_secc(View view) {
        if (view == null) {
            int i = this.ind_abrir_secc;
            if (i != -1) {
                abrir_go(i, this.cerrar_abrir_secc);
                return;
            }
            return;
        }
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
                if (this.myWebView.getUrl() != null && (this.myWebView.getUrl().toLowerCase().contains("youtube.com") || this.myWebView.getUrl().toLowerCase().contains("youtu.be"))) {
                    this.myWebView.reload();
                }
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

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 103) {
            boolean p_location = config.p_location(this);
            if (!p_location || iArr.length <= 0 || ((!strArr[0].equals("android.permission.ACCESS_FINE_LOCATION") && !strArr[0].equals("android.permission.ACCESS_COARSE_LOCATION")) || iArr[0] != 0)) {
                if (p_location && iArr.length > 1) {
                    if ((!strArr[1].equals("android.permission.ACCESS_FINE_LOCATION") && !strArr[1].equals("android.permission.ACCESS_COARSE_LOCATION")) || iArr[1] != 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.callback_glob.invoke(this.origin_glob, true, false);
        } else if (i == 105 && this.pr_glob != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.pr_glob.getResources()) {
                if (str.contains("AUDIO_CAPTURE") && ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.MODIFY_AUDIO_SETTINGS") == 0) {
                    arrayList.add(str);
                }
                if (str.contains("VIDEO_CAPTURE") && ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                try {
                    this.pr_glob.grant((String[]) arrayList.toArray(new String[0]));
                } catch (Exception unused) {
                }
            } else {
                this.pr_glob.deny();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String dataString;
        config config = this.globales;
        if (config != null && config.onActivityResult_glob(i, i2, intent, this)) {
            return;
        }
        if (i == 10) {
            ValueCallback<Uri> valueCallback = this.mUploadMessage;
            if (valueCallback != null || this.mFilePathCallback != null) {
                if (valueCallback != null) {
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.mFilePathCallback != null) {
                    this.mFilePathCallback.onReceiveValue((intent == null || (dataString = intent.getDataString()) == null) ? null : new Uri[]{Uri.parse(dataString)});
                    this.mFilePathCallback = null;
                }
            }
        } else if (i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
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

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.restoreState(bundle);
        }
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
        if (this.mCustomView != null) {
            this.mClient.onHideCustomView();
        }
        super.onPause();
        config.onPause_global(this);
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.onPause();
            if (this.finalizar || isFinishing()) {
                try {
                    this.myWebView.loadData("", "text/html", "utf-8");
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
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
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.onResume();
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
        if ((this.es_root && isFinishing()) || config.finalizar_app) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = false;
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
        if (!this.es_publi && !this.es_pago) {
            config config = this.globales;
            boolean z2 = this.extras.getString("url").contains("youtube.com") || this.extras.getString("url").contains("youtu.be");
            if (this.es_game || this.es_px) {
                z = true;
            }
            this.anun = config.mostrar_banner_2(this, z2, z);
        }
    }

    private void wv_set() {
        if (Build.VERSION.SDK_INT > 20 && this.myWebView != null) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.myWebView, true);
        }
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
                if (!t_url.this.globales.admob_rew_failed(context, t_url.this.mAd_appnext)) {
                    t_url.this.dialog_cargando.cancel();
                    t_url t_url = t_url.this;
                    t_url.abrir_secc(t_url.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_url.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_url.this.abrir_secc(t_url.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_url.this.mAd_visto) {
                            t_url.this.abrir_secc(t_url.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_url.this.mAd_visto = true;
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
                if (t_url.this.mAd_visto) {
                    t_url t_url = t_url.this;
                    t_url.abrir_secc(t_url.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
