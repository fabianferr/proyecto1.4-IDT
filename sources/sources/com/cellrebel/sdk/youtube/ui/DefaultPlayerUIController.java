package com.cellrebel.sdk.youtube.ui;

import android.animation.Animator;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.media3.common.C;
import com.cellrebel.sdk.R;
import com.cellrebel.sdk.youtube.player.PlayerConstants;
import com.cellrebel.sdk.youtube.player.YouTubePlayer;
import com.cellrebel.sdk.youtube.player.YouTubePlayerView;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerFullScreenListener;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener;
import com.cellrebel.sdk.youtube.ui.menu.YouTubePlayerMenu;
import com.cellrebel.sdk.youtube.utils.Utils;

public class DefaultPlayerUIController implements PlayerUIController, YouTubePlayerListener, YouTubePlayerFullScreenListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private final Handler A = new Handler(Looper.getMainLooper());
    private final Runnable B = new a();
    private boolean C = false;
    private int D = -1;
    private final YouTubePlayerView a;
    private final YouTubePlayer b;
    private YouTubePlayerMenu c;
    private View d;
    /* access modifiers changed from: private */
    public View e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    /* access modifiers changed from: private */
    public TextView i;
    private TextView j;
    private ProgressBar k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    /* access modifiers changed from: private */
    public SeekBar r;
    private View.OnClickListener s;
    private View.OnClickListener t;
    private boolean u = false;
    private boolean v = true;
    private boolean w = false;
    private boolean x = true;
    private boolean y = true;
    private boolean z = true;

    class a implements Runnable {
        a() {
        }

        public void run() {
            DefaultPlayerUIController.this.d(0.0f);
        }
    }

    class b implements Animator.AnimatorListener {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a == 0.0f) {
                DefaultPlayerUIController.this.e.setVisibility(8);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if (this.a == 1.0f) {
                DefaultPlayerUIController.this.e.setVisibility(0);
            }
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            DefaultPlayerUIController.this.e.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.a + "#t=" + DefaultPlayerUIController.this.r.getProgress())));
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            DefaultPlayerUIController.this.i.setText("");
        }
    }

    static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState[] r0 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.ENDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.PLAYING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.UNSTARTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.youtube.ui.DefaultPlayerUIController.e.<clinit>():void");
        }
    }

    public DefaultPlayerUIController(YouTubePlayerView youTubePlayerView, YouTubePlayer youTubePlayer) {
        this.a = youTubePlayerView;
        this.b = youTubePlayer;
        a(View.inflate(youTubePlayerView.getContext(), R.layout.default_player_ui, youTubePlayerView));
    }

    private void a(View view) {
        this.d = view.findViewById(R.id.panel);
        this.e = view.findViewById(R.id.controls_root);
        this.f = (LinearLayout) view.findViewById(R.id.extra_views_container);
        this.g = (TextView) view.findViewById(R.id.video_title);
        this.h = (TextView) view.findViewById(R.id.video_current_time);
        this.i = (TextView) view.findViewById(R.id.video_duration);
        this.j = (TextView) view.findViewById(R.id.live_video_indicator);
        this.k = (ProgressBar) view.findViewById(R.id.progress);
        this.l = (ImageView) view.findViewById(R.id.menu_button);
        this.m = (ImageView) view.findViewById(R.id.play_pause_button);
        this.n = (ImageView) view.findViewById(R.id.youtube_button);
        this.o = (ImageView) view.findViewById(R.id.fullscreen_button);
        this.p = (ImageView) view.findViewById(R.id.custom_action_left_button);
        this.q = (ImageView) view.findViewById(R.id.custom_action_right_button);
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seek_bar);
        this.r = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.d.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.o.setOnClickListener(this);
    }

    private void a(boolean z2) {
        this.m.setImageResource(z2 ? R.drawable.ic_pause_36dp : R.drawable.ic_play_36dp);
    }

    private void b(PlayerConstants.PlayerState playerState) {
        int i2 = e.a[playerState.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.u = false;
        } else if (i2 == 3) {
            this.u = true;
        } else if (i2 == 4) {
            h();
        }
        a(!this.u);
    }

    /* access modifiers changed from: private */
    public void d(float f2) {
        if (this.w && this.x) {
            this.v = f2 != 0.0f;
            if (f2 != 1.0f || !this.u) {
                this.A.removeCallbacks(this.B);
            } else {
                i();
            }
            this.e.animate().alpha(f2).setDuration(300).setListener(new b(f2)).start();
        }
    }

    private void e() {
        View.OnClickListener onClickListener = this.s;
        if (onClickListener == null) {
            this.a.d();
        } else {
            onClickListener.onClick(this.o);
        }
    }

    private void f() {
        View.OnClickListener onClickListener = this.t;
        if (onClickListener == null) {
            this.c.a(this.l);
        } else {
            onClickListener.onClick(this.l);
        }
    }

    private void g() {
        if (this.u) {
            this.b.c();
        } else {
            this.b.b();
        }
    }

    private void h() {
        this.r.setProgress(0);
        this.r.setMax(0);
        this.i.post(new d());
    }

    private void i() {
        this.A.postDelayed(this.B, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    private void j() {
        d(this.v ? 0.0f : 1.0f);
    }

    public void a() {
    }

    public void a(float f2) {
        this.i.setText(Utils.a(f2));
        this.r.setMax((int) f2);
    }

    public void a(PlayerConstants.PlaybackQuality playbackQuality) {
    }

    public void a(PlayerConstants.PlaybackRate playbackRate) {
    }

    public void a(PlayerConstants.PlayerError playerError) {
    }

    public void a(PlayerConstants.PlayerState playerState) {
        this.D = -1;
        b(playerState);
        PlayerConstants.PlayerState playerState2 = PlayerConstants.PlayerState.PLAYING;
        boolean z2 = false;
        if (playerState == playerState2 || playerState == PlayerConstants.PlayerState.PAUSED || playerState == PlayerConstants.PlayerState.VIDEO_CUED) {
            this.d.setBackgroundColor(ContextCompat.getColor(this.a.getContext(), 17170445));
            this.k.setVisibility(8);
            if (this.y) {
                this.m.setVisibility(0);
            }
            this.w = true;
            if (playerState == playerState2) {
                z2 = true;
            }
            a(z2);
            if (z2) {
                i();
            } else {
                this.A.removeCallbacks(this.B);
            }
        } else {
            a(false);
            d(1.0f);
            if (playerState == PlayerConstants.PlayerState.BUFFERING) {
                this.d.setBackgroundColor(ContextCompat.getColor(this.a.getContext(), 17170445));
                if (this.y) {
                    this.m.setVisibility(4);
                }
                this.p.setVisibility(8);
                this.q.setVisibility(8);
                this.w = false;
            }
            if (playerState == PlayerConstants.PlayerState.UNSTARTED) {
                this.w = false;
                this.k.setVisibility(8);
                if (this.y) {
                    this.m.setVisibility(0);
                }
            }
        }
    }

    public void a(String str) {
        this.n.setOnClickListener(new c(str));
    }

    public void b() {
        this.o.setImageResource(R.drawable.ic_fullscreen_24dp);
    }

    public void b(float f2) {
        if (!this.C) {
            if (this.D <= 0 || Utils.a(f2).equals(Utils.a((float) this.D))) {
                this.D = -1;
                this.r.setProgress((int) f2);
            }
        }
    }

    public void c() {
    }

    public void c(float f2) {
        if (this.z) {
            SeekBar seekBar = this.r;
            seekBar.setSecondaryProgress((int) (f2 * ((float) seekBar.getMax())));
            return;
        }
        this.r.setSecondaryProgress(0);
    }

    public void d() {
        this.o.setImageResource(R.drawable.ic_fullscreen_exit_24dp);
    }

    public void onClick(View view) {
        if (view == this.d) {
            j();
        } else if (view == this.m) {
            g();
        } else if (view == this.o) {
            e();
        } else if (view == this.l) {
            f();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        this.h.setText(Utils.a((float) i2));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.C = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.u) {
            this.D = seekBar.getProgress();
        }
        this.b.a((float) seekBar.getProgress());
        this.C = false;
    }
}
