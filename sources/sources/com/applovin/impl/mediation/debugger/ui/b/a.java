package com.applovin.impl.mediation.debugger.ui.b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.sdk.R;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    /* access modifiers changed from: private */
    public b a;
    private DataSetObserver b;
    private FrameLayout c;
    private ListView d;
    private com.applovin.impl.adview.a e;

    private void a() {
        String l = this.a.l();
        if (!TextUtils.isEmpty(l)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", l);
            intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
            intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
            startActivity(Intent.createChooser(intent, (CharSequence) null));
        }
    }

    /* access modifiers changed from: private */
    public void a(final Context context) {
        if (StringUtils.isValidString(this.a.h()) && !this.a.c()) {
            this.a.a(true);
            runOnUiThread(new Runnable() {
                public void run() {
                    Utils.showAlert(a.this.a.g(), a.this.a.h(), context);
                }
            });
        }
    }

    private void b() {
        c();
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(this, 50, 16842874);
        this.e = aVar;
        aVar.setColor(-3355444);
        this.c.addView(this.e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.c.bringChildToFront(this.e);
        this.e.a();
    }

    /* access modifiers changed from: private */
    public void c() {
        com.applovin.impl.adview.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.c.removeView(this.e);
            this.e = null;
        }
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.c = (FrameLayout) findViewById(16908290);
        this.d = (ListView) findViewById(R.id.listView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.a;
        if (bVar != null) {
            bVar.unregisterDataSetObserver(this.b);
            this.a.a((d.a) null);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        a();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.d.setAdapter(this.a);
        b bVar = this.a;
        if (bVar != null && !bVar.a()) {
            b();
        }
    }

    public void setListAdapter(b bVar, final com.applovin.impl.sdk.a aVar) {
        DataSetObserver dataSetObserver;
        b bVar2 = this.a;
        if (!(bVar2 == null || (dataSetObserver = this.b) == null)) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.a = bVar;
        this.b = new DataSetObserver() {
            public void onChanged() {
                a.this.c();
                a aVar = a.this;
                aVar.a((Context) aVar);
            }
        };
        a((Context) this);
        this.a.registerDataSetObserver(this.b);
        this.a.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, final c cVar) {
                int a2 = aVar.a();
                if (a2 == b.C0018b.MAX.ordinal()) {
                    Utils.showAlert(cVar.l(), cVar.m(), a.this);
                } else if (a2 == b.C0018b.ADS.ordinal()) {
                    if (aVar.b() != b.a.AD_UNITS.ordinal()) {
                        if (aVar.b() == b.a.SELECT_LIVE_NETWORKS.ordinal()) {
                            if (a.this.a.i().size() > 0 || a.this.a.j().size() > 0) {
                                if (!a.this.a.d().J().a()) {
                                    a.this.startActivity(MaxDebuggerTestLiveNetworkActivity.class, aVar, new a.C0016a<MaxDebuggerTestLiveNetworkActivity>() {
                                        public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                            maxDebuggerTestLiveNetworkActivity.initialize(a.this.a.i(), a.this.a.j(), a.this.a.d());
                                        }
                                    });
                                    return;
                                }
                                Utils.showAlert("Restart Required", cVar.m(), a.this);
                                return;
                            }
                        } else if (aVar.b() == b.a.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                            if (!a.this.a.d().J().a()) {
                                a.this.getSdk().J().d();
                                Utils.showAlert("Restart Required", cVar.m(), a.this);
                                return;
                            } else if (a.this.a.k().size() > 0) {
                                a.this.startActivity(MaxDebuggerTestModeNetworkActivity.class, aVar, new a.C0016a<MaxDebuggerTestModeNetworkActivity>() {
                                    public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                                        maxDebuggerTestModeNetworkActivity.initialize(a.this.a.k(), a.this.a.d());
                                    }
                                });
                                return;
                            }
                        } else if (aVar.b() == b.a.INITIALIZATION_AD_UNITS.ordinal()) {
                            a.this.startActivity(MaxDebuggerAdUnitsListActivity.class, aVar, new a.C0016a<MaxDebuggerAdUnitsListActivity>() {
                                public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                    maxDebuggerAdUnitsListActivity.initialize(a.this.a.f(), true, a.this.a.d());
                                }
                            });
                            return;
                        } else {
                            return;
                        }
                        Utils.showAlert("Complete Integrations", "Please complete integrations in order to access this.", a.this);
                    } else if (a.this.a.e().size() > 0) {
                        a.this.startActivity(MaxDebuggerAdUnitsListActivity.class, aVar, new a.C0016a<MaxDebuggerAdUnitsListActivity>() {
                            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                maxDebuggerAdUnitsListActivity.initialize(a.this.a.e(), false, a.this.a.d());
                            }
                        });
                    } else {
                        Utils.showAlert("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", a.this);
                    }
                } else if ((a2 == b.C0018b.INCOMPLETE_NETWORKS.ordinal() || a2 == b.C0018b.COMPLETED_NETWORKS.ordinal()) && (cVar instanceof com.applovin.impl.mediation.debugger.ui.b.a.a)) {
                    a.this.startActivity(MaxDebuggerDetailActivity.class, aVar, new a.C0016a<MaxDebuggerDetailActivity>() {
                        public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                            maxDebuggerDetailActivity.initialize(((com.applovin.impl.mediation.debugger.ui.b.a.a) cVar).d());
                        }
                    });
                }
            }
        });
    }
}
