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
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class fotogal extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    cargar_likes c_l;
    String codigo;
    View convertView;
    AlertDialog.Builder dialog_likes;
    Bundle extras;
    config globales;
    String idf;
    long idusu;
    String idusu_profile;
    int indf;
    /* access modifiers changed from: private */
    public likes_adapter itemAdapter;
    String liked;
    /* access modifiers changed from: private */
    public ArrayList<likes_item> listData;
    boolean mAd_visto = false;
    ListView mDrawerList;
    WebView myWebView;
    int n_cargados = 0;
    String nlikes;
    boolean primer_load = true;
    SharedPreferences settings;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        establec_ralc(this);
        this.cbtn = config.aplicar_color_dialog("FFFFFFFF", this.globales.c_icos);
        super.onCreate(bundle);
        setContentView(R.layout.fotogal);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                fotogal.this.finalizar = false;
                fotogal.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                fotogal.this.buscador_on = false;
            }
        });
        this.anun = this.globales.mostrar_banner(this, false);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.codigo = this.settings.getString("cod", "");
        this.nlikes = this.extras.getString("nlikes");
        this.idf = this.extras.getString("idf");
        this.indf = this.extras.getInt("indf");
        this.liked = this.extras.getString("liked");
        this.idusu_profile = this.extras.getString("idusu_profile");
        this.listData = new ArrayList<>();
        TextView textView = (TextView) findViewById(R.id.tv_likes_n);
        findViewById(R.id.tv_likes_n).setBackgroundDrawable(getResources().getDrawable(R.drawable.likes_izq));
        textView.setTextColor(config.NEGRO);
        textView.setText(this.nlikes);
        if (this.liked.equals("1")) {
            str = getResources().getString(R.string.tegusta);
        } else {
            str = "";
        }
        ((TextView) findViewById(R.id.tv_likes)).setText(str);
        findViewById(R.id.iv_cerrar).setOnClickListener(this);
        findViewById(R.id.iv_like).setOnClickListener(this);
        findViewById(R.id.tv_likes_n).setOnClickListener(this);
        String str2 = this.idusu_profile;
        if (str2.equals(this.idusu + "")) {
            findViewById(R.id.iv_reportar).setVisibility(8);
            findViewById(R.id.iv_elim).setOnClickListener(this);
            findViewById(R.id.iv_elim).setVisibility(0);
        } else {
            findViewById(R.id.iv_reportar).setOnClickListener(this);
        }
        this.myWebView = (WebView) findViewById(R.id.webview);
        if (this.extras.getString("url").startsWith(AdPayload.FILE_SCHEME)) {
            this.myWebView.getSettings().setAllowFileAccess(true);
            registerForContextMenu(this.myWebView);
            String str3 = this.globales.c1c;
            String str4 = this.globales.c2c;
            if (this.globales.ind_secc_sel_2 != -1) {
                str3 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
                str4 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
            }
            if (this.extras.containsKey("bg1")) {
                str3 = this.extras.getString("bg1");
                str4 = this.extras.getString("bg2");
            }
            if (!str3.equals("")) {
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + str3), Color.parseColor("#" + str4)}));
                this.myWebView.setBackgroundColor(0);
            }
        }
        this.myWebView.setWebChromeClient(new WebChromeClient() {
        });
        this.myWebView.getSettings().setBuiltInZoomControls(true);
        this.myWebView.getSettings().setSupportZoom(true);
        this.myWebView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.myWebView.getSettings().setUseWideViewPort(true);
        this.myWebView.getSettings().setLoadWithOverviewMode(true);
        this.myWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                boolean z;
                boolean z2;
                if (!fotogal.this.finalizar && !fotogal.this.isFinishing() && !fotogal.this.extras.getString("url").contains("youtube.com") && !fotogal.this.extras.getString("url").contains("youtu.be")) {
                    if (fotogal.this.primer_load) {
                        z = true;
                        z2 = fotogal.this.extras != null && fotogal.this.extras.containsKey("ad_entrar");
                        if (fotogal.this.extras == null || !fotogal.this.extras.containsKey("fb_entrar")) {
                            z = false;
                        }
                        fotogal.this.primer_load = false;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    fotogal.this.globales.toca_int_2(fotogal.this, z2, z, false);
                }
            }
        });
        if (bundle == null) {
            this.myWebView.loadUrl(this.extras.getString("url"));
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getMenuInflater().inflate(R.menu.m3, contextMenu);
        MenuItem findItem = contextMenu.findItem(R.id.guardar);
        String str = findItem.getTitle() + "";
        findItem.setTitle(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        boolean z;
        Uri uriForFile;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.compartir) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeFile = BitmapFactory.decodeFile(this.extras.getString("url").replace(AdPayload.FILE_SCHEME, ""), options);
            try {
                File file = new File(getCacheDir(), "images");
                file.mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(file + "/temporal.png");
                decodeFile.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                z = true;
            } catch (IOException e) {
                e.printStackTrace();
                z = false;
            }
            if (z && (uriForFile = FileProvider.getUriForFile(this, "stikerwap.appdys.fileprovider", new File(new File(getCacheDir(), "images"), "temporal.png"))) != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.addFlags(1);
                intent.setType(getContentResolver().getType(uriForFile));
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.compartir)));
            }
            return true;
        } else if (itemId != R.id.guardar) {
            return super.onContextItemSelected(menuItem);
        } else {
            config.fguardar_foto_desdefile(this.extras.getString("url"), this);
            return true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.myWebView.canGoBack()) {
            this.myWebView.goBack();
            return true;
        }
        fcerrar();
        return true;
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

    public void fcerrar() {
        Intent intent = new Intent();
        intent.putExtra("nlikes", this.nlikes);
        intent.putExtra("liked", this.liked);
        intent.putExtra("idf", this.idf);
        setResult(-1, intent);
        finish();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_cerrar) {
            fcerrar();
        } else if (view.getId() != R.id.tv_likes_n) {
            String str = "";
            if (view.getId() == R.id.iv_like) {
                if (this.liked.equals("0")) {
                    this.nlikes = (Integer.parseInt(this.nlikes) + 1) + str;
                    this.liked = "1";
                    String str2 = this.idusu_profile;
                    if (!str2.equals(this.idusu + str)) {
                        SharedPreferences sharedPreferences = this.settings;
                        if (!sharedPreferences.contains("usufav_" + this.idusu_profile)) {
                            SharedPreferences sharedPreferences2 = this.settings;
                            if (!sharedPreferences2.contains("usufav_noactivar_" + this.idusu_profile)) {
                                SharedPreferences.Editor edit = this.settings.edit();
                                edit.putBoolean("usufav_" + this.idusu_profile, true);
                                edit.commit();
                            }
                        }
                    }
                    if (this.listData.size() > 0) {
                        String str3 = this.listData.get(0).id;
                        if (!str3.equals(this.idusu + str)) {
                            likes_item likes_item = new likes_item();
                            likes_item.id = this.idusu + str;
                            likes_item.nombre = getResources().getString(R.string.tu);
                            likes_item.t_img = this.globales.getTempFile(this, 1).exists();
                            this.listData.add(0, likes_item);
                            this.itemAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    this.nlikes = (Integer.parseInt(this.nlikes) - 1) + str;
                    this.liked = "0";
                    if (this.listData.size() > 0) {
                        String str4 = this.listData.get(0).id;
                        if (str4.equals(this.idusu + str)) {
                            this.listData.remove(0);
                            this.itemAdapter.notifyDataSetChanged();
                        }
                    }
                }
                ((TextView) findViewById(R.id.tv_likes_n)).setText(this.nlikes);
                if (this.liked.equals("1")) {
                    str = getResources().getString(R.string.tegusta);
                }
                ((TextView) findViewById(R.id.tv_likes)).setText(str);
                new enviar_like().execute(new String[0]);
            } else if (view.getId() == R.id.iv_reportar) {
                final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fotogal.this.findViewById(R.id.iv_reportar).setVisibility(8);
                        fotogal fotogal = fotogal.this;
                        config.mostrar_toast(Toast.makeText(fotogal, fotogal.getResources().getString(R.string.enviando), 0));
                        new enviar_reporte().execute(new String[0]);
                    }
                }).setMessage(R.string.confirmar_reportarfoto).create();
                if (!this.cbtn.equals(str)) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + fotogal.this.cbtn));
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + fotogal.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            } else if (view.getId() == R.id.iv_elim) {
                final AlertDialog create2 = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fotogal fotogal = fotogal.this;
                        new elim_foto(fotogal.idf).execute(new String[0]);
                        Intent intent = new Intent();
                        intent.putExtra("elim_foto", fotogal.this.idf);
                        intent.putExtra("indf", fotogal.this.indf);
                        fotogal.this.setResult(-1, intent);
                        fotogal.this.finish();
                    }
                }).setMessage(R.string.confirmar_elimfoto).create();
                if (!this.cbtn.equals(str)) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + fotogal.this.cbtn));
                            Button button2 = create2.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + fotogal.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals(str)) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals(str)) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals(str)) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals(str)) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals(str)) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals(str)) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals(str)) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(str))))))))) {
                abrir_secc(view);
            } else {
                if (this.globales.appnext_rew_cod != null && !this.globales.appnext_rew_cod.equals(str)) {
                    this.mAd_appnext = new RewardedVideo((Context) this, this.globales.appnext_rew_cod);
                }
                if (this.globales.admob_rew_cod != null) {
                    this.globales.admob_rew_cod.equals(str);
                }
                if (this.globales.fb_rew_cod != null && !this.globales.fb_rew_cod.equals(str)) {
                    this.mAd_fb = new RewardedVideoAd(this, this.globales.fb_rew_cod);
                }
                if (this.globales.st_rew_cod != null && !this.globales.st_rew_cod.equals(str)) {
                    this.mAd_st = new StartAppAd(this);
                }
                this.dialog_cargando = new ProgressDialog(this);
                this.v_abrir_secc = view;
                if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                    abrir_secc(view);
                }
            }
        } else if (!this.nlikes.equals("0")) {
            this.dialog_likes = new AlertDialog.Builder(this);
            this.convertView = getLayoutInflater().inflate(R.layout.likes_list, (ViewGroup) null);
            if (Build.VERSION.SDK_INT > 20) {
                config.progress_color((ProgressBar) this.convertView.findViewById(R.id.likes_pb), this.globales.c_icos);
            }
            this.dialog_likes.setView(this.convertView);
            this.dialog_likes.setCancelable(true);
            ListView listView = (ListView) this.convertView.findViewById(R.id.lv);
            listView.setCacheColorHint(0);
            likes_adapter likes_adapter = new likes_adapter(this, R.layout.likes_item, this.listData, this.idusu);
            this.itemAdapter = likes_adapter;
            listView.setAdapter(likes_adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    likes_item likes_item = (likes_item) fotogal.this.listData.get(i);
                    if (!likes_item.es_mas) {
                        String str = likes_item.id;
                        if (!str.equals(fotogal.this.idusu + "")) {
                            String str2 = likes_item.id;
                            if (!str2.equals(fotogal.this.idusu_profile + "")) {
                                Intent intent = new Intent(fotogal.this, profile.class);
                                intent.putExtra("id", likes_item.id);
                                intent.putExtra("privados", likes_item.privados);
                                intent.putExtra("nombre", likes_item.nombre);
                                intent.putExtra("coments", likes_item.coments);
                                intent.putExtra("fnac_d", likes_item.fnac_d);
                                intent.putExtra("fnac_m", likes_item.fnac_m);
                                intent.putExtra("fnac_a", likes_item.fnac_a);
                                intent.putExtra("sexo", likes_item.sexo);
                                intent.putExtra("vfoto", likes_item.vfoto_bd);
                                if (fotogal.this.extras.containsKey("desdepriv")) {
                                    intent.putExtra("desdepriv", "1");
                                }
                                intent.putExtra("p_fnac", fotogal.this.extras.getInt("p_fnac"));
                                intent.putExtra("p_sexo", fotogal.this.extras.getInt("p_sexo"));
                                intent.putExtra("p_descr", fotogal.this.extras.getInt("p_descr"));
                                intent.putExtra("p_dist", fotogal.this.extras.getInt("p_dist"));
                                intent.putExtra("coments_chat", fotogal.this.extras.getBoolean("coments_chat"));
                                intent.putExtra("galeria", fotogal.this.extras.getBoolean("galeria"));
                                intent.putExtra("privados_chat", fotogal.this.extras.getBoolean("privados_chat"));
                                intent.putExtra("fotos_perfil", fotogal.this.extras.getInt("fotos_perfil"));
                                intent.putExtra("fotos_chat", fotogal.this.extras.getInt("fotos_chat"));
                                fotogal.this.startActivityForResult(intent, 0);
                            }
                        }
                    } else if (fotogal.this.c_l == null || fotogal.this.c_l.getStatus() != AsyncTask.Status.RUNNING) {
                        fotogal.this.c_l = new cargar_likes();
                        fotogal.this.c_l.execute(new String[0]);
                    }
                }
            });
            this.dialog_likes.show();
            if (this.listData.size() == 0) {
                cargar_likes cargar_likes2 = this.c_l;
                if (cargar_likes2 == null || cargar_likes2.getStatus() != AsyncTask.Status.RUNNING) {
                    cargar_likes cargar_likes3 = new cargar_likes();
                    this.c_l = cargar_likes3;
                    cargar_likes3.execute(new String[0]);
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
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config != null && config.onActivityResult_glob(i, i2, intent, this)) || i2 != -1) {
            return;
        }
        if (intent == null || !intent.hasExtra("finalizar")) {
            if (intent != null && intent.hasExtra("accion_usu_fav_id")) {
                for (int i3 = 0; i3 < this.listData.size(); i3++) {
                    if (this.listData.get(i3).id.equals(intent.getStringExtra("accion_usu_fav_id"))) {
                        this.listData.get(i3).fav = intent.getBooleanExtra("accion_usu_fav_accion", false);
                        this.itemAdapter.notifyDataSetChanged();
                        return;
                    }
                }
            }
        } else if (intent.getExtras().getBoolean("finalizar")) {
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

    private class enviar_like extends AsyncTask<String, Void, String> {
        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
        }

        private enviar_like() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/like_fotogal.php?idusu=" + fotogal.this.idusu + "&c=" + fotogal.this.codigo + "&idusu_pro=" + fotogal.this.idusu_profile + "&idf=" + fotogal.this.idf + "&modo=" + fotogal.this.liked);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
                return "1";
            } catch (Exception unused) {
                return "ANDROID:KO";
            }
        }
    }

    private class elim_foto extends AsyncTask<String, Void, Byte> {
        String idfoto;

        elim_foto(String str) {
            this.idfoto = str;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0091  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0084 }
                r0.<init>()     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "/srv/eliminar_fotogal.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.fotogal r1 = stikerwap.appdys.fotogal.this     // Catch:{ Exception -> 0x0084 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.fotogal r1 = stikerwap.appdys.fotogal.this     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&idf="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r5.idfoto     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0084 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0084 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0084 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x0084 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0084 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.lang.String r1 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r3.<init>(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r2.<init>(r3)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            L_0x005d:
                java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                if (r1 == 0) goto L_0x0071
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r3.<init>()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                r3.append(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                java.lang.String r1 = "\n"
                r3.append(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                goto L_0x005d
            L_0x0071:
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
                if (r0 == 0) goto L_0x007a
                r0.disconnect()
            L_0x007a:
                return r6
            L_0x007b:
                r6 = move-exception
                goto L_0x008f
            L_0x007d:
                r6 = r0
                goto L_0x0084
            L_0x007f:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x008f
            L_0x0084:
                r0 = 2
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x007f }
                if (r6 == 0) goto L_0x008e
                r6.disconnect()
            L_0x008e:
                return r0
            L_0x008f:
                if (r0 == 0) goto L_0x0094
                r0.disconnect()
            L_0x0094:
                goto L_0x0096
            L_0x0095:
                throw r6
            L_0x0096:
                goto L_0x0095
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.fotogal.elim_foto.doInBackground(java.lang.String[]):java.lang.Byte");
        }
    }

    private class cargar_likes extends AsyncTask<String, Void, String> {
        private cargar_likes() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            fotogal.this.convertView.findViewById(R.id.likes_pb).setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
                r0.<init>()     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "/srv/likes.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.fotogal r1 = stikerwap.appdys.fotogal.this     // Catch:{ Exception -> 0x009e }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.fotogal r1 = stikerwap.appdys.fotogal.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&id_fotogal="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.fotogal r1 = stikerwap.appdys.fotogal.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.idf     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&n="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.fotogal r1 = stikerwap.appdys.fotogal.this     // Catch:{ Exception -> 0x009e }
                int r1 = r1.n_cargados     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009e }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x009e }
                r1.<init>(r0)     // Catch:{ Exception -> 0x009e }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x009e }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x009e }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            L_0x0070:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                if (r2 == 0) goto L_0x008b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r3.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r3.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                r6.append(r2)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                goto L_0x0070
            L_0x008b:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
                if (r0 == 0) goto L_0x0094
                r0.disconnect()
            L_0x0094:
                return r6
            L_0x0095:
                r6 = move-exception
                goto L_0x00a6
            L_0x0097:
                r6 = r0
                goto L_0x009e
            L_0x0099:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00a6
            L_0x009e:
                java.lang.String r0 = ""
                if (r6 == 0) goto L_0x00a5
                r6.disconnect()
            L_0x00a5:
                return r0
            L_0x00a6:
                if (r0 == 0) goto L_0x00ab
                r0.disconnect()
            L_0x00ab:
                goto L_0x00ad
            L_0x00ac:
                throw r6
            L_0x00ad:
                goto L_0x00ac
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.fotogal.cargar_likes.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            try {
                fotogal.this.convertView.findViewById(R.id.likes_pb).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                int indexOf = str.indexOf("DATOS:") + 6;
                String[] split = str.substring(indexOf, str.indexOf(";", indexOf)).split(",");
                if (fotogal.this.listData.size() == 0) {
                    if (fotogal.this.liked.equals("1")) {
                        likes_item likes_item = new likes_item();
                        likes_item.id = fotogal.this.idusu + "";
                        likes_item.nombre = fotogal.this.getResources().getString(R.string.tu);
                        likes_item.t_img = fotogal.this.globales.getTempFile(fotogal.this, 1).exists();
                        fotogal.this.listData.add(likes_item);
                    }
                } else if (((likes_item) fotogal.this.listData.get(fotogal.this.listData.size() - 1)).es_mas) {
                    fotogal.this.listData.remove(fotogal.this.listData.size() - 1);
                }
                int i = 0;
                while (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                    String[] split2 = split[i].split("-");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= fotogal.this.listData.size()) {
                            z = false;
                            break;
                        } else if (((likes_item) fotogal.this.listData.get(i2)).id.equals(split2[0])) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        likes_item likes_item2 = new likes_item();
                        likes_item2.id = split2[0];
                        likes_item2.nombre = split2[1].replace("@X@", ",").replace("@Y@", "-");
                        likes_item2.vfoto_bd = split2[2];
                        if (!likes_item2.vfoto_bd.equals("0")) {
                            likes_item2.t_img = true;
                        }
                        likes_item2.privados = split2[3];
                        likes_item2.fnac_d = split2[4];
                        likes_item2.fnac_m = split2[5];
                        likes_item2.fnac_a = split2[6];
                        likes_item2.sexo = split2[7];
                        likes_item2.coments = split2[8];
                        likes_item2.fav = split2[9].equals("1");
                        fotogal.this.listData.add(likes_item2);
                        fotogal.this.n_cargados++;
                    }
                    i++;
                }
                if (split[i].equals(ExifInterface.LATITUDE_SOUTH)) {
                    likes_item likes_item3 = new likes_item();
                    likes_item3.es_mas = true;
                    fotogal.this.listData.add(likes_item3);
                }
                fotogal.this.itemAdapter.notifyDataSetChanged();
            }
        }
    }

    private class enviar_reporte extends AsyncTask<String, Void, String> {
        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
        }

        private enviar_reporte() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/reportar_fotogal.php?idusu=" + fotogal.this.idusu + "&c=" + fotogal.this.codigo + "&idusu_pro=" + fotogal.this.idusu_profile + "&idf=" + fotogal.this.idf);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
                return "1";
            } catch (Exception unused) {
                return "ANDROID:KO";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.myWebView.saveState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.myWebView.restoreState(bundle);
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
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.resume();
        }
        this.myWebView.onResume();
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
                if (!fotogal.this.globales.admob_rew_failed(context, fotogal.this.mAd_appnext)) {
                    fotogal.this.dialog_cargando.cancel();
                    fotogal fotogal = fotogal.this;
                    fotogal.abrir_secc(fotogal.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                fotogal.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        fotogal.this.abrir_secc(fotogal.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (fotogal.this.mAd_visto) {
                            fotogal.this.abrir_secc(fotogal.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        fotogal.this.mAd_visto = true;
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
                if (fotogal.this.mAd_visto) {
                    fotogal fotogal = fotogal.this;
                    fotogal.abrir_secc(fotogal.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
