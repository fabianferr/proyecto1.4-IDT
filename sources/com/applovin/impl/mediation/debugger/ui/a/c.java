package com.applovin.impl.mediation.debugger.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.b.a.b;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class c extends a {
    private List<com.applovin.impl.mediation.debugger.b.a.a> a;
    private m b;
    private d c;
    /* access modifiers changed from: private */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> d;
    private boolean e;
    private ListView f;

    private List<com.applovin.impl.mediation.debugger.ui.d.c> a(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.a.a next : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.a(), ViewCompat.MEASURED_STATE_MASK));
            spannableStringBuilder.append(new SpannedString("\n"));
            spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.c(), ViewCompat.MEASURED_STATE_MASK));
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL).a(StringUtils.createSpannedString(next.b(), ViewCompat.MEASURED_STATE_MASK, 18, 1)).b(new SpannedString(spannableStringBuilder)).a((Context) this).a(true).a());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.b;
    }

    public void initialize(final List<com.applovin.impl.mediation.debugger.b.a.a> list, boolean z, final m mVar) {
        this.a = list;
        this.e = z;
        this.b = mVar;
        this.d = a(list);
        AnonymousClass1 r3 = new d(this) {
            /* access modifiers changed from: protected */
            public int a(int i) {
                return list.size();
            }

            /* access modifiers changed from: protected */
            public int b() {
                return 1;
            }

            /* access modifiers changed from: protected */
            public com.applovin.impl.mediation.debugger.ui.d.c b(int i) {
                return new e("");
            }

            /* access modifiers changed from: protected */
            public List<com.applovin.impl.mediation.debugger.ui.d.c> c(int i) {
                return c.this.d;
            }
        };
        this.c = r3;
        r3.a((d.a) new d.a() {
            public void a(final com.applovin.impl.mediation.debugger.ui.d.a aVar, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
                c.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, mVar.af(), new a.C0016a<MaxDebuggerAdUnitDetailActivity>() {
                    public void a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                        maxDebuggerAdUnitDetailActivity.initialize((com.applovin.impl.mediation.debugger.b.a.a) list.get(aVar.b()), (b) null, mVar);
                    }
                });
            }
        });
        this.c.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle((this.e ? "Selective Init " : "").concat("Ad Units"));
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f = listView;
        listView.setAdapter(this.c);
    }
}
