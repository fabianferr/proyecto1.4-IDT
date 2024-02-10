package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
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
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class t_buscvideos extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private static final int SELECT_VIDEO = 4;
    Anuncios anun;
    boolean atras_pulsado = false;
    boolean c1_esclaro;
    cargar_fotos c_f;
    /* access modifiers changed from: private */
    public cargar_foto_async cfa;
    String codigo;
    ProgressDialog d_video;
    Dialog dialog_filtros;
    Dialog dialog_nuevovideo;
    int dp1;
    Bundle extras;
    boolean fcat;
    int fcat_ind;
    int fcat_v;
    boolean finalizar_2 = false;
    int fotos_perfil;
    boolean ftipo;
    int[] ftipo_a = new int[20];
    int ftipo_v;
    config globales;
    int h_thumb;
    /* access modifiers changed from: private */
    public boolean haymas = false;
    int idcat_unico;
    int idsec;
    long idusu;
    String idusuv;
    int ind_secc;
    boolean mAd_visto = false;
    /* access modifiers changed from: private */
    public RecyclerView.Adapter mAdapter;
    ListView mDrawerList;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public ArrayList<Integer> m_inds = null;
    /* access modifiers changed from: private */
    public ArrayList<claseBuscvideo> m_orders = null;
    /* access modifiers changed from: private */
    public ArrayList<claseBuscvideo> m_orders_temp = null;
    boolean masdeuna;
    /* access modifiers changed from: private */
    public boolean obtencion_ok = false;
    int p_descr;
    int p_fnac;
    int p_sexo;
    String pais;
    File path;
    String path_glob;
    private Runnable returnRes = new Runnable() {
        public void run() {
            String str;
            try {
                t_buscvideos.this.findViewById(R.id.pb_videos).setVisibility(8);
            } catch (Exception unused) {
            }
            if (t_buscvideos.this.m_orders_temp != null && t_buscvideos.this.m_orders_temp.size() > 0) {
                for (int i = 0; i < t_buscvideos.this.m_orders_temp.size(); i++) {
                    if (t_buscvideos.this.m_inds.indexOf(Integer.valueOf(((claseBuscvideo) t_buscvideos.this.m_orders_temp.get(i)).id)) == -1) {
                        t_buscvideos.this.m_orders.add((claseBuscvideo) t_buscvideos.this.m_orders_temp.get(i));
                        t_buscvideos.this.m_inds.add(Integer.valueOf(((claseBuscvideo) t_buscvideos.this.m_orders_temp.get(i)).id));
                    }
                }
            }
            t_buscvideos.this.mAdapter.notifyDataSetChanged();
            if (t_buscvideos.this.m_orders != null && t_buscvideos.this.m_orders.size() == 0) {
                if (!t_buscvideos.this.obtencion_ok) {
                    str = t_buscvideos.this.getResources().getString(R.string.error_http);
                } else {
                    str = t_buscvideos.this.getResources().getString(R.string.lista_vacia_videos);
                }
                final AlertDialog create = new AlertDialog.Builder(t_buscvideos.this).setCancelable(true).setPositiveButton(t_buscvideos.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(str).create();
                if (!t_buscvideos.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + t_buscvideos.this.cbtn));
                        }
                    });
                }
                try {
                    create.show();
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused2) {
                }
            }
            if (t_buscvideos.this.m_orders != null && t_buscvideos.this.m_orders.size() > 0) {
                t_buscvideos.this.cfa = new cargar_foto_async();
                t_buscvideos.this.cfa.execute(new String[0]);
            }
        }
    };
    SharedPreferences settings;
    Bitmap sinfoto;
    boolean soloadmin;
    /* access modifiers changed from: private */
    public Thread thread;
    TextView tv_fcat;
    TextView tv_ftipo;
    ArrayList<Usu> usus_a;
    ArrayList<Long> usus_ids_a;
    /* access modifiers changed from: private */
    public Runnable viewOrders;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01b1, code lost:
        if (r0.settings.getBoolean("email_confirmado", false) == false) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01e4, code lost:
        if (r0.settings.getInt("fnac_a", 0) != 0) goto L_0x01e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0260 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            android.content.Context r2 = r20.getApplicationContext()
            stikerwap.appdys.config r2 = (stikerwap.appdys.config) r2
            r0.globales = r2
            java.lang.String r2 = r2.c1
            if (r2 != 0) goto L_0x0015
            stikerwap.appdys.config r2 = r0.globales
            r2.recuperar_vars()
        L_0x0015:
            r0.establec_ralc(r0)
            android.content.Intent r2 = r20.getIntent()
            android.os.Bundle r2 = r2.getExtras()
            r0.extras = r2
            java.lang.String r3 = "es_root"
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L_0x003e
            if (r2 == 0) goto L_0x003a
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x003a
            android.os.Bundle r2 = r0.extras
            boolean r2 = r2.getBoolean(r3, r5)
            if (r2 == 0) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            r0.es_root = r2
            goto L_0x004f
        L_0x003e:
            boolean r2 = r1.containsKey(r3)
            if (r2 == 0) goto L_0x004c
            boolean r2 = r1.getBoolean(r3, r5)
            if (r2 == 0) goto L_0x004c
            r2 = 1
            goto L_0x004d
        L_0x004c:
            r2 = 0
        L_0x004d:
            r0.es_root = r2
        L_0x004f:
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.ind_secc_sel_2
            r0.ind_secc = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r6 = r0.ind_secc
            r2 = r2[r6]
            int r2 = r2.id
            r0.idsec = r2
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r6 = r0.ind_secc
            r2 = r2[r6]
            java.lang.String r2 = r2.c1
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r7 = r0.ind_secc
            r6 = r6[r7]
            java.lang.String r6 = r6.c2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "#"
            r7.<init>(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            boolean r7 = stikerwap.appdys.config.esClaro(r7)
            r0.c1_esclaro = r7
            stikerwap.appdys.config r7 = r0.globales
            java.lang.String r7 = r7.c_icos
            java.lang.String r7 = stikerwap.appdys.config.aplicar_color_dialog(r2, r7)
            r0.cbtn = r7
            boolean r7 = r0.c1_esclaro
            if (r7 != 0) goto L_0x009d
            r7 = 2131952478(0x7f13035e, float:1.95414E38)
            r0.setTheme(r7)
        L_0x009d:
            super.onCreate(r21)
            java.lang.String r7 = "sh"
            android.content.SharedPreferences r9 = r0.getSharedPreferences(r7, r5)
            r0.settings = r9
            java.lang.String r10 = "idusu"
            r11 = 0
            long r13 = r9.getLong(r10, r11)
            r0.idusu = r13
            android.content.SharedPreferences r9 = r0.settings
            java.lang.String r13 = "cod"
            java.lang.String r14 = ""
            java.lang.String r9 = r9.getString(r13, r14)
            r0.codigo = r9
            int r9 = stikerwap.appdys.config.dp_to_px(r0, r4)
            r0.dp1 = r9
            android.os.Bundle r9 = r0.extras
            java.lang.String r13 = "idusuv"
            java.lang.String r9 = r9.getString(r13, r14)
            r0.idusuv = r9
            android.content.SharedPreferences r9 = r0.settings
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r11 = "ftipo_v_"
            r15.<init>(r11)
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r0.ind_secc
            r11 = r11[r12]
            int r11 = r11.id
            r15.append(r11)
            java.lang.String r11 = r15.toString()
            stikerwap.appdys.config r12 = r0.globales
            stikerwap.appdys.Seccion[] r12 = r12.secciones_a
            int r15 = r0.ind_secc
            r12 = r12[r15]
            int r12 = r12.ftipo_def
            int r9 = r9.getInt(r11, r12)
            r0.ftipo_v = r9
            android.content.SharedPreferences r9 = r0.settings
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "fcat_v_"
            r11.<init>(r12)
            stikerwap.appdys.config r12 = r0.globales
            stikerwap.appdys.Seccion[] r12 = r12.secciones_a
            int r15 = r0.ind_secc
            r12 = r12[r15]
            int r12 = r12.id
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            int r9 = r9.getInt(r11, r5)
            r0.fcat_v = r9
            r0.fcat_ind = r5
            r9 = 0
        L_0x011c:
            stikerwap.appdys.config r11 = r0.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r0.ind_secc
            r11 = r11[r12]
            stikerwap.appdys.Cat_buscvideo[] r11 = r11.cats_buscvideo_a
            int r11 = r11.length
            if (r9 >= r11) goto L_0x0142
            int r11 = r0.fcat_v
            stikerwap.appdys.config r12 = r0.globales
            stikerwap.appdys.Seccion[] r12 = r12.secciones_a
            int r15 = r0.ind_secc
            r12 = r12[r15]
            stikerwap.appdys.Cat_buscvideo[] r12 = r12.cats_buscvideo_a
            r12 = r12[r9]
            int r12 = r12.id
            if (r11 != r12) goto L_0x013f
            int r9 = r9 + r4
            r0.fcat_ind = r9
            goto L_0x0142
        L_0x013f:
            int r9 = r9 + 1
            goto L_0x011c
        L_0x0142:
            java.util.Locale r9 = java.util.Locale.getDefault()
            java.lang.String r9 = r9.getCountry()
            r0.pais = r9
            stikerwap.appdys.config r9 = r0.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            int r11 = r0.ind_secc
            r9 = r9[r11]
            int r9 = r9.p_fnac
            r0.p_fnac = r9
            stikerwap.appdys.config r9 = r0.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            int r11 = r0.ind_secc
            r9 = r9[r11]
            int r9 = r9.p_sexo
            r0.p_sexo = r9
            stikerwap.appdys.config r9 = r0.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            int r11 = r0.ind_secc
            r9 = r9[r11]
            int r9 = r9.p_descr
            r0.p_descr = r9
            stikerwap.appdys.config r9 = r0.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            int r11 = r0.ind_secc
            r9 = r9[r11]
            int r9 = r9.fotos_perfil
            r0.fotos_perfil = r9
            android.content.SharedPreferences r9 = r0.settings
            java.lang.String r11 = "nick"
            java.lang.String r9 = r9.getString(r11, r14)
            boolean r9 = r9.equals(r14)
            java.lang.String r11 = "fnac_a"
            java.lang.String r12 = "descr"
            java.lang.String r15 = "fnac_m"
            java.lang.String r4 = "sexo"
            java.lang.String r5 = "fnac_d"
            r16 = r13
            java.lang.String r13 = "desde_buscvideos"
            r17 = r10
            java.lang.String r10 = "idsecc"
            r18 = r7
            if (r9 != 0) goto L_0x0231
            stikerwap.appdys.config r9 = r0.globales
            int r9 = r9.fb_modo
            r7 = 3
            if (r9 != r7) goto L_0x01b5
            android.content.SharedPreferences r7 = r0.settings
            java.lang.String r9 = "email_confirmado"
            r19 = r6
            r6 = 0
            boolean r7 = r7.getBoolean(r9, r6)
            if (r7 != 0) goto L_0x01b7
            goto L_0x0233
        L_0x01b5:
            r19 = r6
        L_0x01b7:
            int r6 = r0.fotos_perfil
            r7 = 2
            if (r6 != r7) goto L_0x01c9
            stikerwap.appdys.config r6 = r0.globales
            r9 = 1
            java.io.File r6 = r6.getTempFile(r0, r9)
            boolean r6 = r6.exists()
            if (r6 == 0) goto L_0x0205
        L_0x01c9:
            int r6 = r0.p_fnac
            if (r6 != r7) goto L_0x01e7
            android.content.SharedPreferences r6 = r0.settings
            r7 = 0
            int r6 = r6.getInt(r5, r7)
            if (r6 == 0) goto L_0x0205
            android.content.SharedPreferences r6 = r0.settings
            int r6 = r6.getInt(r15, r7)
            if (r6 == 0) goto L_0x0205
            android.content.SharedPreferences r6 = r0.settings
            int r6 = r6.getInt(r11, r7)
            if (r6 == 0) goto L_0x0205
            goto L_0x01e8
        L_0x01e7:
            r7 = 0
        L_0x01e8:
            int r6 = r0.p_sexo
            r9 = 2
            if (r6 != r9) goto L_0x01f5
            android.content.SharedPreferences r6 = r0.settings
            int r6 = r6.getInt(r4, r7)
            if (r6 == 0) goto L_0x0205
        L_0x01f5:
            int r6 = r0.p_descr
            if (r6 != r9) goto L_0x022f
            android.content.SharedPreferences r6 = r0.settings
            java.lang.String r6 = r6.getString(r12, r14)
            boolean r6 = r6.equals(r14)
            if (r6 == 0) goto L_0x022f
        L_0x0205:
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.preperfil> r7 = stikerwap.appdys.preperfil.class
            r6.<init>(r0, r7)
            stikerwap.appdys.config r7 = r0.globales
            stikerwap.appdys.Seccion[] r7 = r7.secciones_a
            int r9 = r0.ind_secc
            r7 = r7[r9]
            int r7 = r7.id
            r6.putExtra(r10, r7)
            r7 = 1
            r6.putExtra(r13, r7)
            boolean r9 = r0.es_root
            if (r9 == 0) goto L_0x0226
            boolean r9 = r0.es_root
            r6.putExtra(r3, r9)
        L_0x0226:
            r3 = 0
            r0.es_root = r3
            r0.finalizar_2 = r7
            r0.startActivityForResult(r6, r3)
            goto L_0x025c
        L_0x022f:
            r3 = 0
            goto L_0x025c
        L_0x0231:
            r19 = r6
        L_0x0233:
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.chat_perfil> r7 = stikerwap.appdys.chat_perfil.class
            r6.<init>(r0, r7)
            stikerwap.appdys.config r7 = r0.globales
            stikerwap.appdys.Seccion[] r7 = r7.secciones_a
            int r9 = r0.ind_secc
            r7 = r7[r9]
            int r7 = r7.id
            r6.putExtra(r10, r7)
            r7 = 1
            r6.putExtra(r13, r7)
            boolean r9 = r0.es_root
            if (r9 == 0) goto L_0x0254
            boolean r9 = r0.es_root
            r6.putExtra(r3, r9)
        L_0x0254:
            r3 = 0
            r0.es_root = r3
            r0.finalizar_2 = r7
            r0.startActivityForResult(r6, r3)
        L_0x025c:
            boolean r6 = r0.finalizar_2
            if (r6 == 0) goto L_0x0261
            return
        L_0x0261:
            r6 = 2131558716(0x7f0d013c, float:1.8742756E38)
            r0.setContentView(r6)
            r20.incluir_menu_pre()
            stikerwap.appdys.config r6 = r0.globales
            r6.onCreate_global(r0, r3)
            java.lang.String r3 = "search"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.SearchManager r3 = (android.app.SearchManager) r3
            stikerwap.appdys.t_buscvideos$1 r6 = new stikerwap.appdys.t_buscvideos$1
            r6.<init>()
            r3.setOnCancelListener(r6)
            stikerwap.appdys.t_buscvideos$2 r6 = new stikerwap.appdys.t_buscvideos$2
            r6.<init>()
            r3.setOnDismissListener(r6)
            android.os.Bundle r3 = r0.extras
            java.lang.String r6 = "abrir_buscvideo"
            boolean r3 = r3.containsKey(r6)
            if (r3 != 0) goto L_0x02b4
            stikerwap.appdys.config r3 = r0.globales
            android.os.Bundle r7 = r0.extras
            if (r7 == 0) goto L_0x02a1
            java.lang.String r9 = "ad_entrar"
            boolean r7 = r7.containsKey(r9)
            if (r7 == 0) goto L_0x02a1
            r7 = 1
            goto L_0x02a2
        L_0x02a1:
            r7 = 0
        L_0x02a2:
            android.os.Bundle r9 = r0.extras
            if (r9 == 0) goto L_0x02b0
            java.lang.String r10 = "fb_entrar"
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L_0x02b0
            r9 = 1
            goto L_0x02b1
        L_0x02b0:
            r9 = 0
        L_0x02b1:
            r3.toca_int(r0, r7, r9)
        L_0x02b4:
            stikerwap.appdys.config r3 = r0.globales
            r7 = 0
            stikerwap.appdys.Anuncios r3 = r3.mostrar_banner(r0, r7)
            r0.anun = r3
            stikerwap.appdys.config r3 = r0.globales
            int r7 = r3.ind_secc_sel_2
            java.lang.String r9 = r0.cbtn
            r3.oncreate_popup(r0, r7, r9, r1)
            boolean r1 = r2.equals(r14)
            if (r1 != 0) goto L_0x0308
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r3 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r7 = 2
            int[] r9 = new int[r7]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r8)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            int r2 = android.graphics.Color.parseColor(r2)
            r7 = 0
            r9[r7] = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r7 = r19
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            int r2 = android.graphics.Color.parseColor(r2)
            r7 = 1
            r9[r7] = r2
            r1.<init>(r3, r9)
            r2 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r2 = r0.findViewById(r2)
            r2.setBackgroundDrawable(r1)
        L_0x0308:
            r1 = r18
            r2 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
            r0.settings = r1
            r7 = r17
            r2 = 0
            long r1 = r1.getLong(r7, r2)
            r0.idusu = r1
            java.io.File r1 = r20.getFilesDir()
            r0.path = r1
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.fondo_v
            if (r1 <= 0) goto L_0x032c
            android.content.SharedPreferences r1 = r0.settings
            r1.registerOnSharedPreferenceChangeListener(r0)
        L_0x032c:
            stikerwap.appdys.config r1 = r0.globales
            int r1 = r1.fondo_v
            if (r1 <= 0) goto L_0x036a
            android.content.SharedPreferences r1 = r0.settings
            java.lang.String r2 = "fondo_v_act"
            r3 = 0
            int r1 = r1.getInt(r2, r3)
            stikerwap.appdys.config r2 = r0.globales
            int r2 = r2.fondo_v
            if (r1 != r2) goto L_0x036a
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x0369 }
            r2 = 2131362464(0x7f0a02a0, float:1.834471E38)
            android.view.View r3 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0369 }
            android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ Exception -> 0x0369 }
            stikerwap.appdys.config r7 = r0.globales     // Catch:{ Exception -> 0x0369 }
            boolean r7 = r7.fondo_margen     // Catch:{ Exception -> 0x0369 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x0369 }
            stikerwap.appdys.config r9 = r0.globales     // Catch:{ Exception -> 0x0369 }
            int r9 = r9.fondo_tipo     // Catch:{ Exception -> 0x0369 }
            r1.tratar_fondo(r3, r7, r9)     // Catch:{ Exception -> 0x0369 }
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception -> 0x0369 }
            java.lang.String r3 = "fondo"
            android.view.View r2 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0369 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0369 }
            r1.file_to_iv(r3, r2)     // Catch:{ Exception -> 0x0369 }
            goto L_0x036a
        L_0x0369:
        L_0x036a:
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r2 = r0.ind_secc
            r1 = r1[r2]
            int r1 = r1.formato
            r2 = 1
            if (r1 != r2) goto L_0x039d
            java.lang.String r1 = "window"
            java.lang.Object r1 = r0.getSystemService(r1)
            android.view.WindowManager r1 = (android.view.WindowManager) r1
            android.view.Display r1 = r1.getDefaultDisplay()
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>()
            r1.getSize(r2)
            r1 = 16
            int r3 = stikerwap.appdys.config.dp_to_px(r0, r1)
            int r2 = r2.x
            r7 = 2
            int r3 = r3 * 2
            int r2 = r2 - r3
            int r2 = r2 * 9
            int r2 = r2 / r1
            r0.h_thumb = r2
        L_0x039d:
            boolean r1 = r0.c1_esclaro
            if (r1 == 0) goto L_0x03b4
            android.content.res.Resources r1 = r20.getResources()
            r2 = 2131231689(0x7f0803c9, float:1.8079466E38)
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)
            r2 = 1
            android.graphics.Bitmap r1 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r1, r2)
            r0.sinfoto = r1
            goto L_0x03c6
        L_0x03b4:
            r2 = 1
            android.content.res.Resources r1 = r20.getResources()
            r3 = 2131231691(0x7f0803cb, float:1.807947E38)
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r3)
            android.graphics.Bitmap r1 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r1, r2)
            r0.sinfoto = r1
        L_0x03c6:
            r1 = 2131363426(0x7f0a0662, float:1.834666E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_ftipo = r1
            r1 = 2131363415(0x7f0a0657, float:1.8346638E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.tv_fcat = r1
            java.lang.String r1 = r0.idusuv
            boolean r1 = r1.equals(r14)
            r2 = 8
            r3 = 2131361985(0x7f0a00c1, float:1.8343738E38)
            if (r1 != 0) goto L_0x0429
            r1 = 2131362433(0x7f0a0281, float:1.8344646E38)
            android.view.View r1 = r0.findViewById(r1)
            stikerwap.appdys.t_buscvideos$3 r7 = new stikerwap.appdys.t_buscvideos$3
            r7.<init>()
            r1.setOnClickListener(r7)
            r1 = 2131363455(0x7f0a067f, float:1.834672E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.os.Bundle r7 = r0.extras
            java.lang.String r8 = "nombreusu"
            java.lang.String r7 = r7.getString(r8)
            r1.setText(r7)
            android.view.View r1 = r0.findViewById(r3)
            r1.setVisibility(r2)
            r1 = 2131361953(0x7f0a00a1, float:1.8343673E38)
            android.view.View r1 = r0.findViewById(r1)
            r1.setVisibility(r2)
            r1 = 2131361954(0x7f0a00a2, float:1.8343675E38)
            android.view.View r1 = r0.findViewById(r1)
            r7 = 0
            r1.setVisibility(r7)
            goto L_0x048b
        L_0x0429:
            r7 = 0
            r1 = 2131361991(0x7f0a00c7, float:1.834375E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            stikerwap.appdys.config r9 = r0.globales
            int r9 = r9.v_ico_perfil
            if (r9 <= 0) goto L_0x0451
            android.content.SharedPreferences r9 = r0.settings
            java.lang.String r10 = "v_ico_perfil_act"
            int r9 = r9.getInt(r10, r7)
            stikerwap.appdys.config r7 = r0.globales
            int r7 = r7.v_ico_perfil
            if (r9 != r7) goto L_0x0451
            stikerwap.appdys.config r7 = r0.globales     // Catch:{ Exception -> 0x0450 }
            java.lang.String r9 = "ico_perfil"
            r7.file_to_iv(r9, r1)     // Catch:{ Exception -> 0x0450 }
            goto L_0x0451
        L_0x0450:
        L_0x0451:
            r1.setOnClickListener(r0)
            r7 = 0
            r1.setVisibility(r7)
            android.content.res.Resources r1 = r20.getResources()
            r7 = 2131231438(0x7f0802ce, float:1.8078957E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r7)
            java.lang.String r7 = r0.cbtn
            boolean r7 = r7.equals(r14)
            if (r7 != 0) goto L_0x0482
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r8)
            java.lang.String r8 = r0.cbtn
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            int r7 = android.graphics.Color.parseColor(r7)
            android.graphics.PorterDuff$Mode r8 = android.graphics.PorterDuff.Mode.MULTIPLY
            r1.setColorFilter(r7, r8)
        L_0x0482:
            android.view.View r7 = r0.findViewById(r3)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r7.setImageDrawable(r1)
        L_0x048b:
            stikerwap.appdys.config r1 = r0.globales
            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
            int r7 = r0.ind_secc
            r1 = r1[r7]
            r7 = 1
            r0.soloadmin = r7
            r7 = 0
            r0.masdeuna = r7
            r7 = 0
            r8 = 0
        L_0x049b:
            stikerwap.appdys.Cat_buscvideo[] r9 = r1.cats_buscvideo_a
            int r9 = r9.length
            if (r7 >= r9) goto L_0x04c4
            stikerwap.appdys.Cat_buscvideo[] r9 = r1.cats_buscvideo_a
            r9 = r9[r7]
            boolean r9 = r9.soloadmin
            if (r9 == 0) goto L_0x04ae
            stikerwap.appdys.config r9 = r0.globales
            boolean r9 = r9.es_admin
            if (r9 == 0) goto L_0x04bb
        L_0x04ae:
            r9 = 0
            r0.soloadmin = r9
            int r8 = r8 + 1
            stikerwap.appdys.Cat_buscvideo[] r9 = r1.cats_buscvideo_a
            r9 = r9[r7]
            int r9 = r9.id
            r0.idcat_unico = r9
        L_0x04bb:
            r9 = 1
            if (r8 <= r9) goto L_0x04c1
            r0.masdeuna = r9
            goto L_0x04c4
        L_0x04c1:
            int r7 = r7 + 1
            goto L_0x049b
        L_0x04c4:
            boolean r7 = r0.soloadmin
            if (r7 != 0) goto L_0x04d0
            android.view.View r2 = r0.findViewById(r3)
            r2.setOnClickListener(r0)
            goto L_0x04d7
        L_0x04d0:
            android.view.View r3 = r0.findViewById(r3)
            r3.setVisibility(r2)
        L_0x04d7:
            boolean r2 = r0.soloadmin
            r3 = 1
            r2 = r2 ^ r3
            boolean r3 = r1.ftipo_dist
            if (r3 == 0) goto L_0x04e1
            int r2 = r2 + 1
        L_0x04e1:
            boolean r3 = r1.ftipo_destacados
            if (r3 == 0) goto L_0x04e7
            int r2 = r2 + 1
        L_0x04e7:
            boolean r3 = r1.ftipo_favoritos
            if (r3 == 0) goto L_0x04ed
            int r2 = r2 + 1
        L_0x04ed:
            boolean r3 = r1.ftipo_maspuntuados
            if (r3 == 0) goto L_0x04f3
            int r2 = r2 + 1
        L_0x04f3:
            boolean r3 = r1.ftipo_masvistos
            if (r3 == 0) goto L_0x04f9
            int r2 = r2 + 1
        L_0x04f9:
            boolean r3 = r1.ftipo_ultimos
            if (r3 == 0) goto L_0x04ff
            int r2 = r2 + 1
        L_0x04ff:
            r3 = 1
            if (r2 <= r3) goto L_0x0504
            r2 = 1
            goto L_0x0505
        L_0x0504:
            r2 = 0
        L_0x0505:
            r0.ftipo = r2
            stikerwap.appdys.Cat_buscvideo[] r1 = r1.cats_buscvideo_a
            int r1 = r1.length
            if (r1 <= r3) goto L_0x050e
            r1 = 1
            goto L_0x050f
        L_0x050e:
            r1 = 0
        L_0x050f:
            r0.fcat = r1
            r20.mostrar_filtros()
            android.app.Dialog r1 = r20.crear_dialog_filtros()
            r0.dialog_filtros = r1
            android.app.Dialog r1 = r20.crear_dialog_nuevovideo()
            r0.dialog_nuevovideo = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.m_orders = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.m_inds = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.usus_a = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.usus_ids_a = r1
            r1 = 2131362904(0x7f0a0458, float:1.8345602E38)
            android.view.View r1 = r0.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            r0.mRecyclerView = r1
            r2 = 1
            r1.setHasFixedSize(r2)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            r1.<init>(r0)
            r0.mLayoutManager = r1
            androidx.recyclerview.widget.RecyclerView r2 = r0.mRecyclerView
            r2.setLayoutManager(r1)
            stikerwap.appdys.t_buscvideos$MyAdapter r1 = new stikerwap.appdys.t_buscvideos$MyAdapter
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r2 = r0.m_orders
            r1.<init>(r2)
            r0.mAdapter = r1
            androidx.recyclerview.widget.RecyclerView r2 = r0.mRecyclerView
            r2.setAdapter(r1)
            stikerwap.appdys.t_buscvideos$4 r1 = new stikerwap.appdys.t_buscvideos$4
            r1.<init>()
            r0.viewOrders = r1
            java.lang.Thread r1 = new java.lang.Thread
            java.lang.Runnable r2 = r0.viewOrders
            java.lang.String r3 = "buscandoelems"
            r7 = 0
            r1.<init>(r7, r2, r3)
            r0.thread = r1
            r1 = 2131363038(0x7f0a04de, float:1.8345874E38)
            android.view.View r1 = r0.findViewById(r1)
            r2 = 0
            r1.setVisibility(r2)
            java.lang.Thread r1 = r0.thread
            r1.start()
            boolean r1 = r0.finalizar_2
            if (r1 != 0) goto L_0x06f8
            android.os.Bundle r1 = r0.extras
            boolean r1 = r1.containsKey(r6)
            if (r1 == 0) goto L_0x06f8
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.t_buscvideo> r2 = stikerwap.appdys.t_buscvideo.class
            r1.<init>(r0, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r2 = r2.getString(r6)
            android.os.Bundle r3 = r0.extras
            java.lang.String r6 = "abrir_buscvideo_idusu"
            java.lang.String r3 = r3.getString(r6)
            android.os.Bundle r6 = r0.extras
            java.lang.String r7 = "abrir_buscvideo_formato"
            java.lang.String r8 = "mp4"
            java.lang.String r6 = r6.getString(r7, r8)
            java.lang.String r7 = "1"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x05be
            java.lang.String r6 = "mp4"
            goto L_0x05d6
        L_0x05be:
            java.lang.String r7 = "2"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x05c9
            java.lang.String r6 = "3gp"
            goto L_0x05d6
        L_0x05c9:
            java.lang.String r7 = "3"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x05d5
            java.lang.String r6 = "webm"
            goto L_0x05d6
        L_0x05d5:
            r6 = r14
        L_0x05d6:
            boolean r7 = r6.equals(r14)
            if (r7 != 0) goto L_0x06f8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "https://video."
            r7.<init>(r8)
            java.lang.String r8 = stikerwap.appdys.config.DOM_EDROID
            r7.append(r8)
            java.lang.String r8 = "/files_busc/v"
            r7.append(r8)
            r7.append(r2)
            java.lang.String r8 = "_"
            r7.append(r8)
            r7.append(r3)
            java.lang.String r8 = "."
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = "?ida=3008836"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "url"
            r1.putExtra(r7, r6)
            java.lang.String r6 = "ind"
            int r7 = r0.ind_secc
            r1.putExtra(r6, r7)
            android.os.Bundle r6 = r0.extras
            java.lang.String r7 = "abrir_buscvideo_nlikes"
            java.lang.String r6 = r6.getString(r7)
            java.lang.String r7 = "nlikes"
            r1.putExtra(r7, r6)
            android.os.Bundle r6 = r0.extras
            java.lang.String r7 = "abrir_buscvideo_liked"
            java.lang.String r6 = r6.getString(r7)
            java.lang.String r7 = "liked"
            r1.putExtra(r7, r6)
            java.lang.String r6 = "idv"
            r1.putExtra(r6, r2)
            java.lang.String r2 = "indv"
            r6 = -1
            r1.putExtra(r2, r6)
            r2 = r16
            r1.putExtra(r2, r3)
            java.lang.String r2 = "desde_videosdeusu"
            r3 = 0
            r1.putExtra(r2, r3)
            stikerwap.appdys.config r2 = r0.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            int r3 = r0.ind_secc
            r2 = r2[r3]
            boolean r2 = r2.mostrar_descr
            if (r2 == 0) goto L_0x065b
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_descr"
            java.lang.String r2 = r2.getString(r3)
            goto L_0x065c
        L_0x065b:
            r2 = r14
        L_0x065c:
            stikerwap.appdys.config r3 = r0.globales
            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
            int r6 = r0.ind_secc
            r3 = r3[r6]
            boolean r3 = r3.mostrar_nombre
            if (r3 == 0) goto L_0x0671
            android.os.Bundle r3 = r0.extras
            java.lang.String r6 = "abrir_buscvideo_nombre"
            java.lang.String r3 = r3.getString(r6)
            goto L_0x0672
        L_0x0671:
            r3 = r14
        L_0x0672:
            stikerwap.appdys.config r6 = r0.globales
            stikerwap.appdys.Seccion[] r6 = r6.secciones_a
            int r7 = r0.ind_secc
            r6 = r6[r7]
            boolean r6 = r6.mostrar_fecha
            if (r6 == 0) goto L_0x0686
            android.os.Bundle r6 = r0.extras
            java.lang.String r7 = "abrir_buscvideo_fcrea"
            java.lang.String r14 = r6.getString(r7)
        L_0x0686:
            r1.putExtra(r12, r2)
            java.lang.String r2 = "nombre"
            r1.putExtra(r2, r3)
            java.lang.String r2 = "fcrea"
            r1.putExtra(r2, r14)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_coments"
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "coments"
            r1.putExtra(r3, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_fnac_d"
            java.lang.String r2 = r2.getString(r3)
            r1.putExtra(r5, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_fnac_m"
            java.lang.String r2 = r2.getString(r3)
            r1.putExtra(r15, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_fnac_a"
            java.lang.String r2 = r2.getString(r3)
            r1.putExtra(r11, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_sexo"
            java.lang.String r2 = r2.getString(r3)
            r1.putExtra(r4, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_privados"
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "privados"
            r1.putExtra(r3, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_nvideos"
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "nvideos"
            r1.putExtra(r3, r2)
            android.os.Bundle r2 = r0.extras
            java.lang.String r3 = "abrir_buscvideo_vfoto"
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "vfoto"
            r1.putExtra(r3, r2)
            r2 = 0
            r0.startActivityForResult(r1, r2)
        L_0x06f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.onCreate(android.os.Bundle):void");
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
            r10 = this;
            stikerwap.appdys.config r0 = r10.globales
            if (r0 == 0) goto L_0x000b
            boolean r0 = r0.onActivityResult_glob(r11, r12, r13, r10)
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            r0 = -1
            r1 = 0
            if (r12 != r0) goto L_0x0200
            java.lang.String r12 = ".jpg"
            java.lang.String r2 = "fbuscvideo_"
            r3 = 1
            if (r13 == 0) goto L_0x007d
            java.lang.String r4 = "idusu_ban"
            boolean r5 = r13.hasExtra(r4)
            if (r5 == 0) goto L_0x007d
            java.lang.String r4 = r13.getStringExtra(r4)
            long r4 = java.lang.Long.parseLong(r4)
        L_0x0026:
            r6 = 0
        L_0x0027:
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r7 = r10.m_orders
            int r7 = r7.size()
            if (r6 >= r7) goto L_0x007a
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r7 = r10.m_orders
            java.lang.Object r7 = r7.get(r6)
            stikerwap.appdys.claseBuscvideo r7 = (stikerwap.appdys.claseBuscvideo) r7
            long r7 = r7.idusu
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x0077
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r7 = r10.m_orders
            java.lang.Object r7 = r7.get(r6)
            stikerwap.appdys.claseBuscvideo r7 = (stikerwap.appdys.claseBuscvideo) r7
            int r7 = r7.id
            java.util.ArrayList<java.lang.Integer> r8 = r10.m_inds
            r8.remove(r6)
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r8 = r10.m_orders
            r8.remove(r6)
            java.io.File r6 = new java.io.File
            java.io.File r8 = r10.path
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r2)
            r9.append(r7)
            r9.append(r12)
            java.lang.String r7 = r9.toString()
            r6.<init>(r8, r7)
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x0070
            r6.delete()
        L_0x0070:
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = r10.mAdapter
            r6.notifyDataSetChanged()
            r6 = 1
            goto L_0x007b
        L_0x0077:
            int r6 = r6 + 1
            goto L_0x0027
        L_0x007a:
            r6 = 0
        L_0x007b:
            if (r6 != 0) goto L_0x0026
        L_0x007d:
            r4 = 108(0x6c, float:1.51E-43)
            java.lang.String r5 = ""
            if (r11 == r4) goto L_0x018e
            r6 = 4
            if (r11 != r6) goto L_0x0088
            goto L_0x018e
        L_0x0088:
            if (r13 == 0) goto L_0x00b3
            java.lang.String r11 = "finalizar"
            boolean r4 = r13.hasExtra(r11)
            if (r4 == 0) goto L_0x00b3
            android.os.Bundle r12 = r13.getExtras()
            boolean r11 = r12.getBoolean(r11)
            if (r11 == 0) goto L_0x0200
            android.os.Bundle r11 = r13.getExtras()
            java.lang.String r12 = "finalizar_app"
            boolean r11 = r11.getBoolean(r12)
            if (r11 != 0) goto L_0x00aa
            r10.es_root = r1
        L_0x00aa:
            r10.setResult(r0, r13)
            r10.finish()
            r1 = 1
            goto L_0x0200
        L_0x00b3:
            if (r13 == 0) goto L_0x010d
            java.lang.String r11 = "elim_video"
            boolean r3 = r13.hasExtra(r11)
            if (r3 == 0) goto L_0x010d
            java.util.ArrayList<java.lang.Integer> r3 = r10.m_inds
            android.os.Bundle r4 = r13.getExtras()
            java.lang.String r4 = r4.getString(r11)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r3 = r3.indexOf(r4)
            if (r3 == r0) goto L_0x0200
            java.util.ArrayList<java.lang.Integer> r0 = r10.m_inds
            r0.remove(r3)
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r0 = r10.m_orders
            r0.remove(r3)
            java.io.File r0 = new java.io.File
            java.io.File r3 = r10.path
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            android.os.Bundle r13 = r13.getExtras()
            java.lang.String r11 = r13.getString(r11)
            r4.append(r11)
            r4.append(r12)
            java.lang.String r11 = r4.toString()
            r0.<init>(r3, r11)
            boolean r11 = r0.exists()
            if (r11 == 0) goto L_0x0106
            r0.delete()
        L_0x0106:
            androidx.recyclerview.widget.RecyclerView$Adapter r11 = r10.mAdapter
            r11.notifyDataSetChanged()
            goto L_0x0200
        L_0x010d:
            if (r13 == 0) goto L_0x0200
            java.lang.String r11 = "nlikesv"
            boolean r12 = r13.hasExtra(r11)
            if (r12 == 0) goto L_0x0200
            java.util.ArrayList<java.lang.Integer> r12 = r10.m_inds
            android.os.Bundle r2 = r13.getExtras()
            java.lang.String r3 = "idv"
            java.lang.String r2 = r2.getString(r3)
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r12 = r12.indexOf(r2)
            if (r12 == r0) goto L_0x0166
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r0 = r10.m_orders
            java.lang.Object r0 = r0.get(r12)
            stikerwap.appdys.claseBuscvideo r0 = (stikerwap.appdys.claseBuscvideo) r0
            android.os.Bundle r2 = r13.getExtras()
            java.lang.String r11 = r2.getString(r11)
            int r11 = java.lang.Integer.parseInt(r11)
            r0.nlikes = r11
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r11 = r10.m_orders
            java.lang.Object r11 = r11.get(r12)
            stikerwap.appdys.claseBuscvideo r11 = (stikerwap.appdys.claseBuscvideo) r11
            android.os.Bundle r12 = r13.getExtras()
            java.lang.String r0 = "liked"
            java.lang.String r12 = r12.getString(r0)
            java.lang.String r0 = "1"
            boolean r12 = r12.equals(r0)
            r11.liked = r12
            androidx.recyclerview.widget.RecyclerView$Adapter r11 = r10.mAdapter
            r11.notifyDataSetChanged()
        L_0x0166:
            java.lang.String r11 = "idusu_abrir"
            java.lang.String r11 = r13.getStringExtra(r11)
            boolean r12 = r11.equals(r5)
            if (r12 != 0) goto L_0x0200
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<stikerwap.appdys.t_buscvideos> r0 = stikerwap.appdys.t_buscvideos.class
            r12.<init>(r10, r0)
            java.lang.String r0 = "idusuv"
            r12.putExtra(r0, r11)
            java.lang.String r11 = "nombreusu_abrir"
            java.lang.String r11 = r13.getStringExtra(r11)
            java.lang.String r13 = "nombreusu"
            r12.putExtra(r13, r11)
            r10.startActivityForResult(r12, r1)
            goto L_0x0200
        L_0x018e:
            if (r11 != r4) goto L_0x019d
            java.lang.String r11 = "dt_foto98_temp.mp4"
            stikerwap.appdys.config r12 = r10.globales
            java.io.File r11 = r12.getExtTempFile_libre(r10, r11)
            java.lang.String r11 = r11.getAbsolutePath()
            goto L_0x01d3
        L_0x019d:
            android.net.Uri r11 = r13.getData()
            android.content.Context r12 = r10.getApplicationContext()
            java.lang.String r12 = stikerwap.appdys.config.generatePath(r11, r12)
            java.lang.String r13 = "."
            int r13 = r12.lastIndexOf(r13)
            int r13 = r13 + r3
            java.lang.String r12 = r12.substring(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "dt_foto98_temp."
            r13.<init>(r0)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            boolean r11 = stikerwap.appdys.config.savefile(r10, r11, r12)
            if (r11 != 0) goto L_0x01c9
            return
        L_0x01c9:
            stikerwap.appdys.config r11 = r10.globales
            java.io.File r11 = r11.getExtTempFile_libre(r10, r12)
            java.lang.String r11 = r11.getAbsolutePath()
        L_0x01d3:
            if (r11 == 0) goto L_0x0200
            boolean r12 = r11.equals(r5)
            if (r12 != 0) goto L_0x0200
            boolean r12 = r10.pretratar_video(r11)
            if (r12 != 0) goto L_0x01e2
            return
        L_0x01e2:
            r10.path_glob = r11
            stikerwap.appdys.config r11 = r10.globales
            stikerwap.appdys.Seccion[] r11 = r11.secciones_a
            int r12 = r10.ind_secc
            r11 = r11[r12]
            boolean r11 = r11.mostrar_descr
            if (r11 != 0) goto L_0x01fb
            boolean r11 = r10.masdeuna
            if (r11 == 0) goto L_0x01f5
            goto L_0x01fb
        L_0x01f5:
            int r11 = r10.idcat_unico
            r10.enviar_video_pre(r11, r5)
            goto L_0x0200
        L_0x01fb:
            android.app.Dialog r11 = r10.dialog_nuevovideo
            r11.show()
        L_0x0200:
            if (r1 != 0) goto L_0x0209
            boolean r11 = r10.finalizar_2
            if (r11 == 0) goto L_0x0209
            r10.finish()
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.onActivityResult(int, int, android.content.Intent):void");
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
        String str;
        if (view.getId() == R.id.ll_filtros) {
            this.dialog_filtros.show();
        } else if (view.getId() == R.id.btnperfil) {
            Intent intent = new Intent(this, preperfil.class);
            intent.putExtra("idsecc", this.globales.secciones_a[this.ind_secc].id);
            intent.putExtra("nocompletar", true);
            intent.putExtra("desde_buscvideos", true);
            startActivityForResult(intent, 0);
        } else {
            String str2 = "";
            if (view.getId() == R.id.btncrearvid) {
                final AlertDialog create = new AlertDialog.Builder(this).setCancelable(true).setPositiveButton(getString(R.string.tomardecamara), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!t_buscvideos.this.globales.tener_que_pedir_p_camara(t_buscvideos.this, 109)) {
                            config config = t_buscvideos.this.globales;
                            t_buscvideos t_buscvideos = t_buscvideos.this;
                            config.iniciar_tomardecamara_v(t_buscvideos, t_buscvideos.globales.getExtTempFile_libre(t_buscvideos.this, "dt_foto98_temp.mp4"));
                        }
                    }
                }).setNegativeButton(getString(R.string.selvideo), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent("android.intent.action.PICK");
                        intent.setType("video/*");
                        t_buscvideos.this.startActivityForResult(intent, 4);
                    }
                }).setMessage(R.string.enviarvideo).create();
                if (!this.cbtn.equals(str2)) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + t_buscvideos.this.cbtn));
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + t_buscvideos.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            } else if (view.getId() == R.id.fila) {
                int childPosition = this.mRecyclerView.getChildPosition(view);
                if (childPosition < this.m_orders.size() && childPosition != -1) {
                    claseBuscvideo clasebuscvideo = this.m_orders.get(childPosition);
                    Intent intent2 = new Intent(this, t_buscvideo.class);
                    String str3 = "1";
                    if (clasebuscvideo.formato.equals(str3)) {
                        str = "mp4";
                    } else if (clasebuscvideo.formato.equals("2")) {
                        str = "3gp";
                    } else if (clasebuscvideo.formato.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        str = "webm";
                    } else {
                        return;
                    }
                    intent2.putExtra("url", "https://video." + config.DOM_EDROID + "/files_busc/v" + clasebuscvideo.id + "_" + clasebuscvideo.idusu + "." + str + "?ida=3008836");
                    intent2.putExtra("ind", this.ind_secc);
                    StringBuilder sb = new StringBuilder();
                    sb.append(clasebuscvideo.nlikes);
                    sb.append(str2);
                    intent2.putExtra("nlikes", sb.toString());
                    if (!clasebuscvideo.liked) {
                        str3 = "0";
                    }
                    intent2.putExtra("liked", str3);
                    intent2.putExtra("idv", clasebuscvideo.id + str2);
                    intent2.putExtra("indv", childPosition);
                    intent2.putExtra("idusuv", clasebuscvideo.idusu + str2);
                    intent2.putExtra("desde_videosdeusu", this.idusuv.equals(str2) ^ true);
                    String str4 = this.globales.secciones_a[this.ind_secc].mostrar_descr ? clasebuscvideo.descr : str2;
                    String str5 = this.globales.secciones_a[this.ind_secc].mostrar_nombre ? clasebuscvideo.nombre : str2;
                    if (this.globales.secciones_a[this.ind_secc].mostrar_fecha) {
                        str2 = clasebuscvideo.fcrea;
                    }
                    intent2.putExtra("descr", str4);
                    intent2.putExtra("nombre", str5);
                    intent2.putExtra("fcrea", str2);
                    intent2.putExtra("coments", clasebuscvideo.coments);
                    intent2.putExtra("fnac_d", clasebuscvideo.fnac_d);
                    intent2.putExtra("fnac_m", clasebuscvideo.fnac_m);
                    intent2.putExtra("fnac_a", clasebuscvideo.fnac_a);
                    intent2.putExtra("sexo", clasebuscvideo.sexo);
                    intent2.putExtra("privados", clasebuscvideo.privados);
                    intent2.putExtra("nvideos", clasebuscvideo.nvideos);
                    int indexOf = this.usus_ids_a.indexOf(Long.valueOf(clasebuscvideo.idusu));
                    if (indexOf != -1) {
                        intent2.putExtra("vfoto", this.usus_a.get(indexOf).vfoto);
                    } else {
                        intent2.putExtra("vfoto", "0");
                    }
                    startActivityForResult(intent2, 0);
                }
            } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals(str2)) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals(str2)) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals(str2)) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals(str2)) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals(str2)) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals(str2)) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals(str2)) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(str2))))))))) {
                abrir_secc(view);
            } else {
                if (this.globales.appnext_rew_cod != null && !this.globales.appnext_rew_cod.equals(str2)) {
                    this.mAd_appnext = new RewardedVideo((Context) this, this.globales.appnext_rew_cod);
                }
                if (this.globales.admob_rew_cod != null) {
                    this.globales.admob_rew_cod.equals(str2);
                }
                if (this.globales.fb_rew_cod != null && !this.globales.fb_rew_cod.equals(str2)) {
                    this.mAd_fb = new RewardedVideoAd(this, this.globales.fb_rew_cod);
                }
                if (this.globales.st_rew_cod != null && !this.globales.st_rew_cod.equals(str2)) {
                    this.mAd_st = new StartAppAd(this);
                }
                this.dialog_cargando = new ProgressDialog(this);
                this.v_abrir_secc = view;
                if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                    abrir_secc(view);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 109) {
            return;
        }
        if (iArr == null || iArr.length <= 0 || !strArr[0].equals("android.permission.CAMERA") || iArr[0] != 0) {
            config.mostrar_error(this, "", getResources().getString(R.string.permisos), this.cbtn);
            return;
        }
        config config = this.globales;
        config.iniciar_tomardecamara_v(this, config.getExtTempFile_libre(this, "dt_foto98_temp.mp4"));
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
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c A[Catch:{ Exception -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7 A[Catch:{ Exception -> 0x00d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean pretratar_video(java.lang.String r8) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            long r1 = r0.length()
            r3 = 0
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0011
            return r5
        L_0x0011:
            long r0 = r0.length()
            r2 = 111149056(0x6a00000, double:5.491493E-316)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0060
            android.app.AlertDialog$Builder r8 = new android.app.AlertDialog$Builder
            r8.<init>(r7)
            android.app.AlertDialog$Builder r8 = r8.setCancelable(r5)
            r0 = 2131886114(0x7f120022, float:1.9406798E38)
            java.lang.String r0 = r7.getString(r0)
            r1 = 0
            android.app.AlertDialog$Builder r8 = r8.setPositiveButton(r0, r1)
            r0 = 2131886868(0x7f120314, float:1.9408327E38)
            android.app.AlertDialog$Builder r8 = r8.setMessage(r0)
            android.app.AlertDialog r8 = r8.create()
            java.lang.String r0 = r7.cbtn
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004e
            stikerwap.appdys.t_buscvideos$8 r0 = new stikerwap.appdys.t_buscvideos$8
            r0.<init>(r8)
            r8.setOnShowListener(r0)
        L_0x004e:
            r8.show()
            r0 = 16908299(0x102000b, float:2.387726E-38)
            android.view.View r8 = r8.findViewById(r0)     // Catch:{ Exception -> 0x005f }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x005f }
            android.graphics.Typeface r0 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x005f }
            r8.setTypeface(r0)     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            return r5
        L_0x0060:
            r0 = 1
            android.graphics.Bitmap r8 = android.media.ThumbnailUtils.createVideoThumbnail(r8, r0)
            stikerwap.appdys.config r1 = r7.globales
            r2 = 99
            java.io.File r1 = r1.getTempFile(r7, r2)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0079 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0079 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0079 }
            r4 = 100
            r8.compress(r1, r4, r3)     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            stikerwap.appdys.config r8 = r7.globales     // Catch:{ Exception -> 0x00d5 }
            java.io.File r8 = r8.getTempFile(r7, r2)     // Catch:{ Exception -> 0x00d5 }
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x00d5 }
            r1.<init>()     // Catch:{ Exception -> 0x00d5 }
            r1.inJustDecodeBounds = r0     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r3 = r8.getPath()     // Catch:{ Exception -> 0x00d5 }
            android.graphics.BitmapFactory.decodeFile(r3, r1)     // Catch:{ Exception -> 0x00d5 }
            int r3 = r1.outWidth     // Catch:{ Exception -> 0x00d5 }
            int r3 = r1.outWidth     // Catch:{ Exception -> 0x00d5 }
            int r1 = r1.outHeight     // Catch:{ Exception -> 0x00d5 }
            r4 = 800(0x320, float:1.121E-42)
            if (r3 > r4) goto L_0x009a
            if (r1 > r4) goto L_0x009a
            r5 = 1
        L_0x009a:
            if (r5 != 0) goto L_0x00b7
            int r1 = stikerwap.appdys.config.calculateNewWidth(r3, r1, r4, r4)     // Catch:{ Exception -> 0x00d5 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x00d5 }
            float r1 = (float) r1     // Catch:{ Exception -> 0x00d5 }
            float r3 = r3 / r1
            int r1 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x00d5 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x00d5 }
            r3.<init>()     // Catch:{ Exception -> 0x00d5 }
            r3.inSampleSize = r1     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r8 = r8.getPath()     // Catch:{ Exception -> 0x00d5 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeFile(r8, r3)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00c3
        L_0x00b7:
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x00d5 }
            android.net.Uri r8 = android.net.Uri.fromFile(r8)     // Catch:{ Exception -> 0x00d5 }
            android.graphics.Bitmap r8 = android.provider.MediaStore.Images.Media.getBitmap(r1, r8)     // Catch:{ Exception -> 0x00d5 }
        L_0x00c3:
            stikerwap.appdys.config r1 = r7.globales     // Catch:{ Exception -> 0x00d5 }
            java.io.File r1 = r1.getTempFile(r7, r2)     // Catch:{ Exception -> 0x00d5 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d5 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00d5 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00d5 }
            r3 = 75
            r8.compress(r1, r3, r2)     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.pretratar_video(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public void act_lista() {
        Thread thread2 = this.thread;
        if (thread2 != null) {
            try {
                thread2.interrupt();
            } catch (Exception unused) {
            }
        }
        this.haymas = false;
        this.obtencion_ok = false;
        ArrayList<claseBuscvideo> arrayList = this.m_orders;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<claseBuscvideo> arrayList2 = this.m_orders_temp;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<Integer> arrayList3 = this.m_inds;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        this.mAdapter.notifyDataSetChanged();
        findViewById(R.id.pb_videos).setVisibility(0);
        Thread thread3 = new Thread((ThreadGroup) null, this.viewOrders, "buscandoelems");
        this.thread = thread3;
        thread3.start();
    }

    /* access modifiers changed from: package-private */
    public Dialog crear_dialog_filtros() {
        int i;
        int i2;
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.buscvideos_filtros);
        dialog.setTitle(getResources().getString(R.string.selecciona));
        TextView textView = (TextView) dialog.findViewById(R.id.btn_aceptar);
        textView.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:16:0x00bd  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0061  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r6) {
                /*
                    r5 = this;
                    stikerwap.appdys.t_buscvideos r6 = stikerwap.appdys.t_buscvideos.this
                    android.content.SharedPreferences r6 = r6.settings
                    android.content.SharedPreferences$Editor r6 = r6.edit()
                    stikerwap.appdys.t_buscvideos r0 = stikerwap.appdys.t_buscvideos.this
                    boolean r0 = r0.ftipo
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x005a
                    stikerwap.appdys.t_buscvideos r0 = stikerwap.appdys.t_buscvideos.this
                    android.app.Dialog r0 = r0.dialog_filtros
                    r3 = 2131363197(0x7f0a057d, float:1.8346196E38)
                    android.view.View r0 = r0.findViewById(r3)
                    android.widget.Spinner r0 = (android.widget.Spinner) r0
                    int r0 = r0.getSelectedItemPosition()
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    int r3 = r3.ftipo_v
                    stikerwap.appdys.t_buscvideos r4 = stikerwap.appdys.t_buscvideos.this
                    int[] r4 = r4.ftipo_a
                    r4 = r4[r0]
                    if (r3 == r4) goto L_0x005a
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    int[] r4 = r3.ftipo_a
                    r0 = r4[r0]
                    r3.ftipo_v = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r3 = "ftipo_v_"
                    r0.<init>(r3)
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    stikerwap.appdys.config r3 = r3.globales
                    stikerwap.appdys.Seccion[] r3 = r3.secciones_a
                    stikerwap.appdys.t_buscvideos r4 = stikerwap.appdys.t_buscvideos.this
                    int r4 = r4.ind_secc
                    r3 = r3[r4]
                    int r3 = r3.id
                    r0.append(r3)
                    java.lang.String r0 = r0.toString()
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    int r3 = r3.ftipo_v
                    r6.putInt(r0, r3)
                    r0 = 1
                    goto L_0x005b
                L_0x005a:
                    r0 = 0
                L_0x005b:
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    boolean r3 = r3.fcat
                    if (r3 == 0) goto L_0x00ba
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    android.app.Dialog r3 = r3.dialog_filtros
                    r4 = 2131363192(0x7f0a0578, float:1.8346186E38)
                    android.view.View r3 = r3.findViewById(r4)
                    android.widget.Spinner r3 = (android.widget.Spinner) r3
                    int r3 = r3.getSelectedItemPosition()
                    if (r3 <= 0) goto L_0x0088
                    stikerwap.appdys.t_buscvideos r2 = stikerwap.appdys.t_buscvideos.this
                    stikerwap.appdys.config r2 = r2.globales
                    stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                    stikerwap.appdys.t_buscvideos r4 = stikerwap.appdys.t_buscvideos.this
                    int r4 = r4.ind_secc
                    r2 = r2[r4]
                    stikerwap.appdys.Cat_buscvideo[] r2 = r2.cats_buscvideo_a
                    int r4 = r3 + -1
                    r2 = r2[r4]
                    int r2 = r2.id
                L_0x0088:
                    stikerwap.appdys.t_buscvideos r4 = stikerwap.appdys.t_buscvideos.this
                    int r4 = r4.fcat_v
                    if (r4 == r2) goto L_0x00ba
                    stikerwap.appdys.t_buscvideos r0 = stikerwap.appdys.t_buscvideos.this
                    r0.fcat_v = r2
                    stikerwap.appdys.t_buscvideos r0 = stikerwap.appdys.t_buscvideos.this
                    r0.fcat_ind = r3
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r2 = "fcat_v_"
                    r0.<init>(r2)
                    stikerwap.appdys.t_buscvideos r2 = stikerwap.appdys.t_buscvideos.this
                    stikerwap.appdys.config r2 = r2.globales
                    stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                    stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this
                    int r3 = r3.ind_secc
                    r2 = r2[r3]
                    int r2 = r2.id
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    stikerwap.appdys.t_buscvideos r2 = stikerwap.appdys.t_buscvideos.this
                    int r2 = r2.fcat_v
                    r6.putInt(r0, r2)
                    goto L_0x00bb
                L_0x00ba:
                    r1 = r0
                L_0x00bb:
                    if (r1 == 0) goto L_0x00ca
                    r6.commit()
                    stikerwap.appdys.t_buscvideos r6 = stikerwap.appdys.t_buscvideos.this
                    r6.mostrar_filtros()
                    stikerwap.appdys.t_buscvideos r6 = stikerwap.appdys.t_buscvideos.this
                    r6.act_lista()
                L_0x00ca:
                    stikerwap.appdys.t_buscvideos r6 = stikerwap.appdys.t_buscvideos.this
                    android.app.Dialog r6 = r6.dialog_filtros
                    r6.dismiss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.AnonymousClass9.onClick(android.view.View):void");
            }
        });
        if (Build.VERSION.SDK_INT > 20) {
            textView.setTextColor(Color.parseColor("#" + this.cbtn));
        }
        if (this.ftipo) {
            Spinner spinner = (Spinner) dialog.findViewById(R.id.sp_tipo);
            ArrayList arrayList = new ArrayList();
            if (this.globales.secciones_a[this.ind_secc].ftipo_ultimos) {
                String str = this.globales.secciones_a[this.ind_secc].txt_ultimos;
                if (str.equals("")) {
                    str = getString(R.string.tipo_ultimos);
                }
                arrayList.add(str);
                this.ftipo_a[0] = 1;
                i2 = this.ftipo_v == 1 ? arrayList.size() - 1 : 0;
                i = 1;
            } else {
                i2 = 0;
                i = 0;
            }
            if (this.globales.secciones_a[this.ind_secc].ftipo_maspuntuados) {
                String str2 = this.globales.secciones_a[this.ind_secc].txt_maspuntuados;
                if (str2.equals("")) {
                    str2 = getString(R.string.tipo_maspuntuados);
                }
                arrayList.add(str2);
                this.ftipo_a[i] = 2;
                i++;
                if (this.ftipo_v == 2) {
                    i2 = arrayList.size() - 1;
                }
            }
            if (this.globales.secciones_a[this.ind_secc].ftipo_masvistos) {
                String str3 = this.globales.secciones_a[this.ind_secc].txt_masvistos;
                if (str3.equals("")) {
                    str3 = getString(R.string.tipo_masvistos);
                }
                arrayList.add(str3);
                this.ftipo_a[i] = 3;
                i++;
                if (this.ftipo_v == 3) {
                    i2 = arrayList.size() - 1;
                }
            }
            if (this.globales.secciones_a[this.ind_secc].ftipo_destacados) {
                String str4 = this.globales.secciones_a[this.ind_secc].txt_destacados;
                if (str4.equals("")) {
                    str4 = getString(R.string.tipo_destacados);
                }
                arrayList.add(str4);
                this.ftipo_a[i] = 4;
                i++;
                if (this.ftipo_v == 4) {
                    i2 = arrayList.size() - 1;
                }
            }
            if (this.globales.secciones_a[this.ind_secc].ftipo_dist) {
                String str5 = this.globales.secciones_a[this.ind_secc].txt_dist;
                if (str5.equals("")) {
                    str5 = getString(R.string.tipo_dist);
                }
                arrayList.add(str5);
                this.ftipo_a[i] = 5;
                i++;
                if (this.ftipo_v == 5) {
                    i2 = arrayList.size() - 1;
                }
            }
            if (this.globales.secciones_a[this.ind_secc].ftipo_favoritos) {
                String str6 = this.globales.secciones_a[this.ind_secc].txt_favoritos;
                if (str6.equals("")) {
                    str6 = getString(R.string.tipo_fav);
                }
                arrayList.add(str6);
                this.ftipo_a[i] = 6;
                i++;
                if (this.ftipo_v == 6) {
                    i2 = arrayList.size() - 1;
                }
            }
            if (!this.soloadmin) {
                String str7 = this.globales.secciones_a[this.ind_secc].txt_propios;
                if (str7.equals("")) {
                    str7 = getString(R.string.tipo_propios);
                }
                arrayList.add(str7);
                this.ftipo_a[i] = 7;
                if (this.ftipo_v == 7) {
                    i2 = arrayList.size() - 1;
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, arrayList);
            arrayAdapter.setDropDownViewResource(17367049);
            spinner.setAdapter(arrayAdapter);
            spinner.setSelection(i2);
            spinner.setVisibility(0);
        }
        if (this.fcat) {
            Spinner spinner2 = (Spinner) dialog.findViewById(R.id.sp_cat);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getString(R.string.todo));
            int i3 = 0;
            for (int i4 = 0; i4 < this.globales.secciones_a[this.ind_secc].cats_buscvideo_a.length; i4++) {
                arrayList2.add(this.globales.secciones_a[this.ind_secc].cats_buscvideo_a[i4].descr);
                if (this.fcat_v == this.globales.secciones_a[this.ind_secc].cats_buscvideo_a[i4].id) {
                    i3 = arrayList2.size() - 1;
                }
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, arrayList2);
            arrayAdapter2.setDropDownViewResource(17367049);
            spinner2.setAdapter(arrayAdapter2);
            spinner2.setSelection(i3);
            spinner2.setVisibility(0);
        }
        return dialog;
    }

    /* access modifiers changed from: package-private */
    public Dialog crear_dialog_nuevovideo() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.buscvideos_nuevo);
        dialog.setTitle(getResources().getString(R.string.enviarvideo));
        ((TextView) dialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                t_buscvideos.this.dialog_nuevovideo.dismiss();
            }
        });
        TextView textView = (TextView) dialog.findViewById(R.id.btn_aceptar);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                int i;
                AlertDialog.Builder builder = new AlertDialog.Builder(t_buscvideos.this);
                boolean z2 = false;
                builder.setCancelable(false).setPositiveButton(t_buscvideos.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null);
                int selectedItemPosition = ((Spinner) t_buscvideos.this.dialog_nuevovideo.findViewById(R.id.sp_cat)).getSelectedItemPosition();
                String str = "";
                if (selectedItemPosition == 0) {
                    builder.setMessage(R.string.falta_cat);
                    final AlertDialog create = builder.create();
                    if (!t_buscvideos.this.cbtn.equals(str)) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_buscvideos.this.cbtn));
                            }
                        });
                    }
                    create.show();
                    try {
                        ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                    } catch (Exception unused) {
                    }
                    i = 0;
                    z = false;
                } else {
                    z = true;
                    int i2 = 0;
                    int i3 = 1;
                    while (i2 < t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].cats_buscvideo_a.length) {
                        if (!t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].cats_buscvideo_a[i2].soloadmin || t_buscvideos.this.globales.es_admin) {
                            if (selectedItemPosition == i3) {
                                break;
                            }
                            i3++;
                        }
                        i2++;
                    }
                    i = t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].cats_buscvideo_a[i2].id;
                }
                if (!z || !t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_descr) {
                    z2 = z;
                } else {
                    String trim = ((EditText) t_buscvideos.this.dialog_nuevovideo.findViewById(R.id.tv_descr)).getText().toString().trim();
                    if (trim.isEmpty()) {
                        builder.setMessage(R.string.falta_descr);
                        final AlertDialog create2 = builder.create();
                        if (!t_buscvideos.this.cbtn.equals(str)) {
                            create2.setOnShowListener(new DialogInterface.OnShowListener() {
                                public void onShow(DialogInterface dialogInterface) {
                                    Button button = create2.getButton(-1);
                                    button.setTextColor(Color.parseColor("#" + t_buscvideos.this.cbtn));
                                }
                            });
                        }
                        create2.show();
                        try {
                            ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                        } catch (Exception unused2) {
                        }
                    } else {
                        z2 = z;
                    }
                    str = trim;
                }
                if (z2) {
                    try {
                        t_buscvideos.this.dialog_nuevovideo.dismiss();
                    } catch (Exception unused3) {
                    }
                    t_buscvideos.this.enviar_video_pre(i, str);
                }
            }
        });
        if (Build.VERSION.SDK_INT > 20) {
            textView.setTextColor(Color.parseColor("#" + this.cbtn));
        }
        Spinner spinner = (Spinner) dialog.findViewById(R.id.sp_cat);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.busc_cat) + "..");
        for (int i = 0; i < this.globales.secciones_a[this.ind_secc].cats_buscvideo_a.length; i++) {
            if (!this.globales.secciones_a[this.ind_secc].cats_buscvideo_a[i].soloadmin || this.globales.es_admin) {
                arrayList.add(this.globales.secciones_a[this.ind_secc].cats_buscvideo_a[i].descr);
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(arrayAdapter);
        if (arrayList.size() < 3) {
            spinner.setSelection(1);
        } else {
            spinner.setSelection(0);
            spinner.setVisibility(0);
        }
        if (this.globales.secciones_a[this.ind_secc].mostrar_descr) {
            dialog.findViewById(R.id.tv_descr).setVisibility(0);
        }
        return dialog;
    }

    /* access modifiers changed from: package-private */
    public void mostrar_filtros() {
        String str;
        if (this.ftipo || this.fcat) {
            findViewById(R.id.ll_filtros).setOnClickListener(this);
            findViewById(R.id.ll_filtros).setVisibility(0);
            if (this.ftipo) {
                int i = this.ftipo_v;
                String str2 = "";
                if (i == 1) {
                    str = this.globales.secciones_a[this.ind_secc].txt_ultimos;
                    if (str.equals(str2)) {
                        str2 = getString(R.string.tipo_ultimos);
                        this.tv_ftipo.setText(str2);
                        this.tv_ftipo.setVisibility(0);
                    }
                } else if (i == 2) {
                    str = this.globales.secciones_a[this.ind_secc].txt_maspuntuados;
                    if (str.equals(str2)) {
                        str2 = getString(R.string.tipo_maspuntuados);
                        this.tv_ftipo.setText(str2);
                        this.tv_ftipo.setVisibility(0);
                    }
                } else if (i == 3) {
                    str = this.globales.secciones_a[this.ind_secc].txt_masvistos;
                    if (str.equals(str2)) {
                        str2 = getString(R.string.tipo_masvistos);
                        this.tv_ftipo.setText(str2);
                        this.tv_ftipo.setVisibility(0);
                    }
                } else if (i == 4) {
                    str = this.globales.secciones_a[this.ind_secc].txt_destacados;
                    if (str.equals(str2)) {
                        str2 = getString(R.string.tipo_destacados);
                        this.tv_ftipo.setText(str2);
                        this.tv_ftipo.setVisibility(0);
                    }
                } else if (i == 5) {
                    str = this.globales.secciones_a[this.ind_secc].txt_dist;
                    if (str.equals(str2)) {
                        str2 = getString(R.string.tipo_dist);
                        this.tv_ftipo.setText(str2);
                        this.tv_ftipo.setVisibility(0);
                    }
                } else if (i == 6) {
                    str = this.globales.secciones_a[this.ind_secc].txt_favoritos;
                    if (str.equals(str2)) {
                        str2 = getString(R.string.tipo_fav);
                        this.tv_ftipo.setText(str2);
                        this.tv_ftipo.setVisibility(0);
                    }
                } else {
                    if (i == 7) {
                        str = this.globales.secciones_a[this.ind_secc].txt_propios;
                        if (str.equals(str2)) {
                            str2 = getString(R.string.tipo_propios);
                        }
                    }
                    this.tv_ftipo.setText(str2);
                    this.tv_ftipo.setVisibility(0);
                }
                str2 = str;
                this.tv_ftipo.setText(str2);
                this.tv_ftipo.setVisibility(0);
            } else {
                this.tv_ftipo.setVisibility(8);
            }
            if (this.fcat) {
                if (this.fcat_ind == 0) {
                    this.tv_fcat.setText(getString(R.string.todo));
                } else {
                    this.tv_fcat.setText(this.globales.secciones_a[this.ind_secc].cats_buscvideo_a[this.fcat_ind - 1].descr);
                }
                this.tv_fcat.setVisibility(0);
            } else {
                this.tv_fcat.setVisibility(8);
            }
            findViewById(R.id.tv_filtrar).setVisibility(8);
            return;
        }
        findViewById(R.id.ll_filtros).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void enviar_video_pre(int i, String str) {
        int i2 = 100;
        while (this.globales.getTempFile(this, i2).exists()) {
            i2++;
        }
        this.globales.getTempFile(this, 99).renameTo(this.globales.getTempFile(this, i2));
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this, Uri.parse(this.path_glob));
            new enviar_video(i2, this.path_glob, i, str, mediaMetadataRetriever.extractMetadata(23)).execute(new String[0]);
        } catch (Exception unused) {
        }
    }

    private class enviar_video extends AsyncTask<String, Void, String> {
        String descr;
        int id_temp;
        int idcat;
        String loc;
        String videoPath;

        public enviar_video(int i, String str, int i2, String str2, String str3) {
            this.videoPath = str;
            this.id_temp = i;
            this.idcat = i2;
            this.descr = str2;
            this.loc = str3;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_buscvideos.this.d_video = new ProgressDialog(t_buscvideos.this);
            t_buscvideos.this.d_video.setMessage(t_buscvideos.this.getString(R.string.subiendo));
            t_buscvideos.this.d_video.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20 && !t_buscvideos.this.cbtn.equals("")) {
                t_buscvideos.this.d_video.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) t_buscvideos.this.d_video.findViewById(16908301), t_buscvideos.this.cbtn);
                    }
                });
            }
            t_buscvideos.this.d_video.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            String str = "";
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.PROTOC_GEN + "video-upload." + config.DOM_EDROID + "/upload.php?busc=1&ida=3008836");
            FileBody fileBody = new FileBody(new File(this.videoPath));
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("videoFile", fileBody);
            try {
                multipartEntity.addPart("idusu", new StringBody(t_buscvideos.this.idusu + str));
                multipartEntity.addPart("idapp", new StringBody("3008836"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                if (entity != null) {
                    str = EntityUtils.toString(entity);
                }
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            int indexOf = str.indexOf("ANDROID:OK:-");
            boolean z = false;
            if (indexOf != -1) {
                int i = indexOf + 12;
                int indexOf2 = str.indexOf("-", i + 1);
                String substring = str.substring(i, indexOf2);
                int i2 = indexOf2 + 1;
                String substring2 = str.substring(i2, str.indexOf("-", i2));
                if (substring2.equals("1")) {
                    str2 = "mp4";
                } else if (substring2.equals("2")) {
                    str2 = "3gp";
                } else {
                    str2 = substring2.equals(ExifInterface.GPS_MEASUREMENT_3D) ? "webm" : "";
                }
                if (!str2.isEmpty()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.videoPath);
                        config config = t_buscvideos.this.globales;
                        t_buscvideos t_buscvideos = t_buscvideos.this;
                        String absolutePath = config.getTempFile_libre(t_buscvideos, "vb" + substring + "." + str2).getAbsolutePath();
                        FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.videoPath = absolutePath;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    new enviar_thumb(this.id_temp, substring, substring2, this.idcat, this.descr, this.loc).execute(new String[0]);
                    z = true;
                }
            }
            if (!z) {
                try {
                    t_buscvideos.this.d_video.dismiss();
                } catch (Exception unused) {
                }
            }
        }
    }

    private class enviar_thumb extends AsyncTask<String, Void, String> {
        String descr;
        String formato;
        int id_temp;
        int idcat;
        String idvideo;
        String loc;

        public enviar_thumb(int i, String str, String str2, int i2, String str3, String str4) {
            this.id_temp = i;
            this.idvideo = str;
            this.formato = str2;
            this.idcat = i2;
            this.descr = str3;
            this.loc = str4;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            Bitmap bitmap;
            String str = "";
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/guardar_videobusc.php");
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(t_buscvideos.this.getContentResolver(), Uri.fromFile(t_buscvideos.this.globales.getTempFile(t_buscvideos.this, this.id_temp)));
            } catch (IOException e) {
                e.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
                return "KO";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            multipartEntity.addPart("thumb", new ByteArrayBody(byteArrayOutputStream.toByteArray(), "temporal.jpg"));
            try {
                multipartEntity.addPart("idusu", new StringBody(t_buscvideos.this.idusu + str));
                multipartEntity.addPart("c", new StringBody(t_buscvideos.this.codigo));
                multipartEntity.addPart("idvideo", new StringBody(this.idvideo));
                multipartEntity.addPart("formato", new StringBody(this.formato));
                multipartEntity.addPart("idcat", new StringBody(this.idcat + str));
                multipartEntity.addPart("descr", new StringBody(URLEncoder.encode(this.descr, "UTF-8")));
                if (this.loc != null) {
                    multipartEntity.addPart("loc", new StringBody(this.loc));
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                str = EntityUtils.toString(entity);
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            int i;
            try {
                t_buscvideos.this.d_video.cancel();
            } catch (Exception unused) {
            }
            if (str.indexOf("ANDROID:OK ID:") != -1) {
                i = t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].req_aprob ? R.string.req_aprob_video : R.string.video_publicado;
                if ((t_buscvideos.this.fcat_v == 0 || t_buscvideos.this.fcat_v == this.idcat) && (!t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].req_aprob || t_buscvideos.this.ftipo_v == 7)) {
                    t_buscvideos.this.act_lista();
                }
            } else {
                i = R.string.error_http;
            }
            final AlertDialog create = new AlertDialog.Builder(t_buscvideos.this).setCancelable(false).setPositiveButton(t_buscvideos.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(i).create();
            if (!t_buscvideos.this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + t_buscvideos.this.cbtn));
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused2) {
            }
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private ArrayList<claseBuscvideo> items;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView iv1;
            public LinearLayout ll_fila;
            public LinearLayout ll_videolikes;
            public LinearLayout ll_videovistos;
            public TextView tt;
            public TextView tt2;
            public TextView tt3;
            public TextView tt4;
            public TextView tt5;
            public TextView tt_videolikes;
            public TextView tt_videovistos;
            public ImageView videoplay;
            public ImageView videouser;

            public ViewHolder(View view) {
                super(view);
                this.ll_fila = (LinearLayout) view.findViewById(R.id.fila);
                this.tt = (TextView) view.findViewById(R.id.videoDescr);
                this.tt2 = (TextView) view.findViewById(R.id.videoName);
                this.tt3 = (TextView) view.findViewById(R.id.videoDate);
                if (!t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_descr) {
                    this.tt.setVisibility(8);
                }
                if (!t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_nombre) {
                    this.tt2.setVisibility(8);
                }
                if (!t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_fecha) {
                    this.tt3.setVisibility(8);
                }
                this.tt4 = (TextView) view.findViewById(R.id.videoDist);
                this.tt5 = (TextView) view.findViewById(R.id.videoEstado);
                this.ll_videolikes = (LinearLayout) view.findViewById(R.id.ll_videoLikes);
                this.ll_videovistos = (LinearLayout) view.findViewById(R.id.ll_videoVistos);
                this.tt_videolikes = (TextView) view.findViewById(R.id.videoLikes);
                this.tt_videovistos = (TextView) view.findViewById(R.id.videoVistos);
                this.iv1 = (ImageView) view.findViewById(R.id.videoThumb);
                if (t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].formato == 1) {
                    this.iv1.getLayoutParams().height = t_buscvideos.this.h_thumb;
                }
                this.videoplay = (ImageView) view.findViewById(R.id.videoPlay);
                this.videouser = (ImageView) view.findViewById(R.id.videoUser);
            }
        }

        public MyAdapter(ArrayList<claseBuscvideo> arrayList) {
            this.items = arrayList;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Drawable drawable;
            Drawable drawable2;
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].formato == 1 ? R.layout.buscvideos_item_2 : R.layout.buscvideos_item, viewGroup, false);
            if (t_buscvideos.this.c1_esclaro) {
                drawable = t_buscvideos.this.getResources().getDrawable(R.drawable.like_black);
                drawable2 = t_buscvideos.this.getResources().getDrawable(R.drawable.eye_black);
                inflate.findViewById(R.id.videoDescrSep).setBackgroundColor(config.NEGRO);
                ((TextView) inflate.findViewById(R.id.videoDescr)).setTextColor(config.NEGRO);
                ((TextView) inflate.findViewById(R.id.videoName)).setTextColor(config.NEGRO_2);
                ((TextView) inflate.findViewById(R.id.videoDate)).setTextColor(config.NEGRO_2);
                ((TextView) inflate.findViewById(R.id.videoDist)).setTextColor(config.NEGRO_2);
                ((TextView) inflate.findViewById(R.id.videoEstado)).setTextColor(config.NEGRO_2);
                ((TextView) inflate.findViewById(R.id.videoLikes)).setTextColor(config.NEGRO_2);
                ((TextView) inflate.findViewById(R.id.videoVistos)).setTextColor(config.NEGRO_2);
            } else {
                drawable = t_buscvideos.this.getResources().getDrawable(R.drawable.like);
                drawable2 = t_buscvideos.this.getResources().getDrawable(R.drawable.eye);
                inflate.findViewById(R.id.videoDescrSep).setBackgroundColor(config.BLANCO);
                ((TextView) inflate.findViewById(R.id.videoDescr)).setTextColor(config.BLANCO);
                ((TextView) inflate.findViewById(R.id.videoName)).setTextColor(config.BLANCO_2);
                ((TextView) inflate.findViewById(R.id.videoDate)).setTextColor(config.BLANCO_2);
                ((TextView) inflate.findViewById(R.id.videoDist)).setTextColor(config.BLANCO_2);
                ((TextView) inflate.findViewById(R.id.videoEstado)).setTextColor(config.BLANCO_2);
                ((TextView) inflate.findViewById(R.id.videoLikes)).setTextColor(config.BLANCO_2);
                ((TextView) inflate.findViewById(R.id.videoVistos)).setTextColor(config.BLANCO_2);
            }
            ((ImageView) inflate.findViewById(R.id.iv_videoLikes)).setImageDrawable(drawable);
            ((ImageView) inflate.findViewById(R.id.iv_videoVistos)).setImageDrawable(drawable2);
            if (!t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_descr) {
                inflate.findViewById(R.id.videoDescrSep).setVisibility(8);
            }
            if (t_buscvideos.this.fotos_perfil == 0 || !t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_nombre) {
                inflate.findViewById(R.id.videoUser).setVisibility(8);
            }
            inflate.setOnClickListener(t_buscvideos.this);
            return new ViewHolder(inflate);
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            String str;
            String str2;
            claseBuscvideo clasebuscvideo = this.items.get(i);
            if (t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_descr) {
                if (clasebuscvideo.descr.equals("")) {
                    viewHolder.tt.setVisibility(8);
                } else {
                    viewHolder.tt.setText(clasebuscvideo.descr);
                    viewHolder.tt.setVisibility(0);
                }
            }
            if (clasebuscvideo.idusu == t_buscvideos.this.idusu) {
                viewHolder.tt2.setText(t_buscvideos.this.getString(R.string.tu));
            } else {
                viewHolder.tt2.setText(clasebuscvideo.nombre);
            }
            viewHolder.tt3.setText(clasebuscvideo.fcrea);
            if (t_buscvideos.this.ftipo_v != 5 || !t_buscvideos.this.idusuv.equals("")) {
                viewHolder.tt4.setVisibility(8);
            } else {
                int i2 = clasebuscvideo.dist;
                if (t_buscvideos.this.pais.equals("US") || t_buscvideos.this.pais.equals("GB") || t_buscvideos.this.pais.equals("MM")) {
                    double d = (double) i2;
                    Double.isNaN(d);
                    i2 = (int) (d / 1.6d);
                    str2 = "mi.";
                } else {
                    str2 = "km.";
                }
                if (i2 == 0) {
                    viewHolder.tt4.setText("<1".concat(str2));
                } else {
                    TextView textView = viewHolder.tt4;
                    textView.setText(i2 + str2);
                }
                viewHolder.tt4.setVisibility(0);
            }
            if (t_buscvideos.this.ftipo_v != 2) {
                viewHolder.ll_videolikes.setVisibility(8);
            } else {
                TextView textView2 = viewHolder.tt_videolikes;
                textView2.setText(clasebuscvideo.nlikes + "");
                viewHolder.ll_videolikes.setVisibility(0);
            }
            if (t_buscvideos.this.ftipo_v != 3) {
                viewHolder.ll_videovistos.setVisibility(8);
            } else {
                TextView textView3 = viewHolder.tt_videovistos;
                textView3.setText(clasebuscvideo.nvistos + "");
                viewHolder.ll_videovistos.setVisibility(0);
            }
            if (t_buscvideos.this.ftipo_v != 7) {
                viewHolder.tt5.setVisibility(8);
            } else {
                GradientDrawable gradientDrawable = (GradientDrawable) viewHolder.tt5.getBackground();
                if (clasebuscvideo.revisado == 0) {
                    viewHolder.tt5.setText(t_buscvideos.this.getString(R.string.pendiente));
                    str = t_buscvideos.this.c1_esclaro ? "#EF6C00" : "#FF9800";
                } else if (clasebuscvideo.revisado == 1) {
                    viewHolder.tt5.setText(t_buscvideos.this.getString(R.string.aprobado));
                    str = t_buscvideos.this.c1_esclaro ? "#1B5E20" : "#81C784";
                } else if (clasebuscvideo.revisado == 2) {
                    viewHolder.tt5.setText(t_buscvideos.this.getString(R.string.rechazado));
                    str = t_buscvideos.this.c1_esclaro ? "#B71C1C" : "#E53935";
                } else {
                    viewHolder.tt5.setText("");
                    str = "";
                }
                if (!str.equals("")) {
                    viewHolder.tt5.setTextColor(Color.parseColor(str));
                    gradientDrawable.setStroke(t_buscvideos.this.dp1, Color.parseColor(str));
                }
                viewHolder.tt5.setVisibility(0);
            }
            File file = t_buscvideos.this.path;
            File file2 = new File(file, "fbuscvideo_" + clasebuscvideo.id + ".jpg");
            if (!file2.exists()) {
                viewHolder.videoplay.setVisibility(8);
                if (clasebuscvideo.cargada_1) {
                    viewHolder.iv1.setImageDrawable((Drawable) null);
                } else if (t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].formato == 0) {
                    viewHolder.iv1.setImageDrawable(t_buscvideos.this.getResources().getDrawable(R.drawable.cargando));
                } else {
                    viewHolder.iv1.setImageDrawable(t_buscvideos.this.getResources().getDrawable(R.drawable.cargando_2));
                }
            } else {
                viewHolder.videoplay.setVisibility(0);
                try {
                    if (!clasebuscvideo.mostrado) {
                        viewHolder.iv1.setVisibility(4);
                    }
                    viewHolder.iv1.setImageBitmap(MediaStore.Images.Media.getBitmap(t_buscvideos.this.getContentResolver(), Uri.fromFile(file2)));
                    if (!clasebuscvideo.mostrado) {
                        clasebuscvideo.mostrado = true;
                        config.fade_in(viewHolder.iv1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            if (t_buscvideos.this.fotos_perfil > 0 && t_buscvideos.this.globales.secciones_a[t_buscvideos.this.ind_secc].mostrar_nombre) {
                int indexOf = t_buscvideos.this.usus_ids_a.indexOf(Long.valueOf(clasebuscvideo.idusu));
                if (indexOf != -1) {
                    Usu usu = t_buscvideos.this.usus_a.get(indexOf);
                    if (usu.foto == null) {
                        viewHolder.videouser.setImageBitmap(t_buscvideos.this.sinfoto);
                    } else {
                        viewHolder.videouser.setImageBitmap(usu.foto);
                    }
                } else {
                    viewHolder.videouser.setImageBitmap(t_buscvideos.this.sinfoto);
                }
            }
            viewHolder.ll_fila.setTag(Integer.valueOf(i));
            if (t_buscvideos.this.haymas && i == t_buscvideos.this.m_orders.size() - 1) {
                if (t_buscvideos.this.thread == null || !t_buscvideos.this.thread.isAlive()) {
                    t_buscvideos.this.findViewById(R.id.pb_videos).setVisibility(0);
                    t_buscvideos.this.thread = new Thread((ThreadGroup) null, t_buscvideos.this.viewOrders, "buscandoelems");
                    t_buscvideos.this.thread.start();
                }
            }
        }

        public int getItemCount() {
            return this.items.size();
        }
    }

    /* JADX WARNING: type inference failed for: r0v39, types: [java.net.URLConnection] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x03a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getOrders() {
        /*
            r33 = this;
            r1 = r33
            java.lang.String r2 = ""
            r3 = 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.<init>()     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "/srv/obtener_buscvideos.php?idusu="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            long r5 = r1.idusu     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "&c="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = r1.codigo     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "&idsec="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            int r5 = r1.idsec     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "&tipo="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            int r5 = r1.ftipo_v     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "&idcat="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            int r5 = r1.fcat_v     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "&idusuv="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = r1.idusuv     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r5 = "&fila="
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r5 = r1.m_orders     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r0.append(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.net.URLConnection r0 = r5.openConnection()     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r5 = r0
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            r5.setDoInput(r3)     // Catch:{ Exception -> 0x00b4 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r5.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00b4 }
            r5.setReadTimeout(r0)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r0 = "User-Agent"
            java.lang.String r6 = "Android Vinebre Software"
            r5.setRequestProperty(r0, r6)     // Catch:{ Exception -> 0x00b4 }
            java.io.InputStream r0 = r5.getInputStream()     // Catch:{ Exception -> 0x00b4 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b4 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b4 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x00b4 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00b4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b4 }
            r0.<init>()     // Catch:{ Exception -> 0x00b4 }
        L_0x008e:
            java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x00b4 }
            if (r7 == 0) goto L_0x00a9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b4 }
            r8.<init>()     // Catch:{ Exception -> 0x00b4 }
            r8.append(r7)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r7 = "\n"
            r8.append(r7)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x00b4 }
            r0.append(r7)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x008e
        L_0x00a9:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b4 }
            if (r5 == 0) goto L_0x00b2
            r5.disconnect()
        L_0x00b2:
            r5 = r0
            goto L_0x00c5
        L_0x00b4:
            r0 = move-exception
            goto L_0x00bc
        L_0x00b6:
            r0 = move-exception
            r4 = 0
            goto L_0x03a1
        L_0x00ba:
            r0 = move-exception
            r5 = 0
        L_0x00bc:
            r0.printStackTrace()     // Catch:{ all -> 0x039f }
            if (r5 == 0) goto L_0x00c4
            r5.disconnect()
        L_0x00c4:
            r5 = r2
        L_0x00c5:
            java.lang.String r0 = "ANDROID:OK RESULT:"
            int r0 = r5.indexOf(r0)
            r6 = 0
            r1.obtencion_ok = r6
            r7 = -1
            if (r0 == r7) goto L_0x0399
            android.content.SharedPreferences r8 = r1.settings
            android.content.SharedPreferences$Editor r8 = r8.edit()
            r1.obtencion_ok = r3
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r1.m_orders_temp = r9
            java.lang.String r9 = "ANDROID:OK RESULT:0"
            int r9 = r5.indexOf(r9)
            if (r9 == r7) goto L_0x00eb
            r1.haymas = r6
            goto L_0x00f5
        L_0x00eb:
            java.lang.String r9 = "ANDROID:OK RESULT:1"
            int r9 = r5.indexOf(r9)
            if (r9 == r7) goto L_0x00f5
            r1.haymas = r3
        L_0x00f5:
            java.lang.String r9 = "@y@"
            int r0 = r5.indexOf(r9, r0)
            r10 = 0
        L_0x00fc:
            if (r0 == r7) goto L_0x0376
            int r0 = r0 + 3
            java.lang.String r11 = ";"
            int r12 = r5.indexOf(r11, r0)
            java.lang.String r0 = r5.substring(r0, r12)
            int r13 = java.lang.Integer.parseInt(r0)
            int r12 = r12 + r3
            int r0 = r5.indexOf(r11, r12)
            java.lang.String r12 = r5.substring(r12, r0)
            long r14 = java.lang.Long.parseLong(r12)
            int r0 = r0 + r3
            int r12 = r5.indexOf(r11, r0)
            java.lang.String r0 = r5.substring(r0, r12)
            int r12 = r12 + r3
            int r6 = r5.indexOf(r11, r12)
            java.lang.String r12 = r5.substring(r12, r6)
            int r6 = r6 + r3
            int r4 = r5.indexOf(r11, r6)
            java.lang.String r6 = r5.substring(r6, r4)
            int r4 = r4 + r3
            int r7 = r5.indexOf(r11, r4)
            java.lang.String r4 = r5.substring(r4, r7)
            int r7 = r7 + r3
            int r3 = r5.indexOf(r11, r7)
            java.lang.String r7 = r5.substring(r7, r3)
            int r7 = java.lang.Integer.parseInt(r7)
            r16 = 1
            int r3 = r3 + 1
            r17 = r10
            int r10 = r5.indexOf(r11, r3)
            java.lang.String r3 = r5.substring(r3, r10)
            int r3 = java.lang.Integer.parseInt(r3)
            int r10 = r10 + 1
            r18 = r8
            int r8 = r5.indexOf(r11, r10)
            java.lang.String r10 = r5.substring(r10, r8)
            r19 = r9
            java.lang.String r9 = "1"
            boolean r9 = r10.equals(r9)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            int r8 = r8 + 1
            int r10 = r5.indexOf(r11, r8)
            java.lang.String r8 = r5.substring(r8, r10)
            int r8 = java.lang.Integer.parseInt(r8)
            int r10 = r10 + 1
            r20 = r8
            int r8 = r5.indexOf(r11, r10)
            java.lang.String r10 = r5.substring(r10, r8)
            int r10 = java.lang.Integer.parseInt(r10)
            int r8 = r8 + 1
            r21 = r10
            int r10 = r5.indexOf(r11, r8)
            java.lang.String r8 = r5.substring(r8, r10)
            int r10 = r10 + 1
            r22 = r9
            int r9 = r5.indexOf(r11, r10)
            java.lang.String r10 = r5.substring(r10, r9)
            int r9 = r9 + 1
            r23 = r10
            int r10 = r5.indexOf(r11, r9)
            java.lang.String r9 = r5.substring(r9, r10)
            int r10 = r10 + 1
            r24 = r9
            int r9 = r5.indexOf(r11, r10)
            java.lang.String r10 = r5.substring(r10, r9)
            int r9 = r9 + 1
            r25 = r10
            int r10 = r5.indexOf(r11, r9)
            java.lang.String r9 = r5.substring(r9, r10)
            int r10 = r10 + 1
            r26 = r9
            int r9 = r5.indexOf(r11, r10)
            java.lang.String r10 = r5.substring(r10, r9)
            int r9 = r9 + 1
            r27 = r10
            int r10 = r5.indexOf(r11, r9)
            java.lang.String r9 = r5.substring(r9, r10)
            int r10 = r10 + 1
            int r11 = r5.indexOf(r11, r10)
            java.lang.String r10 = r5.substring(r10, r11)
            r28 = r5
            java.util.ArrayList<java.lang.Long> r5 = r1.usus_ids_a
            r29 = r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)
            int r5 = r5.indexOf(r11)
            java.lang.String r11 = ".jpg"
            r30 = r10
            r10 = -1
            if (r5 != r10) goto L_0x0270
            java.util.ArrayList<java.lang.Long> r5 = r1.usus_ids_a
            java.lang.Long r10 = java.lang.Long.valueOf(r14)
            r5.add(r10)
            stikerwap.appdys.t_buscvideos$Usu r5 = new stikerwap.appdys.t_buscvideos$Usu
            r10 = 0
            r5.<init>()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r14)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r5.id = r10
            r5.vfoto = r8
            int r8 = java.lang.Integer.parseInt(r8)
            if (r8 <= 0) goto L_0x0265
            java.io.File r8 = new java.io.File
            java.io.File r10 = r1.path
            r31 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r32 = r9
            java.lang.String r9 = "fperfil_"
            r2.<init>(r9)
            r2.append(r14)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r8.<init>(r10, r2)
            boolean r2 = r8.exists()
            if (r2 == 0) goto L_0x0269
            android.content.ContentResolver r2 = r33.getContentResolver()     // Catch:{ Exception -> 0x0269 }
            android.net.Uri r8 = android.net.Uri.fromFile(r8)     // Catch:{ Exception -> 0x0269 }
            android.graphics.Bitmap r2 = android.provider.MediaStore.Images.Media.getBitmap(r2, r8)     // Catch:{ Exception -> 0x0269 }
            r8 = 1
            android.graphics.Bitmap r2 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r2, r8)     // Catch:{ Exception -> 0x0269 }
            r5.foto = r2     // Catch:{ Exception -> 0x0269 }
            goto L_0x0269
        L_0x0265:
            r31 = r2
            r32 = r9
        L_0x0269:
            java.util.ArrayList<stikerwap.appdys.t_buscvideos$Usu> r2 = r1.usus_a
            r2.add(r5)
            r10 = 1
            goto L_0x0276
        L_0x0270:
            r31 = r2
            r32 = r9
            r10 = r17
        L_0x0276:
            stikerwap.appdys.claseBuscvideo r2 = new stikerwap.appdys.claseBuscvideo
            r2.<init>()
            r2.id = r13
            r2.idusu = r14
            r2.descr = r0
            r2.nombre = r12
            java.lang.String r5 = stikerwap.appdys.config.convertir_fecha(r6)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r6 = "ddMMyy"
            r0.<init>(r6)
            r6 = 6
            r8 = 0
            java.lang.String r9 = r5.substring(r8, r6)     // Catch:{ Exception -> 0x029a }
            java.util.Date r0 = r0.parse(r9)     // Catch:{ Exception -> 0x029a }
            r8 = 1
            goto L_0x02a0
        L_0x029a:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
            r8 = 0
        L_0x02a0:
            if (r8 == 0) goto L_0x0308
            java.util.Calendar r8 = java.util.Calendar.getInstance()
            java.util.Calendar r9 = java.util.Calendar.getInstance()
            r9.setTime(r0)
            r12 = 1
            int r14 = r9.get(r12)
            int r15 = r8.get(r12)
            if (r14 != r15) goto L_0x02ce
            int r9 = r9.get(r6)
            int r8 = r8.get(r6)
            if (r9 != r8) goto L_0x02ce
            android.content.res.Resources r0 = r33.getResources()
            r8 = 2131886471(0x7f120187, float:1.9407522E38)
            java.lang.String r0 = r0.getString(r8)
            goto L_0x02d6
        L_0x02ce:
            java.text.DateFormat r8 = android.text.format.DateFormat.getDateFormat(r33)
            java.lang.String r0 = r8.format(r0)
        L_0x02d6:
            r8 = 10
            java.lang.String r5 = r5.substring(r6, r8)
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat
            java.lang.String r8 = "HHmm"
            r6.<init>(r8)
            java.util.Date r5 = r6.parse(r5)     // Catch:{ Exception -> 0x0304 }
            java.text.DateFormat r6 = android.text.format.DateFormat.getTimeFormat(r33)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r5 = r6.format(r5)     // Catch:{ Exception -> 0x0304 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0304 }
            r6.<init>()     // Catch:{ Exception -> 0x0304 }
            r6.append(r0)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r0 = " "
            r6.append(r0)     // Catch:{ Exception -> 0x0304 }
            r6.append(r5)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0304 }
            goto L_0x030a
        L_0x0304:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0308:
            r0 = r31
        L_0x030a:
            r2.fcrea = r0
            r2.formato = r4
            r2.nlikes = r7
            r2.nvistos = r3
            boolean r0 = r22.booleanValue()
            r2.liked = r0
            r3 = r20
            r2.dist = r3
            r3 = r21
            r2.revisado = r3
            r3 = 1
            r2.nfoto1 = r3
            java.io.File r0 = new java.io.File
            java.io.File r4 = r1.path
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "fbuscvideo_"
            r5.<init>(r6)
            r5.append(r13)
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            r0.<init>(r4, r5)
            boolean r0 = r0.exists()
            r2.cargada_1 = r0
            r4 = r23
            r2.coments = r4
            r4 = r24
            r2.fnac_d = r4
            r4 = r25
            r2.fnac_m = r4
            r4 = r26
            r2.fnac_a = r4
            r4 = r27
            r2.sexo = r4
            r4 = r32
            r2.privados = r4
            r4 = r30
            r2.nvideos = r4
            java.util.ArrayList<stikerwap.appdys.claseBuscvideo> r0 = r1.m_orders_temp
            r0.add(r2)
            r5 = r19
            r2 = r28
            r4 = r29
            int r0 = r2.indexOf(r5, r4)
            r9 = r5
            r8 = r18
            r6 = 0
            r7 = -1
            r5 = r2
            r2 = r31
            goto L_0x00fc
        L_0x0376:
            r18 = r8
            r17 = r10
            r18.commit()
            if (r17 == 0) goto L_0x0399
            stikerwap.appdys.t_buscvideos$cargar_fotos r0 = r1.c_f
            if (r0 == 0) goto L_0x038b
            android.os.AsyncTask$Status r0 = r0.getStatus()
            android.os.AsyncTask$Status r2 = android.os.AsyncTask.Status.RUNNING
            if (r0 == r2) goto L_0x0399
        L_0x038b:
            stikerwap.appdys.t_buscvideos$cargar_fotos r0 = new stikerwap.appdys.t_buscvideos$cargar_fotos
            r2 = 0
            r0.<init>()
            r1.c_f = r0
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            r0.execute(r2)
        L_0x0399:
            java.lang.Runnable r0 = r1.returnRes
            r1.runOnUiThread(r0)
            return
        L_0x039f:
            r0 = move-exception
            r4 = r5
        L_0x03a1:
            if (r4 == 0) goto L_0x03a6
            r4.disconnect()
        L_0x03a6:
            goto L_0x03a8
        L_0x03a7:
            throw r0
        L_0x03a8:
            goto L_0x03a7
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.getOrders():void");
    }

    private class cargar_foto_async extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        int f;
        long idusuv;
        int idv;
        int ind;

        private cargar_foto_async() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= t_buscvideos.this.m_orders.size()) {
                    break;
                }
                claseBuscvideo clasebuscvideo = (claseBuscvideo) t_buscvideos.this.m_orders.get(i);
                if (!clasebuscvideo.cargada_1 && clasebuscvideo.nfoto1 != 0) {
                    this.f = 1;
                    this.ind = i;
                    this.idv = clasebuscvideo.id;
                    this.idusuv = clasebuscvideo.idusu;
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
        public String doInBackground(String... strArr) {
            URL url;
            try {
                url = new URL(config.DOM_CDN + "/srv/imgs/videos_busc/v" + this.idv + "_" + this.idusuv + "_th.jpg?ida=3008836");
            } catch (MalformedURLException unused) {
                url = null;
            } catch (Exception unused2) {
                return "ANDROID:KO";
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(7000);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                inputStream.close();
                httpURLConnection.disconnect();
                int round = Math.round(TypedValue.applyDimension(1, 200.0f, t_buscvideos.this.getResources().getDisplayMetrics()));
                options.inSampleSize = config.calculateInSampleSize(options, round, round);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(7000);
                httpURLConnection2.connect();
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                options.inJustDecodeBounds = false;
                this.bmImg = BitmapFactory.decodeStream(inputStream2, (Rect) null, options);
                inputStream2.close();
                return "ANDROID:OK";
            } catch (Exception unused3) {
                return "ANDROID:KO";
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(1:4)|5|(3:9|10|11)|12|13|15) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x004e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r5) {
            /*
                r4 = this;
                java.lang.String r0 = "fbuscvideo_"
                int r1 = r4.f     // Catch:{ Exception -> 0x006d }
                r2 = 1
                if (r1 != r2) goto L_0x0017
                stikerwap.appdys.t_buscvideos r1 = stikerwap.appdys.t_buscvideos.this     // Catch:{ Exception -> 0x006d }
                java.util.ArrayList r1 = r1.m_orders     // Catch:{ Exception -> 0x006d }
                int r3 = r4.ind     // Catch:{ Exception -> 0x006d }
                java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x006d }
                stikerwap.appdys.claseBuscvideo r1 = (stikerwap.appdys.claseBuscvideo) r1     // Catch:{ Exception -> 0x006d }
                r1.cargada_1 = r2     // Catch:{ Exception -> 0x006d }
            L_0x0017:
                java.lang.String r1 = "ANDROID:OK"
                int r5 = r5.indexOf(r1)     // Catch:{ Exception -> 0x006d }
                r1 = -1
                if (r5 == r1) goto L_0x004e
                int r5 = r4.f     // Catch:{ Exception -> 0x006d }
                if (r5 != r2) goto L_0x004e
                java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x006d }
                stikerwap.appdys.t_buscvideos r1 = stikerwap.appdys.t_buscvideos.this     // Catch:{ Exception -> 0x006d }
                java.io.File r1 = r1.path     // Catch:{ Exception -> 0x006d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006d }
                r2.<init>(r0)     // Catch:{ Exception -> 0x006d }
                int r0 = r4.idv     // Catch:{ Exception -> 0x006d }
                r2.append(r0)     // Catch:{ Exception -> 0x006d }
                java.lang.String r0 = ".jpg"
                r2.append(r0)     // Catch:{ Exception -> 0x006d }
                java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x006d }
                r5.<init>(r1, r0)     // Catch:{ Exception -> 0x006d }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004e }
                r0.<init>(r5)     // Catch:{ Exception -> 0x004e }
                android.graphics.Bitmap r5 = r4.bmImg     // Catch:{ Exception -> 0x004e }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x004e }
                r2 = 70
                r5.compress(r1, r2, r0)     // Catch:{ Exception -> 0x004e }
            L_0x004e:
                stikerwap.appdys.t_buscvideos r5 = stikerwap.appdys.t_buscvideos.this     // Catch:{ Exception -> 0x006d }
                androidx.recyclerview.widget.RecyclerView$Adapter r5 = r5.mAdapter     // Catch:{ Exception -> 0x006d }
                r5.notifyDataSetChanged()     // Catch:{ Exception -> 0x006d }
                stikerwap.appdys.t_buscvideos r5 = stikerwap.appdys.t_buscvideos.this     // Catch:{ Exception -> 0x006d }
                stikerwap.appdys.t_buscvideos$cargar_foto_async r0 = new stikerwap.appdys.t_buscvideos$cargar_foto_async     // Catch:{ Exception -> 0x006d }
                r0.<init>()     // Catch:{ Exception -> 0x006d }
                r5.cfa = r0     // Catch:{ Exception -> 0x006d }
                stikerwap.appdys.t_buscvideos r5 = stikerwap.appdys.t_buscvideos.this     // Catch:{ Exception -> 0x006d }
                stikerwap.appdys.t_buscvideos$cargar_foto_async r5 = r5.cfa     // Catch:{ Exception -> 0x006d }
                r0 = 0
                java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x006d }
                r5.execute(r0)     // Catch:{ Exception -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.cargar_foto_async.onPostExecute(java.lang.String):void");
        }
    }

    private class cargar_fotos extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        int i_cargando;
        String idusu_acargar;
        String vfoto_bd;

        private cargar_fotos() {
            this.i_cargando = -1;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            int i = 0;
            while (i <= t_buscvideos.this.usus_a.size() && t_buscvideos.this.usus_a != null && i < t_buscvideos.this.usus_a.size()) {
                if (t_buscvideos.this.usus_a.get(i).foto_pendiente && !t_buscvideos.this.usus_a.get(i).vfoto.equals("0")) {
                    String str = t_buscvideos.this.usus_a.get(i).vfoto;
                    SharedPreferences sharedPreferences = t_buscvideos.this.settings;
                    if (!str.equals(sharedPreferences.getString("fperfil_" + t_buscvideos.this.usus_a.get(i).id, "0"))) {
                        this.idusu_acargar = t_buscvideos.this.usus_a.get(i).id + "";
                        this.vfoto_bd = t_buscvideos.this.usus_a.get(i).vfoto;
                        t_buscvideos.this.usus_a.get(i).foto_pendiente = false;
                        this.i_cargando = i;
                        return;
                    }
                }
                i++;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                java.lang.String r7 = "0"
                java.lang.String r0 = "fperfil_"
                java.lang.String r1 = r6.idusu_acargar
                if (r1 != 0) goto L_0x000b
                java.lang.String r7 = "-1"
                return r7
            L_0x000b:
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/usus/"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r6.idusu_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_1_p.jpg?v="
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r6.vfoto_bd     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r3 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r3)     // Catch:{  }
                r3 = 20000(0x4e20, float:2.8026E-41)
                r1.setReadTimeout(r3)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{  }
                r6.bmImg = r4     // Catch:{  }
                r3.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                java.io.File r1 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this     // Catch:{  }
                java.io.File r3 = r3.path     // Catch:{  }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
                r4.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r6.idusu_acargar     // Catch:{  }
                r4.append(r0)     // Catch:{  }
                java.lang.String r0 = ".jpg"
                r4.append(r0)     // Catch:{  }
                java.lang.String r0 = r4.toString()     // Catch:{  }
                r1.<init>(r3, r0)     // Catch:{  }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x00a5 }
                r0.<init>(r1)     // Catch:{ MalformedURLException -> 0x00a5 }
                android.graphics.Bitmap r3 = r6.bmImg     // Catch:{ MalformedURLException -> 0x00a5 }
                android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x00a5 }
                r5 = 70
                r3.compress(r4, r5, r0)     // Catch:{ MalformedURLException -> 0x00a5 }
                stikerwap.appdys.t_buscvideos r0 = stikerwap.appdys.t_buscvideos.this     // Catch:{ MalformedURLException -> 0x00a5 }
                java.util.ArrayList<stikerwap.appdys.t_buscvideos$Usu> r0 = r0.usus_a     // Catch:{ MalformedURLException -> 0x00a5 }
                int r3 = r6.i_cargando     // Catch:{ MalformedURLException -> 0x00a5 }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ MalformedURLException -> 0x00a5 }
                stikerwap.appdys.t_buscvideos$Usu r0 = (stikerwap.appdys.t_buscvideos.Usu) r0     // Catch:{ MalformedURLException -> 0x00a5 }
                stikerwap.appdys.t_buscvideos r3 = stikerwap.appdys.t_buscvideos.this     // Catch:{ MalformedURLException -> 0x00a5 }
                android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ MalformedURLException -> 0x00a5 }
                android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ MalformedURLException -> 0x00a5 }
                android.graphics.Bitmap r1 = android.provider.MediaStore.Images.Media.getBitmap(r3, r1)     // Catch:{ MalformedURLException -> 0x00a5 }
                android.graphics.Bitmap r1 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r1, r2)     // Catch:{ MalformedURLException -> 0x00a5 }
                r0.foto = r1     // Catch:{ MalformedURLException -> 0x00a5 }
                java.lang.String r7 = "1"
            L_0x00a5:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscvideos.cargar_fotos.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (this.idusu_acargar != null && !str.equals("-1")) {
                if (str == "1") {
                    SharedPreferences.Editor edit = t_buscvideos.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, this.vfoto_bd);
                    edit.commit();
                }
                t_buscvideos.this.mAdapter.notifyDataSetChanged();
                new cargar_fotos().execute(new String[0]);
            } else if (!str.equals("-1")) {
                t_buscvideos.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    private class Usu {
        Bitmap foto;
        boolean foto_pendiente;
        String id;
        String vfoto;

        private Usu() {
            this.foto_pendiente = true;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        this.dialog_filtros.dismiss();
        this.dialog_filtros = crear_dialog_filtros();
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
        ArrayList<claseBuscvideo> arrayList = this.m_orders;
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
                if (!t_buscvideos.this.globales.admob_rew_failed(context, t_buscvideos.this.mAd_appnext)) {
                    t_buscvideos.this.dialog_cargando.cancel();
                    t_buscvideos t_buscvideos = t_buscvideos.this;
                    t_buscvideos.abrir_secc(t_buscvideos.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_buscvideos.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_buscvideos.this.abrir_secc(t_buscvideos.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_buscvideos.this.mAd_visto) {
                            t_buscvideos.this.abrir_secc(t_buscvideos.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_buscvideos.this.mAd_visto = true;
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
                if (t_buscvideos.this.mAd_visto) {
                    t_buscvideos t_buscvideos = t_buscvideos.this;
                    t_buscvideos.abrir_secc(t_buscvideos.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
