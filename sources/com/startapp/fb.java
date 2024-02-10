package com.startapp;

import android.provider.Settings;
import android.view.View;
import com.iab.omid.library.startio.adsession.AdSessionContextType;
import com.iab.omid.library.startio.adsession.Owner;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: Sta */
public class fb extends o {
    public static final Pattern k = Pattern.compile("^[a-zA-Z0-9 ]+$");
    public final q a;
    public final p b;
    public final List<vb> c = new ArrayList();
    public lb d;
    public AdSessionStatePublisher e;
    public boolean f = false;
    public boolean g = false;
    public final String h;
    public boolean i;
    public boolean j;

    public fb(p pVar, q qVar) {
        this.b = pVar;
        this.a = qVar;
        this.h = UUID.randomUUID().toString();
        a((View) null);
        this.e = (qVar.a() == AdSessionContextType.HTML || qVar.a() == AdSessionContextType.JAVASCRIPT) ? new gb(qVar.d()) : new nb(qVar.b(), qVar.c());
        this.e.d();
        db.a().a(this);
        this.e.a(pVar);
    }

    public void a() {
        if (!this.f) {
            this.f = true;
            db dbVar = db.c;
            boolean b2 = dbVar.b();
            dbVar.b.add(this);
            if (!b2) {
                lc a2 = lc.a();
                a2.getClass();
                ob obVar = ob.d;
                obVar.c = a2;
                obVar.a = true;
                obVar.b = false;
                obVar.a();
                w8.h.a();
                dc dcVar = a2.d;
                dcVar.e = dcVar.a();
                dcVar.b();
                dcVar.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, dcVar);
            }
            float f2 = lc.a().a;
            AdSessionStatePublisher adSessionStatePublisher = this.e;
            fc.a.a(adSessionStatePublisher.c(), "setDeviceVolume", Float.valueOf(f2));
            this.e.a(this, this.a);
        }
    }

    public final void a(View view) {
        this.d = new lb((View) null);
    }

    public View b() {
        return (View) this.d.get();
    }

    public boolean c() {
        return this.f && !this.g;
    }

    public boolean d() {
        return Owner.NATIVE == this.b.a;
    }

    public boolean e() {
        return Owner.NATIVE == this.b.b;
    }
}
