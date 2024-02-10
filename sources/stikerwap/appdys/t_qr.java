package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.ads.banner.Mrec;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.wortise.ads.AdError;
import com.wortise.ads.banner.BannerAd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class t_qr extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    BannerAd adView_nat_w;
    AdView admob_qr;
    Anuncios anun;
    BannerView appnext_qr;
    boolean atras_pulsado = false;
    BarcodeDetector barcodeDetector;
    String c1;
    boolean c1_esclaro;
    String c2;
    boolean c2_esclaro;
    CameraSource cameraSource;
    boolean detectat;
    Bundle extras;
    com.facebook.ads.AdView fb_qr;
    config globales;
    boolean hay_banner;
    int idsec;
    long idusu;
    int ind_abrir_secc = -1;
    int ind_secc;
    boolean mAd_visto = false;
    Camera mCamera;
    ListView mDrawerList;
    List<Camera.Size> mSupportedPreviewSizes;
    ProgressBar pb;
    Seccion s;
    SharedPreferences settings;
    SurfaceView surfaceView;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        PackageInfo packageInfo;
        String[] strArr;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        establec_ralc(this);
        this.c1 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
        this.c2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
        this.c1_esclaro = config.esClaro("#" + this.c1);
        this.c2_esclaro = config.esClaro("#" + this.c2);
        this.cbtn = config.aplicar_color_dialog(this.c1, this.globales.c_icos);
        if (!this.c1_esclaro) {
            setTheme(R.style.holonolight);
        }
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        this.ind_secc = this.globales.ind_secc_sel_2;
        Seccion seccion = this.globales.secciones_a[this.ind_secc];
        this.s = seccion;
        this.idsec = seccion.id;
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        setContentView(R.layout.t_qr);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_qr.this.finalizar = false;
                t_qr.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_qr.this.buscador_on = false;
            }
        });
        config config2 = this.globales;
        Bundle bundle2 = this.extras;
        boolean z = bundle2 != null && bundle2.containsKey("ad_entrar");
        Bundle bundle3 = this.extras;
        config2.toca_int(this, z, bundle3 != null && bundle3.containsKey("fb_entrar"));
        boolean z2 = (this.globales.admob_qr_cod == "" && this.globales.appnext_qr_cod == "" && this.globales.fb_qr_cod == "" && this.globales.st_qr_cod == "" && this.globales.is_qr_cod == "" && this.globales.wortise_qr_cod == "") ? false : true;
        this.hay_banner = z2;
        if (z2) {
            posar_banner();
        } else {
            this.anun = this.globales.mostrar_banner(this, false);
        }
        config config3 = this.globales;
        config3.oncreate_popup(this, config3.ind_secc_sel_2, this.cbtn, bundle);
        int i = config.NEGRO;
        int i2 = -1;
        if (!this.c1.equals("")) {
            if (!this.c1_esclaro) {
                i = -1;
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.c1), Color.parseColor("#" + this.c2)}));
        }
        ((TextView) findViewById(R.id.tv_url)).setTextColor(i);
        if (!this.cbtn.equals("")) {
            ((Button) findViewById(R.id.btn_share_url)).setBackgroundColor(Color.parseColor("#" + this.cbtn));
            ((Button) findViewById(R.id.btn_abrir_url)).setBackgroundColor(Color.parseColor("#" + this.cbtn));
            if (config.esClaro("#" + this.cbtn)) {
                i2 = config.NEGRO;
            }
            ((Button) findViewById(R.id.btn_share_url)).setTextColor(i2);
            ((Button) findViewById(R.id.btn_abrir_url)).setTextColor(i2);
            if (i2 == config.NEGRO) {
                ((Button) findViewById(R.id.btn_share_url)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.share_n, 0, 0, 0);
                ((Button) findViewById(R.id.btn_abrir_url)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.view_n, 0, 0, 0);
            }
        } else {
            ((Button) findViewById(R.id.btn_share_url)).setTextColor(i);
            ((Button) findViewById(R.id.btn_abrir_url)).setTextColor(i);
            if (i == config.NEGRO) {
                ((Button) findViewById(R.id.btn_share_url)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.share_n, 0, 0, 0);
                ((Button) findViewById(R.id.btn_abrir_url)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.view_n, 0, 0, 0);
            }
        }
        if (!this.s.t_visor) {
            findViewById(R.id.iv_visor).setVisibility(8);
        } else if (this.s.t_visor && this.s.c_visor != null && !this.s.c_visor.equals("")) {
            Drawable drawable = getResources().getDrawable(R.drawable.qr_visor);
            try {
                drawable.setColorFilter(Color.parseColor("#" + this.s.c_visor), PorterDuff.Mode.MULTIPLY);
            } catch (Exception unused) {
            }
            ((ImageView) findViewById(R.id.iv_visor)).setImageDrawable(drawable);
        }
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
        if (!bool.booleanValue()) {
            config.mostrar_error(this, "", getResources().getString(R.string.permisos), this.cbtn);
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 107);
        } else {
            iniciar_scan();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 107) {
            return;
        }
        if (iArr == null || iArr.length <= 0 || !strArr[0].equals("android.permission.CAMERA") || iArr[0] != 0) {
            config.mostrar_error(this, "", getResources().getString(R.string.permisos), this.cbtn);
        } else {
            iniciar_scan();
        }
    }

    /* access modifiers changed from: package-private */
    public void iniciar_scan() {
        Camera cameraInstance = getCameraInstance();
        this.mCamera = cameraInstance;
        this.mSupportedPreviewSizes = cameraInstance.getParameters().getSupportedPreviewSizes();
        findViewById(R.id.ll_aux).setVisibility(8);
        findViewById(R.id.rl_scan).setVisibility(0);
        this.surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        ini_barcodeDetector();
        this.surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (t_qr.this.cameraSource != null) {
                    try {
                        t_qr.this.cameraSource.stop();
                        t_qr.this.cameraSource.release();
                    } catch (Exception unused) {
                    }
                }
                t_qr t_qr = t_qr.this;
                Camera.Size r2 = t_qr.getOptimalPreviewSize(t_qr.mSupportedPreviewSizes, t_qr.this.surfaceView.getWidth(), t_qr.this.surfaceView.getHeight());
                t_qr.this.ini_barcodeDetector();
                t_qr t_qr2 = t_qr.this;
                t_qr t_qr3 = t_qr.this;
                t_qr2.cameraSource = new CameraSource.Builder(t_qr3, t_qr3.barcodeDetector).setRequestedPreviewSize(r2.width, r2.height).setAutoFocusEnabled(true).build();
                try {
                    t_qr.this.cameraSource.start(t_qr.this.surfaceView.getHolder());
                } catch (IOException | SecurityException unused2) {
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                t_qr.this.cameraSource.stop();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void ini_barcodeDetector() {
        BarcodeDetector barcodeDetector2 = this.barcodeDetector;
        if (barcodeDetector2 != null) {
            try {
                barcodeDetector2.release();
            } catch (Exception unused) {
            }
        }
        BarcodeDetector build = new BarcodeDetector.Builder(this).setBarcodeFormats(256).build();
        this.barcodeDetector = build;
        build.setProcessor(new Detector.Processor<Barcode>() {
            public void release() {
            }

            public void receiveDetections(Detector.Detections<Barcode> detections) {
                if (!t_qr.this.detectat) {
                    SparseArray<Barcode> detectedItems = detections.getDetectedItems();
                    if (detectedItems.size() != 0) {
                        t_qr.this.detectat = true;
                        final String str = detectedItems.valueAt(0).displayValue;
                        if (t_qr.this.s.abrir_directo) {
                            t_qr.this.abrir_url(str);
                        } else {
                            t_qr.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    ((TextView) t_qr.this.findViewById(R.id.tv_url)).setText(str);
                                    t_qr.this.findViewById(R.id.tv_url).setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            t_qr.this.abrir_url(str);
                                        }
                                    });
                                    t_qr.this.findViewById(R.id.btn_abrir_url).setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            t_qr.this.abrir_url(str);
                                        }
                                    });
                                    if (t_qr.this.s.mostrar_compartir) {
                                        t_qr.this.findViewById(R.id.btn_share_url).setVisibility(0);
                                        t_qr.this.findViewById(R.id.v_qr_aux).setVisibility(0);
                                        t_qr.this.findViewById(R.id.btn_share_url).setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                Intent intent = new Intent("android.intent.action.SEND");
                                                intent.setType("text/plain");
                                                intent.putExtra("android.intent.extra.TEXT", str);
                                                t_qr.this.startActivity(Intent.createChooser(intent, t_qr.this.getString(R.string.compartir)));
                                            }
                                        });
                                    } else {
                                        t_qr.this.findViewById(R.id.btn_share_url).setVisibility(8);
                                        t_qr.this.findViewById(R.id.v_qr_aux).setVisibility(8);
                                    }
                                    t_qr.this.findViewById(R.id.rl_scan).setVisibility(8);
                                    t_qr.this.findViewById(R.id.ll_aux).setVisibility(8);
                                    t_qr.this.findViewById(R.id.ll_cont).setVisibility(0);
                                    t_qr.this.findViewById(R.id.ll_ad).setVisibility(0);
                                    if (t_qr.this.cameraSource != null) {
                                        try {
                                            t_qr.this.cameraSource.stop();
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    public void posar_banner() {
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            ArrayList arrayList = new ArrayList();
            if (!this.globales.admob_qr_cod.equals("")) {
                arrayList.add(1);
            }
            if (!this.globales.appnext_qr_cod.equals("") && this.globales.wortise_qr_cod.equals("")) {
                arrayList.add(2);
            }
            if (!this.globales.fb_qr_cod.equals("") && getResources().getConfiguration().orientation == 1) {
                arrayList.add(3);
            }
            if (!this.globales.st_qr_cod.equals("")) {
                arrayList.add(4);
            }
            if (!this.globales.is_qr_cod.equals("")) {
                arrayList.add(5);
            }
            if (!this.globales.wortise_qr_cod.equals("")) {
                arrayList.add(6);
            }
            if (!arrayList.isEmpty()) {
                int intValue = ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue();
                final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_ad_qr);
                linearLayout.removeAllViews();
                if (intValue == 1) {
                    this.admob_qr = new AdView(this);
                    if (getResources().getConfiguration().orientation == 2) {
                        this.admob_qr.setAdSize(AdSize.LARGE_BANNER);
                    } else {
                        this.admob_qr.setAdSize(AdSize.MEDIUM_RECTANGLE);
                    }
                    this.admob_qr.setAdUnitId(this.globales.admob_qr_cod);
                    linearLayout.addView(this.admob_qr);
                    this.admob_qr.loadAd(new AdRequest.Builder().build());
                } else if (intValue == 2) {
                    BannerView bannerView = new BannerView(this);
                    this.appnext_qr = bannerView;
                    bannerView.setPlacementId(this.globales.appnext_qr_cod);
                    if (getResources().getConfiguration().orientation == 2) {
                        this.appnext_qr.setBannerSize(BannerSize.LARGE_BANNER);
                    } else {
                        this.appnext_qr.setBannerSize(BannerSize.MEDIUM_RECTANGLE);
                    }
                    linearLayout.addView(this.appnext_qr);
                    this.appnext_qr.loadAd(new BannerAdRequest());
                } else if (intValue == 3) {
                    com.facebook.ads.AdView adView = new com.facebook.ads.AdView((Context) this, this.globales.fb_qr_cod, com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                    this.fb_qr = adView;
                    linearLayout.addView(adView);
                    this.fb_qr.loadAd();
                } else if (intValue == 4) {
                    Mrec mrec = new Mrec((Activity) this);
                    mrec.setAdTag("QR SECTION");
                    linearLayout.addView(mrec);
                } else if (intValue == 5) {
                    if (this.globales.isBanner_global != null) {
                        IronSource.destroyBanner(this.globales.isBanner_global);
                    }
                    this.globales.isBanner_global = IronSource.createBanner(this, ISBannerSize.RECTANGLE);
                    linearLayout.addView(this.globales.isBanner_global);
                    IronSource.loadBanner(this.globales.isBanner_global);
                } else if (intValue == 6) {
                    BannerAd bannerAd = new BannerAd(this);
                    this.adView_nat_w = bannerAd;
                    bannerAd.setAutoRefresh(false);
                    this.adView_nat_w.setAdSize(com.wortise.ads.AdSize.HEIGHT_250);
                    this.adView_nat_w.setAdUnitId(this.globales.wortise_qr_cod);
                    if (!this.globales.appnext_qr_cod.equals("")) {
                        this.adView_nat_w.setListener(new BannerAd.Listener() {
                            public void onBannerClicked(BannerAd bannerAd) {
                            }

                            public void onBannerLoaded(BannerAd bannerAd) {
                            }

                            public void onBannerFailed(BannerAd bannerAd, AdError adError) {
                                Log.e("ara", "wortise banner failed:" + adError.toString());
                                t_qr.this.appnext_qr = new BannerView(t_qr.this);
                                t_qr.this.appnext_qr.setPlacementId(t_qr.this.globales.appnext_qr_cod);
                                if (t_qr.this.getResources().getConfiguration().orientation == 2) {
                                    t_qr.this.appnext_qr.setBannerSize(BannerSize.LARGE_BANNER);
                                } else {
                                    t_qr.this.appnext_qr.setBannerSize(BannerSize.MEDIUM_RECTANGLE);
                                }
                                linearLayout.removeAllViews();
                                linearLayout.addView(t_qr.this.appnext_qr);
                                t_qr.this.appnext_qr.loadAd(new BannerAdRequest());
                            }
                        });
                    }
                    linearLayout.addView(this.adView_nat_w);
                    this.adView_nat_w.loadAd();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void abrir_url(String str) {
        if (this.s.linksexternos == 1) {
            this.globales.abrir_ext(this, str);
            return;
        }
        Intent intent = new Intent(this, t_url.class);
        intent.putExtra("url", str);
        startActivityForResult(intent, 0);
    }

    /* access modifiers changed from: private */
    public Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i, int i2) {
        if (i2 > i) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        double d = (double) i;
        double d2 = (double) i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d4 = Double.MAX_VALUE;
        for (Camera.Size next : list) {
            double d5 = (double) next.width;
            double d6 = (double) next.height;
            if (next.height > next.width) {
                d5 = (double) next.height;
                d6 = (double) next.width;
            }
            double d7 = (d5 / d6) - d3;
            if (Math.abs(d7) < d4) {
                d4 = Math.abs(d7);
                size = next;
            }
        }
        return size;
    }

    public static Camera getCameraInstance() {
        try {
            return Camera.open();
        } catch (Exception unused) {
            return null;
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
        if (this.hay_banner) {
            posar_banner();
        } else {
            this.anun = this.globales.mostrar_banner(this, false);
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
        CameraSource cameraSource2 = this.cameraSource;
        if (cameraSource2 != null) {
            try {
                cameraSource2.stop();
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
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        SurfaceView surfaceView2;
        super.onResume();
        config.onResume_global(this);
        if (findViewById(R.id.rl_scan).getVisibility() == 0) {
            this.detectat = false;
            CameraSource cameraSource2 = this.cameraSource;
            if (!(cameraSource2 == null || (surfaceView2 = this.surfaceView) == null)) {
                try {
                    cameraSource2.start(surfaceView2.getHolder());
                } catch (Exception unused) {
                }
            }
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
        AdView adView = this.admob_qr;
        if (adView != null) {
            adView.destroy();
        }
        BannerView bannerView = this.appnext_qr;
        if (bannerView != null) {
            bannerView.destroy();
        }
        com.facebook.ads.AdView adView2 = this.fb_qr;
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

    public void onBackPressed() {
        SurfaceView surfaceView2;
        if (findViewById(R.id.ll_cont).getVisibility() == 0) {
            findViewById(R.id.ll_cont).setVisibility(8);
            findViewById(R.id.ll_ad).setVisibility(8);
            findViewById(R.id.ll_aux).setVisibility(8);
            findViewById(R.id.rl_scan).setVisibility(0);
            this.detectat = false;
            CameraSource cameraSource2 = this.cameraSource;
            if (cameraSource2 != null && (surfaceView2 = this.surfaceView) != null) {
                try {
                    cameraSource2.start(surfaceView2.getHolder());
                } catch (Exception unused) {
                }
            }
        } else if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            super.onBackPressed();
        } else {
            this.atras_pulsado = true;
            config.confirmar_exit(this);
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
                if (!t_qr.this.globales.admob_rew_failed(context, t_qr.this.mAd_appnext)) {
                    t_qr.this.dialog_cargando.cancel();
                    t_qr t_qr = t_qr.this;
                    t_qr.abrir_secc(t_qr.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_qr.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        t_qr.this.abrir_secc(t_qr.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_qr.this.mAd_visto) {
                            t_qr.this.abrir_secc(t_qr.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_qr.this.mAd_visto = true;
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
                if (t_qr.this.mAd_visto) {
                    t_qr t_qr = t_qr.this;
                    t_qr.abrir_secc(t_qr.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
