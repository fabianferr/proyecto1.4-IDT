package com.iab.omid.library.mmadbridge.adsession;

import android.view.View;
import com.iab.omid.library.mmadbridge.internal.c;
import com.iab.omid.library.mmadbridge.internal.e;
import com.iab.omid.library.mmadbridge.internal.h;
import com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher;
import com.iab.omid.library.mmadbridge.publisher.b;
import com.iab.omid.library.mmadbridge.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a extends AdSession {
    private static final Pattern l = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final AdSessionContext a;
    private final AdSessionConfiguration b;
    private final List<e> c = new ArrayList();
    private com.iab.omid.library.mmadbridge.weakreference.a d;
    private AdSessionStatePublisher e;
    private boolean f = false;
    private boolean g = false;
    private final String h;
    private boolean i;
    private boolean j;
    private PossibleObstructionListener k;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.b = adSessionConfiguration;
        this.a = adSessionContext;
        this.h = UUID.randomUUID().toString();
        d((View) null);
        this.e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.mmadbridge.publisher.a(adSessionContext.getWebView()) : new b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.e.i();
        c.c().a(this);
        this.e.a(adSessionConfiguration);
    }

    private void a() {
        if (this.i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private static void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!l.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private e b(View view) {
        for (e next : this.c) {
            if (next.c().get() == view) {
                return next;
            }
        }
        return null;
    }

    private void b() {
        if (this.j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void c(View view) {
        Collection<a> b2 = c.c().b();
        if (b2 != null && !b2.isEmpty()) {
            for (a next : b2) {
                if (next != this && next.c() == view) {
                    next.d.clear();
                }
            }
        }
    }

    private void d(View view) {
        this.d = new com.iab.omid.library.mmadbridge.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.mmadbridge.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            for (com.iab.omid.library.mmadbridge.weakreference.a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.k.onPossibleObstructionsDetected(this.h, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.j = true;
    }

    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.g) {
            a(view);
            a(str);
            if (b(view) == null) {
                this.c.add(new e(view, friendlyObstructionPurpose, str));
            }
        }
    }

    public View c() {
        return (View) this.d.get();
    }

    public List<e> d() {
        return this.c;
    }

    public boolean e() {
        return this.k != null;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.g) {
            g.a((Object) errorType, "Error type is null");
            g.a(str, "Message is null");
            getAdSessionStatePublisher().a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public boolean f() {
        return this.f && !this.g;
    }

    public void finish() {
        if (!this.g) {
            this.d.clear();
            removeAllFriendlyObstructions();
            this.g = true;
            getAdSessionStatePublisher().f();
            c.c().b(this);
            getAdSessionStatePublisher().b();
            this.e = null;
            this.k = null;
        }
    }

    public boolean g() {
        return this.g;
    }

    public String getAdSessionId() {
        return this.h;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.e;
    }

    public boolean h() {
        return this.b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        a();
        getAdSessionStatePublisher().g();
        this.i = true;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        b();
        getAdSessionStatePublisher().h();
        this.j = true;
    }

    public void registerAdView(View view) {
        if (!this.g) {
            g.a((Object) view, "AdView is null");
            if (c() != view) {
                d(view);
                getAdSessionStatePublisher().a();
                c(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.g) {
            this.c.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.g) {
            a(view);
            e b2 = b(view);
            if (b2 != null) {
                this.c.remove(b2);
            }
        }
    }

    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.k = possibleObstructionListener;
    }

    public void start() {
        if (!this.f) {
            this.f = true;
            c.c().c(this);
            this.e.a(h.c().b());
            this.e.a(com.iab.omid.library.mmadbridge.internal.a.a().b());
            this.e.a(this, this.a);
        }
    }
}
