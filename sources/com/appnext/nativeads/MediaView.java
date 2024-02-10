package com.appnext.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.appnext.a.a;
import com.appnext.a.b;
import com.appnext.core.g;
import java.io.File;

public class MediaView extends RelativeLayout {
    private boolean clickEnabled = true;
    private boolean eT = true;
    /* access modifiers changed from: private */
    public NativeAd eU;
    private MediaType eV;
    private NativeAdData eW;
    /* access modifiers changed from: private */
    public com.appnext.a.a eX;
    private b eY;
    /* access modifiers changed from: private */
    public View eZ;
    /* access modifiers changed from: private */
    public a fa;
    /* access modifiers changed from: private */
    public boolean fb = false;
    /* access modifiers changed from: private */
    public int fc = 0;
    /* access modifiers changed from: private */
    public boolean finished = false;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    private boolean mute = false;
    /* access modifiers changed from: private */
    public Runnable tick = new Runnable() {
        public final void run() {
            try {
                if (MediaView.this.mediaPlayer != null && MediaView.this.mediaPlayer.isPlaying()) {
                    MediaView mediaView = MediaView.this;
                    mediaView.fc = mediaView.mediaPlayer.getCurrentPosition();
                }
            } catch (Throwable unused) {
            }
            if (MediaView.this.mHandler != null) {
                MediaView.this.mHandler.postDelayed(MediaView.this.tick, 500);
            }
        }
    };

