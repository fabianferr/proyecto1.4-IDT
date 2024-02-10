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
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import stikerwap.appdys.config;

public class t_chat extends Activity_ext_class implements Activity_ext, View.OnKeyListener, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private static final int SELECT_PHOTO = 2;
    private static final int SELECT_VIDEO = 4;
    private int TV_MARGIN;
    private int TV_PADDING;
    private int WIDTH_IMGS;
    Map<String, String> acargar_m;
    private int altura;
    private Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_propia;
    boolean c1_esclaro;
    /* access modifiers changed from: private */
    public String c1_glob;
    boolean c2_esclaro;
    /* access modifiers changed from: private */
    public String c2_glob;
    int c_activ;
    boolean c_fondotxt_esclaro;
    long captureTime;
    /* access modifiers changed from: private */
    public String codigo;
    /* access modifiers changed from: private */
    public String codigo_global;
    boolean coments;
    /* access modifiers changed from: private */
    public AlertDialog d_confirm;
    private Dialog d_solic_privado;
    private int descr;
    /* access modifiers changed from: private */
    public String dia_act;
    private int dist;
    int dp10;
    int dp3;
    enviar env;
    /* access modifiers changed from: private */
    public boolean es_privado;
    private boolean es_privado_root;
    boolean externo;
    Bundle extras;
    boolean fav;
    private int fnac;
    /* access modifiers changed from: private */
    public int fotos_chat;
    Map<String, Bitmap> fotos_m;
    /* access modifiers changed from: private */
    public int fotos_perfil;
    boolean galeria;
    /* access modifiers changed from: private */
    public config globales;
    boolean hayfrasedeotrousu = false;
    int height_global;
    /* access modifiers changed from: private */
    public String id_remit_global;
    /* access modifiers changed from: private */
    public int idchat;
    /* access modifiers changed from: private */
    public int idfrase_masantigua_glob;
    private int idsecc;
    /* access modifiers changed from: private */
    public int idtema;
    /* access modifiers changed from: private */
    public long idusu;
    /* access modifiers changed from: private */
    public String idusu_act;
    /* access modifiers changed from: private */
    public long idusu_global;
    /* access modifiers changed from: private */
    public String imgs_acargar;
    Map<String, String> intentados_m;
    ImageView iv_notif_noactiv;
    boolean ll_cabe_mostrar;
    LinearLayout llchat;
    boolean mAd_visto = false;
    ListView mDrawerList;
    int marge_mateix;
    String msg_ultimas = "";
    /* access modifiers changed from: private */
    public int nfrases;
    /* access modifiers changed from: private */
    public String nombre_remit_global;
    boolean notif;
    obtener_foto o_f;
    obtener_img o_i;
    obtener_img_g o_i_g;
    obtener_video o_v;
    File path;
    ProgressBar pb_ant;
    ProgressBar pb_enviando;
    MediaPlayer player_in;
    MediaPlayer player_out;
    boolean privados;
    float scale;
    Seccion secc_act;
    /* access modifiers changed from: private */
    public SharedPreferences settings;
    /* access modifiers changed from: private */
    public SharedPreferences settings2;
    private int sexo;
    private String sit;
    private String sot;
    List<String> spool = new ArrayList();
    int tag_id = 1;
    TextToSpeech textToSpeechSystem;
    boolean tts_preparado = false;
    int width_ad;
    int width_frase;
    int width_global;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:257:0x08e9  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0914  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0920  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0b99  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0b9f  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0cc2  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0d9d  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0e22 A[Catch:{ OutOfMemoryError -> 0x0e3e }] */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0e30 A[Catch:{ OutOfMemoryError -> 0x0e3e }] */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0e43  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0ea3  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0eb7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            java.lang.String r2 = "sounds/sound_out"
            java.lang.String r3 = "sounds/sound"
            android.content.Context r4 = r24.getApplicationContext()
            stikerwap.appdys.config r4 = (stikerwap.appdys.config) r4
            r1.globales = r4
            java.lang.String r4 = r4.c1
            if (r4 != 0) goto L_0x0019
            stikerwap.appdys.config r4 = r1.globales
            r4.recuperar_vars()
        L_0x0019:
            r1.establec_ralc(r1)
            android.content.Intent r4 = r24.getIntent()
            android.os.Bundle r4 = r4.getExtras()
            r1.extras = r4
            java.lang.String r5 = "es_root"
            r6 = 1
            r7 = 0
            if (r0 != 0) goto L_0x0042
            if (r4 == 0) goto L_0x003e
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x003e
            android.os.Bundle r4 = r1.extras
            boolean r4 = r4.getBoolean(r5, r7)
            if (r4 == 0) goto L_0x003e
            r4 = 1
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            r1.es_root = r4
            goto L_0x0053
        L_0x0042:
            boolean r4 = r0.containsKey(r5)
            if (r4 == 0) goto L_0x0050
            boolean r4 = r0.getBoolean(r5, r7)
            if (r4 == 0) goto L_0x0050
            r4 = 1
            goto L_0x0051
        L_0x0050:
            r4 = 0
        L_0x0051:
            r1.es_root = r4
        L_0x0053:
            android.os.Bundle r4 = r1.extras
            if (r4 == 0) goto L_0x0061
            java.lang.String r5 = "externo"
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x0061
            r4 = 1
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            r1.externo = r4
            stikerwap.appdys.config r4 = r1.globales
            stikerwap.appdys.Seccion[] r4 = r4.secciones_a
            stikerwap.appdys.config r5 = r1.globales
            int r5 = r5.ind_secc_sel_2
            r4 = r4[r5]
            r1.secc_act = r4
            boolean r4 = r1.es_root
            java.lang.String r5 = "id_remit"
            if (r4 == 0) goto L_0x0084
            boolean r4 = r1.externo
            if (r4 == 0) goto L_0x0084
            android.os.Bundle r4 = r1.extras
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x0084
            r4 = 1
            goto L_0x0085
        L_0x0084:
            r4 = 0
        L_0x0085:
            r1.es_privado_root = r4
            boolean r4 = r1.externo
            if (r4 == 0) goto L_0x00a0
            android.os.Bundle r4 = r1.extras
            java.lang.String r8 = "c1"
            java.lang.String r4 = r4.getString(r8)
            r1.c1_glob = r4
            android.os.Bundle r4 = r1.extras
            java.lang.String r8 = "c2"
            java.lang.String r4 = r4.getString(r8)
            r1.c2_glob = r4
            goto L_0x00ac
        L_0x00a0:
            stikerwap.appdys.Seccion r4 = r1.secc_act
            java.lang.String r4 = r4.c1
            r1.c1_glob = r4
            stikerwap.appdys.Seccion r4 = r1.secc_act
            java.lang.String r4 = r4.c2
            r1.c2_glob = r4
        L_0x00ac:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = "#"
            r4.<init>(r8)
            java.lang.String r9 = r1.c1_glob
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r1.c1_esclaro = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r8)
            java.lang.String r9 = r1.c2_glob
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r1.c2_esclaro = r4
            stikerwap.appdys.config r4 = r1.globales
            int r4 = r4.bubbles
            java.lang.String r9 = ""
            if (r4 <= 0) goto L_0x0101
            r1.c_fondotxt_esclaro = r6
            stikerwap.appdys.config r4 = r1.globales
            java.lang.String r4 = r4.c_bubbles
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x0105
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r8)
            stikerwap.appdys.config r10 = r1.globales
            java.lang.String r10 = r10.c_bubbles
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            r1.c_fondotxt_esclaro = r4
            goto L_0x0105
        L_0x0101:
            boolean r4 = r1.c1_esclaro
            r1.c_fondotxt_esclaro = r4
        L_0x0105:
            java.lang.String r4 = r1.c1_glob
            stikerwap.appdys.config r10 = r1.globales
            java.lang.String r10 = r10.c_icos
            java.lang.String r4 = stikerwap.appdys.config.aplicar_color_dialog(r4, r10)
            r1.cbtn = r4
            boolean r4 = r1.c1_esclaro
            if (r4 != 0) goto L_0x011b
            r4 = 2131952478(0x7f13035e, float:1.95414E38)
            r1.setTheme(r4)
        L_0x011b:
            super.onCreate(r25)
            r4 = 2131558726(0x7f0d0146, float:1.8742776E38)
            r1.setContentView(r4)
            r24.incluir_menu_pre()
            stikerwap.appdys.config r4 = r1.globales
            r4.onCreate_global(r1, r7)
            java.lang.String r4 = "search"
            java.lang.Object r4 = r1.getSystemService(r4)
            android.app.SearchManager r4 = (android.app.SearchManager) r4
            stikerwap.appdys.t_chat$1 r10 = new stikerwap.appdys.t_chat$1
            r10.<init>()
            r4.setOnCancelListener(r10)
            stikerwap.appdys.t_chat$2 r10 = new stikerwap.appdys.t_chat$2
            r10.<init>()
            r4.setOnDismissListener(r10)
            stikerwap.appdys.config r4 = r1.globales
            android.os.Bundle r10 = r1.extras
            if (r10 == 0) goto L_0x0154
            java.lang.String r11 = "ad_entrar"
            boolean r10 = r10.containsKey(r11)
            if (r10 == 0) goto L_0x0154
            r10 = 1
            goto L_0x0155
        L_0x0154:
            r10 = 0
        L_0x0155:
            android.os.Bundle r11 = r1.extras
            if (r11 == 0) goto L_0x0163
            java.lang.String r12 = "fb_entrar"
            boolean r11 = r11.containsKey(r12)
            if (r11 == 0) goto L_0x0163
            r11 = 1
            goto L_0x0164
        L_0x0163:
            r11 = 0
        L_0x0164:
            r4.toca_int(r1, r10, r11)
            r4 = 0
            r1.anun = r4
            stikerwap.appdys.config r10 = r1.globales
            boolean r11 = r10.banners_enchats
            r11 = r11 ^ r6
            stikerwap.appdys.Anuncios r10 = r10.mostrar_banner_2(r1, r7, r11)
            r1.anun = r10
            boolean r10 = r1.externo
            if (r10 != 0) goto L_0x0182
            stikerwap.appdys.config r10 = r1.globales
            int r11 = r10.ind_secc_sel_2
            java.lang.String r12 = r1.cbtn
            r10.oncreate_popup(r1, r11, r12, r0)
        L_0x0182:
            stikerwap.appdys.config r0 = r1.globales
            int r10 = r0.ind_secc_sel_2
            boolean r0 = r1.externo
            if (r0 == 0) goto L_0x01ef
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "idchat"
            int r0 = r0.getInt(r11)
            r1.idchat = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "idtema"
            int r0 = r0.getInt(r11)
            r1.idtema = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "fotos_perfil"
            int r0 = r0.getInt(r11)
            r1.fotos_perfil = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "privados"
            boolean r0 = r0.getBoolean(r11)
            r1.privados = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "coments"
            boolean r0 = r0.getBoolean(r11)
            r1.coments = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "galeria"
            boolean r0 = r0.getBoolean(r11)
            r1.galeria = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "fnac"
            int r0 = r0.getInt(r11)
            r1.fnac = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "sexo"
            int r0 = r0.getInt(r11)
            r1.sexo = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "dist"
            int r0 = r0.getInt(r11)
            r1.dist = r0
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "descr"
            int r0 = r0.getInt(r11)
            r1.descr = r0
            goto L_0x025c
        L_0x01ef:
            android.os.Bundle r0 = r1.extras
            java.lang.String r11 = "idsecc"
            int r0 = r0.getInt(r11)
            r1.idsecc = r0
            r1.idchat = r0
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x020a }
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a     // Catch:{ Exception -> 0x020a }
            r0 = r0[r10]     // Catch:{ Exception -> 0x020a }
            stikerwap.appdys.Tema[] r0 = r0.temas_a     // Catch:{ Exception -> 0x020a }
            r0 = r0[r7]     // Catch:{ Exception -> 0x020a }
            int r0 = r0.id     // Catch:{ Exception -> 0x020a }
            r1.idtema = r0     // Catch:{ Exception -> 0x020a }
            goto L_0x020c
        L_0x020a:
            r1.idtema = r7
        L_0x020c:
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            int r0 = r0.fotos_perfil
            r1.fotos_perfil = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            boolean r0 = r0.privados
            r1.privados = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            boolean r0 = r0.coments
            r1.coments = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            boolean r0 = r0.galeria
            r1.galeria = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            int r0 = r0.p_fnac
            r1.fnac = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            int r0 = r0.p_sexo
            r1.sexo = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            int r0 = r0.p_dist
            r1.dist = r0
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            int r0 = r0.p_descr
            r1.descr = r0
        L_0x025c:
            boolean r0 = r1.privados
            r11 = 2131361988(0x7f0a00c4, float:1.8343744E38)
            r12 = 8
            if (r0 != 0) goto L_0x026c
            android.view.View r0 = r1.findViewById(r11)
            r0.setVisibility(r12)
        L_0x026c:
            java.lang.String r0 = "sh"
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r0, r7)
            r1.settings = r0
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.tts_mostrar
            if (r0 == 0) goto L_0x028e
            android.speech.tts.TextToSpeech r0 = new android.speech.tts.TextToSpeech
            stikerwap.appdys.t_chat$3 r13 = new stikerwap.appdys.t_chat$3
            r13.<init>()
            r0.<init>(r1, r13)
            r1.textToSpeechSystem = r0
            stikerwap.appdys.t_chat$4 r13 = new stikerwap.appdys.t_chat$4
            r13.<init>()
            r0.setOnUtteranceProgressListener(r13)
        L_0x028e:
            android.content.SharedPreferences r0 = r1.settings
            java.lang.String r13 = "sit"
            java.lang.String r14 = "0"
            java.lang.String r0 = r0.getString(r13, r14)
            r1.sit = r0
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x0305
            java.lang.String r0 = r1.sit     // Catch:{ Exception -> 0x0301 }
            java.lang.String r13 = "1"
            boolean r0 = r0.equals(r13)     // Catch:{ Exception -> 0x0301 }
            if (r0 == 0) goto L_0x02ca
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0301 }
            r0.<init>()     // Catch:{ Exception -> 0x0301 }
            java.io.File r3 = r24.getFilesDir()     // Catch:{ Exception -> 0x0301 }
            r0.append(r3)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r3 = "/sound_in"
            r0.append(r3)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0301 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0301 }
            android.media.MediaPlayer r0 = android.media.MediaPlayer.create(r1, r0)     // Catch:{ Exception -> 0x0301 }
            r1.player_in = r0     // Catch:{ Exception -> 0x0301 }
            goto L_0x02fb
        L_0x02ca:
            android.content.res.AssetManager r0 = r24.getAssets()     // Catch:{ Exception -> 0x0301 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0301 }
            r13.<init>(r3)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r3 = r1.sit     // Catch:{ Exception -> 0x0301 }
            r13.append(r3)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r3 = ".wav"
            r13.append(r3)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x0301 }
            android.content.res.AssetFileDescriptor r0 = r0.openFd(r3)     // Catch:{ Exception -> 0x0301 }
            android.media.MediaPlayer r15 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x0301 }
            r15.<init>()     // Catch:{ Exception -> 0x0301 }
            r1.player_in = r15     // Catch:{ Exception -> 0x0301 }
            java.io.FileDescriptor r16 = r0.getFileDescriptor()     // Catch:{ Exception -> 0x0301 }
            long r17 = r0.getStartOffset()     // Catch:{ Exception -> 0x0301 }
            long r19 = r0.getLength()     // Catch:{ Exception -> 0x0301 }
            r15.setDataSource(r16, r17, r19)     // Catch:{ Exception -> 0x0301 }
        L_0x02fb:
            android.media.MediaPlayer r0 = r1.player_in     // Catch:{ Exception -> 0x0301 }
            r0.prepare()     // Catch:{ Exception -> 0x0301 }
            goto L_0x0305
        L_0x0301:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0305:
            android.content.SharedPreferences r0 = r1.settings
            java.lang.String r3 = "sot"
            java.lang.String r0 = r0.getString(r3, r14)
            r1.sot = r0
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x037a
            java.lang.String r0 = r1.sot     // Catch:{ Exception -> 0x0376 }
            java.lang.String r3 = "1"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0376 }
            if (r0 == 0) goto L_0x033f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0376 }
            r0.<init>()     // Catch:{ Exception -> 0x0376 }
            java.io.File r2 = r24.getFilesDir()     // Catch:{ Exception -> 0x0376 }
            r0.append(r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = "/sound_out"
            r0.append(r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0376 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0376 }
            android.media.MediaPlayer r0 = android.media.MediaPlayer.create(r1, r0)     // Catch:{ Exception -> 0x0376 }
            r1.player_out = r0     // Catch:{ Exception -> 0x0376 }
            goto L_0x0370
        L_0x033f:
            android.content.res.AssetManager r0 = r24.getAssets()     // Catch:{ Exception -> 0x0376 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0376 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = r1.sot     // Catch:{ Exception -> 0x0376 }
            r3.append(r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = ".wav"
            r3.append(r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0376 }
            android.content.res.AssetFileDescriptor r0 = r0.openFd(r2)     // Catch:{ Exception -> 0x0376 }
            android.media.MediaPlayer r15 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x0376 }
            r15.<init>()     // Catch:{ Exception -> 0x0376 }
            r1.player_out = r15     // Catch:{ Exception -> 0x0376 }
            java.io.FileDescriptor r16 = r0.getFileDescriptor()     // Catch:{ Exception -> 0x0376 }
            long r17 = r0.getStartOffset()     // Catch:{ Exception -> 0x0376 }
            long r19 = r0.getLength()     // Catch:{ Exception -> 0x0376 }
            r15.setDataSource(r16, r17, r19)     // Catch:{ Exception -> 0x0376 }
        L_0x0370:
            android.media.MediaPlayer r0 = r1.player_out     // Catch:{ Exception -> 0x0376 }
            r0.prepare()     // Catch:{ Exception -> 0x0376 }
            goto L_0x037a
        L_0x0376:
            r0 = move-exception
            r0.printStackTrace()
        L_0x037a:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            android.view.WindowManager r2 = r24.getWindowManager()
            android.view.Display r2 = r2.getDefaultDisplay()
            r2.getMetrics(r0)
            int r2 = r0.widthPixels
            r1.width_global = r2
            int r0 = r0.heightPixels
            r1.height_global = r0
            int r0 = r1.width_global
            android.content.res.Resources r2 = r24.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            r3 = 2
            if (r2 != r3) goto L_0x03a3
            int r0 = r1.height_global
        L_0x03a3:
            int r2 = r0 / 2
            r13 = r5
            double r4 = (double) r2
            r16 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r16
            int r2 = (int) r4
            r1.width_frase = r2
            double r4 = (double) r0
            r16 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r16
            int r0 = (int) r4
            r1.width_ad = r0
            int r0 = r1.fotos_perfil
            if (r0 <= 0) goto L_0x03d6
            r0 = 50
            int r0 = stikerwap.appdys.config.dp_to_px(r1, r0)
            int r2 = r1.width_frase
            int r2 = r2 - r0
            r1.width_frase = r2
            int r2 = r1.width_ad
            int r2 = r2 - r0
            r1.width_ad = r2
        L_0x03d6:
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.tts_mostrar
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 == 0) goto L_0x03e5
            r0 = 35
            int r0 = stikerwap.appdys.config.dp_to_px(r1, r0)
            int r2 = r2 + r0
        L_0x03e5:
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.spam_mostrar
            if (r0 == 0) goto L_0x03f2
            r0 = 25
            int r0 = stikerwap.appdys.config.dp_to_px(r1, r0)
            int r2 = r2 + r0
        L_0x03f2:
            int r0 = r1.width_frase
            int r0 = java.lang.Math.max(r0, r2)
            r1.width_frase = r0
            int r2 = r1.width_global
            r4 = 30
            int r4 = stikerwap.appdys.config.dp_to_px(r1, r4)
            int r2 = r2 - r4
            int r0 = java.lang.Math.min(r0, r2)
            r1.width_frase = r0
            r0 = 4
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r0)
            r1.marge_mateix = r2
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.bubbles
            r4 = 3
            if (r2 != r6) goto L_0x0420
            r2 = 14
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r2)
            r1.marge_mateix = r2
            goto L_0x0449
        L_0x0420:
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.bubbles
            if (r2 != r3) goto L_0x042e
            r2 = 5
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r2)
            r1.marge_mateix = r2
            goto L_0x0449
        L_0x042e:
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.bubbles
            if (r2 != r4) goto L_0x043d
            r2 = 12
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r2)
            r1.marge_mateix = r2
            goto L_0x0449
        L_0x043d:
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.bubbles
            if (r2 != r0) goto L_0x0449
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r0)
            r1.marge_mateix = r2
        L_0x0449:
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r4)
            r1.dp3 = r2
            r2 = 10
            int r2 = stikerwap.appdys.config.dp_to_px(r1, r2)
            r1.dp10 = r2
            boolean r2 = r1.c1_esclaro
            if (r2 == 0) goto L_0x0464
            java.lang.String r2 = "#B71C1C"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.c_activ = r2
            goto L_0x046c
        L_0x0464:
            java.lang.String r2 = "#FF5252"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.c_activ = r2
        L_0x046c:
            r1.fotos_chat = r6
            boolean r2 = r1.externo
            if (r2 == 0) goto L_0x047c
            android.os.Bundle r2 = r1.extras
            java.lang.String r5 = "fotos_chat"
            int r2 = r2.getInt(r5)
            if (r2 == 0) goto L_0x048a
        L_0x047c:
            boolean r2 = r1.externo
            if (r2 != 0) goto L_0x048c
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r10]
            int r2 = r2.fotos_chat
            if (r2 != 0) goto L_0x048c
        L_0x048a:
            r1.fotos_chat = r7
        L_0x048c:
            int r2 = r1.fotos_chat
            r5 = 2131361989(0x7f0a00c5, float:1.8343746E38)
            if (r2 != 0) goto L_0x049a
            android.view.View r2 = r1.findViewById(r5)
            r2.setVisibility(r12)
        L_0x049a:
            boolean r2 = r1.externo
            r15 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            if (r2 != 0) goto L_0x04ad
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.cvm
            if (r2 == 0) goto L_0x04ad
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.cvm
            if (r2 != r6) goto L_0x04b4
        L_0x04ad:
            android.view.View r2 = r1.findViewById(r15)
            r2.setVisibility(r12)
        L_0x04b4:
            stikerwap.appdys.config r2 = r1.globales
            boolean r2 = r2.emojis
            r0 = 2131361986(0x7f0a00c2, float:1.834374E38)
            if (r2 != 0) goto L_0x04c4
            android.view.View r2 = r1.findViewById(r0)
            r2.setVisibility(r12)
        L_0x04c4:
            android.content.res.Resources r2 = r24.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            r17 = 1120403456(0x42c80000, float:100.0)
            float r2 = r2 * r17
            r17 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r17
            int r2 = (int) r2
            r1.WIDTH_IMGS = r2
            android.content.res.Resources r2 = r24.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            r17 = 1077936128(0x40400000, float:3.0)
            float r2 = r2 * r17
            r17 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r17
            int r2 = (int) r2
            r1.TV_PADDING = r2
            android.content.res.Resources r2 = r24.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            r17 = 1077936128(0x40400000, float:3.0)
            float r2 = r2 * r17
            r17 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r17
            int r2 = (int) r2
            r1.TV_MARGIN = r2
            java.io.File r2 = r24.getFilesDir()
            r1.path = r2
            r1.nfrases = r7
            r1.dia_act = r9
            r1.idusu_act = r9
            r1.hayfrasedeotrousu = r7
            android.content.SharedPreferences r2 = r1.settings
            java.lang.String r4 = "idusu"
            r11 = 0
            long r11 = r2.getLong(r4, r11)
            r1.idusu = r11
            android.content.SharedPreferences r2 = r1.settings
            java.lang.String r4 = "cod"
            java.lang.String r2 = r2.getString(r4, r9)
            r1.codigo = r2
            java.lang.String r2 = "accion"
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r7)
            r1.settings2 = r2
            r2 = 2131362646(0x7f0a0356, float:1.8345078E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r1.llchat = r2
            r1.ll_cabe_mostrar = r7
            android.os.Bundle r2 = r1.extras
            r4 = 2131362573(0x7f0a030d, float:1.834493E38)
            r11 = 2131362572(0x7f0a030c, float:1.8344928E38)
            r12 = 2131363385(0x7f0a0639, float:1.8346577E38)
            if (r2 == 0) goto L_0x05b0
            java.lang.String r3 = "tit_cab"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x05b0
            android.view.View r2 = r1.findViewById(r12)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.os.Bundle r3 = r1.extras
            java.lang.String r0 = "tit_cab"
            java.lang.String r0 = r3.getString(r0)
            r2.setText(r0)
            android.view.View r0 = r1.findViewById(r12)
            stikerwap.appdys.t_chat$5 r2 = new stikerwap.appdys.t_chat$5
            r2.<init>()
            r0.setOnClickListener(r2)
            r0 = 2131362427(0x7f0a027b, float:1.8344634E38)
            android.view.View r0 = r1.findViewById(r0)
            stikerwap.appdys.t_chat$6 r2 = new stikerwap.appdys.t_chat$6
            r2.<init>()
            r0.setOnClickListener(r2)
            android.view.View r0 = r1.findViewById(r11)
            r0.setVisibility(r7)
            r1.ll_cabe_mostrar = r6
            boolean r0 = r1.externo
            if (r0 == 0) goto L_0x0646
            android.content.SharedPreferences r0 = r1.settings
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "tit_chat"
            r2.<init>(r3)
            int r3 = r1.idchat
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.os.Bundle r3 = r1.extras
            java.lang.String r15 = "tit_cab"
            java.lang.String r3 = r3.getString(r15)
            r0.putString(r2, r3)
            r0.commit()
            goto L_0x0646
        L_0x05b0:
            boolean r0 = r1.externo
            if (r0 != 0) goto L_0x05e4
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            boolean r0 = r0.acceso_a_externo
            if (r0 == 0) goto L_0x05e4
            r0 = 2131363386(0x7f0a063a, float:1.834658E38)
            android.view.View r0 = r1.findViewById(r0)
            stikerwap.appdys.t_chat$7 r2 = new stikerwap.appdys.t_chat$7
            r2.<init>()
            r0.setOnClickListener(r2)
            r0 = 2131362428(0x7f0a027c, float:1.8344636E38)
            android.view.View r0 = r1.findViewById(r0)
            stikerwap.appdys.t_chat$8 r2 = new stikerwap.appdys.t_chat$8
            r2.<init>()
            r0.setOnClickListener(r2)
            android.view.View r0 = r1.findViewById(r4)
            r0.setVisibility(r7)
            goto L_0x0646
        L_0x05e4:
            boolean r0 = r1.externo
            if (r0 == 0) goto L_0x0646
            android.content.SharedPreferences r0 = r1.settings
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "tit_chat"
            r2.<init>(r3)
            int r3 = r1.idchat
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.getString(r2, r9)
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x0646
            android.view.View r0 = r1.findViewById(r12)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "  "
            r2.<init>(r3)
            android.content.SharedPreferences r3 = r1.settings
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r12 = "tit_chat"
            r15.<init>(r12)
            int r12 = r1.idchat
            r15.append(r12)
            java.lang.String r12 = r15.toString()
            java.lang.String r3 = r3.getString(r12, r9)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
            r0 = 2131362427(0x7f0a027b, float:1.8344634E38)
            android.view.View r0 = r1.findViewById(r0)
            r2 = 8
            r0.setVisibility(r2)
            android.view.View r0 = r1.findViewById(r11)
            r0.setVisibility(r7)
            r1.ll_cabe_mostrar = r6
        L_0x0646:
            r0 = 0
        L_0x0647:
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r2 = r2.length
            if (r0 >= r2) goto L_0x067d
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r0]
            int r2 = r2.tipo
            r3 = 10
            if (r2 == r3) goto L_0x0670
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r0]
            int r2 = r2.tipo
            r3 = 9
            if (r2 != r3) goto L_0x067a
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r0]
            boolean r2 = r2.acceso_a_externo
            if (r2 == 0) goto L_0x067a
        L_0x0670:
            r2 = 2131362286(0x7f0a01ee, float:1.8344348E38)
            android.view.View r2 = r1.findViewById(r2)
            r2.setVisibility(r7)
        L_0x067a:
            int r0 = r0 + 1
            goto L_0x0647
        L_0x067d:
            android.os.Bundle r0 = r1.extras
            if (r0 == 0) goto L_0x0694
            java.lang.String r2 = "fav"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0694
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "fav"
            boolean r0 = r0.getBoolean(r2)
            r1.fav = r0
            goto L_0x06ac
        L_0x0694:
            android.content.SharedPreferences r0 = r1.settings
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "fav"
            r2.<init>(r3)
            int r3 = r1.idchat
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r0 = r0.getBoolean(r2, r7)
            r1.fav = r0
        L_0x06ac:
            r0 = 2131362286(0x7f0a01ee, float:1.8344348E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            stikerwap.appdys.t_chat$9 r2 = new stikerwap.appdys.t_chat$9
            r2.<init>()
            r0.setOnClickListener(r2)
            boolean r2 = r1.fav
            if (r2 == 0) goto L_0x06d7
            android.content.res.Resources r2 = r24.getResources()
            r3 = 2131231172(0x7f0801c4, float:1.8078418E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            int r3 = r1.c_activ
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.MULTIPLY
            r2.setColorFilter(r3, r12)
            r0.setImageDrawable(r2)
            goto L_0x06f8
        L_0x06d7:
            boolean r2 = r1.c1_esclaro
            if (r2 == 0) goto L_0x06ea
            android.content.res.Resources r2 = r24.getResources()
            r3 = 2131231173(0x7f0801c5, float:1.807842E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            r0.setImageDrawable(r2)
            goto L_0x06f8
        L_0x06ea:
            android.content.res.Resources r2 = r24.getResources()
            r3 = 2131231174(0x7f0801c6, float:1.8078422E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            r0.setImageDrawable(r2)
        L_0x06f8:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "notif"
            if (r0 == 0) goto L_0x070d
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x070d
            android.os.Bundle r0 = r1.extras
            boolean r0 = r0.getBoolean(r2)
            r1.notif = r0
            goto L_0x0758
        L_0x070d:
            boolean r0 = r1.externo
            if (r0 == 0) goto L_0x0741
            android.content.SharedPreferences r0 = r1.settings
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            int r12 = r1.idchat
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x073f
            r0 = 0
        L_0x0728:
            stikerwap.appdys.config r3 = r1.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            int r3 = r3.length
            if (r0 >= r3) goto L_0x073f
            stikerwap.appdys.config r3 = r1.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            r3 = r3[r0]
            int r3 = r3.id
            int r12 = r1.idchat
            if (r3 != r12) goto L_0x073c
            goto L_0x0741
        L_0x073c:
            int r0 = r0 + 1
            goto L_0x0728
        L_0x073f:
            r0 = 0
            goto L_0x0742
        L_0x0741:
            r0 = 1
        L_0x0742:
            android.content.SharedPreferences r3 = r1.settings
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r2)
            int r2 = r1.idchat
            r12.append(r2)
            java.lang.String r2 = r12.toString()
            boolean r0 = r3.getBoolean(r2, r0)
            r1.notif = r0
        L_0x0758:
            r0 = 2131362946(0x7f0a0482, float:1.8345687E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.iv_notif_noactiv = r0
            stikerwap.appdys.t_chat$10 r0 = new stikerwap.appdys.t_chat$10
            r0.<init>()
            android.widget.ImageView r2 = r1.iv_notif_noactiv
            r2.setOnClickListener(r0)
            boolean r0 = r1.notif
            if (r0 == 0) goto L_0x0789
            android.content.res.Resources r0 = r24.getResources()
            r2 = 2131231599(0x7f08036f, float:1.8079284E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
            int r2 = r1.c_activ
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
            r0.setColorFilter(r2, r3)
            android.widget.ImageView r2 = r1.iv_notif_noactiv
            r2.setImageDrawable(r0)
            goto L_0x07ae
        L_0x0789:
            boolean r0 = r1.c1_esclaro
            if (r0 == 0) goto L_0x079e
            android.widget.ImageView r0 = r1.iv_notif_noactiv
            android.content.res.Resources r2 = r24.getResources()
            r3 = 2131231601(0x7f080371, float:1.8079288E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            r0.setImageDrawable(r2)
            goto L_0x07ae
        L_0x079e:
            android.widget.ImageView r0 = r1.iv_notif_noactiv
            android.content.res.Resources r2 = r24.getResources()
            r3 = 2131231602(0x7f080372, float:1.807929E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            r0.setImageDrawable(r2)
        L_0x07ae:
            r0 = 2131362994(0x7f0a04b2, float:1.8345784E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r1.pb_ant = r0
            r0 = 2131362993(0x7f0a04b1, float:1.8345782E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r1.pb_enviando = r0
            boolean r0 = r1.externo
            if (r0 == 0) goto L_0x07d9
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "c1"
            java.lang.String r0 = r0.getString(r2)
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "c2"
            java.lang.String r2 = r2.getString(r3)
            goto L_0x07e9
        L_0x07d9:
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            java.lang.String r0 = r0.c1
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r10]
            java.lang.String r2 = r2.c2
        L_0x07e9:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)
            r12 = 2131361991(0x7f0a00c7, float:1.834375E38)
            android.view.View r15 = r1.findViewById(r12)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            stikerwap.appdys.config r11 = r1.globales
            int r11 = r11.v_ico_perfil
            if (r11 <= 0) goto L_0x0817
            android.content.SharedPreferences r11 = r1.settings
            java.lang.String r4 = "v_ico_perfil_act"
            int r4 = r11.getInt(r4, r7)
            stikerwap.appdys.config r11 = r1.globales
            int r11 = r11.v_ico_perfil
            if (r4 != r11) goto L_0x0817
            stikerwap.appdys.config r4 = r1.globales     // Catch:{ Exception -> 0x0816 }
            java.lang.String r11 = "ico_perfil"
            r4.file_to_iv(r11, r15)     // Catch:{ Exception -> 0x0816 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0816 }
            goto L_0x0817
        L_0x0816:
        L_0x0817:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r7)
            r11 = 2131361988(0x7f0a00c4, float:1.8343744E38)
            android.view.View r15 = r1.findViewById(r11)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            stikerwap.appdys.config r11 = r1.globales
            int r11 = r11.v_ico_privados
            if (r11 <= 0) goto L_0x0845
            android.content.SharedPreferences r11 = r1.settings
            java.lang.String r12 = "v_ico_privados_act"
            int r11 = r11.getInt(r12, r7)
            stikerwap.appdys.config r12 = r1.globales
            int r12 = r12.v_ico_privados
            if (r11 != r12) goto L_0x0845
            stikerwap.appdys.config r11 = r1.globales     // Catch:{ Exception -> 0x0844 }
            java.lang.String r12 = "ico_privados"
            r11.file_to_iv(r12, r15)     // Catch:{ Exception -> 0x0844 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0844 }
            goto L_0x0845
        L_0x0844:
        L_0x0845:
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r7)
            android.view.View r12 = r1.findViewById(r5)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            stikerwap.appdys.config r15 = r1.globales
            int r15 = r15.v_ico_foto
            if (r15 <= 0) goto L_0x0870
            android.content.SharedPreferences r15 = r1.settings
            java.lang.String r5 = "v_ico_foto_act"
            int r5 = r15.getInt(r5, r7)
            stikerwap.appdys.config r15 = r1.globales
            int r15 = r15.v_ico_foto
            if (r5 != r15) goto L_0x0870
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception -> 0x086f }
            java.lang.String r15 = "ico_foto"
            r5.file_to_iv(r15, r12)     // Catch:{ Exception -> 0x086f }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x086f }
            goto L_0x0870
        L_0x086f:
        L_0x0870:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)
            r12 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            android.view.View r15 = r1.findViewById(r12)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            stikerwap.appdys.config r12 = r1.globales
            int r12 = r12.v_ico_video
            if (r12 <= 0) goto L_0x089f
            android.content.SharedPreferences r12 = r1.settings
            java.lang.String r6 = "v_ico_video_act"
            int r6 = r12.getInt(r6, r7)
            stikerwap.appdys.config r12 = r1.globales
            int r12 = r12.v_ico_video
            if (r6 != r12) goto L_0x089f
            stikerwap.appdys.config r6 = r1.globales     // Catch:{ Exception -> 0x089e }
            java.lang.String r12 = "ico_video"
            r6.file_to_iv(r12, r15)     // Catch:{ Exception -> 0x089e }
            r6 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x089e }
            goto L_0x089f
        L_0x089e:
        L_0x089f:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r7)
            r12 = 2131361986(0x7f0a00c2, float:1.834374E38)
            android.view.View r15 = r1.findViewById(r12)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            stikerwap.appdys.config r12 = r1.globales
            int r12 = r12.v_ico_emotic
            if (r12 <= 0) goto L_0x08d2
            android.content.SharedPreferences r12 = r1.settings
            r21 = r6
            java.lang.String r6 = "v_ico_emotic_act"
            int r6 = r12.getInt(r6, r7)
            stikerwap.appdys.config r12 = r1.globales
            int r12 = r12.v_ico_emotic
            if (r6 != r12) goto L_0x08d4
            stikerwap.appdys.config r6 = r1.globales     // Catch:{ Exception -> 0x08d0 }
            java.lang.String r12 = "ico_emotic"
            r6.file_to_iv(r12, r15)     // Catch:{ Exception -> 0x08d0 }
            r6 = 1
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x08d0 }
            r6 = r12
            goto L_0x08d6
        L_0x08d0:
            goto L_0x08d4
        L_0x08d2:
            r21 = r6
        L_0x08d4:
            r6 = r21
        L_0x08d6:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r7)
            r15 = 2131361987(0x7f0a00c3, float:1.8343742E38)
            android.view.View r15 = r1.findViewById(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            stikerwap.appdys.config r7 = r1.globales
            int r7 = r7.v_ico_enviar
            if (r7 <= 0) goto L_0x0914
            android.content.SharedPreferences r7 = r1.settings
            r22 = r12
            java.lang.String r12 = "v_ico_enviar_act"
            r23 = r13
            r13 = 0
            int r7 = r7.getInt(r12, r13)
            stikerwap.appdys.config r12 = r1.globales
            int r12 = r12.v_ico_enviar
            if (r7 != r12) goto L_0x0918
            r7 = 0
            r15.setRotationY(r7)
            stikerwap.appdys.config r7 = r1.globales     // Catch:{ Exception -> 0x090d }
            java.lang.String r12 = "ico_enviar"
            r7.file_to_iv(r12, r15)     // Catch:{ Exception -> 0x090d }
            r7 = 1
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x090d }
            goto L_0x091a
        L_0x090d:
            r7 = 1325274624(0x4efe1600, float:2.13142733E9)
            r15.setRotationY(r7)
            goto L_0x0918
        L_0x0914:
            r22 = r12
            r23 = r13
        L_0x0918:
            r12 = r22
        L_0x091a:
            boolean r7 = r0.equals(r9)
            if (r7 != 0) goto L_0x0b99
            android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r13 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r22 = r14
            r15 = 2
            int[] r14 = new int[r15]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r8)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            r15 = 0
            r14[r15] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            r15 = 1
            r14[r15] = r0
            r7.<init>(r13, r14)
            r0 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setBackgroundDrawable(r7)
            boolean r0 = r1.c1_esclaro
            if (r0 != 0) goto L_0x0a08
            boolean r0 = r3.booleanValue()
            if (r0 != 0) goto L_0x097d
            r0 = 2131361991(0x7f0a00c7, float:1.834375E38)
            android.view.View r3 = r1.findViewById(r0)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.res.Resources r0 = r24.getResources()
            r7 = 2131231618(0x7f080382, float:1.8079322E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r7)
            r3.setImageDrawable(r0)
        L_0x097d:
            boolean r0 = r4.booleanValue()
            if (r0 != 0) goto L_0x099a
            r3 = 2131361988(0x7f0a00c4, float:1.8343744E38)
            android.view.View r0 = r1.findViewById(r3)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.res.Resources r3 = r24.getResources()
            r4 = 2131231632(0x7f080390, float:1.807935E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
            r0.setImageDrawable(r3)
        L_0x099a:
            r0 = 2131361984(0x7f0a00c0, float:1.8343736E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.res.Resources r3 = r24.getResources()
            r4 = 2131231221(0x7f0801f5, float:1.8078517E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
            r0.setImageDrawable(r3)
            r0 = 2131362991(0x7f0a04af, float:1.8345778E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r1.pb_ant = r0
            r0 = 2131362573(0x7f0a030d, float:1.834493E38)
            android.view.View r3 = r1.findViewById(r0)
            int r0 = stikerwap.appdys.config.GRIS_OSCURO
            r3.setBackgroundColor(r0)
            r0 = 2131363386(0x7f0a063a, float:1.834658E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = -1
            r0.setTextColor(r3)
            r0 = 2131362572(0x7f0a030c, float:1.8344928E38)
            android.view.View r3 = r1.findViewById(r0)
            int r0 = stikerwap.appdys.config.GRIS_OSCURO
            r3.setBackgroundColor(r0)
            r0 = 2131363385(0x7f0a0639, float:1.8346577E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = -1
            r0.setTextColor(r3)
            r0 = 2131362574(0x7f0a030e, float:1.8344932E38)
            android.view.View r0 = r1.findViewById(r0)
            int r3 = stikerwap.appdys.config.GRIS_OSCURO
            r0.setBackgroundColor(r3)
            r0 = 2131363387(0x7f0a063b, float:1.8346581E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = -1
            r0.setTextColor(r3)
            goto L_0x0a56
        L_0x0a08:
            r0 = 2131362573(0x7f0a030d, float:1.834493E38)
            android.view.View r3 = r1.findViewById(r0)
            int r0 = stikerwap.appdys.config.GRIS_CLARO
            r3.setBackgroundColor(r0)
            r0 = 2131363386(0x7f0a063a, float:1.834658E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r3 = stikerwap.appdys.config.NEGRO
            r0.setTextColor(r3)
            r0 = 2131362572(0x7f0a030c, float:1.8344928E38)
            android.view.View r3 = r1.findViewById(r0)
            int r0 = stikerwap.appdys.config.GRIS_CLARO
            r3.setBackgroundColor(r0)
            r0 = 2131363385(0x7f0a0639, float:1.8346577E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r3 = stikerwap.appdys.config.NEGRO
            r0.setTextColor(r3)
            r0 = 2131362574(0x7f0a030e, float:1.8344932E38)
            android.view.View r0 = r1.findViewById(r0)
            int r3 = stikerwap.appdys.config.GRIS_CLARO
            r0.setBackgroundColor(r3)
            r0 = 2131363387(0x7f0a063b, float:1.8346581E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r3 = stikerwap.appdys.config.NEGRO
            r0.setTextColor(r3)
        L_0x0a56:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 20
            if (r0 <= r3) goto L_0x0a73
            r0 = 2131362028(0x7f0a00ec, float:1.8343825E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            boolean r3 = r1.c1_esclaro
            r4 = 1
            r3 = r3 ^ r4
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = r1.cbtn
            stikerwap.appdys.config.edittext_color(r0, r3, r4)
            goto L_0x0a81
        L_0x0a73:
            r0 = 2131362028(0x7f0a00ec, float:1.8343825E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setTextColor(r3)
        L_0x0a81:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            r2 = 1025758986(0x3d23d70a, float:0.04)
            r3 = 0
            int r0 = stikerwap.appdys.config.canviarColor(r0, r2, r3)
            r2 = 2131362595(0x7f0a0323, float:1.8344975E38)
            android.view.View r2 = r1.findViewById(r2)
            r2.setBackgroundColor(r0)
            boolean r2 = r1.c2_esclaro
            if (r2 != 0) goto L_0x0b09
            boolean r2 = r11.booleanValue()
            if (r2 != 0) goto L_0x0ac4
            r2 = 2131361989(0x7f0a00c5, float:1.8343746E38)
            android.view.View r3 = r1.findViewById(r2)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.res.Resources r2 = r24.getResources()
            r4 = 2131231620(0x7f080384, float:1.8079326E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r4)
            r3.setImageDrawable(r2)
        L_0x0ac4:
            boolean r2 = r5.booleanValue()
            if (r2 != 0) goto L_0x0ae1
            r2 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            android.view.View r3 = r1.findViewById(r2)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.res.Resources r2 = r24.getResources()
            r4 = 2131231920(0x7f0804b0, float:1.8079935E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r4)
            r3.setImageDrawable(r2)
        L_0x0ae1:
            boolean r2 = r6.booleanValue()
            if (r2 != 0) goto L_0x0afe
            r2 = 2131361986(0x7f0a00c2, float:1.834374E38)
            android.view.View r3 = r1.findViewById(r2)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.res.Resources r2 = r24.getResources()
            r4 = 2131231073(0x7f080161, float:1.8078217E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r4)
            r3.setImageDrawable(r2)
        L_0x0afe:
            r2 = 2131362992(0x7f0a04b0, float:1.834578E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            r1.pb_enviando = r2
        L_0x0b09:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 20
            if (r2 <= r3) goto L_0x0b1d
            android.widget.ProgressBar r2 = r1.pb_ant
            java.lang.String r3 = r1.cbtn
            stikerwap.appdys.config.progress_color(r2, r3)
            android.widget.ProgressBar r2 = r1.pb_enviando
            java.lang.String r3 = r1.cbtn
            stikerwap.appdys.config.progress_color(r2, r3)
        L_0x0b1d:
            boolean r2 = r12.booleanValue()
            if (r2 != 0) goto L_0x0b9b
            android.content.res.Resources r2 = r24.getResources()
            r3 = 2131230929(0x7f0800d1, float:1.8077925E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            java.lang.String r3 = r1.cbtn
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L_0x0b8c
            java.lang.String r3 = r1.cbtn     // Catch:{ Exception -> 0x0b8c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0b8c }
            r4.<init>()     // Catch:{ Exception -> 0x0b8c }
            r4.append(r8)     // Catch:{ Exception -> 0x0b8c }
            r4.append(r3)     // Catch:{ Exception -> 0x0b8c }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0b8c }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ Exception -> 0x0b8c }
            int r4 = android.graphics.Color.blue(r0)     // Catch:{ Exception -> 0x0b8c }
            int r5 = android.graphics.Color.red(r0)     // Catch:{ Exception -> 0x0b8c }
            if (r4 != r5) goto L_0x0b87
            int r4 = android.graphics.Color.red(r0)     // Catch:{ Exception -> 0x0b8c }
            int r5 = android.graphics.Color.green(r0)     // Catch:{ Exception -> 0x0b8c }
            if (r4 != r5) goto L_0x0b87
            int r4 = android.graphics.Color.blue(r3)     // Catch:{ Exception -> 0x0b8c }
            int r5 = android.graphics.Color.red(r3)     // Catch:{ Exception -> 0x0b8c }
            if (r4 != r5) goto L_0x0b87
            int r4 = android.graphics.Color.red(r3)     // Catch:{ Exception -> 0x0b8c }
            int r5 = android.graphics.Color.green(r3)     // Catch:{ Exception -> 0x0b8c }
            if (r4 != r5) goto L_0x0b87
            boolean r0 = stikerwap.appdys.config.esClaro_int(r0)     // Catch:{ Exception -> 0x0b8c }
            if (r0 == 0) goto L_0x0b87
            boolean r0 = stikerwap.appdys.config.esClaro_int(r3)     // Catch:{ Exception -> 0x0b8c }
            if (r0 == 0) goto L_0x0b87
            r0 = 1045220557(0x3e4ccccd, float:0.2)
            r4 = 0
            int r3 = stikerwap.appdys.config.canviarColor(r3, r0, r4)     // Catch:{ Exception -> 0x0b8c }
        L_0x0b87:
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch:{ Exception -> 0x0b8c }
            r2.setColorFilter(r3, r0)     // Catch:{ Exception -> 0x0b8c }
        L_0x0b8c:
            r0 = 2131361987(0x7f0a00c3, float:1.8343742E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setImageDrawable(r2)
            goto L_0x0b9b
        L_0x0b99:
            r22 = r14
        L_0x0b9b:
            boolean r0 = r1.externo
            if (r0 != 0) goto L_0x0c9b
            stikerwap.appdys.config r0 = r1.globales
            stikerwap.appdys.Seccion[] r0 = r0.secciones_a
            r0 = r0[r10]
            int r0 = r0.idfondo
            stikerwap.appdys.config r2 = r1.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r10]
            int r2 = r2.vfondo
            stikerwap.appdys.config r3 = r1.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            r3 = r3[r10]
            boolean r3 = r3.fondo_modif
            stikerwap.appdys.config r4 = r1.globales
            stikerwap.appdys.Seccion[] r4 = r4.secciones_a
            r4 = r4[r10]
            boolean r4 = r4.fondo_margen
            stikerwap.appdys.config r5 = r1.globales
            stikerwap.appdys.Seccion[] r5 = r5.secciones_a
            r5 = r5[r10]
            int r5 = r5.fondo_tipo
            r6 = 2131362464(0x7f0a02a0, float:1.834471E38)
            if (r0 <= 0) goto L_0x0c62
            if (r3 != 0) goto L_0x0bfb
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x0c9b }
            android.view.View r3 = r1.findViewById(r6)     // Catch:{ Exception -> 0x0c9b }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x0c9b }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0c9b }
            r2.tratar_fondo(r3, r4, r5)     // Catch:{ Exception -> 0x0c9b }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x0c9b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0c9b }
            r3.<init>()     // Catch:{ Exception -> 0x0c9b }
            java.lang.String r4 = "fondo_"
            r3.append(r4)     // Catch:{ Exception -> 0x0c9b }
            r3.append(r0)     // Catch:{ Exception -> 0x0c9b }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0c9b }
            android.view.View r3 = r1.findViewById(r6)     // Catch:{ Exception -> 0x0c9b }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x0c9b }
            r2.file_to_iv(r0, r3)     // Catch:{ Exception -> 0x0c9b }
            goto L_0x0c9b
        L_0x0bfb:
            stikerwap.appdys.t_chat$cargarfoto r3 = new stikerwap.appdys.t_chat$cargarfoto
            r6 = 0
            r3.<init>()
            r6 = 5
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r9)
            java.lang.String r0 = r8.toString()
            r8 = 0
            r6[r8] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r8 = 1
            r6[r8] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r2 = 2
            r6[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r2 = 3
            r6[r2] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r2 = 4
            r6[r2] = r0
            r3.execute(r6)
            goto L_0x0c9b
        L_0x0c62:
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.fondo_v
            if (r0 <= 0) goto L_0x0c9b
            android.content.SharedPreferences r0 = r1.settings
            java.lang.String r2 = "fondo_v_act"
            r3 = 0
            int r0 = r0.getInt(r2, r3)
            stikerwap.appdys.config r2 = r1.globales
            int r2 = r2.fondo_v
            if (r0 != r2) goto L_0x0c9b
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x0c9b }
            android.view.View r2 = r1.findViewById(r6)     // Catch:{ Exception -> 0x0c9b }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0c9b }
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception -> 0x0c9b }
            boolean r3 = r3.fondo_margen     // Catch:{ Exception -> 0x0c9b }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0c9b }
            stikerwap.appdys.config r4 = r1.globales     // Catch:{ Exception -> 0x0c9b }
            int r4 = r4.fondo_tipo     // Catch:{ Exception -> 0x0c9b }
            r0.tratar_fondo(r2, r3, r4)     // Catch:{ Exception -> 0x0c9b }
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x0c9b }
            java.lang.String r2 = "fondo"
            android.view.View r3 = r1.findViewById(r6)     // Catch:{ Exception -> 0x0c9b }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x0c9b }
            r0.file_to_iv(r2, r3)     // Catch:{ Exception -> 0x0c9b }
        L_0x0c9b:
            android.view.WindowManager r0 = r24.getWindowManager()
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>()
            r0.getSize(r2)
            int r0 = r2.y
            r1.altura = r0
            r2 = 0
            r1.es_privado = r2
            android.content.SharedPreferences r0 = r1.settings
            java.lang.String r2 = "idprivado"
            r3 = r22
            java.lang.String r0 = r0.getString(r2, r3)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0d9d
            r2 = 1
            r1.es_privado = r2
            r2 = 2131361988(0x7f0a00c4, float:1.8343744E38)
            android.view.View r0 = r1.findViewById(r2)
            r2 = 8
            r0.setVisibility(r2)
            r0 = 2131361991(0x7f0a00c7, float:1.834375E38)
            android.view.View r4 = r1.findViewById(r0)
            r4.setVisibility(r2)
            stikerwap.appdys.config r0 = r1.globales
            boolean r0 = r0.fotos_privados
            if (r0 == 0) goto L_0x0ced
            r0 = 2131361989(0x7f0a00c5, float:1.8343746E38)
            android.view.View r4 = r1.findViewById(r0)
            r5 = 0
            r4.setVisibility(r5)
            goto L_0x0cf7
        L_0x0ced:
            r0 = 2131361989(0x7f0a00c5, float:1.8343746E38)
            android.view.View r4 = r1.findViewById(r0)
            r4.setVisibility(r2)
        L_0x0cf7:
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.cvm
            r4 = 1
            if (r0 == r4) goto L_0x0d11
            stikerwap.appdys.config r0 = r1.globales
            int r0 = r0.cvm
            r4 = 3
            if (r0 != r4) goto L_0x0d06
            goto L_0x0d11
        L_0x0d06:
            r0 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            android.view.View r4 = r1.findViewById(r0)
            r4.setVisibility(r2)
            goto L_0x0d1c
        L_0x0d11:
            r0 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            android.view.View r2 = r1.findViewById(r0)
            r4 = 0
            r2.setVisibility(r4)
        L_0x0d1c:
            r0 = 2131363387(0x7f0a063b, float:1.8346581E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.res.Resources r4 = r24.getResources()
            r5 = 2131886229(0x7f120095, float:1.940703E38)
            java.lang.String r4 = r4.getString(r5)
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            android.content.SharedPreferences r4 = r1.settings
            java.lang.String r5 = "nombreprivado"
            java.lang.String r4 = r4.getString(r5, r9)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
            boolean r0 = r1.es_privado_root
            if (r0 == 0) goto L_0x0d61
            r0 = 2131362429(0x7f0a027d, float:1.8344638E38)
            android.view.View r0 = r1.findViewById(r0)
            r2 = 8
            r0.setVisibility(r2)
            r4 = 0
            goto L_0x0d6e
        L_0x0d61:
            r2 = 8
            r0 = 2131362429(0x7f0a027d, float:1.8344638E38)
            android.view.View r0 = r1.findViewById(r0)
            r4 = 0
            r0.setVisibility(r4)
        L_0x0d6e:
            r0 = 2131362574(0x7f0a030e, float:1.8344932E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setVisibility(r4)
            r0 = 2131362596(0x7f0a0324, float:1.8344977E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setVisibility(r2)
            r0 = 2131362572(0x7f0a030c, float:1.8344928E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setVisibility(r2)
            r0 = 2131362573(0x7f0a030d, float:1.834493E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setVisibility(r2)
            r0 = 2131361991(0x7f0a00c7, float:1.834375E38)
            r2 = 2131361988(0x7f0a00c4, float:1.8343744E38)
            goto L_0x0db2
        L_0x0d9d:
            r2 = 2131361988(0x7f0a00c4, float:1.8343744E38)
            r4 = 0
            android.view.View r0 = r1.findViewById(r2)
            r0.setVisibility(r4)
            r0 = 2131361991(0x7f0a00c7, float:1.834375E38)
            android.view.View r5 = r1.findViewById(r0)
            r5.setVisibility(r4)
        L_0x0db2:
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            android.view.View r0 = r1.findViewById(r2)
            r0.setOnClickListener(r1)
            r0 = 2131361989(0x7f0a00c5, float:1.8343746E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131362429(0x7f0a027d, float:1.8344638E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131361984(0x7f0a00c0, float:1.8343736E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131361986(0x7f0a00c2, float:1.834374E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131361987(0x7f0a00c3, float:1.8343742E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131362028(0x7f0a00ec, float:1.8343825E38)
            android.view.View r0 = r1.findViewById(r0)
            r0.setOnKeyListener(r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.fotos_m = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.acargar_m = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.intentados_m = r0
            r2 = 0
            r1.bm_propia = r2
            boolean r0 = r1.c_fondotxt_esclaro     // Catch:{ OutOfMemoryError -> 0x0e3e }
            if (r0 == 0) goto L_0x0e30
            android.content.res.Resources r0 = r24.getResources()     // Catch:{ OutOfMemoryError -> 0x0e3e }
            r2 = 2131231691(0x7f0803cb, float:1.807947E38)
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r2)     // Catch:{ OutOfMemoryError -> 0x0e3e }
            r1.bm_propia = r0     // Catch:{ OutOfMemoryError -> 0x0e3e }
            goto L_0x0e3f
        L_0x0e30:
            android.content.res.Resources r0 = r24.getResources()     // Catch:{ OutOfMemoryError -> 0x0e3e }
            r2 = 2131231689(0x7f0803c9, float:1.8079466E38)
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r2)     // Catch:{ OutOfMemoryError -> 0x0e3e }
            r1.bm_propia = r0     // Catch:{ OutOfMemoryError -> 0x0e3e }
            goto L_0x0e3f
        L_0x0e3e:
        L_0x0e3f:
            int r0 = r1.fotos_perfil
            if (r0 <= 0) goto L_0x0e97
            stikerwap.appdys.config r0 = r1.globales
            r2 = 1
            java.io.File r0 = r0.getTempFile(r1, r2)
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0e96 }
            r4.<init>()     // Catch:{ Exception -> 0x0e96 }
            r4.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x0e96 }
            java.lang.String r5 = r0.getPath()     // Catch:{ Exception -> 0x0e96 }
            android.graphics.BitmapFactory.decodeFile(r5, r4)     // Catch:{ Exception -> 0x0e96 }
            int r5 = r4.outWidth     // Catch:{ Exception -> 0x0e96 }
            int r5 = r4.outWidth     // Catch:{ Exception -> 0x0e96 }
            int r4 = r4.outHeight     // Catch:{ Exception -> 0x0e96 }
            r6 = 75
            r7 = 100
            if (r5 > r6) goto L_0x0e67
            if (r4 > r7) goto L_0x0e67
            goto L_0x0e68
        L_0x0e67:
            r2 = 0
        L_0x0e68:
            if (r2 != 0) goto L_0x0e87
            int r2 = stikerwap.appdys.config.calculateNewWidth(r5, r4, r6, r7)     // Catch:{ Exception -> 0x0e96 }
            float r4 = (float) r5     // Catch:{ Exception -> 0x0e96 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x0e96 }
            float r4 = r4 / r2
            int r2 = java.lang.Math.round(r4)     // Catch:{ Exception -> 0x0e96 }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0e96 }
            r4.<init>()     // Catch:{ Exception -> 0x0e96 }
            r4.inSampleSize = r2     // Catch:{ Exception -> 0x0e96 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0e96 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r4)     // Catch:{ Exception -> 0x0e96 }
            r1.bm_propia = r0     // Catch:{ Exception -> 0x0e96 }
            goto L_0x0e97
        L_0x0e87:
            android.content.ContentResolver r2 = r24.getContentResolver()     // Catch:{ Exception -> 0x0e96 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception -> 0x0e96 }
            android.graphics.Bitmap r0 = android.provider.MediaStore.Images.Media.getBitmap(r2, r0)     // Catch:{ Exception -> 0x0e96 }
            r1.bm_propia = r0     // Catch:{ Exception -> 0x0e96 }
            goto L_0x0e97
        L_0x0e96:
        L_0x0e97:
            android.os.Bundle r0 = r1.extras
            if (r0 == 0) goto L_0x0eb7
            java.lang.String r2 = "empezar_privado"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0eb7
            android.os.Bundle r0 = r1.extras
            r2 = r23
            java.lang.String r0 = r0.getString(r2)
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "nombre_remit"
            java.lang.String r2 = r2.getString(r3)
            r1.iniciar_privado(r0, r2)
            goto L_0x0efa
        L_0x0eb7:
            r2 = r23
            r4 = 0
            r1.idfrase_masantigua_glob = r4
            boolean r0 = r1.externo
            if (r0 == 0) goto L_0x0eca
            android.os.Bundle r0 = r1.extras
            if (r0 == 0) goto L_0x0eca
            boolean r0 = r0.containsKey(r2)
            if (r0 != 0) goto L_0x0edf
        L_0x0eca:
            stikerwap.appdys.t_chat$cargar_ultimas r0 = new stikerwap.appdys.t_chat$cargar_ultimas
            android.content.SharedPreferences r4 = r1.settings
            java.lang.String r5 = "idprivado"
            java.lang.String r4 = r4.getString(r5, r3)
            int r5 = r1.idfrase_masantigua_glob
            r0.<init>(r3, r4, r5)
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]
            r0.execute(r3)
        L_0x0edf:
            android.os.Bundle r0 = r1.extras
            if (r0 == 0) goto L_0x0efa
            java.lang.String r0 = r0.getString(r2)
            if (r0 == 0) goto L_0x0efa
            android.os.Bundle r0 = r1.extras
            java.lang.String r0 = r0.getString(r2)
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "nombre_remit"
            java.lang.String r2 = r2.getString(r3)
            r1.mostrar_solicprivado(r0, r2)
        L_0x0efa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public void ir_a_externo() {
        Intent intent;
        Intent intent2 = new Intent();
        intent2.putExtra("finalizar", true);
        setResult(-1, intent2);
        if (this.secc_act.idsubcat > 0) {
            intent = new Intent(this, t_buscchats_lista.class);
            intent.putExtra("ind", this.globales.ind_secc_sel_2);
            intent.putExtra("idcat", this.secc_act.idcat);
            intent.putExtra("idsubcat", this.secc_act.idsubcat);
        } else {
            intent = new Intent(this, t_buscchats.class);
            intent.putExtra("ind", this.globales.ind_secc_sel_2);
            intent.putExtra("idcat", this.secc_act.idcat);
        }
        if (this.globales.tipomenu != 2) {
            intent.putExtra("es_root", true);
        }
        this.es_root = false;
        this.finalizar = true;
        finalizar();
        finish();
        startActivity(intent);
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
            SharedPreferences.Editor edit = this.settings.edit();
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
            if (!this.notif) {
                Drawable drawable = getResources().getDrawable(R.drawable.notif_blanco);
                drawable.setColorFilter(this.c_activ, PorterDuff.Mode.MULTIPLY);
                this.iv_notif_noactiv.setImageDrawable(drawable);
                this.notif = true;
                SharedPreferences.Editor edit2 = this.settings.edit();
                edit2.putBoolean("notif" + this.idchat, true);
                edit2.commit();
                new config.modif_usuchat(this.idusu, this.codigo, this.idchat, "notif", 1).execute(new String[0]);
            }
            if (this.settings.getString("idprivado", "0").equals("0")) {
                this.globales.toca_int_chat(this);
                config config = this.globales;
                SharedPreferences sharedPreferences = this.settings;
                config.toca_inchat(this, sharedPreferences, this.idtema + "");
            }
            this.spool.add(trim);
            enviar enviar2 = this.env;
            if (enviar2 == null || enviar2.getStatus() != AsyncTask.Status.RUNNING) {
                enviar enviar3 = new enviar();
                this.env = enviar3;
                enviar3.execute(new String[0]);
            }
            String string = this.settings.getString("idprivado", "0");
            if (!string.equals("0")) {
                SharedPreferences sharedPreferences2 = this.settings;
                if (!sharedPreferences2.contains("usufav_" + string)) {
                    SharedPreferences sharedPreferences3 = this.settings;
                    if (!sharedPreferences3.contains("usufav_noactivar_" + string)) {
                        SharedPreferences.Editor edit3 = this.settings.edit();
                        edit3.putBoolean("usufav_" + string, true);
                        edit3.commit();
                    }
                }
            }
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
                        button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
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
    /* JADX WARNING: Can't wrap try/catch for region: R(13:106|107|108|(1:112)|113|(2:116|114)|145|117|118|119|120|121|162) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x02c4 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x014d A[SYNTHETIC, Splitter:B:55:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018a A[Catch:{ Exception -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a5 A[Catch:{ Exception -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0232 A[LOOP:3: B:95:0x0226->B:97:0x0232, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r21, int r22, android.content.Intent r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            stikerwap.appdys.config r4 = r1.globales
            if (r4 == 0) goto L_0x0013
            boolean r4 = r4.onActivityResult_glob(r0, r2, r3, r1)
            if (r4 == 0) goto L_0x0013
            return
        L_0x0013:
            r4 = -1
            if (r2 != r4) goto L_0x032d
            r2 = 108(0x6c, float:1.51E-43)
            java.lang.String r5 = ""
            r6 = 100
            r7 = 99
            r8 = 0
            if (r0 != r2) goto L_0x0066
            java.lang.String r0 = "dt_foto98_temp.mp4"
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r0 = r2.getExtTempFile_libre(r1, r0)
            java.lang.String r0 = r0.getAbsolutePath()
            if (r0 == 0) goto L_0x032d
            boolean r2 = r0.equals(r5)
            if (r2 != 0) goto L_0x032d
            boolean r2 = r1.pretratar_video(r0)
            if (r2 != 0) goto L_0x003c
            return
        L_0x003c:
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r2 = r2.getTempFile(r1, r6)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x004b
            int r6 = r6 + 1
            goto L_0x003c
        L_0x004b:
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r2 = r2.getTempFile(r1, r7)
            stikerwap.appdys.config r3 = r1.globales
            java.io.File r3 = r3.getTempFile(r1, r6)
            r2.renameTo(r3)
            stikerwap.appdys.t_chat$enviar_video r2 = new stikerwap.appdys.t_chat$enviar_video
            r2.<init>(r6, r0)
            java.lang.String[] r0 = new java.lang.String[r8]
            r2.execute(r0)
            goto L_0x032d
        L_0x0066:
            r2 = 4
            r9 = 1
            if (r0 != r2) goto L_0x00d9
            android.net.Uri r0 = r23.getData()
            android.content.Context r2 = r20.getApplicationContext()
            java.lang.String r2 = stikerwap.appdys.config.generatePath(r0, r2)
            java.lang.String r3 = "."
            int r3 = r2.lastIndexOf(r3)
            int r3 = r3 + r9
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
            if (r0 == 0) goto L_0x032d
            boolean r2 = r0.equals(r5)
            if (r2 != 0) goto L_0x032d
            boolean r2 = r1.pretratar_video(r0)
            if (r2 != 0) goto L_0x00af
            return
        L_0x00af:
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r2 = r2.getTempFile(r1, r6)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00be
            int r6 = r6 + 1
            goto L_0x00af
        L_0x00be:
            stikerwap.appdys.config r2 = r1.globales
            java.io.File r2 = r2.getTempFile(r1, r7)
            stikerwap.appdys.config r3 = r1.globales
            java.io.File r3 = r3.getTempFile(r1, r6)
            r2.renameTo(r3)
            stikerwap.appdys.t_chat$enviar_video r2 = new stikerwap.appdys.t_chat$enviar_video
            r2.<init>(r6, r0)
            java.lang.String[] r0 = new java.lang.String[r8]
            r2.execute(r0)
            goto L_0x032d
        L_0x00d9:
            r2 = 106(0x6a, float:1.49E-43)
            java.lang.String r11 = "orientation"
            r12 = 800(0x320, float:1.121E-42)
            if (r0 != r2) goto L_0x0255
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0146 }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x0146 }
            java.io.File r2 = r2.getExtTempFile(r1, r7)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0146 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0146 }
            long r2 = r0.length()     // Catch:{ Exception -> 0x0146 }
            android.content.Context r0 = r20.getApplicationContext()     // Catch:{ Exception -> 0x0146 }
            android.content.ContentResolver r13 = r0.getContentResolver()     // Catch:{ Exception -> 0x0146 }
            android.net.Uri r14 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0146 }
            java.lang.String r0 = "_size"
            java.lang.String[] r15 = new java.lang.String[]{r11, r0}     // Catch:{ Exception -> 0x0146 }
            java.lang.String r16 = "date_added>=?"
            java.lang.String[] r0 = new java.lang.String[r9]     // Catch:{ Exception -> 0x0146 }
            long r10 = r1.captureTime     // Catch:{ Exception -> 0x0146 }
            r17 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 / r17
            r17 = 1
            long r10 = r10 - r17
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0146 }
            r0[r8] = r5     // Catch:{ Exception -> 0x0146 }
            java.lang.String r18 = "date_added desc"
            r17 = r0
            android.database.Cursor r0 = r13.query(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0146 }
            if (r0 == 0) goto L_0x0143
            long r10 = r1.captureTime     // Catch:{ Exception -> 0x0146 }
            r13 = 0
            int r5 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r5 == 0) goto L_0x0143
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0146 }
            if (r5 == 0) goto L_0x0143
        L_0x0130:
            boolean r5 = r0.moveToNext()     // Catch:{ Exception -> 0x0146 }
            if (r5 == 0) goto L_0x0143
            long r10 = r0.getLong(r9)     // Catch:{ Exception -> 0x0146 }
            int r5 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0130
            int r0 = r0.getInt(r8)     // Catch:{ Exception -> 0x0146 }
            goto L_0x0144
        L_0x0143:
            r0 = -1
        L_0x0144:
            r2 = r0
            goto L_0x014b
        L_0x0146:
            r0 = move-exception
            r0.printStackTrace()
            r2 = -1
        L_0x014b:
            if (r2 != r4) goto L_0x0167
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0163 }
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ IOException -> 0x0163 }
            java.io.File r3 = r3.getExtTempFile(r1, r7)     // Catch:{ IOException -> 0x0163 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0163 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0163 }
            java.lang.String r3 = "Orientation"
            int r2 = r0.getAttributeInt(r3, r4)     // Catch:{ IOException -> 0x0163 }
            goto L_0x0167
        L_0x0163:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0167:
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x01c8 }
            java.io.File r0 = r0.getExtTempFile(r1, r7)     // Catch:{ Exception -> 0x01c8 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x01c8 }
            r3.<init>()     // Catch:{ Exception -> 0x01c8 }
            r3.inJustDecodeBounds = r9     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r5 = r0.getPath()     // Catch:{ Exception -> 0x01c8 }
            android.graphics.BitmapFactory.decodeFile(r5, r3)     // Catch:{ Exception -> 0x01c8 }
            int r5 = r3.outWidth     // Catch:{ Exception -> 0x01c8 }
            int r5 = r3.outWidth     // Catch:{ Exception -> 0x01c8 }
            int r3 = r3.outHeight     // Catch:{ Exception -> 0x01c8 }
            if (r5 > r12) goto L_0x0187
            if (r3 > r12) goto L_0x0187
            r10 = 1
            goto L_0x0188
        L_0x0187:
            r10 = 0
        L_0x0188:
            if (r10 != 0) goto L_0x01a5
            int r3 = stikerwap.appdys.config.calculateNewWidth(r5, r3, r12, r12)     // Catch:{ Exception -> 0x01c8 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x01c8 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x01c8 }
            float r5 = r5 / r3
            int r3 = java.lang.Math.round(r5)     // Catch:{ Exception -> 0x01c8 }
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x01c8 }
            r5.<init>()     // Catch:{ Exception -> 0x01c8 }
            r5.inSampleSize = r3     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x01c8 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r5)     // Catch:{ Exception -> 0x01c8 }
            goto L_0x01b1
        L_0x01a5:
            android.content.ContentResolver r3 = r20.getContentResolver()     // Catch:{ Exception -> 0x01c8 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception -> 0x01c8 }
            android.graphics.Bitmap r0 = android.provider.MediaStore.Images.Media.getBitmap(r3, r0)     // Catch:{ Exception -> 0x01c8 }
        L_0x01b1:
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception -> 0x01c8 }
            java.io.File r3 = r3.getExtTempFile(r1, r7)     // Catch:{ Exception -> 0x01c8 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01c6 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x01c6 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x01c6 }
            r10 = 75
            r0.compress(r3, r10, r5)     // Catch:{ Exception -> 0x01c6 }
            r10 = 100
            goto L_0x01ce
        L_0x01c6:
            goto L_0x01cc
        L_0x01c8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01cc:
            r10 = 75
        L_0x01ce:
            if (r2 == r4) goto L_0x0226
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r3 = 3
            if (r2 != r3) goto L_0x01db
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x01e9
        L_0x01db:
            r3 = 8
            if (r2 != r3) goto L_0x01e2
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x01e9
        L_0x01e2:
            r3 = 6
            if (r2 != r3) goto L_0x01e8
            r2 = 90
            goto L_0x01e9
        L_0x01e8:
            r2 = 0
        L_0x01e9:
            if (r2 <= 0) goto L_0x0226
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception -> 0x0222 }
            java.io.File r3 = r3.getExtTempFile(r1, r7)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0222 }
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r3)     // Catch:{ Exception -> 0x0222 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x0222 }
            r0.postRotate(r2)     // Catch:{ Exception -> 0x0222 }
            r12 = 0
            r13 = 0
            int r14 = r11.getWidth()     // Catch:{ Exception -> 0x0222 }
            int r15 = r11.getHeight()     // Catch:{ Exception -> 0x0222 }
            r17 = 1
            r16 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0222 }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x0222 }
            java.io.File r2 = r2.getExtTempFile(r1, r7)     // Catch:{ Exception -> 0x0222 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0220 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0220 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0220 }
            r0.compress(r2, r10, r3)     // Catch:{ Exception -> 0x0220 }
            goto L_0x0226
        L_0x0220:
            goto L_0x0226
        L_0x0222:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0226:
            stikerwap.appdys.config r0 = r1.globales
            java.io.File r0 = r0.getTempFile(r1, r6)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0235
            int r6 = r6 + 1
            goto L_0x0226
        L_0x0235:
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x0245 }
            java.io.File r0 = r0.getExtTempFile(r1, r7)     // Catch:{ Exception -> 0x0245 }
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception -> 0x0245 }
            java.io.File r2 = r2.getTempFile(r1, r6)     // Catch:{ Exception -> 0x0245 }
            stikerwap.appdys.config.copy(r0, r2)     // Catch:{ Exception -> 0x0245 }
            goto L_0x0247
        L_0x0245:
            r9 = 0
        L_0x0247:
            if (r9 == 0) goto L_0x032d
            stikerwap.appdys.t_chat$enviar_foto r0 = new stikerwap.appdys.t_chat$enviar_foto
            r0.<init>(r6)
            java.lang.String[] r2 = new java.lang.String[r8]
            r0.execute(r2)
            goto L_0x032d
        L_0x0255:
            r2 = 2
            if (r0 != r2) goto L_0x02d2
            android.net.Uri r0 = r23.getData()
            java.lang.String[] r2 = new java.lang.String[]{r11}     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            android.content.ContentResolver r13 = r20.getContentResolver()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r16 = 0
            r17 = 0
            r18 = 0
            r14 = r0
            r15 = r2
            android.database.Cursor r3 = r13.query(r14, r15, r16, r17, r18)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            if (r3 == 0) goto L_0x0282
            boolean r5 = r3.moveToFirst()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            if (r5 == 0) goto L_0x0282
            r2 = r2[r8]     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            int r2 = r3.getColumnIndex(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            int r4 = r3.getInt(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
        L_0x0282:
            android.graphics.Matrix r2 = new android.graphics.Matrix     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            float r3 = (float) r4     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r2.postRotate(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            stikerwap.appdys.config r3 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            android.graphics.Bitmap r13 = r3.decodeSampledBitmapFromResource(r0, r12, r12)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r14 = 0
            r15 = 0
            int r16 = r13.getWidth()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            int r17 = r13.getHeight()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r19 = 1
            r18 = r2
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
        L_0x02a3:
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            java.io.File r2 = r2.getTempFile(r1, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            boolean r2 = r2.exists()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            if (r2 == 0) goto L_0x02b2
            int r6 = r6 + 1
            goto L_0x02a3
        L_0x02b2:
            stikerwap.appdys.config r2 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            java.io.File r2 = r2.getTempFile(r1, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception | OutOfMemoryError -> 0x02c4 }
            r3.<init>(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x02c4 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception | OutOfMemoryError -> 0x02c4 }
            r4 = 75
            r0.compress(r2, r4, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x02c4 }
        L_0x02c4:
            r0.recycle()     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            stikerwap.appdys.t_chat$enviar_foto r0 = new stikerwap.appdys.t_chat$enviar_foto     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r0.<init>(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            java.lang.String[] r2 = new java.lang.String[r8]     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            r0.execute(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x032d }
            goto L_0x032d
        L_0x02d2:
            if (r3 == 0) goto L_0x02e4
            java.lang.String r0 = "idusu_ban"
            boolean r2 = r3.hasExtra(r0)
            if (r2 == 0) goto L_0x02e4
            java.lang.String r0 = r3.getStringExtra(r0)
            ocultar_frases(r1, r0)
            goto L_0x032d
        L_0x02e4:
            if (r3 == 0) goto L_0x0302
            java.lang.String r0 = "abrir_privado"
            boolean r0 = r3.hasExtra(r0)
            if (r0 == 0) goto L_0x0302
            android.content.SharedPreferences r0 = r1.settings2
            java.lang.String r2 = "id_remit"
            java.lang.String r0 = r0.getString(r2, r5)
            android.content.SharedPreferences r2 = r1.settings2
            java.lang.String r3 = "nombre_remit"
            java.lang.String r2 = r2.getString(r3, r5)
            r1.iniciar_privado(r0, r2)
            goto L_0x032d
        L_0x0302:
            if (r3 == 0) goto L_0x032d
            java.lang.String r0 = "finalizar"
            boolean r2 = r3.hasExtra(r0)
            if (r2 == 0) goto L_0x032d
            android.os.Bundle r2 = r23.getExtras()
            boolean r0 = r2.getBoolean(r0)
            if (r0 == 0) goto L_0x032d
            android.os.Bundle r0 = r23.getExtras()
            java.lang.String r2 = "finalizar_app"
            boolean r0 = r0.getBoolean(r2)
            if (r0 != 0) goto L_0x0324
            r1.es_root = r8
        L_0x0324:
            r1.setResult(r4, r3)
            r20.finalizar()
            r20.finish()
        L_0x032d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.onActivityResult(int, int, android.content.Intent):void");
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
            config.iniciar_tomardecamara(this, config.getExtTempFile(this, 99));
        } else {
            config config2 = this.globales;
            config2.iniciar_tomardecamara_v(this, config2.getExtTempFile_libre(this, "dt_foto98_temp.mp4"));
        }
    }

    private void tomar_foto() {
        final AlertDialog create = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.tomardecamara), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!t_chat.this.globales.tener_que_pedir_p_camara(t_chat.this, 107)) {
                    t_chat.this.captureTime = System.currentTimeMillis();
                    config r4 = t_chat.this.globales;
                    t_chat t_chat = t_chat.this;
                    r4.iniciar_tomardecamara(t_chat, t_chat.globales.getExtTempFile(t_chat.this, 99));
                }
            }
        }).setNegativeButton(getString(R.string.selimg), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                t_chat.this.startActivityForResult(intent, 2);
            }
        }).setMessage(R.string.enviarimg).create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    private void tomar_video() {
        final AlertDialog create = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.tomardecamara), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!t_chat.this.globales.tener_que_pedir_p_camara(t_chat.this, 109)) {
                    config r4 = t_chat.this.globales;
                    t_chat t_chat = t_chat.this;
                    r4.iniciar_tomardecamara_v(t_chat, t_chat.globales.getExtTempFile_libre(t_chat.this, "dt_foto98_temp.mp4"));
                }
            }
        }).setNegativeButton(getString(R.string.selvideo), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("video/*");
                t_chat.this.startActivityForResult(intent, 4);
            }
        }).setMessage(R.string.enviarvideo).create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    static void ocultar_frases(Context context, String str) {
        LinearLayout linearLayout = (LinearLayout) ((Activity) context).findViewById(R.id.llchat);
        if (linearLayout != null) {
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt.getTag() != null && childAt.getTag().equals(str)) {
                    childAt.setVisibility(8);
                }
            }
        }
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.btnfoto) {
            tomar_foto();
        } else if (view.getId() == R.id.btnvideo) {
            tomar_video();
        } else if (view.getId() == R.id.btnfavoritos) {
            Intent intent = new Intent(this, privados.class);
            finalizar();
            startActivityForResult(intent, 0);
        } else {
            boolean z = true;
            if (view.getId() == R.id.btnperfil) {
                Intent intent2 = new Intent(this, preperfil.class);
                if (this.externo) {
                    intent2 = config.completar_externo(intent2, this.extras);
                } else {
                    intent2.putExtra("idsecc", this.idsecc);
                }
                intent2.putExtra("nocompletar", true);
                finalizar();
                startActivityForResult(intent2, 0);
            } else if (view.getId() == R.id.iv_cabe_priv) {
                finalizar_privado(this.settings.getString("idprivado", "0"));
            } else if (view.getId() == R.id.btncargarmas) {
                new cargar_ultimas("0", this.settings.getString("idprivado", "0"), this.idfrase_masantigua_glob).execute(new String[0]);
            } else if (view.getId() == R.id.btnemotic) {
                new EmojisMenu((EditText) findViewById(R.id.c_mensaje), this).show();
            } else if (view.getId() == R.id.btnenv) {
                f_enviar(false);
            } else if (view.getTag(R.id.idaux1) != null && !view.getTag(R.id.idaux1).equals("0") && !view.getTag(R.id.idaux1).equals("1")) {
                Intent intent3 = new Intent(this, profile.class);
                intent3.putExtra("id", (String) view.getTag(R.id.idaux1));
                intent3.putExtra("privados", (String) view.getTag(R.id.idaux2));
                intent3.putExtra("nombre", (String) view.getTag(R.id.idaux3));
                intent3.putExtra("coments", (String) view.getTag(R.id.idaux4));
                intent3.putExtra("fnac_d", (String) view.getTag(R.id.idaux5));
                intent3.putExtra("fnac_m", (String) view.getTag(R.id.idaux6));
                intent3.putExtra("fnac_a", (String) view.getTag(R.id.idaux7));
                intent3.putExtra("sexo", (String) view.getTag(R.id.idaux8));
                intent3.putExtra("vfoto", (String) view.getTag(R.id.idaux9));
                if (view.getTag(R.id.idaux10) != null && ((String) view.getTag(R.id.idaux10)).equals("1")) {
                    intent3.putExtra("desdepriv", "1");
                }
                intent3.putExtra("p_fnac", this.fnac);
                intent3.putExtra("p_sexo", this.sexo);
                intent3.putExtra("p_descr", this.descr);
                intent3.putExtra("p_dist", this.dist);
                intent3.putExtra("coments_chat", this.coments);
                intent3.putExtra("galeria", this.galeria);
                intent3.putExtra("privados_chat", this.privados);
                intent3.putExtra("fotos_perfil", this.fotos_perfil);
                intent3.putExtra("fotos_chat", this.fotos_chat);
                startActivityForResult(intent3, 0);
            } else if (view.getTag() == null || ((String) view.getTag()).length() <= 3 || !((String) view.getTag()).substring(0, 3).equals("img")) {
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
                if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                    abrir_secc(view);
                }
            } else if (view.getTag(R.id.idaux1).equals("0")) {
                String substring = ((String) view.getTag()).substring(3);
                if (view.getTag(R.id.TAG_ESIMGPROPIA) != null) {
                    z = false;
                }
                if (this.globales.getTempFile_notemp(this, Integer.parseInt(substring), z).exists()) {
                    Intent intent4 = new Intent(this, t_url.class);
                    intent4.putExtra("url", AdPayload.FILE_SCHEME + this.globales.getTempFile_notemp(this, Integer.parseInt(substring), z).getAbsolutePath());
                    startActivityForResult(intent4, 0);
                    return;
                }
                obtener_img_g obtener_img_g2 = this.o_i_g;
                if (obtener_img_g2 == null || obtener_img_g2.getStatus() != AsyncTask.Status.RUNNING) {
                    try {
                        this.llchat.findViewWithTag("pb" + substring).setVisibility(0);
                    } catch (Exception unused) {
                    }
                    obtener_img_g obtener_img_g3 = new obtener_img_g(substring);
                    this.o_i_g = obtener_img_g3;
                    obtener_img_g3.execute(new String[0]);
                }
            } else if (view.getTag(R.id.idaux1).equals("1")) {
                String substring2 = ((String) view.getTag()).substring(3);
                String str2 = (String) view.getTag(R.id.idaux2);
                String str3 = (String) view.getTag(R.id.idaux3);
                if (str3.equals("1")) {
                    str = "mp4";
                } else if (str3.equals("2")) {
                    str = "3gp";
                } else if (str3.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    str = "webm";
                } else {
                    return;
                }
                String str4 = "v" + str2 + "." + str;
                String str5 = (String) view.getTag(R.id.idaux4);
                if (this.globales.getTempFile_libre(this, str4).exists()) {
                    Intent intent5 = new Intent(this, t_video.class);
                    intent5.putExtra("url", AdPayload.FILE_SCHEME + this.globales.getTempFile_libre(this, str4).getAbsolutePath());
                    intent5.putExtra("desde_chat", true);
                    startActivityForResult(intent5, 0);
                    return;
                }
                obtener_video obtener_video2 = this.o_v;
                if (obtener_video2 == null || obtener_video2.getStatus() != AsyncTask.Status.RUNNING) {
                    try {
                        this.llchat.findViewWithTag("pb" + substring2).setVisibility(0);
                    } catch (Exception unused2) {
                    }
                    obtener_video obtener_video3 = new obtener_video(substring2, str2, str3, str5);
                    this.o_v = obtener_video3;
                    obtener_video3.execute(new String[0]);
                }
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
                finalizar();
                finish();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_solicprivado(String str, String str2) {
        this.id_remit_global = str;
        this.nombre_remit_global = str2;
        this.idusu_global = this.idusu;
        this.codigo_global = this.codigo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(str2 + " " + getResources().getString(R.string.solicitaprivado)).setItems(R.array.privado_opcs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    t_chat t_chat = t_chat.this;
                    t_chat.iniciar_privado(t_chat.id_remit_global, t_chat.this.nombre_remit_global);
                } else if (i == 1) {
                    SharedPreferences.Editor edit = t_chat.this.settings.edit();
                    edit.putLong("f_ult_" + t_chat.this.id_remit_global, System.currentTimeMillis());
                    edit.commit();
                    if (t_chat.this.externo && t_chat.this.extras.containsKey("id_remit")) {
                        t_chat.this.finalizar = true;
                        t_chat.this.finalizar();
                        t_chat.this.finish();
                    }
                } else if (i == 2) {
                    t_chat.this.d_confirm = new AlertDialog.Builder(t_chat.this).setCancelable(true).setNegativeButton(t_chat.this.getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (t_chat.this.externo && t_chat.this.extras.containsKey("id_remit")) {
                                t_chat.this.finalizar = true;
                                t_chat.this.finalizar();
                                t_chat.this.finish();
                            }
                        }
                    }).setPositiveButton(t_chat.this.getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            config.elim_privado(t_chat.this, t_chat.this.id_remit_global);
                            new cancelar_solicitud(t_chat.this.id_remit_global, 1, t_chat.this.idusu_global, t_chat.this.codigo_global).execute(new String[0]);
                            if (t_chat.this.externo && t_chat.this.extras.containsKey("id_remit")) {
                                t_chat.this.finalizar = true;
                                t_chat.this.finalizar();
                                t_chat.this.finish();
                            }
                        }
                    }).setMessage(R.string.avisodenegarprivados).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        t_chat.this.d_confirm.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = t_chat.this.d_confirm.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                                Button button2 = t_chat.this.d_confirm.getButton(-2);
                                button2.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    t_chat.this.d_confirm.show();
                    try {
                        ((TextView) t_chat.this.d_confirm.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                    } catch (Exception unused) {
                    }
                } else if (i == 3) {
                    t_chat.this.d_confirm = new AlertDialog.Builder(t_chat.this).setCancelable(true).setNegativeButton(t_chat.this.getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (t_chat.this.externo && t_chat.this.extras.containsKey("id_remit")) {
                                t_chat.this.finalizar = true;
                                t_chat.this.finalizar();
                                t_chat.this.finish();
                            }
                        }
                    }).setPositiveButton(t_chat.this.getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new cancelar_solicitud(t_chat.this.id_remit_global, 3, t_chat.this.idusu_global, t_chat.this.codigo_global).execute(new String[0]);
                            SharedPreferences.Editor edit = t_chat.this.settings.edit();
                            edit.putInt("privados", 0);
                            edit.commit();
                            if (t_chat.this.externo && t_chat.this.extras.containsKey("id_remit")) {
                                t_chat.this.finalizar = true;
                                t_chat.this.finalizar();
                                t_chat.this.finish();
                            }
                        }
                    }).setMessage(R.string.confirmar_ningunprivado).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        t_chat.this.d_confirm.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = t_chat.this.d_confirm.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                                Button button2 = t_chat.this.d_confirm.getButton(-2);
                                button2.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    t_chat.this.d_confirm.show();
                    ((TextView) t_chat.this.d_confirm.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                }
            }
        }).setCancelable(false);
        try {
            AlertDialog show = builder.show();
            this.d_solic_privado = show;
            ((TextView) show.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, String str) {
        Dialog dialog;
        AlertDialog alertDialog;
        if (str.equals("fondo_v_act")) {
            if (!this.externo && this.globales.secciones_a[this.globales.ind_secc_sel_2].idfondo == 0) {
                try {
                    this.globales.tratar_fondo((ImageView) findViewById(R.id.iv_fondo), Boolean.valueOf(this.globales.fondo_margen), this.globales.fondo_tipo);
                    ((ImageView) findViewById(R.id.iv_fondo)).setVisibility(8);
                    this.globales.file_to_iv("fondo", (ImageView) findViewById(R.id.iv_fondo));
                    config.fade_in((ImageView) findViewById(R.id.iv_fondo));
                } catch (Exception unused) {
                }
            }
        } else if (!sharedPreferences.contains("accion") || !this.privados) {
            if (sharedPreferences.contains("f2_idfrase")) {
                String string = this.settings.getString("idprivado", "0");
                if (str.equals("f2_ts")) {
                    SharedPreferences sharedPreferences2 = this.settings;
                    if (sharedPreferences2.contains("ban_" + sharedPreferences.getString("f2_id", ""))) {
                        return;
                    }
                    if ((string.equals("0") && !this.es_privado) || (!string.equals("0") && this.es_privado)) {
                        String string2 = sharedPreferences.getString("f2_idtema", "0");
                        if (string2.equals(this.idtema + "") || (!string.equals("0") && this.es_privado)) {
                            if (!string.equals("0") && !string.equals(sharedPreferences.getString("f2_id", ""))) {
                                String string3 = sharedPreferences.getString("f2_id", "");
                                if (!string3.equals(this.idusu + "")) {
                                    return;
                                }
                            }
                            runOnUiThread(new Runnable() {
                                /* JADX WARNING: Code restructure failed: missing block: B:230:0x07a5, code lost:
                                    if (stikerwap.appdys.t_chat.m3058$$Nest$fgetglobales(r1.this$0).bubbles == 4) goto L_0x084c;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:238:0x07d1, code lost:
                                    if (stikerwap.appdys.t_chat.m3058$$Nest$fgetglobales(r1.this$0).bubbles == 4) goto L_0x0812;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:250:0x0810, code lost:
                                    if (stikerwap.appdys.t_chat.m3058$$Nest$fgetglobales(r1.this$0).bubbles == 4) goto L_0x0812;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:251:0x0812, code lost:
                                    r0 = stikerwap.appdys.R.drawable.bubble4_flip;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:252:0x0816, code lost:
                                    r0 = stikerwap.appdys.R.drawable.bubble_flip;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:263:0x084a, code lost:
                                    if (stikerwap.appdys.t_chat.m3058$$Nest$fgetglobales(r1.this$0).bubbles == 4) goto L_0x084c;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:264:0x084c, code lost:
                                    r0 = stikerwap.appdys.R.drawable.bubble4;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:265:0x0850, code lost:
                                    r0 = stikerwap.appdys.R.drawable.bubble;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:3:0x003b, code lost:
                                    if (r7.getString("f2_id", "").equals(stikerwap.appdys.t_chat.m3064$$Nest$fgetidusu_act(r1.this$0) + "") == false) goto L_0x003d;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:7:0x0057, code lost:
                                    if (r7.getString("f2_id", "").equals(r7.getString("f2_idusu_prev", "")) != false) goto L_0x0059;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0059, code lost:
                                    r3 = true;
                                 */
                                /* JADX WARNING: Removed duplicated region for block: B:193:0x067f  */
                                /* JADX WARNING: Removed duplicated region for block: B:194:0x0690  */
                                /* JADX WARNING: Removed duplicated region for block: B:198:0x06be  */
                                /* JADX WARNING: Removed duplicated region for block: B:217:0x0742  */
                                /* JADX WARNING: Removed duplicated region for block: B:269:0x087a  */
                                /* JADX WARNING: Removed duplicated region for block: B:276:0x08a7  */
                                /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
                                /* JADX WARNING: Removed duplicated region for block: B:289:0x090f  */
                                /* JADX WARNING: Removed duplicated region for block: B:329:0x0b27  */
                                /* JADX WARNING: Removed duplicated region for block: B:34:0x0112  */
                                /* JADX WARNING: Removed duplicated region for block: B:35:0x0160  */
                                /* JADX WARNING: Removed duplicated region for block: B:393:0x0f0d  */
                                /* JADX WARNING: Removed duplicated region for block: B:394:0x0f15  */
                                /* JADX WARNING: Removed duplicated region for block: B:405:0x0f96  */
                                /* JADX WARNING: Removed duplicated region for block: B:406:0x0fa5  */
                                /* JADX WARNING: Removed duplicated region for block: B:53:0x0208  */
                                /* JADX WARNING: Removed duplicated region for block: B:56:0x0225  */
                                /* JADX WARNING: Removed duplicated region for block: B:61:0x024f  */
                                /* JADX WARNING: Removed duplicated region for block: B:66:0x02bd  */
                                /* JADX WARNING: Removed duplicated region for block: B:67:0x02c4  */
                                /* JADX WARNING: Removed duplicated region for block: B:70:0x02d1  */
                                /* JADX WARNING: Removed duplicated region for block: B:73:0x0309  */
                                /* JADX WARNING: Removed duplicated region for block: B:82:0x0341  */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public void run() {
                                    /*
                                        r22 = this;
                                        r1 = r22
                                        java.lang.String r0 = "fperfil_"
                                        r2 = 0
                                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r5 = "f2_ultimas"
                                        boolean r4 = r4.getBoolean(r5, r2)
                                        r6 = 1
                                        java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                                        java.lang.String r8 = "f2_id"
                                        java.lang.String r9 = ""
                                        if (r4 != 0) goto L_0x003d
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r4 = r4.getString(r8, r9)
                                        java.lang.StringBuilder r10 = new java.lang.StringBuilder
                                        r10.<init>()
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        java.lang.String r11 = r11.idusu_act
                                        r10.append(r11)
                                        r10.append(r9)
                                        java.lang.String r10 = r10.toString()
                                        boolean r4 = r4.equals(r10)
                                        if (r4 != 0) goto L_0x0059
                                    L_0x003d:
                                        android.content.SharedPreferences r4 = r7
                                        boolean r4 = r4.getBoolean(r5, r2)
                                        if (r4 == 0) goto L_0x005d
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r4 = r4.getString(r8, r9)
                                        android.content.SharedPreferences r10 = r7
                                        java.lang.String r11 = "f2_idusu_prev"
                                        java.lang.String r10 = r10.getString(r11, r9)
                                        boolean r4 = r4.equals(r10)
                                        if (r4 == 0) goto L_0x005d
                                    L_0x0059:
                                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)
                                    L_0x005d:
                                        android.content.SharedPreferences r4 = r7
                                        boolean r4 = r4.getBoolean(r5, r2)
                                        if (r4 != 0) goto L_0x0070
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        android.content.SharedPreferences r10 = r7
                                        java.lang.String r10 = r10.getString(r8, r9)
                                        r4.idusu_act = r10
                                    L_0x0070:
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r4 = r4.getString(r8, r9)
                                        java.lang.StringBuilder r10 = new java.lang.StringBuilder
                                        r10.<init>()
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        long r11 = r11.idusu
                                        r10.append(r11)
                                        r10.append(r9)
                                        java.lang.String r10 = r10.toString()
                                        boolean r4 = r4.equals(r10)
                                        if (r4 == 0) goto L_0x00bc
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        r10 = 2131361984(0x7f0a00c0, float:1.8343736E38)
                                        android.view.View r4 = r4.findViewById(r10)
                                        int r4 = r4.getVisibility()
                                        if (r4 == 0) goto L_0x00ba
                                        android.content.SharedPreferences r4 = r7
                                        boolean r4 = r4.getBoolean(r5, r2)
                                        if (r4 == 0) goto L_0x00b3
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r10 = "f2_mateixusu_hastafinal"
                                        boolean r4 = r4.getBoolean(r10, r2)
                                        if (r4 == 0) goto L_0x00ba
                                        goto L_0x00b9
                                    L_0x00b3:
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        boolean r4 = r4.hayfrasedeotrousu
                                        if (r4 != 0) goto L_0x00ba
                                    L_0x00b9:
                                        goto L_0x00c0
                                    L_0x00ba:
                                        r4 = 1
                                        goto L_0x00c1
                                    L_0x00bc:
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        r4.hayfrasedeotrousu = r6
                                    L_0x00c0:
                                        r4 = 0
                                    L_0x00c1:
                                        android.content.SharedPreferences r10 = r7
                                        boolean r10 = r10.getBoolean(r5, r2)
                                        if (r10 == 0) goto L_0x00f2
                                        android.content.SharedPreferences r10 = r7
                                        java.lang.String r11 = "f2_fcrea"
                                        java.lang.String r10 = r10.getString(r11, r9)
                                        boolean r11 = r10.equals(r9)
                                        if (r11 != 0) goto L_0x00f2
                                        r11 = 6
                                        java.lang.String r10 = r10.substring(r2, r11)
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        java.lang.String r11 = r11.dia_act
                                        boolean r11 = r10.equals(r11)
                                        if (r11 != 0) goto L_0x00f2
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        r11.mostrar_fecha()
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        r11.dia_act = r10
                                    L_0x00f2:
                                        stikerwap.appdys.t_chat r10 = stikerwap.appdys.t_chat.this
                                        java.lang.String r11 = "layout_inflater"
                                        java.lang.Object r10 = r10.getSystemService(r11)
                                        android.view.LayoutInflater r10 = (android.view.LayoutInflater) r10
                                        r11 = 2131558529(0x7f0d0081, float:1.8742376E38)
                                        r12 = 0
                                        android.view.View r10 = r10.inflate(r11, r12)
                                        android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
                                        boolean r11 = r3.booleanValue()
                                        r12 = 4
                                        r13 = 8
                                        r14 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        if (r11 == 0) goto L_0x0160
                                        r11 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                        android.view.View r11 = r10.findViewById(r11)
                                        r11.setVisibility(r12)
                                        r11 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                        android.view.View r11 = r10.findViewById(r11)
                                        android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                                        r11.height = r6
                                        r11 = 2131362421(0x7f0a0275, float:1.8344622E38)
                                        android.view.View r11 = r10.findViewById(r11)
                                        android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                                        r11.height = r6
                                        android.widget.LinearLayout$LayoutParams r11 = new android.widget.LinearLayout$LayoutParams
                                        r15 = -2
                                        r12 = -2
                                        r11.<init>(r15, r12)
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        int r12 = r12.marge_mateix
                                        stikerwap.appdys.t_chat r15 = stikerwap.appdys.t_chat.this
                                        int r15 = r15.marge_mateix
                                        r11.setMargins(r12, r2, r15, r2)
                                        r12 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                        android.view.View r12 = r10.findViewById(r12)
                                        android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
                                        r12.setLayoutParams(r11)
                                        r11 = 2131362603(0x7f0a032b, float:1.8344991E38)
                                        android.view.View r11 = r10.findViewById(r11)
                                        r11.setVisibility(r13)
                                        goto L_0x01d9
                                    L_0x0160:
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        int r11 = r11.dp3
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        int r12 = r12.dp10
                                        stikerwap.appdys.t_chat r15 = stikerwap.appdys.t_chat.this
                                        int r15 = r15.dp3
                                        r10.setPadding(r11, r12, r15, r2)
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r11 = r11.globales
                                        boolean r11 = r11.spam_mostrar
                                        if (r11 == 0) goto L_0x01d9
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r11 = r11.getString(r8, r9)
                                        java.lang.StringBuilder r12 = new java.lang.StringBuilder
                                        r12.<init>()
                                        stikerwap.appdys.t_chat r15 = stikerwap.appdys.t_chat.this
                                        r16 = r7
                                        long r6 = r15.idusu
                                        r12.append(r6)
                                        r12.append(r9)
                                        java.lang.String r6 = r12.toString()
                                        boolean r6 = r11.equals(r6)
                                        if (r6 != 0) goto L_0x01db
                                        boolean r6 = r3.booleanValue()
                                        if (r6 != 0) goto L_0x01db
                                        stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this
                                        boolean r6 = r6.c_fondotxt_esclaro
                                        r7 = 2131362422(0x7f0a0276, float:1.8344624E38)
                                        if (r6 == 0) goto L_0x01b8
                                        android.view.View r6 = r10.findViewById(r7)
                                        android.widget.ImageView r6 = (android.widget.ImageView) r6
                                        int r11 = stikerwap.appdys.config.NEGRO
                                        android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.MULTIPLY
                                        r6.setColorFilter(r11, r12)
                                    L_0x01b8:
                                        android.view.View r6 = r10.findViewById(r7)
                                        r6.setVisibility(r2)
                                        android.view.View r6 = r10.findViewById(r7)
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r11 = r11.getString(r8, r9)
                                        r6.setTag(r14, r11)
                                        android.view.View r6 = r10.findViewById(r7)
                                        stikerwap.appdys.t_chat$20$1 r7 = new stikerwap.appdys.t_chat$20$1
                                        r7.<init>()
                                        r6.setOnClickListener(r7)
                                        goto L_0x01db
                                    L_0x01d9:
                                        r16 = r7
                                    L_0x01db:
                                        stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this
                                        int r6 = r6.width_frase
                                        if (r6 == 0) goto L_0x01f5
                                        boolean r6 = r3.booleanValue()
                                        if (r6 != 0) goto L_0x01f5
                                        r6 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                        android.view.View r6 = r10.findViewById(r6)
                                        stikerwap.appdys.t_chat r7 = stikerwap.appdys.t_chat.this
                                        int r7 = r7.width_frase
                                        r6.setMinimumWidth(r7)
                                    L_0x01f5:
                                        stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r6 = r6.getResources()
                                        r7 = 2131034118(0x7f050006, float:1.7678745E38)
                                        boolean r6 = r6.getBoolean(r7)
                                        r7 = 2131363453(0x7f0a067d, float:1.8346715E38)
                                        r11 = 3
                                        if (r6 == 0) goto L_0x0225
                                        if (r4 == 0) goto L_0x021a
                                        r10.setGravity(r11)
                                        r10.setLayoutDirection(r2)
                                        android.view.View r6 = r10.findViewById(r7)
                                        android.widget.TextView r6 = (android.widget.TextView) r6
                                        r6.setGravity(r11)
                                        goto L_0x0243
                                    L_0x021a:
                                        android.view.View r6 = r10.findViewById(r7)
                                        android.widget.TextView r6 = (android.widget.TextView) r6
                                        r12 = 5
                                        r6.setGravity(r12)
                                        goto L_0x0243
                                    L_0x0225:
                                        if (r4 == 0) goto L_0x023a
                                        r6 = 5
                                        r10.setGravity(r6)
                                        r6 = 1
                                        r10.setLayoutDirection(r6)
                                        android.view.View r6 = r10.findViewById(r7)
                                        android.widget.TextView r6 = (android.widget.TextView) r6
                                        r12 = 5
                                        r6.setGravity(r12)
                                        goto L_0x0243
                                    L_0x023a:
                                        android.view.View r6 = r10.findViewById(r7)
                                        android.widget.TextView r6 = (android.widget.TextView) r6
                                        r6.setGravity(r11)
                                    L_0x0243:
                                        int r6 = android.os.Build.VERSION.SDK_INT
                                        r12 = 20
                                        r15 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                        r13 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                        if (r6 <= r12) goto L_0x0289
                                        r6 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                                        android.view.View r6 = r10.findViewById(r6)
                                        android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        java.lang.String r12 = r12.cbtn
                                        stikerwap.appdys.config.progress_color(r6, r12)
                                        r6 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                                        android.view.View r6 = r10.findViewById(r6)
                                        android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        java.lang.String r12 = r12.cbtn
                                        stikerwap.appdys.config.progress_color(r6, r12)
                                        android.view.View r6 = r10.findViewById(r13)
                                        android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        java.lang.String r12 = r12.cbtn
                                        stikerwap.appdys.config.progress_color(r6, r12)
                                        android.view.View r6 = r10.findViewById(r15)
                                        android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        java.lang.String r12 = r12.cbtn
                                        stikerwap.appdys.config.progress_color(r6, r12)
                                    L_0x0289:
                                        r6 = 2131362421(0x7f0a0275, float:1.8344622E38)
                                        android.view.View r6 = r10.findViewById(r6)
                                        android.widget.ImageView r6 = (android.widget.ImageView) r6
                                        android.view.View r7 = r10.findViewById(r7)
                                        android.widget.TextView r7 = (android.widget.TextView) r7
                                        r12 = 2131363417(0x7f0a0659, float:1.8346642E38)
                                        android.view.View r12 = r10.findViewById(r12)
                                        android.widget.TextView r12 = (android.widget.TextView) r12
                                        stikerwap.appdys.t_chat r13 = stikerwap.appdys.t_chat.this
                                        java.lang.String r13 = r13.c1_glob
                                        java.lang.String r15 = "FFFFFFFF"
                                        boolean r13 = r13.equals(r15)
                                        if (r13 == 0) goto L_0x02c4
                                        stikerwap.appdys.t_chat r13 = stikerwap.appdys.t_chat.this
                                        java.lang.String r13 = r13.c2_glob
                                        java.lang.String r15 = "FFFFFFFF"
                                        boolean r13 = r13.equals(r15)
                                        if (r13 == 0) goto L_0x02c4
                                        java.lang.String r13 = "#EEEEEE"
                                        int r13 = android.graphics.Color.parseColor(r13)
                                        goto L_0x02c5
                                    L_0x02c4:
                                        r13 = -1
                                    L_0x02c5:
                                        java.lang.String r15 = "#555555"
                                        int r15 = android.graphics.Color.parseColor(r15)
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        boolean r11 = r11.c_fondotxt_esclaro
                                        if (r11 != 0) goto L_0x02d7
                                        java.lang.String r11 = "#999999"
                                        int r15 = android.graphics.Color.parseColor(r11)
                                    L_0x02d7:
                                        r7.setTextColor(r15)
                                        r12.setTextColor(r15)
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r11 = r11.getString(r8, r9)
                                        java.lang.StringBuilder r15 = new java.lang.StringBuilder
                                        r15.<init>()
                                        stikerwap.appdys.t_chat r14 = stikerwap.appdys.t_chat.this
                                        r17 = r3
                                        long r2 = r14.idusu
                                        r15.append(r2)
                                        r15.append(r9)
                                        java.lang.String r2 = r15.toString()
                                        boolean r2 = r11.equals(r2)
                                        r3 = 2131362378(0x7f0a024a, float:1.8344535E38)
                                        java.lang.String r14 = "1"
                                        java.lang.String r15 = "0"
                                        r18 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                        if (r2 == 0) goto L_0x0341
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c_fondotxt_esclaro
                                        if (r0 != 0) goto L_0x0311
                                        r18 = -1
                                    L_0x0311:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r2 = 2131886857(0x7f120309, float:1.9408305E38)
                                        java.lang.String r0 = r0.getString(r2)
                                        r7.setText(r0)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        int r0 = r0.fotos_perfil
                                        if (r0 <= 0) goto L_0x033b
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.graphics.Bitmap r0 = r0.bm_propia
                                        if (r0 == 0) goto L_0x033b
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.graphics.Bitmap r0 = r0.bm_propia
                                        r2 = 0
                                        android.graphics.Bitmap r0 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r0, r2)
                                        r6.setImageBitmap(r0)
                                    L_0x033b:
                                        r20 = r5
                                        r2 = r18
                                        goto L_0x0737
                                    L_0x0341:
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r11 = "f2_nombre"
                                        java.lang.String r2 = r2.getString(r11, r9)
                                        java.lang.String r2 = r2.trim()
                                        r7.setText(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r8, r15)
                                        r7 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_privados"
                                        java.lang.String r2 = r2.getString(r7, r14)
                                        r10.setTag(r3, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_nombre"
                                        java.lang.String r2 = r2.getString(r7, r9)
                                        r7 = 2131362379(0x7f0a024b, float:1.8344537E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_coments"
                                        java.lang.String r2 = r2.getString(r7, r14)
                                        r7 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_fnac_d"
                                        java.lang.String r2 = r2.getString(r7, r15)
                                        r7 = 2131362381(0x7f0a024d, float:1.834454E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_fnac_m"
                                        java.lang.String r2 = r2.getString(r7, r15)
                                        r7 = 2131362382(0x7f0a024e, float:1.8344543E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_fnac_a"
                                        java.lang.String r2 = r2.getString(r7, r15)
                                        r7 = 2131362383(0x7f0a024f, float:1.8344545E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_sexo"
                                        java.lang.String r2 = r2.getString(r7, r15)
                                        r7 = 2131362384(0x7f0a0250, float:1.8344547E38)
                                        r10.setTag(r7, r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_vfoto"
                                        java.lang.String r2 = r2.getString(r7, r15)
                                        r7 = 2131362385(0x7f0a0251, float:1.834455E38)
                                        r10.setTag(r7, r2)
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        android.content.SharedPreferences r2 = r2.settings
                                        java.lang.String r7 = "idprivado"
                                        java.lang.String r2 = r2.getString(r7, r15)
                                        boolean r2 = r2.equals(r15)
                                        if (r2 != 0) goto L_0x03e9
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r7 = "f2_desdepriv"
                                        java.lang.String r2 = r2.getString(r7, r14)
                                        r7 = 2131362377(0x7f0a0249, float:1.8344533E38)
                                        r10.setTag(r7, r2)
                                    L_0x03e9:
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r8, r9)
                                        boolean r2 = r2.equals(r14)
                                        if (r2 != 0) goto L_0x03fa
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        r10.setOnClickListener(r2)
                                    L_0x03fa:
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r8, r9)
                                        int r7 = r2.length()
                                        r11 = 1
                                        int r7 = r7 - r11
                                        int r11 = r2.length()
                                        java.lang.String r7 = r2.substring(r7, r11)
                                        boolean r11 = r2.equals(r14)
                                        if (r11 == 0) goto L_0x0415
                                        r7 = r15
                                    L_0x0415:
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        boolean r11 = r11.c_fondotxt_esclaro
                                        if (r11 == 0) goto L_0x04b2
                                        boolean r11 = r7.equals(r15)
                                        if (r11 != 0) goto L_0x04a4
                                        java.lang.String r11 = "5"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x042b
                                        goto L_0x04a4
                                    L_0x042b:
                                        boolean r11 = r7.equals(r14)
                                        if (r11 != 0) goto L_0x0496
                                        java.lang.String r11 = "6"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x043a
                                        goto L_0x0496
                                    L_0x043a:
                                        java.lang.String r11 = "2"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 != 0) goto L_0x0488
                                        java.lang.String r11 = "7"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x044b
                                        goto L_0x0488
                                    L_0x044b:
                                        java.lang.String r11 = "3"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 != 0) goto L_0x047a
                                        java.lang.String r11 = "8"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x045c
                                        goto L_0x047a
                                    L_0x045c:
                                        java.lang.String r11 = "4"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 != 0) goto L_0x046c
                                        java.lang.String r11 = "9"
                                        boolean r7 = r7.equals(r11)
                                        if (r7 == 0) goto L_0x0524
                                    L_0x046c:
                                        java.lang.String r7 = "#FFCC0000"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        java.lang.String r7 = "#FFFFDFDF"
                                        int r13 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x047a:
                                        java.lang.String r7 = "#FF9E5400"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        java.lang.String r7 = "#FFFFF0DF"
                                        int r13 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x0488:
                                        java.lang.String r7 = "#FF3D5C00"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        java.lang.String r7 = "#FFF4FFDF"
                                        int r13 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x0496:
                                        java.lang.String r7 = "#FF9933CC"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        java.lang.String r7 = "#FFF2E6F9"
                                        int r13 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x04a4:
                                        java.lang.String r7 = "#FF00698C"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        java.lang.String r7 = "#FFDFF8FF"
                                        int r13 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x04b2:
                                        boolean r11 = r7.equals(r15)
                                        if (r11 != 0) goto L_0x051e
                                        java.lang.String r11 = "5"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x04c1
                                        goto L_0x051e
                                    L_0x04c1:
                                        boolean r11 = r7.equals(r14)
                                        if (r11 != 0) goto L_0x0517
                                        java.lang.String r11 = "6"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x04d0
                                        goto L_0x0517
                                    L_0x04d0:
                                        java.lang.String r11 = "2"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 != 0) goto L_0x0510
                                        java.lang.String r11 = "7"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x04e1
                                        goto L_0x0510
                                    L_0x04e1:
                                        java.lang.String r11 = "3"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 != 0) goto L_0x0509
                                        java.lang.String r11 = "8"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 == 0) goto L_0x04f2
                                        goto L_0x0509
                                    L_0x04f2:
                                        java.lang.String r11 = "4"
                                        boolean r11 = r7.equals(r11)
                                        if (r11 != 0) goto L_0x0502
                                        java.lang.String r11 = "9"
                                        boolean r7 = r7.equals(r11)
                                        if (r7 == 0) goto L_0x0524
                                    L_0x0502:
                                        java.lang.String r7 = "#FF33FFFF"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x0509:
                                        java.lang.String r7 = "#FF87BFFF"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x0510:
                                        java.lang.String r7 = "#FFC9ADFF"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x0517:
                                        java.lang.String r7 = "#FF66CC33"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                        goto L_0x0524
                                    L_0x051e:
                                        java.lang.String r7 = "#FFFF6633"
                                        int r18 = android.graphics.Color.parseColor(r7)
                                    L_0x0524:
                                        stikerwap.appdys.t_chat r7 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r7 = r7.globales
                                        boolean r7 = r7.c_txt_chats
                                        if (r7 != 0) goto L_0x053b
                                        stikerwap.appdys.t_chat r7 = stikerwap.appdys.t_chat.this
                                        boolean r7 = r7.c_fondotxt_esclaro
                                        if (r7 == 0) goto L_0x0539
                                        r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                        r18 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                        goto L_0x053b
                                    L_0x0539:
                                        r18 = -1
                                    L_0x053b:
                                        android.content.SharedPreferences r7 = r7
                                        java.lang.String r11 = "f2_vfoto"
                                        java.lang.String r7 = r7.getString(r11, r15)
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        int r11 = r11.fotos_perfil
                                        if (r11 <= 0) goto L_0x056e
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r11 = r11.getString(r8, r9)
                                        boolean r11 = r11.equals(r14)
                                        if (r11 == 0) goto L_0x056e
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r2 = 2131230922(0x7f0800ca, float:1.807791E38)
                                        android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r2)
                                        r2 = 0
                                        android.graphics.Bitmap r0 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r0, r2)
                                        r6.setImageBitmap(r0)
                                        goto L_0x072f
                                    L_0x056e:
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        int r11 = r11.fotos_perfil
                                        if (r11 <= 0) goto L_0x05a9
                                        boolean r11 = r7.equals(r15)
                                        if (r11 == 0) goto L_0x05a9
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c_fondotxt_esclaro
                                        if (r0 == 0) goto L_0x0593
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r2 = 2131231691(0x7f0803cb, float:1.807947E38)
                                        android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
                                        r6.setImageDrawable(r0)
                                        goto L_0x05a3
                                    L_0x0593:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r2 = 2131231689(0x7f0803c9, float:1.8079466E38)
                                        android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
                                        r6.setImageDrawable(r0)
                                    L_0x05a3:
                                        r2 = 0
                                        r6.setVisibility(r2)
                                        goto L_0x072f
                                    L_0x05a9:
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        int r11 = r11.fotos_perfil
                                        if (r11 <= 0) goto L_0x072f
                                        boolean r11 = r7.equals(r15)
                                        if (r11 != 0) goto L_0x072f
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        java.util.Map<java.lang.String, android.graphics.Bitmap> r11 = r11.fotos_m
                                        java.lang.Object r11 = r11.get(r2)
                                        android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
                                        if (r11 == 0) goto L_0x05d1
                                        r3 = 0
                                        android.graphics.Bitmap r0 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r11, r3)
                                        r6.setImageBitmap(r0)
                                        r20 = r5
                                        r19 = r13
                                        goto L_0x06a4
                                    L_0x05d1:
                                        java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0674 }
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x0674 }
                                        java.io.File r11 = r11.path     // Catch:{ Exception -> 0x0674 }
                                        r19 = r13
                                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0671 }
                                        r13.<init>(r0)     // Catch:{ Exception -> 0x0671 }
                                        r13.append(r2)     // Catch:{ Exception -> 0x0671 }
                                        java.lang.String r0 = ".jpg"
                                        r13.append(r0)     // Catch:{ Exception -> 0x0671 }
                                        java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x0671 }
                                        r3.<init>(r11, r0)     // Catch:{ Exception -> 0x0671 }
                                        android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0671 }
                                        r0.<init>()     // Catch:{ Exception -> 0x0671 }
                                        r11 = 1
                                        r0.inJustDecodeBounds = r11     // Catch:{ Exception -> 0x0671 }
                                        java.lang.String r11 = r3.getPath()     // Catch:{ Exception -> 0x0671 }
                                        android.graphics.BitmapFactory.decodeFile(r11, r0)     // Catch:{ Exception -> 0x0671 }
                                        int r11 = r0.outWidth     // Catch:{ Exception -> 0x0671 }
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x0671 }
                                        android.content.res.Resources r11 = r11.getResources()     // Catch:{ Exception -> 0x0671 }
                                        android.util.DisplayMetrics r11 = r11.getDisplayMetrics()     // Catch:{ Exception -> 0x0671 }
                                        float r11 = r11.density     // Catch:{ Exception -> 0x0671 }
                                        r13 = 1111490560(0x42400000, float:48.0)
                                        float r11 = r11 * r13
                                        r13 = 1056964608(0x3f000000, float:0.5)
                                        float r11 = r11 + r13
                                        int r11 = (int) r11     // Catch:{ Exception -> 0x0671 }
                                        stikerwap.appdys.t_chat r13 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x0671 }
                                        android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x0671 }
                                        android.util.DisplayMetrics r13 = r13.getDisplayMetrics()     // Catch:{ Exception -> 0x0671 }
                                        float r13 = r13.density     // Catch:{ Exception -> 0x0671 }
                                        r20 = 1111490560(0x42400000, float:48.0)
                                        float r13 = r13 * r20
                                        r20 = 1056964608(0x3f000000, float:0.5)
                                        float r13 = r13 + r20
                                        int r13 = (int) r13
                                        r20 = r5
                                        int r5 = r0.outWidth     // Catch:{ Exception -> 0x0678 }
                                        int r0 = r0.outHeight     // Catch:{ Exception -> 0x0678 }
                                        if (r5 > r11) goto L_0x0634
                                        if (r0 > r13) goto L_0x0634
                                        r21 = 1
                                        goto L_0x0636
                                    L_0x0634:
                                        r21 = 0
                                    L_0x0636:
                                        if (r21 != 0) goto L_0x0653
                                        int r0 = stikerwap.appdys.config.calculateNewWidth(r5, r0, r11, r13)     // Catch:{ Exception -> 0x0678 }
                                        float r5 = (float) r5     // Catch:{ Exception -> 0x0678 }
                                        float r0 = (float) r0     // Catch:{ Exception -> 0x0678 }
                                        float r5 = r5 / r0
                                        int r0 = java.lang.Math.round(r5)     // Catch:{ Exception -> 0x0678 }
                                        android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0678 }
                                        r5.<init>()     // Catch:{ Exception -> 0x0678 }
                                        r5.inSampleSize = r0     // Catch:{ Exception -> 0x0678 }
                                        java.lang.String r0 = r3.getPath()     // Catch:{ Exception -> 0x0678 }
                                        android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r5)     // Catch:{ Exception -> 0x0678 }
                                        goto L_0x0661
                                    L_0x0653:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x0678 }
                                        android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0678 }
                                        android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x0678 }
                                        android.graphics.Bitmap r0 = android.provider.MediaStore.Images.Media.getBitmap(r0, r3)     // Catch:{ Exception -> 0x0678 }
                                    L_0x0661:
                                        r3 = 0
                                        android.graphics.Bitmap r5 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r0, r3)     // Catch:{ Exception -> 0x0678 }
                                        r6.setImageBitmap(r5)     // Catch:{ Exception -> 0x0678 }
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x0678 }
                                        java.util.Map<java.lang.String, android.graphics.Bitmap> r3 = r3.fotos_m     // Catch:{ Exception -> 0x0678 }
                                        r3.put(r2, r0)     // Catch:{ Exception -> 0x0678 }
                                        goto L_0x06a4
                                    L_0x0671:
                                        r20 = r5
                                        goto L_0x0678
                                    L_0x0674:
                                        r20 = r5
                                        r19 = r13
                                    L_0x0678:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c_fondotxt_esclaro
                                        if (r0 == 0) goto L_0x0690
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r3 = 2131231691(0x7f0803cb, float:1.807947E38)
                                        android.graphics.drawable.Drawable r0 = r0.getDrawable(r3)
                                        r6.setImageDrawable(r0)
                                        goto L_0x06a0
                                    L_0x0690:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r3 = 2131231689(0x7f0803c9, float:1.8079466E38)
                                        android.graphics.drawable.Drawable r0 = r0.getDrawable(r3)
                                        r6.setImageDrawable(r0)
                                    L_0x06a0:
                                        r3 = 0
                                        r6.setVisibility(r3)
                                    L_0x06a4:
                                        android.content.SharedPreferences r0 = r7
                                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                        java.lang.String r5 = "fperfil_"
                                        r3.<init>(r5)
                                        r3.append(r2)
                                        java.lang.String r3 = r3.toString()
                                        java.lang.String r0 = r0.getString(r3, r9)
                                        boolean r0 = r0.equals(r7)
                                        if (r0 != 0) goto L_0x0733
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c1_esclaro
                                        if (r0 == 0) goto L_0x06d0
                                        r0 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r3 = 0
                                        r0.setVisibility(r3)
                                        goto L_0x06db
                                    L_0x06d0:
                                        r3 = 0
                                        r0 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r0.setVisibility(r3)
                                    L_0x06db:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        java.util.Map<java.lang.String, java.lang.String> r0 = r0.acargar_m
                                        boolean r0 = r0.containsKey(r2)
                                        if (r0 != 0) goto L_0x0733
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        java.util.Map<java.lang.String, java.lang.String> r0 = r0.intentados_m
                                        boolean r0 = r0.containsKey(r2)
                                        if (r0 == 0) goto L_0x06ff
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        java.util.Map<java.lang.String, java.lang.String> r0 = r0.intentados_m
                                        java.lang.Object r0 = r0.get(r2)
                                        java.lang.String r0 = (java.lang.String) r0
                                        boolean r0 = r0.equals(r7)
                                        if (r0 != 0) goto L_0x0733
                                    L_0x06ff:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        java.util.Map<java.lang.String, java.lang.String> r0 = r0.acargar_m
                                        r0.put(r2, r7)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_foto r0 = r0.o_f
                                        if (r0 == 0) goto L_0x0718
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_foto r0 = r0.o_f
                                        android.os.AsyncTask$Status r0 = r0.getStatus()
                                        android.os.AsyncTask$Status r2 = android.os.AsyncTask.Status.RUNNING
                                        if (r0 == r2) goto L_0x0733
                                    L_0x0718:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_foto r2 = new stikerwap.appdys.t_chat$obtener_foto
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this
                                        r5 = 0
                                        r2.<init>()
                                        r0.o_f = r2
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_foto r0 = r0.o_f
                                        r2 = 0
                                        java.lang.String[] r3 = new java.lang.String[r2]
                                        r0.execute(r3)
                                        goto L_0x0733
                                    L_0x072f:
                                        r20 = r5
                                        r19 = r13
                                    L_0x0733:
                                        r2 = r18
                                        r13 = r19
                                    L_0x0737:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r3 = 2
                                        if (r0 <= 0) goto L_0x086c
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        java.lang.String r0 = r0.c_bubbles
                                        boolean r0 = r0.equals(r9)
                                        if (r0 != 0) goto L_0x076a
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        java.lang.String r5 = "#"
                                        r0.<init>(r5)
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r5 = r5.globales
                                        java.lang.String r5 = r5.c_bubbles
                                        r0.append(r5)
                                        java.lang.String r0 = r0.toString()
                                        int r13 = android.graphics.Color.parseColor(r0)
                                    L_0x076a:
                                        if (r4 == 0) goto L_0x07d4
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r4 = 2131034118(0x7f050006, float:1.7678745E38)
                                        boolean r0 = r0.getBoolean(r4)
                                        if (r0 == 0) goto L_0x07a9
                                        boolean r0 = r17.booleanValue()
                                        if (r0 == 0) goto L_0x0783
                                        goto L_0x0820
                                    L_0x0783:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        if (r0 != r3) goto L_0x078f
                                        goto L_0x082e
                                    L_0x078f:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 3
                                        if (r0 != r4) goto L_0x079c
                                        goto L_0x083d
                                    L_0x079c:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 4
                                        if (r0 != r4) goto L_0x0850
                                        goto L_0x084c
                                    L_0x07a9:
                                        boolean r0 = r17.booleanValue()
                                        if (r0 == 0) goto L_0x07b1
                                        goto L_0x0820
                                    L_0x07b1:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        if (r0 != r3) goto L_0x07bc
                                        goto L_0x07f4
                                    L_0x07bc:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 3
                                        if (r0 != r4) goto L_0x07c8
                                        goto L_0x0803
                                    L_0x07c8:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 4
                                        if (r0 != r4) goto L_0x0816
                                        goto L_0x0812
                                    L_0x07d4:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r0 = r0.getResources()
                                        r4 = 2131034118(0x7f050006, float:1.7678745E38)
                                        boolean r0 = r0.getBoolean(r4)
                                        if (r0 == 0) goto L_0x081a
                                        boolean r0 = r17.booleanValue()
                                        if (r0 == 0) goto L_0x07ea
                                        goto L_0x0820
                                    L_0x07ea:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        if (r0 != r3) goto L_0x07f8
                                    L_0x07f4:
                                        r0 = 2131230944(0x7f0800e0, float:1.8077955E38)
                                        goto L_0x0853
                                    L_0x07f8:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 3
                                        if (r0 != r4) goto L_0x0807
                                    L_0x0803:
                                        r0 = 2131230946(0x7f0800e2, float:1.807796E38)
                                        goto L_0x0853
                                    L_0x0807:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 4
                                        if (r0 != r4) goto L_0x0816
                                    L_0x0812:
                                        r0 = 2131230948(0x7f0800e4, float:1.8077963E38)
                                        goto L_0x0853
                                    L_0x0816:
                                        r0 = 2131230949(0x7f0800e5, float:1.8077965E38)
                                        goto L_0x0853
                                    L_0x081a:
                                        boolean r0 = r17.booleanValue()
                                        if (r0 == 0) goto L_0x0824
                                    L_0x0820:
                                        r0 = 2131230950(0x7f0800e6, float:1.8077967E38)
                                        goto L_0x0853
                                    L_0x0824:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        if (r0 != r3) goto L_0x0832
                                    L_0x082e:
                                        r0 = 2131230943(0x7f0800df, float:1.8077953E38)
                                        goto L_0x0853
                                    L_0x0832:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 3
                                        if (r0 != r4) goto L_0x0841
                                    L_0x083d:
                                        r0 = 2131230945(0x7f0800e1, float:1.8077957E38)
                                        goto L_0x0853
                                    L_0x0841:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        r4 = 4
                                        if (r0 != r4) goto L_0x0850
                                    L_0x084c:
                                        r0 = 2131230947(0x7f0800e3, float:1.8077961E38)
                                        goto L_0x0853
                                    L_0x0850:
                                        r0 = 2131230942(0x7f0800de, float:1.807795E38)
                                    L_0x0853:
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        android.content.res.Resources r4 = r4.getResources()
                                        android.graphics.drawable.Drawable r0 = r4.getDrawable(r0)
                                        android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.MULTIPLY
                                        r0.setColorFilter(r13, r4)
                                        r4 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                        android.view.View r4 = r10.findViewById(r4)
                                        r4.setBackgroundDrawable(r0)
                                    L_0x086c:
                                        android.content.SharedPreferences r0 = r7
                                        java.lang.String r4 = "f2_fcrea"
                                        java.lang.String r0 = r0.getString(r4, r9)
                                        boolean r4 = r0.equals(r9)
                                        if (r4 != 0) goto L_0x089e
                                        r4 = 6
                                        r5 = 10
                                        java.lang.String r0 = r0.substring(r4, r5)
                                        java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
                                        java.lang.String r5 = "HHmm"
                                        r4.<init>(r5)
                                        java.util.Date r0 = r4.parse(r0)     // Catch:{ Exception -> 0x089a }
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x089a }
                                        java.text.DateFormat r4 = android.text.format.DateFormat.getTimeFormat(r4)     // Catch:{ Exception -> 0x089a }
                                        java.lang.String r0 = r4.format(r0)     // Catch:{ Exception -> 0x089a }
                                        r12.setText(r0)     // Catch:{ Exception -> 0x089a }
                                        goto L_0x089e
                                    L_0x089a:
                                        r0 = move-exception
                                        r0.printStackTrace()
                                    L_0x089e:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        int r0 = r0.fotos_perfil
                                        if (r0 <= 0) goto L_0x08a7
                                        goto L_0x08ec
                                    L_0x08a7:
                                        r4 = 8
                                        r6.setVisibility(r4)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        int r0 = r0.bubbles
                                        if (r0 <= 0) goto L_0x08c1
                                        r0 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r0.setVisibility(r4)
                                        goto L_0x08ec
                                    L_0x08c1:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        boolean r0 = r0.c_txt_chats
                                        if (r0 == 0) goto L_0x08cd
                                        r0 = r2
                                        goto L_0x08d7
                                    L_0x08cd:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c1_esclaro
                                        if (r0 == 0) goto L_0x08d6
                                        r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                        goto L_0x08d7
                                    L_0x08d6:
                                        r0 = -1
                                    L_0x08d7:
                                        r4 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                        android.view.View r4 = r10.findViewById(r4)
                                        r4.setBackgroundColor(r0)
                                        r0 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r4 = 0
                                        r0.setVisibility(r4)
                                    L_0x08ec:
                                        r0 = 2131363424(0x7f0a0660, float:1.8346656E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        android.widget.TextView r0 = (android.widget.TextView) r0
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r5 = "f2_frase"
                                        java.lang.String r4 = r4.getString(r5, r9)
                                        android.content.SharedPreferences r5 = r7
                                        java.lang.String r6 = "f2_tipo"
                                        java.lang.String r5 = r5.getString(r6, r9)
                                        boolean r5 = r5.equals(r14)
                                        boolean r6 = r4.equals(r9)
                                        if (r6 != 0) goto L_0x0b27
                                        int r6 = r4.length()
                                        r7 = 14
                                        if (r6 <= r7) goto L_0x09b8
                                        r6 = 14
                                        r7 = 0
                                        java.lang.String r6 = r4.substring(r7, r6)
                                        java.lang.String r7 = "@@idfoto_temp:"
                                        boolean r6 = r6.equals(r7)
                                        if (r6 == 0) goto L_0x09b8
                                        java.lang.String r2 = "@@"
                                        int r2 = r4.indexOf(r2, r3)
                                        r6 = 14
                                        java.lang.String r2 = r4.substring(r6, r2)
                                        r4 = 8
                                        r0.setVisibility(r4)
                                        r0 = 2131362465(0x7f0a02a1, float:1.8344711E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                                        if (r5 == 0) goto L_0x0955
                                        r4 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r4, r14)
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r4 = r4.getString(r8, r9)
                                        r5 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                        r0.setTag(r5, r4)
                                        goto L_0x095b
                                    L_0x0955:
                                        r4 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r4, r15)
                                    L_0x095b:
                                        r4 = 2131361808(0x7f0a0010, float:1.8343379E38)
                                        r6 = r16
                                        r0.setTag(r4, r6)
                                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                        java.lang.String r5 = "imgtemp"
                                        r4.<init>(r5)
                                        r4.append(r2)
                                        java.lang.String r4 = r4.toString()
                                        r0.setTag(r4)
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        int r5 = java.lang.Integer.parseInt(r2)
                                        r6 = 1
                                        r4.mostrar_foto_f(r5, r6, r0)
                                        r0 = 2131362307(0x7f0a0203, float:1.834439E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r4 = 0
                                        r0.setVisibility(r4)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c1_esclaro
                                        if (r0 == 0) goto L_0x09a1
                                        r5 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                        android.view.View r0 = r10.findViewById(r5)
                                        r0.setVisibility(r4)
                                        android.view.View r0 = r10.findViewById(r5)
                                        r0.setTag(r2)
                                        goto L_0x09b2
                                    L_0x09a1:
                                        r5 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                        android.view.View r0 = r10.findViewById(r5)
                                        r0.setVisibility(r4)
                                        android.view.View r0 = r10.findViewById(r5)
                                        r0.setTag(r2)
                                    L_0x09b2:
                                        r7 = r20
                                        r2 = 0
                                        r6 = 1
                                        goto L_0x0efc
                                    L_0x09b8:
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        java.lang.CharSequence r5 = stikerwap.appdys.t_chat.addSmileySpans(r5, r4)
                                        stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r6 = r6.globales
                                        boolean r6 = r6.links_enchats
                                        if (r6 == 0) goto L_0x09d5
                                        stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this
                                        boolean r6 = r6.externo
                                        if (r6 != 0) goto L_0x09d5
                                        r6 = 1
                                        r0.setAutoLinkMask(r6)
                                        r0.setLinkTextColor(r2)
                                    L_0x09d5:
                                        r0.setText(r5)
                                        r0.setTextColor(r2)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        boolean r0 = r0.tts_mostrar
                                        if (r0 == 0) goto L_0x0b24
                                        android.content.SharedPreferences r0 = r7
                                        java.lang.String r0 = r0.getString(r8, r9)
                                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                        r2.<init>()
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        long r5 = r5.idusu
                                        r2.append(r5)
                                        r2.append(r9)
                                        java.lang.String r2 = r2.toString()
                                        boolean r0 = r0.equals(r2)
                                        if (r0 != 0) goto L_0x0b24
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                        r2.<init>()
                                        r2.append(r4)
                                        java.lang.String r5 = " "
                                        r2.append(r5)
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        java.lang.String r5 = r5.msg_ultimas
                                        r2.append(r5)
                                        java.lang.String r2 = r2.toString()
                                        r0.msg_ultimas = r2
                                        boolean r0 = r17.booleanValue()
                                        if (r0 != 0) goto L_0x0ad9
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c_fondotxt_esclaro
                                        r2 = 2131362509(0x7f0a02cd, float:1.83448E38)
                                        if (r0 == 0) goto L_0x0a4e
                                        android.view.View r0 = r10.findViewById(r2)
                                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                                        int r5 = stikerwap.appdys.config.NEGRO
                                        android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.MULTIPLY
                                        r0.setColorFilter(r5, r6)
                                        r0 = 2131362510(0x7f0a02ce, float:1.8344803E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                                        int r5 = stikerwap.appdys.config.NEGRO
                                        android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.MULTIPLY
                                        r0.setColorFilter(r5, r6)
                                    L_0x0a4e:
                                        r0 = 2131362639(0x7f0a034f, float:1.8345064E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r5 = 0
                                        r0.setVisibility(r5)
                                        android.content.SharedPreferences r0 = r7
                                        r7 = r20
                                        boolean r0 = r0.getBoolean(r7, r5)
                                        if (r0 == 0) goto L_0x0a76
                                        android.view.View r0 = r10.findViewById(r2)
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        java.lang.String r5 = r5.msg_ultimas
                                        r6 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r6, r5)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r0.msg_ultimas = r9
                                        goto L_0x0a80
                                    L_0x0a76:
                                        r6 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        android.view.View r0 = r10.findViewById(r2)
                                        r0.setTag(r6, r4)
                                    L_0x0a80:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        int r5 = r0.tag_id
                                        r6 = 1
                                        int r5 = r5 + r6
                                        r0.tag_id = r5
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        java.lang.String r5 = "m"
                                        r0.<init>(r5)
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        int r5 = r5.tag_id
                                        r0.append(r5)
                                        java.lang.String r0 = r0.toString()
                                        android.view.View r5 = r10.findViewById(r2)
                                        r5.setTag(r0)
                                        android.view.View r2 = r10.findViewById(r2)
                                        stikerwap.appdys.t_chat$20$2 r5 = new stikerwap.appdys.t_chat$20$2
                                        r5.<init>()
                                        r2.setOnClickListener(r5)
                                        r2 = 2131362510(0x7f0a02ce, float:1.8344803E38)
                                        android.view.View r2 = r10.findViewById(r2)
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                        r5.<init>()
                                        r5.append(r0)
                                        java.lang.String r0 = "_pause"
                                        r5.append(r0)
                                        java.lang.String r0 = r5.toString()
                                        r2.setTag(r0)
                                        r0 = 2131362510(0x7f0a02ce, float:1.8344803E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        stikerwap.appdys.t_chat$20$3 r2 = new stikerwap.appdys.t_chat$20$3
                                        r2.<init>()
                                        r0.setOnClickListener(r2)
                                        r6 = 1
                                        goto L_0x0adc
                                    L_0x0ad9:
                                        r7 = r20
                                        r6 = 0
                                    L_0x0adc:
                                        if (r6 != 0) goto L_0x0b48
                                        android.content.SharedPreferences r0 = r7
                                        r2 = 0
                                        boolean r0 = r0.getBoolean(r7, r2)
                                        if (r0 != 0) goto L_0x0b48
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.widget.LinearLayout r0 = r0.llchat
                                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                        java.lang.String r5 = "m"
                                        r2.<init>(r5)
                                        stikerwap.appdys.t_chat r5 = stikerwap.appdys.t_chat.this
                                        int r5 = r5.tag_id
                                        r2.append(r5)
                                        java.lang.String r2 = r2.toString()
                                        android.view.View r0 = r0.findViewWithTag(r2)
                                        if (r0 == 0) goto L_0x0b48
                                        r2 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        java.lang.Object r5 = r0.getTag(r2)
                                        java.lang.String r5 = (java.lang.String) r5
                                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                        r6.<init>()
                                        r6.append(r5)
                                        java.lang.String r5 = " "
                                        r6.append(r5)
                                        r6.append(r4)
                                        java.lang.String r4 = r6.toString()
                                        r0.setTag(r2, r4)
                                        goto L_0x0b48
                                    L_0x0b24:
                                        r7 = r20
                                        goto L_0x0b48
                                    L_0x0b27:
                                        r6 = r16
                                        r7 = r20
                                        android.content.SharedPreferences r4 = r7
                                        java.lang.String r11 = "f2_b64"
                                        java.lang.String r4 = r4.getString(r11, r9)
                                        java.lang.String r11 = "es_ad"
                                        boolean r4 = r4.equals(r11)
                                        if (r4 == 0) goto L_0x0b4b
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r0 = r0.globales
                                        stikerwap.appdys.t_chat r4 = stikerwap.appdys.t_chat.this
                                        int r4 = r4.width_ad
                                        r0.mostrar_inchat_post(r10, r2, r4)
                                    L_0x0b48:
                                        r2 = 0
                                        goto L_0x0efb
                                    L_0x0b4b:
                                        java.lang.String r2 = "pb"
                                        java.lang.String r4 = "f2_idfrase"
                                        if (r5 != 0) goto L_0x0b5f
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r12 = "f2_b64"
                                        java.lang.String r11 = r11.getString(r12, r9)
                                        boolean r11 = r11.equals(r9)
                                        if (r11 == 0) goto L_0x0b6f
                                    L_0x0b5f:
                                        if (r5 == 0) goto L_0x0c6b
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r12 = "f2_b64_th"
                                        java.lang.String r11 = r11.getString(r12, r9)
                                        boolean r11 = r11.equals(r9)
                                        if (r11 != 0) goto L_0x0c6b
                                    L_0x0b6f:
                                        android.content.SharedPreferences r6 = r7
                                        java.lang.String r11 = "f2_b64"
                                        java.lang.String r6 = r6.getString(r11, r9)
                                        if (r5 == 0) goto L_0x0b81
                                        android.content.SharedPreferences r6 = r7
                                        java.lang.String r11 = "f2_b64_th"
                                        java.lang.String r6 = r6.getString(r11, r9)
                                    L_0x0b81:
                                        r11 = 0
                                        byte[] r6 = android.util.Base64.decode(r6, r11)
                                        int r12 = r6.length
                                        android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeByteArray(r6, r11, r12)
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r12 = r12.globales
                                        stikerwap.appdys.t_chat r13 = stikerwap.appdys.t_chat.this
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r4, r9)
                                        int r3 = java.lang.Integer.parseInt(r3)
                                        java.io.File r3 = r12.getTempFile_notemp(r13, r3, r11)
                                        java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0bae }
                                        r11.<init>(r3)     // Catch:{ Exception -> 0x0bae }
                                        android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0bae }
                                        r12 = 100
                                        r6.compress(r3, r12, r11)     // Catch:{ Exception -> 0x0bae }
                                        goto L_0x0baf
                                    L_0x0bae:
                                    L_0x0baf:
                                        r3 = 8
                                        r0.setVisibility(r3)
                                        r0 = 2131362465(0x7f0a02a1, float:1.8344711E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                        java.lang.String r6 = "img"
                                        r3.<init>(r6)
                                        android.content.SharedPreferences r6 = r7
                                        java.lang.String r6 = r6.getString(r4, r9)
                                        r3.append(r6)
                                        java.lang.String r3 = r3.toString()
                                        r0.setTag(r3)
                                        if (r5 == 0) goto L_0x0c05
                                        r3 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r3, r14)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r5 = "f2_idvideo"
                                        java.lang.String r3 = r3.getString(r5, r9)
                                        r5 = 2131362378(0x7f0a024a, float:1.8344535E38)
                                        r0.setTag(r5, r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r5 = "f2_formato"
                                        java.lang.String r3 = r3.getString(r5, r9)
                                        r5 = 2131362379(0x7f0a024b, float:1.8344537E38)
                                        r0.setTag(r5, r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r8, r9)
                                        r5 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                        r0.setTag(r5, r3)
                                        goto L_0x0c0b
                                    L_0x0c05:
                                        r3 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r3, r15)
                                    L_0x0c0b:
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this
                                        boolean r3 = r3.c1_esclaro
                                        if (r3 == 0) goto L_0x0c2e
                                        r3 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                        android.view.View r3 = r10.findViewById(r3)
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                        r5.<init>(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r4, r9)
                                        r5.append(r2)
                                        java.lang.String r2 = r5.toString()
                                        r3.setTag(r2)
                                        goto L_0x0c4a
                                    L_0x0c2e:
                                        r3 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                        android.view.View r3 = r10.findViewById(r3)
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                        r5.<init>(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r4, r9)
                                        r5.append(r2)
                                        java.lang.String r2 = r5.toString()
                                        r3.setTag(r2)
                                    L_0x0c4a:
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r4, r9)
                                        int r3 = java.lang.Integer.parseInt(r3)
                                        r11 = 0
                                        r2.mostrar_foto_f(r3, r11, r0)
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        r0.setOnClickListener(r2)
                                        r0 = 2131362307(0x7f0a0203, float:1.834439E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r0.setVisibility(r11)
                                        goto L_0x0b48
                                    L_0x0c6b:
                                        r11 = 0
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.config r3 = r3.globales
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        android.content.SharedPreferences r13 = r7
                                        java.lang.String r13 = r13.getString(r4, r9)
                                        int r13 = java.lang.Integer.parseInt(r13)
                                        java.io.File r3 = r3.getTempFile_notemp(r12, r13, r11)
                                        boolean r3 = r3.exists()
                                        if (r3 == 0) goto L_0x0d6b
                                        r3 = 8
                                        r0.setVisibility(r3)
                                        r0 = 2131362465(0x7f0a02a1, float:1.8344711E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                        java.lang.String r11 = "img"
                                        r3.<init>(r11)
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r11 = r11.getString(r4, r9)
                                        r3.append(r11)
                                        java.lang.String r3 = r3.toString()
                                        r0.setTag(r3)
                                        if (r5 == 0) goto L_0x0cde
                                        r3 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r3, r14)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r5 = "f2_idvideo"
                                        java.lang.String r3 = r3.getString(r5, r9)
                                        r5 = 2131362378(0x7f0a024a, float:1.8344535E38)
                                        r0.setTag(r5, r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r5 = "f2_formato"
                                        java.lang.String r3 = r3.getString(r5, r9)
                                        r5 = 2131362379(0x7f0a024b, float:1.8344537E38)
                                        r0.setTag(r5, r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r8, r9)
                                        r5 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                        r0.setTag(r5, r3)
                                        goto L_0x0ce4
                                    L_0x0cde:
                                        r3 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r3, r15)
                                    L_0x0ce4:
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r8, r9)
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                        r5.<init>()
                                        stikerwap.appdys.t_chat r11 = stikerwap.appdys.t_chat.this
                                        long r11 = r11.idusu
                                        r5.append(r11)
                                        r5.append(r9)
                                        java.lang.String r5 = r5.toString()
                                        boolean r3 = r3.equals(r5)
                                        if (r3 == 0) goto L_0x0d0b
                                        r3 = 2131361808(0x7f0a0010, float:1.8343379E38)
                                        r0.setTag(r3, r6)
                                    L_0x0d0b:
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this
                                        boolean r3 = r3.c1_esclaro
                                        if (r3 == 0) goto L_0x0d2e
                                        r3 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                        android.view.View r3 = r10.findViewById(r3)
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                        r5.<init>(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r4, r9)
                                        r5.append(r2)
                                        java.lang.String r2 = r5.toString()
                                        r3.setTag(r2)
                                        goto L_0x0d4a
                                    L_0x0d2e:
                                        r3 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                        android.view.View r3 = r10.findViewById(r3)
                                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                        r5.<init>(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r4, r9)
                                        r5.append(r2)
                                        java.lang.String r2 = r5.toString()
                                        r3.setTag(r2)
                                    L_0x0d4a:
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r4, r9)
                                        int r3 = java.lang.Integer.parseInt(r3)
                                        r4 = 0
                                        r2.mostrar_foto_f(r3, r4, r0)
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        r0.setOnClickListener(r2)
                                        r0 = 2131362307(0x7f0a0203, float:1.834439E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r0.setVisibility(r4)
                                        goto L_0x0b48
                                    L_0x0d6b:
                                        r3 = 8
                                        r0.setVisibility(r3)
                                        r0 = 2131362465(0x7f0a02a1, float:1.8344711E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                        java.lang.String r11 = "img"
                                        r3.<init>(r11)
                                        android.content.SharedPreferences r11 = r7
                                        java.lang.String r11 = r11.getString(r4, r9)
                                        r3.append(r11)
                                        java.lang.String r3 = r3.toString()
                                        r0.setTag(r3)
                                        if (r5 == 0) goto L_0x0dc1
                                        r3 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r3, r14)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r11 = "f2_idvideo"
                                        java.lang.String r3 = r3.getString(r11, r9)
                                        r11 = 2131362378(0x7f0a024a, float:1.8344535E38)
                                        r0.setTag(r11, r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r11 = "f2_formato"
                                        java.lang.String r3 = r3.getString(r11, r9)
                                        r11 = 2131362379(0x7f0a024b, float:1.8344537E38)
                                        r0.setTag(r11, r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r8, r9)
                                        r11 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                        r0.setTag(r11, r3)
                                        goto L_0x0dc7
                                    L_0x0dc1:
                                        r3 = 2131362376(0x7f0a0248, float:1.834453E38)
                                        r0.setTag(r3, r15)
                                    L_0x0dc7:
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r8, r9)
                                        java.lang.StringBuilder r11 = new java.lang.StringBuilder
                                        r11.<init>()
                                        stikerwap.appdys.t_chat r12 = stikerwap.appdys.t_chat.this
                                        long r12 = r12.idusu
                                        r11.append(r12)
                                        r11.append(r9)
                                        java.lang.String r11 = r11.toString()
                                        boolean r3 = r3.equals(r11)
                                        if (r3 == 0) goto L_0x0dee
                                        r3 = 2131361808(0x7f0a0010, float:1.8343379E38)
                                        r0.setTag(r3, r6)
                                    L_0x0dee:
                                        r0 = 2131362307(0x7f0a0203, float:1.834439E38)
                                        android.view.View r0 = r10.findViewById(r0)
                                        r3 = 0
                                        r0.setVisibility(r3)
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        boolean r0 = r0.c1_esclaro
                                        if (r0 == 0) goto L_0x0e23
                                        r6 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                        android.view.View r0 = r10.findViewById(r6)
                                        r0.setVisibility(r3)
                                        android.view.View r0 = r10.findViewById(r6)
                                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                        r6.<init>(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r4, r9)
                                        r6.append(r2)
                                        java.lang.String r2 = r6.toString()
                                        r0.setTag(r2)
                                        goto L_0x0e46
                                    L_0x0e23:
                                        r6 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                        android.view.View r0 = r10.findViewById(r6)
                                        r0.setVisibility(r3)
                                        android.view.View r0 = r10.findViewById(r6)
                                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                        r3.<init>(r2)
                                        android.content.SharedPreferences r2 = r7
                                        java.lang.String r2 = r2.getString(r4, r9)
                                        r3.append(r2)
                                        java.lang.String r2 = r3.toString()
                                        r0.setTag(r2)
                                    L_0x0e46:
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        java.lang.String r3 = r2.imgs_acargar
                                        r0.append(r3)
                                        java.lang.String r3 = ","
                                        r0.append(r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r4, r9)
                                        r0.append(r3)
                                        java.lang.String r0 = r0.toString()
                                        r2.imgs_acargar = r0
                                        if (r5 == 0) goto L_0x0e9f
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        java.lang.String r3 = r2.imgs_acargar
                                        r0.append(r3)
                                        java.lang.String r3 = "@1@"
                                        r0.append(r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r4 = "f2_idvideo"
                                        java.lang.String r3 = r3.getString(r4, r9)
                                        r0.append(r3)
                                        java.lang.String r3 = "@"
                                        r0.append(r3)
                                        android.content.SharedPreferences r3 = r7
                                        java.lang.String r3 = r3.getString(r8, r9)
                                        r0.append(r3)
                                        java.lang.String r0 = r0.toString()
                                        r2.imgs_acargar = r0
                                        goto L_0x0eb9
                                    L_0x0e9f:
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        java.lang.String r3 = r2.imgs_acargar
                                        r0.append(r3)
                                        java.lang.String r3 = "@0"
                                        r0.append(r3)
                                        java.lang.String r0 = r0.toString()
                                        r2.imgs_acargar = r0
                                    L_0x0eb9:
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        java.lang.String r3 = r2.imgs_acargar
                                        r0.append(r3)
                                        java.lang.String r3 = ","
                                        r0.append(r3)
                                        java.lang.String r0 = r0.toString()
                                        r2.imgs_acargar = r0
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_img r0 = r0.o_i
                                        if (r0 == 0) goto L_0x0ee5
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_img r0 = r0.o_i
                                        android.os.AsyncTask$Status r0 = r0.getStatus()
                                        android.os.AsyncTask$Status r2 = android.os.AsyncTask.Status.RUNNING
                                        if (r0 == r2) goto L_0x0b48
                                    L_0x0ee5:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_img r2 = new stikerwap.appdys.t_chat$obtener_img
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this
                                        r4 = 0
                                        r2.<init>()
                                        r0.o_i = r2
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        stikerwap.appdys.t_chat$obtener_img r0 = r0.o_i
                                        r2 = 0
                                        java.lang.String[] r3 = new java.lang.String[r2]
                                        r0.execute(r3)
                                    L_0x0efb:
                                        r6 = 0
                                    L_0x0efc:
                                        android.content.SharedPreferences r0 = r7
                                        java.lang.String r0 = r0.getString(r8, r9)
                                        r10.setTag(r0)
                                        android.content.SharedPreferences r0 = r7
                                        boolean r0 = r0.getBoolean(r7, r2)
                                        if (r0 == 0) goto L_0x0f15
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.widget.LinearLayout r0 = r0.llchat
                                        r0.addView(r10, r2)
                                        goto L_0x0f83
                                    L_0x0f15:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        android.widget.LinearLayout r0 = r0.llchat
                                        r0.addView(r10)
                                        android.content.SharedPreferences r0 = r7
                                        java.lang.String r0 = r0.getString(r8, r9)
                                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                        r2.<init>()
                                        stikerwap.appdys.t_chat r3 = stikerwap.appdys.t_chat.this
                                        long r3 = r3.idusu
                                        r2.append(r3)
                                        r2.append(r9)
                                        java.lang.String r2 = r2.toString()
                                        boolean r0 = r0.equals(r2)
                                        if (r0 == 0) goto L_0x0f58
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r2 = 2131363236(0x7f0a05a4, float:1.8346275E38)
                                        android.view.View r0 = r0.findViewById(r2)
                                        android.widget.ScrollView r0 = (android.widget.ScrollView) r0
                                        stikerwap.appdys.t_chat$20$4 r2 = new stikerwap.appdys.t_chat$20$4
                                        r2.<init>()
                                        r0.post(r2)
                                        if (r6 != 0) goto L_0x0f83
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r0.play_out()
                                        goto L_0x0f83
                                    L_0x0f58:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r2 = 2131363236(0x7f0a05a4, float:1.8346275E38)
                                        android.view.View r0 = r0.findViewById(r2)
                                        android.widget.ScrollView r0 = (android.widget.ScrollView) r0
                                        stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this
                                        android.widget.LinearLayout r2 = r2.llchat
                                        int r2 = r2.getMeasuredHeight()
                                        int r3 = r0.getScrollY()
                                        int r4 = r0.getHeight()
                                        int r3 = r3 + r4
                                        if (r2 > r3) goto L_0x0f7e
                                        stikerwap.appdys.t_chat$20$5 r2 = new stikerwap.appdys.t_chat$20$5
                                        r2.<init>()
                                        r0.post(r2)
                                    L_0x0f7e:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r0.play_in()
                                    L_0x0f83:
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        int r2 = r0.nfrases
                                        r3 = 1
                                        int r2 = r2 + r3
                                        r0.nfrases = r2
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        int r0 = r0.nfrases
                                        if (r0 != r3) goto L_0x0fa5
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r2 = 2131363531(0x7f0a06cb, float:1.8346873E38)
                                        android.view.View r0 = r0.findViewById(r2)
                                        r2 = 8
                                        r0.setVisibility(r2)
                                        goto L_0x0fbc
                                    L_0x0fa5:
                                        r2 = 8
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        int r0 = r0.nfrases
                                        r3 = 2
                                        if (r0 != r3) goto L_0x0fbc
                                        stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this
                                        r3 = 2131363532(0x7f0a06cc, float:1.8346875E38)
                                        android.view.View r0 = r0.findViewById(r3)
                                        r0.setVisibility(r2)
                                    L_0x0fbc:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.AnonymousClass20.run():void");
                                }
                            });
                        }
                    }
                }
            }
        } else if (str.equals("accion")) {
            if (sharedPreferences.getInt("accion", 0) == 1) {
                if (this.settings.getString("idprivado", "0").equals("0") && this.settings.getInt("privados", 1) == 1 && (((dialog = this.d_solic_privado) == null || !dialog.isShowing()) && ((alertDialog = this.d_confirm) == null || !alertDialog.isShowing()))) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            t_chat t_chat = t_chat.this;
                            t_chat.mostrar_solicprivado(t_chat.settings2.getString("id_remit", ""), t_chat.this.settings2.getString("nombre_remit", ""));
                        }
                    });
                }
            } else if (!(sharedPreferences.getInt("accion", 0) == 2 || sharedPreferences.getInt("accion", 0) == 3)) {
                sharedPreferences.getInt("accion", 0);
            }
            if (sharedPreferences.getInt("accion", 0) != 0) {
                SharedPreferences.Editor edit = this.settings2.edit();
                edit.putInt("accion", 0);
                edit.commit();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void play_out() {
        MediaPlayer mediaPlayer;
        if (!this.sot.equals("0") && (mediaPlayer = this.player_out) != null && !mediaPlayer.isPlaying()) {
            try {
                this.player_out.start();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void play_in() {
        MediaPlayer mediaPlayer;
        if (!this.sit.equals("0") && (mediaPlayer = this.player_in) != null && !mediaPlayer.isPlaying()) {
            try {
                this.player_in.start();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void mostrar_foto_f(int i, boolean z, ImageView imageView) {
        File file;
        Bitmap bitmap;
        if (imageView != null) {
            boolean z2 = false;
            if (z) {
                file = this.globales.getTempFile(this, i);
            } else {
                file = this.globales.getTempFile_notemp(this, i, false);
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                int i2 = options.outWidth;
                int i3 = options.outWidth;
                imageView.getLayoutParams().width = this.WIDTH_IMGS;
                imageView.getLayoutParams().height = (options.outHeight * this.WIDTH_IMGS) / i3;
                int i4 = this.WIDTH_IMGS;
                if (i3 <= i4) {
                    z2 = true;
                }
                if (!z2) {
                    int round = Math.round(((float) i3) / ((float) i4));
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = round;
                    bitmap = BitmapFactory.decodeFile(file.getPath(), options2);
                } else {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
                }
                if (imageView.getTag(R.id.idaux1) != null && imageView.getTag(R.id.idaux1).equals("1")) {
                    bitmap = config.putOverlay(bitmap, BitmapFactory.decodeResource(getResources(), R.drawable.play_pp));
                }
                imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
                config.fade_in(imageView);
            } catch (Exception unused) {
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
            Iterator<String> it = t_chat.this.spool.iterator();
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
                    multipartEntity.addPart("idusu", new StringBody(t_chat.this.idusu + ""));
                    multipartEntity.addPart("c", new StringBody(t_chat.this.codigo));
                    multipartEntity.addPart("idtema", new StringBody(t_chat.this.idtema + ""));
                    multipartEntity.addPart("idusudest", new StringBody(t_chat.this.settings.getString("idprivado", "0")));
                    multipartEntity.addPart("externo", new StringBody(t_chat.this.externo + ""));
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
            if (str.equals("OK") && t_chat.this.spool.size() > 0) {
                t_chat t_chat = t_chat.this;
                t_chat.env = new enviar();
                t_chat.this.env.execute(new String[0]);
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
            if (!t_chat.this.notif) {
                Drawable drawable = t_chat.this.getResources().getDrawable(R.drawable.notif_blanco);
                drawable.setColorFilter(t_chat.this.c_activ, PorterDuff.Mode.MULTIPLY);
                t_chat.this.iv_notif_noactiv.setImageDrawable(drawable);
                t_chat.this.notif = true;
                SharedPreferences.Editor edit = t_chat.this.settings.edit();
                edit.putBoolean("notif" + t_chat.this.idchat, true);
                edit.commit();
                new config.modif_usuchat(t_chat.this.idusu, t_chat.this.codigo, t_chat.this.idchat, "notif", 1).execute(new String[0]);
            }
            if (t_chat.this.settings.getString("idprivado", "0").equals("0")) {
                t_chat.this.globales.toca_int_chat(t_chat.this);
                config r0 = t_chat.this.globales;
                t_chat t_chat = t_chat.this;
                SharedPreferences r5 = t_chat.settings;
                r0.toca_inchat(t_chat, r5, t_chat.this.idtema + "");
            }
            SharedPreferences.Editor edit2 = t_chat.this.settings.edit();
            edit2.putString("f2_id", t_chat.this.idusu + "");
            edit2.putString("f2_frase", "@@idfoto_temp:" + this.id_temp + "@@");
            edit2.putString("f2_fcrea", new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
            edit2.putString("f2_b64", "");
            edit2.putString("f2_idfrase", "");
            edit2.putString("f2_idtema", t_chat.this.idtema + "");
            edit2.putString("f2_vfoto", "0");
            edit2.putString("f2_tipo", "1");
            edit2.putString("f2_idvideo", "");
            edit2.putString("f2_formato", "");
            edit2.putBoolean("f2_ultimas", false);
            edit2.putString("f2_ts", System.currentTimeMillis() + "");
            edit2.commit();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            String str = "";
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("https://video-upload." + config.DOM_EDROID + "/upload.php");
            FileBody fileBody = new FileBody(new File(this.videoPath));
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("videoFile", fileBody);
            try {
                multipartEntity.addPart("idusu", new StringBody(t_chat.this.idusu + str));
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
                } else if (substring2.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    str2 = "webm";
                } else {
                    return;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(this.videoPath);
                    config r6 = t_chat.this.globales;
                    t_chat t_chat = t_chat.this;
                    String absolutePath = r6.getTempFile_libre(t_chat, "v" + substring + "." + str2).getAbsolutePath();
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
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/enviar_video.php");
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(t_chat.this.getContentResolver(), Uri.fromFile(t_chat.this.globales.getTempFile(t_chat.this, this.id_temp)));
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
                multipartEntity.addPart("v", new StringBody("2"));
                multipartEntity.addPart("idusu", new StringBody(t_chat.this.idusu + str));
                multipartEntity.addPart("c", new StringBody(t_chat.this.codigo));
                multipartEntity.addPart("idvideo", new StringBody(this.idvideo));
                multipartEntity.addPart("formato", new StringBody(this.formato));
                multipartEntity.addPart("idtema", new StringBody(t_chat.this.idtema + str));
                multipartEntity.addPart("idusudest", new StringBody(t_chat.this.settings.getString("idprivado", "0")));
                multipartEntity.addPart("externo", new StringBody(t_chat.this.externo + str));
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
            AlertDialog.Builder builder = new AlertDialog.Builder(t_chat.this);
            try {
                LinearLayout linearLayout = t_chat.this.llchat;
                linearLayout.findViewWithTag(this.id_temp + "").setVisibility(8);
                LinearLayout linearLayout2 = t_chat.this.llchat;
                linearLayout2.findViewWithTag(this.id_temp + "").setTag((Object) null);
            } catch (Exception unused) {
            }
            if (str.indexOf("ANDROID:OK IDFRASE:") != -1 || str.indexOf("ANDROID:KO") != -1) {
                if (str.indexOf("ANDROID:OK IDFRASE:") != -1) {
                    t_chat.this.play_out();
                    int indexOf = str.indexOf("ANDROID:OK IDFRASE:") + 19;
                    int indexOf2 = str.indexOf("@", indexOf);
                    t_chat.this.globales.getTempFile(t_chat.this, this.id_temp).renameTo(t_chat.this.globales.getTempFile_notemp(t_chat.this, Integer.parseInt(str.substring(indexOf, indexOf2)), false));
                    try {
                        LinearLayout linearLayout3 = t_chat.this.llchat;
                        View findViewWithTag = linearLayout3.findViewWithTag("imgtemp" + this.id_temp);
                        findViewWithTag.setTag(R.id.idaux2, this.idvideo);
                        findViewWithTag.setTag(R.id.idaux3, this.formato);
                        findViewWithTag.setTag("img" + str.substring(indexOf, indexOf2));
                        LinearLayout linearLayout4 = t_chat.this.llchat;
                        linearLayout4.findViewWithTag("img" + str.substring(indexOf, indexOf2)).setOnClickListener(t_chat.this);
                    } catch (Exception unused2) {
                    }
                } else if (str.indexOf("ANDROID:KO MOTIVO:NOGCM") != -1) {
                    final AlertDialog create = builder.setCancelable(false).setPositiveButton(t_chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.nogcm).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    create.show();
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } else if ((str.indexOf("ANDROID:KO MOTIVO:ABANDONADO") == -1 || t_chat.this.settings.getString("idprivado", "0").equals("0")) && str.indexOf("ANDROID:KO MOTIVO:NOADMITE") != -1 && !t_chat.this.settings.getString("idprivado", "0").equals("0")) {
                    final AlertDialog create2 = builder.setCancelable(false).setPositiveButton(t_chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.noadmiteprivados).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        create2.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create2.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    create2.show();
                    ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                }
            }
        }
    }

    private class enviar_foto extends AsyncTask<String, Void, String> {
        int id_temp;

        public enviar_foto(int i) {
            this.id_temp = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (!t_chat.this.notif) {
                Drawable drawable = t_chat.this.getResources().getDrawable(R.drawable.notif_blanco);
                drawable.setColorFilter(t_chat.this.c_activ, PorterDuff.Mode.MULTIPLY);
                t_chat.this.iv_notif_noactiv.setImageDrawable(drawable);
                t_chat.this.notif = true;
                SharedPreferences.Editor edit = t_chat.this.settings.edit();
                edit.putBoolean("notif" + t_chat.this.idchat, true);
                edit.commit();
                new config.modif_usuchat(t_chat.this.idusu, t_chat.this.codigo, t_chat.this.idchat, "notif", 1).execute(new String[0]);
            }
            if (t_chat.this.settings.getString("idprivado", "0").equals("0")) {
                t_chat.this.globales.toca_int_chat(t_chat.this);
                config r0 = t_chat.this.globales;
                t_chat t_chat = t_chat.this;
                SharedPreferences r5 = t_chat.settings;
                r0.toca_inchat(t_chat, r5, t_chat.this.idtema + "");
            }
            SharedPreferences.Editor edit2 = t_chat.this.settings.edit();
            edit2.putString("f2_id", t_chat.this.idusu + "");
            edit2.putString("f2_frase", "@@idfoto_temp:" + this.id_temp + "@@");
            edit2.putString("f2_fcrea", new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
            edit2.putString("f2_b64", "");
            edit2.putString("f2_idfrase", "");
            edit2.putString("f2_idtema", t_chat.this.idtema + "");
            edit2.putString("f2_vfoto", "0");
            edit2.putString("f2_tipo", "0");
            edit2.putBoolean("f2_ultimas", false);
            edit2.putString("f2_ts", System.currentTimeMillis() + "");
            edit2.commit();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/enviar_foto.php");
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(t_chat.this.getContentResolver(), Uri.fromFile(t_chat.this.globales.getTempFile(t_chat.this, this.id_temp)));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                multipartEntity.addPart("foto", new ByteArrayBody(byteArrayOutputStream.toByteArray(), "temporal.jpg"));
                multipartEntity.addPart("v", new StringBody("2"));
                multipartEntity.addPart("idusu", new StringBody(t_chat.this.idusu + ""));
                multipartEntity.addPart("c", new StringBody(t_chat.this.codigo));
                multipartEntity.addPart("idtema", new StringBody(t_chat.this.idtema + ""));
                multipartEntity.addPart("idusudest", new StringBody(t_chat.this.settings.getString("idprivado", "0")));
                multipartEntity.addPart("externo", new StringBody(t_chat.this.externo + ""));
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
            } catch (Exception e) {
                e.printStackTrace();
                return "ANDROID:KO";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            AlertDialog.Builder builder = new AlertDialog.Builder(t_chat.this);
            try {
                LinearLayout linearLayout = t_chat.this.llchat;
                linearLayout.findViewWithTag(this.id_temp + "").setVisibility(8);
                LinearLayout linearLayout2 = t_chat.this.llchat;
                linearLayout2.findViewWithTag(this.id_temp + "").setTag((Object) null);
            } catch (Exception unused) {
            }
            if (str.indexOf("ANDROID:OK IDFRASE:") != -1 || str.indexOf("ANDROID:KO") != -1) {
                if (str.indexOf("ANDROID:OK IDFRASE:") != -1) {
                    t_chat.this.play_out();
                    int indexOf = str.indexOf("ANDROID:OK IDFRASE:") + 19;
                    int indexOf2 = str.indexOf("@", indexOf);
                    t_chat.this.globales.getTempFile(t_chat.this, this.id_temp).renameTo(t_chat.this.globales.getTempFile_notemp(t_chat.this, Integer.parseInt(str.substring(indexOf, indexOf2)), false));
                    try {
                        LinearLayout linearLayout3 = t_chat.this.llchat;
                        View findViewWithTag = linearLayout3.findViewWithTag("imgtemp" + this.id_temp);
                        findViewWithTag.setTag("img" + str.substring(indexOf, indexOf2));
                        LinearLayout linearLayout4 = t_chat.this.llchat;
                        linearLayout4.findViewWithTag("img" + str.substring(indexOf, indexOf2)).setOnClickListener(t_chat.this);
                    } catch (Exception unused2) {
                    }
                } else if (str.indexOf("ANDROID:KO MOTIVO:NOGCM") != -1) {
                    final AlertDialog create = builder.setCancelable(false).setPositiveButton(t_chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.nogcm).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    create.show();
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } else if ((str.indexOf("ANDROID:KO MOTIVO:ABANDONADO") == -1 || t_chat.this.settings.getString("idprivado", "0").equals("0")) && str.indexOf("ANDROID:KO MOTIVO:NOADMITE") != -1 && !t_chat.this.settings.getString("idprivado", "0").equals("0")) {
                    final AlertDialog create2 = builder.setCancelable(false).setPositiveButton(t_chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.noadmiteprivados).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        create2.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create2.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    create2.show();
                    ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                }
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
            if (t_chat.this.acargar_m.equals("")) {
                cancel(false);
                return;
            }
            try {
                this.idusu_acargar = (String) t_chat.this.acargar_m.keySet().toArray()[0];
            } catch (Exception unused) {
                cancel(false);
            }
            if (this.idusu_acargar != null) {
                this.vfoto_acargar = t_chat.this.acargar_m.get(this.idusu_acargar);
                t_chat.this.intentados_m.put(this.idusu_acargar, t_chat.this.acargar_m.get(this.idusu_acargar));
                t_chat.this.acargar_m.remove(this.idusu_acargar);
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
                stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this     // Catch:{  }
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.obtener_foto.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (t_chat.this.fotos_m != null) {
                if (str == "1") {
                    t_chat.this.fotos_m.put(this.idusu_acargar, this.bmImg);
                    SharedPreferences.Editor edit = t_chat.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, t_chat.this.intentados_m.get(this.idusu_acargar));
                    edit.commit();
                }
                int childCount = t_chat.this.llchat.getChildCount();
                int i = 0;
                while (i < childCount) {
                    try {
                        String str2 = (String) t_chat.this.llchat.getChildAt(i).getTag();
                        if (str2 != null && str2.equals(this.idusu_acargar)) {
                            t_chat.this.llchat.getChildAt(i).findViewById(R.id.pb_foto).setVisibility(8);
                            t_chat.this.llchat.getChildAt(i).findViewById(R.id.pb_foto_inv).setVisibility(8);
                            if (str == "1") {
                                ((ImageView) t_chat.this.llchat.getChildAt(i).findViewById(R.id.iv_avatar_f)).setImageBitmap(config.getCircularBitmapWithWhiteBorder(this.bmImg, 0));
                            }
                        }
                        i++;
                    } catch (Exception unused) {
                    }
                }
                if (!t_chat.this.acargar_m.equals("")) {
                    t_chat t_chat = t_chat.this;
                    t_chat.o_f = new obtener_foto();
                    t_chat.this.o_f.execute(new String[0]);
                }
            }
        }
    }

    private class obtener_img extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idimg_acargar;
        String idusu_vid;
        String idvideo;
        String tipo;

        private obtener_img() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_chat.this.imgs_acargar.equals("")) {
                cancel(false);
                return;
            }
            int indexOf = t_chat.this.imgs_acargar.indexOf(",");
            if (indexOf == -1) {
                cancel(false);
                return;
            }
            int i = indexOf + 1;
            int indexOf2 = t_chat.this.imgs_acargar.indexOf(",", i);
            if (indexOf2 == -1) {
                cancel(false);
                return;
            }
            String substring = t_chat.this.imgs_acargar.substring(i, indexOf2);
            this.idimg_acargar = substring;
            if (substring.equals("")) {
                cancel(false);
                return;
            }
            String[] split = this.idimg_acargar.split("@");
            if ((!split[1].equals("0") || split.length == 2) && (!split[1].equals("1") || split.length == 4)) {
                this.idimg_acargar = split[0];
                String str = split[1];
                this.tipo = str;
                if (str.equals("1")) {
                    this.idvideo = split[2];
                    this.idusu_vid = split[3];
                    return;
                }
                return;
            }
            cancel(false);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r6 = r5.idimg_acargar
                java.lang.String r0 = "0"
                if (r6 == 0) goto L_0x00bc
                java.lang.String r1 = ""
                boolean r6 = r6.equals(r1)
                if (r6 == 0) goto L_0x0010
                goto L_0x00bc
            L_0x0010:
                java.lang.String r6 = r5.tipo     // Catch:{  }
                boolean r6 = r6.equals(r0)     // Catch:{  }
                java.lang.String r1 = "1"
                if (r6 == 0) goto L_0x003d
                java.net.URL r6 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/frases/f"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r5.idimg_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_p.jpg"
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r6.<init>(r2)     // Catch:{  }
                goto L_0x0073
            L_0x003d:
                java.lang.String r6 = r5.tipo     // Catch:{  }
                boolean r6 = r6.equals(r1)     // Catch:{  }
                if (r6 == 0) goto L_0x0072
                java.net.URL r6 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/videos/v"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r5.idvideo     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r5.idusu_vid     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_th.jpg"
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r6.<init>(r2)     // Catch:{  }
                goto L_0x0073
            L_0x0072:
                r6 = 0
            L_0x0073:
                java.net.URLConnection r6 = r6.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{  }
                r2 = 1
                r6.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r6.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r6.setReadTimeout(r2)     // Catch:{  }
                r6.connect()     // Catch:{  }
                java.io.InputStream r2 = r6.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
                r5.bmImg = r3     // Catch:{  }
                r2.close()     // Catch:{  }
                r6.disconnect()     // Catch:{  }
                stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this     // Catch:{  }
                stikerwap.appdys.config r6 = r6.globales     // Catch:{  }
                stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this     // Catch:{  }
                java.lang.String r3 = r5.idimg_acargar     // Catch:{  }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{  }
                r4 = 0
                java.io.File r6 = r6.getTempFile_notemp(r2, r3, r4)     // Catch:{  }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x00bc }
                r2.<init>(r6)     // Catch:{ MalformedURLException -> 0x00bc }
                android.graphics.Bitmap r6 = r5.bmImg     // Catch:{ MalformedURLException -> 0x00bc }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x00bc }
                r4 = 100
                r6.compress(r3, r4, r2)     // Catch:{ MalformedURLException -> 0x00bc }
                return r1
            L_0x00bc:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.obtener_img.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (t_chat.this.imgs_acargar != null) {
                if (this.tipo.equals("0")) {
                    t_chat t_chat = t_chat.this;
                    String r4 = t_chat.imgs_acargar;
                    t_chat.imgs_acargar = r4.replace("," + this.idimg_acargar + "@" + this.tipo + ",", "");
                } else if (this.tipo.equals("1")) {
                    t_chat t_chat2 = t_chat.this;
                    String r42 = t_chat2.imgs_acargar;
                    t_chat2.imgs_acargar = r42.replace("," + this.idimg_acargar + "@" + this.tipo + "@" + this.idvideo + "@" + this.idusu_vid + ",", "");
                }
                try {
                    LinearLayout linearLayout = t_chat.this.llchat;
                    linearLayout.findViewWithTag("pb" + this.idimg_acargar).setVisibility(8);
                } catch (Exception unused) {
                }
                t_chat t_chat3 = t_chat.this;
                int parseInt = Integer.parseInt(this.idimg_acargar);
                LinearLayout linearLayout2 = t_chat.this.llchat;
                t_chat3.mostrar_foto_f(parseInt, false, (ImageView) linearLayout2.findViewWithTag("img" + this.idimg_acargar));
                try {
                    LinearLayout linearLayout3 = t_chat.this.llchat;
                    linearLayout3.findViewWithTag("img" + this.idimg_acargar).setOnClickListener(t_chat.this);
                } catch (Exception unused2) {
                }
                if (!t_chat.this.imgs_acargar.equals("")) {
                    t_chat t_chat4 = t_chat.this;
                    t_chat4.o_i = new obtener_img();
                    t_chat.this.o_i.execute(new String[0]);
                }
            }
        }
    }

    private class obtener_img_g extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idimg_acargar;

        public obtener_img_g(String str) {
            this.idimg_acargar = str;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.net.URL r0 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
                r1.<init>()     // Catch:{  }
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = "/srv/imgs/frases/f"
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = r4.idimg_acargar     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = ".jpg"
                r1.append(r2)     // Catch:{  }
                java.lang.String r1 = r1.toString()     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r1 = 1
                r0.setDoInput(r1)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r2)     // Catch:{  }
                r2 = 60000(0xea60, float:8.4078E-41)
                r0.setReadTimeout(r2)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r2 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
                r4.bmImg = r3     // Catch:{  }
                r2.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                stikerwap.appdys.t_chat r0 = stikerwap.appdys.t_chat.this     // Catch:{  }
                stikerwap.appdys.config r0 = r0.globales     // Catch:{  }
                stikerwap.appdys.t_chat r2 = stikerwap.appdys.t_chat.this     // Catch:{  }
                java.lang.String r3 = r4.idimg_acargar     // Catch:{  }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{  }
                java.io.File r0 = r0.getTempFile_notemp(r2, r3, r1)     // Catch:{  }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x006e }
                r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x006e }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x006e }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x006e }
                r3 = 100
                r0.compress(r2, r3, r1)     // Catch:{ MalformedURLException -> 0x006e }
                java.lang.String r5 = "1"
            L_0x006e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.obtener_img_g.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            try {
                LinearLayout linearLayout = t_chat.this.llchat;
                linearLayout.findViewWithTag("pb" + this.idimg_acargar).setVisibility(8);
            } catch (Exception unused) {
            }
            Intent intent = new Intent(t_chat.this, t_url.class);
            intent.putExtra("url", AdPayload.FILE_SCHEME + t_chat.this.globales.getTempFile_notemp(t_chat.this, Integer.parseInt(this.idimg_acargar), true).getAbsolutePath());
            t_chat.this.startActivityForResult(intent, 0);
        }
    }

    private class obtener_video extends AsyncTask<String, Void, String> {
        String ext = "";
        String idfrase;
        String idusu_vid;
        String idvideo;

        public obtener_video(String str, String str2, String str3, String str4) {
            this.idfrase = str;
            this.idvideo = str2;
            if (str3.equals("1")) {
                this.ext = "mp4";
            } else if (str3.equals("2")) {
                this.ext = "3gp";
            } else if (str3.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                this.ext = "webm";
            }
            this.idusu_vid = str4;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.ext.equals("")) {
                cancel(false);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r10) {
            /*
                r9 = this;
                java.lang.String r10 = "."
                java.lang.String r0 = "0"
                java.lang.String r1 = "v"
                java.lang.String r2 = "https://video."
                java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00b3 }
                r4.<init>(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ MalformedURLException -> 0x00b3 }
                r4.append(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = "/files/v"
                r4.append(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = r9.idvideo     // Catch:{ MalformedURLException -> 0x00b3 }
                r4.append(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = "_"
                r4.append(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = r9.idusu_vid     // Catch:{ MalformedURLException -> 0x00b3 }
                r4.append(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                r4.append(r10)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = r9.ext     // Catch:{ MalformedURLException -> 0x00b3 }
                r4.append(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r2 = r4.toString()     // Catch:{ MalformedURLException -> 0x00b3 }
                r3.<init>(r2)     // Catch:{ MalformedURLException -> 0x00b3 }
                r2 = 0
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x00ad }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x00ad }
                r4 = 1
                r3.setDoInput(r4)     // Catch:{ Exception -> 0x00ad }
                r5 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00ad }
                r5 = 60000(0xea60, float:8.4078E-41)
                r3.setReadTimeout(r5)     // Catch:{ Exception -> 0x00ad }
                r3.connect()     // Catch:{ Exception -> 0x00ad }
                java.io.InputStream r5 = r3.getInputStream()     // Catch:{ Exception -> 0x00ad }
                stikerwap.appdys.t_chat r6 = stikerwap.appdys.t_chat.this     // Catch:{ all -> 0x00a8 }
                stikerwap.appdys.config r6 = r6.globales     // Catch:{ all -> 0x00a8 }
                stikerwap.appdys.t_chat r7 = stikerwap.appdys.t_chat.this     // Catch:{ all -> 0x00a8 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
                r8.<init>(r1)     // Catch:{ all -> 0x00a8 }
                java.lang.String r1 = r9.idvideo     // Catch:{ all -> 0x00a8 }
                r8.append(r1)     // Catch:{ all -> 0x00a8 }
                r8.append(r10)     // Catch:{ all -> 0x00a8 }
                java.lang.String r10 = r9.ext     // Catch:{ all -> 0x00a8 }
                r8.append(r10)     // Catch:{ all -> 0x00a8 }
                java.lang.String r10 = r8.toString()     // Catch:{ all -> 0x00a8 }
                java.io.File r10 = r6.getTempFile_libre(r7, r10)     // Catch:{ all -> 0x00a8 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a8 }
                r1.<init>(r10)     // Catch:{ all -> 0x00a8 }
                r10 = 4096(0x1000, float:5.74E-42)
                byte[] r10 = new byte[r10]     // Catch:{ all -> 0x0098 }
            L_0x007f:
                int r6 = r5.read(r10)     // Catch:{ all -> 0x0098 }
                r7 = -1
                if (r6 == r7) goto L_0x008a
                r1.write(r10, r2, r6)     // Catch:{ all -> 0x0098 }
                goto L_0x007f
            L_0x008a:
                r1.flush()     // Catch:{ all -> 0x0098 }
                r1.close()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
                r2 = 1
                goto L_0x00a1
            L_0x0092:
                r10 = move-exception
                r2 = 1
                goto L_0x00a9
            L_0x0095:
                r10 = move-exception
                r2 = 1
                goto L_0x009e
            L_0x0098:
                r10 = move-exception
                r1.close()     // Catch:{ Exception -> 0x009d }
                throw r10     // Catch:{ Exception -> 0x009d }
            L_0x009d:
                r10 = move-exception
            L_0x009e:
                r10.printStackTrace()     // Catch:{ all -> 0x00a8 }
            L_0x00a1:
                r5.close()     // Catch:{ Exception -> 0x00ad }
                r3.disconnect()     // Catch:{ Exception -> 0x00ad }
                goto L_0x00ae
            L_0x00a8:
                r10 = move-exception
            L_0x00a9:
                r5.close()     // Catch:{ Exception -> 0x00ad }
                throw r10     // Catch:{ Exception -> 0x00ad }
            L_0x00ad:
            L_0x00ae:
                if (r2 == 0) goto L_0x00b3
                java.lang.String r10 = "1"
                return r10
            L_0x00b3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.obtener_video.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            try {
                LinearLayout linearLayout = t_chat.this.llchat;
                linearLayout.findViewWithTag("pb" + this.idfrase).setVisibility(8);
            } catch (Exception unused) {
            }
            Intent intent = new Intent(t_chat.this, t_video.class);
            StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
            config r1 = t_chat.this.globales;
            t_chat t_chat = t_chat.this;
            sb.append(r1.getTempFile_libre(t_chat, "v" + this.idvideo + "." + this.ext).getAbsolutePath());
            intent.putExtra("url", sb.toString());
            intent.putExtra("desde_chat", true);
            t_chat.this.startActivityForResult(intent, 0);
        }
    }

    private class cargar_ultimas extends AsyncTask<String, Void, String> {
        private int btncargarmas_vis;
        private String idconversante;
        private int idfrase_masantigua;
        private String idprivado_finalizar;

        public cargar_ultimas(String str, String str2, int i) {
            this.idprivado_finalizar = str;
            this.idconversante = str2;
            this.idfrase_masantigua = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.idfrase_masantigua > -1) {
                this.btncargarmas_vis = t_chat.this.findViewById(R.id.btncargarmas).getVisibility();
                t_chat.this.findViewById(R.id.btncargarmas).setVisibility(8);
                t_chat.this.pb_ant.setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00c6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2 }
                r0.<init>()     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "/srv/ultimas_frases.php?ver=1&idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                stikerwap.appdys.t_chat r1 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x00c2 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                stikerwap.appdys.t_chat r1 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "&idtema="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                stikerwap.appdys.t_chat r1 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x00c2 }
                int r1 = r1.idtema     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "&idf="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                int r1 = r5.idfrase_masantigua     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "&idprivado_finalizar="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = r5.idprivado_finalizar     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "&idconversante="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = r5.idconversante     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r1 = "&externo="
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                stikerwap.appdys.t_chat r1 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x00c2 }
                boolean r1 = r1.externo     // Catch:{ Exception -> 0x00c2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c2 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00c2 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00c2 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x00c2 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00c2 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r6.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            L_0x0094:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                if (r2 == 0) goto L_0x00af
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r3.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r3.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                r6.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                goto L_0x0094
            L_0x00af:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
                if (r0 == 0) goto L_0x00b8
                r0.disconnect()
            L_0x00b8:
                return r6
            L_0x00b9:
                r6 = move-exception
                goto L_0x00ca
            L_0x00bb:
                r6 = r0
                goto L_0x00c2
            L_0x00bd:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00ca
            L_0x00c2:
                java.lang.String r0 = "ANDROID:KO"
                if (r6 == 0) goto L_0x00c9
                r6.disconnect()
            L_0x00c9:
                return r0
            L_0x00ca:
                if (r0 == 0) goto L_0x00cf
                r0.disconnect()
            L_0x00cf:
                goto L_0x00d1
            L_0x00d0:
                throw r6
            L_0x00d1:
                goto L_0x00d0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.cargar_ultimas.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            int indexOf;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            boolean z;
            int i;
            String str7;
            String str8 = str;
            if (this.idfrase_masantigua != -1) {
                try {
                    t_chat.this.pb_ant.setVisibility(8);
                } catch (Exception unused) {
                }
                if (str8.indexOf("ANDROID:OK") == -1 && str8.indexOf("ANDROID:KO") == -1 && str8.indexOf("ANDROID:PERFILKO") == -1) {
                    t_chat.this.findViewById(R.id.btncargarmas).setVisibility(this.btncargarmas_vis);
                } else if (str8.indexOf("ANDROID:PERFILKO") != -1) {
                    final AlertDialog create = new AlertDialog.Builder(t_chat.this).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).setMessage(R.string.perfil_desactivado).create();
                    if (!t_chat.this.cbtn.equals("")) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                                Button button2 = create.getButton(-2);
                                button2.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                            }
                        });
                    }
                    create.show();
                    try {
                        ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                    } catch (Exception unused2) {
                    }
                } else if (str8.indexOf("ANDROID:OK") != -1) {
                    int indexOf2 = str8.indexOf("@XYY53@");
                    String str9 = "";
                    String str10 = str9;
                    boolean z2 = false;
                    for (int i2 = -1; indexOf2 != i2; i2 = -1) {
                        int indexOf3 = str8.indexOf("@", indexOf2 + 1) + 1;
                        int indexOf4 = str8.indexOf("@", indexOf3);
                        String substring = str8.substring(indexOf3, indexOf4);
                        t_chat.this.idfrase_masantigua_glob = Integer.parseInt(substring);
                        int i3 = indexOf4 + 1;
                        int indexOf5 = str8.indexOf("@", i3);
                        String substring2 = str8.substring(i3, indexOf5);
                        int i4 = indexOf5 + 1;
                        int indexOf6 = str8.indexOf("@", i4);
                        String substring3 = str8.substring(i4, indexOf6);
                        int i5 = indexOf6 + 1;
                        int indexOf7 = str8.indexOf("@", i5);
                        String substring4 = str8.substring(i5, indexOf7);
                        int i6 = indexOf7 + 1;
                        String str11 = substring3;
                        int indexOf8 = str8.indexOf("@", i6);
                        String substring5 = str8.substring(i6, indexOf8);
                        int i7 = indexOf8 + 1;
                        String str12 = substring5;
                        int indexOf9 = str8.indexOf("@", i7);
                        String substring6 = str8.substring(i7, indexOf9);
                        int i8 = indexOf9 + 1;
                        String str13 = substring6;
                        int indexOf10 = str8.indexOf("@", i8);
                        String substring7 = str8.substring(i8, indexOf10);
                        int i9 = indexOf10 + 1;
                        String str14 = substring7;
                        int indexOf11 = str8.indexOf("@", i9);
                        String substring8 = str8.substring(i9, indexOf11);
                        int i10 = indexOf11 + 1;
                        String str15 = substring8;
                        int indexOf12 = str8.indexOf("@", i10);
                        String substring9 = str8.substring(i10, indexOf12);
                        int i11 = indexOf12 + 1;
                        String str16 = substring9;
                        int indexOf13 = str8.indexOf("@", i11);
                        String substring10 = str8.substring(i11, indexOf13);
                        int i12 = indexOf13 + 1;
                        String str17 = substring10;
                        int indexOf14 = str8.indexOf("@", i12);
                        String substring11 = str8.substring(i12, indexOf14);
                        int i13 = indexOf14 + 1;
                        String str18 = substring11;
                        int indexOf15 = str8.indexOf("@", i13);
                        String substring12 = str8.substring(i13, indexOf15);
                        int i14 = indexOf15 + 1;
                        int indexOf16 = str8.indexOf("@", i14);
                        String substring13 = str8.substring(i14, indexOf16);
                        if (substring13.equals("1")) {
                            int i15 = indexOf16 + 1;
                            int indexOf17 = str8.indexOf("@", i15);
                            String substring14 = str8.substring(i15, indexOf17);
                            int i16 = indexOf17 + 1;
                            String str19 = substring14;
                            indexOf16 = str8.indexOf("@", i16);
                            str3 = str8.substring(i16, indexOf16);
                            String str20 = str19;
                            str2 = substring12;
                            str4 = str20;
                        } else {
                            str3 = "";
                            str2 = substring12;
                            str4 = str3;
                        }
                        if (str9.equals("") || substring4.equals("") || !str9.equals(substring4) || str10.equals("") || substring2.equals("") || !str10.equals(substring2)) {
                            int indexOf18 = str8.indexOf("@XYY53@", indexOf16);
                            if (indexOf18 != -1) {
                                int indexOf19 = str8.indexOf("@", str8.indexOf("@", indexOf18 + 1) + 1) + 1;
                                str5 = str8.substring(indexOf19, str8.indexOf("@", indexOf19));
                            } else {
                                str5 = "";
                            }
                            if (z2 || str8.indexOf("ZXRT4@1@") != -1) {
                                z = z2;
                                str6 = str3;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                z = z2;
                                str6 = str3;
                                sb.append(t_chat.this.idusu);
                                sb.append("");
                                if (substring2.equals(sb.toString())) {
                                    int i17 = indexOf16;
                                    while (true) {
                                        int indexOf20 = str8.indexOf("@XYY53@", i17);
                                        if (indexOf20 != -1) {
                                            int indexOf21 = str8.indexOf("@", str8.indexOf("@", indexOf20 + 1) + 1) + 1;
                                            i = str8.indexOf("@", indexOf21);
                                            str7 = str8.substring(indexOf21, i);
                                        } else {
                                            i = i17;
                                            str7 = "";
                                        }
                                        if (str7.equals("")) {
                                            z2 = true;
                                            break;
                                        } else if (!str7.equals(substring2)) {
                                            z2 = false;
                                            break;
                                        } else {
                                            i17 = i;
                                        }
                                    }
                                    SharedPreferences.Editor edit = t_chat.this.settings.edit();
                                    edit.putString("f2_idfrase", substring);
                                    edit.putString("f2_id", substring2);
                                    edit.putString("f2_idusu_prev", str5);
                                    edit.putBoolean("f2_mateixusu_hastafinal", z2);
                                    edit.putString("f2_nombre", str11);
                                    edit.putString("f2_privados", str13);
                                    edit.putString("f2_frase", substring4);
                                    edit.putString("f2_fcrea", config.convertir_fecha(str14));
                                    edit.putString("f2_b64", "");
                                    edit.putString("f2_tipo", substring13);
                                    edit.putString("f2_b64_th", "");
                                    edit.putString("f2_idvideo", str4);
                                    edit.putString("f2_formato", str6);
                                    edit.putString("f2_idtema", t_chat.this.idtema + "");
                                    edit.putString("f2_vfoto", str12);
                                    edit.putString("f2_fnac_d", str15);
                                    edit.putString("f2_fnac_m", str16);
                                    edit.putString("f2_fnac_a", str17);
                                    edit.putString("f2_sexo", str18);
                                    edit.putString("f2_coments", str2);
                                    edit.putBoolean("f2_ultimas", true);
                                    edit.putString("f2_ts", System.currentTimeMillis() + "");
                                    edit.commit();
                                    str10 = substring2;
                                    str9 = substring4;
                                }
                            }
                            z2 = z;
                            SharedPreferences.Editor edit2 = t_chat.this.settings.edit();
                            edit2.putString("f2_idfrase", substring);
                            edit2.putString("f2_id", substring2);
                            edit2.putString("f2_idusu_prev", str5);
                            edit2.putBoolean("f2_mateixusu_hastafinal", z2);
                            edit2.putString("f2_nombre", str11);
                            edit2.putString("f2_privados", str13);
                            edit2.putString("f2_frase", substring4);
                            edit2.putString("f2_fcrea", config.convertir_fecha(str14));
                            edit2.putString("f2_b64", "");
                            edit2.putString("f2_tipo", substring13);
                            edit2.putString("f2_b64_th", "");
                            edit2.putString("f2_idvideo", str4);
                            edit2.putString("f2_formato", str6);
                            edit2.putString("f2_idtema", t_chat.this.idtema + "");
                            edit2.putString("f2_vfoto", str12);
                            edit2.putString("f2_fnac_d", str15);
                            edit2.putString("f2_fnac_m", str16);
                            edit2.putString("f2_fnac_a", str17);
                            edit2.putString("f2_sexo", str18);
                            edit2.putString("f2_coments", str2);
                            edit2.putBoolean("f2_ultimas", true);
                            edit2.putString("f2_ts", System.currentTimeMillis() + "");
                            edit2.commit();
                            str10 = substring2;
                            str9 = substring4;
                        }
                        indexOf2 = str8.indexOf("@XYY53@", indexOf16);
                    }
                    if (str8.indexOf("ZXRT4@1@") != -1) {
                        t_chat.this.findViewById(R.id.btncargarmas).setVisibility(0);
                    } else {
                        t_chat.this.mostrar_fecha();
                        t_chat.this.findViewById(R.id.btncargarmas).setVisibility(8);
                    }
                    if (this.idfrase_masantigua == 0) {
                        ((ScrollView) t_chat.this.findViewById(R.id.sv_chat)).post(new Runnable() {
                            public void run() {
                                ((ScrollView) t_chat.this.findViewById(R.id.sv_chat)).fullScroll(130);
                            }
                        });
                    }
                    if (t_chat.this.externo && (indexOf = str8.indexOf("ZXRT4@")) != -1) {
                        int i18 = indexOf + 8;
                        int indexOf22 = str8.indexOf("@", i18);
                        int parseInt = Integer.parseInt(str8.substring(i18, indexOf22));
                        int i19 = indexOf22 + 1;
                        int indexOf23 = str8.indexOf("@", i19);
                        boolean equals = str8.substring(i19, indexOf23).equals("1");
                        int i20 = indexOf23 + 1;
                        int indexOf24 = str8.indexOf("@", i20);
                        int parseInt2 = Integer.parseInt(str8.substring(i20, indexOf24));
                        int i21 = indexOf24 + 1;
                        int indexOf25 = str8.indexOf("@", i21);
                        boolean z3 = Integer.parseInt(str8.substring(i21, indexOf25)) == 1;
                        int i22 = indexOf25 + 1;
                        int parseInt3 = Integer.parseInt(str8.substring(i22, str8.indexOf("@", i22)));
                        if (parseInt <= 0) {
                            return;
                        }
                        if (!equals) {
                            t_chat.this.globales.tratar_fondo((ImageView) t_chat.this.findViewById(R.id.iv_fondo), Boolean.valueOf(z3), parseInt3);
                            config r1 = t_chat.this.globales;
                            r1.file_to_iv("fondo_" + parseInt, (ImageView) t_chat.this.findViewById(R.id.iv_fondo));
                            return;
                        }
                        cargarfoto cargarfoto = new cargarfoto();
                        cargarfoto.execute(new String[]{parseInt + "", "", parseInt2 + "", z3 + "", parseInt3 + ""});
                    }
                } else {
                    t_chat.this.findViewById(R.id.btncargarmas).setVisibility(this.btncargarmas_vis);
                }
            }
        }
    }

    public static class eliminar_usu extends AsyncTask<String, Void, String> {
        private Context c;
        private String codigo;
        private long idusu;
        private String idusu_elim;

        public eliminar_usu(String str, long j, String str2, Context context) {
            this.idusu_elim = str;
            this.idusu = j;
            this.codigo = str2;
            this.c = context;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/eliminar_usu.php");
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("idusu", new StringBody(this.idusu + ""));
                multipartEntity.addPart("c", new StringBody(this.codigo));
                multipartEntity.addPart("idusu_elim", new StringBody(this.idusu_elim));
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
            if ((str.indexOf("ANDROID:OK") != -1 || str.indexOf("ANDROID:KO") != -1) && str.indexOf("ANDROID:OK") != -1) {
                Context context = this.c;
                config.mostrar_toast(Toast.makeText(context, context.getString(R.string.usu_eliminado), 0));
            }
        }
    }

    public static class cancelar_solicitud extends AsyncTask<String, Void, String> {
        private String codigo;
        private long idusu;
        private String idusu_conversante;
        private int modo;

        public cancelar_solicitud(String str, int i, long j, String str2) {
            this.idusu_conversante = str;
            this.modo = i;
            this.idusu = j;
            this.codigo = str2;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/cancelar_solicitud.php");
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("v", new StringBody("2"));
                multipartEntity.addPart("idusu", new StringBody(this.idusu + ""));
                multipartEntity.addPart("codigo", new StringBody(this.codigo));
                multipartEntity.addPart("idusu_conversante", new StringBody(this.idusu_conversante));
                multipartEntity.addPart("modo", new StringBody(this.modo + ""));
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
            } catch (Exception e) {
                e.printStackTrace();
                return "ANDROID:KO 99";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.indexOf("ANDROID:OK") != -1 || str.indexOf("ANDROID:KO") != -1) {
                str.indexOf("ANDROID:OK");
            }
        }
    }

    /* access modifiers changed from: private */
    public void iniciar_privado(String str, String str2) {
        ((LinearLayout) findViewById(R.id.llchat)).removeAllViews();
        findViewById(R.id.btnfavoritos).setVisibility(8);
        findViewById(R.id.btnperfil).setVisibility(8);
        if (this.globales.fotos_privados) {
            findViewById(R.id.btnfoto).setVisibility(0);
        } else {
            findViewById(R.id.btnfoto).setVisibility(8);
        }
        if (this.globales.cvm == 1 || this.globales.cvm == 3) {
            findViewById(R.id.btnvideo).setVisibility(0);
        } else {
            findViewById(R.id.btnvideo).setVisibility(8);
        }
        ((TextView) findViewById(R.id.tv_cabe_priv)).setText(getResources().getString(R.string.chatprivadocon) + " " + str2);
        if (this.es_privado_root) {
            findViewById(R.id.iv_cabe_priv).setVisibility(8);
        } else {
            findViewById(R.id.iv_cabe_priv).setVisibility(0);
        }
        findViewById(R.id.ll_cabe_priv).setVisibility(0);
        findViewById(R.id.ll_favnotif).setVisibility(8);
        findViewById(R.id.ll_cabe).setVisibility(8);
        findViewById(R.id.ll_cabe_der).setVisibility(8);
        this.idfrase_masantigua_glob = 0;
        new cargar_ultimas("0", str, this.idfrase_masantigua_glob).execute(new String[0]);
        this.nfrases = 0;
        this.dia_act = "";
        this.idusu_act = "";
        this.hayfrasedeotrousu = false;
        findViewById(R.id.view_aux_1).setVisibility(0);
        findViewById(R.id.view_aux_2).setVisibility(0);
        this.es_privado = true;
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putString("idprivado", str);
        edit.putString("nombreprivado", str2);
        edit.commit();
        config.anyadir_privado(this, str, str2);
    }

    private void finalizar_privado(String str) {
        final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean z;
                if (!t_chat.this.externo || t_chat.this.extras == null || !t_chat.this.extras.containsKey("id_remit")) {
                    ((LinearLayout) t_chat.this.findViewById(R.id.llchat)).removeAllViews();
                    t_chat.this.nfrases = 0;
                    t_chat.this.dia_act = "";
                    t_chat.this.idusu_act = "";
                    t_chat.this.hayfrasedeotrousu = false;
                    t_chat.this.findViewById(R.id.view_aux_1).setVisibility(0);
                    t_chat.this.findViewById(R.id.view_aux_2).setVisibility(0);
                    t_chat.this.findViewById(R.id.btnfavoritos).setVisibility(0);
                    t_chat.this.findViewById(R.id.btnperfil).setVisibility(0);
                    if (t_chat.this.fotos_chat == 1) {
                        t_chat.this.findViewById(R.id.btnfoto).setVisibility(0);
                    } else {
                        t_chat.this.findViewById(R.id.btnfoto).setVisibility(8);
                    }
                    if (t_chat.this.externo || t_chat.this.globales.cvm == 0 || t_chat.this.globales.cvm == 1) {
                        t_chat.this.findViewById(R.id.btnvideo).setVisibility(8);
                    } else {
                        t_chat.this.findViewById(R.id.btnvideo).setVisibility(0);
                    }
                    t_chat.this.findViewById(R.id.ll_cabe_priv).setVisibility(8);
                    t_chat.this.findViewById(R.id.ll_favnotif).setVisibility(0);
                    if (t_chat.this.ll_cabe_mostrar) {
                        t_chat.this.findViewById(R.id.ll_cabe).setVisibility(0);
                    } else if (!t_chat.this.externo && t_chat.this.secc_act.acceso_a_externo) {
                        t_chat.this.findViewById(R.id.ll_cabe_der).setVisibility(0);
                    }
                    t_chat.this.idfrase_masantigua_glob = 0;
                    z = false;
                } else {
                    t_chat.this.idfrase_masantigua_glob = -1;
                    z = true;
                }
                if (t_chat.this.idfrase_masantigua_glob != -1) {
                    t_chat t_chat = t_chat.this;
                    new cargar_ultimas("0", "0", t_chat.idfrase_masantigua_glob).execute(new String[0]);
                }
                t_chat.this.es_privado = false;
                SharedPreferences.Editor edit = t_chat.this.settings.edit();
                edit.putString("idprivado", "0");
                edit.commit();
                if (z) {
                    t_chat.this.finalizar = true;
                    t_chat.this.finalizar();
                    t_chat.this.finish();
                }
            }
        }).setMessage(R.string.confirmar_salirprivado).create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + t_chat.this.cbtn));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        String string = this.settings.getString("idprivado", "0");
        if (!string.equals("0") && !this.es_privado_root) {
            finalizar_privado(string);
        } else if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            if (this.es_privado_root) {
                finalizar();
            }
            super.onBackPressed();
        } else {
            this.atras_pulsado = true;
            config.confirmar_exit(this);
        }
    }

    public static CharSequence addSmileySpans(Context context, CharSequence charSequence) {
        HashMap hashMap = new HashMap();
        hashMap.put(":-D\\|", Integer.valueOf(R.drawable.smile1));
        hashMap.put(":-O\\|", Integer.valueOf(R.drawable.smile2));
        hashMap.put(":-\\(\\|", Integer.valueOf(R.drawable.smile3));
        hashMap.put(":-\\)\\|", Integer.valueOf(R.drawable.smile4));
        hashMap.put(";-\\)\\|", Integer.valueOf(R.drawable.smile5));
        hashMap.put(":-\\|", Integer.valueOf(R.drawable.smile6));
        hashMap.put("B-D\\|", Integer.valueOf(R.drawable.smile7));
        hashMap.put("8-\\)", Integer.valueOf(R.drawable.smile8));
        hashMap.put(":-p\\|", Integer.valueOf(R.drawable.smile9));
        hashMap.put(":\"\\)", Integer.valueOf(R.drawable.smile10));
        hashMap.put(":'\\(\\|", Integer.valueOf(R.drawable.smile11));
        hashMap.put("X\\(", Integer.valueOf(R.drawable.smile12));
        hashMap.put(":x\\|", Integer.valueOf(R.drawable.smile13));
        hashMap.put(">:\\)\\|", Integer.valueOf(R.drawable.smile14));
        hashMap.put("O:\\)\\|", Integer.valueOf(R.drawable.smile15));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        for (Map.Entry entry : hashMap.entrySet()) {
            Matcher matcher = Pattern.compile((String) entry.getKey(), 2).matcher(charSequence);
            while (matcher.find()) {
                Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), ((Integer) entry.getValue()).intValue());
                Object[] spans = spannableStringBuilder.getSpans(matcher.start(), matcher.end(), ImageSpan.class);
                if (spans == null || spans.length == 0) {
                    spannableStringBuilder.setSpan(new ImageSpan(context, decodeResource), matcher.start(), matcher.end(), 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        if (this.settings2 == null) {
            this.settings2 = getSharedPreferences("accion", 0);
        }
        SharedPreferences.Editor edit = this.settings2.edit();
        edit.putInt("accion", 0);
        edit.commit();
        if (this.settings == null) {
            this.settings = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        }
        SharedPreferences.Editor edit2 = this.settings.edit();
        edit2.putBoolean("activa" + this.idtema, true);
        edit2.putBoolean("activa", true);
        edit2.commit();
        this.settings.registerOnSharedPreferenceChangeListener(this);
        this.settings2.registerOnSharedPreferenceChangeListener(this);
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (this.globales.admob_pos != 0 && (anuncios = this.anun) != null && anuncios.wortiseBanner != null) {
            this.anun.wortiseBanner.resume();
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
    }

    /* access modifiers changed from: package-private */
    public void finalizar() {
        this.es_privado = false;
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putBoolean("activa" + this.idtema, false);
        edit.putBoolean("activa", false);
        edit.putString("idprivado", "0");
        edit.commit();
        this.settings.unregisterOnSharedPreferenceChangeListener(this);
        this.settings2.unregisterOnSharedPreferenceChangeListener(this);
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
        if (isFinishing()) {
            finalizar();
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
        config config = this.globales;
        this.anun = config.mostrar_banner_2(this, false, !config.banners_enchats);
    }

    private class cargarfoto extends AsyncTask<String, Void, Byte> {
        boolean fondo_margen;
        int fondo_tipo;
        String idfoto;
        String ind;
        String vfoto;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        private cargarfoto() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0092, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x008e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                r1 = r6[r0]
                r5.idfoto = r1
                r1 = 1
                r2 = r6[r1]
                r5.ind = r2
                r2 = 2
                r2 = r6[r2]
                r5.vfoto = r2
                r2 = 3
                r2 = r6[r2]
                java.lang.String r3 = "1"
                boolean r2 = r2.equals(r3)
                r5.fondo_margen = r2
                r2 = 4
                r6 = r6[r2]
                int r6 = java.lang.Integer.parseInt(r6)
                r5.fondo_tipo = r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN
                r6.append(r2)
                java.lang.String r2 = "/srv/imgs/chat/"
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
                java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x009d }
                r4.<init>(r6)     // Catch:{ MalformedURLException -> 0x009d }
                java.net.URLConnection r6 = r4.openConnection()     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                r6.setDoInput(r1)     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                r1 = 5000(0x1388, float:7.006E-42)
                r6.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r6.setReadTimeout(r1)     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                r6.connect()     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                java.io.InputStream r6 = r6.getInputStream()     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                stikerwap.appdys.t_chat r1 = stikerwap.appdys.t_chat.this     // Catch:{ Exception -> 0x008e }
                java.io.FileOutputStream r1 = r1.openFileOutput(r2, r0)     // Catch:{ Exception -> 0x008e }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x008e }
                r4 = 100
                r6.compress(r2, r4, r1)     // Catch:{ Exception -> 0x008e }
                r1.close()     // Catch:{ Exception -> 0x008e }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r0)
                return r6
            L_0x008e:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)     // Catch:{ IOException -> 0x0098, OutOfMemoryError -> 0x0093 }
                return r6
            L_0x0093:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            L_0x0098:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            L_0x009d:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_chat.cargarfoto.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (b.byteValue() == 0) {
                try {
                    ImageView imageView = (ImageView) t_chat.this.findViewById(R.id.iv_fondo);
                    t_chat.this.globales.tratar_fondo(imageView, Boolean.valueOf(this.fondo_margen), this.fondo_tipo);
                    imageView.setVisibility(8);
                    config r1 = t_chat.this.globales;
                    r1.file_to_iv("fondo_" + this.idfoto, imageView);
                    config.fade_in(imageView);
                } catch (Exception unused) {
                }
                if (!t_chat.this.externo) {
                    SharedPreferences.Editor edit = t_chat.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                    edit.putInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + this.idfoto + "_fondo_modif", 0);
                    edit.commit();
                    t_chat.this.globales.secciones_a[Integer.parseInt(this.ind)].fondo_modif = false;
                    return;
                }
                new marcar_fondo_guardado().execute(new String[]{this.idfoto});
            }
        }
    }

    private class marcar_fondo_guardado extends AsyncTask<String, Void, Byte> {
        String idfoto;

        private marcar_fondo_guardado() {
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            this.idfoto = strArr[0];
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/fondo_guardado.php");
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("idusu", new StringBody(t_chat.this.idusu + ""));
                multipartEntity.addPart("c", new StringBody(t_chat.this.codigo));
                multipartEntity.addPart("idfoto", new StringBody(this.idfoto + ""));
                httpPost.setEntity(multipartEntity);
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
                return (byte) 0;
            } catch (Exception unused) {
                return (byte) -1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f_tts(ImageView imageView, ImageView imageView2) {
        if (!this.tts_preparado) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.textToSpeechSystem.speak((String) imageView.getTag(R.id.idaux1), 0, (Bundle) null, (String) imageView.getTag());
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            return;
        }
        this.textToSpeechSystem.speak((String) imageView.getTag(R.id.idaux1), 0, (HashMap) null);
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
                if (!t_chat.this.globales.admob_rew_failed(context, t_chat.this.mAd_appnext)) {
                    t_chat.this.dialog_cargando.cancel();
                    t_chat t_chat = t_chat.this;
                    t_chat.abrir_secc(t_chat.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_chat.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_chat.this.abrir_secc(t_chat.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_chat.this.mAd_visto) {
                            t_chat.this.abrir_secc(t_chat.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_chat.this.mAd_visto = true;
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
                if (t_chat.this.mAd_visto) {
                    t_chat t_chat = t_chat.this;
                    t_chat.abrir_secc(t_chat.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
