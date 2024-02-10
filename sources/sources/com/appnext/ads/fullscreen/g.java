package com.appnext.ads.fullscreen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.appnext.R;

public final class g extends Fragment {
    /* access modifiers changed from: private */
    public ImageView P;
    /* access modifiers changed from: private */
    public Button Q;
    /* access modifiers changed from: private */
    public TextView R;
    /* access modifiers changed from: private */
    public ImageView S;
    /* access modifiers changed from: private */
    public Animation T;
    private final int TICK = 330;
    /* access modifiers changed from: private */
    public ImageView U;
    /* access modifiers changed from: private */
    public boolean V = false;
    /* access modifiers changed from: private */
    public j W;
    Runnable X = new Runnable() {
        public final void run() {
            g.this.R.setAlpha(1.0f);
            g.this.R.animate().alpha(0.0f).setDuration(1000);
        }
    };
    /* access modifiers changed from: private */
    public int currentPosition = 0;
    /* access modifiers changed from: private */
    public Circle d;
    /* access modifiers changed from: private */
    public boolean finished = false;
    private int lastProgress = 0;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public boolean started = false;
    Runnable tick = new Runnable() {
        public final void run() {
            try {
                if (g.this.videoView != null) {
                    g.this.videoView.getCurrentPosition();
                    g.this.videoView.getDuration();
                    if (g.this.videoView.getDuration() == -1) {
                        g.this.p();
                        return;
                    }
                    g.this.checkProgress();
                    if (g.this.d.getVisibility() == 0) {
                        a aVar = new a(g.this.d, 360.0f - ((((float) (g.this.videoView.getCurrentPosition() + 1)) / ((float) g.this.videoView.getDuration())) * 360.0f));
                        aVar.setDuration(330);
                        g.this.d.startAnimation(aVar);
                    }
                    if (g.this.videoView.getCurrentPosition() < g.this.videoView.getDuration() && !g.this.finished) {
                        g.this.mHandler.postDelayed(g.this.tick, 330);
                    }
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("RollFragment$RunnableTick", th);
            }
        }
    };
    /* access modifiers changed from: private */
    public VideoView videoView;

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.W = (j) activity;
        q();
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.W = (j) context;
        q();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(23:1|2|(1:4)(1:5)|6|(1:8)|9|(1:11)|12|(1:18)|19|20|(2:22|23)(1:24)|25|(1:29)|30|(1:32)|33|34|35|36|37|38|(1:40)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0167 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, final android.os.Bundle r10) {
        /*
            r7 = this;
            java.lang.String r0 = "showCta"
            java.lang.String r1 = "RollFragment$onCreateView"
            com.appnext.ads.fullscreen.j r2 = r7.W     // Catch:{ all -> 0x01c1 }
            java.lang.String r3 = "S2"
            int r2 = r2.getTemplate(r3)     // Catch:{ all -> 0x01c1 }
            r3 = 0
            android.view.View r8 = r8.inflate(r2, r9, r3)     // Catch:{ all -> 0x01c1 }
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8     // Catch:{ all -> 0x01c1 }
            int r9 = com.appnext.R.id.privacy     // Catch:{ all -> 0x01c1 }
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ all -> 0x01c1 }
            android.widget.ImageView r9 = (android.widget.ImageView) r9     // Catch:{ all -> 0x01c1 }
            int r2 = com.appnext.R.id.close     // Catch:{ all -> 0x01c1 }
            android.view.View r2 = r8.findViewById(r2)     // Catch:{ all -> 0x01c1 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ all -> 0x01c1 }
            r7.U = r2     // Catch:{ all -> 0x01c1 }
            int r2 = com.appnext.R.id.v_view     // Catch:{ all -> 0x01c1 }
            android.view.View r2 = r8.findViewById(r2)     // Catch:{ all -> 0x01c1 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ all -> 0x01c1 }
            r7.P = r2     // Catch:{ all -> 0x01c1 }
            int r2 = com.appnext.R.id.install     // Catch:{ all -> 0x01c1 }
            android.view.View r2 = r8.findViewById(r2)     // Catch:{ all -> 0x01c1 }
            android.widget.Button r2 = (android.widget.Button) r2     // Catch:{ all -> 0x01c1 }
            r7.Q = r2     // Catch:{ all -> 0x01c1 }
            int r2 = com.appnext.R.id.circle     // Catch:{ all -> 0x01c1 }
            android.view.View r2 = r8.findViewById(r2)     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.Circle r2 = (com.appnext.ads.fullscreen.Circle) r2     // Catch:{ all -> 0x01c1 }
            r7.d = r2     // Catch:{ all -> 0x01c1 }
            int r2 = com.appnext.R.id.click_txt     // Catch:{ all -> 0x01c1 }
            android.view.View r2 = r8.findViewById(r2)     // Catch:{ all -> 0x01c1 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ all -> 0x01c1 }
            r7.R = r2     // Catch:{ all -> 0x01c1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c1 }
            java.lang.String r5 = "You will be redirected to "
            r4.<init>(r5)     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r5 = r7.W     // Catch:{ all -> 0x01c1 }
            boolean r5 = r5.isInstalled()     // Catch:{ all -> 0x01c1 }
            if (r5 == 0) goto L_0x005f
            java.lang.String r5 = "app"
            goto L_0x0061
        L_0x005f:
            java.lang.String r5 = "Google Play"
        L_0x0061:
            r4.append(r5)     // Catch:{ all -> 0x01c1 }
            java.lang.String r5 = " once the ad will finish"
            r4.append(r5)     // Catch:{ all -> 0x01c1 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01c1 }
            r2.setText(r4)     // Catch:{ all -> 0x01c1 }
            int r2 = com.appnext.R.id.loader     // Catch:{ all -> 0x01c1 }
            android.view.View r2 = r8.findViewById(r2)     // Catch:{ all -> 0x01c1 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ all -> 0x01c1 }
            r7.S = r2     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.g$1 r2 = new com.appnext.ads.fullscreen.g$1     // Catch:{ all -> 0x01c1 }
            r2.<init>()     // Catch:{ all -> 0x01c1 }
            r9.setOnClickListener(r2)     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r2 = r7.W     // Catch:{ all -> 0x01c1 }
            com.appnext.core.AppnextAd r2 = r2.getSelectedAd()     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r4 = r7.W     // Catch:{ all -> 0x01c1 }
            com.appnext.core.SettingsManager r4 = r4.getConfigManager()     // Catch:{ all -> 0x01c1 }
            boolean r2 = com.appnext.core.i.a((com.appnext.core.AppnextAd) r2, (com.appnext.core.SettingsManager) r4)     // Catch:{ all -> 0x01c1 }
            if (r2 == 0) goto L_0x009b
            com.appnext.ads.fullscreen.j r2 = r7.W     // Catch:{ all -> 0x01c1 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x01c1 }
            com.appnext.core.i.a((android.content.Context) r2, (android.widget.ImageView) r9)     // Catch:{ all -> 0x01c1 }
        L_0x009b:
            android.widget.ImageView r9 = r7.U     // Catch:{ all -> 0x01c1 }
            r2 = 8
            r9.setVisibility(r2)     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r9 = r7.W     // Catch:{ all -> 0x01c1 }
            boolean r9 = r9.showClose()     // Catch:{ all -> 0x01c1 }
            if (r9 == 0) goto L_0x00ba
            android.os.Handler r9 = r7.mHandler     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.g$4 r4 = new com.appnext.ads.fullscreen.g$4     // Catch:{ all -> 0x01c1 }
            r4.<init>()     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r5 = r7.W     // Catch:{ all -> 0x01c1 }
            long r5 = r5.closeDelay()     // Catch:{ all -> 0x01c1 }
            r9.postDelayed(r4, r5)     // Catch:{ all -> 0x01c1 }
        L_0x00ba:
            android.widget.ImageView r9 = r7.U     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.g$5 r4 = new com.appnext.ads.fullscreen.g$5     // Catch:{ all -> 0x01c1 }
            r4.<init>()     // Catch:{ all -> 0x01c1 }
            r9.setOnClickListener(r4)     // Catch:{ all -> 0x01c1 }
            android.os.Bundle r9 = r7.getArguments()     // Catch:{ all -> 0x01c1 }
            if (r9 == 0) goto L_0x00e3
            android.os.Bundle r9 = r7.getArguments()     // Catch:{ all -> 0x01c1 }
            boolean r9 = r9.containsKey(r0)     // Catch:{ all -> 0x01c1 }
            if (r9 == 0) goto L_0x00e3
            android.os.Bundle r9 = r7.getArguments()     // Catch:{ all -> 0x01c1 }
            boolean r9 = r9.getBoolean(r0)     // Catch:{ all -> 0x01c1 }
            if (r9 != 0) goto L_0x00e3
            android.widget.Button r9 = r7.Q     // Catch:{ all -> 0x01c1 }
            r9.setVisibility(r2)     // Catch:{ all -> 0x01c1 }
        L_0x00e3:
            com.appnext.ads.fullscreen.j r9 = r7.W     // Catch:{ all -> 0x01c1 }
            java.lang.String r9 = r9.getCtaText()     // Catch:{ all -> 0x01c1 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01c1 }
            java.lang.String r2 = "settings"
            r4 = 23
            if (r0 < r4) goto L_0x010a
            android.content.Context r0 = r7.getContext()     // Catch:{ all -> 0x01c1 }
            com.appnext.core.a.a r0 = com.appnext.core.a.a.n(r0)     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r5 = r7.W     // Catch:{ all -> 0x01c1 }
            java.lang.String r5 = r5.getLanguage()     // Catch:{ all -> 0x01c1 }
            java.lang.String r6 = "len"
            java.lang.String r0 = r0.a(r5, r2, r6)     // Catch:{ all -> 0x01c1 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x01c1 }
            goto L_0x010b
        L_0x010a:
            r0 = 0
        L_0x010b:
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x01c1 }
            if (r5 != 0) goto L_0x011b
            int r5 = r9.length()     // Catch:{ all -> 0x01c1 }
            if (r5 <= r0) goto L_0x011b
            java.lang.String r9 = r9.substring(r3, r0)     // Catch:{ all -> 0x01c1 }
        L_0x011b:
            android.widget.Button r0 = r7.Q     // Catch:{ all -> 0x01c1 }
            r0.setText(r9)     // Catch:{ all -> 0x01c1 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01c1 }
            if (r9 < r4) goto L_0x0143
            android.widget.Button r9 = r7.Q     // Catch:{ all -> 0x01c1 }
            android.content.Context r0 = r7.getContext()     // Catch:{ all -> 0x01c1 }
            com.appnext.core.a.a r0 = com.appnext.core.a.a.n(r0)     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.j r4 = r7.W     // Catch:{ all -> 0x01c1 }
            java.lang.String r4 = r4.getLanguage()     // Catch:{ all -> 0x01c1 }
            java.lang.String r5 = "font_size_sp"
            java.lang.String r0 = r0.a(r4, r2, r5)     // Catch:{ all -> 0x01c1 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x01c1 }
            float r0 = (float) r0     // Catch:{ all -> 0x01c1 }
            r2 = 2
            r9.setTextSize(r2, r0)     // Catch:{ all -> 0x01c1 }
        L_0x0143:
            android.widget.Button r9 = r7.Q     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.g$6 r0 = new com.appnext.ads.fullscreen.g$6     // Catch:{ all -> 0x01c1 }
            r0.<init>()     // Catch:{ all -> 0x01c1 }
            r9.setOnClickListener(r0)     // Catch:{ all -> 0x01c1 }
            android.widget.ImageView r9 = r7.P     // Catch:{ all -> 0x01c1 }
            com.appnext.ads.fullscreen.g$7 r0 = new com.appnext.ads.fullscreen.g$7     // Catch:{ all -> 0x01c1 }
            r0.<init>()     // Catch:{ all -> 0x01c1 }
            r9.setOnClickListener(r0)     // Catch:{ all -> 0x01c1 }
            android.widget.VideoView r9 = new android.widget.VideoView     // Catch:{ all -> 0x0167 }
            android.app.Activity r0 = r7.getActivity()     // Catch:{ all -> 0x0167 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0167 }
            r9.<init>(r0)     // Catch:{ all -> 0x0167 }
            r7.videoView = r9     // Catch:{ all -> 0x0167 }
            goto L_0x0172
        L_0x0167:
            android.widget.VideoView r9 = new android.widget.VideoView     // Catch:{ all -> 0x01b7 }
            android.app.Activity r0 = r7.getActivity()     // Catch:{ all -> 0x01b7 }
            r9.<init>(r0)     // Catch:{ all -> 0x01b7 }
            r7.videoView = r9     // Catch:{ all -> 0x01b7 }
        L_0x0172:
            android.widget.VideoView r9 = r7.videoView     // Catch:{ all -> 0x01b7 }
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x01b7 }
            r2 = -1
            r4 = -2
            r0.<init>(r2, r4)     // Catch:{ all -> 0x01b7 }
            r9.setLayoutParams(r0)     // Catch:{ all -> 0x01b7 }
            int r9 = com.appnext.R.id.media     // Catch:{ all -> 0x01b7 }
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ all -> 0x01b7 }
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9     // Catch:{ all -> 0x01b7 }
            android.widget.VideoView r0 = r7.videoView     // Catch:{ all -> 0x01b7 }
            r9.addView(r0, r3)     // Catch:{ all -> 0x01b7 }
            android.widget.VideoView r9 = r7.videoView     // Catch:{ all -> 0x01b7 }
            com.appnext.ads.fullscreen.g$8 r0 = new com.appnext.ads.fullscreen.g$8     // Catch:{ all -> 0x01b7 }
            r0.<init>(r10)     // Catch:{ all -> 0x01b7 }
            r9.setOnPreparedListener(r0)     // Catch:{ all -> 0x01b7 }
            android.widget.VideoView r9 = r7.videoView     // Catch:{ all -> 0x01b7 }
            com.appnext.ads.fullscreen.g$9 r10 = new com.appnext.ads.fullscreen.g$9     // Catch:{ all -> 0x01b7 }
            r10.<init>()     // Catch:{ all -> 0x01b7 }
            r9.setOnCompletionListener(r10)     // Catch:{ all -> 0x01b7 }
            android.widget.VideoView r9 = r7.videoView     // Catch:{ all -> 0x01b7 }
            com.appnext.ads.fullscreen.g$10 r10 = new com.appnext.ads.fullscreen.g$10     // Catch:{ all -> 0x01b7 }
            r10.<init>()     // Catch:{ all -> 0x01b7 }
            r9.setOnErrorListener(r10)     // Catch:{ all -> 0x01b7 }
            com.appnext.ads.fullscreen.j r9 = r7.W     // Catch:{ all -> 0x01b7 }
            android.net.Uri r9 = r9.getSelectedVideoUri()     // Catch:{ all -> 0x01b7 }
            if (r9 == 0) goto L_0x01bb
            android.widget.VideoView r10 = r7.videoView     // Catch:{ all -> 0x01b7 }
            r10.setVideoURI(r9)     // Catch:{ all -> 0x01b7 }
            goto L_0x01bb
        L_0x01b7:
            r9 = move-exception
            com.appnext.base.a.a(r1, r9)     // Catch:{ all -> 0x01c1 }
        L_0x01bb:
            java.lang.String r9 = "roll_loaded"
            r7.report(r9)     // Catch:{ all -> 0x01c1 }
            return r8
        L_0x01c1:
            r8 = move-exception
            com.appnext.base.a.a(r1, r8)
            com.appnext.ads.fullscreen.j r8 = r7.W
            r8.closeClicked()
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.fullscreen.g.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* access modifiers changed from: private */
    public void p() {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && mediaPlayer2.getCurrentPosition() != 0 && this.mediaPlayer.getDuration() != 0 && !this.finished) {
                this.mediaPlayer.getCurrentPosition();
                this.mediaPlayer.getDuration();
                this.finished = true;
                j jVar = this.W;
                if (jVar != null) {
                    jVar.videoEnded();
                }
                report("video_ended");
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$videoCompleted", th);
        }
    }

    public final void onPause() {
        super.onPause();
        try {
            this.mHandler.removeCallbacks(this.tick);
            VideoView videoView2 = this.videoView;
            if (videoView2 != null) {
                videoView2.pause();
                this.currentPosition = this.videoView.getCurrentPosition();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$videoCompleted", th);
        }
    }

    public final void onResume() {
        MediaPlayer mediaPlayer2;
        super.onResume();
        try {
            if (this.videoView != null && (mediaPlayer2 = this.mediaPlayer) != null && !this.finished) {
                mediaPlayer2.seekTo(this.currentPosition);
                this.mediaPlayer.start();
                this.mHandler.postDelayed(this.tick, 33);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$onResume", th);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            bundle.putInt("currentPosition", this.currentPosition);
            bundle.putBoolean("started", this.started);
            super.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$onSaveInstanceState", th);
        }
    }

    public final void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.currentPosition = bundle.getInt("currentPosition");
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        try {
            VideoView videoView2 = this.videoView;
            if (videoView2 != null) {
                videoView2.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                this.videoView.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                this.videoView.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                this.videoView.suspend();
                this.videoView = null;
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$onDestroyView", th);
        }
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
                this.mediaPlayer = null;
            }
        } catch (Throwable th2) {
            com.appnext.base.a.a("RollFragment$onDestroyView", th2);
        }
    }

    private class a extends Animation {
        final int ac;
        View ae;
        int af;

        public final boolean willChangeBounds() {
            return true;
        }

        a(View view, int i, int i2) {
            this.ae = view;
            this.ac = i;
            this.af = i2;
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            try {
                ViewGroup.LayoutParams layoutParams = this.ae.getLayoutParams();
                int i = this.af;
                layoutParams.width = (int) (((float) i) + (((float) (this.ac - i)) * f));
                this.ae.requestLayout();
            } catch (Throwable th) {
                com.appnext.base.a.a("RollFragment$RunnableTick", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkProgress() {
        try {
            int currentPosition2 = (int) ((((float) this.mediaPlayer.getCurrentPosition()) / ((float) this.mediaPlayer.getDuration())) * 100.0f);
            if (currentPosition2 > 25 && this.lastProgress == 0) {
                this.lastProgress = 25;
                report("video_25");
            } else if (currentPosition2 > 50 && this.lastProgress == 25) {
                this.lastProgress = 50;
                report("video_50");
            } else if (currentPosition2 > 75 && this.lastProgress == 50) {
                this.lastProgress = 75;
                report("video_75");
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$checkProgress", th);
        }
    }

    private void q() {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.apnxt_stream_loader);
            this.T = loadAnimation;
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (g.this.S.getVisibility() != 8) {
                        g.this.S.startAnimation(g.this.T);
                    }
                }
            });
            this.T.setRepeatCount(-1);
            this.T.setRepeatMode(1);
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$createAnimation", th);
        }
    }

    /* access modifiers changed from: private */
    public void report(String str) {
        try {
            this.W.report(str, "S2");
        } catch (Throwable th) {
            com.appnext.base.a.a("RollFragment$report", th);
        }
    }
}
