package com.bykv.vk.openvk.component.video.a.d;

import com.bykv.vk.openvk.component.video.a.d.c;

/* compiled from: AbstractMediaPlayer */
public abstract class a implements c {
    protected boolean a = false;
    private c.e b;
    private c.b c;
    private c.a d;
    private c.f e;
    private c.g f;
    private c.C0033c g;
    private c.d h;

    public final void a(c.e eVar) {
        this.b = eVar;
    }

    public final void a(c.b bVar) {
        this.c = bVar;
    }

    public final void a(c.a aVar) {
        this.d = aVar;
    }

    public final void a(c.f fVar) {
        this.e = fVar;
    }

    public final void a(c.C0033c cVar) {
        this.g = cVar;
    }

    public final void a(c.d dVar) {
        this.h = dVar;
    }

    public final void a(c.g gVar) {
        this.f = gVar;
    }

    public void a() {
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            c.e eVar = this.b;
            if (eVar != null) {
                eVar.b(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        try {
            c.b bVar = this.c;
            if (bVar != null) {
                bVar.a(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i) {
        try {
            c.a aVar = this.d;
            if (aVar != null) {
                aVar.a(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        try {
            c.f fVar = this.e;
            if (fVar != null) {
                fVar.c(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i, int i2, int i3, int i4) {
        try {
            c.g gVar = this.f;
            if (gVar != null) {
                gVar.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, int i2) {
        try {
            c.C0033c cVar = this.g;
            return cVar != null && cVar.a(this, i, i2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i, int i2) {
        try {
            c.d dVar = this.h;
            return dVar != null && dVar.b(this, i, i2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    public void a(boolean z) {
        this.a = z;
    }
}
