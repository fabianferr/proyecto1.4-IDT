package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import java.text.NumberFormat;
import java.util.ArrayList;

public class t_buscchats_lista extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    /* access modifiers changed from: private */
    public cargar_foto_async cfa;
    Bundle extras;
    config globales;
    /* access modifiers changed from: private */
    public boolean haymas = false;
    private int idcat;
    private int idsubcat;
    long idusu;
    int ind;
    boolean mAd_visto = false;
    /* access modifiers changed from: private */
    public RecyclerView.Adapter mAdapter;
    ListView mDrawerList;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public ArrayList<Integer> m_inds = null;
    /* access modifiers changed from: private */
    public ArrayList<claseChat> m_orders = null;
    /* access modifiers changed from: private */
    public ArrayList<claseChat> m_orders_temp = null;
    /* access modifiers changed from: private */
    public boolean obtencion_ok = false;
    private Runnable returnRes = new Runnable() {
        public void run() {
            String str;
            try {
                t_buscchats_lista.this.findViewById(R.id.pb_chats).setVisibility(8);
            } catch (Exception unused) {
            }
            if (t_buscchats_lista.this.m_orders_temp != null && t_buscchats_lista.this.m_orders_temp.size() > 0) {
                for (int i = 0; i < t_buscchats_lista.this.m_orders_temp.size(); i++) {
                    if (t_buscchats_lista.this.m_inds.indexOf(Integer.valueOf(((claseChat) t_buscchats_lista.this.m_orders_temp.get(i)).id)) == -1) {
                        t_buscchats_lista.this.m_orders.add((claseChat) t_buscchats_lista.this.m_orders_temp.get(i));
                        t_buscchats_lista.this.m_inds.add(Integer.valueOf(((claseChat) t_buscchats_lista.this.m_orders_temp.get(i)).id));
                    }
                }
            }
            t_buscchats_lista.this.mAdapter.notifyDataSetChanged();
            if (t_buscchats_lista.this.m_orders != null && t_buscchats_lista.this.m_orders.size() == 0) {
                if (!t_buscchats_lista.this.obtencion_ok) {
                    str = t_buscchats_lista.this.getResources().getString(R.string.error_http);
                } else if (t_buscchats_lista.this.tipo == 3) {
                    str = t_buscchats_lista.this.getResources().getString(R.string.lista_vacia_favoritos);
                } else {
                    str = t_buscchats_lista.this.getResources().getString(R.string.lista_vacia_porcat);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(t_buscchats_lista.this);
                builder.setCancelable(true).setPositiveButton(t_buscchats_lista.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(str);
                try {
                    AlertDialog create = builder.create();
                    create.show();
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused2) {
                }
            }
            if (t_buscchats_lista.this.m_orders != null && t_buscchats_lista.this.m_orders.size() > 0) {
                t_buscchats_lista.this.cfa = new cargar_foto_async();
                t_buscchats_lista.this.cfa.execute(new String[0]);
            }
        }
    };
    SharedPreferences settings;
    /* access modifiers changed from: private */
    public int sinfoto_global;
    /* access modifiers changed from: private */
    public Thread thread;
    /* access modifiers changed from: private */
    public int tipo;
    private boolean usu_inapropiado = false;
    /* access modifiers changed from: private */
    public Runnable viewOrders;

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
        this.ind = this.extras.getInt("ind");
        this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[this.ind].c1, this.globales.c_icos);
        if (!config.esClaro("#" + this.globales.secciones_a[this.ind].c1)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.t_buscchats_lista);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_buscchats_lista.this.finalizar = false;
                t_buscchats_lista.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_buscchats_lista.this.buscador_on = false;
            }
        });
        config config2 = this.globales;
        Bundle bundle2 = this.extras;
        boolean z = bundle2 != null && bundle2.containsKey("ad_entrar");
        Bundle bundle3 = this.extras;
        config2.toca_int(this, z, bundle3 != null && bundle3.containsKey("fb_entrar"));
        this.idcat = 0;
        this.idsubcat = 0;
        this.tipo = 0;
        Bundle bundle4 = this.extras;
        if (bundle4 != null && bundle4.containsKey("idcat")) {
            this.idcat = this.extras.getInt("idcat");
        }
        Bundle bundle5 = this.extras;
        if (bundle5 != null && bundle5.containsKey("idsubcat")) {
            this.idsubcat = this.extras.getInt("idsubcat");
        }
        Bundle bundle6 = this.extras;
        if (bundle6 != null && bundle6.containsKey("tipo")) {
            this.tipo = this.extras.getInt("tipo");
        }
        this.anun = this.globales.mostrar_banner(this, false);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.sinfoto_global = R.drawable.sinfoto_chat;
        if (!this.globales.secciones_a[this.ind].c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.secciones_a[this.ind].c1), Color.parseColor("#" + this.globales.secciones_a[this.ind].c2)}));
        }
        if (config.esClaro("#" + this.globales.secciones_a[this.ind].c1)) {
            findViewById(R.id.ll_cabe).setBackgroundColor(config.GRIS_OSCURO);
            ((TextView) findViewById(R.id.tv_cabe)).setTextColor(-1);
        } else {
            findViewById(R.id.ll_cabe).setBackgroundColor(config.GRIS_CLARO);
            ((TextView) findViewById(R.id.tv_cabe)).setTextColor(config.NEGRO);
        }
        Bundle bundle7 = this.extras;
        if (bundle7 != null && bundle7.containsKey("tit_cab")) {
            ((TextView) findViewById(R.id.tv_cabe)).setText(this.extras.getString("tit_cab"));
            findViewById(R.id.tv_cabe).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    t_buscchats_lista.this.finish();
                }
            });
            findViewById(R.id.iv_cabe).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    t_buscchats_lista.this.finish();
                }
            });
            findViewById(R.id.ll_cabe).setVisibility(0);
        }
        this.m_orders = new ArrayList<>();
        this.m_inds = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(this.m_orders);
        this.mAdapter = myAdapter;
        this.mRecyclerView.setAdapter(myAdapter);
        this.viewOrders = new Runnable() {
            public void run() {
                t_buscchats_lista.this.getOrders();
            }
        };
        this.thread = new Thread((ThreadGroup) null, this.viewOrders, "buscandoelems");
        findViewById(R.id.pb_chats).setVisibility(0);
        this.thread.start();
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

    public void onClick(View view) {
        if (view.getId() == R.id.fila) {
            int childPosition = this.mRecyclerView.getChildPosition(view);
            if (childPosition < this.m_orders.size() && childPosition != -1) {
                abrir_detalle(this.m_orders.get(childPosition), childPosition);
            }
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    private void abrir_detalle(claseChat clasechat, int i) {
        Intent intent = new Intent(this, t_chat_contra.class);
        intent.putExtra("externo", true);
        intent.putExtra("idchat", clasechat.id);
        intent.putExtra("idtema", clasechat.idtema);
        intent.putExtra("fotos_perfil", clasechat.fotos_perfil);
        intent.putExtra("fnac", clasechat.p_fnac);
        intent.putExtra("sexo", clasechat.p_sexo);
        intent.putExtra("descr", clasechat.p_descr);
        intent.putExtra("dist", clasechat.p_dist);
        intent.putExtra("privados", clasechat.privados);
        intent.putExtra("coments", clasechat.coments);
        intent.putExtra("galeria", clasechat.galeria);
        intent.putExtra("fotos_chat", clasechat.fotos_chat);
        intent.putExtra("c1", clasechat.c1);
        intent.putExtra("c2", clasechat.c2);
        intent.putExtra("tit_cab", clasechat.titulo);
        startActivityForResult(intent, 0);
    }

    public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private ArrayList<claseChat> items;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView iv1;
            public LinearLayout ll_fila;
            public TextView tt;
            public TextView tt2;

            public ViewHolder(View view) {
                super(view);
                this.ll_fila = (LinearLayout) view.findViewById(R.id.fila);
                this.tt = (TextView) view.findViewById(R.id.titulo);
                this.tt2 = (TextView) view.findViewById(R.id.nusus);
                this.iv1 = (ImageView) view.findViewById(R.id.f1);
            }
        }

        public MyAdapter(ArrayList<claseChat> arrayList) {
            this.items = arrayList;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_chat, viewGroup, false);
            Drawable drawable = t_buscchats_lista.this.getResources().getDrawable(R.drawable.ir);
            if (!t_buscchats_lista.this.cbtn.equals("")) {
                drawable.setColorFilter(Color.parseColor("#" + t_buscchats_lista.this.cbtn), PorterDuff.Mode.MULTIPLY);
            }
            ((ImageView) inflate.findViewById(R.id.iv_ir)).setImageDrawable(drawable);
            if (config.esClaro("#" + t_buscchats_lista.this.globales.secciones_a[t_buscchats_lista.this.ind].c1)) {
                ((TextView) inflate.findViewById(R.id.titulo)).setTextColor(config.NEGRO);
                ((TextView) inflate.findViewById(R.id.nusus)).setTextColor(config.NEGRO_2);
            } else {
                ((TextView) inflate.findViewById(R.id.titulo)).setTextColor(-1);
                ((TextView) inflate.findViewById(R.id.nusus)).setTextColor(config.BLANCO_2);
            }
            inflate.setOnClickListener(t_buscchats_lista.this);
            return new ViewHolder(inflate);
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            claseChat clasechat = this.items.get(i);
            viewHolder.tt.setText(clasechat.titulo);
            if (clasechat.nusus < 10) {
                TextView textView = viewHolder.tt2;
                textView.setText("<10 " + t_buscchats_lista.this.getResources().getString(R.string.usuarios));
            } else {
                TextView textView2 = viewHolder.tt2;
                textView2.setText(NumberFormat.getInstance().format((long) clasechat.nusus) + " " + t_buscchats_lista.this.getResources().getString(R.string.usuarios));
            }
            if (clasechat.nfoto1 == 0) {
                viewHolder.iv1.setImageDrawable(t_buscchats_lista.this.getResources().getDrawable(t_buscchats_lista.this.sinfoto_global));
            } else if (clasechat.b1 != null) {
                viewHolder.iv1.setImageBitmap(clasechat.b1);
                if (!clasechat.mostrada) {
                    clasechat.mostrada = true;
                    viewHolder.iv1.setVisibility(0);
                }
            } else if (clasechat.cargada_1) {
                viewHolder.iv1.setImageDrawable(t_buscchats_lista.this.getResources().getDrawable(t_buscchats_lista.this.sinfoto_global));
            } else {
                viewHolder.iv1.setImageDrawable(t_buscchats_lista.this.getResources().getDrawable(R.drawable.cargando));
            }
            viewHolder.ll_fila.setTag(Integer.valueOf(i));
            if (t_buscchats_lista.this.haymas && i == t_buscchats_lista.this.m_orders.size() - 1) {
                if (t_buscchats_lista.this.thread == null || !t_buscchats_lista.this.thread.isAlive()) {
                    t_buscchats_lista.this.findViewById(R.id.pb_chats).setVisibility(0);
                    t_buscchats_lista.this.thread = new Thread((ThreadGroup) null, t_buscchats_lista.this.viewOrders, "buscandoelems");
                    t_buscchats_lista.this.thread.start();
                }
            }
        }

        public int getItemCount() {
            return this.items.size();
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.net.URLConnection] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0204  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getOrders() {
        /*
            r30 = this;
            r1 = r30
            r2 = 1
            r3 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r0.<init>()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00a8 }
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "/srv/obtenerchats.php?idusu="
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            long r4 = r1.idusu     // Catch:{ Exception -> 0x00a8 }
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "&tipo="
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            int r4 = r1.tipo     // Catch:{ Exception -> 0x00a8 }
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "&idcat="
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            int r4 = r1.idcat     // Catch:{ Exception -> 0x00a8 }
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "&idsubcat="
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            int r4 = r1.idsubcat     // Catch:{ Exception -> 0x00a8 }
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "&fila="
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.util.ArrayList<stikerwap.appdys.claseChat> r4 = r1.m_orders     // Catch:{ Exception -> 0x00a8 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x00a8 }
            r0.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00a8 }
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x00a8 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00a8 }
            java.net.URLConnection r0 = r4.openConnection()     // Catch:{ Exception -> 0x00a8 }
            r4 = r0
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x00a8 }
            r4.setDoInput(r2)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r0 = 10000(0x2710, float:1.4013E-41)
            r4.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r4.setReadTimeout(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.lang.String r0 = "User-Agent"
            java.lang.String r3 = "Android Vinebre Software"
            r4.setRequestProperty(r0, r3)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r0.<init>()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
        L_0x0079:
            java.lang.String r5 = r3.readLine()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            if (r5 == 0) goto L_0x0094
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r6.<init>()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r6.append(r5)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.lang.String r5 = "\n"
            r6.append(r5)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            r0.append(r5)     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            goto L_0x0079
        L_0x0094:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00a2, all -> 0x009e }
            if (r4 == 0) goto L_0x00b3
            r4.disconnect()
            goto L_0x00b3
        L_0x009e:
            r0 = move-exception
            r3 = r4
            goto L_0x0202
        L_0x00a2:
            r0 = move-exception
            r3 = r4
            goto L_0x00a9
        L_0x00a5:
            r0 = move-exception
            goto L_0x0202
        L_0x00a8:
            r0 = move-exception
        L_0x00a9:
            r0.printStackTrace()     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x00b1
            r3.disconnect()
        L_0x00b1:
            java.lang.String r0 = ""
        L_0x00b3:
            java.lang.String r3 = "ANDROID:KO MOTIVO:INAPROPIADO"
            int r3 = r0.indexOf(r3)
            r4 = -1
            if (r3 == r4) goto L_0x00be
            r1.usu_inapropiado = r2
        L_0x00be:
            java.lang.String r3 = "ANDROID:OK RESULT:"
            int r3 = r0.indexOf(r3)
            r5 = 0
            r1.obtencion_ok = r5
            if (r3 == r4) goto L_0x01fa
            android.content.SharedPreferences r6 = r1.settings
            android.content.SharedPreferences$Editor r6 = r6.edit()
            r1.obtencion_ok = r2
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r1.m_orders_temp = r7
            java.lang.String r7 = "ANDROID:OK RESULT:0"
            int r7 = r0.indexOf(r7)
            if (r7 == r4) goto L_0x00e3
            r1.haymas = r5
            goto L_0x00ed
        L_0x00e3:
            java.lang.String r7 = "ANDROID:OK RESULT:1"
            int r7 = r0.indexOf(r7)
            if (r7 == r4) goto L_0x00ed
            r1.haymas = r2
        L_0x00ed:
            java.lang.String r7 = "@y@"
            int r3 = r0.indexOf(r7, r3)
        L_0x00f3:
            if (r3 == r4) goto L_0x01f7
            int r3 = r3 + 3
            java.lang.String r8 = ";"
            int r9 = r0.indexOf(r8, r3)
            java.lang.String r3 = r0.substring(r3, r9)
            int r11 = java.lang.Integer.parseInt(r3)
            int r9 = r9 + r2
            int r3 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r3)
            int r12 = java.lang.Integer.parseInt(r9)
            int r3 = r3 + r2
            int r9 = r0.indexOf(r8, r3)
            java.lang.String r3 = r0.substring(r3, r9)
            int r13 = java.lang.Integer.parseInt(r3)
            int r9 = r9 + r2
            int r3 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r3)
            int r17 = java.lang.Integer.parseInt(r9)
            int r3 = r3 + r2
            int r9 = r0.indexOf(r8, r3)
            java.lang.String r3 = r0.substring(r3, r9)
            int r3 = java.lang.Integer.parseInt(r3)
            int r9 = r9 + r2
            int r9 = r0.indexOf(r8, r9)
            int r9 = r9 + r2
            int r10 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r10)
            int r22 = java.lang.Integer.parseInt(r9)
            int r10 = r10 + r2
            int r9 = r0.indexOf(r8, r10)
            java.lang.String r14 = r0.substring(r10, r9)
            int r9 = r9 + r2
            int r10 = r0.indexOf(r8, r9)
            java.lang.String r15 = r0.substring(r9, r10)
            int r10 = r10 + r2
            int r9 = r0.indexOf(r8, r10)
            java.lang.String r16 = r0.substring(r10, r9)
            int r9 = r9 + r2
            int r10 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r10)
            int r26 = java.lang.Integer.parseInt(r9)
            int r10 = r10 + r2
            int r9 = r0.indexOf(r8, r10)
            java.lang.String r10 = r0.substring(r10, r9)
            int r10 = java.lang.Integer.parseInt(r10)
            int r9 = r9 + r2
            int r4 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r4)
            int r18 = java.lang.Integer.parseInt(r9)
            int r4 = r4 + r2
            int r9 = r0.indexOf(r8, r4)
            java.lang.String r4 = r0.substring(r4, r9)
            int r19 = java.lang.Integer.parseInt(r4)
            int r9 = r9 + r2
            int r4 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r4)
            int r20 = java.lang.Integer.parseInt(r9)
            int r4 = r4 + r2
            int r9 = r0.indexOf(r8, r4)
            java.lang.String r4 = r0.substring(r4, r9)
            int r4 = java.lang.Integer.parseInt(r4)
            int r9 = r9 + r2
            int r8 = r0.indexOf(r8, r9)
            java.lang.String r9 = r0.substring(r9, r8)
            int r21 = java.lang.Integer.parseInt(r9)
            r27 = 0
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            java.util.ArrayList<stikerwap.appdys.claseChat> r5 = r1.m_orders_temp
            stikerwap.appdys.claseChat r1 = new stikerwap.appdys.claseChat
            if (r3 != r2) goto L_0x01d0
            r23 = 1
            goto L_0x01d2
        L_0x01d0:
            r23 = 0
        L_0x01d2:
            if (r10 != r2) goto L_0x01d7
            r24 = 1
            goto L_0x01d9
        L_0x01d7:
            r24 = 0
        L_0x01d9:
            if (r4 != r2) goto L_0x01de
            r25 = 1
            goto L_0x01e0
        L_0x01de:
            r25 = 0
        L_0x01e0:
            r28 = 1
            boolean r29 = r9.booleanValue()
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r5.add(r1)
            int r3 = r0.indexOf(r7, r8)
            r4 = -1
            r5 = 0
            r1 = r30
            goto L_0x00f3
        L_0x01f7:
            r6.commit()
        L_0x01fa:
            r1 = r30
            java.lang.Runnable r0 = r1.returnRes
            r1.runOnUiThread(r0)
            return
        L_0x0202:
            if (r3 == 0) goto L_0x0207
            r3.disconnect()
        L_0x0207:
            goto L_0x0209
        L_0x0208:
            throw r0
        L_0x0209:
            goto L_0x0208
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscchats_lista.getOrders():void");
    }

    private class cargar_foto_async extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        int f;
        int idapp;
        int idfoto;
        int ind;

        private cargar_foto_async() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= t_buscchats_lista.this.m_orders.size()) {
                    break;
                }
                claseChat clasechat = (claseChat) t_buscchats_lista.this.m_orders.get(i);
                if (!clasechat.cargada_1 && clasechat.nfoto1 != 0) {
                    this.f = 1;
                    this.idfoto = clasechat.nfoto1;
                    this.idapp = clasechat.idapp;
                    this.ind = i;
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                cancel(true);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r9) {
            /*
                r8 = this;
                java.lang.String r9 = "ANDROID:KO"
                int r0 = r8.idfoto     // Catch:{ Exception -> 0x0099 }
                r1 = 100
                if (r0 <= r1) goto L_0x000b
                int r0 = r0 - r1
                r8.idfoto = r0     // Catch:{ Exception -> 0x0099 }
            L_0x000b:
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x002f }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x002f }
                r2.<init>()     // Catch:{ MalformedURLException -> 0x002f }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x002f }
                r2.append(r3)     // Catch:{ MalformedURLException -> 0x002f }
                java.lang.String r3 = "/srv/imgs/gen/"
                r2.append(r3)     // Catch:{ MalformedURLException -> 0x002f }
                int r3 = r8.idapp     // Catch:{ MalformedURLException -> 0x002f }
                r2.append(r3)     // Catch:{ MalformedURLException -> 0x002f }
                java.lang.String r3 = "_ico.png"
                r2.append(r3)     // Catch:{ MalformedURLException -> 0x002f }
                java.lang.String r2 = r2.toString()     // Catch:{ MalformedURLException -> 0x002f }
                r1.<init>(r2)     // Catch:{ MalformedURLException -> 0x002f }
                goto L_0x0030
            L_0x002f:
                r1 = r0
            L_0x0030:
                java.net.URLConnection r2 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{  }
                r3 = 1
                r2.setDoInput(r3)     // Catch:{  }
                r4 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r4)     // Catch:{  }
                r5 = 7000(0x1b58, float:9.809E-42)
                r2.setReadTimeout(r5)     // Catch:{  }
                r2.connect()     // Catch:{  }
                java.io.InputStream r6 = r2.getInputStream()     // Catch:{  }
                android.graphics.BitmapFactory$Options r7 = new android.graphics.BitmapFactory$Options     // Catch:{  }
                r7.<init>()     // Catch:{  }
                r7.inJustDecodeBounds = r3     // Catch:{  }
                android.graphics.BitmapFactory.decodeStream(r6, r0, r7)     // Catch:{  }
                r6.close()     // Catch:{  }
                r2.disconnect()     // Catch:{  }
                stikerwap.appdys.t_buscchats_lista r2 = stikerwap.appdys.t_buscchats_lista.this     // Catch:{  }
                android.content.res.Resources r2 = r2.getResources()     // Catch:{  }
                android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch:{  }
                r6 = 1128792064(0x43480000, float:200.0)
                float r2 = android.util.TypedValue.applyDimension(r3, r6, r2)     // Catch:{  }
                int r2 = java.lang.Math.round(r2)     // Catch:{  }
                int r2 = stikerwap.appdys.config.calculateInSampleSize(r7, r2, r2)     // Catch:{  }
                r7.inSampleSize = r2     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r1.setDoInput(r3)     // Catch:{  }
                r1.setConnectTimeout(r4)     // Catch:{  }
                r1.setReadTimeout(r5)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r1 = r1.getInputStream()     // Catch:{  }
                r2 = 0
                r7.inJustDecodeBounds = r2     // Catch:{  }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1, r0, r7)     // Catch:{  }
                r8.bmImg = r0     // Catch:{  }
                r1.close()     // Catch:{  }
                java.lang.String r9 = "ANDROID:OK"
            L_0x0099:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscchats_lista.cargar_foto_async.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            try {
                if (this.f == 1) {
                    ((claseChat) t_buscchats_lista.this.m_orders.get(this.ind)).cargada_1 = true;
                }
                if (str.indexOf("ANDROID:OK") != -1 && this.f == 1) {
                    ((claseChat) t_buscchats_lista.this.m_orders.get(this.ind)).b1 = config.crop(this.bmImg, 1);
                }
                t_buscchats_lista.this.mAdapter.notifyDataSetChanged();
                t_buscchats_lista t_buscchats_lista = t_buscchats_lista.this;
                t_buscchats_lista.cfa = new cargar_foto_async();
                t_buscchats_lista.this.cfa.execute(new String[0]);
            } catch (Exception unused) {
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
        this.anun = this.globales.mostrar_banner(this, false);
    }

    public void onStop() {
        if (this.usu_inapropiado) {
            finish();
        }
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void onPause() {
        Anuncios anuncios;
        Anuncios anuncios2;
        cargar_foto_async cargar_foto_async2 = this.cfa;
        if (cargar_foto_async2 != null) {
            try {
                cargar_foto_async2.cancel(true);
            } catch (Exception unused) {
            }
        }
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
        ArrayList<claseChat> arrayList = this.m_orders;
        if (arrayList != null && arrayList.size() > 0) {
            cargar_foto_async cargar_foto_async2 = new cargar_foto_async();
            this.cfa = cargar_foto_async2;
            cargar_foto_async2.execute(new String[0]);
        }
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
                if (!t_buscchats_lista.this.globales.admob_rew_failed(context, t_buscchats_lista.this.mAd_appnext)) {
                    t_buscchats_lista.this.dialog_cargando.cancel();
                    t_buscchats_lista t_buscchats_lista = t_buscchats_lista.this;
                    t_buscchats_lista.abrir_secc(t_buscchats_lista.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_buscchats_lista.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_buscchats_lista.this.abrir_secc(t_buscchats_lista.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_buscchats_lista.this.mAd_visto) {
                            t_buscchats_lista.this.abrir_secc(t_buscchats_lista.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_buscchats_lista.this.mAd_visto = true;
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
                if (t_buscchats_lista.this.mAd_visto) {
                    t_buscchats_lista t_buscchats_lista = t_buscchats_lista.this;
                    t_buscchats_lista.abrir_secc(t_buscchats_lista.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
