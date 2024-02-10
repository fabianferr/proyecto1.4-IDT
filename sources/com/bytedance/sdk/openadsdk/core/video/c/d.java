package com.bytedance.sdk.openadsdk.core.video.c;

import com.bykv.vk.openvk.component.video.api.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SupportReplayMediaPlayer */
public class d extends com.bykv.vk.openvk.component.video.a.d.d {
    /* access modifiers changed from: private */
    public final List<b> a = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public int b = 1;
    /* access modifiers changed from: private */
    public int c = 1;
    private final a d;

    /* compiled from: SupportReplayMediaPlayer */
    public interface b extends a.C0034a {
        void a(int i, int i2);
    }

    static /* synthetic */ int a(d dVar) {
        int i = dVar.c;
        dVar.c = i + 1;
        return i;
    }

    public d() {
        a aVar = new a();
        this.d = aVar;
        super.a((a.C0034a) aVar);
        a(500);
    }

    public long p() {
        return super.p() * ((long) this.b);
    }

    public long q() {
        return super.q() + (((long) (this.c - 1)) * super.p());
    }

    public void c(int i) {
        this.b = Math.max(1, i);
    }

    public void a(a.C0034a aVar) {
        if (!(aVar instanceof b)) {
            super.a(aVar);
        } else if (!this.a.contains(aVar)) {
            this.a.add((b) aVar);
        }
    }

    public int t() {
        return this.c;
    }

    /* compiled from: SupportReplayMediaPlayer */
    private class a implements a.C0034a {
        private a() {
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
            d.a(d.this);
            if (d.this.c <= d.this.b) {
                for (b a2 : d.this.a) {
                    a2.a(d.this.c, d.this.b);
                }
                d.this.i();
                return;
            }
            for (b a3 : d.this.a) {
                a3.a(aVar);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j) {
            for (b a2 : d.this.a) {
                a2.a(aVar, j);
            }
        }

        public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
            for (b b : d.this.a) {
                b.b(aVar);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, com.bykv.vk.openvk.component.video.api.c.a aVar2) {
            for (b a2 : d.this.a) {
                a2.a(aVar, aVar2);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
            for (b a2 : d.this.a) {
                a2.a(aVar, z);
            }
        }

        public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
            for (b c : d.this.a) {
                c.c(aVar);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
            for (b a2 : d.this.a) {
                a2.a(aVar, i, i2);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
            for (b a2 : d.this.a) {
                a2.a(aVar, i, i2, i3);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
            for (b a2 : d.this.a) {
                a2.a(aVar, i);
            }
        }

        public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
            for (b b : d.this.a) {
                b.b(aVar, i);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
            for (b a2 : d.this.a) {
                a2.a(aVar, j, j2);
            }
        }

        public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
            for (b d : d.this.a) {
                d.d(aVar);
            }
        }

        public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
            for (b e : d.this.a) {
                e.e(aVar);
            }
        }
    }
}
