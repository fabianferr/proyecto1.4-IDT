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
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import androidx.mediarouter.app.MediaRouteButton;
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
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class t_video_exoplayer extends FragmentActivity_ext_class implements Activity_ext, View.OnKeyListener, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private int TV_MARGIN;
    private int TV_PADDING;
    private int WIDTH_IMGS;
    HashMap<String, String> acargar_m;
    private int altura;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_propia;
    String c1;
    boolean c1_esclaro;
    String c2;
    boolean c2_esclaro;
    boolean c_fondotxt_esclaro;
    /* access modifiers changed from: private */
    public String codigo;
    boolean coments;
    boolean con_chat;
    private int descr;
    /* access modifiers changed from: private */
    public String dia_act;
    private int dist;
    int dp10;
    int dp3;
    enviar env;
    boolean esStream = false;
    Boolean estaba_en_fs = false;
    int estado_ad = -1;
    Bundle extras;
    private int fnac;
    private int fotos_chat;
    HashMap<String, Bitmap> fotos_m;
    /* access modifiers changed from: private */
    public int fotos_perfil;
    boolean galeria;
    config globales;
    boolean hayfrasedeotrousu = false;
    int height_global;
    /* access modifiers changed from: private */
    public int idfrase_masantigua_glob;
    private int idsecc;
    /* access modifiers changed from: private */
    public int idtema;
    /* access modifiers changed from: private */
    public long idusu;
    /* access modifiers changed from: private */
    public String idusu_act;
    private long idusu_global;
    int ind;
    HashMap<String, String> intentados_m;
    LinearLayout llchat;
    boolean logineado_ok;
    boolean mAd_visto = false;
    /* access modifiers changed from: private */
    public CastSession mCastSession;
    ListView mDrawerList;
    Boolean mExoPlayerFullscreen = false;
    FrameLayout mFullScreenButton;
    /* access modifiers changed from: private */
    public SessionManager mSessionManager;
    private final SessionManagerListener mSessionManagerListener = new SessionManagerListenerImpl();
    int marge_mateix;
    /* access modifiers changed from: private */
    public int nfrases;
    obtener_foto o_f;
    File path;
    ProgressBar pb_enviando;
    ExoPlayer player;
    PlayerView playerView;
    boolean privados;
    float scale;
    SharedPreferences settings;
    private int sexo;
    List<String> spool = new ArrayList();
    String ua_glob;
    Uri uri_glob;
    public String url_click = "";
    public String url_imp = "";
    int width_ad;
    int width_frase;
    int width_global;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    private class SessionManagerListenerImpl implements SessionManagerListener {
        public void onSessionEnded(Session session, int i) {
        }

        public void onSessionEnding(Session session) {
        }

        public void onSessionResumeFailed(Session session, int i) {
        }

        public void onSessionResuming(Session session, String str) {
        }

        public void onSessionStartFailed(Session session, int i) {
        }

        public void onSessionStarting(Session session) {
        }

        public void onSessionSuspended(Session session, int i) {
        }

        private SessionManagerListenerImpl() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|14|15|17) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0106 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSessionStarted(com.google.android.gms.cast.framework.Session r5, java.lang.String r6) {
            /*
                r4 = this;
                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                r5.invalidateOptionsMenu()
                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                android.os.Bundle r5 = r5.extras
                java.lang.String r6 = "url"
                java.lang.String r5 = r5.getString(r6)
                com.google.android.gms.cast.MediaMetadata r6 = new com.google.android.gms.cast.MediaMetadata
                r0 = 1
                r6.<init>(r0)
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r1 = r1.globales
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                int r2 = r2.ind
                r1 = r1[r2]
                java.lang.String r1 = r1.titulo
                java.lang.String r2 = "com.google.android.gms.cast.metadata.TITLE"
                r6.putString(r2, r1)
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r1 = r1.globales
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                int r2 = r2.ind
                r1 = r1[r2]
                boolean r1 = r1.ico_cargando
                if (r1 != 0) goto L_0x00c8
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r1 = r1.globales
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                int r2 = r2.ind
                r1 = r1[r2]
                android.graphics.Bitmap r1 = r1.ico
                if (r1 == 0) goto L_0x00c8
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r1 = r1.globales
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                int r2 = r2.ind
                r1 = r1[r2]
                int r1 = r1.ico_id
                if (r1 != 0) goto L_0x0093
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN
                r1.append(r2)
                java.lang.String r2 = "/srv/imgs/seccs/"
                r1.append(r2)
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r2 = r2.globales
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                int r3 = r3.ind
                r2 = r2[r3]
                int r2 = r2.id
                r1.append(r2)
                java.lang.String r2 = "_ico.png?v="
                r1.append(r2)
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r2 = r2.globales
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                int r3 = r3.ind
                r2 = r2[r3]
                int r2 = r2.v_ico
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                goto L_0x00bc
            L_0x0093:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN
                r1.append(r2)
                java.lang.String r2 = "/android-app-creator/icos_secc/"
                r1.append(r2)
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                stikerwap.appdys.config r2 = r2.globales
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                int r3 = r3.ind
                r2 = r2[r3]
                int r2 = r2.ico_id
                r1.append(r2)
                java.lang.String r2 = ".png"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
            L_0x00bc:
                android.net.Uri r1 = android.net.Uri.parse(r1)
                com.google.android.gms.common.images.WebImage r2 = new com.google.android.gms.common.images.WebImage
                r2.<init>((android.net.Uri) r1)
                r6.addImage(r2)
            L_0x00c8:
                com.google.android.gms.cast.MediaInfo$Builder r1 = new com.google.android.gms.cast.MediaInfo$Builder
                r1.<init>(r5)
                r5 = 0
                com.google.android.gms.cast.MediaInfo$Builder r1 = r1.setStreamType(r5)
                java.lang.String r2 = "video/*"
                com.google.android.gms.cast.MediaInfo$Builder r1 = r1.setContentType(r2)
                com.google.android.gms.cast.MediaInfo$Builder r6 = r1.setMetadata(r6)
                com.google.android.gms.cast.MediaInfo r6 = r6.build()
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0109 }
                com.google.android.gms.cast.framework.SessionManager r2 = r1.mSessionManager     // Catch:{ Exception -> 0x0109 }
                com.google.android.gms.cast.framework.CastSession r2 = r2.getCurrentCastSession()     // Catch:{ Exception -> 0x0109 }
                r1.mCastSession = r2     // Catch:{ Exception -> 0x0109 }
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0109 }
                com.google.android.gms.cast.framework.CastSession r1 = r1.mCastSession     // Catch:{ Exception -> 0x0109 }
                com.google.android.gms.cast.framework.media.RemoteMediaClient r1 = r1.getRemoteMediaClient()     // Catch:{ Exception -> 0x0109 }
                stikerwap.appdys.t_video_exoplayer$SessionManagerListenerImpl$1 r2 = new stikerwap.appdys.t_video_exoplayer$SessionManagerListenerImpl$1     // Catch:{ Exception -> 0x0109 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0109 }
                r1.addListener(r2)     // Catch:{ Exception -> 0x0109 }
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0106 }
                androidx.media3.exoplayer.ExoPlayer r2 = r2.player     // Catch:{ Exception -> 0x0106 }
                r2.setPlayWhenReady(r5)     // Catch:{ Exception -> 0x0106 }
            L_0x0106:
                r1.load((com.google.android.gms.cast.MediaInfo) r6, (boolean) r0)     // Catch:{ Exception -> 0x0109 }
            L_0x0109:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_exoplayer.SessionManagerListenerImpl.onSessionStarted(com.google.android.gms.cast.framework.Session, java.lang.String):void");
        }

        public void onSessionResumed(Session session, boolean z) {
            t_video_exoplayer.this.invalidateOptionsMenu();
        }
    }

    public void onCreate(Bundle bundle) {
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        setTheme(2131952106);
        establec_ralc(this);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        boolean z = true;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        Bundle extras3 = getIntent().getExtras();
        this.extras = extras3;
        this.ind = extras3.getInt("ind");
        this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[this.ind].c1, this.globales.c_icos);
        super.onCreate(bundle);
        setContentView((int) R.layout.t_video_exoplayer);
        incluir_menu_pre();
        this.globales.onCreate_global(this, true);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_video_exoplayer.this.finalizar = false;
                t_video_exoplayer.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_video_exoplayer.this.buscador_on = false;
            }
        });
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
        config config2 = this.globales;
        Bundle bundle2 = this.extras;
        boolean z2 = bundle2 != null && bundle2.containsKey("ad_entrar");
        Bundle bundle3 = this.extras;
        config2.toca_int(this, z2, bundle3 != null && bundle3.containsKey("fb_entrar"));
        this.anun = this.globales.mostrar_banner(this, false);
        config config3 = this.globales;
        config3.oncreate_popup(this, config3.ind_secc_sel_2, this.cbtn, bundle);
        if (!this.globales.secciones_a[this.ind].c1.equals("")) {
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#" + this.globales.secciones_a[this.ind].c1), Color.parseColor("#" + this.globales.secciones_a[this.ind].c2)}));
        }
        this.esStream = this.globales.secciones_a[this.ind].stream;
        String string = this.extras.getString("ua");
        this.ua_glob = string;
        if (string.equals("")) {
            this.ua_glob = Util.getUserAgent(this, BuildConfig.APPLICATION_ID);
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color((ProgressBar) findViewById(R.id.pb_video), this.cbtn);
        }
        this.playerView = (PlayerView) findViewById(R.id.vv);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putInt("appnext_video_n", sharedPreferences.getInt("appnext_video_n", 0) + 1);
        edit.commit();
        DefaultHttpDataSource.Factory factory = new DefaultHttpDataSource.Factory();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.ua_glob);
        List<String[]> list = this.globales.secciones_a[this.ind].headers;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                hashMap.put(list.get(i)[0], list.get(i)[1]);
            }
        }
        factory.setDefaultRequestProperties((Map<String, String>) hashMap);
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory((DataSource.Factory) factory);
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this);
        defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setMaxVideoSizeSd());
        ExoPlayer build = new ExoPlayer.Builder(this).setTrackSelector(defaultTrackSelector).setMediaSourceFactory(defaultMediaSourceFactory).build();
        this.player = build;
        this.playerView.setPlayer(build);
        this.playerView.setControllerAutoShow(false);
        this.playerView.hideController();
        this.playerView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        if (this.esStream) {
            this.playerView.findViewById(R.id.exo_position).setVisibility(4);
            this.playerView.findViewById(R.id.exo_progress).setVisibility(4);
            this.playerView.findViewById(R.id.exo_duration).setVisibility(4);
        }
        initFullscreenButton();
        if (this.globales.video_cast) {
            findViewById(R.id.exo_cast_button).setVisibility(0);
            try {
                this.mSessionManager = CastContext.getSharedInstance(this).getSessionManager();
                CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), (MediaRouteButton) findViewById(R.id.vcv_img_cast));
            } catch (Exception unused) {
            }
        }
        findViewById(R.id.exo_play).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                t_video_exoplayer.this.player.setPlayWhenReady(true);
                t_video_exoplayer.this.findViewById(R.id.exo_play).setVisibility(8);
                t_video_exoplayer.this.findViewById(R.id.exo_pause).setVisibility(0);
            }
        });
        findViewById(R.id.exo_pause).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                t_video_exoplayer.this.player.setPlayWhenReady(false);
                t_video_exoplayer.this.findViewById(R.id.exo_pause).setVisibility(8);
                t_video_exoplayer.this.findViewById(R.id.exo_play).setVisibility(0);
            }
        });
        if (this.globales.video_pip_icon && Build.VERSION.SDK_INT >= 24) {
            findViewById(R.id.exo_pip_button).setVisibility(0);
            findViewById(R.id.exo_pip_button).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        t_video_exoplayer.this.enterPictureInPictureMode();
                    } catch (Exception unused) {
                    }
                }
            });
        }
        if (this.globales.secciones_a[this.ind].descargar) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.exo_download_button);
            frameLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String str;
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(t_video_exoplayer.this.uri_glob.toString());
                    String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "video/*";
                    try {
                        str = URLUtil.guessFileName(t_video_exoplayer.this.uri_glob.toString(), (String) null, mimeTypeFromExtension);
                    } catch (Exception unused) {
                        str = "";
                    }
                    t_video_exoplayer.this.globales.fdescargar(t_video_exoplayer.this.uri_glob.toString(), mimeTypeFromExtension, str, t_video_exoplayer.this);
                }
            });
            frameLayout.setVisibility(0);
        }
        this.player.addListener(new Player.Listener() {
            public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
            }

            public /* synthetic */ void onAudioSessionIdChanged(int i) {
                Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
            }

            public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
            }

            public /* synthetic */ void onCues(CueGroup cueGroup) {
                Player.Listener.CC.$default$onCues((Player.Listener) this, cueGroup);
            }

            public /* synthetic */ void onCues(List list) {
                Player.Listener.CC.$default$onCues((Player.Listener) this, list);
            }

            public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
            }

            public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
            }

            public /* synthetic */ void onEvents(Player player, Player.Events events) {
                Player.Listener.CC.$default$onEvents(this, player, events);
            }

            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                Player.Listener.CC.$default$onIsLoadingChanged(this, z);
            }

            public /* synthetic */ void onIsPlayingChanged(boolean z) {
                Player.Listener.CC.$default$onIsPlayingChanged(this, z);
            }

            public /* synthetic */ void onLoadingChanged(boolean z) {
                Player.Listener.CC.$default$onLoadingChanged(this, z);
            }

            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                Player.Listener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
            }

            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
            }

            public /* synthetic */ void onMetadata(Metadata metadata) {
                Player.Listener.CC.$default$onMetadata(this, metadata);
            }

            public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
            }

            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
            }

            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                Player.Listener.CC.$default$onPlayerError(this, playbackException);
            }

            public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
            }

            public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                Player.Listener.CC.$default$onPlayerStateChanged(this, z, i);
            }

            public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
            }

            public /* synthetic */ void onPositionDiscontinuity(int i) {
                Player.Listener.CC.$default$onPositionDiscontinuity(this, i);
            }

            public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
                Player.Listener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
            }

            public /* synthetic */ void onRenderedFirstFrame() {
                Player.Listener.CC.$default$onRenderedFirstFrame(this);
            }

            public /* synthetic */ void onRepeatModeChanged(int i) {
                Player.Listener.CC.$default$onRepeatModeChanged(this, i);
            }

            public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
            }

            public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
            }

            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                Player.Listener.CC.$default$onShuffleModeEnabledChanged(this, z);
            }

            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
            }

            public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
            }

            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.Listener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                Player.Listener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
            }

            public /* synthetic */ void onTracksChanged(Tracks tracks) {
                Player.Listener.CC.$default$onTracksChanged(this, tracks);
            }

            public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
            }

            public /* synthetic */ void onVolumeChanged(float f) {
                Player.Listener.CC.$default$onVolumeChanged(this, f);
            }

            public void onPlaybackStateChanged(int i) {
                if (t_video_exoplayer.this.player.isPlaying() || (t_video_exoplayer.this.player.getPlayWhenReady() && i == 3)) {
                    t_video_exoplayer.this.findViewById(R.id.pb_video).setVisibility(8);
                }
            }
        });
        empezar_video();
        this.con_chat = this.globales.chatsecc_en_video;
        this.c1 = this.globales.secciones_a[this.ind].c1;
        this.c2 = this.globales.secciones_a[this.ind].c2;
        if (this.con_chat) {
            this.logineado_ok = true;
            int i2 = this.globales.chatsecc_p_fnac;
            int i3 = this.globales.chatsecc_p_sexo;
            int i4 = this.globales.chatsecc_p_descr;
            this.fotos_perfil = this.globales.chatsecc_fotos_perfil;
            if (this.settings.getString("nick", "").equals("") || (this.globales.fb_modo == 3 && !this.settings.getBoolean("email_confirmado", false))) {
                this.logineado_ok = false;
            } else if ((this.fotos_perfil == 2 && !this.globales.getTempFile(this, 1).exists()) || ((i2 == 2 && (this.settings.getInt("fnac_d", 0) == 0 || this.settings.getInt("fnac_m", 0) == 0 || this.settings.getInt("fnac_a", 0) == 0)) || ((i3 == 2 && this.settings.getInt("sexo", 0) == 0) || (i4 == 2 && this.settings.getString("descr", "").equals(""))))) {
                this.logineado_ok = false;
            }
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.altura = point.y;
            this.c1_esclaro = config.esClaro("#" + this.globales.secciones_a[this.ind].c1);
            this.c2_esclaro = config.esClaro("#" + this.globales.secciones_a[this.ind].c2);
            if (this.globales.bubbles > 0) {
                this.c_fondotxt_esclaro = true;
                if (!this.globales.c_bubbles.equals("")) {
                    this.c_fondotxt_esclaro = config.esClaro("#" + this.globales.c_bubbles);
                }
            } else {
                this.c_fondotxt_esclaro = this.c1_esclaro;
            }
            try {
                this.idtema = this.globales.secciones_a[this.ind].temas_a[0].id;
            } catch (Exception unused2) {
                this.idtema = 0;
            }
            this.fotos_perfil = this.globales.chatsecc_fotos_perfil;
            this.privados = this.globales.chatsecc_privados;
            this.coments = this.globales.chatsecc_coments;
            this.galeria = this.globales.chatsecc_galeria;
            this.fnac = this.globales.chatsecc_p_fnac;
            this.sexo = this.globales.chatsecc_p_sexo;
            this.dist = this.globales.chatsecc_p_dist;
            this.descr = this.globales.chatsecc_p_descr;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.width_global = displayMetrics.widthPixels;
            this.height_global = displayMetrics.heightPixels;
            int i5 = this.width_global;
            if (getResources().getConfiguration().orientation == 2) {
                i5 = this.height_global;
            }
            double d = (double) (i5 / 2);
            Double.isNaN(d);
            this.width_frase = (int) (d * 1.1d);
            double d2 = (double) i5;
            Double.isNaN(d2);
            this.width_ad = (int) (d2 * 0.8d);
            if (this.fotos_perfil > 0) {
                int dp_to_px = config.dp_to_px(this, 50);
                this.width_frase -= dp_to_px;
                this.width_ad -= dp_to_px;
            }
            this.marge_mateix = config.dp_to_px(this, 4);
            if (this.globales.bubbles == 1) {
                this.marge_mateix = config.dp_to_px(this, 14);
            } else if (this.globales.bubbles == 2) {
                this.marge_mateix = config.dp_to_px(this, 5);
            } else if (this.globales.bubbles == 3) {
                this.marge_mateix = config.dp_to_px(this, 12);
            } else if (this.globales.bubbles == 4) {
                this.marge_mateix = config.dp_to_px(this, 4);
            }
            this.dp3 = config.dp_to_px(this, 3);
            this.dp10 = config.dp_to_px(this, 10);
            if (!this.globales.emojis) {
                findViewById(R.id.btnemotic).setVisibility(8);
            }
            this.WIDTH_IMGS = (int) ((getResources().getDisplayMetrics().density * 100.0f) + 0.5f);
            this.TV_PADDING = (int) ((getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
            this.TV_MARGIN = (int) ((getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
            this.path = getFilesDir();
            this.nfrases = 0;
            this.dia_act = "";
            this.idusu_act = "";
            this.hayfrasedeotrousu = false;
            SharedPreferences sharedPreferences2 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            this.settings = sharedPreferences2;
            this.idusu = sharedPreferences2.getLong("idusu", 0);
            this.codigo = this.settings.getString("cod", "");
            this.llchat = (LinearLayout) findViewById(R.id.llchat);
            this.pb_enviando = (ProgressBar) findViewById(R.id.pb_chat_env_inv);
            if (!this.c1.equals("")) {
                if (Build.VERSION.SDK_INT > 20) {
                    config.edittext_color((EditText) findViewById(R.id.c_mensaje), Boolean.valueOf(!this.c1_esclaro), this.cbtn);
                } else {
                    ((EditText) findViewById(R.id.c_mensaje)).setTextColor(-1);
                }
                if (!this.c2_esclaro) {
                    ((ImageView) findViewById(R.id.btnemotic)).setImageDrawable(getResources().getDrawable(R.drawable.emoticono_sel_light));
                    this.pb_enviando = (ProgressBar) findViewById(R.id.pb_chat_env);
                }
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color(this.pb_enviando, this.cbtn);
                }
                Drawable drawable = getResources().getDrawable(R.drawable.btn_enviar_2);
                if (!this.cbtn.equals("")) {
                    drawable.setColorFilter(Color.parseColor("#" + this.cbtn), PorterDuff.Mode.MULTIPLY);
                }
                ((ImageView) findViewById(R.id.btnenv)).setImageDrawable(drawable);
            }
            findViewById(R.id.btnemotic).setOnClickListener(this);
            findViewById(R.id.btnenv).setOnClickListener(this);
            findViewById(R.id.c_mensaje).setOnKeyListener(this);
            findViewById(R.id.rl_chat).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    t_video_exoplayer.this.cerrar_chat();
                }
            });
            findViewById(R.id.btn_verchat).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!t_video_exoplayer.this.logineado_ok) {
                        Intent intent = new Intent(t_video_exoplayer.this, chat_perfil.class);
                        intent.putExtra("idsecc", t_video_exoplayer.this.globales.secciones_a[t_video_exoplayer.this.ind].id);
                        intent.putExtra("desde_video", true);
                        if (t_video_exoplayer.this.es_root) {
                            intent.putExtra("es_root", t_video_exoplayer.this.es_root);
                        }
                        t_video_exoplayer.this.es_root = false;
                        t_video_exoplayer.this.finalizar = true;
                        t_video_exoplayer.this.startActivityForResult(intent, 0);
                    } else if (t_video_exoplayer.this.findViewById(R.id.sv_chat).getVisibility() == 0) {
                        t_video_exoplayer.this.cerrar_chat();
                    } else {
                        t_video_exoplayer.this.playerView.setControllerAutoShow(false);
                        t_video_exoplayer.this.playerView.hideController();
                        t_video_exoplayer.this.findViewById(R.id.sv_chat).setVisibility(0);
                        if (!t_video_exoplayer.this.globales.banners_enchats && t_video_exoplayer.this.anun != null && t_video_exoplayer.this.anun.adView != null) {
                            t_video_exoplayer.this.ocultar_banner();
                        }
                    }
                }
            });
            findViewById(R.id.btn_verchat).setVisibility(0);
            this.fotos_m = new HashMap<>();
            this.acargar_m = new HashMap<>();
            this.intentados_m = new HashMap<>();
            this.bm_propia = null;
            try {
                if (this.c_fondotxt_esclaro) {
                    this.bm_propia = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto_light);
                } else {
                    this.bm_propia = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto);
                }
            } catch (OutOfMemoryError unused3) {
            }
            if (this.fotos_perfil > 0) {
                File tempFile = this.globales.getTempFile(this, 1);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(tempFile.getPath(), options);
                    int i6 = options.outWidth;
                    int i7 = options.outWidth;
                    int i8 = options.outHeight;
                    if (i7 > 75 || i8 > 100) {
                        z = false;
                    }
                    if (!z) {
                        int round = Math.round(((float) i7) / ((float) config.calculateNewWidth(i7, i8, 75, 100)));
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = round;
                        this.bm_propia = BitmapFactory.decodeFile(tempFile.getPath(), options2);
                    } else {
                        this.bm_propia = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(tempFile));
                    }
                } catch (Exception unused4) {
                }
            }
            this.idfrase_masantigua_glob = 0;
            if (this.logineado_ok) {
                new cargar_ultimas("0", "0", this.idfrase_masantigua_glob).execute(new String[0]);
            }
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        if (z) {
            this.estaba_en_fs = this.mExoPlayerFullscreen;
            openFullscreenDialog(true);
        } else if (!this.estaba_en_fs.booleanValue()) {
            closeFullscreenDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        if (this.globales.video_pip_auto && Build.VERSION.SDK_INT >= 24) {
            try {
                enterPictureInPictureMode();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void ocultar_banner() {
        if (((LinearLayout) findViewById(R.id.ll_ad)).getChildCount() > 0) {
            findViewById(R.id.ll_ad).setVisibility(8);
        }
        View findViewWithTag = findViewById(R.id.ll_princ).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void cerrar_chat() {
        Anuncios anuncios;
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
        } catch (Exception unused) {
        }
        findViewById(R.id.sv_chat).setVisibility(8);
        this.playerView.setControllerAutoShow(true);
        if (!this.globales.banners_enchats && (anuncios = this.anun) != null && anuncios.adView != null) {
            if (((LinearLayout) findViewById(R.id.ll_ad)).getChildCount() > 0) {
                findViewById(R.id.ll_ad).setVisibility(0);
            }
            View findViewWithTag = findViewById(R.id.ll_princ).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(0);
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        f_enviar(true);
        return true;
    }

    private void f_enviar(boolean z) {
        String trim = ((TextView) findViewById(R.id.c_mensaje)).getText().toString().replace("@", "").trim();
        if (!trim.equals("")) {
            if (z && this.altura < 600) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
            }
            ((EditText) findViewById(R.id.c_mensaje)).setText("");
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putString("f2_id", this.idusu + "");
            edit.putString("f2_frase", trim);
            edit.putString("f2_fcrea", new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
            edit.putString("f2_b64", "");
            edit.putString("f2_idfrase", "0");
            edit.putString("f2_idtema", this.idtema + "");
            edit.putString("f2_vfoto", "0");
            edit.putBoolean("f2_ultimas", false);
            edit.putString("f2_ts", System.currentTimeMillis() + "");
            edit.commit();
            this.globales.toca_int_chat(this);
            config config = this.globales;
            SharedPreferences sharedPreferences = this.settings;
            config.toca_inchat(this, sharedPreferences, this.idtema + "");
            this.spool.add(trim);
            enviar enviar2 = this.env;
            if (enviar2 == null || enviar2.getStatus() != AsyncTask.Status.RUNNING) {
                enviar enviar3 = new enviar();
                this.env = enviar3;
                enviar3.execute(new String[0]);
            }
        }
    }

    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences.contains("f2_idfrase") && str.equals("f2_ts")) {
            SharedPreferences sharedPreferences2 = this.settings;
            if (!sharedPreferences2.contains("ban_" + sharedPreferences.getString("f2_id", ""))) {
                String string = sharedPreferences.getString("f2_idtema", "0");
                if (string.equals(this.idtema + "")) {
                    runOnUiThread(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:232:0x0765, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07f7;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:240:0x078b, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07c6;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:252:0x07c4, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07c6;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:253:0x07c6, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble4_flip;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:254:0x07ca, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble_flip;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:264:0x07f5, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07f7;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:265:0x07f7, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble4;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:266:0x07fb, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0035, code lost:
                            if (r3.equals(stikerwap.appdys.t_video_exoplayer.m1524$$Nest$fgetidusu_act(r1.this$0) + "") == false) goto L_0x0037;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0051, code lost:
                            if (r4.getString("f2_id", "").equals(r4.getString("f2_idusu_prev", "")) != false) goto L_0x0053;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0053, code lost:
                            r0 = true;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:140:0x04e8  */
                        /* JADX WARNING: Removed duplicated region for block: B:148:0x050e  */
                        /* JADX WARNING: Removed duplicated region for block: B:149:0x0525  */
                        /* JADX WARNING: Removed duplicated region for block: B:194:0x0642  */
                        /* JADX WARNING: Removed duplicated region for block: B:195:0x0653  */
                        /* JADX WARNING: Removed duplicated region for block: B:199:0x067f  */
                        /* JADX WARNING: Removed duplicated region for block: B:218:0x0703  */
                        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6  */
                        /* JADX WARNING: Removed duplicated region for block: B:270:0x0823  */
                        /* JADX WARNING: Removed duplicated region for block: B:277:0x0850  */
                        /* JADX WARNING: Removed duplicated region for block: B:290:0x08b8  */
                        /* JADX WARNING: Removed duplicated region for block: B:294:0x08d4  */
                        /* JADX WARNING: Removed duplicated region for block: B:299:0x0905  */
                        /* JADX WARNING: Removed duplicated region for block: B:300:0x090d  */
                        /* JADX WARNING: Removed duplicated region for block: B:305:0x093b  */
                        /* JADX WARNING: Removed duplicated region for block: B:306:0x094a  */
                        /* JADX WARNING: Removed duplicated region for block: B:311:0x097e  */
                        /* JADX WARNING: Removed duplicated region for block: B:313:? A[RETURN, SYNTHETIC] */
                        /* JADX WARNING: Removed duplicated region for block: B:32:0x0103  */
                        /* JADX WARNING: Removed duplicated region for block: B:33:0x0147  */
                        /* JADX WARNING: Removed duplicated region for block: B:50:0x01de  */
                        /* JADX WARNING: Removed duplicated region for block: B:56:0x01fe  */
                        /* JADX WARNING: Removed duplicated region for block: B:64:0x0289  */
                        /* JADX WARNING: Removed duplicated region for block: B:67:0x02ba  */
                        /* JADX WARNING: Removed duplicated region for block: B:77:0x02f5  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r24 = this;
                                r1 = r24
                                r2 = 0
                                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r4 = "f2_ultimas"
                                boolean r3 = r3.getBoolean(r4, r2)
                                r5 = 1
                                java.lang.String r6 = "f2_id"
                                java.lang.String r7 = ""
                                if (r3 != 0) goto L_0x0037
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r3 = r3.getString(r6, r7)
                                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                                r8.<init>()
                                stikerwap.appdys.t_video_exoplayer r9 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r9 = r9.idusu_act
                                r8.append(r9)
                                r8.append(r7)
                                java.lang.String r8 = r8.toString()
                                boolean r3 = r3.equals(r8)
                                if (r3 != 0) goto L_0x0053
                            L_0x0037:
                                android.content.SharedPreferences r3 = r4
                                boolean r3 = r3.getBoolean(r4, r2)
                                if (r3 == 0) goto L_0x0057
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r3 = r3.getString(r6, r7)
                                android.content.SharedPreferences r8 = r4
                                java.lang.String r9 = "f2_idusu_prev"
                                java.lang.String r8 = r8.getString(r9, r7)
                                boolean r3 = r3.equals(r8)
                                if (r3 == 0) goto L_0x0057
                            L_0x0053:
                                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
                            L_0x0057:
                                android.content.SharedPreferences r3 = r4
                                boolean r3 = r3.getBoolean(r4, r2)
                                if (r3 != 0) goto L_0x006a
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.SharedPreferences r8 = r4
                                java.lang.String r8 = r8.getString(r6, r7)
                                r3.idusu_act = r8
                            L_0x006a:
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r3 = r3.getString(r6, r7)
                                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                                r8.<init>()
                                stikerwap.appdys.t_video_exoplayer r9 = stikerwap.appdys.t_video_exoplayer.this
                                long r9 = r9.idusu
                                r8.append(r9)
                                r8.append(r7)
                                java.lang.String r8 = r8.toString()
                                boolean r3 = r3.equals(r8)
                                if (r3 == 0) goto L_0x00a7
                                android.content.SharedPreferences r3 = r4
                                boolean r3 = r3.getBoolean(r4, r2)
                                if (r3 == 0) goto L_0x009e
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r8 = "f2_mateixusu_hastafinal"
                                boolean r3 = r3.getBoolean(r8, r2)
                                if (r3 == 0) goto L_0x00a5
                                goto L_0x00a4
                            L_0x009e:
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r3 = r3.hayfrasedeotrousu
                                if (r3 != 0) goto L_0x00a5
                            L_0x00a4:
                                goto L_0x00ab
                            L_0x00a5:
                                r3 = 1
                                goto L_0x00ac
                            L_0x00a7:
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                r3.hayfrasedeotrousu = r5
                            L_0x00ab:
                                r3 = 0
                            L_0x00ac:
                                android.content.SharedPreferences r8 = r4
                                boolean r8 = r8.getBoolean(r4, r2)
                                java.lang.String r9 = "f2_fcrea"
                                if (r8 == 0) goto L_0x00dd
                                android.content.SharedPreferences r8 = r4
                                java.lang.String r8 = r8.getString(r9, r7)
                                boolean r10 = r8.equals(r7)
                                if (r10 != 0) goto L_0x00dd
                                r10 = 6
                                java.lang.String r8 = r8.substring(r2, r10)
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r10 = r10.dia_act
                                boolean r10 = r8.equals(r10)
                                if (r10 != 0) goto L_0x00dd
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                r10.mostrar_fecha()
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                r10.dia_act = r8
                            L_0x00dd:
                                stikerwap.appdys.t_video_exoplayer r8 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r10 = "layout_inflater"
                                java.lang.Object r8 = r8.getSystemService(r10)
                                android.view.LayoutInflater r8 = (android.view.LayoutInflater) r8
                                r10 = 2131558529(0x7f0d0081, float:1.8742376E38)
                                r11 = 0
                                android.view.View r8 = r8.inflate(r10, r11)
                                android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
                                boolean r10 = r0.booleanValue()
                                r12 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                r13 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                r14 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                r15 = 8
                                r11 = 4
                                if (r10 == 0) goto L_0x0147
                                android.view.View r10 = r8.findViewById(r13)
                                r10.setVisibility(r11)
                                android.view.View r10 = r8.findViewById(r12)
                                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                                r10.height = r5
                                r10 = 2131362421(0x7f0a0275, float:1.8344622E38)
                                android.view.View r10 = r8.findViewById(r10)
                                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                                r10.height = r5
                                android.widget.LinearLayout$LayoutParams r10 = new android.widget.LinearLayout$LayoutParams
                                r12 = -2
                                r11 = -2
                                r10.<init>(r12, r11)
                                stikerwap.appdys.t_video_exoplayer r11 = stikerwap.appdys.t_video_exoplayer.this
                                int r11 = r11.marge_mateix
                                stikerwap.appdys.t_video_exoplayer r12 = stikerwap.appdys.t_video_exoplayer.this
                                int r12 = r12.marge_mateix
                                r10.setMargins(r11, r2, r12, r2)
                                android.view.View r11 = r8.findViewById(r14)
                                android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
                                r11.setLayoutParams(r10)
                                r10 = 2131362603(0x7f0a032b, float:1.8344991E38)
                                android.view.View r10 = r8.findViewById(r10)
                                r10.setVisibility(r15)
                                goto L_0x01be
                            L_0x0147:
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                int r10 = r10.dp3
                                stikerwap.appdys.t_video_exoplayer r11 = stikerwap.appdys.t_video_exoplayer.this
                                int r11 = r11.dp10
                                stikerwap.appdys.t_video_exoplayer r12 = stikerwap.appdys.t_video_exoplayer.this
                                int r12 = r12.dp3
                                r8.setPadding(r10, r11, r12, r2)
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r10 = r10.globales
                                boolean r10 = r10.spam_mostrar
                                if (r10 == 0) goto L_0x01be
                                android.content.SharedPreferences r10 = r4
                                java.lang.String r10 = r10.getString(r6, r7)
                                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                                r11.<init>()
                                stikerwap.appdys.t_video_exoplayer r12 = stikerwap.appdys.t_video_exoplayer.this
                                long r13 = r12.idusu
                                r11.append(r13)
                                r11.append(r7)
                                java.lang.String r11 = r11.toString()
                                boolean r10 = r10.equals(r11)
                                if (r10 != 0) goto L_0x01be
                                boolean r10 = r0.booleanValue()
                                if (r10 != 0) goto L_0x01be
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r10 = r10.c_fondotxt_esclaro
                                r11 = 2131362422(0x7f0a0276, float:1.8344624E38)
                                if (r10 == 0) goto L_0x019b
                                android.view.View r10 = r8.findViewById(r11)
                                android.widget.ImageView r10 = (android.widget.ImageView) r10
                                int r12 = stikerwap.appdys.config.NEGRO
                                android.graphics.PorterDuff$Mode r13 = android.graphics.PorterDuff.Mode.MULTIPLY
                                r10.setColorFilter(r12, r13)
                            L_0x019b:
                                android.view.View r10 = r8.findViewById(r11)
                                r10.setVisibility(r2)
                                android.view.View r10 = r8.findViewById(r11)
                                android.content.SharedPreferences r12 = r4
                                java.lang.String r12 = r12.getString(r6, r7)
                                r13 = 2131362376(0x7f0a0248, float:1.834453E38)
                                r10.setTag(r13, r12)
                                android.view.View r10 = r8.findViewById(r11)
                                stikerwap.appdys.t_video_exoplayer$13$1 r11 = new stikerwap.appdys.t_video_exoplayer$13$1
                                r11.<init>()
                                r10.setOnClickListener(r11)
                            L_0x01be:
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                int r10 = r10.width_frase
                                if (r10 == 0) goto L_0x01d8
                                boolean r10 = r0.booleanValue()
                                if (r10 != 0) goto L_0x01d8
                                r10 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                android.view.View r11 = r8.findViewById(r10)
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                int r10 = r10.width_frase
                                r11.setMinimumWidth(r10)
                            L_0x01d8:
                                r10 = 2131034118(0x7f050006, float:1.7678745E38)
                                r11 = 3
                                if (r3 == 0) goto L_0x01f8
                                stikerwap.appdys.t_video_exoplayer r12 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r12 = r12.getResources()
                                boolean r12 = r12.getBoolean(r10)
                                if (r12 == 0) goto L_0x01f1
                                r8.setGravity(r11)
                                r8.setLayoutDirection(r2)
                                goto L_0x01f8
                            L_0x01f1:
                                r12 = 5
                                r8.setGravity(r12)
                                r8.setLayoutDirection(r5)
                            L_0x01f8:
                                int r12 = android.os.Build.VERSION.SDK_INT
                                r13 = 20
                                if (r12 <= r13) goto L_0x023e
                                r12 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_exoplayer r13 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                                r12 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_exoplayer r13 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                                r12 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_exoplayer r13 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                                r12 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_exoplayer r13 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                            L_0x023e:
                                r12 = 2131362421(0x7f0a0275, float:1.8344622E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ImageView r12 = (android.widget.ImageView) r12
                                r13 = 2131363453(0x7f0a067d, float:1.8346715E38)
                                android.view.View r13 = r8.findViewById(r13)
                                android.widget.TextView r13 = (android.widget.TextView) r13
                                r14 = 2131363417(0x7f0a0659, float:1.8346642E38)
                                android.view.View r14 = r8.findViewById(r14)
                                android.widget.TextView r14 = (android.widget.TextView) r14
                                java.lang.String r16 = "#C0FFFFFF"
                                int r16 = android.graphics.Color.parseColor(r16)
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r15 = r15.c1
                                java.lang.String r11 = "FFFFFFFF"
                                boolean r11 = r15.equals(r11)
                                if (r11 == 0) goto L_0x027d
                                stikerwap.appdys.t_video_exoplayer r11 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.String r11 = r11.c2
                                java.lang.String r15 = "FFFFFFFF"
                                boolean r11 = r11.equals(r15)
                                if (r11 == 0) goto L_0x027d
                                java.lang.String r11 = "#C0EEEEEE"
                                int r16 = android.graphics.Color.parseColor(r11)
                            L_0x027d:
                                java.lang.String r11 = "#555555"
                                int r11 = android.graphics.Color.parseColor(r11)
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r15 = r15.c_fondotxt_esclaro
                                if (r15 != 0) goto L_0x028f
                                java.lang.String r11 = "#999999"
                                int r11 = android.graphics.Color.parseColor(r11)
                            L_0x028f:
                                r13.setTextColor(r11)
                                r14.setTextColor(r11)
                                android.content.SharedPreferences r11 = r4
                                java.lang.String r11 = r11.getString(r6, r7)
                                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                                r15.<init>()
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                r18 = r6
                                long r5 = r10.idusu
                                r15.append(r5)
                                r15.append(r7)
                                java.lang.String r5 = r15.toString()
                                boolean r5 = r11.equals(r5)
                                java.lang.String r11 = "1"
                                if (r5 == 0) goto L_0x02f5
                                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r5 = r5.c_fondotxt_esclaro
                                if (r5 != 0) goto L_0x02c2
                                r5 = -1
                                goto L_0x02c4
                            L_0x02c2:
                                r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                            L_0x02c4:
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r15 = r15.getResources()
                                r6 = 2131886857(0x7f120309, float:1.9408305E38)
                                java.lang.String r6 = r15.getString(r6)
                                r13.setText(r6)
                                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this
                                int r6 = r6.fotos_perfil
                                if (r6 <= 0) goto L_0x02ed
                                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this
                                android.graphics.Bitmap r6 = r6.bm_propia
                                if (r6 == 0) goto L_0x02ed
                                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this
                                android.graphics.Bitmap r6 = r6.bm_propia
                                android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r2)
                                r12.setImageBitmap(r6)
                            L_0x02ed:
                                r20 = r4
                                r22 = r11
                                r21 = r18
                                goto L_0x06fa
                            L_0x02f5:
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r6 = "f2_nombre"
                                java.lang.String r5 = r5.getString(r6, r7)
                                java.lang.String r5 = r5.trim()
                                r13.setText(r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r6 = "0"
                                r13 = r18
                                java.lang.String r5 = r5.getString(r13, r6)
                                r15 = 2131362376(0x7f0a0248, float:1.834453E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_privados"
                                java.lang.String r5 = r5.getString(r15, r11)
                                r15 = 2131362378(0x7f0a024a, float:1.8344535E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_nombre"
                                java.lang.String r5 = r5.getString(r15, r7)
                                r15 = 2131362379(0x7f0a024b, float:1.8344537E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_coments"
                                java.lang.String r5 = r5.getString(r15, r11)
                                r15 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_fnac_d"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362381(0x7f0a024d, float:1.834454E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_fnac_m"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362382(0x7f0a024e, float:1.8344543E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_fnac_a"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362383(0x7f0a024f, float:1.8344545E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_sexo"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362384(0x7f0a0250, float:1.8344547E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_vfoto"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362385(0x7f0a0251, float:1.834455E38)
                                r8.setTag(r15, r5)
                                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r5 = r5.globales
                                boolean r5 = r5.chatsecc_acceso_a_perfil
                                if (r5 == 0) goto L_0x03b0
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r5 = r5.getString(r13, r7)
                                boolean r5 = r5.equals(r11)
                                if (r5 != 0) goto L_0x03b0
                                r5 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                android.view.View r15 = r8.findViewById(r5)
                                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                                r15.setOnClickListener(r5)
                                r5 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                android.view.View r15 = r8.findViewById(r5)
                                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                                r15.setOnClickListener(r5)
                            L_0x03b0:
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r5 = r5.getString(r13, r7)
                                int r15 = r5.length()
                                r17 = 1
                                int r15 = r15 + -1
                                int r10 = r5.length()
                                java.lang.String r10 = r5.substring(r15, r10)
                                boolean r15 = r5.equals(r11)
                                if (r15 == 0) goto L_0x03cd
                                r10 = r6
                            L_0x03cd:
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r15 = r15.c_fondotxt_esclaro
                                if (r15 == 0) goto L_0x046a
                                boolean r15 = r10.equals(r6)
                                if (r15 != 0) goto L_0x045c
                                java.lang.String r15 = "5"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x03e3
                                goto L_0x045c
                            L_0x03e3:
                                boolean r15 = r10.equals(r11)
                                if (r15 != 0) goto L_0x044e
                                java.lang.String r15 = "6"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x03f2
                                goto L_0x044e
                            L_0x03f2:
                                java.lang.String r15 = "2"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x0440
                                java.lang.String r15 = "7"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0403
                                goto L_0x0440
                            L_0x0403:
                                java.lang.String r15 = "3"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x0432
                                java.lang.String r15 = "8"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0414
                                goto L_0x0432
                            L_0x0414:
                                java.lang.String r15 = "4"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x0424
                                java.lang.String r15 = "9"
                                boolean r10 = r10.equals(r15)
                                if (r10 == 0) goto L_0x04bb
                            L_0x0424:
                                java.lang.String r10 = "#FFCC0000"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0FFDFDF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x0432:
                                java.lang.String r10 = "#FF9E5400"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0FFF0DF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x0440:
                                java.lang.String r10 = "#FF3D5C00"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0F4FFDF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x044e:
                                java.lang.String r10 = "#FF9933CC"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0F2E6F9"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x045c:
                                java.lang.String r10 = "#FF00698C"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0DFF8FF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x046a:
                                boolean r15 = r10.equals(r6)
                                if (r15 != 0) goto L_0x04da
                                java.lang.String r15 = "5"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0479
                                goto L_0x04da
                            L_0x0479:
                                boolean r15 = r10.equals(r11)
                                if (r15 != 0) goto L_0x04d3
                                java.lang.String r15 = "6"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0488
                                goto L_0x04d3
                            L_0x0488:
                                java.lang.String r15 = "2"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x04cc
                                java.lang.String r15 = "7"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0499
                                goto L_0x04cc
                            L_0x0499:
                                java.lang.String r15 = "3"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x04c5
                                java.lang.String r15 = "8"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x04aa
                                goto L_0x04c5
                            L_0x04aa:
                                java.lang.String r15 = "4"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x04be
                                java.lang.String r15 = "9"
                                boolean r10 = r10.equals(r15)
                                if (r10 == 0) goto L_0x04bb
                                goto L_0x04be
                            L_0x04bb:
                                r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                goto L_0x04e0
                            L_0x04be:
                                java.lang.String r10 = "#FF33FFFF"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04c5:
                                java.lang.String r10 = "#FF87BFFF"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04cc:
                                java.lang.String r10 = "#FFC9ADFF"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04d3:
                                java.lang.String r10 = "#FF66CC33"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04da:
                                java.lang.String r10 = "#FFFF6633"
                                int r10 = android.graphics.Color.parseColor(r10)
                            L_0x04e0:
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r15 = r15.globales
                                boolean r15 = r15.c_txt_chats
                                if (r15 != 0) goto L_0x04f2
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r10 = r10.c_fondotxt_esclaro
                                if (r10 == 0) goto L_0x04f1
                                r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                goto L_0x04f2
                            L_0x04f1:
                                r10 = -1
                            L_0x04f2:
                                android.content.SharedPreferences r15 = r4
                                java.lang.String r2 = "f2_vfoto"
                                java.lang.String r2 = r15.getString(r2, r6)
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                int r15 = r15.fotos_perfil
                                if (r15 <= 0) goto L_0x0525
                                android.content.SharedPreferences r15 = r4
                                java.lang.String r15 = r15.getString(r13, r7)
                                boolean r15 = r15.equals(r11)
                                if (r15 == 0) goto L_0x0525
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r2 = r2.getResources()
                                r5 = 2131230922(0x7f0800ca, float:1.807791E38)
                                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r5)
                                r5 = 0
                                android.graphics.Bitmap r2 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r2, r5)
                                r12.setImageBitmap(r2)
                                goto L_0x06f0
                            L_0x0525:
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                int r15 = r15.fotos_perfil
                                if (r15 <= 0) goto L_0x0560
                                boolean r15 = r2.equals(r6)
                                if (r15 == 0) goto L_0x0560
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r2 = r2.c_fondotxt_esclaro
                                if (r2 == 0) goto L_0x054a
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r2 = r2.getResources()
                                r5 = 2131231691(0x7f0803cb, float:1.807947E38)
                                android.graphics.drawable.Drawable r2 = r2.getDrawable(r5)
                                r12.setImageDrawable(r2)
                                goto L_0x055a
                            L_0x054a:
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r2 = r2.getResources()
                                r5 = 2131231689(0x7f0803c9, float:1.8079466E38)
                                android.graphics.drawable.Drawable r2 = r2.getDrawable(r5)
                                r12.setImageDrawable(r2)
                            L_0x055a:
                                r2 = 0
                                r12.setVisibility(r2)
                                goto L_0x06f0
                            L_0x0560:
                                stikerwap.appdys.t_video_exoplayer r15 = stikerwap.appdys.t_video_exoplayer.this
                                int r15 = r15.fotos_perfil
                                if (r15 <= 0) goto L_0x06f0
                                boolean r6 = r2.equals(r6)
                                if (r6 != 0) goto L_0x06f0
                                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this
                                java.util.HashMap<java.lang.String, android.graphics.Bitmap> r6 = r6.fotos_m
                                java.lang.Object r6 = r6.get(r5)
                                android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                                java.lang.String r15 = "fperfil_"
                                if (r6 == 0) goto L_0x058e
                                r19 = r10
                                r10 = 0
                                android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r10)
                                r12.setImageBitmap(r6)
                                r20 = r4
                                r22 = r11
                                r21 = r13
                                goto L_0x0667
                            L_0x058e:
                                r19 = r10
                                java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0635 }
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0635 }
                                java.io.File r10 = r10.path     // Catch:{ Exception -> 0x0635 }
                                r20 = r4
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0637 }
                                r4.<init>(r15)     // Catch:{ Exception -> 0x0637 }
                                r4.append(r5)     // Catch:{ Exception -> 0x0637 }
                                r21 = r13
                                java.lang.String r13 = ".jpg"
                                r4.append(r13)     // Catch:{ Exception -> 0x0632 }
                                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0632 }
                                r6.<init>(r10, r4)     // Catch:{ Exception -> 0x0632 }
                                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0632 }
                                r4.<init>()     // Catch:{ Exception -> 0x0632 }
                                r10 = 1
                                r4.inJustDecodeBounds = r10     // Catch:{ Exception -> 0x0632 }
                                java.lang.String r10 = r6.getPath()     // Catch:{ Exception -> 0x0632 }
                                android.graphics.BitmapFactory.decodeFile(r10, r4)     // Catch:{ Exception -> 0x0632 }
                                int r10 = r4.outWidth     // Catch:{ Exception -> 0x0632 }
                                stikerwap.appdys.t_video_exoplayer r10 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0632 }
                                android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x0632 }
                                android.util.DisplayMetrics r10 = r10.getDisplayMetrics()     // Catch:{ Exception -> 0x0632 }
                                float r10 = r10.density     // Catch:{ Exception -> 0x0632 }
                                r13 = 1111490560(0x42400000, float:48.0)
                                float r10 = r10 * r13
                                r13 = 1056964608(0x3f000000, float:0.5)
                                float r10 = r10 + r13
                                int r10 = (int) r10     // Catch:{ Exception -> 0x0632 }
                                stikerwap.appdys.t_video_exoplayer r13 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0632 }
                                android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x0632 }
                                android.util.DisplayMetrics r13 = r13.getDisplayMetrics()     // Catch:{ Exception -> 0x0632 }
                                float r13 = r13.density     // Catch:{ Exception -> 0x0632 }
                                r22 = 1111490560(0x42400000, float:48.0)
                                float r13 = r13 * r22
                                r22 = 1056964608(0x3f000000, float:0.5)
                                float r13 = r13 + r22
                                int r13 = (int) r13
                                r22 = r11
                                int r11 = r4.outWidth     // Catch:{ Exception -> 0x063b }
                                int r4 = r4.outHeight     // Catch:{ Exception -> 0x063b }
                                if (r11 > r10) goto L_0x05f5
                                if (r4 > r13) goto L_0x05f5
                                r23 = 1
                                goto L_0x05f7
                            L_0x05f5:
                                r23 = 0
                            L_0x05f7:
                                if (r23 != 0) goto L_0x0614
                                int r4 = stikerwap.appdys.config.calculateNewWidth(r11, r4, r10, r13)     // Catch:{ Exception -> 0x063b }
                                float r10 = (float) r11     // Catch:{ Exception -> 0x063b }
                                float r4 = (float) r4     // Catch:{ Exception -> 0x063b }
                                float r10 = r10 / r4
                                int r4 = java.lang.Math.round(r10)     // Catch:{ Exception -> 0x063b }
                                android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x063b }
                                r10.<init>()     // Catch:{ Exception -> 0x063b }
                                r10.inSampleSize = r4     // Catch:{ Exception -> 0x063b }
                                java.lang.String r4 = r6.getPath()     // Catch:{ Exception -> 0x063b }
                                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeFile(r4, r10)     // Catch:{ Exception -> 0x063b }
                                goto L_0x0622
                            L_0x0614:
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x063b }
                                android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x063b }
                                android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ Exception -> 0x063b }
                                android.graphics.Bitmap r4 = android.provider.MediaStore.Images.Media.getBitmap(r4, r6)     // Catch:{ Exception -> 0x063b }
                            L_0x0622:
                                r6 = 0
                                android.graphics.Bitmap r10 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r4, r6)     // Catch:{ Exception -> 0x063b }
                                r12.setImageBitmap(r10)     // Catch:{ Exception -> 0x063b }
                                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x063b }
                                java.util.HashMap<java.lang.String, android.graphics.Bitmap> r6 = r6.fotos_m     // Catch:{ Exception -> 0x063b }
                                r6.put(r5, r4)     // Catch:{ Exception -> 0x063b }
                                goto L_0x0667
                            L_0x0632:
                                r22 = r11
                                goto L_0x063b
                            L_0x0635:
                                r20 = r4
                            L_0x0637:
                                r22 = r11
                                r21 = r13
                            L_0x063b:
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r4 = r4.c_fondotxt_esclaro
                                if (r4 == 0) goto L_0x0653
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r4 = r4.getResources()
                                r6 = 2131231691(0x7f0803cb, float:1.807947E38)
                                android.graphics.drawable.Drawable r4 = r4.getDrawable(r6)
                                r12.setImageDrawable(r4)
                                goto L_0x0663
                            L_0x0653:
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r4 = r4.getResources()
                                r6 = 2131231689(0x7f0803c9, float:1.8079466E38)
                                android.graphics.drawable.Drawable r4 = r4.getDrawable(r6)
                                r12.setImageDrawable(r4)
                            L_0x0663:
                                r4 = 0
                                r12.setVisibility(r4)
                            L_0x0667:
                                android.content.SharedPreferences r4 = r4
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>(r15)
                                r6.append(r5)
                                java.lang.String r6 = r6.toString()
                                java.lang.String r4 = r4.getString(r6, r7)
                                boolean r4 = r4.equals(r2)
                                if (r4 != 0) goto L_0x06f8
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r4 = r4.c1_esclaro
                                if (r4 == 0) goto L_0x0691
                                r4 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                                android.view.View r4 = r8.findViewById(r4)
                                r6 = 0
                                r4.setVisibility(r6)
                                goto L_0x069c
                            L_0x0691:
                                r6 = 0
                                r4 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                                android.view.View r4 = r8.findViewById(r4)
                                r4.setVisibility(r6)
                            L_0x069c:
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.acargar_m
                                boolean r4 = r4.containsKey(r5)
                                if (r4 != 0) goto L_0x06f8
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.intentados_m
                                boolean r4 = r4.containsKey(r5)
                                if (r4 == 0) goto L_0x06c0
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.intentados_m
                                java.lang.Object r4 = r4.get(r5)
                                java.lang.String r4 = (java.lang.String) r4
                                boolean r4 = r4.equals(r2)
                                if (r4 != 0) goto L_0x06f8
                            L_0x06c0:
                                stikerwap.appdys.t_video_exoplayer r4 = stikerwap.appdys.t_video_exoplayer.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.acargar_m
                                r4.put(r5, r2)
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.t_video_exoplayer$obtener_foto r2 = r2.o_f
                                if (r2 == 0) goto L_0x06d9
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.t_video_exoplayer$obtener_foto r2 = r2.o_f
                                android.os.AsyncTask$Status r2 = r2.getStatus()
                                android.os.AsyncTask$Status r4 = android.os.AsyncTask.Status.RUNNING
                                if (r2 == r4) goto L_0x06f8
                            L_0x06d9:
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.t_video_exoplayer$obtener_foto r4 = new stikerwap.appdys.t_video_exoplayer$obtener_foto
                                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                                r6 = 0
                                r4.<init>()
                                r2.o_f = r4
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.t_video_exoplayer$obtener_foto r2 = r2.o_f
                                r4 = 0
                                java.lang.String[] r5 = new java.lang.String[r4]
                                r2.execute(r5)
                                goto L_0x06f8
                            L_0x06f0:
                                r20 = r4
                                r19 = r10
                                r22 = r11
                                r21 = r13
                            L_0x06f8:
                                r5 = r19
                            L_0x06fa:
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r2 = r2.globales
                                int r2 = r2.bubbles
                                r4 = 2
                                if (r2 <= 0) goto L_0x0817
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r2 = r2.globales
                                java.lang.String r2 = r2.c_bubbles
                                boolean r2 = r2.equals(r7)
                                if (r2 != 0) goto L_0x072b
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                java.lang.String r6 = "#C0"
                                r2.<init>(r6)
                                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r6 = r6.globales
                                java.lang.String r6 = r6.c_bubbles
                                java.lang.String r6 = r6.substring(r4)
                                r2.append(r6)
                                java.lang.String r2 = r2.toString()
                                int r16 = android.graphics.Color.parseColor(r2)
                            L_0x072b:
                                r2 = r16
                                r6 = 2131230950(0x7f0800e6, float:1.8077967E38)
                                if (r3 == 0) goto L_0x078e
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r3 = r3.getResources()
                                r10 = 2131034118(0x7f050006, float:1.7678745E38)
                                boolean r3 = r3.getBoolean(r10)
                                if (r3 == 0) goto L_0x0769
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x0749
                                goto L_0x07fe
                            L_0x0749:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x0753
                                goto L_0x07dd
                            L_0x0753:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x075e
                                goto L_0x07ea
                            L_0x075e:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07fb
                                goto L_0x07f7
                            L_0x0769:
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x0771
                                goto L_0x07fe
                            L_0x0771:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x077a
                                goto L_0x07ac
                            L_0x077a:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x0784
                                goto L_0x07b9
                            L_0x0784:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07ca
                                goto L_0x07c6
                            L_0x078e:
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r3 = r3.getResources()
                                r10 = 2131034118(0x7f050006, float:1.7678745E38)
                                boolean r3 = r3.getBoolean(r10)
                                if (r3 == 0) goto L_0x07ce
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x07a4
                                goto L_0x07fe
                            L_0x07a4:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x07b0
                            L_0x07ac:
                                r6 = 2131230944(0x7f0800e0, float:1.8077955E38)
                                goto L_0x07fe
                            L_0x07b0:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x07bd
                            L_0x07b9:
                                r6 = 2131230946(0x7f0800e2, float:1.807796E38)
                                goto L_0x07fe
                            L_0x07bd:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07ca
                            L_0x07c6:
                                r6 = 2131230948(0x7f0800e4, float:1.8077963E38)
                                goto L_0x07fe
                            L_0x07ca:
                                r6 = 2131230949(0x7f0800e5, float:1.8077965E38)
                                goto L_0x07fe
                            L_0x07ce:
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x07d5
                                goto L_0x07fe
                            L_0x07d5:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x07e1
                            L_0x07dd:
                                r6 = 2131230943(0x7f0800df, float:1.8077953E38)
                                goto L_0x07fe
                            L_0x07e1:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x07ee
                            L_0x07ea:
                                r6 = 2131230945(0x7f0800e1, float:1.8077957E38)
                                goto L_0x07fe
                            L_0x07ee:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07fb
                            L_0x07f7:
                                r6 = 2131230947(0x7f0800e3, float:1.8077961E38)
                                goto L_0x07fe
                            L_0x07fb:
                                r6 = 2131230942(0x7f0800de, float:1.807795E38)
                            L_0x07fe:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                android.content.res.Resources r0 = r0.getResources()
                                android.graphics.drawable.Drawable r0 = r0.getDrawable(r6)
                                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                                r0.setColorFilter(r2, r3)
                                r2 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                android.view.View r2 = r8.findViewById(r2)
                                r2.setBackgroundDrawable(r0)
                            L_0x0817:
                                android.content.SharedPreferences r0 = r4
                                java.lang.String r0 = r0.getString(r9, r7)
                                boolean r2 = r0.equals(r7)
                                if (r2 != 0) goto L_0x0847
                                r2 = 6
                                r3 = 10
                                java.lang.String r0 = r0.substring(r2, r3)
                                java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
                                java.lang.String r3 = "HHmm"
                                r2.<init>(r3)
                                java.util.Date r0 = r2.parse(r0)     // Catch:{ Exception -> 0x0843 }
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x0843 }
                                java.text.DateFormat r2 = android.text.format.DateFormat.getTimeFormat(r2)     // Catch:{ Exception -> 0x0843 }
                                java.lang.String r0 = r2.format(r0)     // Catch:{ Exception -> 0x0843 }
                                r14.setText(r0)     // Catch:{ Exception -> 0x0843 }
                                goto L_0x0847
                            L_0x0843:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x0847:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                int r0 = r0.fotos_perfil
                                if (r0 <= 0) goto L_0x0850
                                goto L_0x0894
                            L_0x0850:
                                r2 = 8
                                r12.setVisibility(r2)
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 <= 0) goto L_0x0868
                                r3 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                android.view.View r0 = r8.findViewById(r3)
                                r0.setVisibility(r2)
                                goto L_0x0894
                            L_0x0868:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                boolean r0 = r0.c_txt_chats
                                if (r0 == 0) goto L_0x0875
                                r6 = r5
                                r2 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                goto L_0x0885
                            L_0x0875:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                boolean r0 = r0.c1_esclaro
                                if (r0 == 0) goto L_0x0881
                                r2 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                goto L_0x0885
                            L_0x0881:
                                r2 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                r6 = -1
                            L_0x0885:
                                android.view.View r0 = r8.findViewById(r2)
                                r0.setBackgroundColor(r6)
                                android.view.View r0 = r8.findViewById(r2)
                                r2 = 0
                                r0.setVisibility(r2)
                            L_0x0894:
                                r0 = 2131363424(0x7f0a0660, float:1.8346656E38)
                                android.view.View r0 = r8.findViewById(r0)
                                android.widget.TextView r0 = (android.widget.TextView) r0
                                android.content.SharedPreferences r2 = r4
                                java.lang.String r3 = "f2_frase"
                                java.lang.String r2 = r2.getString(r3, r7)
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r6 = "f2_tipo"
                                java.lang.String r3 = r3.getString(r6, r7)
                                r6 = r22
                                r3.equals(r6)
                                boolean r3 = r2.equals(r7)
                                if (r3 != 0) goto L_0x08d4
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                java.lang.CharSequence r2 = stikerwap.appdys.t_chat.addSmileySpans(r3, r2)
                                stikerwap.appdys.t_video_exoplayer r3 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r3 = r3.globales
                                boolean r3 = r3.links_enchats
                                if (r3 == 0) goto L_0x08cd
                                r3 = 1
                                r0.setAutoLinkMask(r3)
                                r0.setLinkTextColor(r5)
                            L_0x08cd:
                                r0.setText(r2)
                                r0.setTextColor(r5)
                                goto L_0x08ef
                            L_0x08d4:
                                android.content.SharedPreferences r0 = r4
                                java.lang.String r2 = "f2_b64"
                                java.lang.String r0 = r0.getString(r2, r7)
                                java.lang.String r2 = "es_ad"
                                boolean r0 = r0.equals(r2)
                                if (r0 == 0) goto L_0x08ef
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                stikerwap.appdys.config r0 = r0.globales
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                int r2 = r2.width_ad
                                r0.mostrar_inchat_post(r8, r5, r2)
                            L_0x08ef:
                                android.content.SharedPreferences r0 = r4
                                r2 = r21
                                java.lang.String r0 = r0.getString(r2, r7)
                                r8.setTag(r0)
                                android.content.SharedPreferences r0 = r4
                                r3 = r20
                                r2 = 0
                                boolean r0 = r0.getBoolean(r3, r2)
                                if (r0 == 0) goto L_0x090d
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                android.widget.LinearLayout r0 = r0.llchat
                                r0.addView(r8, r2)
                                goto L_0x0928
                            L_0x090d:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                android.widget.LinearLayout r0 = r0.llchat
                                r0.addView(r8)
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                android.widget.LinearLayout r0 = r0.llchat
                                int r0 = r0.getChildCount()
                                r2 = 200(0xc8, float:2.8E-43)
                                if (r0 <= r2) goto L_0x0928
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                android.widget.LinearLayout r0 = r0.llchat
                                r2 = 0
                                r0.removeViewAt(r2)
                            L_0x0928:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                int r2 = r0.nfrases
                                r3 = 1
                                int r2 = r2 + r3
                                r0.nfrases = r2
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                int r0 = r0.nfrases
                                if (r0 != r3) goto L_0x094a
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                r2 = 2131363531(0x7f0a06cb, float:1.8346873E38)
                                android.view.View r0 = r0.findViewById(r2)
                                r2 = 8
                                r0.setVisibility(r2)
                                goto L_0x0960
                            L_0x094a:
                                r2 = 8
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                int r0 = r0.nfrases
                                if (r0 != r4) goto L_0x0960
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                r3 = 2131363532(0x7f0a06cc, float:1.8346875E38)
                                android.view.View r0 = r0.findViewById(r3)
                                r0.setVisibility(r2)
                            L_0x0960:
                                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                                r2 = 2131363236(0x7f0a05a4, float:1.8346275E38)
                                android.view.View r0 = r0.findViewById(r2)
                                android.widget.ScrollView r0 = (android.widget.ScrollView) r0
                                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this
                                android.widget.LinearLayout r2 = r2.llchat
                                int r2 = r2.getMeasuredHeight()
                                int r3 = r0.getScrollY()
                                int r4 = r0.getHeight()
                                int r3 = r3 + r4
                                if (r2 > r3) goto L_0x0986
                                stikerwap.appdys.t_video_exoplayer$13$2 r2 = new stikerwap.appdys.t_video_exoplayer$13$2
                                r2.<init>()
                                r0.post(r2)
                            L_0x0986:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_exoplayer.AnonymousClass13.run():void");
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_fecha() {
        boolean z;
        Date date;
        if (!this.dia_act.equals("")) {
            try {
                date = new SimpleDateFormat("ddMMyy").parse(this.dia_act);
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                date = null;
                z = false;
            }
            if (z) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i = this.TV_MARGIN;
                layoutParams.setMargins(0, i * 8, 0, i * 2);
                layoutParams.gravity = 1;
                textView.setLayoutParams(layoutParams);
                textView.setGravity(1);
                textView.setBackgroundResource(R.drawable.fondo_rounded_fecha);
                textView.setTextSize(1, 13.0f);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextColor(-12303292);
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(date);
                if (instance2.get(1) == instance.get(1) && instance2.get(6) == instance.get(6)) {
                    textView.setText(getResources().getString(R.string.hoy));
                } else {
                    textView.setText(DateFormat.getDateFormat(this).format(date));
                }
                this.llchat.addView(textView, 0);
            }
        }
    }

    private class enviar extends AsyncTask<String, Void, String> {
        private enviar() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            Iterator<String> it = t_video_exoplayer.this.spool.iterator();
            while (it.hasNext()) {
                try {
                    it.remove();
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                    HttpPost httpPost = new HttpPost(config.PROTOC_GEN + "gcm." + config.DOM_EDROID + "/enviar_mensaje.php");
                    MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                    multipartEntity.addPart("v", new StringBody("4"));
                    multipartEntity.addPart("idapp", new StringBody("3008836"));
                    multipartEntity.addPart("idusu", new StringBody(t_video_exoplayer.this.idusu + ""));
                    multipartEntity.addPart("c", new StringBody(t_video_exoplayer.this.codigo));
                    multipartEntity.addPart("idtema", new StringBody(t_video_exoplayer.this.idtema + ""));
                    multipartEntity.addPart("idusudest", new StringBody("0"));
                    multipartEntity.addPart("externo", new StringBody("0"));
                    multipartEntity.addPart("m", new StringBody(URLEncoder.encode(it.next(), "UTF-8")));
                    httpPost.setEntity(multipartEntity);
                    httpPost.setHeader("User-Agent", "Android Vinebre Software");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        }
                    }
                } catch (Exception unused) {
                    return "KO";
                }
            }
            return "OK";
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.equals("OK") && t_video_exoplayer.this.spool.size() > 0) {
                t_video_exoplayer t_video_exoplayer = t_video_exoplayer.this;
                t_video_exoplayer.env = new enviar();
                t_video_exoplayer.this.env.execute(new String[0]);
            }
        }
    }

    private class obtener_foto extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idusu_acargar;
        String vfoto_acargar;

        private obtener_foto() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_video_exoplayer.this.acargar_m.equals("")) {
                cancel(false);
                return;
            }
            try {
                this.idusu_acargar = (String) t_video_exoplayer.this.acargar_m.keySet().toArray()[0];
            } catch (Exception unused) {
                cancel(false);
            }
            if (this.idusu_acargar != null) {
                this.vfoto_acargar = t_video_exoplayer.this.acargar_m.get(this.idusu_acargar);
                t_video_exoplayer.this.intentados_m.put(this.idusu_acargar, t_video_exoplayer.this.acargar_m.get(this.idusu_acargar));
                t_video_exoplayer.this.acargar_m.remove(this.idusu_acargar);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "fperfil_"
                java.lang.String r0 = r4.idusu_acargar
                java.lang.String r1 = "0"
                if (r0 == 0) goto L_0x0088
                java.lang.String r0 = r4.vfoto_acargar
                if (r0 != 0) goto L_0x000d
                goto L_0x0088
            L_0x000d:
                java.net.URL r0 = new java.net.URL     // Catch:{  }
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
                java.lang.String r3 = r4.vfoto_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r0.<init>(r2)     // Catch:{  }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r2 = 1
                r0.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r0.setReadTimeout(r2)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r2 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
                r4.bmImg = r3     // Catch:{  }
                r2.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                java.io.File r0 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_video_exoplayer r2 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r5)     // Catch:{  }
                java.lang.String r5 = r4.idusu_acargar     // Catch:{  }
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = ".jpg"
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = r3.toString()     // Catch:{  }
                r0.<init>(r2, r5)     // Catch:{  }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x0088 }
                r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x0088 }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x0088 }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x0088 }
                r3 = 70
                r0.compress(r2, r3, r5)     // Catch:{ MalformedURLException -> 0x0088 }
                java.lang.String r5 = "1"
                return r5
            L_0x0088:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_exoplayer.obtener_foto.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (t_video_exoplayer.this.fotos_m != null) {
                if (str == "1") {
                    t_video_exoplayer.this.fotos_m.put(this.idusu_acargar, this.bmImg);
                    SharedPreferences.Editor edit = t_video_exoplayer.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, t_video_exoplayer.this.intentados_m.get(this.idusu_acargar));
                    edit.commit();
                }
                int childCount = t_video_exoplayer.this.llchat.getChildCount();
                int i = 0;
                while (i < childCount) {
                    try {
                        String str2 = (String) t_video_exoplayer.this.llchat.getChildAt(i).getTag();
                        if (str2 != null && str2.equals(this.idusu_acargar)) {
                            t_video_exoplayer.this.llchat.getChildAt(i).findViewById(R.id.pb_foto).setVisibility(8);
                            t_video_exoplayer.this.llchat.getChildAt(i).findViewById(R.id.pb_foto_inv).setVisibility(8);
                            if (str == "1") {
                                ((ImageView) t_video_exoplayer.this.llchat.getChildAt(i).findViewById(R.id.iv_avatar_f)).setImageBitmap(config.getCircularBitmapWithWhiteBorder(this.bmImg, 0));
                            }
                        }
                        i++;
                    } catch (Exception unused) {
                    }
                }
                if (!t_video_exoplayer.this.acargar_m.equals("")) {
                    t_video_exoplayer t_video_exoplayer = t_video_exoplayer.this;
                    t_video_exoplayer.o_f = new obtener_foto();
                    t_video_exoplayer.this.o_f.execute(new String[0]);
                }
            }
        }
    }

    private class cargar_ultimas extends AsyncTask<String, Void, String> {
        private String idconversante;
        private int idfrase_masantigua;
        private String idprivado_finalizar;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        public cargar_ultimas(String str, String str2, int i) {
            this.idprivado_finalizar = str;
            this.idconversante = str2;
            this.idfrase_masantigua = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
                r0.<init>()     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "/srv/ultimas_frases.php?ver=1&idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x00b1 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idtema="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_video_exoplayer r1 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x00b1 }
                int r1 = r1.idtema     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idf="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                int r1 = r5.idfrase_masantigua     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idprivado_finalizar=0&idconversante="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = r5.idconversante     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&externo=0"
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b1 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b1 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00b1 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x00b1 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b1 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            L_0x0083:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r2 == 0) goto L_0x009e
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                goto L_0x0083
            L_0x009e:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r0 == 0) goto L_0x00a7
                r0.disconnect()
            L_0x00a7:
                return r6
            L_0x00a8:
                r6 = move-exception
                goto L_0x00b9
            L_0x00aa:
                r6 = r0
                goto L_0x00b1
            L_0x00ac:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00b9
            L_0x00b1:
                java.lang.String r0 = "ANDROID:KO"
                if (r6 == 0) goto L_0x00b8
                r6.disconnect()
            L_0x00b8:
                return r0
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                goto L_0x00c0
            L_0x00bf:
                throw r6
            L_0x00c0:
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_exoplayer.cargar_ultimas.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            boolean z;
            int i;
            String str3;
            String str4 = str;
            if (this.idfrase_masantigua != -1) {
                if (str4.indexOf("ANDROID:OK") != -1 || str4.indexOf("ANDROID:KO") != -1 || str4.indexOf("ANDROID:PERFILKO") != -1) {
                    if (str4.indexOf("ANDROID:PERFILKO") != -1) {
                        final AlertDialog create = new AlertDialog.Builder(t_video_exoplayer.this).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).setMessage(R.string.perfil_desactivado).create();
                        if (!t_video_exoplayer.this.cbtn.equals("")) {
                            create.setOnShowListener(new DialogInterface.OnShowListener() {
                                public void onShow(DialogInterface dialogInterface) {
                                    Button button = create.getButton(-1);
                                    button.setTextColor(Color.parseColor("#" + t_video_exoplayer.this.cbtn));
                                    Button button2 = create.getButton(-2);
                                    button2.setTextColor(Color.parseColor("#" + t_video_exoplayer.this.cbtn));
                                }
                            });
                        }
                        create.show();
                        try {
                            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                        } catch (Exception unused) {
                        }
                    } else if (str4.indexOf("ANDROID:OK") != -1) {
                        int indexOf = str4.indexOf("@XYY53@");
                        String str5 = "";
                        String str6 = str5;
                        boolean z2 = false;
                        for (int i2 = -1; indexOf != i2; i2 = -1) {
                            int indexOf2 = str4.indexOf("@", indexOf + 1) + 1;
                            int indexOf3 = str4.indexOf("@", indexOf2);
                            String substring = str4.substring(indexOf2, indexOf3);
                            t_video_exoplayer.this.idfrase_masantigua_glob = Integer.parseInt(substring);
                            int i3 = indexOf3 + 1;
                            int indexOf4 = str4.indexOf("@", i3);
                            String substring2 = str4.substring(i3, indexOf4);
                            int i4 = indexOf4 + 1;
                            int indexOf5 = str4.indexOf("@", i4);
                            String substring3 = str4.substring(i4, indexOf5);
                            int i5 = indexOf5 + 1;
                            int indexOf6 = str4.indexOf("@", i5);
                            String substring4 = str4.substring(i5, indexOf6);
                            int i6 = indexOf6 + 1;
                            int indexOf7 = str4.indexOf("@", i6);
                            String substring5 = str4.substring(i6, indexOf7);
                            int i7 = indexOf7 + 1;
                            String str7 = substring5;
                            int indexOf8 = str4.indexOf("@", i7);
                            String substring6 = str4.substring(i7, indexOf8);
                            int i8 = indexOf8 + 1;
                            String str8 = substring6;
                            int indexOf9 = str4.indexOf("@", i8);
                            String substring7 = str4.substring(i8, indexOf9);
                            int i9 = indexOf9 + 1;
                            String str9 = substring7;
                            int indexOf10 = str4.indexOf("@", i9);
                            String substring8 = str4.substring(i9, indexOf10);
                            int i10 = indexOf10 + 1;
                            String str10 = substring8;
                            int indexOf11 = str4.indexOf("@", i10);
                            String substring9 = str4.substring(i10, indexOf11);
                            int i11 = indexOf11 + 1;
                            String str11 = substring9;
                            int indexOf12 = str4.indexOf("@", i11);
                            String substring10 = str4.substring(i11, indexOf12);
                            int i12 = indexOf12 + 1;
                            String str12 = substring10;
                            int indexOf13 = str4.indexOf("@", i12);
                            String substring11 = str4.substring(i12, indexOf13);
                            int i13 = indexOf13 + 1;
                            String str13 = substring11;
                            int indexOf14 = str4.indexOf("@", i13);
                            String substring12 = str4.substring(i13, indexOf14);
                            int i14 = indexOf14 + 1;
                            int indexOf15 = str4.indexOf("@", i14);
                            String substring13 = str4.substring(i14, indexOf15);
                            if (str5.equals("") || substring4.equals("") || !str5.equals(substring4) || str6.equals("") || substring2.equals("") || !str6.equals(substring2)) {
                                int indexOf16 = str4.indexOf("@XYY53@", indexOf15);
                                if (indexOf16 != -1) {
                                    int indexOf17 = str4.indexOf("@", str4.indexOf("@", indexOf16 + 1) + 1) + 1;
                                    str2 = str4.substring(indexOf17, str4.indexOf("@", indexOf17));
                                } else {
                                    str2 = "";
                                }
                                if (z2 || str4.indexOf("ZXRT4@1@") != -1) {
                                    z = z2;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    z = z2;
                                    sb.append(t_video_exoplayer.this.idusu);
                                    sb.append("");
                                    if (substring2.equals(sb.toString())) {
                                        int i15 = indexOf15;
                                        while (true) {
                                            int indexOf18 = str4.indexOf("@XYY53@", i15);
                                            if (indexOf18 != -1) {
                                                int indexOf19 = str4.indexOf("@", str4.indexOf("@", indexOf18 + 1) + 1) + 1;
                                                i = str4.indexOf("@", indexOf19);
                                                str3 = str4.substring(indexOf19, i);
                                            } else {
                                                i = i15;
                                                str3 = "";
                                            }
                                            if (str3.equals("")) {
                                                z2 = true;
                                                break;
                                            } else if (!str3.equals(substring2)) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i15 = i;
                                            }
                                        }
                                        SharedPreferences.Editor edit = t_video_exoplayer.this.settings.edit();
                                        edit.putString("f2_idfrase", substring);
                                        edit.putString("f2_id", substring2);
                                        edit.putString("f2_idusu_prev", str2);
                                        edit.putBoolean("f2_mateixusu_hastafinal", z2);
                                        edit.putString("f2_nombre", substring3);
                                        edit.putString("f2_privados", str8);
                                        edit.putString("f2_frase", substring4);
                                        edit.putString("f2_fcrea", config.convertir_fecha(str9));
                                        edit.putString("f2_b64", "");
                                        edit.putString("f2_tipo", substring13);
                                        edit.putString("f2_b64_th", "");
                                        edit.putString("f2_idvideo", "");
                                        edit.putString("f2_formato", "");
                                        edit.putString("f2_idtema", t_video_exoplayer.this.idtema + "");
                                        edit.putString("f2_vfoto", str7);
                                        edit.putString("f2_fnac_d", str10);
                                        edit.putString("f2_fnac_m", str11);
                                        edit.putString("f2_fnac_a", str12);
                                        edit.putString("f2_sexo", str13);
                                        edit.putString("f2_coments", substring12);
                                        edit.putBoolean("f2_ultimas", true);
                                        edit.putString("f2_ts", System.currentTimeMillis() + "");
                                        edit.commit();
                                        str6 = substring2;
                                        str5 = substring4;
                                    }
                                }
                                z2 = z;
                                SharedPreferences.Editor edit2 = t_video_exoplayer.this.settings.edit();
                                edit2.putString("f2_idfrase", substring);
                                edit2.putString("f2_id", substring2);
                                edit2.putString("f2_idusu_prev", str2);
                                edit2.putBoolean("f2_mateixusu_hastafinal", z2);
                                edit2.putString("f2_nombre", substring3);
                                edit2.putString("f2_privados", str8);
                                edit2.putString("f2_frase", substring4);
                                edit2.putString("f2_fcrea", config.convertir_fecha(str9));
                                edit2.putString("f2_b64", "");
                                edit2.putString("f2_tipo", substring13);
                                edit2.putString("f2_b64_th", "");
                                edit2.putString("f2_idvideo", "");
                                edit2.putString("f2_formato", "");
                                edit2.putString("f2_idtema", t_video_exoplayer.this.idtema + "");
                                edit2.putString("f2_vfoto", str7);
                                edit2.putString("f2_fnac_d", str10);
                                edit2.putString("f2_fnac_m", str11);
                                edit2.putString("f2_fnac_a", str12);
                                edit2.putString("f2_sexo", str13);
                                edit2.putString("f2_coments", substring12);
                                edit2.putBoolean("f2_ultimas", true);
                                edit2.putString("f2_ts", System.currentTimeMillis() + "");
                                edit2.commit();
                                str6 = substring2;
                                str5 = substring4;
                            }
                            indexOf = str4.indexOf("@XYY53@", indexOf15);
                        }
                        if (str4.indexOf("ZXRT4@1@") == -1) {
                            t_video_exoplayer.this.mostrar_fecha();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void empezar_video() {
        this.playerView.setControllerAutoShow(true);
        this.uri_glob = Uri.parse(this.extras.getString("url"));
        if (this.globales.video_ls) {
            setRequestedOrientation(0);
        }
        if (this.globales.video_fs) {
            openFullscreenDialog(false);
        }
        findViewById(R.id.pb_video).setVisibility(0);
        MediaItem fromUri = MediaItem.fromUri(this.uri_glob);
        if (fromUri != null) {
            this.player.setPlayWhenReady(true);
            this.player.setMediaItem(fromUri);
            this.player.prepare();
        }
    }

    private void cambiar_ui(boolean z) {
        int i = 0;
        if (z) {
            findViewById(R.id.btn_verchat).setVisibility(8);
            findViewById(R.id.ll_ad).setVisibility(8);
            findViewById(R.id.navigation_b).setVisibility(8);
            ((ViewGroup) findViewById(R.id.ll_princ)).getChildAt(0).setVisibility(8);
            ((PlayerControlView) this.playerView.findViewById(R.id.exo_controller)).hide();
        } else {
            if (this.con_chat) {
                findViewById(R.id.btn_verchat).setVisibility(0);
            }
            if (config.mb_items.length > 0) {
                findViewById(R.id.navigation_b).setVisibility(0);
            }
            if (this.estado_ad != -1) {
                findViewById(R.id.ll_ad).setVisibility(this.estado_ad);
            }
            if (this.globales.tipomenu != 3) {
                ((ViewGroup) findViewById(R.id.ll_princ)).getChildAt(0).setVisibility(0);
            }
            ((PlayerControlView) this.playerView.findViewById(R.id.exo_controller)).show();
        }
        if (!ViewConfiguration.get(this).hasPermanentMenuKey()) {
            if (z) {
                i = 5894;
            }
            getWindow().getDecorView().setSystemUiVisibility(i);
        } else if (z) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().clearFlags(1024);
        }
    }

    private void initFullscreenButton() {
        FrameLayout frameLayout = (FrameLayout) ((PlayerControlView) this.playerView.findViewById(R.id.exo_controller)).findViewById(R.id.exo_fullscreen_button);
        this.mFullScreenButton = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!t_video_exoplayer.this.mExoPlayerFullscreen.booleanValue()) {
                    t_video_exoplayer.this.openFullscreenDialog(false);
                } else {
                    t_video_exoplayer.this.closeFullscreenDialog();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void openFullscreenDialog(boolean z) {
        if (!this.mExoPlayerFullscreen.booleanValue() || z) {
            Boolean bool = true;
            this.mExoPlayerFullscreen = bool;
            cambiar_ui(bool.booleanValue());
        }
    }

    /* access modifiers changed from: private */
    public void closeFullscreenDialog() {
        if (this.mExoPlayerFullscreen.booleanValue()) {
            Boolean bool = false;
            this.mExoPlayerFullscreen = bool;
            cambiar_ui(bool.booleanValue());
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnemotic) {
            new EmojisMenu((EditText) findViewById(R.id.c_mensaje), this).show();
        } else if (view.getId() == R.id.btnenv) {
            f_enviar(false);
        } else if ((view.getId() == R.id.ll_frase_txt || view.getId() == R.id.fl_frase) && ((View) view.getParent()).getTag(R.id.idaux1) != null && !((View) view.getParent()).getTag(R.id.idaux1).equals("0") && !((View) view.getParent()).getTag(R.id.idaux1).equals("1")) {
            View view2 = (View) view.getParent();
            Intent intent = new Intent(this, profile.class);
            intent.putExtra("id", (String) view2.getTag(R.id.idaux1));
            intent.putExtra("privados", (String) view2.getTag(R.id.idaux2));
            intent.putExtra("nombre", (String) view2.getTag(R.id.idaux3));
            intent.putExtra("coments", (String) view2.getTag(R.id.idaux4));
            intent.putExtra("fnac_d", (String) view2.getTag(R.id.idaux5));
            intent.putExtra("fnac_m", (String) view2.getTag(R.id.idaux6));
            intent.putExtra("fnac_a", (String) view2.getTag(R.id.idaux7));
            intent.putExtra("sexo", (String) view2.getTag(R.id.idaux8));
            intent.putExtra("vfoto", (String) view2.getTag(R.id.idaux9));
            intent.putExtra("p_fnac", this.fnac);
            intent.putExtra("p_sexo", this.sexo);
            intent.putExtra("p_descr", this.descr);
            intent.putExtra("p_dist", this.dist);
            intent.putExtra("coments_chat", this.coments);
            intent.putExtra("galeria", this.galeria);
            intent.putExtra("privados_chat", this.privados);
            intent.putExtra("fotos_perfil", this.fotos_perfil);
            intent.putExtra("fotos_chat", this.fotos_chat);
            startActivityForResult(intent, 0);
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config != null && config.onActivityResult_glob(i, i2, intent, this)) || i2 != -1) {
            return;
        }
        if (intent == null || !intent.hasExtra("finalizar")) {
            if (intent != null && intent.hasExtra("idusu_ban")) {
                t_chat.ocultar_frases(this, intent.getStringExtra("idusu_ban"));
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
                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x007b }
                stikerwap.appdys.config r6 = r6.globales     // Catch:{ Exception -> 0x007b }
                java.lang.String r6 = r6.appnext_video_cod     // Catch:{ Exception -> 0x007b }
                r1.append(r6)     // Catch:{ Exception -> 0x007b }
                java.lang.String r6 = "&type=vast&vast_ver=3.0&duration=all&packageId="
                r1.append(r6)     // Catch:{ Exception -> 0x007b }
                stikerwap.appdys.t_video_exoplayer r6 = stikerwap.appdys.t_video_exoplayer.this     // Catch:{ Exception -> 0x007b }
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
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_exoplayer.cargar_anun.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x008b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.String r0 = "<Ad id="
                boolean r0 = r7.contains(r0)
                r1 = 1
                if (r0 == 0) goto L_0x0055
                java.lang.String r0 = "<Impression><![CDATA["
                int r0 = r7.indexOf(r0)
                r2 = -1
                if (r0 == r2) goto L_0x0055
                int r0 = r0 + 21
                java.lang.String r3 = "]"
                int r4 = r7.indexOf(r3, r0)
                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                java.lang.String r0 = r7.substring(r0, r4)
                r5.url_imp = r0
                java.lang.String r0 = "<ClickThrough><![CDATA["
                int r0 = r7.indexOf(r0)
                if (r0 == r2) goto L_0x0055
                int r0 = r0 + 23
                int r4 = r7.indexOf(r3, r0)
                stikerwap.appdys.t_video_exoplayer r5 = stikerwap.appdys.t_video_exoplayer.this
                java.lang.String r0 = r7.substring(r0, r4)
                r5.url_click = r0
                java.lang.String r0 = "width=\"320\" height=\"180\""
                int r0 = r7.indexOf(r0)
                if (r0 == r2) goto L_0x0055
                java.lang.String r4 = "><![CDATA["
                int r0 = r7.indexOf(r4, r0)
                if (r0 == r2) goto L_0x0055
                int r0 = r0 + 10
                int r2 = r7.indexOf(r3, r0)
                java.lang.String r7 = r7.substring(r0, r2)
                r0 = r7
                r7 = 1
                goto L_0x0058
            L_0x0055:
                r7 = 0
                java.lang.String r0 = ""
            L_0x0058:
                if (r7 == 0) goto L_0x008b
                android.net.Uri r7 = android.net.Uri.parse(r0)
                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                r2 = 2131361979(0x7f0a00bb, float:1.8343726E38)
                android.view.View r0 = r0.findViewById(r2)
                stikerwap.appdys.t_video_exoplayer$cargar_anun$1 r2 = new stikerwap.appdys.t_video_exoplayer$cargar_anun$1
                r2.<init>()
                r0.setOnClickListener(r2)
                androidx.media3.common.MediaItem r7 = androidx.media3.common.MediaItem.fromUri((android.net.Uri) r7)
                if (r7 == 0) goto L_0x0090
                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                androidx.media3.exoplayer.ExoPlayer r0 = r0.player
                r0.setPlayWhenReady(r1)
                stikerwap.appdys.t_video_exoplayer r0 = stikerwap.appdys.t_video_exoplayer.this
                androidx.media3.exoplayer.ExoPlayer r0 = r0.player
                r0.setMediaItem(r7)
                stikerwap.appdys.t_video_exoplayer r7 = stikerwap.appdys.t_video_exoplayer.this
                androidx.media3.exoplayer.ExoPlayer r7 = r7.player
                r7.prepare()
                goto L_0x0090
            L_0x008b:
                stikerwap.appdys.t_video_exoplayer r7 = stikerwap.appdys.t_video_exoplayer.this
                r7.empezar_video()
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_exoplayer.cargar_anun.onPostExecute(java.lang.String):void");
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
        super.onPause();
        config.onPause_global(this);
        if (!(Build.VERSION.SDK_INT >= 24 && isInPictureInPictureMode())) {
            try {
                this.player.setPlayWhenReady(false);
                findViewById(R.id.exo_pause).setVisibility(8);
                findViewById(R.id.exo_play).setVisibility(0);
            } catch (Exception unused) {
            }
        }
        if (this.globales.video_cast) {
            try {
                SessionManager sessionManager = this.mSessionManager;
                if (sessionManager != null) {
                    sessionManager.removeSessionManagerListener(this.mSessionManagerListener);
                }
                this.mCastSession = null;
            } catch (Exception unused2) {
            }
        }
    }

    public void onStop() {
        super.onStop();
        if ((this.finalizar && !this.buscador_on) || (Build.VERSION.SDK_INT >= 24 && isInPictureInPictureMode())) {
            finish();
        }
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        SessionManager sessionManager;
        try {
            if (this.globales.video_cast && (sessionManager = this.mSessionManager) != null) {
                this.mCastSession = sessionManager.getCurrentCastSession();
                this.mSessionManager.addSessionManagerListener(this.mSessionManagerListener);
            }
        } catch (Exception unused) {
        }
        super.onResume();
        config.onResume_global(this);
        CastSession castSession = this.mCastSession;
        if (castSession == null || !castSession.isConnected()) {
            try {
                this.player.setPlayWhenReady(true);
            } catch (Exception unused2) {
            }
            findViewById(R.id.exo_play).setVisibility(8);
            findViewById(R.id.exo_pause).setVisibility(0);
        }
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.resume();
        }
        if (this.estado_ad == -1) {
            this.estado_ad = findViewById(R.id.ll_ad).getVisibility();
            if (this.globales.video_fs) {
                openFullscreenDialog(false);
            }
        }
        if (this.con_chat && this.logineado_ok) {
            this.settings.registerOnSharedPreferenceChangeListener(this);
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return;
        }
        if (exoPlayer.isPlaying() || (this.player.getPlayWhenReady() && this.player.getPlaybackState() == 3)) {
            findViewById(R.id.pb_video).setVisibility(8);
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
        try {
            this.player.release();
        } catch (Exception unused) {
        }
        if (this.con_chat && this.logineado_ok) {
            try {
                this.settings.unregisterOnSharedPreferenceChangeListener(this);
            } catch (Exception unused2) {
            }
        }
        if ((this.es_root && isFinishing()) || config.finalizar_app) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Anuncios anuncios;
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
        Anuncios anuncios2 = this.anun;
        if (!(anuncios2 == null || anuncios2.adView == null)) {
            try {
                this.anun.adView.destroy();
            } catch (Exception unused) {
            }
        }
        Anuncios anuncios3 = this.anun;
        if (!(anuncios3 == null || anuncios3.adView_fb == null)) {
            try {
                this.anun.adView_fb.destroy();
            } catch (Exception unused2) {
            }
        }
        Anuncios anuncios4 = this.anun;
        if (!(anuncios4 == null || anuncios4.wortiseBanner == null)) {
            try {
                this.anun.wortiseBanner.destroy();
            } catch (Exception unused3) {
            }
        }
        this.anun = this.globales.mostrar_banner(this, false);
        if (findViewById(R.id.sv_chat).getVisibility() == 0 && !this.globales.banners_enchats && (anuncios = this.anun) != null && anuncios.adView != null) {
            ocultar_banner();
        }
        if (this.mExoPlayerFullscreen.booleanValue()) {
            findViewById(R.id.ll_ad).setVisibility(8);
            findViewById(R.id.navigation_b).setVisibility(8);
            ((ViewGroup) findViewById(R.id.ll_princ)).getChildAt(0).setVisibility(8);
        }
    }

    public void onBackPressed() {
        if (findViewById(R.id.sv_chat).getVisibility() == 0) {
            cerrar_chat();
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
                if (!t_video_exoplayer.this.globales.admob_rew_failed(context, t_video_exoplayer.this.mAd_appnext)) {
                    t_video_exoplayer.this.dialog_cargando.cancel();
                    t_video_exoplayer t_video_exoplayer = t_video_exoplayer.this;
                    t_video_exoplayer.abrir_secc(t_video_exoplayer.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_video_exoplayer.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_video_exoplayer.this.abrir_secc(t_video_exoplayer.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_video_exoplayer.this.mAd_visto) {
                            t_video_exoplayer.this.abrir_secc(t_video_exoplayer.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_video_exoplayer.this.mAd_visto = true;
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
                if (t_video_exoplayer.this.mAd_visto) {
                    t_video_exoplayer t_video_exoplayer = t_video_exoplayer.this;
                    t_video_exoplayer.abrir_secc(t_video_exoplayer.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
