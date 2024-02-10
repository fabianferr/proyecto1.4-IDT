package com.applovin.impl.mediation.debugger.ui.c;

import android.os.Bundle;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.c.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    /* access modifiers changed from: private */
    public b a;
    private ListView b;

    public a() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a().x();
        }
        return null;
    }

    public void initialize(final b bVar) {
        setTitle(bVar.i());
        b bVar2 = new b(bVar, this);
        this.a = bVar2;
        bVar2.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                if (aVar.a() == b.a.TEST_ADS.ordinal()) {
                    m x = bVar.x();
                    b.C0015b c = bVar.c();
                    if (a.this.a.a(aVar)) {
                        if (b.C0015b.READY == c) {
                            a.this.startActivity(MaxDebuggerMultiAdActivity.class, x.af(), new a.C0016a<MaxDebuggerMultiAdActivity>() {
                                public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                    maxDebuggerMultiAdActivity.initialize(bVar);
                                }
                            });
                            return;
                        } else if (b.C0015b.DISABLED == c) {
                            x.J().d();
                        }
                    }
                }
                Utils.showAlert(cVar.l(), cVar.m(), a.this);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.b = listView;
        listView.setAdapter(this.a);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.a.a().m().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.a.c();
            this.a.m();
        }
    }
}
