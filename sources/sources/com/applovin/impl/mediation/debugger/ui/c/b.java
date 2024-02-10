package com.applovin.impl.mediation.debugger.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class b extends d {
    private final com.applovin.impl.mediation.debugger.b.b.b a;
    private List<c> b;
    private final List<c> d;
    private final List<c> e;
    private final List<c> f;
    private final List<c> g;
    private SpannedString h;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    b(com.applovin.impl.mediation.debugger.b.b.b bVar, Context context) {
        super(context);
        this.a = bVar;
        if (bVar.a() == b.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.h = new SpannedString(spannableString);
        } else {
            this.h = new SpannedString("");
        }
        this.b = d();
        this.d = a(bVar.r());
        this.e = a(bVar.t());
        this.f = b(bVar.s());
        this.g = h();
        notifyDataSetChanged();
    }

    private int a(boolean z) {
        return z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }

    private c a(b.C0015b bVar) {
        c.a p = c.p();
        if (bVar == b.C0015b.READY) {
            p.a(this.c);
        }
        return p.a("Test Mode").b(bVar.a()).b(bVar.b()).c("Restart Required").d(bVar.c()).a(true).a();
    }

    private c a(String str, String str2, boolean z, boolean z2) {
        return c.a(z ? c.b.RIGHT_DETAIL : c.b.DETAIL).a(str).b(z ? null : this.h).c("Instructions").d(str2).a(z ? R.drawable.applovin_ic_check_mark_bordered : b(z2)).c(z ? f.a(R.color.applovin_sdk_checkmarkColor, this.c) : d(z2)).a(!z).a();
    }

    private List<c> a(com.applovin.impl.mediation.debugger.b.b.c cVar) {
        ArrayList arrayList = new ArrayList(1);
        if (cVar.a()) {
            arrayList.add(a("Cleartext Traffic", cVar.c(), cVar.b(), false));
        }
        return arrayList;
    }

    private List<c> a(List<com.applovin.impl.mediation.debugger.b.b.d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.b.d next : list) {
                arrayList.add(a(next.a(), next.b(), next.c(), true));
            }
        }
        return arrayList;
    }

    private int b(boolean z) {
        return z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private List<c> b(List<com.applovin.impl.mediation.debugger.b.b.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.b.a next : list) {
                arrayList.add(a(next.a(), next.b(), next.c(), true));
            }
        }
        return arrayList;
    }

    private int c(boolean z) {
        return f.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.c);
    }

    private c c(List<String> list) {
        return c.p().a("Region/VPN Required").b(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private int d(boolean z) {
        return f.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.c);
    }

    private List<c> d() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(e());
        arrayList.add(f());
        arrayList.add(g());
        return arrayList;
    }

    private c e() {
        c.a b2 = c.p().a("SDK").b(this.a.j());
        if (TextUtils.isEmpty(this.a.j())) {
            b2.a(a(this.a.d())).c(c(this.a.d()));
        }
        return b2.a();
    }

    private String e(int i) {
        return (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i) ? "Initialized" : MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i ? "Failure" : MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i ? "Initializing..." : "Not Initialized";
    }

    private c f() {
        c.a b2 = c.p().a("Adapter").b(this.a.k());
        if (TextUtils.isEmpty(this.a.k())) {
            b2.a(a(this.a.e())).c(c(this.a.e()));
        }
        return b2.a();
    }

    private c g() {
        return c.p().a("Initialization Status").b(e(this.a.b())).a(false).a();
    }

    private List<c> h() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.a.v())) {
            arrayList.add(c.a(c.b.DETAIL).a(this.a.v()).a());
        }
        if (this.a.c() == b.C0015b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.a.n() != null) {
            arrayList.add(c(this.a.n()));
        }
        if (this.a.w()) {
            arrayList.add(a("Not an Age Restricted User", "Test mode requires Age Restricted User (COPPA) to be set to false.", !AppLovinPrivacySettings.isAgeRestrictedUser(this.c) && AppLovinPrivacySettings.isAgeRestrictedUserSet(this.c), false));
        }
        arrayList.add(a(this.a.c()));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int a(int i) {
        return (i == a.INTEGRATIONS.ordinal() ? this.b : i == a.PERMISSIONS.ordinal() ? this.d : i == a.CONFIGURATION.ordinal() ? this.e : i == a.DEPENDENCIES.ordinal() ? this.f : this.g).size();
    }

    public com.applovin.impl.mediation.debugger.b.b.b a() {
        return this.a;
    }

    public boolean a(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        return aVar.a() == a.TEST_ADS.ordinal() && aVar.b() == this.g.size() - 1;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return a.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public c b(int i) {
        return i == a.INTEGRATIONS.ordinal() ? new e("INTEGRATIONS") : i == a.PERMISSIONS.ordinal() ? new e("PERMISSIONS") : i == a.CONFIGURATION.ordinal() ? new e("CONFIGURATION") : i == a.DEPENDENCIES.ordinal() ? new e("DEPENDENCIES") : new e("TEST ADS");
    }

    /* access modifiers changed from: protected */
    public List<c> c(int i) {
        return i == a.INTEGRATIONS.ordinal() ? this.b : i == a.PERMISSIONS.ordinal() ? this.d : i == a.CONFIGURATION.ordinal() ? this.e : i == a.DEPENDENCIES.ordinal() ? this.f : this.g;
    }

    public void c() {
        this.b = d();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }
}
