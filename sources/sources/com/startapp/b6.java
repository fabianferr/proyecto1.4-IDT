package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Sta */
public class b6 {
    public final o a;
    public final l b;
    public final a5 c;
    public final AtomicBoolean d = new AtomicBoolean();
    public final AtomicBoolean e = new AtomicBoolean();

    public b6(WebView webView) {
        o b2 = r.b(webView);
        this.a = b2;
        webView.getContext();
        this.b = r.a(b2);
        this.c = null;
    }

    public void a() {
        o oVar = this.a;
        if (oVar != null) {
            fb fbVar = (fb) oVar;
            if (!fbVar.g) {
                fbVar.d.clear();
                if (!fbVar.g) {
                    fbVar.c.clear();
                }
                fbVar.g = true;
                fc.a.a(fbVar.e.c(), "finishSession", new Object[0]);
                db dbVar = db.c;
                boolean b2 = dbVar.b();
                dbVar.a.remove(fbVar);
                dbVar.b.remove(fbVar);
                if (b2 && !dbVar.b()) {
                    lc a2 = lc.a();
                    a2.getClass();
                    w8 w8Var = w8.h;
                    w8Var.getClass();
                    Handler handler = w8.j;
                    if (handler != null) {
                        handler.removeCallbacks(w8.l);
                        w8.j = null;
                    }
                    w8Var.a.clear();
                    w8.i.post(new x8(w8Var));
                    ob obVar = ob.d;
                    obVar.a = false;
                    obVar.b = false;
                    obVar.c = null;
                    dc dcVar = a2.d;
                    dcVar.a.getContentResolver().unregisterContentObserver(dcVar);
                }
                fbVar.e.b();
                fbVar.e = null;
            }
        }
    }

    public void b() {
        if (this.b != null && this.d.compareAndSet(false, true)) {
            l lVar = this.b;
            gc.b(lVar.a);
            gc.c(lVar.a);
            if (!lVar.a.c()) {
                try {
                    lVar.a.a();
                } catch (Exception unused) {
                }
            }
            if (lVar.a.c()) {
                fb fbVar = lVar.a;
                if (!fbVar.i) {
                    fc.a.a(fbVar.e.c(), "publishImpressionEvent", new Object[0]);
                    fbVar.i = true;
                    return;
                }
                throw new IllegalStateException("Impression event can only be sent once");
            }
        }
    }

    public boolean c() {
        return this.a != null;
    }

    public void d() {
        if (this.b != null && this.e.compareAndSet(false, true)) {
            l lVar = this.b;
            gc.a(lVar.a);
            gc.c(lVar.a);
            fb fbVar = lVar.a;
            if (!fbVar.j) {
                fc.a.a(fbVar.e.c(), "publishLoadedEvent", new Object[0]);
                fbVar.j = true;
                return;
            }
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public void e() {
        o oVar = this.a;
        if (oVar != null) {
            oVar.a();
        }
    }

    public b6(Context context, List<VerificationDetails> list, boolean z) {
        o b2 = r.b(context, list, z);
        this.a = b2;
        this.b = r.a(b2);
        this.c = z ? r.b(b2) : null;
    }

    public void a(View view) {
        o oVar = this.a;
        if (oVar != null) {
            fb fbVar = (fb) oVar;
            if (!fbVar.g) {
                gc.a((Object) view, "AdView is null");
                if (fbVar.b() != view) {
                    fbVar.d = new lb(view);
                    fbVar.e.a();
                    Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(db.c.a);
                    if (unmodifiableCollection != null && !unmodifiableCollection.isEmpty()) {
                        for (T t : unmodifiableCollection) {
                            if (t != fbVar && t.b() == view) {
                                t.d.clear();
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        vb vbVar;
        o oVar = this.a;
        if (oVar != null) {
            fb fbVar = (fb) oVar;
            if (!fbVar.g) {
                if (view != null) {
                    Iterator<vb> it = fbVar.c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            vbVar = null;
                            break;
                        }
                        vbVar = it.next();
                        if (vbVar.a.get() == view) {
                            break;
                        }
                    }
                    if (vbVar == null) {
                        fbVar.c.add(new vb(view, friendlyObstructionPurpose, (String) null));
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("FriendlyObstruction is null");
            }
        }
    }
}
