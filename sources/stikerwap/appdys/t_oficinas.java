package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
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
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import java.io.File;

public class t_oficinas extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_foto;
    int[][] coord_fotoacargar;
    Bundle extras;
    File file_global;
    config globales;
    int[] id_fotoacargar;
    int ind_fotoacargar;
    ImageView[] iv_fotoacargar;
    boolean mAd_visto = false;
    ListView mDrawerList;
    int n_fotoacargar;
    Oficina o;
    ProgressBar[] pb_fotoacargar;
    SharedPreferences settings;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:208:0x093b  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0ae6  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0bb9  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0c85  */
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
            java.lang.String r2 = r2.c_ir_ofic
            java.lang.String r3 = "FFFFFFFF"
            java.lang.String r2 = stikerwap.appdys.config.aplicar_color_dialog(r3, r2)
            r0.cbtn = r2
            android.content.Intent r2 = r17.getIntent()
            android.os.Bundle r2 = r2.getExtras()
            r0.extras = r2
            java.lang.String r3 = "es_root"
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L_0x004a
            if (r2 == 0) goto L_0x0046
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0046
            android.os.Bundle r2 = r0.extras
            boolean r2 = r2.getBoolean(r3, r5)
            if (r2 == 0) goto L_0x0046
            r2 = 1
            goto L_0x0047
        L_0x0046:
            r2 = 0
        L_0x0047:
            r0.es_root = r2
            goto L_0x005b
        L_0x004a:
            boolean r2 = r1.containsKey(r3)
            if (r2 == 0) goto L_0x0058
            boolean r2 = r1.getBoolean(r3, r5)
            if (r2 == 0) goto L_0x0058
            r2 = 1
            goto L_0x0059
        L_0x0058:
            r2 = 0
        L_0x0059:
            r0.es_root = r2
        L_0x005b:
            super.onCreate(r18)
            r2 = 2131558739(0x7f0d0153, float:1.8742802E38)
            r0.setContentView(r2)
            r17.incluir_menu_pre()
            stikerwap.appdys.config r2 = r0.globales
            r2.onCreate_global(r0, r5)
            java.lang.String r2 = "search"
            java.lang.Object r2 = r0.getSystemService(r2)
            android.app.SearchManager r2 = (android.app.SearchManager) r2
            stikerwap.appdys.t_oficinas$1 r3 = new stikerwap.appdys.t_oficinas$1
            r3.<init>()
            r2.setOnCancelListener(r3)
            stikerwap.appdys.t_oficinas$2 r3 = new stikerwap.appdys.t_oficinas$2
            r3.<init>()
            r2.setOnDismissListener(r3)
            if (r1 != 0) goto L_0x00a9
            stikerwap.appdys.config r2 = r0.globales
            android.os.Bundle r3 = r0.extras
            if (r3 == 0) goto L_0x0096
            java.lang.String r6 = "ad_entrar"
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L_0x0096
            r3 = 1
            goto L_0x0097
        L_0x0096:
            r3 = 0
        L_0x0097:
            android.os.Bundle r6 = r0.extras
            if (r6 == 0) goto L_0x00a5
            java.lang.String r7 = "fb_entrar"
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x00a5
            r6 = 1
            goto L_0x00a6
        L_0x00a5:
            r6 = 0
        L_0x00a6:
            r2.toca_int(r0, r3, r6)
        L_0x00a9:
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Anuncios r2 = r2.mostrar_banner(r0, r5)
            r0.anun = r2
            stikerwap.appdys.config r2 = r0.globales
            int r3 = r2.ind_secc_sel_2
            java.lang.String r6 = r0.cbtn
            r2.oncreate_popup(r0, r3, r6, r1)
            java.lang.String r1 = "sh"
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r5)
            r0.settings = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.fondo_v
            if (r1 <= 0) goto L_0x00ce
            android.content.SharedPreferences r1 = r0.settings
            r1.registerOnSharedPreferenceChangeListener(r0)
        L_0x00ce:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.fondo_v
            if (r1 <= 0) goto L_0x0109
            android.content.SharedPreferences r1 = r0.settings
            java.lang.String r2 = "fondo_v_act"
            int r1 = r1.getInt(r2, r5)
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fondo_v
            if (r1 != r2) goto L_0x0109
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x0109 }
            r2 = 2131362464(0x7f0a02a0, float:1.834471E38)
            android.view.View r3 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0109 }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x0109 }
            stikerwap.appdys.config r6 = r0.globales     // Catch:{ Exception -> 0x0109 }
            boolean r6 = r6.fondo_margen     // Catch:{ Exception -> 0x0109 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0109 }
            stikerwap.appdys.config r7 = r0.globales     // Catch:{ Exception -> 0x0109 }
            int r7 = r7.fondo_tipo     // Catch:{ Exception -> 0x0109 }
            r1.tratar_fondo(r3, r6, r7)     // Catch:{ Exception -> 0x0109 }
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x0109 }
            java.lang.String r3 = "fondo"
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0109 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0109 }
            r1.file_to_iv(r3, r2)     // Catch:{ Exception -> 0x0109 }
        L_0x0109:
            r1 = 2131362627(0x7f0a0343, float:1.834504E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            android.view.WindowManager r2 = r17.getWindowManager()
            android.view.Display r2 = r2.getDefaultDisplay()
            android.graphics.Point r3 = new android.graphics.Point
            r3.<init>()
            r2.getSize(r3)
            int r2 = r3.x
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r17)
            r0.n_fotoacargar = r5
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Oficina[] r6 = r6.oficinas_a
            int r6 = r6.length
            r7 = 4
            int r6 = r6 * 4
            int[] r6 = new int[r6]
            r0.id_fotoacargar = r6
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Oficina[] r6 = r6.oficinas_a
            int r6 = r6.length
            int r6 = r6 * 4
            android.widget.ImageView[] r6 = new android.widget.ImageView[r6]
            r0.iv_fotoacargar = r6
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Oficina[] r6 = r6.oficinas_a
            int r6 = r6.length
            int r6 = r6 * 4
            android.widget.ProgressBar[] r6 = new android.widget.ProgressBar[r6]
            r0.pb_fotoacargar = r6
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Oficina[] r6 = r6.oficinas_a
            int r6 = r6.length
            int r6 = r6 * 4
            r8 = 2
            int[] r9 = new int[r8]
            r9[r4] = r8
            r9[r5] = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r6, r9)
            int[][] r6 = (int[][]) r6
            r0.coord_fotoacargar = r6
            r6 = 0
        L_0x0165:
            stikerwap.appdys.config r9 = r0.globales
            stikerwap.appdys.Oficina[] r9 = r9.oficinas_a
            int r9 = r9.length
            r11 = 0
            java.lang.String r12 = "#"
            java.lang.String r13 = ""
            if (r6 >= r9) goto L_0x0cfb
            stikerwap.appdys.config r9 = r0.globales
            stikerwap.appdys.Oficina[] r9 = r9.oficinas_a
            r9 = r9[r6]
            r0.o = r9
            android.content.res.Resources r9 = r17.getResources()
            android.util.DisplayMetrics r9 = r9.getDisplayMetrics()
            float r9 = r9.density
            r14 = 1140457472(0x43fa0000, float:500.0)
            float r9 = r9 * r14
            r15 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r15
            int r9 = (int) r9
            if (r2 >= r9) goto L_0x0195
            r9 = 2131558738(0x7f0d0152, float:1.87428E38)
            android.view.View r9 = r3.inflate(r9, r11)
            goto L_0x019c
        L_0x0195:
            r9 = 2131558737(0x7f0d0151, float:1.8742798E38)
            android.view.View r9 = r3.inflate(r9, r11)
        L_0x019c:
            r10 = 2131363473(0x7f0a0691, float:1.8346756E38)
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c_tit_ofic
            boolean r7 = r7.equals(r13)
            if (r7 != 0) goto L_0x01c6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r12)
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_tit_ofic
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r10.setTextColor(r7)
        L_0x01c6:
            stikerwap.appdys.Oficina r7 = r0.o
            java.lang.String r7 = r7.titulo
            r10.setText(r7)
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c_sep_ofic
            boolean r7 = r7.equals(r13)
            if (r7 != 0) goto L_0x01f5
            r7 = 2131363500(0x7f0a06ac, float:1.834681E38)
            android.view.View r7 = r9.findViewById(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_sep_ofic
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r7.setBackgroundColor(r8)
        L_0x01f5:
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c_ico_sep_ofic
            boolean r7 = r7.equals(r13)
            if (r7 != 0) goto L_0x022f
            android.content.res.Resources r7 = r17.getResources()
            r8 = 2131231433(0x7f0802c9, float:1.8078947E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_ico_sep_ofic
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r10 = android.graphics.PorterDuff.Mode.MULTIPLY
            r7.setColorFilter(r8, r10)
            r8 = 2131362360(0x7f0a0238, float:1.8344498E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r7)
        L_0x022f:
            stikerwap.appdys.Oficina r7 = r0.o
            java.lang.String r7 = r7.dir1
            boolean r7 = r7.equals(r13)
            if (r7 != 0) goto L_0x026f
            r7 = 2131363410(0x7f0a0652, float:1.8346628E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x0263
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_txt_ofic
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r7.setTextColor(r8)
        L_0x0263:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.dir1
            r7.setText(r8)
            r7.setVisibility(r5)
            r7 = 1
            goto L_0x0270
        L_0x026f:
            r7 = 0
        L_0x0270:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.dir2
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x02af
            r7 = 2131363411(0x7f0a0653, float:1.834663E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x02a4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_txt_ofic
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r7.setTextColor(r8)
        L_0x02a4:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.dir2
            r7.setText(r8)
            r7.setVisibility(r5)
            r7 = 1
        L_0x02af:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.cp
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x02be
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.cp
            goto L_0x02bf
        L_0x02be:
            r8 = r13
        L_0x02bf:
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.pob
            boolean r10 = r10.equals(r13)
            if (r10 != 0) goto L_0x02f3
            boolean r10 = r8.equals(r13)
            if (r10 != 0) goto L_0x02e0
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            java.lang.String r8 = " "
            r10.append(r8)
            java.lang.String r8 = r10.toString()
        L_0x02e0:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.pob
            r10.append(r8)
            java.lang.String r8 = r10.toString()
        L_0x02f3:
            boolean r10 = r8.equals(r13)
            if (r10 != 0) goto L_0x032a
            r7 = 2131363402(0x7f0a064a, float:1.8346612E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_txt_ofic
            boolean r10 = r10.equals(r13)
            if (r10 != 0) goto L_0x0323
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r12)
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_txt_ofic
            r10.append(r4)
            java.lang.String r4 = r10.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r7.setTextColor(r4)
        L_0x0323:
            r7.setText(r8)
            r7.setVisibility(r5)
            r7 = 1
        L_0x032a:
            stikerwap.appdys.Oficina r4 = r0.o
            java.lang.String r4 = r4.prov
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x0369
            r4 = 2131363460(0x7f0a0684, float:1.834673E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c_txt_ofic
            boolean r7 = r7.equals(r13)
            if (r7 != 0) goto L_0x035e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r12)
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r4.setTextColor(r7)
        L_0x035e:
            stikerwap.appdys.Oficina r7 = r0.o
            java.lang.String r7 = r7.prov
            r4.setText(r7)
            r4.setVisibility(r5)
            r7 = 1
        L_0x0369:
            stikerwap.appdys.Oficina r4 = r0.o
            java.lang.String r4 = r4.tel1
            boolean r4 = r4.equals(r13)
            r8 = 2131231715(0x7f0803e3, float:1.8079519E38)
            r10 = 2131231424(0x7f0802c0, float:1.8078929E38)
            if (r4 != 0) goto L_0x042b
            r4 = 2131363470(0x7f0a068e, float:1.834675E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_txt_ofic
            boolean r15 = r15.equals(r13)
            if (r15 != 0) goto L_0x03a3
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r12)
            stikerwap.appdys.config r14 = r0.globales
            java.lang.String r14 = r14.c_txt_ofic
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            int r14 = android.graphics.Color.parseColor(r14)
            r4.setTextColor(r14)
        L_0x03a3:
            stikerwap.appdys.Oficina r14 = r0.o
            java.lang.String r14 = r14.tel1
            r4.setText(r14)
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x03e1
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r8)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_icos_ofic
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            int r14 = android.graphics.Color.parseColor(r14)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r14, r15)
            r14 = 2131362502(0x7f0a02c6, float:1.8344786E38)
            android.view.View r14 = r9.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r14.setImageDrawable(r4)
        L_0x03e1:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_ir_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x0418
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r10)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_ir_ofic
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            int r14 = android.graphics.Color.parseColor(r14)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r14, r15)
            r14 = 2131362503(0x7f0a02c7, float:1.8344788E38)
            android.view.View r14 = r9.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r14.setImageDrawable(r4)
        L_0x0418:
            r4 = 2131362634(0x7f0a034a, float:1.8345054E38)
            android.view.View r14 = r9.findViewById(r4)
            r14.setOnClickListener(r0)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
            r4 = 1
            goto L_0x042c
        L_0x042b:
            r4 = 0
        L_0x042c:
            stikerwap.appdys.Oficina r14 = r0.o
            java.lang.String r14 = r14.tel2
            boolean r14 = r14.equals(r13)
            if (r14 != 0) goto L_0x04e7
            r4 = 2131363471(0x7f0a068f, float:1.8346752E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r14 = r0.globales
            java.lang.String r14 = r14.c_txt_ofic
            boolean r14 = r14.equals(r13)
            if (r14 != 0) goto L_0x0460
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_txt_ofic
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            int r14 = android.graphics.Color.parseColor(r14)
            r4.setTextColor(r14)
        L_0x0460:
            stikerwap.appdys.Oficina r14 = r0.o
            java.lang.String r14 = r14.tel2
            r4.setText(r14)
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x049e
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r14 = r0.globales
            java.lang.String r14 = r14.c_icos_ofic
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r14)
            r8 = 2131362504(0x7f0a02c8, float:1.834479E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x049e:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_ir_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x04d5
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r14 = r0.globales
            java.lang.String r14 = r14.c_ir_ofic
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r14)
            r8 = 2131362505(0x7f0a02c9, float:1.8344792E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x04d5:
            r4 = 2131362635(0x7f0a034b, float:1.8345056E38)
            android.view.View r8 = r9.findViewById(r4)
            r8.setOnClickListener(r0)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
            r4 = 1
        L_0x04e7:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.horario
            boolean r8 = r8.equals(r13)
            java.lang.String r14 = "FF000000"
            if (r8 != 0) goto L_0x058b
            r4 = 2131363427(0x7f0a0663, float:1.8346663E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x051d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_txt_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r4.setTextColor(r8)
        L_0x051d:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.horario
            r4.setText(r8)
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x0580
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0550
            r4 = 2131362468(0x7f0a02a4, float:1.8344717E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.res.Resources r8 = r17.getResources()
            r15 = 2131231677(0x7f0803bd, float:1.8079442E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r15)
            r4.setImageDrawable(r8)
            goto L_0x0580
        L_0x0550:
            android.content.res.Resources r4 = r17.getResources()
            r8 = 2131231676(0x7f0803bc, float:1.807944E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_icos_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r15)
            r8 = 2131362468(0x7f0a02a4, float:1.8344717E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x0580:
            r4 = 2131362607(0x7f0a032f, float:1.8345E38)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
            r4 = 1
        L_0x058b:
            stikerwap.appdys.Oficina r8 = r0.o
            boolean r8 = r8.chat
            if (r8 == 0) goto L_0x064d
            r4 = 2131363392(0x7f0a0640, float:1.8346592E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x05bb
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_txt_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r4.setTextColor(r8)
        L_0x05bb:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x05f5
            android.content.res.Resources r4 = r17.getResources()
            r8 = 2131231014(0x7f080126, float:1.8078097E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_icos_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r15)
            r8 = 2131362442(0x7f0a028a, float:1.8344665E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x05f5:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_ir_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x062c
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_ir_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r15)
            r8 = 2131362441(0x7f0a0289, float:1.8344663E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x062c:
            r4 = 2131362576(0x7f0a0310, float:1.8344936E38)
            android.view.View r8 = r9.findViewById(r4)
            stikerwap.appdys.Oficina r15 = r0.o
            int r15 = r15.id
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r8.setTag(r15)
            android.view.View r8 = r9.findViewById(r4)
            r8.setOnClickListener(r0)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
            r4 = 1
        L_0x064d:
            stikerwap.appdys.Oficina r8 = r0.o
            boolean r8 = r8.t_email
            if (r8 == 0) goto L_0x0751
            r4 = 2131363412(0x7f0a0654, float:1.8346632E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x067d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_txt_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r4.setTextColor(r8)
        L_0x067d:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.email
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x068f
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.email
            r4.setText(r8)
            goto L_0x069d
        L_0x068f:
            android.content.res.Resources r8 = r17.getResources()
            r15 = 2131886352(0x7f120110, float:1.940728E38)
            java.lang.String r8 = r8.getString(r15)
            r4.setText(r8)
        L_0x069d:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x06f9
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x06c9
            r4 = 2131362447(0x7f0a028f, float:1.8344675E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.res.Resources r8 = r17.getResources()
            r15 = 2131231071(0x7f08015f, float:1.8078213E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r15)
            r4.setImageDrawable(r8)
            goto L_0x06f9
        L_0x06c9:
            android.content.res.Resources r4 = r17.getResources()
            r8 = 2131231069(0x7f08015d, float:1.8078209E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_icos_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r15)
            r8 = 2131362447(0x7f0a028f, float:1.8344675E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x06f9:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_ir_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x0730
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_ir_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r15)
            r8 = 2131362448(0x7f0a0290, float:1.8344677E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x0730:
            r4 = 2131362593(0x7f0a0321, float:1.834497E38)
            android.view.View r8 = r9.findViewById(r4)
            stikerwap.appdys.Oficina r15 = r0.o
            int r15 = r15.id
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r8.setTag(r15)
            android.view.View r8 = r9.findViewById(r4)
            r8.setOnClickListener(r0)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
            r4 = 1
        L_0x0751:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.web
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x0842
            r4 = 2131363478(0x7f0a0696, float:1.8346766E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_txt_ofic
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x0785
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_txt_ofic
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            r4.setTextColor(r8)
        L_0x0785:
            stikerwap.appdys.Oficina r8 = r0.o
            java.lang.String r8 = r8.web
            r4.setText(r8)
            stikerwap.appdys.Oficina r8 = r0.o
            boolean r8 = r8.web_popup
            if (r8 == 0) goto L_0x0795
            java.lang.String r8 = "1"
            goto L_0x0797
        L_0x0795:
            java.lang.String r8 = "0"
        L_0x0797:
            r4.setTag(r8)
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x07f6
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_icos_ofic
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x07c6
            r4 = 2131362511(0x7f0a02cf, float:1.8344805E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.res.Resources r8 = r17.getResources()
            r14 = 2131231917(0x7f0804ad, float:1.8079929E38)
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r14)
            r4.setImageDrawable(r8)
            goto L_0x07f6
        L_0x07c6:
            android.content.res.Resources r4 = r17.getResources()
            r8 = 2131231918(0x7f0804ae, float:1.807993E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r14 = r0.globales
            java.lang.String r14 = r14.c_icos_ofic
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r14)
            r8 = 2131362511(0x7f0a02cf, float:1.8344805E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x07f6:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_ir_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x082d
            android.content.res.Resources r4 = r17.getResources()
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_ir_ofic
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.PorterDuff$Mode r10 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r8, r10)
            r8 = 2131362512(0x7f0a02d0, float:1.8344807E38)
            android.view.View r8 = r9.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r8.setImageDrawable(r4)
        L_0x082d:
            r4 = 2131362640(0x7f0a0350, float:1.8345066E38)
            android.view.View r4 = r9.findViewById(r4)
            r4.setOnClickListener(r0)
            r4 = 2131362640(0x7f0a0350, float:1.8345066E38)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
            r4 = 1
        L_0x0842:
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.x
            if (r8 == 0) goto L_0x08d2
            r7 = 2131361982(0x7f0a00be, float:1.8343732E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            stikerwap.appdys.t_oficinas$datosMapa r8 = new stikerwap.appdys.t_oficinas$datosMapa
            r8.<init>()
            stikerwap.appdys.Oficina r10 = r0.o
            int r10 = r10.x
            r8.x = r10
            stikerwap.appdys.Oficina r10 = r0.o
            int r10 = r10.y
            r8.y = r10
            stikerwap.appdys.Oficina r10 = r0.o
            int r10 = r10.z
            r8.z = r10
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.titulo
            r8.titulo = r10
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.dir1
            r8.dir1 = r10
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.dir2
            r8.dir2 = r10
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.cp
            r8.cp = r10
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.pob
            r8.pob = r10
            stikerwap.appdys.Oficina r10 = r0.o
            java.lang.String r10 = r10.prov
            r8.prov = r10
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_ir_ofic
            boolean r10 = r10.equals(r13)
            if (r10 != 0) goto L_0x08c8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r12)
            stikerwap.appdys.config r11 = r0.globales
            java.lang.String r11 = r11.c_ir_ofic
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            int r10 = android.graphics.Color.parseColor(r10)
            r7.setBackgroundColor(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r12)
            stikerwap.appdys.config r11 = r0.globales
            java.lang.String r11 = r11.c_ir_ofic
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            boolean r10 = stikerwap.appdys.config.esClaro(r10)
            if (r10 == 0) goto L_0x08c8
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r7.setTextColor(r10)
        L_0x08c8:
            r7.setTag(r8)
            r7.setOnClickListener(r0)
            r7.setVisibility(r5)
            r7 = 1
        L_0x08d2:
            if (r7 == 0) goto L_0x08de
            r8 = 2131362590(0x7f0a031e, float:1.8344965E38)
            android.view.View r8 = r9.findViewById(r8)
            r8.setVisibility(r5)
        L_0x08de:
            if (r4 == 0) goto L_0x08ea
            r8 = 2131362582(0x7f0a0316, float:1.8344949E38)
            android.view.View r8 = r9.findViewById(r8)
            r8.setVisibility(r5)
        L_0x08ea:
            if (r7 == 0) goto L_0x090c
            if (r4 == 0) goto L_0x090c
            android.content.res.Resources r4 = r17.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            float r4 = r4.density
            r7 = 1140457472(0x43fa0000, float:500.0)
            float r4 = r4 * r7
            r7 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r7
            int r4 = (int) r4
            if (r2 >= r4) goto L_0x090c
            r4 = 2131363501(0x7f0a06ad, float:1.8346813E38)
            android.view.View r4 = r9.findViewById(r4)
            r4.setVisibility(r5)
        L_0x090c:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c1_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x092e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r12)
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c1_ofic
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            boolean r4 = stikerwap.appdys.config.esClaro(r4)
            if (r4 == 0) goto L_0x092e
            r4 = 1
            goto L_0x092f
        L_0x092e:
            r4 = 0
        L_0x092f:
            stikerwap.appdys.Oficina r7 = r0.o
            int r7 = r7.nfotos
            r8 = 20
            java.lang.String r10 = ".png"
            java.lang.String r11 = "o_f"
            if (r7 <= 0) goto L_0x0a0c
            r7 = 2131362601(0x7f0a0329, float:1.8344987E38)
            android.view.View r7 = r9.findViewById(r7)
            r7.setVisibility(r5)
            r7 = 2131362491(0x7f0a02bb, float:1.8344764E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            stikerwap.appdys.Oficina r14 = r0.o
            boolean r14 = r14.fotos_z
            if (r14 == 0) goto L_0x0975
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r11)
            stikerwap.appdys.Oficina r15 = r0.o
            int r15 = r15.f1_id
            r14.append(r15)
            r14.append(r10)
            java.lang.String r14 = r14.toString()
            java.io.File r14 = r0.getFileStreamPath(r14)
            r0.file_global = r14
            stikerwap.appdys.t_oficinas$3 r14 = new stikerwap.appdys.t_oficinas$3
            r14.<init>()
            r7.setOnClickListener(r14)
        L_0x0975:
            if (r4 == 0) goto L_0x0981
            r14 = 2131363018(0x7f0a04ca, float:1.8345833E38)
            android.view.View r14 = r9.findViewById(r14)
            android.widget.ProgressBar r14 = (android.widget.ProgressBar) r14
            goto L_0x098a
        L_0x0981:
            r14 = 2131363017(0x7f0a04c9, float:1.834583E38)
            android.view.View r14 = r9.findViewById(r14)
            android.widget.ProgressBar r14 = (android.widget.ProgressBar) r14
        L_0x098a:
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 <= r8) goto L_0x0995
            stikerwap.appdys.config r15 = r0.globales
            java.lang.String r15 = r15.c_ir_ofic
            stikerwap.appdys.config.progress_color(r14, r15)
        L_0x0995:
            stikerwap.appdys.Oficina r15 = r0.o
            boolean r15 = r15.f1_modif
            if (r15 == 0) goto L_0x09c0
            int[] r15 = r0.id_fotoacargar
            int r8 = r0.n_fotoacargar
            stikerwap.appdys.Oficina r5 = r0.o
            int r5 = r5.f1_id
            r15[r8] = r5
            android.widget.ImageView[] r5 = r0.iv_fotoacargar
            int r8 = r0.n_fotoacargar
            r5[r8] = r7
            android.widget.ProgressBar[] r5 = r0.pb_fotoacargar
            r5[r8] = r14
            int[][] r5 = r0.coord_fotoacargar
            r5 = r5[r8]
            r7 = 0
            r5[r7] = r6
            r15 = 1
            r5[r15] = r15
            int r8 = r8 + r15
            r0.n_fotoacargar = r8
            r14.setVisibility(r7)
            goto L_0x0a0c
        L_0x09c0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f1_id
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.io.File r8 = r0.getFileStreamPath(r8)
            boolean r14 = r8.exists()
            if (r14 != 0) goto L_0x09f0
            java.io.File r5 = r0.getFileStreamPath(r5)
            r5.renameTo(r8)
        L_0x09f0:
            stikerwap.appdys.config r5 = r0.globales
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            stikerwap.appdys.Oficina r14 = r0.o
            int r14 = r14.f1_id
            r8.append(r14)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r5.file_to_iv(r8, r7)
            r5 = 0
            r7.setVisibility(r5)
        L_0x0a0c:
            stikerwap.appdys.Oficina r5 = r0.o
            int r5 = r5.nfotos
            r7 = 1
            if (r5 <= r7) goto L_0x0adf
            r5 = 2131362492(0x7f0a02bc, float:1.8344766E38)
            android.view.View r5 = r9.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            stikerwap.appdys.Oficina r7 = r0.o
            boolean r7 = r7.fotos_z
            if (r7 == 0) goto L_0x0a43
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f2_id
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            java.io.File r7 = r0.getFileStreamPath(r7)
            r0.file_global = r7
            stikerwap.appdys.t_oficinas$4 r7 = new stikerwap.appdys.t_oficinas$4
            r7.<init>()
            r5.setOnClickListener(r7)
        L_0x0a43:
            if (r4 == 0) goto L_0x0a4f
            r7 = 2131363020(0x7f0a04cc, float:1.8345837E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            goto L_0x0a58
        L_0x0a4f:
            r7 = 2131363019(0x7f0a04cb, float:1.8345835E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
        L_0x0a58:
            int r8 = android.os.Build.VERSION.SDK_INT
            r14 = 20
            if (r8 <= r14) goto L_0x0a65
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_ir_ofic
            stikerwap.appdys.config.progress_color(r7, r8)
        L_0x0a65:
            stikerwap.appdys.Oficina r8 = r0.o
            boolean r8 = r8.f2_modif
            if (r8 == 0) goto L_0x0a93
            int[] r8 = r0.id_fotoacargar
            int r14 = r0.n_fotoacargar
            stikerwap.appdys.Oficina r15 = r0.o
            int r15 = r15.f2_id
            r8[r14] = r15
            android.widget.ImageView[] r8 = r0.iv_fotoacargar
            int r14 = r0.n_fotoacargar
            r8[r14] = r5
            android.widget.ProgressBar[] r5 = r0.pb_fotoacargar
            r5[r14] = r7
            int[][] r5 = r0.coord_fotoacargar
            r5 = r5[r14]
            r8 = 0
            r5[r8] = r6
            r15 = 2
            r16 = 1
            r5[r16] = r15
            int r14 = r14 + 1
            r0.n_fotoacargar = r14
            r7.setVisibility(r8)
            goto L_0x0adf
        L_0x0a93:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f2_id
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.io.File r8 = r0.getFileStreamPath(r8)
            boolean r14 = r8.exists()
            if (r14 != 0) goto L_0x0ac3
            java.io.File r7 = r0.getFileStreamPath(r7)
            r7.renameTo(r8)
        L_0x0ac3:
            stikerwap.appdys.config r7 = r0.globales
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            stikerwap.appdys.Oficina r14 = r0.o
            int r14 = r14.f2_id
            r8.append(r14)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r7.file_to_iv(r8, r5)
            r7 = 0
            r5.setVisibility(r7)
        L_0x0adf:
            stikerwap.appdys.Oficina r5 = r0.o
            int r5 = r5.nfotos
            r7 = 2
            if (r5 <= r7) goto L_0x0bb2
            r5 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            android.view.View r5 = r9.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            stikerwap.appdys.Oficina r7 = r0.o
            boolean r7 = r7.fotos_z
            if (r7 == 0) goto L_0x0b16
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f3_id
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            java.io.File r7 = r0.getFileStreamPath(r7)
            r0.file_global = r7
            stikerwap.appdys.t_oficinas$5 r7 = new stikerwap.appdys.t_oficinas$5
            r7.<init>()
            r5.setOnClickListener(r7)
        L_0x0b16:
            if (r4 == 0) goto L_0x0b22
            r7 = 2131363022(0x7f0a04ce, float:1.8345841E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            goto L_0x0b2b
        L_0x0b22:
            r7 = 2131363021(0x7f0a04cd, float:1.834584E38)
            android.view.View r7 = r9.findViewById(r7)
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
        L_0x0b2b:
            int r8 = android.os.Build.VERSION.SDK_INT
            r14 = 20
            if (r8 <= r14) goto L_0x0b38
            stikerwap.appdys.config r8 = r0.globales
            java.lang.String r8 = r8.c_ir_ofic
            stikerwap.appdys.config.progress_color(r7, r8)
        L_0x0b38:
            stikerwap.appdys.Oficina r8 = r0.o
            boolean r8 = r8.f3_modif
            if (r8 == 0) goto L_0x0b66
            int[] r8 = r0.id_fotoacargar
            int r14 = r0.n_fotoacargar
            stikerwap.appdys.Oficina r15 = r0.o
            int r15 = r15.f3_id
            r8[r14] = r15
            android.widget.ImageView[] r8 = r0.iv_fotoacargar
            int r14 = r0.n_fotoacargar
            r8[r14] = r5
            android.widget.ProgressBar[] r5 = r0.pb_fotoacargar
            r5[r14] = r7
            int[][] r5 = r0.coord_fotoacargar
            r5 = r5[r14]
            r8 = 0
            r5[r8] = r6
            r15 = 3
            r16 = 1
            r5[r16] = r15
            int r14 = r14 + 1
            r0.n_fotoacargar = r14
            r7.setVisibility(r8)
            goto L_0x0bb2
        L_0x0b66:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f3_id
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.io.File r8 = r0.getFileStreamPath(r8)
            boolean r14 = r8.exists()
            if (r14 != 0) goto L_0x0b96
            java.io.File r7 = r0.getFileStreamPath(r7)
            r7.renameTo(r8)
        L_0x0b96:
            stikerwap.appdys.config r7 = r0.globales
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            stikerwap.appdys.Oficina r14 = r0.o
            int r14 = r14.f3_id
            r8.append(r14)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r7.file_to_iv(r8, r5)
            r7 = 0
            r5.setVisibility(r7)
        L_0x0bb2:
            stikerwap.appdys.Oficina r5 = r0.o
            int r5 = r5.nfotos
            r7 = 3
            if (r5 <= r7) goto L_0x0c85
            r5 = 2131362494(0x7f0a02be, float:1.834477E38)
            android.view.View r5 = r9.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            stikerwap.appdys.Oficina r7 = r0.o
            boolean r7 = r7.fotos_z
            if (r7 == 0) goto L_0x0be9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f4_id
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            java.io.File r7 = r0.getFileStreamPath(r7)
            r0.file_global = r7
            stikerwap.appdys.t_oficinas$6 r7 = new stikerwap.appdys.t_oficinas$6
            r7.<init>()
            r5.setOnClickListener(r7)
        L_0x0be9:
            if (r4 == 0) goto L_0x0bf5
            r4 = 2131363024(0x7f0a04d0, float:1.8345845E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            goto L_0x0bfe
        L_0x0bf5:
            r4 = 2131363023(0x7f0a04cf, float:1.8345843E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
        L_0x0bfe:
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 20
            if (r7 <= r8) goto L_0x0c0b
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c_ir_ofic
            stikerwap.appdys.config.progress_color(r4, r7)
        L_0x0c0b:
            stikerwap.appdys.Oficina r7 = r0.o
            boolean r7 = r7.f4_modif
            if (r7 == 0) goto L_0x0c37
            int[] r7 = r0.id_fotoacargar
            int r8 = r0.n_fotoacargar
            stikerwap.appdys.Oficina r10 = r0.o
            int r10 = r10.f4_id
            r7[r8] = r10
            android.widget.ImageView[] r7 = r0.iv_fotoacargar
            int r8 = r0.n_fotoacargar
            r7[r8] = r5
            android.widget.ProgressBar[] r5 = r0.pb_fotoacargar
            r5[r8] = r4
            int[][] r5 = r0.coord_fotoacargar
            r5 = r5[r8]
            r7 = 0
            r5[r7] = r6
            r10 = 1
            r14 = 4
            r5[r10] = r14
            int r8 = r8 + r10
            r0.n_fotoacargar = r8
            r4.setVisibility(r7)
            goto L_0x0c86
        L_0x0c37:
            r14 = 4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            stikerwap.appdys.Oficina r7 = r0.o
            int r7 = r7.f4_id
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            java.io.File r7 = r0.getFileStreamPath(r7)
            boolean r8 = r7.exists()
            if (r8 != 0) goto L_0x0c68
            java.io.File r4 = r0.getFileStreamPath(r4)
            r4.renameTo(r7)
        L_0x0c68:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r11)
            stikerwap.appdys.Oficina r8 = r0.o
            int r8 = r8.f4_id
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r4.file_to_iv(r7, r5)
            r4 = 0
            r5.setVisibility(r4)
            goto L_0x0c86
        L_0x0c85:
            r14 = 4
        L_0x0c86:
            stikerwap.appdys.config r4 = r0.globales
            int r4 = r4.c_perofic
            r5 = 1
            if (r4 != r5) goto L_0x0cf0
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c1_ofic
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x0cf0
            android.graphics.drawable.GradientDrawable r4 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r5 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r7 = 2
            int[] r8 = new int[r7]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c1_ofic
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r10 = 0
            r8[r10] = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r12)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c2_ofic
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            r10 = 1
            r8[r10] = r7
            r4.<init>(r5, r8)
            r9.setBackgroundDrawable(r4)
            r4 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r4 = r0.findViewById(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r12)
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c2_ofic
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            int r5 = android.graphics.Color.parseColor(r5)
            r4.setBackgroundColor(r5)
        L_0x0cf0:
            r1.addView(r9)
            int r6 = r6 + 1
            r4 = 1
            r5 = 0
            r7 = 4
            r8 = 2
            goto L_0x0165
        L_0x0cfb:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.c_perofic
            if (r1 != 0) goto L_0x0d4d
            stikerwap.appdys.config r1 = r0.globales
            java.lang.String r1 = r1.c1_ofic
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x0d4d
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r2 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r3 = 2
            int[] r3 = new int[r3]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r12)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c1_ofic
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r12)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c2_ofic
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r5 = 1
            r3[r5] = r4
            r1.<init>(r2, r3)
            r2 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setBackgroundDrawable(r1)
        L_0x0d4d:
            int r1 = r0.n_fotoacargar
            if (r1 <= 0) goto L_0x0d5e
            r1 = 0
            r0.ind_fotoacargar = r1
            stikerwap.appdys.t_oficinas$cargarfoto r2 = new stikerwap.appdys.t_oficinas$cargarfoto
            r2.<init>()
            java.lang.String[] r1 = new java.lang.String[r1]
            r2.execute(r1)
        L_0x0d5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_oficinas.onCreate(android.os.Bundle):void");
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
        if (view.getId() == R.id.ll_tel1) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((TextView) view.findViewById(R.id.tv_tel1)).getText())));
            } catch (Exception unused) {
            }
        } else if (view.getId() == R.id.ll_tel2) {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((TextView) view.findViewById(R.id.tv_tel2)).getText())));
        } else if (view.getId() == R.id.ll_chat) {
            startActivityForResult(new Intent(this, chat.class), 0);
        } else if (view.getId() == R.id.ll_email) {
            Intent intent = new Intent(this, contactar.class);
            intent.putExtra("idofic", (Integer) view.getTag());
            Bundle bundle = this.extras;
            if (bundle != null && bundle.containsKey("msg_predefinido")) {
                intent.putExtra("msg_predefinido", this.extras.getString("msg_predefinido"));
            }
            startActivityForResult(intent, 0);
        } else if (view.getId() == R.id.ll_url) {
            TextView textView = (TextView) view.findViewById(R.id.tv_url);
            String str = (String) textView.getText();
            if (textView.getTag().equals("1")) {
                this.globales.abrir_ext(this, str);
                return;
            }
            Intent intent2 = new Intent(this, t_url.class);
            intent2.putExtra("url", str);
            startActivityForResult(intent2, 0);
        } else if (view.getId() == R.id.btn_vermapa) {
            datosMapa datosmapa = (datosMapa) view.getTag();
            Intent intent3 = new Intent(this, t_mapa_web.class);
            intent3.putExtra("x", datosmapa.x);
            intent3.putExtra("y", datosmapa.y);
            intent3.putExtra("z", datosmapa.z);
            intent3.putExtra("titulo", datosmapa.titulo);
            intent3.putExtra("dir1", datosmapa.dir1);
            intent3.putExtra("dir2", datosmapa.dir2);
            intent3.putExtra("cp", datosmapa.cp);
            intent3.putExtra("pob", datosmapa.pob);
            intent3.putExtra("prov", datosmapa.prov);
            startActivityForResult(intent3, 0);
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
        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        private cargarfoto() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0087, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0083 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                java.lang.String r7 = ".png"
                java.lang.String r0 = "o_f"
                r1 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x008d }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x008d }
                r3.<init>()     // Catch:{ MalformedURLException -> 0x008d }
                java.lang.String r4 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x008d }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x008d }
                java.lang.String r4 = "/srv/imgs/ofics/f"
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x008d }
                stikerwap.appdys.t_oficinas r4 = stikerwap.appdys.t_oficinas.this     // Catch:{ MalformedURLException -> 0x008d }
                int[] r4 = r4.id_fotoacargar     // Catch:{ MalformedURLException -> 0x008d }
                stikerwap.appdys.t_oficinas r5 = stikerwap.appdys.t_oficinas.this     // Catch:{ MalformedURLException -> 0x008d }
                int r5 = r5.ind_fotoacargar     // Catch:{ MalformedURLException -> 0x008d }
                r4 = r4[r5]     // Catch:{ MalformedURLException -> 0x008d }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x008d }
                r3.append(r7)     // Catch:{ MalformedURLException -> 0x008d }
                java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x008d }
                r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x008d }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x0088 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0088 }
                r3 = 1
                r2.setDoInput(r3)     // Catch:{ IOException -> 0x0088 }
                r3 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0088 }
                r3 = 7000(0x1b58, float:9.809E-42)
                r2.setReadTimeout(r3)     // Catch:{ IOException -> 0x0088 }
                r2.connect()     // Catch:{ IOException -> 0x0088 }
                java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x0088 }
                stikerwap.appdys.t_oficinas r3 = stikerwap.appdys.t_oficinas.this     // Catch:{ IOException -> 0x0088 }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ IOException -> 0x0088 }
                r3.bm_foto = r2     // Catch:{ IOException -> 0x0088 }
                stikerwap.appdys.t_oficinas r2 = stikerwap.appdys.t_oficinas.this     // Catch:{ Exception -> 0x0083 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
                r3.<init>(r0)     // Catch:{ Exception -> 0x0083 }
                stikerwap.appdys.t_oficinas r0 = stikerwap.appdys.t_oficinas.this     // Catch:{ Exception -> 0x0083 }
                int[] r0 = r0.id_fotoacargar     // Catch:{ Exception -> 0x0083 }
                stikerwap.appdys.t_oficinas r4 = stikerwap.appdys.t_oficinas.this     // Catch:{ Exception -> 0x0083 }
                int r4 = r4.ind_fotoacargar     // Catch:{ Exception -> 0x0083 }
                r0 = r0[r4]     // Catch:{ Exception -> 0x0083 }
                r3.append(r0)     // Catch:{ Exception -> 0x0083 }
                r3.append(r7)     // Catch:{ Exception -> 0x0083 }
                java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0083 }
                r0 = 0
                java.io.FileOutputStream r7 = r2.openFileOutput(r7, r0)     // Catch:{ Exception -> 0x0083 }
                stikerwap.appdys.t_oficinas r2 = stikerwap.appdys.t_oficinas.this     // Catch:{ Exception -> 0x0083 }
                android.graphics.Bitmap r2 = r2.bm_foto     // Catch:{ Exception -> 0x0083 }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0083 }
                r4 = 100
                r2.compress(r3, r4, r7)     // Catch:{ Exception -> 0x0083 }
                r7.close()     // Catch:{ Exception -> 0x0083 }
                java.lang.Byte r7 = java.lang.Byte.valueOf(r0)
                return r7
            L_0x0083:
                java.lang.Byte r7 = java.lang.Byte.valueOf(r1)     // Catch:{ IOException -> 0x0088 }
                return r7
            L_0x0088:
                java.lang.Byte r7 = java.lang.Byte.valueOf(r1)
                return r7
            L_0x008d:
                java.lang.Byte r7 = java.lang.Byte.valueOf(r1)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_oficinas.cargarfoto.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (b.byteValue() == 0) {
                t_oficinas.this.iv_fotoacargar[t_oficinas.this.ind_fotoacargar].setImageBitmap(t_oficinas.this.bm_foto);
                t_oficinas.this.pb_fotoacargar[t_oficinas.this.ind_fotoacargar].setVisibility(8);
                config.fade_in(t_oficinas.this.iv_fotoacargar[t_oficinas.this.ind_fotoacargar]);
                SharedPreferences.Editor edit = t_oficinas.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit.putBoolean("o_f" + t_oficinas.this.id_fotoacargar[t_oficinas.this.ind_fotoacargar] + "_modif", false);
                edit.commit();
                int i = t_oficinas.this.coord_fotoacargar[t_oficinas.this.ind_fotoacargar][0];
                int i2 = t_oficinas.this.coord_fotoacargar[t_oficinas.this.ind_fotoacargar][1];
                if (i2 == 1) {
                    t_oficinas.this.globales.oficinas_a[i].f1_modif = false;
                } else if (i2 == 2) {
                    t_oficinas.this.globales.oficinas_a[i].f2_modif = false;
                } else if (i2 == 3) {
                    t_oficinas.this.globales.oficinas_a[i].f3_modif = false;
                } else if (i2 == 4) {
                    t_oficinas.this.globales.oficinas_a[i].f4_modif = false;
                }
            }
            t_oficinas.this.ind_fotoacargar++;
            if (t_oficinas.this.ind_fotoacargar < t_oficinas.this.n_fotoacargar) {
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

    private class datosMapa {
        String cp;
        String dir1;
        String dir2;
        String pob;
        String prov;
        String titulo;
        int x;
        int y;
        int z;

        private datosMapa() {
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
                if (!t_oficinas.this.globales.admob_rew_failed(context, t_oficinas.this.mAd_appnext)) {
                    t_oficinas.this.dialog_cargando.cancel();
                    t_oficinas t_oficinas = t_oficinas.this;
                    t_oficinas.abrir_secc(t_oficinas.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_oficinas.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_oficinas.this.abrir_secc(t_oficinas.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_oficinas.this.mAd_visto) {
                            t_oficinas.this.abrir_secc(t_oficinas.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_oficinas.this.mAd_visto = true;
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
                if (t_oficinas.this.mAd_visto) {
                    t_oficinas t_oficinas = t_oficinas.this;
                    t_oficinas.abrir_secc(t_oficinas.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
