package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.R;

public class c {
    protected b b;
    protected boolean c;
    protected SpannedString d;
    protected SpannedString e;
    protected String f;
    protected String g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected boolean n;

    public static class a {
        final b a;
        boolean b;
        SpannedString c;
        SpannedString d;
        String e;
        String f;
        int g = 0;
        int h = 0;
        int i = ViewCompat.MEASURED_STATE_MASK;
        int j = ViewCompat.MEASURED_STATE_MASK;
        int k = 0;
        int l = 0;
        boolean m;

        public a(b bVar) {
            this.a = bVar;
        }

        public a a(int i2) {
            this.h = i2;
            return this;
        }

        public a a(Context context) {
            this.h = R.drawable.applovin_ic_disclosure_arrow;
            this.l = f.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public a a(SpannedString spannedString) {
            this.c = spannedString;
            return this;
        }

        public a a(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(int i2) {
            this.j = i2;
            return this;
        }

        public a b(SpannedString spannedString) {
            this.d = spannedString;
            return this;
        }

        public a b(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a b(boolean z) {
            this.m = z;
            return this;
        }

        public a c(int i2) {
            this.l = i2;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }
    }

    public enum b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);
        
        private final int g;

        private b(int i) {
            this.g = i;
        }

        public int a() {
            return this.g;
        }

        public int b() {
            if (this == SECTION) {
                return R.layout.mediation_debugger_list_section;
            }
            if (this == SECTION_CENTERED) {
                return R.layout.mediation_debugger_list_section_centered;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? R.layout.mediation_debugger_list_item_detail : R.layout.mediation_debugger_list_item_right_detail;
        }
    }

    private c(a aVar) {
        this.h = 0;
        this.i = 0;
        this.j = ViewCompat.MEASURED_STATE_MASK;
        this.k = ViewCompat.MEASURED_STATE_MASK;
        this.l = 0;
        this.m = 0;
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
        this.n = aVar.m;
    }

    protected c(b bVar) {
        this.h = 0;
        this.i = 0;
        this.j = ViewCompat.MEASURED_STATE_MASK;
        this.k = ViewCompat.MEASURED_STATE_MASK;
        this.l = 0;
        this.m = 0;
        this.b = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public static int h() {
        return b.COUNT.a();
    }

    public static a p() {
        return a(b.RIGHT_DETAIL);
    }

    public boolean b() {
        return this.c;
    }

    public int c() {
        return this.k;
    }

    public SpannedString c_() {
        return this.e;
    }

    public boolean d_() {
        return this.n;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.m;
    }

    public int i() {
        return this.b.a();
    }

    public int j() {
        return this.b.b();
    }

    public SpannedString k() {
        return this.d;
    }

    public String l() {
        return this.f;
    }

    public String m() {
        return this.g;
    }

    public int n() {
        return this.j;
    }

    public int o() {
        return this.l;
    }
}
