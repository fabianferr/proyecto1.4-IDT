package stikerwap.appdys;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class s_mediaplayer_exo extends Service implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, AudioManager.OnAudioFocusChangeListener {
    protected static final Handler TIME_THREAD = new Handler();
    protected static final Handler TIME_THREAD_BTNS = new Handler();
    protected static final Handler TIME_THREAD_MC = new Handler();
    protected static final Handler TIME_THREAD_MC_RELEASE = new Handler();
    SharedPreferences.Editor editor_mc;
    SharedPreferences.Editor editor_mp;
    boolean esStream = true;
    Boolean f_img_notif_activ = false;
    boolean foreground = false;
    IcyStreamMeta icy;
    int idsecc = 0;
    boolean isPlaying_glob = false;
    private AudioManager mAudioManager;
    protected Runnable mcRunnable = new Runnable() {
        public void run() {
            s_mediaplayer_exo.this.update_mc();
        }
    };
    protected Runnable mcRunnableBtns = new Runnable() {
        public void run() {
            if (s_mediaplayer_exo.this.foreground) {
                s_mediaplayer_exo s_mediaplayer_exo = s_mediaplayer_exo.this;
                s_mediaplayer_exo.startForeground(4, s_mediaplayer_exo.crearNotif(s_mediaplayer_exo.txt_act));
            }
        }
    };
    protected Runnable mcRunnableRelease = new Runnable() {
        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
                stikerwap.appdys.s_mediaplayer_exo r0 = stikerwap.appdys.s_mediaplayer_exo.this
                r0.update_mc()
                stikerwap.appdys.s_mediaplayer_exo r0 = stikerwap.appdys.s_mediaplayer_exo.this     // Catch:{ Exception -> 0x000c }
                androidx.media3.exoplayer.ExoPlayer r0 = r0.mp     // Catch:{ Exception -> 0x000c }
                r0.release()     // Catch:{ Exception -> 0x000c }
            L_0x000c:
                stikerwap.appdys.s_mediaplayer_exo r0 = stikerwap.appdys.s_mediaplayer_exo.this     // Catch:{ Exception -> 0x0011 }
                r1 = 0
                r0.mp = r1     // Catch:{ Exception -> 0x0011 }
            L_0x0011:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_mediaplayer_exo.AnonymousClass5.run():void");
        }
    };
    ExoPlayer mp;
    int radio_mostrar = 0;
    String secc_tit;
    SharedPreferences sh_mc;
    SharedPreferences sh_mp;
    Timer timer;
    String txt_act = "";
    protected Runnable updateTimeRunnable = new Runnable() {
        public void run() {
            s_mediaplayer_exo.this.updateState();
            s_mediaplayer_exo.TIME_THREAD.postDelayed(this, 200);
        }
    };
    String url_act;
    WifiManager.WifiLock wifiLock;

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void f_img_notif_run(Seccion seccion) {
        if (!this.f_img_notif_activ.booleanValue()) {
            new Thread(new s_mediaplayer_exo$$ExternalSyntheticLambda0(this, seccion)).start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f_img_notif_run_2 */
    public void m1436lambda$f_img_notif_run$0$stikerwapappdyss_mediaplayer_exo(Seccion seccion) {
        this.f_img_notif_activ = true;
        Bitmap bitmapFromURL = config.getBitmapFromURL(config.DOM_CDN + "/srv/imgs/radio/n" + seccion.id + ".png?v=" + seccion.v_img_notif);
        if (bitmapFromURL != null) {
            try {
                FileOutputStream openFileOutput = openFileOutput("img_notif_" + seccion.id, 0);
                bitmapFromURL.compress(Bitmap.CompressFormat.PNG, 100, openFileOutput);
                openFileOutput.close();
                SharedPreferences.Editor edit = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit.putInt("v_img_notif_act_" + seccion.id, seccion.v_img_notif).commit();
                if (this.foreground) {
                    startForeground(4, crearNotif(this.txt_act));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f_img_notif_activ = false;
    }

    private void getMeta() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(1);
        } catch (Exception unused) {
            networkInfo = null;
        }
        int i = (networkInfo == null || !networkInfo.isConnected()) ? 10000 : 5000;
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(new TimerTask() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: stikerwap.appdys.s_mediaplayer_exo} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.String} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0065  */
            /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    java.lang.String r0 = ""
                    stikerwap.appdys.s_mediaplayer_exo r1 = stikerwap.appdys.s_mediaplayer_exo.this
                    boolean r1 = r1.esStream
                    if (r1 == 0) goto L_0x00eb
                    stikerwap.appdys.s_mediaplayer_exo r1 = stikerwap.appdys.s_mediaplayer_exo.this
                    boolean r1 = r1.foreground
                    if (r1 == 0) goto L_0x00eb
                    stikerwap.appdys.s_mediaplayer_exo r1 = stikerwap.appdys.s_mediaplayer_exo.this
                    int r1 = r1.radio_mostrar
                    if (r1 <= 0) goto L_0x00eb
                    r1 = 1
                    stikerwap.appdys.s_mediaplayer_exo r2 = stikerwap.appdys.s_mediaplayer_exo.this     // Catch:{ MalformedURLException -> 0x004e }
                    stikerwap.appdys.IcyStreamMeta r3 = new stikerwap.appdys.IcyStreamMeta     // Catch:{ MalformedURLException -> 0x004e }
                    java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x004e }
                    stikerwap.appdys.s_mediaplayer_exo r5 = stikerwap.appdys.s_mediaplayer_exo.this     // Catch:{ MalformedURLException -> 0x004e }
                    java.lang.String r5 = r5.url_act     // Catch:{ MalformedURLException -> 0x004e }
                    r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x004e }
                    r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x004e }
                    r2.icy = r3     // Catch:{ MalformedURLException -> 0x004e }
                    stikerwap.appdys.s_mediaplayer_exo r2 = stikerwap.appdys.s_mediaplayer_exo.this     // Catch:{ IOException -> 0x0043, StringIndexOutOfBoundsException -> 0x003c }
                    stikerwap.appdys.IcyStreamMeta r2 = r2.icy     // Catch:{ IOException -> 0x0043, StringIndexOutOfBoundsException -> 0x003c }
                    java.lang.String r2 = r2.getArtist()     // Catch:{ IOException -> 0x0043, StringIndexOutOfBoundsException -> 0x003c }
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this     // Catch:{ IOException -> 0x003a, StringIndexOutOfBoundsException -> 0x0038 }
                    stikerwap.appdys.IcyStreamMeta r3 = r3.icy     // Catch:{ IOException -> 0x003a, StringIndexOutOfBoundsException -> 0x0038 }
                    java.lang.String r3 = r3.getTitle()     // Catch:{ IOException -> 0x003a, StringIndexOutOfBoundsException -> 0x0038 }
                    goto L_0x0049
                L_0x0038:
                    r3 = move-exception
                    goto L_0x003e
                L_0x003a:
                    r3 = move-exception
                    goto L_0x0045
                L_0x003c:
                    r3 = move-exception
                    r2 = r0
                L_0x003e:
                    r3.printStackTrace()     // Catch:{ MalformedURLException -> 0x004c }
                L_0x0041:
                    r3 = r0
                    goto L_0x0049
                L_0x0043:
                    r3 = move-exception
                    r2 = r0
                L_0x0045:
                    r3.printStackTrace()     // Catch:{ MalformedURLException -> 0x004c }
                    goto L_0x0041
                L_0x0049:
                    r4 = r3
                    r3 = 1
                    goto L_0x0055
                L_0x004c:
                    r3 = move-exception
                    goto L_0x0050
                L_0x004e:
                    r3 = move-exception
                    r2 = r0
                L_0x0050:
                    r3.printStackTrace()
                    r3 = 0
                    r4 = r0
                L_0x0055:
                    if (r3 == 0) goto L_0x00eb
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this
                    androidx.media3.exoplayer.ExoPlayer r3 = r3.mp
                    if (r3 == 0) goto L_0x00eb
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this
                    boolean r3 = r3.esta_tocant()
                    if (r3 == 0) goto L_0x00eb
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this
                    android.content.SharedPreferences$Editor r3 = r3.editor_mc
                    java.lang.String r5 = "t_radio_artist"
                    r3.putString(r5, r2)
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this
                    android.content.SharedPreferences$Editor r3 = r3.editor_mc
                    java.lang.String r5 = "t_radio_song"
                    r3.putString(r5, r4)
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this
                    android.content.SharedPreferences$Editor r3 = r3.editor_mc
                    r3.commit()
                    stikerwap.appdys.s_mediaplayer_exo r3 = stikerwap.appdys.s_mediaplayer_exo.this
                    int r3 = r3.radio_mostrar
                    if (r3 != r1) goto L_0x00b1
                    boolean r1 = r2.equals(r0)
                    if (r1 != 0) goto L_0x00a1
                    boolean r1 = r4.equals(r0)
                    if (r1 != 0) goto L_0x00a1
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r2)
                    java.lang.String r2 = " - "
                    r1.append(r2)
                    java.lang.String r2 = r1.toString()
                L_0x00a1:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r2)
                    r1.append(r4)
                    java.lang.String r2 = r1.toString()
                    goto L_0x00c3
                L_0x00b1:
                    stikerwap.appdys.s_mediaplayer_exo r1 = stikerwap.appdys.s_mediaplayer_exo.this
                    int r1 = r1.radio_mostrar
                    r3 = 2
                    if (r1 != r3) goto L_0x00b9
                    goto L_0x00c3
                L_0x00b9:
                    stikerwap.appdys.s_mediaplayer_exo r1 = stikerwap.appdys.s_mediaplayer_exo.this
                    int r1 = r1.radio_mostrar
                    r2 = 3
                    if (r1 != r2) goto L_0x00c2
                    r2 = r4
                    goto L_0x00c3
                L_0x00c2:
                    r2 = r0
                L_0x00c3:
                    java.lang.String r1 = r2.trim()
                    boolean r0 = r1.equals(r0)
                    if (r0 == 0) goto L_0x00d1
                    stikerwap.appdys.s_mediaplayer_exo r0 = stikerwap.appdys.s_mediaplayer_exo.this
                    java.lang.String r1 = r0.secc_tit
                L_0x00d1:
                    stikerwap.appdys.s_mediaplayer_exo r0 = stikerwap.appdys.s_mediaplayer_exo.this
                    java.lang.String r2 = "notification"
                    java.lang.Object r0 = r0.getSystemService(r2)
                    android.app.NotificationManager r0 = (android.app.NotificationManager) r0
                    stikerwap.appdys.s_mediaplayer_exo r2 = stikerwap.appdys.s_mediaplayer_exo.this
                    boolean r2 = r2.foreground
                    if (r2 == 0) goto L_0x00eb
                    stikerwap.appdys.s_mediaplayer_exo r2 = stikerwap.appdys.s_mediaplayer_exo.this
                    android.app.Notification r1 = r2.crearNotif(r1)
                    r2 = 4
                    r0.notify(r2, r1)
                L_0x00eb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_mediaplayer_exo.AnonymousClass4.run():void");
            }
        }, 0, (long) i);
    }

    public void onCreate() {
        this.sh_mp = getSharedPreferences("sh_mp", 0);
        this.sh_mc = getSharedPreferences("sh_mc", 0);
        this.editor_mp = this.sh_mp.edit();
        this.editor_mc = this.sh_mc.edit();
        this.mAudioManager = (AudioManager) getSystemService("audio");
        WifiManager.WifiLock createWifiLock = ((WifiManager) getApplicationContext().getSystemService("wifi")).createWifiLock(3, "acwifilock");
        this.wifiLock = createWifiLock;
        createWifiLock.setReferenceCounted(false);
        TIME_THREAD.postDelayed(this.updateTimeRunnable, 200);
        getMeta();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf();
        } else {
            String stringExtra = intent.getStringExtra("accion");
            String stringExtra2 = intent.getStringExtra("url");
            String stringExtra3 = intent.getStringExtra("ua");
            this.idsecc = intent.getIntExtra("idsecc", 0);
            this.radio_mostrar = intent.getIntExtra("radio_mostrar", 0);
            this.secc_tit = intent.getStringExtra("secc_tit");
            this.esStream = intent.getBooleanExtra("esStream", true);
            if (stringExtra.equals("iniciar")) {
                crear_mp(stringExtra2, stringExtra3);
            } else if (stringExtra.equals("play")) {
                if (!intent.hasExtra("desde_notif")) {
                    ExoPlayer exoPlayer = this.mp;
                    if (exoPlayer == null) {
                        crear_mp(stringExtra2, stringExtra3);
                    } else {
                        try {
                            exoPlayer.setPlayWhenReady(true);
                            foreground_on();
                        } catch (Exception unused) {
                        }
                        TIME_THREAD_MC.postDelayed(this.mcRunnable, 200);
                    }
                } else {
                    ExoPlayer exoPlayer2 = this.mp;
                    if (exoPlayer2 != null) {
                        try {
                            exoPlayer2.setPlayWhenReady(true);
                        } catch (Exception unused2) {
                        }
                        TIME_THREAD_MC.postDelayed(this.mcRunnable, 200);
                        TIME_THREAD_BTNS.postDelayed(this.mcRunnableBtns, 200);
                    }
                }
            } else if (stringExtra.equals(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
                try {
                    this.mp.setPlayWhenReady(false);
                } catch (Exception unused3) {
                }
                if (!intent.hasExtra("desde_notif")) {
                    if (this.esStream) {
                        TIME_THREAD_MC_RELEASE.postDelayed(this.mcRunnableRelease, 200);
                    } else {
                        TIME_THREAD_MC.postDelayed(this.mcRunnable, 200);
                    }
                    foreground_off();
                } else {
                    TIME_THREAD_BTNS.postDelayed(this.mcRunnableBtns, 200);
                    TIME_THREAD_MC.postDelayed(this.mcRunnable, 200);
                }
            } else if (stringExtra.equals("stop")) {
                try {
                    this.mp.stop();
                } catch (Exception unused4) {
                }
                if (this.esStream) {
                    TIME_THREAD_MC_RELEASE.postDelayed(this.mcRunnableRelease, 200);
                } else {
                    TIME_THREAD_MC.postDelayed(this.mcRunnable, 200);
                }
                foreground_off();
            } else if (stringExtra.equals("seekto")) {
                try {
                    this.mp.seekTo((long) intent.getIntExtra("valor", 0));
                } catch (Exception unused5) {
                }
                TIME_THREAD_MC.postDelayed(this.mcRunnable, 200);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* access modifiers changed from: private */
    public boolean esta_tocant() {
        return this.isPlaying_glob;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(1:7)|8|9) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void crear_mp(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            androidx.media3.exoplayer.ExoPlayer r5 = r3.mp
            if (r5 == 0) goto L_0x0018
            java.lang.String r5 = r3.url_act     // Catch:{ Exception -> 0x0013 }
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0013 }
            if (r5 == 0) goto L_0x0013
            boolean r5 = r3.esta_tocant()     // Catch:{ Exception -> 0x0013 }
            if (r5 == 0) goto L_0x0013
            return
        L_0x0013:
            androidx.media3.exoplayer.ExoPlayer r5 = r3.mp     // Catch:{ Exception -> 0x0018 }
            r5.release()     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            r3.url_act = r4
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector r5 = new androidx.media3.exoplayer.trackselection.DefaultTrackSelector
            r5.<init>(r3)
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters$Builder r0 = r5.buildUponParameters()
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters$Builder r0 = r0.setMaxVideoSizeSd()
            r5.setParameters((androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters.Builder) r0)
            androidx.media3.exoplayer.ExoPlayer$Builder r0 = new androidx.media3.exoplayer.ExoPlayer$Builder
            r0.<init>(r3)
            androidx.media3.exoplayer.ExoPlayer$Builder r5 = r0.setTrackSelector(r5)
            androidx.media3.exoplayer.ExoPlayer r5 = r5.build()
            r3.mp = r5
            android.os.Handler r5 = TIME_THREAD_MC     // Catch:{ Exception -> 0x0043 }
            java.lang.Runnable r0 = r3.mcRunnable     // Catch:{ Exception -> 0x0043 }
            r1 = 200(0xc8, double:9.9E-322)
            r5.postDelayed(r0, r1)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0044
        L_0x0043:
        L_0x0044:
            androidx.media3.exoplayer.ExoPlayer r5 = r3.mp
            stikerwap.appdys.s_mediaplayer_exo$6 r0 = new stikerwap.appdys.s_mediaplayer_exo$6
            r0.<init>()
            r5.addListener(r0)
            android.net.Uri r4 = android.net.Uri.parse(r4)
            androidx.media3.common.MediaItem r4 = androidx.media3.common.MediaItem.fromUri((android.net.Uri) r4)
            if (r4 == 0) goto L_0x0068
            androidx.media3.exoplayer.ExoPlayer r5 = r3.mp
            r0 = 1
            r5.setPlayWhenReady(r0)
            androidx.media3.exoplayer.ExoPlayer r5 = r3.mp
            r5.setMediaItem(r4)
            androidx.media3.exoplayer.ExoPlayer r4 = r3.mp
            r4.prepare()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_mediaplayer_exo.crear_mp(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public Notification crearNotif(String str) {
        String str2;
        NotificationCompat.Builder builder;
        String str3 = str;
        Intent intent = new Intent(getApplicationContext(), preinicio.class);
        intent.setFlags(268468224);
        if (this.idsecc != 0) {
            intent.putExtra("notif_id", "0");
            intent.putExtra("notif_tipo", "1");
            intent.putExtra("notif_idelem", this.idsecc + "");
        }
        try {
            str2 = getAppLabel(this);
        } catch (Exception unused) {
            str2 = "";
        }
        if (str2.equals("")) {
            str2 = "Playing";
        }
        int i = Build.VERSION.SDK_INT >= 23 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE;
        PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), 0, intent, i);
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new NotificationCompat.Builder((Context) this, config.crear_channel(this, 0).getId());
        } else {
            builder = new NotificationCompat.Builder(this);
        }
        Class<s_mediaplayer_exo> cls = s_mediaplayer_exo.class;
        Intent intent2 = new Intent(this, cls);
        intent2.putExtra("accion", CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        intent2.putExtra("desde_notif", "1");
        intent2.putExtra("idsecc", this.idsecc);
        NotificationCompat.Action build = new NotificationCompat.Action.Builder((int) R.drawable.pause, (CharSequence) "Pause", PendingIntent.getService(this, 999995, intent2, i)).build();
        Intent intent3 = new Intent(this, cls);
        intent3.putExtra("accion", "play");
        intent3.putExtra("desde_notif", "1");
        intent3.putExtra("idsecc", this.idsecc);
        NotificationCompat.Action action = build;
        NotificationCompat.Action build2 = new NotificationCompat.Action.Builder((int) R.drawable.play_audio, (CharSequence) "Play", PendingIntent.getService(this, 999996, intent3, i)).build();
        Intent intent4 = new Intent(this, cls);
        intent4.putExtra("accion", "stop");
        intent4.putExtra("desde_notif", "1");
        intent4.putExtra("idsecc", this.idsecc);
        NotificationCompat.Action build3 = new NotificationCompat.Action.Builder((int) R.drawable.cerrar_cruz, (CharSequence) "Stop", PendingIntent.getService(this, 999997, intent4, i)).build();
        builder.setTicker(str2).setContentTitle(str2).setContentText(str3).setSmallIcon((int) R.drawable.play).setContentIntent(activity).setOngoing(true);
        Bitmap ico_en_notif = config.ico_en_notif(this);
        if (ico_en_notif != null) {
            builder.setLargeIcon(ico_en_notif);
        }
        config config = (config) getApplicationContext();
        if (this.idsecc > 0 && config != null) {
            Seccion seccion = config.secciones_a[config.secciones_alist.indexOf(Integer.valueOf(this.idsecc))];
            if (seccion.v_img_notif > 0) {
                SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
                int i2 = seccion.v_img_notif;
                if (i2 != sharedPreferences.getInt("v_img_notif_act_" + this.idsecc, 0)) {
                    f_img_notif_run(seccion);
                } else {
                    try {
                        FileInputStream openFileInput = openFileInput("img_notif_" + this.idsecc);
                        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileInput.getFD());
                        openFileInput.close();
                        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(decodeFileDescriptor).bigLargeIcon((Bitmap) null));
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (this.mp == null || !esta_tocant()) {
            builder.addAction(build2);
        } else {
            builder.addAction(action);
        }
        builder.addAction(build3);
        Notification build4 = builder.build();
        this.txt_act = str3;
        return build4;
    }

    /* access modifiers changed from: private */
    public void foreground_on() {
        this.mAudioManager.requestAudioFocus(this, 3, 1);
        startForeground(4, crearNotif(this.secc_tit));
        this.foreground = true;
        try {
            this.wifiLock.acquire();
        } catch (Exception unused) {
        }
    }

    private void foreground_off() {
        try {
            this.wifiLock.release();
        } catch (Exception unused) {
        }
        stopForeground(true);
        this.foreground = false;
        this.mAudioManager.abandonAudioFocus(this);
    }

    public String getAppLabel(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|7|8|9|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateState() {
        /*
            r5 = this;
            android.content.SharedPreferences$Editor r0 = r5.editor_mp
            if (r0 == 0) goto L_0x0034
            androidx.media3.exoplayer.ExoPlayer r1 = r5.mp
            if (r1 == 0) goto L_0x002c
            java.lang.String r2 = "position"
            long r3 = r1.getCurrentPosition()     // Catch:{ Exception -> 0x0012 }
            int r1 = (int) r3     // Catch:{ Exception -> 0x0012 }
            r0.putInt(r2, r1)     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            android.content.SharedPreferences$Editor r0 = r5.editor_mp     // Catch:{ Exception -> 0x0020 }
            java.lang.String r1 = "duration"
            androidx.media3.exoplayer.ExoPlayer r2 = r5.mp     // Catch:{ Exception -> 0x0020 }
            long r2 = r2.getDuration()     // Catch:{ Exception -> 0x0020 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0020 }
            r0.putInt(r1, r3)     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            android.content.SharedPreferences$Editor r0 = r5.editor_mp     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "isPlaying"
            boolean r2 = r5.esta_tocant()     // Catch:{ Exception -> 0x002f }
            r0.putBoolean(r1, r2)     // Catch:{ Exception -> 0x002f }
            goto L_0x002f
        L_0x002c:
            r0.clear()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            android.content.SharedPreferences$Editor r0 = r5.editor_mp     // Catch:{ Exception -> 0x0034 }
            r0.commit()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_mediaplayer_exo.updateState():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:19|20|21|22|23|24|25|26|27|29|(1:31)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0047 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update_mc() {
        /*
            r6 = this;
            android.content.SharedPreferences$Editor r0 = r6.editor_mc
            r1 = 1
            java.lang.String r2 = "act_mc"
            if (r0 == 0) goto L_0x0014
            r0.clear()
            android.content.SharedPreferences$Editor r0 = r6.editor_mc
            r0.putBoolean(r2, r1)
            android.content.SharedPreferences$Editor r0 = r6.editor_mc
            r0.commit()
        L_0x0014:
            androidx.media3.exoplayer.ExoPlayer r0 = r6.mp
            r3 = 0
            if (r0 == 0) goto L_0x001f
            boolean r0 = r6.esta_tocant()     // Catch:{ Exception -> 0x001e }
            goto L_0x0020
        L_0x001e:
        L_0x001f:
            r0 = 0
        L_0x0020:
            androidx.media3.exoplayer.ExoPlayer r4 = r6.mp
            if (r4 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x0062
            boolean r0 = r6.foreground
            if (r0 != 0) goto L_0x0062
            r4.stop()     // Catch:{ Exception -> 0x002e }
            goto L_0x002f
        L_0x002e:
        L_0x002f:
            android.content.SharedPreferences$Editor r0 = r6.editor_mp
            if (r0 == 0) goto L_0x005f
            java.lang.String r4 = "position"
            r0.putInt(r4, r3)     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            android.content.SharedPreferences$Editor r0 = r6.editor_mp     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = "duration"
            r5 = -1
            r0.putInt(r4, r5)     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            android.content.SharedPreferences$Editor r0 = r6.editor_mp     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "isPlaying"
            r0.putBoolean(r4, r3)     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            android.content.SharedPreferences$Editor r0 = r6.editor_mp     // Catch:{ Exception -> 0x004d }
            r0.commit()     // Catch:{ Exception -> 0x004d }
            goto L_0x004e
        L_0x004d:
        L_0x004e:
            android.content.SharedPreferences$Editor r0 = r6.editor_mc
            if (r0 == 0) goto L_0x005f
            r0.clear()
            android.content.SharedPreferences$Editor r0 = r6.editor_mc
            r0.putBoolean(r2, r1)
            android.content.SharedPreferences$Editor r0 = r6.editor_mc
            r0.commit()
        L_0x005f:
            r6.stopSelf()
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_mediaplayer_exo.update_mc():void");
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        foreground_off();
        return true;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        foreground_off();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r2 = this;
            android.os.Handler r0 = TIME_THREAD     // Catch:{ Exception -> 0x0007 }
            java.lang.Runnable r1 = r2.updateTimeRunnable     // Catch:{ Exception -> 0x0007 }
            r0.removeCallbacks(r1)     // Catch:{ Exception -> 0x0007 }
        L_0x0007:
            android.net.wifi.WifiManager$WifiLock r0 = r2.wifiLock     // Catch:{ Exception -> 0x000c }
            r0.release()     // Catch:{ Exception -> 0x000c }
        L_0x000c:
            androidx.media3.exoplayer.ExoPlayer r0 = r2.mp     // Catch:{ Exception -> 0x0011 }
            r0.release()     // Catch:{ Exception -> 0x0011 }
        L_0x0011:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_mediaplayer_exo.onDestroy():void");
    }

    public void onAudioFocusChange(int i) {
        if (i <= 0) {
            ExoPlayer exoPlayer = this.mp;
            if (exoPlayer != null) {
                try {
                    exoPlayer.setVolume(0.0f);
                } catch (Exception unused) {
                }
            }
        } else {
            ExoPlayer exoPlayer2 = this.mp;
            if (exoPlayer2 != null) {
                exoPlayer2.setVolume(1.0f);
            }
        }
    }
}
