package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.CallbackManager;
import com.facebook.ads.Ad;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class chat_perfil extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private static final int PERMISOS_CODE = 3;
    private static final int SELECT_PHOTO = 2;
    Anuncios anun;
    boolean atras_pulsado = false;
    private ImageView btnfotos;
    private String c1;
    private String c2;
    CallbackManager callbackManager;
    Long captureTime;
    /* access modifiers changed from: private */
    public String cod_g;
    /* access modifiers changed from: private */
    public String codigo;
    /* access modifiers changed from: private */
    public String codigo_invit;
    private int coments;
    private int descr;
    boolean desde_main;
    boolean desde_main_oblig;
    ProgressDialog dialog_cargando_2;
    ProgressDialog dialog_cargando_3;
    Dialog dialog_contra;
    ProgressDialog dialog_enviandocontra;
    private ImageView elim1;
    private boolean email_confirmado;
    boolean es_root_orig;
    boolean externo;
    Bundle extras;
    private FrameLayout fl_edit_foto;
    private int fnac;
    private ImageView foto1;
    private String foto1_modif;
    private int fotos_perfil;
    FusedLocationProviderClient fusedLocationClient;
    private int galeria;
    config globales;
    /* access modifiers changed from: private */
    public int idsecc;
    /* access modifiers changed from: private */
    public long idusu;
    private int ind;
    LoginButton loginButton;
    boolean mAd_visto = false;
    ListView mDrawerList;
    private int nfotos = 0;
    boolean nuevo;
    ProgressBar pb;
    /* access modifiers changed from: private */
    public int pos_a;
    /* access modifiers changed from: private */
    public int pos_avisos;
    /* access modifiers changed from: private */
    public int pos_coments;
    /* access modifiers changed from: private */
    public int pos_d;
    /* access modifiers changed from: private */
    public int pos_m;
    /* access modifiers changed from: private */
    public int pos_privados;
    /* access modifiers changed from: private */
    public int pos_sexo;
    private int privados;
    /* access modifiers changed from: private */
    public SharedPreferences settings;
    private int sexo;
    private MaterialAutoCompleteTextView spinner_a;
    private MaterialAutoCompleteTextView spinner_avisos;
    private MaterialAutoCompleteTextView spinner_coments;
    private MaterialAutoCompleteTextView spinner_d;
    private MaterialAutoCompleteTextView spinner_m;
    private MaterialAutoCompleteTextView spinner_privados;
    private MaterialAutoCompleteTextView spinner_sexo;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0108, code lost:
        if (r5.url.contains("forum." + stikerwap.appdys.config.DOM_EDROID + "") == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012f, code lost:
        if (r5.con_login != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0167, code lost:
        if (r5.con_login != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0172, code lost:
        if (r0.globales.chatsecc_en_video != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a8, code lost:
        if (r5.fotos_perfil == 2) goto L_0x01ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x069a A[SYNTHETIC, Splitter:B:154:0x069a] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x06a7 A[Catch:{ Exception -> 0x06a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x06dd  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0721  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x077e  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0819  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0824  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x082c  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x083d  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0848  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x086f  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x08a6  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x08b1  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x08c5  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x08d3  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x095d  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0a2c  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0ab7  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0ac7  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0aea  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0b0c  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0b10  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0b87 A[LOOP:1: B:296:0x0b83->B:298:0x0b87, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0bdf  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0c4e A[LOOP:3: B:308:0x0c4a->B:310:0x0c4e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0d21  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0d32  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0d4d  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0d5e  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0d82  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0d87  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0d98  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0dc7  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0dd7  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0ed7  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0ef8  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0f3a  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0f62  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0fae  */
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
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.ind_secc_sel_2
            r0.ind = r2
            android.content.Intent r2 = r17.getIntent()
            android.os.Bundle r2 = r2.getExtras()
            r0.extras = r2
            java.lang.String r3 = "es_root"
            r5 = 0
            if (r1 != 0) goto L_0x0043
            if (r2 == 0) goto L_0x003f
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x003f
            android.os.Bundle r2 = r0.extras
            boolean r2 = r2.getBoolean(r3, r5)
            if (r2 == 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            r0.es_root = r2
            goto L_0x0054
        L_0x0043:
            boolean r2 = r1.containsKey(r3)
            if (r2 == 0) goto L_0x0051
            boolean r2 = r1.getBoolean(r3, r5)
            if (r2 == 0) goto L_0x0051
            r2 = 1
            goto L_0x0052
        L_0x0051:
            r2 = 0
        L_0x0052:
            r0.es_root = r2
        L_0x0054:
            boolean r2 = r0.es_root
            r0.es_root_orig = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "externo"
            boolean r2 = r2.containsKey(r3)
            r0.externo = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "desde_main"
            boolean r2 = r2.getBoolean(r3, r5)
            r0.desde_main = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "desde_main_oblig"
            boolean r2 = r2.getBoolean(r3, r5)
            r0.desde_main_oblig = r2
            java.lang.String r6 = ""
            if (r2 == 0) goto L_0x00a8
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c1c
            r0.c1 = r2
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c2c
            r0.c2 = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_fotos_perfil
            r0.fotos_perfil = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_fnac
            r0.fnac = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_sexo
            r0.sexo = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_descr
            r0.descr = r2
            r0.galeria = r5
            r0.coments = r5
            r0.privados = r5
            r0.idsecc = r5
            goto L_0x0313
        L_0x00a8:
            boolean r2 = r0.desde_main
            if (r2 == 0) goto L_0x023a
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c1c
            r0.c1 = r2
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c2c
            r0.c2 = r2
            r2 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x00c2:
            stikerwap.appdys.config r5 = r0.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            int r5 = r5.length
            if (r2 >= r5) goto L_0x01d5
            stikerwap.appdys.config r5 = r0.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            r5 = r5[r2]
            int r3 = r5.tipo
            r4 = 10
            if (r3 != r4) goto L_0x00d6
            r12 = 1
        L_0x00d6:
            int r3 = r5.tipo
            r4 = 9
            if (r3 == r4) goto L_0x0180
            int r3 = r5.tipo
            r4 = 11
            if (r3 == r4) goto L_0x0180
            int r3 = r5.tipo
            r4 = 16
            if (r3 == r4) goto L_0x0180
            int r3 = r5.tipo
            r4 = 1
            if (r3 != r4) goto L_0x010b
            java.lang.String r3 = r5.url
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r16 = r12
            java.lang.String r12 = "forum."
            r4.<init>(r12)
            java.lang.String r12 = stikerwap.appdys.config.DOM_EDROID
            r4.append(r12)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x0182
            goto L_0x010d
        L_0x010b:
            r16 = r12
        L_0x010d:
            int r3 = r5.tipo
            r4 = 1
            if (r3 != r4) goto L_0x0131
            java.lang.String r3 = r5.url
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r12 = "games."
            r4.<init>(r12)
            java.lang.String r12 = stikerwap.appdys.config.DOM_EDROID
            r4.append(r12)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0131
            boolean r3 = r5.con_login
            if (r3 != 0) goto L_0x0182
        L_0x0131:
            int r3 = r5.tipo
            r4 = 21
            if (r3 != r4) goto L_0x0145
            java.lang.String r3 = r5.url
            java.lang.String r4 = "pixworld.io-desdeac"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0145
            boolean r3 = r5.con_login
            if (r3 != 0) goto L_0x0182
        L_0x0145:
            int r3 = r5.tipo
            r4 = 1
            if (r3 != r4) goto L_0x0169
            java.lang.String r3 = r5.url
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r12 = "quiz."
            r4.<init>(r12)
            java.lang.String r12 = stikerwap.appdys.config.DOM_EDROID
            r4.append(r12)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0169
            boolean r3 = r5.con_login
            if (r3 != 0) goto L_0x0182
        L_0x0169:
            int r3 = r5.tipo
            r4 = 6
            if (r3 != r4) goto L_0x0174
            stikerwap.appdys.config r3 = r0.globales
            boolean r3 = r3.chatsecc_en_video
            if (r3 != 0) goto L_0x0182
        L_0x0174:
            int r3 = r5.tipo
            r4 = 7
            if (r3 != r4) goto L_0x01cf
            stikerwap.appdys.config r3 = r0.globales
            boolean r3 = r3.chatsecc_en_radio
            if (r3 == 0) goto L_0x01cf
            goto L_0x0182
        L_0x0180:
            r16 = r12
        L_0x0182:
            if (r13 != 0) goto L_0x018b
            boolean r3 = r5.galeria
            if (r3 == 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            r13 = 0
            goto L_0x018c
        L_0x018b:
            r13 = 1
        L_0x018c:
            if (r14 != 0) goto L_0x0195
            boolean r3 = r5.coments
            if (r3 == 0) goto L_0x0193
            goto L_0x0195
        L_0x0193:
            r14 = 0
            goto L_0x0196
        L_0x0195:
            r14 = 1
        L_0x0196:
            if (r15 != 0) goto L_0x019f
            boolean r3 = r5.privados
            if (r3 == 0) goto L_0x019d
            goto L_0x019f
        L_0x019d:
            r15 = 0
            goto L_0x01a0
        L_0x019f:
            r15 = 1
        L_0x01a0:
            r3 = 1
            if (r8 == 0) goto L_0x01ad
            if (r8 != r3) goto L_0x01ab
            int r4 = r5.fotos_perfil
            r7 = 2
            if (r4 != r7) goto L_0x01b0
            goto L_0x01ae
        L_0x01ab:
            r7 = 2
            goto L_0x01b0
        L_0x01ad:
            r7 = 2
        L_0x01ae:
            int r8 = r5.fotos_perfil
        L_0x01b0:
            if (r9 == 0) goto L_0x01b8
            if (r9 != r3) goto L_0x01ba
            int r4 = r5.p_fnac
            if (r4 != r7) goto L_0x01ba
        L_0x01b8:
            int r9 = r5.p_fnac
        L_0x01ba:
            if (r10 == 0) goto L_0x01c2
            if (r10 != r3) goto L_0x01c4
            int r4 = r5.p_sexo
            if (r4 != r7) goto L_0x01c4
        L_0x01c2:
            int r10 = r5.p_sexo
        L_0x01c4:
            if (r11 == 0) goto L_0x01cc
            if (r11 != r3) goto L_0x01ce
            int r3 = r5.p_descr
            if (r3 != r7) goto L_0x01ce
        L_0x01cc:
            int r11 = r5.p_descr
        L_0x01ce:
            r7 = 1
        L_0x01cf:
            int r2 = r2 + 1
            r12 = r16
            goto L_0x00c2
        L_0x01d5:
            r2 = 0
            r0.fotos_perfil = r2
            r0.fnac = r2
            r0.sexo = r2
            r0.descr = r2
            if (r7 != 0) goto L_0x0209
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_acceso
            if (r2 <= 0) goto L_0x01ff
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_fotos_perfil
            r0.fotos_perfil = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_fnac
            r0.fnac = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_sexo
            r0.sexo = r2
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_descr
            r0.descr = r2
            goto L_0x0211
        L_0x01ff:
            r2 = 1
            r0.fotos_perfil = r2
            r0.fnac = r2
            r0.sexo = r2
            r0.descr = r2
            goto L_0x0211
        L_0x0209:
            r0.fotos_perfil = r8
            r0.fnac = r9
            r0.sexo = r10
            r0.descr = r11
        L_0x0211:
            r2 = 0
            r0.galeria = r2
            r0.coments = r2
            r0.privados = r2
            if (r7 != 0) goto L_0x021f
            if (r12 == 0) goto L_0x021d
            goto L_0x021f
        L_0x021d:
            r2 = 0
            goto L_0x0236
        L_0x021f:
            if (r7 == 0) goto L_0x0226
            if (r13 == 0) goto L_0x0224
            goto L_0x0226
        L_0x0224:
            r2 = 1
            goto L_0x0229
        L_0x0226:
            r2 = 1
            r0.galeria = r2
        L_0x0229:
            if (r7 == 0) goto L_0x022d
            if (r14 == 0) goto L_0x022f
        L_0x022d:
            r0.coments = r2
        L_0x022f:
            if (r7 == 0) goto L_0x0233
            if (r15 == 0) goto L_0x021d
        L_0x0233:
            r0.privados = r2
            goto L_0x021d
        L_0x0236:
            r0.idsecc = r2
            goto L_0x0313
        L_0x023a:
            boolean r2 = r0.externo
            if (r2 == 0) goto L_0x029d
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            java.lang.String r2 = r2.c1
            r0.c1 = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            java.lang.String r2 = r2.c2
            r0.c2 = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "fotos_perfil"
            int r2 = r2.getInt(r3)
            r0.fotos_perfil = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "fnac"
            int r2 = r2.getInt(r3)
            r0.fnac = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "sexo"
            int r2 = r2.getInt(r3)
            r0.sexo = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "descr"
            int r2 = r2.getInt(r3)
            r0.descr = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "galeria"
            boolean r2 = r2.getBoolean(r3)
            r0.galeria = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "coments"
            boolean r2 = r2.getBoolean(r3)
            r0.coments = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "privados"
            boolean r2 = r2.getBoolean(r3)
            r0.privados = r2
            goto L_0x0313
        L_0x029d:
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            java.lang.String r2 = r2.c1
            r0.c1 = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            java.lang.String r2 = r2.c2
            r0.c2 = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            int r2 = r2.fotos_perfil
            r0.fotos_perfil = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            int r2 = r2.p_fnac
            r0.fnac = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            int r2 = r2.p_sexo
            r0.sexo = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            int r2 = r2.p_descr
            r0.descr = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            boolean r2 = r2.galeria
            r0.galeria = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            boolean r2 = r2.coments
            r0.coments = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind
            r2 = r2[r3]
            boolean r2 = r2.privados
            r0.privados = r2
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "idsecc"
            int r2 = r2.getInt(r3)
            r0.idsecc = r2
        L_0x0313:
            java.lang.String r2 = r0.c1
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.c_icos
            java.lang.String r2 = stikerwap.appdys.config.aplicar_color_dialog(r2, r3)
            r0.cbtn = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "#"
            r2.<init>(r3)
            java.lang.String r4 = r0.c1
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            if (r2 != 0) goto L_0x033c
            r2 = 2131951901(0x7f13011d, float:1.954023E38)
            r0.setTheme(r2)
            goto L_0x0342
        L_0x033c:
            r2 = 2131951900(0x7f13011c, float:1.9540228E38)
            r0.setTheme(r2)
        L_0x0342:
            super.onCreate(r18)
            r2 = 2131558470(0x7f0d0046, float:1.8742257E38)
            r0.setContentView(r2)
            r17.incluir_menu_pre()
            boolean r2 = r0.desde_main_oblig
            if (r2 != 0) goto L_0x0358
            stikerwap.appdys.config r2 = r0.globales
            r4 = 0
            r2.onCreate_global(r0, r4)
        L_0x0358:
            java.lang.String r2 = "search"
            java.lang.Object r2 = r0.getSystemService(r2)
            android.app.SearchManager r2 = (android.app.SearchManager) r2
            stikerwap.appdys.chat_perfil$1 r4 = new stikerwap.appdys.chat_perfil$1
            r4.<init>()
            r2.setOnCancelListener(r4)
            stikerwap.appdys.chat_perfil$2 r4 = new stikerwap.appdys.chat_perfil$2
            r4.<init>()
            r2.setOnDismissListener(r4)
            stikerwap.appdys.config r2 = r0.globales
            r4 = 0
            stikerwap.appdys.Anuncios r2 = r2.mostrar_banner(r0, r4)
            r0.anun = r2
            java.lang.String r2 = "sh"
            android.content.SharedPreferences r2 = r0.getSharedPreferences(r2, r4)
            r0.settings = r2
            java.lang.String r4 = "idusu"
            r7 = 0
            long r4 = r2.getLong(r4, r7)
            r0.idusu = r4
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r4 = "cod"
            java.lang.String r2 = r2.getString(r4, r6)
            r0.codigo = r2
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r4 = "cod_g"
            java.lang.String r2 = r2.getString(r4, r6)
            r0.cod_g = r2
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r4 = "email_confirmado"
            r5 = 0
            boolean r2 = r2.getBoolean(r4, r5)
            r0.email_confirmado = r2
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r4 = "nick"
            java.lang.String r2 = r2.getString(r4, r6)
            boolean r2 = r2.equals(r6)
            r0.nuevo = r2
            java.lang.String r2 = r0.c1
            boolean r2 = r2.equals(r6)
            r7 = 2131362029(0x7f0a00ed, float:1.8343827E38)
            r8 = 2131363430(0x7f0a0666, float:1.8346669E38)
            r9 = 2131362130(0x7f0a0152, float:1.8344032E38)
            r10 = 2131362129(0x7f0a0151, float:1.834403E38)
            r13 = 2131362023(0x7f0a00e7, float:1.8343815E38)
            r14 = 2131362022(0x7f0a00e6, float:1.8343813E38)
            r15 = 2131362024(0x7f0a00e8, float:1.8343817E38)
            if (r2 != 0) goto L_0x068d
            android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r11 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r4 = 2
            int[] r5 = new int[r4]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r12 = r0.c1
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r12 = 0
            r5[r12] = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r12 = r0.c2
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r12 = 1
            r5[r12] = r4
            r2.<init>(r11, r5)
            r4 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r4 = r0.findViewById(r4)
            r4.setBackgroundDrawable(r2)
            int r2 = stikerwap.appdys.config.BLANCO_2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            if (r4 == 0) goto L_0x042e
            int r2 = stikerwap.appdys.config.NEGRO_2
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x042f
        L_0x042e:
            r4 = -1
        L_0x042f:
            r5 = 2131362941(0x7f0a047d, float:1.8345677E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setTextColor(r4)
            r5 = 2131362198(0x7f0a0196, float:1.834417E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setTextColor(r4)
            r5 = 2131362127(0x7f0a014f, float:1.8344026E38)
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setTextColor(r4)
            android.view.View r5 = r0.findViewById(r10)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setTextColor(r2)
            android.view.View r5 = r0.findViewById(r9)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r5.setTextColor(r2)
            r2 = 2131362153(0x7f0a0169, float:1.8344079E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131362323(0x7f0a0213, float:1.8344423E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131362324(0x7f0a0214, float:1.8344425E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131362322(0x7f0a0212, float:1.8344421E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131363169(0x7f0a0561, float:1.834614E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131362112(0x7f0a0140, float:1.8343995E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131363072(0x7f0a0500, float:1.8345942E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131361945(0x7f0a0099, float:1.8343657E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            r2 = 2131363373(0x7f0a062d, float:1.8346553E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            android.view.View r2 = r0.findViewById(r8)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r4)
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 20
            if (r2 <= r4) goto L_0x068d
            android.view.View r2 = r0.findViewById(r7)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            android.view.View r2 = r0.findViewById(r13)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            android.view.View r2 = r0.findViewById(r15)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            android.view.View r2 = r0.findViewById(r14)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            r2 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            android.view.View r4 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r5 = r0.c1
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            r5 = 1
            r2 = r2 ^ r5
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r4, r2, r5)
            r2 = 2131362021(0x7f0a00e5, float:1.834381E38)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            r2 = 2131362032(0x7f0a00f0, float:1.8343833E38)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            r2 = 2131362015(0x7f0a00df, float:1.8343799E38)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r0.c1
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r5 = 1
            r4 = r4 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r2, r4, r5)
            r2 = 2131362026(0x7f0a00ea, float:1.834382E38)
            android.view.View r4 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r5 = r0.c1
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            r5 = 1
            r2 = r2 ^ r5
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r4, r2, r5)
            r2 = 2131362027(0x7f0a00eb, float:1.8343823E38)
            android.view.View r4 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r5 = r0.c1
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            r5 = 1
            r2 = r2 ^ r5
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r4, r2, r5)
            r2 = 2131362025(0x7f0a00e9, float:1.8343819E38)
            android.view.View r4 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r5 = r0.c1
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            r5 = 1
            r2 = r2 ^ r5
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            stikerwap.appdys.config r11 = r0.globales
            java.lang.String r11 = r11.c_ir_ofic
            stikerwap.appdys.config.textinputlayout_color(r4, r2, r11)
            goto L_0x068e
        L_0x068d:
            r5 = 1
        L_0x068e:
            stikerwap.appdys.config r2 = r0.globales
            java.io.File r2 = r2.getTempFile(r0, r5)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x06a7
            stikerwap.appdys.config r2 = r0.globales     // Catch:{ Exception -> 0x06a5 }
            r4 = 2
            java.io.File r2 = r2.getExtTempFile(r0, r4)     // Catch:{ Exception -> 0x06a5 }
            r2.delete()     // Catch:{ Exception -> 0x06a5 }
            goto L_0x06b8
        L_0x06a5:
            goto L_0x06b8
        L_0x06a7:
            stikerwap.appdys.config r2 = r0.globales     // Catch:{ Exception -> 0x06a5 }
            r4 = 1
            java.io.File r2 = r2.getTempFile(r0, r4)     // Catch:{ Exception -> 0x06a5 }
            stikerwap.appdys.config r4 = r0.globales     // Catch:{ Exception -> 0x06a5 }
            r5 = 2
            java.io.File r4 = r4.getExtTempFile(r0, r5)     // Catch:{ Exception -> 0x06a5 }
            stikerwap.appdys.config.copy(r2, r4)     // Catch:{ Exception -> 0x06a5 }
        L_0x06b8:
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fb_modo
            r4 = 8
            r5 = 1
            if (r2 == r5) goto L_0x06c8
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fb_modo
            r5 = 2
            if (r2 != r5) goto L_0x0777
        L_0x06c8:
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r5 = "logineado_fb"
            r11 = 0
            boolean r2 = r2.getBoolean(r5, r11)
            if (r2 != 0) goto L_0x0777
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.login_tipo
            r5 = 2131363493(0x7f0a06a5, float:1.8346796E38)
            r11 = 1
            if (r2 == r11) goto L_0x071b
            r2 = 2131362462(0x7f0a029e, float:1.8344705E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.Button r2 = (android.widget.Button) r2
            com.facebook.CallbackManager r11 = com.facebook.CallbackManager.Factory.create()     // Catch:{ Exception -> 0x0710 }
            r0.callbackManager = r11     // Catch:{ Exception -> 0x0710 }
            com.facebook.login.widget.LoginButton r11 = new com.facebook.login.widget.LoginButton     // Catch:{ Exception -> 0x0710 }
            r11.<init>(r0)     // Catch:{ Exception -> 0x0710 }
            r0.loginButton = r11     // Catch:{ Exception -> 0x0710 }
            java.lang.String r12 = "public_profile"
            java.lang.String[] r12 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x0710 }
            r11.setReadPermissions((java.lang.String[]) r12)     // Catch:{ Exception -> 0x0710 }
            com.facebook.login.widget.LoginButton r11 = r0.loginButton     // Catch:{ Exception -> 0x0710 }
            com.facebook.CallbackManager r12 = r0.callbackManager     // Catch:{ Exception -> 0x0710 }
            stikerwap.appdys.chat_perfil$3 r7 = new stikerwap.appdys.chat_perfil$3     // Catch:{ Exception -> 0x0710 }
            r7.<init>()     // Catch:{ Exception -> 0x0710 }
            r11.registerCallback(r12, r7)     // Catch:{ Exception -> 0x0710 }
            stikerwap.appdys.chat_perfil$4 r7 = new stikerwap.appdys.chat_perfil$4     // Catch:{ Exception -> 0x0710 }
            r7.<init>()     // Catch:{ Exception -> 0x0710 }
            r2.setOnClickListener(r7)     // Catch:{ Exception -> 0x0710 }
        L_0x0710:
            r7 = 0
            r2.setVisibility(r7)
            android.view.View r2 = r0.findViewById(r5)
            r2.setVisibility(r7)
        L_0x071b:
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.login_tipo
            if (r2 == 0) goto L_0x0751
            com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder r2 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r7 = com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN
            r2.<init>(r7)
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r2 = r2.build()
            com.google.android.gms.auth.api.signin.GoogleSignInClient r2 = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient((android.app.Activity) r0, (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r2)
            r7 = 2131362466(0x7f0a02a2, float:1.8344713E38)
            android.view.View r7 = r0.findViewById(r7)
            stikerwap.appdys.chat_perfil$5 r11 = new stikerwap.appdys.chat_perfil$5
            r11.<init>(r2)
            r7.setOnClickListener(r11)
            r2 = 2131362466(0x7f0a02a2, float:1.8344713E38)
            android.view.View r2 = r0.findViewById(r2)
            r7 = 0
            r2.setVisibility(r7)
            android.view.View r2 = r0.findViewById(r5)
            r2.setVisibility(r7)
        L_0x0751:
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fb_modo
            r7 = 2
            if (r2 != r7) goto L_0x0777
            boolean r2 = r0.nuevo
            if (r2 == 0) goto L_0x0777
            android.view.View r2 = r0.findViewById(r5)
            r2.setVisibility(r4)
            r2 = 2131362575(0x7f0a030f, float:1.8344934E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
            r2 = 2131362568(0x7f0a0308, float:1.834492E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
        L_0x0777:
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fb_modo
            r5 = 3
            if (r2 != r5) goto L_0x0812
            boolean r2 = r0.email_confirmado
            if (r2 == 0) goto L_0x07c9
            android.view.View r2 = r0.findViewById(r15)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r5 = 0
            r2.setEnabled(r5)
            android.view.View r2 = r0.findViewById(r15)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            android.widget.EditText r2 = r2.getEditText()
            android.content.SharedPreferences r5 = r0.settings
            java.lang.String r7 = "email"
            java.lang.String r5 = r5.getString(r7, r6)
            r2.setText(r5)
            android.view.View r2 = r0.findViewById(r14)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            android.widget.EditText r2 = r2.getEditText()
            java.lang.String r5 = "****"
            r2.setText(r5)
            android.view.View r2 = r0.findViewById(r14)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r5 = 0
            r2.setEnabled(r5)
            android.view.View r2 = r0.findViewById(r10)
            r2.setOnClickListener(r0)
            android.view.View r2 = r0.findViewById(r10)
            r2.setVisibility(r5)
            goto L_0x0804
        L_0x07c9:
            r5 = 0
            android.view.View r2 = r0.findViewById(r15)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            android.widget.EditText r2 = r2.getEditText()
            android.content.SharedPreferences r7 = r0.settings
            java.lang.String r10 = "email"
            java.lang.String r7 = r7.getString(r10, r6)
            r2.setText(r7)
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r7 = "mostrar_recordarcontra"
            boolean r2 = r2.getBoolean(r7, r5)
            if (r2 == 0) goto L_0x07f8
            android.view.View r2 = r0.findViewById(r9)
            r2.setOnClickListener(r0)
            android.view.View r2 = r0.findViewById(r9)
            r2.setVisibility(r5)
            goto L_0x0804
        L_0x07f8:
            android.view.View r2 = r0.findViewById(r14)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r7 = 2131886304(0x7f1200e0, float:1.9407183E38)
            r2.setHint((int) r7)
        L_0x0804:
            android.view.View r2 = r0.findViewById(r15)
            r2.setVisibility(r5)
            android.view.View r2 = r0.findViewById(r14)
            r2.setVisibility(r5)
        L_0x0812:
            int r2 = r0.fotos_perfil
            r5 = 2131361990(0x7f0a00c6, float:1.8343748E38)
            if (r2 != 0) goto L_0x0820
            android.view.View r2 = r0.findViewById(r5)
            r2.setVisibility(r4)
        L_0x0820:
            int r2 = r0.descr
            if (r2 != 0) goto L_0x082c
            android.view.View r2 = r0.findViewById(r13)
            r2.setVisibility(r4)
            goto L_0x0839
        L_0x082c:
            r7 = 2
            if (r2 != r7) goto L_0x0839
            android.view.View r2 = r0.findViewById(r13)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r7 = 0
            r2.setHelperTextEnabled(r7)
        L_0x0839:
            int r2 = r0.fnac
            if (r2 != 0) goto L_0x0848
            r2 = 2131362600(0x7f0a0328, float:1.8344985E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
            goto L_0x0865
        L_0x0848:
            r7 = 2
            if (r2 != r7) goto L_0x0865
            r2 = 2131362026(0x7f0a00ea, float:1.834382E38)
            android.view.View r7 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            r9 = 0
            r7.setHelperTextEnabled(r9)
            r7 = 2131362025(0x7f0a00e9, float:1.8343819E38)
            android.view.View r10 = r0.findViewById(r7)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r10.setHelperTextEnabled(r9)
            goto L_0x0869
        L_0x0865:
            r2 = 2131362026(0x7f0a00ea, float:1.834382E38)
            r9 = 0
        L_0x0869:
            stikerwap.appdys.config r7 = r0.globales
            boolean r7 = r7.fnac_completa
            if (r7 == 0) goto L_0x08a2
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r9)
            r2 = 2131362027(0x7f0a00eb, float:1.8343823E38)
            android.view.View r7 = r0.findViewById(r2)
            r7.setVisibility(r9)
            r7 = 2131362025(0x7f0a00e9, float:1.8343819E38)
            android.view.View r10 = r0.findViewById(r7)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r10.setHelperTextEnabled(r9)
            android.view.View r7 = r0.findViewById(r7)
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            java.lang.String r9 = " "
            r7.setHint((java.lang.CharSequence) r9)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            java.lang.String r7 = " "
            r2.setHint((java.lang.CharSequence) r7)
        L_0x08a2:
            int r2 = r0.sexo
            if (r2 != 0) goto L_0x08b1
            r7 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            android.view.View r2 = r0.findViewById(r7)
            r2.setVisibility(r4)
            goto L_0x08c1
        L_0x08b1:
            r7 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            r9 = 2
            if (r2 != r9) goto L_0x08c1
            android.view.View r2 = r0.findViewById(r7)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r7 = 0
            r2.setHelperTextEnabled(r7)
        L_0x08c1:
            int r2 = r0.coments
            if (r2 != 0) goto L_0x08cf
            r2 = 2131362021(0x7f0a00e5, float:1.834381E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
        L_0x08cf:
            int r2 = r0.privados
            if (r2 != 0) goto L_0x08dd
            r2 = 2131362032(0x7f0a00f0, float:1.8343833E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
        L_0x08dd:
            stikerwap.appdys.config r2 = r0.globales
            boolean r2 = r2.es_admin
            if (r2 == 0) goto L_0x0933
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_acceso
            r7 = 2
            if (r2 == r7) goto L_0x08f1
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.glob_acceso
            r7 = 4
            if (r2 != r7) goto L_0x0933
        L_0x08f1:
            android.view.View r2 = r0.findViewById(r8)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "<u>"
            r7.<init>(r9)
            android.content.res.Resources r9 = r17.getResources()
            r10 = 2131886475(0x7f12018b, float:1.940753E38)
            java.lang.String r9 = r9.getString(r10)
            r7.append(r9)
            java.lang.String r9 = "</u>"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            android.text.Spanned r7 = android.text.Html.fromHtml(r7)
            r2.setText(r7)
            android.view.View r2 = r0.findViewById(r8)
            stikerwap.appdys.chat_perfil$6 r7 = new stikerwap.appdys.chat_perfil$6
            r7.<init>()
            r2.setOnClickListener(r7)
            r2 = 2131363334(0x7f0a0606, float:1.8346474E38)
            android.view.View r2 = r0.findViewById(r2)
            r7 = 0
            r2.setVisibility(r7)
        L_0x0933:
            android.view.View r2 = r0.findViewById(r5)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.btnfotos = r2
            r2.setOnClickListener(r0)
            r2 = 2131362306(0x7f0a0202, float:1.8344389E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
            r0.fl_edit_foto = r2
            r2.setOnClickListener(r0)
            r2 = 2131361987(0x7f0a00c3, float:1.8343742E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r7 = r0.cbtn
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L_0x09f8
            r7 = 2131231189(0x7f0801d5, float:1.8078452E38)
            r2.setBackgroundResource(r7)
            android.graphics.drawable.Drawable r7 = r2.getBackground()
            android.graphics.drawable.GradientDrawable r7 = (android.graphics.drawable.GradientDrawable) r7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r7.setColor(r8)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r3)
            java.lang.String r8 = r0.cbtn
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            boolean r7 = stikerwap.appdys.config.esClaro(r7)
            if (r7 == 0) goto L_0x0997
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.setTextColor(r7)
        L_0x0997:
            android.content.res.Resources r7 = r17.getResources()
            r8 = 2131231066(0x7f08015a, float:1.8078203E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r8)
            java.lang.String r8 = r0.cbtn
            boolean r8 = r8.equals(r6)
            if (r8 != 0) goto L_0x09c1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r9 = r0.cbtn
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r9 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r8, r9)
        L_0x09c1:
            r8 = 2131362192(0x7f0a0190, float:1.8344158E38)
            android.view.View r8 = r0.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r3)
            java.lang.String r8 = r0.cbtn
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            boolean r7 = stikerwap.appdys.config.esClaro(r7)
            if (r7 == 0) goto L_0x09f8
            r7 = 2131362193(0x7f0a0191, float:1.834416E38)
            android.view.View r7 = r0.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131230920(0x7f0800c8, float:1.8077906E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r9)
            r7.setImageDrawable(r8)
        L_0x09f8:
            r2.setOnClickListener(r0)
            r2 = 2131361994(0x7f0a00ca, float:1.8343756E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7 = 2131231189(0x7f0801d5, float:1.8078452E38)
            r2.setBackgroundResource(r7)
            android.graphics.drawable.Drawable r7 = r2.getBackground()
            android.graphics.drawable.GradientDrawable r7 = (android.graphics.drawable.GradientDrawable) r7
            java.lang.String r8 = "#666666"
            int r8 = android.graphics.Color.parseColor(r8)
            r7.setColor(r8)
            boolean r7 = r0.desde_main_oblig
            if (r7 != 0) goto L_0x0ab7
            int r7 = r0.galeria
            r8 = 1
            if (r7 == r8) goto L_0x0a2c
            int r7 = r0.coments
            if (r7 == r8) goto L_0x0a2c
            stikerwap.appdys.config r7 = r0.globales
            boolean r7 = r7.galeriav
            if (r7 == 0) goto L_0x0ab7
        L_0x0a2c:
            int r7 = r0.galeria
            if (r7 == r8) goto L_0x0a36
            stikerwap.appdys.config r7 = r0.globales
            boolean r7 = r7.galeriav
            if (r7 == 0) goto L_0x0a70
        L_0x0a36:
            int r7 = r0.coments
            if (r7 != r8) goto L_0x0a70
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131886473(0x7f120189, float:1.9407526E38)
            java.lang.String r8 = r8.getString(r9)
            java.lang.String r8 = r8.toUpperCase()
            r7.append(r8)
            java.lang.String r8 = "/"
            r7.append(r8)
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131886631(0x7f120227, float:1.9407846E38)
            java.lang.String r8 = r8.getString(r9)
            java.lang.String r8 = r8.toUpperCase()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r2.setText(r7)
            goto L_0x0ab3
        L_0x0a70:
            int r7 = r0.galeria
            r8 = 1
            if (r7 == r8) goto L_0x0a7b
            stikerwap.appdys.config r7 = r0.globales
            boolean r7 = r7.galeriav
            if (r7 == 0) goto L_0x0a92
        L_0x0a7b:
            int r7 = r0.coments
            if (r7 != 0) goto L_0x0a92
            android.content.res.Resources r7 = r17.getResources()
            r8 = 2131886473(0x7f120189, float:1.9407526E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r7 = r7.toUpperCase()
            r2.setText(r7)
            goto L_0x0ab3
        L_0x0a92:
            int r7 = r0.galeria
            if (r7 != 0) goto L_0x0ab3
            stikerwap.appdys.config r7 = r0.globales
            boolean r7 = r7.galeriav
            if (r7 != 0) goto L_0x0ab3
            int r7 = r0.coments
            r8 = 1
            if (r7 != r8) goto L_0x0ab3
            android.content.res.Resources r7 = r17.getResources()
            r8 = 2131886260(0x7f1200b4, float:1.9407094E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r7 = r7.toUpperCase()
            r2.setText(r7)
        L_0x0ab3:
            r2.setOnClickListener(r0)
            goto L_0x0aba
        L_0x0ab7:
            r2.setVisibility(r4)
        L_0x0aba:
            r2 = 2131361983(0x7f0a00bf, float:1.8343734E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            boolean r7 = r0.nuevo
            if (r7 != 0) goto L_0x0aea
            r2.setOnClickListener(r0)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r3)
            java.lang.String r8 = r0.c2
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            boolean r7 = stikerwap.appdys.config.esClaro(r7)
            if (r7 == 0) goto L_0x0ae4
            int r7 = stikerwap.appdys.config.GRIS_OSCURO
            r2.setTextColor(r7)
            goto L_0x0aed
        L_0x0ae4:
            int r7 = stikerwap.appdys.config.GRIS_CLARO
            r2.setTextColor(r7)
            goto L_0x0aed
        L_0x0aea:
            r2.setVisibility(r4)
        L_0x0aed:
            r2 = 2131361992(0x7f0a00c8, float:1.8343752E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7 = 2131361993(0x7f0a00c9, float:1.8343754E38)
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            stikerwap.appdys.config r8 = r0.globales
            boolean r8 = r8.privacy_mostrar
            if (r8 != 0) goto L_0x0b10
            stikerwap.appdys.config r8 = r0.globales
            boolean r8 = r8.aviso_cookies
            if (r8 == 0) goto L_0x0b0c
            goto L_0x0b10
        L_0x0b0c:
            r2.setVisibility(r4)
            goto L_0x0b64
        L_0x0b10:
            stikerwap.appdys.config r8 = r0.globales
            int r8 = r8.fb_modo
            r9 = 2
            if (r8 != r9) goto L_0x0b42
            boolean r8 = r0.nuevo
            if (r8 == 0) goto L_0x0b42
            r7.setOnClickListener(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r3 = r0.c2
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            if (r2 == 0) goto L_0x0b38
            int r2 = stikerwap.appdys.config.GRIS_OSCURO
            r7.setTextColor(r2)
            goto L_0x0b3d
        L_0x0b38:
            int r2 = stikerwap.appdys.config.GRIS_CLARO
            r7.setTextColor(r2)
        L_0x0b3d:
            r2 = 0
            r7.setVisibility(r2)
            goto L_0x0b64
        L_0x0b42:
            r2.setOnClickListener(r0)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r3)
            java.lang.String r3 = r0.c2
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            boolean r3 = stikerwap.appdys.config.esClaro(r3)
            if (r3 == 0) goto L_0x0b5f
            int r3 = stikerwap.appdys.config.GRIS_OSCURO
            r2.setTextColor(r3)
            goto L_0x0b64
        L_0x0b5f:
            int r3 = stikerwap.appdys.config.GRIS_CLARO
            r2.setTextColor(r3)
        L_0x0b64:
            r2 = 2131362328(0x7f0a0218, float:1.8344433E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.foto1 = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.res.Resources r3 = r17.getResources()
            r7 = 2131886321(0x7f1200f1, float:1.9407218E38)
            java.lang.String r3 = r3.getString(r7)
            r2.add(r3)
            r3 = 1
        L_0x0b83:
            r7 = 32
            if (r3 >= r7) goto L_0x0b9c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            r2.add(r7)
            int r3 = r3 + 1
            goto L_0x0b83
        L_0x0b9c:
            r3 = 2131362323(0x7f0a0213, float:1.8344423E38)
            android.view.View r3 = r0.findViewById(r3)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r3
            r0.spinner_d = r3
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r7 = 17367043(0x1090003, float:2.5162934E-38)
            r3.<init>(r0, r7, r2)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_d
            r2.setAdapter(r3)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_d
            stikerwap.appdys.chat_perfil$7 r8 = new stikerwap.appdys.chat_perfil$7
            r8.<init>()
            r2.setOnItemClickListener(r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.res.Resources r8 = r17.getResources()
            r9 = 2131886539(0x7f1201cb, float:1.940766E38)
            java.lang.String r8 = r8.getString(r9)
            r2.add(r8)
            java.util.Calendar r8 = java.util.Calendar.getInstance()
            r9 = 5
            r10 = 1
            r8.set(r9, r10)
            r9 = 0
        L_0x0bdb:
            r11 = 12
            if (r9 >= r11) goto L_0x0c12
            r11 = 2
            r8.set(r11, r9)
            java.util.Locale r12 = java.util.Locale.getDefault()
            java.lang.String r12 = r8.getDisplayName(r11, r10, r12)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0c0b }
            r11.<init>()     // Catch:{ Exception -> 0x0c0b }
            r14 = 0
            java.lang.String r15 = r12.substring(r14, r10)     // Catch:{ Exception -> 0x0c0b }
            java.util.Locale r14 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0c0b }
            java.lang.String r14 = r15.toUpperCase(r14)     // Catch:{ Exception -> 0x0c0b }
            r11.append(r14)     // Catch:{ Exception -> 0x0c0b }
            java.lang.String r14 = r12.substring(r10)     // Catch:{ Exception -> 0x0c0b }
            r11.append(r14)     // Catch:{ Exception -> 0x0c0b }
            java.lang.String r12 = r11.toString()     // Catch:{ Exception -> 0x0c0b }
        L_0x0c0b:
            r2.add(r12)
            int r9 = r9 + 1
            r10 = 1
            goto L_0x0bdb
        L_0x0c12:
            r8 = 2131362324(0x7f0a0214, float:1.8344425E38)
            android.view.View r8 = r0.findViewById(r8)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r8 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r8
            r0.spinner_m = r8
            android.widget.ArrayAdapter r8 = new android.widget.ArrayAdapter
            r8.<init>(r0, r7, r2)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_m
            r2.setAdapter(r8)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_m
            stikerwap.appdys.chat_perfil$8 r9 = new stikerwap.appdys.chat_perfil$8
            r9.<init>()
            r2.setOnItemClickListener(r9)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.res.Resources r9 = r17.getResources()
            r10 = 2131886126(0x7f12002e, float:1.9406822E38)
            java.lang.String r9 = r9.getString(r10)
            r2.add(r9)
            java.util.Calendar r9 = java.util.Calendar.getInstance()
            r10 = 14
        L_0x0c4a:
            r11 = 100
            if (r10 >= r11) goto L_0x0c69
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r12 = 1
            int r14 = r9.get(r12)
            int r14 = r14 - r10
            r11.append(r14)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            r2.add(r11)
            int r10 = r10 + 1
            goto L_0x0c4a
        L_0x0c69:
            r9 = 2131362322(0x7f0a0212, float:1.8344421E38)
            android.view.View r9 = r0.findViewById(r9)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r9 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r9
            r0.spinner_a = r9
            android.widget.ArrayAdapter r9 = new android.widget.ArrayAdapter
            r9.<init>(r0, r7, r2)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_a
            r2.setAdapter(r9)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_a
            stikerwap.appdys.chat_perfil$9 r10 = new stikerwap.appdys.chat_perfil$9
            r10.<init>()
            r2.setOnItemClickListener(r10)
            r2 = 2131363169(0x7f0a0561, float:1.834614E38)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r2
            r0.spinner_sexo = r2
            r2 = 2130903084(0x7f03002c, float:1.7412976E38)
            android.widget.ArrayAdapter r2 = android.widget.ArrayAdapter.createFromResource(r0, r2, r7)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r10 = r0.spinner_sexo
            r10.setAdapter(r2)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r10 = r0.spinner_sexo
            stikerwap.appdys.chat_perfil$10 r11 = new stikerwap.appdys.chat_perfil$10
            r11.<init>()
            r10.setOnItemClickListener(r11)
            r10 = 2131362112(0x7f0a0140, float:1.8343995E38)
            android.view.View r10 = r0.findViewById(r10)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r10 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r10
            r0.spinner_coments = r10
            r10 = 2130903058(0x7f030012, float:1.7412923E38)
            android.widget.ArrayAdapter r10 = android.widget.ArrayAdapter.createFromResource(r0, r10, r7)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r11 = r0.spinner_coments
            r11.setAdapter(r10)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r11 = r0.spinner_coments
            stikerwap.appdys.chat_perfil$11 r12 = new stikerwap.appdys.chat_perfil$11
            r12.<init>()
            r11.setOnItemClickListener(r12)
            r11 = 2131363072(0x7f0a0500, float:1.8345942E38)
            android.view.View r11 = r0.findViewById(r11)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r11 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r11
            r0.spinner_privados = r11
            r11 = 2130903083(0x7f03002b, float:1.7412974E38)
            android.widget.ArrayAdapter r11 = android.widget.ArrayAdapter.createFromResource(r0, r11, r7)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = r0.spinner_privados
            r12.setAdapter(r11)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = r0.spinner_privados
            stikerwap.appdys.chat_perfil$12 r14 = new stikerwap.appdys.chat_perfil$12
            r14.<init>()
            r12.setOnItemClickListener(r14)
            r12 = 2131361945(0x7f0a0099, float:1.8343657E38)
            android.view.View r12 = r0.findViewById(r12)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = (com.google.android.material.textfield.MaterialAutoCompleteTextView) r12
            r0.spinner_avisos = r12
            r12 = 2130903040(0x7f030000, float:1.7412887E38)
            android.widget.ArrayAdapter r7 = android.widget.ArrayAdapter.createFromResource(r0, r12, r7)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = r0.spinner_avisos
            r12.setAdapter(r7)
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = r0.spinner_avisos
            stikerwap.appdys.chat_perfil$13 r14 = new stikerwap.appdys.chat_perfil$13
            r14.<init>()
            r12.setOnItemClickListener(r14)
            android.content.SharedPreferences r12 = r0.settings
            java.lang.String r14 = "fnac_d"
            r15 = 0
            int r12 = r12.getInt(r14, r15)
            stikerwap.appdys.config r14 = r0.globales
            boolean r14 = r14.fnac_completa
            if (r14 != 0) goto L_0x0d1d
            if (r12 != 0) goto L_0x0d1d
            r12 = 1
        L_0x0d1d:
            r0.pos_d = r12
            if (r12 <= 0) goto L_0x0d32
            com.google.android.material.textfield.MaterialAutoCompleteTextView r14 = r0.spinner_d
            java.lang.Object r3 = r3.getItem(r12)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.toString()
            r12 = 0
            r14.setText(r3, r12)
            goto L_0x0d38
        L_0x0d32:
            r12 = 0
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = r0.spinner_d
            r3.setText(r6, r12)
        L_0x0d38:
            android.content.SharedPreferences r3 = r0.settings
            java.lang.String r14 = "fnac_m"
            int r3 = r3.getInt(r14, r12)
            stikerwap.appdys.config r12 = r0.globales
            boolean r12 = r12.fnac_completa
            if (r12 != 0) goto L_0x0d49
            if (r3 != 0) goto L_0x0d49
            r3 = 1
        L_0x0d49:
            r0.pos_m = r3
            if (r3 <= 0) goto L_0x0d5e
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = r0.spinner_m
            java.lang.Object r3 = r8.getItem(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.toString()
            r8 = 0
            r12.setText(r3, r8)
            goto L_0x0d64
        L_0x0d5e:
            r8 = 0
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = r0.spinner_m
            r3.setText(r6, r8)
        L_0x0d64:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.SharedPreferences r12 = r0.settings
            java.lang.String r14 = "fnac_a"
            int r12 = r12.getInt(r14, r8)
            r3.append(r12)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            int r3 = r9.getPosition(r3)
            r8 = -1
            if (r3 != r8) goto L_0x0d83
            r3 = 0
        L_0x0d83:
            r0.pos_a = r3
            if (r3 <= 0) goto L_0x0d98
            com.google.android.material.textfield.MaterialAutoCompleteTextView r8 = r0.spinner_a
            java.lang.Object r3 = r9.getItem(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.toString()
            r9 = 0
            r8.setText(r3, r9)
            goto L_0x0d9e
        L_0x0d98:
            r9 = 0
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = r0.spinner_a
            r3.setText(r6, r9)
        L_0x0d9e:
            r3 = 2130903080(0x7f030028, float:1.7412968E38)
            r8 = 17367048(0x1090008, float:2.5162948E-38)
            android.widget.ArrayAdapter r3 = android.widget.ArrayAdapter.createFromResource(r0, r3, r8)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            android.content.SharedPreferences r14 = r0.settings
            java.lang.String r15 = "sexo"
            int r14 = r14.getInt(r15, r9)
            r12.append(r14)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            int r3 = r3.getPosition(r12)
            r0.pos_sexo = r3
            if (r3 <= 0) goto L_0x0dd7
            com.google.android.material.textfield.MaterialAutoCompleteTextView r12 = r0.spinner_sexo
            java.lang.Object r2 = r2.getItem(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r2 = r2.toString()
            r12.setText(r2, r9)
            goto L_0x0ddc
        L_0x0dd7:
            com.google.android.material.textfield.MaterialAutoCompleteTextView r2 = r0.spinner_sexo
            r2.setText(r6, r9)
        L_0x0ddc:
            r2 = 2130903078(0x7f030026, float:1.7412964E38)
            android.widget.ArrayAdapter r2 = android.widget.ArrayAdapter.createFromResource(r0, r2, r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.SharedPreferences r9 = r0.settings
            java.lang.String r12 = "coments"
            r14 = 1
            int r9 = r9.getInt(r12, r14)
            r3.append(r9)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            int r2 = r2.getPosition(r3)
            r0.pos_coments = r2
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = r0.spinner_coments
            java.lang.Object r2 = r10.getItem(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r2 = r2.toString()
            r9 = 0
            r3.setText(r2, r9)
            r2 = 2130903079(0x7f030027, float:1.7412966E38)
            android.widget.ArrayAdapter r2 = android.widget.ArrayAdapter.createFromResource(r0, r2, r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.SharedPreferences r9 = r0.settings
            java.lang.String r10 = "privados"
            r12 = 1
            int r9 = r9.getInt(r10, r12)
            r3.append(r9)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            int r2 = r2.getPosition(r3)
            r0.pos_privados = r2
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = r0.spinner_privados
            java.lang.Object r2 = r11.getItem(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r2 = r2.toString()
            r9 = 0
            r3.setText(r2, r9)
            r2 = 2130903062(0x7f030016, float:1.7412931E38)
            android.widget.ArrayAdapter r2 = android.widget.ArrayAdapter.createFromResource(r0, r2, r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.SharedPreferences r8 = r0.settings
            java.lang.String r9 = "avisos"
            r10 = 1
            int r8 = r8.getInt(r9, r10)
            r3.append(r8)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            int r2 = r2.getPosition(r3)
            r0.pos_avisos = r2
            com.google.android.material.textfield.MaterialAutoCompleteTextView r3 = r0.spinner_avisos
            java.lang.Object r2 = r7.getItem(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r2 = r2.toString()
            r7 = 0
            r3.setText(r2, r7)
            r2 = 2131362029(0x7f0a00ed, float:1.8343827E38)
            android.view.View r3 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            android.widget.EditText r2 = r3.getEditText()
            android.content.SharedPreferences r3 = r0.settings
            java.lang.String r7 = "nick"
            java.lang.String r3 = r3.getString(r7, r6)
            r2.setText(r3)
            android.view.View r2 = r0.findViewById(r13)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            android.widget.EditText r2 = r2.getEditText()
            android.content.SharedPreferences r3 = r0.settings
            java.lang.String r7 = "descr"
            java.lang.String r3 = r3.getString(r7, r6)
            r2.setText(r3)
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fb_modo
            r3 = 1
            if (r2 == r3) goto L_0x0eb6
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fb_modo
            r3 = 2
            if (r2 != r3) goto L_0x0f17
        L_0x0eb6:
            stikerwap.appdys.config r2 = r0.globales
            boolean r2 = r2.fb_bloqdatos
            if (r2 == 0) goto L_0x0f17
            android.content.SharedPreferences r2 = r0.settings
            java.lang.String r3 = "logineado_fb"
            r7 = 0
            boolean r2 = r2.getBoolean(r3, r7)
            if (r2 == 0) goto L_0x0f17
            r2 = 2131362029(0x7f0a00ed, float:1.8343827E38)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r2.setEnabled(r7)
            int r2 = r0.pos_sexo
            if (r2 <= 0) goto L_0x0ee3
            r2 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            android.view.View r2 = r0.findViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            r2.setEnabled(r7)
        L_0x0ee3:
            android.view.View r2 = r0.findViewById(r5)
            r2.setVisibility(r4)
            stikerwap.appdys.config r2 = r0.globales
            r3 = 1
            java.io.File r2 = r2.getTempFile(r0, r3)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0ef8
            goto L_0x0f17
        L_0x0ef8:
            r2 = 2131362306(0x7f0a0202, float:1.8344389E38)
            android.view.View r2 = r0.findViewById(r2)
            r3 = 0
            r2.setVisibility(r3)
            r2 = 2131362192(0x7f0a0190, float:1.8344158E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
            r2 = 2131362193(0x7f0a0191, float:1.834416E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r4)
        L_0x0f17:
            java.lang.String r2 = "0"
            r0.foto1_modif = r2
            if (r1 == 0) goto L_0x0f2d
            java.lang.String r2 = "foto1_modif_saved"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0f2d
            java.lang.String r2 = "foto1_modif_saved"
            java.lang.String r1 = r1.getString(r2)
            r0.foto1_modif = r1
        L_0x0f2d:
            stikerwap.appdys.config r1 = r0.globales
            r2 = 2
            java.io.File r1 = r1.getExtTempFile(r0, r2)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x0f46
            r1 = 1
            r0.mostrar_foto_p(r2, r1)
            boolean r1 = r0.nuevo
            if (r1 == 0) goto L_0x0f46
            java.lang.String r1 = "1"
            r0.foto1_modif = r1
        L_0x0f46:
            int r1 = r17.contar_fotos()
            r0.nfotos = r1
            android.os.Bundle r1 = r0.extras
            java.lang.String r2 = "nocompletar"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)
            if (r1 != 0) goto L_0x0fae
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.fb_modo
            r2 = 2
            if (r1 != r2) goto L_0x0f62
            boolean r1 = r0.nuevo
            if (r1 != 0) goto L_0x0fae
        L_0x0f62:
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r1.<init>(r0)
            r2 = 0
            android.app.AlertDialog$Builder r1 = r1.setCancelable(r2)
            r2 = 2131886114(0x7f120022, float:1.9406798E38)
            java.lang.String r2 = r0.getString(r2)
            stikerwap.appdys.chat_perfil$14 r3 = new stikerwap.appdys.chat_perfil$14
            r3.<init>()
            android.app.AlertDialog$Builder r1 = r1.setPositiveButton(r2, r3)
            r2 = 1
            android.app.AlertDialog$Builder r1 = r1.setCancelable(r2)
            r2 = 2131886281(0x7f1200c9, float:1.9407136E38)
            android.app.AlertDialog$Builder r1 = r1.setMessage(r2)
            android.app.AlertDialog r1 = r1.create()
            java.lang.String r2 = r0.cbtn
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0f9c
            stikerwap.appdys.chat_perfil$15 r2 = new stikerwap.appdys.chat_perfil$15
            r2.<init>(r1)
            r1.setOnShowListener(r2)
        L_0x0f9c:
            r1.show()
            r2 = 16908299(0x102000b, float:2.387726E-38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x0fb9 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x0fb9 }
            android.graphics.Typeface r2 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0fb9 }
            r1.setTypeface(r2)     // Catch:{ Exception -> 0x0fb9 }
            goto L_0x0fb9
        L_0x0fae:
            android.view.Window r1 = r17.getWindow()
            r2 = 2
            r1.setSoftInputMode(r2)
            r17.pedir_permisos()
        L_0x0fb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.chat_perfil.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void invitar() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", this.globales.share_subject);
        intent.putExtra("android.intent.extra.TEXT", (this.globales.share_text + "\n\n" + getResources().getString(R.string.codigo_invit) + " " + this.codigo_invit) + "\n\n" + getResources().getString(R.string.codigo_invit_val));
        startActivity(Intent.createChooser(intent, getString(R.string.compartir)));
    }

    private class codigo_generar extends AsyncTask<String, Void, String> {
        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        private codigo_generar() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/codigo_generar.php?idusu=" + chat_perfil.this.idusu + "&c=" + chat_perfil.this.codigo);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            String str = "";
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                if (entity != null) {
                    str = EntityUtils.toString(entity);
                }
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            AlertDialog.Builder builder = new AlertDialog.Builder(chat_perfil.this);
            builder.setCancelable(false).setPositiveButton(chat_perfil.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
            int indexOf = str.indexOf("ANDROID:OK COD:");
            if (indexOf != -1) {
                int i = indexOf + 15;
                int indexOf2 = str.indexOf("-", i);
                if (indexOf2 != -1) {
                    chat_perfil.this.codigo_invit = str.substring(i, indexOf2);
                    chat_perfil.this.invitar();
                    return;
                }
                return;
            }
            builder.setMessage(R.string.error_http);
            final AlertDialog create = builder.create();
            if (!chat_perfil.this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
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

    /* access modifiers changed from: protected */
    public void pedir_permisos() {
        if (this.settings.contains("pp_aceptada")) {
            pedir_permisos_2();
        } else if (this.globales.aviso_cookies || this.globales.privacy_mostrar_2) {
            new cargarprivacidad(true).execute(new String[0]);
        } else {
            pedir_permisos_2();
        }
    }

    /* access modifiers changed from: protected */
    public void pedir_permisos_2() {
        int i;
        String[] strArr = new String[3];
        boolean z = true;
        if (!config.p_location(this) || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            i = 0;
        } else {
            strArr[0] = "android.permission.ACCESS_FINE_LOCATION";
            strArr[1] = "android.permission.ACCESS_COARSE_LOCATION";
            i = 2;
        }
        if (i > 0) {
            String[] strArr2 = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                strArr2[i2] = strArr[i2];
            }
            ActivityCompat.requestPermissions(this, strArr2, 3);
            return;
        }
        config config = this.globales;
        Bundle bundle = this.extras;
        boolean z2 = bundle != null && bundle.containsKey("ad_entrar");
        Bundle bundle2 = this.extras;
        if (bundle2 == null || !bundle2.containsKey("fb_entrar")) {
            z = false;
        }
        config.toca_int_2(this, z2, z, false);
    }

    private int contar_fotos() {
        return this.globales.getExtTempFile(this, 2).exists() ? 1 : 0;
    }

    private void tomar_foto() {
        this.foto1_modif = "1";
        final AlertDialog create = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.tomardecamara), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!chat_perfil.this.globales.tener_que_pedir_p_camara(chat_perfil.this, 107)) {
                    chat_perfil.this.captureTime = Long.valueOf(System.currentTimeMillis());
                    config config = chat_perfil.this.globales;
                    chat_perfil chat_perfil = chat_perfil.this;
                    config.iniciar_tomardecamara(chat_perfil, chat_perfil.globales.getExtTempFile(chat_perfil.this, 2));
                }
            }
        }).setNegativeButton(getString(R.string.tomardesd), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                chat_perfil.this.startActivityForResult(intent, 2);
            }
        }).setMessage(R.string.tomarfoto).create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 107) {
            if (iArr == null || iArr.length <= 0 || !strArr[0].equals("android.permission.CAMERA") || iArr[0] != 0) {
                config.mostrar_error(this, "", getResources().getString(R.string.permisos), this.cbtn);
                return;
            }
            this.captureTime = Long.valueOf(System.currentTimeMillis());
            config config = this.globales;
            config.iniciar_tomardecamara(this, config.getExtTempFile(this, 2));
        } else if (i == 3) {
            boolean p_location = config.p_location(this);
            if (((p_location && iArr.length > 0 && ((strArr[0].equals("android.permission.ACCESS_FINE_LOCATION") || strArr[0].equals("android.permission.ACCESS_COARSE_LOCATION")) && iArr[0] == 0)) || (p_location && iArr.length > 1 && ((strArr[1].equals("android.permission.ACCESS_FINE_LOCATION") || strArr[1].equals("android.permission.ACCESS_COARSE_LOCATION")) && iArr[1] == 0))) && (getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", getPackageName()) == 0 || getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", getPackageName()) == 0)) {
                try {
                    FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
                    this.fusedLocationClient = fusedLocationProviderClient;
                    fusedLocationProviderClient.getLastLocation().addOnSuccessListener((Activity) this, new OnSuccessListener<Location>() {
                        public void onSuccess(Location location) {
                            if (location != null) {
                                String str = location.getLatitude() + "";
                                SharedPreferences.Editor edit = chat_perfil.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                                edit.putString("x", str);
                                edit.putString("y", location.getLongitude() + "");
                                edit.commit();
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
            if (iArr.length == 0 || ((iArr.length == 1 && iArr[0] == -1) || (iArr.length == 2 && iArr[0] == -1 && iArr[1] == -1))) {
                final AlertDialog create = new AlertDialog.Builder(this).setCancelable(false).setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        chat_perfil.this.finish();
                    }
                }).setMessage(R.string.permisos).create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:85|86|87|(1:91)|92|93|94|95|96|118) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0224 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee A[SYNTHETIC, Splitter:B:45:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012a A[Catch:{ Exception -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0145 A[Catch:{ Exception -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r22, int r23, android.content.Intent r24) {
        /*
            r21 = this;
            r9 = r21
            r0 = r22
            r1 = r23
            r2 = r24
            stikerwap.appdys.config r3 = r9.globales
            if (r3 == 0) goto L_0x0013
            boolean r3 = r3.onActivityResult_glob(r0, r1, r2, r9)
            if (r3 == 0) goto L_0x0013
            return
        L_0x0013:
            r3 = 64206(0xface, float:8.9972E-41)
            if (r0 != r3) goto L_0x001f
            com.facebook.CallbackManager r3 = r9.callbackManager
            r3.onActivityResult(r0, r1, r2)
            goto L_0x0259
        L_0x001f:
            r3 = 104(0x68, float:1.46E-43)
            r10 = 0
            if (r0 != r3) goto L_0x006b
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.auth.api.signin.GoogleSignIn.getSignedInAccountFromIntent(r24)
            java.lang.Class<com.google.android.gms.common.api.ApiException> r1 = com.google.android.gms.common.api.ApiException.class
            java.lang.Object r0 = r0.getResult(r1)     // Catch:{  }
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r0     // Catch:{  }
            android.net.Uri r1 = r0.getPhotoUrl()     // Catch:{  }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0042
            android.net.Uri r1 = r0.getPhotoUrl()     // Catch:{  }
            java.lang.String r1 = r1.toString()     // Catch:{  }
            r8 = r1
            goto L_0x0043
        L_0x0042:
            r8 = r2
        L_0x0043:
            java.lang.String r1 = r0.getIdToken()     // Catch:{  }
            if (r1 == 0) goto L_0x004f
            java.lang.String r1 = r0.getIdToken()     // Catch:{  }
            r3 = r1
            goto L_0x0050
        L_0x004f:
            r3 = r2
        L_0x0050:
            stikerwap.appdys.chat_perfil$guardartk r11 = new stikerwap.appdys.chat_perfil$guardartk     // Catch:{  }
            java.lang.String r4 = ""
            java.lang.String r5 = r0.getId()     // Catch:{  }
            java.lang.String r6 = r0.getDisplayName()     // Catch:{  }
            java.lang.String r7 = "0"
            r1 = r11
            r2 = r21
            r1.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{  }
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{  }
            r11.execute(r0)     // Catch:{  }
            goto L_0x0259
        L_0x006b:
            r3 = -1
            if (r1 != r3) goto L_0x0259
            r1 = 106(0x6a, float:1.49E-43)
            java.lang.String r4 = "orientation"
            r5 = 100
            r6 = 600(0x258, float:8.41E-43)
            r7 = 2
            if (r0 != r1) goto L_0x01c9
            r1 = 1
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00e7 }
            stikerwap.appdys.config r2 = r9.globales     // Catch:{ Exception -> 0x00e7 }
            java.io.File r2 = r2.getExtTempFile(r9, r7)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x00e7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00e7 }
            long r11 = r0.length()     // Catch:{ Exception -> 0x00e7 }
            android.content.Context r0 = r21.getApplicationContext()     // Catch:{ Exception -> 0x00e7 }
            android.content.ContentResolver r13 = r0.getContentResolver()     // Catch:{ Exception -> 0x00e7 }
            android.net.Uri r14 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r0 = "_size"
            java.lang.String[] r15 = new java.lang.String[]{r4, r0}     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r16 = "date_added>=?"
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ Exception -> 0x00e7 }
            java.lang.Long r2 = r9.captureTime     // Catch:{ Exception -> 0x00e7 }
            long r17 = r2.longValue()     // Catch:{ Exception -> 0x00e7 }
            r19 = 1000(0x3e8, double:4.94E-321)
            long r17 = r17 / r19
            r19 = 1
            long r17 = r17 - r19
            java.lang.String r2 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x00e7 }
            r0[r10] = r2     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r18 = "date_added desc"
            r17 = r0
            android.database.Cursor r0 = r13.query(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x00e7 }
            if (r0 == 0) goto L_0x00e4
            java.lang.Long r2 = r9.captureTime     // Catch:{ Exception -> 0x00e7 }
            long r13 = r2.longValue()     // Catch:{ Exception -> 0x00e7 }
            r15 = 0
            int r2 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r2 == 0) goto L_0x00e4
            int r2 = r0.getCount()     // Catch:{ Exception -> 0x00e7 }
            if (r2 == 0) goto L_0x00e4
        L_0x00d1:
            boolean r2 = r0.moveToNext()     // Catch:{ Exception -> 0x00e7 }
            if (r2 == 0) goto L_0x00e4
            long r13 = r0.getLong(r1)     // Catch:{ Exception -> 0x00e7 }
            int r2 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x00d1
            int r0 = r0.getInt(r10)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00e5
        L_0x00e4:
            r0 = -1
        L_0x00e5:
            r2 = r0
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            r0.printStackTrace()
            r2 = -1
        L_0x00ec:
            if (r2 != r3) goto L_0x0108
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0104 }
            stikerwap.appdys.config r4 = r9.globales     // Catch:{ IOException -> 0x0104 }
            java.io.File r4 = r4.getExtTempFile(r9, r7)     // Catch:{ IOException -> 0x0104 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ IOException -> 0x0104 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0104 }
            java.lang.String r4 = "Orientation"
            int r2 = r0.getAttributeInt(r4, r3)     // Catch:{ IOException -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0108:
            stikerwap.appdys.config r0 = r9.globales     // Catch:{ Exception -> 0x0164 }
            java.io.File r0 = r0.getExtTempFile(r9, r7)     // Catch:{ Exception -> 0x0164 }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0164 }
            r4.<init>()     // Catch:{ Exception -> 0x0164 }
            r4.inJustDecodeBounds = r1     // Catch:{ Exception -> 0x0164 }
            java.lang.String r8 = r0.getPath()     // Catch:{ Exception -> 0x0164 }
            android.graphics.BitmapFactory.decodeFile(r8, r4)     // Catch:{ Exception -> 0x0164 }
            int r8 = r4.outWidth     // Catch:{ Exception -> 0x0164 }
            int r8 = r4.outWidth     // Catch:{ Exception -> 0x0164 }
            int r4 = r4.outHeight     // Catch:{ Exception -> 0x0164 }
            if (r8 > r6) goto L_0x0127
            if (r4 > r6) goto L_0x0127
            goto L_0x0128
        L_0x0127:
            r1 = 0
        L_0x0128:
            if (r1 != 0) goto L_0x0145
            int r1 = stikerwap.appdys.config.calculateNewWidth(r8, r4, r6, r6)     // Catch:{ Exception -> 0x0164 }
            float r4 = (float) r8     // Catch:{ Exception -> 0x0164 }
            float r1 = (float) r1     // Catch:{ Exception -> 0x0164 }
            float r4 = r4 / r1
            int r1 = java.lang.Math.round(r4)     // Catch:{ Exception -> 0x0164 }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0164 }
            r4.<init>()     // Catch:{ Exception -> 0x0164 }
            r4.inSampleSize = r1     // Catch:{ Exception -> 0x0164 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0164 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r4)     // Catch:{ Exception -> 0x0164 }
            goto L_0x0151
        L_0x0145:
            android.content.ContentResolver r1 = r21.getContentResolver()     // Catch:{ Exception -> 0x0164 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception -> 0x0164 }
            android.graphics.Bitmap r0 = android.provider.MediaStore.Images.Media.getBitmap(r1, r0)     // Catch:{ Exception -> 0x0164 }
        L_0x0151:
            stikerwap.appdys.config r1 = r9.globales     // Catch:{ Exception -> 0x0164 }
            java.io.File r1 = r1.getExtTempFile(r9, r7)     // Catch:{ Exception -> 0x0164 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0162 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0162 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0162 }
            r0.compress(r1, r5, r4)     // Catch:{ Exception -> 0x0162 }
            goto L_0x0168
        L_0x0162:
            goto L_0x0168
        L_0x0164:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0168:
            if (r2 == r3) goto L_0x01be
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r1 = 3
            if (r2 != r1) goto L_0x0175
            r1 = 180(0xb4, float:2.52E-43)
            goto L_0x0183
        L_0x0175:
            r1 = 8
            if (r2 != r1) goto L_0x017c
            r1 = 270(0x10e, float:3.78E-43)
            goto L_0x0183
        L_0x017c:
            r1 = 6
            if (r2 != r1) goto L_0x0182
            r1 = 90
            goto L_0x0183
        L_0x0182:
            r1 = 0
        L_0x0183:
            if (r1 <= 0) goto L_0x01be
            stikerwap.appdys.config r2 = r9.globales     // Catch:{ Exception -> 0x01ba }
            java.io.File r2 = r2.getExtTempFile(r9, r7)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x01ba }
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x01ba }
            float r1 = (float) r1     // Catch:{ Exception -> 0x01ba }
            r0.postRotate(r1)     // Catch:{ Exception -> 0x01ba }
            r12 = 0
            r13 = 0
            int r14 = r11.getWidth()     // Catch:{ Exception -> 0x01ba }
            int r15 = r11.getHeight()     // Catch:{ Exception -> 0x01ba }
            r17 = 1
            r16 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x01ba }
            stikerwap.appdys.config r1 = r9.globales     // Catch:{ Exception -> 0x01ba }
            java.io.File r1 = r1.getExtTempFile(r9, r7)     // Catch:{ Exception -> 0x01ba }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01be }
            r2.<init>(r1)     // Catch:{ Exception -> 0x01be }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x01be }
            r0.compress(r1, r5, r2)     // Catch:{ Exception -> 0x01be }
            goto L_0x01be
        L_0x01ba:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01be:
            r9.mostrar_foto_p(r7, r10)
            int r0 = r21.contar_fotos()
            r9.nfotos = r0
            goto L_0x0259
        L_0x01c9:
            if (r0 != r7) goto L_0x0231
            android.net.Uri r0 = r24.getData()
            java.lang.String[] r1 = new java.lang.String[]{r4}     // Catch:{ ApiException -> 0x0259 }
            android.content.ContentResolver r11 = r21.getContentResolver()     // Catch:{ ApiException -> 0x0259 }
            r14 = 0
            r15 = 0
            r16 = 0
            r12 = r0
            r13 = r1
            android.database.Cursor r2 = r11.query(r12, r13, r14, r15, r16)     // Catch:{ ApiException -> 0x0259 }
            if (r2 == 0) goto L_0x01f3
            boolean r4 = r2.moveToFirst()     // Catch:{ ApiException -> 0x0259 }
            if (r4 == 0) goto L_0x01f3
            r1 = r1[r10]     // Catch:{ ApiException -> 0x0259 }
            int r1 = r2.getColumnIndex(r1)     // Catch:{ ApiException -> 0x0259 }
            int r3 = r2.getInt(r1)     // Catch:{ ApiException -> 0x0259 }
        L_0x01f3:
            android.graphics.Matrix r1 = new android.graphics.Matrix     // Catch:{ ApiException -> 0x0259 }
            r1.<init>()     // Catch:{ ApiException -> 0x0259 }
            float r2 = (float) r3     // Catch:{ ApiException -> 0x0259 }
            r1.postRotate(r2)     // Catch:{ ApiException -> 0x0259 }
            stikerwap.appdys.config r2 = r9.globales     // Catch:{ ApiException -> 0x0259 }
            android.graphics.Bitmap r11 = r2.decodeSampledBitmapFromResource(r0, r6, r6)     // Catch:{ ApiException -> 0x0259 }
            r12 = 0
            r13 = 0
            int r14 = r11.getWidth()     // Catch:{ ApiException -> 0x0259 }
            int r15 = r11.getHeight()     // Catch:{ ApiException -> 0x0259 }
            r17 = 1
            r16 = r1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ ApiException -> 0x0259 }
            stikerwap.appdys.config r1 = r9.globales     // Catch:{ ApiException -> 0x0259 }
            java.io.File r1 = r1.getExtTempFile(r9, r7)     // Catch:{ ApiException -> 0x0259 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception | OutOfMemoryError -> 0x0224 }
            r2.<init>(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0224 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception | OutOfMemoryError -> 0x0224 }
            r0.compress(r1, r5, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0224 }
        L_0x0224:
            r0.recycle()     // Catch:{ ApiException -> 0x0259 }
            r9.mostrar_foto_p(r7, r10)     // Catch:{ ApiException -> 0x0259 }
            int r0 = r21.contar_fotos()     // Catch:{ ApiException -> 0x0259 }
            r9.nfotos = r0     // Catch:{ ApiException -> 0x0259 }
            goto L_0x0259
        L_0x0231:
            if (r2 == 0) goto L_0x0259
            java.lang.String r0 = "finalizar"
            boolean r1 = r2.hasExtra(r0)
            if (r1 == 0) goto L_0x0259
            android.os.Bundle r1 = r24.getExtras()
            boolean r0 = r1.getBoolean(r0)
            if (r0 == 0) goto L_0x0259
            android.os.Bundle r0 = r24.getExtras()
            java.lang.String r1 = "finalizar_app"
            boolean r0 = r0.getBoolean(r1)
            if (r0 != 0) goto L_0x0253
            r9.es_root = r10
        L_0x0253:
            r9.setResult(r3, r2)
            r21.finish()
        L_0x0259:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.chat_perfil.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: package-private */
    public void incluir_menu_pre() {
        if (this.desde_main_oblig) {
            this.globales.incluir_menu_2(this, false);
            return;
        }
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

    public void onClick(View view) {
        boolean z;
        boolean z2;
        if (view.getId() == R.id.btnbaja) {
            final AlertDialog create = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(chat_perfil.this, eliminarperfil.class);
                    if (chat_perfil.this.externo) {
                        intent = config.completar_externo(intent, chat_perfil.this.extras);
                    } else {
                        intent.putExtra("idsecc", chat_perfil.this.idsecc);
                    }
                    if (chat_perfil.this.globales.tipomenu != 2 || chat_perfil.this.desde_main_oblig) {
                        intent.putExtra("es_root", true);
                    }
                    intent.putExtra("desde_main", chat_perfil.this.desde_main);
                    intent.putExtra("desde_main_oblig", chat_perfil.this.desde_main_oblig);
                    chat_perfil.this.es_root = false;
                    chat_perfil.this.finalizar = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("finalizar", true);
                    chat_perfil.this.setResult(-1, intent2);
                    chat_perfil.this.startActivity(intent);
                    chat_perfil.this.finish();
                }
            }).setNegativeButton(getString(R.string.no), (DialogInterface.OnClickListener) null).setMessage(R.string.confirmarbaja).create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        Button button2 = create.getButton(-2);
                        button2.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
        } else if (view.getId() == R.id.btnprivacidad || view.getId() == R.id.btnprivacidad_fb) {
            new cargarprivacidad(false).execute(new String[0]);
        } else if (view.getId() == R.id.btnfotos || view.getId() == R.id.fl_edit_foto) {
            tomar_foto();
        } else if (view.getId() == R.id.elim1) {
            this.foto1.setImageBitmap((Bitmap) null);
            this.foto1.setVisibility(8);
            this.elim1.setVisibility(8);
            this.globales.getExtTempFile(this, 2).delete();
            int i = this.nfotos - 1;
            this.nfotos = i;
            this.foto1_modif = "1";
            if (i < 4) {
                this.btnfotos.setVisibility(0);
            }
        } else if (view.getId() == R.id.contra_modif) {
            Dialog crear_dialog_contra = crear_dialog_contra();
            this.dialog_contra = crear_dialog_contra;
            crear_dialog_contra.show();
        } else if (view.getId() == R.id.contra_recordar || view.getId() == R.id.iv_help) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String trim = ((TextInputLayout) findViewById(R.id.c_email)).getEditText().getText().toString().trim();
            if (trim.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
                builder.setCancelable(false).setPositiveButton(getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
                builder.setMessage(R.string.falta_email);
                final AlertDialog create2 = builder.create();
                if (!this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                return;
            }
            builder.setCancelable(true).setNegativeButton(getString(R.string.cancelar), (DialogInterface.OnClickListener) null).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    new recordar_contra().execute(new String[0]);
                }
            });
            builder.setMessage(getResources().getString(R.string.confirm_enviarcontra_a) + " " + trim);
            final AlertDialog create3 = builder.create();
            if (!this.cbtn.equals("")) {
                create3.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create3.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        Button button2 = create3.getButton(-2);
                        button2.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                    }
                });
            }
            create3.show();
            ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } else if (view.getId() == R.id.btnenv) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setCancelable(false).setPositiveButton(getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
            if (((TextInputLayout) findViewById(R.id.c_nombre)).getEditText().getText().toString().trim().length() < 3) {
                builder2.setMessage(R.string.falta_nombre);
                final AlertDialog create4 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create4.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create4.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create4.show();
                ((TextView) create4.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (findViewById(R.id.c_email).getVisibility() == 0 && ((TextInputLayout) findViewById(R.id.c_email)).isEnabled() && (((TextInputLayout) findViewById(R.id.c_email)).getEditText().getText().toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(((TextInputLayout) findViewById(R.id.c_email)).getEditText().getText().toString().trim()).matches())) {
                builder2.setMessage(R.string.falta_email);
                final AlertDialog create5 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create5.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create5.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create5.show();
                ((TextView) create5.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (findViewById(R.id.c_contra).getVisibility() == 0 && ((TextInputLayout) findViewById(R.id.c_contra)).isEnabled() && ((TextInputLayout) findViewById(R.id.c_contra)).getEditText().getText().toString().trim().isEmpty()) {
                builder2.setMessage(R.string.chat_contra_necesaria);
                final AlertDialog create6 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create6.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create6.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create6.show();
                ((TextView) create6.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (((TextInputLayout) findViewById(R.id.c_descr)).getEditText().getText().toString().trim().length() < 3 && this.descr == 2) {
                builder2.setMessage(R.string.falta_descr);
                final AlertDialog create7 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create7.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create7.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create7.show();
                ((TextView) create7.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if ((this.pos_d == 0 || this.pos_m == 0 || this.pos_a == 0) && this.fnac == 2) {
                builder2.setMessage(R.string.falta_fnac);
                final AlertDialog create8 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create8.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create8.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create8.show();
                ((TextView) create8.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (this.pos_sexo == 0 && this.sexo == 2) {
                builder2.setMessage(R.string.falta_sexo);
                final AlertDialog create9 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create9.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create9.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create9.show();
                ((TextView) create9.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (this.nfotos == 0 && this.fotos_perfil == 2) {
                builder2.setMessage(R.string.falta_fotos);
                final AlertDialog create10 = builder2.create();
                if (!this.cbtn.equals("")) {
                    create10.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create10.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create10.show();
                ((TextView) create10.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                SharedPreferences.Editor edit = this.settings.edit();
                edit.putString("nick", ((TextInputLayout) findViewById(R.id.c_nombre)).getEditText().getText().toString().trim());
                edit.putString("email", ((TextInputLayout) findViewById(R.id.c_email)).getEditText().getText().toString().trim());
                edit.putString("descr", ((TextInputLayout) findViewById(R.id.c_descr)).getEditText().getText().toString().trim());
                edit.putInt("fnac_d", this.pos_d);
                edit.putInt("fnac_m", this.pos_m);
                if (this.pos_a == 0) {
                    edit.putInt("fnac_a", 0);
                } else {
                    edit.putInt("fnac_a", Integer.parseInt(((TextInputLayout) findViewById(R.id.c_fnac_a)).getEditText().getText().toString().trim()));
                }
                edit.putInt("sexo", Integer.parseInt(getResources().getStringArray(R.array.idsexo_a)[this.pos_sexo]));
                edit.putInt("coments", Integer.parseInt(getResources().getStringArray(R.array.idcoments_a)[this.pos_coments]));
                edit.putInt("privados", Integer.parseInt(getResources().getStringArray(R.array.idprivados_a)[this.pos_privados]));
                edit.putInt("avisos", Integer.parseInt(getResources().getStringArray(R.array.idavisos_a)[this.pos_avisos]));
                try {
                    if (this.globales.getExtTempFile(this, 2).exists()) {
                        config.copy(this.globales.getExtTempFile(this, 2), this.globales.getTempFile(this, 1));
                    } else {
                        this.globales.getTempFile(this, 1).delete();
                    }
                } catch (Exception unused2) {
                }
                if (this.nuevo || (this.globales.fb_modo == 3 && !this.email_confirmado)) {
                    edit.putString("foto1_modif", this.foto1_modif);
                    edit.commit();
                    Intent intent = new Intent(this, guardarprimeravez.class);
                    intent.putExtra("contra", ((TextInputLayout) findViewById(R.id.c_contra)).getEditText().getText().toString().trim());
                    if (this.externo) {
                        intent = config.completar_externo(intent, this.extras);
                    } else {
                        intent.putExtra("idsecc", this.idsecc);
                        intent.putExtra("desde_buscusus", this.extras.getBoolean("desde_buscusus", false));
                        intent.putExtra("desde_buscvideos", this.extras.getBoolean("desde_buscvideos", false));
                        intent.putExtra("desde_foro", this.extras.getBoolean("desde_foro", false));
                        intent.putExtra("desde_game", this.extras.getBoolean("desde_game", false));
                        intent.putExtra("desde_px", this.extras.getBoolean("desde_px", false));
                        intent.putExtra("desde_video", this.extras.getBoolean("desde_video", false));
                        intent.putExtra("desde_radio", this.extras.getBoolean("desde_radio", false));
                        intent.putExtra("desde_quiz", this.extras.getBoolean("desde_quiz", false));
                        intent.putExtra("desde_vistafb", this.extras.getBoolean("desde_vistafb", false));
                        intent.putExtra("desde_main", this.desde_main);
                        intent.putExtra("desde_main_oblig", this.desde_main_oblig);
                    }
                    if (this.globales.tipomenu != 2 || this.desde_main_oblig) {
                        z = true;
                        intent.putExtra("es_root", true);
                        z2 = false;
                    } else {
                        z2 = false;
                        z = true;
                    }
                    this.es_root = z2;
                    this.finalizar = z;
                    Intent intent2 = new Intent();
                    intent2.putExtra("finalizar", z);
                    setResult(-1, intent2);
                    startActivity(intent);
                    finish();
                } else {
                    edit.commit();
                    Intent intent3 = new Intent(this, s_guardarperfil.class);
                    intent3.putExtra("foto1_modif", this.foto1_modif);
                    startService(intent3);
                    continuar();
                }
                finish();
            }
        } else if (view.getId() == R.id.btnprofile) {
            if (this.nuevo || this.desde_main_oblig) {
                final AlertDialog create11 = new AlertDialog.Builder(this).setCancelable(false).setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).setMessage(R.string.guardaprimero).create();
                if (!this.cbtn.equals("")) {
                    create11.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create11.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create11.show();
                ((TextView) create11.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                return;
            }
            Intent intent4 = new Intent(this, profile.class);
            StringBuilder sb = new StringBuilder();
            String str = "fnac_a";
            sb.append(this.settings.getLong("idusu", 0));
            sb.append("");
            intent4.putExtra("id", sb.toString());
            intent4.putExtra("privados", "0");
            intent4.putExtra("nombre", this.settings.getString("nick", ""));
            intent4.putExtra("coments", this.settings.getInt("coments", 1) + "");
            intent4.putExtra("fnac_d", this.settings.getInt("fnac_d", 0) + "");
            intent4.putExtra("fnac_m", this.settings.getInt("fnac_m", 0) + "");
            intent4.putExtra(str, this.settings.getInt(str, 0) + "");
            intent4.putExtra("sexo", this.settings.getInt("sexo", 0) + "");
            intent4.putExtra("vfoto", "99999999");
            intent4.putExtra("dist", "0");
            intent4.putExtra("p_fnac", this.fnac);
            intent4.putExtra("p_sexo", this.sexo);
            intent4.putExtra("p_descr", this.descr);
            intent4.putExtra("p_dist", 0);
            intent4.putExtra("coments_chat", this.coments == 1);
            intent4.putExtra("galeria", this.galeria == 1);
            intent4.putExtra("privados_chat", this.privados == 1);
            intent4.putExtra("fotos_perfil", this.fotos_perfil);
            intent4.putExtra("fotos_chat", 1);
            intent4.putExtra("desde_main", this.desde_main);
            intent4.putExtra("desde_main_oblig", this.desde_main_oblig);
            startActivityForResult(intent4, 0);
        } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
            View view2 = view;
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

    private void mostrar_foto_p(int i, boolean z) {
        Bitmap bitmap;
        File extTempFile = this.globales.getExtTempFile(this, i);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(extTempFile.getPath(), options);
            int i2 = options.outWidth;
            int dp_to_px = config.dp_to_px(this, 120);
            int dp_to_px2 = config.dp_to_px(this, 120);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if (!(i3 <= dp_to_px && i4 <= dp_to_px2)) {
                int round = Math.round(((float) i3) / ((float) config.calculateNewWidth(i3, i4, dp_to_px, dp_to_px2)));
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = round;
                bitmap = BitmapFactory.decodeFile(extTempFile.getPath(), options2);
            } else {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(extTempFile));
            }
            Bitmap circularBitmapWithWhiteBorder = config.getCircularBitmapWithWhiteBorder(bitmap, 1);
            ImageView imageView = this.foto1;
            if (!z) {
                this.foto1_modif = "1";
            }
            imageView.setImageBitmap(circularBitmapWithWhiteBorder);
            findViewById(R.id.btnfotos).setVisibility(8);
            this.fl_edit_foto.setVisibility(0);
            if ((this.globales.fb_modo == 1 || this.globales.fb_modo == 2) && this.globales.fb_bloqdatos && this.settings.getBoolean("logineado_fb", false)) {
                findViewById(R.id.edit_foto).setVisibility(8);
                findViewById(R.id.edit_foto_bg).setVisibility(8);
            }
        } catch (FileNotFoundException | IOException unused) {
        }
    }

    public void abrir_secc(View view) {
        ResultGetIntent intent = this.globales.getIntent(view, this);
        if (intent != null) {
            try {
                if (intent.i != null && intent.i.getComponent().getClassName().endsWith(".preperfil")) {
                    return;
                }
            } catch (Exception unused) {
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
                if (intent.finalizar) {
                    this.es_root = false;
                    if (this.globales.tipomenu != 2) {
                        intent.i.putExtra("es_root", true);
                    }
                    try {
                        startActivity(intent.i);
                    } catch (Exception unused2) {
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

    private class guardartk extends AsyncTask<String, Void, String> {
        String gender;
        String idfb;
        String idgoogle;
        String name;
        String tfoto;
        String tk;

        public guardartk(String str, String str2, String str3, String str4, String str5, String str6) {
            this.tk = str;
            this.idfb = str2;
            this.idgoogle = str3;
            this.name = str4;
            this.gender = str5;
            this.tfoto = str6;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            chat_perfil.this.dialog_cargando_3 = new ProgressDialog(chat_perfil.this);
            chat_perfil.this.dialog_cargando_3.setMessage(chat_perfil.this.getString(R.string.guardando));
            chat_perfil.this.dialog_cargando_3.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !chat_perfil.this.cbtn.equals("")) {
                chat_perfil.this.dialog_cargando_3.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) chat_perfil.this.dialog_cargando_3.findViewById(16908301), chat_perfil.this.cbtn);
                    }
                });
            }
            chat_perfil.this.dialog_cargando_3.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/guardar_token.php?desde_app=1");
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("u", new StringBody(chat_perfil.this.idusu + ""));
                multipartEntity.addPart("cod_g", new StringBody(chat_perfil.this.cod_g));
                multipartEntity.addPart("codigo", new StringBody(chat_perfil.this.codigo));
                multipartEntity.addPart("idapp", new StringBody("3008836"));
                multipartEntity.addPart("x", new StringBody(chat_perfil.this.settings.getString("x", "")));
                multipartEntity.addPart("y", new StringBody(chat_perfil.this.settings.getString("y", "")));
                multipartEntity.addPart("tk", new StringBody(this.tk));
                if (!this.idgoogle.equals("")) {
                    multipartEntity.addPart("idgoogle_param", new StringBody(this.idgoogle));
                } else {
                    multipartEntity.addPart("idfb_param", new StringBody(this.idfb));
                }
                multipartEntity.addPart("nombre", new StringBody(this.name));
                multipartEntity.addPart("gender", new StringBody(this.gender));
                multipartEntity.addPart("tfoto", new StringBody(this.tfoto));
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
            String str2;
            String str3;
            int indexOf = str.indexOf("OK COD:");
            if (indexOf == -1) {
                try {
                    chat_perfil.this.dialog_cargando_3.dismiss();
                } catch (Exception unused) {
                }
                chat_perfil chat_perfil = chat_perfil.this;
                config.mostrar_error(chat_perfil, chat_perfil.getString(R.string.error_http_tit), chat_perfil.this.getString(R.string.error_http), chat_perfil.this.cbtn);
                return;
            }
            int i = indexOf + 7;
            String substring = str.substring(i, i + 6);
            int indexOf2 = str.indexOf(" IDUSU:");
            String str4 = "";
            if (indexOf2 != -1) {
                int i2 = indexOf2 + 7;
                String substring2 = str.substring(i2, str.indexOf("@", i2));
                int indexOf3 = str.indexOf(" COD_G:");
                if (indexOf3 != -1) {
                    int i3 = indexOf3 + 7;
                    str3 = str.substring(i3, str.indexOf("@", i3));
                } else {
                    str3 = str4;
                }
                int indexOf4 = str.indexOf(" DATOS_USU:");
                if (indexOf4 != -1) {
                    str4 = str.substring(indexOf4 + 11);
                }
                str2 = str4;
                str4 = substring2;
            } else {
                str2 = str4;
                str3 = str2;
            }
            chat_perfil.this.guardar_datosfb(Uri.parse("appac://fb_3008836?tk=" + this.tk + "&action=ok&nombre=" + this.name + "&tfoto=" + this.tfoto + "&gender=" + this.gender + "&idfb=" + this.idfb + "&idgoogle=" + this.idgoogle + "&codigo=" + substring + "&idusu=" + str4 + "&cod_g=" + str3 + "&datos_usu=" + str2));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00d6 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void guardar_datosfb(android.net.Uri r15) {
        /*
            r14 = this;
            java.lang.String r0 = "sh"
            r1 = 0
            android.content.SharedPreferences r0 = r14.getSharedPreferences(r0, r1)
            android.content.SharedPreferences$Editor r2 = r0.edit()
            java.lang.String r3 = "logineado_fb"
            r4 = 1
            r2.putBoolean(r3, r4)
            java.lang.String r3 = "gender"
            java.lang.String r5 = r15.getQueryParameter(r3)
            java.lang.String r6 = "male"
            boolean r5 = r5.equals(r6)
            r6 = 2
            if (r5 == 0) goto L_0x0022
            r3 = 1
            goto L_0x0031
        L_0x0022:
            java.lang.String r3 = r15.getQueryParameter(r3)
            java.lang.String r5 = "female"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0030
            r3 = 2
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            java.lang.String r5 = "codigo"
            java.lang.String r7 = r15.getQueryParameter(r5)
            java.lang.String r8 = ""
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0048
            java.lang.String r7 = "cod"
            java.lang.String r5 = r15.getQueryParameter(r5)
            r2.putString(r7, r5)
        L_0x0048:
            java.lang.String r5 = "idusu"
            java.lang.String r7 = r15.getQueryParameter(r5)
            boolean r7 = r7.equals(r8)
            java.lang.String r9 = "@"
            if (r7 != 0) goto L_0x00d9
            java.lang.String r7 = r15.getQueryParameter(r5)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r11 = 0
            long r11 = r0.getLong(r5, r11)
            r10.append(r11)
            r10.append(r8)
            java.lang.String r0 = r10.toString()
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00d9
            java.lang.String r0 = r15.getQueryParameter(r5)
            long r10 = java.lang.Long.parseLong(r0)
            r2.putLong(r5, r10)
            java.lang.String r0 = "cod_g"
            java.lang.String r7 = r15.getQueryParameter(r0)
            r2.putString(r0, r7)
            java.lang.String r0 = r15.getQueryParameter(r5)
            boolean r5 = r7.equals(r8)
            if (r5 != 0) goto L_0x00a5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r9)
            r5.append(r7)
            java.lang.String r0 = r5.toString()
        L_0x00a5:
            r5 = 0
            java.io.File r7 = r14.getFilesDir()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r11 = "vinebre_ac.txt"
            r10.<init>(r7, r11)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            java.io.OutputStreamWriter r10 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r10.<init>(r7)     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r5.<init>(r10)     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r5.write(r0)     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r5.close()     // Catch:{ Exception -> 0x00cf, all -> 0x00cc }
            r7.close()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00d9
        L_0x00ca:
            goto L_0x00d9
        L_0x00cc:
            r15 = move-exception
            r5 = r7
            goto L_0x00d2
        L_0x00cf:
            r5 = r7
            goto L_0x00d6
        L_0x00d1:
            r15 = move-exception
        L_0x00d2:
            r5.close()     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            throw r15
        L_0x00d6:
            r5.close()     // Catch:{ Exception -> 0x00ca }
        L_0x00d9:
            java.lang.String r0 = "nombre"
            java.lang.String r0 = r15.getQueryParameter(r0)
            java.lang.String r5 = "nick"
            r2.putString(r5, r0)
            java.lang.String r0 = "sexo"
            r2.putInt(r0, r3)
            java.lang.String r0 = "datos_usu"
            java.lang.String r3 = r15.getQueryParameter(r0)
            boolean r3 = r3.equals(r8)
            java.lang.String r5 = "coments"
            java.lang.String r7 = "fnac_a"
            java.lang.String r10 = "fnac_m"
            java.lang.String r11 = "fnac_d"
            java.lang.String r12 = "privados"
            java.lang.String r13 = "descr"
            if (r3 != 0) goto L_0x0146
            java.lang.String r0 = r15.getQueryParameter(r0)
            java.lang.String[] r0 = r0.split(r9)
            r3 = r0[r1]
            int r3 = java.lang.Integer.parseInt(r3)
            r2.putInt(r12, r3)
            r3 = r0[r4]
            int r3 = java.lang.Integer.parseInt(r3)
            r2.putInt(r11, r3)
            r3 = r0[r6]
            int r3 = java.lang.Integer.parseInt(r3)
            r2.putInt(r10, r3)
            r3 = 3
            r3 = r0[r3]
            int r3 = java.lang.Integer.parseInt(r3)
            r2.putInt(r7, r3)
            r3 = 4
            r3 = r0[r3]
            int r3 = java.lang.Integer.parseInt(r3)
            r2.putInt(r5, r3)
            int r3 = r0.length
            r4 = 5
            if (r3 <= r4) goto L_0x0142
            r0 = r0[r4]
            r2.putString(r13, r0)
            goto L_0x0158
        L_0x0142:
            r2.putString(r13, r8)
            goto L_0x0158
        L_0x0146:
            r2.putInt(r12, r4)
            r2.putInt(r11, r1)
            r2.putInt(r10, r1)
            r2.putInt(r7, r1)
            r2.putInt(r5, r4)
            r2.putString(r13, r8)
        L_0x0158:
            r2.commit()
            java.lang.String r0 = "idfb"
            java.lang.String r0 = r15.getQueryParameter(r0)
            boolean r0 = r0.equals(r8)
            java.lang.String r2 = "tfoto"
            if (r0 != 0) goto L_0x0175
            java.lang.String r0 = r15.getQueryParameter(r2)
            java.lang.String r3 = "1"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x018b
        L_0x0175:
            java.lang.String r0 = "idgoogle"
            java.lang.String r0 = r15.getQueryParameter(r0)
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0196
            java.lang.String r0 = r15.getQueryParameter(r2)
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0196
        L_0x018b:
            stikerwap.appdys.chat_perfil$bajar_foto_fb r0 = new stikerwap.appdys.chat_perfil$bajar_foto_fb
            r0.<init>(r15)
            java.lang.String[] r15 = new java.lang.String[r1]
            r0.execute(r15)
            goto L_0x0199
        L_0x0196:
            r14.continuar()
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.chat_perfil.guardar_datosfb(android.net.Uri):void");
    }

    private class bajar_foto_fb extends AsyncTask<String, Void, Byte> {
        Uri uri;

        public bajar_foto_fb(Uri uri2) {
            this.uri = uri2;
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            URL url;
            try {
                if (!this.uri.getQueryParameter("idfb").equals("")) {
                    url = new URL("https://graph.facebook.com/" + this.uri.getQueryParameter("idfb") + "/picture?type=large&access_token=" + this.uri.getQueryParameter("tk"));
                } else if (this.uri.getQueryParameter("idgoogle").equals("")) {
                    return (byte) 0;
                } else {
                    url = new URL(this.uri.getQueryParameter("tfoto"));
                }
            } catch (MalformedURLException unused) {
                url = null;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                httpURLConnection.disconnect();
                try {
                    decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(chat_perfil.this.globales.getExtTempFile(chat_perfil.this, 2)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
            return (byte) 1;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            chat_perfil.this.continuar();
        }
    }

    /* access modifiers changed from: protected */
    public void continuar() {
        Intent intent;
        try {
            this.dialog_cargando_3.dismiss();
        } catch (Exception unused) {
        }
        try {
            if (this.globales.getExtTempFile(this, 2).exists()) {
                config.copy(this.globales.getExtTempFile(this, 2), this.globales.getTempFile(this, 1));
            } else {
                this.globales.getTempFile(this, 1).delete();
            }
        } catch (Exception unused2) {
        }
        int i = 0;
        if (this.desde_main) {
            this.es_root = false;
            this.finalizar = true;
            Intent intent2 = new Intent();
            intent2.putExtra("finalizar", true);
            setResult(-1, intent2);
            if ((this.fotos_perfil == 2 && !this.globales.getExtTempFile(this, 2).exists()) || ((this.fnac == 2 && (this.settings.getInt("fnac_d", 0) == 0 || this.settings.getInt("fnac_m", 0) == 0 || this.settings.getInt("fnac_a", 0) == 0)) || ((this.sexo == 2 && this.settings.getInt("sexo", 0) == 0) || (this.descr == 2 && this.settings.getString("descr", "").equals(""))))) {
                Intent intent3 = new Intent(this, chat_perfil.class);
                intent3.putExtra("desde_main", true);
                intent3.putExtra("desde_main_oblig", true);
                this.globales.ind_secc_sel = 900;
                intent3.putExtra("es_root", this.es_root_orig);
                startActivity(intent3);
                finish();
            } else if (this.globales.glob_acceso > 1 && !this.settings.getBoolean("glob_acceso_validado", false)) {
                Intent intent4 = new Intent(this, codigo.class);
                intent4.putExtra("es_root", true);
                startActivity(intent4);
                finish();
            } else if (this.globales.tipomenu == 2 && !this.desde_main_oblig) {
                finish();
            } else if (this.globales.tipomenu == 2) {
                Intent intent5 = new Intent(this, t_menugrid.class);
                this.globales.ind_secc_sel = 900;
                SharedPreferences.Editor edit = this.settings.edit();
                edit.putInt("ind_secc_sel", this.globales.ind_secc_sel);
                edit.commit();
                intent5.putExtra("es_root", true);
                startActivity(intent5);
                finish();
            } else {
                boolean z = false;
                int i2 = 0;
                while (!z && i2 < this.globales.secciones_a.length) {
                    if (!this.globales.secciones_a[i2].oculta) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    i = i2;
                }
                ResultGetIntent crear_rgi = this.globales.crear_rgi(Integer.valueOf(i), this);
                crear_rgi.i.putExtra("es_root", true);
                startActivity(crear_rgi.i);
                finish();
            }
        } else {
            if (this.extras.getBoolean("desde_buscusus", false)) {
                intent = new Intent(this, t_buscusus.class);
            } else if (this.extras.getBoolean("desde_buscvideos", false)) {
                intent = new Intent(this, t_buscvideos.class);
            } else if (this.extras.getBoolean("desde_foro", false)) {
                intent = new Intent(this, t_url.class);
                intent.putExtra("nocompletar", this.extras.getBoolean("nocompletar", false));
            } else if (this.extras.getBoolean("desde_game", false)) {
                intent = new Intent(this, t_url.class);
                intent.putExtra("nocompletar", this.extras.getBoolean("nocompletar", false));
            } else if (this.extras.getBoolean("desde_px", false)) {
                intent = new Intent(this, t_url.class);
                intent.putExtra("nocompletar", this.extras.getBoolean("nocompletar", false));
            } else if (this.extras.getBoolean("desde_video", false)) {
                if (this.globales.secciones_a[config.secciones_alist.indexOf(Integer.valueOf(this.idsecc))].tipo_player == 0) {
                    intent = new Intent(this, t_video.class);
                } else if (this.globales.secciones_a[config.secciones_alist.indexOf(Integer.valueOf(this.idsecc))].tipo_player == 1) {
                    intent = new Intent(this, t_video_exoplayer.class);
                } else {
                    intent = new Intent(this, t_video_playerjs.class);
                }
                intent.putExtra("url", this.globales.secciones_a[config.secciones_alist.indexOf(Integer.valueOf(this.idsecc))].url);
                intent.putExtra("ua", this.globales.secciones_a[config.secciones_alist.indexOf(Integer.valueOf(this.idsecc))].ua);
            } else if (this.extras.getBoolean("desde_radio", false)) {
                intent = new Intent(this, t_radio.class);
                intent.putExtra("ind", config.secciones_alist.indexOf(Integer.valueOf(this.idsecc)));
            } else if (this.extras.getBoolean("desde_quiz", false)) {
                intent = new Intent(this, t_url.class);
                intent.putExtra("nocompletar", this.extras.getBoolean("nocompletar", false));
            } else if (this.extras.getBoolean("desde_vistafb", false)) {
                intent = new Intent(this, t_vistafb.class);
            } else {
                intent = new Intent(this, t_chat_contra.class);
            }
            intent.putExtra("desdeperfil", 1);
            if (this.externo) {
                intent = config.completar_externo(intent, this.extras);
            } else {
                intent.putExtra("idsecc", this.idsecc);
                intent.putExtra("ind", this.ind);
            }
            if (this.globales.tipomenu != 2) {
                intent.putExtra("es_root", true);
            }
            this.es_root = false;
            this.finalizar = true;
            Intent intent6 = new Intent();
            intent6.putExtra("finalizar", true);
            setResult(-1, intent6);
            startActivity(intent);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public Dialog crear_dialog_contra() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_contra);
        dialog.setTitle(getResources().getString(R.string.contra));
        ((TextView) dialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                chat_perfil.this.dialog_contra.dismiss();
            }
        });
        TextView textView = (TextView) dialog.findViewById(R.id.btn_aceptar);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i;
                boolean z;
                AlertDialog.Builder builder = new AlertDialog.Builder(chat_perfil.this);
                builder.setCancelable(false).setPositiveButton(chat_perfil.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
                String trim = ((EditText) chat_perfil.this.dialog_contra.findViewById(R.id.et_contra_act)).getText().toString().trim();
                String trim2 = ((EditText) chat_perfil.this.dialog_contra.findViewById(R.id.et_contra_nueva)).getText().toString().trim();
                String trim3 = ((EditText) chat_perfil.this.dialog_contra.findViewById(R.id.et_contra_repe)).getText().toString().trim();
                if (trim.isEmpty() || trim2.isEmpty() || trim3.isEmpty()) {
                    z = false;
                    i = R.string.falta_alguno;
                } else if (!trim2.equals(trim3)) {
                    z = false;
                    i = R.string.contra_noigual;
                } else {
                    z = true;
                    i = 0;
                }
                if (!z) {
                    builder.setMessage(i);
                    final AlertDialog create = builder.create();
                    if (!chat_perfil.this.cbtn.equals("")) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                            }
                        });
                    }
                    create.show();
                    try {
                        ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                    } catch (Exception unused) {
                    }
                } else {
                    new modif_contra().execute(new String[0]);
                }
            }
        });
        if (Build.VERSION.SDK_INT > 20) {
            textView.setTextColor(Color.parseColor("#" + this.cbtn));
        }
        dialog.findViewById(R.id.iv_help).setOnClickListener(this);
        if (config.esClaro("#" + this.c1)) {
            this.pb = (ProgressBar) dialog.findViewById(R.id.pb_contra_inv);
        } else {
            this.pb = (ProgressBar) dialog.findViewById(R.id.pb_contra);
            ((ImageView) dialog.findViewById(R.id.iv_help)).setImageDrawable(getResources().getDrawable(R.drawable.help_b));
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(this.pb, this.cbtn);
        }
        return dialog;
    }

    private class modif_contra extends AsyncTask<String, Void, String> {
        private modif_contra() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            chat_perfil.this.dialog_contra.findViewById(R.id.ll_contenido).setVisibility(4);
            chat_perfil.this.pb.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/modif_contra.php?idusu=" + chat_perfil.this.idusu + "&c=" + chat_perfil.this.codigo);
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                multipartEntity.addPart("contra_act", new StringBody(((EditText) chat_perfil.this.dialog_contra.findViewById(R.id.et_contra_act)).getText().toString().trim()));
                multipartEntity.addPart("contra_nueva", new StringBody(((EditText) chat_perfil.this.dialog_contra.findViewById(R.id.et_contra_nueva)).getText().toString().trim()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            String str = "";
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
            chat_perfil.this.pb.setVisibility(8);
            AlertDialog.Builder builder = new AlertDialog.Builder(chat_perfil.this);
            builder.setCancelable(false).setPositiveButton(chat_perfil.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
            if (str.indexOf("ANDROID:OK") != -1) {
                chat_perfil.this.dialog_contra.dismiss();
                builder.setMessage(R.string.contra_modificada);
                final AlertDialog create = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            } else if (str.indexOf("ANDROID:KO -CONTRA-") != -1) {
                chat_perfil.this.dialog_contra.findViewById(R.id.ll_contenido).setVisibility(0);
                builder.setMessage(R.string.contra_ko);
                final AlertDialog create2 = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                chat_perfil.this.dialog_contra.findViewById(R.id.ll_contenido).setVisibility(0);
                builder.setMessage(R.string.error_http);
                final AlertDialog create3 = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create3.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create3.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create3.show();
                ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    private class recordar_contra extends AsyncTask<String, Void, String> {
        private recordar_contra() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            try {
                chat_perfil.this.dialog_contra.dismiss();
            } catch (Exception unused) {
            }
            chat_perfil.this.dialog_enviandocontra = new ProgressDialog(chat_perfil.this);
            chat_perfil.this.dialog_enviandocontra.setMessage(chat_perfil.this.getString(R.string.enviando));
            chat_perfil.this.dialog_enviandocontra.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20) {
                chat_perfil.this.dialog_enviandocontra.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) chat_perfil.this.dialog_enviandocontra.findViewById(16908301), chat_perfil.this.cbtn);
                    }
                });
            }
            chat_perfil.this.dialog_enviandocontra.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/recordar_contra.php?idapp=3008836&idl=" + Locale.getDefault().getLanguage());
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                multipartEntity.addPart("email", new StringBody(((TextInputLayout) chat_perfil.this.findViewById(R.id.c_email)).getEditText().getText().toString().trim()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            String str = "";
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
            try {
                chat_perfil.this.dialog_enviandocontra.dismiss();
            } catch (Exception unused) {
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(chat_perfil.this);
            builder.setCancelable(false).setPositiveButton(chat_perfil.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
            if (str.indexOf("ANDROID:OK") != -1) {
                builder.setMessage(R.string.contra_enviada);
                final AlertDialog create = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused2) {
                }
            } else if (str.indexOf("ANDROID:KO -ESPERA-") != -1) {
                builder.setMessage(R.string.contra_espera);
                final AlertDialog create2 = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (str.indexOf("ANDROID:KO -NOTFOUND-") != -1) {
                builder.setMessage(R.string.email_noencontrado);
                final AlertDialog create3 = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create3.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create3.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create3.show();
                ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                builder.setMessage(R.string.error_http);
                final AlertDialog create4 = builder.create();
                if (!chat_perfil.this.cbtn.equals("")) {
                    create4.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create4.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        }
                    });
                }
                create4.show();
                ((TextView) create4.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    private class cargarprivacidad extends AsyncTask<String, Void, Byte> {
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.chat_perfil.cargarprivacidad.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            chat_perfil.this.dialog_cargando_2 = new ProgressDialog(chat_perfil.this);
            chat_perfil.this.dialog_cargando_2.setMessage(chat_perfil.this.getString(R.string.cargando));
            chat_perfil.this.dialog_cargando_2.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !chat_perfil.this.cbtn.equals("")) {
                chat_perfil.this.dialog_cargando_2.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) chat_perfil.this.dialog_cargando_2.findViewById(16908301), chat_perfil.this.cbtn);
                    }
                });
            }
            chat_perfil.this.dialog_cargando_2.show();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                chat_perfil.this.dialog_cargando_2.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() != 0) {
                chat_perfil chat_perfil = chat_perfil.this;
                config.mostrar_error(chat_perfil, chat_perfil.getString(R.string.error_http_tit), chat_perfil.this.getString(R.string.error_http), chat_perfil.this.cbtn);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(chat_perfil.this);
            builder.setMessage(Html.fromHtml(this.result_http));
            if (this.pedir_confirm) {
                builder.setCancelable(false);
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        chat_perfil.this.finish();
                    }
                });
                builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor edit = chat_perfil.this.settings.edit();
                        edit.putBoolean("pp_aceptada", true);
                        edit.commit();
                        chat_perfil.this.pedir_permisos_2();
                    }
                });
            } else {
                builder.setCancelable(true);
                builder.setPositiveButton(chat_perfil.this.getString(R.string.cerrar), (DialogInterface.OnClickListener) null);
            }
            final AlertDialog create = builder.create();
            if (!chat_perfil.this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
                        if (cargarprivacidad.this.pedir_confirm) {
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + chat_perfil.this.cbtn));
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

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("foto1_modif_saved", this.foto1_modif);
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
        super.onPause();
        config.onPause_global(this);
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (this.globales.admob_pos != 0 && (anuncios = this.anun) != null && anuncios.wortiseBanner != null) {
            this.anun.wortiseBanner.resume();
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

    public void onBackPressed() {
        if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            super.onBackPressed();
            return;
        }
        this.atras_pulsado = true;
        config.confirmar_exit(this);
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
        this.anun = this.globales.mostrar_banner(this, false);
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
                if (!chat_perfil.this.globales.admob_rew_failed(context, chat_perfil.this.mAd_appnext)) {
                    chat_perfil.this.dialog_cargando.cancel();
                    chat_perfil chat_perfil = chat_perfil.this;
                    chat_perfil.abrir_secc(chat_perfil.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                chat_perfil.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        chat_perfil.this.abrir_secc(chat_perfil.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (chat_perfil.this.mAd_visto) {
                            chat_perfil.this.abrir_secc(chat_perfil.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        chat_perfil.this.mAd_visto = true;
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
                if (chat_perfil.this.mAd_visto) {
                    chat_perfil chat_perfil = chat_perfil.this;
                    chat_perfil.abrir_secc(chat_perfil.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
