package com.bytedance.sdk.openadsdk.b.d.b;

import com.bykv.vk.openvk.component.video.api.c.c;
import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: VideoLogHelperModel */
public class o {
    private long a;
    private String b;
    private int c;
    private c d;
    private q e;

    public o(long j, String str, int i, c cVar, q qVar) {
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = cVar;
        this.e = qVar;
    }

    public long a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public c d() {
        return this.d;
    }

    public q e() {
        return this.e;
    }

    /* compiled from: VideoLogHelperModel */
    public static class a {
        private long a = 0;
        private long b = 0;
        private long c = 0;
        private boolean d = false;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private boolean j = false;
        private com.bykv.vk.openvk.component.video.api.c.a k;

        public long a() {
            return this.a;
        }

        public void a(long j2) {
            this.a = j2;
            m();
        }

        private void m() {
            long j2 = this.c;
            if (j2 > 0) {
                long j3 = this.a;
                if (j3 > j2) {
                    this.a = j3 % j2;
                }
            }
        }

        public long b() {
            return this.b;
        }

        public void b(long j2) {
            this.b = j2;
        }

        public long c() {
            return this.c;
        }

        public void c(long j2) {
            this.c = j2;
            m();
        }

        public int d() {
            return this.e;
        }

        public void a(int i2) {
            this.e = i2;
        }

        public int e() {
            return this.f;
        }

        public void b(int i2) {
            this.f = i2;
        }

        public int f() {
            long j2 = this.c;
            if (j2 <= 0) {
                return 0;
            }
            return Math.min((int) ((this.a * 100) / j2), 100);
        }

        public int g() {
            return this.g;
        }

        public void c(int i2) {
            this.g = i2;
        }

        public int h() {
            return this.h;
        }

        public int i() {
            return this.i;
        }

        public void d(int i2) {
            this.i = i2;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.d;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public void a(com.bykv.vk.openvk.component.video.api.c.a aVar) {
            this.k = aVar;
        }

        public com.bykv.vk.openvk.component.video.api.c.a l() {
            return this.k;
        }
    }
}
