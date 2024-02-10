package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.startapp.hb;
import com.startapp.ib;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class w8 implements ib.a {
    public static w8 h = new w8();
    public static Handler i = new Handler(Looper.getMainLooper());
    public static Handler j = null;
    public static final Runnable k = new c();
    public static final Runnable l = new d();
    public List<b> a = new ArrayList();
    public int b;
    public final List<lb> c = new ArrayList();
    public qb d = new qb();
    public hb e = new hb();
    public jb f = new jb(new yb());
    public long g;

    /* compiled from: Sta */
    public interface a extends b {
        void b(int i, long j);
    }

    /* compiled from: Sta */
    public interface b {
        void a(int i, long j);
    }

    /* compiled from: Sta */
    public class c implements Runnable {
        public void run() {
            String str;
            Boolean bool;
            w8 w8Var = w8.h;
            w8Var.b = 0;
            w8Var.c.clear();
            for (T t : Collections.unmodifiableCollection(db.c.b)) {
                t.getClass();
            }
            w8Var.g = System.nanoTime();
            hb hbVar = w8Var.e;
            hbVar.getClass();
            db dbVar = db.c;
            if (dbVar != null) {
                for (T t2 : Collections.unmodifiableCollection(dbVar.b)) {
                    View b = t2.b();
                    if (t2.c()) {
                        String str2 = t2.h;
                        if (b != null) {
                            if (!b.isAttachedToWindow()) {
                                str = "notAttached";
                            } else {
                                if (b.hasWindowFocus()) {
                                    hbVar.h.remove(b);
                                    bool = Boolean.FALSE;
                                } else if (hbVar.h.containsKey(b)) {
                                    bool = hbVar.h.get(b);
                                } else {
                                    Map<View, Boolean> map = hbVar.h;
                                    Boolean bool2 = Boolean.FALSE;
                                    map.put(b, bool2);
                                    bool = bool2;
                                }
                                if (bool.booleanValue()) {
                                    str = "noWindowFocus";
                                } else {
                                    HashSet hashSet = new HashSet();
                                    View view = b;
                                    while (true) {
                                        if (view == null) {
                                            hbVar.d.addAll(hashSet);
                                            str = null;
                                            break;
                                        }
                                        String a = jc.a(view);
                                        if (a != null) {
                                            str = a;
                                            break;
                                        }
                                        hashSet.add(view);
                                        ViewParent parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            }
                            if (str == null) {
                                hbVar.e.add(str2);
                                hbVar.a.put(b, str2);
                                for (vb next : t2.c) {
                                    View view2 = (View) next.a.get();
                                    if (view2 != null) {
                                        hb.a aVar = hbVar.b.get(view2);
                                        if (aVar != null) {
                                            aVar.b.add(t2.h);
                                        } else {
                                            hbVar.b.put(view2, new hb.a(next, t2.h));
                                        }
                                    }
                                }
                            } else if (str != "noWindowFocus") {
                                hbVar.f.add(str2);
                                hbVar.c.put(str2, b);
                                hbVar.g.put(str2, str);
                            }
                        } else {
                            hbVar.f.add(str2);
                            hbVar.g.put(str2, "noAdView");
                        }
                    }
                }
            }
            long nanoTime = System.nanoTime();
            wb wbVar = w8Var.d.b;
            if (w8Var.e.f.size() > 0) {
                Iterator<String> it = w8Var.e.f.iterator();
                while (it.hasNext()) {
                    String next2 = it.next();
                    JSONObject a2 = wbVar.a((View) null);
                    View view3 = w8Var.e.c.get(next2);
                    bc bcVar = w8Var.d.a;
                    String str3 = w8Var.e.g.get(next2);
                    if (str3 != null) {
                        JSONObject a3 = bcVar.a(view3);
                        WindowManager windowManager = rb.a;
                        try {
                            a3.put("adSessionId", next2);
                        } catch (JSONException e) {
                            Log.e("OMIDLIB", "Error with setting ad session id", e);
                        }
                        try {
                            a3.put("notVisibleReason", str3);
                        } catch (JSONException e2) {
                            Log.e("OMIDLIB", "Error with setting not visible reason", e2);
                        }
                        rb.a(a2, a3);
                    }
                    rb.a(a2);
                    HashSet hashSet2 = new HashSet();
                    hashSet2.add(next2);
                    jb jbVar = w8Var.f;
                    jbVar.b.a(new hc(jbVar, hashSet2, a2, nanoTime));
                }
            }
            if (w8Var.e.e.size() > 0) {
                JSONObject a4 = wbVar.a((View) null);
                wbVar.a((View) null, a4, w8Var, true, false);
                rb.a(a4);
                jb jbVar2 = w8Var.f;
                jbVar2.b.a(new kc(jbVar2, w8Var.e.e, a4, nanoTime));
            } else {
                jb jbVar3 = w8Var.f;
                jbVar3.b.a(new cc(jbVar3));
            }
            hb hbVar2 = w8Var.e;
            hbVar2.a.clear();
            hbVar2.b.clear();
            hbVar2.c.clear();
            hbVar2.d.clear();
            hbVar2.e.clear();
            hbVar2.f.clear();
            hbVar2.g.clear();
            hbVar2.i = false;
            long nanoTime2 = System.nanoTime() - w8Var.g;
            if (w8Var.a.size() > 0) {
                for (b next3 : w8Var.a) {
                    next3.a(w8Var.b, TimeUnit.NANOSECONDS.toMillis(nanoTime2));
                    if (next3 instanceof a) {
                        ((a) next3).b(w8Var.b, nanoTime2);
                    }
                }
            }
        }
    }

    /* compiled from: Sta */
    public class d implements Runnable {
        public void run() {
            Handler handler = w8.j;
            if (handler != null) {
                handler.post(w8.k);
                w8.j.postDelayed(w8.l, 200);
            }
        }
    }

    public final void a(View view, ib ibVar, JSONObject jSONObject, com.iab.omid.library.startio.walking.b bVar, boolean z) {
        ibVar.a(view, jSONObject, this, bVar == com.iab.omid.library.startio.walking.b.PARENT_VIEW, z);
    }

    public void a(View view, ib ibVar, JSONObject jSONObject, boolean z) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        if (jc.a(view) == null) {
            hb hbVar = this.e;
            com.iab.omid.library.startio.walking.b bVar = hbVar.d.contains(view) ? com.iab.omid.library.startio.walking.b.PARENT_VIEW : hbVar.i ? com.iab.omid.library.startio.walking.b.OBSTRUCTION_VIEW : com.iab.omid.library.startio.walking.b.UNDERLYING_VIEW;
            if (bVar != com.iab.omid.library.startio.walking.b.UNDERLYING_VIEW) {
                JSONObject a2 = ibVar.a(view);
                rb.a(jSONObject, a2);
                hb hbVar2 = this.e;
                if (hbVar2.a.size() == 0) {
                    str = null;
                } else {
                    String str2 = hbVar2.a.get(view);
                    if (str2 != null) {
                        hbVar2.a.remove(view);
                    }
                    str = str2;
                }
                if (str != null) {
                    WindowManager windowManager = rb.a;
                    try {
                        a2.put("adSessionId", str);
                    } catch (JSONException e2) {
                        Log.e("OMIDLIB", "Error with setting ad session id", e2);
                    }
                    hb hbVar3 = this.e;
                    if (hbVar3.h.containsKey(view)) {
                        hbVar3.h.put(view, Boolean.TRUE);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    try {
                        a2.put("hasWindowFocus", Boolean.valueOf(z4));
                    } catch (JSONException e3) {
                        Log.e("OMIDLIB", "Error with setting not visible reason", e3);
                    }
                    this.e.i = true;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    hb hbVar4 = this.e;
                    hb.a aVar = hbVar4.b.get(view);
                    if (aVar != null) {
                        hbVar4.b.remove(view);
                    }
                    if (aVar != null) {
                        WindowManager windowManager2 = rb.a;
                        vb vbVar = aVar.a;
                        JSONArray jSONArray = new JSONArray();
                        for (String put : aVar.b) {
                            jSONArray.put(put);
                        }
                        try {
                            a2.put("isFriendlyObstructionFor", jSONArray);
                            a2.put("friendlyObstructionClass", vbVar.b);
                            a2.put("friendlyObstructionPurpose", vbVar.c);
                            a2.put("friendlyObstructionReason", vbVar.d);
                        } catch (JSONException e4) {
                            Log.e("OMIDLIB", "Error with setting friendly obstruction", e4);
                        }
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    a(view, ibVar, a2, bVar, z || z3);
                }
                this.b++;
            }
        }
    }

    public void a() {
        if (j == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            j = handler;
            handler.post(k);
            j.postDelayed(l, 200);
        }
    }
}
