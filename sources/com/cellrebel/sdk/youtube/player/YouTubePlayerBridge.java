package com.cellrebel.sdk.youtube.player;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.cellrebel.sdk.youtube.player.PlayerConstants;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;

public class YouTubePlayerBridge {
    /* access modifiers changed from: private */
    public final YouTubePlayerBridgeCallbacks a;
    private final Handler b = new Handler(Looper.getMainLooper());

    public interface YouTubePlayerBridgeCallbacks {
        void a();

        Collection<YouTubePlayerListener> d();
    }

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a(this.a);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a();
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ PlayerConstants.PlayerState a;

        c(PlayerConstants.PlayerState playerState) {
            this.a = playerState;
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a(this.a);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ PlayerConstants.PlaybackQuality a;

        d(PlayerConstants.PlaybackQuality playbackQuality) {
            this.a = playbackQuality;
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a(this.a);
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ PlayerConstants.PlaybackRate a;

        e(PlayerConstants.PlaybackRate playbackRate) {
            this.a = playbackRate;
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a(this.a);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ PlayerConstants.PlayerError a;

        f(PlayerConstants.PlayerError playerError) {
            this.a = playerError;
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a(this.a);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            for (YouTubePlayerListener c : YouTubePlayerBridge.this.a.d()) {
                c.c();
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ float a;

        h(float f) {
            this.a = f;
        }

        public void run() {
            for (YouTubePlayerListener b2 : YouTubePlayerBridge.this.a.d()) {
                b2.b(this.a);
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ float a;

        i(float f) {
            this.a = f;
        }

        public void run() {
            for (YouTubePlayerListener a2 : YouTubePlayerBridge.this.a.d()) {
                a2.a(this.a);
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ float a;

        j(float f) {
            this.a = f;
        }

        public void run() {
            for (YouTubePlayerListener c : YouTubePlayerBridge.this.a.d()) {
                c.c(this.a);
            }
        }
    }

    public YouTubePlayerBridge(YouTubePlayerBridgeCallbacks youTubePlayerBridgeCallbacks) {
        this.a = youTubePlayerBridgeCallbacks;
    }

    private PlayerConstants.PlaybackQuality a(String str) {
        return str.equalsIgnoreCase("tiny") ? PlayerConstants.PlaybackQuality.TINY : str.equalsIgnoreCase("small") ? PlayerConstants.PlaybackQuality.SMALL : str.equalsIgnoreCase(FirebaseAnalytics.Param.MEDIUM) ? PlayerConstants.PlaybackQuality.MEDIUM : str.equalsIgnoreCase("large") ? PlayerConstants.PlaybackQuality.LARGE : str.equalsIgnoreCase("hd720") ? PlayerConstants.PlaybackQuality.HD720 : str.equalsIgnoreCase("hd1080") ? PlayerConstants.PlaybackQuality.HD1080 : str.equalsIgnoreCase("hd1440") ? PlayerConstants.PlaybackQuality.HD1440 : str.equalsIgnoreCase("hd2160") ? PlayerConstants.PlaybackQuality.HD2160 : str.equalsIgnoreCase("highres") ? PlayerConstants.PlaybackQuality.HIGH_RES : str.equalsIgnoreCase("default") ? PlayerConstants.PlaybackQuality.DEFAULT : PlayerConstants.PlaybackQuality.UNKNOWN;
    }

    private PlayerConstants.PlaybackRate b(String str) {
        return str.equalsIgnoreCase("0.25") ? PlayerConstants.PlaybackRate.RATE_0_25 : str.equalsIgnoreCase("0.5") ? PlayerConstants.PlaybackRate.RATE_0_5 : str.equalsIgnoreCase("1") ? PlayerConstants.PlaybackRate.RATE_1 : str.equalsIgnoreCase("1.5") ? PlayerConstants.PlaybackRate.RATE_1_5 : str.equalsIgnoreCase("2") ? PlayerConstants.PlaybackRate.RATE_2 : PlayerConstants.PlaybackRate.UNKNOWN;
    }

    private PlayerConstants.PlayerError c(String str) {
        return str.equalsIgnoreCase("2") ? PlayerConstants.PlayerError.INVALID_PARAMETER_IN_REQUEST : str.equalsIgnoreCase(CampaignEx.CLICKMODE_ON) ? PlayerConstants.PlayerError.HTML_5_PLAYER : str.equalsIgnoreCase(StatisticData.ERROR_CODE_NOT_FOUND) ? PlayerConstants.PlayerError.VIDEO_NOT_FOUND : (!str.equalsIgnoreCase(StatisticData.ERROR_CODE_IO_ERROR) && !str.equalsIgnoreCase("150")) ? PlayerConstants.PlayerError.UNKNOWN : PlayerConstants.PlayerError.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
    }

    private PlayerConstants.PlayerState d(String str) {
        return str.equalsIgnoreCase("UNSTARTED") ? PlayerConstants.PlayerState.UNSTARTED : str.equalsIgnoreCase("ENDED") ? PlayerConstants.PlayerState.ENDED : str.equalsIgnoreCase("PLAYING") ? PlayerConstants.PlayerState.PLAYING : str.equalsIgnoreCase("PAUSED") ? PlayerConstants.PlayerState.PAUSED : str.equalsIgnoreCase("BUFFERING") ? PlayerConstants.PlayerState.BUFFERING : str.equalsIgnoreCase("CUED") ? PlayerConstants.PlayerState.VIDEO_CUED : PlayerConstants.PlayerState.UNKNOWN;
    }

    @JavascriptInterface
    public void sendApiChange() {
        this.b.post(new g());
    }

    @JavascriptInterface
    public void sendError(String str) {
        this.b.post(new f(c(str)));
    }

    @JavascriptInterface
    public void sendPlaybackQualityChange(String str) {
        this.b.post(new d(a(str)));
    }

    @JavascriptInterface
    public void sendPlaybackRateChange(String str) {
        this.b.post(new e(b(str)));
    }

    @JavascriptInterface
    public void sendReady() {
        this.b.post(new b());
    }

    @JavascriptInterface
    public void sendStateChange(String str) {
        this.b.post(new c(d(str)));
    }

    @JavascriptInterface
    public void sendVideoCurrentTime(String str) {
        try {
            this.b.post(new h(Float.parseFloat(str)));
        } catch (NumberFormatException unused) {
        }
    }

    @JavascriptInterface
    public void sendVideoDuration(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.b.post(new i(Float.parseFloat(str)));
        } catch (NumberFormatException unused) {
        }
    }

    @JavascriptInterface
    public void sendVideoId(String str) {
        this.b.post(new a(str));
    }

    @JavascriptInterface
    public void sendVideoLoadedFraction(String str) {
        try {
            this.b.post(new j(Float.parseFloat(str)));
        } catch (NumberFormatException unused) {
        }
    }

    @JavascriptInterface
    public void sendYouTubeIframeAPIReady() {
        this.a.a();
    }
}
