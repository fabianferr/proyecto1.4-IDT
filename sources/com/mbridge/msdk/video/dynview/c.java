package com.mbridge.msdk.video.dynview;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* compiled from: ViewOption */
public final class c {
    private Context a;
    private String b;
    private int c;
    private float d;
    private float e;
    private int f;
    private int g;
    private View h;
    private List<CampaignEx> i;
    private int j;
    private boolean k;
    private List<String> l;
    private int m;
    private String n;

    /* compiled from: ViewOption */
    public interface b {
        b a(float f);

        b a(int i);

        b a(Context context);

        b a(View view);

        b a(String str);

        b a(List<CampaignEx> list);

        b a(boolean z);

        c a();

        b b(float f);

        b b(int i);

        b b(String str);

        b b(List<String> list);

        b c(int i);

        b d(int i);

        b e(int i);
    }

    public final Context a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final float c() {
        return this.d;
    }

    public final float d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final View f() {
        return this.h;
    }

    public final List<CampaignEx> g() {
        return this.i;
    }

    public final int h() {
        return this.c;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.g;
    }

    public final boolean k() {
        return this.k;
    }

    public final List<String> l() {
        return this.l;
    }

    private c(a aVar) {
        this.e = aVar.e;
        this.d = aVar.d;
        this.f = aVar.f;
        this.g = aVar.g;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
    }

    /* compiled from: ViewOption */
    public static class a implements b {
        /* access modifiers changed from: private */
        public Context a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public int c;
        /* access modifiers changed from: private */
        public float d;
        /* access modifiers changed from: private */
        public float e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public View h;
        /* access modifiers changed from: private */
        public List<CampaignEx> i;
        /* access modifiers changed from: private */
        public int j;
        /* access modifiers changed from: private */
        public boolean k;
        /* access modifiers changed from: private */
        public List<String> l;
        /* access modifiers changed from: private */
        public int m;
        /* access modifiers changed from: private */
        public String n;

        public final b a(Context context) {
            this.a = context.getApplicationContext();
            return this;
        }

        public final b a(String str) {
            this.b = str;
            return this;
        }

        public final b a(int i2) {
            this.c = i2;
            return this;
        }

        public final b a(float f2) {
            this.d = f2;
            return this;
        }

        public final b b(float f2) {
            this.e = f2;
            return this;
        }

        public final b b(int i2) {
            this.f = i2;
            return this;
        }

        public final b c(int i2) {
            this.g = i2;
            return this;
        }

        public final b a(View view) {
            this.h = view;
            return this;
        }

        public final b a(List<CampaignEx> list) {
            this.i = list;
            return this;
        }

        public final b d(int i2) {
            this.j = i2;
            return this;
        }

        public final b a(boolean z) {
            this.k = z;
            return this;
        }

        public final b b(List<String> list) {
            this.l = list;
            return this;
        }

        public final b e(int i2) {
            this.m = i2;
            return this;
        }

        public final b b(String str) {
            this.n = str;
            return this;
        }

        public final c a() {
            return new c(this);
        }
    }
}
