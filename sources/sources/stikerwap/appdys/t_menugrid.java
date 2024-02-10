package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
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
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.ads.banner.Mrec;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.wortise.ads.banner.BannerAd;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class t_menugrid extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, AdapterView.OnItemClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    int H_MAXIMA = 80;
    int H_MAXIMA_ROW = 30;
    GridAdapter MyGridAdapter;
    BannerAd adView_nat_w;
    Anuncios anun;
    boolean atras_pulsado = false;
    cargarfondo cf;
    config globales;
    MyGridView gridView;
    int h_max;
    int intentos_appnext = 0;
    boolean is_banner_mostrando = false;
    boolean mAd_visto = false;
    int w_max;
    int w_txt_max;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            android.content.Context r0 = r14.getApplicationContext()
            stikerwap.appdys.config r0 = (stikerwap.appdys.config) r0
            r14.globales = r0
            java.lang.String r0 = r0.c1
            if (r0 != 0) goto L_0x0011
            stikerwap.appdys.config r0 = r14.globales
            r0.recuperar_vars()
        L_0x0011:
            r14.establec_ralc(r14)
            stikerwap.appdys.config r0 = r14.globales
            java.lang.String r0 = r0.menu_c1
            stikerwap.appdys.config r1 = r14.globales
            java.lang.String r1 = r1.c_icos
            java.lang.String r0 = stikerwap.appdys.config.aplicar_color_dialog(r0, r1)
            r14.cbtn = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "#"
            r0.<init>(r1)
            stikerwap.appdys.config r2 = r14.globales
            java.lang.String r2 = r2.menu_c1
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            boolean r0 = stikerwap.appdys.config.esClaro(r0)
            if (r0 != 0) goto L_0x0040
            r0 = 2131952478(0x7f13035e, float:1.95414E38)
            r14.setTheme(r0)
        L_0x0040:
            super.onCreate(r15)
            r0 = 2131558732(0x7f0d014c, float:1.8742788E38)
            r14.setContentView(r0)
            stikerwap.appdys.config r0 = r14.globales
            r2 = 900(0x384, float:1.261E-42)
            r0.ind_secc_sel = r2
            java.lang.String r0 = "sh"
            r2 = 0
            android.content.SharedPreferences r0 = r14.getSharedPreferences(r0, r2)
            r0.registerOnSharedPreferenceChangeListener(r14)
            android.content.SharedPreferences$Editor r3 = r0.edit()
            stikerwap.appdys.config r4 = r14.globales
            int r4 = r4.ind_secc_sel
            java.lang.String r5 = "ind_secc_sel"
            r3.putInt(r5, r4)
            r3.commit()
            r14.incluir_menu_pre()
            stikerwap.appdys.config r3 = r14.globales
            r3.onCreate_global(r14, r2)
            java.lang.String r3 = "search"
            java.lang.Object r3 = r14.getSystemService(r3)
            android.app.SearchManager r3 = (android.app.SearchManager) r3
            stikerwap.appdys.t_menugrid$1 r4 = new stikerwap.appdys.t_menugrid$1
            r4.<init>()
            r3.setOnCancelListener(r4)
            stikerwap.appdys.t_menugrid$2 r4 = new stikerwap.appdys.t_menugrid$2
            r4.<init>()
            r3.setOnDismissListener(r4)
            stikerwap.appdys.config r3 = r14.globales
            java.lang.String r3 = r3.menu_c1
            java.lang.String r4 = ""
            boolean r3 = r3.equals(r4)
            r5 = 2131362630(0x7f0a0346, float:1.8345046E38)
            r6 = 2
            r7 = 1
            if (r3 != 0) goto L_0x00d6
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r8 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            int[] r9 = new int[r6]
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r1)
            stikerwap.appdys.config r11 = r14.globales
            java.lang.String r11 = r11.menu_c1
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            int r10 = android.graphics.Color.parseColor(r10)
            r9[r2] = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r1)
            stikerwap.appdys.config r11 = r14.globales
            java.lang.String r11 = r11.menu_c2
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            int r10 = android.graphics.Color.parseColor(r10)
            r9[r7] = r10
            r3.<init>(r8, r9)
            android.view.View r8 = r14.findViewById(r5)
            r8.setBackgroundDrawable(r3)
        L_0x00d6:
            android.content.res.Resources r3 = r14.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            int r8 = r14.H_MAXIMA
            float r8 = (float) r8
            float r8 = r8 * r3
            r9 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r9
            int r8 = (int) r8
            r14.H_MAXIMA = r8
            int r8 = r14.H_MAXIMA_ROW
            float r8 = (float) r8
            float r8 = r8 * r3
            float r8 = r8 + r9
            int r8 = (int) r8
            r14.H_MAXIMA_ROW = r8
            r14.h_max = r2
            r14.w_max = r2
            r14.w_txt_max = r2
            java.lang.String r8 = "layout_inflater"
            java.lang.Object r8 = r14.getSystemService(r8)
            android.view.LayoutInflater r8 = (android.view.LayoutInflater) r8
            stikerwap.appdys.config r10 = r14.globales
            boolean r10 = r10.menu_icos_izq
            java.lang.String r11 = "ara"
            if (r10 == 0) goto L_0x0113
            java.lang.String r10 = "11"
            android.util.Log.e(r11, r10)
            r10 = 2131558733(0x7f0d014d, float:1.874279E38)
            goto L_0x0139
        L_0x0113:
            stikerwap.appdys.config r10 = r14.globales
            int r10 = r10.menu_estilo
            if (r10 != r7) goto L_0x0122
            java.lang.String r10 = "12"
            android.util.Log.e(r11, r10)
            r10 = 2131558734(0x7f0d014e, float:1.8742792E38)
            goto L_0x0139
        L_0x0122:
            stikerwap.appdys.config r10 = r14.globales
            int r10 = r10.menu_estilo
            if (r10 != r6) goto L_0x0131
            java.lang.String r10 = "13"
            android.util.Log.e(r11, r10)
            r10 = 2131558735(0x7f0d014f, float:1.8742794E38)
            goto L_0x0139
        L_0x0131:
            java.lang.String r10 = "14"
            android.util.Log.e(r11, r10)
            r10 = 2131558736(0x7f0d0150, float:1.8742796E38)
        L_0x0139:
            android.view.View r5 = r14.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            android.view.View r5 = r8.inflate(r10, r5, r2)
            r8 = 2131363448(0x7f0a0678, float:1.8346705E38)
            android.view.View r5 = r5.findViewById(r8)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r8 = 0
        L_0x014d:
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            int r10 = r10.length
            if (r8 >= r10) goto L_0x0210
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            boolean r10 = r10.oculta
            if (r10 != 0) goto L_0x020c
            stikerwap.appdys.config r10 = r14.globales
            boolean r10 = r10.menu_mostrar_txt
            if (r10 == 0) goto L_0x018b
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            java.lang.String r10 = r10.titulo
            r5.setText(r10)
            stikerwap.appdys.config r10 = r14.globales
            boolean r10 = r10.menu_txt_b
            if (r10 == 0) goto L_0x017c
            android.graphics.Typeface r10 = r5.getTypeface()
            r5.setTypeface(r10, r7)
        L_0x017c:
            r5.measure(r2, r2)
            int r10 = r14.w_txt_max
            int r11 = r5.getMeasuredWidth()
            int r10 = java.lang.Math.max(r10, r11)
            r14.w_txt_max = r10
        L_0x018b:
            stikerwap.appdys.config r10 = r14.globales
            boolean r10 = r10.menu_mostrar_icos
            if (r10 == 0) goto L_0x020c
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            boolean r10 = r10.ico_cargando
            if (r10 != 0) goto L_0x01ce
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            android.graphics.Bitmap r10 = r10.ico
            if (r10 == 0) goto L_0x01ce
            int r10 = r14.h_max
            stikerwap.appdys.config r11 = r14.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            r11 = r11[r8]
            android.graphics.Bitmap r11 = r11.ico
            int r11 = r11.getHeight()
            int r10 = java.lang.Math.max(r10, r11)
            r14.h_max = r10
            int r10 = r14.w_max
            stikerwap.appdys.config r11 = r14.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            r11 = r11[r8]
            android.graphics.Bitmap r11 = r11.ico
            int r11 = r11.getWidth()
            int r10 = java.lang.Math.max(r10, r11)
            r14.w_max = r10
            goto L_0x020c
        L_0x01ce:
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            boolean r10 = r10.ico_cargando
            if (r10 == 0) goto L_0x020c
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            int r10 = r10.w_ico
            if (r10 == 0) goto L_0x020c
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r8]
            int r10 = r10.h_ico
            if (r10 == 0) goto L_0x020c
            int r10 = r14.h_max
            stikerwap.appdys.config r11 = r14.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            r11 = r11[r8]
            int r11 = r11.h_ico
            int r10 = java.lang.Math.max(r10, r11)
            r14.h_max = r10
            int r10 = r14.w_max
            stikerwap.appdys.config r11 = r14.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            r11 = r11[r8]
            int r11 = r11.w_ico
            int r10 = java.lang.Math.max(r10, r11)
            r14.w_max = r10
        L_0x020c:
            int r8 = r8 + 1
            goto L_0x014d
        L_0x0210:
            int r5 = r14.h_max
            float r5 = (float) r5
            float r5 = r5 * r3
            float r5 = r5 + r9
            int r5 = (int) r5
            r14.h_max = r5
            int r5 = r14.w_max
            float r5 = (float) r5
            float r5 = r5 * r3
            float r5 = r5 + r9
            int r5 = (int) r5
            r14.w_max = r5
            android.view.WindowManager r5 = r14.getWindowManager()
            android.view.Display r5 = r5.getDefaultDisplay()
            android.graphics.Point r8 = new android.graphics.Point
            r8.<init>()
            r5.getSize(r8)
            int r5 = r8.x
            stikerwap.appdys.config r8 = r14.globales
            boolean r8 = r8.menu_icos_izq
            if (r8 == 0) goto L_0x024a
            int r8 = r14.h_max
            int r10 = r14.H_MAXIMA_ROW
            if (r8 <= r10) goto L_0x024a
            int r11 = r14.w_max
            int r11 = r11 * r10
            int r11 = r11 / r8
            r14.w_max = r11
            r14.h_max = r10
            goto L_0x025f
        L_0x024a:
            stikerwap.appdys.config r8 = r14.globales
            boolean r8 = r8.menu_icos_izq
            if (r8 != 0) goto L_0x025f
            int r8 = r14.h_max
            int r10 = r14.H_MAXIMA
            if (r8 <= r10) goto L_0x025f
            int r11 = r14.w_max
            int r11 = r11 * r10
            int r11 = r11 / r8
            r14.w_max = r11
            r14.h_max = r10
        L_0x025f:
            stikerwap.appdys.config r8 = r14.globales
            boolean r8 = r8.menu_icos_izq
            if (r8 != 0) goto L_0x027a
            stikerwap.appdys.config r8 = r14.globales
            boolean r8 = r8.menu_mostrar_txt
            if (r8 == 0) goto L_0x027a
            int r8 = r14.w_max
            int r10 = r14.w_txt_max
            if (r8 <= r10) goto L_0x027a
            int r11 = r14.h_max
            int r11 = r11 * r10
            int r11 = r11 / r8
            r14.h_max = r11
            r14.w_max = r10
        L_0x027a:
            r8 = 2131362339(0x7f0a0223, float:1.8344456E38)
            android.view.View r8 = r14.findViewById(r8)
            stikerwap.appdys.MyGridView r8 = (stikerwap.appdys.MyGridView) r8
            r14.gridView = r8
            stikerwap.appdys.t_menugrid$3 r10 = new stikerwap.appdys.t_menugrid$3
            r10.<init>()
            r8.setOnItemSelectedListener(r10)
            stikerwap.appdys.config r8 = r14.globales
            boolean r8 = r8.menu_c
            if (r8 == 0) goto L_0x029f
            r8 = 2131362606(0x7f0a032e, float:1.8344997E38)
            android.view.View r8 = r14.findViewById(r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r8.setGravity(r7)
        L_0x029f:
            stikerwap.appdys.config r8 = r14.globales
            int r8 = r8.menu_padding
            if (r8 != r7) goto L_0x02a8
            r8 = 16
            goto L_0x02b2
        L_0x02a8:
            stikerwap.appdys.config r8 = r14.globales
            int r8 = r8.menu_padding
            if (r8 != r6) goto L_0x02b1
            r8 = 24
            goto L_0x02b2
        L_0x02b1:
            r8 = 1
        L_0x02b2:
            float r8 = (float) r8
            float r8 = r8 * r3
            float r8 = r8 + r9
            int r8 = (int) r8
            stikerwap.appdys.MyGridView r10 = r14.gridView
            r10.setVerticalSpacing(r8)
            stikerwap.appdys.MyGridView r10 = r14.gridView
            r10.setHorizontalSpacing(r8)
            r10 = 1092616192(0x41200000, float:10.0)
            float r10 = r10 * r3
            float r10 = r10 + r9
            int r10 = (int) r10
            stikerwap.appdys.MyGridView r11 = r14.gridView
            r11.setPadding(r10, r10, r10, r10)
            stikerwap.appdys.config r11 = r14.globales
            int r11 = r11.menu_ncols
            stikerwap.appdys.config r12 = r14.globales
            boolean r12 = r12.menu_icos_izq
            if (r12 == 0) goto L_0x02f2
            int r12 = r14.w_max
            int r13 = r14.w_txt_max
            int r12 = r12 + r13
            int r12 = r12 + r8
            r13 = 1082130432(0x40800000, float:4.0)
            float r3 = r3 * r13
            float r3 = r3 + r9
            int r3 = (int) r3
            stikerwap.appdys.config r9 = r14.globales
            boolean r9 = r9.menu_mostrar_txt
            if (r9 == 0) goto L_0x02e9
            int r12 = r12 + r3
        L_0x02e9:
            int r3 = r14.w_max
            int r9 = r14.w_txt_max
            int r3 = r3 + r9
            r14.banner(r3)
            goto L_0x0317
        L_0x02f2:
            stikerwap.appdys.config r3 = r14.globales
            int r3 = r3.menu_estilo
            if (r3 == r7) goto L_0x0301
            stikerwap.appdys.config r3 = r14.globales
            int r3 = r3.menu_estilo
            if (r3 != r6) goto L_0x02ff
            goto L_0x0301
        L_0x02ff:
            r3 = 0
            goto L_0x0307
        L_0x0301:
            r3 = 10
            int r3 = stikerwap.appdys.config.dp_to_px(r14, r3)
        L_0x0307:
            int r9 = r14.w_max
            int r12 = r14.w_txt_max
            int r9 = java.lang.Math.max(r9, r12)
            int r9 = r9 + r8
            int r12 = r9 + r3
            int r3 = r14.w_txt_max
            r14.banner(r3)
        L_0x0317:
            if (r11 <= r7) goto L_0x0323
            int r3 = r12 * r11
            int r9 = r10 * 2
            int r3 = r3 + r9
            if (r3 <= r5) goto L_0x0323
            int r11 = r11 + -1
            goto L_0x0317
        L_0x0323:
            stikerwap.appdys.MyGridView r3 = r14.gridView
            r3.setNumColumns(r11)
            stikerwap.appdys.MyGridView r3 = r14.gridView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            int r12 = r12 * r11
            int r10 = r10 * 2
            int r12 = r12 + r10
            int r12 = r12 - r8
            r3.width = r12
            stikerwap.appdys.MyGridView r3 = r14.gridView
            r3.setOnItemClickListener(r14)
            stikerwap.appdys.config r3 = r14.globales
            boolean r3 = r3.menu_anim
            r5 = 0
            if (r3 == 0) goto L_0x0344
            if (r15 == 0) goto L_0x0349
        L_0x0344:
            stikerwap.appdys.MyGridView r3 = r14.gridView
            r3.setLayoutAnimation(r5)
        L_0x0349:
            stikerwap.appdys.t_menugrid$GridAdapter r3 = new stikerwap.appdys.t_menugrid$GridAdapter
            r3.<init>(r14)
            r14.MyGridAdapter = r3
            stikerwap.appdys.MyGridView r6 = r14.gridView
            r6.setAdapter(r3)
            stikerwap.appdys.config r3 = r14.globales
            boolean r3 = r3.t_fondomenu
            r6 = 2131362464(0x7f0a02a0, float:1.834471E38)
            if (r3 == 0) goto L_0x03b9
            java.io.File r0 = new java.io.File
            java.io.File r3 = r14.getFilesDir()
            java.lang.String r8 = "fondomenu"
            r0.<init>(r3, r8)
            stikerwap.appdys.config r3 = r14.globales
            boolean r3 = r3.act_fondomenu
            if (r3 != 0) goto L_0x03a0
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0376
            goto L_0x03a0
        L_0x0376:
            java.io.FileInputStream r0 = r14.openFileInput(r8)     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            android.view.View r3 = r14.findViewById(r6)     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            stikerwap.appdys.config r5 = r14.globales     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            boolean r6 = r5.margen_fondomenu     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            stikerwap.appdys.config r8 = r14.globales     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            int r8 = r8.tipo_fondomenu     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            r5.tratar_fondo(r3, r6, r8)     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            java.io.FileDescriptor r5 = r0.getFD()     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFileDescriptor(r5)     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            r3.setImageBitmap(r5)     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            r0.close()     // Catch:{ FileNotFoundException | IOException -> 0x039e }
            goto L_0x03ef
        L_0x039e:
            goto L_0x03ef
        L_0x03a0:
            stikerwap.appdys.t_menugrid$cargarfondo r0 = r14.cf
            if (r0 == 0) goto L_0x03ac
            android.os.AsyncTask$Status r0 = r0.getStatus()
            android.os.AsyncTask$Status r3 = android.os.AsyncTask.Status.RUNNING
            if (r0 == r3) goto L_0x03ef
        L_0x03ac:
            stikerwap.appdys.t_menugrid$cargarfondo r0 = new stikerwap.appdys.t_menugrid$cargarfondo
            r0.<init>()
            r14.cf = r0
            java.lang.String[] r3 = new java.lang.String[r2]
            r0.execute(r3)
            goto L_0x03ef
        L_0x03b9:
            stikerwap.appdys.config r3 = r14.globales
            int r3 = r3.fondo_v
            if (r3 <= 0) goto L_0x03ef
            java.lang.String r3 = "fondo_v_act"
            int r0 = r0.getInt(r3, r2)
            stikerwap.appdys.config r3 = r14.globales
            int r3 = r3.fondo_v
            if (r0 != r3) goto L_0x03ef
            stikerwap.appdys.config r0 = r14.globales     // Catch:{  }
            android.view.View r3 = r14.findViewById(r6)     // Catch:{  }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{  }
            stikerwap.appdys.config r5 = r14.globales     // Catch:{  }
            boolean r5 = r5.fondo_margen     // Catch:{  }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{  }
            stikerwap.appdys.config r8 = r14.globales     // Catch:{  }
            int r8 = r8.fondo_tipo     // Catch:{  }
            r0.tratar_fondo(r3, r5, r8)     // Catch:{  }
            stikerwap.appdys.config r0 = r14.globales     // Catch:{  }
            java.lang.String r3 = "fondo"
            android.view.View r5 = r14.findViewById(r6)     // Catch:{  }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{  }
            r0.file_to_iv(r3, r5)     // Catch:{  }
        L_0x03ef:
            stikerwap.appdys.config r0 = r14.globales
            boolean r0 = r0.privacy_enmenu
            if (r0 == 0) goto L_0x0434
            r0 = 2131363066(0x7f0a04fa, float:1.834593E38)
            android.view.View r0 = r14.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            stikerwap.appdys.config r3 = r14.globales
            java.lang.String r3 = r3.menu_c2
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0424
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            stikerwap.appdys.config r1 = r14.globales
            java.lang.String r1 = r1.menu_c2
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            boolean r1 = stikerwap.appdys.config.esClaro(r1)
            if (r1 == 0) goto L_0x0424
            int r1 = stikerwap.appdys.config.GRIS_OSCURO
            r0.setTextColor(r1)
            goto L_0x0429
        L_0x0424:
            int r1 = stikerwap.appdys.config.GRIS_CLARO
            r0.setTextColor(r1)
        L_0x0429:
            stikerwap.appdys.t_menugrid$4 r1 = new stikerwap.appdys.t_menugrid$4
            r1.<init>()
            r0.setOnClickListener(r1)
            r0.setVisibility(r2)
        L_0x0434:
            if (r15 != 0) goto L_0x0471
            android.content.Intent r0 = r14.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0452
            java.lang.String r1 = "intent_abrir"
            boolean r3 = r0.containsKey(r1)
            if (r3 == 0) goto L_0x0452
            java.lang.Object r15 = r0.get(r1)
            android.content.Intent r15 = (android.content.Intent) r15
            r14.startActivityForResult(r15, r2)
            goto L_0x0471
        L_0x0452:
            if (r15 != 0) goto L_0x0471
            stikerwap.appdys.config r15 = r14.globales
            if (r0 == 0) goto L_0x0462
            java.lang.String r1 = "ad_entrar"
            boolean r1 = r0.containsKey(r1)
            if (r1 == 0) goto L_0x0462
            r1 = 1
            goto L_0x0463
        L_0x0462:
            r1 = 0
        L_0x0463:
            if (r0 == 0) goto L_0x046e
            java.lang.String r3 = "fb_entrar"
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x046e
            r2 = 1
        L_0x046e:
            r15.toca_int(r14, r1, r2)
        L_0x0471:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_menugrid.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public void banner(final int i) {
        int i2;
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            boolean z = (this.globales.admob_menu_cod.equals("") || this.globales.admob_menu_w == 0 || this.globales.admob_menu_h == 0) ? false : true;
            boolean z2 = !this.globales.appnext_menu_cod.equals("") && this.globales.appnext_ads != null && this.globales.appnext_ads.size() > 0;
            boolean z3 = !this.globales.fb_menu_cod.equals("");
            boolean z4 = !this.globales.st_menu_cod.equals("");
            boolean z5 = !this.globales.is_menu_cod.equals("");
            boolean z6 = !this.globales.wortise_menu_cod.equals("");
            if (z6 || z || z2 || z3 || z4 || z5 || this.globales.appnext_menu_cod.equals("") || (i2 = this.intentos_appnext) >= 5) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(1);
                }
                if (z2 && !z6) {
                    arrayList.add(2);
                }
                if (z3) {
                    arrayList.add(3);
                }
                if (z4) {
                    arrayList.add(4);
                }
                if (z5) {
                    arrayList.add(5);
                }
                if (z6) {
                    arrayList.add(6);
                }
                int intValue = !arrayList.isEmpty() ? ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue() : 0;
                if (intValue == 1) {
                    AdView adView = new AdView(this);
                    adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
                    adView.setAdUnitId(this.globales.admob_menu_cod);
                    findViewById(R.id.ll_appsreco).setVisibility(8);
                    ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
                    ((LinearLayout) findViewById(R.id.ll_nat)).removeViewAt(1);
                    ((LinearLayout) findViewById(R.id.ll_nat)).addView(adView, 1);
                    adView.loadAd(new AdRequest.Builder().build());
                } else if (intValue == 2) {
                    if (!this.globales.menu_c1.equals("")) {
                        if (config.esClaro("#" + this.globales.menu_c1)) {
                            ((TextView) findViewById(R.id.tv_appsreco)).setTextColor(config.NEGRO);
                        }
                    }
                    this.globales.appnext_mostrar_2(this, 1, 3, -1, (String) null);
                } else if (intValue == 3) {
                    final NativeAd nativeAd = new NativeAd((Context) this, this.globales.fb_menu_cod);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new NativeAdListener() {
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
                            if (t_menugrid.this.globales.menu_c2 != null && !t_menugrid.this.globales.menu_c2.equals("")) {
                                int canviarColor = config.canviarColor(Color.parseColor("#" + t_menugrid.this.globales.menu_c2), 0.2f, 0);
                                backgroundColor.setBackgroundColor(canviarColor);
                                if (config.esClaro_int(canviarColor)) {
                                    backgroundColor.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
                                    backgroundColor.setDescriptionTextColor(ViewCompat.MEASURED_STATE_MASK);
                                } else {
                                    backgroundColor.setTitleTextColor(-1);
                                    backgroundColor.setDescriptionTextColor(-1);
                                }
                            }
                            if (t_menugrid.this.globales.menu_mostrar_txt && t_menugrid.this.globales.menu_txt_col != null && !t_menugrid.this.globales.menu_txt_col.equals("") && t_menugrid.this.globales.menu_txt_bg != null && !t_menugrid.this.globales.menu_txt_bg.equals("")) {
                                NativeAdViewAttributes buttonBorderColor = backgroundColor.setButtonTextColor(Color.parseColor("#" + t_menugrid.this.globales.menu_txt_col)).setButtonBorderColor(-12303292);
                                buttonBorderColor.setButtonColor(Color.parseColor("#" + t_menugrid.this.globales.menu_txt_bg));
                            }
                            View render = NativeAdView.render(t_menugrid.this, nativeAd, NativeAdView.Type.HEIGHT_300, backgroundColor);
                            LinearLayout linearLayout = (LinearLayout) t_menugrid.this.findViewById(R.id.ll_nat);
                            try {
                                if (config.esClaro("#" + t_menugrid.this.globales.menu_c2)) {
                                    linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                } else {
                                    linearLayout.setBackgroundColor(-1);
                                }
                                int dp_to_px = config.dp_to_px(t_menugrid.this.getApplicationContext(), 1);
                                linearLayout.setPadding(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            linearLayout.setVisibility(0);
                            ((LinearLayout) t_menugrid.this.findViewById(R.id.ll_nat)).removeViewAt(1);
                            ((LinearLayout) t_menugrid.this.findViewById(R.id.ll_nat)).addView(render, 1);
                        }
                    }).build());
                } else if (intValue == 4) {
                    Mrec mrec = new Mrec((Activity) this);
                    mrec.setAdTag("MENU");
                    ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
                    ((LinearLayout) findViewById(R.id.ll_nat)).removeViewAt(1);
                    ((LinearLayout) findViewById(R.id.ll_nat)).addView(mrec, 1);
                } else if (intValue == 5) {
                    mostrar_banner_is();
                } else if (intValue == 6) {
                    BannerAd bannerAd = new BannerAd(this);
                    this.adView_nat_w = bannerAd;
                    bannerAd.setAutoRefresh(false);
                    this.adView_nat_w.setAdSize(com.wortise.ads.AdSize.HEIGHT_250);
                    this.adView_nat_w.setAdUnitId(this.globales.wortise_menu_cod);
                    findViewById(R.id.ll_appsreco).setVisibility(8);
                    ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
                    this.adView_nat_w.setListener(new BannerAd.Listener() {
                        public void onBannerClicked(BannerAd bannerAd) {
                        }

                        public void onBannerFailed(BannerAd bannerAd, com.wortise.ads.AdError adError) {
                            Log.e("ara", "wortise banner failed:" + adError.toString());
                            if (!t_menugrid.this.globales.appnext_menu_cod.equals("")) {
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        if (t_menugrid.this.globales.appnext_ads != null && t_menugrid.this.globales.appnext_ads.size() > 0) {
                                            Log.e("ara", "appnext carregat");
                                            if (!t_menugrid.this.globales.menu_c1.equals("")) {
                                                if (config.esClaro("#" + t_menugrid.this.globales.menu_c1)) {
                                                    ((TextView) t_menugrid.this.findViewById(R.id.tv_appsreco)).setTextColor(config.NEGRO);
                                                }
                                            }
                                            t_menugrid.this.globales.appnext_mostrar_2(t_menugrid.this, 1, 3, -1, (String) null);
                                        }
                                    }
                                }, (long) ((t_menugrid.this.globales.appnext_ads == null || t_menugrid.this.globales.appnext_ads.size() <= 0) ? 2000 : 10));
                            }
                        }

                        public void onBannerLoaded(BannerAd bannerAd) {
                            ((LinearLayout) t_menugrid.this.findViewById(R.id.ll_nat)).removeViewAt(1);
                            ((LinearLayout) t_menugrid.this.findViewById(R.id.ll_nat)).addView(t_menugrid.this.adView_nat_w, 1);
                        }
                    });
                    Log.e("ara", "carreguem wortise");
                    this.adView_nat_w.loadAd();
                } else {
                    this.anun = this.globales.mostrar_banner(this, false);
                }
            } else {
                this.intentos_appnext = i2 + 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        t_menugrid.this.banner(i);
                    }
                }, 1000);
            }
        }
    }

    private void mostrar_banner_is() {
        if (this.globales.isBanner_global != null) {
            IronSource.destroyBanner(this.globales.isBanner_global);
        }
        this.globales.isBanner_global = IronSource.createBanner(this, ISBannerSize.RECTANGLE);
        findViewById(R.id.ll_appsreco).setVisibility(8);
        ((LinearLayout) findViewById(R.id.ll_nat)).setVisibility(0);
        ((LinearLayout) findViewById(R.id.ll_nat)).removeViewAt(1);
        ((LinearLayout) findViewById(R.id.ll_nat)).addView(this.globales.isBanner_global, 1);
        IronSource.loadBanner(this.globales.isBanner_global);
        this.is_banner_mostrando = true;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("fondo_v_act")) {
            if (!this.globales.t_fondomenu) {
                try {
                    this.globales.tratar_fondo((ImageView) findViewById(R.id.iv_fondo), Boolean.valueOf(this.globales.fondo_margen), this.globales.fondo_tipo);
                    ((ImageView) findViewById(R.id.iv_fondo)).setVisibility(8);
                    this.globales.file_to_iv("fondo", (ImageView) findViewById(R.id.iv_fondo));
                    config.fade_in((ImageView) findViewById(R.id.iv_fondo));
                } catch (Exception unused) {
                }
            }
        } else if (this.MyGridAdapter != null && str.equals("ico_cargado")) {
            this.MyGridAdapter.notifyDataSetChanged();
        }
    }

    public class GridAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public GridAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return t_menugrid.this.globales.menu_a_secciones.length;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
                if (t_menugrid.this.globales.menu_icos_izq) {
                    i2 = R.layout.t_menugrid_row;
                } else if (t_menugrid.this.globales.menu_estilo == 1) {
                    i2 = R.layout.t_menugrid_row_formato2;
                } else {
                    i2 = t_menugrid.this.globales.menu_estilo == 2 ? R.layout.t_menugrid_row_formato3 : R.layout.t_menugrid_row_v;
                }
                view = layoutInflater.inflate(i2, viewGroup, false);
                if (!t_menugrid.this.globales.menu_icos_izq && (t_menugrid.this.globales.menu_estilo == 1 || t_menugrid.this.globales.menu_estilo == 2)) {
                    ((CardView) view).setRadius((float) t_menugrid.this.globales.menu_txt_radius);
                }
                if (t_menugrid.this.globales.menu_mostrar_icos) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_menugrid);
                    if (t_menugrid.this.globales.menu_icos_izq) {
                        imageView.getLayoutParams().height = t_menugrid.this.h_max;
                        imageView.getLayoutParams().width = t_menugrid.this.w_max;
                    } else {
                        imageView.getLayoutParams().height = t_menugrid.this.h_max;
                        imageView.getLayoutParams().width = t_menugrid.this.w_max;
                    }
                    imageView.setVisibility(0);
                }
                if (t_menugrid.this.globales.menu_mostrar_txt) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_menugrid);
                    if (t_menugrid.this.globales.menu_txt_b) {
                        textView.setTypeface(textView.getTypeface(), 1);
                    }
                    if (!t_menugrid.this.globales.menu_txt_col.equals("")) {
                        textView.setTextColor(Color.parseColor("#" + t_menugrid.this.globales.menu_txt_col));
                    }
                    textView.getLayoutParams().width = t_menugrid.this.w_txt_max;
                    if (t_menugrid.this.globales.menu_txt_c) {
                        textView.setGravity(17);
                    } else if (t_menugrid.this.getResources().getBoolean(R.bool.es_rtl)) {
                        textView.setTextDirection(4);
                    }
                    if (t_menugrid.this.globales.menu_txt_bg.equals("")) {
                        textView.setBackgroundDrawable((Drawable) null);
                    } else {
                        ((GradientDrawable) textView.getBackground()).setColor(Color.parseColor("#" + t_menugrid.this.globales.menu_txt_bg));
                        ((GradientDrawable) textView.getBackground()).setCornerRadius((float) t_menugrid.this.globales.menu_txt_radius);
                    }
                    textView.setVisibility(0);
                }
            }
            if (t_menugrid.this.globales.menu_mostrar_icos) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_menugrid);
                if (t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].ico_cargando || t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].ico == null) {
                    imageView2.setImageBitmap((Bitmap) null);
                } else {
                    if (!t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].ico_mostrado) {
                        imageView2.setVisibility(4);
                    }
                    imageView2.setImageDrawable(new BitmapDrawable(t_menugrid.this.getResources(), t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].ico));
                    if (!t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].ico_mostrado) {
                        t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].ico_mostrado = true;
                        config.fade_in(imageView2);
                    }
                }
            }
            if (t_menugrid.this.globales.menu_mostrar_txt) {
                ((TextView) view.findViewById(R.id.tv_menugrid)).setText(t_menugrid.this.globales.secciones_a[t_menugrid.this.globales.menu_a_secciones[i]].titulo);
            }
            return view;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        view.setId(this.globales.menu_a_secciones[i]);
        view.setTag(R.id.TAG_IDSECC, Integer.valueOf(this.globales.menu_a_secciones[i]));
        onClick(view);
    }

    public void onClick(View view) {
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

    public void abrir_secc(View view) {
        ResultGetIntent intent = this.globales.getIntent(view, this);
        if (intent != null) {
            if (intent.finalizar_app) {
                finish();
            } else if (intent.i != null) {
                startActivityForResult(intent.i, 0);
            }
        }
    }

    private class cargarfondo extends AsyncTask<String, Void, String> {
        private cargarfondo() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.lang.String r0 = "/srv/imgs/fondos_menu/fm3008836.png?v="
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                r2.append(r0)     // Catch:{  }
                stikerwap.appdys.t_menugrid r0 = stikerwap.appdys.t_menugrid.this     // Catch:{  }
                stikerwap.appdys.config r0 = r0.globales     // Catch:{  }
                int r0 = r0.v_fondomenu     // Catch:{  }
                r2.append(r0)     // Catch:{  }
                java.lang.String r0 = r2.toString()     // Catch:{  }
                r1.<init>(r0)     // Catch:{  }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r1 = 1
                r0.setDoInput(r1)     // Catch:{  }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{  }
                r1 = 60000(0xea60, float:8.4078E-41)
                r0.setReadTimeout(r1)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{  }
                r1.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                stikerwap.appdys.t_menugrid r0 = stikerwap.appdys.t_menugrid.this     // Catch:{ MalformedURLException -> 0x005b }
                java.lang.String r1 = "fondomenu"
                r3 = 0
                java.io.FileOutputStream r0 = r0.openFileOutput(r1, r3)     // Catch:{ MalformedURLException -> 0x005b }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ MalformedURLException -> 0x005b }
                r3 = 100
                r2.compress(r1, r3, r0)     // Catch:{ MalformedURLException -> 0x005b }
                java.lang.String r5 = "1"
            L_0x005b:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_menugrid.cargarfondo.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.equals("1")) {
                t_menugrid.this.globales.act_fondomenu = false;
                SharedPreferences.Editor edit = t_menugrid.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit.putBoolean("act_fm", false);
                edit.commit();
                if (!t_menugrid.this.globales.equals((Object) null)) {
                    try {
                        FileInputStream openFileInput = t_menugrid.this.openFileInput("fondomenu");
                        ImageView imageView = (ImageView) t_menugrid.this.findViewById(R.id.iv_fondo);
                        t_menugrid.this.globales.tratar_fondo(imageView, Boolean.valueOf(t_menugrid.this.globales.margen_fondomenu), t_menugrid.this.globales.tipo_fondomenu);
                        imageView.setVisibility(8);
                        imageView.setImageBitmap(BitmapFactory.decodeFileDescriptor(openFileInput.getFD()));
                        config.fade_in(imageView);
                        openFileInput.close();
                    } catch (FileNotFoundException | IOException unused) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void incluir_menu_pre() {
        this.globales.incluir_menu(this);
        for (int i = 0; i < this.globales.icos_a.length; i++) {
            if (this.globales.icos_a[i] > 0) {
                findViewById(this.globales.icos_a[i]).setOnClickListener(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config == null || !config.onActivityResult_glob(i, i2, intent, this)) && i2 == -1 && intent != null && intent.hasExtra("finalizar_app") && intent.getExtras().getBoolean("finalizar_app")) {
            finish();
        }
    }

    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
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
        ImageView imageView;
        super.onResume();
        config.onResume_global(this);
        if (this.is_banner_mostrando) {
            mostrar_banner_is();
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ll_nat);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i).findViewById(R.id.ad_pb) != null) {
                viewGroup.getChildAt(i).findViewById(R.id.ad_pb).setVisibility(8);
            }
        }
        if (this.globales.ico_perfil_ord > 0 && (imageView = (ImageView) findViewById(this.globales.ico_perfil_ord + 10000)) != null) {
            this.globales.mostrar_ico_perfil(this, imageView);
        }
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
        this.atras_pulsado = false;
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
        if (isFinishing()) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.atras_pulsado || !this.globales.pedir_confirm_exit) {
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
                if (!t_menugrid.this.globales.admob_rew_failed(context, t_menugrid.this.mAd_appnext)) {
                    t_menugrid.this.dialog_cargando.cancel();
                    t_menugrid t_menugrid = t_menugrid.this;
                    t_menugrid.abrir_secc(t_menugrid.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_menugrid.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        t_menugrid.this.abrir_secc(t_menugrid.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_menugrid.this.mAd_visto) {
                            t_menugrid.this.abrir_secc(t_menugrid.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_menugrid.this.mAd_visto = true;
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
                if (t_menugrid.this.mAd_visto) {
                    t_menugrid t_menugrid = t_menugrid.this;
                    t_menugrid.abrir_secc(t_menugrid.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
