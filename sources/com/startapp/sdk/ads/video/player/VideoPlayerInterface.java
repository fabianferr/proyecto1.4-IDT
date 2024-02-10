package com.startapp.sdk.ads.video.player;

/* compiled from: Sta */
public interface VideoPlayerInterface {

    /* compiled from: Sta */
    public enum VideoPlayerErrorType {
        UNKNOWN,
        SERVER_DIED,
        BUFFERING_TIMEOUT
    }

    /* compiled from: Sta */
    public interface a {
    }

    /* compiled from: Sta */
    public interface b {
    }

    /* compiled from: Sta */
    public interface c {
    }

    /* compiled from: Sta */
    public interface d {
    }

    /* compiled from: Sta */
    public interface e {
    }

    /* compiled from: Sta */
    public static class f {
        public VideoPlayerErrorType a;
        public String b;
        public int c;

        public f(VideoPlayerErrorType videoPlayerErrorType, String str, int i) {
            this.a = videoPlayerErrorType;
            this.b = str;
            this.c = i;
        }
    }
}
