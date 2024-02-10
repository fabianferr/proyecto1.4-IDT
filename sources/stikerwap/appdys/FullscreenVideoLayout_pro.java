package stikerwap.appdys;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Locale;
import stikerwap.appdys.FullscreenVideoView_pro;
import stikerwap.appdys.config;

public class FullscreenVideoLayout_pro extends FullscreenVideoView_pro implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnPreparedListener, View.OnTouchListener {
    private static final String TAG = "FullscreenVideoLayout";
    protected static final Handler TIME_THREAD = new Handler();
    protected boolean esStream = false;
    private config globales;
    protected ImageButton imgcast;
    protected ImageButton imgdownload;
    protected ImageButton imgfullscreen;
    protected ImageButton imgplay;
    public boolean modo_publi = false;
    protected SeekBar seekBar;
    protected TextView textElapsed;
    protected TextView textTotal;
    protected View.OnTouchListener touchListener;
    protected Runnable updateTimeRunnable = new Runnable() {
        public void run() {
            FullscreenVideoLayout_pro.this.updateCounter();
            FullscreenVideoLayout_pro.TIME_THREAD.postDelayed(this, 200);
        }
    };
    public String url_click = "";
    public String url_imp = "";
    protected View videoControlsView;

    public FullscreenVideoLayout_pro(Context context) {
        super(context);
    }

