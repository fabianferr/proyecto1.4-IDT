package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.iab.omid.library.mmadbridge.adsession.media.VastProperties;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.video.bt.a.c;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBridgeBTVideoView extends BTBaseView {
    /* access modifiers changed from: private */
    public static boolean K = false;
    private AdSession A;
    /* access modifiers changed from: private */
    public MediaEvents B;
    private AdEvents C;
    private a D;
    /* access modifiers changed from: private */
    public int E = 2;
    private int F;
    private boolean G = false;
    private int H = 2;
    private int I = 1;
    private String J;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private RelativeLayout O;
    /* access modifiers changed from: private */
    public ProgressBar P;
    /* access modifiers changed from: private */
    public PlayerView p;
    private SoundImageView q;
    /* access modifiers changed from: private */
    public TextView r;
    private View s;
    private FeedBackButton t;
    private ImageView u;
    /* access modifiers changed from: private */
    public WebView v;
    private com.mbridge.msdk.videocommon.download.a w;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    public void setCreateWebView(WebView webView) {
        this.v = webView;
    }

    public void setOrientation(int i) {
        this.I = i;
    }

    public MBridgeBTVideoView(Context context) {
        super(context);
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.r.setBackgroundResource(t.a(b.d().g(), "mbridge_reward_shape_progress", "drawable"));
            this.r.setWidth(af.b(b.d().g(), 30.0f));
            return;
        }
        this.r.setBackgroundResource(t.a(b.d().g(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, af.b(b.d().g(), 30.0f));
        int b = af.b(b.d().g(), 5.0f);
        layoutParams.setMargins(b, 0, 0, 0);
        this.r.setPadding(b, 0, b, 0);
        this.r.setLayoutParams(layoutParams);
    }

    public void soundOperate(int i, int i2, String str) {
        if (this.h) {
            this.E = i;
            if (i == 1) {
                this.q.setSoundStatus(false);
                this.p.closeSound();
            } else if (i == 2) {
                this.q.setSoundStatus(true);
                this.p.openSound();
            }
            if (i2 == 1) {
                this.q.setVisibility(8);
            } else if (i2 == 2) {
                this.q.setVisibility(0);
            }
        }
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.f.inflate(findLayout, this);
            this.h = b();
            if (!this.h) {
                aa.d(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            a();
        }
        K = false;
    }

    public void onResume() {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setIsCovered(false);
            this.p.setDesk(true);
            if (this.M) {
                this.p.start(true);
            }
        }
    }

    public void onPause() {
        PlayerView playerView = this.p;
        if (playerView != null) {
            boolean isPlayIng = playerView.isPlayIng();
            this.M = isPlayIng;
            this.p.setIsBTVideoPlaying(isPlayIng);
            this.p.onPause();
        }
    }

    public void onStop() {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        View rootView;
        super.onAttachedToWindow();
        if (!this.N) {
            this.H = c.a().e(this.c);
        }
        View view = this.s;
        int i = 8;
        if (view != null) {
            view.setVisibility(this.y == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.q;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.z == 0 ? 8 : 0);
        }
        if (this.b != null) {
            this.b.setCampaignUnitId(this.c);
            com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
            a2.a(this.c + "_1", this.b);
        }
        TextView textView = this.r;
        if (textView != null) {
            if (this.x != 0) {
                i = 0;
            }
            textView.setVisibility(i);
            if (this.r.getVisibility() == 0 && com.mbridge.msdk.foundation.c.b.a().b()) {
                com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
                a3.a(this.c + "_1", this.t);
            }
        }
        if (this.A != null && (rootView = getRootView()) != null) {
            this.A.removeFriendlyObstruction(rootView);
        }
    }

    public boolean playMute() {
        try {
            PlayerView playerView = this.p;
            if (!(playerView == null || this.v == null)) {
                playerView.closeSound();
                this.q.setSoundStatus(false);
                this.E = 1;
                try {
                    MediaEvents mediaEvents = this.B;
                    if (mediaEvents != null) {
                        mediaEvents.volumeChange(0.0f);
                    }
                } catch (IllegalArgumentException e) {
                    aa.a("OMSDK", e.getMessage());
                }
                a(this.v, "onPlayerMute", this.d);
                return true;
            }
        } catch (Exception e2) {
            aa.d(BTBaseView.TAG, e2.getMessage());
        }
        return false;
    }

    public int getMute() {
        return this.E;
    }

    public boolean playUnMute() {
        try {
            PlayerView playerView = this.p;
            if (playerView == null || this.v == null) {
                return false;
            }
            playerView.openSound();
            this.q.setSoundStatus(true);
            this.E = 2;
            try {
                MediaEvents mediaEvents = this.B;
                if (mediaEvents != null) {
                    mediaEvents.volumeChange(1.0f);
                }
            } catch (IllegalArgumentException e) {
                aa.a("OMSDK", e.getMessage());
            }
            a(this.v, "onUnmute", this.d);
            return true;
        } catch (Exception e2) {
            aa.d(BTBaseView.TAG, e2.getMessage());
            return false;
        }
    }

    public void play() {
        a aVar;
        try {
            if (!this.N) {
                String c = c();
                this.J = c;
                this.p.initVFPData(c, this.b.getVideoUrlEncode(), this.D);
                if (this.H == 1) {
                    playMute();
                } else {
                    playUnMute();
                }
                try {
                    AdEvents adEvents = this.C;
                    if (adEvents != null) {
                        adEvents.impressionOccurred();
                    }
                    if (this.B != null) {
                        float duration = (float) this.p.getDuration();
                        float f = 0.0f;
                        if (duration == 0.0f && this.b != null) {
                            duration = (float) this.b.getVideoLength();
                        }
                        MediaEvents mediaEvents = this.B;
                        if (getMute() == 2) {
                            f = 1.0f;
                        }
                        mediaEvents.start(duration, f);
                        aa.a("omsdk", "play: videoEvents.start()");
                    }
                } catch (IllegalArgumentException e) {
                    aa.a(BTBaseView.TAG, e.getMessage());
                }
                if (!this.p.playVideo() && (aVar = this.D) != null) {
                    aVar.onPlayError("play video failed");
                }
                this.N = true;
                return;
            }
            if (this.G) {
                this.p.playVideo(0);
                this.G = false;
            } else {
                this.p.start(false);
            }
            try {
                MediaEvents mediaEvents2 = this.B;
                if (mediaEvents2 != null) {
                    mediaEvents2.resume();
                    aa.a("omsdk", "play:  videoEvents.resume()");
                }
            } catch (IllegalArgumentException e2) {
                aa.a(BTBaseView.TAG, e2.getMessage());
            }
            WebView webView = this.v;
            if (webView != null) {
                a(webView, "onPlayerPlay", this.d);
            }
        } catch (Exception e3) {
            aa.b(BTBaseView.TAG, e3.getMessage(), e3);
        }
    }

    public void resume() {
        try {
            PlayerView playerView = this.p;
            if (playerView != null) {
                if (this.G) {
                    playerView.playVideo(0);
                    this.G = false;
                } else {
                    playerView.onResume();
                }
                try {
                    MediaEvents mediaEvents = this.B;
                    if (mediaEvents != null) {
                        mediaEvents.resume();
                        aa.a("omsdk", "play:  videoEvents.resume()");
                    }
                } catch (IllegalArgumentException e) {
                    aa.a(BTBaseView.TAG, e.getMessage());
                }
                WebView webView = this.v;
                if (webView != null) {
                    a(webView, "onPlayerResume", this.d);
                }
            }
        } catch (Exception e2) {
            aa.d(BTBaseView.TAG, e2.getMessage());
        }
    }

    public void pause() {
        try {
            PlayerView playerView = this.p;
            if (playerView != null) {
                playerView.pause();
                MediaEvents mediaEvents = this.B;
                if (mediaEvents != null) {
                    mediaEvents.pause();
                    aa.a("omsdk", "play:  videoEvents.pause()");
                }
                WebView webView = this.v;
                if (webView != null) {
                    a(webView, "onPlayerPause", this.d);
                }
            }
        } catch (Exception e) {
            aa.b(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void stop() {
        try {
            PlayerView playerView = this.p;
            if (playerView != null) {
                playerView.pause();
                this.p.stop();
                this.G = true;
                WebView webView = this.v;
                if (webView != null) {
                    a(webView, "onPlayerStop", this.d);
                }
            }
        } catch (Exception e) {
            aa.b(BTBaseView.TAG, e.getMessage(), e);
        }
    }

    public void onDestory() {
        try {
            PlayerView playerView = this.p;
            if (playerView != null) {
                playerView.setOnClickListener((View.OnClickListener) null);
                this.p.release();
                this.p = null;
                m.a().a("2000146", this.b, (Map<String, String>) new HashMap());
            }
            SoundImageView soundImageView = this.q;
            if (soundImageView != null) {
                soundImageView.setOnClickListener((View.OnClickListener) null);
            }
            View view = this.s;
            if (view != null) {
                view.setOnClickListener((View.OnClickListener) null);
            }
            if (this.v != null) {
                this.v = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.B != null) {
                this.B = null;
            }
            setOnClickListener((View.OnClickListener) null);
        } catch (Throwable th) {
            aa.a(BTBaseView.TAG, th.getMessage());
        }
    }

    private boolean b() {
        try {
            this.p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.s = findViewById(findID("mbridge_rl_playing_close"));
            this.O = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.P = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.u = (ImageView) findViewById(findID("mbridge_iv_link"));
            this.p.setIsBTVideo(true);
            return isNotNULL(this.p, this.q, this.r, this.s);
        } catch (Throwable th) {
            aa.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private String c() {
        try {
            String videoUrlEncode = this.b.getVideoUrlEncode();
            com.mbridge.msdk.videocommon.download.a aVar = this.w;
            if (aVar == null) {
                return videoUrlEncode;
            }
            String h = aVar.h();
            if (ak.a(h) || !new File(h).exists()) {
                return videoUrlEncode;
            }
            return h;
        } catch (Throwable th) {
            aa.b(BTBaseView.TAG, th.getMessage(), th);
            return "";
        }
    }

    private int d() {
        int i = 5;
        try {
            com.mbridge.msdk.videocommon.d.a b = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b != null) {
                i = (int) b.h();
            }
            aa.b(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        if (this.h) {
            this.q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean isSilent = MBridgeBTVideoView.this.p.isSilent();
                    if (MBridgeBTVideoView.this.v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.n);
                            jSONObject.put("id", MBridgeBTVideoView.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, MBridgeBTVideoView.this.E);
                            jSONObject.put("data", jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            aa.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + isSilent + " mute = " + MBridgeBTVideoView.this.E);
                        } catch (Exception e) {
                            c.a().a(MBridgeBTVideoView.this.v, e.getMessage());
                        }
                    }
                }
            });
            this.s.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.v != null) {
                        BTBaseView.a(MBridgeBTVideoView.this.v, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.B != null) {
                        MBridgeBTVideoView.this.B.adUserInteraction(InteractionType.CLICK);
                    }
                    if (MBridgeBTVideoView.this.v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.n);
                            jSONObject.put("id", MBridgeBTVideoView.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put("data", jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            c.a().a(MBridgeBTVideoView.this.v, "onClicked", MBridgeBTVideoView.this.d);
                        }
                    }
                }
            });
        }
    }

    private static final class a extends DefaultVideoPlayerStatusListener {
        private MBridgeBTVideoView a;
        private WebView b;
        private MediaEvents c;
        private String d;
        private String e;
        private int f;
        private int g;
        private boolean h;
        private boolean i = false;
        private boolean j = false;
        private boolean k = false;
        private int l;
        private int m;
        private boolean n = false;

        public a(MBridgeBTVideoView mBridgeBTVideoView, WebView webView, MediaEvents mediaEvents) {
            this.a = mBridgeBTVideoView;
            this.b = webView;
            this.c = mediaEvents;
            if (mBridgeBTVideoView != null) {
                this.d = mBridgeBTVideoView.d;
                this.e = mBridgeBTVideoView.c;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9 A[Catch:{ Exception -> 0x00b9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                r2.l = r3
                r2.m = r4
                com.mbridge.msdk.foundation.tools.ac r3 = com.mbridge.msdk.foundation.tools.ac.a()
                java.lang.String r4 = "h_c_r_w_p_c"
                r1 = 0
                boolean r3 = r3.a((java.lang.String) r4, (boolean) r1)
                if (r3 != 0) goto L_0x0015
                goto L_0x00c5
            L_0x0015:
                int r3 = r2.l
                r4 = 100
                if (r3 == r4) goto L_0x00c5
                int r4 = r2.m
                if (r4 != 0) goto L_0x00c5
                boolean r4 = r2.n
                if (r4 != 0) goto L_0x00c5
                if (r3 == 0) goto L_0x00c5
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.a
                if (r3 == 0) goto L_0x00c5
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.b
                if (r3 != 0) goto L_0x002f
                goto L_0x00c5
            L_0x002f:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.b     // Catch:{ Exception -> 0x00b9 }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x00b9 }
                r4 = 94
                if (r3 == r4) goto L_0x0073
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.b     // Catch:{ Exception -> 0x00b9 }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x00b9 }
                r4 = 287(0x11f, float:4.02E-43)
                if (r3 != r4) goto L_0x0048
                goto L_0x0073
            L_0x0048:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b9 }
                r3.<init>()     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x00b9 }
                r3.append(r4)     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x00b9 }
                r3.append(r4)     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r4 = r4.getBidToken()     // Catch:{ Exception -> 0x00b9 }
                r3.append(r4)     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b9 }
                goto L_0x009d
            L_0x0073:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b9 }
                r3.<init>()     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r4 = r4.getRequestId()     // Catch:{ Exception -> 0x00b9 }
                r3.append(r4)     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x00b9 }
                r3.append(r4)     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.a     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x00b9 }
                r3.append(r4)     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b9 }
            L_0x009d:
                com.mbridge.msdk.videocommon.download.c r4 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r1 = r2.e     // Catch:{ Exception -> 0x00b9 }
                com.mbridge.msdk.videocommon.download.a r3 = r4.a(r1, r3)     // Catch:{ Exception -> 0x00b9 }
                if (r3 == 0) goto L_0x00c5
                r3.o()     // Catch:{ Exception -> 0x00b9 }
                r3 = 1
                r2.n = r3     // Catch:{ Exception -> 0x00b9 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x00b9 }
                if (r3 == 0) goto L_0x00c5
                java.lang.String r3 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.aa.d(r0, r3)     // Catch:{ Exception -> 0x00b9 }
                goto L_0x00c5
            L_0x00b9:
                r3 = move-exception
                boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r4 == 0) goto L_0x00c5
                java.lang.String r3 = r3.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r0, r3)
            L_0x00c5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.a(int, int):void");
        }

        public final void onPlayStarted(int i2) {
            super.onPlayStarted(i2);
            if (!this.h) {
                this.a.P.setMax(i2);
                WebView webView = this.b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.d);
                }
                this.h = true;
            }
            boolean unused = MBridgeBTVideoView.K = false;
        }

        public final void onPlayCompleted() {
            super.onPlayCompleted();
            if (this.a.b == null) {
                this.a.r.setText("0");
            } else if (this.a.b.getVideoCompleteTime() > 0) {
                this.a.r.setText(t.a(b.d().g(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
            } else {
                this.a.r.setText("0");
            }
            this.a.p.setClickable(false);
            WebView webView = this.b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.d);
            }
            MediaEvents mediaEvents = this.c;
            if (mediaEvents != null) {
                mediaEvents.complete();
                aa.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f = this.g;
            boolean unused = MBridgeBTVideoView.K = true;
            this.a.stop();
        }

        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.o);
                    jSONObject.put("id", this.d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", str);
                    jSONObject2.put("id", this.d);
                    jSONObject.put("data", jSONObject2);
                    g.a().a(this.b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    c.a().a(this.b, e2.getMessage());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:67:0x0214 A[Catch:{ Exception -> 0x022e }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r10, int r11) {
            /*
                r9 = this;
                java.lang.String r0 = "id"
                java.lang.String r1 = "DefaultVideoPlayerStatusListener"
                java.lang.String r2 = "CDRate is : "
                super.onPlayProgress(r10, r11)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r9.a
                boolean r3 = r3.h
                if (r3 == 0) goto L_0x00b5
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r9.a
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.b
                if (r3 == 0) goto L_0x003e
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r9.a
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.b
                int r3 = r3.getVideoCompleteTime()
                com.mbridge.msdk.foundation.c.b r4 = com.mbridge.msdk.foundation.c.b.a()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r6 = r9.a
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r6.b
                java.lang.String r6 = r6.getCampaignUnitId()
                r5.append(r6)
                java.lang.String r6 = "_1"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                r4.a((java.lang.String) r5, (int) r10)
                goto L_0x003f
            L_0x003e:
                r3 = 0
            L_0x003f:
                if (r3 <= r11) goto L_0x0042
                r3 = r11
            L_0x0042:
                if (r3 > 0) goto L_0x0047
                int r4 = r11 - r10
                goto L_0x0049
            L_0x0047:
                int r4 = r3 - r10
            L_0x0049:
                java.lang.String r5 = "string"
                if (r4 > 0) goto L_0x0072
                if (r3 > 0) goto L_0x0053
                java.lang.String r3 = "0"
                goto L_0x00ac
            L_0x0053:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r9.a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()
                android.content.Context r4 = r4.g()
                java.lang.String r6 = "mbridge_reward_video_view_reward_time_complete"
                int r4 = com.mbridge.msdk.foundation.tools.t.a(r4, r6, r5)
                java.lang.CharSequence r3 = r3.getText(r4)
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x00ac
            L_0x0072:
                if (r3 > 0) goto L_0x007f
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r4)
                java.lang.String r4 = ""
                goto L_0x00a5
            L_0x007f:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r4)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r9.a
                android.content.Context r4 = r4.getContext()
                android.content.res.Resources r4 = r4.getResources()
                com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()
                android.content.Context r6 = r6.g()
                java.lang.String r7 = "mbridge_reward_video_view_reward_time_left"
                int r5 = com.mbridge.msdk.foundation.tools.t.a(r6, r7, r5)
                java.lang.CharSequence r4 = r4.getText(r5)
                java.lang.String r4 = (java.lang.String) r4
            L_0x00a5:
                r3.append(r4)
                java.lang.String r3 = r3.toString()
            L_0x00ac:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r9.a
                android.widget.TextView r4 = r4.r
                r4.setText(r3)
            L_0x00b5:
                r9.g = r11
                r9.f = r10
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r9.a
                android.widget.ProgressBar r3 = r3.P
                int r4 = r9.g
                r3.setMax(r4)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r9.a
                android.widget.ProgressBar r3 = r3.P
                int r4 = r9.f
                r3.setProgress(r4)
                android.webkit.WebView r3 = r9.b
                if (r3 == 0) goto L_0x0136
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0128 }
                r3.<init>()     // Catch:{ Exception -> 0x0128 }
                java.lang.String r4 = "code"
                int r5 = com.mbridge.msdk.video.bt.module.BTBaseView.n     // Catch:{ Exception -> 0x0128 }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r4 = r9.d     // Catch:{ Exception -> 0x0128 }
                r3.put(r0, r4)     // Catch:{ Exception -> 0x0128 }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0128 }
                r4.<init>()     // Catch:{ Exception -> 0x0128 }
                java.lang.String r5 = r9.d     // Catch:{ Exception -> 0x0128 }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r0 = "progress"
                java.lang.String r5 = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.b(r10, r11)     // Catch:{ Exception -> 0x0128 }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r0 = "time"
                java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0128 }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r0 = "duration"
                java.lang.String r5 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0128 }
                r4.put(r0, r5)     // Catch:{ Exception -> 0x0128 }
                java.lang.String r0 = "data"
                r3.put(r0, r4)     // Catch:{ Exception -> 0x0128 }
                com.mbridge.msdk.mbsignalcommon.windvane.g r0 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x0128 }
                android.webkit.WebView r4 = r9.b     // Catch:{ Exception -> 0x0128 }
                java.lang.String r5 = "onPlayerProgressChanged"
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0128 }
                byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x0128 }
                r6 = 2
                java.lang.String r3 = android.util.Base64.encodeToString(r3, r6)     // Catch:{ Exception -> 0x0128 }
                r0.a((android.webkit.WebView) r4, (java.lang.String) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0128 }
                goto L_0x0136
            L_0x0128:
                r0 = move-exception
                com.mbridge.msdk.video.bt.a.c r3 = com.mbridge.msdk.video.bt.a.c.a()
                android.webkit.WebView r4 = r9.b
                java.lang.String r0 = r0.getMessage()
                r3.a((android.webkit.WebView) r4, (java.lang.String) r0)
            L_0x0136:
                com.iab.omid.library.mmadbridge.adsession.media.MediaEvents r0 = r9.c
                r3 = 100
                r4 = 1
                if (r0 == 0) goto L_0x0185
                int r5 = r10 * 100
                int r5 = r5 / r11
                int r6 = r10 + 1
                int r6 = r6 * 100
                int r6 = r6 / r11
                r7 = 25
                java.lang.String r8 = "omsdk"
                if (r5 > r7) goto L_0x015c
                if (r7 >= r6) goto L_0x015c
                boolean r7 = r9.i
                if (r7 != 0) goto L_0x015c
                r9.i = r4
                r0.firstQuartile()
                java.lang.String r0 = "play:  videoEvents.firstQuartile()"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r8, (java.lang.String) r0)
                goto L_0x0185
            L_0x015c:
                r7 = 50
                if (r5 > r7) goto L_0x0171
                if (r7 >= r6) goto L_0x0171
                boolean r7 = r9.j
                if (r7 != 0) goto L_0x0171
                r9.j = r4
                r0.midpoint()
                java.lang.String r0 = "play:  videoEvents.midpoint()"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r8, (java.lang.String) r0)
                goto L_0x0185
            L_0x0171:
                r7 = 75
                if (r5 > r7) goto L_0x0185
                if (r7 >= r6) goto L_0x0185
                boolean r5 = r9.k
                if (r5 != 0) goto L_0x0185
                r9.k = r4
                r0.thirdQuartile()
                java.lang.String r0 = "play:  videoEvents.thirdQuartile()"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r8, (java.lang.String) r0)
            L_0x0185:
                int r0 = r9.l     // Catch:{ Exception -> 0x022e }
                if (r0 == r3) goto L_0x0236
                boolean r5 = r9.n     // Catch:{ Exception -> 0x022e }
                if (r5 != 0) goto L_0x0236
                if (r0 != 0) goto L_0x0191
                goto L_0x0236
            L_0x0191:
                int r0 = r9.m     // Catch:{ Exception -> 0x022e }
                if (r0 < 0) goto L_0x0236
                int r11 = r11 * r0
                int r11 = r11 / r3
                if (r10 < r11) goto L_0x0236
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r10 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = r10.b     // Catch:{ Exception -> 0x022e }
                int r10 = r10.getAdType()     // Catch:{ Exception -> 0x022e }
                r0 = 94
                if (r10 == r0) goto L_0x01de
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r10 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = r10.b     // Catch:{ Exception -> 0x022e }
                int r10 = r10.getAdType()     // Catch:{ Exception -> 0x022e }
                r0 = 287(0x11f, float:4.02E-43)
                if (r10 != r0) goto L_0x01b3
                goto L_0x01de
            L_0x01b3:
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022e }
                r10.<init>()     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x022e }
                java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x022e }
                r10.append(r0)     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x022e }
                java.lang.String r0 = r0.getVideoUrlEncode()     // Catch:{ Exception -> 0x022e }
                r10.append(r0)     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x022e }
                java.lang.String r0 = r0.getBidToken()     // Catch:{ Exception -> 0x022e }
                r10.append(r0)     // Catch:{ Exception -> 0x022e }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x022e }
                goto L_0x0208
            L_0x01de:
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022e }
                r10.<init>()     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x022e }
                java.lang.String r0 = r0.getRequestId()     // Catch:{ Exception -> 0x022e }
                r10.append(r0)     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x022e }
                java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x022e }
                r10.append(r0)     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r0 = r9.a     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.b     // Catch:{ Exception -> 0x022e }
                java.lang.String r0 = r0.getVideoUrlEncode()     // Catch:{ Exception -> 0x022e }
                r10.append(r0)     // Catch:{ Exception -> 0x022e }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x022e }
            L_0x0208:
                com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x022e }
                java.lang.String r3 = r9.e     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.videocommon.download.a r10 = r0.a(r3, r10)     // Catch:{ Exception -> 0x022e }
                if (r10 == 0) goto L_0x0236
                r10.o()     // Catch:{ Exception -> 0x022e }
                r9.n = r4     // Catch:{ Exception -> 0x022e }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022e }
                r10.<init>(r2)     // Catch:{ Exception -> 0x022e }
                r10.append(r11)     // Catch:{ Exception -> 0x022e }
                java.lang.String r11 = " and start download !"
                r10.append(r11)     // Catch:{ Exception -> 0x022e }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x022e }
                com.mbridge.msdk.foundation.tools.aa.d(r1, r10)     // Catch:{ Exception -> 0x022e }
                goto L_0x0236
            L_0x022e:
                r10 = move-exception
                java.lang.String r10 = r10.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r1, r10)
            L_0x0236:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.onPlayProgress(int, int):void");
        }

        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                MediaEvents mediaEvents = this.c;
                if (mediaEvents != null) {
                    mediaEvents.bufferStart();
                }
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) && this.b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.n);
                        jSONObject.put("id", this.d);
                        jSONObject.put("data", new JSONObject());
                        g.a().a(this.b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        c.a().a(this.b, e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                MediaEvents mediaEvents = this.c;
                if (mediaEvents != null) {
                    mediaEvents.bufferFinish();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }
    }

    public void setSoundImageViewVisble(int i) {
        this.q.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i) {
        this.r.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCloseViewVisable(int i) {
        this.s.setVisibility(i == 0 ? 4 : 0);
    }

    public void setShowClose(int i) {
        this.y = i;
    }

    public void setProgressBarState(int i) {
        ProgressBar progressBar = this.P;
        if (progressBar != null) {
            progressBar.setVisibility(i == 0 ? 8 : 0);
        }
    }

    public void setShowMute(int i) {
        this.z = i;
    }

    public void setShowTime(int i) {
        this.x = i;
    }

    /* access modifiers changed from: private */
    public static String b(int i, int i2) {
        if (i2 != 0) {
            double d = (double) (((float) i) / ((float) i2));
            try {
                return af.a(Double.valueOf(d)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i2 + "";
    }

    public void setVolume(float f, float f2) {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setVolume(f, f2);
        }
    }

    public void setPlaybackParams(float f) {
        PlayerView playerView = this.p;
        if (playerView != null) {
            playerView.setPlaybackParams(f);
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            i = this.O.getPaddingLeft();
        }
        if (i2 <= 0) {
            i2 = this.O.getPaddingRight();
        }
        if (i3 <= 0) {
            i3 = this.O.getPaddingTop();
        }
        if (i4 <= 0) {
            i4 = this.O.getPaddingBottom();
        }
        aa.d(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        this.O.setPadding(i, i3, i2, i4);
    }

    public void preLoadData() {
        String str;
        int i;
        if (this.b.getAdType() == 94 || this.b.getAdType() == 287) {
            str = this.b.getRequestId() + this.b.getId() + this.b.getVideoUrlEncode();
        } else {
            str = this.b.getId() + this.b.getVideoUrlEncode() + this.b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.c, str);
        if (a2 != null) {
            this.w = a2;
        }
        this.F = d();
        try {
            if (this.b != null && this.b.isActiveOm()) {
                this.A = com.mbridge.msdk.a.b.a(getContext(), false, this.b.getOmid(), this.b.getRequestId(), this.b.getId(), this.c, "", this.b.getRequestIdNotice());
            }
            AdSession adSession = this.A;
            if (adSession != null) {
                PlayerView playerView = this.p;
                if (playerView != null) {
                    adSession.registerAdView(playerView);
                }
                SoundImageView soundImageView = this.q;
                if (soundImageView != null) {
                    this.A.addFriendlyObstruction(soundImageView, FriendlyObstructionPurpose.OTHER, (String) null);
                }
                TextView textView = this.r;
                if (textView != null) {
                    this.A.addFriendlyObstruction(textView, FriendlyObstructionPurpose.OTHER, (String) null);
                }
                View view = this.s;
                if (view != null) {
                    this.A.addFriendlyObstruction(view, FriendlyObstructionPurpose.VIDEO_CONTROLS, (String) null);
                }
                this.C = AdEvents.createAdEvents(this.A);
                this.B = MediaEvents.createMediaEvents(this.A);
                this.A.start();
                this.C.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
            }
        } catch (Throwable th) {
            aa.a(BTBaseView.TAG, th.getMessage());
        }
        this.J = c();
        if (this.h && !TextUtils.isEmpty(this.J) && this.b != null) {
            AdSession adSession2 = this.A;
            if (adSession2 != null) {
                adSession2.registerAdView(this.p);
                this.A.addFriendlyObstruction(this.q, FriendlyObstructionPurpose.OTHER, (String) null);
                this.A.addFriendlyObstruction(this.r, FriendlyObstructionPurpose.OTHER, (String) null);
                this.A.addFriendlyObstruction(this.s, FriendlyObstructionPurpose.VIDEO_CONTROLS, (String) null);
            }
            a aVar = new a(this, this.v, this.B);
            this.D = aVar;
            CampaignEx campaignEx = this.b;
            if (campaignEx == null) {
                i = com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), this.c, false).r();
            } else if (campaignEx.getReady_rate() != -1) {
                i = campaignEx.getReady_rate();
            } else {
                i = com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), this.c, false).r();
            }
            aVar.a(i, com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), this.c, false).s());
            this.p.setDesk(false);
            this.p.initBufferIngParam(this.F);
            soundOperate(this.E, -1, (String) null);
        }
        K = false;
    }
}
