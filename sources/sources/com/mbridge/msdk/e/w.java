package com.mbridge.msdk.e;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* compiled from: TrackConfig */
public final class w {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final o g;
    public final d h;
    public final v i;
    public final f j;

    private w(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.d;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    /* compiled from: TrackConfig */
    public static final class a {
        /* access modifiers changed from: private */
        public int a = 50;
        /* access modifiers changed from: private */
        public int b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        /* access modifiers changed from: private */
        public int c = 0;
        /* access modifiers changed from: private */
        public o d;
        /* access modifiers changed from: private */
        public int e = 2;
        /* access modifiers changed from: private */
        public int f = 50;
        /* access modifiers changed from: private */
        public int g = 604800000;
        /* access modifiers changed from: private */
        public d h;
        /* access modifiers changed from: private */
        public v i;
        /* access modifiers changed from: private */
        public f j;

        public final a a(int i2) {
            if (i2 <= 0) {
                this.a = 50;
            } else {
                this.a = i2;
            }
            return this;
        }

        public final a b(int i2) {
            if (i2 < 0) {
                this.b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
            } else {
                this.b = i2;
            }
            return this;
        }

        public final a a(int i2, o oVar) {
            this.c = i2;
            this.d = oVar;
            return this;
        }

        public final a c(int i2) {
            if (i2 <= 0) {
                this.e = 2;
            } else {
                this.e = i2;
            }
            return this;
        }

        public final a d(int i2) {
            if (i2 < 0) {
                this.f = 50;
            } else {
                this.f = i2;
            }
            return this;
        }

        public final a e(int i2) {
            if (i2 < 0) {
                this.g = 604800000;
            } else {
                this.g = i2;
            }
            return this;
        }

        public final a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public final a a(v vVar) {
            this.i = vVar;
            return this;
        }

        public final a a(f fVar) {
            this.j = fVar;
            return this;
        }

        public final w a() {
            if (y.a((Object) this.h) && a.a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.a((Object) this.i) && a.a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.a((Object) this.d) || y.a((Object) this.d.c())) && a.a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new w(this);
        }
    }
}
