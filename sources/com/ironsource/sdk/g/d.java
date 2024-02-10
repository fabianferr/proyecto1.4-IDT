package com.ironsource.sdk.g;

public class d {
    private int a;
    private int b;
    private int c;
    private boolean d;

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public enum b {
        None,
        Loading,
        Loaded,
        Ready,
        e
    }

    public enum c {
        Web,
        Native,
        None
    }

    /* renamed from: com.ironsource.sdk.g.d$d  reason: collision with other inner class name */
    public enum C0121d {
        MODE_0(0),
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);
        
        public int d;

        private C0121d(int i) {
            this.d = i;
        }
    }

    public enum e {
        a,
        OfferWall,
        c,
        OfferWallCredits,
        RewardedVideo,
        NativeAd,
        None
    }

    public d() {
    }

    public d(int i, int i2, int i3, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }
}
