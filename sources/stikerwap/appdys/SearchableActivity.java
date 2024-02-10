package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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
import java.util.ArrayList;

public class SearchableActivity extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    Bundle extras;
    config globales;
    ArrayList<search_item> listData;
    private ListView listView;
    boolean mAd_visto = false;
    ListView mDrawerList;
    boolean mostrar_descr;
    boolean mostrar_icos;

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
        this.extras = getIntent().getExtras();
        if (this.globales.tipomenu == 2) {
            this.es_root = false;
        } else {
            this.es_root = true;
        }
        this.cbtn = config.aplicar_color_dialog(this.globales.c1c, this.globales.c_icos);
        if (!config.esClaro("#" + this.globales.c1c)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.searchableactivity);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                SearchableActivity.this.finalizar = false;
                SearchableActivity.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                SearchableActivity.this.buscador_on = false;
            }
        });
        config config2 = this.globales;
        Bundle bundle2 = this.extras;
        boolean z = bundle2 != null && bundle2.containsKey("ad_entrar");
        Bundle bundle3 = this.extras;
        config2.toca_int(this, z, bundle3 != null && bundle3.containsKey("fb_entrar"));
        this.anun = this.globales.mostrar_banner(this, false);
        this.mostrar_icos = false;
        this.mostrar_descr = false;
        if (this.globales.search_show_ico || this.globales.search_show_descr) {
            for (Seccion seccion : this.globales.secciones_a) {
                if (seccion.search_incluir) {
                    if (this.globales.search_show_ico && (seccion.ico_cargando || seccion.ico != null)) {
                        this.mostrar_icos = true;
                    }
                    if (this.globales.search_show_descr && !seccion.descr.equals("")) {
                        this.mostrar_descr = true;
                    }
                    if (this.globales.search_show_ico) {
                        if (this.mostrar_icos) {
                            if (this.globales.search_show_descr) {
                                if (this.mostrar_descr) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (this.globales.search_show_descr) {
                        if (this.mostrar_descr) {
                            if (!this.globales.search_show_ico || this.mostrar_icos) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        this.listView = (ListView) findViewById(R.id.listView);
        if (!this.globales.c1c.equals("") && !this.globales.c2c.equals("")) {
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#" + this.globales.c1c), Color.parseColor("#" + this.globales.c2c)}));
        }
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (SearchableActivity.this.listData != null) {
                    SearchableActivity searchableActivity = SearchableActivity.this;
                    searchableActivity.sel_secc(searchableActivity.listData.get(i).ind);
                }
            }
        });
        handleIntent(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.finalizar = false;
        setResult(0);
        setIntent(intent);
        handleIntent(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleIntent(android.content.Intent r12) {
        /*
            r11 = this;
            java.lang.String r0 = "android.intent.action.SEARCH"
            java.lang.String r1 = r12.getAction()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x013a
            java.lang.String r0 = "query"
            java.lang.String r12 = r12.getStringExtra(r0)
            java.lang.String r12 = r12.toLowerCase()
            java.lang.String r12 = stikerwap.appdys.config.removeAccents(r12)
            java.lang.String r12 = r12.trim()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.listData = r0
            java.lang.String r0 = ""
            boolean r1 = r12.equals(r0)
            r2 = 0
            if (r1 != 0) goto L_0x00fd
            stikerwap.appdys.config r1 = r11.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x0035:
            if (r4 >= r3) goto L_0x00fd
            r6 = r1[r4]
            boolean r7 = r6.search_incluir
            if (r7 == 0) goto L_0x00f7
            stikerwap.appdys.config r7 = r11.globales
            boolean r7 = r7.search_tit
            if (r7 == 0) goto L_0x0053
            java.lang.String r7 = r6.titulo_norm
            if (r7 != 0) goto L_0x0053
            java.lang.String r7 = r6.titulo
            java.lang.String r7 = stikerwap.appdys.config.removeAccents(r7)
            java.lang.String r7 = r7.toLowerCase()
            r6.titulo_norm = r7
        L_0x0053:
            stikerwap.appdys.config r7 = r11.globales
            boolean r7 = r7.search_descr
            if (r7 == 0) goto L_0x0069
            java.lang.String r7 = r6.descr_norm
            if (r7 != 0) goto L_0x0069
            java.lang.String r7 = r6.descr
            java.lang.String r7 = stikerwap.appdys.config.removeAccents(r7)
            java.lang.String r7 = r7.toLowerCase()
            r6.descr_norm = r7
        L_0x0069:
            stikerwap.appdys.config r7 = r11.globales
            boolean r7 = r7.search_tit
            r8 = 1
            if (r7 == 0) goto L_0x0088
            java.lang.String r7 = r6.titulo_norm
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0088
            java.lang.String r7 = r6.titulo_norm
            boolean r7 = r7.contains(r12)
            if (r7 != 0) goto L_0x00b2
            java.lang.String r7 = r6.titulo_norm
            boolean r7 = r12.contains(r7)
            if (r7 != 0) goto L_0x00b2
        L_0x0088:
            stikerwap.appdys.config r7 = r11.globales
            boolean r7 = r7.search_descr
            if (r7 == 0) goto L_0x00a6
            java.lang.String r7 = r6.descr_norm
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00a6
            java.lang.String r7 = r6.descr_norm
            boolean r7 = r7.contains(r12)
            if (r7 != 0) goto L_0x00b2
            java.lang.String r7 = r6.descr_norm
            boolean r7 = r12.contains(r7)
            if (r7 != 0) goto L_0x00b2
        L_0x00a6:
            java.util.ArrayList<java.lang.String> r7 = r6.kw
            if (r7 == 0) goto L_0x00b4
            java.util.ArrayList<java.lang.String> r7 = r6.kw
            boolean r7 = r7.contains(r12)
            if (r7 == 0) goto L_0x00b4
        L_0x00b2:
            r7 = 1
            goto L_0x00d8
        L_0x00b4:
            java.util.ArrayList<java.lang.String> r7 = r6.kw
            if (r7 == 0) goto L_0x00d7
            java.util.ArrayList<java.lang.String> r7 = r6.kw
            java.util.Iterator r7 = r7.iterator()
        L_0x00be:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00d7
            java.lang.Object r9 = r7.next()
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = r9.contains(r12)
            if (r10 != 0) goto L_0x00b2
            boolean r9 = r12.contains(r9)
            if (r9 == 0) goto L_0x00be
            goto L_0x00b2
        L_0x00d7:
            r7 = 0
        L_0x00d8:
            if (r7 == 0) goto L_0x00f7
            stikerwap.appdys.SearchableActivity$search_item r7 = new stikerwap.appdys.SearchableActivity$search_item
            r9 = 0
            r7.<init>()
            r7.ind = r5
            java.lang.String r9 = r6.titulo
            r7.tit = r9
            java.lang.String r9 = r6.descr
            r7.descr = r9
            android.graphics.Bitmap r6 = r6.ico
            if (r6 == 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r8 = 0
        L_0x00f0:
            r7.t_img = r8
            java.util.ArrayList<stikerwap.appdys.SearchableActivity$search_item> r6 = r11.listData
            r6.add(r7)
        L_0x00f7:
            int r5 = r5 + 1
            int r4 = r4 + 1
            goto L_0x0035
        L_0x00fd:
            java.util.ArrayList<stikerwap.appdys.SearchableActivity$search_item> r12 = r11.listData
            boolean r12 = r12.isEmpty()
            r0 = 2131362542(0x7f0a02ee, float:1.8344868E38)
            r1 = 8
            r3 = 2131363180(0x7f0a056c, float:1.8346162E38)
            if (r12 == 0) goto L_0x011c
            android.view.View r12 = r11.findViewById(r0)
            r12.setVisibility(r1)
            android.view.View r12 = r11.findViewById(r3)
            r12.setVisibility(r2)
            goto L_0x012a
        L_0x011c:
            android.view.View r12 = r11.findViewById(r3)
            r12.setVisibility(r1)
            android.view.View r12 = r11.findViewById(r0)
            r12.setVisibility(r2)
        L_0x012a:
            stikerwap.appdys.SearchableActivity$CustomSearchAdapter r12 = new stikerwap.appdys.SearchableActivity$CustomSearchAdapter
            r0 = 2131558696(0x7f0d0128, float:1.8742715E38)
            java.util.ArrayList<stikerwap.appdys.SearchableActivity$search_item> r1 = r11.listData
            r12.<init>(r11, r0, r1)
            android.widget.ListView r0 = r11.listView
            r0.setAdapter(r12)
            goto L_0x0151
        L_0x013a:
            java.lang.String r0 = "android.intent.action.VIEW"
            java.lang.String r1 = r12.getAction()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0151
            java.lang.String r12 = r12.getDataString()
            int r12 = java.lang.Integer.parseInt(r12)
            r11.sel_secc(r12)
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.SearchableActivity.handleIntent(android.content.Intent):void");
    }

    private class search_item {
        public String descr;
        public int ind;
        public boolean t_img;
        public String tit;

        private search_item() {
            this.t_img = false;
        }
    }

    public class CustomSearchAdapter extends ArrayAdapter<search_item> {
        private ArrayList<search_item> datas;

        public CustomSearchAdapter(Context context, int i, ArrayList<search_item> arrayList) {
            super(context, i, arrayList);
            this.datas = arrayList;
        }

        class ViewHolder {
            ImageView iv;
            TextView tv_descr;
            TextView tv_tit;

            ViewHolder() {
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = SearchableActivity.this.getLayoutInflater().inflate(R.layout.search_item, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.iv = (ImageView) view.findViewById(R.id.iv);
                viewHolder.tv_tit = (TextView) view.findViewById(R.id.tv_tit);
                viewHolder.tv_descr = (TextView) view.findViewById(R.id.tv_descr);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (!SearchableActivity.this.mostrar_icos) {
                viewHolder.iv.setVisibility(8);
            } else {
                viewHolder.iv.setVisibility(0);
                if (!this.datas.get(i).t_img) {
                    viewHolder.iv.setImageBitmap((Bitmap) null);
                } else {
                    try {
                        viewHolder.iv.setImageBitmap(SearchableActivity.this.globales.secciones_a[this.datas.get(i).ind].ico);
                    } catch (Exception | OutOfMemoryError unused) {
                    }
                }
            }
            if (SearchableActivity.this.getResources().getBoolean(R.bool.es_rtl)) {
                viewHolder.tv_tit.setTextDirection(4);
                viewHolder.tv_descr.setTextDirection(4);
            }
            if (SearchableActivity.this.globales.search_show_tit) {
                viewHolder.tv_tit.setText(this.datas.get(i).tit);
            }
            if (!SearchableActivity.this.mostrar_descr) {
                viewHolder.tv_descr.setVisibility(8);
            } else if (SearchableActivity.this.globales.search_show_tit) {
                viewHolder.tv_descr.setText(this.datas.get(i).descr);
                viewHolder.tv_descr.setVisibility(0);
            } else {
                viewHolder.tv_tit.setText(this.datas.get(i).descr);
                viewHolder.tv_descr.setVisibility(8);
            }
            return view;
        }
    }

    /* access modifiers changed from: private */
    public void sel_secc(int i) {
        View view = new View(this);
        view.setId(i);
        view.setTag(R.id.TAG_IDSECC, Integer.valueOf(i));
        if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
            abrir_secc_pos(i);
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
            abrir_secc_pos(i);
        }
    }

    public void abrir_secc_pos(int i) {
        ResultGetIntent crear_rgi = this.globales.crear_rgi(Integer.valueOf(i), this);
        this.finalizar = true;
        Intent intent = new Intent();
        intent.putExtra("finalizar", crear_rgi.finalizar);
        setResult(-1, intent);
        if (this.globales.tipomenu != 2) {
            crear_rgi.i.putExtra("es_root", true);
        }
        startActivity(crear_rgi.i);
        finish();
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
            ListView listView2 = (ListView) findViewById(R.id.left_drawer);
            this.mDrawerList = listView2;
            this.globales.config_drawer(listView2);
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
                if (!SearchableActivity.this.globales.admob_rew_failed(context, SearchableActivity.this.mAd_appnext)) {
                    SearchableActivity.this.dialog_cargando.cancel();
                    SearchableActivity searchableActivity = SearchableActivity.this;
                    searchableActivity.abrir_secc(searchableActivity.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                SearchableActivity.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        SearchableActivity.this.abrir_secc(SearchableActivity.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (SearchableActivity.this.mAd_visto) {
                            SearchableActivity.this.abrir_secc(SearchableActivity.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        SearchableActivity.this.mAd_visto = true;
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
                if (SearchableActivity.this.mAd_visto) {
                    SearchableActivity searchableActivity = SearchableActivity.this;
                    searchableActivity.abrir_secc(searchableActivity.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
