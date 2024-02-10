package com.cellrebel.sdk.youtube.player.playerUtils;

import com.cellrebel.sdk.youtube.player.PlayerConstants;
import com.cellrebel.sdk.youtube.player.YouTubePlayer;
import com.cellrebel.sdk.youtube.player.listeners.AbstractYouTubePlayerListener;

public class PlaybackResumer extends AbstractYouTubePlayerListener {
    private boolean a = false;
    private PlayerConstants.PlayerError b = null;
    private String c;
    private float d;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
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
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.youtube.player.playerUtils.PlaybackResumer.a.<clinit>():void");
        }
    }

    public void a(PlayerConstants.PlayerError playerError) {
        if (playerError == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            this.b = playerError;
        }
    }

    public void a(PlayerConstants.PlayerState playerState) {
        int i = a.a[playerState.ordinal()];
        if (i == 1) {
            this.a = false;
        } else if (i == 2) {
            this.a = false;
        } else if (i == 3) {
            this.a = true;
        }
    }

    public void a(YouTubePlayer youTubePlayer) {
        boolean z = this.a;
        if (z && this.b == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            youTubePlayer.a(this.c, this.d);
        } else if (!z && this.b == PlayerConstants.PlayerError.HTML_5_PLAYER) {
            youTubePlayer.b(this.c, this.d);
        }
        this.b = null;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(float f) {
        this.d = f;
    }
}
