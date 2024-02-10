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
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.installreferrer.api.InstallReferrerClient;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.AppnextError;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.nativeads.NativeAd;
import com.appnext.nativeads.NativeAdListener;
import com.appnext.nativeads.NativeAdRequest;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.wortise.ads.interstitial.InterstitialAd;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import stikerwap.appdys.config;

public class preinicio extends Activity {
    public static final int PERMISOS_CODE = 3;
    public static final int REQUEST_GOOGLE_PLAY_SERVICES = 1972;
    boolean acad_icono_cargado = false;
    boolean acad_img_cargado = false;
    AlertDialog.Builder adb;
    boolean bienvenida_mostrar = false;
    Bitmap bm_icohome = null;
    Bitmap bm_splash = null;
    String c1_sp_orig = "";
    String c_icos_orig = "";
    String cbtn;
    String cod_g;
    ConsentInformation consentInformation;
    String contra;
    boolean contra_ko = false;
    int desde_amaz;
    boolean desde_appnext = false;
    int desde_gplay;
    boolean desde_rate = false;
    ProgressDialog dialog_cargando;
    ProgressDialog dialog_enviando;
    boolean directo = false;
    CheckBox dontShowAgain;
    int espera;
    EditText et_contra;
    Bundle extras;
    FusedLocationProviderClient fusedLocationClient;
    config globales;
    long idusu;
    boolean idusu_sd;
    String img_asset = "splash_ani.gif";
    boolean marcar_guardado = true;
    boolean mostrar_ad_entrar;
    boolean mostrar_fb_entrar;
    int ord_secc_abrir;
    ProgressDialog pd_espera;
    boolean preiniciar_3_llamado = false;
    boolean preiniciar_bv_llamado = false;
    InstallReferrerClient referrerClient;
    String result_http = "";
    Map<String, String> result_http_map;
    SharedPreferences settings;
    Thread th_espera;

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02e7  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0111=Splitter:B:24:0x0111, B:17:0x00ce=Splitter:B:17:0x00ce} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            java.lang.String r0 = "idusu"
            java.lang.String r1 = "altres/"
            java.lang.String r2 = "sh"
            r3 = 0
            android.content.SharedPreferences r2 = r11.getSharedPreferences(r2, r3)
            r11.settings = r2
            java.lang.String r4 = "c1_sp"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.getString(r4, r5)
            r11.c1_sp_orig = r2
            android.content.SharedPreferences r2 = r11.settings
            java.lang.String r6 = "c_icos"
            java.lang.String r2 = r2.getString(r6, r5)
            r11.c_icos_orig = r2
            android.content.Intent r2 = r11.getIntent()
            android.os.Bundle r2 = r2.getExtras()
            r11.extras = r2
            java.lang.String r2 = r11.c1_sp_orig
            java.lang.String r6 = r11.c_icos_orig
            java.lang.String r2 = stikerwap.appdys.config.aplicar_color_dialog(r2, r6)
            r11.cbtn = r2
            java.lang.String r2 = r11.c1_sp_orig
            boolean r2 = r2.equals(r5)
            java.lang.String r6 = "#"
            if (r2 != 0) goto L_0x005a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r6)
            java.lang.String r7 = r11.c1_sp_orig
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            boolean r2 = stikerwap.appdys.config.esClaro(r2)
            if (r2 != 0) goto L_0x005a
            r2 = 2131952478(0x7f13035e, float:1.95414E38)
            r11.setTheme(r2)
        L_0x005a:
            super.onCreate(r12)
            android.os.Bundle r12 = r11.extras
            r2 = 1
            if (r12 == 0) goto L_0x0074
            java.lang.String r7 = "directo"
            boolean r12 = r12.containsKey(r7)
            if (r12 == 0) goto L_0x0074
            android.os.Bundle r12 = r11.extras
            boolean r12 = r12.getBoolean(r7, r3)
            if (r12 == 0) goto L_0x0074
            r11.directo = r2
        L_0x0074:
            r12 = 2131558685(0x7f0d011d, float:1.8742693E38)
            r11.setContentView(r12)
            android.content.Context r12 = r11.getApplicationContext()
            stikerwap.appdys.config r12 = (stikerwap.appdys.config) r12
            r11.globales = r12
            android.content.SharedPreferences r7 = r11.settings
            java.lang.String r8 = "ft"
            java.lang.String r9 = "0"
            java.lang.String r7 = r7.getString(r8, r9)
            int r7 = java.lang.Integer.parseInt(r7)
            r12.establecerFuente(r7)
            java.lang.String r12 = "mounted"
            java.lang.String r7 = android.os.Environment.getExternalStorageState()
            boolean r12 = r12.equals(r7)
            r7 = 16908299(0x102000b, float:2.387726E-38)
            r8 = 2131886114(0x7f120022, float:1.9406798E38)
            if (r12 != 0) goto L_0x00de
            android.app.AlertDialog$Builder r12 = new android.app.AlertDialog$Builder
            r12.<init>(r11)
            stikerwap.appdys.preinicio$1 r0 = new stikerwap.appdys.preinicio$1
            r0.<init>()
            android.app.AlertDialog$Builder r12 = r12.setPositiveButton(r8, r0)
            r0 = 2131886609(0x7f120211, float:1.9407802E38)
            android.app.AlertDialog$Builder r12 = r12.setMessage(r0)
            android.app.AlertDialog r12 = r12.create()
            java.lang.String r0 = r11.cbtn
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x00ce
            stikerwap.appdys.preinicio$2 r0 = new stikerwap.appdys.preinicio$2
            r0.<init>(r12)
            r12.setOnShowListener(r0)
        L_0x00ce:
            r12.show()     // Catch:{ Exception -> 0x03c4 }
            android.view.View r12 = r12.findViewById(r7)     // Catch:{ Exception -> 0x03c4 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x03c4 }
            android.graphics.Typeface r0 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x03c4 }
            r12.setTypeface(r0)     // Catch:{ Exception -> 0x03c4 }
            goto L_0x03c4
        L_0x00de:
            android.content.SharedPreferences r12 = r11.settings
            java.lang.String r9 = "dadodebaja"
            boolean r12 = r12.getBoolean(r9, r3)
            if (r12 == 0) goto L_0x0121
            android.app.AlertDialog$Builder r12 = new android.app.AlertDialog$Builder
            r12.<init>(r11)
            stikerwap.appdys.preinicio$3 r0 = new stikerwap.appdys.preinicio$3
            r0.<init>()
            android.app.AlertDialog$Builder r12 = r12.setPositiveButton(r8, r0)
            r0 = 2131886632(0x7f120228, float:1.9407848E38)
            android.app.AlertDialog$Builder r12 = r12.setMessage(r0)
            android.app.AlertDialog r12 = r12.create()
            java.lang.String r0 = r11.cbtn
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0111
            stikerwap.appdys.preinicio$4 r0 = new stikerwap.appdys.preinicio$4
            r0.<init>(r12)
            r12.setOnShowListener(r0)
        L_0x0111:
            r12.show()     // Catch:{ Exception -> 0x03c4 }
            android.view.View r12 = r12.findViewById(r7)     // Catch:{ Exception -> 0x03c4 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x03c4 }
            android.graphics.Typeface r0 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x03c4 }
            r12.setTypeface(r0)     // Catch:{ Exception -> 0x03c4 }
            goto L_0x03c4
        L_0x0121:
            boolean r12 = r11.directo
            r7 = 0
            if (r12 != 0) goto L_0x0141
            android.content.SharedPreferences r12 = r11.settings
            android.content.SharedPreferences$Editor r12 = r12.edit()
            android.content.SharedPreferences r9 = r11.settings
            java.lang.String r10 = "n_opens"
            int r9 = r9.getInt(r10, r3)
            int r9 = r9 + r2
            r12.putInt(r10, r9)
            java.lang.String r9 = "f_ult_notif"
            r12.putLong(r9, r7)
            r12.commit()
        L_0x0141:
            android.content.SharedPreferences r12 = r11.settings     // Catch:{ ClassCastException -> 0x014a }
            long r9 = r12.getLong(r0, r7)     // Catch:{ ClassCastException -> 0x014a }
            r11.idusu = r9     // Catch:{ ClassCastException -> 0x014a }
            goto L_0x0167
        L_0x014a:
            android.content.SharedPreferences r12 = r11.settings
            int r12 = r12.getInt(r0, r3)
            long r9 = (long) r12
            r11.idusu = r9
            android.content.SharedPreferences r12 = r11.settings
            android.content.SharedPreferences$Editor r12 = r12.edit()
            r12.remove(r0)
            r12.commit()
            long r9 = r11.idusu
            r12.putLong(r0, r9)
            r12.commit()
        L_0x0167:
            android.content.SharedPreferences r12 = r11.settings
            java.lang.String r0 = "cod_g"
            java.lang.String r12 = r12.getString(r0, r5)
            r11.cod_g = r12
            r11.idusu_sd = r3
            long r9 = r11.idusu
            int r12 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x01bb
            java.io.File r12 = r11.getFilesDir()     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            java.lang.String r9 = "vinebre_ac.txt"
            r0.<init>(r12, r9)     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            boolean r12 = r0.exists()     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            if (r12 == 0) goto L_0x01bb
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r12.<init>(r0)     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r9.<init>(r12)     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r0.<init>(r9)     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            java.lang.String r0 = r0.readLine()     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r12.close()     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            java.lang.String r12 = "@"
            java.lang.String[] r12 = r0.split(r12)     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r0 = r12[r3]     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            long r9 = (long) r0     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r11.idusu = r9     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            int r0 = r12.length     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            if (r0 <= r2) goto L_0x01b7
            r12 = r12[r2]     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            r11.cod_g = r12     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
        L_0x01b7:
            r11.idusu_sd = r2     // Catch:{ FileNotFoundException | IOException | Exception -> 0x01ba }
            goto L_0x01bb
        L_0x01ba:
        L_0x01bb:
            long r9 = r11.idusu
            int r12 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r12 <= 0) goto L_0x02ea
            int r12 = android.os.Build.VERSION.SDK_INT
            r0 = 20
            if (r12 <= r0) goto L_0x01de
            android.content.SharedPreferences r12 = r11.settings
            java.lang.String r0 = "c1"
            java.lang.String r12 = r12.getString(r0, r5)
            boolean r12 = r12.equals(r5)
            if (r12 != 0) goto L_0x01de
            android.content.SharedPreferences r12 = r11.settings
            java.lang.String r12 = r12.getString(r0, r5)
            stikerwap.appdys.config.aplicar_color_top(r11, r12)
        L_0x01de:
            boolean r12 = r11.directo
            if (r12 != 0) goto L_0x02ea
            android.content.SharedPreferences r12 = r11.settings
            java.lang.String r0 = "sa"
            int r12 = r12.getInt(r0, r3)
            if (r12 <= 0) goto L_0x0214
            android.content.SharedPreferences r12 = r11.settings
            int r12 = r12.getInt(r0, r3)
            int r0 = stikerwap.appdys.config.getAppVersion(r11)
            if (r12 > r0) goto L_0x0214
            android.content.res.Resources r12 = r11.getResources()
            android.content.res.AssetManager r12 = r12.getAssets()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0213 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0213 }
            java.lang.String r1 = r11.img_asset     // Catch:{ IOException -> 0x0213 }
            r0.append(r1)     // Catch:{ IOException -> 0x0213 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0213 }
            r12.open(r0)     // Catch:{ IOException -> 0x0213 }
            r12 = 1
            goto L_0x0215
        L_0x0213:
        L_0x0214:
            r12 = 0
        L_0x0215:
            if (r12 != 0) goto L_0x02e7
            r12 = 2131362501(0x7f0a02c5, float:1.8344784E38)
            android.view.View r0 = r11.findViewById(r12)
            r0.setVisibility(r3)
            java.lang.String r0 = "splash"
            java.io.FileInputStream r0 = r11.openFileInput(r0)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x0237 }
            java.io.FileDescriptor r1 = r0.getFD()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x0237 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFileDescriptor(r1)     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x0237 }
            r11.bm_splash = r1     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x0237 }
            r0.close()     // Catch:{ FileNotFoundException | IOException | OutOfMemoryError -> 0x0237 }
            r0 = 1
            goto L_0x0239
        L_0x0237:
            r0 = 0
        L_0x0239:
            if (r0 == 0) goto L_0x02ea
            android.content.SharedPreferences r0 = r11.settings
            java.lang.String r0 = r0.getString(r4, r5)
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x028d
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r7 = 2
            int[] r7 = new int[r7]
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            android.content.SharedPreferences r9 = r11.settings
            java.lang.String r4 = r9.getString(r4, r5)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r7[r3] = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            android.content.SharedPreferences r6 = r11.settings
            java.lang.String r8 = "c2_sp"
            java.lang.String r6 = r6.getString(r8, r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r7[r2] = r4
            r0.<init>(r1, r7)
            r1 = 2131362315(0x7f0a020b, float:1.8344407E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setBackgroundDrawable(r0)
        L_0x028d:
            android.view.View r12 = r11.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            android.content.SharedPreferences r0 = r11.settings
            java.lang.String r1 = "i"
            java.lang.String r0 = r0.getString(r1, r5)
            boolean r1 = r0.equals(r5)
            if (r1 != 0) goto L_0x02cd
            int r1 = r0.length()
            r4 = 12
            r6 = 13
            if (r1 <= r4) goto L_0x02b9
            stikerwap.appdys.config r1 = r11.globales
            java.lang.String r4 = r0.substring(r4, r6)
            java.lang.String r7 = "1"
            boolean r4 = r4.equals(r7)
            r1.splash_margen = r4
        L_0x02b9:
            int r1 = r0.length()
            if (r1 <= r6) goto L_0x02cd
            stikerwap.appdys.config r1 = r11.globales
            r4 = 14
            java.lang.String r0 = r0.substring(r6, r4)
            int r0 = java.lang.Integer.parseInt(r0)
            r1.splash_tipo = r0
        L_0x02cd:
            stikerwap.appdys.config r0 = r11.globales     // Catch:{ Exception -> 0x02dd }
            boolean r1 = r0.splash_margen     // Catch:{ Exception -> 0x02dd }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x02dd }
            stikerwap.appdys.config r4 = r11.globales     // Catch:{ Exception -> 0x02dd }
            int r4 = r4.splash_tipo     // Catch:{ Exception -> 0x02dd }
            r0.tratar_fondo(r12, r1, r4)     // Catch:{ Exception -> 0x02dd }
            goto L_0x02e1
        L_0x02dd:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02e1:
            android.graphics.Bitmap r0 = r11.bm_splash
            r12.setImageBitmap(r0)
            goto L_0x02ea
        L_0x02e7:
            r11.mostrar_splash_deasset()
        L_0x02ea:
            r11.desde_gplay = r3
            r11.desde_amaz = r3
            android.content.pm.PackageManager r12 = r11.getPackageManager()
            java.lang.String r0 = r11.getPackageName()     // Catch:{ Exception -> 0x0317 }
            android.content.pm.ApplicationInfo r0 = r12.getApplicationInfo(r0, r3)     // Catch:{ Exception -> 0x0317 }
            java.lang.String r0 = r0.packageName     // Catch:{ Exception -> 0x0317 }
            java.lang.String r12 = r12.getInstallerPackageName(r0)     // Catch:{ Exception -> 0x0317 }
            if (r12 == 0) goto L_0x0317
            java.lang.String r0 = "com.android.vending"
            boolean r0 = r0.equals(r12)     // Catch:{ Exception -> 0x0317 }
            if (r0 == 0) goto L_0x030d
            r11.desde_gplay = r2     // Catch:{ Exception -> 0x0317 }
            goto L_0x0317
        L_0x030d:
            java.lang.String r0 = "com.amazon.venezia"
            boolean r12 = r0.equals(r12)     // Catch:{ Exception -> 0x0317 }
            if (r12 == 0) goto L_0x0317
            r11.desde_amaz = r2     // Catch:{ Exception -> 0x0317 }
        L_0x0317:
            r12 = 0
            stikerwap.appdys.config.interstitial_glob = r12
            stikerwap.appdys.config.finalizar_app = r3
            stikerwap.appdys.config.appnext_glob_int = r12
            stikerwap.appdys.config.st_glob_int = r12
            stikerwap.appdys.config.fb_glob_int = r12
            stikerwap.appdys.config.wortise_glob_int = r12
            stikerwap.appdys.config.pangle_glob_int = r12
            stikerwap.appdys.config.liftoff_glob_int = r12
            stikerwap.appdys.config.mint_glob_int = r12
            stikerwap.appdys.config r0 = r11.globales
            r0.startapp_ads = r12
            stikerwap.appdys.config r0 = r11.globales
            r0.st_inchat_cod = r12
            stikerwap.appdys.config r0 = r11.globales
            r0.appnext_ads = r12
            stikerwap.appdys.config r0 = r11.globales
            r0.appnext_inchat_cod = r12
            stikerwap.appdys.config r0 = r11.globales
            r0.instal_int_url = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.pa_int_url = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.uni_appid = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.uni_b_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.uni_pro_cod = r5
            stikerwap.appdys.config.uni_int_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.uni_rew_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_appid = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_b_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_pro_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_menu_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_radio_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_qr_cod = r5
            stikerwap.appdys.config.is_int_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_rew_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.is_card_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_appid = r5
            stikerwap.appdys.config.wortise_int_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_rew_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_menu_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_b_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_pro_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_radio_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_qr_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.wortise_card_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.monedata_appid = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.pangle_appid = r5
            stikerwap.appdys.config.pangle_int_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.liftoff_appid = r5
            stikerwap.appdys.config.liftoff_int_cod = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.mint_appid = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.mint_appkey = r5
            stikerwap.appdys.config.mint_int_cod_place = r5
            stikerwap.appdys.config.mint_int_cod_unit = r5
            stikerwap.appdys.config r0 = r11.globales
            r0.acad_tit = r5
            stikerwap.appdys.config.hsv_x = r3
            stikerwap.appdys.preinicio$cargarconfig r0 = new stikerwap.appdys.preinicio$cargarconfig
            r0.<init>()
            java.lang.String[] r12 = new java.lang.String[r3]
            r0.execute(r12)
        L_0x03c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.onCreate(android.os.Bundle):void");
    }

    private class cargarconfig extends AsyncTask<String, Void, Byte> {
        private cargarconfig() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:36|35|39|40|(0)|43) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x01b4, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x01b5, code lost:
            r2 = r9;
            r9 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01be, code lost:
            r9.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c4, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x01b8 */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01be  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01c4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r9) {
            /*
                r8 = this;
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                boolean r9 = r9.directo
                r0 = 0
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
                if (r9 == 0) goto L_0x000c
                return r0
            L_0x000c:
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                boolean r9 = r9.idusu_sd
                java.lang.String r1 = ""
                if (r9 == 0) goto L_0x0017
                java.lang.String r9 = "&recup_todo=1"
                goto L_0x0018
            L_0x0017:
                r9 = r1
            L_0x0018:
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r2 = r2.settings
                java.lang.String r3 = "fultsync"
                java.lang.String r4 = "010100000000"
                java.lang.String r2 = r2.getString(r3, r4)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.os.Bundle r3 = r3.extras
                if (r3 == 0) goto L_0x005c
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.os.Bundle r3 = r3.extras
                java.lang.String r4 = "notif_id"
                java.lang.String r3 = r3.getString(r4)
                if (r3 == 0) goto L_0x005c
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.os.Bundle r3 = r3.extras
                java.lang.String r3 = r3.getString(r4)
                java.lang.String r5 = "0"
                boolean r3 = r3.equals(r5)
                if (r3 != 0) goto L_0x005c
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "&notif="
                r1.<init>(r3)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.os.Bundle r3 = r3.extras
                java.lang.String r3 = r3.getString(r4)
                r1.append(r3)
                java.lang.String r1 = r1.toString()
            L_0x005c:
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.os.Bundle r3 = r3.extras
                r4 = 1
                if (r3 == 0) goto L_0x00a1
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.os.Bundle r3 = r3.extras
                java.lang.String r5 = "idnotif_marcar"
                boolean r3 = r3.containsKey(r5)
                if (r3 == 0) goto L_0x00a1
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r3 = r3.settings
                android.content.SharedPreferences$Editor r3 = r3.edit()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "notif_"
                r6.<init>(r7)
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                android.os.Bundle r7 = r7.extras
                int r5 = r7.getInt(r5)
                r6.append(r5)
                java.lang.String r5 = "_leida"
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                r3.putBoolean(r5, r4)
                r3.commit()
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.content.Context r3 = r3.getApplicationContext()
                stikerwap.appdys.config.act_notif_noleidas(r3)
            L_0x00a1:
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                android.content.ContentResolver r3 = r3.getContentResolver()
                java.lang.String r5 = "android_id"
                java.lang.String r3 = android.provider.Settings.Secure.getString(r3, r5)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = stikerwap.appdys.config.PROTOC_GEN
                r5.append(r6)
                java.lang.String r6 = "config."
                r5.append(r6)
                java.lang.String r6 = stikerwap.appdys.config.DOM_EDROID
                r5.append(r6)
                java.lang.String r6 = "/srv/config.php?v=172&vname="
                r5.append(r6)
                stikerwap.appdys.preinicio r6 = stikerwap.appdys.preinicio.this
                java.lang.String r6 = stikerwap.appdys.config.getAppVersionName(r6)
                r5.append(r6)
                java.lang.String r6 = "&idapp=3008836&idusu="
                r5.append(r6)
                stikerwap.appdys.preinicio r6 = stikerwap.appdys.preinicio.this
                long r6 = r6.idusu
                r5.append(r6)
                java.lang.String r6 = "&cod_g="
                r5.append(r6)
                stikerwap.appdys.preinicio r6 = stikerwap.appdys.preinicio.this
                java.lang.String r6 = r6.cod_g
                r5.append(r6)
                java.lang.String r6 = "&gp="
                r5.append(r6)
                stikerwap.appdys.preinicio r6 = stikerwap.appdys.preinicio.this
                int r6 = r6.desde_gplay
                r5.append(r6)
                java.lang.String r6 = "&am="
                r5.append(r6)
                stikerwap.appdys.preinicio r6 = stikerwap.appdys.preinicio.this
                int r6 = r6.desde_amaz
                r5.append(r6)
                java.lang.String r6 = "&idl="
                r5.append(r6)
                java.util.Locale r6 = java.util.Locale.getDefault()
                java.lang.String r6 = r6.getLanguage()
                r5.append(r6)
                java.lang.String r6 = "&pa_env=1&pa="
                r5.append(r6)
                java.util.Locale r6 = java.util.Locale.getDefault()
                java.lang.String r6 = r6.getCountry()
                r5.append(r6)
                java.lang.String r6 = "&pn="
                r5.append(r6)
                stikerwap.appdys.preinicio r6 = stikerwap.appdys.preinicio.this
                java.lang.String r6 = r6.getPackageName()
                r5.append(r6)
                java.lang.String r6 = "&fus="
                r5.append(r6)
                r5.append(r2)
                r5.append(r9)
                r5.append(r1)
                java.lang.String r9 = "&aid="
                r5.append(r9)
                r5.append(r3)
                java.lang.String r9 = r5.toString()
                r1 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x01c8 }
                r2.<init>(r9)     // Catch:{ MalformedURLException -> 0x01c8 }
                r9 = 0
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x01b8 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x01b8 }
                r2.setDoInput(r4)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r9 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r9)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r2.setReadTimeout(r9)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.String r9 = "User-Agent"
                java.lang.String r3 = "Android Vinebre Software"
                r2.setRequestProperty(r9, r3)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.io.InputStream r9 = r2.getInputStream()     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r4.<init>(r9)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r9.<init>()     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
            L_0x0179:
                java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                if (r4 == 0) goto L_0x0194
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r5.<init>()     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r5.append(r4)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.String r4 = "\n"
                r5.append(r4)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r9.append(r4)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                goto L_0x0179
            L_0x0194:
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r3.result_http = r9     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.String r3 = r9.result_http     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                java.lang.String r4 = "@EURO@"
                java.lang.String r5 = "€"
                java.lang.String r3 = r3.replace(r4, r5)     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                r9.result_http = r3     // Catch:{ Exception -> 0x01b2, all -> 0x01b0 }
                if (r2 == 0) goto L_0x01af
                r2.disconnect()
            L_0x01af:
                return r0
            L_0x01b0:
                r9 = move-exception
                goto L_0x01c2
            L_0x01b2:
                r9 = r2
                goto L_0x01b8
            L_0x01b4:
                r0 = move-exception
                r2 = r9
                r9 = r0
                goto L_0x01c2
            L_0x01b8:
                java.lang.Byte r0 = java.lang.Byte.valueOf(r1)     // Catch:{ all -> 0x01b4 }
                if (r9 == 0) goto L_0x01c1
                r9.disconnect()
            L_0x01c1:
                return r0
            L_0x01c2:
                if (r2 == 0) goto L_0x01c7
                r2.disconnect()
            L_0x01c7:
                throw r9
            L_0x01c8:
                r9 = move-exception
                r9.printStackTrace()
                java.lang.Byte r9 = java.lang.Byte.valueOf(r1)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargarconfig.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (!preinicio.this.directo) {
                preinicio.this.mostrar_pb(R.string.inicializando);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: stikerwap.appdys.preinicio$cargarconfig} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: android.content.SharedPreferences$Editor} */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x02a5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x16d3  */
        /* JADX WARNING: Removed duplicated region for block: B:194:0x1734  */
        /* JADX WARNING: Removed duplicated region for block: B:195:0x1749  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x1751  */
        /* JADX WARNING: Removed duplicated region for block: B:306:0x20a9  */
        /* JADX WARNING: Removed duplicated region for block: B:307:0x20b5  */
        /* JADX WARNING: Removed duplicated region for block: B:326:0x1b7e A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.Byte r26) {
            /*
                r25 = this;
                r1 = r25
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                r0.result_http_map = r2
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.lang.String r0 = r0.result_http
                java.lang.String r2 = "\\]"
                java.lang.String[] r0 = r0.split(r2)
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                r3 = 0
                r2.result_http = r3
                r2 = 0
                r4 = 0
            L_0x001c:
                int r5 = r0.length
                java.lang.String r6 = ""
                r7 = 2
                r8 = 1
                if (r4 >= r5) goto L_0x0065
                r5 = r0[r4]
                java.lang.String r9 = "="
                java.lang.String[] r5 = r5.split(r9, r7)
                r0[r4] = r3
                int r7 = r5.length
                if (r7 <= 0) goto L_0x0062
                r7 = r5[r2]
                boolean r7 = r7.equals(r3)
                if (r7 != 0) goto L_0x0062
                r7 = r5[r2]
                int r7 = r7.length()
                if (r7 <= r8) goto L_0x0062
                r7 = r5[r2]
                java.lang.String r7 = r7.substring(r8)
                int r9 = r5.length
                if (r9 <= r8) goto L_0x005b
                r9 = r5[r8]
                boolean r9 = r9.equals(r3)
                if (r9 != 0) goto L_0x005b
                r9 = r5[r8]
                int r9 = r9.length()
                if (r9 <= 0) goto L_0x005b
                r6 = r5[r8]
            L_0x005b:
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r5 = r5.result_http_map
                r5.put(r7, r6)
            L_0x0062:
                int r4 = r4 + 1
                goto L_0x001c
            L_0x0065:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.ocultar_pb()
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r0 = r0.result_http_map
                java.lang.String r4 = "FIN"
                boolean r0 = r0.containsKey(r4)
                if (r0 != 0) goto L_0x00a7
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r0 = r0.result_http_map
                r0.clear()
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.marcar_guardado = r2
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                long r4 = r0.idusu
                r9 = 0
                int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r0 == 0) goto L_0x0091
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                boolean r0 = r0.idusu_sd
                if (r0 == 0) goto L_0x00a7
            L_0x0091:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r2 = 2131886359(0x7f120117, float:1.9407295E38)
                java.lang.String r2 = r0.getString(r2)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                r4 = 2131886358(0x7f120116, float:1.9407293E38)
                java.lang.String r3 = r3.getString(r4)
                r0.mostrar_error(r2, r3)
                return
            L_0x00a7:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r0 = r0.result_http_map
                java.lang.String r4 = "sac"
                boolean r0 = r0.containsKey(r4)
                java.lang.String r4 = "sin_acceso"
                if (r0 == 0) goto L_0x00cf
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r0 = r0.settings
                boolean r0 = r0.contains(r4)
                if (r0 != 0) goto L_0x00e8
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r0 = r0.settings
                android.content.SharedPreferences$Editor r0 = r0.edit()
                android.content.SharedPreferences$Editor r0 = r0.putBoolean(r4, r8)
                r0.commit()
                goto L_0x00e8
            L_0x00cf:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r0 = r0.settings
                boolean r0 = r0.contains(r4)
                if (r0 == 0) goto L_0x00e8
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r0 = r0.settings
                android.content.SharedPreferences$Editor r0 = r0.edit()
                android.content.SharedPreferences$Editor r0 = r0.remove(r4)
                r0.commit()
            L_0x00e8:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r0 = r0.result_http_map
                java.lang.String r4 = "APLICNODISP"
                boolean r0 = r0.containsKey(r4)
                if (r0 == 0) goto L_0x0101
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r2 = 2131886357(0x7f120115, float:1.940729E38)
                java.lang.String r2 = r0.getString(r2)
                r0.mostrar_error(r6, r2)
                return
            L_0x0101:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.lang.String r4 = "msg_err"
                java.lang.String r0 = r0.leer_map(r4)
                boolean r4 = r0.equals(r6)
                if (r4 != 0) goto L_0x011d
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                java.lang.String r3 = "msg_err_tit"
                java.lang.String r2 = r2.leer_map(r3)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                r3.mostrar_error(r2, r0)
                return
            L_0x011d:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r0 = r0.settings
                java.lang.String r4 = "imgs"
                java.lang.String r0 = r0.getString(r4, r6)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r5 = r5.result_http_map
                boolean r5 = r5.containsKey(r4)
                if (r5 == 0) goto L_0x014f
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.lang.String r0 = r0.leer_map(r4)
                boolean r5 = r0.equals(r6)
                if (r5 != 0) goto L_0x0157
                stikerwap.appdys.config.DOM_CDN = r0
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r5 = r5.settings
                android.content.SharedPreferences$Editor r5 = r5.edit()
                android.content.SharedPreferences$Editor r0 = r5.putString(r4, r0)
                r0.apply()
                goto L_0x0157
            L_0x014f:
                boolean r4 = r0.equals(r6)
                if (r4 != 0) goto L_0x0157
                stikerwap.appdys.config.DOM_CDN = r0
            L_0x0157:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                boolean r0 = r0.directo
                if (r0 != 0) goto L_0x020e
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                int r0 = r0.desde_gplay
                if (r0 != 0) goto L_0x020e
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.os.Bundle r0 = r0.extras
                if (r0 == 0) goto L_0x018d
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.os.Bundle r0 = r0.extras
                java.lang.String r4 = "notif_id"
                java.lang.String r0 = r0.getString(r4)
                if (r0 != 0) goto L_0x020e
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.os.Bundle r0 = r0.extras
                java.lang.String r4 = "notif_idtema"
                java.lang.String r0 = r0.getString(r4)
                if (r0 != 0) goto L_0x020e
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.os.Bundle r0 = r0.extras
                java.lang.String r4 = "id_remit"
                java.lang.String r0 = r0.getString(r4)
                if (r0 != 0) goto L_0x020e
            L_0x018d:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.lang.String r4 = "v"
                java.lang.String r0 = r0.leer_map(r4)
                boolean r4 = r0.equals(r6)
                if (r4 != 0) goto L_0x020e
                int r4 = java.lang.Integer.parseInt(r0)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this     // Catch:{ NameNotFoundException -> 0x01b2 }
                android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x01b2 }
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this     // Catch:{ NameNotFoundException -> 0x01b2 }
                java.lang.String r9 = r9.getPackageName()     // Catch:{ NameNotFoundException -> 0x01b2 }
                android.content.pm.PackageInfo r5 = r5.getPackageInfo(r9, r2)     // Catch:{ NameNotFoundException -> 0x01b2 }
                int r5 = r5.versionCode     // Catch:{ NameNotFoundException -> 0x01b2 }
                goto L_0x01b3
            L_0x01b2:
                r5 = -1
            L_0x01b3:
                r9 = -1
                if (r5 == r9) goto L_0x020e
                if (r5 >= r4) goto L_0x020e
                android.app.AlertDialog$Builder r3 = new android.app.AlertDialog$Builder
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                r3.<init>(r4)
                android.app.AlertDialog$Builder r2 = r3.setCancelable(r2)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                r4 = 2131886325(0x7f1200f5, float:1.9407226E38)
                java.lang.String r3 = r3.getString(r4)
                stikerwap.appdys.preinicio$cargarconfig$1 r4 = new stikerwap.appdys.preinicio$cargarconfig$1
                r4.<init>(r0)
                android.app.AlertDialog$Builder r0 = r2.setPositiveButton(r3, r4)
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131886613(0x7f120215, float:1.940781E38)
                java.lang.String r2 = r2.getString(r3)
                android.app.AlertDialog$Builder r0 = r0.setMessage(r2)
                android.app.AlertDialog r0 = r0.create()
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                java.lang.String r2 = r2.cbtn
                boolean r2 = r2.equals(r6)
                if (r2 != 0) goto L_0x01fc
                stikerwap.appdys.preinicio$cargarconfig$2 r2 = new stikerwap.appdys.preinicio$cargarconfig$2
                r2.<init>(r0)
                r0.setOnShowListener(r2)
            L_0x01fc:
                r0.show()     // Catch:{ Exception -> 0x01ff }
            L_0x01ff:
                r2 = 16908299(0x102000b, float:2.387726E-38)
                android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x020d }
                android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x020d }
                android.graphics.Typeface r2 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x020d }
                r0.setTypeface(r2)     // Catch:{ Exception -> 0x020d }
            L_0x020d:
                return
            L_0x020e:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r0 = r0.settings
                android.content.SharedPreferences$Editor r0 = r0.edit()
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r5 = "idusu"
                java.lang.String r4 = r4.leer_map(r5)
                boolean r5 = r4.equals(r6)
                if (r5 != 0) goto L_0x02b5
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.String r9 = "cod"
                r5.establec(r9, r7, r0)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                long r9 = java.lang.Long.parseLong(r4)
                r5.idusu = r9
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                long r9 = r5.idusu
                java.lang.String r5 = "idusu"
                r0.putLong(r5, r9)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.String r9 = "cod_g"
                java.lang.String r5 = r5.leer_map(r9)
                boolean r9 = r5.equals(r6)
                if (r9 == 0) goto L_0x024e
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.String r5 = r5.cod_g
            L_0x024e:
                boolean r9 = r5.equals(r6)
                if (r9 != 0) goto L_0x0261
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                r9.cod_g = r5
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.String r5 = r5.cod_g
                java.lang.String r9 = "cod_g"
                r0.putString(r9, r5)
            L_0x0261:
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x02b3, all -> 0x02ae }
                java.io.File r5 = r5.getFilesDir()     // Catch:{ Exception -> 0x02b3, all -> 0x02ae }
                java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x02b3, all -> 0x02ae }
                java.lang.String r10 = "vinebre_ac.txt"
                r9.<init>(r5, r10)     // Catch:{ Exception -> 0x02b3, all -> 0x02ae }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x02b3, all -> 0x02ae }
                r5.<init>(r9)     // Catch:{ Exception -> 0x02b3, all -> 0x02ae }
                java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                java.io.OutputStreamWriter r10 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                r10.<init>(r5)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                r9.<init>(r10)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                stikerwap.appdys.preinicio r10 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                java.lang.String r10 = r10.cod_g     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                boolean r10 = r10.equals(r6)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                if (r10 != 0) goto L_0x029f
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                r10.<init>()     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                r10.append(r4)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                java.lang.String r4 = "@"
                r10.append(r4)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                java.lang.String r4 = r4.cod_g     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                r10.append(r4)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                java.lang.String r4 = r10.toString()     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
            L_0x029f:
                r9.write(r4)     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
                r9.close()     // Catch:{ Exception -> 0x02a5, all -> 0x02ab }
            L_0x02a5:
                r5.close()     // Catch:{ Exception -> 0x02a9 }
                goto L_0x02b5
            L_0x02a9:
                goto L_0x02b5
            L_0x02ab:
                r0 = move-exception
                r3 = r5
                goto L_0x02af
            L_0x02ae:
                r0 = move-exception
            L_0x02af:
                r3.close()     // Catch:{ Exception -> 0x02b2 }
            L_0x02b2:
                throw r0
            L_0x02b3:
                r5 = r3
                goto L_0x02a5
            L_0x02b5:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                boolean r4 = r4.directo
                if (r4 != 0) goto L_0x0323
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                boolean r4 = r4.checkPlayServices()
                if (r4 == 0) goto L_0x02df
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.String r5 = "SENT_TOKEN_TO_SERVER"
                boolean r4 = r4.getBoolean(r5, r2)
                if (r4 != 0) goto L_0x02df
                android.content.Intent r4 = new android.content.Intent
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.Class<stikerwap.appdys.RegistrationIntentService> r9 = stikerwap.appdys.RegistrationIntentService.class
                r4.<init>(r5, r9)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x02de }
                r5.startService(r4)     // Catch:{ Exception -> 0x02de }
                goto L_0x02df
            L_0x02de:
            L_0x02df:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.pm.PackageManager r4 = r4.getPackageManager()
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.String r5 = r5.getPackageName()
                java.lang.String r9 = "android.permission.ACCESS_FINE_LOCATION"
                int r4 = r4.checkPermission(r9, r5)
                if (r4 == 0) goto L_0x0307
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.pm.PackageManager r4 = r4.getPackageManager()
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                java.lang.String r5 = r5.getPackageName()
                java.lang.String r9 = "android.permission.ACCESS_COARSE_LOCATION"
                int r4 = r4.checkPermission(r9, r5)
                if (r4 != 0) goto L_0x0323
            L_0x0307:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0322 }
                com.google.android.gms.location.FusedLocationProviderClient r5 = com.google.android.gms.location.LocationServices.getFusedLocationProviderClient((android.app.Activity) r4)     // Catch:{ Exception -> 0x0322 }
                r4.fusedLocationClient = r5     // Catch:{ Exception -> 0x0322 }
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0322 }
                com.google.android.gms.location.FusedLocationProviderClient r4 = r4.fusedLocationClient     // Catch:{ Exception -> 0x0322 }
                com.google.android.gms.tasks.Task r4 = r4.getLastLocation()     // Catch:{ Exception -> 0x0322 }
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0322 }
                stikerwap.appdys.preinicio$cargarconfig$3 r9 = new stikerwap.appdys.preinicio$cargarconfig$3     // Catch:{ Exception -> 0x0322 }
                r9.<init>()     // Catch:{ Exception -> 0x0322 }
                r4.addOnSuccessListener((android.app.Activity) r5, r9)     // Catch:{ Exception -> 0x0322 }
                goto L_0x0323
            L_0x0322:
            L_0x0323:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r5 = "f_p_elim"
                java.lang.String r4 = r4.leer_map(r5)
                java.lang.String r5 = "1"
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0342
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0341 }
                stikerwap.appdys.config r4 = r4.globales     // Catch:{ Exception -> 0x0341 }
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0341 }
                java.io.File r4 = r4.getTempFile(r9, r8)     // Catch:{ Exception -> 0x0341 }
                r4.delete()     // Catch:{ Exception -> 0x0341 }
                goto L_0x0342
            L_0x0341:
            L_0x0342:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r9 = "splash"
                java.lang.String r4 = r4.leer_map(r9)
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L_0x0365
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r10 = "c1_sp"
                r4.establec(r10, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r10 = "c2_sp"
                r4.establec(r10, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r10 = "sp_i"
                r4.establec(r10, r7, r0)
            L_0x0365:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r4 = r4.result_http_map
                java.lang.String r10 = "adotro2_cod"
                boolean r4 = r4.containsKey(r10)
                if (r4 == 0) goto L_0x037f
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r10 = "adotro2_cod"
                r4.establec(r10, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r10 = "adotro2_tipo"
                r4.establec(r10, r8, r0)
            L_0x037f:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r10 = "ico_share_ord"
                java.lang.String r4 = r4.leer_map(r10)
                boolean r4 = r4.equals(r6)
                java.lang.String r10 = "0"
                if (r4 != 0) goto L_0x0bd2
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "nd_t"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "nd_s"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "nd_u"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "nd_i"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ico_ofics_ord"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ico_share_ord"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ico_busc_ord"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ico_exit_ord"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ico_notif_ord"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ic_po"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ic_so"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ic_sa"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "io1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "io2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "io3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "io4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ib1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ib2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ib3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ib4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "is1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "is2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "is3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "is4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ir1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ir2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ir3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ir4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ie1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ie2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ie3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ie4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "in1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "in2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "in3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "in4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ip1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ip2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ip3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ip4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ip5"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "id1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "id2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "id3"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "id4"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pla"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "share_subject"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "share_text"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "tcn"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_cod"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_pos"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_sma"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fbb"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fbi"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fbm"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fbp"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fbr"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pfc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "stb"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "sti"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "stm"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "stp"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "str"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "iiu"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "piu"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "aai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "abc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "aic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "arc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "uai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ubc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "uic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "urc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "iai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ibc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ipc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "imc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "irc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "iqc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "iic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "iwc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "icc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_ra"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "n_ra"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "f_ra"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "st_ra"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_qr"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "n_qr"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "f_qr"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "st_qr"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "n_i_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "st_i_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ic_1"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ic_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_p_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "n_p_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "upc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_m_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "n_m_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_r_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "n_r_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_p_s"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a_m_s"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_mo"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_ms"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_pms"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.util.Map<java.lang.String, java.lang.String> r4 = r4.result_http_map
                java.lang.String r11 = "ca_a"
                boolean r4 = r4.containsKey(r11)
                if (r4 == 0) goto L_0x06a4
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r4 = r4.globales
                r4.card_nuestro = r8
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ca_a"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ca_n"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ca_f"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ca_s"
                r4.establec(r11, r7, r0)
                goto L_0x06aa
            L_0x06a4:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r4 = r4.globales
                r4.card_nuestro = r2
            L_0x06aa:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fca"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fcs"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "a"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "our"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_int_cod"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "aac"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_int_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "aicod"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "aigi"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_inte_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_ch_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "b_c"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "l_c"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fp"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cvm"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "emo"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wbc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wpc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wmc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wrc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wqc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wwc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "wcc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "mai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "lai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "lic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "miai"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "miak"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "miicp"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "miicu"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "i"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "i2"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cb"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fv"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pv"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pdv"
                r4.establec(r11, r8, r0)
                r4 = 1
            L_0x07c3:
                r11 = 6
                if (r4 >= r11) goto L_0x07dc
                stikerwap.appdys.preinicio r11 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "mb_"
                r12.<init>(r13)
                r12.append(r4)
                java.lang.String r12 = r12.toString()
                r11.establec(r12, r7, r0)
                int r4 = r4 + 1
                goto L_0x07c3
            L_0x07dc:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "mb_cbg"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "mb_cit"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vipe"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vipr"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vifo"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vivi"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "viem"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vien"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vp"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "mv"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_p"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_t_c"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_a_s"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_s_s"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_a_b"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_s_b"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_a_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_s_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "r_a"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_r"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_p"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_c"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_g"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_ap"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_fp"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_pf"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_ps"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_pde"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "cs_pdi"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "apn_v"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "apn_vi"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vi"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "acad"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "appnext_ch_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "appnext_cod"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "appnext_cod_int_e"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "appnext_cod_int_ia"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ap"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "mu"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "appnextb_cod"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_int_exit_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "admob_int_exit_r"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "adotro_cod"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "mf_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "tipomenu"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "petic_ask_nombre"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "petic_ask_email"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "petic_ask_tel"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c1"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c2"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c1c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c2c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_icos"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_icos_t"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_secc_noactiv"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_secc_activ"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_linea"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "t_ind"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_ind"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "t_mas"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "sep_secc"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_sep_secc"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c1_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c2_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_ssl"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_tit_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_sep_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_ico_sep_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_txt_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_icos_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_ir_ofic"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c1_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c2_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_txt_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_icos_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_icos_2_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_tit_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_sep_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_ico_sep_prods"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c1_prods_l"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c2_prods_l"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_perprod"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_tit_prods_l"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_precio_prods_l"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_antiguedad_prods_l"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "c_prods_det"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "splash_w"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "s_v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "s_h"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_ncols"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_padding"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_txt_radius"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_mostrar_icos"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_mostrar_txt"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_icos_izq"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_anim"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_c"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_txt_c"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_txt_b"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_e"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_txt_bg"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_txt_col"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_c1"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "m_c2"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "msl_c"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fm"
                java.lang.String r4 = r4.establec(r11, r8, r0)
                boolean r11 = r4.equals(r5)
                if (r11 == 0) goto L_0x0ad6
                java.lang.String r4 = "act_fm"
                r0.putBoolean(r4, r8)
                goto L_0x0ae1
            L_0x0ad6:
                boolean r4 = r4.equals(r10)
                if (r4 == 0) goto L_0x0ae1
                java.lang.String r4 = "act_fm"
                r0.putBoolean(r4, r2)
            L_0x0ae1:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vf"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "tm"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "dom"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "fb_m"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "vcn"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "hcn"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "conf_ex"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pp"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pp2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "notif_int"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "bv_txt"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "bv_tit"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "bv_nomas_mostrar"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "bv_nomas_def"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ps"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pd"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pt"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pm"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pz"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pe"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "ps2"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pt2"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pm2"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_tit"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_txt"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_ok"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_ko"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_1v"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_int"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "rt_t"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pwd"
                java.lang.String r4 = r4.establec(r11, r8, r0)
                boolean r11 = r4.equals(r10)
                if (r11 == 0) goto L_0x0bc7
                java.lang.String r4 = "pwd_validado"
                r0.putBoolean(r4, r8)
                goto L_0x0bd2
            L_0x0bc7:
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0bd2
                java.lang.String r4 = "pwd_validado"
                r0.putBoolean(r4, r2)
            L_0x0bd2:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "busc_campos"
                java.lang.String r4 = r4.leer_map(r11)
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L_0x0c34
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "divisa"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "busc_campos"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "busc_orden"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "busc_def"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "prods_tit"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "prods_masinfo"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "prods_comprar"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "prods_masinfo_mostrar"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "prods_linksexternos"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "prods_adaptar_ancho"
                r4.establec(r11, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pp_email"
                r4.establec(r11, r7, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r11 = "pp_div"
                r4.establec(r11, r7, r0)
            L_0x0c34:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.String r11 = "nsecc"
                int r4 = r4.getInt(r11, r2)
                stikerwap.appdys.preinicio r12 = stikerwap.appdys.preinicio.this
                java.lang.String r12 = r12.leer_map(r11)
                boolean r13 = r12.equals(r6)
                if (r13 != 0) goto L_0x0c51
                int r4 = java.lang.Integer.parseInt(r12)
                r0.putInt(r11, r4)
            L_0x0c51:
                if (r4 != 0) goto L_0x0c60
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r2 = 2131886363(0x7f12011b, float:1.9407303E38)
                java.lang.String r2 = r0.getString(r2)
                r0.mostrar_error(r6, r2)
                return
            L_0x0c60:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.String r11 = "idseccs"
                java.lang.String r4 = r4.getString(r11, r6)
                stikerwap.appdys.preinicio r12 = stikerwap.appdys.preinicio.this
                java.lang.String r12 = r12.leer_map(r11)
                boolean r13 = r12.equals(r6)
                if (r13 != 0) goto L_0x0c7a
                r0.putString(r11, r12)
                r4 = r12
            L_0x0c7a:
                java.lang.String r11 = ","
                java.lang.String[] r4 = r4.split(r11)
                r12 = 0
                r13 = 0
            L_0x0c82:
                int r14 = r4.length
                java.lang.String r15 = "_nfotos"
                java.lang.String r3 = "_idfotos"
                java.lang.String r2 = "_ord"
                if (r12 >= r14) goto L_0x1b8e
                r14 = r4[r12]
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r16 = r9
                java.lang.String r9 = "s"
                r8.<init>(r9)
                r8.append(r14)
                r8.append(r2)
                java.lang.String r8 = r8.toString()
                java.lang.String r7 = r7.leer_map(r8)
                boolean r7 = r7.equals(r6)
                if (r7 != 0) goto L_0x1696
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>(r9)
                r8.append(r14)
                r8.append(r2)
                java.lang.String r8 = r8.toString()
                r17 = r4
                r4 = 1
                r7.establec(r8, r4, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_tit"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_de"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_k"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_i"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_idgo"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ocu"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_tp"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_pl"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_h"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_r"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_d"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_r_m"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ext"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_adapt"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_stream"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_idfondo"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_vf"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fondo_modif"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_tm"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_tipo"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_url"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ua"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_html"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_pur"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_loa"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_zoo"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_i1"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_i2"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_c1"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_c2"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_c_peritem"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_c_tit"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_c_fecha"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_mostrar_img"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_mostrar_fecha"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_vin"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_v"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ptit"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ptxt"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_pwd"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                java.lang.String r4 = r4.establec(r7, r8, r0)
                boolean r7 = r4.equals(r10)
                if (r7 == 0) goto L_0x1079
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r7 = "chat"
                r4.<init>(r7)
                r4.append(r14)
                java.lang.String r7 = "_validado"
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                r0.putBoolean(r4, r8)
                goto L_0x1096
            L_0x1079:
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x1096
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r7 = "chat"
                r4.<init>(r7)
                r4.append(r14)
                java.lang.String r7 = "_validado"
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                r7 = 0
                r0.putBoolean(r4, r7)
            L_0x1096:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_f_perfil"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_f_p_amp"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_f_chat"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_priv"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_accext"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_cat"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_sub"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fnac"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_sexo"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_descr"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_dist"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_com"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_gal"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fdist"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fsexo"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fn"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fedad1"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fedad2"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fdist_d"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fsexo_d"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fedad1_d"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_fedad2_d"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_i16"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_di"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_mp"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_mv"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_de"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_fa"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_ul"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_t_pr"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_cats"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_idg"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_cl"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_cp"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_iw"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_st"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_sta"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ad"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_mc"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_tv"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_cv"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ncols"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_padding"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_txt_radius"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_mostrar_icos"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_mostrar_txt"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_icos_izq"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_anim"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_c"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_txt_c"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_txt_b"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_e"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_txt_bg"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_txt_col"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_seccs"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_incl"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 2
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ico_id"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_v_ico"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_w_ico"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_h_ico"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_ico"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                java.lang.String r4 = r4.establec(r7, r8, r0)
                boolean r4 = r4.equals(r10)
                if (r4 == 0) goto L_0x1648
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "img_s"
                r7.<init>(r8)
                r7.append(r14)
                java.lang.String r8 = "_ico"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r4.deleteFile(r7)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "img_s"
                r7.<init>(r8)
                r7.append(r14)
                java.lang.String r8 = "_ico_g"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r4.deleteFile(r7)
            L_0x1648:
                if (r13 != 0) goto L_0x1698
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "wv_sc"
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "wv_sc_txt"
                r13 = 2
                r4.establec(r7, r13, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "wv_c"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "rss_i"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "rss_n"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "rss_t"
                r13 = 2
                r4.establec(r7, r13, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "vfs"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "vls"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "vc"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "cr"
                r13 = 2
                r4.establec(r7, r13, r0)
                r13 = 1
                goto L_0x1699
            L_0x1696:
                r17 = r4
            L_0x1698:
                r8 = 1
            L_0x1699:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r7 = "vcv"
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_idtemas"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r4.getString(r7, r6)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                java.lang.String r4 = r4.leer_map(r7)
                boolean r7 = r4.equals(r6)
                if (r7 != 0) goto L_0x16e5
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r0.putString(r7, r4)
            L_0x16e5:
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_nitems"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r8 = 1
                r4.establec(r7, r8, r0)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_iditems"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                java.lang.String r4 = r4.getString(r7, r6)
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>(r9)
                r8.append(r14)
                r18 = r4
                java.lang.String r4 = "_iditems"
                r8.append(r4)
                java.lang.String r4 = r8.toString()
                java.lang.String r4 = r7.leer_map(r4)
                boolean r7 = r4.equals(r6)
                if (r7 != 0) goto L_0x1749
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r9)
                r7.append(r14)
                java.lang.String r8 = "_iditems"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r0.putString(r7, r4)
                goto L_0x174b
            L_0x1749:
                r4 = r18
            L_0x174b:
                boolean r7 = r4.equals(r6)
                if (r7 != 0) goto L_0x1b7e
                java.lang.String[] r4 = r4.split(r11)
                r7 = 0
            L_0x1756:
                int r8 = r4.length
                if (r7 >= r8) goto L_0x1b7e
                r8 = r4[r7]
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r18 = r4
                java.lang.String r4 = "it"
                r14.<init>(r4)
                r14.append(r8)
                r14.append(r2)
                java.lang.String r14 = r14.toString()
                java.lang.String r9 = r9.leer_map(r14)
                boolean r9 = r9.equals(r6)
                if (r9 != 0) goto L_0x1aa0
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>(r4)
                r14.append(r8)
                r14.append(r2)
                java.lang.String r14 = r14.toString()
                r19 = r13
                r13 = 1
                r9.establec(r14, r13, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_c"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fcab_id"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fcab_modif"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fcab_c"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fcab_url"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_c"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_c"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_h"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fotos_pos"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fotos_c"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fotos_h"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fcab_z"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_fotos_z"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_b"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_i"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_f"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_col"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_u"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit1_s"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_b"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_i"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_f"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_col"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_u"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_tit2_s"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_b"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_i"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_f"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_col"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_u"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                java.lang.String r14 = "_txt_s"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                goto L_0x1aa3
            L_0x1aa0:
                r19 = r13
                r14 = 1
            L_0x1aa3:
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                r13.append(r15)
                java.lang.String r13 = r13.toString()
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r9 = r9.settings
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r4)
                r13.append(r8)
                r13.append(r3)
                java.lang.String r13 = r13.toString()
                java.lang.String r9 = r9.getString(r13, r6)
                stikerwap.appdys.preinicio r13 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>(r4)
                r14.append(r8)
                r14.append(r3)
                java.lang.String r14 = r14.toString()
                java.lang.String r13 = r13.leer_map(r14)
                stikerwap.appdys.preinicio r14 = stikerwap.appdys.preinicio.this
                r20 = r9
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>(r4)
                r9.append(r8)
                r9.append(r15)
                java.lang.String r9 = r9.toString()
                java.lang.String r9 = r14.leer_map(r9)
                boolean r9 = r9.equals(r6)
                if (r9 != 0) goto L_0x1b14
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>(r4)
                r9.append(r8)
                r9.append(r3)
                java.lang.String r4 = r9.toString()
                r0.putString(r4, r13)
                r9 = r13
                goto L_0x1b16
            L_0x1b14:
                r9 = r20
            L_0x1b16:
                boolean r4 = r9.equals(r6)
                if (r4 != 0) goto L_0x1b76
                java.lang.String[] r4 = r9.split(r11)
                r8 = 0
            L_0x1b21:
                int r9 = r4.length
                if (r8 >= r9) goto L_0x1b76
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r14 = "it_f"
                r13.<init>(r14)
                r14 = r4[r8]
                r13.append(r14)
                r13.append(r2)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r14 = "it_f"
                r13.<init>(r14)
                r14 = r4[r8]
                r13.append(r14)
                java.lang.String r14 = "_modif"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 1
                r9.establec(r13, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r14 = "it_f"
                r13.<init>(r14)
                r14 = r4[r8]
                r13.append(r14)
                java.lang.String r14 = "_url"
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r14 = 2
                r9.establec(r13, r14, r0)
                int r8 = r8 + 1
                goto L_0x1b21
            L_0x1b76:
                int r7 = r7 + 1
                r4 = r18
                r13 = r19
                goto L_0x1756
            L_0x1b7e:
                r19 = r13
                int r12 = r12 + 1
                r9 = r16
                r4 = r17
                r13 = r19
                r2 = 0
                r3 = 0
                r7 = 2
                r8 = 1
                goto L_0x0c82
            L_0x1b8e:
                r17 = r4
                r16 = r9
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.String r7 = "noficc"
                r8 = 0
                r4.getInt(r7, r8)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r4 = r4.leer_map(r7)
                boolean r8 = r4.equals(r6)
                if (r8 != 0) goto L_0x1baf
                int r8 = java.lang.Integer.parseInt(r4)
                r0.putInt(r7, r8)
            L_0x1baf:
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r7 = r7.settings
                java.lang.String r8 = "idofics"
                java.lang.String r7 = r7.getString(r8, r6)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.String r9 = r9.leer_map(r8)
                boolean r12 = r9.equals(r6)
                if (r12 == 0) goto L_0x1bcb
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L_0x1bcf
            L_0x1bcb:
                r0.putString(r8, r9)
                r7 = r9
            L_0x1bcf:
                r4 = 0
                java.lang.String[] r8 = new java.lang.String[r4]
                boolean r4 = r7.equals(r6)
                if (r4 != 0) goto L_0x1e72
                java.lang.String[] r8 = r7.split(r11)
                r4 = 0
            L_0x1bdd:
                int r7 = r8.length
                if (r4 >= r7) goto L_0x1e70
                r7 = r8[r4]
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "o"
                r12.<init>(r13)
                r12.append(r7)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.String r9 = r9.leer_map(r12)
                boolean r9 = r9.equals(r6)
                if (r9 != 0) goto L_0x1db3
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_tit"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_dir1"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_dir2"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_cp"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_pob"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_prov"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_tel1"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_tel2"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_horario"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_x"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_y"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_z"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_email"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_t_email"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_web"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 2
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_wp"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_chat"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                java.lang.String r14 = "_zoo"
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                r14 = 1
                r9.establec(r12, r14, r0)
                goto L_0x1db4
            L_0x1db3:
                r14 = 1
            L_0x1db4:
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                r12.append(r15)
                java.lang.String r12 = r12.toString()
                r9.establec(r12, r14, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r9 = r9.settings
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r13)
                r12.append(r7)
                r12.append(r3)
                java.lang.String r12 = r12.toString()
                java.lang.String r9 = r9.getString(r12, r6)
                stikerwap.appdys.preinicio r12 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>(r13)
                r14.append(r7)
                r14.append(r3)
                java.lang.String r14 = r14.toString()
                java.lang.String r12 = r12.leer_map(r14)
                stikerwap.appdys.preinicio r14 = stikerwap.appdys.preinicio.this
                r18 = r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>(r13)
                r8.append(r7)
                r8.append(r15)
                java.lang.String r8 = r8.toString()
                java.lang.String r8 = r14.leer_map(r8)
                boolean r8 = r8.equals(r6)
                if (r8 != 0) goto L_0x1e24
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>(r13)
                r8.append(r7)
                r8.append(r3)
                java.lang.String r7 = r8.toString()
                r0.putString(r7, r12)
                r9 = r12
            L_0x1e24:
                boolean r7 = r9.equals(r6)
                if (r7 != 0) goto L_0x1e6a
                java.lang.String[] r7 = r9.split(r11)
                r8 = 0
            L_0x1e2f:
                int r9 = r7.length
                if (r8 >= r9) goto L_0x1e6a
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "o_f"
                r12.<init>(r13)
                r13 = r7[r8]
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                r13 = 1
                r9.establec(r12, r13, r0)
                stikerwap.appdys.preinicio r9 = stikerwap.appdys.preinicio.this
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "o_f"
                r12.<init>(r13)
                r13 = r7[r8]
                r12.append(r13)
                java.lang.String r13 = "_modif"
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                r13 = 10
                r9.establec(r12, r13, r0)
                int r8 = r8 + 1
                goto L_0x1e2f
            L_0x1e6a:
                int r4 = r4 + 1
                r8 = r18
                goto L_0x1bdd
            L_0x1e70:
                r18 = r8
            L_0x1e72:
                r0.commit()
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                java.lang.String r3 = "cats"
                java.lang.String r2 = r2.leer_map(r3)
                boolean r3 = r2.equals(r6)
                if (r3 != 0) goto L_0x1ef1
                stikerwap.appdys.bd r3 = new stikerwap.appdys.bd     // Catch:{ Exception -> 0x1ef0 }
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x1ef0 }
                android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x1ef0 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x1ef0 }
                android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x1ef0 }
                if (r3 == 0) goto L_0x1ef1
                java.lang.String r4 = "DELETE FROM cats"
                r3.execSQL(r4)     // Catch:{ Exception -> 0x1ef0 }
                boolean r4 = r2.equals(r10)     // Catch:{ Exception -> 0x1ef0 }
                if (r4 != 0) goto L_0x1eec
                java.lang.String r4 = ";"
                java.lang.String[] r2 = r2.split(r4)     // Catch:{ Exception -> 0x1ef0 }
                r4 = 0
            L_0x1ea6:
                int r7 = r2.length     // Catch:{ Exception -> 0x1ef0 }
                if (r4 >= r7) goto L_0x1eec
                r7 = r2[r4]     // Catch:{ Exception -> 0x1ef0 }
                java.lang.String r9 = "@"
                java.lang.String[] r7 = r7.split(r9)     // Catch:{ Exception -> 0x1ef0 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1ef0 }
                r9.<init>()     // Catch:{ Exception -> 0x1ef0 }
                java.lang.String r12 = "INSERT INTO cats(_id,idcat,descr)VALUES("
                r9.append(r12)     // Catch:{ Exception -> 0x1ef0 }
                r12 = 0
                r13 = r7[r12]     // Catch:{ Exception -> 0x1ef0 }
                r9.append(r13)     // Catch:{ Exception -> 0x1ef0 }
                r9.append(r11)     // Catch:{ Exception -> 0x1ef0 }
                r12 = 1
                r13 = r7[r12]     // Catch:{ Exception -> 0x1ef0 }
                r9.append(r13)     // Catch:{ Exception -> 0x1ef0 }
                java.lang.String r12 = ",'"
                r9.append(r12)     // Catch:{ Exception -> 0x1ef0 }
                r12 = 2
                r7 = r7[r12]     // Catch:{ Exception -> 0x1ef0 }
                java.lang.String r12 = "'"
                java.lang.String r13 = "''"
                java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ Exception -> 0x1ef0 }
                r9.append(r7)     // Catch:{ Exception -> 0x1ef0 }
                java.lang.String r7 = "')"
                r9.append(r7)     // Catch:{ Exception -> 0x1ef0 }
                java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x1ef0 }
                r3.execSQL(r7)     // Catch:{ Exception -> 0x1ef0 }
                int r4 = r4 + 1
                goto L_0x1ea6
            L_0x1eec:
                r3.close()     // Catch:{ Exception -> 0x1ef0 }
                goto L_0x1ef1
            L_0x1ef0:
            L_0x1ef1:
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r3 = r2.globales
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.os.Bundle r4 = r4.extras
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                android.content.Intent r7 = r7.getIntent()
                r9 = r17
                int r3 = r3.crear_globales(r9, r8, r4, r7)
                r2.ord_secc_abrir = r3
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 20
                if (r2 <= r3) goto L_0x1f22
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r2 = r2.globales
                java.lang.String r2 = r2.c1
                boolean r2 = r2.equals(r6)
                if (r2 != 0) goto L_0x1f22
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r3 = r2.globales
                java.lang.String r3 = r3.c1
                stikerwap.appdys.config.aplicar_color_top(r2, r3)
            L_0x1f22:
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r2 = r2.settings
                java.lang.String r3 = "i"
                java.lang.String r2 = r2.getString(r3, r6)
                boolean r3 = r2.equals(r6)
                if (r3 != 0) goto L_0x1faf
                int r3 = r2.length()
                r4 = 22
                if (r3 <= r4) goto L_0x1faf
                r3 = 22
                r4 = 23
                java.lang.String r2 = r2.substring(r3, r4)
                boolean r2 = r2.equals(r5)
                if (r2 == 0) goto L_0x1faf
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r2 = r2.globales
                boolean r2 = r2.esSuprem()
                if (r2 == 0) goto L_0x1faf
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r2 = 2131886359(0x7f120117, float:1.9407295E38)
                java.lang.String r2 = r0.getString(r2)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                r4 = 2131886358(0x7f120116, float:1.9407293E38)
                java.lang.String r3 = r3.getString(r4)
                r0.mostrar_error(r2, r3)
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                android.content.ContentResolver r0 = r0.getContentResolver()
                java.lang.String r2 = "android_id"
                java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r2)
                stikerwap.appdys.config$enviar_sinresp r2 = new stikerwap.appdys.config$enviar_sinresp
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = stikerwap.appdys.config.DOM_SRV
                r3.append(r4)
                java.lang.String r4 = "/srv/prt_bloq.php?idusu="
                r3.append(r4)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                long r4 = r4.idusu
                r3.append(r4)
                java.lang.String r4 = "&cod_g="
                r3.append(r4)
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                java.lang.String r4 = r4.cod_g
                r3.append(r4)
                java.lang.String r4 = "&aid="
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                java.lang.String r3 = "Android Vinebre Software"
                r2.<init>(r0, r3)
                r3 = 0
                java.lang.String[] r0 = new java.lang.String[r3]
                r2.execute(r0)
                return
            L_0x1faf:
                r3 = 0
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r2 = r2.settings
                java.lang.String r4 = "hatenidonotif"
                boolean r2 = r2.getBoolean(r4, r3)
                if (r2 != 0) goto L_0x2042
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r2 = r2.globales
                java.lang.String r2 = r2.notifdef_tit
                boolean r2 = r2.equals(r6)
                if (r2 != 0) goto L_0x2042
                android.content.Intent r2 = new android.content.Intent
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                java.lang.Class<stikerwap.appdys.preinicio> r4 = stikerwap.appdys.preinicio.class
                r2.<init>(r3, r4)
                r3 = 268468224(0x10008000, float:2.5342157E-29)
                r2.setFlags(r3)
                java.lang.String r3 = "notif_id"
                r2.putExtra(r3, r5)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r3 = r3.globales
                int r3 = r3.notifdef_idabrir
                if (r3 != 0) goto L_0x1ff9
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r3 = r3.globales
                java.lang.String r3 = r3.notifdef_url
                boolean r3 = r3.equals(r6)
                if (r3 != 0) goto L_0x1ff9
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r3 = r3.globales
                java.lang.String r10 = r3.notifdef_url
                java.lang.String r3 = "2"
                goto L_0x2019
            L_0x1ff9:
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r3 = r3.globales
                int r3 = r3.notifdef_idabrir
                if (r3 <= 0) goto L_0x2018
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r4 = r4.globales
                int r4 = r4.notifdef_idabrir
                r3.append(r4)
                r3.append(r6)
                java.lang.String r10 = r3.toString()
                r3 = r5
                goto L_0x2019
            L_0x2018:
                r3 = r10
            L_0x2019:
                java.lang.String r4 = "notif_idelem"
                r2.putExtra(r4, r10)
                java.lang.String r4 = "notif_tipo"
                r2.putExtra(r4, r3)
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r4 = r3.globales
                java.lang.String r4 = r4.notifdef_tit
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r7 = r7.globales
                java.lang.String r7 = r7.notifdef_txt
                r21 = 0
                r22 = 1
                java.lang.String r23 = "0"
                java.lang.String r24 = "0"
                r17 = r3
                r18 = r4
                r19 = r7
                r20 = r2
                stikerwap.appdys.config.crear_notif(r17, r18, r19, r20, r21, r22, r23, r24)
            L_0x2042:
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                boolean r2 = r2.directo
                if (r2 == 0) goto L_0x204f
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.iniciar()
                goto L_0x2165
            L_0x204f:
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                r3 = r16
                java.lang.String r2 = r2.leer_map(r3)
                boolean r4 = r2.equals(r5)
                if (r4 == 0) goto L_0x2127
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                java.lang.String r3 = "sa"
                java.lang.String r2 = r2.leer_map(r3)
                boolean r3 = r2.equals(r6)
                if (r3 != 0) goto L_0x20a6
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{  }
                java.lang.String r3 = "sa"
                r0.putInt(r3, r2)     // Catch:{  }
                r0.commit()     // Catch:{  }
                if (r2 <= 0) goto L_0x20a6
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this     // Catch:{  }
                int r0 = stikerwap.appdys.config.getAppVersion(r0)     // Catch:{  }
                if (r2 > r0) goto L_0x20a6
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this     // Catch:{  }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{  }
                android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x20a5 }
                r2.<init>()     // Catch:{ Exception -> 0x20a5 }
                java.lang.String r3 = "altres/"
                r2.append(r3)     // Catch:{ Exception -> 0x20a5 }
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x20a5 }
                java.lang.String r3 = r3.img_asset     // Catch:{ Exception -> 0x20a5 }
                r2.append(r3)     // Catch:{ Exception -> 0x20a5 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x20a5 }
                r0.open(r2)     // Catch:{ Exception -> 0x20a5 }
                r0 = 1
                goto L_0x20a7
            L_0x20a5:
            L_0x20a6:
                r0 = 0
            L_0x20a7:
                if (r0 == 0) goto L_0x20b5
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.mostrar_splash_deasset()
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.mirar_font()
                goto L_0x2165
            L_0x20b5:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r0 = r0.globales
                java.lang.String r0 = r0.c1_splash
                boolean r0 = r0.equals(r6)
                if (r0 != 0) goto L_0x210d
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                android.graphics.drawable.GradientDrawable$Orientation r2 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
                r3 = 2
                int[] r3 = new int[r3]
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "#"
                r4.<init>(r5)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r5 = r5.globales
                java.lang.String r5 = r5.c1_splash
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                int r4 = android.graphics.Color.parseColor(r4)
                r5 = 0
                r3[r5] = r4
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "#"
                r4.<init>(r5)
                stikerwap.appdys.preinicio r5 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r5 = r5.globales
                java.lang.String r5 = r5.c2_splash
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                int r4 = android.graphics.Color.parseColor(r4)
                r5 = 1
                r3[r5] = r4
                r0.<init>(r2, r3)
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                r3 = 2131362315(0x7f0a020b, float:1.8344407E38)
                android.view.View r2 = r2.findViewById(r3)
                r2.setBackgroundDrawable(r0)
            L_0x210d:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                java.lang.String r2 = "vsp"
                java.lang.String r0 = r0.leer_map(r2)
                stikerwap.appdys.preinicio$cargarsplash r2 = new stikerwap.appdys.preinicio$cargarsplash
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this
                r4 = 0
                r2.<init>()
                r3 = 1
                java.lang.String[] r3 = new java.lang.String[r3]
                r4 = 0
                r3[r4] = r0
                r2.execute(r3)
                goto L_0x2165
            L_0x2127:
                java.lang.String r4 = "2"
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x2160
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                r4 = 2131362501(0x7f0a02c5, float:1.8344784E38)
                android.view.View r2 = r2.findViewById(r4)
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                r4 = 0
                r2.setImageBitmap(r4)
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x2143 }
                r2.deleteFile(r3)     // Catch:{ Exception -> 0x2143 }
            L_0x2143:
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this
                r3 = 2131363575(0x7f0a06f7, float:1.8346963E38)
                android.view.View r2 = r2.findViewById(r3)
                r3 = 8
                r2.setVisibility(r3)
                java.lang.String r2 = "sa"
                r3 = 0
                r0.putInt(r2, r3)
                r0.commit()
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.mirar_font()
                goto L_0x2165
            L_0x2160:
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this
                r0.mirar_font()
            L_0x2165:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargarconfig.onPostExecute(java.lang.Byte):void");
        }
    }

    /* access modifiers changed from: package-private */
    public String establec(String str, int i, SharedPreferences.Editor editor) {
        if (!this.result_http_map.containsKey(str)) {
            return "";
        }
        String str2 = this.result_http_map.get(str);
        if (i == 1) {
            editor.putInt(str, Integer.parseInt(str2));
            return str2;
        } else if (i == 2) {
            editor.putString(str, str2);
            return str2;
        } else if (i == 3) {
            editor.putFloat(str, Float.parseFloat(str2));
            return str2;
        } else if (i != 10) {
            return str2;
        } else {
            editor.putBoolean(str, true);
            editor.putBoolean(str + "_g", true);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_splash_deasset() {
        int i;
        int i2;
        findViewById(R.id.iv_splash).setVisibility(8);
        WebView webView = (WebView) findViewById(R.id.wv_splash);
        webView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
        int i3 = 0;
        webView.setVisibility(0);
        Bitmap bitmap = null;
        try {
            InputStream open = getResources().getAssets().open("altres/" + this.img_asset);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
        } catch (Exception | OutOfMemoryError unused) {
        }
        if (bitmap != null) {
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            int dp_to_px = (this.globales.splash_margen ? config.dp_to_px(this, 10) : 0) * 2;
            int i4 = point.x - dp_to_px;
            int i5 = point.y - dp_to_px;
            int dp_to_px2 = config.dp_to_px(this, 25);
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                dp_to_px2 = getResources().getDimensionPixelSize(identifier);
            }
            int i6 = i5 - dp_to_px2;
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int i7 = 1;
            if (this.globales.splash_tipo == 1) {
                if (width > i4) {
                    height = (height * i4) / width;
                    width = i4;
                    i3 = 1;
                }
                if (height > i6) {
                    width = (width * i6) / height;
                    height = i6;
                } else {
                    i7 = i3;
                }
                if (i7 == 0) {
                    i2 = (height * i4) / width;
                    if (i2 > i6) {
                        i = (width * i6) / height;
                    }
                    i = i4;
                }
                i3 = height;
            } else if (this.globales.splash_tipo == 2) {
                if (width < i4) {
                    i3 = (height * i4) / width;
                    width = i4;
                } else {
                    i3 = height;
                }
                if (i3 < i6) {
                    i = (i * i6) / i3;
                }
            } else {
                if (this.globales.splash_tipo == 3) {
                    i2 = i6;
                    i = i4;
                }
                i3 = height;
            }
            i3 = i6;
        } else {
            i = 0;
        }
        String str = "";
        if (!this.settings.getString("c1_sp", str).equals(str)) {
            str = "background: #" + this.settings.getString("c1_sp", str).substring(2) + ";background: linear-gradient(#" + this.settings.getString("c1_sp", str).substring(2) + ", #" + this.settings.getString("c2_sp", str).substring(2) + ");";
        }
        webView.loadDataWithBaseURL("file:///android_asset/altres/", "<html style='height:100%;margin:0;padding:0;'><head></head><body style='" + str + "height:100%;margin:0;padding:0;'><table style='border:0;width:100%;height:100%;'><tr><td align='center'><img style='padding:0;margin:0;width:" + config.px_to_dp(this, (float) i) + "px;height:" + config.px_to_dp(this, (float) i3) + "px;' src='" + this.img_asset + "'></td></tr></table></body></html>", "text/html", "utf-8", (String) null);
    }

    /* access modifiers changed from: package-private */
    public void mirar_font() {
        String leer_map = leer_map("ft");
        String leer_map2 = leer_map("vfu");
        if (leer_map2.equals("")) {
            leer_map2 = "0";
        }
        if (leer_map.equals("")) {
            mirar_sound_in();
            return;
        }
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putString("ft", leer_map);
        edit.putString("vfu", leer_map2);
        edit.commit();
        if (leer_map.equals("0")) {
            this.globales.establecerFuente(0);
            mirar_sound_in();
        } else if (leer_map.equals("1")) {
            if (Integer.parseInt(leer_map2) > Integer.parseInt(this.settings.getString("vfu_act", "0"))) {
                new cargarfont().execute(new String[]{leer_map2});
                return;
            }
            this.globales.establecerFuente(1);
            mirar_sound_in();
        } else {
            this.globales.establecerFuente(Integer.parseInt(leer_map));
            mirar_sound_in();
        }
    }

    /* access modifiers changed from: package-private */
    public void mirar_sound_in() {
        String leer_map = leer_map("sit");
        String leer_map2 = leer_map("vsi");
        if (leer_map2.equals("")) {
            leer_map2 = "0";
        }
        if (leer_map.equals("")) {
            mirar_sound_out();
            return;
        }
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putString("sit", leer_map);
        edit.putString("vsi", leer_map2);
        edit.commit();
        if (leer_map.equals("0")) {
            mirar_sound_out();
        } else if (leer_map.equals("1")) {
            if (Integer.parseInt(leer_map2) > Integer.parseInt(this.settings.getString("vsi_act", "0"))) {
                new cargarsound().execute(new String[]{leer_map2, ScarConstants.IN_SIGNAL_KEY});
                return;
            }
            mirar_sound_out();
        } else {
            mirar_sound_out();
        }
    }

    /* access modifiers changed from: package-private */
    public void mirar_sound_out() {
        String leer_map = leer_map("sot");
        String leer_map2 = leer_map("vso");
        if (leer_map2.equals("")) {
            leer_map2 = "0";
        }
        if (leer_map.equals("")) {
            mirar_icos();
            return;
        }
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putString("sot", leer_map);
        edit.putString("vso", leer_map2);
        edit.commit();
        if (leer_map.equals("0")) {
            mirar_icos();
        } else if (leer_map.equals("1")) {
            if (Integer.parseInt(leer_map2) > Integer.parseInt(this.settings.getString("vso_act", "0"))) {
                new cargarsound().execute(new String[]{leer_map2, "out"});
                return;
            }
            mirar_icos();
        } else {
            mirar_icos();
        }
    }

    /* access modifiers changed from: package-private */
    public void mirar_icos() {
        if ((!this.globales.ico_ofics_imgperso || this.globales.ico_ofics_imgperso_v <= this.settings.getInt("ofics_imgperso_v_act", 0)) && ((!this.globales.ico_busc_imgperso || this.globales.ico_busc_imgperso_v <= this.settings.getInt("busc_imgperso_v_act", 0)) && ((!this.globales.ico_share_imgperso || this.globales.ico_share_imgperso_v <= this.settings.getInt("share_imgperso_v_act", 0)) && ((!this.globales.ico_exit_imgperso || this.globales.ico_exit_imgperso_v <= this.settings.getInt("exit_imgperso_v_act", 0)) && ((!this.globales.ico_notif_imgperso || this.globales.ico_notif_imgperso_v <= this.settings.getInt("notif_imgperso_v_act", 0)) && ((!this.globales.ico_perfil_imgperso || this.globales.ico_perfil_imgperso_v <= this.settings.getInt("perfil_imgperso_v_act", 0)) && ((!this.globales.ico_search_imgperso || this.globales.ico_search_imgperso_v <= this.settings.getInt("search_imgperso_v_act", 0)) && (!this.globales.ico_sinads_imgperso || this.globales.ico_sinads_imgperso_v <= this.settings.getInt("sinads_imgperso_v_act", 0))))))))) {
            mirar_icos_mb();
        } else {
            new cargaricos().execute(new String[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void mirar_icos_mb() {
        boolean z;
        if (config.mb_items.length > 0) {
            int i = 0;
            while (true) {
                if (i >= config.mb_items.length) {
                    z = false;
                    break;
                }
                int i2 = config.mb_items[i].img_v;
                SharedPreferences sharedPreferences = this.settings;
                if (i2 > sharedPreferences.getInt("mb_it" + config.mb_items[i].id + "_v_act", 0)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                new cargaricos_mb().execute(new String[0]);
            } else {
                mirar_icohome();
            }
        } else {
            mirar_icohome();
        }
    }

    /* access modifiers changed from: package-private */
    public void mirar_icohome() {
        String leer_map = leer_map("icohome");
        if (leer_map.equals("1")) {
            String leer_map2 = leer_map("vih");
            new cargaricohome().execute(new String[]{leer_map2});
        } else if (leer_map.equals("2")) {
            deleteFile("icohome");
            mirar_icosmenu();
        } else {
            mirar_icosmenu();
        }
    }

    /* access modifiers changed from: package-private */
    public void mirar_icosmenu() {
        if (this.globales.fondo_v > 0 && this.settings.getInt("fondo_v_act", 0) != this.globales.fondo_v) {
            startService(new Intent(this, s_cargar_fondo.class));
        }
        Boolean valueOf = Boolean.valueOf(this.globales.v_ico_perfil > 0 && this.settings.getInt("v_ico_perfil_act", 0) != this.globales.v_ico_perfil);
        Boolean valueOf2 = Boolean.valueOf(this.globales.v_ico_privados > 0 && this.settings.getInt("v_ico_privados_act", 0) != this.globales.v_ico_privados);
        Boolean valueOf3 = Boolean.valueOf(this.globales.v_ico_foto > 0 && this.settings.getInt("v_ico_foto_act", 0) != this.globales.v_ico_foto);
        Boolean valueOf4 = Boolean.valueOf(this.globales.v_ico_video > 0 && this.settings.getInt("v_ico_video_act", 0) != this.globales.v_ico_video);
        Boolean valueOf5 = Boolean.valueOf(this.globales.v_ico_emotic > 0 && this.settings.getInt("v_ico_emotic_act", 0) != this.globales.v_ico_emotic);
        Boolean valueOf6 = Boolean.valueOf(this.globales.v_ico_enviar > 0 && this.settings.getInt("v_ico_enviar_act", 0) != this.globales.v_ico_enviar);
        if (valueOf.booleanValue() || valueOf2.booleanValue() || valueOf3.booleanValue() || valueOf4.booleanValue() || valueOf5.booleanValue() || valueOf6.booleanValue()) {
            Intent intent = new Intent(this, s_cargar_icos_gen.class);
            intent.putExtra("act_ico_perfil", valueOf);
            intent.putExtra("act_ico_privados", valueOf2);
            intent.putExtra("act_ico_foto", valueOf3);
            intent.putExtra("act_ico_video", valueOf4);
            intent.putExtra("act_ico_emotic", valueOf5);
            intent.putExtra("act_ico_enviar", valueOf6);
            startService(intent);
        }
        if (this.globales.tipomenu != 2 || !this.globales.icos_pendientes) {
            if (this.globales.tipomenu == 1 && this.globales.slider_v > 0 && this.settings.getInt("slider_v_act", 0) != this.globales.slider_v) {
                try {
                    startService(new Intent(this, s_cargar_sliderheader.class));
                } catch (Exception unused) {
                }
            }
            fin_preinicio();
            return;
        }
        startService(new Intent(this, s_cargar_icos.class));
        fin_preinicio();
    }

    /* access modifiers changed from: package-private */
    public void fin_preinicio() {
        findViewById(R.id.pb_splash).setVisibility(8);
        if (this.marcar_guardado) {
            String leer_map = leer_map("fus");
            if (!leer_map.equals("")) {
                SharedPreferences.Editor edit = this.settings.edit();
                edit.putString("fultsync", leer_map);
                edit.commit();
            }
        }
        if (this.result_http_map.containsKey("espera")) {
            this.espera = Integer.parseInt(leer_map("espera"));
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.pd_espera = progressDialog;
            progressDialog.setCancelable(true);
            this.pd_espera.setCanceledOnTouchOutside(false);
            this.pd_espera.setTitle(getResources().getString(R.string.appnoreg));
            ProgressDialog progressDialog2 = this.pd_espera;
            progressDialog2.setMessage(this.espera + "s.");
            this.pd_espera.setIndeterminate(true);
            this.pd_espera.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    try {
                        preinicio.this.th_espera.interrupt();
                    } catch (Exception unused) {
                    }
                    preinicio.this.finish();
                }
            });
            try {
                this.pd_espera.show();
            } catch (Exception unused) {
            }
            final AnonymousClass7 r0 = new Handler() {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (preinicio.this.espera > 0) {
                        preinicio preinicio = preinicio.this;
                        preinicio.espera--;
                        try {
                            preinicio.this.pd_espera.setMessage(preinicio.this.espera + "s.");
                        } catch (Exception unused) {
                        }
                        if (preinicio.this.espera == 0) {
                            preinicio.this.preiniciar_gdpr();
                        }
                    }
                }
            };
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    while (preinicio.this.espera > 0) {
                        try {
                            Thread.sleep(1000);
                            Handler handler = r0;
                            handler.sendMessage(handler.obtainMessage());
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            });
            this.th_espera = thread;
            thread.start();
            return;
        }
        preiniciar_gdpr();
    }

    /* access modifiers changed from: private */
    public void preiniciar_gdpr() {
        boolean z;
        String country = Locale.getDefault().getCountry();
        if (country != null) {
            config.europeo = Arrays.asList(new String[]{"BE", "LT", "PT", "BG", "ES", "LU", "RO", "CZ", "FR", "HU", "SI", "DK", "MT", "SK", "DE", "IT", "NL", "FI", "EE", "CY", "AT", "SE", "IE", "LV", "PL", "CH", "NO", IronSourceConstants.INTERSTITIAL_EVENT_TYPE, "LI", "HR", "GR", "GB", "UK"}).contains(country.toUpperCase());
        }
        if (!config.europeo) {
            Log.e("ara", "preiniciar_bv directament");
            preiniciar_bv();
        }
        try {
            z = !getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID", "").equals("");
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            ConsentRequestParameters build = new ConsentRequestParameters.Builder().setTagForUnderAgeOfConsent(false).build();
            ConsentInformation consentInformation2 = UserMessagingPlatform.getConsentInformation(this);
            this.consentInformation = consentInformation2;
            consentInformation2.requestConsentInfoUpdate(this, build, new preinicio$$ExternalSyntheticLambda0(this), new preinicio$$ExternalSyntheticLambda1(this));
        } else if (!this.globales.aviso_cookies || this.settings.getInt("a", 0) != 1 || this.settings.contains("cookies_aceptado")) {
            preiniciar_bv();
        } else if (config.europeo) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.cookies_txt)).setTitle(getString(R.string.aviso));
            builder.setCancelable(false);
            builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    preinicio.this.finish();
                }
            });
            builder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences.Editor edit = preinicio.this.settings.edit();
                    edit.putBoolean("cookies_aceptado", true);
                    edit.commit();
                    preinicio.this.preiniciar_bv();
                }
            });
            final AlertDialog create = builder.create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
                        Button button2 = create.getButton(-2);
                        button2.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
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
        } else {
            preiniciar_bv();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$preiniciar_gdpr$1$stikerwap-appdys-preinicio  reason: not valid java name */
    public /* synthetic */ void m1427lambda$preiniciar_gdpr$1$stikerwapappdyspreinicio() {
        UserMessagingPlatform.loadAndShowConsentFormIfRequired(this, new preinicio$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$preiniciar_gdpr$0$stikerwap-appdys-preinicio  reason: not valid java name */
    public /* synthetic */ void m1426lambda$preiniciar_gdpr$0$stikerwapappdyspreinicio(FormError formError) {
        boolean z = true;
        if (formError != null) {
            Log.e("ara", String.format("%s: %s", new Object[]{Integer.valueOf(formError.getErrorCode()), formError.getMessage()}));
        } else {
            Log.e("ara", "Consent has been gathered");
        }
        if (this.consentInformation.getPrivacyOptionsRequirementStatus() != ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED) {
            z = false;
        }
        config.privacy_incluir_adsconsent = z;
        preiniciar_bv();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$preiniciar_gdpr$2$stikerwap-appdys-preinicio  reason: not valid java name */
    public /* synthetic */ void m1428lambda$preiniciar_gdpr$2$stikerwapappdyspreinicio(FormError formError) {
        Log.e("ara", String.format("%s: %s", new Object[]{Integer.valueOf(formError.getErrorCode()), formError.getMessage()}));
        preiniciar_bv();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e A[SYNTHETIC, Splitter:B:12:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0522  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x052b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preiniciar_bv() {
        /*
            r13 = this;
            boolean r0 = r13.preiniciar_bv_llamado
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            r13.preiniciar_bv_llamado = r0
            java.lang.String r1 = "sh"
            r2 = 0
            android.content.SharedPreferences r1 = r13.getSharedPreferences(r1, r2)
            java.lang.String r3 = "sinads"
            boolean r4 = r1.getBoolean(r3, r2)
            if (r4 == 0) goto L_0x0047
            java.lang.String r4 = "sinads_fhasta"
            r5 = 0
            long r7 = r1.getLong(r4, r5)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = r7.longValue()
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0034
            r3 = 1
            goto L_0x0048
        L_0x0034:
            android.content.SharedPreferences$Editor r7 = r1.edit()
            java.lang.String r8 = "sinads_comprobacionespago"
            r7.putInt(r8, r2)
            r7.putBoolean(r3, r2)
            r7.putLong(r4, r5)
            r7.apply()
        L_0x0047:
            r3 = 0
        L_0x0048:
            java.lang.String r4 = ""
            stikerwap.appdys.config.admob_app_id = r4
            if (r3 != 0) goto L_0x0068
            android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r6 = r13.getPackageName()     // Catch:{ Exception -> 0x0067 }
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r6, r7)     // Catch:{ Exception -> 0x0067 }
            android.os.Bundle r5 = r5.metaData     // Catch:{ Exception -> 0x0067 }
            java.lang.String r6 = "com.google.android.gms.ads.APPLICATION_ID"
            java.lang.String r5 = r5.getString(r6, r4)     // Catch:{ Exception -> 0x0067 }
            stikerwap.appdys.config.admob_app_id = r5     // Catch:{ Exception -> 0x0067 }
            goto L_0x0068
        L_0x0067:
        L_0x0068:
            java.lang.String r5 = stikerwap.appdys.config.admob_app_id
            boolean r5 = r5.equals(r4)
            java.lang.String r6 = "ara"
            if (r5 != 0) goto L_0x008a
            boolean r5 = stikerwap.appdys.config.europeo
            if (r5 == 0) goto L_0x0081
            com.google.android.ump.ConsentInformation r5 = r13.consentInformation
            if (r5 == 0) goto L_0x008a
            boolean r5 = r5.canRequestAds()
            if (r5 != 0) goto L_0x0081
            goto L_0x008a
        L_0x0081:
            java.lang.String r5 = "inicialitzem Admob"
            android.util.Log.e(r6, r5)
            com.google.android.gms.ads.MobileAds.initialize(r13)
            goto L_0x00ab
        L_0x008a:
            java.lang.String r5 = "NO inicialitzem"
            android.util.Log.e(r6, r5)
            stikerwap.appdys.config r5 = r13.globales
            r5.admob_cod = r4
            stikerwap.appdys.config.admob_int_cod = r4
            stikerwap.appdys.config.admob_appopen_cod = r4
            stikerwap.appdys.config r5 = r13.globales
            r5.admob_pro_cod = r4
            stikerwap.appdys.config r5 = r13.globales
            r5.admob_radio_cod = r4
            stikerwap.appdys.config r5 = r13.globales
            r5.admob_qr_cod = r4
            stikerwap.appdys.config r5 = r13.globales
            r5.admob_menu_cod = r4
            stikerwap.appdys.config r5 = r13.globales
            r5.admob_rew_cod = r4
        L_0x00ab:
            if (r3 != 0) goto L_0x013f
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_appid
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x013f
            com.ironsource.mediationsdk.IronSource.setConsent(r0)
            java.lang.String r5 = "do_not_sell"
            java.lang.String r7 = "true"
            com.ironsource.mediationsdk.IronSource.setMetaData((java.lang.String) r5, (java.lang.String) r7)
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_rew_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x00e1
            stikerwap.appdys.preinicio$12 r5 = new stikerwap.appdys.preinicio$12
            r5.<init>()
            com.ironsource.mediationsdk.IronSource.setLevelPlayRewardedVideoListener(r5)
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_appid
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r7 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r0]
            com.ironsource.mediationsdk.IronSource$AD_UNIT r8 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO
            r7[r2] = r8
            com.ironsource.mediationsdk.IronSource.init((android.content.Context) r13, (java.lang.String) r5, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r7)
        L_0x00e1:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_b_cod
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x011d
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_pro_cod
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x011d
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_menu_cod
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x011d
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_radio_cod
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x011d
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_qr_cod
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x011d
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_card_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x012a
        L_0x011d:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_appid
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r7 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r0]
            com.ironsource.mediationsdk.IronSource$AD_UNIT r8 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER
            r7[r2] = r8
            com.ironsource.mediationsdk.IronSource.init((android.content.Context) r13, (java.lang.String) r5, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r7)
        L_0x012a:
            java.lang.String r5 = stikerwap.appdys.config.is_int_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x013f
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.is_appid
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r7 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r0]
            com.ironsource.mediationsdk.IronSource$AD_UNIT r8 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL
            r7[r2] = r8
            com.ironsource.mediationsdk.IronSource.init((android.content.Context) r13, (java.lang.String) r5, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r7)
        L_0x013f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            r7 = 4
            if (r3 != 0) goto L_0x0228
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnextb_cod
            if (r8 == 0) goto L_0x015c
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnextb_cod
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x015c
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnextb_cod
            goto L_0x01cc
        L_0x015c:
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_pro_cod
            if (r8 == 0) goto L_0x0171
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_pro_cod
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0171
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_pro_cod
            goto L_0x01cc
        L_0x0171:
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_menu_cod
            if (r8 == 0) goto L_0x0186
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_menu_cod
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0186
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_menu_cod
            goto L_0x01cc
        L_0x0186:
            stikerwap.appdys.config r8 = r13.globales
            boolean r8 = r8.card_nuestro
            if (r8 == 0) goto L_0x01a1
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.card_appnext_nuestro
            if (r8 == 0) goto L_0x01a1
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.card_appnext_nuestro
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x01a1
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.card_appnext_nuestro
            goto L_0x01cc
        L_0x01a1:
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.forzar_cargar_appnext
            if (r8 == 0) goto L_0x01b6
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.forzar_cargar_appnext
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x01b6
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.forzar_cargar_appnext
            goto L_0x01cc
        L_0x01b6:
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_inchat_cod
            if (r8 == 0) goto L_0x01cb
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_inchat_cod
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x01cb
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.appnext_inchat_cod
            goto L_0x01cc
        L_0x01cb:
            r8 = r4
        L_0x01cc:
            boolean r9 = r8.equals(r4)
            if (r9 != 0) goto L_0x01d7
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            goto L_0x01ff
        L_0x01d7:
            java.lang.String r9 = stikerwap.appdys.config.appnext_cod
            if (r9 == 0) goto L_0x01e3
            java.lang.String r9 = stikerwap.appdys.config.appnext_cod
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x01fb
        L_0x01e3:
            java.lang.String r9 = stikerwap.appdys.config.appnext_cod_int_e
            if (r9 == 0) goto L_0x01ef
            java.lang.String r9 = stikerwap.appdys.config.appnext_cod_int_e
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x01fb
        L_0x01ef:
            java.lang.String r9 = stikerwap.appdys.config.appnext_cod_int_ia
            if (r9 == 0) goto L_0x01ff
            java.lang.String r9 = stikerwap.appdys.config.appnext_cod_int_ia
            boolean r9 = r9.equals(r4)
            if (r9 != 0) goto L_0x01ff
        L_0x01fb:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
        L_0x01ff:
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0208
            com.appnext.base.Appnext.init(r13)
        L_0x0208:
            boolean r5 = r8.equals(r4)
            if (r5 != 0) goto L_0x0228
            stikerwap.appdys.config r5 = r13.globales
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r5.appnext_ads = r9
            android.content.Context r5 = r13.getApplicationContext()
            com.appnext.nativeads.NativeAdRequest r9 = new com.appnext.nativeads.NativeAdRequest
            r9.<init>()
            stikerwap.appdys.preinicio$13 r10 = new stikerwap.appdys.preinicio$13
            r10.<init>()
            com.appnext.nativeads.AdLoader.load(r5, r8, r9, r10, r7)
        L_0x0228:
            if (r3 != 0) goto L_0x02c2
            java.lang.String r5 = stikerwap.appdys.config.st_int_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0236
            java.lang.String r5 = stikerwap.appdys.config.st_int_cod
            goto L_0x02c3
        L_0x0236:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_b_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0246
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_b_cod
            goto L_0x02c3
        L_0x0246:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_radio_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0256
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_radio_cod
            goto L_0x02c3
        L_0x0256:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_pro_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0265
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_pro_cod
            goto L_0x02c3
        L_0x0265:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_menu_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0274
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_menu_cod
            goto L_0x02c3
        L_0x0274:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_rew_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0283
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_rew_cod
            goto L_0x02c3
        L_0x0283:
            stikerwap.appdys.config r5 = r13.globales
            boolean r5 = r5.card_nuestro
            if (r5 == 0) goto L_0x0298
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.card_st_nuestro
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0298
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.card_st_nuestro
            goto L_0x02c3
        L_0x0298:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.forzar_cargar_startapp
            if (r5 == 0) goto L_0x02ad
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.forzar_cargar_startapp
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x02ad
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.forzar_cargar_startapp
            goto L_0x02c3
        L_0x02ad:
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_inchat_cod
            if (r5 == 0) goto L_0x02c2
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_inchat_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x02c2
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_inchat_cod
            goto L_0x02c3
        L_0x02c2:
            r5 = r4
        L_0x02c3:
            boolean r8 = r5.equals(r4)
            if (r8 != 0) goto L_0x0358
            java.lang.String r8 = "fnac_a"
            int r8 = r1.getInt(r8, r2)
            java.lang.String r9 = "sexo"
            int r9 = r1.getInt(r9, r2)
            r10 = 2
            if (r8 != 0) goto L_0x02e2
            if (r9 == r0) goto L_0x02e2
            if (r9 != r10) goto L_0x02de
            goto L_0x02e2
        L_0x02de:
            com.startapp.sdk.adsbase.StartAppSDK.init((android.content.Context) r13, (java.lang.String) r5, (boolean) r2)
            goto L_0x0312
        L_0x02e2:
            com.startapp.sdk.adsbase.SDKAdPreferences r11 = new com.startapp.sdk.adsbase.SDKAdPreferences
            r11.<init>()
            if (r8 == 0) goto L_0x0300
            java.util.Calendar r12 = java.util.Calendar.getInstance()
            r12.set(r8, r2, r0)
            java.util.Calendar r8 = java.util.Calendar.getInstance()
            int r8 = r8.get(r0)
            int r12 = r12.get(r0)
            int r8 = r8 - r12
            r11.setAge((int) r8)
        L_0x0300:
            if (r9 != r0) goto L_0x0308
            com.startapp.sdk.adsbase.SDKAdPreferences$Gender r8 = com.startapp.sdk.adsbase.SDKAdPreferences.Gender.MALE
            r11.setGender(r8)
            goto L_0x030f
        L_0x0308:
            if (r9 != r10) goto L_0x030f
            com.startapp.sdk.adsbase.SDKAdPreferences$Gender r8 = com.startapp.sdk.adsbase.SDKAdPreferences.Gender.FEMALE
            r11.setGender(r8)
        L_0x030f:
            com.startapp.sdk.adsbase.StartAppSDK.init((android.content.Context) r13, (java.lang.String) r5, (com.startapp.sdk.adsbase.SDKAdPreferences) r11, (boolean) r2)
        L_0x0312:
            com.startapp.sdk.adsbase.StartAppAd.disableSplash()
            com.startapp.sdk.adsbase.StartAppAd.enableConsent(r13, r2)
            java.lang.String r5 = "pas"
            long r8 = java.lang.System.currentTimeMillis()
            com.startapp.sdk.adsbase.StartAppSDK.setUserConsent(r13, r5, r8, r0)
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_inchat_cod
            if (r5 == 0) goto L_0x0358
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.st_inchat_cod
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0358
            com.startapp.sdk.ads.nativead.StartAppNativeAd r5 = new com.startapp.sdk.ads.nativead.StartAppNativeAd
            r5.<init>(r13)
            com.startapp.sdk.ads.nativead.NativeAdPreferences r8 = new com.startapp.sdk.ads.nativead.NativeAdPreferences
            r8.<init>()
            com.startapp.sdk.ads.nativead.NativeAdPreferences r8 = r8.setAdsNumber(r7)
            com.startapp.sdk.ads.nativead.NativeAdPreferences r8 = r8.setAutoBitmapDownload(r0)
            com.startapp.sdk.ads.nativead.NativeAdPreferences r7 = r8.setPrimaryImageSize(r7)
            com.startapp.sdk.ads.nativead.NativeAdPreferences r7 = r7.setSecondaryImageSize(r2)
            java.lang.String r8 = "IN-CHAT"
            r7.setAdTag(r8)
            stikerwap.appdys.preinicio$14 r8 = new stikerwap.appdys.preinicio$14
            r8.<init>(r5)
            r5.loadAd(r7, r8)
        L_0x0358:
            if (r3 != 0) goto L_0x036b
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.wortise_appid
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x036b
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.wortise_appid
            com.wortise.ads.WortiseSdk.initialize(r13, r5)
        L_0x036b:
            if (r3 != 0) goto L_0x0394
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.pangle_appid
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0394
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r5 = new com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder
            r5.<init>()
            stikerwap.appdys.config r7 = r13.globales
            java.lang.String r7 = r7.pangle_appid
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r5 = r5.appId(r7)
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r5 = r5.debugLog(r0)
            com.bytedance.sdk.openadsdk.api.init.PAGConfig r5 = r5.build()
            stikerwap.appdys.preinicio$15 r7 = new stikerwap.appdys.preinicio$15
            r7.<init>()
            com.bytedance.sdk.openadsdk.api.init.PAGSdk.init(r13, r5, r7)
        L_0x0394:
            if (r3 != 0) goto L_0x03ac
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.liftoff_appid
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x03ac
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.liftoff_appid
            stikerwap.appdys.preinicio$16 r7 = new stikerwap.appdys.preinicio$16
            r7.<init>()
            com.vungle.ads.VungleAds.init(r13, r5, r7)
        L_0x03ac:
            if (r3 != 0) goto L_0x03cb
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.mint_appid
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x03cb
            com.mbridge.msdk.system.a r5 = com.mbridge.msdk.out.MBridgeSDKFactory.getMBridgeSDK()
            stikerwap.appdys.config r7 = r13.globales
            java.lang.String r7 = r7.mint_appid
            stikerwap.appdys.config r8 = r13.globales
            java.lang.String r8 = r8.mint_appkey
            java.util.Map r7 = r5.getMBConfigurationMap(r7, r8)
            r5.init((java.util.Map<java.lang.String, java.lang.String>) r7, (android.content.Context) r13)
        L_0x03cb:
            if (r3 != 0) goto L_0x03e3
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.monedata_appid
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x03e3
            java.lang.String r5 = "ini monedata"
            android.util.Log.e(r6, r5)
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.monedata_appid
            io.monedata.Monedata.initialize(r13, r5, r0)
        L_0x03e3:
            if (r3 != 0) goto L_0x0449
            stikerwap.appdys.config r3 = r13.globales
            java.lang.String r3 = r3.uni_appid
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0449
            stikerwap.appdys.config r3 = r13.globales
            java.lang.String r3 = r3.uni_b_cod
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0415
            java.lang.String r3 = stikerwap.appdys.config.uni_int_cod
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0415
            stikerwap.appdys.config r3 = r13.globales
            java.lang.String r3 = r3.uni_rew_cod
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0415
            stikerwap.appdys.config r3 = r13.globales
            java.lang.String r3 = r3.uni_pro_cod
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0449
        L_0x0415:
            com.unity3d.ads.metadata.MetaData r3 = new com.unity3d.ads.metadata.MetaData
            r3.<init>(r13)
            java.lang.String r5 = "privacy.consent"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r3.set((java.lang.String) r5, (java.lang.Object) r6)
            r3.commit()
            boolean r3 = stikerwap.appdys.config.europeo
            if (r3 == 0) goto L_0x043b
            com.unity3d.ads.metadata.MetaData r3 = new com.unity3d.ads.metadata.MetaData
            r3.<init>(r13)
            java.lang.String r5 = "gdpr.consent"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r3.set((java.lang.String) r5, (java.lang.Object) r6)
            r3.commit()
        L_0x043b:
            stikerwap.appdys.preinicio$17 r3 = new stikerwap.appdys.preinicio$17
            r3.<init>()
            stikerwap.appdys.config r5 = r13.globales     // Catch:{ Exception -> 0x0448 }
            java.lang.String r5 = r5.uni_appid     // Catch:{ Exception -> 0x0448 }
            com.unity3d.ads.UnityAds.initialize(r13, r5, r2, r3)     // Catch:{ Exception -> 0x0448 }
            goto L_0x0449
        L_0x0448:
        L_0x0449:
            r13.bienvenida_mostrar = r2
            stikerwap.appdys.config r3 = r13.globales
            java.lang.String r3 = r3.bienvenida_txt
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x04f3
            java.lang.String r3 = "bienvenida_nomas"
            boolean r3 = r1.getBoolean(r3, r2)
            if (r3 != 0) goto L_0x04f3
            r13.bienvenida_mostrar = r0
            android.app.AlertDialog$Builder r3 = new android.app.AlertDialog$Builder
            r3.<init>(r13)
            r13.adb = r3
            stikerwap.appdys.config r3 = r13.globales
            java.lang.String r3 = r3.bienvenida_tit
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0479
            android.app.AlertDialog$Builder r3 = r13.adb
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.bienvenida_tit
            r3.setTitle(r5)
        L_0x0479:
            stikerwap.appdys.config r3 = r13.globales
            boolean r3 = r3.bienvenida_nomas_mostrar
            if (r3 == 0) goto L_0x04d0
            android.view.LayoutInflater r3 = r13.getLayoutInflater()
            r5 = 2131558451(0x7f0d0033, float:1.8742218E38)
            r6 = 0
            android.view.View r3 = r3.inflate(r5, r6)
            r5 = 2131362811(0x7f0a03fb, float:1.8345413E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.text.method.ScrollingMovementMethod r6 = new android.text.method.ScrollingMovementMethod
            r6.<init>()
            r5.setMovementMethod(r6)
            stikerwap.appdys.config r6 = r13.globales
            java.lang.String r6 = r6.bienvenida_txt
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            r5.setText(r6)
            r5 = 2131363181(0x7f0a056d, float:1.8346164E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.CheckBox r5 = (android.widget.CheckBox) r5
            r13.dontShowAgain = r5
            java.lang.String r5 = r13.cbtn
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x04c1
            android.widget.CheckBox r5 = r13.dontShowAgain
            java.lang.String r6 = r13.cbtn
            stikerwap.appdys.config.checkbox_color(r5, r6)
        L_0x04c1:
            android.widget.CheckBox r5 = r13.dontShowAgain
            stikerwap.appdys.config r6 = r13.globales
            boolean r6 = r6.bienvenida_nomas_def
            r5.setChecked(r6)
            android.app.AlertDialog$Builder r5 = r13.adb
            r5.setView(r3)
            goto L_0x04dd
        L_0x04d0:
            android.app.AlertDialog$Builder r3 = r13.adb
            stikerwap.appdys.config r5 = r13.globales
            java.lang.String r5 = r5.bienvenida_txt
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r3.setMessage(r5)
        L_0x04dd:
            android.app.AlertDialog$Builder r3 = r13.adb
            r3.setCancelable(r2)
            android.app.AlertDialog$Builder r3 = r13.adb
            r5 = 2131886114(0x7f120022, float:1.9406798E38)
            java.lang.String r5 = r13.getString(r5)
            stikerwap.appdys.preinicio$18 r6 = new stikerwap.appdys.preinicio$18
            r6.<init>(r1)
            r3.setPositiveButton(r5, r6)
        L_0x04f3:
            stikerwap.appdys.config r1 = r13.globales
            int r1 = r1.splash_w
            if (r1 <= 0) goto L_0x051f
            r1 = 2131363575(0x7f0a06f7, float:1.8346963E38)
            android.view.View r1 = r13.findViewById(r1)
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0507
            goto L_0x0520
        L_0x0507:
            r1 = 2131362501(0x7f0a02c5, float:1.8344784E38)
            android.view.View r1 = r13.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            if (r1 == 0) goto L_0x051f
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            android.graphics.Bitmap r1 = r1.getBitmap()
            if (r1 == 0) goto L_0x051f
            goto L_0x0520
        L_0x051f:
            r0 = 0
        L_0x0520:
            if (r0 == 0) goto L_0x052b
            stikerwap.appdys.preinicio$19 r0 = new stikerwap.appdys.preinicio$19
            r0.<init>()
            r0.start()
            goto L_0x0564
        L_0x052b:
            boolean r0 = r13.bienvenida_mostrar
            if (r0 == 0) goto L_0x0561
            android.app.AlertDialog$Builder r0 = r13.adb
            android.app.AlertDialog r0 = r0.create()
            java.lang.String r1 = r13.cbtn
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0545
            stikerwap.appdys.preinicio$20 r1 = new stikerwap.appdys.preinicio$20
            r1.<init>(r0)
            r0.setOnShowListener(r1)
        L_0x0545:
            r0.show()     // Catch:{ Exception -> 0x055d }
            stikerwap.appdys.config r1 = r13.globales     // Catch:{ Exception -> 0x055d }
            boolean r1 = r1.bienvenida_nomas_mostrar     // Catch:{ Exception -> 0x055d }
            if (r1 != 0) goto L_0x0564
            r1 = 16908299(0x102000b, float:2.387726E-38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x0564 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0564 }
            android.graphics.Typeface r1 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0564 }
            r0.setTypeface(r1)     // Catch:{ Exception -> 0x0564 }
            goto L_0x0564
        L_0x055d:
            r13.pedir_permisos()
            goto L_0x0564
        L_0x0561:
            r13.pedir_permisos()
        L_0x0564:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.preiniciar_bv():void");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 3) {
            boolean p_location = config.p_location(this);
            if (((p_location && iArr.length > 0 && ((strArr[0].equals("android.permission.ACCESS_FINE_LOCATION") || strArr[0].equals("android.permission.ACCESS_COARSE_LOCATION")) && iArr[0] == 0)) || ((p_location && iArr.length > 1 && ((strArr[1].equals("android.permission.ACCESS_FINE_LOCATION") || strArr[1].equals("android.permission.ACCESS_COARSE_LOCATION")) && iArr[1] == 0)) || (p_location && iArr.length > 2 && ((strArr[2].equals("android.permission.ACCESS_FINE_LOCATION") || strArr[2].equals("android.permission.ACCESS_COARSE_LOCATION")) && iArr[2] == 0)))) && (getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", getPackageName()) == 0 || getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", getPackageName()) == 0)) {
                try {
                    FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
                    this.fusedLocationClient = fusedLocationProviderClient;
                    fusedLocationProviderClient.getLastLocation().addOnSuccessListener((Activity) this, new OnSuccessListener<Location>() {
                        public void onSuccess(Location location) {
                            if (location != null) {
                                String str = location.getLatitude() + "";
                                String str2 = location.getLongitude() + "";
                                SharedPreferences sharedPreferences = preinicio.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("x", str);
                                edit.putString("y", str2);
                                edit.commit();
                                long j = sharedPreferences.getLong("idusu", 0);
                                String string = sharedPreferences.getString("cod", "");
                                if (j != 0 && !string.equals("")) {
                                    new config.enviar_sinresp(config.DOM_SRV + "/srv/guardarpos.php?idusu=" + j + "&c=" + string + "&x=" + str + "&y=" + str2, "Android Vinebre Software").execute(new String[0]);
                                }
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
            preiniciar_4();
        }
    }

    /* access modifiers changed from: private */
    public void pedir_permisos() {
        int i;
        String[] strArr = new String[3];
        if (!this.globales.pedir_location_aliniciar || !config.p_location(this) || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            i = 0;
        } else {
            strArr[0] = "android.permission.ACCESS_FINE_LOCATION";
            strArr[1] = "android.permission.ACCESS_COARSE_LOCATION";
            i = 2;
        }
        if (Build.VERSION.SDK_INT >= 33 && config.p_notifications(this) && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            strArr[i] = "android.permission.POST_NOTIFICATIONS";
            i++;
        }
        if (i > 0) {
            String[] strArr2 = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                strArr2[i2] = strArr[i2];
            }
            ActivityCompat.requestPermissions(this, strArr2, 3);
            return;
        }
        preiniciar_4();
    }

    private void preiniciar_4() {
        if (this.globales.rate_primeravez > 0) {
            int i = this.settings.getInt("rt_n", 0);
            if (i == -1) {
                preiniciar_2();
                return;
            }
            int i2 = i + 1;
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putInt("rt_n", i2);
            edit.commit();
            if (i2 < this.globales.rate_primeravez) {
                preiniciar_2();
            } else if (i2 == this.globales.rate_primeravez || (this.globales.rate_int > 0 && (i2 - this.globales.rate_primeravez) % this.globales.rate_int == 0)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                final RatingBar ratingBar = new RatingBar(this);
                if (this.globales.rate_tipo == 1) {
                    ratingBar.setNumStars(5);
                    try {
                        if (!this.cbtn.equals("")) {
                            LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
                            Drawable drawable = layerDrawable.getDrawable(2);
                            drawable.setColorFilter(Color.parseColor("#" + this.cbtn), PorterDuff.Mode.SRC_ATOP);
                            Drawable drawable2 = layerDrawable.getDrawable(1);
                            drawable2.setColorFilter(Color.parseColor("#" + this.cbtn), PorterDuff.Mode.SRC_ATOP);
                        }
                    } catch (Exception unused) {
                    }
                    LinearLayout linearLayout = new LinearLayout(this);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    linearLayout.setGravity(17);
                    linearLayout.addView(ratingBar);
                    builder.setView(linearLayout);
                }
                builder.setCancelable(false);
                builder.setPositiveButton(this.globales.rate_ok.equals("") ? getResources().getString(R.string.aceptar) : this.globales.rate_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor edit = preinicio.this.settings.edit();
                        edit.putInt("rt_n", -1);
                        edit.commit();
                        if (preinicio.this.globales.rate_tipo == 0) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + preinicio.this.getPackageName()));
                            intent.addFlags(1208483840);
                            preinicio.this.desde_rate = true;
                            try {
                                preinicio.this.startActivity(intent);
                            } catch (Exception unused) {
                                preinicio preinicio = preinicio.this;
                                preinicio.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + preinicio.this.getPackageName())));
                            }
                        } else if (preinicio.this.globales.rate_tipo == 1) {
                            String string = Settings.Secure.getString(preinicio.this.getContentResolver(), "android_id");
                            new config.enviar_sinresp(config.DOM_SRV + "/srv/rate.php?idusu=" + preinicio.this.idusu + "&cod_g=" + preinicio.this.cod_g + "&aid=" + string + "&r=" + ratingBar.getRating(), "Android Vinebre Software").execute(new String[0]);
                            preinicio.this.preiniciar_2();
                        }
                    }
                });
                builder.setNegativeButton(this.globales.rate_ko.equals("") ? getResources().getString(R.string.cancelar) : this.globales.rate_ko, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        preinicio.this.preiniciar_2();
                    }
                });
                if (!this.globales.rate_tit.equals("")) {
                    builder.setTitle(this.globales.rate_tit);
                }
                if (!this.globales.rate_txt.equals("")) {
                    builder.setMessage(this.globales.rate_txt);
                }
                final AlertDialog create = builder.create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
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
            } else {
                preiniciar_2();
            }
        } else {
            preiniciar_2();
        }
    }

    /* access modifiers changed from: protected */
    public void preiniciar_3() {
        if (!this.settings.getBoolean("pwd_validado", true)) {
            preguntar_contra();
        } else {
            iniciar();
        }
    }

    /* access modifiers changed from: private */
    public void mostrar_appnext_agresivo(String str) {
        boolean z = !this.globales.acad_tit.equals("");
        NativeAd nativeAd = !z ? new NativeAd(getApplicationContext(), str) : null;
        findViewById(R.id.iv_splash).setVisibility(8);
        findViewById(R.id.wv_splash).setVisibility(8);
        findViewById(R.id.v_anext).setVisibility(0);
        if (this.globales.pb_tipo == 1) {
            config.progress_color((ProgressBar) findViewById(R.id.progressBar), this.c_icos_orig);
        } else if (this.globales.pb_tipo == 2) {
            config.progress_color((ProgressBar) findViewById(R.id.progressBar), this.globales.pb_c);
        }
        findViewById(R.id.rl_anext).setVisibility(0);
        if (!z) {
            findViewById(R.id.na_view).setVisibility(0);
            nativeAd.setPrivacyPolicyColor(0);
            nativeAd.setAdListener(new NativeAdListener() {
                public void onAdLoaded(NativeAd nativeAd, AppnextAdCreativeType appnextAdCreativeType) {
                    super.onAdLoaded(nativeAd, appnextAdCreativeType);
                    preinicio.this.appnext_agresivo_cargado(false, nativeAd);
                }

                public void onAdClicked(NativeAd nativeAd) {
                    super.onAdClicked(nativeAd);
                }

                public void onError(NativeAd nativeAd, AppnextError appnextError) {
                    super.onError(nativeAd, appnextError);
                    preinicio.this.findViewById(R.id.progressBar).setVisibility(8);
                    if (!preinicio.this.preiniciar_3_llamado) {
                        config.appnext_glob_int = null;
                        preinicio.this.preiniciar_3_llamado = true;
                        preinicio.this.preiniciar_3();
                    }
                }

                public void adImpression(NativeAd nativeAd) {
                    super.adImpression(nativeAd);
                }
            });
            nativeAd.loadAd(new NativeAdRequest().setCachingPolicy(NativeAdRequest.CachingPolicy.STATIC_ONLY).setCreativeType(NativeAdRequest.CreativeType.STATIC_ONLY).setVideoLength(NativeAdRequest.VideoLength.SHORT).setVideoQuality(NativeAdRequest.VideoQuality.LOW));
            return;
        }
        appnext_agresivo_cargado(true, (NativeAd) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(1:2)|3|(2:4|5)|7|(2:9|(1:11))|12|(1:14)|15|(1:17)(1:18)|19|(2:20|21)|22|(1:25)|26|(1:28)(4:29|30|31|32)|34|(2:37|(19:39|40|(2:42|(1:44)(1:45))|46|(1:48)(1:49)|(1:106)(14:53|(1:55)(1:56)|57|58|59|60|61|62|68|(2:71|(1:73)(2:74|(2:78|(2:80|(2:82|(2:84|(1:86)(2:87|(1:89)(1:90)))(3:91|(1:93)(1:94)|95))(3:96|(1:98)(1:99)|100))(3:101|(1:103)(1:104)|105))))|70|76|78|(0)(0))|107|(1:109)(1:110)|111|112|113|(1:116)|117|118|119|120|121|123|(2:125|128)(2:126|127)))|36|40|(0)|46|(0)(0)|(0)(0)|107|(0)(0)|(2:111|112)|113|(0)|117|118|119|120|121|123|(0)(0)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x033c */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void appnext_agresivo_cargado(java.lang.Boolean r22, com.appnext.nativeads.NativeAd r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            boolean r2 = r22.booleanValue()
            r3 = 8
            if (r2 != 0) goto L_0x0016
            r2 = 2131363075(0x7f0a0503, float:1.8345949E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setVisibility(r3)
        L_0x0016:
            r2 = 2131363073(0x7f0a0501, float:1.8345945E38)
            r4 = 3
            android.view.View r5 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0026 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x0026 }
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0026 }
            r5.setTypeface(r6, r4)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0027
        L_0x0026:
        L_0x0027:
            android.content.SharedPreferences r5 = r0.settings
            java.lang.String r6 = "c1_sp"
            java.lang.String r7 = ""
            java.lang.String r5 = r5.getString(r6, r7)
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x005b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "#"
            r5.<init>(r8)
            android.content.SharedPreferences r8 = r0.settings
            java.lang.String r6 = r8.getString(r6, r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            boolean r5 = stikerwap.appdys.config.esClaro(r5)
            if (r5 != 0) goto L_0x005b
            android.view.View r5 = r0.findViewById(r2)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = -1
            r5.setTextColor(r6)
        L_0x005b:
            android.view.View r2 = r0.findViewById(r2)
            r5 = 0
            r2.setVisibility(r5)
            boolean r2 = r22.booleanValue()
            r6 = 2131362906(0x7f0a045a, float:1.8345606E38)
            if (r2 == 0) goto L_0x006d
            goto L_0x007a
        L_0x006d:
            android.view.View r2 = r0.findViewById(r6)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r7 = r23.getIconURL()
            r1.downloadAndDisplayImage(r0, r2, r7)
        L_0x007a:
            boolean r2 = r22.booleanValue()
            r7 = 2131361821(0x7f0a001d, float:1.8343405E38)
            r8 = 2131362909(0x7f0a045d, float:1.8345612E38)
            if (r2 == 0) goto L_0x0094
            android.view.View r2 = r0.findViewById(r7)
            android.widget.TextView r2 = (android.widget.TextView) r2
            stikerwap.appdys.config r9 = r0.globales
            java.lang.String r9 = r9.acad_tit
            r2.setText(r9)
            goto L_0x00a1
        L_0x0094:
            android.view.View r2 = r0.findViewById(r8)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r9 = r23.getAdTitle()
            r2.setText(r9)
        L_0x00a1:
            r9 = 1
            android.graphics.Typeface r10 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x00a7 }
            r2.setTypeface(r10, r9)     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            android.content.res.Resources r10 = r21.getResources()
            r11 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r10 = r10.getBoolean(r11)
            r12 = 4
            if (r10 == 0) goto L_0x00b8
            r2.setTextDirection(r12)
        L_0x00b8:
            boolean r2 = r22.booleanValue()
            r10 = 2131361820(0x7f0a001c, float:1.8343403E38)
            r13 = 0
            if (r2 == 0) goto L_0x00c9
            android.view.View r2 = r0.findViewById(r10)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x00dd
        L_0x00c9:
            r2 = 2131362908(0x7f0a045c, float:1.834561E38)
            android.view.View r2 = r0.findViewById(r2)
            com.appnext.nativeads.MediaView r2 = (com.appnext.nativeads.MediaView) r2
            r2.setMute(r9)     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            r1.setMediaView(r2)
            r20 = r13
            r13 = r2
            r2 = r20
        L_0x00dd:
            android.content.res.Resources r14 = r21.getResources()
            android.content.res.Configuration r14 = r14.getConfiguration()
            int r14 = r14.orientation
            r15 = 2
            if (r14 != r15) goto L_0x00ec
        L_0x00ea:
            r7 = 1
            goto L_0x0123
        L_0x00ec:
            r14 = 372(0x174, float:5.21E-43)
            android.content.Context r8 = r21.getApplicationContext()
            int r8 = stikerwap.appdys.config.dp_to_px(r8, r14)
            android.content.Context r14 = r21.getApplicationContext()
            java.lang.String r6 = "window"
            java.lang.Object r6 = r14.getSystemService(r6)
            android.view.WindowManager r6 = (android.view.WindowManager) r6
            android.view.Display r6 = r6.getDefaultDisplay()
            android.graphics.Point r14 = new android.graphics.Point
            r14.<init>()
            r6.getSize(r14)
            int r6 = r14.y
            double r10 = (double) r6
            r16 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r16
            double r7 = (double) r8
            int r16 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r16 >= 0) goto L_0x0122
            goto L_0x00ea
        L_0x0122:
            r7 = 0
        L_0x0123:
            r8 = 2131361816(0x7f0a0018, float:1.8343395E38)
            r10 = 2131362155(0x7f0a016b, float:1.8344083E38)
            if (r7 == 0) goto L_0x014a
            boolean r7 = r22.booleanValue()
            if (r7 == 0) goto L_0x013e
            r2.setVisibility(r3)
            android.view.View r2 = r0.findViewById(r8)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setMaxLines(r9)
            goto L_0x014a
        L_0x013e:
            r13.setVisibility(r3)
            android.view.View r2 = r0.findViewById(r10)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setMaxLines(r9)
        L_0x014a:
            boolean r2 = r22.booleanValue()
            if (r2 == 0) goto L_0x0155
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.acad_rating
            goto L_0x0159
        L_0x0155:
            java.lang.String r2 = r23.getStoreRating()
        L_0x0159:
            if (r2 == 0) goto L_0x02c2
            int r3 = r2.length()
            if (r3 != r4) goto L_0x02c2
            boolean r3 = r22.booleanValue()
            if (r3 == 0) goto L_0x01c5
            r3 = 2131361823(0x7f0a001f, float:1.834341E38)
            android.view.View r3 = r0.findViewById(r3)
            r7 = 2131361826(0x7f0a0022, float:1.8343415E38)
            android.view.View r7 = r0.findViewById(r7)
            r11 = 2131361829(0x7f0a0025, float:1.8343421E38)
            android.view.View r11 = r0.findViewById(r11)
            r6 = 2131361832(0x7f0a0028, float:1.8343427E38)
            android.view.View r6 = r0.findViewById(r6)
            r14 = 2131361835(0x7f0a002b, float:1.8343434E38)
            android.view.View r14 = r0.findViewById(r14)
            r10 = 2131361828(0x7f0a0024, float:1.834342E38)
            android.view.View r10 = r0.findViewById(r10)
            r8 = 2131361831(0x7f0a0027, float:1.8343425E38)
            android.view.View r8 = r0.findViewById(r8)
            r12 = 2131361834(0x7f0a002a, float:1.8343432E38)
            android.view.View r12 = r0.findViewById(r12)
            r4 = 2131361837(0x7f0a002d, float:1.8343438E38)
            android.view.View r4 = r0.findViewById(r4)
            r15 = 2131361827(0x7f0a0023, float:1.8343417E38)
            android.view.View r15 = r0.findViewById(r15)
            r5 = 2131361830(0x7f0a0026, float:1.8343423E38)
            android.view.View r5 = r0.findViewById(r5)
            r9 = 2131361833(0x7f0a0029, float:1.834343E38)
            android.view.View r9 = r0.findViewById(r9)
            r18 = r3
            r3 = 2131361836(0x7f0a002c, float:1.8343436E38)
            android.view.View r3 = r0.findViewById(r3)
            goto L_0x0222
        L_0x01c5:
            r3 = 2131363080(0x7f0a0508, float:1.8345959E38)
            android.view.View r3 = r0.findViewById(r3)
            r4 = 2131363083(0x7f0a050b, float:1.8345965E38)
            android.view.View r7 = r0.findViewById(r4)
            r4 = 2131363086(0x7f0a050e, float:1.834597E38)
            android.view.View r11 = r0.findViewById(r4)
            r4 = 2131363089(0x7f0a0511, float:1.8345977E38)
            android.view.View r6 = r0.findViewById(r4)
            r4 = 2131363092(0x7f0a0514, float:1.8345983E38)
            android.view.View r14 = r0.findViewById(r4)
            r4 = 2131363085(0x7f0a050d, float:1.8345969E38)
            android.view.View r10 = r0.findViewById(r4)
            r4 = 2131363088(0x7f0a0510, float:1.8345975E38)
            android.view.View r8 = r0.findViewById(r4)
            r4 = 2131363091(0x7f0a0513, float:1.8345981E38)
            android.view.View r12 = r0.findViewById(r4)
            r4 = 2131363094(0x7f0a0516, float:1.8345987E38)
            android.view.View r4 = r0.findViewById(r4)
            r5 = 2131363084(0x7f0a050c, float:1.8345967E38)
            android.view.View r15 = r0.findViewById(r5)
            r5 = 2131363087(0x7f0a050f, float:1.8345973E38)
            android.view.View r5 = r0.findViewById(r5)
            r9 = 2131363090(0x7f0a0512, float:1.834598E38)
            android.view.View r9 = r0.findViewById(r9)
            r18 = r3
            r3 = 2131363093(0x7f0a0515, float:1.8345985E38)
            android.view.View r3 = r0.findViewById(r3)
        L_0x0222:
            r1 = r15
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r18
            r18 = r13
            r0 = 0
            r13 = 1
            java.lang.String r19 = r2.substring(r0, r13)     // Catch:{ Exception -> 0x024d }
            int r0 = java.lang.Integer.parseInt(r19)     // Catch:{ Exception -> 0x024d }
            r19 = r0
            r0 = 3
            r13 = 2
            java.lang.String r2 = r2.substring(r13, r0)     // Catch:{ Exception -> 0x0249 }
            int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0249 }
            goto L_0x0252
        L_0x0249:
            r0 = r19
            goto L_0x024f
        L_0x024d:
            r0 = 0
        L_0x024f:
            r19 = r0
            r0 = 0
        L_0x0252:
            r13 = 3
            if (r0 >= r13) goto L_0x0259
        L_0x0255:
            r13 = r19
            r0 = 0
            goto L_0x0262
        L_0x0259:
            r13 = 7
            if (r0 <= r13) goto L_0x025f
            int r19 = r19 + 1
            goto L_0x0255
        L_0x025f:
            r13 = r19
            r0 = 5
        L_0x0262:
            if (r13 <= 0) goto L_0x02c4
            r2 = 6
            if (r13 >= r2) goto L_0x02c4
            r2 = 0
            r3.setVisibility(r2)
            r3 = 1
            if (r13 <= r3) goto L_0x02ae
            r8.setVisibility(r2)
            r1 = 2
            if (r13 <= r1) goto L_0x029d
            r12.setVisibility(r2)
            r1 = 3
            if (r13 <= r1) goto L_0x028f
            r7.setVisibility(r2)
            r1 = 4
            if (r13 <= r1) goto L_0x0284
            r15.setVisibility(r2)
            goto L_0x02c4
        L_0x0284:
            r3 = 5
            if (r0 != r3) goto L_0x028b
            r5.setVisibility(r2)
            goto L_0x02c4
        L_0x028b:
            r4.setVisibility(r2)
            goto L_0x02c4
        L_0x028f:
            r3 = 5
            if (r0 != r3) goto L_0x0296
            r14.setVisibility(r2)
            goto L_0x0299
        L_0x0296:
            r10.setVisibility(r2)
        L_0x0299:
            r4.setVisibility(r2)
            goto L_0x02c4
        L_0x029d:
            r3 = 5
            if (r0 != r3) goto L_0x02a4
            r9.setVisibility(r2)
            goto L_0x02a7
        L_0x02a4:
            r6.setVisibility(r2)
        L_0x02a7:
            r10.setVisibility(r2)
            r4.setVisibility(r2)
            goto L_0x02c4
        L_0x02ae:
            r3 = 5
            if (r0 != r3) goto L_0x02b5
            r11.setVisibility(r2)
            goto L_0x02b8
        L_0x02b5:
            r1.setVisibility(r2)
        L_0x02b8:
            r6.setVisibility(r2)
            r10.setVisibility(r2)
            r4.setVisibility(r2)
            goto L_0x02c4
        L_0x02c2:
            r18 = r13
        L_0x02c4:
            boolean r0 = r22.booleanValue()
            r1 = 2131361817(0x7f0a0019, float:1.8343397E38)
            if (r0 == 0) goto L_0x02ef
            r2 = 2131361816(0x7f0a0018, float:1.8343395E38)
            r0 = r21
            android.view.View r3 = r0.findViewById(r2)
            android.widget.TextView r3 = (android.widget.TextView) r3
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.acad_descr
            r3.setText(r2)
            r2 = 2131361815(0x7f0a0017, float:1.8343393E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.view.View r4 = r0.findViewById(r1)
            android.widget.Button r4 = (android.widget.Button) r4
            goto L_0x0313
        L_0x02ef:
            r2 = 2131362155(0x7f0a016b, float:1.8344083E38)
            r0 = r21
            android.view.View r3 = r0.findViewById(r2)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r2 = r23.getAdDescription()
            r3.setText(r2)
            r2 = 2131362125(0x7f0a014d, float:1.8344022E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r4 = 2131362405(0x7f0a0265, float:1.834459E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.Button r4 = (android.widget.Button) r4
        L_0x0313:
            android.graphics.Typeface r5 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0318 }
            r3.setTypeface(r5)     // Catch:{ Exception -> 0x0318 }
        L_0x0318:
            android.content.res.Resources r5 = r21.getResources()
            r6 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r5 = r5.getBoolean(r6)
            if (r5 == 0) goto L_0x0329
            r5 = 4
            r3.setTextDirection(r5)
        L_0x0329:
            android.content.res.Resources r3 = r21.getResources()
            r5 = 2131886116(0x7f120024, float:1.9406802E38)
            java.lang.String r3 = r3.getString(r5)
            r4.setText(r3)
            android.graphics.Typeface r3 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x033c }
            r4.setTypeface(r3)     // Catch:{ Exception -> 0x033c }
        L_0x033c:
            android.graphics.Typeface r3 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x0342 }
            r2.setTypeface(r3)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0343
        L_0x0342:
        L_0x0343:
            stikerwap.appdys.preinicio$26 r3 = new stikerwap.appdys.preinicio$26
            r3.<init>()
            r2.setOnClickListener(r3)
            boolean r2 = r22.booleanValue()
            if (r2 == 0) goto L_0x03a9
            r2 = 2131361819(0x7f0a001b, float:1.8343401E38)
            android.view.View r2 = r0.findViewById(r2)
            stikerwap.appdys.preinicio$27 r3 = new stikerwap.appdys.preinicio$27
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 2131361821(0x7f0a001d, float:1.8343405E38)
            android.view.View r2 = r0.findViewById(r2)
            stikerwap.appdys.preinicio$28 r3 = new stikerwap.appdys.preinicio$28
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 2131361838(0x7f0a002e, float:1.834344E38)
            android.view.View r2 = r0.findViewById(r2)
            stikerwap.appdys.preinicio$29 r3 = new stikerwap.appdys.preinicio$29
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 2131361816(0x7f0a0018, float:1.8343395E38)
            android.view.View r2 = r0.findViewById(r2)
            stikerwap.appdys.preinicio$30 r3 = new stikerwap.appdys.preinicio$30
            r3.<init>()
            r2.setOnClickListener(r3)
            android.view.View r1 = r0.findViewById(r1)
            stikerwap.appdys.preinicio$31 r2 = new stikerwap.appdys.preinicio$31
            r2.<init>()
            r1.setOnClickListener(r2)
            r1 = 2131361820(0x7f0a001c, float:1.8343403E38)
            android.view.View r1 = r0.findViewById(r1)
            stikerwap.appdys.preinicio$32 r2 = new stikerwap.appdys.preinicio$32
            r2.<init>()
            r1.setOnClickListener(r2)
            goto L_0x03ef
        L_0x03a9:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 2131362906(0x7f0a045a, float:1.8345606E38)
            android.view.View r2 = r0.findViewById(r2)
            r1.add(r2)
            r2 = 2131362909(0x7f0a045d, float:1.8345612E38)
            android.view.View r2 = r0.findViewById(r2)
            r1.add(r2)
            r2 = 2131363095(0x7f0a0517, float:1.834599E38)
            android.view.View r2 = r0.findViewById(r2)
            r1.add(r2)
            r2 = 2131362155(0x7f0a016b, float:1.8344083E38)
            android.view.View r2 = r0.findViewById(r2)
            r1.add(r2)
            r1.add(r4)
            r13 = r18
            r1.add(r13)
            r2 = r23
            r2.registerClickableViews((java.util.List<android.view.View>) r1)
            r1 = 2131362910(0x7f0a045e, float:1.8345614E38)
            android.view.View r1 = r0.findViewById(r1)
            com.appnext.nativeads.NativeAdView r1 = (com.appnext.nativeads.NativeAdView) r1
            r2.setNativeAdView(r1)
        L_0x03ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.appnext_agresivo_cargado(java.lang.Boolean, com.appnext.nativeads.NativeAd):void");
    }

    /* access modifiers changed from: private */
    public void abrir_acad() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.globales.acad_package + "&referrer=" + this.globales.acad_ref)));
        new config.enviar_sinresp(config.DOM_SRV + "/srv/acad.php?idapp=3008836&idusu=" + this.idusu + "&tipo=2&ref=" + this.globales.acad_ref, "Android Vinebre Software").execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public void preiniciar_2() {
        this.mostrar_ad_entrar = false;
        this.mostrar_fb_entrar = false;
        int i = this.globales.toca_intentrar();
        final String str = null;
        int i2 = 1;
        if (i == 2 || i == 5) {
            if (i != 5 && !config.hay_conn_rapida(this)) {
                config.appnext_glob_int = new Interstitial(getApplicationContext(), config.appnext_cod_int_e);
                config.appnext_glob_int.setMute(true);
                if (!config.autoplay.booleanValue()) {
                    config.appnext_glob_int.setAutoPlay(false);
                }
                config.appnext_glob_int.setBackButtonCanClose(true);
                config.appnext_glob_int.setSkipText(getResources().getString(R.string.ad_saltar));
                config.appnext_glob_int.setOnAdLoadedCallback(new OnAdLoaded() {
                    public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
                        try {
                            config.appnext_glob_int.showAd();
                        } catch (Exception unused) {
                        }
                    }
                });
                config.appnext_glob_int.setOnAdClosedCallback(new OnAdClosed() {
                    public void onAdClosed() {
                        config.appnext_glob_int = null;
                    }
                });
                config.appnext_glob_int.setOnAdErrorCallback(new OnAdError() {
                    public void adError(String str) {
                        Log.e("ara", "Appnext 2 error:" + str);
                        config.appnext_glob_int = null;
                    }
                });
                config.appnext_glob_int.loadAd();
                preiniciar_3();
            } else if (i == 5 || config.appnext_ent_modo == 1) {
                if (i == 2) {
                    str = config.appnext_cod_int_e;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.5f, 1, 0.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(500);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        preinicio.this.mostrar_appnext_agresivo(str);
                    }
                });
                ImageView imageView = (ImageView) findViewById(R.id.iv_splash);
                WebView webView = (WebView) findViewById(R.id.wv_splash);
                if (webView.getVisibility() == 0) {
                    webView.setVisibility(8);
                    findViewById(R.id.v_anext).setVisibility(8);
                    findViewById(R.id.rl_anext).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    mostrar_appnext_agresivo(str);
                } else if (imageView.getVisibility() == 0) {
                    imageView.startAnimation(scaleAnimation);
                } else {
                    findViewById(R.id.v_anext).setVisibility(8);
                    findViewById(R.id.rl_anext).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    mostrar_appnext_agresivo(str);
                }
            } else {
                config.appnext_glob_int = new Interstitial(getApplicationContext(), config.appnext_cod_int_e);
                config.appnext_glob_int.setMute(true);
                if (!config.autoplay.booleanValue()) {
                    config.appnext_glob_int.setAutoPlay(false);
                }
                config.appnext_glob_int.setBackButtonCanClose(true);
                config.appnext_glob_int.setSkipText(getResources().getString(R.string.ad_saltar));
                config.appnext_glob_int.setOnAdLoadedCallback(new OnAdLoaded() {
                    public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
                        preinicio.this.desde_appnext = true;
                        try {
                            config.appnext_glob_int.showAd();
                        } catch (Exception unused) {
                            if (!preinicio.this.preiniciar_3_llamado) {
                                config.appnext_glob_int = null;
                                preinicio.this.preiniciar_3_llamado = true;
                                preinicio.this.preiniciar_3();
                            }
                        }
                    }
                });
                config.appnext_glob_int.setOnAdErrorCallback(new OnAdError() {
                    public void adError(String str) {
                        Log.e("ara", "Appnext 1 error:" + str);
                        if (!preinicio.this.preiniciar_3_llamado) {
                            config.appnext_glob_int = null;
                            preinicio.this.preiniciar_3_llamado = true;
                            preinicio.this.preiniciar_3();
                        }
                    }
                });
                config.appnext_glob_int.loadAd();
            }
        } else if (i == 1) {
            if (!config.admob_appopen_cod.equals("")) {
                AdRequest build = new AdRequest.Builder().build();
                if (getResources().getConfiguration().orientation == 2) {
                    i2 = 2;
                }
                AppOpenAd.load((Context) this, config.admob_appopen_cod, build, i2, (AppOpenAd.AppOpenAdLoadCallback) new AppOpenAd.AppOpenAdLoadCallback() {
                    public void onAdLoaded(AppOpenAd appOpenAd) {
                        appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            public void onAdShowedFullScreenContent() {
                            }

                            public void onAdDismissedFullScreenContent() {
                                preinicio.this.preiniciar_3();
                            }

                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                preinicio.this.preiniciar_3();
                            }
                        });
                        appOpenAd.show(this);
                    }

                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        preinicio.this.preiniciar_3();
                    }
                });
                return;
            }
            InterstitialAd.load(this, config.admob_int_cod, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                public void onAdLoaded(InterstitialAd interstitialAd) {
                    config.interstitial_glob = interstitialAd;
                    config.interstitial_glob.setFullScreenContentCallback(new FullScreenContentCallback() {
                        public void onAdDismissedFullScreenContent() {
                            preinicio.this.preiniciar_3();
                        }

                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            preinicio.this.mostrar_ad_entrar = true;
                            preinicio.this.preiniciar_3();
                        }

                        public void onAdShowedFullScreenContent() {
                            config.interstitial_glob = null;
                        }
                    });
                    try {
                        config.interstitial_glob.show(preinicio.this);
                    } catch (Exception unused) {
                        preinicio.this.mostrar_ad_entrar = true;
                        preinicio.this.preiniciar_3();
                    }
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    config.interstitial_glob = null;
                    preinicio.this.mostrar_ad_entrar = true;
                    preinicio.this.preiniciar_3();
                }
            });
        } else if (i == 3) {
            this.mostrar_fb_entrar = true;
            preiniciar_3();
        } else if (i == 4) {
            config.st_glob_int = new StartAppAd(getApplicationContext());
            config.st_glob_int.loadAd((AdEventListener) new AdEventListener() {
                public void onReceiveAd(Ad ad) {
                    if (config.st_glob_int == null) {
                        preinicio.this.preiniciar_3();
                    } else {
                        config.st_glob_int.showAd(config.our == 1 ? "Intersticial entrada" : "INTERSTITIAL", new AdDisplayListener() {
                            public void adClicked(Ad ad) {
                            }

                            public void adDisplayed(Ad ad) {
                            }

                            public void adHidden(Ad ad) {
                                config.st_glob_int = null;
                                preinicio.this.preiniciar_3();
                            }

                            public void adNotDisplayed(Ad ad) {
                                config.st_glob_int = null;
                                preinicio.this.preiniciar_3();
                            }
                        });
                    }
                }

                public void onFailedToReceiveAd(Ad ad) {
                    config.st_glob_int = null;
                    preinicio.this.preiniciar_3();
                }
            });
        } else if (i == 9) {
            config.toca_int = 9;
            preiniciar_3();
        } else if (i == 10) {
            config.toca_int = 10;
            preiniciar_3();
        } else if (i == 12) {
            if (config.wortise_glob_int != null) {
                config.wortise_glob_int.destroy();
            }
            config.wortise_glob_int = null;
            config.wortise_glob_int = new com.wortise.ads.interstitial.InterstitialAd(this, config.wortise_int_cod);
            config.wortise_glob_int.setListener(new InterstitialAd.Listener() {
                public void onInterstitialClicked(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                }

                public void onInterstitialShown(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                }

                public void onInterstitialDismissed(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                    preinicio.this.preiniciar_3();
                }

                public void onInterstitialFailed(com.wortise.ads.interstitial.InterstitialAd interstitialAd, com.wortise.ads.AdError adError) {
                    if (config.wortise_glob_int != null) {
                        config.wortise_glob_int.destroy();
                    }
                    config.wortise_glob_int = null;
                    preinicio.this.preiniciar_3();
                }

                public void onInterstitialLoaded(com.wortise.ads.interstitial.InterstitialAd interstitialAd) {
                    interstitialAd.showAd();
                }
            });
            config.wortise_glob_int.loadAd();
        } else {
            preiniciar_3();
        }
    }

    /* access modifiers changed from: private */
    public void iniciar() {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        Bundle bundle5;
        boolean z;
        Bundle bundle6;
        Intent intent;
        String str = "";
        if (this.globales.glob_acceso <= 0 || ((this.globales.glob_acceso <= 1 || this.settings.getBoolean("glob_acceso_validado", false)) && !this.settings.getString("nick", str).equals(str) && ((this.globales.fb_modo != 3 || this.settings.getBoolean("email_confirmado", false)) && ((this.globales.glob_fotos_perfil != 2 || this.globales.getTempFile(this, 1).exists()) && (!(this.globales.glob_fnac == 2 && (this.settings.getInt("fnac_d", 0) == 0 || this.settings.getInt("fnac_m", 0) == 0 || this.settings.getInt("fnac_a", 0) == 0)) && (!(this.globales.glob_sexo == 2 && this.settings.getInt("sexo", 0) == 0) && (this.globales.glob_descr != 2 || !this.settings.getString("descr", str).equals(str)))))))) {
            Bundle bundle7 = this.extras;
            if (bundle7 == null || bundle7.getString("abrir_perfil") == null) {
                Bundle bundle8 = this.extras;
                if (bundle8 == null || bundle8.getString("notif_id") == null || !this.extras.getString("notif_tipo").equals("2")) {
                    Bundle bundle9 = this.extras;
                    if (bundle9 != null && bundle9.getString("notif_id") != null && this.extras.getString("notif_tipo").equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        Intent intent2 = new Intent(this, chat.class);
                        if (this.mostrar_ad_entrar) {
                            intent2.putExtra("ad_entrar", true);
                        } else if (this.mostrar_fb_entrar) {
                            intent2.putExtra("fb_entrar", true);
                        }
                        this.globales.ind_secc_sel = 900;
                        SharedPreferences.Editor edit = this.settings.edit();
                        edit.putInt("ind_secc_sel", this.globales.ind_secc_sel);
                        edit.commit();
                        if (this.globales.tipomenu == 2) {
                            Intent intent3 = new Intent(this, t_menugrid.class);
                            intent3.putExtra("intent_abrir", intent2);
                            intent3.putExtra("es_root", true);
                            startActivity(intent3);
                        } else {
                            intent2.putExtra("es_root", true);
                            startActivity(intent2);
                        }
                    } else if (this.globales.tipomenu != 2 || (!(((bundle2 = this.extras) != null && bundle2.getString("notif_id") != null && this.extras.getString("notif_tipo").equals("0")) || (bundle6 = this.extras) == null || bundle6.getString("notif_id") == null) || (!((bundle3 = this.extras) == null || (bundle3.getString("notif_idtema") == null && this.extras.getString("id_remit") == null)) || (!((bundle4 = this.extras) == null || bundle4.getString("abrir_idtema") == null) || (!((bundle5 = this.extras) == null || bundle5.getString("abrir_idsecc") == null) || (getIntent().getDataString() != null && !getIntent().getDataString().endsWith("www.appcreator24.com/open3008836-cfolv1/"))))))) {
                        if (this.ord_secc_abrir == 9997 || this.globales.secciones_a[this.ord_secc_abrir].oculta) {
                            this.globales.ind_secc_sel = 900;
                            SharedPreferences.Editor edit2 = this.settings.edit();
                            edit2.putInt("ind_secc_sel", this.globales.ind_secc_sel);
                            edit2.commit();
                        }
                        ResultGetIntent crear_rgi = this.globales.crear_rgi(Integer.valueOf(this.ord_secc_abrir), this);
                        if (this.mostrar_ad_entrar) {
                            crear_rgi.i.putExtra("ad_entrar", true);
                        } else if (this.mostrar_fb_entrar) {
                            crear_rgi.i.putExtra("fb_entrar", true);
                        }
                        Bundle bundle10 = this.extras;
                        if (bundle10 == null || bundle10.getString("id_remit") == null) {
                            Bundle bundle11 = this.extras;
                            if (bundle11 == null || bundle11.getString("abrir_idtema") == null) {
                                Bundle bundle12 = this.extras;
                                if (!(bundle12 == null || bundle12.getString("abrir_buscvideo") == null)) {
                                    crear_rgi.i.putExtra("abrir_idsecc", this.extras.getString("abrir_idsecc"));
                                    crear_rgi.i.putExtra("abrir_buscvideo", this.extras.getString("abrir_buscvideo"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_formato", this.extras.getString("abrir_buscvideo_formato"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_idusu", this.extras.getString("abrir_buscvideo_idusu"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_nombre", this.extras.getString("abrir_buscvideo_nombre"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_nlikes", this.extras.getString("abrir_buscvideo_nlikes"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_liked", this.extras.getString("abrir_buscvideo_liked"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_descr", this.extras.getString("abrir_buscvideo_descr"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_nvideos", this.extras.getString("abrir_buscvideo_nvideos"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_fcrea", this.extras.getString("abrir_buscvideo_fcrea"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_coments", this.extras.getString("abrir_buscvideo_coments"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_fnac_d", this.extras.getString("abrir_buscvideo_fnac_d"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_fnac_m", this.extras.getString("abrir_buscvideo_fnac_m"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_fnac_a", this.extras.getString("abrir_buscvideo_fnac_a"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_sexo", this.extras.getString("abrir_buscvideo_sexo"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_privados", this.extras.getString("abrir_buscvideo_privados"));
                                    crear_rgi.i.putExtra("abrir_buscvideo_vfoto", this.extras.getString("abrir_buscvideo_vfoto"));
                                }
                            } else {
                                crear_rgi.i.putExtra("abrir_idcat", this.extras.getString("abrir_idcat"));
                                crear_rgi.i.putExtra("abrir_idtema", this.extras.getString("abrir_idtema"));
                                if (this.extras.getString("abrir_idresp") != null) {
                                    crear_rgi.i.putExtra("abrir_idresp", this.extras.getString("abrir_idresp"));
                                    crear_rgi.i.putExtra("idcoment_ir", this.extras.getString("idcoment_ir"));
                                } else {
                                    crear_rgi.i.putExtra("idresp_ir", this.extras.getString("idresp_ir"));
                                }
                            }
                        } else {
                            crear_rgi.i.putExtra("id_remit", this.extras.getString("id_remit"));
                            crear_rgi.i.putExtra("nombre_remit", this.extras.getString("nombre_remit"));
                            if (this.directo) {
                                crear_rgi.i.putExtra("empezar_privado", true);
                            }
                        }
                        if (!(this.ord_secc_abrir != 9997 || (bundle = this.extras) == null || (bundle.getString("id_remit") == null && this.extras.getString("notif_idtema") == null))) {
                            crear_rgi.i.putExtra("externo", true);
                            if (this.extras.getString("id_remit") != null) {
                                crear_rgi.i.putExtra("idchat", 0);
                                crear_rgi.i.putExtra("idtema", 0);
                                crear_rgi.i.putExtra("fotos_perfil", 1);
                                crear_rgi.i.putExtra("fnac", 1);
                                crear_rgi.i.putExtra("sexo", 1);
                                crear_rgi.i.putExtra("descr", 1);
                                crear_rgi.i.putExtra("dist", 1);
                                crear_rgi.i.putExtra("privados", true);
                                crear_rgi.i.putExtra("coments", true);
                                crear_rgi.i.putExtra("galeria", true);
                                crear_rgi.i.putExtra("fotos_chat", 1);
                                String str2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
                                String str3 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
                                crear_rgi.i.putExtra("c1", str2.equals(str) ? this.globales.c1 : str2);
                                Intent intent4 = crear_rgi.i;
                                if (str2.equals(str)) {
                                    str3 = this.globales.c2;
                                }
                                intent4.putExtra("c2", str3);
                            } else {
                                crear_rgi.i.putExtra("idchat", Integer.parseInt(this.extras.getString("notif_idsecc")));
                                crear_rgi.i.putExtra("idtema", Integer.parseInt(this.extras.getString("notif_idtema")));
                                crear_rgi.i.putExtra("fotos_perfil", this.extras.getInt("fotos_perfil"));
                                crear_rgi.i.putExtra("fnac", this.extras.getInt("fnac"));
                                crear_rgi.i.putExtra("sexo", this.extras.getInt("sexo"));
                                crear_rgi.i.putExtra("descr", this.extras.getInt("descr"));
                                crear_rgi.i.putExtra("dist", this.extras.getInt("dist"));
                                crear_rgi.i.putExtra("privados", this.extras.getBoolean("privados"));
                                crear_rgi.i.putExtra("coments", this.extras.getBoolean("coments"));
                                crear_rgi.i.putExtra("galeria", this.extras.getBoolean("galeria"));
                                crear_rgi.i.putExtra("fotos_chat", this.extras.getInt("fotos_chat"));
                                crear_rgi.i.putExtra("c1", this.extras.getString("c1"));
                                crear_rgi.i.putExtra("c2", this.extras.getString("c2"));
                            }
                        }
                        if (this.globales.tipomenu == 2) {
                            Intent intent5 = new Intent(this, t_menugrid.class);
                            intent5.putExtra("intent_abrir", crear_rgi.i);
                            intent5.putExtra("es_root", true);
                            startActivity(intent5);
                        } else {
                            crear_rgi.i.putExtra("es_root", true);
                            startActivity(crear_rgi.i);
                        }
                    } else {
                        Intent intent6 = new Intent(this, t_menugrid.class);
                        if (this.mostrar_ad_entrar) {
                            z = true;
                            intent6.putExtra("ad_entrar", true);
                        } else {
                            z = true;
                            if (this.mostrar_fb_entrar) {
                                intent6.putExtra("fb_entrar", true);
                            }
                        }
                        this.globales.ind_secc_sel = 900;
                        SharedPreferences.Editor edit3 = this.settings.edit();
                        edit3.putInt("ind_secc_sel", this.globales.ind_secc_sel);
                        edit3.commit();
                        intent6.putExtra("es_root", z);
                        startActivity(intent6);
                    }
                } else {
                    Intent intent7 = new Intent(this, t_url.class);
                    if (this.mostrar_ad_entrar) {
                        intent7.putExtra("ad_entrar", true);
                    } else if (this.mostrar_fb_entrar) {
                        intent7.putExtra("fb_entrar", true);
                    }
                    intent7.putExtra("url", this.extras.getString("notif_idelem"));
                    this.globales.ind_secc_sel = 900;
                    SharedPreferences.Editor edit4 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                    edit4.putInt("ind_secc_sel", this.globales.ind_secc_sel);
                    edit4.commit();
                    if (this.globales.tipomenu == 2) {
                        Intent intent8 = new Intent(this, t_menugrid.class);
                        intent8.putExtra("intent_abrir", intent7);
                        intent8.putExtra("es_root", true);
                        startActivity(intent8);
                    } else {
                        intent7.putExtra("es_root", true);
                        startActivity(intent7);
                    }
                }
            } else {
                this.globales.ind_secc_sel = this.ord_secc_abrir;
                this.globales.ind_secc_sel_2 = this.ord_secc_abrir;
                if (this.ord_secc_abrir == 9997 || this.globales.secciones_a[this.ord_secc_abrir].oculta) {
                    this.globales.ind_secc_sel = 900;
                    if (this.ord_secc_abrir == 9997) {
                        this.globales.ind_secc_sel_2 = 0;
                    }
                }
                SharedPreferences.Editor edit5 = this.settings.edit();
                edit5.putInt("ind_secc_sel", this.globales.ind_secc_sel);
                edit5.putInt("ind_secc_sel_2", this.globales.ind_secc_sel_2);
                edit5.commit();
                if (this.extras.containsKey("abrir_perfilv")) {
                    if (this.extras.getString("abrir_perfilv_formato").equals("1")) {
                        str = "mp4";
                    } else if (this.extras.getString("abrir_perfilv_formato").equals("2")) {
                        str = "3gp";
                    } else if (this.extras.getString("abrir_perfilv_formato").equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        str = "webm";
                    }
                }
                if (!this.extras.containsKey("abrir_perfilv") || str.isEmpty()) {
                    intent = new Intent(this, profile.class);
                    intent.putExtra("id", this.extras.getString("abrir_perfil"));
                    intent.putExtra("privados", this.extras.getString("privados"));
                    intent.putExtra("nombre", this.extras.getString("nombre"));
                    intent.putExtra("coments", this.extras.getString("coments"));
                    intent.putExtra("fnac_d", this.extras.getString("fnac_d"));
                    intent.putExtra("fnac_m", this.extras.getString("fnac_m"));
                    intent.putExtra("fnac_a", this.extras.getString("fnac_a"));
                    intent.putExtra("sexo", this.extras.getString("sexo"));
                    intent.putExtra("vfoto", this.extras.getString("vfoto"));
                    intent.putExtra("p_fnac", this.extras.getInt("p_fnac"));
                    intent.putExtra("p_sexo", this.extras.getInt("p_sexo"));
                    intent.putExtra("p_descr", this.extras.getInt("p_descr"));
                    intent.putExtra("p_dist", this.extras.getInt("p_dist"));
                    intent.putExtra("coments_chat", this.extras.getBoolean("coments_chat"));
                    intent.putExtra("galeria", this.extras.getBoolean("galeria"));
                    intent.putExtra("privados_chat", this.extras.getBoolean("privados_chat"));
                    intent.putExtra("fotos_perfil", this.extras.getInt("fotos_perfil"));
                    intent.putExtra("fotos_chat", this.extras.getInt("fotos_chat"));
                    if (this.extras.containsKey("abrir_game")) {
                        intent.putExtra("abrir_game", this.extras.getString("abrir_game"));
                    }
                } else {
                    String string = this.extras.getString("abrir_perfil");
                    String string2 = this.extras.getString("abrir_perfilv");
                    intent = new Intent(this, t_video_pro.class);
                    intent.putExtra("url", "https://video." + config.DOM_EDROID + "/files_pro/v" + string2 + "_" + string + "." + str);
                    intent.putExtra("ind", this.globales.ind_secc_sel_2);
                    intent.putExtra("idv", string2);
                    intent.putExtra("indv", -1);
                    intent.putExtra("idusu_profile", string);
                    intent.putExtra("coments", this.extras.getString("coments"));
                    intent.putExtra("p_fnac", this.extras.getInt("p_fnac"));
                    intent.putExtra("p_sexo", this.extras.getInt("p_sexo"));
                    intent.putExtra("p_descr", this.extras.getInt("p_descr"));
                    intent.putExtra("p_dist", this.extras.getInt("p_dist"));
                    intent.putExtra("coments_chat", this.extras.getBoolean("coments_chat"));
                    intent.putExtra("galeria", this.extras.getBoolean("galeria"));
                    intent.putExtra("privados_chat", this.extras.getBoolean("privados_chat"));
                    intent.putExtra("fotos_perfil", this.extras.getInt("fotos_perfil"));
                    intent.putExtra("fotos_chat", this.extras.getInt("fotos_chat"));
                }
                if (this.globales.tipomenu == 2) {
                    Intent intent9 = new Intent(this, t_menugrid.class);
                    intent9.putExtra("intent_abrir", intent);
                    intent9.putExtra("es_root", true);
                    startActivity(intent9);
                } else {
                    intent.putExtra("es_root", true);
                    startActivity(intent);
                }
            }
        } else {
            Intent intent10 = new Intent(this, chat_perfil.class);
            if (this.mostrar_ad_entrar) {
                intent10.putExtra("ad_entrar", true);
            } else if (this.mostrar_fb_entrar) {
                intent10.putExtra("fb_entrar", true);
            }
            intent10.putExtra("desde_main", true);
            intent10.putExtra("desde_main_oblig", true);
            this.globales.ind_secc_sel = 900;
            intent10.putExtra("es_root", true);
            startActivity(intent10);
        }
        finish();
    }

    private class cargarsplash extends AsyncTask<String, Void, Byte> {
        String vfoto;

        private cargarsplash() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0061 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r0 = "/srv/imgs/gen/3008836_splash.png?v="
                r1 = 0
                r6 = r6[r1]
                r5.vfoto = r6
                r6 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x006b }
                r3.<init>()     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.String r4 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x006b }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x006b }
                r3.append(r0)     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.String r0 = r5.vfoto     // Catch:{ MalformedURLException -> 0x006b }
                r3.append(r0)     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.String r0 = r3.toString()     // Catch:{ MalformedURLException -> 0x006b }
                r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x006b }
                java.net.URLConnection r0 = r2.openConnection()     // Catch:{ IOException -> 0x0066 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0066 }
                r2 = 1
                r0.setDoInput(r2)     // Catch:{ IOException -> 0x0066 }
                r2 = 5000(0x1388, float:7.006E-42)
                r0.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0066 }
                r2 = 7000(0x1b58, float:9.809E-42)
                r0.setReadTimeout(r2)     // Catch:{ IOException -> 0x0066 }
                r0.connect()     // Catch:{ IOException -> 0x0066 }
                java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0066 }
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this     // Catch:{ IOException -> 0x0066 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ IOException -> 0x0066 }
                r2.bm_splash = r0     // Catch:{ IOException -> 0x0066 }
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0061 }
                java.lang.String r2 = "splash"
                java.io.FileOutputStream r0 = r0.openFileOutput(r2, r1)     // Catch:{ Exception -> 0x0061 }
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0061 }
                android.graphics.Bitmap r2 = r2.bm_splash     // Catch:{ Exception -> 0x0061 }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0061 }
                r4 = 100
                r2.compress(r3, r4, r0)     // Catch:{ Exception -> 0x0061 }
                r0.close()     // Catch:{ Exception -> 0x0061 }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r1)
                return r6
            L_0x0061:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ IOException -> 0x0066 }
                return r6
            L_0x0066:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            L_0x006b:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargarsplash.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            preinicio.this.mostrar_pb(R.string.cargando_splash);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            preinicio.this.ocultar_pb();
            if (b.byteValue() == -1) {
                preinicio.this.marcar_guardado = false;
            } else {
                ImageView imageView = (ImageView) preinicio.this.findViewById(R.id.iv_splash);
                try {
                    preinicio.this.globales.tratar_fondo(imageView, Boolean.valueOf(preinicio.this.globales.splash_margen), preinicio.this.globales.splash_tipo);
                } catch (Exception unused) {
                }
                imageView.setImageBitmap(preinicio.this.bm_splash);
                imageView.setVisibility(0);
            }
            preinicio.this.mirar_font();
        }
    }

    private class cargarfont extends AsyncTask<String, Void, Byte> {
        String vfont;

        private cargarfont() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r0 = "/srv/imgs/fonts/app3008836.ttf?v="
                r1 = 0
                r6 = r6[r1]
                r5.vfont = r6
                r6 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0069 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0069 }
                r3.<init>()     // Catch:{ MalformedURLException -> 0x0069 }
                java.lang.String r4 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x0069 }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x0069 }
                r3.append(r0)     // Catch:{ MalformedURLException -> 0x0069 }
                java.lang.String r0 = r5.vfont     // Catch:{ MalformedURLException -> 0x0069 }
                r3.append(r0)     // Catch:{ MalformedURLException -> 0x0069 }
                java.lang.String r0 = r3.toString()     // Catch:{ MalformedURLException -> 0x0069 }
                r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x0069 }
                java.net.URLConnection r0 = r2.openConnection()     // Catch:{ IOException -> 0x0064 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0064 }
                r2 = 1
                r0.setDoInput(r2)     // Catch:{ IOException -> 0x0064 }
                r2 = 5000(0x1388, float:7.006E-42)
                r0.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0064 }
                r2 = 7000(0x1b58, float:9.809E-42)
                r0.setReadTimeout(r2)     // Catch:{ IOException -> 0x0064 }
                r0.connect()     // Catch:{ IOException -> 0x0064 }
                java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0064 }
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x005f }
                java.lang.String r3 = "font"
                java.io.FileOutputStream r2 = r2.openFileOutput(r3, r1)     // Catch:{ Exception -> 0x005f }
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x005f }
            L_0x004a:
                int r4 = r0.read(r3)     // Catch:{ Exception -> 0x005f }
                if (r4 <= 0) goto L_0x0054
                r2.write(r3, r1, r4)     // Catch:{ Exception -> 0x005f }
                goto L_0x004a
            L_0x0054:
                r2.close()     // Catch:{ Exception -> 0x005f }
                r0.close()     // Catch:{ Exception -> 0x005f }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r1)
                return r6
            L_0x005f:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ IOException -> 0x0064 }
                return r6
            L_0x0064:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            L_0x0069:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargarfont.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            preinicio.this.mostrar_pb(R.string.cargando_recursos);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            preinicio.this.ocultar_pb();
            if (b.byteValue() == -1) {
                preinicio.this.marcar_guardado = false;
            } else {
                SharedPreferences.Editor edit = preinicio.this.settings.edit();
                edit.putString("vfu_act", this.vfont);
                edit.commit();
                preinicio.this.globales.establecerFuente(1);
            }
            preinicio.this.mirar_sound_in();
        }
    }

    private class cargarsound extends AsyncTask<String, Void, Byte> {
        String tipo;
        String vsound;

        private cargarsound() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x007f, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x007b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r8) {
            /*
                r7 = this;
                java.lang.String r0 = "sound_"
                java.lang.String r1 = "/srv/imgs/sounds/app3008836_"
                r2 = 0
                r3 = r8[r2]
                r7.vsound = r3
                r3 = 1
                r8 = r8[r3]
                r7.tipo = r8
                r8 = -1
                java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0085 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0085 }
                r5.<init>()     // Catch:{ MalformedURLException -> 0x0085 }
                java.lang.String r6 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x0085 }
                r5.append(r6)     // Catch:{ MalformedURLException -> 0x0085 }
                r5.append(r1)     // Catch:{ MalformedURLException -> 0x0085 }
                java.lang.String r1 = r7.tipo     // Catch:{ MalformedURLException -> 0x0085 }
                r5.append(r1)     // Catch:{ MalformedURLException -> 0x0085 }
                java.lang.String r1 = ".wav?v="
                r5.append(r1)     // Catch:{ MalformedURLException -> 0x0085 }
                java.lang.String r1 = r7.vsound     // Catch:{ MalformedURLException -> 0x0085 }
                r5.append(r1)     // Catch:{ MalformedURLException -> 0x0085 }
                java.lang.String r1 = r5.toString()     // Catch:{ MalformedURLException -> 0x0085 }
                r4.<init>(r1)     // Catch:{ MalformedURLException -> 0x0085 }
                java.net.URLConnection r1 = r4.openConnection()     // Catch:{ IOException -> 0x0080 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x0080 }
                r1.setDoInput(r3)     // Catch:{ IOException -> 0x0080 }
                r3 = 5000(0x1388, float:7.006E-42)
                r1.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0080 }
                r3 = 7000(0x1b58, float:9.809E-42)
                r1.setReadTimeout(r3)     // Catch:{ IOException -> 0x0080 }
                r1.connect()     // Catch:{ IOException -> 0x0080 }
                java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0080 }
                stikerwap.appdys.preinicio r3 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x007b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
                r4.<init>(r0)     // Catch:{ Exception -> 0x007b }
                java.lang.String r0 = r7.tipo     // Catch:{ Exception -> 0x007b }
                r4.append(r0)     // Catch:{ Exception -> 0x007b }
                java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x007b }
                java.io.FileOutputStream r0 = r3.openFileOutput(r0, r2)     // Catch:{ Exception -> 0x007b }
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x007b }
            L_0x0066:
                int r4 = r1.read(r3)     // Catch:{ Exception -> 0x007b }
                if (r4 <= 0) goto L_0x0070
                r0.write(r3, r2, r4)     // Catch:{ Exception -> 0x007b }
                goto L_0x0066
            L_0x0070:
                r0.close()     // Catch:{ Exception -> 0x007b }
                r1.close()     // Catch:{ Exception -> 0x007b }
                java.lang.Byte r8 = java.lang.Byte.valueOf(r2)
                return r8
            L_0x007b:
                java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ IOException -> 0x0080 }
                return r8
            L_0x0080:
                java.lang.Byte r8 = java.lang.Byte.valueOf(r8)
                return r8
            L_0x0085:
                java.lang.Byte r8 = java.lang.Byte.valueOf(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargarsound.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            preinicio.this.mostrar_pb(R.string.cargando_recursos);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            preinicio.this.ocultar_pb();
            if (b.byteValue() == -1) {
                preinicio.this.marcar_guardado = false;
            } else {
                SharedPreferences.Editor edit = preinicio.this.settings.edit();
                if (this.tipo.equals(ScarConstants.IN_SIGNAL_KEY)) {
                    edit.putString("vsi_act", this.vsound);
                } else {
                    edit.putString("vso_act", this.vsound);
                }
                edit.commit();
            }
            if (this.tipo.equals("out")) {
                preinicio.this.mirar_icos();
            } else {
                preinicio.this.mirar_sound_out();
            }
        }
    }

    private class cargaricohome extends AsyncTask<String, Void, Byte> {
        String vfoto;

        private cargaricohome() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0061 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r0 = "/srv/imgs/gen/3008836_icohome.png?v="
                r1 = 0
                r6 = r6[r1]
                r5.vfoto = r6
                r6 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x006b }
                r3.<init>()     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.String r4 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x006b }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x006b }
                r3.append(r0)     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.String r0 = r5.vfoto     // Catch:{ MalformedURLException -> 0x006b }
                r3.append(r0)     // Catch:{ MalformedURLException -> 0x006b }
                java.lang.String r0 = r3.toString()     // Catch:{ MalformedURLException -> 0x006b }
                r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x006b }
                java.net.URLConnection r0 = r2.openConnection()     // Catch:{ IOException -> 0x0066 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0066 }
                r2 = 1
                r0.setDoInput(r2)     // Catch:{ IOException -> 0x0066 }
                r2 = 5000(0x1388, float:7.006E-42)
                r0.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0066 }
                r2 = 7000(0x1b58, float:9.809E-42)
                r0.setReadTimeout(r2)     // Catch:{ IOException -> 0x0066 }
                r0.connect()     // Catch:{ IOException -> 0x0066 }
                java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0066 }
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this     // Catch:{ IOException -> 0x0066 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ IOException -> 0x0066 }
                r2.bm_icohome = r0     // Catch:{ IOException -> 0x0066 }
                stikerwap.appdys.preinicio r0 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0061 }
                java.lang.String r2 = "icohome"
                java.io.FileOutputStream r0 = r0.openFileOutput(r2, r1)     // Catch:{ Exception -> 0x0061 }
                stikerwap.appdys.preinicio r2 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x0061 }
                android.graphics.Bitmap r2 = r2.bm_icohome     // Catch:{ Exception -> 0x0061 }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0061 }
                r4 = 100
                r2.compress(r3, r4, r0)     // Catch:{ Exception -> 0x0061 }
                r0.close()     // Catch:{ Exception -> 0x0061 }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r1)
                return r6
            L_0x0061:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ IOException -> 0x0066 }
                return r6
            L_0x0066:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            L_0x006b:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargaricohome.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            preinicio.this.mostrar_pb(R.string.cargando_icohome);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            preinicio.this.ocultar_pb();
            if (b.byteValue() == -1) {
                preinicio.this.marcar_guardado = false;
            }
            preinicio.this.mirar_icosmenu();
        }
    }

    private class cargaricos extends AsyncTask<String, Void, Byte> {
        private cargaricos() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:36|37|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0182, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x017e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r12) {
            /*
                r11 = this;
                stikerwap.appdys.preinicio r12 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r12 = r12.settings
                android.content.SharedPreferences$Editor r12 = r12.edit()
                r0 = 0
                java.lang.String r1 = ""
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
            L_0x000f:
                r6 = 8
                if (r2 >= r6) goto L_0x0191
                r6 = 1
                if (r2 != 0) goto L_0x0030
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_ofics_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_ofics_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "ofics_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "ofics"
                goto L_0x00f4
            L_0x0030:
                if (r2 != r6) goto L_0x004c
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_busc_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_busc_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "busc_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "busc"
                goto L_0x00f4
            L_0x004c:
                r7 = 2
                if (r2 != r7) goto L_0x0069
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_share_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_share_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "share_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "share"
                goto L_0x00f4
            L_0x0069:
                r7 = 3
                if (r2 != r7) goto L_0x0085
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_exit_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_exit_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "exit_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "exit"
                goto L_0x00f4
            L_0x0085:
                r7 = 4
                if (r2 != r7) goto L_0x00a1
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_notif_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_notif_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "notif_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "notif"
                goto L_0x00f4
            L_0x00a1:
                r7 = 5
                if (r2 != r7) goto L_0x00bd
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_perfil_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_perfil_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "perfil_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "perfil"
                goto L_0x00f4
            L_0x00bd:
                r7 = 6
                if (r2 != r7) goto L_0x00d9
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_search_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_search_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "search_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "search"
                goto L_0x00f4
            L_0x00d9:
                r7 = 7
                if (r2 != r7) goto L_0x00f4
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                boolean r3 = r1.ico_sinads_imgperso
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                stikerwap.appdys.config r1 = r1.globales
                int r4 = r1.ico_sinads_imgperso_v
                stikerwap.appdys.preinicio r1 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r1 = r1.settings
                java.lang.String r5 = "sinads_imgperso_v_act"
                int r5 = r1.getInt(r5, r0)
                java.lang.String r1 = "sinads"
            L_0x00f4:
                if (r3 == 0) goto L_0x018d
                if (r4 <= r5) goto L_0x018d
                r7 = -1
                java.net.URL r8 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0188 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0188 }
                r9.<init>()     // Catch:{ MalformedURLException -> 0x0188 }
                java.lang.String r10 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x0188 }
                r9.append(r10)     // Catch:{ MalformedURLException -> 0x0188 }
                java.lang.String r10 = "/srv/imgs/icos/app"
                r9.append(r10)     // Catch:{ MalformedURLException -> 0x0188 }
                r10 = 3008836(0x2de944, float:4.216277E-39)
                r9.append(r10)     // Catch:{ MalformedURLException -> 0x0188 }
                java.lang.String r10 = "_"
                r9.append(r10)     // Catch:{ MalformedURLException -> 0x0188 }
                r9.append(r1)     // Catch:{ MalformedURLException -> 0x0188 }
                java.lang.String r10 = ".png?v="
                r9.append(r10)     // Catch:{ MalformedURLException -> 0x0188 }
                r9.append(r4)     // Catch:{ MalformedURLException -> 0x0188 }
                java.lang.String r9 = r9.toString()     // Catch:{ MalformedURLException -> 0x0188 }
                r8.<init>(r9)     // Catch:{ MalformedURLException -> 0x0188 }
                java.net.URLConnection r8 = r8.openConnection()     // Catch:{ IOException -> 0x0183 }
                java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x0183 }
                r8.setDoInput(r6)     // Catch:{ IOException -> 0x0183 }
                r6 = 5000(0x1388, float:7.006E-42)
                r8.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0183 }
                r6 = 7000(0x1b58, float:9.809E-42)
                r8.setReadTimeout(r6)     // Catch:{ IOException -> 0x0183 }
                r8.connect()     // Catch:{ IOException -> 0x0183 }
                java.io.InputStream r6 = r8.getInputStream()     // Catch:{ IOException -> 0x0183 }
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ IOException -> 0x0183 }
                stikerwap.appdys.preinicio r8 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x017e }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017e }
                r9.<init>()     // Catch:{ Exception -> 0x017e }
                java.lang.String r10 = "ico_"
                r9.append(r10)     // Catch:{ Exception -> 0x017e }
                r9.append(r1)     // Catch:{ Exception -> 0x017e }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x017e }
                java.io.FileOutputStream r8 = r8.openFileOutput(r9, r0)     // Catch:{ Exception -> 0x017e }
                android.graphics.Bitmap$CompressFormat r9 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x017e }
                r10 = 100
                r6.compress(r9, r10, r8)     // Catch:{ Exception -> 0x017e }
                r8.close()     // Catch:{ Exception -> 0x017e }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r1)
                java.lang.String r7 = "_imgperso_v_act"
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r12.putInt(r6, r4)
                r12.commit()
                goto L_0x018d
            L_0x017e:
                java.lang.Byte r12 = java.lang.Byte.valueOf(r7)     // Catch:{ IOException -> 0x0183 }
                return r12
            L_0x0183:
                java.lang.Byte r12 = java.lang.Byte.valueOf(r7)
                return r12
            L_0x0188:
                java.lang.Byte r12 = java.lang.Byte.valueOf(r7)
                return r12
            L_0x018d:
                int r2 = r2 + 1
                goto L_0x000f
            L_0x0191:
                java.lang.Byte r12 = java.lang.Byte.valueOf(r0)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargaricos.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            preinicio.this.mostrar_pb(R.string.cargando_recursos);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            preinicio.this.ocultar_pb();
            if (b.byteValue() == -1) {
                preinicio.this.marcar_guardado = false;
            }
            preinicio.this.mirar_icos_mb();
        }
    }

    private class cargaricos_mb extends AsyncTask<String, Void, Byte> {
        private cargaricos_mb() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c9, code lost:
            return (byte) -1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x00c5 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r11) {
            /*
                r10 = this;
                stikerwap.appdys.preinicio r11 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r11 = r11.settings
                android.content.SharedPreferences$Editor r11 = r11.edit()
                r0 = 0
                r1 = 0
            L_0x000a:
                stikerwap.appdys.config$mb_item[] r2 = stikerwap.appdys.config.mb_items
                int r2 = r2.length
                if (r1 >= r2) goto L_0x00d8
                stikerwap.appdys.config$mb_item[] r2 = stikerwap.appdys.config.mb_items
                r2 = r2[r1]
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "mb_it"
                r3.<init>(r4)
                int r4 = r2.id
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                int r2 = r2.img_v
                stikerwap.appdys.preinicio r4 = stikerwap.appdys.preinicio.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r3)
                java.lang.String r6 = "_v_act"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                int r4 = r4.getInt(r5, r0)
                if (r2 <= r4) goto L_0x00d4
                r4 = -1
                java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00cf }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00cf }
                r7.<init>()     // Catch:{ MalformedURLException -> 0x00cf }
                java.lang.String r8 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x00cf }
                r7.append(r8)     // Catch:{ MalformedURLException -> 0x00cf }
                java.lang.String r8 = "/srv/imgs/icos/app"
                r7.append(r8)     // Catch:{ MalformedURLException -> 0x00cf }
                r8 = 3008836(0x2de944, float:4.216277E-39)
                r7.append(r8)     // Catch:{ MalformedURLException -> 0x00cf }
                java.lang.String r8 = "_"
                r7.append(r8)     // Catch:{ MalformedURLException -> 0x00cf }
                r7.append(r3)     // Catch:{ MalformedURLException -> 0x00cf }
                java.lang.String r8 = ".png?v="
                r7.append(r8)     // Catch:{ MalformedURLException -> 0x00cf }
                r7.append(r2)     // Catch:{ MalformedURLException -> 0x00cf }
                java.lang.String r7 = r7.toString()     // Catch:{ MalformedURLException -> 0x00cf }
                r5.<init>(r7)     // Catch:{ MalformedURLException -> 0x00cf }
                java.net.URLConnection r5 = r5.openConnection()     // Catch:{ IOException -> 0x00ca }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x00ca }
                r7 = 1
                r5.setDoInput(r7)     // Catch:{ IOException -> 0x00ca }
                r7 = 5000(0x1388, float:7.006E-42)
                r5.setConnectTimeout(r7)     // Catch:{ IOException -> 0x00ca }
                r7 = 7000(0x1b58, float:9.809E-42)
                r5.setReadTimeout(r7)     // Catch:{ IOException -> 0x00ca }
                r5.connect()     // Catch:{ IOException -> 0x00ca }
                java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x00ca }
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ IOException -> 0x00ca }
                stikerwap.appdys.preinicio r7 = stikerwap.appdys.preinicio.this     // Catch:{ Exception -> 0x00c5 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5 }
                r8.<init>()     // Catch:{ Exception -> 0x00c5 }
                java.lang.String r9 = "ico_"
                r8.append(r9)     // Catch:{ Exception -> 0x00c5 }
                r8.append(r3)     // Catch:{ Exception -> 0x00c5 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00c5 }
                java.io.FileOutputStream r7 = r7.openFileOutput(r8, r0)     // Catch:{ Exception -> 0x00c5 }
                android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00c5 }
                r9 = 100
                r5.compress(r8, r9, r7)     // Catch:{ Exception -> 0x00c5 }
                r7.close()     // Catch:{ Exception -> 0x00c5 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                r4.append(r6)
                java.lang.String r3 = r4.toString()
                r11.putInt(r3, r2)
                r11.commit()
                goto L_0x00d4
            L_0x00c5:
                java.lang.Byte r11 = java.lang.Byte.valueOf(r4)     // Catch:{ IOException -> 0x00ca }
                return r11
            L_0x00ca:
                java.lang.Byte r11 = java.lang.Byte.valueOf(r4)
                return r11
            L_0x00cf:
                java.lang.Byte r11 = java.lang.Byte.valueOf(r4)
                return r11
            L_0x00d4:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x00d8:
                java.lang.Byte r11 = java.lang.Byte.valueOf(r0)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preinicio.cargaricos_mb.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            preinicio.this.mostrar_pb(R.string.cargando_recursos);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            preinicio.this.ocultar_pb();
            if (b.byteValue() == -1) {
                preinicio.this.marcar_guardado = false;
            }
            preinicio.this.mirar_icohome();
        }
    }

    /* access modifiers changed from: package-private */
    public String leer_map(String str) {
        if (this.directo) {
            return "";
        }
        try {
            if (this.result_http_map.containsKey(str)) {
                return this.result_http_map.get(str);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public void mostrar_error(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false).setPositiveButton(getString(R.string.cerrar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                preinicio.this.finish();
            }
        }).setMessage(str2);
        if (!str.equals("")) {
            builder.setTitle(str);
        }
        final AlertDialog create = builder.create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
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

    public void onBackPressed() {
        if (findViewById(R.id.rl_anext).getVisibility() != 0) {
            super.onBackPressed();
        } else if (!this.preiniciar_3_llamado) {
            this.preiniciar_3_llamado = true;
            preiniciar_3();
        }
    }

    public void onResume() {
        super.onResume();
        config.onResume_global(this);
        if (this.desde_rate) {
            preiniciar_2();
        } else if (this.desde_appnext) {
            try {
                config.appnext_glob_int = null;
            } catch (Exception unused) {
            }
            this.preiniciar_3_llamado = true;
            preiniciar_3();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (findViewById(R.id.rl_anext).getVisibility() == 0) {
            findViewById(R.id.v_anext).setVisibility(8);
            findViewById(R.id.iv_splash).setVisibility(8);
            ((ImageView) findViewById(R.id.iv_splash)).setImageBitmap((Bitmap) null);
            findViewById(R.id.wv_splash).setVisibility(8);
            findViewById(R.id.na_media).setVisibility(8);
            findViewById(R.id.acad_na_media).setVisibility(8);
        } else if (findViewById(R.id.wv_splash).getVisibility() == 0) {
            mostrar_splash_deasset();
        }
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: private */
    public boolean checkPlayServices() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this) == 0;
    }

    /* access modifiers changed from: package-private */
    public void mostrar_pb(int i) {
        int i2;
        if (this.globales.pb_tipo == 1) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.dialog_cargando = progressDialog;
            progressDialog.setMessage(getString(i));
            this.dialog_cargando.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !this.c_icos_orig.equals("")) {
                this.dialog_cargando.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) preinicio.this.dialog_cargando.findViewById(16908301), preinicio.this.c_icos_orig);
                    }
                });
            }
            try {
                this.dialog_cargando.show();
            } catch (Exception unused) {
            }
        } else if (this.globales.pb_tipo == 2) {
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_splash);
            if (progressBar.getVisibility() == 8) {
                if (this.globales.pb_s == 0) {
                    i2 = config.dp_to_px(this, 40);
                } else if (this.globales.pb_s == 1) {
                    i2 = config.dp_to_px(this, 80);
                } else {
                    i2 = config.dp_to_px(this, 120);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
                if (this.globales.pb_pos == 1) {
                    layoutParams.gravity = 49;
                } else if (this.globales.pb_pos == 2) {
                    layoutParams.gravity = BadgeDrawable.TOP_END;
                } else if (this.globales.pb_pos == 3) {
                    layoutParams.gravity = 8388629;
                } else if (this.globales.pb_pos == 4) {
                    layoutParams.gravity = BadgeDrawable.BOTTOM_END;
                } else if (this.globales.pb_pos == 5) {
                    layoutParams.gravity = 81;
                } else if (this.globales.pb_pos == 6) {
                    layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                } else if (this.globales.pb_pos == 7) {
                    layoutParams.gravity = 8388627;
                } else if (this.globales.pb_pos == 8) {
                    layoutParams.gravity = BadgeDrawable.TOP_START;
                } else {
                    layoutParams.gravity = 17;
                }
                int dp_to_px = config.dp_to_px(this, 40);
                layoutParams.setMargins(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
                progressBar.setLayoutParams(layoutParams);
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color(progressBar, this.globales.pb_c);
                }
                progressBar.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ocultar_pb() {
        if (this.globales.pb_tipo == 1) {
            try {
                this.dialog_cargando.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void preguntar_contra() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        this.adb = builder;
        builder.setTitle(getResources().getString(R.string.chat_acceso));
        View inflate = getLayoutInflater().inflate(R.layout.contra, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.message)).setText(getResources().getString(R.string.chat_introduce_contra));
        this.et_contra = (EditText) inflate.findViewById(R.id.et_contra);
        if (this.contra_ko) {
            inflate.findViewById(R.id.message_error).setVisibility(0);
        }
        this.dontShowAgain = (CheckBox) inflate.findViewById(R.id.skip);
        if (!this.cbtn.equals("")) {
            EditText editText = this.et_contra;
            config.edittext_color(editText, Boolean.valueOf(!config.esClaro("#" + this.c1_sp_orig)), this.cbtn);
            config.checkbox_color(this.dontShowAgain, this.cbtn);
        }
        this.dontShowAgain.setChecked(this.settings.getBoolean("pwd_nomostrarmas_def", true));
        this.adb.setView(inflate);
        this.adb.setCancelable(true);
        this.adb.setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor edit = preinicio.this.settings.edit();
                if (preinicio.this.dontShowAgain.isChecked()) {
                    edit.putBoolean("pwd_nomostrarmas_def", true);
                } else {
                    edit.putBoolean("pwd_nomostrarmas_def", false);
                }
                edit.commit();
                preinicio.this.dialog_enviando = new ProgressDialog(preinicio.this);
                preinicio.this.dialog_enviando.setMessage(preinicio.this.getString(R.string.comprobando));
                preinicio.this.dialog_enviando.setIndeterminate(true);
                if (Build.VERSION.SDK_INT > 20 && !preinicio.this.c_icos_orig.equals("")) {
                    preinicio.this.dialog_enviando.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            config.progress_color((ProgressBar) preinicio.this.dialog_enviando.findViewById(16908301), preinicio.this.c_icos_orig);
                        }
                    });
                }
                try {
                    preinicio.this.dialog_enviando.show();
                } catch (Exception unused) {
                }
                preinicio preinicio = preinicio.this;
                preinicio.contra = preinicio.et_contra.getText().toString();
                new enviarTask().execute(new String[0]);
            }
        });
        this.adb.setNegativeButton(getString(R.string.cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                preinicio.this.finish();
            }
        });
        this.adb.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                preinicio.this.finish();
            }
        });
        final AlertDialog create = this.adb.create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + preinicio.this.cbtn));
                }
            });
        }
        try {
            create.show();
        } catch (Exception unused) {
        }
    }

    private class enviarTask extends AsyncTask<String, Void, Byte> {
        private enviarTask() {
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/comprobar_contra_app.php?v=1&idapp=3008836&idusu=" + preinicio.this.idusu);
            StringBuilder sb = new StringBuilder();
            try {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new BasicNameValuePair("contra", preinicio.this.contra));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                if (sb.indexOf("ANDROID:KO") != -1) {
                    return (byte) 2;
                }
                if (sb.indexOf("ANDROID:OK") != -1) {
                    return (byte) 1;
                }
                return (byte) 0;
            } catch (ClientProtocolException unused) {
                return (byte) 0;
            } catch (IOException unused2) {
                return (byte) 0;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                preinicio.this.dialog_enviando.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() == 1) {
                if (preinicio.this.settings.getBoolean("pwd_nomostrarmas_def", true)) {
                    SharedPreferences.Editor edit = preinicio.this.settings.edit();
                    edit.putBoolean("pwd_validado", true);
                    edit.commit();
                }
                preinicio.this.iniciar();
            } else if (b.byteValue() == 2) {
                preinicio.this.contra_ko = true;
                preinicio.this.preguntar_contra();
            } else {
                preinicio preinicio = preinicio.this;
                preinicio.mostrar_error(preinicio.getString(R.string.error_http_tit), preinicio.this.getString(R.string.error_http));
            }
        }
    }
}
