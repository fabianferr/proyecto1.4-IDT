package com.ironsource.a;

import android.util.Pair;
import java.util.ArrayList;

public final class a {
    String a;
    public boolean b;
    String c;
    d d;
    boolean e = false;
    ArrayList<Pair<String, String>> f;

    /* renamed from: com.ironsource.a.a$a  reason: collision with other inner class name */
    public static class C0102a {
        String a = "";
        public boolean b = false;
        public String c = "POST";
        public d d;
        public boolean e = false;
        public ArrayList<Pair<String, String>> f = new ArrayList<>();

        public C0102a(String str) {
            if (str != null && !str.isEmpty()) {
                this.a = str;
            }
        }
    }

    public a(C0102a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        if (aVar.f != null) {
            this.f = new ArrayList<>(aVar.f);
        }
    }
}