    protected enum MediaType {
        VIDEO,
        STATIC
    }

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public final void a(NativeAd nativeAd, NativeAdData nativeAdData, MediaType mediaType) {
        Uri uri;
        try {
            this.eU = nativeAd;
            this.eW = nativeAdData;
            this.eV = mediaType;
            if (mediaType == MediaType.VIDEO) {
                try {
                    this.eX = new com.appnext.a.a(getContext().getApplicationContext());
                } catch (Throwable th) {
                    com.appnext.base.a.a("MediaView$initVideo", th);
                }
                this.mHandler = new Handler();
                this.eX.setPlayPauseListener(new a.C0023a() {
                    public final void aB() {
                        ((ImageView) MediaView.this.eZ).setImageResource(0);
                    }

                    public final void onPause() {
                        ((ImageView) MediaView.this.eZ).setImageResource(R.drawable.apnxt_na_play);
                    }
                });
                this.eX.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        try {
                            MediaView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            if (MediaView.this.eX != null) {
                                if (MediaView.this.getLayoutParams().height == -2) {
                                    MediaView.this.eX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                                } else if (MediaView.this.getLayoutParams().height == -1) {
                                    MediaView.this.eX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                                } else if (MediaView.this.getLayoutParams().height < g.a(MediaView.this.getContext(), 200.0f)) {
                                    MediaView.this.eX.setLayoutParams(new RelativeLayout.LayoutParams(-1, g.a(MediaView.this.getContext(), 200.0f)));
                                } else {
                                    MediaView.this.eX.setLayoutParams(new RelativeLayout.LayoutParams(-1, MediaView.this.getHeight()));
                                }
                                ((RelativeLayout.LayoutParams) MediaView.this.eX.getLayoutParams()).addRule(13);
                                ((RelativeLayout.LayoutParams) MediaView.this.eZ.getLayoutParams()).addRule(13);
                            }
                        } catch (Throwable th) {
                            com.appnext.base.a.a("MediaView$initVideo", th);
                        }
                    }
                });
                this.eX.setLayoutParams(new RelativeLayout.LayoutParams(-1, 1));
                addView(this.eX);
                this.eX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public final void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            MediaView.this.mediaPlayer = mediaPlayer;
                            if (MediaView.this.isMute()) {
                                MediaView.this.mediaPlayer.setVolume(0.0f, 0.0f);
                            } else {
                                MediaView.this.mediaPlayer.setVolume(1.0f, 1.0f);
                            }
                            MediaView.this.mHandler.removeCallbacksAndMessages((Object) null);
                            MediaView.this.mHandler.post(MediaView.this.tick);
                            MediaView.this.mediaPlayer.seekTo(MediaView.this.fc);
                            MediaView.this.mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                                    try {
                                        if (MediaView.this.isAutoPLay() && MediaView.this.eX != null && MediaView.this.eU != null && MediaView.this.eU.getNativeAdView().getVisiblePercent(MediaView.this.eX) > 90) {
                                            MediaView.this.play();
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    try {
                                        MediaView.this.eZ.getLayoutParams().height = MediaView.this.eX.getMeasuredHeight();
                                    } catch (Throwable th) {
                                        com.appnext.base.a.a("MediaView$initVideo", th);
                                    }
                                }
                            }, 200);
                            MediaView.this.mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                                public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                                    return false;
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }
                });
                this.eX.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        return true;
                    }
                });
                this.eX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        try {
                            if (MediaView.this.mediaPlayer != null && MediaView.this.mediaPlayer.getCurrentPosition() != 0 && MediaView.this.mediaPlayer.getDuration() != 0 && !MediaView.this.finished) {
                                MediaView.this.finished = true;
                                if (!MediaView.this.isClickEnabled()) {
                                    ((ImageView) MediaView.this.eZ).setImageResource(R.drawable.apnxt_na_play);
                                }
                            }
                        } catch (Throwable th) {
                            com.appnext.base.a.a("MediaView$initVideo", th);
                        }
                    }
                });
                String selectedVideo = this.eW.getSelectedVideo();
                if (selectedVideo != null) {
                    if (!selectedVideo.equals("")) {
                        a aVar = new a(getContext());
                        this.eZ = aVar;
                        addView(aVar);
                        this.eZ.getLayoutParams().height = -1;
                        this.eZ.getLayoutParams().width = -1;
                        ((ImageView) this.eZ).setImageResource(R.drawable.apnxt_na_play);
                        ((ImageView) this.eZ).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        this.eZ.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                try {
                                    if (MediaView.this.eX == null || !MediaView.this.eX.isPlaying()) {
                                        MediaView.this.fb = false;
                                        MediaView.this.finished = false;
                                        MediaView.this.eX.start();
                                    } else if (MediaView.this.isClickEnabled()) {
                                        if (!MediaView.this.isAutoPLay()) {
                                            ((ImageView) MediaView.this.eZ).setImageResource(R.drawable.apnxt_na_play);
                                        }
                                        boolean unused = MediaView.super.callOnClick();
                                    } else {
                                        MediaView.this.fb = true;
                                        MediaView.this.eX.pause();
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        });
                        if (isAutoPLay()) {
                            ((ImageView) this.eZ).setImageResource(0);
                        }
                        a aVar2 = new a(getContext());
                        this.fa = aVar2;
                        addView(aVar2);
                        this.fa.getLayoutParams().height = g.a(getContext(), 30.0f);
                        this.fa.getLayoutParams().width = g.a(getContext(), 30.0f);
                        if (isMute()) {
                            this.fa.setImageResource(R.drawable.apnxt_na_mute);
                        } else {
                            this.fa.setImageResource(R.drawable.apnxt_na_unmute);
                        }
                        this.fa.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                try {
                                    MediaView mediaView = MediaView.this;
                                    mediaView.setMute(!mediaView.isMute());
                                    if (MediaView.this.isMute()) {
                                        MediaView.this.fa.setImageResource(R.drawable.apnxt_na_mute);
                                    } else {
                                        MediaView.this.fa.setImageResource(R.drawable.apnxt_na_unmute);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                        com.appnext.a.a aVar3 = this.eX;
                        String b = g.b(selectedVideo);
                        String str = getContext().getFilesDir().getAbsolutePath() + "/data/appnext/videos/";
                        if (new File(str + b).exists()) {
                            uri = Uri.parse(str + b);
                        } else {
                            uri = Uri.parse(selectedVideo);
                        }
                        aVar3.setVideoURI(uri);
                    }
                }
                removeView(this.eX);
                this.eX = null;
                aA();
            } else {
                aA();
            }
            if (getBackground() == null) {
                setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        } catch (Throwable th2) {
            com.appnext.base.a.a("MediaView$initData", th2);
        }
    }

    private void aA() {
        try {
            this.eY = new b(getContext());
            this.eU.downloadAndDisplayImage(getContext(), this.eY, this.eW.getWideImageURL());
            addView(this.eY);
            ((RelativeLayout.LayoutParams) this.eY.getLayoutParams()).addRule(13);
            this.eY.getLayoutParams().width = -1;
            this.eY.getLayoutParams().height = -2;
            this.eY.setAdjustViewBounds(true);
        } catch (Throwable th) {
            com.appnext.base.a.a("MediaView$initStatic", th);
        }
    }

    public void setAutoPLay(boolean z) {
        this.eT = z;
    }

    public void setMute(boolean z) {
        this.mute = z;
        try {
            if (this.mediaPlayer == null) {
                return;
            }
            if (isMute()) {
                this.mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mediaPlayer.setVolume(1.0f, 1.0f);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("MediaView$setMute", th);
        }
    }

    public boolean isMute() {
        return this.mute;
    }

    public boolean isAutoPLay() {
        return this.eT;
    }

    public boolean isClickEnabled() {
        return this.clickEnabled;
    }

    public void setClickEnabled(boolean z) {
        this.clickEnabled = z;
    }

    public void play() {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && !mediaPlayer2.isPlaying()) {
                this.mediaPlayer.start();
                ((ImageView) this.eZ).setImageResource(0);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("MediaView$play", th);
        }
    }

    public void pause() {
        try {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                this.mediaPlayer.pause();
                ((ImageView) this.eZ).setImageResource(R.drawable.apnxt_na_play);
            }
        } catch (Throwable unused) {
        }
    }

    public void destroy() {
        removeAllViews();
        try {
            com.appnext.a.a aVar = this.eX;
            if (aVar != null) {
                aVar.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                this.eX.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                this.eX.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                this.eX.suspend();
                this.eX = null;
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("MediaView$destroy", th);
        }
        try {
            b bVar = this.eY;
            if (bVar != null) {
                bVar.setImageBitmap((Bitmap) null);
                this.eY = null;
            }
        } catch (Throwable th2) {
            com.appnext.base.a.a("MediaView$destroy", th2);
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(int i) {
        if (this.eV != MediaType.VIDEO) {
            return;
        }
        if (i < 90) {
            pause();
        } else if (!this.fb && isAutoPLay() && !this.finished) {
            play();
        }
    }

    class a extends ImageView {
        public a(Context context) {
            super(context);
        }
    }
}
