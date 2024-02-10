package com.startapp.sdk.ads.video.player;

import android.media.MediaPlayer;
import android.os.Build;
import android.widget.VideoView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.startapp.a5;
import com.startapp.b6;
import com.startapp.fc;
import com.startapp.gc;
import com.startapp.i3;
import com.startapp.na;
import com.startapp.oa;
import com.startapp.pa;
import com.startapp.qa;
import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.ads.video.d;
import com.startapp.sdk.ads.video.i;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.ads.video.tracking.VideoPausedTrackingParams;
import org.json.JSONObject;

/* compiled from: Sta */
public class NativeVideoPlayer extends a implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener {
    public MediaPlayer g;
    public final VideoView h;

    /* compiled from: Sta */
    public enum MediaErrorExtra {
        MEDIA_ERROR_IO,
        MEDIA_ERROR_MALFORMED,
        MEDIA_ERROR_UNSUPPORTED,
        MEDIA_ERROR_TIMED_OUT
    }

    /* compiled from: Sta */
    public enum MediaErrorType {
        MEDIA_ERROR_UNKNOWN,
        MEDIA_ERROR_SERVER_DIED
    }

    /* compiled from: Sta */
    public class a implements MediaPlayer.OnBufferingUpdateListener {
        public a() {
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            VideoPlayerInterface.a aVar = NativeVideoPlayer.this.f;
            if (aVar != null) {
                ((pa) aVar).a(i);
            }
        }
    }

    public NativeVideoPlayer(VideoView videoView) {
        this.h = videoView;
        videoView.setOnPreparedListener(this);
        videoView.setOnCompletionListener(this);
        videoView.setOnErrorListener(this);
    }

    public void a(String str) {
        this.a = str;
        if (str != null) {
            try {
                this.h.setVideoPath(str);
            } catch (Throwable th) {
                i3.a(th);
                onError(this.g, 1, 0);
            }
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        VideoPlayerInterface.b bVar = this.d;
        if (bVar != null) {
            ((i) bVar).a();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaErrorType mediaErrorType;
        VideoPlayerInterface.VideoPlayerErrorType videoPlayerErrorType;
        MediaErrorExtra mediaErrorExtra;
        if (this.c == null) {
            return false;
        }
        int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
        VideoPlayerInterface.c cVar = this.c;
        if (i == 100) {
            mediaErrorType = MediaErrorType.MEDIA_ERROR_SERVER_DIED;
        } else {
            mediaErrorType = MediaErrorType.MEDIA_ERROR_UNKNOWN;
        }
        if (mediaErrorType == MediaErrorType.MEDIA_ERROR_SERVER_DIED) {
            videoPlayerErrorType = VideoPlayerInterface.VideoPlayerErrorType.SERVER_DIED;
        } else {
            videoPlayerErrorType = VideoPlayerInterface.VideoPlayerErrorType.UNKNOWN;
        }
        if (i2 == -1010) {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_UNSUPPORTED;
        } else if (i2 == -1007) {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_MALFORMED;
        } else if (i2 != -110) {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_IO;
        } else {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_TIMED_OUT;
        }
        String str = mediaErrorExtra.toString();
        VideoPlayerInterface.f fVar = new VideoPlayerInterface.f(videoPlayerErrorType, str, currentPosition);
        qa qaVar = (qa) cVar;
        VideoMode videoMode = qaVar.a;
        if (videoMode.K != null) {
            if (!videoMode.X || videoMode.a0 > videoMode.b0 || currentPosition <= 0 || !str.equals("MEDIA_ERROR_IO")) {
                qaVar.a.a(fVar);
            } else {
                VideoMode videoMode2 = qaVar.a;
                videoMode2.a0++;
                videoMode2.L();
                VideoMode videoMode3 = qaVar.a;
                ((NativeVideoPlayer) videoMode3.K).a(videoMode3.A().c());
                ((NativeVideoPlayer) qaVar.a.K).a(fVar.c);
            }
        }
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        a5 a5Var;
        this.g = mediaPlayer;
        mediaPlayer.setOnSeekCompleteListener(this);
        VideoPlayerInterface.d dVar = this.b;
        if (dVar != null) {
            oa oaVar = (oa) dVar;
            VideoMode videoMode = oaVar.a;
            int i = videoMode.e0;
            if (i > 0) {
                VideoPlayerInterface videoPlayerInterface = videoMode.K;
                if (videoPlayerInterface != null) {
                    ((NativeVideoPlayer) videoPlayerInterface).a(i);
                }
                VideoMode videoMode2 = oaVar.a;
                VideoPausedTrackingParams.PauseOrigin pauseOrigin = VideoPausedTrackingParams.PauseOrigin.EXTERNAL;
                b6 b6Var = videoMode2.G;
                if (!(b6Var == null || (a5Var = b6Var.c) == null)) {
                    gc.a(a5Var.a);
                    fc.a.a(a5Var.a.e.c(), CampaignEx.JSON_NATIVE_VIDEO_RESUME, (JSONObject) null);
                }
                videoMode2.a(videoMode2.A().i().n(), new VideoPausedTrackingParams(videoMode2.p, videoMode2.b(videoMode2.e0), videoMode2.D, videoMode2.T, pauseOrigin, videoMode2.g0), videoMode2.e0, "resumed");
                videoMode2.T++;
            } else if (videoMode.E()) {
                oaVar.a.M();
            }
        }
        if (com.startapp.sdk.adsbase.a.c(this.a) && (mediaPlayer2 = this.g) != null) {
            mediaPlayer2.setOnBufferingUpdateListener(new a());
        } else if (!com.startapp.sdk.adsbase.a.c(this.a)) {
            d.b.a.b = this.f;
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        VideoPlayerInterface.e eVar = this.e;
        if (eVar != null) {
            ((na) eVar).a.M();
        }
    }

    public void a(int i) {
        try {
            MediaPlayer mediaPlayer = this.g;
            if (mediaPlayer == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo((long) i, 3);
            } else {
                mediaPlayer.seekTo(i);
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public boolean a() {
        return this.g != null;
    }
}