    public FullscreenVideoLayout_pro(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullscreenVideoLayout_pro(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        Log.d(TAG, "init");
        super.init();
        if (!isInEditMode()) {
            super.setOnTouchListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        super.initObjects();
        this.globales = (config) this.context.getApplicationContext();
        if (this.videoControlsView == null) {
            this.videoControlsView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.view_videocontrols_sincast, this, false);
        }
        if (this.videoControlsView != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.videoControlsView, layoutParams);
            this.seekBar = (SeekBar) this.videoControlsView.findViewById(R.id.vcv_seekbar);
            this.imgfullscreen = (ImageButton) this.videoControlsView.findViewById(R.id.vcv_img_fullscreen);
            this.imgplay = (ImageButton) this.videoControlsView.findViewById(R.id.vcv_img_play);
            this.imgcast = (ImageButton) this.videoControlsView.findViewById(R.id.vcv_img_cast);
            this.imgdownload = (ImageButton) this.videoControlsView.findViewById(R.id.vcv_img_download);
            this.textTotal = (TextView) this.videoControlsView.findViewById(R.id.vcv_txt_total);
            this.textElapsed = (TextView) this.videoControlsView.findViewById(R.id.vcv_txt_elapsed);
        }
        ImageButton imageButton = this.imgplay;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = this.imgcast;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = this.imgdownload;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this);
        }
        ImageButton imageButton4 = this.imgfullscreen;
        if (imageButton4 != null) {
            imageButton4.setOnClickListener(this);
        }
        SeekBar seekBar2 = this.seekBar;
        if (seekBar2 != null) {
            seekBar2.setOnSeekBarChangeListener(this);
        }
        View view = this.videoControlsView;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void reorganizar(boolean z, boolean z2) {
        if (!z) {
            this.videoControlsView.findViewById(R.id.vcv_img_cast).setVisibility(8);
            if (z2) {
                this.imgdownload.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.imgdownload.getLayoutParams()).addRule(11);
                ((RelativeLayout.LayoutParams) this.imgfullscreen.getLayoutParams()).addRule(0, R.id.vcv_img_download);
                return;
            }
            ((RelativeLayout.LayoutParams) this.imgfullscreen.getLayoutParams()).addRule(11);
        } else if (z2) {
            this.imgdownload.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.imgdownload.getLayoutParams()).addRule(0, R.id.vcv_img_cast);
            ((RelativeLayout.LayoutParams) this.imgfullscreen.getLayoutParams()).addRule(0, R.id.vcv_img_download);
        } else {
            ((RelativeLayout.LayoutParams) this.imgfullscreen.getLayoutParams()).addRule(0, R.id.vcv_img_cast);
        }
    }

    /* access modifiers changed from: protected */
    public void releaseObjects() {
        super.releaseObjects();
        View view = this.videoControlsView;
        if (view != null) {
            removeView(view);
        }
    }

    /* access modifiers changed from: protected */
    public void startCounter() {
        Log.d(TAG, "startCounter");
        TIME_THREAD.postDelayed(this.updateTimeRunnable, 200);
    }

    /* access modifiers changed from: protected */
    public void stopCounter() {
        Log.d(TAG, "stopCounter");
        TIME_THREAD.removeCallbacks(this.updateTimeRunnable);
    }

    /* access modifiers changed from: protected */
    public void updateCounter() {
        int currentPosition;
        if (this.textElapsed != null && (currentPosition = getCurrentPosition()) > 0 && currentPosition < getDuration()) {
            this.seekBar.setProgress(currentPosition);
            int round = Math.round(((float) currentPosition) / 1000.0f);
            long j = (long) (round % 60);
            long j2 = (long) ((round / 60) % 60);
            long j3 = (long) ((round / 3600) % 24);
            if (j3 > 0) {
                this.textElapsed.setText(String.format(Locale.US, "%d:%02d:%02d", new Object[]{Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)}));
                return;
            }
            this.textElapsed.setText(String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(j2), Long.valueOf(j)}));
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.touchListener = onTouchListener;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onCompletion");
        super.onCompletion(mediaPlayer);
        stopCounter();
        updateControls();
        if (this.currentState != FullscreenVideoView_pro.State.ERROR) {
            updateCounter();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean onError = super.onError(mediaPlayer, i, i2);
        stopCounter();
        updateControls();
        return onError;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getCurrentState() == FullscreenVideoView_pro.State.END) {
            Log.d(TAG, "onDetachedFromWindow END");
            stopCounter();
        }
    }

    /* access modifiers changed from: protected */
    public void tryToPrepare() {
        int duration;
        Log.d(TAG, "tryToPrepare");
        super.tryToPrepare();
        if ((getCurrentState() == FullscreenVideoView_pro.State.PREPARED || getCurrentState() == FullscreenVideoView_pro.State.STARTED) && this.textElapsed != null && this.textTotal != null && (duration = getDuration()) > 0) {
            this.seekBar.setMax(duration);
            this.seekBar.setProgress(0);
            int i = duration / 1000;
            long j = (long) (i % 60);
            long j2 = (long) ((i / 60) % 60);
            long j3 = (long) ((i / 3600) % 24);
            if (j3 > 0) {
                this.textElapsed.setText("00:00:00");
                this.textTotal.setText(String.format(Locale.US, "%d:%02d:%02d", new Object[]{Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)}));
                return;
            }
            this.textElapsed.setText("00:00");
            this.textTotal.setText(String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(j2), Long.valueOf(j)}));
        }
    }

    public void start() throws IllegalStateException {
        Log.d(TAG, "start");
        if (!isPlaying()) {
            super.start();
            if (this.modo_publi) {
                findViewById(R.id.ll_btns).setVisibility(0);
                new config.enviar_sinresp(this.url_imp, (String) null).execute(new String[0]);
            }
            startCounter();
            updateControls();
        }
    }

    public void pause() throws IllegalStateException {
        Log.d(TAG, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        if (isPlaying()) {
            stopCounter();
            super.pause();
            updateControls();
        }
    }

    public void reset() {
        Log.d(TAG, "reset");
        super.reset();
        stopCounter();
        updateControls();
    }

    /* access modifiers changed from: protected */
    public void updateControls() {
        Drawable drawable;
        if (this.imgplay != null) {
            if (getCurrentState() == FullscreenVideoView_pro.State.STARTED) {
                drawable = this.context.getResources().getDrawable(R.drawable.fvl_selector_pause);
            } else {
                drawable = this.context.getResources().getDrawable(R.drawable.fvl_selector_play);
            }
            this.imgplay.setBackgroundDrawable(drawable);
        }
    }

    public void hideControlsStream() {
        View view = this.videoControlsView;
        if (view != null) {
            view.findViewById(R.id.vcv_txt_elapsed).setVisibility(4);
            this.videoControlsView.findViewById(R.id.vcv_txt_total).setVisibility(4);
            this.videoControlsView.findViewById(R.id.vcv_seekbar).setVisibility(4);
        }
    }

    public void hideControls() {
        Log.d(TAG, "hideControls");
        View view = this.videoControlsView;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public void showControls() {
        View view = this.videoControlsView;
        if (view != null) {
            view.bringToFront();
            this.videoControlsView.setVisibility(0);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        if (motionEvent.getAction() == 0 && (view2 = this.videoControlsView) != null) {
            if (view2.getVisibility() == 0) {
                hideControls();
            } else if (this.modo_publi) {
                this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url_click)));
            } else {
                showControls();
            }
        }
        View.OnTouchListener onTouchListener = this.touchListener;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(this, motionEvent);
        }
        return false;
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.vcv_img_play) {
            if (isPlaying()) {
                pause();
            } else {
                start();
            }
        } else if (view.getId() == R.id.vcv_img_download) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.uri_glob.toString());
            String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "video/*";
            try {
                str = URLUtil.guessFileName(this.uri_glob.toString(), (String) null, mimeTypeFromExtension);
            } catch (Exception unused) {
                str = "";
            }
            this.globales.fdescargar(this.uri_glob.toString(), mimeTypeFromExtension, str, this.context);
        } else if (view.getId() != R.id.vcv_img_cast) {
            if (!isFullscreen()) {
                hideControls();
            }
            setFullscreen(!isFullscreen());
        }
    }

    public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
        Log.d(TAG, "onProgressChanged " + i);
    }

    public void onStartTrackingTouch(SeekBar seekBar2) {
        stopCounter();
        Log.d(TAG, "onStartTrackingTouch");
    }

    public void onStopTrackingTouch(SeekBar seekBar2) {
        seekTo(seekBar2.getProgress());
        Log.d(TAG, "onStopTrackingTouch");
    }
}