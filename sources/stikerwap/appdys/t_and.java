package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import java.io.File;

public class t_and extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    AndItem ai;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_foto;
    int[][] coord_fotoacargar;
    Bundle extras;
    File file_global;
    config globales;
    int[] id_fotoacargar;
    int ind_abrir_secc = -1;
    int ind_fotoacargar;
    ImageView[] iv_fotoacargar;
    boolean mAd_visto = false;
    ListView mDrawerList;
    int n_fotoacargar;
    ProgressBar[] pb_fotoacargar;
    Seccion s;
    float scale;
    SharedPreferences settings;
    String url_global;
    int w_max;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0635  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x064f  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0686  */
    /* JADX WARNING: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0197 A[LOOP:0: B:53:0x0190->B:55:0x0197, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r25) {
        /*
            r24 = this;
            r11 = r24
            r0 = r25
            android.content.Context r1 = r24.getApplicationContext()
            stikerwap.appdys.config r1 = (stikerwap.appdys.config) r1
            r11.globales = r1
            java.lang.String r1 = r1.c1
            if (r1 != 0) goto L_0x0015
            stikerwap.appdys.config r1 = r11.globales
            r1.recuperar_vars()
        L_0x0015:
            r11.establec_ralc(r11)
            android.content.Intent r1 = r24.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r11.extras = r1
            java.lang.String r2 = "es_root"
            r12 = 1
            r13 = 0
            if (r0 != 0) goto L_0x003e
            if (r1 == 0) goto L_0x003a
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x003a
            android.os.Bundle r1 = r11.extras
            boolean r1 = r1.getBoolean(r2, r13)
            if (r1 == 0) goto L_0x003a
            r1 = 1
            goto L_0x003b
        L_0x003a:
            r1 = 0
        L_0x003b:
            r11.es_root = r1
            goto L_0x004f
        L_0x003e:
            boolean r1 = r0.containsKey(r2)
            if (r1 == 0) goto L_0x004c
            boolean r1 = r0.getBoolean(r2, r13)
            if (r1 == 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            r11.es_root = r1
        L_0x004f:
            stikerwap.appdys.config r1 = r11.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            stikerwap.appdys.config r2 = r11.globales
            int r2 = r2.ind_secc_sel_2
            r1 = r1[r2]
            java.lang.String r1 = r1.c1
            stikerwap.appdys.config r2 = r11.globales
            java.lang.String r2 = r2.c_icos
            java.lang.String r1 = stikerwap.appdys.config.aplicar_color_dialog(r1, r2)
            r11.cbtn = r1
            super.onCreate(r25)
            r1 = 2131558706(0x7f0d0132, float:1.8742735E38)
            r11.setContentView(r1)
            r24.incluir_menu_pre()
            stikerwap.appdys.config r1 = r11.globales
            r1.onCreate_global(r11, r13)
            java.lang.String r1 = "search"
            java.lang.Object r1 = r11.getSystemService(r1)
            android.app.SearchManager r1 = (android.app.SearchManager) r1
            stikerwap.appdys.t_and$1 r2 = new stikerwap.appdys.t_and$1
            r2.<init>()
            r1.setOnCancelListener(r2)
            stikerwap.appdys.t_and$2 r2 = new stikerwap.appdys.t_and$2
            r2.<init>()
            r1.setOnDismissListener(r2)
            if (r0 != 0) goto L_0x00b3
            stikerwap.appdys.config r1 = r11.globales
            android.os.Bundle r2 = r11.extras
            if (r2 == 0) goto L_0x00a0
            java.lang.String r3 = "ad_entrar"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x00a0
            r2 = 1
            goto L_0x00a1
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            android.os.Bundle r3 = r11.extras
            if (r3 == 0) goto L_0x00af
            java.lang.String r4 = "fb_entrar"
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x00af
            r3 = 1
            goto L_0x00b0
        L_0x00af:
            r3 = 0
        L_0x00b0:
            r1.toca_int(r11, r2, r3)
        L_0x00b3:
            stikerwap.appdys.config r1 = r11.globales
            stikerwap.appdys.Anuncios r1 = r1.mostrar_banner(r11, r13)
            r11.anun = r1
            stikerwap.appdys.config r1 = r11.globales
            int r2 = r1.ind_secc_sel_2
            java.lang.String r3 = r11.cbtn
            r1.oncreate_popup(r11, r2, r3, r0)
            android.content.Intent r0 = r24.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            stikerwap.appdys.config r1 = r11.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            java.lang.String r2 = "idsecc"
            int r0 = r0.getInt(r2)
            r0 = r1[r0]
            r11.s = r0
            android.content.res.Resources r0 = r24.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            r11.scale = r0
            java.lang.String r0 = "sh"
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r0, r13)
            r11.settings = r0
            stikerwap.appdys.config r0 = r11.globales
            int r0 = r0.fondo_v
            if (r0 <= 0) goto L_0x00fa
            android.content.SharedPreferences r0 = r11.settings
            r0.registerOnSharedPreferenceChangeListener(r11)
        L_0x00fa:
            stikerwap.appdys.config r0 = r11.globales
            int r0 = r0.fondo_v
            if (r0 <= 0) goto L_0x0137
            android.content.SharedPreferences r0 = r11.settings
            java.lang.String r1 = "fondo_v_act"
            int r0 = r0.getInt(r1, r13)
            stikerwap.appdys.config r1 = r11.globales
            int r1 = r1.fondo_v
            if (r0 != r1) goto L_0x0137
            stikerwap.appdys.config r0 = r11.globales     // Catch:{ Exception -> 0x0136 }
            r1 = 2131362464(0x7f0a02a0, float:1.834471E38)
            android.view.View r2 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0136 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0136 }
            stikerwap.appdys.config r3 = r11.globales     // Catch:{ Exception -> 0x0136 }
            boolean r3 = r3.fondo_margen     // Catch:{ Exception -> 0x0136 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0136 }
            stikerwap.appdys.config r4 = r11.globales     // Catch:{ Exception -> 0x0136 }
            int r4 = r4.fondo_tipo     // Catch:{ Exception -> 0x0136 }
            r0.tratar_fondo(r2, r3, r4)     // Catch:{ Exception -> 0x0136 }
            stikerwap.appdys.config r0 = r11.globales     // Catch:{ Exception -> 0x0136 }
            java.lang.String r2 = "fondo"
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0136 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0136 }
            r0.file_to_iv(r2, r1)     // Catch:{ Exception -> 0x0136 }
            goto L_0x0137
        L_0x0136:
        L_0x0137:
            r0 = 2131362632(0x7f0a0348, float:1.834505E38)
            android.view.View r0 = r11.findViewById(r0)
            r14 = r0
            android.widget.ScrollView r14 = (android.widget.ScrollView) r14
            android.view.LayoutInflater r15 = android.view.LayoutInflater.from(r24)
            stikerwap.appdys.Seccion r0 = r11.s
            java.lang.String r0 = r0.c1
            java.lang.String r10 = ""
            boolean r0 = r0.equals(r10)
            r1 = 2
            r9 = 0
            java.lang.String r8 = "#"
            if (r0 != 0) goto L_0x018d
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x018c }
            android.graphics.drawable.GradientDrawable$Orientation r2 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM     // Catch:{ Exception -> 0x018c }
            int[] r3 = new int[r1]     // Catch:{ Exception -> 0x018c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018c }
            r4.<init>(r8)     // Catch:{ Exception -> 0x018c }
            stikerwap.appdys.Seccion r5 = r11.s     // Catch:{ Exception -> 0x018c }
            java.lang.String r5 = r5.c1     // Catch:{ Exception -> 0x018c }
            r4.append(r5)     // Catch:{ Exception -> 0x018c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x018c }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x018c }
            r3[r13] = r4     // Catch:{ Exception -> 0x018c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018c }
            r4.<init>(r8)     // Catch:{ Exception -> 0x018c }
            stikerwap.appdys.Seccion r5 = r11.s     // Catch:{ Exception -> 0x018c }
            java.lang.String r5 = r5.c2     // Catch:{ Exception -> 0x018c }
            r4.append(r5)     // Catch:{ Exception -> 0x018c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x018c }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x018c }
            r3[r12] = r4     // Catch:{ Exception -> 0x018c }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x018c }
            r7 = r0
            goto L_0x018e
        L_0x018c:
        L_0x018d:
            r7 = r9
        L_0x018e:
            r0 = 0
            r2 = 0
        L_0x0190:
            stikerwap.appdys.Seccion r3 = r11.s
            stikerwap.appdys.AndItem[] r3 = r3.and_items_a
            int r3 = r3.length
            if (r0 >= r3) goto L_0x01a5
            stikerwap.appdys.Seccion r3 = r11.s
            stikerwap.appdys.AndItem[] r3 = r3.and_items_a
            r3 = r3[r0]
            int[][] r3 = r3.fotos_a
            int r3 = r3.length
            int r3 = r3 + r12
            int r2 = r2 + r3
            int r0 = r0 + 1
            goto L_0x0190
        L_0x01a5:
            r11.n_fotoacargar = r13
            int[] r0 = new int[r2]
            r11.id_fotoacargar = r0
            android.widget.ImageView[] r0 = new android.widget.ImageView[r2]
            r11.iv_fotoacargar = r0
            android.widget.ProgressBar[] r0 = new android.widget.ProgressBar[r2]
            r11.pb_fotoacargar = r0
            int[] r0 = new int[r1]
            r0[r12] = r1
            r0[r13] = r2
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r1, r0)
            int[][] r0 = (int[][]) r0
            r11.coord_fotoacargar = r0
            r6 = 0
        L_0x01c4:
            stikerwap.appdys.Seccion r0 = r11.s
            stikerwap.appdys.AndItem[] r0 = r0.and_items_a
            int r0 = r0.length
            if (r6 >= r0) goto L_0x0664
            stikerwap.appdys.Seccion r0 = r11.s
            stikerwap.appdys.AndItem[] r0 = r0.and_items_a
            r0 = r0[r6]
            r11.ai = r0
            r0 = 2131558707(0x7f0d0133, float:1.8742737E38)
            android.view.View r5 = r15.inflate(r0, r9)
            r0 = 125(0x7d, float:1.75E-43)
            r11.w_max = r0
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r0 = r0.txt
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01ec
            r0 = 250(0xfa, float:3.5E-43)
            r11.w_max = r0
        L_0x01ec:
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.txt_h
            if (r0 != r12) goto L_0x01f8
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.fotos_c
            if (r0 == r12) goto L_0x0204
        L_0x01f8:
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.fotos_h
            if (r0 != r12) goto L_0x0207
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.txt_c
            if (r0 != r12) goto L_0x0207
        L_0x0204:
            r0 = 17
            goto L_0x020a
        L_0x0207:
            r0 = 8388611(0x800003, float:1.1754948E-38)
        L_0x020a:
            stikerwap.appdys.AndItem r1 = r11.ai
            java.lang.String r1 = r1.tit1
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x0290
            stikerwap.appdys.AndItem r1 = r11.ai
            int r1 = r1.txt_h
            if (r1 != 0) goto L_0x022d
            stikerwap.appdys.AndItem r1 = r11.ai
            int r1 = r1.fotos_h
            if (r1 != 0) goto L_0x022d
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.tit1_c
            if (r0 != 0) goto L_0x022a
            r16 = 8388611(0x800003, float:1.1754948E-38)
            goto L_0x022f
        L_0x022a:
            r16 = 17
            goto L_0x022f
        L_0x022d:
            r16 = r0
        L_0x022f:
            r0 = 2131361926(0x7f0a0086, float:1.8343618E38)
            android.view.View r0 = r5.findViewById(r0)
            r2 = r0
            android.widget.TextView r2 = (android.widget.TextView) r2
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r1 = r0.tit1
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.tit1_c
            stikerwap.appdys.AndItem r3 = r11.ai
            int r3 = r3.tit1_b
            stikerwap.appdys.AndItem r4 = r11.ai
            int r4 = r4.tit1_i
            stikerwap.appdys.AndItem r9 = r11.ai
            int r9 = r9.tit1_f
            stikerwap.appdys.AndItem r12 = r11.ai
            java.lang.String r12 = r12.tit1_col
            stikerwap.appdys.AndItem r13 = r11.ai
            int r13 = r13.tit1_u
            r18 = r0
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.tit1_s
            r19 = 0
            r20 = r0
            r0 = r24
            r21 = r1
            r1 = r2
            r22 = r2
            r2 = r21
            r21 = r3
            r3 = r18
            r17 = r4
            r4 = r21
            r23 = r5
            r5 = r17
            r17 = r6
            r6 = r9
            r9 = r7
            r7 = r12
            r12 = r8
            r8 = r13
            r13 = r9
            r25 = r15
            r15 = 0
            r9 = r20
            r15 = r10
            r10 = r19
            r0.tratar_tv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r22
            r1 = 0
            r0.setVisibility(r1)
            r4 = r16
            goto L_0x029a
        L_0x0290:
            r23 = r5
            r17 = r6
            r13 = r7
            r12 = r8
            r25 = r15
            r15 = r10
            r4 = r0
        L_0x029a:
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.fcab_id
            if (r0 == 0) goto L_0x02b8
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.txt_h
            if (r0 != 0) goto L_0x02b8
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.fotos_h
            if (r0 != 0) goto L_0x02b8
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.fcab_c
            if (r0 != 0) goto L_0x02b6
            r4 = 8388611(0x800003, float:1.1754948E-38)
            goto L_0x02b8
        L_0x02b6:
            r4 = 17
        L_0x02b8:
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r0 = r0.tit2
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0324
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.txt_h
            if (r0 != 0) goto L_0x02db
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.fotos_h
            if (r0 != 0) goto L_0x02db
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.tit2_c
            if (r0 != 0) goto L_0x02d8
            r16 = 8388611(0x800003, float:1.1754948E-38)
            goto L_0x02dd
        L_0x02d8:
            r16 = 17
            goto L_0x02dd
        L_0x02db:
            r16 = r4
        L_0x02dd:
            r0 = 2131361927(0x7f0a0087, float:1.834362E38)
            r10 = r23
            android.view.View r0 = r10.findViewById(r0)
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r2 = r0.tit2
            stikerwap.appdys.AndItem r0 = r11.ai
            int r3 = r0.tit2_c
            stikerwap.appdys.AndItem r0 = r11.ai
            int r4 = r0.tit2_b
            stikerwap.appdys.AndItem r0 = r11.ai
            int r5 = r0.tit2_i
            stikerwap.appdys.AndItem r0 = r11.ai
            int r6 = r0.tit2_f
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r7 = r0.tit2_col
            stikerwap.appdys.AndItem r0 = r11.ai
            int r8 = r0.tit2_u
            stikerwap.appdys.AndItem r0 = r11.ai
            int r1 = r0.tit2_s
            r18 = 0
            r0 = r24
            r19 = r1
            r1 = r9
            r20 = r14
            r14 = r9
            r9 = r19
            r19 = r13
            r13 = r10
            r10 = r18
            r0.tratar_tv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 0
            r14.setVisibility(r0)
            r4 = r16
            goto L_0x032a
        L_0x0324:
            r19 = r13
            r20 = r14
            r13 = r23
        L_0x032a:
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r14 = -2
            r0.<init>(r14, r14)
            r10 = 2131362559(0x7f0a02ff, float:1.8344902E38)
            r9 = 8388611(0x800003, float:1.1754948E-38)
            if (r4 != r9) goto L_0x0343
            r0.gravity = r4
            android.view.View r1 = r13.findViewById(r10)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.setLayoutParams(r0)
        L_0x0343:
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r0 = r0.txt
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0393
            android.view.View r0 = r13.findViewById(r10)
            r1 = 0
            r0.setVisibility(r1)
            r0 = 2131361928(0x7f0a0088, float:1.8343622E38)
            android.view.View r0 = r13.findViewById(r0)
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r2 = r0.txt
            r3 = 0
            stikerwap.appdys.AndItem r0 = r11.ai
            int r4 = r0.txt_b
            stikerwap.appdys.AndItem r0 = r11.ai
            int r5 = r0.txt_i
            stikerwap.appdys.AndItem r0 = r11.ai
            int r6 = r0.txt_f
            stikerwap.appdys.AndItem r0 = r11.ai
            java.lang.String r7 = r0.txt_col
            stikerwap.appdys.AndItem r0 = r11.ai
            int r1 = r0.txt_u
            stikerwap.appdys.AndItem r0 = r11.ai
            int r0 = r0.txt_s
            r16 = 1
            r18 = r0
            r0 = r24
            r21 = r1
            r1 = r8
            r14 = r8
            r8 = r21
            r9 = r18
            r10 = r16
            r0.tratar_tv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 0
            r14.setVisibility(r0)
        L_0x0393:
            stikerwap.appdys.Seccion r0 = r11.s
            java.lang.String r0 = r0.c1
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x03b5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            stikerwap.appdys.Seccion r1 = r11.s
            java.lang.String r1 = r1.c1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = stikerwap.appdys.config.esClaro(r0)
            if (r0 == 0) goto L_0x03b5
            r0 = 1
            goto L_0x03b6
        L_0x03b5:
            r0 = 0
        L_0x03b6:
            stikerwap.appdys.AndItem r1 = r11.ai
            int r1 = r1.fcab_id
            java.lang.String r2 = ".png"
            if (r1 == 0) goto L_0x04a7
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r3 = -2
            r1.<init>(r3, r3)
            stikerwap.appdys.AndItem r3 = r11.ai
            int r3 = r3.fcab_c
            if (r3 != 0) goto L_0x03d0
            r3 = 8388611(0x800003, float:1.1754948E-38)
            r1.gravity = r3
            goto L_0x03db
        L_0x03d0:
            stikerwap.appdys.AndItem r3 = r11.ai
            int r3 = r3.fcab_c
            r4 = 1
            if (r3 != r4) goto L_0x03db
            r3 = 17
            r1.gravity = r3
        L_0x03db:
            r3 = 2131361923(0x7f0a0083, float:1.8343612E38)
            android.view.View r3 = r13.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r0 == 0) goto L_0x03f0
            r4 = 2131361925(0x7f0a0085, float:1.8343616E38)
            android.view.View r4 = r13.findViewById(r4)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            goto L_0x03f9
        L_0x03f0:
            r4 = 2131361924(0x7f0a0084, float:1.8343614E38)
            android.view.View r4 = r13.findViewById(r4)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
        L_0x03f9:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 20
            if (r5 <= r6) goto L_0x0406
            stikerwap.appdys.config r5 = r11.globales
            java.lang.String r5 = r5.c_icos
            stikerwap.appdys.config.progress_color(r4, r5)
        L_0x0406:
            r3.setLayoutParams(r1)
            r4.setLayoutParams(r1)
            stikerwap.appdys.AndItem r1 = r11.ai
            java.lang.String r1 = r1.fcab_url
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x041f
            stikerwap.appdys.t_and$3 r1 = new stikerwap.appdys.t_and$3
            r1.<init>()
            r3.setOnClickListener(r1)
            goto L_0x042d
        L_0x041f:
            stikerwap.appdys.AndItem r1 = r11.ai
            boolean r1 = r1.fcab_zoom
            if (r1 == 0) goto L_0x042d
            stikerwap.appdys.t_and$4 r1 = new stikerwap.appdys.t_and$4
            r1.<init>()
            r3.setOnClickListener(r1)
        L_0x042d:
            stikerwap.appdys.AndItem r1 = r11.ai
            int r1 = r1.fcab_modif
            r5 = 1
            if (r1 != r5) goto L_0x0459
            int[] r1 = r11.id_fotoacargar
            int r5 = r11.n_fotoacargar
            stikerwap.appdys.AndItem r6 = r11.ai
            int r6 = r6.fcab_id
            r1[r5] = r6
            android.widget.ImageView[] r1 = r11.iv_fotoacargar
            int r5 = r11.n_fotoacargar
            r1[r5] = r3
            android.widget.ProgressBar[] r1 = r11.pb_fotoacargar
            r1[r5] = r4
            int[][] r1 = r11.coord_fotoacargar
            r1 = r1[r5]
            r3 = 0
            r1[r3] = r17
            r6 = 1
            r1[r6] = r3
            int r5 = r5 + r6
            r11.n_fotoacargar = r5
            r4.setVisibility(r3)
            goto L_0x04a7
        L_0x0459:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "it_fcab"
            r1.<init>(r4)
            stikerwap.appdys.AndItem r5 = r11.ai
            int r5 = r5.fcab_id
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.io.File r5 = r11.getFileStreamPath(r5)
            boolean r6 = r5.exists()
            if (r6 != 0) goto L_0x048b
            java.io.File r1 = r11.getFileStreamPath(r1)
            r1.renameTo(r5)
        L_0x048b:
            stikerwap.appdys.config r1 = r11.globales
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            stikerwap.appdys.AndItem r4 = r11.ai
            int r4 = r4.fcab_id
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
            r1.file_to_iv(r4, r3)
            r1 = 0
            r3.setVisibility(r1)
        L_0x04a7:
            stikerwap.appdys.AndItem r1 = r11.ai
            int[][] r1 = r1.fotos_a
            int r1 = r1.length
            if (r1 <= 0) goto L_0x0633
            stikerwap.appdys.AndItem r1 = r11.ai
            int r1 = r1.fotos_pos
            if (r1 != 0) goto L_0x04be
            r1 = 2131362560(0x7f0a0300, float:1.8344904E38)
            android.view.View r1 = r13.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            goto L_0x04c7
        L_0x04be:
            r1 = 2131362561(0x7f0a0301, float:1.8344906E38)
            android.view.View r1 = r13.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
        L_0x04c7:
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r4 = -2
            r3.<init>(r4, r4)
            r4 = 0
        L_0x04ce:
            stikerwap.appdys.AndItem r5 = r11.ai
            int[][] r5 = r5.fotos_a
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0625
            android.widget.ImageView r5 = new android.widget.ImageView
            r5.<init>(r11)
            r6 = 1092616192(0x41200000, float:10.0)
            float r7 = r11.scale
            float r7 = r7 * r6
            r6 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 + r6
            int r7 = (int) r7
            r8 = 0
            r5.setPadding(r8, r8, r8, r7)
            r7 = 8
            r5.setVisibility(r7)
            r8 = 1
            r5.setAdjustViewBounds(r8)
            stikerwap.appdys.AndItem r8 = r11.ai
            java.lang.String[] r8 = r8.fotos_str_a
            r8 = r8[r4]
            boolean r8 = r8.equals(r15)
            java.lang.String r9 = "it_f"
            if (r8 != 0) goto L_0x0510
            stikerwap.appdys.AndItem r8 = r11.ai
            java.lang.String[] r8 = r8.fotos_str_a
            r8 = r8[r4]
            r11.url_global = r8
            stikerwap.appdys.t_and$5 r8 = new stikerwap.appdys.t_and$5
            r8.<init>()
            r5.setOnClickListener(r8)
            goto L_0x053c
        L_0x0510:
            stikerwap.appdys.AndItem r8 = r11.ai
            boolean r8 = r8.fotos_zoom
            if (r8 == 0) goto L_0x053c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r9)
            stikerwap.appdys.AndItem r10 = r11.ai
            int[][] r10 = r10.fotos_a
            r10 = r10[r4]
            r14 = 0
            r10 = r10[r14]
            r8.append(r10)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.io.File r8 = r11.getFileStreamPath(r8)
            r11.file_global = r8
            stikerwap.appdys.t_and$6 r8 = new stikerwap.appdys.t_and$6
            r8.<init>()
            r5.setOnClickListener(r8)
        L_0x053c:
            if (r0 == 0) goto L_0x0548
            android.widget.ProgressBar r8 = new android.widget.ProgressBar
            r10 = 16843399(0x1010287, float:2.369537E-38)
            r14 = 0
            r8.<init>(r11, r14, r10)
            goto L_0x054d
        L_0x0548:
            android.widget.ProgressBar r8 = new android.widget.ProgressBar
            r8.<init>(r11)
        L_0x054d:
            stikerwap.appdys.config r10 = r11.globales
            java.lang.String r10 = r10.c_icos
            stikerwap.appdys.config.progress_color(r8, r10)
            r10 = 10
            r14 = 0
            r8.setPadding(r14, r14, r14, r10)
            r8.setVisibility(r7)
            r1.addView(r8, r3)
            r1.addView(r5, r3)
            stikerwap.appdys.AndItem r7 = r11.ai
            int[][] r7 = r7.fotos_a
            r7 = r7[r4]
            r10 = 1
            r7 = r7[r10]
            if (r7 != r10) goto L_0x059b
            int[] r6 = r11.id_fotoacargar
            int r7 = r11.n_fotoacargar
            stikerwap.appdys.AndItem r9 = r11.ai
            int[][] r9 = r9.fotos_a
            r9 = r9[r4]
            r10 = 0
            r9 = r9[r10]
            r6[r7] = r9
            android.widget.ImageView[] r6 = r11.iv_fotoacargar
            int r7 = r11.n_fotoacargar
            r6[r7] = r5
            android.widget.ProgressBar[] r5 = r11.pb_fotoacargar
            r5[r7] = r8
            int[][] r5 = r11.coord_fotoacargar
            r5 = r5[r7]
            r5[r10] = r17
            int r6 = r4 + 1
            r9 = 1
            r5[r9] = r6
            int r7 = r7 + r9
            r11.n_fotoacargar = r7
            r8.setVisibility(r10)
            r6 = 0
            goto L_0x0621
        L_0x059b:
            r10 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            stikerwap.appdys.AndItem r8 = r11.ai
            int[][] r8 = r8.fotos_a
            r8 = r8[r4]
            r8 = r8[r10]
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.io.File r8 = r11.getFileStreamPath(r8)
            boolean r10 = r8.exists()
            if (r10 != 0) goto L_0x05d0
            java.io.File r7 = r11.getFileStreamPath(r7)
            r7.renameTo(r8)
        L_0x05d0:
            stikerwap.appdys.config r7 = r11.globales
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r9)
            stikerwap.appdys.AndItem r9 = r11.ai
            int[][] r9 = r9.fotos_a
            r9 = r9[r4]
            r10 = 0
            r9 = r9[r10]
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            int[] r7 = r7.file_to_iv(r8, r5)
            r8 = r7[r10]
            if (r8 <= 0) goto L_0x061d
            int r9 = r11.w_max
            r14 = 1
            if (r8 <= r9) goto L_0x0601
            r16 = r7[r14]
            int r16 = r16 * r9
            int r16 = r16 / r8
            r7[r14] = r16
            r7[r10] = r9
        L_0x0601:
            r8 = r7[r10]
            float r8 = (float) r8
            float r9 = r11.scale
            float r8 = r8 * r9
            float r8 = r8 + r6
            int r8 = (int) r8
            r7 = r7[r14]
            float r7 = (float) r7
            float r7 = r7 * r9
            float r7 = r7 + r6
            int r6 = (int) r7
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            r7.width = r8
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            r7.height = r6
        L_0x061d:
            r6 = 0
            r5.setVisibility(r6)
        L_0x0621:
            int r4 = r4 + 1
            goto L_0x04ce
        L_0x0625:
            r6 = 0
            r1.setVisibility(r6)
            r0 = 2131362559(0x7f0a02ff, float:1.8344902E38)
            android.view.View r0 = r13.findViewById(r0)
            r0.setVisibility(r6)
        L_0x0633:
            if (r19 == 0) goto L_0x064f
            stikerwap.appdys.Seccion r0 = r11.s
            int r0 = r0.c_peritem
            r1 = 1
            if (r0 != r1) goto L_0x064c
            stikerwap.appdys.Seccion r0 = r11.s
            java.lang.String r0 = r0.c1
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x064c
            r0 = r19
            r13.setBackgroundDrawable(r0)
            goto L_0x0652
        L_0x064c:
            r0 = r19
            goto L_0x0652
        L_0x064f:
            r0 = r19
            r1 = 1
        L_0x0652:
            r2 = r20
            r2.addView(r13)
            int r6 = r17 + 1
            r7 = r0
            r14 = r2
            r8 = r12
            r10 = r15
            r9 = 0
            r12 = 1
            r13 = 0
            r15 = r25
            goto L_0x01c4
        L_0x0664:
            r0 = r7
            r15 = r10
            if (r0 == 0) goto L_0x0682
            stikerwap.appdys.Seccion r1 = r11.s
            int r1 = r1.c_peritem
            if (r1 != 0) goto L_0x0682
            stikerwap.appdys.Seccion r1 = r11.s
            java.lang.String r1 = r1.c1
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0682
            r1 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setBackgroundDrawable(r0)
        L_0x0682:
            int r0 = r11.n_fotoacargar
            if (r0 <= 0) goto L_0x0694
            r0 = 0
            r11.ind_fotoacargar = r0
            stikerwap.appdys.t_and$cargarfoto r1 = new stikerwap.appdys.t_and$cargarfoto
            r2 = 0
            r1.<init>()
            java.lang.String[] r0 = new java.lang.String[r0]
            r1.execute(r0)
        L_0x0694:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_and.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tratar_url(java.lang.String r33) {
        /*
            r32 = this;
            r10 = r32
            r11 = r33
            java.lang.String r0 = r33.toLowerCase()
            java.lang.String r12 = "doc"
            java.lang.String r13 = "docx"
            java.lang.String r14 = "xls"
            java.lang.String r15 = "xlsx"
            java.lang.String r16 = "ppt"
            java.lang.String r17 = "pptx"
            java.lang.String r18 = "pdf"
            java.lang.String r19 = "pages"
            java.lang.String r20 = "ai"
            java.lang.String r21 = "psd"
            java.lang.String r22 = "tiff"
            java.lang.String r23 = "dxf"
            java.lang.String r24 = "svg"
            java.lang.String r25 = "eps"
            java.lang.String r26 = "ps"
            java.lang.String r27 = "ttf"
            java.lang.String r28 = "otf"
            java.lang.String r29 = "xps"
            java.lang.String r30 = "zip"
            java.lang.String r31 = "rar"
            java.lang.String[] r1 = new java.lang.String[]{r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31}
            java.lang.String r2 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r0)
            java.lang.String r3 = "tel:"
            boolean r4 = r0.startsWith(r3)
            java.lang.String r12 = "url"
            java.lang.String r5 = "/"
            r13 = 1
            r14 = 0
            if (r4 != 0) goto L_0x04f0
            java.lang.String r4 = "http://tel:"
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x0059
            goto L_0x04f0
        L_0x0059:
            java.lang.String r3 = "mailto:"
            boolean r4 = r0.startsWith(r3)
            java.lang.String r6 = "android.intent.action.SENDTO"
            java.lang.String r7 = "?"
            java.lang.String r8 = "UTF-8"
            r9 = -1
            java.lang.String r15 = ""
            if (r4 != 0) goto L_0x043c
            java.lang.String r4 = "http://mailto:"
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x0074
            goto L_0x043c
        L_0x0074:
            java.lang.String r3 = "smsto:"
            boolean r4 = r0.startsWith(r3)
            if (r4 != 0) goto L_0x03ba
            java.lang.String r4 = "http://smsto:"
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x0087
            goto L_0x03ba
        L_0x0087:
            java.lang.String r3 = "action_"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x0359
            java.lang.String r3 = "http://action_"
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x0099
            goto L_0x0359
        L_0x0099:
            java.lang.String r3 = "go:"
            boolean r4 = r0.startsWith(r3)
            if (r4 != 0) goto L_0x01e2
            java.lang.String r4 = "http://go:"
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x00ab
            goto L_0x01e2
        L_0x00ab:
            java.lang.String r3 = "vnd.youtube:"
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x00ef
            int r0 = r11.indexOf(r7)
            r1 = 12
            if (r0 <= 0) goto L_0x00c1
            java.lang.String r0 = r11.substring(r1, r0)
            goto L_0x00c5
        L_0x00c1:
            java.lang.String r0 = r11.substring(r1)
        L_0x00c5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "https://www.youtube.com/watch?v="
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            stikerwap.appdys.Seccion r1 = r10.s
            int r1 = r1.linksexternos
            if (r1 != r13) goto L_0x00e0
            stikerwap.appdys.config r1 = r10.globales
            r1.abrir_ext(r10, r0)
            goto L_0x0530
        L_0x00e0:
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.t_url> r2 = stikerwap.appdys.t_url.class
            r1.<init>(r10, r2)
            r1.putExtra(r12, r0)
            r10.startActivityForResult(r1, r14)
            goto L_0x0530
        L_0x00ef:
            java.lang.String r3 = ".mp3"
            boolean r3 = r0.endsWith(r3)
            java.lang.String r4 = "android.intent.action.VIEW"
            if (r3 == 0) goto L_0x010c
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r4)
            android.net.Uri r1 = android.net.Uri.parse(r33)
            java.lang.String r2 = "audio/*"
            r0.setDataAndType(r1, r2)
            r10.startActivity(r0)
            goto L_0x0530
        L_0x010c:
            java.lang.String r3 = ".mp4"
            boolean r3 = r0.endsWith(r3)
            if (r3 != 0) goto L_0x01ce
            java.lang.String r3 = ".3gp"
            boolean r3 = r0.endsWith(r3)
            if (r3 == 0) goto L_0x011e
            goto L_0x01ce
        L_0x011e:
            java.lang.String r3 = "upi://"
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x0144
            android.net.Uri r0 = android.net.Uri.parse(r33)
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r4, r0)
            android.content.res.Resources r0 = r32.getResources()
            r2 = 2131886667(0x7f12024b, float:1.940792E38)
            java.lang.String r0 = r0.getString(r2)
            android.content.Intent r0 = android.content.Intent.createChooser(r1, r0)
            r10.startActivity(r0)
            goto L_0x0530
        L_0x0144:
            stikerwap.appdys.Seccion r3 = r10.s
            int r3 = r3.linksexternos
            if (r3 == r13) goto L_0x01c6
            java.lang.String r3 = "rtsp://"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = "rtmp://"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = "market://"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = ".apk"
            boolean r3 = r0.endsWith(r3)
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = "whatsapp://"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = ".m3u"
            boolean r3 = r0.endsWith(r3)
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = ".m3u8"
            boolean r3 = r0.endsWith(r3)
            if (r3 == 0) goto L_0x0184
            goto L_0x01c6
        L_0x0184:
            if (r2 == 0) goto L_0x01c3
            boolean r3 = r2.equals(r15)
            if (r3 != 0) goto L_0x01c3
            java.util.List r1 = java.util.Arrays.asList(r1)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x01c3
            java.lang.String r1 = "docs.google.com"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x01c3
            java.lang.String r0 = "utf-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r11, r0)     // Catch:{ Exception -> 0x01a6 }
            goto L_0x01a7
        L_0x01a6:
            r0 = r11
        L_0x01a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "https://docs.google.com/viewer?embedded=true&url="
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r4, r0)
            r10.startActivity(r1)
            goto L_0x0530
        L_0x01c3:
            r13 = 0
            goto L_0x0530
        L_0x01c6:
            stikerwap.appdys.config r0 = r10.globales
            boolean r13 = r0.abrir_ext(r10, r11)
            goto L_0x0530
        L_0x01ce:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r4)
            android.net.Uri r1 = android.net.Uri.parse(r33)
            java.lang.String r2 = "video/*"
            r0.setDataAndType(r1, r2)
            r10.startActivity(r0)
            goto L_0x0530
        L_0x01e2:
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x01ee
            r0 = 3
            java.lang.String r0 = r11.substring(r0)
            goto L_0x01f4
        L_0x01ee:
            r0 = 10
            java.lang.String r0 = r11.substring(r0)
        L_0x01f4:
            boolean r1 = r0.endsWith(r5)
            if (r1 == 0) goto L_0x0203
            int r1 = r0.length()
            int r1 = r1 - r13
            java.lang.String r0 = r0.substring(r14, r1)
        L_0x0203:
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r8)     // Catch:{ Exception -> 0x0208 }
            goto L_0x0209
        L_0x0208:
        L_0x0209:
            r9 = r0
            r0 = 0
            r8 = 0
        L_0x020c:
            stikerwap.appdys.config r1 = r10.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r1 = r1.length
            if (r8 >= r1) goto L_0x0356
            stikerwap.appdys.config r1 = r10.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            r1 = r1[r8]
            java.lang.String r1 = r1.idgo
            boolean r1 = r1.equalsIgnoreCase(r9)
            if (r1 == 0) goto L_0x034b
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.appnext_rew_cod
            if (r0 == 0) goto L_0x0231
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.appnext_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0231:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.precio_secc
            if (r0 == 0) goto L_0x0241
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.precio_secc
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0241:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.admob_rew_cod
            if (r0 == 0) goto L_0x0251
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.admob_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0251:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.fb_rew_cod
            if (r0 == 0) goto L_0x0261
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.fb_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0261:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.st_rew_cod
            if (r0 == 0) goto L_0x0271
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.st_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0271:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.pollfish_cod
            if (r0 == 0) goto L_0x0281
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.pollfish_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0281:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.uni_rew_cod
            if (r0 == 0) goto L_0x0291
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.uni_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
        L_0x0291:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.is_rew_cod
            if (r0 == 0) goto L_0x0341
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.is_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x02a3
            goto L_0x0341
        L_0x02a3:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.appnext_rew_cod
            if (r0 == 0) goto L_0x02be
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.appnext_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x02be
            com.appnext.ads.fullscreen.RewardedVideo r0 = new com.appnext.ads.fullscreen.RewardedVideo
            stikerwap.appdys.config r1 = r10.globales
            java.lang.String r1 = r1.appnext_rew_cod
            r0.<init>((android.content.Context) r10, (java.lang.String) r1)
            r10.mAd_appnext = r0
        L_0x02be:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.admob_rew_cod
            if (r0 == 0) goto L_0x02cb
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.admob_rew_cod
            r0.equals(r15)
        L_0x02cb:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.fb_rew_cod
            if (r0 == 0) goto L_0x02e6
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.fb_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x02e6
            com.facebook.ads.RewardedVideoAd r0 = new com.facebook.ads.RewardedVideoAd
            stikerwap.appdys.config r1 = r10.globales
            java.lang.String r1 = r1.fb_rew_cod
            r0.<init>(r10, r1)
            r10.mAd_fb = r0
        L_0x02e6:
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.st_rew_cod
            if (r0 == 0) goto L_0x02fd
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r0 = r0.st_rew_cod
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x02fd
            com.startapp.sdk.adsbase.StartAppAd r0 = new com.startapp.sdk.adsbase.StartAppAd
            r0.<init>(r10)
            r10.mAd_st = r0
        L_0x02fd:
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            r0.<init>(r10)
            r10.dialog_cargando = r0
            android.view.View r2 = new android.view.View
            r2.<init>(r10)
            r2.setId(r8)
            r0 = 2131361812(0x7f0a0014, float:1.8343387E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.setTag(r0, r1)
            r0 = 0
            r10.v_abrir_secc = r0
            r10.ind_abrir_secc = r8
            stikerwap.appdys.config r0 = r10.globales
            java.lang.String r3 = r10.cbtn
            android.app.ProgressDialog r4 = r10.dialog_cargando
            com.google.android.gms.ads.rewarded.RewardedAdLoadCallback r5 = r10.ralc
            com.appnext.ads.fullscreen.RewardedVideo r6 = r10.mAd_appnext
            com.facebook.ads.RewardedVideoAd r7 = r10.mAd_fb
            com.startapp.sdk.adsbase.StartAppAd r1 = r10.mAd_st
            android.view.View r14 = r10.v_abrir_secc
            r18 = r1
            r1 = r32
            r13 = r8
            r8 = r18
            r18 = r9
            r9 = r14
            boolean r0 = r0.rewarded(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 != 0) goto L_0x0349
            stikerwap.appdys.config r0 = r10.globales
            r0.abrir_go(r10, r13)
            goto L_0x0349
        L_0x0341:
            r13 = r8
            r18 = r9
            stikerwap.appdys.config r0 = r10.globales
            r0.abrir_go(r10, r13)
        L_0x0349:
            r0 = 1
            goto L_0x034e
        L_0x034b:
            r13 = r8
            r18 = r9
        L_0x034e:
            int r8 = r13 + 1
            r9 = r18
            r13 = 1
            r14 = 0
            goto L_0x020c
        L_0x0356:
            r13 = r0
            goto L_0x0530
        L_0x0359:
            stikerwap.appdys.config r1 = r10.globales
            stikerwap.appdys.ResultGetIntent r0 = r1.getIntent_porURL(r0, r10)
            boolean r1 = r0.finalizar
            if (r1 == 0) goto L_0x037a
            r1 = 1
            r10.finalizar = r1
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "finalizar"
            r2.putExtra(r3, r1)
            java.lang.String r1 = "finalizar_app"
            boolean r3 = r0.finalizar_app
            r2.putExtra(r1, r3)
            r10.setResult(r9, r2)
        L_0x037a:
            boolean r1 = r0.esmas
            if (r1 == 0) goto L_0x0385
            android.content.Intent r0 = r0.i
            r1 = 0
            r10.startActivityForResult(r0, r1)
            goto L_0x03ad
        L_0x0385:
            r1 = 0
            android.content.Intent r2 = r0.i
            if (r2 == 0) goto L_0x03ad
            boolean r2 = r0.finalizar
            if (r2 == 0) goto L_0x03a7
            r10.es_root = r1
            stikerwap.appdys.config r1 = r10.globales
            int r1 = r1.tipomenu
            r2 = 2
            if (r1 == r2) goto L_0x039f
            android.content.Intent r1 = r0.i
            java.lang.String r2 = "es_root"
            r3 = 1
            r1.putExtra(r2, r3)
        L_0x039f:
            android.content.Intent r0 = r0.i     // Catch:{ Exception -> 0x03a5 }
            r10.startActivity(r0)     // Catch:{ Exception -> 0x03a5 }
            goto L_0x03ad
        L_0x03a5:
            goto L_0x03ad
        L_0x03a7:
            android.content.Intent r0 = r0.i     // Catch:{ Exception -> 0x03a5 }
            r1 = 0
            r10.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x03a5 }
        L_0x03ad:
            boolean r0 = r10.finalizar
            if (r0 == 0) goto L_0x04ee
            boolean r0 = r10.buscador_on
            if (r0 != 0) goto L_0x04ee
            r32.finish()
            goto L_0x04ee
        L_0x03ba:
            boolean r0 = r0.startsWith(r3)
            r1 = 6
            if (r0 == 0) goto L_0x03ca
            java.lang.String r0 = r11.substring(r1)
            java.lang.String r0 = r0.trim()
            goto L_0x03d4
        L_0x03ca:
            r0 = 13
            java.lang.String r0 = r11.substring(r0)
            java.lang.String r0 = r0.trim()
        L_0x03d4:
            boolean r2 = r0.equals(r15)
            if (r2 != 0) goto L_0x04ee
            int r2 = r0.indexOf(r7)
            if (r2 <= 0) goto L_0x03fd
            java.lang.String r4 = "?body="
            int r4 = r0.indexOf(r4)
            if (r4 == r9) goto L_0x03f2
            int r4 = r4 + r1
            java.lang.String r1 = r0.substring(r4)
            java.lang.String r1 = r1.trim()
            goto L_0x03f3
        L_0x03f2:
            r1 = r15
        L_0x03f3:
            r4 = 0
            java.lang.String r0 = r0.substring(r4, r2)
            java.lang.String r0 = r0.trim()
            goto L_0x03ff
        L_0x03fd:
            r4 = 0
            r1 = r15
        L_0x03ff:
            boolean r2 = r0.endsWith(r5)
            if (r2 == 0) goto L_0x040f
            int r2 = r0.length()
            r5 = 1
            int r2 = r2 - r5
            java.lang.String r0 = r0.substring(r4, r2)
        L_0x040f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r6, r0)
            boolean r0 = r1.equals(r15)
            if (r0 != 0) goto L_0x0434
            java.lang.String r1 = java.net.URLDecoder.decode(r1, r8)     // Catch:{ Exception -> 0x042e }
        L_0x042e:
            java.lang.String r0 = "sms_body"
            r2.putExtra(r0, r1)
        L_0x0434:
            r10.startActivity(r2)     // Catch:{ Exception -> 0x0439 }
            goto L_0x04ee
        L_0x0439:
            goto L_0x04ee
        L_0x043c:
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x044c
            r0 = 7
            java.lang.String r0 = r11.substring(r0)
            java.lang.String r0 = r0.trim()
            goto L_0x0456
        L_0x044c:
            r0 = 14
            java.lang.String r0 = r11.substring(r0)
            java.lang.String r0 = r0.trim()
        L_0x0456:
            boolean r1 = r0.equals(r15)
            if (r1 != 0) goto L_0x04ee
            int r1 = r0.indexOf(r7)
            if (r1 <= 0) goto L_0x049f
            java.lang.String r2 = "?subject="
            int r2 = r0.indexOf(r2)
            if (r2 == r9) goto L_0x0493
            int r2 = r2 + 9
            java.lang.String r2 = r0.substring(r2)
            java.lang.String r2 = r2.trim()
            java.lang.String r3 = "&body="
            int r3 = r2.indexOf(r3)
            if (r3 == r9) goto L_0x0490
            int r4 = r3 + 6
            java.lang.String r4 = r2.substring(r4)
            java.lang.String r4 = r4.trim()
            r7 = 0
            java.lang.String r2 = r2.substring(r7, r3)
            java.lang.String r2 = r2.trim()
            goto L_0x0496
        L_0x0490:
            r7 = 0
            r4 = r15
            goto L_0x0496
        L_0x0493:
            r7 = 0
            r2 = r15
            r4 = r2
        L_0x0496:
            java.lang.String r0 = r0.substring(r7, r1)
            java.lang.String r0 = r0.trim()
            goto L_0x04a2
        L_0x049f:
            r7 = 0
            r2 = r15
            r4 = r2
        L_0x04a2:
            boolean r1 = r0.endsWith(r5)
            if (r1 == 0) goto L_0x04b2
            int r1 = r0.length()
            r3 = 1
            int r1 = r1 - r3
            java.lang.String r0 = r0.substring(r7, r1)
        L_0x04b2:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "mailto"
            r5 = 0
            android.net.Uri r0 = android.net.Uri.fromParts(r3, r0, r5)
            r1.<init>(r6, r0)
            boolean r0 = r2.equals(r15)
            if (r0 != 0) goto L_0x04cd
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r8)     // Catch:{ Exception -> 0x04c8 }
        L_0x04c8:
            java.lang.String r0 = "android.intent.extra.SUBJECT"
            r1.putExtra(r0, r2)
        L_0x04cd:
            boolean r0 = r4.equals(r15)
            if (r0 != 0) goto L_0x04dc
            java.lang.String r4 = java.net.URLDecoder.decode(r4, r8)     // Catch:{ Exception -> 0x04d7 }
        L_0x04d7:
            java.lang.String r0 = "android.intent.extra.TEXT"
            r1.putExtra(r0, r4)
        L_0x04dc:
            android.content.res.Resources r0 = r32.getResources()
            r2 = 2131886352(0x7f120110, float:1.940728E38)
            java.lang.String r0 = r0.getString(r2)
            android.content.Intent r0 = android.content.Intent.createChooser(r1, r0)
            r10.startActivity(r0)
        L_0x04ee:
            r13 = 1
            goto L_0x0530
        L_0x04f0:
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x04fc
            r0 = 4
            java.lang.String r0 = r11.substring(r0)
            goto L_0x0502
        L_0x04fc:
            r0 = 11
            java.lang.String r0 = r11.substring(r0)
        L_0x0502:
            boolean r1 = r0.endsWith(r5)
            if (r1 == 0) goto L_0x0514
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            r4 = 0
            java.lang.String r0 = r0.substring(r4, r1)
            goto L_0x0515
        L_0x0514:
            r2 = 1
        L_0x0515:
            android.content.Intent r1 = new android.content.Intent
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r3 = "android.intent.action.DIAL"
            r1.<init>(r3, r0)
            r10.startActivity(r1)     // Catch:{ Exception -> 0x0439 }
            goto L_0x04ee
        L_0x0530:
            if (r13 != 0) goto L_0x0540
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.t_url> r1 = stikerwap.appdys.t_url.class
            r0.<init>(r10, r1)
            r0.putExtra(r12, r11)
            r1 = 0
            r10.startActivityForResult(r0, r1)
        L_0x0540:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_and.tratar_url(java.lang.String):void");
    }

    private void tratar_tv(TextView textView, String str, int i, int i2, int i3, int i4, String str2, int i5, int i6, boolean z) {
        Typeface typeface;
        int i7;
        int i8;
        TextView textView2 = textView;
        String str3 = str;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        String str4 = str2;
        int i13 = i5;
        if (i9 == 0) {
            textView2.setGravity(8388611);
            if (getResources().getBoolean(R.bool.es_rtl)) {
                textView2.setTextDirection(4);
            }
        } else if (i9 == 1) {
            textView2.setGravity(17);
        }
        if (i12 == 1) {
            typeface = config.tf_monospace;
        } else if (i12 == 2) {
            typeface = config.tf_sans_serif;
        } else if (i12 == 3) {
            typeface = config.tf_serif;
        } else {
            typeface = Typeface.DEFAULT;
        }
        if (i10 == 1 && i11 == 1) {
            textView2.setTypeface(Typeface.create(typeface, 3));
        } else if (i10 == 1 && i11 == 0) {
            textView2.setTypeface(Typeface.create(typeface, 1));
        } else if (i10 == 0 && i11 == 1) {
            textView2.setTypeface(Typeface.create(typeface, 2));
        } else {
            textView2.setTypeface(typeface);
        }
        if (!str4.equals("")) {
            textView2.setTextColor(Color.parseColor("#" + str4));
            textView2.setLinkTextColor(Color.parseColor("#" + str4));
        }
        if (z) {
            if (str.toUpperCase().indexOf("<BR") == -1) {
                str3 = str3.replace("\n", "<br>");
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(str3.replace("<a href", "@AHREF_INI@").replace("<A HREF", "@AHREF_INI@").replace("</a>", "@AHREF_FIN@").replace("</A>", "@AHREF_FIN@").replace("</ a>", "@AHREF_FIN@").replace("</ A>", "@AHREF_FIN@")));
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            int indexOf = spannableStringBuilder2.indexOf("@AHREF_INI@");
            while (indexOf != -1) {
                spannableStringBuilder.replace(indexOf, indexOf + 11, "<a href");
                spannableStringBuilder2 = spannableStringBuilder.toString();
                indexOf = spannableStringBuilder2.indexOf("@AHREF_INI@");
            }
            for (int indexOf2 = spannableStringBuilder2.indexOf("@AHREF_FIN@"); indexOf2 != -1; indexOf2 = spannableStringBuilder.toString().indexOf("@AHREF_FIN@")) {
                spannableStringBuilder.replace(indexOf2, indexOf2 + 11, "</a>");
            }
            if (i13 == 1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 0);
            }
            String spannableStringBuilder3 = spannableStringBuilder.toString();
            String upperCase = spannableStringBuilder3.toUpperCase();
            int indexOf3 = upperCase.indexOf("<A HREF=");
            while (indexOf3 != -1) {
                int i14 = indexOf3 + 8;
                int i15 = i14 + 1;
                String substring = spannableStringBuilder3.substring(i14, i15);
                if (substring.equals("\"") || substring.equals("'")) {
                    i14 = i15;
                }
                if (substring.equals("\"")) {
                    i8 = spannableStringBuilder3.indexOf("\"", i14);
                } else if (substring.equals("'")) {
                    i8 = spannableStringBuilder3.indexOf("'", i14);
                } else {
                    i8 = spannableStringBuilder3.indexOf(">", i14);
                }
                if (i8 != -1) {
                    this.url_global = spannableStringBuilder3.substring(i14, i8).trim();
                    i8 = spannableStringBuilder3.indexOf(">", i8);
                    if (i8 != -1) {
                        int indexOf4 = upperCase.indexOf("</A>", i8);
                        int i16 = Integer.MAX_VALUE;
                        if (indexOf4 == -1) {
                            indexOf4 = Integer.MAX_VALUE;
                        }
                        int indexOf5 = upperCase.indexOf("</ A>", i8);
                        if (indexOf5 != -1) {
                            i16 = indexOf5;
                        }
                        if (indexOf4 == -1 && i16 == -1) {
                            i14 = i8;
                        } else {
                            int min = Math.min(indexOf4, i16);
                            int indexOf6 = spannableStringBuilder3.indexOf(">", min);
                            spannableStringBuilder.setSpan(new ClickableSpan() {
                                String url;

                                {
                                    this.url = t_and.this.url_global;
                                }

                                public void onClick(View view) {
                                    t_and.this.tratar_url(this.url);
                                }
                            }, i8, min, 33);
                            int i17 = indexOf6 + 1;
                            spannableStringBuilder.delete(min, i17);
                            int i18 = min - (i17 - min);
                            int i19 = i8 + 1;
                            spannableStringBuilder.delete(indexOf3, i19);
                            int i20 = i18 - (i19 - indexOf3);
                            String spannableStringBuilder4 = spannableStringBuilder.toString();
                            i14 = i8;
                            i8 = i20;
                            spannableStringBuilder3 = spannableStringBuilder4;
                            upperCase = spannableStringBuilder4.toUpperCase();
                        }
                    }
                }
                if (i8 == -1) {
                    i8 = i14;
                }
                indexOf3 = upperCase.indexOf("<A HREF=", i8);
            }
            textView2.setText(spannableStringBuilder);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            i7 = 0;
        } else if (i13 == 1) {
            SpannableString spannableString = new SpannableString(str3);
            i7 = 0;
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            textView2.setText(spannableString);
        } else {
            i7 = 0;
            textView.setText(str);
        }
        if (i6 != 0) {
            textView2.setTextSize(i7, textView.getTextSize() + ((float) (i6 * 2)));
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("fondo_v_act")) {
            try {
                this.globales.tratar_fondo((ImageView) findViewById(R.id.iv_fondo), Boolean.valueOf(this.globales.fondo_margen), this.globales.fondo_tipo);
                ((ImageView) findViewById(R.id.iv_fondo)).setVisibility(8);
                this.globales.file_to_iv("fondo", (ImageView) findViewById(R.id.iv_fondo));
                config.fade_in((ImageView) findViewById(R.id.iv_fondo));
            } catch (Exception unused) {
            }
        }
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
        if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
            abrir_secc(view);
        }
    }

    public void abrir_secc(View view) {
        if (view == null) {
            int i = this.ind_abrir_secc;
            if (i != -1) {
                this.globales.abrir_go(this, i);
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
        if ((config == null || !config.onActivityResult_glob(i, i2, intent, this)) && i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
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

    private class cargarfoto extends AsyncTask<String, Void, Byte> {
        String archivo_aux;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        private cargarfoto() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00da, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x00d6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                stikerwap.appdys.t_and r6 = stikerwap.appdys.t_and.this
                int[][] r6 = r6.coord_fotoacargar
                stikerwap.appdys.t_and r0 = stikerwap.appdys.t_and.this
                int r0 = r0.ind_fotoacargar
                r6 = r6[r0]
                r0 = 1
                r6 = r6[r0]
                java.lang.String r1 = ".png"
                if (r6 != 0) goto L_0x0052
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_SRV
                r6.append(r2)
                java.lang.String r2 = "/srv/imgs/and_items/fcab"
                r6.append(r2)
                stikerwap.appdys.t_and r2 = stikerwap.appdys.t_and.this
                int[] r2 = r2.id_fotoacargar
                stikerwap.appdys.t_and r3 = stikerwap.appdys.t_and.this
                int r3 = r3.ind_fotoacargar
                r2 = r2[r3]
                r6.append(r2)
                r6.append(r1)
                java.lang.String r6 = r6.toString()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "it_fcab"
                r2.<init>(r3)
                stikerwap.appdys.t_and r3 = stikerwap.appdys.t_and.this
                int[] r3 = r3.id_fotoacargar
                stikerwap.appdys.t_and r4 = stikerwap.appdys.t_and.this
                int r4 = r4.ind_fotoacargar
                r3 = r3[r4]
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r5.archivo_aux = r1
                goto L_0x0092
            L_0x0052:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN
                r6.append(r2)
                java.lang.String r2 = "/srv/imgs/and_items/f"
                r6.append(r2)
                stikerwap.appdys.t_and r2 = stikerwap.appdys.t_and.this
                int[] r2 = r2.id_fotoacargar
                stikerwap.appdys.t_and r3 = stikerwap.appdys.t_and.this
                int r3 = r3.ind_fotoacargar
                r2 = r2[r3]
                r6.append(r2)
                r6.append(r1)
                java.lang.String r6 = r6.toString()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "it_f"
                r2.<init>(r3)
                stikerwap.appdys.t_and r3 = stikerwap.appdys.t_and.this
                int[] r3 = r3.id_fotoacargar
                stikerwap.appdys.t_and r4 = stikerwap.appdys.t_and.this
                int r4 = r4.ind_fotoacargar
                r3 = r3[r4]
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r5.archivo_aux = r1
            L_0x0092:
                r1 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00e0 }
                r2.<init>(r6)     // Catch:{ MalformedURLException -> 0x00e0 }
                java.net.URLConnection r6 = r2.openConnection()     // Catch:{ IOException -> 0x00db }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x00db }
                r6.setDoInput(r0)     // Catch:{ IOException -> 0x00db }
                r0 = 5000(0x1388, float:7.006E-42)
                r6.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00db }
                r0 = 7000(0x1b58, float:9.809E-42)
                r6.setReadTimeout(r0)     // Catch:{ IOException -> 0x00db }
                r6.connect()     // Catch:{ IOException -> 0x00db }
                java.io.InputStream r6 = r6.getInputStream()     // Catch:{ IOException -> 0x00db }
                stikerwap.appdys.t_and r0 = stikerwap.appdys.t_and.this     // Catch:{ IOException -> 0x00db }
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ IOException -> 0x00db }
                r0.bm_foto = r6     // Catch:{ IOException -> 0x00db }
                stikerwap.appdys.t_and r6 = stikerwap.appdys.t_and.this     // Catch:{ Exception -> 0x00d6 }
                java.lang.String r0 = r5.archivo_aux     // Catch:{ Exception -> 0x00d6 }
                r2 = 0
                java.io.FileOutputStream r6 = r6.openFileOutput(r0, r2)     // Catch:{ Exception -> 0x00d6 }
                stikerwap.appdys.t_and r0 = stikerwap.appdys.t_and.this     // Catch:{ Exception -> 0x00d6 }
                android.graphics.Bitmap r0 = r0.bm_foto     // Catch:{ Exception -> 0x00d6 }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00d6 }
                r4 = 100
                r0.compress(r3, r4, r6)     // Catch:{ Exception -> 0x00d6 }
                r6.close()     // Catch:{ Exception -> 0x00d6 }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r2)
                return r6
            L_0x00d6:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r1)     // Catch:{ IOException -> 0x00db }
                return r6
            L_0x00db:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r1)
                return r6
            L_0x00e0:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_and.cargarfoto.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            int i;
            if (b.byteValue() == 0) {
                int i2 = t_and.this.coord_fotoacargar[t_and.this.ind_fotoacargar][0];
                int i3 = t_and.this.coord_fotoacargar[t_and.this.ind_fotoacargar][1];
                int[] file_to_iv = t_and.this.globales.file_to_iv(this.archivo_aux, t_and.this.iv_fotoacargar[t_and.this.ind_fotoacargar]);
                if (i3 > 0 && (i = file_to_iv[0]) > 0) {
                    if (i > t_and.this.w_max) {
                        file_to_iv[1] = (file_to_iv[1] * t_and.this.w_max) / file_to_iv[0];
                        file_to_iv[0] = t_and.this.w_max;
                    }
                    t_and.this.iv_fotoacargar[t_and.this.ind_fotoacargar].getLayoutParams().width = (int) ((((float) file_to_iv[0]) * t_and.this.scale) + 0.5f);
                    t_and.this.iv_fotoacargar[t_and.this.ind_fotoacargar].getLayoutParams().height = (int) ((((float) file_to_iv[1]) * t_and.this.scale) + 0.5f);
                }
                t_and.this.pb_fotoacargar[t_and.this.ind_fotoacargar].setVisibility(8);
                config.fade_in(t_and.this.iv_fotoacargar[t_and.this.ind_fotoacargar]);
                SharedPreferences.Editor edit = t_and.this.settings.edit();
                if (i3 == 0) {
                    edit.putInt("it" + t_and.this.s.and_items_a[i2].id + "_fcab_modif", 0);
                } else {
                    edit.putInt("it_f" + t_and.this.id_fotoacargar[t_and.this.ind_fotoacargar] + "_modif", 0);
                }
                edit.commit();
                if (i3 == 0) {
                    t_and.this.s.and_items_a[i2].fcab_modif = 0;
                } else {
                    t_and.this.s.and_items_a[i2].fotos_a[i3 - 1][1] = 0;
                }
            }
            t_and.this.ind_fotoacargar++;
            if (t_and.this.ind_fotoacargar < t_and.this.n_fotoacargar) {
                new cargarfoto().execute(new String[0]);
            }
        }
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
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
                if (!t_and.this.globales.admob_rew_failed(context, t_and.this.mAd_appnext)) {
                    t_and.this.dialog_cargando.cancel();
                    t_and t_and = t_and.this;
                    t_and.abrir_secc(t_and.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_and.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_and.this.abrir_secc(t_and.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_and.this.mAd_visto) {
                            t_and.this.abrir_secc(t_and.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_and.this.mAd_visto = true;
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
                if (t_and.this.mAd_visto) {
                    t_and t_and = t_and.this;
                    t_and.abrir_secc(t_and.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
