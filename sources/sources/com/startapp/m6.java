package com.startapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.startapp.sdk.adsbase.e;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashSet;
import java.util.List;

/* compiled from: Sta */
public class m6 implements CookieStore {
    public final CookieStore a = new CookieManager().getCookieStore();
    public final SharedPreferences b;

    public m6(Context context) {
        HttpCookie httpCookie;
        e eVar = new e(context.getSharedPreferences("com.startapp.android.publish.CookiePrefsFile", 0));
        this.b = eVar;
        String string = eVar.getString("names", (String) null);
        if (string != null) {
            for (String str : TextUtils.split(string, ";")) {
                SharedPreferences sharedPreferences = this.b;
                String string2 = sharedPreferences.getString("cookie_" + str, (String) null);
                if (!(string2 == null || (httpCookie = (HttpCookie) g4.a(string2, HttpCookie.class)) == null)) {
                    if (httpCookie.hasExpired()) {
                        b(httpCookie);
                        a();
                    } else if (httpCookie.getDomain() != null) {
                        this.a.add(URI.create(httpCookie.getDomain()), httpCookie);
                    }
                }
            }
        }
    }

    public final void a() {
        SharedPreferences.Editor edit = this.b.edit();
        HashSet hashSet = new HashSet();
        for (HttpCookie a2 : this.a.getCookies()) {
            hashSet.add(a(a2));
        }
        edit.putString("names", TextUtils.join(";", hashSet));
        edit.apply();
    }

    public void add(URI uri, HttpCookie httpCookie) {
        String a2 = a(httpCookie);
        this.a.add(uri, httpCookie);
        SharedPreferences.Editor edit = this.b.edit();
        edit.putString("cookie_" + a2, String.valueOf(g4.b(httpCookie)));
        edit.apply();
        a();
    }

    public final void b(HttpCookie httpCookie) {
        SharedPreferences.Editor edit = this.b.edit();
        StringBuilder a2 = p0.a("cookie_");
        a2.append(a(httpCookie));
        edit.remove(a2.toString());
        edit.apply();
    }

    public List<HttpCookie> get(URI uri) {
        return this.a.get(uri);
    }

    public List<HttpCookie> getCookies() {
        return this.a.getCookies();
    }

    public List<URI> getURIs() {
        return this.a.getURIs();
    }

    public boolean remove(URI uri, HttpCookie httpCookie) {
        if (!this.a.remove(uri, httpCookie)) {
            return false;
        }
        b(httpCookie);
        a();
        return true;
    }

    public boolean removeAll() {
        if (!this.a.removeAll()) {
            return false;
        }
        SharedPreferences.Editor edit = this.b.edit();
        edit.clear();
        edit.apply();
        a();
        return true;
    }

    public final String a(HttpCookie httpCookie) {
        return httpCookie.getDomain() + "_" + httpCookie.getName();
    }
}
