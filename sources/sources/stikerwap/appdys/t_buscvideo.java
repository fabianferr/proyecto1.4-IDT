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
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import stikerwap.appdys.t_chat;

public class t_buscvideo extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_propia;
    String c1;
    boolean c1_esclaro;
    String c2;
    cargar_fotoscoments c_f;
    cargar_likes c_l;
    String cbtn_fondoclaro;
    String codigo;
    View convertView;
    String descr;
    AlertDialog.Builder dialog_likes;
    enviar_coment env;
    boolean esStream = false;
    Bundle extras;
    String fcrea;
    int fotos_perfil;
    config globales;
    String idcoment_ult;
    long idusu;
    String idusu_ban_glob;
    String idusuv;
    String idv;
    int ind;
    int indv;
    /* access modifiers changed from: private */
    public likes_adapter itemAdapter;
    String liked;
    /* access modifiers changed from: private */
    public ArrayList<likes_item> listData;
    LinearLayout ll_coments;
    boolean mAd_visto = false;
    ListView mDrawerList;
    int n_cargados = 0;
    String nlikes;
    String nombre;
    File path;
    ProgressBar pb_enviando;
    SharedPreferences settings;
    int stopPosition = 0;
    String usuv_coments;
    String usuv_fnac_a;
    String usuv_fnac_d;
    String usuv_fnac_m;
    String usuv_privados;
    String usuv_sexo;
    String vfoto;
    FullscreenVideoLayout_pro videoView;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        int i;
        Bitmap bitmap;
        Bundle bundle2 = bundle;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        establec_ralc(this);
        this.extras = getIntent().getExtras();
        this.c1 = this.globales.c1c;
        this.c2 = this.globales.c2c;
        if (this.globales.ind_secc_sel_2 != -1) {
            this.c1 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
            this.c2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
        }
        if (this.extras.containsKey("bg1")) {
            this.c1 = this.extras.getString("bg1");
            this.c2 = this.extras.getString("bg2");
        }
        this.c1_esclaro = true;
        if (bundle2 == null) {
            Bundle bundle3 = this.extras;
            this.es_root = bundle3 != null && bundle3.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle2.containsKey("es_root") && bundle2.getBoolean("es_root", false);
        }
        this.ind = this.extras.getInt("ind");
        this.fotos_perfil = this.globales.secciones_a[this.ind].fotos_perfil;
        this.cbtn = config.aplicar_color_dialog(this.c1, this.globales.c_icos);
        this.cbtn_fondoclaro = config.aplicar_color_dialog("FFE0E0E0", this.globales.c_icos);
        if (!config.esClaro("#" + this.c1)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.t_buscvideo);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_buscvideo.this.finalizar = false;
                t_buscvideo.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_buscvideo.this.buscador_on = false;
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.codigo = this.settings.getString("cod", "");
        this.nlikes = this.extras.getString("nlikes");
        this.liked = this.extras.getString("liked");
        mostrar_likes();
        this.idv = this.extras.getString("idv");
        this.indv = this.extras.getInt("indv");
        this.idusuv = this.extras.getString("idusuv");
        this.descr = this.extras.getString("descr");
        this.nombre = this.extras.getString("nombre");
        this.fcrea = this.extras.getString("fcrea");
        this.vfoto = this.extras.getString("vfoto");
        this.usuv_coments = this.extras.getString("coments");
        this.usuv_fnac_d = this.extras.getString("fnac_d");
        this.usuv_fnac_m = this.extras.getString("fnac_m");
        this.usuv_fnac_a = this.extras.getString("fnac_a");
        this.usuv_privados = this.extras.getString("privados");
        this.usuv_sexo = this.extras.getString("sexo");
        this.path = getFilesDir();
        this.listData = new ArrayList<>();
        this.pb_enviando = (ProgressBar) findViewById(R.id.pb_chat_env_inv);
        if (!this.c1_esclaro) {
            this.pb_enviando = (ProgressBar) findViewById(R.id.pb_chat_env);
        }
        if (this.idusuv.equals(this.idusu + "")) {
            findViewById(R.id.iv_reportar).setVisibility(8);
            findViewById(R.id.iv_elim).setOnClickListener(this);
            findViewById(R.id.iv_elim).setVisibility(0);
        } else {
            findViewById(R.id.iv_reportar).setOnClickListener(this);
        }
        this.videoView = (FullscreenVideoLayout_pro) findViewById(R.id.vv);
        if (this.nombre.equals("") || this.fotos_perfil == 0) {
            findViewById(R.id.videoUser).setVisibility(8);
        } else {
            File file = new File(this.path, "fperfil_" + this.idusuv + ".jpg");
            if (this.vfoto.equals("0") || !file.exists()) {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto);
            } else {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
                } catch (IOException unused) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto);
                }
            }
            ((ImageView) findViewById(R.id.videoUser)).setImageBitmap(config.getCircularBitmapWithWhiteBorder(bitmap, 1));
        }
        if (!this.descr.equals("") || !this.nombre.equals("") || !this.fcrea.equals("")) {
            this.videoView.descr = true;
            findViewById(R.id.ll_descr).setVisibility(0);
            if (!this.descr.equals("")) {
                ((TextView) findViewById(R.id.tv_descr)).setText(this.descr);
                findViewById(R.id.tv_descr).setVisibility(0);
            }
            if (!this.nombre.equals("") || !this.fcrea.equals("")) {
                String str = this.nombre;
                if (!this.fcrea.equals("")) {
                    if (!str.equals("")) {
                        str = str + ", ";
                    }
                    str = str + this.fcrea;
                }
                ((TextView) findViewById(R.id.tv_nombre)).setText(str);
                if (!this.nombre.equals("")) {
                    int parseInt = Integer.parseInt(this.extras.getString("nvideos", "0"));
                    if (this.globales.secciones_a[this.ind].mostrar_videosdeusu && !this.extras.getBoolean("desde_videosdeusu", false) && parseInt > 0) {
                        int dp_to_px = config.dp_to_px(this, 3);
                        if (parseInt < 10) {
                            i = config.dp_to_px(this, 8);
                        } else {
                            i = config.dp_to_px(this, 4);
                        }
                        TextView textView = (TextView) findViewById(R.id.playlist_badge);
                        textView.setPadding(i, dp_to_px, i, dp_to_px);
                        textView.setText("" + parseInt);
                        findViewById(R.id.rl_playlist).setOnClickListener(this);
                        findViewById(R.id.rl_playlist).setVisibility(0);
                    }
                    if (!this.idusuv.equals(this.idusu + "")) {
                        findViewById(R.id.videoUser).setOnClickListener(this);
                        findViewById(R.id.tv_nombre).setOnClickListener(this);
                    }
                }
            } else {
                findViewById(R.id.tv_nombre).setVisibility(8);
            }
        } else {
            this.videoView.descr = false;
        }
        if (this.globales.tipomenu == 1) {
            ((ImageView) findViewById(R.id.iv_drawer)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((DrawerLayout) ((Activity) view.getContext()).findViewById(R.id.drawer_layout)).openDrawer(8388611);
                }
            });
            ((ImageView) findViewById(R.id.icohome)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((DrawerLayout) ((Activity) view.getContext()).findViewById(R.id.drawer_layout)).openDrawer(8388611);
                }
            });
        }
        this.anun = this.globales.mostrar_banner(this, false);
        if (!this.c1.equals("")) {
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#" + this.c1), Color.parseColor("#" + this.c2)}));
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color((ProgressBar) findViewById(R.id.pb_mascoments), this.cbtn_fondoclaro);
            config.progress_color((ProgressBar) findViewById(R.id.pb_mascoments_inv), this.cbtn_fondoclaro);
            config.progress_color((ProgressBar) findViewById(R.id.pb_chat_env), this.cbtn_fondoclaro);
            config.progress_color((ProgressBar) findViewById(R.id.pb_chat_env_inv), this.cbtn_fondoclaro);
        }
        if (this.c1_esclaro) {
            this.bm_propia = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto);
        } else {
            this.bm_propia = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto_light);
        }
        if (this.fotos_perfil > 0) {
            File tempFile = this.globales.getTempFile(this, 1);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(tempFile.getPath(), options);
                int i2 = options.outWidth;
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                if (!(i3 <= 75 && i4 <= 100)) {
                    int round = Math.round(((float) i3) / ((float) config.calculateNewWidth(i3, i4, 75, 100)));
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = round;
                    this.bm_propia = BitmapFactory.decodeFile(tempFile.getPath(), options2);
                } else {
                    this.bm_propia = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(tempFile));
                }
            } catch (Exception | OutOfMemoryError unused2) {
            }
        } else {
            findViewById(R.id.iv_usucoment_self).setVisibility(8);
        }
        this.ll_coments = (LinearLayout) findViewById(R.id.ll_coments);
        if (this.globales.secciones_a[this.ind].pos_coments == 1) {
            this.videoView.coments = true;
            int i5 = !this.c1_esclaro ? -1 : ViewCompat.MEASURED_STATE_MASK;
            ((TextView) findViewById(R.id.tv_coments)).setTextColor(i5);
            if (config.esClaro("#" + this.cbtn_fondoclaro)) {
                findViewById(R.id.iv_enviarcom_fondo_n).setVisibility(0);
            } else {
                findViewById(R.id.iv_enviarcom_fondo_b).setVisibility(0);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.btn_enviar);
            if (!this.cbtn_fondoclaro.equals("")) {
                drawable.setColorFilter(Color.parseColor("#" + this.cbtn_fondoclaro), PorterDuff.Mode.MULTIPLY);
            }
            ((ImageView) findViewById(R.id.iv_enviarcoment)).setImageDrawable(drawable);
            if (config.esClaro("#" + this.cbtn_fondoclaro)) {
                findViewById(R.id.iv_mascoments_fondo_n).setVisibility(0);
            } else {
                findViewById(R.id.iv_mascoments_fondo_b).setVisibility(0);
            }
            Drawable drawable2 = getResources().getDrawable(R.drawable.mas_btn);
            if (!this.cbtn_fondoclaro.equals("")) {
                drawable2.setColorFilter(Color.parseColor("#" + this.cbtn_fondoclaro), PorterDuff.Mode.MULTIPLY);
            }
            ((ImageView) findViewById(R.id.iv_mascoments)).setImageDrawable(drawable2);
            if (Build.VERSION.SDK_INT > 20) {
                config.edittext_color((EditText) findViewById(R.id.et_coment_self), Boolean.valueOf(!this.c1_esclaro), this.cbtn_fondoclaro);
            } else {
                ((EditText) findViewById(R.id.et_coment_self)).setTextColor(i5);
            }
            findViewById(R.id.iv_enviarcoment).setOnClickListener(this);
            findViewById(R.id.iv_mascoments).setOnClickListener(this);
            ((ImageView) findViewById(R.id.iv_usucoment_self)).setImageBitmap(this.bm_propia);
            mostrar_coments(true);
            new cargar_coments(true).execute(new String[0]);
        } else {
            this.videoView.coments = false;
            findViewById(R.id.tv_coments).setVisibility(8);
            findViewById(R.id.rl_enviarcoment).setVisibility(8);
            findViewById(R.id.ll_coments).setVisibility(8);
            new enviar_visto().execute(new String[0]);
        }
        if (this.c1_esclaro) {
            ((TextView) findViewById(R.id.tv_tu)).setTextColor(config.NEGRO);
        } else {
            ((TextView) findViewById(R.id.tv_tu)).setTextColor(-1);
        }
        if (this.idusuv.equals(this.idusu + "")) {
            empezar_video();
            return;
        }
        SharedPreferences sharedPreferences2 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        int i6 = sharedPreferences2.getInt("appnext_video_n", 0) + 1;
        SharedPreferences.Editor edit = sharedPreferences2.edit();
        edit.putInt("appnext_video_n", i6);
        edit.commit();
        if (this.globales.appnext_video_cod.equals("") || i6 < this.globales.appnext_video_ini || (i6 - this.globales.appnext_video_ini) % this.globales.appnext_video_interv != 0) {
            empezar_video();
            return;
        }
        this.videoView.modo_publi = true;
        new cargar_anun().execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public void empezar_video() {
        this.videoView.modo_publi = false;
        this.esStream = false;
        this.videoView.reorganizar(false, this.globales.secciones_a[this.ind].descargar);
        this.videoView.esStream = this.esStream;
        if (this.esStream) {
            this.videoView.hideControlsStream();
        }
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
            }
        });
        this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        try {
            this.videoView.setVideoURI(Uri.parse(this.extras.getString("url")), "Android Vinebre Software");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        String str;
        View findViewById;
        View view2 = view;
        if (view.getId() == R.id.iv_enviarcoment) {
            f_enviar(false);
        } else if (view.getId() == R.id.iv_elimcoment) {
            final View view3 = (View) view.getParent().getParent();
            final String str2 = (String) view3.getTag(R.id.idaux2);
            if (str2 != null) {
                final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        view3.setVisibility(8);
                        int indexOfChild = ((LinearLayout) view3.getParent()).indexOfChild(view3);
                        SharedPreferences.Editor edit = t_buscvideo.this.settings.edit();
                        while (indexOfChild < 4) {
                            SharedPreferences sharedPreferences = t_buscvideo.this.settings;
                            StringBuilder sb = new StringBuilder("idcombv");
                            int i2 = indexOfChild + 1;
                            sb.append(i2);
                            sb.append("_");
                            sb.append(t_buscvideo.this.idv);
                            edit.putString("idcombv" + indexOfChild + "_" + t_buscvideo.this.idv, sharedPreferences.getString(sb.toString(), ""));
                            edit.putString("combv" + indexOfChild + "_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_" + t_buscvideo.this.idv, ""));
                            edit.putString("combv" + indexOfChild + "_fcrea_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fcrea_" + t_buscvideo.this.idv, ""));
                            edit.putString("combv" + indexOfChild + "_idusucrea_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_idusucrea_" + t_buscvideo.this.idv, ""));
                            edit.putString("combv" + indexOfChild + "_nombre_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_nombre_" + t_buscvideo.this.idv, ""));
                            edit.putString("combv" + indexOfChild + "_vfoto_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_vfoto_" + t_buscvideo.this.idv, "0"));
                            edit.putString("combv" + indexOfChild + "_privados_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_privados_" + t_buscvideo.this.idv, "0"));
                            edit.putString("combv" + indexOfChild + "_fnacd_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fnacd_" + t_buscvideo.this.idv, "0"));
                            edit.putString("combv" + indexOfChild + "_fnacm_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fnacm_" + t_buscvideo.this.idv, "0"));
                            edit.putString("combv" + indexOfChild + "_fnaca_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fnaca_" + t_buscvideo.this.idv, "0"));
                            edit.putString("combv" + indexOfChild + "_sexo_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_sexo_" + t_buscvideo.this.idv, "0"));
                            edit.putString("combv" + indexOfChild + "_coments_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_coments_" + t_buscvideo.this.idv, "0"));
                            indexOfChild = i2;
                        }
                        edit.commit();
                        new elim_coment(str2).execute(new String[0]);
                    }
                }).setMessage(R.string.confirmar_elimcoment).create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            }
        } else if (view.getId() == R.id.iv_spamcoment) {
            View view4 = (View) view.getParent().getParent();
            if (view4 != null && (findViewById = view4.findViewById(R.id.iv_usucoment)) != null) {
                ban_usu((String) findViewById.getTag(R.id.idaux1));
            }
        } else if (view.getId() == R.id.iv_mascoments) {
            new cargar_coments(false).execute(new String[0]);
        } else if (view.getId() == R.id.rl_playlist) {
            fcerrar(true);
        } else {
            String str3 = "";
            if (view.getId() == R.id.videoUser || view.getId() == R.id.tv_nombre) {
                Intent intent = new Intent(this, profile.class);
                StringBuilder sb = new StringBuilder();
                String str4 = "p_fnac";
                sb.append(this.idusuv);
                sb.append(str3);
                intent.putExtra("id", sb.toString());
                intent.putExtra("privados", this.usuv_privados);
                intent.putExtra("nombre", this.nombre);
                intent.putExtra("coments", this.usuv_coments);
                intent.putExtra("fnac_d", this.usuv_fnac_d);
                intent.putExtra("fnac_m", this.usuv_fnac_m);
                intent.putExtra("fnac_a", this.usuv_fnac_a);
                intent.putExtra("sexo", this.usuv_sexo);
                intent.putExtra("vfoto", this.vfoto);
                if (this.extras.containsKey("desdepriv")) {
                    intent.putExtra("desdepriv", "1");
                }
                intent.putExtra(str4, this.globales.secciones_a[this.ind].p_fnac);
                intent.putExtra("p_sexo", this.globales.secciones_a[this.ind].p_sexo);
                intent.putExtra("p_descr", this.globales.secciones_a[this.ind].p_descr);
                intent.putExtra("p_dist", this.globales.secciones_a[this.ind].p_dist);
                intent.putExtra("coments_chat", this.globales.secciones_a[this.ind].coments);
                intent.putExtra("galeria", this.globales.secciones_a[this.ind].galeria);
                intent.putExtra("privados_chat", this.globales.secciones_a[this.ind].privados);
                intent.putExtra("fotos_perfil", this.fotos_perfil);
                intent.putExtra("fotos_chat", 1);
                startActivityForResult(intent, 0);
            } else if (view2.getTag(R.id.idaux1) != null && view2.getTag(R.id.idaux1).equals("ESCOMENT")) {
                Intent intent2 = new Intent(this, profile.class);
                intent2.putExtra("id", (String) view2.getTag(R.id.idaux2));
                intent2.putExtra("privados", (String) view2.getTag(R.id.idaux5));
                intent2.putExtra("nombre", (String) view2.getTag(R.id.idaux3));
                intent2.putExtra("coments", (String) view2.getTag(R.id.idaux10));
                intent2.putExtra("fnac_d", (String) view2.getTag(R.id.idaux6));
                intent2.putExtra("fnac_m", (String) view2.getTag(R.id.idaux7));
                intent2.putExtra("fnac_a", (String) view2.getTag(R.id.idaux8));
                intent2.putExtra("sexo", (String) view2.getTag(R.id.idaux9));
                intent2.putExtra("vfoto", (String) view2.getTag(R.id.idaux4));
                if (this.extras.containsKey("desdepriv")) {
                    intent2.putExtra("desdepriv", "1");
                }
                intent2.putExtra("p_fnac", this.globales.secciones_a[this.ind].p_fnac);
                intent2.putExtra("p_sexo", this.globales.secciones_a[this.ind].p_sexo);
                intent2.putExtra("p_descr", this.globales.secciones_a[this.ind].p_descr);
                intent2.putExtra("p_dist", this.globales.secciones_a[this.ind].p_dist);
                intent2.putExtra("coments_chat", this.globales.secciones_a[this.ind].coments);
                intent2.putExtra("galeria", this.globales.secciones_a[this.ind].galeria);
                intent2.putExtra("privados_chat", this.globales.secciones_a[this.ind].privados);
                intent2.putExtra("fotos_perfil", this.fotos_perfil);
                intent2.putExtra("fotos_chat", 1);
                startActivityForResult(intent2, 0);
            } else if (view.getId() == R.id.tv_likes_n) {
                if (!this.nlikes.equals("0")) {
                    this.dialog_likes = new AlertDialog.Builder(this);
                    this.convertView = getLayoutInflater().inflate(R.layout.likes_list, (ViewGroup) null);
                    if (Build.VERSION.SDK_INT > 20) {
                        config.progress_color((ProgressBar) this.convertView.findViewById(R.id.likes_pb), this.cbtn);
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
                            likes_item likes_item = (likes_item) t_buscvideo.this.listData.get(i);
                            if (!likes_item.es_mas) {
                                String str = likes_item.id;
                                if (!str.equals(t_buscvideo.this.idusu + "")) {
                                    Intent intent = new Intent(t_buscvideo.this, profile.class);
                                    intent.putExtra("id", likes_item.id);
                                    intent.putExtra("privados", likes_item.privados);
                                    intent.putExtra("nombre", likes_item.nombre);
                                    intent.putExtra("coments", likes_item.coments);
                                    intent.putExtra("fnac_d", likes_item.fnac_d);
                                    intent.putExtra("fnac_m", likes_item.fnac_m);
                                    intent.putExtra("fnac_a", likes_item.fnac_a);
                                    intent.putExtra("sexo", likes_item.sexo);
                                    intent.putExtra("vfoto", likes_item.vfoto_bd);
                                    if (t_buscvideo.this.extras.containsKey("desdepriv")) {
                                        intent.putExtra("desdepriv", "1");
                                    }
                                    intent.putExtra("p_fnac", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].p_fnac);
                                    intent.putExtra("p_sexo", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].p_sexo);
                                    intent.putExtra("p_descr", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].p_descr);
                                    intent.putExtra("p_dist", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].p_dist);
                                    intent.putExtra("coments_chat", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].coments);
                                    intent.putExtra("galeria", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].galeria);
                                    intent.putExtra("privados_chat", t_buscvideo.this.globales.secciones_a[t_buscvideo.this.ind].privados);
                                    intent.putExtra("fotos_perfil", t_buscvideo.this.fotos_perfil);
                                    intent.putExtra("fotos_chat", 1);
                                    t_buscvideo.this.startActivityForResult(intent, 0);
                                }
                            } else if (t_buscvideo.this.c_l == null || t_buscvideo.this.c_l.getStatus() != AsyncTask.Status.RUNNING) {
                                t_buscvideo.this.c_l = new cargar_likes();
                                t_buscvideo.this.c_l.execute(new String[0]);
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
            } else if (view.getId() == R.id.iv_like) {
                if (this.liked.equals("0")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Integer.parseInt(this.nlikes) + 1);
                    str = str3;
                    sb2.append(str);
                    this.nlikes = sb2.toString();
                    this.liked = "1";
                    String str5 = this.idusuv;
                    if (!str5.equals(this.idusu + str)) {
                        SharedPreferences sharedPreferences = this.settings;
                        if (!sharedPreferences.contains("usufav_" + this.idusuv)) {
                            SharedPreferences sharedPreferences2 = this.settings;
                            if (!sharedPreferences2.contains("usufav_noactivar_" + this.idusuv)) {
                                SharedPreferences.Editor edit = this.settings.edit();
                                edit.putBoolean("usufav_" + this.idusuv, true);
                                edit.commit();
                            }
                        }
                    }
                    if (this.listData.size() > 0) {
                        String str6 = this.listData.get(0).id;
                        if (!str6.equals(this.idusu + str)) {
                            likes_item likes_item = new likes_item();
                            likes_item.id = this.idusu + str;
                            likes_item.nombre = getResources().getString(R.string.tu);
                            likes_item.t_img = this.globales.getTempFile(this, 1).exists();
                            this.listData.add(0, likes_item);
                            this.itemAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    str = str3;
                    this.nlikes = (Integer.parseInt(this.nlikes) - 1) + str;
                    this.liked = "0";
                    if (this.listData.size() > 0) {
                        String str7 = this.listData.get(0).id;
                        if (str7.equals(this.idusu + str)) {
                            this.listData.remove(0);
                            this.itemAdapter.notifyDataSetChanged();
                        }
                    }
                }
                ((TextView) findViewById(R.id.tv_likes_n)).setText(this.nlikes);
                ((TextView) findViewById(R.id.tv_likes)).setText(this.liked.equals("1") ? getResources().getString(R.string.tegusta) : str);
                new enviar_like().execute(new String[0]);
            } else {
                String str8 = str3;
                if (view.getId() == R.id.iv_reportar) {
                    final AlertDialog create2 = new AlertDialog.Builder(this).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            t_buscvideo.this.findViewById(R.id.iv_reportar).setVisibility(8);
                            t_buscvideo t_buscvideo = t_buscvideo.this;
                            config.mostrar_toast(Toast.makeText(t_buscvideo, t_buscvideo.getResources().getString(R.string.enviando), 0));
                            new enviar_reporte().execute(new String[0]);
                            Intent intent = new Intent();
                            intent.putExtra("elim_video", t_buscvideo.this.idv);
                            intent.putExtra("indv", t_buscvideo.this.indv);
                            t_buscvideo.this.setResult(-1, intent);
                            t_buscvideo.this.finish();
                        }
                    }).setMessage(R.string.confirmar_reportarvideo).create();
                    if (!this.cbtn.equals(str8)) {
                        create2.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create2.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                                Button button2 = create2.getButton(-2);
                                button2.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                            }
                        });
                    }
                    create2.show();
                    ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } else if (view.getId() == R.id.iv_elim) {
                    final AlertDialog create3 = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            t_buscvideo t_buscvideo = t_buscvideo.this;
                            new elim_video(t_buscvideo.idv).execute(new String[0]);
                            Intent intent = new Intent();
                            intent.putExtra("elim_video", t_buscvideo.this.idv);
                            intent.putExtra("indv", t_buscvideo.this.indv);
                            t_buscvideo.this.setResult(-1, intent);
                            t_buscvideo.this.finish();
                        }
                    }).setMessage(R.string.confirmar_elimvideo).create();
                    if (!this.cbtn.equals(str8)) {
                        create3.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create3.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                                Button button2 = create3.getButton(-2);
                                button2.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                            }
                        });
                    }
                    create3.show();
                    ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals(str8)) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals(str8)) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals(str8)) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals(str8)) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals(str8)) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals(str8)) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals(str8)) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(str8))))))))) {
                    abrir_secc(view);
                } else {
                    if (this.globales.appnext_rew_cod != null && !this.globales.appnext_rew_cod.equals(str8)) {
                        this.mAd_appnext = new RewardedVideo((Context) this, this.globales.appnext_rew_cod);
                    }
                    if (this.globales.admob_rew_cod != null) {
                        this.globales.admob_rew_cod.equals(str8);
                    }
                    if (this.globales.fb_rew_cod != null && !this.globales.fb_rew_cod.equals(str8)) {
                        this.mAd_fb = new RewardedVideoAd(this, this.globales.fb_rew_cod);
                    }
                    if (this.globales.st_rew_cod != null && !this.globales.st_rew_cod.equals(str8)) {
                        this.mAd_st = new StartAppAd(this);
                    }
                    this.dialog_cargando = new ProgressDialog(this);
                    this.v_abrir_secc = view2;
                    if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                        abrir_secc(view);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ban_usu(final String str) {
        if (str != null) {
            final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    t_buscvideo.this.ban_usu_2(str, false);
                }
            }).setMessage(R.string.confirmar_elimusu).create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                        Button button2 = create.getButton(-2);
                        if (button2 != null) {
                            button2.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                        }
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ban_usu_2(String str, Boolean bool) {
        if (!bool.booleanValue()) {
            config.mostrar_toast(Toast.makeText(this, getResources().getString(R.string.enviando), 0));
            config.elim_privado(this, str);
            new t_chat.eliminar_usu(str, this.idusu, this.codigo, this).execute(new String[0]);
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putBoolean("ban_" + str, true);
            edit.commit();
        }
        Intent intent = new Intent();
        intent.putExtra("idusu_ban", str);
        setResult(-1, intent);
        this.idusu_ban_glob = str;
        if (str.equals(this.idusuv)) {
            finish();
            return;
        }
        for (int i = 0; i < this.ll_coments.getChildCount(); i++) {
            LinearLayout linearLayout = (LinearLayout) this.ll_coments.getChildAt(i);
            String str2 = (String) linearLayout.findViewById(R.id.iv_usucoment).getTag(R.id.idaux1);
            if (str2 != null && str2.equals(str)) {
                linearLayout.setVisibility(8);
                SharedPreferences.Editor edit2 = this.settings.edit();
                int i2 = i;
                while (i2 < 4) {
                    SharedPreferences sharedPreferences = this.settings;
                    StringBuilder sb = new StringBuilder("idcombv");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append("_");
                    sb.append(this.idv);
                    edit2.putString("idcombv" + i2 + "_" + this.idv, sharedPreferences.getString(sb.toString(), ""));
                    edit2.putString("combv" + i2 + "_" + this.idv, this.settings.getString("combv" + i3 + "_" + this.idv, ""));
                    edit2.putString("combv" + i2 + "_fcrea_" + this.idv, this.settings.getString("combv" + i3 + "_fcrea_" + this.idv, ""));
                    edit2.putString("combv" + i2 + "_idusucrea_" + this.idv, this.settings.getString("combv" + i3 + "_idusucrea_" + this.idv, ""));
                    edit2.putString("combv" + i2 + "_nombre_" + this.idv, this.settings.getString("combv" + i3 + "_nombre_" + this.idv, ""));
                    edit2.putString("combv" + i2 + "_vfoto_" + this.idv, this.settings.getString("combv" + i3 + "_vfoto_" + this.idv, "0"));
                    edit2.putString("combv" + i2 + "_privados_" + this.idv, this.settings.getString("combv" + i3 + "_privados_" + this.idv, "0"));
                    edit2.putString("combv" + i2 + "_fnacd_" + this.idv, this.settings.getString("combv" + i3 + "_fnacd_" + this.idv, "0"));
                    edit2.putString("combv" + i2 + "_fnacm_" + this.idv, this.settings.getString("combv" + i3 + "_fnacm_" + this.idv, "0"));
                    edit2.putString("combv" + i2 + "_fnaca_" + this.idv, this.settings.getString("combv" + i3 + "_fnaca_" + this.idv, "0"));
                    edit2.putString("combv" + i2 + "_sexo_" + this.idv, this.settings.getString("combv" + i3 + "_sexo_" + this.idv, "0"));
                    edit2.putString("combv" + i2 + "_coments_" + this.idv, this.settings.getString("combv" + i3 + "_coments_" + this.idv, "0"));
                    i2 = i3;
                }
                edit2.commit();
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
        if (intent != null && intent.hasExtra("idusu_ban")) {
            ban_usu_2(intent.getStringExtra("idusu_ban"), true);
        } else if (intent == null || !intent.hasExtra("finalizar")) {
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

    private class cargar_anun extends AsyncTask<String, Void, String> {
        private cargar_anun() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r6 = "https://global.appnext.com/offerWallApi.aspx?id="
                r0 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
                r1.<init>(r6)     // Catch:{ Exception -> 0x007b }
                stikerwap.appdys.t_buscvideo r6 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x007b }
                stikerwap.appdys.config r6 = r6.globales     // Catch:{ Exception -> 0x007b }
                java.lang.String r6 = r6.appnext_video_cod     // Catch:{ Exception -> 0x007b }
                r1.append(r6)     // Catch:{ Exception -> 0x007b }
                java.lang.String r6 = "&type=vast&vast_ver=3.0&duration=all&packageId="
                r1.append(r6)     // Catch:{ Exception -> 0x007b }
                stikerwap.appdys.t_buscvideo r6 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x007b }
                java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x007b }
                r1.append(r6)     // Catch:{ Exception -> 0x007b }
                java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x007b }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x007b }
                r1.<init>(r6)     // Catch:{ Exception -> 0x007b }
                java.net.URLConnection r6 = r1.openConnection()     // Catch:{ Exception -> 0x007b }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x007b }
                r0 = 1
                r6.setDoInput(r0)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r6.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r6.setReadTimeout(r0)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.io.InputStream r0 = r6.getInputStream()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r0.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            L_0x004d:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                if (r2 == 0) goto L_0x0068
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r3.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r3.append(r2)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r0.append(r2)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                goto L_0x004d
            L_0x0068:
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                if (r6 == 0) goto L_0x0071
                r6.disconnect()
            L_0x0071:
                return r0
            L_0x0072:
                r0 = move-exception
                goto L_0x0083
            L_0x0074:
                r0 = r6
                goto L_0x007b
            L_0x0076:
                r6 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x0083
            L_0x007b:
                java.lang.String r6 = ""
                if (r0 == 0) goto L_0x0082
                r0.disconnect()
            L_0x0082:
                return r6
            L_0x0083:
                if (r6 == 0) goto L_0x0088
                r6.disconnect()
            L_0x0088:
                goto L_0x008a
            L_0x0089:
                throw r0
            L_0x008a:
                goto L_0x0089
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.cargar_anun.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x008d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.String r0 = "<Ad id="
                boolean r0 = r7.contains(r0)
                r1 = 0
                if (r0 == 0) goto L_0x0058
                java.lang.String r0 = "<Impression><![CDATA["
                int r0 = r7.indexOf(r0)
                r2 = -1
                if (r0 == r2) goto L_0x0058
                int r0 = r0 + 21
                java.lang.String r3 = "]"
                int r4 = r7.indexOf(r3, r0)
                stikerwap.appdys.t_buscvideo r5 = stikerwap.appdys.t_buscvideo.this
                stikerwap.appdys.FullscreenVideoLayout_pro r5 = r5.videoView
                java.lang.String r0 = r7.substring(r0, r4)
                r5.url_imp = r0
                java.lang.String r0 = "<ClickThrough><![CDATA["
                int r0 = r7.indexOf(r0)
                if (r0 == r2) goto L_0x0058
                int r0 = r0 + 23
                int r4 = r7.indexOf(r3, r0)
                stikerwap.appdys.t_buscvideo r5 = stikerwap.appdys.t_buscvideo.this
                stikerwap.appdys.FullscreenVideoLayout_pro r5 = r5.videoView
                java.lang.String r0 = r7.substring(r0, r4)
                r5.url_click = r0
                java.lang.String r0 = "width=\"320\" height=\"180\""
                int r0 = r7.indexOf(r0)
                if (r0 == r2) goto L_0x0058
                java.lang.String r4 = "><![CDATA["
                int r0 = r7.indexOf(r4, r0)
                if (r0 == r2) goto L_0x0058
                int r0 = r0 + 10
                int r2 = r7.indexOf(r3, r0)
                java.lang.String r7 = r7.substring(r0, r2)
                r0 = 1
                goto L_0x005b
            L_0x0058:
                java.lang.String r7 = ""
                r0 = 0
            L_0x005b:
                if (r0 == 0) goto L_0x008d
                android.net.Uri r7 = android.net.Uri.parse(r7)
                stikerwap.appdys.t_buscvideo r0 = stikerwap.appdys.t_buscvideo.this
                r2 = 2131361979(0x7f0a00bb, float:1.8343726E38)
                android.view.View r0 = r0.findViewById(r2)
                stikerwap.appdys.t_buscvideo$cargar_anun$1 r2 = new stikerwap.appdys.t_buscvideo$cargar_anun$1
                r2.<init>()
                r0.setOnClickListener(r2)
                stikerwap.appdys.t_buscvideo r0 = stikerwap.appdys.t_buscvideo.this
                stikerwap.appdys.FullscreenVideoLayout_pro r0 = r0.videoView
                r0.esStream = r1
                stikerwap.appdys.t_buscvideo r0 = stikerwap.appdys.t_buscvideo.this
                stikerwap.appdys.FullscreenVideoLayout_pro r0 = r0.videoView
                r0.hideControls()
                stikerwap.appdys.t_buscvideo r0 = stikerwap.appdys.t_buscvideo.this     // Catch:{ IOException -> 0x0088 }
                stikerwap.appdys.FullscreenVideoLayout_pro r0 = r0.videoView     // Catch:{ IOException -> 0x0088 }
                r1 = 0
                r0.setVideoURI(r7, r1)     // Catch:{ IOException -> 0x0088 }
                goto L_0x0092
            L_0x0088:
                r7 = move-exception
                r7.printStackTrace()
                goto L_0x0092
            L_0x008d:
                stikerwap.appdys.t_buscvideo r7 = stikerwap.appdys.t_buscvideo.this
                r7.empezar_video()
            L_0x0092:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.cargar_anun.onPostExecute(java.lang.String):void");
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

    /* access modifiers changed from: private */
    public void mostrar_likes() {
        TextView textView = (TextView) findViewById(R.id.tv_likes_n);
        findViewById(R.id.tv_likes_n).setBackgroundDrawable(getResources().getDrawable(R.drawable.likes_izq_p));
        textView.setTextColor(config.NEGRO);
        textView.setText(this.nlikes);
        ((TextView) findViewById(R.id.tv_likes)).setText(this.liked.equals("1") ? getResources().getString(R.string.tegusta) : "");
        findViewById(R.id.iv_like).setOnClickListener(this);
        findViewById(R.id.tv_likes_n).setOnClickListener(this);
        findViewById(R.id.ll_likes).setVisibility(0);
    }

    private void f_enviar(boolean z) {
        String trim = ((TextView) findViewById(R.id.et_coment_self)).getText().toString().replace("@", "").trim();
        if (!trim.equals("")) {
            ((TextView) findViewById(R.id.et_coment_self)).setTextColor(-7829368);
            this.pb_enviando.setVisibility(0);
            enviar_coment enviar_coment2 = this.env;
            if (enviar_coment2 == null || enviar_coment2.getStatus() != AsyncTask.Status.RUNNING) {
                enviar_coment enviar_coment3 = new enviar_coment(trim);
                this.env = enviar_coment3;
                enviar_coment3.execute(new String[0]);
            }
        }
    }

    private class enviar_coment extends AsyncTask<String, Void, String> {
        String coment;

        public enviar_coment(String str) {
            this.coment = str;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/enviar_coment_buscvideo.php?idusu=" + t_buscvideo.this.idusu + "&c=" + t_buscvideo.this.codigo + "&idv=" + t_buscvideo.this.idv);
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("m", new StringBody(URLEncoder.encode(this.coment, "UTF-8")));
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
            String str2 = str;
            AlertDialog.Builder builder = new AlertDialog.Builder(t_buscvideo.this);
            try {
                t_buscvideo.this.pb_enviando.setVisibility(8);
                if (!t_buscvideo.this.c1_esclaro) {
                    ((TextView) t_buscvideo.this.findViewById(R.id.et_coment_self)).setTextColor(-1);
                } else {
                    ((TextView) t_buscvideo.this.findViewById(R.id.et_coment_self)).setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
            } catch (Exception unused) {
            }
            if (str2.indexOf("ANDROID:OK ID:") != -1) {
                int indexOf = str2.indexOf("ANDROID:OK ID:") + 14;
                String substring = str2.substring(indexOf, str2.indexOf("-", indexOf));
                ((EditText) t_buscvideo.this.findViewById(R.id.et_coment_self)).setText("");
                String convertir_fecha_inv = config.convertir_fecha_inv(new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
                t_buscvideo.this.mostrar_coment(false, true, substring, t_buscvideo.this.idusu + "", t_buscvideo.this.getResources().getString(R.string.tu), convertir_fecha_inv, this.coment, "0", "", "", "", "", "", "");
                SharedPreferences.Editor edit = t_buscvideo.this.settings.edit();
                for (int i = 3; i > 0; i += -1) {
                    SharedPreferences sharedPreferences = t_buscvideo.this.settings;
                    StringBuilder sb = new StringBuilder("idcombv");
                    int i2 = i - 1;
                    sb.append(i2);
                    sb.append("_");
                    sb.append(t_buscvideo.this.idv);
                    edit.putString("idcombv" + i + "_" + t_buscvideo.this.idv, sharedPreferences.getString(sb.toString(), ""));
                    edit.putString("combv" + i + "_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_" + t_buscvideo.this.idv, ""));
                    edit.putString("combv" + i + "_fcrea_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fcrea_" + t_buscvideo.this.idv, ""));
                    edit.putString("combv" + i + "_idusucrea_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_idusucrea_" + t_buscvideo.this.idv, ""));
                    edit.putString("combv" + i + "_nombre_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_nombre_" + t_buscvideo.this.idv, ""));
                    edit.putString("combv" + i + "_vfoto_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_vfoto_" + t_buscvideo.this.idv, "0"));
                    edit.putString("combv" + i + "_privados_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_privados_" + t_buscvideo.this.idv, "0"));
                    edit.putString("combv" + i + "_fnacd_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fnacd_" + t_buscvideo.this.idv, "0"));
                    edit.putString("combv" + i + "_fnacm_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fnacm_" + t_buscvideo.this.idv, "0"));
                    edit.putString("combv" + i + "_fnaca_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_fnaca_" + t_buscvideo.this.idv, "0"));
                    edit.putString("combv" + i + "_sexo_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_sexo_" + t_buscvideo.this.idv, "0"));
                    edit.putString("combv" + i + "_coments_" + t_buscvideo.this.idv, t_buscvideo.this.settings.getString("combv" + i2 + "_coments_" + t_buscvideo.this.idv, "0"));
                }
                edit.putString("idcombv0_" + t_buscvideo.this.idv, substring);
                edit.putString("combv0_" + t_buscvideo.this.idv, this.coment);
                edit.putString("combv0_fcrea_" + t_buscvideo.this.idv, convertir_fecha_inv);
                edit.putString("combv0_idusucrea_" + t_buscvideo.this.idv, t_buscvideo.this.idusu + "");
                StringBuilder sb2 = new StringBuilder("combv0_nombre_");
                sb2.append(t_buscvideo.this.idv);
                edit.putString(sb2.toString(), t_buscvideo.this.getResources().getString(R.string.tu));
                edit.putString("combv0_vfoto_" + t_buscvideo.this.idv, "0");
                edit.commit();
                try {
                    t_buscvideo.this.findViewById(R.id.sc_pro).post(new Runnable() {
                        public void run() {
                            try {
                                ((ScrollView) t_buscvideo.this.findViewById(R.id.sc_pro)).smoothScrollTo(0, t_buscvideo.this.findViewById(R.id.tv_coments).getTop());
                            } catch (Exception unused) {
                            }
                        }
                    });
                } catch (Exception unused2) {
                }
            } else if (str2.indexOf("ANDROID:KO MOTIVO:NOADMITE") != -1) {
                final AlertDialog create = builder.setCancelable(false).setPositiveButton(t_buscvideo.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.noadmitecoments).create();
                if (!t_buscvideo.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                        }
                    });
                }
                create.show();
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                final AlertDialog create2 = builder.setCancelable(false).setPositiveButton(t_buscvideo.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
                if (!t_buscvideo.this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + t_buscvideo.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    private class cargar_coments extends AsyncTask<String, Void, String> {
        boolean es_inicial;

        cargar_coments(boolean z) {
            this.es_inicial = z;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_buscvideo.this.findViewById(R.id.fl_mascoments).setVisibility(8);
            if (t_buscvideo.this.c1_esclaro) {
                t_buscvideo.this.findViewById(R.id.pb_mascoments_inv).setVisibility(0);
            } else {
                t_buscvideo.this.findViewById(R.id.pb_mascoments).setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                stikerwap.appdys.t_buscvideo r7 = stikerwap.appdys.t_buscvideo.this
                java.lang.String r7 = r7.idcoment_ult
                boolean r0 = r6.es_inicial
                java.lang.String r1 = "0"
                if (r0 == 0) goto L_0x000f
                java.lang.String r7 = "1"
                r5 = r1
                r1 = r7
                r7 = r5
            L_0x000f:
                r0 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
                r2.<init>()     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00b1 }
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = "/srv/coments_buscvideo.php?idusu="
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_buscvideo r3 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x00b1 }
                long r3 = r3.idusu     // Catch:{ Exception -> 0x00b1 }
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = "&c="
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_buscvideo r3 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = r3.codigo     // Catch:{ Exception -> 0x00b1 }
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = "&idv="
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_buscvideo r3 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = r3.idv     // Catch:{ Exception -> 0x00b1 }
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r3 = "&idc="
                r2.append(r3)     // Catch:{ Exception -> 0x00b1 }
                r2.append(r7)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r7 = "&es_ini="
                r2.append(r7)     // Catch:{ Exception -> 0x00b1 }
                r2.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x00b1 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b1 }
                r1.<init>(r7)     // Catch:{ Exception -> 0x00b1 }
                java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x00b1 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00b1 }
                r0 = 1
                r7.setDoInput(r0)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r7.setReadTimeout(r0)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r0 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r7.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStream r0 = r7.getInputStream()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r0.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            L_0x0083:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r2 == 0) goto L_0x009e
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r0.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                goto L_0x0083
            L_0x009e:
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r7 == 0) goto L_0x00a7
                r7.disconnect()
            L_0x00a7:
                return r0
            L_0x00a8:
                r0 = move-exception
                goto L_0x00b9
            L_0x00aa:
                r0 = r7
                goto L_0x00b1
            L_0x00ac:
                r7 = move-exception
                r5 = r0
                r0 = r7
                r7 = r5
                goto L_0x00b9
            L_0x00b1:
                java.lang.String r7 = ""
                if (r0 == 0) goto L_0x00b8
                r0.disconnect()
            L_0x00b8:
                return r7
            L_0x00b9:
                if (r7 == 0) goto L_0x00be
                r7.disconnect()
            L_0x00be:
                goto L_0x00c0
            L_0x00bf:
                throw r0
            L_0x00c0:
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.cargar_coments.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String[] strArr;
            String str2;
            int i;
            int i2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13 = str;
            try {
                t_buscvideo.this.findViewById(R.id.pb_mascoments).setVisibility(8);
                t_buscvideo.this.findViewById(R.id.pb_mascoments_inv).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str13.contains("ANDROID:OK DATOS:")) {
                int indexOf = str13.indexOf("DATOS:") + 6;
                String substring = str13.substring(indexOf, str13.indexOf(";", indexOf));
                String str14 = ",";
                String[] split = substring.split(str14);
                boolean z = this.es_inicial;
                String str15 = "N";
                String str16 = ExifInterface.LATITUDE_SOUTH;
                String str17 = "-";
                if (!z) {
                    strArr = split;
                    String str18 = str15;
                    String str19 = str16;
                    String str20 = str17;
                    String str21 = str14;
                    int i3 = 0;
                    while (true) {
                        str2 = str19;
                        if (strArr[i].equals(str2)) {
                            break;
                        }
                        String str22 = str18;
                        if (strArr[i].equals(str22)) {
                            break;
                        }
                        String[] split2 = strArr[i].split(str20);
                        String replace = split2[1].replace("@X@", str20).replace("@Y@", str21);
                        t_buscvideo.this.mostrar_coment(false, false, split2[0], split2[3], split2[4], split2[2], replace, split2[5], split2[6], split2[7], split2[8], split2[9], split2[10], split2[11]);
                        i3 = i + 1;
                        str19 = str2;
                        str18 = str22;
                    }
                } else {
                    SharedPreferences.Editor edit = t_buscvideo.this.settings.edit();
                    int i4 = 0;
                    while (true) {
                        str3 = "_sexo_";
                        str4 = "_fnaca_";
                        str5 = "_fnacm_";
                        str6 = str14;
                        str7 = "_fcrea_";
                        str8 = str17;
                        str9 = "idcombv";
                        str10 = str15;
                        str11 = "_";
                        str12 = str16;
                        strArr = split;
                        if (i4 >= 4) {
                            break;
                        }
                        edit.remove(str9 + i4 + str11 + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + str11 + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + str7 + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + "_idusucrea_" + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + "_nombre_" + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + "_vfoto_" + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + "_privados_" + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + "_fnacd_" + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + str5 + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + str4 + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + str3 + t_buscvideo.this.idv);
                        edit.remove("combv" + i4 + "_coments_" + t_buscvideo.this.idv);
                        i4++;
                        str14 = str6;
                        str17 = str8;
                        str15 = str10;
                        str16 = str12;
                        split = strArr;
                    }
                    i = 0;
                    while (true) {
                        String str23 = str3;
                        String str24 = str12;
                        if (strArr[i].equals(str24)) {
                            str12 = str24;
                            break;
                        }
                        str12 = str24;
                        String str25 = str10;
                        if (strArr[i].equals(str25)) {
                            break;
                        }
                        str10 = str25;
                        String str26 = str8;
                        String[] split3 = strArr[i].split(str26);
                        String str27 = str4;
                        StringBuilder sb = new StringBuilder(str9);
                        sb.append(i);
                        sb.append(str11);
                        String str28 = str9;
                        sb.append(t_buscvideo.this.idv);
                        String str29 = str5;
                        edit.putString(sb.toString(), split3[0]);
                        String str30 = str11;
                        String str31 = str6;
                        edit.putString("combv" + i + str11 + t_buscvideo.this.idv, split3[1].replace("@X@", str26).replace("@Y@", str31));
                        edit.putString("combv" + i + str7 + t_buscvideo.this.idv, split3[2]);
                        edit.putString("combv" + i + "_idusucrea_" + t_buscvideo.this.idv, split3[3]);
                        edit.putString("combv" + i + "_nombre_" + t_buscvideo.this.idv, split3[4]);
                        edit.putString("combv" + i + "_vfoto_" + t_buscvideo.this.idv, split3[5]);
                        edit.putString("combv" + i + "_privados_" + t_buscvideo.this.idv, split3[6]);
                        edit.putString("combv" + i + "_fnacd_" + t_buscvideo.this.idv, split3[7]);
                        StringBuilder sb2 = new StringBuilder("combv");
                        sb2.append(i);
                        String str32 = str29;
                        sb2.append(str32);
                        sb2.append(t_buscvideo.this.idv);
                        edit.putString(sb2.toString(), split3[8]);
                        edit.putString("combv" + i + str27 + t_buscvideo.this.idv, split3[9]);
                        StringBuilder sb3 = new StringBuilder("combv");
                        sb3.append(i);
                        String str33 = str23;
                        sb3.append(str33);
                        sb3.append(t_buscvideo.this.idv);
                        edit.putString(sb3.toString(), split3[10]);
                        edit.putString("combv" + i + "_coments_" + t_buscvideo.this.idv, split3[11]);
                        i++;
                        str5 = str32;
                        str7 = str7;
                        str9 = str28;
                        str6 = str31;
                        str11 = str30;
                        String str34 = str27;
                        str8 = str26;
                        str3 = str33;
                        str4 = str34;
                    }
                    edit.commit();
                    t_buscvideo.this.mostrar_coments(false);
                    str2 = str12;
                }
                if (t_buscvideo.this.c_f == null || t_buscvideo.this.c_f.getStatus() != AsyncTask.Status.RUNNING) {
                    t_buscvideo.this.c_f = new cargar_fotoscoments();
                    i2 = 0;
                    t_buscvideo.this.c_f.execute(new String[0]);
                } else {
                    i2 = 0;
                }
                if (strArr[i].equals(str2)) {
                    t_buscvideo.this.findViewById(R.id.fl_mascoments).setVisibility(i2);
                }
                if (this.es_inicial && !t_buscvideo.this.extras.containsKey("nlikes")) {
                    t_buscvideo.this.nlikes = strArr[i + 1];
                    t_buscvideo.this.liked = strArr[i + 2];
                    t_buscvideo.this.mostrar_likes();
                }
            }
        }
    }

    private class cargar_fotoscoments extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idusu_acargar;
        String vfoto_bd;

        private cargar_fotoscoments() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            for (int i = 0; i < t_buscvideo.this.ll_coments.getChildCount(); i++) {
                LinearLayout linearLayout = (LinearLayout) t_buscvideo.this.ll_coments.getChildAt(i);
                String str = (String) linearLayout.findViewById(R.id.iv_usucoment).getTag(R.id.idaux1);
                String str2 = (String) linearLayout.findViewById(R.id.iv_usucoment).getTag(R.id.idaux2);
                this.vfoto_bd = str2;
                if (str2 != null && !str2.equals("0")) {
                    String str3 = this.vfoto_bd;
                    SharedPreferences sharedPreferences = t_buscvideo.this.settings;
                    if (!str3.equals(sharedPreferences.getString("fperfil_" + str, "0"))) {
                        this.idusu_acargar = str;
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                java.lang.String r0 = "fperfil_"
                java.lang.String r1 = r4.idusu_acargar
                if (r1 != 0) goto L_0x000b
                java.lang.String r5 = "-1"
                return r5
            L_0x000b:
                java.net.URL r1 = new java.net.URL     // Catch:{  }
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
                java.lang.String r3 = r4.vfoto_bd     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r1.setReadTimeout(r2)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ MalformedURLException -> 0x0085 }
                r4.bmImg = r3     // Catch:{ MalformedURLException -> 0x0085 }
                r2.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                java.io.File r1 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_buscvideo r2 = stikerwap.appdys.t_buscvideo.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r4.idusu_acargar     // Catch:{  }
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = ".jpg"
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = r3.toString()     // Catch:{  }
                r1.<init>(r2, r0)     // Catch:{  }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                android.graphics.Bitmap r1 = r4.bmImg     // Catch:{  }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r3 = 70
                r1.compress(r2, r3, r0)     // Catch:{  }
                java.lang.String r5 = "1"
            L_0x0085:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.cargar_fotoscoments.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (t_buscvideo.this.ll_coments != null && this.idusu_acargar != null && !str.equals("-1")) {
                if (str == "1") {
                    SharedPreferences.Editor edit = t_buscvideo.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, this.vfoto_bd);
                    edit.commit();
                }
                int childCount = t_buscvideo.this.ll_coments.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    String str2 = (String) t_buscvideo.this.ll_coments.getChildAt(i).findViewById(R.id.iv_usucoment).getTag(R.id.idaux1);
                    if (str2 != null && str2.equals(this.idusu_acargar)) {
                        t_buscvideo.this.ll_coments.getChildAt(i).findViewById(R.id.iv_usucoment).setTag(R.id.idaux2, this.vfoto_bd);
                        if (str == "1") {
                            ((ImageView) t_buscvideo.this.ll_coments.getChildAt(i).findViewById(R.id.iv_usucoment)).setImageBitmap(this.bmImg);
                        }
                    }
                }
                new cargar_fotoscoments().execute(new String[0]);
            }
        }
    }

    private class elim_coment extends AsyncTask<String, Void, Byte> {
        String idcoment;

        elim_coment(String str) {
            this.idcoment = str;
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
                java.lang.String r1 = "/srv/eliminar_coment_buscvideo.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x0084 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&idc="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r5.idcoment     // Catch:{ Exception -> 0x0084 }
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.elim_coment.doInBackground(java.lang.String[]):java.lang.Byte");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00b8, code lost:
        if (r5.equals(r6.toString()) != false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0320  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mostrar_coment(java.lang.Boolean r20, java.lang.Boolean r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            r19 = this;
            r0 = r19
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r27
            java.lang.String r5 = "fperfil_"
            java.lang.String r6 = "layout_inflater"
            java.lang.Object r6 = r0.getSystemService(r6)
            android.view.LayoutInflater r6 = (android.view.LayoutInflater) r6
            r7 = 2131558478(0x7f0d004e, float:1.8742273E38)
            r8 = 0
            android.view.View r6 = r6.inflate(r7, r8)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r7 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r6.setTag(r7, r1)
            r8 = 2131362514(0x7f0a02d2, float:1.834481E38)
            android.view.View r8 = r6.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r9 = 2131363454(0x7f0a067e, float:1.8346717E38)
            android.view.View r9 = r6.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131363416(0x7f0a0658, float:1.834664E38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131363400(0x7f0a0648, float:1.8346608E38)
            android.view.View r11 = r6.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131362446(0x7f0a028e, float:1.8344673E38)
            android.view.View r12 = r6.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r13 = 2131362500(0x7f0a02c4, float:1.8344782E38)
            android.view.View r13 = r6.findViewById(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            boolean r14 = r0.c1_esclaro
            if (r14 == 0) goto L_0x006e
            int r14 = stikerwap.appdys.config.NEGRO
            r9.setTextColor(r14)
            int r14 = stikerwap.appdys.config.GRIS_OSCURO
            r10.setTextColor(r14)
            int r14 = stikerwap.appdys.config.NEGRO
            r11.setTextColor(r14)
            goto L_0x007a
        L_0x006e:
            r14 = -1
            r9.setTextColor(r14)
            int r15 = stikerwap.appdys.config.GRIS_CLARO
            r10.setTextColor(r15)
            r11.setTextColor(r14)
        L_0x007a:
            boolean r14 = r20.booleanValue()
            r15 = 0
            java.lang.String r7 = ""
            if (r14 != 0) goto L_0x00d7
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r16 = r5
            r17 = r6
            long r5 = r0.idusu
            r14.append(r5)
            r14.append(r7)
            java.lang.String r5 = r14.toString()
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00bb
            java.lang.String r5 = r0.idusuv
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r14 = r10
            r18 = r11
            long r10 = r0.idusu
            r6.append(r10)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00de
            goto L_0x00be
        L_0x00bb:
            r14 = r10
            r18 = r11
        L_0x00be:
            boolean r5 = r0.c1_esclaro
            if (r5 == 0) goto L_0x00d0
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131231068(0x7f08015c, float:1.8078207E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            r12.setImageDrawable(r5)
        L_0x00d0:
            r12.setOnClickListener(r0)
            r12.setVisibility(r15)
            goto L_0x00f6
        L_0x00d7:
            r16 = r5
            r17 = r6
            r14 = r10
            r18 = r11
        L_0x00de:
            boolean r5 = r0.c1_esclaro
            if (r5 == 0) goto L_0x00f0
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131231710(0x7f0803de, float:1.8079509E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            r13.setImageDrawable(r5)
        L_0x00f0:
            r13.setOnClickListener(r0)
            r13.setVisibility(r15)
        L_0x00f6:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r10 = r0.idusu
            r5.append(r10)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L_0x011c
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131886857(0x7f120309, float:1.9408305E38)
            java.lang.String r5 = r5.getString(r6)
            r9.setText(r5)
            goto L_0x011f
        L_0x011c:
            r9.setText(r3)
        L_0x011f:
            java.lang.String r5 = stikerwap.appdys.config.convertir_fecha(r25)
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat
            java.lang.String r9 = "ddMMyyHHmm"
            r6.<init>(r9)
            r9 = 1
            java.text.DateFormat r10 = android.text.format.DateFormat.getDateFormat(r19)     // Catch:{ Exception -> 0x019e }
            java.text.DateFormat r11 = android.text.format.DateFormat.getTimeFormat(r19)     // Catch:{ Exception -> 0x019e }
            java.util.Date r5 = r6.parse(r5)     // Catch:{ Exception -> 0x019e }
            java.util.Calendar r6 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x019e }
            java.util.Calendar r12 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x019e }
            r12.setTime(r5)     // Catch:{ Exception -> 0x019e }
            int r13 = r12.get(r9)     // Catch:{ Exception -> 0x019e }
            int r15 = r6.get(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r9 = " "
            if (r13 != r15) goto L_0x017f
            r13 = 6
            int r12 = r12.get(r13)     // Catch:{ Exception -> 0x019e }
            int r6 = r6.get(r13)     // Catch:{ Exception -> 0x019e }
            if (r12 != r6) goto L_0x017f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019e }
            r6.<init>()     // Catch:{ Exception -> 0x019e }
            android.content.res.Resources r10 = r19.getResources()     // Catch:{ Exception -> 0x019e }
            r12 = 2131886471(0x7f120187, float:1.9407522E38)
            java.lang.String r10 = r10.getString(r12)     // Catch:{ Exception -> 0x019e }
            r6.append(r10)     // Catch:{ Exception -> 0x019e }
            r6.append(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r11.format(r5)     // Catch:{ Exception -> 0x019e }
            r6.append(r5)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x019e }
            r6 = r14
            r6.setText(r5)     // Catch:{ Exception -> 0x019e }
            goto L_0x019f
        L_0x017f:
            r6 = r14
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019e }
            r12.<init>()     // Catch:{ Exception -> 0x019e }
            java.lang.String r10 = r10.format(r5)     // Catch:{ Exception -> 0x019e }
            r12.append(r10)     // Catch:{ Exception -> 0x019e }
            r12.append(r9)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r11.format(r5)     // Catch:{ Exception -> 0x019e }
            r12.append(r5)     // Catch:{ Exception -> 0x019e }
            java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x019e }
            r6.setText(r5)     // Catch:{ Exception -> 0x019e }
            goto L_0x019f
        L_0x019e:
        L_0x019f:
            r5 = r26
            r11 = r18
            r11.setText(r5)
            r5 = 2131362376(0x7f0a0248, float:1.834453E38)
            r8.setTag(r5, r2)
            int r6 = r0.fotos_perfil
            if (r6 <= 0) goto L_0x02a8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            long r9 = r0.idusu
            r6.append(r9)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r6 = r2.equals(r6)
            java.lang.String r9 = "0"
            if (r6 == 0) goto L_0x01d6
            r6 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r8.setTag(r6, r9)
            android.graphics.Bitmap r9 = r0.bm_propia
            r8.setImageBitmap(r9)
            goto L_0x02ad
        L_0x01d6:
            r6 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r8.setTag(r6, r4)
            boolean r6 = r4.equals(r9)
            r9 = 2131231689(0x7f0803c9, float:1.8079466E38)
            r10 = 2131231691(0x7f0803cb, float:1.807947E38)
            if (r6 == 0) goto L_0x0206
            boolean r6 = r0.c1_esclaro
            if (r6 == 0) goto L_0x01f9
            android.content.res.Resources r6 = r19.getResources()
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r9)
            r8.setImageDrawable(r6)
            goto L_0x02ad
        L_0x01f9:
            android.content.res.Resources r6 = r19.getResources()
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r10)
            r8.setImageDrawable(r6)
            goto L_0x02ad
        L_0x0206:
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            java.io.File r11 = r0.path     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r13 = r16
            r12.<init>(r13)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r12.append(r2)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            java.lang.String r13 = ".jpg"
            r12.append(r13)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r6.<init>(r11, r12)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.graphics.BitmapFactory$Options r11 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r11.<init>()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r12 = 1
            r11.inJustDecodeBounds = r12     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            java.lang.String r13 = r6.getPath()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.graphics.BitmapFactory.decodeFile(r13, r11)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            int r13 = r11.outWidth     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.content.res.Resources r13 = r19.getResources()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.util.DisplayMetrics r13 = r13.getDisplayMetrics()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            float r13 = r13.density     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r14 = 1111490560(0x42400000, float:48.0)
            float r13 = r13 * r14
            r15 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 + r15
            int r13 = (int) r13     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.content.res.Resources r16 = r19.getResources()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.util.DisplayMetrics r12 = r16.getDisplayMetrics()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            float r12 = r12.density     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            float r12 = r12 * r14
            float r12 = r12 + r15
            int r12 = (int) r12     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            int r14 = r11.outWidth     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            int r11 = r11.outHeight     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            if (r14 > r13) goto L_0x025b
            if (r11 > r12) goto L_0x025b
            r15 = 1
            goto L_0x025c
        L_0x025b:
            r15 = 0
        L_0x025c:
            if (r15 != 0) goto L_0x0279
            int r11 = stikerwap.appdys.config.calculateNewWidth(r14, r11, r13, r12)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            float r12 = (float) r14     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            float r11 = (float) r11     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            float r12 = r12 / r11
            int r11 = java.lang.Math.round(r12)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.graphics.BitmapFactory$Options r12 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r12.<init>()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            r12.inSampleSize = r11     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r12)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            goto L_0x0285
        L_0x0279:
            android.content.ContentResolver r11 = r19.getContentResolver()     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            android.graphics.Bitmap r6 = android.provider.MediaStore.Images.Media.getBitmap(r11, r6)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
        L_0x0285:
            r8.setImageBitmap(r6)     // Catch:{ Exception -> 0x028b, OutOfMemoryError -> 0x0289 }
            goto L_0x02ad
        L_0x0289:
            goto L_0x02ad
        L_0x028b:
            boolean r6 = r0.c1_esclaro
            if (r6 == 0) goto L_0x029c
            android.content.res.Resources r6 = r19.getResources()
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r9)
            r8.setImageDrawable(r6)
            goto L_0x02ad
        L_0x029c:
            android.content.res.Resources r6 = r19.getResources()
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r10)
            r8.setImageDrawable(r6)
            goto L_0x02ad
        L_0x02a8:
            r6 = 8
            r8.setVisibility(r6)
        L_0x02ad:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            long r8 = r0.idusu
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r6 = r2.equals(r6)
            if (r6 != 0) goto L_0x0311
            java.lang.String r6 = "ESCOMENT"
            r7 = r17
            r7.setTag(r5, r6)
            r5 = 2131362378(0x7f0a024a, float:1.8344535E38)
            r7.setTag(r5, r2)
            r2 = 2131362379(0x7f0a024b, float:1.8344537E38)
            r7.setTag(r2, r3)
            r2 = 2131362380(0x7f0a024c, float:1.8344539E38)
            r7.setTag(r2, r4)
            r2 = 2131362381(0x7f0a024d, float:1.834454E38)
            r3 = r28
            r7.setTag(r2, r3)
            r2 = 2131362382(0x7f0a024e, float:1.8344543E38)
            r3 = r29
            r7.setTag(r2, r3)
            r2 = 2131362383(0x7f0a024f, float:1.8344545E38)
            r3 = r30
            r7.setTag(r2, r3)
            r2 = 2131362384(0x7f0a0250, float:1.8344547E38)
            r3 = r31
            r7.setTag(r2, r3)
            r2 = 2131362385(0x7f0a0251, float:1.834455E38)
            r3 = r32
            r7.setTag(r2, r3)
            r2 = 2131362377(0x7f0a0249, float:1.8344533E38)
            r3 = r33
            r7.setTag(r2, r3)
            r7.setOnClickListener(r0)
            goto L_0x0313
        L_0x0311:
            r7 = r17
        L_0x0313:
            boolean r2 = r21.booleanValue()
            if (r2 == 0) goto L_0x0320
            android.widget.LinearLayout r2 = r0.ll_coments
            r3 = 0
            r2.addView(r7, r3)
            goto L_0x0325
        L_0x0320:
            android.widget.LinearLayout r2 = r0.ll_coments
            r2.addView(r7)
        L_0x0325:
            r0.idcoment_ult = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.mostrar_coment(java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void mostrar_coments(boolean z) {
        int i;
        this.ll_coments.removeAllViews();
        boolean z2 = false;
        int i2 = 0;
        while (i2 < 4) {
            SharedPreferences sharedPreferences = this.settings;
            if (!sharedPreferences.getString("idcombv" + i2 + "_" + this.idv, "").equals("")) {
                SharedPreferences sharedPreferences2 = this.settings;
                String string = sharedPreferences2.getString("combv" + i2 + "_idusucrea_" + this.idv, "");
                if (!string.equals("")) {
                    SharedPreferences sharedPreferences3 = this.settings;
                    if (sharedPreferences3.getBoolean("ban_" + string, z2)) {
                        i = i2;
                        i2 = i + 1;
                        z2 = false;
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                Boolean valueOf2 = Boolean.valueOf(z2);
                SharedPreferences sharedPreferences4 = this.settings;
                String string2 = sharedPreferences4.getString("idcombv" + i2 + "_" + this.idv, "");
                SharedPreferences sharedPreferences5 = this.settings;
                String string3 = sharedPreferences5.getString("combv" + i2 + "_idusucrea_" + this.idv, "");
                SharedPreferences sharedPreferences6 = this.settings;
                String string4 = sharedPreferences6.getString("combv" + i2 + "_nombre_" + this.idv, "");
                SharedPreferences sharedPreferences7 = this.settings;
                String string5 = sharedPreferences7.getString("combv" + i2 + "_fcrea_" + this.idv, "");
                SharedPreferences sharedPreferences8 = this.settings;
                String string6 = sharedPreferences8.getString("combv" + i2 + "_" + this.idv, "");
                SharedPreferences sharedPreferences9 = this.settings;
                String string7 = sharedPreferences9.getString("combv" + i2 + "_vfoto_" + this.idv, "");
                SharedPreferences sharedPreferences10 = this.settings;
                String string8 = sharedPreferences10.getString("combv" + i2 + "_privados_" + this.idv, "");
                SharedPreferences sharedPreferences11 = this.settings;
                String string9 = sharedPreferences11.getString("combv" + i2 + "_fnacd_" + this.idv, "");
                SharedPreferences sharedPreferences12 = this.settings;
                String string10 = sharedPreferences12.getString("combv" + i2 + "_fnacm_" + this.idv, "");
                SharedPreferences sharedPreferences13 = this.settings;
                String string11 = sharedPreferences13.getString("combv" + i2 + "_fnaca_" + this.idv, "");
                SharedPreferences sharedPreferences14 = this.settings;
                String string12 = sharedPreferences14.getString("combv" + i2 + "_sexo_" + this.idv, "");
                SharedPreferences sharedPreferences15 = this.settings;
                i = i2;
                mostrar_coment(valueOf, valueOf2, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, sharedPreferences15.getString("combv" + i2 + "_coments_" + this.idv, ""));
                i2 = i + 1;
                z2 = false;
            } else {
                return;
            }
        }
    }

    private class enviar_visto extends AsyncTask<String, Void, String> {
        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
        }

        private enviar_visto() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/buscvideo_visto.php?idusu=" + t_buscvideo.this.idusu + "&c=" + t_buscvideo.this.codigo + "&idv=" + t_buscvideo.this.idv);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
                return "1";
            } catch (Exception unused) {
                return "ANDROID:KO";
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
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/like_buscvideo.php?idusu=" + t_buscvideo.this.idusu + "&c=" + t_buscvideo.this.codigo + "&idv=" + t_buscvideo.this.idv + "&modo=" + t_buscvideo.this.liked);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
                return "1";
            } catch (Exception unused) {
                return "ANDROID:KO";
            }
        }
    }

    private class elim_video extends AsyncTask<String, Void, Byte> {
        String idvideo;

        elim_video(String str) {
            this.idvideo = str;
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
                java.lang.String r1 = "/srv/eliminar_buscvideo.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x0084 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x0084 }
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = "&idv="
                r0.append(r1)     // Catch:{ Exception -> 0x0084 }
                java.lang.String r1 = r5.idvideo     // Catch:{ Exception -> 0x0084 }
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.elim_video.doInBackground(java.lang.String[]):java.lang.Byte");
        }
    }

    private class cargar_likes extends AsyncTask<String, Void, String> {
        private cargar_likes() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_buscvideo.this.convertView.findViewById(R.id.likes_pb).setVisibility(0);
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
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x009e }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&id_buscvideo="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = r1.idv     // Catch:{ Exception -> 0x009e }
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                java.lang.String r1 = "&n="
                r0.append(r1)     // Catch:{ Exception -> 0x009e }
                stikerwap.appdys.t_buscvideo r1 = stikerwap.appdys.t_buscvideo.this     // Catch:{ Exception -> 0x009e }
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideo.cargar_likes.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            try {
                t_buscvideo.this.convertView.findViewById(R.id.likes_pb).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                int indexOf = str.indexOf("DATOS:") + 6;
                String[] split = str.substring(indexOf, str.indexOf(";", indexOf)).split(",");
                if (t_buscvideo.this.listData.size() == 0) {
                    if (t_buscvideo.this.liked.equals("1")) {
                        likes_item likes_item = new likes_item();
                        likes_item.id = t_buscvideo.this.idusu + "";
                        likes_item.nombre = t_buscvideo.this.getResources().getString(R.string.tu);
                        likes_item.t_img = t_buscvideo.this.globales.getTempFile(t_buscvideo.this, 1).exists();
                        t_buscvideo.this.listData.add(likes_item);
                    }
                } else if (((likes_item) t_buscvideo.this.listData.get(t_buscvideo.this.listData.size() - 1)).es_mas) {
                    t_buscvideo.this.listData.remove(t_buscvideo.this.listData.size() - 1);
                }
                int i = 0;
                while (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                    String[] split2 = split[i].split("-");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= t_buscvideo.this.listData.size()) {
                            z = false;
                            break;
                        } else if (((likes_item) t_buscvideo.this.listData.get(i2)).id.equals(split2[0])) {
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
                        t_buscvideo.this.listData.add(likes_item2);
                        t_buscvideo.this.n_cargados++;
                    }
                    i++;
                }
                if (split[i].equals(ExifInterface.LATITUDE_SOUTH)) {
                    likes_item likes_item3 = new likes_item();
                    likes_item3.es_mas = true;
                    t_buscvideo.this.listData.add(likes_item3);
                }
                t_buscvideo.this.itemAdapter.notifyDataSetChanged();
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
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/reportar_buscvideo.php?idusu=" + t_buscvideo.this.idusu + "&c=" + t_buscvideo.this.codigo + "&idv=" + t_buscvideo.this.idv);
                httpPost.setEntity(new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
                return "1";
            } catch (Exception unused) {
                return "ANDROID:KO";
            }
        }
    }

    public void fcerrar(Boolean bool) {
        Intent intent = new Intent();
        intent.putExtra("nlikesv", this.nlikes);
        intent.putExtra("liked", this.liked);
        intent.putExtra("idv", this.idv);
        if (bool.booleanValue()) {
            intent.putExtra("idusu_abrir", this.idusuv);
            intent.putExtra("nombreusu_abrir", this.nombre);
        } else {
            intent.putExtra("idusu_abrir", "");
        }
        String str = this.idusu_ban_glob;
        if (str != null) {
            intent.putExtra("idusu_ban", str);
        }
        setResult(-1, intent);
        finish();
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
        this.stopPosition = this.videoView.getCurrentPosition();
        this.videoView.pause();
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
        FullscreenVideoLayout_pro fullscreenVideoLayout_pro = this.videoView;
        if (fullscreenVideoLayout_pro != null && fullscreenVideoLayout_pro.videoIsReady) {
            this.videoView.seekTo(this.stopPosition);
            this.videoView.start();
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

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        if (this.globales.tipomenu == 1) {
            ((ImageView) findViewById(R.id.iv_drawer)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((DrawerLayout) ((Activity) view.getContext()).findViewById(R.id.drawer_layout)).openDrawer(8388611);
                }
            });
            ((ImageView) findViewById(R.id.icohome)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((DrawerLayout) ((Activity) view.getContext()).findViewById(R.id.drawer_layout)).openDrawer(8388611);
                }
            });
        }
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
        if (configuration.orientation == 2) {
            if (!this.videoView.isFullscreen()) {
                this.videoView.setFullscreen(true);
            } else {
                this.videoView.resize();
            }
        } else if (this.videoView.isFullscreen()) {
            this.videoView.setFullscreen(false);
        } else {
            this.videoView.resize();
        }
    }

    public void onBackPressed() {
        if (this.videoView.isFullscreen()) {
            this.videoView.setFullscreen(false);
        } else if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            fcerrar(false);
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
                if (!t_buscvideo.this.globales.admob_rew_failed(context, t_buscvideo.this.mAd_appnext)) {
                    t_buscvideo.this.dialog_cargando.cancel();
                    t_buscvideo t_buscvideo = t_buscvideo.this;
                    t_buscvideo.abrir_secc(t_buscvideo.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_buscvideo.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_buscvideo.this.abrir_secc(t_buscvideo.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_buscvideo.this.mAd_visto) {
                            t_buscvideo.this.abrir_secc(t_buscvideo.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_buscvideo.this.mAd_visto = true;
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
                if (t_buscvideo.this.mAd_visto) {
                    t_buscvideo t_buscvideo = t_buscvideo.this;
                    t_buscvideo.abrir_secc(t_buscvideo.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
