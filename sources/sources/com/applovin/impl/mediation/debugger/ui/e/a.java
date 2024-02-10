package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.b.a.d;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    /* access modifiers changed from: private */
    public m a;
    private List<d> b;
    private List<d> c;
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.debugger.ui.d.d d;
    /* access modifiers changed from: private */
    public List<c> e;
    /* access modifiers changed from: private */
    public List<c> f;
    private ListView g;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.e.a$a  reason: collision with other inner class name */
    enum C0019a {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public a() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    /* access modifiers changed from: private */
    public d a(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        return (aVar.a() == C0019a.BIDDERS.ordinal() ? this.b : this.c).get(aVar.b());
    }

    private List<c> a(List<d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final d next : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(next.c(), this) {
                public int f() {
                    if (a.this.a.J().c() == null || !a.this.a.J().c().equals(next.a())) {
                        return 0;
                    }
                    return R.drawable.applovin_ic_check_mark_borderless;
                }

                public int g() {
                    if (a.this.a.J().c() == null || !a.this.a.J().c().equals(next.a())) {
                        return super.g();
                    }
                    return -16776961;
                }

                public SpannedString k() {
                    return StringUtils.createSpannedString(next.b(), b() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
                }
            });
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.a;
    }

    public void initialize(List<d> list, List<d> list2, final m mVar) {
        this.a = mVar;
        this.b = list;
        this.c = list2;
        this.e = a(list);
        this.f = a(list2);
        AnonymousClass1 r1 = new com.applovin.impl.mediation.debugger.ui.d.d(this) {
            /* access modifiers changed from: protected */
            public int a(int i) {
                return (i == C0019a.BIDDERS.ordinal() ? a.this.e : a.this.f).size();
            }

            /* access modifiers changed from: protected */
            public int b() {
                return C0019a.COUNT.ordinal();
            }

            /* access modifiers changed from: protected */
            public c b(int i) {
                return i == C0019a.BIDDERS.ordinal() ? new e("BIDDERS") : new e("WATERFALL");
            }

            /* access modifiers changed from: protected */
            public List<c> c(int i) {
                return i == C0019a.BIDDERS.ordinal() ? a.this.e : a.this.f;
            }

            /* access modifiers changed from: protected */
            public c n() {
                return new c.a(c.b.SECTION_CENTERED).a("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
            }
        };
        this.d = r1;
        r1.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                com.applovin.impl.mediation.debugger.b.a.d a2 = a.this.a(aVar);
                if (!StringUtils.isValidString(a2.a()) || !StringUtils.isValidString(mVar.J().c()) || !a2.a().equals(mVar.J().c())) {
                    mVar.J().a(true);
                    mVar.J().a(a2.a());
                    mVar.ag().a(a2.b());
                } else {
                    mVar.J().a(false);
                    mVar.J().a((String) null);
                    mVar.ag().a((String) null);
                }
                a.this.d.notifyDataSetChanged();
            }
        });
        this.d.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.g = listView;
        listView.setAdapter(this.d);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.e = a(this.b);
        this.f = a(this.c);
        this.d.m();
    }
}
