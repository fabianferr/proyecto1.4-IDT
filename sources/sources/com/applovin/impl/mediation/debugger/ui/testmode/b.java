package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class b extends a {
    /* access modifiers changed from: private */
    public m a;
    private List<com.applovin.impl.mediation.debugger.b.b.b> b;
    /* access modifiers changed from: private */
    public d c;
    /* access modifiers changed from: private */
    public List<c> d;
    private ListView e;

    public b() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    private List<c> a(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final com.applovin.impl.mediation.debugger.b.b.b next : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(this, next) {
                public int f() {
                    if (b.this.a.J().c() == null || !b.this.a.J().c().equals(next.h())) {
                        return 0;
                    }
                    return R.drawable.applovin_ic_check_mark_borderless;
                }

                public int g() {
                    if (b.this.a.J().c() == null || !b.this.a.J().c().equals(next.h())) {
                        return super.g();
                    }
                    return -16776961;
                }

                public SpannedString k() {
                    return StringUtils.createSpannedString(next.i(), b() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
                }
            });
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.a;
    }

    public void initialize(final List<com.applovin.impl.mediation.debugger.b.b.b> list, final m mVar) {
        this.a = mVar;
        this.b = list;
        this.d = a(list);
        AnonymousClass1 r0 = new d(this) {
            /* access modifiers changed from: protected */
            public int a(int i) {
                return list.size();
            }

            /* access modifiers changed from: protected */
            public int b() {
                return 1;
            }

            /* access modifiers changed from: protected */
            public c b(int i) {
                return new e("TEST MODE NETWORKS");
            }

            /* access modifiers changed from: protected */
            public List<c> c(int i) {
                return b.this.d;
            }

            /* access modifiers changed from: protected */
            public c n() {
                return new c.a(c.b.SECTION_CENTERED).a("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
            }
        };
        this.c = r0;
        r0.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                com.applovin.impl.mediation.debugger.b.b.b bVar = (com.applovin.impl.mediation.debugger.b.b.b) list.get(aVar.b());
                String h = bVar.h();
                String c2 = mVar.J().c();
                if (!StringUtils.isValidString(h) || !StringUtils.isValidString(c2) || !h.equals(c2)) {
                    mVar.J().a(true);
                    mVar.J().a(h);
                    b.this.getSdk().ag().b(bVar.i());
                } else {
                    mVar.J().a(false);
                    mVar.J().a((String) null);
                    b.this.getSdk().ag().b((String) null);
                }
                b.this.c.notifyDataSetChanged();
            }
        });
        this.c.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.e = listView;
        listView.setAdapter(this.c);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.d = a(this.b);
        this.c.notifyDataSetChanged();
    }
}
