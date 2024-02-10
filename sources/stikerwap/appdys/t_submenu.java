package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
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
import java.util.ArrayList;
import java.util.Random;

public class t_submenu extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, AdapterView.OnItemClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    int H_MAXIMA = 80;
    int H_MAXIMA_ROW = 30;
    GridAdapter MyGridAdapter;
    BannerAd adView_nat_w;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bundle extras;
    config globales;
    GridView gridView;
    int h_max;
    int ind;
    boolean is_banner_mostrando = false;
    boolean mAd_visto = false;
    ListView mDrawerList;
    ProgressBar pb;
    Seccion s;
    Seccion[] seccs_a;
    String[] seccs_a_aux;
    int seccs_a_length = 0;
    SharedPreferences settings;
    int w_max;
    int w_txt_max;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        establec_ralc(this);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        Bundle extras3 = getIntent().getExtras();
        this.extras = extras3;
        this.ind = extras3.getInt("ind");
        this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[this.ind].c1, this.globales.c_icos);
        if (!config.esClaro("#" + this.globales.secciones_a[this.ind].c1)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.t_menugrid);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_submenu.this.finalizar = false;
                t_submenu.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_submenu.this.buscador_on = false;
            }
        });
        if (bundle == null) {
            config config2 = this.globales;
            Bundle bundle2 = this.extras;
            boolean z = bundle2 != null && bundle2.containsKey("ad_entrar");
            Bundle bundle3 = this.extras;
            config2.toca_int(this, z, bundle3 != null && bundle3.containsKey("fb_entrar"));
        }
        config config3 = this.globales;
        config3.oncreate_popup(this, config3.ind_secc_sel_2, this.cbtn, bundle);
        Seccion seccion = this.globales.secciones_a[this.ind];
        this.s = seccion;
        if (!seccion.c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.s.c1), Color.parseColor("#" + this.s.c2)}));
        }
        this.seccs_a = new Seccion[this.globales.secciones_a.length];
        this.seccs_a_aux = this.s.seccs.split(",");
        this.seccs_a_length = 0;
        if (config.esClaro("#" + this.s.c1)) {
            this.pb = (ProgressBar) findViewById(R.id.pb_inv);
        } else {
            this.pb = (ProgressBar) findViewById(R.id.pb);
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(this.pb, this.globales.c_icos);
        }
        mostrar_grid();
        if (this.s.mostrar_icos) {
            Intent intent = new Intent(this, s_cargar_icos.class);
            intent.putExtra("ind_submenu", this.ind);
            startService(intent);
        }
    }

    private void banner(int i) {
        if (!getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
            boolean z = (this.globales.admob_menu_cod.equals("") || this.globales.admob_menu_w == 0 || this.globales.admob_menu_h == 0) ? false : true;
            final boolean z2 = !this.globales.appnext_menu_cod.equals("") && this.globales.appnext_ads != null && this.globales.appnext_ads.size() > 0;
            boolean z3 = !this.globales.fb_menu_cod.equals("");
            boolean z4 = !this.globales.st_menu_cod.equals("");
            boolean z5 = !this.globales.is_menu_cod.equals("");
            boolean z6 = !this.globales.wortise_menu_cod.equals("");
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
                if (!this.s.c1.equals("")) {
                    if (config.esClaro("#" + this.s.c1)) {
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
                        if (t_submenu.this.s.c2 != null && !t_submenu.this.s.c2.equals("")) {
                            int canviarColor = config.canviarColor(Color.parseColor("#" + t_submenu.this.s.c2), 0.2f, 0);
                            backgroundColor.setBackgroundColor(canviarColor);
                            if (config.esClaro_int(canviarColor)) {
                                backgroundColor.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
                                backgroundColor.setDescriptionTextColor(ViewCompat.MEASURED_STATE_MASK);
                            } else {
                                backgroundColor.setTitleTextColor(-1);
                                backgroundColor.setDescriptionTextColor(-1);
                            }
                        }
                        if (t_submenu.this.s.mostrar_txt && t_submenu.this.s.txt_col != null && !t_submenu.this.s.txt_col.equals("") && t_submenu.this.s.txt_bg != null && !t_submenu.this.s.txt_bg.equals("")) {
                            NativeAdViewAttributes buttonBorderColor = backgroundColor.setButtonTextColor(Color.parseColor("#" + t_submenu.this.s.txt_col)).setButtonBorderColor(-12303292);
                            buttonBorderColor.setButtonColor(Color.parseColor("#" + t_submenu.this.s.txt_bg));
                        }
                        View render = NativeAdView.render(t_submenu.this, nativeAd, NativeAdView.Type.HEIGHT_300, backgroundColor);
                        LinearLayout linearLayout = (LinearLayout) t_submenu.this.findViewById(R.id.ll_nat);
                        try {
                            if (config.esClaro("#" + t_submenu.this.s.c2)) {
                                linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                            } else {
                                linearLayout.setBackgroundColor(-1);
                            }
                            int dp_to_px = config.dp_to_px(t_submenu.this.getApplicationContext(), 1);
                            linearLayout.setPadding(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        linearLayout.setVisibility(0);
                        ((LinearLayout) t_submenu.this.findViewById(R.id.ll_nat)).removeViewAt(1);
                        ((LinearLayout) t_submenu.this.findViewById(R.id.ll_nat)).addView(render, 1);
                    }
                }).build());
            } else if (intValue == 4) {
                Mrec mrec = new Mrec((Activity) this);
                mrec.setAdTag("SUBMENU");
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
                        if (z2) {
                            if (!t_submenu.this.globales.menu_c1.equals("")) {
                                if (config.esClaro("#" + t_submenu.this.globales.menu_c1)) {
                                    ((TextView) t_submenu.this.findViewById(R.id.tv_appsreco)).setTextColor(config.NEGRO);
                                }
                            }
                            t_submenu.this.globales.appnext_mostrar_2(t_submenu.this, 1, 3, -1, (String) null);
                        }
                    }

                    public void onBannerLoaded(BannerAd bannerAd) {
                        ((LinearLayout) t_submenu.this.findViewById(R.id.ll_nat)).removeViewAt(1);
                        ((LinearLayout) t_submenu.this.findViewById(R.id.ll_nat)).addView(t_submenu.this.adView_nat_w, 1);
                    }
                });
                this.adView_nat_w.loadAd();
            } else {
                this.anun = this.globales.mostrar_banner(this, false);
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
            if (this.s.idfondo == 0) {
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

    /* access modifiers changed from: package-private */
    public void mostrar_grid() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f = getResources().getDisplayMetrics().density;
        this.H_MAXIMA = (int) ((((float) this.H_MAXIMA) * f) + 0.5f);
        this.H_MAXIMA_ROW = (int) ((((float) this.H_MAXIMA_ROW) * f) + 0.5f);
        this.h_max = 0;
        this.w_max = 0;
        this.w_txt_max = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        if (this.s.icos_izq) {
            i = R.layout.t_menugrid_row;
        } else if (this.s.estilo == 1) {
            i = R.layout.t_menugrid_row_formato2;
        } else {
            i = this.s.estilo == 2 ? R.layout.t_menugrid_row_formato3 : R.layout.t_menugrid_row_v;
        }
        TextView textView = (TextView) layoutInflater.inflate(i, (LinearLayout) findViewById(R.id.ll_princ), false).findViewById(R.id.tv_menugrid);
        int i11 = 0;
        while (true) {
            Seccion seccion = null;
            if (i11 >= this.seccs_a_aux.length) {
                break;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= this.globales.secciones_a.length) {
                    break;
                }
                if (this.seccs_a_aux[i11].equals(this.globales.secciones_a[i12].id + "")) {
                    seccion = this.globales.secciones_a[i12];
                    Seccion[] seccionArr = this.seccs_a;
                    int i13 = this.seccs_a_length;
                    seccionArr[i13] = seccion;
                    this.seccs_a_length = i13 + 1;
                    break;
                }
                i12++;
            }
            if (seccion != null) {
                if (this.s.mostrar_txt) {
                    textView.setText(seccion.titulo);
                    if (this.s.txt_b) {
                        textView.setTypeface(textView.getTypeface(), 1);
                    }
                    textView.measure(0, 0);
                    this.w_txt_max = Math.max(this.w_txt_max, textView.getMeasuredWidth());
                }
                if (this.s.mostrar_icos) {
                    if (!seccion.ico_cargando && seccion.ico != null) {
                        this.h_max = Math.max(this.h_max, seccion.ico.getHeight());
                        this.w_max = Math.max(this.w_max, seccion.ico.getWidth());
                    } else if (!(!seccion.ico_cargando || seccion.w_ico == 0 || seccion.h_ico == 0)) {
                        this.h_max = Math.max(this.h_max, seccion.h_ico);
                        this.w_max = Math.max(this.w_max, seccion.w_ico);
                    }
                }
            }
            i11++;
        }
        this.h_max = (int) ((((float) this.h_max) * f) + 0.5f);
        this.w_max = (int) ((((float) this.w_max) * f) + 0.5f);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i14 = point.x;
        if (this.s.icos_izq && (i9 = this.h_max) > (i10 = this.H_MAXIMA_ROW)) {
            this.w_max = (this.w_max * i10) / i9;
            this.h_max = i10;
        } else if (!this.s.icos_izq && (i7 = this.h_max) > (i8 = this.H_MAXIMA)) {
            this.w_max = (this.w_max * i8) / i7;
            this.h_max = i8;
        }
        if (!this.s.icos_izq && this.s.mostrar_txt && (i5 = this.w_max) > (i6 = this.w_txt_max)) {
            this.h_max = (this.h_max * i6) / i5;
            this.w_max = i6;
        }
        GridView gridView2 = (GridView) findViewById(R.id.grid);
        this.gridView = gridView2;
        gridView2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (view != null) {
                    try {
                        ((ScrollView) t_submenu.this.findViewById(R.id.sv_menugrid)).smoothScrollTo(0, view.getTop() - 20);
                    } catch (Exception unused) {
                    }
                }
            }
        });
        if (this.s.c) {
            ((LinearLayout) findViewById(R.id.ll_grid)).setGravity(1);
        }
        if (this.s.padding == 1) {
            i2 = 16;
        } else {
            i2 = this.s.padding == 2 ? 24 : 1;
        }
        int i15 = (int) ((((float) i2) * f) + 0.5f);
        this.gridView.setHorizontalSpacing(i15);
        this.gridView.setVerticalSpacing(i15);
        int i16 = (int) ((10.0f * f) + 0.5f);
        this.gridView.setPadding(i16, i16, i16, i16);
        int i17 = (int) ((f * 4.0f) + 0.5f);
        int i18 = this.s.ncols;
        if (this.s.icos_izq) {
            i3 = this.w_max + this.w_txt_max + i15;
            if (this.s.mostrar_txt) {
                i3 += i17;
            }
            banner(this.w_max + this.w_txt_max);
        } else {
            if (this.s.estilo == 1 || this.s.estilo == 2) {
                i4 = config.dp_to_px(this, 10);
            } else {
                i4 = 0;
            }
            i3 = Math.max(this.w_max, this.w_txt_max) + i15 + i4;
            banner(this.w_txt_max);
        }
        while (i18 > 1 && (i3 * i18) + (i16 * 2) > i14) {
            i18--;
        }
        this.gridView.setNumColumns(i18);
        this.gridView.getLayoutParams().width = ((i3 * i18) + (i16 * 2)) - i15;
        this.gridView.setOnItemClickListener(this);
        if (!this.s.anim) {
            this.gridView.setLayoutAnimation((LayoutAnimationController) null);
        }
        GridAdapter gridAdapter = new GridAdapter(this);
        this.MyGridAdapter = gridAdapter;
        this.gridView.setAdapter(gridAdapter);
        if (this.s.idfondo > 0) {
            if (!this.s.fondo_modif) {
                try {
                    ImageView imageView = (ImageView) findViewById(R.id.iv_fondo);
                    this.globales.tratar_fondo(imageView, Boolean.valueOf(this.s.fondo_margen), this.s.fondo_tipo);
                    this.globales.file_to_iv("fondo_" + this.s.idfondo, imageView);
                } catch (Exception unused) {
                }
            } else {
                new cargarfoto().execute(new String[]{this.s.idfondo + "", this.ind + "", this.s.vfondo + ""});
            }
        } else if (this.globales.fondo_v > 0 && this.settings.getInt("fondo_v_act", 0) == this.globales.fondo_v) {
            this.globales.tratar_fondo((ImageView) findViewById(R.id.iv_fondo), Boolean.valueOf(this.globales.fondo_margen), this.globales.fondo_tipo);
            this.globales.file_to_iv("fondo", (ImageView) findViewById(R.id.iv_fondo));
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
            return t_submenu.this.seccs_a_length;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
                if (t_submenu.this.s.icos_izq) {
                    i2 = R.layout.t_menugrid_row;
                } else if (t_submenu.this.s.estilo == 1) {
                    i2 = R.layout.t_menugrid_row_formato2;
                } else {
                    i2 = t_submenu.this.s.estilo == 2 ? R.layout.t_menugrid_row_formato3 : R.layout.t_menugrid_row_v;
                }
                view = layoutInflater.inflate(i2, viewGroup, false);
                if (!t_submenu.this.s.icos_izq && (t_submenu.this.s.estilo == 1 || t_submenu.this.s.estilo == 2)) {
                    ((CardView) view.findViewById(R.id.cv)).setRadius((float) t_submenu.this.s.txt_radius);
                }
                if (t_submenu.this.s.mostrar_icos) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_menugrid);
                    if (t_submenu.this.s.icos_izq) {
                        imageView.getLayoutParams().height = t_submenu.this.h_max;
                        imageView.getLayoutParams().width = t_submenu.this.w_max;
                    } else {
                        imageView.getLayoutParams().height = t_submenu.this.h_max;
                        imageView.getLayoutParams().width = t_submenu.this.w_max;
                    }
                    imageView.setVisibility(0);
                }
                if (t_submenu.this.s.mostrar_txt) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_menugrid);
                    if (t_submenu.this.s.txt_b) {
                        textView.setTypeface(textView.getTypeface(), 1);
                    }
                    if (!t_submenu.this.s.txt_col.equals("")) {
                        textView.setTextColor(Color.parseColor("#" + t_submenu.this.s.txt_col));
                    }
                    textView.getLayoutParams().width = t_submenu.this.w_txt_max;
                    if (t_submenu.this.s.txt_c) {
                        textView.setGravity(17);
                    } else if (t_submenu.this.getResources().getBoolean(R.bool.es_rtl)) {
                        textView.setTextDirection(4);
                    }
                    if (t_submenu.this.s.txt_bg.equals("")) {
                        textView.setBackgroundDrawable((Drawable) null);
                    } else {
                        ((GradientDrawable) textView.getBackground()).setColor(Color.parseColor("#" + t_submenu.this.s.txt_bg));
                        ((GradientDrawable) textView.getBackground()).setCornerRadius((float) t_submenu.this.s.txt_radius);
                    }
                    textView.setVisibility(0);
                }
            }
            if (t_submenu.this.s.mostrar_icos) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_menugrid);
                if (t_submenu.this.seccs_a[i].ico_cargando || t_submenu.this.seccs_a[i].ico == null) {
                    imageView2.setImageBitmap((Bitmap) null);
                } else {
                    if (!t_submenu.this.seccs_a[i].ico_mostrado) {
                        imageView2.setVisibility(4);
                    }
                    imageView2.setImageDrawable(new BitmapDrawable(t_submenu.this.getResources(), t_submenu.this.seccs_a[i].ico));
                    if (!t_submenu.this.seccs_a[i].ico_mostrado) {
                        t_submenu.this.seccs_a[i].ico_mostrado = true;
                        config.fade_in(imageView2);
                    }
                }
            }
            if (t_submenu.this.s.mostrar_txt) {
                ((TextView) view.findViewById(R.id.tv_menugrid)).setText(t_submenu.this.seccs_a[i].titulo);
            }
            return view;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.globales.secciones_a.length) {
                break;
            } else if (this.seccs_a[i].id == this.globales.secciones_a[i3].id) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        view.setId(i2);
        view.setTag(R.id.TAG_IDSECC, Integer.valueOf(i2));
        view.setTag(R.id.idaux1, 1);
        if (!this.s.descargar || this.seccs_a[i].tipo != 1) {
            if (this.s.linksexternos == 1 && this.seccs_a[i].tipo == 1) {
                String str = this.seccs_a[i].url;
                if (!str.contains("forum." + config.DOM_EDROID + "")) {
                    String str2 = this.seccs_a[i].url;
                    if (!str2.contains("quiz." + config.DOM_EDROID + "")) {
                        String str3 = this.seccs_a[i].url;
                        if (!str3.contains("games." + config.DOM_EDROID + "") && !this.seccs_a[i].url.contains("pixworld.io-desdeac")) {
                            view.setTag(R.id.idaux2, this.seccs_a[i].url);
                        }
                    }
                }
            }
            onClick(view);
            return;
        }
        this.globales.fdescargar(this.seccs_a[i].url, "", "", this);
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
        if (view.getTag(R.id.idaux2) != null) {
            this.globales.abrir_ext(this, (String) view.getTag(R.id.idaux2));
            return;
        }
        ResultGetIntent intent = this.globales.getIntent(view, this);
        if (intent != null) {
            if (view.getTag(R.id.idaux1) != null) {
                intent.finalizar = false;
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

    private class cargarfoto extends AsyncTask<String, Void, Byte> {
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
                r5.ind = r2
                r2 = 2
                r6 = r6[r2]
                r5.vfoto = r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN
                r6.append(r2)
                java.lang.String r2 = "/srv/imgs/fondos_submenu/"
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
                java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0084 }
                r4.<init>(r6)     // Catch:{ MalformedURLException -> 0x0084 }
                java.net.URLConnection r6 = r4.openConnection()     // Catch:{ IOException -> 0x007f }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x007f }
                r6.setDoInput(r1)     // Catch:{ IOException -> 0x007f }
                r1 = 5000(0x1388, float:7.006E-42)
                r6.setConnectTimeout(r1)     // Catch:{ IOException -> 0x007f }
                r1 = 7000(0x1b58, float:9.809E-42)
                r6.setReadTimeout(r1)     // Catch:{ IOException -> 0x007f }
                r6.connect()     // Catch:{ IOException -> 0x007f }
                java.io.InputStream r6 = r6.getInputStream()     // Catch:{ IOException -> 0x007f }
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ IOException -> 0x007f }
                stikerwap.appdys.t_submenu r1 = stikerwap.appdys.t_submenu.this     // Catch:{ Exception -> 0x007a }
                java.io.FileOutputStream r1 = r1.openFileOutput(r2, r0)     // Catch:{ Exception -> 0x007a }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x007a }
                r4 = 100
                r6.compress(r2, r4, r1)     // Catch:{ Exception -> 0x007a }
                r1.close()     // Catch:{ Exception -> 0x007a }
                java.lang.Byte r6 = java.lang.Byte.valueOf(r0)
                return r6
            L_0x007a:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)     // Catch:{ IOException -> 0x007f }
                return r6
            L_0x007f:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            L_0x0084:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r3)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_submenu.cargarfoto.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (b.byteValue() == 0) {
                try {
                    ImageView imageView = (ImageView) t_submenu.this.findViewById(R.id.iv_fondo);
                    t_submenu.this.globales.tratar_fondo(imageView, Boolean.valueOf(t_submenu.this.s.fondo_margen), t_submenu.this.s.fondo_tipo);
                    imageView.setVisibility(8);
                    config config = t_submenu.this.globales;
                    config.file_to_iv("fondo_" + t_submenu.this.s.idfondo, imageView);
                    config.fade_in(imageView);
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = t_submenu.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit.putInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + this.idfoto + "_fondo_modif", 0);
                edit.commit();
                t_submenu.this.globales.secciones_a[Integer.parseInt(this.ind)].fondo_modif = false;
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
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

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
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
                if (!t_submenu.this.globales.admob_rew_failed(context, t_submenu.this.mAd_appnext)) {
                    t_submenu.this.dialog_cargando.cancel();
                    t_submenu t_submenu = t_submenu.this;
                    t_submenu.abrir_secc(t_submenu.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_submenu.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        t_submenu.this.abrir_secc(t_submenu.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_submenu.this.mAd_visto) {
                            t_submenu.this.abrir_secc(t_submenu.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_submenu.this.mAd_visto = true;
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
                if (t_submenu.this.mAd_visto) {
                    t_submenu t_submenu = t_submenu.this;
                    t_submenu.abrir_secc(t_submenu.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
